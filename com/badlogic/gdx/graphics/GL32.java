package com.badlogic.gdx.graphics;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface GL32 extends GL31 {
  public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
  
  public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 4;
  
  public static final int GL_GEOMETRY_SHADER_BIT = 4;
  
  public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
  
  public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
  
  public static final int GL_QUADS = 7;
  
  public static final int GL_LINES_ADJACENCY = 10;
  
  public static final int GL_LINE_STRIP_ADJACENCY = 11;
  
  public static final int GL_TRIANGLES_ADJACENCY = 12;
  
  public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13;
  
  public static final int GL_PATCHES = 14;
  
  public static final int GL_STACK_OVERFLOW = 1283;
  
  public static final int GL_STACK_UNDERFLOW = 1284;
  
  public static final int GL_CONTEXT_LOST = 1287;
  
  public static final int GL_TEXTURE_BORDER_COLOR = 4100;
  
  public static final int GL_VERTEX_ARRAY = 32884;
  
  public static final int GL_CLAMP_TO_BORDER = 33069;
  
  public static final int GL_CONTEXT_FLAGS = 33310;
  
  public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313;
  
  public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
  
  public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
  
  public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
  
  public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
  
  public static final int GL_DEBUG_SOURCE_API = 33350;
  
  public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
  
  public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
  
  public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
  
  public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
  
  public static final int GL_DEBUG_SOURCE_OTHER = 33355;
  
  public static final int GL_DEBUG_TYPE_ERROR = 33356;
  
  public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
  
  public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
  
  public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
  
  public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
  
  public static final int GL_DEBUG_TYPE_OTHER = 33361;
  
  public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
  
  public static final int GL_GUILTY_CONTEXT_RESET = 33363;
  
  public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
  
  public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
  
  public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
  
  public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
  
  public static final int GL_UNDEFINED_VERTEX = 33376;
  
  public static final int GL_NO_RESET_NOTIFICATION = 33377;
  
  public static final int GL_DEBUG_TYPE_MARKER = 33384;
  
  public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
  
  public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
  
  public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
  
  public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
  
  public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
  
  public static final int GL_BUFFER = 33504;
  
  public static final int GL_SHADER = 33505;
  
  public static final int GL_PROGRAM = 33506;
  
  public static final int GL_QUERY = 33507;
  
  public static final int GL_PROGRAM_PIPELINE = 33508;
  
  public static final int GL_SAMPLER = 33510;
  
  public static final int GL_MAX_LABEL_LENGTH = 33512;
  
  public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
  
  public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
  
  public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
  
  public static final int GL_GEOMETRY_VERTICES_OUT = 35094;
  
  public static final int GL_GEOMETRY_INPUT_TYPE = 35095;
  
  public static final int GL_GEOMETRY_OUTPUT_TYPE = 35096;
  
  public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
  
  public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
  
  public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881;
  
  public static final int GL_TEXTURE_BUFFER = 35882;
  
  public static final int GL_TEXTURE_BUFFER_BINDING = 35882;
  
  public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
  
  public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
  
  public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
  
  public static final int GL_SAMPLE_SHADING = 35894;
  
  public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
  
  public static final int GL_PRIMITIVES_GENERATED = 35975;
  
  public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263;
  
  public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264;
  
  public static final int GL_SAMPLER_BUFFER = 36290;
  
  public static final int GL_INT_SAMPLER_BUFFER = 36304;
  
  public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
  
  public static final int GL_GEOMETRY_SHADER = 36313;
  
  public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319;
  
  public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320;
  
  public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321;
  
  public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
  
  public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
  
  public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
  
  public static final int GL_LAST_VERTEX_CONVENTION = 36430;
  
  public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
  
  public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
  
  public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
  
  public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
  
  public static final int GL_PATCH_VERTICES = 36466;
  
  public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
  
  public static final int GL_TESS_GEN_MODE = 36470;
  
  public static final int GL_TESS_GEN_SPACING = 36471;
  
  public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
  
  public static final int GL_TESS_GEN_POINT_MODE = 36473;
  
  public static final int GL_ISOLINES = 36474;
  
  public static final int GL_FRACTIONAL_ODD = 36475;
  
  public static final int GL_FRACTIONAL_EVEN = 36476;
  
  public static final int GL_MAX_PATCH_VERTICES = 36477;
  
  public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
  
  public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
  
  public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
  
  public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
  
  public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
  
  public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
  
  public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
  
  public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
  
  public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
  
  public static final int GL_TESS_EVALUATION_SHADER = 36487;
  
  public static final int GL_TESS_CONTROL_SHADER = 36488;
  
  public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
  
  public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
  
  public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
  
  public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
  
  public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
  
  public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
  
  public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
  
  public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;
  
  public static final int GL_IMAGE_BUFFER = 36945;
  
  public static final int GL_IMAGE_CUBE_MAP_ARRAY = 36948;
  
  public static final int GL_INT_IMAGE_BUFFER = 36956;
  
  public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY = 36959;
  
  public static final int GL_UNSIGNED_INT_IMAGE_BUFFER = 36967;
  
  public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY = 36970;
  
  public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS = 37067;
  
  public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS = 37068;
  
  public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS = 37069;
  
  public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079;
  
  public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080;
  
  public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081;
  
  public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
  
  public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
  
  public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
  
  public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
  
  public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;
  
  public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155;
  
  public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156;
  
  public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
  
  public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
  
  public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
  
  public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
  
  public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
  
  public static final int GL_DEBUG_SEVERITY_LOW = 37192;
  
  public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
  
  public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
  
  public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
  
  public static final int GL_MULTIPLY = 37524;
  
  public static final int GL_SCREEN = 37525;
  
  public static final int GL_OVERLAY = 37526;
  
  public static final int GL_DARKEN = 37527;
  
  public static final int GL_LIGHTEN = 37528;
  
  public static final int GL_COLORDODGE = 37529;
  
  public static final int GL_COLORBURN = 37530;
  
  public static final int GL_HARDLIGHT = 37531;
  
  public static final int GL_SOFTLIGHT = 37532;
  
  public static final int GL_DIFFERENCE = 37534;
  
  public static final int GL_EXCLUSION = 37536;
  
  public static final int GL_HSL_HUE = 37549;
  
  public static final int GL_HSL_SATURATION = 37550;
  
  public static final int GL_HSL_COLOR = 37551;
  
  public static final int GL_HSL_LUMINOSITY = 37552;
  
  public static final int GL_PRIMITIVE_BOUNDING_BOX = 37566;
  
  public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 37581;
  
  public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 37582;
  
  public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 37583;
  
  public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 37587;
  
  public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 37588;
  
  public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 37589;
  
  public static final int GL_DEBUG_OUTPUT = 37600;
  
  public static final int GL_IS_PER_PATCH = 37607;
  
  public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
  
  public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
  
  public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
  
  public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
  
  public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
  
  public static final int GL_MULTISAMPLE_LINE_WIDTH_RANGE = 37761;
  
  public static final int GL_MULTISAMPLE_LINE_WIDTH_GRANULARITY = 37762;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_4x4 = 37808;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_5x4 = 37809;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_5x5 = 37810;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_6x5 = 37811;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_6x6 = 37812;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_8x5 = 37813;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_8x6 = 37814;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_8x8 = 37815;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_10x5 = 37816;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_10x6 = 37817;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_10x8 = 37818;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_10x10 = 37819;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_12x10 = 37820;
  
  public static final int GL_COMPRESSED_RGBA_ASTC_12x12 = 37821;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_4x4 = 37840;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x4 = 37841;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x5 = 37842;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x5 = 37843;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x6 = 37844;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x5 = 37845;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x6 = 37846;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x8 = 37847;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x5 = 37848;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x6 = 37849;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x8 = 37850;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x10 = 37851;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x10 = 37852;
  
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x12 = 37853;
  
  void glBlendBarrier();
  
  void glCopyImageSubData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15);
  
  void glDebugMessageControl(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, boolean paramBoolean);
  
  void glDebugMessageInsert(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString);
  
  void glDebugMessageCallback(DebugProc paramDebugProc);
  
  int glGetDebugMessageLog(int paramInt, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3, IntBuffer paramIntBuffer4, IntBuffer paramIntBuffer5, ByteBuffer paramByteBuffer);
  
  void glPushDebugGroup(int paramInt1, int paramInt2, String paramString);
  
  void glPopDebugGroup();
  
  void glObjectLabel(int paramInt1, int paramInt2, String paramString);
  
  String glGetObjectLabel(int paramInt1, int paramInt2);
  
  long glGetPointerv(int paramInt);
  
  void glEnablei(int paramInt1, int paramInt2);
  
  void glDisablei(int paramInt1, int paramInt2);
  
  void glBlendEquationi(int paramInt1, int paramInt2);
  
  void glBlendEquationSeparatei(int paramInt1, int paramInt2, int paramInt3);
  
  void glBlendFunci(int paramInt1, int paramInt2, int paramInt3);
  
  void glBlendFuncSeparatei(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void glColorMaski(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  boolean glIsEnabledi(int paramInt1, int paramInt2);
  
  void glDrawElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer, int paramInt4);
  
  void glDrawRangeElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Buffer paramBuffer, int paramInt6);
  
  void glDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer, int paramInt4, int paramInt5);
  
  void glDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  void glFramebufferTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  int glGetGraphicsResetStatus();
  
  void glReadnPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer);
  
  void glGetnUniformfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer);
  
  void glGetnUniformiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glGetnUniformuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glMinSampleShading(float paramFloat);
  
  void glPatchParameteri(int paramInt1, int paramInt2);
  
  void glTexParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glTexParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glGetTexParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glGetTexParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glSamplerParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glSamplerParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glGetSamplerParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glGetSamplerParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  void glTexBuffer(int paramInt1, int paramInt2, int paramInt3);
  
  void glTexBufferRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void glTexStorage3DMultisample(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);
  
  public static interface DebugProc {
    void onMessage(int param1Int1, int param1Int2, int param1Int3, int param1Int4, String param1String);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\GL32.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */