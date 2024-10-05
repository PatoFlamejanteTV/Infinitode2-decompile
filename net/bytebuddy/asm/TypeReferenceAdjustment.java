/*     */ package net.bytebuddy.asm;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.ConstantDynamic;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
/*     */ import net.bytebuddy.jar.asm.Handle;
/*     */ import net.bytebuddy.jar.asm.Label;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.jar.asm.TypePath;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.OpenedClassReader;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class TypeReferenceAdjustment
/*     */   extends AsmVisitorWrapper.AbstractBase
/*     */ {
/*     */   private final boolean strict;
/*     */   private final ElementMatcher.Junction<? super TypeDescription> filter;
/*     */   
/*     */   protected TypeReferenceAdjustment(boolean paramBoolean, ElementMatcher.Junction<? super TypeDescription> paramJunction) {
/*  64 */     this.strict = paramBoolean;
/*  65 */     this.filter = paramJunction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeReferenceAdjustment strict() {
/*  75 */     return new TypeReferenceAdjustment(true, ElementMatchers.none());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeReferenceAdjustment relaxed() {
/*  85 */     return new TypeReferenceAdjustment(false, ElementMatchers.none());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeReferenceAdjustment filter(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/*  95 */     return new TypeReferenceAdjustment(this.strict, this.filter.or(paramElementMatcher));
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
/*     */   public ClassVisitor wrap(TypeDescription paramTypeDescription, ClassVisitor paramClassVisitor, Implementation.Context paramContext, TypePool paramTypePool, FieldList<FieldDescription.InDefinedShape> paramFieldList, MethodList<?> paramMethodList, int paramInt1, int paramInt2) {
/* 109 */     return new TypeReferenceClassVisitor(paramClassVisitor, this.strict, (ElementMatcher<? super TypeDescription>)this.filter, paramTypePool);
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.strict != ((TypeReferenceAdjustment)paramObject).strict) ? false : (!!this.filter.equals(((TypeReferenceAdjustment)paramObject).filter)))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return (getClass().hashCode() * 31 + this.strict) * 31 + this.filter.hashCode();
/*     */   }
/*     */   
/*     */   protected static class TypeReferenceClassVisitor extends ClassVisitor { @AlwaysNull
/* 121 */     private static final AnnotationVisitor IGNORE_ANNOTATION = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @AlwaysNull
/* 127 */     private static final FieldVisitor IGNORE_FIELD = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @AlwaysNull
/* 133 */     private static final MethodVisitor IGNORE_METHOD = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean strict;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ElementMatcher<? super TypeDescription> filter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypePool typePool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Set<String> observedTypes;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Set<String> visitedInnerTypes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected TypeReferenceClassVisitor(ClassVisitor param1ClassVisitor, boolean param1Boolean, ElementMatcher<? super TypeDescription> param1ElementMatcher, TypePool param1TypePool) {
/* 169 */       super(OpenedClassReader.ASM_API, param1ClassVisitor);
/* 170 */       this.typePool = param1TypePool;
/* 171 */       this.strict = param1Boolean;
/* 172 */       this.filter = param1ElementMatcher;
/* 173 */       this.observedTypes = new HashSet<String>();
/* 174 */       this.visitedInnerTypes = new HashSet<String>();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void visit(int param1Int1, int param1Int2, String param1String1, @MaybeNull String param1String2, @MaybeNull String param1String3, @MaybeNull String[] param1ArrayOfString) {
/* 184 */       if (param1String3 != null) {
/* 185 */         this.observedTypes.add(param1String3);
/*     */       }
/* 187 */       if (param1ArrayOfString != null) {
/* 188 */         this.observedTypes.addAll(Arrays.asList(param1ArrayOfString));
/*     */       }
/* 190 */       super.visit(param1Int1, param1Int2, param1String1, param1String2, param1String3, param1ArrayOfString);
/*     */     }
/*     */ 
/*     */     
/*     */     public void visitNestHost(String param1String) {
/* 195 */       this.observedTypes.add(param1String);
/* 196 */       super.visitNestHost(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public void visitOuterClass(String param1String1, String param1String2, String param1String3) {
/* 201 */       this.observedTypes.add(param1String1);
/* 202 */       super.visitOuterClass(param1String1, param1String2, param1String3);
/*     */     }
/*     */ 
/*     */     
/*     */     public void visitNestMember(String param1String) {
/* 207 */       this.observedTypes.add(param1String);
/* 208 */       super.visitNestMember(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public void visitInnerClass(String param1String1, String param1String2, String param1String3, int param1Int) {
/* 213 */       this.visitedInnerTypes.add(param1String1);
/* 214 */       super.visitInnerClass(param1String1, param1String2, param1String3, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public RecordComponentVisitor visitRecordComponent(String param1String1, String param1String2, @MaybeNull String param1String3) {
/* 220 */       this.observedTypes.add(Type.getType(param1String2).getInternalName());
/* 221 */       return super.visitRecordComponent(param1String1, param1String2, param1String3);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public AnnotationVisitor visitAnnotation(String param1String, boolean param1Boolean) {
/* 227 */       this.observedTypes.add(Type.getType(param1String).getInternalName());
/*     */       AnnotationVisitor annotationVisitor;
/* 229 */       if ((annotationVisitor = super.visitAnnotation(param1String, param1Boolean)) != null) {
/* 230 */         return new TypeReferenceAnnotationVisitor(this, annotationVisitor);
/*     */       }
/* 232 */       return IGNORE_ANNOTATION;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public AnnotationVisitor visitTypeAnnotation(int param1Int, @MaybeNull TypePath param1TypePath, String param1String, boolean param1Boolean) {
/* 239 */       this.observedTypes.add(Type.getType(param1String).getInternalName());
/*     */       AnnotationVisitor annotationVisitor;
/* 241 */       if ((annotationVisitor = super.visitTypeAnnotation(param1Int, param1TypePath, param1String, param1Boolean)) != null) {
/* 242 */         return new TypeReferenceAnnotationVisitor(this, annotationVisitor);
/*     */       }
/* 244 */       return IGNORE_ANNOTATION;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public FieldVisitor visitField(int param1Int, String param1String1, String param1String2, @MaybeNull String param1String3, @MaybeNull Object param1Object) {
/*     */       FieldVisitor fieldVisitor;
/* 252 */       if ((fieldVisitor = super.visitField(param1Int, param1String1, param1String2, param1String3, param1Object)) != null) {
/* 253 */         resolve(Type.getType(param1String2));
/* 254 */         return new TypeReferenceFieldVisitor(this, fieldVisitor);
/*     */       } 
/* 256 */       return IGNORE_FIELD;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public MethodVisitor visitMethod(int param1Int, String param1String1, String param1String2, @MaybeNull String param1String3, @MaybeNull String[] param1ArrayOfString) {
/*     */       MethodVisitor methodVisitor;
/* 264 */       if ((methodVisitor = super.visitMethod(param1Int, param1String1, param1String2, param1String3, param1ArrayOfString)) != null) {
/* 265 */         resolve(Type.getType(param1String2));
/* 266 */         if (param1ArrayOfString != null) {
/* 267 */           this.observedTypes.addAll(Arrays.asList(param1ArrayOfString));
/*     */         }
/* 269 */         return new TypeReferenceMethodVisitor(this, methodVisitor);
/*     */       } 
/* 271 */       return IGNORE_METHOD;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public void visitEnd() {
/* 278 */       for (String str : this.observedTypes) {
/* 279 */         if (this.visitedInnerTypes.add(str)) {
/*     */           TypePool.Resolution resolution;
/* 281 */           if ((resolution = this.typePool.describe(str.replace('/', '.'))).isResolved()) {
/* 282 */             TypeDescription typeDescription = resolution.resolve();
/* 283 */             if (!this.filter.matches(typeDescription)) {
/* 284 */               while (typeDescription != null && typeDescription.isNestedClass()) {
/* 285 */                 super.visitInnerClass(typeDescription.getInternalName(), 
/* 286 */                     typeDescription.isMemberType() ? typeDescription
/* 287 */                     .getDeclaringType().getInternalName() : null, 
/*     */                     
/* 289 */                     typeDescription.isAnonymousType() ? null : typeDescription
/*     */                     
/* 291 */                     .getSimpleName(), typeDescription
/* 292 */                     .getModifiers());
/*     */                 try {
/*     */                   do {
/*     */                   
/* 296 */                   } while ((typeDescription = typeDescription.getEnclosingType()) != null && !this.visitedInnerTypes.add(typeDescription.getInternalName()));
/* 297 */                 } catch (RuntimeException runtimeException) {
/* 298 */                   if (this.strict) {
/* 299 */                     throw runtimeException;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             }
/*     */             continue;
/*     */           } 
/* 306 */           if (this.strict) {
/* 307 */             throw new IllegalStateException("Could not locate type for: " + runtimeException.replace('/', '.'));
/*     */           }
/*     */         } 
/*     */       } 
/* 311 */       super.visitEnd();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void resolve(Type param1Type) {
/*     */       Type[] arrayOfType;
/*     */       Type type;
/* 320 */       if (param1Type.getSort() == 11) {
/* 321 */         resolve(param1Type.getReturnType()); int i; byte b;
/* 322 */         for (i = (arrayOfType = param1Type.getArgumentTypes()).length, b = 0; b < i; ) { Type type1 = arrayOfType[b];
/* 323 */           resolve(type1); b++; }
/*     */          return;
/*     */       } 
/* 326 */       while (arrayOfType.getSort() == 9) {
/* 327 */         type = arrayOfType.getElementType();
/*     */       }
/* 329 */       if (type.getSort() == 10) {
/* 330 */         this.observedTypes.add(type.getInternalName());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void resolve(Handle param1Handle) {
/* 341 */       this.observedTypes.add(param1Handle.getOwner());
/* 342 */       Type type = Type.getType(param1Handle.getDesc());
/* 343 */       resolve(type.getReturnType()); Type[] arrayOfType; int i; byte b;
/* 344 */       for (i = (arrayOfType = type.getArgumentTypes()).length, b = 0; b < i; ) { Type type1 = arrayOfType[b];
/* 345 */         resolve(type1);
/*     */         b++; }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void resolve(ConstantDynamic param1ConstantDynamic) {
/* 355 */       Type type = Type.getType(param1ConstantDynamic.getDescriptor());
/* 356 */       resolve(type.getReturnType()); Type[] arrayOfType; int i; byte b2;
/* 357 */       for (i = (arrayOfType = type.getArgumentTypes()).length, b2 = 0; b2 < i; ) { Type type1 = arrayOfType[b2];
/* 358 */         resolve(type1); b2++; }
/*     */       
/* 360 */       resolve(param1ConstantDynamic.getBootstrapMethod());
/* 361 */       for (byte b1 = 0; b1 < param1ConstantDynamic.getBootstrapMethodArgumentCount(); b1++) {
/* 362 */         resolve(param1ConstantDynamic.getBootstrapMethodArgument(b1));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void observeInternalName(String param1String) {
/*     */       int i;
/* 373 */       if ((i = param1String.lastIndexOf('[')) != -1) {
/* 374 */         param1String = param1String.substring(i + 2, param1String.length() - 1);
/*     */       }
/* 376 */       this.observedTypes.add(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void resolve(Object param1Object) {
/* 385 */       if (param1Object instanceof Type) {
/* 386 */         resolve((Type)param1Object); return;
/* 387 */       }  if (param1Object instanceof Handle) {
/* 388 */         resolve((Handle)param1Object); return;
/* 389 */       }  if (param1Object instanceof ConstantDynamic) {
/* 390 */         resolve((ConstantDynamic)param1Object);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected class TypeReferenceAnnotationVisitor
/*     */       extends AnnotationVisitor
/*     */     {
/*     */       protected TypeReferenceAnnotationVisitor(TypeReferenceAdjustment.TypeReferenceClassVisitor this$0, AnnotationVisitor param2AnnotationVisitor) {
/* 405 */         super(OpenedClassReader.ASM_API, param2AnnotationVisitor);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visit(String param2String, Object param2Object) {
/* 410 */         this.a.resolve(param2Object);
/* 411 */         super.visit(param2String, param2Object);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitEnum(String param2String1, String param2String2, String param2String3) {
/* 416 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String2).getInternalName());
/* 417 */         super.visitEnum(param2String1, param2String2, param2String3);
/*     */       }
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitAnnotation(String param2String1, String param2String2) {
/* 423 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String2).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 425 */         if ((annotationVisitor = super.visitAnnotation(param2String1, param2String2)) != null) {
/* 426 */           return new TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 428 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitArray(String param2String) {
/*     */         AnnotationVisitor annotationVisitor;
/* 436 */         if ((annotationVisitor = super.visitArray(param2String)) != null) {
/* 437 */           return new TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 439 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
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
/*     */     protected class TypeReferenceFieldVisitor
/*     */       extends FieldVisitor
/*     */     {
/*     */       protected TypeReferenceFieldVisitor(TypeReferenceAdjustment.TypeReferenceClassVisitor this$0, FieldVisitor param2FieldVisitor) {
/* 455 */         super(OpenedClassReader.ASM_API, param2FieldVisitor);
/*     */       }
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitAnnotation(String param2String, boolean param2Boolean) {
/* 461 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 463 */         if ((annotationVisitor = super.visitAnnotation(param2String, param2Boolean)) != null) {
/* 464 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 466 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
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
/*     */     protected class TypeReferenceMethodVisitor
/*     */       extends MethodVisitor
/*     */     {
/*     */       protected TypeReferenceMethodVisitor(TypeReferenceAdjustment.TypeReferenceClassVisitor this$0, MethodVisitor param2MethodVisitor) {
/* 482 */         super(OpenedClassReader.ASM_API, param2MethodVisitor);
/*     */       }
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitAnnotationDefault() {
/*     */         AnnotationVisitor annotationVisitor;
/* 489 */         if ((annotationVisitor = super.visitAnnotationDefault()) != null) {
/* 490 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 492 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitAnnotation(String param2String, boolean param2Boolean) {
/* 499 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 501 */         if ((annotationVisitor = super.visitAnnotation(param2String, param2Boolean)) != null) {
/* 502 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 504 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitTypeAnnotation(int param2Int, @MaybeNull TypePath param2TypePath, String param2String, boolean param2Boolean) {
/* 511 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 513 */         if ((annotationVisitor = super.visitTypeAnnotation(param2Int, param2TypePath, param2String, param2Boolean)) != null) {
/* 514 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 516 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitParameterAnnotation(int param2Int, String param2String, boolean param2Boolean) {
/* 523 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 525 */         if ((annotationVisitor = super.visitParameterAnnotation(param2Int, param2String, param2Boolean)) != null) {
/* 526 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 528 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitInsnAnnotation(int param2Int, @MaybeNull TypePath param2TypePath, String param2String, boolean param2Boolean) {
/* 535 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 537 */         if ((annotationVisitor = super.visitInsnAnnotation(param2Int, param2TypePath, param2String, param2Boolean)) != null) {
/* 538 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 540 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitTryCatchAnnotation(int param2Int, @MaybeNull TypePath param2TypePath, String param2String, boolean param2Boolean) {
/* 547 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 549 */         if ((annotationVisitor = super.visitTryCatchAnnotation(param2Int, param2TypePath, param2String, param2Boolean)) != null) {
/* 550 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 552 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationVisitor visitLocalVariableAnnotation(int param2Int, @MaybeNull TypePath param2TypePath, Label[] param2ArrayOfLabel1, Label[] param2ArrayOfLabel2, int[] param2ArrayOfint, String param2String, boolean param2Boolean) {
/* 565 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(Type.getType(param2String).getInternalName());
/*     */         AnnotationVisitor annotationVisitor;
/* 567 */         if ((annotationVisitor = super.visitLocalVariableAnnotation(param2Int, param2TypePath, param2ArrayOfLabel1, param2ArrayOfLabel2, param2ArrayOfint, param2String, param2Boolean)) != null) {
/* 568 */           return new TypeReferenceAdjustment.TypeReferenceClassVisitor.TypeReferenceAnnotationVisitor(this.a, annotationVisitor);
/*     */         }
/* 570 */         return TypeReferenceAdjustment.TypeReferenceClassVisitor.a();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void visitTypeInsn(int param2Int, String param2String) {
/* 576 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a, param2String);
/* 577 */         super.visitTypeInsn(param2Int, param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitFieldInsn(int param2Int, String param2String1, String param2String2, String param2String3) {
/* 582 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a, param2String1);
/* 583 */         this.a.resolve(Type.getType(param2String3));
/* 584 */         super.visitFieldInsn(param2Int, param2String1, param2String2, param2String3);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitMethodInsn(int param2Int, String param2String1, String param2String2, String param2String3, boolean param2Boolean) {
/* 589 */         TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a, param2String1);
/* 590 */         this.a.resolve(Type.getType(param2String3));
/* 591 */         super.visitMethodInsn(param2Int, param2String1, param2String2, param2String3, param2Boolean);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitInvokeDynamicInsn(String param2String1, String param2String2, Handle param2Handle, Object... param2VarArgs) {
/* 596 */         this.a.resolve(Type.getType(param2String2));
/* 597 */         this.a.resolve(param2Handle); Object[] arrayOfObject; int i; byte b;
/* 598 */         for (i = (arrayOfObject = param2VarArgs).length, b = 0; b < i; ) { Object object = arrayOfObject[b];
/* 599 */           this.a.resolve(object); b++; }
/*     */         
/* 601 */         super.visitInvokeDynamicInsn(param2String1, param2String2, param2Handle, param2VarArgs);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitLdcInsn(Object param2Object) {
/* 606 */         this.a.resolve(param2Object);
/* 607 */         super.visitLdcInsn(param2Object);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitMultiANewArrayInsn(String param2String, int param2Int) {
/* 612 */         this.a.resolve(Type.getType(param2String));
/* 613 */         super.visitMultiANewArrayInsn(param2String, param2Int);
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitTryCatchBlock(Label param2Label1, Label param2Label2, Label param2Label3, @MaybeNull String param2String) {
/* 618 */         if (param2String != null) {
/* 619 */           TypeReferenceAdjustment.TypeReferenceClassVisitor.a(this.a).add(param2String);
/*     */         }
/* 621 */         super.visitTryCatchBlock(param2Label1, param2Label2, param2Label3, param2String);
/*     */       }
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\TypeReferenceAdjustment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */