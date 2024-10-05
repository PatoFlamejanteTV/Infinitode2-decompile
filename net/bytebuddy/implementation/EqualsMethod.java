/*      */ package net.bytebuddy.implementation;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.StackSize;
/*      */ import net.bytebuddy.implementation.bytecode.assign.InstanceCheck;
/*      */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*      */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.Label;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
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
/*      */ @Enhance
/*      */ public class EqualsMethod
/*      */   implements Implementation
/*      */ {
/*   56 */   private static final MethodDescription.InDefinedShape EQUALS = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Object.class)
/*   57 */     .getDeclaredMethods()
/*   58 */     .filter((ElementMatcher)ElementMatchers.isEquals()))
/*   59 */     .getOnly();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final SuperClassCheck superClassCheck;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final TypeCompatibilityCheck typeCompatibilityCheck;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> nonNullable;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Comparator<? super FieldDescription.InDefinedShape> comparator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected EqualsMethod(SuperClassCheck paramSuperClassCheck) {
/*   92 */     this(paramSuperClassCheck, TypeCompatibilityCheck.EXACT, ElementMatchers.none(), ElementMatchers.none(), NaturalOrderComparator.INSTANCE);
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
/*      */   private EqualsMethod(SuperClassCheck paramSuperClassCheck, TypeCompatibilityCheck paramTypeCompatibilityCheck, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> paramJunction1, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> paramJunction2, Comparator<? super FieldDescription.InDefinedShape> paramComparator) {
/*  109 */     this.superClassCheck = paramSuperClassCheck;
/*  110 */     this.typeCompatibilityCheck = paramTypeCompatibilityCheck;
/*  111 */     this.ignored = paramJunction1;
/*  112 */     this.nonNullable = paramJunction2;
/*  113 */     this.comparator = paramComparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static EqualsMethod requiringSuperClassEquality() {
/*  122 */     return new EqualsMethod(SuperClassCheck.ENABLED);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static EqualsMethod isolated() {
/*  131 */     return new EqualsMethod(SuperClassCheck.DISABLED);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/*  142 */     return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored.or(paramElementMatcher), this.nonNullable, this.comparator);
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
/*      */   public EqualsMethod withNonNullableFields(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/*  154 */     return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored, this.nonNullable.or(paramElementMatcher), this.comparator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsMethod withPrimitiveTypedFieldsFirst() {
/*  163 */     return withFieldOrder(TypePropertyComparator.FOR_PRIMITIVE_TYPES);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsMethod withEnumerationTypedFieldsFirst() {
/*  172 */     return withFieldOrder(TypePropertyComparator.FOR_ENUMERATION_TYPES);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsMethod withPrimitiveWrapperTypedFieldsFirst() {
/*  181 */     return withFieldOrder(TypePropertyComparator.FOR_PRIMITIVE_WRAPPER_TYPES);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsMethod withStringTypedFieldsFirst() {
/*  190 */     return withFieldOrder(TypePropertyComparator.FOR_STRING_TYPES);
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
/*      */   public EqualsMethod withFieldOrder(Comparator<? super FieldDescription.InDefinedShape> paramComparator) {
/*  202 */     return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored, this.nonNullable, new CompoundComparator((Comparator<? super FieldDescription.InDefinedShape>[])new Comparator[] { this.comparator, paramComparator }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Implementation withSubclassEquality() {
/*  213 */     return new EqualsMethod(this.superClassCheck, TypeCompatibilityCheck.SUBCLASS, this.ignored, this.nonNullable, this.comparator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/*  220 */     return paramInstrumentedType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/*  227 */     if (paramTarget.getInstrumentedType().isInterface()) {
/*  228 */       throw new IllegalStateException("Cannot implement meaningful equals method for " + paramTarget.getInstrumentedType());
/*      */     }
/*      */     
/*      */     ArrayList<FieldDescription.InDefinedShape> arrayList;
/*      */     
/*  233 */     Collections.sort(arrayList = new ArrayList<FieldDescription.InDefinedShape>((Collection<?>)paramTarget.getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isStatic().or((ElementMatcher)this.ignored)))), this.comparator);
/*  234 */     return new Appender(paramTarget.getInstrumentedType(), (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.superClassCheck
/*  235 */             .resolve(paramTarget.getInstrumentedType()), 
/*  236 */             MethodVariableAccess.loadThis(), MethodVariableAccess.REFERENCE
/*  237 */             .loadFrom(1), 
/*  238 */             ConditionalReturn.onIdentity().returningTrue(), this.typeCompatibilityCheck
/*  239 */             .resolve(paramTarget.getInstrumentedType()) }, ), arrayList, (ElementMatcher<? super FieldDescription.InDefinedShape>)this.nonNullable);
/*      */   }
/*      */   
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.superClassCheck.equals(((EqualsMethod)paramObject).superClassCheck) ? false : (!this.typeCompatibilityCheck.equals(((EqualsMethod)paramObject).typeCompatibilityCheck) ? false : (!this.ignored.equals(((EqualsMethod)paramObject).ignored) ? false : (!this.nonNullable.equals(((EqualsMethod)paramObject).nonNullable) ? false : (!!this.comparator.equals(((EqualsMethod)paramObject).comparator))))))));
/*      */   }
/*      */   
/*      */   public int hashCode() {
/*      */     return ((((getClass().hashCode() * 31 + this.superClassCheck.hashCode()) * 31 + this.typeCompatibilityCheck.hashCode()) * 31 + this.ignored.hashCode()) * 31 + this.nonNullable.hashCode()) * 31 + this.comparator.hashCode();
/*      */   }
/*      */   
/*      */   protected enum SuperClassCheck {
/*  251 */     DISABLED
/*      */     {
/*      */       protected final StackManipulation resolve(TypeDescription param2TypeDescription) {
/*  254 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  261 */     ENABLED
/*      */     {
/*      */       protected final StackManipulation resolve(TypeDescription param2TypeDescription) {
/*      */         TypeDescription.Generic generic;
/*  265 */         if ((generic = param2TypeDescription.getSuperClass()) == null) {
/*  266 */           throw new IllegalStateException(param2TypeDescription + " does not declare a super class");
/*      */         }
/*  268 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), MethodVariableAccess.REFERENCE
/*  269 */               .loadFrom(1), 
/*  270 */               MethodInvocation.invoke(EqualsMethod.a()).special(generic.asErasure()), 
/*  271 */               (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() });
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected abstract StackManipulation resolve(TypeDescription param1TypeDescription);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected enum TypeCompatibilityCheck
/*      */   {
/*  292 */     EXACT
/*      */     {
/*      */       public final StackManipulation resolve(TypeDescription param2TypeDescription) {
/*  295 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.REFERENCE
/*  296 */               .loadFrom(1), 
/*  297 */               (StackManipulation)EqualsMethod.ConditionalReturn.onNullValue(), MethodVariableAccess.REFERENCE
/*  298 */               .loadFrom(0), 
/*  299 */               (StackManipulation)MethodInvocation.invoke(GET_CLASS), MethodVariableAccess.REFERENCE
/*  300 */               .loadFrom(1), 
/*  301 */               (StackManipulation)MethodInvocation.invoke(GET_CLASS), 
/*  302 */               (StackManipulation)EqualsMethod.ConditionalReturn.onNonIdentity()
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             });
/*      */       }
/*      */     },
/*  310 */     SUBCLASS
/*      */     {
/*      */       protected final StackManipulation resolve(TypeDescription param2TypeDescription) {
/*  313 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.REFERENCE
/*  314 */               .loadFrom(1), 
/*  315 */               InstanceCheck.of(param2TypeDescription), 
/*  316 */               (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() });
/*      */       }
/*      */     };
/*      */ 
/*      */     
/*      */     protected abstract StackManipulation resolve(TypeDescription param1TypeDescription);
/*      */ 
/*      */     
/*  324 */     protected static final MethodDescription.InDefinedShape GET_CLASS = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Object.class)
/*  325 */       .getDeclaredMethods()
/*  326 */       .filter((ElementMatcher)ElementMatchers.named("getClass")))
/*  327 */       .getOnly();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*      */     
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static interface NullValueGuard
/*      */   {
/*      */     StackManipulation before();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     StackManipulation after();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int getRequiredVariablePadding();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum NoOp
/*      */       implements NullValueGuard
/*      */     {
/*  372 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final StackManipulation before() {
/*  378 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final StackManipulation after() {
/*  385 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final int getRequiredVariablePadding() {
/*  392 */         return StackSize.ZERO.getSize();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class UsingJump
/*      */       implements NullValueGuard
/*      */     {
/*      */       private final MethodDescription instrumentedMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Label firstValueNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Label secondValueNull;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Label endOfBlock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected UsingJump(MethodDescription param2MethodDescription) {
/*  429 */         this.instrumentedMethod = param2MethodDescription;
/*  430 */         this.firstValueNull = new Label();
/*  431 */         this.secondValueNull = new Label();
/*  432 */         this.endOfBlock = new Label();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation before() {
/*  439 */         return (StackManipulation)new BeforeInstruction(this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation after() {
/*  446 */         return (StackManipulation)new AfterInstruction(this);
/*      */       }
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedMethod.equals(((UsingJump)param2Object).instrumentedMethod) ? false : (!this.firstValueNull.equals(((UsingJump)param2Object).firstValueNull) ? false : (!this.secondValueNull.equals(((UsingJump)param2Object).secondValueNull) ? false : (!!this.endOfBlock.equals(((UsingJump)param2Object).endOfBlock)))))));
/*      */       }
/*      */       
/*      */       public int getRequiredVariablePadding() {
/*  453 */         return 2;
/*      */       }
/*      */       public int hashCode() {
/*      */         return (((getClass().hashCode() * 31 + this.instrumentedMethod.hashCode()) * 31 + this.firstValueNull.hashCode()) * 31 + this.secondValueNull.hashCode()) * 31 + this.endOfBlock.hashCode();
/*      */       }
/*      */       @Enhance(includeSyntheticFields = true)
/*      */       protected class BeforeInstruction extends StackManipulation.AbstractBase { protected BeforeInstruction(EqualsMethod.NullValueGuard.UsingJump this$0) {}
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.a.equals(((BeforeInstruction)param3Object).a))));
/*      */         }
/*      */         
/*      */         public StackManipulation.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/*  466 */           param3MethodVisitor.visitVarInsn(58, EqualsMethod.NullValueGuard.UsingJump.a(this.a).getStackSize());
/*  467 */           param3MethodVisitor.visitVarInsn(58, EqualsMethod.NullValueGuard.UsingJump.a(this.a).getStackSize() + 1);
/*  468 */           param3MethodVisitor.visitVarInsn(25, EqualsMethod.NullValueGuard.UsingJump.a(this.a).getStackSize() + 1);
/*  469 */           param3MethodVisitor.visitVarInsn(25, EqualsMethod.NullValueGuard.UsingJump.a(this.a).getStackSize());
/*  470 */           param3MethodVisitor.visitJumpInsn(198, EqualsMethod.NullValueGuard.UsingJump.b(this.a));
/*  471 */           param3MethodVisitor.visitJumpInsn(198, EqualsMethod.NullValueGuard.UsingJump.c(this.a));
/*  472 */           param3MethodVisitor.visitVarInsn(25, EqualsMethod.NullValueGuard.UsingJump.a(this.a).getStackSize() + 1);
/*  473 */           param3MethodVisitor.visitVarInsn(25, EqualsMethod.NullValueGuard.UsingJump.a(this.a).getStackSize());
/*  474 */           return StackManipulation.Size.ZERO;
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.a.hashCode();
/*      */         } }
/*      */ 
/*      */       
/*      */       @Enhance(includeSyntheticFields = true)
/*      */       protected class AfterInstruction
/*      */         extends StackManipulation.AbstractBase {
/*      */         protected AfterInstruction(EqualsMethod.NullValueGuard.UsingJump this$0) {}
/*      */         
/*      */         public StackManipulation.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/*  488 */           param3MethodVisitor.visitJumpInsn(167, EqualsMethod.NullValueGuard.UsingJump.d(this.a));
/*  489 */           param3MethodVisitor.visitLabel(EqualsMethod.NullValueGuard.UsingJump.b(this.a));
/*  490 */           param3Context.getFrameGeneration().same1(param3MethodVisitor, 
/*  491 */               (TypeDefinition)TypeDescription.ForLoadedType.of(Object.class), 
/*  492 */               (List)Arrays.asList((Object[])new TypeDescription[] { param3Context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class) }));
/*  493 */           param3MethodVisitor.visitJumpInsn(198, EqualsMethod.NullValueGuard.UsingJump.d(this.a));
/*  494 */           param3MethodVisitor.visitLabel(EqualsMethod.NullValueGuard.UsingJump.c(this.a));
/*  495 */           param3Context.getFrameGeneration().same(param3MethodVisitor, 
/*  496 */               (List)Arrays.asList((Object[])new TypeDescription[] { param3Context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class) }));
/*  497 */           param3MethodVisitor.visitInsn(3);
/*  498 */           param3MethodVisitor.visitInsn(172);
/*  499 */           param3MethodVisitor.visitLabel(EqualsMethod.NullValueGuard.UsingJump.d(this.a));
/*  500 */           param3Context.getFrameGeneration().same(param3MethodVisitor, 
/*  501 */               (List)Arrays.asList((Object[])new TypeDescription[] { param3Context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class) }));
/*  502 */           return StackManipulation.Size.ZERO;
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.a.equals(((AfterInstruction)param3Object).a))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.a.hashCode();
/*      */         } }
/*      */     }
/*      */   }
/*      */   
/*      */   protected enum ValueComparator implements StackManipulation {
/*  516 */     LONG
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  519 */         param2MethodVisitor.visitInsn(148);
/*  520 */         return new StackManipulation.Size(-2, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  527 */     FLOAT
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  530 */         param2MethodVisitor.visitMethodInsn(184, "java/lang/Float", "compare", "(FF)I", false);
/*  531 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  538 */     DOUBLE
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  541 */         param2MethodVisitor.visitMethodInsn(184, "java/lang/Double", "compare", "(DD)I", false);
/*  542 */         return new StackManipulation.Size(-2, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  549 */     BOOLEAN_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  552 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([Z[Z)Z", false);
/*  553 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  560 */     BYTE_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  563 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([B[B)Z", false);
/*  564 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  571 */     SHORT_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  574 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([S[S)Z", false);
/*  575 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  582 */     CHARACTER_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  585 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([C[C)Z", false);
/*  586 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  593 */     INTEGER_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  596 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([I[I)Z", false);
/*  597 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  604 */     LONG_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  607 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([J[J)Z", false);
/*  608 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  615 */     FLOAT_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  618 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([F[F)Z", false);
/*  619 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  626 */     DOUBLE_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  629 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([D[D)Z", false);
/*  630 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  637 */     REFERENCE_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  640 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", false);
/*  641 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  648 */     NESTED_ARRAY
/*      */     {
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  651 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "deepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", false);
/*  652 */         return new StackManipulation.Size(-1, 0);
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*      */     public static StackManipulation of(TypeDefinition param1TypeDefinition) {
/*  664 */       if (param1TypeDefinition.represents(boolean.class) || param1TypeDefinition
/*  665 */         .represents(byte.class) || param1TypeDefinition
/*  666 */         .represents(short.class) || param1TypeDefinition
/*  667 */         .represents(char.class) || param1TypeDefinition
/*  668 */         .represents(int.class))
/*  669 */         return (StackManipulation)EqualsMethod.ConditionalReturn.onNonEqualInteger(); 
/*  670 */       if (param1TypeDefinition.represents(long.class))
/*  671 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { LONG, (StackManipulation)EqualsMethod.ConditionalReturn.onNonZeroInteger() }); 
/*  672 */       if (param1TypeDefinition.represents(float.class))
/*  673 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { FLOAT, (StackManipulation)EqualsMethod.ConditionalReturn.onNonZeroInteger() }); 
/*  674 */       if (param1TypeDefinition.represents(double.class))
/*  675 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { DOUBLE, (StackManipulation)EqualsMethod.ConditionalReturn.onNonZeroInteger() }); 
/*  676 */       if (param1TypeDefinition.represents(boolean[].class))
/*  677 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { BOOLEAN_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  678 */       if (param1TypeDefinition.represents(byte[].class))
/*  679 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { BYTE_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  680 */       if (param1TypeDefinition.represents(short[].class))
/*  681 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { SHORT_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  682 */       if (param1TypeDefinition.represents(char[].class))
/*  683 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { CHARACTER_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  684 */       if (param1TypeDefinition.represents(int[].class))
/*  685 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { INTEGER_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  686 */       if (param1TypeDefinition.represents(long[].class))
/*  687 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { LONG_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  688 */       if (param1TypeDefinition.represents(float[].class))
/*  689 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { FLOAT_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  690 */       if (param1TypeDefinition.represents(double[].class))
/*  691 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { DOUBLE_ARRAY, (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() }); 
/*  692 */       if (param1TypeDefinition.isArray()) {
/*  693 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param1TypeDefinition.getComponentType().isArray() ? NESTED_ARRAY : REFERENCE_ARRAY, 
/*      */               
/*  695 */               (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() });
/*      */       }
/*  697 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodInvocation.invoke(EqualsMethod.a()).virtual(param1TypeDefinition.asErasure()), (StackManipulation)EqualsMethod.ConditionalReturn.onZeroInteger() });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isValid() {
/*  705 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class Appender
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final StackManipulation baseline;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<FieldDescription.InDefinedShape> fieldDescriptions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Appender(TypeDescription param1TypeDescription, StackManipulation param1StackManipulation, List<FieldDescription.InDefinedShape> param1List, ElementMatcher<? super FieldDescription.InDefinedShape> param1ElementMatcher) {
/*  747 */       this.instrumentedType = param1TypeDescription;
/*  748 */       this.baseline = param1StackManipulation;
/*  749 */       this.fieldDescriptions = param1List;
/*  750 */       this.nonNullable = param1ElementMatcher;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*  757 */       if (param1MethodDescription.isStatic())
/*  758 */         throw new IllegalStateException("Hash code method must not be static: " + param1MethodDescription); 
/*  759 */       if (param1MethodDescription.getParameters().size() != 1 || ((ParameterDescription)param1MethodDescription.getParameters().getOnly()).getType().isPrimitive())
/*  760 */         throw new IllegalStateException(); 
/*  761 */       if (!param1MethodDescription.getReturnType().represents(boolean.class)) {
/*  762 */         throw new IllegalStateException("Hash code method does not return primitive boolean: " + param1MethodDescription);
/*      */       }
/*      */       ArrayList<StackManipulation> arrayList;
/*  765 */       (arrayList = new ArrayList<StackManipulation>(3 + (this.fieldDescriptions.size() << 3))).add(this.baseline);
/*  766 */       int i = 0;
/*  767 */       for (FieldDescription.InDefinedShape inDefinedShape : this.fieldDescriptions) {
/*  768 */         arrayList.add(MethodVariableAccess.loadThis());
/*  769 */         arrayList.add(FieldAccess.forField(inDefinedShape).read());
/*  770 */         arrayList.add(MethodVariableAccess.REFERENCE.loadFrom(1));
/*  771 */         arrayList.add(TypeCasting.to((TypeDefinition)this.instrumentedType));
/*  772 */         arrayList.add(FieldAccess.forField(inDefinedShape).read());
/*  773 */         EqualsMethod.NullValueGuard nullValueGuard = (EqualsMethod.NullValueGuard)((inDefinedShape.getType().isPrimitive() || inDefinedShape.getType().isArray() || this.nonNullable.matches(inDefinedShape)) ? EqualsMethod.NullValueGuard.NoOp.INSTANCE : new EqualsMethod.NullValueGuard.UsingJump(param1MethodDescription));
/*      */ 
/*      */         
/*  776 */         arrayList.add(nullValueGuard.before());
/*  777 */         arrayList.add(EqualsMethod.ValueComparator.of((TypeDefinition)inDefinedShape.getType()));
/*  778 */         arrayList.add(nullValueGuard.after());
/*  779 */         i = Math.max(i, nullValueGuard.getRequiredVariablePadding());
/*      */       } 
/*  781 */       arrayList.add(IntegerConstant.forValue(true));
/*  782 */       arrayList.add(MethodReturn.INTEGER);
/*  783 */       return new ByteCodeAppender.Size((new StackManipulation.Compound(arrayList)).apply(param1MethodVisitor, param1Context).getMaximalSize(), param1MethodDescription.getStackSize() + i);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.instrumentedType.equals(((Appender)param1Object).instrumentedType) ? false : (!this.baseline.equals(((Appender)param1Object).baseline) ? false : (!this.fieldDescriptions.equals(((Appender)param1Object).fieldDescriptions) ? false : (!!this.nonNullable.equals(((Appender)param1Object).nonNullable)))))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.baseline.hashCode()) * 31 + this.fieldDescriptions.hashCode()) * 31 + this.nonNullable.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*  796 */   protected static class ConditionalReturn extends StackManipulation.AbstractBase { private static final Object[] EMPTY = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int jumpCondition;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ConditionalReturn(int param1Int) {
/*  814 */       this(param1Int, 3);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private ConditionalReturn(int param1Int1, int param1Int2) {
/*  824 */       this.jumpCondition = param1Int1;
/*  825 */       this.value = param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static ConditionalReturn onZeroInteger() {
/*  834 */       return new ConditionalReturn(154);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static ConditionalReturn onNonZeroInteger() {
/*  843 */       return new ConditionalReturn(153);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static ConditionalReturn onNullValue() {
/*  852 */       return new ConditionalReturn(199);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static ConditionalReturn onNonIdentity() {
/*  861 */       return new ConditionalReturn(165);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static ConditionalReturn onIdentity() {
/*  870 */       return new ConditionalReturn(166);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static ConditionalReturn onNonEqualInteger() {
/*  879 */       return new ConditionalReturn(159);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected StackManipulation returningTrue() {
/*  888 */       return (StackManipulation)new ConditionalReturn(this.jumpCondition, 4);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/*  895 */       Label label = new Label();
/*  896 */       param1MethodVisitor.visitJumpInsn(this.jumpCondition, label);
/*  897 */       param1MethodVisitor.visitInsn(this.value);
/*  898 */       param1MethodVisitor.visitInsn(172);
/*  899 */       param1MethodVisitor.visitLabel(label);
/*  900 */       param1Context.getFrameGeneration().same(param1MethodVisitor, 
/*  901 */           (List)Arrays.asList((Object[])new TypeDescription[] { param1Context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class) }));
/*  902 */       return new StackManipulation.Size(-1, 1);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.jumpCondition != ((ConditionalReturn)param1Object).jumpCondition) ? false : (!(this.value != ((ConditionalReturn)param1Object).value)))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.jumpCondition) * 31 + this.value;
/*      */     } }
/*      */   
/*      */   protected enum NaturalOrderComparator implements Comparator<FieldDescription.InDefinedShape> {
/*  914 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int compare(FieldDescription.InDefinedShape param1InDefinedShape1, FieldDescription.InDefinedShape param1InDefinedShape2) {
/*  920 */       return 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected enum TypePropertyComparator
/*      */     implements Comparator<FieldDescription.InDefinedShape>
/*      */   {
/*  932 */     FOR_PRIMITIVE_TYPES
/*      */     {
/*      */       protected final boolean resolve(TypeDefinition param2TypeDefinition) {
/*  935 */         return param2TypeDefinition.isPrimitive();
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  942 */     FOR_ENUMERATION_TYPES
/*      */     {
/*      */       protected final boolean resolve(TypeDefinition param2TypeDefinition) {
/*  945 */         return param2TypeDefinition.isEnum();
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  952 */     FOR_STRING_TYPES
/*      */     {
/*      */       protected final boolean resolve(TypeDefinition param2TypeDefinition) {
/*  955 */         return param2TypeDefinition.represents(String.class);
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  962 */     FOR_PRIMITIVE_WRAPPER_TYPES
/*      */     {
/*      */       protected final boolean resolve(TypeDefinition param2TypeDefinition) {
/*  965 */         return param2TypeDefinition.asErasure().isPrimitiveWrapper();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int compare(FieldDescription.InDefinedShape param1InDefinedShape1, FieldDescription.InDefinedShape param1InDefinedShape2) {
/*  973 */       if (resolve((TypeDefinition)param1InDefinedShape1.getType()) && !resolve((TypeDefinition)param1InDefinedShape2.getType()))
/*  974 */         return -1; 
/*  975 */       if (!resolve((TypeDefinition)param1InDefinedShape1.getType()) && resolve((TypeDefinition)param1InDefinedShape2.getType())) {
/*  976 */         return 1;
/*      */       }
/*  978 */       return 0;
/*      */     }
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
/*      */     protected abstract boolean resolve(TypeDefinition param1TypeDefinition);
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
/*      */   @Enhance
/*      */   @SuppressFBWarnings(value = {"SE_COMPARATOR_SHOULD_BE_SERIALIZABLE"}, justification = "Not used within a serializable instance")
/*      */   protected static class CompoundComparator
/*      */     implements Comparator<FieldDescription.InDefinedShape>
/*      */   {
/*      */     protected CompoundComparator(Comparator<? super FieldDescription.InDefinedShape>... param1VarArgs) {
/* 1010 */       this(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1019 */     private final List<Comparator<? super FieldDescription.InDefinedShape>> comparators = new ArrayList<Comparator<? super FieldDescription.InDefinedShape>>(); protected CompoundComparator(List<? extends Comparator<? super FieldDescription.InDefinedShape>> param1List) {
/* 1020 */       for (Iterator<? extends Comparator<? super FieldDescription.InDefinedShape>> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 1021 */         Comparator<? super FieldDescription.InDefinedShape> comparator; if (comparator = iterator.next() instanceof CompoundComparator) {
/* 1022 */           this.comparators.addAll(((CompoundComparator)comparator).comparators); continue;
/* 1023 */         }  if (!(comparator instanceof EqualsMethod.NaturalOrderComparator)) {
/* 1024 */           this.comparators.add(comparator);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int compare(FieldDescription.InDefinedShape param1InDefinedShape1, FieldDescription.InDefinedShape param1InDefinedShape2) {
/* 1033 */       for (Iterator<Comparator<? super FieldDescription.InDefinedShape>> iterator = this.comparators.iterator(); iterator.hasNext();) {
/*      */         
/* 1035 */         if ((i = (comparator = (Comparator)iterator.next()).compare(param1InDefinedShape1, param1InDefinedShape2)) != 0) {
/* 1036 */           return i;
/*      */         }
/*      */       } 
/* 1039 */       return 0;
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.comparators.hashCode();
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.comparators.equals(((CompoundComparator)param1Object).comparators))));
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\EqualsMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */