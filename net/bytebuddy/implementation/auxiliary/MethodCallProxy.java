/*     */ package net.bytebuddy.implementation.auxiliary;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.bytebuddy.ByteBuddy;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationValue;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.modifier.Visibility;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*     */ @Enhance
/*     */ public class MethodCallProxy
/*     */   implements AuxiliaryType
/*     */ {
/*     */   private static final String FIELD_NAME_PREFIX = "argument";
/*     */   private final Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */   private final boolean serializableProxy;
/*     */   private final Assigner assigner;
/*     */   
/*     */   public MethodCallProxy(Implementation.SpecialMethodInvocation paramSpecialMethodInvocation, boolean paramBoolean) {
/* 101 */     this(paramSpecialMethodInvocation, paramBoolean, Assigner.DEFAULT);
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
/*     */   public MethodCallProxy(Implementation.SpecialMethodInvocation paramSpecialMethodInvocation, boolean paramBoolean, Assigner paramAssigner) {
/* 114 */     this.specialMethodInvocation = paramSpecialMethodInvocation;
/* 115 */     this.serializableProxy = paramBoolean;
/* 116 */     this.assigner = paramAssigner;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static LinkedHashMap<String, TypeDescription> extractFields(MethodDescription paramMethodDescription) {
/* 127 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 128 */     byte b = 0;
/* 129 */     if (!paramMethodDescription.isStatic()) {
/* 130 */       b++; linkedHashMap.put(fieldName(0), paramMethodDescription.getDeclaringType().asErasure());
/*     */     } 
/* 132 */     for (ParameterDescription parameterDescription : paramMethodDescription.getParameters()) {
/* 133 */       linkedHashMap.put(fieldName(b++), parameterDescription.getType().asErasure());
/*     */     }
/* 135 */     return (LinkedHashMap)linkedHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String fieldName(int paramInt) {
/* 145 */     return "argument" + paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSuffix() {
/* 152 */     return RandomString.hashOf(this.specialMethodInvocation.getMethodDescription().hashCode()) + (this.serializableProxy ? "S" : "0");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicType make(String paramString, ClassFileVersion paramClassFileVersion, MethodAccessorFactory paramMethodAccessorFactory) {
/*     */     DynamicType.Builder.FieldDefinition.Optional.Valuable valuable;
/*     */     MethodDescription.InDefinedShape inDefinedShape;
/* 162 */     LinkedHashMap<String, TypeDescription> linkedHashMap = extractFields((MethodDescription)(inDefinedShape = paramMethodAccessorFactory.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.DEFAULT)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     (new Class[1])[0] = Serializable.class;
/*     */ 
/*     */     
/* 172 */     DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition = (new ByteBuddy(paramClassFileVersion)).with(TypeValidation.DISABLED).with(PrecomputedMethodGraph.INSTANCE).subclass(Object.class, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).name(paramString).modifiers(DEFAULT_TYPE_MODIFIER).implement(new Type[] { Runnable.class, Callable.class }).intercept(new MethodCall((MethodDescription)inDefinedShape, this.assigner)).implement(this.serializableProxy ? (Type[])new Class[1] : (Type[])new Class[0]).defineConstructor(new ModifierContributor.ForMethod[0]).withParameters(linkedHashMap.values()).intercept(ConstructorCall.INSTANCE);
/* 173 */     for (Map.Entry<String, TypeDescription> entry : linkedHashMap.entrySet()) {
/* 174 */       valuable = receiverTypeDefinition.defineField((String)entry.getKey(), (TypeDefinition)entry.getValue(), new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE });
/*     */     } 
/* 176 */     return (DynamicType)valuable.make();
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.serializableProxy != ((MethodCallProxy)paramObject).serializableProxy) ? false : (!this.specialMethodInvocation.equals(((MethodCallProxy)paramObject).specialMethodInvocation) ? false : (!!this.assigner.equals(((MethodCallProxy)paramObject).assigner))))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return ((getClass().hashCode() * 31 + this.specialMethodInvocation.hashCode()) * 31 + this.serializableProxy) * 31 + this.assigner.hashCode();
/*     */   }
/*     */   
/* 187 */   protected enum PrecomputedMethodGraph implements MethodGraph.Compiler { INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final transient MethodGraph.Linked methodGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PrecomputedMethodGraph() {
/* 198 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 206 */       MethodDescription.Latent latent = new MethodDescription.Latent(TypeDescription.ForLoadedType.of(Callable.class), "call", 1025, Collections.emptyList(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Collections.emptyList(), Collections.singletonList(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Exception.class)), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
/*     */ 
/*     */       
/* 209 */       linkedHashMap.put(latent.asSignatureToken(), new MethodGraph.Node.Simple((MethodDescription)latent));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 217 */       latent = new MethodDescription.Latent(TypeDescription.ForLoadedType.of(Runnable.class), "run", 1025, Collections.emptyList(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
/*     */ 
/*     */       
/* 220 */       linkedHashMap.put(latent.asSignatureToken(), new MethodGraph.Node.Simple((MethodDescription)latent));
/* 221 */       MethodGraph.Simple simple = new MethodGraph.Simple(linkedHashMap);
/* 222 */       this.methodGraph = (MethodGraph.Linked)new MethodGraph.Linked.Delegation((MethodGraph)simple, (MethodGraph)simple, Collections.emptyMap());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodGraph.Linked compile(TypeDefinition param1TypeDefinition) {
/* 229 */       return this.methodGraph;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public final MethodGraph.Linked compile(TypeDescription param1TypeDescription) {
/* 237 */       return this.methodGraph;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodGraph.Linked compile(TypeDefinition param1TypeDefinition, TypeDescription param1TypeDescription) {
/* 244 */       return this.methodGraph;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public final MethodGraph.Linked compile(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/* 252 */       return this.methodGraph;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum ConstructorCall
/*     */     implements Implementation
/*     */   {
/* 264 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final MethodDescription objectTypeDefaultConstructor;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ConstructorCall() {
/* 275 */       this.objectTypeDefaultConstructor = (MethodDescription)((MethodList)TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 282 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ByteCodeAppender appender(Implementation.Target param1Target) {
/* 289 */       return new Appender(param1Target.getInstrumentedType(), (byte)0);
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
/*     */       private Appender(TypeDescription param2TypeDescription) {
/* 309 */         this.instrumentedType = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/*     */         FieldList fieldList;
/* 317 */         StackManipulation[] arrayOfStackManipulation = new StackManipulation[(fieldList = this.instrumentedType.getDeclaredFields()).size()];
/* 318 */         byte b = 0;
/* 319 */         for (FieldDescription fieldDescription : fieldList) {
/* 320 */           arrayOfStackManipulation[b] = (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 321 */                 MethodVariableAccess.loadThis(), 
/* 322 */                 MethodVariableAccess.load((ParameterDescription)param2MethodDescription.getParameters().get(b)), 
/* 323 */                 FieldAccess.forField(fieldDescription).write()
/*     */               });
/* 325 */           b++;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 332 */         StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(MethodCallProxy.ConstructorCall.a(MethodCallProxy.ConstructorCall.INSTANCE)), (StackManipulation)new StackManipulation.Compound(arrayOfStackManipulation), (StackManipulation)MethodReturn.VOID })).apply(param2MethodVisitor, param2Context);
/* 333 */         return new ByteCodeAppender.Size(size.getMaximalSize(), param2MethodDescription.getStackSize());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((Appender)param2Object).instrumentedType))));
/*     */       }
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
/*     */   @Enhance
/*     */   protected static class MethodCall
/*     */     implements Implementation
/*     */   {
/*     */     private final MethodDescription accessorMethod;
/*     */     
/*     */     private final Assigner assigner;
/*     */ 
/*     */     
/*     */     protected MethodCall(MethodDescription param1MethodDescription, Assigner param1Assigner) {
/* 361 */       this.accessorMethod = param1MethodDescription;
/* 362 */       this.assigner = param1Assigner;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 369 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 376 */       return new Appender(param1Target.getInstrumentedType(), (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.accessorMethod.equals(((MethodCall)param1Object).accessorMethod) ? false : (!!this.assigner.equals(((MethodCall)param1Object).assigner)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.accessorMethod.hashCode()) * 31 + this.assigner.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance(includeSyntheticFields = true)
/*     */     protected class Appender
/*     */       implements ByteCodeAppender
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */       
/*     */       private Appender(MethodCallProxy.MethodCall this$0, TypeDescription param2TypeDescription) {
/* 396 */         this.instrumentedType = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 405 */         FieldList fieldList = this.instrumentedType.getDeclaredFields();
/* 406 */         ArrayList<StackManipulation.Compound> arrayList = new ArrayList(fieldList.size());
/* 407 */         for (FieldDescription fieldDescription : fieldList) {
/* 408 */           arrayList.add(new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), FieldAccess.forField(fieldDescription).read() }));
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 415 */         StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { (StackManipulation)new StackManipulation.Compound(arrayList), (StackManipulation)MethodInvocation.invoke(MethodCallProxy.MethodCall.a(this.a)), MethodCallProxy.MethodCall.b(this.a).assign(MethodCallProxy.MethodCall.a(this.a).getReturnType(), param2MethodDescription.getReturnType(), Assigner.Typing.DYNAMIC), MethodReturn.of((TypeDefinition)param2MethodDescription.getReturnType()) })).apply(param2MethodVisitor, param2Context);
/* 416 */         return new ByteCodeAppender.Size(size.getMaximalSize(), param2MethodDescription.getStackSize());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedType.equals(((Appender)param2Object).instrumentedType) ? false : (!!this.a.equals(((Appender)param2Object).a)))));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.a.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class AssignableSignatureCall
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final Implementation.SpecialMethodInvocation specialMethodInvocation;
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean serializable;
/*     */ 
/*     */ 
/*     */     
/*     */     public AssignableSignatureCall(Implementation.SpecialMethodInvocation param1SpecialMethodInvocation, boolean param1Boolean) {
/* 451 */       this.specialMethodInvocation = param1SpecialMethodInvocation;
/* 452 */       this.serializable = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 460 */       TypeDescription typeDescription = param1Context.register(new MethodCallProxy(this.specialMethodInvocation, this.serializable));
/* 461 */       return (new StackManipulation.Compound(new StackManipulation[] {
/* 462 */             TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, 
/*     */             
/* 464 */             MethodVariableAccess.allArgumentsOf(this.specialMethodInvocation.getMethodDescription()).prependThisReference(), 
/* 465 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly())
/* 466 */           })).apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.serializable != ((AssignableSignatureCall)param1Object).serializable) ? false : (!!this.specialMethodInvocation.equals(((AssignableSignatureCall)param1Object).specialMethodInvocation)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.specialMethodInvocation.hashCode()) * 31 + this.serializable;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\auxiliary\MethodCallProxy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */