/*     */ package org.a.c.h.e.a;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */   extends c
/*     */ {
/*     */   private final d c;
/*     */   private final c d;
/*     */   private final Map<Integer, String> e;
/*     */   
/*     */   public b(d paramd) {
/*  37 */     this.e = new HashMap<Integer, String>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     this.c = paramd;
/*  78 */     this.d = null;
/*  79 */     g();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(d paramd, boolean paramBoolean, c paramc) {
/*     */     c c1;
/*     */     this.e = new HashMap<Integer, String>();
/*  91 */     this.c = paramd;
/*     */     
/*  93 */     paramd = null;
/*     */     boolean bool;
/*  95 */     if (bool = this.c.o(j.u)) {
/*     */       j j;
/*     */       
/*  98 */       c1 = c.a(j = this.c.b(j.u));
/*     */     } 
/*     */     
/* 101 */     if (c1 == null)
/*     */     {
/* 103 */       if (paramBoolean) {
/*     */ 
/*     */         
/* 106 */         c1 = h.c;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 111 */       else if (paramc != null) {
/*     */         
/* 113 */         c1 = paramc;
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 119 */         throw new IllegalArgumentException("Symbolic fonts must have a built-in encoding");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 124 */     this.d = c1;
/*     */     
/* 126 */     this.a.putAll(this.d.a);
/* 127 */     this.b.putAll(this.d.b);
/* 128 */     g();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void g() {
/*     */     org.a.c.b.b b1;
/* 135 */     if (!(b1 = this.c.a(j.aE) instanceof a)) {
/*     */       return;
/*     */     }
/*     */     
/* 139 */     a a = (a)b1;
/* 140 */     int i = -1;
/* 141 */     for (byte b2 = 0; b2 < a.b(); b2++) {
/*     */       org.a.c.b.b b3;
/*     */       
/* 144 */       if (b3 = a.a(b2) instanceof l) {
/*     */         
/* 146 */         i = ((l)b3).c();
/*     */       }
/* 148 */       else if (b3 instanceof j) {
/*     */         
/* 150 */         j j = (j)b3;
/* 151 */         b(i, j.a());
/* 152 */         this.e.put(Integer.valueOf(i), j.a());
/* 153 */         i++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c b() {
/* 163 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<Integer, String> c() {
/* 171 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final org.a.c.b.b f() {
/* 177 */     return (org.a.c.b.b)this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 183 */     return this.d.a() + " with differences";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */