/*     */ package org.a.c.h.a.b.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */ {
/*     */   private enum b
/*     */   {
/*  30 */     a, b, c, d;
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
/*     */   public static void a(CharSequence paramCharSequence, c paramc) {
/*     */     d d;
/*  47 */     d.a(d = new d(paramCharSequence, paramc, (byte)0));
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
/*     */   public static interface c
/*     */   {
/*     */     void b(CharSequence param1CharSequence);
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
/*     */   public static abstract class a
/*     */     implements c {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class d
/*     */   {
/* 129 */     private h.b d = h.b.b;
/* 130 */     private final StringBuilder e = new StringBuilder(); private final CharSequence a; private int b;
/*     */     private final h.c c;
/*     */     
/*     */     private d(CharSequence param1CharSequence, h.c param1c) {
/* 134 */       this.a = param1CharSequence;
/* 135 */       this.c = param1c;
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean a() {
/* 140 */       return (this.b < this.a.length());
/*     */     }
/*     */ 
/*     */     
/*     */     private char b() {
/* 145 */       return this.a.charAt(this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     private char c() {
/* 150 */       this.b++;
/* 151 */       if (!a())
/*     */       {
/* 153 */         return '\004';
/*     */       }
/*     */ 
/*     */       
/* 157 */       return b();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private char d() {
/* 163 */       if (this.b < this.a.length() - 1)
/*     */       {
/* 165 */         return this.a.charAt(this.b + 1);
/*     */       }
/*     */ 
/*     */       
/* 169 */       return '\004';
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private h.b e() {
/*     */       char c1;
/* 176 */       switch (c1 = b())
/*     */       
/*     */       { case '\n':
/*     */         case '\f':
/*     */         case '\r':
/* 181 */           this.d = h.b.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 194 */           return this.d;case '\000': case '\t': case ' ': this.d = h.b.b; return this.d;case '%': this.d = h.b.c; return this.d; }  this.d = h.b.d; return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     private void f() {
/* 199 */       while (a()) {
/*     */         
/* 201 */         this.e.setLength(0);
/* 202 */         e();
/* 203 */         switch (i.a[this.d.ordinal()]) {
/*     */           
/*     */           case 1:
/* 206 */             g();
/*     */             continue;
/*     */           case 2:
/* 209 */             h();
/*     */             continue;
/*     */           case 3:
/* 212 */             i();
/*     */             continue;
/*     */         } 
/* 215 */         j();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void g() {
/* 222 */       if (!f && this.d != h.b.a) throw new AssertionError(); 
/* 223 */       char c1 = b();
/* 224 */       this.e.append(c1);
/* 225 */       if (c1 == '\r' && d() == '\n')
/*     */       {
/*     */         
/* 228 */         this.e.append(c());
/*     */       }
/*     */       
/* 231 */       c();
/*     */     }
/*     */ 
/*     */     
/*     */     private void h() {
/* 236 */       if (!f && this.d != h.b.b) throw new AssertionError(); 
/* 237 */       this.e.append(b());
/*     */       
/* 239 */       while (a()) {
/*     */         char c1;
/*     */         
/* 242 */         switch (c1 = c()) {
/*     */           
/*     */           case '\000':
/*     */           case '\t':
/*     */           case ' ':
/* 247 */             this.e.append(c1);
/*     */             continue;
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void i() {
/* 258 */       if (!f && this.d != h.b.c) throw new AssertionError(); 
/* 259 */       this.e.append(b());
/*     */       
/* 261 */       while (a()) {
/*     */         char c1;
/*     */         
/* 264 */         switch (c1 = c()) {
/*     */           case '\n':
/*     */           case '\f':
/*     */           case '\r':
/*     */             return;
/*     */         } 
/*     */         
/* 271 */         this.e.append(c1);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void j() {
/* 280 */       if (!f && this.d != h.b.d) throw new AssertionError(); 
/* 281 */       char c1 = b();
/* 282 */       this.e.append(c1);
/* 283 */       switch (c1) {
/*     */         
/*     */         case '{':
/*     */         case '}':
/* 287 */           this.c.b(this.e);
/* 288 */           c();
/*     */           return;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 294 */       while (a()) {
/*     */ 
/*     */         
/* 297 */         switch (c1 = c()) {
/*     */           case '\000':
/*     */           case '\004':
/*     */           case '\t':
/*     */           case '\n':
/*     */           case '\f':
/*     */           case '\r':
/*     */           case ' ':
/*     */           case '{':
/*     */           case '}':
/*     */             break;
/*     */         } 
/*     */         
/* 310 */         this.e.append(c1);
/*     */       } 
/*     */ 
/*     */       
/* 314 */       this.c.b(this.e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */