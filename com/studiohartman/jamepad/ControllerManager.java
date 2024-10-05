/*     */ package com.studiohartman.jamepad;
/*     */ 
/*     */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.file.CopyOption;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.StandardCopyOption;
/*     */ import java.nio.file.attribute.FileAttribute;
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
/*     */ public class ControllerManager
/*     */ {
/*     */   private final a a;
/*     */   private String b;
/*     */   private boolean c;
/*     */   private ControllerIndex[] d;
/*     */   
/*     */   public ControllerManager() {
/*  43 */     this(new a(), "/gamecontrollerdb.txt");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ControllerManager(a parama) {
/*  52 */     this(parama, "/gamecontrollerdb.txt");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ControllerManager(a parama, String paramString) {
/*  62 */     this.a = parama;
/*  63 */     this.b = paramString;
/*  64 */     this.c = false;
/*  65 */     this.d = new ControllerIndex[parama.a];
/*     */     
/*  67 */     if (parama.c) {
/*  68 */       (new SharedLibraryLoader()).load("jamepad");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/*  79 */     if (this.c) {
/*  80 */       throw new IllegalStateException("SDL is already initialized!");
/*     */     }
/*     */ 
/*     */     
/*  84 */     if (!nativeInitSDLGamepad(true)) {
/*  85 */       throw new IllegalStateException("Failed to initialize SDL in native method!");
/*     */     }
/*  87 */     this.c = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  93 */       a(this.b);
/*  94 */     } catch (IOException|IllegalStateException iOException) {
/*  95 */       System.err.println("Failed to load mapping with original location \"" + this.b + "\", Falling back of SDL's built in mappings");
/*     */       
/*  97 */       iOException.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/* 101 */     for (byte b = 0; b < this.d.length; b++) {
/* 102 */       this.d[b] = new ControllerIndex(b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeInitSDLGamepad(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b() {
/*     */     ControllerIndex[] arrayOfControllerIndex;
/*     */     int i;
/*     */     byte b;
/* 126 */     for (i = (arrayOfControllerIndex = this.d).length, b = 0; b < i; b++) {
/* 127 */       ControllerIndex controllerIndex; (controllerIndex = arrayOfControllerIndex[b]).a();
/*     */     } 
/* 129 */     nativeCloseSDLGamepad();
/* 130 */     this.d = new ControllerIndex[0];
/* 131 */     this.c = false;
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
/*     */   private native void nativeCloseSDLGamepad();
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
/*     */   public final ControllerIndex a(int paramInt) {
/* 216 */     d();
/* 217 */     return this.d[paramInt];
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
/*     */   public final void c() {
/* 255 */     d();
/* 256 */     if (nativeControllerConnectedOrDisconnected()) {
/* 257 */       for (byte b = 0; b < this.d.length; b++) {
/* 258 */         this.d[b].b();
/*     */       }
/*     */     }
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
/*     */   private native boolean nativeControllerConnectedOrDisconnected();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/*     */     InputStream inputStream;
/* 282 */     if ((inputStream = getClass().getResourceAsStream(paramString)) == null) inputStream = ClassLoader.getSystemResourceAsStream(paramString); 
/* 283 */     if (inputStream == null) throw new IOException("Cannot open resource from classpath " + paramString);
/*     */     
/* 285 */     if (this.a.d) {
/* 286 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */ 
/*     */       
/* 289 */       byte[] arrayOfByte2 = new byte[4096];
/*     */       int i;
/* 291 */       while ((i = inputStream.read(arrayOfByte2, 0, 4096)) != -1) {
/* 292 */         byteArrayOutputStream.write(arrayOfByte2, 0, i);
/*     */       }
/*     */       
/* 295 */       byte[] arrayOfByte1 = byteArrayOutputStream.toByteArray();
/* 296 */       if (!nativeAddMappingsFromBuffer(arrayOfByte1, arrayOfByte1.length)) {
/* 297 */         throw new IllegalStateException("Failed to set SDL controller mappings! Falling back to build in SDL mappings.");
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 305 */     Path path = Files.createTempFile(null, null, (FileAttribute<?>[])new FileAttribute[0]).toAbsolutePath();
/*     */     
/* 307 */     Files.copy(inputStream, path, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*     */     
/* 309 */     if (!nativeAddMappingsFromFile(path.toString())) {
/* 310 */       throw new IllegalStateException("Failed to set SDL controller mappings! Falling back to build in SDL mappings.");
/*     */     }
/*     */     
/* 313 */     Files.delete(path);
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
/*     */   private native boolean nativeAddMappingsFromFile(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeAddMappingsFromBuffer(byte[] paramArrayOfbyte, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public native String getLastNativeError();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean d() {
/* 353 */     if (!this.c) {
/* 354 */       throw new IllegalStateException("SDL_GameController is not initialized!");
/*     */     }
/* 356 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\studiohartman\jamepad\ControllerManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */