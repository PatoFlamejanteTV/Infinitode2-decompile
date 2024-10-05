/*     */ package com.a.a.c.i;
/*     */ 
/*     */ import com.a.a.a.af;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class e
/*     */ {
/*     */   public abstract e a(c paramc);
/*     */   
/*     */   public abstract af.a a();
/*     */   
/*     */   public abstract String b();
/*     */   
/*     */   public abstract g c();
/*     */   
/*     */   public abstract Class<?> d();
/*     */   
/*     */   public boolean e() {
/*  77 */     return (d() != null);
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
/*     */   public abstract Object a(l paraml, g paramg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Object b(l paraml, g paramg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Object c(l paraml, g paramg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Object d(l paraml, g paramg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object a(l paraml, g paramg, j paramj) {
/* 142 */     return a(paraml, paramj.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object a(l paraml, Class<?> paramClass) {
/*     */     o o;
/* 150 */     if ((o = paraml.k()) == null) {
/* 151 */       return null;
/*     */     }
/* 153 */     switch (f.a[o.ordinal()]) {
/*     */       case 1:
/* 155 */         if (paramClass.isAssignableFrom(String.class)) {
/* 156 */           return paraml.w();
/*     */         }
/*     */         break;
/*     */       case 2:
/* 160 */         if (paramClass.isAssignableFrom(Integer.class)) {
/* 161 */           return Integer.valueOf(paraml.G());
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 166 */         if (paramClass.isAssignableFrom(Double.class)) {
/* 167 */           return Double.valueOf(paraml.K());
/*     */         }
/*     */         break;
/*     */       case 4:
/* 171 */         if (paramClass.isAssignableFrom(Boolean.class)) {
/* 172 */           return Boolean.TRUE;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 176 */         if (paramClass.isAssignableFrom(Boolean.class)) {
/* 177 */           return Boolean.FALSE;
/*     */         }
/*     */         break;
/*     */     } 
/* 181 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */