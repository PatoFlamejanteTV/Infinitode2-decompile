/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ @NativeType("struct sockaddr")
/*     */ public class Sockaddr
/*     */   extends Struct<Sockaddr>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SA_FAMILY;
/*     */   public static final int SA_DATA;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  50 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), __array(1, 14) })).getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     SA_FAMILY = layout.offsetof(0);
/*  54 */     SA_DATA = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected Sockaddr(long paramLong, ByteBuffer paramByteBuffer) {
/*  58 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Sockaddr create(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     return new Sockaddr(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sockaddr(ByteBuffer paramByteBuffer) {
/*  73 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  77 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("sa_family_t")
/*     */   public short sa_family() {
/*  81 */     return nsa_family(address());
/*     */   } @NativeType("char[14]")
/*     */   public ByteBuffer sa_data() {
/*  84 */     return nsa_data(address());
/*     */   } @NativeType("char")
/*     */   public byte sa_data(int paramInt) {
/*  87 */     return nsa_data(address(), paramInt);
/*     */   }
/*     */   public Sockaddr sa_family(@NativeType("sa_family_t") short paramShort) {
/*  90 */     nsa_family(address(), paramShort); return this;
/*     */   } public Sockaddr sa_data(@NativeType("char[14]") ByteBuffer paramByteBuffer) {
/*  92 */     nsa_data(address(), paramByteBuffer); return this;
/*     */   } public Sockaddr sa_data(int paramInt, @NativeType("char") byte paramByte) {
/*  94 */     nsa_data(address(), paramInt, paramByte); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sockaddr set(short paramShort, ByteBuffer paramByteBuffer) {
/* 101 */     sa_family(paramShort);
/* 102 */     sa_data(paramByteBuffer);
/*     */     
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sockaddr set(Sockaddr paramSockaddr) {
/* 115 */     MemoryUtil.memCopy(paramSockaddr.address(), address(), SIZEOF);
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Sockaddr malloc() {
/* 123 */     return new Sockaddr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sockaddr calloc() {
/* 128 */     return new Sockaddr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sockaddr create() {
/* 133 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 134 */     return new Sockaddr(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sockaddr create(long paramLong) {
/* 139 */     return new Sockaddr(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Sockaddr createSafe(long paramLong) {
/* 145 */     return (paramLong == 0L) ? null : new Sockaddr(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 154 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 163 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 172 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 173 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 183 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 189 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Sockaddr malloc(MemoryStack paramMemoryStack) {
/* 198 */     return new Sockaddr(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Sockaddr calloc(MemoryStack paramMemoryStack) {
/* 207 */     return new Sockaddr(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 217 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 227 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nsa_family(long paramLong) {
/* 233 */     return UNSAFE.getShort(null, paramLong + SA_FAMILY);
/*     */   } public static ByteBuffer nsa_data(long paramLong) {
/* 235 */     return MemoryUtil.memByteBuffer(paramLong + SA_DATA, 14);
/*     */   }
/*     */   public static byte nsa_data(long paramLong, int paramInt) {
/* 238 */     return UNSAFE.getByte(null, paramLong + SA_DATA + Checks.check(paramInt, 14));
/*     */   }
/*     */   
/*     */   public static void nsa_family(long paramLong, short paramShort) {
/* 242 */     UNSAFE.putShort(null, paramLong + SA_FAMILY, paramShort);
/*     */   }
/*     */   public static void nsa_data(long paramLong, ByteBuffer paramByteBuffer) {
/* 245 */     if (Checks.CHECKS) Checks.checkGT(paramByteBuffer, 14); 
/* 246 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramByteBuffer), paramLong + SA_DATA, paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public static void nsa_data(long paramLong, int paramInt, byte paramByte) {
/* 250 */     UNSAFE.putByte(null, paramLong + SA_DATA + Checks.check(paramInt, 14), paramByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Sockaddr, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 258 */     private static final Sockaddr ELEMENT_FACTORY = Sockaddr.create(-1L);
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
/* 270 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / Sockaddr.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 274 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 278 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 283 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Sockaddr getElementFactory() {
/* 288 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("sa_family_t")
/*     */     public short sa_family() {
/* 293 */       return Sockaddr.nsa_family(address());
/*     */     } @NativeType("char[14]")
/*     */     public ByteBuffer sa_data() {
/* 296 */       return Sockaddr.nsa_data(address());
/*     */     } @NativeType("char")
/*     */     public byte sa_data(int param1Int) {
/* 299 */       return Sockaddr.nsa_data(address(), param1Int);
/*     */     }
/*     */     public Buffer sa_family(@NativeType("sa_family_t") short param1Short) {
/* 302 */       Sockaddr.nsa_family(address(), param1Short); return this;
/*     */     } public Buffer sa_data(@NativeType("char[14]") ByteBuffer param1ByteBuffer) {
/* 304 */       Sockaddr.nsa_data(address(), param1ByteBuffer); return this;
/*     */     } public Buffer sa_data(int param1Int, @NativeType("char") byte param1Byte) {
/* 306 */       Sockaddr.nsa_data(address(), param1Int, param1Byte); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\Sockaddr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */