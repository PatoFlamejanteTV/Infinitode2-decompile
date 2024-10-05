/*    */ package nonapi.io.github.classgraph.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Assert
/*    */ {
/*    */   public static void isAnnotation(Class<?> paramClass) {
/* 14 */     if (!paramClass.isAnnotation()) {
/* 15 */       throw new IllegalArgumentException(paramClass + " is not an annotation");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void isInterface(Class<?> paramClass) {
/* 28 */     if (!paramClass.isInterface())
/* 29 */       throw new IllegalArgumentException(paramClass + " is not an interface"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\Assert.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */