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
/*    */ public final class e
/*    */ {
/* 26 */   private static final Map e = new HashMap<>();
/* 27 */   private static int f = 0;
/*    */   
/*    */   private int g;
/*    */   
/*    */   private final String h;
/*    */   
/* 33 */   public static final e a = b("start");
/* 34 */   public static final e b = b("first");
/* 35 */   public static final e c = b("last");
/* 36 */   public static final e d = b("last-except");
/*    */   
/*    */   private e(String paramString) {
/* 39 */     this.h = paramString;
/* 40 */     this.g = f++;
/*    */   }
/*    */   
/*    */   private static final e b(String paramString) {
/* 44 */     e e1 = new e(paramString);
/* 45 */     e.put(paramString, e1);
/* 46 */     return e1;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 50 */     return this.h;
/*    */   }
/*    */   
/*    */   public static e a(String paramString) {
/* 54 */     return (e)e.get(paramString);
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/* 58 */     return this.g;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 62 */     if (paramObject == null || !(paramObject instanceof e)) {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     return (this.g == ((e)paramObject).g);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */