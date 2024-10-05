/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.b.f.a;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.k.b.ah;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class p
/*     */   extends ah<Collection<String>>
/*     */ {
/*  27 */   public static final p a = new p();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected p() {
/*  36 */     super(Collection.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private p(p paramp, Boolean paramBoolean) {
/*  42 */     super(paramp, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<?> a(Boolean paramBoolean) {
/*  47 */     return (o<?>)new p(this, paramBoolean);
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
/*     */   private void a(Collection<String> paramCollection, h paramh, aa paramaa) {
/*     */     int i;
/*  71 */     if ((i = paramCollection.size()) == 1 && ((
/*  72 */       this.b == null && paramaa
/*  73 */       .a(z.r)) || this.b == Boolean.TRUE)) {
/*     */       
/*  75 */       b(paramCollection, paramh, paramaa);
/*     */       
/*     */       return;
/*     */     } 
/*  79 */     paramh.a(paramCollection, i);
/*  80 */     b(paramCollection, paramh, paramaa);
/*  81 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Collection<String> paramCollection, h paramh, aa paramaa, i parami) {
/*  89 */     a a = parami.a(paramh, parami
/*  90 */         .a(paramCollection, o.d));
/*  91 */     paramh.a(paramCollection);
/*  92 */     b(paramCollection, paramh, paramaa);
/*  93 */     parami.b(paramh, a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void b(Collection<String> paramCollection, h paramh, aa paramaa) {
/* 100 */     byte b = 0;
/*     */     
/*     */     try {
/* 103 */       for (Iterator<String> iterator = paramCollection.iterator(); iterator.hasNext(); ) {
/* 104 */         String str; if ((str = iterator.next()) == null) {
/* 105 */           paramaa.a(paramh);
/*     */         } else {
/* 107 */           paramh.b(str);
/*     */         } 
/* 109 */         b++;
/*     */       }  return;
/* 111 */     } catch (Exception exception) {
/* 112 */       a(paramaa, exception, paramCollection, b);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */