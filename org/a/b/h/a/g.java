/*     */ package org.a.b.h.a;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.a.b.h.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */   implements a
/*     */ {
/*     */   private static String a(String paramString) {
/*     */     Process process;
/*  42 */     Runtime runtime = Runtime.getRuntime();
/*  43 */     if (paramString.startsWith("Windows 9")) {
/*     */       
/*  45 */       process = runtime.exec("command.com /c echo %windir%");
/*     */     }
/*     */     else {
/*     */       
/*  49 */       process = runtime.exec("cmd.exe /c echo %windir%");
/*     */     } 
/*     */     
/*     */     BufferedReader bufferedReader;
/*  53 */     String str = (bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), b.a))).readLine();
/*  54 */     bufferedReader.close();
/*  55 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<File> a() {
/*     */     File file;
/*  66 */     ArrayList<File> arrayList = new ArrayList();
/*  67 */     String str1 = null;
/*     */     
/*     */     try {
/*  70 */       str1 = System.getProperty("env.windir");
/*     */     }
/*  72 */     catch (SecurityException securityException) {}
/*     */ 
/*     */ 
/*     */     
/*  76 */     String str2 = System.getProperty("os.name");
/*  77 */     if (str1 == null) {
/*     */       
/*     */       try {
/*     */         
/*  81 */         str1 = a(str2);
/*     */       }
/*  83 */       catch (IOException iOException) {
/*     */ 
/*     */       
/*     */       }
/*  87 */       catch (SecurityException securityException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     if (str1 != null) {
/*     */ 
/*     */       
/*  97 */       if (str1.endsWith("/"))
/*     */       {
/*  99 */         str1 = str1.substring(0, str1.length() - 1);
/*     */       }
/*     */       
/* 102 */       if ((file = new File(str1 + File.separator + "FONTS")).exists() && file.canRead())
/*     */       {
/* 104 */         arrayList.add(file);
/*     */       }
/*     */       File file1;
/* 107 */       if ((file1 = new File(str1.substring(0, 2) + File.separator + "PSFONTS")).exists() && file1.canRead())
/*     */       {
/* 109 */         arrayList.add(file1);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 114 */       str1 = file.endsWith("NT") ? "WINNT" : "WINDOWS";
/*     */       char c;
/* 116 */       for (c = 'C'; c <= 'E'; c = (char)(c + 1)) {
/*     */         
/* 118 */         file = new File(c + ":" + File.separator + str1 + File.separator + "FONTS");
/*     */ 
/*     */         
/*     */         try {
/* 122 */           if (file.exists() && file.canRead()) {
/*     */             
/* 124 */             arrayList.add(file);
/*     */             
/*     */             break;
/*     */           } 
/* 128 */         } catch (SecurityException securityException) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       for (c = 'C'; c <= 'E'; c = (char)(c + 1)) {
/*     */         
/* 136 */         File file1 = new File(c + ":" + File.separator + "PSFONTS");
/*     */         
/*     */         try {
/* 139 */           if (file1.exists() && file1.canRead()) {
/*     */             
/* 141 */             arrayList.add(file1);
/*     */             
/*     */             break;
/*     */           } 
/* 145 */         } catch (SecurityException securityException) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 151 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\h\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */