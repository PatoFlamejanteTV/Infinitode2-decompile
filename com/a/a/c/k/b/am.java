/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.k.a.k;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.m;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.y;
/*     */ import com.a.a.c.z;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class am
/*     */ {
/*  20 */   private static o<Object> a = new d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o<Object> a(Class<?> paramClass, boolean paramBoolean) {
/*  38 */     if (paramClass == null || paramClass == Object.class) {
/*  39 */       return new b();
/*     */     }
/*  41 */     if (paramClass == String.class) {
/*  42 */       return a;
/*     */     }
/*  44 */     if (paramClass.isPrimitive()) {
/*  45 */       paramClass = i.i(paramClass);
/*     */     }
/*  47 */     if (paramClass == Integer.class) {
/*  48 */       return new a(5, paramClass);
/*     */     }
/*  50 */     if (paramClass == Long.class) {
/*  51 */       return new a(6, paramClass);
/*     */     }
/*  53 */     if (paramClass.isPrimitive() || Number.class.isAssignableFrom(paramClass))
/*     */     {
/*     */       
/*  56 */       return new a(8, paramClass);
/*     */     }
/*  58 */     if (paramClass == Class.class) {
/*  59 */       return new a(3, paramClass);
/*     */     }
/*  61 */     if (Date.class.isAssignableFrom(paramClass)) {
/*  62 */       return new a(1, paramClass);
/*     */     }
/*  64 */     if (Calendar.class.isAssignableFrom(paramClass)) {
/*  65 */       return new a(2, paramClass);
/*     */     }
/*     */     
/*  68 */     if (paramClass == UUID.class) {
/*  69 */       return new a(8, paramClass);
/*     */     }
/*  71 */     if (paramClass == byte[].class) {
/*  72 */       return new a(7, paramClass);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     return null;
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
/*     */   public static o<Object> a(y paramy, Class<?> paramClass) {
/*  91 */     if (paramClass != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  98 */       if (paramClass == Enum.class) {
/*  99 */         return new b();
/*     */       }
/*     */ 
/*     */       
/* 103 */       if (i.k(paramClass)) {
/* 104 */         return c.a(paramClass, 
/* 105 */             m.a((q)paramy, paramClass));
/*     */       }
/*     */     } 
/*     */     
/* 109 */     return new a(8, paramClass);
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
/*     */   public static class a
/*     */     extends ao<Object>
/*     */   {
/*     */     private int a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(int param1Int, Class<?> param1Class) {
/* 147 */       super(param1Class, (byte)0);
/* 148 */       this.a = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object, h param1h, aa param1aa) {
/* 153 */       switch (this.a) {
/*     */         case 1:
/* 155 */           param1aa.b((Date)param1Object, param1h);
/*     */           return;
/*     */         case 2:
/* 158 */           param1aa.a(((Calendar)param1Object).getTimeInMillis(), param1h);
/*     */           return;
/*     */         case 3:
/* 161 */           param1h.a(((Class)param1Object).getName());
/*     */           return;
/*     */ 
/*     */ 
/*     */         
/*     */         case 4:
/* 167 */           if (param1aa.a(z.m)) {
/* 168 */             param1Object = param1Object.toString();
/*     */           } else {
/* 170 */             param1Object = param1Object;
/*     */             
/* 172 */             if (param1aa.a(z.o)) {
/* 173 */               param1Object = String.valueOf(param1Object.ordinal());
/*     */             } else {
/* 175 */               param1Object = param1Object.name();
/*     */             } 
/*     */           } 
/* 178 */           param1h.a((String)param1Object);
/*     */           return;
/*     */         
/*     */         case 5:
/*     */         case 6:
/* 183 */           param1h.a(((Number)param1Object).longValue());
/*     */           return;
/*     */         
/*     */         case 7:
/* 187 */           param1Object = param1aa.c().v().a((byte[])param1Object);
/* 188 */           param1h.a((String)param1Object);
/*     */           return;
/*     */       } 
/*     */ 
/*     */       
/* 193 */       param1h.a(param1Object.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class b
/*     */     extends ao<Object>
/*     */   {
/*     */     private transient k a;
/*     */ 
/*     */ 
/*     */     
/*     */     public b() {
/* 208 */       super(String.class, (byte)0);
/* 209 */       this.a = k.a();
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
/*     */     public final void a(Object param1Object, h param1h, aa param1aa) {
/* 222 */       Class<?> clazz = param1Object.getClass();
/*     */       k k1;
/*     */       o<Object> o;
/* 225 */       if ((o = (k1 = this.a).a(clazz)) == null) {
/* 226 */         o = a(k1, clazz, param1aa);
/*     */       }
/* 228 */       o.a(param1Object, param1h, param1aa);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private o<Object> a(k param1k, Class<?> param1Class, aa param1aa) {
/*     */       am.a a;
/* 240 */       if (param1Class == Object.class) {
/*     */         
/* 242 */         a = new am.a(8, param1Class);
/* 243 */         this.a = param1k.b(param1Class, a);
/* 244 */         return a;
/*     */       } 
/*     */ 
/*     */       
/* 248 */       k.d d = param1k.c(param1Class, (aa)a, null);
/*     */       
/* 250 */       if (param1k != d.b) {
/* 251 */         this.a = d.b;
/*     */       }
/* 253 */       return d.a;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class d
/*     */     extends ao<Object>
/*     */   {
/*     */     public d() {
/* 262 */       super(String.class, (byte)0);
/*     */     }
/*     */     
/*     */     public final void a(Object param1Object, h param1h, aa param1aa) {
/* 266 */       param1h.a((String)param1Object);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class c
/*     */     extends ao<Object>
/*     */   {
/*     */     private m a;
/*     */ 
/*     */ 
/*     */     
/*     */     private c(Class<?> param1Class, m param1m) {
/* 280 */       super(param1Class, (byte)0);
/* 281 */       this.a = param1m;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static c a(Class<?> param1Class, m param1m) {
/* 287 */       return new c(param1Class, param1m);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object, h param1h, aa param1aa) {
/* 294 */       if (param1aa.a(z.m)) {
/* 295 */         param1h.a(param1Object.toString());
/*     */         return;
/*     */       } 
/* 298 */       param1Object = param1Object;
/*     */       
/* 300 */       if (param1aa.a(z.o)) {
/* 301 */         param1h.a(String.valueOf(param1Object.ordinal()));
/*     */         return;
/*     */       } 
/* 304 */       param1h.b(this.a.a((Enum)param1Object));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\am.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */