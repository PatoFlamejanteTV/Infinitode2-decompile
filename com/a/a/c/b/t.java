/*    */ package com.a.a.c.b;
/*    */ 
/*    */ import com.a.a.c.f.w;
/*    */ import com.a.a.c.k.i;
/*    */ import com.a.a.c.m.e;
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
/*    */ public final class t
/*    */   implements Serializable
/*    */ {
/* 19 */   private static w.a[] a = new w.a[0];
/*    */   
/* 21 */   private static i[] b = new i[0];
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private w.a[] c;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private w.a[] d;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private i[] e;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public t() {
/* 42 */     this(null, null, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private t(w.a[] paramArrayOfa1, w.a[] paramArrayOfa2, i[] paramArrayOfi) {
/* 49 */     this.c = (paramArrayOfa1 == null) ? a : paramArrayOfa1;
/*    */     
/* 51 */     this.d = (paramArrayOfa2 == null) ? a : paramArrayOfa2;
/*    */     
/* 53 */     this.e = (paramArrayOfi == null) ? b : paramArrayOfi;
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
/*    */   public final boolean a() {
/* 84 */     return (this.d.length > 0);
/* 85 */   } public final boolean b() { return (this.e.length > 0); }
/* 86 */   public final Iterable<w.a> c() { return (Iterable<w.a>)new e((Object[])this.c); }
/* 87 */   public final Iterable<w.a> d() { return (Iterable<w.a>)new e((Object[])this.d); } public final Iterable<i> e() {
/* 88 */     return (Iterable<i>)new e((Object[])this.e);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */