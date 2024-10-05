/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.k;
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
/*     */ public final class w
/*     */ {
/*  34 */   private static final a a = c.a(w.class);
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
/*     */   public static u a(d paramd, k paramk) {
/*     */     b b;
/*  62 */     j j = paramd.b(j.dN, j.be);
/*  63 */     if (!j.be.equals(j))
/*     */     {
/*  65 */       (new StringBuilder("Expected 'Font' dictionary but found '")).append(j.a()).append("'");
/*     */     }
/*     */     
/*  68 */     j = paramd.b(j.dE);
/*  69 */     if (j.dP.equals(j)) {
/*     */ 
/*     */       
/*  72 */       if (b = paramd.a(j.bg) instanceof d && ((d)b).o(j.bk))
/*     */       {
/*  74 */         return new ad(paramd);
/*     */       }
/*  76 */       return new ae(paramd);
/*     */     } 
/*  78 */     if (j.cm.equals(j)) {
/*     */ 
/*     */       
/*  81 */       if (b = paramd.a(j.bg) instanceof d && ((d)b).o(j.bk))
/*     */       {
/*  83 */         return new ad(paramd);
/*     */       }
/*  85 */       return new x(paramd);
/*     */     } 
/*  87 */     if (j.dK.equals(j))
/*     */     {
/*  89 */       return new ab(paramd);
/*     */     }
/*  91 */     if (j.dQ.equals(j))
/*     */     {
/*  93 */       return new ag(paramd, (k)b);
/*     */     }
/*  95 */     if (j.dO.equals(j))
/*     */     {
/*  97 */       return new ac(paramd);
/*     */     }
/*  99 */     if (j.V.equals(j))
/*     */     {
/* 101 */       throw new IllegalArgumentException("Type 0 descendant font not allowed");
/*     */     }
/* 103 */     if (j.W.equals(j))
/*     */     {
/* 105 */       throw new IllegalArgumentException("Type 2 descendant font not allowed");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     (new StringBuilder("Invalid font subtype '")).append(j).append("'");
/* 112 */     return new ae(paramd);
/*     */   }
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
/*     */   static o a(d paramd, ac paramac) {
/* 126 */     j j1 = paramd.b(j.dN, j.be);
/* 127 */     if (!j.be.equals(j1))
/*     */     {
/* 129 */       throw new IllegalArgumentException("Expected 'Font' dictionary but found '" + j1.a() + "'");
/*     */     }
/*     */     
/* 132 */     j j2 = paramd.b(j.dE);
/* 133 */     if (j.V.equals(j2))
/*     */     {
/* 135 */       return new p(paramd, paramac);
/*     */     }
/* 137 */     if (j.W.equals(j2))
/*     */     {
/* 139 */       return new q(paramd, paramac);
/*     */     }
/*     */ 
/*     */     
/* 143 */     throw new IOException("Invalid font type: " + j1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */