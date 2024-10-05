/*     */ package org.lwjgl.system.macosx;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGEventTapInformation
/*     */   extends Struct<CGEventTapInformation>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int EVENTTAPID;
/*     */   public static final int TAPPOINT;
/*     */   public static final int OPTIONS;
/*     */   public static final int EVENTSOFINTEREST;
/*     */   public static final int TAPPINGPROCESS;
/*     */   public static final int PROCESSBEINGTAPPED;
/*     */   public static final int ENABLED;
/*     */   public static final int MINUSECLATENCY;
/*     */   public static final int AVGUSECLATENCY;
/*     */   public static final int MAXUSECLATENCY;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  72 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(8), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(1), __member(4), __member(4), __member(4) })).getSize();
/*  73 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  75 */     EVENTTAPID = layout.offsetof(0);
/*  76 */     TAPPOINT = layout.offsetof(1);
/*  77 */     OPTIONS = layout.offsetof(2);
/*  78 */     EVENTSOFINTEREST = layout.offsetof(3);
/*  79 */     TAPPINGPROCESS = layout.offsetof(4);
/*  80 */     PROCESSBEINGTAPPED = layout.offsetof(5);
/*  81 */     ENABLED = layout.offsetof(6);
/*  82 */     MINUSECLATENCY = layout.offsetof(7);
/*  83 */     AVGUSECLATENCY = layout.offsetof(8);
/*  84 */     MAXUSECLATENCY = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected CGEventTapInformation(long paramLong, ByteBuffer paramByteBuffer) {
/*  88 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CGEventTapInformation create(long paramLong, ByteBuffer paramByteBuffer) {
/*  93 */     return new CGEventTapInformation(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGEventTapInformation(ByteBuffer paramByteBuffer) {
/* 103 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 107 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("uint32_t")
/*     */   public int eventTapID() {
/* 111 */     return neventTapID(address());
/*     */   } @NativeType("CGEventTapLocation")
/*     */   public int tapPoint() {
/* 114 */     return ntapPoint(address());
/*     */   } @NativeType("CGEventTapOptions")
/*     */   public int options() {
/* 117 */     return noptions(address());
/*     */   } @NativeType("CGEventMask")
/*     */   public long eventsOfInterest() {
/* 120 */     return neventsOfInterest(address());
/*     */   } @NativeType("pid_t")
/*     */   public long tappingProcess() {
/* 123 */     return ntappingProcess(address());
/*     */   } @NativeType("pid_t")
/*     */   public long processBeingTapped() {
/* 126 */     return nprocessBeingTapped(address());
/*     */   } @NativeType("bool")
/*     */   public boolean enabled() {
/* 129 */     return nenabled(address());
/*     */   } public float minUsecLatency() {
/* 131 */     return nminUsecLatency(address());
/*     */   } public float avgUsecLatency() {
/* 133 */     return navgUsecLatency(address());
/*     */   } public float maxUsecLatency() {
/* 135 */     return nmaxUsecLatency(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation malloc() {
/* 141 */     return new CGEventTapInformation(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation calloc() {
/* 146 */     return new CGEventTapInformation(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation create() {
/* 151 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 152 */     return new CGEventTapInformation(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation create(long paramLong) {
/* 157 */     return new CGEventTapInformation(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation createSafe(long paramLong) {
/* 163 */     return (paramLong == 0L) ? null : new CGEventTapInformation(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 172 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 181 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 190 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 191 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 201 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 207 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static CGEventTapInformation mallocStack() {
/* 213 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 215 */   public static CGEventTapInformation callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 217 */   public static CGEventTapInformation mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 219 */   public static CGEventTapInformation callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 221 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 223 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 225 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 227 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation malloc(MemoryStack paramMemoryStack) {
/* 235 */     return new CGEventTapInformation(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation calloc(MemoryStack paramMemoryStack) {
/* 244 */     return new CGEventTapInformation(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 254 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 264 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int neventTapID(long paramLong) {
/* 270 */     return UNSAFE.getInt(null, paramLong + EVENTTAPID);
/*     */   } public static int ntapPoint(long paramLong) {
/* 272 */     return UNSAFE.getInt(null, paramLong + TAPPOINT);
/*     */   } public static int noptions(long paramLong) {
/* 274 */     return UNSAFE.getInt(null, paramLong + OPTIONS);
/*     */   } public static long neventsOfInterest(long paramLong) {
/* 276 */     return UNSAFE.getLong(null, paramLong + EVENTSOFINTEREST);
/*     */   } public static long ntappingProcess(long paramLong) {
/* 278 */     return MemoryUtil.memGetAddress(paramLong + TAPPINGPROCESS);
/*     */   } public static long nprocessBeingTapped(long paramLong) {
/* 280 */     return MemoryUtil.memGetAddress(paramLong + PROCESSBEINGTAPPED);
/*     */   } public static boolean nenabled(long paramLong) {
/* 282 */     return (UNSAFE.getByte(null, paramLong + ENABLED) != 0);
/*     */   } public static float nminUsecLatency(long paramLong) {
/* 284 */     return UNSAFE.getFloat(null, paramLong + MINUSECLATENCY);
/*     */   } public static float navgUsecLatency(long paramLong) {
/* 286 */     return UNSAFE.getFloat(null, paramLong + AVGUSECLATENCY);
/*     */   } public static float nmaxUsecLatency(long paramLong) {
/* 288 */     return UNSAFE.getFloat(null, paramLong + MAXUSECLATENCY);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<CGEventTapInformation, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 295 */     private static final CGEventTapInformation ELEMENT_FACTORY = CGEventTapInformation.create(-1L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Buffer(ByteBuffer param1ByteBuffer) {
/* 307 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / CGEventTapInformation.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 311 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 315 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 320 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected CGEventTapInformation getElementFactory() {
/* 325 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("uint32_t")
/*     */     public int eventTapID() {
/* 330 */       return CGEventTapInformation.neventTapID(address());
/*     */     } @NativeType("CGEventTapLocation")
/*     */     public int tapPoint() {
/* 333 */       return CGEventTapInformation.ntapPoint(address());
/*     */     } @NativeType("CGEventTapOptions")
/*     */     public int options() {
/* 336 */       return CGEventTapInformation.noptions(address());
/*     */     } @NativeType("CGEventMask")
/*     */     public long eventsOfInterest() {
/* 339 */       return CGEventTapInformation.neventsOfInterest(address());
/*     */     } @NativeType("pid_t")
/*     */     public long tappingProcess() {
/* 342 */       return CGEventTapInformation.ntappingProcess(address());
/*     */     } @NativeType("pid_t")
/*     */     public long processBeingTapped() {
/* 345 */       return CGEventTapInformation.nprocessBeingTapped(address());
/*     */     } @NativeType("bool")
/*     */     public boolean enabled() {
/* 348 */       return CGEventTapInformation.nenabled(address());
/*     */     } public float minUsecLatency() {
/* 350 */       return CGEventTapInformation.nminUsecLatency(address());
/*     */     } public float avgUsecLatency() {
/* 352 */       return CGEventTapInformation.navgUsecLatency(address());
/*     */     } public float maxUsecLatency() {
/* 354 */       return CGEventTapInformation.nmaxUsecLatency(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\CGEventTapInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */