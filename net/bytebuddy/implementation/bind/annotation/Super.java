/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.Arrays;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.TargetType;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.auxiliary.TypeProxy;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ public @interface Super
/*     */ {
/*     */   Instantiation strategy() default Instantiation.CONSTRUCTOR;
/*     */   
/*     */   boolean ignoreFinalizer() default true;
/*     */   
/*     */   boolean serializableProxy() default false;
/*     */   
/*     */   Class<?>[] constructorParameters() default {};
/*     */   
/*     */   Class<?> proxyType() default void.class;
/*     */   
/*     */   public enum Instantiation
/*     */   {
/* 126 */     CONSTRUCTOR
/*     */     {
/*     */       
/*     */       protected final StackManipulation proxyFor(TypeDescription param2TypeDescription, Implementation.Target param2Target, AnnotationDescription.Loadable<Super> param2Loadable)
/*     */       {
/* 131 */         return (StackManipulation)new TypeProxy.ForSuperMethodByConstructor(param2TypeDescription, param2Target, 
/*     */             
/* 133 */             Arrays.asList((Object[])param2Loadable.getValue(a()).resolve(TypeDescription[].class)), ((Boolean)param2Loadable
/* 134 */             .getValue(b()).resolve(Boolean.class)).booleanValue(), ((Boolean)param2Loadable
/* 135 */             .getValue(c()).resolve(Boolean.class)).booleanValue());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     UNSAFE
/*     */     {
/*     */       
/*     */       protected final StackManipulation proxyFor(TypeDescription param2TypeDescription, Implementation.Target param2Target, AnnotationDescription.Loadable<Super> param2Loadable)
/*     */       {
/* 148 */         return (StackManipulation)new TypeProxy.ForSuperMethodByReflectionFactory(param2TypeDescription, param2Target, ((Boolean)param2Loadable
/*     */             
/* 150 */             .getValue(b()).resolve(Boolean.class)).booleanValue(), ((Boolean)param2Loadable
/* 151 */             .getValue(c()).resolve(Boolean.class)).booleanValue());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract StackManipulation proxyFor(TypeDescription param1TypeDescription, Implementation.Target param1Target, AnnotationDescription.Loadable<Super> param1Loadable);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape IGNORE_FINALIZER;
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape CONSTRUCTOR_PARAMETERS;
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 175 */       IGNORE_FINALIZER = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Super.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("ignoreFinalizer"))).getOnly();
/* 176 */       SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("serializableProxy"))).getOnly();
/* 177 */       CONSTRUCTOR_PARAMETERS = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("constructorParameters"))).getOnly();
/*     */     }
/*     */   }
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
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Super>
/*     */   {
/* 206 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape PROXY_TYPE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape STRATEGY;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 223 */       STRATEGY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Super.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("strategy"))).getOnly();
/* 224 */       PROXY_TYPE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("proxyType"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<Super> getHandledType() {
/* 231 */       return Super.class;
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Super> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 243 */       if (param1ParameterDescription.getType().isPrimitive() || param1ParameterDescription.getType().isArray()) {
/* 244 */         throw new IllegalStateException(param1ParameterDescription + " uses the @Super annotation on an invalid type");
/*     */       }
/*     */       
/*     */       TypeDescription typeDescription;
/*     */       
/* 249 */       if ((typeDescription = TypeLocator.ForType.of((TypeDescription)param1Loadable.getValue(PROXY_TYPE).resolve(TypeDescription.class)).resolve(param1Target.getInstrumentedType(), param1ParameterDescription.getType())).isFinal())
/* 250 */         throw new IllegalStateException("Cannot extend final type as @Super proxy: " + typeDescription); 
/* 251 */       if (param1MethodDescription.isStatic() || !param1Target.getInstrumentedType().isAssignableTo(typeDescription)) {
/* 252 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       }
/* 254 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(((Super.Instantiation)((EnumerationDescription)param1Loadable
/* 255 */           .getValue(STRATEGY).resolve(EnumerationDescription.class)).load(Super.Instantiation.class))
/* 256 */           .proxyFor(typeDescription, param1Target, param1Loadable));
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
/*     */     protected static interface TypeLocator
/*     */     {
/*     */       TypeDescription resolve(TypeDescription param2TypeDescription, TypeDescription.Generic param2Generic);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public enum ForInstrumentedType
/*     */         implements TypeLocator
/*     */       {
/* 282 */         INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final TypeDescription resolve(TypeDescription param3TypeDescription, TypeDescription.Generic param3Generic) {
/* 288 */           return param3TypeDescription;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public enum ForParameterType
/*     */         implements TypeLocator
/*     */       {
/* 300 */         INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final TypeDescription resolve(TypeDescription param3TypeDescription, TypeDescription.Generic param3Generic) {
/*     */           TypeDescription typeDescription;
/* 307 */           return (typeDescription = param3Generic.asErasure()).equals(param3TypeDescription) ? param3TypeDescription : typeDescription;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class ForType
/*     */         implements TypeLocator
/*     */       {
/*     */         private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected ForType(TypeDescription param3TypeDescription) {
/* 330 */           this.typeDescription = param3TypeDescription;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected static Super.Binder.TypeLocator of(TypeDescription param3TypeDescription) {
/* 340 */           if (param3TypeDescription.represents(void.class))
/* 341 */             return Super.Binder.TypeLocator.ForParameterType.INSTANCE; 
/* 342 */           if (param3TypeDescription.represents(TargetType.class))
/* 343 */             return Super.Binder.TypeLocator.ForInstrumentedType.INSTANCE; 
/* 344 */           if (param3TypeDescription.isPrimitive() || param3TypeDescription.isArray()) {
/* 345 */             throw new IllegalStateException("Cannot assign proxy to " + param3TypeDescription);
/*     */           }
/* 347 */           return new ForType(param3TypeDescription);
/*     */         }
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForType)param3Object).typeDescription))));
/*     */         }
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */         }
/* 355 */         public TypeDescription resolve(TypeDescription param3TypeDescription, TypeDescription.Generic param3Generic) { if (!this.typeDescription.isAssignableTo(param3Generic.asErasure())) {
/* 356 */             throw new IllegalStateException("Impossible to assign " + this.typeDescription + " to parameter of type " + param3Generic);
/*     */           }
/* 358 */           return this.typeDescription; } } } @Enhance public static class ForType implements TypeLocator { public TypeDescription resolve(TypeDescription param2TypeDescription, TypeDescription.Generic param2Generic) { if (!this.typeDescription.isAssignableTo(param2Generic.asErasure())) throw new IllegalStateException("Impossible to assign " + this.typeDescription + " to parameter of type " + param2Generic);  return this.typeDescription; }
/*     */ 
/*     */       
/*     */       private final TypeDescription typeDescription;
/*     */       
/*     */       protected ForType(TypeDescription param2TypeDescription) {
/*     */         this.typeDescription = param2TypeDescription;
/*     */       }
/*     */       
/*     */       protected static Super.Binder.TypeLocator of(TypeDescription param2TypeDescription) {
/*     */         if (param2TypeDescription.represents(void.class))
/*     */           return Super.Binder.TypeLocator.ForParameterType.INSTANCE; 
/*     */         if (param2TypeDescription.represents(TargetType.class))
/*     */           return Super.Binder.TypeLocator.ForInstrumentedType.INSTANCE; 
/*     */         if (param2TypeDescription.isPrimitive() || param2TypeDescription.isArray())
/*     */           throw new IllegalStateException("Cannot assign proxy to " + param2TypeDescription); 
/*     */         return new ForType(param2TypeDescription);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((ForType)param2Object).typeDescription))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */       } }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\Super.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */