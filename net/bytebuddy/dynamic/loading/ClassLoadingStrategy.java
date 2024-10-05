/*     */ package net.bytebuddy.dynamic.loading;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.lang.instrument.Instrumentation;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.type.TypeDescription;
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
/*     */ public interface ClassLoadingStrategy<T extends ClassLoader>
/*     */ {
/*     */   @AlwaysNull
/*  40 */   public static final ClassLoader BOOTSTRAP_LOADER = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @AlwaysNull
/*  46 */   public static final ProtectionDomain NO_PROTECTION_DOMAIN = null;
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
/*     */   Map<TypeDescription, Class<?>> load(@MaybeNull T paramT, Map<TypeDescription, byte[]> paramMap);
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
/*     */   public enum Default
/*     */     implements Configurable<ClassLoader>
/*     */   {
/*  73 */     WRAPPER((String)new WrappingDispatcher(ByteArrayClassLoader.PersistenceHandler.LATENT, false)),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     WRAPPER_PERSISTENT((String)new WrappingDispatcher(ByteArrayClassLoader.PersistenceHandler.MANIFEST, false)),
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
/*  93 */     CHILD_FIRST((String)new WrappingDispatcher(ByteArrayClassLoader.PersistenceHandler.LATENT, true)),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     CHILD_FIRST_PERSISTENT((String)new WrappingDispatcher(ByteArrayClassLoader.PersistenceHandler.MANIFEST, true)),
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
/* 123 */     INJECTION((String)new InjectionDispatcher());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final boolean DEFAULT_FORBID_EXISTING = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ClassLoadingStrategy.Configurable<ClassLoader> dispatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Default(ClassLoadingStrategy.Configurable<ClassLoader> param1Configurable) {
/* 141 */       this.dispatcher = param1Configurable;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param1ClassLoader, Map<TypeDescription, byte[]> param1Map) {
/* 148 */       return this.dispatcher.load(param1ClassLoader, param1Map);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ClassLoadingStrategy.Configurable<ClassLoader> with(ProtectionDomain param1ProtectionDomain) {
/* 155 */       return this.dispatcher.with(param1ProtectionDomain);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ClassLoadingStrategy.Configurable<ClassLoader> with(PackageDefinitionStrategy param1PackageDefinitionStrategy) {
/* 162 */       return this.dispatcher.with(param1PackageDefinitionStrategy);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ClassLoadingStrategy.Configurable<ClassLoader> allowExistingTypes() {
/* 169 */       return this.dispatcher.allowExistingTypes();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ClassLoadingStrategy.Configurable<ClassLoader> opened() {
/* 176 */       return this.dispatcher.opened();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class InjectionDispatcher
/*     */       implements ClassLoadingStrategy.Configurable<ClassLoader>
/*     */     {
/*     */       @MaybeNull
/*     */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */       private final ProtectionDomain protectionDomain;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final PackageDefinitionStrategy packageDefinitionStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final boolean forbidExisting;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected InjectionDispatcher() {
/* 213 */         this(NO_PROTECTION_DOMAIN, PackageDefinitionStrategy.NoOp.INSTANCE, true);
/*     */       }
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
/*     */       private InjectionDispatcher(@MaybeNull ProtectionDomain param2ProtectionDomain, PackageDefinitionStrategy param2PackageDefinitionStrategy, boolean param2Boolean) {
/* 226 */         this.protectionDomain = param2ProtectionDomain;
/* 227 */         this.packageDefinitionStrategy = param2PackageDefinitionStrategy;
/* 228 */         this.forbidExisting = param2Boolean;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param2ClassLoader, Map<TypeDescription, byte[]> param2Map) {
/* 235 */         if (param2ClassLoader == null) {
/* 236 */           throw new IllegalArgumentException("Cannot inject classes into the bootstrap class loader");
/*     */         }
/* 238 */         return (new ClassInjector.UsingReflection(param2ClassLoader, this.protectionDomain, this.packageDefinitionStrategy, this.forbidExisting))
/*     */ 
/*     */           
/* 241 */           .inject(param2Map);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> with(ProtectionDomain param2ProtectionDomain) {
/* 248 */         return new InjectionDispatcher(param2ProtectionDomain, this.packageDefinitionStrategy, this.forbidExisting);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> with(PackageDefinitionStrategy param2PackageDefinitionStrategy) {
/* 255 */         return new InjectionDispatcher(this.protectionDomain, param2PackageDefinitionStrategy, this.forbidExisting);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> allowExistingTypes() {
/* 262 */         return new InjectionDispatcher(this.protectionDomain, this.packageDefinitionStrategy, false);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> opened() {
/* 269 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         ProtectionDomain protectionDomain2;
/*     */         if (this == param2Object) {
/*     */           return true;
/*     */         }
/*     */         if (param2Object == null) {
/*     */           return false;
/*     */         }
/*     */         if (getClass() != param2Object.getClass()) {
/*     */           return false;
/*     */         }
/*     */         if (this.forbidExisting != ((InjectionDispatcher)param2Object).forbidExisting) {
/*     */           return false;
/*     */         }
/*     */         ProtectionDomain protectionDomain1 = ((InjectionDispatcher)param2Object).protectionDomain;
/*     */         if (protectionDomain1 != null) {
/*     */           if ((protectionDomain2 = this.protectionDomain) != null) {
/*     */             if (!protectionDomain2.equals(protectionDomain1)) {
/*     */               return false;
/*     */             }
/*     */           } else {
/*     */             return false;
/*     */           } 
/*     */         } else if ((protectionDomain2 = this.protectionDomain) != null) {
/*     */           return false;
/*     */         } 
/*     */         return !!this.packageDefinitionStrategy.equals(((InjectionDispatcher)param2Object).packageDefinitionStrategy);
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         ProtectionDomain protectionDomain;
/*     */         if ((protectionDomain = this.protectionDomain) != null);
/*     */         return ((getClass().hashCode() * 31 + protectionDomain.hashCode()) * 31 + this.packageDefinitionStrategy.hashCode()) * 31 + this.forbidExisting;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class WrappingDispatcher
/*     */       implements ClassLoadingStrategy.Configurable<ClassLoader>
/*     */     {
/*     */       private static final boolean CHILD_FIRST = true;
/*     */       
/*     */       private static final boolean PARENT_FIRST = false;
/*     */       
/*     */       @MaybeNull
/*     */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */       private final ProtectionDomain protectionDomain;
/*     */       private final ByteArrayClassLoader.PersistenceHandler persistenceHandler;
/*     */       private final PackageDefinitionStrategy packageDefinitionStrategy;
/*     */       private final boolean childFirst;
/*     */       private final boolean forbidExisting;
/*     */       private final boolean sealed;
/*     */       
/*     */       protected WrappingDispatcher(ByteArrayClassLoader.PersistenceHandler param2PersistenceHandler, boolean param2Boolean) {
/* 329 */         this(NO_PROTECTION_DOMAIN, PackageDefinitionStrategy.Trivial.INSTANCE, param2PersistenceHandler, param2Boolean, true, true);
/*     */       }
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
/*     */       private WrappingDispatcher(@MaybeNull ProtectionDomain param2ProtectionDomain, PackageDefinitionStrategy param2PackageDefinitionStrategy, ByteArrayClassLoader.PersistenceHandler param2PersistenceHandler, boolean param2Boolean1, boolean param2Boolean2, boolean param2Boolean3) {
/* 353 */         this.protectionDomain = param2ProtectionDomain;
/* 354 */         this.packageDefinitionStrategy = param2PackageDefinitionStrategy;
/* 355 */         this.persistenceHandler = param2PersistenceHandler;
/* 356 */         this.childFirst = param2Boolean1;
/* 357 */         this.forbidExisting = param2Boolean2;
/* 358 */         this.sealed = param2Boolean3;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param2ClassLoader, Map<TypeDescription, byte[]> param2Map) {
/* 365 */         if (this.childFirst)
/* 366 */           return ByteArrayClassLoader.ChildFirst.load(param2ClassLoader, param2Map, this.protectionDomain, this.persistenceHandler, this.packageDefinitionStrategy, this.forbidExisting, this.sealed); 
/* 367 */         return ByteArrayClassLoader.load(param2ClassLoader, param2Map, this.protectionDomain, this.persistenceHandler, this.packageDefinitionStrategy, this.forbidExisting, this.sealed);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> with(ProtectionDomain param2ProtectionDomain) {
/* 374 */         return new WrappingDispatcher(param2ProtectionDomain, this.packageDefinitionStrategy, this.persistenceHandler, this.childFirst, this.forbidExisting, this.sealed);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> with(PackageDefinitionStrategy param2PackageDefinitionStrategy) {
/* 381 */         return new WrappingDispatcher(this.protectionDomain, param2PackageDefinitionStrategy, this.persistenceHandler, this.childFirst, this.forbidExisting, this.sealed);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> allowExistingTypes() {
/* 388 */         return new WrappingDispatcher(this.protectionDomain, this.packageDefinitionStrategy, this.persistenceHandler, this.childFirst, false, this.sealed);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ClassLoadingStrategy.Configurable<ClassLoader> opened() {
/* 395 */         return new WrappingDispatcher(this.protectionDomain, this.packageDefinitionStrategy, this.persistenceHandler, this.childFirst, this.forbidExisting, false);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         ProtectionDomain protectionDomain2;
/*     */         if (this == param2Object) {
/*     */           return true;
/*     */         }
/*     */         if (param2Object == null) {
/*     */           return false;
/*     */         }
/*     */         if (getClass() != param2Object.getClass()) {
/*     */           return false;
/*     */         }
/*     */         if (this.childFirst != ((WrappingDispatcher)param2Object).childFirst) {
/*     */           return false;
/*     */         }
/*     */         if (this.forbidExisting != ((WrappingDispatcher)param2Object).forbidExisting)
/*     */           return false; 
/*     */         if (this.sealed != ((WrappingDispatcher)param2Object).sealed)
/*     */           return false; 
/*     */         if (!this.persistenceHandler.equals(((WrappingDispatcher)param2Object).persistenceHandler))
/*     */           return false; 
/*     */         ProtectionDomain protectionDomain1 = ((WrappingDispatcher)param2Object).protectionDomain;
/*     */         if (protectionDomain1 != null) {
/*     */           if ((protectionDomain2 = this.protectionDomain) != null) {
/*     */             if (!protectionDomain2.equals(protectionDomain1))
/*     */               return false; 
/*     */           } else {
/*     */             return false;
/*     */           } 
/*     */         } else if ((protectionDomain2 = this.protectionDomain) != null) {
/*     */           return false;
/*     */         } 
/*     */         return !!this.packageDefinitionStrategy.equals(((WrappingDispatcher)param2Object).packageDefinitionStrategy);
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         ProtectionDomain protectionDomain;
/*     */         if ((protectionDomain = this.protectionDomain) != null);
/*     */         return (((((getClass().hashCode() * 31 + protectionDomain.hashCode()) * 31 + this.persistenceHandler.hashCode()) * 31 + this.packageDefinitionStrategy.hashCode()) * 31 + this.childFirst) * 31 + this.forbidExisting) * 31 + this.sealed;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface Configurable<S extends ClassLoader>
/*     */     extends ClassLoadingStrategy<S>
/*     */   {
/*     */     Configurable<S> with(ProtectionDomain param1ProtectionDomain);
/*     */     
/*     */     Configurable<S> with(PackageDefinitionStrategy param1PackageDefinitionStrategy);
/*     */     
/*     */     Configurable<S> allowExistingTypes();
/*     */     
/*     */     Configurable<S> opened();
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class UsingLookup
/*     */     implements ClassLoadingStrategy<ClassLoader>
/*     */   {
/*     */     private final ClassInjector classInjector;
/*     */     
/*     */     protected UsingLookup(ClassInjector param1ClassInjector) {
/* 459 */       this.classInjector = param1ClassInjector;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ClassLoadingStrategy<ClassLoader> of(Object param1Object) {
/* 469 */       return new UsingLookup(ClassInjector.UsingLookup.of(param1Object));
/*     */     }
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
/*     */     public static ClassLoadingStrategy<ClassLoader> withFallback(Callable<?> param1Callable) {
/* 484 */       return withFallback(param1Callable, false);
/*     */     }
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
/*     */     public static ClassLoadingStrategy<ClassLoader> withFallback(Callable<?> param1Callable, boolean param1Boolean) {
/* 500 */       if (ClassInjector.UsingLookup.isAvailable())
/*     */         try {
/* 502 */           return of(param1Callable.call());
/* 503 */         } catch (Exception exception) {
/* 504 */           throw new IllegalStateException(exception);
/*     */         }  
/* 506 */       if (ClassInjector.UsingUnsafe.isAvailable())
/* 507 */         return new ClassLoadingStrategy.ForUnsafeInjection(); 
/* 508 */       if (param1Boolean) {
/* 509 */         return ClassLoadingStrategy.Default.WRAPPER;
/*     */       }
/* 511 */       throw new IllegalStateException("Neither lookup or unsafe class injection is available");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param1ClassLoader, Map<TypeDescription, byte[]> param1Map) {
/* 519 */       return this.classInjector.inject(param1Map);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classInjector.equals(((UsingLookup)param1Object).classInjector))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.classInjector.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForBootstrapInjection
/*     */     implements ClassLoadingStrategy<ClassLoader>
/*     */   {
/*     */     private final Instrumentation instrumentation;
/*     */     
/*     */     private final File folder;
/*     */ 
/*     */     
/*     */     public ForBootstrapInjection(Instrumentation param1Instrumentation, File param1File) {
/* 547 */       this.instrumentation = param1Instrumentation;
/* 548 */       this.folder = param1File;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param1ClassLoader, Map<TypeDescription, byte[]> param1Map) {
/*     */       ClassInjector classInjector;
/* 558 */       return (classInjector = (param1ClassLoader == null) ? ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, this.instrumentation) : new ClassInjector.UsingReflection(param1ClassLoader)).inject(param1Map);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.instrumentation.equals(((ForBootstrapInjection)param1Object).instrumentation) ? false : (!!this.folder.equals(((ForBootstrapInjection)param1Object).folder)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.instrumentation.hashCode()) * 31 + this.folder.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class ForUnsafeInjection
/*     */     implements ClassLoadingStrategy<ClassLoader>
/*     */   {
/*     */     @MaybeNull
/*     */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */     private final ProtectionDomain protectionDomain;
/*     */     
/*     */     public ForUnsafeInjection() {
/* 579 */       this(NO_PROTECTION_DOMAIN);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForUnsafeInjection(@MaybeNull ProtectionDomain param1ProtectionDomain) {
/* 588 */       this.protectionDomain = param1ProtectionDomain;
/*     */     } public boolean equals(@MaybeNull Object param1Object) { ProtectionDomain protectionDomain; if (this == param1Object)
/*     */         return true;  if (param1Object == null)
/*     */         return false;  if (getClass() != param1Object.getClass())
/*     */         return false;  param1Object = ((ForUnsafeInjection)param1Object).protectionDomain; if (param1Object != null) { if ((protectionDomain = this.protectionDomain) != null) { if (!protectionDomain.equals(param1Object))
/*     */             return false;  } else { return false; }  }
/*     */       else if ((protectionDomain = this.protectionDomain) != null) { return false; }
/* 595 */        return true; } public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param1ClassLoader, Map<TypeDescription, byte[]> param1Map) { return (new ClassInjector.UsingUnsafe(param1ClassLoader, this.protectionDomain)).inject(param1Map); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       ProtectionDomain protectionDomain;
/*     */       if ((protectionDomain = this.protectionDomain) != null);
/*     */       return getClass().hashCode() * 31 + protectionDomain.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForJnaInjection
/*     */     implements ClassLoadingStrategy<ClassLoader>
/*     */   {
/*     */     public ForJnaInjection() {
/* 617 */       this(NO_PROTECTION_DOMAIN);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */     private final ProtectionDomain protectionDomain;
/*     */     
/*     */     public ForJnaInjection(@MaybeNull ProtectionDomain param1ProtectionDomain) {
/* 626 */       this.protectionDomain = param1ProtectionDomain;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param1ClassLoader, Map<TypeDescription, byte[]> param1Map) {
/* 633 */       return (new ClassInjector.UsingUnsafe(param1ClassLoader, this.protectionDomain)).inject(param1Map);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       ProtectionDomain protectionDomain;
/*     */       if (this == param1Object)
/*     */         return true; 
/*     */       if (param1Object == null)
/*     */         return false; 
/*     */       if (getClass() != param1Object.getClass())
/*     */         return false; 
/*     */       param1Object = ((ForJnaInjection)param1Object).protectionDomain;
/*     */       if (param1Object != null) {
/*     */         if ((protectionDomain = this.protectionDomain) != null) {
/*     */           if (!protectionDomain.equals(param1Object))
/*     */             return false; 
/*     */         } else {
/*     */           return false;
/*     */         } 
/*     */       } else if ((protectionDomain = this.protectionDomain) != null) {
/*     */         return false;
/*     */       } 
/*     */       return true;
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       ProtectionDomain protectionDomain;
/*     */       if ((protectionDomain = this.protectionDomain) != null);
/*     */       return getClass().hashCode() * 31 + protectionDomain.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\ClassLoadingStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */