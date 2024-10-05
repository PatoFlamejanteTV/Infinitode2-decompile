/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CumulativeDistribution<T>
/*     */ {
/*     */   public class CumulativeValue
/*     */   {
/*     */     public T value;
/*     */     public float frequency;
/*     */     public float interval;
/*     */     
/*     */     public CumulativeValue(T param1T, float param1Float1, float param1Float2) {
/*  21 */       this.value = param1T;
/*  22 */       this.frequency = param1Float1;
/*  23 */       this.interval = param1Float2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  30 */   private Array<CumulativeValue> values = new Array(false, 10, CumulativeValue.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(T paramT, float paramFloat) {
/*  35 */     this.values.add(new CumulativeValue(paramT, 0.0F, paramFloat));
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(T paramT) {
/*  40 */     this.values.add(new CumulativeValue(paramT, 0.0F, 0.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public void generate() {
/*  45 */     float f = 0.0F;
/*  46 */     for (byte b = 0; b < this.values.size; b++) {
/*  47 */       f += (((CumulativeValue[])this.values.items)[b]).interval;
/*  48 */       (((CumulativeValue[])this.values.items)[b]).frequency = f;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateNormalized() {
/*  54 */     float f1 = 0.0F;
/*  55 */     for (byte b1 = 0; b1 < this.values.size; b1++) {
/*  56 */       f1 += (((CumulativeValue[])this.values.items)[b1]).interval;
/*     */     }
/*  58 */     float f2 = 0.0F;
/*  59 */     for (byte b2 = 0; b2 < this.values.size; b2++) {
/*  60 */       f2 += (((CumulativeValue[])this.values.items)[b2]).interval / f1;
/*  61 */       (((CumulativeValue[])this.values.items)[b2]).frequency = f2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateUniform() {
/*  67 */     float f = 1.0F / this.values.size;
/*  68 */     for (byte b = 0; b < this.values.size; b++) {
/*     */       
/*  70 */       (((CumulativeValue[])this.values.items)[b]).interval = f;
/*  71 */       (((CumulativeValue[])this.values.items)[b]).frequency = (b + 1) * f;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T value(float paramFloat) {
/*  80 */     int i = this.values.size - 1, j = 0;
/*  81 */     while (j <= i) {
/*  82 */       int k = j + (i - j) / 2;
/*  83 */       CumulativeValue cumulativeValue = ((CumulativeValue[])this.values.items)[k];
/*  84 */       if (paramFloat < cumulativeValue.frequency) {
/*  85 */         i = k - 1; continue;
/*  86 */       }  if (paramFloat > cumulativeValue.frequency) {
/*  87 */         j = k + 1;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  92 */     return (((CumulativeValue[])this.values.items)[j]).value;
/*     */   }
/*     */ 
/*     */   
/*     */   public T value() {
/*  97 */     return value(MathUtils.random());
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 102 */     return this.values.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getInterval(int paramInt) {
/* 107 */     return (((CumulativeValue[])this.values.items)[paramInt]).interval;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getValue(int paramInt) {
/* 112 */     return (((CumulativeValue[])this.values.items)[paramInt]).value;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInterval(T paramT, float paramFloat) {
/* 117 */     for (Array.ArrayIterator<CumulativeValue> arrayIterator = this.values.iterator(); arrayIterator.hasNext();) {
/* 118 */       if ((cumulativeValue = arrayIterator.next()).value == paramT) {
/* 119 */         cumulativeValue.interval = paramFloat;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setInterval(int paramInt, float paramFloat) {
/* 126 */     (((CumulativeValue[])this.values.items)[paramInt]).interval = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 131 */     this.values.clear();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\CumulativeDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */