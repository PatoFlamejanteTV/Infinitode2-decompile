/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.StringBuilder;
/*    */ import java.text.MessageFormat;
/*    */ import java.util.Locale;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class I18NTextFormatter
/*    */ {
/*    */   private MessageFormat a;
/* 13 */   private StringBuilder b = new StringBuilder(); public I18NTextFormatter(Locale paramLocale, boolean paramBoolean) {
/* 14 */     if (paramBoolean) this.a = new MessageFormat("", paramLocale); 
/*    */   }
/*    */   
/*    */   public String format(String paramString, Object... paramVarArgs) {
/* 18 */     if (this.a != null) {
/* 19 */       this.a.applyPattern(a(paramString));
/* 20 */       return this.a.format(paramVarArgs);
/*    */     } 
/* 22 */     return a(paramString, paramVarArgs);
/*    */   }
/*    */   
/*    */   private String a(String paramString) {
/* 26 */     this.b.setLength(0);
/* 27 */     boolean bool = false;
/* 28 */     int i = paramString.length();
/* 29 */     for (int j = 0; j < i; j++) {
/*    */       char c;
/* 31 */       if ((c = paramString.charAt(j)) == '\'')
/* 32 */       { bool = true;
/* 33 */         this.b.append("''"); }
/* 34 */       else { int k; if (c == '{') {
/* 35 */           k = j + 1;
/* 36 */           while (k < i && paramString.charAt(k) == '{')
/* 37 */             k++; 
/*    */           int m;
/* 39 */           if ((m = (k - j) / 2) > 0) {
/* 40 */             bool = true;
/* 41 */             this.b.append('\'');
/*    */             while (true) {
/* 43 */               this.b.append('{');
/* 44 */               if (--m <= 0)
/* 45 */               { this.b.append('\''); break; } 
/*    */             } 
/* 47 */           }  if ((k - j) % 2 != 0) this.b.append('{'); 
/* 48 */           j = k - 1;
/*    */         } else {
/* 50 */           this.b.append(k);
/*    */         }  }
/*    */     
/* 53 */     }  return bool ? this.b.toString() : paramString;
/*    */   }
/*    */   
/*    */   private String a(String paramString, Object... paramVarArgs) {
/* 57 */     this.b.setLength(0);
/* 58 */     boolean bool = false;
/* 59 */     int i = -1;
/* 60 */     int j = paramString.length();
/* 61 */     for (byte b = 0; b < j; b++) {
/* 62 */       char c = paramString.charAt(b);
/* 63 */       if (i < 0) {
/* 64 */         if (c == '{') {
/* 65 */           bool = true;
/* 66 */           if (b + 1 < j && paramString.charAt(b + 1) == '{') {
/* 67 */             this.b.append(c);
/* 68 */             b++;
/*    */           } else {
/* 70 */             i = 0;
/*    */           } 
/*    */         } else {
/* 73 */           this.b.append(c);
/*    */         }
/*    */       
/* 76 */       } else if (c == '}') {
/* 77 */         if (i >= paramVarArgs.length)
/* 78 */           throw new IllegalArgumentException("Argument index out of bounds: " + i); 
/* 79 */         if (paramString.charAt(b - 1) == '{')
/* 80 */           throw new IllegalArgumentException("Missing argument index after a left curly brace"); 
/* 81 */         if (paramVarArgs[i] == null) {
/* 82 */           this.b.append("null");
/*    */         } else {
/* 84 */           this.b.append(paramVarArgs[i].toString());
/* 85 */         }  i = -1;
/*    */       } else {
/* 87 */         if (c < '0' || c > '9')
/* 88 */           throw new IllegalArgumentException("Unexpected '" + c + "' while parsing argument index"); 
/* 89 */         i = i * 10 + c - 48;
/*    */       } 
/*    */     } 
/*    */     
/* 93 */     if (i >= 0) throw new IllegalArgumentException("Unmatched braces in the pattern.");
/*    */     
/* 95 */     return bool ? this.b.toString() : paramString;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\I18NTextFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */