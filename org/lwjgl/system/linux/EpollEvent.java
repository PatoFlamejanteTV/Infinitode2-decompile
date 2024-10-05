/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.function.Consumer;
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
/*     */ @NativeType("struct epoll_event")
/*     */ public class EpollEvent
/*     */   extends Struct<EpollEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int EVENTS;
/*     */   public static final int DATA;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  47 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(EpollData.SIZEOF, EpollData.ALIGNOF) })).getSize();
/*  48 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  50 */     EVENTS = layout.offsetof(0);
/*  51 */     DATA = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected EpollEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  55 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected EpollEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  60 */     return new EpollEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollEvent(ByteBuffer paramByteBuffer) {
/*  70 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  74 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("uint32_t")
/*     */   public int events() {
/*  78 */     return nevents(address());
/*     */   } @NativeType("epoll_data_t")
/*     */   public EpollData data() {
/*  81 */     return ndata(address());
/*     */   }
/*     */   public EpollEvent events(@NativeType("uint32_t") int paramInt) {
/*  84 */     nevents(address(), paramInt); return this;
/*     */   } public EpollEvent data(@NativeType("epoll_data_t") EpollData paramEpollData) {
/*  86 */     ndata(address(), paramEpollData); return this;
/*     */   } public EpollEvent data(Consumer<EpollData> paramConsumer) {
/*  88 */     paramConsumer.accept(data()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollEvent set(int paramInt, EpollData paramEpollData) {
/*  95 */     events(paramInt);
/*  96 */     data(paramEpollData);
/*     */     
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollEvent set(EpollEvent paramEpollEvent) {
/* 109 */     MemoryUtil.memCopy(paramEpollEvent.address(), address(), SIZEOF);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollEvent malloc() {
/* 117 */     return new EpollEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollEvent calloc() {
/* 122 */     return new EpollEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollEvent create() {
/* 127 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 128 */     return new EpollEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollEvent create(long paramLong) {
/* 133 */     return new EpollEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollEvent createSafe(long paramLong) {
/* 139 */     return (paramLong == 0L) ? null : new EpollEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 148 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 157 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 166 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 167 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 177 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 183 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollEvent malloc(MemoryStack paramMemoryStack) {
/* 192 */     return new EpollEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollEvent calloc(MemoryStack paramMemoryStack) {
/* 201 */     return new EpollEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 211 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 221 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nevents(long paramLong) {
/* 227 */     return UNSAFE.getInt(null, paramLong + EVENTS);
/*     */   } public static EpollData ndata(long paramLong) {
/* 229 */     return EpollData.create(paramLong + DATA);
/*     */   }
/*     */   public static void nevents(long paramLong, int paramInt) {
/* 232 */     UNSAFE.putInt(null, paramLong + EVENTS, paramInt);
/*     */   } public static void ndata(long paramLong, EpollData paramEpollData) {
/* 234 */     MemoryUtil.memCopy(paramEpollData.address(), paramLong + DATA, EpollData.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<EpollEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 241 */     private static final EpollEvent ELEMENT_FACTORY = EpollEvent.create(-1L);
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
/* 253 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / EpollEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 257 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 261 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 266 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected EpollEvent getElementFactory() {
/* 271 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("uint32_t")
/*     */     public int events() {
/* 276 */       return EpollEvent.nevents(address());
/*     */     } @NativeType("epoll_data_t")
/*     */     public EpollData data() {
/* 279 */       return EpollEvent.ndata(address());
/*     */     }
/*     */     public Buffer events(@NativeType("uint32_t") int param1Int) {
/* 282 */       EpollEvent.nevents(address(), param1Int); return this;
/*     */     } public Buffer data(@NativeType("epoll_data_t") EpollData param1EpollData) {
/* 284 */       EpollEvent.ndata(address(), param1EpollData); return this;
/*     */     } public Buffer data(Consumer<EpollData> param1Consumer) {
/* 286 */       param1Consumer.accept(data()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\EpollEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */