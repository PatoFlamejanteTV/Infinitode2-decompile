/*      */ package org.lwjgl.stb;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Struct;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class STBTruetype
/*      */ {
/*      */   public static final byte STBTT_vmove = 1;
/*      */   public static final byte STBTT_vline = 2;
/*      */   public static final byte STBTT_vcurve = 3;
/*      */   public static final byte STBTT_vcubic = 4;
/*      */   public static final int STBTT_MACSTYLE_DONTCARE = 0;
/*      */   public static final int STBTT_MACSTYLE_BOLD = 1;
/*      */   public static final int STBTT_MACSTYLE_ITALIC = 2;
/*      */   public static final int STBTT_MACSTYLE_UNDERSCORE = 4;
/*      */   public static final int STBTT_MACSTYLE_NONE = 8;
/*      */   public static final int STBTT_PLATFORM_ID_UNICODE = 0;
/*      */   public static final int STBTT_PLATFORM_ID_MAC = 1;
/*      */   public static final int STBTT_PLATFORM_ID_ISO = 2;
/*      */   public static final int STBTT_PLATFORM_ID_MICROSOFT = 3;
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_1_0 = 0;
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_1_1 = 1;
/*      */   public static final int STBTT_UNICODE_EID_ISO_10646 = 2;
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_2_0_BMP = 3;
/*      */   public static final int STBTT_UNICODE_EID_UNICODE_2_0_FULL = 4;
/*      */   public static final int STBTT_MS_EID_SYMBOL = 0;
/*      */   public static final int STBTT_MS_EID_UNICODE_BMP = 1;
/*      */   public static final int STBTT_MS_EID_SHIFTJIS = 2;
/*      */   public static final int STBTT_MS_EID_UNICODE_FULL = 10;
/*      */   public static final int STBTT_MAC_EID_ROMAN = 0;
/*      */   public static final int STBTT_MAC_EID_JAPANESE = 1;
/*      */   public static final int STBTT_MAC_EID_CHINESE_TRAD = 2;
/*      */   public static final int STBTT_MAC_EID_KOREAN = 3;
/*      */   public static final int STBTT_MAC_EID_ARABIC = 4;
/*      */   public static final int STBTT_MAC_EID_HEBREW = 5;
/*      */   public static final int STBTT_MAC_EID_GREEK = 6;
/*      */   public static final int STBTT_MAC_EID_RUSSIAN = 7;
/*      */   public static final int STBTT_MS_LANG_ENGLISH = 1033;
/*      */   public static final int STBTT_MS_LANG_CHINESE = 2052;
/*      */   public static final int STBTT_MS_LANG_DUTCH = 1043;
/*      */   public static final int STBTT_MS_LANG_FRENCH = 1036;
/*      */   public static final int STBTT_MS_LANG_GERMAN = 1031;
/*      */   public static final int STBTT_MS_LANG_HEBREW = 1037;
/*      */   public static final int STBTT_MS_LANG_ITALIAN = 1040;
/*      */   public static final int STBTT_MS_LANG_JAPANESE = 1041;
/*      */   public static final int STBTT_MS_LANG_KOREAN = 1042;
/*      */   public static final int STBTT_MS_LANG_RUSSIAN = 1049;
/*      */   public static final int STBTT_MS_LANG_SPANISH = 1033;
/*      */   public static final int STBTT_MS_LANG_SWEDISH = 1053;
/*      */   public static final int STBTT_MAC_LANG_ENGLISH = 0;
/*      */   public static final int STBTT_MAC_LANG_ARABIC = 12;
/*      */   public static final int STBTT_MAC_LANG_DUTCH = 4;
/*      */   public static final int STBTT_MAC_LANG_FRENCH = 1;
/*      */   public static final int STBTT_MAC_LANG_GERMAN = 2;
/*      */   public static final int STBTT_MAC_LANG_HEBREW = 10;
/*      */   public static final int STBTT_MAC_LANG_ITALIAN = 3;
/*      */   public static final int STBTT_MAC_LANG_JAPANESE = 11;
/*      */   public static final int STBTT_MAC_LANG_KOREAN = 23;
/*      */   public static final int STBTT_MAC_LANG_RUSSIAN = 32;
/*      */   public static final int STBTT_MAC_LANG_SPANISH = 6;
/*      */   public static final int STBTT_MAC_LANG_SWEDISH = 5;
/*      */   public static final int STBTT_MAC_LANG_CHINESE_SIMPLIFIED = 33;
/*      */   public static final int STBTT_MAC_LANG_CHINESE_TRAD = 19;
/*      */   
/*      */   static {
/*  259 */     LibSTB.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected STBTruetype() {
/*  342 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_BakeFontBitmap(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer1, float paramFloat, @NativeType("unsigned char *") ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, int paramInt3, @NativeType("stbtt_bakedchar *") STBTTBakedChar.Buffer paramBuffer) {
/*  371 */     if (Checks.CHECKS) {
/*  372 */       Checks.check(paramByteBuffer2, paramInt1 * paramInt2);
/*      */     }
/*  374 */     return nstbtt_BakeFontBitmap(MemoryUtil.memAddress(paramByteBuffer1), 0, paramFloat, MemoryUtil.memAddress(paramByteBuffer2), paramInt1, paramInt2, paramInt3, paramBuffer.remaining(), paramBuffer.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetBakedQuad(@NativeType("stbtt_bakedchar const *") STBTTBakedChar.Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") FloatBuffer paramFloatBuffer1, @NativeType("float *") FloatBuffer paramFloatBuffer2, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad paramSTBTTAlignedQuad, @NativeType("int") boolean paramBoolean) {
/*  398 */     if (Checks.CHECKS) {
/*  399 */       Checks.check((CustomBuffer)paramBuffer, paramInt3 + 1);
/*  400 */       Checks.check(paramFloatBuffer1, 1);
/*  401 */       Checks.check(paramFloatBuffer2, 1);
/*      */     } 
/*  403 */     nstbtt_GetBakedQuad(paramBuffer.address(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), paramSTBTTAlignedQuad.address(), paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetScaledFontVMetrics(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, int paramInt, float paramFloat, @NativeType("float *") FloatBuffer paramFloatBuffer1, @NativeType("float *") FloatBuffer paramFloatBuffer2, @NativeType("float *") FloatBuffer paramFloatBuffer3) {
/*  421 */     if (Checks.CHECKS) {
/*  422 */       Checks.check(paramFloatBuffer1, 1);
/*  423 */       Checks.check(paramFloatBuffer2, 1);
/*  424 */       Checks.check(paramFloatBuffer3, 1);
/*      */     } 
/*  426 */     nstbtt_GetScaledFontVMetrics(MemoryUtil.memAddress(paramByteBuffer), paramInt, paramFloat, MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), MemoryUtil.memAddress(paramFloatBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackBegin(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NativeType("void *") long paramLong) {
/*  450 */     if (Checks.CHECKS) {
/*  451 */       Checks.checkSafe(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/*      */     }
/*  453 */     return (nstbtt_PackBegin(paramSTBTTPackContext.address(), MemoryUtil.memAddressSafe(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramInt4, paramLong) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackBegin(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  471 */     if (Checks.CHECKS) {
/*  472 */       Checks.checkSafe(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/*      */     }
/*  474 */     return (nstbtt_PackBegin(paramSTBTTPackContext.address(), MemoryUtil.memAddressSafe(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramInt4, 0L) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackEnd(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext) {
/*  488 */     nstbtt_PackEnd(paramSTBTTPackContext.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int STBTT_POINT_SIZE(int paramInt) {
/*  502 */     return -paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackFontRange(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer, int paramInt1, float paramFloat, int paramInt2, @NativeType("stbtt_packedchar *") STBTTPackedchar.Buffer paramBuffer) {
/*  535 */     return (nstbtt_PackFontRange(paramSTBTTPackContext.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramFloat, paramInt2, paramBuffer.remaining(), paramBuffer.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackFontRanges(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer, int paramInt, @NativeType("stbtt_pack_range *") STBTTPackRange.Buffer paramBuffer) {
/*  560 */     if (Checks.CHECKS) {
/*  561 */       Struct.validate(paramBuffer.address(), paramBuffer.remaining(), STBTTPackRange.SIZEOF, STBTTPackRange::validate);
/*      */     }
/*  563 */     return (nstbtt_PackFontRanges(paramSTBTTPackContext.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt, paramBuffer.address(), paramBuffer.remaining()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackSetOversampling(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2) {
/*  587 */     nstbtt_PackSetOversampling(paramSTBTTPackContext.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackSetSkipMissingCodepoints(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("int") boolean paramBoolean) {
/*  603 */     nstbtt_PackSetSkipMissingCodepoints(paramSTBTTPackContext.address(), paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetPackedQuad(@NativeType("stbtt_packedchar const *") STBTTPackedchar.Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") FloatBuffer paramFloatBuffer1, @NativeType("float *") FloatBuffer paramFloatBuffer2, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad paramSTBTTAlignedQuad, @NativeType("int") boolean paramBoolean) {
/*  627 */     if (Checks.CHECKS) {
/*  628 */       Checks.check((CustomBuffer)paramBuffer, paramInt3 + 1);
/*  629 */       Checks.check(paramFloatBuffer1, 1);
/*  630 */       Checks.check(paramFloatBuffer2, 1);
/*      */     } 
/*  632 */     nstbtt_GetPackedQuad(paramBuffer.address(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), paramSTBTTAlignedQuad.address(), paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_PackFontRangesGatherRects(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("stbtt_fontinfo *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("stbtt_pack_range *") STBTTPackRange.Buffer paramBuffer, @NativeType("stbrp_rect *") STBRPRect.Buffer paramBuffer1) {
/*  658 */     if (Checks.CHECKS) {
/*  659 */       Struct.validate(paramBuffer.address(), paramBuffer.remaining(), STBTTPackRange.SIZEOF, STBTTPackRange::validate);
/*      */     }
/*  661 */     return nstbtt_PackFontRangesGatherRects(paramSTBTTPackContext.address(), paramSTBTTFontinfo.address(), paramBuffer.address(), paramBuffer.remaining(), paramBuffer1.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_PackFontRangesPackRects(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("stbrp_rect *") STBRPRect.Buffer paramBuffer) {
/*  680 */     nstbtt_PackFontRangesPackRects(paramSTBTTPackContext.address(), paramBuffer.address(), paramBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_PackFontRangesRenderIntoRects(@NativeType("stbtt_pack_context *") STBTTPackContext paramSTBTTPackContext, @NativeType("stbtt_fontinfo *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("stbtt_pack_range *") STBTTPackRange.Buffer paramBuffer, @NativeType("stbrp_rect *") STBRPRect.Buffer paramBuffer1) {
/*  704 */     if (Checks.CHECKS) {
/*  705 */       Struct.validate(paramBuffer.address(), paramBuffer.remaining(), STBTTPackRange.SIZEOF, STBTTPackRange::validate);
/*      */     }
/*  707 */     return (nstbtt_PackFontRangesRenderIntoRects(paramSTBTTPackContext.address(), paramSTBTTFontinfo.address(), paramBuffer.address(), paramBuffer.remaining(), paramBuffer1.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetNumberOfFonts(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer) {
/*  724 */     return nstbtt_GetNumberOfFonts(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetFontOffsetForIndex(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, int paramInt) {
/*  741 */     return nstbtt_GetFontOffsetForIndex(MemoryUtil.memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_InitFont(@NativeType("stbtt_fontinfo *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer, int paramInt) {
/*  762 */     return (nstbtt_InitFont(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_InitFont(@NativeType("stbtt_fontinfo *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer) {
/*  777 */     return (nstbtt_InitFont(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), 0) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_FindGlyphIndex(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt) {
/*  795 */     return nstbtt_FindGlyphIndex(paramSTBTTFontinfo.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float stbtt_ScaleForPixelHeight(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat) {
/*  818 */     return nstbtt_ScaleForPixelHeight(paramSTBTTFontinfo.address(), paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float stbtt_ScaleForMappingEmToPixels(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat) {
/*  836 */     return nstbtt_ScaleForMappingEmToPixels(paramSTBTTFontinfo.address(), paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontVMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3) {
/*  855 */     if (Checks.CHECKS) {
/*  856 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  857 */       Checks.checkSafe(paramIntBuffer2, 1);
/*  858 */       Checks.checkSafe(paramIntBuffer3, 1);
/*      */     } 
/*  860 */     nstbtt_GetFontVMetrics(paramSTBTTFontinfo.address(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetFontVMetricsOS2(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3) {
/*  880 */     if (Checks.CHECKS) {
/*  881 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  882 */       Checks.checkSafe(paramIntBuffer2, 1);
/*  883 */       Checks.checkSafe(paramIntBuffer3, 1);
/*      */     } 
/*  885 */     return (nstbtt_GetFontVMetricsOS2(paramSTBTTFontinfo.address(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontBoundingBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/*  903 */     if (Checks.CHECKS) {
/*  904 */       Checks.check(paramIntBuffer1, 1);
/*  905 */       Checks.check(paramIntBuffer2, 1);
/*  906 */       Checks.check(paramIntBuffer3, 1);
/*  907 */       Checks.check(paramIntBuffer4, 1);
/*      */     } 
/*  909 */     nstbtt_GetFontBoundingBox(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramIntBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/*  928 */     if (Checks.CHECKS) {
/*  929 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  930 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     } 
/*  932 */     nstbtt_GetCodepointHMetrics(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetCodepointKernAdvance(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt1, int paramInt2) {
/*  948 */     return nstbtt_GetCodepointKernAdvance(paramSTBTTFontinfo.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetCodepointBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/*  968 */     if (Checks.CHECKS) {
/*  969 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  970 */       Checks.checkSafe(paramIntBuffer2, 1);
/*  971 */       Checks.checkSafe(paramIntBuffer3, 1);
/*  972 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/*  974 */     return (nstbtt_GetCodepointBox(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/*  991 */     if (Checks.CHECKS) {
/*  992 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  993 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     } 
/*  995 */     nstbtt_GetGlyphHMetrics(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetGlyphKernAdvance(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt1, int paramInt2) {
/* 1011 */     return nstbtt_GetGlyphKernAdvance(paramSTBTTFontinfo.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetGlyphBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1031 */     if (Checks.CHECKS) {
/* 1032 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1033 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 1034 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1035 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/* 1037 */     return (nstbtt_GetGlyphBox(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetKerningTableLength(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo) {
/* 1045 */     return nstbtt_GetKerningTableLength(paramSTBTTFontinfo.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetKerningTable(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("stbtt_kerningentry *") STBTTKerningentry.Buffer paramBuffer) {
/* 1060 */     return nstbtt_GetKerningTable(paramSTBTTFontinfo.address(), paramBuffer.address(), paramBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_IsGlyphEmpty(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt) {
/* 1076 */     return (nstbtt_IsGlyphEmpty(paramSTBTTFontinfo.address(), paramInt) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetCodepointShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("stbtt_vertex **") PointerBuffer paramPointerBuffer) {
/* 1098 */     if (Checks.CHECKS) {
/* 1099 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1101 */     return nstbtt_GetCodepointShape(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static STBTTVertex.Buffer stbtt_GetCodepointShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1119 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1121 */       PointerBuffer pointerBuffer = memoryStack.pointers(0L);
/* 1122 */       int j = nstbtt_GetCodepointShape(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 1123 */       return STBTTVertex.createSafe(pointerBuffer.get(0), j);
/*      */     } finally {
/* 1125 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetGlyphShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("stbtt_vertex **") PointerBuffer paramPointerBuffer) {
/* 1142 */     if (Checks.CHECKS) {
/* 1143 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1145 */     return nstbtt_GetGlyphShape(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static STBTTVertex.Buffer stbtt_GetGlyphShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1157 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1159 */       PointerBuffer pointerBuffer = memoryStack.pointers(0L);
/* 1160 */       int j = nstbtt_GetGlyphShape(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 1161 */       return STBTTVertex.createSafe(pointerBuffer.get(0), j);
/*      */     } finally {
/* 1163 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeShape(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("stbtt_vertex *") STBTTVertex.Buffer paramBuffer) {
/* 1179 */     if (Checks.CHECKS) {
/* 1180 */       Checks.check((CustomBuffer)paramBuffer, 1);
/*      */     }
/* 1182 */     nstbtt_FreeShape(paramSTBTTFontinfo.address(), paramBuffer.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static long stbtt_FindSVGDoc(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt) {
/* 1191 */     return nstbtt_FindSVGDoc(paramSTBTTFontinfo.address(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetCodepointSVG(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("char const **") PointerBuffer paramPointerBuffer) {
/* 1205 */     if (Checks.CHECKS) {
/* 1206 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1208 */     return nstbtt_GetCodepointSVG(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_GetGlyphSVG(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("char const **") PointerBuffer paramPointerBuffer) {
/* 1222 */     if (Checks.CHECKS) {
/* 1223 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1225 */     return nstbtt_GetGlyphSVG(paramSTBTTFontinfo.address(), paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeBitmap(@NativeType("unsigned char *") ByteBuffer paramByteBuffer, @NativeType("void *") long paramLong) {
/* 1240 */     nstbtt_FreeBitmap(MemoryUtil.memAddress(paramByteBuffer), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeBitmap(@NativeType("unsigned char *") ByteBuffer paramByteBuffer) {
/* 1249 */     nstbtt_FreeBitmap(MemoryUtil.memAddress(paramByteBuffer), 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1272 */     if (Checks.CHECKS) {
/* 1273 */       Checks.check(paramIntBuffer1, 1);
/* 1274 */       Checks.check(paramIntBuffer2, 1);
/* 1275 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1276 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/*      */     long l;
/* 1279 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetCodepointBitmap(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramInt, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4)), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1304 */     if (Checks.CHECKS) {
/* 1305 */       Checks.check(paramIntBuffer1, 1);
/* 1306 */       Checks.check(paramIntBuffer2, 1);
/* 1307 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1308 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/*      */     long l;
/* 1311 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetCodepointBitmapSubpixel(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4)), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4) {
/* 1333 */     if (Checks.CHECKS) {
/* 1334 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/*      */     }
/* 1336 */     nstbtt_MakeCodepointBitmap(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4) {
/* 1359 */     if (Checks.CHECKS) {
/* 1360 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/*      */     }
/* 1362 */     nstbtt_MakeCodepointBitmapSubpixel(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, @NativeType("float *") FloatBuffer paramFloatBuffer1, @NativeType("float *") FloatBuffer paramFloatBuffer2, int paramInt6) {
/* 1389 */     if (Checks.CHECKS) {
/* 1390 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/* 1391 */       Checks.check(paramFloatBuffer1, 1);
/* 1392 */       Checks.check(paramFloatBuffer2, 1);
/*      */     } 
/* 1394 */     nstbtt_MakeCodepointBitmapSubpixelPrefilter(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1418 */     if (Checks.CHECKS) {
/* 1419 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1420 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 1421 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1422 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/* 1424 */     nstbtt_GetCodepointBitmapBox(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1447 */     if (Checks.CHECKS) {
/* 1448 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1449 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 1450 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1451 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/* 1453 */     nstbtt_GetCodepointBitmapBoxSubpixel(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1476 */     if (Checks.CHECKS) {
/* 1477 */       Checks.check(paramIntBuffer1, 1);
/* 1478 */       Checks.check(paramIntBuffer2, 1);
/* 1479 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1480 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/*      */     long l;
/* 1483 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetGlyphBitmap(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramInt, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4)), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1508 */     if (Checks.CHECKS) {
/* 1509 */       Checks.check(paramIntBuffer1, 1);
/* 1510 */       Checks.check(paramIntBuffer2, 1);
/* 1511 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1512 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/*      */     long l;
/* 1515 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetGlyphBitmapSubpixel(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4)), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4) {
/* 1537 */     if (Checks.CHECKS) {
/* 1538 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/*      */     }
/* 1540 */     nstbtt_MakeGlyphBitmap(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4) {
/* 1563 */     if (Checks.CHECKS) {
/* 1564 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/*      */     }
/* 1566 */     nstbtt_MakeGlyphBitmapSubpixel(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, @NativeType("float *") FloatBuffer paramFloatBuffer1, @NativeType("float *") FloatBuffer paramFloatBuffer2, int paramInt6) {
/* 1593 */     if (Checks.CHECKS) {
/* 1594 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/* 1595 */       Checks.check(paramFloatBuffer1, 1);
/* 1596 */       Checks.check(paramFloatBuffer2, 1);
/*      */     } 
/* 1598 */     nstbtt_MakeGlyphBitmapSubpixelPrefilter(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1622 */     if (Checks.CHECKS) {
/* 1623 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1624 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 1625 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1626 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/* 1628 */     nstbtt_GetGlyphBitmapBox(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1651 */     if (Checks.CHECKS) {
/* 1652 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1653 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 1654 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1655 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/* 1657 */     nstbtt_GetGlyphBitmapBoxSubpixel(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_Rasterize(@NativeType("stbtt__bitmap *") STBTTBitmap paramSTBTTBitmap, float paramFloat1, @NativeType("stbtt_vertex *") STBTTVertex.Buffer paramBuffer, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2, @NativeType("int") boolean paramBoolean) {
/* 1684 */     nstbtt_Rasterize(paramSTBTTBitmap.address(), paramFloat1, paramBuffer.address(), paramBuffer.remaining(), paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramInt1, paramInt2, paramBoolean ? 1 : 0, 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeSDF(@NativeType("unsigned char *") ByteBuffer paramByteBuffer, @NativeType("void *") long paramLong) {
/* 1699 */     nstbtt_FreeSDF(MemoryUtil.memAddress(paramByteBuffer), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_FreeSDF(@NativeType("unsigned char *") ByteBuffer paramByteBuffer) {
/* 1708 */     nstbtt_FreeSDF(MemoryUtil.memAddress(paramByteBuffer), 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, int paramInt1, int paramInt2, @NativeType("unsigned char") byte paramByte, float paramFloat2, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1759 */     if (Checks.CHECKS) {
/* 1760 */       Checks.check(paramIntBuffer1, 1);
/* 1761 */       Checks.check(paramIntBuffer2, 1);
/* 1762 */       Checks.check(paramIntBuffer3, 1);
/* 1763 */       Checks.check(paramIntBuffer4, 1);
/*      */     } 
/*      */     long l;
/* 1766 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetGlyphSDF(paramSTBTTFontinfo.address(), paramFloat1, paramInt1, paramInt2, paramByte, paramFloat2, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramIntBuffer4)), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, int paramInt1, int paramInt2, @NativeType("unsigned char") byte paramByte, float paramFloat2, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1792 */     if (Checks.CHECKS) {
/* 1793 */       Checks.check(paramIntBuffer1, 1);
/* 1794 */       Checks.check(paramIntBuffer2, 1);
/* 1795 */       Checks.check(paramIntBuffer3, 1);
/* 1796 */       Checks.check(paramIntBuffer4, 1);
/*      */     } 
/*      */     long l;
/* 1799 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetCodepointSDF(paramSTBTTFontinfo.address(), paramFloat1, paramInt1, paramInt2, paramByte, paramFloat2, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramIntBuffer4)), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_FindMatchingFont(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2, int paramInt) {
/* 1818 */     if (Checks.CHECKS) {
/* 1819 */       Checks.checkNT1(paramByteBuffer2);
/*      */     }
/* 1821 */     return nstbtt_FindMatchingFont(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbtt_FindMatchingFont(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("char const *") CharSequence paramCharSequence, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1835 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1837 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1838 */       long l = memoryStack.getPointerAddress();
/* 1839 */       return nstbtt_FindMatchingFont(MemoryUtil.memAddress(paramByteBuffer), l, paramInt);
/*      */     } finally {
/* 1841 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_CompareUTF8toUTF16_bigendian(@NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2) {
/* 1864 */     return (nstbtt_CompareUTF8toUTF16_bigendian(MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer2), paramByteBuffer2.remaining()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static ByteBuffer stbtt_GetFontNameString(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*      */     MemoryStack memoryStack;
/* 1895 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1896 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 1899 */       return MemoryUtil.memByteBufferSafe(l = nstbtt_GetFontNameString(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(intBuffer), paramInt1, paramInt2, paramInt3, paramInt4), intBuffer.get(0));
/*      */     } finally {
/* 1901 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetBakedQuad(@NativeType("stbtt_bakedchar const *") STBTTBakedChar.Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") float[] paramArrayOffloat1, @NativeType("float *") float[] paramArrayOffloat2, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad paramSTBTTAlignedQuad, @NativeType("int") boolean paramBoolean) {
/* 1910 */     if (Checks.CHECKS) {
/* 1911 */       Checks.check((CustomBuffer)paramBuffer, paramInt3 + 1);
/* 1912 */       Checks.check(paramArrayOffloat1, 1);
/* 1913 */       Checks.check(paramArrayOffloat2, 1);
/*      */     } 
/* 1915 */     nstbtt_GetBakedQuad(paramBuffer.address(), paramInt1, paramInt2, paramInt3, paramArrayOffloat1, paramArrayOffloat2, paramSTBTTAlignedQuad.address(), paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetScaledFontVMetrics(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, int paramInt, float paramFloat, @NativeType("float *") float[] paramArrayOffloat1, @NativeType("float *") float[] paramArrayOffloat2, @NativeType("float *") float[] paramArrayOffloat3) {
/* 1923 */     if (Checks.CHECKS) {
/* 1924 */       Checks.check(paramArrayOffloat1, 1);
/* 1925 */       Checks.check(paramArrayOffloat2, 1);
/* 1926 */       Checks.check(paramArrayOffloat3, 1);
/*      */     } 
/* 1928 */     nstbtt_GetScaledFontVMetrics(MemoryUtil.memAddress(paramByteBuffer), paramInt, paramFloat, paramArrayOffloat1, paramArrayOffloat2, paramArrayOffloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetPackedQuad(@NativeType("stbtt_packedchar const *") STBTTPackedchar.Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") float[] paramArrayOffloat1, @NativeType("float *") float[] paramArrayOffloat2, @NativeType("stbtt_aligned_quad *") STBTTAlignedQuad paramSTBTTAlignedQuad, @NativeType("int") boolean paramBoolean) {
/* 1936 */     if (Checks.CHECKS) {
/* 1937 */       Checks.check((CustomBuffer)paramBuffer, paramInt3 + 1);
/* 1938 */       Checks.check(paramArrayOffloat1, 1);
/* 1939 */       Checks.check(paramArrayOffloat2, 1);
/*      */     } 
/* 1941 */     nstbtt_GetPackedQuad(paramBuffer.address(), paramInt1, paramInt2, paramInt3, paramArrayOffloat1, paramArrayOffloat2, paramSTBTTAlignedQuad.address(), paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontVMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3) {
/* 1949 */     if (Checks.CHECKS) {
/* 1950 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 1951 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 1952 */       Checks.checkSafe(paramArrayOfint3, 1);
/*      */     } 
/* 1954 */     nstbtt_GetFontVMetrics(paramSTBTTFontinfo.address(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetFontVMetricsOS2(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3) {
/* 1963 */     if (Checks.CHECKS) {
/* 1964 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 1965 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 1966 */       Checks.checkSafe(paramArrayOfint3, 1);
/*      */     } 
/* 1968 */     return (nstbtt_GetFontVMetricsOS2(paramSTBTTFontinfo.address(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetFontBoundingBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 1976 */     if (Checks.CHECKS) {
/* 1977 */       Checks.check(paramArrayOfint1, 1);
/* 1978 */       Checks.check(paramArrayOfint2, 1);
/* 1979 */       Checks.check(paramArrayOfint3, 1);
/* 1980 */       Checks.check(paramArrayOfint4, 1);
/*      */     } 
/* 1982 */     nstbtt_GetFontBoundingBox(paramSTBTTFontinfo.address(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 1990 */     if (Checks.CHECKS) {
/* 1991 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 1992 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 1994 */     nstbtt_GetCodepointHMetrics(paramSTBTTFontinfo.address(), paramInt, paramArrayOfint1, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetCodepointBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2003 */     if (Checks.CHECKS) {
/* 2004 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2005 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 2006 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2007 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 2009 */     return (nstbtt_GetCodepointBox(paramSTBTTFontinfo.address(), paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphHMetrics(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 2017 */     if (Checks.CHECKS) {
/* 2018 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2019 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 2021 */     nstbtt_GetGlyphHMetrics(paramSTBTTFontinfo.address(), paramInt, paramArrayOfint1, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbtt_GetGlyphBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2030 */     if (Checks.CHECKS) {
/* 2031 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2032 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 2033 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2034 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 2036 */     return (nstbtt_GetGlyphBox(paramSTBTTFontinfo.address(), paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2046 */     if (Checks.CHECKS) {
/* 2047 */       Checks.check(paramArrayOfint1, 1);
/* 2048 */       Checks.check(paramArrayOfint2, 1);
/* 2049 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2050 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/*      */     long l;
/* 2053 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetCodepointBitmap(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4), paramArrayOfint1[0] * paramArrayOfint2[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2063 */     if (Checks.CHECKS) {
/* 2064 */       Checks.check(paramArrayOfint1, 1);
/* 2065 */       Checks.check(paramArrayOfint2, 1);
/* 2066 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2067 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/*      */     long l;
/* 2070 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetCodepointBitmapSubpixel(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4), paramArrayOfint1[0] * paramArrayOfint2[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeCodepointBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, @NativeType("float *") float[] paramArrayOffloat1, @NativeType("float *") float[] paramArrayOffloat2, int paramInt6) {
/* 2078 */     if (Checks.CHECKS) {
/* 2079 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/* 2080 */       Checks.check(paramArrayOffloat1, 1);
/* 2081 */       Checks.check(paramArrayOffloat2, 1);
/*      */     } 
/* 2083 */     nstbtt_MakeCodepointBitmapSubpixelPrefilter(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt4, paramInt5, paramArrayOffloat1, paramArrayOffloat2, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2091 */     if (Checks.CHECKS) {
/* 2092 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2093 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 2094 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2095 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 2097 */     nstbtt_GetCodepointBitmapBox(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetCodepointBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2105 */     if (Checks.CHECKS) {
/* 2106 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2107 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 2108 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2109 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 2111 */     nstbtt_GetCodepointBitmapBoxSubpixel(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmap(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2121 */     if (Checks.CHECKS) {
/* 2122 */       Checks.check(paramArrayOfint1, 1);
/* 2123 */       Checks.check(paramArrayOfint2, 1);
/* 2124 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2125 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/*      */     long l;
/* 2128 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetGlyphBitmap(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4), paramArrayOfint1[0] * paramArrayOfint2[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphBitmapSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2138 */     if (Checks.CHECKS) {
/* 2139 */       Checks.check(paramArrayOfint1, 1);
/* 2140 */       Checks.check(paramArrayOfint2, 1);
/* 2141 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2142 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/*      */     long l;
/* 2145 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetGlyphBitmapSubpixel(paramSTBTTFontinfo.address(), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4), paramArrayOfint1[0] * paramArrayOfint2[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_MakeGlyphBitmapSubpixelPrefilter(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, @NativeType("unsigned char *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, @NativeType("float *") float[] paramArrayOffloat1, @NativeType("float *") float[] paramArrayOffloat2, int paramInt6) {
/* 2153 */     if (Checks.CHECKS) {
/* 2154 */       Checks.check(paramByteBuffer, ((paramInt3 != 0) ? paramInt3 : paramInt1) * paramInt2);
/* 2155 */       Checks.check(paramArrayOffloat1, 1);
/* 2156 */       Checks.check(paramArrayOffloat2, 1);
/*      */     } 
/* 2158 */     nstbtt_MakeGlyphBitmapSubpixelPrefilter(paramSTBTTFontinfo.address(), MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt4, paramInt5, paramArrayOffloat1, paramArrayOffloat2, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBox(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2166 */     if (Checks.CHECKS) {
/* 2167 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2168 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 2169 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2170 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 2172 */     nstbtt_GetGlyphBitmapBox(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbtt_GetGlyphBitmapBoxSubpixel(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2180 */     if (Checks.CHECKS) {
/* 2181 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2182 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 2183 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 2184 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 2186 */     nstbtt_GetGlyphBitmapBoxSubpixel(paramSTBTTFontinfo.address(), paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetGlyphSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, int paramInt1, int paramInt2, @NativeType("unsigned char") byte paramByte, float paramFloat2, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2196 */     if (Checks.CHECKS) {
/* 2197 */       Checks.check(paramArrayOfint1, 1);
/* 2198 */       Checks.check(paramArrayOfint2, 1);
/* 2199 */       Checks.check(paramArrayOfint3, 1);
/* 2200 */       Checks.check(paramArrayOfint4, 1);
/*      */     } 
/*      */     long l;
/* 2203 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetGlyphSDF(paramSTBTTFontinfo.address(), paramFloat1, paramInt1, paramInt2, paramByte, paramFloat2, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4), paramArrayOfint1[0] * paramArrayOfint2[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char *")
/*      */   public static ByteBuffer stbtt_GetCodepointSDF(@NativeType("stbtt_fontinfo const *") STBTTFontinfo paramSTBTTFontinfo, float paramFloat1, int paramInt1, int paramInt2, @NativeType("unsigned char") byte paramByte, float paramFloat2, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 2213 */     if (Checks.CHECKS) {
/* 2214 */       Checks.check(paramArrayOfint1, 1);
/* 2215 */       Checks.check(paramArrayOfint2, 1);
/* 2216 */       Checks.check(paramArrayOfint3, 1);
/* 2217 */       Checks.check(paramArrayOfint4, 1);
/*      */     } 
/*      */     long l;
/* 2220 */     return MemoryUtil.memByteBufferSafe(l = nstbtt_GetCodepointSDF(paramSTBTTFontinfo.address(), paramFloat1, paramInt1, paramInt2, paramByte, paramFloat2, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4), paramArrayOfint1[0] * paramArrayOfint2[0]);
/*      */   }
/*      */   
/*      */   public static native int nstbtt_BakeFontBitmap(long paramLong1, int paramInt1, float paramFloat, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3);
/*      */   
/*      */   public static native void nstbtt_GetBakedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetScaledFontVMetrics(long paramLong1, int paramInt, float paramFloat, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nstbtt_PackBegin(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native void nstbtt_PackEnd(long paramLong);
/*      */   
/*      */   public static native int nstbtt_PackFontRange(long paramLong1, long paramLong2, int paramInt1, float paramFloat, int paramInt2, int paramInt3, long paramLong3);
/*      */   
/*      */   public static native int nstbtt_PackFontRanges(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nstbtt_PackSetOversampling(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nstbtt_PackSetSkipMissingCodepoints(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nstbtt_GetPackedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, int paramInt4);
/*      */   
/*      */   public static native int nstbtt_PackFontRangesGatherRects(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*      */   
/*      */   public static native void nstbtt_PackFontRangesPackRects(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_PackFontRangesRenderIntoRects(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*      */   
/*      */   public static native int nstbtt_GetNumberOfFonts(long paramLong);
/*      */   
/*      */   public static native int nstbtt_GetFontOffsetForIndex(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbtt_InitFont(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_FindGlyphIndex(long paramLong, int paramInt);
/*      */   
/*      */   public static native float nstbtt_ScaleForPixelHeight(long paramLong, float paramFloat);
/*      */   
/*      */   public static native float nstbtt_ScaleForMappingEmToPixels(long paramLong, float paramFloat);
/*      */   
/*      */   public static native void nstbtt_GetFontVMetrics(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nstbtt_GetFontVMetricsOS2(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void nstbtt_GetFontBoundingBox(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetCodepointHMetrics(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nstbtt_GetCodepointKernAdvance(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nstbtt_GetCodepointBox(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetGlyphHMetrics(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nstbtt_GetGlyphKernAdvance(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphBox(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int nstbtt_GetKerningTableLength(long paramLong);
/*      */   
/*      */   public static native int nstbtt_GetKerningTable(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_IsGlyphEmpty(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbtt_GetCodepointShape(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphShape(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nstbtt_FreeShape(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nstbtt_FindSVGDoc(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbtt_GetCodepointSVG(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphSVG(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nstbtt_FreeBitmap(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmap(long paramLong1, float paramFloat1, float paramFloat2, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmapSubpixel(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmapSubpixel(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, long paramLong3, long paramLong4, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBox(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBoxSubpixel(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmap(long paramLong1, float paramFloat1, float paramFloat2, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmapSubpixel(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmapSubpixel(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, long paramLong3, long paramLong4, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBox(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBoxSubpixel(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void nstbtt_Rasterize(long paramLong1, float paramFloat1, long paramLong2, int paramInt1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native void nstbtt_FreeSDF(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nstbtt_GetGlyphSDF(long paramLong1, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native long nstbtt_GetCodepointSDF(long paramLong1, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int nstbtt_FindMatchingFont(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nstbtt_CompareUTF8toUTF16_bigendian(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native long nstbtt_GetFontNameString(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetBakedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetScaledFontVMetrics(long paramLong, int paramInt, float paramFloat, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3);
/*      */   
/*      */   public static native void nstbtt_GetPackedQuad(long paramLong1, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2, int paramInt4);
/*      */   
/*      */   public static native void nstbtt_GetFontVMetrics(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*      */   
/*      */   public static native int nstbtt_GetFontVMetricsOS2(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*      */   
/*      */   public static native void nstbtt_GetFontBoundingBox(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetCodepointHMetrics(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2);
/*      */   
/*      */   public static native int nstbtt_GetCodepointBox(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetGlyphHMetrics(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2);
/*      */   
/*      */   public static native int nstbtt_GetGlyphBox(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmap(long paramLong, float paramFloat1, float paramFloat2, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetCodepointBitmapSubpixel(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_MakeCodepointBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBox(long paramLong, int paramInt, float paramFloat1, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetCodepointBitmapBoxSubpixel(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmap(long paramLong, float paramFloat1, float paramFloat2, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetGlyphBitmapSubpixel(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_MakeGlyphBitmapSubpixelPrefilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt6);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBox(long paramLong, int paramInt, float paramFloat1, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native void nstbtt_GetGlyphBitmapBoxSubpixel(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetGlyphSDF(long paramLong, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */   
/*      */   public static native long nstbtt_GetCodepointSDF(long paramLong, float paramFloat1, int paramInt1, int paramInt2, byte paramByte, float paramFloat2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTruetype.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */