/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.a.af;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.b;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.i.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.ac;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.q;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   extends g
/*     */ {
/*  36 */   private static final BitSet g = new BitSet(0);
/*     */ 
/*     */   
/*     */   private final Map<String, Integer> h;
/*     */ 
/*     */   
/*     */   private final Map<BitSet, String> i;
/*     */ 
/*     */   
/*     */   public c(j paramj1, g paramg, j paramj2, f paramf, Collection<b> paramCollection) {
/*  46 */     super(paramj1, paramg, (String)null, false, paramj2, (af.a)null);
/*  47 */     this.h = new HashMap<>();
/*  48 */     this.i = a(paramf, paramCollection);
/*     */   }
/*     */   
/*     */   private c(c paramc, com.a.a.c.c paramc1) {
/*  52 */     super(paramc, paramc1);
/*  53 */     this.h = paramc.h;
/*  54 */     this.i = paramc.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final e a(com.a.a.c.c paramc) {
/*  59 */     return (paramc == this.c) ? this : new c(this, paramc);
/*     */   }
/*     */   
/*     */   private Map<BitSet, String> a(f paramf, Collection<b> paramCollection) {
/*  63 */     boolean bool = paramf.a(q.v);
/*     */     
/*  65 */     byte b = 0;
/*  66 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  68 */     for (b b1 : paramCollection) {
/*  69 */       j j = paramf.p().a(b1.a());
/*  70 */       List list = paramf.a(j).h();
/*     */       
/*  72 */       BitSet bitSet = new BitSet(b + list.size());
/*  73 */       for (Iterator<s> iterator = list.iterator(); iterator.hasNext(); ) {
/*  74 */         s s; String str1 = (s = iterator.next()).a();
/*  75 */         if (bool) str1 = str1.toLowerCase(); 
/*     */         Integer integer;
/*  77 */         if ((integer = this.h.get(str1)) == null) {
/*  78 */           integer = Integer.valueOf(b);
/*  79 */           this.h.put(str1, Integer.valueOf(b++));
/*     */         } 
/*  81 */         bitSet.set(integer.intValue());
/*     */       } 
/*     */ 
/*     */       
/*     */       String str;
/*     */       
/*  87 */       if ((str = (String)hashMap.put(bitSet, b1.a().getName())) != null) {
/*  88 */         throw new IllegalStateException(
/*  89 */             String.format("Subtypes %s and %s have the same signature and cannot be uniquely deduced.", new Object[] { str, b1.a().getName() }));
/*     */       }
/*     */     } 
/*     */     
/*  93 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/*     */     o o;
/* 100 */     if ((o = paraml.k()) == o.b) {
/* 101 */       o = paraml.g();
/* 102 */     } else if (o != o.f) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 110 */       return b(paraml, paramg, (ac)null, "Unexpected input");
/*     */     } 
/*     */     
/*     */     String str2;
/* 114 */     if (o == o.c && (
/*     */       
/* 116 */       str2 = this.i.get(g)) != null) {
/* 117 */       return a(paraml, paramg, (ac)null, str2);
/*     */     }
/*     */ 
/*     */     
/* 121 */     LinkedList<BitSet> linkedList = new LinkedList(this.i.keySet());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     ac ac = paramg.a(paraml);
/* 127 */     boolean bool = paramg.a(q.v);
/*     */     
/* 129 */     for (; o == o.f; o1 = paraml.g()) {
/* 130 */       o o1; String str = paraml.v();
/* 131 */       if (bool) str = str.toLowerCase();
/*     */       
/* 133 */       ac.b(paraml);
/*     */       
/*     */       Integer integer;
/* 136 */       if ((integer = this.h.get(str)) != null) {
/*     */         
/* 138 */         a(linkedList, integer.intValue());
/* 139 */         if (linkedList.size() == 1) {
/* 140 */           return a(paraml, paramg, ac, this.i.get(linkedList.get(0)));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 146 */     String str1 = String.format("Cannot deduce unique subtype of %s (%d candidates match)", new Object[] { i.b(this.b), Integer.valueOf(linkedList.size()) });
/* 147 */     return b(paraml, paramg, ac, str1);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(List<BitSet> paramList, int paramInt) {
/* 152 */     for (Iterator<BitSet> iterator = paramList.iterator(); iterator.hasNext();) {
/* 153 */       if (!((BitSet)iterator.next()).get(paramInt))
/* 154 */         iterator.remove(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */