/*    */ package com.a.a.c.c.a;
/*    */ 
/*    */ import com.a.a.c.c.s;
/*    */ import com.a.a.c.g;
/*    */ import java.io.Serializable;
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
/*    */ public final class q
/*    */   implements s, Serializable
/*    */ {
/* 19 */   private static final q a = new q(null);
/*    */   
/* 21 */   private static final q b = new q(null);
/*    */ 
/*    */   
/*    */   private Object c;
/*    */ 
/*    */   
/*    */   private q(Object paramObject) {
/* 28 */     this.c = paramObject;
/* 29 */     if (this.c == null) {
/*    */       return;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static q a() {
/* 40 */     return a;
/*    */   }
/*    */   
/*    */   public static q b() {
/* 44 */     return b;
/*    */   }
/*    */   
/*    */   public static q a(Object paramObject) {
/* 48 */     if (paramObject == null) {
/* 49 */       return b;
/*    */     }
/* 51 */     return new q(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean a(s params) {
/* 60 */     return (params == a);
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
/*    */   public final Object a(g paramg) {
/* 79 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */