/*     */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import com.c.a.b;
/*     */ import com.c.a.c;
/*     */ import com.c.a.d;
/*     */ import com.c.a.e;
/*     */ import com.c.b.a;
/*     */ import com.c.b.c;
/*     */ import com.c.b.e;
/*     */ import com.c.b.l;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import org.lwjgl.BufferUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OggInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private static final int BUFFER_SIZE = 512;
/*  51 */   private int convsize = 2048;
/*     */   
/*     */   private byte[] convbuffer;
/*     */   
/*     */   private InputStream input;
/*     */   
/*  57 */   private l oggInfo = new l();
/*     */ 
/*     */   
/*     */   private boolean endOfStream;
/*     */   
/*  62 */   private e syncState = new e();
/*     */   
/*  64 */   private d streamState = new d();
/*     */   
/*  66 */   private c page = new c();
/*     */   
/*  68 */   private b packet = new b();
/*     */ 
/*     */   
/*  71 */   private c comment = new c();
/*     */   
/*  73 */   private e dspState = new e();
/*     */   
/*  75 */   private a vorbisBlock = new a(this.dspState);
/*     */ 
/*     */   
/*     */   byte[] buffer;
/*     */   
/*  80 */   int bytes = 0;
/*     */   
/*  82 */   boolean bigEndian = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
/*     */ 
/*     */   
/*     */   boolean endOfBitStream = true;
/*     */ 
/*     */   
/*     */   boolean inited = false;
/*     */ 
/*     */   
/*     */   private int readIndex;
/*     */   
/*     */   private ByteBuffer pcmBuffer;
/*     */   
/*     */   private int total;
/*     */ 
/*     */   
/*     */   public OggInputStream(InputStream paramInputStream) {
/*  99 */     this(paramInputStream, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OggInputStream(InputStream paramInputStream, OggInputStream paramOggInputStream) {
/* 109 */     if (paramOggInputStream == null) {
/* 110 */       this.convbuffer = new byte[this.convsize];
/* 111 */       this.pcmBuffer = BufferUtils.createByteBuffer(2048000);
/*     */     } else {
/* 113 */       this.convbuffer = paramOggInputStream.convbuffer;
/* 114 */       this.pcmBuffer = paramOggInputStream.pcmBuffer;
/*     */     } 
/*     */     
/* 117 */     this.input = paramInputStream;
/*     */     try {
/* 119 */       this.total = paramInputStream.available();
/* 120 */     } catch (IOException iOException) {
/* 121 */       throw new GdxRuntimeException(iOException);
/*     */     } 
/*     */     
/* 124 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLength() {
/* 131 */     return this.total;
/*     */   }
/*     */   
/*     */   public int getChannels() {
/* 135 */     return this.oggInfo.a;
/*     */   }
/*     */   
/*     */   public int getSampleRate() {
/* 139 */     return this.oggInfo.b;
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/* 144 */     initVorbis();
/* 145 */     readPCM();
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 150 */     return this.endOfStream ? 0 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initVorbis() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean getPageAndPacket() {
/*     */     int i;
/* 169 */     if ((i = this.syncState.a(512)) == -1) return false;
/*     */     
/* 171 */     this.buffer = this.syncState.a;
/* 172 */     if (this.buffer == null) {
/* 173 */       this.endOfStream = true;
/* 174 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/* 178 */       this.bytes = this.input.read(this.buffer, i, 512);
/* 179 */     } catch (Exception exception) {
/* 180 */       throw new GdxRuntimeException("Failure reading Vorbis.", exception);
/*     */     } 
/* 182 */     this.syncState.b(this.bytes);
/*     */ 
/*     */     
/* 185 */     if (this.syncState.a(this.page) != 1) {
/*     */       
/* 187 */       if (this.bytes < 512) return false;
/*     */ 
/*     */       
/* 190 */       throw new GdxRuntimeException("Input does not appear to be an Ogg bitstream.");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 195 */     this.streamState.a(this.page.f());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     this.oggInfo.a();
/* 206 */     this.comment.a();
/* 207 */     if (this.streamState.a(this.page) < 0)
/*     */     {
/* 209 */       throw new GdxRuntimeException("Error reading first page of Ogg bitstream.");
/*     */     }
/*     */     
/* 212 */     if (this.streamState.a(this.packet) != 1)
/*     */     {
/* 214 */       throw new GdxRuntimeException("Error reading initial header packet.");
/*     */     }
/*     */     
/* 217 */     if (this.oggInfo.a(this.comment, this.packet) < 0)
/*     */     {
/* 219 */       throw new GdxRuntimeException("Ogg bitstream does not contain Vorbis audio data.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     byte b1 = 0;
/* 233 */     while (b1 < 2) {
/* 234 */       while (b1 < 2 && (
/*     */         
/* 236 */         i = this.syncState.a(this.page)) != 0) {
/*     */ 
/*     */ 
/*     */         
/* 240 */         if (i == 1) {
/* 241 */           this.streamState.a(this.page);
/*     */           
/* 243 */           while (b1 < 2 && (
/*     */             
/* 245 */             i = this.streamState.a(this.packet)) != 0) {
/* 246 */             if (i == -1)
/*     */             {
/*     */               
/* 249 */               throw new GdxRuntimeException("Corrupt secondary header.");
/*     */             }
/*     */             
/* 252 */             this.oggInfo.a(this.comment, this.packet);
/* 253 */             b1++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 259 */       if ((i = this.syncState.a(512)) == -1) return false; 
/* 260 */       this.buffer = this.syncState.a;
/*     */       try {
/* 262 */         this.bytes = this.input.read(this.buffer, i, 512);
/* 263 */       } catch (Exception exception) {
/* 264 */         throw new GdxRuntimeException("Failed to read Vorbis.", exception);
/*     */       } 
/* 266 */       if (this.bytes == 0 && b1 < 2) {
/* 267 */         throw new GdxRuntimeException("End of file before finding all Vorbis headers.");
/*     */       }
/* 269 */       this.syncState.b(this.bytes);
/*     */     } 
/*     */     
/* 272 */     this.convsize = 512 / this.oggInfo.a;
/*     */ 
/*     */     
/* 275 */     this.dspState.a(this.oggInfo);
/* 276 */     this.vorbisBlock.a(this.dspState);
/*     */ 
/*     */ 
/*     */     
/* 280 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readPCM() {
/* 285 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/* 288 */       if (this.endOfBitStream)
/* 289 */         if (getPageAndPacket()) {
/*     */ 
/*     */           
/* 292 */           this.endOfBitStream = false;
/*     */         } else {
/*     */           break;
/* 295 */         }   if (!this.inited) {
/* 296 */         this.inited = true;
/*     */         
/*     */         return;
/*     */       } 
/* 300 */       float[][][] arrayOfFloat = new float[1][][];
/* 301 */       int[] arrayOfInt = new int[this.oggInfo.a];
/*     */       
/* 303 */       while (!this.endOfBitStream) {
/* 304 */         int i; while (!this.endOfBitStream && (
/*     */ 
/*     */           
/* 307 */           i = this.syncState.a(this.page)) != 0) {
/*     */           boolean bool1;
/* 309 */           if (i == -1) {
/* 310 */             Gdx.app.error("gdx-audio", "Error reading OGG: Corrupt or missing data in bitstream."); continue;
/*     */           } 
/* 312 */           this.streamState.a(this.page);
/*     */ 
/*     */ 
/*     */           
/* 316 */           while ((i = this.streamState.a(this.packet)) != 0) {
/* 317 */             if (i != -1) {
/*     */ 
/*     */               
/* 320 */               if (this.vorbisBlock.a(this.packet) == 0) {
/* 321 */                 this.dspState.a(this.vorbisBlock);
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 329 */               while ((i = this.dspState.a(arrayOfFloat, arrayOfInt)) > 0) {
/* 330 */                 float[][] arrayOfFloat1 = arrayOfFloat[0];
/*     */                 
/* 332 */                 i = (i < this.convsize) ? i : this.convsize;
/*     */                 
/*     */                 int j;
/* 335 */                 for (j = 0; j < this.oggInfo.a; j++) {
/* 336 */                   int k = j << 1;
/*     */                   
/* 338 */                   int m = arrayOfInt[j];
/* 339 */                   for (byte b1 = 0; b1 < i; b1++) {
/*     */                     int n;
/*     */                     
/* 342 */                     if ((n = (int)(arrayOfFloat1[j][m + b1] * 32767.0D)) > 32767) {
/* 343 */                       n = 32767;
/*     */                     }
/* 345 */                     if (n < -32768) {
/* 346 */                       n = -32768;
/*     */                     }
/* 348 */                     if (n < 0) n |= 0x8000;
/*     */                     
/* 350 */                     if (this.bigEndian) {
/* 351 */                       this.convbuffer[k] = (byte)(n >>> 8);
/* 352 */                       this.convbuffer[k + 1] = (byte)n;
/*     */                     } else {
/* 354 */                       this.convbuffer[k] = (byte)n;
/* 355 */                       this.convbuffer[k + 1] = (byte)(n >>> 8);
/*     */                     } 
/* 357 */                     k += 2 * this.oggInfo.a;
/*     */                   } 
/*     */                 } 
/*     */ 
/*     */                 
/* 362 */                 if ((j = 2 * this.oggInfo.a * i) > this.pcmBuffer.remaining()) {
/* 363 */                   throw new GdxRuntimeException("Ogg block too big to be buffered: " + j + " :: " + this.pcmBuffer
/* 364 */                       .remaining());
/*     */                 }
/* 366 */                 this.pcmBuffer.put(this.convbuffer, 0, j);
/*     */ 
/*     */                 
/* 369 */                 bool1 = true;
/* 370 */                 this.dspState.a(i);
/*     */               } 
/*     */             } 
/*     */           } 
/* 374 */           if (this.page.d() != 0) {
/* 375 */             this.endOfBitStream = true;
/*     */           }
/*     */           
/* 378 */           if (!this.endOfBitStream && bool1) {
/*     */             return;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 384 */         if (!this.endOfBitStream) {
/* 385 */           this.bytes = 0;
/*     */           
/* 387 */           if ((i = this.syncState.a(512)) >= 0) {
/* 388 */             this.buffer = this.syncState.a;
/*     */             try {
/* 390 */               this.bytes = this.input.read(this.buffer, i, 512);
/* 391 */             } catch (Exception exception) {
/* 392 */               throw new GdxRuntimeException("Error during Vorbis decoding.", exception);
/*     */             } 
/*     */           } else {
/* 395 */             this.bytes = 0;
/*     */           } 
/* 397 */           this.syncState.b(this.bytes);
/* 398 */           if (this.bytes == 0) {
/* 399 */             this.endOfBitStream = true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 406 */       this.streamState.a();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 411 */       this.vorbisBlock.a();
/*     */       
/* 413 */       this.oggInfo.b();
/*     */     } 
/*     */ 
/*     */     
/* 417 */     this.syncState.a();
/* 418 */     this.endOfStream = true;
/*     */   }
/*     */   
/*     */   public int read() {
/* 422 */     if (this.readIndex >= this.pcmBuffer.position()) {
/* 423 */       this.pcmBuffer.clear();
/* 424 */       readPCM();
/* 425 */       this.readIndex = 0;
/*     */     } 
/* 427 */     if (this.readIndex >= this.pcmBuffer.position()) {
/* 428 */       return -1;
/*     */     }
/*     */     
/*     */     int i;
/* 432 */     if ((i = this.pcmBuffer.get(this.readIndex)) < 0) {
/* 433 */       i = i + 256;
/*     */     }
/* 435 */     this.readIndex++;
/*     */     
/* 437 */     return i;
/*     */   }
/*     */   
/*     */   public boolean atEnd() {
/* 441 */     return (this.endOfStream && this.readIndex >= this.pcmBuffer.position());
/*     */   }
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 445 */     for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
/*     */       int i;
/* 447 */       if ((i = read()) >= 0) {
/* 448 */         paramArrayOfbyte[paramInt1] = (byte)i;
/*     */       } else {
/* 450 */         if (paramInt1 == 0) {
/* 451 */           return -1;
/*     */         }
/* 453 */         return paramInt1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 458 */     return paramInt2;
/*     */   }
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 462 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public void close() {
/* 466 */     StreamUtils.closeQuietly(this.input);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\OggInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */