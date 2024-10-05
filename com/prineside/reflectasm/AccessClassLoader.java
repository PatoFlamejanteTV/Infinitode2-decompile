/*     */ package com.prineside.reflectasm;
/*     */ 
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.PackageDescription;
/*     */ import net.bytebuddy.description.type.RecordComponentDescription;
/*     */ import net.bytebuddy.description.type.RecordComponentList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  41 */   private static final TLog a = TLog.forClass(AccessClassLoader.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private static final WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> b = new WeakHashMap<>();
/*     */ 
/*     */   
/*  50 */   private static final ClassLoader c = b(AccessClassLoader.class);
/*  51 */   private static volatile AccessClassLoader d = new AccessClassLoader(c);
/*     */   
/*     */   private static volatile Method e;
/*     */   
/*  55 */   private final HashSet<String> f = new HashSet<>();
/*     */   
/*     */   private AccessClassLoader(ClassLoader paramClassLoader) {
/*  58 */     super(paramClassLoader);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final Class a(String paramString) {
/*  64 */     if (this.f.contains(paramString)) {
/*     */       try {
/*  66 */         return loadClass(paramString, false);
/*  67 */       } catch (ClassNotFoundException classNotFoundException) {
/*  68 */         throw new RuntimeException(classNotFoundException);
/*     */       } 
/*     */     }
/*  71 */     return null;
/*     */   }
/*     */   
/*     */   final Class a(String paramString, byte[] paramArrayOfbyte) {
/*  75 */     this.f.add(paramString);
/*  76 */     return b(paramString, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Class<?> loadClass(String paramString, boolean paramBoolean) {
/*  81 */     if (paramString.equals(FieldAccess.class.getName())) return FieldAccess.class; 
/*  82 */     if (paramString.equals(MethodAccess.class.getName())) return MethodAccess.class; 
/*  83 */     if (paramString.equals(ConstructorAccess.class.getName())) return ConstructorAccess.class; 
/*  84 */     if (paramString.equals(PublicConstructorAccess.class.getName())) return PublicConstructorAccess.class;
/*     */     
/*  86 */     return super.loadClass(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   private Class<?> b(String paramString, byte[] paramArrayOfbyte) {
/*     */     try {
/*  92 */       return (Class)a().invoke(getParent(), new Object[] { paramString, paramArrayOfbyte, 
/*  93 */             Integer.valueOf(0), Integer.valueOf(paramArrayOfbyte.length), getClass().getProtectionDomain() });
/*  94 */     } catch (Exception exception) {
/*     */ 
/*     */       
/*     */       try {
/*  98 */         return defineClass(paramString, paramArrayOfbyte, 0, paramArrayOfbyte.length, getClass().getProtectionDomain());
/*  99 */       } catch (Exception exception1) {
/*     */         
/* 101 */         a.e("failed to define class in a regular way, using ByteBuddy ClassLoadingStrategy", new Object[0]);
/*     */         ClassLoadingStrategy classLoadingStrategy;
/* 103 */         if ((classLoadingStrategy = Game.i.actionResolver.getByteBuddyClassLoadingStrategy()) == null) {
/* 104 */           throw new IllegalStateException("Failed to define class in a regular way and no ClassLoadingStrategy provided by ActionResolver", exception1);
/*     */         }
/* 106 */         HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */         
/* 109 */         TypeDescription.AbstractBase.OfSimpleType ofSimpleType = new TypeDescription.AbstractBase.OfSimpleType(this, paramString)
/*     */           {
/*     */             public int getModifiers() {
/* 112 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public AnnotationList getDeclaredAnnotations() {
/* 117 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeList.Generic getTypeVariables() {
/* 122 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeDescription.Generic getSuperClass() {
/* 127 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeList.Generic getInterfaces() {
/* 132 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/* 137 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/* 142 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/* 147 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean isRecord() {
/* 152 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeDescription getDeclaringType() {
/* 157 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeList getDeclaredTypes() {
/* 162 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public MethodDescription.InDefinedShape getEnclosingMethod() {
/* 167 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeDescription getEnclosingType() {
/* 172 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean isAnonymousType() {
/* 177 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean isLocalType() {
/* 182 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public PackageDescription getPackage() {
/* 187 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeDescription getNestHost() {
/* 192 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeList getNestMembers() {
/* 197 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public TypeList getPermittedSubtypes() {
/* 202 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public String getName() {
/* 207 */               return this.a;
/*     */             }
/*     */           };
/* 210 */         hashMap.put(ofSimpleType, paramArrayOfbyte);
/*     */         Map<?, Class<?>> map;
/* 212 */         Class<?> clazz = (map = classLoadingStrategy.load(AccessClassLoader.class.getClassLoader(), hashMap)).get(ofSimpleType);
/* 213 */         a.i("created new class: " + clazz, new Object[0]);
/* 214 */         return clazz;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean a(Class paramClass1, Class paramClass2) {
/* 223 */     if (paramClass1.getPackage() != paramClass2.getPackage()) {
/* 224 */       return false;
/*     */     }
/* 226 */     ClassLoader classLoader1 = paramClass1.getClassLoader();
/* 227 */     ClassLoader classLoader2 = paramClass2.getClassLoader();
/* 228 */     ClassLoader classLoader3 = ClassLoader.getSystemClassLoader();
/* 229 */     if (classLoader1 == null) {
/* 230 */       return (classLoader2 == null || classLoader2 == classLoader3);
/*     */     }
/* 232 */     if (classLoader2 == null) return (classLoader1 == classLoader3); 
/* 233 */     return (classLoader1 == classLoader2);
/*     */   }
/*     */   
/*     */   private static ClassLoader b(Class paramClass) {
/*     */     ClassLoader classLoader;
/* 238 */     if ((classLoader = paramClass.getClassLoader()) == null) classLoader = ClassLoader.getSystemClassLoader(); 
/* 239 */     return classLoader;
/*     */   }
/*     */   
/*     */   private static Method a() {
/* 243 */     if (e == null) {
/* 244 */       synchronized (b) {
/* 245 */         if (e == null) {
/* 246 */           e = ClassLoader.class.getDeclaredMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ProtectionDomain.class });
/*     */           
/*     */           try {
/* 249 */             e.setAccessible(true);
/* 250 */           } catch (Exception exception) {}
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 255 */     return e;
/*     */   }
/*     */   
/*     */   static AccessClassLoader a(Class paramClass) {
/* 259 */     null = b(paramClass);
/*     */     
/* 261 */     if (c.equals(null)) {
/* 262 */       if (d == null)
/* 263 */         synchronized (b) {
/* 264 */           if (d == null) {
/* 265 */             d = new AccessClassLoader(c);
/*     */           }
/*     */         }  
/* 268 */       return d;
/*     */     } 
/*     */     
/* 271 */     synchronized (b) {
/*     */       WeakReference<AccessClassLoader> weakReference;
/* 273 */       if ((weakReference = b.get(null)) != null) {
/*     */         AccessClassLoader accessClassLoader1;
/* 275 */         if ((accessClassLoader1 = weakReference.get()) != null) {
/* 276 */           return accessClassLoader1;
/*     */         }
/* 278 */         b.remove(null);
/*     */       } 
/* 280 */       AccessClassLoader accessClassLoader = new AccessClassLoader(null);
/* 281 */       b.put(null, new WeakReference<>(accessClassLoader));
/* 282 */       return accessClassLoader;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void remove(ClassLoader paramClassLoader) {
/* 288 */     if (c.equals(paramClassLoader)) {
/* 289 */       d = null;
/*     */       return;
/*     */     } 
/* 292 */     synchronized (b) {
/* 293 */       b.remove(paramClassLoader);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int activeAccessClassLoaders() {
/* 299 */     int i = b.size();
/* 300 */     if (d != null) i++; 
/* 301 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\reflectasm\AccessClassLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */