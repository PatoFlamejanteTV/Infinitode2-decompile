/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Pointer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL43C
/*      */   extends GL42C
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
/*   56 */     GL.initialize();
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
/*      */   
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
/*      */   protected GL43C() {
/*  452 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  474 */     nglClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  491 */     nglClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  508 */     nglClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  525 */     nglClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  549 */     nglClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  568 */     nglClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  587 */     nglClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  606 */     nglClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  718 */     nglDebugMessageControl(paramInt1, paramInt2, paramInt3, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     MemoryStack memoryStack;
/*  755 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  757 */       IntBuffer intBuffer = memoryStack.ints(paramInt4);
/*  758 */       nglDebugMessageControl(paramInt1, paramInt2, paramInt3, 1, MemoryUtil.memAddress(intBuffer), paramBoolean); return;
/*      */     } finally {
/*  760 */       memoryStack.setPointer(i);
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
/*      */   public static void glDebugMessageInsert(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  794 */     nglDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     MemoryStack memoryStack;
/*  818 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  820 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/*  821 */       long l = memoryStack.getPointerAddress();
/*  822 */       nglDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, j, l); return;
/*      */     } finally {
/*  824 */       memoryStack.setPointer(i);
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
/*      */   public static void glDebugMessageCallback(@NativeType("GLDEBUGPROC") GLDebugMessageCallbackI paramGLDebugMessageCallbackI, @NativeType("void const *") long paramLong) {
/*  867 */     nglDebugMessageCallback(MemoryUtil.memAddressSafe((Pointer)paramGLDebugMessageCallbackI), paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  916 */     if (Checks.CHECKS) {
/*  917 */       Checks.checkSafe(paramIntBuffer1, paramInt);
/*  918 */       Checks.checkSafe(paramIntBuffer2, paramInt);
/*  919 */       Checks.checkSafe(paramIntBuffer3, paramInt);
/*  920 */       Checks.checkSafe(paramIntBuffer4, paramInt);
/*  921 */       Checks.checkSafe(paramIntBuffer5, paramInt);
/*      */     } 
/*  923 */     return nglGetDebugMessageLog(paramInt, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4), MemoryUtil.memAddressSafe(paramIntBuffer5), MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  954 */     nglPushDebugGroup(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     MemoryStack memoryStack;
/*  976 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  978 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/*  979 */       long l = memoryStack.getPointerAddress();
/*  980 */       nglPushDebugGroup(paramInt1, paramInt2, j, l); return;
/*      */     } finally {
/*  982 */       memoryStack.setPointer(i);
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
/*      */   public static void glObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1020 */     nglObjectLabel(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1033 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1035 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 1036 */       long l = memoryStack.getPointerAddress();
/* 1037 */       nglObjectLabel(paramInt1, paramInt2, j, l); return;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1063 */     if (Checks.CHECKS) {
/* 1064 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 1066 */     nglGetObjectLabel(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1080 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1082 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1083 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 1084 */       nglGetObjectLabel(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1085 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1087 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1101 */     return glGetObjectLabel(paramInt1, paramInt2, GL11.glGetInteger(33512));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1122 */     if (Checks.CHECKS) {
/* 1123 */       Checks.check(paramLong);
/*      */     }
/* 1125 */     nglObjectPtrLabel(paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/* 1137 */     if (Checks.CHECKS)
/* 1138 */       Checks.check(paramLong); 
/*      */     MemoryStack memoryStack;
/* 1140 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1142 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 1143 */       long l = memoryStack.getPointerAddress();
/* 1144 */       nglObjectPtrLabel(paramLong, j, l); return;
/*      */     } finally {
/* 1146 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1169 */     if (Checks.CHECKS) {
/* 1170 */       Checks.check(paramLong);
/* 1171 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     } 
/* 1173 */     nglGetObjectPtrLabel(paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/* 1186 */     if (Checks.CHECKS)
/* 1187 */       Checks.check(paramLong); 
/*      */     MemoryStack memoryStack;
/* 1189 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1191 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1192 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt);
/* 1193 */       nglGetObjectPtrLabel(paramLong, paramInt, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1194 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1196 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetObjectPtrLabel(@NativeType("void *") long paramLong) {
/* 1209 */     return glGetObjectPtrLabel(paramLong, GL11.glGetInteger(33512));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1240 */     if (Checks.CHECKS) {
/* 1241 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1243 */     nglGetFramebufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetFramebufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1256 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1258 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1259 */       nglGetFramebufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1260 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1262 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetInternalformati64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 1286 */     nglGetInternalformati64v(paramInt1, paramInt2, paramInt3, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1300 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1302 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 1303 */       nglGetInternalformati64v(paramInt1, paramInt2, paramInt3, 1, MemoryUtil.memAddress(longBuffer));
/* 1304 */       return longBuffer.get(0);
/*      */     } finally {
/* 1306 */       memoryStack.setPointer(i);
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
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 1382 */     nglInvalidateFramebuffer(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1393 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1395 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1396 */       nglInvalidateFramebuffer(paramInt1, 1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1398 */       memoryStack.setPointer(i);
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
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1424 */     nglInvalidateSubFramebuffer(paramInt1, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
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
/*      */     MemoryStack memoryStack;
/* 1439 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1441 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1442 */       nglInvalidateSubFramebuffer(paramInt1, 1, MemoryUtil.memAddress(intBuffer), paramInt3, paramInt4, paramInt5, paramInt6); return;
/*      */     } finally {
/* 1444 */       memoryStack.setPointer(i);
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
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 1486 */     if (Checks.CHECKS) {
/* 1487 */       Checks.check(paramByteBuffer, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3));
/*      */     }
/* 1489 */     nglMultiDrawArraysIndirect(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1525 */     nglMultiDrawArraysIndirect(paramInt1, paramLong, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1561 */     if (Checks.CHECKS) {
/* 1562 */       Checks.check(paramIntBuffer, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3) >> 2);
/*      */     }
/* 1564 */     nglMultiDrawArraysIndirect(paramInt1, MemoryUtil.memAddress(paramIntBuffer), paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1607 */     if (Checks.CHECKS) {
/* 1608 */       Checks.check(paramByteBuffer, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4));
/*      */     }
/* 1610 */     nglMultiDrawElementsIndirect(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1648 */     nglMultiDrawElementsIndirect(paramInt1, paramInt2, paramLong, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1686 */     if (Checks.CHECKS) {
/* 1687 */       Checks.check(paramIntBuffer, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4) >> 2);
/*      */     }
/* 1689 */     nglMultiDrawElementsIndirect(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer), paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1708 */     if (Checks.CHECKS) {
/* 1709 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1711 */     nglGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1725 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1727 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1728 */       nglGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1729 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1731 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("GLuint")
/*      */   public static int glGetProgramResourceIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1751 */     if (Checks.CHECKS) {
/* 1752 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1754 */     return nglGetProgramResourceIndex(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1768 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1770 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1771 */       long l = memoryStack.getPointerAddress();
/* 1772 */       paramInt1 = nglGetProgramResourceIndex(paramInt1, paramInt2, l); return paramInt1;
/*      */     } finally {
/* 1774 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1799 */     if (Checks.CHECKS) {
/* 1800 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 1802 */     nglGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
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
/*      */     MemoryStack memoryStack;
/* 1817 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1819 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1820 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt4);
/* 1821 */       nglGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1822 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1824 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1839 */     return glGetProgramResourceName(paramInt1, paramInt2, paramInt3, glGetProgramInterfacei(paramInt1, paramInt2, 37622));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1865 */     if (Checks.CHECKS) {
/* 1866 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     }
/* 1868 */     nglGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), paramIntBuffer3.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1887 */     if (Checks.CHECKS) {
/* 1888 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1890 */     return nglGetProgramResourceLocation(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1904 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1906 */       memoryStack.nASCII(paramCharSequence, true);
/* 1907 */       long l = memoryStack.getPointerAddress();
/* 1908 */       paramInt1 = nglGetProgramResourceLocation(paramInt1, paramInt2, l); return paramInt1;
/*      */     } finally {
/* 1910 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1930 */     if (Checks.CHECKS) {
/* 1931 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1933 */     return nglGetProgramResourceLocationIndex(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1947 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1949 */       memoryStack.nASCII(paramCharSequence, true);
/* 1950 */       long l = memoryStack.getPointerAddress();
/* 1951 */       paramInt1 = nglGetProgramResourceLocationIndex(paramInt1, paramInt2, l); return paramInt1;
/*      */     } finally {
/* 1953 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2126 */     long l = (GL.getICD()).glClearBufferData;
/* 2127 */     if (Checks.CHECKS) {
/* 2128 */       Checks.check(l);
/*      */     }
/* 2130 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 2139 */     long l = (GL.getICD()).glClearBufferData;
/* 2140 */     if (Checks.CHECKS) {
/* 2141 */       Checks.check(l);
/*      */     }
/* 2143 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2152 */     long l = (GL.getICD()).glClearBufferData;
/* 2153 */     if (Checks.CHECKS) {
/* 2154 */       Checks.check(l);
/*      */     }
/* 2156 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2165 */     long l = (GL.getICD()).glClearBufferSubData;
/* 2166 */     if (Checks.CHECKS) {
/* 2167 */       Checks.check(l);
/*      */     }
/* 2169 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 2178 */     long l = (GL.getICD()).glClearBufferSubData;
/* 2179 */     if (Checks.CHECKS) {
/* 2180 */       Checks.check(l);
/*      */     }
/* 2182 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2191 */     long l = (GL.getICD()).glClearBufferSubData;
/* 2192 */     if (Checks.CHECKS) {
/* 2193 */       Checks.check(l);
/*      */     }
/* 2195 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDebugMessageControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLboolean") boolean paramBoolean) {
/* 2204 */     long l = (GL.getICD()).glDebugMessageControl;
/* 2205 */     if (Checks.CHECKS) {
/* 2206 */       Checks.check(l);
/*      */     }
/* 2208 */     JNI.callPV(paramInt1, paramInt2, paramInt3, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, paramBoolean, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glGetDebugMessageLog(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3, @NativeType("GLenum *") int[] paramArrayOfint4, @NativeType("GLsizei *") int[] paramArrayOfint5, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2218 */     long l = (GL.getICD()).glGetDebugMessageLog;
/* 2219 */     if (Checks.CHECKS) {
/* 2220 */       Checks.check(l);
/* 2221 */       Checks.checkSafe(paramArrayOfint1, paramInt);
/* 2222 */       Checks.checkSafe(paramArrayOfint2, paramInt);
/* 2223 */       Checks.checkSafe(paramArrayOfint3, paramInt);
/* 2224 */       Checks.checkSafe(paramArrayOfint4, paramInt);
/* 2225 */       Checks.checkSafe(paramArrayOfint5, paramInt);
/*      */     } 
/* 2227 */     return JNI.callPPPPPPI(paramInt, Checks.remainingSafe(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramArrayOfint5, MemoryUtil.memAddressSafe(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2236 */     long l = (GL.getICD()).glGetObjectLabel;
/* 2237 */     if (Checks.CHECKS) {
/* 2238 */       Checks.check(l);
/* 2239 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2241 */     JNI.callPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2250 */     long l = (GL.getICD()).glGetObjectPtrLabel;
/* 2251 */     if (Checks.CHECKS) {
/* 2252 */       Checks.check(l);
/* 2253 */       Checks.check(paramLong);
/* 2254 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2256 */     JNI.callPPPV(paramLong, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2265 */     long l = (GL.getICD()).glGetFramebufferParameteriv;
/* 2266 */     if (Checks.CHECKS) {
/* 2267 */       Checks.check(l);
/* 2268 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2270 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetInternalformati64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 2279 */     long l = (GL.getICD()).glGetInternalformati64v;
/* 2280 */     if (Checks.CHECKS) {
/* 2281 */       Checks.check(l);
/*      */     }
/* 2283 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOflong.length, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 2292 */     long l = (GL.getICD()).glInvalidateFramebuffer;
/* 2293 */     if (Checks.CHECKS) {
/* 2294 */       Checks.check(l);
/*      */     }
/* 2296 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int[] paramArrayOfint, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 2305 */     long l = (GL.getICD()).glInvalidateSubFramebuffer;
/* 2306 */     if (Checks.CHECKS) {
/* 2307 */       Checks.check(l);
/*      */     }
/* 2309 */     JNI.callPV(paramInt1, paramArrayOfint.length, paramArrayOfint, paramInt2, paramInt3, paramInt4, paramInt5, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 2318 */     long l = (GL.getICD()).glMultiDrawArraysIndirect;
/* 2319 */     if (Checks.CHECKS) {
/* 2320 */       Checks.check(l);
/* 2321 */       Checks.check(paramArrayOfint, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3) >> 2);
/*      */     } 
/* 2323 */     JNI.callPV(paramInt1, paramArrayOfint, paramInt2, paramInt3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 2332 */     long l = (GL.getICD()).glMultiDrawElementsIndirect;
/* 2333 */     if (Checks.CHECKS) {
/* 2334 */       Checks.check(l);
/* 2335 */       Checks.check(paramArrayOfint, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4) >> 2);
/*      */     } 
/* 2337 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, paramInt3, paramInt4, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramInterfaceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2346 */     long l = (GL.getICD()).glGetProgramInterfaceiv;
/* 2347 */     if (Checks.CHECKS) {
/* 2348 */       Checks.check(l);
/* 2349 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2351 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2360 */     long l = (GL.getICD()).glGetProgramResourceName;
/* 2361 */     if (Checks.CHECKS) {
/* 2362 */       Checks.check(l);
/* 2363 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2365 */     JNI.callPPV(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramResourceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum const *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLint *") int[] paramArrayOfint3) {
/* 2374 */     long l = (GL.getICD()).glGetProgramResourceiv;
/* 2375 */     if (Checks.CHECKS) {
/* 2376 */       Checks.check(l);
/* 2377 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 2379 */     JNI.callPPPV(paramInt1, paramInt2, paramInt3, paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint3.length, paramArrayOfint2, paramArrayOfint3, l);
/*      */   }
/*      */   
/*      */   public static native void nglClearBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglClearBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native void glDispatchCompute(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glDispatchComputeIndirect(@NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glCopyImageSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLsizei") int paramInt13, @NativeType("GLsizei") int paramInt14, @NativeType("GLsizei") int paramInt15);
/*      */   
/*      */   public static native void nglDebugMessageControl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean);
/*      */   
/*      */   public static native void nglDebugMessageInsert(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglDebugMessageCallback(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nglGetDebugMessageLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*      */   
/*      */   public static native void nglPushDebugGroup(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glPopDebugGroup();
/*      */   
/*      */   public static native void nglObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglObjectPtrLabel(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nglGetObjectPtrLabel(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glFramebufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglGetFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetInternalformati64v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glInvalidateTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8);
/*      */   
/*      */   public static native void glInvalidateTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glInvalidateBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glInvalidateBufferData(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglInvalidateFramebuffer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglInvalidateSubFramebuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
/*      */   
/*      */   public static native void nglMultiDrawArraysIndirect(int paramInt1, long paramLong, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nglMultiDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nglGetProgramInterfaceiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native int nglGetProgramResourceIndex(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramResourceName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetProgramResourceiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nglGetProgramResourceLocation(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native int nglGetProgramResourceLocationIndex(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glShaderStorageBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glTexBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glTexStorage2DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glTexStorage3DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glTextureView(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint") int paramInt8);
/*      */   
/*      */   public static native void glBindVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glVertexAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL43C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */