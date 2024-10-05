/*     */ package net.bytebuddy.implementation.attribute;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.jar.asm.TypePath;
/*     */ import net.bytebuddy.jar.asm.TypeReference;
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
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
/*     */ public interface AnnotationAppender
/*     */ {
/*     */   @AlwaysNull
/*  41 */   public static final String NO_NAME = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnnotationAppender append(AnnotationDescription paramAnnotationDescription, AnnotationValueFilter paramAnnotationValueFilter);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnnotationAppender append(AnnotationDescription paramAnnotationDescription, AnnotationValueFilter paramAnnotationValueFilter, int paramInt, String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Target
/*     */   {
/*     */     @MaybeNull
/*     */     AnnotationVisitor visit(String param1String, boolean param1Boolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     AnnotationVisitor visit(String param1String1, boolean param1Boolean, int param1Int, String param1String2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class OnType
/*     */       implements Target
/*     */     {
/*     */       private final ClassVisitor classVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public OnType(ClassVisitor param2ClassVisitor) {
/* 107 */         this.classVisitor = param2ClassVisitor;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String, boolean param2Boolean) {
/* 115 */         return this.classVisitor.visitAnnotation(param2String, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String1, boolean param2Boolean, int param2Int, String param2String2) {
/* 123 */         return this.classVisitor.visitTypeAnnotation(param2Int, TypePath.fromString(param2String2), param2String1, param2Boolean);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.classVisitor.equals(((OnType)param2Object).classVisitor))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.classVisitor.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static class OnField
/*     */       implements Target
/*     */     {
/*     */       private final FieldVisitor fieldVisitor;
/*     */       
/*     */       public OnField(FieldVisitor param2FieldVisitor) {
/* 144 */         this.fieldVisitor = param2FieldVisitor;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String, boolean param2Boolean) {
/* 152 */         return this.fieldVisitor.visitAnnotation(param2String, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String1, boolean param2Boolean, int param2Int, String param2String2) {
/* 160 */         return this.fieldVisitor.visitTypeAnnotation(param2Int, TypePath.fromString(param2String2), param2String1, param2Boolean);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldVisitor.equals(((OnField)param2Object).fieldVisitor))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.fieldVisitor.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static class OnMethod
/*     */       implements Target
/*     */     {
/*     */       private final MethodVisitor methodVisitor;
/*     */       
/*     */       public OnMethod(MethodVisitor param2MethodVisitor) {
/* 181 */         this.methodVisitor = param2MethodVisitor;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String, boolean param2Boolean) {
/* 189 */         return this.methodVisitor.visitAnnotation(param2String, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String1, boolean param2Boolean, int param2Int, String param2String2) {
/* 197 */         return this.methodVisitor.visitTypeAnnotation(param2Int, TypePath.fromString(param2String2), param2String1, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.methodVisitor.equals(((OnMethod)param2Object).methodVisitor))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.methodVisitor.hashCode();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class OnMethodParameter
/*     */       implements Target
/*     */     {
/*     */       private final MethodVisitor methodVisitor;
/*     */       
/*     */       private final int parameterIndex;
/*     */ 
/*     */       
/*     */       public OnMethodParameter(MethodVisitor param2MethodVisitor, int param2Int) {
/* 224 */         this.methodVisitor = param2MethodVisitor;
/* 225 */         this.parameterIndex = param2Int;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String, boolean param2Boolean) {
/* 233 */         return this.methodVisitor.visitParameterAnnotation(this.parameterIndex, param2String, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String1, boolean param2Boolean, int param2Int, String param2String2) {
/* 241 */         return this.methodVisitor.visitTypeAnnotation(param2Int, TypePath.fromString(param2String2), param2String1, param2Boolean);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.parameterIndex != ((OnMethodParameter)param2Object).parameterIndex) ? false : (!!this.methodVisitor.equals(((OnMethodParameter)param2Object).methodVisitor)))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.methodVisitor.hashCode()) * 31 + this.parameterIndex;
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static class OnRecordComponent
/*     */       implements Target
/*     */     {
/*     */       private final RecordComponentVisitor recordComponentVisitor;
/*     */       
/*     */       public OnRecordComponent(RecordComponentVisitor param2RecordComponentVisitor) {
/* 262 */         this.recordComponentVisitor = param2RecordComponentVisitor;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String, boolean param2Boolean) {
/* 270 */         return this.recordComponentVisitor.visitAnnotation(param2String, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visit(String param2String1, boolean param2Boolean, int param2Int, String param2String2) {
/* 278 */         return this.recordComponentVisitor.visitTypeAnnotation(param2Int, TypePath.fromString(param2String2), param2String1, param2Boolean);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.recordComponentVisitor.equals(((OnRecordComponent)param2Object).recordComponentVisitor))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.recordComponentVisitor.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Default
/*     */     implements AnnotationAppender
/*     */   {
/*     */     private final AnnotationAppender.Target target;
/*     */     
/*     */     public Default(AnnotationAppender.Target param1Target) {
/* 301 */       this.target = param1Target;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static void handle(AnnotationVisitor param1AnnotationVisitor, AnnotationDescription param1AnnotationDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 312 */       for (MethodDescription.InDefinedShape inDefinedShape : param1AnnotationDescription.getAnnotationType().getDeclaredMethods()) {
/* 313 */         if (param1AnnotationValueFilter.isRelevant(param1AnnotationDescription, inDefinedShape)) {
/* 314 */           apply(param1AnnotationVisitor, inDefinedShape.getReturnType().asErasure(), inDefinedShape.getName(), param1AnnotationDescription.getValue(inDefinedShape).resolve());
/*     */         }
/*     */       } 
/* 317 */       param1AnnotationVisitor.visitEnd();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static void apply(AnnotationVisitor param1AnnotationVisitor, TypeDescription param1TypeDescription, @MaybeNull String param1String, Object param1Object) {
/*     */       int i;
/* 329 */       if (param1TypeDescription.isArray()) {
/* 330 */         param1AnnotationVisitor = param1AnnotationVisitor.visitArray(param1String);
/* 331 */         i = Array.getLength(param1Object);
/* 332 */         param1TypeDescription = param1TypeDescription.getComponentType();
/* 333 */         for (byte b = 0; b < i; b++) {
/* 334 */           apply(param1AnnotationVisitor, param1TypeDescription, NO_NAME, Array.get(param1Object, b));
/*     */         }
/* 336 */         param1AnnotationVisitor.visitEnd(); return;
/* 337 */       }  if (param1TypeDescription.isAnnotation()) {
/* 338 */         handle(param1AnnotationVisitor.visitAnnotation(i, param1TypeDescription.getDescriptor()), (AnnotationDescription)param1Object, AnnotationValueFilter.Default.APPEND_DEFAULTS); return;
/* 339 */       }  if (param1TypeDescription.isEnum()) {
/* 340 */         param1AnnotationVisitor.visitEnum(i, param1TypeDescription.getDescriptor(), ((EnumerationDescription)param1Object).getValue()); return;
/* 341 */       }  if (param1TypeDescription.represents(Class.class)) {
/* 342 */         param1AnnotationVisitor.visit(i, Type.getType(((TypeDescription)param1Object).getDescriptor())); return;
/*     */       } 
/* 344 */       param1AnnotationVisitor.visit(i, param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationAppender append(AnnotationDescription param1AnnotationDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 352 */       switch (AnnotationAppender.null.a[param1AnnotationDescription.getRetention().ordinal()]) {
/*     */         case 1:
/* 354 */           doAppend(param1AnnotationDescription, true, param1AnnotationValueFilter);
/*     */         
/*     */         case 2:
/* 357 */           doAppend(param1AnnotationDescription, false, param1AnnotationValueFilter);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 3:
/* 364 */           return this;
/*     */       } 
/*     */       throw new IllegalStateException("Unexpected retention policy: " + param1AnnotationDescription.getRetention());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void doAppend(AnnotationDescription param1AnnotationDescription, boolean param1Boolean, AnnotationValueFilter param1AnnotationValueFilter) {
/*     */       AnnotationVisitor annotationVisitor;
/* 376 */       if ((annotationVisitor = this.target.visit(param1AnnotationDescription.getAnnotationType().getDescriptor(), param1Boolean)) != null) {
/* 377 */         handle(annotationVisitor, param1AnnotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationAppender append(AnnotationDescription param1AnnotationDescription, AnnotationValueFilter param1AnnotationValueFilter, int param1Int, String param1String) {
/* 385 */       switch (AnnotationAppender.null.a[param1AnnotationDescription.getRetention().ordinal()]) {
/*     */         case 1:
/* 387 */           doAppend(param1AnnotationDescription, true, param1AnnotationValueFilter, param1Int, param1String);
/*     */         
/*     */         case 2:
/* 390 */           doAppend(param1AnnotationDescription, false, param1AnnotationValueFilter, param1Int, param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 3:
/* 397 */           return this;
/*     */       } 
/*     */       throw new IllegalStateException("Unexpected retention policy: " + param1AnnotationDescription.getRetention());
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
/*     */ 
/*     */     
/*     */     private void doAppend(AnnotationDescription param1AnnotationDescription, boolean param1Boolean, AnnotationValueFilter param1AnnotationValueFilter, int param1Int, String param1String) {
/*     */       AnnotationVisitor annotationVisitor;
/* 415 */       if ((annotationVisitor = this.target.visit(param1AnnotationDescription.getAnnotationType().getDescriptor(), param1Boolean, param1Int, param1String)) != null) {
/* 416 */         handle(annotationVisitor, param1AnnotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.target.equals(((Default)param1Object).target))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.target.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForTypeAnnotations
/*     */     implements TypeDescription.Generic.Visitor<AnnotationAppender>
/*     */   {
/*     */     public static final boolean VARIABLE_ON_TYPE = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final boolean VARIABLE_ON_INVOKEABLE = false;
/*     */ 
/*     */ 
/*     */     
/*     */     private static final String EMPTY_TYPE_PATH = "";
/*     */ 
/*     */ 
/*     */     
/*     */     private static final char COMPONENT_TYPE_PATH = '[';
/*     */ 
/*     */ 
/*     */     
/*     */     private static final char WILDCARD_TYPE_PATH = '*';
/*     */ 
/*     */ 
/*     */     
/*     */     private static final char INNER_CLASS_PATH = '.';
/*     */ 
/*     */ 
/*     */     
/*     */     private static final char INDEXED_TYPE_DELIMITER = ';';
/*     */ 
/*     */ 
/*     */     
/*     */     private static final int SUPER_CLASS_INDEX = -1;
/*     */ 
/*     */ 
/*     */     
/*     */     private final AnnotationAppender annotationAppender;
/*     */ 
/*     */ 
/*     */     
/*     */     private final AnnotationValueFilter annotationValueFilter;
/*     */ 
/*     */ 
/*     */     
/*     */     private final int typeReference;
/*     */ 
/*     */ 
/*     */     
/*     */     private final String typePath;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForTypeAnnotations(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, TypeReference param1TypeReference) {
/* 496 */       this(param1AnnotationAppender, param1AnnotationValueFilter, param1TypeReference.getValue(), "");
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
/*     */     protected ForTypeAnnotations(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, int param1Int, String param1String) {
/* 508 */       this.annotationAppender = param1AnnotationAppender;
/* 509 */       this.annotationValueFilter = param1AnnotationValueFilter;
/* 510 */       this.typeReference = param1Int;
/* 511 */       this.typePath = param1String;
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
/*     */     public static TypeDescription.Generic.Visitor<AnnotationAppender> ofSuperClass(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter) {
/* 523 */       return new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, TypeReference.newSuperTypeReference(-1));
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
/*     */     
/*     */     public static TypeDescription.Generic.Visitor<AnnotationAppender> ofInterfaceType(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, int param1Int) {
/* 537 */       return new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, TypeReference.newSuperTypeReference(param1Int));
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
/*     */     public static TypeDescription.Generic.Visitor<AnnotationAppender> ofFieldType(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter) {
/* 549 */       return new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, TypeReference.newTypeReference(19));
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
/*     */     public static TypeDescription.Generic.Visitor<AnnotationAppender> ofMethodReturnType(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter) {
/* 561 */       return new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, TypeReference.newTypeReference(20));
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
/*     */     
/*     */     public static TypeDescription.Generic.Visitor<AnnotationAppender> ofMethodParameterType(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, int param1Int) {
/* 575 */       return new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, TypeReference.newFormalParameterReference(param1Int));
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
/*     */     
/*     */     public static TypeDescription.Generic.Visitor<AnnotationAppender> ofExceptionType(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, int param1Int) {
/* 589 */       return new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, TypeReference.newExceptionReference(param1Int));
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
/*     */     public static TypeDescription.Generic.Visitor<AnnotationAppender> ofReceiverType(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter) {
/* 601 */       return new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, TypeReference.newTypeReference(21));
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
/*     */ 
/*     */ 
/*     */     
/*     */     public static AnnotationAppender ofTypeVariable(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, boolean param1Boolean, List<? extends TypeDescription.Generic> param1List) {
/* 617 */       return ofTypeVariable(param1AnnotationAppender, param1AnnotationValueFilter, param1Boolean, 0, param1List);
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static AnnotationAppender ofTypeVariable(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, boolean param1Boolean, int param1Int, List<? extends TypeDescription.Generic> param1List) {
/*     */       byte b;
/* 635 */       int i = param1Int;
/* 636 */       if (param1Boolean) {
/* 637 */         param1Boolean = false;
/* 638 */         b = 17;
/*     */       } else {
/* 640 */         param1Boolean = true;
/* 641 */         b = 18;
/*     */       } 
/* 643 */       for (TypeDescription.Generic generic : param1List.subList(param1Int, param1List.size())) {
/* 644 */         int j = TypeReference.newTypeParameterReference(param1Boolean, i).getValue();
/* 645 */         for (AnnotationDescription annotationDescription : generic.getDeclaredAnnotations()) {
/* 646 */           param1AnnotationAppender = param1AnnotationAppender.append(annotationDescription, param1AnnotationValueFilter, j, "");
/*     */         }
/* 648 */         byte b1 = (!((TypeDescription.Generic)generic.getUpperBounds().get(0)).getSort().isTypeVariable() && ((TypeDescription.Generic)generic.getUpperBounds().get(0)).isInterface()) ? 1 : 0;
/*     */ 
/*     */         
/* 651 */         for (Iterator<TypeDescription.Generic> iterator = generic.getUpperBounds().iterator(); iterator.hasNext();) {
/* 652 */           param1AnnotationAppender = (AnnotationAppender)(generic = iterator.next()).accept(new ForTypeAnnotations(param1AnnotationAppender, param1AnnotationValueFilter, 
/*     */                 
/* 654 */                 TypeReference.newTypeParameterBoundReference(b, i, b1++)));
/*     */         }
/* 656 */         i++;
/*     */       } 
/* 658 */       return param1AnnotationAppender;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*     */     public AnnotationAppender onGenericArray(TypeDescription.Generic param1Generic) {
/* 666 */       return (AnnotationAppender)param1Generic.getComponentType().accept(new ForTypeAnnotations(apply(param1Generic, this.typePath), this.annotationValueFilter, this.typeReference, this.typePath + '['));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationAppender onWildcard(TypeDescription.Generic param1Generic) {
/*     */       TypeList.Generic generic;
/* 676 */       return (AnnotationAppender)(
/* 677 */         (generic = param1Generic.getLowerBounds()).isEmpty() ? (TypeDescription.Generic)param1Generic
/* 678 */         .getUpperBounds().getOnly() : (TypeDescription.Generic)generic
/* 679 */         .getOnly()).accept(new ForTypeAnnotations(apply(param1Generic, this.typePath), this.annotationValueFilter, this.typeReference, this.typePath + '*'));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationAppender onParameterizedType(TypeDescription.Generic param1Generic) {
/* 686 */       StringBuilder stringBuilder = new StringBuilder(this.typePath);
/* 687 */       for (byte b1 = 0; b1 < param1Generic.asErasure().getInnerClassCount(); b1++) {
/* 688 */         stringBuilder = stringBuilder.append('.');
/*     */       }
/* 690 */       AnnotationAppender annotationAppender = apply(param1Generic, stringBuilder.toString());
/*     */       TypeDescription.Generic generic;
/* 692 */       if ((generic = param1Generic.getOwnerType()) != null) {
/* 693 */         annotationAppender = (AnnotationAppender)generic.accept(new ForTypeAnnotations(annotationAppender, this.annotationValueFilter, this.typeReference, this.typePath));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 698 */       byte b2 = 0;
/* 699 */       for (Iterator<TypeDescription.Generic> iterator = param1Generic.getTypeArguments().iterator(); iterator.hasNext();) {
/* 700 */         annotationAppender = (AnnotationAppender)(generic1 = iterator.next()).accept(new ForTypeAnnotations(annotationAppender, this.annotationValueFilter, this.typeReference, stringBuilder
/*     */ 
/*     */               
/* 703 */               .toString() + b2++ + ';'));
/*     */       }
/* 705 */       return annotationAppender;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationAppender onTypeVariable(TypeDescription.Generic param1Generic) {
/* 712 */       return apply(param1Generic, this.typePath);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationAppender onNonGenericType(TypeDescription.Generic param1Generic) {
/* 719 */       StringBuilder stringBuilder = new StringBuilder(this.typePath);
/* 720 */       for (byte b = 0; b < param1Generic.asErasure().getInnerClassCount(); b++) {
/* 721 */         stringBuilder = stringBuilder.append('.');
/*     */       }
/* 723 */       AnnotationAppender annotationAppender = apply(param1Generic, stringBuilder.toString());
/*     */       
/* 725 */       if ((param1Generic = param1Generic.getComponentType()) != null) {
/* 726 */         annotationAppender = (AnnotationAppender)param1Generic.accept(new ForTypeAnnotations(annotationAppender, this.annotationValueFilter, this.typeReference, this.typePath + '['));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 731 */       return annotationAppender;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private AnnotationAppender apply(TypeDescription.Generic param1Generic, String param1String) {
/* 742 */       AnnotationAppender annotationAppender = this.annotationAppender;
/* 743 */       for (AnnotationDescription annotationDescription : param1Generic.getDeclaredAnnotations()) {
/* 744 */         annotationAppender = annotationAppender.append(annotationDescription, this.annotationValueFilter, this.typeReference, param1String);
/*     */       }
/* 746 */       return annotationAppender;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.typeReference != ((ForTypeAnnotations)param1Object).typeReference) ? false : (!this.typePath.equals(((ForTypeAnnotations)param1Object).typePath) ? false : (!this.annotationAppender.equals(((ForTypeAnnotations)param1Object).annotationAppender) ? false : (!!this.annotationValueFilter.equals(((ForTypeAnnotations)param1Object).annotationValueFilter)))))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (((getClass().hashCode() * 31 + this.annotationAppender.hashCode()) * 31 + this.annotationValueFilter.hashCode()) * 31 + this.typeReference) * 31 + this.typePath.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\attribute\AnnotationAppender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */