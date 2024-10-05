/*     */ package com.a.a.b.g;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
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
/*     */ public final class k
/*     */   extends j
/*     */ {
/*     */   private l[] d;
/*     */   private boolean e;
/*     */   private int f;
/*     */   private boolean g;
/*     */   
/*     */   private k(boolean paramBoolean, l[] paramArrayOfl) {
/*  66 */     super(paramArrayOfl[0]);
/*  67 */     this.e = paramBoolean;
/*  68 */     this.g = (paramBoolean && this.c.o());
/*  69 */     this.d = paramArrayOfl;
/*  70 */     this.f = 1;
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
/*     */   public static k a(boolean paramBoolean, l paraml1, l paraml2) {
/*  92 */     if (!(paraml1 instanceof k) && !(paraml2 instanceof k)) {
/*  93 */       return new k(false, new l[] { paraml1, paraml2 });
/*     */     }
/*     */     
/*  96 */     ArrayList<l> arrayList = new ArrayList();
/*  97 */     if (paraml1 instanceof k) {
/*  98 */       ((k)paraml1).a(arrayList);
/*     */     } else {
/* 100 */       arrayList.add(paraml1);
/*     */     } 
/* 102 */     if (paraml2 instanceof k) {
/* 103 */       ((k)paraml2).a(arrayList);
/*     */     } else {
/* 105 */       arrayList.add(paraml2);
/*     */     } 
/* 107 */     return new k(false, arrayList
/* 108 */         .<l>toArray(new l[arrayList.size()]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<l> paramList) {
/* 119 */     for (int i = this.f - 1, m = this.d.length; i < m; i++) {
/*     */       l l1;
/* 121 */       if (l1 = this.d[i] instanceof k) {
/* 122 */         ((k)l1).a(paramList);
/*     */       } else {
/* 124 */         paramList.add(l1);
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
/*     */   public final void close() {
/*     */     
/* 138 */     do { this.c.close(); } while (W());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final o g() {
/* 144 */     if (this.c == null) {
/* 145 */       return null;
/*     */     }
/* 147 */     if (this.g) {
/* 148 */       this.g = false;
/* 149 */       return this.c.k();
/*     */     } 
/*     */     o o;
/* 152 */     if ((o = this.c.g()) == null) {
/* 153 */       return X();
/*     */     }
/* 155 */     return o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final l j() {
/* 166 */     if (this.c.k() != o.b && this.c
/* 167 */       .k() != o.d) {
/* 168 */       return this;
/*     */     }
/* 170 */     byte b = 1;
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       o o;
/*     */       
/* 176 */       if ((o = g()) == null) {
/* 177 */         return this;
/*     */       }
/* 179 */       if (o.e()) {
/* 180 */         b++; continue;
/* 181 */       }  if (o.f() && 
/* 182 */         --b == 0) {
/* 183 */         return this;
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
/*     */   private boolean W() {
/* 223 */     if (this.f < this.d.length) {
/* 224 */       this.c = this.d[this.f++];
/* 225 */       return true;
/*     */     } 
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private o X() {
/* 232 */     while (this.f < this.d.length) {
/* 233 */       this.c = this.d[this.f++];
/* 234 */       if (this.e && this.c.o()) {
/* 235 */         return this.c.m();
/*     */       }
/*     */       o o;
/* 238 */       if ((o = this.c.g()) != null) {
/* 239 */         return o;
/*     */       }
/*     */     } 
/* 242 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */