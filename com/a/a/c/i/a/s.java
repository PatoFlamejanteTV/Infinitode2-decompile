/*    */ package com.a.a.c.i.a;
/*    */ 
/*    */ import com.a.a.c.d;
/*    */ import com.a.a.c.i.g;
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.l.o;
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
/*    */ public abstract class s
/*    */   implements g
/*    */ {
/*    */   protected final o a;
/*    */   protected final j b;
/*    */   
/*    */   protected s(j paramj, o paramo) {
/* 38 */     this.b = paramj;
/* 39 */     this.a = paramo;
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
/*    */   public final String a() {
/* 53 */     return a(null, this.b.b());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public j a(d paramd, String paramString) {
/* 60 */     throw new IllegalStateException("Sub-class " + getClass().getName() + " MUST implement `typeFromId(DatabindContext,String)");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String b() {
/* 70 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */