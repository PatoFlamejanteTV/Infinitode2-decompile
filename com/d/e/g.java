/*    */ package com.d.e;
/*    */ 
/*    */ import com.d.c.f.d;
/*    */ import com.d.d.m;
/*    */ import com.d.i.ab;
/*    */ import java.util.LinkedList;
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
/*    */ public final class g
/*    */ {
/* 30 */   private LinkedList<f> a = new LinkedList<>();
/*    */   
/*    */   private m b;
/*    */   
/*    */   private List c;
/* 35 */   private int d = 0;
/* 36 */   private f e = null;
/*    */   
/*    */   public g(m paramm, List<f> paramList) {
/* 39 */     this.b = paramm;
/* 40 */     this.c = paramList;
/*    */     
/* 42 */     if (paramList.size() > 0) {
/* 43 */       this.e = paramList.get(0);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(ab paramab, int paramInt) {
/* 54 */     while (this.e != null && this.e.b().a() == paramInt) {
/* 55 */       this.e.a(this.b.c());
/* 56 */       this.a.add(this.e);
/*    */       
/* 58 */       this.b.d(this.e.a().k((d)paramab));
/*    */       
/* 60 */       if (this.d == this.c.size() - 1) {
/* 61 */         this.e = null; continue;
/*    */       } 
/* 63 */       this.e = this.c.get(++this.d);
/*    */     } 
/*    */   }
/*    */   
/*    */   public final void a(int paramInt) {
/*    */     f f1;
/* 69 */     while (this.a.size() > 0 && (
/*    */       
/* 71 */       f1 = this.a.getLast()).b().b() == paramInt) {
/* 72 */       this.b.e(f1.c());
/* 73 */       this.a.removeLast();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */