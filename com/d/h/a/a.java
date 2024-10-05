/*     */ package com.d.h.a;
/*     */ 
/*     */ import java.awt.geom.Point2D;
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
/*     */ public final class a
/*     */ {
/*     */   private static boolean a = false;
/*  24 */   private List<Point2D.Float> b = new ArrayList<>(); public a(List<Point2D.Float> paramList) {
/*  25 */     for (Point2D.Float float_ : paramList) {
/*  26 */       this.b.add(new Point2D.Float(float_.x, float_.y));
/*     */     }
/*  28 */     this.c = new ArrayList<>();
/*  29 */     this.d = new ArrayList<>();
/*     */     
/*  31 */     d();
/*  32 */     c();
/*     */   }
/*     */   
/*     */   private List<Point2D.Float> c;
/*     */   private List<b> d;
/*     */   private boolean e;
/*     */   
/*     */   private void c() {
/*  40 */     if (this.b.size() <= 3) {
/*  41 */       if (this.b.size() == 3) {
/*  42 */         this.d.add(new b(this.b.get(0), this.b.get(1), this.b.get(2)));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  53 */     for (byte b = 0; b < this.b.size() - 1; b++) {
/*  54 */       Point2D.Float float_2, float_3, float_1 = this.b.get(b);
/*  55 */       Point2D.Float float_4 = this.b.get(b + 1);
/*     */       
/*  57 */       float_4.x -= float_1.x;
/*  58 */       float_4.y -= float_1.y;
/*     */ 
/*     */       
/*  61 */       if (b == this.b.size() - 2) {
/*  62 */         float_3 = this.b.get(0);
/*     */       } else {
/*  64 */         float_3 = this.b.get(b + 2);
/*     */       } 
/*     */       
/*     */       float f;
/*  68 */       if (((f = float_3.x * float_2.y - float_3.y * float_2.x + float_2.x * float_1.y - float_2.y * float_1.x) > 0.0F && this.e) || (f <= 0.0F && !this.e)) {
/*  69 */         this.c.add(float_4);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/*     */     Point2D.Float float_1, float_3;
/*  82 */     if (this.b.size() < 3) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  87 */     byte b1 = 0;
/*  88 */     Point2D.Float float_2 = this.b.get(0);
/*  89 */     for (byte b2 = 1; b2 < this.b.size(); b2++) {
/*  90 */       if (((Point2D.Float)this.b.get(b2)).x < float_2.x) {
/*  91 */         float_2 = this.b.get(b2);
/*  92 */         b1 = b2;
/*  93 */       } else if (((Point2D.Float)this.b.get(b2)).x == float_2.x && ((Point2D.Float)this.b.get(b2)).y > float_2.y) {
/*  94 */         float_2 = this.b.get(b2);
/*  95 */         b1 = b2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 101 */     if (b1 == 0) {
/* 102 */       float_3 = this.b.get(this.b.size() - 1);
/*     */     } else {
/* 104 */       float_3 = this.b.get(b1 - 1);
/* 105 */     }  float_2 = new Point2D.Float(float_2.x - float_3.x, float_2.y - float_3.y);
/*     */ 
/*     */     
/* 108 */     if (b1 == this.b.size() - 1) {
/* 109 */       float_1 = this.b.get(0);
/*     */     } else {
/* 111 */       float_1 = this.b.get(float_1 + 1);
/*     */     } 
/*     */     
/* 114 */     float f = float_1.x * float_2.y - float_1.y * float_2.x + float_2.x * float_3.y - float_2.y * float_3.x;
/*     */ 
/*     */     
/* 117 */     this.e = (f <= 0.0F);
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
/*     */   private boolean a(Point2D.Float paramFloat1, Point2D.Float paramFloat2, Point2D.Float paramFloat3) {
/* 129 */     if (!b(paramFloat1, paramFloat2, paramFloat3)) {
/* 130 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 134 */     for (Point2D.Float float_ : this.c) {
/* 135 */       if (b.a(paramFloat1, paramFloat2, paramFloat3, float_))
/* 136 */         return false; 
/*     */     } 
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b(Point2D.Float paramFloat1, Point2D.Float paramFloat2, Point2D.Float paramFloat3) {
/* 146 */     paramFloat2 = new Point2D.Float(paramFloat2.x - paramFloat1.x, paramFloat2.y - paramFloat1.y);
/*     */     float f;
/* 148 */     if (((f = paramFloat3.x * paramFloat2.y - paramFloat3.y * paramFloat2.x + paramFloat2.x * paramFloat1.y - paramFloat2.y * paramFloat1.x) <= 0.0F || !this.e) && (f > 0.0F || this.e)) return true;  return false;
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
/*     */   private int a(int paramInt1, int paramInt2) {
/* 163 */     if (paramInt1 + paramInt2 >= this.b.size()) {
/* 164 */       paramInt1 = this.b.size() - paramInt1 + paramInt2;
/*     */     }
/* 166 */     else if (paramInt1 + paramInt2 < 0) {
/* 167 */       paramInt1 = this.b.size() + paramInt1 + paramInt2;
/*     */     } else {
/* 169 */       paramInt1 += paramInt2;
/*     */     } 
/*     */ 
/*     */     
/* 173 */     return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/* 180 */     if (this.b.size() <= 3) {
/*     */       return;
/*     */     }
/* 183 */     this.d.clear();
/* 184 */     int i = 1;
/*     */     
/* 186 */     while (this.b.size() > 3) {
/* 187 */       if (a(this.b.get(a(i, -1)), this.b.get(i), this.b.get(a(i, 1)))) {
/*     */         
/* 189 */         this.d.add(new b(this.b.get(a(i, -1)), this.b.get(i), this.b
/* 190 */               .get(a(i, 1))));
/* 191 */         this.b.remove(this.b.get(i));
/* 192 */         i = a(i, -1);
/*     */         continue;
/*     */       } 
/* 195 */       i = a(i, 1);
/*     */     } 
/*     */ 
/*     */     
/* 199 */     this.d.add(new b(this.b.get(0), this.b.get(1), this.b.get(2)));
/*     */   }
/*     */ 
/*     */   
/*     */   public final List<b> b() {
/* 204 */     return this.d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */