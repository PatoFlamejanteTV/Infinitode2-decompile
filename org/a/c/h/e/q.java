/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.c.a;
/*     */ import org.a.b.f.ab;
/*     */ import org.a.b.f.ad;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.b.f.c;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
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
/*     */ public class q
/*     */   extends o
/*     */ {
/*  43 */   private static final a b = c.a(q.class);
/*     */ 
/*     */   
/*     */   private final ap c;
/*     */   
/*     */   private final int[] d;
/*     */   
/*     */   private final boolean e;
/*     */   
/*     */   private final boolean f;
/*     */   
/*     */   private final c g;
/*     */   
/*     */   private d h;
/*     */   
/*     */   private a i;
/*     */ 
/*     */   
/*     */   public q(d paramd, ac paramac) {
/*  62 */     this(paramd, paramac, (ap)null);
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
/*     */   public q(d paramd, ac paramac, ap paramap) {
/*  75 */     super(paramd, paramac);
/*     */     
/*  77 */     v v = c();
/*  78 */     if (paramap != null) {
/*     */       
/*  80 */       this.c = paramap;
/*  81 */       this.e = true;
/*  82 */       this.f = false;
/*     */     } else {
/*     */       ad ad;
/*     */       ap ap1;
/*  86 */       boolean bool = false;
/*  87 */       paramap = null;
/*     */       
/*  89 */       i i = null;
/*  90 */       if (v != null) {
/*     */ 
/*     */         
/*  93 */         if ((i = v.p()) == null)
/*     */         {
/*  95 */           i = v.q();
/*     */         }
/*  97 */         if (i == null)
/*     */         {
/*     */           
/* 100 */           i = v.o();
/*     */         }
/*     */       } 
/* 103 */       if (i != null) {
/*     */         try {
/*     */           ab ab;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 110 */           ad ad1 = (ab = new ab(true)).a((InputStream)i.c());
/*     */           
/* 112 */           if (ad1.f()) {
/*     */ 
/*     */             
/* 115 */             bool = true;
/* 116 */             (new StringBuilder("Found CFF/OTF but expected embedded TTF font ")).append(v.g());
/*     */           } 
/*     */           
/* 119 */           if (ad1.g())
/*     */           {
/* 121 */             (new StringBuilder("OpenType Layout tables used in font ")).append(a()).append(" are not implemented in PDFBox and will be ignored");
/*     */           
/*     */           }
/*     */         }
/* 125 */         catch (NullPointerException nullPointerException) {
/*     */           
/* 127 */           bool = true;
/* 128 */           (new StringBuilder("Could not read embedded OTF for font ")).append(a());
/*     */         }
/* 130 */         catch (IOException iOException) {
/*     */           
/* 132 */           bool = true;
/* 133 */           (new StringBuilder("Could not read embedded OTF for font ")).append(a());
/*     */         } 
/*     */       }
/* 136 */       this.e = (ad != null);
/* 137 */       this.f = bool;
/*     */       
/* 139 */       if (ad == null)
/*     */       {
/* 141 */         ap1 = j();
/*     */       }
/* 143 */       this.c = ap1;
/*     */     } 
/* 145 */     this.g = this.c.a(false);
/* 146 */     this.d = i();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ap j() {
/*     */     ap ap1;
/*     */     a a1;
/* 156 */     if ((a1 = l.a().a(a(), c(), h())).b()) {
/*     */       
/* 158 */       ap1 = (ap)a1.c();
/*     */     }
/*     */     else {
/*     */       
/* 162 */       ap1 = (ap)a1.a();
/*     */     } 
/* 164 */     if (a1.d())
/*     */     {
/* 166 */       (new StringBuilder("Using fallback font ")).append(ap1.b()).append(" for CID-keyed TrueType font ").append(a());
/*     */     }
/* 168 */     return ap1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final d d() {
/* 174 */     if (this.h == null)
/*     */     {
/*     */       
/* 177 */       this.h = new d(0.001F, 0.0F, 0.0F, 0.001F, 0.0F, 0.0F);
/*     */     }
/* 179 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/* 185 */     if (this.i == null)
/*     */     {
/* 187 */       this.i = k();
/*     */     }
/* 189 */     return this.i;
/*     */   }
/*     */ 
/*     */   
/*     */   private a k() {
/* 194 */     if (c() != null) {
/*     */       h h;
/*     */       
/* 197 */       if ((h = c().j()) != null && (
/* 198 */         Float.compare(h.c(), 0.0F) != 0 || 
/* 199 */         Float.compare(h.d(), 0.0F) != 0 || 
/* 200 */         Float.compare(h.e(), 0.0F) != 0 || 
/* 201 */         Float.compare(h.g(), 0.0F) != 0))
/*     */       {
/* 203 */         return new a(h.c(), h.d(), h
/* 204 */             .e(), h.g());
/*     */       }
/*     */     } 
/* 207 */     return this.c.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c(int paramInt) {
/*     */     a a1;
/* 216 */     if (!(a1 = this.a.l()).a() && a1.b())
/*     */     {
/* 218 */       return a1.a(paramInt).codePointAt(0);
/*     */     }
/*     */     
/* 221 */     return a1.b(paramInt);
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
/*     */   private int e(int paramInt) {
/* 234 */     if (!this.e) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 241 */       if (this.d != null && !this.f) {
/*     */ 
/*     */         
/* 244 */         (new StringBuilder("Using non-embedded GIDs in font ")).append(b());
/* 245 */         int j = c(paramInt);
/* 246 */         return this.d[j];
/*     */       } 
/*     */ 
/*     */       
/*     */       String str;
/*     */       
/* 252 */       if ((str = this.a.e(paramInt)) == null) {
/*     */         
/* 254 */         (new StringBuilder("Failed to find a character mapping for ")).append(paramInt).append(" in ").append(b());
/*     */ 
/*     */         
/* 257 */         return c(paramInt);
/*     */       } 
/* 259 */       str.length();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 265 */       return this.g.a(str.codePointAt(0));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     int i = c(paramInt);
/* 275 */     if (this.d != null) {
/*     */ 
/*     */       
/* 278 */       if (i < this.d.length)
/*     */       {
/* 280 */         return this.d[i];
/*     */       }
/*     */ 
/*     */       
/* 284 */       return 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 290 */     if (i < this.c.w())
/*     */     {
/* 292 */       return i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 297 */     return 0;
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
/*     */   public final float b(int paramInt) {
/* 314 */     paramInt = e(paramInt);
/* 315 */     paramInt = this.c.a(paramInt);
/*     */     int i;
/* 317 */     if ((i = this.c.x()) != 1000)
/*     */     {
/* 319 */       paramInt = (int)(paramInt * 1000.0F / i);
/*     */     }
/* 321 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] d(int paramInt) {
/* 327 */     int i = -1;
/* 328 */     if (this.e) {
/*     */ 
/*     */       
/* 331 */       if (this.a.l().c().startsWith("Identity-")) {
/*     */         
/* 333 */         if (this.g != null)
/*     */         {
/* 335 */           i = this.g.a(paramInt);
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 341 */       else if (this.a.m() != null) {
/*     */         
/* 343 */         i = this.a.m().b(paramInt);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 348 */       if (i == -1)
/*     */       {
/*     */ 
/*     */         
/* 352 */         i = 0;
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 358 */       i = this.g.a(paramInt);
/*     */     } 
/*     */     
/* 361 */     if (i == 0)
/*     */     {
/* 363 */       throw new IllegalArgumentException(
/* 364 */           String.format("No glyph for U+%04X in font %s", new Object[] { Integer.valueOf(paramInt), b() }));
/*     */     }
/*     */ 
/*     */     
/* 368 */     return new byte[] { (byte)(i >> 8), (byte)i };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean g() {
/* 374 */     return this.e;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */