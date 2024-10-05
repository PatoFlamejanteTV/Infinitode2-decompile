/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.b.b;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.g;
/*     */ import com.d.e.ac;
/*     */ import com.d.e.ad;
/*     */ import com.d.e.j;
/*     */ import com.d.e.v;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Text;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class q
/*     */   implements ac
/*     */ {
/*     */   private Element a;
/*     */   private String b;
/*     */   private String c;
/*     */   private boolean d;
/*     */   private boolean e;
/*     */   private boolean f;
/*     */   private c g;
/*     */   private b h;
/*     */   private e i;
/*     */   private boolean j;
/*     */   private int k;
/*     */   private int l;
/*     */   private int m;
/*     */   private String n;
/*     */   private final Text o;
/*     */   private byte p;
/*     */   
/*     */   public q(String paramString, Text paramText) {
/*  78 */     this.c = paramString;
/*  79 */     this.b = paramString;
/*  80 */     this.o = paramText;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte paramByte) {
/*  89 */     this.p = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte b() {
/*  96 */     return this.p;
/*     */   }
/*     */   
/*     */   public final String c() {
/* 100 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(String paramString) {
/* 104 */     this.c = paramString;
/* 105 */     this.b = paramString;
/*     */   }
/*     */   
/*     */   public final void d() {
/* 109 */     this.c = this.b;
/* 110 */     this.c = ad.a(this.c, a());
/*     */   }
/*     */   
/*     */   public final boolean e() {
/* 114 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 118 */     this.d = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean f() {
/* 122 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 126 */     this.f = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean g() {
/* 130 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void c(boolean paramBoolean) {
/* 134 */     this.e = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public final c a() {
/* 139 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(c paramc) {
/* 144 */     this.g = paramc;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Element h() {
/* 149 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Element paramElement) {
/* 154 */     this.a = paramElement;
/*     */   }
/*     */   
/*     */   public final b i() {
/* 158 */     return this.h;
/*     */   }
/*     */   
/*     */   public final void a(b paramb) {
/* 162 */     this.h = paramb;
/*     */   }
/*     */   
/*     */   public final boolean j() {
/* 166 */     return (this.h != null);
/*     */   }
/*     */   
/*     */   private int a(v paramv, String paramString) {
/* 170 */     paramv
/* 171 */       .w(); return paramv.d().a(paramv
/* 172 */         .c(a().b((d)paramv)), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private int b(v paramv, String paramString) {
/* 177 */     char[] arrayOfChar = paramString.toCharArray();
/* 178 */     int i = 0;
/* 179 */     for (byte b1 = 0; b1 < arrayOfChar.length; b1++) {
/*     */       int j;
/* 181 */       if ((j = a(paramv, Character.toString(arrayOfChar[b1]))) > i) {
/* 182 */         i = j;
/*     */       }
/*     */     } 
/* 185 */     return i;
/*     */   }
/*     */   
/*     */   private void b(v paramv, int paramInt, boolean paramBoolean) {
/* 189 */     int i = 0;
/*     */     
/*     */     int j;
/* 192 */     while ((j = this.c.indexOf("\n", i)) != -1) {
/* 193 */       String str1 = this.c.substring(i, j);
/* 194 */       if (paramBoolean) {
/* 195 */         str1 = str1.trim();
/*     */       }
/* 197 */       int m = a(paramv, str1);
/* 198 */       if (!i) {
/* 199 */         m += a().a((d)paramv, paramInt, 1);
/*     */       }
/* 201 */       if (m > this.k) {
/* 202 */         this.k = m;
/*     */       }
/* 204 */       if (!i) {
/* 205 */         this.m = m;
/*     */       }
/* 207 */       i = j + 1;
/*     */     } 
/*     */     
/* 210 */     String str = this.c.substring(i);
/* 211 */     if (paramBoolean) {
/* 212 */       str = str.trim();
/*     */     }
/*     */     
/*     */     int k;
/* 216 */     if ((k = (k = a(paramv, str)) + a().a((d)paramv, paramInt, 2)) > this.k) {
/* 217 */       this.k = k;
/*     */     }
/* 219 */     if (i == 0) {
/* 220 */       this.m = k;
/*     */     }
/*     */   }
/*     */   
/*     */   private int b(v paramv) {
/* 225 */     paramv
/* 226 */       .w();
/* 227 */     return paramv.d().a(a().d((d)paramv), " ");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(v paramv) {
/* 233 */     if (this.c.length() > 0 && this.c.charAt(this.c.length() - 1) == ' ') {
/* 234 */       return b(paramv);
/*     */     }
/* 236 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(v paramv, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 242 */     int k, j = -1;
/*     */     
/* 244 */     int m = 0;
/*     */     
/* 246 */     int n = 0;
/* 247 */     byte b1 = 0;
/*     */ 
/*     */     
/* 250 */     int i1 = 0;
/* 251 */     int i2 = 0;
/*     */     
/*     */     String str2;
/* 254 */     g g = j.b(str2 = d(paramBoolean1), paramv.y());
/*     */     
/*     */     int i;
/* 257 */     while ((i = g.a()) != -1) {
/* 258 */       String str = str2.substring(m, i);
/* 259 */       int i4 = a(paramv, str);
/*     */       
/* 261 */       if (a().j() == c.as) {
/* 262 */         m = b(paramv, str);
/*     */       } else {
/* 264 */         m = i4;
/*     */       } 
/*     */       
/* 267 */       if (b1) {
/* 268 */         if (paramBoolean2) {
/* 269 */           for (byte b2 = 0; b2 < b1; b2++) {
/* 270 */             i4 += j;
/* 271 */             m += j;
/*     */           } 
/*     */         } else {
/* 274 */           n += j;
/*     */         } 
/* 276 */         b1 = 0;
/*     */       } 
/* 278 */       if (m > 0) {
/*     */         
/* 280 */         i1 = m;
/*     */         
/* 282 */         i2 = m;
/*     */       } 
/*     */       
/* 285 */       if (m > this.l) {
/* 286 */         this.l = m;
/*     */       }
/* 288 */       n += i4;
/*     */       
/* 290 */       m = i;
/* 291 */       for (int i5 = i; i5 < str2.length() && 
/* 292 */         str2.charAt(i5) == ' '; i5++) {
/* 293 */         b1++;
/* 294 */         m++;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 299 */       if (b1 > 0 && j == -1) {
/* 300 */         j = b(paramv);
/*     */       }
/*     */     } 
/*     */     
/* 304 */     String str1 = str2.substring(m);
/* 305 */     int i3 = a(paramv, str1);
/*     */     
/* 307 */     if (a().j() == c.as) {
/* 308 */       k = b(paramv, str1);
/*     */     } else {
/* 310 */       k = i3;
/*     */     } 
/* 312 */     if (b1 > 0) {
/* 313 */       if (paramBoolean2) {
/* 314 */         for (byte b2 = 0; b2 < b1; b2++) {
/* 315 */           i3 += j;
/* 316 */           k += j;
/*     */         } 
/*     */       } else {
/* 319 */         n += j;
/*     */       } 
/*     */     }
/*     */     
/* 323 */     if (k > 0) {
/*     */       
/* 325 */       i1 = k;
/*     */       
/* 327 */       i2 = k;
/*     */     } 
/* 329 */     if (k > this.l) {
/* 330 */       this.l = k;
/*     */     }
/* 332 */     n += i3;
/*     */     
/* 334 */     if (g()) {
/* 335 */       int i4 = a().a((d)paramv, paramInt, 1);
/* 336 */       if (i1 + i4 > this.l) {
/* 337 */         this.l = i1 + i4;
/*     */       }
/* 339 */       n += i4;
/*     */     } 
/*     */     
/* 342 */     if (f()) {
/* 343 */       int i4 = a().a((d)paramv, paramInt, 2);
/* 344 */       if (i2 + i4 > this.l) {
/* 345 */         this.l = i2 + i4;
/*     */       }
/* 347 */       n += i4;
/*     */     } 
/*     */     
/* 350 */     return n;
/*     */   }
/*     */   
/*     */   private String d(boolean paramBoolean) {
/* 354 */     if (!paramBoolean) {
/* 355 */       return c();
/*     */     }
/* 357 */     if (this.c.length() > 0 && this.c.charAt(0) == ' ') {
/* 358 */       return this.c.substring(1);
/*     */     }
/* 360 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(v paramv, int paramInt) {
/* 366 */     return a().a((d)paramv, paramInt, 1) + 
/* 367 */       a().a((d)paramv, paramInt, 2);
/*     */   }
/*     */   
/*     */   public final void a(v paramv, int paramInt, boolean paramBoolean) {
/* 371 */     if (!this.j) {
/*     */       c c1;
/* 373 */       if ((c1 = a().i()) == c.ar) {
/* 374 */         this.l = this.k = a(paramv, paramInt) + a(paramv, d(paramBoolean));
/* 375 */       } else if (c1 == c.aB) {
/* 376 */         b(paramv, paramInt, false);
/* 377 */         this.l = this.k;
/* 378 */       } else if (c1 == c.aD) {
/* 379 */         a(paramv, paramInt, false, true);
/* 380 */         b(paramv, paramInt, false);
/* 381 */       } else if (c1 == c.aC) {
/* 382 */         a(paramv, paramInt, paramBoolean, false);
/* 383 */         b(paramv, paramInt, true);
/*     */       } else {
/* 385 */         this.k = a(paramv, paramInt, paramBoolean, false);
/*     */       } 
/* 387 */       this.l = Math.min(this.k, this.l);
/* 388 */       this.j = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final int k() {
/* 393 */     return this.k;
/*     */   }
/*     */   
/*     */   public final int l() {
/* 397 */     return this.l;
/*     */   }
/*     */   
/*     */   public final int m() {
/* 401 */     return this.m;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String n() {
/* 406 */     return this.n;
/*     */   }
/*     */   
/*     */   public final void b(String paramString) {
/* 410 */     this.n = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 416 */     (stringBuilder = new StringBuilder()).append("InlineBox: ");
/* 417 */     if (h() != null) {
/* 418 */       stringBuilder.append("<");
/* 419 */       stringBuilder.append(h().getNodeName());
/* 420 */       stringBuilder.append("> ");
/*     */     } else {
/* 422 */       stringBuilder.append("(anonymous) ");
/*     */     } 
/* 424 */     if (n() != null) {
/* 425 */       stringBuilder.append(':');
/* 426 */       stringBuilder.append(n());
/* 427 */       stringBuilder.append(' ');
/*     */     } 
/* 429 */     if (g() || f()) {
/* 430 */       stringBuilder.append("(");
/* 431 */       if (g()) {
/* 432 */         stringBuilder.append("S");
/*     */       }
/* 434 */       if (f()) {
/* 435 */         stringBuilder.append("E");
/*     */       }
/* 437 */       stringBuilder.append(") ");
/*     */     } 
/*     */     
/* 440 */     a(stringBuilder);
/*     */     
/* 442 */     stringBuilder.append("(");
/* 443 */     stringBuilder.append(r());
/* 444 */     stringBuilder.append(") ");
/* 445 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void a(StringBuilder paramStringBuilder) {
/* 449 */     if (a().F()) {
/* 450 */       paramStringBuilder.append("(relative) ");
/*     */     }
/* 452 */     if (a().B()) {
/* 453 */       paramStringBuilder.append("(fixed) ");
/*     */     }
/* 455 */     if (a().A()) {
/* 456 */       paramStringBuilder.append("(absolute) ");
/*     */     }
/* 458 */     if (a().C()) {
/* 459 */       paramStringBuilder.append("(floated) ");
/*     */     }
/*     */   }
/*     */   
/*     */   private String r() {
/* 464 */     if (this.c == null) {
/* 465 */       return null;
/*     */     }
/* 467 */     StringBuilder stringBuilder = new StringBuilder();
/* 468 */     for (byte b1 = 0; b1 < this.c.length() && b1 < 40; b1++) {
/*     */       char c1;
/* 470 */       if ((c1 = this.c.charAt(b1)) == '\n') {
/* 471 */         stringBuilder.append(' ');
/*     */       } else {
/* 473 */         stringBuilder.append(c1);
/*     */       } 
/*     */     } 
/* 476 */     if (stringBuilder.length() == 40) {
/* 477 */       stringBuilder.append("...");
/*     */     }
/* 479 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final e o() {
/* 484 */     return this.i;
/*     */   }
/*     */   
/*     */   public final void a(e parame) {
/* 488 */     this.i = parame;
/*     */   }
/*     */   
/*     */   public final void p() {
/* 492 */     this.c = "";
/* 493 */     this.b = "";
/*     */   }
/*     */   
/*     */   public final Text q() {
/* 497 */     return this.o;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */