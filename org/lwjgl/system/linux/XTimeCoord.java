/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public class XTimeCoord
/*     */   extends Struct<XTimeCoord>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TIME;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  47 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(CLONG_SIZE), __member(2), __member(2) })).getSize();
/*  48 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  50 */     TIME = layout.offsetof(0);
/*  51 */     X = layout.offsetof(1);
/*  52 */     Y = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected XTimeCoord(long paramLong, ByteBuffer paramByteBuffer) {
/*  56 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XTimeCoord create(long paramLong, ByteBuffer paramByteBuffer) {
/*  61 */     return new XTimeCoord(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XTimeCoord(ByteBuffer paramByteBuffer) {
/*  71 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  75 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("Time")
/*     */   public long time() {
/*  79 */     return ntime(address());
/*     */   } public short x() {
/*  81 */     return nx(address());
/*     */   } public short y() {
/*  83 */     return ny(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XTimeCoord create(long paramLong) {
/*  89 */     return new XTimeCoord(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XTimeCoord createSafe(long paramLong) {
/*  95 */     return (paramLong == 0L) ? null : new XTimeCoord(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 105 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 111 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long ntime(long paramLong) {
/* 117 */     return MemoryUtil.memGetCLong(paramLong + TIME);
/*     */   } public static short nx(long paramLong) {
/* 119 */     return UNSAFE.getShort(null, paramLong + X);
/*     */   } public static short ny(long paramLong) {
/* 121 */     return UNSAFE.getShort(null, paramLong + Y);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XTimeCoord, Buffer>
/*     */   {
/* 128 */     private static final XTimeCoord ELEMENT_FACTORY = XTimeCoord.create(-1L);
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
/* 140 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XTimeCoord.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 144 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 148 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 153 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XTimeCoord getElementFactory() {
/* 158 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("Time")
/*     */     public long time() {
/* 163 */       return XTimeCoord.ntime(address());
/*     */     } public short x() {
/* 165 */       return XTimeCoord.nx(address());
/*     */     } public short y() {
/* 167 */       return XTimeCoord.ny(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XTimeCoord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */