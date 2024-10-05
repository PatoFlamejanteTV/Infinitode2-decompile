/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import java.util.Arrays;
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
/*     */ public class QuadTreeFloat
/*     */   implements Pool.Poolable
/*     */ {
/*     */   public static final int VALUE = 0;
/*     */   public static final int X = 1;
/*     */   public static final int Y = 2;
/*     */   public static final int DISTSQR = 3;
/*     */   
/*  29 */   private static final Pool<QuadTreeFloat> pool = new Pool<QuadTreeFloat>(128, 4096) {
/*     */       protected Object newObject() {
/*  31 */         return new QuadTreeFloat();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public final int maxValues;
/*     */   
/*     */   public final int maxDepth;
/*     */   
/*     */   public float x;
/*     */   
/*     */   public float y;
/*     */   
/*     */   public float width;
/*     */   public float height;
/*     */   
/*     */   public QuadTreeFloat() {
/*  48 */     this(16, 8);
/*     */   }
/*     */   public int depth; @Null
/*     */   public QuadTreeFloat nw; @Null
/*     */   public QuadTreeFloat ne; @Null
/*     */   public QuadTreeFloat sw; @Null
/*     */   public QuadTreeFloat se; public float[] values; public int count;
/*     */   public QuadTreeFloat(int paramInt1, int paramInt2) {
/*  56 */     this.maxValues = paramInt1 * 3;
/*  57 */     this.maxDepth = paramInt2;
/*  58 */     this.values = new float[this.maxValues];
/*     */   }
/*     */   
/*     */   public void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  62 */     this.x = paramFloat1;
/*  63 */     this.y = paramFloat2;
/*  64 */     this.width = paramFloat3;
/*  65 */     this.height = paramFloat4;
/*     */   }
/*     */   
/*     */   public void add(float paramFloat1, float paramFloat2, float paramFloat3) {
/*     */     int i;
/*  70 */     if ((i = this.count) == -1) {
/*  71 */       addToChild(paramFloat1, paramFloat2, paramFloat3);
/*     */       return;
/*     */     } 
/*  74 */     if (this.depth < this.maxDepth) {
/*  75 */       if (i == this.maxValues) {
/*  76 */         split(paramFloat1, paramFloat2, paramFloat3);
/*     */         return;
/*     */       } 
/*  79 */     } else if (i == this.values.length) {
/*  80 */       this.values = Arrays.copyOf(this.values, growValues());
/*  81 */     }  this.values[i] = paramFloat1;
/*  82 */     this.values[i + 1] = paramFloat2;
/*  83 */     this.values[i + 2] = paramFloat3;
/*  84 */     this.count += 3;
/*     */   }
/*     */   
/*     */   private void split(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  88 */     float[] arrayOfFloat = this.values;
/*  89 */     for (byte b = 0; b < this.maxValues; b += 3) {
/*  90 */       addToChild(arrayOfFloat[b], arrayOfFloat[b + 1], arrayOfFloat[b + 2]);
/*     */     }
/*  92 */     this.count = -1;
/*  93 */     addToChild(paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */   
/*     */   private void addToChild(float paramFloat1, float paramFloat2, float paramFloat3) {
/*     */     QuadTreeFloat quadTreeFloat;
/*  98 */     float f1 = this.width / 2.0F, f2 = this.height / 2.0F;
/*  99 */     if (paramFloat2 < this.x + f1) {
/* 100 */       if (paramFloat3 < this.y + f2) {
/* 101 */         quadTreeFloat = (this.sw != null) ? this.sw : (this.sw = obtainChild(this.x, this.y, f1, f2, this.depth + 1));
/*     */       } else {
/* 103 */         quadTreeFloat = (this.nw != null) ? this.nw : (this.nw = obtainChild(this.x, this.y + f2, quadTreeFloat, f2, this.depth + 1));
/*     */       } 
/* 105 */     } else if (paramFloat3 < this.y + f2) {
/* 106 */       quadTreeFloat = (this.se != null) ? this.se : (this.se = obtainChild(this.x + quadTreeFloat, this.y, quadTreeFloat, f2, this.depth + 1));
/*     */     } else {
/* 108 */       quadTreeFloat = (this.ne != null) ? this.ne : (this.ne = obtainChild(this.x + quadTreeFloat, this.y + f2, quadTreeFloat, f2, this.depth + 1));
/*     */     } 
/* 110 */     quadTreeFloat.add(paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */   
/*     */   private QuadTreeFloat obtainChild(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt) {
/*     */     QuadTreeFloat quadTreeFloat;
/* 115 */     (quadTreeFloat = pool.obtain()).x = paramFloat1;
/* 116 */     quadTreeFloat.y = paramFloat2;
/* 117 */     quadTreeFloat.width = paramFloat3;
/* 118 */     quadTreeFloat.height = paramFloat4;
/* 119 */     quadTreeFloat.depth = paramInt;
/* 120 */     return quadTreeFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int growValues() {
/* 126 */     return this.count + 30;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void query(float paramFloat1, float paramFloat2, float paramFloat3, FloatArray paramFloatArray) {
/* 132 */     query(paramFloat1, paramFloat2, paramFloat3 * paramFloat3, paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat3 * 2.0F, paramFloatArray);
/*     */   }
/*     */   private void query(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, FloatArray paramFloatArray) {
/*     */     float[] arrayOfFloat;
/*     */     byte b;
/* 137 */     if (this.x >= paramFloat4 + paramFloat6 || this.x + this.width <= paramFloat4 || this.y >= paramFloat5 + paramFloat6 || this.y + this.height <= paramFloat5)
/*     */       return;  int i;
/* 139 */     if ((i = this.count) != -1) {
/* 140 */       arrayOfFloat = this.values;
/* 141 */       for (b = 1; b < i; b += 3) {
/* 142 */         paramFloat6 = arrayOfFloat[b]; float f1 = arrayOfFloat[b + 1];
/* 143 */         float f2 = paramFloat6 - paramFloat1, f3 = f1 - paramFloat2;
/*     */         
/* 145 */         if ((f2 = f2 * f2 + f3 * f3) <= paramFloat3) {
/* 146 */           paramFloatArray.add(arrayOfFloat[b - 1]);
/* 147 */           paramFloatArray.add(paramFloat6);
/* 148 */           paramFloatArray.add(f1);
/* 149 */           paramFloatArray.add(f2);
/*     */         } 
/*     */       }  return;
/*     */     } 
/* 153 */     if (this.nw != null) this.nw.query(paramFloat1, paramFloat2, paramFloat3, arrayOfFloat, b, paramFloat6, paramFloatArray); 
/* 154 */     if (this.sw != null) this.sw.query(paramFloat1, paramFloat2, paramFloat3, arrayOfFloat, b, paramFloat6, paramFloatArray); 
/* 155 */     if (this.ne != null) this.ne.query(paramFloat1, paramFloat2, paramFloat3, arrayOfFloat, b, paramFloat6, paramFloatArray); 
/* 156 */     if (this.se != null) this.se.query(paramFloat1, paramFloat2, paramFloat3, arrayOfFloat, b, paramFloat6, paramFloatArray);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void query(Rectangle paramRectangle, FloatArray paramFloatArray) {
/* 163 */     if (this.x >= paramRectangle.x + paramRectangle.width || this.x + this.width <= paramRectangle.x || this.y >= paramRectangle.y + paramRectangle.height || this.y + this.height <= paramRectangle.y)
/*     */       return;  int i;
/* 165 */     if ((i = this.count) != -1) {
/* 166 */       float[] arrayOfFloat = this.values;
/* 167 */       for (byte b = 1; b < i; b += 3) {
/* 168 */         float f1 = arrayOfFloat[b], f2 = arrayOfFloat[b + 1];
/* 169 */         if (paramRectangle.contains(f1, f2)) {
/* 170 */           paramFloatArray.add(arrayOfFloat[b - 1]);
/* 171 */           paramFloatArray.add(f1);
/* 172 */           paramFloatArray.add(f2);
/*     */         } 
/*     */       }  return;
/*     */     } 
/* 176 */     if (this.nw != null) this.nw.query(paramRectangle, paramFloatArray); 
/* 177 */     if (this.sw != null) this.sw.query(paramRectangle, paramFloatArray); 
/* 178 */     if (this.ne != null) this.ne.query(paramRectangle, paramFloatArray); 
/* 179 */     if (this.se != null) this.se.query(paramRectangle, paramFloatArray);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nearest(float paramFloat1, float paramFloat2, FloatArray paramFloatArray) {
/* 189 */     paramFloatArray.clear();
/* 190 */     paramFloatArray.add(0.0F);
/* 191 */     paramFloatArray.add(0.0F);
/* 192 */     paramFloatArray.add(0.0F);
/* 193 */     paramFloatArray.add(Float.POSITIVE_INFINITY);
/* 194 */     findNearestInternal(paramFloat1, paramFloat2, paramFloatArray);
/* 195 */     float f1 = paramFloatArray.first(), f2 = paramFloatArray.get(1), f3 = paramFloatArray.get(2); float f4;
/*     */     boolean bool;
/* 197 */     if (!(bool = ((f4 = paramFloatArray.get(3)) != Float.POSITIVE_INFINITY) ? true : false))
/*     */     {
/* 199 */       f4 = (f4 = Math.max(this.width, this.height)) * f4;
/*     */     }
/*     */ 
/*     */     
/* 203 */     paramFloatArray.clear();
/* 204 */     query(paramFloat1, paramFloat2, (float)Math.sqrt(f4), paramFloatArray); byte b; int i;
/* 205 */     for (b = 3, i = paramFloatArray.size; b < i; b += 4) {
/*     */       float f;
/* 207 */       if ((f = paramFloatArray.get(b)) < f4) {
/* 208 */         f4 = f;
/* 209 */         f1 = paramFloatArray.get(b - 3);
/* 210 */         f2 = paramFloatArray.get(b - 2);
/* 211 */         f3 = paramFloatArray.get(b - 1);
/*     */       } 
/*     */     } 
/* 214 */     if (!bool && paramFloatArray.isEmpty()) return false; 
/* 215 */     paramFloatArray.clear();
/* 216 */     paramFloatArray.add(f1);
/* 217 */     paramFloatArray.add(f2);
/* 218 */     paramFloatArray.add(f3);
/* 219 */     paramFloatArray.add(f4);
/* 220 */     return true;
/*     */   }
/*     */   
/*     */   private void findNearestInternal(float paramFloat1, float paramFloat2, FloatArray paramFloatArray) {
/* 224 */     if (this.x >= paramFloat1 || this.x + this.width <= paramFloat1 || this.y >= paramFloat2 || this.y + this.height <= paramFloat2)
/*     */       return; 
/*     */     int i;
/* 227 */     if ((i = this.count) != -1) {
/* 228 */       float f1 = paramFloatArray.first(), f2 = paramFloatArray.get(1), f3 = paramFloatArray.get(2), f4 = paramFloatArray.get(3);
/* 229 */       float[] arrayOfFloat = this.values;
/* 230 */       for (byte b = 1; b < i; b += 3) {
/* 231 */         float f5 = arrayOfFloat[b], f6 = arrayOfFloat[b + 1];
/* 232 */         float f7 = f5 - paramFloat1, f8 = f6 - paramFloat2;
/*     */         
/* 234 */         if ((f7 = f7 * f7 + f8 * f8) < f4) {
/* 235 */           f4 = f7;
/* 236 */           f1 = arrayOfFloat[b - 1];
/* 237 */           f2 = f5;
/* 238 */           f3 = f6;
/*     */         } 
/*     */       } 
/* 241 */       paramFloatArray.set(0, f1);
/* 242 */       paramFloatArray.set(1, f2);
/* 243 */       paramFloatArray.set(2, f3);
/* 244 */       paramFloatArray.set(3, f4); return;
/*     */     } 
/* 246 */     if (this.nw != null) this.nw.findNearestInternal(paramFloat1, paramFloat2, paramFloatArray); 
/* 247 */     if (this.sw != null) this.sw.findNearestInternal(paramFloat1, paramFloat2, paramFloatArray); 
/* 248 */     if (this.ne != null) this.ne.findNearestInternal(paramFloat1, paramFloat2, paramFloatArray); 
/* 249 */     if (this.se != null) this.se.findNearestInternal(paramFloat1, paramFloat2, paramFloatArray);
/*     */   
/*     */   }
/*     */   
/*     */   public void reset() {
/* 254 */     if (this.count == -1) {
/* 255 */       if (this.nw != null) {
/* 256 */         pool.free(this.nw);
/* 257 */         this.nw = null;
/*     */       } 
/* 259 */       if (this.sw != null) {
/* 260 */         pool.free(this.sw);
/* 261 */         this.sw = null;
/*     */       } 
/* 263 */       if (this.ne != null) {
/* 264 */         pool.free(this.ne);
/* 265 */         this.ne = null;
/*     */       } 
/* 267 */       if (this.se != null) {
/* 268 */         pool.free(this.se);
/* 269 */         this.se = null;
/*     */       } 
/*     */     } 
/* 272 */     this.count = 0;
/* 273 */     if (this.values.length > this.maxValues) this.values = new float[this.maxValues]; 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\QuadTreeFloat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */