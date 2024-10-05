/*     */ package nonapi.io.github.classgraph.fastzipfilereader;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import nonapi.io.github.classgraph.fileslice.ArraySlice;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.RandomAccessReader;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ import nonapi.io.github.classgraph.utils.StringUtils;
/*     */ import nonapi.io.github.classgraph.utils.VersionFinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LogicalZipFile
/*     */   extends ZipFileSlice
/*     */ {
/*     */   public List<FastZipEntry> entries;
/*     */   private boolean isMultiReleaseJar;
/*  66 */   Set<String> classpathRoots = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*     */ 
/*     */ 
/*     */   
/*     */   public String classPathManifestEntryValue;
/*     */ 
/*     */ 
/*     */   
/*     */   public String bundleClassPathManifestEntryValue;
/*     */ 
/*     */   
/*     */   public String addExportsManifestEntryValue;
/*     */ 
/*     */   
/*     */   public String addOpensManifestEntryValue;
/*     */ 
/*     */   
/*     */   public String automaticModuleNameManifestEntryValue;
/*     */ 
/*     */   
/*     */   public boolean isJREJar;
/*     */ 
/*     */   
/*     */   private final boolean enableMultiReleaseVersions;
/*     */ 
/*     */   
/*     */   static final String META_INF_PATH_PREFIX = "META-INF/";
/*     */ 
/*     */   
/*     */   private static final String MANIFEST_PATH = "META-INF/MANIFEST.MF";
/*     */ 
/*     */   
/*     */   public static final String MULTI_RELEASE_PATH_PREFIX = "META-INF/versions/";
/*     */ 
/*     */   
/* 101 */   private static final byte[] IMPLEMENTATION_TITLE_KEY = manifestKeyToBytes("Implementation-Title");
/*     */ 
/*     */   
/* 104 */   private static final byte[] SPECIFICATION_TITLE_KEY = manifestKeyToBytes("Specification-Title");
/*     */ 
/*     */   
/* 107 */   private static final byte[] CLASS_PATH_KEY = manifestKeyToBytes("Class-Path");
/*     */ 
/*     */   
/* 110 */   private static final byte[] BUNDLE_CLASSPATH_KEY = manifestKeyToBytes("Bundle-ClassPath");
/*     */ 
/*     */   
/* 113 */   private static final byte[] SPRING_BOOT_CLASSES_KEY = manifestKeyToBytes("Spring-Boot-Classes");
/*     */ 
/*     */   
/* 116 */   private static final byte[] SPRING_BOOT_LIB_KEY = manifestKeyToBytes("Spring-Boot-Lib");
/*     */ 
/*     */   
/* 119 */   private static final byte[] MULTI_RELEASE_KEY = manifestKeyToBytes("Multi-Release");
/*     */ 
/*     */   
/* 122 */   private static final byte[] ADD_EXPORTS_KEY = manifestKeyToBytes("Add-Exports");
/*     */ 
/*     */   
/* 125 */   private static final byte[] ADD_OPENS_KEY = manifestKeyToBytes("Add-Opens");
/*     */ 
/*     */   
/* 128 */   private static final byte[] AUTOMATIC_MODULE_NAME_KEY = manifestKeyToBytes("Automatic-Module-Name");
/*     */ 
/*     */   
/* 131 */   private static byte[] toLowerCase = new byte[256];
/*     */   static {
/* 133 */     for (byte b = 32; b < 127; b++) {
/* 134 */       toLowerCase[b] = (byte)Character.toLowerCase((char)b);
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
/*     */   LogicalZipFile(ZipFileSlice paramZipFileSlice, NestedJarHandler paramNestedJarHandler, LogNode paramLogNode, boolean paramBoolean) {
/* 156 */     super(paramZipFileSlice);
/* 157 */     this.enableMultiReleaseVersions = paramBoolean;
/* 158 */     readCentralDirectory(paramNestedJarHandler, paramLogNode);
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
/*     */   private static Map.Entry<String, Integer> getManifestValue(byte[] paramArrayOfbyte, int paramInt) {
/*     */     String str;
/* 176 */     paramInt = paramInt;
/* 177 */     int i = paramArrayOfbyte.length;
/* 178 */     while (paramInt < i && paramArrayOfbyte[paramInt] == 32)
/*     */     {
/* 180 */       paramInt++;
/*     */     }
/* 182 */     int j = paramInt;
/* 183 */     boolean bool = false;
/* 184 */     for (; paramInt < i; paramInt++) {
/*     */       byte b;
/* 186 */       if ((b = paramArrayOfbyte[paramInt]) == 13 && paramInt < i - 1 && paramArrayOfbyte[paramInt + 1] == 10) {
/* 187 */         if (paramInt < i - 2 && paramArrayOfbyte[paramInt + 2] == 32)
/* 188 */           bool = true; 
/*     */         break;
/*     */       } 
/* 191 */       if (b == 13 || b == 10) {
/* 192 */         if (paramInt < i - 1 && paramArrayOfbyte[paramInt + 1] == 32) {
/* 193 */           bool = true;
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 199 */     if (!bool) {
/*     */       
/* 201 */       str = new String(paramArrayOfbyte, j, paramInt - j, StandardCharsets.UTF_8);
/*     */     } else {
/*     */       
/* 204 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 205 */       paramInt = j;
/* 206 */       while (paramInt < i) {
/*     */ 
/*     */         
/* 209 */         if ((j = paramArrayOfbyte[paramInt]) == 13 && paramInt < i - 1 && paramArrayOfbyte[paramInt + 1] == 10) {
/*     */           
/* 211 */           paramInt += 2;
/* 212 */           j = 1;
/* 213 */         } else if (j == 13 || j == 10) {
/*     */           
/* 215 */           paramInt++;
/* 216 */           j = 1;
/*     */         } else {
/* 218 */           byteArrayOutputStream.write(j);
/* 219 */           j = 0;
/*     */         } 
/* 221 */         if (j == 0 || paramInt >= i || paramArrayOfbyte[paramInt] == 32) {
/*     */           paramInt++;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 228 */         str = byteArrayOutputStream.toString("UTF-8");
/* 229 */       } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */         
/* 231 */         throw new RuntimeException("UTF-8 encoding is not supported in your JRE", unsupportedEncodingException);
/*     */       } 
/*     */     } 
/* 234 */     return new AbstractMap.SimpleEntry<>(str.endsWith(" ") ? str.trim() : str, Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] manifestKeyToBytes(String paramString) {
/* 245 */     byte[] arrayOfByte = new byte[paramString.length()];
/* 246 */     for (byte b = 0; b < paramString.length(); b++) {
/* 247 */       arrayOfByte[b] = (byte)Character.toLowerCase(paramString.charAt(b));
/*     */     }
/* 249 */     return arrayOfByte;
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
/*     */   private static boolean keyMatchesAtPosition(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 264 */     if (paramInt + paramArrayOfbyte2.length + 1 > paramArrayOfbyte1.length || paramArrayOfbyte1[paramInt + paramArrayOfbyte2.length] != 58) {
/* 265 */       return false;
/*     */     }
/* 267 */     for (byte b = 0; b < paramArrayOfbyte2.length; b++) {
/*     */       
/* 269 */       if (toLowerCase[paramArrayOfbyte1[b + paramInt]] != paramArrayOfbyte2[b]) {
/* 270 */         return false;
/*     */       }
/*     */     } 
/* 273 */     return true;
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
/*     */   private void parseManifest(FastZipEntry paramFastZipEntry, LogNode paramLogNode) {
/* 291 */     byte[] arrayOfByte = paramFastZipEntry.getSlice().load();
/*     */ 
/*     */     
/* 294 */     for (byte b = 0; b < arrayOfByte.length; ) {
/*     */       int i;
/* 296 */       boolean bool = false;
/* 297 */       if (arrayOfByte[b] == 10 || arrayOfByte[b] == 13) {
/*     */         
/* 299 */         bool = true;
/*     */       }
/* 301 */       else if (keyMatchesAtPosition(arrayOfByte, IMPLEMENTATION_TITLE_KEY, b)) {
/*     */         Map.Entry<String, Integer> entry;
/*     */         
/* 304 */         if (((String)(entry = getManifestValue(arrayOfByte, b + IMPLEMENTATION_TITLE_KEY.length + 1)).getKey()).equalsIgnoreCase("Java Runtime Environment")) {
/* 305 */           this.isJREJar = true;
/*     */         }
/* 307 */         i = ((Integer)entry.getValue()).intValue();
/*     */       } else {
/* 309 */         int j; if (keyMatchesAtPosition(arrayOfByte, SPECIFICATION_TITLE_KEY, i)) {
/*     */           Map.Entry<String, Integer> entry;
/*     */           
/* 312 */           if (((String)(entry = getManifestValue(arrayOfByte, i + SPECIFICATION_TITLE_KEY.length + 1)).getKey()).equalsIgnoreCase("Java Platform API Specification")) {
/* 313 */             this.isJREJar = true;
/*     */           }
/* 315 */           j = ((Integer)entry.getValue()).intValue();
/*     */         } else {
/* 317 */           int k; if (keyMatchesAtPosition(arrayOfByte, CLASS_PATH_KEY, j)) {
/* 318 */             Map.Entry<String, Integer> entry = getManifestValue(arrayOfByte, j + CLASS_PATH_KEY.length + 1);
/*     */ 
/*     */             
/* 321 */             this.classPathManifestEntryValue = entry.getKey();
/* 322 */             if (paramLogNode != null) {
/* 323 */               paramLogNode.log("Found Class-Path entry in manifest file: " + this.classPathManifestEntryValue);
/*     */             }
/* 325 */             k = ((Integer)entry.getValue()).intValue();
/*     */           } else {
/* 327 */             int m; if (keyMatchesAtPosition(arrayOfByte, BUNDLE_CLASSPATH_KEY, k))
/* 328 */             { Map.Entry<String, Integer> entry = getManifestValue(arrayOfByte, k + BUNDLE_CLASSPATH_KEY.length + 1);
/*     */ 
/*     */               
/* 331 */               this.bundleClassPathManifestEntryValue = entry.getKey();
/* 332 */               if (paramLogNode != null) {
/* 333 */                 paramLogNode.log("Found Bundle-ClassPath entry in manifest file: " + this.bundleClassPathManifestEntryValue);
/*     */               }
/* 335 */               m = ((Integer)entry.getValue()).intValue(); }
/*     */             else
/* 337 */             { int n; if (keyMatchesAtPosition(arrayOfByte, SPRING_BOOT_CLASSES_KEY, m))
/*     */               { Map.Entry<String, Integer> entry;
/*     */                 
/*     */                 String str;
/* 341 */                 if (!(str = (entry = getManifestValue(arrayOfByte, m + SPRING_BOOT_CLASSES_KEY.length + 1)).getKey()).equals("BOOT-INF/classes") && 
/* 342 */                   !str.equals("BOOT-INF/classes/") && 
/* 343 */                   !str.equals("WEB-INF/classes") && 
/* 344 */                   !str.equals("WEB-INF/classes/")) {
/* 345 */                   throw new IOException("Spring boot classes are at \"" + str + "\" rather than the standard location \"BOOT-INF/classes/\" or \"WEB-INF/classes/\" -- please report this at https://github.com/classgraph/classgraph/issues");
/*     */                 }
/*     */ 
/*     */                 
/* 349 */                 n = ((Integer)entry.getValue()).intValue(); }
/*     */               else
/* 351 */               { int i1; if (keyMatchesAtPosition(arrayOfByte, SPRING_BOOT_LIB_KEY, n))
/*     */                 { Map.Entry<String, Integer> entry;
/*     */                   
/*     */                   String str;
/* 355 */                   if (!(str = (entry = getManifestValue(arrayOfByte, n + SPRING_BOOT_LIB_KEY.length + 1)).getKey()).equals("BOOT-INF/lib") && !str.equals("BOOT-INF/lib/") && 
/* 356 */                     !str.equals("WEB-INF/lib") && 
/* 357 */                     !str.equals("WEB-INF/lib/")) {
/* 358 */                     throw new IOException("Spring boot lib jars are at \"" + str + "\" rather than the standard location \"BOOT-INF/lib/\" or \"WEB-INF/lib/\" -- please report this at https://github.com/classgraph/classgraph/issues");
/*     */                   }
/*     */ 
/*     */                   
/* 362 */                   i1 = ((Integer)entry.getValue()).intValue(); }
/*     */                 else
/* 364 */                 { int i2; if (keyMatchesAtPosition(arrayOfByte, MULTI_RELEASE_KEY, i1))
/*     */                   { Map.Entry<String, Integer> entry;
/*     */                     
/* 367 */                     if (((String)(entry = getManifestValue(arrayOfByte, i1 + MULTI_RELEASE_KEY.length + 1)).getKey()).equalsIgnoreCase("true")) {
/* 368 */                       this.isMultiReleaseJar = true;
/*     */                     }
/* 370 */                     i2 = ((Integer)entry.getValue()).intValue(); }
/*     */                   else
/* 372 */                   { int i3; if (keyMatchesAtPosition(arrayOfByte, ADD_EXPORTS_KEY, i2))
/* 373 */                     { Map.Entry<String, Integer> entry = getManifestValue(arrayOfByte, i2 + ADD_EXPORTS_KEY.length + 1);
/*     */                       
/* 375 */                       this.addExportsManifestEntryValue = entry.getKey();
/* 376 */                       if (paramLogNode != null) {
/* 377 */                         paramLogNode.log("Found Add-Exports entry in manifest file: " + this.addExportsManifestEntryValue);
/*     */                       }
/* 379 */                       i3 = ((Integer)entry.getValue()).intValue(); }
/*     */                     else
/* 381 */                     { int i4; if (keyMatchesAtPosition(arrayOfByte, ADD_OPENS_KEY, i3))
/* 382 */                       { Map.Entry<String, Integer> entry = getManifestValue(arrayOfByte, i3 + ADD_OPENS_KEY.length + 1);
/*     */                         
/* 384 */                         this.addExportsManifestEntryValue = entry.getKey();
/* 385 */                         if (paramLogNode != null) {
/* 386 */                           paramLogNode.log("Found Add-Opens entry in manifest file: " + this.addOpensManifestEntryValue);
/*     */                         }
/* 388 */                         i4 = ((Integer)entry.getValue()).intValue(); }
/*     */                       
/* 390 */                       else if (keyMatchesAtPosition(arrayOfByte, AUTOMATIC_MODULE_NAME_KEY, i4))
/* 391 */                       { Map.Entry<String, Integer> entry = getManifestValue(arrayOfByte, i4 + AUTOMATIC_MODULE_NAME_KEY.length + 1);
/*     */                         
/* 393 */                         this.automaticModuleNameManifestEntryValue = entry.getKey();
/* 394 */                         if (paramLogNode != null) {
/* 395 */                           paramLogNode.log("Found Automatic-Module-Name entry in manifest file: " + this.automaticModuleNameManifestEntryValue);
/*     */                         }
/*     */                         
/* 398 */                         i = ((Integer)entry.getValue()).intValue();
/*     */                          }
/*     */                       
/*     */                       else
/*     */                       
/* 403 */                       { bool = true; }  }  }  }  }  } 
/*     */           } 
/*     */         } 
/* 406 */       }  if (bool) {
/*     */         
/* 408 */         for (; i < arrayOfByte.length - 2; i++) {
/* 409 */           if (arrayOfByte[i] == 13 && arrayOfByte[i + 1] == 10 && arrayOfByte[i + 2] != 32) {
/*     */             
/* 411 */             i += 2; break;
/*     */           } 
/* 413 */           if ((arrayOfByte[i] == 13 || arrayOfByte[i] == 10) && arrayOfByte[i + 1] != 32) {
/*     */             
/* 415 */             i++;
/*     */             break;
/*     */           } 
/*     */         } 
/* 419 */         if (i < arrayOfByte.length - 2) {
/*     */           continue;
/*     */         }
/*     */         break;
/*     */       } 
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
/*     */   private void readCentralDirectory(NestedJarHandler paramNestedJarHandler, LogNode paramLogNode) {
/*     */     RandomAccessReader randomAccessReader2;
/* 443 */     if (this.slice.sliceLength < 22L) {
/* 444 */       throw new IOException("Zipfile too short to have a central directory");
/*     */     }
/*     */     
/* 447 */     RandomAccessReader randomAccessReader1 = this.slice.randomAccessReader();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     long l1 = -1L; long l2, l3;
/* 453 */     for (l2 = this.slice.sliceLength - 22L, l3 = this.slice.sliceLength - 22L - 32L; l2 >= l3 && l2 >= 0L; l2--) {
/* 454 */       if (randomAccessReader1.readUnsignedInt(l2) == 101010256L) {
/* 455 */         l1 = l2;
/*     */         break;
/*     */       } 
/*     */     } 
/* 459 */     if (l1 < 0L && this.slice.sliceLength > 54L) {
/*     */       int i;
/*     */ 
/*     */       
/* 463 */       byte[] arrayOfByte = new byte[i = (int)Math.min(this.slice.sliceLength, 65536L)];
/* 464 */       l3 = this.slice.sliceLength - i;
/* 465 */       if (randomAccessReader1.read(l3, arrayOfByte, 0, i) < i)
/*     */       {
/* 467 */         throw new IOException("Zipfile is truncated");
/*     */       }
/* 469 */       ArraySlice arraySlice = new ArraySlice(arrayOfByte, false, 0L, paramNestedJarHandler); Throwable throwable = null;
/*     */       
/* 471 */       try { RandomAccessReader randomAccessReader = arraySlice.randomAccessReader(); long l;
/* 472 */         for (l = arrayOfByte.length - 22L; l >= 0L; l--) {
/* 473 */           if (randomAccessReader.readUnsignedInt(l) == 101010256L) {
/* 474 */             l1 = l + l3; break;
/*     */           } 
/*     */         }  }
/*     */       catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 478 */       finally { if (throwable != null) { try { arraySlice.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { arraySlice.close(); }  }
/*     */     
/* 480 */     }  if (l1 < 0L) {
/* 481 */       throw new IOException("Jarfile central directory signature not found: " + getPath());
/*     */     }
/* 483 */     l2 = randomAccessReader1.readUnsignedShort(l1 + 8L);
/* 484 */     if (randomAccessReader1.readUnsignedShort(l1 + 4L) > 0 || randomAccessReader1.readUnsignedShort(l1 + 6L) > 0 || l2 != randomAccessReader1
/* 485 */       .readUnsignedShort(l1 + 10L)) {
/* 486 */       throw new IOException("Multi-disk jarfiles not supported: " + getPath());
/*     */     }
/* 488 */     l3 = randomAccessReader1.readUnsignedInt(l1 + 12L);
/* 489 */     long l4 = randomAccessReader1.readUnsignedInt(l1 + 16L);
/* 490 */     long l5 = l1 - l3;
/*     */     
/*     */     long l6;
/*     */     
/* 494 */     if ((l6 = l1 - 20L) >= 0L && randomAccessReader1.readUnsignedInt(l6) == 117853008L) {
/* 495 */       if (randomAccessReader1.readUnsignedInt(l6 + 4L) > 0L || randomAccessReader1.readUnsignedInt(l6 + 16L) > 1L) {
/* 496 */         throw new IOException("Multi-disk jarfiles not supported: " + getPath());
/*     */       }
/* 498 */       long l8 = randomAccessReader1.readLong(l6 + 8L);
/* 499 */       if (randomAccessReader1.readUnsignedInt(l8) != 101075792L) {
/* 500 */         throw new IOException("Zip64 central directory at location " + l8 + " does not have Zip64 central directory header: " + 
/* 501 */             getPath());
/*     */       }
/* 503 */       long l9 = randomAccessReader1.readLong(l8 + 24L);
/* 504 */       if (randomAccessReader1.readUnsignedInt(l8 + 16L) > 0L || randomAccessReader1.readUnsignedInt(l8 + 20L) > 0L || l9 != randomAccessReader1
/* 505 */         .readLong(l8 + 32L)) {
/* 506 */         throw new IOException("Multi-disk jarfiles not supported: " + getPath());
/*     */       }
/* 508 */       if (l2 == 65535L) {
/* 509 */         l2 = l9;
/* 510 */       } else if (l2 != l9) {
/*     */         
/* 512 */         l2 = -1L;
/*     */       } 
/*     */       
/* 515 */       long l10 = randomAccessReader1.readLong(l8 + 40L);
/* 516 */       if (l3 == 4294967295L) {
/* 517 */         l3 = l10;
/* 518 */       } else if (l3 != l10) {
/* 519 */         throw new IOException("Mismatch in central directory size: " + l3 + " vs. " + l10 + ": " + 
/* 520 */             getPath());
/*     */       } 
/*     */ 
/*     */       
/* 524 */       l5 = l8 - l3;
/*     */       
/* 526 */       long l11 = randomAccessReader1.readLong(l8 + 48L);
/* 527 */       if (l4 == 4294967295L) {
/* 528 */         l4 = l11;
/* 529 */       } else if (l4 != l11) {
/* 530 */         throw new IOException("Mismatch in central directory offset: " + l4 + " vs. " + l11 + ": " + 
/* 531 */             getPath());
/*     */       } 
/*     */     } 
/*     */     
/* 535 */     if (l3 > l1) {
/* 536 */       throw new IOException("Central directory size out of range: " + l3 + " vs. " + l1 + ": " + 
/* 537 */           getPath());
/*     */     }
/*     */     
/*     */     long l7;
/*     */     
/* 542 */     if ((l7 = l5 - l4) < 0L) {
/* 543 */       throw new IOException("Local file header offset out of range: " + l7 + ": " + getPath());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 549 */     if (l3 > 2147483639L) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 556 */       randomAccessReader2 = this.slice.slice(l5, l3, false, 0L).randomAccessReader();
/*     */     }
/*     */     else {
/*     */       
/* 560 */       byte[] arrayOfByte = new byte[(int)l3];
/* 561 */       if (randomAccessReader1.read(l5, arrayOfByte, 0, (int)l3) < l3)
/*     */       {
/* 563 */         throw new IOException("Zipfile is truncated");
/*     */       }
/*     */       
/* 566 */       randomAccessReader2 = (new ArraySlice(arrayOfByte, false, 0L, paramNestedJarHandler)).randomAccessReader();
/*     */     } 
/*     */     
/* 569 */     if (l2 == -1L) {
/*     */       
/* 571 */       l2 = 0L;
/* 572 */       for (long l = 0L; l + 46L <= l3; ) {
/*     */         long l8;
/* 574 */         if ((l8 = randomAccessReader2.readUnsignedInt(l)) != 33639248L) {
/* 575 */           throw new IOException("Invalid central directory signature: 0x" + 
/* 576 */               Integer.toString((int)l8, 16) + ": " + getPath());
/*     */         }
/* 578 */         int j = randomAccessReader2.readUnsignedShort(l + 28L);
/* 579 */         int k = randomAccessReader2.readUnsignedShort(l + 30L);
/* 580 */         int i = randomAccessReader2.readUnsignedShort(l + 32L);
/* 581 */         l += (j + 46 + k + i);
/* 582 */         l2++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 587 */     if (l2 > 2147483639L)
/*     */     {
/* 589 */       throw new IOException("Too many zipfile entries: " + l2);
/*     */     }
/*     */ 
/*     */     
/* 593 */     if (l2 > l3 / 46L)
/*     */     {
/* 595 */       throw new IOException("Too many zipfile entries: " + l2 + " (expected a max of " + (l3 / 46L) + " based on central directory size)");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 600 */     this.entries = new ArrayList<>((int)l2);
/* 601 */     FastZipEntry fastZipEntry = null;
/*     */     try {
/*     */       long l;
/* 604 */       for (l = 0L; l + 46L <= l3; l += m) {
/*     */         long l8;
/* 606 */         if ((l8 = randomAccessReader2.readUnsignedInt(l)) != 33639248L) {
/* 607 */           throw new IOException("Invalid central directory signature: 0x" + 
/* 608 */               Integer.toString((int)l8, 16) + ": " + getPath());
/*     */         }
/* 610 */         int i = randomAccessReader2.readUnsignedShort(l + 28L);
/* 611 */         int j = randomAccessReader2.readUnsignedShort(l + 30L);
/* 612 */         int k = randomAccessReader2.readUnsignedShort(l + 32L);
/* 613 */         int m = i + 46 + j + k;
/*     */ 
/*     */         
/*     */         long l9, l10;
/*     */         
/* 618 */         if ((l10 = (l9 = l + 46L) + i) > l3) {
/* 619 */           if (paramLogNode != null) {
/* 620 */             paramLogNode.log("Filename extends past end of entry -- skipping entry at offset " + l);
/*     */           }
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/*     */         String str1, str2;
/* 627 */         if (!(str2 = FileUtils.sanitizeEntryPath(str1 = randomAccessReader2.readString(l9, i), true, false)).isEmpty() && !str1.endsWith("/")) {
/*     */           int n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 634 */           if (((n = randomAccessReader2.readUnsignedShort(l + 8L)) & 0x1) != 0)
/* 635 */           { if (paramLogNode != null) {
/* 636 */               paramLogNode.log("Skipping encrypted zip entry: " + str2);
/*     */ 
/*     */             
/*     */             }
/*     */             
/*     */              }
/*     */           
/* 643 */           else if ((n = randomAccessReader2.readUnsignedShort(l + 10L)) != 0 && n != 8)
/* 644 */           { if (paramLogNode != null) {
/* 645 */               paramLogNode.log("Skipping zip entry with invalid compression method " + n + ": " + str2);
/*     */             } }
/*     */           
/*     */           else
/*     */           
/* 650 */           { n = (n == 8) ? 1 : 0;
/*     */ 
/*     */             
/* 653 */             long l11 = randomAccessReader2.readUnsignedInt(l + 20L);
/* 654 */             long l12 = randomAccessReader2.readUnsignedInt(l + 24L);
/*     */ 
/*     */             
/* 657 */             int i1 = randomAccessReader2.readUnsignedShort(l + 40L);
/*     */             
/* 659 */             long l13 = randomAccessReader2.readUnsignedInt(l + 42L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 665 */             long l14 = 0L;
/* 666 */             if (j > 0) {
/* 667 */               int i4; for (i4 = 0; i4 + 4 < j; ) {
/* 668 */                 long l15 = l10 + i4;
/* 669 */                 int i6 = randomAccessReader2.readUnsignedShort(l15);
/* 670 */                 int i5 = randomAccessReader2.readUnsignedShort(l15 + 2L);
/* 671 */                 if (i4 + 4 + i5 > j) {
/*     */                   
/* 673 */                   if (paramLogNode != null) {
/* 674 */                     paramLogNode.log("Skipping zip entry with invalid extra field size: " + str2);
/*     */                   }
/*     */                   break;
/*     */                 } 
/* 678 */                 if (i6 == 1 && i5 >= 20) {
/*     */                   
/* 680 */                   long l16 = randomAccessReader2.readLong(l15 + 4L);
/* 681 */                   if (l12 == 4294967295L) {
/* 682 */                     l12 = l16;
/* 683 */                   } else if (l12 != l16) {
/* 684 */                     throw new IOException("Mismatch in uncompressed size: " + l12 + " vs. " + l16 + ": " + str2);
/*     */                   } 
/*     */                   
/* 687 */                   long l17 = randomAccessReader2.readLong(l15 + 4L + 8L);
/* 688 */                   if (l11 == 4294967295L) {
/* 689 */                     l11 = l17;
/* 690 */                   } else if (l11 != l17) {
/* 691 */                     throw new IOException("Mismatch in compressed size: " + l11 + " vs. " + l17 + ": " + str2);
/*     */                   } 
/*     */ 
/*     */                   
/* 695 */                   if (i5 >= 28) {
/* 696 */                     long l18 = randomAccessReader2.readLong(l15 + 4L + 16L);
/* 697 */                     if (l13 == 4294967295L) {
/* 698 */                       l13 = l18; break;
/* 699 */                     }  if (l13 != l18) {
/* 700 */                       throw new IOException("Mismatch in entry pos: " + l13 + " vs. " + l18 + ": " + str2);
/*     */                     }
/*     */                   } 
/*     */                   
/*     */                   break;
/*     */                 } 
/* 706 */                 if (i6 == 21589 && i5 >= 5) {
/*     */                   int i7;
/*     */                   
/* 709 */                   if (((i7 = randomAccessReader2.readUnsignedByte(l15 + 4L)) & 0x1) == 1 && i5 >= 13) {
/* 710 */                     l14 = randomAccessReader2.readLong(l15 + 4L + 1L) * 1000L;
/*     */                   }
/*     */                 }
/* 713 */                 else if (i6 == 22613 && i5 >= 20) {
/*     */                   
/* 715 */                   l14 = randomAccessReader2.readLong(l15 + 4L + 8L) * 1000L;
/*     */                 
/*     */                 }
/* 718 */                 else if (i6 != 30805) {
/*     */ 
/*     */                   
/* 721 */                   if (i6 == 28789) {
/*     */                     int i7;
/*     */                     
/* 724 */                     if ((i7 = randomAccessReader2.readUnsignedByte(l15 + 4L)) != 1) {
/* 725 */                       throw new IOException("Unknown Unicode entry name format " + i7 + " in extra field: " + str2);
/*     */                     }
/* 727 */                     if (i5 > 9) {
/*     */                       
/*     */                       try {
/* 730 */                         str2 = randomAccessReader2.readString(l15 + 9L, i5 - 9);
/* 731 */                       } catch (IllegalArgumentException illegalArgumentException) {
/* 732 */                         throw new IOException("Malformed extended Unicode entry name for entry: " + str2);
/*     */                       } 
/*     */                     }
/*     */                   } 
/*     */                 } 
/* 737 */                 i4 += i5 + 4;
/*     */               } 
/*     */             } 
/*     */             
/* 741 */             int i2 = 0;
/* 742 */             int i3 = 0;
/* 743 */             if (l14 == 0L) {
/*     */               
/* 745 */               i2 = randomAccessReader2.readUnsignedShort(l + 12L);
/* 746 */               i3 = randomAccessReader2.readUnsignedShort(l + 14L);
/*     */             } 
/*     */             
/* 749 */             if (l11 < 0L)
/* 750 */             { if (paramLogNode != null) {
/* 751 */                 paramLogNode.log("Skipping zip entry with invalid compressed size (" + l11 + "): " + str2);
/*     */               
/*     */               }
/*     */                }
/*     */             
/* 756 */             else if (l12 < 0L)
/* 757 */             { if (paramLogNode != null) {
/* 758 */                 paramLogNode.log("Skipping zip entry with invalid uncompressed size (" + l12 + "): " + str2);
/*     */               
/*     */               }
/*     */                }
/*     */             
/* 763 */             else if (l13 < 0L)
/* 764 */             { if (paramLogNode != null) {
/* 765 */                 paramLogNode.log("Skipping zip entry with invalid pos (" + l13 + "): " + str2);
/*     */               } }
/*     */             else
/*     */             { long l15;
/*     */ 
/*     */               
/* 771 */               if ((l15 = l7 + l13) < 0L)
/* 772 */               { if (paramLogNode != null) {
/* 773 */                   paramLogNode.log("Skipping zip entry with invalid loc header position (" + l15 + "): " + str2);
/*     */                 
/*     */                 }
/*     */                  }
/*     */               
/* 778 */               else if (l15 + 4L >= this.slice.sliceLength)
/* 779 */               { if (paramLogNode != null) {
/* 780 */                   paramLogNode.log("Unexpected EOF when trying to read LOC header: " + str2);
/*     */                 
/*     */                 } }
/*     */               
/*     */               else
/*     */               
/* 786 */               { FastZipEntry fastZipEntry1 = new FastZipEntry(this, l15, str2, n, l11, l12, l14, i2, i3, i1, this.enableMultiReleaseVersions);
/*     */ 
/*     */                 
/* 789 */                 this.entries.add(fastZipEntry1);
/*     */ 
/*     */                 
/* 792 */                 if (fastZipEntry1.entryName.equals("META-INF/MANIFEST.MF"))
/* 793 */                   fastZipEntry = fastZipEntry1;  }  }  } 
/*     */         } 
/*     */       } 
/* 796 */     } catch (EOFException|IndexOutOfBoundsException eOFException) {
/*     */       
/* 798 */       if (paramLogNode != null) {
/* 799 */         paramLogNode.log("Reached premature EOF" + (
/* 800 */             this.entries.isEmpty() ? "" : (" after reading zip entry " + this.entries.get(this.entries.size() - 1))));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 805 */     if (fastZipEntry != null) {
/* 806 */       parseManifest(fastZipEntry, paramLogNode);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 811 */     if (this.isMultiReleaseJar) {
/* 812 */       if (VersionFinder.JAVA_MAJOR_VERSION < 9) {
/* 813 */         if (paramLogNode != null) {
/* 814 */           paramLogNode.log("This is a multi-release jar, but JRE version " + VersionFinder.JAVA_MAJOR_VERSION + " does not support multi-release jars");
/*     */           return;
/*     */         } 
/*     */       } else {
/* 818 */         if (paramLogNode != null) {
/*     */           
/* 820 */           HashSet<Integer> hashSet = new HashSet();
/* 821 */           for (Iterator<FastZipEntry> iterator = this.entries.iterator(); iterator.hasNext();) {
/* 822 */             if ((fastZipEntry1 = iterator.next()).version > 8) {
/* 823 */               hashSet.add(Integer.valueOf(fastZipEntry1.version));
/*     */             }
/*     */           } 
/*     */           ArrayList<Integer> arrayList1;
/* 827 */           CollectionUtils.sortIfNotEmpty(arrayList1 = new ArrayList<>(hashSet));
/* 828 */           paramLogNode.log("This is a multi-release jar, with versions: " + 
/* 829 */               StringUtils.join(", ", arrayList1));
/*     */         } 
/*     */ 
/*     */         
/* 833 */         CollectionUtils.sortIfNotEmpty(this.entries);
/*     */ 
/*     */ 
/*     */         
/* 837 */         ArrayList<FastZipEntry> arrayList = new ArrayList(this.entries.size());
/* 838 */         HashMap<Object, Object> hashMap = new HashMap<>();
/* 839 */         for (FastZipEntry fastZipEntry1 : this.entries) {
/* 840 */           if (!hashMap.containsKey(fastZipEntry1.entryNameUnversioned)) {
/*     */             
/* 842 */             hashMap.put(fastZipEntry1.entryNameUnversioned, fastZipEntry1.entryName);
/*     */             
/* 844 */             arrayList.add(fastZipEntry1); continue;
/* 845 */           }  if (paramLogNode != null) {
/* 846 */             paramLogNode.log((String)hashMap.get(fastZipEntry1.entryNameUnversioned) + " masks " + fastZipEntry1.entryName);
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 852 */         this.entries = arrayList;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 861 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 866 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 874 */     return getPath();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fastzipfilereader\LogicalZipFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */