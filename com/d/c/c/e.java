/*     */ package com.d.c.c;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.a.d;
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class e
/*     */ {
/*     */   private final a a;
/*     */   private final Map<d, List<v>> b;
/*     */   private final List c;
/*     */   
/*     */   public e(List paramList, a parama, Map<d, List<v>> paramMap) {
/*  42 */     this.a = parama;
/*  43 */     this.b = paramMap;
/*     */     
/*  45 */     this.c = paramMap.remove(d.q);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a() {
/*  53 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a(d paramd, boolean paramBoolean) {
/*     */     ArrayList<v> arrayList;
/*     */     List<?> list;
/*  63 */     if (((list = this.b.get(paramd)) == null || list.size() == 0) && !paramBoolean) {
/*  64 */       return null;
/*     */     }
/*     */ 
/*     */     
/*  68 */     if (list != null) {
/*     */       
/*  70 */       (arrayList = new ArrayList(list.size() + 3)).addAll(list);
/*     */     } else {
/*  72 */       arrayList = new ArrayList(3);
/*     */     } 
/*     */     
/*  75 */     arrayList.add(a.a(a.G, c.aX));
/*  76 */     arrayList.add(new v(a.as, (d)new j(paramd
/*     */             
/*  78 */             .b()), false, 0));
/*     */ 
/*     */     
/*  81 */     arrayList.add(new v(a.an, (d)new j(paramd
/*     */             
/*  83 */             .a()), false, 0));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     return new a(arrayList.iterator());
/*     */   } public final boolean a(d[] paramArrayOfd) {
/*     */     int i;
/*     */     byte b;
/*  92 */     for (i = (paramArrayOfd = paramArrayOfd).length, b = 0; b < i; ) { d d1 = paramArrayOfd[b];
/*  93 */       if (this.b.containsKey(d1)) {
/*  94 */         return true;
/*     */       }
/*     */       b++; }
/*     */     
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final List b() {
/* 103 */     return this.c;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\c\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */