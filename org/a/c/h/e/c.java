/*    */ package org.a.c.h.e;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.a.b.c.a;
/*    */ import org.a.b.c.b;
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
/*    */ final class c
/*    */ {
/* 34 */   private static Map<String, a> a = Collections.synchronizedMap(new HashMap<String, a>());
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
/*    */   public static a a(String paramString) {
/*    */     a a2;
/* 50 */     if ((a2 = a.get(paramString)) != null)
/*    */     {
/* 52 */       return a2;
/*    */     }
/*    */     
/*    */     b b;
/* 56 */     a a1 = (b = new b()).a(paramString);
/*    */ 
/*    */     
/* 59 */     a.put(a1.c(), a1);
/* 60 */     return a1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static a a(InputStream paramInputStream) {
/*    */     a a;
/* 71 */     b b = null;
/* 72 */     if (paramInputStream != null)
/*    */     {
/*    */       
/* 75 */       a = (b = new b()).a(paramInputStream);
/*    */     }
/* 77 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */