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
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*    */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*    */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
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
/*    */ public @interface StubValue
/*    */ {
/*    */   public enum Binder
/*    */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<StubValue>
/*    */   {
/* 64 */     INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final Class<StubValue> getHandledType() {
/* 70 */       return StubValue.class;
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
/*    */     public final MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<StubValue> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 82 */       if (!param1ParameterDescription.getType().represents(Object.class)) {
/* 83 */         throw new IllegalStateException(param1ParameterDescription + " uses StubValue annotation on non-Object type");
/*    */       }
/* 85 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(param1MethodDescription.getReturnType().represents(void.class) ? (StackManipulation)NullConstant.INSTANCE : (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/*    */               
/* 87 */               DefaultValue.of((TypeDefinition)param1MethodDescription.getReturnType().asErasure()), param1Assigner
/* 88 */               .assign(param1MethodDescription.getReturnType(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), param1Typing)
/*    */             }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\StubValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */