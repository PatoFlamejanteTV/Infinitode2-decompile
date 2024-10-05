/*     */ package com.d.c.e;
/*     */ 
/*     */ import com.d.c.a.d;
/*     */ import com.d.i.v;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public final class c
/*     */   implements e
/*     */ {
/*     */   private String a;
/*     */   private String b;
/*     */   private d c;
/*     */   private int d;
/*  34 */   private final Map<d, List<v>> e = new HashMap<>();
/*     */   
/*     */   private int f;
/*     */   
/*     */   private int g;
/*     */   private int h;
/*     */   private int i;
/*     */   
/*     */   public c(int paramInt) {
/*  43 */     this.d = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/*  51 */     this.b = paramString;
/*  52 */     if (paramString.equals("first")) {
/*  53 */       this.h = 1; return;
/*     */     } 
/*  55 */     this.i = 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final d b() {
/*  60 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(d paramd) {
/*  69 */     if (this.c != null) {
/*  70 */       throw new IllegalStateException("Ruleset has already been set");
/*     */     }
/*  72 */     this.c = paramd;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int a() {
/*  77 */     return this.d;
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
/*     */   public final void b(String paramString) {
/*  89 */     this.a = paramString;
/*  90 */     this.g = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(d paramd, List<v> paramList) {
/*  98 */     this.e.put(paramd, paramList);
/*     */   }
/*     */   
/*     */   public final Map<d, List<v>> c() {
/* 102 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long d() {
/*     */     long l;
/* 113 */     return l = (l = (l = (l = 0x0L | this.g << 32L) | this.h << 24L) | this.i << 16L) | this.f;
/*     */   }
/*     */   
/*     */   public final boolean a(String paramString1, String paramString2) {
/* 117 */     if (this.a == null && this.b == null)
/* 118 */       return true; 
/* 119 */     if (this.a == null && this.b != null && (this.b
/* 120 */       .equals(paramString2) || (this.b
/* 121 */       .equals("right") && paramString2 != null && paramString2.equals("first"))))
/* 122 */       return true; 
/* 123 */     if (this.a != null && this.a.equals(paramString1) && this.b == null)
/* 124 */       return true; 
/* 125 */     if (this.a != null && this.a.equals(paramString1) && this.b != null && this.b
/* 126 */       .equals(paramString2)) {
/* 127 */       return true;
/*     */     }
/*     */     
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 138 */     this.f = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\e\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */