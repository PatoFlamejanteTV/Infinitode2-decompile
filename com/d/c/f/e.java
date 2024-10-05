/*     */ package com.d.c.f;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.g;
/*     */ import com.d.h.w;
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
/*     */ public abstract class e
/*     */   implements g
/*     */ {
/*     */   private String a;
/*     */   private short b;
/*     */   
/*     */   protected e(a parama, short paramShort, String paramString1, String paramString2) {
/*  42 */     this.b = paramShort;
/*     */     
/*  44 */     if (paramString1 == null) {
/*  45 */       throw new w.a("CSSValue for '" + parama + "' is null after resolving CSS identifier for value '" + paramString2 + "'");
/*     */     }
/*     */ 
/*     */     
/*  49 */     this.a = a(paramString1, paramString2);
/*     */   }
/*     */   
/*     */   private String a(String paramString1, String paramString2) {
/*  53 */     switch (this.b) {
/*     */       case 19:
/*     */       case 20:
/*     */       case 21:
/*     */       case 22:
/*  58 */         return (paramString2 == null) ? paramString1 : paramString2;
/*     */     } 
/*  60 */     return paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  66 */     return this.a;
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
/*     */   public final short i() {
/*  78 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float b() {
/*  86 */     throw new w.a("asFloat() needs to be overridden in subclass.");
/*     */   }
/*     */   
/*     */   public g c() {
/*  90 */     throw new w.a("asColor() needs to be overridden in subclass.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float a(a parama, float paramFloat, d paramd) {
/*  98 */     throw new w.a("getFloatProportionalTo() needs to be overridden in subclass.");
/*     */   }
/*     */   
/*     */   public final String d() {
/* 102 */     return a();
/*     */   }
/*     */   public String[] e() {
/* 105 */     throw new w.a("asStringArray() needs to be overridden in subclass.");
/*     */   }
/*     */   public final c f() {
/* 108 */     throw new w.a("asIdentValue() needs to be overridden in subclass.");
/*     */   }
/*     */   public boolean g() {
/* 111 */     throw new w.a("hasAbsoluteUnit() needs to be overridden in subclass.");
/*     */   }
/*     */   public final boolean h() {
/* 114 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */