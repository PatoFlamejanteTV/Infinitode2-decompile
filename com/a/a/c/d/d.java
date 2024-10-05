/*    */ package com.a.a.c.d;
/*    */ 
/*    */ import com.a.a.c.g;
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.m.i;
/*    */ import com.a.a.c.w;
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
/*    */   extends f
/*    */ {
/*    */   private d(g paramg, String paramString, w paramw) {
/* 33 */     super(paramg.j(), paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static d a(g paramg, w paramw, j paramj) {
/* 40 */     String str = String.format("Invalid `null` value encountered for property %s", new Object[] {
/* 41 */           i.a(paramw, "<UNKNOWN>") });
/* 42 */     d d1 = new d(paramg, str, paramw);
/* 43 */     if (paramj != null) {
/* 44 */       d1.a(paramj);
/*    */     }
/* 46 */     return d1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\d\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */