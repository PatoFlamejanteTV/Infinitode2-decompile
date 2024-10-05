/*     */ package net.bytebuddy.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Container;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsStatic;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
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
/*     */ public abstract class FileSystem
/*     */ {
/*     */   private static final boolean ACCESS_CONTROLLER;
/*     */   
/*     */   @Enhance("INSTANCE")
/*     */   public static FileSystem getInstance() {
/*     */     try {
/*  40 */       Class.forName("java.nio.file.Files", false, ClassLoadingStrategy.BOOTSTRAP_LOADER);
/*     */     }
/*  42 */     catch (ClassNotFoundException classNotFoundException) {} FileSystem fileSystem;
/*  43 */     if ((fileSystem = (FileSystem)(((fileSystem = INSTANCE) != null) ? null : new ForLegacyVm())) == null) { fileSystem = INSTANCE; } else { INSTANCE = fileSystem; }  return fileSystem;
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
/*     */   @Enhance
/*     */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/*  56 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract void copy(File paramFile1, File paramFile2);
/*     */ 
/*     */   
/*     */   public abstract void move(File paramFile1, File paramFile2);
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*     */       Class.forName("java.security.AccessController", false, (ClassLoader)null);
/*     */       ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
/*     */       return;
/*     */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       ACCESS_CONTROLLER = false;
/*     */       return;
/*     */     } catch (SecurityException securityException) {
/*     */       ACCESS_CONTROLLER = true;
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   protected static class ForLegacyVm
/*     */     extends FileSystem
/*     */   {
/*     */     public void copy(File param1File1, File param1File2) {
/*  85 */       FileInputStream fileInputStream = new FileInputStream(param1File1);
/*     */       try {
/*  87 */         FileOutputStream fileOutputStream = new FileOutputStream(param1File2);
/*     */         try {
/*  89 */           byte[] arrayOfByte = new byte[1024];
/*     */           int i;
/*  91 */           while ((i = fileInputStream.read(arrayOfByte)) != -1) {
/*  92 */             fileOutputStream.write(arrayOfByte, 0, i);
/*     */           }
/*     */         } finally {
/*  95 */           fileOutputStream.close();
/*     */         }  return;
/*     */       } finally {
/*  98 */         fileInputStream.close();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void move(File param1File1, File param1File2) {
/* 104 */       FileInputStream fileInputStream = new FileInputStream(param1File1);
/*     */       try {
/* 106 */         FileOutputStream fileOutputStream = new FileOutputStream(param1File2);
/*     */         try {
/* 108 */           byte[] arrayOfByte = new byte[1024];
/*     */           int i;
/* 110 */           while ((i = fileInputStream.read(arrayOfByte)) != -1) {
/* 111 */             fileOutputStream.write(arrayOfByte, 0, i);
/*     */           }
/*     */         } finally {
/* 114 */           fileOutputStream.close();
/*     */         } 
/*     */       } finally {
/* 117 */         fileInputStream.close();
/*     */       } 
/* 119 */       if (!param1File1.delete())
/* 120 */         param1File1.deleteOnExit(); 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass())));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   protected static class ForNio2CapableVm extends FileSystem {
/* 134 */     private static final Dispatcher DISPATCHER = (Dispatcher)FileSystem.a(JavaDispatcher.of(Dispatcher.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     private static final Files FILES = (Files)FileSystem.a(JavaDispatcher.of(Files.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     private static final StandardCopyOption STANDARD_COPY_OPTION = (StandardCopyOption)FileSystem.a(JavaDispatcher.of(StandardCopyOption.class));
/*     */ 
/*     */     
/*     */     public void copy(File param1File1, File param1File2) {
/*     */       Object[] arrayOfObject;
/* 149 */       (arrayOfObject = STANDARD_COPY_OPTION.toArray(1))[0] = STANDARD_COPY_OPTION.valueOf("REPLACE_EXISTING");
/* 150 */       FILES.copy(DISPATCHER.toPath(param1File1), DISPATCHER.toPath(param1File2), arrayOfObject);
/*     */     }
/*     */ 
/*     */     
/*     */     public void move(File param1File1, File param1File2) {
/*     */       Object[] arrayOfObject;
/* 156 */       (arrayOfObject = STANDARD_COPY_OPTION.toArray(1))[0] = STANDARD_COPY_OPTION.valueOf("REPLACE_EXISTING");
/* 157 */       FILES.move(DISPATCHER.toPath(param1File1), DISPATCHER.toPath(param1File2), arrayOfObject);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass())));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode();
/*     */     }
/*     */     
/*     */     @Proxied("java.nio.file.StandardCopyOption")
/*     */     protected static interface StandardCopyOption {
/*     */       @Container
/*     */       @Proxied("toArray")
/*     */       Object[] toArray(int param2Int);
/*     */       
/*     */       @IsStatic
/*     */       @Proxied("valueOf")
/*     */       Object valueOf(String param2String);
/*     */     }
/*     */     
/*     */     @Proxied("java.nio.file.Files")
/*     */     protected static interface Files {
/*     */       @IsStatic
/*     */       @Proxied("copy")
/*     */       Object copy(@Proxied("java.nio.file.Path") Object param2Object1, @Proxied("java.nio.file.Path") Object param2Object2, @Proxied("java.nio.file.CopyOption") Object[] param2ArrayOfObject);
/*     */       
/*     */       @IsStatic
/*     */       @Proxied("move")
/*     */       Object move(@Proxied("java.nio.file.Path") Object param2Object1, @Proxied("java.nio.file.Path") Object param2Object2, @Proxied("java.nio.file.CopyOption") Object[] param2ArrayOfObject);
/*     */     }
/*     */     
/*     */     @Proxied("java.io.File")
/*     */     protected static interface Dispatcher {
/*     */       @Proxied("toPath")
/*     */       Object toPath(File param2File);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\FileSystem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */