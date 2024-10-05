/*    */ package net.bytebuddy.implementation.bind.annotation;
/*    */ 
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.ElementType;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.lang.annotation.Target;
/*    */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*    */ import net.bytebuddy.description.method.MethodDescription;
/*    */ import net.bytebuddy.description.method.ParameterDescription;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*    */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*    */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Documented
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ @Target({ElementType.PARAMETER})
/*    */ public @interface Empty
/*    */ {
/*    */   public enum Binder
/*    */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Empty>
/*    */   {
/* 48 */     INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final Class<Empty> getHandledType() {
/* 54 */       return Empty.class;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Empty> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 66 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(DefaultValue.of((TypeDefinition)param1ParameterDescription.getType().asErasure()));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\Empty.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */