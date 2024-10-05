/*     */ package org.a.c.h.g.e;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.h.a.a;
/*     */ import org.a.c.h.g.b.m;
/*     */ import org.a.c.h.g.b.o;
/*     */ import org.a.c.h.g.b.p;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class e
/*     */   extends p
/*     */ {
/*     */   public e(d paramd) {
/*  68 */     super(paramd);
/*  69 */     i().a(j.bq, (b)j.F);
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
/*     */   e(d paramd, d paramd1, l paraml) {
/*  81 */     super(paramd, paramd1, paraml);
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
/*     */   public final void a(boolean paramBoolean) {
/* 101 */     i().a(j.aV, 65536, true);
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
/*     */   public final void b(boolean paramBoolean) {
/* 121 */     i().a(j.aV, 32768, true);
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
/*     */   public String a() {
/*     */     b b;
/* 135 */     if (b = a(j.dU) instanceof j)
/*     */     {
/* 137 */       return ((j)b).a();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     return "Off";
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
/*     */   public final void a(String paramString) {
/* 158 */     b(paramString);
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 164 */     if (bool = (b().size() > 0) ? true : false) {
/* 165 */       f(paramString);
/*     */     }
/*     */     else {
/*     */       
/* 169 */       e(paramString);
/*     */     } 
/*     */     
/* 172 */     m();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> b() {
/*     */     b b;
/* 236 */     if (b = a(j.cC) instanceof s) {
/*     */       ArrayList<String> arrayList;
/*     */       
/* 239 */       (arrayList = new ArrayList<String>()).add(((s)b).b());
/* 240 */       return arrayList;
/*     */     } 
/* 242 */     if (b instanceof a)
/*     */     {
/* 244 */       return a.d((a)b);
/*     */     }
/* 246 */     return Collections.emptyList();
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
/*     */   public void a(List<String> paramList) {
/* 258 */     if (!paramList.isEmpty()) {
/*     */       
/* 260 */       a a = a.a(paramList);
/* 261 */       i().a(j.cC, (b)a);
/*     */       
/*     */       return;
/*     */     } 
/* 265 */     i().m(j.cC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void c() {
/*     */     List<String> list;
/* 273 */     if ((list = b()).size() > 0) {
/*     */       try {
/*     */         int i;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 280 */         if ((i = Integer.parseInt(a())) < list.size())
/*     */         {
/* 282 */           f(list.get(i)); } 
/*     */         return;
/* 284 */       } catch (NumberFormatException numberFormatException) {
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     e(a());
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
/*     */   private Set<String> d() {
/* 309 */     LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
/*     */     
/* 311 */     if (b().size() > 0) {
/*     */       
/* 313 */       linkedHashSet.addAll(b());
/* 314 */       return linkedHashSet;
/*     */     } 
/*     */     
/*     */     List<m> list;
/* 318 */     for (m m : list = l())
/*     */     {
/* 320 */       linkedHashSet.add(a(m));
/*     */     }
/* 322 */     return linkedHashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String a(int paramInt) {
/* 330 */     List<m> list = l();
/* 331 */     if (paramInt < list.size())
/*     */     {
/* 333 */       return a(list.get(paramInt));
/*     */     }
/* 335 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(m paramm) {
/*     */     o o;
/* 344 */     if ((o = paramm.c()) != null) {
/*     */       p p1;
/*     */       
/* 347 */       if ((p1 = o.b()) != null) {
/*     */         Set<?> set;
/*     */         
/* 350 */         for (j j : set = p1.d().keySet()) {
/*     */           
/* 352 */           if (j.cB.a(j) != 0)
/*     */           {
/* 354 */             return j.a();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 359 */     return "";
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
/*     */   private void b(String paramString) {
/* 371 */     Set<String> set = d();
/* 372 */     if (j.cB.a().compareTo(paramString) != 0 && !set.contains(paramString))
/*     */     {
/* 374 */       throw new IllegalArgumentException("value '" + paramString + "' is not a valid option for the field " + 
/* 375 */           j() + ", valid values are: " + set + " and " + j.cB
/* 376 */           .a());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void e(String paramString) {
/* 382 */     i().a(j.dU, paramString);
/*     */     
/* 384 */     for (Iterator<m> iterator = l().iterator(); iterator.hasNext();) {
/*     */       
/* 386 */       if ((m = iterator.next()).c() != null) {
/*     */         p p1;
/*     */ 
/*     */ 
/*     */         
/* 391 */         if (((d)(p1 = m.c().b()).f()).b(paramString)) {
/*     */           
/* 393 */           m.a(paramString);
/*     */           
/*     */           continue;
/*     */         } 
/* 397 */         m.a(j.cB.a());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void f(String paramString) {
/* 404 */     List<m> list = l();
/* 405 */     List<String> list1 = b();
/*     */     
/* 407 */     if (list.size() != list1.size())
/*     */     {
/* 409 */       throw new IllegalArgumentException("The number of options doesn't match the number of widgets");
/*     */     }
/*     */     
/* 412 */     if (paramString.equals(j.cB.a())) {
/*     */       
/* 414 */       e(paramString);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/* 424 */     if ((i = list1.indexOf(paramString)) != -1)
/*     */     {
/* 426 */       e(a(i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */