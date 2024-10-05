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
/*     */ public @interface SuperMethod
/*     */ {
/*     */   boolean cached() default true;
/*     */   
/*     */   boolean privileged() default false;
/*     */   
/*     */   boolean fallbackToDefault() default true;
/*     */   
/*     */   boolean nullIfImpossible() default false;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperMethod>
/*     */   {
/*  89 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape FALLBACK_TO_DEFAULT;
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
/* 116 */       CACHED = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(SuperMethod.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("cached"))).getOnly();
/* 117 */       PRIVILEGED = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("privileged"))).getOnly();
/* 118 */       FALLBACK_TO_DEFAULT = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("fallbackToDefault"))).getOnly();
/* 119 */       NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("nullIfImpossible"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<SuperMethod> getHandledType() {
/* 126 */       return SuperMethod.class;
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperMethod> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 138 */       if (!param1ParameterDescription.getType().asErasure().isAssignableFrom(Method.class))
/* 139 */         throw new IllegalStateException("Cannot assign Method type to " + param1ParameterDescription); 
/* 140 */       if (param1MethodDescription.isMethod()) {
/*     */         Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */ 
/*     */         
/* 144 */         if ((specialMethodInvocation = (((Boolean)param1Loadable.getValue(FALLBACK_TO_DEFAULT).resolve(Boolean.class)).booleanValue() ? param1Target.invokeDominant(param1MethodDescription.asSignatureToken()) : param1Target.invokeSuper(param1MethodDescription.asSignatureToken())).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken())).isValid())
/* 145 */           return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(new DelegationMethod(specialMethodInvocation, ((Boolean)param1Loadable
/* 146 */                 .getValue(CACHED).resolve(Boolean.class)).booleanValue(), ((Boolean)param1Loadable
/* 147 */                 .getValue(PRIVILEGED).resolve(Boolean.class)).booleanValue())); 
/* 148 */         if (((Boolean)param1Loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
/* 149 */           return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)NullConstant.INSTANCE);
/*     */         }
/* 151 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       } 
/* 153 */       if (((Boolean)param1Loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
/* 154 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)NullConstant.INSTANCE);
/*     */       }
/* 156 */       return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class DelegationMethod
/*     */       implements StackManipulation
/*     */     {
/*     */       private final Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final boolean cached;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final boolean privileged;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected DelegationMethod(Implementation.SpecialMethodInvocation param2SpecialMethodInvocation, boolean param2Boolean1, boolean param2Boolean2) {
/* 189 */         this.specialMethodInvocation = param2SpecialMethodInvocation;
/* 190 */         this.cached = param2Boolean1;
/* 191 */         this.privileged = param2Boolean2;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isValid() {
/* 198 */         return this.specialMethodInvocation.isValid();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 207 */         MethodConstant.CanCache canCache = this.privileged ? MethodConstant.ofPrivileged(param2Context.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC)) : MethodConstant.of(param2Context.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC));
/* 208 */         return (this.cached ? 
/* 209 */           FieldAccess.forField(param2Context.cache((StackManipulation)canCache, TypeDescription.ForLoadedType.of(Method.class))).read() : canCache)
/* 210 */           .apply(param2MethodVisitor, param2Context);
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\SuperMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */