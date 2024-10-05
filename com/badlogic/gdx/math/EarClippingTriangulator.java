/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.ShortArray;
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
/*     */ public class EarClippingTriangulator
/*     */ {
/*     */   private static final int CONCAVE = -1;
/*     */   private static final int CONVEX = 1;
/*  46 */   private final ShortArray indicesArray = new ShortArray();
/*     */   private short[] indices;
/*     */   private float[] vertices;
/*     */   private int vertexCount;
/*  50 */   private final IntArray vertexTypes = new IntArray();
/*  51 */   private final ShortArray triangles = new ShortArray();
/*     */ 
/*     */   
/*     */   public ShortArray computeTriangles(FloatArray paramFloatArray) {
/*  55 */     return computeTriangles(paramFloatArray.items, 0, paramFloatArray.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public ShortArray computeTriangles(float[] paramArrayOffloat) {
/*  60 */     return computeTriangles(paramArrayOffloat, 0, paramArrayOffloat.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortArray computeTriangles(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  68 */     this.vertices = paramArrayOffloat;
/*  69 */     int i = this.vertexCount = paramInt2 / 2;
/*  70 */     int j = paramInt1 / 2;
/*     */     
/*     */     ShortArray shortArray2;
/*  73 */     (shortArray2 = this.indicesArray).clear();
/*  74 */     shortArray2.ensureCapacity(i);
/*  75 */     shortArray2.size = i;
/*  76 */     short[] arrayOfShort = this.indices = shortArray2.items;
/*  77 */     if (GeometryUtils.isClockwise(paramArrayOffloat, paramInt1, paramInt2)) {
/*  78 */       for (short s = 0; s < i; s = (short)(s + 1))
/*  79 */         arrayOfShort[s] = (short)(j + s); 
/*     */     } else {
/*  81 */       for (byte b = 0; b < i; b++) {
/*  82 */         arrayOfShort[b] = (short)(j + paramInt1 - b);
/*     */       }
/*     */     } 
/*     */     IntArray intArray;
/*  86 */     (intArray = this.vertexTypes).clear();
/*  87 */     intArray.ensureCapacity(i);
/*  88 */     for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
/*  89 */       intArray.add(classifyVertex(paramInt1));
/*     */     }
/*     */     
/*     */     ShortArray shortArray1;
/*  93 */     (shortArray1 = this.triangles).clear();
/*  94 */     shortArray1.ensureCapacity(Math.max(0, i - 2) * 3);
/*  95 */     triangulate();
/*  96 */     return shortArray1;
/*     */   }
/*     */   
/*     */   private void triangulate() {
/* 100 */     int[] arrayOfInt = this.vertexTypes.items;
/*     */     
/* 102 */     while (this.vertexCount > 3) {
/* 103 */       int i = findEarTip();
/* 104 */       cutEarTip(i);
/*     */ 
/*     */       
/* 107 */       int j = previousIndex(i);
/* 108 */       i = (i == this.vertexCount) ? 0 : i;
/* 109 */       arrayOfInt[j] = classifyVertex(j);
/* 110 */       arrayOfInt[i] = classifyVertex(i);
/*     */     } 
/*     */     
/* 113 */     if (this.vertexCount == 3) {
/* 114 */       ShortArray shortArray = this.triangles;
/* 115 */       short[] arrayOfShort = this.indices;
/* 116 */       shortArray.add(arrayOfShort[0]);
/* 117 */       shortArray.add(arrayOfShort[1]);
/* 118 */       shortArray.add(arrayOfShort[2]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int classifyVertex(int paramInt) {
/*     */     short[] arrayOfShort;
/* 125 */     int i = (arrayOfShort = this.indices)[previousIndex(paramInt)] << 1;
/* 126 */     int j = arrayOfShort[paramInt] << 1;
/* 127 */     paramInt = arrayOfShort[nextIndex(paramInt)] << 1;
/*     */     float[] arrayOfFloat;
/* 129 */     return computeSpannedAreaSign((arrayOfFloat = this.vertices)[i], arrayOfFloat[i + 1], arrayOfFloat[j], arrayOfFloat[j + 1], arrayOfFloat[paramInt], arrayOfFloat[paramInt + 1]);
/*     */   }
/*     */ 
/*     */   
/*     */   private int findEarTip() {
/* 134 */     int i = this.vertexCount;
/* 135 */     for (byte b1 = 0; b1 < i; b1++) {
/* 136 */       if (isEarTip(b1)) return b1;
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     int[] arrayOfInt = this.vertexTypes.items;
/* 146 */     for (byte b2 = 0; b2 < i; b2++) {
/* 147 */       if (arrayOfInt[b2] != -1) return b2; 
/* 148 */     }  return 0;
/*     */   }
/*     */   
/*     */   private boolean isEarTip(int paramInt) {
/*     */     int[] arrayOfInt;
/* 153 */     if ((arrayOfInt = this.vertexTypes.items)[paramInt] == -1) return false;
/*     */     
/* 155 */     int i = previousIndex(paramInt);
/* 156 */     int j = nextIndex(paramInt);
/*     */     short[] arrayOfShort;
/* 158 */     int k = (arrayOfShort = this.indices)[i] << 1;
/* 159 */     paramInt = arrayOfShort[paramInt] << 1;
/* 160 */     int m = arrayOfShort[j] << 1;
/*     */     
/* 162 */     float arrayOfFloat[], f4 = (arrayOfFloat = this.vertices)[k], f2 = arrayOfFloat[k + 1];
/* 163 */     float f5 = arrayOfFloat[paramInt], f1 = arrayOfFloat[paramInt + 1];
/* 164 */     float f6 = arrayOfFloat[m], f3 = arrayOfFloat[m + 1];
/*     */ 
/*     */ 
/*     */     
/* 168 */     for (j = nextIndex(j); j != i; j = nextIndex(j)) {
/*     */ 
/*     */       
/* 171 */       if (arrayOfInt[j] != 1) {
/* 172 */         int n = arrayOfShort[j] << 1;
/* 173 */         float f8 = arrayOfFloat[n];
/* 174 */         float f7 = arrayOfFloat[n + 1];
/*     */ 
/*     */ 
/*     */         
/* 178 */         if (computeSpannedAreaSign(f6, f3, f4, f2, f8, f7) >= 0 && 
/* 179 */           computeSpannedAreaSign(f4, f2, f5, f1, f8, f7) >= 0 && 
/* 180 */           computeSpannedAreaSign(f5, f1, f6, f3, f8, f7) >= 0) return false;
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     return true;
/*     */   }
/*     */   
/*     */   private void cutEarTip(int paramInt) {
/* 189 */     short[] arrayOfShort = this.indices;
/*     */     
/*     */     ShortArray shortArray;
/* 192 */     (shortArray = this.triangles).add(arrayOfShort[previousIndex(paramInt)]);
/* 193 */     shortArray.add(arrayOfShort[paramInt]);
/* 194 */     shortArray.add(arrayOfShort[nextIndex(paramInt)]);
/*     */     
/* 196 */     this.indicesArray.removeIndex(paramInt);
/* 197 */     this.vertexTypes.removeIndex(paramInt);
/* 198 */     this.vertexCount--;
/*     */   }
/*     */   
/*     */   private int previousIndex(int paramInt) {
/* 202 */     return ((paramInt == 0) ? this.vertexCount : paramInt) - 1;
/*     */   }
/*     */   
/*     */   private int nextIndex(int paramInt) {
/* 206 */     return (paramInt + 1) % this.vertexCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int computeSpannedAreaSign(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 213 */     return (int)Math.signum(paramFloat1 = (paramFloat1 = (paramFloat1 = paramFloat1 * (paramFloat6 - paramFloat4)) + paramFloat3 * (paramFloat2 - paramFloat6)) + paramFloat5 * (paramFloat4 - paramFloat2));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\EarClippingTriangulator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */