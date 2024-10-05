/*     */ package com.d.e;
/*     */ 
/*     */ import com.d.d.g;
/*     */ import com.d.i.k;
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
/*     */ public final class j
/*     */ {
/*     */   public static void a(v paramv, x paramx, int paramInt, com.d.c.f.c paramc) {
/*  38 */     k k = paramc.d(paramv);
/*     */ 
/*     */     
/*  41 */     float f = paramc.aA() ? paramc.b(com.d.c.a.a.T, 0.0F, paramv) : 0.0F;
/*     */     
/*  43 */     paramx.a(a(paramx.d(), paramx.e()));
/*  44 */     paramv
/*  45 */       .w(); paramx.c(paramv.d().a(k, paramx.g()) + (int)f);
/*     */     
/*  47 */     if (paramx.j() > paramInt) {
/*  48 */       paramx.b(true);
/*  49 */       paramx.a(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int a(String paramString, int paramInt) {
/*  54 */     boolean bool = false;
/*  55 */     int i = paramString.length();
/*     */     int k;
/*  57 */     for (k = paramInt; k < i; ) {
/*     */       
/*  59 */       if (!ad.a(paramInt = paramString.codePointAt(k))) {
/*  60 */         if (bool) {
/*  61 */           return k;
/*     */         }
/*  63 */         bool = true;
/*     */       } 
/*     */       
/*  66 */       k += Character.charCount(paramInt);
/*     */     } 
/*  68 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void b(v paramv, x paramx, int paramInt, com.d.c.f.c paramc) {
/*  73 */     k k = paramc.d(paramv);
/*     */     
/*     */     com.d.c.a.c c1;
/*     */     
/*  77 */     if ((c1 = paramc.i()) == com.d.c.a.c.ar) {
/*  78 */       paramx.a(paramx.a());
/*  79 */       paramv
/*  80 */         .w(); paramx.c(paramv.d().a(k, paramx.g()));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  85 */     if (c1 == com.d.c.a.c.aB || c1 == com.d.c.a.c.aD || c1 == com.d.c.a.c.aC) {
/*     */       int i;
/*     */ 
/*     */       
/*  89 */       if ((i = paramx.f().indexOf("\n")) >= 0) {
/*  90 */         paramx.a(paramx.e() + i + 1);
/*  91 */         paramv
/*  92 */           .w(); paramx.c(paramv.d().a(k, paramx.g()));
/*  93 */         paramx.b(true);
/*     */       }
/*  95 */       else if (c1 == com.d.c.a.c.aB) {
/*  96 */         paramx.a(paramx.a());
/*  97 */         paramv
/*  98 */           .w(); paramx.c(paramv.d().a(k, paramx.g()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 103 */     if (c1 == com.d.c.a.c.aB || (paramx
/* 104 */       .i() && paramx.j() <= paramInt)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 109 */     a(paramv, paramx, paramInt, paramc, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(v paramv, x paramx, int paramInt, com.d.c.f.c paramc, boolean paramBoolean) {
/* 115 */     a(paramv, paramx, paramInt, paramc, a, b, false);
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
/*     */   private static void a(v paramv, x paramx, int paramInt, com.d.c.f.c paramc, c paramc1, c paramc2, boolean paramBoolean) {
/* 127 */     k k = paramc.d(paramv);
/*     */ 
/*     */ 
/*     */     
/* 131 */     float f = paramc.aA() ? paramc.b(com.d.c.a.a.T, 0.0F, paramv) : 0.0F;
/*     */     
/* 133 */     String str = paramx.f();
/*     */ 
/*     */     
/* 136 */     g g = paramBoolean ? paramc1.a(str, paramv.y()) : paramc2.a(str, paramv.y());
/*     */     
/* 138 */     int i = 0;
/* 139 */     int m = g.a();
/* 140 */     int n = 0;
/* 141 */     int i1 = 0;
/* 142 */     int i2 = 0;
/*     */ 
/*     */     
/* 145 */     while (m > 0 && i1 <= paramInt) {
/* 146 */       i2 = i1;
/* 147 */       paramv
/* 148 */         .w(); i1 = (int)(i1 + paramv.d().a(k, str.substring(i, m)) + (m - i) * f);
/* 149 */       n = i;
/* 150 */       i = m;
/* 151 */       m = g.a();
/*     */     } 
/*     */     
/* 154 */     if (i1 <= paramInt) {
/*     */       
/* 156 */       n = i;
/* 157 */       i2 = i1;
/* 158 */       paramv
/* 159 */         .w(); i1 += paramv.d().a(k, str.substring(i));
/*     */     } 
/*     */     
/* 162 */     if (i1 <= paramInt) {
/* 163 */       paramx.c(i1);
/* 164 */       paramx.a(paramx.d().length());
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 169 */     paramx.b(true);
/* 170 */     if (n == 0 && paramc.j() == com.d.c.a.c.as && 
/* 171 */       !paramBoolean) {
/* 172 */       a(paramv, paramx, paramInt, paramc, paramc1, paramc2, true);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 177 */     if (n != 0) {
/* 178 */       paramx.a(paramx.e() + n);
/* 179 */       paramx.c(i2); return;
/*     */     } 
/* 181 */     if (i == 0) {
/* 182 */       i = str.length();
/*     */     }
/*     */     
/* 185 */     paramx.a(paramx.e() + i);
/* 186 */     paramx.a(true);
/*     */     
/* 188 */     if (i == str.length()) {
/* 189 */       paramv
/* 190 */         .w(); paramx.c(paramv.d().a(k, paramx.g())); return;
/*     */     } 
/* 192 */     paramx.c(i1);
/*     */   }
/*     */   
/*     */   public static interface c {
/*     */     g a(String param1String, aa param1aa);
/*     */   }
/*     */   
/*     */   static class a
/*     */     implements c {
/*     */     private a() {}
/*     */     
/*     */     public final g a(String param1String, aa param1aa) {
/* 204 */       return j.a(param1String, param1aa);
/*     */     } }
/*     */   
/*     */   static class b implements c {
/*     */     private b() {}
/*     */     
/*     */     public final g a(String param1String, aa param1aa) {
/* 211 */       return j.b(param1String, param1aa);
/*     */     }
/*     */   }
/*     */   
/* 215 */   private static c a = new a((byte)0);
/* 216 */   private static c b = new b((byte)0);
/*     */   
/*     */   public static g a(String paramString, aa paramaa) {
/*     */     g g;
/* 220 */     (g = paramaa.z()).a(paramString);
/* 221 */     return g;
/*     */   }
/*     */   
/*     */   public static g b(String paramString, aa paramaa) {
/*     */     g g;
/* 226 */     (g = paramaa.y()).a(paramString);
/* 227 */     return g;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */