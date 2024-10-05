/*    */ package com.d.m;
/*    */ 
/*    */ import com.d.e.aa;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class i
/*    */ {
/* 11 */   private static final ThreadLocal<a> a = new j();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static a a() {
/* 19 */     return a.get();
/*    */   }
/*    */   
/*    */   public static void b() {
/* 23 */     a.remove();
/*    */   }
/*    */   
/*    */   public static class a
/*    */   {
/*    */     private aa a;
/*    */     
/*    */     public final aa a() {
/* 31 */       if (this.a == null) {
/* 32 */         throw new NullPointerException("SharedContext must be registered in renderer.");
/*    */       }
/* 34 */       return this.a;
/*    */     }
/*    */     private a() {}
/*    */     public final void a(aa param1aa) {
/* 38 */       this.a = param1aa;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */