/*     */ package com.prineside.tdi2.ibxm;
/*     */ public class Channel {
/*     */   public static final int NEAREST = 0;
/*     */   public static final int LINEAR = 1;
/*     */   public static final int SINC = 2;
/*   6 */   private static int[] a = new int[] { 32768, 32946, 33125, 33305, 33486, 33667, 33850, 34034, 34219, 34405, 34591, 34779, 34968, 35158, 35349, 35541, 35734, 35928, 36123, 36319, 36516, 36715, 36914, 37114, 37316, 37518, 37722, 37927, 38133, 38340, 38548, 38757, 38968, 39180, 39392, 39606, 39821, 40037, 40255, 40473, 40693, 40914, 41136, 41360, 41584, 41810, 42037, 42265, 42495, 42726, 42958, 43191, 43425, 43661, 43898, 44137, 44376, 44617, 44859, 45103, 45348, 45594, 45842, 46091, 46341, 46593, 46846, 47100, 47356, 47613, 47871, 48131, 48393, 48655, 48920, 49185, 49452, 49721, 49991, 50262, 50535, 50810, 51085, 51363, 51642, 51922, 52204, 52488, 52773, 53059, 53347, 53637, 53928, 54221, 54515, 54811, 55109, 55408, 55709, 56012, 56316, 56622, 56929, 57238, 57549, 57861, 58176, 58491, 58809, 59128, 59449, 59772, 60097, 60423, 60751, 61081, 61413, 61746, 62081, 62419, 62757, 63098, 63441, 63785, 64132, 64480, 64830, 65182, 65536 };
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
/*  26 */   private static final short[] b = new short[] { 0, 24, 49, 74, 97, 120, 141, 161, 180, 197, 212, 224, 235, 244, 250, 253, 255, 253, 250, 244, 235, 224, 212, 197, 180, 161, 141, 120, 97, 74, 49, 24 }; private final Module c; private final GlobalVol d; private Instrument e; private Sample f; private boolean g;
/*     */   private int h;
/*     */   private int i;
/*     */   private int j;
/*     */   private int k;
/*     */   private int l;
/*     */   private int m;
/*     */   private int n;
/*     */   private int o;
/*     */   private int p;
/*     */   private int q;
/*     */   private int r;
/*     */   private int s;
/*     */   private int t;
/*     */   private int u;
/*     */   private int v;
/*     */   private int w;
/*     */   private int x;
/*     */   private int y;
/*     */   private int z;
/*     */   private int A;
/*     */   private int B;
/*     */   private int C;
/*     */   private int D;
/*     */   
/*     */   public Channel(Module paramModule, int paramInt, GlobalVol paramGlobalVol) {
/*  52 */     this.c = paramModule;
/*  53 */     this.ae = paramInt;
/*  54 */     this.d = paramGlobalVol;
/*  55 */     this.t = paramModule.defaultPanning[paramInt];
/*  56 */     this.e = new Instrument();
/*  57 */     this.f = this.e.samples[0];
/*  58 */     this.af = (paramInt + 1) * 11259375;
/*     */   }
/*     */   private int E; private int F; private int G; private int H; private int I; private int J; private int K; private int L; private int M; private int N; private int O; private int P; private int Q; private int R; private int S; private int T; private int U; private int V; private int W; private int X; private int Y; private int Z; private int aa; private int ab; private int ac; private int ad; private int ae; private int af; public int plRow;
/*     */   public void reset() {
/*  62 */     this.g = false;
/*  63 */     this.h = this.i = this.j = this.k = this.l = this.m = this.n = this.o = this.p = this.q = this.r = this.s = this.u = this.v = this.w = this.x = this.y = this.z = this.A = this.B = this.C = this.D = this.E = this.F = this.G = this.H = this.I = this.J = this.K = this.L = this.M = this.N = this.O = this.P = this.Q = this.R = this.S = this.T = this.U = this.V = this.W = this.X = this.Y = this.Z = this.aa = this.ab = this.ac = this.ad = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     this.t = this.c.defaultPanning[this.ae];
/*     */     
/*  74 */     this.f = this.e.samples[0];
/*  75 */     this.af = (this.ae + 1) * 11259375;
/*     */   }
/*     */   
/*     */   public void resample(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  79 */     if (this.q <= 0)
/*  80 */       return;  int i = this.q * (255 - this.r) >> 8;
/*  81 */     int j = this.q * this.r >> 8;
/*  82 */     paramInt3 = (this.p << 12) / (paramInt3 >> 3);
/*  83 */     switch (paramInt4) {
/*     */       case 0:
/*  85 */         this.f.resampleNearest(this.n, this.o, paramInt3, i, j, paramArrayOfint, paramInt1, paramInt2);
/*     */         return;
/*     */       default:
/*  88 */         this.f.resampleLinear(this.n, this.o, paramInt3, i, j, paramArrayOfint, paramInt1, paramInt2); return;
/*     */       case 2:
/*     */         break;
/*  91 */     }  this.f.resampleSinc(this.n, this.o, paramInt3, i, j, paramArrayOfint, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSampleIdx(int paramInt1, int paramInt2) {
/*  97 */     paramInt2 = (this.p << 12) / (paramInt2 >> 3);
/*  98 */     this.o += paramInt2 * paramInt1;
/*  99 */     this.n = this.f.normaliseSampleIdx(this.n + (this.o >> 15));
/* 100 */     this.o &= 0x7FFF;
/*     */   }
/*     */   
/*     */   public void row(Note paramNote) {
/* 104 */     this.h = paramNote.key;
/* 105 */     this.i = paramNote.instrument;
/* 106 */     this.j = paramNote.volume;
/* 107 */     this.k = paramNote.effect;
/* 108 */     this.l = paramNote.param;
/* 109 */     this.z++;
/* 110 */     this.ac = this.ab = this.ad = this.A = 0;
/* 111 */     if ((this.k != 125 && this.k != 253) || this.l <= 0)
/*     */     {
/* 113 */       j();
/*     */     }
/* 115 */     switch (this.k) { case 1:
/*     */       case 134:
/* 117 */         if (this.l > 0) this.C = this.l; 
/* 118 */         a(this.C); break;
/*     */       case 2:
/*     */       case 133:
/* 121 */         if (this.l > 0) this.D = this.l; 
/* 122 */         b(this.D); break;
/*     */       case 3:
/*     */       case 135:
/* 125 */         if (this.l > 0) this.E = this.l;  break;
/*     */       case 4:
/*     */       case 136:
/* 128 */         if (this.l >> 4 > 0) this.V = this.l >> 4; 
/* 129 */         if ((this.l & 0xF) > 0) this.W = this.l & 0xF; 
/* 130 */         a(false); break;
/*     */       case 5:
/*     */       case 140:
/* 133 */         if (this.l > 0) this.K = this.l; 
/* 134 */         c(); break;
/*     */       case 6:
/*     */       case 139:
/* 137 */         if (this.l > 0) this.K = this.l; 
/* 138 */         a(false);
/* 139 */         c(); break;
/*     */       case 7:
/*     */       case 146:
/* 142 */         if (this.l >> 4 > 0) this.Z = this.l >> 4; 
/* 143 */         if ((this.l & 0xF) > 0) this.aa = this.l & 0xF; 
/* 144 */         e();
/*     */         break;
/*     */       case 8:
/* 147 */         this.t = this.l; break;
/*     */       case 10:
/*     */       case 132:
/* 150 */         if (this.l > 0) this.K = this.l; 
/* 151 */         c();
/*     */         break;
/*     */       case 12:
/* 154 */         this.s = (this.l >= 64) ? 64 : (this.l & 0x3F); break;
/*     */       case 16:
/*     */       case 150:
/* 157 */         this.d.volume = (this.l >= 64) ? 64 : (this.l & 0x3F);
/*     */         break;
/*     */       case 17:
/* 160 */         if (this.l > 0) this.L = this.l; 
/*     */         break;
/*     */       case 20:
/* 163 */         this.g = false;
/*     */         break;
/*     */       case 21:
/* 166 */         this.v = this.w = this.l & 0xFF;
/*     */         break;
/*     */       case 25:
/* 169 */         if (this.l > 0) this.M = this.l;  break;
/*     */       case 27:
/*     */       case 145:
/* 172 */         if (this.l >> 4 > 0) this.P = this.l >> 4; 
/* 173 */         if ((this.l & 0xF) > 0) this.Q = this.l & 0xF; 
/* 174 */         g(); break;
/*     */       case 29:
/*     */       case 137:
/* 177 */         if (this.l >> 4 > 0) this.R = this.l >> 4; 
/* 178 */         if ((this.l & 0xF) > 0) this.S = this.l & 0xF; 
/* 179 */         f();
/*     */         break;
/*     */       case 33:
/* 182 */         if (this.l > 0) this.I = this.l; 
/* 183 */         switch (this.I & 0xF0) {
/*     */           case 16:
/* 185 */             a(0xE0 | this.I & 0xF);
/*     */             break;
/*     */           case 32:
/* 188 */             b(0xE0 | this.I & 0xF);
/*     */             break;
/*     */         } 
/*     */         break;
/*     */       case 113:
/* 193 */         if (this.l > 0) this.G = this.l; 
/* 194 */         a(0xF0 | this.G & 0xF);
/*     */         break;
/*     */       case 114:
/* 197 */         if (this.l > 0) this.H = this.l; 
/* 198 */         b(0xF0 | this.H & 0xF); break;
/*     */       case 116:
/*     */       case 243:
/* 201 */         if (this.l < 8) this.T = this.l;  break;
/*     */       case 119:
/*     */       case 244:
/* 204 */         if (this.l < 8) this.X = this.l; 
/*     */         break;
/*     */       case 122:
/* 207 */         if (this.l > 0) this.N = this.l; 
/* 208 */         this.s += this.N;
/* 209 */         if (this.s > 64) this.s = 64; 
/*     */         break;
/*     */       case 123:
/* 212 */         if (this.l > 0) this.O = this.l; 
/* 213 */         this.s -= this.O;
/* 214 */         if (this.s < 0) this.s = 0;  break;
/*     */       case 124:
/*     */       case 252:
/* 217 */         if (this.l <= 0) this.s = 0; 
/*     */         break;
/*     */       case 138:
/* 220 */         if (this.l > 0) this.J = this.l; 
/*     */         break;
/*     */       case 149:
/* 223 */         if (this.l >> 4 > 0) this.V = this.l >> 4; 
/* 224 */         if ((this.l & 0xF) > 0) this.W = this.l & 0xF; 
/* 225 */         a(true);
/*     */         break;
/*     */       case 248:
/* 228 */         this.t = this.l * 17;
/*     */         break; }
/*     */     
/* 231 */     b();
/* 232 */     h();
/* 233 */     i();
/* 234 */     a();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 238 */     this.ac = 0;
/* 239 */     this.A++;
/* 240 */     this.z++;
/* 241 */     if (this.k != 125 || this.A > this.l) {
/* 242 */       switch (this.j & 0xF0) {
/*     */         case 96:
/* 244 */           this.s -= this.j & 0xF;
/* 245 */           if (this.s < 0) this.s = 0; 
/*     */           break;
/*     */         case 112:
/* 248 */           this.s += this.j & 0xF;
/* 249 */           if (this.s > 64) this.s = 64; 
/*     */           break;
/*     */         case 176:
/* 252 */           this.U += this.V;
/* 253 */           a(false);
/*     */           break;
/*     */         case 208:
/* 256 */           this.t -= this.j & 0xF;
/* 257 */           if (this.t < 0) this.t = 0; 
/*     */           break;
/*     */         case 224:
/* 260 */           this.t += this.j & 0xF;
/* 261 */           if (this.t > 255) this.t = 255; 
/*     */           break;
/*     */         case 240:
/* 264 */           d();
/*     */           break;
/*     */       } 
/*     */     }
/* 268 */     switch (this.k) { case 1:
/*     */       case 134:
/* 270 */         a(this.C); break;
/*     */       case 2:
/*     */       case 133:
/* 273 */         b(this.D); break;
/*     */       case 3:
/*     */       case 135:
/* 276 */         d(); break;
/*     */       case 4:
/*     */       case 136:
/* 279 */         this.U += this.V;
/* 280 */         a(false); break;
/*     */       case 5:
/*     */       case 140:
/* 283 */         d();
/* 284 */         c(); break;
/*     */       case 6:
/*     */       case 139:
/* 287 */         this.U += this.V;
/* 288 */         a(false);
/* 289 */         c(); break;
/*     */       case 7:
/*     */       case 146:
/* 292 */         this.Y += this.Z;
/* 293 */         e(); break;
/*     */       case 10:
/*     */       case 132:
/* 296 */         c();
/*     */         break;
/*     */       case 17:
/* 299 */         this.d.volume += (this.L >> 4) - (this.L & 0xF);
/* 300 */         if (this.d.volume < 0) this.d.volume = 0; 
/* 301 */         if (this.d.volume > 64) this.d.volume = 64; 
/*     */         break;
/*     */       case 25:
/* 304 */         this.t += (this.M >> 4) - (this.M & 0xF);
/* 305 */         if (this.t < 0) this.t = 0; 
/* 306 */         if (this.t > 255) this.t = 255;  break;
/*     */       case 27:
/*     */       case 145:
/* 309 */         g(); break;
/*     */       case 29:
/*     */       case 137:
/* 312 */         f();
/*     */         break;
/*     */       case 121:
/* 315 */         if (this.A >= this.l) {
/* 316 */           this.A = 0;
/* 317 */           this.n = this.o = 0;
/*     */         }  break;
/*     */       case 124:
/*     */       case 252:
/* 321 */         if (this.l == this.A) this.s = 0;  break;
/*     */       case 125:
/*     */       case 253:
/* 324 */         if (this.l == this.A) j(); 
/*     */         break;
/*     */       case 138:
/* 327 */         if (this.A > 2) this.A = 0; 
/* 328 */         if (this.A == 0) this.ad = 0; 
/* 329 */         if (this.A == 1) this.ad = this.J >> 4; 
/* 330 */         if (this.A == 2) this.ad = this.J & 0xF; 
/*     */         break;
/*     */       case 149:
/* 333 */         this.U += this.V;
/* 334 */         a(true);
/*     */         break; }
/*     */     
/* 337 */     b();
/* 338 */     h();
/* 339 */     i();
/* 340 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/* 344 */     if (this.e.volumeEnvelope.enabled) {
/* 345 */       if (!this.g) {
/* 346 */         this.u -= this.e.volumeFadeOut;
/* 347 */         if (this.u < 0) this.u = 0; 
/*     */       } 
/* 349 */       this.v = this.e.volumeEnvelope.nextTick(this.v, this.g);
/*     */     } 
/* 351 */     if (this.e.panningEnvelope.enabled)
/* 352 */       this.w = this.e.panningEnvelope.nextTick(this.w, this.g); 
/*     */   }
/*     */   
/*     */   private void b() {
/*     */     int i;
/* 357 */     if ((i = this.e.vibratoDepth & 0x7F) > 0) {
/* 358 */       int j = this.e.vibratoSweep & 0x7F;
/* 359 */       int k = this.e.vibratoRate & 0x7F;
/* 360 */       int m = this.e.vibratoType;
/* 361 */       if (this.B < j) i = i * this.B / j; 
/* 362 */       this.ac += a(this.B * k >> 2, m + 4) * i >> 8;
/* 363 */       this.B++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c() {
/* 368 */     int i = this.K >> 4;
/*     */     int j;
/* 370 */     if ((j = this.K & 0xF) == 15 && i > 0) {
/* 371 */       if (this.A == 0) this.s += i; 
/* 372 */     } else if (i == 15 && j > 0) {
/* 373 */       if (this.A == 0) this.s -= j; 
/* 374 */     } else if (this.A > 0 || this.c.fastVolSlides) {
/* 375 */       this.s += i - j;
/* 376 */     }  if (this.s > 64) this.s = 64; 
/* 377 */     if (this.s < 0) this.s = 0; 
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/* 381 */     switch (paramInt & 0xF0) {
/*     */       case 224:
/* 383 */         if (this.A == 0) this.x -= paramInt & 0xF; 
/*     */         break;
/*     */       case 240:
/* 386 */         if (this.A == 0) this.x -= (paramInt & 0xF) << 2; 
/*     */         break;
/*     */       default:
/* 389 */         if (this.A > 0) this.x -= paramInt << 2; 
/*     */         break;
/*     */     } 
/* 392 */     if (this.x < 0) this.x = 0; 
/*     */   }
/*     */   
/*     */   private void b(int paramInt) {
/* 396 */     if (this.x > 0) {
/* 397 */       switch (paramInt & 0xF0) {
/*     */         case 224:
/* 399 */           if (this.A == 0) this.x += paramInt & 0xF; 
/*     */           break;
/*     */         case 240:
/* 402 */           if (this.A == 0) this.x += (paramInt & 0xF) << 2; 
/*     */           break;
/*     */         default:
/* 405 */           if (this.A > 0) this.x += paramInt << 2; 
/*     */           break;
/*     */       } 
/* 408 */       if (this.x > 65535) this.x = 65535; 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d() {
/* 413 */     if (this.x > 0)
/* 414 */       if (this.x < this.y)
/* 415 */       { this.x += this.E << 2;
/* 416 */         if (this.x > this.y) { this.x = this.y; return; }
/*     */          }
/* 418 */       else { this.x -= this.E << 2;
/* 419 */         if (this.x < this.y) this.x = this.y;
/*     */          }
/*     */        
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 425 */     this.ac = a(this.U, this.T & 0x3) * this.W >> (paramBoolean ? 7 : 5);
/*     */   }
/*     */   
/*     */   private void e() {
/* 429 */     this.ab = a(this.Y, this.X & 0x3) * this.aa >> 6;
/*     */   }
/*     */ 
/*     */   
/*     */   private int a(int paramInt1, int paramInt2) {
/* 434 */     switch (paramInt2)
/*     */     { default:
/* 436 */         paramInt2 = b[paramInt1 & 0x1F];
/* 437 */         if ((paramInt1 & 0x20) > 0) paramInt2 = -paramInt2;
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
/* 453 */         return paramInt2;case 6: paramInt2 = ((paramInt1 + 32 & 0x3F) << 3) - 255; return paramInt2;case 1: case 7: paramInt2 = 255 - ((paramInt1 + 32 & 0x3F) << 3); return paramInt2;case 2: case 5: paramInt2 = ((paramInt1 & 0x20) > 0) ? 255 : -255; return paramInt2;case 3: case 8: break; }  paramInt2 = (this.af >> 20) - 255; this.af = this.af * 65 + 17 & 0x1FFFFFFF; return paramInt2;
/*     */   }
/*     */   
/*     */   private void f() {
/* 457 */     if (this.z >= this.R) this.ab = -64; 
/* 458 */     if (this.z >= this.R + this.S)
/* 459 */       this.ab = this.z = 0; 
/*     */   }
/*     */   
/*     */   private void g() {
/* 463 */     if (this.z >= this.Q) {
/* 464 */       this.z = this.n = this.o = 0;
/* 465 */       switch (this.P) { case 1:
/* 466 */           this.s--; break;
/* 467 */         case 2: this.s -= 2; break;
/* 468 */         case 3: this.s -= 4; break;
/* 469 */         case 4: this.s -= 8; break;
/* 470 */         case 5: this.s -= 16; break;
/* 471 */         case 6: this.s = (this.s << 1) / 3; break;
/* 472 */         case 7: this.s >>= 1; break;
/*     */         case 9:
/* 474 */           this.s++; break;
/* 475 */         case 10: this.s += 2; break;
/* 476 */         case 11: this.s += 4; break;
/* 477 */         case 12: this.s += 8; break;
/* 478 */         case 13: this.s += 16; break;
/* 479 */         case 14: this.s = this.s * 3 / 2; break;
/* 480 */         case 15: this.s <<= 1; break; }
/*     */       
/* 482 */       if (this.s < 0) this.s = 0; 
/* 483 */       if (this.s > 64) this.s = 64; 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void h() {
/* 488 */     int i = this.x + this.ac;
/* 489 */     if (this.c.linearPeriods) {
/*     */       
/* 491 */       if ((i = i - (this.ad << 6)) < 28 || i > 7680) i = 7680; 
/* 492 */       this.p = (this.c.c2Rate >> 4) * exp2((4608 - i << 15) / 768) >> 11; return;
/*     */     } 
/* 494 */     if (i > 29021) i = 29021;
/*     */     
/* 496 */     if ((i = (i << 15) / exp2((this.ad << 15) / 12)) < 28) i = 29021; 
/* 497 */     this.p = this.c.c2Rate * 1712 / i;
/*     */   }
/*     */ 
/*     */   
/*     */   private void i() {
/* 502 */     int i = this.g ? 64 : 0;
/* 503 */     if (this.e.volumeEnvelope.enabled)
/* 504 */       i = this.e.volumeEnvelope.calculateAmpl(this.v); 
/*     */     int j;
/* 506 */     if ((j = this.s + this.ab) > 64) j = 64; 
/* 507 */     if (j < 0) j = 0;
/*     */     
/* 509 */     j = (j = j * this.c.gain << 15 >> 13) * this.u >> 15;
/* 510 */     this.q = j * this.d.volume * i >> 12;
/* 511 */     i = 32;
/* 512 */     if (this.e.panningEnvelope.enabled)
/* 513 */       i = this.e.panningEnvelope.calculateAmpl(this.w); 
/* 514 */     j = (this.t < 128) ? this.t : (255 - this.t);
/* 515 */     this.r = this.t + (j * (i - 32) >> 5);
/*     */   }
/*     */   
/*     */   private void j() {
/* 519 */     if (this.i > 0 && this.i <= this.c.numInstruments) {
/* 520 */       this.e = this.c.instruments[this.i];
/* 521 */       Sample sample = this.e.samples[this.e.keyToSample[(this.h < 97) ? this.h : 0]];
/* 522 */       this.s = (sample.volume >= 64) ? 64 : (sample.volume & 0x3F);
/* 523 */       if (sample.panning >= 0) this.t = sample.panning & 0xFF; 
/* 524 */       if (this.x > 0 && sample.looped()) this.f = sample; 
/* 525 */       this.m = this.v = this.w = 0;
/* 526 */       this.u = 32768;
/* 527 */       this.g = true;
/*     */     } 
/* 529 */     if (this.k == 9 || this.k == 143) {
/* 530 */       if (this.l > 0) this.F = this.l; 
/* 531 */       this.m = this.F << 8;
/*     */     } 
/* 533 */     if (this.j >= 16 && this.j < 96)
/* 534 */       this.s = (this.j < 80) ? (this.j - 16) : 64; 
/* 535 */     switch (this.j & 0xF0) {
/*     */       case 128:
/* 537 */         this.s -= this.j & 0xF;
/* 538 */         if (this.s < 0) this.s = 0; 
/*     */         break;
/*     */       case 144:
/* 541 */         this.s += this.j & 0xF;
/* 542 */         if (this.s > 64) this.s = 64; 
/*     */         break;
/*     */       case 160:
/* 545 */         if ((this.j & 0xF) > 0) this.V = this.j & 0xF; 
/*     */         break;
/*     */       case 176:
/* 548 */         if ((this.j & 0xF) > 0) this.W = this.j & 0xF; 
/* 549 */         a(false);
/*     */         break;
/*     */       case 192:
/* 552 */         this.t = (this.j & 0xF) * 17;
/*     */         break;
/*     */       case 240:
/* 555 */         if ((this.j & 0xF) > 0) this.E = this.j & 0xF; 
/*     */         break;
/*     */     } 
/* 558 */     if (this.h > 0) {
/* 559 */       if (this.h > 96) {
/* 560 */         this.g = false;
/*     */         
/*     */         return;
/*     */       } 
/*     */       boolean bool;
/* 565 */       if (!(bool = ((this.j & 0xF0) == 240 || this.k == 3 || this.k == 5 || this.k == 135 || this.k == 140) ? true : false)) this.f = this.e.samples[this.e.keyToSample[this.h]]; 
/* 566 */       int i = this.f.fineTune;
/* 567 */       if (this.k == 117 || this.k == 242) {
/* 568 */         i = ((this.l & 0xF) << 4) - 128;
/*     */       }
/*     */       int j;
/* 571 */       if ((j = this.h + this.f.relNote) <= 0) j = 1; 
/* 572 */       if (j > 120) j = 120; 
/* 573 */       i = (j << 6) + (i >> 1);
/* 574 */       if (this.c.linearPeriods) {
/* 575 */         this.y = 7744 - i;
/*     */       } else {
/* 577 */         this.y = 29021 * exp2((i << 15) / -768) >> 15;
/*     */       } 
/* 579 */       if (!bool) {
/* 580 */         this.x = this.y;
/* 581 */         this.n = this.m;
/* 582 */         this.o = 0;
/* 583 */         if (this.T < 4) this.U = 0; 
/* 584 */         if (this.X < 4) this.Y = 0; 
/* 585 */         this.z = this.B = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int exp2(int paramInt) {
/* 592 */     int i = (paramInt & 0x7FFF) >> 8;
/* 593 */     int j = a[i];
/*     */ 
/*     */     
/* 596 */     return (i = ((i = a[i + 1] - j) * (paramInt & 0xFF) >> 8) + j) << 15 >> 15 - (paramInt >> 15);
/*     */   }
/*     */   
/*     */   public static int log2(int paramInt) {
/* 600 */     int i = 524288;
/* 601 */     for (int j = 524288; j > 0; j >>= 1) {
/* 602 */       if (exp2(i - j) >= paramInt) i -= j; 
/*     */     } 
/* 604 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Channel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */