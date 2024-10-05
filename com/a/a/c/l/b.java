/*    */ package com.a.a.c.l;
/*    */ 
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
/*    */ public final class b
/*    */   implements Serializable, Comparable<b>
/*    */ {
/*    */   private String a;
/*    */   private Class<?> b;
/*    */   private int c;
/*    */   
/*    */   public b() {
/* 37 */     this.b = null;
/* 38 */     this.a = null;
/* 39 */     this.c = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public b(Class<?> paramClass) {
/* 44 */     this.b = paramClass;
/* 45 */     this.a = paramClass.getName();
/* 46 */     this.c = this.a.hashCode();
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
/*    */   
/*    */   private int a(b paramb) {
/* 66 */     return this.a.compareTo(paramb.a);
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
/*    */   public final boolean equals(Object paramObject) {
/* 78 */     if (paramObject == this) return true; 
/* 79 */     if (paramObject == null) return false; 
/* 80 */     if (paramObject.getClass() != getClass()) return false;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 90 */     return (((b)(paramObject = paramObject)).b == this.b);
/*    */   }
/*    */   public final int hashCode() {
/* 93 */     return this.c;
/*    */   } public final String toString() {
/* 95 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */