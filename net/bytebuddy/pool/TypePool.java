/*      */ package net.bytebuddy.pool;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.IOException;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.ref.SoftReference;
/*      */ import java.lang.reflect.GenericSignatureFormatError;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentMap;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.TypeVariableSource;
/*      */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.method.ParameterList;
/*      */ import net.bytebuddy.description.type.PackageDescription;
/*      */ import net.bytebuddy.description.type.RecordComponentDescription;
/*      */ import net.bytebuddy.description.type.RecordComponentList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.ClassFileLocator;
/*      */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*      */ import net.bytebuddy.implementation.bytecode.StackSize;
/*      */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*      */ import net.bytebuddy.jar.asm.ClassReader;
/*      */ import net.bytebuddy.jar.asm.ClassVisitor;
/*      */ import net.bytebuddy.jar.asm.FieldVisitor;
/*      */ import net.bytebuddy.jar.asm.Label;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
/*      */ import net.bytebuddy.jar.asm.Type;
/*      */ import net.bytebuddy.jar.asm.TypePath;
/*      */ import net.bytebuddy.jar.asm.TypeReference;
/*      */ import net.bytebuddy.jar.asm.signature.SignatureReader;
/*      */ import net.bytebuddy.jar.asm.signature.SignatureVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.JavaType;
/*      */ import net.bytebuddy.utility.OpenedClassReader;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.nullability.UnknownNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface TypePool
/*      */ {
/*      */   Resolution describe(String paramString);
/*      */   
/*      */   void clear();
/*      */   
/*      */   public static interface Resolution
/*      */   {
/*      */     boolean isResolved();
/*      */     
/*      */     TypeDescription resolve();
/*      */     
/*      */     @Enhance
/*      */     public static class Simple
/*      */       implements Resolution
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */       
/*      */       public Simple(TypeDescription param2TypeDescription) {
/*  118 */         this.typeDescription = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isResolved() {
/*  125 */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription resolve() {
/*  132 */         return this.typeDescription;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((Simple)param2Object).typeDescription))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class Illegal
/*      */       implements Resolution
/*      */     {
/*      */       private final String name;
/*      */       
/*      */       public Illegal(String param2String) {
/*  153 */         this.name = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isResolved() {
/*  160 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription resolve() {
/*  167 */         throw new TypePool.Resolution.NoSuchTypeException(this.name);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.name.equals(((Illegal)param2Object).name))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.name.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public static class NoSuchTypeException
/*      */       extends IllegalStateException
/*      */     {
/*      */       private static final long serialVersionUID = 1L;
/*      */       
/*      */       private final String name;
/*      */ 
/*      */       
/*      */       public NoSuchTypeException(String param2String) {
/*  192 */         super("Cannot resolve type description for " + param2String);
/*  193 */         this.name = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getName() {
/*  202 */         return this.name;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface CacheProvider
/*      */   {
/*      */     @MaybeNull
/*  216 */     public static final TypePool.Resolution UNRESOLVED = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     TypePool.Resolution find(String param1String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TypePool.Resolution register(String param1String, TypePool.Resolution param1Resolution);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void clear();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum NoOp
/*      */       implements CacheProvider
/*      */     {
/*  251 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public final TypePool.Resolution find(String param2String) {
/*  258 */         return UNRESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final TypePool.Resolution register(String param2String, TypePool.Resolution param2Resolution) {
/*  265 */         return param2Resolution;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final void clear() {}
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Simple
/*      */       implements CacheProvider
/*      */     {
/*      */       private final ConcurrentMap<String, TypePool.Resolution> storage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Simple() {
/*  290 */         this(new ConcurrentHashMap<String, TypePool.Resolution>());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Simple(ConcurrentMap<String, TypePool.Resolution> param2ConcurrentMap) {
/*  299 */         this.storage = param2ConcurrentMap;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypePool.CacheProvider withObjectType() {
/*      */         Simple simple;
/*  309 */         (simple = new Simple()).register(Object.class.getName(), new TypePool.Resolution.Simple(TypeDescription.ForLoadedType.of(Object.class)));
/*  310 */         return simple;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public TypePool.Resolution find(String param2String) {
/*  318 */         return this.storage.get(param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypePool.Resolution register(String param2String, TypePool.Resolution param2Resolution) {
/*      */         TypePool.Resolution resolution;
/*  326 */         return ((resolution = this.storage.putIfAbsent(param2String, param2Resolution)) == null) ? param2Resolution : resolution;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void clear() {
/*  335 */         this.storage.clear();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ConcurrentMap<String, TypePool.Resolution> getStorage() {
/*  344 */         return this.storage;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class UsingSoftReference
/*      */         implements TypePool.CacheProvider
/*      */       {
/*  361 */         private final AtomicReference<SoftReference<TypePool.CacheProvider.Simple>> delegate = new AtomicReference<SoftReference<TypePool.CacheProvider.Simple>>(new SoftReference<TypePool.CacheProvider.Simple>(new TypePool.CacheProvider.Simple()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public TypePool.Resolution find(String param3String) {
/*      */           TypePool.CacheProvider cacheProvider;
/*  370 */           return ((cacheProvider = ((SoftReference<TypePool.CacheProvider>)this.delegate.get()).get()) == null) ? UNRESOLVED : cacheProvider
/*      */             
/*  372 */             .find(param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypePool.Resolution register(String param3String, TypePool.Resolution param3Resolution) {
/*      */           SoftReference<TypePool.CacheProvider.Simple> softReference;
/*      */           TypePool.CacheProvider.Simple simple;
/*  381 */           if ((simple = (softReference = this.delegate.get()).get()) == null) {
/*  382 */             simple = new TypePool.CacheProvider.Simple();
/*  383 */             while (!this.delegate.compareAndSet(softReference, new SoftReference<TypePool.CacheProvider.Simple>(simple))) {
/*      */               TypePool.CacheProvider.Simple simple1;
/*      */               
/*  386 */               if ((simple1 = (softReference = this.delegate.get()).get()) != null) {
/*  387 */                 simple = simple1;
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*  392 */           return simple.register(param3String, param3Resolution);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void clear() {
/*      */           TypePool.CacheProvider cacheProvider;
/*  400 */           if ((cacheProvider = ((SoftReference<TypePool.CacheProvider>)this.delegate.get()).get()) != null) {
/*  401 */             cacheProvider.clear();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Discriminating
/*      */       implements CacheProvider
/*      */     {
/*      */       private final ElementMatcher<String> matcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypePool.CacheProvider matched;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypePool.CacheProvider unmatched;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Discriminating(ElementMatcher<String> param2ElementMatcher, TypePool.CacheProvider param2CacheProvider1, TypePool.CacheProvider param2CacheProvider2) {
/*  435 */         this.matcher = param2ElementMatcher;
/*  436 */         this.matched = param2CacheProvider1;
/*  437 */         this.unmatched = param2CacheProvider2;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public TypePool.Resolution find(String param2String) {
/*  445 */         return (this.matcher.matches(param2String) ? this.matched : this.unmatched).find(param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypePool.Resolution register(String param2String, TypePool.Resolution param2Resolution) {
/*  452 */         return (this.matcher.matches(param2String) ? this.matched : this.unmatched).register(param2String, param2Resolution);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void clear() {
/*      */         try {
/*  460 */           this.unmatched.clear(); return;
/*      */         } finally {
/*  462 */           this.matched.clear();
/*      */         } 
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum Empty
/*      */     implements TypePool
/*      */   {
/*  476 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final TypePool.Resolution describe(String param1String) {
/*  482 */       return new TypePool.Resolution.Illegal(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void clear() {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static abstract class AbstractBase
/*      */     implements TypePool
/*      */   {
/*      */     protected static final Map<String, TypeDescription> PRIMITIVE_TYPES;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static final Map<String, String> PRIMITIVE_DESCRIPTORS;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String ARRAY_SYMBOL = "[";
/*      */ 
/*      */ 
/*      */     
/*      */     protected final TypePool.CacheProvider cacheProvider;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*  519 */       HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/*  520 */       HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>(); Class[] arrayOfClass; byte b;
/*  521 */       for (arrayOfClass = new Class[] { boolean.class, byte.class, short.class, char.class, int.class, long.class, float.class, double.class, void.class }, b = 0; b < 9; ) { Class clazz = arrayOfClass[b];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  530 */         hashMap1.put(clazz.getName(), TypeDescription.ForLoadedType.of(clazz));
/*  531 */         hashMap2.put(Type.getDescriptor(clazz), clazz.getName()); b++; }
/*      */       
/*  533 */       PRIMITIVE_TYPES = Collections.unmodifiableMap(hashMap1);
/*  534 */       PRIMITIVE_DESCRIPTORS = Collections.unmodifiableMap(hashMap2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected AbstractBase(TypePool.CacheProvider param1CacheProvider) {
/*  548 */       this.cacheProvider = param1CacheProvider;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypePool.Resolution describe(String param1String) {
/*  555 */       if (param1String.contains("/")) {
/*  556 */         throw new IllegalArgumentException(param1String + " contains the illegal character '/'");
/*      */       }
/*  558 */       byte b = 0;
/*  559 */       while (param1String.startsWith("[")) {
/*  560 */         b++;
/*  561 */         param1String = param1String.substring(1);
/*      */       } 
/*  563 */       if (b > 0) {
/*      */         String str;
/*      */         
/*  566 */         param1String = ((str = PRIMITIVE_DESCRIPTORS.get(param1String)) == null) ? param1String.substring(1, param1String.length() - 1) : str;
/*      */       } 
/*      */       
/*      */       TypePool.Resolution resolution;
/*      */       
/*      */       TypeDescription typeDescription;
/*      */       
/*  573 */       if ((resolution = (TypePool.Resolution)(((typeDescription = PRIMITIVE_TYPES.get(param1String)) == null) ? this.cacheProvider.find(param1String) : new TypePool.Resolution.Simple(typeDescription))) == null) {
/*  574 */         resolution = doCache(param1String, doDescribe(param1String));
/*      */       }
/*  576 */       return ArrayTypeResolution.of(resolution, b);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected TypePool.Resolution doCache(String param1String, TypePool.Resolution param1Resolution) {
/*  588 */       return this.cacheProvider.register(param1String, param1Resolution);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void clear() {
/*  595 */       this.cacheProvider.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     protected abstract TypePool.Resolution doDescribe(String param1String);
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.cacheProvider.equals(((AbstractBase)param1Object).cacheProvider))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.cacheProvider.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     protected static interface ComponentTypeReference
/*      */     {
/*      */       @MaybeNull
/*  615 */       public static final String NO_ARRAY = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       String resolve();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static abstract class Hierarchical
/*      */       extends AbstractBase
/*      */     {
/*      */       private final TypePool parent;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Hierarchical(TypePool.CacheProvider param2CacheProvider, TypePool param2TypePool) {
/*  646 */         super(param2CacheProvider);
/*  647 */         this.parent = param2TypePool;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypePool.Resolution describe(String param2String) {
/*      */         TypePool.Resolution resolution;
/*  655 */         return (resolution = this.parent.describe(param2String)).isResolved() ? resolution : super
/*      */           
/*  657 */           .describe(param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void clear() {
/*      */         try {
/*  665 */           this.parent.clear(); return;
/*      */         } finally {
/*  667 */           super.clear();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.parent.equals(((Hierarchical)param2Object).parent)))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.parent.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class ArrayTypeResolution
/*      */       implements TypePool.Resolution
/*      */     {
/*      */       private final TypePool.Resolution resolution;
/*      */       
/*      */       private final int arity;
/*      */ 
/*      */       
/*      */       protected ArrayTypeResolution(TypePool.Resolution param2Resolution, int param2Int) {
/*  695 */         this.resolution = param2Resolution;
/*  696 */         this.arity = param2Int;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static TypePool.Resolution of(TypePool.Resolution param2Resolution, int param2Int) {
/*  710 */         return (param2Int == 0) ? param2Resolution : new ArrayTypeResolution(param2Resolution, param2Int);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isResolved() {
/*  719 */         return this.resolution.isResolved();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription resolve() {
/*  726 */         return TypeDescription.ArrayProjection.of(this.resolution.resolve(), this.arity);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.arity != ((ArrayTypeResolution)param2Object).arity) ? false : (!!this.resolution.equals(((ArrayTypeResolution)param2Object).resolution)))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.resolution.hashCode()) * 31 + this.arity;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Default
/*      */     extends AbstractBase.Hierarchical
/*      */   {
/*      */     @AlwaysNull
/*  747 */     private static final MethodVisitor IGNORE_METHOD = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected final ClassFileLocator classFileLocator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected final ReaderMode readerMode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Default(TypePool.CacheProvider param1CacheProvider, ClassFileLocator param1ClassFileLocator, ReaderMode param1ReaderMode) {
/*  767 */       this(param1CacheProvider, param1ClassFileLocator, param1ReaderMode, TypePool.Empty.INSTANCE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Default(TypePool.CacheProvider param1CacheProvider, ClassFileLocator param1ClassFileLocator, ReaderMode param1ReaderMode, TypePool param1TypePool) {
/*  779 */       super(param1CacheProvider, param1TypePool);
/*  780 */       this.classFileLocator = param1ClassFileLocator;
/*  781 */       this.readerMode = param1ReaderMode;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool ofSystemLoader() {
/*  791 */       return of(ClassFileLocator.ForClassLoader.ofSystemLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool ofPlatformLoader() {
/*  802 */       return of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool ofBootLoader() {
/*  812 */       return of(ClassFileLocator.ForClassLoader.ofBootLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool of(@MaybeNull ClassLoader param1ClassLoader) {
/*  822 */       return of(ClassFileLocator.ForClassLoader.of(param1ClassLoader));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool of(ClassFileLocator param1ClassFileLocator) {
/*  833 */       return new Default(new TypePool.CacheProvider.Simple(), param1ClassFileLocator, ReaderMode.FAST);
/*      */     }
/*      */ 
/*      */     
/*      */     protected TypePool.Resolution doDescribe(String param1String) {
/*      */       try {
/*      */         ClassFileLocator.Resolution resolution;
/*  840 */         return (TypePool.Resolution)((resolution = this.classFileLocator.locate(param1String)).isResolved() ? new TypePool.Resolution.Simple(
/*  841 */             parse(resolution.resolve())) : new TypePool.Resolution.Illegal(param1String));
/*      */       }
/*  843 */       catch (IOException iOException) {
/*  844 */         throw new IllegalStateException("Error while reading class file", iOException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private TypeDescription parse(byte[] param1ArrayOfbyte) {
/*  855 */       ClassReader classReader = OpenedClassReader.of(param1ArrayOfbyte);
/*  856 */       TypeExtractor typeExtractor = new TypeExtractor(this);
/*  857 */       classReader.accept(typeExtractor, this.readerMode.getFlags());
/*  858 */       return typeExtractor.toTypeDescription();
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.readerMode.equals(((Default)param1Object).readerMode) ? false : (!!this.classFileLocator.equals(((Default)param1Object).classFileLocator))))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (super.hashCode() * 31 + this.classFileLocator.hashCode()) * 31 + this.readerMode.hashCode();
/*      */     }
/*      */     
/*      */     public enum ReaderMode {
/*  870 */       EXTENDED(4),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  877 */       FAST(1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int flags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       ReaderMode(int param2Int1) {
/*  890 */         this.flags = param2Int1;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected final int getFlags() {
/*  899 */         return this.flags;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isExtended() {
/*  908 */         return (this == EXTENDED);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class WithLazyResolution
/*      */       extends Default
/*      */     {
/*      */       public WithLazyResolution(TypePool.CacheProvider param2CacheProvider, ClassFileLocator param2ClassFileLocator, TypePool.Default.ReaderMode param2ReaderMode) {
/*  931 */         this(param2CacheProvider, param2ClassFileLocator, param2ReaderMode, TypePool.Empty.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public WithLazyResolution(TypePool.CacheProvider param2CacheProvider, ClassFileLocator param2ClassFileLocator, TypePool.Default.ReaderMode param2ReaderMode, TypePool param2TypePool) {
/*  943 */         super(param2CacheProvider, param2ClassFileLocator, param2ReaderMode, param2TypePool);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypePool ofSystemLoader() {
/*  953 */         return of(ClassFileLocator.ForClassLoader.ofSystemLoader());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypePool ofPlatformLoader() {
/*  964 */         return of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypePool ofBootLoader() {
/*  974 */         return of(ClassFileLocator.ForClassLoader.ofBootLoader());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypePool of(@MaybeNull ClassLoader param2ClassLoader) {
/*  984 */         return of(ClassFileLocator.ForClassLoader.of(param2ClassLoader));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypePool of(ClassFileLocator param2ClassFileLocator) {
/*  995 */         return new WithLazyResolution(new TypePool.CacheProvider.Simple(), param2ClassFileLocator, TypePool.Default.ReaderMode.FAST);
/*      */       }
/*      */ 
/*      */       
/*      */       protected TypePool.Resolution doDescribe(String param2String) {
/* 1000 */         return new LazyResolution(this, param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected TypePool.Resolution doCache(String param2String, TypePool.Resolution param2Resolution) {
/* 1007 */         return param2Resolution;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected TypePool.Resolution doResolve(String param2String) {
/*      */         TypePool.Resolution resolution;
/* 1018 */         if ((resolution = this.cacheProvider.find(param2String)) == null) {
/* 1019 */           resolution = this.cacheProvider.register(param2String, a(this, param2String));
/*      */         }
/* 1021 */         return resolution;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance(includeSyntheticFields = true)
/*      */       protected class LazyResolution
/*      */         implements TypePool.Resolution
/*      */       {
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected LazyResolution(TypePool.Default.WithLazyResolution this$0, String param3String) {
/* 1041 */           this.name = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isResolved() {
/* 1048 */           return this.a.doResolve(this.name).isResolved();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription resolve() {
/* 1055 */           return (TypeDescription)new TypePool.Default.WithLazyResolution.LazyTypeDescription(this.a, this.name);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.name.equals(((LazyResolution)param3Object).name) ? false : (!!this.a.equals(((LazyResolution)param3Object).a)))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.a.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       protected class LazyTypeDescription
/*      */         extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation
/*      */       {
/*      */         private final String name;
/*      */         
/*      */         protected LazyTypeDescription(TypePool.Default.WithLazyResolution this$0, String param3String) {
/* 1075 */           this.name = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getName() {
/* 1082 */           return this.name;
/*      */         } @Enhance("delegate")
/*      */         protected TypeDescription delegate() {
/*      */           TypeDescription typeDescription1;
/*      */           TypeDescription typeDescription2;
/*      */           LazyTypeDescription lazyTypeDescription;
/* 1088 */           if ((typeDescription1 = (TypeDescription)(((typeDescription2 = this.delegate) != null) ? null : (lazyTypeDescription = this).a.doResolve(lazyTypeDescription.name).resolve())) == null) { typeDescription1 = this.delegate; } else { this.delegate = typeDescription1; }  return typeDescription1;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static interface AnnotationRegistrant
/*      */     {
/*      */       void register(String param2String, AnnotationValue<?, ?> param2AnnotationValue);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void onComplete();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class AbstractBase
/*      */         implements AnnotationRegistrant
/*      */       {
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, AnnotationValue<?, ?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AbstractBase(String param3String) {
/* 1132 */           this.descriptor = param3String;
/* 1133 */           this.values = new HashMap<String, AnnotationValue<?, ?>>();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void register(String param3String, AnnotationValue<?, ?> param3AnnotationValue) {
/* 1140 */           this.values.put(param3String, param3AnnotationValue);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onComplete() {
/* 1147 */           getTokens().add(new TypePool.Default.LazyTypeDescription.AnnotationToken(this.descriptor, this.values));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract List<TypePool.Default.LazyTypeDescription.AnnotationToken> getTokens();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static abstract class ForTypeVariable
/*      */           extends AbstractBase
/*      */         {
/*      */           private final String typePath;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForTypeVariable(String param4String, @MaybeNull TypePath param4TypePath) {
/* 1174 */             super(param4String);
/* 1175 */             this
/*      */               
/* 1177 */               .typePath = (param4TypePath == null) ? "" : param4TypePath.toString();
/*      */           }
/*      */ 
/*      */           
/*      */           protected List<TypePool.Default.LazyTypeDescription.AnnotationToken> getTokens() {
/*      */             Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> map;
/*      */             List<TypePool.Default.LazyTypeDescription.AnnotationToken> list;
/* 1184 */             if ((list = (map = getPathMap()).get(this.typePath)) == null) {
/* 1185 */               list = new ArrayList();
/* 1186 */               map.put(this.typePath, list);
/*      */             } 
/* 1188 */             return list;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected abstract Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> getPathMap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static abstract class WithIndex
/*      */             extends ForTypeVariable
/*      */           {
/*      */             private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected WithIndex(String param5String, @MaybeNull TypePath param5TypePath, int param5Int) {
/* 1216 */               super(param5String, param5TypePath);
/* 1217 */               this.index = param5Int;
/*      */             }
/*      */ 
/*      */             
/*      */             protected Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> getPathMap() {
/*      */               Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> map;
/*      */               Map<Object, Object> map1;
/* 1224 */               if ((map1 = (Map)(map = getIndexedPathMap()).get(Integer.valueOf(this.index))) == null) {
/* 1225 */                 map1 = new HashMap<Object, Object>();
/* 1226 */                 map.put(Integer.valueOf(this.index), map1);
/*      */               } 
/* 1228 */               return (Map)map1;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected abstract Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> getIndexedPathMap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static abstract class DoubleIndexed
/*      */               extends WithIndex
/*      */             {
/*      */               private final int preIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected DoubleIndexed(String param6String, @MaybeNull TypePath param6TypePath, int param6Int1, int param6Int2) {
/* 1257 */                 super(param6String, param6TypePath, param6Int1);
/* 1258 */                 this.preIndex = param6Int2;
/*      */               }
/*      */ 
/*      */               
/*      */               protected Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
/*      */                 Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> map;
/*      */                 Map<Object, Object> map1;
/* 1265 */                 if ((map1 = (Map)(map = getDoubleIndexedPathMap()).get(Integer.valueOf(this.preIndex))) == null) {
/* 1266 */                   map1 = new HashMap<Object, Object>();
/* 1267 */                   map.put(Integer.valueOf(this.preIndex), map1);
/*      */                 } 
/* 1269 */                 return (Map)map1;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected abstract Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap();
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class ForByteCodeElement
/*      */         extends AbstractBase
/*      */       {
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForByteCodeElement(String param3String, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List) {
/* 1300 */           super(param3String);
/* 1301 */           this.annotationTokens = param3List;
/*      */         }
/*      */ 
/*      */         
/*      */         protected List<TypePool.Default.LazyTypeDescription.AnnotationToken> getTokens() {
/* 1306 */           return this.annotationTokens;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class WithIndex
/*      */           extends TypePool.Default.AnnotationRegistrant.AbstractBase
/*      */         {
/*      */           private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected WithIndex(String param4String, int param4Int, Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) {
/* 1332 */             super(param4String);
/* 1333 */             this.index = param4Int;
/* 1334 */             this.annotationTokens = param4Map;
/*      */           }
/*      */ 
/*      */           
/*      */           protected List<TypePool.Default.LazyTypeDescription.AnnotationToken> getTokens() {
/*      */             List<TypePool.Default.LazyTypeDescription.AnnotationToken> list;
/* 1340 */             if ((list = this.annotationTokens.get(Integer.valueOf(this.index))) == null) {
/* 1341 */               list = new ArrayList();
/* 1342 */               this.annotationTokens.put(Integer.valueOf(this.index), list);
/*      */             } 
/* 1344 */             return list;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class ForTypeVariable
/*      */         extends AbstractBase.ForTypeVariable
/*      */       {
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> pathMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForTypeVariable(String param3String, @MaybeNull TypePath param3TypePath, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map) {
/* 1367 */           super(param3String, param3TypePath);
/* 1368 */           this.pathMap = param3Map;
/*      */         }
/*      */ 
/*      */         
/*      */         protected Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> getPathMap() {
/* 1373 */           return this.pathMap;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class WithIndex
/*      */           extends TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex
/*      */         {
/*      */           private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> indexedPathMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected WithIndex(String param4String, @MaybeNull TypePath param4TypePath, int param4Int, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param4Map) {
/* 1398 */             super(param4String, param4TypePath, param4Int);
/* 1399 */             this.indexedPathMap = param4Map;
/*      */           }
/*      */ 
/*      */           
/*      */           protected Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
/* 1404 */             return this.indexedPathMap;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public static class DoubleIndexed
/*      */             extends TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex.DoubleIndexed
/*      */           {
/*      */             private final Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> doubleIndexedPathMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected DoubleIndexed(String param5String, @MaybeNull TypePath param5TypePath, int param5Int1, int param5Int2, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param5Map) {
/* 1431 */               super(param5String, param5TypePath, param5Int1, param5Int2);
/* 1432 */               this.doubleIndexedPathMap = param5Map;
/*      */             }
/*      */ 
/*      */             
/*      */             protected Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap() {
/* 1437 */               return this.doubleIndexedPathMap;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static interface ComponentTypeLocator
/*      */     {
/*      */       TypePool.AbstractBase.ComponentTypeReference bind(String param2String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Illegal
/*      */         implements ComponentTypeLocator
/*      */       {
/* 1466 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypePool.AbstractBase.ComponentTypeReference bind(String param3String) {
/* 1472 */           throw new IllegalStateException("Unexpected lookup of component type for " + param3String);
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForAnnotationProperty
/*      */         implements ComponentTypeLocator
/*      */       {
/*      */         private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String annotationName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForAnnotationProperty(TypePool param3TypePool, String param3String) {
/* 1500 */           this.typePool = param3TypePool;
/* 1501 */           this.annotationName = param3String.substring(1, param3String.length() - 1).replace('/', '.');
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypePool.AbstractBase.ComponentTypeReference bind(String param3String) {
/* 1508 */           return new Bound(this, param3String);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationName.equals(((ForAnnotationProperty)param3Object).annotationName) ? false : (!!this.typePool.equals(((ForAnnotationProperty)param3Object).typePool)))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.typePool.hashCode()) * 31 + this.annotationName.hashCode();
/*      */         }
/*      */ 
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class Bound
/*      */           implements TypePool.AbstractBase.ComponentTypeReference
/*      */         {
/*      */           private final String name;
/*      */           
/*      */           protected Bound(TypePool.Default.ComponentTypeLocator.ForAnnotationProperty this$0, String param4String) {
/* 1529 */             this.name = param4String;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public String resolve() {
/*      */             TypeDescription typeDescription;
/* 1545 */             return ((typeDescription = ((MethodDescription.InDefinedShape)((MethodList)TypePool.Default.ComponentTypeLocator.ForAnnotationProperty.b(this.a).describe(TypePool.Default.ComponentTypeLocator.ForAnnotationProperty.a(this.a)).resolve().getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly()).getReturnType().asErasure().getComponentType()) == null) ? NO_ARRAY : typeDescription
/*      */               
/* 1547 */               .getName();
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.name.equals(((Bound)param4Object).name) ? false : (!!this.a.equals(((Bound)param4Object).a)))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class ForArrayType
/*      */         implements TypePool.AbstractBase.ComponentTypeReference, ComponentTypeLocator
/*      */       {
/*      */         private final String componentType;
/*      */         
/*      */         public ForArrayType(String param3String) {
/* 1569 */           param3String = Type.getMethodType(param3String).getReturnType().getClassName();
/* 1570 */           this.componentType = param3String.substring(0, param3String.length() - 2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypePool.AbstractBase.ComponentTypeReference bind(String param3String) {
/* 1577 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String resolve() {
/* 1584 */           return this.componentType;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.componentType.equals(((ForArrayType)param3Object).componentType))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.componentType.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected static interface GenericTypeRegistrant
/*      */     {
/*      */       void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param2GenericTypeToken);
/*      */ 
/*      */       
/*      */       public static class RejectingSignatureVisitor
/*      */         extends SignatureVisitor
/*      */       {
/*      */         private static final String MESSAGE = "Unexpected token in generic signature";
/*      */ 
/*      */         
/*      */         public RejectingSignatureVisitor() {
/* 1615 */           super(OpenedClassReader.ASM_API);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitFormalTypeParameter(String param3String) {
/* 1622 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitClassBound() {
/* 1629 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitInterfaceBound() {
/* 1636 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitSuperclass() {
/* 1643 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitInterface() {
/* 1650 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitParameterType() {
/* 1657 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitReturnType() {
/* 1664 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitExceptionType() {
/* 1671 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitBaseType(char param3Char) {
/* 1678 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitTypeVariable(String param3String) {
/* 1685 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitArrayType() {
/* 1692 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitClassType(String param3String) {
/* 1699 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitInnerClassType(String param3String) {
/* 1706 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitTypeArgument() {
/* 1713 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitTypeArgument(char param3Char) {
/* 1720 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitEnd() {
/* 1727 */           throw new IllegalStateException("Unexpected token in generic signature");
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class ParameterBag
/*      */     {
/*      */       private final Type[] parameterType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Integer, String> parameterRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ParameterBag(Type[] param2ArrayOfType) {
/* 1755 */         this.parameterType = param2ArrayOfType;
/* 1756 */         this.parameterRegistry = new HashMap<Integer, String>();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected void register(int param2Int, String param2String) {
/* 1766 */         this.parameterRegistry.put(Integer.valueOf(param2Int), param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected List<TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken> resolve(boolean param2Boolean) {
/* 1776 */         ArrayList<TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken> arrayList = new ArrayList(this.parameterType.length);
/*      */ 
/*      */         
/* 1779 */         int i = param2Boolean ? StackSize.ZERO.getSize() : StackSize.SINGLE.getSize(); Type[] arrayOfType; int j; byte b;
/* 1780 */         for (j = (arrayOfType = this.parameterType).length, b = 0; b < j; ) { Type type = arrayOfType[b];
/* 1781 */           String str = this.parameterRegistry.get(Integer.valueOf(i));
/* 1782 */           arrayList.add((str == null) ? new TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken() : new TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken(str));
/*      */ 
/*      */           
/* 1785 */           i += type.getSize(); b++; }
/*      */         
/* 1787 */         return arrayList;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class GenericTypeExtractor
/*      */       extends GenericTypeRegistrant.RejectingSignatureVisitor
/*      */       implements GenericTypeRegistrant
/*      */     {
/*      */       private final TypePool.Default.GenericTypeRegistrant genericTypeRegistrant;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @UnknownNull
/*      */       private IncompleteToken incompleteToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GenericTypeExtractor(TypePool.Default.GenericTypeRegistrant param2GenericTypeRegistrant) {
/* 1813 */         this.genericTypeRegistrant = param2GenericTypeRegistrant;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void visitBaseType(char param2Char) {
/* 1820 */         this.genericTypeRegistrant.register(TypePool.Default.LazyTypeDescription.GenericTypeToken.ForPrimitiveType.of(param2Char));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void visitTypeVariable(String param2String) {
/* 1827 */         this.genericTypeRegistrant.register(new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForTypeVariable(param2String));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public SignatureVisitor visitArrayType() {
/* 1834 */         return new GenericTypeExtractor(this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param2GenericTypeToken) {
/* 1841 */         this.genericTypeRegistrant.register(new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForGenericArray(param2GenericTypeToken));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void visitClassType(String param2String) {
/* 1848 */         this.incompleteToken = new IncompleteToken.ForTopLevelType(param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void visitInnerClassType(String param2String) {
/* 1855 */         this.incompleteToken = new IncompleteToken.ForInnerClass(param2String, this.incompleteToken);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void visitTypeArgument() {
/* 1862 */         this.incompleteToken.appendPlaceholder();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public SignatureVisitor visitTypeArgument(char param2Char) {
/* 1869 */         switch (param2Char) {
/*      */           case '-':
/* 1871 */             return this.incompleteToken.appendLowerBound();
/*      */           case '+':
/* 1873 */             return this.incompleteToken.appendUpperBound();
/*      */           case '=':
/* 1875 */             return this.incompleteToken.appendDirectBound();
/*      */         } 
/* 1877 */         throw new IllegalArgumentException("Unknown wildcard: " + param2Char);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void visitEnd() {
/* 1885 */         this.genericTypeRegistrant.register(this.incompleteToken.toToken());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForTopLevelType
/*      */         extends IncompleteToken.AbstractBase
/*      */       {
/*      */         private final String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForTopLevelType(String param3String) {
/* 2042 */           this.internalName = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypePool.Default.LazyTypeDescription.GenericTypeToken toToken() {
/* 2049 */           return (TypePool.Default.LazyTypeDescription.GenericTypeToken)(isParameterized() ? new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForParameterizedType(
/* 2050 */               getName(), this.parameters) : new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForRawType(
/* 2051 */               getName()));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isParameterized() {
/* 2058 */           return !this.parameters.isEmpty();
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public String getName()
/*      */         {
/* 2065 */           return this.internalName.replace('/', '.'); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.internalName.equals(((ForTopLevelType)param3Object).internalName)))); } public int hashCode() { return getClass().hashCode() * 31 + this.internalName.hashCode(); } } protected static interface IncompleteToken { SignatureVisitor appendLowerBound(); SignatureVisitor appendUpperBound(); SignatureVisitor appendDirectBound(); void appendPlaceholder(); boolean isParameterized(); String getName(); TypePool.Default.LazyTypeDescription.GenericTypeToken toToken(); public static abstract class AbstractBase implements IncompleteToken { protected final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameters = new ArrayList<TypePool.Default.LazyTypeDescription.GenericTypeToken>(); public SignatureVisitor appendDirectBound() { return new TypePool.Default.GenericTypeExtractor(new ForDirectBound(this)); } public SignatureVisitor appendUpperBound() { return new TypePool.Default.GenericTypeExtractor(new ForUpperBound(this)); } public SignatureVisitor appendLowerBound() { return new TypePool.Default.GenericTypeExtractor(new ForLowerBound(this)); } public void appendPlaceholder() { this.parameters.add(TypePool.Default.LazyTypeDescription.GenericTypeToken.ForUnboundWildcard.INSTANCE); } protected class ForDirectBound implements TypePool.Default.GenericTypeRegistrant { protected ForDirectBound(TypePool.Default.GenericTypeExtractor.IncompleteToken.AbstractBase this$0) {} public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) { this.a.parameters.add(param5GenericTypeToken); } } protected class ForUpperBound implements TypePool.Default.GenericTypeRegistrant { protected ForUpperBound(TypePool.Default.GenericTypeExtractor.IncompleteToken.AbstractBase this$0) {} public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) { this.a.parameters.add(new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForUpperBoundWildcard(param5GenericTypeToken)); } } protected class ForLowerBound implements TypePool.Default.GenericTypeRegistrant { protected ForLowerBound(TypePool.Default.GenericTypeExtractor.IncompleteToken.AbstractBase this$0) {} public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) { this.a.parameters.add(new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForLowerBoundWildcard(param5GenericTypeToken)); } } } @Enhance public static class ForTopLevelType extends AbstractBase { private final String internalName; public ForTopLevelType(String param4String) { this.internalName = param4String; } public TypePool.Default.LazyTypeDescription.GenericTypeToken toToken() { return (TypePool.Default.LazyTypeDescription.GenericTypeToken)(isParameterized() ? new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForParameterizedType(getName(), this.parameters) : new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForRawType(getName())); } public boolean isParameterized() { return !this.parameters.isEmpty(); } public String getName() { return this.internalName.replace('/', '.'); }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.internalName.equals(((ForTopLevelType)param4Object).internalName))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.internalName.hashCode();
/*      */           } }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForInnerClass
/*      */           extends AbstractBase
/*      */         {
/*      */           private static final char INNER_CLASS_SEPARATOR = '$';
/*      */ 
/*      */           
/*      */           private final String internalName;
/*      */ 
/*      */           
/*      */           private final TypePool.Default.GenericTypeExtractor.IncompleteToken outerTypeToken;
/*      */ 
/*      */           
/*      */           public ForInnerClass(String param4String, TypePool.Default.GenericTypeExtractor.IncompleteToken param4IncompleteToken) {
/* 2097 */             this.internalName = param4String;
/* 2098 */             this.outerTypeToken = param4IncompleteToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypePool.Default.LazyTypeDescription.GenericTypeToken toToken() {
/* 2105 */             return (TypePool.Default.LazyTypeDescription.GenericTypeToken)((isParameterized() || this.outerTypeToken.isParameterized()) ? new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForParameterizedType.Nested(
/* 2106 */                 getName(), this.parameters, this.outerTypeToken.toToken()) : new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForRawType(
/* 2107 */                 getName()));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isParameterized() {
/* 2114 */             return (!this.parameters.isEmpty() || !this.outerTypeToken.isParameterized());
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public String getName()
/*      */           {
/* 2121 */             return this.outerTypeToken.getName() + '$' + this.internalName.replace('/', '.'); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.internalName.equals(((ForInnerClass)param4Object).internalName) ? false : (!!this.outerTypeToken.equals(((ForInnerClass)param4Object).outerTypeToken))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.internalName.hashCode()) * 31 + this.outerTypeToken.hashCode(); } } } @Enhance public static class ForInnerClass extends IncompleteToken.AbstractBase { private static final char INNER_CLASS_SEPARATOR = '$'; private final String internalName; private final TypePool.Default.GenericTypeExtractor.IncompleteToken outerTypeToken; public ForInnerClass(String param3String, TypePool.Default.GenericTypeExtractor.IncompleteToken param3IncompleteToken) { this.internalName = param3String; this.outerTypeToken = param3IncompleteToken; } public TypePool.Default.LazyTypeDescription.GenericTypeToken toToken() { return (TypePool.Default.LazyTypeDescription.GenericTypeToken)((isParameterized() || this.outerTypeToken.isParameterized()) ? new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForParameterizedType.Nested(getName(), this.parameters, this.outerTypeToken.toToken()) : new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForRawType(getName())); } public boolean isParameterized() { return (!this.parameters.isEmpty() || !this.outerTypeToken.isParameterized()); } public String getName() { return this.outerTypeToken.getName() + '$' + this.internalName.replace('/', '.'); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.internalName.equals(((ForInnerClass)param3Object).internalName) ? false : (!!this.outerTypeToken.equals(((ForInnerClass)param3Object).outerTypeToken)))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.internalName.hashCode()) * 31 + this.outerTypeToken.hashCode();
/*      */         } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static abstract class ForSignature<T extends TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution>
/*      */         extends TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor
/*      */         implements TypePool.Default.GenericTypeRegistrant
/*      */       {
/* 2156 */         protected final List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens = new ArrayList<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable>();
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         protected String currentTypeParameter;
/*      */ 
/*      */         
/*      */         @UnknownNull
/*      */         protected List<TypePool.Default.LazyTypeDescription.GenericTypeToken> currentBounds;
/*      */ 
/*      */         
/*      */         protected static <S extends TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution> S extract(String param3String, ForSignature<S> param3ForSignature) {
/*      */           SignatureReader signatureReader;
/* 2169 */           (signatureReader = new SignatureReader(param3String)).accept(param3ForSignature);
/* 2170 */           return param3ForSignature.resolve();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitFormalTypeParameter(String param3String) {
/* 2177 */           collectTypeParameter();
/* 2178 */           this.currentTypeParameter = param3String;
/* 2179 */           this.currentBounds = new ArrayList<TypePool.Default.LazyTypeDescription.GenericTypeToken>();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitClassBound() {
/* 2186 */           return new TypePool.Default.GenericTypeExtractor(this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public SignatureVisitor visitInterfaceBound() {
/* 2193 */           return new TypePool.Default.GenericTypeExtractor(this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param3GenericTypeToken) {
/* 2200 */           if (this.currentBounds == null) {
/* 2201 */             throw new IllegalStateException("Did not expect " + param3GenericTypeToken + " before finding formal parameter");
/*      */           }
/* 2203 */           this.currentBounds.add(param3GenericTypeToken);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected void collectTypeParameter() {
/* 2210 */           if (this.currentTypeParameter != null) {
/* 2211 */             this.typeVariableTokens.add(new TypePool.Default.LazyTypeDescription.GenericTypeToken.ForTypeVariable.Formal(this.currentTypeParameter, this.currentBounds));
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public abstract T resolve();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class OfType
/*      */           extends ForSignature<TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType>
/*      */         {
/* 2242 */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> interfaceTypeTokens = new ArrayList<TypePool.Default.LazyTypeDescription.GenericTypeToken>();
/*      */ 
/*      */ 
/*      */           
/*      */           @UnknownNull
/*      */           private TypePool.Default.LazyTypeDescription.GenericTypeToken superClassToken;
/*      */ 
/*      */ 
/*      */           
/*      */           public static TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType extract(@MaybeNull String param4String) {
/*      */             try {
/* 2253 */               return (param4String == null) ? TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : 
/*      */                 
/* 2255 */                 TypePool.Default.GenericTypeExtractor.ForSignature.<TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType>extract(param4String, new OfType());
/* 2256 */             } catch (RuntimeException runtimeException) {
/* 2257 */               return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public SignatureVisitor visitSuperclass() {
/* 2265 */             collectTypeParameter();
/* 2266 */             return new TypePool.Default.GenericTypeExtractor(new SuperClassRegistrant(this));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public SignatureVisitor visitInterface() {
/* 2273 */             return new TypePool.Default.GenericTypeExtractor(new InterfaceTypeRegistrant(this));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType resolve() {
/* 2280 */             return new TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType.Tokenized(this.superClassToken, this.interfaceTypeTokens, this.typeVariableTokens);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class SuperClassRegistrant
/*      */             implements TypePool.Default.GenericTypeRegistrant
/*      */           {
/*      */             protected SuperClassRegistrant(TypePool.Default.GenericTypeExtractor.ForSignature.OfType this$0) {}
/*      */ 
/*      */             
/*      */             public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 2293 */               TypePool.Default.GenericTypeExtractor.ForSignature.OfType.a(this.a, param5GenericTypeToken);
/*      */             }
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.a.equals(((SuperClassRegistrant)param5Object).a))));
/*      */             }
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.a.hashCode();
/*      */             } }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class InterfaceTypeRegistrant implements TypePool.Default.GenericTypeRegistrant { protected InterfaceTypeRegistrant(TypePool.Default.GenericTypeExtractor.ForSignature.OfType this$0) {}
/*      */             
/*      */             public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 2307 */               TypePool.Default.GenericTypeExtractor.ForSignature.OfType.a(this.a).add(param5GenericTypeToken);
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.a.equals(((InterfaceTypeRegistrant)param5Object).a))));
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.a.hashCode();
/*      */             } }
/*      */         
/*      */         }
/*      */ 
/*      */         
/*      */         protected static class OfField
/*      */           implements TypePool.Default.GenericTypeRegistrant
/*      */         {
/*      */           @UnknownNull
/*      */           private TypePool.Default.LazyTypeDescription.GenericTypeToken fieldTypeToken;
/*      */           
/*      */           public static TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField extract(@MaybeNull String param4String) {
/* 2330 */             if (param4String == null) {
/* 2331 */               return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
/*      */             }
/* 2333 */             SignatureReader signatureReader = new SignatureReader(param4String);
/* 2334 */             OfField ofField = new OfField();
/*      */             try {
/* 2336 */               signatureReader.acceptType(new TypePool.Default.GenericTypeExtractor(ofField));
/* 2337 */               return ofField.resolve();
/* 2338 */             } catch (RuntimeException runtimeException) {
/* 2339 */               return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param4GenericTypeToken) {
/* 2348 */             this.fieldTypeToken = param4GenericTypeToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField resolve() {
/* 2357 */             return new TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField.Tokenized(this.fieldTypeToken);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class OfMethod
/*      */           extends ForSignature<TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod>
/*      */         {
/* 2386 */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameterTypeTokens = new ArrayList<TypePool.Default.LazyTypeDescription.GenericTypeToken>();
/* 2387 */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> exceptionTypeTokens = new ArrayList<TypePool.Default.LazyTypeDescription.GenericTypeToken>();
/*      */ 
/*      */ 
/*      */           
/*      */           @UnknownNull
/*      */           private TypePool.Default.LazyTypeDescription.GenericTypeToken returnTypeToken;
/*      */ 
/*      */ 
/*      */           
/*      */           public static TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod extract(@MaybeNull String param4String) {
/*      */             try {
/* 2398 */               return (param4String == null) ? TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : 
/*      */                 
/* 2400 */                 TypePool.Default.GenericTypeExtractor.ForSignature.<TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod>extract(param4String, new OfMethod());
/* 2401 */             } catch (RuntimeException runtimeException) {
/* 2402 */               return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public SignatureVisitor visitParameterType() {
/* 2410 */             return new TypePool.Default.GenericTypeExtractor(new ParameterTypeRegistrant(this));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public SignatureVisitor visitReturnType() {
/* 2417 */             collectTypeParameter();
/* 2418 */             return new TypePool.Default.GenericTypeExtractor(new ReturnTypeTypeRegistrant(this));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public SignatureVisitor visitExceptionType() {
/* 2425 */             return new TypePool.Default.GenericTypeExtractor(new ExceptionTypeRegistrant(this));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod resolve() {
/* 2432 */             return new TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod.Tokenized(this.returnTypeToken, this.parameterTypeTokens, this.exceptionTypeTokens, this.typeVariableTokens);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class ParameterTypeRegistrant
/*      */             implements TypePool.Default.GenericTypeRegistrant
/*      */           {
/*      */             protected ParameterTypeRegistrant(TypePool.Default.GenericTypeExtractor.ForSignature.OfMethod this$0) {}
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 2448 */               TypePool.Default.GenericTypeExtractor.ForSignature.OfMethod.a(this.a).add(param5GenericTypeToken);
/*      */             }
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.a.equals(((ParameterTypeRegistrant)param5Object).a))));
/*      */             }
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.a.hashCode();
/*      */             } }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class ReturnTypeTypeRegistrant implements TypePool.Default.GenericTypeRegistrant { protected ReturnTypeTypeRegistrant(TypePool.Default.GenericTypeExtractor.ForSignature.OfMethod this$0) {}
/*      */             
/*      */             public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 2462 */               TypePool.Default.GenericTypeExtractor.ForSignature.OfMethod.a(this.a, param5GenericTypeToken);
/*      */             }
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.a.equals(((ReturnTypeTypeRegistrant)param5Object).a))));
/*      */             }
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.a.hashCode();
/*      */             } }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class ExceptionTypeRegistrant implements TypePool.Default.GenericTypeRegistrant { protected ExceptionTypeRegistrant(TypePool.Default.GenericTypeExtractor.ForSignature.OfMethod this$0) {}
/*      */             
/*      */             public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 2476 */               TypePool.Default.GenericTypeExtractor.ForSignature.OfMethod.b(this.a).add(param5GenericTypeToken);
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.a.equals(((ExceptionTypeRegistrant)param5Object).a))));
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.a.hashCode();
/*      */             } }
/*      */         
/*      */         }
/*      */ 
/*      */         
/*      */         protected static class OfRecordComponent
/*      */           implements TypePool.Default.GenericTypeRegistrant
/*      */         {
/*      */           @UnknownNull
/*      */           private TypePool.Default.LazyTypeDescription.GenericTypeToken recordComponentType;
/*      */           
/*      */           public static TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent extract(@MaybeNull String param4String) {
/* 2499 */             if (param4String == null) {
/* 2500 */               return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
/*      */             }
/* 2502 */             SignatureReader signatureReader = new SignatureReader(param4String);
/* 2503 */             OfRecordComponent ofRecordComponent = new OfRecordComponent();
/*      */             try {
/* 2505 */               signatureReader.acceptType(new TypePool.Default.GenericTypeExtractor(ofRecordComponent));
/* 2506 */               return ofRecordComponent.resolve();
/* 2507 */             } catch (RuntimeException runtimeException) {
/* 2508 */               return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void register(TypePool.Default.LazyTypeDescription.GenericTypeToken param4GenericTypeToken) {
/* 2517 */             this.recordComponentType = param4GenericTypeToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent resolve() {
/* 2526 */             return new TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent.Tokenized(this.recordComponentType);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class LazyTypeDescription
/*      */       extends TypeDescription.AbstractBase.OfSimpleType
/*      */     {
/*      */       @AlwaysNull
/* 2542 */       private static final String NO_TYPE = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int actualModifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private final String superClassDescriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final GenericTypeToken.Resolution.ForType signatureResolution;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<String> interfaceTypeDescriptors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeContainment typeContainment;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private final String declaringTypeName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<String> declaredTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean anonymousType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private final String nestHost;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<String> nestMembers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<String, List<AnnotationToken>> superClassAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Integer, Map<String, List<AnnotationToken>>> interfaceAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundsAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<FieldToken> fieldTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<MethodToken> methodTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<RecordComponentToken> recordComponentTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<String> permittedSubclasses;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final ClassFileVersion classFileVersion;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected LazyTypeDescription(TypePool param2TypePool, int param2Int1, int param2Int2, String param2String1, @MaybeNull String param2String2, @MaybeNull String[] param2ArrayOfString, @MaybeNull String param2String3, TypeContainment param2TypeContainment, @MaybeNull String param2String4, List<String> param2List1, boolean param2Boolean, @MaybeNull String param2String5, List<String> param2List2, Map<String, List<AnnotationToken>> param2Map, Map<Integer, Map<String, List<AnnotationToken>>> param2Map1, Map<Integer, Map<String, List<AnnotationToken>>> param2Map2, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> param2Map3, List<AnnotationToken> param2List, List<FieldToken> param2List3, List<MethodToken> param2List4, List<RecordComponentToken> param2List5, List<String> param2List6, ClassFileVersion param2ClassFileVersion) {
/* 2719 */         this.typePool = param2TypePool;
/* 2720 */         this.actualModifiers = param2Int1 & 0xFFFFFFDF;
/* 2721 */         this.modifiers = param2Int2 & 0xFFFDFFDF;
/* 2722 */         this.name = Type.getObjectType(param2String1).getClassName();
/* 2723 */         this
/*      */           
/* 2725 */           .superClassDescriptor = (param2String2 == null) ? NO_TYPE : Type.getObjectType(param2String2).getDescriptor();
/* 2726 */         this.genericSignature = param2String3;
/* 2727 */         this
/*      */           
/* 2729 */           .signatureResolution = RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : TypePool.Default.GenericTypeExtractor.ForSignature.OfType.extract(param2String3);
/* 2730 */         if (param2ArrayOfString == null) {
/* 2731 */           this.interfaceTypeDescriptors = Collections.emptyList();
/*      */         } else {
/* 2733 */           this.interfaceTypeDescriptors = new ArrayList<String>(param2ArrayOfString.length); String[] arrayOfString;
/* 2734 */           for (param2Int1 = (arrayOfString = param2ArrayOfString).length, param2Int2 = 0; param2Int2 < param2Int1; ) { param2String1 = arrayOfString[param2Int2];
/* 2735 */             this.interfaceTypeDescriptors.add(Type.getObjectType(param2String1).getDescriptor()); param2Int2++; }
/*      */         
/*      */         } 
/* 2738 */         this.typeContainment = param2TypeContainment;
/* 2739 */         this
/*      */           
/* 2741 */           .declaringTypeName = (param2String4 == null) ? NO_TYPE : param2String4.replace('/', '.');
/* 2742 */         this.declaredTypes = param2List1;
/* 2743 */         this.anonymousType = param2Boolean;
/* 2744 */         this
/*      */           
/* 2746 */           .nestHost = (param2String5 == null) ? NO_TYPE : Type.getObjectType(param2String5).getClassName();
/* 2747 */         this.nestMembers = new ArrayList<String>(param2List2.size());
/* 2748 */         for (String str : param2List2) {
/* 2749 */           this.nestMembers.add(Type.getObjectType(str).getClassName());
/*      */         }
/* 2751 */         this.superClassAnnotationTokens = param2Map;
/* 2752 */         this.interfaceAnnotationTokens = param2Map1;
/* 2753 */         this.typeVariableAnnotationTokens = param2Map2;
/* 2754 */         this.typeVariableBoundsAnnotationTokens = param2Map3;
/* 2755 */         this.annotationTokens = param2List;
/* 2756 */         this.fieldTokens = param2List3;
/* 2757 */         this.methodTokens = param2List4;
/* 2758 */         this.recordComponentTokens = param2List5;
/* 2759 */         this.permittedSubclasses = new ArrayList<String>(param2List6.size());
/* 2760 */         for (String str : param2List6) {
/* 2761 */           this.permittedSubclasses.add(Type.getObjectType(str).getDescriptor());
/*      */         }
/* 2763 */         this.classFileVersion = param2ClassFileVersion;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public TypeDescription.Generic getSuperClass() {
/* 2771 */         return (this.superClassDescriptor == null || isInterface()) ? TypeDescription.Generic.UNDEFINED : this.signatureResolution
/*      */           
/* 2773 */           .resolveSuperClass(this.superClassDescriptor, this.typePool, this.superClassAnnotationTokens, (TypeDescription)this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic getInterfaces() {
/* 2780 */         return this.signatureResolution.resolveInterfaceTypes(this.interfaceTypeDescriptors, this.typePool, this.interfaceAnnotationTokens, (TypeDescription)this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public MethodDescription.InDefinedShape getEnclosingMethod() {
/* 2788 */         return this.typeContainment.getEnclosingMethod(this.typePool);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public TypeDescription getEnclosingType() {
/* 2796 */         return this.typeContainment.getEnclosingType(this.typePool);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList getDeclaredTypes() {
/* 2803 */         return (TypeList)new LazyTypeList(this.typePool, this.declaredTypes);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isAnonymousType() {
/* 2810 */         return this.anonymousType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isLocalType() {
/* 2817 */         return (!this.anonymousType && this.typeContainment.isLocalType());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/* 2824 */         return (FieldList<FieldDescription.InDefinedShape>)new FieldTokenList(this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/* 2831 */         return (MethodList<MethodDescription.InDefinedShape>)new MethodTokenList(this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public PackageDescription getPackage() {
/*      */         String str;
/* 2840 */         int i = (str = getName()).lastIndexOf('.');
/* 2841 */         return (PackageDescription)new LazyPackageDescription(this.typePool, (i == -1) ? "" : str
/*      */             
/* 2843 */             .substring(0, i), (byte)0);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getName() {
/* 2850 */         return this.name;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public TypeDescription getDeclaringType() {
/* 2858 */         return (this.declaringTypeName == null) ? TypeDescription.UNDEFINED : this.typePool
/*      */           
/* 2860 */           .describe(this.declaringTypeName).resolve();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getModifiers() {
/* 2867 */         return this.modifiers;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getActualModifiers(boolean param2Boolean) {
/* 2874 */         return param2Boolean ? (this.actualModifiers | 0x20) : this.actualModifiers;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getNestHost() {
/* 2881 */         return (TypeDescription)((this.nestHost == null) ? this : this.typePool
/*      */           
/* 2883 */           .describe(this.nestHost).resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList getNestMembers() {
/* 2890 */         return (TypeList)((this.nestHost == null) ? new LazyNestMemberList((TypeDescription)this, this.typePool, this.nestMembers) : this.typePool
/*      */           
/* 2892 */           .describe(this.nestHost).resolve().getNestMembers());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationList getDeclaredAnnotations() {
/* 2899 */         return LazyAnnotationDescription.asList(this.typePool, this.annotationTokens);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic getTypeVariables() {
/* 2906 */         return this.signatureResolution.resolveTypeVariables(this.typePool, (TypeVariableSource)this, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens);
/*      */       }
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public String getGenericSignature() {
/* 2912 */         return this.genericSignature;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/* 2919 */         return (RecordComponentList<RecordComponentDescription.InDefinedShape>)new RecordComponentTokenList(this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isRecord() {
/* 2926 */         return ((this.actualModifiers & 0x10000) != 0 && JavaType.RECORD.getTypeStub().getDescriptor().equals(this.superClassDescriptor));
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isSealed() {
/* 2931 */         return !this.permittedSubclasses.isEmpty();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList getPermittedSubtypes() {
/* 2938 */         return (TypeList)new LazyTypeList(this.typePool, this.permittedSubclasses);
/*      */       }
/*      */ 
/*      */       
/*      */       public ClassFileVersion getClassFileVersion() {
/* 2943 */         return this.classFileVersion;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected class FieldTokenList
/*      */         extends FieldList.AbstractBase<FieldDescription.InDefinedShape>
/*      */       {
/*      */         protected FieldTokenList(TypePool.Default.LazyTypeDescription this$0) {}
/*      */ 
/*      */         
/*      */         public FieldDescription.InDefinedShape get(int param3Int) {
/* 2955 */           return (FieldDescription.InDefinedShape)TypePool.Default.LazyTypeDescription.FieldToken.a(TypePool.Default.LazyTypeDescription.a(this.a).get(param3Int), this.a);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/* 2962 */           return TypePool.Default.LazyTypeDescription.a(this.a).size();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected class MethodTokenList
/*      */         extends MethodList.AbstractBase<MethodDescription.InDefinedShape>
/*      */       {
/*      */         protected MethodTokenList(TypePool.Default.LazyTypeDescription this$0) {}
/*      */ 
/*      */         
/*      */         public MethodDescription.InDefinedShape get(int param3Int) {
/* 2975 */           return TypePool.Default.LazyTypeDescription.MethodToken.a(TypePool.Default.LazyTypeDescription.b(this.a).get(param3Int), this.a);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/* 2982 */           return TypePool.Default.LazyTypeDescription.b(this.a).size();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected class RecordComponentTokenList
/*      */         extends RecordComponentList.AbstractBase<RecordComponentDescription.InDefinedShape>
/*      */       {
/*      */         protected RecordComponentTokenList(TypePool.Default.LazyTypeDescription this$0) {}
/*      */ 
/*      */         
/*      */         public RecordComponentDescription.InDefinedShape get(int param3Int) {
/* 2995 */           return TypePool.Default.LazyTypeDescription.RecordComponentToken.a(TypePool.Default.LazyTypeDescription.c(this.a).get(param3Int), this.a);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/* 3002 */           return TypePool.Default.LazyTypeDescription.c(this.a).size();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static interface TypeContainment
/*      */       {
/*      */         @MaybeNull
/*      */         MethodDescription.InDefinedShape getEnclosingMethod(TypePool param3TypePool);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         TypeDescription getEnclosingType(TypePool param3TypePool);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         boolean isSelfContained();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         boolean isLocalType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public enum SelfContained
/*      */           implements TypeContainment
/*      */         {
/* 3052 */           INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public final MethodDescription.InDefinedShape getEnclosingMethod(TypePool param4TypePool) {
/* 3059 */             return MethodDescription.UNDEFINED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public final TypeDescription getEnclosingType(TypePool param4TypePool) {
/* 3067 */             return TypeDescription.UNDEFINED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final boolean isSelfContained() {
/* 3074 */             return true;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final boolean isLocalType() {
/* 3081 */             return false;
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class WithinType
/*      */           implements TypeContainment
/*      */         {
/*      */           private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final boolean localType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected WithinType(String param4String, boolean param4Boolean) {
/* 3108 */             this.name = param4String.replace('/', '.');
/* 3109 */             this.localType = param4Boolean;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public MethodDescription.InDefinedShape getEnclosingMethod(TypePool param4TypePool) {
/* 3117 */             return MethodDescription.UNDEFINED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription getEnclosingType(TypePool param4TypePool) {
/* 3124 */             return param4TypePool.describe(this.name).resolve();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isSelfContained() {
/* 3131 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isLocalType() {
/* 3138 */             return this.localType;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.localType != ((WithinType)param4Object).localType) ? false : (!!this.name.equals(((WithinType)param4Object).name)))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.localType;
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class WithinMethod
/*      */           implements TypeContainment
/*      */         {
/*      */           private final String name;
/*      */ 
/*      */           
/*      */           private final String methodName;
/*      */ 
/*      */           
/*      */           private final String methodDescriptor;
/*      */ 
/*      */ 
/*      */           
/*      */           protected WithinMethod(String param4String1, String param4String2, String param4String3) {
/* 3171 */             this.name = param4String1.replace('/', '.');
/* 3172 */             this.methodName = param4String2;
/* 3173 */             this.methodDescriptor = param4String3;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription.InDefinedShape getEnclosingMethod(TypePool param4TypePool) {
/*      */             TypeDescription typeDescription;
/* 3181 */             if ((typeDescription = getEnclosingType(param4TypePool)) == null) {
/* 3182 */               throw new IllegalStateException("Could not resolve enclosing type " + this.name);
/*      */             }
/*      */             
/*      */             MethodList methodList;
/* 3186 */             if ((methodList = (MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.hasMethodName(this.methodName).and((ElementMatcher)ElementMatchers.hasDescriptor(this.methodDescriptor)))).isEmpty()) {
/* 3187 */               throw new IllegalStateException(this.methodName + this.methodDescriptor + " not declared by " + typeDescription);
/*      */             }
/* 3189 */             return (MethodDescription.InDefinedShape)methodList.getOnly();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription getEnclosingType(TypePool param4TypePool) {
/* 3196 */             return param4TypePool.describe(this.name).resolve();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isSelfContained() {
/* 3203 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isLocalType() {
/* 3210 */             return true;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.name.equals(((WithinMethod)param4Object).name) ? false : (!this.methodName.equals(((WithinMethod)param4Object).methodName) ? false : (!!this.methodDescriptor.equals(((WithinMethod)param4Object).methodDescriptor))))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return ((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.methodName.hashCode()) * 31 + this.methodDescriptor.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Raw
/*      */         implements GenericTypeToken.Resolution.ForField, GenericTypeToken.Resolution.ForMethod, GenericTypeToken.Resolution.ForRecordComponent, GenericTypeToken.Resolution.ForType
/*      */       {
/* 3616 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeDescription.Generic resolveSuperClass(String param3String, TypePool param3TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, TypeDescription param3TypeDescription) {
/* 3625 */           return RawAnnotatedType.of(param3TypePool, param3Map, param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeList.Generic resolveInterfaceTypes(List<String> param3List, TypePool param3TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map, TypeDescription param3TypeDescription) {
/* 3635 */           return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param3TypePool, param3Map, param3List);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeList.Generic resolveTypeVariables(TypePool param3TypePool, TypeVariableSource param3TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param3Map1) {
/* 3645 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeDescription.Generic resolveFieldType(String param3String, TypePool param3TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, FieldDescription.InDefinedShape param3InDefinedShape) {
/* 3655 */           return RawAnnotatedType.of(param3TypePool, param3Map, param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeDescription.Generic resolveReturnType(String param3String, TypePool param3TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, MethodDescription.InDefinedShape param3InDefinedShape) {
/* 3665 */           return RawAnnotatedType.of(param3TypePool, param3Map, param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeList.Generic resolveParameterTypes(List<String> param3List, TypePool param3TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map, MethodDescription.InDefinedShape param3InDefinedShape) {
/* 3675 */           return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param3TypePool, param3Map, param3List);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeList.Generic resolveExceptionTypes(List<String> param3List, TypePool param3TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map, MethodDescription.InDefinedShape param3InDefinedShape) {
/* 3685 */           return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param3TypePool, param3Map, param3List);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeDescription.Generic resolveRecordType(String param3String, TypePool param3TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, RecordComponentDescription.InDefinedShape param3InDefinedShape) {
/* 3695 */           return RawAnnotatedType.of(param3TypePool, param3Map, param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class RawAnnotatedType
/*      */           extends TypeDescription.Generic.OfNonGenericType
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String typePath;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected RawAnnotatedType(TypePool param6TypePool, String param6String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, TypeDescription param6TypeDescription) {
/* 3735 */             this.typePool = param6TypePool;
/* 3736 */             this.typePath = param6String;
/* 3737 */             this.annotationTokens = param6Map;
/* 3738 */             this.typeDescription = param6TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static TypeDescription.Generic of(TypePool param6TypePool, @MaybeNull Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, String param6String) {
/* 3752 */             return (TypeDescription.Generic)new RawAnnotatedType(param6TypePool, "", (param6Map == null) ? 
/*      */ 
/*      */                 
/* 3755 */                 Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : param6Map, 
/*      */                 
/* 3757 */                 TypePool.Default.LazyTypeDescription.TokenizedGenericType.toErasure(param6TypePool, param6String));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription asErasure() {
/* 3764 */             return this.typeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public TypeDescription.Generic getOwnerType() {
/*      */             TypeDescription typeDescription;
/* 3773 */             return (TypeDescription.Generic)(((typeDescription = this.typeDescription.getDeclaringType()) == null) ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath, this.annotationTokens, typeDescription));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public TypeDescription.Generic getComponentType() {
/*      */             TypeDescription typeDescription;
/* 3784 */             return (TypeDescription.Generic)(((typeDescription = this.typeDescription.getComponentType()) == null) ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath + '[', this.annotationTokens, typeDescription));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/* 3793 */             StringBuilder stringBuilder = new StringBuilder(this.typePath);
/* 3794 */             for (byte b = 0; b < this.typeDescription.getInnerClassCount(); b++) {
/* 3795 */               stringBuilder = stringBuilder.append('.');
/*      */             }
/* 3797 */             return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(stringBuilder.toString()));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class LazyRawAnnotatedTypeList
/*      */             extends TypeList.Generic.AbstractBase
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<String> descriptors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected LazyRawAnnotatedTypeList(TypePool param7TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param7Map, List<String> param7List) {
/* 3830 */               this.typePool = param7TypePool;
/* 3831 */               this.annotationTokens = param7Map;
/* 3832 */               this.descriptors = param7List;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static TypeList.Generic of(TypePool param7TypePool, @MaybeNull Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param7Map, List<String> param7List) {
/* 3847 */               return (TypeList.Generic)new LazyRawAnnotatedTypeList(param7TypePool, (param7Map == null) ? 
/*      */                   
/* 3849 */                   Collections.<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>emptyMap() : param7Map, param7List);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic get(int param7Int) {
/* 3858 */               return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(param7Int)), this.descriptors.get(param7Int));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int size() {
/* 3865 */               return this.descriptors.size();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList asErasures() {
/* 3872 */               return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.descriptors);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic asRawTypes() {
/* 3879 */               return (TypeList.Generic)this;
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public int getStackSize()
/*      */             {
/* 3886 */               int i = 0;
/* 3887 */               for (String str : this.descriptors) {
/* 3888 */                 i += Type.getType(str).getSize();
/*      */               }
/* 3890 */               return i; } } } protected static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase { private final TypePool typePool; private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens; private final List<String> descriptors; protected LazyRawAnnotatedTypeList(TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, List<String> param6List) { this.typePool = param6TypePool; this.annotationTokens = param6Map; this.descriptors = param6List; } protected static TypeList.Generic of(TypePool param6TypePool, @MaybeNull Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, List<String> param6List) { return (TypeList.Generic)new LazyRawAnnotatedTypeList(param6TypePool, (param6Map == null) ? Collections.<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>emptyMap() : param6Map, param6List); } public TypeDescription.Generic get(int param6Int) { return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(param6Int)), this.descriptors.get(param6Int)); } public int size() { return this.descriptors.size(); } public TypeList asErasures() { return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.descriptors); } public TypeList.Generic asRawTypes() { return (TypeList.Generic)this; } public int getStackSize() { int i = 0; for (String str : this.descriptors) i += Type.getType(str).getSize();  return i; }
/*      */            }
/*      */       
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface ForType
/*      */         extends GenericTypeToken.Resolution
/*      */       {
/*      */         TypeDescription.Generic resolveSuperClass(String param3String, TypePool param3TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, TypeDescription param3TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         TypeList.Generic resolveInterfaceTypes(List<String> param3List, TypePool param3TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map, TypeDescription param3TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Tokenized
/*      */           implements ForType
/*      */         {
/*      */           private final TypePool.Default.LazyTypeDescription.GenericTypeToken superClassToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> interfaceTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List, List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> param6List1) {
/* 4052 */             this.superClassToken = param6GenericTypeToken;
/* 4053 */             this.interfaceTypeTokens = param6List;
/* 4054 */             this.typeVariableTokens = param6List1;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic resolveSuperClass(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, TypeDescription param6TypeDescription) {
/* 4064 */             return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.superClassToken, param6String, param6Map, (TypeVariableSource)param6TypeDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic resolveInterfaceTypes(List<String> param6List, TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, TypeDescription param6TypeDescription) {
/* 4078 */             return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TokenList(param6TypePool, this.interfaceTypeTokens, param6Map, param6List, (TypeVariableSource)param6TypeDescription, (byte)0);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic resolveTypeVariables(TypePool param6TypePool, TypeVariableSource param6TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param6Map1)
/*      */           {
/* 4088 */             return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TypeVariableList(param6TypePool, this.typeVariableTokens, param6TypeVariableSource, param6Map, param6Map1); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!this.superClassToken.equals(((Tokenized)param6Object).superClassToken) ? false : (!this.interfaceTypeTokens.equals(((Tokenized)param6Object).interfaceTypeTokens) ? false : (!!this.typeVariableTokens.equals(((Tokenized)param6Object).typeVariableTokens)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.superClassToken.hashCode()) * 31 + this.interfaceTypeTokens.hashCode()) * 31 + this.typeVariableTokens.hashCode(); } } } public static interface Resolution { TypeList.Generic resolveTypeVariables(TypePool param3TypePool, TypeVariableSource param3TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param3Map1); public enum Raw implements ForField, ForMethod, ForRecordComponent, ForType { INSTANCE; public final TypeDescription.Generic resolveSuperClass(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypeDescription param5TypeDescription) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } public final TypeList.Generic resolveInterfaceTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, TypeDescription param5TypeDescription) { return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param5TypePool, param5Map, param5List); } public final TypeList.Generic resolveTypeVariables(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param5Map1) { return (TypeList.Generic)new TypeList.Generic.Empty(); } public final TypeDescription.Generic resolveFieldType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, FieldDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } public final TypeDescription.Generic resolveReturnType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } public final TypeList.Generic resolveParameterTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param5TypePool, param5Map, param5List); } public final TypeList.Generic resolveExceptionTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param5TypePool, param5Map, param5List); } public final TypeDescription.Generic resolveRecordType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, RecordComponentDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } protected static class RawAnnotatedType extends TypeDescription.Generic.OfNonGenericType { private final TypePool typePool; private final String typePath; private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens; private final TypeDescription typeDescription; protected RawAnnotatedType(TypePool param6TypePool, String param6String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, TypeDescription param6TypeDescription) { this.typePool = param6TypePool; this.typePath = param6String; this.annotationTokens = param6Map; this.typeDescription = param6TypeDescription; } protected static TypeDescription.Generic of(TypePool param6TypePool, @MaybeNull Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, String param6String) { return (TypeDescription.Generic)new RawAnnotatedType(param6TypePool, "", (param6Map == null) ? Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : param6Map, TypePool.Default.LazyTypeDescription.TokenizedGenericType.toErasure(param6TypePool, param6String)); } public TypeDescription asErasure() { return this.typeDescription; } @MaybeNull public TypeDescription.Generic getOwnerType() { TypeDescription typeDescription; return (TypeDescription.Generic)(((typeDescription = this.typeDescription.getDeclaringType()) == null) ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath, this.annotationTokens, typeDescription)); } @MaybeNull public TypeDescription.Generic getComponentType() { TypeDescription typeDescription; return (TypeDescription.Generic)(((typeDescription = this.typeDescription.getComponentType()) == null) ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath + '[', this.annotationTokens, typeDescription)); } public AnnotationList getDeclaredAnnotations() { StringBuilder stringBuilder = new StringBuilder(this.typePath); for (byte b = 0; b < this.typeDescription.getInnerClassCount(); b++) stringBuilder = stringBuilder.append('.');  return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(stringBuilder.toString())); } protected static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase { private final TypePool typePool; private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens; private final List<String> descriptors; protected LazyRawAnnotatedTypeList(TypePool param7TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param7Map, List<String> param7List) { this.typePool = param7TypePool; this.annotationTokens = param7Map; this.descriptors = param7List; } protected static TypeList.Generic of(TypePool param7TypePool, @MaybeNull Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param7Map, List<String> param7List) { return (TypeList.Generic)new LazyRawAnnotatedTypeList(param7TypePool, (param7Map == null) ? Collections.<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>emptyMap() : param7Map, param7List); } public TypeDescription.Generic get(int param7Int) { return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(param7Int)), this.descriptors.get(param7Int)); } public int size() { return this.descriptors.size(); } public TypeList asErasures() { return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.descriptors); } public TypeList.Generic asRawTypes() { return (TypeList.Generic)this; } public int getStackSize() { int i = 0; for (String str : this.descriptors) i += Type.getType(str).getSize();  return i; } } } protected static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase { private final TypePool typePool; private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens; private final List<String> descriptors; protected LazyRawAnnotatedTypeList(TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, List<String> param6List) { this.typePool = param6TypePool; this.annotationTokens = param6Map; this.descriptors = param6List; } protected static TypeList.Generic of(TypePool param6TypePool, @MaybeNull Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, List<String> param6List) { return (TypeList.Generic)new LazyRawAnnotatedTypeList(param6TypePool, (param6Map == null) ? Collections.<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>emptyMap() : param6Map, param6List); } public TypeDescription.Generic get(int param6Int) { return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(param6Int)), this.descriptors.get(param6Int)); } public int size() { return this.descriptors.size(); } public TypeList asErasures() { return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.descriptors); } public TypeList.Generic asRawTypes() { return (TypeList.Generic)this; } public int getStackSize() { int i = 0; for (String str : this.descriptors) i += Type.getType(str).getSize();  return i; } } } public enum Malformed implements ForField, ForMethod, ForRecordComponent, ForType { INSTANCE; public final TypeDescription.Generic resolveSuperClass(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypeDescription param5TypeDescription) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } public final TypeList.Generic resolveInterfaceTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, TypeDescription param5TypeDescription) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed.TokenList(param5TypePool, param5List); } public final TypeList.Generic resolveTypeVariables(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param5Map1) { throw new GenericSignatureFormatError(); } public final TypeDescription.Generic resolveFieldType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, FieldDescription.InDefinedShape param5InDefinedShape) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } public final TypeDescription.Generic resolveReturnType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } public final TypeList.Generic resolveParameterTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed.TokenList(param5TypePool, param5List); } public final TypeList.Generic resolveExceptionTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed.TokenList(param5TypePool, param5List); } public final TypeDescription.Generic resolveRecordType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, RecordComponentDescription.InDefinedShape param5InDefinedShape) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } } public static interface ForType extends Resolution { TypeDescription.Generic resolveSuperClass(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypeDescription param5TypeDescription); TypeList.Generic resolveInterfaceTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, TypeDescription param5TypeDescription); @Enhance public static class Tokenized implements ForType { private final TypePool.Default.LazyTypeDescription.GenericTypeToken superClassToken; private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> interfaceTypeTokens; private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens; protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List, List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> param6List1) { this.superClassToken = param6GenericTypeToken; this.interfaceTypeTokens = param6List; this.typeVariableTokens = param6List1; } public TypeDescription.Generic resolveSuperClass(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, TypeDescription param6TypeDescription) { return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.superClassToken, param6String, param6Map, (TypeVariableSource)param6TypeDescription); } public TypeList.Generic resolveInterfaceTypes(List<String> param6List, TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, TypeDescription param6TypeDescription) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TokenList(param6TypePool, this.interfaceTypeTokens, param6Map, param6List, (TypeVariableSource)param6TypeDescription, (byte)0); } public TypeList.Generic resolveTypeVariables(TypePool param6TypePool, TypeVariableSource param6TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param6Map1) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TypeVariableList(param6TypePool, this.typeVariableTokens, param6TypeVariableSource, param6Map, param6Map1); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param6Object) {
/*      */               return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!this.superClassToken.equals(((Tokenized)param6Object).superClassToken) ? false : (!this.interfaceTypeTokens.equals(((Tokenized)param6Object).interfaceTypeTokens) ? false : (!!this.typeVariableTokens.equals(((Tokenized)param6Object).typeVariableTokens))))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return ((getClass().hashCode() * 31 + this.superClassToken.hashCode()) * 31 + this.interfaceTypeTokens.hashCode()) * 31 + this.typeVariableTokens.hashCode();
/*      */             } }
/*      */            }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static interface ForField
/*      */         {
/*      */           TypeDescription.Generic resolveFieldType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, FieldDescription.InDefinedShape param5InDefinedShape);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           public static class Tokenized
/*      */             implements ForField
/*      */           {
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken fieldTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken) {
/* 4129 */               this.fieldTypeToken = param6GenericTypeToken;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic resolveFieldType(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, FieldDescription.InDefinedShape param6InDefinedShape) {
/* 4139 */               return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.fieldTypeToken, param6String, param6Map, (TypeVariableSource)param6InDefinedShape
/*      */ 
/*      */ 
/*      */                   
/* 4143 */                   .getDeclaringType());
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param6Object) {
/*      */               return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!!this.fieldTypeToken.equals(((Tokenized)param6Object).fieldTypeToken))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.fieldTypeToken.hashCode();
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static interface ForMethod
/*      */           extends Resolution
/*      */         {
/*      */           TypeDescription.Generic resolveReturnType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           TypeList.Generic resolveParameterTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           TypeList.Generic resolveExceptionTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           public static class Tokenized
/*      */             implements ForMethod
/*      */           {
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken returnTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameterTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> exceptionTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List1, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List2, List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> param6List) {
/* 4233 */               this.returnTypeToken = param6GenericTypeToken;
/* 4234 */               this.parameterTypeTokens = param6List1;
/* 4235 */               this.exceptionTypeTokens = param6List2;
/* 4236 */               this.typeVariableTokens = param6List;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic resolveReturnType(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, MethodDescription.InDefinedShape param6InDefinedShape) {
/* 4246 */               return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.returnTypeToken, param6String, param6Map, (TypeVariableSource)param6InDefinedShape);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic resolveParameterTypes(List<String> param6List, TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, MethodDescription.InDefinedShape param6InDefinedShape) {
/* 4260 */               return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TokenList(param6TypePool, this.parameterTypeTokens, param6Map, param6List, (TypeVariableSource)param6InDefinedShape, (byte)0);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic resolveExceptionTypes(List<String> param6List, TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, MethodDescription.InDefinedShape param6InDefinedShape) {
/* 4271 */               if (this.exceptionTypeTokens.isEmpty())
/* 4272 */                 return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE.resolveExceptionTypes(param6List, param6TypePool, param6Map, param6InDefinedShape);  return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TokenList(param6TypePool, this.exceptionTypeTokens, param6Map, param6List, (TypeVariableSource)param6InDefinedShape, (byte)0);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic resolveTypeVariables(TypePool param6TypePool, TypeVariableSource param6TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param6Map1) {
/* 4283 */               return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TypeVariableList(param6TypePool, this.typeVariableTokens, param6TypeVariableSource, param6Map, param6Map1);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param6Object) {
/*      */               return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!this.returnTypeToken.equals(((Tokenized)param6Object).returnTypeToken) ? false : (!this.parameterTypeTokens.equals(((Tokenized)param6Object).parameterTypeTokens) ? false : (!this.exceptionTypeTokens.equals(((Tokenized)param6Object).exceptionTypeTokens) ? false : (!!this.typeVariableTokens.equals(((Tokenized)param6Object).typeVariableTokens)))))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return (((getClass().hashCode() * 31 + this.returnTypeToken.hashCode()) * 31 + this.parameterTypeTokens.hashCode()) * 31 + this.exceptionTypeTokens.hashCode()) * 31 + this.typeVariableTokens.hashCode();
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static interface ForRecordComponent
/*      */         {
/*      */           TypeDescription.Generic resolveRecordType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, RecordComponentDescription.InDefinedShape param5InDefinedShape);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           public static class Tokenized
/*      */             implements ForRecordComponent
/*      */           {
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken recordComponentTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken) {
/* 4324 */               this.recordComponentTypeToken = param6GenericTypeToken;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic resolveRecordType(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, RecordComponentDescription.InDefinedShape param6InDefinedShape)
/*      */             {
/* 4334 */               return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.recordComponentTypeToken, param6String, param6Map, (TypeVariableSource)param6InDefinedShape
/*      */ 
/*      */ 
/*      */                   
/* 4338 */                   .getDeclaringType()); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!!this.recordComponentTypeToken.equals(((Tokenized)param6Object).recordComponentTypeToken)))); } public int hashCode() { return getClass().hashCode() * 31 + this.recordComponentTypeToken.hashCode(); } } } } protected static interface GenericTypeToken { public static final String EMPTY_TYPE_PATH = ""; public static final char COMPONENT_TYPE_PATH = '['; public static final char WILDCARD_TYPE_PATH = '*'; public static final char INNER_CLASS_PATH = '.'; public static final char INDEXED_TYPE_DELIMITER = ';'; TypeDescription.Generic toGenericType(TypePool param3TypePool, TypeVariableSource param3TypeVariableSource, String param3String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map); boolean isPrimaryBound(TypePool param3TypePool); String getTypePathPrefix(); public static interface OfFormalTypeVariable { TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param4Map1); } public enum ForPrimitiveType implements GenericTypeToken { BOOLEAN((String)boolean.class), BYTE((String)byte.class), SHORT((String)short.class), CHAR((String)char.class), INTEGER((String)int.class), LONG((String)long.class), FLOAT((String)float.class), DOUBLE((String)double.class), VOID((String)void.class); private final TypeDescription typeDescription; ForPrimitiveType(Class<?> param4Class) { this.typeDescription = TypeDescription.ForLoadedType.of(param4Class); } public static TypePool.Default.LazyTypeDescription.GenericTypeToken of(char param4Char) { switch (param4Char) { case 'V': return VOID;case 'Z': return BOOLEAN;case 'B': return BYTE;case 'S': return SHORT;case 'C': return CHAR;case 'I': return INTEGER;case 'J': return LONG;case 'F': return FLOAT;case 'D': return DOUBLE; }  throw new IllegalArgumentException("Not a valid primitive type descriptor: " + param4Char); } public final TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) { return (TypeDescription.Generic)new LazyPrimitiveType(param4TypePool, param4String, param4Map, this.typeDescription); } public final boolean isPrimaryBound(TypePool param4TypePool) { throw new IllegalStateException("A primitive type cannot be a type variable bound: " + this); } public final String getTypePathPrefix() { throw new IllegalStateException("A primitive type cannot be the owner of a nested type: " + this); } protected static class LazyPrimitiveType extends TypeDescription.Generic.OfNonGenericType { private final TypePool typePool; private final String typePath; private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens; private final TypeDescription typeDescription; protected LazyPrimitiveType(TypePool param5TypePool, String param5String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypeDescription param5TypeDescription) { this.typePool = param5TypePool; this.typePath = param5String; this.annotationTokens = param5Map; this.typeDescription = param5TypeDescription; } public TypeDescription asErasure() { return this.typeDescription; } @MaybeNull public TypeDescription.Generic getOwnerType() { return TypeDescription.Generic.UNDEFINED; } @MaybeNull public TypeDescription.Generic getComponentType() { return TypeDescription.Generic.UNDEFINED; } public AnnotationList getDeclaredAnnotations() { return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath)); } } } public enum ForUnboundWildcard implements GenericTypeToken { INSTANCE; public final TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, @MaybeNull Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) { return (TypeDescription.Generic)new LazyUnboundWildcard(param4TypePool, param4String, (param4Map == null) ? Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : param4Map); } public final boolean isPrimaryBound(TypePool param4TypePool) { throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this); } public final String getTypePathPrefix() { throw new IllegalStateException("An unbound wildcard cannot be the owner of a nested type: " + this); } protected static class LazyUnboundWildcard extends TypeDescription.Generic.OfWildcardType { private final TypePool typePool; private final String typePath; private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens; protected LazyUnboundWildcard(TypePool param5TypePool, String param5String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map) { this.typePool = param5TypePool; this.typePath = param5String; this.annotationTokens = param5Map; } public TypeList.Generic getUpperBounds() { return (TypeList.Generic)new TypeList.Generic.Explicit(new TypeDefinition[] { (TypeDefinition)TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class) }); } public TypeList.Generic getLowerBounds() { return (TypeList.Generic)new TypeList.Generic.Empty(); } public AnnotationList getDeclaredAnnotations() { return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath)); } } } public static interface Resolution { TypeList.Generic resolveTypeVariables(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param4Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param4Map1); public enum Raw implements ForField, ForMethod, ForRecordComponent, ForType { INSTANCE; public final TypeDescription.Generic resolveSuperClass(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypeDescription param5TypeDescription) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } public final TypeList.Generic resolveInterfaceTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, TypeDescription param5TypeDescription) { return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param5TypePool, param5Map, param5List); } public final TypeList.Generic resolveTypeVariables(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param5Map1) { return (TypeList.Generic)new TypeList.Generic.Empty(); } public final TypeDescription.Generic resolveFieldType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, FieldDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } public final TypeDescription.Generic resolveReturnType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } public final TypeList.Generic resolveParameterTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param5TypePool, param5Map, param5List); } public final TypeList.Generic resolveExceptionTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.LazyRawAnnotatedTypeList.of(param5TypePool, param5Map, param5List); } public final TypeDescription.Generic resolveRecordType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, RecordComponentDescription.InDefinedShape param5InDefinedShape) { return RawAnnotatedType.of(param5TypePool, param5Map, param5String); } protected static class RawAnnotatedType extends TypeDescription.Generic.OfNonGenericType { private final TypePool typePool; private final String typePath; private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens; private final TypeDescription typeDescription; protected RawAnnotatedType(TypePool param6TypePool, String param6String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, TypeDescription param6TypeDescription) { this.typePool = param6TypePool; this.typePath = param6String; this.annotationTokens = param6Map; this.typeDescription = param6TypeDescription; } protected static TypeDescription.Generic of(TypePool param6TypePool, @MaybeNull Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, String param6String) { return (TypeDescription.Generic)new RawAnnotatedType(param6TypePool, "", (param6Map == null) ? Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : param6Map, TypePool.Default.LazyTypeDescription.TokenizedGenericType.toErasure(param6TypePool, param6String)); } public TypeDescription asErasure() { return this.typeDescription; } @MaybeNull public TypeDescription.Generic getOwnerType() { TypeDescription typeDescription; return (TypeDescription.Generic)(((typeDescription = this.typeDescription.getDeclaringType()) == null) ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath, this.annotationTokens, typeDescription)); } @MaybeNull public TypeDescription.Generic getComponentType() { TypeDescription typeDescription; return (TypeDescription.Generic)(((typeDescription = this.typeDescription.getComponentType()) == null) ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath + '[', this.annotationTokens, typeDescription)); } public AnnotationList getDeclaredAnnotations() { StringBuilder stringBuilder = new StringBuilder(this.typePath); for (byte b = 0; b < this.typeDescription.getInnerClassCount(); b++) stringBuilder = stringBuilder.append('.');  return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(stringBuilder.toString())); } protected static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase { private final TypePool typePool; private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens; private final List<String> descriptors; protected LazyRawAnnotatedTypeList(TypePool param7TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param7Map, List<String> param7List) { this.typePool = param7TypePool; this.annotationTokens = param7Map; this.descriptors = param7List; } protected static TypeList.Generic of(TypePool param7TypePool, @MaybeNull Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param7Map, List<String> param7List) { return (TypeList.Generic)new LazyRawAnnotatedTypeList(param7TypePool, (param7Map == null) ? Collections.<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>emptyMap() : param7Map, param7List); } public TypeDescription.Generic get(int param7Int) { return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(param7Int)), this.descriptors.get(param7Int)); } public int size() { return this.descriptors.size(); } public TypeList asErasures() { return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.descriptors); } public TypeList.Generic asRawTypes() { return (TypeList.Generic)this; } public int getStackSize() { int i = 0; for (String str : this.descriptors) i += Type.getType(str).getSize();  return i; } } } protected static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase { private final TypePool typePool; private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens; private final List<String> descriptors; protected LazyRawAnnotatedTypeList(TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, List<String> param6List) { this.typePool = param6TypePool; this.annotationTokens = param6Map; this.descriptors = param6List; } protected static TypeList.Generic of(TypePool param6TypePool, @MaybeNull Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, List<String> param6List) { return (TypeList.Generic)new LazyRawAnnotatedTypeList(param6TypePool, (param6Map == null) ? Collections.<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>emptyMap() : param6Map, param6List); } public TypeDescription.Generic get(int param6Int) { return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(param6Int)), this.descriptors.get(param6Int)); } public int size() { return this.descriptors.size(); } public TypeList asErasures() { return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.descriptors); } public TypeList.Generic asRawTypes() { return (TypeList.Generic)this; } public int getStackSize() { int i = 0; for (String str : this.descriptors) i += Type.getType(str).getSize();  return i; } } } public enum Malformed implements ForField, ForMethod, ForRecordComponent, ForType { INSTANCE; public final TypeDescription.Generic resolveSuperClass(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypeDescription param5TypeDescription) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } public final TypeList.Generic resolveInterfaceTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, TypeDescription param5TypeDescription) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed.TokenList(param5TypePool, param5List); } public final TypeList.Generic resolveTypeVariables(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param5Map1) { throw new GenericSignatureFormatError(); } public final TypeDescription.Generic resolveFieldType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, FieldDescription.InDefinedShape param5InDefinedShape) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } public final TypeDescription.Generic resolveReturnType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } public final TypeList.Generic resolveParameterTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed.TokenList(param5TypePool, param5List); } public final TypeList.Generic resolveExceptionTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed.TokenList(param5TypePool, param5List); } public final TypeDescription.Generic resolveRecordType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, RecordComponentDescription.InDefinedShape param5InDefinedShape) { return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(param5TypePool, param5String); } } public static interface ForType extends Resolution { TypeDescription.Generic resolveSuperClass(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypeDescription param5TypeDescription); TypeList.Generic resolveInterfaceTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, TypeDescription param5TypeDescription); @Enhance public static class Tokenized implements ForType { private final TypePool.Default.LazyTypeDescription.GenericTypeToken superClassToken; private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> interfaceTypeTokens; private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens; protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List, List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> param6List1) { this.superClassToken = param6GenericTypeToken; this.interfaceTypeTokens = param6List; this.typeVariableTokens = param6List1; } public TypeDescription.Generic resolveSuperClass(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, TypeDescription param6TypeDescription) { return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.superClassToken, param6String, param6Map, (TypeVariableSource)param6TypeDescription); } public TypeList.Generic resolveInterfaceTypes(List<String> param6List, TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, TypeDescription param6TypeDescription) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TokenList(param6TypePool, this.interfaceTypeTokens, param6Map, param6List, (TypeVariableSource)param6TypeDescription, (byte)0); } public TypeList.Generic resolveTypeVariables(TypePool param6TypePool, TypeVariableSource param6TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param6Map1) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TypeVariableList(param6TypePool, this.typeVariableTokens, param6TypeVariableSource, param6Map, param6Map1); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!this.superClassToken.equals(((Tokenized)param6Object).superClassToken) ? false : (!this.interfaceTypeTokens.equals(((Tokenized)param6Object).interfaceTypeTokens) ? false : (!!this.typeVariableTokens.equals(((Tokenized)param6Object).typeVariableTokens)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.superClassToken.hashCode()) * 31 + this.interfaceTypeTokens.hashCode()) * 31 + this.typeVariableTokens.hashCode(); } } } public static interface ForField { TypeDescription.Generic resolveFieldType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, FieldDescription.InDefinedShape param5InDefinedShape); @Enhance public static class Tokenized implements ForField { private final TypePool.Default.LazyTypeDescription.GenericTypeToken fieldTypeToken; protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken) { this.fieldTypeToken = param6GenericTypeToken; } public TypeDescription.Generic resolveFieldType(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, FieldDescription.InDefinedShape param6InDefinedShape) { return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.fieldTypeToken, param6String, param6Map, (TypeVariableSource)param6InDefinedShape.getDeclaringType()); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!!this.fieldTypeToken.equals(((Tokenized)param6Object).fieldTypeToken)))); } public int hashCode() { return getClass().hashCode() * 31 + this.fieldTypeToken.hashCode(); } } } public static interface ForMethod extends Resolution { TypeDescription.Generic resolveReturnType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape); TypeList.Generic resolveParameterTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape); TypeList.Generic resolveExceptionTypes(List<String> param5List, TypePool param5TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map, MethodDescription.InDefinedShape param5InDefinedShape); @Enhance public static class Tokenized implements ForMethod { private final TypePool.Default.LazyTypeDescription.GenericTypeToken returnTypeToken; private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameterTypeTokens; private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> exceptionTypeTokens; private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens; protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List1, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List2, List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> param6List) { this.returnTypeToken = param6GenericTypeToken; this.parameterTypeTokens = param6List1; this.exceptionTypeTokens = param6List2; this.typeVariableTokens = param6List; } public TypeDescription.Generic resolveReturnType(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, MethodDescription.InDefinedShape param6InDefinedShape) { return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.returnTypeToken, param6String, param6Map, (TypeVariableSource)param6InDefinedShape); } public TypeList.Generic resolveParameterTypes(List<String> param6List, TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, MethodDescription.InDefinedShape param6InDefinedShape) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TokenList(param6TypePool, this.parameterTypeTokens, param6Map, param6List, (TypeVariableSource)param6InDefinedShape, (byte)0); } public TypeList.Generic resolveExceptionTypes(List<String> param6List, TypePool param6TypePool, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, MethodDescription.InDefinedShape param6InDefinedShape) { if (this.exceptionTypeTokens.isEmpty()) return TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE.resolveExceptionTypes(param6List, param6TypePool, param6Map, param6InDefinedShape);  return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TokenList(param6TypePool, this.exceptionTypeTokens, param6Map, param6List, (TypeVariableSource)param6InDefinedShape, (byte)0); } public TypeList.Generic resolveTypeVariables(TypePool param6TypePool, TypeVariableSource param6TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param6Map1) { return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.TypeVariableList(param6TypePool, this.typeVariableTokens, param6TypeVariableSource, param6Map, param6Map1); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!this.returnTypeToken.equals(((Tokenized)param6Object).returnTypeToken) ? false : (!this.parameterTypeTokens.equals(((Tokenized)param6Object).parameterTypeTokens) ? false : (!this.exceptionTypeTokens.equals(((Tokenized)param6Object).exceptionTypeTokens) ? false : (!!this.typeVariableTokens.equals(((Tokenized)param6Object).typeVariableTokens))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.returnTypeToken.hashCode()) * 31 + this.parameterTypeTokens.hashCode()) * 31 + this.exceptionTypeTokens.hashCode()) * 31 + this.typeVariableTokens.hashCode(); } } } public static interface ForRecordComponent { TypeDescription.Generic resolveRecordType(String param5String, TypePool param5TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, RecordComponentDescription.InDefinedShape param5InDefinedShape); @Enhance public static class Tokenized implements ForRecordComponent { public TypeDescription.Generic resolveRecordType(String param6String, TypePool param6TypePool, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, RecordComponentDescription.InDefinedShape param6InDefinedShape) { return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(param6TypePool, this.recordComponentTypeToken, param6String, param6Map, (TypeVariableSource)param6InDefinedShape.getDeclaringType()); }
/*      */ 
/*      */               
/*      */               private final TypePool.Default.LazyTypeDescription.GenericTypeToken recordComponentTypeToken;
/*      */               
/*      */               protected Tokenized(TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken) {
/*      */                 this.recordComponentTypeToken = param6GenericTypeToken;
/*      */               }
/*      */               
/*      */               public boolean equals(@MaybeNull Object param6Object) {
/*      */                 return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!!this.recordComponentTypeToken.equals(((Tokenized)param6Object).recordComponentTypeToken))));
/*      */               }
/*      */               
/*      */               public int hashCode() {
/*      */                 return getClass().hashCode() * 31 + this.recordComponentTypeToken.hashCode();
/*      */               } } } }
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForRawType implements GenericTypeToken {
/*      */           private final String name;
/*      */           
/*      */           protected ForRawType(String param4String) {
/* 4361 */             this.name = param4String;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) {
/* 4371 */             return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.RawAnnotatedType(param4TypePool, param4String, param4Map, param4TypePool
/*      */ 
/*      */                 
/* 4374 */                 .describe(this.name).resolve());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isPrimaryBound(TypePool param4TypePool) {
/* 4381 */             return !param4TypePool.describe(this.name).resolve().isInterface();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getTypePathPrefix() {
/* 4388 */             throw new IllegalStateException("A non-generic type cannot be the owner of a nested type: " + this);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.name.equals(((ForRawType)param4Object).name))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.name.hashCode();
/*      */           }
/*      */         }
/*      */         
/*      */         @Enhance
/*      */         public static class ForTypeVariable
/*      */           implements GenericTypeToken
/*      */         {
/*      */           private final String symbol;
/*      */           
/*      */           protected ForTypeVariable(String param4String) {
/* 4409 */             this.symbol = param4String;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) {
/*      */             TypeDescription.Generic generic;
/* 4420 */             return (TypeDescription.Generic)(((generic = param4TypeVariableSource.findVariable(this.symbol)) == null) ? new UnresolvedTypeVariable(param4TypeVariableSource, param4TypePool, this.symbol, param4Map
/* 4421 */                 .get(param4String)) : new AnnotatedTypeVariable(param4TypePool, param4Map
/* 4422 */                 .get(param4String), generic));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isPrimaryBound(TypePool param4TypePool) {
/* 4429 */             return true;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getTypePathPrefix() {
/* 4436 */             throw new IllegalStateException("A type variable cannot be the owner of a nested type: " + this);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.symbol.equals(((ForTypeVariable)param4Object).symbol))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.symbol.hashCode();
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class AnnotatedTypeVariable
/*      */             extends TypeDescription.Generic.OfTypeVariable
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */             
/*      */             private final TypeDescription.Generic typeVariable;
/*      */ 
/*      */ 
/*      */             
/*      */             protected AnnotatedTypeVariable(TypePool param5TypePool, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param5List, TypeDescription.Generic param5Generic) {
/* 4467 */               this.typePool = param5TypePool;
/* 4468 */               this.annotationTokens = param5List;
/* 4469 */               this.typeVariable = param5Generic;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getUpperBounds() {
/* 4476 */               return this.typeVariable.getUpperBounds();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeVariableSource getTypeVariableSource() {
/* 4483 */               return this.typeVariable.getTypeVariableSource();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public String getSymbol() {
/* 4490 */               return this.typeVariable.getSymbol();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationList getDeclaredAnnotations() {
/* 4497 */               return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class UnresolvedTypeVariable
/*      */             extends TypeDescription.Generic.OfTypeVariable
/*      */           {
/*      */             private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final String symbol;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected UnresolvedTypeVariable(TypeVariableSource param5TypeVariableSource, TypePool param5TypePool, String param5String, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param5List) {
/* 4539 */               this.typeVariableSource = param5TypeVariableSource;
/* 4540 */               this.typePool = param5TypePool;
/* 4541 */               this.symbol = param5String;
/* 4542 */               this.annotationTokens = param5List;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getUpperBounds() {
/* 4549 */               throw new IllegalStateException("Cannot resolve bounds of unresolved type variable " + this + " by " + this.typeVariableSource);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeVariableSource getTypeVariableSource() {
/* 4556 */               return this.typeVariableSource;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public String getSymbol() {
/* 4563 */               return this.symbol;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationList getDeclaredAnnotations() {
/* 4570 */               return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           protected static class Formal
/*      */             implements TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable
/*      */           {
/*      */             private final String symbol;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> boundTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Formal(String param5String, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param5List) {
/* 4597 */               this.symbol = param5String;
/* 4598 */               this.boundTypeTokens = param5List;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic toGenericType(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, @MaybeNull Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, @MaybeNull Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param5Map1) {
/* 4608 */               return (TypeDescription.Generic)new LazyTypeVariable(param5TypePool, param5TypeVariableSource, (param5Map == null) ? 
/*      */ 
/*      */                   
/* 4611 */                   Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : param5Map, (param5Map1 == null) ? 
/*      */ 
/*      */                   
/* 4614 */                   Collections.<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>emptyMap() : param5Map1, this.symbol, this.boundTypeTokens);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.symbol.equals(((Formal)param5Object).symbol) ? false : (!!this.boundTypeTokens.equals(((Formal)param5Object).boundTypeTokens)))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return (getClass().hashCode() * 31 + this.symbol.hashCode()) * 31 + this.boundTypeTokens.hashCode();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static class LazyTypeVariable
/*      */               extends TypeDescription.Generic.OfTypeVariable
/*      */             {
/*      */               private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> boundaryAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final String symbol;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> boundTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected LazyTypeVariable(TypePool param6TypePool, TypeVariableSource param6TypeVariableSource, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param6Map1, String param6String, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List) {
/* 4671 */                 this.typePool = param6TypePool;
/* 4672 */                 this.typeVariableSource = param6TypeVariableSource;
/* 4673 */                 this.annotationTokens = param6Map;
/* 4674 */                 this.boundaryAnnotationTokens = param6Map1;
/* 4675 */                 this.symbol = param6String;
/* 4676 */                 this.boundTypeTokens = param6List;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public TypeList.Generic getUpperBounds() {
/* 4683 */                 return (TypeList.Generic)new LazyBoundTokenList(this.typePool, this.typeVariableSource, this.boundaryAnnotationTokens, this.boundTypeTokens);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public TypeVariableSource getTypeVariableSource() {
/* 4690 */                 return this.typeVariableSource;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public String getSymbol() {
/* 4697 */                 return this.symbol;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public AnnotationList getDeclaredAnnotations() {
/* 4704 */                 return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(""));
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected static class LazyBoundTokenList
/*      */                 extends TypeList.Generic.AbstractBase
/*      */               {
/*      */                 private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> boundTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 protected LazyBoundTokenList(TypePool param7TypePool, TypeVariableSource param7TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param7Map, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param7List) {
/* 4744 */                   this.typePool = param7TypePool;
/* 4745 */                   this.typeVariableSource = param7TypeVariableSource;
/* 4746 */                   this.annotationTokens = param7Map;
/* 4747 */                   this.boundTypeTokens = param7List;
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public TypeDescription.Generic get(int param7Int) {
/* 4757 */                   Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> map = (!this.annotationTokens.containsKey(Integer.valueOf(param7Int)) && !this.annotationTokens.containsKey(Integer.valueOf(param7Int + 1))) ? Collections.emptyMap() : this.annotationTokens.get(Integer.valueOf(param7Int + (((TypePool.Default.LazyTypeDescription.GenericTypeToken)this.boundTypeTokens.get(0)).isPrimaryBound(this.typePool) ? 0 : 1)));
/* 4758 */                   return ((TypePool.Default.LazyTypeDescription.GenericTypeToken)this.boundTypeTokens.get(param7Int)).toGenericType(this.typePool, this.typeVariableSource, "", (map == null) ? 
/*      */ 
/*      */ 
/*      */                       
/* 4762 */                       Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : map);
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public int size() {
/* 4770 */                   return this.boundTypeTokens.size();
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForGenericArray
/*      */           implements GenericTypeToken
/*      */         {
/*      */           private final TypePool.Default.LazyTypeDescription.GenericTypeToken componentTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForGenericArray(TypePool.Default.LazyTypeDescription.GenericTypeToken param4GenericTypeToken) {
/* 4794 */             this.componentTypeToken = param4GenericTypeToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) {
/* 4804 */             return (TypeDescription.Generic)new LazyGenericArray(param4TypePool, param4TypeVariableSource, param4String, param4Map, this.componentTypeToken);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isPrimaryBound(TypePool param4TypePool) {
/* 4811 */             throw new IllegalStateException("A generic array type cannot be a type variable bound: " + this);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getTypePathPrefix() {
/* 4818 */             throw new IllegalStateException("A generic array type cannot be the owner of a nested type: " + this);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.componentTypeToken.equals(((ForGenericArray)param4Object).componentTypeToken))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.componentTypeToken.hashCode();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class LazyGenericArray
/*      */             extends TypeDescription.Generic.OfGenericArray
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */             
/*      */             private final String typePath;
/*      */ 
/*      */ 
/*      */             
/*      */             private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken componentTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected LazyGenericArray(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, String param5String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 4865 */               this.typePool = param5TypePool;
/* 4866 */               this.typeVariableSource = param5TypeVariableSource;
/* 4867 */               this.typePath = param5String;
/* 4868 */               this.annotationTokens = param5Map;
/* 4869 */               this.componentTypeToken = param5GenericTypeToken;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic getComponentType() {
/* 4876 */               return this.componentTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath + '[', this.annotationTokens);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationList getDeclaredAnnotations() {
/* 4883 */               return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForLowerBoundWildcard
/*      */           implements GenericTypeToken
/*      */         {
/*      */           private final TypePool.Default.LazyTypeDescription.GenericTypeToken boundTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForLowerBoundWildcard(TypePool.Default.LazyTypeDescription.GenericTypeToken param4GenericTypeToken) {
/* 4905 */             this.boundTypeToken = param4GenericTypeToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) {
/* 4915 */             return (TypeDescription.Generic)new LazyLowerBoundWildcard(param4TypePool, param4TypeVariableSource, param4String, param4Map, this.boundTypeToken);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isPrimaryBound(TypePool param4TypePool) {
/* 4922 */             throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getTypePathPrefix() {
/* 4929 */             throw new IllegalStateException("A lower bound wildcard cannot be the owner of a nested type: " + this);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.boundTypeToken.equals(((ForLowerBoundWildcard)param4Object).boundTypeToken))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.boundTypeToken.hashCode();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class LazyLowerBoundWildcard
/*      */             extends TypeDescription.Generic.OfWildcardType
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */             
/*      */             private final String typePath;
/*      */ 
/*      */ 
/*      */             
/*      */             private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken boundTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected LazyLowerBoundWildcard(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, String param5String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 4976 */               this.typePool = param5TypePool;
/* 4977 */               this.typeVariableSource = param5TypeVariableSource;
/* 4978 */               this.typePath = param5String;
/* 4979 */               this.annotationTokens = param5Map;
/* 4980 */               this.boundTypeToken = param5GenericTypeToken;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getUpperBounds() {
/* 4987 */               return (TypeList.Generic)new TypeList.Generic.Explicit(new TypeDefinition[] { (TypeDefinition)TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class) });
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getLowerBounds() {
/* 4994 */               return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.GenericTypeToken.LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationList getDeclaredAnnotations() {
/* 5001 */               return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForUpperBoundWildcard
/*      */           implements GenericTypeToken
/*      */         {
/*      */           private final TypePool.Default.LazyTypeDescription.GenericTypeToken boundTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForUpperBoundWildcard(TypePool.Default.LazyTypeDescription.GenericTypeToken param4GenericTypeToken) {
/* 5023 */             this.boundTypeToken = param4GenericTypeToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) {
/* 5033 */             return (TypeDescription.Generic)new LazyUpperBoundWildcard(param4TypePool, param4TypeVariableSource, param4String, param4Map, this.boundTypeToken);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isPrimaryBound(TypePool param4TypePool) {
/* 5040 */             throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getTypePathPrefix() {
/* 5047 */             throw new IllegalStateException("An upper bound wildcard cannot be the owner of a nested type: " + this);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.boundTypeToken.equals(((ForUpperBoundWildcard)param4Object).boundTypeToken))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.boundTypeToken.hashCode();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class LazyUpperBoundWildcard
/*      */             extends TypeDescription.Generic.OfWildcardType
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */             
/*      */             private final String typePath;
/*      */ 
/*      */ 
/*      */             
/*      */             private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken boundTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected LazyUpperBoundWildcard(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, String param5String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 5094 */               this.typePool = param5TypePool;
/* 5095 */               this.typeVariableSource = param5TypeVariableSource;
/* 5096 */               this.typePath = param5String;
/* 5097 */               this.annotationTokens = param5Map;
/* 5098 */               this.boundTypeToken = param5GenericTypeToken;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getUpperBounds() {
/* 5105 */               return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.GenericTypeToken.LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getLowerBounds() {
/* 5112 */               return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationList getDeclaredAnnotations() {
/* 5119 */               return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForParameterizedType
/*      */           implements GenericTypeToken
/*      */         {
/*      */           private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameterTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForParameterizedType(String param4String, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param4List) {
/* 5147 */             this.name = param4String;
/* 5148 */             this.parameterTypeTokens = param4List;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic toGenericType(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map) {
/* 5158 */             return (TypeDescription.Generic)new LazyParameterizedType(param4TypePool, param4TypeVariableSource, param4String, param4Map, this.name, this.parameterTypeTokens);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isPrimaryBound(TypePool param4TypePool) {
/* 5165 */             return !param4TypePool.describe(this.name).resolve().isInterface();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getTypePathPrefix() {
/* 5172 */             return ".";
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.name.equals(((ForParameterizedType)param4Object).name) ? false : (!!this.parameterTypeTokens.equals(((ForParameterizedType)param4Object).parameterTypeTokens)))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.parameterTypeTokens.hashCode();
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           public static class Nested
/*      */             implements TypePool.Default.LazyTypeDescription.GenericTypeToken
/*      */           {
/*      */             private final String name;
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameterTypeTokens;
/*      */ 
/*      */             
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken ownerTypeToken;
/*      */ 
/*      */ 
/*      */             
/*      */             protected Nested(String param5String, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param5List, TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 5204 */               this.name = param5String;
/* 5205 */               this.parameterTypeTokens = param5List;
/* 5206 */               this.ownerTypeToken = param5GenericTypeToken;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic toGenericType(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, String param5String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map) {
/* 5216 */               return (TypeDescription.Generic)new LazyParameterizedType(param5TypePool, param5TypeVariableSource, param5String, param5Map, this.name, this.parameterTypeTokens, this.ownerTypeToken);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public String getTypePathPrefix() {
/* 5223 */               return this.ownerTypeToken.getTypePathPrefix() + '.';
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isPrimaryBound(TypePool param5TypePool) {
/* 5230 */               return !param5TypePool.describe(this.name).resolve().isInterface();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.name.equals(((Nested)param5Object).name) ? false : (!this.parameterTypeTokens.equals(((Nested)param5Object).parameterTypeTokens) ? false : (!!this.ownerTypeToken.equals(((Nested)param5Object).ownerTypeToken))))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return ((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.parameterTypeTokens.hashCode()) * 31 + this.ownerTypeToken.hashCode();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static class LazyParameterizedType
/*      */               extends TypeDescription.Generic.OfParameterizedType
/*      */             {
/*      */               private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final String typePath;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameterTypeTokens;
/*      */ 
/*      */ 
/*      */               
/*      */               private final TypePool.Default.LazyTypeDescription.GenericTypeToken ownerTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected LazyParameterizedType(TypePool param6TypePool, TypeVariableSource param6TypeVariableSource, String param6String1, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param6Map, String param6String2, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param6List, TypePool.Default.LazyTypeDescription.GenericTypeToken param6GenericTypeToken) {
/* 5291 */                 this.typePool = param6TypePool;
/* 5292 */                 this.typeVariableSource = param6TypeVariableSource;
/* 5293 */                 this.typePath = param6String1;
/* 5294 */                 this.annotationTokens = param6Map;
/* 5295 */                 this.name = param6String2;
/* 5296 */                 this.parameterTypeTokens = param6List;
/* 5297 */                 this.ownerTypeToken = param6GenericTypeToken;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public TypeDescription asErasure() {
/* 5304 */                 return this.typePool.describe(this.name).resolve();
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public TypeList.Generic getTypeArguments() {
/* 5311 */                 return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.GenericTypeToken.LazyTokenList(this.typePool, this.typeVariableSource, this.typePath + this.ownerTypeToken.getTypePathPrefix(), this.annotationTokens, this.parameterTypeTokens);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               @MaybeNull
/*      */               public TypeDescription.Generic getOwnerType() {
/* 5319 */                 return this.ownerTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public AnnotationList getDeclaredAnnotations() {
/* 5326 */                 return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath + this.ownerTypeToken.getTypePathPrefix()));
/*      */               }
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class LazyParameterizedType
/*      */             extends TypeDescription.Generic.OfParameterizedType
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final String typePath;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> parameterTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected LazyParameterizedType(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, String param5String1, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, String param5String2, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param5List) {
/* 5382 */               this.typePool = param5TypePool;
/* 5383 */               this.typeVariableSource = param5TypeVariableSource;
/* 5384 */               this.typePath = param5String1;
/* 5385 */               this.annotationTokens = param5Map;
/* 5386 */               this.name = param5String2;
/* 5387 */               this.parameterTypeTokens = param5List;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription asErasure() {
/* 5394 */               return this.typePool.describe(this.name).resolve();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getTypeArguments() {
/* 5401 */               return (TypeList.Generic)new TypePool.Default.LazyTypeDescription.GenericTypeToken.LazyTokenList(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.parameterTypeTokens);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public TypeDescription.Generic getOwnerType() {
/*      */               TypeDescription typeDescription;
/* 5410 */               return ((typeDescription = this.typePool.describe(this.name).resolve().getEnclosingType()) == null) ? TypeDescription.Generic.UNDEFINED : typeDescription
/*      */                 
/* 5412 */                 .asGenericType();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationList getDeclaredAnnotations() {
/* 5419 */               return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static class LazyTokenList
/*      */           extends TypeList.Generic.AbstractBase
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String typePath;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> genericTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected LazyTokenList(TypePool param4TypePool, TypeVariableSource param4TypeVariableSource, String param4String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param4Map, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param4List) {
/* 5468 */             this.typePool = param4TypePool;
/* 5469 */             this.typeVariableSource = param4TypeVariableSource;
/* 5470 */             this.typePath = param4String;
/* 5471 */             this.annotationTokens = param4Map;
/* 5472 */             this.genericTypeTokens = param4List;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic get(int param4Int) {
/* 5479 */             return ((TypePool.Default.LazyTypeDescription.GenericTypeToken)this.genericTypeTokens.get(param4Int)).toGenericType(this.typePool, this.typeVariableSource, this.typePath + param4Int + ';', this.annotationTokens);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int size() {
/* 5486 */             return this.genericTypeTokens.size();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class ForWildcardBound
/*      */             extends TypeList.Generic.AbstractBase
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final String typePath;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypePool.Default.LazyTypeDescription.GenericTypeToken genericTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected ForWildcardBound(TypePool param5TypePool, TypeVariableSource param5TypeVariableSource, String param5String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param5Map, TypePool.Default.LazyTypeDescription.GenericTypeToken param5GenericTypeToken) {
/* 5531 */               this.typePool = param5TypePool;
/* 5532 */               this.typeVariableSource = param5TypeVariableSource;
/* 5533 */               this.typePath = param5String;
/* 5534 */               this.annotationTokens = param5Map;
/* 5535 */               this.genericTypeToken = param5GenericTypeToken;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic get(int param5Int) {
/* 5542 */               if (param5Int == 0) {
/* 5543 */                 return this.genericTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath + '*', this.annotationTokens);
/*      */               }
/* 5545 */               throw new IndexOutOfBoundsException("index = " + param5Int);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int size() {
/* 5553 */               return 1;
/*      */             }
/*      */           }
/*      */         } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class AnnotationToken
/*      */       {
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, AnnotationValue<?, ?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AnnotationToken(String param3String, Map<String, AnnotationValue<?, ?>> param3Map) {
/* 5582 */           this.descriptor = param3String;
/* 5583 */           this.values = param3Map;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected String getBinaryName() {
/* 5592 */           return this.descriptor.substring(1, this.descriptor.length() - 1).replace('/', '.');
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private Resolution toAnnotationDescription(TypePool param3TypePool) {
/*      */           TypePool.Resolution resolution;
/* 5603 */           return (Resolution)((resolution = param3TypePool.describe(getBinaryName())).isResolved() ? new Resolution.Simple((AnnotationDescription)new TypePool.Default.LazyTypeDescription.LazyAnnotationDescription(param3TypePool, resolution
/* 5604 */                 .resolve(), this.values, (byte)0)) : new Resolution.Illegal(
/* 5605 */               getBinaryName()));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.descriptor.equals(((AnnotationToken)param3Object).descriptor) ? false : (!!this.values.equals(((AnnotationToken)param3Object).values)))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.descriptor.hashCode()) * 31 + this.values.hashCode();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Simple
/*      */           implements Resolution
/*      */         {
/*      */           private final AnnotationDescription annotationDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Simple(AnnotationDescription param4AnnotationDescription) {
/* 5645 */             this.annotationDescription = param4AnnotationDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isResolved() {
/* 5652 */             return true;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationDescription resolve()
/*      */           {
/* 5659 */             return this.annotationDescription; } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.annotationDescription.equals(((Simple)param4Object).annotationDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.annotationDescription.hashCode(); } } protected static interface Resolution { boolean isResolved(); AnnotationDescription resolve(); @Enhance public static class Simple implements Resolution { private final AnnotationDescription annotationDescription; protected Simple(AnnotationDescription param5AnnotationDescription) { this.annotationDescription = param5AnnotationDescription; } public boolean isResolved() { return true; } public AnnotationDescription resolve() { return this.annotationDescription; }
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.annotationDescription.equals(((Simple)param5Object).annotationDescription))));
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.annotationDescription.hashCode();
/*      */             } }
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           public static class Illegal
/*      */             implements Resolution
/*      */           {
/*      */             private final String annotationType;
/*      */             
/*      */             public Illegal(String param5String) {
/* 5680 */               this.annotationType = param5String;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isResolved() {
/* 5687 */               return false;
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationDescription resolve()
/*      */             {
/* 5694 */               throw new IllegalStateException("Annotation type is not available: " + this.annotationType); } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.annotationType.equals(((Illegal)param5Object).annotationType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.annotationType.hashCode(); } } } @Enhance public static class Illegal implements Resolution { private final String annotationType; public Illegal(String param4String) { this.annotationType = param4String; } public boolean isResolved() { return false; } public AnnotationDescription resolve() { throw new IllegalStateException("Annotation type is not available: " + this.annotationType); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.annotationType.equals(((Illegal)param4Object).annotationType))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.annotationType.hashCode();
/*      */           } }
/*      */       
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class FieldToken
/*      */       {
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @UnknownNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField signatureResolution;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected FieldToken(String param3String1, int param3Int, String param3String2, @MaybeNull String param3String3, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List) {
/* 5758 */           this.modifiers = param3Int & 0xFFFDFFFF;
/* 5759 */           this.name = param3String1;
/* 5760 */           this.descriptor = param3String2;
/* 5761 */           this.genericSignature = param3String3;
/* 5762 */           this
/*      */             
/* 5764 */             .signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : TypePool.Default.GenericTypeExtractor.ForSignature.OfField.extract(param3String3);
/* 5765 */           this.typeAnnotationTokens = param3Map;
/* 5766 */           this.annotationTokens = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private TypePool.Default.LazyTypeDescription.LazyFieldDescription toFieldDescription(TypePool.Default.LazyTypeDescription param3LazyTypeDescription) {
/* 5776 */           param3LazyTypeDescription.getClass(); return new TypePool.Default.LazyTypeDescription.LazyFieldDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens, (byte)0);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.modifiers != ((FieldToken)param3Object).modifiers) ? false : (!this.name.equals(((FieldToken)param3Object).name) ? false : (!this.descriptor.equals(((FieldToken)param3Object).descriptor) ? false : (!this.genericSignature.equals(((FieldToken)param3Object).genericSignature) ? false : (!this.signatureResolution.equals(((FieldToken)param3Object).signatureResolution) ? false : (!this.typeAnnotationTokens.equals(((FieldToken)param3Object).typeAnnotationTokens) ? false : (!!this.annotationTokens.equals(((FieldToken)param3Object).annotationTokens))))))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((((((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.modifiers) * 31 + this.descriptor.hashCode()) * 31 + this.genericSignature.hashCode()) * 31 + this.signatureResolution.hashCode()) * 31 + this.typeAnnotationTokens.hashCode()) * 31 + this.annotationTokens.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class MethodToken
/*      */       {
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @UnknownNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod signatureResolution;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String[] exceptionName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> typeVariableBoundAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> returnTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> parameterTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> exceptionTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> receiverTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> parameterAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<ParameterToken> parameterTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @UnknownNull
/*      */         private final AnnotationValue<?, ?> defaultValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected MethodToken(String param3String1, int param3Int, String param3String2, @MaybeNull String param3String3, @MaybeNull String[] param3ArrayOfString, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map1, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param3Map, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map2, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map3, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map4, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map5, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List, Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map6, List<ParameterToken> param3List1, @MaybeNull AnnotationValue<?, ?> param3AnnotationValue) {
/* 5912 */           this.modifiers = param3Int & 0xFFFDFFFF;
/* 5913 */           this.name = param3String1;
/* 5914 */           this.descriptor = param3String2;
/* 5915 */           this.genericSignature = param3String3;
/* 5916 */           this
/*      */             
/* 5918 */             .signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : TypePool.Default.GenericTypeExtractor.ForSignature.OfMethod.extract(param3String3);
/* 5919 */           this.exceptionName = param3ArrayOfString;
/* 5920 */           this.typeVariableAnnotationTokens = param3Map1;
/* 5921 */           this.typeVariableBoundAnnotationTokens = param3Map;
/* 5922 */           this.returnTypeAnnotationTokens = param3Map2;
/* 5923 */           this.parameterTypeAnnotationTokens = param3Map3;
/* 5924 */           this.exceptionTypeAnnotationTokens = param3Map4;
/* 5925 */           this.receiverTypeAnnotationTokens = param3Map5;
/* 5926 */           this.annotationTokens = param3List;
/* 5927 */           this.parameterAnnotationTokens = param3Map6;
/* 5928 */           this.parameterTokens = param3List1;
/* 5929 */           this.defaultValue = param3AnnotationValue;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private MethodDescription.InDefinedShape toMethodDescription(TypePool.Default.LazyTypeDescription param3LazyTypeDescription) {
/* 5939 */           param3LazyTypeDescription.getClass(); return (MethodDescription.InDefinedShape)new TypePool.Default.LazyTypeDescription.LazyMethodDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.exceptionName, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens, this.returnTypeAnnotationTokens, this.parameterTypeAnnotationTokens, this.exceptionTypeAnnotationTokens, this.receiverTypeAnnotationTokens, this.annotationTokens, this.parameterAnnotationTokens, this.parameterTokens, this.defaultValue, (byte)0);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.modifiers != ((MethodToken)param3Object).modifiers) ? false : (!this.name.equals(((MethodToken)param3Object).name) ? false : (!this.descriptor.equals(((MethodToken)param3Object).descriptor) ? false : (!this.genericSignature.equals(((MethodToken)param3Object).genericSignature) ? false : (!this.signatureResolution.equals(((MethodToken)param3Object).signatureResolution) ? false : (!Arrays.equals((Object[])this.exceptionName, (Object[])((MethodToken)param3Object).exceptionName) ? false : (!this.typeVariableAnnotationTokens.equals(((MethodToken)param3Object).typeVariableAnnotationTokens) ? false : (!this.typeVariableBoundAnnotationTokens.equals(((MethodToken)param3Object).typeVariableBoundAnnotationTokens) ? false : (!this.returnTypeAnnotationTokens.equals(((MethodToken)param3Object).returnTypeAnnotationTokens) ? false : (!this.parameterTypeAnnotationTokens.equals(((MethodToken)param3Object).parameterTypeAnnotationTokens) ? false : (!this.exceptionTypeAnnotationTokens.equals(((MethodToken)param3Object).exceptionTypeAnnotationTokens) ? false : (!this.receiverTypeAnnotationTokens.equals(((MethodToken)param3Object).receiverTypeAnnotationTokens) ? false : (!this.annotationTokens.equals(((MethodToken)param3Object).annotationTokens) ? false : (!this.parameterAnnotationTokens.equals(((MethodToken)param3Object).parameterAnnotationTokens) ? false : (!this.parameterTokens.equals(((MethodToken)param3Object).parameterTokens) ? false : (!!this.defaultValue.equals(((MethodToken)param3Object).defaultValue)))))))))))))))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (((((((((((((((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.modifiers) * 31 + this.descriptor.hashCode()) * 31 + this.genericSignature.hashCode()) * 31 + this.signatureResolution.hashCode()) * 31 + Arrays.hashCode((Object[])this.exceptionName)) * 31 + this.typeVariableAnnotationTokens.hashCode()) * 31 + this.typeVariableBoundAnnotationTokens.hashCode()) * 31 + this.returnTypeAnnotationTokens.hashCode()) * 31 + this.parameterTypeAnnotationTokens.hashCode()) * 31 + this.exceptionTypeAnnotationTokens.hashCode()) * 31 + this.receiverTypeAnnotationTokens.hashCode()) * 31 + this.annotationTokens.hashCode()) * 31 + this.parameterAnnotationTokens.hashCode()) * 31 + this.parameterTokens.hashCode()) * 31 + this.defaultValue.hashCode();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         protected static class ParameterToken
/*      */         {
/*      */           @AlwaysNull
/* 5967 */           protected static final String NO_NAME = null;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @AlwaysNull
/* 5973 */           protected static final Integer NO_MODIFIERS = null;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */           private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */           private final Integer modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ParameterToken() {
/* 5993 */             this(NO_NAME);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ParameterToken(@MaybeNull String param4String) {
/* 6002 */             this(param4String, NO_MODIFIERS);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ParameterToken(@MaybeNull String param4String, @MaybeNull Integer param4Integer) {
/* 6012 */             this.name = param4String;
/* 6013 */             this.modifiers = param4Integer;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected String getName() {
/* 6023 */             return this.name;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected Integer getModifiers() {
/* 6033 */             return this.modifiers;
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             Integer integer2;
/*      */             String str2;
/*      */             if (this == param4Object)
/*      */               return true; 
/*      */             if (param4Object == null)
/*      */               return false; 
/*      */             if (getClass() != param4Object.getClass())
/*      */               return false; 
/*      */             Integer integer1 = ((ParameterToken)param4Object).modifiers;
/*      */             if (integer1 != null) {
/*      */               if ((integer2 = this.modifiers) != null) {
/*      */                 if (!integer2.equals(integer1))
/*      */                   return false; 
/*      */               } else {
/*      */                 return false;
/*      */               } 
/*      */             } else if ((integer2 = this.modifiers) != null) {
/*      */               return false;
/*      */             } 
/*      */             String str1 = ((ParameterToken)param4Object).name;
/*      */             if (str1 != null) {
/*      */               if ((str2 = this.name) != null) {
/*      */                 if (!str2.equals(str1))
/*      */                   return false; 
/*      */               } else {
/*      */                 return false;
/*      */               } 
/*      */             } else if ((str2 = this.name) != null) {
/*      */               return false;
/*      */             } 
/*      */             return true;
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             String str;
/*      */             if ((str = this.name) != null);
/*      */             Integer integer;
/*      */             if ((integer = this.modifiers) != null);
/*      */             return (getClass().hashCode() * 31 + str.hashCode()) * 31 + integer.hashCode();
/*      */           } } }
/*      */       
/*      */       @Enhance
/*      */       protected static class RecordComponentToken {
/*      */         private final String name;
/*      */         private final String descriptor;
/*      */         @UnknownNull
/*      */         private final String genericSignature;
/*      */         private final TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */         
/*      */         protected RecordComponentToken(String param3String1, String param3String2, @MaybeNull String param3String3, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List) {
/* 6089 */           this.name = param3String1;
/* 6090 */           this.descriptor = param3String2;
/* 6091 */           this.genericSignature = param3String3;
/* 6092 */           this
/*      */             
/* 6094 */             .signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : TypePool.Default.GenericTypeExtractor.ForSignature.OfRecordComponent.extract(param3String3);
/* 6095 */           this.typeAnnotationTokens = param3Map;
/* 6096 */           this.annotationTokens = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private RecordComponentDescription.InDefinedShape toRecordComponentDescription(TypePool.Default.LazyTypeDescription param3LazyTypeDescription) {
/* 6106 */           param3LazyTypeDescription.getClass(); return (RecordComponentDescription.InDefinedShape)new TypePool.Default.LazyTypeDescription.LazyRecordComponentDescription(this.name, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens, (byte)0);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.name.equals(((RecordComponentToken)param3Object).name) ? false : (!this.descriptor.equals(((RecordComponentToken)param3Object).descriptor) ? false : (!this.genericSignature.equals(((RecordComponentToken)param3Object).genericSignature) ? false : (!this.signatureResolution.equals(((RecordComponentToken)param3Object).signatureResolution) ? false : (!this.typeAnnotationTokens.equals(((RecordComponentToken)param3Object).typeAnnotationTokens) ? false : (!!this.annotationTokens.equals(((RecordComponentToken)param3Object).annotationTokens)))))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (((((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.descriptor.hashCode()) * 31 + this.genericSignature.hashCode()) * 31 + this.signatureResolution.hashCode()) * 31 + this.typeAnnotationTokens.hashCode()) * 31 + this.annotationTokens.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static class LazyAnnotationDescription
/*      */         extends AnnotationDescription.AbstractBase
/*      */       {
/*      */         protected final TypePool typePool;
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription annotationType;
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Map<String, AnnotationValue<?, ?>> values;
/*      */ 
/*      */ 
/*      */         
/*      */         private LazyAnnotationDescription(TypePool param3TypePool, TypeDescription param3TypeDescription, Map<String, AnnotationValue<?, ?>> param3Map) {
/* 6143 */           this.typePool = param3TypePool;
/* 6144 */           this.annotationType = param3TypeDescription;
/* 6145 */           this.values = param3Map;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static AnnotationList asListOfNullable(TypePool param3TypePool, @MaybeNull List<? extends TypePool.Default.LazyTypeDescription.AnnotationToken> param3List) {
/* 6158 */           return (AnnotationList)((param3List == null) ? new AnnotationList.Empty() : 
/*      */             
/* 6160 */             asList(param3TypePool, param3List));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static AnnotationList asList(TypePool param3TypePool, List<? extends TypePool.Default.LazyTypeDescription.AnnotationToken> param3List) {
/* 6172 */           ArrayList<AnnotationDescription> arrayList = new ArrayList(param3List.size());
/* 6173 */           for (Iterator<? extends TypePool.Default.LazyTypeDescription.AnnotationToken> iterator = param3List.iterator(); iterator.hasNext();) {
/*      */             
/* 6175 */             if ((resolution = TypePool.Default.LazyTypeDescription.AnnotationToken.a(annotationToken = iterator.next(), param3TypePool)).isResolved() && resolution.resolve().getAnnotationType().isAnnotation()) {
/* 6176 */               arrayList.add(resolution.resolve());
/*      */             }
/*      */           } 
/* 6179 */           return (AnnotationList)new AnnotationList.Explicit(arrayList);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape param3InDefinedShape) {
/* 6186 */           if (!param3InDefinedShape.getDeclaringType().asErasure().equals(this.annotationType)) {
/* 6187 */             throw new IllegalArgumentException(param3InDefinedShape + " is not declared by " + getAnnotationType());
/*      */           }
/*      */           AnnotationValue<?, ?> annotationValue;
/* 6190 */           if ((annotationValue = this.values.get(param3InDefinedShape.getName())) != null) {
/* 6191 */             return annotationValue.filter(param3InDefinedShape);
/*      */           }
/*      */ 
/*      */           
/* 6195 */           return (AnnotationValue<?, ?>)(((annotationValue = ((MethodDescription.InDefinedShape)((MethodList)getAnnotationType().getDeclaredMethods().filter((ElementMatcher)ElementMatchers.is(param3InDefinedShape))).getOnly()).getDefaultValue()) == null) ? new AnnotationValue.ForMissingValue(this.annotationType, param3InDefinedShape
/* 6196 */               .getName()) : annotationValue);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getAnnotationType() {
/* 6204 */           return this.annotationType;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public <T extends Annotation> Loadable<T> prepare(Class<T> param3Class) {
/* 6211 */           if (!this.annotationType.represents(param3Class)) {
/* 6212 */             throw new IllegalArgumentException(param3Class + " does not represent " + this.annotationType);
/*      */           }
/* 6214 */           return new Loadable<T>(this.typePool, param3Class, this.values, (byte)0);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private static class Loadable<S extends Annotation>
/*      */           extends LazyAnnotationDescription
/*      */           implements AnnotationDescription.Loadable<S>
/*      */         {
/*      */           private final Class<S> annotationType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private Loadable(TypePool param4TypePool, Class<S> param4Class, Map<String, AnnotationValue<?, ?>> param4Map) {
/* 6237 */             super(param4TypePool, TypeDescription.ForLoadedType.of(param4Class), param4Map, (byte)0);
/* 6238 */             this.annotationType = param4Class;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public S load() {
/* 6245 */             return (S)AnnotationDescription.AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, this.values);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static abstract class LazyAnnotationValue<U, V>
/*      */         extends AnnotationValue.AbstractBase<U, V>
/*      */       {
/*      */         private LazyAnnotationValue() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationValue.State getState() {
/* 6269 */           return doResolve().getState();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape param3InDefinedShape, TypeDefinition param3TypeDefinition) {
/* 6276 */           return doResolve().filter(param3InDefinedShape, param3TypeDefinition);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public U resolve() {
/* 6283 */           return (U)doResolve().resolve();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader param3ClassLoader) {
/* 6290 */           return doResolve().load(param3ClassLoader);
/*      */         } @Enhance("hashCode")
/*      */         public int hashCode() {
/*      */           int i;
/*      */           LazyAnnotationValue<?, ?> lazyAnnotationValue;
/*      */           int j;
/* 6296 */           if (!(i = ((j = this.hashCode) != 0) ? 0 : (lazyAnnotationValue = this).doResolve().hashCode())) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/* 6301 */           return doResolve().equals(param3Object);
/*      */         }
/*      */ 
/*      */         
/*      */         public String toString() {
/* 6306 */           return doResolve().toString();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract AnnotationValue<U, V> doResolve();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         private static class ForMismatchedType<W, X>
/*      */           extends AnnotationValue.AbstractBase<W, X>
/*      */         {
/*      */           private final String value;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final AnnotationValue.Sort sort;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private ForMismatchedType(String param4String, AnnotationValue.Sort param4Sort) {
/* 6335 */             this.value = param4String;
/* 6336 */             this.sort = param4Sort;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue.State getState() {
/* 6343 */             return AnnotationValue.State.UNRESOLVED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue.Sort getSort() {
/* 6350 */             return AnnotationValue.Sort.NONE;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue<W, X> filter(MethodDescription.InDefinedShape param4InDefinedShape, TypeDefinition param4TypeDefinition) {
/* 6357 */             return (AnnotationValue<W, X>)new AnnotationValue.ForMismatchedType(param4InDefinedShape, param4InDefinedShape.getReturnType().isArray() ? AnnotationValue.RenderingDispatcher.CURRENT
/* 6358 */                 .toArrayErrorString(this.sort) : this.value);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public W resolve() {
/* 6366 */             throw new IllegalStateException("Expected filtering of this unresolved property");
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue.Loaded<X> load(@MaybeNull ClassLoader param4ClassLoader) {
/* 6373 */             throw new IllegalStateException("Expected filtering of this unresolved property");
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.sort.equals(((ForMismatchedType)param4Object).sort) ? false : (!!this.value.equals(((ForMismatchedType)param4Object).value)))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.value.hashCode()) * 31 + this.sort.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*      */         private static class ForTypeValue
/*      */           extends LazyAnnotationValue<TypeDescription, Class<?>>
/*      */         {
/*      */           private final TypePool typePool;
/*      */           
/*      */           private final String typeName;
/*      */ 
/*      */           
/*      */           private ForTypeValue(TypePool param4TypePool, String param4String) {
/* 6398 */             super((byte)0);
/* 6399 */             this.typePool = param4TypePool;
/* 6400 */             this.typeName = param4String;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue.Sort getSort() {
/* 6407 */             return AnnotationValue.Sort.TYPE;
/*      */           }
/*      */           @Enhance("resolved")
/*      */           protected AnnotationValue<TypeDescription, Class<?>> doResolve() {
/*      */             AnnotationValue<TypeDescription, Class<?>> annotationValue;
/*      */             AnnotationValue annotationValue1;
/*      */             ForTypeValue forTypeValue;
/*      */             TypePool.Resolution resolution;
/* 6415 */             if ((forTypeValue = (ForTypeValue)(((annotationValue1 = this.resolved) != null) ? null : ((resolution = (forTypeValue = this).typePool.describe(forTypeValue.typeName)).isResolved() ? new AnnotationValue.ForTypeDescription(resolution
/* 6416 */                 .resolve()) : new AnnotationValue.ForMissingType(forTypeValue.typeName)))) == null) {
/*      */               annotationValue = this.resolved;
/*      */             } else {
/*      */               this.resolved = annotationValue;
/*      */             } 
/*      */             return annotationValue;
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private static class ForAnnotationValue
/*      */           extends LazyAnnotationValue<AnnotationDescription, Annotation>
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypePool.Default.LazyTypeDescription.AnnotationToken annotationToken;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private ForAnnotationValue(TypePool param4TypePool, TypePool.Default.LazyTypeDescription.AnnotationToken param4AnnotationToken) {
/* 6442 */             super((byte)0);
/* 6443 */             this.typePool = param4TypePool;
/* 6444 */             this.annotationToken = param4AnnotationToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue.Sort getSort() {
/* 6451 */             return AnnotationValue.Sort.ANNOTATION;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance("resolved")
/*      */           protected AnnotationValue<AnnotationDescription, Annotation> doResolve() {
/*      */             AnnotationValue<AnnotationDescription, Annotation> annotationValue;
/*      */             AnnotationValue annotationValue1;
/*      */             ForAnnotationValue forAnnotationValue;
/*      */             TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution resolution;
/* 6463 */             if ((forAnnotationValue = (ForAnnotationValue)(((annotationValue1 = this.resolved) != null) ? null : (!(resolution = TypePool.Default.LazyTypeDescription.AnnotationToken.a((forAnnotationValue = this).annotationToken, forAnnotationValue.typePool)).isResolved() ? new AnnotationValue.ForMissingType(forAnnotationValue.annotationToken.getBinaryName()) : (!resolution.resolve().getAnnotationType().isAnnotation() ? new TypePool.Default.LazyTypeDescription.LazyAnnotationValue.ForMismatchedType<Object, Object>(resolution.resolve().getAnnotationType().getName(), AnnotationValue.Sort.ANNOTATION, (byte)0) : new AnnotationValue.ForAnnotationDescription(resolution.resolve()))))) == null) { annotationValue = this.resolved; } else { this.resolved = annotationValue; }  return annotationValue;
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private static class ForEnumerationValue
/*      */           extends LazyAnnotationValue<EnumerationDescription, Enum<?>>
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String typeName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private ForEnumerationValue(TypePool param4TypePool, String param4String1, String param4String2) {
/* 6495 */             super((byte)0);
/* 6496 */             this.typePool = param4TypePool;
/* 6497 */             this.typeName = param4String1;
/* 6498 */             this.value = param4String2;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue.Sort getSort() {
/* 6505 */             return AnnotationValue.Sort.ENUMERATION;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance("resolved")
/*      */           protected AnnotationValue<EnumerationDescription, Enum<?>> doResolve() {
/*      */             AnnotationValue<EnumerationDescription, Enum<?>> annotationValue;
/*      */             ForEnumerationValue forEnumerationValue;
/*      */             AnnotationValue annotationValue1;
/*      */             TypePool.Resolution resolution;
/* 6520 */             if ((forEnumerationValue = (ForEnumerationValue)(((annotationValue1 = this.resolved) != null) ? null : (!(resolution = (forEnumerationValue = this).typePool.describe(forEnumerationValue.typeName)).isResolved() ? new AnnotationValue.ForMissingType(forEnumerationValue.typeName) : (!resolution.resolve().isEnum() ? new TypePool.Default.LazyTypeDescription.LazyAnnotationValue.ForMismatchedType<Object, Object>(forEnumerationValue.typeName + "." + forEnumerationValue.value, AnnotationValue.Sort.ENUMERATION, (byte)0) : (((FieldList)resolution.resolve().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(forEnumerationValue.value))).isEmpty() ? new AnnotationValue.ForEnumerationDescription.WithUnknownConstant(resolution.resolve(), forEnumerationValue.value) : new AnnotationValue.ForEnumerationDescription((EnumerationDescription)new EnumerationDescription.Latent(resolution.resolve(), forEnumerationValue.value))))))) == null) { annotationValue = this.resolved; } else { this.resolved = annotationValue; }  return annotationValue;
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private static class ForArray
/*      */           extends LazyAnnotationValue<Object, Object>
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypePool.AbstractBase.ComponentTypeReference componentTypeReference;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<AnnotationValue<?, ?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private ForArray(TypePool param4TypePool, TypePool.AbstractBase.ComponentTypeReference param4ComponentTypeReference, List<AnnotationValue<?, ?>> param4List) {
/* 6552 */             super((byte)0);
/* 6553 */             this.typePool = param4TypePool;
/* 6554 */             this.componentTypeReference = param4ComponentTypeReference;
/* 6555 */             this.values = param4List;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationValue.Sort getSort() {
/* 6562 */             return AnnotationValue.Sort.ARRAY;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance("resolved")
/*      */           protected AnnotationValue<Object, Object> doResolve() {
/*      */             // Byte code:
/*      */             //   0: aload_0
/*      */             //   1: getfield resolved : Lnet/bytebuddy/description/annotation/AnnotationValue;
/*      */             //   4: dup
/*      */             //   5: astore_1
/*      */             //   6: ifnull -> 13
/*      */             //   9: aconst_null
/*      */             //   10: goto -> 601
/*      */             //   13: aload_0
/*      */             //   14: dup
/*      */             //   15: astore_1
/*      */             //   16: getfield componentTypeReference : Lnet/bytebuddy/pool/TypePool$AbstractBase$ComponentTypeReference;
/*      */             //   19: invokeinterface resolve : ()Ljava/lang/String;
/*      */             //   24: dup
/*      */             //   25: astore_2
/*      */             //   26: ifnull -> 528
/*      */             //   29: aload_1
/*      */             //   30: getfield typePool : Lnet/bytebuddy/pool/TypePool;
/*      */             //   33: aload_2
/*      */             //   34: invokeinterface describe : (Ljava/lang/String;)Lnet/bytebuddy/pool/TypePool$Resolution;
/*      */             //   39: dup
/*      */             //   40: astore_3
/*      */             //   41: invokeinterface isResolved : ()Z
/*      */             //   46: ifne -> 60
/*      */             //   49: new net/bytebuddy/description/annotation/AnnotationValue$ForMissingType
/*      */             //   52: dup
/*      */             //   53: aload_2
/*      */             //   54: invokespecial <init> : (Ljava/lang/String;)V
/*      */             //   57: goto -> 601
/*      */             //   60: aload_3
/*      */             //   61: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   66: invokeinterface isEnum : ()Z
/*      */             //   71: ifeq -> 96
/*      */             //   74: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   77: dup
/*      */             //   78: ldc net/bytebuddy/description/enumeration/EnumerationDescription
/*      */             //   80: aload_3
/*      */             //   81: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   86: aload_1
/*      */             //   87: getfield values : Ljava/util/List;
/*      */             //   90: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   93: goto -> 601
/*      */             //   96: aload_3
/*      */             //   97: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   102: invokeinterface isAnnotation : ()Z
/*      */             //   107: ifeq -> 132
/*      */             //   110: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   113: dup
/*      */             //   114: ldc net/bytebuddy/description/annotation/AnnotationDescription
/*      */             //   116: aload_3
/*      */             //   117: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   122: aload_1
/*      */             //   123: getfield values : Ljava/util/List;
/*      */             //   126: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   129: goto -> 601
/*      */             //   132: aload_3
/*      */             //   133: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   138: ldc java/lang/Class
/*      */             //   140: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   145: ifeq -> 170
/*      */             //   148: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   151: dup
/*      */             //   152: ldc net/bytebuddy/description/type/TypeDescription
/*      */             //   154: aload_3
/*      */             //   155: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   160: aload_1
/*      */             //   161: getfield values : Ljava/util/List;
/*      */             //   164: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   167: goto -> 601
/*      */             //   170: aload_3
/*      */             //   171: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   176: ldc java/lang/String
/*      */             //   178: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   183: ifeq -> 208
/*      */             //   186: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   189: dup
/*      */             //   190: ldc java/lang/String
/*      */             //   192: aload_3
/*      */             //   193: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   198: aload_1
/*      */             //   199: getfield values : Ljava/util/List;
/*      */             //   202: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   205: goto -> 601
/*      */             //   208: aload_3
/*      */             //   209: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   214: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
/*      */             //   217: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   222: ifeq -> 248
/*      */             //   225: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   228: dup
/*      */             //   229: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
/*      */             //   232: aload_3
/*      */             //   233: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   238: aload_1
/*      */             //   239: getfield values : Ljava/util/List;
/*      */             //   242: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   245: goto -> 601
/*      */             //   248: aload_3
/*      */             //   249: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   254: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
/*      */             //   257: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   262: ifeq -> 288
/*      */             //   265: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   268: dup
/*      */             //   269: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
/*      */             //   272: aload_3
/*      */             //   273: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   278: aload_1
/*      */             //   279: getfield values : Ljava/util/List;
/*      */             //   282: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   285: goto -> 601
/*      */             //   288: aload_3
/*      */             //   289: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   294: getstatic java/lang/Short.TYPE : Ljava/lang/Class;
/*      */             //   297: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   302: ifeq -> 328
/*      */             //   305: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   308: dup
/*      */             //   309: getstatic java/lang/Short.TYPE : Ljava/lang/Class;
/*      */             //   312: aload_3
/*      */             //   313: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   318: aload_1
/*      */             //   319: getfield values : Ljava/util/List;
/*      */             //   322: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   325: goto -> 601
/*      */             //   328: aload_3
/*      */             //   329: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   334: getstatic java/lang/Character.TYPE : Ljava/lang/Class;
/*      */             //   337: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   342: ifeq -> 368
/*      */             //   345: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   348: dup
/*      */             //   349: getstatic java/lang/Character.TYPE : Ljava/lang/Class;
/*      */             //   352: aload_3
/*      */             //   353: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   358: aload_1
/*      */             //   359: getfield values : Ljava/util/List;
/*      */             //   362: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   365: goto -> 601
/*      */             //   368: aload_3
/*      */             //   369: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   374: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*      */             //   377: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   382: ifeq -> 408
/*      */             //   385: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   388: dup
/*      */             //   389: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*      */             //   392: aload_3
/*      */             //   393: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   398: aload_1
/*      */             //   399: getfield values : Ljava/util/List;
/*      */             //   402: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   405: goto -> 601
/*      */             //   408: aload_3
/*      */             //   409: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   414: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
/*      */             //   417: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   422: ifeq -> 448
/*      */             //   425: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   428: dup
/*      */             //   429: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
/*      */             //   432: aload_3
/*      */             //   433: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   438: aload_1
/*      */             //   439: getfield values : Ljava/util/List;
/*      */             //   442: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   445: goto -> 601
/*      */             //   448: aload_3
/*      */             //   449: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   454: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
/*      */             //   457: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   462: ifeq -> 488
/*      */             //   465: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   468: dup
/*      */             //   469: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
/*      */             //   472: aload_3
/*      */             //   473: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   478: aload_1
/*      */             //   479: getfield values : Ljava/util/List;
/*      */             //   482: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   485: goto -> 601
/*      */             //   488: aload_3
/*      */             //   489: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   494: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
/*      */             //   497: invokeinterface represents : (Ljava/lang/reflect/Type;)Z
/*      */             //   502: ifeq -> 528
/*      */             //   505: new net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray
/*      */             //   508: dup
/*      */             //   509: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
/*      */             //   512: aload_3
/*      */             //   513: invokeinterface resolve : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */             //   518: aload_1
/*      */             //   519: getfield values : Ljava/util/List;
/*      */             //   522: invokespecial <init> : (Ljava/lang/Class;Lnet/bytebuddy/description/type/TypeDescription;Ljava/util/List;)V
/*      */             //   525: goto -> 601
/*      */             //   528: getstatic net/bytebuddy/description/annotation/AnnotationValue$Sort.NONE : Lnet/bytebuddy/description/annotation/AnnotationValue$Sort;
/*      */             //   531: astore_3
/*      */             //   532: aload_1
/*      */             //   533: getfield values : Ljava/util/List;
/*      */             //   536: aload_1
/*      */             //   537: getfield values : Ljava/util/List;
/*      */             //   540: invokeinterface size : ()I
/*      */             //   545: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*      */             //   550: astore_1
/*      */             //   551: aload_1
/*      */             //   552: invokeinterface hasPrevious : ()Z
/*      */             //   557: ifeq -> 585
/*      */             //   560: aload_3
/*      */             //   561: invokevirtual isDefined : ()Z
/*      */             //   564: ifne -> 585
/*      */             //   567: aload_1
/*      */             //   568: invokeinterface previous : ()Ljava/lang/Object;
/*      */             //   573: checkcast net/bytebuddy/description/annotation/AnnotationValue
/*      */             //   576: invokeinterface getSort : ()Lnet/bytebuddy/description/annotation/AnnotationValue$Sort;
/*      */             //   581: astore_3
/*      */             //   582: goto -> 551
/*      */             //   585: new net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationValue$ForMismatchedType
/*      */             //   588: dup
/*      */             //   589: getstatic net/bytebuddy/description/annotation/AnnotationValue$RenderingDispatcher.CURRENT : Lnet/bytebuddy/description/annotation/AnnotationValue$RenderingDispatcher;
/*      */             //   592: aload_3
/*      */             //   593: invokevirtual toArrayErrorString : (Lnet/bytebuddy/description/annotation/AnnotationValue$Sort;)Ljava/lang/String;
/*      */             //   596: aload_3
/*      */             //   597: iconst_0
/*      */             //   598: invokespecial <init> : (Ljava/lang/String;Lnet/bytebuddy/description/annotation/AnnotationValue$Sort;B)V
/*      */             //   601: dup
/*      */             //   602: astore_1
/*      */             //   603: ifnonnull -> 617
/*      */             //   606: aload_0
/*      */             //   607: getfield resolved : Lnet/bytebuddy/description/annotation/AnnotationValue;
/*      */             //   610: checkcast net/bytebuddy/description/annotation/AnnotationValue
/*      */             //   613: astore_1
/*      */             //   614: goto -> 623
/*      */             //   617: aload_1
/*      */             //   618: aload_0
/*      */             //   619: swap
/*      */             //   620: putfield resolved : Lnet/bytebuddy/description/annotation/AnnotationValue;
/*      */             //   623: aload_1
/*      */             //   624: areturn
/*      */             // Line number table:
/*      */             //   Java source line number -> byte code offset
/*      */             //   #6568	-> 0
/*      */             //   #6569	-> 25
/*      */             //   #6570	-> 29
/*      */             //   #6571	-> 40
/*      */             //   #6572	-> 49
/*      */             //   #6573	-> 60
/*      */             //   #6574	-> 74
/*      */             //   #6575	-> 96
/*      */             //   #6576	-> 110
/*      */             //   #6577	-> 132
/*      */             //   #6578	-> 148
/*      */             //   #6579	-> 170
/*      */             //   #6580	-> 186
/*      */             //   #6581	-> 208
/*      */             //   #6582	-> 225
/*      */             //   #6583	-> 248
/*      */             //   #6584	-> 265
/*      */             //   #6585	-> 288
/*      */             //   #6586	-> 305
/*      */             //   #6587	-> 328
/*      */             //   #6588	-> 345
/*      */             //   #6589	-> 368
/*      */             //   #6590	-> 385
/*      */             //   #6591	-> 408
/*      */             //   #6592	-> 425
/*      */             //   #6593	-> 448
/*      */             //   #6594	-> 465
/*      */             //   #6595	-> 488
/*      */             //   #6596	-> 505
/*      */             //   #6599	-> 528
/*      */             //   #6600	-> 532
/*      */             //   #6601	-> 551
/*      */             //   #6602	-> 567
/*      */             //   #6604	-> 585
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static class LazyPackageDescription
/*      */         extends PackageDescription.AbstractBase
/*      */       {
/*      */         private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private LazyPackageDescription(TypePool param3TypePool, String param3String) {
/* 6632 */           this.typePool = param3TypePool;
/* 6633 */           this.name = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/*      */           TypePool.Resolution resolution;
/* 6641 */           if ((resolution = this.typePool.describe(this.name + ".package-info")).isResolved())
/* 6642 */             return resolution.resolve().getDeclaredAnnotations();  return (AnnotationList)new AnnotationList.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getName() {
/* 6650 */           return this.name;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class LazyTypeList
/*      */         extends TypeList.AbstractBase
/*      */       {
/*      */         private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<String> descriptors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected LazyTypeList(TypePool param3TypePool, List<String> param3List) {
/* 6676 */           this.typePool = param3TypePool;
/* 6677 */           this.descriptors = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription get(int param3Int) {
/* 6684 */           return TypePool.Default.LazyTypeDescription.TokenizedGenericType.toErasure(this.typePool, this.descriptors.get(param3Int));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/* 6691 */           return this.descriptors.size();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public String[] toInternalNames() {
/* 6699 */           String[] arrayOfString = new String[this.descriptors.size()];
/* 6700 */           byte b = 0;
/* 6701 */           for (String str : this.descriptors) {
/* 6702 */             arrayOfString[b++] = Type.getType(str).getInternalName();
/*      */           }
/* 6704 */           return (arrayOfString.length == 0) ? NO_INTERFACES : arrayOfString;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int getStackSize() {
/* 6713 */           int i = 0;
/* 6714 */           for (String str : this.descriptors) {
/* 6715 */             i += Type.getType(str).getSize();
/*      */           }
/* 6717 */           return i;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class LazyNestMemberList
/*      */         extends TypeList.AbstractBase
/*      */       {
/*      */         private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<String> nestMembers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected LazyNestMemberList(TypeDescription param3TypeDescription, TypePool param3TypePool, List<String> param3List) {
/* 6749 */           this.typeDescription = param3TypeDescription;
/* 6750 */           this.typePool = param3TypePool;
/* 6751 */           this.nestMembers = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription get(int param3Int) {
/* 6758 */           return (param3Int == 0) ? this.typeDescription : this.typePool
/*      */             
/* 6760 */             .describe(this.nestMembers.get(param3Int - 1)).resolve();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/* 6767 */           return this.nestMembers.size() + 1;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String[] toInternalNames() {
/*      */           String[] arrayOfString;
/* 6775 */           (arrayOfString = new String[this.nestMembers.size() + 1])[0] = this.typeDescription.getInternalName();
/* 6776 */           byte b = 1;
/* 6777 */           for (String str : this.nestMembers) {
/* 6778 */             arrayOfString[b++] = str.replace('.', '/');
/*      */           }
/* 6780 */           return arrayOfString;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int getStackSize() {
/* 6787 */           return this.nestMembers.size() + 1;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class TokenizedGenericType
/*      */         extends TypeDescription.Generic.LazyProjection.WithEagerNavigation
/*      */       {
/*      */         private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.LazyTypeDescription.GenericTypeToken genericTypeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String rawTypeDescriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected TokenizedGenericType(TypePool param3TypePool, TypePool.Default.LazyTypeDescription.GenericTypeToken param3GenericTypeToken, String param3String, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, TypeVariableSource param3TypeVariableSource) {
/* 6835 */           this.typePool = param3TypePool;
/* 6836 */           this.genericTypeToken = param3GenericTypeToken;
/* 6837 */           this.rawTypeDescriptor = param3String;
/* 6838 */           this.annotationTokens = param3Map;
/* 6839 */           this.typeVariableSource = param3TypeVariableSource;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static TypeDescription.Generic of(TypePool param3TypePool, TypePool.Default.LazyTypeDescription.GenericTypeToken param3GenericTypeToken, String param3String, @MaybeNull Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, TypeVariableSource param3TypeVariableSource) {
/* 6857 */           return (TypeDescription.Generic)new TokenizedGenericType(param3TypePool, param3GenericTypeToken, param3String, (param3Map == null) ? 
/*      */ 
/*      */ 
/*      */               
/* 6861 */               Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : param3Map, param3TypeVariableSource);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static TypeDescription toErasure(TypePool param3TypePool, String param3String) {
/* 6874 */           Type type = Type.getType(param3String);
/* 6875 */           return param3TypePool.describe((type.getSort() == 9) ? type
/* 6876 */               .getInternalName().replace('/', '.') : type
/* 6877 */               .getClassName()).resolve();
/*      */         } @Enhance("resolved")
/*      */         protected TypeDescription.Generic resolve() {
/*      */           TokenizedGenericType tokenizedGenericType;
/*      */           TypeDescription.Generic generic2;
/*      */           TypeDescription.Generic generic1;
/* 6883 */           if ((generic1 = (TypeDescription.Generic)(((generic2 = this.resolved) != null) ? null : (tokenizedGenericType = this).genericTypeToken.toGenericType(tokenizedGenericType.typePool, tokenizedGenericType.typeVariableSource, "", tokenizedGenericType.annotationTokens))) == null) { generic1 = this.resolved; } else { this.resolved = generic1; }  return generic1;
/*      */         }
/*      */         
/*      */         @Enhance("erasure")
/*      */         public TypeDescription asErasure() {
/*      */           TokenizedGenericType tokenizedGenericType;
/*      */           TypeDescription typeDescription1;
/*      */           TypeDescription typeDescription2;
/* 6891 */           if ((typeDescription1 = (TypeDescription)(((typeDescription2 = this.erasure) != null) ? null : toErasure((tokenizedGenericType = this).typePool, tokenizedGenericType.rawTypeDescriptor))) == null) { typeDescription1 = this.erasure; } else { this.erasure = typeDescription1; }  return typeDescription1;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 6898 */           return resolve().getDeclaredAnnotations();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class TokenList
/*      */           extends TypeList.Generic.AbstractBase
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken> genericTypeTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<String> rawTypeDescriptors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private TokenList(TypePool param4TypePool, List<TypePool.Default.LazyTypeDescription.GenericTypeToken> param4List, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param4Map, List<String> param4List1, TypeVariableSource param4TypeVariableSource) {
/* 6945 */             this.typePool = param4TypePool;
/* 6946 */             this.genericTypeTokens = param4List;
/* 6947 */             this.annotationTokens = param4Map;
/* 6948 */             this.rawTypeDescriptors = param4List1;
/* 6949 */             this.typeVariableSource = param4TypeVariableSource;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic get(int param4Int) {
/* 6956 */             if (this.rawTypeDescriptors.size() == this.genericTypeTokens.size())
/* 6957 */               return TypePool.Default.LazyTypeDescription.TokenizedGenericType.of(this.typePool, this.genericTypeTokens.get(param4Int), this.rawTypeDescriptors.get(param4Int), this.annotationTokens.get(Integer.valueOf(param4Int)), this.typeVariableSource); 
/* 6958 */             return TypePool.Default.LazyTypeDescription.TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptors.get(param4Int)).asGenericType();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int size() {
/* 6965 */             return this.rawTypeDescriptors.size();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList asErasures() {
/* 6972 */             return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.rawTypeDescriptors);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class TypeVariableList
/*      */           extends TypeList.Generic.AbstractBase
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> boundAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected TypeVariableList(TypePool param4TypePool, List<TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> param4List, TypeVariableSource param4TypeVariableSource, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param4Map, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param4Map1) {
/* 7021 */             this.typePool = param4TypePool;
/* 7022 */             this.typeVariables = param4List;
/* 7023 */             this.typeVariableSource = param4TypeVariableSource;
/* 7024 */             this.annotationTokens = param4Map;
/* 7025 */             this.boundAnnotationTokens = param4Map1;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic get(int param4Int) {
/* 7032 */             return ((TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable)this.typeVariables.get(param4Int)).toGenericType(this.typePool, this.typeVariableSource, this.annotationTokens.get(Integer.valueOf(param4Int)), this.boundAnnotationTokens.get(Integer.valueOf(param4Int)));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int size() {
/* 7039 */             return this.typeVariables.size();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class Malformed
/*      */           extends TypeDescription.Generic.LazyProjection.WithEagerNavigation
/*      */         {
/*      */           private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String rawTypeDescriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Malformed(TypePool param4TypePool, String param4String) {
/* 7065 */             this.typePool = param4TypePool;
/* 7066 */             this.rawTypeDescriptor = param4String;
/*      */           }
/*      */ 
/*      */           
/*      */           protected TypeDescription.Generic resolve() {
/* 7071 */             throw new GenericSignatureFormatError();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription asErasure() {
/* 7078 */             return TypePool.Default.LazyTypeDescription.TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptor);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/* 7085 */             throw new GenericSignatureFormatError();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class TokenList
/*      */             extends TypeList.Generic.AbstractBase
/*      */           {
/*      */             private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final List<String> rawTypeDescriptors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected TokenList(TypePool param5TypePool, List<String> param5List) {
/* 7110 */               this.typePool = param5TypePool;
/* 7111 */               this.rawTypeDescriptors = param5List;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic get(int param5Int) {
/* 7118 */               return (TypeDescription.Generic)new TypePool.Default.LazyTypeDescription.TokenizedGenericType.Malformed(this.typePool, this.rawTypeDescriptors.get(param5Int));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int size() {
/* 7125 */               return this.rawTypeDescriptors.size();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList asErasures() {
/* 7132 */               return (TypeList)new TypePool.Default.LazyTypeDescription.LazyTypeList(this.typePool, this.rawTypeDescriptors);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private class LazyFieldDescription
/*      */         extends FieldDescription.InDefinedShape.AbstractBase
/*      */       {
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField signatureResolution;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private LazyFieldDescription(TypePool.Default.LazyTypeDescription this$0, String param3String1, int param3Int, @MaybeNull String param3String2, String param3String3, TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField param3ForField, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List) {
/* 7198 */           this.modifiers = param3Int;
/* 7199 */           this.name = param3String1;
/* 7200 */           this.descriptor = param3String2;
/* 7201 */           this.genericSignature = param3String3;
/* 7202 */           this.signatureResolution = param3ForField;
/* 7203 */           this.typeAnnotationTokens = param3Map;
/* 7204 */           this.annotationTokens = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getType() {
/* 7211 */           return this.signatureResolution.resolveFieldType(this.descriptor, TypePool.Default.LazyTypeDescription.d(this.a), this.typeAnnotationTokens, (FieldDescription.InDefinedShape)this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 7218 */           return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(TypePool.Default.LazyTypeDescription.d(this.a), this.annotationTokens);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getName() {
/* 7225 */           return this.name;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getDeclaringType() {
/* 7233 */           return (TypeDescription)this.a;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int getModifiers() {
/* 7240 */           return this.modifiers;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public String getGenericSignature() {
/* 7248 */           return this.genericSignature;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private class LazyMethodDescription
/*      */         extends MethodDescription.InDefinedShape.AbstractBase
/*      */       {
/*      */         private final String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String returnTypeDescriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod signatureResolution;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<String> parameterTypeDescriptors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<String> exceptionTypeDescriptors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> typeVariableBoundAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> returnTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> parameterTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> exceptionTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> receiverTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> parameterAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String[] parameterNames;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Integer[] parameterModifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final AnnotationValue<?, ?> defaultValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private LazyMethodDescription(TypePool.Default.LazyTypeDescription this$0, String param3String1, int param3Int, @MaybeNull String param3String2, String param3String3, @MaybeNull TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod param3ForMethod, String[] param3ArrayOfString, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map1, Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> param3Map, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map2, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map3, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> param3Map4, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map5, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List, Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map6, @MaybeNull List<TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken> param3List1, AnnotationValue<?, ?> param3AnnotationValue) {
/* 7392 */           this.modifiers = param3Int;
/* 7393 */           this.internalName = param3String1;
/*      */           
/* 7395 */           Type type1, type2 = (type1 = Type.getMethodType(param3String2)).getReturnType();
/* 7396 */           Type[] arrayOfType1 = type1.getArgumentTypes();
/* 7397 */           this.returnTypeDescriptor = type2.getDescriptor();
/* 7398 */           this.parameterTypeDescriptors = new ArrayList<String>(arrayOfType1.length); Type[] arrayOfType2; byte b;
/* 7399 */           for (param3Int = (arrayOfType2 = arrayOfType1).length, b = 0; b < param3Int; ) { Type type = arrayOfType2[b];
/* 7400 */             this.parameterTypeDescriptors.add(type.getDescriptor()); b++; }
/*      */           
/* 7402 */           this.genericSignature = param3String3;
/* 7403 */           this.signatureResolution = param3ForMethod;
/* 7404 */           if (param3ArrayOfString == null) {
/* 7405 */             this.exceptionTypeDescriptors = Collections.emptyList();
/*      */           } else {
/* 7407 */             this.exceptionTypeDescriptors = new ArrayList<String>(param3ArrayOfString.length); String[] arrayOfString;
/* 7408 */             for (param3Int = (arrayOfString = param3ArrayOfString).length, b = 0; b < param3Int; ) { String str = arrayOfString[b];
/* 7409 */               this.exceptionTypeDescriptors.add(Type.getObjectType(str).getDescriptor()); b++; }
/*      */           
/*      */           } 
/* 7412 */           this.typeVariableAnnotationTokens = param3Map1;
/* 7413 */           this.typeVariableBoundAnnotationTokens = param3Map;
/* 7414 */           this.returnTypeAnnotationTokens = param3Map2;
/* 7415 */           this.parameterTypeAnnotationTokens = param3Map3;
/* 7416 */           this.exceptionTypeAnnotationTokens = param3Map4;
/* 7417 */           this.receiverTypeAnnotationTokens = param3Map5;
/* 7418 */           this.annotationTokens = param3List;
/* 7419 */           this.parameterAnnotationTokens = param3Map6;
/* 7420 */           this.parameterNames = new String[arrayOfType1.length];
/* 7421 */           this.parameterModifiers = new Integer[arrayOfType1.length];
/* 7422 */           if (param3List1.size() == arrayOfType1.length) {
/* 7423 */             byte b1 = 0;
/* 7424 */             for (TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken parameterToken : param3List1) {
/* 7425 */               this.parameterNames[b1] = parameterToken.getName();
/* 7426 */               this.parameterModifiers[b1] = parameterToken.getModifiers();
/* 7427 */               b1++;
/*      */             } 
/*      */           } 
/* 7430 */           this.defaultValue = param3AnnotationValue;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getReturnType() {
/* 7437 */           return this.signatureResolution.resolveReturnType(this.returnTypeDescriptor, TypePool.Default.LazyTypeDescription.d(this.a), this.returnTypeAnnotationTokens, (MethodDescription.InDefinedShape)this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getExceptionTypes() {
/* 7444 */           return this.signatureResolution.resolveExceptionTypes(this.exceptionTypeDescriptors, TypePool.Default.LazyTypeDescription.d(this.a), this.exceptionTypeAnnotationTokens, (MethodDescription.InDefinedShape)this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 7451 */           return (ParameterList<ParameterDescription.InDefinedShape>)new LazyParameterList((byte)0);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 7458 */           return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asList(TypePool.Default.LazyTypeDescription.d(this.a), this.annotationTokens);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getInternalName() {
/* 7465 */           return this.internalName;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getDeclaringType() {
/* 7473 */           return (TypeDescription)this.a;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int getModifiers() {
/* 7480 */           return this.modifiers;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getTypeVariables() {
/* 7487 */           return this.signatureResolution.resolveTypeVariables(TypePool.Default.LazyTypeDescription.d(this.a), (TypeVariableSource)this, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public AnnotationValue<?, ?> getDefaultValue() {
/* 7495 */           return this.defaultValue;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public TypeDescription.Generic getReceiverType() {
/* 7503 */           if (isStatic())
/* 7504 */             return TypeDescription.Generic.UNDEFINED; 
/* 7505 */           if (isConstructor()) {
/*      */             TypeDescription typeDescription1; TypeDescription typeDescription2;
/* 7507 */             if ((typeDescription2 = (typeDescription1 = getDeclaringType()).getEnclosingType()) == null) {
/* 7508 */               return (TypeDescription.Generic)(typeDescription1.isGenerified() ? new LazyParameterizedReceiverType(typeDescription1) : new LazyNonGenericReceiverType(typeDescription1));
/*      */             }
/*      */ 
/*      */             
/* 7512 */             return (TypeDescription.Generic)((!typeDescription1.isStatic() && typeDescription1.isGenerified()) ? new LazyParameterizedReceiverType(typeDescription2) : new LazyNonGenericReceiverType(typeDescription2));
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 7517 */           return (TypeDescription.Generic)(this.a.isGenerified() ? new LazyParameterizedReceiverType() : new LazyNonGenericReceiverType());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public String getGenericSignature() {
/* 7528 */           return this.genericSignature;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         private class LazyParameterList
/*      */           extends ParameterList.AbstractBase<ParameterDescription.InDefinedShape>
/*      */         {
/*      */           private LazyParameterList(TypePool.Default.LazyTypeDescription.LazyMethodDescription this$0) {}
/*      */ 
/*      */           
/*      */           public ParameterDescription.InDefinedShape get(int param4Int) {
/* 7540 */             return (ParameterDescription.InDefinedShape)new TypePool.Default.LazyTypeDescription.LazyMethodDescription.LazyParameterDescription(this.a, param4Int);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean hasExplicitMetaData() {
/* 7547 */             for (byte b = 0; b < size(); b++) {
/* 7548 */               if (TypePool.Default.LazyTypeDescription.LazyMethodDescription.a(this.a)[b] == null || TypePool.Default.LazyTypeDescription.LazyMethodDescription.b(this.a)[b] == null) {
/* 7549 */                 return false;
/*      */               }
/*      */             } 
/* 7552 */             return true;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int size() {
/* 7559 */             return TypePool.Default.LazyTypeDescription.LazyMethodDescription.c(this.a).size();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic asTypeList() {
/* 7566 */             return TypePool.Default.LazyTypeDescription.LazyMethodDescription.e(this.a).resolveParameterTypes(TypePool.Default.LazyTypeDescription.LazyMethodDescription.c(this.a), TypePool.Default.LazyTypeDescription.d(this.a.a), TypePool.Default.LazyTypeDescription.LazyMethodDescription.d(this.a), (MethodDescription.InDefinedShape)this.a);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private class LazyParameterDescription
/*      */           extends ParameterDescription.InDefinedShape.AbstractBase
/*      */         {
/*      */           private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected LazyParameterDescription(TypePool.Default.LazyTypeDescription.LazyMethodDescription this$0, int param4Int) {
/* 7586 */             this.index = param4Int;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription.InDefinedShape getDeclaringMethod() {
/* 7593 */             return (MethodDescription.InDefinedShape)this.a;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int getIndex() {
/* 7600 */             return this.index;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isNamed() {
/* 7607 */             return (TypePool.Default.LazyTypeDescription.LazyMethodDescription.a(this.a)[this.index] != null);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean hasModifiers() {
/* 7614 */             return (TypePool.Default.LazyTypeDescription.LazyMethodDescription.b(this.a)[this.index] != null);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getName() {
/* 7621 */             if (isNamed())
/* 7622 */               return TypePool.Default.LazyTypeDescription.LazyMethodDescription.a(this.a)[this.index];  return super
/* 7623 */               .getName();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int getModifiers() {
/* 7630 */             if (hasModifiers())
/* 7631 */               return TypePool.Default.LazyTypeDescription.LazyMethodDescription.b(this.a)[this.index].intValue();  return super
/* 7632 */               .getModifiers();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic getType() {
/* 7639 */             return (TypeDescription.Generic)TypePool.Default.LazyTypeDescription.LazyMethodDescription.e(this.a).resolveParameterTypes(TypePool.Default.LazyTypeDescription.LazyMethodDescription.c(this.a), TypePool.Default.LazyTypeDescription.d(this.a.a), TypePool.Default.LazyTypeDescription.LazyMethodDescription.d(this.a), (MethodDescription.InDefinedShape)this.a).get(this.index);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/* 7646 */             return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(TypePool.Default.LazyTypeDescription.d(this.a.a), (List<? extends TypePool.Default.LazyTypeDescription.AnnotationToken>)TypePool.Default.LazyTypeDescription.LazyMethodDescription.f(this.a).get(Integer.valueOf(this.index)));
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private class LazyParameterizedReceiverType
/*      */           extends TypeDescription.Generic.OfParameterizedType
/*      */         {
/*      */           private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected LazyParameterizedReceiverType() {
/* 7664 */             this((TypeDescription)TypePool.Default.LazyTypeDescription.LazyMethodDescription.this.a);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected LazyParameterizedReceiverType(TypeDescription param4TypeDescription) {
/* 7673 */             this.typeDescription = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic getTypeArguments() {
/* 7680 */             return (TypeList.Generic)new TypeArgumentList(this, (List<? extends TypeDescription.Generic>)this.typeDescription.getTypeVariables());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public TypeDescription.Generic getOwnerType() {
/*      */             TypeDescription typeDescription;
/* 7689 */             if ((typeDescription = this.typeDescription.getDeclaringType()) == null) {
/* 7690 */               return TypeDescription.Generic.UNDEFINED;
/*      */             }
/* 7692 */             return (TypeDescription.Generic)((!this.typeDescription.isStatic() && typeDescription.isGenerified()) ? new LazyParameterizedReceiverType(typeDescription) : new TypePool.Default.LazyTypeDescription.LazyMethodDescription.LazyNonGenericReceiverType(typeDescription));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/* 7702 */             return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(TypePool.Default.LazyTypeDescription.d(this.a.a), (List<? extends TypePool.Default.LazyTypeDescription.AnnotationToken>)TypePool.Default.LazyTypeDescription.LazyMethodDescription.g(this.a).get(getTypePath()));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private String getTypePath() {
/* 7711 */             StringBuilder stringBuilder = new StringBuilder();
/* 7712 */             for (byte b = 0; b < this.typeDescription.getInnerClassCount(); b++) {
/* 7713 */               stringBuilder = stringBuilder.append('.');
/*      */             }
/* 7715 */             return stringBuilder.toString();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription asErasure() {
/* 7722 */             return this.typeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected class TypeArgumentList
/*      */             extends TypeList.Generic.AbstractBase
/*      */           {
/*      */             private final List<? extends TypeDescription.Generic> typeVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected TypeArgumentList(TypePool.Default.LazyTypeDescription.LazyMethodDescription.LazyParameterizedReceiverType this$0, List<? extends TypeDescription.Generic> param5List) {
/* 7741 */               this.typeVariables = param5List;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic get(int param5Int) {
/* 7748 */               return (TypeDescription.Generic)new AnnotatedTypeVariable(this, this.typeVariables.get(param5Int), param5Int);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int size() {
/* 7755 */               return this.typeVariables.size();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected class AnnotatedTypeVariable
/*      */               extends TypeDescription.Generic.OfTypeVariable
/*      */             {
/*      */               private final TypeDescription.Generic typeVariable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected AnnotatedTypeVariable(TypePool.Default.LazyTypeDescription.LazyMethodDescription.LazyParameterizedReceiverType.TypeArgumentList this$0, TypeDescription.Generic param6Generic, int param6Int) {
/* 7780 */                 this.typeVariable = param6Generic;
/* 7781 */                 this.index = param6Int;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public TypeList.Generic getUpperBounds() {
/* 7788 */                 return this.typeVariable.getUpperBounds();
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public TypeVariableSource getTypeVariableSource() {
/* 7795 */                 return this.typeVariable.getTypeVariableSource();
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public String getSymbol() {
/* 7802 */                 return this.typeVariable.getSymbol();
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public AnnotationList getDeclaredAnnotations() {
/* 7809 */                 return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(TypePool.Default.LazyTypeDescription.d(this.a.a.a.a), (List<? extends TypePool.Default.LazyTypeDescription.AnnotationToken>)TypePool.Default.LazyTypeDescription.LazyMethodDescription.g(this.a.a.a).get(TypePool.Default.LazyTypeDescription.LazyMethodDescription.LazyParameterizedReceiverType.a(this.a.a) + this.index + ';'));
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected class LazyNonGenericReceiverType
/*      */           extends TypeDescription.Generic.OfNonGenericType
/*      */         {
/*      */           private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected LazyNonGenericReceiverType() {
/* 7831 */             this((TypeDescription)TypePool.Default.LazyTypeDescription.LazyMethodDescription.this.a);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected LazyNonGenericReceiverType(TypeDescription param4TypeDescription) {
/* 7840 */             this.typeDescription = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public TypeDescription.Generic getOwnerType() {
/*      */             TypeDescription typeDescription;
/* 7849 */             return (TypeDescription.Generic)(((typeDescription = this.typeDescription.getDeclaringType()) == null) ? TypeDescription.Generic.UNDEFINED : new LazyNonGenericReceiverType(typeDescription));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public TypeDescription.Generic getComponentType() {
/* 7859 */             return TypeDescription.Generic.UNDEFINED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/* 7866 */             StringBuilder stringBuilder = new StringBuilder();
/* 7867 */             for (byte b = 0; b < this.typeDescription.getInnerClassCount(); b++) {
/* 7868 */               stringBuilder = stringBuilder.append('.');
/*      */             }
/* 7870 */             return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asListOfNullable(TypePool.Default.LazyTypeDescription.d(this.a.a), (List<? extends TypePool.Default.LazyTypeDescription.AnnotationToken>)TypePool.Default.LazyTypeDescription.LazyMethodDescription.g(this.a).get(stringBuilder.toString()));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription asErasure() {
/* 7877 */             return this.typeDescription;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private class LazyRecordComponentDescription
/*      */         extends RecordComponentDescription.InDefinedShape.AbstractBase
/*      */       {
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private LazyRecordComponentDescription(TypePool.Default.LazyTypeDescription this$0, String param3String1, @MaybeNull String param3String2, String param3String3, TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent param3ForRecordComponent, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List) {
/* 7934 */           this.name = param3String1;
/* 7935 */           this.descriptor = param3String2;
/* 7936 */           this.genericSignature = param3String3;
/* 7937 */           this.signatureResolution = param3ForRecordComponent;
/* 7938 */           this.typeAnnotationTokens = param3Map;
/* 7939 */           this.annotationTokens = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getType() {
/* 7946 */           return this.signatureResolution.resolveRecordType(this.descriptor, TypePool.Default.LazyTypeDescription.d(this.a), this.typeAnnotationTokens, (RecordComponentDescription.InDefinedShape)this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getDeclaringType() {
/* 7954 */           return (TypeDescription)this.a;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getActualName() {
/* 7961 */           return this.name;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 7968 */           return TypePool.Default.LazyTypeDescription.LazyAnnotationDescription.asList(TypePool.Default.LazyTypeDescription.d(this.a), this.annotationTokens);
/*      */         }
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public String getGenericSignature() {
/* 7974 */           return this.genericSignature;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected class TypeExtractor
/*      */       extends ClassVisitor
/*      */     {
/*      */       private static final int SUPER_CLASS_INDEX = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final int REAL_MODIFIER_MASK = 65535;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> superTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> typeVariableBoundsAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<TypePool.Default.LazyTypeDescription.FieldToken> fieldTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<TypePool.Default.LazyTypeDescription.MethodToken> methodTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<TypePool.Default.LazyTypeDescription.RecordComponentToken> recordComponentTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int actualModifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private String superClassName;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private String[] interfaceName;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private boolean anonymousType;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private String nestHost;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<String> nestMembers;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private TypePool.Default.LazyTypeDescription.TypeContainment typeContainment;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private String declaringTypeName;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<String> declaredTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<String> permittedSubclasses;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private ClassFileVersion classFileVersion;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected TypeExtractor(TypePool.Default this$0) {
/* 8111 */         super(OpenedClassReader.ASM_API);
/* 8112 */         this.superTypeAnnotationTokens = new HashMap<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>();
/* 8113 */         this.typeVariableAnnotationTokens = new HashMap<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>();
/* 8114 */         this.typeVariableBoundsAnnotationTokens = new HashMap<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>>();
/* 8115 */         this.annotationTokens = new ArrayList<TypePool.Default.LazyTypeDescription.AnnotationToken>();
/* 8116 */         this.fieldTokens = new ArrayList<TypePool.Default.LazyTypeDescription.FieldToken>();
/* 8117 */         this.methodTokens = new ArrayList<TypePool.Default.LazyTypeDescription.MethodToken>();
/* 8118 */         this.recordComponentTokens = new ArrayList<TypePool.Default.LazyTypeDescription.RecordComponentToken>();
/* 8119 */         this.anonymousType = false;
/* 8120 */         this.typeContainment = TypePool.Default.LazyTypeDescription.TypeContainment.SelfContained.INSTANCE;
/* 8121 */         this.nestMembers = new ArrayList<String>();
/* 8122 */         this.declaredTypes = new ArrayList<String>();
/* 8123 */         this.permittedSubclasses = new ArrayList<String>();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not modified by class contract.")
/*      */       public void visit(int param2Int1, int param2Int2, String param2String1, @MaybeNull String param2String2, @MaybeNull String param2String3, @MaybeNull String[] param2ArrayOfString) {
/* 8134 */         this.modifiers = param2Int2 & 0xFFFF;
/* 8135 */         this.actualModifiers = param2Int2;
/* 8136 */         this.internalName = param2String1;
/* 8137 */         this.genericSignature = param2String2;
/* 8138 */         this.superClassName = param2String3;
/* 8139 */         this.interfaceName = param2ArrayOfString;
/* 8140 */         this.classFileVersion = ClassFileVersion.ofMinorMajor(param2Int1);
/*      */       }
/*      */ 
/*      */       
/*      */       public void visitOuterClass(@MaybeNull String param2String1, @MaybeNull String param2String2, String param2String3) {
/* 8145 */         if (param2String2 != null && !param2String2.equals("<clinit>")) {
/* 8146 */           this.typeContainment = new TypePool.Default.LazyTypeDescription.TypeContainment.WithinMethod(param2String1, param2String2, param2String3); return;
/* 8147 */         }  if (param2String1 != null) {
/* 8148 */           this.typeContainment = new TypePool.Default.LazyTypeDescription.TypeContainment.WithinType(param2String1, true);
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       public void visitInnerClass(String param2String1, @MaybeNull String param2String2, @MaybeNull String param2String3, int param2Int) {
/* 8154 */         if (param2String1.equals(this.internalName)) {
/* 8155 */           if (param2String2 != null) {
/* 8156 */             this.declaringTypeName = param2String2;
/* 8157 */             if (this.typeContainment.isSelfContained()) {
/* 8158 */               this.typeContainment = new TypePool.Default.LazyTypeDescription.TypeContainment.WithinType(param2String2, false);
/*      */             }
/*      */           } 
/* 8161 */           if (param2String3 == null && !this.typeContainment.isSelfContained()) {
/* 8162 */             this.anonymousType = true;
/*      */           }
/* 8164 */           this.modifiers = param2Int & 0xFFFF; return;
/* 8165 */         }  if (param2String2 != null && param2String3 != null && param2String2.equals(this.internalName)) {
/* 8166 */           this.declaredTypes.add("L" + param2String1 + ";");
/*      */         }
/*      */       }
/*      */       
/*      */       public AnnotationVisitor visitTypeAnnotation(int param2Int, @MaybeNull TypePath param2TypePath, String param2String, boolean param2Boolean) {
/*      */         TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex withIndex;
/*      */         TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed doubleIndexed;
/*      */         TypeReference typeReference;
/* 8174 */         switch ((typeReference = new TypeReference(param2Int)).getSort()) {
/*      */ 
/*      */           
/*      */           case 16:
/* 8178 */             withIndex = new TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex(param2String, param2TypePath, typeReference.getSuperTypeIndex(), this.superTypeAnnotationTokens);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 8197 */             return new AnnotationExtractor(withIndex, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a, param2String));case 0: withIndex = new TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex(param2String, param2TypePath, withIndex.getTypeParameterIndex(), this.typeVariableAnnotationTokens); return new AnnotationExtractor(withIndex, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a, param2String));case 17: doubleIndexed = new TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed(param2String, param2TypePath, withIndex.getTypeParameterBoundIndex(), withIndex.getTypeParameterIndex(), this.typeVariableBoundsAnnotationTokens); return new AnnotationExtractor(doubleIndexed, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a, param2String));
/*      */         } 
/*      */         throw new IllegalArgumentException("Unexpected type reference: " + doubleIndexed.getSort());
/*      */       }
/*      */       public AnnotationVisitor visitAnnotation(String param2String, boolean param2Boolean) {
/* 8202 */         return new AnnotationExtractor(param2String, this.annotationTokens, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a, param2String));
/*      */       }
/*      */ 
/*      */       
/*      */       public FieldVisitor visitField(int param2Int, String param2String1, String param2String2, @MaybeNull String param2String3, @MaybeNull Object param2Object) {
/* 8207 */         return new FieldExtractor(this, param2Int & 0xFFFF, param2String1, param2String2, param2String3);
/*      */       }
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public MethodVisitor visitMethod(int param2Int, String param2String1, String param2String2, @MaybeNull String param2String3, @MaybeNull String[] param2ArrayOfString) {
/* 8213 */         if (param2String1.equals("<clinit>"))
/* 8214 */           return TypePool.Default.a();  return new MethodExtractor(this, param2Int & 0xFFFF, param2String1, param2String2, param2String3, param2ArrayOfString);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void visitNestHost(String param2String) {
/* 8220 */         this.nestHost = param2String;
/*      */       }
/*      */ 
/*      */       
/*      */       public void visitNestMember(String param2String) {
/* 8225 */         this.nestMembers.add(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       public RecordComponentVisitor visitRecordComponent(String param2String1, String param2String2, @MaybeNull String param2String3) {
/* 8230 */         return new RecordComponentExtractor(this, param2String1, param2String2, param2String3);
/*      */       }
/*      */ 
/*      */       
/*      */       public void visitPermittedSubclass(String param2String) {
/* 8235 */         this.permittedSubclasses.add(param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected TypeDescription toTypeDescription() {
/* 8245 */         if (this.internalName == null || this.classFileVersion == null) {
/* 8246 */           throw new IllegalStateException("Internal name or class file version were not set");
/*      */         }
/* 8248 */         Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> map = this.superTypeAnnotationTokens.remove(Integer.valueOf(-1));
/* 8249 */         return (TypeDescription)new TypePool.Default.LazyTypeDescription(this.a, this.actualModifiers, this.modifiers, this.internalName, this.superClassName, this.interfaceName, this.genericSignature, this.typeContainment, this.declaringTypeName, this.declaredTypes, this.anonymousType, this.nestHost, this.nestMembers, (map == null) ? 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 8263 */             Collections.<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>emptyMap() : map, this.superTypeAnnotationTokens, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens, this.annotationTokens, this.fieldTokens, this.methodTokens, this.recordComponentTokens, this.permittedSubclasses, this.classFileVersion);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected class AnnotationExtractor
/*      */         extends AnnotationVisitor
/*      */       {
/*      */         private final TypePool.Default.AnnotationRegistrant annotationRegistrant;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.ComponentTypeLocator componentTypeLocator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AnnotationExtractor(String param3String, List<TypePool.Default.LazyTypeDescription.AnnotationToken> param3List, TypePool.Default.ComponentTypeLocator param3ComponentTypeLocator) {
/* 8300 */           this(new TypePool.Default.AnnotationRegistrant.ForByteCodeElement(param3String, param3List), param3ComponentTypeLocator);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AnnotationExtractor(String param3String, int param3Int, Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> param3Map, TypePool.Default.ComponentTypeLocator param3ComponentTypeLocator) {
/* 8315 */           this(new TypePool.Default.AnnotationRegistrant.ForByteCodeElement.WithIndex(param3String, param3Int, param3Map), param3ComponentTypeLocator);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AnnotationExtractor(TypePool.Default.AnnotationRegistrant param3AnnotationRegistrant, TypePool.Default.ComponentTypeLocator param3ComponentTypeLocator) {
/* 8325 */           super(OpenedClassReader.ASM_API);
/* 8326 */           this.annotationRegistrant = param3AnnotationRegistrant;
/* 8327 */           this.componentTypeLocator = param3ComponentTypeLocator;
/*      */         }
/*      */ 
/*      */         
/*      */         public void visit(String param3String, Object param3Object) {
/* 8332 */           if (param3Object instanceof Type) {
/* 8333 */             param3Object = param3Object;
/* 8334 */             this.annotationRegistrant.register(param3String, (AnnotationValue<?, ?>)new TypePool.Default.LazyTypeDescription.LazyAnnotationValue.ForTypeValue(this.a.a, (param3Object.getSort() == 9) ? param3Object
/* 8335 */                   .getInternalName().replace('/', '.') : param3Object
/* 8336 */                   .getClassName(), (byte)0)); return;
/*      */           } 
/* 8338 */           this.annotationRegistrant.register(param3String, AnnotationValue.ForConstant.of(param3Object));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitEnum(String param3String1, String param3String2, String param3String3) {
/* 8344 */           this.annotationRegistrant.register(param3String1, (AnnotationValue<?, ?>)new TypePool.Default.LazyTypeDescription.LazyAnnotationValue.ForEnumerationValue(this.a.a, param3String2
/* 8345 */                 .substring(1, param3String2.length() - 1).replace('/', '.'), param3String3, (byte)0));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationVisitor visitAnnotation(String param3String1, String param3String2) {
/* 8351 */           return new AnnotationExtractor(new AnnotationLookup(this, param3String2, param3String1), new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String2));
/*      */         }
/*      */ 
/*      */         
/*      */         public AnnotationVisitor visitArray(String param3String) {
/* 8356 */           return new AnnotationExtractor(new ArrayLookup(param3String, this.componentTypeLocator.bind(param3String), (byte)0), TypePool.Default.ComponentTypeLocator.Illegal.INSTANCE);
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitEnd() {
/* 8361 */           this.annotationRegistrant.onComplete();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected class ArrayLookup
/*      */           implements TypePool.Default.AnnotationRegistrant
/*      */         {
/*      */           private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypePool.AbstractBase.ComponentTypeReference componentTypeReference;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final List<AnnotationValue<?, ?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private ArrayLookup(TypePool.Default.TypeExtractor.AnnotationExtractor this$0, String param4String, TypePool.AbstractBase.ComponentTypeReference param4ComponentTypeReference) {
/* 8391 */             this.name = param4String;
/* 8392 */             this.componentTypeReference = param4ComponentTypeReference;
/* 8393 */             this.values = new ArrayList<AnnotationValue<?, ?>>();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void register(String param4String, AnnotationValue<?, ?> param4AnnotationValue) {
/* 8400 */             this.values.add(param4AnnotationValue);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void onComplete() {
/* 8407 */             TypePool.Default.TypeExtractor.AnnotationExtractor.a(this.a).register(this.name, (AnnotationValue<?, ?>)new TypePool.Default.LazyTypeDescription.LazyAnnotationValue.ForArray(this.a.a.a, this.componentTypeReference, this.values, (byte)0));
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected class AnnotationLookup
/*      */           implements TypePool.Default.AnnotationRegistrant
/*      */         {
/*      */           private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Map<String, AnnotationValue<?, ?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected AnnotationLookup(TypePool.Default.TypeExtractor.AnnotationExtractor this$0, String param4String1, String param4String2) {
/* 8440 */             this.descriptor = param4String1;
/* 8441 */             this.name = param4String2;
/* 8442 */             this.values = new HashMap<String, AnnotationValue<?, ?>>();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void register(String param4String, AnnotationValue<?, ?> param4AnnotationValue) {
/* 8449 */             this.values.put(param4String, param4AnnotationValue);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void onComplete() {
/* 8456 */             TypePool.Default.TypeExtractor.AnnotationExtractor.a(this.a).register(this.name, (AnnotationValue<?, ?>)new TypePool.Default.LazyTypeDescription.LazyAnnotationValue.ForAnnotationValue(this.a.a.a, new TypePool.Default.LazyTypeDescription.AnnotationToken(this.descriptor, this.values), (byte)0));
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected class FieldExtractor
/*      */         extends FieldVisitor
/*      */       {
/*      */         private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected FieldExtractor(TypePool.Default.TypeExtractor this$0, int param3Int, String param3String1, @MaybeNull String param3String2, String param3String3) {
/* 8511 */           super(OpenedClassReader.ASM_API);
/* 8512 */           this.modifiers = param3Int;
/* 8513 */           this.internalName = param3String1;
/* 8514 */           this.descriptor = param3String2;
/* 8515 */           this.genericSignature = param3String3;
/* 8516 */           this.typeAnnotationTokens = new HashMap<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>();
/* 8517 */           this.annotationTokens = new ArrayList<TypePool.Default.LazyTypeDescription.AnnotationToken>();
/*      */         }
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public AnnotationVisitor visitTypeAnnotation(int param3Int, @MaybeNull TypePath param3TypePath, String param3String, boolean param3Boolean) {
/*      */           TypePool.Default.AnnotationRegistrant.ForTypeVariable forTypeVariable;
/*      */           TypeReference typeReference;
/* 8525 */           switch ((typeReference = new TypeReference(param3Int)).getSort()) {
/*      */             case 19:
/* 8527 */               forTypeVariable = new TypePool.Default.AnnotationRegistrant.ForTypeVariable(param3String, param3TypePath, this.typeAnnotationTokens);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 8532 */               return new TypePool.Default.TypeExtractor.AnnotationExtractor(forTypeVariable, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));
/*      */           } 
/*      */           throw new IllegalStateException("Unexpected type reference on field: " + forTypeVariable.getSort());
/*      */         }
/*      */         public AnnotationVisitor visitAnnotation(String param3String, boolean param3Boolean) {
/* 8537 */           return new TypePool.Default.TypeExtractor.AnnotationExtractor(param3String, this.annotationTokens, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitEnd() {
/* 8542 */           TypePool.Default.TypeExtractor.a(this.a).add(new TypePool.Default.LazyTypeDescription.FieldToken(this.internalName, this.modifiers, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected class MethodExtractor
/*      */         extends MethodVisitor
/*      */         implements TypePool.Default.AnnotationRegistrant
/*      */       {
/*      */         private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String[] exceptionName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>> typeVariableBoundAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> returnTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> parameterTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>> exceptionTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> receiverTypeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> parameterAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken> parameterTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypePool.Default.ParameterBag legacyParameterBag;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private Label firstLabel;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private int visibleParameterShift;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private int invisibleParameterShift;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private AnnotationValue<?, ?> defaultValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected MethodExtractor(TypePool.Default.TypeExtractor this$0, int param3Int, String param3String1, @MaybeNull String param3String2, @MaybeNull String param3String3, String[] param3ArrayOfString) {
/* 8675 */           super(OpenedClassReader.ASM_API);
/* 8676 */           this.modifiers = param3Int;
/* 8677 */           this.internalName = param3String1;
/* 8678 */           this.descriptor = param3String2;
/* 8679 */           this.genericSignature = param3String3;
/* 8680 */           this.exceptionName = param3ArrayOfString;
/* 8681 */           this.typeVariableAnnotationTokens = new HashMap<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>();
/* 8682 */           this.typeVariableBoundAnnotationTokens = new HashMap<Integer, Map<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>>();
/* 8683 */           this.returnTypeAnnotationTokens = new HashMap<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>();
/* 8684 */           this.parameterTypeAnnotationTokens = new HashMap<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>();
/* 8685 */           this.exceptionTypeAnnotationTokens = new HashMap<Integer, Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>>();
/* 8686 */           this.receiverTypeAnnotationTokens = new HashMap<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>();
/* 8687 */           this.annotationTokens = new ArrayList<TypePool.Default.LazyTypeDescription.AnnotationToken>();
/* 8688 */           this.parameterAnnotationTokens = new HashMap<Integer, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>();
/* 8689 */           this.parameterTokens = new ArrayList<TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken>();
/* 8690 */           this.legacyParameterBag = new TypePool.Default.ParameterBag(Type.getMethodType(param3String2).getArgumentTypes());
/*      */         } @MaybeNull
/*      */         public AnnotationVisitor visitTypeAnnotation(int param3Int, TypePath param3TypePath, String param3String, boolean param3Boolean) { TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex withIndex2;
/*      */           TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed doubleIndexed;
/*      */           TypePool.Default.AnnotationRegistrant.ForTypeVariable forTypeVariable2;
/*      */           TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex withIndex1;
/*      */           TypePool.Default.AnnotationRegistrant.ForTypeVariable forTypeVariable1;
/*      */           TypeReference typeReference;
/* 8698 */           switch ((typeReference = new TypeReference(param3Int)).getSort()) {
/*      */ 
/*      */             
/*      */             case 1:
/* 8702 */               withIndex2 = new TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex(param3String, param3TypePath, typeReference.getTypeParameterIndex(), this.typeVariableAnnotationTokens);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 8739 */               return new TypePool.Default.TypeExtractor.AnnotationExtractor(withIndex2, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));case 18: doubleIndexed = new TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed(param3String, param3TypePath, withIndex2.getTypeParameterBoundIndex(), withIndex2.getTypeParameterIndex(), this.typeVariableBoundAnnotationTokens); return new TypePool.Default.TypeExtractor.AnnotationExtractor(doubleIndexed, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));case 20: forTypeVariable2 = new TypePool.Default.AnnotationRegistrant.ForTypeVariable(param3String, param3TypePath, this.returnTypeAnnotationTokens); return new TypePool.Default.TypeExtractor.AnnotationExtractor(forTypeVariable2, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));case 22: withIndex1 = new TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex(param3String, param3TypePath, forTypeVariable2.getFormalParameterIndex(), this.parameterTypeAnnotationTokens); return new TypePool.Default.TypeExtractor.AnnotationExtractor(withIndex1, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));case 23: withIndex1 = new TypePool.Default.AnnotationRegistrant.ForTypeVariable.WithIndex(param3String, param3TypePath, withIndex1.getExceptionIndex(), this.exceptionTypeAnnotationTokens); return new TypePool.Default.TypeExtractor.AnnotationExtractor(withIndex1, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));case 21: forTypeVariable1 = new TypePool.Default.AnnotationRegistrant.ForTypeVariable(param3String, param3TypePath, this.receiverTypeAnnotationTokens); return new TypePool.Default.TypeExtractor.AnnotationExtractor(forTypeVariable1, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));
/*      */             case 19:
/*      */               return null;
/*      */           } 
/*      */           throw new IllegalStateException("Unexpected type reference on method: " + forTypeVariable1.getSort()); } public AnnotationVisitor visitAnnotation(String param3String, boolean param3Boolean) {
/* 8744 */           return new TypePool.Default.TypeExtractor.AnnotationExtractor(param3String, this.annotationTokens, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitAnnotableParameterCount(int param3Int, boolean param3Boolean) {
/* 8749 */           if (param3Boolean) {
/* 8750 */             this.visibleParameterShift = (Type.getMethodType(this.descriptor).getArgumentTypes()).length - param3Int; return;
/*      */           } 
/* 8752 */           this.invisibleParameterShift = (Type.getMethodType(this.descriptor).getArgumentTypes()).length - param3Int;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationVisitor visitParameterAnnotation(int param3Int, String param3String, boolean param3Boolean) {
/* 8758 */           return new TypePool.Default.TypeExtractor.AnnotationExtractor(param3String, param3Int + (param3Boolean ? this.visibleParameterShift : this.invisibleParameterShift), this.parameterAnnotationTokens, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitLabel(Label param3Label) {
/* 8766 */           if (this.a.a.readerMode.isExtended() && this.firstLabel == null) {
/* 8767 */             this.firstLabel = param3Label;
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitLocalVariable(String param3String1, String param3String2, String param3String3, Label param3Label1, Label param3Label2, int param3Int) {
/* 8773 */           if (this.a.a.readerMode.isExtended() && param3Label1 == this.firstLabel) {
/* 8774 */             this.legacyParameterBag.register(param3Int, param3String1);
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitParameter(String param3String, int param3Int) {
/* 8780 */           this.parameterTokens.add(new TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken(param3String, Integer.valueOf(param3Int)));
/*      */         }
/*      */ 
/*      */         
/*      */         public AnnotationVisitor visitAnnotationDefault() {
/* 8785 */           return new TypePool.Default.TypeExtractor.AnnotationExtractor(this, new TypePool.Default.ComponentTypeLocator.ForArrayType(this.descriptor));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void register(String param3String, AnnotationValue<?, ?> param3AnnotationValue) {
/* 8792 */           this.defaultValue = param3AnnotationValue;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onComplete() {}
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void visitEnd() {
/* 8804 */           TypePool.Default.TypeExtractor.b(this.a).add(new TypePool.Default.LazyTypeDescription.MethodToken(this.internalName, this.modifiers, this.descriptor, this.genericSignature, this.exceptionName, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens, this.returnTypeAnnotationTokens, this.parameterTypeAnnotationTokens, this.exceptionTypeAnnotationTokens, this.receiverTypeAnnotationTokens, this.annotationTokens, this.parameterAnnotationTokens, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 8817 */                 this.parameterTokens.isEmpty() ? this.legacyParameterBag
/* 8818 */                 .resolve(((this.modifiers & 0x8) != 0)) : this.parameterTokens, this.defaultValue));
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected class RecordComponentExtractor
/*      */         extends RecordComponentVisitor
/*      */       {
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         private final String genericSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<TypePool.Default.LazyTypeDescription.AnnotationToken> annotationTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected RecordComponentExtractor(TypePool.Default.TypeExtractor this$0, String param3String1, @MaybeNull String param3String2, String param3String3) {
/* 8863 */           super(OpenedClassReader.ASM_API);
/* 8864 */           this.name = param3String1;
/* 8865 */           this.descriptor = param3String2;
/* 8866 */           this.genericSignature = param3String3;
/* 8867 */           this.typeAnnotationTokens = new HashMap<String, List<TypePool.Default.LazyTypeDescription.AnnotationToken>>();
/* 8868 */           this.annotationTokens = new ArrayList<TypePool.Default.LazyTypeDescription.AnnotationToken>();
/*      */         }
/*      */ 
/*      */         
/*      */         public AnnotationVisitor visitTypeAnnotation(int param3Int, TypePath param3TypePath, String param3String, boolean param3Boolean) {
/*      */           TypePool.Default.AnnotationRegistrant.ForTypeVariable forTypeVariable;
/*      */           TypeReference typeReference;
/* 8875 */           switch ((typeReference = new TypeReference(param3Int)).getSort()) {
/*      */             case 19:
/* 8877 */               forTypeVariable = new TypePool.Default.AnnotationRegistrant.ForTypeVariable(param3String, param3TypePath, this.typeAnnotationTokens);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 8882 */               return new TypePool.Default.TypeExtractor.AnnotationExtractor(forTypeVariable, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));
/*      */           } 
/*      */           throw new IllegalStateException("Unexpected type reference on record component: " + forTypeVariable.getSort());
/*      */         }
/*      */         public AnnotationVisitor visitAnnotation(String param3String, boolean param3Boolean) {
/* 8887 */           return new TypePool.Default.TypeExtractor.AnnotationExtractor(param3String, this.annotationTokens, new TypePool.Default.ComponentTypeLocator.ForAnnotationProperty(this.a.a, param3String));
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitEnd() {
/* 8892 */           TypePool.Default.TypeExtractor.c(this.a).add(new TypePool.Default.LazyTypeDescription.RecordComponentToken(this.name, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class LazyFacade
/*      */     extends AbstractBase
/*      */   {
/*      */     private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LazyFacade(TypePool param1TypePool) {
/* 8919 */       super(TypePool.CacheProvider.NoOp.INSTANCE);
/* 8920 */       this.typePool = param1TypePool;
/*      */     }
/*      */ 
/*      */     
/*      */     protected TypePool.Resolution doDescribe(String param1String) {
/* 8925 */       return new LazyResolution(this.typePool, param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void clear() {
/* 8932 */       this.typePool.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typePool.equals(((LazyFacade)param1Object).typePool)))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return super.hashCode() * 31 + this.typePool.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class LazyResolution
/*      */       implements TypePool.Resolution
/*      */     {
/*      */       private final TypePool typePool;
/*      */       
/*      */       private final String name;
/*      */ 
/*      */       
/*      */       protected LazyResolution(TypePool param2TypePool, String param2String) {
/* 8958 */         this.typePool = param2TypePool;
/* 8959 */         this.name = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isResolved() {
/* 8966 */         return this.typePool.describe(this.name).isResolved();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription resolve() {
/* 8973 */         return (TypeDescription)new TypePool.LazyFacade.LazyTypeDescription(this.typePool, this.name);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.name.equals(((LazyResolution)param2Object).name) ? false : (!!this.typePool.equals(((LazyResolution)param2Object).typePool)))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.typePool.hashCode()) * 31 + this.name.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     protected static class LazyTypeDescription
/*      */       extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation
/*      */     {
/*      */       private final TypePool typePool;
/*      */       
/*      */       private final String name;
/*      */ 
/*      */       
/*      */       protected LazyTypeDescription(TypePool param2TypePool, String param2String) {
/* 8999 */         this.typePool = param2TypePool;
/* 9000 */         this.name = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getName() {
/* 9007 */         return this.name;
/*      */       } @Enhance("delegate")
/*      */       protected TypeDescription delegate() {
/*      */         TypeDescription typeDescription1;
/*      */         LazyTypeDescription lazyTypeDescription;
/*      */         TypeDescription typeDescription2;
/* 9013 */         if ((typeDescription1 = (TypeDescription)(((typeDescription2 = this.delegate) != null) ? null : (lazyTypeDescription = this).typePool.describe(lazyTypeDescription.name).resolve())) == null) { typeDescription1 = this.delegate; } else { this.delegate = typeDescription1; }  return typeDescription1;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ClassLoading
/*      */     extends AbstractBase.Hierarchical
/*      */   {
/*      */     @MaybeNull
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */     private final ClassLoader classLoader;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassLoading(TypePool.CacheProvider param1CacheProvider, TypePool param1TypePool, @MaybeNull ClassLoader param1ClassLoader) {
/* 9039 */       super(param1CacheProvider, param1TypePool);
/* 9040 */       this.classLoader = param1ClassLoader;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool of(@MaybeNull ClassLoader param1ClassLoader) {
/* 9050 */       return of(param1ClassLoader, TypePool.Empty.INSTANCE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool of(@MaybeNull ClassLoader param1ClassLoader, TypePool param1TypePool) {
/* 9061 */       return new ClassLoading(new TypePool.CacheProvider.Simple(), param1TypePool, param1ClassLoader);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool ofSystemLoader() {
/* 9070 */       return of(ClassLoader.getSystemClassLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool ofPlatformLoader() {
/* 9080 */       return of(ClassLoader.getSystemClassLoader().getParent());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypePool ofBootLoader() {
/* 9089 */       return of(ClassLoadingStrategy.BOOTSTRAP_LOADER);
/*      */     }
/*      */     
/*      */     protected TypePool.Resolution doDescribe(String param1String)
/*      */     {
/*      */       try {
/* 9095 */         return new TypePool.Resolution.Simple(TypeDescription.ForLoadedType.of(Class.forName(param1String, false, this.classLoader)));
/* 9096 */       } catch (ClassNotFoundException classNotFoundException) {
/* 9097 */         return new TypePool.Resolution.Illegal(param1String);
/*      */       } 
/*      */     } public boolean equals(@MaybeNull Object param1Object) { ClassLoader classLoader; if (!super.equals(param1Object))
/*      */         return false;  if (this == param1Object)
/*      */         return true;  if (param1Object == null)
/*      */         return false; 
/*      */       if (getClass() != param1Object.getClass())
/*      */         return false; 
/*      */       param1Object = ((ClassLoading)param1Object).classLoader;
/*      */       if (param1Object != null) {
/*      */         if ((classLoader = this.classLoader) != null) {
/*      */           if (!classLoader.equals(param1Object))
/*      */             return false; 
/*      */         } else {
/*      */           return false;
/*      */         } 
/*      */       } else if ((classLoader = this.classLoader) != null) {
/*      */         return false;
/*      */       } 
/*      */       return true; } public int hashCode() { ClassLoader classLoader;
/*      */       if ((classLoader = this.classLoader) != null);
/*      */       return super.hashCode() * 31 + classLoader.hashCode(); } } @Enhance public static class Explicit extends AbstractBase.Hierarchical { private final Map<String, TypeDescription> types;
/* 9119 */     public Explicit(Map<String, TypeDescription> param1Map) { this(TypePool.Empty.INSTANCE, param1Map); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Explicit(TypePool param1TypePool, Map<String, TypeDescription> param1Map) {
/* 9129 */       super(TypePool.CacheProvider.NoOp.INSTANCE, param1TypePool);
/* 9130 */       this.types = param1Map;
/*      */     }
/*      */ 
/*      */     
/*      */     protected TypePool.Resolution doDescribe(String param1String) {
/*      */       TypeDescription typeDescription;
/* 9136 */       return (TypePool.Resolution)(((typeDescription = this.types.get(param1String)) == null) ? new TypePool.Resolution.Illegal(param1String) : new TypePool.Resolution.Simple(typeDescription));
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.types.equals(((Explicit)param1Object).types)))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return super.hashCode() * 31 + this.types.hashCode();
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\pool\TypePool.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */