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
/*     */ public class ParseException
/*     */   extends Exception
/*     */ {
/*     */   public Token currentToken;
/*     */   public int[][] expectedTokenSequences;
/*     */   public String[] tokenImage;
/*     */   
/*     */   public ParseException(Token paramToken, int[][] paramArrayOfint, String[] paramArrayOfString) {
/*  34 */     super(a(paramToken, paramArrayOfint, paramArrayOfString));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     System.getProperty("line.separator", "\n"); this.currentToken = paramToken; this.expectedTokenSequences = paramArrayOfint; this.tokenImage = paramArrayOfString; } public ParseException() { System.getProperty("line.separator", "\n"); } public ParseException(String paramString) { super(paramString); System.getProperty("line.separator", "\n"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(String paramString) {
/* 142 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 144 */     for (byte b = 0; b < paramString.length(); b++) {
/* 145 */       char c; String str; switch (paramString.charAt(b)) {
/*     */         case '\000':
/*     */           break;
/*     */         
/*     */         case '\b':
/* 150 */           stringBuffer.append("\\b");
/*     */           break;
/*     */         case '\t':
/* 153 */           stringBuffer.append("\\t");
/*     */           break;
/*     */         case '\n':
/* 156 */           stringBuffer.append("\\n");
/*     */           break;
/*     */         case '\f':
/* 159 */           stringBuffer.append("\\f");
/*     */           break;
/*     */         case '\r':
/* 162 */           stringBuffer.append("\\r");
/*     */           break;
/*     */         case '"':
/* 165 */           stringBuffer.append("\\\"");
/*     */           break;
/*     */         case '\'':
/* 168 */           stringBuffer.append("\\'");
/*     */           break;
/*     */         case '\\':
/* 171 */           stringBuffer.append("\\\\");
/*     */           break;
/*     */         default:
/* 174 */           if ((c = paramString.charAt(b)) < ' ' || c > '~') {
/* 175 */             str = "0000" + Integer.toString(c, 16);
/* 176 */             stringBuffer.append("\\u" + str.substring(str.length() - 4, str.length())); break;
/*     */           } 
/* 178 */           stringBuffer.append(str);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 183 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private static String a(Token paramToken, int[][] paramArrayOfint, String[] paramArrayOfString) {
/*     */     String str1 = System.getProperty("line.separator", "\n");
/*     */     StringBuffer stringBuffer = new StringBuffer();
/*     */     int i = 0;
/*     */     for (byte b1 = 0; b1 < paramArrayOfint.length; b1++) {
/*     */       if (i < (paramArrayOfint[b1]).length)
/*     */         i = (paramArrayOfint[b1]).length; 
/*     */       for (byte b = 0; b < (paramArrayOfint[b1]).length; b++)
/*     */         stringBuffer.append(paramArrayOfString[paramArrayOfint[b1][b]]).append(' '); 
/*     */       if (paramArrayOfint[b1][(paramArrayOfint[b1]).length - 1] != 0)
/*     */         stringBuffer.append("..."); 
/*     */       stringBuffer.append(str1).append("    ");
/*     */     } 
/*     */     String str2 = "Encountered \"";
/*     */     Token token = paramToken.next;
/*     */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       if (b2 != 0)
/*     */         str2 = str2 + " "; 
/*     */       if (token.kind == 0) {
/*     */         str2 = str2 + paramArrayOfString[0];
/*     */         break;
/*     */       } 
/*     */       str2 = str2 + " " + paramArrayOfString[token.kind];
/*     */       str2 = str2 + " \"";
/*     */       str2 = str2 + a(token.image);
/*     */       str2 = str2 + " \"";
/*     */       token = token.next;
/*     */     } 
/*     */     str2 = str2 + "\" at line " + paramToken.next.beginLine + ", column " + paramToken.next.beginColumn;
/*     */     str2 = str2 + "." + str1;
/*     */     if (paramArrayOfint.length == 1) {
/*     */       str2 = str2 + "Was expecting:" + str1 + "    ";
/*     */     } else {
/*     */       str2 = str2 + "Was expecting one of:" + str1 + "    ";
/*     */     } 
/*     */     return str2 = str2 + stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\parser\ParseException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */