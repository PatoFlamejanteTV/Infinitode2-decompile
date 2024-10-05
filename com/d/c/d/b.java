/*     */ package com.d.c.d;
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
/*     */ public final class b
/*     */   extends RuntimeException
/*     */ {
/*     */   private final k a;
/*     */   private final k[] b;
/*     */   private int c;
/*     */   private final String d;
/*     */   private boolean e;
/*     */   
/*     */   public b(String paramString, int paramInt) {
/*  34 */     this.a = null;
/*  35 */     this.b = null;
/*  36 */     this.c = paramInt;
/*  37 */     this.d = paramString;
/*     */   }
/*     */   
/*     */   public b(k paramk1, k paramk2, int paramInt) {
/*  41 */     this.a = paramk1;
/*  42 */     this.b = new k[] { paramk2 };
/*  43 */     this.c = paramInt;
/*  44 */     this.d = null;
/*     */   }
/*     */   
/*     */   public b(k paramk, k[] paramArrayOfk, int paramInt) {
/*  48 */     this.a = paramk;
/*  49 */     this.b = (k[])paramArrayOfk.clone();
/*  50 */     this.c = paramInt;
/*  51 */     this.d = null;
/*     */   }
/*     */   
/*     */   public final String getMessage() {
/*  55 */     if (this.d != null) {
/*  56 */       return this.d + " at line " + (this.c + 1) + ".";
/*     */     }
/*  58 */     String str = (this.a == null) ? "end of file" : this.a.b();
/*  59 */     return "Found " + str + " where " + 
/*  60 */       a(this.b) + " was expected at line " + (this.c + 1) + ".";
/*     */   }
/*     */ 
/*     */   
/*     */   private static String a(k[] paramArrayOfk) {
/*  65 */     if (paramArrayOfk.length == 1) {
/*  66 */       return paramArrayOfk[0].b();
/*     */     }
/*  68 */     StringBuilder stringBuilder = new StringBuilder();
/*  69 */     if (paramArrayOfk.length > 2) {
/*  70 */       stringBuilder.append("one of ");
/*     */     }
/*  72 */     for (byte b1 = 0; b1 < paramArrayOfk.length; b1++) {
/*  73 */       stringBuilder.append(paramArrayOfk[b1].b());
/*  74 */       if (b1 < paramArrayOfk.length - 2) {
/*  75 */         stringBuilder.append(", ");
/*  76 */       } else if (b1 == paramArrayOfk.length - 2) {
/*  77 */         if (paramArrayOfk.length > 2) {
/*  78 */           stringBuilder.append(", or ");
/*     */         } else {
/*  80 */           stringBuilder.append(" or ");
/*     */         } 
/*     */       } 
/*     */     } 
/*  84 */     return stringBuilder.toString();
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
/*     */   public final void a(int paramInt) {
/*  97 */     this.c = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean a() {
/* 101 */     return (this.a == k.aa);
/*     */   }
/*     */   
/*     */   public final boolean b() {
/* 105 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 109 */     this.e = true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */