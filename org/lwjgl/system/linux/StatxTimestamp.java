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
/*     */ @NativeType("struct statx_timestamp")
/*     */ public class StatxTimestamp
/*     */   extends Struct<StatxTimestamp>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TV_SEC;
/*     */   public static final int TV_NSEC;
/*     */   public static final int __RESERVED;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  52 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(4), __member(4) })).getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     TV_SEC = layout.offsetof(0);
/*  56 */     TV_NSEC = layout.offsetof(1);
/*  57 */     __RESERVED = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected StatxTimestamp(long paramLong, ByteBuffer paramByteBuffer) {
/*  61 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected StatxTimestamp create(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     return new StatxTimestamp(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatxTimestamp(ByteBuffer paramByteBuffer) {
/*  76 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__s64")
/*     */   public long tv_sec() {
/*  84 */     return ntv_sec(address());
/*     */   } @NativeType("__u32")
/*     */   public int tv_nsec() {
/*  87 */     return ntv_nsec(address());
/*     */   }
/*     */   public StatxTimestamp tv_sec(@NativeType("__s64") long paramLong) {
/*  90 */     ntv_sec(address(), paramLong); return this;
/*     */   } public StatxTimestamp tv_nsec(@NativeType("__u32") int paramInt) {
/*  92 */     ntv_nsec(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatxTimestamp set(long paramLong, int paramInt) {
/*  99 */     tv_sec(paramLong);
/* 100 */     tv_nsec(paramInt);
/*     */     
/* 102 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatxTimestamp set(StatxTimestamp paramStatxTimestamp) {
/* 113 */     MemoryUtil.memCopy(paramStatxTimestamp.address(), address(), SIZEOF);
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatxTimestamp malloc() {
/* 121 */     return new StatxTimestamp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatxTimestamp calloc() {
/* 126 */     return new StatxTimestamp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatxTimestamp create() {
/* 131 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 132 */     return new StatxTimestamp(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatxTimestamp create(long paramLong) {
/* 137 */     return new StatxTimestamp(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatxTimestamp createSafe(long paramLong) {
/* 143 */     return (paramLong == 0L) ? null : new StatxTimestamp(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 152 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 161 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 170 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 171 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 181 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 187 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatxTimestamp malloc(MemoryStack paramMemoryStack) {
/* 196 */     return new StatxTimestamp(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatxTimestamp calloc(MemoryStack paramMemoryStack) {
/* 205 */     return new StatxTimestamp(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 215 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 225 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long ntv_sec(long paramLong) {
/* 231 */     return UNSAFE.getLong(null, paramLong + TV_SEC);
/*     */   }
/* 233 */   public static int ntv_nsec(long paramLong) { return UNSAFE.getInt(null, paramLong + TV_NSEC); } public static int n__reserved(long paramLong) {
/* 234 */     return UNSAFE.getInt(null, paramLong + __RESERVED);
/*     */   }
/*     */   public static void ntv_sec(long paramLong1, long paramLong2) {
/* 237 */     UNSAFE.putLong(null, paramLong1 + TV_SEC, paramLong2);
/*     */   }
/* 239 */   public static void ntv_nsec(long paramLong, int paramInt) { UNSAFE.putInt(null, paramLong + TV_NSEC, paramInt); } public static void n__reserved(long paramLong, int paramInt) {
/* 240 */     UNSAFE.putInt(null, paramLong + __RESERVED, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<StatxTimestamp, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 247 */     private static final StatxTimestamp ELEMENT_FACTORY = StatxTimestamp.create(-1L);
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
/* 259 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / StatxTimestamp.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 263 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 267 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 272 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected StatxTimestamp getElementFactory() {
/* 277 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__s64")
/*     */     public long tv_sec() {
/* 282 */       return StatxTimestamp.ntv_sec(address());
/*     */     } @NativeType("__u32")
/*     */     public int tv_nsec() {
/* 285 */       return StatxTimestamp.ntv_nsec(address());
/*     */     }
/*     */     public Buffer tv_sec(@NativeType("__s64") long param1Long) {
/* 288 */       StatxTimestamp.ntv_sec(address(), param1Long); return this;
/*     */     } public Buffer tv_nsec(@NativeType("__u32") int param1Int) {
/* 290 */       StatxTimestamp.ntv_nsec(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\StatxTimestamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */