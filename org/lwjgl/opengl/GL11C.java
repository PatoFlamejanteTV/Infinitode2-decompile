/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
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
/*      */ public class GL11C
/*      */ {
/*      */   public static final int GL_NEVER = 512;
/*      */   public static final int GL_LESS = 513;
/*      */   public static final int GL_EQUAL = 514;
/*      */   public static final int GL_LEQUAL = 515;
/*      */   public static final int GL_GREATER = 516;
/*      */   public static final int GL_NOTEQUAL = 517;
/*      */   public static final int GL_GEQUAL = 518;
/*      */   public static final int GL_ALWAYS = 519;
/*      */   public static final int GL_DEPTH_BUFFER_BIT = 256;
/*      */   public static final int GL_STENCIL_BUFFER_BIT = 1024;
/*      */   public static final int GL_COLOR_BUFFER_BIT = 16384;
/*      */   public static final int GL_POINTS = 0;
/*      */   
/*      */   static {
/*   38 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_LINES = 1;
/*      */   
/*      */   public static final int GL_LINE_LOOP = 2;
/*      */   
/*      */   public static final int GL_LINE_STRIP = 3;
/*      */   
/*      */   public static final int GL_TRIANGLES = 4;
/*      */   
/*      */   public static final int GL_TRIANGLE_STRIP = 5;
/*      */   
/*      */   public static final int GL_TRIANGLE_FAN = 6;
/*      */   
/*      */   public static final int GL_QUADS = 7;
/*      */   
/*      */   public static final int GL_ZERO = 0;
/*      */   
/*      */   public static final int GL_ONE = 1;
/*      */   
/*      */   public static final int GL_SRC_COLOR = 768;
/*      */   
/*      */   public static final int GL_ONE_MINUS_SRC_COLOR = 769;
/*      */   
/*      */   public static final int GL_SRC_ALPHA = 770;
/*      */   
/*      */   public static final int GL_ONE_MINUS_SRC_ALPHA = 771;
/*      */   
/*      */   public static final int GL_DST_ALPHA = 772;
/*      */   
/*      */   public static final int GL_ONE_MINUS_DST_ALPHA = 773;
/*      */   
/*      */   public static final int GL_DST_COLOR = 774;
/*      */   
/*      */   public static final int GL_ONE_MINUS_DST_COLOR = 775;
/*      */   
/*      */   public static final int GL_SRC_ALPHA_SATURATE = 776;
/*      */   
/*      */   public static final int GL_TRUE = 1;
/*      */   
/*      */   public static final int GL_FALSE = 0;
/*      */   
/*      */   public static final int GL_BYTE = 5120;
/*      */   
/*      */   public static final int GL_UNSIGNED_BYTE = 5121;
/*      */   
/*      */   public static final int GL_SHORT = 5122;
/*      */   
/*      */   public static final int GL_UNSIGNED_SHORT = 5123;
/*      */   
/*      */   public static final int GL_INT = 5124;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT = 5125;
/*      */   
/*      */   public static final int GL_FLOAT = 5126;
/*      */   
/*      */   public static final int GL_DOUBLE = 5130;
/*      */   
/*      */   public static final int GL_NONE = 0;
/*      */   
/*      */   public static final int GL_FRONT_LEFT = 1024;
/*      */   
/*      */   public static final int GL_FRONT_RIGHT = 1025;
/*      */   
/*      */   public static final int GL_BACK_LEFT = 1026;
/*      */   
/*      */   public static final int GL_BACK_RIGHT = 1027;
/*      */   
/*      */   public static final int GL_FRONT = 1028;
/*      */   
/*      */   public static final int GL_BACK = 1029;
/*      */   
/*      */   public static final int GL_LEFT = 1030;
/*      */   
/*      */   public static final int GL_RIGHT = 1031;
/*      */   
/*      */   public static final int GL_FRONT_AND_BACK = 1032;
/*      */   
/*      */   public static final int GL_NO_ERROR = 0;
/*      */   
/*      */   public static final int GL_INVALID_ENUM = 1280;
/*      */   
/*      */   public static final int GL_INVALID_VALUE = 1281;
/*      */   
/*      */   public static final int GL_INVALID_OPERATION = 1282;
/*      */   
/*      */   public static final int GL_STACK_OVERFLOW = 1283;
/*      */   
/*      */   public static final int GL_STACK_UNDERFLOW = 1284;
/*      */   
/*      */   public static final int GL_OUT_OF_MEMORY = 1285;
/*      */   
/*      */   public static final int GL_CW = 2304;
/*      */   
/*      */   public static final int GL_CCW = 2305;
/*      */   
/*      */   public static final int GL_POINT_SIZE = 2833;
/*      */   
/*      */   public static final int GL_POINT_SIZE_RANGE = 2834;
/*      */   
/*      */   public static final int GL_POINT_SIZE_GRANULARITY = 2835;
/*      */   
/*      */   public static final int GL_LINE_SMOOTH = 2848;
/*      */   
/*      */   public static final int GL_LINE_WIDTH = 2849;
/*      */   
/*      */   public static final int GL_LINE_WIDTH_RANGE = 2850;
/*      */   
/*      */   public static final int GL_LINE_WIDTH_GRANULARITY = 2851;
/*      */   
/*      */   public static final int GL_POLYGON_MODE = 2880;
/*      */   
/*      */   public static final int GL_POLYGON_SMOOTH = 2881;
/*      */   
/*      */   public static final int GL_CULL_FACE = 2884;
/*      */   
/*      */   public static final int GL_CULL_FACE_MODE = 2885;
/*      */   
/*      */   public static final int GL_FRONT_FACE = 2886;
/*      */   
/*      */   public static final int GL_DEPTH_RANGE = 2928;
/*      */   
/*      */   public static final int GL_DEPTH_TEST = 2929;
/*      */   
/*      */   public static final int GL_DEPTH_WRITEMASK = 2930;
/*      */   
/*      */   public static final int GL_DEPTH_CLEAR_VALUE = 2931;
/*      */   
/*      */   public static final int GL_DEPTH_FUNC = 2932;
/*      */   
/*      */   public static final int GL_STENCIL_TEST = 2960;
/*      */   
/*      */   public static final int GL_STENCIL_CLEAR_VALUE = 2961;
/*      */   
/*      */   public static final int GL_STENCIL_FUNC = 2962;
/*      */   
/*      */   public static final int GL_STENCIL_VALUE_MASK = 2963;
/*      */   
/*      */   public static final int GL_STENCIL_FAIL = 2964;
/*      */   
/*      */   public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
/*      */   
/*      */   public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
/*      */   
/*      */   public static final int GL_STENCIL_REF = 2967;
/*      */   
/*      */   public static final int GL_STENCIL_WRITEMASK = 2968;
/*      */   
/*      */   public static final int GL_VIEWPORT = 2978;
/*      */   
/*      */   public static final int GL_DITHER = 3024;
/*      */   
/*      */   public static final int GL_BLEND_DST = 3040;
/*      */   
/*      */   public static final int GL_BLEND_SRC = 3041;
/*      */   
/*      */   public static final int GL_BLEND = 3042;
/*      */   
/*      */   public static final int GL_LOGIC_OP_MODE = 3056;
/*      */   
/*      */   public static final int GL_COLOR_LOGIC_OP = 3058;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER = 3073;
/*      */   
/*      */   public static final int GL_READ_BUFFER = 3074;
/*      */   
/*      */   public static final int GL_SCISSOR_BOX = 3088;
/*      */   
/*      */   public static final int GL_SCISSOR_TEST = 3089;
/*      */   
/*      */   public static final int GL_COLOR_CLEAR_VALUE = 3106;
/*      */   
/*      */   public static final int GL_COLOR_WRITEMASK = 3107;
/*      */   
/*      */   public static final int GL_DOUBLEBUFFER = 3122;
/*      */   
/*      */   public static final int GL_STEREO = 3123;
/*      */   
/*      */   public static final int GL_LINE_SMOOTH_HINT = 3154;
/*      */   
/*      */   public static final int GL_POLYGON_SMOOTH_HINT = 3155;
/*      */   
/*      */   public static final int GL_UNPACK_SWAP_BYTES = 3312;
/*      */   public static final int GL_UNPACK_LSB_FIRST = 3313;
/*      */   public static final int GL_UNPACK_ROW_LENGTH = 3314;
/*      */   public static final int GL_UNPACK_SKIP_ROWS = 3315;
/*      */   public static final int GL_UNPACK_SKIP_PIXELS = 3316;
/*      */   public static final int GL_UNPACK_ALIGNMENT = 3317;
/*      */   public static final int GL_PACK_SWAP_BYTES = 3328;
/*      */   public static final int GL_PACK_LSB_FIRST = 3329;
/*      */   public static final int GL_PACK_ROW_LENGTH = 3330;
/*      */   public static final int GL_PACK_SKIP_ROWS = 3331;
/*      */   public static final int GL_PACK_SKIP_PIXELS = 3332;
/*      */   public static final int GL_PACK_ALIGNMENT = 3333;
/*      */   public static final int GL_MAX_TEXTURE_SIZE = 3379;
/*      */   public static final int GL_MAX_VIEWPORT_DIMS = 3386;
/*      */   public static final int GL_SUBPIXEL_BITS = 3408;
/*      */   public static final int GL_TEXTURE_1D = 3552;
/*      */   public static final int GL_TEXTURE_2D = 3553;
/*      */   public static final int GL_TEXTURE_WIDTH = 4096;
/*      */   public static final int GL_TEXTURE_HEIGHT = 4097;
/*      */   public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;
/*      */   public static final int GL_TEXTURE_BORDER_COLOR = 4100;
/*      */   public static final int GL_DONT_CARE = 4352;
/*      */   public static final int GL_FASTEST = 4353;
/*      */   public static final int GL_NICEST = 4354;
/*      */   public static final int GL_CLEAR = 5376;
/*      */   public static final int GL_AND = 5377;
/*      */   public static final int GL_AND_REVERSE = 5378;
/*      */   public static final int GL_COPY = 5379;
/*      */   public static final int GL_AND_INVERTED = 5380;
/*      */   public static final int GL_NOOP = 5381;
/*      */   public static final int GL_XOR = 5382;
/*      */   public static final int GL_OR = 5383;
/*      */   public static final int GL_NOR = 5384;
/*      */   public static final int GL_EQUIV = 5385;
/*      */   public static final int GL_INVERT = 5386;
/*      */   public static final int GL_OR_REVERSE = 5387;
/*      */   public static final int GL_COPY_INVERTED = 5388;
/*      */   public static final int GL_OR_INVERTED = 5389;
/*      */   public static final int GL_NAND = 5390;
/*      */   public static final int GL_SET = 5391;
/*      */   public static final int GL_TEXTURE = 5890;
/*      */   public static final int GL_COLOR = 6144;
/*      */   public static final int GL_DEPTH = 6145;
/*      */   public static final int GL_STENCIL = 6146;
/*      */   public static final int GL_STENCIL_INDEX = 6401;
/*      */   public static final int GL_DEPTH_COMPONENT = 6402;
/*      */   public static final int GL_RED = 6403;
/*      */   public static final int GL_GREEN = 6404;
/*      */   public static final int GL_BLUE = 6405;
/*      */   public static final int GL_ALPHA = 6406;
/*      */   public static final int GL_RGB = 6407;
/*      */   public static final int GL_RGBA = 6408;
/*      */   public static final int GL_POINT = 6912;
/*      */   public static final int GL_LINE = 6913;
/*      */   public static final int GL_FILL = 6914;
/*      */   public static final int GL_KEEP = 7680;
/*      */   public static final int GL_REPLACE = 7681;
/*      */   public static final int GL_INCR = 7682;
/*      */   public static final int GL_DECR = 7683;
/*      */   public static final int GL_VENDOR = 7936;
/*      */   public static final int GL_RENDERER = 7937;
/*      */   public static final int GL_VERSION = 7938;
/*      */   public static final int GL_EXTENSIONS = 7939;
/*      */   public static final int GL_NEAREST = 9728;
/*      */   public static final int GL_LINEAR = 9729;
/*      */   public static final int GL_NEAREST_MIPMAP_NEAREST = 9984;
/*      */   public static final int GL_LINEAR_MIPMAP_NEAREST = 9985;
/*      */   public static final int GL_NEAREST_MIPMAP_LINEAR = 9986;
/*      */   public static final int GL_LINEAR_MIPMAP_LINEAR = 9987;
/*      */   public static final int GL_TEXTURE_MAG_FILTER = 10240;
/*      */   public static final int GL_TEXTURE_MIN_FILTER = 10241;
/*      */   public static final int GL_TEXTURE_WRAP_S = 10242;
/*      */   public static final int GL_TEXTURE_WRAP_T = 10243;
/*      */   public static final int GL_REPEAT = 10497;
/*      */   public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
/*      */   public static final int GL_POLYGON_OFFSET_UNITS = 10752;
/*      */   public static final int GL_POLYGON_OFFSET_POINT = 10753;
/*      */   public static final int GL_POLYGON_OFFSET_LINE = 10754;
/*      */   public static final int GL_POLYGON_OFFSET_FILL = 32823;
/*      */   public static final int GL_R3_G3_B2 = 10768;
/*      */   public static final int GL_RGB4 = 32847;
/*      */   public static final int GL_RGB5 = 32848;
/*      */   public static final int GL_RGB8 = 32849;
/*      */   public static final int GL_RGB10 = 32850;
/*      */   public static final int GL_RGB12 = 32851;
/*      */   public static final int GL_RGB16 = 32852;
/*      */   public static final int GL_RGBA2 = 32853;
/*      */   public static final int GL_RGBA4 = 32854;
/*      */   public static final int GL_RGB5_A1 = 32855;
/*      */   public static final int GL_RGBA8 = 32856;
/*      */   public static final int GL_RGB10_A2 = 32857;
/*      */   public static final int GL_RGBA12 = 32858;
/*      */   public static final int GL_RGBA16 = 32859;
/*      */   public static final int GL_TEXTURE_RED_SIZE = 32860;
/*      */   public static final int GL_TEXTURE_GREEN_SIZE = 32861;
/*      */   public static final int GL_TEXTURE_BLUE_SIZE = 32862;
/*      */   public static final int GL_TEXTURE_ALPHA_SIZE = 32863;
/*      */   public static final int GL_PROXY_TEXTURE_1D = 32867;
/*      */   public static final int GL_PROXY_TEXTURE_2D = 32868;
/*      */   public static final int GL_TEXTURE_BINDING_1D = 32872;
/*      */   public static final int GL_TEXTURE_BINDING_2D = 32873;
/*      */   public static final int GL_VERTEX_ARRAY = 32884;
/*      */   
/*      */   protected GL11C() {
/*  326 */     throw new UnsupportedOperationException();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawElements(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong) {
/*  543 */     nglDrawElements(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glDrawElements(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  558 */     nglDrawElements(paramInt1, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt2), paramInt2, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glDrawElements(@NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  572 */     nglDrawElements(paramInt, paramByteBuffer.remaining(), 5121, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glDrawElements(@NativeType("GLenum") int paramInt, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  586 */     nglDrawElements(paramInt, paramShortBuffer.remaining(), 5123, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glDrawElements(@NativeType("GLenum") int paramInt, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  600 */     nglDrawElements(paramInt, paramIntBuffer.remaining(), 5125, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGenTextures(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  653 */     nglGenTextures(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenTextures() {
/*      */     MemoryStack memoryStack;
/*  664 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  666 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  667 */       nglGenTextures(1, MemoryUtil.memAddress(intBuffer));
/*  668 */       return intBuffer.get(0);
/*      */     } finally {
/*  670 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  697 */     nglDeleteTextures(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  712 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  714 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  715 */       nglDeleteTextures(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  717 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetBooleanv(@NativeType("GLenum") int paramInt, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/*  739 */     if (Checks.CHECKS) {
/*  740 */       Checks.check(paramByteBuffer, 1);
/*      */     }
/*  742 */     nglGetBooleanv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("void")
/*      */   public static boolean glGetBoolean(@NativeType("GLenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  758 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  760 */       ByteBuffer byteBuffer = memoryStack.calloc(1);
/*  761 */       nglGetBooleanv(paramInt, MemoryUtil.memAddress(byteBuffer));
/*  762 */       paramInt = (byteBuffer.get(0) != 0) ? 1 : 0; return paramInt;
/*      */     } finally {
/*  764 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetFloatv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  786 */     if (Checks.CHECKS) {
/*  787 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  789 */     nglGetFloatv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   @NativeType("void")
/*      */   public static float glGetFloat(@NativeType("GLenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  805 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  807 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  808 */       nglGetFloatv(paramInt, MemoryUtil.memAddress(floatBuffer));
/*  809 */       return floatBuffer.get(0);
/*      */     } finally {
/*  811 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetIntegerv(@NativeType("GLenum") int paramInt, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  833 */     if (Checks.CHECKS) {
/*  834 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  836 */     nglGetIntegerv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   @NativeType("void")
/*      */   public static int glGetInteger(@NativeType("GLenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  852 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  854 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  855 */       nglGetIntegerv(paramInt, MemoryUtil.memAddress(intBuffer));
/*  856 */       paramInt = intBuffer.get(0); return paramInt;
/*      */     } finally {
/*  858 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetDoublev(@NativeType("GLenum") int paramInt, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/*  880 */     if (Checks.CHECKS) {
/*  881 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/*  883 */     nglGetDoublev(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   @NativeType("void")
/*      */   public static double glGetDouble(@NativeType("GLenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  899 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  901 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/*  902 */       nglGetDoublev(paramInt, MemoryUtil.memAddress(doubleBuffer));
/*  903 */       return doubleBuffer.get(0);
/*      */     } finally {
/*  905 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPointerv(@NativeType("GLenum") int paramInt, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  938 */     if (Checks.CHECKS) {
/*  939 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/*  941 */     nglGetPointerv(paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetPointer(@NativeType("GLenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  953 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  955 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/*  956 */       nglGetPointerv(paramInt, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/*  957 */       return pointerBuffer.get(0);
/*      */     } finally {
/*  959 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("GLubyte const *")
/*      */   public static String glGetString(@NativeType("GLenum") int paramInt) {
/*      */     long l;
/*  979 */     return MemoryUtil.memUTF8Safe(l = nglGetString(paramInt));
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
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  999 */     nglGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") long paramLong) {
/* 1014 */     nglGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 1029 */     nglGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 1044 */     nglGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 1059 */     nglGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 1074 */     nglGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetTexLevelParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1093 */     if (Checks.CHECKS) {
/* 1094 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1096 */     nglGetTexLevelParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   @NativeType("void")
/*      */   public static int glGetTexLevelParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1110 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1112 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1113 */       nglGetTexLevelParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1114 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1116 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexLevelParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1136 */     if (Checks.CHECKS) {
/* 1137 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1139 */     nglGetTexLevelParameterfv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   @NativeType("void")
/*      */   public static float glGetTexLevelParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1153 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1155 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1156 */       nglGetTexLevelParameterfv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(floatBuffer));
/* 1157 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1159 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1178 */     if (Checks.CHECKS) {
/* 1179 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1181 */     nglGetTexParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTexParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1194 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1196 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1197 */       nglGetTexParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1198 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1200 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1219 */     if (Checks.CHECKS) {
/* 1220 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1222 */     nglGetTexParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTexParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1235 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1237 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1238 */       nglGetTexParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1239 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1241 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1408 */     nglReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") long paramLong) {
/* 1429 */     nglReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 1450 */     nglReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 1471 */     nglReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 1492 */     nglReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1585 */     nglTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") long paramLong) {
/* 1603 */     nglTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1621 */     nglTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddressSafe(paramShortBuffer));
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
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1639 */     nglTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1657 */     nglTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddressSafe(paramFloatBuffer));
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
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1675 */     nglTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddressSafe(paramDoubleBuffer));
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
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1699 */     nglTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") long paramLong) {
/* 1718 */     nglTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1737 */     nglTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramShortBuffer));
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
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1756 */     nglTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1775 */     nglTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramFloatBuffer));
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
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1794 */     nglTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramDoubleBuffer));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1916 */     if (Checks.CHECKS) {
/* 1917 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1919 */     nglTexParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glTexParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1950 */     if (Checks.CHECKS) {
/* 1951 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1953 */     nglTexParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1975 */     nglTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") long paramLong) {
/* 1992 */     nglTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 2009 */     nglTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 2026 */     nglTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 2043 */     nglTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 2060 */     nglTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2085 */     nglTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") long paramLong) {
/* 2105 */     nglTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 2125 */     nglTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 2145 */     nglTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 2165 */     nglTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 2185 */     nglTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGenTextures(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2219 */     long l = (GL.getICD()).glGenTextures;
/* 2220 */     if (Checks.CHECKS) {
/* 2221 */       Checks.check(l);
/*      */     }
/* 2223 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2232 */     long l = (GL.getICD()).glDeleteTextures;
/* 2233 */     if (Checks.CHECKS) {
/* 2234 */       Checks.check(l);
/*      */     }
/* 2236 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloatv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2245 */     long l = (GL.getICD()).glGetFloatv;
/* 2246 */     if (Checks.CHECKS) {
/* 2247 */       Checks.check(l);
/* 2248 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2250 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetIntegerv(@NativeType("GLenum") int paramInt, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2259 */     long l = (GL.getICD()).glGetIntegerv;
/* 2260 */     if (Checks.CHECKS) {
/* 2261 */       Checks.check(l);
/* 2262 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2264 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublev(@NativeType("GLenum") int paramInt, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 2273 */     long l = (GL.getICD()).glGetDoublev;
/* 2274 */     if (Checks.CHECKS) {
/* 2275 */       Checks.check(l);
/* 2276 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 2278 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/* 2287 */     long l = (GL.getICD()).glGetTexImage;
/* 2288 */     if (Checks.CHECKS) {
/* 2289 */       Checks.check(l);
/*      */     }
/* 2291 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/* 2300 */     long l = (GL.getICD()).glGetTexImage;
/* 2301 */     if (Checks.CHECKS) {
/* 2302 */       Checks.check(l);
/*      */     }
/* 2304 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/* 2313 */     long l = (GL.getICD()).glGetTexImage;
/* 2314 */     if (Checks.CHECKS) {
/* 2315 */       Checks.check(l);
/*      */     }
/* 2317 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/* 2326 */     long l = (GL.getICD()).glGetTexImage;
/* 2327 */     if (Checks.CHECKS) {
/* 2328 */       Checks.check(l);
/*      */     }
/* 2330 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2339 */     long l = (GL.getICD()).glGetTexLevelParameteriv;
/* 2340 */     if (Checks.CHECKS) {
/* 2341 */       Checks.check(l);
/* 2342 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2344 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2353 */     long l = (GL.getICD()).glGetTexLevelParameterfv;
/* 2354 */     if (Checks.CHECKS) {
/* 2355 */       Checks.check(l);
/* 2356 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2358 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2367 */     long l = (GL.getICD()).glGetTexParameteriv;
/* 2368 */     if (Checks.CHECKS) {
/* 2369 */       Checks.check(l);
/* 2370 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2372 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2381 */     long l = (GL.getICD()).glGetTexParameterfv;
/* 2382 */     if (Checks.CHECKS) {
/* 2383 */       Checks.check(l);
/* 2384 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2386 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") short[] paramArrayOfshort) {
/* 2395 */     long l = (GL.getICD()).glReadPixels;
/* 2396 */     if (Checks.CHECKS) {
/* 2397 */       Checks.check(l);
/*      */     }
/* 2399 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") int[] paramArrayOfint) {
/* 2408 */     long l = (GL.getICD()).glReadPixels;
/* 2409 */     if (Checks.CHECKS) {
/* 2410 */       Checks.check(l);
/*      */     }
/* 2412 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") float[] paramArrayOffloat) {
/* 2421 */     long l = (GL.getICD()).glReadPixels;
/* 2422 */     if (Checks.CHECKS) {
/* 2423 */       Checks.check(l);
/*      */     }
/* 2425 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2434 */     long l = (GL.getICD()).glTexImage1D;
/* 2435 */     if (Checks.CHECKS) {
/* 2436 */       Checks.check(l);
/*      */     }
/* 2438 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") int[] paramArrayOfint) {
/* 2447 */     long l = (GL.getICD()).glTexImage1D;
/* 2448 */     if (Checks.CHECKS) {
/* 2449 */       Checks.check(l);
/*      */     }
/* 2451 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2460 */     long l = (GL.getICD()).glTexImage1D;
/* 2461 */     if (Checks.CHECKS) {
/* 2462 */       Checks.check(l);
/*      */     }
/* 2464 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2473 */     long l = (GL.getICD()).glTexImage1D;
/* 2474 */     if (Checks.CHECKS) {
/* 2475 */       Checks.check(l);
/*      */     }
/* 2477 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2486 */     long l = (GL.getICD()).glTexImage2D;
/* 2487 */     if (Checks.CHECKS) {
/* 2488 */       Checks.check(l);
/*      */     }
/* 2490 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 2499 */     long l = (GL.getICD()).glTexImage2D;
/* 2500 */     if (Checks.CHECKS) {
/* 2501 */       Checks.check(l);
/*      */     }
/* 2503 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2512 */     long l = (GL.getICD()).glTexImage2D;
/* 2513 */     if (Checks.CHECKS) {
/* 2514 */       Checks.check(l);
/*      */     }
/* 2516 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2525 */     long l = (GL.getICD()).glTexImage2D;
/* 2526 */     if (Checks.CHECKS) {
/* 2527 */       Checks.check(l);
/*      */     }
/* 2529 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2538 */     long l = (GL.getICD()).glTexParameteriv;
/* 2539 */     if (Checks.CHECKS) {
/* 2540 */       Checks.check(l);
/* 2541 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2543 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2552 */     long l = (GL.getICD()).glTexParameterfv;
/* 2553 */     if (Checks.CHECKS) {
/* 2554 */       Checks.check(l);
/* 2555 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 2557 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2566 */     long l = (GL.getICD()).glTexSubImage1D;
/* 2567 */     if (Checks.CHECKS) {
/* 2568 */       Checks.check(l);
/*      */     }
/* 2570 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") int[] paramArrayOfint) {
/* 2579 */     long l = (GL.getICD()).glTexSubImage1D;
/* 2580 */     if (Checks.CHECKS) {
/* 2581 */       Checks.check(l);
/*      */     }
/* 2583 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2592 */     long l = (GL.getICD()).glTexSubImage1D;
/* 2593 */     if (Checks.CHECKS) {
/* 2594 */       Checks.check(l);
/*      */     }
/* 2596 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2605 */     long l = (GL.getICD()).glTexSubImage1D;
/* 2606 */     if (Checks.CHECKS) {
/* 2607 */       Checks.check(l);
/*      */     }
/* 2609 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2618 */     long l = (GL.getICD()).glTexSubImage2D;
/* 2619 */     if (Checks.CHECKS) {
/* 2620 */       Checks.check(l);
/*      */     }
/* 2622 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 2631 */     long l = (GL.getICD()).glTexSubImage2D;
/* 2632 */     if (Checks.CHECKS) {
/* 2633 */       Checks.check(l);
/*      */     }
/* 2635 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2644 */     long l = (GL.getICD()).glTexSubImage2D;
/* 2645 */     if (Checks.CHECKS) {
/* 2646 */       Checks.check(l);
/*      */     }
/* 2648 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2657 */     long l = (GL.getICD()).glTexSubImage2D;
/* 2658 */     if (Checks.CHECKS) {
/* 2659 */       Checks.check(l);
/*      */     }
/* 2661 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble, l);
/*      */   }
/*      */   
/*      */   public static native void glEnable(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDisable(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glBindTexture(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glBlendFunc(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glClear(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glClearColor(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glClearDepth(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glClearStencil(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glColorMask(@NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4);
/*      */   
/*      */   public static native void glCullFace(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDepthFunc(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDepthMask(@NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glDepthRange(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glDrawArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3);
/*      */   
/*      */   public static native void glDrawBuffer(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglDrawElements(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glFinish();
/*      */   
/*      */   public static native void glFlush();
/*      */   
/*      */   public static native void glFrontFace(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglGenTextures(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglDeleteTextures(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetBooleanv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetFloatv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetIntegerv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetDoublev(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glGetError();
/*      */   
/*      */   public static native void nglGetPointerv(int paramInt, long paramLong);
/*      */   
/*      */   public static native long nglGetString(int paramInt);
/*      */   
/*      */   public static native void nglGetTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetTexLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTexLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glHint(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsEnabled(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsTexture(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glLineWidth(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glLogicOp(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glPixelStorei(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glPixelStoref(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glPointSize(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glPolygonMode(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glPolygonOffset(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glReadBuffer(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void glScissor(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glStencilFunc(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glStencilMask(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glStencilOp(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*      */   
/*      */   public static native void nglTexImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void glCopyTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7);
/*      */   
/*      */   public static native void glCopyTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8);
/*      */   
/*      */   public static native void glCopyTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   public static native void glCopyTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8);
/*      */   
/*      */   public static native void glTexParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTexParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTexParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTexSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void nglTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void glViewport(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL11C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */