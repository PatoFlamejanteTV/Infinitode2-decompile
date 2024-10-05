/*     */ package net.bytebuddy;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.utility.OpenedClassReader;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Enhance
/*     */ public class ClassFileVersion
/*     */   implements Serializable, Comparable<ClassFileVersion>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected static final int BASE_VERSION = 44;
/*  51 */   public static final ClassFileVersion JAVA_V1 = new ClassFileVersion(196653);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final ClassFileVersion JAVA_V2 = new ClassFileVersion(46);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final ClassFileVersion JAVA_V3 = new ClassFileVersion(47);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public static final ClassFileVersion JAVA_V4 = new ClassFileVersion(48);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final ClassFileVersion JAVA_V5 = new ClassFileVersion(49);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   public static final ClassFileVersion JAVA_V6 = new ClassFileVersion(50);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public static final ClassFileVersion JAVA_V7 = new ClassFileVersion(51);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public static final ClassFileVersion JAVA_V8 = new ClassFileVersion(52);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public static final ClassFileVersion JAVA_V9 = new ClassFileVersion(53);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public static final ClassFileVersion JAVA_V10 = new ClassFileVersion(54);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public static final ClassFileVersion JAVA_V11 = new ClassFileVersion(55);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public static final ClassFileVersion JAVA_V12 = new ClassFileVersion(56);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public static final ClassFileVersion JAVA_V13 = new ClassFileVersion(57);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   public static final ClassFileVersion JAVA_V14 = new ClassFileVersion(58);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   public static final ClassFileVersion JAVA_V15 = new ClassFileVersion(59);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public static final ClassFileVersion JAVA_V16 = new ClassFileVersion(60);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   public static final ClassFileVersion JAVA_V17 = new ClassFileVersion(61);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   public static final ClassFileVersion JAVA_V18 = new ClassFileVersion(62);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public static final ClassFileVersion JAVA_V19 = new ClassFileVersion(63);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   public static final ClassFileVersion JAVA_V20 = new ClassFileVersion(64);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   private static final VersionLocator VERSION_LOCATOR = doPrivileged(VersionLocator.Resolver.INSTANCE); private final int versionNumber; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassFileVersion(int paramInt) {
/* 164 */     this.versionNumber = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/* 176 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassFileVersion ofMinorMajor(int paramInt) {
/*     */     ClassFileVersion classFileVersion;
/* 187 */     if ((classFileVersion = new ClassFileVersion(paramInt)).getMajorVersion() <= 44) {
/* 188 */       throw new IllegalArgumentException("Class version " + paramInt + " is not valid");
/*     */     }
/* 190 */     return classFileVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassFileVersion ofJavaVersionString(String paramString) {
/* 200 */     if (paramString.equals("1.1"))
/* 201 */       return JAVA_V1; 
/* 202 */     if (paramString.equals("1.2"))
/* 203 */       return JAVA_V2; 
/* 204 */     if (paramString.equals("1.3"))
/* 205 */       return JAVA_V3; 
/* 206 */     if (paramString.equals("1.4"))
/* 207 */       return JAVA_V4; 
/* 208 */     if (paramString.equals("1.5") || paramString.equals("5"))
/* 209 */       return JAVA_V5; 
/* 210 */     if (paramString.equals("1.6") || paramString.equals("6"))
/* 211 */       return JAVA_V6; 
/* 212 */     if (paramString.equals("1.7") || paramString.equals("7"))
/* 213 */       return JAVA_V7; 
/* 214 */     if (paramString.equals("1.8") || paramString.equals("8"))
/* 215 */       return JAVA_V8; 
/* 216 */     if (paramString.equals("1.9") || paramString.equals("9"))
/* 217 */       return JAVA_V9; 
/* 218 */     if (paramString.equals("1.10") || paramString.equals("10"))
/* 219 */       return JAVA_V10; 
/* 220 */     if (paramString.equals("1.11") || paramString.equals("11"))
/* 221 */       return JAVA_V11; 
/* 222 */     if (paramString.equals("1.12") || paramString.equals("12"))
/* 223 */       return JAVA_V12; 
/* 224 */     if (paramString.equals("1.13") || paramString.equals("13"))
/* 225 */       return JAVA_V13; 
/* 226 */     if (paramString.equals("1.14") || paramString.equals("14"))
/* 227 */       return JAVA_V14; 
/* 228 */     if (paramString.equals("1.15") || paramString.equals("15"))
/* 229 */       return JAVA_V15; 
/* 230 */     if (paramString.equals("1.16") || paramString.equals("16"))
/* 231 */       return JAVA_V16; 
/* 232 */     if (paramString.equals("1.17") || paramString.equals("17"))
/* 233 */       return JAVA_V17; 
/* 234 */     if (paramString.equals("1.18") || paramString.equals("18"))
/* 235 */       return JAVA_V18; 
/* 236 */     if (paramString.equals("1.19") || paramString.equals("19"))
/* 237 */       return JAVA_V19; 
/* 238 */     if (paramString.equals("1.20") || paramString.equals("20")) {
/* 239 */       return JAVA_V20;
/*     */     }
/* 241 */     if (OpenedClassReader.EXPERIMENTAL) {
/*     */       try {
/*     */         int i;
/*     */ 
/*     */         
/* 246 */         if ((i = Integer.parseInt(paramString.startsWith("1.") ? paramString.substring(2) : paramString)) > 0) {
/* 247 */           return new ClassFileVersion(i + 44);
/*     */         }
/* 249 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */     
/* 252 */     throw new IllegalArgumentException("Unknown Java version string: " + paramString);
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
/*     */   public static ClassFileVersion ofJavaVersion(int paramInt) {
/* 264 */     switch (paramInt) {
/*     */       case 1:
/* 266 */         return JAVA_V1;
/*     */       case 2:
/* 268 */         return JAVA_V2;
/*     */       case 3:
/* 270 */         return JAVA_V3;
/*     */       case 4:
/* 272 */         return JAVA_V4;
/*     */       case 5:
/* 274 */         return JAVA_V5;
/*     */       case 6:
/* 276 */         return JAVA_V6;
/*     */       case 7:
/* 278 */         return JAVA_V7;
/*     */       case 8:
/* 280 */         return JAVA_V8;
/*     */       case 9:
/* 282 */         return JAVA_V9;
/*     */       case 10:
/* 284 */         return JAVA_V10;
/*     */       case 11:
/* 286 */         return JAVA_V11;
/*     */       case 12:
/* 288 */         return JAVA_V12;
/*     */       case 13:
/* 290 */         return JAVA_V13;
/*     */       case 14:
/* 292 */         return JAVA_V14;
/*     */       case 15:
/* 294 */         return JAVA_V15;
/*     */       case 16:
/* 296 */         return JAVA_V16;
/*     */       case 17:
/* 298 */         return JAVA_V17;
/*     */       case 18:
/* 300 */         return JAVA_V18;
/*     */       case 19:
/* 302 */         return JAVA_V19;
/*     */       case 20:
/* 304 */         return JAVA_V20;
/*     */     } 
/* 306 */     if (OpenedClassReader.EXPERIMENTAL && paramInt > 0) {
/* 307 */       return new ClassFileVersion(paramInt + 44);
/*     */     }
/* 309 */     throw new IllegalArgumentException("Unknown Java version: " + paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassFileVersion latest() {
/* 320 */     return JAVA_V20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassFileVersion ofThisVm() {
/* 331 */     return VERSION_LOCATOR.resolve();
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
/*     */   @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*     */   public static ClassFileVersion ofThisVm(ClassFileVersion paramClassFileVersion) {
/*     */     try {
/* 345 */       return ofThisVm();
/* 346 */     } catch (Exception exception) {
/* 347 */       return paramClassFileVersion;
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
/*     */   public static ClassFileVersion of(Class<?> paramClass) {
/* 359 */     return of(paramClass, ClassFileLocator.ForClassLoader.of(paramClass.getClassLoader()));
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
/*     */   public static ClassFileVersion of(Class<?> paramClass, ClassFileLocator paramClassFileLocator) {
/* 371 */     return of(TypeDescription.ForLoadedType.of(paramClass), paramClassFileLocator);
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
/*     */   public static ClassFileVersion of(TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/* 383 */     return ofClassFile(paramClassFileLocator.locate(paramTypeDescription.getName()).resolve());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassFileVersion ofClassFile(byte[] paramArrayOfbyte) {
/* 393 */     if (paramArrayOfbyte.length < 7) {
/* 394 */       throw new IllegalArgumentException("Supplied byte array is too short to be a class file with " + paramArrayOfbyte.length + " byte");
/*     */     }
/* 396 */     return ofMinorMajor(paramArrayOfbyte[6] << 8 | paramArrayOfbyte[7] & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinorMajorVersion() {
/* 405 */     return this.versionNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMajorVersion() {
/* 414 */     return (short)(this.versionNumber & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMinorVersion() {
/* 423 */     return (short)(this.versionNumber >> 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getJavaVersion() {
/* 432 */     return getMajorVersion() - 44;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAtLeast(ClassFileVersion paramClassFileVersion) {
/* 442 */     return (compareTo(paramClassFileVersion) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGreaterThan(ClassFileVersion paramClassFileVersion) {
/* 452 */     return (compareTo(paramClassFileVersion) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAtMost(ClassFileVersion paramClassFileVersion) {
/* 462 */     return (compareTo(paramClassFileVersion) <= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLessThan(ClassFileVersion paramClassFileVersion) {
/* 472 */     return (compareTo(paramClassFileVersion) < 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassFileVersion asPreviewVersion() {
/* 481 */     return new ClassFileVersion(this.versionNumber | 0xFFFF0000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPreviewVersion() {
/* 490 */     return ((this.versionNumber & 0xFFFF0000) == -65536);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ClassFileVersion paramClassFileVersion) {
/* 497 */     return Integer.signum((getMajorVersion() == paramClassFileVersion.getMajorVersion()) ? (
/* 498 */         getMinorVersion() - paramClassFileVersion.getMinorVersion()) : (
/* 499 */         getMajorVersion() - paramClassFileVersion.getMajorVersion()));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 504 */     return "Java " + getJavaVersion() + " (" + getMinorMajorVersion() + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!(this.versionNumber != ((ClassFileVersion)paramObject).versionNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return getClass().hashCode() * 31 + this.versionNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Resolver
/*     */     implements PrivilegedAction<VersionLocator>
/*     */   {
/* 537 */     INSTANCE;
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*     */     public final ClassFileVersion.VersionLocator run()
/*     */     {
/*     */       
/*     */       try { Method method;
/* 545 */         Class<?> clazz = Class.forName(Runtime.class.getName() + "$Version");
/*     */         
/*     */         try {
/* 548 */           method = clazz.getMethod("feature", new Class[0]);
/* 549 */         } catch (NoSuchMethodException noSuchMethodException) {
/* 550 */           method = clazz.getMethod("major", new Class[0]);
/*     */         } 
/* 552 */         return new ClassFileVersion.VersionLocator.Resolved(ClassFileVersion.ofJavaVersion(((Integer)method.invoke(Runtime.class.getMethod("version", new Class[0]).invoke(null, new Object[0]), new Object[0])).intValue())); }
/* 553 */       catch (Throwable throwable)
/*     */       { 
/*     */         try { String str;
/* 556 */           if ((str = System.getProperty("java.version")) == null)
/* 557 */             throw new IllegalStateException("Java version property is not set"); 
/* 558 */           if (str.equals("0")) {
/* 559 */             return new ClassFileVersion.VersionLocator.Resolved(ClassFileVersion.JAVA_V6);
/*     */           }
/* 561 */           if (str.endsWith("-ea")) {
/* 562 */             str = str.substring(0, str.length() - 3);
/*     */           }
/* 564 */           int[] arrayOfInt = { -1, 0, 0 };
/* 565 */           for (byte b = 1; b < 3; b++) {
/* 566 */             arrayOfInt[b] = str.indexOf('.', arrayOfInt[b - 1] + 1);
/* 567 */             if (arrayOfInt[b] == -1) {
/* 568 */               throw new IllegalStateException("This JVM's version string does not seem to be valid: " + str);
/*     */             }
/*     */           } 
/* 571 */           return new ClassFileVersion.VersionLocator.Resolved(ClassFileVersion.ofJavaVersion(Integer.parseInt(str.substring(arrayOfInt[1] + 1, arrayOfInt[2])))); }
/* 572 */         catch (Throwable throwable1)
/* 573 */         { return new ClassFileVersion.VersionLocator.Unresolved(throwable1.getMessage()); }  }  } } protected static interface VersionLocator { public static final String EARLY_ACCESS = "-ea"; public static final String JAVA_VERSION = "java.version"; ClassFileVersion resolve(); public enum Resolver implements PrivilegedAction<VersionLocator> { @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final ClassFileVersion.VersionLocator run() { try { Method method; Class<?> clazz = Class.forName(Runtime.class.getName() + "$Version"); try { method = clazz.getMethod("feature", new Class[0]); } catch (NoSuchMethodException noSuchMethodException) { method = clazz.getMethod("major", new Class[0]); }  return new ClassFileVersion.VersionLocator.Resolved(ClassFileVersion.ofJavaVersion(((Integer)method.invoke(Runtime.class.getMethod("version", new Class[0]).invoke(null, new Object[0]), new Object[0])).intValue())); } catch (Throwable throwable) { try { String str; if ((str = System.getProperty("java.version")) == null) throw new IllegalStateException("Java version property is not set");  if (str.equals("0")) return new ClassFileVersion.VersionLocator.Resolved(ClassFileVersion.JAVA_V6);  if (str.endsWith("-ea")) str = str.substring(0, str.length() - 3);  int[] arrayOfInt = { -1, 0, 0 }; for (byte b = 1; b < 3; b++) { arrayOfInt[b] = str.indexOf('.', arrayOfInt[b - 1] + 1); if (arrayOfInt[b] == -1) throw new IllegalStateException("This JVM's version string does not seem to be valid: " + str);  }  return new ClassFileVersion.VersionLocator.Resolved(ClassFileVersion.ofJavaVersion(Integer.parseInt(str.substring(arrayOfInt[1] + 1, arrayOfInt[2])))); } catch (Throwable throwable1) { return new ClassFileVersion.VersionLocator.Unresolved(throwable1.getMessage()); }
/*     */            }
/*     */          }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       INSTANCE; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Resolved
/*     */       implements VersionLocator
/*     */     {
/*     */       private final ClassFileVersion classFileVersion;
/*     */ 
/*     */ 
/*     */       
/*     */       protected Resolved(ClassFileVersion param2ClassFileVersion) {
/* 596 */         this.classFileVersion = param2ClassFileVersion;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassFileVersion resolve() {
/* 603 */         return this.classFileVersion;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.classFileVersion.equals(((Resolved)param2Object).classFileVersion))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.classFileVersion.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static class Unresolved
/*     */       implements VersionLocator
/*     */     {
/*     */       private final String message;
/*     */       
/*     */       protected Unresolved(String param2String) {
/* 624 */         this.message = param2String;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassFileVersion resolve() {
/* 631 */         throw new IllegalStateException("Failed to resolve the class file version of the current VM: " + this.message);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.message.equals(((Unresolved)param2Object).message))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.message.hashCode();
/*     */       }
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\ClassFileVersion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */