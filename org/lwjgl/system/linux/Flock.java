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
/*     */ @NativeType("struct flock64")
/*     */ public class Flock
/*     */   extends Struct<Flock>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int L_TYPE;
/*     */   public static final int L_WHENCE;
/*     */   public static final int L_START;
/*     */   public static final int L_LEN;
/*     */   public static final int L_PID;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  56 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), __member(2), __member(8), __member(8), __member(4) })).getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     L_TYPE = layout.offsetof(0);
/*  60 */     L_WHENCE = layout.offsetof(1);
/*  61 */     L_START = layout.offsetof(2);
/*  62 */     L_LEN = layout.offsetof(3);
/*  63 */     L_PID = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected Flock(long paramLong, ByteBuffer paramByteBuffer) {
/*  67 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Flock create(long paramLong, ByteBuffer paramByteBuffer) {
/*  72 */     return new Flock(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flock(ByteBuffer paramByteBuffer) {
/*  82 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  86 */     return SIZEOF;
/*     */   }
/*     */   public short l_type() {
/*  89 */     return nl_type(address());
/*     */   } public short l_whence() {
/*  91 */     return nl_whence(address());
/*     */   } @NativeType("off_t")
/*     */   public long l_start() {
/*  94 */     return nl_start(address());
/*     */   } @NativeType("off_t")
/*     */   public long l_len() {
/*  97 */     return nl_len(address());
/*     */   } @NativeType("pid_t")
/*     */   public int l_pid() {
/* 100 */     return nl_pid(address());
/*     */   }
/*     */   public Flock l_type(short paramShort) {
/* 103 */     nl_type(address(), paramShort); return this;
/*     */   } public Flock l_whence(short paramShort) {
/* 105 */     nl_whence(address(), paramShort); return this;
/*     */   } public Flock l_start(@NativeType("off_t") long paramLong) {
/* 107 */     nl_start(address(), paramLong); return this;
/*     */   } public Flock l_len(@NativeType("off_t") long paramLong) {
/* 109 */     nl_len(address(), paramLong); return this;
/*     */   } public Flock l_pid(@NativeType("pid_t") int paramInt) {
/* 111 */     nl_pid(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flock set(short paramShort1, short paramShort2, long paramLong1, long paramLong2, int paramInt) {
/* 121 */     l_type(paramShort1);
/* 122 */     l_whence(paramShort2);
/* 123 */     l_start(paramLong1);
/* 124 */     l_len(paramLong2);
/* 125 */     l_pid(paramInt);
/*     */     
/* 127 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flock set(Flock paramFlock) {
/* 138 */     MemoryUtil.memCopy(paramFlock.address(), address(), SIZEOF);
/* 139 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Flock malloc() {
/* 146 */     return new Flock(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Flock calloc() {
/* 151 */     return new Flock(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Flock create() {
/* 156 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 157 */     return new Flock(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Flock create(long paramLong) {
/* 162 */     return new Flock(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Flock createSafe(long paramLong) {
/* 168 */     return (paramLong == 0L) ? null : new Flock(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 177 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 186 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 195 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 196 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 206 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 212 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Flock malloc(MemoryStack paramMemoryStack) {
/* 221 */     return new Flock(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Flock calloc(MemoryStack paramMemoryStack) {
/* 230 */     return new Flock(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 240 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 250 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nl_type(long paramLong) {
/* 256 */     return UNSAFE.getShort(null, paramLong + L_TYPE);
/*     */   } public static short nl_whence(long paramLong) {
/* 258 */     return UNSAFE.getShort(null, paramLong + L_WHENCE);
/*     */   } public static long nl_start(long paramLong) {
/* 260 */     return UNSAFE.getLong(null, paramLong + L_START);
/*     */   } public static long nl_len(long paramLong) {
/* 262 */     return UNSAFE.getLong(null, paramLong + L_LEN);
/*     */   } public static int nl_pid(long paramLong) {
/* 264 */     return UNSAFE.getInt(null, paramLong + L_PID);
/*     */   }
/*     */   public static void nl_type(long paramLong, short paramShort) {
/* 267 */     UNSAFE.putShort(null, paramLong + L_TYPE, paramShort);
/*     */   } public static void nl_whence(long paramLong, short paramShort) {
/* 269 */     UNSAFE.putShort(null, paramLong + L_WHENCE, paramShort);
/*     */   } public static void nl_start(long paramLong1, long paramLong2) {
/* 271 */     UNSAFE.putLong(null, paramLong1 + L_START, paramLong2);
/*     */   } public static void nl_len(long paramLong1, long paramLong2) {
/* 273 */     UNSAFE.putLong(null, paramLong1 + L_LEN, paramLong2);
/*     */   } public static void nl_pid(long paramLong, int paramInt) {
/* 275 */     UNSAFE.putInt(null, paramLong + L_PID, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Flock, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 282 */     private static final Flock ELEMENT_FACTORY = Flock.create(-1L);
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
/* 294 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / Flock.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 298 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 302 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 307 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Flock getElementFactory() {
/* 312 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public short l_type() {
/* 316 */       return Flock.nl_type(address());
/*     */     } public short l_whence() {
/* 318 */       return Flock.nl_whence(address());
/*     */     } @NativeType("off_t")
/*     */     public long l_start() {
/* 321 */       return Flock.nl_start(address());
/*     */     } @NativeType("off_t")
/*     */     public long l_len() {
/* 324 */       return Flock.nl_len(address());
/*     */     } @NativeType("pid_t")
/*     */     public int l_pid() {
/* 327 */       return Flock.nl_pid(address());
/*     */     }
/*     */     public Buffer l_type(short param1Short) {
/* 330 */       Flock.nl_type(address(), param1Short); return this;
/*     */     } public Buffer l_whence(short param1Short) {
/* 332 */       Flock.nl_whence(address(), param1Short); return this;
/*     */     } public Buffer l_start(@NativeType("off_t") long param1Long) {
/* 334 */       Flock.nl_start(address(), param1Long); return this;
/*     */     } public Buffer l_len(@NativeType("off_t") long param1Long) {
/* 336 */       Flock.nl_len(address(), param1Long); return this;
/*     */     } public Buffer l_pid(@NativeType("pid_t") int param1Int) {
/* 338 */       Flock.nl_pid(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\Flock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */