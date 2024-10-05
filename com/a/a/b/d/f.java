/*     */ package com.a.a.b.d;
/*     */ 
/*     */ import com.a.a.b.g;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.n;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class f
/*     */   extends n
/*     */ {
/*     */   private f c;
/*     */   private b d;
/*     */   private f e;
/*     */   private String f;
/*     */   private Object g;
/*     */   private boolean h;
/*     */   
/*     */   private f(int paramInt, f paramf, b paramb) {
/*  70 */     this.a = paramInt;
/*  71 */     this.c = paramf;
/*  72 */     this.d = paramb;
/*  73 */     this.b = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private f(int paramInt, f paramf, b paramb, Object paramObject) {
/*  80 */     this.a = paramInt;
/*  81 */     this.c = paramf;
/*  82 */     this.d = paramb;
/*  83 */     this.b = -1;
/*  84 */     this.g = paramObject;
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
/*     */   private f a(int paramInt) {
/* 101 */     this.a = paramInt;
/* 102 */     this.b = -1;
/* 103 */     this.f = null;
/* 104 */     this.h = false;
/* 105 */     this.g = null;
/* 106 */     if (this.d != null) this.d.b(); 
/* 107 */     return this;
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
/*     */   private f a(int paramInt, Object paramObject) {
/* 127 */     this.a = paramInt;
/* 128 */     this.b = -1;
/* 129 */     this.f = null;
/* 130 */     this.h = false;
/* 131 */     this.g = paramObject;
/* 132 */     if (this.d != null) this.d.b(); 
/* 133 */     return this;
/*     */   }
/*     */   
/*     */   public final f a(b paramb) {
/* 137 */     this.d = paramb;
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object h() {
/* 143 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject) {
/* 148 */     this.g = paramObject;
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
/*     */   public static f b(b paramb) {
/* 166 */     return new f(0, null, paramb);
/*     */   }
/*     */   
/*     */   public final f i() {
/*     */     f f1;
/* 171 */     if ((f1 = this.e) == null) {
/* 172 */       this
/* 173 */         .e = f1 = new f(1, this, (this.d == null) ? null : this.d.a());
/* 174 */       return f1;
/*     */     } 
/* 176 */     return f1.a(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b(Object paramObject) {
/*     */     f f1;
/* 182 */     if ((f1 = this.e) == null) {
/* 183 */       this
/* 184 */         .e = f1 = new f(1, this, (this.d == null) ? null : this.d.a(), paramObject);
/* 185 */       return f1;
/*     */     } 
/* 187 */     return f1.a(1, paramObject);
/*     */   }
/*     */   
/*     */   public final f j() {
/*     */     f f1;
/* 192 */     if ((f1 = this.e) == null) {
/* 193 */       this
/* 194 */         .e = f1 = new f(2, this, (this.d == null) ? null : this.d.a());
/* 195 */       return f1;
/*     */     } 
/* 197 */     return f1.a(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f c(Object paramObject) {
/*     */     f f1;
/* 203 */     if ((f1 = this.e) == null) {
/* 204 */       this
/* 205 */         .e = f1 = new f(2, this, (this.d == null) ? null : this.d.a(), paramObject);
/* 206 */       return f1;
/*     */     } 
/* 208 */     return f1.a(2, paramObject);
/*     */   }
/*     */   
/* 211 */   public final f k() { return this.c; } public final String g() {
/* 212 */     return this.f;
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
/*     */   public final f l() {
/* 229 */     this.g = null;
/*     */     
/* 231 */     return this.c;
/*     */   }
/*     */   
/*     */   public final b m() {
/* 235 */     return this.d;
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
/*     */   public final int a(String paramString) {
/* 248 */     if (this.a != 2 || this.h) {
/* 249 */       return 4;
/*     */     }
/* 251 */     this.h = true;
/* 252 */     this.f = paramString;
/* 253 */     if (this.d != null) a(this.d, paramString); 
/* 254 */     return (this.b < 0) ? 0 : 1;
/*     */   }
/*     */   
/*     */   private static void a(b paramb, String paramString) {
/* 258 */     if (paramb.a(paramString)) {
/* 259 */       Object object = paramb.c();
/* 260 */       throw new g("Duplicate field '" + paramString + "'", (object instanceof h) ? (h)object : null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int n() {
/* 267 */     if (this.a == 2) {
/* 268 */       if (!this.h) {
/* 269 */         return 5;
/*     */       }
/* 271 */       this.h = false;
/* 272 */       this.b++;
/* 273 */       return 2;
/*     */     } 
/*     */ 
/*     */     
/* 277 */     if (this.a == 1) {
/* 278 */       int i = this.b;
/* 279 */       this.b++;
/* 280 */       return (i < 0) ? 0 : 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 285 */     this.b++;
/* 286 */     return (this.b == 0) ? 0 : 3;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */