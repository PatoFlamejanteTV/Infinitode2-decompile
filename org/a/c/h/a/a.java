/*     */ package org.a.c.h.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.f;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.k;
/*     */ import org.a.c.b.l;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.s;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a<E>
/*     */   implements List<E>
/*     */ {
/*     */   private final org.a.c.b.a a;
/*     */   private final List<E> b;
/*     */   private d c;
/*     */   private j d;
/*     */   
/*     */   public a() {
/*  54 */     this.a = new org.a.c.b.a();
/*  55 */     this.b = new ArrayList<E>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(List<E> paramList, org.a.c.b.a parama) {
/*  66 */     this.b = paramList;
/*  67 */     this.a = parama;
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
/*     */   public a(d paramd, j paramj) {
/*  80 */     this.a = new org.a.c.b.a();
/*  81 */     this.b = new ArrayList<E>();
/*  82 */     this.c = paramd;
/*  83 */     this.d = paramj;
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
/*     */   public a(E paramE, b paramb, d paramd, j paramj) {
/* 103 */     this.a = new org.a.c.b.a();
/* 104 */     this.a.a(paramb);
/* 105 */     this.b = new ArrayList<E>();
/* 106 */     this.b.add(paramE);
/*     */     
/* 108 */     this.c = paramd;
/* 109 */     this.d = paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int size() {
/* 118 */     return this.b.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isEmpty() {
/* 127 */     return this.b.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean contains(Object paramObject) {
/* 136 */     return this.b.contains(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Iterator<E> iterator() {
/* 145 */     return this.b.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object[] toArray() {
/* 154 */     return this.b.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <X> X[] toArray(X[] paramArrayOfX) {
/* 163 */     return this.b.toArray(paramArrayOfX);
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
/*     */   public final boolean add(E paramE) {
/* 175 */     if (this.c != null) {
/*     */       
/* 177 */       this.c.a(this.d, (b)this.a);
/*     */ 
/*     */       
/* 180 */       this.c = null;
/*     */     } 
/*     */     
/* 183 */     if (paramE instanceof String) {
/*     */       
/* 185 */       this.a.a((b)new s((String)paramE));
/*     */ 
/*     */     
/*     */     }
/* 189 */     else if (this.a != null) {
/*     */       
/* 191 */       this.a.a(((c)paramE).f());
/*     */     } 
/*     */     
/* 194 */     return this.b.add(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean remove(Object paramObject) {
/* 203 */     boolean bool = true;
/*     */     int i;
/* 205 */     if ((i = this.b.indexOf(paramObject)) >= 0) {
/*     */       
/* 207 */       this.b.remove(i);
/* 208 */       this.a.d(i);
/*     */     }
/*     */     else {
/*     */       
/* 212 */       bool = false;
/*     */     } 
/* 214 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean containsAll(Collection<?> paramCollection) {
/* 223 */     return this.b.containsAll(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addAll(Collection<? extends E> paramCollection) {
/* 234 */     if (this.c != null && paramCollection.size() > 0) {
/*     */       
/* 236 */       this.c.a(this.d, (b)this.a);
/*     */ 
/*     */       
/* 239 */       this.c = null;
/*     */     } 
/* 241 */     this.a.c(a(paramCollection));
/* 242 */     return this.b.addAll(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/* 253 */     if (this.c != null && paramCollection.size() > 0) {
/*     */       
/* 255 */       this.c.a(this.d, (b)this.a);
/*     */ 
/*     */       
/* 258 */       this.c = null;
/*     */     } 
/*     */     
/* 261 */     this.a.a(paramInt, a(paramCollection));
/* 262 */     return this.b.addAll(paramInt, paramCollection);
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
/*     */   public static List<Integer> a(org.a.c.b.a parama) {
/*     */     a<Integer> a1;
/* 275 */     ArrayList<Integer> arrayList = null;
/* 276 */     if (parama != null) {
/*     */       
/* 278 */       arrayList = new ArrayList();
/* 279 */       for (byte b = 0; b < parama.b(); b++) {
/*     */         l l;
/*     */         
/* 282 */         if (parama.b(b) instanceof m) {
/*     */           
/* 284 */           l = (l)((m)parama.b(b)).a();
/*     */         }
/*     */         else {
/*     */           
/* 288 */           l = (l)parama.b(b);
/*     */         } 
/* 290 */         arrayList.add(Integer.valueOf(l.c()));
/*     */       } 
/* 292 */       a1 = new a<Integer>(arrayList, parama);
/*     */     } 
/* 294 */     return a1;
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
/*     */   public static List<Float> b(org.a.c.b.a parama) {
/*     */     a<Float> a1;
/* 307 */     ArrayList<Float> arrayList = null;
/* 308 */     if (parama != null) {
/*     */       
/* 310 */       arrayList = new ArrayList(parama.b());
/* 311 */       for (byte b = 0; b < parama.b(); b++) {
/*     */         b b1;
/*     */         
/* 314 */         if (b1 = parama.a(b) instanceof l) {
/*     */           
/* 316 */           arrayList.add(Float.valueOf(((l)b1).a()));
/*     */         }
/*     */         else {
/*     */           
/* 320 */           arrayList.add(null);
/*     */         } 
/*     */       } 
/* 323 */       a1 = new a<Float>(arrayList, parama);
/*     */     } 
/* 325 */     return a1;
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
/*     */   public static List<String> c(org.a.c.b.a parama) {
/*     */     a<String> a1;
/* 338 */     ArrayList<String> arrayList = null;
/* 339 */     if (parama != null) {
/*     */       
/* 341 */       arrayList = new ArrayList();
/* 342 */       for (byte b = 0; b < parama.b(); b++)
/*     */       {
/* 344 */         arrayList.add(((j)parama.a(b)).a());
/*     */       }
/* 346 */       a1 = new a<String>(arrayList, parama);
/*     */     } 
/* 348 */     return a1;
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
/*     */   public static List<String> d(org.a.c.b.a parama) {
/*     */     a<String> a1;
/* 361 */     ArrayList<String> arrayList = null;
/* 362 */     if (parama != null) {
/*     */       
/* 364 */       arrayList = new ArrayList();
/* 365 */       for (byte b = 0; b < parama.b(); b++)
/*     */       {
/* 367 */         arrayList.add(((s)parama.a(b)).b());
/*     */       }
/* 369 */       a1 = new a<String>(arrayList, parama);
/*     */     } 
/* 371 */     return a1;
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
/*     */   public static org.a.c.b.a a(List<String> paramList) {
/* 402 */     org.a.c.b.a a1 = new org.a.c.b.a();
/* 403 */     for (String str : paramList)
/*     */     {
/* 405 */       a1.a((b)new s(str));
/*     */     }
/* 407 */     return a1;
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
/*     */   public static org.a.c.b.a b(List<?> paramList) {
/* 421 */     org.a.c.b.a a1 = null;
/* 422 */     if (paramList != null)
/*     */     {
/* 424 */       if (paramList instanceof a) {
/*     */ 
/*     */         
/* 427 */         a1 = ((a)paramList).a;
/*     */       }
/*     */       else {
/*     */         
/* 431 */         a1 = new org.a.c.b.a();
/* 432 */         for (Iterator<?> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*     */           Object object;
/* 434 */           if (object = iterator.next() instanceof String) {
/*     */             
/* 436 */             a1.a((b)new s((String)object)); continue;
/*     */           } 
/* 438 */           if (object instanceof Integer || object instanceof Long) {
/*     */             
/* 440 */             a1.a((b)i.a(((Number)object).longValue())); continue;
/*     */           } 
/* 442 */           if (object instanceof Float || object instanceof Double) {
/*     */             
/* 444 */             a1.a((b)new f(((Number)object).floatValue())); continue;
/*     */           } 
/* 446 */           if (object instanceof c) {
/*     */             
/* 448 */             object = object;
/* 449 */             a1.a(object.f()); continue;
/*     */           } 
/* 451 */           if (object == null) {
/*     */             
/* 453 */             a1.a((b)k.a);
/*     */             
/*     */             continue;
/*     */           } 
/* 457 */           throw new IllegalArgumentException("Error: Don't know how to convert type to COSBase '" + object
/* 458 */               .getClass().getName() + "'");
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 463 */     return a1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<b> a(Collection<?> paramCollection) {
/* 468 */     ArrayList<s> arrayList = new ArrayList();
/* 469 */     for (Iterator<?> iterator = paramCollection.iterator(); iterator.hasNext(); ) {
/*     */       Object object;
/* 471 */       if (object = iterator.next() instanceof String) {
/*     */         
/* 473 */         arrayList.add(new s((String)object));
/*     */         
/*     */         continue;
/*     */       } 
/* 477 */       object = object;
/* 478 */       arrayList.add(object.f());
/*     */     } 
/*     */     
/* 481 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean removeAll(Collection<?> paramCollection) {
/* 490 */     this.a.a(a(paramCollection));
/* 491 */     return this.b.removeAll(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean retainAll(Collection<?> paramCollection) {
/* 500 */     this.a.b(a(paramCollection));
/* 501 */     return this.b.retainAll(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void clear() {
/* 512 */     if (this.c != null)
/*     */     {
/* 514 */       this.c.a(this.d, null);
/*     */     }
/* 516 */     this.b.clear();
/* 517 */     this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 526 */     return this.b.equals(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 535 */     return this.b.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final E get(int paramInt) {
/* 544 */     return this.b.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final E set(int paramInt, E paramE) {
/* 554 */     if (paramE instanceof String) {
/*     */       
/* 556 */       s s = new s((String)paramE);
/* 557 */       if (this.c != null && paramInt == 0)
/*     */       {
/* 559 */         this.c.a(this.d, (b)s);
/*     */       }
/* 561 */       this.a.b(paramInt, (b)s);
/*     */     }
/*     */     else {
/*     */       
/* 565 */       if (this.c != null && paramInt == 0)
/*     */       {
/* 567 */         this.c.a(this.d, ((c)paramE).f());
/*     */       }
/* 569 */       this.a.b(paramInt, ((c)paramE).f());
/*     */     } 
/* 571 */     return this.b.set(paramInt, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void add(int paramInt, E paramE) {
/* 582 */     if (this.c != null) {
/*     */       
/* 584 */       this.c.a(this.d, (b)this.a);
/*     */ 
/*     */       
/* 587 */       this.c = null;
/*     */     } 
/* 589 */     this.b.add(paramInt, paramE);
/* 590 */     if (paramE instanceof String) {
/*     */       
/* 592 */       this.a.a(paramInt, (b)new s((String)paramE));
/*     */       
/*     */       return;
/*     */     } 
/* 596 */     this.a.a(paramInt, ((c)paramE).f());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final E remove(int paramInt) {
/* 606 */     this.a.d(paramInt);
/* 607 */     return this.b.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int indexOf(Object paramObject) {
/* 616 */     return this.b.indexOf(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int lastIndexOf(Object paramObject) {
/* 625 */     return this.b.indexOf(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ListIterator<E> listIterator() {
/* 635 */     return this.b.listIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ListIterator<E> listIterator(int paramInt) {
/* 644 */     return this.b.listIterator(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<E> subList(int paramInt1, int paramInt2) {
/* 653 */     return this.b.subList(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 662 */     return "COSArrayList{" + this.a.toString() + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final org.a.c.b.a a() {
/* 672 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */