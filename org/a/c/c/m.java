/*    */ package org.a.c.c;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.a.c.b.j;
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
/*    */ public final class m
/*    */ {
/* 35 */   public static final m a = new m();
/*    */   
/* 37 */   private final Map<j, l> b = new HashMap<j, l>();
/*    */ 
/*    */   
/*    */   private m() {
/* 41 */     n n = new n();
/* 42 */     i i = new i();
/* 43 */     g g = new g();
/* 44 */     r r = new r();
/* 45 */     d d = new d();
/* 46 */     a a = new a();
/* 47 */     u u = new u();
/* 48 */     h h = new h();
/* 49 */     q q = new q();
/* 50 */     p p = new p();
/*    */     
/* 52 */     this.b.put(j.bc, n);
/* 53 */     this.b.put(j.bd, n);
/* 54 */     this.b.put(j.ao, i);
/* 55 */     this.b.put(j.ap, i);
/* 56 */     this.b.put(j.O, g);
/* 57 */     this.b.put(j.P, g);
/* 58 */     this.b.put(j.ca, r);
/* 59 */     this.b.put(j.cb, r);
/* 60 */     this.b.put(j.n, d);
/* 61 */     this.b.put(j.o, d);
/* 62 */     this.b.put(j.p, a);
/* 63 */     this.b.put(j.q, a);
/* 64 */     this.b.put(j.dl, u);
/* 65 */     this.b.put(j.dm, u);
/* 66 */     this.b.put(j.ak, h);
/* 67 */     this.b.put(j.bN, q);
/* 68 */     this.b.put(j.bL, p);
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
/*    */   public final l a(j paramj) {
/*    */     l l;
/* 91 */     if ((l = this.b.get(paramj)) == null)
/*    */     {
/* 93 */       throw new IOException("Invalid filter: " + paramj);
/*    */     }
/* 95 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */