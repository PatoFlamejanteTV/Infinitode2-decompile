/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.ByteArray;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.RandomAccessFile;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipOutputStream;
/*    */ 
/*    */ public final class FileUtils
/*    */ {
/* 17 */   private static final TLog a = TLog.forClass(FileUtils.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void fileToZip(File paramFile1, File paramFile2, String paramString) {
/* 25 */     if (!paramFile1.exists()) {
/* 26 */       a.e("fileToZip: File %s does not exist", new Object[] { paramFile1 }); return;
/*    */     } 
/*    */     try {
/*    */       int i;
/* 30 */       FileOutputStream fileOutputStream = new FileOutputStream(paramFile2, false);
/*    */       ZipOutputStream zipOutputStream;
/* 32 */       (zipOutputStream = new ZipOutputStream(fileOutputStream)).putNextEntry(new ZipEntry(paramString));
/*    */       
/* 34 */       byte[] arrayOfByte = new byte[(int)paramFile1.length()];
/*    */       
/* 36 */       FileInputStream fileInputStream = new FileInputStream(paramFile1); 
/* 37 */       try { i = fileInputStream.read(arrayOfByte);
/* 38 */         fileInputStream.close(); } catch (Throwable throwable1) { try { fileInputStream.close(); } catch (Throwable throwable2) { throwable1.addSuppressed(throwable2); }
/*    */          throw throwable1; }
/* 40 */        throwable2.write((byte[])throwable1, 0, i);
/* 41 */       throwable2.closeEntry();
/* 42 */       throwable2.close(); return;
/* 43 */     } catch (FileNotFoundException fileNotFoundException) {
/* 44 */       a.e("fileToZip: File %s does not exist", new Object[] { paramFile1, fileNotFoundException }); return;
/* 45 */     } catch (Exception exception) {
/* 46 */       a.e("fileToZip: error (%s, %s)", new Object[] { paramFile1, paramFile2, exception });
/*    */       return;
/*    */     } 
/*    */   }
/*    */   public static Array<String> tail(File paramFile, int paramInt) {
/* 51 */     Array<String> array = new Array(); 
/* 52 */     try { RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "r"); 
/* 53 */       try { ByteArray byteArray = new ByteArray();
/*    */         
/* 55 */         long l1 = (l1 = paramFile.length()) - 1L;
/* 56 */         randomAccessFile.seek(l1); long l2;
/* 57 */         for (l2 = l1; l2 >= 0L; l2--) {
/* 58 */           randomAccessFile.seek(l2);
/*    */           int i;
/* 60 */           if ((i = randomAccessFile.read()) == 10)
/* 61 */           { byteArray.reverse();
/* 62 */             array.add(new String(byteArray.toArray(), StandardCharsets.UTF_8));
/* 63 */             paramInt--;
/* 64 */             if (paramInt >= 0)
/*    */             
/*    */             { 
/* 67 */               byteArray.clear(); } else { break; }
/*    */              }
/* 69 */           else { byteArray.add((byte)i); }
/*    */         
/*    */         } 
/* 72 */         randomAccessFile.close(); } catch (Throwable throwable) { try { randomAccessFile.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception exception) {}
/* 73 */     return array;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\FileUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */