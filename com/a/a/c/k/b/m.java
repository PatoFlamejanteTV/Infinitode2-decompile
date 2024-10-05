/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.m.ab;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class m<T>
/*     */   extends an<T>
/*     */   implements k
/*     */ {
/*     */   private Boolean a;
/*     */   private DateFormat b;
/*     */   private AtomicReference<DateFormat> c;
/*     */   
/*     */   protected m(Class<T> paramClass, Boolean paramBoolean, DateFormat paramDateFormat) {
/*  53 */     super(paramClass);
/*  54 */     this.a = paramBoolean;
/*  55 */     this.b = paramDateFormat;
/*  56 */     this.c = (paramDateFormat == null) ? null : new AtomicReference<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract m<T> a(Boolean paramBoolean, DateFormat paramDateFormat);
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     ab ab;
/*     */     TimeZone timeZone2;
/*     */     l.d d;
/*  68 */     if ((d = a(paramaa, paramc, a())) == null) {
/*  69 */       return this;
/*     */     }
/*     */     
/*     */     l.c c1;
/*  73 */     if ((c1 = d.c()).a()) {
/*  74 */       return a(Boolean.TRUE, (DateFormat)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  79 */     if (d.h()) {
/*     */ 
/*     */       
/*  82 */       Locale locale = d.i() ? d.d() : paramaa.g();
/*  83 */       SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(d.b(), locale);
/*     */       
/*  85 */       timeZone2 = d.j() ? d.f() : paramaa.h();
/*  86 */       simpleDateFormat1.setTimeZone(timeZone2);
/*  87 */       return a(Boolean.FALSE, simpleDateFormat1);
/*     */     } 
/*     */ 
/*     */     
/*  91 */     boolean bool3 = d.i();
/*  92 */     boolean bool4 = d.j();
/*  93 */     boolean bool2 = (timeZone2 == l.c.h) ? true : false;
/*     */     
/*  95 */     if (!bool3 && !bool4 && !bool2) {
/*  96 */       return this;
/*     */     }
/*     */     
/*     */     DateFormat dateFormat;
/*     */     
/* 101 */     if (dateFormat = paramaa.c().s() instanceof ab) {
/* 102 */       ab = (ab)dateFormat;
/* 103 */       if (d.i()) {
/* 104 */         ab = ab.a(d.d());
/*     */       }
/* 106 */       if (d.j()) {
/* 107 */         ab = ab.a(d.f());
/*     */       }
/* 109 */       return a(Boolean.FALSE, (DateFormat)ab);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (!(dateFormat instanceof SimpleDateFormat)) {
/* 116 */       ab.a(a(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", new Object[] { dateFormat
/*     */               
/* 118 */               .getClass().getName() }));
/*     */     }
/* 120 */     SimpleDateFormat simpleDateFormat = (SimpleDateFormat)dateFormat;
/* 121 */     if (bool3) {
/*     */       
/* 123 */       simpleDateFormat = new SimpleDateFormat(simpleDateFormat.toPattern(), d.d());
/*     */     } else {
/* 125 */       simpleDateFormat = (SimpleDateFormat)simpleDateFormat.clone();
/*     */     } 
/*     */     TimeZone timeZone1;
/*     */     boolean bool1;
/* 129 */     if (bool1 = ((timeZone1 = d.f()) != null && !timeZone1.equals(simpleDateFormat.getTimeZone())) ? true : false) {
/* 130 */       simpleDateFormat.setTimeZone(timeZone1);
/*     */     }
/* 132 */     return a(Boolean.FALSE, simpleDateFormat);
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
/*     */   public final boolean a(aa paramaa, T paramT) {
/* 146 */     return false;
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
/*     */   protected final boolean a(aa paramaa) {
/* 181 */     if (this.a != null) {
/* 182 */       return this.a.booleanValue();
/*     */     }
/* 184 */     if (this.b == null) {
/* 185 */       if (paramaa != null) {
/* 186 */         return paramaa.a(z.j);
/*     */       }
/*     */       
/* 189 */       throw new IllegalArgumentException("Null SerializerProvider passed for " + a().getName());
/*     */     } 
/* 191 */     return false;
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
/*     */   protected final void a(Date paramDate, h paramh, aa paramaa) {
/* 210 */     if (this.b == null) {
/* 211 */       paramaa.a(paramDate, paramh);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     DateFormat dateFormat;
/*     */ 
/*     */     
/* 223 */     if ((dateFormat = this.c.getAndSet(null)) == null) {
/* 224 */       dateFormat = (DateFormat)this.b.clone();
/*     */     }
/* 226 */     paramh.b(dateFormat.format(paramDate));
/* 227 */     this.c.compareAndSet(null, dateFormat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */