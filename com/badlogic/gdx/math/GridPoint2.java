/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class GridPoint2
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -4019969926331717380L;
/*     */   public int x;
/*     */   public int y;
/*     */   
/*     */   public GridPoint2() {}
/*     */   
/*     */   public GridPoint2(int paramInt1, int paramInt2) {
/*  39 */     this.x = paramInt1;
/*  40 */     this.y = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint2(GridPoint2 paramGridPoint2) {
/*  47 */     this.x = paramGridPoint2.x;
/*  48 */     this.y = paramGridPoint2.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint2 set(GridPoint2 paramGridPoint2) {
/*  57 */     this.x = paramGridPoint2.x;
/*  58 */     this.y = paramGridPoint2.y;
/*  59 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint2 set(int paramInt1, int paramInt2) {
/*  69 */     this.x = paramInt1;
/*  70 */     this.y = paramInt2;
/*  71 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst2(GridPoint2 paramGridPoint2) {
/*  77 */     int j = paramGridPoint2.x - this.x;
/*  78 */     int i = paramGridPoint2.y - this.y;
/*     */     
/*  80 */     return (j * j + i * i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst2(int paramInt1, int paramInt2) {
/*  87 */     paramInt1 -= this.x;
/*  88 */     paramInt2 -= this.y;
/*     */     
/*  90 */     return (paramInt1 * paramInt1 + paramInt2 * paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst(GridPoint2 paramGridPoint2) {
/*  96 */     int j = paramGridPoint2.x - this.x;
/*  97 */     int i = paramGridPoint2.y - this.y;
/*     */     
/*  99 */     return (float)Math.sqrt((j * j + i * i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst(int paramInt1, int paramInt2) {
/* 106 */     paramInt1 -= this.x;
/* 107 */     paramInt2 -= this.y;
/*     */     
/* 109 */     return (float)Math.sqrt((paramInt1 * paramInt1 + paramInt2 * paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint2 add(GridPoint2 paramGridPoint2) {
/* 117 */     this.x += paramGridPoint2.x;
/* 118 */     this.y += paramGridPoint2.y;
/* 119 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint2 add(int paramInt1, int paramInt2) {
/* 128 */     this.x += paramInt1;
/* 129 */     this.y += paramInt2;
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint2 sub(GridPoint2 paramGridPoint2) {
/* 138 */     this.x -= paramGridPoint2.x;
/* 139 */     this.y -= paramGridPoint2.y;
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint2 sub(int paramInt1, int paramInt2) {
/* 149 */     this.x -= paramInt1;
/* 150 */     this.y -= paramInt2;
/* 151 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GridPoint2 cpy() {
/* 156 */     return new GridPoint2(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 161 */     if (this == paramObject) return true; 
/* 162 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 163 */     paramObject = paramObject;
/* 164 */     return (this.x == ((GridPoint2)paramObject).x && this.y == ((GridPoint2)paramObject).y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 171 */     int i = 53 + this.x;
/*     */     
/* 173 */     return i = i * 53 + this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 178 */     return "(" + this.x + ", " + this.y + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\GridPoint2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */