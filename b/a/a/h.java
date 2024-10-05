/*    */ package b.a.a;
/*    */ 
/*    */ import java.io.PrintStream;
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
/*    */ public class h
/*    */   extends Exception
/*    */ {
/*    */   private Throwable a;
/*    */   
/*    */   public h(String paramString, Throwable paramThrowable) {
/* 38 */     super(paramString);
/* 39 */     this.a = paramThrowable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void printStackTrace() {
/* 47 */     printStackTrace(System.err);
/*    */   }
/*    */   
/*    */   public void printStackTrace(PrintStream paramPrintStream) {
/* 51 */     if (this.a == null) {
/* 52 */       super.printStackTrace(paramPrintStream); return;
/*    */     } 
/* 54 */     this.a.printStackTrace();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */