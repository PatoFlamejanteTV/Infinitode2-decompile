/*      */ package net.bytebuddy.asm;
/*      */ 
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Type;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import net.bytebuddy.ByteBuddy;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.modifier.FieldManifestation;
/*      */ import net.bytebuddy.description.modifier.ModifierContributor;
/*      */ import net.bytebuddy.description.modifier.Ownership;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.DynamicType;
/*      */ import net.bytebuddy.dynamic.loading.MultipleParentClassLoader;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*      */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*      */ import net.bytebuddy.implementation.ExceptionMethod;
/*      */ import net.bytebuddy.implementation.FieldAccessor;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.MethodCall;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.Duplication;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*      */ import net.bytebuddy.jar.asm.Attribute;
/*      */ import net.bytebuddy.jar.asm.ClassVisitor;
/*      */ import net.bytebuddy.jar.asm.ConstantDynamic;
/*      */ import net.bytebuddy.jar.asm.FieldVisitor;
/*      */ import net.bytebuddy.jar.asm.Handle;
/*      */ import net.bytebuddy.jar.asm.Label;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.jar.asm.ModuleVisitor;
/*      */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
/*      */ import net.bytebuddy.jar.asm.Type;
/*      */ import net.bytebuddy.jar.asm.TypePath;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.OpenedClassReader;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Enhance
/*      */ public abstract class ClassVisitorFactory<T>
/*      */ {
/*      */   private static final String DELEGATE = "delegate";
/*      */   private static final String LABELS = "labels";
/*      */   private static final String WRAP = "wrap";
/*      */   private final Class<?> type;
/*      */   private static final boolean ACCESS_CONTROLLER;
/*      */   
/*      */   protected ClassVisitorFactory(Class<?> paramClass) {
/*   95 */     this.type = paramClass;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<?> getType() {
/*  104 */     return this.type;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <S> ClassVisitorFactory<S> of(Class<S> paramClass) {
/*  115 */     return of(paramClass, (new ByteBuddy()).with(TypeValidation.DISABLED));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <S> ClassVisitorFactory<S> of(Class<S> paramClass, ByteBuddy paramByteBuddy) {
/*  127 */     return doPrivileged(new CreateClassVisitorFactory<S>(paramClass, paramByteBuddy));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/*  139 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DynamicType.Builder<?> toVisitorBuilder(ByteBuddy paramByteBuddy, Class<?> paramClass1, Class<?> paramClass2, @MaybeNull Class<?> paramClass3, @MaybeNull Class<?> paramClass4, Implementation paramImplementation) {
/*  170 */     DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition = paramByteBuddy.subclass(paramClass1, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).defineField("delegate", paramClass2, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE, (ModifierContributor.ForField)FieldManifestation.FINAL }).defineConstructor(new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { paramClass2 }).intercept(MethodCall.invoke(paramClass1.getDeclaredConstructor(new Class[] { int.class })).with(new Object[] { Integer.valueOf(OpenedClassReader.ASM_API) }).andThen(FieldAccessor.ofField("delegate").setsArgumentAt(0)).andThen(paramImplementation)).defineMethod("wrap", paramClass1, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC, (ModifierContributor.ForMethod)Ownership.STATIC }).withParameters(new Type[] { paramClass2 }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new NullCheckedConstruction(paramClass2) }));
/*  171 */     if (paramClass3 == null || paramClass4 == null) {
/*  172 */       return (DynamicType.Builder<?>)receiverTypeDefinition;
/*      */     }
/*  174 */     return (DynamicType.Builder<?>)receiverTypeDefinition
/*  175 */       .defineMethod("typePath", paramClass4, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE, (ModifierContributor.ForMethod)Ownership.STATIC
/*  176 */         }).withParameters(new Type[] { paramClass3
/*  177 */         }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new TypePathTranslator(paramClass3, paramClass4) }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DynamicType.Builder<?> toMethodVisitorBuilder(ByteBuddy paramByteBuddy, Class<?> paramClass1, Class<?> paramClass2, @MaybeNull Class<?> paramClass3, @MaybeNull Class<?> paramClass4, @MaybeNull Class<?> paramClass5, @MaybeNull Class<?> paramClass6, @MaybeNull Class<?> paramClass7, @MaybeNull Class<?> paramClass8, @MaybeNull Class<?> paramClass9, @MaybeNull Class<?> paramClass10, @MaybeNull Class<?> paramClass11, @MaybeNull Class<?> paramClass12) {
/*      */     DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition;
/*  213 */     DynamicType.Builder<?> builder = toVisitorBuilder(paramByteBuddy, paramClass1, paramClass2, paramClass3, paramClass4, 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  218 */         (Implementation)FieldAccessor.ofField("labels").setsValue((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(TypeDescription.ForLoadedType.of(HashMap.class)), (StackManipulation)Duplication.SINGLE, 
/*      */               
/*  220 */               (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(HashMap.class)
/*  221 */                 .getDeclaredMethods()
/*  222 */                 .filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(0))))
/*  223 */                 .getOnly()) }, ), Map.class));
/*  224 */     if (paramClass5 != null && paramClass6 != null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  235 */       receiverTypeDefinition = builder.defineField("labels", Map.class, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE, (ModifierContributor.ForField)FieldManifestation.FINAL }).defineMethod("label", paramClass6, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE }).withParameters(new Type[] { paramClass5 }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new LabelTranslator(paramClass6) })).defineMethod("labels", (TypeDefinition)TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(paramClass6)), new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE }).withParameters(new TypeDefinition[] { (TypeDefinition)TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(paramClass5)) }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new LabelArrayTranslator(paramClass5, paramClass6) })).defineMethod("frames", Object[].class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE }).withParameters(new Type[] { Object[].class }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new FrameTranslator(paramClass5, paramClass6) }));
/*      */     }
/*  237 */     if (paramClass9 != null && paramClass10 != null)
/*      */     {
/*      */ 
/*      */       
/*  241 */       receiverTypeDefinition = receiverTypeDefinition.defineMethod("handle", paramClass10, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE, (ModifierContributor.ForMethod)Ownership.STATIC }).withParameters(new Type[] { paramClass9 }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new HandleTranslator(paramClass9, paramClass10) }));
/*      */     }
/*  243 */     if (paramClass11 != null && paramClass12 != null && paramClass9 != null && paramClass10 != null)
/*      */     {
/*      */ 
/*      */       
/*  247 */       receiverTypeDefinition = receiverTypeDefinition.defineMethod("constantDyanmic", paramClass12, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE, (ModifierContributor.ForMethod)Ownership.STATIC }).withParameters(new Type[] { paramClass11 }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new ConstantDynamicTranslator(paramClass11, paramClass12, paramClass9, paramClass10) }));
/*      */     }
/*  249 */     return (DynamicType.Builder<?>)receiverTypeDefinition
/*  250 */       .defineMethod("constant", Object.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE, (ModifierContributor.ForMethod)Ownership.STATIC
/*  251 */         }).withParameters(new Type[] { Object.class
/*  252 */         }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new ConstantTranslator(paramClass9, paramClass10, paramClass7, paramClass8, paramClass11, paramClass12)
/*  253 */           })).defineMethod("constants", Object[].class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE, (ModifierContributor.ForMethod)Ownership.STATIC
/*  254 */         }).withParameters(new Type[] { Object[].class
/*  255 */         }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new ConstantArrayTranslator() }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static MethodCall.ArgumentLoader.Factory toConvertedParameter(TypeDescription paramTypeDescription, Class<?> paramClass, String paramString, int paramInt, boolean paramBoolean) {
/*  269 */     return (MethodCall.ArgumentLoader.Factory)new MethodCall.ArgumentLoader.ForStackManipulation((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { paramBoolean ? MethodVariableAccess.loadThis() : (StackManipulation)StackManipulation.Trivial.INSTANCE, MethodVariableAccess.REFERENCE
/*  270 */             .loadFrom(paramInt), 
/*  271 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)paramTypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named(paramString))).getOnly()) }, ), paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DynamicType toAttributeWrapper(DynamicType.Builder<?> paramBuilder, Class<?> paramClass1, Class<?> paramClass2, TypeDescription paramTypeDescription1, TypeDescription paramTypeDescription2) {
/*  286 */     return (DynamicType)paramBuilder
/*  287 */       .defineField("delegate", paramClass2, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PUBLIC, (ModifierContributor.ForField)FieldManifestation.FINAL
/*  288 */         }).defineConstructor(new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC
/*  289 */         }).withParameters(new Type[] { paramClass2
/*  290 */         }).intercept((Implementation)MethodCall.invoke(paramClass1.getDeclaredConstructor(new Class[] { String.class
/*  291 */             })).onSuper()
/*  292 */         .with((StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/*  293 */               MethodVariableAccess.REFERENCE.loadFrom(1), 
/*  294 */               FieldAccess.forField((FieldDescription.InDefinedShape)new FieldDescription.ForLoadedField(paramClass2.getField("type"))).read() }, ), String.class)
/*  295 */         .andThen(FieldAccessor.ofField("delegate").setsArgumentAt(0)))
/*  296 */       .defineMethod("attribute", paramClass1, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC, (ModifierContributor.ForMethod)Ownership.STATIC
/*  297 */         }).withParameters(new Type[] { paramClass2
/*  298 */         }).intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { new AttributeTranslator(paramClass1, paramClass2, paramTypeDescription1, paramTypeDescription2)
/*  299 */           })).method((ElementMatcher)ElementMatchers.isProtected())
/*  300 */       .intercept(ExceptionMethod.throwing(UnsupportedOperationException.class))
/*  301 */       .method((ElementMatcher)ElementMatchers.named("isUnknown"))
/*  302 */       .intercept((Implementation)MethodCall.invoke(paramClass2.getMethod("isUnknown", new Class[0])).onField("delegate"))
/*  303 */       .method((ElementMatcher)ElementMatchers.named("isCodeAttribute"))
/*  304 */       .intercept((Implementation)MethodCall.invoke(paramClass2.getMethod("isCodeAttribute", new Class[0])).onField("delegate"))
/*  305 */       .make();
/*      */   }
/*      */   
/*      */   public abstract T wrap(ClassVisitor paramClassVisitor);
/*      */   
/*      */   public abstract ClassVisitor unwrap(T paramT);
/*      */   
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.type.equals(((ClassVisitorFactory)paramObject).type))));
/*      */   }
/*      */   
/*      */   public int hashCode() {
/*      */     return getClass().hashCode() * 31 + this.type.hashCode();
/*      */   }
/*      */   
/*      */   static {
/*      */     try {
/*      */       Class.forName("java.security.AccessController", false, (ClassLoader)null);
/*      */       ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
/*      */       return;
/*      */     } catch (ClassNotFoundException classNotFoundException) {
/*      */       ACCESS_CONTROLLER = false;
/*      */       return;
/*      */     } catch (SecurityException securityException) {
/*      */       ACCESS_CONTROLLER = true;
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   protected static class NullCheckedConstruction
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     private final Class<?> type;
/*      */     
/*      */     protected NullCheckedConstruction(Class<?> param1Class) {
/*  341 */       this.type = param1Class;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  350 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  351 */       Label label = new Label();
/*  352 */       param1MethodVisitor.visitJumpInsn(198, label);
/*  353 */       param1MethodVisitor.visitTypeInsn(187, param1Context.getInstrumentedType().getInternalName());
/*  354 */       param1MethodVisitor.visitInsn(89);
/*  355 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  356 */       param1MethodVisitor.visitMethodInsn(183, param1Context
/*  357 */           .getInstrumentedType().getInternalName(), "<init>", 
/*      */           
/*  359 */           Type.getMethodDescriptor(Type.VOID_TYPE, new Type[] { Type.getType(this.type) }), false);
/*      */       
/*  361 */       param1MethodVisitor.visitInsn(176);
/*  362 */       param1MethodVisitor.visitLabel(label);
/*  363 */       param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/*  364 */       param1MethodVisitor.visitInsn(1);
/*  365 */       param1MethodVisitor.visitInsn(176);
/*  366 */       return new ByteCodeAppender.Size(3, 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.type.equals(((NullCheckedConstruction)param1Object).type))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.type.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class LabelTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "label";
/*      */     
/*      */     private final Class<?> target;
/*      */ 
/*      */     
/*      */     protected LabelTranslator(Class<?> param1Class) {
/*  392 */       this.target = param1Class;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  399 */       Label label1 = new Label(), label2 = new Label();
/*  400 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  401 */       param1MethodVisitor.visitJumpInsn(199, label1);
/*  402 */       param1MethodVisitor.visitInsn(1);
/*  403 */       param1MethodVisitor.visitInsn(176);
/*  404 */       param1MethodVisitor.visitLabel(label1);
/*  405 */       param1Context.getFrameGeneration().same(param1MethodVisitor, CompoundList.of(param1Context
/*  406 */             .getInstrumentedType(), (List)param1MethodDescription
/*  407 */             .getParameters().asTypeList()));
/*  408 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  409 */       param1MethodVisitor.visitFieldInsn(180, param1Context
/*  410 */           .getInstrumentedType().getInternalName(), "labels", 
/*      */           
/*  412 */           Type.getDescriptor(Map.class));
/*  413 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  414 */       param1MethodVisitor.visitMethodInsn(185, Type.getInternalName(Map.class), "get", 
/*      */           
/*  416 */           Type.getMethodDescriptor(Type.getType(Object.class), new Type[] { Type.getType(Object.class) }), true);
/*      */       
/*  418 */       param1MethodVisitor.visitTypeInsn(192, Type.getInternalName(this.target));
/*  419 */       param1MethodVisitor.visitVarInsn(58, 2);
/*  420 */       param1MethodVisitor.visitVarInsn(25, 2);
/*  421 */       param1MethodVisitor.visitJumpInsn(199, label2);
/*  422 */       param1MethodVisitor.visitTypeInsn(187, Type.getInternalName(this.target));
/*  423 */       param1MethodVisitor.visitInsn(89);
/*  424 */       param1MethodVisitor.visitMethodInsn(183, 
/*  425 */           Type.getInternalName(this.target), "<init>", "()V", false);
/*      */ 
/*      */ 
/*      */       
/*  429 */       param1MethodVisitor.visitVarInsn(58, 2);
/*  430 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  431 */       param1MethodVisitor.visitFieldInsn(180, param1Context
/*  432 */           .getInstrumentedType().getInternalName(), "labels", 
/*      */           
/*  434 */           Type.getDescriptor(Map.class));
/*  435 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  436 */       param1MethodVisitor.visitVarInsn(25, 2);
/*  437 */       param1MethodVisitor.visitMethodInsn(185, 
/*  438 */           Type.getInternalName(Map.class), "put", 
/*      */           
/*  440 */           Type.getMethodDescriptor(Type.getType(Object.class), new Type[] { Type.getType(Object.class), Type.getType(Object.class) }), true);
/*      */       
/*  442 */       param1MethodVisitor.visitInsn(87);
/*  443 */       param1MethodVisitor.visitLabel(label2);
/*  444 */       param1Context.getFrameGeneration().append(param1MethodVisitor, 
/*  445 */           Collections.singletonList(TypeDescription.ForLoadedType.of(this.target)), 
/*  446 */           CompoundList.of(param1Context.getInstrumentedType(), (List)param1MethodDescription.getParameters().asTypeList()));
/*  447 */       param1MethodVisitor.visitVarInsn(25, 2);
/*  448 */       param1MethodVisitor.visitInsn(176);
/*  449 */       return new ByteCodeAppender.Size(3, 3);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.target.equals(((LabelTranslator)param1Object).target))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.target.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class LabelArrayTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "labels";
/*      */ 
/*      */     
/*      */     private final Class<?> sourceLabel;
/*      */ 
/*      */     
/*      */     private final Class<?> targetLabel;
/*      */ 
/*      */     
/*      */     protected LabelArrayTranslator(Class<?> param1Class1, Class<?> param1Class2) {
/*  481 */       this.sourceLabel = param1Class1;
/*  482 */       this.targetLabel = param1Class2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  489 */       Label label1 = new Label(), label2 = new Label(), label3 = new Label();
/*  490 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  491 */       param1MethodVisitor.visitJumpInsn(199, label1);
/*  492 */       param1MethodVisitor.visitInsn(1);
/*  493 */       param1MethodVisitor.visitInsn(176);
/*  494 */       param1MethodVisitor.visitLabel(label1);
/*  495 */       param1Context.getFrameGeneration().same(param1MethodVisitor, CompoundList.of(param1Context
/*  496 */             .getInstrumentedType(), (List)param1MethodDescription
/*  497 */             .getParameters().asTypeList()));
/*  498 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  499 */       param1MethodVisitor.visitInsn(190);
/*  500 */       param1MethodVisitor.visitTypeInsn(189, Type.getInternalName(this.targetLabel));
/*  501 */       param1MethodVisitor.visitVarInsn(58, 2);
/*  502 */       param1MethodVisitor.visitInsn(3);
/*  503 */       param1MethodVisitor.visitVarInsn(54, 3);
/*  504 */       param1MethodVisitor.visitLabel(label2);
/*  505 */       param1Context.getFrameGeneration().append(param1MethodVisitor, 
/*  506 */           Arrays.asList(new TypeDescription[] { TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(this.targetLabel)), TypeDescription.ForLoadedType.of(int.class)
/*  507 */             }, ), CompoundList.of(param1Context.getInstrumentedType(), (List)param1MethodDescription.getParameters().asTypeList()));
/*  508 */       param1MethodVisitor.visitVarInsn(21, 3);
/*  509 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  510 */       param1MethodVisitor.visitInsn(190);
/*  511 */       param1MethodVisitor.visitJumpInsn(162, label3);
/*  512 */       param1MethodVisitor.visitVarInsn(25, 2);
/*  513 */       param1MethodVisitor.visitVarInsn(21, 3);
/*  514 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  515 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  516 */       param1MethodVisitor.visitVarInsn(21, 3);
/*  517 */       param1MethodVisitor.visitInsn(50);
/*  518 */       param1MethodVisitor.visitMethodInsn(183, param1Context
/*  519 */           .getInstrumentedType().getInternalName(), "label", 
/*      */           
/*  521 */           Type.getMethodDescriptor(Type.getType(this.targetLabel), new Type[] { Type.getType(this.sourceLabel) }), false);
/*      */       
/*  523 */       param1MethodVisitor.visitInsn(83);
/*  524 */       param1MethodVisitor.visitIincInsn(3, 1);
/*  525 */       param1MethodVisitor.visitJumpInsn(167, label2);
/*  526 */       param1MethodVisitor.visitLabel(label3);
/*  527 */       param1Context.getFrameGeneration().chop(param1MethodVisitor, 1, CompoundList.of(
/*  528 */             Collections.singletonList(param1Context.getInstrumentedType()), (List)param1MethodDescription
/*  529 */             .getParameters().asTypeList(), 
/*  530 */             Collections.singletonList(TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(this.targetLabel)))));
/*  531 */       param1MethodVisitor.visitVarInsn(25, 2);
/*  532 */       param1MethodVisitor.visitInsn(176);
/*  533 */       return new ByteCodeAppender.Size(5, 4);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.sourceLabel.equals(((LabelArrayTranslator)param1Object).sourceLabel) ? false : (!!this.targetLabel.equals(((LabelArrayTranslator)param1Object).targetLabel)))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.sourceLabel.hashCode()) * 31 + this.targetLabel.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class HandleTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "handle";
/*      */ 
/*      */     
/*      */     private final Class<?> sourceHandle;
/*      */ 
/*      */     
/*      */     private final Class<?> targetHandle;
/*      */ 
/*      */     
/*      */     protected HandleTranslator(Class<?> param1Class1, Class<?> param1Class2) {
/*  565 */       this.sourceHandle = param1Class1;
/*  566 */       this.targetHandle = param1Class2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  573 */       Label label = new Label();
/*  574 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  575 */       param1MethodVisitor.visitJumpInsn(199, label);
/*  576 */       param1MethodVisitor.visitInsn(1);
/*  577 */       param1MethodVisitor.visitInsn(176);
/*  578 */       param1MethodVisitor.visitLabel(label);
/*  579 */       param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/*  580 */       param1MethodVisitor.visitTypeInsn(187, Type.getInternalName(this.targetHandle));
/*  581 */       param1MethodVisitor.visitInsn(89);
/*  582 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  583 */       param1MethodVisitor.visitMethodInsn(182, 
/*  584 */           Type.getInternalName(this.sourceHandle), "getTag", 
/*      */           
/*  586 */           Type.getMethodDescriptor(Type.INT_TYPE, new Type[0]), false);
/*      */       
/*  588 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  589 */       param1MethodVisitor.visitMethodInsn(182, 
/*  590 */           Type.getInternalName(this.sourceHandle), "getOwner", 
/*      */           
/*  592 */           Type.getMethodDescriptor(Type.getType(String.class), new Type[0]), false);
/*      */       
/*  594 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  595 */       param1MethodVisitor.visitMethodInsn(182, 
/*  596 */           Type.getInternalName(this.sourceHandle), "getName", 
/*      */           
/*  598 */           Type.getMethodDescriptor(Type.getType(String.class), new Type[0]), false);
/*      */       
/*  600 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  601 */       param1MethodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceHandle), "getDesc", 
/*      */           
/*  603 */           Type.getMethodDescriptor(Type.getType(String.class), new Type[0]), false);
/*      */       
/*  605 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  606 */       param1MethodVisitor.visitMethodInsn(182, 
/*  607 */           Type.getInternalName(this.sourceHandle), "isInterface", 
/*      */           
/*  609 */           Type.getMethodDescriptor(Type.BOOLEAN_TYPE, new Type[0]), false);
/*      */       
/*  611 */       param1MethodVisitor.visitMethodInsn(183, 
/*  612 */           Type.getInternalName(this.targetHandle), "<init>", 
/*      */           
/*  614 */           Type.getMethodDescriptor(Type.VOID_TYPE, new Type[] { Type.INT_TYPE, Type.getType(String.class), Type.getType(String.class), Type.getType(String.class), Type.BOOLEAN_TYPE }), false);
/*      */       
/*  616 */       param1MethodVisitor.visitInsn(176);
/*  617 */       return new ByteCodeAppender.Size(7, 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.sourceHandle.equals(((HandleTranslator)param1Object).sourceHandle) ? false : (!!this.targetHandle.equals(((HandleTranslator)param1Object).targetHandle)))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.sourceHandle.hashCode()) * 31 + this.targetHandle.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class ConstantDynamicTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "constantDyanmic";
/*      */ 
/*      */ 
/*      */     
/*      */     private final Class<?> sourceConstantDynamic;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Class<?> targetConstantDynamic;
/*      */ 
/*      */     
/*      */     private final Class<?> sourceHandle;
/*      */ 
/*      */     
/*      */     private final Class<?> targetHandle;
/*      */ 
/*      */ 
/*      */     
/*      */     protected ConstantDynamicTranslator(Class<?> param1Class1, Class<?> param1Class2, Class<?> param1Class3, Class<?> param1Class4) {
/*  661 */       this.sourceConstantDynamic = param1Class1;
/*  662 */       this.targetConstantDynamic = param1Class2;
/*  663 */       this.sourceHandle = param1Class3;
/*  664 */       this.targetHandle = param1Class4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  671 */       Label label1 = new Label(), label2 = new Label();
/*  672 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  673 */       param1MethodVisitor.visitMethodInsn(182, 
/*  674 */           Type.getInternalName(this.sourceConstantDynamic), "getBootstrapMethodArgumentCount", 
/*      */           
/*  676 */           Type.getMethodDescriptor(Type.INT_TYPE, new Type[0]), false);
/*      */       
/*  678 */       param1MethodVisitor.visitTypeInsn(189, Type.getInternalName(Object.class));
/*  679 */       param1MethodVisitor.visitVarInsn(58, 1);
/*  680 */       param1MethodVisitor.visitInsn(3);
/*  681 */       param1MethodVisitor.visitVarInsn(54, 2);
/*  682 */       param1MethodVisitor.visitLabel(label1);
/*  683 */       param1Context.getFrameGeneration().append(param1MethodVisitor, 
/*  684 */           Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(int.class) }, ), (List)param1MethodDescription
/*  685 */           .getParameters().asTypeList());
/*  686 */       param1MethodVisitor.visitVarInsn(21, 2);
/*  687 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  688 */       param1MethodVisitor.visitInsn(190);
/*  689 */       param1MethodVisitor.visitJumpInsn(162, label2);
/*  690 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  691 */       param1MethodVisitor.visitVarInsn(21, 2);
/*  692 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  693 */       param1MethodVisitor.visitVarInsn(21, 2);
/*  694 */       param1MethodVisitor.visitMethodInsn(182, 
/*  695 */           Type.getInternalName(this.sourceConstantDynamic), "getBootstrapMethodArgument", 
/*      */           
/*  697 */           Type.getMethodDescriptor(Type.getType(Object.class), new Type[] { Type.INT_TYPE }), false);
/*      */       
/*  699 */       param1MethodVisitor.visitMethodInsn(184, param1Context
/*  700 */           .getInstrumentedType().getInternalName(), "ldc", 
/*      */           
/*  702 */           Type.getMethodDescriptor(Type.getType(Object.class), new Type[] { Type.getType(Object.class) }), false);
/*      */       
/*  704 */       param1MethodVisitor.visitInsn(83);
/*  705 */       param1MethodVisitor.visitIincInsn(2, 1);
/*  706 */       param1MethodVisitor.visitJumpInsn(167, label1);
/*  707 */       param1MethodVisitor.visitLabel(label2);
/*  708 */       param1Context.getFrameGeneration().chop(param1MethodVisitor, 1, CompoundList.of((List)param1MethodDescription
/*  709 */             .getParameters().asTypeList(), 
/*  710 */             TypeDescription.ForLoadedType.of(Object[].class)));
/*  711 */       param1MethodVisitor.visitTypeInsn(187, Type.getInternalName(this.targetConstantDynamic));
/*  712 */       param1MethodVisitor.visitInsn(89);
/*  713 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  714 */       param1MethodVisitor.visitMethodInsn(182, 
/*  715 */           Type.getInternalName(this.sourceConstantDynamic), "getName", 
/*      */           
/*  717 */           Type.getMethodDescriptor(Type.getType(String.class), new Type[0]), false);
/*      */       
/*  719 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  720 */       param1MethodVisitor.visitMethodInsn(182, 
/*  721 */           Type.getInternalName(this.sourceConstantDynamic), "getDescriptor", 
/*      */           
/*  723 */           Type.getMethodDescriptor(Type.getType(String.class), new Type[0]), false);
/*      */       
/*  725 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  726 */       param1MethodVisitor.visitMethodInsn(182, 
/*  727 */           Type.getInternalName(this.sourceConstantDynamic), "getBootstrapMethod", 
/*      */           
/*  729 */           Type.getMethodDescriptor(Type.getType(this.sourceHandle), new Type[0]), false);
/*      */       
/*  731 */       param1MethodVisitor.visitMethodInsn(184, param1Context
/*  732 */           .getInstrumentedType().getInternalName(), "handle", 
/*      */           
/*  734 */           Type.getMethodDescriptor(Type.getType(this.targetHandle), new Type[] { Type.getType(this.sourceHandle) }), false);
/*      */       
/*  736 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  737 */       param1MethodVisitor.visitMethodInsn(183, 
/*  738 */           Type.getInternalName(this.targetConstantDynamic), "<init>", 
/*      */           
/*  740 */           Type.getMethodDescriptor(Type.VOID_TYPE, new Type[] { Type.getType(String.class), Type.getType(String.class), Type.getType(this.targetHandle), Type.getType(Object[].class) }), false);
/*      */       
/*  742 */       param1MethodVisitor.visitInsn(176);
/*  743 */       param1MethodVisitor.visitMaxs(6, 3);
/*  744 */       return new ByteCodeAppender.Size(6, 3);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.sourceConstantDynamic.equals(((ConstantDynamicTranslator)param1Object).sourceConstantDynamic) ? false : (!this.targetConstantDynamic.equals(((ConstantDynamicTranslator)param1Object).targetConstantDynamic) ? false : (!this.sourceHandle.equals(((ConstantDynamicTranslator)param1Object).sourceHandle) ? false : (!!this.targetHandle.equals(((ConstantDynamicTranslator)param1Object).targetHandle)))))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.sourceConstantDynamic.hashCode()) * 31 + this.targetConstantDynamic.hashCode()) * 31 + this.sourceHandle.hashCode()) * 31 + this.targetHandle.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class ConstantTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "constant";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */     private final Class<?> sourceHandle;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */     private final Class<?> targetHandle;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */     private final Class<?> sourceType;
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */     private final Class<?> targetType;
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */     private final Class<?> sourceConstantDynamic;
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */     private final Class<?> targetConstantDynamic;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ConstantTranslator(@MaybeNull Class<?> param1Class1, @MaybeNull Class<?> param1Class2, @MaybeNull Class<?> param1Class3, @MaybeNull Class<?> param1Class4, @MaybeNull Class<?> param1Class5, @MaybeNull Class<?> param1Class6) {
/*  817 */       this.sourceHandle = param1Class1;
/*  818 */       this.targetHandle = param1Class2;
/*  819 */       this.sourceType = param1Class3;
/*  820 */       this.targetType = param1Class4;
/*  821 */       this.sourceConstantDynamic = param1Class5;
/*  822 */       this.targetConstantDynamic = param1Class6;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  829 */       Label label1 = new Label(), label2 = new Label(), label3 = new Label();
/*  830 */       if (this.sourceType != null && this.targetType != null) {
/*  831 */         param1MethodVisitor.visitVarInsn(25, 0);
/*  832 */         param1MethodVisitor.visitTypeInsn(193, Type.getInternalName(this.sourceType));
/*  833 */         param1MethodVisitor.visitJumpInsn(153, label1);
/*  834 */         param1MethodVisitor.visitVarInsn(25, 0);
/*  835 */         param1MethodVisitor.visitTypeInsn(192, Type.getInternalName(this.sourceType));
/*  836 */         param1MethodVisitor.visitMethodInsn(182, 
/*  837 */             Type.getInternalName(this.sourceType), "getDescriptor", 
/*      */             
/*  839 */             Type.getMethodDescriptor(Type.getType(String.class), new Type[0]), false);
/*      */         
/*  841 */         param1MethodVisitor.visitMethodInsn(184, 
/*  842 */             Type.getInternalName(this.targetType), "getType", 
/*      */             
/*  844 */             Type.getMethodDescriptor(Type.getType(this.targetType), new Type[] { Type.getType(String.class) }), false);
/*      */         
/*  846 */         param1MethodVisitor.visitInsn(176);
/*  847 */         param1MethodVisitor.visitLabel(label1);
/*  848 */         param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/*      */       } 
/*  850 */       if (this.sourceHandle != null && this.targetHandle != null) {
/*  851 */         param1MethodVisitor.visitVarInsn(25, 0);
/*  852 */         param1MethodVisitor.visitTypeInsn(193, Type.getInternalName(this.sourceHandle));
/*  853 */         param1MethodVisitor.visitJumpInsn(153, label2);
/*  854 */         param1MethodVisitor.visitVarInsn(25, 0);
/*  855 */         param1MethodVisitor.visitTypeInsn(192, Type.getInternalName(this.sourceHandle));
/*  856 */         param1MethodVisitor.visitMethodInsn(184, param1Context
/*  857 */             .getInstrumentedType().getInternalName(), "handle", 
/*      */             
/*  859 */             Type.getMethodDescriptor(Type.getType(this.targetHandle), new Type[] { Type.getType(this.sourceHandle) }), false);
/*      */         
/*  861 */         param1MethodVisitor.visitInsn(176);
/*  862 */         param1MethodVisitor.visitLabel(label2);
/*  863 */         param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/*      */       } 
/*  865 */       if (this.sourceConstantDynamic != null && this.targetConstantDynamic != null) {
/*  866 */         param1MethodVisitor.visitVarInsn(25, 0);
/*  867 */         param1MethodVisitor.visitTypeInsn(193, Type.getInternalName(this.sourceConstantDynamic));
/*  868 */         param1MethodVisitor.visitJumpInsn(153, label3);
/*  869 */         param1MethodVisitor.visitVarInsn(25, 0);
/*  870 */         param1MethodVisitor.visitTypeInsn(192, Type.getInternalName(this.sourceConstantDynamic));
/*  871 */         param1MethodVisitor.visitMethodInsn(184, param1Context
/*  872 */             .getInstrumentedType().getInternalName(), "constantDyanmic", 
/*      */             
/*  874 */             Type.getMethodDescriptor(Type.getType(this.targetConstantDynamic), new Type[] { Type.getType(this.sourceConstantDynamic) }), false);
/*      */         
/*  876 */         param1MethodVisitor.visitInsn(176);
/*  877 */         param1MethodVisitor.visitLabel(label3);
/*  878 */         param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/*      */       } 
/*  880 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  881 */       param1MethodVisitor.visitInsn(176);
/*  882 */       return new ByteCodeAppender.Size(1, 1);
/*      */     } public boolean equals(@MaybeNull Object param1Object) { Class<?> clazz2; if (this == param1Object)
/*      */         return true;  if (param1Object == null)
/*      */         return false;  if (getClass() != param1Object.getClass())
/*      */         return false;  Class<?> clazz1 = ((ConstantTranslator)param1Object).sourceHandle; if (clazz1 != null) { if ((clazz2 = this.sourceHandle) != null) { if (!clazz2.equals(clazz1))
/*      */             return false;  } else { return false; }  } else if ((clazz2 = this.sourceHandle) != null) { return false; }  clazz1 = ((ConstantTranslator)param1Object).targetHandle; if (clazz1 != null) { if ((clazz2 = this.targetHandle) != null) { if (!clazz2.equals(clazz1))
/*      */             return false;  } else { return false; }  } else if ((clazz2 = this.targetHandle) != null) { return false; }  clazz1 = ((ConstantTranslator)param1Object).sourceType; if (clazz1 != null) { if ((clazz2 = this.sourceType) != null) { if (!clazz2.equals(clazz1))
/*      */             return false;  } else { return false; }  } else if ((clazz2 = this.sourceType) != null) { return false; }  clazz1 = ((ConstantTranslator)param1Object).targetType; if (clazz1 != null) { if ((clazz2 = this.targetType) != null) { if (!clazz2.equals(clazz1))
/*      */             return false;  } else { return false; }  } else if ((clazz2 = this.targetType) != null) { return false; }  clazz1 = ((ConstantTranslator)param1Object).sourceConstantDynamic; if (clazz1 != null) { if ((clazz2 = this.sourceConstantDynamic) != null) { if (!clazz2.equals(clazz1))
/*      */             return false;  }
/*      */         else { return false; }
/*      */          }
/*      */       else if ((clazz2 = this.sourceConstantDynamic) != null) { return false; }
/*      */        clazz1 = ((ConstantTranslator)param1Object).targetConstantDynamic; if (clazz1 != null) { if ((clazz2 = this.targetConstantDynamic) != null) { if (!clazz2.equals(clazz1))
/*      */             return false;  }
/*      */         else { return false; }
/*      */          }
/*      */       else if ((clazz2 = this.targetConstantDynamic) != null) { return false; }
/*      */        return true; } public int hashCode() { Class<?> clazz; if ((clazz = this.sourceHandle) != null); if ((clazz = this.targetHandle) != null); if ((clazz = this.sourceType) != null); if ((clazz = this.targetType) != null); if ((clazz = this.sourceConstantDynamic) != null); if ((clazz = this.targetConstantDynamic) != null); return (((((getClass().hashCode() * 31 + clazz.hashCode()) * 31 + clazz.hashCode()) * 31 + clazz.hashCode()) * 31 + clazz.hashCode()) * 31 + clazz.hashCode()) * 31 + clazz.hashCode(); }
/*  901 */   } @Enhance protected static class ConstantArrayTranslator implements ByteCodeAppender { public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) { Label label1 = new Label(), label2 = new Label(), label3 = new Label();
/*  902 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  903 */       param1MethodVisitor.visitJumpInsn(199, label1);
/*  904 */       param1MethodVisitor.visitInsn(1);
/*  905 */       param1MethodVisitor.visitInsn(176);
/*  906 */       param1MethodVisitor.visitLabel(label1);
/*  907 */       param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/*  908 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  909 */       param1MethodVisitor.visitInsn(190);
/*  910 */       param1MethodVisitor.visitTypeInsn(189, Type.getInternalName(Object.class));
/*  911 */       param1MethodVisitor.visitVarInsn(58, 1);
/*  912 */       param1MethodVisitor.visitInsn(3);
/*  913 */       param1MethodVisitor.visitVarInsn(54, 2);
/*  914 */       param1MethodVisitor.visitLabel(label2);
/*  915 */       param1Context.getFrameGeneration().append(param1MethodVisitor, 
/*  916 */           Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(int.class) }, ), (List)param1MethodDescription
/*  917 */           .getParameters().asTypeList());
/*  918 */       param1MethodVisitor.visitVarInsn(21, 2);
/*  919 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  920 */       param1MethodVisitor.visitInsn(190);
/*  921 */       param1MethodVisitor.visitJumpInsn(162, label3);
/*  922 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  923 */       param1MethodVisitor.visitVarInsn(21, 2);
/*  924 */       param1MethodVisitor.visitVarInsn(25, 0);
/*  925 */       param1MethodVisitor.visitVarInsn(21, 2);
/*  926 */       param1MethodVisitor.visitInsn(50);
/*  927 */       param1MethodVisitor.visitMethodInsn(184, param1Context
/*  928 */           .getInstrumentedType().getInternalName(), "constant", 
/*      */           
/*  930 */           Type.getMethodDescriptor(Type.getType(Object.class), new Type[] { Type.getType(Object.class) }), false);
/*      */       
/*  932 */       param1MethodVisitor.visitInsn(83);
/*  933 */       param1MethodVisitor.visitIincInsn(2, 1);
/*  934 */       param1MethodVisitor.visitJumpInsn(167, label2);
/*  935 */       param1MethodVisitor.visitLabel(label3);
/*  936 */       param1Context.getFrameGeneration().chop(param1MethodVisitor, 1, CompoundList.of((List)param1MethodDescription
/*  937 */             .getParameters().asTypeList(), 
/*  938 */             TypeDescription.ForLoadedType.of(Object[].class)));
/*  939 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  940 */       param1MethodVisitor.visitInsn(176);
/*  941 */       return new ByteCodeAppender.Size(4, 3); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static final String NAME = "constants";
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass())));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class FrameTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "frames";
/*      */     
/*      */     private final Class<?> sourceLabel;
/*      */     
/*      */     private final Class<?> targetLabel;
/*      */ 
/*      */     
/*      */     protected FrameTranslator(Class<?> param1Class1, Class<?> param1Class2) {
/*  973 */       this.sourceLabel = param1Class1;
/*  974 */       this.targetLabel = param1Class2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  981 */       Label label1 = new Label(), label2 = new Label(), label3 = new Label(), label4 = new Label(), label5 = new Label();
/*  982 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  983 */       param1MethodVisitor.visitJumpInsn(199, label1);
/*  984 */       param1MethodVisitor.visitInsn(1);
/*  985 */       param1MethodVisitor.visitInsn(176);
/*  986 */       param1MethodVisitor.visitLabel(label1);
/*  987 */       param1Context.getFrameGeneration().same(param1MethodVisitor, CompoundList.of(param1Context
/*  988 */             .getInstrumentedType(), (List)param1MethodDescription
/*  989 */             .getParameters().asTypeList()));
/*  990 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  991 */       param1MethodVisitor.visitInsn(190);
/*  992 */       param1MethodVisitor.visitTypeInsn(189, Type.getInternalName(Object.class));
/*  993 */       param1MethodVisitor.visitVarInsn(58, 2);
/*  994 */       param1MethodVisitor.visitInsn(3);
/*  995 */       param1MethodVisitor.visitVarInsn(54, 3);
/*  996 */       param1MethodVisitor.visitLabel(label2);
/*  997 */       param1Context.getFrameGeneration().append(param1MethodVisitor, 
/*  998 */           Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(int.class)
/*  999 */             }, ), CompoundList.of(param1Context.getInstrumentedType(), (List)param1MethodDescription.getParameters().asTypeList()));
/* 1000 */       param1MethodVisitor.visitVarInsn(21, 3);
/* 1001 */       param1MethodVisitor.visitVarInsn(25, 1);
/* 1002 */       param1MethodVisitor.visitInsn(190);
/* 1003 */       param1MethodVisitor.visitJumpInsn(162, label4);
/* 1004 */       param1MethodVisitor.visitVarInsn(25, 2);
/* 1005 */       param1MethodVisitor.visitVarInsn(21, 3);
/* 1006 */       param1MethodVisitor.visitVarInsn(25, 1);
/* 1007 */       param1MethodVisitor.visitVarInsn(21, 3);
/* 1008 */       param1MethodVisitor.visitInsn(50);
/* 1009 */       param1MethodVisitor.visitTypeInsn(193, Type.getInternalName(this.sourceLabel));
/* 1010 */       param1MethodVisitor.visitJumpInsn(153, label5);
/* 1011 */       param1MethodVisitor.visitVarInsn(25, 0);
/* 1012 */       param1MethodVisitor.visitVarInsn(25, 1);
/* 1013 */       param1MethodVisitor.visitVarInsn(21, 3);
/* 1014 */       param1MethodVisitor.visitInsn(50);
/* 1015 */       param1MethodVisitor.visitTypeInsn(192, Type.getInternalName(this.sourceLabel));
/* 1016 */       param1MethodVisitor.visitMethodInsn(183, param1Context
/* 1017 */           .getInstrumentedType().getInternalName(), "label", 
/*      */           
/* 1019 */           Type.getMethodDescriptor(Type.getType(this.targetLabel), new Type[] { Type.getType(this.sourceLabel) }), false);
/*      */       
/* 1021 */       param1MethodVisitor.visitJumpInsn(167, label3);
/* 1022 */       param1MethodVisitor.visitLabel(label5);
/* 1023 */       param1Context.getFrameGeneration().full(param1MethodVisitor, 
/* 1024 */           Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(int.class)
/* 1025 */             }, ), CompoundList.of(
/* 1026 */             Collections.singletonList(param1Context.getInstrumentedType()), (List)param1MethodDescription
/* 1027 */             .getParameters().asTypeList(), 
/* 1028 */             Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(int.class) })));
/* 1029 */       param1MethodVisitor.visitVarInsn(25, 1);
/* 1030 */       param1MethodVisitor.visitVarInsn(21, 3);
/* 1031 */       param1MethodVisitor.visitInsn(50);
/* 1032 */       param1MethodVisitor.visitLabel(label3);
/* 1033 */       param1Context.getFrameGeneration().full(param1MethodVisitor, 
/* 1034 */           Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(int.class), TypeDescription.ForLoadedType.of(Object.class)
/* 1035 */             }, ), CompoundList.of(
/* 1036 */             Collections.singletonList(param1Context.getInstrumentedType()), (List)param1MethodDescription
/* 1037 */             .getParameters().asTypeList(), 
/* 1038 */             Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(int.class) })));
/* 1039 */       param1MethodVisitor.visitInsn(83);
/* 1040 */       param1MethodVisitor.visitIincInsn(3, 1);
/* 1041 */       param1MethodVisitor.visitJumpInsn(167, label2);
/* 1042 */       param1MethodVisitor.visitLabel(label4);
/* 1043 */       param1Context.getFrameGeneration().chop(param1MethodVisitor, 1, CompoundList.of(
/* 1044 */             Collections.singletonList(param1Context.getInstrumentedType()), (List)param1MethodDescription
/* 1045 */             .getParameters().asTypeList(), 
/* 1046 */             Collections.singletonList(TypeDescription.ForLoadedType.of(Object[].class))));
/* 1047 */       param1MethodVisitor.visitVarInsn(25, 2);
/* 1048 */       param1MethodVisitor.visitInsn(176);
/* 1049 */       return new ByteCodeAppender.Size(5, 4);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.sourceLabel.equals(((FrameTranslator)param1Object).sourceLabel) ? false : (!!this.targetLabel.equals(((FrameTranslator)param1Object).targetLabel)))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.sourceLabel.hashCode()) * 31 + this.targetLabel.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class TypePathTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "typePath";
/*      */ 
/*      */     
/*      */     private final Class<?> sourceTypePath;
/*      */ 
/*      */     
/*      */     private final Class<?> targetTypePath;
/*      */ 
/*      */     
/*      */     protected TypePathTranslator(Class<?> param1Class1, Class<?> param1Class2) {
/* 1081 */       this.sourceTypePath = param1Class1;
/* 1082 */       this.targetTypePath = param1Class2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 1089 */       Label label1 = new Label(), label2 = new Label();
/* 1090 */       param1MethodVisitor.visitVarInsn(25, 0);
/* 1091 */       param1MethodVisitor.visitJumpInsn(199, label1);
/* 1092 */       param1MethodVisitor.visitInsn(1);
/* 1093 */       param1MethodVisitor.visitJumpInsn(167, label2);
/* 1094 */       param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/* 1095 */       param1MethodVisitor.visitLabel(label1);
/* 1096 */       param1MethodVisitor.visitVarInsn(25, 0);
/* 1097 */       param1MethodVisitor.visitMethodInsn(182, 
/* 1098 */           Type.getInternalName(this.sourceTypePath), "toString", 
/*      */           
/* 1100 */           Type.getMethodDescriptor(Type.getType(String.class), new Type[0]), false);
/*      */       
/* 1102 */       param1MethodVisitor.visitMethodInsn(184, 
/* 1103 */           Type.getInternalName(this.targetTypePath), "fromString", 
/*      */           
/* 1105 */           Type.getMethodDescriptor(Type.getType(this.targetTypePath), new Type[] { Type.getType(String.class) }), false);
/*      */       
/* 1107 */       param1MethodVisitor.visitLabel(label2);
/* 1108 */       param1Context.getFrameGeneration().same1(param1MethodVisitor, 
/* 1109 */           (TypeDefinition)TypeDescription.ForLoadedType.of(this.targetTypePath), (List)param1MethodDescription
/* 1110 */           .getParameters().asTypeList());
/* 1111 */       param1MethodVisitor.visitInsn(176);
/* 1112 */       return new ByteCodeAppender.Size(1, 2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.sourceTypePath.equals(((TypePathTranslator)param1Object).sourceTypePath) ? false : (!!this.targetTypePath.equals(((TypePathTranslator)param1Object).targetTypePath)))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.sourceTypePath.hashCode()) * 31 + this.targetTypePath.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class AttributeTranslator
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     protected static final String NAME = "attribute";
/*      */ 
/*      */ 
/*      */     
/*      */     private final Class<?> sourceAttribute;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Class<?> targetAttribute;
/*      */ 
/*      */     
/*      */     private final TypeDescription sourceWrapper;
/*      */ 
/*      */     
/*      */     private final TypeDescription targetWrapper;
/*      */ 
/*      */ 
/*      */     
/*      */     protected AttributeTranslator(Class<?> param1Class1, Class<?> param1Class2, TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/* 1156 */       this.sourceAttribute = param1Class1;
/* 1157 */       this.targetAttribute = param1Class2;
/* 1158 */       this.sourceWrapper = param1TypeDescription1;
/* 1159 */       this.targetWrapper = param1TypeDescription2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 1166 */       Label label1 = new Label(), label2 = new Label();
/* 1167 */       param1MethodVisitor.visitVarInsn(25, 0);
/* 1168 */       param1MethodVisitor.visitJumpInsn(199, label1);
/* 1169 */       param1MethodVisitor.visitInsn(1);
/* 1170 */       param1MethodVisitor.visitInsn(176);
/* 1171 */       param1MethodVisitor.visitLabel(label1);
/* 1172 */       param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/* 1173 */       param1MethodVisitor.visitVarInsn(25, 0);
/* 1174 */       param1MethodVisitor.visitTypeInsn(193, this.targetWrapper.getInternalName());
/* 1175 */       param1MethodVisitor.visitJumpInsn(153, label2);
/* 1176 */       param1MethodVisitor.visitVarInsn(25, 0);
/* 1177 */       param1MethodVisitor.visitTypeInsn(192, this.targetWrapper.getInternalName());
/* 1178 */       param1MethodVisitor.visitFieldInsn(180, this.targetWrapper.getInternalName(), "delegate", Type.getDescriptor(this.sourceAttribute));
/* 1179 */       param1MethodVisitor.visitInsn(176);
/* 1180 */       param1MethodVisitor.visitLabel(label2);
/* 1181 */       param1Context.getFrameGeneration().same(param1MethodVisitor, (List)param1MethodDescription.getParameters().asTypeList());
/* 1182 */       param1MethodVisitor.visitTypeInsn(187, this.sourceWrapper.getInternalName());
/* 1183 */       param1MethodVisitor.visitInsn(89);
/* 1184 */       param1MethodVisitor.visitVarInsn(25, 0);
/* 1185 */       param1MethodVisitor.visitMethodInsn(183, this.sourceWrapper
/* 1186 */           .getInternalName(), "<init>", 
/*      */           
/* 1188 */           Type.getMethodDescriptor(Type.VOID_TYPE, new Type[] { Type.getType(this.targetAttribute) }), false);
/*      */       
/* 1190 */       param1MethodVisitor.visitInsn(176);
/* 1191 */       return new ByteCodeAppender.Size(3, 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.sourceAttribute.equals(((AttributeTranslator)param1Object).sourceAttribute) ? false : (!this.targetAttribute.equals(((AttributeTranslator)param1Object).targetAttribute) ? false : (!this.sourceWrapper.equals(((AttributeTranslator)param1Object).sourceWrapper) ? false : (!!this.targetWrapper.equals(((AttributeTranslator)param1Object).targetWrapper)))))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.sourceAttribute.hashCode()) * 31 + this.targetAttribute.hashCode()) * 31 + this.sourceWrapper.hashCode()) * 31 + this.targetWrapper.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class CreateClassVisitorFactory<S>
/*      */     implements PrivilegedAction<ClassVisitorFactory<S>>
/*      */   {
/*      */     private final Class<S> classVisitor;
/*      */ 
/*      */     
/*      */     private final ByteBuddy byteBuddy;
/*      */ 
/*      */     
/*      */     protected CreateClassVisitorFactory(Class<S> param1Class, ByteBuddy param1ByteBuddy) {
/* 1220 */       this.classVisitor = param1Class;
/* 1221 */       this.byteBuddy = param1ByteBuddy;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassVisitorFactory<S> run() {
/* 1228 */       if (!ClassVisitor.class.getSimpleName().equals(this.classVisitor.getSimpleName()))
/* 1229 */         throw new IllegalArgumentException("Expected a class named " + ClassVisitor.class.getSimpleName() + ": " + this.classVisitor); 
/*      */       try {
/*      */         DynamicType dynamicType1, dynamicType2;
/* 1232 */         String str = this.classVisitor.getPackage().getName();
/* 1233 */         HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 1234 */         for (Class<?> clazz1 : Arrays.<Class<?>[]>asList((Class<?>[][])new Class[] { Attribute.class, Label.class, Type.class, TypePath.class, Handle.class, ConstantDynamic.class })) {
/*      */           Class<?> clazz2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/* 1244 */             clazz2 = Class.forName(str + "." + clazz1.getSimpleName(), false, this.classVisitor.getClassLoader());
/* 1245 */           } catch (ClassNotFoundException classNotFoundException) {
/*      */             continue;
/*      */           } 
/* 1248 */           hashMap1.put(clazz1, clazz2);
/*      */         } 
/* 1250 */         if (hashMap1.containsKey(Label.class)) {
/* 1251 */           hashMap1.put(Label[].class, Class.forName("[L" + ((Class)hashMap1.get(Label.class)).getName() + ";", false, this.classVisitor.getClassLoader()));
/*      */         }
/* 1253 */         HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/* 1254 */         HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
/* 1255 */         for (Class<MethodVisitor> clazz : Arrays.<Class<?>[]>asList((Class<?>[][])new Class[] { ClassVisitor.class, AnnotationVisitor.class, ModuleVisitor.class, RecordComponentVisitor.class, FieldVisitor.class, MethodVisitor.class })) {
/*      */           DynamicType.Builder builder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/* 1265 */             dynamicType1 = (DynamicType)Class.forName(str + "." + clazz.getSimpleName(), false, this.classVisitor.getClassLoader());
/* 1266 */           } catch (ClassNotFoundException classNotFoundException) {
/*      */             continue;
/*      */           } 
/*      */           
/* 1270 */           if (clazz == MethodVisitor.class) {
/* 1271 */             dynamicType2 = (DynamicType)ClassVisitorFactory.a(this.byteBuddy, clazz, (Class)dynamicType1, TypePath.class, (Class)hashMap1
/*      */                 
/* 1273 */                 .get(TypePath.class), Label.class, (Class)hashMap1
/* 1274 */                 .get(Label.class), Type.class, (Class)hashMap1
/* 1275 */                 .get(Type.class), Handle.class, (Class)hashMap1
/* 1276 */                 .get(Handle.class), ConstantDynamic.class, (Class)hashMap1
/* 1277 */                 .get(ConstantDynamic.class));
/* 1278 */             builder = ClassVisitorFactory.a(this.byteBuddy, (Class)dynamicType1, clazz, (Class)hashMap1
/*      */                 
/* 1280 */                 .get(TypePath.class), TypePath.class, (Class)hashMap1
/* 1281 */                 .get(Label.class), Label.class, (Class)hashMap1
/* 1282 */                 .get(Type.class), Type.class, (Class)hashMap1
/* 1283 */                 .get(Handle.class), Handle.class, (Class)hashMap1
/* 1284 */                 .get(ConstantDynamic.class), ConstantDynamic.class);
/*      */           } else {
/* 1286 */             dynamicType2 = (DynamicType)ClassVisitorFactory.a(this.byteBuddy, clazz, (Class)dynamicType1, TypePath.class, (Class)hashMap1
/*      */                 
/* 1288 */                 .get(TypePath.class), (Implementation)new Implementation.Simple(new StackManipulation[] { (StackManipulation)MethodReturn.VOID }));
/*      */             
/* 1290 */             builder = ClassVisitorFactory.a(this.byteBuddy, (Class)dynamicType1, clazz, (Class)hashMap1
/*      */                 
/* 1292 */                 .get(TypePath.class), TypePath.class, (Implementation)new Implementation.Simple(new StackManipulation[] { (StackManipulation)MethodReturn.VOID }));
/*      */           } 
/*      */           
/* 1295 */           hashMap2.put(clazz, dynamicType1);
/* 1296 */           hashMap3.put(clazz, dynamicType2);
/* 1297 */           hashMap3.put(dynamicType1, builder);
/*      */         } 
/* 1299 */         ArrayList<DynamicType> arrayList = new ArrayList();
/* 1300 */         HashMap<Object, Object> hashMap4 = new HashMap<Object, Object>();
/*      */         
/* 1302 */         if (hashMap1.containsKey(Attribute.class)) {
/* 1303 */           DynamicType.Builder builder2 = this.byteBuddy.subclass(Attribute.class, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS);
/* 1304 */           DynamicType.Builder builder1 = this.byteBuddy.subclass((Class)hashMap1.get(Attribute.class), (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS);
/* 1305 */           dynamicType1 = ClassVisitorFactory.a(builder2, Attribute.class, (Class)hashMap1.get(Attribute.class), builder2.toTypeDescription(), builder1.toTypeDescription());
/* 1306 */           arrayList.add(dynamicType1);
/* 1307 */           dynamicType2 = ClassVisitorFactory.a(builder1, (Class)hashMap1.get(Attribute.class), Attribute.class, builder1.toTypeDescription(), builder2.toTypeDescription());
/* 1308 */           arrayList.add(dynamicType2);
/*      */         } else {
/* 1310 */           dynamicType1 = null;
/* 1311 */           dynamicType2 = null;
/*      */         } 
/* 1313 */         for (Map.Entry<Object, Object> entry : hashMap2.entrySet()) {
/* 1314 */           DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition1, receiverTypeDefinition2; DynamicType.Builder builder1 = (DynamicType.Builder)hashMap3.get(entry.getKey()), builder2 = (DynamicType.Builder)hashMap3.get(entry.getValue()); Method[] arrayOfMethod; int i; byte b;
/* 1315 */           for (i = (arrayOfMethod = ((Class)entry.getKey()).getMethods()).length, b = 0; b < i; b++) {
/* 1316 */             Method method; if ((method = arrayOfMethod[b]).getDeclaringClass() != Object.class) {
/*      */               Method method1;
/*      */               
/* 1319 */               Class[] arrayOfClass1, arrayOfClass2 = new Class[(arrayOfClass1 = method.getParameterTypes()).length];
/* 1320 */               ArrayList<MethodCall.ArgumentLoader.Factory> arrayList1 = new ArrayList(arrayOfClass1.length);
/* 1321 */               ArrayList<MethodCall.ArgumentLoader.Factory> arrayList2 = new ArrayList(arrayOfClass2.length);
/* 1322 */               boolean bool1 = false, bool2 = false;
/* 1323 */               int j = 1;
/* 1324 */               for (byte b1 = 0; b1 < arrayOfClass1.length; b1++) {
/* 1325 */                 if (entry.getKey() == MethodVisitor.class && arrayOfClass1[b1] == Label.class) {
/* 1326 */                   arrayOfClass2[b1] = (Class)hashMap1.get(Label.class);
/* 1327 */                   arrayList1.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getKey())).toTypeDescription(), arrayOfClass2[b1], "label", j, true));
/* 1328 */                   arrayList2.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getValue())).toTypeDescription(), arrayOfClass1[b1], "label", j, true));
/* 1329 */                 } else if (entry.getKey() == MethodVisitor.class && arrayOfClass1[b1] == Label[].class) {
/* 1330 */                   arrayOfClass2[b1] = (Class)hashMap1.get(Label[].class);
/* 1331 */                   arrayList1.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getKey())).toTypeDescription(), arrayOfClass2[b1], "labels", j, true));
/* 1332 */                   arrayList2.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getValue())).toTypeDescription(), arrayOfClass1[b1], "labels", j, true));
/* 1333 */                 } else if (arrayOfClass1[b1] == TypePath.class) {
/* 1334 */                   arrayOfClass2[b1] = (Class)hashMap1.get(TypePath.class);
/* 1335 */                   arrayList1.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getKey())).toTypeDescription(), arrayOfClass2[b1], "typePath", j, false));
/* 1336 */                   arrayList2.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getValue())).toTypeDescription(), arrayOfClass1[b1], "typePath", j, false));
/* 1337 */                 } else if (entry.getKey() == MethodVisitor.class && arrayOfClass1[b1] == Handle.class) {
/* 1338 */                   arrayOfClass2[b1] = (Class)hashMap1.get(Handle.class);
/* 1339 */                   arrayList1.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getKey())).toTypeDescription(), arrayOfClass2[b1], "handle", j, false));
/* 1340 */                   arrayList2.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getValue())).toTypeDescription(), arrayOfClass1[b1], "handle", j, false));
/* 1341 */                 } else if (entry.getKey() == MethodVisitor.class && arrayOfClass1[b1] == Object.class) {
/* 1342 */                   arrayOfClass2[b1] = Object.class;
/* 1343 */                   arrayList1.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getKey())).toTypeDescription(), Object.class, "constant", j, false));
/* 1344 */                   arrayList2.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getValue())).toTypeDescription(), Object.class, "constant", j, false));
/* 1345 */                 } else if (entry.getKey() == MethodVisitor.class && arrayOfClass1[b1] == Object[].class) {
/* 1346 */                   arrayOfClass2[b1] = Object[].class;
/* 1347 */                   if (method.getName().equals("visitFrame")) {
/* 1348 */                     arrayList1.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getKey())).toTypeDescription(), Object[].class, "frames", j, true));
/* 1349 */                     arrayList2.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getValue())).toTypeDescription(), Object[].class, "frames", j, true));
/*      */                   } else {
/* 1351 */                     arrayList1.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getKey())).toTypeDescription(), Object[].class, "constants", j, false));
/* 1352 */                     arrayList2.add(ClassVisitorFactory.a(((DynamicType.Builder)hashMap3.get(entry.getValue())).toTypeDescription(), Object[].class, "constants", j, false));
/*      */                   } 
/* 1354 */                 } else if (arrayOfClass1[b1] == Attribute.class) {
/* 1355 */                   arrayOfClass2[b1] = (Class)hashMap1.get(Attribute.class);
/* 1356 */                   if (dynamicType1 != null && dynamicType2 != null) {
/* 1357 */                     arrayList1.add(ClassVisitorFactory.a(dynamicType2.getTypeDescription(), (Class)hashMap1.get(Attribute.class), "attribute", j, false));
/* 1358 */                     arrayList2.add(ClassVisitorFactory.a(dynamicType1.getTypeDescription(), Attribute.class, "attribute", j, false));
/*      */                   } else {
/* 1360 */                     bool1 = true;
/*      */                   } 
/*      */                 } else {
/* 1363 */                   arrayOfClass2[b1] = arrayOfClass1[b1];
/* 1364 */                   arrayList1.add(new MethodCall.ArgumentLoader.ForMethodParameter.Factory(b1));
/* 1365 */                   arrayList2.add(new MethodCall.ArgumentLoader.ForMethodParameter.Factory(b1));
/*      */                 } 
/* 1367 */                 if (arrayOfClass2[b1] == null) {
/* 1368 */                   bool2 = true;
/*      */                   break;
/*      */                 } 
/* 1371 */                 j += (arrayOfClass1[b1] == long.class || arrayOfClass1[b1] == double.class) ? 2 : 1;
/*      */               } 
/*      */               
/* 1374 */               if (bool2) {
/* 1375 */                 method1 = null;
/* 1376 */                 bool1 = true;
/*      */               } else {
/*      */                 try {
/* 1379 */                   method1 = ((Class)entry.getValue()).getMethod(method.getName(), arrayOfClass2);
/* 1380 */                 } catch (NoSuchMethodException noSuchMethodException) {
/* 1381 */                   method1 = null;
/* 1382 */                   bool1 = true;
/*      */                 } 
/*      */               } 
/* 1385 */               if (bool1) {
/* 1386 */                 receiverTypeDefinition1 = builder1.method((ElementMatcher)ElementMatchers.is(method)).intercept(ExceptionMethod.throwing(UnsupportedOperationException.class));
/* 1387 */                 if (method1 != null) {
/* 1388 */                   receiverTypeDefinition2 = builder2.method((ElementMatcher)ElementMatchers.is(method1)).intercept(ExceptionMethod.throwing(UnsupportedOperationException.class));
/*      */                 }
/*      */               } else {
/* 1391 */                 MethodCall methodCall1 = MethodCall.invoke(method1).onField("delegate").with(arrayList1);
/* 1392 */                 MethodCall methodCall2 = MethodCall.invoke(method).onField("delegate").with(arrayList2);
/*      */                 Class clazz;
/* 1394 */                 if ((clazz = (Class)hashMap2.get(method.getReturnType())) != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1399 */                   methodCall1 = MethodCall.invoke((MethodDescription)((MethodList)((DynamicType.Builder)hashMap3.get(method.getReturnType())).toTypeDescription().getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("wrap"))).getOnly()).withMethodCall(methodCall1);
/*      */ 
/*      */ 
/*      */                   
/* 1403 */                   methodCall2 = MethodCall.invoke((MethodDescription)((MethodList)((DynamicType.Builder)hashMap3.get(clazz)).toTypeDescription().getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("wrap"))).getOnly()).withMethodCall(methodCall2);
/*      */                 } 
/* 1405 */                 receiverTypeDefinition1 = receiverTypeDefinition1.method((ElementMatcher)ElementMatchers.is(method)).intercept((Implementation)methodCall1);
/* 1406 */                 receiverTypeDefinition2 = receiverTypeDefinition2.method((ElementMatcher)ElementMatchers.is(method1)).intercept((Implementation)methodCall2);
/*      */               } 
/*      */             } 
/* 1409 */           }  DynamicType.Unloaded unloaded1 = receiverTypeDefinition1.make(), unloaded2 = receiverTypeDefinition2.make();
/* 1410 */           hashMap4.put(entry.getKey(), unloaded1.getTypeDescription());
/* 1411 */           hashMap4.put(entry.getValue(), unloaded2.getTypeDescription());
/* 1412 */           arrayList.add(unloaded1);
/* 1413 */           arrayList.add(unloaded2);
/*      */         } 
/*      */ 
/*      */         
/* 1417 */         ClassLoader classLoader = (new MultipleParentClassLoader.Builder(false)).appendMostSpecific(new Class[] { ClassVisitor.class, this.classVisitor }).build();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1433 */         ClassVisitorFactory<S> classVisitorFactory = this.byteBuddy.subclass(ClassVisitorFactory.class, (ConstructorStrategy)ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING).method((ElementMatcher)ElementMatchers.named("wrap")).intercept((Implementation)MethodCall.construct((MethodDescription)((MethodList)((TypeDescription)hashMap4.get(this.classVisitor)).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly()).withArgument(new int[] { 0 })).method((ElementMatcher)ElementMatchers.named("unwrap")).intercept((Implementation)MethodCall.construct((MethodDescription)((MethodList)((TypeDescription)hashMap4.get(ClassVisitor.class)).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly()).withArgument(new int[] { 0 }).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC)).make().include(arrayList).load(classLoader).getLoaded().getConstructor(new Class[] { Class.class }).newInstance(new Object[] { this.classVisitor });
/* 1434 */         if (classLoader instanceof MultipleParentClassLoader && classLoader != ClassVisitor.class
/* 1435 */           .getClassLoader() && classLoader != this.classVisitor
/* 1436 */           .getClassLoader() && 
/* 1437 */           !((MultipleParentClassLoader)classLoader).seal()) {
/* 1438 */           throw new IllegalStateException("Failed to seal multiple parent class loader: " + classLoader);
/*      */         }
/* 1440 */         return classVisitorFactory;
/* 1441 */       } catch (Exception exception) {
/* 1442 */         throw new IllegalArgumentException("Failed to generate factory for " + this.classVisitor.getName(), exception);
/*      */       } 
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.classVisitor.equals(((CreateClassVisitorFactory)param1Object).classVisitor) ? false : (!!this.byteBuddy.equals(((CreateClassVisitorFactory)param1Object).byteBuddy)))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.classVisitor.hashCode()) * 31 + this.byteBuddy.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\ClassVisitorFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */