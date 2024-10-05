/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Method;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.TargetType;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.PARAMETER})
/*     */ public @interface DefaultMethod
/*     */ {
/*     */   boolean cached() default true;
/*     */   
/*     */   boolean privileged() default false;
/*     */   
/*     */   Class<?> targetType() default void.class;
/*     */   
/*     */   boolean nullIfImpossible() default false;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultMethod>
/*     */   {
/*  90 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape TARGET_TYPE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape PRIVILEGED;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape CACHED;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 117 */       CACHED = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(DefaultMethod.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("cached"))).getOnly();
/* 118 */       PRIVILEGED = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("privileged"))).getOnly();
/* 119 */       TARGET_TYPE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("targetType"))).getOnly();
/* 120 */       NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("nullIfImpossible"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<DefaultMethod> getHandledType() {
/* 127 */       return DefaultMethod.class;
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultMethod> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 139 */       if (!param1ParameterDescription.getType().asErasure().isAssignableFrom(Method.class))
/* 140 */         throw new IllegalStateException("Cannot assign Method type to " + param1ParameterDescription); 
/* 141 */       if (param1MethodDescription.isMethod()) {
/*     */         Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */         
/*     */         TypeDescription typeDescription;
/*     */         
/* 146 */         if ((specialMethodInvocation = ((typeDescription = (TypeDescription)param1Loadable.getValue(TARGET_TYPE).resolve(TypeDescription.class)).represents(void.class) ? MethodLocator.ForImplicitType.INSTANCE : new MethodLocator.ForExplicitType(typeDescription)).resolve(param1Target, param1MethodDescription).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken())).isValid())
/* 147 */           return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(new DelegationMethod(specialMethodInvocation, ((Boolean)param1Loadable
/* 148 */                 .getValue(CACHED).resolve(Boolean.class)).booleanValue(), ((Boolean)param1Loadable
/* 149 */                 .getValue(PRIVILEGED).resolve(Boolean.class)).booleanValue())); 
/* 150 */         if (((Boolean)param1Loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
/* 151 */           return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)NullConstant.INSTANCE);
/*     */         }
/* 153 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       } 
/* 155 */       if (((Boolean)param1Loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
/* 156 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)NullConstant.INSTANCE);
/*     */       }
/* 158 */       return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
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
/*     */     public enum ForImplicitType
/*     */       implements MethodLocator
/*     */     {
/* 184 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription) {
/* 190 */         return param2Target.invokeDefault(param2MethodDescription.asSignatureToken());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class ForExplicitType
/*     */       implements MethodLocator
/*     */     {
/*     */       private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected ForExplicitType(TypeDescription param2TypeDescription) {
/* 211 */         this.typeDescription = param2TypeDescription;
/*     */       }
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((ForExplicitType)param2Object).typeDescription))));
/*     */       } public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */       }
/* 218 */       public Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription) { if (!this.typeDescription.isInterface()) {
/* 219 */           throw new IllegalStateException(param2MethodDescription + " method carries default method call parameter on non-interface type");
/*     */         }
/* 221 */         return param2Target.invokeDefault(param2MethodDescription.asSignatureToken(), TargetType.resolve(this.typeDescription, param2Target.getInstrumentedType())); } } protected static interface MethodLocator { Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription); public enum ForImplicitType implements MethodLocator { INSTANCE; public final Implementation.SpecialMethodInvocation resolve(Implementation.Target param3Target, MethodDescription param3MethodDescription) { return param3Target.invokeDefault(param3MethodDescription.asSignatureToken()); } } @Enhance public static class ForExplicitType implements MethodLocator { public Implementation.SpecialMethodInvocation resolve(Implementation.Target param3Target, MethodDescription param3MethodDescription) { if (!this.typeDescription.isInterface()) throw new IllegalStateException(param3MethodDescription + " method carries default method call parameter on non-interface type");  return param3Target.invokeDefault(param3MethodDescription.asSignatureToken(), TargetType.resolve(this.typeDescription, param3Target.getInstrumentedType())); }
/*     */ 
/*     */ 
/*     */         
/*     */         private final TypeDescription typeDescription;
/*     */ 
/*     */         
/*     */         protected ForExplicitType(TypeDescription param3TypeDescription) {
/*     */           this.typeDescription = param3TypeDescription;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForExplicitType)param3Object).typeDescription))));
/*     */         }
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */         } }
/*     */        }
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class DelegationMethod
/*     */       implements StackManipulation
/*     */     {
/*     */       private final Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */       
/*     */       private final boolean cached;
/*     */       private final boolean privileged;
/*     */       
/*     */       protected DelegationMethod(Implementation.SpecialMethodInvocation param2SpecialMethodInvocation, boolean param2Boolean1, boolean param2Boolean2) {
/* 255 */         this.specialMethodInvocation = param2SpecialMethodInvocation;
/* 256 */         this.cached = param2Boolean1;
/* 257 */         this.privileged = param2Boolean2;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isValid() {
/* 264 */         return this.specialMethodInvocation.isValid();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 273 */         MethodConstant.CanCache canCache = this.privileged ? MethodConstant.ofPrivileged(param2Context.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC)) : MethodConstant.of(param2Context.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC));
/* 274 */         return (this.cached ? 
/* 275 */           FieldAccess.forField(param2Context.cache((StackManipulation)canCache, TypeDescription.ForLoadedType.of(Method.class))).read() : canCache)
/* 276 */           .apply(param2MethodVisitor, param2Context);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.cached != ((DelegationMethod)param2Object).cached) ? false : ((this.privileged != ((DelegationMethod)param2Object).privileged) ? false : (!!this.specialMethodInvocation.equals(((DelegationMethod)param2Object).specialMethodInvocation))))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return ((getClass().hashCode() * 31 + this.specialMethodInvocation.hashCode()) * 31 + this.cached) * 31 + this.privileged;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\DefaultMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */