/*     */ package net.bytebuddy.dynamic.scaffold.inline;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.asm.AsmVisitorWrapper;
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
/*     */ import net.bytebuddy.matcher.LatentMatcher;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RedefinitionDynamicTypeBuilder<T>
/*     */   extends AbstractInliningDynamicTypeBuilder<T>
/*     */ {
/*     */   public RedefinitionDynamicTypeBuilder(InstrumentedType.WithFlexibleName paramWithFlexibleName, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*  74 */     this(paramWithFlexibleName, (FieldRegistry)new FieldRegistry.Default(), (MethodRegistry)new MethodRegistry.Default(), (RecordComponentRegistry)new RecordComponentRegistry.Default(), 
/*     */ 
/*     */ 
/*     */         
/*  78 */         paramAnnotationRetention.isEnabled() ? (TypeAttributeAppender)new TypeAttributeAppender.ForInstrumentedType.Differentiating(paramTypeDescription) : (TypeAttributeAppender)TypeAttributeAppender.ForInstrumentedType.INSTANCE, (AsmVisitorWrapper)AsmVisitorWrapper.NoOp.INSTANCE, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  92 */         Collections.emptyList(), paramTypeDescription, paramClassFileLocator);
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
/*     */   protected RedefinitionDynamicTypeBuilder(InstrumentedType.WithFlexibleName paramWithFlexibleName, FieldRegistry paramFieldRegistry, MethodRegistry paramMethodRegistry, RecordComponentRegistry paramRecordComponentRegistry, TypeAttributeAppender paramTypeAttributeAppender, AsmVisitorWrapper paramAsmVisitorWrapper, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, List<? extends DynamicType> paramList, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/* 139 */     super(paramWithFlexibleName, paramFieldRegistry, paramMethodRegistry, paramRecordComponentRegistry, paramTypeAttributeAppender, paramAsmVisitorWrapper, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, paramList, paramTypeDescription, paramClassFileLocator);
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
/*     */   protected DynamicType.Builder<T> materialize(InstrumentedType.WithFlexibleName paramWithFlexibleName, FieldRegistry paramFieldRegistry, MethodRegistry paramMethodRegistry, RecordComponentRegistry paramRecordComponentRegistry, TypeAttributeAppender paramTypeAttributeAppender, AsmVisitorWrapper paramAsmVisitorWrapper, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, List<? extends DynamicType> paramList) {
/* 178 */     return (DynamicType.Builder<T>)new RedefinitionDynamicTypeBuilder(paramWithFlexibleName, paramFieldRegistry, paramMethodRegistry, paramRecordComponentRegistry, paramTypeAttributeAppender, paramAsmVisitorWrapper, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, paramList, this.originalType, this.classFileLocator);
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
/*     */   protected TypeWriter<T> toTypeWriter(TypePool paramTypePool) {
/*     */     MethodRegistry.Prepared prepared;
/* 208 */     return TypeWriter.Default.forRedefinition(prepared = this.methodRegistry.prepare((InstrumentedType)this.instrumentedType, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, InliningImplementationMatcher.of(this.ignoredMethods, this.originalType)), this.auxiliaryTypes, (TypeWriter.FieldPool)this.fieldRegistry
/*     */         
/* 210 */         .compile(prepared.getInstrumentedType()), (TypeWriter.RecordComponentPool)this.recordComponentRegistry
/* 211 */         .compile(prepared.getInstrumentedType()), this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.annotationValueFilterFactory, this.annotationRetention, this.auxiliaryTypeNamingStrategy, this.implementationContextFactory, this.typeValidation, this.classWriterStrategy, paramTypePool, this.originalType, this.classFileLocator);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\RedefinitionDynamicTypeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */