/*     */ package net.bytebuddy.dynamic.scaffold.inline;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.type.RecordComponentDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeVariableToken;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.Transformer;
/*     */ import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeWriter;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationRetention;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*     */ import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
/*     */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.matcher.LatentMatcher;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.CompoundList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class DecoratingDynamicTypeBuilder<T>
/*     */   extends DynamicType.Builder.AbstractBase.UsingTypeWriter<T>
/*     */ {
/*     */   private final TypeDescription instrumentedType;
/*     */   private final TypeAttributeAppender typeAttributeAppender;
/*     */   private final AsmVisitorWrapper asmVisitorWrapper;
/*     */   private final ClassFileVersion classFileVersion;
/*     */   private final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
/*     */   private final AnnotationValueFilter.Factory annotationValueFilterFactory;
/*     */   private final AnnotationRetention annotationRetention;
/*     */   private final Implementation.Context.Factory implementationContextFactory;
/*     */   private final MethodGraph.Compiler methodGraphCompiler;
/*     */   private final TypeValidation typeValidation;
/*     */   private final ClassWriterStrategy classWriterStrategy;
/*     */   private final LatentMatcher<? super MethodDescription> ignoredMethods;
/*     */   private final List<DynamicType> auxiliaryTypes;
/*     */   private final ClassFileLocator classFileLocator;
/*     */   
/*     */   public DecoratingDynamicTypeBuilder(TypeDescription paramTypeDescription, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, ClassFileLocator paramClassFileLocator) {
/* 160 */     this(paramTypeDescription, 
/* 161 */         paramAnnotationRetention.isEnabled() ? (TypeAttributeAppender)new TypeAttributeAppender.ForInstrumentedType.Differentiating(paramTypeDescription) : (TypeAttributeAppender)TypeAttributeAppender.ForInstrumentedType.INSTANCE, (AsmVisitorWrapper)AsmVisitorWrapper.NoOp.INSTANCE, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramClassWriterStrategy, paramLatentMatcher, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 174 */         Collections.emptyList(), paramClassFileLocator);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DecoratingDynamicTypeBuilder(TypeDescription paramTypeDescription, TypeAttributeAppender paramTypeAttributeAppender, AsmVisitorWrapper paramAsmVisitorWrapper, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, List<DynamicType> paramList, ClassFileLocator paramClassFileLocator) {
/* 210 */     this.instrumentedType = paramTypeDescription;
/* 211 */     this.typeAttributeAppender = paramTypeAttributeAppender;
/* 212 */     this.asmVisitorWrapper = paramAsmVisitorWrapper;
/* 213 */     this.classFileVersion = paramClassFileVersion;
/* 214 */     this.auxiliaryTypeNamingStrategy = paramNamingStrategy;
/* 215 */     this.annotationValueFilterFactory = paramFactory;
/* 216 */     this.annotationRetention = paramAnnotationRetention;
/* 217 */     this.implementationContextFactory = paramFactory1;
/* 218 */     this.methodGraphCompiler = paramCompiler;
/* 219 */     this.typeValidation = paramTypeValidation;
/* 220 */     this.classWriterStrategy = paramClassWriterStrategy;
/* 221 */     this.ignoredMethods = paramLatentMatcher;
/* 222 */     this.auxiliaryTypes = paramList;
/* 223 */     this.classFileLocator = paramClassFileLocator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> visit(AsmVisitorWrapper paramAsmVisitorWrapper) {
/* 230 */     return (DynamicType.Builder<T>)new DecoratingDynamicTypeBuilder(this.instrumentedType, this.typeAttributeAppender, (AsmVisitorWrapper)new AsmVisitorWrapper.Compound(new AsmVisitorWrapper[] { this.asmVisitorWrapper, paramAsmVisitorWrapper }, ), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes, this.classFileLocator);
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
/*     */   public DynamicType.Builder<T> suffix(String paramString) {
/* 250 */     throw new UnsupportedOperationException("Cannot change name of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> name(String paramString) {
/* 257 */     throw new UnsupportedOperationException("Cannot change name of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> modifiers(int paramInt) {
/* 264 */     throw new UnsupportedOperationException("Cannot change modifiers of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> merge(Collection<? extends ModifierContributor.ForType> paramCollection) {
/* 271 */     throw new UnsupportedOperationException("Cannot change modifiers of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> topLevelType() {
/* 278 */     throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.InnerTypeDefinition.ForType<T> innerTypeOf(TypeDescription paramTypeDescription) {
/* 285 */     throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.InnerTypeDefinition<T> innerTypeOf(MethodDescription.InDefinedShape paramInDefinedShape) {
/* 292 */     throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> declaredTypes(Collection<? extends TypeDescription> paramCollection) {
/* 299 */     throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> nestHost(TypeDescription paramTypeDescription) {
/* 306 */     throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> nestMembers(Collection<? extends TypeDescription> paramCollection) {
/* 313 */     throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> permittedSubclass(Collection<? extends TypeDescription> paramCollection) {
/* 320 */     throw new UnsupportedOperationException("Cannot change permitted subclasses of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> unsealed() {
/* 327 */     throw new UnsupportedOperationException("Cannot unseal decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> attribute(TypeAttributeAppender paramTypeAttributeAppender) {
/* 334 */     return (DynamicType.Builder<T>)new DecoratingDynamicTypeBuilder(this.instrumentedType, (TypeAttributeAppender)new TypeAttributeAppender.Compound(new TypeAttributeAppender[] { this.typeAttributeAppender, paramTypeAttributeAppender }, ), this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes, this.classFileLocator);
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
/*     */   public DynamicType.Builder<T> annotateType(Collection<? extends AnnotationDescription> paramCollection) {
/* 354 */     return attribute((TypeAttributeAppender)new TypeAttributeAppender.Explicit(new ArrayList<AnnotationDescription>(paramCollection)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<T> implement(Collection<? extends TypeDefinition> paramCollection) {
/* 361 */     throw new UnsupportedOperationException("Cannot implement interface for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> initializer(ByteCodeAppender paramByteCodeAppender) {
/* 368 */     throw new UnsupportedOperationException("Cannot add initializer of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> initializer(LoadedTypeInitializer paramLoadedTypeInitializer) {
/* 375 */     throw new UnsupportedOperationException("Cannot add initializer of decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.TypeVariableDefinition<T> typeVariable(String paramString, Collection<? extends TypeDefinition> paramCollection) {
/* 382 */     throw new UnsupportedOperationException("Cannot add type variable to decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> transform(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher, Transformer<TypeVariableToken> paramTransformer) {
/* 389 */     throw new UnsupportedOperationException("Cannot transform decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.FieldDefinition.Optional.Valuable<T> defineField(String paramString, TypeDefinition paramTypeDefinition, int paramInt) {
/* 396 */     throw new UnsupportedOperationException("Cannot define field for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.FieldDefinition.Valuable<T> field(LatentMatcher<? super FieldDescription> paramLatentMatcher) {
/* 403 */     throw new UnsupportedOperationException("Cannot change field for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> ignoreAlso(LatentMatcher<? super MethodDescription> paramLatentMatcher) {
/* 411 */     return (DynamicType.Builder<T>)new DecoratingDynamicTypeBuilder(this.instrumentedType, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, (LatentMatcher<? super MethodDescription>)new LatentMatcher.Disjunction(new LatentMatcher[] { this.ignoredMethods, paramLatentMatcher }, ), this.auxiliaryTypes, this.classFileLocator);
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
/*     */   public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String paramString, TypeDefinition paramTypeDefinition, int paramInt) {
/* 431 */     throw new UnsupportedOperationException("Cannot define method for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(int paramInt) {
/* 438 */     throw new UnsupportedOperationException("Cannot define constructor for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.MethodDefinition.ImplementationDefinition<T> invokable(LatentMatcher<? super MethodDescription> paramLatentMatcher) {
/* 445 */     throw new UnsupportedOperationException("Cannot intercept method for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.RecordComponentDefinition.Optional<T> defineRecordComponent(String paramString, TypeDefinition paramTypeDefinition) {
/* 452 */     throw new UnsupportedOperationException("Cannot define record component for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder.RecordComponentDefinition<T> recordComponent(LatentMatcher<? super RecordComponentDescription> paramLatentMatcher) {
/* 459 */     throw new UnsupportedOperationException("Cannot change record component for decorated type: " + this.instrumentedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType.Builder<T> require(Collection<DynamicType> paramCollection) {
/* 466 */     return (DynamicType.Builder<T>)new DecoratingDynamicTypeBuilder(this.instrumentedType, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 478 */         CompoundList.of(this.auxiliaryTypes, new ArrayList<DynamicType>(paramCollection)), this.classFileLocator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected TypeWriter<T> toTypeWriter() {
/* 486 */     return toTypeWriter((TypePool)TypePool.Empty.INSTANCE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected TypeWriter<T> toTypeWriter(TypePool paramTypePool) {
/* 493 */     return TypeWriter.Default.forDecoration(this.instrumentedType, this.classFileVersion, this.auxiliaryTypes, 
/*     */ 
/*     */         
/* 496 */         CompoundList.of((List)this.methodGraphCompiler.compile((TypeDefinition)this.instrumentedType)
/* 497 */           .listNodes()
/* 498 */           .asMethodList()
/* 499 */           .filter((ElementMatcher)ElementMatchers.not(this.ignoredMethods.resolve(this.instrumentedType))), (List)this.instrumentedType.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isVirtual()))), this.typeAttributeAppender, this.asmVisitorWrapper, this.annotationValueFilterFactory, this.annotationRetention, this.auxiliaryTypeNamingStrategy, this.implementationContextFactory, this.typeValidation, this.classWriterStrategy, paramTypePool, this.classFileLocator);
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
/*     */   public TypeDescription toTypeDescription() {
/* 516 */     return this.instrumentedType;
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.annotationRetention.equals(((DecoratingDynamicTypeBuilder)paramObject).annotationRetention) ? false : (!this.typeValidation.equals(((DecoratingDynamicTypeBuilder)paramObject).typeValidation) ? false : (!this.instrumentedType.equals(((DecoratingDynamicTypeBuilder)paramObject).instrumentedType) ? false : (!this.typeAttributeAppender.equals(((DecoratingDynamicTypeBuilder)paramObject).typeAttributeAppender) ? false : (!this.asmVisitorWrapper.equals(((DecoratingDynamicTypeBuilder)paramObject).asmVisitorWrapper) ? false : (!this.classFileVersion.equals(((DecoratingDynamicTypeBuilder)paramObject).classFileVersion) ? false : (!this.auxiliaryTypeNamingStrategy.equals(((DecoratingDynamicTypeBuilder)paramObject).auxiliaryTypeNamingStrategy) ? false : (!this.annotationValueFilterFactory.equals(((DecoratingDynamicTypeBuilder)paramObject).annotationValueFilterFactory) ? false : (!this.implementationContextFactory.equals(((DecoratingDynamicTypeBuilder)paramObject).implementationContextFactory) ? false : (!this.methodGraphCompiler.equals(((DecoratingDynamicTypeBuilder)paramObject).methodGraphCompiler) ? false : (!this.classWriterStrategy.equals(((DecoratingDynamicTypeBuilder)paramObject).classWriterStrategy) ? false : (!this.ignoredMethods.equals(((DecoratingDynamicTypeBuilder)paramObject).ignoredMethods) ? false : (!this.auxiliaryTypes.equals(((DecoratingDynamicTypeBuilder)paramObject).auxiliaryTypes) ? false : (!!this.classFileLocator.equals(((DecoratingDynamicTypeBuilder)paramObject).classFileLocator)))))))))))))))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return (((((((((((((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.typeAttributeAppender.hashCode()) * 31 + this.asmVisitorWrapper.hashCode()) * 31 + this.classFileVersion.hashCode()) * 31 + this.auxiliaryTypeNamingStrategy.hashCode()) * 31 + this.annotationValueFilterFactory.hashCode()) * 31 + this.annotationRetention.hashCode()) * 31 + this.implementationContextFactory.hashCode()) * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.typeValidation.hashCode()) * 31 + this.classWriterStrategy.hashCode()) * 31 + this.ignoredMethods.hashCode()) * 31 + this.auxiliaryTypes.hashCode()) * 31 + this.classFileLocator.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\DecoratingDynamicTypeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */