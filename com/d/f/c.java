/*    */ package com.d.f;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public final class c
/*    */ {
/* 35 */   private List a = new ArrayList();
/*    */   
/*    */   public final List a() {
/* 38 */     return this.a;
/*    */   }
/*    */   
/*    */   public final void a(int paramInt) {
/* 42 */     while (this.a.size() < paramInt) {
/* 43 */       this.a.add(null);
/*    */     }
/*    */   }
/*    */   
/*    */   public final void b(int paramInt) {
/* 48 */     f f = this.a.get(paramInt);
/* 49 */     this.a.add(paramInt + 1, (f == null) ? null : f.a);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\f\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */