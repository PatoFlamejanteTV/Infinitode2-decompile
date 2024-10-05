/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.ab;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */ {
/*     */   private static final HashSet<String> a;
/*     */   
/*     */   static {
/*  29 */     (a = new HashSet<>()).add("java.util.Calendar");
/*  30 */     a.add("java.util.GregorianCalendar");
/*  31 */     a.add("java.util.Date");
/*     */   }
/*     */ 
/*     */   
/*     */   public static k<?> a(Class<?> paramClass, String paramString) {
/*  36 */     if (a.contains(paramString)) {
/*     */       
/*  38 */       if (paramClass == Calendar.class) {
/*  39 */         return new a();
/*     */       }
/*  41 */       if (paramClass == Date.class) {
/*  42 */         return c.a;
/*     */       }
/*  44 */       if (paramClass == GregorianCalendar.class) {
/*  45 */         return new a((Class)GregorianCalendar.class);
/*     */       }
/*     */     } 
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class b<T>
/*     */     extends ai<T>
/*     */     implements k
/*     */   {
/*     */     private DateFormat a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected b(Class<?> param1Class) {
/*  78 */       super(param1Class);
/*  79 */       this.a = null;
/*  80 */       this.b = null;
/*     */     }
/*     */ 
/*     */     
/*     */     protected b(b<T> param1b, DateFormat param1DateFormat, String param1String) {
/*  85 */       super(param1b.s);
/*  86 */       this.a = param1DateFormat;
/*  87 */       this.b = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract b<T> a(DateFormat param1DateFormat, String param1String);
/*     */     
/*     */     public f b() {
/*  94 */       return f.l;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public k<?> a(g param1g, com.a.a.c.c param1c) {
/*     */       l.d d;
/* 105 */       if ((d = a(param1g, param1c, a())) != null) {
/* 106 */         Locale locale; TimeZone timeZone = d.f();
/* 107 */         Boolean bool = d.e();
/*     */ 
/*     */         
/* 110 */         if (d.h()) {
/* 111 */           String str = d.b();
/* 112 */           locale = d.i() ? d.d() : param1g.g();
/* 113 */           SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
/* 114 */           if (timeZone == null) {
/* 115 */             timeZone = param1g.h();
/*     */           }
/* 117 */           simpleDateFormat.setTimeZone(timeZone);
/* 118 */           if (bool != null) {
/* 119 */             simpleDateFormat.setLenient(bool.booleanValue());
/*     */           }
/* 121 */           return a(simpleDateFormat, str);
/*     */         } 
/*     */         
/* 124 */         if (timeZone != null) {
/*     */           ab ab; DateFormat dateFormat1;
/*     */           DateFormat dateFormat2;
/* 127 */           if ((dateFormat2 = param1g.c().s()).getClass() == ab.class) {
/* 128 */             locale = locale.i() ? locale.d() : param1g.g();
/*     */ 
/*     */             
/* 131 */             ab ab1 = (ab1 = (ab1 = (ab)dateFormat2).a(timeZone)).a(locale);
/* 132 */             if (bool != null) {
/* 133 */               ab1 = ab1.a(bool);
/*     */             }
/* 135 */             ab = ab1;
/*     */           }
/*     */           else {
/*     */             
/* 139 */             (dateFormat1 = (DateFormat)ab.clone()).setTimeZone(timeZone);
/* 140 */             if (bool != null) {
/* 141 */               dateFormat1.setLenient(bool.booleanValue());
/*     */             }
/*     */           } 
/* 144 */           return a(dateFormat1, this.b);
/*     */         } 
/*     */         
/* 147 */         if (bool != null) {
/* 148 */           ab ab; DateFormat dateFormat1, dateFormat2 = param1g.c().s();
/* 149 */           String str = this.b;
/*     */           
/* 151 */           if (dateFormat2.getClass() == ab.class) {
/*     */ 
/*     */             
/* 154 */             ab ab1 = (ab1 = (ab)dateFormat2).a(bool);
/* 155 */             str = ab1.a();
/*     */           }
/*     */           else {
/*     */             
/* 159 */             (dateFormat1 = (DateFormat)ab.clone()).setLenient(bool.booleanValue());
/* 160 */             if (dateFormat1 instanceof SimpleDateFormat) {
/* 161 */               ((SimpleDateFormat)dateFormat1).toPattern();
/*     */             }
/*     */           } 
/* 164 */           if (str == null) {
/* 165 */             str = "[unknown]";
/*     */           }
/* 167 */           return a(dateFormat1, str);
/*     */         } 
/*     */       } 
/* 170 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final Date a_(l param1l, g param1g) {
/* 177 */       if (this.a != null && 
/* 178 */         param1l.a(o.h)) {
/*     */         
/* 180 */         if ((null = param1l.w().trim()).isEmpty()) {
/* 181 */           com.a.a.c.b.b b1 = a(param1g, null);
/* 182 */           switch (k.a[b1.ordinal()]) {
/*     */             case 1:
/* 184 */               return new Date(0L);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 189 */           return null;
/*     */         } 
/* 191 */         synchronized (this.a) {
/*     */           
/* 193 */           return this.a.parse(null);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 201 */       return super.a_(param1l, param1g);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.a.a.c.a.a
/*     */   public static class a
/*     */     extends b<Calendar>
/*     */   {
/*     */     private Constructor<Calendar> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a() {
/* 223 */       super(Calendar.class);
/* 224 */       this.a = null;
/*     */     }
/*     */ 
/*     */     
/*     */     public a(Class<? extends Calendar> param1Class) {
/* 229 */       super(param1Class);
/* 230 */       this.a = i.c(param1Class, false);
/*     */     }
/*     */     
/*     */     private a(a param1a, DateFormat param1DateFormat, String param1String) {
/* 234 */       super(param1a, param1DateFormat, param1String);
/* 235 */       this.a = param1a.a;
/*     */     }
/*     */ 
/*     */     
/*     */     private a b(DateFormat param1DateFormat, String param1String) {
/* 240 */       return new a(this, param1DateFormat, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public final Object c(g param1g) {
/*     */       GregorianCalendar gregorianCalendar;
/* 246 */       (gregorianCalendar = new GregorianCalendar()).setTimeInMillis(0L);
/* 247 */       return gregorianCalendar;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private Calendar c(l param1l, g param1g) {
/*     */       Date date;
/* 254 */       if ((date = a_(param1l, param1g)) == null) {
/* 255 */         return null;
/*     */       }
/* 257 */       if (this.a == null) {
/* 258 */         return param1g.a(date);
/*     */       }
/*     */       try {
/*     */         Calendar calendar;
/* 262 */         (calendar = this.a.newInstance(new Object[0])).setTimeInMillis(date.getTime());
/*     */         TimeZone timeZone;
/* 264 */         if ((timeZone = param1g.h()) != null) {
/* 265 */           calendar.setTimeZone(timeZone);
/*     */         }
/* 267 */         return calendar;
/* 268 */       } catch (Exception exception) {
/* 269 */         return (Calendar)param1g.a(a(), date, exception);
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
/*     */   @com.a.a.c.a.a
/*     */   public static class c
/*     */     extends b<Date>
/*     */   {
/* 284 */     public static final c a = new c();
/*     */     public c() {
/* 286 */       super(Date.class);
/*     */     } private c(c param1c, DateFormat param1DateFormat, String param1String) {
/* 288 */       super(param1c, param1DateFormat, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     private c b(DateFormat param1DateFormat, String param1String) {
/* 293 */       return new c(this, param1DateFormat, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public final Object c(g param1g) {
/* 298 */       return new Date(0L);
/*     */     }
/*     */ 
/*     */     
/*     */     private Date c(l param1l, g param1g) {
/* 303 */       return a_(param1l, param1g);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */