/*     */ package com.a.a.b.c;
/*     */ 
/*     */ import com.a.a.b.r;
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
/*     */ public final class k
/*     */   implements r, Serializable
/*     */ {
/*  22 */   private static final f a = f.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private char[] c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k(String paramString) {
/*  52 */     if (paramString == null) {
/*  53 */       throw new IllegalStateException("Null String illegal for SerializedString");
/*     */     }
/*  55 */     this.b = paramString;
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
/*     */   public final String a() {
/*  91 */     return this.b;
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
/*     */   public final char[] b() {
/*     */     char[] arrayOfChar;
/* 106 */     if ((arrayOfChar = this.c) == null) {
/* 107 */       this.c = arrayOfChar = a.a(this.b);
/*     */     }
/* 109 */     return arrayOfChar;
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
/*     */   public final int a(char[] paramArrayOfchar, int paramInt) {
/*     */     char[] arrayOfChar;
/* 148 */     if ((arrayOfChar = this.c) == null) {
/* 149 */       this.c = arrayOfChar = a.a(this.b);
/*     */     }
/* 151 */     int i = arrayOfChar.length;
/* 152 */     if (paramInt + i > paramArrayOfchar.length) {
/* 153 */       return -1;
/*     */     }
/* 155 */     System.arraycopy(arrayOfChar, 0, paramArrayOfchar, paramInt, i);
/* 156 */     return i;
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
/*     */   public final int b(char[] paramArrayOfchar, int paramInt) {
/*     */     String str;
/* 176 */     int i = (str = this.b).length();
/* 177 */     if (paramInt + i > paramArrayOfchar.length) {
/* 178 */       return -1;
/*     */     }
/* 180 */     str.getChars(0, i, paramArrayOfchar, paramInt);
/* 181 */     return i;
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
/*     */   public final String toString() {
/* 255 */     return this.b;
/*     */   }
/*     */   public final int hashCode() {
/* 258 */     return this.b.hashCode();
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 262 */     if (paramObject == this) return true; 
/* 263 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 264 */     paramObject = paramObject;
/* 265 */     return this.b.equals(((k)paramObject).b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */