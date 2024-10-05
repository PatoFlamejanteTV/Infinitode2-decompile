/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
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
/*     */ public final class WGLCapabilities
/*     */ {
/*     */   public final long wglGetGPUIDsAMD;
/*     */   public final long wglGetGPUInfoAMD;
/*     */   public final long wglGetContextGPUIDAMD;
/*     */   public final long wglCreateAssociatedContextAMD;
/*     */   public final long wglCreateAssociatedContextAttribsAMD;
/*     */   public final long wglDeleteAssociatedContextAMD;
/*     */   public final long wglMakeAssociatedContextCurrentAMD;
/*     */   public final long wglGetCurrentAssociatedContextAMD;
/*     */   public final long wglBlitContextFramebufferAMD;
/*     */   public final long wglCreateBufferRegionARB;
/*     */   public final long wglDeleteBufferRegionARB;
/*     */   public final long wglSaveBufferRegionARB;
/*     */   public final long wglRestoreBufferRegionARB;
/*     */   public final long wglCreateContextAttribsARB;
/*     */   public final long wglGetExtensionsStringARB;
/*     */   public final long wglMakeContextCurrentARB;
/*     */   public final long wglGetCurrentReadDCARB;
/*     */   public final long wglCreatePbufferARB;
/*     */   public final long wglGetPbufferDCARB;
/*     */   public final long wglReleasePbufferDCARB;
/*     */   public final long wglDestroyPbufferARB;
/*     */   public final long wglQueryPbufferARB;
/*     */   public final long wglGetPixelFormatAttribivARB;
/*     */   public final long wglGetPixelFormatAttribfvARB;
/*     */   public final long wglChoosePixelFormatARB;
/*     */   public final long wglBindTexImageARB;
/*     */   public final long wglReleaseTexImageARB;
/*     */   public final long wglSetPbufferAttribARB;
/*     */   public final long wglGetExtensionsStringEXT;
/*     */   public final long wglSwapIntervalEXT;
/*     */   public final long wglGetSwapIntervalEXT;
/*     */   public final long wglCopyImageSubDataNV;
/*     */   public final long wglDelayBeforeSwapNV;
/*     */   public final long wglDXSetResourceShareHandleNV;
/*     */   public final long wglDXOpenDeviceNV;
/*     */   public final long wglDXCloseDeviceNV;
/*     */   public final long wglDXRegisterObjectNV;
/*     */   public final long wglDXUnregisterObjectNV;
/*     */   public final long wglDXObjectAccessNV;
/*     */   public final long wglDXLockObjectsNV;
/*     */   public final long wglDXUnlockObjectsNV;
/*     */   public final long wglEnumGpusNV;
/*     */   public final long wglEnumGpuDevicesNV;
/*     */   public final long wglCreateAffinityDCNV;
/*     */   public final long wglEnumGpusFromAffinityDCNV;
/*     */   public final long wglDeleteDCNV;
/*     */   public final long wglJoinSwapGroupNV;
/*     */   public final long wglBindSwapBarrierNV;
/*     */   public final long wglQuerySwapGroupNV;
/*     */   public final long wglQueryMaxSwapGroupsNV;
/*     */   public final long wglQueryFrameCountNV;
/*     */   public final long wglResetFrameCountNV;
/*     */   public final long wglAllocateMemoryNV;
/*     */   public final long wglFreeMemoryNV;
/*     */   public final boolean WGL_AMD_gpu_association;
/*     */   public final boolean WGL_ARB_buffer_region;
/*     */   public final boolean WGL_ARB_context_flush_control;
/*     */   public final boolean WGL_ARB_create_context;
/*     */   public final boolean WGL_ARB_create_context_no_error;
/*     */   public final boolean WGL_ARB_create_context_profile;
/*     */   public final boolean WGL_ARB_create_context_robustness;
/*     */   public final boolean WGL_ARB_extensions_string;
/*     */   public final boolean WGL_ARB_framebuffer_sRGB;
/*     */   public final boolean WGL_ARB_make_current_read;
/*     */   public final boolean WGL_ARB_multisample;
/*     */   public final boolean WGL_ARB_pbuffer;
/*     */   public final boolean WGL_ARB_pixel_format;
/*     */   public final boolean WGL_ARB_pixel_format_float;
/*     */   public final boolean WGL_ARB_render_texture;
/*     */   public final boolean WGL_ARB_robustness_application_isolation;
/*     */   public final boolean WGL_ARB_robustness_share_group_isolation;
/*     */   public final boolean WGL_ATI_pixel_format_float;
/*     */   public final boolean WGL_ATI_render_texture_rectangle;
/*     */   public final boolean WGL_EXT_colorspace;
/*     */   public final boolean WGL_EXT_create_context_es2_profile;
/*     */   public final boolean WGL_EXT_create_context_es_profile;
/*     */   public final boolean WGL_EXT_depth_float;
/*     */   public final boolean WGL_EXT_extensions_string;
/*     */   public final boolean WGL_EXT_framebuffer_sRGB;
/*     */   public final boolean WGL_EXT_pixel_format_packed_float;
/*     */   public final boolean WGL_EXT_swap_control;
/*     */   public final boolean WGL_EXT_swap_control_tear;
/*     */   public final boolean WGL_NV_copy_image;
/*     */   public final boolean WGL_NV_delay_before_swap;
/*     */   public final boolean WGL_NV_DX_interop;
/*     */   public final boolean WGL_NV_DX_interop2;
/*     */   public final boolean WGL_NV_float_buffer;
/*     */   public final boolean WGL_NV_gpu_affinity;
/*     */   public final boolean WGL_NV_multigpu_context;
/*     */   public final boolean WGL_NV_multisample_coverage;
/*     */   public final boolean WGL_NV_render_depth_texture;
/*     */   public final boolean WGL_NV_render_texture_rectangle;
/*     */   public final boolean WGL_NV_swap_group;
/*     */   public final boolean WGL_NV_vertex_array_range;
/*     */   
/*     */   WGLCapabilities(FunctionProvider paramFunctionProvider, Set<String> paramSet) {
/* 230 */     long[] arrayOfLong = new long[54];
/*     */     
/* 232 */     this.WGL_AMD_gpu_association = check_WGL_AMD_gpu_association(paramFunctionProvider, arrayOfLong, paramSet);
/* 233 */     this.WGL_ARB_buffer_region = check_WGL_ARB_buffer_region(paramFunctionProvider, arrayOfLong, paramSet);
/* 234 */     this.WGL_ARB_context_flush_control = paramSet.contains("WGL_ARB_context_flush_control");
/* 235 */     this.WGL_ARB_create_context = check_WGL_ARB_create_context(paramFunctionProvider, arrayOfLong, paramSet);
/* 236 */     this.WGL_ARB_create_context_no_error = paramSet.contains("WGL_ARB_create_context_no_error");
/* 237 */     this.WGL_ARB_create_context_profile = paramSet.contains("WGL_ARB_create_context_profile");
/* 238 */     this.WGL_ARB_create_context_robustness = paramSet.contains("WGL_ARB_create_context_robustness");
/* 239 */     this.WGL_ARB_extensions_string = check_WGL_ARB_extensions_string(paramFunctionProvider, arrayOfLong, paramSet);
/* 240 */     this.WGL_ARB_framebuffer_sRGB = paramSet.contains("WGL_ARB_framebuffer_sRGB");
/* 241 */     this.WGL_ARB_make_current_read = check_WGL_ARB_make_current_read(paramFunctionProvider, arrayOfLong, paramSet);
/* 242 */     this.WGL_ARB_multisample = paramSet.contains("WGL_ARB_multisample");
/* 243 */     this.WGL_ARB_pbuffer = check_WGL_ARB_pbuffer(paramFunctionProvider, arrayOfLong, paramSet);
/* 244 */     this.WGL_ARB_pixel_format = check_WGL_ARB_pixel_format(paramFunctionProvider, arrayOfLong, paramSet);
/* 245 */     this.WGL_ARB_pixel_format_float = paramSet.contains("WGL_ARB_pixel_format_float");
/* 246 */     this.WGL_ARB_render_texture = check_WGL_ARB_render_texture(paramFunctionProvider, arrayOfLong, paramSet);
/* 247 */     this.WGL_ARB_robustness_application_isolation = paramSet.contains("WGL_ARB_robustness_application_isolation");
/* 248 */     this.WGL_ARB_robustness_share_group_isolation = paramSet.contains("WGL_ARB_robustness_share_group_isolation");
/* 249 */     this.WGL_ATI_pixel_format_float = paramSet.contains("WGL_ATI_pixel_format_float");
/* 250 */     this.WGL_ATI_render_texture_rectangle = paramSet.contains("WGL_ATI_render_texture_rectangle");
/* 251 */     this.WGL_EXT_colorspace = paramSet.contains("WGL_EXT_colorspace");
/* 252 */     this.WGL_EXT_create_context_es2_profile = paramSet.contains("WGL_EXT_create_context_es2_profile");
/* 253 */     this.WGL_EXT_create_context_es_profile = paramSet.contains("WGL_EXT_create_context_es_profile");
/* 254 */     this.WGL_EXT_depth_float = paramSet.contains("WGL_EXT_depth_float");
/* 255 */     this.WGL_EXT_extensions_string = check_WGL_EXT_extensions_string(paramFunctionProvider, arrayOfLong, paramSet);
/* 256 */     this.WGL_EXT_framebuffer_sRGB = paramSet.contains("WGL_EXT_framebuffer_sRGB");
/* 257 */     this.WGL_EXT_pixel_format_packed_float = paramSet.contains("WGL_EXT_pixel_format_packed_float");
/* 258 */     this.WGL_EXT_swap_control = check_WGL_EXT_swap_control(paramFunctionProvider, arrayOfLong, paramSet);
/* 259 */     this.WGL_EXT_swap_control_tear = paramSet.contains("WGL_EXT_swap_control_tear");
/* 260 */     this.WGL_NV_copy_image = check_WGL_NV_copy_image(paramFunctionProvider, arrayOfLong, paramSet);
/* 261 */     this.WGL_NV_delay_before_swap = check_WGL_NV_delay_before_swap(paramFunctionProvider, arrayOfLong, paramSet);
/* 262 */     this.WGL_NV_DX_interop = check_WGL_NV_DX_interop(paramFunctionProvider, arrayOfLong, paramSet);
/* 263 */     this.WGL_NV_DX_interop2 = paramSet.contains("WGL_NV_DX_interop2");
/* 264 */     this.WGL_NV_float_buffer = paramSet.contains("WGL_NV_float_buffer");
/* 265 */     this.WGL_NV_gpu_affinity = check_WGL_NV_gpu_affinity(paramFunctionProvider, arrayOfLong, paramSet);
/* 266 */     this.WGL_NV_multigpu_context = paramSet.contains("WGL_NV_multigpu_context");
/* 267 */     this.WGL_NV_multisample_coverage = paramSet.contains("WGL_NV_multisample_coverage");
/* 268 */     this.WGL_NV_render_depth_texture = paramSet.contains("WGL_NV_render_depth_texture");
/* 269 */     this.WGL_NV_render_texture_rectangle = paramSet.contains("WGL_NV_render_texture_rectangle");
/* 270 */     this.WGL_NV_swap_group = check_WGL_NV_swap_group(paramFunctionProvider, arrayOfLong, paramSet);
/* 271 */     this.WGL_NV_vertex_array_range = check_WGL_NV_vertex_array_range(paramFunctionProvider, arrayOfLong, paramSet);
/*     */     
/* 273 */     this.wglGetGPUIDsAMD = arrayOfLong[0];
/* 274 */     this.wglGetGPUInfoAMD = arrayOfLong[1];
/* 275 */     this.wglGetContextGPUIDAMD = arrayOfLong[2];
/* 276 */     this.wglCreateAssociatedContextAMD = arrayOfLong[3];
/* 277 */     this.wglCreateAssociatedContextAttribsAMD = arrayOfLong[4];
/* 278 */     this.wglDeleteAssociatedContextAMD = arrayOfLong[5];
/* 279 */     this.wglMakeAssociatedContextCurrentAMD = arrayOfLong[6];
/* 280 */     this.wglGetCurrentAssociatedContextAMD = arrayOfLong[7];
/* 281 */     this.wglBlitContextFramebufferAMD = arrayOfLong[8];
/* 282 */     this.wglCreateBufferRegionARB = arrayOfLong[9];
/* 283 */     this.wglDeleteBufferRegionARB = arrayOfLong[10];
/* 284 */     this.wglSaveBufferRegionARB = arrayOfLong[11];
/* 285 */     this.wglRestoreBufferRegionARB = arrayOfLong[12];
/* 286 */     this.wglCreateContextAttribsARB = arrayOfLong[13];
/* 287 */     this.wglGetExtensionsStringARB = arrayOfLong[14];
/* 288 */     this.wglMakeContextCurrentARB = arrayOfLong[15];
/* 289 */     this.wglGetCurrentReadDCARB = arrayOfLong[16];
/* 290 */     this.wglCreatePbufferARB = arrayOfLong[17];
/* 291 */     this.wglGetPbufferDCARB = arrayOfLong[18];
/* 292 */     this.wglReleasePbufferDCARB = arrayOfLong[19];
/* 293 */     this.wglDestroyPbufferARB = arrayOfLong[20];
/* 294 */     this.wglQueryPbufferARB = arrayOfLong[21];
/* 295 */     this.wglGetPixelFormatAttribivARB = arrayOfLong[22];
/* 296 */     this.wglGetPixelFormatAttribfvARB = arrayOfLong[23];
/* 297 */     this.wglChoosePixelFormatARB = arrayOfLong[24];
/* 298 */     this.wglBindTexImageARB = arrayOfLong[25];
/* 299 */     this.wglReleaseTexImageARB = arrayOfLong[26];
/* 300 */     this.wglSetPbufferAttribARB = arrayOfLong[27];
/* 301 */     this.wglGetExtensionsStringEXT = arrayOfLong[28];
/* 302 */     this.wglSwapIntervalEXT = arrayOfLong[29];
/* 303 */     this.wglGetSwapIntervalEXT = arrayOfLong[30];
/* 304 */     this.wglCopyImageSubDataNV = arrayOfLong[31];
/* 305 */     this.wglDelayBeforeSwapNV = arrayOfLong[32];
/* 306 */     this.wglDXSetResourceShareHandleNV = arrayOfLong[33];
/* 307 */     this.wglDXOpenDeviceNV = arrayOfLong[34];
/* 308 */     this.wglDXCloseDeviceNV = arrayOfLong[35];
/* 309 */     this.wglDXRegisterObjectNV = arrayOfLong[36];
/* 310 */     this.wglDXUnregisterObjectNV = arrayOfLong[37];
/* 311 */     this.wglDXObjectAccessNV = arrayOfLong[38];
/* 312 */     this.wglDXLockObjectsNV = arrayOfLong[39];
/* 313 */     this.wglDXUnlockObjectsNV = arrayOfLong[40];
/* 314 */     this.wglEnumGpusNV = arrayOfLong[41];
/* 315 */     this.wglEnumGpuDevicesNV = arrayOfLong[42];
/* 316 */     this.wglCreateAffinityDCNV = arrayOfLong[43];
/* 317 */     this.wglEnumGpusFromAffinityDCNV = arrayOfLong[44];
/* 318 */     this.wglDeleteDCNV = arrayOfLong[45];
/* 319 */     this.wglJoinSwapGroupNV = arrayOfLong[46];
/* 320 */     this.wglBindSwapBarrierNV = arrayOfLong[47];
/* 321 */     this.wglQuerySwapGroupNV = arrayOfLong[48];
/* 322 */     this.wglQueryMaxSwapGroupsNV = arrayOfLong[49];
/* 323 */     this.wglQueryFrameCountNV = arrayOfLong[50];
/* 324 */     this.wglResetFrameCountNV = arrayOfLong[51];
/* 325 */     this.wglAllocateMemoryNV = arrayOfLong[52];
/* 326 */     this.wglFreeMemoryNV = arrayOfLong[53];
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_AMD_gpu_association(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 330 */     if (!paramSet.contains("WGL_AMD_gpu_association")) {
/* 331 */       return false;
/*     */     }
/*     */     
/* 334 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }, new String[] { "wglGetGPUIDsAMD", "wglGetGPUInfoAMD", "wglGetContextGPUIDAMD", "wglCreateAssociatedContextAMD", "wglCreateAssociatedContextAttribsAMD", "wglDeleteAssociatedContextAMD", "wglMakeAssociatedContextCurrentAMD", "wglGetCurrentAssociatedContextAMD"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 339 */         }) || Checks.reportMissing("WGL", "WGL_AMD_gpu_association")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_ARB_buffer_region(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 343 */     if (!paramSet.contains("WGL_ARB_buffer_region")) {
/* 344 */       return false;
/*     */     }
/*     */     
/* 347 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 9, 10, 11, 12 }, new String[] { "wglCreateBufferRegionARB", "wglDeleteBufferRegionARB", "wglSaveBufferRegionARB", "wglRestoreBufferRegionARB"
/*     */ 
/*     */ 
/*     */         
/* 351 */         }) || Checks.reportMissing("WGL", "WGL_ARB_buffer_region")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_ARB_create_context(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 355 */     if (!paramSet.contains("WGL_ARB_create_context")) {
/* 356 */       return false;
/*     */     }
/*     */     
/* 359 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 13 }, new String[] { "wglCreateContextAttribsARB"
/*     */ 
/*     */ 
/*     */         
/* 363 */         }) || Checks.reportMissing("WGL", "WGL_ARB_create_context")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_ARB_extensions_string(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 367 */     if (!paramSet.contains("WGL_ARB_extensions_string")) {
/* 368 */       return false;
/*     */     }
/*     */     
/* 371 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 14 }, new String[] { "wglGetExtensionsStringARB"
/*     */ 
/*     */ 
/*     */         
/* 375 */         }) || Checks.reportMissing("WGL", "WGL_ARB_extensions_string")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_ARB_make_current_read(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 379 */     if (!paramSet.contains("WGL_ARB_make_current_read")) {
/* 380 */       return false;
/*     */     }
/*     */     
/* 383 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 15, 16 }, new String[] { "wglMakeContextCurrentARB", "wglGetCurrentReadDCARB"
/*     */ 
/*     */ 
/*     */         
/* 387 */         }) || Checks.reportMissing("WGL", "WGL_ARB_make_current_read")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_ARB_pbuffer(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 391 */     if (!paramSet.contains("WGL_ARB_pbuffer")) {
/* 392 */       return false;
/*     */     }
/*     */     
/* 395 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 17, 18, 19, 20, 21 }, new String[] { "wglCreatePbufferARB", "wglGetPbufferDCARB", "wglReleasePbufferDCARB", "wglDestroyPbufferARB", "wglQueryPbufferARB"
/*     */ 
/*     */ 
/*     */         
/* 399 */         }) || Checks.reportMissing("WGL", "WGL_ARB_pbuffer")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_ARB_pixel_format(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 403 */     if (!paramSet.contains("WGL_ARB_pixel_format")) {
/* 404 */       return false;
/*     */     }
/*     */     
/* 407 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 22, 23, 24 }, new String[] { "wglGetPixelFormatAttribivARB", "wglGetPixelFormatAttribfvARB", "wglChoosePixelFormatARB"
/*     */ 
/*     */ 
/*     */         
/* 411 */         }) || Checks.reportMissing("WGL", "WGL_ARB_pixel_format")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_ARB_render_texture(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 415 */     if (!paramSet.contains("WGL_ARB_render_texture")) {
/* 416 */       return false;
/*     */     }
/*     */     
/* 419 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 25, 26, 27 }, new String[] { "wglBindTexImageARB", "wglReleaseTexImageARB", "wglSetPbufferAttribARB"
/*     */ 
/*     */ 
/*     */         
/* 423 */         }) || Checks.reportMissing("WGL", "WGL_ARB_render_texture")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_EXT_extensions_string(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 427 */     if (!paramSet.contains("WGL_EXT_extensions_string")) {
/* 428 */       return false;
/*     */     }
/*     */     
/* 431 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 28 }, new String[] { "wglGetExtensionsStringEXT"
/*     */ 
/*     */ 
/*     */         
/* 435 */         }) || Checks.reportMissing("WGL", "WGL_EXT_extensions_string")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_EXT_swap_control(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 439 */     if (!paramSet.contains("WGL_EXT_swap_control")) {
/* 440 */       return false;
/*     */     }
/*     */     
/* 443 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 29, 30 }, new String[] { "wglSwapIntervalEXT", "wglGetSwapIntervalEXT"
/*     */ 
/*     */ 
/*     */         
/* 447 */         }) || Checks.reportMissing("WGL", "WGL_EXT_swap_control")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_NV_copy_image(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 451 */     if (!paramSet.contains("WGL_NV_copy_image")) {
/* 452 */       return false;
/*     */     }
/*     */     
/* 455 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 31 }, new String[] { "wglCopyImageSubDataNV"
/*     */ 
/*     */ 
/*     */         
/* 459 */         }) || Checks.reportMissing("WGL", "WGL_NV_copy_image")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_NV_delay_before_swap(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 463 */     if (!paramSet.contains("WGL_NV_delay_before_swap")) {
/* 464 */       return false;
/*     */     }
/*     */     
/* 467 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 32 }, new String[] { "wglDelayBeforeSwapNV"
/*     */ 
/*     */ 
/*     */         
/* 471 */         }) || Checks.reportMissing("WGL", "WGL_NV_delay_before_swap")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_NV_DX_interop(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 475 */     if (!paramSet.contains("WGL_NV_DX_interop")) {
/* 476 */       return false;
/*     */     }
/*     */     
/* 479 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 33, 34, 35, 36, 37, 38, 39, 40 }, new String[] { "wglDXSetResourceShareHandleNV", "wglDXOpenDeviceNV", "wglDXCloseDeviceNV", "wglDXRegisterObjectNV", "wglDXUnregisterObjectNV", "wglDXObjectAccessNV", "wglDXLockObjectsNV", "wglDXUnlockObjectsNV"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 484 */         }) || Checks.reportMissing("WGL", "WGL_NV_DX_interop")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_NV_gpu_affinity(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 488 */     if (!paramSet.contains("WGL_NV_gpu_affinity")) {
/* 489 */       return false;
/*     */     }
/*     */     
/* 492 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 41, 42, 43, 44, 45 }, new String[] { "wglEnumGpusNV", "wglEnumGpuDevicesNV", "wglCreateAffinityDCNV", "wglEnumGpusFromAffinityDCNV", "wglDeleteDCNV"
/*     */ 
/*     */ 
/*     */         
/* 496 */         }) || Checks.reportMissing("WGL", "WGL_NV_gpu_affinity")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_NV_swap_group(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 500 */     if (!paramSet.contains("WGL_NV_swap_group")) {
/* 501 */       return false;
/*     */     }
/*     */     
/* 504 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 46, 47, 48, 49, 50, 51 }, new String[] { "wglJoinSwapGroupNV", "wglBindSwapBarrierNV", "wglQuerySwapGroupNV", "wglQueryMaxSwapGroupsNV", "wglQueryFrameCountNV", "wglResetFrameCountNV"
/*     */ 
/*     */ 
/*     */         
/* 508 */         }) || Checks.reportMissing("WGL", "WGL_NV_swap_group")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_WGL_NV_vertex_array_range(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 512 */     if (!paramSet.contains("WGL_NV_vertex_array_range")) {
/* 513 */       return false;
/*     */     }
/*     */     
/* 516 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 52, 53 }, new String[] { "wglAllocateMemoryNV", "wglFreeMemoryNV"
/*     */ 
/*     */ 
/*     */         
/* 520 */         }) || Checks.reportMissing("WGL", "WGL_NV_vertex_array_range")) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */