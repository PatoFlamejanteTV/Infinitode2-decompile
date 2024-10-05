/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stbtt_pack_range")
/*     */ public class STBTTPackRange
/*     */   extends Struct<STBTTPackRange>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int FONT_SIZE;
/*     */   public static final int FIRST_UNICODE_CODEPOINT_IN_RANGE;
/*     */   public static final int ARRAY_OF_UNICODE_CODEPOINTS;
/*     */   public static final int NUM_CHARS;
/*     */   public static final int CHARDATA_FOR_RANGE;
/*     */   public static final int H_OVERSAMPLE;
/*     */   public static final int V_OVERSAMPLE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  65 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(POINTER_SIZE), __member(4), __member(POINTER_SIZE), __member(1), __member(1) })).getSize();
/*  66 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  68 */     FONT_SIZE = layout.offsetof(0);
/*  69 */     FIRST_UNICODE_CODEPOINT_IN_RANGE = layout.offsetof(1);
/*  70 */     ARRAY_OF_UNICODE_CODEPOINTS = layout.offsetof(2);
/*  71 */     NUM_CHARS = layout.offsetof(3);
/*  72 */     CHARDATA_FOR_RANGE = layout.offsetof(4);
/*  73 */     H_OVERSAMPLE = layout.offsetof(5);
/*  74 */     V_OVERSAMPLE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected STBTTPackRange(long paramLong, ByteBuffer paramByteBuffer) {
/*  78 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTPackRange create(long paramLong, ByteBuffer paramByteBuffer) {
/*  83 */     return new STBTTPackRange(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackRange(ByteBuffer paramByteBuffer) {
/*  93 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  97 */     return SIZEOF;
/*     */   }
/*     */   public float font_size() {
/* 100 */     return nfont_size(address());
/*     */   } public int first_unicode_codepoint_in_range() {
/* 102 */     return nfirst_unicode_codepoint_in_range(address());
/*     */   }
/*     */   @NativeType("int *")
/*     */   public IntBuffer array_of_unicode_codepoints() {
/* 106 */     return narray_of_unicode_codepoints(address());
/*     */   } public int num_chars() {
/* 108 */     return nnum_chars(address());
/*     */   } @NativeType("stbtt_packedchar *")
/*     */   public STBTTPackedchar.Buffer chardata_for_range() {
/* 111 */     return nchardata_for_range(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte h_oversample() {
/* 114 */     return nh_oversample(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte v_oversample() {
/* 117 */     return nv_oversample(address());
/*     */   }
/*     */   public STBTTPackRange font_size(float paramFloat) {
/* 120 */     nfont_size(address(), paramFloat); return this;
/*     */   } public STBTTPackRange first_unicode_codepoint_in_range(int paramInt) {
/* 122 */     nfirst_unicode_codepoint_in_range(address(), paramInt); return this;
/*     */   } public STBTTPackRange array_of_unicode_codepoints(@NativeType("int *") IntBuffer paramIntBuffer) {
/* 124 */     narray_of_unicode_codepoints(address(), paramIntBuffer); return this;
/*     */   } public STBTTPackRange num_chars(int paramInt) {
/* 126 */     nnum_chars(address(), paramInt); return this;
/*     */   } public STBTTPackRange chardata_for_range(@NativeType("stbtt_packedchar *") STBTTPackedchar.Buffer paramBuffer) {
/* 128 */     nchardata_for_range(address(), paramBuffer); return this;
/*     */   } public STBTTPackRange h_oversample(@NativeType("unsigned char") byte paramByte) {
/* 130 */     nh_oversample(address(), paramByte); return this;
/*     */   } public STBTTPackRange v_oversample(@NativeType("unsigned char") byte paramByte) {
/* 132 */     nv_oversample(address(), paramByte); return this;
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
/*     */   public STBTTPackRange set(float paramFloat, int paramInt1, IntBuffer paramIntBuffer, int paramInt2, STBTTPackedchar.Buffer paramBuffer, byte paramByte1, byte paramByte2) {
/* 144 */     font_size(paramFloat);
/* 145 */     first_unicode_codepoint_in_range(paramInt1);
/* 146 */     array_of_unicode_codepoints(paramIntBuffer);
/* 147 */     num_chars(paramInt2);
/* 148 */     chardata_for_range(paramBuffer);
/* 149 */     h_oversample(paramByte1);
/* 150 */     v_oversample(paramByte2);
/*     */     
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackRange set(STBTTPackRange paramSTBTTPackRange) {
/* 163 */     MemoryUtil.memCopy(paramSTBTTPackRange.address(), address(), SIZEOF);
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackRange malloc() {
/* 171 */     return new STBTTPackRange(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackRange calloc() {
/* 176 */     return new STBTTPackRange(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackRange create() {
/* 181 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 182 */     return new STBTTPackRange(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackRange create(long paramLong) {
/* 187 */     return new STBTTPackRange(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackRange createSafe(long paramLong) {
/* 193 */     return (paramLong == 0L) ? null : new STBTTPackRange(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 202 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 211 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 220 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 221 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 231 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 237 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTPackRange mallocStack() {
/* 243 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 245 */   public static STBTTPackRange callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 247 */   public static STBTTPackRange mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 249 */   public static STBTTPackRange callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 251 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 253 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 255 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 257 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackRange malloc(MemoryStack paramMemoryStack) {
/* 265 */     return new STBTTPackRange(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackRange calloc(MemoryStack paramMemoryStack) {
/* 274 */     return new STBTTPackRange(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 284 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 294 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float nfont_size(long paramLong) {
/* 300 */     return UNSAFE.getFloat(null, paramLong + FONT_SIZE);
/*     */   } public static int nfirst_unicode_codepoint_in_range(long paramLong) {
/* 302 */     return UNSAFE.getInt(null, paramLong + FIRST_UNICODE_CODEPOINT_IN_RANGE);
/*     */   } public static IntBuffer narray_of_unicode_codepoints(long paramLong) {
/* 304 */     return MemoryUtil.memIntBufferSafe(MemoryUtil.memGetAddress(paramLong + ARRAY_OF_UNICODE_CODEPOINTS), nnum_chars(paramLong));
/*     */   } public static int nnum_chars(long paramLong) {
/* 306 */     return UNSAFE.getInt(null, paramLong + NUM_CHARS);
/*     */   } public static STBTTPackedchar.Buffer nchardata_for_range(long paramLong) {
/* 308 */     return STBTTPackedchar.create(MemoryUtil.memGetAddress(paramLong + CHARDATA_FOR_RANGE), nnum_chars(paramLong));
/*     */   } public static byte nh_oversample(long paramLong) {
/* 310 */     return UNSAFE.getByte(null, paramLong + H_OVERSAMPLE);
/*     */   } public static byte nv_oversample(long paramLong) {
/* 312 */     return UNSAFE.getByte(null, paramLong + V_OVERSAMPLE);
/*     */   }
/*     */   public static void nfont_size(long paramLong, float paramFloat) {
/* 315 */     UNSAFE.putFloat(null, paramLong + FONT_SIZE, paramFloat);
/*     */   } public static void nfirst_unicode_codepoint_in_range(long paramLong, int paramInt) {
/* 317 */     UNSAFE.putInt(null, paramLong + FIRST_UNICODE_CODEPOINT_IN_RANGE, paramInt);
/*     */   } public static void narray_of_unicode_codepoints(long paramLong, IntBuffer paramIntBuffer) {
/* 319 */     MemoryUtil.memPutAddress(paramLong + ARRAY_OF_UNICODE_CODEPOINTS, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   } public static void nnum_chars(long paramLong, int paramInt) {
/* 321 */     UNSAFE.putInt(null, paramLong + NUM_CHARS, paramInt);
/*     */   } public static void nchardata_for_range(long paramLong, STBTTPackedchar.Buffer paramBuffer) {
/* 323 */     MemoryUtil.memPutAddress(paramLong + CHARDATA_FOR_RANGE, paramBuffer.address());
/*     */   } public static void nh_oversample(long paramLong, byte paramByte) {
/* 325 */     UNSAFE.putByte(null, paramLong + H_OVERSAMPLE, paramByte);
/*     */   } public static void nv_oversample(long paramLong, byte paramByte) {
/* 327 */     UNSAFE.putByte(null, paramLong + V_OVERSAMPLE, paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 335 */     Checks.check(MemoryUtil.memGetAddress(paramLong + CHARDATA_FOR_RANGE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTPackRange, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 343 */     private static final STBTTPackRange ELEMENT_FACTORY = STBTTPackRange.create(-1L);
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
/* 355 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTPackRange.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 359 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 363 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 368 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTPackRange getElementFactory() {
/* 373 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public float font_size() {
/* 377 */       return STBTTPackRange.nfont_size(address());
/*     */     } public int first_unicode_codepoint_in_range() {
/* 379 */       return STBTTPackRange.nfirst_unicode_codepoint_in_range(address());
/*     */     }
/*     */     @NativeType("int *")
/*     */     public IntBuffer array_of_unicode_codepoints() {
/* 383 */       return STBTTPackRange.narray_of_unicode_codepoints(address());
/*     */     } public int num_chars() {
/* 385 */       return STBTTPackRange.nnum_chars(address());
/*     */     } @NativeType("stbtt_packedchar *")
/*     */     public STBTTPackedchar.Buffer chardata_for_range() {
/* 388 */       return STBTTPackRange.nchardata_for_range(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte h_oversample() {
/* 391 */       return STBTTPackRange.nh_oversample(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte v_oversample() {
/* 394 */       return STBTTPackRange.nv_oversample(address());
/*     */     }
/*     */     public Buffer font_size(float param1Float) {
/* 397 */       STBTTPackRange.nfont_size(address(), param1Float); return this;
/*     */     } public Buffer first_unicode_codepoint_in_range(int param1Int) {
/* 399 */       STBTTPackRange.nfirst_unicode_codepoint_in_range(address(), param1Int); return this;
/*     */     } public Buffer array_of_unicode_codepoints(@NativeType("int *") IntBuffer param1IntBuffer) {
/* 401 */       STBTTPackRange.narray_of_unicode_codepoints(address(), param1IntBuffer); return this;
/*     */     } public Buffer num_chars(int param1Int) {
/* 403 */       STBTTPackRange.nnum_chars(address(), param1Int); return this;
/*     */     } public Buffer chardata_for_range(@NativeType("stbtt_packedchar *") STBTTPackedchar.Buffer param1Buffer) {
/* 405 */       STBTTPackRange.nchardata_for_range(address(), param1Buffer); return this;
/*     */     } public Buffer h_oversample(@NativeType("unsigned char") byte param1Byte) {
/* 407 */       STBTTPackRange.nh_oversample(address(), param1Byte); return this;
/*     */     } public Buffer v_oversample(@NativeType("unsigned char") byte param1Byte) {
/* 409 */       STBTTPackRange.nv_oversample(address(), param1Byte); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTPackRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */