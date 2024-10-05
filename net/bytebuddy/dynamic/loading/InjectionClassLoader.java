/*     */ package net.bytebuddy.dynamic.loading;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import net.bytebuddy.description.type.TypeDescription;
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
/*     */ public abstract class InjectionClassLoader
/*     */   extends ClassLoader
/*     */ {
/*     */   private final AtomicBoolean sealed;
/*     */   
/*     */   static {
/*  43 */     doRegisterAsParallelCapable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Must be invoked from targeting class loader type.")
/*     */   private static void doRegisterAsParallelCapable() {
/*     */     try {
/*     */       Method method;
/*  53 */       (method = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0])).setAccessible(true);
/*  54 */       method.invoke(null, new Object[0]); return;
/*  55 */     } catch (Throwable throwable) {
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
/*     */   protected InjectionClassLoader(@MaybeNull ClassLoader paramClassLoader, boolean paramBoolean) {
/*  72 */     super(paramClassLoader);
/*  73 */     this.sealed = new AtomicBoolean(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSealed() {
/*  82 */     return this.sealed.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean seal() {
/*  91 */     return !this.sealed.getAndSet(true);
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
/*     */   public Class<?> defineClass(String paramString, byte[] paramArrayOfbyte) {
/* 103 */     return defineClasses((Map)Collections.singletonMap(paramString, paramArrayOfbyte)).get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Class<?>> defineClasses(Map<String, byte[]> paramMap) {
/* 114 */     if (this.sealed.get()) {
/* 115 */       throw new IllegalStateException("Cannot inject classes into a sealed class loader");
/*     */     }
/* 117 */     return doDefineClasses(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Map<String, Class<?>> doDefineClasses(Map<String, byte[]> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Strategy
/*     */     implements ClassLoadingStrategy<InjectionClassLoader>
/*     */   {
/* 137 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Map<TypeDescription, Class<?>> load(@MaybeNull InjectionClassLoader param1InjectionClassLoader, Map<TypeDescription, byte[]> param1Map) {
/* 143 */       if (param1InjectionClassLoader == null) {
/* 144 */         throw new IllegalArgumentException("Cannot add types to bootstrap class loader: " + param1Map);
/*     */       }
/* 146 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 147 */       HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 148 */       for (Map.Entry<TypeDescription, byte> entry : param1Map.entrySet()) {
/* 149 */         linkedHashMap.put(((TypeDescription)entry.getKey()).getName(), entry.getValue());
/* 150 */         hashMap1.put(((TypeDescription)entry.getKey()).getName(), entry.getKey());
/*     */       } 
/* 152 */       HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/*     */       try {
/* 154 */         for (Map.Entry<String, Class<?>> entry : param1InjectionClassLoader.defineClasses((Map)linkedHashMap).entrySet()) {
/* 155 */           hashMap2.put(hashMap1.get(entry.getKey()), entry.getValue());
/*     */         }
/* 157 */       } catch (ClassNotFoundException classNotFoundException) {
/* 158 */         throw new IllegalStateException("Cannot load classes: " + param1Map, classNotFoundException);
/*     */       } 
/* 160 */       return (Map)hashMap2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\InjectionClassLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */