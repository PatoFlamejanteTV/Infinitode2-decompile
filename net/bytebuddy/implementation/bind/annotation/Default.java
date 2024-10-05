/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
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
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.PARAMETER})
/*     */ public @interface Default
/*     */ {
/*     */   boolean serializableProxy() default false;
/*     */   
/*     */   Class<?> proxyType() default void.class;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Default>
/*     */   {
/*  73 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape PROXY_TYPE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/*  90 */       SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Default.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("serializableProxy"))).getOnly();
/*  91 */       PROXY_TYPE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("proxyType"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<Default> getHandledType() {
/*  98 */       return Default.class;
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Default> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*     */       TypeDescription typeDescription;
/* 111 */       if (!(typeDescription = TypeLocator.ForType.of((TypeDescription)param1Loadable.getValue(PROXY_TYPE).resolve(TypeDescription.class)).resolve(param1ParameterDescription.getType())).isInterface()) {
/* 112 */         throw new IllegalStateException(param1ParameterDescription + " uses the @Default annotation on an invalid type");
/*     */       }
/* 114 */       if (param1MethodDescription.isStatic() || !param1Target.getInstrumentedType().getInterfaces().asErasures().contains(typeDescription)) {
/* 115 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       }
/* 117 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new TypeProxy.ForDefaultMethod(typeDescription, param1Target, ((Boolean)param1Loadable
/*     */             
/* 119 */             .getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue()));
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
/*     */       TypeDescription resolve(TypeDescription.Generic param2Generic);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public enum ForParameterType
/*     */         implements TypeLocator
/*     */       {
/* 144 */         INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final TypeDescription resolve(TypeDescription.Generic param3Generic) {
/* 150 */           return param3Generic.asErasure();
/*     */         }
/*     */       }
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
/*     */         protected ForType(TypeDescription param3TypeDescription) {
/* 171 */           this.typeDescription = param3TypeDescription;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected static Default.Binder.TypeLocator of(TypeDescription param3TypeDescription) {
/* 181 */           if (param3TypeDescription.represents(void.class))
/* 182 */             return Default.Binder.TypeLocator.ForParameterType.INSTANCE; 
/* 183 */           if (!param3TypeDescription.isInterface()) {
/* 184 */             throw new IllegalStateException("Cannot assign proxy to " + param3TypeDescription);
/*     */           }
/* 186 */           return new ForType(param3TypeDescription);
/*     */         }
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForType)param3Object).typeDescription))));
/*     */         }
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */         }
/* 194 */         public TypeDescription resolve(TypeDescription.Generic param3Generic) { if (!this.typeDescription.isAssignableTo(param3Generic.asErasure())) {
/* 195 */             throw new IllegalStateException("Impossible to assign " + this.typeDescription + " to parameter of type " + param3Generic);
/*     */           }
/* 197 */           return this.typeDescription; } } } @Enhance public static class ForType implements TypeLocator { public TypeDescription resolve(TypeDescription.Generic param2Generic) { if (!this.typeDescription.isAssignableTo(param2Generic.asErasure())) throw new IllegalStateException("Impossible to assign " + this.typeDescription + " to parameter of type " + param2Generic);  return this.typeDescription; }
/*     */ 
/*     */       
/*     */       private final TypeDescription typeDescription;
/*     */       
/*     */       protected ForType(TypeDescription param2TypeDescription) {
/*     */         this.typeDescription = param2TypeDescription;
/*     */       }
/*     */       
/*     */       protected static Default.Binder.TypeLocator of(TypeDescription param2TypeDescription) {
/*     */         if (param2TypeDescription.represents(void.class))
/*     */           return Default.Binder.TypeLocator.ForParameterType.INSTANCE; 
/*     */         if (!param2TypeDescription.isInterface())
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\Default.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */