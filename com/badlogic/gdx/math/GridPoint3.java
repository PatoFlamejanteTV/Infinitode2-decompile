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
/*     */ 
/*     */ public class GridPoint3
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5922187982746752830L;
/*     */   public int x;
/*     */   public int y;
/*     */   public int z;
/*     */   
/*     */   public GridPoint3() {}
/*     */   
/*     */   public GridPoint3(int paramInt1, int paramInt2, int paramInt3) {
/*  41 */     this.x = paramInt1;
/*  42 */     this.y = paramInt2;
/*  43 */     this.z = paramInt3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint3(GridPoint3 paramGridPoint3) {
/*  50 */     this.x = paramGridPoint3.x;
/*  51 */     this.y = paramGridPoint3.y;
/*  52 */     this.z = paramGridPoint3.z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint3 set(GridPoint3 paramGridPoint3) {
/*  61 */     this.x = paramGridPoint3.x;
/*  62 */     this.y = paramGridPoint3.y;
/*  63 */     this.z = paramGridPoint3.z;
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint3 set(int paramInt1, int paramInt2, int paramInt3) {
/*  75 */     this.x = paramInt1;
/*  76 */     this.y = paramInt2;
/*  77 */     this.z = paramInt3;
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst2(GridPoint3 paramGridPoint3) {
/*  84 */     int j = paramGridPoint3.x - this.x;
/*  85 */     int k = paramGridPoint3.y - this.y;
/*  86 */     int i = paramGridPoint3.z - this.z;
/*     */     
/*  88 */     return (j * j + k * k + i * i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst2(int paramInt1, int paramInt2, int paramInt3) {
/*  96 */     paramInt1 -= this.x;
/*  97 */     paramInt2 -= this.y;
/*  98 */     paramInt3 -= this.z;
/*     */     
/* 100 */     return (paramInt1 * paramInt1 + paramInt2 * paramInt2 + paramInt3 * paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst(GridPoint3 paramGridPoint3) {
/* 106 */     int j = paramGridPoint3.x - this.x;
/* 107 */     int k = paramGridPoint3.y - this.y;
/* 108 */     int i = paramGridPoint3.z - this.z;
/*     */     
/* 110 */     return (float)Math.sqrt((j * j + k * k + i * i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst(int paramInt1, int paramInt2, int paramInt3) {
/* 118 */     paramInt1 -= this.x;
/* 119 */     paramInt2 -= this.y;
/* 120 */     paramInt3 -= this.z;
/*     */     
/* 122 */     return (float)Math.sqrt((paramInt1 * paramInt1 + paramInt2 * paramInt2 + paramInt3 * paramInt3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint3 add(GridPoint3 paramGridPoint3) {
/* 130 */     this.x += paramGridPoint3.x;
/* 131 */     this.y += paramGridPoint3.y;
/* 132 */     this.z += paramGridPoint3.z;
/* 133 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint3 add(int paramInt1, int paramInt2, int paramInt3) {
/* 143 */     this.x += paramInt1;
/* 144 */     this.y += paramInt2;
/* 145 */     this.z += paramInt3;
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint3 sub(GridPoint3 paramGridPoint3) {
/* 154 */     this.x -= paramGridPoint3.x;
/* 155 */     this.y -= paramGridPoint3.y;
/* 156 */     this.z -= paramGridPoint3.z;
/* 157 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GridPoint3 sub(int paramInt1, int paramInt2, int paramInt3) {
/* 167 */     this.x -= paramInt1;
/* 168 */     this.y -= paramInt2;
/* 169 */     this.z -= paramInt3;
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GridPoint3 cpy() {
/* 175 */     return new GridPoint3(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 180 */     if (this == paramObject) return true; 
/* 181 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 182 */     paramObject = paramObject;
/* 183 */     return (this.x == ((GridPoint3)paramObject).x && this.y == ((GridPoint3)paramObject).y && this.z == ((GridPoint3)paramObject).z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 190 */     int i = 17 + this.x;
/* 191 */     i = i * 17 + this.y;
/*     */     
/* 193 */     return i = i * 17 + this.z;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     return "(" + this.x + ", " + this.y + ", " + this.z + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\GridPoint3.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */