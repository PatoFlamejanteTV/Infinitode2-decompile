/*     */ package org.a.c.h;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */   implements Iterable<e>, c
/*     */ {
/*  42 */   private static final org.a.a.a.a a = c.a(h.class);
/*     */ 
/*     */   
/*     */   private final d b;
/*     */   
/*     */   private final b c;
/*     */ 
/*     */   
/*     */   public h() {
/*  51 */     this.b = new d();
/*  52 */     this.b.a(j.dN, (b)j.cL);
/*  53 */     this.b.a(j.bR, (b)new org.a.c.b.a());
/*  54 */     this.b.a(j.ag, (b)i.a);
/*  55 */     this.c = null;
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
/*     */   h(d paramd, b paramb) {
/*  76 */     if (paramd == null)
/*     */     {
/*  78 */       throw new IllegalArgumentException("page tree root cannot be null");
/*     */     }
/*     */     
/*  81 */     if (j.cK.equals(paramd.b(j.dN))) {
/*     */       org.a.c.b.a a1;
/*     */       
/*  84 */       (a1 = new org.a.c.b.a()).a((b)paramd);
/*  85 */       this.b = new d();
/*  86 */       this.b.a(j.bR, (b)a1);
/*  87 */       this.b.a(j.ag, 1);
/*     */     }
/*     */     else {
/*     */       
/*  91 */       this.b = paramd;
/*     */     } 
/*  93 */     this.c = paramb;
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
/*     */   public static b a(d paramd, j paramj) {
/*     */     b b2;
/* 106 */     if ((b2 = paramd.a(paramj)) != null)
/*     */     {
/* 108 */       return b2;
/*     */     }
/*     */     
/*     */     b b1;
/* 112 */     if (b1 = paramd.a(j.cN, j.cJ) instanceof d) {
/*     */       
/* 114 */       d d1 = (d)b1;
/* 115 */       if (j.cL.equals(d1.a(j.dN)))
/*     */       {
/* 117 */         return a(d1, paramj);
/*     */       }
/*     */     } 
/*     */     
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<e> iterator() {
/* 130 */     return new a(this.b, (byte)0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<d> b(d paramd) {
/* 140 */     ArrayList<d> arrayList = new ArrayList();
/*     */     
/*     */     org.a.c.b.a a1;
/* 143 */     if ((a1 = paramd.f(j.bR)) == null)
/*     */     {
/*     */       
/* 146 */       return arrayList; } 
/*     */     byte b1;
/*     */     int i;
/* 149 */     for (b1 = 0, i = a1.b(); b1 < i; b1++) {
/*     */       b b2;
/*     */       
/* 152 */       if (b2 = a1.a(b1) instanceof d) {
/*     */         
/* 154 */         arrayList.add((d)b2);
/*     */       }
/*     */       else {
/*     */         
/* 158 */         (new StringBuilder("COSDictionary expected, but got "))
/* 159 */           .append((b2 == null) ? "null" : b2.getClass().getSimpleName());
/*     */       } 
/*     */     } 
/*     */     
/* 163 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final class a
/*     */     implements Iterator<e>
/*     */   {
/* 171 */     private final Queue<d> a = new ArrayDeque<d>();
/*     */ 
/*     */     
/*     */     private a(h this$0, d param1d) {
/* 175 */       a(param1d);
/*     */     }
/*     */ 
/*     */     
/*     */     private void a(d param1d) {
/* 180 */       if (h.a(this.b, param1d)) {
/*     */         List<?> list;
/*     */         
/* 183 */         for (d d1 : list = h.b(this.b, param1d))
/*     */         {
/* 185 */           a(d1);
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 190 */       this.a.add(param1d);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean hasNext() {
/* 197 */       return !this.a.isEmpty();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private e a() {
/*     */       d d;
/* 205 */       h.a(d = this.a.poll());
/*     */       
/* 207 */       k k = (h.a(this.b) != null) ? h.a(this.b).j() : null;
/* 208 */       return new e(d, k);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void remove() {
/* 214 */       throw new UnsupportedOperationException();
/*     */     }
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
/*     */   public final e a(int paramInt) {
/*     */     d d1;
/* 229 */     c(d1 = a(paramInt + 1, this.b, 0));
/*     */     
/* 231 */     k k = (this.c != null) ? this.c.j() : null;
/* 232 */     return new e(d1, k);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void c(d paramd) {
/*     */     j j;
/* 238 */     if ((j = paramd.b(j.dN)) == null) {
/*     */       
/* 240 */       paramd.a(j.dN, (b)j.cK);
/*     */       return;
/*     */     } 
/* 243 */     if (!j.cK.equals(j))
/*     */     {
/* 245 */       throw new IllegalStateException("Expected 'Page' but found " + j);
/*     */     }
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
/*     */   private d a(int paramInt1, d paramd, int paramInt2) {
/*     */     Iterator<d> iterator;
/* 259 */     if (paramInt1 < 0)
/*     */     {
/* 261 */       throw new IndexOutOfBoundsException("Index out of bounds: " + paramInt1);
/*     */     }
/*     */     
/* 264 */     if (d(paramd)) {
/*     */       
/* 266 */       int i = paramd.b(j.ag, 0);
/* 267 */       if (paramInt1 <= paramInt2 + i) {
/*     */ 
/*     */         
/* 270 */         for (iterator = b(paramd).iterator(); iterator.hasNext(); ) {
/*     */           d d1;
/*     */           
/* 273 */           if (d(d1 = iterator.next())) {
/*     */             
/* 275 */             int j = d1.b(j.ag, 0);
/* 276 */             if (paramInt1 <= paramInt2 + j)
/*     */             {
/*     */               
/* 279 */               return a(paramInt1, d1, paramInt2);
/*     */             }
/*     */ 
/*     */             
/* 283 */             paramInt2 += j;
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 289 */           paramInt2++;
/* 290 */           if (paramInt1 == paramInt2)
/*     */           {
/*     */             
/* 293 */             return a(paramInt1, d1, paramInt2);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 298 */         throw new IllegalStateException("Index not found: " + paramInt1);
/*     */       } 
/*     */ 
/*     */       
/* 302 */       throw new IndexOutOfBoundsException("Index out of bounds: " + paramInt1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 307 */     if (paramInt2 == paramInt1)
/*     */     {
/* 309 */       return (d)iterator;
/*     */     }
/*     */ 
/*     */     
/* 313 */     throw new IllegalStateException("Index not found: " + paramInt1);
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
/*     */   private static boolean d(d paramd) {
/* 325 */     if (paramd != null && (paramd
/* 326 */       .b(j.dN) == j.cL || paramd.o(j.bR))) return true;
/*     */     
/*     */     return false;
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
/*     */   public final int a() {
/* 390 */     return this.b.b(j.ag, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private d b() {
/* 396 */     return this.b;
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
/*     */   public final void a(e parame) {
/*     */     d d1;
/* 451 */     (d1 = parame.b()).a(j.cN, (b)this.b);
/*     */ 
/*     */     
/*     */     org.a.c.b.a a1;
/*     */ 
/*     */     
/* 457 */     (a1 = (org.a.c.b.a)this.b.a(j.bR)).a((b)d1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 463 */       if ((d1 = (d)d1.a(j.cN, j.cJ)) == null)
/*     */         continue; 
/* 465 */       d1.a(j.ag, d1.j(j.ag) + 1);
/*     */     
/*     */     }
/* 468 */     while (d1 != null);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */