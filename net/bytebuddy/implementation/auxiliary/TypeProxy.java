/*     */ package net.bytebuddy.implementation.auxiliary;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.ByteBuddy;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.modifier.Ownership;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.TargetType;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.Throw;
/*     */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*     */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.RandomString;
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
/*     */ @Enhance
/*     */ public class TypeProxy
/*     */   implements AuxiliaryType
/*     */ {
/*     */   public static final String REFLECTION_METHOD = "make";
/*     */   public static final String INSTANCE_FIELD = "target";
/*     */   private final TypeDescription proxiedType;
/*     */   private final Implementation.Target implementationTarget;
/*     */   private final InvocationFactory invocationFactory;
/*     */   private final boolean ignoreFinalizer;
/*     */   private final boolean serializableProxy;
/*     */   
/*     */   public TypeProxy(TypeDescription paramTypeDescription, Implementation.Target paramTarget, InvocationFactory paramInvocationFactory, boolean paramBoolean1, boolean paramBoolean2) {
/* 105 */     this.proxiedType = paramTypeDescription;
/* 106 */     this.implementationTarget = paramTarget;
/* 107 */     this.invocationFactory = paramInvocationFactory;
/* 108 */     this.ignoreFinalizer = paramBoolean1;
/* 109 */     this.serializableProxy = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSuffix() {
/* 116 */     return RandomString.hashOf(this.proxiedType.hashCode()) + (this.ignoreFinalizer ? "I" : "0") + (this.serializableProxy ? "S" : "0");
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
/*     */   public DynamicType make(String paramString, ClassFileVersion paramClassFileVersion, MethodAccessorFactory paramMethodAccessorFactory) {
/* 132 */     (new Class[1])[0] = Serializable.class; return (DynamicType)(new ByteBuddy(paramClassFileVersion)).with(TypeValidation.DISABLED).ignore(this.ignoreFinalizer ? (ElementMatcher)ElementMatchers.isFinalizer() : (ElementMatcher)ElementMatchers.none()).subclass((TypeDefinition)this.proxiedType).name(paramString).modifiers(DEFAULT_TYPE_MODIFIER)
/* 133 */       .implement(this.serializableProxy ? (Type[])new Class[1] : (Type[])new Class[0])
/* 134 */       .method((ElementMatcher)ElementMatchers.any()).intercept(new MethodCall(this, paramMethodAccessorFactory))
/* 135 */       .defineMethod("make", TargetType.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Ownership.STATIC }).intercept(SilentConstruction.INSTANCE)
/* 136 */       .make();
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.ignoreFinalizer != ((TypeProxy)paramObject).ignoreFinalizer) ? false : ((this.serializableProxy != ((TypeProxy)paramObject).serializableProxy) ? false : (!this.proxiedType.equals(((TypeProxy)paramObject).proxiedType) ? false : (!this.implementationTarget.equals(((TypeProxy)paramObject).implementationTarget) ? false : (!!this.invocationFactory.equals(((TypeProxy)paramObject).invocationFactory))))))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return ((((getClass().hashCode() * 31 + this.proxiedType.hashCode()) * 31 + this.implementationTarget.hashCode()) * 31 + this.invocationFactory.hashCode()) * 31 + this.ignoreFinalizer) * 31 + this.serializableProxy;
/*     */   }
/*     */   
/* 147 */   protected enum AbstractMethodErrorThrow implements StackManipulation { INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final transient StackManipulation implementation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AbstractMethodErrorThrow() {
/*     */       TypeDescription typeDescription;
/* 160 */       MethodDescription methodDescription = (MethodDescription)((MethodList)(typeDescription = TypeDescription.ForLoadedType.of(AbstractMethodError.class)).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(0)))).getOnly();
/* 161 */       this
/*     */         
/* 163 */         .implementation = (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, (StackManipulation)MethodInvocation.invoke(methodDescription), (StackManipulation)Throw.INSTANCE });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isValid() {
/* 171 */       return this.implementation.isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 178 */       return this.implementation.apply(param1MethodVisitor, param1Context);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum SilentConstruction
/*     */     implements Implementation
/*     */   {
/* 192 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 198 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ByteCodeAppender appender(Implementation.Target param1Target) {
/* 205 */       return new Appender(param1Target.getInstrumentedType(), (byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class Appender
/*     */       implements ByteCodeAppender
/*     */     {
/*     */       public static final String REFLECTION_FACTORY_INTERNAL_NAME = "sun/reflect/ReflectionFactory";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String GET_REFLECTION_FACTORY_METHOD_NAME = "getReflectionFactory";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String GET_REFLECTION_FACTORY_METHOD_DESCRIPTOR = "()Lsun/reflect/ReflectionFactory;";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_NAME = "newConstructorForSerialization";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_DESCRIPTOR = "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;)Ljava/lang/reflect/Constructor;";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String JAVA_LANG_OBJECT_DESCRIPTOR = "Ljava/lang/Object;";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String JAVA_LANG_OBJECT_INTERNAL_NAME = "java/lang/Object";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String JAVA_LANG_CONSTRUCTOR_INTERNAL_NAME = "java/lang/reflect/Constructor";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String NEW_INSTANCE_METHOD_NAME = "newInstance";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String NEW_INSTANCE_METHOD_DESCRIPTOR = "([Ljava/lang/Object;)Ljava/lang/Object;";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String JAVA_LANG_CLASS_INTERNAL_NAME = "java/lang/Class";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String GET_DECLARED_CONSTRUCTOR_METHOD_NAME = "getDeclaredConstructor";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final String GET_DECLARED_CONSTRUCTOR_METHOD_DESCRIPTOR = "([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private Appender(TypeDescription param2TypeDescription) {
/* 292 */         this.instrumentedType = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 299 */         param2MethodVisitor.visitMethodInsn(184, "sun/reflect/ReflectionFactory", "getReflectionFactory", "()Lsun/reflect/ReflectionFactory;", false);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 304 */         param2MethodVisitor.visitLdcInsn(Type.getType(this.instrumentedType.getDescriptor()));
/* 305 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
/* 306 */         param2MethodVisitor.visitInsn(3);
/* 307 */         param2MethodVisitor.visitTypeInsn(189, "java/lang/Class");
/* 308 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/Class", "getDeclaredConstructor", "([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;", false);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 313 */         param2MethodVisitor.visitMethodInsn(182, "sun/reflect/ReflectionFactory", "newConstructorForSerialization", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;)Ljava/lang/reflect/Constructor;", false);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 318 */         param2MethodVisitor.visitInsn(3);
/* 319 */         param2MethodVisitor.visitTypeInsn(189, "java/lang/Object");
/* 320 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/reflect/Constructor", "newInstance", "([Ljava/lang/Object;)Ljava/lang/Object;", false);
/*     */ 
/*     */ 
/*     */         
/* 324 */         param2MethodVisitor.visitTypeInsn(192, this.instrumentedType.getInternalName());
/* 325 */         param2MethodVisitor.visitInsn(176);
/* 326 */         return new ByteCodeAppender.Size(4, 0);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((Appender)param2Object).instrumentedType))));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface InvocationFactory
/*     */   {
/*     */     Implementation.SpecialMethodInvocation invoke(Implementation.Target param1Target, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum Default
/*     */       implements InvocationFactory
/*     */     {
/* 362 */       SUPER_METHOD
/*     */       {
/*     */         
/*     */         public final Implementation.SpecialMethodInvocation invoke(Implementation.Target param3Target, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription)
/*     */         {
/* 367 */           return param3Target.invokeDominant(param3MethodDescription.asSignatureToken());
/*     */         }
/*     */       },
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 374 */       DEFAULT_METHOD
/*     */       {
/*     */         
/*     */         public final Implementation.SpecialMethodInvocation invoke(Implementation.Target param3Target, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription)
/*     */         {
/* 379 */           return param3Target.invokeDefault(param3MethodDescription.asSignatureToken(), param3TypeDescription);
/*     */         }
/*     */       };
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
/*     */   public static class ForSuperMethodByConstructor
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final TypeDescription proxiedType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Implementation.Target implementationTarget;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<TypeDescription> constructorParameters;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean ignoreFinalizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean serializableProxy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForSuperMethodByConstructor(TypeDescription param1TypeDescription, Implementation.Target param1Target, List<TypeDescription> param1List, boolean param1Boolean1, boolean param1Boolean2) {
/* 432 */       this.proxiedType = param1TypeDescription;
/* 433 */       this.implementationTarget = param1Target;
/* 434 */       this.constructorParameters = param1List;
/* 435 */       this.ignoreFinalizer = param1Boolean1;
/* 436 */       this.serializableProxy = param1Boolean2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 444 */       TypeDescription typeDescription = param1Context.register(new TypeProxy(this.proxiedType, this.implementationTarget, TypeProxy.InvocationFactory.Default.SUPER_METHOD, this.ignoreFinalizer, this.serializableProxy));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 449 */       StackManipulation[] arrayOfStackManipulation = new StackManipulation[this.constructorParameters.size()];
/* 450 */       byte b = 0;
/* 451 */       for (TypeDescription typeDescription1 : this.constructorParameters) {
/* 452 */         arrayOfStackManipulation[b++] = DefaultValue.of((TypeDefinition)typeDescription1);
/*     */       }
/* 454 */       return (new StackManipulation.Compound(new StackManipulation[] {
/* 455 */             TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, (StackManipulation)new StackManipulation.Compound(arrayOfStackManipulation), 
/*     */ 
/*     */             
/* 458 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(this.constructorParameters)))).getOnly()), (StackManipulation)Duplication.SINGLE, 
/*     */             
/* 460 */             MethodVariableAccess.loadThis(), 
/* 461 */             FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("target"))).getOnly()).write()
/* 462 */           })).apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.ignoreFinalizer != ((ForSuperMethodByConstructor)param1Object).ignoreFinalizer) ? false : ((this.serializableProxy != ((ForSuperMethodByConstructor)param1Object).serializableProxy) ? false : (!this.proxiedType.equals(((ForSuperMethodByConstructor)param1Object).proxiedType) ? false : (!this.implementationTarget.equals(((ForSuperMethodByConstructor)param1Object).implementationTarget) ? false : (!!this.constructorParameters.equals(((ForSuperMethodByConstructor)param1Object).constructorParameters))))))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return ((((getClass().hashCode() * 31 + this.proxiedType.hashCode()) * 31 + this.implementationTarget.hashCode()) * 31 + this.constructorParameters.hashCode()) * 31 + this.ignoreFinalizer) * 31 + this.serializableProxy;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForSuperMethodByReflectionFactory
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final TypeDescription proxiedType;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Implementation.Target implementationTarget;
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean ignoreFinalizer;
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean serializableProxy;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForSuperMethodByReflectionFactory(TypeDescription param1TypeDescription, Implementation.Target param1Target, boolean param1Boolean1, boolean param1Boolean2) {
/* 507 */       this.proxiedType = param1TypeDescription;
/* 508 */       this.implementationTarget = param1Target;
/* 509 */       this.ignoreFinalizer = param1Boolean1;
/* 510 */       this.serializableProxy = param1Boolean2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 517 */       TypeDescription typeDescription = param1Context.register(new TypeProxy(this.proxiedType, this.implementationTarget, TypeProxy.InvocationFactory.Default.SUPER_METHOD, this.ignoreFinalizer, this.serializableProxy));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 522 */       return (new StackManipulation.Compound(new StackManipulation[] {
/* 523 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named("make").and((ElementMatcher)ElementMatchers.takesArguments(0)))).getOnly()), (StackManipulation)Duplication.SINGLE, 
/*     */             
/* 525 */             MethodVariableAccess.loadThis(), 
/* 526 */             FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("target"))).getOnly()).write()
/* 527 */           })).apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.ignoreFinalizer != ((ForSuperMethodByReflectionFactory)param1Object).ignoreFinalizer) ? false : ((this.serializableProxy != ((ForSuperMethodByReflectionFactory)param1Object).serializableProxy) ? false : (!this.proxiedType.equals(((ForSuperMethodByReflectionFactory)param1Object).proxiedType) ? false : (!!this.implementationTarget.equals(((ForSuperMethodByReflectionFactory)param1Object).implementationTarget)))))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (((getClass().hashCode() * 31 + this.proxiedType.hashCode()) * 31 + this.implementationTarget.hashCode()) * 31 + this.ignoreFinalizer) * 31 + this.serializableProxy;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForDefaultMethod
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final TypeDescription proxiedType;
/*     */ 
/*     */     
/*     */     private final Implementation.Target implementationTarget;
/*     */ 
/*     */     
/*     */     private final boolean serializableProxy;
/*     */ 
/*     */ 
/*     */     
/*     */     public ForDefaultMethod(TypeDescription param1TypeDescription, Implementation.Target param1Target, boolean param1Boolean) {
/* 563 */       this.proxiedType = param1TypeDescription;
/* 564 */       this.implementationTarget = param1Target;
/* 565 */       this.serializableProxy = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 572 */       TypeDescription typeDescription = param1Context.register(new TypeProxy(this.proxiedType, this.implementationTarget, TypeProxy.InvocationFactory.Default.DEFAULT_METHOD, true, this.serializableProxy));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 577 */       return (new StackManipulation.Compound(new StackManipulation[] {
/* 578 */             TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, 
/*     */             
/* 580 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly()), (StackManipulation)Duplication.SINGLE, 
/*     */             
/* 582 */             MethodVariableAccess.loadThis(), 
/* 583 */             FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("target"))).getOnly()).write()
/* 584 */           })).apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.serializableProxy != ((ForDefaultMethod)param1Object).serializableProxy) ? false : (!this.proxiedType.equals(((ForDefaultMethod)param1Object).proxiedType) ? false : (!!this.implementationTarget.equals(((ForDefaultMethod)param1Object).implementationTarget))))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return ((getClass().hashCode() * 31 + this.proxiedType.hashCode()) * 31 + this.implementationTarget.hashCode()) * 31 + this.serializableProxy;
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class MethodCall
/*     */     implements Implementation
/*     */   {
/*     */     private final MethodAccessorFactory methodAccessorFactory;
/*     */     
/*     */     protected MethodCall(TypeProxy this$0, MethodAccessorFactory param1MethodAccessorFactory) {
/* 605 */       this.methodAccessorFactory = param1MethodAccessorFactory;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 612 */       return param1InstrumentedType.withField(new FieldDescription.Token("target", 65, 
/*     */             
/* 614 */             TypeProxy.a(this.a).getInstrumentedType().asGenericType()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 621 */       return new Appender(this, param1Target.getInstrumentedType());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.methodAccessorFactory.equals(((MethodCall)param1Object).methodAccessorFactory) ? false : (!!this.a.equals(((MethodCall)param1Object).a)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.methodAccessorFactory.hashCode()) * 31 + this.a.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance(includeSyntheticFields = true)
/*     */     protected class Appender
/*     */       implements ByteCodeAppender
/*     */     {
/*     */       private final StackManipulation fieldLoadingInstruction;
/*     */       
/*     */       protected Appender(TypeProxy.MethodCall this$0, TypeDescription param2TypeDescription) {
/* 641 */         this.fieldLoadingInstruction = FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)param2TypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named("target"))).getOnly()).read();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/*     */         Implementation.SpecialMethodInvocation specialMethodInvocation;
/* 651 */         StackManipulation.Size size = ((specialMethodInvocation = TypeProxy.c(this.a.a).invoke(TypeProxy.a(this.a.a), TypeProxy.b(this.a.a), param2MethodDescription)).isValid() ? new AccessorMethodInvocation(this, param2MethodDescription, specialMethodInvocation) : TypeProxy.AbstractMethodErrorThrow.INSTANCE).apply(param2MethodVisitor, param2Context);
/* 652 */         return new ByteCodeAppender.Size(size.getMaximalSize(), param2MethodDescription.getStackSize());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldLoadingInstruction.equals(((Appender)param2Object).fieldLoadingInstruction) ? false : (!!this.a.equals(((Appender)param2Object).a)))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.fieldLoadingInstruction.hashCode()) * 31 + this.a.hashCode();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance(includeSyntheticFields = true)
/*     */       protected class AccessorMethodInvocation
/*     */         implements StackManipulation
/*     */       {
/*     */         private final MethodDescription instrumentedMethod;
/*     */ 
/*     */         
/*     */         private final Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */ 
/*     */         
/*     */         protected AccessorMethodInvocation(TypeProxy.MethodCall.Appender this$0, MethodDescription param3MethodDescription, Implementation.SpecialMethodInvocation param3SpecialMethodInvocation) {
/* 680 */           this.instrumentedMethod = param3MethodDescription;
/* 681 */           this.specialMethodInvocation = param3SpecialMethodInvocation;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean isValid() {
/* 688 */           return this.specialMethodInvocation.isValid();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public StackManipulation.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/* 695 */           MethodDescription.InDefinedShape inDefinedShape = TypeProxy.MethodCall.a(this.a.a).registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.DEFAULT);
/* 696 */           return (new StackManipulation.Compound(new StackManipulation[] {
/* 697 */                 MethodVariableAccess.loadThis(), 
/* 698 */                 TypeProxy.MethodCall.Appender.a(this.a), 
/* 699 */                 (StackManipulation)MethodVariableAccess.allArgumentsOf(this.instrumentedMethod).asBridgeOf((MethodDescription)inDefinedShape), 
/* 700 */                 (StackManipulation)MethodInvocation.invoke(inDefinedShape), 
/* 701 */                 MethodReturn.of((TypeDefinition)this.instrumentedMethod.getReturnType())
/* 702 */               })).apply(param3MethodVisitor, param3Context);
/*     */         }
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.instrumentedMethod.equals(((AccessorMethodInvocation)param3Object).instrumentedMethod) ? false : (!this.specialMethodInvocation.equals(((AccessorMethodInvocation)param3Object).specialMethodInvocation) ? false : (!!this.a.equals(((AccessorMethodInvocation)param3Object).a))))));
/*     */         }
/*     */         
/*     */         public int hashCode() {
/*     */           return ((getClass().hashCode() * 31 + this.instrumentedMethod.hashCode()) * 31 + this.specialMethodInvocation.hashCode()) * 31 + this.a.hashCode();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\auxiliary\TypeProxy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */