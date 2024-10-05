/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
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
/*     */ @NativeType("struct open_how")
/*     */ public class OpenHow
/*     */   extends Struct<OpenHow>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int FLAGS;
/*     */   public static final int MODE;
/*     */   public static final int RESOLVE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  57 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(8), __member(8) })).getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     FLAGS = layout.offsetof(0);
/*  61 */     MODE = layout.offsetof(1);
/*  62 */     RESOLVE = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected OpenHow(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected OpenHow create(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     return new OpenHow(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenHow(ByteBuffer paramByteBuffer) {
/*  81 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long flags() {
/*  89 */     return nflags(address());
/*     */   } @NativeType("__u64")
/*     */   public long mode() {
/*  92 */     return nmode(address());
/*     */   } @NativeType("__u64")
/*     */   public long resolve() {
/*  95 */     return nresolve(address());
/*     */   }
/*     */   public OpenHow flags(@NativeType("__u64") long paramLong) {
/*  98 */     nflags(address(), paramLong); return this;
/*     */   } public OpenHow mode(@NativeType("__u64") long paramLong) {
/* 100 */     nmode(address(), paramLong); return this;
/*     */   } public OpenHow resolve(@NativeType("__u64") long paramLong) {
/* 102 */     nresolve(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenHow set(long paramLong1, long paramLong2, long paramLong3) {
/* 110 */     flags(paramLong1);
/* 111 */     mode(paramLong2);
/* 112 */     resolve(paramLong3);
/*     */     
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenHow set(OpenHow paramOpenHow) {
/* 125 */     MemoryUtil.memCopy(paramOpenHow.address(), address(), SIZEOF);
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OpenHow malloc() {
/* 133 */     return new OpenHow(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static OpenHow calloc() {
/* 138 */     return new OpenHow(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static OpenHow create() {
/* 143 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 144 */     return new OpenHow(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static OpenHow create(long paramLong) {
/* 149 */     return new OpenHow(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static OpenHow createSafe(long paramLong) {
/* 155 */     return (paramLong == 0L) ? null : new OpenHow(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 164 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 173 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 182 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 183 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 193 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 199 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OpenHow malloc(MemoryStack paramMemoryStack) {
/* 208 */     return new OpenHow(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OpenHow calloc(MemoryStack paramMemoryStack) {
/* 217 */     return new OpenHow(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 227 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 237 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nflags(long paramLong) {
/* 243 */     return UNSAFE.getLong(null, paramLong + FLAGS);
/*     */   } public static long nmode(long paramLong) {
/* 245 */     return UNSAFE.getLong(null, paramLong + MODE);
/*     */   } public static long nresolve(long paramLong) {
/* 247 */     return UNSAFE.getLong(null, paramLong + RESOLVE);
/*     */   }
/*     */   public static void nflags(long paramLong1, long paramLong2) {
/* 250 */     UNSAFE.putLong(null, paramLong1 + FLAGS, paramLong2);
/*     */   } public static void nmode(long paramLong1, long paramLong2) {
/* 252 */     UNSAFE.putLong(null, paramLong1 + MODE, paramLong2);
/*     */   } public static void nresolve(long paramLong1, long paramLong2) {
/* 254 */     UNSAFE.putLong(null, paramLong1 + RESOLVE, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<OpenHow, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 261 */     private static final OpenHow ELEMENT_FACTORY = OpenHow.create(-1L);
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
/*     */     public Buffer(ByteBuffer param1ByteBuffer) {
/* 273 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / OpenHow.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 277 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 281 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 286 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected OpenHow getElementFactory() {
/* 291 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long flags() {
/* 296 */       return OpenHow.nflags(address());
/*     */     } @NativeType("__u64")
/*     */     public long mode() {
/* 299 */       return OpenHow.nmode(address());
/*     */     } @NativeType("__u64")
/*     */     public long resolve() {
/* 302 */       return OpenHow.nresolve(address());
/*     */     }
/*     */     public Buffer flags(@NativeType("__u64") long param1Long) {
/* 305 */       OpenHow.nflags(address(), param1Long); return this;
/*     */     } public Buffer mode(@NativeType("__u64") long param1Long) {
/* 307 */       OpenHow.nmode(address(), param1Long); return this;
/*     */     } public Buffer resolve(@NativeType("__u64") long param1Long) {
/* 309 */       OpenHow.nresolve(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\OpenHow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */