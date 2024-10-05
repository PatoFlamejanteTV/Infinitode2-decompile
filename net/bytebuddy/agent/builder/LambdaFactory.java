/*     */ package net.bytebuddy.agent.builder;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.instrument.ClassFileTransformer;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.loading.ClassInjector;
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
/*     */ @Enhance
/*     */ public class LambdaFactory
/*     */ {
/*     */   private static final String FIELD_NAME = "CLASS_FILE_TRANSFORMERS";
/*     */   @SuppressFBWarnings(value = {"MS_MUTABLE_COLLECTION_PKGPROTECT"}, justification = "The field must be accessible by different class loader instances.")
/*  51 */   public static final Map<ClassFileTransformer, LambdaFactory> CLASS_FILE_TRANSFORMERS = new ConcurrentHashMap<ClassFileTransformer, LambdaFactory>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Object target;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Method dispatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LambdaFactory(Object paramObject, Method paramMethod) {
/*  70 */     this.target = paramObject;
/*  71 */     this.dispatcher = paramMethod;
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
/*     */   public static boolean register(ClassFileTransformer paramClassFileTransformer, Object paramObject) {
/*     */     try {
/*  92 */       TypeDescription typeDescription = TypeDescription.ForLoadedType.of(LambdaFactory.class);
/*     */ 
/*     */       
/*     */       Class<?> clazz;
/*     */ 
/*     */       
/*     */       Map map;
/*     */       
/* 100 */       synchronized (map = (Map)(clazz = (Class)ClassInjector.UsingReflection.ofSystemClassLoader().inject(Collections.singletonMap(typeDescription, ClassFileLocator.ForClassLoader.read(LambdaFactory.class))).get(typeDescription)).getField("CLASS_FILE_TRANSFORMERS").get(null)) {
/*     */         try {
/* 102 */           return map.isEmpty();
/*     */         } finally {
/* 104 */           map.put(paramClassFileTransformer, clazz
/* 105 */               .getConstructor(new Class[] { Object.class, Method.class
/* 106 */                 }).newInstance(new Object[] { paramObject, paramObject.getClass().getMethod("make", new Class[] { Object.class, String.class, Object.class, Object.class, Object.class, Object.class, boolean.class, List.class, List.class, Collection.class }) }));
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 119 */     catch (RuntimeException runtimeException2) {
/* 120 */       RuntimeException runtimeException1; throw runtimeException1 = null;
/* 121 */     } catch (Exception exception) {
/* 122 */       throw new IllegalStateException("Could not register class file transformer", exception);
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
/*     */   public static boolean release(ClassFileTransformer paramClassFileTransformer) {
/*     */     try {
/*     */       Map map;
/* 141 */       synchronized (map = (Map)ClassLoader.getSystemClassLoader().loadClass(LambdaFactory.class.getName()).getField("CLASS_FILE_TRANSFORMERS").get(null)) {
/* 142 */         return (map.remove(paramClassFileTransformer) != null && map.isEmpty());
/*     */       } 
/* 144 */     } catch (RuntimeException runtimeException2) {
/* 145 */       RuntimeException runtimeException1; throw runtimeException1 = null;
/* 146 */     } catch (Exception exception) {
/* 147 */       throw new IllegalStateException("Could not release class file transformer", exception);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] invoke(Object paramObject1, String paramString, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, boolean paramBoolean, List<Class<?>> paramList, List<?> paramList1, Collection<ClassFileTransformer> paramCollection) {
/*     */     try {
/* 178 */       return (byte[])this.dispatcher.invoke(this.target, new Object[] { paramObject1, paramString, paramObject2, paramObject3, paramObject4, paramObject5, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 185 */             Boolean.valueOf(paramBoolean), paramList, paramList1, paramCollection });
/*     */ 
/*     */     
/*     */     }
/* 189 */     catch (RuntimeException runtimeException) {
/* 190 */       throw paramObject1 = null;
/* 191 */     } catch (Exception exception) {
/* 192 */       throw new IllegalStateException("Cannot create class for lambda expression", exception);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] make(Object paramObject1, String paramString, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, boolean paramBoolean, List<Class<?>> paramList, List<?> paramList1) {
/* 219 */     return ((LambdaFactory)CLASS_FILE_TRANSFORMERS.values().iterator().next()).invoke(paramObject1, paramString, paramObject2, paramObject3, paramObject4, paramObject5, paramBoolean, paramList, paramList1, CLASS_FILE_TRANSFORMERS
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 228 */         .keySet());
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.target.equals(((LambdaFactory)paramObject).target) ? false : (!!this.dispatcher.equals(((LambdaFactory)paramObject).dispatcher)))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return (getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.dispatcher.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\agent\builder\LambdaFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */