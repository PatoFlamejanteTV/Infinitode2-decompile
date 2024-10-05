/*    */ package org.a.c.d;
/*    */ 
/*    */ import java.io.OutputStream;
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
/*    */ public final class d
/*    */   extends OutputStream
/*    */ {
/*    */   private final f a;
/*    */   
/*    */   public d(f paramf) {
/* 39 */     this.a = paramf;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 46 */     this.a.b(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void write(byte[] paramArrayOfbyte) {
/* 52 */     this.a.a(paramArrayOfbyte);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void write(int paramInt) {
/* 58 */     this.a.a(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */