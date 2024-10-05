/*     */ package net.bytebuddy.dynamic;
/*     */ 
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Nexus
/*     */   extends WeakReference<ClassLoader>
/*     */ {
/*     */   public static final String PROPERTY = "net.bytebuddy.nexus.disabled";
/*     */   @AlwaysNull
/*  57 */   private static final ReferenceQueue<ClassLoader> NO_QUEUE = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private static final ConcurrentMap<Nexus, Object> TYPE_INITIALIZERS = new ConcurrentHashMap<Nexus, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int classLoaderHashCode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int identification;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Nexus(Class<?> paramClass, int paramInt) {
/*  89 */     this(nonAnonymous(paramClass.getName()), paramClass.getClassLoader(), NO_QUEUE, paramInt);
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
/*     */   private Nexus(String paramString, @MaybeNull ClassLoader paramClassLoader, @MaybeNull ReferenceQueue<? super ClassLoader> paramReferenceQueue, int paramInt) {
/* 101 */     super(paramClassLoader, (paramClassLoader == null) ? null : paramReferenceQueue);
/*     */ 
/*     */     
/* 104 */     this.name = paramString;
/* 105 */     this.classLoaderHashCode = System.identityHashCode(paramClassLoader);
/* 106 */     this.identification = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String nonAnonymous(String paramString) {
/*     */     int i;
/* 117 */     return ((i = paramString.indexOf('/')) == -1) ? paramString : paramString
/*     */       
/* 119 */       .substring(0, i);
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
/*     */   public static void initialize(Class<?> paramClass, int paramInt) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/bytebuddy/dynamic/Nexus.TYPE_INITIALIZERS : Ljava/util/concurrent/ConcurrentMap;
/*     */     //   3: new net/bytebuddy/dynamic/Nexus
/*     */     //   6: dup
/*     */     //   7: aload_0
/*     */     //   8: iload_1
/*     */     //   9: invokespecial <init> : (Ljava/lang/Class;I)V
/*     */     //   12: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   17: dup
/*     */     //   18: astore_1
/*     */     //   19: ifnull -> 62
/*     */     //   22: ldc 'net.bytebuddy.implementation.LoadedTypeInitializer'
/*     */     //   24: iconst_1
/*     */     //   25: aload_1
/*     */     //   26: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   29: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
/*     */     //   32: invokestatic forName : (Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
/*     */     //   35: ldc 'onLoad'
/*     */     //   37: iconst_1
/*     */     //   38: anewarray java/lang/Class
/*     */     //   41: dup
/*     */     //   42: iconst_0
/*     */     //   43: ldc java/lang/Class
/*     */     //   45: aastore
/*     */     //   46: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*     */     //   49: aload_1
/*     */     //   50: iconst_1
/*     */     //   51: anewarray java/lang/Object
/*     */     //   54: dup
/*     */     //   55: iconst_0
/*     */     //   56: aload_0
/*     */     //   57: aastore
/*     */     //   58: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   61: pop
/*     */     //   62: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #139	-> 0
/*     */     //   #140	-> 18
/*     */     //   #141	-> 22
/*     */     //   #143	-> 26
/*     */     //   #141	-> 32
/*     */     //   #143	-> 46
/*     */     //   #145	-> 62
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
/*     */   public static void register(String paramString, @MaybeNull ClassLoader paramClassLoader, @MaybeNull ReferenceQueue<? super ClassLoader> paramReferenceQueue, int paramInt, Object paramObject) {
/* 168 */     TYPE_INITIALIZERS.put(new Nexus(paramString, paramClassLoader, paramReferenceQueue, paramInt), paramObject);
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
/*     */   public static void clean(Reference<? super ClassLoader> paramReference) {
/* 185 */     TYPE_INITIALIZERS.remove(paramReference);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 190 */     int i = this.name.hashCode();
/* 191 */     i = i * 31 + this.classLoaderHashCode;
/*     */     
/* 193 */     return i = i * 31 + this.identification;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/* 198 */     if (this == paramObject)
/* 199 */       return true; 
/* 200 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 201 */       return false;
/*     */     }
/* 203 */     paramObject = paramObject;
/* 204 */     if (this.classLoaderHashCode == ((Nexus)paramObject).classLoaderHashCode && this.identification == ((Nexus)paramObject).identification && this.name
/*     */       
/* 206 */       .equals(((Nexus)paramObject).name) && 
/* 207 */       get() == paramObject.get()) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 212 */     return "Nexus{name='" + this.name + '\'' + ", classLoaderHashCode=" + this.classLoaderHashCode + ", identification=" + this.identification + ", classLoader=" + 
/*     */ 
/*     */ 
/*     */       
/* 216 */       get() + '}';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\Nexus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */