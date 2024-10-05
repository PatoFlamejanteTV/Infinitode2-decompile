/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.b;
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
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
/*     */ public final class o
/*     */   extends a
/*     */ {
/*  34 */   private static final a[] a = new a[] { a.t, a.q, a.p };
/*     */   
/*     */   public final List a(a parama, List<j> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     k k;
/*  38 */     ArrayList<v> arrayList = new ArrayList(3);
/*  39 */     a(parama, 1, 2, paramList.size());
/*     */     
/*  41 */     if (paramList.size() == 1) {
/*     */       j j;
/*     */       
/*  44 */       a((d)(j = paramList.get(0)), paramBoolean2);
/*     */       
/*  46 */       if (j.e() == 0)
/*  47 */         return a(a, paramList, paramInt, paramBoolean1, paramBoolean2); 
/*  48 */       if (j.a() == 21) {
/*     */         
/*  50 */         if ((k = k.a(j.c())) != null) {
/*  51 */           arrayList.add(new v(a.t, (d)new j(c.e), paramBoolean1, paramInt));
/*     */           
/*  53 */           arrayList.add(new v(a.p, k
/*  54 */                 .b(), paramBoolean1, paramInt));
/*  55 */           arrayList.add(new v(a.q, k
/*  56 */                 .a(), paramBoolean1, paramInt));
/*  57 */           return arrayList;
/*     */         } 
/*     */         
/*     */         c c;
/*  61 */         if ((c = b((d)j)) == c.Z || c == c.aA) {
/*  62 */           arrayList.add(new v(a.t, (d)j, paramBoolean1, paramInt));
/*     */           
/*  64 */           arrayList.add(new v(a.p, (d)new j(c.e), paramBoolean1, paramInt));
/*     */           
/*  66 */           arrayList.add(new v(a.q, (d)new j(c.e), paramBoolean1, paramInt));
/*     */           
/*  68 */           return arrayList;
/*  69 */         }  if (c == c.e) {
/*  70 */           arrayList.add(new v(a.t, (d)j, paramBoolean1, paramInt));
/*     */           
/*  72 */           arrayList.add(new v(a.p, (d)j, paramBoolean1, paramInt));
/*     */           
/*  74 */           arrayList.add(new v(a.q, (d)j, paramBoolean1, paramInt));
/*     */           
/*  76 */           return arrayList;
/*     */         } 
/*  78 */         throw new b("Identifier " + c + " is not a valid value for " + parama, -1);
/*     */       } 
/*  80 */       if (a((d)j)) {
/*  81 */         if (j.f() < 0.0F) {
/*  82 */           throw new b("A page dimension may not be negative", -1);
/*     */         }
/*     */         
/*  85 */         arrayList.add(new v(a.t, (d)new j(c.e), paramBoolean1, paramInt));
/*     */         
/*  87 */         arrayList.add(new v(a.p, (d)j, paramBoolean1, paramInt));
/*     */         
/*  89 */         arrayList.add(new v(a.q, (d)j, paramBoolean1, paramInt));
/*     */ 
/*     */         
/*  92 */         return arrayList;
/*     */       } 
/*  94 */       throw new b("Value for " + parama + " must be a length or identifier", -1);
/*     */     } 
/*     */     
/*  97 */     j j2 = k.get(0);
/*     */     
/*     */     j j1;
/* 100 */     a((d)(j1 = k.get(1)), false);
/*     */     
/* 102 */     if (a((d)j2) && a((d)j1)) {
/* 103 */       if (j2.f() < 0.0F) {
/* 104 */         throw new b("A page dimension may not be negative", -1);
/*     */       }
/*     */       
/* 107 */       if (j1.f() < 0.0F) {
/* 108 */         throw new b("A page dimension may not be negative", -1);
/*     */       }
/*     */       
/* 111 */       arrayList.add(new v(a.t, (d)new j(c.e), paramBoolean1, paramInt));
/*     */       
/* 113 */       arrayList.add(new v(a.p, (d)j2, paramBoolean1, paramInt));
/*     */       
/* 115 */       arrayList.add(new v(a.q, (d)j1, paramBoolean1, paramInt));
/*     */ 
/*     */       
/* 118 */       return arrayList;
/* 119 */     }  if (j2.a() == 21 && j1
/* 120 */       .a() == 21) {
/* 121 */       if (j1.c().equals("landscape") || j1
/* 122 */         .c().equals("portrait")) {
/* 123 */         j j = j2;
/* 124 */         j2 = j1;
/* 125 */         j1 = j;
/*     */       } 
/*     */       
/* 128 */       if (!j2.toString().equals("landscape") && !j2.toString().equals("portrait")) {
/* 129 */         throw new b("Value " + j2 + " is not a valid page orientation", -1);
/*     */       }
/*     */       
/* 132 */       arrayList.add(new v(a.t, (d)j2, paramBoolean1, paramInt));
/*     */       
/*     */       k k1;
/*     */       
/* 136 */       if ((k1 = k.a(j1.c())) == null) {
/* 137 */         throw new b("Value " + j2 + " is not a valid page size", -1);
/*     */       }
/*     */       
/* 140 */       arrayList.add(new v(a.p, k1
/* 141 */             .b(), paramBoolean1, paramInt));
/* 142 */       arrayList.add(new v(a.q, k1
/* 143 */             .a(), paramBoolean1, paramInt));
/*     */       
/* 145 */       return arrayList;
/*     */     } 
/* 147 */     throw new b("Invalid value for size property", -1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */