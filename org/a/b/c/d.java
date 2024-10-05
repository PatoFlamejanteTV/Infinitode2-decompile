/*     */ package org.a.b.c;
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
/*     */ public final class d
/*     */ {
/*     */   private byte[] a;
/*     */   private int b;
/*     */   private int c;
/*  32 */   private int d = 0;
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
/*     */   public final int a() {
/*  48 */     return this.d;
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
/*     */   final void a(byte[] paramArrayOfbyte) {
/*  67 */     this.c = a.a(paramArrayOfbyte, paramArrayOfbyte.length);
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
/*     */   final void b(byte[] paramArrayOfbyte) {
/*  85 */     this.a = paramArrayOfbyte;
/*  86 */     this.d = this.a.length;
/*  87 */     this.b = a.a(paramArrayOfbyte, paramArrayOfbyte.length);
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
/*     */   public final boolean a(byte[] paramArrayOfbyte, int paramInt) {
/* 104 */     if (paramInt == this.d) {
/*     */       int i;
/*     */       
/* 107 */       if ((i = a.a(paramArrayOfbyte, paramInt)) >= this.b && i <= this.c)
/*     */       {
/* 109 */         return true;
/*     */       }
/*     */     } 
/* 112 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */