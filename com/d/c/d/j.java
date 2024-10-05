/*     */ package com.d.c.d;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.e.ad;
/*     */ import com.d.i.e;
/*     */ import com.d.m.a;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public final class j
/*     */   implements d
/*     */ {
/*     */   private final short a;
/*     */   private final short b;
/*     */   private String c;
/*     */   private float d;
/*     */   private String[] e;
/*     */   private final String f;
/*     */   private g g;
/*     */   private c h;
/*     */   private short i;
/*     */   private k j;
/*     */   private List<j> k;
/*     */   private List<ad> l;
/*     */   private e m;
/*     */   
/*     */   public j(short paramShort, float paramFloat, String paramString) {
/*  61 */     this.a = paramShort;
/*  62 */     this.d = paramFloat;
/*  63 */     this.b = 1;
/*  64 */     this.f = paramString;
/*     */     
/*  66 */     if (paramShort == 1 && paramFloat != 0.0F) {
/*  67 */       this.i = 1; return;
/*     */     } 
/*  69 */     this.i = 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public j(g paramg) {
/*  74 */     this.a = 25;
/*  75 */     this.b = 1;
/*  76 */     this.f = paramg.toString();
/*  77 */     this.g = paramg;
/*     */     
/*  79 */     this.i = 3;
/*     */   }
/*     */   
/*     */   public j(short paramShort, String paramString1, String paramString2) {
/*  83 */     this.a = paramShort;
/*  84 */     this.c = paramString1;
/*     */ 
/*     */     
/*  87 */     this.b = this.c.equalsIgnoreCase("inherit") ? 0 : 1;
/*  88 */     this.f = paramString2;
/*     */     
/*  90 */     if (paramShort == 21) {
/*  91 */       this.i = 4; return;
/*     */     } 
/*  93 */     this.i = 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public j(c paramc) {
/*  98 */     this.a = 21;
/*  99 */     this.c = paramc.toString();
/* 100 */     this.b = this.c.equals("inherit") ? 0 : 1;
/* 101 */     this.f = paramc.toString();
/*     */     
/* 103 */     this.i = 4;
/* 104 */     this.h = paramc;
/*     */   }
/*     */   
/*     */   public j(List<j> paramList) {
/* 108 */     this.a = 0;
/* 109 */     this.b = 3;
/* 110 */     this.f = paramList.toString();
/*     */     
/* 112 */     this.k = paramList;
/* 113 */     this.i = 6;
/*     */   }
/*     */   
/*     */   public j(List<ad> paramList, byte paramByte) {
/* 117 */     this.a = 0;
/* 118 */     this.b = 3;
/* 119 */     this.f = paramList.toString();
/*     */     
/* 121 */     this.l = paramList;
/* 122 */     this.i = 8;
/*     */   }
/*     */   
/*     */   public j(e parame) {
/* 126 */     this.a = 0;
/* 127 */     this.b = 3;
/* 128 */     this.f = parame.toString();
/*     */     
/* 130 */     this.m = parame;
/* 131 */     this.i = 7;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float b() {
/* 136 */     return this.d;
/*     */   }
/*     */   
/*     */   public final float f() {
/* 140 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final short a() {
/* 145 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String c() {
/* 150 */     return this.c;
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
/*     */   public final String d() {
/* 163 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final short e() {
/* 168 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final g g() {
/* 176 */     return this.g;
/*     */   }
/*     */   
/*     */   public final c h() {
/* 180 */     return this.h;
/*     */   }
/*     */   
/*     */   public final void a(c paramc) {
/* 184 */     this.h = paramc;
/*     */   }
/*     */   
/*     */   public final short i() {
/* 188 */     return this.i;
/*     */   }
/*     */   
/*     */   public final k j() {
/* 192 */     return this.j;
/*     */   }
/*     */   
/*     */   public final void a(k paramk) {
/* 196 */     this.j = paramk;
/*     */   }
/*     */   
/*     */   public final String[] k() {
/* 200 */     return a.a(this.e);
/*     */   }
/*     */   
/*     */   public final void a(String[] paramArrayOfString) {
/* 204 */     this.e = a.a(paramArrayOfString);
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 208 */     return this.f;
/*     */   }
/*     */   
/*     */   public final List<j> l() {
/* 212 */     return new ArrayList<>(this.k);
/*     */   }
/*     */   
/*     */   public final List<ad> m() {
/* 216 */     return new ArrayList<>(this.l);
/*     */   }
/*     */   
/*     */   public final e n() {
/* 220 */     return this.m;
/*     */   }
/*     */   
/*     */   public final String o() {
/* 224 */     if (i() == 4) {
/* 225 */       if (this.h == null) {
/* 226 */         this.h = c.a(c());
/*     */       }
/* 228 */       return "I" + this.h.a;
/*     */     } 
/* 230 */     return d();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */