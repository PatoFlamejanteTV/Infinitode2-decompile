/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class STBVorbis
/*     */ {
/*     */   public static final int VORBIS__no_error = 0;
/*     */   public static final int VORBIS_need_more_data = 1;
/*     */   public static final int VORBIS_invalid_api_mixing = 2;
/*     */   public static final int VORBIS_outofmem = 3;
/*     */   public static final int VORBIS_feature_not_supported = 4;
/*     */   public static final int VORBIS_too_many_channels = 5;
/*     */   public static final int VORBIS_file_open_failure = 6;
/*     */   public static final int VORBIS_seek_without_length = 7;
/*     */   public static final int VORBIS_unexpected_eof = 10;
/*     */   public static final int VORBIS_seek_invalid = 11;
/*     */   public static final int VORBIS_invalid_setup = 20;
/*     */   public static final int VORBIS_invalid_stream = 21;
/*     */   public static final int VORBIS_missing_capture_pattern = 30;
/*     */   public static final int VORBIS_invalid_stream_structure_version = 31;
/*     */   public static final int VORBIS_continued_packet_flag_invalid = 32;
/*     */   public static final int VORBIS_incorrect_stream_serial_number = 33;
/*     */   public static final int VORBIS_invalid_first_page = 34;
/*     */   public static final int VORBIS_bad_packet_type = 35;
/*     */   public static final int VORBIS_cant_find_last_page = 36;
/*     */   public static final int VORBIS_seek_failed = 37;
/*     */   public static final int VORBIS_ogg_skeleton_not_supported = 38;
/*     */   
/*     */   static {
/*  55 */     LibSTB.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected STBVorbis() {
/* 110 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis_info")
/*     */   public static STBVorbisInfo stb_vorbis_get_info(@NativeType("stb_vorbis *") long paramLong, @NativeType("stb_vorbis_info") STBVorbisInfo paramSTBVorbisInfo) {
/* 125 */     if (Checks.CHECKS) {
/* 126 */       Checks.check(paramLong);
/*     */     }
/* 128 */     nstb_vorbis_get_info(paramLong, paramSTBVorbisInfo.address());
/* 129 */     return paramSTBVorbisInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis_comment")
/*     */   public static STBVorbisComment stb_vorbis_get_comment(@NativeType("stb_vorbis *") long paramLong, @NativeType("stb_vorbis_comment") STBVorbisComment paramSTBVorbisComment) {
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(paramLong);
/*     */     }
/* 147 */     nstb_vorbis_get_comment(paramLong, paramSTBVorbisComment.address());
/* 148 */     return paramSTBVorbisComment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_error(@NativeType("stb_vorbis *") long paramLong) {
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.check(paramLong);
/*     */     }
/* 165 */     return nstb_vorbis_get_error(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stb_vorbis_close(@NativeType("stb_vorbis *") long paramLong) {
/* 179 */     if (Checks.CHECKS) {
/* 180 */       Checks.check(paramLong);
/*     */     }
/* 182 */     nstb_vorbis_close(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_sample_offset(@NativeType("stb_vorbis *") long paramLong) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(paramLong);
/*     */     }
/* 202 */     return nstb_vorbis_get_sample_offset(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int stb_vorbis_get_file_offset(@NativeType("stb_vorbis *") long paramLong) {
/* 217 */     if (Checks.CHECKS) {
/* 218 */       Checks.check(paramLong);
/*     */     }
/* 220 */     return nstb_vorbis_get_file_offset(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_pushdata(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 248 */     if (Checks.CHECKS) {
/* 249 */       Checks.check(paramIntBuffer1, 1);
/* 250 */       Checks.check(paramIntBuffer2, 1);
/* 251 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     } 
/* 253 */     return nstb_vorbis_open_pushdata(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_frame_pushdata(@NativeType("stb_vorbis *") long paramLong, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("float ***") PointerBuffer paramPointerBuffer, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 296 */     if (Checks.CHECKS) {
/* 297 */       Checks.check(paramLong);
/* 298 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 299 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 300 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/* 302 */     return nstb_vorbis_decode_frame_pushdata(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stb_vorbis_flush_pushdata(@NativeType("stb_vorbis *") long paramLong) {
/* 321 */     if (Checks.CHECKS) {
/* 322 */       Checks.check(paramLong);
/*     */     }
/* 324 */     nstb_vorbis_flush_pushdata(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("short **") PointerBuffer paramPointerBuffer) {
/* 344 */     if (Checks.CHECKS) {
/* 345 */       Checks.checkNT1(paramByteBuffer);
/* 346 */       Checks.check(paramIntBuffer1, 1);
/* 347 */       Checks.check(paramIntBuffer2, 1);
/* 348 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 350 */     return nstb_vorbis_decode_filename(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("short **") PointerBuffer paramPointerBuffer) {
/* 365 */     if (Checks.CHECKS) {
/* 366 */       Checks.check(paramIntBuffer1, 1);
/* 367 */       Checks.check(paramIntBuffer2, 1);
/* 368 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }  MemoryStack memoryStack;
/* 370 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 372 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/* 374 */       return nstb_vorbis_decode_filename(l = memoryStack.getPointerAddress(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */     } finally {
/* 376 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static ShortBuffer stb_vorbis_decode_filename(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 393 */     if (Checks.CHECKS) {
/* 394 */       Checks.check(paramIntBuffer1, 1);
/* 395 */       Checks.check(paramIntBuffer2, 1);
/*     */     }  MemoryStack memoryStack;
/* 397 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 399 */       memoryStack.nASCII(paramCharSequence, true);
/* 400 */       long l = memoryStack.getPointerAddress();
/* 401 */       PointerBuffer pointerBuffer = memoryStack.pointers(0L);
/* 402 */       int j = nstb_vorbis_decode_filename(l, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 403 */       return MemoryUtil.memShortBufferSafe(pointerBuffer.get(0), j * paramIntBuffer1.get(0));
/*     */     } finally {
/* 405 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_memory(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("short **") PointerBuffer paramPointerBuffer) {
/* 427 */     if (Checks.CHECKS) {
/* 428 */       Checks.check(paramIntBuffer1, 1);
/* 429 */       Checks.check(paramIntBuffer2, 1);
/* 430 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 432 */     return nstb_vorbis_decode_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static ShortBuffer stb_vorbis_decode_memory(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 445 */     if (Checks.CHECKS) {
/* 446 */       Checks.check(paramIntBuffer1, 1);
/* 447 */       Checks.check(paramIntBuffer2, 1);
/*     */     }  MemoryStack memoryStack;
/* 449 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 451 */       PointerBuffer pointerBuffer = memoryStack.pointers(0L);
/* 452 */       int j = nstb_vorbis_decode_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 453 */       return MemoryUtil.memShortBufferSafe(pointerBuffer.get(0), j * paramIntBuffer1.get(0));
/*     */     } finally {
/* 455 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_memory(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 479 */     if (Checks.CHECKS) {
/* 480 */       Checks.check(paramIntBuffer, 1);
/* 481 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     } 
/* 483 */     return nstb_vorbis_open_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 502 */     if (Checks.CHECKS) {
/* 503 */       Checks.checkNT1(paramByteBuffer);
/* 504 */       Checks.check(paramIntBuffer, 1);
/* 505 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     } 
/* 507 */     return nstb_vorbis_open_filename(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") IntBuffer paramIntBuffer, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 521 */     if (Checks.CHECKS) {
/* 522 */       Checks.check(paramIntBuffer, 1);
/* 523 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     }  MemoryStack memoryStack;
/* 525 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 527 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/* 529 */       return nstb_vorbis_open_filename(l = memoryStack.getPointerAddress(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */     } finally {
/* 531 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stb_vorbis_seek_frame(@NativeType("stb_vorbis *") long paramLong, @NativeType("unsigned int") int paramInt) {
/* 549 */     if (Checks.CHECKS) {
/* 550 */       Checks.check(paramLong);
/*     */     }
/* 552 */     return (nstb_vorbis_seek_frame(paramLong, paramInt) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stb_vorbis_seek(@NativeType("stb_vorbis *") long paramLong, @NativeType("unsigned int") int paramInt) {
/* 569 */     if (Checks.CHECKS) {
/* 570 */       Checks.check(paramLong);
/*     */     }
/* 572 */     return (nstb_vorbis_seek(paramLong, paramInt) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stb_vorbis_seek_start(@NativeType("stb_vorbis *") long paramLong) {
/* 587 */     if (Checks.CHECKS) {
/* 588 */       Checks.check(paramLong);
/*     */     }
/* 590 */     return (nstb_vorbis_seek_start(paramLong) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int stb_vorbis_stream_length_in_samples(@NativeType("stb_vorbis *") long paramLong) {
/* 605 */     if (Checks.CHECKS) {
/* 606 */       Checks.check(paramLong);
/*     */     }
/* 608 */     return nstb_vorbis_stream_length_in_samples(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float stb_vorbis_stream_length_in_seconds(@NativeType("stb_vorbis *") long paramLong) {
/* 622 */     if (Checks.CHECKS) {
/* 623 */       Checks.check(paramLong);
/*     */     }
/* 625 */     return nstb_vorbis_stream_length_in_seconds(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_float(@NativeType("stb_vorbis *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer, @NativeType("float ***") PointerBuffer paramPointerBuffer) {
/* 646 */     if (Checks.CHECKS) {
/* 647 */       Checks.check(paramLong);
/* 648 */       Checks.checkSafe(paramIntBuffer, 1);
/* 649 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 651 */     return nstb_vorbis_get_frame_float(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_short(@NativeType("stb_vorbis *") long paramLong, @NativeType("short **") PointerBuffer paramPointerBuffer, int paramInt) {
/* 692 */     if (Checks.CHECKS) {
/* 693 */       Checks.check(paramLong);
/*     */     }
/* 695 */     return nstb_vorbis_get_frame_short(paramLong, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_short_interleaved(@NativeType("stb_vorbis *") long paramLong, int paramInt, @NativeType("short *") ShortBuffer paramShortBuffer) {
/* 720 */     if (Checks.CHECKS) {
/* 721 */       Checks.check(paramLong);
/*     */     }
/* 723 */     return nstb_vorbis_get_frame_short_interleaved(paramLong, paramInt, MemoryUtil.memAddress(paramShortBuffer), paramShortBuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_float(@NativeType("stb_vorbis *") long paramLong, @NativeType("float **") PointerBuffer paramPointerBuffer, int paramInt) {
/* 746 */     if (Checks.CHECKS) {
/* 747 */       Checks.check(paramLong);
/*     */     }
/* 749 */     return nstb_vorbis_get_samples_float(paramLong, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_float_interleaved(@NativeType("stb_vorbis *") long paramLong, int paramInt, @NativeType("float *") FloatBuffer paramFloatBuffer) {
/* 771 */     if (Checks.CHECKS) {
/* 772 */       Checks.check(paramLong);
/*     */     }
/* 774 */     return nstb_vorbis_get_samples_float_interleaved(paramLong, paramInt, MemoryUtil.memAddress(paramFloatBuffer), paramFloatBuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_short(@NativeType("stb_vorbis *") long paramLong, @NativeType("short **") PointerBuffer paramPointerBuffer, int paramInt) {
/* 797 */     if (Checks.CHECKS) {
/* 798 */       Checks.check(paramLong);
/*     */     }
/* 800 */     return nstb_vorbis_get_samples_short(paramLong, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_short_interleaved(@NativeType("stb_vorbis *") long paramLong, int paramInt, @NativeType("short *") ShortBuffer paramShortBuffer) {
/* 822 */     if (Checks.CHECKS) {
/* 823 */       Checks.check(paramLong);
/*     */     }
/* 825 */     return nstb_vorbis_get_samples_short_interleaved(paramLong, paramInt, MemoryUtil.memAddress(paramShortBuffer), paramShortBuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_pushdata(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 834 */     if (Checks.CHECKS) {
/* 835 */       Checks.check(paramArrayOfint1, 1);
/* 836 */       Checks.check(paramArrayOfint2, 1);
/* 837 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     } 
/* 839 */     return nstb_vorbis_open_pushdata(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_frame_pushdata(@NativeType("stb_vorbis *") long paramLong, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("float ***") PointerBuffer paramPointerBuffer, @NativeType("int *") int[] paramArrayOfint2) {
/* 847 */     if (Checks.CHECKS) {
/* 848 */       Checks.check(paramLong);
/* 849 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 850 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 851 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 853 */     return nstb_vorbis_decode_frame_pushdata(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint1, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("short **") PointerBuffer paramPointerBuffer) {
/* 861 */     if (Checks.CHECKS) {
/* 862 */       Checks.checkNT1(paramByteBuffer);
/* 863 */       Checks.check(paramArrayOfint1, 1);
/* 864 */       Checks.check(paramArrayOfint2, 1);
/* 865 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 867 */     return nstb_vorbis_decode_filename(MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_filename(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("short **") PointerBuffer paramPointerBuffer) {
/* 872 */     if (Checks.CHECKS) {
/* 873 */       Checks.check(paramArrayOfint1, 1);
/* 874 */       Checks.check(paramArrayOfint2, 1);
/* 875 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }  MemoryStack memoryStack;
/* 877 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 879 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/* 881 */       return nstb_vorbis_decode_filename(l = memoryStack.getPointerAddress(), paramArrayOfint1, paramArrayOfint2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */     } finally {
/* 883 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_decode_memory(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("short **") PointerBuffer paramPointerBuffer) {
/* 892 */     if (Checks.CHECKS) {
/* 893 */       Checks.check(paramArrayOfint1, 1);
/* 894 */       Checks.check(paramArrayOfint2, 1);
/* 895 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 897 */     return nstb_vorbis_decode_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_memory(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 906 */     if (Checks.CHECKS) {
/* 907 */       Checks.check(paramArrayOfint, 1);
/* 908 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     } 
/* 910 */     return nstb_vorbis_open_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 919 */     if (Checks.CHECKS) {
/* 920 */       Checks.checkNT1(paramByteBuffer);
/* 921 */       Checks.check(paramArrayOfint, 1);
/* 922 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     } 
/* 924 */     return nstb_vorbis_open_filename(MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint, MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("stb_vorbis *")
/*     */   public static long stb_vorbis_open_filename(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") int[] paramArrayOfint, @NativeType("stb_vorbis_alloc const *") STBVorbisAlloc paramSTBVorbisAlloc) {
/* 930 */     if (Checks.CHECKS) {
/* 931 */       Checks.check(paramArrayOfint, 1);
/* 932 */       if (paramSTBVorbisAlloc != null) STBVorbisAlloc.validate(paramSTBVorbisAlloc.address()); 
/*     */     }  MemoryStack memoryStack;
/* 934 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 936 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/* 938 */       return nstb_vorbis_open_filename(l = memoryStack.getPointerAddress(), paramArrayOfint, MemoryUtil.memAddressSafe((Pointer)paramSTBVorbisAlloc));
/*     */     } finally {
/* 940 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_float(@NativeType("stb_vorbis *") long paramLong, @NativeType("int *") int[] paramArrayOfint, @NativeType("float ***") PointerBuffer paramPointerBuffer) {
/* 949 */     if (Checks.CHECKS) {
/* 950 */       Checks.check(paramLong);
/* 951 */       Checks.checkSafe(paramArrayOfint, 1);
/* 952 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 954 */     return nstb_vorbis_get_frame_float(paramLong, paramArrayOfint, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_frame_short_interleaved(@NativeType("stb_vorbis *") long paramLong, int paramInt, @NativeType("short *") short[] paramArrayOfshort) {
/* 962 */     if (Checks.CHECKS) {
/* 963 */       Checks.check(paramLong);
/*     */     }
/* 965 */     return nstb_vorbis_get_frame_short_interleaved(paramLong, paramInt, paramArrayOfshort, paramArrayOfshort.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_float_interleaved(@NativeType("stb_vorbis *") long paramLong, int paramInt, @NativeType("float *") float[] paramArrayOffloat) {
/* 973 */     if (Checks.CHECKS) {
/* 974 */       Checks.check(paramLong);
/*     */     }
/* 976 */     return nstb_vorbis_get_samples_float_interleaved(paramLong, paramInt, paramArrayOffloat, paramArrayOffloat.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_vorbis_get_samples_short_interleaved(@NativeType("stb_vorbis *") long paramLong, int paramInt, @NativeType("short *") short[] paramArrayOfshort) {
/* 984 */     if (Checks.CHECKS) {
/* 985 */       Checks.check(paramLong);
/*     */     }
/* 987 */     return nstb_vorbis_get_samples_short_interleaved(paramLong, paramInt, paramArrayOfshort, paramArrayOfshort.length);
/*     */   }
/*     */   
/*     */   public static native void nstb_vorbis_get_info(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nstb_vorbis_get_comment(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_get_error(long paramLong);
/*     */   
/*     */   public static native void nstb_vorbis_close(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_get_sample_offset(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_get_file_offset(long paramLong);
/*     */   
/*     */   public static native long nstb_vorbis_open_pushdata(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nstb_vorbis_decode_frame_pushdata(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*     */   
/*     */   public static native void nstb_vorbis_flush_pushdata(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_decode_filename(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nstb_vorbis_decode_memory(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native long nstb_vorbis_open_memory(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nstb_vorbis_open_filename(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nstb_vorbis_seek_frame(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstb_vorbis_seek(long paramLong, int paramInt);
/*     */   
/*     */   public static native int nstb_vorbis_seek_start(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_stream_length_in_samples(long paramLong);
/*     */   
/*     */   public static native float nstb_vorbis_stream_length_in_seconds(long paramLong);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_float(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_short(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_short_interleaved(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_float(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_float_interleaved(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_short(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_short_interleaved(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native long nstb_vorbis_open_pushdata(long paramLong1, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_decode_frame_pushdata(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint1, long paramLong3, int[] paramArrayOfint2);
/*     */   
/*     */   public static native int nstb_vorbis_decode_filename(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_decode_memory(long paramLong1, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*     */   
/*     */   public static native long nstb_vorbis_open_memory(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*     */   
/*     */   public static native long nstb_vorbis_open_filename(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_float(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*     */   
/*     */   public static native int nstb_vorbis_get_frame_short_interleaved(long paramLong, int paramInt1, short[] paramArrayOfshort, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_float_interleaved(long paramLong, int paramInt1, float[] paramArrayOffloat, int paramInt2);
/*     */   
/*     */   public static native int nstb_vorbis_get_samples_short_interleaved(long paramLong, int paramInt1, short[] paramArrayOfshort, int paramInt2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBVorbis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */