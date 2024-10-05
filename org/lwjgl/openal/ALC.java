/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.HashSet;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.FunctionProviderLocal;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.SharedLibrary;
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
/*     */ public final class ALC
/*     */ {
/*     */   private static FunctionProviderLocal functionProvider;
/*     */   private static ALCCapabilities router;
/*  48 */   private static final ThreadLocal<ALCCapabilities> capabilitiesTLS = new ThreadLocal<>();
/*     */   
/*     */   private static ICD icd;
/*     */ 
/*     */   
/*     */   static {
/*  54 */     if (!((Boolean)Configuration.OPENAL_EXPLICIT_INIT.get(Boolean.FALSE)).booleanValue()) {
/*  55 */       create();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create() {
/*     */     String str;
/*  64 */     switch (Platform.get()) {
/*     */       case LINUX:
/*     */       case MACOSX:
/*  67 */         str = "openal";
/*     */         break;
/*     */       case WINDOWS:
/*  70 */         str = "OpenAL";
/*     */         break;
/*     */       default:
/*  73 */         throw new IllegalStateException();
/*     */     } 
/*     */     
/*  76 */     create((String)Configuration.OPENAL_LIBRARY_NAME.get(Platform.mapLibraryNameBundled(str)));
/*     */   }
/*     */   
/*     */   private static class SharedLibraryAL
/*     */     extends SharedLibrary.Delegate implements FunctionProviderLocal {
/*  81 */     private final long alcGetProcAddress = getFunctionAddress("alcGetProcAddress");
/*     */     
/*     */     protected SharedLibraryAL(SharedLibrary param1SharedLibrary) {
/*  84 */       super(param1SharedLibrary);
/*  85 */       if (this.alcGetProcAddress == 0L) {
/*  86 */         throw new RuntimeException("A core ALC function is missing. Make sure that the OpenAL library has been loaded correctly.");
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public long getFunctionAddress(ByteBuffer param1ByteBuffer) {
/*     */       long l;
/*  93 */       if ((l = this.library.getFunctionAddress(param1ByteBuffer)) == 0L && Checks.DEBUG_FUNCTIONS) {
/*  94 */         APIUtil.apiLogMissing("ALC core", param1ByteBuffer);
/*     */       }
/*  96 */       return l;
/*     */     }
/*     */ 
/*     */     
/*     */     public long getFunctionAddress(long param1Long, ByteBuffer param1ByteBuffer) {
/*     */       long l;
/* 102 */       if ((l = this.library.getFunctionAddress(param1ByteBuffer)) == 0L && param1Long != 0L) {
/* 103 */         l = JNI.invokePPP(param1Long, MemoryUtil.memAddress(param1ByteBuffer), this.alcGetProcAddress);
/*     */       }
/* 105 */       if (l == 0L && Checks.DEBUG_FUNCTIONS) {
/* 106 */         APIUtil.apiLogMissing("ALC", param1ByteBuffer);
/*     */       }
/* 108 */       return l;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(String paramString) {
/* 119 */     SharedLibrary sharedLibrary = Library.loadNative(ALC.class, "org.lwjgl.openal", paramString, true);
/*     */     try {
/* 121 */       create(new SharedLibraryAL(sharedLibrary)); return;
/* 122 */     } catch (RuntimeException runtimeException) {
/* 123 */       sharedLibrary.free();
/* 124 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(FunctionProviderLocal paramFunctionProviderLocal) {
/* 134 */     if (functionProvider != null) {
/* 135 */       throw new IllegalStateException("ALC has already been created.");
/*     */     }
/*     */     
/* 138 */     functionProvider = paramFunctionProviderLocal;
/*     */     
/* 140 */     router = createCapabilities(0L);
/*     */     
/* 142 */     AL.init();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void destroy() {
/* 147 */     if (functionProvider == null) {
/*     */       return;
/*     */     }
/*     */     
/* 151 */     AL.destroy();
/*     */     
/* 153 */     router = null;
/*     */     
/* 155 */     if (functionProvider instanceof NativeResource) {
/* 156 */       ((NativeResource)functionProvider).free();
/*     */     }
/* 158 */     functionProvider = null;
/*     */   }
/*     */   
/*     */   static <T> T check(T paramT) {
/* 162 */     if (paramT == null) {
/* 163 */       throw new IllegalStateException("OpenAL library has not been loaded.");
/*     */     }
/* 165 */     return paramT;
/*     */   }
/*     */ 
/*     */   
/*     */   public static FunctionProviderLocal getFunctionProvider() {
/* 170 */     return check(functionProvider);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCapabilities(ALCCapabilities paramALCCapabilities) {
/* 181 */     capabilitiesTLS.set(paramALCCapabilities);
/* 182 */     if (icd == null) {
/* 183 */       icd = new ICDStatic();
/*     */     }
/* 185 */     icd.set(paramALCCapabilities);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ALCCapabilities getCapabilities() {
/*     */     ALCCapabilities aLCCapabilities;
/* 195 */     if ((aLCCapabilities = capabilitiesTLS.get()) == null) {
/* 196 */       aLCCapabilities = router;
/*     */     }
/*     */     
/* 199 */     return checkCapabilities(aLCCapabilities);
/*     */   }
/*     */   
/*     */   private static ALCCapabilities checkCapabilities(ALCCapabilities paramALCCapabilities) {
/* 203 */     if (paramALCCapabilities == null) {
/* 204 */       throw new IllegalStateException("No ALCCapabilities instance set");
/*     */     }
/* 206 */     return paramALCCapabilities;
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
/*     */   public static ALCCapabilities createCapabilities(long paramLong) {
/* 219 */     return createCapabilities(paramLong, null);
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
/*     */   public static ALCCapabilities createCapabilities(long paramLong, IntFunction<PointerBuffer> paramIntFunction) {
/*     */     int i, j;
/*     */     FunctionProviderLocal functionProviderLocal;
/* 238 */     long l1 = (functionProviderLocal = getFunctionProvider()).getFunctionAddress("alcGetIntegerv");
/* 239 */     long l2 = functionProviderLocal.getFunctionAddress("alcGetString");
/* 240 */     long l3 = functionProviderLocal.getFunctionAddress("alcIsExtensionPresent");
/*     */     
/* 242 */     if (l1 == 0L || l2 == 0L || l3 == 0L) {
/* 243 */       throw new IllegalStateException("Core ALC functions could not be found. Make sure that OpenAL has been loaded.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     try (MemoryStack null = MemoryStack.stackPush()) {
/* 250 */       IntBuffer intBuffer = memoryStack.mallocInt(1);
/*     */       
/* 252 */       JNI.invokePPV(paramLong, 4096, 1, MemoryUtil.memAddress(intBuffer), l1);
/* 253 */       j = intBuffer.get(0);
/*     */       
/* 255 */       JNI.invokePPV(paramLong, 4097, 1, MemoryUtil.memAddress(intBuffer), l1);
/* 256 */       i = intBuffer.get(0);
/*     */     } 
/*     */     
/* 259 */     int[][] arrayOfInt = { { 0, 1 } };
/*     */ 
/*     */ 
/*     */     
/* 263 */     HashSet<String> hashSet = new HashSet(16);
/*     */     
/* 265 */     for (byte b = 1; b <= 1; b++) {
/*     */       int[] arrayOfInt1; int[] arrayOfInt2; int k; byte b1;
/* 267 */       for (k = (arrayOfInt2 = arrayOfInt1 = arrayOfInt[b - 1]).length, b1 = 0; b1 < k; ) { int m = arrayOfInt2[b1];
/* 268 */         if (b < j || (b == j && m <= i)) {
/* 269 */           hashSet.add("OpenALC" + b + m);
/*     */         }
/*     */         
/*     */         b1++; }
/*     */     
/*     */     } 
/*     */     String str;
/* 276 */     if ((str = MemoryUtil.memASCIISafe(JNI.invokePP(paramLong, 4102, l2))) != null) {
/* 277 */       StringTokenizer stringTokenizer = new StringTokenizer(str);
/* 278 */       while (stringTokenizer.hasMoreTokens()) {
/* 279 */         String str1 = stringTokenizer.nextToken();
/* 280 */         try (MemoryStack null = MemoryStack.stackPush()) {
/* 281 */           if (JNI.invokePPZ(paramLong, MemoryUtil.memAddress(memoryStack1.ASCII(str1, true)), l3)) {
/* 282 */             hashSet.add(str1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 287 */     APIUtil.apiFilterExtensions(hashSet, Configuration.OPENAL_EXTENSION_FILTER);
/*     */     
/* 289 */     ALCCapabilities aLCCapabilities = new ALCCapabilities(functionProviderLocal, paramLong, hashSet, (paramIntFunction == null) ? BufferUtils::createPointerBuffer : paramIntFunction);
/* 290 */     if (paramLong != 0L) {
/* 291 */       setCapabilities(aLCCapabilities);
/*     */     }
/*     */     
/* 294 */     return aLCCapabilities;
/*     */   }
/*     */   
/*     */   static ALCCapabilities getICD() {
/*     */     ALCCapabilities aLCCapabilities;
/* 299 */     if ((aLCCapabilities = (ALCCapabilities)((icd == null) ? null : icd.get())) == null) {
/* 300 */       aLCCapabilities = router;
/*     */     }
/* 302 */     return check(aLCCapabilities);
/*     */   }
/*     */ 
/*     */   
/*     */   private static interface ICD
/*     */   {
/*     */     default void set(ALCCapabilities param1ALCCapabilities) {}
/*     */ 
/*     */     
/*     */     ALCCapabilities get();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ICDStatic
/*     */     implements ICD
/*     */   {
/*     */     private static ALCCapabilities tempCaps;
/*     */ 
/*     */     
/*     */     private ICDStatic() {}
/*     */ 
/*     */     
/*     */     public void set(ALCCapabilities param1ALCCapabilities) {
/* 325 */       if (tempCaps == null) {
/* 326 */         tempCaps = param1ALCCapabilities; return;
/* 327 */       }  if (param1ALCCapabilities != null && param1ALCCapabilities != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses, param1ALCCapabilities.addresses)) {
/* 328 */         APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread/process lookup for AL contexts.");
/* 329 */         ALC.icd = ALC::getCapabilities;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public ALCCapabilities get() {
/* 335 */       return WriteOnce.caps;
/*     */     }
/*     */     
/*     */     private static final class WriteOnce
/*     */     {
/*     */       static final ALCCapabilities caps;
/*     */       
/*     */       static {
/*     */         ALCCapabilities aLCCapabilities;
/* 344 */         if ((aLCCapabilities = ALC.ICDStatic.tempCaps) == null) {
/* 345 */           throw new IllegalStateException("No ALCCapabilities instance has been set");
/*     */         }
/* 347 */         caps = aLCCapabilities;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\ALC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */