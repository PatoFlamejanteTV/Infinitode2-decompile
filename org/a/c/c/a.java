/*    */ package org.a.c.c;
/*    */ 
/*    */ import com.a.a.a.am;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import org.a.c.b.d;
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
/*    */ final class a
/*    */   extends l
/*    */ {
/*    */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/* 36 */     b b = null;
/*    */ 
/*    */     
/*    */     try {
/* 40 */       am.a(b = new b(paramInputStream), paramOutputStream);
/* 41 */       paramOutputStream.flush();
/*    */     }
/*    */     finally {
/*    */       
/* 45 */       am.a(b);
/*    */     } 
/* 47 */     return new k(paramd);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 54 */     c c = new c(paramOutputStream);
/* 55 */     am.a(paramInputStream, c);
/* 56 */     c.close();
/* 57 */     paramOutputStream.flush();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */