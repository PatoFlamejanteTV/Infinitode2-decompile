/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
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
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.PARAMETER})
/*     */ public @interface This
/*     */ {
/*     */   boolean optional() default false;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<This>
/*     */   {
/*  74 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     private static final MethodDescription.InDefinedShape OPTIONAL = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(This.class)
/*  80 */       .getDeclaredMethods()
/*  81 */       .filter((ElementMatcher)ElementMatchers.named("optional")))
/*  82 */       .getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<This> getHandledType() {
/*  88 */       return This.class;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<This> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 100 */       if (param1ParameterDescription.getType().isPrimitive())
/* 101 */         throw new IllegalStateException(param1ParameterDescription + " uses a primitive type with a @This annotation"); 
/* 102 */       if (param1ParameterDescription.getType().isArray())
/* 103 */         throw new IllegalStateException(param1ParameterDescription + " uses an array type with a @This annotation"); 
/* 104 */       if (param1MethodDescription.isStatic() && !((Boolean)param1Loadable.getValue(OPTIONAL).resolve(Boolean.class)).booleanValue()) {
/* 105 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       }
/* 107 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(param1MethodDescription.isStatic() ? (StackManipulation)NullConstant.INSTANCE : (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/*     */               
/* 109 */               MethodVariableAccess.loadThis(), param1Assigner
/* 110 */               .assign(param1Target.getInstrumentedType().asGenericType(), param1ParameterDescription.getType(), param1Typing)
/*     */             }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\This.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */