/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.implementation.bytecode.Addition;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Multiplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.jar.asm.Label;
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
/*     */ @Enhance
/*     */ public class HashCodeMethod
/*     */   implements Implementation
/*     */ {
/*     */   private static final int DEFAULT_OFFSET = 17;
/*     */   private static final int DEFAULT_MULTIPLIER = 31;
/*  64 */   private static final MethodDescription.InDefinedShape HASH_CODE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Object.class)
/*  65 */     .getDeclaredMethods()
/*  66 */     .filter((ElementMatcher)ElementMatchers.isHashCode()))
/*  67 */     .getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   private static final MethodDescription.InDefinedShape GET_CLASS = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Object.class)
/*  73 */     .getDeclaredMethods()
/*  74 */     .filter((ElementMatcher)ElementMatchers.named("getClass").and((ElementMatcher)ElementMatchers.takesArguments(0))))
/*  75 */     .getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final OffsetProvider offsetProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int multiplier;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> nonNullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HashCodeMethod(OffsetProvider paramOffsetProvider) {
/* 103 */     this(paramOffsetProvider, 31, ElementMatchers.none(), ElementMatchers.none());
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
/*     */   private HashCodeMethod(OffsetProvider paramOffsetProvider, int paramInt, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> paramJunction1, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> paramJunction2) {
/* 118 */     this.offsetProvider = paramOffsetProvider;
/* 119 */     this.multiplier = paramInt;
/* 120 */     this.ignored = paramJunction1;
/* 121 */     this.nonNullable = paramJunction2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HashCodeMethod usingSuperClassOffset() {
/* 130 */     return new HashCodeMethod(OffsetProvider.ForSuperMethodCall.INSTANCE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HashCodeMethod usingTypeHashOffset(boolean paramBoolean) {
/* 140 */     return new HashCodeMethod(paramBoolean ? OffsetProvider.ForDynamicTypeHash.INSTANCE : OffsetProvider.ForStaticTypeHash.INSTANCE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HashCodeMethod usingDefaultOffset() {
/* 149 */     return usingOffset(17);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HashCodeMethod usingOffset(int paramInt) {
/* 159 */     return new HashCodeMethod(new OffsetProvider.ForFixedValue(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashCodeMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/* 170 */     return new HashCodeMethod(this.offsetProvider, this.multiplier, this.ignored.or(paramElementMatcher), this.nonNullable);
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
/*     */   public HashCodeMethod withNonNullableFields(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/* 182 */     return new HashCodeMethod(this.offsetProvider, this.multiplier, this.ignored, this.nonNullable.or(paramElementMatcher));
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
/*     */   public Implementation withMultiplier(int paramInt) {
/* 194 */     if (paramInt == 0) {
/* 195 */       throw new IllegalArgumentException("Hash code multiplier must not be zero");
/*     */     }
/* 197 */     return new HashCodeMethod(this.offsetProvider, paramInt, this.ignored, this.nonNullable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/* 204 */     return paramInstrumentedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/* 211 */     if (paramTarget.getInstrumentedType().isInterface()) {
/* 212 */       throw new IllegalStateException("Cannot implement meaningful hash code method for " + paramTarget.getInstrumentedType());
/*     */     }
/* 214 */     return new Appender(this.offsetProvider.resolve(paramTarget.getInstrumentedType()), this.multiplier, (List<FieldDescription.InDefinedShape>)paramTarget
/*     */         
/* 216 */         .getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isStatic().or((ElementMatcher)this.ignored))), (ElementMatcher<? super FieldDescription.InDefinedShape>)this.nonNullable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.multiplier != ((HashCodeMethod)paramObject).multiplier) ? false : (!this.offsetProvider.equals(((HashCodeMethod)paramObject).offsetProvider) ? false : (!this.ignored.equals(((HashCodeMethod)paramObject).ignored) ? false : (!!this.nonNullable.equals(((HashCodeMethod)paramObject).nonNullable)))))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return (((getClass().hashCode() * 31 + this.offsetProvider.hashCode()) * 31 + this.multiplier) * 31 + this.ignored.hashCode()) * 31 + this.nonNullable.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForFixedValue
/*     */     implements OffsetProvider
/*     */   {
/*     */     private final int value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForFixedValue(int param1Int) {
/* 250 */       this.value = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation resolve(TypeDescription param1TypeDescription) {
/* 257 */       return IntegerConstant.forValue(this.value);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ForFixedValue)param1Object).value))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.value;
/*     */     } }
/*     */   
/*     */   public enum ForSuperMethodCall implements OffsetProvider {
/* 269 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation resolve(TypeDescription param1TypeDescription) {
/*     */       TypeDescription.Generic generic;
/* 276 */       if ((generic = param1TypeDescription.getSuperClass()) == null) {
/* 277 */         throw new IllegalStateException(param1TypeDescription + " does not declare a super class");
/*     */       }
/* 279 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), MethodInvocation.invoke(HashCodeMethod.a()).special(generic.asErasure()) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ForStaticTypeHash
/*     */     implements OffsetProvider
/*     */   {
/* 291 */     INSTANCE;
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation resolve(TypeDescription param1TypeDescription)
/*     */     {
/* 297 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { ClassConstant.of(param1TypeDescription), MethodInvocation.invoke(HashCodeMethod.a()).virtual(TypeDescription.ForLoadedType.of(Class.class)) }); } } protected static interface OffsetProvider { StackManipulation resolve(TypeDescription param1TypeDescription); @Enhance public static class ForFixedValue implements OffsetProvider { private final int value; protected ForFixedValue(int param2Int) { this.value = param2Int; } public StackManipulation resolve(TypeDescription param2TypeDescription) { return IntegerConstant.forValue(this.value); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!(this.value != ((ForFixedValue)param2Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } public enum ForSuperMethodCall implements OffsetProvider { INSTANCE; public final StackManipulation resolve(TypeDescription param2TypeDescription) { TypeDescription.Generic generic; if ((generic = param2TypeDescription.getSuperClass()) == null) throw new IllegalStateException(param2TypeDescription + " does not declare a super class");  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), MethodInvocation.invoke(HashCodeMethod.a()).special(generic.asErasure()) }); } } public enum ForStaticTypeHash implements OffsetProvider { public final StackManipulation resolve(TypeDescription param2TypeDescription) { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { ClassConstant.of(param2TypeDescription), MethodInvocation.invoke(HashCodeMethod.a()).virtual(TypeDescription.ForLoadedType.of(Class.class)) }); }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       INSTANCE; }
/*     */ 
/*     */ 
/*     */     
/*     */     public enum ForDynamicTypeHash
/*     */       implements OffsetProvider
/*     */     {
/* 309 */       INSTANCE;
/*     */ 
/*     */ 
/*     */       
/*     */       public final StackManipulation resolve(TypeDescription param2TypeDescription)
/*     */       {
/* 315 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), 
/* 316 */               MethodInvocation.invoke(HashCodeMethod.b()).virtual(param2TypeDescription), 
/* 317 */               MethodInvocation.invoke(HashCodeMethod.a()).virtual(TypeDescription.ForLoadedType.of(Class.class)) }); } } } public enum ForDynamicTypeHash implements OffsetProvider { INSTANCE; public final StackManipulation resolve(TypeDescription param1TypeDescription) { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), MethodInvocation.invoke(HashCodeMethod.b()).virtual(param1TypeDescription), MethodInvocation.invoke(HashCodeMethod.a()).virtual(TypeDescription.ForLoadedType.of(Class.class)) }); }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static interface NullValueGuard
/*     */   {
/*     */     StackManipulation before();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StackManipulation after();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int getRequiredVariablePadding();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum NoOp
/*     */       implements NullValueGuard
/*     */     {
/* 356 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final StackManipulation before() {
/* 362 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final StackManipulation after() {
/* 369 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final int getRequiredVariablePadding() {
/* 376 */         return StackSize.ZERO.getSize();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class UsingJump
/*     */       implements NullValueGuard
/*     */     {
/*     */       private final MethodDescription instrumentedMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final Label label;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected UsingJump(MethodDescription param2MethodDescription) {
/* 402 */         this.instrumentedMethod = param2MethodDescription;
/* 403 */         this.label = new Label();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public StackManipulation before() {
/* 410 */         return (StackManipulation)new BeforeInstruction(this);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public StackManipulation after() {
/* 417 */         return (StackManipulation)new AfterInstruction(this);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int getRequiredVariablePadding() {
/* 424 */         return 1;
/*     */       }
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedMethod.equals(((UsingJump)param2Object).instrumentedMethod) ? false : (!!this.label.equals(((UsingJump)param2Object).label)))));
/*     */       }
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.instrumentedMethod.hashCode()) * 31 + this.label.hashCode();
/*     */       }
/*     */       
/*     */       @Enhance(includeSyntheticFields = true)
/*     */       protected class BeforeInstruction extends StackManipulation.AbstractBase { protected BeforeInstruction(HashCodeMethod.NullValueGuard.UsingJump this$0) {}
/*     */         
/*     */         public StackManipulation.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/* 437 */           param3MethodVisitor.visitVarInsn(58, HashCodeMethod.NullValueGuard.UsingJump.a(this.a).getStackSize());
/* 438 */           param3MethodVisitor.visitVarInsn(25, HashCodeMethod.NullValueGuard.UsingJump.a(this.a).getStackSize());
/* 439 */           param3MethodVisitor.visitJumpInsn(198, HashCodeMethod.NullValueGuard.UsingJump.b(this.a));
/* 440 */           param3MethodVisitor.visitVarInsn(25, HashCodeMethod.NullValueGuard.UsingJump.a(this.a).getStackSize());
/* 441 */           return StackManipulation.Size.ZERO;
/*     */         }
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.a.equals(((BeforeInstruction)param3Object).a))));
/*     */         }
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.a.hashCode();
/*     */         } }
/*     */       
/*     */       @Enhance(includeSyntheticFields = true)
/*     */       protected class AfterInstruction extends StackManipulation.AbstractBase { protected AfterInstruction(HashCodeMethod.NullValueGuard.UsingJump this$0) {}
/*     */         
/*     */         public StackManipulation.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/* 455 */           param3MethodVisitor.visitLabel(HashCodeMethod.NullValueGuard.UsingJump.b(this.a));
/* 456 */           param3Context.getFrameGeneration().same1(param3MethodVisitor, 
/* 457 */               (TypeDefinition)TypeDescription.ForLoadedType.of(int.class), 
/* 458 */               (List)Arrays.asList((Object[])new TypeDescription[] { param3Context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class) }));
/* 459 */           return StackManipulation.Size.ZERO;
/*     */         }
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.a.equals(((AfterInstruction)param3Object).a))));
/*     */         }
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.a.hashCode();
/*     */         } }
/*     */     }
/*     */   }
/*     */   
/*     */   protected enum ValueTransformer implements StackManipulation {
/* 473 */     LONG
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 476 */         param2MethodVisitor.visitInsn(92);
/* 477 */         param2MethodVisitor.visitIntInsn(16, 32);
/* 478 */         param2MethodVisitor.visitInsn(125);
/* 479 */         param2MethodVisitor.visitInsn(131);
/* 480 */         param2MethodVisitor.visitInsn(136);
/* 481 */         return new StackManipulation.Size(-1, 3);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 488 */     FLOAT
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 491 */         param2MethodVisitor.visitMethodInsn(184, "java/lang/Float", "floatToIntBits", "(F)I", false);
/* 492 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 499 */     DOUBLE
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 502 */         param2MethodVisitor.visitMethodInsn(184, "java/lang/Double", "doubleToLongBits", "(D)J", false);
/* 503 */         param2MethodVisitor.visitInsn(92);
/* 504 */         param2MethodVisitor.visitIntInsn(16, 32);
/* 505 */         param2MethodVisitor.visitInsn(125);
/* 506 */         param2MethodVisitor.visitInsn(131);
/* 507 */         param2MethodVisitor.visitInsn(136);
/* 508 */         return new StackManipulation.Size(-1, 3);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 515 */     BOOLEAN_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 518 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([Z)I", false);
/* 519 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 526 */     BYTE_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 529 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([B)I", false);
/* 530 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 537 */     SHORT_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 540 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([S)I", false);
/* 541 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 548 */     CHARACTER_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 551 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([C)I", false);
/* 552 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 559 */     INTEGER_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 562 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([I)I", false);
/* 563 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 570 */     LONG_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 573 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([J)I", false);
/* 574 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 581 */     FLOAT_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 584 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([F)I", false);
/* 585 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 592 */     DOUBLE_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 595 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([D)I", false);
/* 596 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 603 */     REFERENCE_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 606 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([Ljava/lang/Object;)I", false);
/* 607 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 614 */     NESTED_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 617 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "deepHashCode", "([Ljava/lang/Object;)I", false);
/* 618 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*     */     public static StackManipulation of(TypeDefinition param1TypeDefinition) {
/* 630 */       if (param1TypeDefinition.represents(boolean.class) || param1TypeDefinition
/* 631 */         .represents(byte.class) || param1TypeDefinition
/* 632 */         .represents(short.class) || param1TypeDefinition
/* 633 */         .represents(char.class) || param1TypeDefinition
/* 634 */         .represents(int.class))
/* 635 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE; 
/* 636 */       if (param1TypeDefinition.represents(long.class))
/* 637 */         return LONG; 
/* 638 */       if (param1TypeDefinition.represents(float.class))
/* 639 */         return FLOAT; 
/* 640 */       if (param1TypeDefinition.represents(double.class))
/* 641 */         return DOUBLE; 
/* 642 */       if (param1TypeDefinition.represents(boolean[].class))
/* 643 */         return BOOLEAN_ARRAY; 
/* 644 */       if (param1TypeDefinition.represents(byte[].class))
/* 645 */         return BYTE_ARRAY; 
/* 646 */       if (param1TypeDefinition.represents(short[].class))
/* 647 */         return SHORT_ARRAY; 
/* 648 */       if (param1TypeDefinition.represents(char[].class))
/* 649 */         return CHARACTER_ARRAY; 
/* 650 */       if (param1TypeDefinition.represents(int[].class))
/* 651 */         return INTEGER_ARRAY; 
/* 652 */       if (param1TypeDefinition.represents(long[].class))
/* 653 */         return LONG_ARRAY; 
/* 654 */       if (param1TypeDefinition.represents(float[].class))
/* 655 */         return FLOAT_ARRAY; 
/* 656 */       if (param1TypeDefinition.represents(double[].class))
/* 657 */         return DOUBLE_ARRAY; 
/* 658 */       if (param1TypeDefinition.isArray()) {
/* 659 */         return param1TypeDefinition.getComponentType().isArray() ? NESTED_ARRAY : REFERENCE_ARRAY;
/*     */       }
/*     */ 
/*     */       
/* 663 */       return MethodInvocation.invoke(HashCodeMethod.a()).virtual(param1TypeDefinition.asErasure());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 671 */       return true;
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
/*     */   protected static class Appender
/*     */     implements ByteCodeAppender
/*     */   {
/*     */     private final StackManipulation initialValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int multiplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<FieldDescription.InDefinedShape> fieldDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Appender(StackManipulation param1StackManipulation, int param1Int, List<FieldDescription.InDefinedShape> param1List, ElementMatcher<? super FieldDescription.InDefinedShape> param1ElementMatcher) {
/* 713 */       this.initialValue = param1StackManipulation;
/* 714 */       this.multiplier = param1Int;
/* 715 */       this.fieldDescriptions = param1List;
/* 716 */       this.nonNullable = param1ElementMatcher;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 723 */       if (param1MethodDescription.isStatic())
/* 724 */         throw new IllegalStateException("Hash code method must not be static: " + param1MethodDescription); 
/* 725 */       if (!param1MethodDescription.getReturnType().represents(int.class)) {
/* 726 */         throw new IllegalStateException("Hash code method does not return primitive integer: " + param1MethodDescription);
/*     */       }
/*     */       ArrayList<StackManipulation> arrayList;
/* 729 */       (arrayList = new ArrayList<StackManipulation>(2 + (this.fieldDescriptions.size() << 3))).add(this.initialValue);
/* 730 */       int i = 0;
/* 731 */       for (FieldDescription.InDefinedShape inDefinedShape : this.fieldDescriptions) {
/* 732 */         arrayList.add(IntegerConstant.forValue(this.multiplier));
/* 733 */         arrayList.add(Multiplication.INTEGER);
/* 734 */         arrayList.add(MethodVariableAccess.loadThis());
/* 735 */         arrayList.add(FieldAccess.forField(inDefinedShape).read());
/* 736 */         HashCodeMethod.NullValueGuard nullValueGuard = (HashCodeMethod.NullValueGuard)((inDefinedShape.getType().isPrimitive() || inDefinedShape.getType().isArray() || this.nonNullable.matches(inDefinedShape)) ? HashCodeMethod.NullValueGuard.NoOp.INSTANCE : new HashCodeMethod.NullValueGuard.UsingJump(param1MethodDescription));
/*     */ 
/*     */         
/* 739 */         arrayList.add(nullValueGuard.before());
/* 740 */         arrayList.add(HashCodeMethod.ValueTransformer.of((TypeDefinition)inDefinedShape.getType()));
/* 741 */         arrayList.add(Addition.INTEGER);
/* 742 */         arrayList.add(nullValueGuard.after());
/* 743 */         i = Math.max(i, nullValueGuard.getRequiredVariablePadding());
/*     */       } 
/* 745 */       arrayList.add(MethodReturn.INTEGER);
/* 746 */       return new ByteCodeAppender.Size((new StackManipulation.Compound(arrayList)).apply(param1MethodVisitor, param1Context).getMaximalSize(), param1MethodDescription.getStackSize() + i);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.multiplier != ((Appender)param1Object).multiplier) ? false : (!this.initialValue.equals(((Appender)param1Object).initialValue) ? false : (!this.fieldDescriptions.equals(((Appender)param1Object).fieldDescriptions) ? false : (!!this.nonNullable.equals(((Appender)param1Object).nonNullable)))))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (((getClass().hashCode() * 31 + this.initialValue.hashCode()) * 31 + this.multiplier) * 31 + this.fieldDescriptions.hashCode()) * 31 + this.nonNullable.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\HashCodeMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */