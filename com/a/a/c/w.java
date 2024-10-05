/*     */ package com.a.a.c;
/*     */ 
/*     */ import com.a.a.b.c.k;
/*     */ import com.a.a.b.g.g;
/*     */ import com.a.a.b.r;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class w
/*     */   implements Serializable
/*     */ {
/*  29 */   public static final w a = new w("", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   public static final w b = new w(new String(""), null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private r e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w(String paramString) {
/*  61 */     this(paramString, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private w(String paramString1, String paramString2) {
/*  66 */     this.c = i.a(paramString1);
/*  67 */     this.d = paramString2;
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
/*     */   public static w a(String paramString) {
/*  92 */     if (paramString == null || paramString.isEmpty()) {
/*  93 */       return a;
/*     */     }
/*  95 */     return new w(g.a.a(paramString), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static w a(String paramString1, String paramString2) {
/* 100 */     if (paramString1 == null) {
/* 101 */       paramString1 = "";
/*     */     }
/* 103 */     if (paramString2 == null && paramString1.isEmpty()) {
/* 104 */       return a;
/*     */     }
/* 106 */     return new w(g.a.a(paramString1), paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final w a() {
/* 111 */     if (this.c.isEmpty()) {
/* 112 */       return this;
/*     */     }
/*     */     String str;
/* 115 */     if ((str = g.a.a(this.c)) == this.c) {
/* 116 */       return this;
/*     */     }
/* 118 */     return new w(str, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final w b(String paramString) {
/* 127 */     if (paramString == null) {
/* 128 */       paramString = "";
/*     */     }
/* 130 */     if (paramString.equals(this.c)) {
/* 131 */       return this;
/*     */     }
/* 133 */     return new w(paramString, this.d);
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
/*     */   public final String b() {
/* 158 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final r a(q<?> paramq) {
/*     */     r r1;
/* 169 */     if ((r1 = this.e) == null) {
/* 170 */       if (paramq == null) {
/* 171 */         k k = new k(this.c);
/*     */       } else {
/* 173 */         r1 = q.a(this.c);
/*     */       } 
/* 175 */       this.e = r1;
/*     */     } 
/* 177 */     return r1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 185 */     return !this.c.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c(String paramString) {
/* 193 */     return this.c.equals(paramString);
/*     */   }
/*     */   
/*     */   public final boolean d() {
/* 197 */     return (this.d != null);
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
/*     */   public final boolean e() {
/* 209 */     return (this.d == null && this.c.isEmpty());
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
/*     */   public final boolean equals(Object paramObject) {
/* 221 */     if (paramObject == this) return true; 
/* 222 */     if (paramObject == null) return false;
/*     */ 
/*     */ 
/*     */     
/* 226 */     if (paramObject.getClass() != getClass()) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     paramObject = paramObject;
/* 232 */     if (this.c == null) {
/* 233 */       if (((w)paramObject).c != null) return false; 
/* 234 */     } else if (!this.c.equals(((w)paramObject).c)) {
/* 235 */       return false;
/*     */     } 
/* 237 */     if (this.d == null) {
/* 238 */       return (((w)paramObject).d == null);
/*     */     }
/* 240 */     return this.d.equals(((w)paramObject).d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 245 */     if (this.d == null) {
/* 246 */       return this.c.hashCode();
/*     */     }
/* 248 */     return this.d.hashCode() ^ this.c.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 253 */     if (this.d == null) {
/* 254 */       return this.c;
/*     */     }
/* 256 */     return "{" + this.d + "}" + this.c;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */