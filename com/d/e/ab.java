/*    */ package com.d.e;
/*    */ 
/*    */ import com.d.c.c.a;
/*    */ import com.d.c.f.c;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ab
/*    */ {
/* 35 */   private List a = new ArrayList();
/*    */   
/*    */   public final void a(a parama) {
/* 38 */     this.a.add(parama);
/*    */   }
/*    */   
/*    */   public final void a() {
/* 42 */     if (this.a.size() != 0) {
/* 43 */       this.a.remove(this.a.size() - 1);
/*    */     }
/*    */   }
/*    */   
/*    */   public final boolean b() {
/* 48 */     return (this.a.size() != 0);
/*    */   }
/*    */   
/*    */   public final void c() {
/* 52 */     this.a.clear();
/*    */   }
/*    */   
/*    */   public final c a(c paramc) {
/* 56 */     paramc = paramc;
/* 57 */     for (Iterator<a> iterator = e().iterator(); iterator.hasNext();) {
/* 58 */       paramc = paramc.a(iterator.next());
/*    */     }
/* 60 */     return paramc;
/*    */   }
/*    */   
/*    */   private List e() {
/* 64 */     return this.a;
/*    */   }
/*    */   
/*    */   public final ab d() {
/*    */     ab ab1;
/* 69 */     (ab1 = new ab()).a.addAll(this.a);
/* 70 */     return ab1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\ab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */