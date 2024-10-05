/*     */ package net.bytebuddy.asm;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.CompoundList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Enhance
/*     */ public class ModifierAdjustment
/*     */   extends AsmVisitorWrapper.AbstractBase
/*     */ {
/*     */   private final List<Adjustment<TypeDescription>> typeAdjustments;
/*     */   private final List<Adjustment<FieldDescription.InDefinedShape>> fieldAdjustments;
/*     */   private final List<Adjustment<MethodDescription>> methodAdjustments;
/*     */   
/*     */   public ModifierAdjustment() {
/*  73 */     this(Collections.emptyList(), 
/*  74 */         Collections.emptyList(), 
/*  75 */         Collections.emptyList());
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
/*     */   protected ModifierAdjustment(List<Adjustment<TypeDescription>> paramList, List<Adjustment<FieldDescription.InDefinedShape>> paramList1, List<Adjustment<MethodDescription>> paramList2) {
/*  88 */     this.typeAdjustments = paramList;
/*  89 */     this.fieldAdjustments = paramList1;
/*  90 */     this.methodAdjustments = paramList2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withTypeModifiers(ModifierContributor.ForType... paramVarArgs) {
/* 100 */     return withTypeModifiers(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withTypeModifiers(List<? extends ModifierContributor.ForType> paramList) {
/* 110 */     return withTypeModifiers((ElementMatcher<? super TypeDescription>)ElementMatchers.any(), paramList);
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
/*     */   public ModifierAdjustment withTypeModifiers(ElementMatcher<? super TypeDescription> paramElementMatcher, ModifierContributor.ForType... paramVarArgs) {
/* 122 */     return withTypeModifiers(paramElementMatcher, Arrays.asList(paramVarArgs));
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
/*     */   public ModifierAdjustment withTypeModifiers(ElementMatcher<? super TypeDescription> paramElementMatcher, List<? extends ModifierContributor.ForType> paramList) {
/* 134 */     return new ModifierAdjustment(CompoundList.of(new Adjustment<TypeDescription>(paramElementMatcher, 
/* 135 */             ModifierContributor.Resolver.of(paramList)), this.typeAdjustments), this.fieldAdjustments, this.methodAdjustments);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withFieldModifiers(ModifierContributor.ForField... paramVarArgs) {
/* 145 */     return withFieldModifiers(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withFieldModifiers(List<? extends ModifierContributor.ForField> paramList) {
/* 155 */     return withFieldModifiers((ElementMatcher<? super FieldDescription.InDefinedShape>)ElementMatchers.any(), paramList);
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
/*     */   public ModifierAdjustment withFieldModifiers(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher, ModifierContributor.ForField... paramVarArgs) {
/* 167 */     return withFieldModifiers(paramElementMatcher, Arrays.asList(paramVarArgs));
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
/*     */   public ModifierAdjustment withFieldModifiers(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher, List<? extends ModifierContributor.ForField> paramList) {
/* 179 */     return new ModifierAdjustment(this.typeAdjustments, CompoundList.of(new Adjustment<FieldDescription.InDefinedShape>(paramElementMatcher, 
/* 180 */             ModifierContributor.Resolver.of(paramList)), this.fieldAdjustments), this.methodAdjustments);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withMethodModifiers(ModifierContributor.ForMethod... paramVarArgs) {
/* 190 */     return withMethodModifiers(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withMethodModifiers(List<? extends ModifierContributor.ForMethod> paramList) {
/* 200 */     return withMethodModifiers((ElementMatcher<? super MethodDescription>)ElementMatchers.any(), paramList);
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
/*     */   public ModifierAdjustment withMethodModifiers(ElementMatcher<? super MethodDescription> paramElementMatcher, ModifierContributor.ForMethod... paramVarArgs) {
/* 212 */     return withMethodModifiers(paramElementMatcher, Arrays.asList(paramVarArgs));
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
/*     */   public ModifierAdjustment withMethodModifiers(ElementMatcher<? super MethodDescription> paramElementMatcher, List<? extends ModifierContributor.ForMethod> paramList) {
/* 224 */     return withInvokableModifiers((ElementMatcher<? super MethodDescription>)ElementMatchers.isMethod().and(paramElementMatcher), paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withConstructorModifiers(ModifierContributor.ForMethod... paramVarArgs) {
/* 234 */     return withConstructorModifiers(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withConstructorModifiers(List<? extends ModifierContributor.ForMethod> paramList) {
/* 244 */     return withConstructorModifiers((ElementMatcher<? super MethodDescription>)ElementMatchers.any(), paramList);
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
/*     */   public ModifierAdjustment withConstructorModifiers(ElementMatcher<? super MethodDescription> paramElementMatcher, ModifierContributor.ForMethod... paramVarArgs) {
/* 256 */     return withConstructorModifiers(paramElementMatcher, Arrays.asList(paramVarArgs));
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
/*     */   public ModifierAdjustment withConstructorModifiers(ElementMatcher<? super MethodDescription> paramElementMatcher, List<? extends ModifierContributor.ForMethod> paramList) {
/* 268 */     return withInvokableModifiers((ElementMatcher<? super MethodDescription>)ElementMatchers.isConstructor().and(paramElementMatcher), paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withInvokableModifiers(ModifierContributor.ForMethod... paramVarArgs) {
/* 278 */     return withInvokableModifiers(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierAdjustment withInvokableModifiers(List<? extends ModifierContributor.ForMethod> paramList) {
/* 288 */     return withInvokableModifiers((ElementMatcher<? super MethodDescription>)ElementMatchers.any(), paramList);
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
/*     */   public ModifierAdjustment withInvokableModifiers(ElementMatcher<? super MethodDescription> paramElementMatcher, ModifierContributor.ForMethod... paramVarArgs) {
/* 300 */     return withInvokableModifiers(paramElementMatcher, Arrays.asList(paramVarArgs));
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
/*     */   public ModifierAdjustment withInvokableModifiers(ElementMatcher<? super MethodDescription> paramElementMatcher, List<? extends ModifierContributor.ForMethod> paramList) {
/* 312 */     return new ModifierAdjustment(this.typeAdjustments, this.fieldAdjustments, CompoundList.of(new Adjustment<MethodDescription>(paramElementMatcher, 
/* 313 */             ModifierContributor.Resolver.of(paramList)), this.methodAdjustments));
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
/*     */   public ModifierAdjustingClassVisitor wrap(TypeDescription paramTypeDescription, ClassVisitor paramClassVisitor, Implementation.Context paramContext, TypePool paramTypePool, FieldList<FieldDescription.InDefinedShape> paramFieldList, MethodList<?> paramMethodList, int paramInt1, int paramInt2) {
/* 327 */     HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 328 */     for (FieldDescription.InDefinedShape inDefinedShape : paramFieldList) {
/* 329 */       hashMap1.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
/*     */     }
/* 331 */     HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/* 332 */     for (MethodDescription methodDescription : CompoundList.of((List)paramMethodList, new MethodDescription.Latent.TypeInitializer(paramTypeDescription))) {
/* 333 */       hashMap2.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
/*     */     }
/* 335 */     return new ModifierAdjustingClassVisitor(paramClassVisitor, this.typeAdjustments, this.fieldAdjustments, this.methodAdjustments, paramTypeDescription, (Map)hashMap1, (Map)hashMap2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.typeAdjustments.equals(((ModifierAdjustment)paramObject).typeAdjustments) ? false : (!this.fieldAdjustments.equals(((ModifierAdjustment)paramObject).fieldAdjustments) ? false : (!!this.methodAdjustments.equals(((ModifierAdjustment)paramObject).methodAdjustments))))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return ((getClass().hashCode() * 31 + this.typeAdjustments.hashCode()) * 31 + this.fieldAdjustments.hashCode()) * 31 + this.methodAdjustments.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class Adjustment<T>
/*     */     implements ElementMatcher<T>
/*     */   {
/*     */     private final ElementMatcher<? super T> matcher;
/*     */ 
/*     */ 
/*     */     
/*     */     private final ModifierContributor.Resolver<?> resolver;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Adjustment(ElementMatcher<? super T> param1ElementMatcher, ModifierContributor.Resolver<?> param1Resolver) {
/* 369 */       this.matcher = param1ElementMatcher;
/* 370 */       this.resolver = param1Resolver;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean matches(@MaybeNull T param1T) {
/* 377 */       return this.matcher.matches(param1T);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected int resolve(int param1Int) {
/* 387 */       return this.resolver.resolve(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.matcher.equals(((Adjustment)param1Object).matcher) ? false : (!!this.resolver.equals(((Adjustment)param1Object).resolver)))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.resolver.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class ModifierAdjustingClassVisitor
/*     */     extends ClassVisitor
/*     */   {
/*     */     private final List<ModifierAdjustment.Adjustment<TypeDescription>> typeAdjustments;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<ModifierAdjustment.Adjustment<FieldDescription.InDefinedShape>> fieldAdjustments;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<ModifierAdjustment.Adjustment<MethodDescription>> methodAdjustments;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Map<String, FieldDescription.InDefinedShape> fields;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Map<String, MethodDescription> methods;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ModifierAdjustingClassVisitor(ClassVisitor param1ClassVisitor, List<ModifierAdjustment.Adjustment<TypeDescription>> param1List, List<ModifierAdjustment.Adjustment<FieldDescription.InDefinedShape>> param1List1, List<ModifierAdjustment.Adjustment<MethodDescription>> param1List2, TypeDescription param1TypeDescription, Map<String, FieldDescription.InDefinedShape> param1Map, Map<String, MethodDescription> param1Map1) {
/* 444 */       super(OpenedClassReader.ASM_API, param1ClassVisitor);
/* 445 */       this.typeAdjustments = param1List;
/* 446 */       this.fieldAdjustments = param1List1;
/* 447 */       this.methodAdjustments = param1List2;
/* 448 */       this.instrumentedType = param1TypeDescription;
/* 449 */       this.fields = param1Map;
/* 450 */       this.methods = param1Map1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void visit(int param1Int1, int param1Int2, String param1String1, @MaybeNull String param1String2, @MaybeNull String param1String3, @MaybeNull String[] param1ArrayOfString) {
/* 455 */       for (Iterator<ModifierAdjustment.Adjustment<TypeDescription>> iterator = this.typeAdjustments.iterator(); iterator.hasNext();) {
/* 456 */         if ((adjustment = iterator.next()).matches(this.instrumentedType)) {
/* 457 */           param1Int2 = adjustment.resolve(param1Int2);
/*     */           break;
/*     */         } 
/*     */       } 
/* 461 */       super.visit(param1Int1, param1Int2, param1String1, param1String2, param1String3, param1ArrayOfString);
/*     */     }
/*     */ 
/*     */     
/*     */     public void visitInnerClass(String param1String1, @MaybeNull String param1String2, @MaybeNull String param1String3, int param1Int) {
/* 466 */       if (this.instrumentedType.getInternalName().equals(param1String1)) {
/* 467 */         for (Iterator<ModifierAdjustment.Adjustment<TypeDescription>> iterator = this.typeAdjustments.iterator(); iterator.hasNext();) {
/* 468 */           if ((adjustment = iterator.next()).matches(this.instrumentedType)) {
/* 469 */             param1Int = adjustment.resolve(param1Int);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 474 */       super.visitInnerClass(param1String1, param1String2, param1String3, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public FieldVisitor visitField(int param1Int, String param1String1, String param1String2, @MaybeNull String param1String3, @MaybeNull Object param1Object) {
/*     */       FieldDescription.InDefinedShape inDefinedShape;
/* 481 */       if ((inDefinedShape = this.fields.get(param1String1 + param1String2)) != null) {
/* 482 */         for (Iterator<ModifierAdjustment.Adjustment<FieldDescription.InDefinedShape>> iterator = this.fieldAdjustments.iterator(); iterator.hasNext();) {
/* 483 */           if ((adjustment = iterator.next()).matches(inDefinedShape)) {
/* 484 */             param1Int = adjustment.resolve(param1Int);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 489 */       return super.visitField(param1Int, param1String1, param1String2, param1String3, param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public MethodVisitor visitMethod(int param1Int, String param1String1, String param1String2, @MaybeNull String param1String3, @MaybeNull String[] param1ArrayOfString) {
/*     */       MethodDescription methodDescription;
/* 496 */       if ((methodDescription = this.methods.get(param1String1 + param1String2)) != null) {
/* 497 */         for (Iterator<ModifierAdjustment.Adjustment<MethodDescription>> iterator = this.methodAdjustments.iterator(); iterator.hasNext();) {
/* 498 */           if ((adjustment = iterator.next()).matches(methodDescription)) {
/* 499 */             param1Int = adjustment.resolve(param1Int);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 504 */       return super.visitMethod(param1Int, param1String1, param1String2, param1String3, param1ArrayOfString);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\ModifierAdjustment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */