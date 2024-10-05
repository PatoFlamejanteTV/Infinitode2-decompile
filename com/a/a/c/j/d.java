/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.b;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */   extends u
/*     */ {
/*  19 */   private static d a = new d(new byte[0]);
/*     */   
/*     */   private byte[] b;
/*     */ 
/*     */   
/*     */   private d(byte[] paramArrayOfbyte) {
/*  25 */     this.b = paramArrayOfbyte;
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
/*     */   public static d a(byte[] paramArrayOfbyte) {
/*  40 */     if (paramArrayOfbyte == null) {
/*  41 */       return null;
/*     */     }
/*  43 */     if (paramArrayOfbyte.length == 0) {
/*  44 */       return a;
/*     */     }
/*  46 */     return new d(paramArrayOfbyte);
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
/*     */   public final m d() {
/*  63 */     return m.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o p() {
/*  72 */     return o.g;
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
/*     */   public final String i() {
/*  89 */     return b.a().a(this.b, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh, aa paramaa) {
/*  96 */     paramh.a(paramaa.c().v(), this.b, 0, this.b.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 103 */     if (paramObject == this) return true; 
/* 104 */     if (paramObject == null) return false; 
/* 105 */     if (!(paramObject instanceof d)) {
/* 106 */       return false;
/*     */     }
/* 108 */     return Arrays.equals(((d)paramObject).b, this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 113 */     return (this.b == null) ? -1 : this.b.length;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */