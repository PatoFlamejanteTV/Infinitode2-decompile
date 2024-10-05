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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GLXCapabilities
/*     */ {
/*     */   public final long glXQueryExtensionsString;
/*     */   public final long glXGetClientString;
/*     */   public final long glXQueryServerString;
/*     */   public final long glXGetCurrentDisplay;
/*     */   public final long glXGetFBConfigs;
/*     */   public final long glXChooseFBConfig;
/*     */   public final long glXGetFBConfigAttrib;
/*     */   public final long glXGetVisualFromFBConfig;
/*     */   public final long glXCreateWindow;
/*     */   public final long glXCreatePixmap;
/*     */   public final long glXDestroyPixmap;
/*     */   public final long glXCreatePbuffer;
/*     */   public final long glXDestroyPbuffer;
/*     */   public final long glXQueryDrawable;
/*     */   public final long glXCreateNewContext;
/*     */   public final long glXMakeContextCurrent;
/*     */   public final long glXGetCurrentReadDrawable;
/*     */   public final long glXQueryContext;
/*     */   public final long glXSelectEvent;
/*     */   public final long glXGetSelectedEvent;
/*     */   public final long glXGetProcAddress;
/*     */   public final long glXBlitContextFramebufferAMD;
/*     */   public final long glXCreateAssociatedContextAMD;
/*     */   public final long glXCreateAssociatedContextAttribsAMD;
/*     */   public final long glXDeleteAssociatedContextAMD;
/*     */   public final long glXGetContextGPUIDAMD;
/*     */   public final long glXGetCurrentAssociatedContextAMD;
/*     */   public final long glXGetGPUIDsAMD;
/*     */   public final long glXGetGPUInfoAMD;
/*     */   public final long glXMakeAssociatedContextCurrentAMD;
/*     */   public final long glXCreateContextAttribsARB;
/*     */   public final long glXGetProcAddressARB;
/*     */   public final long glXGetCurrentDisplayEXT;
/*     */   public final long glXQueryContextInfoEXT;
/*     */   public final long glXGetContextIDEXT;
/*     */   public final long glXImportContextEXT;
/*     */   public final long glXFreeContextEXT;
/*     */   public final long glXSwapIntervalEXT;
/*     */   public final long glXBindTexImageEXT;
/*     */   public final long glXReleaseTexImageEXT;
/*     */   public final long glXCopyBufferSubDataNV;
/*     */   public final long glXNamedCopyBufferSubDataNV;
/*     */   public final long glXCopyImageSubDataNV;
/*     */   public final long glXDelayBeforeSwapNV;
/*     */   public final long glXJoinSwapGroupNV;
/*     */   public final long glXBindSwapBarrierNV;
/*     */   public final long glXQuerySwapGroupNV;
/*     */   public final long glXQueryMaxSwapGroupsNV;
/*     */   public final long glXQueryFrameCountNV;
/*     */   public final long glXResetFrameCountNV;
/*     */   public final long glXMakeCurrentReadSGI;
/*     */   public final long glXGetCurrentReadDrawableSGI;
/*     */   public final long glXSwapIntervalSGI;
/*     */   public final long glXGetVideoSyncSGI;
/*     */   public final long glXWaitVideoSyncSGI;
/*     */   public final long glXGetFBConfigAttribSGIX;
/*     */   public final long glXChooseFBConfigSGIX;
/*     */   public final long glXCreateGLXPixmapWithConfigSGIX;
/*     */   public final long glXCreateContextWithConfigSGIX;
/*     */   public final long glXGetVisualFromFBConfigSGIX;
/*     */   public final long glXGetFBConfigFromVisualSGIX;
/*     */   public final long glXCreateGLXPbufferSGIX;
/*     */   public final long glXDestroyGLXPbufferSGIX;
/*     */   public final long glXQueryGLXPbufferSGIX;
/*     */   public final long glXSelectEventSGIX;
/*     */   public final long glXGetSelectedEventSGIX;
/*     */   public final long glXBindSwapBarrierSGIX;
/*     */   public final long glXQueryMaxSwapBarriersSGIX;
/*     */   public final long glXJoinSwapGroupSGIX;
/*     */   public final boolean GLX11;
/*     */   public final boolean GLX12;
/*     */   public final boolean GLX13;
/*     */   public final boolean GLX14;
/*     */   public final boolean GLX_AMD_gpu_association;
/*     */   public final boolean GLX_ARB_context_flush_control;
/*     */   public final boolean GLX_ARB_create_context;
/*     */   public final boolean GLX_ARB_create_context_no_error;
/*     */   public final boolean GLX_ARB_create_context_profile;
/*     */   public final boolean GLX_ARB_create_context_robustness;
/*     */   public final boolean GLX_ARB_fbconfig_float;
/*     */   public final boolean GLX_ARB_framebuffer_sRGB;
/*     */   public final boolean GLX_ARB_get_proc_address;
/*     */   public final boolean GLX_ARB_multisample;
/*     */   public final boolean GLX_ARB_robustness_application_isolation;
/*     */   public final boolean GLX_ARB_robustness_share_group_isolation;
/*     */   public final boolean GLX_ARB_vertex_buffer_object;
/*     */   public final boolean GLX_EXT_buffer_age;
/*     */   public final boolean GLX_EXT_context_priority;
/*     */   public final boolean GLX_EXT_create_context_es2_profile;
/*     */   public final boolean GLX_EXT_create_context_es_profile;
/*     */   public final boolean GLX_EXT_fbconfig_packed_float;
/*     */   public final boolean GLX_EXT_framebuffer_sRGB;
/*     */   public final boolean GLX_EXT_get_drawable_type;
/*     */   public final boolean GLX_EXT_import_context;
/*     */   public final boolean GLX_EXT_no_config_context;
/*     */   public final boolean GLX_EXT_stereo_tree;
/*     */   public final boolean GLX_EXT_swap_control;
/*     */   public final boolean GLX_EXT_swap_control_tear;
/*     */   public final boolean GLX_EXT_texture_from_pixmap;
/*     */   public final boolean GLX_EXT_visual_info;
/*     */   public final boolean GLX_EXT_visual_rating;
/*     */   public final boolean GLX_INTEL_swap_event;
/*     */   public final boolean GLX_NV_copy_buffer;
/*     */   public final boolean GLX_NV_copy_image;
/*     */   public final boolean GLX_NV_delay_before_swap;
/*     */   public final boolean GLX_NV_float_buffer;
/*     */   public final boolean GLX_NV_multigpu_context;
/*     */   public final boolean GLX_NV_multisample_coverage;
/*     */   public final boolean GLX_NV_robustness_video_memory_purge;
/*     */   public final boolean GLX_NV_swap_group;
/*     */   public final boolean GLX_SGI_make_current_read;
/*     */   public final boolean GLX_SGI_swap_control;
/*     */   public final boolean GLX_SGI_video_sync;
/*     */   public final boolean GLX_SGIX_fbconfig;
/*     */   public final boolean GLX_SGIX_pbuffer;
/*     */   public final boolean GLX_SGIX_swap_barrier;
/*     */   public final boolean GLX_SGIX_swap_group;
/*     */   
/*     */   GLXCapabilities(FunctionProvider paramFunctionProvider, Set<String> paramSet) {
/* 274 */     long[] arrayOfLong = new long[69];
/*     */     
/* 276 */     this.GLX11 = check_GLX11(paramFunctionProvider, arrayOfLong, paramSet);
/* 277 */     this.GLX12 = check_GLX12(paramFunctionProvider, arrayOfLong, paramSet);
/* 278 */     this.GLX13 = check_GLX13(paramFunctionProvider, arrayOfLong, paramSet);
/* 279 */     this.GLX14 = check_GLX14(paramFunctionProvider, arrayOfLong, paramSet);
/* 280 */     this.GLX_AMD_gpu_association = check_GLX_AMD_gpu_association(paramFunctionProvider, arrayOfLong, paramSet);
/* 281 */     this.GLX_ARB_context_flush_control = paramSet.contains("GLX_ARB_context_flush_control");
/* 282 */     this.GLX_ARB_create_context = check_GLX_ARB_create_context(paramFunctionProvider, arrayOfLong, paramSet);
/* 283 */     this.GLX_ARB_create_context_no_error = paramSet.contains("GLX_ARB_create_context_no_error");
/* 284 */     this.GLX_ARB_create_context_profile = paramSet.contains("GLX_ARB_create_context_profile");
/* 285 */     this.GLX_ARB_create_context_robustness = paramSet.contains("GLX_ARB_create_context_robustness");
/* 286 */     this.GLX_ARB_fbconfig_float = paramSet.contains("GLX_ARB_fbconfig_float");
/* 287 */     this.GLX_ARB_framebuffer_sRGB = paramSet.contains("GLX_ARB_framebuffer_sRGB");
/* 288 */     this.GLX_ARB_get_proc_address = check_GLX_ARB_get_proc_address(paramFunctionProvider, arrayOfLong, paramSet);
/* 289 */     this.GLX_ARB_multisample = paramSet.contains("GLX_ARB_multisample");
/* 290 */     this.GLX_ARB_robustness_application_isolation = paramSet.contains("GLX_ARB_robustness_application_isolation");
/* 291 */     this.GLX_ARB_robustness_share_group_isolation = paramSet.contains("GLX_ARB_robustness_share_group_isolation");
/* 292 */     this.GLX_ARB_vertex_buffer_object = paramSet.contains("GLX_ARB_vertex_buffer_object");
/* 293 */     this.GLX_EXT_buffer_age = paramSet.contains("GLX_EXT_buffer_age");
/* 294 */     this.GLX_EXT_context_priority = paramSet.contains("GLX_EXT_context_priority");
/* 295 */     this.GLX_EXT_create_context_es2_profile = paramSet.contains("GLX_EXT_create_context_es2_profile");
/* 296 */     this.GLX_EXT_create_context_es_profile = paramSet.contains("GLX_EXT_create_context_es_profile");
/* 297 */     this.GLX_EXT_fbconfig_packed_float = paramSet.contains("GLX_EXT_fbconfig_packed_float");
/* 298 */     this.GLX_EXT_framebuffer_sRGB = paramSet.contains("GLX_EXT_framebuffer_sRGB");
/* 299 */     this.GLX_EXT_get_drawable_type = paramSet.contains("GLX_EXT_get_drawable_type");
/* 300 */     this.GLX_EXT_import_context = check_GLX_EXT_import_context(paramFunctionProvider, arrayOfLong, paramSet);
/* 301 */     this.GLX_EXT_no_config_context = paramSet.contains("GLX_EXT_no_config_context");
/* 302 */     this.GLX_EXT_stereo_tree = paramSet.contains("GLX_EXT_stereo_tree");
/* 303 */     this.GLX_EXT_swap_control = check_GLX_EXT_swap_control(paramFunctionProvider, arrayOfLong, paramSet);
/* 304 */     this.GLX_EXT_swap_control_tear = paramSet.contains("GLX_EXT_swap_control_tear");
/* 305 */     this.GLX_EXT_texture_from_pixmap = check_GLX_EXT_texture_from_pixmap(paramFunctionProvider, arrayOfLong, paramSet);
/* 306 */     this.GLX_EXT_visual_info = paramSet.contains("GLX_EXT_visual_info");
/* 307 */     this.GLX_EXT_visual_rating = paramSet.contains("GLX_EXT_visual_rating");
/* 308 */     this.GLX_INTEL_swap_event = paramSet.contains("GLX_INTEL_swap_event");
/* 309 */     this.GLX_NV_copy_buffer = check_GLX_NV_copy_buffer(paramFunctionProvider, arrayOfLong, paramSet);
/* 310 */     this.GLX_NV_copy_image = check_GLX_NV_copy_image(paramFunctionProvider, arrayOfLong, paramSet);
/* 311 */     this.GLX_NV_delay_before_swap = check_GLX_NV_delay_before_swap(paramFunctionProvider, arrayOfLong, paramSet);
/* 312 */     this.GLX_NV_float_buffer = paramSet.contains("GLX_NV_float_buffer");
/* 313 */     this.GLX_NV_multigpu_context = paramSet.contains("GLX_NV_multigpu_context");
/* 314 */     this.GLX_NV_multisample_coverage = paramSet.contains("GLX_NV_multisample_coverage");
/* 315 */     this.GLX_NV_robustness_video_memory_purge = paramSet.contains("GLX_NV_robustness_video_memory_purge");
/* 316 */     this.GLX_NV_swap_group = check_GLX_NV_swap_group(paramFunctionProvider, arrayOfLong, paramSet);
/* 317 */     this.GLX_SGI_make_current_read = check_GLX_SGI_make_current_read(paramFunctionProvider, arrayOfLong, paramSet);
/* 318 */     this.GLX_SGI_swap_control = check_GLX_SGI_swap_control(paramFunctionProvider, arrayOfLong, paramSet);
/* 319 */     this.GLX_SGI_video_sync = check_GLX_SGI_video_sync(paramFunctionProvider, arrayOfLong, paramSet);
/* 320 */     this.GLX_SGIX_fbconfig = check_GLX_SGIX_fbconfig(paramFunctionProvider, arrayOfLong, paramSet);
/* 321 */     this.GLX_SGIX_pbuffer = check_GLX_SGIX_pbuffer(paramFunctionProvider, arrayOfLong, paramSet);
/* 322 */     this.GLX_SGIX_swap_barrier = check_GLX_SGIX_swap_barrier(paramFunctionProvider, arrayOfLong, paramSet);
/* 323 */     this.GLX_SGIX_swap_group = check_GLX_SGIX_swap_group(paramFunctionProvider, arrayOfLong, paramSet);
/*     */     
/* 325 */     this.glXQueryExtensionsString = arrayOfLong[0];
/* 326 */     this.glXGetClientString = arrayOfLong[1];
/* 327 */     this.glXQueryServerString = arrayOfLong[2];
/* 328 */     this.glXGetCurrentDisplay = arrayOfLong[3];
/* 329 */     this.glXGetFBConfigs = arrayOfLong[4];
/* 330 */     this.glXChooseFBConfig = arrayOfLong[5];
/* 331 */     this.glXGetFBConfigAttrib = arrayOfLong[6];
/* 332 */     this.glXGetVisualFromFBConfig = arrayOfLong[7];
/* 333 */     this.glXCreateWindow = arrayOfLong[8];
/* 334 */     this.glXCreatePixmap = arrayOfLong[9];
/* 335 */     this.glXDestroyPixmap = arrayOfLong[10];
/* 336 */     this.glXCreatePbuffer = arrayOfLong[11];
/* 337 */     this.glXDestroyPbuffer = arrayOfLong[12];
/* 338 */     this.glXQueryDrawable = arrayOfLong[13];
/* 339 */     this.glXCreateNewContext = arrayOfLong[14];
/* 340 */     this.glXMakeContextCurrent = arrayOfLong[15];
/* 341 */     this.glXGetCurrentReadDrawable = arrayOfLong[16];
/* 342 */     this.glXQueryContext = arrayOfLong[17];
/* 343 */     this.glXSelectEvent = arrayOfLong[18];
/* 344 */     this.glXGetSelectedEvent = arrayOfLong[19];
/* 345 */     this.glXGetProcAddress = arrayOfLong[20];
/* 346 */     this.glXBlitContextFramebufferAMD = arrayOfLong[21];
/* 347 */     this.glXCreateAssociatedContextAMD = arrayOfLong[22];
/* 348 */     this.glXCreateAssociatedContextAttribsAMD = arrayOfLong[23];
/* 349 */     this.glXDeleteAssociatedContextAMD = arrayOfLong[24];
/* 350 */     this.glXGetContextGPUIDAMD = arrayOfLong[25];
/* 351 */     this.glXGetCurrentAssociatedContextAMD = arrayOfLong[26];
/* 352 */     this.glXGetGPUIDsAMD = arrayOfLong[27];
/* 353 */     this.glXGetGPUInfoAMD = arrayOfLong[28];
/* 354 */     this.glXMakeAssociatedContextCurrentAMD = arrayOfLong[29];
/* 355 */     this.glXCreateContextAttribsARB = arrayOfLong[30];
/* 356 */     this.glXGetProcAddressARB = arrayOfLong[31];
/* 357 */     this.glXGetCurrentDisplayEXT = arrayOfLong[32];
/* 358 */     this.glXQueryContextInfoEXT = arrayOfLong[33];
/* 359 */     this.glXGetContextIDEXT = arrayOfLong[34];
/* 360 */     this.glXImportContextEXT = arrayOfLong[35];
/* 361 */     this.glXFreeContextEXT = arrayOfLong[36];
/* 362 */     this.glXSwapIntervalEXT = arrayOfLong[37];
/* 363 */     this.glXBindTexImageEXT = arrayOfLong[38];
/* 364 */     this.glXReleaseTexImageEXT = arrayOfLong[39];
/* 365 */     this.glXCopyBufferSubDataNV = arrayOfLong[40];
/* 366 */     this.glXNamedCopyBufferSubDataNV = arrayOfLong[41];
/* 367 */     this.glXCopyImageSubDataNV = arrayOfLong[42];
/* 368 */     this.glXDelayBeforeSwapNV = arrayOfLong[43];
/* 369 */     this.glXJoinSwapGroupNV = arrayOfLong[44];
/* 370 */     this.glXBindSwapBarrierNV = arrayOfLong[45];
/* 371 */     this.glXQuerySwapGroupNV = arrayOfLong[46];
/* 372 */     this.glXQueryMaxSwapGroupsNV = arrayOfLong[47];
/* 373 */     this.glXQueryFrameCountNV = arrayOfLong[48];
/* 374 */     this.glXResetFrameCountNV = arrayOfLong[49];
/* 375 */     this.glXMakeCurrentReadSGI = arrayOfLong[50];
/* 376 */     this.glXGetCurrentReadDrawableSGI = arrayOfLong[51];
/* 377 */     this.glXSwapIntervalSGI = arrayOfLong[52];
/* 378 */     this.glXGetVideoSyncSGI = arrayOfLong[53];
/* 379 */     this.glXWaitVideoSyncSGI = arrayOfLong[54];
/* 380 */     this.glXGetFBConfigAttribSGIX = arrayOfLong[55];
/* 381 */     this.glXChooseFBConfigSGIX = arrayOfLong[56];
/* 382 */     this.glXCreateGLXPixmapWithConfigSGIX = arrayOfLong[57];
/* 383 */     this.glXCreateContextWithConfigSGIX = arrayOfLong[58];
/* 384 */     this.glXGetVisualFromFBConfigSGIX = arrayOfLong[59];
/* 385 */     this.glXGetFBConfigFromVisualSGIX = arrayOfLong[60];
/* 386 */     this.glXCreateGLXPbufferSGIX = arrayOfLong[61];
/* 387 */     this.glXDestroyGLXPbufferSGIX = arrayOfLong[62];
/* 388 */     this.glXQueryGLXPbufferSGIX = arrayOfLong[63];
/* 389 */     this.glXSelectEventSGIX = arrayOfLong[64];
/* 390 */     this.glXGetSelectedEventSGIX = arrayOfLong[65];
/* 391 */     this.glXBindSwapBarrierSGIX = arrayOfLong[66];
/* 392 */     this.glXQueryMaxSwapBarriersSGIX = arrayOfLong[67];
/* 393 */     this.glXJoinSwapGroupSGIX = arrayOfLong[68];
/*     */   }
/*     */   
/*     */   private static boolean check_GLX11(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 397 */     if (!paramSet.contains("GLX11")) {
/* 398 */       return false;
/*     */     }
/*     */     
/* 401 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 0, 1, 2 }, new String[] { "glXQueryExtensionsString", "glXGetClientString", "glXQueryServerString"
/*     */ 
/*     */ 
/*     */         
/* 405 */         }) || Checks.reportMissing("GLX", "GLX11")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX12(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 409 */     if (!paramSet.contains("GLX12")) {
/* 410 */       return false;
/*     */     }
/*     */     
/* 413 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 3 }, new String[] { "glXGetCurrentDisplay"
/*     */ 
/*     */ 
/*     */         
/* 417 */         }) || Checks.reportMissing("GLX", "GLX12")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX13(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 421 */     if (!paramSet.contains("GLX13")) {
/* 422 */       return false;
/*     */     }
/*     */     
/* 425 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 }, new String[] { "glXGetFBConfigs", "glXChooseFBConfig", "glXGetFBConfigAttrib", "glXGetVisualFromFBConfig", "glXCreateWindow", "glXCreatePixmap", "glXDestroyPixmap", "glXCreatePbuffer", "glXDestroyPbuffer", "glXQueryDrawable", "glXCreateNewContext", "glXMakeContextCurrent", "glXGetCurrentReadDrawable", "glXQueryContext", "glXSelectEvent", "glXGetSelectedEvent"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 431 */         }) || Checks.reportMissing("GLX", "GLX13")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX14(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 435 */     if (!paramSet.contains("GLX14")) {
/* 436 */       return false;
/*     */     }
/*     */     
/* 439 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 20 }, new String[] { "glXGetProcAddress"
/*     */ 
/*     */ 
/*     */         
/* 443 */         }) || Checks.reportMissing("GLX", "GLX14")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_AMD_gpu_association(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 447 */     if (!paramSet.contains("GLX_AMD_gpu_association")) {
/* 448 */       return false;
/*     */     }
/*     */     
/* 451 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 21, 22, 23, 24, 25, 26, 27, 28, 29 }, new String[] { "glXBlitContextFramebufferAMD", "glXCreateAssociatedContextAMD", "glXCreateAssociatedContextAttribsAMD", "glXDeleteAssociatedContextAMD", "glXGetContextGPUIDAMD", "glXGetCurrentAssociatedContextAMD", "glXGetGPUIDsAMD", "glXGetGPUInfoAMD", "glXMakeAssociatedContextCurrentAMD"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 456 */         }) || Checks.reportMissing("GLX", "GLX_AMD_gpu_association")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_ARB_create_context(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 460 */     if (!paramSet.contains("GLX_ARB_create_context")) {
/* 461 */       return false;
/*     */     }
/*     */     
/* 464 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 30 }, new String[] { "glXCreateContextAttribsARB"
/*     */ 
/*     */ 
/*     */         
/* 468 */         }) || Checks.reportMissing("GLX", "GLX_ARB_create_context")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_ARB_get_proc_address(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 472 */     if (!paramSet.contains("GLX_ARB_get_proc_address")) {
/* 473 */       return false;
/*     */     }
/*     */     
/* 476 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 31 }, new String[] { "glXGetProcAddressARB"
/*     */ 
/*     */ 
/*     */         
/* 480 */         }) || Checks.reportMissing("GLX", "GLX_ARB_get_proc_address")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_EXT_import_context(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 484 */     if (!paramSet.contains("GLX_EXT_import_context")) {
/* 485 */       return false;
/*     */     }
/*     */     
/* 488 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 32, 33, 34, 35, 36 }, new String[] { "glXGetCurrentDisplayEXT", "glXQueryContextInfoEXT", "glXGetContextIDEXT", "glXImportContextEXT", "glXFreeContextEXT"
/*     */ 
/*     */ 
/*     */         
/* 492 */         }) || Checks.reportMissing("GLX", "GLX_EXT_import_context")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_EXT_swap_control(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 496 */     if (!paramSet.contains("GLX_EXT_swap_control")) {
/* 497 */       return false;
/*     */     }
/*     */     
/* 500 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 37 }, new String[] { "glXSwapIntervalEXT"
/*     */ 
/*     */ 
/*     */         
/* 504 */         }) || Checks.reportMissing("GLX", "GLX_EXT_swap_control")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_EXT_texture_from_pixmap(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 508 */     if (!paramSet.contains("GLX_EXT_texture_from_pixmap")) {
/* 509 */       return false;
/*     */     }
/*     */     
/* 512 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 38, 39 }, new String[] { "glXBindTexImageEXT", "glXReleaseTexImageEXT"
/*     */ 
/*     */ 
/*     */         
/* 516 */         }) || Checks.reportMissing("GLX", "GLX_EXT_texture_from_pixmap")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_NV_copy_buffer(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 520 */     if (!paramSet.contains("GLX_NV_copy_buffer")) {
/* 521 */       return false;
/*     */     }
/*     */     
/* 524 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 40, 41 }, new String[] { "glXCopyBufferSubDataNV", "glXNamedCopyBufferSubDataNV"
/*     */ 
/*     */ 
/*     */         
/* 528 */         }) || Checks.reportMissing("GLX", "GLX_NV_copy_buffer")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_NV_copy_image(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 532 */     if (!paramSet.contains("GLX_NV_copy_image")) {
/* 533 */       return false;
/*     */     }
/*     */     
/* 536 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 42 }, new String[] { "glXCopyImageSubDataNV"
/*     */ 
/*     */ 
/*     */         
/* 540 */         }) || Checks.reportMissing("GLX", "GLX_NV_copy_image")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_NV_delay_before_swap(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 544 */     if (!paramSet.contains("GLX_NV_delay_before_swap")) {
/* 545 */       return false;
/*     */     }
/*     */     
/* 548 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 43 }, new String[] { "glXDelayBeforeSwapNV"
/*     */ 
/*     */ 
/*     */         
/* 552 */         }) || Checks.reportMissing("GLX", "GLX_NV_delay_before_swap")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_NV_swap_group(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 556 */     if (!paramSet.contains("GLX_NV_swap_group")) {
/* 557 */       return false;
/*     */     }
/*     */     
/* 560 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 44, 45, 46, 47, 48, 49 }, new String[] { "glXJoinSwapGroupNV", "glXBindSwapBarrierNV", "glXQuerySwapGroupNV", "glXQueryMaxSwapGroupsNV", "glXQueryFrameCountNV", "glXResetFrameCountNV"
/*     */ 
/*     */ 
/*     */         
/* 564 */         }) || Checks.reportMissing("GLX", "GLX_NV_swap_group")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_SGI_make_current_read(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 568 */     if (!paramSet.contains("GLX_SGI_make_current_read")) {
/* 569 */       return false;
/*     */     }
/*     */     
/* 572 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 50, 51 }, new String[] { "glXMakeCurrentReadSGI", "glXGetCurrentReadDrawableSGI"
/*     */ 
/*     */ 
/*     */         
/* 576 */         }) || Checks.reportMissing("GLX", "GLX_SGI_make_current_read")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_SGI_swap_control(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 580 */     if (!paramSet.contains("GLX_SGI_swap_control")) {
/* 581 */       return false;
/*     */     }
/*     */     
/* 584 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 52 }, new String[] { "glXSwapIntervalSGI"
/*     */ 
/*     */ 
/*     */         
/* 588 */         }) || Checks.reportMissing("GLX", "GLX_SGI_swap_control")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_SGI_video_sync(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 592 */     if (!paramSet.contains("GLX_SGI_video_sync")) {
/* 593 */       return false;
/*     */     }
/*     */     
/* 596 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 53, 54 }, new String[] { "glXGetVideoSyncSGI", "glXWaitVideoSyncSGI"
/*     */ 
/*     */ 
/*     */         
/* 600 */         }) || Checks.reportMissing("GLX", "GLX_SGI_video_sync")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_SGIX_fbconfig(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 604 */     if (!paramSet.contains("GLX_SGIX_fbconfig")) {
/* 605 */       return false;
/*     */     }
/*     */     
/* 608 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 55, 56, 57, 58, 59, 60 }, new String[] { "glXGetFBConfigAttribSGIX", "glXChooseFBConfigSGIX", "glXCreateGLXPixmapWithConfigSGIX", "glXCreateContextWithConfigSGIX", "glXGetVisualFromFBConfigSGIX", "glXGetFBConfigFromVisualSGIX"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 613 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_fbconfig")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_SGIX_pbuffer(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 617 */     if (!paramSet.contains("GLX_SGIX_pbuffer")) {
/* 618 */       return false;
/*     */     }
/*     */     
/* 621 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 61, 62, 63, 64, 65 }, new String[] { "glXCreateGLXPbufferSGIX", "glXDestroyGLXPbufferSGIX", "glXQueryGLXPbufferSGIX", "glXSelectEventSGIX", "glXGetSelectedEventSGIX"
/*     */ 
/*     */ 
/*     */         
/* 625 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_pbuffer")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_SGIX_swap_barrier(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 629 */     if (!paramSet.contains("GLX_SGIX_swap_barrier")) {
/* 630 */       return false;
/*     */     }
/*     */     
/* 633 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 66, 67 }, new String[] { "glXBindSwapBarrierSGIX", "glXQueryMaxSwapBarriersSGIX"
/*     */ 
/*     */ 
/*     */         
/* 637 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_swap_barrier")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_GLX_SGIX_swap_group(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, Set<String> paramSet) {
/* 641 */     if (!paramSet.contains("GLX_SGIX_swap_group")) {
/* 642 */       return false;
/*     */     }
/*     */     
/* 645 */     if (Checks.checkFunctions(paramFunctionProvider, paramArrayOflong, new int[] { 68 }, new String[] { "glXJoinSwapGroupSGIX"
/*     */ 
/*     */ 
/*     */         
/* 649 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_swap_group")) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */