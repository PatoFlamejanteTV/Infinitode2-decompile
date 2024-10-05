/*    */ package com.d.m;
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
/*    */   private static Map e;
/* 40 */   public static final d a = a("HIGH");
/*    */ 
/*    */   
/* 43 */   public static final d b = a("MED");
/*    */ 
/*    */   
/* 46 */   public static final d c = a("LOW");
/*    */ 
/*    */   
/* 49 */   public static final d d = a("AREA");
/*    */ 
/*    */ 
/*    */   
/*    */   private final String f;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static d a(String paramString) {
/* 59 */     b();
/* 60 */     if (e.containsKey(paramString)) {
/* 61 */       throw new RuntimeException("Type strings for DownscaleQuality should be unique; " + paramString + " is declared twice");
/*    */     }
/*    */     
/* 64 */     d d1 = new d(paramString);
/* 65 */     e.put(paramString, d1);
/* 66 */     return d1;
/*    */   }
/*    */   
/*    */   private static void b() {
/* 70 */     if (e == null) e = new HashMap<>(); 
/*    */   }
/*    */   
/*    */   private d(String paramString) {
/* 74 */     this.f = paramString;
/*    */   }
/*    */   
/*    */   public final String a() {
/* 78 */     return this.f;
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
/*    */   public static d a(String paramString, d paramd) {
/*    */     d d1;
/* 91 */     return ((d1 = (d)e.get(paramString)) == null) ? paramd : d1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */