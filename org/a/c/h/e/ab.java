/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.f.ag;
/*     */ import org.a.b.f.al;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.b.f.d;
/*     */ import org.a.b.f.f;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.e.a.a;
/*     */ import org.a.c.h.e.a.c;
/*     */ import org.a.c.h.e.a.d;
/*     */ import org.a.c.h.e.a.f;
/*     */ import org.a.c.h.e.a.h;
/*     */ import org.a.c.h.e.a.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ab
/*     */   extends aa
/*     */ {
/*  58 */   private static final a e = c.a(ab.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private static final Map<String, Integer> f = new HashMap<String, Integer>(250); private d g; private d h;
/*     */   
/*     */   static {
/*     */     Map<?, ?> map;
/*  68 */     for (Map.Entry<?, ?> entry : (map = f.c.d()).entrySet()) {
/*     */       
/*  70 */       if (!f.containsKey(entry.getValue()))
/*     */       {
/*  72 */         f.put((String)entry.getValue(), (Integer)entry.getKey());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Integer, Integer> k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ap l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ab(d paramd) {
/* 184 */     super(paramd); ap ap1; this.g = null; this.h = null; this.i = null;
/*     */     this.j = false;
/* 186 */     paramd = null;
/*     */     
/* 188 */     if (b() != null) {
/*     */       i i;
/*     */       
/*     */       v v;
/* 192 */       if ((i = (v = b()).p()) != null) {
/*     */         try {
/*     */           al al;
/*     */ 
/*     */ 
/*     */           
/* 198 */           ap1 = (al = new al(true)).b((InputStream)i.c());
/*     */         }
/* 200 */         catch (NullPointerException nullPointerException) {
/*     */           
/* 202 */           (new StringBuilder("Could not read embedded TTF for font ")).append(s());
/*     */         
/*     */         }
/* 205 */         catch (IOException iOException) {
/*     */           
/* 207 */           (new StringBuilder("Could not read embedded TTF for font ")).append(s());
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 212 */     this.m = (ap1 != null);
/*     */ 
/*     */ 
/*     */     
/* 216 */     if (ap1 == null) {
/*     */       m<ap> m;
/*     */ 
/*     */ 
/*     */       
/* 221 */       ap1 = (m = l.a().a(s(), b())).c();
/*     */       
/* 223 */       if (m.d())
/*     */       {
/* 225 */         (new StringBuilder("Using fallback font '")).append(ap1).append("' for '").append(s()).append("'");
/*     */       }
/*     */     } 
/* 228 */     this.l = ap1;
/* 229 */     l();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String s() {
/* 237 */     return this.b.g(j.v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final c m() {
/* 243 */     if (!c() && a() != null)
/*     */     {
/*     */       
/* 246 */       return (c)new j(a());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 253 */     if (r() != null && !r().booleanValue())
/*     */     {
/* 255 */       return (c)h.c;
/*     */     }
/*     */ 
/*     */     
/* 259 */     String str = ah.c(d());
/*     */ 
/*     */     
/* 262 */     if (i() && 
/* 263 */       !str.equals("Symbol") && 
/* 264 */       !str.equals("ZapfDingbats"))
/*     */     {
/* 266 */       return (c)h.c;
/*     */     }
/*     */ 
/*     */     
/* 270 */     ag ag = this.l.k();
/* 271 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 272 */     for (byte b = 0; b <= 'Ā'; b++) {
/*     */       int i;
/*     */       
/* 275 */       if ((i = g(b)) > 0) {
/*     */         
/* 277 */         String str1 = null;
/* 278 */         if (ag != null)
/*     */         {
/* 280 */           str1 = ag.a(i);
/*     */         }
/* 282 */         if (str1 == null)
/*     */         {
/*     */           
/* 285 */           str1 = Integer.toString(i);
/*     */         }
/* 287 */         hashMap.put(Integer.valueOf(b), str1);
/*     */       } 
/*     */     } 
/* 290 */     return (c)new a(hashMap);
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
/*     */   public final int a(InputStream paramInputStream) {
/* 319 */     return paramInputStream.read();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String d() {
/* 325 */     return s();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/* 331 */     if (this.n == null)
/*     */     {
/* 333 */       this.n = t();
/*     */     }
/* 335 */     return this.n;
/*     */   }
/*     */   
/*     */   private a t() {
/*     */     h h;
/* 340 */     if (b() != null && (
/*     */       
/* 342 */       h = b().j()) != null)
/*     */     {
/* 344 */       return new a(h.c(), h.d(), h
/* 345 */           .e(), h.g());
/*     */     }
/*     */     
/* 348 */     return this.l.c();
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
/*     */   public final float c(int paramInt) {
/* 368 */     paramInt = g(paramInt);
/* 369 */     float f1 = this.l.a(paramInt);
/*     */     float f2;
/* 371 */     if ((f2 = this.l.x()) != 1000.0F)
/*     */     {
/* 373 */       f1 *= 1000.0F / f2;
/*     */     }
/* 375 */     return f1;
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
/* 393 */     if (this.c != null) {
/*     */       
/* 395 */       if (!this.c.a(o().a(paramInt)))
/*     */       {
/* 397 */         throw new IllegalArgumentException(
/* 398 */             String.format("U+%04X is not available in this font's encoding: %s", new Object[] {
/* 399 */                 Integer.valueOf(paramInt), this.c.a()
/*     */               }));
/*     */       }
/* 402 */       String str1 = o().a(paramInt);
/* 403 */       Map map = this.c.e();
/*     */       
/* 405 */       if (!this.l.b(str1)) {
/*     */ 
/*     */         
/* 408 */         String str2 = l.a(paramInt);
/* 409 */         if (!this.l.b(str2))
/*     */         {
/* 411 */           throw new IllegalArgumentException(
/* 412 */               String.format("No glyph for U+%04X in font %s", new Object[] { Integer.valueOf(paramInt), d() }));
/*     */         }
/*     */       } 
/*     */       
/* 416 */       int j = ((Integer)map.get(str1)).intValue();
/* 417 */       return new byte[] { (byte)j };
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 422 */     String str = o().a(paramInt);
/*     */     
/* 424 */     if (!this.l.b(str))
/*     */     {
/* 426 */       throw new IllegalArgumentException(
/* 427 */           String.format("No glyph for U+%04X in font %s", new Object[] { Integer.valueOf(paramInt), d() }));
/*     */     }
/*     */     
/* 430 */     int i = this.l.e(str);
/*     */     Integer integer;
/* 432 */     if ((integer = u().get(Integer.valueOf(i))) == null)
/*     */     {
/* 434 */       throw new IllegalArgumentException(
/* 435 */           String.format("U+%04X is not available in this font's Encoding", new Object[] { Integer.valueOf(paramInt) }));
/*     */     }
/*     */     
/* 438 */     return new byte[] { (byte)integer.intValue() };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Integer, Integer> u() {
/* 447 */     if (this.k != null)
/*     */     {
/* 449 */       return this.k;
/*     */     }
/*     */     
/* 452 */     this.k = new HashMap<Integer, Integer>();
/* 453 */     for (byte b = 0; b <= 'ÿ'; b++) {
/*     */       
/* 455 */       int i = g(b);
/* 456 */       if (!this.k.containsKey(Integer.valueOf(i)))
/*     */       {
/* 458 */         this.k.put(Integer.valueOf(i), Integer.valueOf(b));
/*     */       }
/*     */     } 
/* 461 */     return this.k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 467 */     return this.m;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int g(int paramInt) {
/*     */     String str;
/* 553 */     v();
/* 554 */     int i = 0;
/*     */     
/* 556 */     if (!p()) {
/*     */       
/* 558 */       str = this.c.a(paramInt);
/* 559 */       if (".notdef".equals(str))
/*     */       {
/* 561 */         return 0;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 566 */       if (this.g != null) {
/*     */         String str1;
/*     */         
/* 569 */         if ((str1 = d.a().a(str)) != null) {
/*     */           
/* 571 */           i = str1.codePointAt(0);
/* 572 */           i = this.g.a(i);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 577 */       if (i == 0 && this.i != null) {
/*     */         Integer integer;
/*     */         
/* 580 */         if ((integer = f.get(str)) != null)
/*     */         {
/* 582 */           i = this.i.a(integer.intValue());
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 587 */       if (i == 0)
/*     */       {
/* 589 */         i = this.l.e(str);
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 596 */       if (this.h != null) {
/*     */         
/* 598 */         i = this.h.a(str);
/* 599 */         if (str >= null && str <= 'ÿ') {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 604 */           if (i == 0)
/*     */           {
/*     */             
/* 607 */             i = this.h.a(str + 61440);
/*     */           }
/* 609 */           if (i == 0)
/*     */           {
/*     */             
/* 612 */             i = this.h.a(str + 61696);
/*     */           }
/* 614 */           if (i == 0)
/*     */           {
/*     */             
/* 617 */             i = this.h.a(str + 61952);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 623 */       if (i == 0 && this.i != null)
/*     */       {
/* 625 */         i = this.i.a(str);
/*     */       }
/*     */ 
/*     */       
/* 629 */       if (i == 0 && this.g != null && this.c != null) {
/*     */         
/* 631 */         str = this.c.a(str);
/* 632 */         if (".notdef".equals(str))
/*     */         {
/* 634 */           return 0;
/*     */         }
/*     */         String str1;
/* 637 */         if ((str1 = d.a().a(str)) != null) {
/*     */           
/* 639 */           i = str1.codePointAt(0);
/* 640 */           i = this.g.a(i);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 645 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void v() {
/* 653 */     if (this.j) {
/*     */       return;
/*     */     }
/*     */     
/*     */     f f;
/*     */     
/* 659 */     if ((f = this.l.r()) != null) {
/*     */       d[] arrayOfD;
/*     */       int i;
/*     */       byte b;
/* 663 */       for (i = (arrayOfD = arrayOfD = f.a()).length, b = 0; b < i; ) { d d1 = arrayOfD[b];
/*     */         
/* 665 */         if (3 == d1.b()) {
/*     */           
/* 667 */           if (1 == d1.a())
/*     */           {
/* 669 */             this.g = d1;
/*     */           }
/* 671 */           else if (0 == d1.a())
/*     */           {
/* 673 */             this.h = d1;
/*     */           }
/*     */         
/* 676 */         } else if (1 == d1.b() && 0 == d1
/* 677 */           .a()) {
/*     */           
/* 679 */           this.i = d1;
/*     */         }  b++; }
/*     */     
/*     */     } 
/* 683 */     this.j = true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */