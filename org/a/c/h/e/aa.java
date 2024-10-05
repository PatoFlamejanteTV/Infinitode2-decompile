/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.e.a.b;
/*     */ import org.a.c.h.e.a.c;
/*     */ import org.a.c.h.e.a.d;
/*     */ import org.a.c.h.e.a.g;
/*     */ import org.a.c.h.e.a.h;
/*     */ import org.a.c.h.e.a.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class aa
/*     */   extends u
/*     */ {
/*  44 */   private static final a e = c.a(aa.class);
/*     */   
/*     */   protected c c;
/*     */   protected d d;
/*     */   private Boolean f;
/*  49 */   private final Set<Integer> g = new HashSet<Integer>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   aa() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   aa(String paramString) {
/*  64 */     super(paramString);
/*     */ 
/*     */     
/*  67 */     if ("ZapfDingbats".equals(paramString)) {
/*     */       
/*  69 */       this.d = d.b();
/*     */       
/*     */       return;
/*     */     } 
/*  73 */     this.d = d.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   aa(d paramd) {
/*  84 */     super(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void l() {
/*     */     b b;
/*  96 */     if ((b = this.b.a(j.aR)) != null) {
/*     */       j j;
/*  98 */       if (b instanceof j) {
/*     */         
/* 100 */         j = (j)b;
/* 101 */         this.c = c.a(j);
/* 102 */         if (this.c == null)
/*     */         {
/* 104 */           (new StringBuilder("Unknown encoding: ")).append(j.a());
/* 105 */           this.c = m();
/*     */         }
/*     */       
/* 108 */       } else if (j instanceof d) {
/*     */         
/* 110 */         d d1 = (d)j;
/* 111 */         c c1 = null;
/*     */         Boolean bool;
/* 113 */         boolean bool1 = ((bool = r()) != null && bool.booleanValue()) ? true : false;
/*     */ 
/*     */         
/*     */         boolean bool2;
/*     */         
/*     */         j j1;
/*     */         
/* 120 */         if (!(bool2 = ((j1 = d1.b(j.u)) != null && c.a(j1) != null) ? true : false) && bool1)
/*     */         {
/* 122 */           c1 = m();
/*     */         }
/*     */         
/* 125 */         if (bool == null)
/*     */         {
/* 127 */           bool = Boolean.FALSE;
/*     */         }
/* 129 */         this.c = (c)new b(d1, !bool.booleanValue(), c1);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 134 */       this.c = m();
/*     */     } 
/*     */ 
/*     */     
/* 138 */     String str = ah.c(d());
/*     */ 
/*     */     
/* 141 */     if ("ZapfDingbats".equals(str)) {
/*     */       
/* 143 */       this.d = d.b();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 148 */     this.d = d.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract c m();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c n() {
/* 164 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d o() {
/* 172 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean p() {
/* 181 */     if (this.f == null) {
/*     */       Boolean bool;
/*     */       
/* 184 */       if ((bool = q()) != null) {
/*     */         
/* 186 */         this.f = bool;
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 191 */         this.f = Boolean.TRUE;
/*     */       } 
/*     */     } 
/* 194 */     return this.f.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Boolean q() {
/*     */     Boolean bool;
/* 204 */     if ((bool = r()) != null)
/*     */     {
/* 206 */       return bool;
/*     */     }
/* 208 */     if (i()) {
/*     */       String str;
/*     */       
/* 211 */       return Boolean.valueOf(((str = ah.c(d())).equals("Symbol") || str.equals("ZapfDingbats")));
/*     */     } 
/*     */ 
/*     */     
/* 215 */     if (this.c == null) {
/*     */ 
/*     */       
/* 218 */       if (!(this instanceof ab))
/*     */       {
/* 220 */         throw new IllegalStateException("PDFBox bug: encoding should not be null!");
/*     */       }
/*     */ 
/*     */       
/* 224 */       return Boolean.TRUE;
/*     */     } 
/* 226 */     if (this.c instanceof k || this.c instanceof g || this.c instanceof h)
/*     */     {
/*     */ 
/*     */       
/* 230 */       return Boolean.FALSE;
/*     */     }
/* 232 */     if (this.c instanceof b) {
/*     */ 
/*     */       
/* 235 */       for (String str : ((b)this.c).c().values()) {
/*     */         
/* 237 */         if (!".notdef".equals(str))
/*     */         {
/*     */ 
/*     */           
/* 241 */           if (!k.c.a(str) || 
/* 242 */             !g.d.a(str) || 
/* 243 */             !h.c.a(str))
/*     */           {
/* 245 */             return Boolean.TRUE;
/*     */           }
/*     */         }
/*     */       } 
/* 249 */       return Boolean.FALSE;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 254 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Boolean r() {
/* 265 */     if (b() != null)
/*     */     {
/*     */       
/* 268 */       return Boolean.valueOf(b().c());
/*     */     }
/* 270 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String e(int paramInt) {
/* 276 */     return a(paramInt, d.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(int paramInt, d paramd) {
/* 285 */     if (this.d == d.a()) {
/*     */       
/* 287 */       paramd = paramd;
/*     */     }
/*     */     else {
/*     */       
/* 291 */       paramd = this.d;
/*     */     } 
/*     */     
/*     */     String str1;
/*     */     
/* 296 */     if ((str1 = super.e(paramInt)) != null)
/*     */     {
/* 298 */       return str1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 307 */     String str2 = null;
/* 308 */     if (this.c != null) {
/*     */       
/* 310 */       str2 = this.c.a(paramInt);
/*     */       
/* 312 */       if ((str1 = paramd.a(str2)) != null)
/*     */       {
/* 314 */         return str1;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 319 */     if (e.c() && !this.g.contains(Integer.valueOf(paramInt))) {
/*     */ 
/*     */       
/* 322 */       this.g.add(Integer.valueOf(paramInt));
/* 323 */       if (str2 != null) {
/*     */         
/* 325 */         (new StringBuilder("No Unicode mapping for ")).append(str2).append(" (").append(paramInt).append(") in font ")
/* 326 */           .append(d());
/*     */       }
/*     */       else {
/*     */         
/* 330 */         (new StringBuilder("No Unicode mapping for character code ")).append(paramInt).append(" in font ")
/* 331 */           .append(d());
/*     */       } 
/*     */     } 
/*     */     
/* 335 */     return null;
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
/*     */   protected final float b(int paramInt) {
/* 347 */     if (a() != null) {
/*     */       
/* 349 */       String str = n().a(paramInt);
/*     */ 
/*     */       
/* 352 */       if (".notdef".equals(str))
/*     */       {
/* 354 */         return 250.0F;
/*     */       }
/*     */       
/* 357 */       return a().a(str);
/*     */     } 
/* 359 */     throw new IllegalStateException("No AFM");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean i() {
/* 367 */     if (n() instanceof b) {
/*     */       b b;
/*     */       
/* 370 */       if ((b = (b)n()).c().size() > 0) {
/*     */ 
/*     */ 
/*     */         
/* 374 */         c c1 = b.b();
/* 375 */         for (Iterator<Map.Entry> iterator = b.c().entrySet().iterator(); iterator.hasNext();) {
/*     */           
/* 377 */           if (!((String)(entry = iterator.next()).getValue()).equals(c1.a(((Integer)entry.getKey()).intValue())))
/*     */           {
/* 379 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 384 */     return super.i();
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
/*     */   public final void f(int paramInt) {
/* 411 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void j() {
/* 418 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean k() {
/* 424 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */