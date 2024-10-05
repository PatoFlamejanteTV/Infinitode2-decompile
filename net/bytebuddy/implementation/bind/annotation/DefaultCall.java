/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
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
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.PARAMETER})
/*     */ public @interface DefaultCall
/*     */ {
/*     */   Class<?> targetType() default void.class;
/*     */   
/*     */   boolean serializableProxy() default false;
/*     */   
/*     */   boolean nullIfImpossible() default false;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultCall>
/*     */   {
/*  91 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape TARGET_TYPE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 113 */       TARGET_TYPE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(DefaultCall.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("targetType"))).getOnly();
/* 114 */       SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("serializableProxy"))).getOnly();
/* 115 */       NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("nullIfImpossible"))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<DefaultCall> getHandledType() {
/* 122 */       return DefaultCall.class;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultCall> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*     */       MethodCallProxy.AssignableSignatureCall assignableSignatureCall;
/*     */       NullConstant nullConstant;
/*     */       TypeDescription typeDescription2;
/* 135 */       if (!(typeDescription2 = param1ParameterDescription.getType().asErasure()).represents(Runnable.class) && !typeDescription2.represents(Callable.class) && !typeDescription2.represents(Object.class))
/* 136 */         throw new IllegalStateException("A default method call proxy can only be assigned to Runnable or Callable types: " + param1ParameterDescription); 
/* 137 */       if (param1MethodDescription.isConstructor()) {
/* 138 */         return (MethodDelegationBinder.ParameterBinding<?>)(((Boolean)param1Loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue() ? new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)NullConstant.INSTANCE) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE);
/*     */       }
/*     */ 
/*     */       
/*     */       Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */ 
/*     */       
/*     */       TypeDescription typeDescription1;
/*     */       
/* 147 */       if ((specialMethodInvocation = ((typeDescription1 = (TypeDescription)param1Loadable.getValue(TARGET_TYPE).resolve(TypeDescription.class)).represents(void.class) ? DefaultMethodLocator.Implicit.INSTANCE : new DefaultMethodLocator.Explicit(typeDescription1)).resolve(param1Target, param1MethodDescription).withCheckedCompatibilityTo(param1MethodDescription.asTypeToken())).isValid()) {
/* 148 */         assignableSignatureCall = new MethodCallProxy.AssignableSignatureCall(specialMethodInvocation, ((Boolean)param1Loadable.getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue());
/* 149 */       } else if (((Boolean)assignableSignatureCall.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
/* 150 */         nullConstant = NullConstant.INSTANCE;
/*     */       } else {
/* 152 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       } 
/* 154 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)nullConstant);
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
/*     */     
/*     */     public enum Implicit
/*     */       implements DefaultMethodLocator
/*     */     {
/* 181 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription) {
/* 187 */         return param2Target.invokeDefault(param2MethodDescription.asSignatureToken());
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
/* 209 */         this.typeDescription = param2TypeDescription;
/*     */       }
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((Explicit)param2Object).typeDescription))));
/*     */       } public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */       }
/* 216 */       public Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription) { if (!this.typeDescription.isInterface()) {
/* 217 */           throw new IllegalStateException(param2MethodDescription + " method carries default method call parameter on non-interface type");
/*     */         }
/* 219 */         return param2Target.invokeDefault(param2MethodDescription.asSignatureToken(), this.typeDescription); } } protected static interface DefaultMethodLocator { Implementation.SpecialMethodInvocation resolve(Implementation.Target param2Target, MethodDescription param2MethodDescription); public enum Implicit implements DefaultMethodLocator { INSTANCE; public final Implementation.SpecialMethodInvocation resolve(Implementation.Target param3Target, MethodDescription param3MethodDescription) { return param3Target.invokeDefault(param3MethodDescription.asSignatureToken()); } } @Enhance public static class Explicit implements DefaultMethodLocator { public Implementation.SpecialMethodInvocation resolve(Implementation.Target param3Target, MethodDescription param3MethodDescription) { if (!this.typeDescription.isInterface()) throw new IllegalStateException(param3MethodDescription + " method carries default method call parameter on non-interface type");  return param3Target.invokeDefault(param3MethodDescription.asSignatureToken(), this.typeDescription); }
/*     */ 
/*     */         
/*     */         private final TypeDescription typeDescription;
/*     */         
/*     */         public Explicit(TypeDescription param3TypeDescription) {
/*     */           this.typeDescription = param3TypeDescription;
/*     */         }
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((Explicit)param3Object).typeDescription))));
/*     */         }
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */         } }
/*     */        }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\DefaultCall.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */