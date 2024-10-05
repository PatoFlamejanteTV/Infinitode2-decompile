/*     */ package org.a.b.g;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class e
/*     */ {
/*  50 */   private static final a a = c.a(e.class);
/*     */   
/*     */   private final ByteBuffer b;
/*     */   private b c;
/*  54 */   private int d = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   e(byte[] paramArrayOfbyte) {
/*  63 */     this.b = ByteBuffer.wrap(paramArrayOfbyte);
/*  64 */     this.c = a((b)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b a() {
/*  73 */     b b1 = this.c;
/*     */     
/*  75 */     this.c = a(b1);
/*  76 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b b() {
/*  85 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private char c() {
/*  93 */     return (char)this.b.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b a(b paramb) {
/*     */     while (true) {
/*     */       String str;
/* 105 */       char c = Character.MIN_VALUE;
/* 106 */       while (this.b.hasRemaining()) {
/*     */         char c1;
/*     */ 
/*     */ 
/*     */         
/* 111 */         if ((c1 = c()) == '%') {
/*     */ 
/*     */           
/* 114 */           f(); continue;
/*     */         } 
/* 116 */         if (c1 == '(')
/*     */         {
/* 118 */           return g();
/*     */         }
/* 120 */         if (c1 == ')')
/*     */         {
/*     */           
/* 123 */           throw new IOException("unexpected closing parenthesis");
/*     */         }
/* 125 */         if (c1 == '[')
/*     */         {
/* 127 */           return new b(c1, b.f);
/*     */         }
/* 129 */         if (c1 == '{')
/*     */         {
/* 131 */           return new b(c1, b.h);
/*     */         }
/* 133 */         if (c1 == ']')
/*     */         {
/* 135 */           return new b(c1, b.g);
/*     */         }
/* 137 */         if (c1 == '}')
/*     */         {
/* 139 */           return new b(c1, b.i);
/*     */         }
/* 141 */         if (c1 == '/')
/*     */         {
/* 143 */           return new b(e(), b.c);
/*     */         }
/* 145 */         if (c1 == '<') {
/*     */ 
/*     */           
/* 148 */           if ((c = c()) == c1)
/*     */           {
/* 150 */             return new b("<<", b.k);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 155 */           this.b.position(this.b.position() - 1);
/* 156 */           return new b(c1, b.b);
/*     */         } 
/*     */         
/* 159 */         if (c1 == '>') {
/*     */ 
/*     */           
/* 162 */           if ((c = c()) == c1)
/*     */           {
/* 164 */             return new b(">>", b.l);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 169 */           this.b.position(this.b.position() - 1);
/* 170 */           return new b(c1, b.b);
/*     */         } 
/*     */         
/* 173 */         if (Character.isWhitespace(c1)) {
/*     */           
/* 175 */           c = '\001'; continue;
/*     */         } 
/* 177 */         if (c1 == '\000') {
/*     */ 
/*     */           
/* 180 */           c = '\001';
/*     */           
/*     */           continue;
/*     */         } 
/* 184 */         this.b.position(this.b.position() - 1);
/*     */         
/*     */         b b1;
/*     */         
/* 188 */         if ((b1 = d()) != null)
/*     */         {
/* 190 */           return b1;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 196 */         if ((str = e()) == null)
/*     */         {
/*     */           
/* 199 */           throw new a("Could not read token at position " + this.b
/* 200 */               .position());
/*     */         }
/*     */         
/* 203 */         if (str.equals("RD") || str.equals("-|")) {
/*     */ 
/*     */           
/* 206 */           if (paramb.b() == b.e)
/*     */           {
/* 208 */             return a(paramb.c());
/*     */           }
/*     */ 
/*     */           
/* 212 */           throw new IOException("expected INTEGER before -| or RD");
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 217 */         return new b(str, b.b);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 223 */       if (str == null) {
/* 224 */         return null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private b d() {
/*     */     Integer integer;
/* 232 */     this.b.mark();
/*     */     
/* 234 */     StringBuilder stringBuilder1 = new StringBuilder();
/* 235 */     StringBuilder stringBuilder2 = null;
/* 236 */     char c = c();
/* 237 */     boolean bool = false;
/*     */ 
/*     */     
/* 240 */     if (c == '+' || c == '-') {
/*     */       
/* 242 */       stringBuilder1.append(c);
/* 243 */       c = c();
/*     */     } 
/*     */ 
/*     */     
/* 247 */     while (Character.isDigit(c)) {
/*     */       
/* 249 */       stringBuilder1.append(c);
/* 250 */       c = c();
/* 251 */       bool = true;
/*     */     } 
/*     */ 
/*     */     
/* 255 */     if (c == '.') {
/*     */       
/* 257 */       stringBuilder1.append(c);
/* 258 */       c = c();
/*     */     }
/* 260 */     else if (c == '#') {
/*     */ 
/*     */       
/* 263 */       stringBuilder2 = stringBuilder1;
/* 264 */       stringBuilder1 = new StringBuilder();
/* 265 */       c = c();
/*     */     } else {
/* 267 */       if (stringBuilder1.length() == 0 || !bool) {
/*     */ 
/*     */         
/* 270 */         this.b.reset();
/* 271 */         return null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 276 */       this.b.position(this.b.position() - 1);
/* 277 */       return new b(stringBuilder1.toString(), b.e);
/*     */     } 
/*     */ 
/*     */     
/* 281 */     if (Character.isDigit(c)) {
/*     */       
/* 283 */       stringBuilder1.append(c);
/* 284 */       c = c();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 289 */       this.b.reset();
/* 290 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 294 */     while (Character.isDigit(c)) {
/*     */       
/* 296 */       stringBuilder1.append(c);
/* 297 */       c = c();
/*     */     } 
/*     */ 
/*     */     
/* 301 */     if (c == 'E') {
/*     */       
/* 303 */       stringBuilder1.append(c);
/*     */ 
/*     */ 
/*     */       
/* 307 */       if ((c = c()) == '-') {
/*     */         
/* 309 */         stringBuilder1.append(c);
/* 310 */         c = c();
/*     */       } 
/*     */ 
/*     */       
/* 314 */       if (Character.isDigit(c)) {
/*     */         
/* 316 */         stringBuilder1.append(c);
/* 317 */         c = c();
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 322 */         this.b.reset();
/* 323 */         return null;
/*     */       } 
/*     */ 
/*     */       
/* 327 */       while (Character.isDigit(c)) {
/*     */         
/* 329 */         stringBuilder1.append(c);
/* 330 */         c = c();
/*     */       } 
/*     */     } 
/*     */     
/* 334 */     this.b.position(this.b.position() - 1);
/* 335 */     if (stringBuilder2 != null) {
/*     */       
/* 337 */       integer = Integer.valueOf(Integer.parseInt(stringBuilder1.toString(), Integer.parseInt(stringBuilder2.toString())));
/* 338 */       return new b(integer.toString(), b.e);
/*     */     } 
/* 340 */     return new b(integer.toString(), b.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String e() {
/* 349 */     StringBuilder stringBuilder = new StringBuilder();
/* 350 */     while (this.b.hasRemaining()) {
/*     */       
/* 352 */       this.b.mark();
/*     */       char c;
/* 354 */       if (Character.isWhitespace(c = c()) || c == '(' || c == ')' || c == '<' || c == '>' || c == '[' || c == ']' || c == '{' || c == '}' || c == '/' || c == '%') {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 361 */         this.b.reset();
/*     */         
/*     */         break;
/*     */       } 
/*     */       
/* 366 */       stringBuilder.append(c);
/*     */     } 
/*     */     
/*     */     String str;
/* 370 */     if ((str = stringBuilder.toString()).length() == 0)
/*     */     {
/* 372 */       return null;
/*     */     }
/* 374 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String f() {
/* 382 */     StringBuilder stringBuilder = new StringBuilder();
/* 383 */     while (this.b.hasRemaining()) {
/*     */       char c;
/*     */       
/* 386 */       if ((c = c()) != '\r' && c != '\n')
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 392 */         stringBuilder.append(c);
/*     */       }
/*     */     } 
/* 395 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b g() {
/* 403 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 405 */     while (this.b.hasRemaining()) {
/*     */       Integer integer;
/*     */       
/*     */       char c;
/*     */       
/* 410 */       switch (c = c()) {
/*     */         
/*     */         case '(':
/* 413 */           this.d++;
/* 414 */           stringBuilder.append('(');
/*     */           continue;
/*     */         case ')':
/* 417 */           if (this.d == 0)
/*     */           {
/*     */             
/* 420 */             return new b(stringBuilder.toString(), b.a);
/*     */           }
/* 422 */           stringBuilder.append(')');
/* 423 */           this.d--;
/*     */           continue;
/*     */ 
/*     */         
/*     */         case '\\':
/* 428 */           switch (c = c()) {
/*     */             case 'n':
/*     */             case 'r':
/* 431 */               stringBuilder.append("\n"); break;
/* 432 */             case 't': stringBuilder.append('\t'); break;
/* 433 */             case 'b': stringBuilder.append('\b'); break;
/* 434 */             case 'f': stringBuilder.append('\f'); break;
/* 435 */             case '\\': stringBuilder.append('\\'); break;
/* 436 */             case '(': stringBuilder.append('('); break;
/* 437 */             case ')': stringBuilder.append(')');
/*     */               break;
/*     */           } 
/* 440 */           if (Character.isDigit(c)) {
/*     */             String str;
/*     */             
/* 443 */             integer = Integer.valueOf(Integer.parseInt(str = String.valueOf(new char[] { c, c(), c() }, ), 8));
/* 444 */             stringBuilder.append((char)integer.intValue());
/*     */           } 
/*     */           continue;
/*     */         case '\n':
/*     */         case '\r':
/* 449 */           stringBuilder.append("\n");
/*     */           continue;
/*     */       } 
/* 452 */       stringBuilder.append(integer);
/*     */     } 
/*     */ 
/*     */     
/* 456 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b a(int paramInt) {
/* 464 */     this.b.get();
/* 465 */     byte[] arrayOfByte = new byte[paramInt];
/* 466 */     this.b.get(arrayOfByte);
/* 467 */     return new b(arrayOfByte, b.j);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */