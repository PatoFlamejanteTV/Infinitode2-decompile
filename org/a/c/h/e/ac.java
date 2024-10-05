/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.c.a;
/*     */ import org.a.b.f.al;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.i.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ac
/*     */   extends u
/*     */ {
/*  46 */   private static final a c = c.a(ac.class);
/*     */   private final o d;
/*     */   private a e;
/*     */   private a f;
/*     */   private boolean g;
/*     */   private boolean h;
/*     */   private r i;
/*  53 */   private final Set<Integer> j = new HashSet<Integer>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ap k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ac a(b paramb, File paramFile) {
/*  66 */     return new ac(paramb, (new al()).b(paramFile), true, true, false);
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
/*     */   public static ac a(b paramb, InputStream paramInputStream, boolean paramBoolean) {
/*  94 */     return new ac(paramb, (new al()).b(paramInputStream), paramBoolean, true, false);
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
/*     */   public static ac a(b paramb, ap paramap, boolean paramBoolean) {
/* 109 */     return new ac(paramb, paramap, paramBoolean, false, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ac(d paramd) {
/* 176 */     super(paramd);
/*     */     b b2;
/* 178 */     if (!(b2 = this.b.a(j.aw) instanceof a))
/*     */     {
/* 180 */       throw new IOException("Missing descendant font array");
/*     */     }
/*     */     a a1;
/* 183 */     if ((a1 = (a)b2).b() == 0)
/*     */     {
/* 185 */       throw new IOException("Descendant font array is empty");
/*     */     }
/*     */     b b1;
/* 188 */     if (!(b1 = a1.a(0) instanceof d))
/*     */     {
/* 190 */       throw new IOException("Missing descendant font dictionary");
/*     */     }
/* 192 */     this.d = w.a((d)b1, this);
/* 193 */     n();
/* 194 */     o();
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
/*     */   private ac(b paramb, ap paramap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 216 */     this.i = new r(paramb, this.b, paramap, paramBoolean1, this, false);
/* 217 */     this.d = this.i.a();
/* 218 */     n();
/* 219 */     o();
/* 220 */     if (paramBoolean2) {
/*     */       
/* 222 */       if (paramBoolean1) {
/*     */         
/* 224 */         this.k = paramap;
/* 225 */         paramb.a(paramap);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 230 */       paramap.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void f(int paramInt) {
/* 238 */     if (!k())
/*     */     {
/* 240 */       throw new IllegalStateException("This font was created with subsetting disabled");
/*     */     }
/* 242 */     this.i.a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void j() {
/* 248 */     if (!k())
/*     */     {
/* 250 */       throw new IllegalStateException("This font was created with subsetting disabled");
/*     */     }
/* 252 */     this.i.b();
/* 253 */     if (this.k != null) {
/*     */       
/* 255 */       this.k.close();
/* 256 */       this.k = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean k() {
/* 263 */     return (this.i != null && this.i.c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void n() {
/*     */     j j;
/*     */     b b;
/* 272 */     if (b = this.b.a(j.aR) instanceof j) {
/*     */ 
/*     */       
/* 275 */       j = (j)b;
/* 276 */       this.e = c.a(j.a());
/* 277 */       if (this.e != null)
/*     */       {
/* 279 */         this.g = true;
/*     */       }
/*     */       else
/*     */       {
/* 283 */         throw new IOException("Missing required CMap");
/*     */       }
/*     */     
/* 286 */     } else if (j != null) {
/*     */       
/* 288 */       this.e = a((b)j);
/* 289 */       if (this.e == null)
/*     */       {
/* 291 */         throw new IOException("Missing required CMap");
/*     */       }
/* 293 */       if (!this.e.a())
/*     */       {
/* 295 */         (new StringBuilder("Invalid Encoding CMap in font ")).append(d());
/*     */       }
/*     */     } 
/*     */     
/*     */     t t;
/*     */     
/* 301 */     if ((t = this.d.h()) != null)
/*     */     {
/* 303 */       this
/*     */ 
/*     */ 
/*     */         
/* 307 */         .h = ("Adobe".equals(t.a()) && ("GB1".equals(t.b()) || "CNS1".equals(t.b()) || "Japan1".equals(t.b()) || "Korea1".equals(t.b())));
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
/*     */   private void o() {
/* 319 */     j j = this.b.b(j.aR);
/* 320 */     if ((this.g && j != j.bC && j != j.bD) || this.h) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 330 */       String str = null;
/* 331 */       if (this.h) {
/*     */ 
/*     */ 
/*     */         
/* 335 */         str = this.d.h().a() + "-" + this.d.h().b() + "-" + this.d.h().c();
/*     */       }
/* 337 */       else if (j != null) {
/*     */         
/* 339 */         str = j.a();
/*     */       } 
/*     */ 
/*     */       
/* 343 */       if (str != null) {
/*     */         
/* 345 */         a a1 = c.a(str);
/* 346 */         String str1 = a1.d() + "-" + a1.e() + "-UCS2";
/* 347 */         this.f = c.a(str1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String p() {
/* 357 */     return this.b.g(j.v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o q() {
/* 365 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a l() {
/* 373 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a m() {
/* 381 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final v b() {
/* 387 */     return this.d.c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final d h() {
/* 393 */     return this.d.d();
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
/*     */   protected final byte[] d(int paramInt) {
/* 411 */     return this.d.d(paramInt);
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
/*     */   public final float a(int paramInt) {
/* 449 */     return this.d.a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final float b(int paramInt) {
/* 455 */     throw new UnsupportedOperationException("not suppported");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float c(int paramInt) {
/* 461 */     return this.d.b(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 467 */     return this.d.g();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String e(int paramInt) {
/*     */     String str;
/* 475 */     if ((str = super.e(paramInt)) != null)
/*     */     {
/* 477 */       return str;
/*     */     }
/*     */     
/* 480 */     if ((this.g || this.h) && this.f != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 486 */       int i = g(paramInt);
/*     */ 
/*     */       
/* 489 */       return this.f.a(i);
/*     */     } 
/*     */ 
/*     */     
/* 493 */     if (c.c() && !this.j.contains(Integer.valueOf(paramInt))) {
/*     */ 
/*     */       
/* 496 */       str = "CID+" + g(paramInt);
/* 497 */       (new StringBuilder("No Unicode mapping for ")).append(str).append(" (").append(paramInt).append(") in font ").append(d());
/*     */       
/* 499 */       this.j.add(Integer.valueOf(paramInt));
/*     */     } 
/* 501 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String d() {
/* 508 */     return p();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/* 515 */     return this.d.e();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(InputStream paramInputStream) {
/* 521 */     return this.e.a(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int g(int paramInt) {
/* 532 */     return this.d.c(paramInt);
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
/*     */   public final boolean i() {
/* 549 */     return false;
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
/*     */   public String toString() {
/* 561 */     String str = null;
/* 562 */     if (q() != null)
/*     */     {
/* 564 */       str = q().getClass().getSimpleName();
/*     */     }
/* 566 */     return getClass().getSimpleName() + "/" + str + ", PostScript name: " + p();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */