/*    */ package com.vladsch.flexmark.util.misc;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Files;
/*    */ 
/*    */ public class FileUtil
/*    */ {
/*    */   public static boolean isChildOf(File paramFile1, File paramFile2) {
/* 14 */     return Utils.suffixWith(paramFile1.getPath(), File.separator).startsWith(Utils.suffixWith(paramFile2.getPath(), File.separator));
/*    */   }
/*    */   
/*    */   public static String getNameOnly(File paramFile) {
/*    */     String str;
/*    */     int i;
/* 20 */     if ((i = (str = paramFile.getName()).lastIndexOf('.')) > 0 && i > str.lastIndexOf(File.separatorChar)) return str.substring(0, i);  return str;
/*    */   }
/*    */   
/*    */   public static String getDotExtension(File paramFile) {
/*    */     String str;
/*    */     int i;
/* 26 */     if ((i = (str = paramFile.getName()).lastIndexOf('.')) > 0 && i > str.lastIndexOf(File.separatorChar)) return str.substring(i);  return "";
/*    */   }
/*    */   
/*    */   public static String pathSlash(File paramFile) {
/*    */     String str;
/*    */     int i;
/* 32 */     return ((i = (str = paramFile.getPath()).lastIndexOf(File.separatorChar)) != -1) ? str.substring(0, i + 1) : "";
/*    */   }
/*    */   
/*    */   public static File plus(File paramFile, String paramString) {
/* 36 */     return new File(paramFile, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getFileContent(File paramFile) {
/* 41 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/*    */     try {
/* 44 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 45 */       InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
/* 46 */       BufferedReader bufferedReader = new BufferedReader(inputStreamReader); String str;
/* 47 */       while ((str = bufferedReader.readLine()) != null) {
/* 48 */         stringBuilder.append(str);
/* 49 */         stringBuilder.append("\n");
/*    */       } 
/* 51 */       bufferedReader.close();
/* 52 */       inputStreamReader.close();
/* 53 */       fileInputStream.close();
/* 54 */       return stringBuilder.toString();
/* 55 */     } catch (IOException iOException2) {
/* 56 */       IOException iOException1; (iOException1 = null).printStackTrace();
/*    */       
/* 58 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String getFileContentWithExceptions(File paramFile) {
/* 63 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 65 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 66 */     InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
/* 67 */     BufferedReader bufferedReader = new BufferedReader(inputStreamReader); String str;
/* 68 */     while ((str = bufferedReader.readLine()) != null) {
/* 69 */       stringBuilder.append(str);
/* 70 */       stringBuilder.append("\n");
/*    */     } 
/* 72 */     bufferedReader.close();
/* 73 */     inputStreamReader.close();
/* 74 */     fileInputStream.close();
/* 75 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public static byte[] getFileContentBytes(File paramFile) {
/*    */     try {
/* 81 */       return Files.readAllBytes(paramFile.toPath());
/* 82 */     } catch (IOException iOException) {
/* 83 */       (paramFile = null).printStackTrace();
/*    */       
/* 85 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static byte[] getFileContentBytesWithExceptions(File paramFile) {
/* 90 */     return Files.readAllBytes(paramFile.toPath());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\FileUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */