/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.d;
/*     */ import com.a.a.c.f.e;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.b;
/*     */ import com.a.a.c.i.d;
/*     */ import com.a.a.c.j;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class n
/*     */   extends d
/*     */   implements Serializable
/*     */ {
/*     */   private LinkedHashSet<b> a;
/*     */   
/*     */   public final Collection<b> a(q<?> paramq, j paramj, j paramj1) {
/*     */     Class clazz;
/*  85 */     a a = paramq.j();
/*     */ 
/*     */ 
/*     */     
/*  89 */     if (paramj1 != null) {
/*  90 */       clazz = paramj1.b();
/*  91 */     } else if (paramj != null) {
/*  92 */       clazz = paramj.d();
/*     */     } else {
/*  94 */       throw new IllegalArgumentException("Both property and base type are nulls");
/*     */     } 
/*     */     
/*  97 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  99 */     if (this.a != null) {
/* 100 */       for (b b1 : this.a) {
/*     */         
/* 102 */         if (clazz.isAssignableFrom(b1.a())) {
/* 103 */           d d2 = e.a(paramq, b1
/* 104 */               .a());
/* 105 */           a(d2, b1, paramq, a, (HashMap)hashMap);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     List list;
/* 111 */     if (paramj != null && (
/*     */       
/* 113 */       list = a.f((b)paramj)) != null) {
/* 114 */       for (b b1 : list) {
/* 115 */         d d2 = e.a(paramq, b1
/* 116 */             .a());
/* 117 */         a(d2, b1, paramq, a, (HashMap)hashMap);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 122 */     b b = new b(clazz, null);
/* 123 */     d d1 = e.a(paramq, clazz);
/*     */ 
/*     */     
/* 126 */     a(d1, b, paramq, a, (HashMap)hashMap);
/*     */     
/* 128 */     return new ArrayList<>(hashMap.values());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Collection<b> a(q<?> paramq, d paramd) {
/* 135 */     a a = paramq.j();
/* 136 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */     
/* 139 */     if (this.a != null) {
/* 140 */       Class clazz = paramd.d();
/* 141 */       for (b b1 : this.a) {
/*     */         
/* 143 */         if (clazz.isAssignableFrom(b1.a())) {
/* 144 */           d d1 = e.a(paramq, b1
/* 145 */               .a());
/* 146 */           a(d1, b1, paramq, a, (HashMap)hashMap);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     b b = new b(paramd.d(), null);
/* 152 */     a(paramd, b, paramq, a, (HashMap)hashMap);
/* 153 */     return new ArrayList<>(hashMap.values());
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
/*     */   public final Collection<b> b(q<?> paramq, j paramj, j paramj1) {
/* 166 */     a a = paramq.j();
/* 167 */     Class<?> clazz = paramj1.b();
/*     */ 
/*     */     
/* 170 */     HashSet<Class<?>> hashSet = new HashSet();
/* 171 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */ 
/*     */     
/* 174 */     b = new b(clazz, null);
/* 175 */     d d1 = e.a(paramq, clazz);
/*     */     
/* 177 */     a(d1, b, paramq, hashSet, (Map)linkedHashMap);
/*     */     
/*     */     List list;
/* 180 */     if (paramj != null && (
/*     */       
/* 182 */       list = a.f((b)paramj)) != null) {
/* 183 */       for (b b : list) {
/* 184 */         d1 = e.a(paramq, b.a());
/* 185 */         a(d1, b, paramq, hashSet, (Map)linkedHashMap);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 190 */     if (this.a != null) {
/* 191 */       for (b b1 : this.a) {
/*     */         
/* 193 */         if (clazz.isAssignableFrom(b1.a())) {
/* 194 */           d d2 = e.a(paramq, b1
/* 195 */               .a());
/* 196 */           a(d2, b1, paramq, hashSet, (Map)linkedHashMap);
/*     */         } 
/*     */       } 
/*     */     }
/* 200 */     return a(clazz, hashSet, (Map)linkedHashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Collection<b> b(q<?> paramq, d paramd) {
/* 207 */     Class<?> clazz = paramd.d();
/* 208 */     HashSet<Class<?>> hashSet = new HashSet();
/* 209 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */     
/* 211 */     b = new b(clazz, null);
/* 212 */     a(paramd, b, paramq, hashSet, (Map)linkedHashMap);
/*     */     
/* 214 */     if (this.a != null) {
/* 215 */       for (b b : this.a) {
/*     */         
/* 217 */         if (clazz.isAssignableFrom(b.a())) {
/* 218 */           d d1 = e.a(paramq, b
/* 219 */               .a());
/* 220 */           a(d1, b, paramq, hashSet, (Map)linkedHashMap);
/*     */         } 
/*     */       } 
/*     */     }
/* 224 */     return a(clazz, hashSet, (Map)linkedHashMap);
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
/*     */   private void a(d paramd, b paramb, q<?> paramq, a parama, HashMap<b, b> paramHashMap) {
/*     */     b b1;
/*     */     String str;
/* 241 */     if (!paramb.c() && (
/*     */       
/* 243 */       str = parama.d(paramd)) != null) {
/* 244 */       paramb = new b(paramb.a(), str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     b b2 = new b(paramb.a());
/*     */ 
/*     */     
/* 253 */     if (paramHashMap.containsKey(b2)) {
/*     */       
/* 255 */       if (paramb.c() && 
/*     */         
/* 257 */         !(b1 = paramHashMap.get(b2)).c()) {
/* 258 */         paramHashMap.put(b2, paramb);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 264 */     paramHashMap.put(b2, paramb);
/*     */     List list;
/* 266 */     if ((list = parama.f((b)b1)) != null && !list.isEmpty()) {
/* 267 */       for (b paramb : list) {
/* 268 */         d d1 = e.a(paramq, paramb
/* 269 */             .a());
/* 270 */         a(d1, paramb, paramq, parama, paramHashMap);
/*     */       } 
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
/*     */   private void a(d paramd, b paramb, q<?> paramq, Set<Class<?>> paramSet, Map<String, b> paramMap) {
/* 283 */     a a = paramq.j(); String str;
/* 284 */     if (!paramb.c() && (
/*     */       
/* 286 */       str = a.d(paramd)) != null) {
/* 287 */       paramb = new b(paramb.a(), str);
/*     */     }
/*     */     
/* 290 */     if (paramb.c()) {
/* 291 */       paramMap.put(paramb.b(), paramb);
/*     */     }
/*     */     
/*     */     List list;
/* 295 */     if (paramSet.add(paramb.a()) && (
/*     */       
/* 297 */       list = a.f((b)paramd)) != null && !list.isEmpty()) {
/* 298 */       for (b paramb : list) {
/* 299 */         d d1 = e.a(paramq, paramb
/* 300 */             .a());
/* 301 */         a(d1, paramb, paramq, paramSet, paramMap);
/*     */       } 
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
/*     */   private static Collection<b> a(Class<?> paramClass, Set<Class<?>> paramSet, Map<String, b> paramMap) {
/* 314 */     ArrayList<b> arrayList = new ArrayList(paramMap.values());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     for (b b : paramMap.values()) {
/* 320 */       paramSet.remove(b.a());
/*     */     }
/* 322 */     for (Iterator<Class<?>> iterator = paramSet.iterator(); iterator.hasNext();) {
/*     */ 
/*     */       
/* 325 */       if ((clazz = iterator.next()) != paramClass || !Modifier.isAbstract(clazz.getModifiers()))
/*     */       {
/*     */         
/* 328 */         arrayList.add(new b(clazz)); } 
/*     */     } 
/* 330 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */