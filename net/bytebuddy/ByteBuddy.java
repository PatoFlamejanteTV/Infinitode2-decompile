/*      */ package net.bytebuddy;
/*      */ 
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.reflect.Type;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.modifier.EnumerationState;
/*      */ import net.bytebuddy.description.modifier.ModifierContributor;
/*      */ import net.bytebuddy.description.modifier.Ownership;
/*      */ import net.bytebuddy.description.modifier.TypeManifestation;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.PackageDescription;
/*      */ import net.bytebuddy.description.type.RecordComponentDescription;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.ClassFileLocator;
/*      */ import net.bytebuddy.dynamic.DynamicType;
/*      */ import net.bytebuddy.dynamic.TargetType;
/*      */ import net.bytebuddy.dynamic.Transformer;
/*      */ import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
/*      */ import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodRegistry;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*      */ import net.bytebuddy.dynamic.scaffold.inline.DecoratingDynamicTypeBuilder;
/*      */ import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
/*      */ import net.bytebuddy.dynamic.scaffold.inline.RebaseDynamicTypeBuilder;
/*      */ import net.bytebuddy.dynamic.scaffold.inline.RedefinitionDynamicTypeBuilder;
/*      */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*      */ import net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.MethodCall;
/*      */ import net.bytebuddy.implementation.SuperMethodCall;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationRetention;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*      */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*      */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.Duplication;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*      */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
/*      */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.matcher.LatentMatcher;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.GraalImageCode;
/*      */ import net.bytebuddy.utility.JavaConstant;
/*      */ import net.bytebuddy.utility.JavaType;
/*      */ import net.bytebuddy.utility.RandomString;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Enhance
/*      */ public class ByteBuddy
/*      */ {
/*      */   public static final String DEFAULT_NAMING_PROPERTY = "net.bytebuddy.naming";
/*      */   private static final String BYTE_BUDDY_DEFAULT_PREFIX = "ByteBuddy";
/*      */   private static final String BYTE_BUDDY_DEFAULT_SUFFIX = "auxiliary";
/*      */   private static final String BYTE_BUDDY_DEFAULT_CONTEXT_NAME = "synthetic";
/*      */   @MaybeNull
/*      */   private static final NamingStrategy DEFAULT_NAMING_STRATEGY;
/*      */   @MaybeNull
/*      */   private static final AuxiliaryType.NamingStrategy DEFAULT_AUXILIARY_NAMING_STRATEGY;
/*      */   @MaybeNull
/*      */   private static final Implementation.Context.Factory DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY;
/*      */   protected final ClassFileVersion classFileVersion;
/*      */   protected final NamingStrategy namingStrategy;
/*      */   protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
/*      */   protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
/*      */   protected final AnnotationRetention annotationRetention;
/*      */   protected final Implementation.Context.Factory implementationContextFactory;
/*      */   protected final MethodGraph.Compiler methodGraphCompiler;
/*      */   protected final InstrumentedType.Factory instrumentedTypeFactory;
/*      */   protected final LatentMatcher<? super MethodDescription> ignoredMethods;
/*      */   protected final TypeValidation typeValidation;
/*      */   protected final VisibilityBridgeStrategy visibilityBridgeStrategy;
/*      */   protected final ClassWriterStrategy classWriterStrategy;
/*      */   private static final boolean ACCESS_CONTROLLER;
/*      */   
/*      */   static {
/*      */     NamingStrategy.Suffixing suffixing;
/*      */     AuxiliaryType.NamingStrategy.Suffixing suffixing1;
/*      */     Implementation.Context.Default.Factory.WithFixedSuffix withFixedSuffix;
/*      */     
/*  198 */     try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */      String str; if ((str = doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("net.bytebuddy.naming"))) == null) { if (GraalImageCode.getCurrent().isDefined()) { suffixing = new NamingStrategy.Suffixing("ByteBuddy", new NamingStrategy.Suffixing.BaseNameResolver.WithCallerSuffix(NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE), "net.bytebuddy.renamed"); suffixing1 = new AuxiliaryType.NamingStrategy.Suffixing("auxiliary"); withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix("synthetic"); }
/*      */       else { str = null; suffixing1 = null; withFixedSuffix = null; }
/*      */        }
/*      */     else if (str.equalsIgnoreCase("fixed")) { suffixing = new NamingStrategy.Suffixing("ByteBuddy", NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE, "net.bytebuddy.renamed"); suffixing1 = new AuxiliaryType.NamingStrategy.Suffixing("auxiliary"); withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix("synthetic"); }
/*      */     else if (suffixing.equalsIgnoreCase("caller")) { suffixing = new NamingStrategy.Suffixing("ByteBuddy", new NamingStrategy.Suffixing.BaseNameResolver.WithCallerSuffix(NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE), "net.bytebuddy.renamed"); suffixing1 = new AuxiliaryType.NamingStrategy.Suffixing("auxiliary"); withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix("synthetic"); }
/*      */     else
/*      */     { long l; try {
/*      */         l = Long.parseLong((String)suffixing);
/*      */       } catch (Exception exception) {
/*      */         throw new IllegalStateException("'net.bytebuddy.naming' is set to an unknown, non-numeric value: " + suffixing);
/*      */       }  suffixing = new NamingStrategy.SuffixingRandom("ByteBuddy", NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE, "net.bytebuddy.renamed", new RandomString(8, new Random(l))); suffixing1 = new AuxiliaryType.NamingStrategy.Suffixing("auxiliary"); withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix("synthetic"); }
/*  210 */      DEFAULT_NAMING_STRATEGY = suffixing; DEFAULT_AUXILIARY_NAMING_STRATEGY = (AuxiliaryType.NamingStrategy)suffixing1; DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY = (Implementation.Context.Factory)withFixedSuffix; } @MaybeNull @Enhance private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) { return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy() {
/*  285 */     this(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy(ClassFileVersion paramClassFileVersion) {
/*  294 */     this(paramClassFileVersion, (DEFAULT_NAMING_STRATEGY == null) ? new NamingStrategy.SuffixingRandom("ByteBuddy") : DEFAULT_NAMING_STRATEGY, (DEFAULT_AUXILIARY_NAMING_STRATEGY == null) ? (AuxiliaryType.NamingStrategy)new AuxiliaryType.NamingStrategy.SuffixingRandom("auxiliary") : DEFAULT_AUXILIARY_NAMING_STRATEGY, (AnnotationValueFilter.Factory)AnnotationValueFilter.Default.APPEND_DEFAULTS, AnnotationRetention.ENABLED, (DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY == null) ? (Implementation.Context.Factory)Implementation.Context.Default.Factory.INSTANCE : DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY, MethodGraph.Compiler.DEFAULT, (InstrumentedType.Factory)InstrumentedType.Factory.Default.MODIFIABLE, TypeValidation.ENABLED, (VisibilityBridgeStrategy)VisibilityBridgeStrategy.Default.ALWAYS, (ClassWriterStrategy)ClassWriterStrategy.Default.CONSTANT_POOL_RETAINING, (LatentMatcher<? super MethodDescription>)new LatentMatcher.Resolved(
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  311 */           (ElementMatcher)ElementMatchers.isSynthetic().or((ElementMatcher)ElementMatchers.isDefaultFinalizer())));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ByteBuddy(ClassFileVersion paramClassFileVersion, NamingStrategy paramNamingStrategy, AuxiliaryType.NamingStrategy paramNamingStrategy1, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, InstrumentedType.Factory paramFactory2, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher) {
/*  342 */     this.classFileVersion = paramClassFileVersion;
/*  343 */     this.namingStrategy = paramNamingStrategy;
/*  344 */     this.auxiliaryTypeNamingStrategy = paramNamingStrategy1;
/*  345 */     this.annotationValueFilterFactory = paramFactory;
/*  346 */     this.annotationRetention = paramAnnotationRetention;
/*  347 */     this.implementationContextFactory = paramFactory1;
/*  348 */     this.methodGraphCompiler = paramCompiler;
/*  349 */     this.instrumentedTypeFactory = paramFactory2;
/*  350 */     this.typeValidation = paramTypeValidation;
/*  351 */     this.visibilityBridgeStrategy = paramVisibilityBridgeStrategy;
/*  352 */     this.classWriterStrategy = paramClassWriterStrategy;
/*  353 */     this.ignoredMethods = paramLatentMatcher;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> subclass(Class<T> paramClass) {
/*  380 */     return (DynamicType.Builder)subclass((TypeDefinition)TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> subclass(Class<T> paramClass, ConstructorStrategy paramConstructorStrategy) {
/*  403 */     return (DynamicType.Builder)subclass((TypeDefinition)TypeDescription.ForLoadedType.of(paramClass), paramConstructorStrategy);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> subclass(Type paramType) {
/*  431 */     return subclass((TypeDefinition)TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> subclass(Type paramType, ConstructorStrategy paramConstructorStrategy) {
/*  455 */     return subclass((TypeDefinition)TypeDefinition.Sort.describe(paramType), paramConstructorStrategy);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> subclass(TypeDefinition paramTypeDefinition) {
/*  483 */     return subclass(paramTypeDefinition, (ConstructorStrategy)ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> subclass(TypeDefinition paramTypeDefinition, ConstructorStrategy paramConstructorStrategy) {
/*      */     TypeDescription.Generic generic;
/*      */     TypeList.Generic.Empty empty;
/*  509 */     if (paramTypeDefinition.isPrimitive() || paramTypeDefinition.isArray() || paramTypeDefinition.isFinal())
/*  510 */       throw new IllegalArgumentException("Cannot subclass primitive, array or final types: " + paramTypeDefinition); 
/*  511 */     if (paramTypeDefinition.isInterface()) {
/*  512 */       generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
/*  513 */       TypeList.Generic.Explicit explicit = new TypeList.Generic.Explicit(new TypeDefinition[] { paramTypeDefinition });
/*      */     } else {
/*  515 */       generic = paramTypeDefinition.asGenericType();
/*  516 */       empty = new TypeList.Generic.Empty();
/*      */     } 
/*  518 */     return (DynamicType.Builder<?>)new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(paramTypeDefinition.asGenericType()), 
/*  519 */           ModifierContributor.Resolver.of(new ModifierContributor.ForType[] { (ModifierContributor.ForType)Visibility.PUBLIC, (ModifierContributor.ForType)TypeManifestation.PLAIN }, ).resolve(paramTypeDefinition.getModifiers()), generic)
/*  520 */         .withInterfaces((TypeList.Generic)empty), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, paramConstructorStrategy);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> makeInterface() {
/*  546 */     return makeInterface(Collections.emptyList());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> makeInterface(Class<T> paramClass) {
/*  567 */     return (DynamicType.Builder)makeInterface(Collections.singletonList(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> makeInterface(Type... paramVarArgs) {
/*  589 */     return makeInterface(Arrays.asList(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> makeInterface(List<? extends Type> paramList) {
/*  611 */     return makeInterface((Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(paramList));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> makeInterface(TypeDefinition... paramVarArgs) {
/*  633 */     return makeInterface(Arrays.asList(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> makeInterface(Collection<? extends TypeDefinition> paramCollection) {
/*  655 */     return subclass((Class)Object.class, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).implement(paramCollection).modifiers(new ModifierContributor.ForType[] { (ModifierContributor.ForType)TypeManifestation.INTERFACE, (ModifierContributor.ForType)Visibility.PUBLIC });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> makePackage(String paramString) {
/*  673 */     return (DynamicType.Builder<?>)new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(paramString + ".package-info", 5632, 
/*      */           
/*  675 */           TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> makeRecord() {
/*  708 */     TypeDescription.Generic generic = InstrumentedType.Default.of(JavaType.RECORD.getTypeStub().getName(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new ModifierContributor.ForType[] { (ModifierContributor.ForType)Visibility.PUBLIC }).withMethod(new MethodDescription.Token(4)).withMethod(new MethodDescription.Token("hashCode", 1025, TypeDescription.ForLoadedType.of(int.class).asGenericType())).withMethod(new MethodDescription.Token("equals", 1025, TypeDescription.ForLoadedType.of(boolean.class).asGenericType(), Collections.singletonList(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)))).withMethod(new MethodDescription.Token("toString", 1025, TypeDescription.ForLoadedType.of(String.class).asGenericType())).asGenericType();
/*  709 */     return (DynamicType.Builder<?>)(new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(generic), 17, generic).withRecord(true), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, RecordConstructorStrategy.INSTANCE))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  721 */       .method((ElementMatcher)ElementMatchers.isHashCode()).intercept(RecordObjectMethod.HASH_CODE)
/*  722 */       .method((ElementMatcher)ElementMatchers.isEquals()).intercept(RecordObjectMethod.EQUALS)
/*  723 */       .method((ElementMatcher)ElementMatchers.isToString()).intercept(RecordObjectMethod.TO_STRING);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<? extends Annotation> makeAnnotation() {
/*  739 */     return (DynamicType.Builder<? extends Annotation>)new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Annotation.class)), 
/*  740 */           ModifierContributor.Resolver.of(new ModifierContributor.ForType[] { (ModifierContributor.ForType)Visibility.PUBLIC, (ModifierContributor.ForType)TypeManifestation.ANNOTATION }, ).resolve(), 
/*  741 */           TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)).withInterfaces((TypeList.Generic)new TypeList.Generic.Explicit(new TypeDefinition[] { (TypeDefinition)TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Annotation.class) })), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<? extends Enum<?>> makeEnumeration(String... paramVarArgs) {
/*  768 */     return makeEnumeration(Arrays.asList(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<? extends Enum<?>> makeEnumeration(Collection<? extends String> paramCollection) {
/*  784 */     if (paramCollection.isEmpty()) {
/*  785 */       throw new IllegalArgumentException("Require at least one enumeration constant");
/*      */     }
/*  787 */     TypeDescription.Generic generic = TypeDescription.Generic.Builder.parameterizedType(Enum.class, new Type[] { TargetType.class }).build();
/*  788 */     return (DynamicType.Builder<? extends Enum<?>>)(new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(generic), 
/*  789 */           ModifierContributor.Resolver.of(new ModifierContributor.ForType[] { (ModifierContributor.ForType)Visibility.PUBLIC, (ModifierContributor.ForType)TypeManifestation.FINAL, (ModifierContributor.ForType)EnumerationState.ENUMERATION }, ).resolve(), generic), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  802 */       .defineConstructor(new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE }).withParameters(new Type[] { String.class, int.class
/*  803 */         }).intercept((Implementation)SuperMethodCall.INSTANCE)
/*  804 */       .defineMethod("valueOf", TargetType.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC, (ModifierContributor.ForMethod)Ownership.STATIC
/*      */         
/*  806 */         }).withParameters(new Type[] { String.class
/*  807 */         }).intercept((Implementation)MethodCall.invoke((MethodDescription)((MethodList)generic.getDeclaredMethods()
/*  808 */           .filter((ElementMatcher)ElementMatchers.named("valueOf").and((ElementMatcher)ElementMatchers.takesArguments(new Class[] { Class.class, String.class })))).getOnly())
/*  809 */         .withOwnType().withArgument(new int[] { 0
/*  810 */           }).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC))
/*  811 */       .defineMethod("values", TargetType[].class, new ModifierContributor.ForMethod[] {
/*      */           
/*      */           (ModifierContributor.ForMethod)Visibility.PUBLIC, (ModifierContributor.ForMethod)Ownership.STATIC
/*  814 */         }).intercept(new EnumerationImplementation(new ArrayList<String>(paramCollection)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> redefine(Class<T> paramClass) {
/*  839 */     return redefine(paramClass, ClassFileLocator.ForClassLoader.of(paramClass.getClassLoader()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> redefine(Class<T> paramClass, ClassFileLocator paramClassFileLocator) {
/*  861 */     return redefine(TypeDescription.ForLoadedType.of(paramClass), paramClassFileLocator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> redefine(TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*  883 */     if (paramTypeDescription.isArray() || paramTypeDescription.isPrimitive()) {
/*  884 */       throw new IllegalArgumentException("Cannot redefine array or primitive type: " + paramTypeDescription);
/*      */     }
/*  886 */     return (DynamicType.Builder<T>)new RedefinitionDynamicTypeBuilder(this.instrumentedTypeFactory.represent(paramTypeDescription), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, paramTypeDescription, paramClassFileLocator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> rebase(Class<T> paramClass) {
/*  917 */     return rebase(paramClass, ClassFileLocator.ForClassLoader.of(paramClass.getClassLoader()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> rebase(Class<T> paramClass, ClassFileLocator paramClassFileLocator) {
/*  938 */     return rebase(TypeDescription.ForLoadedType.of(paramClass), paramClassFileLocator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> rebase(Class<T> paramClass, ClassFileLocator paramClassFileLocator, MethodNameTransformer paramMethodNameTransformer) {
/*  953 */     return rebase(TypeDescription.ForLoadedType.of(paramClass), paramClassFileLocator, paramMethodNameTransformer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> rebase(TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*  974 */     return rebase(paramTypeDescription, paramClassFileLocator, MethodNameTransformer.Suffixing.withRandomSuffix());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> rebase(TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator, MethodNameTransformer paramMethodNameTransformer) {
/*  989 */     if (paramTypeDescription.isArray() || paramTypeDescription.isPrimitive()) {
/*  990 */       throw new IllegalArgumentException("Cannot rebase array or primitive type: " + paramTypeDescription);
/*      */     }
/*  992 */     return (DynamicType.Builder<T>)new RebaseDynamicTypeBuilder(this.instrumentedTypeFactory.represent(paramTypeDescription), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, paramTypeDescription, paramClassFileLocator, paramMethodNameTransformer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> rebase(Package paramPackage, ClassFileLocator paramClassFileLocator) {
/* 1018 */     return rebase((PackageDescription)new PackageDescription.ForLoadedPackage(paramPackage), paramClassFileLocator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DynamicType.Builder<?> rebase(PackageDescription paramPackageDescription, ClassFileLocator paramClassFileLocator) {
/* 1031 */     return rebase((TypeDescription)new TypeDescription.ForPackageDescription(paramPackageDescription), paramClassFileLocator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> decorate(Class<T> paramClass) {
/* 1051 */     return decorate(paramClass, ClassFileLocator.ForClassLoader.of(paramClass.getClassLoader()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> decorate(Class<T> paramClass, ClassFileLocator paramClassFileLocator) {
/* 1072 */     return decorate(TypeDescription.ForLoadedType.of(paramClass), paramClassFileLocator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> DynamicType.Builder<T> decorate(TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/* 1093 */     if (paramTypeDescription.isArray() || paramTypeDescription.isPrimitive()) {
/* 1094 */       throw new IllegalArgumentException("Cannot decorate array or primitive type: " + paramTypeDescription);
/*      */     }
/* 1096 */     return (DynamicType.Builder<T>)new DecoratingDynamicTypeBuilder(paramTypeDescription, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, paramClassFileLocator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(ClassFileVersion paramClassFileVersion) {
/* 1119 */     return new ByteBuddy(paramClassFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(NamingStrategy paramNamingStrategy) {
/* 1143 */     return new ByteBuddy(this.classFileVersion, paramNamingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(AuxiliaryType.NamingStrategy paramNamingStrategy) {
/* 1166 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, paramNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(AnnotationValueFilter.Factory paramFactory) {
/* 1190 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, paramFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(AnnotationRetention paramAnnotationRetention) {
/* 1221 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, paramAnnotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(Implementation.Context.Factory paramFactory) {
/* 1247 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, paramFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(MethodGraph.Compiler paramCompiler) {
/* 1273 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, paramCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(InstrumentedType.Factory paramFactory) {
/* 1295 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, paramFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(TypeValidation paramTypeValidation) {
/* 1319 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, paramTypeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(VisibilityBridgeStrategy paramVisibilityBridgeStrategy) {
/* 1341 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, paramVisibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy with(ClassWriterStrategy paramClassWriterStrategy) {
/* 1363 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, paramClassWriterStrategy, this.ignoredMethods);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy ignore(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/* 1387 */     return ignore((LatentMatcher<? super MethodDescription>)new LatentMatcher.Resolved(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuddy ignore(LatentMatcher<? super MethodDescription> paramLatentMatcher) {
/* 1403 */     return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, paramLatentMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.annotationRetention.equals(((ByteBuddy)paramObject).annotationRetention) ? false : (!this.typeValidation.equals(((ByteBuddy)paramObject).typeValidation) ? false : (!this.classFileVersion.equals(((ByteBuddy)paramObject).classFileVersion) ? false : (!this.namingStrategy.equals(((ByteBuddy)paramObject).namingStrategy) ? false : (!this.auxiliaryTypeNamingStrategy.equals(((ByteBuddy)paramObject).auxiliaryTypeNamingStrategy) ? false : (!this.annotationValueFilterFactory.equals(((ByteBuddy)paramObject).annotationValueFilterFactory) ? false : (!this.implementationContextFactory.equals(((ByteBuddy)paramObject).implementationContextFactory) ? false : (!this.methodGraphCompiler.equals(((ByteBuddy)paramObject).methodGraphCompiler) ? false : (!this.instrumentedTypeFactory.equals(((ByteBuddy)paramObject).instrumentedTypeFactory) ? false : (!this.ignoredMethods.equals(((ByteBuddy)paramObject).ignoredMethods) ? false : (!this.visibilityBridgeStrategy.equals(((ByteBuddy)paramObject).visibilityBridgeStrategy) ? false : (!!this.classWriterStrategy.equals(((ByteBuddy)paramObject).classWriterStrategy)))))))))))))));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*      */     return (((((((((((getClass().hashCode() * 31 + this.classFileVersion.hashCode()) * 31 + this.namingStrategy.hashCode()) * 31 + this.auxiliaryTypeNamingStrategy.hashCode()) * 31 + this.annotationValueFilterFactory.hashCode()) * 31 + this.annotationRetention.hashCode()) * 31 + this.implementationContextFactory.hashCode()) * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.instrumentedTypeFactory.hashCode()) * 31 + this.ignoredMethods.hashCode()) * 31 + this.typeValidation.hashCode()) * 31 + this.visibilityBridgeStrategy.hashCode()) * 31 + this.classWriterStrategy.hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class EnumerationImplementation
/*      */     implements Implementation
/*      */   {
/*      */     protected static final String CLONE_METHOD_NAME = "clone";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static final String ENUM_VALUE_OF_METHOD_NAME = "valueOf";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static final String ENUM_VALUES_METHOD_NAME = "values";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final int ENUM_FIELD_MODIFIERS = 25;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String ENUM_VALUES = "$VALUES";
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<String> values;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected EnumerationImplementation(List<String> param1List) {
/* 1459 */       this.values = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1466 */       for (String str : this.values) {
/* 1467 */         param1InstrumentedType = param1InstrumentedType.withField(new FieldDescription.Token(str, 16409, TargetType.DESCRIPTION
/*      */               
/* 1469 */               .asGenericType()));
/*      */       }
/* 1471 */       return param1InstrumentedType
/* 1472 */         .withField(new FieldDescription.Token("$VALUES", 4121, 
/*      */             
/* 1474 */             TypeDescription.ArrayProjection.of(TargetType.DESCRIPTION).asGenericType()))
/* 1475 */         .withInitializer(new InitializationAppender(this.values));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 1482 */       return new ValuesMethodAppender(param1Target.getInstrumentedType());
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.values.equals(((EnumerationImplementation)param1Object).values))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.values.hashCode();
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     protected static class ValuesMethodAppender
/*      */       implements ByteCodeAppender
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */       
/*      */       protected ValuesMethodAppender(TypeDescription param2TypeDescription) {
/* 1502 */         this.instrumentedType = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 1509 */         FieldDescription fieldDescription = (FieldDescription)((FieldList)this.instrumentedType.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("$VALUES"))).getOnly();
/* 1510 */         MethodDescription methodDescription = (MethodDescription)((MethodList)TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("clone"))).getOnly();
/* 1511 */         return new ByteCodeAppender.Size((new StackManipulation.Compound(new StackManipulation[] {
/* 1512 */                 FieldAccess.forField(fieldDescription).read(), 
/* 1513 */                 MethodInvocation.invoke(methodDescription).virtual(fieldDescription.getType().asErasure()), 
/* 1514 */                 TypeCasting.to((TypeDefinition)fieldDescription.getType().asErasure()), (StackManipulation)MethodReturn.REFERENCE
/*      */               },
/* 1516 */             )).apply(param2MethodVisitor, param2Context).getMaximalSize(), param2MethodDescription.getStackSize());
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ValuesMethodAppender)param2Object).instrumentedType))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     protected static class InitializationAppender
/*      */       implements ByteCodeAppender
/*      */     {
/*      */       private final List<String> values;
/*      */       
/*      */       protected InitializationAppender(List<String> param2List) {
/* 1537 */         this.values = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/*      */         TypeDescription typeDescription;
/* 1547 */         MethodDescription methodDescription = (MethodDescription)((MethodList)(typeDescription = param2MethodDescription.getDeclaringType().asErasure()).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(new Class[] { String.class, int.class })))).getOnly();
/* 1548 */         byte b = 0;
/* 1549 */         StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE;
/* 1550 */         ArrayList<FieldDescription> arrayList = new ArrayList(this.values.size());
/* 1551 */         for (String str : this.values) {
/* 1552 */           FieldDescription fieldDescription = (FieldDescription)((FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(str))).getOnly();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1559 */           compound = new StackManipulation.Compound(new StackManipulation[] { (StackManipulation)trivial, TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, (StackManipulation)new TextConstant(str), IntegerConstant.forValue(b++), (StackManipulation)MethodInvocation.invoke(methodDescription), FieldAccess.forField(fieldDescription).write() });
/* 1560 */           arrayList.add(fieldDescription);
/*      */         } 
/* 1562 */         ArrayList<StackManipulation> arrayList1 = new ArrayList(this.values.size());
/* 1563 */         for (FieldDescription fieldDescription : arrayList) {
/* 1564 */           arrayList1.add(FieldAccess.forField(fieldDescription).read());
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1569 */         StackManipulation.Compound compound = new StackManipulation.Compound(new StackManipulation[] { (StackManipulation)compound, ArrayFactory.forType(typeDescription.asGenericType()).withValues(arrayList1), FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("$VALUES"))).getOnly()).write() });
/*      */         
/* 1571 */         return new ByteCodeAppender.Size(compound.apply(param2MethodVisitor, param2Context).getMaximalSize(), param2MethodDescription.getStackSize());
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.values.equals(((InitializationAppender)param2Object).values))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.values.hashCode();
/*      */       } }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   protected enum RecordConstructorStrategy implements ConstructorStrategy, Implementation {
/* 1585 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final List<MethodDescription.Token> extractConstructors(TypeDescription param1TypeDescription) {
/* 1591 */       ArrayList<ParameterDescription.Token> arrayList = new ArrayList(param1TypeDescription.getRecordComponents().size());
/* 1592 */       for (RecordComponentDescription.InDefinedShape inDefinedShape : param1TypeDescription.getRecordComponents()) {
/* 1593 */         arrayList.add(new ParameterDescription.Token(inDefinedShape.getType(), (List)inDefinedShape
/* 1594 */               .getDeclaredAnnotations().filter((ElementMatcher)ElementMatchers.targetsElement(ElementType.CONSTRUCTOR)), inDefinedShape
/* 1595 */               .getActualName(), 
/* 1596 */               Integer.valueOf(0)));
/*      */       }
/* 1598 */       return Collections.singletonList(new MethodDescription.Token("<init>", 1, 
/*      */             
/* 1600 */             Collections.emptyList(), 
/* 1601 */             TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class), arrayList, 
/*      */             
/* 1603 */             Collections.emptyList(), 
/* 1604 */             Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodRegistry inject(TypeDescription param1TypeDescription, MethodRegistry param1MethodRegistry) {
/* 1613 */       return param1MethodRegistry.prepend((LatentMatcher)new LatentMatcher.Resolved((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesGenericArguments((List)param1TypeDescription.getRecordComponents().asTypeList()))), (MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation(this), (MethodAttributeAppender.Factory)MethodAttributeAppender.ForInstrumentedMethod.EXCLUDING_RECEIVER, 
/*      */ 
/*      */           
/* 1616 */           Transformer.NoOp.make());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final ByteCodeAppender appender(Implementation.Target param1Target) {
/* 1623 */       return new Appender(param1Target.getInstrumentedType());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1630 */       for (RecordComponentDescription.InDefinedShape inDefinedShape : param1InstrumentedType.getRecordComponents())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1636 */         param1InstrumentedType = param1InstrumentedType.withField(new FieldDescription.Token(inDefinedShape.getActualName(), 18, inDefinedShape.getType(), (List)inDefinedShape.getDeclaredAnnotations().filter((ElementMatcher)ElementMatchers.targetsElement(ElementType.FIELD)))).withMethod(new MethodDescription.Token(inDefinedShape.getActualName(), 1, 
/*      */               
/* 1638 */               Collections.emptyList(), inDefinedShape
/* 1639 */               .getType(), 
/* 1640 */               Collections.emptyList(), 
/* 1641 */               Collections.emptyList(), (List)inDefinedShape
/* 1642 */               .getDeclaredAnnotations().filter((ElementMatcher)ElementMatchers.targetsElement(ElementType.METHOD)), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
/*      */       }
/*      */ 
/*      */       
/* 1646 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class Appender
/*      */       implements ByteCodeAppender
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Appender(TypeDescription param2TypeDescription) {
/* 1666 */         this.instrumentedType = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 1673 */         if (param2MethodDescription.isMethod()) {
/* 1674 */           return (new ByteCodeAppender.Simple(new StackManipulation[] {
/* 1675 */                 MethodVariableAccess.loadThis(), 
/* 1676 */                 FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)this.instrumentedType.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(param2MethodDescription.getName()))).getOnly()).read(), 
/* 1677 */                 MethodReturn.of((TypeDefinition)param2MethodDescription.getReturnType())
/* 1678 */               })).apply(param2MethodVisitor, param2Context, param2MethodDescription);
/*      */         }
/*      */         ArrayList<StackManipulation> arrayList;
/* 1681 */         (arrayList = new ArrayList<StackManipulation>(this.instrumentedType.getRecordComponents().size() * 3 + 2)).add(MethodVariableAccess.loadThis());
/* 1682 */         arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.Latent(JavaType.RECORD.getTypeStub(), new MethodDescription.Token(1))));
/* 1683 */         int i = 1;
/* 1684 */         for (RecordComponentDescription.InDefinedShape inDefinedShape : this.instrumentedType.getRecordComponents()) {
/* 1685 */           arrayList.add(MethodVariableAccess.loadThis());
/* 1686 */           arrayList.add(MethodVariableAccess.of((TypeDefinition)inDefinedShape.getType()).loadFrom(i));
/* 1687 */           arrayList.add(FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)this.instrumentedType.getDeclaredFields()
/* 1688 */                 .filter((ElementMatcher)ElementMatchers.named(inDefinedShape.getActualName())))
/* 1689 */                 .getOnly()).write());
/* 1690 */           i += inDefinedShape.getType().getStackSize().getSize();
/*      */         } 
/* 1692 */         arrayList.add(MethodReturn.VOID);
/* 1693 */         return (new ByteCodeAppender.Simple(arrayList)).apply(param2MethodVisitor, param2Context, param2MethodDescription);
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((Appender)param2Object).instrumentedType))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   protected enum RecordObjectMethod implements Implementation {
/* 1708 */     HASH_CODE("hashCode", StackManipulation.Trivial.INSTANCE, (String)int.class, (StackManipulation)new Class[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1713 */     EQUALS("equals", MethodVariableAccess.REFERENCE.loadFrom(1), (String)boolean.class, (StackManipulation)new Class[] { Object.class
/*      */ 
/*      */ 
/*      */       
/*      */       }),
/* 1718 */     TO_STRING("toString", StackManipulation.Trivial.INSTANCE, (String)String.class, (StackManipulation)new Class[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final StackManipulation stackManipulation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription returnType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription> arguments;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     RecordObjectMethod(String param1String1, StackManipulation param1StackManipulation, Class<?> param1Class, Class<?>... param1VarArgs) {
/* 1749 */       this.name = param1String1;
/* 1750 */       this.stackManipulation = param1StackManipulation;
/* 1751 */       this.returnType = TypeDescription.ForLoadedType.of(param1Class);
/* 1752 */       this.arguments = (List<? extends TypeDescription>)new TypeList.ForLoadedTypes(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final ByteCodeAppender appender(Implementation.Target param1Target) {
/* 1759 */       StringBuilder stringBuilder = new StringBuilder();
/* 1760 */       ArrayList<JavaConstant.MethodHandle> arrayList = new ArrayList(param1Target.getInstrumentedType().getRecordComponents().size());
/* 1761 */       for (RecordComponentDescription.InDefinedShape inDefinedShape : param1Target.getInstrumentedType().getRecordComponents()) {
/* 1762 */         if (stringBuilder.length() > 0) {
/* 1763 */           stringBuilder.append(";");
/*      */         }
/* 1765 */         stringBuilder.append(inDefinedShape.getActualName());
/* 1766 */         arrayList.add(JavaConstant.MethodHandle.ofGetter((FieldDescription.InDefinedShape)((FieldList)param1Target.getInstrumentedType().getDeclaredFields()
/* 1767 */               .filter((ElementMatcher)ElementMatchers.named(inDefinedShape.getActualName())))
/* 1768 */               .getOnly()));
/*      */       } 
/* 1770 */       return (ByteCodeAppender)new ByteCodeAppender.Simple(new StackManipulation[] { MethodVariableAccess.loadThis(), this.stackManipulation, 
/*      */             
/* 1772 */             MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.Latent(JavaType.OBJECT_METHODS.getTypeStub(), new MethodDescription.Token("bootstrap", 9, 
/*      */                   
/* 1774 */                   TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), 
/* 1775 */                   Arrays.asList(new TypeDescription.Generic[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType(), 
/* 1776 */                       TypeDescription.ForLoadedType.of(String.class).asGenericType(), JavaType.TYPE_DESCRIPTOR
/* 1777 */                       .getTypeStub().asGenericType(), 
/* 1778 */                       TypeDescription.ForLoadedType.of(Class.class).asGenericType(), 
/* 1779 */                       TypeDescription.ForLoadedType.of(String.class).asGenericType(), 
/* 1780 */                       TypeDescription.ArrayProjection.of(JavaType.METHOD_HANDLE.getTypeStub()).asGenericType() })))).dynamic(this.name, this.returnType, 
/*      */               
/* 1782 */               CompoundList.of(param1Target.getInstrumentedType(), this.arguments), 
/* 1783 */               CompoundList.of(Arrays.asList(new JavaConstant[] { JavaConstant.Simple.of(param1Target.getInstrumentedType()), JavaConstant.Simple.ofLoaded(stringBuilder.toString()) }, ), arrayList)), 
/* 1784 */             MethodReturn.of((TypeDefinition)this.returnType) });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1791 */       return param1InstrumentedType;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\ByteBuddy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */