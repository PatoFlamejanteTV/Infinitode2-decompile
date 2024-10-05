/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.e.ad;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class g
/*     */   extends a
/*     */ {
/*     */   protected abstract int a();
/*     */   
/*     */   public final List a(com.d.c.a.a parama, List<j> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  42 */     if (paramList.size() == 1) {
/*     */       j j;
/*     */       
/*  45 */       a((d)(j = paramList.get(0)), paramBoolean2);
/*     */       
/*  47 */       if (j.e() == 0)
/*  48 */         return Collections.singletonList(new v(parama, (d)j, paramBoolean1, paramInt)); 
/*  49 */       if (j.a() == 21) {
/*  50 */         if (j.d().equals("none")) {
/*  51 */           return Collections.singletonList(new v(parama, (d)j, paramBoolean1, paramInt));
/*     */         }
/*     */ 
/*     */         
/*  55 */         ad ad = new ad(j.c(), a());
/*     */         
/*  57 */         return Collections.singletonList(new v(parama, (d)new j(
/*     */                 
/*  59 */                 Collections.singletonList(ad), (byte)0), paramBoolean1, paramInt));
/*     */       } 
/*     */ 
/*     */       
/*  63 */       throw new com.d.c.d.b("The syntax of the " + parama + " property is invalid", -1);
/*     */     } 
/*  65 */     ArrayList<ad> arrayList = new ArrayList();
/*  66 */     for (paramBoolean2 = false; paramBoolean2 < paramList.size(); paramBoolean2++) {
/*     */       j j;
/*     */       
/*  69 */       if ((j = paramList.get(paramBoolean2)).a() == 21) {
/*  70 */         String str = j.c();
/*  71 */         int i = a();
/*     */         
/*  73 */         if (paramBoolean2 < paramList.size() - 1) {
/*     */           j j1;
/*  75 */           if ((j1 = paramList.get(paramBoolean2 + 1)).a() == 1) {
/*  76 */             o(parama, (d)j1);
/*     */             
/*  78 */             i = (int)j1.f();
/*     */           } 
/*     */           
/*  81 */           paramBoolean2++;
/*     */         } 
/*  83 */         arrayList.add(new ad(str, i));
/*     */       } else {
/*  85 */         throw new com.d.c.d.b("The syntax of the " + parama + " property is invalid", -1);
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return Collections.singletonList(new v(parama, (d)new j(arrayList, (byte)0), paramBoolean1, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void o(com.d.c.a.a parama, d paramd) {
/*  95 */     if ((int)paramd.b() != 
/*  96 */       Math.round(paramd.b()))
/*  97 */       throw new com.d.c.d.b("The value " + paramd.b() + " in " + parama + " must be an integer", -1); 
/*     */   }
/*     */   
/*     */   public static class b
/*     */     extends g
/*     */   {
/*     */     protected final int a() {
/* 104 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class a extends g {
/*     */     protected final int a() {
/* 110 */       return 1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */