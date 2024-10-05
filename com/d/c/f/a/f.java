/*    */ package com.d.c.f.a;
/*    */ 
/*    */ import com.d.c.a.a;
/*    */ import com.d.c.d.j;
/*    */ import com.d.c.f.e;
/*    */ import com.d.m.c;
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
/*    */ public final class f
/*    */   extends e
/*    */ {
/*    */   private final List<j> a;
/*    */   
/*    */   public f(a parama, j paramj) {
/* 33 */     super(parama, paramj.a(), paramj.d(), paramj.d());
/*    */     
/* 35 */     this.a = paramj.l();
/*    */   }
/*    */   
/*    */   public final List<j> j() {
/* 39 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String[] e() {
/* 44 */     if (this.a == null || this.a.isEmpty()) {
/* 45 */       return c.a;
/*    */     }
/*    */     
/* 48 */     return (String[])this.a.stream().map(Object::toString).toArray(paramInt -> new String[paramInt]);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */