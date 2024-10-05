/*    */ package com.a.a.b.g;
/*    */ 
/*    */ import java.util.concurrent.ConcurrentHashMap;
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
/*    */ public final class g
/*    */   extends ConcurrentHashMap<String, String>
/*    */ {
/* 28 */   public static final g a = new g();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   private final Object b = new Object();
/*    */   private g() {
/* 37 */     super(180, 0.8F, 4);
/*    */   }
/*    */   public final String a(String paramString) {
/*    */     String str;
/* 41 */     if ((str = get(paramString)) != null) return str;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 48 */     if (size() >= 180)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 53 */       synchronized (this.b) {
/* 54 */         if (size() >= 180) {
/* 55 */           clear();
/*    */         }
/*    */       } 
/*    */     }
/* 59 */     str = paramString.intern();
/* 60 */     put(str, str);
/* 61 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */