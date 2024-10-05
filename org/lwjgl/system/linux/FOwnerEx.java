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
/*     */ @NativeType("struct f_owner_ex")
/*     */ public class FOwnerEx
/*     */   extends Struct<FOwnerEx>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int PID;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  47 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4) })).getSize();
/*  48 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  50 */     TYPE = layout.offsetof(0);
/*  51 */     PID = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected FOwnerEx(long paramLong, ByteBuffer paramByteBuffer) {
/*  55 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FOwnerEx create(long paramLong, ByteBuffer paramByteBuffer) {
/*  60 */     return new FOwnerEx(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FOwnerEx(ByteBuffer paramByteBuffer) {
/*  70 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  74 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  77 */     return ntype(address());
/*     */   } @NativeType("pid_t")
/*     */   public int pid() {
/*  80 */     return npid(address());
/*     */   }
/*     */   public FOwnerEx type(int paramInt) {
/*  83 */     ntype(address(), paramInt); return this;
/*     */   } public FOwnerEx pid(@NativeType("pid_t") int paramInt) {
/*  85 */     npid(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FOwnerEx set(int paramInt1, int paramInt2) {
/*  92 */     type(paramInt1);
/*  93 */     pid(paramInt2);
/*     */     
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FOwnerEx set(FOwnerEx paramFOwnerEx) {
/* 106 */     MemoryUtil.memCopy(paramFOwnerEx.address(), address(), SIZEOF);
/* 107 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FOwnerEx malloc() {
/* 114 */     return new FOwnerEx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FOwnerEx calloc() {
/* 119 */     return new FOwnerEx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FOwnerEx create() {
/* 124 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 125 */     return new FOwnerEx(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FOwnerEx create(long paramLong) {
/* 130 */     return new FOwnerEx(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FOwnerEx createSafe(long paramLong) {
/* 136 */     return (paramLong == 0L) ? null : new FOwnerEx(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 145 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 154 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 163 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 164 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 174 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 180 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FOwnerEx malloc(MemoryStack paramMemoryStack) {
/* 189 */     return new FOwnerEx(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FOwnerEx calloc(MemoryStack paramMemoryStack) {
/* 198 */     return new FOwnerEx(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 208 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 218 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 224 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static int npid(long paramLong) {
/* 226 */     return UNSAFE.getInt(null, paramLong + PID);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 229 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void npid(long paramLong, int paramInt) {
/* 231 */     UNSAFE.putInt(null, paramLong + PID, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FOwnerEx, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 238 */     private static final FOwnerEx ELEMENT_FACTORY = FOwnerEx.create(-1L);
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
/* 250 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / FOwnerEx.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 254 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 258 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 263 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected FOwnerEx getElementFactory() {
/* 268 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 272 */       return FOwnerEx.ntype(address());
/*     */     } @NativeType("pid_t")
/*     */     public int pid() {
/* 275 */       return FOwnerEx.npid(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 278 */       FOwnerEx.ntype(address(), param1Int); return this;
/*     */     } public Buffer pid(@NativeType("pid_t") int param1Int) {
/* 280 */       FOwnerEx.npid(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\FOwnerEx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */