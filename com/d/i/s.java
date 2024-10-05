/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.e.o;
/*     */ import com.d.e.v;
/*     */ import com.d.m.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class s
/*     */ {
/*     */   private r a;
/*     */   private int b;
/*     */   private String c;
/*     */   private int d;
/*     */   private int e;
/*     */   private int f;
/*     */   private o g;
/*     */   private boolean h = false;
/*     */   private byte i;
/*     */   private float j;
/*     */   
/*     */   public final void a(byte paramByte) {
/*  68 */     this.i = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte a() {
/*  75 */     return this.i;
/*     */   }
/*     */   
/*     */   public final void a(float paramFloat) {
/*  79 */     this.j = paramFloat;
/*     */   }
/*     */   
/*     */   public final float b() {
/*  83 */     return this.j;
/*     */   }
/*     */   
/*     */   public final void a(v paramv) {
/*  87 */     if (!c() && this.c.charAt(this.e - 1) == ' ') {
/*  88 */       this.e--;
/*  89 */       paramv.w(); b(paramv.d().a(
/*  90 */             g().a().d((d)paramv), 
/*  91 */             d()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c() {
/*  97 */     return (this.d == this.e && !this.h);
/*     */   }
/*     */   
/*     */   public final String d() {
/* 101 */     if (i() != null) {
/* 102 */       if (this.d == -1 || this.e == -1) {
/* 103 */         throw new RuntimeException("negative index in InlineBox");
/*     */       }
/* 105 */       if (this.e < this.d) {
/* 106 */         throw new RuntimeException("end is less than setStartStyle");
/*     */       }
/* 108 */       return i().substring(this.d, this.e);
/*     */     } 
/* 110 */     throw new RuntimeException("No master text set!");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(int paramInt1, int paramInt2) {
/* 115 */     if (paramInt2 < paramInt1) {
/* 116 */       k.b("setting substring to: " + paramInt1 + " " + paramInt2);
/* 117 */       throw new RuntimeException("set substring length too long: " + this);
/* 118 */     }  if (paramInt2 < 0 || paramInt1 < 0) {
/* 119 */       throw new RuntimeException("Trying to set negative index to inline box");
/*     */     }
/* 121 */     this.d = paramInt1;
/* 122 */     this.e = paramInt2;
/*     */     
/* 124 */     if (this.e > 0 && this.c.charAt(this.e - 1) == '\n') {
/* 125 */       this.h = true;
/* 126 */       this.e--;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String i() {
/* 131 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(String paramString) {
/* 135 */     this.c = paramString;
/*     */   }
/*     */   
/*     */   public final int e() {
/* 139 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/* 143 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */   public final int f() {
/* 147 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/* 151 */     this.f = paramInt;
/*     */   }
/*     */   
/*     */   public final void a(ab paramab) {
/* 155 */     paramab.p().a(paramab, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final r g() {
/* 163 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(r paramr) {
/* 167 */     this.a = paramr;
/*     */   }
/*     */   
/*     */   public final boolean h() {
/* 171 */     return (this.g != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(o paramo) {
/* 179 */     this.g = paramo;
/*     */   }
/*     */   
/*     */   public final void b(ab paramab) {
/* 183 */     String str = this.g.a().a(paramab, this.g
/* 184 */         .b(), this);
/* 185 */     this.d = 0;
/* 186 */     this.e = str.length();
/* 187 */     this.c = str;
/* 188 */     paramab
/* 189 */       .q(); this.f = paramab.f().a(g().a().d(paramab), str);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 195 */     (stringBuilder = new StringBuilder()).append("InlineText: ");
/* 196 */     if (this.h || h()) {
/* 197 */       stringBuilder.append("(");
/* 198 */       if (this.h) {
/* 199 */         stringBuilder.append('L');
/*     */       }
/* 201 */       if (h()) {
/* 202 */         stringBuilder.append('F');
/*     */       }
/* 204 */       stringBuilder.append(") ");
/*     */     } 
/* 206 */     stringBuilder.append('(');
/* 207 */     stringBuilder.append(d());
/* 208 */     stringBuilder.append(')');
/*     */     
/* 210 */     return stringBuilder.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh) {
/* 323 */     if (b() != 0.0F) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*     */     String str;
/*     */     
/* 330 */     int i = (str = d()).length();
/* 331 */     byte b1 = 0;
/* 332 */     byte b2 = 0;
/*     */     
/* 334 */     for (byte b3 = 0; b3 < i; b3++) {
/*     */       char c;
/* 336 */       if ((c = str.charAt(b3)) == ' ' || c == ' ' || c == '　') {
/* 337 */         b1++;
/*     */       } else {
/* 339 */         b2++;
/*     */       } 
/*     */     } 
/*     */     
/* 343 */     paramh.a(paramh.a() + b1);
/* 344 */     paramh.b(paramh.b() + b2);
/*     */   }
/*     */   
/*     */   public final float a(t paramt) {
/* 348 */     if (b() != 0.0F)
/*     */     {
/*     */       
/* 351 */       return 0.0F;
/*     */     }
/*     */     
/*     */     String str;
/* 355 */     int i = (str = d()).length();
/*     */     
/* 357 */     float f = 0.0F;
/* 358 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 360 */       if ((c = str.charAt(b)) == ' ' || c == ' ' || c == '　') {
/* 361 */         f += paramt.b();
/*     */       } else {
/* 363 */         f += paramt.a();
/*     */       } 
/*     */     } 
/*     */     
/* 367 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */