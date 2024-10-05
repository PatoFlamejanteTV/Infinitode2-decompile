/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.a.c.a.a;
/*     */ import org.a.c.a.a.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.l;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.f.g;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class af
/*     */   implements a, c
/*     */ {
/*     */   private final p a;
/*     */   
/*     */   public af(ag paramag, p paramp) {
/*  50 */     this.a = paramp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private p e() {
/*  56 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final i b() {
/*  66 */     return new i(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final InputStream a() {
/*  72 */     return (InputStream)this.a.k();
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
/*     */   public final h c() {
/*  96 */     ArrayList<b> arrayList = new ArrayList();
/*     */     g g;
/*  98 */     Object object = (g = new g(this)).r();
/*  99 */     while (object != null) {
/*     */       byte b;
/* 101 */       if (object instanceof m) {
/*     */         
/* 103 */         arrayList.add(((m)object).a());
/*     */       } else {
/* 105 */         if (object instanceof a) {
/*     */           
/* 107 */           if (((a)object).a().equals("d1") && arrayList.size() == 6) {
/*     */             
/* 109 */             for (b = 0; b < 6; b++) {
/*     */               
/* 111 */               if (!(arrayList.get(b) instanceof l))
/*     */               {
/* 113 */                 return null;
/*     */               }
/*     */             } 
/* 116 */             return new h(((l)arrayList
/* 117 */                 .get(2)).a(), ((l)arrayList
/* 118 */                 .get(3)).a(), ((l)arrayList
/* 119 */                 .get(4)).a() - ((l)arrayList.get(2)).a(), ((l)arrayList
/* 120 */                 .get(5)).a() - ((l)arrayList.get(3)).a());
/*     */           } 
/*     */ 
/*     */           
/* 124 */           return null;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 129 */         arrayList.add((b)object);
/*     */       } 
/* 131 */       object = b.r();
/*     */     } 
/* 133 */     return null;
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
/*     */   public final float d() {
/* 151 */     ArrayList<b> arrayList = new ArrayList();
/*     */     g g;
/* 153 */     Object object = (g = new g(this)).r();
/* 154 */     while (object != null) {
/*     */       
/* 156 */       if (object instanceof m) {
/*     */         
/* 158 */         arrayList.add(((m)object).a());
/*     */       } else {
/* 160 */         if (object instanceof a)
/*     */         {
/* 162 */           return a((a)object, arrayList);
/*     */         }
/*     */ 
/*     */         
/* 166 */         arrayList.add((b)object);
/*     */       } 
/* 168 */       object = g.r();
/*     */     } 
/* 170 */     throw new IOException("Unexpected end of stream");
/*     */   }
/*     */ 
/*     */   
/*     */   private static float a(a parama, List<b> paramList) {
/* 175 */     if (parama.a().equals("d0") || parama.a().equals("d1")) {
/*     */       b b;
/*     */       
/* 178 */       if (b = paramList.get(0) instanceof l)
/*     */       {
/* 180 */         return ((l)b).a();
/*     */       }
/* 182 */       throw new IOException("Unexpected argument type: " + b.getClass().getName());
/*     */     } 
/*     */ 
/*     */     
/* 186 */     throw new IOException("First operator must be d0 or d1");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */