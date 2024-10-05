/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Collections;
/*     */ import net.bytebuddy.ByteBuddy;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*     */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.RandomString;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.PARAMETER})
/*     */ public @interface Morph
/*     */ {
/*     */   boolean serializableProxy() default false;
/*     */   
/*     */   boolean defaultMethod() default false;
/*     */   
/*     */   Class<?> defaultTarget() default void.class;
/*     */   
/*     */   @Enhance
/*     */   public static class Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Morph>
/*     */   {
/*     */     private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;
/*     */     private static final MethodDescription.InDefinedShape DEFAULT_METHOD;
/*     */     private static final MethodDescription.InDefinedShape DEFAULT_TARGET;
/*     */     private final MethodDescription forwardingMethod;
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 124 */       SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Morph.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("serializableProxy"))).getOnly();
/* 125 */       DEFAULT_METHOD = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("defaultMethod"))).getOnly();
/* 126 */       DEFAULT_TARGET = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("defaultTarget"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Binder(MethodDescription param1MethodDescription) {
/* 140 */       this.forwardingMethod = param1MethodDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Morph> install(Class<?> param1Class) {
/* 154 */       return install(TypeDescription.ForLoadedType.of(param1Class));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Morph> install(TypeDescription param1TypeDescription) {
/* 168 */       return new Binder(onlyMethod(param1TypeDescription));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static MethodDescription onlyMethod(TypeDescription param1TypeDescription) {
/* 178 */       if (!param1TypeDescription.isInterface())
/* 179 */         throw new IllegalArgumentException(param1TypeDescription + " is not an interface"); 
/* 180 */       if (!param1TypeDescription.getInterfaces().isEmpty())
/* 181 */         throw new IllegalArgumentException(param1TypeDescription + " must not extend other interfaces"); 
/* 182 */       if (!param1TypeDescription.isPublic()) {
/* 183 */         throw new IllegalArgumentException(param1TypeDescription + " is mot public");
/*     */       }
/*     */       MethodList methodList;
/* 186 */       if ((methodList = (MethodList)param1TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isAbstract())).size() != 1) {
/* 187 */         throw new IllegalArgumentException(param1TypeDescription + " must declare exactly one abstract method");
/*     */       }
/*     */       MethodDescription methodDescription;
/* 190 */       if (!(methodDescription = (MethodDescription)methodList.getOnly()).getReturnType().asErasure().represents(Object.class))
/* 191 */         throw new IllegalArgumentException(methodDescription + " does not return an Object-type"); 
/* 192 */       if (methodDescription.getParameters().size() != 1 || !((ParameterDescription)methodDescription.getParameters().get(0)).getType().asErasure().represents(Object[].class)) {
/* 193 */         throw new IllegalArgumentException(methodDescription + " does not take a single argument of type Object[]");
/*     */       }
/* 195 */       return methodDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<Morph> getHandledType() {
/* 202 */       return Morph.class;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Morph> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*     */       Implementation.SpecialMethodInvocation specialMethodInvocation;
/* 214 */       if (!param1ParameterDescription.getType().asErasure().equals(this.forwardingMethod.getDeclaringType())) {
/* 215 */         throw new IllegalStateException("Illegal use of @Morph for " + param1ParameterDescription + " which was installed for " + this.forwardingMethod.getDeclaringType());
/*     */       }
/*     */       
/*     */       TypeDescription typeDescription;
/* 219 */       if ((typeDescription = (TypeDescription)param1Loadable.getValue(DEFAULT_TARGET).resolve(TypeDescription.class)).represents(void.class) && !((Boolean)param1Loadable.getValue(DEFAULT_METHOD).resolve(Boolean.class)).booleanValue()) {
/* 220 */         specialMethodInvocation = param1Target.invokeSuper(param1MethodDescription.asSignatureToken()).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken());
/*     */       }
/*     */       else {
/*     */         
/* 224 */         specialMethodInvocation = (typeDescription.represents(void.class) ? DefaultMethodLocator.Implicit.INSTANCE : new DefaultMethodLocator.Explicit(typeDescription)).resolve(param1Target, (MethodDescription)specialMethodInvocation);
/*     */       } 
/* 226 */       return (MethodDelegationBinder.ParameterBinding<?>)(specialMethodInvocation.isValid() ? new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new RedirectionProxy(this.forwardingMethod
/* 227 */             .getDeclaringType().asErasure(), param1Target
/* 228 */             .getInstrumentedType(), specialMethodInvocation, param1Assigner, ((Boolean)param1Loadable
/*     */ 
/*     */             
/* 231 */             .getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue())) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.forwardingMethod.equals(((Binder)param1Object).forwardingMethod))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.forwardingMethod.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum Implicit
/*     */       implements DefaultMethodLocator
/*     */     {
/* 260 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription) {
/* 266 */         return param2Target.invokeDefault(param2MethodDescription.asSignatureToken()).withCheckedCompatibilityTo(param2MethodDescription.asTypeToken());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Explicit
/*     */       implements DefaultMethodLocator
/*     */     {
/*     */       private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Explicit(TypeDescription param2TypeDescription) {
/* 288 */         this.typeDescription = param2TypeDescription;
/*     */       }
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((Explicit)param2Object).typeDescription))));
/*     */       } public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */       }
/* 295 */       public Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription) { if (!this.typeDescription.isInterface()) {
/* 296 */           throw new IllegalStateException(param2MethodDescription + " method carries default method call parameter on non-interface type");
/*     */         }
/* 298 */         return param2Target
/* 299 */           .invokeDefault(param2MethodDescription.asSignatureToken(), this.typeDescription)
/* 300 */           .withCheckedCompatibilityTo(param2MethodDescription.asTypeToken()); } } protected static interface DefaultMethodLocator { Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription); public enum Implicit implements DefaultMethodLocator { INSTANCE; public final Implementation.SpecialMethodInvocation resolve(Implementation.Target param3Target, MethodDescription param3MethodDescription) { return param3Target.invokeDefault(param3MethodDescription.asSignatureToken()).withCheckedCompatibilityTo(param3MethodDescription.asTypeToken()); } } @Enhance public static class Explicit implements DefaultMethodLocator { public Implementation.SpecialMethodInvocation resolve(Implementation.Target param3Target, MethodDescription param3MethodDescription) { if (!this.typeDescription.isInterface()) throw new IllegalStateException(param3MethodDescription + " method carries default method call parameter on non-interface type");  return param3Target.invokeDefault(param3MethodDescription.asSignatureToken(), this.typeDescription).withCheckedCompatibilityTo(param3MethodDescription.asTypeToken()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public Explicit(TypeDescription param3TypeDescription) {
/*     */           this.typeDescription = param3TypeDescription;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((Explicit)param3Object).typeDescription))));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */         } }
/*     */        }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class RedirectionProxy
/*     */       extends StackManipulation.AbstractBase
/*     */       implements AuxiliaryType
/*     */     {
/*     */       protected static final String FIELD_NAME = "target";
/*     */ 
/*     */       
/*     */       private final TypeDescription morphingType;
/*     */ 
/*     */       
/*     */       private final TypeDescription instrumentedType;
/*     */ 
/*     */       
/*     */       private final Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */ 
/*     */       
/*     */       private final Assigner assigner;
/*     */ 
/*     */       
/*     */       private final boolean serializableProxy;
/*     */ 
/*     */ 
/*     */       
/*     */       protected RedirectionProxy(TypeDescription param2TypeDescription1, TypeDescription param2TypeDescription2, Implementation.SpecialMethodInvocation param2SpecialMethodInvocation, Assigner param2Assigner, boolean param2Boolean) {
/* 357 */         this.morphingType = param2TypeDescription1;
/* 358 */         this.instrumentedType = param2TypeDescription2;
/* 359 */         this.specialMethodInvocation = param2SpecialMethodInvocation;
/* 360 */         this.assigner = param2Assigner;
/* 361 */         this.serializableProxy = param2Boolean;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getSuffix() {
/* 368 */         return RandomString.hashOf(this.morphingType.hashCode()) + (this.serializableProxy ? "S" : "0");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public DynamicType make(String param2String, ClassFileVersion param2ClassFileVersion, MethodAccessorFactory param2MethodAccessorFactory) {
/* 381 */         (new Class[1])[0] = Serializable.class; return (DynamicType)(new ByteBuddy(param2ClassFileVersion)).with(TypeValidation.DISABLED).subclass((TypeDefinition)this.morphingType, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).name(param2String).modifiers(DEFAULT_TYPE_MODIFIER)
/* 382 */           .implement(this.serializableProxy ? (Type[])new Class[1] : (Type[])new Class[0])
/* 383 */           .defineConstructor(new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[0]).withParameters(this.specialMethodInvocation.getMethodDescription().isStatic() ? 
/* 384 */             Collections.emptyList() : 
/* 385 */             Collections.<TypeDescription>singletonList(this.instrumentedType))
/* 386 */           .intercept(this.specialMethodInvocation.getMethodDescription().isStatic() ? StaticFieldConstructor.INSTANCE : new InstanceFieldConstructor(this.instrumentedType))
/*     */ 
/*     */           
/* 389 */           .method((ElementMatcher)ElementMatchers.isAbstract().and((ElementMatcher)ElementMatchers.isDeclaredBy(this.morphingType)))
/* 390 */           .intercept(new MethodCall((MethodDescription)param2MethodAccessorFactory.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.DEFAULT), this.assigner))
/* 391 */           .make();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 398 */         TypeDescription typeDescription = param2Context.register(this);
/* 399 */         return (new StackManipulation.Compound(new StackManipulation[] {
/* 400 */               TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, 
/*     */               
/* 402 */               this.specialMethodInvocation.getMethodDescription().isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*     */               
/* 404 */               MethodVariableAccess.loadThis(), 
/* 405 */               (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly())
/* 406 */             })).apply(param2MethodVisitor, param2Context);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.serializableProxy != ((RedirectionProxy)param2Object).serializableProxy) ? false : (!this.morphingType.equals(((RedirectionProxy)param2Object).morphingType) ? false : (!this.instrumentedType.equals(((RedirectionProxy)param2Object).instrumentedType) ? false : (!this.specialMethodInvocation.equals(((RedirectionProxy)param2Object).specialMethodInvocation) ? false : (!!this.assigner.equals(((RedirectionProxy)param2Object).assigner))))))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return ((((getClass().hashCode() * 31 + this.morphingType.hashCode()) * 31 + this.instrumentedType.hashCode()) * 31 + this.specialMethodInvocation.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.serializableProxy;
/*     */       }
/*     */       
/* 417 */       protected enum StaticFieldConstructor implements Implementation { INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final MethodDescription objectTypeDefaultConstructor;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         StaticFieldConstructor() {
/* 428 */           this
/*     */             
/* 430 */             .objectTypeDefaultConstructor = (MethodDescription)((MethodList)TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 437 */           return param3InstrumentedType;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final ByteCodeAppender appender(Implementation.Target param3Target) {
/* 444 */           return (ByteCodeAppender)new ByteCodeAppender.Simple(new StackManipulation[] { MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(this.objectTypeDefaultConstructor), (StackManipulation)MethodReturn.VOID });
/*     */         } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       protected static class InstanceFieldConstructor
/*     */         implements Implementation
/*     */       {
/*     */         private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected InstanceFieldConstructor(TypeDescription param3TypeDescription) {
/* 465 */           this.instrumentedType = param3TypeDescription;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 472 */           return param3InstrumentedType.withField(new FieldDescription.Token("target", 18, this.instrumentedType
/*     */                 
/* 474 */                 .asGenericType()));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ByteCodeAppender appender(Implementation.Target param3Target) {
/* 481 */           return new Appender(param3Target);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.instrumentedType.equals(((InstanceFieldConstructor)param3Object).instrumentedType))));
/*     */         }
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*     */         }
/*     */         
/*     */         @Enhance
/*     */         protected static class Appender
/*     */           implements ByteCodeAppender
/*     */         {
/*     */           private final FieldDescription fieldDescription;
/*     */           
/*     */           protected Appender(Implementation.Target param4Target) {
/* 501 */             this
/*     */ 
/*     */               
/* 504 */               .fieldDescription = (FieldDescription)((FieldList)param4Target.getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("target"))).getOnly();
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/* 519 */             StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(Morph.Binder.RedirectionProxy.StaticFieldConstructor.a(Morph.Binder.RedirectionProxy.StaticFieldConstructor.INSTANCE)), MethodVariableAccess.allArgumentsOf(param4MethodDescription).prependThisReference(), FieldAccess.forField(this.fieldDescription).write(), (StackManipulation)MethodReturn.VOID })).apply(param4MethodVisitor, param4Context);
/* 520 */             return new ByteCodeAppender.Size(size.getMaximalSize(), param4MethodDescription.getStackSize());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean equals(@MaybeNull Object param4Object) {
/*     */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.fieldDescription.equals(((Appender)param4Object).fieldDescription))));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public int hashCode() {
/*     */             return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       protected static class MethodCall
/*     */         implements Implementation
/*     */       {
/*     */         private final MethodDescription accessorMethod;
/*     */         
/*     */         private final Assigner assigner;
/*     */ 
/*     */         
/*     */         protected MethodCall(MethodDescription param3MethodDescription, Assigner param3Assigner) {
/* 548 */           this.accessorMethod = param3MethodDescription;
/* 549 */           this.assigner = param3Assigner;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 556 */           return param3InstrumentedType;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ByteCodeAppender appender(Implementation.Target param3Target) {
/* 563 */           return new Appender(this, param3Target);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.accessorMethod.equals(((MethodCall)param3Object).accessorMethod) ? false : (!!this.assigner.equals(((MethodCall)param3Object).assigner)))));
/*     */         }
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return (getClass().hashCode() * 31 + this.accessorMethod.hashCode()) * 31 + this.assigner.hashCode();
/*     */         }
/*     */         
/*     */         @Enhance(includeSyntheticFields = true)
/*     */         protected class Appender
/*     */           implements ByteCodeAppender
/*     */         {
/*     */           private final TypeDescription typeDescription;
/*     */           
/*     */           protected Appender(Morph.Binder.RedirectionProxy.MethodCall this$0, Implementation.Target param4Target) {
/* 583 */             this.typeDescription = param4Target.getInstrumentedType();
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/* 592 */             StackManipulation stackManipulation = MethodVariableAccess.REFERENCE.loadFrom(1);
/* 593 */             StackManipulation[] arrayOfStackManipulation = new StackManipulation[Morph.Binder.RedirectionProxy.MethodCall.a(this.a).getParameters().size()];
/* 594 */             byte b = 0;
/* 595 */             for (TypeDescription.Generic generic : Morph.Binder.RedirectionProxy.MethodCall.a(this.a).getParameters().asTypeList()) {
/* 596 */               arrayOfStackManipulation[b] = (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { stackManipulation, 
/* 597 */                     IntegerConstant.forValue(b), ArrayAccess.REFERENCE
/* 598 */                     .load(), 
/* 599 */                     Morph.Binder.RedirectionProxy.MethodCall.b(this.a).assign(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), generic, Assigner.Typing.DYNAMIC) });
/* 600 */               b++;
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 614 */             StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { Morph.Binder.RedirectionProxy.MethodCall.a(this.a).isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)this.typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("target"))).getOnly()).read() }), (StackManipulation)new StackManipulation.Compound(arrayOfStackManipulation), (StackManipulation)MethodInvocation.invoke(Morph.Binder.RedirectionProxy.MethodCall.a(this.a)), Morph.Binder.RedirectionProxy.MethodCall.b(this.a).assign(Morph.Binder.RedirectionProxy.MethodCall.a(this.a).getReturnType(), param4MethodDescription.getReturnType(), Assigner.Typing.DYNAMIC), (StackManipulation)MethodReturn.REFERENCE })).apply(param4MethodVisitor, param4Context);
/* 615 */             return new ByteCodeAppender.Size(size.getMaximalSize(), param4MethodDescription.getStackSize());
/*     */           }
/*     */           
/*     */           public boolean equals(@MaybeNull Object param4Object) {
/*     */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.typeDescription.equals(((Appender)param4Object).typeDescription) ? false : (!!this.a.equals(((Appender)param4Object).a)))));
/*     */           }
/*     */           
/*     */           public int hashCode() {
/*     */             return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.a.hashCode();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\Morph.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */