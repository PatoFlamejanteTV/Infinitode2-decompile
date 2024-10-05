/*     */ package com.d.m;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.util.HashMap;
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
/*     */ public final class h
/*     */ {
/*     */   private d a;
/*     */   private Object b;
/*     */   private int c;
/*     */   private int d;
/*     */   
/*     */   private h(d paramd, Object paramObject) {
/*  50 */     this.a = paramd;
/*  51 */     this.b = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h() {
/*  59 */     this(d.c, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
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
/*     */   public h(int paramInt1, int paramInt2, d paramd, Object paramObject) {
/*  76 */     this(paramd, paramObject);
/*  77 */     b(Math.max(1, paramInt2));
/*  78 */     a(Math.max(1, paramInt1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a() {
/*  85 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object d() {
/*  92 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Graphics2D paramGraphics2D) {
/* 102 */     paramGraphics2D.setRenderingHints(e());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map e() {
/*     */     HashMap<Object, Object> hashMap;
/* 114 */     (hashMap = new HashMap<>()).put(RenderingHints.KEY_INTERPOLATION, d());
/* 115 */     return hashMap;
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
/*     */   public final boolean a(int paramInt1, int paramInt2) {
/* 127 */     return (paramInt1 == b() && paramInt2 == c());
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
/*     */   public final int b() {
/* 142 */     return this.c;
/*     */   }
/*     */   
/*     */   public final int c() {
/* 146 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/* 150 */     this.c = paramInt;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/* 154 */     this.d = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */