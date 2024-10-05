/*      */ package net.bytebuddy.implementation;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.method.ParameterList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.scaffold.FieldLocator;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.Removal;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
/*      */ import net.bytebuddy.implementation.bytecode.constant.LongConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.JavaConstant;
/*      */ import net.bytebuddy.utility.JavaType;
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
/*      */ @Enhance
/*      */ public class InvokeDynamic
/*      */   implements Implementation.Composable
/*      */ {
/*      */   protected final MethodDescription.InDefinedShape bootstrap;
/*      */   protected final List<? extends JavaConstant> arguments;
/*      */   protected final InvocationProvider invocationProvider;
/*      */   protected final TerminationHandler terminationHandler;
/*      */   protected final Assigner assigner;
/*      */   protected final Assigner.Typing typing;
/*      */   
/*      */   protected InvokeDynamic(MethodDescription.InDefinedShape paramInDefinedShape, List<? extends JavaConstant> paramList, InvocationProvider paramInvocationProvider, TerminationHandler paramTerminationHandler, Assigner paramAssigner, Assigner.Typing paramTyping) {
/*  115 */     this.bootstrap = paramInDefinedShape;
/*  116 */     this.arguments = paramList;
/*  117 */     this.invocationProvider = paramInvocationProvider;
/*  118 */     this.terminationHandler = paramTerminationHandler;
/*  119 */     this.assigner = paramAssigner;
/*  120 */     this.typing = paramTyping;
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
/*      */   public static WithImplicitTarget bootstrap(Method paramMethod, Object... paramVarArgs) {
/*  135 */     return bootstrap((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(paramMethod), paramVarArgs);
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
/*      */   public static WithImplicitTarget bootstrap(Method paramMethod, List<?> paramList) {
/*  150 */     return bootstrap((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(paramMethod), paramList);
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
/*      */   public static WithImplicitTarget bootstrap(Constructor<?> paramConstructor, Object... paramVarArgs) {
/*  165 */     return bootstrap((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(paramConstructor), paramVarArgs);
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
/*      */   public static WithImplicitTarget bootstrap(Constructor<?> paramConstructor, List<?> paramList) {
/*  180 */     return bootstrap((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(paramConstructor), paramList);
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
/*      */   public static WithImplicitTarget bootstrap(MethodDescription.InDefinedShape paramInDefinedShape, Object... paramVarArgs) {
/*  195 */     return bootstrap(paramInDefinedShape, Arrays.asList(paramVarArgs));
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
/*      */   public static WithImplicitTarget bootstrap(MethodDescription.InDefinedShape paramInDefinedShape, List<?> paramList) {
/*  210 */     paramList = JavaConstant.Simple.wrap(paramList);
/*  211 */     if (!paramInDefinedShape.isInvokeBootstrap((List)TypeList.Explicit.of(paramList))) {
/*  212 */       throw new IllegalArgumentException("Not a valid bootstrap method " + paramInDefinedShape + " for " + paramList);
/*      */     }
/*  214 */     return new WithImplicitTarget(paramInDefinedShape, (List)paramList, new InvocationProvider.Default(), TerminationHandler.RETURNING, Assigner.DEFAULT, Assigner.Typing.STATIC);
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
/*      */   public static WithImplicitArguments lambda(Method paramMethod, Type paramType) {
/*  239 */     return lambda((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(paramMethod), (TypeDefinition)TypeDefinition.Sort.describe(paramType));
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
/*      */   public static WithImplicitArguments lambda(Method paramMethod, Type paramType, MethodGraph.Compiler paramCompiler) {
/*  260 */     return lambda((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(paramMethod), (TypeDefinition)TypeDefinition.Sort.describe(paramType), paramCompiler);
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
/*      */   public static WithImplicitArguments lambda(MethodDescription.InDefinedShape paramInDefinedShape, TypeDefinition paramTypeDefinition) {
/*  280 */     return lambda(paramInDefinedShape, paramTypeDefinition, MethodGraph.Compiler.Default.forJavaHierarchy());
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
/*      */   public static WithImplicitArguments lambda(MethodDescription.InDefinedShape paramInDefinedShape, TypeDefinition paramTypeDefinition, MethodGraph.Compiler paramCompiler) {
/*  303 */     if (!paramTypeDefinition.isInterface()) {
/*  304 */       throw new IllegalArgumentException(paramTypeDefinition + " is not an interface type");
/*      */     }
/*      */ 
/*      */     
/*      */     MethodList methodList;
/*      */     
/*  310 */     if ((methodList = (MethodList)paramCompiler.compile(paramTypeDefinition).listNodes().asMethodList().filter((ElementMatcher)ElementMatchers.isAbstract())).size() != 1) {
/*  311 */       throw new IllegalArgumentException(paramTypeDefinition + " does not define exactly one abstract method: " + methodList);
/*      */     }
/*  313 */     return bootstrap((MethodDescription.InDefinedShape)new MethodDescription.Latent((TypeDescription)new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, 
/*      */             
/*  315 */             TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new TypeDescription.Generic[0]), "metafactory", 9, 
/*      */ 
/*      */           
/*  318 */           Collections.emptyList(), JavaType.CALL_SITE
/*  319 */           .getTypeStub().asGenericType(), 
/*  320 */           Arrays.asList(new ParameterDescription.Token[] { new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType()), new ParameterDescription.Token(
/*  321 */                 TypeDescription.ForLoadedType.of(String.class).asGenericType()), new ParameterDescription.Token(JavaType.METHOD_TYPE
/*  322 */                 .getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_TYPE
/*  323 */                 .getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE
/*  324 */                 .getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_TYPE
/*  325 */                 .getTypeStub().asGenericType())
/*  326 */             }, ), Collections.emptyList(), 
/*  327 */           Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), new Object[] {
/*      */ 
/*      */           
/*  330 */           JavaConstant.MethodType.of((MethodDescription)methodList.asDefined().getOnly()), 
/*  331 */           JavaConstant.MethodHandle.of(paramInDefinedShape), 
/*  332 */           JavaConstant.MethodType.of((MethodDescription)methodList.getOnly()) }).invoke(((MethodDescription.InDefinedShape)methodList.asDefined().getOnly()).getInternalName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InvokeDynamic withBooleanValue(boolean... paramVarArgs) {
/*  343 */     ArrayList<InvocationProvider.ArgumentProvider.ForBooleanConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  344 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { boolean bool = paramVarArgs[b];
/*  345 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForBooleanConstant(bool)); b++; }
/*      */     
/*  347 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  349 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withByteValue(byte... paramVarArgs) {
/*  363 */     ArrayList<InvocationProvider.ArgumentProvider.ForByteConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  364 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { byte b1 = paramVarArgs[b];
/*  365 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForByteConstant(b1)); b++; }
/*      */     
/*  367 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  369 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withShortValue(short... paramVarArgs) {
/*  383 */     ArrayList<InvocationProvider.ArgumentProvider.ForShortConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  384 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { short s = paramVarArgs[b];
/*  385 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForShortConstant(s)); b++; }
/*      */     
/*  387 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  389 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withCharacterValue(char... paramVarArgs) {
/*  403 */     ArrayList<InvocationProvider.ArgumentProvider.ForCharacterConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  404 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { char c = paramVarArgs[b];
/*  405 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForCharacterConstant(c)); b++; }
/*      */     
/*  407 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  409 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withIntegerValue(int... paramVarArgs) {
/*  423 */     ArrayList<InvocationProvider.ArgumentProvider.ForIntegerConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  424 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/*  425 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForIntegerConstant(j)); b++; }
/*      */     
/*  427 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  429 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withLongValue(long... paramVarArgs) {
/*  443 */     ArrayList<InvocationProvider.ArgumentProvider.ForLongConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  444 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { long l = paramVarArgs[b];
/*  445 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForLongConstant(l)); b++; }
/*      */     
/*  447 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  449 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withFloatValue(float... paramVarArgs) {
/*  463 */     ArrayList<InvocationProvider.ArgumentProvider.ForFloatConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  464 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { float f = paramVarArgs[b];
/*  465 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForFloatConstant(f)); b++; }
/*      */     
/*  467 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  469 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withDoubleValue(double... paramVarArgs) {
/*  483 */     ArrayList<InvocationProvider.ArgumentProvider.ForDoubleConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  484 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { double d = paramVarArgs[b];
/*  485 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForDoubleConstant(d)); b++; }
/*      */     
/*  487 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  489 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withValue(Object... paramVarArgs) {
/*  507 */     ArrayList<InvocationProvider.ArgumentProvider> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  508 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Object object = paramVarArgs[b];
/*  509 */       arrayList.add(InvocationProvider.ArgumentProvider.ConstantPoolWrapper.of(object)); b++; }
/*      */     
/*  511 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  513 */         .appendArguments(arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public WithImplicitType withReference(Object paramObject) {
/*  529 */     return new WithImplicitType.OfInstance(this.bootstrap, this.arguments, this.invocationProvider, this.terminationHandler, this.assigner, this.typing, paramObject);
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
/*      */   public InvokeDynamic withReference(Object... paramVarArgs) {
/*  547 */     ArrayList<InvocationProvider.ArgumentProvider> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  548 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Object object = paramVarArgs[b];
/*  549 */       arrayList.add(InvocationProvider.ArgumentProvider.ForInstance.of(object)); b++; }
/*      */     
/*  551 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  553 */         .appendArguments(arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withType(TypeDescription... paramVarArgs) {
/*  568 */     ArrayList<InvocationProvider.ArgumentProvider.ForClassConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  569 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { TypeDescription typeDescription = paramVarArgs[b];
/*  570 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForClassConstant(typeDescription)); b++; }
/*      */     
/*  572 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  574 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withEnumeration(EnumerationDescription... paramVarArgs) {
/*  589 */     ArrayList<InvocationProvider.ArgumentProvider.ForEnumerationValue> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  590 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { EnumerationDescription enumerationDescription = paramVarArgs[b];
/*  591 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForEnumerationValue(enumerationDescription)); b++; }
/*      */     
/*  593 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  595 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withInstance(JavaConstant... paramVarArgs) {
/*  610 */     ArrayList<InvocationProvider.ArgumentProvider.ForJavaConstant> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  611 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { JavaConstant javaConstant = paramVarArgs[b];
/*  612 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForJavaConstant(javaConstant)); b++; }
/*      */     
/*  614 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  616 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withNullValue(Class<?>... paramVarArgs) {
/*  629 */     return withNullValue((TypeDescription[])(new TypeList.ForLoadedTypes(paramVarArgs)).toArray((Object[])new TypeDescription[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InvokeDynamic withNullValue(TypeDescription... paramVarArgs) {
/*  639 */     ArrayList<InvocationProvider.ArgumentProvider.ForNullValue> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  640 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  641 */       TypeDescription typeDescription; if ((typeDescription = paramVarArgs[b]).isPrimitive()) {
/*  642 */         throw new IllegalArgumentException("Cannot assign null to primitive type: " + typeDescription);
/*      */       }
/*  644 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForNullValue(typeDescription));
/*      */     } 
/*  646 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  648 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withArgument(int... paramVarArgs) {
/*  661 */     ArrayList<InvocationProvider.ArgumentProvider.ForMethodParameter> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  662 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  663 */       int j; if ((j = paramVarArgs[b]) < 0) {
/*  664 */         throw new IllegalArgumentException("Method parameter indices cannot be negative: " + j);
/*      */       }
/*  666 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForMethodParameter(j));
/*      */     } 
/*  668 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  670 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public WithImplicitType withArgument(int paramInt) {
/*  684 */     if (paramInt < 0) {
/*  685 */       throw new IllegalArgumentException("Method parameter indices cannot be negative: " + paramInt);
/*      */     }
/*  687 */     return new WithImplicitType.OfArgument(this.bootstrap, this.arguments, this.invocationProvider, this.terminationHandler, this.assigner, this.typing, paramInt);
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
/*      */   public InvokeDynamic withThis(Class<?>... paramVarArgs) {
/*  704 */     return withThis((TypeDescription[])(new TypeList.ForLoadedTypes(paramVarArgs)).toArray((Object[])new TypeDescription[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InvokeDynamic withThis(TypeDescription... paramVarArgs) {
/*  715 */     ArrayList<InvocationProvider.ArgumentProvider.ForThisInstance> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  716 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { TypeDescription typeDescription = paramVarArgs[b];
/*  717 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForThisInstance(typeDescription)); b++; }
/*      */     
/*  719 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  721 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withMethodArguments() {
/*  733 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  735 */         .appendArgument(InvocationProvider.ArgumentProvider.ForInterceptedMethodParameters.INSTANCE), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withImplicitAndMethodArguments() {
/*  748 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  750 */         .appendArgument(InvocationProvider.ArgumentProvider.ForInterceptedMethodInstanceAndParameters.INSTANCE), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public InvokeDynamic withField(String... paramVarArgs) {
/*  764 */     return withField((FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE, paramVarArgs);
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
/*      */   public InvokeDynamic withField(FieldLocator.Factory paramFactory, String... paramVarArgs) {
/*  776 */     ArrayList<InvocationProvider.ArgumentProvider.ForField> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  777 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/*  778 */       arrayList.add(new InvocationProvider.ArgumentProvider.ForField(str, paramFactory)); b++; }
/*      */     
/*  780 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */         
/*  782 */         .appendArguments((List)arrayList), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public WithImplicitType withField(String paramString) {
/*  796 */     return withField(paramString, (FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE);
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
/*      */   public WithImplicitType withField(String paramString, FieldLocator.Factory paramFactory) {
/*  808 */     return new WithImplicitType.OfField(this.bootstrap, this.arguments, this.invocationProvider, this.terminationHandler, this.assigner, this.typing, paramString, paramFactory);
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
/*      */   public Implementation.Composable withAssigner(Assigner paramAssigner, Assigner.Typing paramTyping) {
/*  827 */     return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider, this.terminationHandler, paramAssigner, paramTyping);
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
/*      */   public Implementation andThen(Implementation paramImplementation) {
/*  839 */     return new Implementation.Compound(new Implementation[] { new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider, TerminationHandler.DROPPING, this.assigner, this.typing), paramImplementation });
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
/*      */   public Implementation.Composable andThen(Implementation.Composable paramComposable) {
/*  852 */     return new Implementation.Compound.Composable(new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider, TerminationHandler.DROPPING, this.assigner, this.typing), paramComposable);
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
/*      */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/*  865 */     return this.invocationProvider.prepare(paramInstrumentedType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/*  872 */     return new Appender(this, paramTarget.getInstrumentedType());
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
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.terminationHandler.equals(((InvokeDynamic)paramObject).terminationHandler) ? false : (!this.typing.equals(((InvokeDynamic)paramObject).typing) ? false : (!this.bootstrap.equals(((InvokeDynamic)paramObject).bootstrap) ? false : (!this.arguments.equals(((InvokeDynamic)paramObject).arguments) ? false : (!this.invocationProvider.equals(((InvokeDynamic)paramObject).invocationProvider) ? false : (!!this.assigner.equals(((InvokeDynamic)paramObject).assigner)))))))));
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
/*      */   public int hashCode() {
/*      */     return (((((getClass().hashCode() * 31 + this.bootstrap.hashCode()) * 31 + this.arguments.hashCode()) * 31 + this.invocationProvider.hashCode()) * 31 + this.terminationHandler.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.typing.hashCode();
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
/*      */   public enum ForInterceptedMethodInstanceAndParameters
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/* 1097 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1103 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(MethodVariableAccess.allArgumentsOf(param1MethodDescription).prependThisReference(), 
/* 1104 */           param1MethodDescription.isStatic() ? (List<TypeDescription>)param1MethodDescription
/* 1105 */           .getParameters().asTypeList().asErasures() : 
/* 1106 */           CompoundList.of(param1MethodDescription.getDeclaringType().asErasure(), (List)param1MethodDescription.getParameters().asTypeList().asErasures()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1113 */       return param1InstrumentedType;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum ForInterceptedMethodParameters
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/* 1125 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1131 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)MethodVariableAccess.allArgumentsOf(param1MethodDescription), (List<TypeDescription>)param1MethodDescription
/* 1132 */           .getParameters().asTypeList().asErasures());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1139 */       return param1InstrumentedType;
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
/*      */   public enum ConstantPoolWrapper
/*      */   {
/* 1152 */     BOOLEAN((String)boolean.class, Boolean.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1155 */         return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Boolean)param4Object).booleanValue()));
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1162 */     BYTE((String)byte.class, Byte.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1165 */         return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Byte)param4Object).byteValue()));
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1172 */     SHORT((String)short.class, Short.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1175 */         return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Short)param4Object).shortValue()));
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1182 */     CHARACTER((String)char.class, Character.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1185 */         return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Character)param4Object).charValue()));
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1192 */     INTEGER((String)int.class, Integer.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1195 */         return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Integer)param4Object).intValue()));
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1202 */     LONG((String)long.class, Long.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1205 */         return new WrappingArgumentProvider(this, LongConstant.forValue(((Long)param4Object).longValue()));
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1212 */     FLOAT((String)float.class, Float.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1215 */         return new WrappingArgumentProvider(this, FloatConstant.forValue(((Float)param4Object).floatValue()));
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1222 */     DOUBLE((String)double.class, Double.class)
/*      */     {
/*      */       protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) {
/* 1225 */         return new WrappingArgumentProvider(this, DoubleConstant.forValue(((Double)param4Object).doubleValue()));
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription primitiveType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription wrapperType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ConstantPoolWrapper(Class<?> param1Class1, Class<?> param1Class2) {
/* 1246 */       this.primitiveType = TypeDescription.ForLoadedType.of(param1Class1);
/* 1247 */       this.wrapperType = TypeDescription.ForLoadedType.of(param1Class2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static InvokeDynamic.InvocationProvider.ArgumentProvider of(Object param1Object) {
/* 1257 */       if (param1Object instanceof Boolean)
/* 1258 */         return BOOLEAN.make(param1Object); 
/* 1259 */       if (param1Object instanceof Byte)
/* 1260 */         return BYTE.make(param1Object); 
/* 1261 */       if (param1Object instanceof Short)
/* 1262 */         return SHORT.make(param1Object); 
/* 1263 */       if (param1Object instanceof Character)
/* 1264 */         return CHARACTER.make(param1Object); 
/* 1265 */       if (param1Object instanceof Integer)
/* 1266 */         return INTEGER.make(param1Object); 
/* 1267 */       if (param1Object instanceof Long)
/* 1268 */         return LONG.make(param1Object); 
/* 1269 */       if (param1Object instanceof Float)
/* 1270 */         return FLOAT.make(param1Object); 
/* 1271 */       if (param1Object instanceof Double)
/* 1272 */         return DOUBLE.make(param1Object); 
/* 1273 */       if (param1Object instanceof String)
/* 1274 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForStringConstant((String)param1Object); 
/* 1275 */       if (param1Object instanceof Class)
/* 1276 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForClassConstant(TypeDescription.ForLoadedType.of((Class)param1Object)); 
/* 1277 */       if (param1Object instanceof TypeDescription)
/* 1278 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForClassConstant((TypeDescription)param1Object); 
/* 1279 */       if (param1Object instanceof Enum)
/* 1280 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForEnumerationValue((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)param1Object)); 
/* 1281 */       if (param1Object instanceof EnumerationDescription)
/* 1282 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForEnumerationValue((EnumerationDescription)param1Object); 
/* 1283 */       if (JavaType.METHOD_HANDLE.isInstance(param1Object))
/* 1284 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)JavaConstant.MethodHandle.ofLoaded(param1Object)); 
/* 1285 */       if (JavaType.METHOD_TYPE.isInstance(param1Object))
/* 1286 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)JavaConstant.MethodType.ofLoaded(param1Object)); 
/* 1287 */       if (param1Object instanceof JavaConstant) {
/* 1288 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)param1Object);
/*      */       }
/* 1290 */       return InvokeDynamic.InvocationProvider.ArgumentProvider.ForInstance.of(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected abstract InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param1Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance(includeSyntheticFields = true)
/*      */     protected class WrappingArgumentProvider
/*      */       implements InvokeDynamic.InvocationProvider.ArgumentProvider
/*      */     {
/*      */       private final StackManipulation stackManipulation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected WrappingArgumentProvider(InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper this$0, StackManipulation param4StackManipulation) {
/* 1320 */         this.stackManipulation = param4StackManipulation;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Assigner param4Assigner, Assigner.Typing param4Typing) {
/* 1327 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.stackManipulation, param4Assigner
/* 1328 */                 .assign(InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.a(this.a).asGenericType(), InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.b(this.a).asGenericType(), param4Typing) }), InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.b(this.a));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param4InstrumentedType) {
/* 1335 */         return param4InstrumentedType;
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
/*      */       public boolean equals(@MaybeNull Object param4Object) {
/*      */         return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.a.equals(((WrappingArgumentProvider)param4Object).a) ? false : (!!this.stackManipulation.equals(((WrappingArgumentProvider)param4Object).stackManipulation)))));
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
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.a.hashCode();
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
/*      */   public static class ForThisInstance
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final TypeDescription typeDescription;
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
/*      */     protected ForThisInstance(TypeDescription param1TypeDescription) {
/* 1430 */       this.typeDescription = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1437 */       if (param1MethodDescription.isStatic())
/* 1438 */         throw new IllegalStateException("Cannot get this instance from static method: " + param1MethodDescription); 
/* 1439 */       if (!param1TypeDescription.isAssignableTo(this.typeDescription)) {
/* 1440 */         throw new IllegalStateException(param1TypeDescription + " is not assignable to " + param1TypeDescription);
/*      */       }
/* 1442 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(MethodVariableAccess.loadThis(), this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1449 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typeDescription.equals(((ForThisInstance)param1Object).typeDescription))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForInstance
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private static final String FIELD_PREFIX = "invokeDynamic";
/*      */ 
/*      */     
/*      */     private final Object value;
/*      */ 
/*      */     
/*      */     private final TypeDescription fieldType;
/*      */ 
/*      */     
/*      */     @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*      */     private final String name;
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForInstance(Object param1Object, TypeDescription param1TypeDescription) {
/* 1487 */       this.value = param1Object;
/* 1488 */       this.fieldType = param1TypeDescription;
/* 1489 */       this.name = "invokeDynamic$" + RandomString.hashOf(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static InvokeDynamic.InvocationProvider.ArgumentProvider of(Object param1Object) {
/* 1499 */       return new ForInstance(param1Object, TypeDescription.ForLoadedType.of(param1Object.getClass()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1506 */       FieldDescription fieldDescription = (FieldDescription)((FieldList)param1TypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly();
/*      */       StackManipulation stackManipulation;
/* 1508 */       if (!(stackManipulation = param1Assigner.assign(fieldDescription.getType(), this.fieldType.asGenericType(), param1Typing)).isValid()) {
/* 1509 */         throw new IllegalStateException("Cannot assign " + fieldDescription + " to " + this.fieldType);
/*      */       }
/* 1511 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { FieldAccess.forField(fieldDescription).read(), stackManipulation }, ), fieldDescription
/* 1512 */           .getType().asErasure());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1519 */       return param1InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4169, this.fieldType
/*      */             
/* 1521 */             .asGenericType()), this.value);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.value.equals(((ForInstance)param1Object).value) ? false : (!!this.fieldType.equals(((ForInstance)param1Object).fieldType)))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.value.hashCode()) * 31 + this.fieldType.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForField
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     protected final String fieldName;
/*      */     
/*      */     protected final FieldLocator.Factory fieldLocatorFactory;
/*      */ 
/*      */     
/*      */     protected ForField(String param1String, FieldLocator.Factory param1Factory) {
/* 1548 */       this.fieldName = param1String;
/* 1549 */       this.fieldLocatorFactory = param1Factory;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*      */       FieldLocator.Resolution resolution;
/* 1557 */       if (!(resolution = this.fieldLocatorFactory.make(param1TypeDescription).locate(this.fieldName)).isResolved())
/* 1558 */         throw new IllegalStateException("Cannot find a field " + this.fieldName + " for " + param1TypeDescription); 
/* 1559 */       if (!resolution.getField().isStatic() && param1MethodDescription.isStatic()) {
/* 1560 */         throw new IllegalStateException("Cannot access non-static " + resolution.getField() + " from " + param1MethodDescription);
/*      */       }
/* 1562 */       return doResolve((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { resolution.getField().isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*      */               
/* 1564 */               MethodVariableAccess.loadThis(), FieldAccess.forField(resolution.getField()).read() }, ), resolution
/* 1565 */           .getField().getType(), param1Assigner, param1Typing);
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
/*      */     
/*      */     protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param1StackManipulation, TypeDescription.Generic param1Generic, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1580 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(param1StackManipulation, param1Generic.asErasure());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1587 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.fieldName.equals(((ForField)param1Object).fieldName) ? false : (!!this.fieldLocatorFactory.equals(((ForField)param1Object).fieldLocatorFactory)))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.fieldName.hashCode()) * 31 + this.fieldLocatorFactory.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class WithExplicitType
/*      */       extends ForField
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */ 
/*      */       
/*      */       protected WithExplicitType(String param4String, FieldLocator.Factory param4Factory, TypeDescription param4TypeDescription) {
/* 1609 */         super(param4String, param4Factory);
/* 1610 */         this.typeDescription = param4TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param4StackManipulation, TypeDescription.Generic param4Generic, Assigner param4Assigner, Assigner.Typing param4Typing) {
/*      */         StackManipulation stackManipulation;
/* 1618 */         if (!(stackManipulation = param4Assigner.assign(param4Generic, this.typeDescription.asGenericType(), param4Typing)).isValid()) {
/* 1619 */           throw new IllegalStateException("Cannot assign " + param4Generic + " to " + this.typeDescription);
/*      */         }
/* 1621 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param4StackManipulation, stackManipulation }, ), this.typeDescription);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param4Object) {
/*      */         return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((WithExplicitType)param4Object).typeDescription)))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.typeDescription.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForMethodParameter
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     protected final int index;
/*      */     
/*      */     protected ForMethodParameter(int param1Int) {
/* 1643 */       this.index = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1650 */       ParameterList parameterList = param1MethodDescription.getParameters();
/* 1651 */       if (this.index >= parameterList.size()) {
/* 1652 */         throw new IllegalStateException("No parameter " + this.index + " for " + param1MethodDescription);
/*      */       }
/* 1654 */       return doResolve(MethodVariableAccess.load((ParameterDescription)parameterList.get(this.index)), ((ParameterDescription)parameterList.get(this.index)).getType(), param1Assigner, param1Typing);
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
/*      */     protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param1StackManipulation, TypeDescription.Generic param1Generic, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1667 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(param1StackManipulation, param1Generic.asErasure());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1674 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.index != ((ForMethodParameter)param1Object).index))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.index;
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class WithExplicitType
/*      */       extends ForMethodParameter
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */       
/*      */       protected WithExplicitType(int param4Int, TypeDescription param4TypeDescription) {
/* 1695 */         super(param4Int);
/* 1696 */         this.typeDescription = param4TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param4StackManipulation, TypeDescription.Generic param4Generic, Assigner param4Assigner, Assigner.Typing param4Typing) {
/*      */         StackManipulation stackManipulation;
/* 1704 */         if (!(stackManipulation = param4Assigner.assign(param4Generic, this.typeDescription.asGenericType(), param4Typing)).isValid()) {
/* 1705 */           throw new IllegalStateException("Cannot assign " + param4Generic + " to " + this.typeDescription);
/*      */         }
/* 1707 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param4StackManipulation, stackManipulation }, ), this.typeDescription);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param4Object) {
/*      */         return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((WithExplicitType)param4Object).typeDescription)))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.typeDescription.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForBooleanConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final boolean value;
/*      */     
/*      */     protected ForBooleanConstant(boolean param1Boolean) {
/* 1729 */       this.value = param1Boolean;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1736 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(boolean.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1743 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ForBooleanConstant)param1Object).value))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForByteConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final byte value;
/*      */     
/*      */     protected ForByteConstant(byte param1Byte) {
/* 1764 */       this.value = param1Byte;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1771 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(byte.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1778 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ForByteConstant)param1Object).value))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForShortConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final short value;
/*      */     
/*      */     protected ForShortConstant(short param1Short) {
/* 1799 */       this.value = param1Short;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1806 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(short.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1813 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ForShortConstant)param1Object).value))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForCharacterConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final char value;
/*      */     
/*      */     protected ForCharacterConstant(char param1Char) {
/* 1834 */       this.value = param1Char;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1841 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(char.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1848 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ForCharacterConstant)param1Object).value))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForIntegerConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final int value;
/*      */     
/*      */     protected ForIntegerConstant(int param1Int) {
/* 1869 */       this.value = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1876 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(int.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1883 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ForIntegerConstant)param1Object).value))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForLongConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final long value;
/*      */     
/*      */     protected ForLongConstant(long param1Long) {
/* 1904 */       this.value = param1Long;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1911 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(LongConstant.forValue(this.value), TypeDescription.ForLoadedType.of(long.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1918 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ForLongConstant)param1Object).value))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + (int)(this.value ^ this.value >>> 32L);
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForFloatConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final float value;
/*      */     
/*      */     protected ForFloatConstant(float param1Float) {
/* 1939 */       this.value = param1Float;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1946 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(FloatConstant.forValue(this.value), TypeDescription.ForLoadedType.of(float.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1953 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(Float.compare(this.value, ((ForFloatConstant)param1Object).value) != 0))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + Float.floatToIntBits(this.value);
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForDoubleConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final double value;
/*      */     
/*      */     protected ForDoubleConstant(double param1Double) {
/* 1974 */       this.value = param1Double;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1981 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(DoubleConstant.forValue(this.value), TypeDescription.ForLoadedType.of(double.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 1988 */       return param1InstrumentedType;
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
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(Double.compare(this.value, ((ForDoubleConstant)param1Object).value) != 0))));
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
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + (int)(Double.doubleToLongBits(this.value) ^ Double.doubleToLongBits(this.value) >>> 32L);
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
/*      */   @Enhance
/*      */   public static class ForClassConstant
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final TypeDescription typeDescription;
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
/*      */     protected ForClassConstant(TypeDescription param1TypeDescription) {
/* 2044 */       this.typeDescription = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2051 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(ClassConstant.of(this.typeDescription), TypeDescription.ForLoadedType.of(Class.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 2058 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typeDescription.equals(((ForClassConstant)param1Object).typeDescription))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForEnumerationValue
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final EnumerationDescription enumerationDescription;
/*      */     
/*      */     protected ForEnumerationValue(EnumerationDescription param1EnumerationDescription) {
/* 2079 */       this.enumerationDescription = param1EnumerationDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2086 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(FieldAccess.forEnumeration(this.enumerationDescription), this.enumerationDescription.getEnumerationType());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 2093 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.enumerationDescription.equals(((ForEnumerationValue)param1Object).enumerationDescription))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.enumerationDescription.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForNullValue
/*      */     implements InvocationProvider.ArgumentProvider
/*      */   {
/*      */     private final TypeDescription typeDescription;
/*      */     
/*      */     protected ForNullValue(TypeDescription param1TypeDescription) {
/* 2114 */       this.typeDescription = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2121 */       return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)NullConstant.INSTANCE, this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType)
/*      */     {
/* 2128 */       return param1InstrumentedType; } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typeDescription.equals(((ForNullValue)param1Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } public static interface ArgumentProvider { Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing); InstrumentedType prepare(InstrumentedType param1InstrumentedType); public enum ForInterceptedMethodInstanceAndParameters implements ArgumentProvider { INSTANCE; public final InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(MethodVariableAccess.allArgumentsOf(param3MethodDescription).prependThisReference(), param3MethodDescription.isStatic() ? (List<TypeDescription>)param3MethodDescription.getParameters().asTypeList().asErasures() : CompoundList.of(param3MethodDescription.getDeclaringType().asErasure(), (List)param3MethodDescription.getParameters().asTypeList().asErasures())); } public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } } public enum ForInterceptedMethodParameters implements ArgumentProvider { INSTANCE; public final InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)MethodVariableAccess.allArgumentsOf(param3MethodDescription), (List<TypeDescription>)param3MethodDescription.getParameters().asTypeList().asErasures()); } public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } } public enum ConstantPoolWrapper { BOOLEAN((String)boolean.class, Boolean.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Boolean)param4Object).booleanValue())); } }, BYTE((String)byte.class, Byte.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Byte)param4Object).byteValue())); } }, SHORT((String)short.class, Short.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Short)param4Object).shortValue())); } }, CHARACTER((String)char.class, Character.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Character)param4Object).charValue())); } }, INTEGER((String)int.class, Integer.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Integer)param4Object).intValue())); } }, LONG((String)long.class, Long.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, LongConstant.forValue(((Long)param4Object).longValue())); } }, FLOAT((String)float.class, Float.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, FloatConstant.forValue(((Float)param4Object).floatValue())); } }, DOUBLE((String)double.class, Double.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, DoubleConstant.forValue(((Double)param4Object).doubleValue())); } }; private final TypeDescription primitiveType; private final TypeDescription wrapperType; ConstantPoolWrapper(Class<?> param3Class1, Class<?> param3Class2) { this.primitiveType = TypeDescription.ForLoadedType.of(param3Class1); this.wrapperType = TypeDescription.ForLoadedType.of(param3Class2); } public static InvokeDynamic.InvocationProvider.ArgumentProvider of(Object param3Object) { if (param3Object instanceof Boolean) return BOOLEAN.make(param3Object);  if (param3Object instanceof Byte) return BYTE.make(param3Object);  if (param3Object instanceof Short) return SHORT.make(param3Object);  if (param3Object instanceof Character) return CHARACTER.make(param3Object);  if (param3Object instanceof Integer) return INTEGER.make(param3Object);  if (param3Object instanceof Long) return LONG.make(param3Object);  if (param3Object instanceof Float) return FLOAT.make(param3Object);  if (param3Object instanceof Double) return DOUBLE.make(param3Object);  if (param3Object instanceof String) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForStringConstant((String)param3Object);  if (param3Object instanceof Class) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForClassConstant(TypeDescription.ForLoadedType.of((Class)param3Object));  if (param3Object instanceof TypeDescription) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForClassConstant((TypeDescription)param3Object);  if (param3Object instanceof Enum) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForEnumerationValue((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)param3Object));  if (param3Object instanceof EnumerationDescription) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForEnumerationValue((EnumerationDescription)param3Object);  if (JavaType.METHOD_HANDLE.isInstance(param3Object)) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)JavaConstant.MethodHandle.ofLoaded(param3Object));  if (JavaType.METHOD_TYPE.isInstance(param3Object)) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)JavaConstant.MethodType.ofLoaded(param3Object));  if (param3Object instanceof JavaConstant) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)param3Object);  return InvokeDynamic.InvocationProvider.ArgumentProvider.ForInstance.of(param3Object); } protected abstract InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param3Object); @Enhance(includeSyntheticFields = true) protected class WrappingArgumentProvider implements InvokeDynamic.InvocationProvider.ArgumentProvider { private final StackManipulation stackManipulation; protected WrappingArgumentProvider(InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper this$0, StackManipulation param4StackManipulation) { this.stackManipulation = param4StackManipulation; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Assigner param4Assigner, Assigner.Typing param4Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.stackManipulation, param4Assigner.assign(InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.a(this.a).asGenericType(), InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.b(this.a).asGenericType(), param4Typing) }), InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.b(this.a)); } public InstrumentedType prepare(InstrumentedType param4InstrumentedType) { return param4InstrumentedType; } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.a.equals(((WrappingArgumentProvider)param4Object).a) ? false : (!!this.stackManipulation.equals(((WrappingArgumentProvider)param4Object).stackManipulation))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.a.hashCode(); } } } public static interface Resolved { StackManipulation getLoadInstruction(); List<TypeDescription> getLoadedTypes(); @Enhance public static class Simple implements Resolved { private final StackManipulation stackManipulation; private final List<TypeDescription> loadedTypes; public Simple(StackManipulation param4StackManipulation, TypeDescription param4TypeDescription) { this(param4StackManipulation, Collections.singletonList(param4TypeDescription)); } public Simple(StackManipulation param4StackManipulation, List<TypeDescription> param4List) { this.stackManipulation = param4StackManipulation; this.loadedTypes = param4List; } public StackManipulation getLoadInstruction() { return this.stackManipulation; } public List<TypeDescription> getLoadedTypes() { return this.loadedTypes; } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.stackManipulation.equals(((Simple)param4Object).stackManipulation) ? false : (!!this.loadedTypes.equals(((Simple)param4Object).loadedTypes))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.loadedTypes.hashCode(); } } } @Enhance public static class ForThisInstance implements ArgumentProvider { private final TypeDescription typeDescription; protected ForThisInstance(TypeDescription param3TypeDescription) { this.typeDescription = param3TypeDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { if (param3MethodDescription.isStatic()) throw new IllegalStateException("Cannot get this instance from static method: " + param3MethodDescription);  if (!param3TypeDescription.isAssignableTo(this.typeDescription)) throw new IllegalStateException(param3TypeDescription + " is not assignable to " + param3TypeDescription);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(MethodVariableAccess.loadThis(), this.typeDescription); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForThisInstance)param3Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } @Enhance public static class ForInstance implements ArgumentProvider { private static final String FIELD_PREFIX = "invokeDynamic"; private final Object value; private final TypeDescription fieldType; @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE) private final String name; protected ForInstance(Object param3Object, TypeDescription param3TypeDescription) { this.value = param3Object; this.fieldType = param3TypeDescription; this.name = "invokeDynamic$" + RandomString.hashOf(param3Object); } protected static InvokeDynamic.InvocationProvider.ArgumentProvider of(Object param3Object) { return new ForInstance(param3Object, TypeDescription.ForLoadedType.of(param3Object.getClass())); } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { FieldDescription fieldDescription = (FieldDescription)((FieldList)param3TypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly(); StackManipulation stackManipulation; if (!(stackManipulation = param3Assigner.assign(fieldDescription.getType(), this.fieldType.asGenericType(), param3Typing)).isValid()) throw new IllegalStateException("Cannot assign " + fieldDescription + " to " + this.fieldType);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { FieldAccess.forField(fieldDescription).read(), stackManipulation }, ), fieldDescription.getType().asErasure()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4169, this.fieldType.asGenericType()), this.value); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.value.equals(((ForInstance)param3Object).value) ? false : (!!this.fieldType.equals(((ForInstance)param3Object).fieldType))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.value.hashCode()) * 31 + this.fieldType.hashCode(); } } @Enhance public static class ForField implements ArgumentProvider { protected final String fieldName; protected final FieldLocator.Factory fieldLocatorFactory; protected ForField(String param3String, FieldLocator.Factory param3Factory) { this.fieldName = param3String; this.fieldLocatorFactory = param3Factory; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { FieldLocator.Resolution resolution; if (!(resolution = this.fieldLocatorFactory.make(param3TypeDescription).locate(this.fieldName)).isResolved()) throw new IllegalStateException("Cannot find a field " + this.fieldName + " for " + param3TypeDescription);  if (!resolution.getField().isStatic() && param3MethodDescription.isStatic()) throw new IllegalStateException("Cannot access non-static " + resolution.getField() + " from " + param3MethodDescription);  return doResolve((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { resolution.getField().isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(resolution.getField()).read() }, ), resolution.getField().getType(), param3Assigner, param3Typing); } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param3StackManipulation, TypeDescription.Generic param3Generic, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(param3StackManipulation, param3Generic.asErasure()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fieldName.equals(((ForField)param3Object).fieldName) ? false : (!!this.fieldLocatorFactory.equals(((ForField)param3Object).fieldLocatorFactory))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fieldName.hashCode()) * 31 + this.fieldLocatorFactory.hashCode(); } @Enhance protected static class WithExplicitType extends ForField { private final TypeDescription typeDescription; protected WithExplicitType(String param4String, FieldLocator.Factory param4Factory, TypeDescription param4TypeDescription) { super(param4String, param4Factory); this.typeDescription = param4TypeDescription; } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param4StackManipulation, TypeDescription.Generic param4Generic, Assigner param4Assigner, Assigner.Typing param4Typing) { StackManipulation stackManipulation; if (!(stackManipulation = param4Assigner.assign(param4Generic, this.typeDescription.asGenericType(), param4Typing)).isValid()) throw new IllegalStateException("Cannot assign " + param4Generic + " to " + this.typeDescription);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param4StackManipulation, stackManipulation }, ), this.typeDescription); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((WithExplicitType)param4Object).typeDescription))))); } public int hashCode() { return super.hashCode() * 31 + this.typeDescription.hashCode(); } } } @Enhance public static class ForMethodParameter implements ArgumentProvider { protected final int index; protected ForMethodParameter(int param3Int) { this.index = param3Int; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { ParameterList parameterList = param3MethodDescription.getParameters(); if (this.index >= parameterList.size()) throw new IllegalStateException("No parameter " + this.index + " for " + param3MethodDescription);  return doResolve(MethodVariableAccess.load((ParameterDescription)parameterList.get(this.index)), ((ParameterDescription)parameterList.get(this.index)).getType(), param3Assigner, param3Typing); } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param3StackManipulation, TypeDescription.Generic param3Generic, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(param3StackManipulation, param3Generic.asErasure()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((ForMethodParameter)param3Object).index)))); } public int hashCode() { return getClass().hashCode() * 31 + this.index; } @Enhance protected static class WithExplicitType extends ForMethodParameter { private final TypeDescription typeDescription; protected WithExplicitType(int param4Int, TypeDescription param4TypeDescription) { super(param4Int); this.typeDescription = param4TypeDescription; } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param4StackManipulation, TypeDescription.Generic param4Generic, Assigner param4Assigner, Assigner.Typing param4Typing) { StackManipulation stackManipulation; if (!(stackManipulation = param4Assigner.assign(param4Generic, this.typeDescription.asGenericType(), param4Typing)).isValid()) throw new IllegalStateException("Cannot assign " + param4Generic + " to " + this.typeDescription);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param4StackManipulation, stackManipulation }, ), this.typeDescription); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((WithExplicitType)param4Object).typeDescription))))); } public int hashCode() { return super.hashCode() * 31 + this.typeDescription.hashCode(); } } } @Enhance public static class ForBooleanConstant implements ArgumentProvider { private final boolean value; protected ForBooleanConstant(boolean param3Boolean) { this.value = param3Boolean; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(boolean.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForBooleanConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForByteConstant implements ArgumentProvider { private final byte value; protected ForByteConstant(byte param3Byte) { this.value = param3Byte; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(byte.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForByteConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForShortConstant implements ArgumentProvider { private final short value; protected ForShortConstant(short param3Short) { this.value = param3Short; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(short.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForShortConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForCharacterConstant implements ArgumentProvider { private final char value; protected ForCharacterConstant(char param3Char) { this.value = param3Char; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(char.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForCharacterConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForIntegerConstant implements ArgumentProvider { private final int value; protected ForIntegerConstant(int param3Int) { this.value = param3Int; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(int.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForIntegerConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForLongConstant implements ArgumentProvider { private final long value; protected ForLongConstant(long param3Long) { this.value = param3Long; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(LongConstant.forValue(this.value), TypeDescription.ForLoadedType.of(long.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForLongConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + (int)(this.value ^ this.value >>> 32L); } } @Enhance public static class ForFloatConstant implements ArgumentProvider { private final float value; protected ForFloatConstant(float param3Float) { this.value = param3Float; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(FloatConstant.forValue(this.value), TypeDescription.ForLoadedType.of(float.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(Float.compare(this.value, ((ForFloatConstant)param3Object).value) != 0)))); } public int hashCode() { return getClass().hashCode() * 31 + Float.floatToIntBits(this.value); } } @Enhance public static class ForDoubleConstant implements ArgumentProvider { private final double value; protected ForDoubleConstant(double param3Double) { this.value = param3Double; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(DoubleConstant.forValue(this.value), TypeDescription.ForLoadedType.of(double.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(Double.compare(this.value, ((ForDoubleConstant)param3Object).value) != 0)))); } public int hashCode() { return getClass().hashCode() * 31 + (int)(Double.doubleToLongBits(this.value) ^ Double.doubleToLongBits(this.value) >>> 32L); } } @Enhance public static class ForStringConstant implements ArgumentProvider { private final String value; protected ForStringConstant(String param3String) { this.value = param3String; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new TextConstant(this.value), TypeDescription.ForLoadedType.of(String.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.value.equals(((ForStringConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value.hashCode(); } } @Enhance public static class ForClassConstant implements ArgumentProvider { private final TypeDescription typeDescription; protected ForClassConstant(TypeDescription param3TypeDescription) { this.typeDescription = param3TypeDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(ClassConstant.of(this.typeDescription), TypeDescription.ForLoadedType.of(Class.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForClassConstant)param3Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } @Enhance public static class ForEnumerationValue implements ArgumentProvider { private final EnumerationDescription enumerationDescription; protected ForEnumerationValue(EnumerationDescription param3EnumerationDescription) { this.enumerationDescription = param3EnumerationDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(FieldAccess.forEnumeration(this.enumerationDescription), this.enumerationDescription.getEnumerationType()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.enumerationDescription.equals(((ForEnumerationValue)param3Object).enumerationDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.enumerationDescription.hashCode(); } } @Enhance public static class ForNullValue implements ArgumentProvider { private final TypeDescription typeDescription; protected ForNullValue(TypeDescription param3TypeDescription) { this.typeDescription = param3TypeDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)NullConstant.INSTANCE, this.typeDescription); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForNullValue)param3Object).typeDescription))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */       } }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForJavaConstant
/*      */       implements ArgumentProvider
/*      */     {
/*      */       private final JavaConstant javaConstant;
/*      */       
/*      */       protected ForJavaConstant(JavaConstant param3JavaConstant) {
/* 2149 */         this.javaConstant = param3JavaConstant;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) {
/* 2156 */         return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new JavaConstantValue(this.javaConstant), this.javaConstant.getTypeDescription());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param3InstrumentedType)
/*      */       {
/* 2163 */         return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.javaConstant.equals(((ForJavaConstant)param3Object).javaConstant)))); } public int hashCode() { return getClass().hashCode() * 31 + this.javaConstant.hashCode(); } } } @Enhance public static class ForJavaConstant implements InvocationProvider.ArgumentProvider { private final JavaConstant javaConstant; protected ForJavaConstant(JavaConstant param1JavaConstant) { this.javaConstant = param1JavaConstant; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new JavaConstantValue(this.javaConstant), this.javaConstant.getTypeDescription()); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.javaConstant.equals(((ForJavaConstant)param1Object).javaConstant)))); } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public int hashCode() { return getClass().hashCode() * 31 + this.javaConstant.hashCode(); } } protected static interface InvocationProvider { Target make(MethodDescription param1MethodDescription); InvocationProvider appendArguments(List<ArgumentProvider> param1List); InvocationProvider appendArgument(ArgumentProvider param1ArgumentProvider); InvocationProvider withoutArguments(); InvocationProvider withNameProvider(NameProvider param1NameProvider); InvocationProvider withReturnTypeProvider(ReturnTypeProvider param1ReturnTypeProvider); InstrumentedType prepare(InstrumentedType param1InstrumentedType); public static interface Target { Resolved resolve(TypeDescription param2TypeDescription, Assigner param2Assigner, Assigner.Typing param2Typing); public static interface Resolved { StackManipulation getStackManipulation(); TypeDescription getReturnType(); String getInternalName(); List<TypeDescription> getParameterTypes(); @Enhance public static class Simple implements Resolved { private final StackManipulation stackManipulation; private final String internalName; private final TypeDescription returnType; private final List<TypeDescription> parameterTypes; public Simple(StackManipulation param4StackManipulation, String param4String, TypeDescription param4TypeDescription, List<TypeDescription> param4List) { this.stackManipulation = param4StackManipulation; this.internalName = param4String; this.returnType = param4TypeDescription; this.parameterTypes = param4List; } public StackManipulation getStackManipulation() { return this.stackManipulation; } public TypeDescription getReturnType() { return this.returnType; } public String getInternalName() { return this.internalName; } public List<TypeDescription> getParameterTypes() { return this.parameterTypes; } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.internalName.equals(((Simple)param4Object).internalName) ? false : (!this.stackManipulation.equals(((Simple)param4Object).stackManipulation) ? false : (!this.returnType.equals(((Simple)param4Object).returnType) ? false : (!!this.parameterTypes.equals(((Simple)param4Object).parameterTypes))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.internalName.hashCode()) * 31 + this.returnType.hashCode()) * 31 + this.parameterTypes.hashCode(); } } } } public static interface ArgumentProvider { Resolved resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Assigner.Typing param2Typing); InstrumentedType prepare(InstrumentedType param2InstrumentedType); public enum ForInterceptedMethodInstanceAndParameters implements ArgumentProvider { INSTANCE; public final InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(MethodVariableAccess.allArgumentsOf(param3MethodDescription).prependThisReference(), param3MethodDescription.isStatic() ? (List<TypeDescription>)param3MethodDescription.getParameters().asTypeList().asErasures() : CompoundList.of(param3MethodDescription.getDeclaringType().asErasure(), (List)param3MethodDescription.getParameters().asTypeList().asErasures())); } public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } } public enum ForInterceptedMethodParameters implements ArgumentProvider { INSTANCE; public final InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)MethodVariableAccess.allArgumentsOf(param3MethodDescription), (List<TypeDescription>)param3MethodDescription.getParameters().asTypeList().asErasures()); } public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } } public enum ConstantPoolWrapper { BOOLEAN((String)boolean.class, Boolean.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Boolean)param4Object).booleanValue())); } }, BYTE((String)byte.class, Byte.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Byte)param4Object).byteValue())); } }, SHORT((String)short.class, Short.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Short)param4Object).shortValue())); } }, CHARACTER((String)char.class, Character.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Character)param4Object).charValue())); } }, INTEGER((String)int.class, Integer.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, IntegerConstant.forValue(((Integer)param4Object).intValue())); } }, LONG((String)long.class, Long.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, LongConstant.forValue(((Long)param4Object).longValue())); } }, FLOAT((String)float.class, Float.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, FloatConstant.forValue(((Float)param4Object).floatValue())); } }, DOUBLE((String)double.class, Double.class) { protected final InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param4Object) { return new WrappingArgumentProvider(this, DoubleConstant.forValue(((Double)param4Object).doubleValue())); } }; private final TypeDescription primitiveType; private final TypeDescription wrapperType; ConstantPoolWrapper(Class<?> param3Class1, Class<?> param3Class2) { this.primitiveType = TypeDescription.ForLoadedType.of(param3Class1); this.wrapperType = TypeDescription.ForLoadedType.of(param3Class2); } public static InvokeDynamic.InvocationProvider.ArgumentProvider of(Object param3Object) { if (param3Object instanceof Boolean) return BOOLEAN.make(param3Object);  if (param3Object instanceof Byte) return BYTE.make(param3Object);  if (param3Object instanceof Short) return SHORT.make(param3Object);  if (param3Object instanceof Character) return CHARACTER.make(param3Object);  if (param3Object instanceof Integer) return INTEGER.make(param3Object);  if (param3Object instanceof Long) return LONG.make(param3Object);  if (param3Object instanceof Float) return FLOAT.make(param3Object);  if (param3Object instanceof Double) return DOUBLE.make(param3Object);  if (param3Object instanceof String) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForStringConstant((String)param3Object);  if (param3Object instanceof Class) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForClassConstant(TypeDescription.ForLoadedType.of((Class)param3Object));  if (param3Object instanceof TypeDescription) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForClassConstant((TypeDescription)param3Object);  if (param3Object instanceof Enum) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForEnumerationValue((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)param3Object));  if (param3Object instanceof EnumerationDescription) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForEnumerationValue((EnumerationDescription)param3Object);  if (JavaType.METHOD_HANDLE.isInstance(param3Object)) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)JavaConstant.MethodHandle.ofLoaded(param3Object));  if (JavaType.METHOD_TYPE.isInstance(param3Object)) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)JavaConstant.MethodType.ofLoaded(param3Object));  if (param3Object instanceof JavaConstant) return new InvokeDynamic.InvocationProvider.ArgumentProvider.ForJavaConstant((JavaConstant)param3Object);  return InvokeDynamic.InvocationProvider.ArgumentProvider.ForInstance.of(param3Object); } protected abstract InvokeDynamic.InvocationProvider.ArgumentProvider make(Object param3Object); @Enhance(includeSyntheticFields = true) protected class WrappingArgumentProvider implements InvokeDynamic.InvocationProvider.ArgumentProvider { private final StackManipulation stackManipulation; protected WrappingArgumentProvider(InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper this$0, StackManipulation param4StackManipulation) { this.stackManipulation = param4StackManipulation; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Assigner param4Assigner, Assigner.Typing param4Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.stackManipulation, param4Assigner.assign(InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.a(this.a).asGenericType(), InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.b(this.a).asGenericType(), param4Typing) }), InvokeDynamic.InvocationProvider.ArgumentProvider.ConstantPoolWrapper.b(this.a)); } public InstrumentedType prepare(InstrumentedType param4InstrumentedType) { return param4InstrumentedType; } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.a.equals(((WrappingArgumentProvider)param4Object).a) ? false : (!!this.stackManipulation.equals(((WrappingArgumentProvider)param4Object).stackManipulation))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.a.hashCode(); } } } public static interface Resolved { StackManipulation getLoadInstruction(); List<TypeDescription> getLoadedTypes(); @Enhance public static class Simple implements Resolved { private final StackManipulation stackManipulation; private final List<TypeDescription> loadedTypes; public Simple(StackManipulation param4StackManipulation, TypeDescription param4TypeDescription) { this(param4StackManipulation, Collections.singletonList(param4TypeDescription)); } public Simple(StackManipulation param4StackManipulation, List<TypeDescription> param4List) { this.stackManipulation = param4StackManipulation; this.loadedTypes = param4List; } public StackManipulation getLoadInstruction() { return this.stackManipulation; } public List<TypeDescription> getLoadedTypes() { return this.loadedTypes; } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.stackManipulation.equals(((Simple)param4Object).stackManipulation) ? false : (!!this.loadedTypes.equals(((Simple)param4Object).loadedTypes))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.loadedTypes.hashCode(); } } } @Enhance public static class ForThisInstance implements ArgumentProvider { private final TypeDescription typeDescription; protected ForThisInstance(TypeDescription param3TypeDescription) { this.typeDescription = param3TypeDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { if (param3MethodDescription.isStatic()) throw new IllegalStateException("Cannot get this instance from static method: " + param3MethodDescription);  if (!param3TypeDescription.isAssignableTo(this.typeDescription)) throw new IllegalStateException(param3TypeDescription + " is not assignable to " + param3TypeDescription);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(MethodVariableAccess.loadThis(), this.typeDescription); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForThisInstance)param3Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } @Enhance public static class ForInstance implements ArgumentProvider { private static final String FIELD_PREFIX = "invokeDynamic"; private final Object value; private final TypeDescription fieldType; @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE) private final String name; protected ForInstance(Object param3Object, TypeDescription param3TypeDescription) { this.value = param3Object; this.fieldType = param3TypeDescription; this.name = "invokeDynamic$" + RandomString.hashOf(param3Object); } protected static InvokeDynamic.InvocationProvider.ArgumentProvider of(Object param3Object) { return new ForInstance(param3Object, TypeDescription.ForLoadedType.of(param3Object.getClass())); } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { FieldDescription fieldDescription = (FieldDescription)((FieldList)param3TypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly(); StackManipulation stackManipulation; if (!(stackManipulation = param3Assigner.assign(fieldDescription.getType(), this.fieldType.asGenericType(), param3Typing)).isValid()) throw new IllegalStateException("Cannot assign " + fieldDescription + " to " + this.fieldType);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { FieldAccess.forField(fieldDescription).read(), stackManipulation }, ), fieldDescription.getType().asErasure()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4169, this.fieldType.asGenericType()), this.value); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.value.equals(((ForInstance)param3Object).value) ? false : (!!this.fieldType.equals(((ForInstance)param3Object).fieldType))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.value.hashCode()) * 31 + this.fieldType.hashCode(); } } @Enhance public static class ForField implements ArgumentProvider { protected final String fieldName; protected final FieldLocator.Factory fieldLocatorFactory; protected ForField(String param3String, FieldLocator.Factory param3Factory) { this.fieldName = param3String; this.fieldLocatorFactory = param3Factory; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { FieldLocator.Resolution resolution; if (!(resolution = this.fieldLocatorFactory.make(param3TypeDescription).locate(this.fieldName)).isResolved()) throw new IllegalStateException("Cannot find a field " + this.fieldName + " for " + param3TypeDescription);  if (!resolution.getField().isStatic() && param3MethodDescription.isStatic()) throw new IllegalStateException("Cannot access non-static " + resolution.getField() + " from " + param3MethodDescription);  return doResolve((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { resolution.getField().isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(resolution.getField()).read() }, ), resolution.getField().getType(), param3Assigner, param3Typing); } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param3StackManipulation, TypeDescription.Generic param3Generic, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(param3StackManipulation, param3Generic.asErasure()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fieldName.equals(((ForField)param3Object).fieldName) ? false : (!!this.fieldLocatorFactory.equals(((ForField)param3Object).fieldLocatorFactory))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fieldName.hashCode()) * 31 + this.fieldLocatorFactory.hashCode(); } @Enhance protected static class WithExplicitType extends ForField { private final TypeDescription typeDescription; protected WithExplicitType(String param4String, FieldLocator.Factory param4Factory, TypeDescription param4TypeDescription) { super(param4String, param4Factory); this.typeDescription = param4TypeDescription; } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param4StackManipulation, TypeDescription.Generic param4Generic, Assigner param4Assigner, Assigner.Typing param4Typing) { StackManipulation stackManipulation; if (!(stackManipulation = param4Assigner.assign(param4Generic, this.typeDescription.asGenericType(), param4Typing)).isValid()) throw new IllegalStateException("Cannot assign " + param4Generic + " to " + this.typeDescription);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param4StackManipulation, stackManipulation }, ), this.typeDescription); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((WithExplicitType)param4Object).typeDescription))))); } public int hashCode() { return super.hashCode() * 31 + this.typeDescription.hashCode(); } } } @Enhance public static class ForMethodParameter implements ArgumentProvider { protected final int index; protected ForMethodParameter(int param3Int) { this.index = param3Int; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { ParameterList parameterList = param3MethodDescription.getParameters(); if (this.index >= parameterList.size()) throw new IllegalStateException("No parameter " + this.index + " for " + param3MethodDescription);  return doResolve(MethodVariableAccess.load((ParameterDescription)parameterList.get(this.index)), ((ParameterDescription)parameterList.get(this.index)).getType(), param3Assigner, param3Typing); } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param3StackManipulation, TypeDescription.Generic param3Generic, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(param3StackManipulation, param3Generic.asErasure()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((ForMethodParameter)param3Object).index)))); } public int hashCode() { return getClass().hashCode() * 31 + this.index; } @Enhance protected static class WithExplicitType extends ForMethodParameter { private final TypeDescription typeDescription; protected WithExplicitType(int param4Int, TypeDescription param4TypeDescription) { super(param4Int); this.typeDescription = param4TypeDescription; } protected InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved doResolve(StackManipulation param4StackManipulation, TypeDescription.Generic param4Generic, Assigner param4Assigner, Assigner.Typing param4Typing) { StackManipulation stackManipulation; if (!(stackManipulation = param4Assigner.assign(param4Generic, this.typeDescription.asGenericType(), param4Typing)).isValid()) throw new IllegalStateException("Cannot assign " + param4Generic + " to " + this.typeDescription);  return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param4StackManipulation, stackManipulation }, ), this.typeDescription); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((WithExplicitType)param4Object).typeDescription))))); } public int hashCode() { return super.hashCode() * 31 + this.typeDescription.hashCode(); } } } @Enhance public static class ForBooleanConstant implements ArgumentProvider { private final boolean value; protected ForBooleanConstant(boolean param3Boolean) { this.value = param3Boolean; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(boolean.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForBooleanConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForByteConstant implements ArgumentProvider { private final byte value; protected ForByteConstant(byte param3Byte) { this.value = param3Byte; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(byte.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForByteConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForShortConstant implements ArgumentProvider { private final short value; protected ForShortConstant(short param3Short) { this.value = param3Short; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(short.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForShortConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForCharacterConstant implements ArgumentProvider { private final char value; protected ForCharacterConstant(char param3Char) { this.value = param3Char; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(char.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForCharacterConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForIntegerConstant implements ArgumentProvider { private final int value; protected ForIntegerConstant(int param3Int) { this.value = param3Int; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(int.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForIntegerConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value; } } @Enhance public static class ForLongConstant implements ArgumentProvider { private final long value; protected ForLongConstant(long param3Long) { this.value = param3Long; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(LongConstant.forValue(this.value), TypeDescription.ForLoadedType.of(long.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((ForLongConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + (int)(this.value ^ this.value >>> 32L); } } @Enhance public static class ForFloatConstant implements ArgumentProvider { private final float value; protected ForFloatConstant(float param3Float) { this.value = param3Float; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(FloatConstant.forValue(this.value), TypeDescription.ForLoadedType.of(float.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(Float.compare(this.value, ((ForFloatConstant)param3Object).value) != 0)))); } public int hashCode() { return getClass().hashCode() * 31 + Float.floatToIntBits(this.value); } } @Enhance public static class ForDoubleConstant implements ArgumentProvider { private final double value; protected ForDoubleConstant(double param3Double) { this.value = param3Double; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(DoubleConstant.forValue(this.value), TypeDescription.ForLoadedType.of(double.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(Double.compare(this.value, ((ForDoubleConstant)param3Object).value) != 0)))); } public int hashCode() { return getClass().hashCode() * 31 + (int)(Double.doubleToLongBits(this.value) ^ Double.doubleToLongBits(this.value) >>> 32L); } } @Enhance public static class ForStringConstant implements ArgumentProvider { private final String value; protected ForStringConstant(String param3String) { this.value = param3String; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new TextConstant(this.value), TypeDescription.ForLoadedType.of(String.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.value.equals(((ForStringConstant)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value.hashCode(); } } @Enhance public static class ForClassConstant implements ArgumentProvider { private final TypeDescription typeDescription; protected ForClassConstant(TypeDescription param3TypeDescription) { this.typeDescription = param3TypeDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(ClassConstant.of(this.typeDescription), TypeDescription.ForLoadedType.of(Class.class)); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForClassConstant)param3Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } @Enhance public static class ForEnumerationValue implements ArgumentProvider { private final EnumerationDescription enumerationDescription; protected ForEnumerationValue(EnumerationDescription param3EnumerationDescription) { this.enumerationDescription = param3EnumerationDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple(FieldAccess.forEnumeration(this.enumerationDescription), this.enumerationDescription.getEnumerationType()); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.enumerationDescription.equals(((ForEnumerationValue)param3Object).enumerationDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.enumerationDescription.hashCode(); } } @Enhance public static class ForNullValue implements ArgumentProvider { private final TypeDescription typeDescription; protected ForNullValue(TypeDescription param3TypeDescription) { this.typeDescription = param3TypeDescription; } public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)NullConstant.INSTANCE, this.typeDescription); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForNullValue)param3Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } @Enhance public static class ForJavaConstant implements ArgumentProvider { public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; }
/*      */ 
/*      */         
/*      */         private final JavaConstant javaConstant;
/*      */         
/*      */         protected ForJavaConstant(JavaConstant param3JavaConstant) {
/*      */           this.javaConstant = param3JavaConstant;
/*      */         }
/*      */         
/*      */         public InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) {
/*      */           return new InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved.Simple((StackManipulation)new JavaConstantValue(this.javaConstant), this.javaConstant.getTypeDescription());
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.javaConstant.equals(((ForJavaConstant)param3Object).javaConstant))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.javaConstant.hashCode();
/*      */         } } }
/*      */ 
/*      */     
/*      */     public static interface NameProvider {
/*      */       String resolve(MethodDescription param2MethodDescription);
/*      */       
/*      */       public enum ForInterceptedMethod implements NameProvider {
/* 2189 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final String resolve(MethodDescription param3MethodDescription) {
/* 2195 */           return param3MethodDescription.getInternalName();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForExplicitName
/*      */         implements NameProvider
/*      */       {
/*      */         private final String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForExplicitName(String param3String) {
/* 2216 */           this.internalName = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String resolve(MethodDescription param3MethodDescription) {
/* 2223 */           return this.internalName;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.internalName.equals(((ForExplicitName)param3Object).internalName))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.internalName.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public static interface ReturnTypeProvider
/*      */     {
/*      */       TypeDescription resolve(MethodDescription param2MethodDescription);
/*      */ 
/*      */       
/*      */       public enum ForInterceptedMethod
/*      */         implements ReturnTypeProvider
/*      */       {
/* 2249 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final TypeDescription resolve(MethodDescription param3MethodDescription) {
/* 2255 */           return param3MethodDescription.getReturnType().asErasure();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForExplicitType
/*      */         implements ReturnTypeProvider
/*      */       {
/*      */         private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForExplicitType(TypeDescription param3TypeDescription) {
/* 2276 */           this.typeDescription = param3TypeDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription resolve(MethodDescription param3MethodDescription) {
/* 2283 */           return this.typeDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForExplicitType)param3Object).typeDescription))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Default
/*      */       implements InvocationProvider
/*      */     {
/*      */       private final InvokeDynamic.InvocationProvider.NameProvider nameProvider;
/*      */ 
/*      */       
/*      */       private final InvokeDynamic.InvocationProvider.ReturnTypeProvider returnTypeProvider;
/*      */       
/*      */       private final List<InvokeDynamic.InvocationProvider.ArgumentProvider> argumentProviders;
/*      */ 
/*      */       
/*      */       protected Default() {
/* 2315 */         this(InvokeDynamic.InvocationProvider.NameProvider.ForInterceptedMethod.INSTANCE, InvokeDynamic.InvocationProvider.ReturnTypeProvider.ForInterceptedMethod.INSTANCE, 
/*      */             
/* 2317 */             Collections.singletonList(InvokeDynamic.InvocationProvider.ArgumentProvider.ForInterceptedMethodInstanceAndParameters.INSTANCE));
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
/*      */       protected Default(InvokeDynamic.InvocationProvider.NameProvider param2NameProvider, InvokeDynamic.InvocationProvider.ReturnTypeProvider param2ReturnTypeProvider, List<InvokeDynamic.InvocationProvider.ArgumentProvider> param2List) {
/* 2330 */         this.nameProvider = param2NameProvider;
/* 2331 */         this.returnTypeProvider = param2ReturnTypeProvider;
/* 2332 */         this.argumentProviders = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Target make(MethodDescription param2MethodDescription) {
/* 2339 */         return new Target(this.nameProvider.resolve(param2MethodDescription), this.returnTypeProvider
/* 2340 */             .resolve(param2MethodDescription), this.argumentProviders, param2MethodDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InvokeDynamic.InvocationProvider appendArguments(List<InvokeDynamic.InvocationProvider.ArgumentProvider> param2List) {
/* 2349 */         return new Default(this.nameProvider, this.returnTypeProvider, 
/*      */             
/* 2351 */             CompoundList.of(this.argumentProviders, param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InvokeDynamic.InvocationProvider appendArgument(InvokeDynamic.InvocationProvider.ArgumentProvider param2ArgumentProvider) {
/* 2358 */         return new Default(this.nameProvider, this.returnTypeProvider, 
/*      */             
/* 2360 */             CompoundList.of(this.argumentProviders, param2ArgumentProvider));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InvokeDynamic.InvocationProvider withoutArguments() {
/* 2367 */         return new Default(this.nameProvider, this.returnTypeProvider, 
/*      */             
/* 2369 */             Collections.emptyList());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InvokeDynamic.InvocationProvider withNameProvider(InvokeDynamic.InvocationProvider.NameProvider param2NameProvider) {
/* 2376 */         return new Default(param2NameProvider, this.returnTypeProvider, this.argumentProviders);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InvokeDynamic.InvocationProvider withReturnTypeProvider(InvokeDynamic.InvocationProvider.ReturnTypeProvider param2ReturnTypeProvider) {
/* 2385 */         return new Default(this.nameProvider, param2ReturnTypeProvider, this.argumentProviders);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 2394 */         for (Iterator<InvokeDynamic.InvocationProvider.ArgumentProvider> iterator = this.argumentProviders.iterator(); iterator.hasNext();) {
/* 2395 */           param2InstrumentedType = (argumentProvider = iterator.next()).prepare(param2InstrumentedType);
/*      */         }
/* 2397 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.nameProvider.equals(((Default)param2Object).nameProvider) ? false : (!this.returnTypeProvider.equals(((Default)param2Object).returnTypeProvider) ? false : (!!this.argumentProviders.equals(((Default)param2Object).argumentProviders))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.nameProvider.hashCode()) * 31 + this.returnTypeProvider.hashCode()) * 31 + this.argumentProviders.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Target
/*      */         implements InvokeDynamic.InvocationProvider.Target
/*      */       {
/*      */         private final String internalName;
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription returnType;
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<InvokeDynamic.InvocationProvider.ArgumentProvider> argumentProviders;
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodDescription instrumentedMethod;
/*      */ 
/*      */ 
/*      */         
/*      */         protected Target(String param3String, TypeDescription param3TypeDescription, List<InvokeDynamic.InvocationProvider.ArgumentProvider> param3List, MethodDescription param3MethodDescription) {
/* 2438 */           this.internalName = param3String;
/* 2439 */           this.returnType = param3TypeDescription;
/* 2440 */           this.argumentProviders = param3List;
/* 2441 */           this.instrumentedMethod = param3MethodDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public InvokeDynamic.InvocationProvider.Target.Resolved resolve(TypeDescription param3TypeDescription, Assigner param3Assigner, Assigner.Typing param3Typing)
/*      */         {
/* 2448 */           StackManipulation[] arrayOfStackManipulation = new StackManipulation[this.argumentProviders.size()];
/* 2449 */           ArrayList<TypeDescription> arrayList = new ArrayList();
/* 2450 */           byte b = 0;
/* 2451 */           for (Iterator<InvokeDynamic.InvocationProvider.ArgumentProvider> iterator = this.argumentProviders.iterator(); iterator.hasNext(); ) {
/* 2452 */             InvokeDynamic.InvocationProvider.ArgumentProvider argumentProvider; InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolved = (argumentProvider = iterator.next()).resolve(param3TypeDescription, this.instrumentedMethod, param3Assigner, param3Typing);
/* 2453 */             arrayList.addAll(resolved.getLoadedTypes());
/* 2454 */             arrayOfStackManipulation[b++] = resolved.getLoadInstruction();
/*      */           } 
/* 2456 */           return new InvokeDynamic.InvocationProvider.Target.Resolved.Simple((StackManipulation)new StackManipulation.Compound(arrayOfStackManipulation), this.internalName, this.returnType, arrayList); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.internalName.equals(((Target)param3Object).internalName) ? false : (!this.returnType.equals(((Target)param3Object).returnType) ? false : (!this.argumentProviders.equals(((Target)param3Object).argumentProviders) ? false : (!!this.instrumentedMethod.equals(((Target)param3Object).instrumentedMethod))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.internalName.hashCode()) * 31 + this.returnType.hashCode()) * 31 + this.argumentProviders.hashCode()) * 31 + this.instrumentedMethod.hashCode(); } } } } @Enhance public static class Default implements InvocationProvider { private final InvokeDynamic.InvocationProvider.NameProvider nameProvider; private final InvokeDynamic.InvocationProvider.ReturnTypeProvider returnTypeProvider; private final List<InvokeDynamic.InvocationProvider.ArgumentProvider> argumentProviders; protected Default() { this(InvokeDynamic.InvocationProvider.NameProvider.ForInterceptedMethod.INSTANCE, InvokeDynamic.InvocationProvider.ReturnTypeProvider.ForInterceptedMethod.INSTANCE, Collections.singletonList(InvokeDynamic.InvocationProvider.ArgumentProvider.ForInterceptedMethodInstanceAndParameters.INSTANCE)); } protected Default(InvokeDynamic.InvocationProvider.NameProvider param1NameProvider, InvokeDynamic.InvocationProvider.ReturnTypeProvider param1ReturnTypeProvider, List<InvokeDynamic.InvocationProvider.ArgumentProvider> param1List) { this.nameProvider = param1NameProvider; this.returnTypeProvider = param1ReturnTypeProvider; this.argumentProviders = param1List; } public Target make(MethodDescription param1MethodDescription) { return new Target(this.nameProvider.resolve(param1MethodDescription), this.returnTypeProvider.resolve(param1MethodDescription), this.argumentProviders, param1MethodDescription); } public InvokeDynamic.InvocationProvider appendArguments(List<InvokeDynamic.InvocationProvider.ArgumentProvider> param1List) { return new Default(this.nameProvider, this.returnTypeProvider, CompoundList.of(this.argumentProviders, param1List)); } public InvokeDynamic.InvocationProvider appendArgument(InvokeDynamic.InvocationProvider.ArgumentProvider param1ArgumentProvider) { return new Default(this.nameProvider, this.returnTypeProvider, CompoundList.of(this.argumentProviders, param1ArgumentProvider)); } public InvokeDynamic.InvocationProvider withoutArguments() { return new Default(this.nameProvider, this.returnTypeProvider, Collections.emptyList()); } public InvokeDynamic.InvocationProvider withNameProvider(InvokeDynamic.InvocationProvider.NameProvider param1NameProvider) { return new Default(param1NameProvider, this.returnTypeProvider, this.argumentProviders); } public InvokeDynamic.InvocationProvider withReturnTypeProvider(InvokeDynamic.InvocationProvider.ReturnTypeProvider param1ReturnTypeProvider) { return new Default(this.nameProvider, param1ReturnTypeProvider, this.argumentProviders); } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { for (Iterator<InvokeDynamic.InvocationProvider.ArgumentProvider> iterator = this.argumentProviders.iterator(); iterator.hasNext();) param1InstrumentedType = (argumentProvider = iterator.next()).prepare(param1InstrumentedType);  return param1InstrumentedType; } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.nameProvider.equals(((Default)param1Object).nameProvider) ? false : (!this.returnTypeProvider.equals(((Default)param1Object).returnTypeProvider) ? false : (!!this.argumentProviders.equals(((Default)param1Object).argumentProviders)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.nameProvider.hashCode()) * 31 + this.returnTypeProvider.hashCode()) * 31 + this.argumentProviders.hashCode(); } @Enhance protected static class Target implements InvokeDynamic.InvocationProvider.Target { private final String internalName; private final TypeDescription returnType; private final List<InvokeDynamic.InvocationProvider.ArgumentProvider> argumentProviders; private final MethodDescription instrumentedMethod; protected Target(String param3String, TypeDescription param3TypeDescription, List<InvokeDynamic.InvocationProvider.ArgumentProvider> param3List, MethodDescription param3MethodDescription) { this.internalName = param3String; this.returnType = param3TypeDescription; this.argumentProviders = param3List; this.instrumentedMethod = param3MethodDescription; } public InvokeDynamic.InvocationProvider.Target.Resolved resolve(TypeDescription param3TypeDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { StackManipulation[] arrayOfStackManipulation = new StackManipulation[this.argumentProviders.size()]; ArrayList<TypeDescription> arrayList = new ArrayList(); byte b = 0; for (Iterator<InvokeDynamic.InvocationProvider.ArgumentProvider> iterator = this.argumentProviders.iterator(); iterator.hasNext(); ) { InvokeDynamic.InvocationProvider.ArgumentProvider argumentProvider; InvokeDynamic.InvocationProvider.ArgumentProvider.Resolved resolved = (argumentProvider = iterator.next()).resolve(param3TypeDescription, this.instrumentedMethod, param3Assigner, param3Typing); arrayList.addAll(resolved.getLoadedTypes()); arrayOfStackManipulation[b++] = resolved.getLoadInstruction(); }  return new InvokeDynamic.InvocationProvider.Target.Resolved.Simple((StackManipulation)new StackManipulation.Compound(arrayOfStackManipulation), this.internalName, this.returnType, arrayList); }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.internalName.equals(((Target)param3Object).internalName) ? false : (!this.returnType.equals(((Target)param3Object).returnType) ? false : (!this.argumentProviders.equals(((Target)param3Object).argumentProviders) ? false : (!!this.instrumentedMethod.equals(((Target)param3Object).instrumentedMethod)))))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (((getClass().hashCode() * 31 + this.internalName.hashCode()) * 31 + this.returnType.hashCode()) * 31 + this.argumentProviders.hashCode()) * 31 + this.instrumentedMethod.hashCode();
/*      */       } }
/*      */      }
/*      */ 
/*      */ 
/*      */   
/*      */   protected enum TerminationHandler
/*      */   {
/* 2474 */     RETURNING
/*      */     {
/*      */       protected final StackManipulation resolve(MethodDescription param2MethodDescription, TypeDescription param2TypeDescription, Assigner param2Assigner, Assigner.Typing param2Typing) {
/*      */         StackManipulation stackManipulation;
/* 2478 */         if (!(stackManipulation = param2Assigner.assign(param2TypeDescription.asGenericType(), param2MethodDescription.getReturnType(), param2Typing)).isValid()) {
/* 2479 */           throw new IllegalStateException("Cannot return " + param2TypeDescription + " from " + param2MethodDescription);
/*      */         }
/* 2481 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { stackManipulation, MethodReturn.of((TypeDefinition)param2MethodDescription.getReturnType())
/*      */ 
/*      */ 
/*      */             
/*      */             });
/*      */       }
/*      */     },
/* 2488 */     DROPPING
/*      */     {
/*      */       protected final StackManipulation resolve(MethodDescription param2MethodDescription, TypeDescription param2TypeDescription, Assigner param2Assigner, Assigner.Typing param2Typing) {
/* 2491 */         return Removal.of((TypeDefinition)param2TypeDescription);
/*      */       }
/*      */     };
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
/*      */     protected abstract StackManipulation resolve(MethodDescription param1MethodDescription, TypeDescription param1TypeDescription, Assigner param1Assigner, Assigner.Typing param1Typing);
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
/*      */   protected static abstract class AbstractDelegator
/*      */     extends InvokeDynamic
/*      */   {
/*      */     protected AbstractDelegator(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List, InvokeDynamic.InvocationProvider param1InvocationProvider, InvokeDynamic.TerminationHandler param1TerminationHandler, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2531 */       super(param1InDefinedShape, param1List, param1InvocationProvider, param1TerminationHandler, param1Assigner, param1Typing);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected abstract InvokeDynamic materialize();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withBooleanValue(boolean... param1VarArgs) {
/* 2545 */       return materialize().withBooleanValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withByteValue(byte... param1VarArgs) {
/* 2552 */       return materialize().withByteValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withShortValue(short... param1VarArgs) {
/* 2559 */       return materialize().withShortValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withCharacterValue(char... param1VarArgs) {
/* 2566 */       return materialize().withCharacterValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withIntegerValue(int... param1VarArgs) {
/* 2573 */       return materialize().withIntegerValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withLongValue(long... param1VarArgs) {
/* 2580 */       return materialize().withLongValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withFloatValue(float... param1VarArgs) {
/* 2587 */       return materialize().withFloatValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withDoubleValue(double... param1VarArgs) {
/* 2594 */       return materialize().withDoubleValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withValue(Object... param1VarArgs) {
/* 2601 */       return materialize().withValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.WithImplicitType withReference(Object param1Object) {
/* 2608 */       return materialize().withReference(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withReference(Object... param1VarArgs) {
/* 2615 */       return materialize().withReference(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withType(TypeDescription... param1VarArgs) {
/* 2622 */       return materialize().withType(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withInstance(JavaConstant... param1VarArgs) {
/* 2629 */       return materialize().withInstance(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withNullValue(Class<?>... param1VarArgs) {
/* 2636 */       return materialize().withNullValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withNullValue(TypeDescription... param1VarArgs) {
/* 2643 */       return materialize().withNullValue(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withArgument(int... param1VarArgs) {
/* 2650 */       return materialize().withArgument(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.WithImplicitType withArgument(int param1Int) {
/* 2657 */       return materialize().withArgument(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withThis(Class<?>... param1VarArgs) {
/* 2664 */       return materialize().withThis(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withThis(TypeDescription... param1VarArgs) {
/* 2671 */       return materialize().withThis(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withMethodArguments() {
/* 2678 */       return materialize().withMethodArguments();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withImplicitAndMethodArguments() {
/* 2685 */       return materialize().withImplicitAndMethodArguments();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withField(String... param1VarArgs) {
/* 2692 */       return materialize().withField(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withEnumeration(EnumerationDescription... param1VarArgs) {
/* 2699 */       return materialize().withEnumeration(param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic withField(FieldLocator.Factory param1Factory, String... param1VarArgs) {
/* 2706 */       return materialize().withField(param1Factory, param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.WithImplicitType withField(String param1String) {
/* 2713 */       return materialize().withField(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.WithImplicitType withField(String param1String, FieldLocator.Factory param1Factory) {
/* 2720 */       return materialize().withField(param1String, param1Factory);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2727 */       return materialize().withAssigner(param1Assigner, param1Typing);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation andThen(Implementation param1Implementation) {
/* 2734 */       return materialize().andThen(param1Implementation);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 2741 */       return materialize().prepare(param1InstrumentedType);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 2748 */       return materialize().appender(param1Target);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class WithImplicitArguments
/*      */     extends AbstractDelegator
/*      */   {
/*      */     protected WithImplicitArguments(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List, InvokeDynamic.InvocationProvider param1InvocationProvider, InvokeDynamic.TerminationHandler param1TerminationHandler, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2774 */       super(param1InDefinedShape, param1List, param1InvocationProvider, param1TerminationHandler, param1Assigner, param1Typing);
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
/*      */     public InvokeDynamic withoutArguments() {
/* 2788 */       return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */           
/* 2790 */           .withoutArguments(), this.terminationHandler, this.assigner, this.typing);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected InvokeDynamic materialize() {
/* 2798 */       return withoutArguments();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WithImplicitArguments withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2805 */       return new WithImplicitArguments(this.bootstrap, this.arguments, this.invocationProvider, this.terminationHandler, param1Assigner, param1Typing);
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
/*      */   public static class WithImplicitTarget
/*      */     extends WithImplicitArguments
/*      */   {
/*      */     protected WithImplicitTarget(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List, InvokeDynamic.InvocationProvider param1InvocationProvider, InvokeDynamic.TerminationHandler param1TerminationHandler, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2837 */       super(param1InDefinedShape, param1List, param1InvocationProvider, param1TerminationHandler, param1Assigner, param1Typing);
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
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.WithImplicitArguments invoke(Class<?> param1Class) {
/* 2854 */       return invoke(TypeDescription.ForLoadedType.of(param1Class));
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
/*      */     public InvokeDynamic.WithImplicitArguments invoke(TypeDescription param1TypeDescription) {
/* 2866 */       return new InvokeDynamic.WithImplicitArguments(this.bootstrap, this.arguments, this.invocationProvider
/*      */           
/* 2868 */           .withReturnTypeProvider(new InvokeDynamic.InvocationProvider.ReturnTypeProvider.ForExplicitType(param1TypeDescription)), this.terminationHandler, this.assigner, this.typing);
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
/*      */     public InvokeDynamic.WithImplicitArguments invoke(String param1String) {
/* 2881 */       return new InvokeDynamic.WithImplicitArguments(this.bootstrap, this.arguments, this.invocationProvider
/*      */           
/* 2883 */           .withNameProvider(new InvokeDynamic.InvocationProvider.NameProvider.ForExplicitName(param1String)), this.terminationHandler, this.assigner, this.typing);
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
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic.WithImplicitArguments invoke(String param1String, Class<?> param1Class) {
/* 2900 */       return invoke(param1String, TypeDescription.ForLoadedType.of(param1Class));
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
/*      */     public InvokeDynamic.WithImplicitArguments invoke(String param1String, TypeDescription param1TypeDescription) {
/* 2914 */       return new InvokeDynamic.WithImplicitArguments(this.bootstrap, this.arguments, this.invocationProvider
/*      */ 
/*      */           
/* 2917 */           .withNameProvider(new InvokeDynamic.InvocationProvider.NameProvider.ForExplicitName(param1String))
/* 2918 */           .withReturnTypeProvider(new InvokeDynamic.InvocationProvider.ReturnTypeProvider.ForExplicitType(param1TypeDescription)), this.terminationHandler, this.assigner, this.typing);
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
/*      */   public static abstract class WithImplicitType
/*      */     extends AbstractDelegator
/*      */   {
/*      */     protected WithImplicitType(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List, InvokeDynamic.InvocationProvider param1InvocationProvider, InvokeDynamic.TerminationHandler param1TerminationHandler, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2946 */       super(param1InDefinedShape, param1List, param1InvocationProvider, param1TerminationHandler, param1Assigner, param1Typing);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InvokeDynamic as(Class<?> param1Class) {
/* 2956 */       return as(TypeDescription.ForLoadedType.of(param1Class));
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
/*      */     public abstract InvokeDynamic as(TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"EQ_DOESNT_OVERRIDE_EQUALS"}, justification = "Super type implementation covers use case")
/*      */     protected static class OfInstance
/*      */       extends WithImplicitType
/*      */     {
/*      */       private final Object value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final InvokeDynamic.InvocationProvider.ArgumentProvider argumentProvider;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfInstance(MethodDescription.InDefinedShape param2InDefinedShape, List<? extends JavaConstant> param2List, InvokeDynamic.InvocationProvider param2InvocationProvider, InvokeDynamic.TerminationHandler param2TerminationHandler, Assigner param2Assigner, Assigner.Typing param2Typing, Object param2Object) {
/* 3001 */         super(param2InDefinedShape, param2List, param2InvocationProvider, param2TerminationHandler, param2Assigner, param2Typing);
/* 3002 */         this.value = param2Object;
/* 3003 */         this.argumentProvider = InvokeDynamic.InvocationProvider.ArgumentProvider.ForInstance.of(param2Object);
/*      */       }
/*      */ 
/*      */       
/*      */       public InvokeDynamic as(TypeDescription param2TypeDescription) {
/* 3008 */         if (!param2TypeDescription.asBoxed().isInstance(this.value)) {
/* 3009 */           throw new IllegalArgumentException(this.value + " is not of type " + param2TypeDescription);
/*      */         }
/* 3011 */         return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */             
/* 3013 */             .appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForInstance(this.value, param2TypeDescription)), this.terminationHandler, this.assigner, this.typing);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected InvokeDynamic materialize() {
/* 3021 */         return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */             
/* 3023 */             .appendArgument(this.argumentProvider), this.terminationHandler, this.assigner, this.typing);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"EQ_DOESNT_OVERRIDE_EQUALS"}, justification = "Super type implementation covers use case")
/*      */     protected static class OfArgument
/*      */       extends WithImplicitType
/*      */     {
/*      */       private final int index;
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
/*      */       protected OfArgument(MethodDescription.InDefinedShape param2InDefinedShape, List<? extends JavaConstant> param2List, InvokeDynamic.InvocationProvider param2InvocationProvider, InvokeDynamic.TerminationHandler param2TerminationHandler, Assigner param2Assigner, Assigner.Typing param2Typing, int param2Int) {
/* 3059 */         super(param2InDefinedShape, param2List, param2InvocationProvider, param2TerminationHandler, param2Assigner, param2Typing);
/* 3060 */         this.index = param2Int;
/*      */       }
/*      */ 
/*      */       
/*      */       public InvokeDynamic as(TypeDescription param2TypeDescription) {
/* 3065 */         return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */             
/* 3067 */             .appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForMethodParameter.WithExplicitType(this.index, param2TypeDescription)), this.terminationHandler, this.assigner, this.typing);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected InvokeDynamic materialize() {
/* 3075 */         return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */             
/* 3077 */             .appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForMethodParameter(this.index)), this.terminationHandler, this.assigner, this.typing);
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"EQ_DOESNT_OVERRIDE_EQUALS"}, justification = "Super type implementation covers use case")
/*      */     protected static class OfField
/*      */       extends WithImplicitType
/*      */     {
/*      */       private final String fieldName;
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
/*      */       private final FieldLocator.Factory fieldLocatorFactory;
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
/*      */       protected OfField(MethodDescription.InDefinedShape param2InDefinedShape, List<? extends JavaConstant> param2List, InvokeDynamic.InvocationProvider param2InvocationProvider, InvokeDynamic.TerminationHandler param2TerminationHandler, Assigner param2Assigner, Assigner.Typing param2Typing, String param2String, FieldLocator.Factory param2Factory) {
/* 3120 */         super(param2InDefinedShape, param2List, param2InvocationProvider, param2TerminationHandler, param2Assigner, param2Typing);
/* 3121 */         this.fieldName = param2String;
/* 3122 */         this.fieldLocatorFactory = param2Factory;
/*      */       }
/*      */ 
/*      */       
/*      */       public InvokeDynamic as(TypeDescription param2TypeDescription) {
/* 3127 */         return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */             
/* 3129 */             .appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForField.WithExplicitType(this.fieldName, this.fieldLocatorFactory, param2TypeDescription)), this.terminationHandler, this.assigner, this.typing);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected InvokeDynamic materialize()
/*      */       {
/* 3137 */         return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider
/*      */             
/* 3139 */             .appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForField(this.fieldName, this.fieldLocatorFactory)), this.terminationHandler, this.assigner, this.typing); } } } @SuppressFBWarnings(value = {"EQ_DOESNT_OVERRIDE_EQUALS"}, justification = "Super type implementation covers use case") protected static class OfInstance extends WithImplicitType { private final Object value; private final InvokeDynamic.InvocationProvider.ArgumentProvider argumentProvider; protected OfInstance(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List, InvokeDynamic.InvocationProvider param1InvocationProvider, InvokeDynamic.TerminationHandler param1TerminationHandler, Assigner param1Assigner, Assigner.Typing param1Typing, Object param1Object) { super(param1InDefinedShape, param1List, param1InvocationProvider, param1TerminationHandler, param1Assigner, param1Typing); this.value = param1Object; this.argumentProvider = InvokeDynamic.InvocationProvider.ArgumentProvider.ForInstance.of(param1Object); } public InvokeDynamic as(TypeDescription param1TypeDescription) { if (!param1TypeDescription.asBoxed().isInstance(this.value)) throw new IllegalArgumentException(this.value + " is not of type " + param1TypeDescription);  return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider.appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForInstance(this.value, param1TypeDescription)), this.terminationHandler, this.assigner, this.typing); } protected InvokeDynamic materialize() { return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider.appendArgument(this.argumentProvider), this.terminationHandler, this.assigner, this.typing); } } @SuppressFBWarnings(value = {"EQ_DOESNT_OVERRIDE_EQUALS"}, justification = "Super type implementation covers use case") protected static class OfArgument extends WithImplicitType { private final int index; protected OfArgument(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List, InvokeDynamic.InvocationProvider param1InvocationProvider, InvokeDynamic.TerminationHandler param1TerminationHandler, Assigner param1Assigner, Assigner.Typing param1Typing, int param1Int) { super(param1InDefinedShape, param1List, param1InvocationProvider, param1TerminationHandler, param1Assigner, param1Typing); this.index = param1Int; } public InvokeDynamic as(TypeDescription param1TypeDescription) { return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider.appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForMethodParameter.WithExplicitType(this.index, param1TypeDescription)), this.terminationHandler, this.assigner, this.typing); } protected InvokeDynamic materialize() { return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider.appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForMethodParameter(this.index)), this.terminationHandler, this.assigner, this.typing); } } @SuppressFBWarnings(value = {"EQ_DOESNT_OVERRIDE_EQUALS"}, justification = "Super type implementation covers use case") protected static class OfField extends WithImplicitType { private final String fieldName; private final FieldLocator.Factory fieldLocatorFactory; protected OfField(MethodDescription.InDefinedShape param1InDefinedShape, List<? extends JavaConstant> param1List, InvokeDynamic.InvocationProvider param1InvocationProvider, InvokeDynamic.TerminationHandler param1TerminationHandler, Assigner param1Assigner, Assigner.Typing param1Typing, String param1String, FieldLocator.Factory param1Factory) { super(param1InDefinedShape, param1List, param1InvocationProvider, param1TerminationHandler, param1Assigner, param1Typing); this.fieldName = param1String; this.fieldLocatorFactory = param1Factory; } public InvokeDynamic as(TypeDescription param1TypeDescription) { return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider.appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForField.WithExplicitType(this.fieldName, this.fieldLocatorFactory, param1TypeDescription)), this.terminationHandler, this.assigner, this.typing); } protected InvokeDynamic materialize() { return new InvokeDynamic(this.bootstrap, this.arguments, this.invocationProvider.appendArgument(new InvokeDynamic.InvocationProvider.ArgumentProvider.ForField(this.fieldName, this.fieldLocatorFactory)), this.terminationHandler, this.assigner, this.typing); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance(includeSyntheticFields = true)
/*      */   protected class Appender
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Appender(InvokeDynamic this$0, TypeDescription param1TypeDescription) {
/* 3164 */       this.instrumentedType = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 3171 */       InvokeDynamic.InvocationProvider.Target.Resolved resolved = this.a.invocationProvider.make(param1MethodDescription).resolve(this.instrumentedType, this.a.assigner, this.a.typing);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3179 */       StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { resolved.getStackManipulation(), MethodInvocation.invoke(this.a.bootstrap).dynamic(resolved.getInternalName(), resolved.getReturnType(), resolved.getParameterTypes(), this.a.arguments), this.a.terminationHandler.resolve(param1MethodDescription, resolved.getReturnType(), this.a.assigner, this.a.typing) })).apply(param1MethodVisitor, param1Context);
/* 3180 */       return new ByteCodeAppender.Size(size.getMaximalSize(), param1MethodDescription.getStackSize());
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.instrumentedType.equals(((Appender)param1Object).instrumentedType) ? false : (!!this.a.equals(((Appender)param1Object).a)))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.a.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\InvokeDynamic.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */