/*    */ package com.a.a.b.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class i<F extends h>
/*    */ {
/*    */   private int a;
/*    */   
/*    */   private i(int paramInt) {
/* 23 */     this.a = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <F extends h> i<F> a(F[] paramArrayOfF) {
/* 39 */     if (paramArrayOfF.length > 31) {
/* 40 */       String str = paramArrayOfF[0].getClass().getName();
/* 41 */       throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", new Object[] { str, 
/*    */               
/* 43 */               Integer.valueOf(paramArrayOfF.length) }));
/*    */     } 
/*    */     
/* 46 */     int j = 0; int k; byte b;
/* 47 */     for (k = (paramArrayOfF = paramArrayOfF).length, b = 0; b < k; b++) {
/* 48 */       F f; if ((f = paramArrayOfF[b]).a()) {
/* 49 */         j |= f.b();
/*    */       }
/*    */     } 
/* 52 */     return new i<>(j);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final i<F> a(F paramF) {
/*    */     int j;
/* 70 */     return ((j = this.a | paramF.b()) == this.a) ? this : new i(j);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean b(F paramF) {
/* 95 */     return ((paramF.b() & this.a) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */