/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.zip.DataFormatException;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.DeflaterOutputStream;
/*     */ import java.util.zip.Inflater;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class n
/*     */   extends l
/*     */ {
/*  39 */   private static final a a = c.a(n.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/*  46 */     d d1 = a(paramd, paramInt);
/*     */ 
/*     */     
/*     */     try {
/*  50 */       a(paramInputStream, t.a(paramOutputStream, d1));
/*     */     }
/*  52 */     catch (DataFormatException dataFormatException) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  58 */       throw new IOException(dataFormatException);
/*     */     } 
/*  60 */     return new k(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(InputStream paramInputStream, OutputStream paramOutputStream) {
/*  67 */     byte[] arrayOfByte = new byte[2048];
/*     */     
/*  69 */     paramInputStream.read(arrayOfByte, 0, 2);
/*     */     int i;
/*  71 */     if ((i = paramInputStream.read(arrayOfByte)) > 0) {
/*     */       Inflater inflater;
/*     */ 
/*     */       
/*  75 */       (inflater = new Inflater(true)).setInput(arrayOfByte, 0, i);
/*  76 */       byte[] arrayOfByte1 = new byte[1024];
/*  77 */       boolean bool = false;
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         try {
/*  83 */           i = inflater.inflate(arrayOfByte1);
/*     */         }
/*  85 */         catch (DataFormatException dataFormatException) {
/*     */           
/*  87 */           if (!bool)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  96 */             throw dataFormatException; } 
/*     */           break;
/*     */         } 
/*  99 */         if (i != 0) {
/*     */           
/* 101 */           paramOutputStream.write(arrayOfByte1, 0, i);
/* 102 */           bool = true;
/*     */           continue;
/*     */         } 
/* 105 */         if (!inflater.finished() && !inflater.needsDictionary() && dataFormatException.available() != 0) {
/*     */ 
/*     */ 
/*     */           
/* 109 */           i = dataFormatException.read(arrayOfByte);
/* 110 */           inflater.setInput(arrayOfByte, 0, i); continue;
/*     */         }  break;
/* 112 */       }  inflater.end();
/*     */     } 
/* 114 */     paramOutputStream.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 121 */     int i = a();
/* 122 */     Deflater deflater = new Deflater(i);
/* 123 */     DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(paramOutputStream, deflater);
/*     */     
/*     */     int j;
/* 126 */     if ((j = paramInputStream.available()) > 0) {
/*     */       
/* 128 */       byte[] arrayOfByte = new byte[Math.min(j, 16384)]; int k;
/* 129 */       while ((k = paramInputStream.read(arrayOfByte, 0, Math.min(j, 16384))) != -1)
/*     */       {
/* 131 */         deflaterOutputStream.write(arrayOfByte, 0, k);
/*     */       }
/*     */     } 
/* 134 */     deflaterOutputStream.close();
/* 135 */     paramOutputStream.flush();
/* 136 */     deflater.end();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */