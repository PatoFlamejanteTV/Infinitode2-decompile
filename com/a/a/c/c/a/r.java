/*    */ package com.a.a.c.c.a;
/*    */ 
/*    */ import com.a.a.c.c;
/*    */ import com.a.a.c.c.s;
/*    */ import com.a.a.c.d.d;
/*    */ import com.a.a.c.g;
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.w;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class r
/*    */   implements s, Serializable
/*    */ {
/*    */   private w a;
/*    */   private j b;
/*    */   
/*    */   private r(w paramw, j paramj) {
/* 21 */     this.a = paramw;
/* 22 */     this.b = paramj;
/*    */   }
/*    */   
/*    */   public static r a(c paramc) {
/* 26 */     return a(paramc, paramc.c());
/*    */   }
/*    */ 
/*    */   
/*    */   public static r a(c paramc, j paramj) {
/* 31 */     return new r(paramc.b(), paramj);
/*    */   }
/*    */   
/*    */   public static r a(j paramj) {
/* 35 */     return new r(null, paramj);
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
/*    */   public final Object a(g paramg) {
/* 47 */     throw d.a(paramg, this.a, this.b);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */