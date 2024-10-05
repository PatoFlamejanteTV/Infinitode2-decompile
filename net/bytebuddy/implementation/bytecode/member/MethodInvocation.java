/*     */ package net.bytebuddy.implementation.bytecode.member;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*     */ import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
/*     */ import net.bytebuddy.jar.asm.Handle;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.utility.JavaConstant;
/*     */ import net.bytebuddy.utility.JavaType;
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
/*     */ public enum MethodInvocation
/*     */ {
/*  44 */   VIRTUAL(182, 5, 182, 5),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   INTERFACE(185, 9, 185, 9),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   STATIC(184, 6, 184, 6),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   SPECIAL(183, 7, 183, 7),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   SPECIAL_CONSTRUCTOR(183, 8, 183, 8),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   VIRTUAL_PRIVATE(182, 5, 183, 7),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   INTERFACE_PRIVATE(185, 9, 183, 7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int opcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int handle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int legacyOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int legacyHandle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   MethodInvocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 105 */     this.opcode = paramInt1;
/* 106 */     this.handle = paramInt2;
/* 107 */     this.legacyOpcode = paramInt3;
/* 108 */     this.legacyHandle = paramInt4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WithImplicitInvocationTargetType invoke(MethodDescription.InDefinedShape paramInDefinedShape) {
/* 118 */     if (paramInDefinedShape.isTypeInitializer())
/* 119 */       return IllegalInvocation.INSTANCE; 
/* 120 */     if (paramInDefinedShape.isStatic()) {
/* 121 */       STATIC.getClass(); return new Invocation(paramInDefinedShape);
/* 122 */     }  if (paramInDefinedShape.isConstructor()) {
/* 123 */       SPECIAL_CONSTRUCTOR.getClass(); return new Invocation(paramInDefinedShape);
/* 124 */     }  if (paramInDefinedShape.isPrivate()) {
/* 125 */       (paramInDefinedShape.getDeclaringType().isInterface() ? INTERFACE_PRIVATE : VIRTUAL_PRIVATE).getClass(); return new Invocation(paramInDefinedShape);
/*     */     } 
/*     */     
/* 128 */     if (paramInDefinedShape.getDeclaringType().isInterface()) {
/* 129 */       INTERFACE.getClass(); return new Invocation(paramInDefinedShape);
/*     */     } 
/* 131 */     VIRTUAL.getClass(); return new Invocation(paramInDefinedShape);
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
/*     */   public static WithImplicitInvocationTargetType invoke(MethodDescription paramMethodDescription) {
/*     */     MethodDescription.InDefinedShape inDefinedShape;
/* 144 */     if ((inDefinedShape = (MethodDescription.InDefinedShape)paramMethodDescription.asDefined()).getReturnType().asErasure().equals(paramMethodDescription.getReturnType().asErasure()))
/* 145 */       return invoke(inDefinedShape); 
/* 146 */     return OfGenericMethod.of(paramMethodDescription, invoke(inDefinedShape));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation lookup() {
/* 155 */     return invoke((MethodDescription.InDefinedShape)new MethodDescription.Latent(JavaType.METHOD_HANDLES.getTypeStub(), new MethodDescription.Token("lookup", 9, JavaType.METHOD_HANDLES_LOOKUP
/*     */             
/* 157 */             .getTypeStub().asGenericType())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum IllegalInvocation
/*     */     implements WithImplicitInvocationTargetType
/*     */   {
/* 168 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation virtual(TypeDescription param1TypeDescription) {
/* 174 */       return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation special(TypeDescription param1TypeDescription) {
/* 181 */       return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation dynamic(String param1String, TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List, List<? extends JavaConstant> param1List1) {
/* 191 */       return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation onHandle(MethodInvocation.HandleType param1HandleType) {
/* 198 */       return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isValid() {
/* 205 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 212 */       return StackManipulation.Illegal.INSTANCE.apply(param1MethodVisitor, param1Context);
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
/*     */   public static interface WithImplicitInvocationTargetType
/*     */     extends StackManipulation
/*     */   {
/*     */     StackManipulation virtual(TypeDescription param1TypeDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StackManipulation special(TypeDescription param1TypeDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StackManipulation dynamic(String param1String, TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List, List<? extends JavaConstant> param1List1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StackManipulation onHandle(MethodInvocation.HandleType param1HandleType);
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
/*     */   protected static class OfGenericMethod
/*     */     implements WithImplicitInvocationTargetType
/*     */   {
/*     */     private final TypeDescription targetType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final MethodInvocation.WithImplicitInvocationTargetType invocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected OfGenericMethod(TypeDescription param1TypeDescription, MethodInvocation.WithImplicitInvocationTargetType param1WithImplicitInvocationTargetType) {
/* 286 */       this.targetType = param1TypeDescription;
/* 287 */       this.invocation = param1WithImplicitInvocationTargetType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static MethodInvocation.WithImplicitInvocationTargetType of(MethodDescription param1MethodDescription, MethodInvocation.WithImplicitInvocationTargetType param1WithImplicitInvocationTargetType) {
/* 298 */       return new OfGenericMethod(param1MethodDescription.getReturnType().asErasure(), param1WithImplicitInvocationTargetType);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation virtual(TypeDescription param1TypeDescription) {
/* 305 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.invocation.virtual(param1TypeDescription), TypeCasting.to((TypeDefinition)this.targetType) });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation special(TypeDescription param1TypeDescription) {
/* 312 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.invocation.special(param1TypeDescription), TypeCasting.to((TypeDefinition)this.targetType) });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation dynamic(String param1String, TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List, List<? extends JavaConstant> param1List1) {
/* 319 */       return this.invocation.dynamic(param1String, param1TypeDescription, param1List, param1List1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation onHandle(MethodInvocation.HandleType param1HandleType) {
/* 326 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.invocation.onHandle(param1HandleType), TypeCasting.to((TypeDefinition)this.targetType) });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 333 */       return this.invocation.isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 340 */       return (new StackManipulation.Compound(new StackManipulation[] { this.invocation, TypeCasting.to((TypeDefinition)this.targetType) })).apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.targetType.equals(((OfGenericMethod)param1Object).targetType) ? false : (!!this.invocation.equals(((OfGenericMethod)param1Object).invocation)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.targetType.hashCode()) * 31 + this.invocation.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class Invocation
/*     */     extends StackManipulation.AbstractBase
/*     */     implements WithImplicitInvocationTargetType
/*     */   {
/*     */     private final TypeDescription typeDescription;
/*     */     
/*     */     private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */     
/*     */     protected Invocation(MethodDescription.InDefinedShape param1InDefinedShape) {
/* 366 */       this(param1InDefinedShape, param1InDefinedShape.getDeclaringType());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Invocation(MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription param1TypeDescription) {
/* 376 */       this.typeDescription = param1TypeDescription;
/* 377 */       this.methodDescription = param1InDefinedShape;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 384 */       param1MethodVisitor.visitMethodInsn((MethodInvocation.a(this.a) == MethodInvocation.b(this.a) || param1Context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11)) ? 
/* 385 */           MethodInvocation.a(this.a) : 
/* 386 */           MethodInvocation.b(this.a), this.typeDescription
/* 387 */           .getInternalName(), this.methodDescription
/* 388 */           .getInternalName(), this.methodDescription
/* 389 */           .getDescriptor(), this.typeDescription
/* 390 */           .isInterface());
/* 391 */       int i = this.methodDescription.getStackSize(), j = this.methodDescription.getReturnType().getStackSize().getSize();
/* 392 */       return new StackManipulation.Size(j - i, Math.max(0, j - i));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation virtual(TypeDescription param1TypeDescription) {
/* 399 */       if (this.methodDescription.isConstructor() || this.methodDescription.isStatic())
/* 400 */         return (StackManipulation)StackManipulation.Illegal.INSTANCE; 
/* 401 */       if (this.methodDescription.isPrivate()) {
/* 402 */         return (StackManipulation)(this.methodDescription.getDeclaringType().equals(param1TypeDescription) ? this : StackManipulation.Illegal.INSTANCE);
/*     */       }
/*     */       
/* 405 */       if (param1TypeDescription.isInterface()) {
/* 406 */         if (this.methodDescription.getDeclaringType().represents(Object.class)) return this;  MethodInvocation.INTERFACE.getClass(); return new Invocation(this.methodDescription, param1TypeDescription);
/*     */       } 
/*     */ 
/*     */       
/* 410 */       MethodInvocation.VIRTUAL.getClass(); return new Invocation(this.methodDescription, param1TypeDescription);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation special(TypeDescription param1TypeDescription) {
/* 418 */       if (this.methodDescription.isSpecializableFor(param1TypeDescription)) { MethodInvocation.SPECIAL.getClass(); return new Invocation(this.methodDescription, param1TypeDescription); }  return (StackManipulation)StackManipulation.Illegal.INSTANCE;
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
/*     */     public StackManipulation dynamic(String param1String, TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List, List<? extends JavaConstant> param1List1) {
/* 430 */       return (StackManipulation)(this.methodDescription.isInvokeBootstrap() ? new MethodInvocation.DynamicInvocation(this.a, param1String, param1TypeDescription, (List<? extends TypeDescription>)new TypeList.Explicit(param1List), (MethodDescription.InDefinedShape)this.methodDescription
/* 431 */           .asDefined(), param1List1) : StackManipulation.Illegal.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation onHandle(MethodInvocation.HandleType param1HandleType) {
/* 439 */       return (StackManipulation)new MethodInvocation.HandleInvocation(this.methodDescription, param1HandleType);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.a.equals(((Invocation)param1Object).a) ? false : (!this.typeDescription.equals(((Invocation)param1Object).typeDescription) ? false : (!!this.methodDescription.equals(((Invocation)param1Object).methodDescription))))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return ((getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.a.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class DynamicInvocation
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final String methodName;
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription returnType;
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends TypeDescription> parameterTypes;
/*     */ 
/*     */ 
/*     */     
/*     */     private final MethodDescription.InDefinedShape bootstrapMethod;
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends JavaConstant> arguments;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DynamicInvocation(MethodInvocation this$0, String param1String, TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List, MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List1) {
/* 488 */       this.methodName = param1String;
/* 489 */       this.returnType = param1TypeDescription;
/* 490 */       this.parameterTypes = param1List;
/* 491 */       this.bootstrapMethod = param1InDefinedShape;
/* 492 */       this.arguments = param1List1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 499 */       StringBuilder stringBuilder = new StringBuilder("(");
/* 500 */       for (TypeDescription typeDescription : this.parameterTypes) {
/* 501 */         stringBuilder.append(typeDescription.getDescriptor());
/*     */       }
/* 503 */       String str = stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
/* 504 */       Object[] arrayOfObject = new Object[this.arguments.size()];
/* 505 */       byte b = 0;
/* 506 */       for (JavaConstant javaConstant : this.arguments) {
/* 507 */         arrayOfObject[b++] = javaConstant.accept((JavaConstant.Visitor)JavaConstantValue.Visitor.INSTANCE);
/*     */       }
/* 509 */       param1MethodVisitor.visitInvokeDynamicInsn(this.methodName, str, new Handle((
/*     */             
/* 511 */             MethodInvocation.c(this.a) == MethodInvocation.d(this.a) || param1Context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11)) ? 
/* 512 */             MethodInvocation.c(this.a) : 
/* 513 */             MethodInvocation.d(this.a), this.bootstrapMethod
/* 514 */             .getDeclaringType().getInternalName(), this.bootstrapMethod
/* 515 */             .getInternalName(), this.bootstrapMethod
/* 516 */             .getDescriptor(), this.bootstrapMethod
/* 517 */             .getDeclaringType().isInterface()), arrayOfObject);
/*     */       
/* 519 */       int i = this.returnType.getStackSize().getSize() - StackSize.of(this.parameterTypes);
/* 520 */       return new StackManipulation.Size(i, Math.max(i, 0));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.a.equals(((DynamicInvocation)param1Object).a) ? false : (!this.methodName.equals(((DynamicInvocation)param1Object).methodName) ? false : (!this.returnType.equals(((DynamicInvocation)param1Object).returnType) ? false : (!this.parameterTypes.equals(((DynamicInvocation)param1Object).parameterTypes) ? false : (!this.bootstrapMethod.equals(((DynamicInvocation)param1Object).bootstrapMethod) ? false : (!!this.arguments.equals(((DynamicInvocation)param1Object).arguments)))))))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (((((getClass().hashCode() * 31 + this.methodName.hashCode()) * 31 + this.returnType.hashCode()) * 31 + this.parameterTypes.hashCode()) * 31 + this.bootstrapMethod.hashCode()) * 31 + this.arguments.hashCode()) * 31 + this.a.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class HandleInvocation
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private static final String METHOD_HANDLE = "java/lang/invoke/MethodHandle";
/*     */ 
/*     */     
/*     */     private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */     
/*     */     private final MethodInvocation.HandleType type;
/*     */ 
/*     */     
/*     */     protected HandleInvocation(MethodDescription.InDefinedShape param1InDefinedShape, MethodInvocation.HandleType param1HandleType) {
/* 552 */       this.methodDescription = param1InDefinedShape;
/* 553 */       this.type = param1HandleType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 560 */       param1MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandle", this.type
/*     */           
/* 562 */           .getMethodName(), (this.methodDescription
/* 563 */           .isStatic() || this.methodDescription.isConstructor()) ? this.methodDescription
/* 564 */           .getDescriptor() : ("(" + this.methodDescription
/* 565 */           .getDeclaringType().getDescriptor() + this.methodDescription.getDescriptor().substring(1)), false);
/*     */       
/* 567 */       int i = 1 + this.methodDescription.getStackSize(), j = this.methodDescription.getReturnType().getStackSize().getSize();
/* 568 */       return new StackManipulation.Size(j - i, Math.max(0, j - i));
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.type.equals(((HandleInvocation)param1Object).type) ? false : (!!this.methodDescription.equals(((HandleInvocation)param1Object).methodDescription)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.type.hashCode();
/*     */     } }
/*     */   
/*     */   public enum HandleType {
/* 580 */     EXACT("invokeExact"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 585 */     REGULAR("invoke");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String methodName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     HandleType(String param1String1) {
/* 598 */       this.methodName = param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final String getMethodName() {
/* 607 */       return this.methodName;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\member\MethodInvocation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */