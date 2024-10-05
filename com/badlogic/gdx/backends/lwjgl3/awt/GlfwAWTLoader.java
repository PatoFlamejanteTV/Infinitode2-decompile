/*     */ package com.badlogic.gdx.backends.lwjgl3.awt;
/*     */ 
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import java.util.zip.CRC32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GlfwAWTLoader
/*     */ {
/*  34 */   public static boolean isMac = System.getProperty("os.name").contains("Mac");
/*     */   
/*  36 */   private static final Random random = new Random();
/*     */   
/*     */   public static void closeQuietly(Closeable paramCloseable) {
/*  39 */     if (paramCloseable != null) {
/*     */       try {
/*  41 */         paramCloseable.close(); return;
/*  42 */       } catch (Throwable throwable) {}
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static String randomUUID() {
/*  48 */     return (new UUID(random.nextLong(), random.nextLong())).toString();
/*     */   }
/*     */   
/*     */   public static String crc(InputStream paramInputStream) {
/*  52 */     if (paramInputStream == null) throw new IllegalArgumentException("input cannot be null."); 
/*  53 */     null = new CRC32();
/*  54 */     byte[] arrayOfByte = new byte[4096];
/*     */ 
/*     */     
/*     */     try { int i;
/*  58 */       while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/*  59 */         null.update(arrayOfByte, 0, i);
/*     */       } }
/*  61 */     catch (Exception exception) {  }
/*     */     finally
/*  63 */     { closeQuietly(paramInputStream); }
/*     */     
/*  65 */     return Long.toString(SYNTHETIC_LOCAL_VARIABLE_1.getValue(), 16);
/*     */   }
/*     */   
/*     */   private static File extractFile(String paramString, File paramFile) {
/*     */     try {
/*  70 */       if (!paramFile.getParentFile().exists() && !paramFile.getParentFile().mkdirs()) throw new GdxRuntimeException("Couldn't create ANGLE native library output directory " + paramFile
/*  71 */             .getParentFile().getAbsolutePath()); 
/*  72 */       FileOutputStream fileOutputStream = null;
/*  73 */       InputStream inputStream = null;
/*     */       
/*     */       try {
/*  76 */         fileOutputStream = new FileOutputStream(paramFile);
/*  77 */         inputStream = GlfwAWTLoader.class.getResourceAsStream("/" + paramString);
/*  78 */         byte[] arrayOfByte = new byte[4096];
/*     */         
/*     */         int i;
/*  81 */         while ((i = inputStream.read(arrayOfByte)) != -1) {
/*  82 */           fileOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/*  84 */         return paramFile;
/*     */       } finally {
/*  86 */         closeQuietly(fileOutputStream);
/*  87 */         closeQuietly(inputStream);
/*     */       } 
/*  89 */     } catch (Throwable throwable) {
/*  90 */       throw new GdxRuntimeException("Couldn't load ANGLE shared library " + paramString, throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static File getExtractedFile(String paramString1, String paramString2) {
/*     */     File file1;
/* 100 */     if (canWrite(file1 = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + paramString1, paramString2))) return file1;
/*     */ 
/*     */     
/*     */     try {
/*     */       File file;
/* 105 */       if ((file = File.createTempFile(paramString1, null)).delete() && 
/*     */         
/* 107 */         canWrite(file = new File(file, paramString2))) return file;
/*     */     
/* 109 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/*     */     File file2;
/*     */     
/* 114 */     if (canWrite(file2 = new File(System.getProperty("user.home") + "/.libgdx/" + paramString1, paramString2))) return file2;
/*     */ 
/*     */ 
/*     */     
/* 118 */     if (canWrite(file2 = new File(".temp/" + paramString1, paramString2))) return file2;
/*     */ 
/*     */     
/* 121 */     if (System.getenv("APP_SANDBOX_CONTAINER_ID") != null) return file1;
/*     */     
/* 123 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean canWrite(File paramFile) {
/* 128 */     null = paramFile.getParentFile();
/*     */     
/* 130 */     if (paramFile.exists()) {
/* 131 */       if (!paramFile.canWrite() || !canExecute(paramFile)) return false;
/*     */       
/* 133 */       paramFile = new File(null, randomUUID().toString());
/*     */     } else {
/* 135 */       null.mkdirs();
/* 136 */       if (!null.isDirectory()) return false; 
/* 137 */       paramFile = paramFile;
/*     */     } 
/*     */     try {
/* 140 */       (new FileOutputStream(paramFile)).close();
/* 141 */       if (!canExecute(paramFile)) return false; 
/* 142 */       return true;
/* 143 */     } catch (Throwable throwable) {
/* 144 */       return false;
/*     */     } finally {
/* 146 */       paramFile.delete();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean canExecute(File paramFile) {
/*     */     try {
/*     */       Method method1;
/* 153 */       if (((Boolean)(method1 = File.class.getMethod("canExecute", new Class[0])).invoke(paramFile, new Object[0])).booleanValue()) return true;
/*     */       
/*     */       Method method2;
/* 156 */       (method2 = File.class.getMethod("setExecutable", new Class[] { boolean.class, boolean.class })).invoke(paramFile, new Object[] { Boolean.TRUE, Boolean.FALSE });
/*     */       
/* 158 */       return ((Boolean)method1.invoke(paramFile, new Object[0])).booleanValue();
/* 159 */     } catch (Exception exception) {
/*     */       
/* 161 */       return false;
/*     */     } 
/*     */   }
/*     */   public static File load() {
/* 165 */     if (!isMac) return null;
/*     */     
/* 167 */     if (!EventQueue.isDispatchThread()) {
/*     */       try {
/* 169 */         EventQueue.invokeAndWait(new Runnable() {
/*     */               public void run() {
/* 171 */                 Toolkit.getDefaultToolkit();
/*     */               }
/*     */             });
/* 174 */       } catch (Throwable throwable) {
/* 175 */         throw new GdxRuntimeException("Couldn't initialize AWT.", throwable);
/*     */       } 
/*     */     }
/*     */     
/* 179 */     String str1 = SharedLibraryLoader.isARM ? "macosarm64/libglfwarm64.dylib" : "macosx64/libglfw.dylib";
/*     */     String str2;
/* 181 */     File file = getExtractedFile(str2 = crc(GlfwAWTLoader.class.getResourceAsStream("/" + str1)), (new File(str1)).getName());
/*     */     
/* 183 */     extractFile(str1, file);
/* 184 */     return file;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\awt\GlfwAWTLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */