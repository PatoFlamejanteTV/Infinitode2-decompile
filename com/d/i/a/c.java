/*    */ package com.d.i.a;public abstract class c {
/*    */   public abstract a a(int paramInt);
/*    */   
/*    */   public abstract int a();
/*    */   
/*    */   public abstract int b();
/*    */   
/*    */   public static class a {
/*  9 */     private List<b> a = null;
/* 10 */     private List<a> b = null;
/*    */     private final a c;
/*    */     
/*    */     public a(a param1a) {
/* 14 */       this.c = param1a;
/*    */     }
/*    */     
/*    */     private boolean c() {
/* 18 */       return (this.c != null);
/*    */     }
/*    */     
/*    */     private a d() {
/* 22 */       return this.c;
/*    */     }
/*    */     
/*    */     public final void a(b param1b) {
/* 26 */       if (this.a == null) {
/* 27 */         this.a = new ArrayList<>();
/*    */       }
/* 29 */       this.a.add(param1b);
/*    */     }
/*    */     
/*    */     private void b(int param1Int) {
/* 33 */       for (int i = this.b.size(); i <= param1Int; i++) {
/* 34 */         this.b.add(new a(this));
/*    */       }
/*    */     }
/*    */     
/*    */     public final a a(int param1Int) {
/* 39 */       if (c()) {
/* 40 */         return d().a(param1Int);
/*    */       }
/*    */       
/* 43 */       if (this.b == null) {
/* 44 */         this.b = new ArrayList<>();
/*    */       }
/* 46 */       b(param1Int);
/*    */       
/* 48 */       return this.b.get(param1Int);
/*    */     }
/*    */     
/*    */     public final List<a> a() {
/* 52 */       if (c()) {
/* 53 */         return this.c.a();
/*    */       }
/*    */       
/* 56 */       return (this.b == null) ? Collections.emptyList() : this.b;
/*    */     }
/*    */     
/*    */     public final List<b> b() {
/* 60 */       return (this.a == null) ? Collections.emptyList() : this.a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */