/*     */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.EOFException;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
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
/*     */ public class Wav
/*     */ {
/*     */   public static class Music
/*     */     extends OpenALMusic
/*     */   {
/*     */     private Wav.WavInputStream input;
/*     */     
/*     */     public Music(OpenALLwjgl3Audio param1OpenALLwjgl3Audio, FileHandle param1FileHandle) {
/*  32 */       super(param1OpenALLwjgl3Audio, param1FileHandle);
/*  33 */       this.input = new Wav.WavInputStream(param1FileHandle);
/*  34 */       if (param1OpenALLwjgl3Audio.noDevice)
/*  35 */         return;  setup(this.input.channels, this.input.bitDepth, this.input.sampleRate);
/*     */     }
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte) {
/*  39 */       if (this.input == null) {
/*  40 */         this.input = new Wav.WavInputStream(this.file);
/*  41 */         setup(this.input.channels, this.input.bitDepth, this.input.sampleRate);
/*     */       } 
/*     */       try {
/*  44 */         return this.input.read(param1ArrayOfbyte);
/*  45 */       } catch (IOException iOException) {
/*  46 */         throw new GdxRuntimeException("Error reading WAV file: " + this.file, iOException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void reset() {
/*  51 */       StreamUtils.closeQuietly(this.input);
/*  52 */       this.input = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Sound extends OpenALSound {
/*     */     public Sound(OpenALLwjgl3Audio param1OpenALLwjgl3Audio, FileHandle param1FileHandle) {
/*  58 */       super(param1OpenALLwjgl3Audio); Wav.WavInputStream wavInputStream;
/*  59 */       if (param1OpenALLwjgl3Audio.noDevice)
/*     */         return; 
/*  61 */       param1OpenALLwjgl3Audio = null;
/*     */       
/*     */       try {
/*  64 */         if ((wavInputStream = new Wav.WavInputStream(param1FileHandle)).type == 85) {
/*  65 */           setType("mp3");
/*     */           return;
/*     */         } 
/*  68 */         setup(StreamUtils.copyStreamToByteArray(wavInputStream, wavInputStream.dataRemaining), wavInputStream.channels, wavInputStream.bitDepth, wavInputStream.sampleRate);
/*     */         return;
/*  70 */       } catch (IOException iOException) {
/*  71 */         throw new GdxRuntimeException("Error reading WAV file: " + param1FileHandle, iOException);
/*     */       } finally {
/*  73 */         StreamUtils.closeQuietly(wavInputStream);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WavInputStream
/*     */     extends FilterInputStream {
/*     */     public int channels;
/*     */     public int bitDepth;
/*     */     
/*     */     public WavInputStream(FileHandle param1FileHandle) {
/*  84 */       super(param1FileHandle.read());
/*     */       try {
/*  86 */         if (read() != 82 || read() != 73 || read() != 70 || read() != 70) {
/*  87 */           throw new GdxRuntimeException("RIFF header not found: " + param1FileHandle);
/*     */         }
/*  89 */         skipFully(4);
/*     */         
/*  91 */         if (read() != 87 || read() != 65 || read() != 86 || read() != 69) {
/*  92 */           throw new GdxRuntimeException("Invalid wave file header: " + param1FileHandle);
/*     */         }
/*  94 */         int i = seekToChunk('f', 'm', 't', ' ');
/*     */ 
/*     */ 
/*     */         
/*  98 */         this.type = read() & 0xFF | (read() & 0xFF) << 8;
/*     */         
/* 100 */         if (this.type == 85)
/* 101 */           return;  if (this.type != 1 && this.type != 3) throw new GdxRuntimeException("WAV files must be PCM, unsupported format: " + 
/* 102 */               getCodecName(this.type) + " (" + this.type + ")");
/*     */         
/* 104 */         this.channels = read() & 0xFF | (read() & 0xFF) << 8;
/* 105 */         this.sampleRate = read() & 0xFF | (read() & 0xFF) << 8 | (read() & 0xFF) << 16 | (read() & 0xFF) << 24;
/*     */         
/* 107 */         skipFully(6);
/*     */         
/* 109 */         this.bitDepth = read() & 0xFF | (read() & 0xFF) << 8;
/* 110 */         if (this.type == 1) {
/* 111 */           if (this.bitDepth != 8 && this.bitDepth != 16)
/* 112 */             throw new GdxRuntimeException("PCM WAV files must be 8 or 16-bit: " + this.bitDepth); 
/* 113 */         } else if (this.type == 3 && 
/* 114 */           this.bitDepth != 32 && this.bitDepth != 64) {
/* 115 */           throw new GdxRuntimeException("Floating-point WAV files must be 32 or 64-bit: " + this.bitDepth);
/*     */         } 
/*     */         
/* 118 */         skipFully(i - 16);
/*     */         
/* 120 */         this.dataRemaining = seekToChunk('d', 'a', 't', 'a'); return;
/* 121 */       } catch (Throwable throwable) {
/* 122 */         StreamUtils.closeQuietly(this);
/* 123 */         throw new GdxRuntimeException("Error reading WAV file: " + param1FileHandle, throwable);
/*     */       } 
/*     */     }
/*     */     public int sampleRate;
/*     */     public int dataRemaining;
/*     */     public int type;
/*     */     
/*     */     private int seekToChunk(char param1Char1, char param1Char2, char param1Char3, char param1Char4) {
/*     */       while (true) {
/* 132 */         int i = (i = (i = (i = (read() == param1Char1) ? 1 : 0) & ((read() == param1Char2) ? 1 : 0)) & ((read() == param1Char3) ? 1 : 0)) & ((read() == param1Char4) ? 1 : 0);
/*     */         int j;
/* 134 */         if ((j = read() & 0xFF | (read() & 0xFF) << 8 | (read() & 0xFF) << 16 | (read() & 0xFF) << 24) == -1) throw new IOException("Chunk not found: " + param1Char1 + param1Char2 + param1Char3 + param1Char4); 
/* 135 */         if (i != 0) return j; 
/* 136 */         skipFully(j);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void skipFully(int param1Int) {
/* 141 */       while (param1Int > 0) {
/*     */         long l;
/* 143 */         if ((l = this.in.skip(param1Int)) <= 0L) throw new EOFException("Unable to skip."); 
/* 144 */         param1Int = (int)(param1Int - l);
/*     */       } 
/*     */     }
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte) {
/* 149 */       if (this.dataRemaining == 0) return -1; 
/* 150 */       int i = 0;
/*     */       while (true) {
/*     */         int j;
/* 153 */         if ((j = Math.min(read(param1ArrayOfbyte, i, param1ArrayOfbyte.length - i), this.dataRemaining)) == -1) {
/* 154 */           if (i > 0) return i; 
/* 155 */           return -1;
/*     */         } 
/* 157 */         i += j;
/* 158 */         this.dataRemaining -= j;
/* 159 */         if (i >= param1ArrayOfbyte.length) {
/* 160 */           return i;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private String getCodecName(int param1Int) {
/* 168 */       switch (param1Int) { case 2:
/* 169 */           return "Microsoft ADPCM";
/* 170 */         case 6: return "ITU-T G.711 A-law";
/* 171 */         case 7: return "ITU-T G.711 u-law";
/* 172 */         case 17: return "IMA ADPCM";
/* 173 */         case 34: return "DSP Group TrueSpeech";
/* 174 */         case 49: return "Microsoft GSM 6.10";
/* 175 */         case 64: return "Antex G.721 ADPCM";
/* 176 */         case 112: return "Lernout & Hauspie CELP 4.8kbps";
/* 177 */         case 114: return "Lernout & Hauspie CBS 12kbps";
/* 178 */         case 65534: return "Extensible"; }
/* 179 */        return "Unknown";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\Wav.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */