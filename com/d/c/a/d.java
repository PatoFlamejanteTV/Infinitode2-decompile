/*    */ package com.d.c.a;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public final class d
/*    */ {
/* 26 */   private static final Map r = new HashMap<>();
/* 27 */   private static int s = 0;
/*    */   
/*    */   private int t;
/*    */   
/*    */   private final String u;
/*    */   
/*    */   private final c v;
/*    */   private final c w;
/* 35 */   public static final d a = a("top-left-corner", c.aJ, c.al);
/* 36 */   public static final d b = a("top-left", c.aa, c.al);
/* 37 */   public static final d c = a("top-center", c.n, c.al);
/* 38 */   public static final d d = a("top-right", c.aJ, c.al);
/* 39 */   public static final d e = a("top-right-corner", c.aa, c.al);
/* 40 */   public static final d f = a("bottom-left-corner", c.aJ, c.al);
/* 41 */   public static final d g = a("bottom-left", c.aa, c.al);
/* 42 */   public static final d h = a("bottom-center", c.n, c.al);
/* 43 */   public static final d i = a("bottom-right", c.aJ, c.al);
/* 44 */   public static final d j = a("bottom-right-corner", c.aa, c.al);
/* 45 */   public static final d k = a("left-top", c.n, c.bi);
/* 46 */   public static final d l = a("left-middle", c.n, c.al);
/* 47 */   public static final d m = a("left-bottom", c.n, c.l);
/* 48 */   public static final d n = a("right-top", c.n, c.bi);
/* 49 */   public static final d o = a("right-middle", c.n, c.al);
/* 50 */   public static final d p = a("right-bottom", c.n, c.l);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 55 */   public static final d q = a("-fs-pdf-xmp-metadata", c.bi, c.aa);
/*    */   
/*    */   private d(String paramString, c paramc1, c paramc2) {
/* 58 */     this.u = paramString;
/* 59 */     this.v = paramc1;
/* 60 */     this.w = paramc2;
/*    */     
/* 62 */     this.t = s++;
/*    */   }
/*    */   
/*    */   private static final d a(String paramString, c paramc1, c paramc2) {
/* 66 */     d d1 = new d(paramString, paramc1, paramc2);
/* 67 */     r.put(paramString, d1);
/* 68 */     return d1;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 72 */     return this.u;
/*    */   }
/*    */   
/*    */   public static d a(String paramString) {
/* 76 */     return (d)r.get(paramString);
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/* 80 */     return this.t;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 84 */     if (paramObject == null || !(paramObject instanceof d)) {
/* 85 */       return false;
/*    */     }
/*    */     
/* 88 */     return (this.t == ((d)paramObject).t);
/*    */   }
/*    */   
/*    */   public final c a() {
/* 92 */     return this.v;
/*    */   }
/*    */   
/*    */   public final c b() {
/* 96 */     return this.w;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */