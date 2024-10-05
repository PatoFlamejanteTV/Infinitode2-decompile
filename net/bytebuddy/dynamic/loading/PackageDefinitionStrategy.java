/*     */ package net.bytebuddy.dynamic.loading;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.Manifest;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
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
/*     */ public interface PackageDefinitionStrategy
/*     */ {
/*     */   Definition define(ClassLoader paramClassLoader, String paramString1, String paramString2);
/*     */   
/*     */   public enum NoOp
/*     */     implements PackageDefinitionStrategy
/*     */   {
/*  57 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final PackageDefinitionStrategy.Definition define(ClassLoader param1ClassLoader, String param1String1, String param1String2) {
/*  63 */       return PackageDefinitionStrategy.Definition.Undefined.INSTANCE;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Trivial
/*     */     implements PackageDefinitionStrategy
/*     */   {
/*  75 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final PackageDefinitionStrategy.Definition define(ClassLoader param1ClassLoader, String param1String1, String param1String2) {
/*  81 */       return PackageDefinitionStrategy.Definition.Trivial.INSTANCE;
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
/*     */   public static interface Definition
/*     */   {
/*     */     boolean isDefined();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     String getSpecificationTitle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     String getSpecificationVersion();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     String getSpecificationVendor();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     String getImplementationTitle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     String getImplementationVersion();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     String getImplementationVendor();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     URL getSealBase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isCompatibleTo(Package param1Package);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum Undefined
/*     */       implements Definition
/*     */     {
/* 176 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final boolean isDefined() {
/* 182 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final String getSpecificationTitle() {
/* 189 */         throw new IllegalStateException("Cannot read property of undefined package");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final String getSpecificationVersion() {
/* 196 */         throw new IllegalStateException("Cannot read property of undefined package");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final String getSpecificationVendor() {
/* 203 */         throw new IllegalStateException("Cannot read property of undefined package");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final String getImplementationTitle() {
/* 210 */         throw new IllegalStateException("Cannot read property of undefined package");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final String getImplementationVersion() {
/* 217 */         throw new IllegalStateException("Cannot read property of undefined package");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final String getImplementationVendor() {
/* 224 */         throw new IllegalStateException("Cannot read property of undefined package");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final URL getSealBase() {
/* 231 */         throw new IllegalStateException("Cannot read property of undefined package");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final boolean isCompatibleTo(Package param2Package) {
/* 238 */         throw new IllegalStateException("Cannot check compatibility to undefined package");
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum Trivial
/*     */       implements Definition
/*     */     {
/* 250 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @AlwaysNull
/* 262 */       private static final URL NOT_SEALED = null; @AlwaysNull
/*     */       private static final String NO_VALUE = null;
/*     */       static {
/*     */       
/*     */       }
/*     */       public final boolean isDefined() {
/* 268 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public final String getSpecificationTitle() {
/* 276 */         return NO_VALUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public final String getSpecificationVersion() {
/* 284 */         return NO_VALUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public final String getSpecificationVendor() {
/* 292 */         return NO_VALUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public final String getImplementationTitle() {
/* 300 */         return NO_VALUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public final String getImplementationVersion() {
/* 308 */         return NO_VALUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final String getImplementationVendor() {
/* 315 */         return NO_VALUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public final URL getSealBase() {
/* 323 */         return NOT_SEALED;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final boolean isCompatibleTo(Package param2Package) {
/* 330 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Simple
/*     */       implements Definition
/*     */     {
/*     */       @MaybeNull
/*     */       protected final URL sealBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       private final String specificationTitle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       private final String specificationVersion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       private final String specificationVendor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       private final String implementationTitle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       private final String implementationVersion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       private final String implementationVendor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Simple(@MaybeNull String param2String1, @MaybeNull String param2String2, @MaybeNull String param2String3, @MaybeNull String param2String4, @MaybeNull String param2String5, @MaybeNull String param2String6, @MaybeNull URL param2URL) {
/* 399 */         this.specificationTitle = param2String1;
/* 400 */         this.specificationVersion = param2String2;
/* 401 */         this.specificationVendor = param2String3;
/* 402 */         this.implementationTitle = param2String4;
/* 403 */         this.implementationVersion = param2String5;
/* 404 */         this.implementationVendor = param2String6;
/* 405 */         this.sealBase = param2URL;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isDefined() {
/* 412 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public String getSpecificationTitle() {
/* 420 */         return this.specificationTitle;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public String getSpecificationVersion() {
/* 428 */         return this.specificationVersion;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public String getSpecificationVendor() {
/* 436 */         return this.specificationVendor;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public String getImplementationTitle() {
/* 444 */         return this.implementationTitle;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public String getImplementationVersion() {
/* 452 */         return this.implementationVersion;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public String getImplementationVendor() {
/* 460 */         return this.implementationVendor;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public URL getSealBase() {
/* 468 */         return this.sealBase;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isCompatibleTo(Package param2Package) {
/* 475 */         if (this.sealBase == null) {
/* 476 */           return !param2Package.isSealed();
/*     */         }
/* 478 */         return param2Package.isSealed(this.sealBase);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @SuppressFBWarnings(value = {"DMI_BLOCKING_METHODS_ON_URL"}, justification = "Package sealing relies on URL equality.")
/*     */       public int hashCode() {
/* 485 */         int i = (this.specificationTitle != null) ? this.specificationTitle.hashCode() : 0;
/* 486 */         i = i * 31 + ((this.specificationVersion != null) ? this.specificationVersion.hashCode() : 0);
/* 487 */         i = i * 31 + ((this.specificationVendor != null) ? this.specificationVendor.hashCode() : 0);
/* 488 */         i = i * 31 + ((this.implementationTitle != null) ? this.implementationTitle.hashCode() : 0);
/* 489 */         i = i * 31 + ((this.implementationVersion != null) ? this.implementationVersion.hashCode() : 0);
/* 490 */         i = i * 31 + ((this.implementationVendor != null) ? this.implementationVendor.hashCode() : 0);
/*     */         
/* 492 */         return i = i * 31 + ((this.sealBase != null) ? this.sealBase.hashCode() : 0);
/*     */       }
/*     */ 
/*     */       
/*     */       @SuppressFBWarnings(value = {"DMI_BLOCKING_METHODS_ON_URL"}, justification = "Package sealing relies on URL equality.")
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/* 498 */         if (this == param2Object)
/* 499 */           return true; 
/* 500 */         if (param2Object == null || getClass() != param2Object.getClass()) {
/* 501 */           return false;
/*     */         }
/* 503 */         param2Object = param2Object;
/* 504 */         if (((this.specificationTitle != null) ? !this.specificationTitle.equals(((Simple)param2Object).specificationTitle) : (((Simple)param2Object).specificationTitle != null)) || ((this.specificationVersion != null) ? 
/* 505 */           !this.specificationVersion.equals(((Simple)param2Object).specificationVersion) : (((Simple)param2Object).specificationVersion != null)) || ((this.specificationVendor != null) ? 
/* 506 */           !this.specificationVendor.equals(((Simple)param2Object).specificationVendor) : (((Simple)param2Object).specificationVendor != null)) || ((this.implementationTitle != null) ? 
/* 507 */           !this.implementationTitle.equals(((Simple)param2Object).implementationTitle) : (((Simple)param2Object).implementationTitle != null)) || ((this.implementationVersion != null) ? 
/* 508 */           !this.implementationVersion.equals(((Simple)param2Object).implementationVersion) : (((Simple)param2Object).implementationVersion != null)) || ((this.implementationVendor != null) ? 
/* 509 */           !this.implementationVendor.equals(((Simple)param2Object).implementationVendor) : (((Simple)param2Object).implementationVendor != null)) || ((this.sealBase != null) ? 
/* 510 */           !this.sealBase.equals(((Simple)param2Object).sealBase) : (((Simple)param2Object).sealBase != null))) return false;  return true;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ManifestReading
/*     */     implements PackageDefinitionStrategy
/*     */   {
/*     */     @AlwaysNull
/* 525 */     private static final URL NOT_SEALED = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 530 */     private static final Attributes.Name[] ATTRIBUTE_NAMES = new Attributes.Name[] { Attributes.Name.SPECIFICATION_TITLE, Attributes.Name.SPECIFICATION_VERSION, Attributes.Name.SPECIFICATION_VENDOR, Attributes.Name.IMPLEMENTATION_TITLE, Attributes.Name.IMPLEMENTATION_VERSION, Attributes.Name.IMPLEMENTATION_VENDOR, Attributes.Name.SEALED };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final SealBaseLocator sealBaseLocator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ManifestReading() {
/* 549 */       this(new SealBaseLocator.ForTypeResourceUrl());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ManifestReading(SealBaseLocator param1SealBaseLocator) {
/* 558 */       this.sealBaseLocator = param1SealBaseLocator;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PackageDefinitionStrategy.Definition define(ClassLoader param1ClassLoader, String param1String1, String param1String2) {
/*     */       InputStream inputStream;
/* 566 */       if ((inputStream = param1ClassLoader.getResourceAsStream("META-INF/MANIFEST.MF")) != null)
/*     */         
/*     */         try {
/* 569 */           Manifest manifest = new Manifest(inputStream);
/* 570 */           HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */           Attributes attributes1;
/* 572 */           if ((attributes1 = manifest.getMainAttributes()) != null) {
/* 573 */             Attributes.Name[] arrayOfName; int i; byte b; for (i = (arrayOfName = ATTRIBUTE_NAMES).length, b = 0; b < i; ) { Attributes.Name name = arrayOfName[b];
/* 574 */               hashMap.put(name, attributes1.getValue(name)); b++; }
/*     */           
/*     */           } 
/*     */           Attributes attributes2;
/* 578 */           if ((attributes2 = manifest.getAttributes(param1String1.replace('.', '/').concat("/"))) != null) {
/* 579 */             Attributes.Name[] arrayOfName; int i; byte b; for (i = (arrayOfName = ATTRIBUTE_NAMES).length, b = 0; b < i; ) { Attributes.Name name = arrayOfName[b];
/*     */               String str;
/* 581 */               if ((str = attributes2.getValue(name)) != null)
/* 582 */                 hashMap.put(name, str); 
/*     */               b++; }
/*     */           
/*     */           } 
/* 586 */           return new PackageDefinitionStrategy.Definition.Simple((String)hashMap.get(Attributes.Name.SPECIFICATION_TITLE), (String)hashMap
/* 587 */               .get(Attributes.Name.SPECIFICATION_VERSION), (String)hashMap
/* 588 */               .get(Attributes.Name.SPECIFICATION_VENDOR), (String)hashMap
/* 589 */               .get(Attributes.Name.IMPLEMENTATION_TITLE), (String)hashMap
/* 590 */               .get(Attributes.Name.IMPLEMENTATION_VERSION), (String)hashMap
/* 591 */               .get(Attributes.Name.IMPLEMENTATION_VENDOR), 
/* 592 */               Boolean.parseBoolean((String)hashMap.get(Attributes.Name.SEALED)) ? this.sealBaseLocator
/* 593 */               .findSealBase(param1ClassLoader, param1String2) : NOT_SEALED);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 598 */         catch (IOException iOException) {
/* 599 */           throw new IllegalStateException("Error while reading manifest file", iOException);
/*     */         } finally {
/*     */           inputStream.close();
/* 602 */         }   return PackageDefinitionStrategy.Definition.Trivial.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.sealBaseLocator.equals(((ManifestReading)param1Object).sealBaseLocator))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.sealBaseLocator.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static interface SealBaseLocator
/*     */     {
/*     */       @MaybeNull
/*     */       URL findSealBase(ClassLoader param2ClassLoader, String param2String);
/*     */ 
/*     */ 
/*     */       
/*     */       public enum NonSealing
/*     */         implements SealBaseLocator
/*     */       {
/* 629 */         INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         @MaybeNull
/*     */         public final URL findSealBase(ClassLoader param3ClassLoader, String param3String) {
/* 636 */           return PackageDefinitionStrategy.ManifestReading.a();
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class ForFixedValue
/*     */         implements SealBaseLocator
/*     */       {
/*     */         @MaybeNull
/*     */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */         private final URL sealBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ForFixedValue(@MaybeNull URL param3URL) {
/* 659 */           this.sealBase = param3URL;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         @MaybeNull
/*     */         public URL findSealBase(ClassLoader param3ClassLoader, String param3String) {
/* 667 */           return this.sealBase;
/*     */         }
/*     */ 
/*     */         
/*     */         @SuppressFBWarnings(value = {"DMI_BLOCKING_METHODS_ON_URL"}, justification = "Package sealing relies on URL equality.")
/*     */         public int hashCode() {
/* 673 */           return (this.sealBase == null) ? 17 : this.sealBase
/*     */             
/* 675 */             .hashCode();
/*     */         }
/*     */ 
/*     */         
/*     */         @SuppressFBWarnings(value = {"DMI_BLOCKING_METHODS_ON_URL"}, justification = "Package sealing relies on URL equality.")
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/* 681 */           if (this == param3Object)
/* 682 */             return true; 
/* 683 */           if (param3Object == null || getClass() != param3Object.getClass()) {
/* 684 */             return false;
/*     */           }
/* 686 */           param3Object = param3Object;
/* 687 */           return (this.sealBase == null) ? ((((ForFixedValue)param3Object).sealBase == null)) : this.sealBase
/*     */             
/* 689 */             .equals(((ForFixedValue)param3Object).sealBase);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class ForTypeResourceUrl
/*     */         implements SealBaseLocator
/*     */       {
/*     */         private static final int EXCLUDE_INITIAL_SLASH = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private static final String CLASS_FILE_EXTENSION = ".class";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private static final String JAR_FILE = "jar";
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private static final String FILE_SYSTEM = "file";
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private static final String RUNTIME_IMAGE = "jrt";
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final PackageDefinitionStrategy.ManifestReading.SealBaseLocator fallback;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ForTypeResourceUrl() {
/* 736 */           this(PackageDefinitionStrategy.ManifestReading.SealBaseLocator.NonSealing.INSTANCE);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ForTypeResourceUrl(PackageDefinitionStrategy.ManifestReading.SealBaseLocator param3SealBaseLocator) {
/* 745 */           this.fallback = param3SealBaseLocator;
/*     */         }
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fallback.equals(((ForTypeResourceUrl)param3Object).fallback))));
/*     */         } public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.fallback.hashCode();
/*     */         } @MaybeNull
/*     */         public URL findSealBase(ClassLoader param3ClassLoader, String param3String) { int i;
/*     */           URL uRL;
/* 754 */           if ((uRL = param3ClassLoader.getResource(param3String.replace('.', '/') + ".class")) != null) {
/*     */             try {
/* 756 */               if (uRL.getProtocol().equals("jar"))
/* 757 */                 return new URL(uRL.getPath().substring(0, uRL.getPath().indexOf('!'))); 
/* 758 */               if (uRL.getProtocol().equals("file"))
/* 759 */                 return uRL; 
/* 760 */               if (uRL.getProtocol().equals("jrt")) {
/*     */                 String str;
/*     */                 
/* 763 */                 return ((i = (str = uRL.getPath()).indexOf('/', 1)) == -1) ? uRL : new URL("jrt:" + str
/*     */                     
/* 765 */                     .substring(0, i));
/*     */               } 
/* 767 */             } catch (MalformedURLException malformedURLException) {
/* 768 */               throw new IllegalStateException("Unexpected URL: " + uRL, malformedURLException);
/*     */             } 
/*     */           }
/* 771 */           return this.fallback.findSealBase((ClassLoader)malformedURLException, i); } } } @Enhance public static class ForTypeResourceUrl implements SealBaseLocator { @MaybeNull public URL findSealBase(ClassLoader param2ClassLoader, String param2String) { int i; URL uRL; if ((uRL = param2ClassLoader.getResource(param2String.replace('.', '/') + ".class")) != null) try { if (uRL.getProtocol().equals("jar")) return new URL(uRL.getPath().substring(0, uRL.getPath().indexOf('!')));  if (uRL.getProtocol().equals("file")) return uRL;  if (uRL.getProtocol().equals("jrt")) { String str; return ((i = (str = uRL.getPath()).indexOf('/', 1)) == -1) ? uRL : new URL("jrt:" + str.substring(0, i)); }  } catch (MalformedURLException malformedURLException) { throw new IllegalStateException("Unexpected URL: " + uRL, malformedURLException); }   return this.fallback.findSealBase((ClassLoader)malformedURLException, i); }
/*     */ 
/*     */       
/*     */       private static final int EXCLUDE_INITIAL_SLASH = 1;
/*     */       private static final String CLASS_FILE_EXTENSION = ".class";
/*     */       private static final String JAR_FILE = "jar";
/*     */       private static final String FILE_SYSTEM = "file";
/*     */       private static final String RUNTIME_IMAGE = "jrt";
/*     */       private final PackageDefinitionStrategy.ManifestReading.SealBaseLocator fallback;
/*     */       
/*     */       public ForTypeResourceUrl() {
/*     */         this(PackageDefinitionStrategy.ManifestReading.SealBaseLocator.NonSealing.INSTANCE);
/*     */       }
/*     */       
/*     */       public ForTypeResourceUrl(PackageDefinitionStrategy.ManifestReading.SealBaseLocator param2SealBaseLocator) {
/*     */         this.fallback = param2SealBaseLocator;
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fallback.equals(((ForTypeResourceUrl)param2Object).fallback))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.fallback.hashCode();
/*     */       } }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\PackageDefinitionStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */