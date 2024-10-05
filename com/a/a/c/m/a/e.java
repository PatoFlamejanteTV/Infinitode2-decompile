/*      */ package com.a.a.c.m.a;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Queue;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentLinkedQueue;
/*      */ import java.util.concurrent.ConcurrentMap;
/*      */ import java.util.concurrent.atomic.AtomicLong;
/*      */ import java.util.concurrent.atomic.AtomicLongArray;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ import java.util.concurrent.atomic.AtomicReferenceArray;
/*      */ import java.util.concurrent.locks.Lock;
/*      */ import java.util.concurrent.locks.ReentrantLock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class e<K, V>
/*      */   extends AbstractMap<K, V>
/*      */   implements Serializable, ConcurrentMap<K, V>
/*      */ {
/*  132 */   private static int d = Runtime.getRuntime().availableProcessors();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  144 */   private static int f = (e = Math.min(4, a(d))) - 1;
/*      */   
/*      */   final ConcurrentMap<K, h<K, V>> a;
/*      */   
/*      */   private int g;
/*      */   
/*      */   private long[] h;
/*      */   
/*      */   final b<h<K, V>> b;
/*      */   final AtomicLong c;
/*      */   private AtomicLong i;
/*      */   private Lock j;
/*      */   private Queue<Runnable> k;
/*      */   private AtomicLongArray l;
/*      */   private AtomicLongArray m;
/*      */   private AtomicReferenceArray<h<K, V>> n;
/*      */   private AtomicReference<c> o;
/*      */   private transient Set<K> p;
/*      */   private transient Collection<V> q;
/*      */   private transient Set<Map.Entry<K, V>> r;
/*      */   
/*      */   private static int a(int paramInt) {
/*  166 */     return 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int a(int paramInt1, int paramInt2) {
/*  197 */     return paramInt1 * 16 + paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private e(b<K, V> paramb) {
/*  206 */     this.g = paramb.a;
/*  207 */     this.i = new AtomicLong(Math.min(paramb.c, 9223372034707292160L));
/*  208 */     this.a = new ConcurrentHashMap<>(paramb.b, 0.75F, this.g);
/*      */ 
/*      */     
/*  211 */     this.j = new ReentrantLock();
/*  212 */     this.c = new AtomicLong();
/*  213 */     this.b = new b<>();
/*  214 */     this.k = new ConcurrentLinkedQueue<>();
/*  215 */     this.o = new AtomicReference<>(c.a);
/*      */     
/*  217 */     this.h = new long[e];
/*  218 */     this.l = new AtomicLongArray(e);
/*  219 */     this.m = new AtomicLongArray(e);
/*  220 */     this.n = new AtomicReferenceArray<>(e << 4);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(Object paramObject) {
/*  225 */     if (paramObject == null) {
/*  226 */       throw new NullPointerException();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static void a(boolean paramBoolean) {
/*  232 */     if (!paramBoolean) {
/*  233 */       throw new IllegalArgumentException();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static void b(boolean paramBoolean) {
/*  239 */     if (!paramBoolean) {
/*  240 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean b() {
/*  277 */     return (this.c.get() > this.i.get());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a() {
/*  292 */     while (b()) {
/*      */       h<K, V> h;
/*      */ 
/*      */ 
/*      */       
/*  297 */       if ((h = this.b.a()) == null) {
/*      */         return;
/*      */       }
/*      */       
/*  301 */       this.a.remove(h.a, h);
/*      */       
/*  303 */       b(h);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(h<K, V> paramh) {
/*  313 */     int i = c();
/*  314 */     long l = a(i, paramh);
/*  315 */     a(i, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int c() {
/*  323 */     return (int)Thread.currentThread().getId() & f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long a(int paramInt, h<K, V> paramh) {
/*  337 */     long l = this.l.get(paramInt);
/*  338 */     this.l.lazySet(paramInt, l + 1L);
/*      */     
/*  340 */     int i = (int)(l & 0xFL);
/*  341 */     this.n.lazySet(a(paramInt, i), paramh);
/*      */     
/*  343 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(int paramInt, long paramLong) {
/*      */     long l;
/*  355 */     paramInt = ((l = paramLong - this.m.get(paramInt)) < 4L) ? 1 : 0;
/*      */     c c;
/*  357 */     if ((c = this.o.get()).a(paramInt)) {
/*  358 */       d();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Runnable paramRunnable) {
/*  368 */     this.k.add(paramRunnable);
/*  369 */     this.o.lazySet(c.b);
/*  370 */     d();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d() {
/*  378 */     if (this.j.tryLock()) {
/*      */       try {
/*  380 */         this.o.lazySet(c.c);
/*  381 */         e(); return;
/*      */       } finally {
/*  383 */         this.o.compareAndSet(c.c, c.a);
/*  384 */         this.j.unlock();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void e() {
/*  392 */     f();
/*  393 */     g();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void f() {
/*  400 */     int i, j = (i = (int)Thread.currentThread().getId()) + e;
/*  401 */     for (i = i; i < j; i++) {
/*  402 */       b(i & f);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(int paramInt) {
/*  409 */     long l = this.l.get(paramInt);
/*  410 */     byte b1 = 0;
/*  411 */     int i = (int)(this.h[paramInt] & 0xFL);
/*  412 */     i = a(paramInt, i);
/*      */     h<K, V> h;
/*  414 */     for (; b1 < 8 && (h = this.n.get(i)) != null; b1++) {
/*      */ 
/*      */ 
/*      */       
/*  418 */       this.n.lazySet(i, null);
/*  419 */       a(h);
/*  420 */       this.h[paramInt] = this.h[paramInt] + 1L;
/*      */     } 
/*  422 */     this.m.lazySet(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(h<K, V> paramh) {
/*  432 */     if (this.b.a(paramh)) {
/*  433 */       this.b.b(paramh);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void g() {
/*      */     Runnable runnable;
/*  440 */     for (byte b1 = 0; b1 < 16 && (
/*      */       
/*  442 */       runnable = this.k.poll()) != null; b1++)
/*      */     {
/*      */       
/*  445 */       runnable.run();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(h<K, V> paramh, m<V> paramm) {
/*  458 */     if (paramm.a()) {
/*  459 */       m<V> m1 = new m<>(paramm.b, -paramm.a);
/*  460 */       return paramh.compareAndSet(paramm, m1);
/*      */     } 
/*  462 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void d(h<K, V> paramh) {
/*      */     m<V> m1;
/*      */     m<V> m2;
/*      */     do {
/*  474 */       if (!(m1 = paramh.get()).a()) {
/*      */         return;
/*      */       }
/*  477 */       m2 = new m<>(m1.b, -m1.a);
/*  478 */     } while (!paramh.compareAndSet(m1, m2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void b(h<K, V> paramh) {
/*      */     while (true) {
/*  493 */       m<V> m1 = paramh.get();
/*  494 */       m<V> m2 = new m<>(m1.b, 0);
/*  495 */       if (paramh.compareAndSet(m1, m2)) {
/*  496 */         this.c.lazySet(this.c.get() - Math.abs(m1.a));
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   final class a
/*      */     implements Runnable {
/*      */     private e.h<K, V> a;
/*      */     private int b;
/*      */     
/*      */     a(e this$0, e.h<K, V> param1h, int param1Int) {
/*  508 */       this.b = 1;
/*  509 */       this.a = param1h;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void run() {
/*  515 */       this.c.c.lazySet(this.c.c.get() + this.b);
/*      */ 
/*      */       
/*  518 */       if (this.a.get().a()) {
/*  519 */         this.c.b.c(this.a);
/*  520 */         this.c.a();
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   final class i
/*      */     implements Runnable {
/*      */     private e.h<K, V> a;
/*      */     
/*      */     i(e this$0, e.h<K, V> param1h) {
/*  530 */       this.a = param1h;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void run() {
/*  537 */       this.b.b.d(this.a);
/*  538 */       this.b.b(this.a);
/*      */     }
/*      */   }
/*      */   
/*      */   final class j
/*      */     implements Runnable {
/*      */     private int a;
/*      */     private e.h<K, V> b;
/*      */     
/*      */     j(e this$0, e.h<K, V> param1h, int param1Int) {
/*  548 */       this.a = param1Int;
/*  549 */       this.b = param1h;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void run() {
/*  555 */       this.c.c.lazySet(this.c.c.get() + this.a);
/*  556 */       this.c.a(this.b);
/*  557 */       this.c.a();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isEmpty() {
/*  565 */     return this.a.isEmpty();
/*      */   }
/*      */ 
/*      */   
/*      */   public final int size() {
/*  570 */     return this.a.size();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void clear() {
/*  575 */     this.j.lock();
/*      */     
/*      */     try {
/*      */       h<K, V> h;
/*  579 */       while ((h = this.b.a()) != null) {
/*  580 */         this.a.remove(h.a, h);
/*  581 */         b(h);
/*      */       } 
/*      */ 
/*      */       
/*  585 */       for (byte b1 = 0; b1 < this.n.length(); b1++) {
/*  586 */         this.n.lazySet(b1, null);
/*      */       }
/*      */       
/*      */       Runnable runnable;
/*      */       
/*  591 */       while ((runnable = this.k.poll()) != null)
/*  592 */         runnable.run(); 
/*      */       return;
/*      */     } finally {
/*  595 */       this.j.unlock();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean containsKey(Object paramObject) {
/*  601 */     return this.a.containsKey(paramObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean containsValue(Object paramObject) {
/*  606 */     a(paramObject);
/*      */     
/*  608 */     for (Iterator<h> iterator = this.a.values().iterator(); iterator.hasNext();) {
/*  609 */       if ((h = iterator.next()).c().equals(paramObject)) {
/*  610 */         return true;
/*      */       }
/*      */     } 
/*  613 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final V get(Object paramObject) {
/*  619 */     if ((paramObject = this.a.get(paramObject)) == null) {
/*  620 */       return null;
/*      */     }
/*  622 */     c((h<K, V>)paramObject);
/*  623 */     return (V)paramObject.c();
/*      */   }
/*      */ 
/*      */   
/*      */   public final V put(K paramK, V paramV) {
/*  628 */     return a(paramK, paramV, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public final V putIfAbsent(K paramK, V paramV) {
/*  633 */     return a(paramK, paramV, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private V a(K paramK, V paramV, boolean paramBoolean) {
/*  647 */     a(paramK);
/*  648 */     a(paramV);
/*      */ 
/*      */     
/*  651 */     m<V> m = new m<>(paramV, 1);
/*  652 */     h<K, V> h = new h<>(paramK, m);
/*      */     
/*      */     while (true) {
/*      */       h<K, V> h1;
/*  656 */       if ((h1 = (h)this.a.putIfAbsent(h.a, (h)h)) == null) {
/*  657 */         a(new a(this, h, 1));
/*  658 */         return null;
/*  659 */       }  if (paramBoolean) {
/*  660 */         c(h1);
/*  661 */         return h1.c();
/*      */       } 
/*      */       
/*      */       m<V> m1;
/*  665 */       while ((m1 = h1.get()).a()) {
/*      */ 
/*      */ 
/*      */         
/*  669 */         if (h1.compareAndSet(m1, m)) {
/*      */           int i;
/*  671 */           if ((i = 1 - m1.a) == 0) {
/*  672 */             c(h1);
/*      */           } else {
/*  674 */             a(new j(this, h1, i));
/*      */           } 
/*  676 */           return m1.b;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final V remove(Object paramObject) {
/*  685 */     if ((paramObject = this.a.remove(paramObject)) == null) {
/*  686 */       return null;
/*      */     }
/*      */     
/*  689 */     d((h<K, V>)paramObject);
/*  690 */     a(new i(this, (h<K, V>)paramObject));
/*  691 */     return (V)paramObject.c();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean remove(Object paramObject1, Object paramObject2) {
/*      */     h<K, V> h;
/*  697 */     if ((h = (h)this.a.get(paramObject1)) == null || paramObject2 == null) {
/*  698 */       return false;
/*      */     }
/*      */     
/*  701 */     m<V> m = h.get();
/*      */     
/*  703 */     while (m.a(paramObject2)) {
/*  704 */       if (a(h, m)) {
/*  705 */         if (this.a.remove(paramObject1, h)) {
/*  706 */           a(new i(this, h));
/*  707 */           return true;
/*      */         } 
/*      */         break;
/*      */       } 
/*  711 */       if (!(m = h.get()).a()) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  718 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final V replace(K paramK, V paramV) {
/*  724 */     a(paramK);
/*  725 */     a(paramV);
/*      */ 
/*      */     
/*  728 */     m<V> m = new m<>(paramV, 1);
/*      */     
/*      */     h<K, V> h;
/*  731 */     if ((h = (h)this.a.get(paramK)) == null) {
/*  732 */       return null;
/*      */     }
/*      */     while (true) {
/*      */       m<?> m1;
/*  736 */       if (!(m1 = h.get()).a()) {
/*  737 */         return null;
/*      */       }
/*  739 */       if (h.compareAndSet(m1, m)) {
/*      */         int i;
/*  741 */         if ((i = 1 - m1.a) == 0) {
/*  742 */           c(h);
/*      */         } else {
/*  744 */           a(new j(this, h, i));
/*      */         } 
/*  746 */         return m1.b;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean replace(K paramK, V paramV1, V paramV2) {
/*  753 */     a(paramK);
/*  754 */     a(paramV1);
/*  755 */     a(paramV2);
/*      */ 
/*      */     
/*  758 */     m<V> m = new m<>(paramV2, 1);
/*      */     
/*      */     h<K, V> h;
/*  761 */     if ((h = (h)this.a.get(paramK)) == null) {
/*  762 */       return false;
/*      */     }
/*      */     while (true) {
/*      */       m<?> m1;
/*  766 */       if (!(m1 = h.get()).a() || !m1.a(paramV1)) {
/*  767 */         return false;
/*      */       }
/*  769 */       if (h.compareAndSet(m1, m)) {
/*      */         int i;
/*  771 */         if ((i = 1 - m1.a) == 0) {
/*  772 */           c(h);
/*      */         } else {
/*  774 */           a(new j(this, h, i));
/*      */         } 
/*  776 */         return true;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final Set<K> keySet() {
/*      */     Set<K> set;
/*  784 */     return ((set = this.p) == null) ? (this.p = new g(this)) : set;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Collection<V> values() {
/*      */     Collection<V> collection;
/*  790 */     return ((collection = this.q) == null) ? (this.q = new l(this)) : collection;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Set<Map.Entry<K, V>> entrySet() {
/*      */     Set<Map.Entry<K, V>> set;
/*  796 */     return ((set = this.r) == null) ? (this.r = new e(this)) : set;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   enum c
/*      */   {
/*  803 */     a,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  810 */     b,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  817 */     c;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     abstract boolean a(boolean param1Boolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final class m<V>
/*      */   {
/*      */     final int a;
/*      */ 
/*      */ 
/*      */     
/*      */     final V b;
/*      */ 
/*      */ 
/*      */     
/*      */     m(V param1V, int param1Int) {
/*  839 */       this.a = param1Int;
/*  840 */       this.b = param1V;
/*      */     }
/*      */     
/*      */     final boolean a(Object param1Object) {
/*  844 */       return (param1Object == this.b || this.b.equals(param1Object));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean a() {
/*  851 */       return (this.a > 0);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static final class h<K, V>
/*      */     extends AtomicReference<m<V>>
/*      */     implements a<h<K, V>>
/*      */   {
/*      */     final K a;
/*      */ 
/*      */     
/*      */     private h<K, V> b;
/*      */     
/*      */     private h<K, V> c;
/*      */ 
/*      */     
/*      */     h(K param1K, e.m<V> param1m) {
/*  870 */       super(param1m);
/*  871 */       this.a = param1K;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private h<K, V> d() {
/*  877 */       return this.b;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void a(h<K, V> param1h) {
/*  883 */       this.b = param1h;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private h<K, V> e() {
/*  889 */       return this.c;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void b(h<K, V> param1h) {
/*  895 */       this.c = param1h;
/*      */     }
/*      */ 
/*      */     
/*      */     final V c() {
/*  900 */       return (get()).b;
/*      */     }
/*      */   }
/*      */   
/*      */   final class g
/*      */     extends AbstractSet<K> {
/*  906 */     private e<K, V> a = this.b;
/*      */     g(e this$0) {}
/*      */     
/*      */     public final int size() {
/*  910 */       return this.a.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void clear() {
/*  915 */       this.a.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public final Iterator<K> iterator() {
/*  920 */       return new e.f(this.b);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean contains(Object param1Object) {
/*  925 */       return this.b.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean remove(Object param1Object) {
/*  930 */       return (this.a.remove(param1Object) != null);
/*      */     }
/*      */ 
/*      */     
/*      */     public final Object[] toArray() {
/*  935 */       return this.a.a.keySet().toArray();
/*      */     }
/*      */ 
/*      */     
/*      */     public final <T> T[] toArray(T[] param1ArrayOfT) {
/*  940 */       return (T[])this.a.a.keySet().toArray((Object[])param1ArrayOfT);
/*      */     }
/*      */   }
/*      */   
/*      */   final class f
/*      */     implements Iterator<K> {
/*  946 */     private Iterator<K> a = this.c.a.keySet().iterator(); private K b;
/*      */     
/*      */     f(e this$0) {}
/*      */     
/*      */     public final boolean hasNext() {
/*  951 */       return this.a.hasNext();
/*      */     }
/*      */ 
/*      */     
/*      */     public final K next() {
/*  956 */       this.b = this.a.next();
/*  957 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void remove() {
/*  962 */       e.b((this.b != null));
/*  963 */       this.c.remove(this.b);
/*  964 */       this.b = null;
/*      */     }
/*      */   }
/*      */   
/*      */   final class l
/*      */     extends AbstractCollection<V> {
/*      */     l(e this$0) {}
/*      */     
/*      */     public final int size() {
/*  973 */       return this.a.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void clear() {
/*  978 */       this.a.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public final Iterator<V> iterator() {
/*  983 */       return new e.k(this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean contains(Object param1Object) {
/*  988 */       return this.a.containsValue(param1Object);
/*      */     }
/*      */   }
/*      */   
/*      */   final class k
/*      */     implements Iterator<V> {
/*  994 */     private Iterator<e.h<K, V>> a = this.c.a.values().iterator(); private e.h<K, V> b;
/*      */     
/*      */     k(e this$0) {}
/*      */     
/*      */     public final boolean hasNext() {
/*  999 */       return this.a.hasNext();
/*      */     }
/*      */ 
/*      */     
/*      */     public final V next() {
/* 1004 */       this.b = this.a.next();
/* 1005 */       return this.b.c();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void remove() {
/* 1010 */       e.b((this.b != null));
/* 1011 */       this.c.remove(this.b.a);
/* 1012 */       this.b = null;
/*      */     }
/*      */   }
/*      */   
/*      */   final class e
/*      */     extends AbstractSet<Map.Entry<K, V>> {
/* 1018 */     private e<K, V> a = this.b;
/*      */ 
/*      */     
/*      */     public final int size() {
/* 1022 */       return this.a.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void clear() {
/* 1027 */       this.a.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public final Iterator<Map.Entry<K, V>> iterator() {
/* 1032 */       return new e.d(this.b);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean contains(Object param1Object) {
/* 1037 */       if (!(param1Object instanceof Map.Entry)) {
/* 1038 */         return false;
/*      */       }
/* 1040 */       param1Object = param1Object;
/*      */       e.h h;
/* 1042 */       if ((h = this.a.a.get(param1Object.getKey())) != null && h.c().equals(param1Object.getValue())) return true;  return false;
/*      */     }
/*      */ 
/*      */     
/*      */     private static boolean a() {
/* 1047 */       throw new UnsupportedOperationException("ConcurrentLinkedHashMap does not allow add to be called on entrySet()");
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean remove(Object param1Object) {
/* 1052 */       if (!(param1Object instanceof Map.Entry)) {
/* 1053 */         return false;
/*      */       }
/* 1055 */       param1Object = param1Object;
/* 1056 */       return this.a.remove(param1Object.getKey(), param1Object.getValue());
/*      */     }
/*      */     
/*      */     e(e this$0) {} }
/*      */   
/*      */   final class d implements Iterator<Map.Entry<K, V>> {
/* 1062 */     private Iterator<e.h<K, V>> a = this.c.a.values().iterator();
/*      */     
/*      */     private e.h<K, V> b;
/*      */     
/*      */     public final boolean hasNext() {
/* 1067 */       return this.a.hasNext();
/*      */     }
/*      */ 
/*      */     
/*      */     private Map.Entry<K, V> a() {
/* 1072 */       this.b = this.a.next();
/* 1073 */       return new e.n(this.c, this.b);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void remove() {
/* 1078 */       e.b((this.b != null));
/* 1079 */       this.c.remove(this.b.a);
/* 1080 */       this.b = null;
/*      */     }
/*      */     
/*      */     d(e this$0) {}
/*      */   }
/*      */   
/*      */   final class n
/*      */     extends AbstractMap.SimpleEntry<K, V> {
/*      */     n(e this$0, e.h<K, V> param1h) {
/* 1089 */       super(param1h.a, param1h.c());
/*      */     }
/*      */ 
/*      */     
/*      */     public final V setValue(V param1V) {
/* 1094 */       this.a.put(getKey(), param1V);
/* 1095 */       return super.setValue(param1V);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class b<K, V>
/*      */   {
/* 1166 */     long c = -1L;
/* 1167 */     int b = 16;
/* 1168 */     int a = 16;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final b<K, V> a(int param1Int) {
/* 1181 */       e.a((param1Int >= 0));
/* 1182 */       this.b = param1Int;
/* 1183 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final b<K, V> a(long param1Long) {
/* 1194 */       e.a((param1Long >= 0L));
/* 1195 */       this.c = param1Long;
/* 1196 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final b<K, V> b(int param1Int) {
/* 1210 */       e.a(true);
/* 1211 */       this.a = 4;
/* 1212 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final e<K, V> a() {
/* 1222 */       e.b((this.c >= 0L));
/* 1223 */       return new e<>(this, (byte)0);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */