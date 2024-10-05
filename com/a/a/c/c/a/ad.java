/*    */ package com.a.a.c.c.a;
/*    */ 
/*    */ import com.a.a.b.l;
/*    */ import com.a.a.c.c.v;
/*    */ import com.a.a.c.g;
/*    */ import com.a.a.c.k;
/*    */ import com.a.a.c.m.ac;
/*    */ import com.a.a.c.m.r;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ad
/*    */ {
/*    */   private List<v> a;
/*    */   
/*    */   public ad() {
/* 23 */     this.a = new ArrayList<>();
/*    */   }
/*    */   private ad(List<v> paramList) {
/* 26 */     this.a = paramList;
/*    */   }
/*    */   
/*    */   public final void a(v paramv) {
/* 30 */     this.a.add(paramv);
/*    */   }
/*    */ 
/*    */   
/*    */   public final ad a(r paramr) {
/* 35 */     ArrayList<v> arrayList = new ArrayList(this.a.size());
/* 36 */     for (v v : this.a) {
/* 37 */       String str = paramr.a(v.a());
/*    */       
/*    */       k k;
/* 40 */       if ((k = (v = v.a(str)).p()) != null) {
/*    */         k k1;
/*    */ 
/*    */         
/* 44 */         if ((k1 = k.a(paramr)) != k) {
/* 45 */           v = v.a(k1);
/*    */         }
/*    */       } 
/* 48 */       arrayList.add(v);
/*    */     } 
/* 50 */     return new ad(arrayList);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Object a(g paramg, Object paramObject, ac paramac) {
/*    */     byte b;
/*    */     int i;
/* 58 */     for (b = 0, i = this.a.size(); b < i; b++) {
/* 59 */       v v = this.a.get(b);
/*    */       l l;
/* 61 */       (l = paramac.o()).g();
/* 62 */       v.a(l, paramg, paramObject);
/*    */     } 
/* 64 */     return paramObject;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\ad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */