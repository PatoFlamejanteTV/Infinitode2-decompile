/*    */ package org.a.a.a;
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
/*    */ public final class b
/*    */   extends RuntimeException
/*    */ {
/*    */   public b() {}
/*    */   
/*    */   public b(Throwable paramThrowable) {
/* 55 */     this(paramThrowable.toString(), paramThrowable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public b(String paramString, Throwable paramThrowable) {
/* 65 */     super(paramString + " (Caused by " + paramThrowable + ")");
/* 66 */     this.a = paramThrowable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 72 */   private Throwable a = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Throwable getCause() {
/* 78 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\a\a\b.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */