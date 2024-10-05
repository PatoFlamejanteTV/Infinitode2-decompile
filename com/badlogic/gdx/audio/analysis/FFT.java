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
/*     */ public class FFT
/*     */   extends FourierTransform
/*     */ {
/*     */   private int[] reverse;
/*     */   private float[] sinlookup;
/*     */   private float[] coslookup;
/*     */   
/*     */   public FFT(int paramInt, float paramFloat) {
/*  34 */     super(paramInt, paramFloat);
/*  35 */     if ((paramInt & paramInt - 1) != 0) throw new IllegalArgumentException("FFT: timeSize must be a power of two."); 
/*  36 */     buildReverseTable();
/*  37 */     buildTrigTables();
/*     */   }
/*     */   
/*     */   protected void allocateArrays() {
/*  41 */     this.spectrum = new float[this.timeSize / 2 + 1];
/*  42 */     this.real = new float[this.timeSize];
/*  43 */     this.imag = new float[this.timeSize];
/*     */   }
/*     */   
/*     */   public void scaleBand(int paramInt, float paramFloat) {
/*  47 */     if (paramFloat < 0.0F) {
/*  48 */       throw new IllegalArgumentException("Can't scale a frequency band by a negative value.");
/*     */     }
/*  50 */     if (this.spectrum[paramInt] != 0.0F) {
/*  51 */       this.real[paramInt] = this.real[paramInt] / this.spectrum[paramInt];
/*  52 */       this.imag[paramInt] = this.imag[paramInt] / this.spectrum[paramInt];
/*  53 */       this.spectrum[paramInt] = this.spectrum[paramInt] * paramFloat;
/*  54 */       this.real[paramInt] = this.real[paramInt] * this.spectrum[paramInt];
/*  55 */       this.imag[paramInt] = this.imag[paramInt] * this.spectrum[paramInt];
/*     */     } 
/*  57 */     if (paramInt != 0 && paramInt != this.timeSize / 2) {
/*  58 */       this.real[this.timeSize - paramInt] = this.real[paramInt];
/*  59 */       this.imag[this.timeSize - paramInt] = -this.imag[paramInt];
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBand(int paramInt, float paramFloat) {
/*  64 */     if (paramFloat < 0.0F) {
/*  65 */       throw new IllegalArgumentException("Can't set a frequency band to a negative value.");
/*     */     }
/*  67 */     if (this.real[paramInt] == 0.0F && this.imag[paramInt] == 0.0F) {
/*  68 */       this.real[paramInt] = paramFloat;
/*  69 */       this.spectrum[paramInt] = paramFloat;
/*     */     } else {
/*  71 */       this.real[paramInt] = this.real[paramInt] / this.spectrum[paramInt];
/*  72 */       this.imag[paramInt] = this.imag[paramInt] / this.spectrum[paramInt];
/*  73 */       this.spectrum[paramInt] = paramFloat;
/*  74 */       this.real[paramInt] = this.real[paramInt] * this.spectrum[paramInt];
/*  75 */       this.imag[paramInt] = this.imag[paramInt] * this.spectrum[paramInt];
/*     */     } 
/*  77 */     if (paramInt != 0 && paramInt != this.timeSize / 2) {
/*  78 */       this.real[this.timeSize - paramInt] = this.real[paramInt];
/*  79 */       this.imag[this.timeSize - paramInt] = -this.imag[paramInt];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fft() {
/*  86 */     for (int i = 1; i < this.real.length; i <<= 1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  92 */       float f1 = cos(i);
/*  93 */       float f2 = sin(i);
/*     */       
/*  95 */       float f3 = 1.0F;
/*  96 */       float f4 = 0.0F;
/*  97 */       for (byte b = 0; b < i; b++) {
/*  98 */         int j; for (j = b; j < this.real.length; j += 2 * i) {
/*  99 */           int k = j + i;
/* 100 */           float f5 = f3 * this.real[k] - f4 * this.imag[k];
/* 101 */           float f6 = f3 * this.imag[k] + f4 * this.real[k];
/* 102 */           this.real[k] = this.real[j] - f5;
/* 103 */           this.imag[k] = this.imag[j] - f6;
/* 104 */           this.real[j] = this.real[j] + f5;
/* 105 */           this.imag[j] = this.imag[j] + f6;
/*     */         } 
/*     */         float f;
/* 108 */         f3 = (f = f3) * f1 - f4 * f2;
/* 109 */         f4 = f * f2 + f4 * f1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void forward(float[] paramArrayOffloat) {
/* 115 */     if (paramArrayOffloat.length != this.timeSize) {
/* 116 */       throw new IllegalArgumentException("FFT.forward: The length of the passed sample buffer must be equal to timeSize().");
/*     */     }
/* 118 */     doWindow(paramArrayOffloat);
/*     */     
/* 120 */     bitReverseSamples(paramArrayOffloat);
/*     */     
/* 122 */     fft();
/*     */     
/* 124 */     fillSpectrum();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void forward(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 132 */     if (paramArrayOffloat1.length != this.timeSize || paramArrayOffloat2.length != this.timeSize) {
/* 133 */       throw new IllegalArgumentException("FFT.forward: The length of the passed buffers must be equal to timeSize().");
/*     */     }
/* 135 */     setComplex(paramArrayOffloat1, paramArrayOffloat2);
/* 136 */     bitReverseComplex();
/* 137 */     fft();
/* 138 */     fillSpectrum();
/*     */   }
/*     */   
/*     */   public void inverse(float[] paramArrayOffloat) {
/* 142 */     if (paramArrayOffloat.length > this.real.length) {
/* 143 */       throw new IllegalArgumentException("FFT.inverse: the passed array's length must equal FFT.timeSize().");
/*     */     }
/*     */     byte b;
/* 146 */     for (b = 0; b < this.timeSize; b++) {
/* 147 */       this.imag[b] = -this.imag[b];
/*     */     }
/* 149 */     bitReverseComplex();
/* 150 */     fft();
/*     */     
/* 152 */     for (b = 0; b < paramArrayOffloat.length; b++) {
/* 153 */       paramArrayOffloat[b] = this.real[b] / this.real.length;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void buildReverseTable() {
/* 160 */     int i = this.timeSize;
/* 161 */     this.reverse = new int[i];
/*     */ 
/*     */     
/* 164 */     this.reverse[0] = 0;
/* 165 */     for (int j = 1, k = i / 2; j < i; j <<= 1, k >>= 1) {
/* 166 */       for (byte b = 0; b < j; b++) {
/* 167 */         this.reverse[b + j] = this.reverse[b] + k;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bitReverseSamples(float[] paramArrayOffloat) {
/* 173 */     for (byte b = 0; b < paramArrayOffloat.length; b++) {
/* 174 */       this.real[b] = paramArrayOffloat[this.reverse[b]];
/* 175 */       this.imag[b] = 0.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void bitReverseComplex() {
/* 181 */     float[] arrayOfFloat1 = new float[this.real.length];
/* 182 */     float[] arrayOfFloat2 = new float[this.imag.length];
/* 183 */     for (byte b = 0; b < this.real.length; b++) {
/* 184 */       arrayOfFloat1[b] = this.real[this.reverse[b]];
/* 185 */       arrayOfFloat2[b] = this.imag[this.reverse[b]];
/*     */     } 
/* 187 */     this.real = arrayOfFloat1;
/* 188 */     this.imag = arrayOfFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float sin(int paramInt) {
/* 197 */     return this.sinlookup[paramInt];
/*     */   }
/*     */   
/*     */   private float cos(int paramInt) {
/* 201 */     return this.coslookup[paramInt];
/*     */   }
/*     */   
/*     */   private void buildTrigTables() {
/* 205 */     int i = this.timeSize;
/* 206 */     this.sinlookup = new float[i];
/* 207 */     this.coslookup = new float[i];
/* 208 */     for (byte b = 0; b < i; b++) {
/* 209 */       this.sinlookup[b] = (float)Math.sin((-3.1415927F / b));
/* 210 */       this.coslookup[b] = (float)Math.cos((-3.1415927F / b));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\audio\analysis\FFT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */