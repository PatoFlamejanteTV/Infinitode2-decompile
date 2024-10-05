/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.b;
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class e
/*     */   extends a
/*     */ {
/*     */   public final List a(a parama, List<j> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  40 */     if (paramList.size() == 1) {
/*     */       j j;
/*  42 */       if ((j = paramList.get(0)).e() == 0)
/*  43 */         return Collections.EMPTY_LIST;  c c;
/*  44 */       if (j.a() == 21 && ((
/*     */         
/*  46 */         c = b((d)j)) == c.ap || c == c.aq)) {
/*  47 */         return Collections.singletonList(new v(a.C, (d)j, paramBoolean1, paramInt));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  53 */     ArrayList<j> arrayList = new ArrayList();
/*  54 */     for (Iterator<j> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*     */       j j;
/*     */       
/*  57 */       if ((j = iterator.next()).j() != null) {
/*  58 */         throw new b("Found unexpected operator, " + j
/*  59 */             .j().b(), -1);
/*     */       }
/*     */       
/*     */       short s;
/*  63 */       if ((s = j.a()) != 20) {
/*     */         
/*  65 */         if (s == 19) {
/*  66 */           arrayList.add(j); continue;
/*  67 */         }  if (j.i() == 7) {
/*  68 */           if (!a(j.n())) {
/*  69 */             throw new b("Function " + j
/*  70 */                 .n().a() + " is not allowed here", -1);
/*     */           }
/*  72 */           arrayList.add(j); continue;
/*  73 */         }  if (s == 21) {
/*     */           c c;
/*  75 */           if ((c = b((d)j)) == c.au || c == c.p || c == c.am || c == c.an) {
/*     */             
/*  77 */             arrayList.add(j); continue;
/*     */           } 
/*  79 */           throw new b("Identifier " + c + " is not a valid value for the content property", -1);
/*     */         } 
/*     */ 
/*     */         
/*  83 */         throw new b(j
/*  84 */             .d() + " is not a value value for the content property", -1);
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     if (arrayList.size() > 0) {
/*  89 */       return Collections.singletonList(new v(a.C, (d)new j(arrayList), paramBoolean1, paramInt));
/*     */     }
/*     */     
/*  92 */     return Collections.EMPTY_LIST;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(com.d.i.e parame) {
/*     */     String str;
/*  98 */     if ((str = parame.a()).equals("attr") || str.equals("counter") || str.equals("counters") || str
/*  99 */       .equals("element") || str.startsWith("-fs") || str.equals("target-counter") || str
/* 100 */       .equals("leader")) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */