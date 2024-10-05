/*      */ package org.lwjgl.glfw;public class GLFW { public static final int GLFW_VERSION_MAJOR = 3; public static final int GLFW_VERSION_MINOR = 4; public static final int GLFW_VERSION_REVISION = 0; public static final int GLFW_TRUE = 1; public static final int GLFW_FALSE = 0; public static final int GLFW_RELEASE = 0; public static final int GLFW_PRESS = 1; public static final int GLFW_REPEAT = 2; public static final int GLFW_HAT_CENTERED = 0; public static final int GLFW_HAT_UP = 1; public static final int GLFW_HAT_RIGHT = 2; public static final int GLFW_HAT_DOWN = 4; public static final int GLFW_HAT_LEFT = 8; public static final int GLFW_HAT_RIGHT_UP = 3; public static final int GLFW_HAT_RIGHT_DOWN = 6; public static final int GLFW_HAT_LEFT_UP = 9; public static final int GLFW_HAT_LEFT_DOWN = 12; public static final int GLFW_KEY_UNKNOWN = -1; public static final int GLFW_KEY_SPACE = 32; public static final int GLFW_KEY_APOSTROPHE = 39; public static final int GLFW_KEY_COMMA = 44; public static final int GLFW_KEY_MINUS = 45; public static final int GLFW_KEY_PERIOD = 46; public static final int GLFW_KEY_SLASH = 47; public static final int GLFW_KEY_0 = 48; public static final int GLFW_KEY_1 = 49; public static final int GLFW_KEY_2 = 50; public static final int GLFW_KEY_3 = 51; public static final int GLFW_KEY_4 = 52; public static final int GLFW_KEY_5 = 53; public static final int GLFW_KEY_6 = 54; public static final int GLFW_KEY_7 = 55; public static final int GLFW_KEY_8 = 56; public static final int GLFW_KEY_9 = 57; public static final int GLFW_KEY_SEMICOLON = 59; public static final int GLFW_KEY_EQUAL = 61; public static final int GLFW_KEY_A = 65; public static final int GLFW_KEY_B = 66; public static final int GLFW_KEY_C = 67; public static final int GLFW_KEY_D = 68; public static final int GLFW_KEY_E = 69; public static final int GLFW_KEY_F = 70; public static final int GLFW_KEY_G = 71; public static final int GLFW_KEY_H = 72; public static final int GLFW_KEY_I = 73; public static final int GLFW_KEY_J = 74; public static final int GLFW_KEY_K = 75; public static final int GLFW_KEY_L = 76; public static final int GLFW_KEY_M = 77; public static final int GLFW_KEY_N = 78; public static final int GLFW_KEY_O = 79; public static final int GLFW_KEY_P = 80; public static final int GLFW_KEY_Q = 81; public static final int GLFW_KEY_R = 82;
/*      */   public static final int GLFW_KEY_S = 83;
/*      */   public static final int GLFW_KEY_T = 84;
/*      */   public static final int GLFW_KEY_U = 85;
/*      */   public static final int GLFW_KEY_V = 86;
/*      */   public static final int GLFW_KEY_W = 87;
/*      */   public static final int GLFW_KEY_X = 88;
/*      */   public static final int GLFW_KEY_Y = 89;
/*      */   public static final int GLFW_KEY_Z = 90;
/*      */   public static final int GLFW_KEY_LEFT_BRACKET = 91;
/*      */   public static final int GLFW_KEY_BACKSLASH = 92;
/*      */   public static final int GLFW_KEY_RIGHT_BRACKET = 93;
/*      */   public static final int GLFW_KEY_GRAVE_ACCENT = 96;
/*      */   public static final int GLFW_KEY_WORLD_1 = 161;
/*      */   public static final int GLFW_KEY_WORLD_2 = 162;
/*      */   public static final int GLFW_KEY_ESCAPE = 256;
/*      */   public static final int GLFW_KEY_ENTER = 257;
/*      */   public static final int GLFW_KEY_TAB = 258;
/*      */   public static final int GLFW_KEY_BACKSPACE = 259;
/*      */   public static final int GLFW_KEY_INSERT = 260;
/*      */   public static final int GLFW_KEY_DELETE = 261;
/*      */   public static final int GLFW_KEY_RIGHT = 262;
/*      */   public static final int GLFW_KEY_LEFT = 263;
/*      */   public static final int GLFW_KEY_DOWN = 264;
/*      */   public static final int GLFW_KEY_UP = 265;
/*      */   public static final int GLFW_KEY_PAGE_UP = 266;
/*      */   public static final int GLFW_KEY_PAGE_DOWN = 267;
/*      */   public static final int GLFW_KEY_HOME = 268;
/*      */   public static final int GLFW_KEY_END = 269;
/*   30 */   private static final SharedLibrary GLFW = Library.loadNative(GLFW.class, "org.lwjgl.glfw", (String)Configuration.GLFW_LIBRARY_NAME.get(Platform.mapLibraryNameBundled("glfw")), true); public static final int GLFW_KEY_CAPS_LOCK = 280; public static final int GLFW_KEY_SCROLL_LOCK = 281; public static final int GLFW_KEY_NUM_LOCK = 282; public static final int GLFW_KEY_PRINT_SCREEN = 283; public static final int GLFW_KEY_PAUSE = 284; public static final int GLFW_KEY_F1 = 290; public static final int GLFW_KEY_F2 = 291; public static final int GLFW_KEY_F3 = 292; public static final int GLFW_KEY_F4 = 293; public static final int GLFW_KEY_F5 = 294; public static final int GLFW_KEY_F6 = 295; public static final int GLFW_KEY_F7 = 296; public static final int GLFW_KEY_F8 = 297; public static final int GLFW_KEY_F9 = 298; public static final int GLFW_KEY_F10 = 299; public static final int GLFW_KEY_F11 = 300; public static final int GLFW_KEY_F12 = 301; public static final int GLFW_KEY_F13 = 302; public static final int GLFW_KEY_F14 = 303; public static final int GLFW_KEY_F15 = 304; public static final int GLFW_KEY_F16 = 305; public static final int GLFW_KEY_F17 = 306; public static final int GLFW_KEY_F18 = 307; public static final int GLFW_KEY_F19 = 308; public static final int GLFW_KEY_F20 = 309; public static final int GLFW_KEY_F21 = 310; public static final int GLFW_KEY_F22 = 311; public static final int GLFW_KEY_F23 = 312; public static final int GLFW_KEY_F24 = 313; public static final int GLFW_KEY_F25 = 314; public static final int GLFW_KEY_KP_0 = 320; public static final int GLFW_KEY_KP_1 = 321; public static final int GLFW_KEY_KP_2 = 322; public static final int GLFW_KEY_KP_3 = 323; public static final int GLFW_KEY_KP_4 = 324; public static final int GLFW_KEY_KP_5 = 325; public static final int GLFW_KEY_KP_6 = 326; public static final int GLFW_KEY_KP_7 = 327; public static final int GLFW_KEY_KP_8 = 328; public static final int GLFW_KEY_KP_9 = 329; public static final int GLFW_KEY_KP_DECIMAL = 330; public static final int GLFW_KEY_KP_DIVIDE = 331; public static final int GLFW_KEY_KP_MULTIPLY = 332; public static final int GLFW_KEY_KP_SUBTRACT = 333; public static final int GLFW_KEY_KP_ADD = 334; public static final int GLFW_KEY_KP_ENTER = 335; public static final int GLFW_KEY_KP_EQUAL = 336; public static final int GLFW_KEY_LEFT_SHIFT = 340; public static final int GLFW_KEY_LEFT_CONTROL = 341; public static final int GLFW_KEY_LEFT_ALT = 342; public static final int GLFW_KEY_LEFT_SUPER = 343; public static final int GLFW_KEY_RIGHT_SHIFT = 344; public static final int GLFW_KEY_RIGHT_CONTROL = 345; public static final int GLFW_KEY_RIGHT_ALT = 346; public static final int GLFW_KEY_RIGHT_SUPER = 347; public static final int GLFW_KEY_MENU = 348; public static final int GLFW_KEY_LAST = 348; public static final int GLFW_MOD_SHIFT = 1; public static final int GLFW_MOD_CONTROL = 2; public static final int GLFW_MOD_ALT = 4; public static final int GLFW_MOD_SUPER = 8; public static final int GLFW_MOD_CAPS_LOCK = 16; public static final int GLFW_MOD_NUM_LOCK = 32; public static final int GLFW_MOUSE_BUTTON_1 = 0; public static final int GLFW_MOUSE_BUTTON_2 = 1; public static final int GLFW_MOUSE_BUTTON_3 = 2; public static final int GLFW_MOUSE_BUTTON_4 = 3; public static final int GLFW_MOUSE_BUTTON_5 = 4; public static final int GLFW_MOUSE_BUTTON_6 = 5; public static final int GLFW_MOUSE_BUTTON_7 = 6; public static final int GLFW_MOUSE_BUTTON_8 = 7; public static final int GLFW_MOUSE_BUTTON_LAST = 7; public static final int GLFW_MOUSE_BUTTON_LEFT = 0; public static final int GLFW_MOUSE_BUTTON_RIGHT = 1; public static final int GLFW_MOUSE_BUTTON_MIDDLE = 2; public static final int GLFW_JOYSTICK_1 = 0; public static final int GLFW_JOYSTICK_2 = 1; public static final int GLFW_JOYSTICK_3 = 2; public static final int GLFW_JOYSTICK_4 = 3; public static final int GLFW_JOYSTICK_5 = 4; public static final int GLFW_JOYSTICK_6 = 5; public static final int GLFW_JOYSTICK_7 = 6; public static final int GLFW_JOYSTICK_8 = 7; public static final int GLFW_JOYSTICK_9 = 8; public static final int GLFW_JOYSTICK_10 = 9; public static final int GLFW_JOYSTICK_11 = 10; public static final int GLFW_JOYSTICK_12 = 11; public static final int GLFW_JOYSTICK_13 = 12; public static final int GLFW_JOYSTICK_14 = 13; public static final int GLFW_JOYSTICK_15 = 14; public static final int GLFW_JOYSTICK_16 = 15; public static final int GLFW_JOYSTICK_LAST = 15; public static final int GLFW_GAMEPAD_BUTTON_A = 0; public static final int GLFW_GAMEPAD_BUTTON_B = 1; public static final int GLFW_GAMEPAD_BUTTON_X = 2; public static final int GLFW_GAMEPAD_BUTTON_Y = 3; public static final int GLFW_GAMEPAD_BUTTON_LEFT_BUMPER = 4; public static final int GLFW_GAMEPAD_BUTTON_RIGHT_BUMPER = 5; public static final int GLFW_GAMEPAD_BUTTON_BACK = 6; public static final int GLFW_GAMEPAD_BUTTON_START = 7; public static final int GLFW_GAMEPAD_BUTTON_GUIDE = 8; public static final int GLFW_GAMEPAD_BUTTON_LEFT_THUMB = 9; public static final int GLFW_GAMEPAD_BUTTON_RIGHT_THUMB = 10; public static final int GLFW_GAMEPAD_BUTTON_DPAD_UP = 11; public static final int GLFW_GAMEPAD_BUTTON_DPAD_RIGHT = 12; public static final int GLFW_GAMEPAD_BUTTON_DPAD_DOWN = 13; public static final int GLFW_GAMEPAD_BUTTON_DPAD_LEFT = 14; public static final int GLFW_GAMEPAD_BUTTON_LAST = 14; public static final int GLFW_GAMEPAD_BUTTON_CROSS = 0; public static final int GLFW_GAMEPAD_BUTTON_CIRCLE = 1; public static final int GLFW_GAMEPAD_BUTTON_SQUARE = 2; public static final int GLFW_GAMEPAD_BUTTON_TRIANGLE = 3; public static final int GLFW_GAMEPAD_AXIS_LEFT_X = 0; public static final int GLFW_GAMEPAD_AXIS_LEFT_Y = 1; public static final int GLFW_GAMEPAD_AXIS_RIGHT_X = 2; public static final int GLFW_GAMEPAD_AXIS_RIGHT_Y = 3; public static final int GLFW_GAMEPAD_AXIS_LEFT_TRIGGER = 4; public static final int GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER = 5; public static final int GLFW_GAMEPAD_AXIS_LAST = 5; public static final int GLFW_NO_ERROR = 0; public static final int GLFW_NOT_INITIALIZED = 65537; public static final int GLFW_NO_CURRENT_CONTEXT = 65538; public static final int GLFW_INVALID_ENUM = 65539; public static final int GLFW_INVALID_VALUE = 65540; public static final int GLFW_OUT_OF_MEMORY = 65541; public static final int GLFW_API_UNAVAILABLE = 65542; public static final int GLFW_VERSION_UNAVAILABLE = 65543; public static final int GLFW_PLATFORM_ERROR = 65544; public static final int GLFW_FORMAT_UNAVAILABLE = 65545; public static final int GLFW_NO_WINDOW_CONTEXT = 65546; public static final int GLFW_CURSOR_UNAVAILABLE = 65547; public static final int GLFW_FEATURE_UNAVAILABLE = 65548; public static final int GLFW_FEATURE_UNIMPLEMENTED = 65549; public static final int GLFW_PLATFORM_UNAVAILABLE = 65550; public static final int GLFW_FOCUSED = 131073; public static final int GLFW_ICONIFIED = 131074; public static final int GLFW_RESIZABLE = 131075; public static final int GLFW_VISIBLE = 131076; public static final int GLFW_DECORATED = 131077; public static final int GLFW_AUTO_ICONIFY = 131078; public static final int GLFW_FLOATING = 131079; public static final int GLFW_MAXIMIZED = 131080; public static final int GLFW_CENTER_CURSOR = 131081; public static final int GLFW_TRANSPARENT_FRAMEBUFFER = 131082; public static final int GLFW_HOVERED = 131083; public static final int GLFW_FOCUS_ON_SHOW = 131084; public static final int GLFW_MOUSE_PASSTHROUGH = 131085; public static final int GLFW_POSITION_X = 131086; public static final int GLFW_POSITION_Y = 131087; public static final int GLFW_CURSOR = 208897; public static final int GLFW_STICKY_KEYS = 208898; public static final int GLFW_STICKY_MOUSE_BUTTONS = 208899; public static final int GLFW_LOCK_KEY_MODS = 208900; public static final int GLFW_RAW_MOUSE_MOTION = 208901; public static final int GLFW_CURSOR_NORMAL = 212993; public static final int GLFW_CURSOR_HIDDEN = 212994; public static final int GLFW_CURSOR_DISABLED = 212995; public static final int GLFW_CURSOR_CAPTURED = 212996; public static final int GLFW_ARROW_CURSOR = 221185; public static final int GLFW_IBEAM_CURSOR = 221186; public static final int GLFW_CROSSHAIR_CURSOR = 221187; public static final int GLFW_POINTING_HAND_CURSOR = 221188; public static final int GLFW_RESIZE_EW_CURSOR = 221189; public static final int GLFW_RESIZE_NS_CURSOR = 221190; public static final int GLFW_RESIZE_NWSE_CURSOR = 221191; public static final int GLFW_RESIZE_NESW_CURSOR = 221192; public static final int GLFW_RESIZE_ALL_CURSOR = 221193; public static final int GLFW_NOT_ALLOWED_CURSOR = 221194; public static final int GLFW_HRESIZE_CURSOR = 221189; public static final int GLFW_VRESIZE_CURSOR = 221190; public static final int GLFW_HAND_CURSOR = 221188; public static final int GLFW_CONNECTED = 262145; public static final int GLFW_DISCONNECTED = 262146; public static final int GLFW_JOYSTICK_HAT_BUTTONS = 327681; public static final int GLFW_ANGLE_PLATFORM_TYPE = 327682; public static final int GLFW_ANY_POSITION = -2147483648; public static final int GLFW_PLATFORM = 327683; public static final int GLFW_COCOA_CHDIR_RESOURCES = 331777; public static final int GLFW_COCOA_MENUBAR = 331778; public static final int GLFW_X11_XCB_VULKAN_SURFACE = 335873; public static final int GLFW_WAYLAND_LIBDECOR = 339969; public static final int GLFW_ANY_PLATFORM = 393216; public static final int GLFW_PLATFORM_WIN32 = 393217; public static final int GLFW_PLATFORM_COCOA = 393218; public static final int GLFW_PLATFORM_WAYLAND = 393219; public static final int GLFW_PLATFORM_X11 = 393220; public static final int GLFW_PLATFORM_NULL = 393221; public static final int GLFW_DONT_CARE = -1; public static final int GLFW_RED_BITS = 135169; public static final int GLFW_GREEN_BITS = 135170; public static final int GLFW_BLUE_BITS = 135171; public static final int GLFW_ALPHA_BITS = 135172; public static final int GLFW_DEPTH_BITS = 135173; public static final int GLFW_STENCIL_BITS = 135174; public static final int GLFW_ACCUM_RED_BITS = 135175; public static final int GLFW_ACCUM_GREEN_BITS = 135176; public static final int GLFW_ACCUM_BLUE_BITS = 135177; public static final int GLFW_ACCUM_ALPHA_BITS = 135178; public static final int GLFW_AUX_BUFFERS = 135179; public static final int GLFW_STEREO = 135180; public static final int GLFW_SAMPLES = 135181; public static final int GLFW_SRGB_CAPABLE = 135182; public static final int GLFW_REFRESH_RATE = 135183; public static final int GLFW_DOUBLEBUFFER = 135184; public static final int GLFW_CLIENT_API = 139265; public static final int GLFW_CONTEXT_VERSION_MAJOR = 139266; public static final int GLFW_CONTEXT_VERSION_MINOR = 139267; public static final int GLFW_CONTEXT_REVISION = 139268; public static final int GLFW_CONTEXT_ROBUSTNESS = 139269; public static final int GLFW_OPENGL_FORWARD_COMPAT = 139270; public static final int GLFW_CONTEXT_DEBUG = 139271; public static final int GLFW_OPENGL_DEBUG_CONTEXT = 139271; public static final int GLFW_OPENGL_PROFILE = 139272; public static final int GLFW_CONTEXT_RELEASE_BEHAVIOR = 139273; public static final int GLFW_CONTEXT_NO_ERROR = 139274; public static final int GLFW_CONTEXT_CREATION_API = 139275; public static final int GLFW_SCALE_TO_MONITOR = 139276; public static final int GLFW_COCOA_RETINA_FRAMEBUFFER = 143361; public static final int GLFW_COCOA_FRAME_NAME = 143362; public static final int GLFW_COCOA_GRAPHICS_SWITCHING = 143363; public static final int GLFW_X11_CLASS_NAME = 147457; public static final int GLFW_X11_INSTANCE_NAME = 147458; public static final int GLFW_WIN32_KEYBOARD_MENU = 151553; public static final int GLFW_WAYLAND_APP_ID = 155649; public static final int GLFW_NO_API = 0; public static final int GLFW_OPENGL_API = 196609; public static final int GLFW_OPENGL_ES_API = 196610; public static final int GLFW_NO_ROBUSTNESS = 0; public static final int GLFW_NO_RESET_NOTIFICATION = 200705; public static final int GLFW_LOSE_CONTEXT_ON_RESET = 200706; public static final int GLFW_OPENGL_ANY_PROFILE = 0; public static final int GLFW_OPENGL_CORE_PROFILE = 204801; public static final int GLFW_OPENGL_COMPAT_PROFILE = 204802; public static final int GLFW_ANY_RELEASE_BEHAVIOR = 0; public static final int GLFW_RELEASE_BEHAVIOR_FLUSH = 217089; public static final int GLFW_RELEASE_BEHAVIOR_NONE = 217090; public static final int GLFW_NATIVE_CONTEXT_API = 221185; public static final int GLFW_EGL_CONTEXT_API = 221186; public static final int GLFW_OSMESA_CONTEXT_API = 221187; public static final int GLFW_ANGLE_PLATFORM_TYPE_NONE = 225281; public static final int GLFW_ANGLE_PLATFORM_TYPE_OPENGL = 225282;
/*      */   public static final int GLFW_ANGLE_PLATFORM_TYPE_OPENGLES = 225283;
/*      */   public static final int GLFW_ANGLE_PLATFORM_TYPE_D3D9 = 225284;
/*      */   public static final int GLFW_ANGLE_PLATFORM_TYPE_D3D11 = 225285;
/*      */   public static final int GLFW_ANGLE_PLATFORM_TYPE_VULKAN = 225287;
/*      */   public static final int GLFW_ANGLE_PLATFORM_TYPE_METAL = 225288;
/*      */   public static final int GLFW_WAYLAND_PREFER_LIBDECOR = 229377;
/*      */   public static final int GLFW_WAYLAND_DISABLE_LIBDECOR = 229378;
/*      */   
/*   39 */   public static final class Functions { public static final long Init = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwInit");
/*   40 */     public static final long Terminate = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwTerminate");
/*   41 */     public static final long InitHint = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwInitHint");
/*   42 */     public static final long InitAllocator = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwInitAllocator");
/*   43 */     public static final long GetVersion = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetVersion");
/*   44 */     public static final long GetVersionString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetVersionString");
/*   45 */     public static final long GetError = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetError");
/*   46 */     public static final long SetErrorCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetErrorCallback");
/*   47 */     public static final long GetPlatform = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetPlatform");
/*   48 */     public static final long PlatformSupported = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwPlatformSupported");
/*   49 */     public static final long GetMonitors = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMonitors");
/*   50 */     public static final long GetPrimaryMonitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetPrimaryMonitor");
/*   51 */     public static final long GetMonitorPos = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMonitorPos");
/*   52 */     public static final long GetMonitorWorkarea = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMonitorWorkarea");
/*   53 */     public static final long GetMonitorPhysicalSize = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMonitorPhysicalSize");
/*   54 */     public static final long GetMonitorContentScale = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMonitorContentScale");
/*   55 */     public static final long GetMonitorName = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMonitorName");
/*   56 */     public static final long SetMonitorUserPointer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetMonitorUserPointer");
/*   57 */     public static final long GetMonitorUserPointer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMonitorUserPointer");
/*   58 */     public static final long SetMonitorCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetMonitorCallback");
/*   59 */     public static final long GetVideoModes = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetVideoModes");
/*   60 */     public static final long GetVideoMode = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetVideoMode");
/*   61 */     public static final long SetGamma = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetGamma");
/*   62 */     public static final long GetGammaRamp = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetGammaRamp");
/*   63 */     public static final long SetGammaRamp = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetGammaRamp");
/*   64 */     public static final long DefaultWindowHints = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwDefaultWindowHints");
/*   65 */     public static final long WindowHint = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwWindowHint");
/*   66 */     public static final long WindowHintString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwWindowHintString");
/*   67 */     public static final long CreateWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwCreateWindow");
/*   68 */     public static final long DestroyWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwDestroyWindow");
/*   69 */     public static final long WindowShouldClose = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwWindowShouldClose");
/*   70 */     public static final long SetWindowShouldClose = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowShouldClose");
/*   71 */     public static final long SetWindowTitle = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowTitle");
/*   72 */     public static final long SetWindowIcon = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowIcon");
/*   73 */     public static final long GetWindowPos = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowPos");
/*   74 */     public static final long SetWindowPos = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowPos");
/*   75 */     public static final long GetWindowSize = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowSize");
/*   76 */     public static final long SetWindowSizeLimits = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowSizeLimits");
/*   77 */     public static final long SetWindowAspectRatio = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowAspectRatio");
/*   78 */     public static final long SetWindowSize = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowSize");
/*   79 */     public static final long GetFramebufferSize = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetFramebufferSize");
/*   80 */     public static final long GetWindowFrameSize = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowFrameSize");
/*   81 */     public static final long GetWindowContentScale = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowContentScale");
/*   82 */     public static final long GetWindowOpacity = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowOpacity");
/*   83 */     public static final long SetWindowOpacity = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowOpacity");
/*   84 */     public static final long IconifyWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwIconifyWindow");
/*   85 */     public static final long RestoreWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwRestoreWindow");
/*   86 */     public static final long MaximizeWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwMaximizeWindow");
/*   87 */     public static final long ShowWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwShowWindow");
/*   88 */     public static final long HideWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwHideWindow");
/*   89 */     public static final long FocusWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwFocusWindow");
/*   90 */     public static final long RequestWindowAttention = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwRequestWindowAttention");
/*   91 */     public static final long GetWindowMonitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowMonitor");
/*   92 */     public static final long SetWindowMonitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowMonitor");
/*   93 */     public static final long GetWindowAttrib = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowAttrib");
/*   94 */     public static final long SetWindowAttrib = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowAttrib");
/*   95 */     public static final long SetWindowUserPointer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowUserPointer");
/*   96 */     public static final long GetWindowUserPointer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetWindowUserPointer");
/*   97 */     public static final long SetWindowPosCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowPosCallback");
/*   98 */     public static final long SetWindowSizeCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowSizeCallback");
/*   99 */     public static final long SetWindowCloseCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowCloseCallback");
/*  100 */     public static final long SetWindowRefreshCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowRefreshCallback");
/*  101 */     public static final long SetWindowFocusCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowFocusCallback");
/*  102 */     public static final long SetWindowIconifyCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowIconifyCallback");
/*  103 */     public static final long SetWindowMaximizeCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowMaximizeCallback");
/*  104 */     public static final long SetFramebufferSizeCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetFramebufferSizeCallback");
/*  105 */     public static final long SetWindowContentScaleCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetWindowContentScaleCallback");
/*  106 */     public static final long PollEvents = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwPollEvents");
/*  107 */     public static final long WaitEvents = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwWaitEvents");
/*  108 */     public static final long WaitEventsTimeout = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwWaitEventsTimeout");
/*  109 */     public static final long PostEmptyEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwPostEmptyEvent");
/*  110 */     public static final long GetInputMode = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetInputMode");
/*  111 */     public static final long SetInputMode = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetInputMode");
/*  112 */     public static final long RawMouseMotionSupported = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwRawMouseMotionSupported");
/*  113 */     public static final long GetKeyName = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetKeyName");
/*  114 */     public static final long GetKeyScancode = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetKeyScancode");
/*  115 */     public static final long GetKey = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetKey");
/*  116 */     public static final long GetMouseButton = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetMouseButton");
/*  117 */     public static final long GetCursorPos = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetCursorPos");
/*  118 */     public static final long SetCursorPos = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetCursorPos");
/*  119 */     public static final long CreateCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwCreateCursor");
/*  120 */     public static final long CreateStandardCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwCreateStandardCursor");
/*  121 */     public static final long DestroyCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwDestroyCursor");
/*  122 */     public static final long SetCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetCursor");
/*  123 */     public static final long SetKeyCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetKeyCallback");
/*  124 */     public static final long SetCharCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetCharCallback");
/*  125 */     public static final long SetCharModsCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetCharModsCallback");
/*  126 */     public static final long SetMouseButtonCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetMouseButtonCallback");
/*  127 */     public static final long SetCursorPosCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetCursorPosCallback");
/*  128 */     public static final long SetCursorEnterCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetCursorEnterCallback");
/*  129 */     public static final long SetScrollCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetScrollCallback");
/*  130 */     public static final long SetDropCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetDropCallback");
/*  131 */     public static final long JoystickPresent = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwJoystickPresent");
/*  132 */     public static final long GetJoystickAxes = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetJoystickAxes");
/*  133 */     public static final long GetJoystickButtons = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetJoystickButtons");
/*  134 */     public static final long GetJoystickHats = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetJoystickHats");
/*  135 */     public static final long GetJoystickName = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetJoystickName");
/*  136 */     public static final long GetJoystickGUID = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetJoystickGUID");
/*  137 */     public static final long SetJoystickUserPointer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetJoystickUserPointer");
/*  138 */     public static final long GetJoystickUserPointer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetJoystickUserPointer");
/*  139 */     public static final long JoystickIsGamepad = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwJoystickIsGamepad");
/*  140 */     public static final long SetJoystickCallback = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetJoystickCallback");
/*  141 */     public static final long UpdateGamepadMappings = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwUpdateGamepadMappings");
/*  142 */     public static final long GetGamepadName = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetGamepadName");
/*  143 */     public static final long GetGamepadState = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetGamepadState");
/*  144 */     public static final long SetClipboardString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetClipboardString");
/*  145 */     public static final long GetClipboardString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetClipboardString");
/*  146 */     public static final long GetTime = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetTime");
/*  147 */     public static final long SetTime = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSetTime");
/*  148 */     public static final long GetTimerValue = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetTimerValue");
/*  149 */     public static final long GetTimerFrequency = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetTimerFrequency");
/*  150 */     public static final long MakeContextCurrent = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwMakeContextCurrent");
/*  151 */     public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetCurrentContext");
/*  152 */     public static final long SwapBuffers = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSwapBuffers");
/*  153 */     public static final long SwapInterval = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwSwapInterval");
/*  154 */     public static final long ExtensionSupported = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwExtensionSupported");
/*  155 */     public static final long GetProcAddress = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.GLFW, "glfwGetProcAddress"); }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static SharedLibrary getLibrary() {
/*  161 */     return GLFW;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GLFW() {
/* 1039 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwInit() {
/* 1077 */     long l = Functions.Init;
/* 1078 */     EventLoop.check();
/* 1079 */     return (JNI.invokeI(l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwTerminate() {
/*      */     long l;
/* 1108 */     JNI.invokeV(l = Functions.Terminate);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwInitHint(int paramInt1, int paramInt2) {
/* 1135 */     long l = Functions.InitHint;
/* 1136 */     JNI.invokeV(paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwInitAllocator(long paramLong) {
/* 1143 */     long l = Functions.InitAllocator;
/* 1144 */     if (Checks.CHECKS && 
/* 1145 */       paramLong != 0L) GLFWAllocator.validate(paramLong);
/*      */     
/* 1147 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwInitAllocator(@NativeType("GLFWallocator const *") GLFWAllocator paramGLFWAllocator) {
/* 1171 */     nglfwInitAllocator(MemoryUtil.memAddressSafe((Pointer)paramGLFWAllocator));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetVersion(long paramLong1, long paramLong2, long paramLong3) {
/* 1178 */     long l = Functions.GetVersion;
/* 1179 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetVersion(@NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3) {
/* 1202 */     if (Checks.CHECKS) {
/* 1203 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1204 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 1205 */       Checks.checkSafe(paramIntBuffer3, 1);
/*      */     } 
/* 1207 */     nglfwGetVersion(MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetVersionString() {
/*      */     long l;
/* 1215 */     return JNI.invokeP(l = Functions.GetVersionString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static String glfwGetVersionString() {
/*      */     long l;
/* 1244 */     return MemoryUtil.memASCII(l = nglfwGetVersionString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglfwGetError(long paramLong) {
/* 1251 */     long l = Functions.GetError;
/* 1252 */     return JNI.invokePI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int glfwGetError(@NativeType("char const **") PointerBuffer paramPointerBuffer) {
/* 1277 */     if (Checks.CHECKS) {
/* 1278 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1280 */     return nglfwGetError(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetErrorCallback(long paramLong) {
/* 1287 */     long l = Functions.SetErrorCallback;
/* 1288 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWerrorfun")
/*      */   public static GLFWErrorCallback glfwSetErrorCallback(@NativeType("GLFWerrorfun") GLFWErrorCallbackI paramGLFWErrorCallbackI) {
/* 1320 */     return GLFWErrorCallback.createSafe(nglfwSetErrorCallback(MemoryUtil.memAddressSafe((Pointer)paramGLFWErrorCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int glfwGetPlatform() {
/*      */     long l;
/* 1341 */     return JNI.invokeI(l = Functions.GetPlatform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwPlatformSupported(int paramInt) {
/* 1365 */     long l = Functions.PlatformSupported;
/* 1366 */     return (JNI.invokeI(paramInt, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetMonitors(long paramLong) {
/* 1377 */     long l = Functions.GetMonitors;
/* 1378 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWmonitor **")
/*      */   public static PointerBuffer glfwGetMonitors() {
/*      */     MemoryStack memoryStack;
/* 1397 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1398 */     null = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 1401 */       return MemoryUtil.memPointerBufferSafe(l = nglfwGetMonitors(MemoryUtil.memAddress(null)), null.get(0));
/*      */     } finally {
/* 1403 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("GLFWmonitor *")
/*      */   public static long glfwGetPrimaryMonitor() {
/*      */     long l;
/* 1423 */     return JNI.invokeP(l = Functions.GetPrimaryMonitor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetMonitorPos(long paramLong1, long paramLong2, long paramLong3) {
/* 1430 */     long l = Functions.GetMonitorPos;
/* 1431 */     if (Checks.CHECKS) {
/* 1432 */       Checks.check(paramLong1);
/*      */     }
/* 1434 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorPos(@NativeType("GLFWmonitor *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 1451 */     if (Checks.CHECKS) {
/* 1452 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1453 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     } 
/* 1455 */     nglfwGetMonitorPos(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetMonitorWorkarea(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/* 1462 */     long l = Functions.GetMonitorWorkarea;
/* 1463 */     if (Checks.CHECKS) {
/* 1464 */       Checks.check(paramLong1);
/*      */     }
/* 1466 */     JNI.invokePPPPPV(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorWorkarea(@NativeType("GLFWmonitor *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 1489 */     if (Checks.CHECKS) {
/* 1490 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1491 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 1492 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 1493 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/* 1495 */     nglfwGetMonitorWorkarea(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetMonitorPhysicalSize(long paramLong1, long paramLong2, long paramLong3) {
/* 1502 */     long l = Functions.GetMonitorPhysicalSize;
/* 1503 */     if (Checks.CHECKS) {
/* 1504 */       Checks.check(paramLong1);
/*      */     }
/* 1506 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorPhysicalSize(@NativeType("GLFWmonitor *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 1533 */     if (Checks.CHECKS) {
/* 1534 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1535 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     } 
/* 1537 */     nglfwGetMonitorPhysicalSize(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetMonitorContentScale(long paramLong1, long paramLong2, long paramLong3) {
/* 1544 */     long l = Functions.GetMonitorContentScale;
/* 1545 */     if (Checks.CHECKS) {
/* 1546 */       Checks.check(paramLong1);
/*      */     }
/* 1548 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorContentScale(@NativeType("GLFWmonitor *") long paramLong, @NativeType("float *") FloatBuffer paramFloatBuffer1, @NativeType("float *") FloatBuffer paramFloatBuffer2) {
/* 1571 */     if (Checks.CHECKS) {
/* 1572 */       Checks.checkSafe(paramFloatBuffer1, 1);
/* 1573 */       Checks.checkSafe(paramFloatBuffer2, 1);
/*      */     } 
/* 1575 */     nglfwGetMonitorContentScale(paramLong, MemoryUtil.memAddressSafe(paramFloatBuffer1), MemoryUtil.memAddressSafe(paramFloatBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetMonitorName(long paramLong) {
/* 1582 */     long l = Functions.GetMonitorName;
/* 1583 */     if (Checks.CHECKS) {
/* 1584 */       Checks.check(paramLong);
/*      */     }
/* 1586 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static String glfwGetMonitorName(@NativeType("GLFWmonitor *") long paramLong) {
/*      */     long l;
/* 1608 */     return MemoryUtil.memUTF8Safe(l = nglfwGetMonitorName(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetMonitorUserPointer(@NativeType("GLFWmonitor *") long paramLong1, @NativeType("void *") long paramLong2) {
/* 1629 */     long l = Functions.SetMonitorUserPointer;
/* 1630 */     if (Checks.CHECKS) {
/* 1631 */       Checks.check(paramLong1);
/* 1632 */       Checks.check(paramLong2);
/*      */     } 
/* 1634 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static long glfwGetMonitorUserPointer(@NativeType("GLFWmonitor *") long paramLong) {
/* 1654 */     long l = Functions.GetMonitorUserPointer;
/* 1655 */     if (Checks.CHECKS) {
/* 1656 */       Checks.check(paramLong);
/*      */     }
/* 1658 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetMonitorCallback(long paramLong) {
/* 1665 */     long l = Functions.SetMonitorCallback;
/* 1666 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWmonitorfun")
/*      */   public static GLFWMonitorCallback glfwSetMonitorCallback(@NativeType("GLFWmonitorfun") GLFWMonitorCallbackI paramGLFWMonitorCallbackI) {
/* 1684 */     return GLFWMonitorCallback.createSafe(nglfwSetMonitorCallback(MemoryUtil.memAddressSafe((Pointer)paramGLFWMonitorCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetVideoModes(long paramLong1, long paramLong2) {
/* 1695 */     long l = Functions.GetVideoModes;
/* 1696 */     if (Checks.CHECKS) {
/* 1697 */       Checks.check(paramLong1);
/*      */     }
/* 1699 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWvidmode const *")
/*      */   public static GLFWVidMode.Buffer glfwGetVideoModes(@NativeType("GLFWmonitor *") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 1722 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1723 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 1726 */       return GLFWVidMode.createSafe(l = nglfwGetVideoModes(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 1728 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetVideoMode(long paramLong) {
/* 1736 */     long l = Functions.GetVideoMode;
/* 1737 */     if (Checks.CHECKS) {
/* 1738 */       Checks.check(paramLong);
/*      */     }
/* 1740 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWvidmode const *")
/*      */   public static GLFWVidMode glfwGetVideoMode(@NativeType("GLFWmonitor *") long paramLong) {
/*      */     long l;
/* 1762 */     return GLFWVidMode.createSafe(l = nglfwGetVideoMode(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetGamma(@NativeType("GLFWmonitor *") long paramLong, float paramFloat) {
/* 1791 */     long l = Functions.SetGamma;
/* 1792 */     if (Checks.CHECKS) {
/* 1793 */       Checks.check(paramLong);
/*      */     }
/* 1795 */     JNI.invokePV(paramLong, paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetGammaRamp(long paramLong) {
/* 1802 */     long l = Functions.GetGammaRamp;
/* 1803 */     if (Checks.CHECKS) {
/* 1804 */       Checks.check(paramLong);
/*      */     }
/* 1806 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWgammaramp const *")
/*      */   public static GLFWGammaRamp glfwGetGammaRamp(@NativeType("GLFWmonitor *") long paramLong) {
/*      */     long l;
/* 1833 */     return GLFWGammaRamp.createSafe(l = nglfwGetGammaRamp(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwSetGammaRamp(long paramLong1, long paramLong2) {
/* 1840 */     long l = Functions.SetGammaRamp;
/* 1841 */     if (Checks.CHECKS) {
/* 1842 */       Checks.check(paramLong1);
/* 1843 */       GLFWGammaRamp.validate(paramLong2);
/*      */     } 
/* 1845 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetGammaRamp(@NativeType("GLFWmonitor *") long paramLong, @NativeType("GLFWgammaramp const *") GLFWGammaRamp paramGLFWGammaRamp) {
/* 1875 */     nglfwSetGammaRamp(paramLong, paramGLFWGammaRamp.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwDefaultWindowHints() {
/*      */     long l;
/* 1889 */     JNI.invokeV(l = Functions.DefaultWindowHints);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwWindowHint(int paramInt1, int paramInt2) {
/* 1961 */     long l = Functions.WindowHint;
/* 1962 */     JNI.invokeV(paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwWindowHintString(int paramInt, long paramLong) {
/* 1969 */     long l = Functions.WindowHintString;
/* 1970 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwWindowHintString(int paramInt, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 2005 */     if (Checks.CHECKS) {
/* 2006 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2008 */     nglfwWindowHintString(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwWindowHintString(int paramInt, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 2043 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2045 */       memoryStack.nUTF8(paramCharSequence, true);
/* 2046 */       long l = memoryStack.getPointerAddress();
/* 2047 */       nglfwWindowHintString(paramInt, l); return;
/*      */     } finally {
/* 2049 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwCreateWindow(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/* 2057 */     long l = Functions.CreateWindow;
/* 2058 */     return JNI.invokePPPP(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindow *")
/*      */   public static long glfwCreateWindow(int paramInt1, int paramInt2, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("GLFWmonitor *") long paramLong1, @NativeType("GLFWwindow *") long paramLong2) {
/* 2140 */     if (Checks.CHECKS) {
/* 2141 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2143 */     return nglfwCreateWindow(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindow *")
/*      */   public static long glfwCreateWindow(int paramInt1, int paramInt2, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("GLFWmonitor *") long paramLong1, @NativeType("GLFWwindow *") long paramLong2) {
/*      */     MemoryStack memoryStack;
/* 2225 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2227 */       memoryStack.nUTF8(paramCharSequence, true);
/* 2228 */       long l = memoryStack.getPointerAddress();
/* 2229 */       return nglfwCreateWindow(paramInt1, paramInt2, l, paramLong1, paramLong2);
/*      */     } finally {
/* 2231 */       memoryStack.setPointer(i);
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
/*      */   public static void glfwDestroyWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 2255 */     long l = Functions.DestroyWindow;
/* 2256 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwWindowShouldClose(@NativeType("GLFWwindow *") long paramLong) {
/* 2274 */     long l = Functions.WindowShouldClose;
/* 2275 */     if (Checks.CHECKS) {
/* 2276 */       Checks.check(paramLong);
/*      */     }
/* 2278 */     return (JNI.invokePI(paramLong, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowShouldClose(@NativeType("GLFWwindow *") long paramLong, @NativeType("int") boolean paramBoolean) {
/* 2295 */     long l = Functions.SetWindowShouldClose;
/* 2296 */     if (Checks.CHECKS) {
/* 2297 */       Checks.check(paramLong);
/*      */     }
/* 2299 */     JNI.invokePV(paramLong, paramBoolean ? 1 : 0, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwSetWindowTitle(long paramLong1, long paramLong2) {
/* 2306 */     long l = Functions.SetWindowTitle;
/* 2307 */     if (Checks.CHECKS) {
/* 2308 */       Checks.check(paramLong1);
/*      */     }
/* 2310 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowTitle(@NativeType("GLFWwindow *") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 2326 */     if (Checks.CHECKS) {
/* 2327 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2329 */     nglfwSetWindowTitle(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowTitle(@NativeType("GLFWwindow *") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 2345 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2347 */       memoryStack.nUTF8(paramCharSequence, true);
/* 2348 */       long l = memoryStack.getPointerAddress();
/* 2349 */       nglfwSetWindowTitle(paramLong, l); return;
/*      */     } finally {
/* 2351 */       memoryStack.setPointer(i);
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
/*      */   public static void nglfwSetWindowIcon(long paramLong1, int paramInt, long paramLong2) {
/* 2363 */     long l = Functions.SetWindowIcon;
/* 2364 */     if (Checks.CHECKS) {
/* 2365 */       Checks.check(paramLong1);
/* 2366 */       if (paramLong2 != 0L) Struct.validate(paramLong2, paramInt, GLFWImage.SIZEOF, GLFWImage::validate); 
/*      */     } 
/* 2368 */     JNI.invokePPV(paramLong1, paramInt, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowIcon(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWimage const *") GLFWImage.Buffer paramBuffer) {
/* 2400 */     nglfwSetWindowIcon(paramLong, Checks.remainingSafe((CustomBuffer)paramBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetWindowPos(long paramLong1, long paramLong2, long paramLong3) {
/* 2407 */     long l = Functions.GetWindowPos;
/* 2408 */     if (Checks.CHECKS) {
/* 2409 */       Checks.check(paramLong1);
/*      */     }
/* 2411 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowPos(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 2433 */     if (Checks.CHECKS) {
/* 2434 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 2435 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     } 
/* 2437 */     nglfwGetWindowPos(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowPos(@NativeType("GLFWwindow *") long paramLong, int paramInt1, int paramInt2) {
/* 2465 */     long l = Functions.SetWindowPos;
/* 2466 */     if (Checks.CHECKS) {
/* 2467 */       Checks.check(paramLong);
/*      */     }
/* 2469 */     JNI.invokePV(paramLong, paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetWindowSize(long paramLong1, long paramLong2, long paramLong3) {
/* 2476 */     long l = Functions.GetWindowSize;
/* 2477 */     if (Checks.CHECKS) {
/* 2478 */       Checks.check(paramLong1);
/*      */     }
/* 2480 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowSize(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 2498 */     if (Checks.CHECKS) {
/* 2499 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 2500 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     } 
/* 2502 */     nglfwGetWindowSize(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowSizeLimits(@NativeType("GLFWwindow *") long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2531 */     long l = Functions.SetWindowSizeLimits;
/* 2532 */     if (Checks.CHECKS) {
/* 2533 */       Checks.check(paramLong);
/*      */     }
/* 2535 */     JNI.invokePV(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowAspectRatio(@NativeType("GLFWwindow *") long paramLong, int paramInt1, int paramInt2) {
/* 2565 */     long l = Functions.SetWindowAspectRatio;
/* 2566 */     if (Checks.CHECKS) {
/* 2567 */       Checks.check(paramLong);
/*      */     }
/* 2569 */     JNI.invokePV(paramLong, paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowSize(@NativeType("GLFWwindow *") long paramLong, int paramInt1, int paramInt2) {
/* 2598 */     long l = Functions.SetWindowSize;
/* 2599 */     if (Checks.CHECKS) {
/* 2600 */       Checks.check(paramLong);
/*      */     }
/* 2602 */     JNI.invokePV(paramLong, paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetFramebufferSize(long paramLong1, long paramLong2, long paramLong3) {
/* 2609 */     long l = Functions.GetFramebufferSize;
/* 2610 */     if (Checks.CHECKS) {
/* 2611 */       Checks.check(paramLong1);
/*      */     }
/* 2613 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetFramebufferSize(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 2631 */     if (Checks.CHECKS) {
/* 2632 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 2633 */       Checks.checkSafe(paramIntBuffer2, 1);
/*      */     } 
/* 2635 */     nglfwGetFramebufferSize(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetWindowFrameSize(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/* 2642 */     long l = Functions.GetWindowFrameSize;
/* 2643 */     if (Checks.CHECKS) {
/* 2644 */       Checks.check(paramLong1);
/*      */     }
/* 2646 */     JNI.invokePPPPPV(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowFrameSize(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4) {
/* 2670 */     if (Checks.CHECKS) {
/* 2671 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 2672 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 2673 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 2674 */       Checks.checkSafe(paramIntBuffer4, 1);
/*      */     } 
/* 2676 */     nglfwGetWindowFrameSize(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetWindowContentScale(long paramLong1, long paramLong2, long paramLong3) {
/* 2683 */     long l = Functions.GetWindowContentScale;
/* 2684 */     if (Checks.CHECKS) {
/* 2685 */       Checks.check(paramLong1);
/*      */     }
/* 2687 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowContentScale(@NativeType("GLFWwindow *") long paramLong, @NativeType("float *") FloatBuffer paramFloatBuffer1, @NativeType("float *") FloatBuffer paramFloatBuffer2) {
/* 2708 */     if (Checks.CHECKS) {
/* 2709 */       Checks.checkSafe(paramFloatBuffer1, 1);
/* 2710 */       Checks.checkSafe(paramFloatBuffer2, 1);
/*      */     } 
/* 2712 */     nglfwGetWindowContentScale(paramLong, MemoryUtil.memAddressSafe(paramFloatBuffer1), MemoryUtil.memAddressSafe(paramFloatBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float glfwGetWindowOpacity(@NativeType("GLFWwindow *") long paramLong) {
/* 2736 */     long l = Functions.GetWindowOpacity;
/* 2737 */     if (Checks.CHECKS) {
/* 2738 */       Checks.check(paramLong);
/*      */     }
/* 2740 */     return JNI.invokePF(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowOpacity(@NativeType("GLFWwindow *") long paramLong, float paramFloat) {
/* 2769 */     long l = Functions.SetWindowOpacity;
/* 2770 */     if (Checks.CHECKS) {
/* 2771 */       Checks.check(paramLong);
/*      */     }
/* 2773 */     JNI.invokePV(paramLong, paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwIconifyWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 2796 */     long l = Functions.IconifyWindow;
/* 2797 */     if (Checks.CHECKS) {
/* 2798 */       Checks.check(paramLong);
/*      */     }
/* 2800 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwRestoreWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 2817 */     long l = Functions.RestoreWindow;
/* 2818 */     if (Checks.CHECKS) {
/* 2819 */       Checks.check(paramLong);
/*      */     }
/* 2821 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwMaximizeWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 2838 */     long l = Functions.MaximizeWindow;
/* 2839 */     if (Checks.CHECKS) {
/* 2840 */       Checks.check(paramLong);
/*      */     }
/* 2842 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwShowWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 2866 */     long l = Functions.ShowWindow;
/* 2867 */     if (Checks.CHECKS) {
/* 2868 */       Checks.check(paramLong);
/*      */     }
/* 2870 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwHideWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 2885 */     long l = Functions.HideWindow;
/* 2886 */     if (Checks.CHECKS) {
/* 2887 */       Checks.check(paramLong);
/*      */     }
/* 2889 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwFocusWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 2918 */     long l = Functions.FocusWindow;
/* 2919 */     if (Checks.CHECKS) {
/* 2920 */       Checks.check(paramLong);
/*      */     }
/* 2922 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwRequestWindowAttention(@NativeType("GLFWwindow *") long paramLong) {
/* 2947 */     long l = Functions.RequestWindowAttention;
/* 2948 */     if (Checks.CHECKS) {
/* 2949 */       Checks.check(paramLong);
/*      */     }
/* 2951 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWmonitor *")
/*      */   public static long glfwGetWindowMonitor(@NativeType("GLFWwindow *") long paramLong) {
/* 2969 */     long l = Functions.GetWindowMonitor;
/* 2970 */     if (Checks.CHECKS) {
/* 2971 */       Checks.check(paramLong);
/*      */     }
/* 2973 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowMonitor(@NativeType("GLFWwindow *") long paramLong1, @NativeType("GLFWmonitor *") long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 3013 */     long l = Functions.SetWindowMonitor;
/* 3014 */     if (Checks.CHECKS) {
/* 3015 */       Checks.check(paramLong1);
/*      */     }
/* 3017 */     JNI.invokePPV(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int glfwGetWindowAttrib(@NativeType("GLFWwindow *") long paramLong, int paramInt) {
/* 3042 */     long l = Functions.GetWindowAttrib;
/* 3043 */     if (Checks.CHECKS) {
/* 3044 */       Checks.check(paramLong);
/*      */     }
/* 3046 */     return JNI.invokePI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowAttrib(@NativeType("GLFWwindow *") long paramLong, int paramInt1, int paramInt2) {
/* 3069 */     long l = Functions.SetWindowAttrib;
/* 3070 */     if (Checks.CHECKS) {
/* 3071 */       Checks.check(paramLong);
/*      */     }
/* 3073 */     JNI.invokePV(paramLong, paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetWindowUserPointer(@NativeType("GLFWwindow *") long paramLong1, @NativeType("void *") long paramLong2) {
/* 3089 */     long l = Functions.SetWindowUserPointer;
/* 3090 */     if (Checks.CHECKS) {
/* 3091 */       Checks.check(paramLong1);
/*      */     }
/* 3093 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static long glfwGetWindowUserPointer(@NativeType("GLFWwindow *") long paramLong) {
/* 3109 */     long l = Functions.GetWindowUserPointer;
/* 3110 */     if (Checks.CHECKS) {
/* 3111 */       Checks.check(paramLong);
/*      */     }
/* 3113 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowPosCallback(long paramLong1, long paramLong2) {
/* 3120 */     long l = Functions.SetWindowPosCallback;
/* 3121 */     if (Checks.CHECKS) {
/* 3122 */       Checks.check(paramLong1);
/*      */     }
/* 3124 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowposfun")
/*      */   public static GLFWWindowPosCallback glfwSetWindowPosCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowposfun") GLFWWindowPosCallbackI paramGLFWWindowPosCallbackI) {
/* 3149 */     return GLFWWindowPosCallback.createSafe(nglfwSetWindowPosCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowPosCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowSizeCallback(long paramLong1, long paramLong2) {
/* 3156 */     long l = Functions.SetWindowSizeCallback;
/* 3157 */     if (Checks.CHECKS) {
/* 3158 */       Checks.check(paramLong1);
/*      */     }
/* 3160 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowsizefun")
/*      */   public static GLFWWindowSizeCallback glfwSetWindowSizeCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowsizefun") GLFWWindowSizeCallbackI paramGLFWWindowSizeCallbackI) {
/* 3180 */     return GLFWWindowSizeCallback.createSafe(nglfwSetWindowSizeCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowSizeCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowCloseCallback(long paramLong1, long paramLong2) {
/* 3187 */     long l = Functions.SetWindowCloseCallback;
/* 3188 */     if (Checks.CHECKS) {
/* 3189 */       Checks.check(paramLong1);
/*      */     }
/* 3191 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowclosefun")
/*      */   public static GLFWWindowCloseCallback glfwSetWindowCloseCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowclosefun") GLFWWindowCloseCallbackI paramGLFWWindowCloseCallbackI) {
/* 3220 */     return GLFWWindowCloseCallback.createSafe(nglfwSetWindowCloseCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowCloseCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowRefreshCallback(long paramLong1, long paramLong2) {
/* 3227 */     long l = Functions.SetWindowRefreshCallback;
/* 3228 */     if (Checks.CHECKS) {
/* 3229 */       Checks.check(paramLong1);
/*      */     }
/* 3231 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowrefreshfun")
/*      */   public static GLFWWindowRefreshCallback glfwSetWindowRefreshCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowrefreshfun") GLFWWindowRefreshCallbackI paramGLFWWindowRefreshCallbackI) {
/* 3254 */     return GLFWWindowRefreshCallback.createSafe(nglfwSetWindowRefreshCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowRefreshCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowFocusCallback(long paramLong1, long paramLong2) {
/* 3261 */     long l = Functions.SetWindowFocusCallback;
/* 3262 */     if (Checks.CHECKS) {
/* 3263 */       Checks.check(paramLong1);
/*      */     }
/* 3265 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowfocusfun")
/*      */   public static GLFWWindowFocusCallback glfwSetWindowFocusCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowfocusfun") GLFWWindowFocusCallbackI paramGLFWWindowFocusCallbackI) {
/* 3287 */     return GLFWWindowFocusCallback.createSafe(nglfwSetWindowFocusCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowFocusCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowIconifyCallback(long paramLong1, long paramLong2) {
/* 3294 */     long l = Functions.SetWindowIconifyCallback;
/* 3295 */     if (Checks.CHECKS) {
/* 3296 */       Checks.check(paramLong1);
/*      */     }
/* 3298 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowiconifyfun")
/*      */   public static GLFWWindowIconifyCallback glfwSetWindowIconifyCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowiconifyfun") GLFWWindowIconifyCallbackI paramGLFWWindowIconifyCallbackI) {
/* 3317 */     return GLFWWindowIconifyCallback.createSafe(nglfwSetWindowIconifyCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowIconifyCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowMaximizeCallback(long paramLong1, long paramLong2) {
/* 3324 */     long l = Functions.SetWindowMaximizeCallback;
/* 3325 */     if (Checks.CHECKS) {
/* 3326 */       Checks.check(paramLong1);
/*      */     }
/* 3328 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowmaximizefun")
/*      */   public static GLFWWindowMaximizeCallback glfwSetWindowMaximizeCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowmaximizefun") GLFWWindowMaximizeCallbackI paramGLFWWindowMaximizeCallbackI) {
/* 3347 */     return GLFWWindowMaximizeCallback.createSafe(nglfwSetWindowMaximizeCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowMaximizeCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetFramebufferSizeCallback(long paramLong1, long paramLong2) {
/* 3354 */     long l = Functions.SetFramebufferSizeCallback;
/* 3355 */     if (Checks.CHECKS) {
/* 3356 */       Checks.check(paramLong1);
/*      */     }
/* 3358 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWframebuffersizefun")
/*      */   public static GLFWFramebufferSizeCallback glfwSetFramebufferSizeCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWframebuffersizefun") GLFWFramebufferSizeCallbackI paramGLFWFramebufferSizeCallbackI) {
/* 3377 */     return GLFWFramebufferSizeCallback.createSafe(nglfwSetFramebufferSizeCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWFramebufferSizeCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetWindowContentScaleCallback(long paramLong1, long paramLong2) {
/* 3384 */     long l = Functions.SetWindowContentScaleCallback;
/* 3385 */     if (Checks.CHECKS) {
/* 3386 */       Checks.check(paramLong1);
/*      */     }
/* 3388 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindowcontentscalefun")
/*      */   public static GLFWWindowContentScaleCallback glfwSetWindowContentScaleCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWwindowcontentscalefun") GLFWWindowContentScaleCallbackI paramGLFWWindowContentScaleCallbackI) {
/* 3407 */     return GLFWWindowContentScaleCallback.createSafe(nglfwSetWindowContentScaleCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWWindowContentScaleCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwPollEvents() {
/*      */     long l;
/* 3438 */     JNI.invokeV(l = Functions.PollEvents);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwWaitEvents() {
/*      */     long l;
/* 3472 */     JNI.invokeV(l = Functions.WaitEvents);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwWaitEventsTimeout(double paramDouble) {
/* 3508 */     long l = Functions.WaitEventsTimeout;
/* 3509 */     JNI.invokeV(paramDouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwPostEmptyEvent() {
/*      */     long l;
/* 3523 */     JNI.invokeV(l = Functions.PostEmptyEvent);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int glfwGetInputMode(@NativeType("GLFWwindow *") long paramLong, int paramInt) {
/* 3541 */     long l = Functions.GetInputMode;
/* 3542 */     if (Checks.CHECKS) {
/* 3543 */       Checks.check(paramLong);
/*      */     }
/* 3545 */     return JNI.invokePI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetInputMode(@NativeType("GLFWwindow *") long paramLong, int paramInt1, int paramInt2) {
/* 3588 */     long l = Functions.SetInputMode;
/* 3589 */     if (Checks.CHECKS) {
/* 3590 */       Checks.check(paramLong);
/*      */     }
/* 3592 */     JNI.invokePV(paramLong, paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwRawMouseMotionSupported() {
/*      */     long l;
/* 3616 */     return (JNI.invokeI(l = Functions.RawMouseMotionSupported) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetKeyName(int paramInt1, int paramInt2) {
/* 3623 */     long l = Functions.GetKeyName;
/* 3624 */     return JNI.invokeP(paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static String glfwGetKeyName(int paramInt1, int paramInt2) {
/*      */     long l;
/* 3686 */     return MemoryUtil.memUTF8Safe(l = nglfwGetKeyName(paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int glfwGetKeyScancode(int paramInt) {
/* 3707 */     long l = Functions.GetKeyScancode;
/* 3708 */     return JNI.invokeI(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int glfwGetKey(@NativeType("GLFWwindow *") long paramLong, int paramInt) {
/* 3742 */     long l = Functions.GetKey;
/* 3743 */     if (Checks.CHECKS) {
/* 3744 */       Checks.check(paramLong);
/*      */     }
/* 3746 */     return JNI.invokePI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int glfwGetMouseButton(@NativeType("GLFWwindow *") long paramLong, int paramInt) {
/* 3768 */     long l = Functions.GetMouseButton;
/* 3769 */     if (Checks.CHECKS) {
/* 3770 */       Checks.check(paramLong);
/*      */     }
/* 3772 */     return JNI.invokePI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwGetCursorPos(long paramLong1, long paramLong2, long paramLong3) {
/* 3779 */     long l = Functions.GetCursorPos;
/* 3780 */     if (Checks.CHECKS) {
/* 3781 */       Checks.check(paramLong1);
/*      */     }
/* 3783 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwGetCursorPos(@NativeType("GLFWwindow *") long paramLong, @NativeType("double *") DoubleBuffer paramDoubleBuffer1, @NativeType("double *") DoubleBuffer paramDoubleBuffer2) {
/* 3806 */     if (Checks.CHECKS) {
/* 3807 */       Checks.checkSafe(paramDoubleBuffer1, 1);
/* 3808 */       Checks.checkSafe(paramDoubleBuffer2, 1);
/*      */     } 
/* 3810 */     nglfwGetCursorPos(paramLong, MemoryUtil.memAddressSafe(paramDoubleBuffer1), MemoryUtil.memAddressSafe(paramDoubleBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetCursorPos(@NativeType("GLFWwindow *") long paramLong, double paramDouble1, double paramDouble2) {
/* 3838 */     long l = Functions.SetCursorPos;
/* 3839 */     if (Checks.CHECKS) {
/* 3840 */       Checks.check(paramLong);
/*      */     }
/* 3842 */     JNI.invokePV(paramLong, paramDouble1, paramDouble2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwCreateCursor(long paramLong, int paramInt1, int paramInt2) {
/* 3849 */     long l = Functions.CreateCursor;
/* 3850 */     if (Checks.CHECKS) {
/* 3851 */       GLFWImage.validate(paramLong);
/*      */     }
/* 3853 */     return JNI.invokePP(paramLong, paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWcursor *")
/*      */   public static long glfwCreateCursor(@NativeType("GLFWimage const *") GLFWImage paramGLFWImage, int paramInt1, int paramInt2) {
/* 3883 */     return nglfwCreateCursor(paramGLFWImage.address(), paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWcursor *")
/*      */   public static long glfwCreateStandardCursor(int paramInt) {
/* 3929 */     long l = Functions.CreateStandardCursor;
/* 3930 */     return JNI.invokeP(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwDestroyCursor(@NativeType("GLFWcursor *") long paramLong) {
/* 3950 */     long l = Functions.DestroyCursor;
/* 3951 */     if (Checks.CHECKS) {
/* 3952 */       Checks.check(paramLong);
/*      */     }
/* 3954 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetCursor(@NativeType("GLFWwindow *") long paramLong1, @NativeType("GLFWcursor *") long paramLong2) {
/* 3973 */     long l = Functions.SetCursor;
/* 3974 */     if (Checks.CHECKS) {
/* 3975 */       Checks.check(paramLong1);
/*      */     }
/* 3977 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetKeyCallback(long paramLong1, long paramLong2) {
/* 3984 */     long l = Functions.SetKeyCallback;
/* 3985 */     if (Checks.CHECKS) {
/* 3986 */       Checks.check(paramLong1);
/*      */     }
/* 3988 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWkeyfun")
/*      */   public static GLFWKeyCallback glfwSetKeyCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWkeyfun") GLFWKeyCallbackI paramGLFWKeyCallbackI) {
/* 4018 */     return GLFWKeyCallback.createSafe(nglfwSetKeyCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWKeyCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetCharCallback(long paramLong1, long paramLong2) {
/* 4025 */     long l = Functions.SetCharCallback;
/* 4026 */     if (Checks.CHECKS) {
/* 4027 */       Checks.check(paramLong1);
/*      */     }
/* 4029 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWcharfun")
/*      */   public static GLFWCharCallback glfwSetCharCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWcharfun") GLFWCharCallbackI paramGLFWCharCallbackI) {
/* 4054 */     return GLFWCharCallback.createSafe(nglfwSetCharCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWCharCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetCharModsCallback(long paramLong1, long paramLong2) {
/* 4061 */     long l = Functions.SetCharModsCallback;
/* 4062 */     if (Checks.CHECKS) {
/* 4063 */       Checks.check(paramLong1);
/*      */     }
/* 4065 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWcharmodsfun")
/*      */   public static GLFWCharModsCallback glfwSetCharModsCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWcharmodsfun") GLFWCharModsCallbackI paramGLFWCharModsCallbackI) {
/* 4091 */     return GLFWCharModsCallback.createSafe(nglfwSetCharModsCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWCharModsCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetMouseButtonCallback(long paramLong1, long paramLong2) {
/* 4098 */     long l = Functions.SetMouseButtonCallback;
/* 4099 */     if (Checks.CHECKS) {
/* 4100 */       Checks.check(paramLong1);
/*      */     }
/* 4102 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWmousebuttonfun")
/*      */   public static GLFWMouseButtonCallback glfwSetMouseButtonCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWmousebuttonfun") GLFWMouseButtonCallbackI paramGLFWMouseButtonCallbackI) {
/* 4124 */     return GLFWMouseButtonCallback.createSafe(nglfwSetMouseButtonCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWMouseButtonCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetCursorPosCallback(long paramLong1, long paramLong2) {
/* 4131 */     long l = Functions.SetCursorPosCallback;
/* 4132 */     if (Checks.CHECKS) {
/* 4133 */       Checks.check(paramLong1);
/*      */     }
/* 4135 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWcursorposfun")
/*      */   public static GLFWCursorPosCallback glfwSetCursorPosCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWcursorposfun") GLFWCursorPosCallbackI paramGLFWCursorPosCallbackI) {
/* 4154 */     return GLFWCursorPosCallback.createSafe(nglfwSetCursorPosCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWCursorPosCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetCursorEnterCallback(long paramLong1, long paramLong2) {
/* 4161 */     long l = Functions.SetCursorEnterCallback;
/* 4162 */     if (Checks.CHECKS) {
/* 4163 */       Checks.check(paramLong1);
/*      */     }
/* 4165 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWcursorenterfun")
/*      */   public static GLFWCursorEnterCallback glfwSetCursorEnterCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWcursorenterfun") GLFWCursorEnterCallbackI paramGLFWCursorEnterCallbackI) {
/* 4183 */     return GLFWCursorEnterCallback.createSafe(nglfwSetCursorEnterCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWCursorEnterCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetScrollCallback(long paramLong1, long paramLong2) {
/* 4190 */     long l = Functions.SetScrollCallback;
/* 4191 */     if (Checks.CHECKS) {
/* 4192 */       Checks.check(paramLong1);
/*      */     }
/* 4194 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWscrollfun")
/*      */   public static GLFWScrollCallback glfwSetScrollCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWscrollfun") GLFWScrollCallbackI paramGLFWScrollCallbackI) {
/* 4214 */     return GLFWScrollCallback.createSafe(nglfwSetScrollCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWScrollCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetDropCallback(long paramLong1, long paramLong2) {
/* 4221 */     long l = Functions.SetDropCallback;
/* 4222 */     if (Checks.CHECKS) {
/* 4223 */       Checks.check(paramLong1);
/*      */     }
/* 4225 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWdropfun")
/*      */   public static GLFWDropCallback glfwSetDropCallback(@NativeType("GLFWwindow *") long paramLong, @NativeType("GLFWdropfun") GLFWDropCallbackI paramGLFWDropCallbackI) {
/* 4251 */     return GLFWDropCallback.createSafe(nglfwSetDropCallback(paramLong, MemoryUtil.memAddressSafe((Pointer)paramGLFWDropCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwJoystickPresent(int paramInt) {
/* 4269 */     long l = Functions.JoystickPresent;
/* 4270 */     return (JNI.invokeI(paramInt, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetJoystickAxes(int paramInt, long paramLong) {
/* 4281 */     long l = Functions.GetJoystickAxes;
/* 4282 */     return JNI.invokePP(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("float const *")
/*      */   public static FloatBuffer glfwGetJoystickAxes(int paramInt) {
/*      */     MemoryStack memoryStack;
/* 4305 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 4306 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 4309 */       return MemoryUtil.memFloatBufferSafe(l = nglfwGetJoystickAxes(paramInt, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 4311 */       memoryStack.setPointer(i);
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
/*      */   public static long nglfwGetJoystickButtons(int paramInt, long paramLong) {
/* 4323 */     long l = Functions.GetJoystickButtons;
/* 4324 */     return JNI.invokePP(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char const *")
/*      */   public static ByteBuffer glfwGetJoystickButtons(int paramInt) {
/*      */     MemoryStack memoryStack;
/* 4351 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 4352 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 4355 */       return MemoryUtil.memByteBufferSafe(l = nglfwGetJoystickButtons(paramInt, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 4357 */       memoryStack.setPointer(i);
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
/*      */   public static long nglfwGetJoystickHats(int paramInt, long paramLong) {
/* 4369 */     long l = Functions.GetJoystickHats;
/* 4370 */     return JNI.invokePP(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned char const *")
/*      */   public static ByteBuffer glfwGetJoystickHats(int paramInt) {
/*      */     MemoryStack memoryStack;
/* 4420 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 4421 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 4424 */       return MemoryUtil.memByteBufferSafe(l = nglfwGetJoystickHats(paramInt, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 4426 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetJoystickName(int paramInt) {
/* 4434 */     long l = Functions.GetJoystickName;
/* 4435 */     return JNI.invokeP(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static String glfwGetJoystickName(int paramInt) {
/*      */     long l;
/* 4459 */     return MemoryUtil.memUTF8Safe(l = nglfwGetJoystickName(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetJoystickGUID(int paramInt) {
/* 4466 */     long l = Functions.GetJoystickGUID;
/* 4467 */     return JNI.invokeP(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static String glfwGetJoystickGUID(int paramInt) {
/*      */     long l;
/* 4498 */     return MemoryUtil.memUTF8Safe(l = nglfwGetJoystickGUID(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetJoystickUserPointer(int paramInt, @NativeType("void *") long paramLong) {
/* 4519 */     long l = Functions.SetJoystickUserPointer;
/* 4520 */     if (Checks.CHECKS) {
/* 4521 */       Checks.check(paramLong);
/*      */     }
/* 4523 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static long glfwGetJoystickUserPointer(int paramInt) {
/* 4543 */     long l = Functions.GetJoystickUserPointer;
/* 4544 */     return JNI.invokeP(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwJoystickIsGamepad(int paramInt) {
/* 4565 */     long l = Functions.JoystickIsGamepad;
/* 4566 */     return (JNI.invokeI(paramInt, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwSetJoystickCallback(long paramLong) {
/* 4573 */     long l = Functions.SetJoystickCallback;
/* 4574 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWjoystickfun")
/*      */   public static GLFWJoystickCallback glfwSetJoystickCallback(@NativeType("GLFWjoystickfun") GLFWJoystickCallbackI paramGLFWJoystickCallbackI) {
/* 4596 */     return GLFWJoystickCallback.createSafe(nglfwSetJoystickCallback(MemoryUtil.memAddressSafe((Pointer)paramGLFWJoystickCallbackI)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglfwUpdateGamepadMappings(long paramLong) {
/* 4603 */     long l = Functions.UpdateGamepadMappings;
/* 4604 */     return JNI.invokePI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwUpdateGamepadMappings(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 4629 */     if (Checks.CHECKS) {
/* 4630 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 4632 */     return (nglfwUpdateGamepadMappings(MemoryUtil.memAddress(paramByteBuffer)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetGamepadName(int paramInt) {
/* 4639 */     long l = Functions.GetGamepadName;
/* 4640 */     return JNI.invokeP(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static String glfwGetGamepadName(int paramInt) {
/*      */     long l;
/* 4664 */     return MemoryUtil.memUTF8Safe(l = nglfwGetGamepadName(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglfwGetGamepadState(int paramInt, long paramLong) {
/* 4671 */     long l = Functions.GetGamepadState;
/* 4672 */     return JNI.invokePI(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwGetGamepadState(int paramInt, @NativeType("GLFWgamepadstate *") GLFWGamepadState paramGLFWGamepadState) {
/* 4697 */     return (nglfwGetGamepadState(paramInt, paramGLFWGamepadState.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglfwSetClipboardString(long paramLong1, long paramLong2) {
/* 4704 */     long l = Functions.SetClipboardString;
/* 4705 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetClipboardString(@NativeType("GLFWwindow *") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 4725 */     if (Checks.CHECKS) {
/* 4726 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 4728 */     nglfwSetClipboardString(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetClipboardString(@NativeType("GLFWwindow *") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 4748 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 4750 */       memoryStack.nUTF8(paramCharSequence, true);
/* 4751 */       long l = memoryStack.getPointerAddress();
/* 4752 */       nglfwSetClipboardString(paramLong, l); return;
/*      */     } finally {
/* 4754 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetClipboardString(long paramLong) {
/* 4762 */     long l = Functions.GetClipboardString;
/* 4763 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static String glfwGetClipboardString(@NativeType("GLFWwindow *") long paramLong) {
/*      */     long l;
/* 4791 */     return MemoryUtil.memUTF8Safe(l = nglfwGetClipboardString(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double glfwGetTime() {
/*      */     long l;
/* 4811 */     return JNI.invokeD(l = Functions.GetTime);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSetTime(double paramDouble) {
/* 4831 */     long l = Functions.SetTime;
/* 4832 */     JNI.invokeV(paramDouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("uint64_t")
/*      */   public static long glfwGetTimerValue() {
/*      */     long l;
/* 4851 */     return JNI.invokeJ(l = Functions.GetTimerValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("uint64_t")
/*      */   public static long glfwGetTimerFrequency() {
/*      */     long l;
/* 4868 */     return JNI.invokeJ(l = Functions.GetTimerFrequency);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwMakeContextCurrent(@NativeType("GLFWwindow *") long paramLong) {
/* 4893 */     long l = Functions.MakeContextCurrent;
/* 4894 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWwindow *")
/*      */   public static long glfwGetCurrentContext() {
/*      */     long l;
/* 4911 */     return JNI.invokeP(l = Functions.GetCurrentContext);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSwapBuffers(@NativeType("GLFWwindow *") long paramLong) {
/* 4933 */     long l = Functions.SwapBuffers;
/* 4934 */     if (Checks.CHECKS) {
/* 4935 */       Checks.check(paramLong);
/*      */     }
/* 4937 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glfwSwapInterval(int paramInt) {
/* 4972 */     long l = Functions.SwapInterval;
/* 4973 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglfwExtensionSupported(long paramLong) {
/* 4980 */     long l = Functions.ExtensionSupported;
/* 4981 */     return JNI.invokePI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwExtensionSupported(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 5006 */     if (Checks.CHECKS) {
/* 5007 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 5009 */     return (nglfwExtensionSupported(MemoryUtil.memAddress(paramByteBuffer)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static boolean glfwExtensionSupported(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 5034 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 5036 */       memoryStack.nASCII(paramCharSequence, true); long l; return 
/*      */         
/* 5038 */         (nglfwExtensionSupported(l = memoryStack.getPointerAddress()) != 0);
/*      */     } finally {
/* 5040 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglfwGetProcAddress(long paramLong) {
/* 5048 */     long l = Functions.GetProcAddress;
/* 5049 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWglproc")
/*      */   public static long glfwGetProcAddress(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 5078 */     if (Checks.CHECKS) {
/* 5079 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 5081 */     return nglfwGetProcAddress(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLFWglproc")
/*      */   public static long glfwGetProcAddress(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 5110 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 5112 */       memoryStack.nASCII(paramCharSequence, true);
/*      */       long l;
/* 5114 */       return nglfwGetProcAddress(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 5116 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetVersion(@NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3) {
/* 5122 */     long l = Functions.GetVersion;
/* 5123 */     if (Checks.CHECKS) {
/* 5124 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5125 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 5126 */       Checks.checkSafe(paramArrayOfint3, 1);
/*      */     } 
/* 5128 */     JNI.invokePPPV(paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorPos(@NativeType("GLFWmonitor *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 5133 */     long l = Functions.GetMonitorPos;
/* 5134 */     if (Checks.CHECKS) {
/* 5135 */       Checks.check(paramLong);
/* 5136 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5137 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 5139 */     JNI.invokePPPV(paramLong, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorWorkarea(@NativeType("GLFWmonitor *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 5144 */     long l = Functions.GetMonitorWorkarea;
/* 5145 */     if (Checks.CHECKS) {
/* 5146 */       Checks.check(paramLong);
/* 5147 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5148 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 5149 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 5150 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 5152 */     JNI.invokePPPPPV(paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorPhysicalSize(@NativeType("GLFWmonitor *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 5157 */     long l = Functions.GetMonitorPhysicalSize;
/* 5158 */     if (Checks.CHECKS) {
/* 5159 */       Checks.check(paramLong);
/* 5160 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5161 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 5163 */     JNI.invokePPPV(paramLong, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetMonitorContentScale(@NativeType("GLFWmonitor *") long paramLong, @NativeType("float *") float[] paramArrayOffloat1, @NativeType("float *") float[] paramArrayOffloat2) {
/* 5168 */     long l = Functions.GetMonitorContentScale;
/* 5169 */     if (Checks.CHECKS) {
/* 5170 */       Checks.check(paramLong);
/* 5171 */       Checks.checkSafe(paramArrayOffloat1, 1);
/* 5172 */       Checks.checkSafe(paramArrayOffloat2, 1);
/*      */     } 
/* 5174 */     JNI.invokePPPV(paramLong, paramArrayOffloat1, paramArrayOffloat2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowPos(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 5179 */     long l = Functions.GetWindowPos;
/* 5180 */     if (Checks.CHECKS) {
/* 5181 */       Checks.check(paramLong);
/* 5182 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5183 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 5185 */     JNI.invokePPPV(paramLong, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowSize(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 5190 */     long l = Functions.GetWindowSize;
/* 5191 */     if (Checks.CHECKS) {
/* 5192 */       Checks.check(paramLong);
/* 5193 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5194 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 5196 */     JNI.invokePPPV(paramLong, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetFramebufferSize(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 5201 */     long l = Functions.GetFramebufferSize;
/* 5202 */     if (Checks.CHECKS) {
/* 5203 */       Checks.check(paramLong);
/* 5204 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5205 */       Checks.checkSafe(paramArrayOfint2, 1);
/*      */     } 
/* 5207 */     JNI.invokePPPV(paramLong, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowFrameSize(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4) {
/* 5212 */     long l = Functions.GetWindowFrameSize;
/* 5213 */     if (Checks.CHECKS) {
/* 5214 */       Checks.check(paramLong);
/* 5215 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 5216 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 5217 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 5218 */       Checks.checkSafe(paramArrayOfint4, 1);
/*      */     } 
/* 5220 */     JNI.invokePPPPPV(paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetWindowContentScale(@NativeType("GLFWwindow *") long paramLong, @NativeType("float *") float[] paramArrayOffloat1, @NativeType("float *") float[] paramArrayOffloat2) {
/* 5225 */     long l = Functions.GetWindowContentScale;
/* 5226 */     if (Checks.CHECKS) {
/* 5227 */       Checks.check(paramLong);
/* 5228 */       Checks.checkSafe(paramArrayOffloat1, 1);
/* 5229 */       Checks.checkSafe(paramArrayOffloat2, 1);
/*      */     } 
/* 5231 */     JNI.invokePPPV(paramLong, paramArrayOffloat1, paramArrayOffloat2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glfwGetCursorPos(@NativeType("GLFWwindow *") long paramLong, @NativeType("double *") double[] paramArrayOfdouble1, @NativeType("double *") double[] paramArrayOfdouble2) {
/* 5236 */     long l = Functions.GetCursorPos;
/* 5237 */     if (Checks.CHECKS) {
/* 5238 */       Checks.check(paramLong);
/* 5239 */       Checks.checkSafe(paramArrayOfdouble1, 1);
/* 5240 */       Checks.checkSafe(paramArrayOfdouble2, 1);
/*      */     } 
/* 5242 */     JNI.invokePPPV(paramLong, paramArrayOfdouble1, paramArrayOfdouble2, l);
/*      */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFW.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */