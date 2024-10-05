/*     */ package com.a.a.b;
/*     */ 
/*     */ import com.a.a.b.c.d;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class j
/*     */   implements Serializable
/*     */ {
/*  38 */   public static final j a = new j(d.a(), -1L, -1L, -1, -1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long c;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int e;
/*     */ 
/*     */ 
/*     */   
/*     */   private d f;
/*     */ 
/*     */ 
/*     */   
/*     */   private transient String g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(d paramd, long paramLong, int paramInt1, int paramInt2) {
/*  72 */     this(paramd, -1L, -1L, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(d paramd, long paramLong1, long paramLong2, int paramInt1, int paramInt2) {
/*  79 */     if (paramd == null) {
/*  80 */       paramd = d.a();
/*     */     }
/*  82 */     this.f = paramd;
/*  83 */     this.b = paramLong1;
/*  84 */     this.c = paramLong2;
/*  85 */     this.d = paramInt1;
/*  86 */     this.e = paramInt2;
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
/*     */   private String a() {
/* 190 */     if (this.g == null) {
/* 191 */       this.g = this.f.d();
/*     */     }
/* 193 */     return this.g;
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
/*     */   private StringBuilder a(StringBuilder paramStringBuilder) {
/* 216 */     if (this.f.b()) {
/* 217 */       paramStringBuilder.append("line: ");
/*     */       
/* 219 */       if (this.d >= 0) {
/* 220 */         paramStringBuilder.append(this.d);
/*     */       } else {
/* 222 */         paramStringBuilder.append("UNKNOWN");
/*     */       } 
/* 224 */       paramStringBuilder.append(", column: ");
/* 225 */       if (this.e >= 0) {
/* 226 */         paramStringBuilder.append(this.e);
/*     */       } else {
/* 228 */         paramStringBuilder.append("UNKNOWN");
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 234 */     else if (this.d > 0) {
/* 235 */       paramStringBuilder.append("line: ").append(this.d);
/* 236 */       if (this.e > 0) {
/* 237 */         paramStringBuilder.append(", column: ");
/* 238 */         paramStringBuilder.append(this.e);
/*     */       } 
/*     */     } else {
/* 241 */       paramStringBuilder.append("byte offset: #");
/*     */ 
/*     */       
/* 244 */       if (this.b >= 0L) {
/* 245 */         paramStringBuilder.append(this.b);
/*     */       } else {
/* 247 */         paramStringBuilder.append("UNKNOWN");
/*     */       } 
/*     */     } 
/*     */     
/* 251 */     return paramStringBuilder;
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
/*     */   public int hashCode() {
/*     */     int i;
/* 268 */     return i = (i = (i = (i = (i = (this.f == null) ? 1 : 2) ^ this.d) + this.e) ^ (int)this.c) + (int)this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 274 */     if (paramObject == this) return true; 
/* 275 */     if (paramObject == null) return false; 
/* 276 */     if (!(paramObject instanceof j)) return false; 
/* 277 */     paramObject = paramObject;
/*     */     
/* 279 */     if (this.f == null) {
/* 280 */       if (((j)paramObject).f != null) return false; 
/* 281 */     } else if (!this.f.equals(((j)paramObject).f)) {
/* 282 */       return false;
/*     */     } 
/*     */     
/* 285 */     return (this.d == ((j)paramObject).d && this.e == ((j)paramObject).e && this.c == ((j)paramObject).c && this.b == ((j)paramObject).b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 295 */     String str = a();
/*     */ 
/*     */ 
/*     */     
/* 299 */     StringBuilder stringBuilder = (new StringBuilder(40 + str.length())).append("[Source: ").append(str).append("; ");
/* 300 */     return a(stringBuilder)
/* 301 */       .append(']')
/* 302 */       .toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */