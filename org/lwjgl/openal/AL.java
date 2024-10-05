/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.HashSet;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public final class AL
/*     */ {
/*     */   private static ALCapabilities processCaps;
/*  50 */   private static final ThreadLocal<ALCapabilities> capabilitiesTLS = new ThreadLocal<>();
/*     */   
/*  52 */   private static ICD icd = new ICDStatic();
/*     */ 
/*     */ 
/*     */   
/*     */   static void init() {}
/*     */ 
/*     */   
/*     */   static void destroy() {
/*  60 */     setCurrentProcess(null);
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
/*     */   public static void setCurrentProcess(ALCapabilities paramALCapabilities) {
/*  72 */     processCaps = paramALCapabilities;
/*  73 */     capabilitiesTLS.set(null);
/*  74 */     icd.set(paramALCapabilities);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCurrentThread(ALCapabilities paramALCapabilities) {
/*  85 */     capabilitiesTLS.set(paramALCapabilities);
/*  86 */     icd.set(paramALCapabilities);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ALCapabilities getCapabilities() {
/*     */     ALCapabilities aLCapabilities;
/*  96 */     if ((aLCapabilities = capabilitiesTLS.get()) == null) {
/*  97 */       aLCapabilities = processCaps;
/*     */     }
/*     */     
/* 100 */     return checkCapabilities(aLCapabilities);
/*     */   }
/*     */   
/*     */   private static ALCapabilities checkCapabilities(ALCapabilities paramALCapabilities) {
/* 104 */     if (paramALCapabilities == null) {
/* 105 */       throw new IllegalStateException("No ALCapabilities instance set for the current thread or process. Possible solutions:\n\ta) Call AL.createCapabilities() after making a context current.\n\tb) Call AL.setCurrentProcess() or AL.setCurrentThread() if an ALCapabilities instance already exists.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     return paramALCapabilities;
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
/*     */   public static ALCapabilities createCapabilities(ALCCapabilities paramALCCapabilities) {
/* 124 */     return createCapabilities(paramALCCapabilities, null);
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
/*     */   public static ALCapabilities createCapabilities(ALCCapabilities paramALCCapabilities, IntFunction<PointerBuffer> paramIntFunction) {
/*     */     long l1;
/* 141 */     if ((l1 = ALC.getFunctionProvider().getFunctionAddress(0L, "alGetProcAddress")) == 0L) {
/* 142 */       throw new RuntimeException("A core AL function is missing. Make sure that the OpenAL library has been loaded correctly.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FunctionProvider functionProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     long l2 = (functionProvider = (paramByteBuffer -> { long l; if ((l = JNI.invokePP(MemoryUtil.memAddress(paramByteBuffer), paramLong)) == 0L && Checks.DEBUG_FUNCTIONS) APIUtil.apiLogMissing("AL", paramByteBuffer);  return l; })).getFunctionAddress("alGetString");
/* 154 */     long l3 = functionProvider.getFunctionAddress("alGetError");
/* 155 */     long l4 = functionProvider.getFunctionAddress("alIsExtensionPresent");
/* 156 */     if (l2 == 0L || l3 == 0L || l4 == 0L) {
/* 157 */       throw new IllegalStateException("Core OpenAL functions could not be found. Make sure that the OpenAL library has been loaded correctly.");
/*     */     }
/*     */     
/*     */     String str1;
/* 161 */     if ((str1 = MemoryUtil.memASCIISafe(JNI.invokeP(45058, l2))) == null || JNI.invokeI(l3) != 0) {
/* 162 */       throw new IllegalStateException("There is no OpenAL context current in the current thread or process.");
/*     */     }
/*     */     
/*     */     APIUtil.APIVersion aPIVersion;
/*     */     
/* 167 */     int j = (aPIVersion = APIUtil.apiParseVersion(str1)).major;
/* 168 */     int i = aPIVersion.minor;
/*     */     
/* 170 */     int[][] arrayOfInt = { { 0, 1 } };
/*     */ 
/*     */ 
/*     */     
/* 174 */     HashSet<String> hashSet = new HashSet(32);
/*     */     
/* 176 */     for (byte b = 1; b <= 1; b++) {
/*     */       int[] arrayOfInt1; int[] arrayOfInt2; int k; byte b1;
/* 178 */       for (k = (arrayOfInt2 = arrayOfInt1 = arrayOfInt[b - 1]).length, b1 = 0; b1 < k; ) { int m = arrayOfInt2[b1];
/* 179 */         if (b < j || (b == j && m <= i)) {
/* 180 */           hashSet.add("OpenAL" + b + m);
/*     */         }
/*     */         
/*     */         b1++; }
/*     */     
/*     */     } 
/*     */     String str2;
/* 187 */     if ((str2 = MemoryUtil.memASCIISafe(JNI.invokeP(45060, l2))) != null) {
/* 188 */       MemoryStack memoryStack = MemoryStack.stackGet();
/*     */       
/* 190 */       StringTokenizer stringTokenizer = new StringTokenizer(str2);
/* 191 */       while (stringTokenizer.hasMoreTokens()) {
/* 192 */         String str = stringTokenizer.nextToken();
/* 193 */         try (MemoryStack null = memoryStack.push()) {
/* 194 */           if (JNI.invokePZ(MemoryUtil.memAddress(memoryStack1.ASCII(str, true)), l4)) {
/* 195 */             hashSet.add(str);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 201 */     if (paramALCCapabilities.ALC_EXT_EFX) {
/* 202 */       hashSet.add("ALC_EXT_EFX");
/*     */     }
/* 204 */     APIUtil.apiFilterExtensions(hashSet, Configuration.OPENAL_EXTENSION_FILTER);
/*     */     
/* 206 */     ALCapabilities aLCapabilities = new ALCapabilities(functionProvider, hashSet, (throwable == null) ? BufferUtils::createPointerBuffer : (IntFunction<PointerBuffer>)throwable);
/*     */     
/* 208 */     if (paramALCCapabilities.ALC_EXT_thread_local_context && EXTThreadLocalContext.alcGetThreadContext() != 0L) {
/* 209 */       setCurrentThread(aLCapabilities);
/*     */     } else {
/* 211 */       setCurrentProcess(aLCapabilities);
/*     */     } 
/*     */     
/* 214 */     return aLCapabilities;
/*     */   }
/*     */   
/*     */   static ALCapabilities getICD() {
/* 218 */     return ALC.<ALCapabilities>check(icd.get());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static interface ICD
/*     */   {
/*     */     default void set(ALCapabilities param1ALCapabilities) {}
/*     */ 
/*     */     
/*     */     ALCapabilities get();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ICDStatic
/*     */     implements ICD
/*     */   {
/*     */     private static ALCapabilities tempCaps;
/*     */ 
/*     */     
/*     */     private ICDStatic() {}
/*     */ 
/*     */     
/*     */     public void set(ALCapabilities param1ALCapabilities) {
/* 242 */       if (tempCaps == null) {
/* 243 */         tempCaps = param1ALCapabilities; return;
/* 244 */       }  if (param1ALCapabilities != null && param1ALCapabilities != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses, param1ALCapabilities.addresses)) {
/* 245 */         APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread/process lookup for AL contexts.");
/* 246 */         AL.icd = AL::getCapabilities;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public ALCapabilities get() {
/* 252 */       return WriteOnce.caps;
/*     */     }
/*     */     
/*     */     private static final class WriteOnce
/*     */     {
/*     */       static final ALCapabilities caps;
/*     */       
/*     */       static {
/*     */         ALCapabilities aLCapabilities;
/* 261 */         if ((aLCapabilities = AL.ICDStatic.tempCaps) == null) {
/* 262 */           throw new IllegalStateException("No ALCapabilities instance has been set");
/*     */         }
/* 264 */         caps = aLCapabilities;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\AL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */