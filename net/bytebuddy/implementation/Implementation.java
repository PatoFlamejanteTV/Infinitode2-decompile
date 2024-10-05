/*      */ package net.bytebuddy.implementation;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.method.ParameterList;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.DynamicType;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeInitializer;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeWriter;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*      */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.ClassVisitor;
/*      */ import net.bytebuddy.jar.asm.FieldVisitor;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.jar.asm.Opcodes;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.RandomString;
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
/*      */ public interface Implementation
/*      */   extends InstrumentedType.Prepareable
/*      */ {
/*      */   ByteCodeAppender appender(Target paramTarget);
/*      */   
/*      */   public static interface Composable
/*      */     extends Implementation
/*      */   {
/*      */     Implementation andThen(Implementation param1Implementation);
/*      */     
/*      */     Composable andThen(Composable param1Composable);
/*      */   }
/*      */   
/*      */   public static interface SpecialMethodInvocation
/*      */     extends StackManipulation
/*      */   {
/*      */     MethodDescription getMethodDescription();
/*      */     
/*      */     TypeDescription getTypeDescription();
/*      */     
/*      */     SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken param1TypeToken);
/*      */     
/*      */     public enum Illegal
/*      */       implements SpecialMethodInvocation
/*      */     {
/*  145 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isValid() {
/*  151 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  158 */         throw new IllegalStateException("Cannot implement an undefined method");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDescription getMethodDescription() {
/*  165 */         throw new IllegalStateException("An illegal special method invocation must not be applied");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final TypeDescription getTypeDescription() {
/*  172 */         throw new IllegalStateException("An illegal special method invocation must not be applied");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Implementation.SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken param2TypeToken) {
/*  179 */         return this;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static abstract class AbstractBase
/*      */       extends StackManipulation.AbstractBase
/*      */       implements SpecialMethodInvocation
/*      */     {
/*      */       @Enhance("hashCode")
/*      */       public int hashCode() {
/*  191 */         AbstractBase abstractBase = this; int i, j; if (!(i = ((j = this.hashCode) != 0) ? 0 : (31 * abstractBase.getMethodDescription().asSignatureToken().hashCode() + abstractBase.getTypeDescription().hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*  196 */         if (this == param2Object)
/*  197 */           return true; 
/*  198 */         if (!(param2Object instanceof Implementation.SpecialMethodInvocation)) {
/*  199 */           return false;
/*      */         }
/*  201 */         param2Object = param2Object;
/*  202 */         if (getMethodDescription().asSignatureToken().equals(param2Object.getMethodDescription().asSignatureToken()) && 
/*  203 */           getTypeDescription().equals(param2Object.getTypeDescription())) return true;
/*      */         
/*      */         return false;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Simple
/*      */       extends AbstractBase
/*      */     {
/*      */       private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final StackManipulation stackManipulation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Simple(MethodDescription param2MethodDescription, TypeDescription param2TypeDescription, StackManipulation param2StackManipulation) {
/*  236 */         this.methodDescription = param2MethodDescription;
/*  237 */         this.typeDescription = param2TypeDescription;
/*  238 */         this.stackManipulation = param2StackManipulation;
/*      */       }
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
/*      */       public static Implementation.SpecialMethodInvocation of(MethodDescription param2MethodDescription, TypeDescription param2TypeDescription) {
/*      */         StackManipulation stackManipulation;
/*  252 */         return (Implementation.SpecialMethodInvocation)((stackManipulation = MethodInvocation.invoke(param2MethodDescription).special(param2TypeDescription)).isValid() ? new Simple(param2MethodDescription, param2TypeDescription, stackManipulation) : Implementation.SpecialMethodInvocation.Illegal.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription getMethodDescription() {
/*  261 */         return this.methodDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getTypeDescription() {
/*  268 */         return this.typeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  275 */         return this.stackManipulation.apply(param2MethodVisitor, param2Context);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken param2TypeToken) {
/*  282 */         if (this.methodDescription.asTypeToken().equals(param2TypeToken)) {
/*  283 */           return this;
/*      */         }
/*  285 */         return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*      */       }
/*      */     }
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
/*      */   public static interface Target
/*      */   {
/*      */     TypeDescription getInstrumentedType();
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
/*      */     TypeDefinition getOriginType();
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
/*      */     Implementation.SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken param1SignatureToken);
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
/*      */     Implementation.SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken param1SignatureToken);
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
/*      */     Implementation.SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken param1SignatureToken, TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Implementation.SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken param1SignatureToken);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static abstract class AbstractBase
/*      */       implements Target
/*      */     {
/*      */       protected final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected final MethodGraph.Linked methodGraph;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected final DefaultMethodInvocation defaultMethodInvocation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected AbstractBase(TypeDescription param2TypeDescription, MethodGraph.Linked param2Linked, DefaultMethodInvocation param2DefaultMethodInvocation) {
/*  398 */         this.instrumentedType = param2TypeDescription;
/*  399 */         this.methodGraph = param2Linked;
/*  400 */         this.defaultMethodInvocation = param2DefaultMethodInvocation;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getInstrumentedType() {
/*  407 */         return this.instrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken param2SignatureToken) {
/*  414 */         Implementation.SpecialMethodInvocation specialMethodInvocation = Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*  415 */         for (TypeDescription typeDescription : this.instrumentedType.getInterfaces().asErasures()) {
/*      */           Implementation.SpecialMethodInvocation specialMethodInvocation1;
/*  417 */           if ((specialMethodInvocation1 = invokeDefault(param2SignatureToken, typeDescription).withCheckedCompatibilityTo(param2SignatureToken.asTypeToken())).isValid()) {
/*  418 */             if (specialMethodInvocation.isValid()) {
/*  419 */               return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*      */             }
/*  421 */             specialMethodInvocation = specialMethodInvocation1;
/*      */           } 
/*      */         } 
/*      */         
/*  425 */         return specialMethodInvocation;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken param2SignatureToken, TypeDescription param2TypeDescription) {
/*  432 */         return this.defaultMethodInvocation.apply(this.methodGraph.getInterfaceGraph(param2TypeDescription).locate(param2SignatureToken), param2TypeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken param2SignatureToken) {
/*      */         Implementation.SpecialMethodInvocation specialMethodInvocation;
/*  440 */         return (specialMethodInvocation = invokeSuper(param2SignatureToken)).isValid() ? specialMethodInvocation : 
/*      */           
/*  442 */           invokeDefault(param2SignatureToken);
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.defaultMethodInvocation.equals(((AbstractBase)param2Object).defaultMethodInvocation) ? false : (!this.instrumentedType.equals(((AbstractBase)param2Object).instrumentedType) ? false : (!!this.methodGraph.equals(((AbstractBase)param2Object).methodGraph))))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.methodGraph.hashCode()) * 31 + this.defaultMethodInvocation.hashCode();
/*      */       }
/*      */       
/*  453 */       protected enum DefaultMethodInvocation { ENABLED
/*      */         {
/*      */           protected final Implementation.SpecialMethodInvocation apply(MethodGraph.Node param4Node, TypeDescription param4TypeDescription) {
/*  456 */             if (param4Node.getSort().isUnique())
/*  457 */               return Implementation.SpecialMethodInvocation.Simple.of(param4Node.getRepresentative(), param4TypeDescription);  return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  465 */         DISABLED
/*      */         {
/*      */           protected final Implementation.SpecialMethodInvocation apply(MethodGraph.Node param4Node, TypeDescription param4TypeDescription) {
/*  468 */             return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
/*      */           }
/*      */         };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static DefaultMethodInvocation of(ClassFileVersion param3ClassFileVersion) {
/*  479 */           return param3ClassFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? ENABLED : DISABLED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract Implementation.SpecialMethodInvocation apply(MethodGraph.Node param3Node, TypeDescription param3TypeDescription); }
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Factory
/*      */     {
/*      */       Implementation.Target make(TypeDescription param2TypeDescription, MethodGraph.Linked param2Linked, ClassFileVersion param2ClassFileVersion);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Context
/*      */     extends MethodAccessorFactory
/*      */   {
/*      */     TypeDescription register(AuxiliaryType param1AuxiliaryType);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     FieldDescription.InDefinedShape cache(StackManipulation param1StackManipulation, TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TypeDescription getInstrumentedType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ClassFileVersion getClassFileVersion();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     FrameGeneration getFrameGeneration();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum FrameGeneration
/*      */     {
/*  557 */       GENERATE(true)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void generate(MethodVisitor param3MethodVisitor, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2, int param3Int4, @MaybeNull Object[] param3ArrayOfObject3)
/*      */         {
/*  567 */           param3MethodVisitor.visitFrame(param3Int1, param3Int3, param3ArrayOfObject2, param3Int2, param3ArrayOfObject1);
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  574 */       EXPAND(true)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void generate(MethodVisitor param3MethodVisitor, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2, int param3Int4, @MaybeNull Object[] param3ArrayOfObject3)
/*      */         {
/*  584 */           param3MethodVisitor.visitFrame(-1, param3Int4, param3ArrayOfObject3, param3Int2, param3ArrayOfObject1);
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  591 */       DISABLED(false)
/*      */       {
/*      */         public final void generate(MethodVisitor param3MethodVisitor, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2, int param3Int4, @MaybeNull Object[] param3ArrayOfObject3) {}
/*      */       };
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
/*  608 */       private static final Object[] EMPTY = new Object[0];
/*      */ 
/*      */       
/*      */       private final boolean active;
/*      */ 
/*      */ 
/*      */       
/*      */       static {
/*      */       
/*      */       }
/*      */ 
/*      */       
/*      */       FrameGeneration(boolean param2Boolean) {
/*  621 */         this.active = param2Boolean;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isActive() {
/*  630 */         return this.active;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void same(MethodVisitor param2MethodVisitor, List<? extends TypeDefinition> param2List) {
/*  641 */         generate(param2MethodVisitor, 3, EMPTY.length, EMPTY, EMPTY.length, EMPTY, param2List
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  647 */             .size(), 
/*  648 */             toStackMapFrames(param2List));
/*      */       }
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
/*      */       public void same1(MethodVisitor param2MethodVisitor, TypeDefinition param2TypeDefinition, List<? extends TypeDefinition> param2List) {
/*  661 */         generate(param2MethodVisitor, 4, 1, new Object[] {
/*      */ 
/*      */               
/*  664 */               toStackMapFrame(param2TypeDefinition) }, EMPTY.length, EMPTY, param2List
/*      */ 
/*      */             
/*  667 */             .size(), 
/*  668 */             toStackMapFrames(param2List));
/*      */       }
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
/*      */       public void append(MethodVisitor param2MethodVisitor, List<? extends TypeDefinition> param2List1, List<? extends TypeDefinition> param2List2) {
/*  681 */         generate(param2MethodVisitor, 1, EMPTY.length, EMPTY, param2List1
/*      */ 
/*      */ 
/*      */             
/*  685 */             .size(), 
/*  686 */             toStackMapFrames(param2List1), param2List2
/*  687 */             .size() + param2List1.size(), 
/*  688 */             toStackMapFrames(CompoundList.of(param2List2, param2List1)));
/*      */       }
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
/*      */       public void chop(MethodVisitor param2MethodVisitor, int param2Int, List<? extends TypeDefinition> param2List) {
/*  701 */         generate(param2MethodVisitor, 2, EMPTY.length, EMPTY, param2Int, EMPTY, param2List
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  707 */             .size(), 
/*  708 */             toStackMapFrames(param2List));
/*      */       }
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
/*      */       public void full(MethodVisitor param2MethodVisitor, List<? extends TypeDefinition> param2List1, List<? extends TypeDefinition> param2List2) {
/*  721 */         generate(param2MethodVisitor, 0, param2List1
/*      */             
/*  723 */             .size(), 
/*  724 */             toStackMapFrames(param2List1), param2List2
/*  725 */             .size(), 
/*  726 */             toStackMapFrames(param2List2), param2List2
/*  727 */             .size(), 
/*  728 */             toStackMapFrames(param2List2));
/*      */       }
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
/*      */       private static Object[] toStackMapFrames(List<? extends TypeDefinition> param2List) {
/*  755 */         Object[] arrayOfObject = param2List.isEmpty() ? EMPTY : new Object[param2List.size()];
/*  756 */         for (byte b = 0; b < param2List.size(); b++) {
/*  757 */           arrayOfObject[b] = toStackMapFrame(param2List.get(b));
/*      */         }
/*  759 */         return arrayOfObject;
/*      */       }
/*      */       
/*      */       private static Object toStackMapFrame(TypeDefinition param2TypeDefinition) {
/*  763 */         if (param2TypeDefinition.represents(boolean.class) || param2TypeDefinition
/*  764 */           .represents(byte.class) || param2TypeDefinition
/*  765 */           .represents(short.class) || param2TypeDefinition
/*  766 */           .represents(char.class) || param2TypeDefinition
/*  767 */           .represents(int.class))
/*  768 */           return Opcodes.INTEGER; 
/*  769 */         if (param2TypeDefinition.represents(long.class))
/*  770 */           return Opcodes.LONG; 
/*  771 */         if (param2TypeDefinition.represents(float.class))
/*  772 */           return Opcodes.FLOAT; 
/*  773 */         if (param2TypeDefinition.represents(double.class)) {
/*  774 */           return Opcodes.DOUBLE;
/*      */         }
/*  776 */         return param2TypeDefinition.asErasure().getInternalName();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected abstract void generate(MethodVisitor param2MethodVisitor, int param2Int1, int param2Int2, @MaybeNull Object[] param2ArrayOfObject1, int param2Int3, @MaybeNull Object[] param2ArrayOfObject2, int param2Int4, @MaybeNull Object[] param2ArrayOfObject3);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface ExtractableView
/*      */       extends Context
/*      */     {
/*      */       boolean isEnabled();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       List<DynamicType> getAuxiliaryTypes();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void drain(TypeInitializer.Drain param2Drain, ClassVisitor param2ClassVisitor, AnnotationValueFilter.Factory param2Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static abstract class AbstractBase
/*      */         implements ExtractableView
/*      */       {
/*      */         protected final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final ClassFileVersion classFileVersion;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Implementation.Context.FrameGeneration frameGeneration;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AbstractBase(TypeDescription param3TypeDescription, ClassFileVersion param3ClassFileVersion, Implementation.Context.FrameGeneration param3FrameGeneration) {
/*  842 */           this.instrumentedType = param3TypeDescription;
/*  843 */           this.classFileVersion = param3ClassFileVersion;
/*  844 */           this.frameGeneration = param3FrameGeneration;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getInstrumentedType() {
/*  851 */           return this.instrumentedType;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassFileVersion getClassFileVersion() {
/*  858 */           return this.classFileVersion;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Implementation.Context.FrameGeneration getFrameGeneration() {
/*  865 */           return this.frameGeneration;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.frameGeneration.equals(((AbstractBase)param3Object).frameGeneration) ? false : (!this.instrumentedType.equals(((AbstractBase)param3Object).instrumentedType) ? false : (!!this.classFileVersion.equals(((AbstractBase)param3Object).classFileVersion))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.classFileVersion.hashCode()) * 31 + this.frameGeneration.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Factory
/*      */     {
/*      */       @Deprecated
/*      */       Implementation.Context.ExtractableView make(TypeDescription param2TypeDescription, AuxiliaryType.NamingStrategy param2NamingStrategy, TypeInitializer param2TypeInitializer, ClassFileVersion param2ClassFileVersion1, ClassFileVersion param2ClassFileVersion2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Implementation.Context.ExtractableView make(TypeDescription param2TypeDescription, AuxiliaryType.NamingStrategy param2NamingStrategy, TypeInitializer param2TypeInitializer, ClassFileVersion param2ClassFileVersion1, ClassFileVersion param2ClassFileVersion2, Implementation.Context.FrameGeneration param2FrameGeneration);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Disabled
/*      */       extends ExtractableView.AbstractBase
/*      */     {
/*      */       protected Disabled(TypeDescription param2TypeDescription, ClassFileVersion param2ClassFileVersion, Implementation.Context.FrameGeneration param2FrameGeneration) {
/*  927 */         super(param2TypeDescription, param2ClassFileVersion, param2FrameGeneration);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isEnabled() {
/*  934 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<DynamicType> getAuxiliaryTypes() {
/*  941 */         return Collections.emptyList();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void drain(TypeInitializer.Drain param2Drain, ClassVisitor param2ClassVisitor, AnnotationValueFilter.Factory param2Factory) {
/*  948 */         param2Drain.apply(param2ClassVisitor, (TypeInitializer)TypeInitializer.None.INSTANCE, this);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription register(AuxiliaryType param2AuxiliaryType) {
/*  955 */         throw new IllegalStateException("Registration of auxiliary types was disabled: " + param2AuxiliaryType);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape registerAccessorFor(Implementation.SpecialMethodInvocation param2SpecialMethodInvocation, MethodAccessorFactory.AccessType param2AccessType) {
/*  962 */         throw new IllegalStateException("Registration of method accessors was disabled: " + param2SpecialMethodInvocation.getMethodDescription());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape registerGetterFor(FieldDescription param2FieldDescription, MethodAccessorFactory.AccessType param2AccessType) {
/*  969 */         throw new IllegalStateException("Registration of field accessor was disabled: " + param2FieldDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape registerSetterFor(FieldDescription param2FieldDescription, MethodAccessorFactory.AccessType param2AccessType) {
/*  976 */         throw new IllegalStateException("Registration of field accessor was disabled: " + param2FieldDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FieldDescription.InDefinedShape cache(StackManipulation param2StackManipulation, TypeDescription param2TypeDescription) {
/*  983 */         throw new IllegalStateException("Field values caching was disabled: " + param2TypeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Factory
/*      */         implements Implementation.Context.Factory
/*      */       {
/*  994 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Deprecated
/*      */         public final Implementation.Context.ExtractableView make(TypeDescription param3TypeDescription, AuxiliaryType.NamingStrategy param3NamingStrategy, TypeInitializer param3TypeInitializer, ClassFileVersion param3ClassFileVersion1, ClassFileVersion param3ClassFileVersion2) {
/* 1005 */           return make(param3TypeDescription, param3NamingStrategy, param3TypeInitializer, param3ClassFileVersion1, param3ClassFileVersion2, 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1010 */               param3ClassFileVersion1.isAtLeast(ClassFileVersion.JAVA_V6) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.DISABLED);
/*      */         }
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
/*      */         public final Implementation.Context.ExtractableView make(TypeDescription param3TypeDescription, AuxiliaryType.NamingStrategy param3NamingStrategy, TypeInitializer param3TypeInitializer, ClassFileVersion param3ClassFileVersion1, ClassFileVersion param3ClassFileVersion2, Implementation.Context.FrameGeneration param3FrameGeneration) {
/* 1024 */           if (param3TypeInitializer.isDefined()) {
/* 1025 */             throw new IllegalStateException("Cannot define type initializer which was explicitly disabled: " + param3TypeInitializer);
/*      */           }
/* 1027 */           return new Implementation.Context.Disabled(param3TypeDescription, param3ClassFileVersion1, param3FrameGeneration);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Default
/*      */       extends ExtractableView.AbstractBase
/*      */     {
/*      */       public static final String ACCESSOR_METHOD_SUFFIX = "accessor";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final String FIELD_CACHE_PREFIX = "cachedValue";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeInitializer typeInitializer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final ClassFileVersion auxiliaryClassFileVersion;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<Implementation.SpecialMethodInvocation, DelegationRecord> registeredAccessorMethods;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<FieldDescription, DelegationRecord> registeredGetters;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<FieldDescription, DelegationRecord> registeredSetters;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<AuxiliaryType, DynamicType> auxiliaryTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<FieldCacheEntry, FieldDescription.InDefinedShape> registeredFieldCacheEntries;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Set<FieldDescription.InDefinedShape> registeredFieldCacheFields;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String suffix;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private boolean fieldCacheCanAppendEntries;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Default(TypeDescription param2TypeDescription, ClassFileVersion param2ClassFileVersion1, AuxiliaryType.NamingStrategy param2NamingStrategy, TypeInitializer param2TypeInitializer, ClassFileVersion param2ClassFileVersion2, Implementation.Context.FrameGeneration param2FrameGeneration, String param2String) {
/* 1121 */         super(param2TypeDescription, param2ClassFileVersion1, param2FrameGeneration);
/* 1122 */         this.auxiliaryTypeNamingStrategy = param2NamingStrategy;
/* 1123 */         this.typeInitializer = param2TypeInitializer;
/* 1124 */         this.auxiliaryClassFileVersion = param2ClassFileVersion2;
/* 1125 */         this.suffix = param2String;
/* 1126 */         this.registeredAccessorMethods = new HashMap<Implementation.SpecialMethodInvocation, DelegationRecord>();
/* 1127 */         this.registeredGetters = new HashMap<FieldDescription, DelegationRecord>();
/* 1128 */         this.registeredSetters = new HashMap<FieldDescription, DelegationRecord>();
/* 1129 */         this.auxiliaryTypes = new HashMap<AuxiliaryType, DynamicType>();
/* 1130 */         this.registeredFieldCacheEntries = new HashMap<FieldCacheEntry, FieldDescription.InDefinedShape>();
/* 1131 */         this.registeredFieldCacheFields = new HashSet<FieldDescription.InDefinedShape>();
/* 1132 */         this.fieldCacheCanAppendEntries = true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isEnabled() {
/* 1139 */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape registerAccessorFor(Implementation.SpecialMethodInvocation param2SpecialMethodInvocation, MethodAccessorFactory.AccessType param2AccessType) {
/* 1149 */         DelegationRecord delegationRecord = ((delegationRecord = this.registeredAccessorMethods.get(param2SpecialMethodInvocation)) == null) ? new AccessorMethodDelegation(this.instrumentedType, this.suffix, param2AccessType, param2SpecialMethodInvocation) : delegationRecord.with(param2AccessType);
/* 1150 */         this.registeredAccessorMethods.put(param2SpecialMethodInvocation, delegationRecord);
/* 1151 */         return delegationRecord.getMethod();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape registerGetterFor(FieldDescription param2FieldDescription, MethodAccessorFactory.AccessType param2AccessType) {
/* 1161 */         DelegationRecord delegationRecord = ((delegationRecord = this.registeredGetters.get(param2FieldDescription)) == null) ? new FieldGetterDelegation(this.instrumentedType, this.suffix, param2AccessType, param2FieldDescription) : delegationRecord.with(param2AccessType);
/* 1162 */         this.registeredGetters.put(param2FieldDescription, delegationRecord);
/* 1163 */         return delegationRecord.getMethod();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape registerSetterFor(FieldDescription param2FieldDescription, MethodAccessorFactory.AccessType param2AccessType) {
/* 1173 */         DelegationRecord delegationRecord = ((delegationRecord = this.registeredSetters.get(param2FieldDescription)) == null) ? new FieldSetterDelegation(this.instrumentedType, this.suffix, param2AccessType, param2FieldDescription) : delegationRecord.with(param2AccessType);
/* 1174 */         this.registeredSetters.put(param2FieldDescription, delegationRecord);
/* 1175 */         return delegationRecord.getMethod();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription register(AuxiliaryType param2AuxiliaryType) {
/*      */         DynamicType dynamicType;
/* 1183 */         if ((dynamicType = this.auxiliaryTypes.get(param2AuxiliaryType)) == null) {
/* 1184 */           dynamicType = param2AuxiliaryType.make(this.auxiliaryTypeNamingStrategy.name(this.instrumentedType, param2AuxiliaryType), this.auxiliaryClassFileVersion, this);
/*      */ 
/*      */           
/* 1187 */           this.auxiliaryTypes.put(param2AuxiliaryType, dynamicType);
/*      */         } 
/* 1189 */         return dynamicType.getTypeDescription();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<DynamicType> getAuxiliaryTypes() {
/* 1196 */         return new ArrayList<DynamicType>(this.auxiliaryTypes.values());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FieldDescription.InDefinedShape cache(StackManipulation param2StackManipulation, TypeDescription param2TypeDescription) {
/* 1203 */         FieldCacheEntry fieldCacheEntry = new FieldCacheEntry(param2StackManipulation, param2TypeDescription);
/*      */         FieldDescription.InDefinedShape inDefinedShape;
/* 1205 */         if ((inDefinedShape = this.registeredFieldCacheEntries.get(fieldCacheEntry)) != null) {
/* 1206 */           return inDefinedShape;
/*      */         }
/* 1208 */         if (!this.fieldCacheCanAppendEntries) {
/* 1209 */           throw new IllegalStateException("Cached values cannot be registered after defining the type initializer for " + this.instrumentedType);
/*      */         }
/* 1211 */         int i = param2StackManipulation.hashCode();
/*      */         while (true) {
/* 1213 */           CacheValueField cacheValueField = new CacheValueField(this.instrumentedType, param2TypeDescription.asGenericType(), this.suffix, i++);
/* 1214 */           if (this.registeredFieldCacheFields.add(cacheValueField)) {
/* 1215 */             this.registeredFieldCacheEntries.put(fieldCacheEntry, cacheValueField);
/* 1216 */             return (FieldDescription.InDefinedShape)cacheValueField;
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void drain(TypeInitializer.Drain param2Drain, ClassVisitor param2ClassVisitor, AnnotationValueFilter.Factory param2Factory) {
/* 1225 */         this.fieldCacheCanAppendEntries = false;
/* 1226 */         TypeInitializer typeInitializer = this.typeInitializer;
/* 1227 */         for (Map.Entry<FieldCacheEntry, FieldDescription.InDefinedShape> entry : this.registeredFieldCacheEntries.entrySet()) {
/*      */           FieldVisitor fieldVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1233 */           if ((fieldVisitor = param2ClassVisitor.visitField(((FieldDescription.InDefinedShape)entry.getValue()).getModifiers(), ((FieldDescription.InDefinedShape)entry.getValue()).getInternalName(), ((FieldDescription.InDefinedShape)entry.getValue()).getDescriptor(), ((FieldDescription.InDefinedShape)entry.getValue()).getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE)) != null) {
/* 1234 */             fieldVisitor.visitEnd();
/* 1235 */             typeInitializer = typeInitializer.expandWith(((FieldCacheEntry)entry.getKey()).storeIn((FieldDescription)entry.getValue()));
/*      */           } 
/*      */         } 
/* 1238 */         param2Drain.apply(param2ClassVisitor, typeInitializer, this); Iterator<TypeWriter.MethodPool.Record> iterator;
/* 1239 */         for (iterator = this.registeredAccessorMethods.values().iterator(); iterator.hasNext();) {
/* 1240 */           (record = iterator.next()).apply(param2ClassVisitor, this, param2Factory);
/*      */         }
/* 1242 */         for (iterator = this.registeredGetters.values().iterator(); iterator.hasNext();) {
/* 1243 */           (record = iterator.next()).apply(param2ClassVisitor, this, param2Factory);
/*      */         }
/* 1245 */         for (iterator = this.registeredSetters.values().iterator(); iterator.hasNext();) {
/* 1246 */           (record = iterator.next()).apply(param2ClassVisitor, this, param2Factory);
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class CacheValueField
/*      */         extends FieldDescription.InDefinedShape.AbstractBase
/*      */       {
/*      */         private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription.Generic fieldType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected CacheValueField(TypeDescription param3TypeDescription, TypeDescription.Generic param3Generic, String param3String, int param3Int) {
/* 1279 */           this.instrumentedType = param3TypeDescription;
/* 1280 */           this.fieldType = param3Generic;
/* 1281 */           this.name = "cachedValue$" + param3String + "$" + RandomString.hashOf(param3Int);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getType() {
/* 1288 */           return this.fieldType;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 1295 */           return (AnnotationList)new AnnotationList.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getDeclaringType() {
/* 1303 */           return this.instrumentedType;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int getModifiers() {
/* 1310 */           return 0x1018 | (this.instrumentedType.isInterface() ? 1 : 2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getName() {
/* 1319 */           return this.name;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class FieldCacheEntry
/*      */         implements StackManipulation
/*      */       {
/*      */         private final StackManipulation fieldValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription fieldType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected FieldCacheEntry(StackManipulation param3StackManipulation, TypeDescription param3TypeDescription) {
/* 1346 */           this.fieldValue = param3StackManipulation;
/* 1347 */           this.fieldType = param3TypeDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ByteCodeAppender storeIn(FieldDescription param3FieldDescription) {
/* 1357 */           return (ByteCodeAppender)new ByteCodeAppender.Simple(new StackManipulation[] { this, FieldAccess.forField(param3FieldDescription).write() });
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected TypeDescription getFieldType() {
/* 1366 */           return this.fieldType;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isValid() {
/* 1373 */           return this.fieldValue.isValid();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public StackManipulation.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/* 1380 */           return this.fieldValue.apply(param3MethodVisitor, param3Context);
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/* 1385 */           int i = this.fieldValue.hashCode();
/*      */           
/* 1387 */           return i = i * 31 + this.fieldType.hashCode();
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/* 1392 */           if (this == param3Object)
/* 1393 */             return true; 
/* 1394 */           if (param3Object == null || getClass() != param3Object.getClass()) {
/* 1395 */             return false;
/*      */           }
/* 1397 */           param3Object = param3Object;
/* 1398 */           return (this.fieldValue.equals(((FieldCacheEntry)param3Object).fieldValue) && this.fieldType.equals(((FieldCacheEntry)param3Object).fieldType));
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static abstract class AbstractPropertyAccessorMethod
/*      */         extends MethodDescription.InDefinedShape.AbstractBase
/*      */       {
/*      */         public int getModifiers() {
/* 1411 */           return 0x1000 | getBaseModifiers() | (getDeclaringType().isInterface() ? 1 : 16);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract int getBaseModifiers();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class AccessorMethod
/*      */         extends AbstractPropertyAccessorMethod
/*      */       {
/*      */         private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AccessorMethod(TypeDescription param3TypeDescription1, MethodDescription param3MethodDescription, TypeDescription param3TypeDescription2, String param3String) {
/* 1456 */           this.instrumentedType = param3TypeDescription1;
/* 1457 */           this.methodDescription = param3MethodDescription;
/* 1458 */           this
/*      */ 
/*      */             
/* 1461 */             .name = param3MethodDescription.getInternalName() + "$accessor" + "$" + param3String + (param3TypeDescription2.isInterface() ? ("$" + RandomString.hashOf(param3TypeDescription2.hashCode())) : "");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getReturnType() {
/* 1468 */           return this.methodDescription.getReturnType().asRawType();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1475 */           return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape)this, (List)this.methodDescription.getParameters().asTypeList().asRawTypes());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getExceptionTypes() {
/* 1482 */           return this.methodDescription.getExceptionTypes().asRawTypes();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public AnnotationValue<?, ?> getDefaultValue() {
/* 1490 */           return AnnotationValue.UNDEFINED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getTypeVariables() {
/* 1497 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 1504 */           return (AnnotationList)new AnnotationList.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getDeclaringType() {
/* 1512 */           return this.instrumentedType;
/*      */         }
/*      */ 
/*      */         
/*      */         protected int getBaseModifiers() {
/* 1517 */           return this.methodDescription.isStatic() ? 8 : 0;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getInternalName() {
/* 1526 */           return this.name;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class FieldGetter
/*      */         extends AbstractPropertyAccessorMethod
/*      */       {
/*      */         private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final FieldDescription fieldDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected FieldGetter(TypeDescription param3TypeDescription, FieldDescription param3FieldDescription, String param3String) {
/* 1558 */           this.instrumentedType = param3TypeDescription;
/* 1559 */           this.fieldDescription = param3FieldDescription;
/* 1560 */           this.name = param3FieldDescription.getName() + "$accessor" + "$" + param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getReturnType() {
/* 1567 */           return this.fieldDescription.getType().asRawType();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1574 */           return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getExceptionTypes() {
/* 1581 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public AnnotationValue<?, ?> getDefaultValue() {
/* 1589 */           return AnnotationValue.UNDEFINED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getTypeVariables() {
/* 1596 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 1603 */           return (AnnotationList)new AnnotationList.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getDeclaringType() {
/* 1611 */           return this.instrumentedType;
/*      */         }
/*      */ 
/*      */         
/*      */         protected int getBaseModifiers() {
/* 1616 */           return this.fieldDescription.isStatic() ? 8 : 0;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getInternalName() {
/* 1625 */           return this.name;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class FieldSetter
/*      */         extends AbstractPropertyAccessorMethod
/*      */       {
/*      */         private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final FieldDescription fieldDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected FieldSetter(TypeDescription param3TypeDescription, FieldDescription param3FieldDescription, String param3String) {
/* 1657 */           this.instrumentedType = param3TypeDescription;
/* 1658 */           this.fieldDescription = param3FieldDescription;
/* 1659 */           this.name = param3FieldDescription.getName() + "$accessor" + "$" + param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getReturnType() {
/* 1666 */           return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1673 */           return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape)this, Collections.singletonList(this.fieldDescription.getType().asRawType()));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getExceptionTypes() {
/* 1680 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public AnnotationValue<?, ?> getDefaultValue() {
/* 1688 */           return AnnotationValue.UNDEFINED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeList.Generic getTypeVariables() {
/* 1695 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationList getDeclaredAnnotations() {
/* 1702 */           return (AnnotationList)new AnnotationList.Empty();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getDeclaringType() {
/* 1710 */           return this.instrumentedType;
/*      */         }
/*      */ 
/*      */         
/*      */         protected int getBaseModifiers() {
/* 1715 */           return this.fieldDescription.isStatic() ? 8 : 0;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getInternalName() {
/* 1724 */           return this.name;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static abstract class DelegationRecord
/*      */         extends TypeWriter.MethodPool.Record.ForDefinedMethod
/*      */         implements ByteCodeAppender
/*      */       {
/*      */         protected final MethodDescription.InDefinedShape methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Visibility visibility;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected DelegationRecord(MethodDescription.InDefinedShape param3InDefinedShape, Visibility param3Visibility) {
/* 1751 */           this.methodDescription = param3InDefinedShape;
/* 1752 */           this.visibility = param3Visibility;
/*      */         }
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
/*      */         public MethodDescription.InDefinedShape getMethod() {
/* 1767 */           return this.methodDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record.Sort getSort() {
/* 1774 */           return TypeWriter.MethodPool.Record.Sort.IMPLEMENTED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Visibility getVisibility() {
/* 1781 */           return this.visibility;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyHead(MethodVisitor param3MethodVisitor) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyBody(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, AnnotationValueFilter.Factory param3Factory) {
/* 1795 */           param3MethodVisitor.visitCode();
/* 1796 */           ByteCodeAppender.Size size = applyCode(param3MethodVisitor, param3Context);
/* 1797 */           param3MethodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyAttributes(MethodVisitor param3MethodVisitor, AnnotationValueFilter.Factory param3Factory) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size applyCode(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/* 1811 */           return apply(param3MethodVisitor, param3Context, (MethodDescription)getMethod());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record prepend(ByteCodeAppender param3ByteCodeAppender) {
/* 1818 */           throw new UnsupportedOperationException("Cannot prepend code to a delegation for " + this.methodDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract DelegationRecord with(MethodAccessorFactory.AccessType param3AccessType);
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.visibility.equals(((DelegationRecord)param3Object).visibility) ? false : (!!this.methodDescription.equals(((DelegationRecord)param3Object).methodDescription)))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class AccessorMethodDelegation
/*      */         extends DelegationRecord
/*      */       {
/*      */         private final StackManipulation accessorMethodInvocation;
/*      */ 
/*      */         
/*      */         protected AccessorMethodDelegation(TypeDescription param3TypeDescription, String param3String, MethodAccessorFactory.AccessType param3AccessType, Implementation.SpecialMethodInvocation param3SpecialMethodInvocation) {
/* 1846 */           this((MethodDescription.InDefinedShape)new Implementation.Context.Default.AccessorMethod(param3TypeDescription, param3SpecialMethodInvocation
/* 1847 */                 .getMethodDescription(), param3SpecialMethodInvocation
/* 1848 */                 .getTypeDescription(), param3String), param3AccessType
/* 1849 */               .getVisibility(), param3SpecialMethodInvocation);
/*      */         }
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
/*      */         private AccessorMethodDelegation(MethodDescription.InDefinedShape param3InDefinedShape, Visibility param3Visibility, StackManipulation param3StackManipulation) {
/* 1862 */           super(param3InDefinedShape, param3Visibility);
/* 1863 */           this.accessorMethodInvocation = param3StackManipulation;
/*      */         }
/*      */ 
/*      */         
/*      */         protected Implementation.Context.Default.DelegationRecord with(MethodAccessorFactory.AccessType param3AccessType) {
/* 1868 */           return new AccessorMethodDelegation(this.methodDescription, this.visibility.expandTo(param3AccessType.getVisibility()), this.accessorMethodInvocation);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, MethodDescription param3MethodDescription) {
/* 1879 */           StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.allArgumentsOf(param3MethodDescription).prependThisReference(), this.accessorMethodInvocation, MethodReturn.of((TypeDefinition)param3MethodDescription.getReturnType()) })).apply(param3MethodVisitor, param3Context);
/* 1880 */           return new ByteCodeAppender.Size(size.getMaximalSize(), param3MethodDescription.getStackSize());
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.accessorMethodInvocation.equals(((AccessorMethodDelegation)param3Object).accessorMethodInvocation)))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return super.hashCode() * 31 + this.accessorMethodInvocation.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class FieldGetterDelegation
/*      */         extends DelegationRecord
/*      */       {
/*      */         private final FieldDescription fieldDescription;
/*      */ 
/*      */         
/*      */         protected FieldGetterDelegation(TypeDescription param3TypeDescription, String param3String, MethodAccessorFactory.AccessType param3AccessType, FieldDescription param3FieldDescription) {
/* 1904 */           this((MethodDescription.InDefinedShape)new Implementation.Context.Default.FieldGetter(param3TypeDescription, param3FieldDescription, param3String), param3AccessType.getVisibility(), param3FieldDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private FieldGetterDelegation(MethodDescription.InDefinedShape param3InDefinedShape, Visibility param3Visibility, FieldDescription param3FieldDescription) {
/* 1915 */           super(param3InDefinedShape, param3Visibility);
/* 1916 */           this.fieldDescription = param3FieldDescription;
/*      */         }
/*      */ 
/*      */         
/*      */         protected Implementation.Context.Default.DelegationRecord with(MethodAccessorFactory.AccessType param3AccessType) {
/* 1921 */           return new FieldGetterDelegation(this.methodDescription, this.visibility.expandTo(param3AccessType.getVisibility()), this.fieldDescription);
/*      */         }
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
/*      */         public ByteCodeAppender.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, MethodDescription param3MethodDescription) {
/* 1934 */           StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read(), MethodReturn.of((TypeDefinition)this.fieldDescription.getType()) })).apply(param3MethodVisitor, param3Context);
/* 1935 */           return new ByteCodeAppender.Size(size.getMaximalSize(), param3MethodDescription.getStackSize());
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((FieldGetterDelegation)param3Object).fieldDescription)))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return super.hashCode() * 31 + this.fieldDescription.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class FieldSetterDelegation
/*      */         extends DelegationRecord
/*      */       {
/*      */         private final FieldDescription fieldDescription;
/*      */ 
/*      */         
/*      */         protected FieldSetterDelegation(TypeDescription param3TypeDescription, String param3String, MethodAccessorFactory.AccessType param3AccessType, FieldDescription param3FieldDescription) {
/* 1959 */           this((MethodDescription.InDefinedShape)new Implementation.Context.Default.FieldSetter(param3TypeDescription, param3FieldDescription, param3String), param3AccessType.getVisibility(), param3FieldDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private FieldSetterDelegation(MethodDescription.InDefinedShape param3InDefinedShape, Visibility param3Visibility, FieldDescription param3FieldDescription) {
/* 1970 */           super(param3InDefinedShape, param3Visibility);
/* 1971 */           this.fieldDescription = param3FieldDescription;
/*      */         }
/*      */ 
/*      */         
/*      */         protected Implementation.Context.Default.DelegationRecord with(MethodAccessorFactory.AccessType param3AccessType) {
/* 1976 */           return new FieldSetterDelegation(this.methodDescription, this.visibility.expandTo(param3AccessType.getVisibility()), this.fieldDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, MethodDescription param3MethodDescription) {
/* 1987 */           StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.allArgumentsOf(param3MethodDescription).prependThisReference(), FieldAccess.forField(this.fieldDescription).write(), (StackManipulation)MethodReturn.VOID })).apply(param3MethodVisitor, param3Context);
/* 1988 */           return new ByteCodeAppender.Size(size.getMaximalSize(), param3MethodDescription.getStackSize());
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((FieldSetterDelegation)param3Object).fieldDescription)))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return super.hashCode() * 31 + this.fieldDescription.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       public enum Factory implements Implementation.Context.Factory {
/* 2001 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Deprecated
/*      */         public final Implementation.Context.ExtractableView make(TypeDescription param3TypeDescription, AuxiliaryType.NamingStrategy param3NamingStrategy, TypeInitializer param3TypeInitializer, ClassFileVersion param3ClassFileVersion1, ClassFileVersion param3ClassFileVersion2) {
/* 2012 */           return make(param3TypeDescription, param3NamingStrategy, param3TypeInitializer, param3ClassFileVersion1, param3ClassFileVersion2, 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2017 */               param3ClassFileVersion1.isAtLeast(ClassFileVersion.JAVA_V6) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.DISABLED);
/*      */         }
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
/*      */         public final Implementation.Context.ExtractableView make(TypeDescription param3TypeDescription, AuxiliaryType.NamingStrategy param3NamingStrategy, TypeInitializer param3TypeInitializer, ClassFileVersion param3ClassFileVersion1, ClassFileVersion param3ClassFileVersion2, Implementation.Context.FrameGeneration param3FrameGeneration) {
/* 2031 */           return new Implementation.Context.Default(param3TypeDescription, param3ClassFileVersion1, param3NamingStrategy, param3TypeInitializer, param3ClassFileVersion2, param3FrameGeneration, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2037 */               RandomString.make());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class WithFixedSuffix
/*      */           implements Implementation.Context.Factory
/*      */         {
/*      */           private final String suffix;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public WithFixedSuffix(String param4String) {
/* 2058 */             this.suffix = param4String;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Deprecated
/*      */           public Implementation.Context.ExtractableView make(TypeDescription param4TypeDescription, AuxiliaryType.NamingStrategy param4NamingStrategy, TypeInitializer param4TypeInitializer, ClassFileVersion param4ClassFileVersion1, ClassFileVersion param4ClassFileVersion2) {
/* 2070 */             return make(param4TypeDescription, param4NamingStrategy, param4TypeInitializer, param4ClassFileVersion1, param4ClassFileVersion2, 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2075 */                 param4ClassFileVersion1.isAtLeast(ClassFileVersion.JAVA_V6) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.DISABLED);
/*      */           }
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
/*      */           public Implementation.Context.ExtractableView make(TypeDescription param4TypeDescription, AuxiliaryType.NamingStrategy param4NamingStrategy, TypeInitializer param4TypeInitializer, ClassFileVersion param4ClassFileVersion1, ClassFileVersion param4ClassFileVersion2, Implementation.Context.FrameGeneration param4FrameGeneration) {
/* 2089 */             return new Implementation.Context.Default(param4TypeDescription, param4ClassFileVersion1, param4NamingStrategy, param4TypeInitializer, param4ClassFileVersion2, param4FrameGeneration, this.suffix);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.suffix.equals(((WithFixedSuffix)param4Object).suffix))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.suffix.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Compound
/*      */     implements Implementation
/*      */   {
/*      */     public Compound(Implementation... param1VarArgs) {
/* 2125 */       this(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2134 */     private final List<Implementation> implementations = new ArrayList<Implementation>(); public Compound(List<? extends Implementation> param1List) {
/* 2135 */       for (Iterator<? extends Implementation> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 2136 */         Implementation implementation; if (implementation = iterator.next() instanceof Composable) {
/* 2137 */           this.implementations.addAll(Composable.a((Composable)implementation));
/* 2138 */           this.implementations.add(Composable.b((Composable)implementation)); continue;
/* 2139 */         }  if (implementation instanceof Compound) {
/* 2140 */           this.implementations.addAll(((Compound)implementation).implementations); continue;
/*      */         } 
/* 2142 */         this.implementations.add(implementation);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 2151 */       for (Iterator<Implementation> iterator = this.implementations.iterator(); iterator.hasNext();) {
/* 2152 */         param1InstrumentedType = (implementation = iterator.next()).prepare(param1InstrumentedType);
/*      */       }
/* 2154 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 2161 */       ByteCodeAppender[] arrayOfByteCodeAppender = new ByteCodeAppender[this.implementations.size()];
/* 2162 */       byte b = 0;
/* 2163 */       for (Implementation implementation : this.implementations) {
/* 2164 */         arrayOfByteCodeAppender[b++] = implementation.appender(param1Target);
/*      */       }
/* 2166 */       return (ByteCodeAppender)new ByteCodeAppender.Compound(arrayOfByteCodeAppender);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.implementations.equals(((Compound)param1Object).implementations))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.implementations.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Composable
/*      */       implements Implementation.Composable
/*      */     {
/*      */       private final Implementation.Composable composable;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Composable(Implementation param2Implementation, Implementation.Composable param2Composable) {
/* 2198 */         this(Collections.singletonList(param2Implementation), param2Composable);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2208 */       private final List<Implementation> implementations = new ArrayList<Implementation>(); public Composable(List<? extends Implementation> param2List, Implementation.Composable param2Composable) {
/* 2209 */         for (Iterator<? extends Implementation> iterator = param2List.iterator(); iterator.hasNext(); ) {
/* 2210 */           Implementation implementation; if (implementation = iterator.next() instanceof Composable) {
/* 2211 */             this.implementations.addAll(((Composable)implementation).implementations);
/* 2212 */             this.implementations.add(((Composable)implementation).composable); continue;
/* 2213 */           }  if (implementation instanceof Implementation.Compound) {
/* 2214 */             this.implementations.addAll(Implementation.Compound.a((Implementation.Compound)implementation)); continue;
/*      */           } 
/* 2216 */           this.implementations.add(implementation);
/*      */         } 
/*      */         
/* 2219 */         if (param2Composable instanceof Composable) {
/* 2220 */           this.implementations.addAll(((Composable)param2Composable).implementations);
/* 2221 */           this.composable = ((Composable)param2Composable).composable; return;
/*      */         } 
/* 2223 */         this.composable = param2Composable;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 2231 */         for (Iterator<Implementation> iterator = this.implementations.iterator(); iterator.hasNext();) {
/* 2232 */           param2InstrumentedType = (implementation = iterator.next()).prepare(param2InstrumentedType);
/*      */         }
/* 2234 */         return this.composable.prepare(param2InstrumentedType);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender appender(Implementation.Target param2Target) {
/* 2241 */         ByteCodeAppender[] arrayOfByteCodeAppender = new ByteCodeAppender[this.implementations.size() + 1];
/* 2242 */         byte b = 0;
/* 2243 */         for (Implementation implementation : this.implementations) {
/* 2244 */           arrayOfByteCodeAppender[b++] = implementation.appender(param2Target);
/*      */         }
/* 2246 */         arrayOfByteCodeAppender[b] = this.composable.appender(param2Target);
/* 2247 */         return (ByteCodeAppender)new ByteCodeAppender.Compound(arrayOfByteCodeAppender);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation andThen(Implementation param2Implementation) {
/* 2254 */         return new Implementation.Compound(CompoundList.of(this.implementations, this.composable.andThen(param2Implementation)));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.Composable andThen(Implementation.Composable param2Composable) {
/* 2261 */         return new Composable(this.implementations, this.composable.andThen(param2Composable));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.composable.equals(((Composable)param2Object).composable) ? false : (!!this.implementations.equals(((Composable)param2Object).implementations)))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.composable.hashCode()) * 31 + this.implementations.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Simple
/*      */     implements Implementation
/*      */   {
/*      */     private static final int NO_ADDITIONAL_VARIABLES = 0;
/*      */     
/*      */     private final ByteCodeAppender byteCodeAppender;
/*      */ 
/*      */     
/*      */     public Simple(ByteCodeAppender... param1VarArgs) {
/* 2288 */       this.byteCodeAppender = (ByteCodeAppender)new ByteCodeAppender.Compound(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Simple(StackManipulation... param1VarArgs) {
/* 2298 */       this.byteCodeAppender = (ByteCodeAppender)new ByteCodeAppender.Simple(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Implementation of(Dispatcher param1Dispatcher) {
/* 2308 */       return of(param1Dispatcher, 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Implementation of(Dispatcher param1Dispatcher, int param1Int) {
/* 2319 */       return of(param1Dispatcher, (InstrumentedType.Prepareable)InstrumentedType.Prepareable.NoOp.INSTANCE, param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Implementation of(Dispatcher param1Dispatcher, InstrumentedType.Prepareable param1Prepareable) {
/* 2330 */       return of(param1Dispatcher, param1Prepareable, 0);
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
/*      */     public static Implementation of(Dispatcher param1Dispatcher, InstrumentedType.Prepareable param1Prepareable, int param1Int) {
/* 2342 */       if (param1Int < 0) {
/* 2343 */         throw new IllegalArgumentException("Additional variable length cannot be negative: " + param1Int);
/*      */       }
/* 2345 */       return new ForDispatcher(param1Dispatcher, param1Prepareable, param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 2352 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 2359 */       return this.byteCodeAppender;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.byteCodeAppender.equals(((Simple)param1Object).byteCodeAppender))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.byteCodeAppender.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class ForDispatcher
/*      */       implements Implementation
/*      */     {
/*      */       private final Implementation.Simple.Dispatcher dispatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final InstrumentedType.Prepareable prepareable;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int additionalVariableLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForDispatcher(Implementation.Simple.Dispatcher param2Dispatcher, InstrumentedType.Prepareable param2Prepareable, int param2Int) {
/* 2406 */         this.dispatcher = param2Dispatcher;
/* 2407 */         this.prepareable = param2Prepareable;
/* 2408 */         this.additionalVariableLength = param2Int;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 2415 */         return this.prepareable.prepare(param2InstrumentedType);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender appender(Implementation.Target param2Target) {
/* 2422 */         return new Appender(this, param2Target);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.additionalVariableLength != ((ForDispatcher)param2Object).additionalVariableLength) ? false : (!this.dispatcher.equals(((ForDispatcher)param2Object).dispatcher) ? false : (!!this.prepareable.equals(((ForDispatcher)param2Object).prepareable))))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.dispatcher.hashCode()) * 31 + this.prepareable.hashCode()) * 31 + this.additionalVariableLength;
/*      */       }
/*      */       
/*      */       @Enhance(includeSyntheticFields = true)
/*      */       protected class Appender
/*      */         implements ByteCodeAppender
/*      */       {
/*      */         private final Implementation.Target implementationTarget;
/*      */         
/*      */         protected Appender(Implementation.Simple.ForDispatcher this$0, Implementation.Target param3Target) {
/* 2442 */           this.implementationTarget = param3Target;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, MethodDescription param3MethodDescription) {
/* 2449 */           return new ByteCodeAppender.Size(Implementation.Simple.ForDispatcher.a(this.a).apply(this.implementationTarget, param3MethodDescription)
/* 2450 */               .apply(param3MethodVisitor, param3Context)
/* 2451 */               .getMaximalSize(), param3MethodDescription.getStackSize() + Implementation.Simple.ForDispatcher.b(this.a));
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.implementationTarget.equals(((Appender)param3Object).implementationTarget) ? false : (!!this.a.equals(((Appender)param3Object).a)))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.implementationTarget.hashCode()) * 31 + this.a.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     public static interface Dispatcher {
/*      */       StackManipulation apply(Implementation.Target param2Target, MethodDescription param2MethodDescription);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\Implementation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */