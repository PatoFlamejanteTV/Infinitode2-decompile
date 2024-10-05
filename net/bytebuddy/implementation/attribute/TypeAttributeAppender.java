/*     */ package net.bytebuddy.implementation.attribute;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
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
/*     */ public interface TypeAttributeAppender
/*     */ {
/*     */   void apply(ClassVisitor paramClassVisitor, TypeDescription paramTypeDescription, AnnotationValueFilter paramAnnotationValueFilter);
/*     */   
/*     */   public enum NoOp
/*     */     implements TypeAttributeAppender
/*     */   {
/*  51 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void apply(ClassVisitor param1ClassVisitor, TypeDescription param1TypeDescription, AnnotationValueFilter param1AnnotationValueFilter) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ForInstrumentedType
/*     */     implements TypeAttributeAppender
/*     */   {
/*  71 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void apply(ClassVisitor param1ClassVisitor, TypeDescription param1TypeDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/*     */       AnnotationAppender.Default default_;
/*  78 */       AnnotationAppender annotationAppender = AnnotationAppender.ForTypeAnnotations.ofTypeVariable(default_ = new AnnotationAppender.Default(new AnnotationAppender.Target.OnType(param1ClassVisitor)), param1AnnotationValueFilter, true, (List<? extends TypeDescription.Generic>)param1TypeDescription
/*     */ 
/*     */           
/*  81 */           .getTypeVariables());
/*     */       TypeDescription.Generic generic;
/*  83 */       if ((generic = param1TypeDescription.getSuperClass()) != null) {
/*  84 */         annotationAppender = (AnnotationAppender)generic.accept(AnnotationAppender.ForTypeAnnotations.ofSuperClass(annotationAppender, param1AnnotationValueFilter));
/*     */       }
/*  86 */       byte b = 0;
/*  87 */       for (null = param1TypeDescription.getInterfaces().iterator(); null.hasNext();) {
/*  88 */         annotationAppender = (AnnotationAppender)(generic1 = null.next()).accept(AnnotationAppender.ForTypeAnnotations.ofInterfaceType(annotationAppender, param1AnnotationValueFilter, b++));
/*     */       }
/*     */ 
/*     */       
/*  92 */       for (AnnotationDescription annotationDescription : param1TypeDescription.getDeclaredAnnotations()) {
/*  93 */         annotationAppender = annotationAppender.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Differentiating
/*     */       implements TypeAttributeAppender
/*     */     {
/*     */       private final int annotationIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final int typeVariableIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final int interfaceTypeIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Differentiating(TypeDescription param2TypeDescription) {
/* 125 */         this(param2TypeDescription.getDeclaredAnnotations().size(), param2TypeDescription.getTypeVariables().size(), param2TypeDescription.getInterfaces().size());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Differentiating(int param2Int1, int param2Int2, int param2Int3) {
/* 136 */         this.annotationIndex = param2Int1;
/* 137 */         this.typeVariableIndex = param2Int2;
/* 138 */         this.interfaceTypeIndex = param2Int3;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void apply(ClassVisitor param2ClassVisitor, TypeDescription param2TypeDescription, AnnotationValueFilter param2AnnotationValueFilter) {
/*     */         AnnotationAppender annotationAppender;
/* 146 */         AnnotationAppender.ForTypeAnnotations.ofTypeVariable(annotationAppender = new AnnotationAppender.Default(new AnnotationAppender.Target.OnType(param2ClassVisitor)), param2AnnotationValueFilter, true, this.typeVariableIndex, (List<? extends TypeDescription.Generic>)param2TypeDescription
/*     */ 
/*     */ 
/*     */             
/* 150 */             .getTypeVariables());
/* 151 */         TypeList.Generic generic = param2TypeDescription.getInterfaces();
/* 152 */         int i = this.interfaceTypeIndex;
/* 153 */         for (Iterator<TypeDescription.Generic> iterator = ((TypeList.Generic)generic.subList(this.interfaceTypeIndex, generic.size())).iterator(); iterator.hasNext();) {
/* 154 */           annotationAppender = (AnnotationAppender)(generic1 = iterator.next()).accept(AnnotationAppender.ForTypeAnnotations.ofInterfaceType(annotationAppender, param2AnnotationValueFilter, i++));
/*     */         }
/*     */         
/*     */         AnnotationList annotationList;
/*     */         
/* 159 */         for (AnnotationDescription annotationDescription : (annotationList = param2TypeDescription.getDeclaredAnnotations()).subList(this.annotationIndex, annotationList.size())) {
/* 160 */           annotationAppender = annotationAppender.append(annotationDescription, param2AnnotationValueFilter);
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.annotationIndex != ((Differentiating)param2Object).annotationIndex) ? false : ((this.typeVariableIndex != ((Differentiating)param2Object).typeVariableIndex) ? false : (!(this.interfaceTypeIndex != ((Differentiating)param2Object).interfaceTypeIndex))))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return ((getClass().hashCode() * 31 + this.annotationIndex) * 31 + this.typeVariableIndex) * 31 + this.interfaceTypeIndex;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Explicit
/*     */     implements TypeAttributeAppender
/*     */   {
/*     */     private final List<? extends AnnotationDescription> annotations;
/*     */     
/*     */     public Explicit(List<? extends AnnotationDescription> param1List) {
/* 184 */       this.annotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(ClassVisitor param1ClassVisitor, TypeDescription param1TypeDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 191 */       AnnotationAppender.Default default_ = new AnnotationAppender.Default(new AnnotationAppender.Target.OnType(param1ClassVisitor));
/* 192 */       for (AnnotationDescription annotationDescription : this.annotations) {
/* 193 */         AnnotationAppender annotationAppender = default_.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.annotations.equals(((Explicit)param1Object).annotations))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.annotations.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Compound
/*     */     implements TypeAttributeAppender
/*     */   {
/*     */     public Compound(TypeAttributeAppender... param1VarArgs) {
/* 215 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     private final List<TypeAttributeAppender> typeAttributeAppenders = new ArrayList<TypeAttributeAppender>(); public Compound(List<? extends TypeAttributeAppender> param1List) {
/* 225 */       for (Iterator<? extends TypeAttributeAppender> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 226 */         TypeAttributeAppender typeAttributeAppender; if (typeAttributeAppender = iterator.next() instanceof Compound) {
/* 227 */           this.typeAttributeAppenders.addAll(((Compound)typeAttributeAppender).typeAttributeAppenders); continue;
/* 228 */         }  if (!(typeAttributeAppender instanceof TypeAttributeAppender.NoOp)) {
/* 229 */           this.typeAttributeAppenders.add(typeAttributeAppender);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(ClassVisitor param1ClassVisitor, TypeDescription param1TypeDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 238 */       for (Iterator<TypeAttributeAppender> iterator = this.typeAttributeAppenders.iterator(); iterator.hasNext();)
/* 239 */         (typeAttributeAppender = iterator.next()).apply(param1ClassVisitor, param1TypeDescription, param1AnnotationValueFilter); 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typeAttributeAppenders.equals(((Compound)param1Object).typeAttributeAppenders))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.typeAttributeAppenders.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\attribute\TypeAttributeAppender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */