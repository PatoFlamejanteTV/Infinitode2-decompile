/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class TextFormatter
/*     */ {
/*     */   private MessageFormat messageFormat;
/*  31 */   private StringBuilder buffer = new StringBuilder(); public TextFormatter(Locale paramLocale, boolean paramBoolean) {
/*  32 */     if (paramBoolean) this.messageFormat = new MessageFormat("", paramLocale);
/*     */   
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
/*     */   public String format(String paramString, Object... paramVarArgs) {
/*  60 */     if (this.messageFormat != null) {
/*  61 */       this.messageFormat.applyPattern(replaceEscapeChars(paramString));
/*  62 */       return this.messageFormat.format(paramVarArgs);
/*     */     } 
/*  64 */     return simpleFormat(paramString, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String replaceEscapeChars(String paramString) {
/*  73 */     this.buffer.setLength(0);
/*  74 */     boolean bool = false;
/*  75 */     int i = paramString.length();
/*  76 */     for (int j = 0; j < i; j++) {
/*     */       char c;
/*  78 */       if ((c = paramString.charAt(j)) == '\'')
/*  79 */       { bool = true;
/*  80 */         this.buffer.append("''"); }
/*  81 */       else { int k; if (c == '{') {
/*  82 */           k = j + 1;
/*  83 */           while (k < i && paramString.charAt(k) == '{')
/*  84 */             k++; 
/*     */           int m;
/*  86 */           if ((m = (k - j) / 2) > 0) {
/*  87 */             bool = true;
/*  88 */             this.buffer.append('\'');
/*     */             while (true) {
/*  90 */               this.buffer.append('{');
/*  91 */               if (--m <= 0)
/*  92 */               { this.buffer.append('\''); break; } 
/*     */             } 
/*  94 */           }  if ((k - j) % 2 != 0) this.buffer.append('{'); 
/*  95 */           j = k - 1;
/*     */         } else {
/*  97 */           this.buffer.append(k);
/*     */         }  }
/*     */     
/* 100 */     }  return bool ? this.buffer.toString() : paramString;
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
/*     */   private String simpleFormat(String paramString, Object... paramVarArgs) {
/* 116 */     this.buffer.setLength(0);
/* 117 */     boolean bool = false;
/* 118 */     int i = -1;
/* 119 */     int j = paramString.length();
/* 120 */     for (byte b = 0; b < j; b++) {
/* 121 */       char c = paramString.charAt(b);
/* 122 */       if (i < 0) {
/* 123 */         if (c == '{') {
/* 124 */           bool = true;
/* 125 */           if (b + 1 < j && paramString.charAt(b + 1) == '{') {
/* 126 */             this.buffer.append(c);
/* 127 */             b++;
/*     */           } else {
/* 129 */             i = 0;
/*     */           } 
/*     */         } else {
/* 132 */           this.buffer.append(c);
/*     */         }
/*     */       
/* 135 */       } else if (c == '}') {
/* 136 */         if (i >= paramVarArgs.length) throw new IllegalArgumentException("Argument index out of bounds: " + i); 
/* 137 */         if (paramString.charAt(b - 1) == '{')
/* 138 */           throw new IllegalArgumentException("Missing argument index after a left curly brace"); 
/* 139 */         if (paramVarArgs[i] == null) {
/* 140 */           this.buffer.append("null");
/*     */         } else {
/* 142 */           this.buffer.append(paramVarArgs[i].toString());
/* 143 */         }  i = -1;
/*     */       } else {
/* 145 */         if (c < '0' || c > '9')
/* 146 */           throw new IllegalArgumentException("Unexpected '" + c + "' while parsing argument index"); 
/* 147 */         i = i * 10 + c - 48;
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     if (i >= 0) throw new IllegalArgumentException("Unmatched braces in the pattern.");
/*     */     
/* 153 */     return bool ? this.buffer.toString() : paramString;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\TextFormatter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */