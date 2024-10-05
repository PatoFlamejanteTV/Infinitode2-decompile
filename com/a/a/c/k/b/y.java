/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.o;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class y
/*     */   extends an<Number>
/*     */   implements k
/*     */ {
/*  32 */   public static final y a = new y(Number.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public y(Class<? extends Number> paramClass) {
/*  45 */     super(paramClass, (byte)0);
/*     */     
/*  47 */     BigInteger.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     l.d d;
/*  55 */     if ((d = a(paramaa, paramc, a())) != null) {
/*  56 */       switch (z.a[d.c().ordinal()]) {
/*     */         
/*     */         case 1:
/*  59 */           if (a() == BigDecimal.class) {
/*  60 */             return d();
/*     */           }
/*  62 */           return as.a;
/*     */       } 
/*     */     
/*     */     }
/*  66 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(Number paramNumber, h paramh) {
/*  73 */     if (paramNumber instanceof BigDecimal) {
/*  74 */       paramh.a((BigDecimal)paramNumber); return;
/*  75 */     }  if (paramNumber instanceof BigInteger) {
/*  76 */       paramh.a((BigInteger)paramNumber);
/*     */       
/*     */       return;
/*     */     } 
/*  80 */     if (paramNumber instanceof Long) {
/*  81 */       paramh.b(paramNumber.longValue()); return;
/*  82 */     }  if (paramNumber instanceof Double) {
/*  83 */       paramh.a(paramNumber.doubleValue()); return;
/*  84 */     }  if (paramNumber instanceof Float) {
/*  85 */       paramh.a(paramNumber.floatValue()); return;
/*  86 */     }  if (paramNumber instanceof Integer || paramNumber instanceof Byte || paramNumber instanceof Short) {
/*  87 */       paramh.c(paramNumber.intValue());
/*     */       return;
/*     */     } 
/*  90 */     paramh.e(paramNumber.toString());
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
/*     */   public static o<?> d() {
/* 118 */     return a.a;
/*     */   }
/*     */   
/*     */   static final class a
/*     */     extends at
/*     */   {
/* 124 */     static final a a = new a();
/*     */     
/*     */     public a() {
/* 127 */       super(BigDecimal.class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean a(aa param1aa, Object param1Object) {
/* 134 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object, h param1h, aa param1aa) {
/* 142 */       if (param1h.b(h.a.h)) {
/*     */ 
/*     */         
/* 145 */         if (!a((BigDecimal)(param1Object = param1Object))) {
/*     */ 
/*     */           
/* 148 */           String str = String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[] {
/*     */                 
/* 150 */                 Integer.valueOf(param1Object.scale()), Integer.valueOf(9999), Integer.valueOf(9999) });
/* 151 */           param1aa.b(str, new Object[0]);
/*     */         } 
/* 153 */         param1Object = param1Object.toPlainString();
/*     */       } else {
/* 155 */         param1Object = param1Object.toString();
/*     */       } 
/* 157 */       param1h.b((String)param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a(Object param1Object) {
/* 163 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean a(BigDecimal param1BigDecimal) {
/*     */       int i;
/* 169 */       if ((i = param1BigDecimal.scale()) >= -9999 && i <= 9999) return true;  return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */