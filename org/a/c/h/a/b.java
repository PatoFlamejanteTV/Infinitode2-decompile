/*     */ package org.a.c.h.a;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b<K, V>
/*     */   implements Map<K, V>
/*     */ {
/*     */   private final d a;
/*     */   private final Map<K, V> b;
/*     */   
/*     */   public b(Map<K, V> paramMap, d paramd) {
/*  52 */     this.b = paramMap;
/*  53 */     this.a = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int size() {
/*  63 */     return this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isEmpty() {
/*  72 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean containsKey(Object paramObject) {
/*  81 */     return this.b.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean containsValue(Object paramObject) {
/*  90 */     return this.b.containsValue(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final V get(Object paramObject) {
/*  99 */     return this.b.get(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final V put(K paramK, V paramV) {
/* 108 */     c c = (c)paramV;
/*     */     
/* 110 */     this.a.a(j.a((String)paramK), c.f());
/* 111 */     return this.b.put(paramK, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final V remove(Object paramObject) {
/* 120 */     this.a.m(j.a((String)paramObject));
/* 121 */     return this.b.remove(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void putAll(Map<? extends K, ? extends V> paramMap) {
/* 130 */     throw new RuntimeException("Not yet implemented");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void clear() {
/* 139 */     this.a.b();
/* 140 */     this.b.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Set<K> keySet() {
/* 149 */     return this.b.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Collection<V> values() {
/* 158 */     return this.b.values();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Set<Map.Entry<K, V>> entrySet() {
/* 167 */     return Collections.unmodifiableSet(this.b.entrySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 176 */     boolean bool = false;
/* 177 */     if (paramObject instanceof b)
/*     */     {
/*     */       
/* 180 */       bool = ((b)(paramObject = paramObject)).a.equals(this.a);
/*     */     }
/* 182 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 191 */     return this.b.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 200 */     return this.a.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */