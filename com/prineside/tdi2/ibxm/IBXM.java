/*     */ package com.prineside.tdi2.ibxm;
/*     */ 
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.prineside.tdi2.utils.MovingAverageFloat;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IBXM
/*     */ {
/*     */   public static final String VERSION = "a73 (c)2017 mumart@gmail.com";
/*     */   private final Module a;
/*  15 */   private final int[] b = new int[128];
/*     */   private final boolean[] c;
/*     */   private final byte[][] d;
/*     */   public final Channel[] channels;
/*     */   private int e;
/*  20 */   public int interpolation = 1; private int f; private int g;
/*     */   private int h;
/*     */   private int i;
/*  23 */   private final GlobalVol o = new GlobalVol(); private int j; private int k; private int l; private int m; private int n;
/*  24 */   private final Note p = new Note();
/*     */ 
/*     */   
/*     */   public int lastSeqPos;
/*     */ 
/*     */   
/*     */   public IBXM(Module paramModule, int paramInt) {
/*  31 */     this.a = paramModule;
/*  32 */     setSampleRate(paramInt);
/*  33 */     this.d = new byte[paramModule.sequenceLength][0];
/*  34 */     this.channels = new Channel[paramModule.numChannels];
/*  35 */     this.c = new boolean[paramModule.numChannels];
/*  36 */     for (paramInt = 0; paramInt < paramModule.numChannels; paramInt++) {
/*  37 */       this.channels[paramInt] = new Channel(paramModule, paramInt, this.o);
/*     */     }
/*  39 */     setSequencePos(0);
/*     */   }
/*     */   
/*     */   public Module getModule() {
/*  43 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSampleRate() {
/*  48 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSampleRate(int paramInt) {
/*  54 */     if (paramInt < 8000 || paramInt > 128000) {
/*  55 */       throw new IllegalArgumentException("Unsupported sampling rate!");
/*     */     }
/*  57 */     this.e = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInterpolation(int paramInt) {
/*  63 */     this.interpolation = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMixBufferLength() {
/*  68 */     return a(32, 128000) + 65 << 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMuted(int paramInt, boolean paramBoolean) {
/*  74 */     if (paramInt < 0) {
/*  75 */       for (paramInt = 0; paramInt < this.a.numChannels; paramInt++)
/*  76 */         this.c[paramInt] = paramBoolean;  return;
/*     */     } 
/*  78 */     if (paramInt < this.a.numChannels) {
/*  79 */       this.c[paramInt] = paramBoolean;
/*     */     }
/*     */   }
/*     */   
/*     */   public GlobalVol getGlobalVol() {
/*  84 */     return this.o;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRow() {
/*  89 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSequencePos() {
/*  94 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setSequencePosApplyEffects(int paramInt) {
/*  98 */     setSequencePos(0);
/*  99 */     while (paramInt != this.f) {
/* 100 */       a();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSequencePos(int paramInt) {
/* 106 */     if (paramInt >= this.a.sequenceLength) paramInt = 0; 
/* 107 */     this.g = paramInt;
/* 108 */     this.i = 0;
/* 109 */     this.j = 1;
/* 110 */     this.o.volume = this.a.defaultGVol;
/* 111 */     this.k = (this.a.defaultSpeed > 0) ? this.a.defaultSpeed : 6;
/* 112 */     this.l = (this.a.defaultTempo > 0) ? this.a.defaultTempo : 125;
/* 113 */     this.m = this.n = -1;
/* 114 */     for (paramInt = 0; paramInt < this.d.length; paramInt++) {
/*     */       
/* 116 */       int i = ((i = this.a.sequence[paramInt]) < this.a.numPatterns) ? (this.a.patterns[i]).numRows : 0;
/*     */       
/* 118 */       if ((this.d[paramInt]).length < i) {
/* 119 */         this.d[paramInt] = new byte[i];
/*     */       }
/*     */       
/* 122 */       Arrays.fill(this.d[paramInt], (byte)0);
/*     */     } 
/* 124 */     for (paramInt = 0; paramInt < this.a.numChannels; paramInt++) {
/* 125 */       this.channels[paramInt].reset();
/*     */     }
/* 127 */     for (paramInt = 0; paramInt < 128; paramInt++)
/* 128 */       this.b[paramInt] = 0; 
/* 129 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int calculateSongDuration() {
/* 134 */     int i = 0;
/* 135 */     setSequencePos(0);
/* 136 */     boolean bool = false;
/* 137 */     while (!bool) {
/* 138 */       i += a(this.l, this.e);
/* 139 */       bool = a();
/*     */     } 
/* 141 */     setSequencePos(0);
/* 142 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int seek(int paramInt) {
/* 148 */     setSequencePos(0);
/* 149 */     int i = 0;
/* 150 */     int j = a(this.l, this.e);
/* 151 */     while (paramInt - i >= j) {
/* 152 */       for (byte b = 0; b < this.a.numChannels; b++)
/* 153 */         this.channels[b].updateSampleIdx(j << 1, this.e << 1); 
/* 154 */       i += j;
/* 155 */       a();
/* 156 */       j = a(this.l, this.e);
/*     */     } 
/* 158 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void seekSequencePos(int paramInt1, int paramInt2) {
/* 163 */     setSequencePos(0);
/* 164 */     if (paramInt1 < 0 || paramInt1 >= this.a.sequenceLength)
/* 165 */       paramInt1 = 0; 
/* 166 */     if (paramInt2 >= (this.a.patterns[this.a.sequence[paramInt1]]).numRows)
/* 167 */       paramInt2 = 0; 
/* 168 */     while (this.f < paramInt1 || this.h < paramInt2) {
/* 169 */       int i = a(this.l, this.e);
/* 170 */       for (byte b = 0; b < this.a.numChannels; b++)
/* 171 */         this.channels[b].updateSampleIdx(i << 1, this.e << 1); 
/* 172 */       if (a()) {
/*     */         
/* 174 */         setSequencePos(paramInt1);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatArray getAmplitudes(int paramInt) {
/* 184 */     setSequencePos(0);
/*     */     
/* 186 */     int i, arrayOfInt[] = new int[i = getMixBufferLength()];
/* 187 */     int j = 0;
/*     */     
/* 189 */     FloatArray floatArray = new FloatArray(512);
/* 190 */     MovingAverageFloat movingAverageFloat1 = new MovingAverageFloat(paramInt);
/* 191 */     MovingAverageFloat movingAverageFloat2 = new MovingAverageFloat(paramInt);
/* 192 */     byte b = 0;
/*     */     
/*     */     while (true) {
/* 195 */       int k = getAudio(arrayOfInt); int m;
/* 196 */       for (m = 0, k <<= 1; m < k; m += 2) {
/* 197 */         int n = arrayOfInt[m];
/* 198 */         int i1 = arrayOfInt[m + 1];
/*     */         
/* 200 */         if (n > 32767) n = 32767; 
/* 201 */         if (n < -32768) n = -32768; 
/* 202 */         if (i1 > 32767) i1 = 32767; 
/* 203 */         if (i1 < -32768) i1 = -32768;
/*     */         
/* 205 */         float f = Math.abs(n / 32768.0F);
/* 206 */         movingAverageFloat1.push(f);
/* 207 */         f = Math.abs(i1 / 32768.0F);
/* 208 */         movingAverageFloat2.push(f);
/*     */         
/* 210 */         b++;
/* 211 */         if (b == paramInt) {
/*     */           
/* 213 */           b = 0;
/* 214 */           floatArray.add(movingAverageFloat1.getAverage());
/* 215 */           floatArray.add(movingAverageFloat2.getAverage());
/* 216 */           movingAverageFloat1.reset();
/* 217 */           movingAverageFloat2.reset();
/*     */         } 
/*     */       } 
/*     */       
/* 221 */       if ((m = getSequencePos()) >= j) {
/*     */ 
/*     */         
/* 224 */         j = m; continue;
/*     */       }  break;
/*     */     } 
/* 227 */     floatArray.add(movingAverageFloat1.getAverage());
/* 228 */     floatArray.add(movingAverageFloat2.getAverage());
/*     */     
/* 230 */     return floatArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAudio(int[] paramArrayOfint) {
/* 238 */     int i = a(this.l, this.e); byte b;
/*     */     int j;
/* 240 */     for (b = 0, j = i + 65 << 2; b < j; b++) {
/* 241 */       paramArrayOfint[b] = 0;
/*     */     }
/* 243 */     for (b = 0; b < this.a.numChannels; b++) {
/* 244 */       Channel channel = this.channels[b];
/* 245 */       if (!this.c[b]) {
/* 246 */         channel.resample(paramArrayOfint, 0, i + 65 << 1, this.e << 1, this.interpolation);
/*     */       }
/* 248 */       channel.updateSampleIdx(i << 1, this.e << 1);
/*     */     } 
/* 250 */     b(paramArrayOfint, i + 64);
/* 251 */     a(paramArrayOfint, i);
/* 252 */     a();
/* 253 */     return i;
/*     */   }
/*     */   
/*     */   private static int a(int paramInt1, int paramInt2) {
/* 257 */     return paramInt2 * 5 / (paramInt1 << 1);
/*     */   }
/*     */   
/*     */   private void a(int[] paramArrayOfint, int paramInt) {
/* 261 */     int i = 524288 / this.e; int j;
/* 262 */     for (byte b = 0; j < 256; b += 2, j += i) {
/* 263 */       int k = 256 - j;
/* 264 */       paramArrayOfint[b] = paramArrayOfint[b] * j + this.b[b] * k >> 8;
/* 265 */       paramArrayOfint[b + 1] = paramArrayOfint[b + 1] * j + this.b[b + 1] * k >> 8;
/*     */     } 
/* 267 */     System.arraycopy(paramArrayOfint, paramInt << 1, this.b, 0, 128);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void b(int[] paramArrayOfint, int paramInt) {
/* 272 */     paramInt <<= 1;
/* 273 */     for (byte b1 = 0, b2 = 0; b2 < paramInt; b1 += 4, b2 += 2) {
/* 274 */       paramArrayOfint[b2] = (paramArrayOfint[b1] >> 2) + (paramArrayOfint[b1 + 2] >> 1) + (paramArrayOfint[b1 + 4] >> 2);
/* 275 */       paramArrayOfint[b2 + 1] = (paramArrayOfint[b1 + 1] >> 2) + (paramArrayOfint[b1 + 3] >> 1) + (paramArrayOfint[b1 + 5] >> 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a() {
/* 280 */     if (--this.j <= 0) {
/* 281 */       this.j = this.k;
/* 282 */       b();
/*     */     } else {
/* 284 */       for (byte b = 0; b < this.a.numChannels; ) { this.channels[b].tick(); b++; }
/*     */     
/* 286 */     }  return (this.d[this.f][this.h] > 1);
/*     */   }
/*     */   
/*     */   private void b() {
/* 290 */     if (this.i < 0) {
/* 291 */       this.g = this.f + 1;
/* 292 */       this.i = 0;
/*     */     } 
/* 294 */     if (this.g >= 0) {
/* 295 */       if (this.g >= this.a.sequenceLength) this.g = this.i = 0; 
/* 296 */       while (this.a.sequence[this.g] >= this.a.numPatterns) {
/* 297 */         this.g++;
/* 298 */         if (this.g >= this.a.sequenceLength) this.g = this.i = 0; 
/*     */       } 
/* 300 */       this.f = this.g;
/* 301 */       for (byte b2 = 0; b2 < this.a.numChannels; ) { (this.channels[b2]).plRow = 0; b2++; }
/* 302 */        this.g = -1;
/*     */     } 
/* 304 */     Pattern pattern = this.a.patterns[this.a.sequence[this.f]];
/* 305 */     this.h = this.i;
/* 306 */     if (this.h >= pattern.numRows) this.h = 0; 
/* 307 */     byte b = this.d[this.f][this.h];
/* 308 */     if (this.m < 0 && b < Byte.MAX_VALUE) {
/* 309 */       this.d[this.f][this.h] = (byte)(b + 1);
/*     */     }
/* 311 */     this.i = this.h + 1;
/* 312 */     if (this.i >= pattern.numRows) {
/* 313 */       this.i = -1;
/*     */     }
/* 315 */     int i = this.h * this.a.numChannels;
/* 316 */     for (byte b1 = 0; b1 < this.a.numChannels; b1++) {
/* 317 */       Channel channel = this.channels[b1];
/* 318 */       pattern.getNote(i + b1, this.p);
/* 319 */       if (this.p.effect == 14) {
/* 320 */         this.p.effect = 0x70 | this.p.param >> 4;
/* 321 */         this.p.param &= 0xF;
/*     */       } 
/* 323 */       if (this.p.effect == 147) {
/* 324 */         this.p.effect = 0xF0 | this.p.param >> 4;
/* 325 */         this.p.param &= 0xF;
/*     */       } 
/* 327 */       if (this.p.effect == 0 && this.p.param > 0) this.p.effect = 138; 
/* 328 */       channel.row(this.p);
/* 329 */       switch (this.p.effect) {
/*     */         case 129:
/* 331 */           if (this.p.param > 0)
/* 332 */             this.j = this.k = this.p.param;  break;
/*     */         case 11:
/*     */         case 130:
/* 335 */           if (this.m < 0) {
/* 336 */             this.g = this.p.param;
/* 337 */             this.i = 0;
/*     */           }  break;
/*     */         case 13:
/*     */         case 131:
/* 341 */           if (this.m < 0) {
/* 342 */             if (this.g < 0)
/* 343 */               this.g = this.f + 1; 
/* 344 */             this.i = (this.p.param >> 4) * 10 + (this.p.param & 0xF);
/*     */           } 
/*     */           break;
/*     */         case 15:
/* 348 */           if (this.p.param > 0) {
/* 349 */             if (this.p.param < 32) {
/* 350 */               this.j = this.k = this.p.param; break;
/*     */             } 
/* 352 */             this.l = this.p.param;
/*     */           } 
/*     */           break;
/*     */         case 148:
/* 356 */           if (this.p.param > 32)
/* 357 */             this.l = this.p.param;  break;
/*     */         case 118:
/*     */         case 251:
/* 360 */           if (this.p.param == 0)
/* 361 */             channel.plRow = this.h; 
/* 362 */           if (channel.plRow < this.h && this.g < 0) {
/* 363 */             if (this.m < 0) {
/* 364 */               this.m = this.p.param;
/* 365 */               this.n = b1;
/*     */             } 
/* 367 */             if (this.n == b1) {
/* 368 */               if (this.m == 0) {
/*     */                 
/* 370 */                 channel.plRow = this.h + 1;
/*     */               } else {
/* 372 */                 this.i = channel.plRow;
/*     */               } 
/* 374 */               this.m--;
/*     */             } 
/*     */           }  break;
/*     */         case 126:
/*     */         case 254:
/* 379 */           this.j = this.k + this.k * this.p.param;
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\IBXM.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */