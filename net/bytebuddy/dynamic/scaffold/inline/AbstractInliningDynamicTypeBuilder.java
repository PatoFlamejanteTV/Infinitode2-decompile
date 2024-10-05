/*     */ package net.bytebuddy.dynamic.scaffold.inline;
/*     */ 
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class AbstractInliningDynamicTypeBuilder<T>
/*     */   extends DynamicType.Builder.AbstractBase.Adapter<T>
/*     */ {
/*     */   protected final TypeDescription originalType;
/*     */   protected final ClassFileLocator classFileLocator;
/*     */   
/*     */   protected AbstractInliningDynamicTypeBuilder(InstrumentedType.WithFlexibleName paramWithFlexibleName, FieldRegistry paramFieldRegistry, MethodRegistry paramMethodRegistry, RecordComponentRegistry paramRecordComponentRegistry, TypeAttributeAppender paramTypeAttributeAppender, AsmVisitorWrapper paramAsmVisitorWrapper, ClassFileVersion paramClassFileVersion, AuxiliaryType.NamingStrategy paramNamingStrategy, AnnotationValueFilter.Factory paramFactory, AnnotationRetention paramAnnotationRetention, Implementation.Context.Factory paramFactory1, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, ClassWriterStrategy paramClassWriterStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher, List<? extends DynamicType> paramList, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*  97 */     super(paramWithFlexibleName, paramFieldRegistry, paramMethodRegistry, paramRecordComponentRegistry, paramTypeAttributeAppender, paramAsmVisitorWrapper, paramClassFileVersion, paramNamingStrategy, paramFactory, paramAnnotationRetention, paramFactory1, paramCompiler, paramTypeValidation, paramVisibilityBridgeStrategy, paramClassWriterStrategy, paramLatentMatcher, paramList);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     this.originalType = paramTypeDescription;
/* 115 */     this.classFileLocator = paramClassFileLocator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected TypeWriter<T> toTypeWriter() {
/* 122 */     return toTypeWriter(TypePool.Default.of(this.classFileLocator));
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.originalType.equals(((AbstractInliningDynamicTypeBuilder)paramObject).originalType) ? false : (!!this.classFileLocator.equals(((AbstractInliningDynamicTypeBuilder)paramObject).classFileLocator))))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return (super.hashCode() * 31 + this.originalType.hashCode()) * 31 + this.classFileLocator.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\AbstractInliningDynamicTypeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */