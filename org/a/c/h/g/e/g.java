/*     */ package org.a.c.h.g.e;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.h.a.a;
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
/*     */ public abstract class g
/*     */   extends r
/*     */ {
/*     */   public g(d paramd) {
/*  55 */     super(paramd);
/*  56 */     i().a(j.bq, (b)j.S);
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
/*     */   g(d paramd, d paramd1, l paraml) {
/*  68 */     super(paramd, paramd1, paraml);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> k() {
/*     */     b b;
/*  91 */     return c.a(b = i().a(j.cC), 0);
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
/*     */   
/*     */   public final void a(List<String> paramList1, List<String> paramList2) {
/* 145 */     if (!paramList1.isEmpty() && !paramList2.isEmpty()) {
/*     */       
/* 147 */       if (paramList1.size() != paramList2.size())
/*     */       {
/* 149 */         throw new IllegalArgumentException("The number of entries for exportValue and displayValue shall be the same.");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 154 */       paramList2 = (List)c.a(paramList1, paramList2);
/*     */       
/* 156 */       if (p())
/*     */       {
/* 158 */         c.a((List)paramList2);
/*     */       }
/*     */       
/* 161 */       a a = new a();
/* 162 */       for (byte b = 0; b < paramList1.size(); b++) {
/*     */         a a1;
/*     */         
/* 165 */         (a1 = new a()).a((b)new s(((c.a)paramList2.get(b)).a()));
/* 166 */         a1.a((b)new s(((c.a)paramList2.get(b)).b()));
/* 167 */         a.a((b)a1);
/*     */       } 
/* 169 */       i().a(j.cC, (b)a);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 174 */     i().m(j.cC);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<String> a() {
/*     */     b b;
/* 193 */     return c.a(b = i().a(j.cC), 1);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<String> b() {
/* 210 */     return k();
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
/*     */ 
/*     */   
/*     */   public final List<Integer> d() {
/*     */     b b;
/* 227 */     if ((b = i().a(j.by)) != null)
/*     */     {
/* 229 */       return a.a((a)b);
/*     */     }
/* 231 */     return Collections.emptyList();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(List<Integer> paramList) {
/* 249 */     if (paramList != null && !paramList.isEmpty()) {
/*     */       
/* 251 */       if (!q())
/*     */       {
/* 253 */         throw new IllegalArgumentException("Setting the indices is not allowed for choice fields not allowing multiple selections.");
/*     */       }
/*     */       
/* 256 */       i().a(j.by, (b)a.b(paramList));
/*     */       
/*     */       return;
/*     */     } 
/* 260 */     i().m(j.by);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean p() {
/* 277 */     return i().c(j.aV, 524288);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean q() {
/* 298 */     return i().c(j.aV, 2097152);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 308 */     i().a(j.aV, 2097152, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 368 */     i().a(j.aV, 131072, true);
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
/*     */   public final void a(String paramString) {
/* 381 */     i().b(j.dU, paramString);
/*     */ 
/*     */     
/* 384 */     a((List<Integer>)null);
/*     */     
/* 386 */     m();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(String paramString) {
/* 397 */     i().b(j.aL, paramString);
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
/*     */   public final List<String> e() {
/* 437 */     return b(j.dU);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> b(j paramj) {
/*     */     b b;
/* 457 */     if (b = i().a(paramj) instanceof s) {
/*     */       ArrayList<String> arrayList;
/*     */       
/* 460 */       (arrayList = new ArrayList<String>()).add(((s)b).b());
/* 461 */       return arrayList;
/*     */     } 
/* 463 */     if (b instanceof a)
/*     */     {
/* 465 */       return a.d((a)b);
/*     */     }
/* 467 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   abstract void c();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */