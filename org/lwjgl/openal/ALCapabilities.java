/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.ThreadLocalUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ALCapabilities
/*     */ {
/*     */   public final long alGetError;
/*     */   public final long alEnable;
/*     */   public final long alDisable;
/*     */   public final long alIsEnabled;
/*     */   public final long alGetBoolean;
/*     */   public final long alGetInteger;
/*     */   public final long alGetFloat;
/*     */   public final long alGetDouble;
/*     */   public final long alGetBooleanv;
/*     */   public final long alGetIntegerv;
/*     */   public final long alGetFloatv;
/*     */   public final long alGetDoublev;
/*     */   public final long alGetString;
/*     */   public final long alDistanceModel;
/*     */   public final long alDopplerFactor;
/*     */   public final long alDopplerVelocity;
/*     */   public final long alListenerf;
/*     */   public final long alListeneri;
/*     */   public final long alListener3f;
/*     */   public final long alListenerfv;
/*     */   public final long alGetListenerf;
/*     */   public final long alGetListeneri;
/*     */   public final long alGetListener3f;
/*     */   public final long alGetListenerfv;
/*     */   public final long alGenSources;
/*     */   public final long alDeleteSources;
/*     */   public final long alIsSource;
/*     */   public final long alSourcef;
/*     */   public final long alSource3f;
/*     */   public final long alSourcefv;
/*     */   public final long alSourcei;
/*     */   public final long alGetSourcef;
/*     */   public final long alGetSource3f;
/*     */   public final long alGetSourcefv;
/*     */   public final long alGetSourcei;
/*     */   public final long alGetSourceiv;
/*     */   public final long alSourceQueueBuffers;
/*     */   public final long alSourceUnqueueBuffers;
/*     */   public final long alSourcePlay;
/*     */   public final long alSourcePause;
/*     */   public final long alSourceStop;
/*     */   public final long alSourceRewind;
/*     */   public final long alSourcePlayv;
/*     */   public final long alSourcePausev;
/*     */   public final long alSourceStopv;
/*     */   public final long alSourceRewindv;
/*     */   public final long alGenBuffers;
/*     */   public final long alDeleteBuffers;
/*     */   public final long alIsBuffer;
/*     */   public final long alGetBufferf;
/*     */   public final long alGetBufferi;
/*     */   public final long alBufferData;
/*     */   public final long alGetEnumValue;
/*     */   public final long alGetProcAddress;
/*     */   public final long alIsExtensionPresent;
/*     */   public final long alListener3i;
/*     */   public final long alGetListeneriv;
/*     */   public final long alSource3i;
/*     */   public final long alListeneriv;
/*     */   public final long alSourceiv;
/*     */   public final long alBufferf;
/*     */   public final long alBuffer3f;
/*     */   public final long alBufferfv;
/*     */   public final long alBufferi;
/*     */   public final long alBuffer3i;
/*     */   public final long alBufferiv;
/*     */   public final long alGetBufferiv;
/*     */   public final long alGetBufferfv;
/*     */   public final long alSpeedOfSound;
/*     */   public final long alGenEffects;
/*     */   public final long alDeleteEffects;
/*     */   public final long alIsEffect;
/*     */   public final long alEffecti;
/*     */   public final long alEffectiv;
/*     */   public final long alEffectf;
/*     */   public final long alEffectfv;
/*     */   public final long alGetEffecti;
/*     */   public final long alGetEffectiv;
/*     */   public final long alGetEffectf;
/*     */   public final long alGetEffectfv;
/*     */   public final long alGenFilters;
/*     */   public final long alDeleteFilters;
/*     */   public final long alIsFilter;
/*     */   public final long alFilteri;
/*     */   public final long alFilteriv;
/*     */   public final long alFilterf;
/*     */   public final long alFilterfv;
/*     */   public final long alGetFilteri;
/*     */   public final long alGetFilteriv;
/*     */   public final long alGetFilterf;
/*     */   public final long alGetFilterfv;
/*     */   public final long alGenAuxiliaryEffectSlots;
/*     */   public final long alDeleteAuxiliaryEffectSlots;
/*     */   public final long alIsAuxiliaryEffectSlot;
/*     */   public final long alAuxiliaryEffectSloti;
/*     */   public final long alAuxiliaryEffectSlotiv;
/*     */   public final long alAuxiliaryEffectSlotf;
/*     */   public final long alAuxiliaryEffectSlotfv;
/*     */   public final long alGetAuxiliaryEffectSloti;
/*     */   public final long alGetAuxiliaryEffectSlotiv;
/*     */   public final long alGetAuxiliaryEffectSlotf;
/*     */   public final long alGetAuxiliaryEffectSlotfv;
/*     */   public final long alBufferDataStatic;
/*     */   public final long alBufferSamplesSOFT;
/*     */   public final long alBufferSubSamplesSOFT;
/*     */   public final long alGetBufferSamplesSOFT;
/*     */   public final long alIsBufferFormatSupportedSOFT;
/*     */   public final long alBufferSubDataSOFT;
/*     */   public final long alBufferCallbackSOFT;
/*     */   public final long alGetBufferPtrSOFT;
/*     */   public final long alGetBuffer3PtrSOFT;
/*     */   public final long alGetBufferPtrvSOFT;
/*     */   public final long alDeferUpdatesSOFT;
/*     */   public final long alProcessUpdatesSOFT;
/*     */   public final long alEventControlSOFT;
/*     */   public final long alEventCallbackSOFT;
/*     */   public final long alGetPointerSOFT;
/*     */   public final long alGetPointervSOFT;
/*     */   public final long alSourcedSOFT;
/*     */   public final long alSource3dSOFT;
/*     */   public final long alSourcedvSOFT;
/*     */   public final long alGetSourcedSOFT;
/*     */   public final long alGetSource3dSOFT;
/*     */   public final long alGetSourcedvSOFT;
/*     */   public final long alSourcei64SOFT;
/*     */   public final long alSource3i64SOFT;
/*     */   public final long alSourcei64vSOFT;
/*     */   public final long alGetSourcei64SOFT;
/*     */   public final long alGetSource3i64SOFT;
/*     */   public final long alGetSourcei64vSOFT;
/*     */   public final long alGetStringiSOFT;
/*     */   public final long alSourcePlayAtTimeSOFT;
/*     */   public final long alSourcePlayAtTimevSOFT;
/*     */   public final boolean OpenAL10;
/*     */   public final boolean OpenAL11;
/*     */   public final boolean AL_EXT_ALAW;
/*     */   public final boolean AL_EXT_BFORMAT;
/*     */   public final boolean AL_EXT_DOUBLE;
/*     */   public final boolean ALC_EXT_EFX;
/*     */   public final boolean AL_EXT_EXPONENT_DISTANCE;
/*     */   public final boolean AL_EXT_FLOAT32;
/*     */   public final boolean AL_EXT_IMA4;
/*     */   public final boolean AL_EXT_LINEAR_DISTANCE;
/*     */   public final boolean AL_EXT_MCFORMATS;
/*     */   public final boolean AL_EXT_MULAW;
/*     */   public final boolean AL_EXT_MULAW_BFORMAT;
/*     */   public final boolean AL_EXT_MULAW_MCFORMATS;
/*     */   public final boolean AL_EXT_OFFSET;
/*     */   public final boolean AL_EXT_source_distance_model;
/*     */   public final boolean AL_EXT_SOURCE_RADIUS;
/*     */   public final boolean AL_EXT_STATIC_BUFFER;
/*     */   public final boolean AL_EXT_STEREO_ANGLES;
/*     */   public final boolean AL_EXT_vorbis;
/*     */   public final boolean AL_LOKI_IMA_ADPCM;
/*     */   public final boolean AL_LOKI_quadriphonic;
/*     */   public final boolean AL_LOKI_WAVE_format;
/*     */   public final boolean AL_SOFT_bformat_ex;
/*     */   public final boolean AL_SOFT_block_alignment;
/*     */   public final boolean AL_SOFT_buffer_length_query;
/*     */   public final boolean AL_SOFT_buffer_samples;
/*     */   public final boolean AL_SOFT_buffer_sub_data;
/*     */   public final boolean AL_SOFT_callback_buffer;
/*     */   public final boolean AL_SOFT_deferred_updates;
/*     */   public final boolean AL_SOFT_direct_channels;
/*     */   public final boolean AL_SOFT_direct_channels_remix;
/*     */   public final boolean AL_SOFT_effect_target;
/*     */   public final boolean AL_SOFT_events;
/*     */   public final boolean AL_SOFT_gain_clamp_ex;
/*     */   public final boolean AL_SOFT_loop_points;
/*     */   public final boolean AL_SOFT_MSADPCM;
/*     */   public final boolean AL_SOFT_source_latency;
/*     */   public final boolean AL_SOFT_source_length;
/*     */   public final boolean AL_SOFT_source_resampler;
/*     */   public final boolean AL_SOFT_source_spatialize;
/*     */   public final boolean AL_SOFT_source_start_delay;
/*     */   public final boolean AL_SOFT_UHJ;
/*     */   public final boolean AL_SOFT_UHJ_ex;
/*     */   public final boolean AL_SOFTX_hold_on_disconnect;
/*     */   final PointerBuffer addresses;
/*     */   
/*     */   ALCapabilities(FunctionProvider paramFunctionProvider, Set<String> paramSet, IntFunction<PointerBuffer> paramIntFunction) {
/* 283 */     PointerBuffer pointerBuffer = paramIntFunction.apply(133);
/*     */     
/* 285 */     this.OpenAL10 = check_AL10(paramFunctionProvider, pointerBuffer, paramSet);
/* 286 */     this.OpenAL11 = check_AL11(paramFunctionProvider, pointerBuffer, paramSet);
/* 287 */     this.AL_EXT_ALAW = paramSet.contains("AL_EXT_ALAW");
/* 288 */     this.AL_EXT_BFORMAT = paramSet.contains("AL_EXT_BFORMAT");
/* 289 */     this.AL_EXT_DOUBLE = paramSet.contains("AL_EXT_DOUBLE");
/* 290 */     this.ALC_EXT_EFX = check_EXT_EFX(paramFunctionProvider, pointerBuffer, paramSet);
/* 291 */     this.AL_EXT_EXPONENT_DISTANCE = paramSet.contains("AL_EXT_EXPONENT_DISTANCE");
/* 292 */     this.AL_EXT_FLOAT32 = paramSet.contains("AL_EXT_FLOAT32");
/* 293 */     this.AL_EXT_IMA4 = paramSet.contains("AL_EXT_IMA4");
/* 294 */     this.AL_EXT_LINEAR_DISTANCE = paramSet.contains("AL_EXT_LINEAR_DISTANCE");
/* 295 */     this.AL_EXT_MCFORMATS = paramSet.contains("AL_EXT_MCFORMATS");
/* 296 */     this.AL_EXT_MULAW = paramSet.contains("AL_EXT_MULAW");
/* 297 */     this.AL_EXT_MULAW_BFORMAT = paramSet.contains("AL_EXT_MULAW_BFORMAT");
/* 298 */     this.AL_EXT_MULAW_MCFORMATS = paramSet.contains("AL_EXT_MULAW_MCFORMATS");
/* 299 */     this.AL_EXT_OFFSET = paramSet.contains("AL_EXT_OFFSET");
/* 300 */     this.AL_EXT_source_distance_model = paramSet.contains("AL_EXT_source_distance_model");
/* 301 */     this.AL_EXT_SOURCE_RADIUS = paramSet.contains("AL_EXT_SOURCE_RADIUS");
/* 302 */     this.AL_EXT_STATIC_BUFFER = check_EXT_STATIC_BUFFER(paramFunctionProvider, pointerBuffer, paramSet);
/* 303 */     this.AL_EXT_STEREO_ANGLES = paramSet.contains("AL_EXT_STEREO_ANGLES");
/* 304 */     this.AL_EXT_vorbis = paramSet.contains("AL_EXT_vorbis");
/* 305 */     this.AL_LOKI_IMA_ADPCM = paramSet.contains("AL_LOKI_IMA_ADPCM");
/* 306 */     this.AL_LOKI_quadriphonic = paramSet.contains("AL_LOKI_quadriphonic");
/* 307 */     this.AL_LOKI_WAVE_format = paramSet.contains("AL_LOKI_WAVE_format");
/* 308 */     this.AL_SOFT_bformat_ex = paramSet.contains("AL_SOFT_bformat_ex");
/* 309 */     this.AL_SOFT_block_alignment = paramSet.contains("AL_SOFT_block_alignment");
/* 310 */     this.AL_SOFT_buffer_length_query = paramSet.contains("AL_SOFT_buffer_length_query");
/* 311 */     this.AL_SOFT_buffer_samples = check_SOFT_buffer_samples(paramFunctionProvider, pointerBuffer, paramSet);
/* 312 */     this.AL_SOFT_buffer_sub_data = check_SOFT_buffer_sub_data(paramFunctionProvider, pointerBuffer, paramSet);
/* 313 */     this.AL_SOFT_callback_buffer = check_SOFT_callback_buffer(paramFunctionProvider, pointerBuffer, paramSet);
/* 314 */     this.AL_SOFT_deferred_updates = check_SOFT_deferred_updates(paramFunctionProvider, pointerBuffer, paramSet);
/* 315 */     this.AL_SOFT_direct_channels = paramSet.contains("AL_SOFT_direct_channels");
/* 316 */     this.AL_SOFT_direct_channels_remix = paramSet.contains("AL_SOFT_direct_channels_remix");
/* 317 */     this.AL_SOFT_effect_target = paramSet.contains("AL_SOFT_effect_target");
/* 318 */     this.AL_SOFT_events = check_SOFT_events(paramFunctionProvider, pointerBuffer, paramSet);
/* 319 */     this.AL_SOFT_gain_clamp_ex = paramSet.contains("AL_SOFT_gain_clamp_ex");
/* 320 */     this.AL_SOFT_loop_points = paramSet.contains("AL_SOFT_loop_points");
/* 321 */     this.AL_SOFT_MSADPCM = paramSet.contains("AL_SOFT_MSADPCM");
/* 322 */     this.AL_SOFT_source_latency = check_SOFT_source_latency(paramFunctionProvider, pointerBuffer, paramSet);
/* 323 */     this.AL_SOFT_source_length = paramSet.contains("AL_SOFT_source_length");
/* 324 */     this.AL_SOFT_source_resampler = check_SOFT_source_resampler(paramFunctionProvider, pointerBuffer, paramSet);
/* 325 */     this.AL_SOFT_source_spatialize = paramSet.contains("AL_SOFT_source_spatialize");
/* 326 */     this.AL_SOFT_source_start_delay = check_SOFT_source_start_delay(paramFunctionProvider, pointerBuffer, paramSet);
/* 327 */     this.AL_SOFT_UHJ = paramSet.contains("AL_SOFT_UHJ");
/* 328 */     this.AL_SOFT_UHJ_ex = paramSet.contains("AL_SOFT_UHJ_ex");
/* 329 */     this.AL_SOFTX_hold_on_disconnect = paramSet.contains("AL_SOFTX_hold_on_disconnect");
/*     */     
/* 331 */     this.alGetError = pointerBuffer.get(0);
/* 332 */     this.alEnable = pointerBuffer.get(1);
/* 333 */     this.alDisable = pointerBuffer.get(2);
/* 334 */     this.alIsEnabled = pointerBuffer.get(3);
/* 335 */     this.alGetBoolean = pointerBuffer.get(4);
/* 336 */     this.alGetInteger = pointerBuffer.get(5);
/* 337 */     this.alGetFloat = pointerBuffer.get(6);
/* 338 */     this.alGetDouble = pointerBuffer.get(7);
/* 339 */     this.alGetBooleanv = pointerBuffer.get(8);
/* 340 */     this.alGetIntegerv = pointerBuffer.get(9);
/* 341 */     this.alGetFloatv = pointerBuffer.get(10);
/* 342 */     this.alGetDoublev = pointerBuffer.get(11);
/* 343 */     this.alGetString = pointerBuffer.get(12);
/* 344 */     this.alDistanceModel = pointerBuffer.get(13);
/* 345 */     this.alDopplerFactor = pointerBuffer.get(14);
/* 346 */     this.alDopplerVelocity = pointerBuffer.get(15);
/* 347 */     this.alListenerf = pointerBuffer.get(16);
/* 348 */     this.alListeneri = pointerBuffer.get(17);
/* 349 */     this.alListener3f = pointerBuffer.get(18);
/* 350 */     this.alListenerfv = pointerBuffer.get(19);
/* 351 */     this.alGetListenerf = pointerBuffer.get(20);
/* 352 */     this.alGetListeneri = pointerBuffer.get(21);
/* 353 */     this.alGetListener3f = pointerBuffer.get(22);
/* 354 */     this.alGetListenerfv = pointerBuffer.get(23);
/* 355 */     this.alGenSources = pointerBuffer.get(24);
/* 356 */     this.alDeleteSources = pointerBuffer.get(25);
/* 357 */     this.alIsSource = pointerBuffer.get(26);
/* 358 */     this.alSourcef = pointerBuffer.get(27);
/* 359 */     this.alSource3f = pointerBuffer.get(28);
/* 360 */     this.alSourcefv = pointerBuffer.get(29);
/* 361 */     this.alSourcei = pointerBuffer.get(30);
/* 362 */     this.alGetSourcef = pointerBuffer.get(31);
/* 363 */     this.alGetSource3f = pointerBuffer.get(32);
/* 364 */     this.alGetSourcefv = pointerBuffer.get(33);
/* 365 */     this.alGetSourcei = pointerBuffer.get(34);
/* 366 */     this.alGetSourceiv = pointerBuffer.get(35);
/* 367 */     this.alSourceQueueBuffers = pointerBuffer.get(36);
/* 368 */     this.alSourceUnqueueBuffers = pointerBuffer.get(37);
/* 369 */     this.alSourcePlay = pointerBuffer.get(38);
/* 370 */     this.alSourcePause = pointerBuffer.get(39);
/* 371 */     this.alSourceStop = pointerBuffer.get(40);
/* 372 */     this.alSourceRewind = pointerBuffer.get(41);
/* 373 */     this.alSourcePlayv = pointerBuffer.get(42);
/* 374 */     this.alSourcePausev = pointerBuffer.get(43);
/* 375 */     this.alSourceStopv = pointerBuffer.get(44);
/* 376 */     this.alSourceRewindv = pointerBuffer.get(45);
/* 377 */     this.alGenBuffers = pointerBuffer.get(46);
/* 378 */     this.alDeleteBuffers = pointerBuffer.get(47);
/* 379 */     this.alIsBuffer = pointerBuffer.get(48);
/* 380 */     this.alGetBufferf = pointerBuffer.get(49);
/* 381 */     this.alGetBufferi = pointerBuffer.get(50);
/* 382 */     this.alBufferData = pointerBuffer.get(51);
/* 383 */     this.alGetEnumValue = pointerBuffer.get(52);
/* 384 */     this.alGetProcAddress = pointerBuffer.get(53);
/* 385 */     this.alIsExtensionPresent = pointerBuffer.get(54);
/* 386 */     this.alListener3i = pointerBuffer.get(55);
/* 387 */     this.alGetListeneriv = pointerBuffer.get(56);
/* 388 */     this.alSource3i = pointerBuffer.get(57);
/* 389 */     this.alListeneriv = pointerBuffer.get(58);
/* 390 */     this.alSourceiv = pointerBuffer.get(59);
/* 391 */     this.alBufferf = pointerBuffer.get(60);
/* 392 */     this.alBuffer3f = pointerBuffer.get(61);
/* 393 */     this.alBufferfv = pointerBuffer.get(62);
/* 394 */     this.alBufferi = pointerBuffer.get(63);
/* 395 */     this.alBuffer3i = pointerBuffer.get(64);
/* 396 */     this.alBufferiv = pointerBuffer.get(65);
/* 397 */     this.alGetBufferiv = pointerBuffer.get(66);
/* 398 */     this.alGetBufferfv = pointerBuffer.get(67);
/* 399 */     this.alSpeedOfSound = pointerBuffer.get(68);
/* 400 */     this.alGenEffects = pointerBuffer.get(69);
/* 401 */     this.alDeleteEffects = pointerBuffer.get(70);
/* 402 */     this.alIsEffect = pointerBuffer.get(71);
/* 403 */     this.alEffecti = pointerBuffer.get(72);
/* 404 */     this.alEffectiv = pointerBuffer.get(73);
/* 405 */     this.alEffectf = pointerBuffer.get(74);
/* 406 */     this.alEffectfv = pointerBuffer.get(75);
/* 407 */     this.alGetEffecti = pointerBuffer.get(76);
/* 408 */     this.alGetEffectiv = pointerBuffer.get(77);
/* 409 */     this.alGetEffectf = pointerBuffer.get(78);
/* 410 */     this.alGetEffectfv = pointerBuffer.get(79);
/* 411 */     this.alGenFilters = pointerBuffer.get(80);
/* 412 */     this.alDeleteFilters = pointerBuffer.get(81);
/* 413 */     this.alIsFilter = pointerBuffer.get(82);
/* 414 */     this.alFilteri = pointerBuffer.get(83);
/* 415 */     this.alFilteriv = pointerBuffer.get(84);
/* 416 */     this.alFilterf = pointerBuffer.get(85);
/* 417 */     this.alFilterfv = pointerBuffer.get(86);
/* 418 */     this.alGetFilteri = pointerBuffer.get(87);
/* 419 */     this.alGetFilteriv = pointerBuffer.get(88);
/* 420 */     this.alGetFilterf = pointerBuffer.get(89);
/* 421 */     this.alGetFilterfv = pointerBuffer.get(90);
/* 422 */     this.alGenAuxiliaryEffectSlots = pointerBuffer.get(91);
/* 423 */     this.alDeleteAuxiliaryEffectSlots = pointerBuffer.get(92);
/* 424 */     this.alIsAuxiliaryEffectSlot = pointerBuffer.get(93);
/* 425 */     this.alAuxiliaryEffectSloti = pointerBuffer.get(94);
/* 426 */     this.alAuxiliaryEffectSlotiv = pointerBuffer.get(95);
/* 427 */     this.alAuxiliaryEffectSlotf = pointerBuffer.get(96);
/* 428 */     this.alAuxiliaryEffectSlotfv = pointerBuffer.get(97);
/* 429 */     this.alGetAuxiliaryEffectSloti = pointerBuffer.get(98);
/* 430 */     this.alGetAuxiliaryEffectSlotiv = pointerBuffer.get(99);
/* 431 */     this.alGetAuxiliaryEffectSlotf = pointerBuffer.get(100);
/* 432 */     this.alGetAuxiliaryEffectSlotfv = pointerBuffer.get(101);
/* 433 */     this.alBufferDataStatic = pointerBuffer.get(102);
/* 434 */     this.alBufferSamplesSOFT = pointerBuffer.get(103);
/* 435 */     this.alBufferSubSamplesSOFT = pointerBuffer.get(104);
/* 436 */     this.alGetBufferSamplesSOFT = pointerBuffer.get(105);
/* 437 */     this.alIsBufferFormatSupportedSOFT = pointerBuffer.get(106);
/* 438 */     this.alBufferSubDataSOFT = pointerBuffer.get(107);
/* 439 */     this.alBufferCallbackSOFT = pointerBuffer.get(108);
/* 440 */     this.alGetBufferPtrSOFT = pointerBuffer.get(109);
/* 441 */     this.alGetBuffer3PtrSOFT = pointerBuffer.get(110);
/* 442 */     this.alGetBufferPtrvSOFT = pointerBuffer.get(111);
/* 443 */     this.alDeferUpdatesSOFT = pointerBuffer.get(112);
/* 444 */     this.alProcessUpdatesSOFT = pointerBuffer.get(113);
/* 445 */     this.alEventControlSOFT = pointerBuffer.get(114);
/* 446 */     this.alEventCallbackSOFT = pointerBuffer.get(115);
/* 447 */     this.alGetPointerSOFT = pointerBuffer.get(116);
/* 448 */     this.alGetPointervSOFT = pointerBuffer.get(117);
/* 449 */     this.alSourcedSOFT = pointerBuffer.get(118);
/* 450 */     this.alSource3dSOFT = pointerBuffer.get(119);
/* 451 */     this.alSourcedvSOFT = pointerBuffer.get(120);
/* 452 */     this.alGetSourcedSOFT = pointerBuffer.get(121);
/* 453 */     this.alGetSource3dSOFT = pointerBuffer.get(122);
/* 454 */     this.alGetSourcedvSOFT = pointerBuffer.get(123);
/* 455 */     this.alSourcei64SOFT = pointerBuffer.get(124);
/* 456 */     this.alSource3i64SOFT = pointerBuffer.get(125);
/* 457 */     this.alSourcei64vSOFT = pointerBuffer.get(126);
/* 458 */     this.alGetSourcei64SOFT = pointerBuffer.get(127);
/* 459 */     this.alGetSource3i64SOFT = pointerBuffer.get(128);
/* 460 */     this.alGetSourcei64vSOFT = pointerBuffer.get(129);
/* 461 */     this.alGetStringiSOFT = pointerBuffer.get(130);
/* 462 */     this.alSourcePlayAtTimeSOFT = pointerBuffer.get(131);
/* 463 */     this.alSourcePlayAtTimevSOFT = pointerBuffer.get(132);
/*     */     
/* 465 */     this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public final PointerBuffer getAddressBuffer() {
/* 470 */     return this.addresses;
/*     */   }
/*     */   
/*     */   private static boolean check_AL10(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 474 */     if (!paramSet.contains("OpenAL10")) {
/* 475 */       return false;
/*     */     }
/*     */     
/* 478 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54 }, new String[] { "alGetError", "alEnable", "alDisable", "alIsEnabled", "alGetBoolean", "alGetInteger", "alGetFloat", "alGetDouble", "alGetBooleanv", "alGetIntegerv", "alGetFloatv", "alGetDoublev", "alGetString", "alDistanceModel", "alDopplerFactor", "alDopplerVelocity", "alListenerf", "alListeneri", "alListener3f", "alListenerfv", "alGetListenerf", "alGetListeneri", "alGetListener3f", "alGetListenerfv", "alGenSources", "alDeleteSources", "alIsSource", "alSourcef", "alSource3f", "alSourcefv", "alSourcei", "alGetSourcef", "alGetSource3f", "alGetSourcefv", "alGetSourcei", "alGetSourceiv", "alSourceQueueBuffers", "alSourceUnqueueBuffers", "alSourcePlay", "alSourcePause", "alSourceStop", "alSourceRewind", "alSourcePlayv", "alSourcePausev", "alSourceStopv", "alSourceRewindv", "alGenBuffers", "alDeleteBuffers", "alIsBuffer", "alGetBufferf", "alGetBufferi", "alBufferData", "alGetEnumValue", "alGetProcAddress", "alIsExtensionPresent"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 489 */         }) || Checks.reportMissing("AL", "OpenAL10")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_AL11(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 493 */     if (!paramSet.contains("OpenAL11")) {
/* 494 */       return false;
/*     */     }
/*     */     
/* 497 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68 }, new String[] { "alListener3i", "alGetListeneriv", "alSource3i", "alListeneriv", "alSourceiv", "alBufferf", "alBuffer3f", "alBufferfv", "alBufferi", "alBuffer3i", "alBufferiv", "alGetBufferiv", "alGetBufferfv", "alSpeedOfSound"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 502 */         }) || Checks.reportMissing("AL", "OpenAL11")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_EXT_EFX(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 506 */     if (!paramSet.contains("ALC_EXT_EFX")) {
/* 507 */       return false;
/*     */     }
/*     */     
/* 510 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101 }, new String[] { "alGenEffects", "alDeleteEffects", "alIsEffect", "alEffecti", "alEffectiv", "alEffectf", "alEffectfv", "alGetEffecti", "alGetEffectiv", "alGetEffectf", "alGetEffectfv", "alGenFilters", "alDeleteFilters", "alIsFilter", "alFilteri", "alFilteriv", "alFilterf", "alFilterfv", "alGetFilteri", "alGetFilteriv", "alGetFilterf", "alGetFilterfv", "alGenAuxiliaryEffectSlots", "alDeleteAuxiliaryEffectSlots", "alIsAuxiliaryEffectSlot", "alAuxiliaryEffectSloti", "alAuxiliaryEffectSlotiv", "alAuxiliaryEffectSlotf", "alAuxiliaryEffectSlotfv", "alGetAuxiliaryEffectSloti", "alGetAuxiliaryEffectSlotiv", "alGetAuxiliaryEffectSlotf", "alGetAuxiliaryEffectSlotfv"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 518 */         }) || Checks.reportMissing("AL", "ALC_EXT_EFX")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_EXT_STATIC_BUFFER(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 522 */     if (!paramSet.contains("AL_EXT_STATIC_BUFFER")) {
/* 523 */       return false;
/*     */     }
/*     */     
/* 526 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 102 }, new String[] { "alBufferDataStatic"
/*     */ 
/*     */ 
/*     */         
/* 530 */         }) || Checks.reportMissing("AL", "AL_EXT_STATIC_BUFFER")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_buffer_samples(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 534 */     if (!paramSet.contains("AL_SOFT_buffer_samples")) {
/* 535 */       return false;
/*     */     }
/*     */     
/* 538 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 103, 104, 105, 106 }, new String[] { "alBufferSamplesSOFT", "alBufferSubSamplesSOFT", "alGetBufferSamplesSOFT", "alIsBufferFormatSupportedSOFT"
/*     */ 
/*     */ 
/*     */         
/* 542 */         }) || Checks.reportMissing("AL", "AL_SOFT_buffer_samples")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_buffer_sub_data(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 546 */     if (!paramSet.contains("AL_SOFT_buffer_sub_data")) {
/* 547 */       return false;
/*     */     }
/*     */     
/* 550 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 107 }, new String[] { "alBufferSubDataSOFT"
/*     */ 
/*     */ 
/*     */         
/* 554 */         }) || Checks.reportMissing("AL", "AL_SOFT_buffer_sub_data")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_callback_buffer(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 558 */     if (!paramSet.contains("AL_SOFT_callback_buffer")) {
/* 559 */       return false;
/*     */     }
/*     */     
/* 562 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 108, 109, 110, 111 }, new String[] { "alBufferCallbackSOFT", "alGetBufferPtrSOFT", "alGetBuffer3PtrSOFT", "alGetBufferPtrvSOFT"
/*     */ 
/*     */ 
/*     */         
/* 566 */         }) || Checks.reportMissing("AL", "AL_SOFT_callback_buffer")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_deferred_updates(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 570 */     if (!paramSet.contains("AL_SOFT_deferred_updates")) {
/* 571 */       return false;
/*     */     }
/*     */     
/* 574 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 112, 113 }, new String[] { "alDeferUpdatesSOFT", "alProcessUpdatesSOFT"
/*     */ 
/*     */ 
/*     */         
/* 578 */         }) || Checks.reportMissing("AL", "AL_SOFT_deferred_updates")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_events(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 582 */     if (!paramSet.contains("AL_SOFT_events")) {
/* 583 */       return false;
/*     */     }
/*     */     
/* 586 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 114, 115, 116, 117 }, new String[] { "alEventControlSOFT", "alEventCallbackSOFT", "alGetPointerSOFT", "alGetPointervSOFT"
/*     */ 
/*     */ 
/*     */         
/* 590 */         }) || Checks.reportMissing("AL", "AL_SOFT_events")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_source_latency(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 594 */     if (!paramSet.contains("AL_SOFT_source_latency")) {
/* 595 */       return false;
/*     */     }
/*     */     
/* 598 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129 }, new String[] { "alSourcedSOFT", "alSource3dSOFT", "alSourcedvSOFT", "alGetSourcedSOFT", "alGetSource3dSOFT", "alGetSourcedvSOFT", "alSourcei64SOFT", "alSource3i64SOFT", "alSourcei64vSOFT", "alGetSourcei64SOFT", "alGetSource3i64SOFT", "alGetSourcei64vSOFT"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 603 */         }) || Checks.reportMissing("AL", "AL_SOFT_source_latency")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_source_resampler(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 607 */     if (!paramSet.contains("AL_SOFT_source_resampler")) {
/* 608 */       return false;
/*     */     }
/*     */     
/* 611 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 130 }, new String[] { "alGetStringiSOFT"
/*     */ 
/*     */ 
/*     */         
/* 615 */         }) || Checks.reportMissing("AL", "AL_SOFT_source_resampler")) return true; 
/*     */     return false;
/*     */   }
/*     */   private static boolean check_SOFT_source_start_delay(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 619 */     if (!paramSet.contains("AL_SOFT_source_start_delay")) {
/* 620 */       return false;
/*     */     }
/*     */     
/* 623 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 131, 132 }, new String[] { "alSourcePlayAtTimeSOFT", "alSourcePlayAtTimevSOFT"
/*     */ 
/*     */ 
/*     */         
/* 627 */         }) || Checks.reportMissing("AL", "AL_SOFT_source_start_delay")) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\ALCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */