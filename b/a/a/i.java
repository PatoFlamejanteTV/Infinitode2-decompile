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
/*     */ public class i
/*     */   implements f
/*     */ {
/*     */   protected b a;
/*     */   protected g b;
/*     */   private n h;
/*     */   private n i;
/*     */   private m j;
/*     */   private int k;
/*     */   protected int c;
/*     */   protected int d;
/*     */   protected a[] e;
/*  35 */   protected d f = null;
/*     */   
/*     */   public i() {
/*  38 */     this.f = new d();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(b paramb, g paramg, n paramn1, n paramn2, m paramm, int paramInt) {
/*  43 */     this.a = paramb;
/*  44 */     this.b = paramg;
/*  45 */     this.h = paramn1;
/*  46 */     this.i = paramn2;
/*  47 */     this.j = paramm;
/*  48 */     this.k = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/*  54 */     this.d = this.b.k();
/*  55 */     this.e = new a[32];
/*  56 */     this.c = this.b.f();
/*     */     
/*  58 */     b();
/*     */     
/*  60 */     d();
/*  61 */     c();
/*     */     
/*  63 */     if (this.f != null || this.b.g()) {
/*  64 */       e();
/*     */       
/*  66 */       f();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void b() {
/*  73 */     if (this.c == 3) {
/*  74 */       for (byte b1 = 0; b1 < this.d; b1++)
/*  75 */         this.e[b1] = new b(b1); 
/*  76 */     } else if (this.c == 1) {
/*  77 */       byte b1; for (b1 = 0; b1 < this.b.l(); b1++)
/*  78 */         this.e[b1] = new d(b1); 
/*  79 */       for (; b1 < this.d; b1++)
/*  80 */         this.e[b1] = new c(b1); 
/*     */     } else {
/*  82 */       for (byte b1 = 0; b1 < this.d; b1++)
/*  83 */         this.e[b1] = new d(b1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d() {
/*  88 */     for (byte b1 = 0; b1 < this.d; b1++) {
/*  89 */       this.e[b1].a(this.a, this.b, this.f);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void c() {}
/*     */ 
/*     */   
/*     */   private void e() {
/*  98 */     for (byte b1 = 0; b1 < this.d; b1++)
/*  99 */       this.e[b1].a(this.a, this.b); 
/*     */   }
/*     */   
/*     */   private void f() {
/* 103 */     boolean bool1 = false;
/* 104 */     boolean bool2 = false;
/* 105 */     int j = this.b.f();
/*     */     while (true) {
/*     */       byte b1;
/* 108 */       for (b1 = 0; b1 < this.d; b1++)
/* 109 */         bool1 = this.e[b1].a(this.a); 
/*     */       do {
/* 111 */         for (b1 = 0; b1 < this.d; b1++) {
/* 112 */           bool2 = this.e[b1].a(this.k, this.h, this.i);
/*     */         }
/* 114 */         this.h.a(this.j);
/* 115 */         if (this.k != 0 || j == 3)
/* 116 */           continue;  this.i.a(this.j);
/* 117 */       } while (!bool2 || 
/* 118 */         !bool1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   static final float[] g = new float[] { 2.0F, 1.587401F, 1.2599211F, 1.0F, 0.7937005F, 0.62996054F, 0.5F, 0.39685026F, 0.31498027F, 0.25F, 0.19842513F, 0.15749013F, 0.125F, 0.099212565F, 0.07874507F, 0.0625F, 0.049606282F, 0.039372534F, 0.03125F, 0.024803141F, 0.019686267F, 0.015625F, 0.012401571F, 0.009843133F, 0.0078125F, 0.0062007853F, 0.0049215667F, 0.00390625F, 0.0031003926F, 0.0024607833F, 0.001953125F, 0.0015501963F, 0.0012303917F, 9.765625E-4F, 7.7509816E-4F, 6.1519584E-4F, 4.8828125E-4F, 3.8754908E-4F, 3.0759792E-4F, 2.4414062E-4F, 1.9377454E-4F, 1.5379896E-4F, 1.2207031E-4F, 9.688727E-5F, 7.689948E-5F, 6.1035156E-5F, 4.8443635E-5F, 3.844974E-5F, 3.0517578E-5F, 2.4221818E-5F, 1.922487E-5F, 1.5258789E-5F, 1.2110909E-5F, 9.612435E-6F, 7.6293945E-6F, 6.0554544E-6F, 4.8062175E-6F, 3.8146973E-6F, 3.0277272E-6F, 2.4031087E-6F, 1.9073486E-6F, 1.5138636E-6F, 1.2015544E-6F, 0.0F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class a
/*     */   {
/*     */     public abstract void a(b param1b, g param1g, d param1d);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract void a(b param1b, g param1g);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract boolean a(b param1b);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract boolean a(int param1Int, n param1n1, n param1n2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class b
/*     */     extends a
/*     */   {
/* 164 */     public static final float[] a = new float[] { 0.0F, 0.6666667F, 0.2857143F, 0.13333334F, 0.06451613F, 0.031746034F, 0.015748031F, 0.007843138F, 0.0039138943F, 0.0019550342F, 9.770396E-4F, 4.884005E-4F, 2.4417043E-4F, 1.2207776E-4F, 6.103702E-5F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     public static final float[] b = new float[] { 0.0F, -0.6666667F, -0.85714287F, -0.93333334F, -0.9677419F, -0.984127F, -0.992126F, -0.99607843F, -0.99804306F, -0.9990225F, -0.9995115F, -0.9997558F, -0.9998779F, -0.99993896F, -0.9999695F };
/*     */     
/*     */     protected int c;
/*     */     
/*     */     private int j;
/*     */     
/*     */     protected int d;
/*     */     
/*     */     protected float e;
/*     */     
/*     */     protected int f;
/*     */     
/*     */     protected float g;
/*     */     
/*     */     protected float h;
/*     */     
/*     */     protected float i;
/*     */ 
/*     */     
/*     */     public b(int param1Int) {
/* 190 */       this.c = param1Int;
/* 191 */       this.j = 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(b param1b, g param1g, d param1d) {
/* 198 */       if ((this.d = param1b.d(4)) == 15) {
/* 199 */         throw new e(514, null);
/*     */       }
/*     */ 
/*     */       
/* 203 */       if (param1d != null) param1d.a(this.d, 4); 
/* 204 */       if (this.d != 0) {
/* 205 */         this.f = this.d + 1;
/* 206 */         this.h = a[this.d];
/* 207 */         this.i = b[this.d];
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(b param1b, g param1g) {
/* 215 */       if (this.d != 0) this.e = i.g[param1b.d(6)];
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean a(b param1b) {
/* 222 */       if (this.d != 0) this.g = param1b.d(this.f); 
/* 223 */       if (++this.j == 12) {
/* 224 */         this.j = 0;
/* 225 */         return true;
/*     */       } 
/* 227 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean a(int param1Int, n param1n1, n param1n2) {
/* 234 */       if (this.d != 0 && param1Int != 2) {
/* 235 */         float f = (this.g * this.h + this.i) * this.e;
/* 236 */         param1n1.a(f, this.c);
/*     */       } 
/* 238 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class c
/*     */     extends b
/*     */   {
/*     */     private float j;
/*     */ 
/*     */ 
/*     */     
/*     */     public c(int param1Int) {
/* 252 */       super(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(b param1b, g param1g, d param1d) {
/* 259 */       super.a(param1b, param1g, param1d);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(b param1b, g param1g) {
/* 266 */       if (this.d != 0) {
/* 267 */         this.e = i.g[param1b.d(6)];
/* 268 */         this.j = i.g[param1b.d(6)];
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean a(b param1b) {
/* 276 */       return super.a(param1b);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean a(int param1Int, n param1n1, n param1n2) {
/* 283 */       if (this.d != 0) {
/* 284 */         float f; this.g = this.g * this.h + this.i;
/* 285 */         if (param1Int == 0) {
/* 286 */           f = this.g * this.e; float f1 = this.g * this.j;
/* 287 */           param1n1.a(f, this.c);
/* 288 */           param1n2.a(f1, this.c);
/* 289 */         } else if (f == 1) {
/* 290 */           f = this.g * this.e;
/* 291 */           param1n1.a(f, this.c);
/*     */         } else {
/* 293 */           f = this.g * this.j;
/* 294 */           param1n1.a(f, this.c);
/*     */         } 
/*     */       } 
/* 297 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class d
/*     */     extends b
/*     */   {
/*     */     private int j;
/*     */     
/*     */     private float k;
/*     */     
/*     */     private int l;
/*     */     private float m;
/*     */     private float n;
/*     */     private float o;
/*     */     
/*     */     public d(int param1Int) {
/* 315 */       super(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(b param1b, g param1g, d param1d) {
/* 322 */       this.d = param1b.d(4);
/* 323 */       this.j = param1b.d(4);
/* 324 */       if (param1d != null) {
/* 325 */         param1d.a(this.d, 4);
/* 326 */         param1d.a(this.j, 4);
/*     */       } 
/* 328 */       if (this.d != 0) {
/* 329 */         this.f = this.d + 1;
/* 330 */         this.h = a[this.d];
/* 331 */         this.i = b[this.d];
/*     */       } 
/* 333 */       if (this.j != 0) {
/* 334 */         this.l = this.j + 1;
/* 335 */         this.n = a[this.j];
/* 336 */         this.o = b[this.j];
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(b param1b, g param1g) {
/* 344 */       if (this.d != 0) this.e = i.g[param1b.d(6)]; 
/* 345 */       if (this.j != 0) this.k = i.g[param1b.d(6)];
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean a(b param1b) {
/* 352 */       boolean bool = super.a(param1b);
/* 353 */       if (this.j != 0) this.m = param1b.d(this.l); 
/* 354 */       return bool;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean a(int param1Int, n param1n1, n param1n2) {
/* 361 */       super.a(param1Int, param1n1, param1n2);
/* 362 */       if (this.j != 0 && param1Int != 1) {
/* 363 */         float f = (this.m * this.n + this.o) * this.k;
/* 364 */         if (param1Int == 0) {
/* 365 */           param1n2.a(f, this.c);
/*     */         } else {
/* 367 */           param1n1.a(f, this.c);
/*     */         } 
/* 369 */       }  return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */