/*    */ package net.bytebuddy.implementation.bind.annotation;
/*    */ 
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.ElementType;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.lang.annotation.Target;
/*    */ import net.bytebuddy.description.method.MethodDescription;
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
/*    */ @Target({ElementType.METHOD})
/*    */ public @interface IgnoreForBinding
/*    */ {
/*    */   public static final class Verifier
/*    */   {
/*    */     private Verifier() {
/* 42 */       throw new UnsupportedOperationException();
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static boolean check(MethodDescription param1MethodDescription) {
/* 52 */       return param1MethodDescription.getDeclaredAnnotations().isAnnotationPresent(IgnoreForBinding.class);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\IgnoreForBinding.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */