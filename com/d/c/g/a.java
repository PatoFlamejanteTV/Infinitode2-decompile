/*    */ package com.d.c.g;
/*    */ 
/*    */ import com.d.c.a.c;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ public final class a
/*    */ {
/*    */   public float a;
/*    */   public c b;
/*    */   public String[] c;
/*    */   public c d;
/*    */   public c e;
/*    */   
/*    */   public final String toString() {
/*    */     StringBuilder stringBuilder;
/* 17 */     (stringBuilder = new StringBuilder("Font specification: "))
/* 18 */       .append(" families: " + Arrays.<String>asList(this.c).toString())
/* 19 */       .append(" size: " + this.a)
/* 20 */       .append(" weight: " + this.b)
/* 21 */       .append(" style: " + this.d)
/* 22 */       .append(" variant: " + this.e);
/* 23 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */