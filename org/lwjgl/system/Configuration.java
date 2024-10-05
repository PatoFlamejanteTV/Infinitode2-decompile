/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.util.function.Function;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Configuration<T>
/*     */ {
/*  30 */   public static final Configuration<String> LIBRARY_PATH = new Configuration("org.lwjgl.librarypath", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   public static final Configuration<Object> BUNDLED_LIBRARY_NAME_MAPPER = new Configuration("org.lwjgl.system.bundledLibrary.nameMapper", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static final Configuration<Object> BUNDLED_LIBRARY_PATH_MAPPER = new Configuration("org.lwjgl.system.bundledLibrary.pathMapper", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public static final Configuration<String> SHARED_LIBRARY_EXTRACT_DIRECTORY = new Configuration("org.lwjgl.system.SharedLibraryExtractDirectory", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public static final Configuration<String> SHARED_LIBRARY_EXTRACT_PATH = new Configuration("org.lwjgl.system.SharedLibraryExtractPath", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   public static final Configuration<Boolean> SHARED_LIBRARY_EXTRACT_FORCE = new Configuration("org.lwjgl.system.SharedLibraryExtractForce", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public static final Configuration<Boolean> EMULATE_SYSTEM_LOADLIBRARY = new Configuration("org.lwjgl.system.EmulateSystemLoadLibrary", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public static final Configuration<String> LIBRARY_NAME = new Configuration("org.lwjgl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   public static final Configuration<Object> MEMORY_ALLOCATOR = new Configuration("org.lwjgl.system.allocator", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 182 */   public static final Configuration<Integer> STACK_SIZE = new Configuration("org.lwjgl.system.stackSize", (StateInit)StateInit.INT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 196 */   public static final Configuration<Integer> ARRAY_TLC_SIZE = new Configuration("org.lwjgl.system.arrayTLCSize", (StateInit)StateInit.INT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 215 */   public static final Configuration<Integer> JNI_NATIVE_INTERFACE_FUNCTION_COUNT = new Configuration("org.lwjgl.system.JNINativeInterfaceSize", (StateInit)StateInit.INT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 227 */   public static final Configuration<Boolean> DISABLE_CHECKS = new Configuration("org.lwjgl.util.NoChecks", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 239 */   public static final Configuration<Boolean> DISABLE_FUNCTION_CHECKS = new Configuration("org.lwjgl.util.NoFunctionChecks", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 251 */   public static final Configuration<Boolean> DEBUG = new Configuration("org.lwjgl.util.Debug", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 262 */   public static final Configuration<Boolean> DEBUG_LOADER = new Configuration("org.lwjgl.util.DebugLoader", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 277 */   public static final Configuration<Object> DEBUG_STREAM = new Configuration("org.lwjgl.util.DebugStream", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 292 */   public static final Configuration<Boolean> DEBUG_MEMORY_ALLOCATOR = new Configuration("org.lwjgl.util.DebugAllocator", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 303 */   public static final Configuration<Boolean> DEBUG_MEMORY_ALLOCATOR_INTERNAL = new Configuration("org.lwjgl.util.DebugAllocator.internal", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 324 */   public static final Configuration<Boolean> DEBUG_MEMORY_ALLOCATOR_FAST = new Configuration("org.lwjgl.util.DebugAllocator.fast", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 339 */   public static final Configuration<Boolean> DEBUG_STACK = new Configuration("org.lwjgl.util.DebugStack", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 352 */   public static final Configuration<Boolean> DEBUG_FUNCTIONS = new Configuration("org.lwjgl.util.DebugFunctions", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 357 */   public static final Configuration<String> ASSIMP_LIBRARY_NAME = new Configuration("org.lwjgl.assimp.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 360 */   public static final Configuration<String> ASSIMP_DRACO_LIBRARY_NAME = new Configuration("org.lwjgl.assimp.draco.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 365 */   public static final Configuration<String> BGFX_LIBRARY_NAME = new Configuration("org.lwjgl.bgfx.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 370 */   public static final Configuration<String> CUDA_LIBRARY_NAME = new Configuration("org.lwjgl.cuda.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 381 */   public static final Configuration<String> CUDA_TOOLKIT_VERSION = new Configuration("org.lwjgl.cuda.toolkit.version", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 392 */   public static final Configuration<String> CUDA_TOOLKIT_PATH = new Configuration("org.lwjgl.cuda.toolkit.path", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 395 */   public static final Configuration<String> CUDA_NVRTC_LIBRARY_NAME = new Configuration("org.lwjgl.cuda.nvrtc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 398 */   public static final Configuration<String> CUDA_NVRTC_BUILTINS_LIBRARY_NAME = new Configuration("org.lwjgl.cuda.nvrtc-builtins.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 410 */   public static final Configuration<Boolean> CUDA_API_PER_THREAD_DEFAULT_STREAM = new Configuration("org.lwjgl.cuda.ptds", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 423 */   public static final Configuration<Boolean> EGL_EXPLICIT_INIT = new Configuration("org.lwjgl.egl.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 426 */   public static final Configuration<String> EGL_LIBRARY_NAME = new Configuration("org.lwjgl.egl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 429 */   public static final Configuration<Object> EGL_EXTENSION_FILTER = new Configuration("org.lwjgl.egl.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 434 */   public static final Configuration<String> FMOD_LIBRARY_NAME = new Configuration("org.lwjgl.fmod.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 437 */   public static final Configuration<String> FMOD_STUDIO_LIBRARY_NAME = new Configuration("org.lwjgl.fmod.studio.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 440 */   public static final Configuration<String> FMOD_FSBANK_LIBRARY_NAME = new Configuration("org.lwjgl.fmod.fsbank.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */   
/* 444 */   public static final Configuration<String> FREETYPE_LIBRARY_NAME = new Configuration("org.lwjgl.freetype.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 449 */   public static final Configuration<String> GLFW_LIBRARY_NAME = new Configuration("org.lwjgl.glfw.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 463 */   public static final Configuration<Boolean> GLFW_CHECK_THREAD0 = new Configuration("org.lwjgl.glfw.checkThread0", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 487 */   public static final Configuration<Object> HARFBUZZ_LIBRARY_NAME = new Configuration("org.lwjgl.harfbuzz.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 492 */   public static final Configuration<String> HWLOC_LIBRARY_NAME = new Configuration("org.lwjgl.hwloc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 497 */   public static final Configuration<String> JAWT_LIBRARY_NAME = new Configuration("org.lwjgl.system.jawt.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 502 */   public static final Configuration<String> JEMALLOC_LIBRARY_NAME = new Configuration("org.lwjgl.system.jemalloc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 507 */   public static final Configuration<String> KTX_LIBRARY_NAME = new Configuration("org.lwjgl.ktx.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 512 */   public static final Configuration<String> LLVM_LIBRARY_NAME = new Configuration("org.lwjgl.llvm.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 515 */   public static final Configuration<String> LLVM_CLANG_LIBRARY_NAME = new Configuration("org.lwjgl.llvm.clang.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 518 */   public static final Configuration<String> LLVM_LTO_LIBRARY_NAME = new Configuration("org.lwjgl.llvm.lto.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 528 */   public static final Configuration<Boolean> NFD_LINUX_PORTAL = new Configuration("org.lwjgl.nfd.linux.portal", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 533 */   public static final Configuration<String> ODBC_LIBRARY_NAME = new Configuration("org.lwjgl.odbc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 538 */   public static final Configuration<Boolean> OPENAL_EXPLICIT_INIT = new Configuration("org.lwjgl.openal.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 541 */   public static final Configuration<String> OPENAL_LIBRARY_NAME = new Configuration("org.lwjgl.openal.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 544 */   public static final Configuration<Object> OPENAL_EXTENSION_FILTER = new Configuration("org.lwjgl.openal.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 549 */   public static final Configuration<Boolean> OPENCL_EXPLICIT_INIT = new Configuration("org.lwjgl.opencl.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 552 */   public static final Configuration<String> OPENCL_LIBRARY_NAME = new Configuration("org.lwjgl.opencl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 555 */   public static final Configuration<Object> OPENCL_EXTENSION_FILTER = new Configuration("org.lwjgl.opencl.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 560 */   public static final Configuration<Boolean> OPENGL_EXPLICIT_INIT = new Configuration("org.lwjgl.opengl.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 563 */   public static final Configuration<String> OPENGL_LIBRARY_NAME = new Configuration("org.lwjgl.opengl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 576 */   public static final Configuration<Object> OPENGL_MAXVERSION = new Configuration("org.lwjgl.opengl.maxVersion", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 593 */   public static final Configuration<Object> OPENGL_EXTENSION_FILTER = new Configuration("org.lwjgl.opengl.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 598 */   public static final Configuration<Boolean> OPENGLES_EXPLICIT_INIT = new Configuration("org.lwjgl.opengles.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 601 */   public static final Configuration<String> OPENGLES_LIBRARY_NAME = new Configuration("org.lwjgl.opengles.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 604 */   public static final Configuration<Object> OPENGLES_MAXVERSION = new Configuration("org.lwjgl.opengles.maxVersion", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 607 */   public static final Configuration<Object> OPENGLES_EXTENSION_FILTER = new Configuration("org.lwjgl.opengles.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 625 */   public static final Configuration<String> OPENGLES_CONTEXT_API = new Configuration("org.lwjgl.opengles.contextAPI", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 630 */   public static final Configuration<String> OPENVR_LIBRARY_NAME = new Configuration("org.lwjgl.openvr.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 635 */   public static final Configuration<Boolean> OPENXR_EXPLICIT_INIT = new Configuration("org.lwjgl.openxr.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 638 */   public static final Configuration<String> OPENXR_LIBRARY_NAME = new Configuration("org.lwjgl.openxr.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 643 */   public static final Configuration<String> OPUS_LIBRARY_NAME = new Configuration("org.lwjgl.opus.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 648 */   public static final Configuration<String> SHADERC_LIBRARY_NAME = new Configuration("org.lwjgl.shaderc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 653 */   public static final Configuration<String> SPVC_LIBRARY_NAME = new Configuration("org.lwjgl.spvc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 658 */   public static final Configuration<Boolean> VULKAN_EXPLICIT_INIT = new Configuration("org.lwjgl.vulkan.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */   private final String property;
/*     */   private volatile T state;
/* 661 */   public static final Configuration<String> VULKAN_LIBRARY_NAME = new Configuration("org.lwjgl.vulkan.libname", (StateInit)StateInit.STRING);
/*     */   
/*     */   private static interface StateInit<T> extends Function<String, T> { static {
/* 664 */       BOOLEAN = (param1String -> ((param1String = System.getProperty(param1String)) == null) ? null : Boolean.valueOf(Boolean.parseBoolean(param1String)));
/*     */     }
/*     */ 
/*     */     
/*     */     public static final StateInit<Boolean> BOOLEAN;
/* 669 */     public static final StateInit<Integer> INT = Integer::getInteger;
/*     */     
/* 671 */     public static final StateInit<String> STRING = System::getProperty; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Configuration(String paramString, StateInit<? extends T> paramStateInit) {
/* 680 */     this.property = paramString;
/* 681 */     this.state = paramStateInit.apply(paramString);
/*     */   }
/*     */   
/*     */   public String getProperty() {
/* 685 */     return this.property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(T paramT) {
/* 694 */     this.state = paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get() {
/* 704 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get(T paramT) {
/*     */     T t;
/* 716 */     if ((t = this.state) == null) {
/* 717 */       t = paramT;
/*     */     }
/*     */     
/* 720 */     return t;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\Configuration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */