/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public @interface SuperCall
/*     */ {
/*     */   boolean serializableProxy() default false;
/*     */   
/*     */   boolean fallbackToDefault() default true;
/*     */   
/*     */   boolean nullIfImpossible() default false;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperCall>
/*     */   {
/*  86 */     INSTANCE;
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
/*     */     private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 108 */       SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(SuperCall.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("serializableProxy"))).getOnly();
/* 109 */       FALLBACK_TO_DEFAULT = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("fallbackToDefault"))).getOnly();
/* 110 */       NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("nullIfImpossible"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<SuperCall> getHandledType() {
/* 117 */       return SuperCall.class;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperCall> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*     */       MethodCallProxy.AssignableSignatureCall assignableSignatureCall;
/*     */       NullConstant nullConstant;
/*     */       TypeDescription typeDescription;
/* 130 */       if (!(typeDescription = param1ParameterDescription.getType().asErasure()).represents(Runnable.class) && !typeDescription.represents(Callable.class) && !typeDescription.represents(Object.class))
/* 131 */         throw new IllegalStateException("A super method call proxy can only be assigned to Runnable or Callable types: " + param1ParameterDescription); 
/* 132 */       if (param1MethodDescription.isConstructor()) {
/* 133 */         return (MethodDelegationBinder.ParameterBinding<?>)(((Boolean)param1Loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue() ? new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)NullConstant.INSTANCE) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */ 
/*     */       
/* 141 */       if ((specialMethodInvocation = (((Boolean)param1Loadable.getValue(FALLBACK_TO_DEFAULT).resolve(Boolean.class)).booleanValue() ? param1Target.invokeDominant(param1MethodDescription.asSignatureToken()) : param1Target.invokeSuper(param1MethodDescription.asSignatureToken())).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken())).isValid()) {
/* 142 */         assignableSignatureCall = new MethodCallProxy.AssignableSignatureCall(specialMethodInvocation, ((Boolean)param1Loadable.getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue());
/* 143 */       } else if (((Boolean)assignableSignatureCall.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
/* 144 */         nullConstant = NullConstant.INSTANCE;
/*     */       } else {
/* 146 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       } 
/* 148 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)nullConstant);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\SuperCall.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */