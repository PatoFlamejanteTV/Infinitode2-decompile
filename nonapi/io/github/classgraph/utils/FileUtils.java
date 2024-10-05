/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.InvalidPathException;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.nio.file.attribute.FileTime;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FileUtils
/*     */ {
/*     */   private static Method directByteBufferCleanerMethod;
/*     */   private static Method cleanerCleanMethod;
/*     */   private static Method attachmentMethod;
/*     */   private static Object theUnsafe;
/*  80 */   private static AtomicBoolean initialized = new AtomicBoolean();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String currDirPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MAX_BUFFER_SIZE = 2147483639;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String currDirPath() {
/* 112 */     if (currDirPath == null) {
/*     */ 
/*     */       
/* 115 */       Path path = null;
/*     */       String str;
/* 117 */       if ((str = System.getProperty("user.dir")) != null) {
/*     */         try {
/* 119 */           path = Paths.get(str, new String[0]);
/* 120 */         } catch (InvalidPathException invalidPathException) {}
/*     */       }
/*     */ 
/*     */       
/* 124 */       if (path == null) {
/*     */         
/*     */         try {
/*     */           
/* 128 */           path = Paths.get("", new String[0]);
/* 129 */         } catch (InvalidPathException invalidPathException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 136 */       currDirPath = FastPathResolver.resolve((path == null) ? "" : path.toString());
/*     */     } 
/* 138 */     return currDirPath;
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
/*     */   public static String sanitizeEntryPath(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 158 */     if (paramString.isEmpty()) {
/* 159 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 163 */     byte b1 = 0;
/*     */     int i;
/* 165 */     char[] arrayOfChar = new char[i = paramString.length()];
/* 166 */     paramString.getChars(0, i, arrayOfChar, 0);
/*     */     
/* 168 */     byte b = -1;
/* 169 */     boolean bool = false; int j;
/* 170 */     for (byte b2 = 0; b2 < j; b2++) {
/*     */       boolean bool1;
/* 172 */       if ((bool1 = (b2 == i) ? false : arrayOfChar[b2]) == 47 || bool1 == 33 || !bool1) {
/*     */         int k;
/* 174 */         if (((k = b2 - b + 1) == 0 && bool == bool1) || (k == 1 && arrayOfChar[b2 - 1] == '.') || (k == 2 && arrayOfChar[b2 - 2] == '.' && arrayOfChar[b2 - 1] == '.'))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 181 */           b1 = 1;
/*     */         }
/* 183 */         b = b2;
/*     */       } 
/* 185 */       bool = bool1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     bool = ((b = (arrayOfChar[0] == '/') ? 1 : 0) != 0 && i > 1 && arrayOfChar[1] == '/') ? true : false;
/* 192 */     StringBuilder stringBuilder = new StringBuilder(i + 16);
/* 193 */     if (b1) {
/*     */       
/* 195 */       ArrayList<ArrayList> arrayList = new ArrayList();
/* 196 */       ArrayList<CharSequence> arrayList1 = new ArrayList();
/* 197 */       arrayList.add(arrayList1);
/* 198 */       int k = -1;
/* 199 */       for (b1 = 0; b1 < i + 1; b1++) {
/*     */         boolean bool1;
/* 201 */         if ((bool1 = (b1 == i) ? false : arrayOfChar[b1]) == 47 || bool1 == 33 || !bool1) {
/* 202 */           k++;
/*     */           int m;
/* 204 */           if ((m = b1 - k) != 0 && (m != 1 || arrayOfChar[k] != '.'))
/*     */           {
/* 206 */             if (m == 2 && arrayOfChar[k] == '.' && arrayOfChar[k + 1] == '.') {
/*     */ 
/*     */               
/* 209 */               if (!arrayList1.isEmpty()) {
/* 210 */                 arrayList1.remove(arrayList1.size() - 1);
/*     */               }
/*     */             } else {
/*     */               
/* 214 */               arrayList1.add(paramString.subSequence(k, k + m));
/*     */             }  } 
/* 216 */           if (bool1 == 33 && !arrayList1.isEmpty()) {
/*     */             
/* 218 */             arrayList1 = new ArrayList<>();
/* 219 */             arrayList.add(arrayList1);
/*     */           } 
/* 221 */           k = b1;
/*     */         } 
/*     */       } 
/*     */       
/* 225 */       for (Iterator<ArrayList> iterator = arrayList.iterator(); iterator.hasNext();) {
/* 226 */         if (!(list = iterator.next()).isEmpty()) {
/*     */           
/* 228 */           if (stringBuilder.length() > 0) {
/* 229 */             stringBuilder.append('!');
/*     */           }
/* 231 */           for (CharSequence charSequence : list) {
/* 232 */             stringBuilder.append('/');
/* 233 */             stringBuilder.append(charSequence);
/*     */           } 
/*     */         } 
/*     */       } 
/* 237 */       if (stringBuilder.length() == 0 && b != 0) {
/* 238 */         stringBuilder.append('/');
/*     */       }
/*     */     } else {
/* 241 */       stringBuilder.append(paramString);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 246 */     if (VersionFinder.OS == VersionFinder.OperatingSystem.Windows && bool) {
/* 247 */       stringBuilder.insert(0, '/');
/*     */     }
/*     */     
/* 250 */     j = 0;
/* 251 */     if (paramBoolean1 || b == 0)
/*     */     {
/*     */ 
/*     */       
/* 255 */       while (j < stringBuilder.length() && stringBuilder.charAt(j) == '/') {
/* 256 */         j++;
/*     */       }
/*     */     }
/* 259 */     if (paramBoolean2) {
/* 260 */       while (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '/') {
/* 261 */         stringBuilder.setLength(stringBuilder.length() - 1);
/*     */       }
/*     */     }
/*     */     
/* 265 */     return stringBuilder.substring(j);
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
/*     */   public static boolean isClassfile(String paramString) {
/*     */     int i;
/* 279 */     if ((i = paramString.length()) > 6 && paramString.regionMatches(true, i - 6, ".class", 0, 6)) return true;  return false;
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
/*     */   public static boolean canRead(File paramFile) {
/*     */     try {
/* 293 */       return paramFile.canRead();
/* 294 */     } catch (SecurityException securityException) {
/* 295 */       return false;
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
/*     */   public static boolean canRead(Path paramPath) {
/*     */     try {
/* 308 */       return canRead(paramPath.toFile());
/* 309 */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*     */       
/*     */       try {
/* 312 */         return Files.isReadable(paramPath);
/* 313 */       } catch (SecurityException securityException) {
/* 314 */         return false;
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
/*     */   public static boolean canReadAndIsFile(File paramFile) {
/*     */     try {
/* 327 */       if (!paramFile.canRead()) {
/* 328 */         return false;
/*     */       }
/* 330 */     } catch (SecurityException securityException) {
/* 331 */       return false;
/*     */     } 
/* 333 */     return paramFile.isFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canReadAndIsFile(Path paramPath) {
/*     */     try {
/* 345 */       return canReadAndIsFile(paramPath.toFile());
/* 346 */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*     */       
/*     */       try {
/* 349 */         if (!Files.isReadable(paramPath)) {
/* 350 */           return false;
/*     */         }
/* 352 */       } catch (SecurityException securityException) {
/* 353 */         return false;
/*     */       } 
/* 355 */       return Files.isRegularFile(paramPath, new java.nio.file.LinkOption[0]);
/*     */     } 
/*     */   }
/*     */   public static boolean isFile(Path paramPath) {
/*     */     try {
/* 360 */       return paramPath.toFile().isFile();
/* 361 */     } catch (UnsupportedOperationException unsupportedOperationException) {
/* 362 */       return Files.isRegularFile(paramPath, new java.nio.file.LinkOption[0]);
/* 363 */     } catch (SecurityException securityException) {
/* 364 */       return false;
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
/*     */   public static void checkCanReadAndIsFile(File paramFile) {
/*     */     try {
/* 378 */       if (!paramFile.canRead()) {
/* 379 */         throw new FileNotFoundException("File does not exist or cannot be read: " + paramFile);
/*     */       }
/* 381 */     } catch (SecurityException securityException) {
/* 382 */       throw new FileNotFoundException("File " + paramFile + " cannot be accessed: " + securityException);
/*     */     } 
/* 384 */     if (!paramFile.isFile()) {
/* 385 */       throw new IOException("Not a regular file: " + paramFile);
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
/*     */   public static void checkCanReadAndIsFile(Path paramPath) {
/*     */     try {
/* 399 */       checkCanReadAndIsFile(paramPath.toFile());
/*     */       return;
/* 401 */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*     */       
/*     */       try {
/* 404 */         if (!Files.isReadable(paramPath)) {
/* 405 */           throw new FileNotFoundException("Path does not exist or cannot be read: " + paramPath);
/*     */         }
/* 407 */       } catch (SecurityException securityException) {
/* 408 */         throw new FileNotFoundException("Path " + paramPath + " cannot be accessed: " + securityException);
/*     */       } 
/* 410 */       if (!Files.isRegularFile(paramPath, new java.nio.file.LinkOption[0])) {
/* 411 */         throw new IOException("Not a regular file: " + paramPath);
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canReadAndIsDir(File paramFile) {
/*     */     try {
/* 424 */       if (!paramFile.canRead()) {
/* 425 */         return false;
/*     */       }
/* 427 */     } catch (SecurityException securityException) {
/* 428 */       return false;
/*     */     } 
/* 430 */     return paramFile.isDirectory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canReadAndIsDir(Path paramPath) {
/*     */     try {
/* 442 */       return canReadAndIsDir(paramPath.toFile());
/* 443 */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*     */       
/*     */       try {
/* 446 */         if (!Files.isReadable(paramPath)) {
/* 447 */           return false;
/*     */         }
/* 449 */       } catch (SecurityException securityException) {
/* 450 */         return false;
/*     */       } 
/* 452 */       return Files.isDirectory(paramPath, new java.nio.file.LinkOption[0]);
/*     */     } 
/*     */   }
/*     */   public static boolean isDir(Path paramPath) {
/*     */     try {
/* 457 */       return paramPath.toFile().isDirectory();
/* 458 */     } catch (UnsupportedOperationException unsupportedOperationException) {
/* 459 */       return Files.isDirectory(paramPath, new java.nio.file.LinkOption[0]);
/* 460 */     } catch (SecurityException securityException) {
/* 461 */       return false;
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
/*     */   public static void checkCanReadAndIsDir(File paramFile) {
/*     */     try {
/* 475 */       if (!paramFile.canRead()) {
/* 476 */         throw new FileNotFoundException("Directory does not exist or cannot be read: " + paramFile);
/*     */       }
/* 478 */     } catch (SecurityException securityException) {
/* 479 */       throw new FileNotFoundException("File " + paramFile + " cannot be accessed: " + securityException);
/*     */     } 
/* 481 */     if (!paramFile.isDirectory()) {
/* 482 */       throw new IOException("Not a directory: " + paramFile);
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
/*     */   public static String getParentDirPath(String paramString, char paramChar) {
/*     */     int i;
/* 499 */     if ((i = paramString.lastIndexOf(paramChar)) <= 0) {
/* 500 */       return "";
/*     */     }
/* 502 */     return paramString.substring(0, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getParentDirPath(String paramString) {
/* 513 */     return getParentDirPath(paramString, '/');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void lookupCleanMethodPrivileged() {
/* 522 */     if (VersionFinder.JAVA_MAJOR_VERSION < 9) {
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 527 */         (cleanerCleanMethod = Class.forName("sun.misc.Cleaner").getDeclaredMethod("clean", new Class[0])).setAccessible(true);
/*     */         Class<?> clazz;
/* 529 */         directByteBufferCleanerMethod = (clazz = Class.forName("sun.nio.ch.DirectBuffer")).getDeclaredMethod("cleaner", new Class[0]);
/*     */         
/* 531 */         (attachmentMethod = clazz.getMethod("attachment", new Class[0])).setAccessible(true); return;
/* 532 */       } catch (SecurityException securityException) {
/* 533 */         throw new RuntimeException("You need to grant classgraph RuntimePermission(\"accessClassInPackage.sun.misc\") and ReflectPermission(\"suppressAccessChecks\")", securityException);
/*     */ 
/*     */       
/*     */       }
/* 537 */       catch (ReflectiveOperationException|LinkageError reflectiveOperationException) {
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       Class<?> clazz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 567 */         clazz = Class.forName("sun.misc.Unsafe");
/* 568 */       } catch (ReflectiveOperationException|LinkageError reflectiveOperationException) {
/* 569 */         throw new RuntimeException("Could not get class sun.misc.Unsafe", reflectiveOperationException);
/*     */       } 
/*     */       Field field;
/* 572 */       (field = clazz.getDeclaredField("theUnsafe")).setAccessible(true);
/* 573 */       theUnsafe = field.get(null);
/*     */       
/* 575 */       (cleanerCleanMethod = clazz.getMethod("invokeCleaner", new Class[] { ByteBuffer.class })).setAccessible(true); return;
/* 576 */     } catch (SecurityException securityException) {
/* 577 */       throw new RuntimeException("You need to grant classgraph RuntimePermission(\"accessClassInPackage.sun.misc\") and ReflectPermission(\"suppressAccessChecks\")", securityException);
/*     */ 
/*     */     
/*     */     }
/* 581 */     catch (ReflectiveOperationException|LinkageError reflectiveOperationException) {
/*     */       return;
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
/*     */   private static boolean closeDirectByteBufferPrivileged(ByteBuffer paramByteBuffer, LogNode paramLogNode) {
/* 598 */     if (!paramByteBuffer.isDirect())
/*     */     {
/* 600 */       return true;
/*     */     }
/*     */     try {
/* 603 */       if (VersionFinder.JAVA_MAJOR_VERSION < 9) {
/* 604 */         if (attachmentMethod == null) {
/* 605 */           if (paramLogNode != null) {
/* 606 */             paramLogNode.log("Could not unmap ByteBuffer, attachmentMethod == null");
/*     */           }
/* 608 */           return false;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 614 */         if (attachmentMethod.invoke(paramByteBuffer, new Object[0]) != null)
/*     */         {
/* 616 */           return false;
/*     */         }
/*     */         
/* 619 */         if (directByteBufferCleanerMethod == null) {
/* 620 */           if (paramLogNode != null) {
/* 621 */             paramLogNode.log("Could not unmap ByteBuffer, cleanerMethod == null");
/*     */           }
/* 623 */           return false;
/*     */         } 
/*     */         try {
/* 626 */           directByteBufferCleanerMethod.setAccessible(true);
/* 627 */         } catch (Exception exception) {
/* 628 */           if (paramLogNode != null) {
/* 629 */             paramLogNode.log("Could not unmap ByteBuffer, cleanerMethod.setAccessible(true) failed");
/*     */           }
/* 631 */           return false;
/*     */         } 
/*     */         
/* 634 */         if ((object = directByteBufferCleanerMethod.invoke(paramByteBuffer, new Object[0])) == null) {
/* 635 */           if (paramLogNode != null) {
/* 636 */             paramLogNode.log("Could not unmap ByteBuffer, cleaner == null");
/*     */           }
/* 638 */           return false;
/*     */         } 
/* 640 */         if (cleanerCleanMethod == null) {
/* 641 */           if (paramLogNode != null) {
/* 642 */             paramLogNode.log("Could not unmap ByteBuffer, cleanMethod == null");
/*     */           }
/* 644 */           return false;
/*     */         } 
/*     */         try {
/* 647 */           cleanerCleanMethod.invoke(object, new Object[0]);
/* 648 */           return true;
/* 649 */         } catch (Exception object) {
/* 650 */           if (paramLogNode != null) {
/* 651 */             paramLogNode.log("Could not unmap ByteBuffer, cleanMethod.invoke(cleaner) failed: " + object);
/*     */           }
/* 653 */           return false;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 667 */       if (theUnsafe == null) {
/* 668 */         if (paramLogNode != null) {
/* 669 */           paramLogNode.log("Could not unmap ByteBuffer, theUnsafe == null");
/*     */         }
/* 671 */         return false;
/*     */       } 
/* 673 */       if (cleanerCleanMethod == null) {
/* 674 */         if (paramLogNode != null) {
/* 675 */           paramLogNode.log("Could not unmap ByteBuffer, cleanMethod == null");
/*     */         }
/* 677 */         return false;
/*     */       } 
/*     */       try {
/* 680 */         cleanerCleanMethod.invoke(theUnsafe, new Object[] { object });
/* 681 */         return true;
/* 682 */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         
/* 684 */         return false;
/*     */       }
/*     */     
/* 687 */     } catch (ReflectiveOperationException|SecurityException reflectiveOperationException) {
/* 688 */       if (paramLogNode != null) {
/* 689 */         paramLogNode.log("Could not unmap ByteBuffer: " + reflectiveOperationException);
/*     */       }
/* 691 */       return false;
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
/*     */   public static boolean closeDirectByteBuffer(ByteBuffer paramByteBuffer, ReflectionUtils paramReflectionUtils, final LogNode log) {
/* 706 */     if (paramByteBuffer != null && paramByteBuffer.isDirect()) {
/* 707 */       if (!initialized.get()) {
/*     */         try {
/* 709 */           paramReflectionUtils.doPrivileged(new Callable<Void>()
/*     */               {
/*     */                 public final Void call() {
/* 712 */                   FileUtils.lookupCleanMethodPrivileged();
/* 713 */                   return null;
/*     */                 }
/*     */               });
/* 716 */         } catch (Throwable throwable) {
/* 717 */           throw new RuntimeException("Cannot get buffer cleaner method", throwable);
/*     */         } 
/* 719 */         initialized.set(true);
/*     */       } 
/*     */       try {
/* 722 */         return ((Boolean)paramReflectionUtils.doPrivileged(new Callable<Boolean>()
/*     */             {
/*     */               public final Boolean call() {
/* 725 */                 return Boolean.valueOf(FileUtils.closeDirectByteBufferPrivileged(byteBuffer, log));
/*     */               }
/*     */             })).booleanValue();
/* 728 */       } catch (Throwable throwable1) {
/* 729 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 733 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static FileAttributesGetter createCachedAttributesGetter() {
/* 738 */     final HashMap<Object, Object> cache = new HashMap<>();
/* 739 */     return new FileAttributesGetter()
/*     */       {
/*     */         public final BasicFileAttributes get(Path param1Path) {
/*     */           BasicFileAttributes basicFileAttributes;
/* 743 */           if ((basicFileAttributes = (BasicFileAttributes)cache.get(param1Path)) == null) {
/* 744 */             basicFileAttributes = FileUtils.readAttributes(param1Path);
/* 745 */             cache.put(param1Path, basicFileAttributes);
/*     */           } 
/* 747 */           return basicFileAttributes;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public static BasicFileAttributes readAttributes(final Path path) {
/*     */     try {
/* 754 */       return Files.readAttributes(path, BasicFileAttributes.class, new java.nio.file.LinkOption[0]);
/* 755 */     } catch (IOException iOException) {
/* 756 */       return new BasicFileAttributes()
/*     */         {
/*     */           public final FileTime lastModifiedTime() {
/* 759 */             return FileTime.fromMillis(path.toFile().lastModified());
/*     */           }
/*     */ 
/*     */           
/*     */           public final FileTime lastAccessTime() {
/* 764 */             throw new UnsupportedOperationException();
/*     */           }
/*     */ 
/*     */           
/*     */           public final FileTime creationTime() {
/* 769 */             return FileTime.fromMillis(0L);
/*     */           }
/*     */ 
/*     */           
/*     */           public final boolean isRegularFile() {
/* 774 */             return FileUtils.isFile(path);
/*     */           }
/*     */ 
/*     */           
/*     */           public final boolean isDirectory() {
/* 779 */             return FileUtils.isDir(path);
/*     */           }
/*     */ 
/*     */           
/*     */           public final boolean isSymbolicLink() {
/* 784 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public final boolean isOther() {
/* 789 */             return (!isRegularFile() && !isDirectory());
/*     */           }
/*     */ 
/*     */           
/*     */           public final long size() {
/* 794 */             return path.toFile().length();
/*     */           }
/*     */ 
/*     */           
/*     */           public final Object fileKey() {
/* 799 */             throw new UnsupportedOperationException();
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */   
/*     */   public static interface FileAttributesGetter {
/*     */     BasicFileAttributes get(Path param1Path);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\FileUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */