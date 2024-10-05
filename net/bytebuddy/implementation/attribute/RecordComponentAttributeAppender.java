/*     */ package net.bytebuddy.implementation.attribute;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.type.RecordComponentDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
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
/*     */ public interface RecordComponentAttributeAppender
/*     */ {
/*     */   void apply(RecordComponentVisitor paramRecordComponentVisitor, RecordComponentDescription paramRecordComponentDescription, AnnotationValueFilter paramAnnotationValueFilter);
/*     */   
/*     */   public enum NoOp
/*     */     implements RecordComponentAttributeAppender, Factory
/*     */   {
/*  50 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final RecordComponentAttributeAppender make(TypeDescription param1TypeDescription) {
/*  56 */       return this;
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
/*     */     public final void apply(RecordComponentVisitor param1RecordComponentVisitor, RecordComponentDescription param1RecordComponentDescription, AnnotationValueFilter param1AnnotationValueFilter) {}
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
/*     */   public static interface Factory
/*     */   {
/*     */     RecordComponentAttributeAppender make(TypeDescription param1TypeDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Compound
/*     */       implements Factory
/*     */     {
/*     */       public Compound(RecordComponentAttributeAppender.Factory... param2VarArgs) {
/*  98 */         this(Arrays.asList(param2VarArgs));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 107 */       private final List<RecordComponentAttributeAppender.Factory> factories = new ArrayList<RecordComponentAttributeAppender.Factory>(); public Compound(List<? extends RecordComponentAttributeAppender.Factory> param2List) {
/* 108 */         for (Iterator<? extends RecordComponentAttributeAppender.Factory> iterator = param2List.iterator(); iterator.hasNext(); ) {
/* 109 */           RecordComponentAttributeAppender.Factory factory; if (factory = iterator.next() instanceof Compound) {
/* 110 */             this.factories.addAll(((Compound)factory).factories); continue;
/* 111 */           }  if (!(factory instanceof RecordComponentAttributeAppender.NoOp)) {
/* 112 */             this.factories.add(factory);
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public RecordComponentAttributeAppender make(TypeDescription param2TypeDescription) {
/* 121 */         ArrayList<RecordComponentAttributeAppender> arrayList = new ArrayList(this.factories.size());
/* 122 */         for (RecordComponentAttributeAppender.Factory factory : this.factories) {
/* 123 */           arrayList.add(factory.make(param2TypeDescription));
/*     */         }
/* 125 */         return new RecordComponentAttributeAppender.Compound(arrayList);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.factories.equals(((Compound)param2Object).factories))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.factories.hashCode();
/*     */       } }
/*     */   }
/*     */   
/*     */   public enum ForInstrumentedRecordComponent implements RecordComponentAttributeAppender, Factory {
/* 138 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void apply(RecordComponentVisitor param1RecordComponentVisitor, RecordComponentDescription param1RecordComponentDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 144 */       AnnotationAppender.Default default_ = new AnnotationAppender.Default(new AnnotationAppender.Target.OnRecordComponent(param1RecordComponentVisitor));
/* 145 */       AnnotationAppender annotationAppender = (AnnotationAppender)param1RecordComponentDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofFieldType(default_, param1AnnotationValueFilter));
/* 146 */       for (AnnotationDescription annotationDescription : param1RecordComponentDescription.getDeclaredAnnotations()) {
/* 147 */         annotationAppender = annotationAppender.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final RecordComponentAttributeAppender make(TypeDescription param1TypeDescription) {
/* 155 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Explicit
/*     */     implements RecordComponentAttributeAppender, Factory
/*     */   {
/*     */     private final List<? extends AnnotationDescription> annotations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(List<? extends AnnotationDescription> param1List) {
/* 177 */       this.annotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(RecordComponentVisitor param1RecordComponentVisitor, RecordComponentDescription param1RecordComponentDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 184 */       AnnotationAppender.Default default_ = new AnnotationAppender.Default(new AnnotationAppender.Target.OnRecordComponent(param1RecordComponentVisitor));
/* 185 */       for (AnnotationDescription annotationDescription : this.annotations) {
/* 186 */         AnnotationAppender annotationAppender = default_.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RecordComponentAttributeAppender make(TypeDescription param1TypeDescription) {
/* 194 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.annotations.equals(((Explicit)param1Object).annotations))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.annotations.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Compound
/*     */     implements RecordComponentAttributeAppender
/*     */   {
/*     */     public Compound(RecordComponentAttributeAppender... param1VarArgs) {
/* 217 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     private final List<RecordComponentAttributeAppender> recordComponentAttributeAppenders = new ArrayList<RecordComponentAttributeAppender>(); public Compound(List<? extends RecordComponentAttributeAppender> param1List) {
/* 228 */       for (Iterator<? extends RecordComponentAttributeAppender> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 229 */         RecordComponentAttributeAppender recordComponentAttributeAppender; if (recordComponentAttributeAppender = iterator.next() instanceof Compound) {
/* 230 */           this.recordComponentAttributeAppenders.addAll(((Compound)recordComponentAttributeAppender).recordComponentAttributeAppenders); continue;
/* 231 */         }  if (!(recordComponentAttributeAppender instanceof RecordComponentAttributeAppender.NoOp)) {
/* 232 */           this.recordComponentAttributeAppenders.add(recordComponentAttributeAppender);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(RecordComponentVisitor param1RecordComponentVisitor, RecordComponentDescription param1RecordComponentDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 241 */       for (Iterator<RecordComponentAttributeAppender> iterator = this.recordComponentAttributeAppenders.iterator(); iterator.hasNext();)
/* 242 */         (recordComponentAttributeAppender = iterator.next()).apply(param1RecordComponentVisitor, param1RecordComponentDescription, param1AnnotationValueFilter); 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.recordComponentAttributeAppenders.equals(((Compound)param1Object).recordComponentAttributeAppenders))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.recordComponentAttributeAppenders.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\attribute\RecordComponentAttributeAppender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */