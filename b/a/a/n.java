/*      */ package b.a.a;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InvalidClassException;
/*      */ import java.io.InvalidObjectException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.lang.reflect.Array;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class n
/*      */ {
/*      */   private float[] a;
/*      */   private float[] b;
/*      */   private float[] c;
/*      */   private int d;
/*      */   private float[] e;
/*      */   private int f;
/*      */   private float g;
/*      */   
/*      */   public n(int paramInt, float paramFloat) {
/*   69 */     if (N == null)
/*      */     {
/*   71 */       O = a(N = s(), 16);
/*      */     }
/*      */     
/*   74 */     this.a = new float[512];
/*   75 */     this.b = new float[512];
/*   76 */     this.e = new float[32];
/*   77 */     this.f = paramInt;
/*   78 */     this.g = 32700.0F;
/*      */     
/*   80 */     a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a() {
/*      */     byte b;
/*  100 */     for (b = 0; b < 'Ȁ'; b++) {
/*  101 */       this.b[b] = 0.0F; this.a[b] = 0.0F;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  106 */     for (b = 0; b < 32; b++) {
/*  107 */       this.e[b] = 0.0F;
/*      */     }
/*  109 */     this.c = this.a;
/*  110 */     this.d = 15;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(float paramFloat, int paramInt) {
/*  117 */     this.e[paramInt] = paramFloat;
/*      */   }
/*      */   
/*      */   public final void a(float[] paramArrayOffloat) {
/*  121 */     for (byte b = 31; b >= 0; b--) {
/*  122 */       this.e[b] = paramArrayOffloat[b];
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/*  155 */     float arrayOfFloat1[], f2 = (arrayOfFloat1 = this.e)[0];
/*  156 */     float f4 = arrayOfFloat1[1];
/*  157 */     float f6 = arrayOfFloat1[2];
/*  158 */     float f8 = arrayOfFloat1[3];
/*  159 */     float f10 = arrayOfFloat1[4];
/*  160 */     float f12 = arrayOfFloat1[5];
/*  161 */     float f14 = arrayOfFloat1[6];
/*  162 */     float f16 = arrayOfFloat1[7];
/*  163 */     float f17 = arrayOfFloat1[8];
/*  164 */     float f19 = arrayOfFloat1[9];
/*  165 */     float f21 = arrayOfFloat1[10];
/*  166 */     float f23 = arrayOfFloat1[11];
/*  167 */     float f25 = arrayOfFloat1[12];
/*  168 */     float f27 = arrayOfFloat1[13];
/*  169 */     float f29 = arrayOfFloat1[14];
/*  170 */     float f31 = arrayOfFloat1[15];
/*  171 */     float f33 = arrayOfFloat1[16];
/*  172 */     float f34 = arrayOfFloat1[17];
/*  173 */     float f35 = arrayOfFloat1[18];
/*  174 */     float f36 = arrayOfFloat1[19];
/*  175 */     float f37 = arrayOfFloat1[20];
/*  176 */     float f38 = arrayOfFloat1[21];
/*  177 */     float f39 = arrayOfFloat1[22];
/*  178 */     float f40 = arrayOfFloat1[23];
/*  179 */     float f41 = arrayOfFloat1[24];
/*  180 */     float f42 = arrayOfFloat1[25];
/*  181 */     float f43 = arrayOfFloat1[26];
/*  182 */     float f44 = arrayOfFloat1[27];
/*  183 */     float f45 = arrayOfFloat1[28];
/*  184 */     float f46 = arrayOfFloat1[29];
/*  185 */     float f47 = arrayOfFloat1[30];
/*  186 */     float f48 = arrayOfFloat1[31];
/*      */     
/*  188 */     float f49 = f2 + f48;
/*  189 */     float f50 = f4 + f47;
/*  190 */     float f51 = f6 + f46;
/*  191 */     float f52 = f8 + f45;
/*  192 */     float f53 = f10 + f44;
/*  193 */     float f54 = f12 + f43;
/*  194 */     float f55 = f14 + f42;
/*  195 */     float f56 = f16 + f41;
/*  196 */     float f57 = f17 + f40;
/*  197 */     float f58 = f19 + f39;
/*  198 */     float f59 = f21 + f38;
/*  199 */     float f60 = f23 + f37;
/*  200 */     float f61 = f25 + f36;
/*  201 */     float f62 = f27 + f35;
/*  202 */     float f63 = f29 + f34;
/*  203 */     float f64 = f31 + f33;
/*      */     
/*  205 */     float f65 = f49 + f64;
/*  206 */     float f66 = f50 + f63;
/*  207 */     float f67 = f51 + f62;
/*  208 */     float f68 = f52 + f61;
/*  209 */     float f69 = f53 + f60;
/*  210 */     float f70 = f54 + f59;
/*  211 */     float f71 = f55 + f58;
/*  212 */     float f72 = f56 + f57;
/*  213 */     float f73 = (f49 - f64) * y;
/*  214 */     float f74 = (f50 - f63) * z;
/*  215 */     float f75 = (f51 - f62) * A;
/*  216 */     float f76 = (f52 - f61) * B;
/*  217 */     float f77 = (f53 - f60) * C;
/*  218 */     float f78 = (f54 - f59) * D;
/*  219 */     float f79 = (f55 - f58) * E;
/*  220 */     float f80 = (f56 - f57) * F;
/*      */     
/*  222 */     f49 = f65 + f72;
/*  223 */     f50 = f66 + f71;
/*  224 */     f51 = f67 + f70;
/*  225 */     f52 = f68 + f69;
/*  226 */     f53 = (f65 - f72) * G;
/*  227 */     f54 = (f66 - f71) * H;
/*  228 */     f55 = (f67 - f70) * I;
/*  229 */     f56 = (f68 - f69) * J;
/*  230 */     f57 = f73 + f80;
/*  231 */     f58 = f74 + f79;
/*  232 */     f59 = f75 + f78;
/*  233 */     f60 = f76 + f77;
/*  234 */     f61 = (f73 - f80) * G;
/*  235 */     f62 = (f74 - f79) * H;
/*  236 */     f63 = (f75 - f78) * I;
/*  237 */     f64 = (f76 - f77) * J;
/*      */     
/*  239 */     f65 = f49 + f52;
/*  240 */     f66 = f50 + f51;
/*  241 */     f67 = (f49 - f52) * K;
/*  242 */     f68 = (f50 - f51) * L;
/*  243 */     f69 = f53 + f56;
/*  244 */     f70 = f54 + f55;
/*  245 */     f71 = (f53 - f56) * K;
/*  246 */     f72 = (f54 - f55) * L;
/*  247 */     f73 = f57 + f60;
/*  248 */     f74 = f58 + f59;
/*  249 */     f75 = (f57 - f60) * K;
/*  250 */     f76 = (f58 - f59) * L;
/*  251 */     f77 = f61 + f64;
/*  252 */     f78 = f62 + f63;
/*  253 */     f79 = (f61 - f64) * K;
/*  254 */     f80 = (f62 - f63) * L;
/*      */     
/*  256 */     f49 = f65 + f66;
/*  257 */     f50 = (f65 - f66) * M;
/*  258 */     f51 = f67 + f68;
/*  259 */     f52 = (f67 - f68) * M;
/*  260 */     f53 = f69 + f70;
/*  261 */     f54 = (f69 - f70) * M;
/*  262 */     f55 = f71 + f72;
/*  263 */     f56 = (f71 - f72) * M;
/*  264 */     f57 = f73 + f74;
/*  265 */     f58 = (f73 - f74) * M;
/*  266 */     f59 = f75 + f76;
/*  267 */     f60 = (f75 - f76) * M;
/*  268 */     f61 = f77 + f78;
/*  269 */     f62 = (f77 - f78) * M;
/*  270 */     f63 = f79 + f80;
/*  271 */     f64 = (f79 - f80) * M;
/*      */ 
/*      */ 
/*      */     
/*  275 */     float f5, f13, f20 = -(f5 = (f13 = f56) + f54) - f55;
/*  276 */     float f28 = -f55 - f56 - f53;
/*  277 */     float f11, f15, f7 = (f11 = (f15 = f64) + f60) + f62;
/*  278 */     float f3, f18 = -(f3 = f64 + f62 + f58) - f63;
/*  279 */     float f81, f22 = (f81 = -f63 - f64 - f59 - f60) - f62;
/*  280 */     float f30 = -f63 - f64 - f61 - f57;
/*  281 */     float f26 = f81 - f61;
/*  282 */     float f32 = -f49;
/*  283 */     float f1 = f50;
/*  284 */     float f9, f24 = -(f9 = f52) - f51;
/*      */     
/*  286 */     f49 = (f2 - f48) * i;
/*  287 */     f50 = (f4 - f47) * j;
/*  288 */     f51 = (f6 - f46) * k;
/*  289 */     f52 = (f8 - f45) * l;
/*  290 */     f53 = (f10 - f44) * m;
/*  291 */     f54 = (f12 - f43) * n;
/*  292 */     f55 = (f14 - f42) * o;
/*  293 */     f56 = (f16 - f41) * p;
/*  294 */     f57 = (f17 - f40) * q;
/*  295 */     f58 = (f19 - f39) * r;
/*  296 */     f59 = (f21 - f38) * s;
/*  297 */     f60 = (f23 - f37) * t;
/*  298 */     f61 = (f25 - f36) * u;
/*  299 */     f62 = (f27 - f35) * v;
/*  300 */     f63 = (f29 - f34) * w;
/*  301 */     f64 = (f31 - f33) * x;
/*      */     
/*  303 */     f65 = f49 + f64;
/*  304 */     f66 = f50 + f63;
/*  305 */     f67 = f51 + f62;
/*  306 */     f68 = f52 + f61;
/*  307 */     f69 = f53 + f60;
/*  308 */     f70 = f54 + f59;
/*  309 */     f71 = f55 + f58;
/*  310 */     f72 = f56 + f57;
/*  311 */     f73 = (f49 - f64) * y;
/*  312 */     f74 = (f50 - f63) * z;
/*  313 */     f75 = (f51 - f62) * A;
/*  314 */     f76 = (f52 - f61) * B;
/*  315 */     f77 = (f53 - f60) * C;
/*  316 */     f78 = (f54 - f59) * D;
/*  317 */     f79 = (f55 - f58) * E;
/*  318 */     f80 = (f56 - f57) * F;
/*      */     
/*  320 */     f49 = f65 + f72;
/*  321 */     f50 = f66 + f71;
/*  322 */     f51 = f67 + f70;
/*  323 */     f52 = f68 + f69;
/*  324 */     f53 = (f65 - f72) * G;
/*  325 */     f54 = (f66 - f71) * H;
/*  326 */     f55 = (f67 - f70) * I;
/*  327 */     f56 = (f68 - f69) * J;
/*  328 */     f57 = f73 + f80;
/*  329 */     f58 = f74 + f79;
/*  330 */     f59 = f75 + f78;
/*  331 */     f60 = f76 + f77;
/*  332 */     f61 = (f73 - f80) * G;
/*  333 */     f62 = (f74 - f79) * H;
/*  334 */     f63 = (f75 - f78) * I;
/*  335 */     f64 = (f76 - f77) * J;
/*      */     
/*  337 */     f65 = f49 + f52;
/*  338 */     f66 = f50 + f51;
/*  339 */     f67 = (f49 - f52) * K;
/*  340 */     f68 = (f50 - f51) * L;
/*  341 */     f69 = f53 + f56;
/*  342 */     f70 = f54 + f55;
/*  343 */     f71 = (f53 - f56) * K;
/*  344 */     f72 = (f54 - f55) * L;
/*  345 */     f73 = f57 + f60;
/*  346 */     f74 = f58 + f59;
/*  347 */     f75 = (f57 - f60) * K;
/*  348 */     f76 = (f58 - f59) * L;
/*  349 */     f77 = f61 + f64;
/*  350 */     f78 = f62 + f63;
/*  351 */     f79 = (f61 - f64) * K;
/*  352 */     f80 = (f62 - f63) * L;
/*      */     
/*  354 */     f49 = f65 + f66;
/*  355 */     f50 = (f65 - f66) * M;
/*  356 */     f51 = f67 + f68;
/*  357 */     f52 = (f67 - f68) * M;
/*  358 */     f53 = f69 + f70;
/*  359 */     f54 = (f69 - f70) * M;
/*  360 */     f55 = f71 + f72;
/*  361 */     f56 = (f71 - f72) * M;
/*  362 */     f57 = f73 + f74;
/*  363 */     f58 = (f73 - f74) * M;
/*  364 */     f59 = f75 + f76;
/*  365 */     f60 = (f75 - f76) * M;
/*  366 */     f61 = f77 + f78;
/*  367 */     f62 = (f77 - f78) * M;
/*  368 */     f63 = f79 + f80;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  374 */     f6 = (f12 = (f14 = (f16 = f64 = (f79 - f80) * M) + f56) + f60) + f54 + f62;
/*  375 */     f8 = (f10 = f64 + f60 + f52) + f62;
/*  376 */     f17 = -(f2 = (f81 = f62 + f64 + f58) + f50) - f63;
/*  377 */     f19 = -(f4 = f81 + f54 + f56) - f55 - f63;
/*      */     
/*  379 */     f23 = (f81 = -f59 - f60 - f63 - f64) - f62 - f51 - f52;
/*  380 */     f21 = f81 - f62 - f54 - f55 - f56;
/*  381 */     f25 = f81 - f61 - f51 - f52; float f82;
/*  382 */     f27 = f81 - f61 - (f82 = f53 + f55 + f56);
/*  383 */     f31 = (f81 = -f57 - f61 - f63 - f64) - f49;
/*  384 */     f29 = f81 - f82;
/*      */ 
/*      */ 
/*      */     
/*  388 */     float[] arrayOfFloat2 = this.c;
/*      */     
/*  390 */     int i = this.d;
/*      */     
/*  392 */     arrayOfFloat2[i + 0] = f1;
/*  393 */     arrayOfFloat2[i + 16] = f2;
/*  394 */     arrayOfFloat2[i + 32] = f3;
/*  395 */     arrayOfFloat2[i + 48] = f4;
/*  396 */     arrayOfFloat2[i + 64] = f5;
/*  397 */     arrayOfFloat2[i + 80] = f6;
/*  398 */     arrayOfFloat2[i + 96] = f7;
/*  399 */     arrayOfFloat2[i + 112] = f8;
/*  400 */     arrayOfFloat2[i + 128] = f9;
/*  401 */     arrayOfFloat2[i + 144] = f10;
/*  402 */     arrayOfFloat2[i + 160] = f11;
/*  403 */     arrayOfFloat2[i + 176] = f12;
/*  404 */     arrayOfFloat2[i + 192] = f13;
/*  405 */     arrayOfFloat2[i + 208] = f14;
/*  406 */     arrayOfFloat2[i + 224] = f15;
/*  407 */     arrayOfFloat2[i + 240] = f16;
/*      */ 
/*      */     
/*  410 */     arrayOfFloat2[i + 256] = 0.0F;
/*      */ 
/*      */     
/*  413 */     arrayOfFloat2[i + 272] = -f16;
/*  414 */     arrayOfFloat2[i + 288] = -f15;
/*  415 */     arrayOfFloat2[i + 304] = -f14;
/*  416 */     arrayOfFloat2[i + 320] = -f13;
/*  417 */     arrayOfFloat2[i + 336] = -f12;
/*  418 */     arrayOfFloat2[i + 352] = -f11;
/*  419 */     arrayOfFloat2[i + 368] = -f10;
/*  420 */     arrayOfFloat2[i + 384] = -f9;
/*  421 */     arrayOfFloat2[i + 400] = -f8;
/*  422 */     arrayOfFloat2[i + 416] = -f7;
/*  423 */     arrayOfFloat2[i + 432] = -f6;
/*  424 */     arrayOfFloat2[i + 448] = -f5;
/*  425 */     arrayOfFloat2[i + 464] = -f4;
/*  426 */     arrayOfFloat2[i + 480] = -f3;
/*  427 */     arrayOfFloat2[i + 496] = -f2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  432 */     (arrayOfFloat2 = (this.c == this.a) ? this.b : this.a)[i + 0] = -f1;
/*      */     
/*  434 */     arrayOfFloat2[i + 16] = f17;
/*  435 */     arrayOfFloat2[i + 32] = f18;
/*  436 */     arrayOfFloat2[i + 48] = f19;
/*  437 */     arrayOfFloat2[i + 64] = f20;
/*  438 */     arrayOfFloat2[i + 80] = f21;
/*  439 */     arrayOfFloat2[i + 96] = f22;
/*  440 */     arrayOfFloat2[i + 112] = f23;
/*  441 */     arrayOfFloat2[i + 128] = f24;
/*  442 */     arrayOfFloat2[i + 144] = f25;
/*  443 */     arrayOfFloat2[i + 160] = f26;
/*  444 */     arrayOfFloat2[i + 176] = f27;
/*  445 */     arrayOfFloat2[i + 192] = f28;
/*  446 */     arrayOfFloat2[i + 208] = f29;
/*  447 */     arrayOfFloat2[i + 224] = f30;
/*  448 */     arrayOfFloat2[i + 240] = f31;
/*  449 */     arrayOfFloat2[i + 256] = f32;
/*      */ 
/*      */     
/*  452 */     arrayOfFloat2[i + 272] = f31;
/*  453 */     arrayOfFloat2[i + 288] = f30;
/*  454 */     arrayOfFloat2[i + 304] = f29;
/*  455 */     arrayOfFloat2[i + 320] = f28;
/*  456 */     arrayOfFloat2[i + 336] = f27;
/*  457 */     arrayOfFloat2[i + 352] = f26;
/*  458 */     arrayOfFloat2[i + 368] = f25;
/*  459 */     arrayOfFloat2[i + 384] = f24;
/*  460 */     arrayOfFloat2[i + 400] = f23;
/*  461 */     arrayOfFloat2[i + 416] = f22;
/*  462 */     arrayOfFloat2[i + 432] = f21;
/*  463 */     arrayOfFloat2[i + 448] = f20;
/*  464 */     arrayOfFloat2[i + 464] = f19;
/*  465 */     arrayOfFloat2[i + 480] = f18;
/*  466 */     arrayOfFloat2[i + 496] = f17;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  487 */   private float[] h = new float[32];
/*      */   
/*      */   private void c() {
/*  490 */     float[] arrayOfFloat1 = this.c;
/*      */     
/*  492 */     float[] arrayOfFloat2 = this.h;
/*  493 */     byte b1 = 0;
/*      */ 
/*      */     
/*  496 */     for (byte b2 = 0; b2 < 32; b2++) {
/*      */       
/*  498 */       float[] arrayOfFloat = O[b2];
/*  499 */       float f = (arrayOfFloat1[b1 + 0] * arrayOfFloat[0] + arrayOfFloat1[b1 + 15] * arrayOfFloat[1] + arrayOfFloat1[b1 + 14] * arrayOfFloat[2] + arrayOfFloat1[b1 + 13] * arrayOfFloat[3] + arrayOfFloat1[b1 + 12] * arrayOfFloat[4] + arrayOfFloat1[b1 + 11] * arrayOfFloat[5] + arrayOfFloat1[b1 + 10] * arrayOfFloat[6] + arrayOfFloat1[b1 + 9] * arrayOfFloat[7] + arrayOfFloat1[b1 + 8] * arrayOfFloat[8] + arrayOfFloat1[b1 + 7] * arrayOfFloat[9] + arrayOfFloat1[b1 + 6] * arrayOfFloat[10] + arrayOfFloat1[b1 + 5] * arrayOfFloat[11] + arrayOfFloat1[b1 + 4] * arrayOfFloat[12] + arrayOfFloat1[b1 + 3] * arrayOfFloat[13] + arrayOfFloat1[b1 + 2] * arrayOfFloat[14] + arrayOfFloat1[b1 + 1] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  504 */       arrayOfFloat2[b2] = f;
/*      */       
/*  506 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d() {
/*  511 */     float[] arrayOfFloat1 = this.c;
/*      */     
/*  513 */     float[] arrayOfFloat2 = this.h;
/*  514 */     byte b1 = 0;
/*      */ 
/*      */     
/*  517 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  518 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  521 */       float f = (arrayOfFloat1[b1 + 1] * arrayOfFloat[0] + arrayOfFloat1[b1 + 0] * arrayOfFloat[1] + arrayOfFloat1[b1 + 15] * arrayOfFloat[2] + arrayOfFloat1[b1 + 14] * arrayOfFloat[3] + arrayOfFloat1[b1 + 13] * arrayOfFloat[4] + arrayOfFloat1[b1 + 12] * arrayOfFloat[5] + arrayOfFloat1[b1 + 11] * arrayOfFloat[6] + arrayOfFloat1[b1 + 10] * arrayOfFloat[7] + arrayOfFloat1[b1 + 9] * arrayOfFloat[8] + arrayOfFloat1[b1 + 8] * arrayOfFloat[9] + arrayOfFloat1[b1 + 7] * arrayOfFloat[10] + arrayOfFloat1[b1 + 6] * arrayOfFloat[11] + arrayOfFloat1[b1 + 5] * arrayOfFloat[12] + arrayOfFloat1[b1 + 4] * arrayOfFloat[13] + arrayOfFloat1[b1 + 3] * arrayOfFloat[14] + arrayOfFloat1[b1 + 2] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  526 */       arrayOfFloat2[b2] = f;
/*      */       
/*  528 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void e() {
/*  533 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  536 */     float[] arrayOfFloat2 = this.h;
/*  537 */     byte b1 = 0;
/*      */ 
/*      */     
/*  540 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  541 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  544 */       float f = (arrayOfFloat1[b1 + 2] * arrayOfFloat[0] + arrayOfFloat1[b1 + 1] * arrayOfFloat[1] + arrayOfFloat1[b1 + 0] * arrayOfFloat[2] + arrayOfFloat1[b1 + 15] * arrayOfFloat[3] + arrayOfFloat1[b1 + 14] * arrayOfFloat[4] + arrayOfFloat1[b1 + 13] * arrayOfFloat[5] + arrayOfFloat1[b1 + 12] * arrayOfFloat[6] + arrayOfFloat1[b1 + 11] * arrayOfFloat[7] + arrayOfFloat1[b1 + 10] * arrayOfFloat[8] + arrayOfFloat1[b1 + 9] * arrayOfFloat[9] + arrayOfFloat1[b1 + 8] * arrayOfFloat[10] + arrayOfFloat1[b1 + 7] * arrayOfFloat[11] + arrayOfFloat1[b1 + 6] * arrayOfFloat[12] + arrayOfFloat1[b1 + 5] * arrayOfFloat[13] + arrayOfFloat1[b1 + 4] * arrayOfFloat[14] + arrayOfFloat1[b1 + 3] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  549 */       arrayOfFloat2[b2] = f;
/*      */       
/*  551 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void f() {
/*  556 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  559 */     float[] arrayOfFloat2 = this.h;
/*  560 */     byte b1 = 0;
/*      */ 
/*      */     
/*  563 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  564 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  567 */       float f = (arrayOfFloat1[b1 + 3] * arrayOfFloat[0] + arrayOfFloat1[b1 + 2] * arrayOfFloat[1] + arrayOfFloat1[b1 + 1] * arrayOfFloat[2] + arrayOfFloat1[b1 + 0] * arrayOfFloat[3] + arrayOfFloat1[b1 + 15] * arrayOfFloat[4] + arrayOfFloat1[b1 + 14] * arrayOfFloat[5] + arrayOfFloat1[b1 + 13] * arrayOfFloat[6] + arrayOfFloat1[b1 + 12] * arrayOfFloat[7] + arrayOfFloat1[b1 + 11] * arrayOfFloat[8] + arrayOfFloat1[b1 + 10] * arrayOfFloat[9] + arrayOfFloat1[b1 + 9] * arrayOfFloat[10] + arrayOfFloat1[b1 + 8] * arrayOfFloat[11] + arrayOfFloat1[b1 + 7] * arrayOfFloat[12] + arrayOfFloat1[b1 + 6] * arrayOfFloat[13] + arrayOfFloat1[b1 + 5] * arrayOfFloat[14] + arrayOfFloat1[b1 + 4] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  572 */       arrayOfFloat2[b2] = f;
/*      */       
/*  574 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void g() {
/*  579 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  582 */     float[] arrayOfFloat2 = this.h;
/*  583 */     byte b1 = 0;
/*      */ 
/*      */     
/*  586 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  587 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  590 */       float f = (arrayOfFloat1[b1 + 4] * arrayOfFloat[0] + arrayOfFloat1[b1 + 3] * arrayOfFloat[1] + arrayOfFloat1[b1 + 2] * arrayOfFloat[2] + arrayOfFloat1[b1 + 1] * arrayOfFloat[3] + arrayOfFloat1[b1 + 0] * arrayOfFloat[4] + arrayOfFloat1[b1 + 15] * arrayOfFloat[5] + arrayOfFloat1[b1 + 14] * arrayOfFloat[6] + arrayOfFloat1[b1 + 13] * arrayOfFloat[7] + arrayOfFloat1[b1 + 12] * arrayOfFloat[8] + arrayOfFloat1[b1 + 11] * arrayOfFloat[9] + arrayOfFloat1[b1 + 10] * arrayOfFloat[10] + arrayOfFloat1[b1 + 9] * arrayOfFloat[11] + arrayOfFloat1[b1 + 8] * arrayOfFloat[12] + arrayOfFloat1[b1 + 7] * arrayOfFloat[13] + arrayOfFloat1[b1 + 6] * arrayOfFloat[14] + arrayOfFloat1[b1 + 5] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  595 */       arrayOfFloat2[b2] = f;
/*      */       
/*  597 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void h() {
/*  602 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  605 */     float[] arrayOfFloat2 = this.h;
/*  606 */     byte b1 = 0;
/*      */ 
/*      */     
/*  609 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  610 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  613 */       float f = (arrayOfFloat1[b1 + 5] * arrayOfFloat[0] + arrayOfFloat1[b1 + 4] * arrayOfFloat[1] + arrayOfFloat1[b1 + 3] * arrayOfFloat[2] + arrayOfFloat1[b1 + 2] * arrayOfFloat[3] + arrayOfFloat1[b1 + 1] * arrayOfFloat[4] + arrayOfFloat1[b1 + 0] * arrayOfFloat[5] + arrayOfFloat1[b1 + 15] * arrayOfFloat[6] + arrayOfFloat1[b1 + 14] * arrayOfFloat[7] + arrayOfFloat1[b1 + 13] * arrayOfFloat[8] + arrayOfFloat1[b1 + 12] * arrayOfFloat[9] + arrayOfFloat1[b1 + 11] * arrayOfFloat[10] + arrayOfFloat1[b1 + 10] * arrayOfFloat[11] + arrayOfFloat1[b1 + 9] * arrayOfFloat[12] + arrayOfFloat1[b1 + 8] * arrayOfFloat[13] + arrayOfFloat1[b1 + 7] * arrayOfFloat[14] + arrayOfFloat1[b1 + 6] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  618 */       arrayOfFloat2[b2] = f;
/*      */       
/*  620 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void i() {
/*  625 */     float[] arrayOfFloat1 = this.c;
/*      */     
/*  627 */     float[] arrayOfFloat2 = this.h;
/*  628 */     byte b1 = 0;
/*      */ 
/*      */     
/*  631 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  632 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  635 */       float f = (arrayOfFloat1[b1 + 6] * arrayOfFloat[0] + arrayOfFloat1[b1 + 5] * arrayOfFloat[1] + arrayOfFloat1[b1 + 4] * arrayOfFloat[2] + arrayOfFloat1[b1 + 3] * arrayOfFloat[3] + arrayOfFloat1[b1 + 2] * arrayOfFloat[4] + arrayOfFloat1[b1 + 1] * arrayOfFloat[5] + arrayOfFloat1[b1 + 0] * arrayOfFloat[6] + arrayOfFloat1[b1 + 15] * arrayOfFloat[7] + arrayOfFloat1[b1 + 14] * arrayOfFloat[8] + arrayOfFloat1[b1 + 13] * arrayOfFloat[9] + arrayOfFloat1[b1 + 12] * arrayOfFloat[10] + arrayOfFloat1[b1 + 11] * arrayOfFloat[11] + arrayOfFloat1[b1 + 10] * arrayOfFloat[12] + arrayOfFloat1[b1 + 9] * arrayOfFloat[13] + arrayOfFloat1[b1 + 8] * arrayOfFloat[14] + arrayOfFloat1[b1 + 7] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  640 */       arrayOfFloat2[b2] = f;
/*      */       
/*  642 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void j() {
/*  647 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  650 */     float[] arrayOfFloat2 = this.h;
/*  651 */     byte b1 = 0;
/*      */ 
/*      */     
/*  654 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  655 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  658 */       float f = (arrayOfFloat1[b1 + 7] * arrayOfFloat[0] + arrayOfFloat1[b1 + 6] * arrayOfFloat[1] + arrayOfFloat1[b1 + 5] * arrayOfFloat[2] + arrayOfFloat1[b1 + 4] * arrayOfFloat[3] + arrayOfFloat1[b1 + 3] * arrayOfFloat[4] + arrayOfFloat1[b1 + 2] * arrayOfFloat[5] + arrayOfFloat1[b1 + 1] * arrayOfFloat[6] + arrayOfFloat1[b1 + 0] * arrayOfFloat[7] + arrayOfFloat1[b1 + 15] * arrayOfFloat[8] + arrayOfFloat1[b1 + 14] * arrayOfFloat[9] + arrayOfFloat1[b1 + 13] * arrayOfFloat[10] + arrayOfFloat1[b1 + 12] * arrayOfFloat[11] + arrayOfFloat1[b1 + 11] * arrayOfFloat[12] + arrayOfFloat1[b1 + 10] * arrayOfFloat[13] + arrayOfFloat1[b1 + 9] * arrayOfFloat[14] + arrayOfFloat1[b1 + 8] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  663 */       arrayOfFloat2[b2] = f;
/*      */       
/*  665 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void k() {
/*  670 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  673 */     float[] arrayOfFloat2 = this.h;
/*  674 */     byte b1 = 0;
/*      */ 
/*      */     
/*  677 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  678 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  681 */       float f = (arrayOfFloat1[b1 + 8] * arrayOfFloat[0] + arrayOfFloat1[b1 + 7] * arrayOfFloat[1] + arrayOfFloat1[b1 + 6] * arrayOfFloat[2] + arrayOfFloat1[b1 + 5] * arrayOfFloat[3] + arrayOfFloat1[b1 + 4] * arrayOfFloat[4] + arrayOfFloat1[b1 + 3] * arrayOfFloat[5] + arrayOfFloat1[b1 + 2] * arrayOfFloat[6] + arrayOfFloat1[b1 + 1] * arrayOfFloat[7] + arrayOfFloat1[b1 + 0] * arrayOfFloat[8] + arrayOfFloat1[b1 + 15] * arrayOfFloat[9] + arrayOfFloat1[b1 + 14] * arrayOfFloat[10] + arrayOfFloat1[b1 + 13] * arrayOfFloat[11] + arrayOfFloat1[b1 + 12] * arrayOfFloat[12] + arrayOfFloat1[b1 + 11] * arrayOfFloat[13] + arrayOfFloat1[b1 + 10] * arrayOfFloat[14] + arrayOfFloat1[b1 + 9] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  686 */       arrayOfFloat2[b2] = f;
/*      */       
/*  688 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void l() {
/*  693 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  696 */     float[] arrayOfFloat2 = this.h;
/*  697 */     byte b1 = 0;
/*      */ 
/*      */     
/*  700 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  701 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  704 */       float f = (arrayOfFloat1[b1 + 9] * arrayOfFloat[0] + arrayOfFloat1[b1 + 8] * arrayOfFloat[1] + arrayOfFloat1[b1 + 7] * arrayOfFloat[2] + arrayOfFloat1[b1 + 6] * arrayOfFloat[3] + arrayOfFloat1[b1 + 5] * arrayOfFloat[4] + arrayOfFloat1[b1 + 4] * arrayOfFloat[5] + arrayOfFloat1[b1 + 3] * arrayOfFloat[6] + arrayOfFloat1[b1 + 2] * arrayOfFloat[7] + arrayOfFloat1[b1 + 1] * arrayOfFloat[8] + arrayOfFloat1[b1 + 0] * arrayOfFloat[9] + arrayOfFloat1[b1 + 15] * arrayOfFloat[10] + arrayOfFloat1[b1 + 14] * arrayOfFloat[11] + arrayOfFloat1[b1 + 13] * arrayOfFloat[12] + arrayOfFloat1[b1 + 12] * arrayOfFloat[13] + arrayOfFloat1[b1 + 11] * arrayOfFloat[14] + arrayOfFloat1[b1 + 10] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  709 */       arrayOfFloat2[b2] = f;
/*      */       
/*  711 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void m() {
/*  716 */     float[] arrayOfFloat1 = this.c;
/*      */     
/*  718 */     float[] arrayOfFloat2 = this.h;
/*  719 */     byte b1 = 0;
/*      */ 
/*      */     
/*  722 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  723 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  726 */       float f = (arrayOfFloat1[b1 + 10] * arrayOfFloat[0] + arrayOfFloat1[b1 + 9] * arrayOfFloat[1] + arrayOfFloat1[b1 + 8] * arrayOfFloat[2] + arrayOfFloat1[b1 + 7] * arrayOfFloat[3] + arrayOfFloat1[b1 + 6] * arrayOfFloat[4] + arrayOfFloat1[b1 + 5] * arrayOfFloat[5] + arrayOfFloat1[b1 + 4] * arrayOfFloat[6] + arrayOfFloat1[b1 + 3] * arrayOfFloat[7] + arrayOfFloat1[b1 + 2] * arrayOfFloat[8] + arrayOfFloat1[b1 + 1] * arrayOfFloat[9] + arrayOfFloat1[b1 + 0] * arrayOfFloat[10] + arrayOfFloat1[b1 + 15] * arrayOfFloat[11] + arrayOfFloat1[b1 + 14] * arrayOfFloat[12] + arrayOfFloat1[b1 + 13] * arrayOfFloat[13] + arrayOfFloat1[b1 + 12] * arrayOfFloat[14] + arrayOfFloat1[b1 + 11] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  731 */       arrayOfFloat2[b2] = f;
/*      */       
/*  733 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void n() {
/*  738 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  741 */     float[] arrayOfFloat2 = this.h;
/*  742 */     byte b1 = 0;
/*      */ 
/*      */     
/*  745 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  746 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  749 */       float f = (arrayOfFloat1[b1 + 11] * arrayOfFloat[0] + arrayOfFloat1[b1 + 10] * arrayOfFloat[1] + arrayOfFloat1[b1 + 9] * arrayOfFloat[2] + arrayOfFloat1[b1 + 8] * arrayOfFloat[3] + arrayOfFloat1[b1 + 7] * arrayOfFloat[4] + arrayOfFloat1[b1 + 6] * arrayOfFloat[5] + arrayOfFloat1[b1 + 5] * arrayOfFloat[6] + arrayOfFloat1[b1 + 4] * arrayOfFloat[7] + arrayOfFloat1[b1 + 3] * arrayOfFloat[8] + arrayOfFloat1[b1 + 2] * arrayOfFloat[9] + arrayOfFloat1[b1 + 1] * arrayOfFloat[10] + arrayOfFloat1[b1 + 0] * arrayOfFloat[11] + arrayOfFloat1[b1 + 15] * arrayOfFloat[12] + arrayOfFloat1[b1 + 14] * arrayOfFloat[13] + arrayOfFloat1[b1 + 13] * arrayOfFloat[14] + arrayOfFloat1[b1 + 12] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  754 */       arrayOfFloat2[b2] = f;
/*      */       
/*  756 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void o() {
/*  761 */     float[] arrayOfFloat1 = this.c;
/*      */     
/*  763 */     float[] arrayOfFloat2 = this.h;
/*  764 */     byte b1 = 0;
/*      */ 
/*      */     
/*  767 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  768 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  771 */       float f = (arrayOfFloat1[b1 + 12] * arrayOfFloat[0] + arrayOfFloat1[b1 + 11] * arrayOfFloat[1] + arrayOfFloat1[b1 + 10] * arrayOfFloat[2] + arrayOfFloat1[b1 + 9] * arrayOfFloat[3] + arrayOfFloat1[b1 + 8] * arrayOfFloat[4] + arrayOfFloat1[b1 + 7] * arrayOfFloat[5] + arrayOfFloat1[b1 + 6] * arrayOfFloat[6] + arrayOfFloat1[b1 + 5] * arrayOfFloat[7] + arrayOfFloat1[b1 + 4] * arrayOfFloat[8] + arrayOfFloat1[b1 + 3] * arrayOfFloat[9] + arrayOfFloat1[b1 + 2] * arrayOfFloat[10] + arrayOfFloat1[b1 + 1] * arrayOfFloat[11] + arrayOfFloat1[b1 + 0] * arrayOfFloat[12] + arrayOfFloat1[b1 + 15] * arrayOfFloat[13] + arrayOfFloat1[b1 + 14] * arrayOfFloat[14] + arrayOfFloat1[b1 + 13] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  776 */       arrayOfFloat2[b2] = f;
/*      */       
/*  778 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void p() {
/*  783 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  786 */     float[] arrayOfFloat2 = this.h;
/*  787 */     byte b1 = 0;
/*      */ 
/*      */     
/*  790 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  791 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  794 */       float f = (arrayOfFloat1[b1 + 13] * arrayOfFloat[0] + arrayOfFloat1[b1 + 12] * arrayOfFloat[1] + arrayOfFloat1[b1 + 11] * arrayOfFloat[2] + arrayOfFloat1[b1 + 10] * arrayOfFloat[3] + arrayOfFloat1[b1 + 9] * arrayOfFloat[4] + arrayOfFloat1[b1 + 8] * arrayOfFloat[5] + arrayOfFloat1[b1 + 7] * arrayOfFloat[6] + arrayOfFloat1[b1 + 6] * arrayOfFloat[7] + arrayOfFloat1[b1 + 5] * arrayOfFloat[8] + arrayOfFloat1[b1 + 4] * arrayOfFloat[9] + arrayOfFloat1[b1 + 3] * arrayOfFloat[10] + arrayOfFloat1[b1 + 2] * arrayOfFloat[11] + arrayOfFloat1[b1 + 1] * arrayOfFloat[12] + arrayOfFloat1[b1 + 0] * arrayOfFloat[13] + arrayOfFloat1[b1 + 15] * arrayOfFloat[14] + arrayOfFloat1[b1 + 14] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  799 */       arrayOfFloat2[b2] = f;
/*      */       
/*  801 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void q() {
/*  806 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  809 */     float[] arrayOfFloat2 = this.h;
/*  810 */     byte b1 = 0;
/*      */ 
/*      */     
/*  813 */     for (byte b2 = 0; b2 < 32; b2++) {
/*  814 */       float[] arrayOfFloat = O[b2];
/*      */ 
/*      */       
/*  817 */       float f = (arrayOfFloat1[b1 + 14] * arrayOfFloat[0] + arrayOfFloat1[b1 + 13] * arrayOfFloat[1] + arrayOfFloat1[b1 + 12] * arrayOfFloat[2] + arrayOfFloat1[b1 + 11] * arrayOfFloat[3] + arrayOfFloat1[b1 + 10] * arrayOfFloat[4] + arrayOfFloat1[b1 + 9] * arrayOfFloat[5] + arrayOfFloat1[b1 + 8] * arrayOfFloat[6] + arrayOfFloat1[b1 + 7] * arrayOfFloat[7] + arrayOfFloat1[b1 + 6] * arrayOfFloat[8] + arrayOfFloat1[b1 + 5] * arrayOfFloat[9] + arrayOfFloat1[b1 + 4] * arrayOfFloat[10] + arrayOfFloat1[b1 + 3] * arrayOfFloat[11] + arrayOfFloat1[b1 + 2] * arrayOfFloat[12] + arrayOfFloat1[b1 + 1] * arrayOfFloat[13] + arrayOfFloat1[b1 + 0] * arrayOfFloat[14] + arrayOfFloat1[b1 + 15] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  822 */       arrayOfFloat2[b2] = f;
/*      */       
/*  824 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void r() {
/*  829 */     float[] arrayOfFloat1 = this.c;
/*      */ 
/*      */     
/*  832 */     float[] arrayOfFloat2 = this.h;
/*  833 */     byte b1 = 0;
/*      */ 
/*      */     
/*  836 */     for (byte b2 = 0; b2 < 32; b2++) {
/*      */       
/*  838 */       float[] arrayOfFloat = O[b2];
/*  839 */       float f = (arrayOfFloat1[b1 + 15] * arrayOfFloat[0] + arrayOfFloat1[b1 + 14] * arrayOfFloat[1] + arrayOfFloat1[b1 + 13] * arrayOfFloat[2] + arrayOfFloat1[b1 + 12] * arrayOfFloat[3] + arrayOfFloat1[b1 + 11] * arrayOfFloat[4] + arrayOfFloat1[b1 + 10] * arrayOfFloat[5] + arrayOfFloat1[b1 + 9] * arrayOfFloat[6] + arrayOfFloat1[b1 + 8] * arrayOfFloat[7] + arrayOfFloat1[b1 + 7] * arrayOfFloat[8] + arrayOfFloat1[b1 + 6] * arrayOfFloat[9] + arrayOfFloat1[b1 + 5] * arrayOfFloat[10] + arrayOfFloat1[b1 + 4] * arrayOfFloat[11] + arrayOfFloat1[b1 + 3] * arrayOfFloat[12] + arrayOfFloat1[b1 + 2] * arrayOfFloat[13] + arrayOfFloat1[b1 + 1] * arrayOfFloat[14] + arrayOfFloat1[b1 + 0] * arrayOfFloat[15]) * this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  844 */       arrayOfFloat2[b2] = f;
/*  845 */       b1 += 16;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void b(m paramm) {
/*  851 */     switch (this.d) {
/*      */       case 0:
/*  853 */         c();
/*      */         break;
/*      */       case 1:
/*  856 */         d();
/*      */         break;
/*      */       case 2:
/*  859 */         e();
/*      */         break;
/*      */       case 3:
/*  862 */         f();
/*      */         break;
/*      */       case 4:
/*  865 */         g();
/*      */         break;
/*      */       case 5:
/*  868 */         h();
/*      */         break;
/*      */       case 6:
/*  871 */         i();
/*      */         break;
/*      */       case 7:
/*  874 */         j();
/*      */         break;
/*      */       case 8:
/*  877 */         k();
/*      */         break;
/*      */       case 9:
/*  880 */         l();
/*      */         break;
/*      */       case 10:
/*  883 */         m();
/*      */         break;
/*      */       case 11:
/*  886 */         n();
/*      */         break;
/*      */       case 12:
/*  889 */         o();
/*      */         break;
/*      */       case 13:
/*  892 */         p();
/*      */         break;
/*      */       case 14:
/*  895 */         q();
/*      */         break;
/*      */       case 15:
/*  898 */         r();
/*      */         break;
/*      */     } 
/*      */     
/*  902 */     if (paramm != null) paramm.a(this.f, this.h);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(m paramm) {
/*  920 */     b();
/*  921 */     b(paramm);
/*      */     
/*  923 */     this.d = this.d + 1 & 0xF;
/*  924 */     this.c = (this.c == this.a) ? this.b : this.a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  932 */     for (byte b = 0; b < 32; b++) {
/*  933 */       this.e[b] = 0.0F;
/*      */     }
/*      */   }
/*      */   
/*  937 */   private static final float i = (float)(1.0D / 2.0D * Math.cos(0.04908738521234052D));
/*  938 */   private static final float j = (float)(1.0D / 2.0D * Math.cos(0.14726215563702155D));
/*  939 */   private static final float k = (float)(1.0D / 2.0D * Math.cos(0.2454369260617026D));
/*  940 */   private static final float l = (float)(1.0D / 2.0D * Math.cos(0.3436116964863836D));
/*  941 */   private static final float m = (float)(1.0D / 2.0D * Math.cos(0.44178646691106466D));
/*  942 */   private static final float n = (float)(1.0D / 2.0D * Math.cos(0.5399612373357456D));
/*  943 */   private static final float o = (float)(1.0D / 2.0D * Math.cos(0.6381360077604268D));
/*  944 */   private static final float p = (float)(1.0D / 2.0D * Math.cos(0.7363107781851077D));
/*  945 */   private static final float q = (float)(1.0D / 2.0D * Math.cos(0.8344855486097889D));
/*  946 */   private static final float r = (float)(1.0D / 2.0D * Math.cos(0.9326603190344698D));
/*  947 */   private static final float s = (float)(1.0D / 2.0D * Math.cos(1.030835089459151D));
/*  948 */   private static final float t = (float)(1.0D / 2.0D * Math.cos(1.1290098598838318D));
/*  949 */   private static final float u = (float)(1.0D / 2.0D * Math.cos(1.227184630308513D));
/*  950 */   private static final float v = (float)(1.0D / 2.0D * Math.cos(1.325359400733194D));
/*  951 */   private static final float w = (float)(1.0D / 2.0D * Math.cos(1.423534171157875D));
/*  952 */   private static final float x = (float)(1.0D / 2.0D * Math.cos(1.521708941582556D));
/*  953 */   private static final float y = (float)(1.0D / 2.0D * Math.cos(0.09817477042468103D));
/*  954 */   private static final float z = (float)(1.0D / 2.0D * Math.cos(0.2945243112740431D));
/*  955 */   private static final float A = (float)(1.0D / 2.0D * Math.cos(0.4908738521234052D));
/*  956 */   private static final float B = (float)(1.0D / 2.0D * Math.cos(0.6872233929727672D));
/*  957 */   private static final float C = (float)(1.0D / 2.0D * Math.cos(0.8835729338221293D));
/*  958 */   private static final float D = (float)(1.0D / 2.0D * Math.cos(1.0799224746714913D));
/*  959 */   private static final float E = (float)(1.0D / 2.0D * Math.cos(1.2762720155208536D));
/*  960 */   private static final float F = (float)(1.0D / 2.0D * Math.cos(1.4726215563702154D));
/*  961 */   private static final float G = (float)(1.0D / 2.0D * Math.cos(0.19634954084936207D));
/*  962 */   private static final float H = (float)(1.0D / 2.0D * Math.cos(0.5890486225480862D));
/*  963 */   private static final float I = (float)(1.0D / 2.0D * Math.cos(0.9817477042468103D));
/*  964 */   private static final float J = (float)(1.0D / 2.0D * Math.cos(1.3744467859455345D));
/*  965 */   private static final float K = (float)(1.0D / 2.0D * Math.cos(0.39269908169872414D));
/*  966 */   private static final float L = (float)(1.0D / 2.0D * Math.cos(1.1780972450961724D));
/*  967 */   private static final float M = (float)(1.0D / 2.0D * Math.cos(0.7853981633974483D));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  973 */   private static float[] N = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  979 */   private static float[][] O = (float[][])null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float[] s() {
/*      */     try {
/*  987 */       Class<float> clazz = float.class;
/*      */       Object object;
/*  989 */       return (float[])(object = a(n.class.getResourceAsStream("/sfd.ser"), clazz, 512));
/*  990 */     } catch (IOException iOException) {
/*  991 */       throw new ExceptionInInitializerError(iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Object a(InputStream paramInputStream, Class<?> paramClass, int paramInt) {
/* 1004 */     if (paramClass == null) throw new NullPointerException("elemType");
/*      */ 
/*      */ 
/*      */     
/*      */     Object object;
/*      */     
/*      */     Class<?> clazz;
/*      */     
/* 1012 */     if (!(clazz = (object = a(paramInputStream)).getClass()).isArray()) throw new InvalidObjectException("object is not an array");
/*      */ 
/*      */     
/* 1015 */     if ((clazz = clazz.getComponentType()) != paramClass) throw new InvalidObjectException("unexpected array component type");
/*      */ 
/*      */     
/*      */     int i;
/* 1019 */     if ((i = Array.getLength(object)) != 512) throw new InvalidObjectException("array length mismatch");
/*      */ 
/*      */     
/* 1022 */     return object;
/*      */   }
/*      */   
/*      */   private static Object a(InputStream paramInputStream) {
/* 1026 */     if (paramInputStream == null) throw new NullPointerException("in");
/*      */     
/* 1028 */     paramInputStream = new ObjectInputStream(paramInputStream);
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1033 */       object = paramInputStream.readObject();
/* 1034 */     } catch (ClassNotFoundException object) {
/* 1035 */       throw new InvalidClassException(object.toString());
/*      */     } 
/* 1037 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float[][] a(float[] paramArrayOffloat, int paramInt) {
/* 1051 */     float[][] arrayOfFloat = new float[paramInt = paramArrayOffloat.length / 16][];
/* 1052 */     for (byte b = 0; b < paramInt; b++)
/* 1053 */       arrayOfFloat[b] = a(paramArrayOffloat, b << 4, 16); 
/* 1054 */     return arrayOfFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float[] a(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 1066 */     if (paramInt1 + paramInt2 > paramArrayOffloat.length) paramInt2 = paramArrayOffloat.length - paramInt1;
/*      */     
/* 1068 */     if (paramInt2 < 0) paramInt2 = 0;
/*      */     
/* 1070 */     float[] arrayOfFloat = new float[paramInt2];
/* 1071 */     for (byte b = 0; b < paramInt2; b++)
/* 1072 */       arrayOfFloat[b] = paramArrayOffloat[paramInt1 + b]; 
/* 1073 */     return arrayOfFloat;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */