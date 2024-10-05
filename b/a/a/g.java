/*     */ package b.a.a;
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
/*     */ public final class g
/*     */ {
/*  33 */   private static int[][] a = new int[][] { { 22050, 24000, 16000, 1 }, { 44100, 48000, 32000, 1 }, { 11025, 12000, 8000, 1 } };
/*     */ 
/*     */   
/*     */   private int b;
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */   
/*     */   private int e;
/*     */ 
/*     */   
/*     */   private int f;
/*     */ 
/*     */   
/*     */   private int g;
/*     */ 
/*     */   
/*     */   private int h;
/*     */   
/*     */   private int i;
/*     */   
/*     */   private int j;
/*     */   
/*     */   private int k;
/*     */   
/*  62 */   private double[] l = new double[] { -1.0D, 384.0D, 1152.0D, 1152.0D };
/*     */   
/*     */   private boolean m;
/*     */   
/*     */   private int n;
/*     */   private int o;
/*     */   private byte[] p;
/*  69 */   private byte q = b.a;
/*     */ 
/*     */   
/*     */   private d r;
/*     */   
/*     */   private short s;
/*     */   
/*     */   private int t;
/*     */   
/*     */   private int u;
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     StringBuffer stringBuffer;
/*  83 */     (stringBuffer = new StringBuffer(200)).append("Layer ");
/*  84 */     stringBuffer.append(p());
/*  85 */     stringBuffer.append(" frame ");
/*  86 */     stringBuffer.append(t());
/*  87 */     stringBuffer.append(' ');
/*  88 */     stringBuffer.append(u());
/*  89 */     if (!m()) stringBuffer.append(" no"); 
/*  90 */     stringBuffer.append(" checksums");
/*  91 */     stringBuffer.append(' ');
/*  92 */     stringBuffer.append(s());
/*  93 */     stringBuffer.append(',');
/*  94 */     stringBuffer.append(' ');
/*  95 */     stringBuffer.append(q());
/*     */     
/*     */     String str;
/*  98 */     return str = stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(b paramb, d[] paramArrayOfd) {
/* 107 */     boolean bool = false;
/*     */     while (true) {
/* 109 */       int i = paramb.a(this.q);
/*     */       
/* 111 */       if (this.q == b.a) {
/* 112 */         this.g = i >>> 19 & 0x1;
/* 113 */         if ((i >>> 20 & 0x1) == 0)
/* 114 */           if (this.g == 0) {
/* 115 */             this.g = 2;
/*     */           } else {
/* 117 */             throw b.b(256);
/* 118 */           }   if ((this.i = i >>> 10 & 0x3) == 3) throw b.b(256); 
/*     */       } 
/* 120 */       this.b = 4 - (i >>> 17) & 0x3;
/* 121 */       this.c = i >>> 16 & 0x1;
/* 122 */       this.d = i >>> 12 & 0xF;
/* 123 */       this.e = i >>> 9 & 0x1;
/* 124 */       this.h = i >>> 6 & 0x3;
/* 125 */       this.f = i >>> 4 & 0x3;
/* 126 */       if (this.h == 1) {
/* 127 */         this.k = (this.f << 2) + 4;
/*     */       } else {
/* 129 */         this.k = 0;
/*     */       } 
/*     */ 
/*     */       
/* 133 */       if (this.b == 1) {
/* 134 */         this.j = 32;
/*     */       } else {
/* 136 */         int k = this.d;
/*     */         
/* 138 */         if (this.h != 3) if (k == 4) {
/* 139 */             k = 1;
/*     */           } else {
/* 141 */             k -= 4;
/* 142 */           }   if (k == 1 || k == 2) {
/* 143 */           if (this.i == 2)
/* 144 */           { this.j = 12; }
/*     */           else
/* 146 */           { this.j = 8; } 
/* 147 */         } else if (this.i == 1 || (k >= 3 && k <= 5)) {
/* 148 */           this.j = 27;
/*     */         } else {
/* 150 */           this.j = 30;
/*     */         } 
/* 152 */       }  if (this.k > this.j) this.k = this.j;
/*     */       
/* 154 */       n();
/*     */       
/* 156 */       int j = paramb.c(this.t);
/* 157 */       if (this.t >= 0 && j != this.t)
/*     */       {
/* 159 */         throw b.b(261); } 
/* 160 */       if (paramb.a(this.q)) {
/* 161 */         if (this.q == b.a) {
/* 162 */           this.q = b.b;
/* 163 */           paramb.e(i & 0xFFF80CC0);
/*     */         } 
/* 165 */         bool = true;
/*     */       } else {
/* 167 */         paramb.c();
/* 168 */       }  if (bool) {
/* 169 */         paramb.e();
/* 170 */         if (this.c == 0) {
/*     */           
/* 172 */           this.s = (short)paramb.d(16);
/* 173 */           if (this.r == null) this.r = new d(); 
/* 174 */           this.r.a(i, 16);
/* 175 */           paramArrayOfd[0] = this.r; return;
/*     */         } 
/* 177 */         paramArrayOfd[0] = null;
/*     */         return;
/*     */       } 
/*     */     } 
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
/*     */   
/*     */   final void a(byte[] paramArrayOfbyte) {
/*     */     byte b;
/* 194 */     String str = "Xing";
/* 195 */     byte[] arrayOfByte = new byte[4];
/*     */ 
/*     */     
/* 198 */     if (this.g == 1) {
/* 199 */       if (this.h == 3)
/* 200 */       { b = 17; }
/*     */       else
/* 202 */       { b = 32; } 
/* 203 */     } else if (this.h == 3) {
/* 204 */       b = 9;
/*     */     } else {
/* 206 */       b = 17;
/*     */     }  try {
/* 208 */       System.arraycopy(paramArrayOfbyte, b, arrayOfByte, 0, 4);
/*     */       
/* 210 */       if (str.equals(new String(arrayOfByte)))
/*     */       {
/* 212 */         this.m = true;
/* 213 */         this.n = -1;
/* 214 */         this.o = -1;
/*     */         
/* 216 */         this.p = new byte[100];
/*     */ 
/*     */ 
/*     */         
/* 220 */         byte[] arrayOfByte1 = new byte[4];
/* 221 */         System.arraycopy(paramArrayOfbyte, b + 4, arrayOfByte1, 0, 4);
/* 222 */         int i = 8;
/*     */         
/* 224 */         if ((arrayOfByte1[3] & 0x1) != 0) {
/* 225 */           System.arraycopy(paramArrayOfbyte, b + 8, arrayOfByte, 0, 4);
/* 226 */           this.n = arrayOfByte[0] << 24 & 0xFF000000 | arrayOfByte[1] << 16 & 0xFF0000 | arrayOfByte[2] << 8 & 0xFF00 | arrayOfByte[3] & 0xFF;
/*     */           
/* 228 */           i += 4;
/*     */         } 
/*     */         
/* 231 */         if ((arrayOfByte1[3] & 0x2) != 0) {
/* 232 */           System.arraycopy(paramArrayOfbyte, b + i, arrayOfByte, 0, 4);
/* 233 */           this.o = arrayOfByte[0] << 24 & 0xFF000000 | arrayOfByte[1] << 16 & 0xFF0000 | arrayOfByte[2] << 8 & 0xFF00 | arrayOfByte[3] & 0xFF;
/*     */           
/* 235 */           i += 4;
/*     */         } 
/*     */         
/* 238 */         if ((arrayOfByte1[3] & 0x4) != 0) {
/* 239 */           System.arraycopy(paramArrayOfbyte, b + i, this.p, 0, this.p.length);
/* 240 */           i += this.p.length;
/*     */         } 
/*     */         
/* 243 */         if ((arrayOfByte1[3] & 0x8) != 0) {
/* 244 */           System.arraycopy(paramArrayOfbyte, b + i, arrayOfByte, 0, 4);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 251 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 252 */       throw new c("XingVBRHeader Corrupted", arrayIndexOutOfBoundsException);
/*     */     } 
/*     */ 
/*     */     
/* 256 */     str = "VBRI";
/*     */     
/*     */     try {
/* 259 */       System.arraycopy(paramArrayOfbyte, 32, arrayOfByte, 0, 4);
/*     */       
/* 261 */       if (str.equals(new String(arrayOfByte))) {
/*     */         
/* 263 */         this.m = true;
/* 264 */         this.n = -1;
/* 265 */         this.o = -1;
/*     */         
/* 267 */         this.p = new byte[100];
/*     */ 
/*     */         
/* 270 */         System.arraycopy(paramArrayOfbyte, 42, arrayOfByte, 0, 4);
/* 271 */         this.o = arrayOfByte[0] << 24 & 0xFF000000 | arrayOfByte[1] << 16 & 0xFF0000 | arrayOfByte[2] << 8 & 0xFF00 | arrayOfByte[3] & 0xFF;
/*     */ 
/*     */         
/* 274 */         System.arraycopy(paramArrayOfbyte, 46, arrayOfByte, 0, 4);
/* 275 */         this.n = arrayOfByte[0] << 24 & 0xFF000000 | arrayOfByte[1] << 16 & 0xFF0000 | arrayOfByte[2] << 8 & 0xFF00 | arrayOfByte[3] & 0xFF;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/* 281 */     } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 282 */       throw new c("VBRIVBRHeader Corrupted", arrayIndexOutOfBoundsException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/* 291 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 298 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/* 305 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int d() {
/* 312 */     return this.i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int e() {
/* 319 */     return a[this.g][this.i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int f() {
/* 326 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean m() {
/* 333 */     if (this.c == 0) {
/* 334 */       return true;
/*     */     }
/* 336 */     return false;
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
/*     */   public final boolean g() {
/* 381 */     return (this.s == this.r.a());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int h() {
/* 399 */     return this.u;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int i() {
/* 406 */     return this.f;
/*     */   }
/*     */   
/* 409 */   private static final int[][][] v = new int[][][] { { { 0, 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000, 0 }, { 0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0 }, { 0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0 } }, { { 0, 32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000, 0 }, { 0, 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000, 0 }, { 0, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 0 } }, { { 0, 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000, 0 }, { 0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0 }, { 0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0 } } };
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
/*     */   private int n() {
/* 442 */     if (this.b == 1)
/* 443 */     { this.t = 12 * v[this.g][0][this.d] / a[this.g][this.i];
/* 444 */       if (this.e != 0) this.t++; 
/* 445 */       this.t <<= 2; }
/*     */     else
/*     */     
/* 448 */     { this.t = 144 * v[this.g][this.b - 1][this.d] / a[this.g][this.i];
/* 449 */       if (this.g == 0 || this.g == 2) this.t >>= 1; 
/* 450 */       if (this.e != 0) this.t++;
/*     */       
/* 452 */       if (this.b == 3)
/* 453 */       { if (this.g == 1) {
/* 454 */           this.u = this.t - ((this.h == 3) ? 17 : 32) - ((this.c != 0) ? 0 : 2) - 4;
/*     */         }
/*     */         else {
/*     */           
/* 458 */           this.u = this.t - ((this.h == 3) ? 9 : 17) - ((this.c != 0) ? 0 : 2) - 4;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 464 */         this.t -= 4;
/* 465 */         return this.t; }  }  this.u = 0; this.t -= 4; return this.t;
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
/*     */   private float o() {
/* 504 */     if (this.m == true) {
/* 505 */       double d1 = this.l[b()] / e();
/* 506 */       if (this.g == 0 || this.g == 2) d1 /= 2.0D; 
/* 507 */       return (float)(d1 * 1000.0D);
/*     */     } 
/*     */     float[][] arrayOfFloat;
/* 510 */     return (arrayOfFloat = new float[][] { { 8.707483F, 8.0F, 12.0F }, { 26.12245F, 24.0F, 36.0F }, { 26.12245F, 24.0F, 36.0F } })[this.b - 1][this.i];
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
/*     */   private String p() {
/* 537 */     switch (this.b) {
/*     */       case 1:
/* 539 */         return "I";
/*     */       case 2:
/* 541 */         return "II";
/*     */       case 3:
/* 543 */         return "III";
/*     */     } 
/* 545 */     return null;
/*     */   }
/*     */ 
/*     */   
/* 549 */   private static final String[][][] w = new String[][][] { { { "free format", "32 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "176 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "forbidden" }, { "free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden" }, { "free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden" } }, { { "free format", "32 kbit/s", "64 kbit/s", "96 kbit/s", "128 kbit/s", "160 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "288 kbit/s", "320 kbit/s", "352 kbit/s", "384 kbit/s", "416 kbit/s", "448 kbit/s", "forbidden" }, { "free format", "32 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "160 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "320 kbit/s", "384 kbit/s", "forbidden" }, { "free format", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "160 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "320 kbit/s", "forbidden" } }, { { "free format", "32 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "176 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "forbidden" }, { "free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden" }, { "free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden" } } };
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
/*     */   private String q() {
/* 579 */     if (this.m == true) {
/* 580 */       return Integer.toString(r() / 1000) + " kb/s";
/*     */     }
/* 582 */     return w[this.g][this.b - 1][this.d];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int r() {
/* 590 */     if (this.m == true) {
/* 591 */       return (int)((this.o << 3) / o() * this.n) * 1000;
/*     */     }
/* 593 */     return v[this.g][this.b - 1][this.d];
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String s() {
/* 609 */     switch (this.i) {
/*     */       case 2:
/* 611 */         if (this.g == 1)
/* 612 */           return "32 kHz"; 
/* 613 */         if (this.g == 0) {
/* 614 */           return "16 kHz";
/*     */         }
/*     */         
/* 617 */         return "8 kHz";
/*     */       case 0:
/* 619 */         if (this.g == 1)
/* 620 */           return "44.1 kHz"; 
/* 621 */         if (this.g == 0) {
/* 622 */           return "22.05 kHz";
/*     */         }
/*     */         
/* 625 */         return "11.025 kHz";
/*     */       case 1:
/* 627 */         if (this.g == 1)
/* 628 */           return "48 kHz"; 
/* 629 */         if (this.g == 0) {
/* 630 */           return "24 kHz";
/*     */         }
/*     */         
/* 633 */         return "12 kHz";
/*     */     } 
/* 635 */     return null;
/*     */   }
/*     */   
/*     */   public final int j() {
/* 639 */     switch (this.i) {
/*     */       case 2:
/* 641 */         if (this.g == 1)
/* 642 */           return 32000; 
/* 643 */         if (this.g == 0) {
/* 644 */           return 16000;
/*     */         }
/*     */         
/* 647 */         return 8000;
/*     */       case 0:
/* 649 */         if (this.g == 1)
/* 650 */           return 44100; 
/* 651 */         if (this.g == 0) {
/* 652 */           return 22050;
/*     */         }
/*     */         
/* 655 */         return 11025;
/*     */       case 1:
/* 657 */         if (this.g == 1)
/* 658 */           return 48000; 
/* 659 */         if (this.g == 0) {
/* 660 */           return 24000;
/*     */         }
/*     */         
/* 663 */         return 12000;
/*     */     } 
/* 665 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String t() {
/* 672 */     switch (this.h) {
/*     */       case 0:
/* 674 */         return "Stereo";
/*     */       case 1:
/* 676 */         return "Joint stereo";
/*     */       case 2:
/* 678 */         return "Dual channel";
/*     */       case 3:
/* 680 */         return "Single channel";
/*     */     } 
/* 682 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String u() {
/* 690 */     switch (this.g) {
/*     */       case 1:
/* 692 */         return "MPEG-1";
/*     */       case 0:
/* 694 */         return "MPEG-2 LSF";
/*     */       case 2:
/* 696 */         return "MPEG-2.5 LSF";
/*     */     } 
/* 698 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int k() {
/* 706 */     return this.j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int l() {
/* 715 */     return this.k;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */