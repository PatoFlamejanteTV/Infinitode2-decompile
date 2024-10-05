/*     */ package com.esotericsoftware.reflectasm;
/*     */ 
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.HashSet;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class AccessClassLoader
/*     */   extends ClassLoader
/*     */ {
/*  28 */   private static final WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> accessClassLoaders = new WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>>();
/*     */ 
/*     */   
/*  31 */   private static final ClassLoader selfContextParentClassLoader = getParentClassLoader(AccessClassLoader.class);
/*  32 */   private static volatile AccessClassLoader selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
/*     */   
/*     */   private static volatile Method defineClassMethod;
/*     */   
/*  36 */   private final HashSet<String> localClassNames = new HashSet<String>();
/*     */   
/*     */   private AccessClassLoader(ClassLoader paramClassLoader) {
/*  39 */     super(paramClassLoader);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Class loadAccessClass(String paramString) {
/*  45 */     if (this.localClassNames.contains(paramString)) {
/*     */       try {
/*  47 */         return loadClass(paramString, false);
/*  48 */       } catch (ClassNotFoundException classNotFoundException) {
/*  49 */         throw new RuntimeException(classNotFoundException);
/*     */       } 
/*     */     }
/*  52 */     return null;
/*     */   }
/*     */   
/*     */   Class defineAccessClass(String paramString, byte[] paramArrayOfbyte) {
/*  56 */     this.localClassNames.add(paramString);
/*  57 */     return defineClass(paramString, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Class<?> loadClass(String paramString, boolean paramBoolean) {
/*  62 */     if (paramString.equals(FieldAccess.class.getName())) return FieldAccess.class; 
/*  63 */     if (paramString.equals(MethodAccess.class.getName())) return MethodAccess.class; 
/*  64 */     if (paramString.equals(ConstructorAccess.class.getName())) return ConstructorAccess.class; 
/*  65 */     if (paramString.equals(PublicConstructorAccess.class.getName())) return PublicConstructorAccess.class;
/*     */     
/*  67 */     return super.loadClass(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> defineClass(String paramString, byte[] paramArrayOfbyte) {
/*     */     try {
/*  73 */       return (Class)getDefineClassMethod().invoke(getParent(), new Object[] { paramString, paramArrayOfbyte, 
/*  74 */             Integer.valueOf(0), Integer.valueOf(paramArrayOfbyte.length), getClass().getProtectionDomain() });
/*  75 */     } catch (Exception exception) {
/*     */ 
/*     */       
/*  78 */       return defineClass(paramString, paramArrayOfbyte, 0, paramArrayOfbyte.length, getClass().getProtectionDomain());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean areInSameRuntimeClassLoader(Class paramClass1, Class paramClass2) {
/*  85 */     if (paramClass1.getPackage() != paramClass2.getPackage()) {
/*  86 */       return false;
/*     */     }
/*  88 */     ClassLoader classLoader1 = paramClass1.getClassLoader();
/*  89 */     ClassLoader classLoader2 = paramClass2.getClassLoader();
/*  90 */     ClassLoader classLoader3 = ClassLoader.getSystemClassLoader();
/*  91 */     if (classLoader1 == null) {
/*  92 */       return (classLoader2 == null || classLoader2 == classLoader3);
/*     */     }
/*  94 */     if (classLoader2 == null) return (classLoader1 == classLoader3); 
/*  95 */     return (classLoader1 == classLoader2);
/*     */   }
/*     */   
/*     */   private static ClassLoader getParentClassLoader(Class paramClass) {
/*     */     ClassLoader classLoader;
/* 100 */     if ((classLoader = paramClass.getClassLoader()) == null) classLoader = ClassLoader.getSystemClassLoader(); 
/* 101 */     return classLoader;
/*     */   }
/*     */   
/*     */   private static Method getDefineClassMethod() {
/* 105 */     if (defineClassMethod == null) {
/* 106 */       synchronized (accessClassLoaders) {
/* 107 */         if (defineClassMethod == null) {
/* 108 */           defineClassMethod = ClassLoader.class.getDeclaredMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ProtectionDomain.class });
/*     */           
/*     */           try {
/* 111 */             defineClassMethod.setAccessible(true);
/* 112 */           } catch (Exception exception) {}
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 117 */     return defineClassMethod;
/*     */   }
/*     */   
/*     */   static AccessClassLoader get(Class paramClass) {
/* 121 */     null = getParentClassLoader(paramClass);
/*     */     
/* 123 */     if (selfContextParentClassLoader.equals(null)) {
/* 124 */       if (selfContextAccessClassLoader == null)
/* 125 */         synchronized (accessClassLoaders) {
/* 126 */           if (selfContextAccessClassLoader == null) {
/* 127 */             selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
/*     */           }
/*     */         }  
/* 130 */       return selfContextAccessClassLoader;
/*     */     } 
/*     */     
/* 133 */     synchronized (accessClassLoaders) {
/*     */       WeakReference<AccessClassLoader> weakReference;
/* 135 */       if ((weakReference = accessClassLoaders.get(null)) != null) {
/*     */         AccessClassLoader accessClassLoader1;
/* 137 */         if ((accessClassLoader1 = weakReference.get()) != null) {
/* 138 */           return accessClassLoader1;
/*     */         }
/* 140 */         accessClassLoaders.remove(null);
/*     */       } 
/* 142 */       AccessClassLoader accessClassLoader = new AccessClassLoader(null);
/* 143 */       accessClassLoaders.put(null, new WeakReference<AccessClassLoader>(accessClassLoader));
/* 144 */       return accessClassLoader;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void remove(ClassLoader paramClassLoader) {
/* 150 */     if (selfContextParentClassLoader.equals(paramClassLoader)) {
/* 151 */       selfContextAccessClassLoader = null;
/*     */       return;
/*     */     } 
/* 154 */     synchronized (accessClassLoaders) {
/* 155 */       accessClassLoaders.remove(paramClassLoader);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int activeAccessClassLoaders() {
/* 161 */     int i = accessClassLoaders.size();
/* 162 */     if (selfContextAccessClassLoader != null) i++; 
/* 163 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\reflectasm\AccessClassLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */