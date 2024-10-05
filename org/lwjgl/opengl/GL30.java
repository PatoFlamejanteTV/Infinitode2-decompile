/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ public class GL30
/*      */   extends GL21
/*      */ {
/*      */   public static final int GL_MAJOR_VERSION = 33307;
/*      */   public static final int GL_MINOR_VERSION = 33308;
/*      */   public static final int GL_NUM_EXTENSIONS = 33309;
/*      */   public static final int GL_CONTEXT_FLAGS = 33310;
/*      */   public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 1;
/*      */   public static final int GL_COMPARE_REF_TO_TEXTURE = 34894;
/*      */   public static final int GL_CLIP_DISTANCE0 = 12288;
/*      */   public static final int GL_CLIP_DISTANCE1 = 12289;
/*      */   public static final int GL_CLIP_DISTANCE2 = 12290;
/*      */   public static final int GL_CLIP_DISTANCE3 = 12291;
/*      */   public static final int GL_CLIP_DISTANCE4 = 12292;
/*      */   public static final int GL_CLIP_DISTANCE5 = 12293;
/*      */   public static final int GL_CLIP_DISTANCE6 = 12294;
/*      */   public static final int GL_CLIP_DISTANCE7 = 12295;
/*      */   public static final int GL_MAX_CLIP_DISTANCES = 3378;
/*      */   public static final int GL_MAX_VARYING_COMPONENTS = 35659;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 35069;
/*      */   public static final int GL_SAMPLER_1D_ARRAY = 36288;
/*      */   public static final int GL_SAMPLER_2D_ARRAY = 36289;
/*      */   public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 36291;
/*      */   public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 36292;
/*      */   public static final int GL_SAMPLER_CUBE_SHADOW = 36293;
/*      */   public static final int GL_UNSIGNED_INT_VEC2 = 36294;
/*      */   public static final int GL_UNSIGNED_INT_VEC3 = 36295;
/*      */   public static final int GL_UNSIGNED_INT_VEC4 = 36296;
/*      */   public static final int GL_INT_SAMPLER_1D = 36297;
/*      */   public static final int GL_INT_SAMPLER_2D = 36298;
/*      */   public static final int GL_INT_SAMPLER_3D = 36299;
/*      */   public static final int GL_INT_SAMPLER_CUBE = 36300;
/*      */   
/*      */   static {
/*   45 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_INT_SAMPLER_1D_ARRAY = 36302;
/*      */ 
/*      */   
/*      */   public static final int GL_INT_SAMPLER_2D_ARRAY = 36303;
/*      */ 
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_1D = 36305;
/*      */ 
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_2D = 36306;
/*      */ 
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_3D = 36307;
/*      */ 
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 36308;
/*      */ 
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 36310;
/*      */ 
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 36311;
/*      */ 
/*      */   
/*      */   public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 35076;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 35077;
/*      */ 
/*      */   
/*      */   public static final int GL_QUERY_WAIT = 36371;
/*      */ 
/*      */   
/*      */   public static final int GL_QUERY_NO_WAIT = 36372;
/*      */ 
/*      */   
/*      */   public static final int GL_QUERY_BY_REGION_WAIT = 36373;
/*      */   
/*      */   public static final int GL_QUERY_BY_REGION_NO_WAIT = 36374;
/*      */   
/*      */   public static final int GL_MAP_READ_BIT = 1;
/*      */   
/*      */   public static final int GL_MAP_WRITE_BIT = 2;
/*      */   
/*      */   public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
/*      */   
/*      */   public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
/*      */   
/*      */   public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
/*      */   
/*      */   public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
/*      */   
/*      */   public static final int GL_BUFFER_ACCESS_FLAGS = 37151;
/*      */   
/*      */   public static final int GL_BUFFER_MAP_LENGTH = 37152;
/*      */   
/*      */   public static final int GL_BUFFER_MAP_OFFSET = 37153;
/*      */   
/*      */   public static final int GL_CLAMP_VERTEX_COLOR = 35098;
/*      */   
/*      */   public static final int GL_CLAMP_FRAGMENT_COLOR = 35099;
/*      */   
/*      */   public static final int GL_CLAMP_READ_COLOR = 35100;
/*      */   
/*      */   public static final int GL_FIXED_ONLY = 35101;
/*      */   
/*      */   public static final int GL_DEPTH_COMPONENT32F = 36012;
/*      */   
/*      */   public static final int GL_DEPTH32F_STENCIL8 = 36013;
/*      */   
/*      */   public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269;
/*      */   
/*      */   public static final int GL_TEXTURE_RED_TYPE = 35856;
/*      */   
/*      */   public static final int GL_TEXTURE_GREEN_TYPE = 35857;
/*      */   
/*      */   public static final int GL_TEXTURE_BLUE_TYPE = 35858;
/*      */   
/*      */   public static final int GL_TEXTURE_ALPHA_TYPE = 35859;
/*      */   
/*      */   public static final int GL_TEXTURE_LUMINANCE_TYPE = 35860;
/*      */   
/*      */   public static final int GL_TEXTURE_INTENSITY_TYPE = 35861;
/*      */   
/*      */   public static final int GL_TEXTURE_DEPTH_TYPE = 35862;
/*      */   
/*      */   public static final int GL_UNSIGNED_NORMALIZED = 35863;
/*      */   
/*      */   public static final int GL_RGBA32F = 34836;
/*      */   
/*      */   public static final int GL_RGB32F = 34837;
/*      */   
/*      */   public static final int GL_RGBA16F = 34842;
/*      */   
/*      */   public static final int GL_RGB16F = 34843;
/*      */   
/*      */   public static final int GL_R11F_G11F_B10F = 35898;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 35899;
/*      */   
/*      */   public static final int GL_RGB9_E5 = 35901;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 35902;
/*      */   
/*      */   public static final int GL_TEXTURE_SHARED_SIZE = 35903;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER = 36160;
/*      */   
/*      */   public static final int GL_READ_FRAMEBUFFER = 36008;
/*      */   
/*      */   public static final int GL_DRAW_FRAMEBUFFER = 36009;
/*      */   
/*      */   public static final int GL_RENDERBUFFER = 36161;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX1 = 36166;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX4 = 36167;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX8 = 36168;
/*      */   
/*      */   public static final int GL_STENCIL_INDEX16 = 36169;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_WIDTH = 36162;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_HEIGHT = 36163;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_SAMPLES = 36011;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT = 33304;
/*      */   
/*      */   public static final int GL_INDEX = 33314;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT0 = 36064;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT1 = 36065;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT2 = 36066;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT3 = 36067;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT4 = 36068;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT5 = 36069;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT6 = 36070;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT7 = 36071;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT8 = 36072;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT9 = 36073;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT10 = 36074;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT11 = 36075;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT12 = 36076;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT13 = 36077;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT14 = 36078;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT15 = 36079;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT16 = 36080;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT17 = 36081;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT18 = 36082;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT19 = 36083;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT20 = 36084;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT21 = 36085;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT22 = 36086;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT23 = 36087;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT24 = 36088;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT25 = 36089;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT26 = 36090;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT27 = 36091;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT28 = 36092;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT29 = 36093;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT30 = 36094;
/*      */   
/*      */   public static final int GL_COLOR_ATTACHMENT31 = 36095;
/*      */   
/*      */   public static final int GL_DEPTH_ATTACHMENT = 36096;
/*      */   
/*      */   public static final int GL_STENCIL_ATTACHMENT = 36128;
/*      */   
/*      */   public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306;
/*      */   
/*      */   public static final int GL_MAX_SAMPLES = 36183;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_UNDEFINED = 33305;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_BINDING = 36006;
/*      */   
/*      */   public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
/*      */   
/*      */   public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
/*      */   
/*      */   public static final int GL_RENDERBUFFER_BINDING = 36007;
/*      */   
/*      */   public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
/*      */   
/*      */   public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
/*      */   
/*      */   public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
/*      */   
/*      */   public static final int GL_DEPTH_STENCIL = 34041;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_24_8 = 34042;
/*      */   
/*      */   public static final int GL_DEPTH24_STENCIL8 = 35056;
/*      */   
/*      */   public static final int GL_TEXTURE_STENCIL_SIZE = 35057;
/*      */   
/*      */   public static final int GL_HALF_FLOAT = 5131;
/*      */   
/*      */   public static final int GL_RGBA32UI = 36208;
/*      */   
/*      */   public static final int GL_RGB32UI = 36209;
/*      */   
/*      */   public static final int GL_RGBA16UI = 36214;
/*      */   
/*      */   public static final int GL_RGB16UI = 36215;
/*      */   
/*      */   public static final int GL_RGBA8UI = 36220;
/*      */   
/*      */   public static final int GL_RGB8UI = 36221;
/*      */   
/*      */   public static final int GL_RGBA32I = 36226;
/*      */   
/*      */   public static final int GL_RGB32I = 36227;
/*      */   
/*      */   public static final int GL_RGBA16I = 36232;
/*      */   
/*      */   public static final int GL_RGB16I = 36233;
/*      */   
/*      */   public static final int GL_RGBA8I = 36238;
/*      */   
/*      */   public static final int GL_RGB8I = 36239;
/*      */   
/*      */   public static final int GL_RED_INTEGER = 36244;
/*      */   
/*      */   public static final int GL_GREEN_INTEGER = 36245;
/*      */   
/*      */   public static final int GL_BLUE_INTEGER = 36246;
/*      */   
/*      */   public static final int GL_ALPHA_INTEGER = 36247;
/*      */   
/*      */   public static final int GL_RGB_INTEGER = 36248;
/*      */   
/*      */   public static final int GL_RGBA_INTEGER = 36249;
/*      */   
/*      */   public static final int GL_BGR_INTEGER = 36250;
/*      */   
/*      */   public static final int GL_BGRA_INTEGER = 36251;
/*      */   
/*      */   public static final int GL_TEXTURE_1D_ARRAY = 35864;
/*      */   
/*      */   public static final int GL_TEXTURE_2D_ARRAY = 35866;
/*      */   
/*      */   public static final int GL_PROXY_TEXTURE_2D_ARRAY = 35867;
/*      */   
/*      */   public static final int GL_PROXY_TEXTURE_1D_ARRAY = 35865;
/*      */   
/*      */   public static final int GL_TEXTURE_BINDING_1D_ARRAY = 35868;
/*      */   
/*      */   public static final int GL_TEXTURE_BINDING_2D_ARRAY = 35869;
/*      */   
/*      */   public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 35071;
/*      */   
/*      */   public static final int GL_COMPRESSED_RED_RGTC1 = 36283;
/*      */   
/*      */   public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 36284;
/*      */   
/*      */   public static final int GL_COMPRESSED_RG_RGTC2 = 36285;
/*      */   
/*      */   public static final int GL_COMPRESSED_SIGNED_RG_RGTC2 = 36286;
/*      */   
/*      */   public static final int GL_R8 = 33321;
/*      */   
/*      */   public static final int GL_R16 = 33322;
/*      */   
/*      */   public static final int GL_RG8 = 33323;
/*      */   
/*      */   public static final int GL_RG16 = 33324;
/*      */   
/*      */   public static final int GL_R16F = 33325;
/*      */   
/*      */   public static final int GL_R32F = 33326;
/*      */   
/*      */   public static final int GL_RG16F = 33327;
/*      */   
/*      */   public static final int GL_RG32F = 33328;
/*      */   
/*      */   public static final int GL_R8I = 33329;
/*      */   
/*      */   public static final int GL_R8UI = 33330;
/*      */   
/*      */   public static final int GL_R16I = 33331;
/*      */   
/*      */   public static final int GL_R16UI = 33332;
/*      */   
/*      */   public static final int GL_R32I = 33333;
/*      */   
/*      */   public static final int GL_R32UI = 33334;
/*      */   
/*      */   public static final int GL_RG8I = 33335;
/*      */   
/*      */   public static final int GL_RG8UI = 33336;
/*      */   
/*      */   public static final int GL_RG16I = 33337;
/*      */   
/*      */   public static final int GL_RG16UI = 33338;
/*      */   
/*      */   public static final int GL_RG32I = 33339;
/*      */   
/*      */   public static final int GL_RG32UI = 33340;
/*      */   
/*      */   public static final int GL_RG = 33319;
/*      */   
/*      */   public static final int GL_COMPRESSED_RED = 33317;
/*      */   
/*      */   public static final int GL_COMPRESSED_RG = 33318;
/*      */   
/*      */   public static final int GL_RG_INTEGER = 33320;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 35982;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 35972;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 35973;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 35983;
/*      */   
/*      */   public static final int GL_INTERLEAVED_ATTRIBS = 35980;
/*      */   
/*      */   public static final int GL_SEPARATE_ATTRIBS = 35981;
/*      */   
/*      */   public static final int GL_PRIMITIVES_GENERATED = 35975;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 35976;
/*      */   
/*      */   public static final int GL_RASTERIZER_DISCARD = 35977;
/*      */   
/*      */   public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 35978;
/*      */   
/*      */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 35979;
/*      */   
/*      */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 35968;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 35971;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 35967;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 35958;
/*      */   
/*      */   public static final int GL_VERTEX_ARRAY_BINDING = 34229;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_SRGB = 36281;
/*      */ 
/*      */   
/*      */   protected GL30() {
/*  480 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglGetStringi(int paramInt1, int paramInt2) {
/*  487 */     return GL30C.nglGetStringi(paramInt1, paramInt2);
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
/*      */   @NativeType("GLubyte const *")
/*      */   public static String glGetStringi(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  501 */     return GL30C.glGetStringi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearBufferiv(int paramInt1, int paramInt2, long paramLong) {
/*  508 */     GL30C.nglClearBufferiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glClearBufferiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  522 */     GL30C.glClearBufferiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearBufferuiv(int paramInt1, int paramInt2, long paramLong) {
/*  529 */     GL30C.nglClearBufferuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glClearBufferuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  542 */     GL30C.glClearBufferuiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearBufferfv(int paramInt1, int paramInt2, long paramLong) {
/*  549 */     GL30C.nglClearBufferfv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glClearBufferfv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  563 */     GL30C.glClearBufferfv(paramInt1, paramInt2, paramFloatBuffer);
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
/*      */   public static void glClearBufferfi(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat, @NativeType("GLint") int paramInt3) {
/*  579 */     GL30C.glClearBufferfi(paramInt1, paramInt2, paramFloat, paramInt3);
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
/*      */   public static void glVertexAttribI1i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*  593 */     GL30C.glVertexAttribI1i(paramInt1, paramInt2);
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
/*      */   public static void glVertexAttribI2i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  608 */     GL30C.glVertexAttribI2i(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glVertexAttribI3i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  624 */     GL30C.glVertexAttribI3i(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glVertexAttribI4i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/*  641 */     GL30C.glVertexAttribI4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glVertexAttribI1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  655 */     GL30C.glVertexAttribI1ui(paramInt1, paramInt2);
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
/*      */   public static void glVertexAttribI2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  670 */     GL30C.glVertexAttribI2ui(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glVertexAttribI3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  686 */     GL30C.glVertexAttribI3ui(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glVertexAttribI4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/*  703 */     GL30C.glVertexAttribI4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI1iv(int paramInt, long paramLong) {
/*  710 */     GL30C.nglVertexAttribI1iv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI1iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  722 */     GL30C.glVertexAttribI1iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI2iv(int paramInt, long paramLong) {
/*  729 */     GL30C.nglVertexAttribI2iv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI2iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  741 */     GL30C.glVertexAttribI2iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI3iv(int paramInt, long paramLong) {
/*  748 */     GL30C.nglVertexAttribI3iv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI3iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  760 */     GL30C.glVertexAttribI3iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI4iv(int paramInt, long paramLong) {
/*  767 */     GL30C.nglVertexAttribI4iv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI4iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  779 */     GL30C.glVertexAttribI4iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI1uiv(int paramInt, long paramLong) {
/*  786 */     GL30C.nglVertexAttribI1uiv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI1uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  798 */     GL30C.glVertexAttribI1uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI2uiv(int paramInt, long paramLong) {
/*  805 */     GL30C.nglVertexAttribI2uiv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI2uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  817 */     GL30C.glVertexAttribI2uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI3uiv(int paramInt, long paramLong) {
/*  824 */     GL30C.nglVertexAttribI3uiv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI3uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  836 */     GL30C.glVertexAttribI3uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI4uiv(int paramInt, long paramLong) {
/*  843 */     GL30C.nglVertexAttribI4uiv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI4uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  855 */     GL30C.glVertexAttribI4uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI4bv(int paramInt, long paramLong) {
/*  862 */     GL30C.nglVertexAttribI4bv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI4bv(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  874 */     GL30C.glVertexAttribI4bv(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI4sv(int paramInt, long paramLong) {
/*  881 */     GL30C.nglVertexAttribI4sv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI4sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  893 */     GL30C.glVertexAttribI4sv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI4ubv(int paramInt, long paramLong) {
/*  900 */     GL30C.nglVertexAttribI4ubv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI4ubv(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  912 */     GL30C.glVertexAttribI4ubv(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribI4usv(int paramInt, long paramLong) {
/*  919 */     GL30C.nglVertexAttribI4usv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribI4usv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  931 */     GL30C.glVertexAttribI4usv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribIPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  938 */     GL30C.nglVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  955 */     GL30C.glVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/*  972 */     GL30C.glVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  989 */     GL30C.glVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
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
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1006 */     GL30C.glVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribIiv(int paramInt1, int paramInt2, long paramLong) {
/* 1013 */     GL30C.nglGetVertexAttribIiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexAttribIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1026 */     GL30C.glGetVertexAttribIiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetVertexAttribIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1039 */     return GL30C.glGetVertexAttribIi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 1046 */     GL30C.nglGetVertexAttribIuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexAttribIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1059 */     GL30C.glGetVertexAttribIuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetVertexAttribIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1072 */     return GL30C.glGetVertexAttribIui(paramInt1, paramInt2);
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
/*      */   public static void glUniform1ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1086 */     GL30C.glUniform1ui(paramInt1, paramInt2);
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
/*      */   public static void glUniform2ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1101 */     GL30C.glUniform2ui(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glUniform3ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 1117 */     GL30C.glUniform3ui(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glUniform4ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 1134 */     GL30C.glUniform4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform1uiv(int paramInt1, int paramInt2, long paramLong) {
/* 1145 */     GL30C.nglUniform1uiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform1uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1157 */     GL30C.glUniform1uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform2uiv(int paramInt1, int paramInt2, long paramLong) {
/* 1168 */     GL30C.nglUniform2uiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform2uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1180 */     GL30C.glUniform2uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform3uiv(int paramInt1, int paramInt2, long paramLong) {
/* 1191 */     GL30C.nglUniform3uiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform3uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1203 */     GL30C.glUniform3uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform4uiv(int paramInt1, int paramInt2, long paramLong) {
/* 1214 */     GL30C.nglUniform4uiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform4uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1226 */     GL30C.glUniform4uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetUniformuiv(int paramInt1, int paramInt2, long paramLong) {
/* 1233 */     GL30C.nglGetUniformuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1246 */     GL30C.glGetUniformuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetUniformui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 1259 */     return GL30C.glGetUniformui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindFragDataLocation(int paramInt1, int paramInt2, long paramLong) {
/* 1266 */     GL30C.nglBindFragDataLocation(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glBindFragDataLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1279 */     GL30C.glBindFragDataLocation(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   public static void glBindFragDataLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1292 */     GL30C.glBindFragDataLocation(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetFragDataLocation(int paramInt, long paramLong) {
/* 1299 */     return GL30C.nglGetFragDataLocation(paramInt, paramLong);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataLocation(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1312 */     return GL30C.glGetFragDataLocation(paramInt, paramByteBuffer);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataLocation(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1325 */     return GL30C.glGetFragDataLocation(paramInt, paramCharSequence);
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
/*      */   public static void glBeginConditionalRender(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1339 */     GL30C.glBeginConditionalRender(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEndConditionalRender() {
/* 1350 */     GL30C.glEndConditionalRender();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/* 1357 */     return GL30C.nglMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2) {
/* 1380 */     return GL30C.glMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2, ByteBuffer paramByteBuffer) {
/* 1403 */     return GL30C.glMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2, paramByteBuffer);
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
/*      */   public static void glFlushMappedBufferRange(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 1418 */     GL30C.glFlushMappedBufferRange(paramInt, paramLong1, paramLong2);
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
/*      */   public static void glClampColor(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1432 */     GL30C.glClampColor(paramInt1, paramInt2);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsRenderbuffer(@NativeType("GLuint") int paramInt) {
/* 1446 */     return GL30C.glIsRenderbuffer(paramInt);
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
/*      */   public static void glBindRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1460 */     GL30C.glBindRenderbuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteRenderbuffers(int paramInt, long paramLong) {
/* 1471 */     GL30C.nglDeleteRenderbuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1482 */     GL30C.glDeleteRenderbuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int paramInt) {
/* 1491 */     GL30C.glDeleteRenderbuffers(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenRenderbuffers(int paramInt, long paramLong) {
/* 1502 */     GL30C.nglGenRenderbuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenRenderbuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1513 */     GL30C.glGenRenderbuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenRenderbuffers() {
/* 1523 */     return GL30C.glGenRenderbuffers();
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
/*      */   public static void glRenderbufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1539 */     GL30C.glRenderbufferStorage(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glRenderbufferStorageMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1558 */     GL30C.glRenderbufferStorageMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1565 */     GL30C.nglGetRenderbufferParameteriv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1578 */     GL30C.glGetRenderbufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetRenderbufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1591 */     return GL30C.glGetRenderbufferParameteri(paramInt1, paramInt2);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsFramebuffer(@NativeType("GLuint") int paramInt) {
/* 1605 */     return GL30C.glIsFramebuffer(paramInt);
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
/*      */   public static void glBindFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1619 */     GL30C.glBindFramebuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteFramebuffers(int paramInt, long paramLong) {
/* 1630 */     GL30C.nglDeleteFramebuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1641 */     GL30C.glDeleteFramebuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int paramInt) {
/* 1650 */     GL30C.glDeleteFramebuffers(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenFramebuffers(int paramInt, long paramLong) {
/* 1661 */     GL30C.nglGenFramebuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenFramebuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1672 */     GL30C.glGenFramebuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenFramebuffers() {
/* 1682 */     return GL30C.glGenFramebuffers();
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
/*      */   public static int glCheckFramebufferStatus(@NativeType("GLenum") int paramInt) {
/* 1696 */     return GL30C.glCheckFramebufferStatus(paramInt);
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
/*      */   public static void glFramebufferTexture1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 1713 */     GL30C.glFramebufferTexture1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glFramebufferTexture2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 1730 */     GL30C.glFramebufferTexture2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glFramebufferTexture3D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6) {
/* 1748 */     GL30C.glFramebufferTexture3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*      */   public static void glFramebufferTextureLayer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 1765 */     GL30C.glFramebufferTextureLayer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glFramebufferRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 1781 */     GL30C.glFramebufferRenderbuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1788 */     GL30C.nglGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1802 */     GL30C.glGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetFramebufferAttachmentParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 1816 */     return GL30C.glGetFramebufferAttachmentParameteri(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glBlitFramebuffer(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10) {
/* 1838 */     GL30C.glBlitFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
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
/*      */   public static void glGenerateMipmap(@NativeType("GLenum") int paramInt) {
/* 1851 */     GL30C.glGenerateMipmap(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 1858 */     GL30C.nglTexParameterIiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1871 */     GL30C.glTexParameterIiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static void glTexParameterIi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int paramInt3) {
/* 1883 */     GL30C.glTexParameterIi(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 1890 */     GL30C.nglTexParameterIuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1903 */     GL30C.glTexParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static void glTexParameterIui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int paramInt3) {
/* 1915 */     GL30C.glTexParameterIui(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 1922 */     GL30C.nglGetTexParameterIiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1935 */     GL30C.glGetTexParameterIiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetTexParameterIi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1948 */     return GL30C.glGetTexParameterIi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 1955 */     GL30C.nglGetTexParameterIuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1968 */     GL30C.glGetTexParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetTexParameterIui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1981 */     return GL30C.glGetTexParameterIui(paramInt1, paramInt2);
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
/*      */   public static void glColorMaski(@NativeType("GLuint") int paramInt, @NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4) {
/* 1998 */     GL30C.glColorMaski(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBooleani_v(int paramInt1, int paramInt2, long paramLong) {
/* 2005 */     GL30C.nglGetBooleani_v(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetBooleani_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/* 2018 */     GL30C.glGetBooleani_v(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   public static boolean glGetBooleani(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2031 */     return GL30C.glGetBooleani(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetIntegeri_v(int paramInt1, int paramInt2, long paramLong) {
/* 2038 */     GL30C.nglGetIntegeri_v(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetIntegeri_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2051 */     GL30C.glGetIntegeri_v(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetIntegeri(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2064 */     return GL30C.glGetIntegeri(paramInt1, paramInt2);
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
/*      */   public static void glEnablei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2078 */     GL30C.glEnablei(paramInt1, paramInt2);
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
/*      */   public static void glDisablei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2092 */     GL30C.glDisablei(paramInt1, paramInt2);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsEnabledi(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2107 */     return GL30C.glIsEnabledi(paramInt1, paramInt2);
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
/*      */   public static void glBindBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 2124 */     GL30C.glBindBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*      */   public static void glBindBufferBase(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 2139 */     GL30C.glBindBufferBase(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glBeginTransformFeedback(@NativeType("GLenum") int paramInt) {
/* 2152 */     GL30C.glBeginTransformFeedback(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEndTransformFeedback() {
/* 2163 */     GL30C.glEndTransformFeedback();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTransformFeedbackVaryings(int paramInt1, int paramInt2, long paramLong, int paramInt3) {
/* 2174 */     GL30C.nglTransformFeedbackVaryings(paramInt1, paramInt2, paramLong, paramInt3);
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
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLenum") int paramInt2) {
/* 2187 */     GL30C.glTransformFeedbackVaryings(paramInt1, paramPointerBuffer, paramInt2);
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
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") CharSequence[] paramArrayOfCharSequence, @NativeType("GLenum") int paramInt2) {
/* 2200 */     GL30C.glTransformFeedbackVaryings(paramInt1, paramArrayOfCharSequence, paramInt2);
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
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") CharSequence paramCharSequence, @NativeType("GLenum") int paramInt2) {
/* 2212 */     GL30C.glTransformFeedbackVaryings(paramInt1, paramCharSequence, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbackVarying(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 2223 */     GL30C.nglGetTransformFeedbackVarying(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3, paramLong4);
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
/*      */   public static void glGetTransformFeedbackVarying(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2239 */     GL30C.glGetTransformFeedbackVarying(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3, paramByteBuffer);
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
/*      */   @NativeType("void")
/*      */   public static String glGetTransformFeedbackVarying(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 2255 */     return GL30C.glGetTransformFeedbackVarying(paramInt1, paramInt2, paramInt3, paramIntBuffer1, paramIntBuffer2);
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
/*      */   public static String glGetTransformFeedbackVarying(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 2270 */     return glGetTransformFeedbackVarying(paramInt1, paramInt2, GL20.glGetProgrami(paramInt1, 35958), paramIntBuffer1, paramIntBuffer2);
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
/*      */   public static void glBindVertexArray(@NativeType("GLuint") int paramInt) {
/* 2283 */     GL30C.glBindVertexArray(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteVertexArrays(int paramInt, long paramLong) {
/* 2294 */     GL30C.nglDeleteVertexArrays(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2305 */     GL30C.glDeleteVertexArrays(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int paramInt) {
/* 2314 */     GL30C.glDeleteVertexArrays(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenVertexArrays(int paramInt, long paramLong) {
/* 2325 */     GL30C.nglGenVertexArrays(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenVertexArrays(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2336 */     GL30C.glGenVertexArrays(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenVertexArrays() {
/* 2346 */     return GL30C.glGenVertexArrays();
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsVertexArray(@NativeType("GLuint") int paramInt) {
/* 2360 */     return GL30C.glIsVertexArray(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2369 */     GL30C.glClearBufferiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2378 */     GL30C.glClearBufferuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferfv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2387 */     GL30C.glClearBufferfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI1iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2396 */     GL30C.glVertexAttribI1iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2405 */     GL30C.glVertexAttribI2iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2414 */     GL30C.glVertexAttribI3iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2423 */     GL30C.glVertexAttribI4iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI1uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2432 */     GL30C.glVertexAttribI1uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2441 */     GL30C.glVertexAttribI2uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2450 */     GL30C.glVertexAttribI3uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2459 */     GL30C.glVertexAttribI4uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2468 */     GL30C.glVertexAttribI4sv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4usv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2477 */     GL30C.glVertexAttribI4usv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2486 */     GL30C.glGetVertexAttribIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 2495 */     GL30C.glGetVertexAttribIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2504 */     GL30C.glUniform1uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2513 */     GL30C.glUniform2uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2522 */     GL30C.glUniform3uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2531 */     GL30C.glUniform4uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 2540 */     GL30C.glGetUniformuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2549 */     GL30C.glDeleteRenderbuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenRenderbuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2558 */     GL30C.glGenRenderbuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2567 */     GL30C.glGetRenderbufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2576 */     GL30C.glDeleteFramebuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenFramebuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2585 */     GL30C.glGenFramebuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2594 */     GL30C.glGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2603 */     GL30C.glTexParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2612 */     GL30C.glTexParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2621 */     GL30C.glGetTexParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 2630 */     GL30C.glGetTexParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetIntegeri_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2639 */     GL30C.glGetIntegeri_v(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackVarying(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2648 */     GL30C.glGetTransformFeedbackVarying(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2657 */     GL30C.glDeleteVertexArrays(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenVertexArrays(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2666 */     GL30C.glGenVertexArrays(paramArrayOfint);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL30.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */