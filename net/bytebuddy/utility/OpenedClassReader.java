/*     */ package net.bytebuddy.utility;
/*     */ 
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.jar.asm.ClassReader;
/*     */ import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpenedClassReader
/*     */ {
/*     */   public static final String EXPERIMENTAL_PROPERTY = "net.bytebuddy.experimental";
/*     */   public static final boolean EXPERIMENTAL;
/*     */   private static final boolean ACCESS_CONTROLLER;
/*  57 */   public static final int ASM_API = 589824; static { boolean bool; 
/*  58 */     try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */      try {
/*     */       bool = Boolean.parseBoolean(doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("net.bytebuddy.experimental")));
/*     */     } catch (Exception exception) {
/*     */       bool = false;
/*     */     } 
/*  64 */     EXPERIMENTAL = bool; } private OpenedClassReader() { throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated"); }
/*     */ 
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
/*  76 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassReader of(byte[] paramArrayOfbyte) {
/*  86 */     ClassFileVersion classFileVersion1 = ClassFileVersion.ofClassFile(paramArrayOfbyte), classFileVersion2 = ClassFileVersion.latest();
/*  87 */     if (classFileVersion1.isGreaterThan(classFileVersion2)) {
/*  88 */       ClassReader classReader; if (EXPERIMENTAL) {
/*  89 */         paramArrayOfbyte[6] = (byte)(classFileVersion2.getMajorVersion() >>> 8);
/*  90 */         paramArrayOfbyte[7] = (byte)classFileVersion2.getMajorVersion();
/*  91 */         classReader = new ClassReader(paramArrayOfbyte);
/*  92 */         paramArrayOfbyte[6] = (byte)(classFileVersion1.getMajorVersion() >>> 8);
/*  93 */         paramArrayOfbyte[7] = (byte)classFileVersion1.getMajorVersion();
/*  94 */         return classReader;
/*     */       } 
/*  96 */       throw new IllegalArgumentException(classFileVersion1 + " is not supported by the current version of Byte Buddy which officially supports " + classReader + " - update Byte Buddy or set net.bytebuddy.experimental" + " as a VM property");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 101 */     return new ClassReader(paramArrayOfbyte);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\OpenedClassReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */