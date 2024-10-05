/*     */ package org.a.c.h.g.e;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.a.c.h.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class t
/*     */ {
/*     */   private final b a;
/*     */   private final boolean b;
/*     */   private final float c;
/*     */   private final g d;
/*     */   private final s e;
/*     */   private final b f;
/*     */   private float g;
/*     */   private float h;
/*     */   
/*     */   enum b
/*     */   {
/*  40 */     a(0), b(1), c(2), d(4);
/*     */     
/*     */     private final int e;
/*     */ 
/*     */     
/*     */     b(int param1Int1) {
/*  46 */       this.e = param1Int1;
/*     */     }
/*     */ 
/*     */     
/*     */     private int a() {
/*  51 */       return this.e;
/*     */     } public static b a(int param1Int) {
/*     */       b[] arrayOfB;
/*     */       int i;
/*     */       byte b1;
/*  56 */       for (i = (arrayOfB = values()).length, b1 = 0; b1 < i; b1++) {
/*     */         b b2;
/*  58 */         if ((b2 = arrayOfB[b1]).a() == param1Int)
/*     */         {
/*  60 */           return b2;
/*     */         }
/*     */       } 
/*  63 */       return a;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */   {
/*     */     private g a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean c = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     private float d = 0.0F;
/*     */     private s e;
/*  94 */     private t.b f = t.b.a;
/*     */ 
/*     */ 
/*     */     
/*  98 */     private float g = 0.0F;
/*  99 */     private float h = 0.0F;
/*     */ 
/*     */     
/*     */     a(g param1g) {
/* 103 */       this.a = param1g;
/*     */     }
/*     */ 
/*     */     
/*     */     final a a(b param1b) {
/* 108 */       this.b = param1b;
/* 109 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     final a a(boolean param1Boolean) {
/* 114 */       this.c = param1Boolean;
/* 115 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     final a a(float param1Float) {
/* 120 */       this.d = param1Float;
/* 121 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     final a a(int param1Int) {
/* 126 */       this.f = t.b.a(param1Int);
/* 127 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final a a(s param1s) {
/* 139 */       this.e = param1s;
/* 140 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     final a a(float param1Float1, float param1Float2) {
/* 145 */       this.g = param1Float1;
/* 146 */       this.h = param1Float2;
/* 147 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     final t a() {
/* 152 */       return new t(this, (byte)0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private t(a parama) {
/* 158 */     this.a = a.a(parama);
/* 159 */     this.b = a.b(parama);
/* 160 */     this.c = a.c(parama);
/* 161 */     this.d = a.d(parama);
/* 162 */     this.e = a.e(parama);
/* 163 */     this.f = a.f(parama);
/* 164 */     this.g = a.g(parama);
/* 165 */     this.h = a.h(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/* 175 */     if (this.e != null && !this.e.a().isEmpty()) {
/*     */       
/* 177 */       boolean bool = true;
/* 178 */       for (s.b b1 : this.e.a()) {
/*     */         
/* 180 */         if (this.b) {
/*     */           
/* 182 */           List<s.a> list = b1.a(this.a
/* 183 */               .a(), this.a
/* 184 */               .b(), this.c);
/*     */ 
/*     */           
/* 187 */           a(list, bool);
/* 188 */           bool = false;
/*     */           
/*     */           continue;
/*     */         } 
/* 192 */         float f1 = 0.0F;
/*     */ 
/*     */         
/*     */         float f2;
/*     */ 
/*     */         
/* 198 */         if ((f2 = this.a.a().b(b1.a()) * this.a.b() / 1000.0F) < this.c)
/*     */         {
/* 200 */           switch (u.a[this.f.ordinal()]) {
/*     */             
/*     */             case 1:
/* 203 */               f1 = (this.c - f2) / 2.0F;
/*     */               break;
/*     */             case 2:
/* 206 */               f1 = this.c - f2;
/*     */               break;
/*     */             
/*     */             default:
/* 210 */               f1 = 0.0F;
/*     */               break;
/*     */           } 
/*     */         }
/* 214 */         this.d.a(this.g + f1, this.h);
/* 215 */         this.d.a(b1.a());
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
/*     */   private void a(List<s.a> paramList, boolean paramBoolean) {
/* 234 */     float f1 = 0.0F;
/* 235 */     float f2 = 0.0F;
/* 236 */     float f3 = 0.0F;
/*     */     
/* 238 */     for (s.a a : paramList) {
/*     */       
/* 240 */       switch (u.a[this.f.ordinal()]) {
/*     */         
/*     */         case 1:
/* 243 */           f2 = (this.c - a.a()) / 2.0F;
/*     */           break;
/*     */         case 2:
/* 246 */           f2 = this.c - a.a();
/*     */           break;
/*     */         case 3:
/* 249 */           if (paramList.indexOf(a) != paramList.size() - 1)
/*     */           {
/* 251 */             f3 = a.b(this.c);
/*     */           }
/*     */           break;
/*     */         default:
/* 255 */           f2 = 0.0F;
/*     */           break;
/*     */       } 
/* 258 */       float f = -f1 + f2 + this.g;
/*     */       
/* 260 */       if (paramList.indexOf(a) == 0 && paramBoolean) {
/*     */         
/* 262 */         this.d.a(f, this.h);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 267 */         this.h -= this.a.c();
/* 268 */         this.d.a(f, -this.a.c());
/*     */       } 
/*     */       
/* 271 */       f1 += f;
/*     */       
/*     */       List<s.d> list;
/* 274 */       for (s.d d : list = a.b()) {
/*     */         
/* 276 */         this.d.a(d.a());
/* 277 */         float f4 = ((Float)d.b().getIterator().getAttribute(s.c.a)).floatValue();
/* 278 */         if (list.indexOf(d) != list.size() - 1) {
/*     */           
/* 280 */           this.d.a(f4 + f3, 0.0F);
/* 281 */           f1 = f1 + f4 + f3;
/*     */         } 
/*     */       } 
/*     */     } 
/* 285 */     this.g -= f1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\e\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */