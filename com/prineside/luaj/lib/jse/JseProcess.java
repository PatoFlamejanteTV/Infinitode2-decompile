/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ public class JseProcess
/*     */ {
/*     */   private Process a;
/*     */   private Thread b;
/*     */   private Thread c;
/*     */   private Thread d;
/*     */   
/*     */   public JseProcess(String[] paramArrayOfString, InputStream paramInputStream, OutputStream paramOutputStream1, OutputStream paramOutputStream2) {
/*  45 */     this(Runtime.getRuntime().exec(paramArrayOfString), paramInputStream, paramOutputStream1, paramOutputStream2);
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
/*     */   public JseProcess(String paramString, InputStream paramInputStream, OutputStream paramOutputStream1, OutputStream paramOutputStream2) {
/*  58 */     this(Runtime.getRuntime().exec(paramString), paramInputStream, paramOutputStream1, paramOutputStream2);
/*     */   }
/*     */   
/*     */   private JseProcess(Process paramProcess, InputStream paramInputStream, OutputStream paramOutputStream1, OutputStream paramOutputStream2) {
/*  62 */     this.a = paramProcess;
/*  63 */     this.b = (paramInputStream == null) ? null : a(paramInputStream, paramProcess.getOutputStream(), null, paramProcess.getOutputStream());
/*  64 */     this.c = (paramOutputStream1 == null) ? null : a(paramProcess.getInputStream(), paramOutputStream1, paramProcess.getInputStream(), null);
/*  65 */     this.d = (paramOutputStream2 == null) ? null : a(paramProcess.getErrorStream(), paramOutputStream2, paramProcess.getErrorStream(), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int exitValue() {
/*  70 */     return this.a.exitValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int waitFor() {
/*  78 */     int i = this.a.waitFor();
/*  79 */     if (this.b != null)
/*  80 */       this.b.join(); 
/*  81 */     if (this.c != null)
/*  82 */       this.c.join(); 
/*  83 */     if (this.d != null)
/*  84 */       this.d.join(); 
/*  85 */     this.a.destroy();
/*  86 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Thread a(InputStream paramInputStream1, OutputStream paramOutputStream1, InputStream paramInputStream2, OutputStream paramOutputStream2) {
/*     */     CopyThread copyThread;
/*  94 */     (copyThread = new CopyThread(paramOutputStream1, paramOutputStream2, paramInputStream2, paramInputStream1, (byte)0)).setDaemon(true);
/*  95 */     copyThread.start();
/*  96 */     return copyThread;
/*     */   }
/*     */   
/*     */   private static final class CopyThread
/*     */     extends Thread {
/*     */     private final OutputStream a;
/*     */     private final OutputStream b;
/*     */     private final InputStream c;
/*     */     private final InputStream d;
/*     */     
/*     */     private CopyThread(OutputStream param1OutputStream1, OutputStream param1OutputStream2, InputStream param1InputStream1, InputStream param1InputStream2) {
/* 107 */       this.a = param1OutputStream1;
/* 108 */       this.b = param1OutputStream2;
/* 109 */       this.c = param1InputStream1;
/* 110 */       this.d = param1InputStream2;
/*     */     }
/*     */     
/*     */     public final void run() {
/*     */       try {
/* 115 */         null = new byte[1024];
/*     */         try {
/*     */           int i;
/* 118 */           while ((i = this.d.read(null)) >= 0) {
/* 119 */             this.a.write(null, 0, i);
/*     */           }
/*     */         } finally {
/* 122 */           if (this.c != null)
/* 123 */             this.c.close(); 
/* 124 */           if (this.b != null)
/* 125 */             this.b.close(); 
/*     */         } 
/* 127 */       } catch (IOException iOException2) {
/* 128 */         IOException iOException1; (iOException1 = null).printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JseProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */