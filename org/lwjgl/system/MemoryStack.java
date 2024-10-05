/*      */ package org.lwjgl.system;
/*      */ 
/*      */ import java.nio.Buffer;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import java.util.Arrays;
/*      */ import org.lwjgl.BufferUtils;
/*      */ import org.lwjgl.CLongBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MemoryStack
/*      */   extends Pointer.Default
/*      */   implements AutoCloseable
/*      */ {
/*   28 */   private static final int DEFAULT_STACK_SIZE = ((Integer)Configuration.STACK_SIZE.get(Integer.valueOf(64))).intValue() << 10;
/*      */   
/*      */   private static final int DEFAULT_STACK_FRAMES = 8;
/*   31 */   private static final ThreadLocal<MemoryStack> TLS = ThreadLocal.withInitial(MemoryStack::create); private final ByteBuffer container;
/*      */   
/*      */   static {
/*   34 */     if (DEFAULT_STACK_SIZE < 0) {
/*   35 */       throw new IllegalStateException("Invalid stack size.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int size;
/*      */ 
/*      */ 
/*      */   
/*      */   private int pointer;
/*      */ 
/*      */ 
/*      */   
/*      */   private int[] frames;
/*      */ 
/*      */ 
/*      */   
/*      */   protected int frameIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected MemoryStack(ByteBuffer paramByteBuffer, long paramLong, int paramInt) {
/*   60 */     super(paramLong);
/*   61 */     this.container = paramByteBuffer;
/*      */     
/*   63 */     this.size = paramInt;
/*   64 */     this.pointer = paramInt;
/*      */     
/*   66 */     this.frames = new int[8];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack create() {
/*   75 */     return create(DEFAULT_STACK_SIZE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack create(int paramInt) {
/*   86 */     return create(BufferUtils.createByteBuffer(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack create(ByteBuffer paramByteBuffer) {
/*   97 */     long l = MemoryUtil.memAddress(paramByteBuffer);
/*   98 */     int i = paramByteBuffer.remaining();
/*   99 */     return ((Boolean)Configuration.DEBUG_STACK.get(Boolean.FALSE)).booleanValue() ? new DebugMemoryStack(paramByteBuffer, l, i) : new MemoryStack(paramByteBuffer, l, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack ncreate(long paramLong, int paramInt) {
/*  113 */     return ((Boolean)Configuration.DEBUG_STACK.get(Boolean.FALSE)).booleanValue() ? new DebugMemoryStack(null, paramLong, paramInt) : new MemoryStack(null, paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MemoryStack push() {
/*  134 */     if (this.frameIndex == this.frames.length) {
/*  135 */       frameOverflow();
/*      */     }
/*      */     
/*  138 */     this.frames[this.frameIndex++] = this.pointer;
/*  139 */     return this;
/*      */   }
/*      */   
/*      */   private void frameOverflow() {
/*  143 */     if (Checks.DEBUG) {
/*  144 */       APIUtil.apiLog("[WARNING] Out of frame stack space (" + this.frames.length + ") in thread: " + Thread.currentThread());
/*      */     }
/*  146 */     this.frames = Arrays.copyOf(this.frames, this.frames.length * 3 / 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MemoryStack pop() {
/*  155 */     this.pointer = this.frames[--this.frameIndex];
/*  156 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() {
/*  168 */     pop();
/*      */   }
/*      */   
/*      */   private static class DebugMemoryStack
/*      */     extends MemoryStack
/*      */   {
/*      */     private Object[] debugFrames;
/*      */     
/*      */     DebugMemoryStack(ByteBuffer param1ByteBuffer, long param1Long, int param1Int) {
/*  177 */       super(param1ByteBuffer, param1Long, param1Int);
/*  178 */       this.debugFrames = new Object[8];
/*      */     }
/*      */ 
/*      */     
/*      */     public MemoryStack push() {
/*  183 */       if (this.frameIndex == this.debugFrames.length) {
/*  184 */         frameOverflow();
/*      */       }
/*      */       
/*  187 */       this.debugFrames[this.frameIndex] = StackWalkUtil.stackWalkGetMethod(MemoryStack.class);
/*      */       
/*  189 */       return super.push();
/*      */     }
/*      */     
/*      */     private void frameOverflow() {
/*  193 */       this.debugFrames = Arrays.copyOf(this.debugFrames, this.debugFrames.length * 3 / 2);
/*      */     }
/*      */ 
/*      */     
/*      */     public MemoryStack pop() {
/*  198 */       Object object1 = this.debugFrames[this.frameIndex - 1];
/*      */       Object object2;
/*  200 */       if ((object2 = StackWalkUtil.stackWalkCheckPop(MemoryStack.class, object1)) != null) {
/*  201 */         reportAsymmetricPop(object1, object2);
/*      */       }
/*      */       
/*  204 */       this.debugFrames[this.frameIndex - 1] = null;
/*  205 */       return super.pop();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/*  211 */       this.debugFrames[this.frameIndex - 1] = null;
/*  212 */       super.pop();
/*      */     }
/*      */     
/*      */     private static void reportAsymmetricPop(Object param1Object1, Object param1Object2) {
/*  216 */       APIUtil.DEBUG_STREAM.format("[LWJGL] Asymmetric pop detected:\n\tPUSHED: %s\n\tPOPPED: %s\n\tTHREAD: %s\n", new Object[] { param1Object1, param1Object2, 
/*      */ 
/*      */ 
/*      */             
/*  220 */             Thread.currentThread() });
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
/*      */   public long getAddress() {
/*  232 */     return this.address;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSize() {
/*  241 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFrameIndex() {
/*  250 */     return this.frameIndex;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getPointerAddress() {
/*  255 */     return this.address + (this.pointer & 0xFFFFFFFFL);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPointer() {
/*  267 */     return this.pointer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPointer(int paramInt) {
/*  277 */     if (Checks.CHECKS) {
/*  278 */       checkPointer(paramInt);
/*      */     }
/*      */     
/*  281 */     this.pointer = paramInt;
/*      */   }
/*      */   
/*      */   private void checkPointer(int paramInt) {
/*  285 */     if (paramInt < 0 || this.size < paramInt) {
/*  286 */       throw new IndexOutOfBoundsException("Invalid stack pointer");
/*      */     }
/*      */   }
/*      */   
/*      */   private static void checkAlignment(int paramInt) {
/*  291 */     if (Integer.bitCount(paramInt) != 1) {
/*  292 */       throw new IllegalArgumentException("Alignment must be a power-of-two value.");
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
/*      */   public long nmalloc(int paramInt) {
/*  304 */     return nmalloc(POINTER_SIZE, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long nmalloc(int paramInt1, int paramInt2) {
/*  318 */     long l = this.address + this.pointer - paramInt2 & (Integer.toUnsignedLong(paramInt1 - 1) ^ 0xFFFFFFFFFFFFFFFFL);
/*      */     
/*  320 */     this.pointer = (int)(l - this.address);
/*  321 */     if (Checks.CHECKS && this.pointer < 0) {
/*  322 */       throw new OutOfMemoryError("Out of stack space.");
/*      */     }
/*      */     
/*  325 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long ncalloc(int paramInt1, int paramInt2, int paramInt3) {
/*  339 */     paramInt2 *= paramInt3;
/*      */     long l;
/*  341 */     MemoryUtil.memSet(l = nmalloc(paramInt1, paramInt2), 0, paramInt2);
/*  342 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer malloc(int paramInt1, int paramInt2) {
/*  356 */     if (Checks.DEBUG) {
/*  357 */       checkAlignment(paramInt1);
/*      */     }
/*  359 */     return ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, nmalloc(paramInt1, paramInt2), paramInt2)).order(MemoryUtil.NATIVE_ORDER);
/*      */   }
/*      */   
/*      */   public ByteBuffer calloc(int paramInt1, int paramInt2) {
/*  363 */     if (Checks.DEBUG) {
/*  364 */       checkAlignment(paramInt1);
/*      */     }
/*  366 */     return ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, ncalloc(paramInt1, paramInt2, 1), paramInt2)).order(MemoryUtil.NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer malloc(int paramInt) {
/*  377 */     return ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, nmalloc(POINTER_SIZE, paramInt), paramInt)).order(MemoryUtil.NATIVE_ORDER);
/*      */   }
/*      */   
/*      */   public ByteBuffer calloc(int paramInt) {
/*  381 */     return ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, ncalloc(POINTER_SIZE, paramInt, 1), paramInt)).order(MemoryUtil.NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nbyte(byte paramByte) {
/*      */     long l;
/*  387 */     MemoryUtil.memPutByte(l = nmalloc(1, 1), paramByte);
/*  388 */     return l;
/*      */   }
/*      */   public ByteBuffer bytes(byte paramByte) {
/*  391 */     return malloc(1, 1).put(0, paramByte);
/*      */   } public ByteBuffer bytes(byte paramByte1, byte paramByte2) {
/*  393 */     return malloc(1, 2).put(0, paramByte1).put(1, paramByte2);
/*      */   } public ByteBuffer bytes(byte paramByte1, byte paramByte2, byte paramByte3) {
/*  395 */     return malloc(1, 3).put(0, paramByte1).put(1, paramByte2).put(2, paramByte3);
/*      */   } public ByteBuffer bytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
/*  397 */     return malloc(1, 4).put(0, paramByte1).put(1, paramByte2).put(2, paramByte3).put(3, paramByte4);
/*      */   }
/*      */   public ByteBuffer bytes(byte... paramVarArgs) {
/*      */     ByteBuffer byteBuffer;
/*  401 */     (byteBuffer = malloc(1, paramVarArgs.length).put(paramVarArgs)).flip();
/*  402 */     return byteBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ShortBuffer mallocShort(int paramInt) {
/*  408 */     return MemoryUtil.<ShortBuffer>wrap(MemoryUtil.BUFFER_SHORT, nmalloc(2, paramInt << 1), paramInt);
/*      */   }
/*      */   public ShortBuffer callocShort(int paramInt) {
/*  411 */     int i = paramInt << 1;
/*      */     long l;
/*  413 */     MemoryUtil.memSet(l = nmalloc(2, i), 0, i);
/*  414 */     return MemoryUtil.<ShortBuffer>wrap(MemoryUtil.BUFFER_SHORT, l, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nshort(short paramShort) {
/*      */     long l;
/*  420 */     MemoryUtil.memPutShort(l = nmalloc(2, 2), paramShort);
/*  421 */     return l;
/*      */   }
/*      */   public ShortBuffer shorts(short paramShort) {
/*  424 */     return mallocShort(1).put(0, paramShort);
/*      */   } public ShortBuffer shorts(short paramShort1, short paramShort2) {
/*  426 */     return mallocShort(2).put(0, paramShort1).put(1, paramShort2);
/*      */   } public ShortBuffer shorts(short paramShort1, short paramShort2, short paramShort3) {
/*  428 */     return mallocShort(3).put(0, paramShort1).put(1, paramShort2).put(2, paramShort3);
/*      */   } public ShortBuffer shorts(short paramShort1, short paramShort2, short paramShort3, short paramShort4) {
/*  430 */     return mallocShort(4).put(0, paramShort1).put(1, paramShort2).put(2, paramShort3).put(3, paramShort4);
/*      */   }
/*      */   public ShortBuffer shorts(short... paramVarArgs) {
/*      */     ShortBuffer shortBuffer;
/*  434 */     (shortBuffer = mallocShort(paramVarArgs.length).put(paramVarArgs)).flip();
/*  435 */     return shortBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IntBuffer mallocInt(int paramInt) {
/*  441 */     return MemoryUtil.<IntBuffer>wrap(MemoryUtil.BUFFER_INT, nmalloc(4, paramInt << 2), paramInt);
/*      */   }
/*      */   public IntBuffer callocInt(int paramInt) {
/*  444 */     int i = paramInt << 2;
/*      */     long l;
/*  446 */     MemoryUtil.memSet(l = nmalloc(4, i), 0, i);
/*  447 */     return MemoryUtil.<IntBuffer>wrap(MemoryUtil.BUFFER_INT, l, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nint(int paramInt) {
/*      */     long l;
/*  453 */     MemoryUtil.memPutInt(l = nmalloc(4, 4), paramInt);
/*  454 */     return l;
/*      */   }
/*      */   public IntBuffer ints(int paramInt) {
/*  457 */     return mallocInt(1).put(0, paramInt);
/*      */   } public IntBuffer ints(int paramInt1, int paramInt2) {
/*  459 */     return mallocInt(2).put(0, paramInt1).put(1, paramInt2);
/*      */   } public IntBuffer ints(int paramInt1, int paramInt2, int paramInt3) {
/*  461 */     return mallocInt(3).put(0, paramInt1).put(1, paramInt2).put(2, paramInt3);
/*      */   } public IntBuffer ints(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  463 */     return mallocInt(4).put(0, paramInt1).put(1, paramInt2).put(2, paramInt3).put(3, paramInt4);
/*      */   }
/*      */   public IntBuffer ints(int... paramVarArgs) {
/*      */     IntBuffer intBuffer;
/*  467 */     (intBuffer = mallocInt(paramVarArgs.length).put(paramVarArgs)).flip();
/*  468 */     return intBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LongBuffer mallocLong(int paramInt) {
/*  474 */     return MemoryUtil.<LongBuffer>wrap(MemoryUtil.BUFFER_LONG, nmalloc(8, paramInt << 3), paramInt);
/*      */   }
/*      */   public LongBuffer callocLong(int paramInt) {
/*  477 */     int i = paramInt << 3;
/*      */     long l;
/*  479 */     MemoryUtil.memSet(l = nmalloc(8, i), 0, i);
/*  480 */     return MemoryUtil.<LongBuffer>wrap(MemoryUtil.BUFFER_LONG, l, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nlong(long paramLong) {
/*      */     long l;
/*  486 */     MemoryUtil.memPutLong(l = nmalloc(8, 8), paramLong);
/*  487 */     return l;
/*      */   }
/*      */   public LongBuffer longs(long paramLong) {
/*  490 */     return mallocLong(1).put(0, paramLong);
/*      */   } public LongBuffer longs(long paramLong1, long paramLong2) {
/*  492 */     return mallocLong(2).put(0, paramLong1).put(1, paramLong2);
/*      */   } public LongBuffer longs(long paramLong1, long paramLong2, long paramLong3) {
/*  494 */     return mallocLong(3).put(0, paramLong1).put(1, paramLong2).put(2, paramLong3);
/*      */   } public LongBuffer longs(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  496 */     return mallocLong(4).put(0, paramLong1).put(1, paramLong2).put(2, paramLong3).put(3, paramLong4);
/*      */   }
/*      */   public LongBuffer longs(long... paramVarArgs) {
/*      */     LongBuffer longBuffer;
/*  500 */     (longBuffer = mallocLong(paramVarArgs.length).put(paramVarArgs)).flip();
/*  501 */     return longBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CLongBuffer mallocCLong(int paramInt) {
/*  507 */     return CLongBuffer.create(nmalloc(CLONG_SIZE, paramInt << CLONG_SHIFT), paramInt);
/*      */   }
/*      */   public CLongBuffer callocCLong(int paramInt) {
/*  510 */     int i = paramInt * CLONG_SIZE;
/*      */     long l;
/*  512 */     MemoryUtil.memSet(l = nmalloc(CLONG_SIZE, i), 0, i);
/*  513 */     return CLongBuffer.create(l, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nclong(long paramLong) {
/*      */     long l;
/*  519 */     MemoryUtil.memPutCLong(l = nmalloc(CLONG_SIZE, CLONG_SIZE), paramLong);
/*  520 */     return l;
/*      */   }
/*      */   public CLongBuffer clongs(long paramLong) {
/*  523 */     return mallocCLong(1).put(0, paramLong);
/*      */   } public CLongBuffer clongs(long paramLong1, long paramLong2) {
/*  525 */     return mallocCLong(2).put(0, paramLong1).put(1, paramLong2);
/*      */   } public CLongBuffer clongs(long paramLong1, long paramLong2, long paramLong3) {
/*  527 */     return mallocCLong(3).put(0, paramLong1).put(1, paramLong2).put(2, paramLong3);
/*      */   } public CLongBuffer clongs(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  529 */     return mallocCLong(4).put(0, paramLong1).put(1, paramLong2).put(2, paramLong3).put(3, paramLong4);
/*      */   }
/*      */   public CLongBuffer clongs(long... paramVarArgs) {
/*      */     CLongBuffer cLongBuffer;
/*  533 */     (cLongBuffer = mallocCLong(paramVarArgs.length).put(paramVarArgs)).flip();
/*  534 */     return cLongBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public FloatBuffer mallocFloat(int paramInt) {
/*  540 */     return MemoryUtil.<FloatBuffer>wrap(MemoryUtil.BUFFER_FLOAT, nmalloc(4, paramInt << 2), paramInt);
/*      */   }
/*      */   public FloatBuffer callocFloat(int paramInt) {
/*  543 */     int i = paramInt << 2;
/*      */     long l;
/*  545 */     MemoryUtil.memSet(l = nmalloc(4, i), 0, i);
/*  546 */     return MemoryUtil.<FloatBuffer>wrap(MemoryUtil.BUFFER_FLOAT, l, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nfloat(float paramFloat) {
/*      */     long l;
/*  552 */     MemoryUtil.memPutFloat(l = nmalloc(4, 4), paramFloat);
/*  553 */     return l;
/*      */   }
/*      */   public FloatBuffer floats(float paramFloat) {
/*  556 */     return mallocFloat(1).put(0, paramFloat);
/*      */   } public FloatBuffer floats(float paramFloat1, float paramFloat2) {
/*  558 */     return mallocFloat(2).put(0, paramFloat1).put(1, paramFloat2);
/*      */   } public FloatBuffer floats(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  560 */     return mallocFloat(3).put(0, paramFloat1).put(1, paramFloat2).put(2, paramFloat3);
/*      */   } public FloatBuffer floats(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  562 */     return mallocFloat(4).put(0, paramFloat1).put(1, paramFloat2).put(2, paramFloat3).put(3, paramFloat4);
/*      */   }
/*      */   public FloatBuffer floats(float... paramVarArgs) {
/*      */     FloatBuffer floatBuffer;
/*  566 */     (floatBuffer = mallocFloat(paramVarArgs.length).put(paramVarArgs)).flip();
/*  567 */     return floatBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public DoubleBuffer mallocDouble(int paramInt) {
/*  573 */     return MemoryUtil.<DoubleBuffer>wrap(MemoryUtil.BUFFER_DOUBLE, nmalloc(8, paramInt << 3), paramInt);
/*      */   }
/*      */   public DoubleBuffer callocDouble(int paramInt) {
/*  576 */     int i = paramInt << 3;
/*      */     long l;
/*  578 */     MemoryUtil.memSet(l = nmalloc(8, i), 0, i);
/*  579 */     return MemoryUtil.<DoubleBuffer>wrap(MemoryUtil.BUFFER_DOUBLE, l, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long ndouble(double paramDouble) {
/*      */     long l;
/*  585 */     MemoryUtil.memPutDouble(l = nmalloc(8, 8), paramDouble);
/*  586 */     return l;
/*      */   }
/*      */   public DoubleBuffer doubles(double paramDouble) {
/*  589 */     return mallocDouble(1).put(0, paramDouble);
/*      */   } public DoubleBuffer doubles(double paramDouble1, double paramDouble2) {
/*  591 */     return mallocDouble(2).put(0, paramDouble1).put(1, paramDouble2);
/*      */   } public DoubleBuffer doubles(double paramDouble1, double paramDouble2, double paramDouble3) {
/*  593 */     return mallocDouble(3).put(0, paramDouble1).put(1, paramDouble2).put(2, paramDouble3);
/*      */   } public DoubleBuffer doubles(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/*  595 */     return mallocDouble(4).put(0, paramDouble1).put(1, paramDouble2).put(2, paramDouble3).put(3, paramDouble4);
/*      */   }
/*      */   public DoubleBuffer doubles(double... paramVarArgs) {
/*      */     DoubleBuffer doubleBuffer;
/*  599 */     (doubleBuffer = mallocDouble(paramVarArgs.length).put(paramVarArgs)).flip();
/*  600 */     return doubleBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public PointerBuffer mallocPointer(int paramInt) {
/*  606 */     return PointerBuffer.create(nmalloc(POINTER_SIZE, paramInt << POINTER_SHIFT), paramInt);
/*      */   }
/*      */   public PointerBuffer callocPointer(int paramInt) {
/*  609 */     int i = paramInt * POINTER_SIZE;
/*      */     long l;
/*  611 */     MemoryUtil.memSet(l = nmalloc(POINTER_SIZE, i), 0, i);
/*  612 */     return PointerBuffer.create(l, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long npointer(long paramLong) {
/*      */     long l;
/*  618 */     MemoryUtil.memPutAddress(l = nmalloc(POINTER_SIZE, POINTER_SIZE), paramLong);
/*  619 */     return l;
/*      */   }
/*      */   public PointerBuffer pointers(long paramLong) {
/*  622 */     return mallocPointer(1).put(0, paramLong);
/*      */   } public PointerBuffer pointers(long paramLong1, long paramLong2) {
/*  624 */     return mallocPointer(2).put(0, paramLong1).put(1, paramLong2);
/*      */   } public PointerBuffer pointers(long paramLong1, long paramLong2, long paramLong3) {
/*  626 */     return mallocPointer(3).put(0, paramLong1).put(1, paramLong2).put(2, paramLong3);
/*      */   } public PointerBuffer pointers(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  628 */     return mallocPointer(4).put(0, paramLong1).put(1, paramLong2).put(2, paramLong3).put(3, paramLong4);
/*      */   }
/*      */   public PointerBuffer pointers(long... paramVarArgs) {
/*      */     PointerBuffer pointerBuffer;
/*  632 */     (pointerBuffer = mallocPointer(paramVarArgs.length).put(paramVarArgs)).flip();
/*  633 */     return pointerBuffer;
/*      */   }
/*      */ 
/*      */   
/*      */   public long npointer(Pointer paramPointer) {
/*      */     long l;
/*  639 */     MemoryUtil.memPutAddress(l = nmalloc(POINTER_SIZE, POINTER_SIZE), paramPointer.address());
/*  640 */     return l;
/*      */   }
/*      */   public PointerBuffer pointers(Pointer paramPointer) {
/*  643 */     return mallocPointer(1).put(0, paramPointer);
/*      */   } public PointerBuffer pointers(Pointer paramPointer1, Pointer paramPointer2) {
/*  645 */     return mallocPointer(2).put(0, paramPointer1).put(1, paramPointer2);
/*      */   } public PointerBuffer pointers(Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3) {
/*  647 */     return mallocPointer(3).put(0, paramPointer1).put(1, paramPointer2).put(2, paramPointer3);
/*      */   } public PointerBuffer pointers(Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3, Pointer paramPointer4) {
/*  649 */     return mallocPointer(4).put(0, paramPointer1).put(1, paramPointer2).put(2, paramPointer3).put(3, paramPointer4);
/*      */   }
/*      */   public PointerBuffer pointers(Pointer... paramVarArgs) {
/*  652 */     PointerBuffer pointerBuffer = mallocPointer(paramVarArgs.length);
/*  653 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  654 */       pointerBuffer.put(b, paramVarArgs[b]);
/*      */     }
/*  656 */     return pointerBuffer;
/*      */   }
/*      */ 
/*      */   
/*      */   public long npointer(Buffer paramBuffer) {
/*      */     long l;
/*  662 */     MemoryUtil.memPutAddress(l = nmalloc(POINTER_SIZE, POINTER_SIZE), MemoryUtil.memAddress(paramBuffer));
/*  663 */     return l;
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer paramBuffer) {
/*  667 */     return mallocPointer(1)
/*  668 */       .put(0, MemoryUtil.memAddress(paramBuffer));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer paramBuffer1, Buffer paramBuffer2) {
/*  672 */     return mallocPointer(2)
/*  673 */       .put(0, MemoryUtil.memAddress(paramBuffer1))
/*  674 */       .put(1, MemoryUtil.memAddress(paramBuffer2));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer paramBuffer1, Buffer paramBuffer2, Buffer paramBuffer3) {
/*  678 */     return mallocPointer(3)
/*  679 */       .put(0, MemoryUtil.memAddress(paramBuffer1))
/*  680 */       .put(1, MemoryUtil.memAddress(paramBuffer2))
/*  681 */       .put(2, MemoryUtil.memAddress(paramBuffer3));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer paramBuffer1, Buffer paramBuffer2, Buffer paramBuffer3, Buffer paramBuffer4) {
/*  685 */     return mallocPointer(4)
/*  686 */       .put(0, MemoryUtil.memAddress(paramBuffer1))
/*  687 */       .put(1, MemoryUtil.memAddress(paramBuffer2))
/*  688 */       .put(2, MemoryUtil.memAddress(paramBuffer3))
/*  689 */       .put(3, MemoryUtil.memAddress(paramBuffer4));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer... paramVarArgs) {
/*  693 */     PointerBuffer pointerBuffer = mallocPointer(paramVarArgs.length);
/*  694 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  695 */       pointerBuffer.put(b, MemoryUtil.memAddress(paramVarArgs[b]));
/*      */     }
/*  697 */     return pointerBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PointerBuffer pointersOfElements(CustomBuffer<?> paramCustomBuffer) {
/*  712 */     int i = paramCustomBuffer.remaining();
/*  713 */     long l1 = paramCustomBuffer.address();
/*  714 */     long l2 = paramCustomBuffer.sizeof();
/*      */     
/*  716 */     PointerBuffer pointerBuffer = mallocPointer(i);
/*  717 */     for (byte b = 0; b < i; b++) {
/*  718 */       pointerBuffer.put(b, l1 + l2 * b);
/*      */     }
/*      */     
/*  721 */     return pointerBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer ASCII(CharSequence paramCharSequence) {
/*  735 */     return ASCII(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer ASCII(CharSequence paramCharSequence, boolean paramBoolean) {
/*  747 */     int i = MemoryUtil.memLengthASCII(paramCharSequence, paramBoolean);
/*  748 */     long l = nmalloc(POINTER_SIZE, i);
/*  749 */     MemoryUtil.encodeASCIIUnsafe(paramCharSequence, paramBoolean, l);
/*  750 */     return ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, l, i)).order(MemoryUtil.NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nASCII(CharSequence paramCharSequence, boolean paramBoolean) {
/*  763 */     long l = nmalloc(POINTER_SIZE, MemoryUtil.memLengthASCII(paramCharSequence, paramBoolean));
/*  764 */     return MemoryUtil.encodeASCIIUnsafe(paramCharSequence, paramBoolean, l);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer ASCIISafe(CharSequence paramCharSequence) {
/*  770 */     return ASCIISafe(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer ASCIISafe(CharSequence paramCharSequence, boolean paramBoolean) {
/*  776 */     return (paramCharSequence == null) ? null : ASCII(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public int nASCIISafe(CharSequence paramCharSequence, boolean paramBoolean) {
/*  781 */     return (paramCharSequence == null) ? 0 : nASCII(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF8(CharSequence paramCharSequence) {
/*  793 */     return UTF8(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF8(CharSequence paramCharSequence, boolean paramBoolean) {
/*  805 */     int i = MemoryUtil.memLengthUTF8(paramCharSequence, paramBoolean);
/*  806 */     long l = nmalloc(POINTER_SIZE, i);
/*  807 */     MemoryUtil.encodeUTF8Unsafe(paramCharSequence, paramBoolean, l);
/*  808 */     return ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, l, i)).order(MemoryUtil.NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nUTF8(CharSequence paramCharSequence, boolean paramBoolean) {
/*  821 */     long l = nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF8(paramCharSequence, paramBoolean));
/*  822 */     return MemoryUtil.encodeUTF8Unsafe(paramCharSequence, paramBoolean, l);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF8Safe(CharSequence paramCharSequence) {
/*  828 */     return UTF8Safe(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF8Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/*  834 */     return (paramCharSequence == null) ? null : UTF8(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public int nUTF8Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/*  839 */     return (paramCharSequence == null) ? 0 : nUTF8(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF16(CharSequence paramCharSequence) {
/*  851 */     return UTF16(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF16(CharSequence paramCharSequence, boolean paramBoolean) {
/*  863 */     int i = MemoryUtil.memLengthUTF16(paramCharSequence, paramBoolean);
/*  864 */     long l = nmalloc(POINTER_SIZE, i);
/*  865 */     MemoryUtil.encodeUTF16Unsafe(paramCharSequence, paramBoolean, l);
/*  866 */     return ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, l, i)).order(MemoryUtil.NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nUTF16(CharSequence paramCharSequence, boolean paramBoolean) {
/*  879 */     long l = nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF16(paramCharSequence, paramBoolean));
/*  880 */     return MemoryUtil.encodeUTF16Unsafe(paramCharSequence, paramBoolean, l);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF16Safe(CharSequence paramCharSequence) {
/*  886 */     return UTF16Safe(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF16Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/*  892 */     return (paramCharSequence == null) ? null : UTF16(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public int nUTF16Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/*  897 */     return (paramCharSequence == null) ? 0 : nUTF16(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack stackGet() {
/*  906 */     return TLS.get();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack stackPush() {
/*  915 */     return stackGet().push();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack stackPop() {
/*  924 */     return stackGet().pop();
/*      */   }
/*      */   
/*      */   public static long nstackMalloc(int paramInt) {
/*  928 */     return stackGet().nmalloc(paramInt);
/*      */   } public static long nstackMalloc(int paramInt1, int paramInt2) {
/*  930 */     return stackGet().nmalloc(paramInt1, paramInt2);
/*      */   } public static long nstackCalloc(int paramInt1, int paramInt2, int paramInt3) {
/*  932 */     return stackGet().ncalloc(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer stackMalloc(int paramInt) {
/*  937 */     return stackGet().malloc(paramInt);
/*      */   } public static ByteBuffer stackCalloc(int paramInt) {
/*  939 */     return stackGet().calloc(paramInt);
/*      */   }
/*      */   public static ByteBuffer stackBytes(byte paramByte) {
/*  942 */     return stackGet().bytes(paramByte);
/*      */   } public static ByteBuffer stackBytes(byte paramByte1, byte paramByte2) {
/*  944 */     return stackGet().bytes(paramByte1, paramByte2);
/*      */   } public static ByteBuffer stackBytes(byte paramByte1, byte paramByte2, byte paramByte3) {
/*  946 */     return stackGet().bytes(paramByte1, paramByte2, paramByte3);
/*      */   } public static ByteBuffer stackBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
/*  948 */     return stackGet().bytes(paramByte1, paramByte2, paramByte3, paramByte4);
/*      */   } public static ByteBuffer stackBytes(byte... paramVarArgs) {
/*  950 */     return stackGet().bytes(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ShortBuffer stackMallocShort(int paramInt) {
/*  955 */     return stackGet().mallocShort(paramInt);
/*      */   } public static ShortBuffer stackCallocShort(int paramInt) {
/*  957 */     return stackGet().callocShort(paramInt);
/*      */   }
/*      */   public static ShortBuffer stackShorts(short paramShort) {
/*  960 */     return stackGet().shorts(paramShort);
/*      */   } public static ShortBuffer stackShorts(short paramShort1, short paramShort2) {
/*  962 */     return stackGet().shorts(paramShort1, paramShort2);
/*      */   } public static ShortBuffer stackShorts(short paramShort1, short paramShort2, short paramShort3) {
/*  964 */     return stackGet().shorts(paramShort1, paramShort2, paramShort3);
/*      */   } public static ShortBuffer stackShorts(short paramShort1, short paramShort2, short paramShort3, short paramShort4) {
/*  966 */     return stackGet().shorts(paramShort1, paramShort2, paramShort3, paramShort4);
/*      */   } public static ShortBuffer stackShorts(short... paramVarArgs) {
/*  968 */     return stackGet().shorts(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IntBuffer stackMallocInt(int paramInt) {
/*  973 */     return stackGet().mallocInt(paramInt);
/*      */   } public static IntBuffer stackCallocInt(int paramInt) {
/*  975 */     return stackGet().callocInt(paramInt);
/*      */   }
/*      */   public static IntBuffer stackInts(int paramInt) {
/*  978 */     return stackGet().ints(paramInt);
/*      */   } public static IntBuffer stackInts(int paramInt1, int paramInt2) {
/*  980 */     return stackGet().ints(paramInt1, paramInt2);
/*      */   } public static IntBuffer stackInts(int paramInt1, int paramInt2, int paramInt3) {
/*  982 */     return stackGet().ints(paramInt1, paramInt2, paramInt3);
/*      */   } public static IntBuffer stackInts(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  984 */     return stackGet().ints(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   } public static IntBuffer stackInts(int... paramVarArgs) {
/*  986 */     return stackGet().ints(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static LongBuffer stackMallocLong(int paramInt) {
/*  991 */     return stackGet().mallocLong(paramInt);
/*      */   } public static LongBuffer stackCallocLong(int paramInt) {
/*  993 */     return stackGet().callocLong(paramInt);
/*      */   }
/*      */   public static LongBuffer stackLongs(long paramLong) {
/*  996 */     return stackGet().longs(paramLong);
/*      */   } public static LongBuffer stackLongs(long paramLong1, long paramLong2) {
/*  998 */     return stackGet().longs(paramLong1, paramLong2);
/*      */   } public static LongBuffer stackLongs(long paramLong1, long paramLong2, long paramLong3) {
/* 1000 */     return stackGet().longs(paramLong1, paramLong2, paramLong3);
/*      */   } public static LongBuffer stackLongs(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 1002 */     return stackGet().longs(paramLong1, paramLong2, paramLong3, paramLong4);
/*      */   } public static LongBuffer stackLongs(long... paramVarArgs) {
/* 1004 */     return stackGet().longs(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static CLongBuffer stackMallocCLong(int paramInt) {
/* 1009 */     return stackGet().mallocCLong(paramInt);
/*      */   } public static CLongBuffer stackCallocCLong(int paramInt) {
/* 1011 */     return stackGet().callocCLong(paramInt);
/*      */   }
/*      */   public static CLongBuffer stackCLongs(long paramLong) {
/* 1014 */     return stackGet().clongs(paramLong);
/*      */   } public static CLongBuffer stackCLongs(long paramLong1, long paramLong2) {
/* 1016 */     return stackGet().clongs(paramLong1, paramLong2);
/*      */   } public static CLongBuffer stackCLongs(long paramLong1, long paramLong2, long paramLong3) {
/* 1018 */     return stackGet().clongs(paramLong1, paramLong2, paramLong3);
/*      */   } public static CLongBuffer stackCLongs(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 1020 */     return stackGet().clongs(paramLong1, paramLong2, paramLong3, paramLong4);
/*      */   } public static CLongBuffer stackCLongs(long... paramVarArgs) {
/* 1022 */     return stackGet().clongs(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static FloatBuffer stackMallocFloat(int paramInt) {
/* 1027 */     return stackGet().mallocFloat(paramInt);
/*      */   } public static FloatBuffer stackCallocFloat(int paramInt) {
/* 1029 */     return stackGet().callocFloat(paramInt);
/*      */   }
/*      */   public static FloatBuffer stackFloats(float paramFloat) {
/* 1032 */     return stackGet().floats(paramFloat);
/*      */   } public static FloatBuffer stackFloats(float paramFloat1, float paramFloat2) {
/* 1034 */     return stackGet().floats(paramFloat1, paramFloat2);
/*      */   } public static FloatBuffer stackFloats(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1036 */     return stackGet().floats(paramFloat1, paramFloat2, paramFloat3);
/*      */   } public static FloatBuffer stackFloats(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1038 */     return stackGet().floats(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   } public static FloatBuffer stackFloats(float... paramVarArgs) {
/* 1040 */     return stackGet().floats(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static DoubleBuffer stackMallocDouble(int paramInt) {
/* 1045 */     return stackGet().mallocDouble(paramInt);
/*      */   } public static DoubleBuffer stackCallocDouble(int paramInt) {
/* 1047 */     return stackGet().callocDouble(paramInt);
/*      */   }
/*      */   public static DoubleBuffer stackDoubles(double paramDouble) {
/* 1050 */     return stackGet().doubles(paramDouble);
/*      */   } public static DoubleBuffer stackDoubles(double paramDouble1, double paramDouble2) {
/* 1052 */     return stackGet().doubles(paramDouble1, paramDouble2);
/*      */   } public static DoubleBuffer stackDoubles(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1054 */     return stackGet().doubles(paramDouble1, paramDouble2, paramDouble3);
/*      */   } public static DoubleBuffer stackDoubles(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 1056 */     return stackGet().doubles(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*      */   } public static DoubleBuffer stackDoubles(double... paramVarArgs) {
/* 1058 */     return stackGet().doubles(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static PointerBuffer stackMallocPointer(int paramInt) {
/* 1063 */     return stackGet().mallocPointer(paramInt);
/*      */   } public static PointerBuffer stackCallocPointer(int paramInt) {
/* 1065 */     return stackGet().callocPointer(paramInt);
/*      */   }
/*      */   public static PointerBuffer stackPointers(long paramLong) {
/* 1068 */     return stackGet().pointers(paramLong);
/*      */   } public static PointerBuffer stackPointers(long paramLong1, long paramLong2) {
/* 1070 */     return stackGet().pointers(paramLong1, paramLong2);
/*      */   } public static PointerBuffer stackPointers(long paramLong1, long paramLong2, long paramLong3) {
/* 1072 */     return stackGet().pointers(paramLong1, paramLong2, paramLong3);
/*      */   } public static PointerBuffer stackPointers(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 1074 */     return stackGet().pointers(paramLong1, paramLong2, paramLong3, paramLong4);
/*      */   } public static PointerBuffer stackPointers(long... paramVarArgs) {
/* 1076 */     return stackGet().pointers(paramVarArgs);
/*      */   }
/*      */   public static PointerBuffer stackPointers(Pointer paramPointer) {
/* 1079 */     return stackGet().pointers(paramPointer);
/*      */   } public static PointerBuffer stackPointers(Pointer paramPointer1, Pointer paramPointer2) {
/* 1081 */     return stackGet().pointers(paramPointer1, paramPointer2);
/*      */   } public static PointerBuffer stackPointers(Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3) {
/* 1083 */     return stackGet().pointers(paramPointer1, paramPointer2, paramPointer3);
/*      */   } public static PointerBuffer stackPointers(Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3, Pointer paramPointer4) {
/* 1085 */     return stackGet().pointers(paramPointer1, paramPointer2, paramPointer3, paramPointer4);
/*      */   } public static PointerBuffer stackPointers(Pointer... paramVarArgs) {
/* 1087 */     return stackGet().pointers(paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer stackASCII(CharSequence paramCharSequence) {
/* 1092 */     return stackGet().ASCII(paramCharSequence);
/*      */   }
/*      */   public static ByteBuffer stackASCII(CharSequence paramCharSequence, boolean paramBoolean) {
/* 1095 */     return stackGet().ASCII(paramCharSequence, paramBoolean);
/*      */   }
/*      */   public static ByteBuffer stackUTF8(CharSequence paramCharSequence) {
/* 1098 */     return stackGet().UTF8(paramCharSequence);
/*      */   }
/*      */   public static ByteBuffer stackUTF8(CharSequence paramCharSequence, boolean paramBoolean) {
/* 1101 */     return stackGet().UTF8(paramCharSequence, paramBoolean);
/*      */   }
/*      */   public static ByteBuffer stackUTF16(CharSequence paramCharSequence) {
/* 1104 */     return stackGet().UTF16(paramCharSequence);
/*      */   }
/*      */   public static ByteBuffer stackUTF16(CharSequence paramCharSequence, boolean paramBoolean) {
/* 1107 */     return stackGet().UTF16(paramCharSequence, paramBoolean);
/*      */   }
/*      */   public static ByteBuffer stackASCIISafe(CharSequence paramCharSequence) {
/* 1110 */     return stackGet().ASCIISafe(paramCharSequence);
/*      */   }
/*      */   public static ByteBuffer stackASCIISafe(CharSequence paramCharSequence, boolean paramBoolean) {
/* 1113 */     return stackGet().ASCIISafe(paramCharSequence, paramBoolean);
/*      */   }
/*      */   public static ByteBuffer stackUTF8Safe(CharSequence paramCharSequence) {
/* 1116 */     return stackGet().UTF8Safe(paramCharSequence);
/*      */   }
/*      */   public static ByteBuffer stackUTF8Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/* 1119 */     return stackGet().UTF8Safe(paramCharSequence, paramBoolean);
/*      */   }
/*      */   public static ByteBuffer stackUTF16Safe(CharSequence paramCharSequence) {
/* 1122 */     return stackGet().UTF16Safe(paramCharSequence);
/*      */   }
/*      */   public static ByteBuffer stackUTF16Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/* 1125 */     return stackGet().UTF16Safe(paramCharSequence, paramBoolean);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\MemoryStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */