/*    */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*    */ 
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.utils.BufferUtils;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import com.badlogic.gdx.utils.StreamUtils;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import java.nio.ShortBuffer;
/*    */ import org.lwjgl.stb.STBVorbis;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ogg
/*    */ {
/*    */   public static class Music
/*    */     extends OpenALMusic
/*    */   {
/*    */     private OggInputStream input;
/*    */     private OggInputStream previousInput;
/*    */     
/*    */     public Music(OpenALLwjgl3Audio param1OpenALLwjgl3Audio, FileHandle param1FileHandle) {
/* 37 */       super(param1OpenALLwjgl3Audio, param1FileHandle);
/* 38 */       if (param1OpenALLwjgl3Audio.noDevice)
/* 39 */         return;  this.input = new OggInputStream(param1FileHandle.read());
/* 40 */       setup(this.input.getChannels(), 16, this.input.getSampleRate());
/*    */     }
/*    */     
/*    */     public int read(byte[] param1ArrayOfbyte) {
/* 44 */       if (this.input == null) {
/* 45 */         this.input = new OggInputStream(this.file.read(), this.previousInput);
/* 46 */         setup(this.input.getChannels(), 16, this.input.getSampleRate());
/* 47 */         this.previousInput = null;
/*    */       } 
/* 49 */       return this.input.read(param1ArrayOfbyte);
/*    */     }
/*    */     
/*    */     public void reset() {
/* 53 */       StreamUtils.closeQuietly(this.input);
/* 54 */       this.previousInput = null;
/* 55 */       this.input = null;
/*    */     }
/*    */ 
/*    */     
/*    */     protected void loop() {
/* 60 */       StreamUtils.closeQuietly(this.input);
/* 61 */       this.previousInput = this.input;
/* 62 */       this.input = null;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Sound extends OpenALSound {
/*    */     public Sound(OpenALLwjgl3Audio param1OpenALLwjgl3Audio, FileHandle param1FileHandle) {
/* 68 */       super(param1OpenALLwjgl3Audio);
/* 69 */       if (param1OpenALLwjgl3Audio.noDevice) {
/*    */         return;
/*    */       }
/*    */       byte[] arrayOfByte;
/*    */       ByteBuffer byteBuffer;
/* 74 */       (byteBuffer = BufferUtils.newByteBuffer((arrayOfByte = param1FileHandle.readBytes()).length)).put(arrayOfByte);
/* 75 */       byteBuffer.flip();
/*    */       
/* 77 */       MemoryStack memoryStack = MemoryStack.stackPush(); try {
/* 78 */         IntBuffer intBuffer1 = memoryStack.mallocInt(1);
/* 79 */         IntBuffer intBuffer2 = memoryStack.mallocInt(1);
/*    */ 
/*    */         
/* 82 */         ShortBuffer shortBuffer = STBVorbis.stb_vorbis_decode_memory(byteBuffer, intBuffer1, intBuffer2);
/* 83 */         int i = intBuffer1.get(0);
/* 84 */         int j = intBuffer2.get(0);
/* 85 */         if (shortBuffer == null) {
/* 86 */           throw new GdxRuntimeException("Error decoding OGG file: " + param1FileHandle);
/*    */         }
/*    */         
/* 89 */         setup(shortBuffer, i, 16, j);
/* 90 */         if (memoryStack != null) { memoryStack.close();
/*    */           return; }
/*    */       
/*    */       } catch (Throwable throwable) {
/*    */         if (memoryStack != null)
/*    */           try {
/*    */             memoryStack.close();
/*    */           } catch (Throwable throwable1) {
/*    */             throwable.addSuppressed(throwable1);
/*    */           }  
/*    */         throw throwable;
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\Ogg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */