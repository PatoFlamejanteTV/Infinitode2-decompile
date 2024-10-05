/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NVPathRendering
/*      */ {
/*      */   public static final byte GL_CLOSE_PATH_NV = 0;
/*      */   public static final byte GL_MOVE_TO_NV = 2;
/*      */   public static final byte GL_RELATIVE_MOVE_TO_NV = 3;
/*      */   public static final byte GL_LINE_TO_NV = 4;
/*      */   public static final byte GL_RELATIVE_LINE_TO_NV = 5;
/*      */   public static final byte GL_HORIZONTAL_LINE_TO_NV = 6;
/*      */   public static final byte GL_RELATIVE_HORIZONTAL_LINE_TO_NV = 7;
/*      */   public static final byte GL_VERTICAL_LINE_TO_NV = 8;
/*      */   public static final byte GL_RELATIVE_VERTICAL_LINE_TO_NV = 9;
/*      */   public static final byte GL_QUADRATIC_CURVE_TO_NV = 10;
/*      */   public static final byte GL_RELATIVE_QUADRATIC_CURVE_TO_NV = 11;
/*      */   public static final byte GL_CUBIC_CURVE_TO_NV = 12;
/*      */   public static final byte GL_RELATIVE_CUBIC_CURVE_TO_NV = 13;
/*      */   public static final byte GL_SMOOTH_QUADRATIC_CURVE_TO_NV = 14;
/*      */   public static final byte GL_RELATIVE_SMOOTH_QUADRATIC_CURVE_TO_NV = 15;
/*      */   public static final byte GL_SMOOTH_CUBIC_CURVE_TO_NV = 16;
/*      */   public static final byte GL_RELATIVE_SMOOTH_CUBIC_CURVE_TO_NV = 17;
/*      */   public static final byte GL_SMALL_CCW_ARC_TO_NV = 18;
/*      */   public static final byte GL_RELATIVE_SMALL_CCW_ARC_TO_NV = 19;
/*      */   public static final byte GL_SMALL_CW_ARC_TO_NV = 20;
/*      */   public static final byte GL_RELATIVE_SMALL_CW_ARC_TO_NV = 21;
/*      */   public static final byte GL_LARGE_CCW_ARC_TO_NV = 22;
/*      */   public static final byte GL_RELATIVE_LARGE_CCW_ARC_TO_NV = 23;
/*      */   public static final byte GL_LARGE_CW_ARC_TO_NV = 24;
/*      */   public static final byte GL_RELATIVE_LARGE_CW_ARC_TO_NV = 25;
/*      */   public static final byte GL_CONIC_CURVE_TO_NV = 26;
/*      */   public static final byte GL_RELATIVE_CONIC_CURVE_TO_NV = 27;
/*      */   public static final byte GL_ROUNDED_RECT_NV = -24;
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT_NV = -23;
/*      */   public static final byte GL_ROUNDED_RECT2_NV = -22;
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT2_NV = -21;
/*      */   public static final byte GL_ROUNDED_RECT4_NV = -20;
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT4_NV = -19;
/*      */   public static final byte GL_ROUNDED_RECT8_NV = -18;
/*      */   public static final byte GL_RELATIVE_ROUNDED_RECT8_NV = -17;
/*      */   public static final byte GL_RESTART_PATH_NV = -16;
/*      */   public static final byte GL_DUP_FIRST_CUBIC_CURVE_TO_NV = -14;
/*      */   public static final byte GL_DUP_LAST_CUBIC_CURVE_TO_NV = -12;
/*      */   public static final byte GL_RECT_NV = -10;
/*      */   public static final byte GL_RELATIVE_RECT_NV = -9;
/*      */   public static final byte GL_CIRCULAR_CCW_ARC_TO_NV = -8;
/*      */   
/*      */   static {
/*   86 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte GL_CIRCULAR_CW_ARC_TO_NV = -6;
/*      */ 
/*      */   
/*      */   public static final byte GL_CIRCULAR_TANGENT_ARC_TO_NV = -4;
/*      */ 
/*      */   
/*      */   public static final byte GL_ARC_TO_NV = -2;
/*      */ 
/*      */   
/*      */   public static final byte GL_RELATIVE_ARC_TO_NV = -1;
/*      */ 
/*      */   
/*      */   public static final int GL_PATH_FORMAT_SVG_NV = 36976;
/*      */ 
/*      */   
/*      */   public static final int GL_PATH_FORMAT_PS_NV = 36977;
/*      */ 
/*      */   
/*      */   public static final int GL_STANDARD_FONT_NAME_NV = 36978;
/*      */ 
/*      */   
/*      */   public static final int GL_SYSTEM_FONT_NAME_NV = 36979;
/*      */ 
/*      */   
/*      */   public static final int GL_FILE_NAME_NV = 36980;
/*      */ 
/*      */   
/*      */   public static final int GL_STANDARD_FONT_FORMAT_NV = 37740;
/*      */ 
/*      */   
/*      */   public static final int GL_SKIP_MISSING_GLYPH_NV = 37033;
/*      */ 
/*      */   
/*      */   public static final int GL_USE_MISSING_GLYPH_NV = 37034;
/*      */ 
/*      */   
/*      */   public static final int GL_FONT_GLYPHS_AVAILABLE_NV = 37736;
/*      */ 
/*      */   
/*      */   public static final int GL_FONT_TARGET_UNAVAILABLE_NV = 37737;
/*      */ 
/*      */   
/*      */   public static final int GL_FONT_UNAVAILABLE_NV = 37738;
/*      */ 
/*      */   
/*      */   public static final int GL_FONT_UNINTELLIGIBLE_NV = 37739;
/*      */ 
/*      */   
/*      */   public static final int GL_PATH_STROKE_WIDTH_NV = 36981;
/*      */   
/*      */   public static final int GL_PATH_INITIAL_END_CAP_NV = 36983;
/*      */   
/*      */   public static final int GL_PATH_TERMINAL_END_CAP_NV = 36984;
/*      */   
/*      */   public static final int GL_PATH_JOIN_STYLE_NV = 36985;
/*      */   
/*      */   public static final int GL_PATH_MITER_LIMIT_NV = 36986;
/*      */   
/*      */   public static final int GL_PATH_INITIAL_DASH_CAP_NV = 36988;
/*      */   
/*      */   public static final int GL_PATH_TERMINAL_DASH_CAP_NV = 36989;
/*      */   
/*      */   public static final int GL_PATH_DASH_OFFSET_NV = 36990;
/*      */   
/*      */   public static final int GL_PATH_CLIENT_LENGTH_NV = 36991;
/*      */   
/*      */   public static final int GL_PATH_DASH_OFFSET_RESET_NV = 37044;
/*      */   
/*      */   public static final int GL_PATH_FILL_MODE_NV = 36992;
/*      */   
/*      */   public static final int GL_PATH_FILL_MASK_NV = 36993;
/*      */   
/*      */   public static final int GL_PATH_FILL_COVER_MODE_NV = 36994;
/*      */   
/*      */   public static final int GL_PATH_STROKE_COVER_MODE_NV = 36995;
/*      */   
/*      */   public static final int GL_PATH_STROKE_MASK_NV = 36996;
/*      */   
/*      */   public static final int GL_PATH_STROKE_BOUND_NV = 36998;
/*      */   
/*      */   public static final int GL_PATH_END_CAPS_NV = 36982;
/*      */   
/*      */   public static final int GL_PATH_DASH_CAPS_NV = 36987;
/*      */   
/*      */   public static final int GL_COUNT_UP_NV = 37000;
/*      */   
/*      */   public static final int GL_COUNT_DOWN_NV = 37001;
/*      */   
/*      */   public static final int GL_PRIMARY_COLOR_NV = 34092;
/*      */   
/*      */   public static final int GL_SECONDARY_COLOR_NV = 34093;
/*      */   
/*      */   public static final int GL_PATH_OBJECT_BOUNDING_BOX_NV = 37002;
/*      */   
/*      */   public static final int GL_CONVEX_HULL_NV = 37003;
/*      */   
/*      */   public static final int GL_BOUNDING_BOX_NV = 37005;
/*      */   
/*      */   public static final int GL_TRANSLATE_X_NV = 37006;
/*      */   
/*      */   public static final int GL_TRANSLATE_Y_NV = 37007;
/*      */   
/*      */   public static final int GL_TRANSLATE_2D_NV = 37008;
/*      */   
/*      */   public static final int GL_TRANSLATE_3D_NV = 37009;
/*      */   
/*      */   public static final int GL_AFFINE_2D_NV = 37010;
/*      */   
/*      */   public static final int GL_AFFINE_3D_NV = 37012;
/*      */   
/*      */   public static final int GL_TRANSPOSE_AFFINE_2D_NV = 37014;
/*      */   
/*      */   public static final int GL_TRANSPOSE_AFFINE_3D_NV = 37016;
/*      */   
/*      */   public static final int GL_UTF8_NV = 37018;
/*      */   
/*      */   public static final int GL_UTF16_NV = 37019;
/*      */   
/*      */   public static final int GL_BOUNDING_BOX_OF_BOUNDING_BOXES_NV = 37020;
/*      */   
/*      */   public static final int GL_PATH_COMMAND_COUNT_NV = 37021;
/*      */   
/*      */   public static final int GL_PATH_COORD_COUNT_NV = 37022;
/*      */   
/*      */   public static final int GL_PATH_DASH_ARRAY_COUNT_NV = 37023;
/*      */   
/*      */   public static final int GL_PATH_COMPUTED_LENGTH_NV = 37024;
/*      */   
/*      */   public static final int GL_PATH_FILL_BOUNDING_BOX_NV = 37025;
/*      */   
/*      */   public static final int GL_PATH_STROKE_BOUNDING_BOX_NV = 37026;
/*      */   
/*      */   public static final int GL_SQUARE_NV = 37027;
/*      */   
/*      */   public static final int GL_ROUND_NV = 37028;
/*      */   
/*      */   public static final int GL_TRIANGULAR_NV = 37029;
/*      */   
/*      */   public static final int GL_BEVEL_NV = 37030;
/*      */   
/*      */   public static final int GL_MITER_REVERT_NV = 37031;
/*      */   
/*      */   public static final int GL_MITER_TRUNCATE_NV = 37032;
/*      */   
/*      */   public static final int GL_MOVE_TO_RESETS_NV = 37045;
/*      */   
/*      */   public static final int GL_MOVE_TO_CONTINUES_NV = 37046;
/*      */   
/*      */   public static final int GL_BOLD_BIT_NV = 1;
/*      */   
/*      */   public static final int GL_ITALIC_BIT_NV = 2;
/*      */   
/*      */   public static final int GL_PATH_ERROR_POSITION_NV = 37035;
/*      */   
/*      */   public static final int GL_PATH_FOG_GEN_MODE_NV = 37036;
/*      */   
/*      */   public static final int GL_PATH_STENCIL_FUNC_NV = 37047;
/*      */   
/*      */   public static final int GL_PATH_STENCIL_REF_NV = 37048;
/*      */   
/*      */   public static final int GL_PATH_STENCIL_VALUE_MASK_NV = 37049;
/*      */   
/*      */   public static final int GL_PATH_STENCIL_DEPTH_OFFSET_FACTOR_NV = 37053;
/*      */   
/*      */   public static final int GL_PATH_STENCIL_DEPTH_OFFSET_UNITS_NV = 37054;
/*      */   
/*      */   public static final int GL_PATH_COVER_DEPTH_FUNC_NV = 37055;
/*      */   
/*      */   public static final int GL_GLYPH_WIDTH_BIT_NV = 1;
/*      */   
/*      */   public static final int GL_GLYPH_HEIGHT_BIT_NV = 2;
/*      */   
/*      */   public static final int GL_GLYPH_HORIZONTAL_BEARING_X_BIT_NV = 4;
/*      */   
/*      */   public static final int GL_GLYPH_HORIZONTAL_BEARING_Y_BIT_NV = 8;
/*      */   
/*      */   public static final int GL_GLYPH_HORIZONTAL_BEARING_ADVANCE_BIT_NV = 16;
/*      */   
/*      */   public static final int GL_GLYPH_VERTICAL_BEARING_X_BIT_NV = 32;
/*      */   
/*      */   public static final int GL_GLYPH_VERTICAL_BEARING_Y_BIT_NV = 64;
/*      */   
/*      */   public static final int GL_GLYPH_VERTICAL_BEARING_ADVANCE_BIT_NV = 128;
/*      */   
/*      */   public static final int GL_GLYPH_HAS_KERNING_BIT_NV = 256;
/*      */   
/*      */   public static final int GL_FONT_X_MIN_BOUNDS_BIT_NV = 65536;
/*      */   
/*      */   public static final int GL_FONT_Y_MIN_BOUNDS_BIT_NV = 131072;
/*      */   
/*      */   public static final int GL_FONT_X_MAX_BOUNDS_BIT_NV = 262144;
/*      */   
/*      */   public static final int GL_FONT_Y_MAX_BOUNDS_BIT_NV = 524288;
/*      */   
/*      */   public static final int GL_FONT_UNITS_PER_EM_BIT_NV = 1048576;
/*      */   
/*      */   public static final int GL_FONT_ASCENDER_BIT_NV = 2097152;
/*      */   
/*      */   public static final int GL_FONT_DESCENDER_BIT_NV = 4194304;
/*      */   
/*      */   public static final int GL_FONT_HEIGHT_BIT_NV = 8388608;
/*      */   
/*      */   public static final int GL_FONT_MAX_ADVANCE_WIDTH_BIT_NV = 16777216;
/*      */   
/*      */   public static final int GL_FONT_MAX_ADVANCE_HEIGHT_BIT_NV = 33554432;
/*      */   
/*      */   public static final int GL_FONT_UNDERLINE_POSITION_BIT_NV = 67108864;
/*      */   
/*      */   public static final int GL_FONT_UNDERLINE_THICKNESS_BIT_NV = 134217728;
/*      */   
/*      */   public static final int GL_FONT_HAS_KERNING_BIT_NV = 268435456;
/*      */   
/*      */   public static final int GL_FONT_NUM_GLYPH_INDICES_BIT_NV = 536870912;
/*      */   
/*      */   public static final int GL_ACCUM_ADJACENT_PAIRS_NV = 37037;
/*      */   
/*      */   public static final int GL_ADJACENT_PAIRS_NV = 37038;
/*      */   
/*      */   public static final int GL_FIRST_TO_REST_NV = 37039;
/*      */   
/*      */   public static final int GL_PATH_GEN_MODE_NV = 37040;
/*      */   
/*      */   public static final int GL_PATH_GEN_COEFF_NV = 37041;
/*      */   
/*      */   public static final int GL_PATH_GEN_COLOR_FORMAT_NV = 37042;
/*      */   
/*      */   public static final int GL_PATH_GEN_COMPONENTS_NV = 37043;
/*      */   
/*      */   public static final int GL_FRAGMENT_INPUT_NV = 37741;
/*      */   
/*      */   public static final int GL_PATH_PROJECTION_NV = 5889;
/*      */   
/*      */   public static final int GL_PATH_MODELVIEW_NV = 5888;
/*      */   
/*      */   public static final int GL_PATH_MODELVIEW_STACK_DEPTH_NV = 2979;
/*      */   
/*      */   public static final int GL_PATH_MODELVIEW_MATRIX_NV = 2982;
/*      */   
/*      */   public static final int GL_PATH_MAX_MODELVIEW_STACK_DEPTH_NV = 3382;
/*      */   
/*      */   public static final int GL_PATH_TRANSPOSE_MODELVIEW_MATRIX_NV = 34019;
/*      */   
/*      */   public static final int GL_PATH_PROJECTION_STACK_DEPTH_NV = 2980;
/*      */   
/*      */   public static final int GL_PATH_PROJECTION_MATRIX_NV = 2983;
/*      */   
/*      */   public static final int GL_PATH_MAX_PROJECTION_STACK_DEPTH_NV = 3384;
/*      */   
/*      */   public static final int GL_PATH_TRANSPOSE_PROJECTION_MATRIX_NV = 34020;
/*      */   
/*      */   public static final int GL_2_BYTES_NV = 5127;
/*      */   
/*      */   public static final int GL_3_BYTES_NV = 5128;
/*      */   
/*      */   public static final int GL_4_BYTES_NV = 5129;
/*      */   
/*      */   public static final int GL_EYE_LINEAR_NV = 9216;
/*      */   
/*      */   public static final int GL_OBJECT_LINEAR_NV = 9217;
/*      */   
/*      */   public static final int GL_CONSTANT_NV = 34166;
/*      */ 
/*      */   
/*      */   protected NVPathRendering() {
/*  355 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer2) {
/*  365 */     nglPathCommandsNV(paramInt1, paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining() >> GLChecks.typeToByteShift(paramInt2), paramInt2, MemoryUtil.memAddress(paramByteBuffer2));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  370 */     nglPathCommandsNV(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), (int)(paramShortBuffer.remaining() << 1L >> GLChecks.typeToByteShift(paramInt2)), paramInt2, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  375 */     nglPathCommandsNV(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), (int)(paramFloatBuffer.remaining() << 2L >> GLChecks.typeToByteShift(paramInt2)), paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  385 */     nglPathCoordsNV(paramInt1, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt2), paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  390 */     nglPathCoordsNV(paramInt1, (int)(paramShortBuffer.remaining() << 1L >> GLChecks.typeToByteShift(paramInt2)), paramInt2, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  395 */     nglPathCoordsNV(paramInt1, (int)(paramFloatBuffer.remaining() << 2L >> GLChecks.typeToByteShift(paramInt2)), paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer1, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer2) {
/*  405 */     nglPathSubCommandsNV(paramInt1, paramInt2, paramInt3, paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining() >> GLChecks.typeToByteShift(paramInt4), paramInt4, MemoryUtil.memAddress(paramByteBuffer2));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  410 */     nglPathSubCommandsNV(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), (int)(paramShortBuffer.remaining() << 1L >> GLChecks.typeToByteShift(paramInt4)), paramInt4, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  415 */     nglPathSubCommandsNV(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), (int)(paramFloatBuffer.remaining() << 2L >> GLChecks.typeToByteShift(paramInt4)), paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  425 */     nglPathSubCoordsNV(paramInt1, paramInt2, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt3), paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  430 */     nglPathSubCoordsNV(paramInt1, paramInt2, (int)(paramShortBuffer.remaining() << 1L >> GLChecks.typeToByteShift(paramInt3)), paramInt3, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  435 */     nglPathSubCoordsNV(paramInt1, paramInt2, (int)(paramFloatBuffer.remaining() << 2L >> GLChecks.typeToByteShift(paramInt3)), paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathStringNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  445 */     nglPathStringNV(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glPathGlyphsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer1, @NativeType("GLbitfield") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer2, @NativeType("GLenum") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLfloat") float paramFloat) {
/*  460 */     if (Checks.CHECKS) {
/*  461 */       Checks.checkNT1(paramByteBuffer1);
/*      */     }
/*  463 */     nglPathGlyphsNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer1), paramInt3, paramByteBuffer2.remaining() / charcodeTypeToBytes(paramInt4), paramInt4, MemoryUtil.memAddress(paramByteBuffer2), paramInt5, paramInt6, paramFloat);
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
/*      */   public static void glPathGlyphRangeNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLfloat") float paramFloat) {
/*  477 */     if (Checks.CHECKS) {
/*  478 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  480 */     nglPathGlyphRangeNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramFloat);
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
/*      */   @NativeType("GLenum")
/*      */   public static int glPathGlyphIndexArrayNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLfloat") float paramFloat) {
/*  494 */     if (Checks.CHECKS) {
/*  495 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  497 */     return nglPathGlyphIndexArrayNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4, paramInt5, paramInt6, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glPathMemoryGlyphIndexArrayNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLfloat") float paramFloat) {
/*  508 */     return nglPathMemoryGlyphIndexArrayNV(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4, paramInt5, paramInt6, paramFloat);
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
/*      */   public static void glWeightPathsNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  520 */     if (Checks.CHECKS) {
/*  521 */       Checks.check(paramFloatBuffer, paramIntBuffer.remaining());
/*      */     }
/*  523 */     nglWeightPathsNV(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glTransformPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  537 */     if (Checks.CHECKS) {
/*  538 */       Checks.check(paramFloatBuffer, transformTypeToElements(paramInt3));
/*      */     }
/*  540 */     nglTransformPathNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  550 */     if (Checks.CHECKS) {
/*  551 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  553 */     nglPathParameterivNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glPathParameterfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  568 */     if (Checks.CHECKS) {
/*  569 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  571 */     nglPathParameterfvNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glPathDashArrayNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  584 */     nglPathDashArrayNV(paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glStencilFillPathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  629 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/*  630 */     if (Checks.CHECKS) {
/*  631 */       Checks.check(paramFloatBuffer, i * transformTypeToElements(paramInt5));
/*      */     }
/*  633 */     nglStencilFillPathInstancedNV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glStencilStrokePathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  646 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/*  647 */     if (Checks.CHECKS) {
/*  648 */       Checks.check(paramFloatBuffer, i * transformTypeToElements(paramInt5));
/*      */     }
/*  650 */     nglStencilStrokePathInstancedNV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glPathColorGenNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  668 */     if (Checks.CHECKS) {
/*  669 */       Checks.check(paramFloatBuffer, genModeToElements(paramInt2) * colorFormatToComponents(paramInt3));
/*      */     }
/*  671 */     nglPathColorGenNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPathTexGenNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  679 */     if (Checks.CHECKS) {
/*  680 */       Checks.check(paramFloatBuffer, genModeToElements(paramInt2) * paramInt3);
/*      */     }
/*  682 */     nglPathTexGenNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glCoverFillPathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  710 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/*  711 */     if (Checks.CHECKS) {
/*  712 */       Checks.check(paramFloatBuffer, i * transformTypeToElements(paramInt4));
/*      */     }
/*  714 */     nglCoverFillPathInstancedNV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glCoverStrokePathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  728 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/*  729 */     if (Checks.CHECKS) {
/*  730 */       Checks.check(paramFloatBuffer, i * transformTypeToElements(paramInt4));
/*      */     }
/*  732 */     nglCoverStrokePathInstancedNV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glStencilThenCoverFillPathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  760 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/*  761 */     if (Checks.CHECKS) {
/*  762 */       Checks.check(paramFloatBuffer, i * transformTypeToElements(paramInt6));
/*      */     }
/*  764 */     nglStencilThenCoverFillPathInstancedNV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glStencilThenCoverStrokePathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  778 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/*  779 */     if (Checks.CHECKS) {
/*  780 */       Checks.check(paramFloatBuffer, i * transformTypeToElements(paramInt6));
/*      */     }
/*  782 */     nglStencilThenCoverStrokePathInstancedNV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   @NativeType("GLenum")
/*      */   public static int glPathGlyphIndexRangeNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  796 */     if (Checks.CHECKS) {
/*  797 */       Checks.checkNT1(paramByteBuffer);
/*  798 */       Checks.check(paramIntBuffer, 2);
/*      */     } 
/*  800 */     return nglPathGlyphIndexRangeNV(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramFloat, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramPathFragmentInputGenNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  808 */     if (Checks.CHECKS) {
/*  809 */       Checks.check(paramFloatBuffer, genModeToElements(paramInt3) * paramInt4);
/*      */     }
/*  811 */     nglProgramPathFragmentInputGenNV(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  821 */     if (Checks.CHECKS) {
/*  822 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  824 */     nglGetPathParameterivNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetPathParameteriNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  830 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  832 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  833 */       nglGetPathParameterivNV(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  834 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  836 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  847 */     if (Checks.CHECKS) {
/*  848 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  850 */     nglGetPathParameterfvNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetPathParameterfNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  856 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  858 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  859 */       nglGetPathParameterfvNV(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/*  860 */       return floatBuffer.get(0);
/*      */     } finally {
/*  862 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathCommandsNV(@NativeType("GLuint") int paramInt, @NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/*  871 */     if (Checks.CHECKS && 
/*  872 */       Checks.DEBUG) {
/*  873 */       Checks.check(paramByteBuffer, glGetPathParameteriNV(paramInt, 37021));
/*      */     }
/*      */     
/*  876 */     nglGetPathCommandsNV(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathCoordsNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  884 */     if (Checks.CHECKS && 
/*  885 */       Checks.DEBUG) {
/*  886 */       Checks.check(paramFloatBuffer, glGetPathParameteriNV(paramInt, 37022));
/*      */     }
/*      */     
/*  889 */     nglGetPathCoordsNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathDashArrayNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  897 */     if (Checks.CHECKS && 
/*  898 */       Checks.DEBUG) {
/*  899 */       Checks.check(paramFloatBuffer, glGetPathParameteriNV(paramInt, 37023));
/*      */     }
/*      */     
/*  902 */     nglGetPathDashArrayNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetPathMetricsNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  915 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt2);
/*  916 */     if (Checks.CHECKS) {
/*  917 */       Checks.check(paramFloatBuffer, i * ((paramInt4 == 0) ? Integer.bitCount(paramInt1) : (paramInt4 >> 2)));
/*      */     }
/*  919 */     nglGetPathMetricsNV(paramInt1, i, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathMetricRangeNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  929 */     if (Checks.CHECKS) {
/*  930 */       Checks.check(paramFloatBuffer, paramInt3 * ((paramInt4 == 0) ? Integer.bitCount(paramInt1) : (paramInt4 >> 2)));
/*      */     }
/*  932 */     nglGetPathMetricRangeNV(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetPathSpacingNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  946 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt2);
/*  947 */     if (Checks.CHECKS) {
/*  948 */       Checks.check(paramFloatBuffer, (i - 1) * ((paramInt4 == 37006) ? 1 : 2));
/*      */     }
/*  950 */     nglGetPathSpacingNV(paramInt1, i, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramFloat1, paramFloat2, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetPathColorGenivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  963 */     if (Checks.CHECKS) {
/*  964 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  966 */     nglGetPathColorGenivNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetPathColorGeniNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  975 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  977 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  978 */       nglGetPathColorGenivNV(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  979 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  981 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetPathColorGenfvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  995 */     if (Checks.CHECKS) {
/*  996 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  998 */     nglGetPathColorGenfvNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetPathColorGenfNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1007 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1009 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1010 */       nglGetPathColorGenfvNV(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1011 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1013 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1024 */     if (Checks.CHECKS) {
/* 1025 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1027 */     nglGetPathTexGenivNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetPathTexGeniNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1033 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1035 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1036 */       nglGetPathTexGenivNV(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1037 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1039 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenfvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1050 */     if (Checks.CHECKS) {
/* 1051 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1053 */     nglGetPathTexGenfvNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetPathTexGenfNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1059 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1061 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1062 */       nglGetPathTexGenfvNV(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1063 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1065 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glPointAlongPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer1, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer4) {
/* 1090 */     if (Checks.CHECKS) {
/* 1091 */       Checks.checkSafe(paramFloatBuffer1, 1);
/* 1092 */       Checks.checkSafe(paramFloatBuffer2, 1);
/* 1093 */       Checks.checkSafe(paramFloatBuffer3, 1);
/* 1094 */       Checks.checkSafe(paramFloatBuffer4, 1);
/*      */     } 
/* 1096 */     return nglPointAlongPathNV(paramInt1, paramInt2, paramInt3, paramFloat, MemoryUtil.memAddressSafe(paramFloatBuffer1), MemoryUtil.memAddressSafe(paramFloatBuffer2), MemoryUtil.memAddressSafe(paramFloatBuffer3), MemoryUtil.memAddressSafe(paramFloatBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x2fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1106 */     if (Checks.CHECKS) {
/* 1107 */       Checks.check(paramFloatBuffer, 6);
/*      */     }
/* 1109 */     nglMatrixLoad3x2fNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1119 */     if (Checks.CHECKS) {
/* 1120 */       Checks.check(paramFloatBuffer, 9);
/*      */     }
/* 1122 */     nglMatrixLoad3x3fNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTranspose3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1132 */     if (Checks.CHECKS) {
/* 1133 */       Checks.check(paramFloatBuffer, 9);
/*      */     }
/* 1135 */     nglMatrixLoadTranspose3x3fNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x2fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1145 */     if (Checks.CHECKS) {
/* 1146 */       Checks.check(paramFloatBuffer, 6);
/*      */     }
/* 1148 */     nglMatrixMult3x2fNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1158 */     if (Checks.CHECKS) {
/* 1159 */       Checks.check(paramFloatBuffer, 9);
/*      */     }
/* 1161 */     nglMatrixMult3x3fNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTranspose3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1171 */     if (Checks.CHECKS) {
/* 1172 */       Checks.check(paramFloatBuffer, 9);
/*      */     }
/* 1174 */     nglMatrixMultTranspose3x3fNV(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourcefvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum const *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1182 */     if (Checks.CHECKS) {
/* 1183 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     }
/* 1185 */     nglGetProgramResourcefvNV(paramInt1, paramInt2, paramInt3, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), paramFloatBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1190 */     long l = (GL.getICD()).glPathCommandsNV;
/* 1191 */     if (Checks.CHECKS) {
/* 1192 */       Checks.check(l);
/*      */     }
/* 1194 */     JNI.callPPV(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramArrayOfshort.length, paramInt2, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1199 */     long l = (GL.getICD()).glPathCommandsNV;
/* 1200 */     if (Checks.CHECKS) {
/* 1201 */       Checks.check(l);
/*      */     }
/* 1203 */     JNI.callPPV(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramArrayOffloat.length, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1208 */     long l = (GL.getICD()).glPathCoordsNV;
/* 1209 */     if (Checks.CHECKS) {
/* 1210 */       Checks.check(l);
/*      */     }
/* 1212 */     JNI.callPV(paramInt1, paramArrayOfshort.length, paramInt2, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1217 */     long l = (GL.getICD()).glPathCoordsNV;
/* 1218 */     if (Checks.CHECKS) {
/* 1219 */       Checks.check(l);
/*      */     }
/* 1221 */     JNI.callPV(paramInt1, paramArrayOffloat.length, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1226 */     long l = (GL.getICD()).glPathSubCommandsNV;
/* 1227 */     if (Checks.CHECKS) {
/* 1228 */       Checks.check(l);
/*      */     }
/* 1230 */     JNI.callPPV(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramArrayOfshort.length, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCommandsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1235 */     long l = (GL.getICD()).glPathSubCommandsNV;
/* 1236 */     if (Checks.CHECKS) {
/* 1237 */       Checks.check(l);
/*      */     }
/* 1239 */     JNI.callPPV(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramArrayOffloat.length, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1244 */     long l = (GL.getICD()).glPathSubCoordsNV;
/* 1245 */     if (Checks.CHECKS) {
/* 1246 */       Checks.check(l);
/*      */     }
/* 1248 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfshort.length, paramInt3, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathSubCoordsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1253 */     long l = (GL.getICD()).glPathSubCoordsNV;
/* 1254 */     if (Checks.CHECKS) {
/* 1255 */       Checks.check(l);
/*      */     }
/* 1257 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glWeightPathsNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1262 */     long l = (GL.getICD()).glWeightPathsNV;
/* 1263 */     if (Checks.CHECKS) {
/* 1264 */       Checks.check(l);
/* 1265 */       Checks.check(paramArrayOffloat, paramArrayOfint.length);
/*      */     } 
/* 1267 */     JNI.callPPV(paramInt, paramArrayOfint.length, paramArrayOfint, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTransformPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1272 */     long l = (GL.getICD()).glTransformPathNV;
/* 1273 */     if (Checks.CHECKS) {
/* 1274 */       Checks.check(l);
/* 1275 */       Checks.check(paramArrayOffloat, transformTypeToElements(paramInt3));
/*      */     } 
/* 1277 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1282 */     long l = (GL.getICD()).glPathParameterivNV;
/* 1283 */     if (Checks.CHECKS) {
/* 1284 */       Checks.check(l);
/* 1285 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1287 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathParameterfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1292 */     long l = (GL.getICD()).glPathParameterfvNV;
/* 1293 */     if (Checks.CHECKS) {
/* 1294 */       Checks.check(l);
/* 1295 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1297 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathDashArrayNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1302 */     long l = (GL.getICD()).glPathDashArrayNV;
/* 1303 */     if (Checks.CHECKS) {
/* 1304 */       Checks.check(l);
/*      */     }
/* 1306 */     JNI.callPV(paramInt, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilFillPathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1311 */     long l = (GL.getICD()).glStencilFillPathInstancedNV;
/* 1312 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/* 1313 */     if (Checks.CHECKS) {
/* 1314 */       Checks.check(l);
/* 1315 */       Checks.check(paramArrayOffloat, i * transformTypeToElements(paramInt5));
/*      */     } 
/* 1317 */     JNI.callPPV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilStrokePathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1322 */     long l = (GL.getICD()).glStencilStrokePathInstancedNV;
/* 1323 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/* 1324 */     if (Checks.CHECKS) {
/* 1325 */       Checks.check(l);
/* 1326 */       Checks.check(paramArrayOffloat, i * transformTypeToElements(paramInt5));
/*      */     } 
/* 1328 */     JNI.callPPV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathColorGenNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1333 */     long l = (GL.getICD()).glPathColorGenNV;
/* 1334 */     if (Checks.CHECKS) {
/* 1335 */       Checks.check(l);
/* 1336 */       Checks.check(paramArrayOffloat, genModeToElements(paramInt2) * colorFormatToComponents(paramInt3));
/*      */     } 
/* 1338 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glPathTexGenNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1343 */     long l = (GL.getICD()).glPathTexGenNV;
/* 1344 */     if (Checks.CHECKS) {
/* 1345 */       Checks.check(l);
/* 1346 */       Checks.check(paramArrayOffloat, genModeToElements(paramInt2) * paramInt3);
/*      */     } 
/* 1348 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCoverFillPathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1353 */     long l = (GL.getICD()).glCoverFillPathInstancedNV;
/* 1354 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/* 1355 */     if (Checks.CHECKS) {
/* 1356 */       Checks.check(l);
/* 1357 */       Checks.check(paramArrayOffloat, i * transformTypeToElements(paramInt4));
/*      */     } 
/* 1359 */     JNI.callPPV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCoverStrokePathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1364 */     long l = (GL.getICD()).glCoverStrokePathInstancedNV;
/* 1365 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/* 1366 */     if (Checks.CHECKS) {
/* 1367 */       Checks.check(l);
/* 1368 */       Checks.check(paramArrayOffloat, i * transformTypeToElements(paramInt4));
/*      */     } 
/* 1370 */     JNI.callPPV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilThenCoverFillPathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1375 */     long l = (GL.getICD()).glStencilThenCoverFillPathInstancedNV;
/* 1376 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/* 1377 */     if (Checks.CHECKS) {
/* 1378 */       Checks.check(l);
/* 1379 */       Checks.check(paramArrayOffloat, i * transformTypeToElements(paramInt6));
/*      */     } 
/* 1381 */     JNI.callPPV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glStencilThenCoverStrokePathInstancedNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1386 */     long l = (GL.getICD()).glStencilThenCoverStrokePathInstancedNV;
/* 1387 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt1);
/* 1388 */     if (Checks.CHECKS) {
/* 1389 */       Checks.check(l);
/* 1390 */       Checks.check(paramArrayOffloat, i * transformTypeToElements(paramInt6));
/*      */     } 
/* 1392 */     JNI.callPPV(i, paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glPathGlyphIndexRangeNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 1398 */     long l = (GL.getICD()).glPathGlyphIndexRangeNV;
/* 1399 */     if (Checks.CHECKS) {
/* 1400 */       Checks.check(l);
/* 1401 */       Checks.checkNT1(paramByteBuffer);
/* 1402 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 1404 */     return JNI.callPPI(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramFloat, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramPathFragmentInputGenNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1409 */     long l = (GL.getICD()).glProgramPathFragmentInputGenNV;
/* 1410 */     if (Checks.CHECKS) {
/* 1411 */       Checks.check(l);
/* 1412 */       Checks.check(paramArrayOffloat, genModeToElements(paramInt3) * paramInt4);
/*      */     } 
/* 1414 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1419 */     long l = (GL.getICD()).glGetPathParameterivNV;
/* 1420 */     if (Checks.CHECKS) {
/* 1421 */       Checks.check(l);
/* 1422 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1424 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathParameterfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1429 */     long l = (GL.getICD()).glGetPathParameterfvNV;
/* 1430 */     if (Checks.CHECKS) {
/* 1431 */       Checks.check(l);
/* 1432 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1434 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathCoordsNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1439 */     long l = (GL.getICD()).glGetPathCoordsNV;
/* 1440 */     if (Checks.CHECKS) {
/* 1441 */       Checks.check(l);
/* 1442 */       if (Checks.DEBUG) {
/* 1443 */         Checks.check(paramArrayOffloat, glGetPathParameteriNV(paramInt, 37022));
/*      */       }
/*      */     } 
/* 1446 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathDashArrayNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1451 */     long l = (GL.getICD()).glGetPathDashArrayNV;
/* 1452 */     if (Checks.CHECKS) {
/* 1453 */       Checks.check(l);
/* 1454 */       if (Checks.DEBUG) {
/* 1455 */         Checks.check(paramArrayOffloat, glGetPathParameteriNV(paramInt, 37023));
/*      */       }
/*      */     } 
/* 1458 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathMetricsNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1463 */     long l = (GL.getICD()).glGetPathMetricsNV;
/* 1464 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt2);
/* 1465 */     if (Checks.CHECKS) {
/* 1466 */       Checks.check(l);
/* 1467 */       Checks.check(paramArrayOffloat, i * ((paramInt4 == 0) ? Integer.bitCount(paramInt1) : (paramInt4 >> 2)));
/*      */     } 
/* 1469 */     JNI.callPPV(paramInt1, i, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathMetricRangeNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1474 */     long l = (GL.getICD()).glGetPathMetricRangeNV;
/* 1475 */     if (Checks.CHECKS) {
/* 1476 */       Checks.check(l);
/* 1477 */       Checks.check(paramArrayOffloat, paramInt3 * ((paramInt4 == 0) ? Integer.bitCount(paramInt1) : (paramInt4 >> 2)));
/*      */     } 
/* 1479 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathSpacingNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1484 */     long l = (GL.getICD()).glGetPathSpacingNV;
/* 1485 */     int i = paramByteBuffer.remaining() / pathNameTypeToBytes(paramInt2);
/* 1486 */     if (Checks.CHECKS) {
/* 1487 */       Checks.check(l);
/* 1488 */       Checks.check(paramArrayOffloat, (i - 1) * ((paramInt4 == 37006) ? 1 : 2));
/*      */     } 
/* 1490 */     JNI.callPPV(paramInt1, i, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramFloat1, paramFloat2, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathColorGenivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1495 */     long l = (GL.getICD()).glGetPathColorGenivNV;
/* 1496 */     if (Checks.CHECKS) {
/* 1497 */       Checks.check(l);
/* 1498 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1500 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathColorGenfvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1505 */     long l = (GL.getICD()).glGetPathColorGenfvNV;
/* 1506 */     if (Checks.CHECKS) {
/* 1507 */       Checks.check(l);
/* 1508 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1510 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1515 */     long l = (GL.getICD()).glGetPathTexGenivNV;
/* 1516 */     if (Checks.CHECKS) {
/* 1517 */       Checks.check(l);
/* 1518 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1520 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetPathTexGenfvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1525 */     long l = (GL.getICD()).glGetPathTexGenfvNV;
/* 1526 */     if (Checks.CHECKS) {
/* 1527 */       Checks.check(l);
/* 1528 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1530 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glPointAlongPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLfloat *") float[] paramArrayOffloat1, @NativeType("GLfloat *") float[] paramArrayOffloat2, @NativeType("GLfloat *") float[] paramArrayOffloat3, @NativeType("GLfloat *") float[] paramArrayOffloat4) {
/* 1536 */     long l = (GL.getICD()).glPointAlongPathNV;
/* 1537 */     if (Checks.CHECKS) {
/* 1538 */       Checks.check(l);
/* 1539 */       Checks.checkSafe(paramArrayOffloat1, 1);
/* 1540 */       Checks.checkSafe(paramArrayOffloat2, 1);
/* 1541 */       Checks.checkSafe(paramArrayOffloat3, 1);
/* 1542 */       Checks.checkSafe(paramArrayOffloat4, 1);
/*      */     } 
/* 1544 */     return JNI.callPPPPZ(paramInt1, paramInt2, paramInt3, paramFloat, paramArrayOffloat1, paramArrayOffloat2, paramArrayOffloat3, paramArrayOffloat4, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x2fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1549 */     long l = (GL.getICD()).glMatrixLoad3x2fNV;
/* 1550 */     if (Checks.CHECKS) {
/* 1551 */       Checks.check(l);
/* 1552 */       Checks.check(paramArrayOffloat, 6);
/*      */     } 
/* 1554 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoad3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1559 */     long l = (GL.getICD()).glMatrixLoad3x3fNV;
/* 1560 */     if (Checks.CHECKS) {
/* 1561 */       Checks.check(l);
/* 1562 */       Checks.check(paramArrayOffloat, 9);
/*      */     } 
/* 1564 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTranspose3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1569 */     long l = (GL.getICD()).glMatrixLoadTranspose3x3fNV;
/* 1570 */     if (Checks.CHECKS) {
/* 1571 */       Checks.check(l);
/* 1572 */       Checks.check(paramArrayOffloat, 9);
/*      */     } 
/* 1574 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x2fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1579 */     long l = (GL.getICD()).glMatrixMult3x2fNV;
/* 1580 */     if (Checks.CHECKS) {
/* 1581 */       Checks.check(l);
/* 1582 */       Checks.check(paramArrayOffloat, 6);
/*      */     } 
/* 1584 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMult3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1589 */     long l = (GL.getICD()).glMatrixMult3x3fNV;
/* 1590 */     if (Checks.CHECKS) {
/* 1591 */       Checks.check(l);
/* 1592 */       Checks.check(paramArrayOffloat, 9);
/*      */     } 
/* 1594 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTranspose3x3fNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1599 */     long l = (GL.getICD()).glMatrixMultTranspose3x3fNV;
/* 1600 */     if (Checks.CHECKS) {
/* 1601 */       Checks.check(l);
/* 1602 */       Checks.check(paramArrayOffloat, 9);
/*      */     } 
/* 1604 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourcefvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum const *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1609 */     long l = (GL.getICD()).glGetProgramResourcefvNV;
/* 1610 */     if (Checks.CHECKS) {
/* 1611 */       Checks.check(l);
/* 1612 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 1614 */     JNI.callPPPV(paramInt1, paramInt2, paramInt3, paramArrayOfint1.length, paramArrayOfint1, paramArrayOffloat.length, paramArrayOfint2, paramArrayOffloat, l);
/*      */   }
/*      */   
/*      */   private static int charcodeTypeToBytes(int paramInt) {
/* 1618 */     switch (paramInt) {
/*      */       case 5121:
/*      */       case 37018:
/* 1621 */         return 1;
/*      */       case 5123:
/*      */       case 5127:
/*      */       case 37019:
/* 1625 */         return 2;
/*      */       case 5128:
/* 1627 */         return 3;
/*      */       case 5125:
/*      */       case 5129:
/* 1630 */         return 4;
/*      */     } 
/* 1632 */     throw new IllegalArgumentException(String.format("Unsupported charcode type: 0x%X", new Object[] { Integer.valueOf(paramInt) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int pathNameTypeToBytes(int paramInt) {
/* 1637 */     switch (paramInt) {
/*      */       case 5120:
/*      */       case 5121:
/*      */       case 37018:
/* 1641 */         return 1;
/*      */       case 5122:
/*      */       case 5123:
/*      */       case 5127:
/*      */       case 37019:
/* 1646 */         return 2;
/*      */       case 5128:
/* 1648 */         return 3;
/*      */       case 5124:
/*      */       case 5125:
/*      */       case 5129:
/* 1652 */         return 4;
/*      */     } 
/* 1654 */     throw new IllegalArgumentException(String.format("Unsupported path name type: 0x%X", new Object[] { Integer.valueOf(paramInt) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int transformTypeToElements(int paramInt) {
/* 1659 */     switch (paramInt) {
/*      */       case 0:
/* 1661 */         return 0;
/*      */       case 37006:
/*      */       case 37007:
/* 1664 */         return 1;
/*      */       case 37008:
/* 1666 */         return 2;
/*      */       case 37009:
/* 1668 */         return 3;
/*      */       case 37010:
/*      */       case 37014:
/* 1671 */         return 6;
/*      */       case 37012:
/*      */       case 37016:
/* 1674 */         return 12;
/*      */     } 
/* 1676 */     throw new IllegalArgumentException(String.format("Unsupported transform type: 0x%X", new Object[] { Integer.valueOf(paramInt) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int colorFormatToComponents(int paramInt) {
/* 1681 */     switch (paramInt) {
/*      */       case 6406:
/*      */       case 6409:
/*      */       case 32841:
/* 1685 */         return 1;
/*      */       case 6410:
/* 1687 */         return 2;
/*      */       case 6407:
/* 1689 */         return 3;
/*      */       case 6408:
/* 1691 */         return 4;
/*      */     } 
/* 1693 */     throw new IllegalArgumentException(String.format("Unsupported colorFormat specified: 0x%X", new Object[] { Integer.valueOf(paramInt) }));
/*      */   }
/*      */ 
/*      */   
/*      */   private static int genModeToElements(int paramInt) {
/* 1698 */     switch (paramInt) {
/*      */       case 0:
/* 1700 */         return 0;
/*      */       case 34166:
/* 1702 */         return 1;
/*      */       case 9217:
/*      */       case 37002:
/* 1705 */         return 3;
/*      */       case 9216:
/* 1707 */         return 4;
/*      */     } 
/* 1709 */     throw new IllegalArgumentException(String.format("Unsupported genMode specified: 0x%X", new Object[] { Integer.valueOf(paramInt) }));
/*      */   }
/*      */   
/*      */   public static native void nglPathCommandsNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, long paramLong2);
/*      */   
/*      */   public static native void nglPathCoordsNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathSubCommandsNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, long paramLong2);
/*      */   
/*      */   public static native void nglPathSubCoordsNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglPathStringNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathGlyphsNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2, int paramInt6, int paramInt7, float paramFloat);
/*      */   
/*      */   public static native void nglPathGlyphRangeNV(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat);
/*      */   
/*      */   public static native int nglPathGlyphIndexArrayNV(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat);
/*      */   
/*      */   public static native int nglPathMemoryGlyphIndexArrayNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat);
/*      */   
/*      */   public static native void glCopyPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglWeightPathsNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glInterpolatePathsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTransformPathNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glPathParameteriNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglPathParameterfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glPathParameterfNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglPathDashArrayNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glGenPathsNV(@NativeType("GLsizei") int paramInt);
/*      */   
/*      */   public static native void glDeletePathsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsPathNV(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glPathStencilFuncNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glPathStencilDepthOffsetNV(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glStencilFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glStencilStrokePathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglStencilFillPathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*      */   
/*      */   public static native void nglStencilStrokePathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*      */   
/*      */   public static native void glPathCoverDepthFuncNV(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglPathColorGenNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglPathTexGenNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glPathFogGenNV(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glCoverFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glCoverStrokePathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglCoverFillPathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void nglCoverStrokePathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void glStencilThenCoverFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*      */   
/*      */   public static native void glStencilThenCoverStrokePathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*      */   
/*      */   public static native void nglStencilThenCoverFillPathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2);
/*      */   
/*      */   public static native void nglStencilThenCoverStrokePathInstancedNV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2);
/*      */   
/*      */   public static native int nglPathGlyphIndexRangeNV(int paramInt1, long paramLong1, int paramInt2, int paramInt3, float paramFloat, long paramLong2);
/*      */   
/*      */   public static native void nglProgramPathFragmentInputGenNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetPathParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathParameterfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathCommandsNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPathCoordsNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPathDashArrayNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPathMetricsNV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void nglGetPathMetricRangeNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetPathSpacingNV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native void nglGetPathColorGenivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathColorGenfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathTexGenivNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPathTexGenfvNV(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsPointInFillPathNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsPointInStrokePathNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   @NativeType("GLfloat")
/*      */   public static native float glGetPathLengthNV(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*      */   
/*      */   public static native boolean nglPointAlongPathNV(int paramInt1, int paramInt2, int paramInt3, float paramFloat, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void nglMatrixLoad3x2fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoad3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoadTranspose3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMult3x2fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMult3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultTranspose3x3fNV(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramResourcefvNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVPathRendering.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */