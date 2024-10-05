/*    */ package com.d.c.e;
/*    */ 
/*    */ import com.d.c.f.c;
/*    */ import com.d.c.f.f;
/*    */ import com.d.h.w;
/*    */ import com.d.i.v;
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
/*    */ public final class a
/*    */   implements e
/*    */ {
/*    */   private int a;
/*    */   private d b;
/*    */   private c c;
/*    */   
/*    */   public a(int paramInt) {
/* 33 */     this.a = paramInt;
/*    */   }
/*    */   
/*    */   public final void a(d paramd) {
/* 37 */     if (this.b != null) {
/* 38 */       throw new w.a("Ruleset can only be set once");
/*    */     }
/* 40 */     this.b = paramd;
/*    */   }
/*    */   
/*    */   public final int a() {
/* 44 */     return this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final c b() {
/* 52 */     if (this.c == null) {
/* 53 */       this.c = (new f()).a(
/* 54 */           com.d.c.c.a.a(this.b.a()));
/*    */     }
/*    */     
/* 57 */     return this.c;
/*    */   }
/*    */   
/*    */   private boolean a(String paramString) {
/* 61 */     return this.b.a().stream().anyMatch(paramv -> paramString.equals(paramv.c()));
/*    */   }
/*    */   
/*    */   public final boolean c() {
/* 65 */     return a("font-family");
/*    */   }
/*    */   
/*    */   public final boolean d() {
/* 69 */     return a("font-weight");
/*    */   }
/*    */   
/*    */   public final boolean e() {
/* 73 */     return a("font-style");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */