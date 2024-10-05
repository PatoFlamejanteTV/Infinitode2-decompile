/*    */ package net.bytebuddy.implementation.bind.annotation;
/*    */ 
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.ElementType;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.lang.annotation.Target;
/*    */ import net.bytebuddy.description.annotation.AnnotationSource;
/*    */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
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
/*    */ @Target({ElementType.PARAMETER, ElementType.METHOD})
/*    */ public @interface RuntimeType
/*    */ {
/*    */   public static final class Verifier
/*    */   {
/*    */     private Verifier() {
/* 51 */       throw new UnsupportedOperationException();
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static Assigner.Typing check(AnnotationSource param1AnnotationSource) {
/* 61 */       return Assigner.Typing.of(param1AnnotationSource.getDeclaredAnnotations().isAnnotationPresent(RuntimeType.class));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\RuntimeType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */