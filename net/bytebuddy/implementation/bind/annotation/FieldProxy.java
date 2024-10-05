/*      */ package net.bytebuddy.implementation.bind.annotation;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.lang.annotation.Documented;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ import java.lang.annotation.Target;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.Collections;
/*      */ import net.bytebuddy.ByteBuddy;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.DynamicType;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*      */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*      */ import net.bytebuddy.implementation.ExceptionMethod;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*      */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*      */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.Duplication;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.RandomString;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Documented
/*      */ @Retention(RetentionPolicy.RUNTIME)
/*      */ @Target({ElementType.PARAMETER})
/*      */ public @interface FieldProxy
/*      */ {
/*      */   boolean serializableProxy() default false;
/*      */   
/*      */   String value() default "";
/*      */   
/*      */   Class<?> declaringType() default void.class;
/*      */   
/*      */   @Enhance
/*      */   public static class Binder
/*      */     extends TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFieldBinding<FieldProxy>
/*      */   {
/*      */     private static final MethodDescription.InDefinedShape DECLARING_TYPE;
/*      */     private static final MethodDescription.InDefinedShape FIELD_NAME;
/*      */     private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;
/*      */     private final FieldResolver.Factory fieldResolverFactory;
/*      */     
/*      */     static {
/*      */       MethodList methodList;
/*  120 */       DECLARING_TYPE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(FieldProxy.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("declaringType"))).getOnly();
/*  121 */       FIELD_NAME = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/*  122 */       SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("serializableProxy"))).getOnly();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(Class<?> param1Class) {
/*  134 */       return install(TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(TypeDescription param1TypeDescription) {
/*  146 */       if (!param1TypeDescription.isInterface())
/*  147 */         throw new IllegalArgumentException(param1TypeDescription + " is not an interface"); 
/*  148 */       if (!param1TypeDescription.getInterfaces().isEmpty())
/*  149 */         throw new IllegalArgumentException(param1TypeDescription + " must not extend other interfaces"); 
/*  150 */       if (!param1TypeDescription.isPublic()) {
/*  151 */         throw new IllegalArgumentException(param1TypeDescription + " is not public");
/*      */       }
/*      */       MethodList methodList1;
/*  154 */       if ((methodList1 = (MethodList)param1TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isAbstract())).size() != 2) {
/*  155 */         throw new IllegalArgumentException(param1TypeDescription + " does not declare exactly two non-abstract methods");
/*      */       }
/*      */       MethodList methodList2;
/*  158 */       if ((methodList2 = (MethodList)methodList1.filter((ElementMatcher)ElementMatchers.isGetter(Object.class))).size() != 1) {
/*  159 */         throw new IllegalArgumentException(param1TypeDescription + " does not declare a getter with an Object type");
/*      */       }
/*      */       
/*  162 */       if ((methodList1 = (MethodList)methodList1.filter((ElementMatcher)ElementMatchers.isSetter(Object.class))).size() != 1) {
/*  163 */         throw new IllegalArgumentException(param1TypeDescription + " does not declare a setter with an Object type");
/*      */       }
/*  165 */       return new Binder(param1TypeDescription, (MethodDescription.InDefinedShape)methodList2.getOnly(), (MethodDescription.InDefinedShape)methodList1.getOnly());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(Class<?> param1Class1, Class<?> param1Class2) {
/*  184 */       return install(TypeDescription.ForLoadedType.of(param1Class1), TypeDescription.ForLoadedType.of(param1Class2));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/*      */       MethodDescription.InDefinedShape inDefinedShape1;
/*  204 */       if (!(inDefinedShape1 = onlyMethod(param1TypeDescription1)).getReturnType().asErasure().represents(Object.class))
/*  205 */         throw new IllegalArgumentException(inDefinedShape1 + " must take a single Object-typed parameter"); 
/*  206 */       if (inDefinedShape1.getParameters().size() != 0) {
/*  207 */         throw new IllegalArgumentException(inDefinedShape1 + " must not declare parameters");
/*      */       }
/*      */       MethodDescription.InDefinedShape inDefinedShape2;
/*  210 */       if (!(inDefinedShape2 = onlyMethod(param1TypeDescription2)).getReturnType().asErasure().represents(void.class))
/*  211 */         throw new IllegalArgumentException(inDefinedShape2 + " must return void"); 
/*  212 */       if (inDefinedShape2.getParameters().size() != 1 || !((ParameterDescription.InDefinedShape)inDefinedShape2.getParameters().get(0)).getType().asErasure().represents(Object.class)) {
/*  213 */         throw new IllegalArgumentException(inDefinedShape2 + " must declare a single Object-typed parameters");
/*      */       }
/*  215 */       return new Binder(inDefinedShape1, inDefinedShape2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static MethodDescription.InDefinedShape onlyMethod(TypeDescription param1TypeDescription) {
/*  226 */       if (!param1TypeDescription.isInterface())
/*  227 */         throw new IllegalArgumentException(param1TypeDescription + " is not an interface"); 
/*  228 */       if (!param1TypeDescription.getInterfaces().isEmpty())
/*  229 */         throw new IllegalArgumentException(param1TypeDescription + " must not extend other interfaces"); 
/*  230 */       if (!param1TypeDescription.isPublic()) {
/*  231 */         throw new IllegalArgumentException(param1TypeDescription + " is not public");
/*      */       }
/*      */       MethodList methodList;
/*  234 */       if ((methodList = (MethodList)param1TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isAbstract())).size() != 1) {
/*  235 */         throw new IllegalArgumentException(param1TypeDescription + " must declare exactly one abstract method");
/*      */       }
/*  237 */       return (MethodDescription.InDefinedShape)methodList.getOnly();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Binder(MethodDescription.InDefinedShape param1InDefinedShape1, MethodDescription.InDefinedShape param1InDefinedShape2) {
/*  252 */       this(new FieldResolver.Factory.Simplex(param1InDefinedShape1, param1InDefinedShape2));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Binder(TypeDescription param1TypeDescription, MethodDescription.InDefinedShape param1InDefinedShape1, MethodDescription.InDefinedShape param1InDefinedShape2) {
/*  263 */       this(new FieldResolver.Factory.Duplex(param1TypeDescription, param1InDefinedShape1, param1InDefinedShape2));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Binder(FieldResolver.Factory param1Factory) {
/*  272 */       this.fieldResolverFactory = param1Factory;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Class<FieldProxy> getHandledType() {
/*  279 */       return FieldProxy.class;
/*      */     }
/*      */ 
/*      */     
/*      */     protected String fieldName(AnnotationDescription.Loadable<FieldProxy> param1Loadable) {
/*  284 */       return (String)param1Loadable.getValue(FIELD_NAME).resolve(String.class);
/*      */     }
/*      */ 
/*      */     
/*      */     protected TypeDescription declaringType(AnnotationDescription.Loadable<FieldProxy> param1Loadable) {
/*  289 */       return (TypeDescription)param1Loadable.getValue(DECLARING_TYPE).resolve(TypeDescription.class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected MethodDelegationBinder.ParameterBinding<?> bind(FieldDescription param1FieldDescription, AnnotationDescription.Loadable<FieldProxy> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner) {
/*      */       FieldResolver fieldResolver;
/*  300 */       if ((fieldResolver = this.fieldResolverFactory.resolve(param1ParameterDescription.getType().asErasure(), param1FieldDescription)).isResolved()) {
/*  301 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new AccessorProxy(param1FieldDescription, param1Target
/*  302 */               .getInstrumentedType(), fieldResolver, param1Assigner, ((Boolean)param1Loadable
/*      */ 
/*      */               
/*  305 */               .getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue()));
/*      */       }
/*  307 */       return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.fieldResolverFactory.equals(((Binder)param1Object).fieldResolverFactory))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.fieldResolverFactory.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Duplex
/*      */       implements FieldResolver.Factory
/*      */     {
/*      */       private final TypeDescription proxyType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodDescription.InDefinedShape getterMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodDescription.InDefinedShape setterMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Duplex(TypeDescription param2TypeDescription, MethodDescription.InDefinedShape param2InDefinedShape1, MethodDescription.InDefinedShape param2InDefinedShape2) {
/*  389 */         this.proxyType = param2TypeDescription;
/*  390 */         this.getterMethod = param2InDefinedShape1;
/*  391 */         this.setterMethod = param2InDefinedShape2;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FieldProxy.Binder.FieldResolver resolve(TypeDescription param2TypeDescription, FieldDescription param2FieldDescription) {
/*  398 */         if (param2TypeDescription.equals(this.proxyType)) {
/*  399 */           return new FieldProxy.Binder.FieldResolver.ForGetterSetterPair(this.proxyType, this.getterMethod, this.setterMethod);
/*      */         }
/*  401 */         throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.proxyType.equals(((Duplex)param2Object).proxyType) ? false : (!this.getterMethod.equals(((Duplex)param2Object).getterMethod) ? false : (!!this.setterMethod.equals(((Duplex)param2Object).setterMethod))))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.proxyType.hashCode()) * 31 + this.getterMethod.hashCode()) * 31 + this.setterMethod.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Simplex
/*      */       implements FieldResolver.Factory
/*      */     {
/*      */       private final MethodDescription.InDefinedShape getterMethod;
/*      */       
/*      */       private final MethodDescription.InDefinedShape setterMethod;
/*      */ 
/*      */       
/*      */       protected Simplex(MethodDescription.InDefinedShape param2InDefinedShape1, MethodDescription.InDefinedShape param2InDefinedShape2) {
/*  429 */         this.getterMethod = param2InDefinedShape1;
/*  430 */         this.setterMethod = param2InDefinedShape2;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public FieldProxy.Binder.FieldResolver resolve(TypeDescription param2TypeDescription, FieldDescription param2FieldDescription)
/*      */       {
/*  437 */         if (param2TypeDescription.equals(this.getterMethod.getDeclaringType()))
/*  438 */           return new FieldProxy.Binder.FieldResolver.ForGetter(this.getterMethod); 
/*  439 */         if (param2TypeDescription.equals(this.setterMethod.getDeclaringType())) {
/*  440 */           return (FieldProxy.Binder.FieldResolver)(param2FieldDescription.isFinal() ? FieldProxy.Binder.FieldResolver.Unresolved.INSTANCE : new FieldProxy.Binder.FieldResolver.ForSetter(this.setterMethod));
/*      */         }
/*      */ 
/*      */         
/*  444 */         throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type"); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.getterMethod.equals(((Simplex)param2Object).getterMethod) ? false : (!!this.setterMethod.equals(((Simplex)param2Object).setterMethod))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.getterMethod.hashCode()) * 31 + this.setterMethod.hashCode(); } } public static interface Factory { FieldProxy.Binder.FieldResolver resolve(TypeDescription param2TypeDescription, FieldDescription param2FieldDescription); @Enhance public static class Duplex implements Factory { private final TypeDescription proxyType; private final MethodDescription.InDefinedShape getterMethod; private final MethodDescription.InDefinedShape setterMethod; protected Duplex(TypeDescription param4TypeDescription, MethodDescription.InDefinedShape param4InDefinedShape1, MethodDescription.InDefinedShape param4InDefinedShape2) { this.proxyType = param4TypeDescription; this.getterMethod = param4InDefinedShape1; this.setterMethod = param4InDefinedShape2; } public FieldProxy.Binder.FieldResolver resolve(TypeDescription param4TypeDescription, FieldDescription param4FieldDescription) { if (param4TypeDescription.equals(this.proxyType)) return new FieldProxy.Binder.FieldResolver.ForGetterSetterPair(this.proxyType, this.getterMethod, this.setterMethod);  throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type"); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.proxyType.equals(((Duplex)param4Object).proxyType) ? false : (!this.getterMethod.equals(((Duplex)param4Object).getterMethod) ? false : (!!this.setterMethod.equals(((Duplex)param4Object).setterMethod)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.proxyType.hashCode()) * 31 + this.getterMethod.hashCode()) * 31 + this.setterMethod.hashCode(); } } @Enhance public static class Simplex implements Factory { private final MethodDescription.InDefinedShape getterMethod; private final MethodDescription.InDefinedShape setterMethod; protected Simplex(MethodDescription.InDefinedShape param4InDefinedShape1, MethodDescription.InDefinedShape param4InDefinedShape2) { this.getterMethod = param4InDefinedShape1; this.setterMethod = param4InDefinedShape2; } public FieldProxy.Binder.FieldResolver resolve(TypeDescription param4TypeDescription, FieldDescription param4FieldDescription) { if (param4TypeDescription.equals(this.getterMethod.getDeclaringType())) return new FieldProxy.Binder.FieldResolver.ForGetter(this.getterMethod);  if (param4TypeDescription.equals(this.setterMethod.getDeclaringType())) return (FieldProxy.Binder.FieldResolver)(param4FieldDescription.isFinal() ? FieldProxy.Binder.FieldResolver.Unresolved.INSTANCE : new FieldProxy.Binder.FieldResolver.ForSetter(this.setterMethod));  throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type"); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.getterMethod.equals(((Simplex)param4Object).getterMethod) ? false : (!!this.setterMethod.equals(((Simplex)param4Object).setterMethod))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.getterMethod.hashCode()) * 31 + this.setterMethod.hashCode(); } } } protected static interface FieldResolver { boolean isResolved(); TypeDescription getProxyType(); DynamicType.Builder<?> apply(DynamicType.Builder<?> param2Builder, FieldDescription param2FieldDescription, Assigner param2Assigner, MethodAccessorFactory param2MethodAccessorFactory); public static interface Factory { FieldProxy.Binder.FieldResolver resolve(TypeDescription param3TypeDescription, FieldDescription param3FieldDescription); @Enhance public static class Duplex implements Factory { private final TypeDescription proxyType; private final MethodDescription.InDefinedShape getterMethod; private final MethodDescription.InDefinedShape setterMethod; protected Duplex(TypeDescription param4TypeDescription, MethodDescription.InDefinedShape param4InDefinedShape1, MethodDescription.InDefinedShape param4InDefinedShape2) { this.proxyType = param4TypeDescription; this.getterMethod = param4InDefinedShape1; this.setterMethod = param4InDefinedShape2; } public FieldProxy.Binder.FieldResolver resolve(TypeDescription param4TypeDescription, FieldDescription param4FieldDescription) { if (param4TypeDescription.equals(this.proxyType)) return new FieldProxy.Binder.FieldResolver.ForGetterSetterPair(this.proxyType, this.getterMethod, this.setterMethod);  throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type"); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.proxyType.equals(((Duplex)param4Object).proxyType) ? false : (!this.getterMethod.equals(((Duplex)param4Object).getterMethod) ? false : (!!this.setterMethod.equals(((Duplex)param4Object).setterMethod)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.proxyType.hashCode()) * 31 + this.getterMethod.hashCode()) * 31 + this.setterMethod.hashCode(); } } @Enhance public static class Simplex implements Factory { private final MethodDescription.InDefinedShape getterMethod; public FieldProxy.Binder.FieldResolver resolve(TypeDescription param4TypeDescription, FieldDescription param4FieldDescription) { if (param4TypeDescription.equals(this.getterMethod.getDeclaringType())) return new FieldProxy.Binder.FieldResolver.ForGetter(this.getterMethod);  if (param4TypeDescription.equals(this.setterMethod.getDeclaringType())) return (FieldProxy.Binder.FieldResolver)(param4FieldDescription.isFinal() ? FieldProxy.Binder.FieldResolver.Unresolved.INSTANCE : new FieldProxy.Binder.FieldResolver.ForSetter(this.setterMethod));  throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type"); }
/*      */           
/*      */           private final MethodDescription.InDefinedShape setterMethod;
/*      */           protected Simplex(MethodDescription.InDefinedShape param4InDefinedShape1, MethodDescription.InDefinedShape param4InDefinedShape2) {
/*      */             this.getterMethod = param4InDefinedShape1;
/*      */             this.setterMethod = param4InDefinedShape2;
/*      */           }
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.getterMethod.equals(((Simplex)param4Object).getterMethod) ? false : (!!this.setterMethod.equals(((Simplex)param4Object).setterMethod)))));
/*      */           }
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.getterMethod.hashCode()) * 31 + this.setterMethod.hashCode();
/*      */           } } }
/*      */       
/*  458 */       public enum Unresolved implements FieldResolver { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final boolean isResolved() {
/*  464 */           return false;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeDescription getProxyType() {
/*  471 */           throw new IllegalStateException("Cannot read type for unresolved field resolver");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final DynamicType.Builder<?> apply(DynamicType.Builder<?> param3Builder, FieldDescription param3FieldDescription, Assigner param3Assigner, MethodAccessorFactory param3MethodAccessorFactory) {
/*  481 */           throw new IllegalStateException("Cannot apply unresolved field resolver");
/*      */         } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForGetter
/*      */         implements FieldResolver
/*      */       {
/*      */         private final MethodDescription.InDefinedShape getterMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForGetter(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  502 */           this.getterMethod = param3InDefinedShape;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isResolved() {
/*  509 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getProxyType() {
/*  516 */           return this.getterMethod.getDeclaringType();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<?> apply(DynamicType.Builder<?> param3Builder, FieldDescription param3FieldDescription, Assigner param3Assigner, MethodAccessorFactory param3MethodAccessorFactory) {
/*  526 */           return (DynamicType.Builder<?>)param3Builder.method((ElementMatcher)ElementMatchers.definedMethod((ElementMatcher)ElementMatchers.is(this.getterMethod))).intercept(new FieldProxy.Binder.FieldGetter(param3FieldDescription, param3Assigner, param3MethodAccessorFactory));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.getterMethod.equals(((ForGetter)param3Object).getterMethod))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.getterMethod.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class ForSetter
/*      */         implements FieldResolver
/*      */       {
/*      */         private final MethodDescription.InDefinedShape setterMethod;
/*      */         
/*      */         protected ForSetter(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  547 */           this.setterMethod = param3InDefinedShape;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isResolved() {
/*  554 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getProxyType() {
/*  561 */           return this.setterMethod.getDeclaringType();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<?> apply(DynamicType.Builder<?> param3Builder, FieldDescription param3FieldDescription, Assigner param3Assigner, MethodAccessorFactory param3MethodAccessorFactory) {
/*  571 */           return (DynamicType.Builder<?>)param3Builder.method((ElementMatcher)ElementMatchers.is(this.setterMethod)).intercept(new FieldProxy.Binder.FieldSetter(param3FieldDescription, param3Assigner, param3MethodAccessorFactory));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.setterMethod.equals(((ForSetter)param3Object).setterMethod))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.setterMethod.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForGetterSetterPair
/*      */         implements FieldResolver
/*      */       {
/*      */         private final TypeDescription proxyType;
/*      */ 
/*      */         
/*      */         private final MethodDescription.InDefinedShape getterMethod;
/*      */ 
/*      */         
/*      */         private final MethodDescription.InDefinedShape setterMethod;
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForGetterSetterPair(TypeDescription param3TypeDescription, MethodDescription.InDefinedShape param3InDefinedShape1, MethodDescription.InDefinedShape param3InDefinedShape2) {
/*  606 */           this.proxyType = param3TypeDescription;
/*  607 */           this.getterMethod = param3InDefinedShape1;
/*  608 */           this.setterMethod = param3InDefinedShape2;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isResolved() {
/*  615 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getProxyType() {
/*  622 */           return this.proxyType;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<?> apply(DynamicType.Builder<?> param3Builder, FieldDescription param3FieldDescription, Assigner param3Assigner, MethodAccessorFactory param3MethodAccessorFactory) {
/*  632 */           return (DynamicType.Builder<?>)param3Builder
/*  633 */             .method((ElementMatcher)ElementMatchers.is(this.getterMethod)).intercept(new FieldProxy.Binder.FieldGetter(param3FieldDescription, param3Assigner, param3MethodAccessorFactory))
/*  634 */             .method((ElementMatcher)ElementMatchers.is(this.setterMethod)).intercept(param3FieldDescription.isFinal() ? 
/*  635 */               ExceptionMethod.throwing(UnsupportedOperationException.class, "Cannot set final field " + param3FieldDescription) : new FieldProxy.Binder.FieldSetter(param3FieldDescription, param3Assigner, param3MethodAccessorFactory));
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.proxyType.equals(((ForGetterSetterPair)param3Object).proxyType) ? false : (!this.getterMethod.equals(((ForGetterSetterPair)param3Object).getterMethod) ? false : (!!this.setterMethod.equals(((ForGetterSetterPair)param3Object).setterMethod))))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return ((getClass().hashCode() * 31 + this.proxyType.hashCode()) * 31 + this.getterMethod.hashCode()) * 31 + this.setterMethod.hashCode();
/*      */         }
/*      */       } }
/*      */ 
/*      */     
/*      */     protected enum StaticFieldConstructor implements Implementation {
/*  649 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodDescription objectTypeDefaultConstructor;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       StaticFieldConstructor() {
/*  660 */         this.objectTypeDefaultConstructor = (MethodDescription)((MethodList)TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  667 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final ByteCodeAppender appender(Implementation.Target param2Target) {
/*  674 */         return (ByteCodeAppender)new ByteCodeAppender.Simple(new StackManipulation[] { MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(this.objectTypeDefaultConstructor), (StackManipulation)MethodReturn.VOID });
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class InstanceFieldConstructor
/*      */       implements Implementation
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected InstanceFieldConstructor(TypeDescription param2TypeDescription) {
/*  696 */         this.instrumentedType = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  703 */         return param2InstrumentedType.withField(new FieldDescription.Token("instance", 18, this.instrumentedType
/*      */               
/*  705 */               .asGenericType()));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender appender(Implementation.Target param2Target) {
/*  712 */         return new Appender(param2Target);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((InstanceFieldConstructor)param2Object).instrumentedType))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Appender
/*      */         implements ByteCodeAppender
/*      */       {
/*      */         private final FieldDescription fieldDescription;
/*      */         
/*      */         protected Appender(Implementation.Target param3Target) {
/*  733 */           this
/*      */ 
/*      */             
/*  736 */             .fieldDescription = (FieldDescription)((FieldList)param3Target.getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("instance"))).getOnly();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, MethodDescription param3MethodDescription) {
/*  751 */           StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(FieldProxy.Binder.StaticFieldConstructor.a(FieldProxy.Binder.StaticFieldConstructor.INSTANCE)), MethodVariableAccess.allArgumentsOf((MethodDescription)param3MethodDescription.asDefined()).prependThisReference(), FieldAccess.forField(this.fieldDescription).write(), (StackManipulation)MethodReturn.VOID })).apply(param3MethodVisitor, param3Context);
/*  752 */           return new ByteCodeAppender.Size(size.getMaximalSize(), param3MethodDescription.getStackSize());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((Appender)param3Object).fieldDescription))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class FieldGetter
/*      */       implements Implementation
/*      */     {
/*      */       private final FieldDescription fieldDescription;
/*      */ 
/*      */       
/*      */       private final Assigner assigner;
/*      */ 
/*      */       
/*      */       private final MethodAccessorFactory methodAccessorFactory;
/*      */ 
/*      */ 
/*      */       
/*      */       protected FieldGetter(FieldDescription param2FieldDescription, Assigner param2Assigner, MethodAccessorFactory param2MethodAccessorFactory) {
/*  788 */         this.fieldDescription = param2FieldDescription;
/*  789 */         this.assigner = param2Assigner;
/*  790 */         this.methodAccessorFactory = param2MethodAccessorFactory;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  797 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender appender(Implementation.Target param2Target) {
/*  804 */         return new Appender(this, param2Target);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldDescription.equals(((FieldGetter)param2Object).fieldDescription) ? false : (!this.assigner.equals(((FieldGetter)param2Object).assigner) ? false : (!!this.methodAccessorFactory.equals(((FieldGetter)param2Object).methodAccessorFactory))))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.methodAccessorFactory.hashCode();
/*      */       }
/*      */       
/*      */       @Enhance(includeSyntheticFields = true)
/*      */       protected class Appender
/*      */         implements ByteCodeAppender
/*      */       {
/*      */         private final TypeDescription typeDescription;
/*      */         
/*      */         protected Appender(FieldProxy.Binder.FieldGetter this$0, Implementation.Target param3Target) {
/*  824 */           this.typeDescription = param3Target.getInstrumentedType();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, MethodDescription param3MethodDescription) {
/*  833 */           MethodDescription.InDefinedShape inDefinedShape = FieldProxy.Binder.FieldGetter.b(this.a).registerGetterFor(FieldProxy.Binder.FieldGetter.a(this.a), MethodAccessorFactory.AccessType.DEFAULT);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  843 */           StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { FieldProxy.Binder.FieldGetter.a(this.a).isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)this.typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("instance"))).getOnly()).read() }), (StackManipulation)MethodInvocation.invoke((MethodDescription)inDefinedShape), FieldProxy.Binder.FieldGetter.c(this.a).assign(inDefinedShape.getReturnType(), param3MethodDescription.getReturnType(), Assigner.Typing.DYNAMIC), MethodReturn.of((TypeDefinition)param3MethodDescription.getReturnType().asErasure()) })).apply(param3MethodVisitor, param3Context);
/*  844 */           return new ByteCodeAppender.Size(size.getMaximalSize(), param3MethodDescription.getStackSize());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typeDescription.equals(((Appender)param3Object).typeDescription) ? false : (!!this.a.equals(((Appender)param3Object).a)))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.a.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class FieldSetter
/*      */       implements Implementation
/*      */     {
/*      */       private final FieldDescription fieldDescription;
/*      */ 
/*      */       
/*      */       private final Assigner assigner;
/*      */ 
/*      */       
/*      */       private final MethodAccessorFactory methodAccessorFactory;
/*      */ 
/*      */ 
/*      */       
/*      */       protected FieldSetter(FieldDescription param2FieldDescription, Assigner param2Assigner, MethodAccessorFactory param2MethodAccessorFactory) {
/*  880 */         this.fieldDescription = param2FieldDescription;
/*  881 */         this.assigner = param2Assigner;
/*  882 */         this.methodAccessorFactory = param2MethodAccessorFactory;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  889 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender appender(Implementation.Target param2Target) {
/*  896 */         return new Appender(this, param2Target);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldDescription.equals(((FieldSetter)param2Object).fieldDescription) ? false : (!this.assigner.equals(((FieldSetter)param2Object).assigner) ? false : (!!this.methodAccessorFactory.equals(((FieldSetter)param2Object).methodAccessorFactory))))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.methodAccessorFactory.hashCode();
/*      */       }
/*      */       
/*      */       @Enhance(includeSyntheticFields = true)
/*      */       protected class Appender
/*      */         implements ByteCodeAppender
/*      */       {
/*      */         private final TypeDescription typeDescription;
/*      */         
/*      */         protected Appender(FieldProxy.Binder.FieldSetter this$0, Implementation.Target param3Target) {
/*  916 */           this.typeDescription = param3Target.getInstrumentedType();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, MethodDescription param3MethodDescription) {
/*  925 */           TypeDescription.Generic generic = ((ParameterDescription)param3MethodDescription.getParameters().get(0)).getType();
/*  926 */           MethodDescription.InDefinedShape inDefinedShape = FieldProxy.Binder.FieldSetter.b(this.a).registerSetterFor(FieldProxy.Binder.FieldSetter.a(this.a), MethodAccessorFactory.AccessType.DEFAULT);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  938 */           StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { FieldProxy.Binder.FieldSetter.a(this.a).isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)this.typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("instance"))).getOnly()).read() }), MethodVariableAccess.of((TypeDefinition)generic).loadFrom(1), FieldProxy.Binder.FieldSetter.c(this.a).assign(generic, ((ParameterDescription)inDefinedShape.getParameters().get(0)).getType(), Assigner.Typing.DYNAMIC), (StackManipulation)MethodInvocation.invoke((MethodDescription)inDefinedShape), (StackManipulation)MethodReturn.VOID })).apply(param3MethodVisitor, param3Context);
/*  939 */           return new ByteCodeAppender.Size(size.getMaximalSize(), param3MethodDescription.getStackSize());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typeDescription.equals(((Appender)param3Object).typeDescription) ? false : (!!this.a.equals(((Appender)param3Object).a)))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.a.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance(includeSyntheticFields = true)
/*      */     protected static class AccessorProxy
/*      */       extends StackManipulation.AbstractBase
/*      */       implements AuxiliaryType
/*      */     {
/*      */       protected static final String FIELD_NAME = "instance";
/*      */ 
/*      */ 
/*      */       
/*      */       private final FieldDescription fieldDescription;
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */       
/*      */       private final FieldProxy.Binder.FieldResolver fieldResolver;
/*      */ 
/*      */ 
/*      */       
/*      */       private final Assigner assigner;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean serializableProxy;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected AccessorProxy(FieldDescription param2FieldDescription, TypeDescription param2TypeDescription, FieldProxy.Binder.FieldResolver param2FieldResolver, Assigner param2Assigner, boolean param2Boolean) {
/*  992 */         this.fieldDescription = param2FieldDescription;
/*  993 */         this.instrumentedType = param2TypeDescription;
/*  994 */         this.fieldResolver = param2FieldResolver;
/*  995 */         this.assigner = param2Assigner;
/*  996 */         this.serializableProxy = param2Boolean;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getSuffix() {
/* 1003 */         return RandomString.hashOf(this.fieldDescription.hashCode()) + (this.serializableProxy ? "S" : "0");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType make(String param2String, ClassFileVersion param2ClassFileVersion, MethodAccessorFactory param2MethodAccessorFactory) {
/* 1016 */         (new Class[1])[0] = Serializable.class; return (DynamicType)this.fieldResolver.apply((DynamicType.Builder<?>)(new ByteBuddy(param2ClassFileVersion)).with(TypeValidation.DISABLED).subclass((TypeDefinition)this.fieldResolver.getProxyType(), (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).name(param2String).modifiers(DEFAULT_TYPE_MODIFIER)
/* 1017 */             .implement(this.serializableProxy ? (Type[])new Class[1] : (Type[])new Class[0])
/* 1018 */             .defineConstructor(new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[0]).withParameters(this.fieldDescription.isStatic() ? 
/* 1019 */               Collections.emptyList() : 
/* 1020 */               Collections.<TypeDescription>singletonList(this.instrumentedType))
/* 1021 */             .intercept(this.fieldDescription.isStatic() ? FieldProxy.Binder.StaticFieldConstructor.INSTANCE : new FieldProxy.Binder.InstanceFieldConstructor(this.instrumentedType)), this.fieldDescription, this.assigner, param2MethodAccessorFactory)
/*      */           
/* 1023 */           .make();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 1030 */         TypeDescription typeDescription = param2Context.register(this);
/* 1031 */         return (new StackManipulation.Compound(new StackManipulation[] {
/* 1032 */               TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, 
/*      */               
/* 1034 */               this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*      */               
/* 1036 */               MethodVariableAccess.loadThis(), 
/* 1037 */               (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly())
/* 1038 */             })).apply(param2MethodVisitor, param2Context);
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.serializableProxy != ((AccessorProxy)param2Object).serializableProxy) ? false : (!this.fieldDescription.equals(((AccessorProxy)param2Object).fieldDescription) ? false : (!this.instrumentedType.equals(((AccessorProxy)param2Object).instrumentedType) ? false : (!this.fieldResolver.equals(((AccessorProxy)param2Object).fieldResolver) ? false : (!!this.assigner.equals(((AccessorProxy)param2Object).assigner))))))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return ((((getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.instrumentedType.hashCode()) * 31 + this.fieldResolver.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.serializableProxy;
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\FieldProxy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */