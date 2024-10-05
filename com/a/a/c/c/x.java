/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.c.c.a.y;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.o;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class x
/*     */ {
/*     */   public final x a() {
/*  73 */     return this;
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
/*     */   public Class<?> b() {
/*  93 */     return Object.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String c() {
/*     */     Class<?> clazz;
/* 102 */     if ((clazz = b()) == null) {
/* 103 */       return "UNKNOWN";
/*     */     }
/* 105 */     return clazz.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean d() {
/* 114 */     if (l() || 
/* 115 */       m() || n() || 
/* 116 */       o() || e() || 
/* 117 */       f() || g() || 
/* 118 */       i() || k()) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean e() {
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean f() {
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean g() {
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean h() {
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean i() {
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean j() {
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean k() {
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean l() {
/* 172 */     return (r() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean m() {
/* 179 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean n() {
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean o() {
/* 195 */     return false;
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
/*     */   public v[] a(f paramf) {
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j p() {
/* 218 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j q() {
/* 229 */     return null;
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
/*     */   public Object a(g paramg) {
/* 248 */     return paramg.a(b(), this, null, "no default no-arguments constructor found", new Object[0]);
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
/*     */   public Object a(g paramg, Object[] paramArrayOfObject) {
/* 262 */     return paramg.a(b(), this, null, "no creator with arguments specified", new Object[0]);
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
/*     */   public final Object a(g paramg, v[] paramArrayOfv, y paramy) {
/* 288 */     return a(paramg, paramy.a(paramArrayOfv));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(g paramg, Object paramObject) {
/* 296 */     return paramg.a(b(), this, null, "no delegate creator specified", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object b(g paramg, Object paramObject) {
/* 305 */     return paramg.a(b(), this, null, "no array delegate creator specified", new Object[0]);
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
/*     */   public Object a(g paramg, String paramString) {
/* 317 */     return paramg.a(b(), this, paramg.j(), "no String-argument constructor/factory method to deserialize from String value ('%s')", new Object[] { paramString });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(g paramg, int paramInt) {
/* 324 */     return paramg.a(b(), this, null, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", new Object[] {
/*     */           
/* 326 */           Integer.valueOf(paramInt) });
/*     */   }
/*     */   
/*     */   public Object a(g paramg, long paramLong) {
/* 330 */     return paramg.a(b(), this, null, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", new Object[] {
/*     */           
/* 332 */           Long.valueOf(paramLong)
/*     */         });
/*     */   }
/*     */   
/*     */   public Object a(g paramg, BigInteger paramBigInteger) {
/* 337 */     return paramg.a(b(), this, null, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", new Object[] { paramBigInteger });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(g paramg, double paramDouble) {
/* 344 */     return paramg.a(b(), this, null, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", new Object[] {
/*     */           
/* 346 */           Double.valueOf(paramDouble)
/*     */         });
/*     */   }
/*     */   
/*     */   public Object a(g paramg, BigDecimal paramBigDecimal) {
/* 351 */     return paramg.a(b(), this, null, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", new Object[] { paramBigDecimal });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(g paramg, boolean paramBoolean) {
/* 358 */     return paramg.a(b(), this, null, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", new Object[] {
/*     */           
/* 360 */           Boolean.valueOf(paramBoolean)
/*     */         });
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
/*     */   public o r() {
/* 379 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public o s() {
/* 389 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public o t() {
/* 399 */     return null;
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
/*     */   public static class a
/*     */     extends x
/*     */     implements Serializable
/*     */   {
/*     */     private Class<?> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(Class<?> param1Class) {
/* 474 */       this.a = param1Class;
/*     */     }
/*     */     
/*     */     public a(j param1j) {
/* 478 */       this.a = param1j.b();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String c() {
/* 483 */       return this.a.getName();
/*     */     }
/*     */ 
/*     */     
/*     */     public final Class<?> b() {
/* 488 */       return this.a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */