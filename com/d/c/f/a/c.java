/*    */ package com.d.c.f.a;
/*    */ 
/*    */ import com.d.c.a.a;
/*    */ import com.d.c.d.j;
/*    */ import com.d.c.f.e;
/*    */ import com.d.e.ad;
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
/*    */ public final class c
/*    */   extends e
/*    */ {
/*    */   private final List<ad> a;
/*    */   
/*    */   public c(a parama, j paramj) {
/* 34 */     super(parama, paramj.a(), paramj.d(), paramj.d());
/*    */     
/* 36 */     this.a = paramj.m();
/*    */   }
/*    */   
/*    */   public final List<ad> j() {
/* 40 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String[] e() {
/* 45 */     if (this.a == null || this.a.isEmpty()) {
/* 46 */       return com.d.m.c.a;
/*    */     }
/*    */     
/* 49 */     return (String[])this.a.stream().map(Object::toString).toArray(paramInt -> new String[paramInt]);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */