/*     */ package com.badlogic.gdx.audio.analysis;
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
/*     */ public abstract class FourierTransform
/*     */ {
/*     */   public static final int NONE = 0;
/*     */   public static final int HAMMING = 1;
/*     */   protected static final int LINAVG = 2;
/*     */   protected static final int LOGAVG = 3;
/*     */   protected static final int NOAVG = 4;
/*     */   protected static final float TWO_PI = 6.2831855F;
/*     */   protected int timeSize;
/*     */   protected int sampleRate;
/*     */   protected float bandWidth;
/*     */   protected int whichWindow;
/*     */   protected float[] real;
/*     */   protected float[] imag;
/*     */   protected float[] spectrum;
/*     */   protected float[] averages;
/*     */   protected int whichAverage;
/*     */   protected int octaves;
/*     */   protected int avgPerOctave;
/*     */   
/*     */   FourierTransform(int paramInt, float paramFloat) {
/* 120 */     this.timeSize = paramInt;
/* 121 */     this.sampleRate = (int)paramFloat;
/* 122 */     this.bandWidth = 2.0F / this.timeSize * this.sampleRate / 2.0F;
/* 123 */     noAverages();
/* 124 */     allocateArrays();
/* 125 */     this.whichWindow = 0;
/*     */   }
/*     */   
/*     */   public int getTimeSize() {
/* 129 */     return this.timeSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void allocateArrays();
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComplex(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 139 */     if (this.real.length != paramArrayOffloat1.length && this.imag.length != paramArrayOffloat2.length) {
/* 140 */       throw new IllegalArgumentException("This won't work");
/*     */     }
/* 142 */     System.arraycopy(paramArrayOffloat1, 0, this.real, 0, paramArrayOffloat1.length);
/* 143 */     System.arraycopy(paramArrayOffloat2, 0, this.imag, 0, paramArrayOffloat2.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fillSpectrum() {
/*     */     int i;
/* 151 */     for (i = 0; i < this.spectrum.length; i++) {
/* 152 */       this.spectrum[i] = (float)Math.sqrt((this.real[i] * this.real[i] + this.imag[i] * this.imag[i]));
/*     */     }
/*     */     
/* 155 */     if (this.whichAverage == 2) {
/* 156 */       i = this.spectrum.length / this.averages.length;
/* 157 */       for (byte b = 0; b < this.averages.length; b++) {
/* 158 */         float f = 0.0F; byte b1;
/*     */         int j;
/* 160 */         for (b1 = 0; b1 < i && (
/*     */           
/* 162 */           j = b1 + b * i) < this.spectrum.length; b1++) {
/* 163 */           f += this.spectrum[j];
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 168 */         f /= (b1 + 1);
/* 169 */         this.averages[b] = f;
/*     */       }  return;
/* 171 */     }  if (this.whichAverage == 3) {
/* 172 */       for (i = 0; i < this.octaves; i++) {
/*     */         float f1;
/* 174 */         if (i == 0) {
/* 175 */           f1 = 0.0F;
/*     */         } else {
/* 177 */           f1 = (this.sampleRate / 2) / (float)Math.pow(2.0D, (this.octaves - i));
/*     */         } 
/*     */         
/* 180 */         float f2, f3 = ((f2 = (this.sampleRate / 2) / (float)Math.pow(2.0D, (this.octaves - i - 1))) - f1) / this.avgPerOctave;
/* 181 */         float f4 = f1;
/* 182 */         for (byte b = 0; b < this.avgPerOctave; b++) {
/* 183 */           int j = b + i * this.avgPerOctave;
/* 184 */           this.averages[j] = calcAvg(f4, f4 + f3);
/* 185 */           f4 += f3;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void noAverages() {
/* 193 */     this.averages = new float[0];
/* 194 */     this.whichAverage = 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void linAverages(int paramInt) {
/* 202 */     if (paramInt > this.spectrum.length / 2) {
/* 203 */       throw new IllegalArgumentException("The number of averages for this transform can be at most " + (this.spectrum.length / 2) + ".");
/*     */     }
/*     */     
/* 206 */     this.averages = new float[paramInt];
/*     */     
/* 208 */     this.whichAverage = 2;
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
/*     */   public void logAverages(int paramInt1, int paramInt2) {
/* 220 */     float f = this.sampleRate / 2.0F;
/* 221 */     this.octaves = 1;
/* 222 */     while ((f /= 2.0F) > paramInt1) {
/* 223 */       this.octaves++;
/*     */     }
/* 225 */     this.avgPerOctave = paramInt2;
/* 226 */     this.averages = new float[this.octaves * paramInt2];
/* 227 */     this.whichAverage = 3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void window(int paramInt) {
/* 235 */     if (paramInt < 0 || paramInt > 1) {
/* 236 */       throw new IllegalArgumentException("Invalid window type.");
/*     */     }
/* 238 */     this.whichWindow = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doWindow(float[] paramArrayOffloat) {
/* 243 */     switch (this.whichWindow) {
/*     */       case 1:
/* 245 */         hamming(paramArrayOffloat);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hamming(float[] paramArrayOffloat) {
/* 252 */     for (byte b = 0; b < paramArrayOffloat.length; b++) {
/* 253 */       paramArrayOffloat[b] = (float)(paramArrayOffloat[b] * (0.5400000214576721D - 0.46000000834465027D * Math.cos((6.2831855F * b / (paramArrayOffloat.length - 1)))));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int timeSize() {
/* 261 */     return this.timeSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int specSize() {
/* 269 */     return this.spectrum.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getBand(int paramInt) {
/* 277 */     if (paramInt < 0) paramInt = 0; 
/* 278 */     if (paramInt > this.spectrum.length - 1) paramInt = this.spectrum.length - 1; 
/* 279 */     return this.spectrum[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getBandWidth() {
/* 287 */     return this.bandWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setBand(int paramInt, float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void scaleBand(int paramInt, float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int freqToIndex(float paramFloat) {
/* 310 */     if (paramFloat < getBandWidth() / 2.0F) return 0;
/*     */     
/* 312 */     if (paramFloat > (this.sampleRate / 2) - getBandWidth() / 2.0F) return this.spectrum.length - 1;
/*     */     
/* 314 */     paramFloat /= this.sampleRate;
/*     */     int i;
/* 316 */     return i = Math.round(this.timeSize * paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float indexToFreq(int paramInt) {
/* 322 */     float f1, f2 = getBandWidth();
/*     */ 
/*     */     
/* 325 */     if (paramInt == 0) return f2 * 0.25F;
/*     */     
/* 327 */     if (paramInt == this.spectrum.length - 1) {
/* 328 */       f1 = (this.sampleRate / 2) - f2 / 2.0F;
/* 329 */       f2 *= 0.25F;
/* 330 */       return f1 + f2;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 336 */     return f1 * f2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAverageCenterFrequency(int paramInt) {
/* 343 */     if (this.whichAverage == 2) {
/*     */       
/* 345 */       int i = this.spectrum.length / this.averages.length;
/*     */       
/* 347 */       paramInt = paramInt * i + i / 2;
/* 348 */       return indexToFreq(paramInt);
/*     */     } 
/* 350 */     if (this.whichAverage == 3) {
/*     */       float f3;
/* 352 */       int i = paramInt / this.avgPerOctave;
/*     */       
/* 354 */       paramInt %= this.avgPerOctave;
/*     */ 
/*     */       
/* 357 */       if (i == 0) {
/* 358 */         f3 = 0.0F;
/*     */       } else {
/* 360 */         f3 = (this.sampleRate / 2) / (float)Math.pow(2.0D, (this.octaves - i));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 365 */       float f2 = ((f2 = (this.sampleRate / 2) / (float)Math.pow(2.0D, (this.octaves - i - 1))) - f3) / this.avgPerOctave;
/*     */       
/*     */       float f1;
/*     */       
/* 369 */       return (f1 = f3 + paramInt * f2) + f2 / 2.0F;
/*     */     } 
/*     */     
/* 372 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFreq(float paramFloat) {
/* 380 */     return getBand(freqToIndex(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFreq(float paramFloat1, float paramFloat2) {
/* 388 */     setBand(freqToIndex(paramFloat1), paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void scaleFreq(float paramFloat1, float paramFloat2) {
/* 396 */     scaleBand(freqToIndex(paramFloat1), paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int avgSize() {
/* 403 */     return this.averages.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAvg(int paramInt) {
/*     */     float f;
/* 412 */     if (this.averages.length > 0) {
/* 413 */       f = this.averages[paramInt];
/*     */     } else {
/* 415 */       f = 0.0F;
/* 416 */     }  return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float calcAvg(float paramFloat1, float paramFloat2) {
/* 425 */     int i = freqToIndex(paramFloat1);
/* 426 */     int j = freqToIndex(paramFloat2);
/* 427 */     float f = 0.0F;
/* 428 */     for (int k = i; k <= j; k++) {
/* 429 */       f += this.spectrum[k];
/*     */     }
/*     */     
/* 432 */     return f = f / (j - i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void forward(float[] paramArrayOffloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void forward(float[] paramArrayOffloat, int paramInt) {
/* 446 */     if (paramArrayOffloat.length - paramInt < this.timeSize) {
/* 447 */       throw new IllegalArgumentException("FourierTransform.forward: not enough samples in the buffer between " + paramInt + " and " + paramArrayOffloat.length + " to perform a transform.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 452 */     float[] arrayOfFloat = new float[this.timeSize];
/* 453 */     System.arraycopy(paramArrayOffloat, paramInt, arrayOfFloat, 0, arrayOfFloat.length);
/* 454 */     forward(arrayOfFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void inverse(float[] paramArrayOffloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void inverse(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3) {
/* 469 */     setComplex(paramArrayOffloat1, paramArrayOffloat2);
/* 470 */     inverse(paramArrayOffloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getSpectrum() {
/* 475 */     return this.spectrum;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getRealPart() {
/* 480 */     return this.real;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getImaginaryPart() {
/* 485 */     return this.imag;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\audio\analysis\FourierTransform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */