/*     */ package com.a.a.b;
/*     */ 
/*     */ import com.a.a.b.g.h;
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
/*     */ public enum s
/*     */   implements h
/*     */ {
/*  30 */   a(false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   c(false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   b(false),
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
/*     */ 
/*     */ 
/*     */   
/*  87 */   d(false);
/*     */ 
/*     */   
/*     */   private final boolean e;
/*     */ 
/*     */   
/*     */   private final int f;
/*     */ 
/*     */ 
/*     */   
/*     */   s(boolean paramBoolean) {
/*  98 */     this.e = false;
/*  99 */     this.f = 1 << ordinal();
/*     */   }
/*     */   
/*     */   public final boolean a() {
/* 103 */     return this.e;
/*     */   } public final boolean a(int paramInt) {
/* 105 */     return ((paramInt & this.f) != 0);
/*     */   } public final int b() {
/* 107 */     return this.f;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */