/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationSource;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
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
/*     */ public @interface FieldValue
/*     */ {
/*     */   String value() default "";
/*     */   
/*     */   Class<?> declaringType() default void.class;
/*     */   
/*     */   public enum Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldValue>
/*     */   {
/*  87 */     INSTANCE((String)new Delegate());
/*     */ 
/*     */ 
/*     */     
/*     */     private final TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldValue> delegate;
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape FIELD_NAME;
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape DECLARING_TYPE;
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       MethodList methodList;
/* 104 */       DECLARING_TYPE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(FieldValue.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("declaringType"))).getOnly();
/* 105 */       FIELD_NAME = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
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
/*     */     Binder(TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldValue> param1ParameterBinder) {
/* 119 */       this.delegate = param1ParameterBinder;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<FieldValue> getHandledType() {
/* 126 */       return this.delegate.getHandledType();
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
/*     */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<FieldValue> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 138 */       return this.delegate.bind(param1Loadable, param1MethodDescription, param1ParameterDescription, param1Target, param1Assigner, param1Typing);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class Delegate
/*     */       extends TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFieldBinding<FieldValue>
/*     */     {
/*     */       public Class<FieldValue> getHandledType() {
/* 150 */         return FieldValue.class;
/*     */       }
/*     */ 
/*     */       
/*     */       protected String fieldName(AnnotationDescription.Loadable<FieldValue> param2Loadable) {
/* 155 */         return (String)param2Loadable.getValue(FieldValue.Binder.a()).resolve(String.class);
/*     */       }
/*     */ 
/*     */       
/*     */       protected TypeDescription declaringType(AnnotationDescription.Loadable<FieldValue> param2Loadable) {
/* 160 */         return (TypeDescription)param2Loadable.getValue(FieldValue.Binder.b()).resolve(TypeDescription.class);
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
/*     */ 
/*     */ 
/*     */       
/*     */       protected MethodDelegationBinder.ParameterBinding<?> bind(FieldDescription param2FieldDescription, AnnotationDescription.Loadable<FieldValue> param2Loadable, MethodDescription param2MethodDescription, ParameterDescription param2ParameterDescription, Implementation.Target param2Target, Assigner param2Assigner) {
/*     */         StackManipulation.Compound compound;
/* 177 */         return (MethodDelegationBinder.ParameterBinding<?>)((compound = new StackManipulation.Compound(new StackManipulation[] { param2FieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(param2FieldDescription).read(), param2Assigner.assign(param2FieldDescription.getType(), param2ParameterDescription.getType(), RuntimeType.Verifier.check((AnnotationSource)param2ParameterDescription)) })).isValid() ? new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)compound) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\FieldValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */