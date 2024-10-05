/*     */ package net.bytebuddy.implementation.attribute;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.method.ParameterList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ public interface MethodAttributeAppender
/*     */ {
/*     */   void apply(MethodVisitor paramMethodVisitor, MethodDescription paramMethodDescription, AnnotationValueFilter paramAnnotationValueFilter);
/*     */   
/*     */   public enum NoOp
/*     */     implements MethodAttributeAppender, Factory
/*     */   {
/*  56 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodAttributeAppender make(TypeDescription param1TypeDescription) {
/*  62 */       return this;
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
/*     */     public final void apply(MethodVisitor param1MethodVisitor, MethodDescription param1MethodDescription, AnnotationValueFilter param1AnnotationValueFilter) {}
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
/*     */     MethodAttributeAppender make(TypeDescription param1TypeDescription);
/*     */ 
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
/*     */       public Compound(MethodAttributeAppender.Factory... param2VarArgs) {
/* 104 */         this(Arrays.asList(param2VarArgs));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       private final List<MethodAttributeAppender.Factory> factories = new ArrayList<MethodAttributeAppender.Factory>(); public Compound(List<? extends MethodAttributeAppender.Factory> param2List) {
/* 114 */         for (Iterator<? extends MethodAttributeAppender.Factory> iterator = param2List.iterator(); iterator.hasNext(); ) {
/* 115 */           MethodAttributeAppender.Factory factory; if (factory = iterator.next() instanceof Compound) {
/* 116 */             this.factories.addAll(((Compound)factory).factories); continue;
/* 117 */           }  if (!(factory instanceof MethodAttributeAppender.NoOp)) {
/* 118 */             this.factories.add(factory);
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodAttributeAppender make(TypeDescription param2TypeDescription) {
/* 127 */         ArrayList<MethodAttributeAppender> arrayList = new ArrayList(this.factories.size());
/* 128 */         for (MethodAttributeAppender.Factory factory : this.factories) {
/* 129 */           arrayList.add(factory.make(param2TypeDescription));
/*     */         }
/* 131 */         return new MethodAttributeAppender.Compound(arrayList);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.factories.equals(((Compound)param2Object).factories))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.factories.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public enum ForInstrumentedMethod
/*     */     implements MethodAttributeAppender, Factory
/*     */   {
/* 151 */     EXCLUDING_RECEIVER
/*     */     {
/*     */       
/*     */       protected final AnnotationAppender appendReceiver(AnnotationAppender param2AnnotationAppender, AnnotationValueFilter param2AnnotationValueFilter, MethodDescription param2MethodDescription)
/*     */       {
/* 156 */         return param2AnnotationAppender;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     INCLUDING_RECEIVER
/*     */     {
/*     */       protected final AnnotationAppender appendReceiver(AnnotationAppender param2AnnotationAppender, AnnotationValueFilter param2AnnotationValueFilter, MethodDescription param2MethodDescription)
/*     */       {
/*     */         TypeDescription.Generic generic;
/*     */         
/* 178 */         return ((generic = param2MethodDescription.getReceiverType()) == null) ? param2AnnotationAppender : (AnnotationAppender)generic
/*     */           
/* 180 */           .accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(param2AnnotationAppender, param2AnnotationValueFilter));
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodAttributeAppender make(TypeDescription param1TypeDescription) {
/* 188 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(MethodVisitor param1MethodVisitor, MethodDescription param1MethodDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 195 */       AnnotationAppender.Default default_ = new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(param1MethodVisitor));
/*     */ 
/*     */       
/* 198 */       AnnotationAppender annotationAppender = AnnotationAppender.ForTypeAnnotations.ofTypeVariable(annotationAppender = (AnnotationAppender)param1MethodDescription.getReturnType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodReturnType(default_, param1AnnotationValueFilter)), param1AnnotationValueFilter, false, (List<? extends TypeDescription.Generic>)param1MethodDescription
/*     */ 
/*     */           
/* 201 */           .getTypeVariables());
/* 202 */       for (AnnotationDescription annotationDescription : param1MethodDescription.getDeclaredAnnotations().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.annotationType((ElementMatcher)ElementMatchers.nameStartsWith("jdk.internal."))))) {
/* 203 */         annotationAppender = annotationAppender.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/* 205 */       for (ParameterDescription parameterDescription : param1MethodDescription.getParameters()) {
/*     */         
/* 207 */         AnnotationAppender.Default default_1 = new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethodParameter(param1MethodVisitor, parameterDescription.getIndex()));
/* 208 */         AnnotationAppender annotationAppender1 = (AnnotationAppender)parameterDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodParameterType(default_1, param1AnnotationValueFilter, parameterDescription
/*     */               
/* 210 */               .getIndex()));
/* 211 */         for (AnnotationDescription annotationDescription : parameterDescription.getDeclaredAnnotations()) {
/* 212 */           annotationAppender1 = annotationAppender1.append(annotationDescription, param1AnnotationValueFilter);
/*     */         }
/*     */       } 
/* 215 */       annotationAppender = appendReceiver(annotationAppender, param1AnnotationValueFilter, param1MethodDescription);
/* 216 */       byte b = 0;
/* 217 */       for (Iterator<TypeDescription.Generic> iterator = param1MethodDescription.getExceptionTypes().iterator(); iterator.hasNext();) {
/* 218 */         annotationAppender = (AnnotationAppender)(generic = iterator.next()).accept(AnnotationAppender.ForTypeAnnotations.ofExceptionType(annotationAppender, param1AnnotationValueFilter, b++));
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
/*     */     protected abstract AnnotationAppender appendReceiver(AnnotationAppender param1AnnotationAppender, AnnotationValueFilter param1AnnotationValueFilter, MethodDescription param1MethodDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Explicit
/*     */     implements MethodAttributeAppender, Factory
/*     */   {
/*     */     private final Target target;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends AnnotationDescription> annotations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(int param1Int, List<? extends AnnotationDescription> param1List) {
/* 261 */       this(new Target.OnMethodParameter(param1Int), param1List);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(List<? extends AnnotationDescription> param1List) {
/* 270 */       this(Target.OnMethod.INSTANCE, param1List);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Explicit(Target param1Target, List<? extends AnnotationDescription> param1List) {
/* 280 */       this.target = param1Target;
/* 281 */       this.annotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static MethodAttributeAppender.Factory of(MethodDescription param1MethodDescription) {
/* 292 */       return new MethodAttributeAppender.Factory.Compound(new MethodAttributeAppender.Factory[] { ofMethodAnnotations(param1MethodDescription), ofParameterAnnotations(param1MethodDescription) });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static MethodAttributeAppender.Factory ofMethodAnnotations(MethodDescription param1MethodDescription) {
/* 302 */       return new Explicit((List<? extends AnnotationDescription>)param1MethodDescription.getDeclaredAnnotations());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static MethodAttributeAppender.Factory ofParameterAnnotations(MethodDescription param1MethodDescription) {
/* 313 */       ParameterList parameterList = param1MethodDescription.getParameters();
/* 314 */       ArrayList<Explicit> arrayList = new ArrayList(parameterList.size());
/* 315 */       for (ParameterDescription parameterDescription : parameterList) {
/* 316 */         arrayList.add(new Explicit(parameterDescription.getIndex(), (List<? extends AnnotationDescription>)parameterDescription.getDeclaredAnnotations()));
/*     */       }
/* 318 */       return new MethodAttributeAppender.Factory.Compound((List)arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodAttributeAppender make(TypeDescription param1TypeDescription) {
/* 325 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(MethodVisitor param1MethodVisitor, MethodDescription param1MethodDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 332 */       AnnotationAppender.Default default_ = new AnnotationAppender.Default(this.target.make(param1MethodVisitor, param1MethodDescription));
/* 333 */       for (AnnotationDescription annotationDescription : this.annotations) {
/* 334 */         AnnotationAppender annotationAppender = default_.append(annotationDescription, param1AnnotationValueFilter);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.target.equals(((Explicit)param1Object).target) ? false : (!!this.annotations.equals(((Explicit)param1Object).annotations)))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.annotations.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum OnMethod
/*     */       implements Target
/*     */     {
/* 362 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final AnnotationAppender.Target make(MethodVisitor param2MethodVisitor, MethodDescription param2MethodDescription) {
/* 368 */         return new AnnotationAppender.Target.OnMethod(param2MethodVisitor);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class OnMethodParameter
/*     */       implements Target
/*     */     {
/*     */       private final int parameterIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected OnMethodParameter(int param2Int) {
/* 389 */         this.parameterIndex = param2Int;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public AnnotationAppender.Target make(MethodVisitor param2MethodVisitor, MethodDescription param2MethodDescription)
/*     */       {
/* 396 */         if (this.parameterIndex >= param2MethodDescription.getParameters().size()) {
/* 397 */           throw new IllegalArgumentException("Method " + param2MethodDescription + " has less then " + this.parameterIndex + " parameters");
/*     */         }
/* 399 */         return new AnnotationAppender.Target.OnMethodParameter(param2MethodVisitor, this.parameterIndex); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!(this.parameterIndex != ((OnMethodParameter)param2Object).parameterIndex)))); } public int hashCode() { return getClass().hashCode() * 31 + this.parameterIndex; } } protected static interface Target { AnnotationAppender.Target make(MethodVisitor param2MethodVisitor, MethodDescription param2MethodDescription); public enum OnMethod implements Target { INSTANCE; public final AnnotationAppender.Target make(MethodVisitor param3MethodVisitor, MethodDescription param3MethodDescription) { return new AnnotationAppender.Target.OnMethod(param3MethodVisitor); } } @Enhance public static class OnMethodParameter implements Target { public AnnotationAppender.Target make(MethodVisitor param3MethodVisitor, MethodDescription param3MethodDescription) { if (this.parameterIndex >= param3MethodDescription.getParameters().size()) throw new IllegalArgumentException("Method " + param3MethodDescription + " has less then " + this.parameterIndex + " parameters");  return new AnnotationAppender.Target.OnMethodParameter(param3MethodVisitor, this.parameterIndex); }
/*     */ 
/*     */         
/*     */         private final int parameterIndex;
/*     */         
/*     */         protected OnMethodParameter(int param3Int) {
/*     */           this.parameterIndex = param3Int;
/*     */         }
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.parameterIndex != ((OnMethodParameter)param3Object).parameterIndex))));
/*     */         }
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.parameterIndex;
/*     */         } } }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class ForReceiverType implements MethodAttributeAppender, Factory {
/*     */     private final TypeDescription.Generic receiverType;
/*     */     
/*     */     public ForReceiverType(TypeDescription.Generic param1Generic) {
/* 422 */       this.receiverType = param1Generic;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodAttributeAppender make(TypeDescription param1TypeDescription) {
/* 429 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(MethodVisitor param1MethodVisitor, MethodDescription param1MethodDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 436 */       this.receiverType.accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(param1MethodVisitor)), param1AnnotationValueFilter));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.receiverType.equals(((ForReceiverType)param1Object).receiverType))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.receiverType.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Compound
/*     */     implements MethodAttributeAppender
/*     */   {
/*     */     public Compound(MethodAttributeAppender... param1VarArgs) {
/* 459 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 469 */     private final List<MethodAttributeAppender> methodAttributeAppenders = new ArrayList<MethodAttributeAppender>(); public Compound(List<? extends MethodAttributeAppender> param1List) {
/* 470 */       for (Iterator<? extends MethodAttributeAppender> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 471 */         MethodAttributeAppender methodAttributeAppender; if (methodAttributeAppender = iterator.next() instanceof Compound) {
/* 472 */           this.methodAttributeAppenders.addAll(((Compound)methodAttributeAppender).methodAttributeAppenders); continue;
/* 473 */         }  if (!(methodAttributeAppender instanceof MethodAttributeAppender.NoOp)) {
/* 474 */           this.methodAttributeAppenders.add(methodAttributeAppender);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void apply(MethodVisitor param1MethodVisitor, MethodDescription param1MethodDescription, AnnotationValueFilter param1AnnotationValueFilter) {
/* 483 */       for (Iterator<MethodAttributeAppender> iterator = this.methodAttributeAppenders.iterator(); iterator.hasNext();)
/* 484 */         (methodAttributeAppender = iterator.next()).apply(param1MethodVisitor, param1MethodDescription, param1AnnotationValueFilter); 
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.methodAttributeAppenders.equals(((Compound)param1Object).methodAttributeAppenders))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.methodAttributeAppenders.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\attribute\MethodAttributeAppender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */