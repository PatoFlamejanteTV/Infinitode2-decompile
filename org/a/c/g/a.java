/*     */ package org.a.c.g;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.OutputStream;
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
/*     */ public final class a
/*     */   extends FilterOutputStream
/*     */ {
/*  33 */   private static byte[] a = new byte[] { 13, 10 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private static byte[] b = new byte[] { 10 };
/*     */ 
/*     */   
/*  46 */   private long c = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean d = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(OutputStream paramOutputStream) {
/*  58 */     super(paramOutputStream);
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   public final long a() {
/*  94 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean d() {
/* 104 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 113 */     this.d = paramBoolean;
/*     */   }
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
/*     */   public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 128 */     a(false);
/* 129 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 130 */     this.c += paramInt2;
/*     */   }
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
/*     */   public final void write(int paramInt) {
/* 143 */     a(false);
/* 144 */     this.out.write(paramInt);
/* 145 */     this.c++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b() {
/* 155 */     write(a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c() {
/* 165 */     if (!d()) {
/*     */       
/* 167 */       write(b);
/* 168 */       a(true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */