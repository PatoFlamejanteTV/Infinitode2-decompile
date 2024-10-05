/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.nio.charset.Charset;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class Html5Entities
/*    */ {
/* 17 */   private static final Map<String, String> NAMED_CHARACTER_REFERENCES = readEntities();
/* 18 */   private static final Pattern NUMERIC_PATTERN = Pattern.compile("^&#[Xx]?");
/*    */   
/*    */   private static final String ENTITY_PATH = "/com/vladsch/flexmark/util/html/entities.properties";
/*    */   
/*    */   public static String entityToString(String paramString) {
/*    */     Matcher matcher;
/* 24 */     if ((matcher = NUMERIC_PATTERN.matcher(paramString)).find()) {
/* 25 */       byte b = (matcher.end() == 2) ? 10 : 16;
/*    */       try {
/*    */         int i;
/* 28 */         if ((i = Integer.parseInt(paramString.substring(matcher.end(), paramString.length() - 1), b)) == 0) {
/* 29 */           return "�";
/*    */         }
/* 31 */         return new String(Character.toChars(i));
/* 32 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 33 */         return "�";
/*    */       } 
/*    */     } 
/* 36 */     String str2 = paramString.substring(1, paramString.length() - 1);
/*    */     String str1;
/* 38 */     if ((str1 = NAMED_CHARACTER_REFERENCES.get(str2)) != null) {
/* 39 */       return str1;
/*    */     }
/* 41 */     return paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static BasedSequence entityToSequence(BasedSequence paramBasedSequence) {
/* 47 */     Matcher matcher = NUMERIC_PATTERN.matcher(paramBasedSequence);
/* 48 */     BasedSequence basedSequence = paramBasedSequence.subSequence(0, 0);
/*    */     
/* 50 */     if (matcher.find()) {
/* 51 */       byte b = (matcher.end() == 2) ? 10 : 16;
/*    */       try {
/*    */         int i;
/* 54 */         if ((i = Integer.parseInt(paramBasedSequence.subSequence(matcher.end(), paramBasedSequence.length() - 1).toString(), b)) == 0) {
/* 55 */           return PrefixedSubSequence.prefixOf("�", basedSequence);
/*    */         }
/* 57 */         return PrefixedSubSequence.prefixOf(Arrays.toString(Character.toChars(i)), basedSequence);
/* 58 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 59 */         return PrefixedSubSequence.prefixOf("�", basedSequence);
/*    */       } 
/*    */     } 
/* 62 */     String str2 = paramBasedSequence.subSequence(1, paramBasedSequence.length() - 1).toString();
/*    */     String str1;
/* 64 */     if ((str1 = NAMED_CHARACTER_REFERENCES.get(str2)) != null) {
/* 65 */       return PrefixedSubSequence.prefixOf(str1, basedSequence);
/*    */     }
/* 67 */     return paramBasedSequence;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, String> readEntities() {
/* 73 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 74 */     InputStream inputStream = Html5Entities.class.getResourceAsStream("/com/vladsch/flexmark/util/html/entities.properties");
/* 75 */     Charset charset = StandardCharsets.UTF_8;
/*    */     
/*    */     try {
/* 78 */       InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
/* 79 */       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
/*    */       String str;
/* 81 */       while ((str = bufferedReader.readLine()) != null) {
/* 82 */         if (str.length() != 0)
/*    */         
/*    */         { 
/* 85 */           int i = str.indexOf("=");
/* 86 */           String str1 = str.substring(0, i);
/* 87 */           str = str.substring(i + 1);
/* 88 */           hashMap.put(str1, str); } 
/*    */       } 
/* 90 */     } catch (IOException iOException) {
/* 91 */       throw new IllegalStateException("Failed reading data for HTML named character references", iOException);
/*    */     } 
/* 93 */     hashMap.put("NewLine", "\n");
/* 94 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\Html5Entities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */