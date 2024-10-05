/*     */ package com.badlogic.gdx.math;
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
/*     */ public final class WindowedMean
/*     */ {
/*     */   float[] values;
/*  26 */   int added_values = 0;
/*     */   int last_value;
/*  28 */   float mean = 0.0F;
/*     */ 
/*     */   
/*     */   boolean dirty = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public WindowedMean(int paramInt) {
/*  36 */     this.values = new float[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasEnoughData() {
/*  41 */     return (this.added_values >= this.values.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void clear() {
/*  46 */     this.added_values = 0;
/*  47 */     this.last_value = 0;
/*  48 */     for (byte b = 0; b < this.values.length; b++)
/*  49 */       this.values[b] = 0.0F; 
/*  50 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addValue(float paramFloat) {
/*  57 */     if (this.added_values < this.values.length) this.added_values++; 
/*  58 */     this.values[this.last_value++] = paramFloat;
/*  59 */     if (this.last_value > this.values.length - 1) this.last_value = 0; 
/*  60 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getMean() {
/*  67 */     if (hasEnoughData()) {
/*  68 */       if (this.dirty) {
/*  69 */         float f = 0.0F;
/*  70 */         for (byte b = 0; b < this.values.length; b++) {
/*  71 */           f += this.values[b];
/*     */         }
/*  73 */         this.mean = f / this.values.length;
/*  74 */         this.dirty = false;
/*     */       } 
/*  76 */       return this.mean;
/*     */     } 
/*  78 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getOldest() {
/*  83 */     return (this.added_values < this.values.length) ? this.values[0] : this.values[this.last_value];
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getLatest() {
/*  88 */     return this.values[(this.last_value - 1 == -1) ? (this.values.length - 1) : (this.last_value - 1)];
/*     */   }
/*     */ 
/*     */   
/*     */   public final float standardDeviation() {
/*  93 */     if (!hasEnoughData()) return 0.0F;
/*     */     
/*  95 */     float f1 = getMean();
/*  96 */     float f2 = 0.0F;
/*  97 */     for (byte b = 0; b < this.values.length; b++) {
/*  98 */       f2 += (this.values[b] - f1) * (this.values[b] - f1);
/*     */     }
/*     */     
/* 101 */     return (float)Math.sqrt((f2 / this.values.length));
/*     */   }
/*     */   
/*     */   public final float getLowest() {
/* 105 */     float f = Float.MAX_VALUE;
/* 106 */     for (byte b = 0; b < this.values.length; b++)
/* 107 */       f = Math.min(f, this.values[b]); 
/* 108 */     return f;
/*     */   }
/*     */   
/*     */   public final float getHighest() {
/* 112 */     float f = 1.1754944E-38F;
/* 113 */     for (byte b = 0; b < this.values.length; b++)
/* 114 */       f = Math.max(f, this.values[b]); 
/* 115 */     return f;
/*     */   }
/*     */   
/*     */   public final int getValueCount() {
/* 119 */     return this.added_values;
/*     */   }
/*     */   
/*     */   public final int getWindowSize() {
/* 123 */     return this.values.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] getWindowValues() {
/* 129 */     float[] arrayOfFloat = new float[this.added_values];
/* 130 */     if (hasEnoughData()) {
/* 131 */       for (byte b = 0; b < arrayOfFloat.length; b++) {
/* 132 */         arrayOfFloat[b] = this.values[(b + this.last_value) % this.values.length];
/*     */       }
/*     */     } else {
/* 135 */       System.arraycopy(this.values, 0, arrayOfFloat, 0, this.added_values);
/*     */     } 
/* 137 */     return arrayOfFloat;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\WindowedMean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */