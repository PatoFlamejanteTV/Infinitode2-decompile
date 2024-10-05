/*     */ package com.a.a.a;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ public @interface l
/*     */ {
/*     */   String a() default "";
/*     */   
/*     */   c b() default c.ANY;
/*     */   
/*     */   String c() default "##default";
/*     */   
/*     */   String d() default "##default";
/*     */   
/*     */   ao e() default ao.DEFAULT;
/*     */   
/*     */   a[] f() default {};
/*     */   
/*     */   a[] g() default {};
/*     */   
/*     */   public enum c
/*     */   {
/* 156 */     a,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     b,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     c,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     d,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     e,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     f,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     j,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     g,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 206 */     h,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     k,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     i;
/*     */ 
/*     */     
/*     */     public final boolean a() {
/* 224 */       return (this == f || this == g || this == j);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum a
/*     */   {
/* 251 */     a,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 262 */     b,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     e,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     f,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     g,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 291 */     c,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 298 */     d,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 313 */     h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class b
/*     */   {
/*     */     private final int a;
/*     */ 
/*     */     
/*     */     private final int b;
/*     */ 
/*     */     
/* 326 */     private static final b c = new b(0, 0);
/*     */     
/*     */     private b(int param1Int1, int param1Int2) {
/* 329 */       this.a = param1Int1;
/* 330 */       this.b = param1Int2;
/*     */     }
/*     */     
/*     */     public static b a() {
/* 334 */       return c;
/*     */     }
/*     */     
/*     */     public static b a(l param1l) {
/* 338 */       return a(param1l.f(), param1l.g());
/*     */     }
/*     */ 
/*     */     
/*     */     private static b a(l.a[] param1ArrayOfa1, l.a[] param1ArrayOfa2) {
/* 343 */       int j = 0; int m;
/* 344 */       for (int k = (param1ArrayOfa1 = param1ArrayOfa1).length; m < k; ) { l.a a1 = param1ArrayOfa1[m];
/* 345 */         j |= 1 << a1.ordinal(); m++; }
/*     */       
/* 347 */       int i = 0; l.a[] arrayOfA; byte b1;
/* 348 */       for (m = (arrayOfA = param1ArrayOfa2).length, b1 = 0; b1 < m; ) { l.a a1 = arrayOfA[b1];
/* 349 */         i |= 1 << a1.ordinal(); b1++; }
/*     */       
/* 351 */       return new b(j, i);
/*     */     }
/*     */ 
/*     */     
/*     */     public final b a(b param1b) {
/* 356 */       if (param1b == null) {
/* 357 */         return this;
/*     */       }
/* 359 */       int j = param1b.b;
/* 360 */       int k = param1b.a;
/* 361 */       if (j == 0 && k == 0) {
/* 362 */         return this;
/*     */       }
/* 364 */       if (this.a == 0 && this.b == 0) {
/* 365 */         return param1b;
/*     */       }
/*     */       
/* 368 */       int i = this.a & (j ^ 0xFFFFFFFF) | k;
/* 369 */       j = this.b & (k ^ 0xFFFFFFFF) | j;
/*     */ 
/*     */       
/* 372 */       if (i == this.a && j == this.b) {
/* 373 */         return this;
/*     */       }
/*     */       
/* 376 */       return new b(i, j);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Boolean a(l.a param1a) {
/* 396 */       int i = 1 << param1a.ordinal();
/* 397 */       if ((this.b & i) != 0) {
/* 398 */         return Boolean.FALSE;
/*     */       }
/* 400 */       if ((this.a & i) != 0) {
/* 401 */         return Boolean.TRUE;
/*     */       }
/* 403 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 408 */       if (this == c) {
/* 409 */         return "EMPTY";
/*     */       }
/* 411 */       return String.format("(enabled=0x%x,disabled=0x%x)", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) });
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 416 */       return this.b + this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 421 */       if (param1Object == this) return true; 
/* 422 */       if (param1Object == null) return false; 
/* 423 */       if (param1Object.getClass() != getClass()) return false;
/*     */       
/* 425 */       if (((b)(param1Object = param1Object)).a == this.a && ((b)param1Object).b == this.b) return true;  return false;
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
/*     */   public static class d
/*     */     implements Serializable
/*     */   {
/* 439 */     private static final d a = new d();
/*     */ 
/*     */     
/*     */     private final String b;
/*     */ 
/*     */     
/*     */     private final l.c c;
/*     */ 
/*     */     
/*     */     private final Locale d;
/*     */ 
/*     */     
/*     */     private final String e;
/*     */     
/*     */     private final Boolean f;
/*     */     
/*     */     private final l.b g;
/*     */     
/*     */     private transient TimeZone h;
/*     */ 
/*     */     
/*     */     public d() {
/* 461 */       this("", l.c.a, "", "", l.b.a(), null);
/*     */     }
/*     */     
/*     */     private d(l param1l) {
/* 465 */       this(param1l.a(), param1l.b(), param1l.c(), param1l.d(), 
/* 466 */           l.b.a(param1l), param1l.e().a());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private d(String param1String1, l.c param1c, String param1String2, String param1String3, l.b param1b, Boolean param1Boolean) {
/* 475 */       this(param1String1, param1c, (param1String2 == null || param1String2
/* 476 */           .length() == 0 || "##default".equals(param1String2)) ? null : new Locale(param1String2), (param1String3 == null || param1String3
/*     */           
/* 478 */           .length() == 0 || "##default".equals(param1String3)) ? null : param1String3, null, param1b, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private d(String param1String1, l.c param1c, Locale param1Locale, String param1String2, TimeZone param1TimeZone, l.b param1b, Boolean param1Boolean) {
/* 504 */       this.b = (param1String1 == null) ? "" : param1String1;
/* 505 */       this.c = (param1c == null) ? l.c.a : param1c;
/* 506 */       this.d = param1Locale;
/* 507 */       this.h = param1TimeZone;
/* 508 */       this.e = param1String2;
/* 509 */       this.g = (param1b == null) ? l.b.a() : param1b;
/* 510 */       this.f = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final d a() {
/* 531 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static d a(d param1d1, d param1d2) {
/* 547 */       return (param1d1 == null) ? param1d2 : param1d1
/* 548 */         .a(param1d2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final d a(l param1l) {
/* 569 */       return (param1l == null) ? a : new d(param1l);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final d a(d param1d) {
/*     */       TimeZone timeZone;
/* 576 */       if (param1d == null || param1d == a || param1d == this) {
/* 577 */         return this;
/*     */       }
/* 579 */       if (this == a) {
/* 580 */         return param1d;
/*     */       }
/*     */       String str1;
/* 583 */       if ((str1 = param1d.b) == null || str1.isEmpty()) {
/* 584 */         str1 = this.b;
/*     */       }
/*     */       l.c c1;
/* 587 */       if ((c1 = param1d.c) == l.c.a) {
/* 588 */         c1 = this.c;
/*     */       }
/*     */       Locale locale;
/* 591 */       if ((locale = param1d.d) == null) {
/* 592 */         locale = this.d;
/*     */       }
/*     */       l.b b1;
/* 595 */       if ((b1 = this.g) == null) {
/* 596 */         b1 = param1d.g;
/*     */       } else {
/* 598 */         b1 = b1.a(param1d.g);
/*     */       } 
/*     */       Boolean bool;
/* 601 */       if ((bool = param1d.f) == null) {
/* 602 */         bool = this.f;
/*     */       }
/*     */ 
/*     */       
/*     */       String str2;
/*     */ 
/*     */       
/* 609 */       if ((str2 = param1d.e) == null || str2.isEmpty()) {
/* 610 */         str2 = this.e;
/* 611 */         timeZone = this.h;
/*     */       } else {
/* 613 */         timeZone = ((d)timeZone).h;
/*     */       } 
/* 615 */       return new d(str1, c1, locale, str2, timeZone, b1, bool);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static d a(boolean param1Boolean) {
/* 636 */       return new d("", null, null, null, null, l.b.a(), 
/* 637 */           Boolean.valueOf(param1Boolean));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final d a(Boolean param1Boolean) {
/* 679 */       if (param1Boolean == this.f) {
/* 680 */         return this;
/*     */       }
/* 682 */       return new d(this.b, this.c, this.d, this.e, this.h, this.g, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String b() {
/* 711 */       return this.b;
/* 712 */     } public final l.c c() { return this.c; } public final Locale d() {
/* 713 */       return this.d;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Boolean e() {
/* 723 */       return this.f;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TimeZone f() {
/*     */       TimeZone timeZone;
/* 756 */       if ((timeZone = this.h) == null) {
/* 757 */         if (this.e == null) {
/* 758 */           return null;
/*     */         }
/* 760 */         timeZone = TimeZone.getTimeZone(this.e);
/* 761 */         this.h = timeZone;
/*     */       } 
/* 763 */       return timeZone;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean g() {
/* 769 */       return (this.c != l.c.a);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean h() {
/* 775 */       return (this.b != null && this.b.length() > 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean i() {
/* 781 */       return (this.d != null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean j() {
/* 787 */       return (this.h != null || (this.e != null && !this.e.isEmpty()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean k() {
/* 798 */       return (this.f != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Boolean a(l.a param1a) {
/* 811 */       return this.g.a(param1a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 825 */       return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", new Object[] { this.b, this.c, this.f, this.d, this.e, this.g });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 831 */       int i = (this.e == null) ? 1 : this.e.hashCode();
/* 832 */       if (this.b != null) {
/* 833 */         i ^= this.b.hashCode();
/*     */       }
/* 835 */       i += this.c.hashCode();
/* 836 */       if (this.f != null) {
/* 837 */         i ^= this.f.hashCode();
/*     */       }
/* 839 */       if (this.d != null) {
/* 840 */         i += this.d.hashCode();
/*     */       }
/*     */       
/* 843 */       return i = i ^ this.g.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 848 */       if (param1Object == this) return true; 
/* 849 */       if (param1Object == null) return false; 
/* 850 */       if (param1Object.getClass() != getClass()) return false; 
/* 851 */       param1Object = param1Object;
/*     */       
/* 853 */       if (this.c != ((d)param1Object).c || 
/* 854 */         !this.g.equals(((d)param1Object).g)) {
/* 855 */         return false;
/*     */       }
/* 857 */       if (a(this.f, ((d)param1Object).f) && 
/* 858 */         a(this.e, ((d)param1Object).e) && 
/* 859 */         a(this.b, ((d)param1Object).b) && 
/* 860 */         a(this.h, ((d)param1Object).h) && 
/* 861 */         a(this.d, ((d)param1Object).d)) return true; 
/*     */       return false;
/*     */     }
/*     */     
/*     */     private static <T> boolean a(T param1T1, T param1T2) {
/* 866 */       if (param1T1 == null) {
/* 867 */         return (param1T2 == null);
/*     */       }
/* 869 */       if (param1T2 == null) {
/* 870 */         return false;
/*     */       }
/* 872 */       return param1T1.equals(param1T2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */