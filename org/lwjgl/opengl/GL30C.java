/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL30C
/*      */   extends GL21C
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
/*      */   
/*      */   static {
/*   51 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_INT_SAMPLER_CUBE = 36300;
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
/*      */   protected GL30C() {
/*  478 */     throw new UnsupportedOperationException();
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
/*      */   @NativeType("GLubyte const *")
/*      */   public static String glGetStringi(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     long l;
/*  498 */     return MemoryUtil.memUTF8Safe(l = nglGetStringi(paramInt1, paramInt2));
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
/*      */   public static void glClearBufferiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  517 */     if (Checks.CHECKS) {
/*  518 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  520 */     nglClearBufferiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glClearBufferuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  538 */     if (Checks.CHECKS) {
/*  539 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  541 */     nglClearBufferuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glClearBufferfv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  560 */     if (Checks.CHECKS) {
/*  561 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  563 */     nglClearBufferfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glVertexAttribI1iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  702 */     if (Checks.CHECKS) {
/*  703 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  705 */     nglVertexAttribI1iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI2iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  722 */     if (Checks.CHECKS) {
/*  723 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/*  725 */     nglVertexAttribI2iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI3iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  742 */     if (Checks.CHECKS) {
/*  743 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/*  745 */     nglVertexAttribI3iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI4iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  762 */     if (Checks.CHECKS) {
/*  763 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  765 */     nglVertexAttribI4iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI1uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  782 */     if (Checks.CHECKS) {
/*  783 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  785 */     nglVertexAttribI1uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI2uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  802 */     if (Checks.CHECKS) {
/*  803 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/*  805 */     nglVertexAttribI2uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI3uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  822 */     if (Checks.CHECKS) {
/*  823 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/*  825 */     nglVertexAttribI3uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI4uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  842 */     if (Checks.CHECKS) {
/*  843 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  845 */     nglVertexAttribI4uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribI4bv(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  862 */     if (Checks.CHECKS) {
/*  863 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/*  865 */     nglVertexAttribI4bv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glVertexAttribI4sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  882 */     if (Checks.CHECKS) {
/*  883 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/*  885 */     nglVertexAttribI4sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttribI4ubv(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  902 */     if (Checks.CHECKS) {
/*  903 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/*  905 */     nglVertexAttribI4ubv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glVertexAttribI4usv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  922 */     if (Checks.CHECKS) {
/*  923 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/*  925 */     nglVertexAttribI4usv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttribIPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  947 */     nglVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
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
/*  964 */     nglVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*  981 */     nglVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramShortBuffer));
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
/*  998 */     nglVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetVertexAttribIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1016 */     if (Checks.CHECKS) {
/* 1017 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1019 */     nglGetVertexAttribIiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetVertexAttribIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1032 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1034 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1035 */       nglGetVertexAttribIiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1036 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1038 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetVertexAttribIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1057 */     if (Checks.CHECKS) {
/* 1058 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1060 */     nglGetVertexAttribIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetVertexAttribIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1073 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1075 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1076 */       nglGetVertexAttribIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1077 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1079 */       memoryStack.setPointer(i);
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
/*      */   public static void glUniform1uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1155 */     nglUniform1uiv(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glUniform2uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1176 */     nglUniform2uiv(paramInt, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glUniform3uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1197 */     nglUniform3uiv(paramInt, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glUniform4uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1218 */     nglUniform4uiv(paramInt, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1236 */     if (Checks.CHECKS) {
/* 1237 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1239 */     nglGetUniformuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetUniformui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1252 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1254 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1255 */       nglGetUniformuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1256 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1258 */       memoryStack.setPointer(i);
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
/*      */   public static void glBindFragDataLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1277 */     if (Checks.CHECKS) {
/* 1278 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1280 */     nglBindFragDataLocation(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glBindFragDataLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1293 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1295 */       memoryStack.nASCII(paramCharSequence, true);
/* 1296 */       long l = memoryStack.getPointerAddress();
/* 1297 */       nglBindFragDataLocation(paramInt1, paramInt2, l); return;
/*      */     } finally {
/* 1299 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataLocation(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1318 */     if (Checks.CHECKS) {
/* 1319 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1321 */     return nglGetFragDataLocation(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1334 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1336 */       memoryStack.nASCII(paramCharSequence, true);
/* 1337 */       long l = memoryStack.getPointerAddress();
/* 1338 */       paramInt = nglGetFragDataLocation(paramInt, l); return paramInt;
/*      */     } finally {
/* 1340 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2) {
/*      */     long l;
/* 1391 */     return MemoryUtil.memByteBufferSafe(l = nglMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2), (int)paramLong2);
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
/* 1414 */     long l = nglMapBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
/* 1415 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong2);
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
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1484 */     nglDeleteRenderbuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1493 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1495 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 1496 */       nglDeleteRenderbuffers(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1498 */       memoryStack.setPointer(i);
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
/*      */   public static void glGenRenderbuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1519 */     nglGenRenderbuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenRenderbuffers() {
/*      */     MemoryStack memoryStack;
/* 1529 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1531 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1532 */       nglGenRenderbuffers(1, MemoryUtil.memAddress(intBuffer));
/* 1533 */       return intBuffer.get(0);
/*      */     } finally {
/* 1535 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1585 */     if (Checks.CHECKS) {
/* 1586 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1588 */     nglGetRenderbufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetRenderbufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1601 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1603 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1604 */       nglGetRenderbufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1605 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1607 */       memoryStack.setPointer(i);
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
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1652 */     nglDeleteFramebuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1661 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1663 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 1664 */       nglDeleteFramebuffers(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1666 */       memoryStack.setPointer(i);
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
/*      */   public static void glGenFramebuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1687 */     nglGenFramebuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenFramebuffers() {
/*      */     MemoryStack memoryStack;
/* 1697 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1699 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1700 */       nglGenFramebuffers(1, MemoryUtil.memAddress(intBuffer));
/* 1701 */       return intBuffer.get(0);
/*      */     } finally {
/* 1703 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1810 */     if (Checks.CHECKS) {
/* 1811 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1813 */     nglGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetFramebufferAttachmentParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1827 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1829 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1830 */       nglGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1831 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1833 */       memoryStack.setPointer(i);
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
/*      */   public static void glTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1883 */     if (Checks.CHECKS) {
/* 1884 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1886 */     nglTexParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterIi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1898 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1900 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 1901 */       nglTexParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1903 */       memoryStack.setPointer(i);
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
/*      */   public static void glTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1922 */     if (Checks.CHECKS) {
/* 1923 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1925 */     nglTexParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterIui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1937 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1939 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 1940 */       nglTexParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1942 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1961 */     if (Checks.CHECKS) {
/* 1962 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1964 */     nglGetTexParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTexParameterIi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1977 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1979 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1980 */       nglGetTexParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1981 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1983 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2002 */     if (Checks.CHECKS) {
/* 2003 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2005 */     nglGetTexParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTexParameterIui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2018 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2020 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2021 */       nglGetTexParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2022 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2024 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetBooleani_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/* 2058 */     if (Checks.CHECKS) {
/* 2059 */       Checks.check(paramByteBuffer, 1);
/*      */     }
/* 2061 */     nglGetBooleani_v(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static boolean glGetBooleani(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2074 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2076 */       ByteBuffer byteBuffer = memoryStack.calloc(1);
/* 2077 */       nglGetBooleani_v(paramInt1, paramInt2, MemoryUtil.memAddress(byteBuffer));
/* 2078 */       paramInt1 = (byteBuffer.get(0) != 0) ? 1 : 0; return paramInt1;
/*      */     } finally {
/* 2080 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetIntegeri_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2099 */     if (Checks.CHECKS) {
/* 2100 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2102 */     nglGetIntegeri_v(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetIntegeri(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2115 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2117 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2118 */       nglGetIntegeri_v(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2119 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2121 */       memoryStack.setPointer(i);
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
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLenum") int paramInt2) {
/* 2229 */     nglTransformFeedbackVaryings(paramInt1, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramInt2);
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
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") CharSequence[] paramArrayOfCharSequence, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2242 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2244 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, paramArrayOfCharSequence);
/* 2245 */       nglTransformFeedbackVaryings(paramInt1, paramArrayOfCharSequence.length, l, paramInt2);
/* 2246 */       APIUtil.apiArrayFree(l, paramArrayOfCharSequence.length); return;
/*      */     } finally {
/* 2248 */       memoryStack.setPointer(i);
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
/*      */   public static void glTransformFeedbackVaryings(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") CharSequence paramCharSequence, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2261 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2263 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, new CharSequence[] { paramCharSequence });
/* 2264 */       nglTransformFeedbackVaryings(paramInt1, 1, l, paramInt2);
/* 2265 */       APIUtil.apiArrayFree(l, 1); return;
/*      */     } finally {
/* 2267 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTransformFeedbackVarying(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2293 */     if (Checks.CHECKS) {
/* 2294 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 2295 */       Checks.check(paramIntBuffer2, 1);
/* 2296 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/* 2298 */     nglGetTransformFeedbackVarying(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramByteBuffer));
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
/* 2314 */     if (Checks.CHECKS) {
/* 2315 */       Checks.check(paramIntBuffer1, 1);
/* 2316 */       Checks.check(paramIntBuffer2, 1);
/*      */     }  MemoryStack memoryStack;
/* 2318 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2320 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 2321 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 2322 */       nglGetTransformFeedbackVarying(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(byteBuffer));
/* 2323 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 2325 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetTransformFeedbackVarying(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 2341 */     return glGetTransformFeedbackVarying(paramInt1, paramInt2, GL20.glGetProgrami(paramInt1, 35958), paramIntBuffer1, paramIntBuffer2);
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
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2372 */     nglDeleteVertexArrays(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 2381 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2383 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 2384 */       nglDeleteVertexArrays(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 2386 */       memoryStack.setPointer(i);
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
/*      */   public static void glGenVertexArrays(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2407 */     nglGenVertexArrays(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenVertexArrays() {
/*      */     MemoryStack memoryStack;
/* 2417 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2419 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2420 */       nglGenVertexArrays(1, MemoryUtil.memAddress(intBuffer));
/* 2421 */       return intBuffer.get(0);
/*      */     } finally {
/* 2423 */       memoryStack.setPointer(i);
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
/*      */   public static void glClearBufferiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2445 */     long l = (GL.getICD()).glClearBufferiv;
/* 2446 */     if (Checks.CHECKS) {
/* 2447 */       Checks.check(l);
/* 2448 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2450 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2459 */     long l = (GL.getICD()).glClearBufferuiv;
/* 2460 */     if (Checks.CHECKS) {
/* 2461 */       Checks.check(l);
/* 2462 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2464 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferfv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2473 */     long l = (GL.getICD()).glClearBufferfv;
/* 2474 */     if (Checks.CHECKS) {
/* 2475 */       Checks.check(l);
/* 2476 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2478 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI1iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2487 */     long l = (GL.getICD()).glVertexAttribI1iv;
/* 2488 */     if (Checks.CHECKS) {
/* 2489 */       Checks.check(l);
/* 2490 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2492 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2501 */     long l = (GL.getICD()).glVertexAttribI2iv;
/* 2502 */     if (Checks.CHECKS) {
/* 2503 */       Checks.check(l);
/* 2504 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 2506 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2515 */     long l = (GL.getICD()).glVertexAttribI3iv;
/* 2516 */     if (Checks.CHECKS) {
/* 2517 */       Checks.check(l);
/* 2518 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 2520 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2529 */     long l = (GL.getICD()).glVertexAttribI4iv;
/* 2530 */     if (Checks.CHECKS) {
/* 2531 */       Checks.check(l);
/* 2532 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2534 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI1uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2543 */     long l = (GL.getICD()).glVertexAttribI1uiv;
/* 2544 */     if (Checks.CHECKS) {
/* 2545 */       Checks.check(l);
/* 2546 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2548 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI2uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2557 */     long l = (GL.getICD()).glVertexAttribI2uiv;
/* 2558 */     if (Checks.CHECKS) {
/* 2559 */       Checks.check(l);
/* 2560 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 2562 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI3uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2571 */     long l = (GL.getICD()).glVertexAttribI3uiv;
/* 2572 */     if (Checks.CHECKS) {
/* 2573 */       Checks.check(l);
/* 2574 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 2576 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2585 */     long l = (GL.getICD()).glVertexAttribI4uiv;
/* 2586 */     if (Checks.CHECKS) {
/* 2587 */       Checks.check(l);
/* 2588 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2590 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2599 */     long l = (GL.getICD()).glVertexAttribI4sv;
/* 2600 */     if (Checks.CHECKS) {
/* 2601 */       Checks.check(l);
/* 2602 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 2604 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribI4usv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2613 */     long l = (GL.getICD()).glVertexAttribI4usv;
/* 2614 */     if (Checks.CHECKS) {
/* 2615 */       Checks.check(l);
/* 2616 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 2618 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2627 */     long l = (GL.getICD()).glGetVertexAttribIiv;
/* 2628 */     if (Checks.CHECKS) {
/* 2629 */       Checks.check(l);
/* 2630 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2632 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 2641 */     long l = (GL.getICD()).glGetVertexAttribIuiv;
/* 2642 */     if (Checks.CHECKS) {
/* 2643 */       Checks.check(l);
/* 2644 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2646 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2655 */     long l = (GL.getICD()).glUniform1uiv;
/* 2656 */     if (Checks.CHECKS) {
/* 2657 */       Checks.check(l);
/*      */     }
/* 2659 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2668 */     long l = (GL.getICD()).glUniform2uiv;
/* 2669 */     if (Checks.CHECKS) {
/* 2670 */       Checks.check(l);
/*      */     }
/* 2672 */     JNI.callPV(paramInt, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2681 */     long l = (GL.getICD()).glUniform3uiv;
/* 2682 */     if (Checks.CHECKS) {
/* 2683 */       Checks.check(l);
/*      */     }
/* 2685 */     JNI.callPV(paramInt, paramArrayOfint.length / 3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4uiv(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2694 */     long l = (GL.getICD()).glUniform4uiv;
/* 2695 */     if (Checks.CHECKS) {
/* 2696 */       Checks.check(l);
/*      */     }
/* 2698 */     JNI.callPV(paramInt, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 2707 */     long l = (GL.getICD()).glGetUniformuiv;
/* 2708 */     if (Checks.CHECKS) {
/* 2709 */       Checks.check(l);
/* 2710 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2712 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2721 */     long l = (GL.getICD()).glDeleteRenderbuffers;
/* 2722 */     if (Checks.CHECKS) {
/* 2723 */       Checks.check(l);
/*      */     }
/* 2725 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenRenderbuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2734 */     long l = (GL.getICD()).glGenRenderbuffers;
/* 2735 */     if (Checks.CHECKS) {
/* 2736 */       Checks.check(l);
/*      */     }
/* 2738 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2747 */     long l = (GL.getICD()).glGetRenderbufferParameteriv;
/* 2748 */     if (Checks.CHECKS) {
/* 2749 */       Checks.check(l);
/* 2750 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2752 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2761 */     long l = (GL.getICD()).glDeleteFramebuffers;
/* 2762 */     if (Checks.CHECKS) {
/* 2763 */       Checks.check(l);
/*      */     }
/* 2765 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenFramebuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2774 */     long l = (GL.getICD()).glGenFramebuffers;
/* 2775 */     if (Checks.CHECKS) {
/* 2776 */       Checks.check(l);
/*      */     }
/* 2778 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2787 */     long l = (GL.getICD()).glGetFramebufferAttachmentParameteriv;
/* 2788 */     if (Checks.CHECKS) {
/* 2789 */       Checks.check(l);
/* 2790 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2792 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2801 */     long l = (GL.getICD()).glTexParameterIiv;
/* 2802 */     if (Checks.CHECKS) {
/* 2803 */       Checks.check(l);
/* 2804 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2806 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2815 */     long l = (GL.getICD()).glTexParameterIuiv;
/* 2816 */     if (Checks.CHECKS) {
/* 2817 */       Checks.check(l);
/* 2818 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2820 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2829 */     long l = (GL.getICD()).glGetTexParameterIiv;
/* 2830 */     if (Checks.CHECKS) {
/* 2831 */       Checks.check(l);
/* 2832 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2834 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterIuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 2843 */     long l = (GL.getICD()).glGetTexParameterIuiv;
/* 2844 */     if (Checks.CHECKS) {
/* 2845 */       Checks.check(l);
/* 2846 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2848 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetIntegeri_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2857 */     long l = (GL.getICD()).glGetIntegeri_v;
/* 2858 */     if (Checks.CHECKS) {
/* 2859 */       Checks.check(l);
/* 2860 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2862 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackVarying(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2871 */     long l = (GL.getICD()).glGetTransformFeedbackVarying;
/* 2872 */     if (Checks.CHECKS) {
/* 2873 */       Checks.check(l);
/* 2874 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2875 */       Checks.check(paramArrayOfint2, 1);
/* 2876 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 2878 */     JNI.callPPPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2887 */     long l = (GL.getICD()).glDeleteVertexArrays;
/* 2888 */     if (Checks.CHECKS) {
/* 2889 */       Checks.check(l);
/*      */     }
/* 2891 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenVertexArrays(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2900 */     long l = (GL.getICD()).glGenVertexArrays;
/* 2901 */     if (Checks.CHECKS) {
/* 2902 */       Checks.check(l);
/*      */     }
/* 2904 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */   
/*      */   public static native long nglGetStringi(int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nglClearBufferiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglClearBufferuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglClearBufferfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glClearBufferfi(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribI1i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glVertexAttribI2i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribI3i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribI4i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glVertexAttribI1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexAttribI2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribI3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribI4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void nglVertexAttribI1iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI2iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI3iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI1uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI2uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI3uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4bv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4ubv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribI4usv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribIPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glUniform1ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glUniform2ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glUniform3ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glUniform4ui(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void nglUniform1uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetUniformuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglBindFragDataLocation(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native int nglGetFragDataLocation(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glBeginConditionalRender(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glEndConditionalRender();
/*      */   
/*      */   public static native long nglMapBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void glFlushMappedBufferRange(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glClampColor(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsRenderbuffer(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBindRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteRenderbuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenRenderbuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glRenderbufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glRenderbufferStorageMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglGetRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsFramebuffer(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBindFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteFramebuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenFramebuffers(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glCheckFramebufferStatus(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glFramebufferTexture1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glFramebufferTexture2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glFramebufferTexture3D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void glFramebufferTextureLayer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glFramebufferRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void nglGetFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glBlitFramebuffer(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10);
/*      */   
/*      */   public static native void glGenerateMipmap(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglTexParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTexParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glColorMaski(@NativeType("GLuint") int paramInt, @NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4);
/*      */   
/*      */   public static native void nglGetBooleani_v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetIntegeri_v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glEnablei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisablei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsEnabledi(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glBindBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glBindBufferBase(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glBeginTransformFeedback(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glEndTransformFeedback();
/*      */   
/*      */   public static native void nglTransformFeedbackVaryings(int paramInt1, int paramInt2, long paramLong, int paramInt3);
/*      */   
/*      */   public static native void nglGetTransformFeedbackVarying(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void glBindVertexArray(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglDeleteVertexArrays(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenVertexArrays(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsVertexArray(@NativeType("GLuint") int paramInt);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL30C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */