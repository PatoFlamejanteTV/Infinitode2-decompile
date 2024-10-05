/*     */ package org.a.c.c;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class g
/*     */   extends l
/*     */ {
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/*     */     long l1;
/*     */     d d1;
/*  44 */     int i = (d1 = a(paramd, paramInt)).b(j.ad, 1728);
/*  45 */     int j = d1.b(j.dk, 0);
/*  46 */     int k = paramd.a(j.bx, j.bw, 0);
/*  47 */     if (j > 0 && k > 0) {
/*     */ 
/*     */       
/*  50 */       j = k;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  55 */       j = Math.max(j, k);
/*     */     } 
/*     */ 
/*     */     
/*  59 */     k = d1.b(j.bP, 0);
/*  60 */     boolean bool2 = d1.b(j.aQ, false);
/*     */ 
/*     */     
/*  63 */     byte[] arrayOfByte = new byte[j = (i + 7) / 8 * j];
/*     */ 
/*     */ 
/*     */     
/*  67 */     if (k == 0) {
/*     */       
/*  69 */       l1 = bool2 ? 8L : 0L;
/*  70 */       k = 2;
/*     */ 
/*     */     
/*     */     }
/*  74 */     else if (k > 0) {
/*     */ 
/*     */       
/*  77 */       l1 = (l1 = bool2 ? 8L : 0L) | 0x1L;
/*  78 */       k = 3;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  83 */       l1 = bool2 ? 4L : 0L;
/*  84 */       k = 4;
/*     */     } 
/*     */ 
/*     */     
/*  88 */     a((e)(paramInputStream = new e(paramInputStream, i, k, 1, l1)), arrayOfByte);
/*     */     
/*     */     boolean bool1;
/*     */     
/*  92 */     if (!(bool1 = d1.b(j.B, false)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  98 */       a(arrayOfByte);
/*     */     }
/*     */     
/* 101 */     paramOutputStream.write(arrayOfByte);
/* 102 */     return new k(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(e parame, byte[] paramArrayOfbyte) {
/* 108 */     int i = 0;
/*     */     int j;
/* 110 */     while ((j = parame.read(paramArrayOfbyte, i, paramArrayOfbyte.length - i)) >= 0) {
/*     */ 
/*     */       
/* 113 */       if ((i = i + j) >= paramArrayOfbyte.length) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     parame.close();
/*     */   }
/*     */   private static void a(byte[] paramArrayOfbyte) {
/*     */     byte b;
/*     */     int i;
/* 123 */     for (b = 0, i = paramArrayOfbyte.length; b < i; b++)
/*     */     {
/* 125 */       paramArrayOfbyte[b] = (byte)(paramArrayOfbyte[b] ^ 0xFFFFFFFF);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 133 */     int j = paramd.j(j.ad);
/* 134 */     int i = paramd.j(j.dk);
/* 135 */     paramOutputStream = new f(paramOutputStream, j, i, 1);
/*     */     
/* 137 */     am.a(paramInputStream, paramOutputStream);
/* 138 */     paramInputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */