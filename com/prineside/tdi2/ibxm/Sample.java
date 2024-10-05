/*     */ package com.prineside.tdi2.ibxm;
/*     */ 
/*     */ 
/*     */ public class Sample
/*     */ {
/*     */   public static final int FP_SHIFT = 15;
/*     */   public static final int FP_ONE = 32768;
/*     */   public static final int FP_MASK = 32767;
/*     */   public static final int C2_PAL = 8287;
/*     */   public static final int C2_NTSC = 8363;
/*  11 */   public String name = "";
/*  12 */   public int volume = 0; public int panning = -1; public int relNote = 0; public int fineTune = 0;
/*  13 */   private int a = 0; private int b = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short[] sampleData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  27 */   private static final short[][] c = a();
/*     */   
/*     */   public Sample() {}
/*     */   
/*     */   public Sample(Sample paramSample) {
/*  32 */     this.name = paramSample.name;
/*  33 */     this.volume = paramSample.volume;
/*  34 */     this.panning = paramSample.panning;
/*  35 */     this.relNote = paramSample.relNote;
/*  36 */     this.fineTune = paramSample.fineTune;
/*  37 */     this.a = paramSample.a;
/*  38 */     this.b = paramSample.b;
/*  39 */     if (paramSample.sampleData != null) {
/*  40 */       this.sampleData = new short[paramSample.sampleData.length];
/*  41 */       System.arraycopy(paramSample.sampleData, 0, this.sampleData, 0, this.sampleData.length);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static short[][] a() {
/*  46 */     short[][] arrayOfShort = new short[8][];
/*  47 */     for (byte b = 0; b < 8; b++) {
/*  48 */       arrayOfShort[b] = a(1.0D / (b + 1));
/*     */     }
/*  50 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   private static short[] a(double paramDouble) {
/*  54 */     short[] arrayOfShort = new short[272];
/*     */ 
/*     */     
/*  57 */     byte b1 = 0;
/*  58 */     for (byte b2 = 0; b2 <= 16; b2++) {
/*  59 */       double d1 = b2 / 16.0D;
/*  60 */       double d2 = Math.PI * (d1 + 7.0D);
/*  61 */       double d3 = Math.PI + d2 * 2.0D / 16.0D;
/*  62 */       for (byte b = 0; b < 16; b++) {
/*  63 */         double d4 = paramDouble;
/*  64 */         if (d2 != 0.0D) {
/*  65 */           d4 = Math.sin(paramDouble * d2) / d2;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  71 */         double d5 = (d5 = (d5 = 0.35875D - 0.48829D * Math.cos(d3)) + 0.14128D * Math.cos(d3 * 2.0D)) - 0.01168D * Math.cos(d3 * 3.0D);
/*  72 */         arrayOfShort[b1++] = (short)(int)Math.round(d4 * d5 * 32767.0D);
/*  73 */         d2 += -3.141592653589793D;
/*  74 */         d3 += -0.39269908169872414D;
/*     */       } 
/*     */     } 
/*  77 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public void setSampleData(short[] paramArrayOfshort, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  81 */     int j = paramArrayOfshort.length;
/*     */     
/*  83 */     if (paramInt1 < 0 || paramInt1 > j)
/*  84 */       paramInt1 = j; 
/*  85 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > j)
/*  86 */       paramInt2 = j - paramInt1; 
/*  87 */     j = paramInt1 + paramInt2;
/*     */     
/*  89 */     paramInt1 += 8;
/*     */     
/*     */     int k;
/*  92 */     short[] arrayOfShort = new short[k = j + 8 + (paramBoolean ? paramInt2 : 0) + 16];
/*  93 */     System.arraycopy(paramArrayOfshort, 0, arrayOfShort, 8, j);
/*  94 */     paramArrayOfshort = arrayOfShort;
/*  95 */     if (paramBoolean) {
/*     */       
/*  97 */       int m = paramInt1 + paramInt2;
/*  98 */       for (j = 0; j < paramInt2; j++)
/*  99 */         paramArrayOfshort[m + j] = paramArrayOfshort[m - j - 1]; 
/* 100 */       paramInt2 <<= 1;
/*     */     } 
/*     */     int i;
/* 103 */     for (j = (i = paramInt1 + paramInt2) + 16; i < j; i++)
/* 104 */       paramArrayOfshort[i] = paramArrayOfshort[i - paramInt2]; 
/* 105 */     this.sampleData = paramArrayOfshort;
/* 106 */     this.a = paramInt1;
/* 107 */     this.b = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resampleNearest(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, int paramInt6, int paramInt7) {
/* 112 */     int i = this.b;
/* 113 */     int j = this.a + i;
/* 114 */     paramInt1 += 8;
/* 115 */     if (paramInt1 >= j)
/* 116 */       paramInt1 = normaliseSampleIdx(paramInt1); 
/* 117 */     short[] arrayOfShort = this.sampleData;
/* 118 */     int k = paramInt6 << 1;
/* 119 */     paramInt6 = paramInt6 + paramInt7 << 1;
/* 120 */     while (k < paramInt6) {
/* 121 */       if (paramInt1 >= j)
/* 122 */         if (i >= 2)
/* 123 */         { for (; paramInt1 >= j; paramInt1 -= i); }
/*     */         else { break; }
/* 125 */           paramInt7 = arrayOfShort[paramInt1];
/* 126 */       paramArrayOfint[k++] = paramArrayOfint[k++] + (paramInt7 * paramInt4 >> 15);
/* 127 */       paramArrayOfint[k++] = paramArrayOfint[k++] + (paramInt7 * paramInt5 >> 15);
/* 128 */       paramInt2 += paramInt3;
/* 129 */       paramInt1 += paramInt2 >> 15;
/* 130 */       paramInt2 &= 0x7FFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void resampleLinear(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, int paramInt6, int paramInt7) {
/* 136 */     int i = this.b;
/* 137 */     int j = this.a + i;
/* 138 */     paramInt1 += 8;
/* 139 */     if (paramInt1 >= j)
/* 140 */       paramInt1 = normaliseSampleIdx(paramInt1); 
/* 141 */     short[] arrayOfShort = this.sampleData;
/* 142 */     int k = paramInt6 << 1;
/* 143 */     paramInt6 = paramInt6 + paramInt7 << 1;
/* 144 */     while (k < paramInt6) {
/* 145 */       if (paramInt1 >= j)
/* 146 */         if (i >= 2)
/* 147 */         { for (; paramInt1 >= j; paramInt1 -= i); }
/*     */         else { break; }
/* 149 */           paramInt7 = arrayOfShort[paramInt1];
/*     */       int m;
/* 151 */       paramInt7 = ((m = arrayOfShort[paramInt1 + 1] - paramInt7) * paramInt2 >> 15) + paramInt7;
/* 152 */       paramArrayOfint[k++] = paramArrayOfint[k++] + (paramInt7 * paramInt4 >> 15);
/* 153 */       paramArrayOfint[k++] = paramArrayOfint[k++] + (paramInt7 * paramInt5 >> 15);
/* 154 */       paramInt2 += paramInt3;
/* 155 */       paramInt1 += paramInt2 >> 15;
/* 156 */       paramInt2 &= 0x7FFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void resampleSinc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, int paramInt6, int paramInt7) {
/* 162 */     int i = 0;
/* 163 */     if (paramInt3 > 32768)
/*     */     {
/*     */       
/* 166 */       if ((i = (paramInt3 >> 15) - 1) >= 8) {
/* 167 */         i = 7;
/*     */       }
/*     */     }
/* 170 */     short[] arrayOfShort1 = c[i];
/* 171 */     int j = this.b;
/* 172 */     int k = this.a + j;
/* 173 */     if (paramInt1 >= k)
/* 174 */       paramInt1 = normaliseSampleIdx(paramInt1); 
/* 175 */     short[] arrayOfShort2 = this.sampleData;
/* 176 */     int m = paramInt6 << 1;
/* 177 */     paramInt6 = paramInt6 + paramInt7 << 1;
/* 178 */     while (m < paramInt6) {
/* 179 */       if (paramInt1 >= k)
/* 180 */         if (j >= 2) {
/* 181 */           for (; paramInt1 >= k; paramInt1 -= j);
/*     */         } else {
/*     */           break;
/* 184 */         }   int n = (paramInt7 = paramInt2 >> 11 << 4) + 16;
/* 185 */       int i1 = 0, i2 = 0; int i3;
/* 186 */       for (i3 = 0; i3 < 16; i3++) {
/* 187 */         i1 += arrayOfShort1[paramInt7 + i3] * arrayOfShort2[paramInt1 + i3];
/* 188 */         i2 += arrayOfShort1[n + i3] * arrayOfShort2[paramInt1 + i3];
/*     */       } 
/* 190 */       i1 >>= 15;
/* 191 */       i2 >>= 15;
/* 192 */       i3 = i1 + ((i2 - i1) * (paramInt2 & 0x7FF) >> 11);
/* 193 */       paramArrayOfint[m++] = paramArrayOfint[m++] + (i3 * paramInt4 >> 15);
/* 194 */       paramArrayOfint[m++] = paramArrayOfint[m++] + (i3 * paramInt5 >> 15);
/* 195 */       paramInt2 += paramInt3;
/* 196 */       paramInt1 += paramInt2 >> 15;
/* 197 */       paramInt2 &= 0x7FFF;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int normaliseSampleIdx(int paramInt) {
/*     */     int i;
/* 203 */     if ((i = paramInt - this.a) > 0) {
/* 204 */       paramInt = this.a;
/* 205 */       if (this.b > 1) paramInt += i % this.b; 
/*     */     } 
/* 207 */     return paramInt;
/*     */   }
/*     */   
/*     */   public boolean looped() {
/* 211 */     return (this.b > 1);
/*     */   }
/*     */   
/*     */   public void toStringBuffer(StringBuffer paramStringBuffer) {
/* 215 */     paramStringBuffer.append("Name: " + this.name + '\n');
/* 216 */     paramStringBuffer.append("Volume: " + this.volume + '\n');
/* 217 */     paramStringBuffer.append("Panning: " + this.panning + '\n');
/* 218 */     paramStringBuffer.append("Relative Note: " + this.relNote + '\n');
/* 219 */     paramStringBuffer.append("Fine Tune: " + this.fineTune + '\n');
/* 220 */     paramStringBuffer.append("Loop Start: " + this.a + '\n');
/* 221 */     paramStringBuffer.append("Loop Length: " + this.b + '\n');
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Sample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */