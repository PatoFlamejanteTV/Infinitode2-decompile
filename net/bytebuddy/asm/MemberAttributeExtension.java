/*     */ package net.bytebuddy.asm;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*     */ import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
/*     */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.OpenedClassReader;
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
/*     */ @Enhance
/*     */ public abstract class MemberAttributeExtension<T>
/*     */ {
/*     */   protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
/*     */   protected final T attributeAppenderFactory;
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.annotationValueFilterFactory.equals(((MemberAttributeExtension)paramObject).annotationValueFilterFactory) ? false : (!!this.attributeAppenderFactory.equals(((MemberAttributeExtension)paramObject).attributeAppenderFactory)))));
/*     */   }
/*     */   
/*     */   protected MemberAttributeExtension(AnnotationValueFilter.Factory paramFactory, T paramT) {
/*  65 */     this.annotationValueFilterFactory = paramFactory;
/*  66 */     this.attributeAppenderFactory = paramT;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return (getClass().hashCode() * 31 + this.annotationValueFilterFactory.hashCode()) * 31 + this.attributeAppenderFactory.hashCode();
/*     */   }
/*     */   
/*     */   public static class ForField
/*     */     extends MemberAttributeExtension<FieldAttributeAppender.Factory>
/*     */     implements AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper
/*     */   {
/*     */     public ForField() {
/*  78 */       this((AnnotationValueFilter.Factory)AnnotationValueFilter.Default.APPEND_DEFAULTS);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForField(AnnotationValueFilter.Factory param1Factory) {
/*  87 */       this(param1Factory, (FieldAttributeAppender.Factory)FieldAttributeAppender.NoOp.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForField(AnnotationValueFilter.Factory param1Factory, FieldAttributeAppender.Factory param1Factory1) {
/*  97 */       super(param1Factory, param1Factory1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForField annotate(Annotation... param1VarArgs) {
/* 107 */       return annotate(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForField annotate(List<? extends Annotation> param1List) {
/* 117 */       return annotate((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param1List));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForField annotate(AnnotationDescription... param1VarArgs) {
/* 127 */       return annotate(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForField annotate(Collection<? extends AnnotationDescription> param1Collection) {
/* 137 */       return attribute((FieldAttributeAppender.Factory)new FieldAttributeAppender.Explicit(new ArrayList<AnnotationDescription>(param1Collection)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForField attribute(FieldAttributeAppender.Factory param1Factory) {
/* 147 */       return new ForField(this.annotationValueFilterFactory, (FieldAttributeAppender.Factory)new FieldAttributeAppender.Factory.Compound(new FieldAttributeAppender.Factory[] { this.attributeAppenderFactory, param1Factory }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldVisitor wrap(TypeDescription param1TypeDescription, FieldDescription.InDefinedShape param1InDefinedShape, FieldVisitor param1FieldVisitor) {
/* 154 */       return new FieldAttributeVisitor(param1FieldVisitor, (FieldDescription)param1InDefinedShape, this.attributeAppenderFactory
/*     */           
/* 156 */           .make(param1TypeDescription), this.annotationValueFilterFactory
/* 157 */           .on((FieldDescription)param1InDefinedShape), (byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AsmVisitorWrapper on(ElementMatcher<? super FieldDescription.InDefinedShape> param1ElementMatcher) {
/* 167 */       return (new AsmVisitorWrapper.ForDeclaredFields()).field(param1ElementMatcher, new AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper[] { this });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static class FieldAttributeVisitor
/*     */       extends FieldVisitor
/*     */     {
/*     */       private final FieldDescription fieldDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final FieldAttributeAppender fieldAttributeAppender;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final AnnotationValueFilter annotationValueFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private FieldAttributeVisitor(FieldVisitor param2FieldVisitor, FieldDescription param2FieldDescription, FieldAttributeAppender param2FieldAttributeAppender, AnnotationValueFilter param2AnnotationValueFilter) {
/* 202 */         super(OpenedClassReader.ASM_API, param2FieldVisitor);
/* 203 */         this.fieldDescription = param2FieldDescription;
/* 204 */         this.fieldAttributeAppender = param2FieldAttributeAppender;
/* 205 */         this.annotationValueFilter = param2AnnotationValueFilter;
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitEnd() {
/* 210 */         this.fieldAttributeAppender.apply(this.fv, this.fieldDescription, this.annotationValueFilter);
/* 211 */         super.visitEnd();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForMethod
/*     */     extends MemberAttributeExtension<MethodAttributeAppender.Factory>
/*     */     implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
/*     */   {
/*     */     public ForMethod() {
/* 225 */       this((AnnotationValueFilter.Factory)AnnotationValueFilter.Default.APPEND_DEFAULTS);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod(AnnotationValueFilter.Factory param1Factory) {
/* 234 */       this(param1Factory, (MethodAttributeAppender.Factory)MethodAttributeAppender.NoOp.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForMethod(AnnotationValueFilter.Factory param1Factory, MethodAttributeAppender.Factory param1Factory1) {
/* 244 */       super(param1Factory, param1Factory1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateMethod(Annotation... param1VarArgs) {
/* 254 */       return annotateMethod(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateMethod(List<? extends Annotation> param1List) {
/* 264 */       return annotateMethod((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param1List));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateMethod(AnnotationDescription... param1VarArgs) {
/* 274 */       return annotateMethod(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateMethod(Collection<? extends AnnotationDescription> param1Collection) {
/* 284 */       return attribute((MethodAttributeAppender.Factory)new MethodAttributeAppender.Explicit(new ArrayList<AnnotationDescription>(param1Collection)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateParameter(int param1Int, Annotation... param1VarArgs) {
/* 295 */       return annotateParameter(param1Int, Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateParameter(int param1Int, List<? extends Annotation> param1List) {
/* 306 */       return annotateParameter(param1Int, (Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param1List));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateParameter(int param1Int, AnnotationDescription... param1VarArgs) {
/* 317 */       return annotateParameter(param1Int, Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod annotateParameter(int param1Int, Collection<? extends AnnotationDescription> param1Collection) {
/* 328 */       if (param1Int < 0) {
/* 329 */         throw new IllegalArgumentException("Parameter index cannot be negative: " + param1Int);
/*     */       }
/* 331 */       return attribute((MethodAttributeAppender.Factory)new MethodAttributeAppender.Explicit(param1Int, new ArrayList<AnnotationDescription>(param1Collection)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod attribute(MethodAttributeAppender.Factory param1Factory) {
/* 342 */       return new ForMethod(this.annotationValueFilterFactory, (MethodAttributeAppender.Factory)new MethodAttributeAppender.Factory.Compound(new MethodAttributeAppender.Factory[] { this.attributeAppenderFactory, param1Factory }));
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
/*     */     public MethodVisitor wrap(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, MethodVisitor param1MethodVisitor, Implementation.Context param1Context, TypePool param1TypePool, int param1Int1, int param1Int2) {
/* 355 */       return new AttributeAppendingMethodVisitor(param1MethodVisitor, param1MethodDescription, this.attributeAppenderFactory
/*     */           
/* 357 */           .make(param1TypeDescription), this.annotationValueFilterFactory
/* 358 */           .on(param1MethodDescription), (byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AsmVisitorWrapper on(ElementMatcher<? super MethodDescription> param1ElementMatcher) {
/* 368 */       return (new AsmVisitorWrapper.ForDeclaredMethods()).invokable(param1ElementMatcher, new AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper[] { this });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static class AttributeAppendingMethodVisitor
/*     */       extends MethodVisitor
/*     */     {
/*     */       private final MethodDescription methodDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final MethodAttributeAppender methodAttributeAppender;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final AnnotationValueFilter annotationValueFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private boolean applicable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private AttributeAppendingMethodVisitor(MethodVisitor param2MethodVisitor, MethodDescription param2MethodDescription, MethodAttributeAppender param2MethodAttributeAppender, AnnotationValueFilter param2AnnotationValueFilter) {
/* 406 */         super(OpenedClassReader.ASM_API, param2MethodVisitor);
/* 407 */         this.methodDescription = param2MethodDescription;
/* 408 */         this.methodAttributeAppender = param2MethodAttributeAppender;
/* 409 */         this.annotationValueFilter = param2AnnotationValueFilter;
/* 410 */         this.applicable = true;
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitCode() {
/* 415 */         if (this.applicable) {
/* 416 */           this.methodAttributeAppender.apply(this.mv, this.methodDescription, this.annotationValueFilter);
/* 417 */           this.applicable = false;
/*     */         } 
/* 419 */         super.visitCode();
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitEnd() {
/* 424 */         if (this.applicable) {
/* 425 */           this.methodAttributeAppender.apply(this.mv, this.methodDescription, this.annotationValueFilter);
/* 426 */           this.applicable = false;
/*     */         } 
/* 428 */         super.visitEnd();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\MemberAttributeExtension.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */