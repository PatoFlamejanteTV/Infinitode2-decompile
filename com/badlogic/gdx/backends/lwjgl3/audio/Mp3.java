/*     */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*     */ 
/*     */ import b.a.a.b;
/*     */ import b.a.a.c;
/*     */ import b.a.a.g;
/*     */ import b.a.a.l;
/*     */ import b.a.a.m;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Mp3
/*     */ {
/*     */   public static class Music
/*     */     extends OpenALMusic
/*     */   {
/*     */     private b bitstream;
/*     */     private m outputBuffer;
/*     */     private l decoder;
/*     */     
/*     */     public Music(OpenALLwjgl3Audio param1OpenALLwjgl3Audio, FileHandle param1FileHandle) {
/*  40 */       super(param1OpenALLwjgl3Audio, param1FileHandle);
/*  41 */       if (param1OpenALLwjgl3Audio.noDevice)
/*  42 */         return;  this.bitstream = new b(param1FileHandle.read());
/*  43 */       this.decoder = new l();
/*     */       try {
/*     */         g g;
/*  46 */         if ((g = this.bitstream.b()) == null) throw new GdxRuntimeException("Empty MP3"); 
/*  47 */         boolean bool = (g.f() == 3) ? true : true;
/*  48 */         this.outputBuffer = new m(bool, false);
/*  49 */         this.decoder.a(this.outputBuffer);
/*  50 */         setup(bool, 16, g.j()); return;
/*  51 */       } catch (c c) {
/*  52 */         throw new GdxRuntimeException("Error while preloading MP3", c);
/*     */       } 
/*     */     }
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte) {
/*     */       try {
/*     */         boolean bool;
/*  59 */         if (bool = (this.bitstream == null) ? true : false) {
/*  60 */           this.bitstream = new b(this.file.read());
/*  61 */           this.decoder = new l();
/*     */         } 
/*     */         
/*  64 */         int i = 0;
/*  65 */         int j = param1ArrayOfbyte.length - 4608; g g;
/*  66 */         while (i <= j && (
/*     */           
/*  68 */           g = this.bitstream.b()) != null) {
/*  69 */           if (bool) {
/*  70 */             boolean bool1 = (g.f() == 3) ? true : true;
/*  71 */             this.outputBuffer = new m(bool1, false);
/*  72 */             this.decoder.a(this.outputBuffer);
/*  73 */             setup(bool1, 16, g.j());
/*  74 */             bool = false;
/*     */           } 
/*     */           try {
/*  77 */             this.decoder.a(g, this.bitstream);
/*  78 */           } catch (Exception exception) {}
/*     */ 
/*     */           
/*  81 */           this.bitstream.d();
/*     */           
/*  83 */           int k = this.outputBuffer.b();
/*  84 */           System.arraycopy(this.outputBuffer.a(), 0, param1ArrayOfbyte, i, k);
/*  85 */           i += k;
/*     */         } 
/*  87 */         return i;
/*  88 */       } catch (Throwable throwable) {
/*  89 */         reset();
/*  90 */         throw new GdxRuntimeException("Error reading audio data.", throwable);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void reset() {
/*  95 */       if (this.bitstream == null)
/*     */         return;  try {
/*  97 */         this.bitstream.a();
/*  98 */       } catch (c c) {}
/*     */       
/* 100 */       this.bitstream = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Sound
/*     */     extends OpenALSound
/*     */   {
/*     */     public Sound(OpenALLwjgl3Audio param1OpenALLwjgl3Audio, FileHandle param1FileHandle) {
/* 108 */       super(param1OpenALLwjgl3Audio);
/* 109 */       if (param1OpenALLwjgl3Audio.noDevice)
/* 110 */         return;  ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
/*     */       
/* 112 */       b b = new b(param1FileHandle.read());
/* 113 */       l l = new l();
/*     */       
/*     */       try {
/* 116 */         m m = null;
/* 117 */         int i = -1; byte b1 = -1;
/*     */         
/*     */         g g;
/* 120 */         while ((g = b.b()) != null) {
/* 121 */           if (m == null) {
/* 122 */             b1 = (g.f() == 3) ? 1 : 2;
/* 123 */             m = new m(b1, false);
/* 124 */             l.a(m);
/* 125 */             i = g.j();
/*     */           } 
/*     */           try {
/* 128 */             l.a(g, b);
/* 129 */           } catch (Exception exception) {}
/*     */ 
/*     */           
/* 132 */           b.d();
/* 133 */           byteArrayOutputStream.write(m.a(), 0, m.b());
/*     */         } 
/* 135 */         b.a();
/* 136 */         setup(byteArrayOutputStream.toByteArray(), b1, 16, i); return;
/* 137 */       } catch (Throwable throwable) {
/* 138 */         throw new GdxRuntimeException("Error reading audio data.", throwable);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\Mp3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */