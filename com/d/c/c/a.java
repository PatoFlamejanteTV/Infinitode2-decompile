/*     */ package com.d.c.c;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private Map<com.d.c.a.a, v> b;
/*     */   private String c;
/*     */   
/*     */   a(Iterator<v> paramIterator) {
/*  79 */     this();
/*     */     
/*  81 */     a(paramIterator);
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
/*     */   public static a a(v[] paramArrayOfv) {
/*  93 */     return new a(Arrays.<v>asList(paramArrayOfv).iterator());
/*     */   }
/*     */   
/*     */   public static a a(List<v> paramList) {
/*  97 */     return new a(paramList.iterator());
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
/*     */   public static a a(a parama, v[] paramArrayOfv) {
/* 110 */     return new a(parama, Arrays.<v>asList(paramArrayOfv).iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static v a(com.d.c.a.a parama, c paramc) {
/* 120 */     j j = new j(paramc);
/*     */     
/* 122 */     return new v(parama, (d)j, true, 1);
/*     */   }
/*     */   
/*     */   private a(a parama, Iterator<v> paramIterator) {
/* 126 */     this.b = new TreeMap<>(parama.b);
/*     */     
/* 128 */     a(paramIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a() {
/* 137 */     this.b = new TreeMap<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a(c paramc) {
/* 144 */     j j = new j(paramc);
/*     */     
/* 146 */     List<v> list = Collections.singletonList(new v(com.d.c.a.a.G, (d)j, true, 1));
/*     */ 
/*     */     
/* 149 */     return new a(list.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Iterator<v> paramIterator) {
/* 158 */     List[] arrayOfList1 = new List[6];
/*     */     
/* 160 */     while (paramIterator.hasNext()) {
/* 161 */       v v = paramIterator.next();
/*     */       List<v> list;
/* 163 */       if ((list = arrayOfList1[v.b()]) == null) {
/* 164 */         list = new ArrayList();
/* 165 */         arrayOfList1[v.b()] = list;
/*     */       } 
/* 167 */       list.add(v);
/*     */     }  byte b;
/*     */     List[] arrayOfList2;
/* 170 */     for (arrayOfList2 = arrayOfList1, b = 0; b < 6; b++) {
/* 171 */       List list; if ((list = arrayOfList2[b]) != null)
/*     */       {
/* 173 */         for (v v : list) {
/* 174 */           this.b.put(v.d(), v);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 182 */   public static final a a = new a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final v a(com.d.c.a.a parama) {
/* 205 */     return this.b.get(parama);
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
/*     */   public final Collection<v> a() {
/* 230 */     return this.b.values();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/* 236 */     if (this.c == null) {
/* 237 */       StringBuilder stringBuilder = new StringBuilder();
/* 238 */       for (v v : this.b.values()) {
/* 239 */         stringBuilder.append(v.a());
/*     */       }
/* 241 */       this.c = stringBuilder.toString();
/*     */     } 
/* 243 */     return this.c;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */