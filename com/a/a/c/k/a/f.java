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
/*     */ @a
/*     */ public final class f
/*     */   extends ah<List<String>>
/*     */ {
/*  28 */   public static final f a = new f();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected f() {
/*  37 */     super(List.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private f(f paramf, Boolean paramBoolean) {
/*  42 */     super(paramf, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<?> a(Boolean paramBoolean) {
/*  47 */     return (o<?>)new f(this, paramBoolean);
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
/*     */   private void a(List<String> paramList, h paramh, aa paramaa) {
/*     */     int i;
/*  68 */     if ((i = paramList.size()) == 1 && ((
/*  69 */       this.b == null && paramaa
/*  70 */       .a(z.r)) || this.b == Boolean.TRUE)) {
/*     */       
/*  72 */       a(paramList, paramh, paramaa, 1);
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     paramh.a(paramList, i);
/*  77 */     a(paramList, paramh, paramaa, i);
/*  78 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<String> paramList, h paramh, aa paramaa, i parami) {
/*  86 */     a a = parami.a(paramh, parami
/*  87 */         .a(paramList, o.d));
/*  88 */     paramh.a(paramList);
/*  89 */     a(paramList, paramh, paramaa, paramList.size());
/*  90 */     parami.b(paramh, a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final void a(List<String> paramList, h paramh, aa paramaa, int paramInt) {
/*  96 */     byte b = 0;
/*     */     try {
/*  98 */       for (; b < paramInt; b++) {
/*     */         String str;
/* 100 */         if ((str = paramList.get(b)) == null) {
/* 101 */           paramaa.a(paramh);
/*     */         } else {
/* 103 */           paramh.b(str);
/*     */         } 
/*     */       }  return;
/* 106 */     } catch (Exception exception) {
/* 107 */       a(paramaa, exception, paramList, b);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */