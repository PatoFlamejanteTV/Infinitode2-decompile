/*     */ package org.lwjgl.system.windows;
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
/*     */ public class LARGE_INTEGER
/*     */   extends Struct<LARGE_INTEGER>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int U;
/*     */   public static final int U_LOWPART;
/*     */   public static final int U_HIGHPART;
/*     */   public static final int QUADPART;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  54 */     SIZEOF = (layout = __union(new Struct.Member[] { (Struct.Member)__struct(new Struct.Member[] { __member(4), __member(4) }), __member(8) })).getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     U = layout.offsetof(0);
/*  58 */     U_LOWPART = layout.offsetof(1);
/*  59 */     U_HIGHPART = layout.offsetof(2);
/*  60 */     QUADPART = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected LARGE_INTEGER(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected LARGE_INTEGER create(long paramLong, ByteBuffer paramByteBuffer) {
/*  69 */     return new LARGE_INTEGER(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LARGE_INTEGER(ByteBuffer paramByteBuffer) {
/*  79 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  83 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int u_LowPart() {
/*  87 */     return nu_LowPart(address());
/*     */   } @NativeType("LONG")
/*     */   public int u_HighPart() {
/*  90 */     return nu_HighPart(address());
/*     */   } @NativeType("LONGLONG")
/*     */   public long QuadPart() {
/*  93 */     return nQuadPart(address());
/*     */   }
/*     */   public LARGE_INTEGER u_LowPart(@NativeType("DWORD") int paramInt) {
/*  96 */     nu_LowPart(address(), paramInt); return this;
/*     */   } public LARGE_INTEGER u_HighPart(@NativeType("LONG") int paramInt) {
/*  98 */     nu_HighPart(address(), paramInt); return this;
/*     */   } public LARGE_INTEGER QuadPart(@NativeType("LONGLONG") long paramLong) {
/* 100 */     nQuadPart(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LARGE_INTEGER set(LARGE_INTEGER paramLARGE_INTEGER) {
/* 110 */     MemoryUtil.memCopy(paramLARGE_INTEGER.address(), address(), SIZEOF);
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER malloc() {
/* 118 */     return new LARGE_INTEGER(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER calloc() {
/* 123 */     return new LARGE_INTEGER(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER create() {
/* 128 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 129 */     return new LARGE_INTEGER(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER create(long paramLong) {
/* 134 */     return new LARGE_INTEGER(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER createSafe(long paramLong) {
/* 140 */     return (paramLong == 0L) ? null : new LARGE_INTEGER(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 149 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 158 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 167 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 168 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 178 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 184 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER malloc(MemoryStack paramMemoryStack) {
/* 193 */     return new LARGE_INTEGER(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER calloc(MemoryStack paramMemoryStack) {
/* 202 */     return new LARGE_INTEGER(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 212 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 222 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nu_LowPart(long paramLong) {
/* 228 */     return UNSAFE.getInt(null, paramLong + U_LOWPART);
/*     */   } public static int nu_HighPart(long paramLong) {
/* 230 */     return UNSAFE.getInt(null, paramLong + U_HIGHPART);
/*     */   } public static long nQuadPart(long paramLong) {
/* 232 */     return UNSAFE.getLong(null, paramLong + QUADPART);
/*     */   }
/*     */   public static void nu_LowPart(long paramLong, int paramInt) {
/* 235 */     UNSAFE.putInt(null, paramLong + U_LOWPART, paramInt);
/*     */   } public static void nu_HighPart(long paramLong, int paramInt) {
/* 237 */     UNSAFE.putInt(null, paramLong + U_HIGHPART, paramInt);
/*     */   } public static void nQuadPart(long paramLong1, long paramLong2) {
/* 239 */     UNSAFE.putLong(null, paramLong1 + QUADPART, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<LARGE_INTEGER, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 246 */     private static final LARGE_INTEGER ELEMENT_FACTORY = LARGE_INTEGER.create(-1L);
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
/* 258 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / LARGE_INTEGER.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 262 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 266 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 271 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected LARGE_INTEGER getElementFactory() {
/* 276 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int u_LowPart() {
/* 281 */       return LARGE_INTEGER.nu_LowPart(address());
/*     */     } @NativeType("LONG")
/*     */     public int u_HighPart() {
/* 284 */       return LARGE_INTEGER.nu_HighPart(address());
/*     */     } @NativeType("LONGLONG")
/*     */     public long QuadPart() {
/* 287 */       return LARGE_INTEGER.nQuadPart(address());
/*     */     }
/*     */     public Buffer u_LowPart(@NativeType("DWORD") int param1Int) {
/* 290 */       LARGE_INTEGER.nu_LowPart(address(), param1Int); return this;
/*     */     } public Buffer u_HighPart(@NativeType("LONG") int param1Int) {
/* 292 */       LARGE_INTEGER.nu_HighPart(address(), param1Int); return this;
/*     */     } public Buffer QuadPart(@NativeType("LONGLONG") long param1Long) {
/* 294 */       LARGE_INTEGER.nQuadPart(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\LARGE_INTEGER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */