/*    */ package org.a.c.c;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import org.a.c.b.d;
/*    */ import org.a.c.b.j;
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
/*    */ final class h
/*    */   extends l
/*    */ {
/*    */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/*    */     o o;
/*    */     j j;
/* 37 */     if ((j = (j)paramd.a(j.cp)) == null || j.equals(j.bB)) {
/*    */ 
/*    */ 
/*    */       
/* 41 */       (o = new o()).a(paramInputStream, paramOutputStream, paramd, paramInt);
/* 42 */       return new k(paramd);
/*    */     } 
/* 44 */     throw new IOException("Unsupported crypt filter " + o.a());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/*    */     o o;
/*    */     j j;
/* 52 */     if ((j = (j)paramd.a(j.cp)) == null || j.equals(j.bB)) {
/*    */ 
/*    */ 
/*    */       
/* 56 */       (o = new o()).a(paramInputStream, paramOutputStream, paramd);
/*    */       
/*    */       return;
/*    */     } 
/* 60 */     throw new IOException("Unsupported crypt filter " + o.a());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */