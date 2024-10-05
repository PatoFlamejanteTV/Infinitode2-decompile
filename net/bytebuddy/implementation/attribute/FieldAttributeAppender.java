/*     */ package net.bytebuddy.implementation.attribute;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
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
/*     */ public interface FieldAttributeAppender
/*     */ {
/*     */   void apply(FieldVisitor paramFieldVisitor, FieldDescription paramFieldDescription, AnnotationValueFilter paramAnnotationValueFilter);
/*     */   
/*     */   public enum NoOp
/*     */     implements FieldAttributeAppender, Factory
/*     */   {
/*  50 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final FieldAttributeAppender make(TypeDescription param1TypeDescription) {
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
/*     */     public final void apply(FieldVisitor param1FieldVisitor, FieldDescription param1FieldDescription, AnnotationValueFilter param1AnnotationValueFilter) {}
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
/*     */     FieldAttributeAppender make(TypeDescription param1TypeDescription);
/*     */ 
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
/*     */       public Compound(FieldAttributeAppender.Factory... param2VarArgs) {
/*  98 */         this(Arrays.asList(param2VarArgs));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 107 */       private final List<FieldAttributeAppender.Factory> factories = new ArrayList<FieldAttributeAppender.Factory>(); public Compound(List<? extends FieldAttributeAppender.Factory> param2List) {
/* 108 */         for (Iterator<? extends FieldAttributeAppender.Factory> iterator = param2List.iterator(); iterator.hasNext(); ) {
/* 109 */           FieldAttributeAppender.Factory factory; if (factory = iterator.next() instanceof Compound) {
/* 110 */             this.factories.addAll(((Compound)factory).factories); continue;
/* 111 */           }  if (!(factory instanceof FieldAttributeAppender.NoOp)) {
/* 112 */             this.factories.add(factory);
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public FieldAttributeAppender make(TypeDescription param2TypeDescription) {
/* 121 */         ArrayList<FieldAttributeAppender> arrayList = new ArrayList(this.factories.size());
/* 122 */         for (FieldAttributeAppender.Factory factory : this.factories) {
/* 123 */           arrayList.add(factory.make(param2TypeDescription));
/*     */         }
/* 125 */         return new FieldAttributeAppender.Compound(arrayList);
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
/*     */   public enum ForInstrumentedField implements FieldAttributeAppender, Factory {
/* 138 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void apply(FieldVisitor param1FieldVisitor, FieldDescription param1FieldDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 144 */       AnnotationAppender.Default default_ = new AnnotationAppender.Default(new AnnotationAppender.Target.OnField(param1FieldVisitor));
/* 145 */       AnnotationAppender annotationAppender = (AnnotationAppender)param1FieldDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofFieldType(default_, param1AnnotationValueFilter));
/* 146 */       for (AnnotationDescription annotationDescription : param1FieldDescription.getDeclaredAnnotations()) {
/* 147 */         annotationAppender = annotationAppender.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final FieldAttributeAppender make(TypeDescription param1TypeDescription) {
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
/*     */     implements FieldAttributeAppender, Factory
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
/*     */     public void apply(FieldVisitor param1FieldVisitor, FieldDescription param1FieldDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 184 */       AnnotationAppender.Default default_ = new AnnotationAppender.Default(new AnnotationAppender.Target.OnField(param1FieldVisitor));
/* 185 */       for (AnnotationDescription annotationDescription : this.annotations) {
/* 186 */         AnnotationAppender annotationAppender = default_.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldAttributeAppender make(TypeDescription param1TypeDescription) {
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
/*     */     implements FieldAttributeAppender
/*     */   {
/*     */     public Compound(FieldAttributeAppender... param1VarArgs) {
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
/* 227 */     private final List<FieldAttributeAppender> fieldAttributeAppenders = new ArrayList<FieldAttributeAppender>(); public Compound(List<? extends FieldAttributeAppender> param1List) {
/* 228 */       for (Iterator<? extends FieldAttributeAppender> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 229 */         FieldAttributeAppender fieldAttributeAppender; if (fieldAttributeAppender = iterator.next() instanceof Compound) {
/* 230 */           this.fieldAttributeAppenders.addAll(((Compound)fieldAttributeAppender).fieldAttributeAppenders); continue;
/* 231 */         }  if (!(fieldAttributeAppender instanceof FieldAttributeAppender.NoOp)) {
/* 232 */           this.fieldAttributeAppenders.add(fieldAttributeAppender);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(FieldVisitor param1FieldVisitor, FieldDescription param1FieldDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 241 */       for (Iterator<FieldAttributeAppender> iterator = this.fieldAttributeAppenders.iterator(); iterator.hasNext();)
/* 242 */         (fieldAttributeAppender = iterator.next()).apply(param1FieldVisitor, param1FieldDescription, param1AnnotationValueFilter); 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.fieldAttributeAppenders.equals(((Compound)param1Object).fieldAttributeAppenders))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.fieldAttributeAppenders.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\attribute\FieldAttributeAppender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */