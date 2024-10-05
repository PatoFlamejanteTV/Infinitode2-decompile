/*     */ package com.prineside.luaj.parser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TokenMgrError
/*     */   extends Error
/*     */ {
/*     */   private static String a(String paramString) {
/*  51 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  53 */     for (byte b = 0; b < paramString.length(); b++) {
/*  54 */       char c; String str; switch (paramString.charAt(b)) {
/*     */         case '\000':
/*     */           break;
/*     */         
/*     */         case '\b':
/*  59 */           stringBuffer.append("\\b");
/*     */           break;
/*     */         case '\t':
/*  62 */           stringBuffer.append("\\t");
/*     */           break;
/*     */         case '\n':
/*  65 */           stringBuffer.append("\\n");
/*     */           break;
/*     */         case '\f':
/*  68 */           stringBuffer.append("\\f");
/*     */           break;
/*     */         case '\r':
/*  71 */           stringBuffer.append("\\r");
/*     */           break;
/*     */         case '"':
/*  74 */           stringBuffer.append("\\\"");
/*     */           break;
/*     */         case '\'':
/*  77 */           stringBuffer.append("\\'");
/*     */           break;
/*     */         case '\\':
/*  80 */           stringBuffer.append("\\\\");
/*     */           break;
/*     */         default:
/*  83 */           if ((c = paramString.charAt(b)) < ' ' || c > '~') {
/*  84 */             str = "0000" + Integer.toString(c, 16);
/*  85 */             stringBuffer.append("\\u" + str.substring(str.length() - 4, str.length())); break;
/*     */           } 
/*  87 */           stringBuffer.append(str);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/*  92 */     return stringBuffer.toString();
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
/*     */   private static String a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString, char paramChar) {
/* 108 */     return "Lexical error at line " + paramInt1 + ", column " + paramInt2 + ".  Encountered: " + (
/*     */ 
/*     */       
/* 111 */       paramBoolean ? "<EOF> " : ("\"" + a(String.valueOf(paramChar)) + "\" (" + paramChar + "), ")) + "after : \"" + 
/* 112 */       a(paramString) + "\"";
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
/*     */   public String getMessage() {
/* 125 */     return super.getMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TokenMgrError() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TokenMgrError(String paramString, int paramInt) {
/* 138 */     super(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TokenMgrError(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, char paramChar, int paramInt4) {
/* 144 */     this(a(paramBoolean, paramInt2, paramInt3, paramString, paramChar), paramInt4);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\parser\TokenMgrError.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */