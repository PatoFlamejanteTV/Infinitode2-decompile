/*     */ package net.bytebuddy.dynamic.scaffold.subclass;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
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
/*     */ @Enhance
/*     */ public class SubclassDynamicTypeBuilder<T>
/*     */   extends DynamicType.Builder.AbstractBase.Adapter<T>
/*     */ {
/*     */   private final ConstructorStrategy constructorStrategy;
/*     */   
/*     */   public SubclassDynamicTypeBuilder(InstrumentedType.WithFlexibleName paramWithFlexibleName, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, ConstructorStrategy paramConstructorStrategy) {
/*  81 */     this(paramWithFlexibleName, (FieldRegistry)new FieldRegistry.Default(), (MethodRegistry)new MethodRegistry.Default(), (RecordComponentRegistry)new RecordComponentRegistry.Default(), (TypeAttributeAppender)TypeAttributeAppender.ForInstrumentedType.INSTANCE, (AsmVisitorWrapper)AsmVisitorWrapper.NoOp.INSTANCE, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  97 */         Collections.emptyList(), paramConstructorStrategy);
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
/*     */   protected SubclassDynamicTypeBuilder(InstrumentedType.WithFlexibleName paramWithFlexibleName, FieldRegistry paramFieldRegistry, MethodRegistry paramMethodRegistry, RecordComponentRegistry paramRecordComponentRegistry, TypeAttributeAppender paramTypeAttributeAppender, AsmVisitorWrapper paramAsmVisitorWrapper, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, List<? extends DynamicType> paramList, ConstructorStrategy paramConstructorStrategy) {
/* 141 */     super(paramWithFlexibleName, paramFieldRegistry, paramMethodRegistry, paramRecordComponentRegistry, paramTypeAttributeAppender, paramAsmVisitorWrapper, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, paramList);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     this.constructorStrategy = paramConstructorStrategy;
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
/* 179 */     return (DynamicType.Builder<T>)new SubclassDynamicTypeBuilder(paramWithFlexibleName, paramFieldRegistry, paramMethodRegistry, paramRecordComponentRegistry, paramTypeAttributeAppender, paramAsmVisitorWrapper, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, paramList, this.constructorStrategy);
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
/*     */   protected TypeWriter<T> toTypeWriter() {
/* 203 */     return toTypeWriter(TypePool.ClassLoading.ofSystemLoader());
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
/*     */   protected TypeWriter<T> toTypeWriter(TypePool paramTypePool) {
/*     */     MethodRegistry.Compiled compiled;
/* 218 */     return TypeWriter.Default.forCreation(compiled = this.constructorStrategy.inject((TypeDescription)this.instrumentedType, this.methodRegistry).prepare(applyConstructorStrategy((InstrumentedType)this.instrumentedType), this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, new InstrumentableMatcher(this.ignoredMethods)).compile(SubclassImplementationTarget.Factory.SUPER_CLASS, this.classFileVersion), this.auxiliaryTypes, (TypeWriter.FieldPool)this.fieldRegistry
/*     */         
/* 220 */         .compile(compiled.getInstrumentedType()), (TypeWriter.RecordComponentPool)this.recordComponentRegistry
/* 221 */         .compile(compiled.getInstrumentedType()), this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.annotationValueFilterFactory, this.annotationRetention, this.auxiliaryTypeNamingStrategy, this.implementationContextFactory, this.typeValidation, this.classWriterStrategy, paramTypePool);
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
/*     */   private InstrumentedType applyConstructorStrategy(InstrumentedType paramInstrumentedType) {
/* 241 */     if (!paramInstrumentedType.isInterface()) {
/* 242 */       for (MethodDescription.Token token : this.constructorStrategy.extractConstructors((TypeDescription)paramInstrumentedType)) {
/* 243 */         paramInstrumentedType = paramInstrumentedType.withMethod(token);
/*     */       }
/*     */     }
/* 246 */     return paramInstrumentedType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.constructorStrategy.equals(((SubclassDynamicTypeBuilder)paramObject).constructorStrategy)))));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode() * 31 + this.constructorStrategy.hashCode();
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   protected static class InstrumentableMatcher
/*     */     implements LatentMatcher<MethodDescription>
/*     */   {
/*     */     private final LatentMatcher<? super MethodDescription> ignoredMethods;
/*     */     
/*     */     protected InstrumentableMatcher(LatentMatcher<? super MethodDescription> param1LatentMatcher) {
/* 266 */       this.ignoredMethods = param1LatentMatcher;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementMatcher<? super MethodDescription> resolve(TypeDescription param1TypeDescription) {
/* 274 */       return (ElementMatcher<? super MethodDescription>)ElementMatchers.isVirtual().and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isFinal()))
/* 275 */         .and((ElementMatcher)ElementMatchers.isVisibleTo(param1TypeDescription))
/* 276 */         .and((ElementMatcher)ElementMatchers.not(this.ignoredMethods.resolve(param1TypeDescription)))
/* 277 */         .or((ElementMatcher)ElementMatchers.isDeclaredBy(param1TypeDescription));
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.ignoredMethods.equals(((InstrumentableMatcher)param1Object).ignoredMethods))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.ignoredMethods.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\subclass\SubclassDynamicTypeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */