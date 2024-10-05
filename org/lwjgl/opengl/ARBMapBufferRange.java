/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class ARBMapBufferRange
/*     */ {
/*     */   public static final int GL_MAP_READ_BIT = 1;
/*     */   public static final int GL_MAP_WRITE_BIT = 2;
/*     */   public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
/*     */   public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
/*     */   public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
/*     */   public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
/*     */   
/*     */   static {
/*  34 */     GL.initialize();
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
/*     */   protected ARBMapBufferRange() {
/*  46 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglMapBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  53 */     return GL30C.nglMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2) {
/*  74 */     return GL30C.glMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2, ByteBuffer paramByteBuffer) {
/*  95 */     return GL30C.glMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2, paramByteBuffer);
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
/*     */   public static void glFlushMappedBufferRange(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 108 */     GL30C.glFlushMappedBufferRange(paramInt, paramLong1, paramLong2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBMapBufferRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */