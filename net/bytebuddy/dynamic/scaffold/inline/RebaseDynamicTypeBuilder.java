/*     */ package net.bytebuddy.dynamic.scaffold.inline;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
/*     */ import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
/*     */ import net.bytebuddy.dynamic.scaffold.FieldRegistry;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodRegistry;
/*     */ import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeWriter;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationRetention;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*     */ import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
/*     */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.matcher.LatentMatcher;
/*     */ import net.bytebuddy.pool.TypePool;
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
/*     */ @Enhance
/*     */ public class RebaseDynamicTypeBuilder<T>
/*     */   extends AbstractInliningDynamicTypeBuilder<T>
/*     */ {
/*     */   private final MethodNameTransformer methodNameTransformer;
/*     */   
/*     */   public RebaseDynamicTypeBuilder(InstrumentedType.WithFlexibleName paramWithFlexibleName, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator, MethodNameTransformer paramMethodNameTransformer) {
/*  86 */     this(paramWithFlexibleName, (FieldRegistry)new FieldRegistry.Default(), (MethodRegistry)new MethodRegistry.Default(), (RecordComponentRegistry)new RecordComponentRegistry.Default(), 
/*     */ 
/*     */ 
/*     */         
/*  90 */         paramAnnotationRetention.isEnabled() ? (TypeAttributeAppender)new TypeAttributeAppender.ForInstrumentedType.Differentiating(paramTypeDescription) : (TypeAttributeAppender)TypeAttributeAppender.ForInstrumentedType.INSTANCE, (AsmVisitorWrapper)AsmVisitorWrapper.NoOp.INSTANCE, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 104 */         Collections.emptyList(), paramTypeDescription, paramClassFileLocator, paramMethodNameTransformer);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected RebaseDynamicTypeBuilder(InstrumentedType.WithFlexibleName paramWithFlexibleName, FieldRegistry paramFieldRegistry, MethodRegistry paramMethodRegistry, RecordComponentRegistry paramRecordComponentRegistry, TypeAttributeAppender paramTypeAttributeAppender, AsmVisitorWrapper paramAsmVisitorWrapper, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, List<? extends DynamicType> paramList, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator, MethodNameTransformer paramMethodNameTransformer) {
/* 154 */     super(paramWithFlexibleName, paramFieldRegistry, paramMethodRegistry, paramRecordComponentRegistry, paramTypeAttributeAppender, paramAsmVisitorWrapper, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, paramList, paramTypeDescription, paramClassFileLocator);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.methodNameTransformer = paramMethodNameTransformer;
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
/*     */   protected DynamicType.Builder<T> materialize(InstrumentedType.WithFlexibleName paramWithFlexibleName, FieldRegistry paramFieldRegistry, MethodRegistry paramMethodRegistry, RecordComponentRegistry paramRecordComponentRegistry, TypeAttributeAppender paramTypeAttributeAppender, AsmVisitorWrapper paramAsmVisitorWrapper, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, List<? extends DynamicType> paramList) {
/* 194 */     return (DynamicType.Builder<T>)new RebaseDynamicTypeBuilder(paramWithFlexibleName, paramFieldRegistry, paramMethodRegistry, paramRecordComponentRegistry, paramTypeAttributeAppender, paramAsmVisitorWrapper, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, paramList, this.originalType, this.classFileLocator, this.methodNameTransformer);
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
/*     */   protected TypeWriter<T> toTypeWriter(TypePool paramTypePool) {
/* 220 */     MethodRegistry.Prepared prepared = this.methodRegistry.prepare((InstrumentedType)this.instrumentedType, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, 
/*     */ 
/*     */ 
/*     */         
/* 224 */         InliningImplementationMatcher.of(this.ignoredMethods, this.originalType));
/*     */     
/*     */     HashSet<?> hashSet;
/* 227 */     (hashSet = new HashSet(this.originalType.getDeclaredMethods().asSignatureTokenList((ElementMatcher)ElementMatchers.is(this.originalType), (TypeDescription)this.instrumentedType))).retainAll(prepared.getInstrumentedMethods().asSignatureTokenList());
/* 228 */     MethodRebaseResolver methodRebaseResolver = MethodRebaseResolver.Default.make(prepared.getInstrumentedType(), (Set)hashSet, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.methodNameTransformer);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     return TypeWriter.Default.forRebasing(prepared, this.auxiliaryTypes, (TypeWriter.FieldPool)this.fieldRegistry
/*     */         
/* 235 */         .compile(prepared.getInstrumentedType()), (TypeWriter.RecordComponentPool)this.recordComponentRegistry
/* 236 */         .compile(prepared.getInstrumentedType()), this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.annotationValueFilterFactory, this.annotationRetention, this.auxiliaryTypeNamingStrategy, this.implementationContextFactory, this.typeValidation, this.classWriterStrategy, paramTypePool, this.originalType, this.classFileLocator, methodRebaseResolver);
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.methodNameTransformer.equals(((RebaseDynamicTypeBuilder)paramObject).methodNameTransformer)))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode() * 31 + this.methodNameTransformer.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\RebaseDynamicTypeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */