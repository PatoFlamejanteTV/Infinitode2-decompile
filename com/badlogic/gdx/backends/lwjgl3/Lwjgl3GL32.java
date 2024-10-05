/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GL32;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ import org.lwjgl.opengl.GL31;
/*     */ import org.lwjgl.opengl.GL32;
/*     */ import org.lwjgl.opengl.GL33;
/*     */ import org.lwjgl.opengl.GL40;
/*     */ import org.lwjgl.opengl.GL43;
/*     */ import org.lwjgl.opengl.GL45;
/*     */ import org.lwjgl.opengl.GLDebugMessageCallbackI;
/*     */ import org.lwjgl.opengl.KHRBlendEquationAdvanced;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public class Lwjgl3GL32
/*     */   extends Lwjgl3GL31
/*     */   implements GL32
/*     */ {
/*  42 */   private static final PointerBuffer pb = PointerBuffer.allocateDirect(16);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void glBlendBarrier() {
/*  48 */     KHRBlendEquationAdvanced.glBlendBarrierKHR();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glCopyImageSubData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15) {
/*  54 */     GL43.glCopyImageSubData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glDebugMessageControl(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, boolean paramBoolean) {
/*  60 */     GL43.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDebugMessageInsert(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString) {
/*  65 */     GL43.glDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDebugMessageCallback(final GL32.DebugProc callback) {
/*  70 */     if (callback != null) {
/*  71 */       GL43.glDebugMessageCallback(new GLDebugMessageCallbackI()
/*     */           {
/*     */             public void invoke(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, long param1Long1, long param1Long2) {
/*  74 */               callback.onMessage(param1Int1, param1Int2, param1Int3, param1Int4, MemoryUtil.memUTF8(param1Long1, param1Int5)); }
/*     */           }0L);
/*     */       return;
/*     */     } 
/*  78 */     GL43.glDebugMessageCallback(null, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int glGetDebugMessageLog(int paramInt, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3, IntBuffer paramIntBuffer4, IntBuffer paramIntBuffer5, ByteBuffer paramByteBuffer) {
/*  85 */     return GL43.glGetDebugMessageLog(paramInt, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3, paramIntBuffer4, paramIntBuffer5, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glPushDebugGroup(int paramInt1, int paramInt2, String paramString) {
/*  90 */     GL43.glPushDebugGroup(paramInt1, paramInt2, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glPopDebugGroup() {
/*  95 */     GL43.glPopDebugGroup();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glObjectLabel(int paramInt1, int paramInt2, String paramString) {
/* 100 */     GL43.glObjectLabel(paramInt1, paramInt2, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String glGetObjectLabel(int paramInt1, int paramInt2) {
/* 105 */     return GL43.glGetObjectLabel(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public long glGetPointerv(int paramInt) {
/* 110 */     pb.reset();
/* 111 */     GL43.glGetPointerv(paramInt, pb);
/* 112 */     return pb.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glEnablei(int paramInt1, int paramInt2) {
/* 117 */     GL30.glEnablei(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDisablei(int paramInt1, int paramInt2) {
/* 122 */     GL30.glDisablei(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBlendEquationi(int paramInt1, int paramInt2) {
/* 127 */     GL40.glBlendEquationi(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBlendEquationSeparatei(int paramInt1, int paramInt2, int paramInt3) {
/* 132 */     GL40.glBlendEquationSeparatei(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBlendFunci(int paramInt1, int paramInt2, int paramInt3) {
/* 137 */     GL40.glBlendFunci(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBlendFuncSeparatei(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 142 */     GL40.glBlendFuncSeparatei(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glColorMaski(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 147 */     GL30.glColorMaski(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsEnabledi(int paramInt1, int paramInt2) {
/* 152 */     return GL30.glIsEnabledi(paramInt1, paramInt2);
/*     */   }
/*     */   public void glDrawElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer, int paramInt4) {
/*     */     ShortBuffer shortBuffer;
/*     */     int i;
/* 157 */     if (paramBuffer instanceof ShortBuffer && paramInt3 == 5123) {
/*     */       
/* 159 */       i = (shortBuffer = (ShortBuffer)paramBuffer).position();
/* 160 */       int j = shortBuffer.limit();
/* 161 */       shortBuffer.limit(i + paramInt2);
/* 162 */       GL32.glDrawElementsBaseVertex(paramInt1, shortBuffer, paramInt4);
/* 163 */       shortBuffer.limit(j); return;
/* 164 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐃ') {
/*     */       
/* 166 */       i = (shortBuffer = ((ByteBuffer)i).asShortBuffer()).position();
/* 167 */       int j = shortBuffer.limit();
/* 168 */       shortBuffer.limit(i + paramInt2);
/* 169 */       GL32.glDrawElementsBaseVertex(paramInt1, shortBuffer, paramInt4);
/* 170 */       shortBuffer.limit(j); return;
/* 171 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐁ') {
/*     */       ByteBuffer byteBuffer;
/* 173 */       i = (byteBuffer = (ByteBuffer)i).position();
/* 174 */       int j = byteBuffer.limit();
/* 175 */       byteBuffer.limit(i + paramInt2);
/* 176 */       GL32.glDrawElementsBaseVertex(paramInt1, byteBuffer, paramInt4);
/* 177 */       byteBuffer.limit(j); return;
/*     */     } 
/* 179 */     throw new GdxRuntimeException("Can't use " + i
/* 180 */         .getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead.");
/*     */   }
/*     */   public void glDrawRangeElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Buffer paramBuffer, int paramInt6) {
/*     */     ShortBuffer shortBuffer;
/*     */     int i;
/* 185 */     if (paramBuffer instanceof ShortBuffer && paramInt5 == 5123) {
/*     */       
/* 187 */       i = (shortBuffer = (ShortBuffer)paramBuffer).position();
/* 188 */       int j = shortBuffer.limit();
/* 189 */       shortBuffer.limit(i + paramInt4);
/* 190 */       GL32.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, shortBuffer, paramInt6);
/* 191 */       shortBuffer.limit(j); return;
/* 192 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐃ') {
/*     */       
/* 194 */       i = (shortBuffer = ((ByteBuffer)i).asShortBuffer()).position();
/* 195 */       int j = shortBuffer.limit();
/* 196 */       shortBuffer.limit(i + paramInt4);
/* 197 */       GL32.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, shortBuffer, paramInt6);
/* 198 */       shortBuffer.limit(j); return;
/* 199 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐁ') {
/*     */       ByteBuffer byteBuffer;
/* 201 */       i = (byteBuffer = (ByteBuffer)i).position();
/* 202 */       int j = byteBuffer.limit();
/* 203 */       byteBuffer.limit(i + paramInt4);
/* 204 */       GL32.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, byteBuffer, paramInt6);
/* 205 */       byteBuffer.limit(j); return;
/*     */     } 
/* 207 */     throw new GdxRuntimeException("Can't use " + i
/* 208 */         .getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead.");
/*     */   }
/*     */   
/*     */   public void glDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer, int paramInt4, int paramInt5) {
/*     */     ShortBuffer shortBuffer;
/*     */     int i;
/* 214 */     if (paramBuffer instanceof ShortBuffer && paramInt3 == 5123) {
/*     */       
/* 216 */       i = (shortBuffer = (ShortBuffer)paramBuffer).position();
/* 217 */       int j = shortBuffer.limit();
/* 218 */       shortBuffer.limit(i + paramInt2);
/* 219 */       GL32.glDrawElementsInstancedBaseVertex(paramInt1, shortBuffer, paramInt4, paramInt5);
/* 220 */       shortBuffer.limit(j); return;
/* 221 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐃ') {
/*     */       
/* 223 */       i = (shortBuffer = ((ByteBuffer)i).asShortBuffer()).position();
/* 224 */       int j = shortBuffer.limit();
/* 225 */       shortBuffer.limit(i + paramInt2);
/* 226 */       GL32.glDrawElementsInstancedBaseVertex(paramInt1, shortBuffer, paramInt4, paramInt5);
/* 227 */       shortBuffer.limit(j); return;
/* 228 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐁ') {
/*     */       ByteBuffer byteBuffer;
/* 230 */       i = (byteBuffer = (ByteBuffer)i).position();
/* 231 */       int j = byteBuffer.limit();
/* 232 */       byteBuffer.limit(i + paramInt2);
/* 233 */       GL32.glDrawElementsInstancedBaseVertex(paramInt1, byteBuffer, paramInt4, paramInt5);
/* 234 */       byteBuffer.limit(j); return;
/*     */     } 
/* 236 */     throw new GdxRuntimeException("Can't use " + i
/* 237 */         .getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 243 */     GL32.glDrawElementsInstancedBaseVertex(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glFramebufferTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 248 */     GL32.glFramebufferTexture(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGetGraphicsResetStatus() {
/* 253 */     return GL45.glGetGraphicsResetStatus();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glReadnPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer) {
/* 258 */     if (paramBuffer == null) {
/* 259 */       GL45.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, 0L); return;
/*     */     } 
/* 261 */     int i = paramBuffer.limit();
/* 262 */     paramBuffer.limit(paramInt7);
/* 263 */     if (paramBuffer instanceof ByteBuffer) {
/* 264 */       GL45.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (ByteBuffer)paramBuffer);
/* 265 */     } else if (paramBuffer instanceof IntBuffer) {
/* 266 */       GL45.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (IntBuffer)paramBuffer);
/* 267 */     } else if (paramBuffer instanceof ShortBuffer) {
/* 268 */       GL45.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (ShortBuffer)paramBuffer);
/* 269 */     } else if (paramBuffer instanceof FloatBuffer) {
/* 270 */       GL45.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (FloatBuffer)paramBuffer);
/*     */     } else {
/* 272 */       throw new GdxRuntimeException("buffer type not supported");
/*     */     } 
/* 274 */     paramBuffer.limit(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glGetnUniformfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 280 */     GL45.glGetnUniformfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetnUniformiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 285 */     GL45.glGetnUniformiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetnUniformuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 290 */     GL45.glGetnUniformuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glMinSampleShading(float paramFloat) {
/* 295 */     GL40.glMinSampleShading(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glPatchParameteri(int paramInt1, int paramInt2) {
/* 300 */     GL40.glPatchParameteri(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 305 */     GL30.glTexParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 310 */     GL30.glTexParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetTexParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 315 */     GL30.glGetTexParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetTexParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 320 */     GL30.glGetTexParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glSamplerParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 325 */     GL33.glSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glSamplerParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 330 */     GL33.glSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetSamplerParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 335 */     GL33.glGetSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetSamplerParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 340 */     GL33.glGetSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexBuffer(int paramInt1, int paramInt2, int paramInt3) {
/* 345 */     GL31.glTexBuffer(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexBufferRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 350 */     GL43.glTexBufferRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexStorage3DMultisample(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {
/* 356 */     GL43.glTexStorage3DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3GL32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */