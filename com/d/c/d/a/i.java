/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.b;
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */   extends a
/*     */ {
/*  34 */   private static final a[] a = new a[] { a.U, a.V, a.W };
/*     */ 
/*     */   
/*     */   public final List a(a parama, List paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     List list;
/*  39 */     if ((list = a(a, paramList, paramInt, paramBoolean1, paramBoolean2)) != null) {
/*  40 */       return list;
/*     */     }
/*     */     
/*  43 */     v v1 = null;
/*  44 */     v v2 = null;
/*  45 */     v v3 = null;
/*     */     
/*  47 */     for (Iterator<j> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*     */       c c; j j;
/*  49 */       a((d)(j = iterator.next()), false);
/*     */       short s;
/*  51 */       if ((s = j.a()) == 21) {
/*     */ 
/*     */         
/*  54 */         if ((c = b((d)j)) == c.ap) {
/*  55 */           if (v1 == null) {
/*  56 */             v1 = new v(a.U, (d)j, paramBoolean1, paramInt);
/*     */           }
/*     */ 
/*     */           
/*  60 */           if (v3 == null)
/*  61 */             v3 = new v(a.W, (d)j, paramBoolean1, paramInt); 
/*     */           continue;
/*     */         } 
/*  64 */         if (l.j.get(c.a)) {
/*  65 */           if (v2 != null) {
/*  66 */             throw new b("A list-style-position value cannot be set twice", -1);
/*     */           }
/*     */           
/*  69 */           v2 = new v(a.V, (d)j, paramBoolean1, paramInt); continue;
/*     */         } 
/*  71 */         if (l.k.get(c.a)) {
/*  72 */           if (v1 != null) {
/*  73 */             throw new b("A list-style-type value cannot be set twice", -1);
/*     */           }
/*     */           
/*  76 */           v1 = new v(a.U, (d)j, paramBoolean1, paramInt);
/*     */         }  continue;
/*     */       } 
/*  79 */       if (c == 20) {
/*  80 */         if (v3 != null) {
/*  81 */           throw new b("A list-style-image value cannot be set twice", -1);
/*     */         }
/*     */         
/*  84 */         v3 = new v(a.W, (d)j, paramBoolean1, paramInt);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  89 */     ArrayList<v> arrayList = new ArrayList(3);
/*  90 */     if (v1 != null) {
/*  91 */       arrayList.add(v1);
/*     */     }
/*  93 */     if (v2 != null) {
/*  94 */       arrayList.add(v2);
/*     */     }
/*  96 */     if (v3 != null) {
/*  97 */       arrayList.add(v3);
/*     */     }
/*     */     
/* 100 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */