/*     */ package net.bytebuddy;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.utility.RandomString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface NamingStrategy
/*     */ {
/*     */   public static final String BYTE_BUDDY_RENAME_PACKAGE = "net.bytebuddy.renamed";
/*     */   public static final String NO_PREFIX = "";
/*     */   
/*     */   String subclass(TypeDescription.Generic paramGeneric);
/*     */   
/*     */   String redefine(TypeDescription paramTypeDescription);
/*     */   
/*     */   String rebase(TypeDescription paramTypeDescription);
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     implements NamingStrategy
/*     */   {
/*     */     public String subclass(TypeDescription.Generic param1Generic) {
/*  76 */       return name(param1Generic.asErasure());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract String name(TypeDescription param1TypeDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String redefine(TypeDescription param1TypeDescription) {
/*  91 */       return param1TypeDescription.getName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String rebase(TypeDescription param1TypeDescription) {
/*  98 */       return param1TypeDescription.getName();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Suffixing
/*     */     extends AbstractBase
/*     */   {
/*     */     private static final String JAVA_PACKAGE = "java.";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String suffix;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String javaLangPackagePrefix;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final BaseNameResolver baseNameResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Suffixing(String param1String) {
/* 137 */       this(param1String, BaseNameResolver.ForUnnamedType.INSTANCE);
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
/*     */     public Suffixing(String param1String1, String param1String2) {
/* 150 */       this(param1String1, BaseNameResolver.ForUnnamedType.INSTANCE, param1String2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Suffixing(String param1String, BaseNameResolver param1BaseNameResolver) {
/* 161 */       this(param1String, param1BaseNameResolver, "net.bytebuddy.renamed");
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
/*     */     public Suffixing(String param1String1, BaseNameResolver param1BaseNameResolver, String param1String2) {
/* 175 */       this.suffix = param1String1;
/* 176 */       this.baseNameResolver = param1BaseNameResolver;
/* 177 */       this.javaLangPackagePrefix = param1String2;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String name(TypeDescription param1TypeDescription) {
/*     */       String str;
/* 183 */       if ((str = this.baseNameResolver.resolve(param1TypeDescription)).startsWith("java.") && !this.javaLangPackagePrefix.equals("")) {
/* 184 */         str = this.javaLangPackagePrefix + "." + str;
/*     */       }
/* 186 */       return str + "$" + this.suffix;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.suffix.equals(((Suffixing)param1Object).suffix) ? false : (!this.javaLangPackagePrefix.equals(((Suffixing)param1Object).javaLangPackagePrefix) ? false : (!!this.baseNameResolver.equals(((Suffixing)param1Object).baseNameResolver))))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return ((getClass().hashCode() * 31 + this.suffix.hashCode()) * 31 + this.javaLangPackagePrefix.hashCode()) * 31 + this.baseNameResolver.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum ForUnnamedType
/*     */       implements BaseNameResolver
/*     */     {
/* 210 */       INSTANCE;
/*     */ 
/*     */ 
/*     */       
/*     */       public final String resolve(TypeDescription param2TypeDescription)
/*     */       {
/* 216 */         return param2TypeDescription.getName(); } } public static interface BaseNameResolver { String resolve(TypeDescription param2TypeDescription); public enum ForUnnamedType implements BaseNameResolver { public final String resolve(TypeDescription param3TypeDescription) { return param3TypeDescription.getName(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         INSTANCE; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class ForGivenType
/*     */         implements BaseNameResolver
/*     */       {
/*     */         private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */         
/*     */         public ForGivenType(TypeDescription param3TypeDescription) {
/* 237 */           this.typeDescription = param3TypeDescription;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String resolve(TypeDescription param3TypeDescription) {
/* 244 */           return this.typeDescription.getName();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForGivenType)param3Object).typeDescription))));
/*     */         }
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */         }
/*     */       }
/*     */       
/*     */       @Enhance
/*     */       public static class ForFixedValue
/*     */         implements BaseNameResolver
/*     */       {
/*     */         private final String name;
/*     */         
/*     */         public ForFixedValue(String param3String) {
/* 265 */           this.name = param3String;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String resolve(TypeDescription param3TypeDescription) {
/* 272 */           return this.name;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.name.equals(((ForFixedValue)param3Object).name))));
/*     */         }
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.name.hashCode();
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class WithCallerSuffix
/*     */         implements BaseNameResolver
/*     */       {
/*     */         private final NamingStrategy.Suffixing.BaseNameResolver delegate;
/*     */         
/*     */         public WithCallerSuffix(NamingStrategy.Suffixing.BaseNameResolver param3BaseNameResolver) {
/* 294 */           this.delegate = param3BaseNameResolver;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String resolve(TypeDescription param3TypeDescription) {
/* 301 */           boolean bool = false;
/* 302 */           String str = null; StackTraceElement[] arrayOfStackTraceElement; int i; byte b;
/* 303 */           for (i = (arrayOfStackTraceElement = (new Throwable()).getStackTrace()).length, b = 0; b < i; b++) {
/* 304 */             StackTraceElement stackTraceElement; if ((stackTraceElement = arrayOfStackTraceElement[b]).getClassName().equals(ByteBuddy.class.getName())) {
/* 305 */               bool = true;
/* 306 */             } else if (bool) {
/* 307 */               str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
/*     */               break;
/*     */             } 
/*     */           } 
/* 311 */           if (str == null) {
/* 312 */             throw new IllegalStateException("Base name resolver not invoked via " + ByteBuddy.class);
/*     */           }
/* 314 */           return this.delegate.resolve(param3TypeDescription) + "$" + str.replace('.', '$');
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.delegate.equals(((WithCallerSuffix)param3Object).delegate))));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.delegate.hashCode();
/*     */         }
/*     */       } }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class SuffixingRandom
/*     */     extends Suffixing
/*     */   {
/*     */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */     private final RandomString randomString;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SuffixingRandom(String param1String) {
/* 349 */       this(param1String, NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE);
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
/*     */     public SuffixingRandom(String param1String1, String param1String2) {
/* 362 */       this(param1String1, NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE, param1String2);
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
/*     */     @Deprecated
/*     */     public SuffixingRandom(String param1String, BaseNameResolver param1BaseNameResolver) {
/* 375 */       this(param1String, param1BaseNameResolver);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SuffixingRandom(String param1String, NamingStrategy.Suffixing.BaseNameResolver param1BaseNameResolver) {
/* 386 */       this(param1String, param1BaseNameResolver, "net.bytebuddy.renamed");
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
/*     */     @Deprecated
/*     */     public SuffixingRandom(String param1String1, BaseNameResolver param1BaseNameResolver, String param1String2) {
/* 402 */       this(param1String1, param1BaseNameResolver, param1String2);
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
/*     */     public SuffixingRandom(String param1String1, NamingStrategy.Suffixing.BaseNameResolver param1BaseNameResolver, String param1String2) {
/* 416 */       this(param1String1, param1BaseNameResolver, param1String2, new RandomString());
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
/*     */     @Deprecated
/*     */     public SuffixingRandom(String param1String1, BaseNameResolver param1BaseNameResolver, String param1String2, RandomString param1RandomString) {
/* 433 */       this(param1String1, param1BaseNameResolver, param1String2, param1RandomString);
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
/*     */     public SuffixingRandom(String param1String1, NamingStrategy.Suffixing.BaseNameResolver param1BaseNameResolver, String param1String2, RandomString param1RandomString) {
/* 448 */       super(param1String1, param1BaseNameResolver, param1String2);
/* 449 */       this.randomString = param1RandomString;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String name(TypeDescription param1TypeDescription) {
/* 454 */       return super.name(param1TypeDescription) + "$" + this.randomString.nextString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass()))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public static interface BaseNameResolver
/*     */       extends NamingStrategy.Suffixing.BaseNameResolver
/*     */     {
/*     */       @Deprecated
/*     */       public enum ForUnnamedType
/*     */         implements BaseNameResolver
/*     */       {
/* 476 */         INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final String resolve(TypeDescription param3TypeDescription) {
/* 482 */           return param3TypeDescription.getName();
/*     */         }
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
/*     */       @Deprecated
/*     */       @Enhance
/*     */       public static class ForGivenType
/*     */         extends NamingStrategy.Suffixing.BaseNameResolver.ForGivenType
/*     */         implements BaseNameResolver
/*     */       {
/*     */         public ForGivenType(TypeDescription param3TypeDescription) {
/* 501 */           super(param3TypeDescription);
/*     */         }
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : (!(getClass() != param3Object.getClass()))));
/*     */         }
/*     */         
/*     */         public int hashCode() {
/*     */           return super.hashCode();
/*     */         }
/*     */       }
/*     */       
/*     */       @Deprecated
/*     */       @Enhance
/*     */       public static class ForFixedValue
/*     */         extends NamingStrategy.Suffixing.BaseNameResolver.ForFixedValue
/*     */         implements BaseNameResolver
/*     */       {
/*     */         public ForFixedValue(String param3String) {
/* 520 */           super(param3String);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : (!(getClass() != param3Object.getClass()))));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return super.hashCode();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class PrefixingRandom
/*     */     extends AbstractBase
/*     */   {
/*     */     private final String prefix;
/*     */     
/*     */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */     private final RandomString randomString;
/*     */ 
/*     */     
/*     */     public PrefixingRandom(String param1String) {
/* 550 */       this.prefix = param1String;
/* 551 */       this.randomString = new RandomString();
/*     */     }
/*     */ 
/*     */     
/*     */     protected String name(TypeDescription param1TypeDescription) {
/* 556 */       return this.prefix + "." + param1TypeDescription.getName() + "$" + this.randomString.nextString();
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.prefix.equals(((PrefixingRandom)param1Object).prefix))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.prefix.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\NamingStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */