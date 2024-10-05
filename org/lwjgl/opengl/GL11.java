/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL11
/*      */ {
/*      */   public static final int GL_ACCUM = 256;
/*      */   public static final int GL_LOAD = 257;
/*      */   public static final int GL_RETURN = 258;
/*      */   public static final int GL_MULT = 259;
/*      */   public static final int GL_ADD = 260;
/*      */   public static final int GL_NEVER = 512;
/*      */   public static final int GL_LESS = 513;
/*      */   public static final int GL_EQUAL = 514;
/*      */   public static final int GL_LEQUAL = 515;
/*      */   public static final int GL_GREATER = 516;
/*      */   public static final int GL_NOTEQUAL = 517;
/*      */   public static final int GL_GEQUAL = 518;
/*      */   public static final int GL_ALWAYS = 519;
/*      */   public static final int GL_CURRENT_BIT = 1;
/*      */   public static final int GL_POINT_BIT = 2;
/*      */   public static final int GL_LINE_BIT = 4;
/*      */   
/*      */   static {
/*   38 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_POLYGON_BIT = 8;
/*      */   
/*      */   public static final int GL_POLYGON_STIPPLE_BIT = 16;
/*      */   
/*      */   public static final int GL_PIXEL_MODE_BIT = 32;
/*      */   
/*      */   public static final int GL_LIGHTING_BIT = 64;
/*      */   
/*      */   public static final int GL_FOG_BIT = 128;
/*      */   
/*      */   public static final int GL_DEPTH_BUFFER_BIT = 256;
/*      */   
/*      */   public static final int GL_ACCUM_BUFFER_BIT = 512;
/*      */   
/*      */   public static final int GL_STENCIL_BUFFER_BIT = 1024;
/*      */   
/*      */   public static final int GL_VIEWPORT_BIT = 2048;
/*      */   
/*      */   public static final int GL_TRANSFORM_BIT = 4096;
/*      */   
/*      */   public static final int GL_ENABLE_BIT = 8192;
/*      */   
/*      */   public static final int GL_COLOR_BUFFER_BIT = 16384;
/*      */   
/*      */   public static final int GL_HINT_BIT = 32768;
/*      */   
/*      */   public static final int GL_EVAL_BIT = 65536;
/*      */   
/*      */   public static final int GL_LIST_BIT = 131072;
/*      */   
/*      */   public static final int GL_TEXTURE_BIT = 262144;
/*      */   
/*      */   public static final int GL_SCISSOR_BIT = 524288;
/*      */   
/*      */   public static final int GL_ALL_ATTRIB_BITS = 1048575;
/*      */   
/*      */   public static final int GL_POINTS = 0;
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
/*      */   public static final int GL_QUAD_STRIP = 8;
/*      */   
/*      */   public static final int GL_POLYGON = 9;
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
/*      */   public static final int GL_CLIP_PLANE0 = 12288;
/*      */   
/*      */   public static final int GL_CLIP_PLANE1 = 12289;
/*      */   
/*      */   public static final int GL_CLIP_PLANE2 = 12290;
/*      */   
/*      */   public static final int GL_CLIP_PLANE3 = 12291;
/*      */   
/*      */   public static final int GL_CLIP_PLANE4 = 12292;
/*      */   
/*      */   public static final int GL_CLIP_PLANE5 = 12293;
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
/*      */   public static final int GL_2_BYTES = 5127;
/*      */   
/*      */   public static final int GL_3_BYTES = 5128;
/*      */   
/*      */   public static final int GL_4_BYTES = 5129;
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
/*      */   public static final int GL_AUX0 = 1033;
/*      */   
/*      */   public static final int GL_AUX1 = 1034;
/*      */   
/*      */   public static final int GL_AUX2 = 1035;
/*      */   
/*      */   public static final int GL_AUX3 = 1036;
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
/*      */   public static final int GL_2D = 1536;
/*      */   
/*      */   public static final int GL_3D = 1537;
/*      */   
/*      */   public static final int GL_3D_COLOR = 1538;
/*      */   
/*      */   public static final int GL_3D_COLOR_TEXTURE = 1539;
/*      */   
/*      */   public static final int GL_4D_COLOR_TEXTURE = 1540;
/*      */   
/*      */   public static final int GL_PASS_THROUGH_TOKEN = 1792;
/*      */   
/*      */   public static final int GL_POINT_TOKEN = 1793;
/*      */   
/*      */   public static final int GL_LINE_TOKEN = 1794;
/*      */   
/*      */   public static final int GL_POLYGON_TOKEN = 1795;
/*      */   
/*      */   public static final int GL_BITMAP_TOKEN = 1796;
/*      */   
/*      */   public static final int GL_DRAW_PIXEL_TOKEN = 1797;
/*      */   
/*      */   public static final int GL_COPY_PIXEL_TOKEN = 1798;
/*      */   
/*      */   public static final int GL_LINE_RESET_TOKEN = 1799;
/*      */   
/*      */   public static final int GL_EXP = 2048;
/*      */   
/*      */   public static final int GL_EXP2 = 2049;
/*      */   
/*      */   public static final int GL_CW = 2304;
/*      */   
/*      */   public static final int GL_CCW = 2305;
/*      */   
/*      */   public static final int GL_COEFF = 2560;
/*      */   
/*      */   public static final int GL_ORDER = 2561;
/*      */   
/*      */   public static final int GL_DOMAIN = 2562;
/*      */   
/*      */   public static final int GL_CURRENT_COLOR = 2816;
/*      */   
/*      */   public static final int GL_CURRENT_INDEX = 2817;
/*      */   
/*      */   public static final int GL_CURRENT_NORMAL = 2818;
/*      */   
/*      */   public static final int GL_CURRENT_TEXTURE_COORDS = 2819;
/*      */   
/*      */   public static final int GL_CURRENT_RASTER_COLOR = 2820;
/*      */   
/*      */   public static final int GL_CURRENT_RASTER_INDEX = 2821;
/*      */   
/*      */   public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 2822;
/*      */   
/*      */   public static final int GL_CURRENT_RASTER_POSITION = 2823;
/*      */   
/*      */   public static final int GL_CURRENT_RASTER_POSITION_VALID = 2824;
/*      */   
/*      */   public static final int GL_CURRENT_RASTER_DISTANCE = 2825;
/*      */   
/*      */   public static final int GL_POINT_SMOOTH = 2832;
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
/*      */   public static final int GL_LINE_STIPPLE = 2852;
/*      */   
/*      */   public static final int GL_LINE_STIPPLE_PATTERN = 2853;
/*      */   
/*      */   public static final int GL_LINE_STIPPLE_REPEAT = 2854;
/*      */   
/*      */   public static final int GL_LIST_MODE = 2864;
/*      */   
/*      */   public static final int GL_MAX_LIST_NESTING = 2865;
/*      */   
/*      */   public static final int GL_LIST_BASE = 2866;
/*      */   
/*      */   public static final int GL_LIST_INDEX = 2867;
/*      */   
/*      */   public static final int GL_POLYGON_MODE = 2880;
/*      */   
/*      */   public static final int GL_POLYGON_SMOOTH = 2881;
/*      */   
/*      */   public static final int GL_POLYGON_STIPPLE = 2882;
/*      */   
/*      */   public static final int GL_EDGE_FLAG = 2883;
/*      */   
/*      */   public static final int GL_CULL_FACE = 2884;
/*      */   
/*      */   public static final int GL_CULL_FACE_MODE = 2885;
/*      */   
/*      */   public static final int GL_FRONT_FACE = 2886;
/*      */   
/*      */   public static final int GL_LIGHTING = 2896;
/*      */   
/*      */   public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 2897;
/*      */   
/*      */   public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898;
/*      */   
/*      */   public static final int GL_LIGHT_MODEL_AMBIENT = 2899;
/*      */   
/*      */   public static final int GL_SHADE_MODEL = 2900;
/*      */   
/*      */   public static final int GL_COLOR_MATERIAL_FACE = 2901;
/*      */   
/*      */   public static final int GL_COLOR_MATERIAL_PARAMETER = 2902;
/*      */   
/*      */   public static final int GL_COLOR_MATERIAL = 2903;
/*      */   
/*      */   public static final int GL_FOG = 2912;
/*      */   
/*      */   public static final int GL_FOG_INDEX = 2913;
/*      */   
/*      */   public static final int GL_FOG_DENSITY = 2914;
/*      */   
/*      */   public static final int GL_FOG_START = 2915;
/*      */   
/*      */   public static final int GL_FOG_END = 2916;
/*      */   
/*      */   public static final int GL_FOG_MODE = 2917;
/*      */   
/*      */   public static final int GL_FOG_COLOR = 2918;
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
/*      */   public static final int GL_ACCUM_CLEAR_VALUE = 2944;
/*      */   
/*      */   public static final int GL_STENCIL_TEST = 2960;
/*      */   
/*      */   public static final int GL_STENCIL_CLEAR_VALUE = 2961;
/*      */   
/*      */   public static final int GL_STENCIL_FUNC = 2962;
/*      */   
/*      */   public static final int GL_STENCIL_VALUE_MASK = 2963;
/*      */   public static final int GL_STENCIL_FAIL = 2964;
/*      */   public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
/*      */   public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
/*      */   public static final int GL_STENCIL_REF = 2967;
/*      */   public static final int GL_STENCIL_WRITEMASK = 2968;
/*      */   public static final int GL_MATRIX_MODE = 2976;
/*      */   public static final int GL_NORMALIZE = 2977;
/*      */   public static final int GL_VIEWPORT = 2978;
/*      */   public static final int GL_MODELVIEW_STACK_DEPTH = 2979;
/*      */   public static final int GL_PROJECTION_STACK_DEPTH = 2980;
/*      */   public static final int GL_TEXTURE_STACK_DEPTH = 2981;
/*      */   public static final int GL_MODELVIEW_MATRIX = 2982;
/*      */   public static final int GL_PROJECTION_MATRIX = 2983;
/*      */   public static final int GL_TEXTURE_MATRIX = 2984;
/*      */   public static final int GL_ATTRIB_STACK_DEPTH = 2992;
/*      */   public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 2993;
/*      */   public static final int GL_ALPHA_TEST = 3008;
/*      */   public static final int GL_ALPHA_TEST_FUNC = 3009;
/*      */   public static final int GL_ALPHA_TEST_REF = 3010;
/*      */   public static final int GL_DITHER = 3024;
/*      */   public static final int GL_BLEND_DST = 3040;
/*      */   public static final int GL_BLEND_SRC = 3041;
/*      */   public static final int GL_BLEND = 3042;
/*      */   public static final int GL_LOGIC_OP_MODE = 3056;
/*      */   public static final int GL_INDEX_LOGIC_OP = 3057;
/*      */   public static final int GL_LOGIC_OP = 3057;
/*      */   public static final int GL_COLOR_LOGIC_OP = 3058;
/*      */   public static final int GL_AUX_BUFFERS = 3072;
/*      */   public static final int GL_DRAW_BUFFER = 3073;
/*      */   public static final int GL_READ_BUFFER = 3074;
/*      */   public static final int GL_SCISSOR_BOX = 3088;
/*      */   public static final int GL_SCISSOR_TEST = 3089;
/*      */   public static final int GL_INDEX_CLEAR_VALUE = 3104;
/*      */   public static final int GL_INDEX_WRITEMASK = 3105;
/*      */   public static final int GL_COLOR_CLEAR_VALUE = 3106;
/*      */   public static final int GL_COLOR_WRITEMASK = 3107;
/*      */   public static final int GL_INDEX_MODE = 3120;
/*      */   public static final int GL_RGBA_MODE = 3121;
/*      */   public static final int GL_DOUBLEBUFFER = 3122;
/*      */   public static final int GL_STEREO = 3123;
/*      */   public static final int GL_RENDER_MODE = 3136;
/*      */   public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152;
/*      */   public static final int GL_POINT_SMOOTH_HINT = 3153;
/*      */   public static final int GL_LINE_SMOOTH_HINT = 3154;
/*      */   public static final int GL_POLYGON_SMOOTH_HINT = 3155;
/*      */   public static final int GL_FOG_HINT = 3156;
/*      */   public static final int GL_TEXTURE_GEN_S = 3168;
/*      */   public static final int GL_TEXTURE_GEN_T = 3169;
/*      */   public static final int GL_TEXTURE_GEN_R = 3170;
/*      */   public static final int GL_TEXTURE_GEN_Q = 3171;
/*      */   public static final int GL_PIXEL_MAP_I_TO_I = 3184;
/*      */   public static final int GL_PIXEL_MAP_S_TO_S = 3185;
/*      */   public static final int GL_PIXEL_MAP_I_TO_R = 3186;
/*      */   public static final int GL_PIXEL_MAP_I_TO_G = 3187;
/*      */   public static final int GL_PIXEL_MAP_I_TO_B = 3188;
/*      */   public static final int GL_PIXEL_MAP_I_TO_A = 3189;
/*      */   public static final int GL_PIXEL_MAP_R_TO_R = 3190;
/*      */   public static final int GL_PIXEL_MAP_G_TO_G = 3191;
/*      */   public static final int GL_PIXEL_MAP_B_TO_B = 3192;
/*      */   public static final int GL_PIXEL_MAP_A_TO_A = 3193;
/*      */   public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 3248;
/*      */   public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 3249;
/*      */   public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 3250;
/*      */   public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 3251;
/*      */   public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 3252;
/*      */   public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 3253;
/*      */   public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 3254;
/*      */   public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 3255;
/*      */   public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 3256;
/*      */   public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 3257;
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
/*      */   public static final int GL_MAP_COLOR = 3344;
/*      */   public static final int GL_MAP_STENCIL = 3345;
/*      */   public static final int GL_INDEX_SHIFT = 3346;
/*      */   public static final int GL_INDEX_OFFSET = 3347;
/*      */   public static final int GL_RED_SCALE = 3348;
/*      */   public static final int GL_RED_BIAS = 3349;
/*      */   public static final int GL_ZOOM_X = 3350;
/*      */   public static final int GL_ZOOM_Y = 3351;
/*      */   public static final int GL_GREEN_SCALE = 3352;
/*      */   public static final int GL_GREEN_BIAS = 3353;
/*      */   public static final int GL_BLUE_SCALE = 3354;
/*      */   public static final int GL_BLUE_BIAS = 3355;
/*      */   public static final int GL_ALPHA_SCALE = 3356;
/*      */   public static final int GL_ALPHA_BIAS = 3357;
/*      */   public static final int GL_DEPTH_SCALE = 3358;
/*      */   public static final int GL_DEPTH_BIAS = 3359;
/*      */   public static final int GL_MAX_EVAL_ORDER = 3376;
/*      */   public static final int GL_MAX_LIGHTS = 3377;
/*      */   public static final int GL_MAX_CLIP_PLANES = 3378;
/*      */   public static final int GL_MAX_TEXTURE_SIZE = 3379;
/*      */   public static final int GL_MAX_PIXEL_MAP_TABLE = 3380;
/*      */   public static final int GL_MAX_ATTRIB_STACK_DEPTH = 3381;
/*      */   public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382;
/*      */   public static final int GL_MAX_NAME_STACK_DEPTH = 3383;
/*      */   public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384;
/*      */   public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385;
/*      */   public static final int GL_MAX_VIEWPORT_DIMS = 3386;
/*      */   public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 3387;
/*      */   public static final int GL_SUBPIXEL_BITS = 3408;
/*      */   public static final int GL_INDEX_BITS = 3409;
/*      */   public static final int GL_RED_BITS = 3410;
/*      */   public static final int GL_GREEN_BITS = 3411;
/*      */   public static final int GL_BLUE_BITS = 3412;
/*      */   public static final int GL_ALPHA_BITS = 3413;
/*      */   public static final int GL_DEPTH_BITS = 3414;
/*      */   public static final int GL_STENCIL_BITS = 3415;
/*      */   public static final int GL_ACCUM_RED_BITS = 3416;
/*      */   public static final int GL_ACCUM_GREEN_BITS = 3417;
/*      */   public static final int GL_ACCUM_BLUE_BITS = 3418;
/*      */   public static final int GL_ACCUM_ALPHA_BITS = 3419;
/*      */   public static final int GL_NAME_STACK_DEPTH = 3440;
/*      */   public static final int GL_AUTO_NORMAL = 3456;
/*      */   public static final int GL_MAP1_COLOR_4 = 3472;
/*      */   public static final int GL_MAP1_INDEX = 3473;
/*      */   public static final int GL_MAP1_NORMAL = 3474;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_1 = 3475;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_2 = 3476;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_3 = 3477;
/*      */   public static final int GL_MAP1_TEXTURE_COORD_4 = 3478;
/*      */   public static final int GL_MAP1_VERTEX_3 = 3479;
/*      */   public static final int GL_MAP1_VERTEX_4 = 3480;
/*      */   public static final int GL_MAP2_COLOR_4 = 3504;
/*      */   public static final int GL_MAP2_INDEX = 3505;
/*      */   public static final int GL_MAP2_NORMAL = 3506;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_1 = 3507;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_2 = 3508;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_3 = 3509;
/*      */   public static final int GL_MAP2_TEXTURE_COORD_4 = 3510;
/*      */   public static final int GL_MAP2_VERTEX_3 = 3511;
/*      */   public static final int GL_MAP2_VERTEX_4 = 3512;
/*      */   public static final int GL_MAP1_GRID_DOMAIN = 3536;
/*      */   public static final int GL_MAP1_GRID_SEGMENTS = 3537;
/*      */   public static final int GL_MAP2_GRID_DOMAIN = 3538;
/*      */   public static final int GL_MAP2_GRID_SEGMENTS = 3539;
/*      */   public static final int GL_TEXTURE_1D = 3552;
/*      */   public static final int GL_TEXTURE_2D = 3553;
/*      */   public static final int GL_FEEDBACK_BUFFER_POINTER = 3568;
/*      */   public static final int GL_FEEDBACK_BUFFER_SIZE = 3569;
/*      */   public static final int GL_FEEDBACK_BUFFER_TYPE = 3570;
/*      */   public static final int GL_SELECTION_BUFFER_POINTER = 3571;
/*      */   public static final int GL_SELECTION_BUFFER_SIZE = 3572;
/*      */   public static final int GL_TEXTURE_WIDTH = 4096;
/*      */   public static final int GL_TEXTURE_HEIGHT = 4097;
/*      */   public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;
/*      */   public static final int GL_TEXTURE_COMPONENTS = 4099;
/*      */   public static final int GL_TEXTURE_BORDER_COLOR = 4100;
/*      */   public static final int GL_TEXTURE_BORDER = 4101;
/*      */   public static final int GL_DONT_CARE = 4352;
/*      */   public static final int GL_FASTEST = 4353;
/*      */   public static final int GL_NICEST = 4354;
/*      */   public static final int GL_LIGHT0 = 16384;
/*      */   public static final int GL_LIGHT1 = 16385;
/*      */   public static final int GL_LIGHT2 = 16386;
/*      */   public static final int GL_LIGHT3 = 16387;
/*      */   public static final int GL_LIGHT4 = 16388;
/*      */   public static final int GL_LIGHT5 = 16389;
/*      */   public static final int GL_LIGHT6 = 16390;
/*      */   public static final int GL_LIGHT7 = 16391;
/*      */   public static final int GL_AMBIENT = 4608;
/*      */   public static final int GL_DIFFUSE = 4609;
/*      */   public static final int GL_SPECULAR = 4610;
/*      */   public static final int GL_POSITION = 4611;
/*      */   public static final int GL_SPOT_DIRECTION = 4612;
/*      */   public static final int GL_SPOT_EXPONENT = 4613;
/*      */   public static final int GL_SPOT_CUTOFF = 4614;
/*      */   public static final int GL_CONSTANT_ATTENUATION = 4615;
/*      */   public static final int GL_LINEAR_ATTENUATION = 4616;
/*      */   public static final int GL_QUADRATIC_ATTENUATION = 4617;
/*      */   public static final int GL_COMPILE = 4864;
/*      */   public static final int GL_COMPILE_AND_EXECUTE = 4865;
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
/*      */   public static final int GL_EMISSION = 5632;
/*      */   public static final int GL_SHININESS = 5633;
/*      */   public static final int GL_AMBIENT_AND_DIFFUSE = 5634;
/*      */   public static final int GL_COLOR_INDEXES = 5635;
/*      */   public static final int GL_MODELVIEW = 5888;
/*      */   public static final int GL_PROJECTION = 5889;
/*      */   public static final int GL_TEXTURE = 5890;
/*      */   public static final int GL_COLOR = 6144;
/*      */   public static final int GL_DEPTH = 6145;
/*      */   public static final int GL_STENCIL = 6146;
/*      */   public static final int GL_COLOR_INDEX = 6400;
/*      */   public static final int GL_STENCIL_INDEX = 6401;
/*      */   public static final int GL_DEPTH_COMPONENT = 6402;
/*      */   public static final int GL_RED = 6403;
/*      */   public static final int GL_GREEN = 6404;
/*      */   public static final int GL_BLUE = 6405;
/*      */   public static final int GL_ALPHA = 6406;
/*      */   public static final int GL_RGB = 6407;
/*      */   public static final int GL_RGBA = 6408;
/*      */   public static final int GL_LUMINANCE = 6409;
/*      */   public static final int GL_LUMINANCE_ALPHA = 6410;
/*      */   public static final int GL_BITMAP = 6656;
/*      */   public static final int GL_POINT = 6912;
/*      */   public static final int GL_LINE = 6913;
/*      */   public static final int GL_FILL = 6914;
/*      */   public static final int GL_RENDER = 7168;
/*      */   public static final int GL_FEEDBACK = 7169;
/*      */   public static final int GL_SELECT = 7170;
/*      */   public static final int GL_FLAT = 7424;
/*      */   public static final int GL_SMOOTH = 7425;
/*      */   public static final int GL_KEEP = 7680;
/*      */   public static final int GL_REPLACE = 7681;
/*      */   public static final int GL_INCR = 7682;
/*      */   public static final int GL_DECR = 7683;
/*      */   public static final int GL_VENDOR = 7936;
/*      */   public static final int GL_RENDERER = 7937;
/*      */   public static final int GL_VERSION = 7938;
/*      */   public static final int GL_EXTENSIONS = 7939;
/*      */   public static final int GL_S = 8192;
/*      */   public static final int GL_T = 8193;
/*      */   public static final int GL_R = 8194;
/*      */   public static final int GL_Q = 8195;
/*      */   public static final int GL_MODULATE = 8448;
/*      */   public static final int GL_DECAL = 8449;
/*      */   public static final int GL_TEXTURE_ENV_MODE = 8704;
/*      */   public static final int GL_TEXTURE_ENV_COLOR = 8705;
/*      */   public static final int GL_TEXTURE_ENV = 8960;
/*      */   public static final int GL_EYE_LINEAR = 9216;
/*      */   public static final int GL_OBJECT_LINEAR = 9217;
/*      */   public static final int GL_SPHERE_MAP = 9218;
/*      */   public static final int GL_TEXTURE_GEN_MODE = 9472;
/*      */   public static final int GL_OBJECT_PLANE = 9473;
/*      */   public static final int GL_EYE_PLANE = 9474;
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
/*      */   public static final int GL_CLAMP = 10496;
/*      */   public static final int GL_REPEAT = 10497;
/*      */   public static final int GL_CLIENT_PIXEL_STORE_BIT = 1;
/*      */   public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 2;
/*      */   public static final int GL_CLIENT_ALL_ATTRIB_BITS = -1;
/*      */   public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
/*      */   public static final int GL_POLYGON_OFFSET_UNITS = 10752;
/*      */   public static final int GL_POLYGON_OFFSET_POINT = 10753;
/*      */   public static final int GL_POLYGON_OFFSET_LINE = 10754;
/*      */   public static final int GL_POLYGON_OFFSET_FILL = 32823;
/*      */   public static final int GL_ALPHA4 = 32827;
/*      */   public static final int GL_ALPHA8 = 32828;
/*      */   public static final int GL_ALPHA12 = 32829;
/*      */   public static final int GL_ALPHA16 = 32830;
/*      */   public static final int GL_LUMINANCE4 = 32831;
/*      */   public static final int GL_LUMINANCE8 = 32832;
/*      */   public static final int GL_LUMINANCE12 = 32833;
/*      */   public static final int GL_LUMINANCE16 = 32834;
/*      */   public static final int GL_LUMINANCE4_ALPHA4 = 32835;
/*      */   public static final int GL_LUMINANCE6_ALPHA2 = 32836;
/*      */   public static final int GL_LUMINANCE8_ALPHA8 = 32837;
/*      */   public static final int GL_LUMINANCE12_ALPHA4 = 32838;
/*      */   public static final int GL_LUMINANCE12_ALPHA12 = 32839;
/*      */   public static final int GL_LUMINANCE16_ALPHA16 = 32840;
/*      */   public static final int GL_INTENSITY = 32841;
/*      */   public static final int GL_INTENSITY4 = 32842;
/*      */   public static final int GL_INTENSITY8 = 32843;
/*      */   public static final int GL_INTENSITY12 = 32844;
/*      */   public static final int GL_INTENSITY16 = 32845;
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
/*      */   public static final int GL_TEXTURE_LUMINANCE_SIZE = 32864;
/*      */   public static final int GL_TEXTURE_INTENSITY_SIZE = 32865;
/*      */   public static final int GL_PROXY_TEXTURE_1D = 32867;
/*      */   public static final int GL_PROXY_TEXTURE_2D = 32868;
/*      */   public static final int GL_TEXTURE_PRIORITY = 32870;
/*      */   public static final int GL_TEXTURE_RESIDENT = 32871;
/*      */   public static final int GL_TEXTURE_BINDING_1D = 32872;
/*      */   public static final int GL_TEXTURE_BINDING_2D = 32873;
/*      */   public static final int GL_VERTEX_ARRAY = 32884;
/*      */   public static final int GL_NORMAL_ARRAY = 32885;
/*      */   public static final int GL_COLOR_ARRAY = 32886;
/*      */   public static final int GL_INDEX_ARRAY = 32887;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY = 32888;
/*      */   public static final int GL_EDGE_FLAG_ARRAY = 32889;
/*      */   public static final int GL_VERTEX_ARRAY_SIZE = 32890;
/*      */   public static final int GL_VERTEX_ARRAY_TYPE = 32891;
/*      */   public static final int GL_VERTEX_ARRAY_STRIDE = 32892;
/*      */   public static final int GL_NORMAL_ARRAY_TYPE = 32894;
/*      */   public static final int GL_NORMAL_ARRAY_STRIDE = 32895;
/*      */   public static final int GL_COLOR_ARRAY_SIZE = 32897;
/*      */   public static final int GL_COLOR_ARRAY_TYPE = 32898;
/*      */   public static final int GL_COLOR_ARRAY_STRIDE = 32899;
/*      */   public static final int GL_INDEX_ARRAY_TYPE = 32901;
/*      */   public static final int GL_INDEX_ARRAY_STRIDE = 32902;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906;
/*      */   public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 32908;
/*      */   public static final int GL_VERTEX_ARRAY_POINTER = 32910;
/*      */   public static final int GL_NORMAL_ARRAY_POINTER = 32911;
/*      */   public static final int GL_COLOR_ARRAY_POINTER = 32912;
/*      */   public static final int GL_INDEX_ARRAY_POINTER = 32913;
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914;
/*      */   public static final int GL_EDGE_FLAG_ARRAY_POINTER = 32915;
/*      */   public static final int GL_V2F = 10784;
/*      */   public static final int GL_V3F = 10785;
/*      */   public static final int GL_C4UB_V2F = 10786;
/*      */   public static final int GL_C4UB_V3F = 10787;
/*      */   public static final int GL_C3F_V3F = 10788;
/*      */   public static final int GL_N3F_V3F = 10789;
/*      */   public static final int GL_C4F_N3F_V3F = 10790;
/*      */   public static final int GL_T2F_V3F = 10791;
/*      */   public static final int GL_T4F_V4F = 10792;
/*      */   public static final int GL_T2F_C4UB_V3F = 10793;
/*      */   public static final int GL_T2F_C3F_V3F = 10794;
/*      */   public static final int GL_T2F_N3F_V3F = 10795;
/*      */   public static final int GL_T2F_C4F_N3F_V3F = 10796;
/*      */   public static final int GL_T4F_C4F_N3F_V4F = 10797;
/*      */   
/*      */   protected GL11() {
/*  711 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnable(@NativeType("GLenum") int paramInt) {
/*  724 */     GL11C.glEnable(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisable(@NativeType("GLenum") int paramInt) {
/*  737 */     GL11C.glDisable(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glAreTexturesResident(@NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/*  788 */     if (Checks.CHECKS) {
/*  789 */       Checks.check(paramByteBuffer, paramIntBuffer.remaining());
/*      */     }
/*  791 */     return nglAreTexturesResident(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
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
/*      */   public static boolean glAreTexturesResident(@NativeType("GLuint const *") int paramInt, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/*  805 */     if (Checks.CHECKS)
/*  806 */       Checks.check(paramByteBuffer, 1); 
/*      */     MemoryStack memoryStack;
/*  808 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  810 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  811 */       return nglAreTexturesResident(1, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */     } finally {
/*  813 */       memoryStack.setPointer(i);
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
/*      */   public static void glBindTexture(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  854 */     GL11C.glBindTexture(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBitmap(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/*  877 */     if (Checks.CHECKS) {
/*  878 */       Checks.checkSafe(paramByteBuffer, (paramInt1 + 7 >> 3) * paramInt2);
/*      */     }
/*  880 */     nglBitmap(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBitmap(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLubyte const *") long paramLong) {
/*  898 */     nglBitmap(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlendFunc(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  912 */     GL11C.glBlendFunc(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCallLists(@NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  945 */     nglCallLists(paramByteBuffer.remaining() / GLChecks.typeToBytes(paramInt), paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCallLists(@NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  956 */     nglCallLists(paramByteBuffer.remaining(), 5121, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCallLists(@NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  967 */     nglCallLists(paramShortBuffer.remaining(), 5123, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCallLists(@NativeType("void const *") IntBuffer paramIntBuffer) {
/*  978 */     nglCallLists(paramIntBuffer.remaining(), 5125, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClear(@NativeType("GLbitfield") int paramInt) {
/*  992 */     GL11C.glClear(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearColor(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/* 1022 */     GL11C.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearDepth(@NativeType("GLdouble") double paramDouble) {
/* 1036 */     GL11C.glClearDepth(paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearStencil(@NativeType("GLint") int paramInt) {
/* 1062 */     GL11C.glClearStencil(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClipPlane(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1083 */     if (Checks.CHECKS) {
/* 1084 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1086 */     nglClipPlane(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3bv(@NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 1206 */     if (Checks.CHECKS) {
/* 1207 */       Checks.check(paramByteBuffer, 3);
/*      */     }
/* 1209 */     nglColor3bv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1225 */     if (Checks.CHECKS) {
/* 1226 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/* 1228 */     nglColor3sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1244 */     if (Checks.CHECKS) {
/* 1245 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/* 1247 */     nglColor3iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1263 */     if (Checks.CHECKS) {
/* 1264 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/* 1266 */     nglColor3fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1282 */     if (Checks.CHECKS) {
/* 1283 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 1285 */     nglColor3dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3ubv(@NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/* 1301 */     if (Checks.CHECKS) {
/* 1302 */       Checks.check(paramByteBuffer, 3);
/*      */     }
/* 1304 */     nglColor3ubv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3usv(@NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/* 1320 */     if (Checks.CHECKS) {
/* 1321 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/* 1323 */     nglColor3usv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3uiv(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1339 */     if (Checks.CHECKS) {
/* 1340 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/* 1342 */     nglColor3uiv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4bv(@NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 1470 */     if (Checks.CHECKS) {
/* 1471 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/* 1473 */     nglColor4bv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1489 */     if (Checks.CHECKS) {
/* 1490 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 1492 */     nglColor4sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1508 */     if (Checks.CHECKS) {
/* 1509 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1511 */     nglColor4iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1527 */     if (Checks.CHECKS) {
/* 1528 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1530 */     nglColor4fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1546 */     if (Checks.CHECKS) {
/* 1547 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1549 */     nglColor4dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4ubv(@NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/* 1565 */     if (Checks.CHECKS) {
/* 1566 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/* 1568 */     nglColor4ubv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4usv(@NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/* 1584 */     if (Checks.CHECKS) {
/* 1585 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 1587 */     nglColor4usv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4uiv(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1603 */     if (Checks.CHECKS) {
/* 1604 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1606 */     nglColor4uiv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorMask(@NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4) {
/* 1622 */     GL11C.glColorMask(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1655 */     nglColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") long paramLong) {
/* 1669 */     nglColorPointer(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1683 */     nglColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1697 */     nglColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1711 */     nglColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCullFace(@NativeType("GLenum") int paramInt) {
/* 1741 */     GL11C.glCullFace(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthFunc(@NativeType("GLenum") int paramInt) {
/* 1767 */     GL11C.glDepthFunc(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthMask(@NativeType("GLboolean") boolean paramBoolean) {
/* 1780 */     GL11C.glDepthMask(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthRange(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/* 1794 */     GL11C.glDepthRange(paramDouble1, paramDouble2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 1826 */     GL11C.glDrawArrays(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffer(@NativeType("GLenum") int paramInt) {
/* 1842 */     GL11C.glDrawBuffer(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDrawElements(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1854 */     GL11C.nglDrawElements(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1870 */     GL11C.glDrawElements(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1885 */     GL11C.glDrawElements(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
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
/* 1899 */     GL11C.glDrawElements(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
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
/* 1913 */     GL11C.glDrawElements(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
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
/* 1927 */     GL11C.glDrawElements(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1947 */     nglDrawPixels(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") long paramLong) {
/* 1962 */     nglDrawPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1977 */     nglDrawPixels(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1992 */     nglDrawPixels(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 2007 */     nglDrawPixels(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEdgeFlagv(@NativeType("GLboolean const *") ByteBuffer paramByteBuffer) {
/* 2040 */     if (Checks.CHECKS) {
/* 2041 */       Checks.check(paramByteBuffer, 1);
/*      */     }
/* 2043 */     nglEdgeFlagv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEdgeFlagPointer(@NativeType("GLsizei") int paramInt, @NativeType("GLboolean const *") ByteBuffer paramByteBuffer) {
/* 2060 */     nglEdgeFlagPointer(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEdgeFlagPointer(@NativeType("GLsizei") int paramInt, @NativeType("GLboolean const *") long paramLong) {
/* 2072 */     nglEdgeFlagPointer(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord1fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 2121 */     if (Checks.CHECKS) {
/* 2122 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 2124 */     nglEvalCoord1fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord1dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 2151 */     if (Checks.CHECKS) {
/* 2152 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 2154 */     nglEvalCoord1dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord2fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 2182 */     if (Checks.CHECKS) {
/* 2183 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/* 2185 */     nglEvalCoord2fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord2dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 2213 */     if (Checks.CHECKS) {
/* 2214 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/* 2216 */     nglEvalCoord2dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFeedbackBuffer(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2288 */     nglFeedbackBuffer(paramFloatBuffer.remaining(), paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFinish() {
/* 2300 */     GL11C.glFinish();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFlush() {
/* 2311 */     GL11C.glFlush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogiv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2340 */     if (Checks.CHECKS) {
/* 2341 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2343 */     nglFogiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 2372 */     if (Checks.CHECKS) {
/* 2373 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 2375 */     nglFogfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFrontFace(@NativeType("GLenum") int paramInt) {
/* 2390 */     GL11C.glFrontFace(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenTextures(int paramInt, long paramLong) {
/* 2416 */     GL11C.nglGenTextures(paramInt, paramLong);
/*      */   }
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
/* 2428 */     GL11C.glGenTextures(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenTextures() {
/* 2439 */     return GL11C.glGenTextures();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteTextures(int paramInt, long paramLong) {
/* 2450 */     GL11C.nglDeleteTextures(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2467 */     GL11C.glDeleteTextures(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2482 */     GL11C.glDeleteTextures(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetClipPlane(@NativeType("GLenum") int paramInt, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 2500 */     if (Checks.CHECKS) {
/* 2501 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 2503 */     nglGetClipPlane(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBooleanv(int paramInt, long paramLong) {
/* 2510 */     GL11C.nglGetBooleanv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2526 */     GL11C.glGetBooleanv(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2542 */     return GL11C.glGetBoolean(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetFloatv(int paramInt, long paramLong) {
/* 2549 */     GL11C.nglGetFloatv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2565 */     GL11C.glGetFloatv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2581 */     return GL11C.glGetFloat(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetIntegerv(int paramInt, long paramLong) {
/* 2588 */     GL11C.nglGetIntegerv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2604 */     GL11C.glGetIntegerv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2620 */     return GL11C.glGetInteger(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetDoublev(int paramInt, long paramLong) {
/* 2627 */     GL11C.nglGetDoublev(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2643 */     GL11C.glGetDoublev(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2659 */     return GL11C.glGetDouble(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static int glGetError() {
/* 2676 */     return GL11C.glGetError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetLightiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2694 */     if (Checks.CHECKS) {
/* 2695 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2697 */     nglGetLightiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetLighti(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2710 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2712 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2713 */       nglGetLightiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2714 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2716 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetLightfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2735 */     if (Checks.CHECKS) {
/* 2736 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 2738 */     nglGetLightfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetLightf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2751 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2753 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 2754 */       nglGetLightfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 2755 */       return floatBuffer.get(0);
/*      */     } finally {
/* 2757 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetMapiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2776 */     if (Checks.CHECKS) {
/* 2777 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2779 */     nglGetMapiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetMapi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2792 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2794 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2795 */       nglGetMapiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2796 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2798 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetMapfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2817 */     if (Checks.CHECKS) {
/* 2818 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 2820 */     nglGetMapfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetMapf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2833 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2835 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 2836 */       nglGetMapfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 2837 */       return floatBuffer.get(0);
/*      */     } finally {
/* 2839 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetMapdv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 2858 */     if (Checks.CHECKS) {
/* 2859 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 2861 */     nglGetMapdv(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static double glGetMapd(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2874 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2876 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 2877 */       nglGetMapdv(paramInt1, paramInt2, MemoryUtil.memAddress(doubleBuffer));
/* 2878 */       return doubleBuffer.get(0);
/*      */     } finally {
/* 2880 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetMaterialiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2899 */     if (Checks.CHECKS) {
/* 2900 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2902 */     nglGetMaterialiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMaterialfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2920 */     if (Checks.CHECKS) {
/* 2921 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 2923 */     nglGetMaterialfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2940 */     if (Checks.CHECKS) {
/* 2941 */       Checks.check(paramFloatBuffer, 32);
/*      */     }
/* 2943 */     nglGetPixelMapfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") long paramLong) {
/* 2955 */     nglGetPixelMapfv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapusv(@NativeType("GLenum") int paramInt, @NativeType("GLushort *") ShortBuffer paramShortBuffer) {
/* 2972 */     if (Checks.CHECKS) {
/* 2973 */       Checks.check(paramShortBuffer, 32);
/*      */     }
/* 2975 */     nglGetPixelMapusv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapusv(@NativeType("GLenum") int paramInt, @NativeType("GLushort *") long paramLong) {
/* 2987 */     nglGetPixelMapusv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3004 */     if (Checks.CHECKS) {
/* 3005 */       Checks.check(paramIntBuffer, 32);
/*      */     }
/* 3007 */     nglGetPixelMapuiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") long paramLong) {
/* 3019 */     nglGetPixelMapuiv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetPointerv(int paramInt, long paramLong) {
/* 3026 */     GL11C.nglGetPointerv(paramInt, paramLong);
/*      */   }
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
/* 3038 */     GL11C.glGetPointerv(paramInt, paramPointerBuffer);
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
/*      */   public static long glGetPointer(@NativeType("GLenum") int paramInt) {
/* 3050 */     return GL11C.glGetPointer(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPolygonStipple(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 3066 */     if (Checks.CHECKS) {
/* 3067 */       Checks.check(paramByteBuffer, 128);
/*      */     }
/* 3069 */     nglGetPolygonStipple(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPolygonStipple(@NativeType("void *") long paramLong) {
/* 3080 */     nglGetPolygonStipple(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglGetString(int paramInt) {
/* 3087 */     return GL11C.nglGetString(paramInt);
/*      */   }
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
/* 3100 */     return GL11C.glGetString(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexEnviv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3118 */     if (Checks.CHECKS) {
/* 3119 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3121 */     nglGetTexEnviv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTexEnvi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3134 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3136 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3137 */       nglGetTexEnviv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 3138 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3140 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexEnvfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 3159 */     if (Checks.CHECKS) {
/* 3160 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 3162 */     nglGetTexEnvfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetTexEnvf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3175 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3177 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 3178 */       nglGetTexEnvfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 3179 */       return floatBuffer.get(0);
/*      */     } finally {
/* 3181 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexGeniv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3200 */     if (Checks.CHECKS) {
/* 3201 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3203 */     nglGetTexGeniv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTexGeni(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3216 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3218 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3219 */       nglGetTexGeniv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 3220 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3222 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexGenfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 3241 */     if (Checks.CHECKS) {
/* 3242 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 3244 */     nglGetTexGenfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetTexGenf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3257 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3259 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 3260 */       nglGetTexGenfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 3261 */       return floatBuffer.get(0);
/*      */     } finally {
/* 3263 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTexGendv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 3282 */     if (Checks.CHECKS) {
/* 3283 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 3285 */     nglGetTexGendv(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static double glGetTexGend(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3298 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3300 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 3301 */       nglGetTexGendv(paramInt1, paramInt2, MemoryUtil.memAddress(doubleBuffer));
/* 3302 */       return doubleBuffer.get(0);
/*      */     } finally {
/* 3304 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 3312 */     GL11C.nglGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 3327 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 3342 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 3357 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 3372 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 3387 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 3402 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 3409 */     GL11C.nglGetTexLevelParameteriv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
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
/* 3423 */     GL11C.glGetTexLevelParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
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
/* 3437 */     return GL11C.glGetTexLevelParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 3444 */     GL11C.nglGetTexLevelParameterfv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
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
/* 3458 */     GL11C.glGetTexLevelParameterfv(paramInt1, paramInt2, paramInt3, paramFloatBuffer);
/*      */   }
/*      */ 
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
/* 3472 */     return GL11C.glGetTexLevelParameterf(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 3479 */     GL11C.nglGetTexParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
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
/* 3492 */     GL11C.glGetTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
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
/*      */   public static int glGetTexParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 3505 */     return GL11C.glGetTexParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTexParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 3512 */     GL11C.nglGetTexParameterfv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
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
/* 3525 */     GL11C.glGetTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
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
/*      */   public static float glGetTexParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 3538 */     return GL11C.glGetTexParameterf(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glHint(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 3553 */     GL11C.glHint(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexiv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 3624 */     if (Checks.CHECKS) {
/* 3625 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3627 */     nglIndexiv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexubv(@NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/* 3643 */     if (Checks.CHECKS) {
/* 3644 */       Checks.check(paramByteBuffer, 1);
/*      */     }
/* 3646 */     nglIndexubv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexsv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 3662 */     if (Checks.CHECKS) {
/* 3663 */       Checks.check(paramShortBuffer, 1);
/*      */     }
/* 3665 */     nglIndexsv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexfv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 3681 */     if (Checks.CHECKS) {
/* 3682 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 3684 */     nglIndexfv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexdv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 3700 */     if (Checks.CHECKS) {
/* 3701 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 3703 */     nglIndexdv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 3738 */     nglIndexPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") long paramLong) {
/* 3751 */     nglIndexPointer(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLsizei") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 3763 */     nglIndexPointer(5121, paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLsizei") int paramInt, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 3775 */     nglIndexPointer(5122, paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexPointer(@NativeType("GLsizei") int paramInt, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 3787 */     nglIndexPointer(5124, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 3814 */     nglInterleavedArrays(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") long paramLong) {
/* 3827 */     nglInterleavedArrays(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 3840 */     nglInterleavedArrays(paramInt1, paramInt2, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 3853 */     nglInterleavedArrays(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 3866 */     nglInterleavedArrays(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 3879 */     nglInterleavedArrays(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
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
/*      */   public static boolean glIsEnabled(@NativeType("GLenum") int paramInt) {
/* 3893 */     return GL11C.glIsEnabled(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glIsTexture(@NativeType("GLuint") int paramInt) {
/* 3919 */     return GL11C.glIsTexture(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightModeliv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 3960 */     if (Checks.CHECKS) {
/* 3961 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 3963 */     nglLightModeliv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightModelfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 3980 */     if (Checks.CHECKS) {
/* 3981 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 3983 */     nglLightModelfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 4027 */     if (Checks.CHECKS) {
/* 4028 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 4030 */     nglLightiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4048 */     if (Checks.CHECKS) {
/* 4049 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 4051 */     nglLightfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLineWidth(@NativeType("GLfloat") float paramFloat) {
/* 4078 */     GL11C.glLineWidth(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLoadMatrixf(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4117 */     if (Checks.CHECKS) {
/* 4118 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/* 4120 */     nglLoadMatrixf(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLoadMatrixd(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 4136 */     if (Checks.CHECKS) {
/* 4137 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/* 4139 */     nglLoadMatrixd(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLogicOp(@NativeType("GLenum") int paramInt) {
/* 4181 */     GL11C.glLogicOp(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap1f(@NativeType("GLenum") int paramInt1, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4203 */     if (Checks.CHECKS) {
/* 4204 */       Checks.check(paramFloatBuffer, paramInt3 * paramInt2);
/*      */     }
/* 4206 */     nglMap1f(paramInt1, paramFloat1, paramFloat2, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap1d(@NativeType("GLenum") int paramInt1, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 4227 */     if (Checks.CHECKS) {
/* 4228 */       Checks.check(paramDoubleBuffer, paramInt2 * paramInt3);
/*      */     }
/* 4230 */     nglMap1d(paramInt1, paramDouble1, paramDouble2, paramInt2, paramInt3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap2f(@NativeType("GLenum") int paramInt1, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4255 */     if (Checks.CHECKS) {
/* 4256 */       Checks.check(paramFloatBuffer, paramInt2 * paramInt3 * paramInt4 * paramInt5);
/*      */     }
/* 4258 */     nglMap2f(paramInt1, paramFloat1, paramFloat2, paramInt2, paramInt3, paramFloat3, paramFloat4, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap2d(@NativeType("GLenum") int paramInt1, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 4283 */     if (Checks.CHECKS) {
/* 4284 */       Checks.check(paramDoubleBuffer, paramInt2 * paramInt3 * paramInt4 * paramInt5);
/*      */     }
/* 4286 */     nglMap2d(paramInt1, paramDouble1, paramDouble2, paramInt2, paramInt3, paramDouble3, paramDouble4, paramInt4, paramInt5, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMaterialiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 4388 */     if (Checks.CHECKS) {
/* 4389 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 4391 */     nglMaterialiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMaterialfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4409 */     if (Checks.CHECKS) {
/* 4410 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 4412 */     nglMaterialfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultMatrixf(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4439 */     if (Checks.CHECKS) {
/* 4440 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/* 4442 */     nglMultMatrixf(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultMatrixd(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 4458 */     if (Checks.CHECKS) {
/* 4459 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/* 4461 */     nglMultMatrixd(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4592 */     if (Checks.CHECKS) {
/* 4593 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/* 4595 */     nglNormal3fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3bv(@NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 4611 */     if (Checks.CHECKS) {
/* 4612 */       Checks.check(paramByteBuffer, 3);
/*      */     }
/* 4614 */     nglNormal3bv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 4630 */     if (Checks.CHECKS) {
/* 4631 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/* 4633 */     nglNormal3sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 4649 */     if (Checks.CHECKS) {
/* 4650 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/* 4652 */     nglNormal3iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 4668 */     if (Checks.CHECKS) {
/* 4669 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 4671 */     nglNormal3dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 4689 */     nglNormalPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") long paramLong) {
/* 4702 */     nglNormalPointer(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 4715 */     nglNormalPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 4728 */     nglNormalPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 4741 */     nglNormalPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapfv(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLfloat const *") long paramLong) {
/* 4804 */     nglPixelMapfv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 4816 */     nglPixelMapfv(paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapusv(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLushort const *") long paramLong) {
/* 4838 */     nglPixelMapusv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapusv(@NativeType("GLenum") int paramInt, @NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/* 4850 */     nglPixelMapusv(paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLuint const *") long paramLong) {
/* 4872 */     nglPixelMapuiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 4884 */     nglPixelMapuiv(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelStorei(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 4898 */     GL11C.glPixelStorei(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelStoref(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat) {
/* 4912 */     GL11C.glPixelStoref(paramInt, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPointSize(@NativeType("GLfloat") float paramFloat) {
/* 4969 */     GL11C.glPointSize(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPolygonMode(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 4987 */     GL11C.glPolygonMode(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPolygonOffset(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/* 5005 */     GL11C.glPolygonOffset(paramFloat1, paramFloat2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPolygonStipple(@NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/* 5028 */     if (Checks.CHECKS) {
/* 5029 */       Checks.check(paramByteBuffer, 128);
/*      */     }
/* 5031 */     nglPolygonStipple(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPolygonStipple(@NativeType("GLubyte const *") long paramLong) {
/* 5049 */     nglPolygonStipple(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPrioritizeTextures(@NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 5143 */     if (Checks.CHECKS) {
/* 5144 */       Checks.check(paramFloatBuffer, paramIntBuffer.remaining());
/*      */     }
/* 5146 */     nglPrioritizeTextures(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 5236 */     if (Checks.CHECKS) {
/* 5237 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/* 5239 */     nglRasterPos2iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 5255 */     if (Checks.CHECKS) {
/* 5256 */       Checks.check(paramShortBuffer, 2);
/*      */     }
/* 5258 */     nglRasterPos2sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 5274 */     if (Checks.CHECKS) {
/* 5275 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/* 5277 */     nglRasterPos2fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 5293 */     if (Checks.CHECKS) {
/* 5294 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/* 5296 */     nglRasterPos2dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 5364 */     if (Checks.CHECKS) {
/* 5365 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/* 5367 */     nglRasterPos3iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 5383 */     if (Checks.CHECKS) {
/* 5384 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/* 5386 */     nglRasterPos3sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 5402 */     if (Checks.CHECKS) {
/* 5403 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/* 5405 */     nglRasterPos3fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 5421 */     if (Checks.CHECKS) {
/* 5422 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 5424 */     nglRasterPos3dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 5496 */     if (Checks.CHECKS) {
/* 5497 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 5499 */     nglRasterPos4iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 5515 */     if (Checks.CHECKS) {
/* 5516 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 5518 */     nglRasterPos4sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 5534 */     if (Checks.CHECKS) {
/* 5535 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 5537 */     nglRasterPos4fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 5553 */     if (Checks.CHECKS) {
/* 5554 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 5556 */     nglRasterPos4dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadBuffer(@NativeType("GLenum") int paramInt) {
/* 5572 */     GL11C.glReadBuffer(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/* 5579 */     GL11C.nglReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 5600 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 5621 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 5642 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 5663 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 5684 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectiv(@NativeType("GLint const *") IntBuffer paramIntBuffer1, @NativeType("GLint const *") IntBuffer paramIntBuffer2) {
/* 5770 */     if (Checks.CHECKS) {
/* 5771 */       Checks.check(paramIntBuffer1, 2);
/* 5772 */       Checks.check(paramIntBuffer2, 2);
/*      */     } 
/* 5774 */     nglRectiv(MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectsv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer1, @NativeType("GLshort const *") ShortBuffer paramShortBuffer2) {
/* 5791 */     if (Checks.CHECKS) {
/* 5792 */       Checks.check(paramShortBuffer1, 2);
/* 5793 */       Checks.check(paramShortBuffer2, 2);
/*      */     } 
/* 5795 */     nglRectsv(MemoryUtil.memAddress(paramShortBuffer1), MemoryUtil.memAddress(paramShortBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectfv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer1, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer2) {
/* 5812 */     if (Checks.CHECKS) {
/* 5813 */       Checks.check(paramFloatBuffer1, 2);
/* 5814 */       Checks.check(paramFloatBuffer2, 2);
/*      */     } 
/* 5816 */     nglRectfv(MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectdv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer1, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer2) {
/* 5833 */     if (Checks.CHECKS) {
/* 5834 */       Checks.check(paramDoubleBuffer1, 2);
/* 5835 */       Checks.check(paramDoubleBuffer2, 2);
/*      */     } 
/* 5837 */     nglRectdv(MemoryUtil.memAddress(paramDoubleBuffer1), MemoryUtil.memAddress(paramDoubleBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glScissor(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 5952 */     GL11C.glScissor(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSelectBuffer(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 5972 */     nglSelectBuffer(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilFunc(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 6007 */     GL11C.glStencilFunc(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilMask(@NativeType("GLuint") int paramInt) {
/* 6023 */     GL11C.glStencilMask(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glStencilOp(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 6046 */     GL11C.glStencilOp(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 6106 */     if (Checks.CHECKS) {
/* 6107 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 6109 */     nglTexCoord1fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 6125 */     if (Checks.CHECKS) {
/* 6126 */       Checks.check(paramShortBuffer, 1);
/*      */     }
/* 6128 */     nglTexCoord1sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 6144 */     if (Checks.CHECKS) {
/* 6145 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 6147 */     nglTexCoord1iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 6163 */     if (Checks.CHECKS) {
/* 6164 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 6166 */     nglTexCoord1dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 6230 */     if (Checks.CHECKS) {
/* 6231 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/* 6233 */     nglTexCoord2fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 6249 */     if (Checks.CHECKS) {
/* 6250 */       Checks.check(paramShortBuffer, 2);
/*      */     }
/* 6252 */     nglTexCoord2sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 6268 */     if (Checks.CHECKS) {
/* 6269 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/* 6271 */     nglTexCoord2iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 6287 */     if (Checks.CHECKS) {
/* 6288 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/* 6290 */     nglTexCoord2dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 6358 */     if (Checks.CHECKS) {
/* 6359 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/* 6361 */     nglTexCoord3fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 6377 */     if (Checks.CHECKS) {
/* 6378 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/* 6380 */     nglTexCoord3sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 6396 */     if (Checks.CHECKS) {
/* 6397 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/* 6399 */     nglTexCoord3iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 6415 */     if (Checks.CHECKS) {
/* 6416 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 6418 */     nglTexCoord3dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 6490 */     if (Checks.CHECKS) {
/* 6491 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 6493 */     nglTexCoord4fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 6509 */     if (Checks.CHECKS) {
/* 6510 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 6512 */     nglTexCoord4sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 6528 */     if (Checks.CHECKS) {
/* 6529 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 6531 */     nglTexCoord4iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 6547 */     if (Checks.CHECKS) {
/* 6548 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 6550 */     nglTexCoord4dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 6569 */     nglTexCoordPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") long paramLong) {
/* 6583 */     nglTexCoordPointer(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 6597 */     nglTexCoordPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 6611 */     nglTexCoordPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 6625 */     nglTexCoordPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexEnviv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 6657 */     if (Checks.CHECKS) {
/* 6658 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 6660 */     nglTexEnviv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexEnvfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 6691 */     if (Checks.CHECKS) {
/* 6692 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 6694 */     nglTexEnvfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexGeniv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 6733 */     if (Checks.CHECKS) {
/* 6734 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 6736 */     nglTexGeniv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexGenfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 6767 */     if (Checks.CHECKS) {
/* 6768 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 6770 */     nglTexGenfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexGendv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 6801 */     if (Checks.CHECKS) {
/* 6802 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 6804 */     nglTexGendv(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {
/* 6811 */     GL11C.nglTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6829 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6847 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6865 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6883 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6901 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6919 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong) {
/* 6926 */     GL11C.nglTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6945 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6964 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 6983 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7002 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7021 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7040 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7) {
/* 7063 */     GL11C.glCopyTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8) {
/* 7097 */     GL11C.glCopyTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 7117 */     GL11C.glCopyTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8) {
/* 7139 */     GL11C.glCopyTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 7154 */     GL11C.glTexParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 7161 */     GL11C.nglTexParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
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
/* 7174 */     GL11C.glTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat) {
/* 7189 */     GL11C.glTexParameterf(paramInt1, paramInt2, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 7196 */     GL11C.nglTexParameterfv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
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
/* 7209 */     GL11C.glTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/* 7216 */     GL11C.nglTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7233 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7250 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7267 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7284 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7301 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7318 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong) {
/* 7325 */     GL11C.nglTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7345 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7365 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7385 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7405 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7425 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 7445 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 7545 */     if (Checks.CHECKS) {
/* 7546 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/* 7548 */     nglVertex2fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 7564 */     if (Checks.CHECKS) {
/* 7565 */       Checks.check(paramShortBuffer, 2);
/*      */     }
/* 7567 */     nglVertex2sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 7583 */     if (Checks.CHECKS) {
/* 7584 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/* 7586 */     nglVertex2iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 7602 */     if (Checks.CHECKS) {
/* 7603 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/* 7605 */     nglVertex2dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 7674 */     if (Checks.CHECKS) {
/* 7675 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/* 7677 */     nglVertex3fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 7693 */     if (Checks.CHECKS) {
/* 7694 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/* 7696 */     nglVertex3sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 7712 */     if (Checks.CHECKS) {
/* 7713 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/* 7715 */     nglVertex3iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 7731 */     if (Checks.CHECKS) {
/* 7732 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 7734 */     nglVertex3dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 7806 */     if (Checks.CHECKS) {
/* 7807 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 7809 */     nglVertex4fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 7825 */     if (Checks.CHECKS) {
/* 7826 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 7828 */     nglVertex4sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 7844 */     if (Checks.CHECKS) {
/* 7845 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 7847 */     nglVertex4iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 7863 */     if (Checks.CHECKS) {
/* 7864 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 7866 */     nglVertex4dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 7885 */     nglVertexPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") long paramLong) {
/* 7899 */     nglVertexPointer(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 7913 */     nglVertexPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 7927 */     nglVertexPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 7941 */     nglVertexPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewport(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 7968 */     GL11C.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glAreTexturesResident(@NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/* 7978 */     long l = (GL.getICD()).glAreTexturesResident;
/* 7979 */     if (Checks.CHECKS) {
/* 7980 */       Checks.check(l);
/* 7981 */       Checks.check(paramByteBuffer, paramArrayOfint.length);
/*      */     } 
/* 7983 */     return JNI.callPPZ(paramArrayOfint.length, paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClipPlane(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 7992 */     long l = (GL.getICD()).glClipPlane;
/* 7993 */     if (Checks.CHECKS) {
/* 7994 */       Checks.check(l);
/* 7995 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 7997 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 8006 */     long l = (GL.getICD()).glColor3sv;
/* 8007 */     if (Checks.CHECKS) {
/* 8008 */       Checks.check(l);
/* 8009 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 8011 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 8020 */     long l = (GL.getICD()).glColor3iv;
/* 8021 */     if (Checks.CHECKS) {
/* 8022 */       Checks.check(l);
/* 8023 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 8025 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8034 */     long l = (GL.getICD()).glColor3fv;
/* 8035 */     if (Checks.CHECKS) {
/* 8036 */       Checks.check(l);
/* 8037 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 8039 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8048 */     long l = (GL.getICD()).glColor3dv;
/* 8049 */     if (Checks.CHECKS) {
/* 8050 */       Checks.check(l);
/* 8051 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 8053 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3usv(@NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 8062 */     long l = (GL.getICD()).glColor3usv;
/* 8063 */     if (Checks.CHECKS) {
/* 8064 */       Checks.check(l);
/* 8065 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 8067 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor3uiv(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 8076 */     long l = (GL.getICD()).glColor3uiv;
/* 8077 */     if (Checks.CHECKS) {
/* 8078 */       Checks.check(l);
/* 8079 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 8081 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 8090 */     long l = (GL.getICD()).glColor4sv;
/* 8091 */     if (Checks.CHECKS) {
/* 8092 */       Checks.check(l);
/* 8093 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 8095 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 8104 */     long l = (GL.getICD()).glColor4iv;
/* 8105 */     if (Checks.CHECKS) {
/* 8106 */       Checks.check(l);
/* 8107 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 8109 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8118 */     long l = (GL.getICD()).glColor4fv;
/* 8119 */     if (Checks.CHECKS) {
/* 8120 */       Checks.check(l);
/* 8121 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 8123 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8132 */     long l = (GL.getICD()).glColor4dv;
/* 8133 */     if (Checks.CHECKS) {
/* 8134 */       Checks.check(l);
/* 8135 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 8137 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4usv(@NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 8146 */     long l = (GL.getICD()).glColor4usv;
/* 8147 */     if (Checks.CHECKS) {
/* 8148 */       Checks.check(l);
/* 8149 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 8151 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor4uiv(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 8160 */     long l = (GL.getICD()).glColor4uiv;
/* 8161 */     if (Checks.CHECKS) {
/* 8162 */       Checks.check(l);
/* 8163 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 8165 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 8174 */     long l = (GL.getICD()).glDrawPixels;
/* 8175 */     if (Checks.CHECKS) {
/* 8176 */       Checks.check(l);
/*      */     }
/* 8178 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 8187 */     long l = (GL.getICD()).glDrawPixels;
/* 8188 */     if (Checks.CHECKS) {
/* 8189 */       Checks.check(l);
/*      */     }
/* 8191 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawPixels(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 8200 */     long l = (GL.getICD()).glDrawPixels;
/* 8201 */     if (Checks.CHECKS) {
/* 8202 */       Checks.check(l);
/*      */     }
/* 8204 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord1fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8213 */     long l = (GL.getICD()).glEvalCoord1fv;
/* 8214 */     if (Checks.CHECKS) {
/* 8215 */       Checks.check(l);
/* 8216 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 8218 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord1dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8227 */     long l = (GL.getICD()).glEvalCoord1dv;
/* 8228 */     if (Checks.CHECKS) {
/* 8229 */       Checks.check(l);
/* 8230 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 8232 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord2fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8241 */     long l = (GL.getICD()).glEvalCoord2fv;
/* 8242 */     if (Checks.CHECKS) {
/* 8243 */       Checks.check(l);
/* 8244 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 8246 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEvalCoord2dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8255 */     long l = (GL.getICD()).glEvalCoord2dv;
/* 8256 */     if (Checks.CHECKS) {
/* 8257 */       Checks.check(l);
/* 8258 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 8260 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFeedbackBuffer(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8269 */     long l = (GL.getICD()).glFeedbackBuffer;
/* 8270 */     if (Checks.CHECKS) {
/* 8271 */       Checks.check(l);
/*      */     }
/* 8273 */     JNI.callPV(paramArrayOffloat.length, paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogiv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 8282 */     long l = (GL.getICD()).glFogiv;
/* 8283 */     if (Checks.CHECKS) {
/* 8284 */       Checks.check(l);
/* 8285 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 8287 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8296 */     long l = (GL.getICD()).glFogfv;
/* 8297 */     if (Checks.CHECKS) {
/* 8298 */       Checks.check(l);
/* 8299 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 8301 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenTextures(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 8310 */     GL11C.glGenTextures(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTextures(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 8319 */     GL11C.glDeleteTextures(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetClipPlane(@NativeType("GLenum") int paramInt, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 8328 */     long l = (GL.getICD()).glGetClipPlane;
/* 8329 */     if (Checks.CHECKS) {
/* 8330 */       Checks.check(l);
/* 8331 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 8333 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloatv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8342 */     GL11C.glGetFloatv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetIntegerv(@NativeType("GLenum") int paramInt, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8351 */     GL11C.glGetIntegerv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublev(@NativeType("GLenum") int paramInt, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 8360 */     GL11C.glGetDoublev(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetLightiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8369 */     long l = (GL.getICD()).glGetLightiv;
/* 8370 */     if (Checks.CHECKS) {
/* 8371 */       Checks.check(l);
/* 8372 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 8374 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetLightfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8383 */     long l = (GL.getICD()).glGetLightfv;
/* 8384 */     if (Checks.CHECKS) {
/* 8385 */       Checks.check(l);
/* 8386 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 8388 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMapiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8397 */     long l = (GL.getICD()).glGetMapiv;
/* 8398 */     if (Checks.CHECKS) {
/* 8399 */       Checks.check(l);
/* 8400 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 8402 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMapfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8411 */     long l = (GL.getICD()).glGetMapfv;
/* 8412 */     if (Checks.CHECKS) {
/* 8413 */       Checks.check(l);
/* 8414 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 8416 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMapdv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 8425 */     long l = (GL.getICD()).glGetMapdv;
/* 8426 */     if (Checks.CHECKS) {
/* 8427 */       Checks.check(l);
/* 8428 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 8430 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMaterialiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8439 */     long l = (GL.getICD()).glGetMaterialiv;
/* 8440 */     if (Checks.CHECKS) {
/* 8441 */       Checks.check(l);
/* 8442 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 8444 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMaterialfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8453 */     long l = (GL.getICD()).glGetMaterialfv;
/* 8454 */     if (Checks.CHECKS) {
/* 8455 */       Checks.check(l);
/* 8456 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 8458 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8467 */     long l = (GL.getICD()).glGetPixelMapfv;
/* 8468 */     if (Checks.CHECKS) {
/* 8469 */       Checks.check(l);
/* 8470 */       Checks.check(paramArrayOffloat, 32);
/*      */     } 
/* 8472 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapusv(@NativeType("GLenum") int paramInt, @NativeType("GLushort *") short[] paramArrayOfshort) {
/* 8481 */     long l = (GL.getICD()).glGetPixelMapusv;
/* 8482 */     if (Checks.CHECKS) {
/* 8483 */       Checks.check(l);
/* 8484 */       Checks.check(paramArrayOfshort, 32);
/*      */     } 
/* 8486 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPixelMapuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 8495 */     long l = (GL.getICD()).glGetPixelMapuiv;
/* 8496 */     if (Checks.CHECKS) {
/* 8497 */       Checks.check(l);
/* 8498 */       Checks.check(paramArrayOfint, 32);
/*      */     } 
/* 8500 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexEnviv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8509 */     long l = (GL.getICD()).glGetTexEnviv;
/* 8510 */     if (Checks.CHECKS) {
/* 8511 */       Checks.check(l);
/* 8512 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 8514 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexEnvfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8523 */     long l = (GL.getICD()).glGetTexEnvfv;
/* 8524 */     if (Checks.CHECKS) {
/* 8525 */       Checks.check(l);
/* 8526 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 8528 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexGeniv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8537 */     long l = (GL.getICD()).glGetTexGeniv;
/* 8538 */     if (Checks.CHECKS) {
/* 8539 */       Checks.check(l);
/* 8540 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 8542 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexGenfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8551 */     long l = (GL.getICD()).glGetTexGenfv;
/* 8552 */     if (Checks.CHECKS) {
/* 8553 */       Checks.check(l);
/* 8554 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 8556 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexGendv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 8565 */     long l = (GL.getICD()).glGetTexGendv;
/* 8566 */     if (Checks.CHECKS) {
/* 8567 */       Checks.check(l);
/* 8568 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 8570 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/* 8579 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/* 8588 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/* 8597 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/* 8606 */     GL11C.glGetTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8615 */     GL11C.glGetTexLevelParameteriv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexLevelParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8624 */     GL11C.glGetTexLevelParameterfv(paramInt1, paramInt2, paramInt3, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 8633 */     GL11C.glGetTexParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTexParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 8642 */     GL11C.glGetTexParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexiv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 8651 */     long l = (GL.getICD()).glIndexiv;
/* 8652 */     if (Checks.CHECKS) {
/* 8653 */       Checks.check(l);
/* 8654 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 8656 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexsv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 8665 */     long l = (GL.getICD()).glIndexsv;
/* 8666 */     if (Checks.CHECKS) {
/* 8667 */       Checks.check(l);
/* 8668 */       Checks.check(paramArrayOfshort, 1);
/*      */     } 
/* 8670 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexfv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8679 */     long l = (GL.getICD()).glIndexfv;
/* 8680 */     if (Checks.CHECKS) {
/* 8681 */       Checks.check(l);
/* 8682 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 8684 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glIndexdv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8693 */     long l = (GL.getICD()).glIndexdv;
/* 8694 */     if (Checks.CHECKS) {
/* 8695 */       Checks.check(l);
/* 8696 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 8698 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") short[] paramArrayOfshort) {
/* 8707 */     long l = (GL.getICD()).glInterleavedArrays;
/* 8708 */     if (Checks.CHECKS) {
/* 8709 */       Checks.check(l);
/*      */     }
/* 8711 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") int[] paramArrayOfint) {
/* 8720 */     long l = (GL.getICD()).glInterleavedArrays;
/* 8721 */     if (Checks.CHECKS) {
/* 8722 */       Checks.check(l);
/*      */     }
/* 8724 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") float[] paramArrayOffloat) {
/* 8733 */     long l = (GL.getICD()).glInterleavedArrays;
/* 8734 */     if (Checks.CHECKS) {
/* 8735 */       Checks.check(l);
/*      */     }
/* 8737 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInterleavedArrays(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 8746 */     long l = (GL.getICD()).glInterleavedArrays;
/* 8747 */     if (Checks.CHECKS) {
/* 8748 */       Checks.check(l);
/*      */     }
/* 8750 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightModeliv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 8759 */     long l = (GL.getICD()).glLightModeliv;
/* 8760 */     if (Checks.CHECKS) {
/* 8761 */       Checks.check(l);
/* 8762 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 8764 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightModelfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8773 */     long l = (GL.getICD()).glLightModelfv;
/* 8774 */     if (Checks.CHECKS) {
/* 8775 */       Checks.check(l);
/* 8776 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 8778 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 8787 */     long l = (GL.getICD()).glLightiv;
/* 8788 */     if (Checks.CHECKS) {
/* 8789 */       Checks.check(l);
/* 8790 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 8792 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLightfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8801 */     long l = (GL.getICD()).glLightfv;
/* 8802 */     if (Checks.CHECKS) {
/* 8803 */       Checks.check(l);
/* 8804 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 8806 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLoadMatrixf(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8815 */     long l = (GL.getICD()).glLoadMatrixf;
/* 8816 */     if (Checks.CHECKS) {
/* 8817 */       Checks.check(l);
/* 8818 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 8820 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLoadMatrixd(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8829 */     long l = (GL.getICD()).glLoadMatrixd;
/* 8830 */     if (Checks.CHECKS) {
/* 8831 */       Checks.check(l);
/* 8832 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 8834 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap1f(@NativeType("GLenum") int paramInt1, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8843 */     long l = (GL.getICD()).glMap1f;
/* 8844 */     if (Checks.CHECKS) {
/* 8845 */       Checks.check(l);
/* 8846 */       Checks.check(paramArrayOffloat, paramInt3 * paramInt2);
/*      */     } 
/* 8848 */     JNI.callPV(paramInt1, paramFloat1, paramFloat2, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap1d(@NativeType("GLenum") int paramInt1, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8857 */     long l = (GL.getICD()).glMap1d;
/* 8858 */     if (Checks.CHECKS) {
/* 8859 */       Checks.check(l);
/* 8860 */       Checks.check(paramArrayOfdouble, paramInt2 * paramInt3);
/*      */     } 
/* 8862 */     JNI.callPV(paramInt1, paramDouble1, paramDouble2, paramInt2, paramInt3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap2f(@NativeType("GLenum") int paramInt1, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8871 */     long l = (GL.getICD()).glMap2f;
/* 8872 */     if (Checks.CHECKS) {
/* 8873 */       Checks.check(l);
/* 8874 */       Checks.check(paramArrayOffloat, paramInt2 * paramInt3 * paramInt4 * paramInt5);
/*      */     } 
/* 8876 */     JNI.callPV(paramInt1, paramFloat1, paramFloat2, paramInt2, paramInt3, paramFloat3, paramFloat4, paramInt4, paramInt5, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMap2d(@NativeType("GLenum") int paramInt1, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8885 */     long l = (GL.getICD()).glMap2d;
/* 8886 */     if (Checks.CHECKS) {
/* 8887 */       Checks.check(l);
/* 8888 */       Checks.check(paramArrayOfdouble, paramInt2 * paramInt3 * paramInt4 * paramInt5);
/*      */     } 
/* 8890 */     JNI.callPV(paramInt1, paramDouble1, paramDouble2, paramInt2, paramInt3, paramDouble3, paramDouble4, paramInt4, paramInt5, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMaterialiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 8899 */     long l = (GL.getICD()).glMaterialiv;
/* 8900 */     if (Checks.CHECKS) {
/* 8901 */       Checks.check(l);
/* 8902 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 8904 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMaterialfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8913 */     long l = (GL.getICD()).glMaterialfv;
/* 8914 */     if (Checks.CHECKS) {
/* 8915 */       Checks.check(l);
/* 8916 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 8918 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultMatrixf(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8927 */     long l = (GL.getICD()).glMultMatrixf;
/* 8928 */     if (Checks.CHECKS) {
/* 8929 */       Checks.check(l);
/* 8930 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 8932 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultMatrixd(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8941 */     long l = (GL.getICD()).glMultMatrixd;
/* 8942 */     if (Checks.CHECKS) {
/* 8943 */       Checks.check(l);
/* 8944 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 8946 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 8955 */     long l = (GL.getICD()).glNormal3fv;
/* 8956 */     if (Checks.CHECKS) {
/* 8957 */       Checks.check(l);
/* 8958 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 8960 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 8969 */     long l = (GL.getICD()).glNormal3sv;
/* 8970 */     if (Checks.CHECKS) {
/* 8971 */       Checks.check(l);
/* 8972 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 8974 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 8983 */     long l = (GL.getICD()).glNormal3iv;
/* 8984 */     if (Checks.CHECKS) {
/* 8985 */       Checks.check(l);
/* 8986 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 8988 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormal3dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 8997 */     long l = (GL.getICD()).glNormal3dv;
/* 8998 */     if (Checks.CHECKS) {
/* 8999 */       Checks.check(l);
/* 9000 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 9002 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9011 */     long l = (GL.getICD()).glPixelMapfv;
/* 9012 */     if (Checks.CHECKS) {
/* 9013 */       Checks.check(l);
/*      */     }
/* 9015 */     JNI.callPV(paramInt, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapusv(@NativeType("GLenum") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 9024 */     long l = (GL.getICD()).glPixelMapusv;
/* 9025 */     if (Checks.CHECKS) {
/* 9026 */       Checks.check(l);
/*      */     }
/* 9028 */     JNI.callPV(paramInt, paramArrayOfshort.length, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPixelMapuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 9037 */     long l = (GL.getICD()).glPixelMapuiv;
/* 9038 */     if (Checks.CHECKS) {
/* 9039 */       Checks.check(l);
/*      */     }
/* 9041 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPrioritizeTextures(@NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9050 */     long l = (GL.getICD()).glPrioritizeTextures;
/* 9051 */     if (Checks.CHECKS) {
/* 9052 */       Checks.check(l);
/* 9053 */       Checks.check(paramArrayOffloat, paramArrayOfint.length);
/*      */     } 
/* 9055 */     JNI.callPPV(paramArrayOfint.length, paramArrayOfint, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9064 */     long l = (GL.getICD()).glRasterPos2iv;
/* 9065 */     if (Checks.CHECKS) {
/* 9066 */       Checks.check(l);
/* 9067 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 9069 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9078 */     long l = (GL.getICD()).glRasterPos2sv;
/* 9079 */     if (Checks.CHECKS) {
/* 9080 */       Checks.check(l);
/* 9081 */       Checks.check(paramArrayOfshort, 2);
/*      */     } 
/* 9083 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9092 */     long l = (GL.getICD()).glRasterPos2fv;
/* 9093 */     if (Checks.CHECKS) {
/* 9094 */       Checks.check(l);
/* 9095 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 9097 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos2dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9106 */     long l = (GL.getICD()).glRasterPos2dv;
/* 9107 */     if (Checks.CHECKS) {
/* 9108 */       Checks.check(l);
/* 9109 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 9111 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9120 */     long l = (GL.getICD()).glRasterPos3iv;
/* 9121 */     if (Checks.CHECKS) {
/* 9122 */       Checks.check(l);
/* 9123 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 9125 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9134 */     long l = (GL.getICD()).glRasterPos3sv;
/* 9135 */     if (Checks.CHECKS) {
/* 9136 */       Checks.check(l);
/* 9137 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 9139 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9148 */     long l = (GL.getICD()).glRasterPos3fv;
/* 9149 */     if (Checks.CHECKS) {
/* 9150 */       Checks.check(l);
/* 9151 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 9153 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos3dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9162 */     long l = (GL.getICD()).glRasterPos3dv;
/* 9163 */     if (Checks.CHECKS) {
/* 9164 */       Checks.check(l);
/* 9165 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 9167 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9176 */     long l = (GL.getICD()).glRasterPos4iv;
/* 9177 */     if (Checks.CHECKS) {
/* 9178 */       Checks.check(l);
/* 9179 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 9181 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9190 */     long l = (GL.getICD()).glRasterPos4sv;
/* 9191 */     if (Checks.CHECKS) {
/* 9192 */       Checks.check(l);
/* 9193 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 9195 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9204 */     long l = (GL.getICD()).glRasterPos4fv;
/* 9205 */     if (Checks.CHECKS) {
/* 9206 */       Checks.check(l);
/* 9207 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 9209 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRasterPos4dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9218 */     long l = (GL.getICD()).glRasterPos4dv;
/* 9219 */     if (Checks.CHECKS) {
/* 9220 */       Checks.check(l);
/* 9221 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 9223 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") short[] paramArrayOfshort) {
/* 9232 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") int[] paramArrayOfint) {
/* 9241 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") float[] paramArrayOffloat) {
/* 9250 */     GL11C.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectiv(@NativeType("GLint const *") int[] paramArrayOfint1, @NativeType("GLint const *") int[] paramArrayOfint2) {
/* 9259 */     long l = (GL.getICD()).glRectiv;
/* 9260 */     if (Checks.CHECKS) {
/* 9261 */       Checks.check(l);
/* 9262 */       Checks.check(paramArrayOfint1, 2);
/* 9263 */       Checks.check(paramArrayOfint2, 2);
/*      */     } 
/* 9265 */     JNI.callPPV(paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectsv(@NativeType("GLshort const *") short[] paramArrayOfshort1, @NativeType("GLshort const *") short[] paramArrayOfshort2) {
/* 9274 */     long l = (GL.getICD()).glRectsv;
/* 9275 */     if (Checks.CHECKS) {
/* 9276 */       Checks.check(l);
/* 9277 */       Checks.check(paramArrayOfshort1, 2);
/* 9278 */       Checks.check(paramArrayOfshort2, 2);
/*      */     } 
/* 9280 */     JNI.callPPV(paramArrayOfshort1, paramArrayOfshort2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectfv(@NativeType("GLfloat const *") float[] paramArrayOffloat1, @NativeType("GLfloat const *") float[] paramArrayOffloat2) {
/* 9289 */     long l = (GL.getICD()).glRectfv;
/* 9290 */     if (Checks.CHECKS) {
/* 9291 */       Checks.check(l);
/* 9292 */       Checks.check(paramArrayOffloat1, 2);
/* 9293 */       Checks.check(paramArrayOffloat2, 2);
/*      */     } 
/* 9295 */     JNI.callPPV(paramArrayOffloat1, paramArrayOffloat2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glRectdv(@NativeType("GLdouble const *") double[] paramArrayOfdouble1, @NativeType("GLdouble const *") double[] paramArrayOfdouble2) {
/* 9304 */     long l = (GL.getICD()).glRectdv;
/* 9305 */     if (Checks.CHECKS) {
/* 9306 */       Checks.check(l);
/* 9307 */       Checks.check(paramArrayOfdouble1, 2);
/* 9308 */       Checks.check(paramArrayOfdouble2, 2);
/*      */     } 
/* 9310 */     JNI.callPPV(paramArrayOfdouble1, paramArrayOfdouble2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSelectBuffer(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 9319 */     long l = (GL.getICD()).glSelectBuffer;
/* 9320 */     if (Checks.CHECKS) {
/* 9321 */       Checks.check(l);
/*      */     }
/* 9323 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9332 */     long l = (GL.getICD()).glTexCoord1fv;
/* 9333 */     if (Checks.CHECKS) {
/* 9334 */       Checks.check(l);
/* 9335 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 9337 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9346 */     long l = (GL.getICD()).glTexCoord1sv;
/* 9347 */     if (Checks.CHECKS) {
/* 9348 */       Checks.check(l);
/* 9349 */       Checks.check(paramArrayOfshort, 1);
/*      */     } 
/* 9351 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9360 */     long l = (GL.getICD()).glTexCoord1iv;
/* 9361 */     if (Checks.CHECKS) {
/* 9362 */       Checks.check(l);
/* 9363 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 9365 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord1dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9374 */     long l = (GL.getICD()).glTexCoord1dv;
/* 9375 */     if (Checks.CHECKS) {
/* 9376 */       Checks.check(l);
/* 9377 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 9379 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9388 */     long l = (GL.getICD()).glTexCoord2fv;
/* 9389 */     if (Checks.CHECKS) {
/* 9390 */       Checks.check(l);
/* 9391 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 9393 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9402 */     long l = (GL.getICD()).glTexCoord2sv;
/* 9403 */     if (Checks.CHECKS) {
/* 9404 */       Checks.check(l);
/* 9405 */       Checks.check(paramArrayOfshort, 2);
/*      */     } 
/* 9407 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9416 */     long l = (GL.getICD()).glTexCoord2iv;
/* 9417 */     if (Checks.CHECKS) {
/* 9418 */       Checks.check(l);
/* 9419 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 9421 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord2dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9430 */     long l = (GL.getICD()).glTexCoord2dv;
/* 9431 */     if (Checks.CHECKS) {
/* 9432 */       Checks.check(l);
/* 9433 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 9435 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9444 */     long l = (GL.getICD()).glTexCoord3fv;
/* 9445 */     if (Checks.CHECKS) {
/* 9446 */       Checks.check(l);
/* 9447 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 9449 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9458 */     long l = (GL.getICD()).glTexCoord3sv;
/* 9459 */     if (Checks.CHECKS) {
/* 9460 */       Checks.check(l);
/* 9461 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 9463 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9472 */     long l = (GL.getICD()).glTexCoord3iv;
/* 9473 */     if (Checks.CHECKS) {
/* 9474 */       Checks.check(l);
/* 9475 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 9477 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord3dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9486 */     long l = (GL.getICD()).glTexCoord3dv;
/* 9487 */     if (Checks.CHECKS) {
/* 9488 */       Checks.check(l);
/* 9489 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 9491 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9500 */     long l = (GL.getICD()).glTexCoord4fv;
/* 9501 */     if (Checks.CHECKS) {
/* 9502 */       Checks.check(l);
/* 9503 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 9505 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9514 */     long l = (GL.getICD()).glTexCoord4sv;
/* 9515 */     if (Checks.CHECKS) {
/* 9516 */       Checks.check(l);
/* 9517 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 9519 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9528 */     long l = (GL.getICD()).glTexCoord4iv;
/* 9529 */     if (Checks.CHECKS) {
/* 9530 */       Checks.check(l);
/* 9531 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 9533 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoord4dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9542 */     long l = (GL.getICD()).glTexCoord4dv;
/* 9543 */     if (Checks.CHECKS) {
/* 9544 */       Checks.check(l);
/* 9545 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 9547 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexEnviv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 9556 */     long l = (GL.getICD()).glTexEnviv;
/* 9557 */     if (Checks.CHECKS) {
/* 9558 */       Checks.check(l);
/* 9559 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 9561 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexEnvfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9570 */     long l = (GL.getICD()).glTexEnvfv;
/* 9571 */     if (Checks.CHECKS) {
/* 9572 */       Checks.check(l);
/* 9573 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 9575 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexGeniv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 9584 */     long l = (GL.getICD()).glTexGeniv;
/* 9585 */     if (Checks.CHECKS) {
/* 9586 */       Checks.check(l);
/* 9587 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 9589 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexGenfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9598 */     long l = (GL.getICD()).glTexGenfv;
/* 9599 */     if (Checks.CHECKS) {
/* 9600 */       Checks.check(l);
/* 9601 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 9603 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexGendv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9612 */     long l = (GL.getICD()).glTexGendv;
/* 9613 */     if (Checks.CHECKS) {
/* 9614 */       Checks.check(l);
/* 9615 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 9617 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") short[] paramArrayOfshort) {
/* 9626 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") int[] paramArrayOfint) {
/* 9635 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") float[] paramArrayOffloat) {
/* 9644 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 9653 */     GL11C.glTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 9662 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 9671 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 9680 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 9689 */     GL11C.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 9698 */     GL11C.glTexParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9707 */     GL11C.glTexParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") short[] paramArrayOfshort) {
/* 9716 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") int[] paramArrayOfint) {
/* 9725 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") float[] paramArrayOffloat) {
/* 9734 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 9743 */     GL11C.glTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 9752 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 9761 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 9770 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 9779 */     GL11C.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9788 */     long l = (GL.getICD()).glVertex2fv;
/* 9789 */     if (Checks.CHECKS) {
/* 9790 */       Checks.check(l);
/* 9791 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 9793 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9802 */     long l = (GL.getICD()).glVertex2sv;
/* 9803 */     if (Checks.CHECKS) {
/* 9804 */       Checks.check(l);
/* 9805 */       Checks.check(paramArrayOfshort, 2);
/*      */     } 
/* 9807 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9816 */     long l = (GL.getICD()).glVertex2iv;
/* 9817 */     if (Checks.CHECKS) {
/* 9818 */       Checks.check(l);
/* 9819 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 9821 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex2dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9830 */     long l = (GL.getICD()).glVertex2dv;
/* 9831 */     if (Checks.CHECKS) {
/* 9832 */       Checks.check(l);
/* 9833 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 9835 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9844 */     long l = (GL.getICD()).glVertex3fv;
/* 9845 */     if (Checks.CHECKS) {
/* 9846 */       Checks.check(l);
/* 9847 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 9849 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9858 */     long l = (GL.getICD()).glVertex3sv;
/* 9859 */     if (Checks.CHECKS) {
/* 9860 */       Checks.check(l);
/* 9861 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 9863 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9872 */     long l = (GL.getICD()).glVertex3iv;
/* 9873 */     if (Checks.CHECKS) {
/* 9874 */       Checks.check(l);
/* 9875 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 9877 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex3dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9886 */     long l = (GL.getICD()).glVertex3dv;
/* 9887 */     if (Checks.CHECKS) {
/* 9888 */       Checks.check(l);
/* 9889 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 9891 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 9900 */     long l = (GL.getICD()).glVertex4fv;
/* 9901 */     if (Checks.CHECKS) {
/* 9902 */       Checks.check(l);
/* 9903 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 9905 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 9914 */     long l = (GL.getICD()).glVertex4sv;
/* 9915 */     if (Checks.CHECKS) {
/* 9916 */       Checks.check(l);
/* 9917 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 9919 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 9928 */     long l = (GL.getICD()).glVertex4iv;
/* 9929 */     if (Checks.CHECKS) {
/* 9930 */       Checks.check(l);
/* 9931 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 9933 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertex4dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 9942 */     long l = (GL.getICD()).glVertex4dv;
/* 9943 */     if (Checks.CHECKS) {
/* 9944 */       Checks.check(l);
/* 9945 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 9947 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */   
/*      */   public static native void glAccum(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glAlphaFunc(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native boolean nglAreTexturesResident(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glArrayElement(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glBegin(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglBitmap(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong);
/*      */   
/*      */   public static native void glCallList(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglCallLists(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glClearAccum(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glClearIndex(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglClipPlane(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glColor3b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*      */   
/*      */   public static native void glColor3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glColor3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glColor3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glColor3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glColor3ub(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3);
/*      */   
/*      */   public static native void glColor3us(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3);
/*      */   
/*      */   public static native void glColor3ui(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglColor3bv(long paramLong);
/*      */   
/*      */   public static native void nglColor3sv(long paramLong);
/*      */   
/*      */   public static native void nglColor3iv(long paramLong);
/*      */   
/*      */   public static native void nglColor3fv(long paramLong);
/*      */   
/*      */   public static native void nglColor3dv(long paramLong);
/*      */   
/*      */   public static native void nglColor3ubv(long paramLong);
/*      */   
/*      */   public static native void nglColor3usv(long paramLong);
/*      */   
/*      */   public static native void nglColor3uiv(long paramLong);
/*      */   
/*      */   public static native void glColor4b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3, @NativeType("GLbyte") byte paramByte4);
/*      */   
/*      */   public static native void glColor4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glColor4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glColor4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glColor4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glColor4ub(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4);
/*      */   
/*      */   public static native void glColor4us(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3, @NativeType("GLushort") short paramShort4);
/*      */   
/*      */   public static native void glColor4ui(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglColor4bv(long paramLong);
/*      */   
/*      */   public static native void nglColor4sv(long paramLong);
/*      */   
/*      */   public static native void nglColor4iv(long paramLong);
/*      */   
/*      */   public static native void nglColor4fv(long paramLong);
/*      */   
/*      */   public static native void nglColor4dv(long paramLong);
/*      */   
/*      */   public static native void nglColor4ubv(long paramLong);
/*      */   
/*      */   public static native void nglColor4usv(long paramLong);
/*      */   
/*      */   public static native void nglColor4uiv(long paramLong);
/*      */   
/*      */   public static native void glColorMaterial(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglColorPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glCopyPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5);
/*      */   
/*      */   public static native void glDeleteLists(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2);
/*      */   
/*      */   public static native void glDisableClientState(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglDrawPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glEdgeFlag(@NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void nglEdgeFlagv(long paramLong);
/*      */   
/*      */   public static native void nglEdgeFlagPointer(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glEnableClientState(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glEnd();
/*      */   
/*      */   public static native void glEvalCoord1f(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglEvalCoord1fv(long paramLong);
/*      */   
/*      */   public static native void glEvalCoord1d(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglEvalCoord1dv(long paramLong);
/*      */   
/*      */   public static native void glEvalCoord2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void nglEvalCoord2fv(long paramLong);
/*      */   
/*      */   public static native void glEvalCoord2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglEvalCoord2dv(long paramLong);
/*      */   
/*      */   public static native void glEvalMesh1(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glEvalMesh2(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glEvalPoint1(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glEvalPoint2(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void nglFeedbackBuffer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glFogi(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void nglFogiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glFogf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglFogfv(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glGenLists(@NativeType("GLsizei") int paramInt);
/*      */   
/*      */   public static native void nglGetClipPlane(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetLightiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetLightfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMapiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMapfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMapdv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMaterialiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMaterialfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPixelMapfv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPixelMapusv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPixelMapuiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetPolygonStipple(long paramLong);
/*      */   
/*      */   public static native void nglGetTexEnviv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexEnvfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexGeniv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexGenfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTexGendv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glIndexi(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glIndexub(@NativeType("GLubyte") byte paramByte);
/*      */   
/*      */   public static native void glIndexs(@NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glIndexf(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glIndexd(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglIndexiv(long paramLong);
/*      */   
/*      */   public static native void nglIndexubv(long paramLong);
/*      */   
/*      */   public static native void nglIndexsv(long paramLong);
/*      */   
/*      */   public static native void nglIndexfv(long paramLong);
/*      */   
/*      */   public static native void nglIndexdv(long paramLong);
/*      */   
/*      */   public static native void glIndexMask(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglIndexPointer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glInitNames();
/*      */   
/*      */   public static native void nglInterleavedArrays(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsList(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glLightModeli(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glLightModelf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglLightModeliv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglLightModelfv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glLighti(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glLightf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglLightiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglLightfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glLineStipple(@NativeType("GLint") int paramInt, @NativeType("GLushort") short paramShort);
/*      */   
/*      */   public static native void glListBase(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglLoadMatrixf(long paramLong);
/*      */   
/*      */   public static native void nglLoadMatrixd(long paramLong);
/*      */   
/*      */   public static native void glLoadIdentity();
/*      */   
/*      */   public static native void glLoadName(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglMap1f(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMap1d(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMap2f(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglMap2d(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double paramDouble3, double paramDouble4, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void glMapGrid1f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glMapGrid1d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glMapGrid2f(@NativeType("GLint") int paramInt1, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glMapGrid2d(@NativeType("GLint") int paramInt1, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glMateriali(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glMaterialf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMaterialiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglMaterialfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glMatrixMode(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglMultMatrixf(long paramLong);
/*      */   
/*      */   public static native void nglMultMatrixd(long paramLong);
/*      */   
/*      */   public static native void glFrustum(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glNewList(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glEndList();
/*      */   
/*      */   public static native void glNormal3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glNormal3b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*      */   
/*      */   public static native void glNormal3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glNormal3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glNormal3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglNormal3fv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3bv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3sv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3iv(long paramLong);
/*      */   
/*      */   public static native void nglNormal3dv(long paramLong);
/*      */   
/*      */   public static native void nglNormalPointer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glOrtho(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glPassThrough(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglPixelMapfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglPixelMapusv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglPixelMapuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glPixelTransferi(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glPixelTransferf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glPixelZoom(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void nglPolygonStipple(long paramLong);
/*      */   
/*      */   public static native void glPushAttrib(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glPushClientAttrib(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glPopAttrib();
/*      */   
/*      */   public static native void glPopClientAttrib();
/*      */   
/*      */   public static native void glPopMatrix();
/*      */   
/*      */   public static native void glPopName();
/*      */   
/*      */   public static native void nglPrioritizeTextures(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glPushMatrix();
/*      */   
/*      */   public static native void glPushName(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glRasterPos2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glRasterPos2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glRasterPos2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glRasterPos2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglRasterPos2iv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos2sv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos2fv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos2dv(long paramLong);
/*      */   
/*      */   public static native void glRasterPos3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glRasterPos3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glRasterPos3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glRasterPos3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglRasterPos3iv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos3sv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos3fv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos3dv(long paramLong);
/*      */   
/*      */   public static native void glRasterPos4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glRasterPos4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glRasterPos4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glRasterPos4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglRasterPos4iv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos4sv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos4fv(long paramLong);
/*      */   
/*      */   public static native void nglRasterPos4dv(long paramLong);
/*      */   
/*      */   public static native void glRecti(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glRects(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glRectf(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glRectd(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglRectiv(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglRectsv(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglRectfv(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglRectdv(long paramLong1, long paramLong2);
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static native int glRenderMode(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glRotatef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glRotated(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glScalef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glScaled(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglSelectBuffer(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glShadeModel(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glTexCoord1f(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glTexCoord1s(@NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glTexCoord1i(@NativeType("GLint") int paramInt);
/*      */   
/*      */   public static native void glTexCoord1d(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglTexCoord1fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord1sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord1iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord1dv(long paramLong);
/*      */   
/*      */   public static native void glTexCoord2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glTexCoord2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glTexCoord2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glTexCoord2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglTexCoord2fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord2sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord2iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord2dv(long paramLong);
/*      */   
/*      */   public static native void glTexCoord3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glTexCoord3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glTexCoord3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glTexCoord3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglTexCoord3fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord3sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord3iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord3dv(long paramLong);
/*      */   
/*      */   public static native void glTexCoord4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glTexCoord4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glTexCoord4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glTexCoord4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglTexCoord4fv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord4sv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord4iv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoord4dv(long paramLong);
/*      */   
/*      */   public static native void nglTexCoordPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glTexEnvi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTexEnviv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexEnvf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTexEnvfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexGeni(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTexGeniv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexGenf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTexGenfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTexGend(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglTexGendv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTranslatef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glTranslated(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glVertex2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glVertex2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glVertex2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glVertex2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglVertex2fv(long paramLong);
/*      */   
/*      */   public static native void nglVertex2sv(long paramLong);
/*      */   
/*      */   public static native void nglVertex2iv(long paramLong);
/*      */   
/*      */   public static native void nglVertex2dv(long paramLong);
/*      */   
/*      */   public static native void glVertex3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glVertex3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glVertex3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glVertex3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglVertex3fv(long paramLong);
/*      */   
/*      */   public static native void nglVertex3sv(long paramLong);
/*      */   
/*      */   public static native void nglVertex3iv(long paramLong);
/*      */   
/*      */   public static native void nglVertex3dv(long paramLong);
/*      */   
/*      */   public static native void glVertex4f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glVertex4s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glVertex4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glVertex4d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglVertex4fv(long paramLong);
/*      */   
/*      */   public static native void nglVertex4sv(long paramLong);
/*      */   
/*      */   public static native void nglVertex4iv(long paramLong);
/*      */   
/*      */   public static native void nglVertex4dv(long paramLong);
/*      */   
/*      */   public static native void nglVertexPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */