/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
/*     */ import net.bytebuddy.implementation.bytecode.constant.LongConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.JavaConstant;
/*     */ import net.bytebuddy.utility.JavaType;
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
/*     */ @Enhance
/*     */ public abstract class FixedValue
/*     */   implements Implementation
/*     */ {
/*     */   protected final Assigner assigner;
/*     */   protected final Assigner.Typing typing;
/*     */   
/*     */   protected FixedValue(Assigner paramAssigner, Assigner.Typing paramTyping) {
/*  66 */     this.assigner = paramAssigner;
/*  67 */     this.typing = paramTyping;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AssignerConfigurable value(Object paramObject) {
/*  93 */     if (paramObject instanceof JavaConstant)
/*  94 */       return value((JavaConstant)paramObject); 
/*  95 */     if (paramObject instanceof TypeDescription) {
/*  96 */       return value((TypeDescription)paramObject);
/*     */     }
/*     */     Class<?> clazz;
/*  99 */     if ((clazz = paramObject.getClass()) == String.class)
/* 100 */       return new ForPoolValue((StackManipulation)new TextConstant((String)paramObject), TypeDescription.ForLoadedType.of(String.class)); 
/* 101 */     if (clazz == Class.class)
/* 102 */       return new ForPoolValue(ClassConstant.of(TypeDescription.ForLoadedType.of((Class)paramObject)), TypeDescription.ForLoadedType.of(Class.class)); 
/* 103 */     if (clazz == Boolean.class)
/* 104 */       return new ForPoolValue(IntegerConstant.forValue(((Boolean)paramObject).booleanValue()), boolean.class); 
/* 105 */     if (clazz == Byte.class)
/* 106 */       return new ForPoolValue(IntegerConstant.forValue(((Byte)paramObject).byteValue()), byte.class); 
/* 107 */     if (clazz == Short.class)
/* 108 */       return new ForPoolValue(IntegerConstant.forValue(((Short)paramObject).shortValue()), short.class); 
/* 109 */     if (clazz == Character.class)
/* 110 */       return new ForPoolValue(IntegerConstant.forValue(((Character)paramObject).charValue()), char.class); 
/* 111 */     if (clazz == Integer.class)
/* 112 */       return new ForPoolValue(IntegerConstant.forValue(((Integer)paramObject).intValue()), int.class); 
/* 113 */     if (clazz == Long.class)
/* 114 */       return new ForPoolValue(LongConstant.forValue(((Long)paramObject).longValue()), long.class); 
/* 115 */     if (clazz == Float.class)
/* 116 */       return new ForPoolValue(FloatConstant.forValue(((Float)paramObject).floatValue()), float.class); 
/* 117 */     if (clazz == Double.class)
/* 118 */       return new ForPoolValue(DoubleConstant.forValue(((Double)paramObject).doubleValue()), double.class); 
/* 119 */     if (JavaType.METHOD_HANDLE.getTypeStub().isAssignableFrom(clazz))
/* 120 */       return new ForPoolValue((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.ofLoaded(paramObject)), clazz); 
/* 121 */     if (JavaType.METHOD_TYPE.getTypeStub().represents(clazz)) {
/* 122 */       return new ForPoolValue((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodType.ofLoaded(paramObject)), clazz);
/*     */     }
/* 124 */     return reference(paramObject);
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
/*     */   public static AssignerConfigurable reference(Object paramObject) {
/* 140 */     return reference(paramObject, "value$" + RandomString.hashOf(paramObject));
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
/*     */   public static AssignerConfigurable reference(Object paramObject, String paramString) {
/* 154 */     return new ForValue(paramObject, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AssignerConfigurable value(TypeDescription paramTypeDescription) {
/* 164 */     return new ForPoolValue(ClassConstant.of(paramTypeDescription), TypeDescription.ForLoadedType.of(Class.class));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AssignerConfigurable value(JavaConstant paramJavaConstant) {
/* 174 */     return new ForPoolValue((StackManipulation)new JavaConstantValue(paramJavaConstant), paramJavaConstant.getTypeDescription());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AssignerConfigurable argument(int paramInt) {
/* 184 */     if (paramInt < 0) {
/* 185 */       throw new IllegalArgumentException("Argument index cannot be negative: " + paramInt);
/*     */     }
/* 187 */     return new ForArgument(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AssignerConfigurable self() {
/* 196 */     return new ForThisValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Implementation nullValue() {
/* 205 */     return ForNullValue.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AssignerConfigurable originType() {
/* 214 */     return new ForOriginType();
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
/*     */   
/*     */   protected ByteCodeAppender.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext, MethodDescription paramMethodDescription, TypeDescription.Generic paramGeneric, StackManipulation paramStackManipulation) {
/*     */     StackManipulation stackManipulation;
/* 235 */     if (!(stackManipulation = this.assigner.assign(paramGeneric, paramMethodDescription.getReturnType(), this.typing)).isValid()) {
/* 236 */       throw new IllegalArgumentException("Cannot return value of type " + paramGeneric + " for " + paramMethodDescription);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { paramStackManipulation, stackManipulation, MethodReturn.of((TypeDefinition)paramMethodDescription.getReturnType()) })).apply(paramMethodVisitor, paramContext);
/* 243 */     return new ByteCodeAppender.Size(size.getMaximalSize(), paramMethodDescription.getStackSize());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.typing.equals(((FixedValue)paramObject).typing) ? false : (!!this.assigner.equals(((FixedValue)paramObject).assigner)))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return (getClass().hashCode() * 31 + this.assigner.hashCode()) * 31 + this.typing.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface AssignerConfigurable
/*     */     extends Implementation
/*     */   {
/*     */     Implementation withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum ForNullValue
/*     */     implements Implementation, ByteCodeAppender
/*     */   {
/* 271 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ByteCodeAppender appender(Implementation.Target param1Target) {
/* 277 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 284 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 291 */       if (param1MethodDescription.getReturnType().isPrimitive()) {
/* 292 */         throw new IllegalStateException("Cannot return null from " + param1MethodDescription);
/*     */       }
/* 294 */       return (new ByteCodeAppender.Simple(new StackManipulation[] { (StackManipulation)NullConstant.INSTANCE, (StackManipulation)MethodReturn.REFERENCE
/*     */ 
/*     */           
/* 297 */           })).apply(param1MethodVisitor, param1Context, param1MethodDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class ForOriginType
/*     */     extends FixedValue
/*     */     implements AssignerConfigurable
/*     */   {
/*     */     protected ForOriginType() {
/* 310 */       this(Assigner.DEFAULT, Assigner.Typing.STATIC);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ForOriginType(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 320 */       super(param1Assigner, param1Typing);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 327 */       return new ForOriginType(param1Assigner, param1Typing);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 334 */       return new Appender(this, param1Target.getOriginType().asErasure());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 341 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance(includeSyntheticFields = true)
/*     */     protected class Appender
/*     */       implements ByteCodeAppender
/*     */     {
/*     */       private final TypeDescription originType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Appender(FixedValue.ForOriginType this$0, TypeDescription param2TypeDescription) {
/* 361 */         this.originType = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 368 */         return this.a.apply(param2MethodVisitor, param2Context, param2MethodDescription, 
/*     */ 
/*     */             
/* 371 */             TypeDescription.ForLoadedType.of(Class.class).asGenericType(), 
/* 372 */             ClassConstant.of(this.originType));
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.originType.equals(((Appender)param2Object).originType) ? false : (!!this.a.equals(((Appender)param2Object).a)))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.originType.hashCode()) * 31 + this.a.hashCode();
/*     */       } }
/*     */   }
/*     */   
/*     */   protected static class ForThisValue extends FixedValue implements AssignerConfigurable {
/*     */     protected ForThisValue() {
/* 386 */       super(Assigner.DEFAULT, Assigner.Typing.STATIC);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ForThisValue(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 396 */       super(param1Assigner, param1Typing);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 403 */       return new Appender(param1Target.getInstrumentedType());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 410 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 417 */       return new ForThisValue(param1Assigner, param1Typing);
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
/*     */       private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Appender(TypeDescription param2TypeDescription) {
/* 437 */         this.instrumentedType = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 444 */         if (param2MethodDescription.isStatic() || !this.instrumentedType.isAssignableTo(param2MethodDescription.getReturnType().asErasure())) {
/* 445 */           throw new IllegalStateException("Cannot return 'this' from " + param2MethodDescription);
/*     */         }
/* 447 */         return (new ByteCodeAppender.Simple(new StackManipulation[] {
/* 448 */               MethodVariableAccess.loadThis(), (StackManipulation)MethodReturn.REFERENCE
/*     */             
/* 450 */             })).apply(param2MethodVisitor, param2Context, param2MethodDescription);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((Appender)param2Object).instrumentedType))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   protected static class ForArgument
/*     */     extends FixedValue
/*     */     implements AssignerConfigurable, ByteCodeAppender
/*     */   {
/*     */     private final int index;
/*     */     
/*     */     protected ForArgument(int param1Int) {
/* 472 */       this(Assigner.DEFAULT, Assigner.Typing.STATIC, param1Int);
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
/*     */     private ForArgument(Assigner param1Assigner, Assigner.Typing param1Typing, int param1Int) {
/* 484 */       super(param1Assigner, param1Typing);
/* 485 */       this.index = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 492 */       if (param1MethodDescription.getParameters().size() <= this.index) {
/* 493 */         throw new IllegalStateException(param1MethodDescription + " does not define a parameter with index " + this.index);
/*     */       }
/* 495 */       ParameterDescription parameterDescription = (ParameterDescription)param1MethodDescription.getParameters().get(this.index);
/*     */ 
/*     */       
/*     */       StackManipulation.Compound compound;
/*     */ 
/*     */       
/* 501 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(parameterDescription), this.assigner.assign(parameterDescription.getType(), param1MethodDescription.getReturnType(), this.typing), MethodReturn.of((TypeDefinition)param1MethodDescription.getReturnType()) })).isValid()) {
/* 502 */         throw new IllegalStateException("Cannot assign " + param1MethodDescription.getReturnType() + " to " + parameterDescription);
/*     */       }
/* 504 */       return new ByteCodeAppender.Size(compound.apply(param1MethodVisitor, param1Context).getMaximalSize(), param1MethodDescription.getStackSize());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 511 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 518 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 525 */       return new ForArgument(param1Assigner, param1Typing, this.index);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.index != ((ForArgument)param1Object).index)))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode() * 31 + this.index;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class ForPoolValue
/*     */     extends FixedValue
/*     */     implements AssignerConfigurable, ByteCodeAppender
/*     */   {
/*     */     private final StackManipulation valueLoadInstruction;
/*     */     
/*     */     private final TypeDescription loadedType;
/*     */ 
/*     */     
/*     */     protected ForPoolValue(StackManipulation param1StackManipulation, Class<?> param1Class) {
/* 554 */       this(param1StackManipulation, TypeDescription.ForLoadedType.of(param1Class));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForPoolValue(StackManipulation param1StackManipulation, TypeDescription param1TypeDescription) {
/* 565 */       this(Assigner.DEFAULT, Assigner.Typing.STATIC, param1StackManipulation, param1TypeDescription);
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
/*     */     private ForPoolValue(Assigner param1Assigner, Assigner.Typing param1Typing, StackManipulation param1StackManipulation, TypeDescription param1TypeDescription) {
/* 579 */       super(param1Assigner, param1Typing);
/* 580 */       this.valueLoadInstruction = param1StackManipulation;
/* 581 */       this.loadedType = param1TypeDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 588 */       return new ForPoolValue(param1Assigner, param1Typing, this.valueLoadInstruction, this.loadedType);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 595 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 602 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 609 */       return apply(param1MethodVisitor, param1Context, param1MethodDescription, this.loadedType.asGenericType(), this.valueLoadInstruction);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.valueLoadInstruction.equals(((ForPoolValue)param1Object).valueLoadInstruction) ? false : (!!this.loadedType.equals(((ForPoolValue)param1Object).loadedType))))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (super.hashCode() * 31 + this.valueLoadInstruction.hashCode()) * 31 + this.loadedType.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class ForValue
/*     */     extends FixedValue
/*     */     implements AssignerConfigurable
/*     */   {
/*     */     private static final String PREFIX = "value";
/*     */ 
/*     */     
/*     */     private final String name;
/*     */     
/*     */     private final Object value;
/*     */ 
/*     */     
/*     */     protected ForValue(Object param1Object, String param1String) {
/* 641 */       this(Assigner.DEFAULT, Assigner.Typing.STATIC, param1Object, param1String);
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
/*     */     private ForValue(Assigner param1Assigner, Assigner.Typing param1Typing, Object param1Object, String param1String) {
/* 654 */       super(param1Assigner, param1Typing);
/* 655 */       this.name = param1String;
/* 656 */       this.value = param1Object;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 663 */       return new ForValue(param1Assigner, param1Typing, this.value, this.name);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 670 */       return param1InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4169, 
/*     */             
/* 672 */             TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.value.getClass())), this.value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 679 */       return new StaticFieldByteCodeAppender(param1Target.getInstrumentedType(), (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.name.equals(((ForValue)param1Object).name) ? false : (!!this.value.equals(((ForValue)param1Object).value))))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (super.hashCode() * 31 + this.name.hashCode()) * 31 + this.value.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     private class StaticFieldByteCodeAppender
/*     */       implements ByteCodeAppender
/*     */     {
/*     */       private final StackManipulation fieldGetAccess;
/*     */       
/*     */       private StaticFieldByteCodeAppender(FixedValue.ForValue this$0, TypeDescription param2TypeDescription) {
/* 699 */         this.fieldGetAccess = FieldAccess.forField((FieldDescription.InDefinedShape)((FieldList)param2TypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(FixedValue.ForValue.a(FixedValue.ForValue.this)))).getOnly()).read();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 706 */         return this.a.apply(param2MethodVisitor, param2Context, param2MethodDescription, 
/*     */ 
/*     */             
/* 709 */             TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(FixedValue.ForValue.b(this.a).getClass()), this.fieldGetAccess);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldGetAccess.equals(((StaticFieldByteCodeAppender)param2Object).fieldGetAccess))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.fieldGetAccess.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\FixedValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */