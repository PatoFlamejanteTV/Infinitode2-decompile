/*     */ package net.bytebuddy.asm;
/*     */ 
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface AsmVisitorWrapper
/*     */ {
/*     */   public static final int NO_FLAGS = 0;
/*     */   
/*     */   int mergeWriter(int paramInt);
/*     */   
/*     */   int mergeReader(int paramInt);
/*     */   
/*     */   ClassVisitor wrap(TypeDescription paramTypeDescription, ClassVisitor paramClassVisitor, Implementation.Context paramContext, TypePool paramTypePool, FieldList<FieldDescription.InDefinedShape> paramFieldList, MethodList<?> paramMethodList, int paramInt1, int paramInt2);
/*     */   
/*     */   public enum NoOp
/*     */     implements AsmVisitorWrapper
/*     */   {
/* 102 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int mergeWriter(int param1Int) {
/* 108 */       return param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int mergeReader(int param1Int) {
/* 115 */       return param1Int;
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
/*     */     public final ClassVisitor wrap(TypeDescription param1TypeDescription, ClassVisitor param1ClassVisitor, Implementation.Context param1Context, TypePool param1TypePool, FieldList<FieldDescription.InDefinedShape> param1FieldList, MethodList<?> param1MethodList, int param1Int1, int param1Int2) {
/* 129 */       return param1ClassVisitor;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     implements AsmVisitorWrapper
/*     */   {
/*     */     public int mergeWriter(int param1Int) {
/* 142 */       return param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int mergeReader(int param1Int) {
/* 149 */       return param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForDeclaredFields
/*     */     extends AbstractBase
/*     */   {
/*     */     private final List<Entry> entries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDeclaredFields() {
/* 168 */       this(Collections.emptyList());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForDeclaredFields(List<Entry> param1List) {
/* 177 */       this.entries = param1List;
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
/*     */     public ForDeclaredFields field(ElementMatcher<? super FieldDescription.InDefinedShape> param1ElementMatcher, FieldVisitorWrapper... param1VarArgs) {
/* 189 */       return field(param1ElementMatcher, Arrays.asList(param1VarArgs));
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
/*     */     public ForDeclaredFields field(ElementMatcher<? super FieldDescription.InDefinedShape> param1ElementMatcher, List<? extends FieldVisitorWrapper> param1List) {
/* 201 */       return new ForDeclaredFields(CompoundList.of(this.entries, new Entry(param1ElementMatcher, param1List)));
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
/*     */     public ClassVisitor wrap(TypeDescription param1TypeDescription, ClassVisitor param1ClassVisitor, Implementation.Context param1Context, TypePool param1TypePool, FieldList<FieldDescription.InDefinedShape> param1FieldList, MethodList<?> param1MethodList, int param1Int1, int param1Int2) {
/* 215 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 216 */       for (FieldDescription.InDefinedShape inDefinedShape : param1FieldList) {
/* 217 */         hashMap.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
/*     */       }
/* 219 */       return new DispatchingVisitor(this, param1ClassVisitor, param1TypeDescription, (Map)hashMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.entries.equals(((ForDeclaredFields)param1Object).entries))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.entries.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static interface FieldVisitorWrapper
/*     */     {
/*     */       FieldVisitor wrap(TypeDescription param2TypeDescription, FieldDescription.InDefinedShape param2InDefinedShape, FieldVisitor param2FieldVisitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class Entry
/*     */       implements FieldVisitorWrapper, ElementMatcher<FieldDescription.InDefinedShape>
/*     */     {
/*     */       private final ElementMatcher<? super FieldDescription.InDefinedShape> matcher;
/*     */ 
/*     */ 
/*     */       
/*     */       private final List<? extends AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper> fieldVisitorWrappers;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Entry(ElementMatcher<? super FieldDescription.InDefinedShape> param2ElementMatcher, List<? extends AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper> param2List) {
/* 261 */         this.matcher = param2ElementMatcher;
/* 262 */         this.fieldVisitorWrappers = param2List;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean matches(@MaybeNull FieldDescription.InDefinedShape param2InDefinedShape) {
/* 269 */         return this.matcher.matches(param2InDefinedShape);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public FieldVisitor wrap(TypeDescription param2TypeDescription, FieldDescription.InDefinedShape param2InDefinedShape, FieldVisitor param2FieldVisitor) {
/* 276 */         for (Iterator<? extends AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper> iterator = this.fieldVisitorWrappers.iterator(); iterator.hasNext();) {
/* 277 */           param2FieldVisitor = (fieldVisitorWrapper = iterator.next()).wrap(param2TypeDescription, param2InDefinedShape, param2FieldVisitor);
/*     */         }
/* 279 */         return param2FieldVisitor;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.matcher.equals(((Entry)param2Object).matcher) ? false : (!!this.fieldVisitorWrappers.equals(((Entry)param2Object).fieldVisitorWrappers)))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.fieldVisitorWrappers.hashCode();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected class DispatchingVisitor
/*     */       extends ClassVisitor
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */       
/*     */       private final Map<String, FieldDescription.InDefinedShape> fields;
/*     */ 
/*     */       
/*     */       protected DispatchingVisitor(AsmVisitorWrapper.ForDeclaredFields this$0, ClassVisitor param2ClassVisitor, TypeDescription param2TypeDescription, Map<String, FieldDescription.InDefinedShape> param2Map) {
/* 306 */         super(OpenedClassReader.ASM_API, param2ClassVisitor);
/* 307 */         this.instrumentedType = param2TypeDescription;
/* 308 */         this.fields = param2Map;
/*     */       }
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public FieldVisitor visitField(int param2Int, String param2String1, String param2String2, @MaybeNull String param2String3, @MaybeNull Object param2Object) {
/* 314 */         FieldVisitor fieldVisitor = super.visitField(param2Int, param2String1, param2String2, param2String3, param2Object);
/* 315 */         FieldDescription.InDefinedShape inDefinedShape = this.fields.get(param2String1 + param2String2);
/* 316 */         if (fieldVisitor != null && inDefinedShape != null) {
/* 317 */           for (Iterator<AsmVisitorWrapper.ForDeclaredFields.Entry> iterator = AsmVisitorWrapper.ForDeclaredFields.a(this.a).iterator(); iterator.hasNext();) {
/* 318 */             if ((entry = iterator.next()).matches(inDefinedShape)) {
/* 319 */               fieldVisitor = entry.wrap(this.instrumentedType, inDefinedShape, fieldVisitor);
/*     */             }
/*     */           } 
/*     */         }
/* 323 */         return fieldVisitor;
/*     */       }
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
/*     */   public static class ForDeclaredMethods
/*     */     implements AsmVisitorWrapper
/*     */   {
/*     */     private final List<Entry> entries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int writerFlags;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int readerFlags;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDeclaredMethods() {
/* 358 */       this(Collections.emptyList(), 0, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForDeclaredMethods(List<Entry> param1List, int param1Int1, int param1Int2) {
/* 369 */       this.entries = param1List;
/* 370 */       this.writerFlags = param1Int1;
/* 371 */       this.readerFlags = param1Int2;
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
/*     */     public ForDeclaredMethods method(ElementMatcher<? super MethodDescription> param1ElementMatcher, MethodVisitorWrapper... param1VarArgs) {
/* 383 */       return method(param1ElementMatcher, Arrays.asList(param1VarArgs));
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
/*     */     public ForDeclaredMethods method(ElementMatcher<? super MethodDescription> param1ElementMatcher, List<? extends MethodVisitorWrapper> param1List) {
/* 395 */       return invokable((ElementMatcher<? super MethodDescription>)ElementMatchers.isMethod().and(param1ElementMatcher), param1List);
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
/*     */     public ForDeclaredMethods constructor(ElementMatcher<? super MethodDescription> param1ElementMatcher, MethodVisitorWrapper... param1VarArgs) {
/* 407 */       return constructor(param1ElementMatcher, Arrays.asList(param1VarArgs));
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
/*     */     public ForDeclaredMethods constructor(ElementMatcher<? super MethodDescription> param1ElementMatcher, List<? extends MethodVisitorWrapper> param1List) {
/* 419 */       return invokable((ElementMatcher<? super MethodDescription>)ElementMatchers.isConstructor().and(param1ElementMatcher), param1List);
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
/*     */     public ForDeclaredMethods invokable(ElementMatcher<? super MethodDescription> param1ElementMatcher, MethodVisitorWrapper... param1VarArgs) {
/* 431 */       return invokable(param1ElementMatcher, Arrays.asList(param1VarArgs));
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
/*     */     public ForDeclaredMethods invokable(ElementMatcher<? super MethodDescription> param1ElementMatcher, List<? extends MethodVisitorWrapper> param1List) {
/* 443 */       return new ForDeclaredMethods(CompoundList.of(this.entries, new Entry(param1ElementMatcher, param1List)), this.writerFlags, this.readerFlags);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDeclaredMethods writerFlags(int param1Int) {
/* 453 */       return new ForDeclaredMethods(this.entries, this.writerFlags | param1Int, this.readerFlags);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDeclaredMethods readerFlags(int param1Int) {
/* 463 */       return new ForDeclaredMethods(this.entries, this.writerFlags, this.readerFlags | param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int mergeWriter(int param1Int) {
/* 470 */       return param1Int | this.writerFlags;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int mergeReader(int param1Int) {
/* 477 */       return param1Int | this.readerFlags;
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
/*     */     public ClassVisitor wrap(TypeDescription param1TypeDescription, ClassVisitor param1ClassVisitor, Implementation.Context param1Context, TypePool param1TypePool, FieldList<FieldDescription.InDefinedShape> param1FieldList, MethodList<?> param1MethodList, int param1Int1, int param1Int2) {
/* 491 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 492 */       for (MethodDescription methodDescription : CompoundList.of((List)param1MethodList, new MethodDescription.Latent.TypeInitializer(param1TypeDescription))) {
/* 493 */         hashMap.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
/*     */       }
/* 495 */       return new DispatchingVisitor(this, param1ClassVisitor, param1TypeDescription, param1Context, param1TypePool, (Map)hashMap, param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.writerFlags != ((ForDeclaredMethods)param1Object).writerFlags) ? false : ((this.readerFlags != ((ForDeclaredMethods)param1Object).readerFlags) ? false : (!!this.entries.equals(((ForDeclaredMethods)param1Object).entries))))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return ((getClass().hashCode() * 31 + this.entries.hashCode()) * 31 + this.writerFlags) * 31 + this.readerFlags;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static interface MethodVisitorWrapper
/*     */     {
/*     */       MethodVisitor wrap(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, MethodVisitor param2MethodVisitor, Implementation.Context param2Context, TypePool param2TypePool, int param2Int1, int param2Int2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class Entry
/*     */       implements MethodVisitorWrapper, ElementMatcher<MethodDescription>
/*     */     {
/*     */       private final ElementMatcher<? super MethodDescription> matcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final List<? extends AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper> methodVisitorWrappers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Entry(ElementMatcher<? super MethodDescription> param2ElementMatcher, List<? extends AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper> param2List) {
/* 553 */         this.matcher = param2ElementMatcher;
/* 554 */         this.methodVisitorWrappers = param2List;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean matches(@MaybeNull MethodDescription param2MethodDescription) {
/* 561 */         return this.matcher.matches(param2MethodDescription);
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
/*     */       
/*     */       public MethodVisitor wrap(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, MethodVisitor param2MethodVisitor, Implementation.Context param2Context, TypePool param2TypePool, int param2Int1, int param2Int2) {
/* 574 */         for (Iterator<? extends AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper> iterator = this.methodVisitorWrappers.iterator(); iterator.hasNext();) {
/* 575 */           param2MethodVisitor = (methodVisitorWrapper = iterator.next()).wrap(param2TypeDescription, param2MethodDescription, param2MethodVisitor, param2Context, param2TypePool, param2Int1, param2Int2);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 583 */         return param2MethodVisitor;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.matcher.equals(((Entry)param2Object).matcher) ? false : (!!this.methodVisitorWrappers.equals(((Entry)param2Object).methodVisitorWrappers)))));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.methodVisitorWrappers.hashCode();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected class DispatchingVisitor
/*     */       extends ClassVisitor
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final Implementation.Context implementationContext;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final TypePool typePool;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final int writerFlags;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final int readerFlags;
/*     */ 
/*     */ 
/*     */       
/*     */       private final Map<String, MethodDescription> methods;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected DispatchingVisitor(AsmVisitorWrapper.ForDeclaredMethods this$0, ClassVisitor param2ClassVisitor, TypeDescription param2TypeDescription, Implementation.Context param2Context, TypePool param2TypePool, Map<String, MethodDescription> param2Map, int param2Int1, int param2Int2) {
/* 640 */         super(OpenedClassReader.ASM_API, param2ClassVisitor);
/* 641 */         this.instrumentedType = param2TypeDescription;
/* 642 */         this.implementationContext = param2Context;
/* 643 */         this.typePool = param2TypePool;
/* 644 */         this.methods = param2Map;
/* 645 */         this.writerFlags = param2Int1;
/* 646 */         this.readerFlags = param2Int2;
/*     */       }
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public MethodVisitor visitMethod(int param2Int, String param2String1, String param2String2, @MaybeNull String param2String3, @MaybeNull String[] param2ArrayOfString) {
/* 652 */         MethodVisitor methodVisitor = super.visitMethod(param2Int, param2String1, param2String2, param2String3, param2ArrayOfString);
/* 653 */         MethodDescription methodDescription = this.methods.get(param2String1 + param2String2);
/* 654 */         if (methodVisitor != null && methodDescription != null) {
/* 655 */           for (Iterator<AsmVisitorWrapper.ForDeclaredMethods.Entry> iterator = AsmVisitorWrapper.ForDeclaredMethods.a(this.a).iterator(); iterator.hasNext();) {
/* 656 */             if ((entry = iterator.next()).matches(methodDescription)) {
/* 657 */               methodVisitor = entry.wrap(this.instrumentedType, methodDescription, methodVisitor, this.implementationContext, this.typePool, this.writerFlags, this.readerFlags);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 667 */         return methodVisitor;
/*     */       }
/*     */     }
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
/*     */   @Enhance
/*     */   public static class Compound
/*     */     implements AsmVisitorWrapper
/*     */   {
/*     */     public Compound(AsmVisitorWrapper... param1VarArgs) {
/* 692 */       this(Arrays.asList(param1VarArgs));
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
/* 704 */     private final List<AsmVisitorWrapper> asmVisitorWrappers = new ArrayList<AsmVisitorWrapper>(); public Compound(List<? extends AsmVisitorWrapper> param1List) {
/* 705 */       for (Iterator<? extends AsmVisitorWrapper> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 706 */         AsmVisitorWrapper asmVisitorWrapper; if (asmVisitorWrapper = iterator.next() instanceof Compound) {
/* 707 */           this.asmVisitorWrappers.addAll(((Compound)asmVisitorWrapper).asmVisitorWrappers); continue;
/* 708 */         }  if (!(asmVisitorWrapper instanceof AsmVisitorWrapper.NoOp)) {
/* 709 */           this.asmVisitorWrappers.add(asmVisitorWrapper);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int mergeWriter(int param1Int) {
/* 718 */       for (Iterator<AsmVisitorWrapper> iterator = this.asmVisitorWrappers.iterator(); iterator.hasNext();) {
/* 719 */         param1Int = (asmVisitorWrapper = iterator.next()).mergeWriter(param1Int);
/*     */       }
/* 721 */       return param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int mergeReader(int param1Int) {
/* 728 */       for (Iterator<AsmVisitorWrapper> iterator = this.asmVisitorWrappers.iterator(); iterator.hasNext();) {
/* 729 */         param1Int = (asmVisitorWrapper = iterator.next()).mergeReader(param1Int);
/*     */       }
/* 731 */       return param1Int;
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
/*     */     public ClassVisitor wrap(TypeDescription param1TypeDescription, ClassVisitor param1ClassVisitor, Implementation.Context param1Context, TypePool param1TypePool, FieldList<FieldDescription.InDefinedShape> param1FieldList, MethodList<?> param1MethodList, int param1Int1, int param1Int2) {
/* 745 */       for (Iterator<AsmVisitorWrapper> iterator = this.asmVisitorWrappers.iterator(); iterator.hasNext();) {
/* 746 */         param1ClassVisitor = (asmVisitorWrapper = iterator.next()).wrap(param1TypeDescription, param1ClassVisitor, param1Context, param1TypePool, param1FieldList, param1MethodList, param1Int1, param1Int2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 755 */       return param1ClassVisitor;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.asmVisitorWrappers.equals(((Compound)param1Object).asmVisitorWrappers))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.asmVisitorWrappers.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\AsmVisitorWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */