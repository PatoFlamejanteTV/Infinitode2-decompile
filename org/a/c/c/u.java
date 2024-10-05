/*    */ package org.a.c.c;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import org.a.a.a.a;
/*    */ import org.a.a.a.c;
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
/*    */ final class u
/*    */   extends l
/*    */ {
/* 34 */   private static final a a = c.a(u.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/* 42 */     byte[] arrayOfByte = new byte[128];
/* 43 */     while ((paramInt = paramInputStream.read()) != -1 && paramInt != 128) {
/*    */       
/* 45 */       if (paramInt <= 127) {
/*    */         
/* 47 */         int j = paramInt + 1;
/*    */         
/* 49 */         while (j > 0) {
/*    */           int k;
/*    */ 
/*    */           
/* 53 */           if ((k = paramInputStream.read(arrayOfByte, 0, j)) != -1) {
/*    */ 
/*    */ 
/*    */             
/* 57 */             paramOutputStream.write(arrayOfByte, 0, k);
/* 58 */             j -= k;
/*    */           } 
/*    */         } 
/*    */         
/*    */         continue;
/*    */       } 
/*    */       int i;
/* 65 */       if ((i = paramInputStream.read()) != -1)
/*    */       {
/*    */ 
/*    */         
/* 69 */         for (byte b = 0; b < 257 - paramInt; b++)
/*    */         {
/* 71 */           paramOutputStream.write(i);
/*    */         }
/*    */       }
/*    */     } 
/* 75 */     return new k(paramd);
/*    */   }
/*    */   
/*    */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */