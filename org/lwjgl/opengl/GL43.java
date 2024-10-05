/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL43
/*      */   extends GL42
/*      */ {
/*      */   public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 33513;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 34638;
/*      */   public static final int GL_COMPRESSED_RGB8_ETC2 = 37492;
/*      */   public static final int GL_COMPRESSED_SRGB8_ETC2 = 37493;
/*      */   public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37494;
/*      */   public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37495;
/*      */   public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 37496;
/*      */   public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 37497;
/*      */   public static final int GL_COMPRESSED_R11_EAC = 37488;
/*      */   public static final int GL_COMPRESSED_SIGNED_R11_EAC = 37489;
/*      */   public static final int GL_COMPRESSED_RG11_EAC = 37490;
/*      */   public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 37491;
/*      */   public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 36201;
/*      */   public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 36202;
/*      */   public static final int GL_MAX_ELEMENT_INDEX = 36203;
/*      */   public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
/*      */   public static final int GL_COMPUTE_SHADER = 37305;
/*      */   public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307;
/*      */   public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308;
/*      */   public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309;
/*      */   public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378;
/*      */   public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379;
/*      */   public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380;
/*      */   public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381;
/*      */   public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382;
/*      */   public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099;
/*      */   public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310;
/*      */   public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311;
/*      */   public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383;
/*      */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 37100;
/*      */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 37101;
/*      */   public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102;
/*      */   
/*      */   static {
/*   51 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103;
/*      */   
/*      */   public static final int GL_COMPUTE_SHADER_BIT = 32;
/*      */   
/*      */   public static final int GL_DEBUG_OUTPUT = 37600;
/*      */   
/*      */   public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
/*      */   
/*      */   public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
/*      */   
/*      */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
/*      */   
/*      */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
/*      */   
/*      */   public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
/*      */   
/*      */   public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
/*      */   
/*      */   public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
/*      */   
/*      */   public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
/*      */   
/*      */   public static final int GL_MAX_LABEL_LENGTH = 33512;
/*      */   
/*      */   public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
/*      */   
/*      */   public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_API = 33350;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
/*      */   
/*      */   public static final int GL_DEBUG_SOURCE_OTHER = 33355;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_ERROR = 33356;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_OTHER = 33361;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_MARKER = 33384;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
/*      */   
/*      */   public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_LOW = 37192;
/*      */   
/*      */   public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
/*      */   
/*      */   public static final int GL_BUFFER = 33504;
/*      */   
/*      */   public static final int GL_SHADER = 33505;
/*      */   
/*      */   public static final int GL_PROGRAM = 33506;
/*      */   
/*      */   public static final int GL_QUERY = 33507;
/*      */   
/*      */   public static final int GL_PROGRAM_PIPELINE = 33508;
/*      */   
/*      */   public static final int GL_SAMPLER = 33510;
/*      */   
/*      */   public static final int GL_DISPLAY_LIST = 33511;
/*      */   
/*      */   public static final int GL_MAX_UNIFORM_LOCATIONS = 33390;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
/*      */   
/*      */   public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
/*      */   
/*      */   public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
/*      */   
/*      */   public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
/*      */   
/*      */   public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_SUPPORTED = 33391;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_PREFERRED = 33392;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_RED_SIZE = 33393;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_GREEN_SIZE = 33394;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_BLUE_SIZE = 33395;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 33396;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 33397;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 33398;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_SHARED_SIZE = 33399;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_RED_TYPE = 33400;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_GREEN_TYPE = 33401;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_BLUE_TYPE = 33402;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 33403;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 33404;
/*      */   
/*      */   public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 33405;
/*      */   
/*      */   public static final int GL_MAX_WIDTH = 33406;
/*      */   
/*      */   public static final int GL_MAX_HEIGHT = 33407;
/*      */   
/*      */   public static final int GL_MAX_DEPTH = 33408;
/*      */   
/*      */   public static final int GL_MAX_LAYERS = 33409;
/*      */   
/*      */   public static final int GL_MAX_COMBINED_DIMENSIONS = 33410;
/*      */   
/*      */   public static final int GL_COLOR_COMPONENTS = 33411;
/*      */   
/*      */   public static final int GL_DEPTH_COMPONENTS = 33412;
/*      */   
/*      */   public static final int GL_STENCIL_COMPONENTS = 33413;
/*      */   
/*      */   public static final int GL_COLOR_RENDERABLE = 33414;
/*      */   
/*      */   public static final int GL_DEPTH_RENDERABLE = 33415;
/*      */   
/*      */   public static final int GL_STENCIL_RENDERABLE = 33416;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_RENDERABLE = 33417;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 33418;
/*      */   
/*      */   public static final int GL_FRAMEBUFFER_BLEND = 33419;
/*      */   
/*      */   public static final int GL_READ_PIXELS = 33420;
/*      */   
/*      */   public static final int GL_READ_PIXELS_FORMAT = 33421;
/*      */   
/*      */   public static final int GL_READ_PIXELS_TYPE = 33422;
/*      */   
/*      */   public static final int GL_TEXTURE_IMAGE_FORMAT = 33423;
/*      */   
/*      */   public static final int GL_TEXTURE_IMAGE_TYPE = 33424;
/*      */   
/*      */   public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 33425;
/*      */   
/*      */   public static final int GL_GET_TEXTURE_IMAGE_TYPE = 33426;
/*      */   
/*      */   public static final int GL_MIPMAP = 33427;
/*      */   
/*      */   public static final int GL_MANUAL_GENERATE_MIPMAP = 33428;
/*      */   
/*      */   public static final int GL_AUTO_GENERATE_MIPMAP = 33429;
/*      */   
/*      */   public static final int GL_COLOR_ENCODING = 33430;
/*      */   
/*      */   public static final int GL_SRGB_READ = 33431;
/*      */   
/*      */   public static final int GL_SRGB_WRITE = 33432;
/*      */   
/*      */   public static final int GL_FILTER = 33434;
/*      */   
/*      */   public static final int GL_VERTEX_TEXTURE = 33435;
/*      */   
/*      */   public static final int GL_TESS_CONTROL_TEXTURE = 33436;
/*      */   
/*      */   public static final int GL_TESS_EVALUATION_TEXTURE = 33437;
/*      */   
/*      */   public static final int GL_GEOMETRY_TEXTURE = 33438;
/*      */   
/*      */   public static final int GL_FRAGMENT_TEXTURE = 33439;
/*      */   
/*      */   public static final int GL_COMPUTE_TEXTURE = 33440;
/*      */   
/*      */   public static final int GL_TEXTURE_SHADOW = 33441;
/*      */   
/*      */   public static final int GL_TEXTURE_GATHER = 33442;
/*      */   
/*      */   public static final int GL_TEXTURE_GATHER_SHADOW = 33443;
/*      */   
/*      */   public static final int GL_SHADER_IMAGE_LOAD = 33444;
/*      */   
/*      */   public static final int GL_SHADER_IMAGE_STORE = 33445;
/*      */   
/*      */   public static final int GL_SHADER_IMAGE_ATOMIC = 33446;
/*      */   
/*      */   public static final int GL_IMAGE_TEXEL_SIZE = 33447;
/*      */   
/*      */   public static final int GL_IMAGE_COMPATIBILITY_CLASS = 33448;
/*      */   
/*      */   public static final int GL_IMAGE_PIXEL_FORMAT = 33449;
/*      */   
/*      */   public static final int GL_IMAGE_PIXEL_TYPE = 33450;
/*      */   
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 33452;
/*      */   
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 33453;
/*      */   
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 33454;
/*      */   
/*      */   public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 33455;
/*      */   
/*      */   public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 33457;
/*      */   
/*      */   public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 33458;
/*      */   
/*      */   public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 33459;
/*      */   
/*      */   public static final int GL_CLEAR_BUFFER = 33460;
/*      */   
/*      */   public static final int GL_TEXTURE_VIEW = 33461;
/*      */   
/*      */   public static final int GL_VIEW_COMPATIBILITY_CLASS = 33462;
/*      */   
/*      */   public static final int GL_FULL_SUPPORT = 33463;
/*      */   
/*      */   public static final int GL_CAVEAT_SUPPORT = 33464;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_4_X_32 = 33465;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_2_X_32 = 33466;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_1_X_32 = 33467;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_4_X_16 = 33468;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_2_X_16 = 33469;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_1_X_16 = 33470;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_4_X_8 = 33471;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_2_X_8 = 33472;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_1_X_8 = 33473;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_11_11_10 = 33474;
/*      */   
/*      */   public static final int GL_IMAGE_CLASS_10_10_10_2 = 33475;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_128_BITS = 33476;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_96_BITS = 33477;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_64_BITS = 33478;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_48_BITS = 33479;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_32_BITS = 33480;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_24_BITS = 33481;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_16_BITS = 33482;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_8_BITS = 33483;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 33484;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 33485;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 33486;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 33487;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_RGTC1_RED = 33488;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_RGTC2_RG = 33489;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_BPTC_UNORM = 33490;
/*      */   
/*      */   public static final int GL_VIEW_CLASS_BPTC_FLOAT = 33491;
/*      */   
/*      */   public static final int GL_UNIFORM = 37601;
/*      */   
/*      */   public static final int GL_UNIFORM_BLOCK = 37602;
/*      */   
/*      */   public static final int GL_PROGRAM_INPUT = 37603;
/*      */   
/*      */   public static final int GL_PROGRAM_OUTPUT = 37604;
/*      */   
/*      */   public static final int GL_BUFFER_VARIABLE = 37605;
/*      */   
/*      */   public static final int GL_SHADER_STORAGE_BLOCK = 37606;
/*      */   
/*      */   public static final int GL_VERTEX_SUBROUTINE = 37608;
/*      */   
/*      */   public static final int GL_TESS_CONTROL_SUBROUTINE = 37609;
/*      */   
/*      */   public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610;
/*      */   
/*      */   public static final int GL_GEOMETRY_SUBROUTINE = 37611;
/*      */   
/*      */   public static final int GL_FRAGMENT_SUBROUTINE = 37612;
/*      */   
/*      */   public static final int GL_COMPUTE_SUBROUTINE = 37613;
/*      */   
/*      */   public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614;
/*      */   
/*      */   public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615;
/*      */   
/*      */   public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616;
/*      */   
/*      */   public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617;
/*      */   
/*      */   public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618;
/*      */   public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620;
/*      */   public static final int GL_ACTIVE_RESOURCES = 37621;
/*      */   public static final int GL_MAX_NAME_LENGTH = 37622;
/*      */   public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623;
/*      */   public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624;
/*      */   public static final int GL_NAME_LENGTH = 37625;
/*      */   public static final int GL_TYPE = 37626;
/*      */   public static final int GL_ARRAY_SIZE = 37627;
/*      */   public static final int GL_OFFSET = 37628;
/*      */   public static final int GL_BLOCK_INDEX = 37629;
/*      */   public static final int GL_ARRAY_STRIDE = 37630;
/*      */   public static final int GL_MATRIX_STRIDE = 37631;
/*      */   public static final int GL_IS_ROW_MAJOR = 37632;
/*      */   public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633;
/*      */   public static final int GL_BUFFER_BINDING = 37634;
/*      */   public static final int GL_BUFFER_DATA_SIZE = 37635;
/*      */   public static final int GL_NUM_ACTIVE_VARIABLES = 37636;
/*      */   public static final int GL_ACTIVE_VARIABLES = 37637;
/*      */   public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638;
/*      */   public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
/*      */   public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
/*      */   public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
/*      */   public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642;
/*      */   public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643;
/*      */   public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644;
/*      */   public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645;
/*      */   public static final int GL_LOCATION = 37646;
/*      */   public static final int GL_LOCATION_INDEX = 37647;
/*      */   public static final int GL_IS_PER_PATCH = 37607;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER = 37074;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_START = 37076;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077;
/*      */   public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078;
/*      */   public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079;
/*      */   public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080;
/*      */   public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081;
/*      */   public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082;
/*      */   public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083;
/*      */   public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084;
/*      */   public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085;
/*      */   public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086;
/*      */   public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087;
/*      */   public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192;
/*      */   public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665;
/*      */   public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 37098;
/*      */   public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
/*      */   public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
/*      */   public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
/*      */   public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
/*      */   public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
/*      */   public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
/*      */   public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
/*      */   public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
/*      */   public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
/*      */   public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
/*      */   public static final int GL_VERTEX_BINDING_OFFSET = 33495;
/*      */   public static final int GL_VERTEX_BINDING_STRIDE = 33496;
/*      */   public static final int GL_VERTEX_BINDING_BUFFER = 36687;
/*      */   public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
/*      */   public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;
/*      */   
/*      */   protected GL43() {
/*  448 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  455 */     GL43C.nglClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  472 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  489 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  506 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  523 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3) {
/*  530 */     GL43C.nglClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  549 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  568 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  587 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  606 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDispatchCompute(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  621 */     GL43C.glDispatchCompute(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDispatchComputeIndirect(@NativeType("GLintptr") long paramLong) {
/*  650 */     GL43C.glDispatchComputeIndirect(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyImageSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLsizei") int paramInt13, @NativeType("GLsizei") int paramInt14, @NativeType("GLsizei") int paramInt15) {
/*  677 */     GL43C.glCopyImageSubData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDebugMessageControl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean) {
/*  688 */     GL43C.nglDebugMessageControl(paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLboolean") boolean paramBoolean) {
/*  726 */     GL43C.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int paramInt4, @NativeType("GLboolean") boolean paramBoolean) {
/*  763 */     GL43C.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDebugMessageInsert(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/*  774 */     GL43C.nglDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageInsert(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  798 */     GL43C.glDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageInsert(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  822 */     GL43C.glDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDebugMessageCallback(long paramLong1, long paramLong2) {
/*  829 */     GL43C.nglDebugMessageCallback(paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageCallback(@NativeType("GLDEBUGPROC") GLDebugMessageCallbackI paramGLDebugMessageCallbackI, @NativeType("void const *") long paramLong) {
/*  866 */     GL43C.glDebugMessageCallback(paramGLDebugMessageCallbackI, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetDebugMessageLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
/*  877 */     return GL43C.nglGetDebugMessageLog(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetDebugMessageLog(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer3, @NativeType("GLenum *") IntBuffer paramIntBuffer4, @NativeType("GLsizei *") IntBuffer paramIntBuffer5, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/*  917 */     return GL43C.glGetDebugMessageLog(paramInt, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3, paramIntBuffer4, paramIntBuffer5, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglPushDebugGroup(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  928 */     GL43C.nglPushDebugGroup(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPushDebugGroup(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  950 */     GL43C.glPushDebugGroup(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPushDebugGroup(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  972 */     GL43C.glPushDebugGroup(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPopDebugGroup() {
/*  989 */     GL43C.glPopDebugGroup();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1000 */     GL43C.nglObjectLabel(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1013 */     GL43C.glObjectLabel(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1026 */     GL43C.glObjectLabel(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
/* 1037 */     GL43C.nglGetObjectLabel(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1051 */     GL43C.glGetObjectLabel(paramInt1, paramInt2, paramIntBuffer, paramByteBuffer);
/*      */   }
/*      */ 
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
/*      */   public static String glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 1065 */     return GL43C.glGetObjectLabel(paramInt1, paramInt2, paramInt3);
/*      */   }
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
/*      */   public static String glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1078 */     return glGetObjectLabel(paramInt1, paramInt2, GL11.glGetInteger(33512));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglObjectPtrLabel(long paramLong1, int paramInt, long paramLong2) {
/* 1089 */     GL43C.nglObjectPtrLabel(paramLong1, paramInt, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1101 */     GL43C.glObjectPtrLabel(paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1113 */     GL43C.glObjectPtrLabel(paramLong, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetObjectPtrLabel(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
/* 1124 */     GL43C.nglGetObjectPtrLabel(paramLong1, paramInt, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1137 */     GL43C.glGetObjectPtrLabel(paramLong, paramIntBuffer, paramByteBuffer);
/*      */   }
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
/*      */   public static String glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei") int paramInt) {
/* 1150 */     return GL43C.glGetObjectPtrLabel(paramLong, paramInt);
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
/*      */   public static String glGetObjectPtrLabel(@NativeType("void *") long paramLong) {
/* 1162 */     return glGetObjectPtrLabel(paramLong, GL11.glGetInteger(33512));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFramebufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 1177 */     GL43C.glFramebufferParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1184 */     GL43C.nglGetFramebufferParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1197 */     GL43C.glGetFramebufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
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
/*      */   public static int glGetFramebufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1210 */     return GL43C.glGetFramebufferParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetInternalformati64v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 1221 */     GL43C.nglGetInternalformati64v(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetInternalformati64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 1235 */     GL43C.glGetInternalformati64v(paramInt1, paramInt2, paramInt3, paramLongBuffer);
/*      */   }
/*      */ 
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
/*      */   public static long glGetInternalformati64(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 1249 */     return GL43C.glGetInternalformati64(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8) {
/* 1269 */     GL43C.glInvalidateTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 1283 */     GL43C.glInvalidateTexImage(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 1298 */     GL43C.glInvalidateBufferSubData(paramInt, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateBufferData(@NativeType("GLuint") int paramInt) {
/* 1311 */     GL43C.glInvalidateBufferData(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateFramebuffer(int paramInt1, int paramInt2, long paramLong) {
/* 1322 */     GL43C.nglInvalidateFramebuffer(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 1334 */     GL43C.glInvalidateFramebuffer(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/* 1345 */     GL43C.glInvalidateFramebuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateSubFramebuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 1356 */     GL43C.nglInvalidateSubFramebuffer(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1372 */     GL43C.glInvalidateSubFramebuffer(paramInt1, paramIntBuffer, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 1387 */     GL43C.glInvalidateSubFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglMultiDrawArraysIndirect(int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/* 1394 */     GL43C.nglMultiDrawArraysIndirect(paramInt1, paramLong, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 1430 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramByteBuffer, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 1466 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramLong, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 1502 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramIntBuffer, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglMultiDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4) {
/* 1509 */     GL43C.nglMultiDrawElementsIndirect(paramInt1, paramInt2, paramLong, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1547 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramByteBuffer, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1585 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramLong, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1623 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramIntBuffer, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramInterfaceiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1630 */     GL43C.nglGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramInterfaceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1644 */     GL43C.glGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
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
/*      */   public static int glGetProgramInterfacei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 1658 */     return GL43C.glGetProgramInterfacei(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetProgramResourceIndex(int paramInt1, int paramInt2, long paramLong) {
/* 1665 */     return GL43C.nglGetProgramResourceIndex(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetProgramResourceIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1679 */     return GL43C.glGetProgramResourceIndex(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetProgramResourceIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1693 */     return GL43C.glGetProgramResourceIndex(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramResourceName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2) {
/* 1704 */     GL43C.nglGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1719 */     GL43C.glGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
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
/*      */   public static String glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1734 */     return GL43C.glGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
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
/*      */   public static String glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1748 */     return glGetProgramResourceName(paramInt1, paramInt2, paramInt3, glGetProgramInterfacei(paramInt1, paramInt2, 37622));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramResourceiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3) {
/* 1760 */     GL43C.nglGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramInt5, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum const *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLint *") IntBuffer paramIntBuffer3) {
/* 1776 */     GL43C.glGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetProgramResourceLocation(int paramInt1, int paramInt2, long paramLong) {
/* 1783 */     return GL43C.nglGetProgramResourceLocation(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
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
/*      */   public static int glGetProgramResourceLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1797 */     return GL43C.glGetProgramResourceLocation(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
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
/*      */   public static int glGetProgramResourceLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1811 */     return GL43C.glGetProgramResourceLocation(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetProgramResourceLocationIndex(int paramInt1, int paramInt2, long paramLong) {
/* 1818 */     return GL43C.nglGetProgramResourceLocationIndex(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
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
/*      */   public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1832 */     return GL43C.glGetProgramResourceLocationIndex(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
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
/*      */   public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1846 */     return GL43C.glGetProgramResourceLocationIndex(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glShaderStorageBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1861 */     GL43C.glShaderStorageBlockBinding(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 1878 */     GL43C.glTexBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexStorage2DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean) {
/* 1897 */     GL43C.glTexStorage2DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexStorage3DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean) {
/* 1917 */     GL43C.glTexStorage3DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureView(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint") int paramInt8) {
/* 1937 */     GL43C.glTextureView(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3) {
/* 1953 */     GL43C.glBindVertexBuffer(paramInt1, paramInt2, paramLong, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt4) {
/* 1971 */     GL43C.glVertexAttribFormat(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 1987 */     GL43C.glVertexAttribIFormat(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 2003 */     GL43C.glVertexAttribLFormat(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2017 */     GL43C.glVertexAttribBinding(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2031 */     GL43C.glVertexBindingDivisor(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2040 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 2049 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2058 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2067 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 2076 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2085 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLboolean") boolean paramBoolean) {
/* 2094 */     GL43C.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetDebugMessageLog(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3, @NativeType("GLenum *") int[] paramArrayOfint4, @NativeType("GLsizei *") int[] paramArrayOfint5, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2104 */     return GL43C.glGetDebugMessageLog(paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramArrayOfint5, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2113 */     GL43C.glGetObjectLabel(paramInt1, paramInt2, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2122 */     GL43C.glGetObjectPtrLabel(paramLong, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2131 */     GL43C.glGetFramebufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetInternalformati64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 2140 */     GL43C.glGetInternalformati64v(paramInt1, paramInt2, paramInt3, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 2149 */     GL43C.glInvalidateFramebuffer(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int[] paramArrayOfint, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 2158 */     GL43C.glInvalidateSubFramebuffer(paramInt1, paramArrayOfint, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 2167 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramArrayOfint, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 2176 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramArrayOfint, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramInterfaceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2185 */     GL43C.glGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2194 */     GL43C.glGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum const *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLint *") int[] paramArrayOfint3) {
/* 2203 */     GL43C.glGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL43.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */