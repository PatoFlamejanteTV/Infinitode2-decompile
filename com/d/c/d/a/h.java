/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.b;
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.c.d.k;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */   extends a
/*     */ {
/*  37 */   private static final a[] a = new a[] { a.J, a.K, a.L, a.M, a.N, a.O };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List a(a parama, List paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     List list;
/*  44 */     if ((list = a(a, paramList, paramInt, paramBoolean1, paramBoolean2)) != null) {
/*  45 */       return list;
/*     */     }
/*     */     
/*  48 */     v v1 = null;
/*  49 */     v v2 = null;
/*  50 */     v v3 = null;
/*  51 */     v v4 = null;
/*  52 */     v v5 = null;
/*  53 */     v v6 = null;
/*     */     
/*  55 */     boolean bool = false;
/*     */     
/*  57 */     ListIterator<j> listIterator = paramList.listIterator();
/*  58 */     while (listIterator.hasNext()) {
/*     */       String str; j j;
/*     */       short s;
/*  61 */       if ((s = (j = listIterator.next()).a()) == 21) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  66 */         str = j.c().toLowerCase();
/*     */         
/*     */         c c;
/*  69 */         if ((c = b((d)(j = new j((short)21, str, str)))) != c.aq) {
/*     */ 
/*     */           
/*  72 */           if (l.g.get(c.a)) {
/*  73 */             if (v1 != null) {
/*  74 */               throw new b("font-style cannot be set twice", -1);
/*     */             }
/*  76 */             v1 = new v(a.J, (d)j, paramBoolean1, paramInt); continue;
/*  77 */           }  if (l.d.get(c.a)) {
/*  78 */             if (v2 != null) {
/*  79 */               throw new b("font-variant cannot be set twice", -1);
/*     */             }
/*  81 */             v2 = new v(a.K, (d)j, paramBoolean1, paramInt); continue;
/*  82 */           }  if (l.h.get(c.a)) {
/*  83 */             if (v3 != null) {
/*  84 */               throw new b("font-weight cannot be set twice", -1);
/*     */             }
/*  86 */             v3 = new v(a.L, (d)j, paramBoolean1, paramInt); continue;
/*     */           } 
/*  88 */           bool = true; break;
/*     */         }  continue;
/*     */       } 
/*  91 */       if (str == '\001' && j.f() > 0.0F) {
/*  92 */         if (v3 != null) {
/*  93 */           throw new b("font-weight cannot be set twice", -1);
/*     */         }
/*     */         
/*     */         c c;
/*  97 */         if ((c = f.a(j.f())) == null) {
/*  98 */           throw new b(j + " is not a valid font weight", -1);
/*     */         }
/*     */         
/*     */         j j1;
/*     */         
/* 103 */         (j1 = new j((short)21, c.toString(), c.toString())).a(c);
/*     */         
/* 105 */         v3 = new v(a.L, (d)j1, paramBoolean1, paramInt); continue;
/*     */       } 
/* 107 */       bool = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 112 */     if (bool) {
/* 113 */       listIterator.previous();
/*     */       
/*     */       j j;
/* 116 */       if ((j = listIterator.next()).a() == 21) {
/* 117 */         String str = j.c().toLowerCase();
/* 118 */         j = new j((short)21, str, str);
/*     */       } 
/*     */       
/*     */       List<v> list1;
/*     */       
/*     */       m m;
/*     */       
/* 125 */       v4 = (list1 = (m = a.e(a.M)).a(a.M, Collections.singletonList(j), paramInt, paramBoolean1)).get(0);
/*     */       
/* 127 */       if (listIterator.hasNext())
/*     */       {
/* 129 */         if ((j = listIterator.next()).j() == k.Q) {
/*     */           m m1;
/*     */ 
/*     */           
/* 133 */           v5 = (list1 = (m1 = a.e(a.N)).a(a.N, Collections.singletonList(j), paramInt, paramBoolean1)).get(0);
/*     */         } else {
/* 135 */           listIterator.previous();
/*     */         } 
/*     */       }
/*     */       
/* 139 */       if (listIterator.hasNext()) {
/* 140 */         ArrayList arrayList1 = new ArrayList();
/* 141 */         while (listIterator.hasNext()) {
/* 142 */           arrayList1.add(listIterator.next());
/*     */         }
/*     */         
/*     */         m m1;
/*     */         
/* 147 */         v6 = (list1 = (m1 = a.e(a.O)).a(a.O, arrayList1, paramInt, paramBoolean1)).get(0);
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     if (v1 == null) {
/* 152 */       v1 = new v(a.J, (d)new j(c.aq), paramBoolean1, paramInt);
/*     */     }
/*     */ 
/*     */     
/* 156 */     if (v2 == null) {
/* 157 */       v2 = new v(a.K, (d)new j(c.aq), paramBoolean1, paramInt);
/*     */     }
/*     */ 
/*     */     
/* 161 */     if (v3 == null) {
/* 162 */       v3 = new v(a.L, (d)new j(c.aq), paramBoolean1, paramInt);
/*     */     }
/*     */ 
/*     */     
/* 166 */     if (v4 == null) {
/* 167 */       throw new b("A font-size value is required", -1);
/*     */     }
/*     */     
/* 170 */     if (v5 == null) {
/* 171 */       v5 = new v(a.N, (d)new j(c.aq), paramBoolean1, paramInt);
/*     */     }
/*     */ 
/*     */     
/*     */     ArrayList<v> arrayList;
/*     */ 
/*     */     
/* 178 */     (arrayList = new ArrayList<>(a.length)).add(v1);
/* 179 */     arrayList.add(v2);
/* 180 */     arrayList.add(v3);
/* 181 */     arrayList.add(v4);
/* 182 */     arrayList.add(v5);
/* 183 */     if (v6 != null) {
/* 184 */       arrayList.add(v6);
/*     */     }
/*     */     
/* 187 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */