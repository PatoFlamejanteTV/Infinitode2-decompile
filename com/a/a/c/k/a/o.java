/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.k.b.a;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.z;
/*     */ import java.util.Objects;
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
/*     */ @a
/*     */ public final class o
/*     */   extends a<String[]>
/*     */ {
/*     */   static {
/*  35 */     com.a.a.c.l.o.a().a(String.class);
/*     */   }
/*  37 */   public static final o a = new o();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private com.a.a.c.o<Object> d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected o() {
/*  52 */     super(String[].class);
/*  53 */     this.d = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private o(o paramo, c paramc, com.a.a.c.o<?> paramo1, Boolean paramBoolean) {
/*  59 */     super(paramo, paramc, paramBoolean);
/*  60 */     this.d = (com.a.a.c.o)paramo1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final com.a.a.c.o<?> a(c paramc, Boolean paramBoolean) {
/*  65 */     return (com.a.a.c.o<?>)new o(this, paramc, this.d, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j<?> b(i parami) {
/*  74 */     return (j<?>)this;
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
/*     */   public final com.a.a.c.o<?> a(aa paramaa, c paramc) {
/*  92 */     com.a.a.c.o<Object> o1 = null;
/*     */ 
/*     */ 
/*     */     
/*  96 */     a a1 = paramaa.d(); Object object;
/*     */     j j;
/*  98 */     if (paramc != null && (j = paramc.e()) != null && (
/*     */       
/* 100 */       object = a1.p((b)j)) != null) {
/* 101 */       o1 = paramaa.b((b)j, object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     object = a(paramaa, paramc, String[].class, l.a.c);
/*     */     
/* 109 */     if (o1 == null) {
/* 110 */       o1 = this.d;
/*     */     }
/*     */ 
/*     */     
/* 114 */     if ((o1 = a(paramaa, paramc, o1)) == null) {
/* 115 */       o1 = paramaa.c(String.class, paramc);
/*     */     }
/*     */     
/* 118 */     if (a(o1)) {
/* 119 */       o1 = null;
/*     */     }
/*     */     
/* 122 */     if (o1 == this.d && Objects.equals(object, this.c)) {
/* 123 */       return (com.a.a.c.o<?>)this;
/*     */     }
/* 125 */     return (com.a.a.c.o<?>)new o(this, paramc, o1, (Boolean)object);
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
/*     */   private static boolean a(String[] paramArrayOfString) {
/* 146 */     return (paramArrayOfString.length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean b(String[] paramArrayOfString) {
/* 151 */     return (paramArrayOfString.length == 1);
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
/*     */   private void a(String[] paramArrayOfString, h paramh, aa paramaa) {
/*     */     int i;
/* 165 */     if ((i = paramArrayOfString.length) == 1 && ((
/* 166 */       this.c == null && paramaa
/* 167 */       .a(z.r)) || this.c == Boolean.TRUE)) {
/*     */       
/* 169 */       b(paramArrayOfString, paramh, paramaa);
/*     */       
/*     */       return;
/*     */     } 
/* 173 */     paramh.a(paramArrayOfString, i);
/* 174 */     b(paramArrayOfString, paramh, paramaa);
/* 175 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(String[] paramArrayOfString, h paramh, aa paramaa) {
/*     */     int i;
/* 183 */     if ((i = paramArrayOfString.length) == 0) {
/*     */       return;
/*     */     }
/* 186 */     if (this.d != null) {
/* 187 */       a(paramArrayOfString, paramh, paramaa, this.d);
/*     */       return;
/*     */     } 
/* 190 */     for (byte b = 0; b < i; b++) {
/*     */       String str;
/* 192 */       if ((str = paramArrayOfString[b]) == null) {
/* 193 */         paramh.k();
/*     */       } else {
/* 195 */         paramh.b(paramArrayOfString[b]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(String[] paramArrayOfString, h paramh, aa paramaa, com.a.a.c.o<Object> paramo) {
/*     */     byte b;
/*     */     int i;
/* 203 */     for (b = 0, i = paramArrayOfString.length; b < i; b++) {
/*     */       String str;
/* 205 */       if ((str = paramArrayOfString[b]) == null) {
/* 206 */         paramaa.a(paramh);
/*     */       } else {
/* 208 */         paramo.a(paramArrayOfString[b], paramh, paramaa);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */