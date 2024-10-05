/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiPredicate;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Stream;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.libffi.FFICIF;
/*     */ import org.lwjgl.system.libffi.FFIType;
/*     */ import org.lwjgl.system.libffi.LibFFI;
/*     */ import org.lwjgl.system.linux.LinuxLibrary;
/*     */ import org.lwjgl.system.macosx.MacOSXLibrary;
/*     */ import org.lwjgl.system.windows.WindowsLibrary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class APIUtil
/*     */ {
/*  42 */   public static final PrintStream DEBUG_STREAM = getDebugStream();
/*     */   
/*     */   private static final Pattern API_VERSION_PATTERN;
/*     */   
/*     */   static {
/*  47 */     String str1 = "[^\\d\\n\\r]*";
/*  48 */     String str2 = "(\\d+)[.](\\d+)(?:[.](\\S+))?";
/*  49 */     String str3 = "(?:\\s+(.+?))?\\s*";
/*     */     
/*  51 */     API_VERSION_PATTERN = Pattern.compile("^" + str1 + str2 + str3 + "$", 32);
/*     */   }
/*     */ 
/*     */   
/*     */   private static PrintStream getDebugStream() {
/*  56 */     PrintStream printStream = System.err;
/*     */     
/*     */     Object object;
/*  59 */     if (object = Configuration.DEBUG_STREAM.get() instanceof String) {
/*     */       
/*     */       try {
/*  62 */         printStream = (object = Class.forName((String)object).getConstructor(new Class[0]).newInstance(new Object[0])).get();
/*  63 */       } catch (Exception exception) {
/*  64 */         (object = null).printStackTrace();
/*     */       } 
/*  66 */     } else if (object instanceof Supplier) {
/*  67 */       printStream = ((Supplier<PrintStream>)object).get();
/*  68 */     } else if (object instanceof PrintStream) {
/*  69 */       printStream = (PrintStream)object;
/*     */     } 
/*     */     
/*  72 */     return printStream;
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
/*     */   public static void apiLog(CharSequence paramCharSequence) {
/*  84 */     if (Checks.DEBUG) {
/*  85 */       DEBUG_STREAM.print("[LWJGL] " + paramCharSequence + "\n");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void apiLogMore(CharSequence paramCharSequence) {
/*  95 */     if (Checks.DEBUG) {
/*  96 */       DEBUG_STREAM.print("\t" + paramCharSequence + "\n");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void apiLogMissing(String paramString, ByteBuffer paramByteBuffer) {
/* 101 */     if (Checks.DEBUG) {
/* 102 */       String str = MemoryUtil.memASCII(paramByteBuffer, paramByteBuffer.remaining() - 1);
/* 103 */       DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + paramString + " function " + str + "\n");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String apiFindLibrary(String paramString1, String paramString2) {
/* 108 */     String str = Platform.get().mapLibraryName(paramString2); 
/* 109 */     try { Throwable throwable2; Stream<Path> stream = Files.find(
/* 110 */           Paths.get(paramString1, new String[0]).toAbsolutePath(), 2147483647, (paramPath, paramBasicFileAttributes) -> 
/*     */           
/* 112 */           (paramBasicFileAttributes.isRegularFile() && paramPath.getFileName().toString().equals(paramString)), new java.nio.file.FileVisitOption[0]); str = null;
/*     */       
/* 114 */       try { return stream
/* 115 */           .findFirst()
/* 116 */           .map(Path::toString)
/* 117 */           .orElse(paramString2); } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 118 */       finally { if (throwable1 != null) if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }   }  } catch (IOException iOException)
/* 119 */     { return paramString2; }
/*     */   
/*     */   }
/*     */   
/*     */   public static SharedLibrary apiCreateLibrary(String paramString) {
/* 124 */     switch (Platform.get()) {
/*     */       case WINDOWS:
/* 126 */         return (SharedLibrary)new WindowsLibrary(paramString);
/*     */       case LINUX:
/* 128 */         return (SharedLibrary)new LinuxLibrary(paramString);
/*     */       case MACOSX:
/* 130 */         return (SharedLibrary)MacOSXLibrary.create(paramString);
/*     */     } 
/* 132 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/*     */   public static long apiGetFunctionAddress(FunctionProvider paramFunctionProvider, String paramString) {
/*     */     long l;
/* 138 */     if ((l = paramFunctionProvider.getFunctionAddress(paramString)) == 0L) {
/* 139 */       requiredFunctionMissing(paramString);
/*     */     }
/* 141 */     return l;
/*     */   }
/*     */   private static void requiredFunctionMissing(String paramString) {
/* 144 */     if (!((Boolean)Configuration.DISABLE_FUNCTION_CHECKS.get(Boolean.FALSE)).booleanValue()) {
/* 145 */       throw new NullPointerException("A required function is missing: " + paramString);
/*     */     }
/*     */   }
/*     */   
/*     */   public static long apiGetFunctionAddressOptional(SharedLibrary paramSharedLibrary, String paramString) {
/* 150 */     long l = paramSharedLibrary.getFunctionAddress(paramString);
/* 151 */     if (Checks.DEBUG_FUNCTIONS && l == 0L) {
/* 152 */       optionalFunctionMissing(paramSharedLibrary, paramString);
/*     */     }
/* 154 */     return l;
/*     */   }
/*     */   private static void optionalFunctionMissing(SharedLibrary paramSharedLibrary, String paramString) {
/* 157 */     if (Checks.DEBUG) {
/* 158 */       DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + paramSharedLibrary.getName() + " function " + paramString + "\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static ByteBuffer apiGetMappedBuffer(ByteBuffer paramByteBuffer, long paramLong, int paramInt) {
/* 164 */     if (paramByteBuffer != null && MemoryUtil.memAddress(paramByteBuffer) == paramLong && paramByteBuffer.capacity() == paramInt) {
/* 165 */       return paramByteBuffer;
/*     */     }
/* 167 */     return (paramLong == 0L) ? null : ((ByteBuffer)MemoryUtil.<ByteBuffer>wrap(MemoryUtil.BUFFER_BYTE, paramLong, paramInt)).order(MemoryUtil.NATIVE_ORDER);
/*     */   }
/*     */   
/*     */   public static long apiGetBytes(int paramInt1, int paramInt2) {
/* 171 */     return (paramInt1 & 0xFFFFFFFFL) << paramInt2;
/*     */   }
/*     */   
/*     */   public static long apiCheckAllocation(int paramInt, long paramLong1, long paramLong2) {
/* 175 */     if (Checks.DEBUG) {
/* 176 */       if (paramInt < 0) {
/* 177 */         throw new IllegalArgumentException("Invalid number of elements");
/*     */       }
/* 179 */       if (paramLong2 + Long.MIN_VALUE < paramLong1 + Long.MIN_VALUE) {
/* 180 */         throw new IllegalArgumentException("The request allocation is too large");
/*     */       }
/*     */     } 
/* 183 */     return paramLong1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface Encoder
/*     */   {
/*     */     ByteBuffer encode(CharSequence param1CharSequence, boolean param1Boolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class APIVersion
/*     */     implements Comparable<APIVersion>
/*     */   {
/*     */     public final int major;
/*     */     public final int minor;
/*     */     public final String revision;
/*     */     public final String implementation;
/*     */     
/*     */     public APIVersion(int param1Int1, int param1Int2) {
/* 202 */       this(param1Int1, param1Int2, null, null);
/*     */     }
/*     */     
/*     */     public APIVersion(int param1Int1, int param1Int2, String param1String1, String param1String2) {
/* 206 */       this.major = param1Int1;
/* 207 */       this.minor = param1Int2;
/* 208 */       this.revision = param1String1;
/* 209 */       this.implementation = param1String2;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*     */       StringBuilder stringBuilder;
/* 215 */       (stringBuilder = new StringBuilder(16)).append(this.major).append('.').append(this.minor);
/* 216 */       if (this.revision != null) {
/* 217 */         stringBuilder.append('.').append(this.revision);
/*     */       }
/* 219 */       if (this.implementation != null) {
/* 220 */         stringBuilder.append(" (").append(this.implementation).append(')');
/*     */       }
/* 222 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 227 */       if (this == param1Object) {
/* 228 */         return true;
/*     */       }
/* 230 */       if (!(param1Object instanceof APIVersion)) {
/* 231 */         return false;
/*     */       }
/*     */       
/* 234 */       param1Object = param1Object;
/*     */       
/* 236 */       if (this.major == ((APIVersion)param1Object).major && this.minor == ((APIVersion)param1Object).major && 
/*     */         
/* 238 */         Objects.equals(this.revision, ((APIVersion)param1Object).revision) && 
/* 239 */         Objects.equals(this.implementation, ((APIVersion)param1Object).implementation)) return true; 
/*     */       return false;
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 244 */       int i = this.major;
/* 245 */       i = i * 31 + this.minor;
/* 246 */       i = i * 31 + ((this.revision != null) ? this.revision.hashCode() : 0);
/*     */       
/* 248 */       return i = i * 31 + ((this.implementation != null) ? this.implementation.hashCode() : 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(APIVersion param1APIVersion) {
/* 253 */       if (this.major != param1APIVersion.major) {
/* 254 */         return Integer.compare(this.major, param1APIVersion.major);
/*     */       }
/*     */       
/* 257 */       if (this.minor != param1APIVersion.minor) {
/* 258 */         return Integer.compare(this.minor, param1APIVersion.minor);
/*     */       }
/*     */       
/* 261 */       return 0;
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
/*     */   public static APIVersion apiParseVersion(Configuration<?> paramConfiguration) {
/*     */     APIVersion aPIVersion;
/* 275 */     if (paramConfiguration = (Configuration<?>)paramConfiguration.get() instanceof String) {
/* 276 */       aPIVersion = apiParseVersion((String)paramConfiguration);
/* 277 */     } else if (aPIVersion instanceof APIVersion) {
/* 278 */       aPIVersion = aPIVersion;
/*     */     } else {
/* 280 */       aPIVersion = null;
/*     */     } 
/*     */     
/* 283 */     return aPIVersion;
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
/*     */   public static APIVersion apiParseVersion(String paramString) {
/*     */     Matcher matcher;
/* 299 */     if (!(matcher = API_VERSION_PATTERN.matcher(paramString)).matches()) {
/* 300 */       throw new IllegalArgumentException(String.format("Malformed API version string [%s]", new Object[] { paramString }));
/*     */     }
/*     */     
/* 303 */     return new APIVersion(
/* 304 */         Integer.parseInt(matcher.group(1)), 
/* 305 */         Integer.parseInt(matcher.group(2)), matcher
/* 306 */         .group(3), matcher
/* 307 */         .group(4));
/*     */   }
/*     */   
/*     */   public static void apiFilterExtensions(Set<String> paramSet, Configuration<Object> paramConfiguration) {
/*     */     int i;
/*     */     Object object;
/* 313 */     if ((object = paramConfiguration.get()) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 317 */     if (object instanceof String)
/*     */     { String str;
/* 319 */       if ((str = (String)object).indexOf('.') != -1) {
/*     */         try {
/* 321 */           Predicate<? super String> predicate = (Predicate)Class.forName(str).newInstance();
/* 322 */           paramSet.removeIf(predicate);
/* 323 */         } catch (Exception exception) {
/* 324 */           throw new RuntimeException(exception);
/*     */         } 
/*     */       } else {
/* 327 */         String[] arrayOfString; byte b; for (i = (arrayOfString = exception.split(",")).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/* 328 */           paramSet.remove(str1); b++; }
/*     */          return;
/*     */       }  }
/* 331 */     else { Predicate<? super String> predicate; if (i instanceof List) {
/* 332 */         List<?> list = (List)i;
/* 333 */         paramSet.removeAll(list); return;
/* 334 */       }  if (i instanceof Predicate) {
/* 335 */         predicate = (Predicate)i;
/* 336 */         paramSet.removeIf(predicate); return;
/*     */       } 
/* 338 */       throw new IllegalStateException("Unsupported " + predicate.getProperty() + " value specified."); }
/*     */   
/*     */   }
/*     */   
/*     */   public static String apiUnknownToken(int paramInt) {
/* 343 */     return apiUnknownToken("Unknown", paramInt);
/*     */   }
/*     */   
/*     */   public static String apiUnknownToken(String paramString, int paramInt) {
/* 347 */     return String.format("%s [0x%X]", new Object[] { paramString, Integer.valueOf(paramInt) });
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
/*     */   public static Map<Integer, String> apiClassTokens(BiPredicate<Field, Integer> paramBiPredicate, Map<Integer, String> paramMap, Class<?>... paramVarArgs) {
/* 363 */     if (paramMap == null)
/*     */     {
/* 365 */       paramMap = new HashMap<>(64);
/*     */     }
/*     */     
/*     */     int i;
/*     */     byte b;
/* 370 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 371 */       Class<?> clazz; if ((clazz = paramVarArgs[b]) != null) {
/*     */         Field[] arrayOfField;
/*     */         int j;
/*     */         byte b1;
/* 375 */         for (j = (arrayOfField = clazz.getDeclaredFields()).length, b1 = 0; b1 < j; ) {
/*     */           Field field;
/* 377 */           if (((field = arrayOfField[b1]).getModifiers() & 0x19) == 25 && field.getType() == int.class) {
/*     */             try {
/* 379 */               Integer integer = Integer.valueOf(field.getInt(null));
/* 380 */               if (paramBiPredicate == null || paramBiPredicate.test(field, integer))
/*     */               
/*     */               { 
/*     */                 
/* 384 */                 String str = paramMap.get(integer);
/* 385 */                 paramMap.put(integer, (str == null) ? field.getName() : (str + "|" + field.getName())); } 
/* 386 */             } catch (IllegalAccessException illegalAccessException) {}
/*     */           }
/*     */           
/*     */           b1++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 393 */     return paramMap;
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
/*     */   public static long apiArray(MemoryStack paramMemoryStack, long... paramVarArgs) {
/* 407 */     PointerBuffer pointerBuffer = MemoryUtil.memPointerBuffer(paramMemoryStack.nmalloc(MemoryStack.POINTER_SIZE, paramVarArgs.length << MemoryStack.POINTER_SHIFT), paramVarArgs.length); int i;
/*     */     byte b;
/* 409 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { long l = paramVarArgs[b];
/* 410 */       pointerBuffer.put(l);
/*     */       b++; }
/*     */     
/* 413 */     return pointerBuffer.address;
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
/*     */   public static long apiArray(MemoryStack paramMemoryStack, ByteBuffer... paramVarArgs) {
/* 425 */     PointerBuffer pointerBuffer = MemoryUtil.memPointerBuffer(paramMemoryStack.nmalloc(MemoryStack.POINTER_SIZE, paramVarArgs.length << MemoryStack.POINTER_SHIFT), paramVarArgs.length); int i;
/*     */     byte b;
/* 427 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { ByteBuffer byteBuffer = paramVarArgs[b];
/* 428 */       pointerBuffer.put(byteBuffer);
/*     */       b++; }
/*     */     
/* 431 */     return pointerBuffer.address;
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
/*     */   public static long apiArrayp(MemoryStack paramMemoryStack, ByteBuffer... paramVarArgs) {
/* 444 */     long l = apiArray(paramMemoryStack, paramVarArgs);
/*     */     
/* 446 */     PointerBuffer pointerBuffer = paramMemoryStack.mallocPointer(paramVarArgs.length); int i; byte b;
/* 447 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { ByteBuffer byteBuffer = paramVarArgs[b];
/* 448 */       pointerBuffer.put(byteBuffer.remaining());
/*     */       b++; }
/*     */     
/* 451 */     return l;
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
/*     */   public static long apiArray(MemoryStack paramMemoryStack, Encoder paramEncoder, CharSequence... paramVarArgs) {
/* 471 */     PointerBuffer pointerBuffer = paramMemoryStack.mallocPointer(paramVarArgs.length); int i;
/*     */     byte b;
/* 473 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { CharSequence charSequence = paramVarArgs[b];
/* 474 */       pointerBuffer.put(paramEncoder.encode(charSequence, true));
/*     */       b++; }
/*     */     
/* 477 */     return pointerBuffer.address;
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
/*     */   public static long apiArrayi(MemoryStack paramMemoryStack, Encoder paramEncoder, CharSequence... paramVarArgs) {
/* 494 */     PointerBuffer pointerBuffer = paramMemoryStack.mallocPointer(paramVarArgs.length);
/* 495 */     IntBuffer intBuffer = paramMemoryStack.mallocInt(paramVarArgs.length); int i;
/*     */     byte b;
/* 497 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { CharSequence charSequence = paramVarArgs[b];
/* 498 */       ByteBuffer byteBuffer = paramEncoder.encode(charSequence, false);
/*     */       
/* 500 */       pointerBuffer.put(byteBuffer);
/* 501 */       intBuffer.put(byteBuffer.capacity());
/*     */       b++; }
/*     */     
/* 504 */     return pointerBuffer.address;
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
/*     */   public static long apiArrayp(MemoryStack paramMemoryStack, Encoder paramEncoder, CharSequence... paramVarArgs) {
/* 521 */     PointerBuffer pointerBuffer2 = paramMemoryStack.mallocPointer(paramVarArgs.length);
/* 522 */     PointerBuffer pointerBuffer1 = paramMemoryStack.mallocPointer(paramVarArgs.length); int i;
/*     */     byte b;
/* 524 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { CharSequence charSequence = paramVarArgs[b];
/* 525 */       ByteBuffer byteBuffer = paramEncoder.encode(charSequence, false);
/*     */       
/* 527 */       pointerBuffer2.put(byteBuffer);
/* 528 */       pointerBuffer1.put(byteBuffer.capacity());
/*     */       b++; }
/*     */     
/* 531 */     return pointerBuffer2.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void apiArrayFree(long paramLong, int paramInt) {
/* 541 */     for (paramInt = paramInt; --paramInt >= 0;) {
/* 542 */       MemoryUtil.nmemFree(MemoryUtil.memGetAddress(paramLong + Integer.toUnsignedLong(paramInt) * MemoryStack.POINTER_SIZE));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType apiCreateStruct(FFIType... paramVarArgs) {
/*     */     MemoryUtil.MemoryAllocator memoryAllocator;
/* 553 */     PointerBuffer pointerBuffer = PointerBuffer.create((memoryAllocator = MemoryUtil.getAllocator())
/* 554 */         .malloc(((paramVarArgs.length + 1) * MemoryStack.POINTER_SIZE)), paramVarArgs.length + 1);
/*     */ 
/*     */     
/* 557 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 558 */       pointerBuffer.put(b, (Pointer)paramVarArgs[b]);
/*     */     }
/* 560 */     pointerBuffer.put(paramVarArgs.length, 0L);
/*     */     
/* 562 */     return FFIType.create(memoryAllocator.calloc(1L, FFIType.SIZEOF))
/* 563 */       .type((short)13)
/* 564 */       .elements(pointerBuffer);
/*     */   }
/*     */   
/*     */   private static FFIType prep(FFIType paramFFIType) {
/* 568 */     MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable = null; 
/*     */     try { FFICIF fFICIF;
/* 570 */       if (LibFFI.ffi_prep_cif(fFICIF = FFICIF.calloc(memoryStack), LibFFI.FFI_DEFAULT_ABI, paramFFIType, null) != 0)
/* 571 */         throw new IllegalStateException("Failed to prepare LibFFI type.");  }
/*     */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 573 */     finally { if (memoryStack != null) if (throwable != null) { try { memoryStack.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }
/* 574 */      return paramFFIType;
/*     */   }
/*     */   
/*     */   public static FFIType apiCreateUnion(FFIType... paramVarArgs) {
/* 578 */     MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator();
/*     */ 
/*     */     
/* 581 */     FFIType fFIType = prep(paramVarArgs[0]);
/* 582 */     short s = paramVarArgs[0].alignment();
/* 583 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 584 */       FFIType fFIType1 = prep(paramVarArgs[b]);
/* 585 */       if (fFIType.size() < fFIType1.size()) {
/* 586 */         fFIType = fFIType1;
/*     */       }
/* 588 */       if (s < fFIType1.alignment()) {
/* 589 */         s = fFIType1.alignment();
/*     */       }
/*     */     } 
/*     */     
/* 593 */     return FFIType.create(memoryAllocator.malloc(FFIType.SIZEOF))
/* 594 */       .size(fFIType.size())
/* 595 */       .alignment(s)
/* 596 */       .type((short)13)
/* 597 */       .elements(PointerBuffer.create(memoryAllocator.malloc((2 * MemoryStack.POINTER_SIZE)), 2)
/* 598 */         .put(0, (Pointer)fFIType)
/* 599 */         .put(1, 0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType apiCreateArray(FFIType paramFFIType, int paramInt) {
/*     */     MemoryUtil.MemoryAllocator memoryAllocator;
/* 605 */     PointerBuffer pointerBuffer = PointerBuffer.create((memoryAllocator = MemoryUtil.getAllocator())
/* 606 */         .malloc(((paramInt + 1) * MemoryStack.POINTER_SIZE)), paramInt + 1);
/*     */ 
/*     */     
/* 609 */     for (byte b = 0; b < paramInt; b++) {
/* 610 */       pointerBuffer.put(b, (Pointer)paramFFIType);
/*     */     }
/* 612 */     pointerBuffer.put(paramInt, 0L);
/*     */     
/* 614 */     return FFIType.create(memoryAllocator.calloc(1L, FFIType.SIZEOF))
/* 615 */       .type((short)13)
/* 616 */       .elements(pointerBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF apiCreateCIF(int paramInt, FFIType paramFFIType, FFIType... paramVarArgs) {
/*     */     MemoryUtil.MemoryAllocator memoryAllocator;
/* 624 */     PointerBuffer pointerBuffer = PointerBuffer.create((memoryAllocator = MemoryUtil.getAllocator()).malloc((paramVarArgs.length * MemoryStack.POINTER_SIZE)), paramVarArgs.length);
/* 625 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 626 */       pointerBuffer.put(b, (Pointer)paramVarArgs[b]);
/*     */     }
/*     */ 
/*     */     
/*     */     FFICIF fFICIF;
/*     */     
/* 632 */     if ((paramInt = LibFFI.ffi_prep_cif(fFICIF = FFICIF.create(memoryAllocator.malloc(FFICIF.SIZEOF)), paramInt, paramFFIType, pointerBuffer)) != 0) {
/* 633 */       throw new IllegalStateException("Failed to prepare libffi CIF: " + paramInt);
/*     */     }
/*     */     
/* 636 */     return fFICIF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF apiCreateCIFVar(int paramInt1, int paramInt2, FFIType paramFFIType, FFIType... paramVarArgs) {
/*     */     MemoryUtil.MemoryAllocator memoryAllocator;
/* 644 */     PointerBuffer pointerBuffer = PointerBuffer.create((memoryAllocator = MemoryUtil.getAllocator()).malloc((paramVarArgs.length * MemoryStack.POINTER_SIZE)), paramVarArgs.length);
/* 645 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 646 */       pointerBuffer.put(b, (Pointer)paramVarArgs[b]);
/*     */     }
/*     */ 
/*     */     
/*     */     FFICIF fFICIF;
/*     */     
/* 652 */     if ((paramInt1 = LibFFI.ffi_prep_cif_var(fFICIF = FFICIF.create(memoryAllocator.malloc(FFICIF.SIZEOF)), paramInt1, paramInt2, paramFFIType, pointerBuffer)) != 0) {
/* 653 */       throw new IllegalStateException("Failed to prepare libffi var CIF: " + paramInt1);
/*     */     }
/*     */     
/* 656 */     return fFICIF;
/*     */   }
/*     */   
/*     */   public static int apiStdcall() {
/* 660 */     return (Platform.get() == Platform.WINDOWS && Pointer.BITS32) ? LibFFI.FFI_STDCALL : LibFFI.FFI_DEFAULT_ABI;
/*     */   }
/*     */   
/* 663 */   public static void apiClosureRet(long paramLong, boolean paramBoolean) { MemoryUtil.memPutAddress(paramLong, paramBoolean ? 1L : 0L); }
/* 664 */   public static void apiClosureRet(long paramLong, byte paramByte) { MemoryUtil.memPutAddress(paramLong, paramByte & 0xFFL); }
/* 665 */   public static void apiClosureRet(long paramLong, short paramShort) { MemoryUtil.memPutAddress(paramLong, paramShort & 0xFFFFL); }
/* 666 */   public static void apiClosureRet(long paramLong, int paramInt) { MemoryUtil.memPutAddress(paramLong, paramInt & 0xFFFFFFFFL); }
/* 667 */   public static void apiClosureRetL(long paramLong1, long paramLong2) { MemoryUtil.memPutLong(paramLong1, paramLong2); }
/* 668 */   public static void apiClosureRetP(long paramLong1, long paramLong2) { MemoryUtil.memPutAddress(paramLong1, paramLong2); }
/* 669 */   public static void apiClosureRet(long paramLong, float paramFloat) { MemoryUtil.memPutFloat(paramLong, paramFloat); } public static void apiClosureRet(long paramLong, double paramDouble) {
/* 670 */     MemoryUtil.memPutDouble(paramLong, paramDouble);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\APIUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */