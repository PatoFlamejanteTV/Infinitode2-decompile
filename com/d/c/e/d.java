/*    */ package com.d.c.e;
/*    */ 
/*    */ import com.d.c.c.f;
/*    */ import com.d.i.v;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
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
/*    */ public final class d
/*    */ {
/*    */   private final int a;
/*    */   private final List<v> b;
/*    */   private final List<f> c;
/*    */   
/*    */   public d(int paramInt) {
/* 39 */     this.a = paramInt;
/* 40 */     this.b = new ArrayList<>();
/* 41 */     this.c = new ArrayList<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final List<v> a() {
/* 51 */     return Collections.unmodifiableList(this.b);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(List<v> paramList) {
/* 59 */     this.b.addAll(paramList);
/*    */   }
/*    */   
/*    */   public final void a(f paramf) {
/* 63 */     this.c.add(paramf);
/*    */   }
/*    */   
/*    */   public final List<f> b() {
/* 67 */     return this.c;
/*    */   }
/*    */   
/*    */   public final int c() {
/* 71 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\e\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */