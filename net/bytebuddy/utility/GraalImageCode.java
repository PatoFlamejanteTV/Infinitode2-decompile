/*     */ package net.bytebuddy.utility;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*     */ public enum GraalImageCode
/*     */ {
/*  38 */   AGENT(true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   BUILD(true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   RUNTIME(true, true),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   UNKNOWN(false, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   NONE(false, false);
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*     */       Class.forName("java.security.AccessController", false, (ClassLoader)null);
/*     */       ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
/*     */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       ACCESS_CONTROLLER = false;
/*     */     } catch (SecurityException securityException) {
/*     */       ACCESS_CONTROLLER = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   @SuppressFBWarnings(value = {"LI_LAZY_INIT_STATIC", "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "This behaviour is intended to avoid early binding in native images.")
/*     */   public static GraalImageCode getCurrent() {
/*     */     GraalImageCode graalImageCode;
/*  75 */     if ((graalImageCode = current) == null) {
/*     */       String str;
/*  77 */       if ((str = doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("org.graalvm.nativeimage.imagecode"))) == null) {
/*     */ 
/*     */         
/*  80 */         graalImageCode = ((str = doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("java.vm.vendor"))) != null && str.toLowerCase(Locale.US).contains("graalvm")) ? doPrivileged(ImageCodeContextAction.INSTANCE) : NONE;
/*     */       }
/*  82 */       else if (graalImageCode.equalsIgnoreCase("agent")) {
/*  83 */         graalImageCode = AGENT;
/*  84 */       } else if (graalImageCode.equalsIgnoreCase("runtime")) {
/*  85 */         graalImageCode = RUNTIME;
/*  86 */       } else if (graalImageCode.equalsIgnoreCase("buildtime")) {
/*  87 */         graalImageCode = BUILD;
/*     */       } else {
/*  89 */         graalImageCode = UNKNOWN;
/*     */       } 
/*  91 */       current = graalImageCode;
/*     */     } 
/*  93 */     return graalImageCode;
/*     */   }
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   private static GraalImageCode current;
/*     */   
/*     */   private final boolean defined;
/*     */   private final boolean nativeImageExecution;
/*     */   private static final boolean ACCESS_CONTROLLER;
/*     */   
/*     */   public final <T> T[] sorted(T[] paramArrayOfT, Comparator<? super T> paramComparator) {
/* 105 */     if (this.defined) {
/* 106 */       Arrays.sort(paramArrayOfT, paramComparator);
/*     */     }
/* 108 */     return paramArrayOfT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   @Enhance
/*     */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/* 121 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
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
/*     */   GraalImageCode(boolean paramBoolean1, boolean paramBoolean2) {
/* 141 */     this.defined = paramBoolean1;
/* 142 */     this.nativeImageExecution = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDefined() {
/* 151 */     return this.defined;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isNativeImageExecution() {
/* 160 */     return this.nativeImageExecution;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum ImageCodeContextAction
/*     */     implements PrivilegedAction<GraalImageCode>
/*     */   {
/* 171 */     INSTANCE;
/*     */ 
/*     */ 
/*     */     
/*     */     public final GraalImageCode run() {
/*     */       try {
/*     */         Method method;
/*     */         List<?> list;
/* 179 */         for (Iterator<?> iterator = (list = (List)(method = Class.forName("java.lang.management.ManagementFactory").getMethod("getRuntimeMXBean", new Class[0])).getReturnType().getMethod("getInputArguments", new Class[0]).invoke(method.invoke(null, new Object[0]), new Object[0])).iterator(); iterator.hasNext();) {
/* 180 */           if ((str = (String)iterator.next()).startsWith("-agentlib:native-image-agent")) {
/* 181 */             return GraalImageCode.AGENT;
/*     */           }
/*     */         } 
/* 184 */       } catch (Throwable throwable) {}
/*     */ 
/*     */       
/* 187 */       return GraalImageCode.NONE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\GraalImageCode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */