/*    */ package com.d.i.a;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class a
/*    */   extends c
/*    */ {
/*    */   private final List<c.a> a;
/*    */   private final int b;
/*    */   
/*    */   public a(int paramInt1, int paramInt2) {
/* 15 */     this.a = new ArrayList<>(paramInt2 + 1);
/* 16 */     this.b = 0;
/*    */     
/* 18 */     for (paramInt1 = 0; paramInt1 < paramInt2 + 1; paramInt1++) {
/* 19 */       this.a.add(new c.a(null));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final c.a a(int paramInt) {
/* 25 */     return this.a.get(paramInt - this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int a() {
/* 30 */     return this.b;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int b() {
/* 35 */     return this.b + this.a.size() - 1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */