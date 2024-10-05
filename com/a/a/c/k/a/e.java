/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.b.b;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class e
/*     */   extends b<List<?>>
/*     */ {
/*     */   public e(j paramj, boolean paramBoolean, i parami, o<Object> paramo) {
/*  27 */     super(List.class, paramj, paramBoolean, parami, paramo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e(e parame, c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  33 */     super(parame, paramc, parami, paramo, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e b(c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  40 */     return new e(this, paramc, parami, paramo, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(List<?> paramList) {
/*  51 */     return paramList.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean b(List<?> paramList) {
/*  56 */     return (paramList.size() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final j<?> b(i parami) {
/*  61 */     return (j<?>)new e(this, this.b, parami, this.e, this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<?> paramList, h paramh, aa paramaa) {
/*     */     int i;
/*  70 */     if ((i = paramList.size()) == 1 && ((
/*  71 */       this.c == null && paramaa
/*  72 */       .a(z.r)) || this.c == Boolean.TRUE)) {
/*     */       
/*  74 */       b(paramList, paramh, paramaa);
/*     */       
/*     */       return;
/*     */     } 
/*  78 */     paramh.a(paramList, i);
/*  79 */     b(paramList, paramh, paramaa);
/*  80 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(List<?> paramList, h paramh, aa paramaa) {
/*  87 */     if (this.e != null) {
/*  88 */       a(paramList, paramh, paramaa, this.e);
/*     */       return;
/*     */     } 
/*  91 */     if (this.d != null) {
/*  92 */       c(paramList, paramh, paramaa);
/*     */       return;
/*     */     } 
/*     */     int i;
/*  96 */     if ((i = paramList.size()) == 0) {
/*     */       return;
/*     */     }
/*  99 */     byte b1 = 0;
/*     */     try {
/* 101 */       k k = this.f;
/* 102 */       for (; b1 < i; b1++) {
/*     */         Object object;
/* 104 */         if ((object = paramList.get(b1)) == null) {
/* 105 */           paramaa.a(paramh);
/*     */         } else {
/* 107 */           Class<?> clazz = object.getClass();
/*     */           o<Object> o;
/* 109 */           if ((o = k.a(clazz)) == null) {
/*     */             
/* 111 */             if (this.a.s()) {
/* 112 */               o = a(k, paramaa
/* 113 */                   .a(this.a, clazz), paramaa);
/*     */             } else {
/* 115 */               o = a(k, clazz, paramaa);
/*     */             } 
/* 117 */             k = this.f;
/*     */           } 
/* 119 */           o.a(object, paramh, paramaa);
/*     */         } 
/*     */       }  return;
/* 122 */     } catch (Exception exception) {
/* 123 */       a(paramaa, exception, paramList, b1);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<?> paramList, h paramh, aa paramaa, o<Object> paramo) {
/*     */     int i;
/* 132 */     if ((i = paramList.size()) == 0) {
/*     */       return;
/*     */     }
/* 135 */     i i1 = this.d;
/* 136 */     for (byte b1 = 0; b1 < i; b1++) {
/* 137 */       Object object = paramList.get(b1);
/*     */       try {
/* 139 */         if (object == null) {
/* 140 */           paramaa.a(paramh);
/* 141 */         } else if (i1 == null) {
/* 142 */           paramo.a(object, paramh, paramaa);
/*     */         } else {
/* 144 */           paramo.a(object, paramh, paramaa, i1);
/*     */         } 
/* 146 */       } catch (Exception exception) {
/*     */         
/* 148 */         a(paramaa, exception, paramList, b1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(List<?> paramList, h paramh, aa paramaa) {
/*     */     int i;
/* 157 */     if ((i = paramList.size()) == 0) {
/*     */       return;
/*     */     }
/* 160 */     byte b1 = 0;
/*     */     try {
/* 162 */       i i1 = this.d;
/* 163 */       k k = this.f;
/* 164 */       for (; b1 < i; b1++) {
/*     */         Object object;
/* 166 */         if ((object = paramList.get(b1)) == null) {
/* 167 */           paramaa.a(paramh);
/*     */         } else {
/* 169 */           Class<?> clazz = object.getClass();
/*     */           o<Object> o;
/* 171 */           if ((o = k.a(clazz)) == null) {
/*     */             
/* 173 */             if (this.a.s()) {
/* 174 */               o = a(k, paramaa
/* 175 */                   .a(this.a, clazz), paramaa);
/*     */             } else {
/* 177 */               o = a(k, clazz, paramaa);
/*     */             } 
/* 179 */             k = this.f;
/*     */           } 
/* 181 */           o.a(object, paramh, paramaa, i1);
/*     */         } 
/*     */       }  return;
/* 184 */     } catch (Exception exception) {
/* 185 */       a(paramaa, exception, paramList, b1);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */