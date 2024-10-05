/*    */ package com.a.a.c.f;
/*    */ 
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.l.n;
/*    */ import com.a.a.c.l.o;
/*    */ import java.lang.reflect.Type;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface an
/*    */ {
/*    */   j a(Type paramType);
/*    */   
/*    */   public static class a
/*    */     implements an
/*    */   {
/*    */     private final o a;
/*    */     private final n b;
/*    */     
/*    */     public a(o param1o, n param1n) {
/* 25 */       this.a = param1o;
/* 26 */       this.b = param1n;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final j a(Type param1Type) {
/* 33 */       return this.a.a(param1Type, this.b);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\an.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */