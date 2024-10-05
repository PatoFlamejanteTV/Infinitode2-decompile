/*      */ package net.bytebuddy.implementation;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.Callable;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.method.ParameterList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.scaffold.FieldLocator;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.Duplication;
/*      */ import net.bytebuddy.implementation.bytecode.Removal;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
/*      */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
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
/*      */ public class MethodCall
/*      */   implements Implementation.Composable
/*      */ {
/*      */   protected final MethodLocator.Factory methodLocator;
/*      */   protected final TargetHandler.Factory targetHandler;
/*      */   protected final List<ArgumentLoader.Factory> argumentLoaders;
/*      */   protected final MethodInvoker.Factory methodInvoker;
/*      */   protected final TerminationHandler.Factory terminationHandler;
/*      */   protected final Assigner assigner;
/*      */   protected final Assigner.Typing typing;
/*      */   
/*      */   protected MethodCall(MethodLocator.Factory paramFactory, TargetHandler.Factory paramFactory1, List<ArgumentLoader.Factory> paramList, MethodInvoker.Factory paramFactory2, TerminationHandler.Factory paramFactory3, Assigner paramAssigner, Assigner.Typing paramTyping) {
/*  119 */     this.methodLocator = paramFactory;
/*  120 */     this.targetHandler = paramFactory1;
/*  121 */     this.argumentLoaders = paramList;
/*  122 */     this.methodInvoker = paramFactory2;
/*  123 */     this.terminationHandler = paramFactory3;
/*  124 */     this.assigner = paramAssigner;
/*  125 */     this.typing = paramTyping;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WithoutSpecifiedTarget invoke(Method paramMethod) {
/*  136 */     return invoke((MethodDescription)new MethodDescription.ForLoadedMethod(paramMethod));
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
/*      */   public static WithoutSpecifiedTarget invoke(Constructor<?> paramConstructor) {
/*  152 */     return invoke((MethodDescription)new MethodDescription.ForLoadedConstructor(paramConstructor));
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
/*      */   public static WithoutSpecifiedTarget invoke(MethodDescription paramMethodDescription) {
/*  170 */     return invoke(new MethodLocator.ForExplicitMethod(paramMethodDescription));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WithoutSpecifiedTarget invoke(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/*  181 */     return invoke(paramElementMatcher, MethodGraph.Compiler.DEFAULT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WithoutSpecifiedTarget invoke(ElementMatcher<? super MethodDescription> paramElementMatcher, MethodGraph.Compiler paramCompiler) {
/*  192 */     return invoke(new MethodLocator.ForElementMatcher.Factory(paramElementMatcher, paramCompiler));
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
/*      */   public static WithoutSpecifiedTarget invoke(MethodLocator.Factory paramFactory) {
/*  205 */     return new WithoutSpecifiedTarget(paramFactory);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WithoutSpecifiedTarget invokeSelf() {
/*  215 */     return new WithoutSpecifiedTarget(MethodLocator.ForInstrumentedMethod.INSTANCE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MethodCall invokeSuper() {
/*  224 */     return invokeSelf().onSuper();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Implementation.Composable call(Callable<?> paramCallable) {
/*      */     try {
/*  236 */       return invoke(Callable.class.getMethod("call", new Class[0])).<Callable<?>>on(paramCallable, (Class)Callable.class).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC);
/*  237 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  238 */       throw new IllegalStateException("Could not locate Callable::call method", noSuchMethodException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Implementation.Composable run(Runnable paramRunnable) {
/*      */     try {
/*  250 */       return invoke(Runnable.class.getMethod("run", new Class[0])).<Runnable>on(paramRunnable, Runnable.class).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC);
/*  251 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  252 */       throw new IllegalStateException("Could not locate Runnable::run method", noSuchMethodException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MethodCall construct(Constructor<?> paramConstructor) {
/*  263 */     return construct((MethodDescription)new MethodDescription.ForLoadedConstructor(paramConstructor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MethodCall construct(MethodDescription paramMethodDescription) {
/*  273 */     if (!paramMethodDescription.isConstructor()) {
/*  274 */       throw new IllegalArgumentException("Not a constructor: " + paramMethodDescription);
/*      */     }
/*  276 */     return new MethodCall(new MethodLocator.ForExplicitMethod(paramMethodDescription), TargetHandler.ForConstructingInvocation.Factory.INSTANCE, 
/*      */         
/*  278 */         Collections.emptyList(), MethodInvoker.ForContextualInvocation.Factory.INSTANCE, TerminationHandler.Simple.RETURNING, Assigner.DEFAULT, Assigner.Typing.STATIC);
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
/*      */   public MethodCall with(Object... paramVarArgs) {
/*  296 */     ArrayList<ArgumentLoader.Factory> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  297 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Object object = paramVarArgs[b];
/*  298 */       arrayList.add(ArgumentLoader.ForStackManipulation.of(object)); b++; }
/*      */     
/*  300 */     return with(arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall with(TypeDescription... paramVarArgs) {
/*  311 */     ArrayList<ArgumentLoader.ForStackManipulation> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  312 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { TypeDescription typeDescription = paramVarArgs[b];
/*  313 */       arrayList.add(new ArgumentLoader.ForStackManipulation(ClassConstant.of(typeDescription), Class.class)); b++; }
/*      */     
/*  315 */     return with((List)arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall with(EnumerationDescription... paramVarArgs) {
/*  326 */     ArrayList<ArgumentLoader.ForStackManipulation> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  327 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { EnumerationDescription enumerationDescription = paramVarArgs[b];
/*  328 */       arrayList.add(new ArgumentLoader.ForStackManipulation(FieldAccess.forEnumeration(enumerationDescription), (TypeDefinition)enumerationDescription.getEnumerationType())); b++; }
/*      */     
/*  330 */     return with((List)arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall with(JavaConstant... paramVarArgs) {
/*  341 */     ArrayList<ArgumentLoader.ForStackManipulation> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  342 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { JavaConstant javaConstant = paramVarArgs[b];
/*  343 */       arrayList.add(new ArgumentLoader.ForStackManipulation((StackManipulation)new JavaConstantValue(javaConstant), (TypeDefinition)javaConstant.getTypeDescription())); b++; }
/*      */     
/*  345 */     return with((List)arrayList);
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
/*      */   public MethodCall withReference(Object... paramVarArgs) {
/*  357 */     ArrayList<? extends ArgumentLoader.Factory> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  358 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Object object = paramVarArgs[b];
/*  359 */       arrayList.add((object == null) ? ArgumentLoader.ForNullConstant.INSTANCE : new ArgumentLoader.ForInstance.Factory(object));
/*      */       
/*      */       b++; }
/*      */     
/*  363 */     return with(arrayList);
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
/*      */   public MethodCall withArgument(int... paramVarArgs) {
/*  375 */     ArrayList<ArgumentLoader.ForMethodParameter.Factory> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  376 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  377 */       int j; if ((j = paramVarArgs[b]) < 0) {
/*  378 */         throw new IllegalArgumentException("Negative index: " + j);
/*      */       }
/*  380 */       arrayList.add(new ArgumentLoader.ForMethodParameter.Factory(j));
/*      */     } 
/*  382 */     return with((List)arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall withAllArguments() {
/*  391 */     return with(new ArgumentLoader.Factory[] { ArgumentLoader.ForMethodParameter.OfInstrumentedMethod.INSTANCE });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall withArgumentArray() {
/*  400 */     return with(new ArgumentLoader.Factory[] { ArgumentLoader.ForMethodParameterArray.ForInstrumentedMethod.INSTANCE });
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
/*      */   public MethodCall withArgumentArrayElements(int paramInt) {
/*  417 */     if (paramInt < 0) {
/*  418 */       throw new IllegalArgumentException("A parameter index cannot be negative: " + paramInt);
/*      */     }
/*  420 */     return with(new ArgumentLoader.Factory[] { new ArgumentLoader.ForMethodParameterArrayElement.OfInvokedMethod(paramInt) });
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
/*      */   public MethodCall withArgumentArrayElements(int paramInt1, int paramInt2) {
/*  438 */     return withArgumentArrayElements(paramInt1, 0, paramInt2);
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
/*      */   public MethodCall withArgumentArrayElements(int paramInt1, int paramInt2, int paramInt3) {
/*  457 */     if (paramInt1 < 0)
/*  458 */       throw new IllegalArgumentException("A parameter index cannot be negative: " + paramInt1); 
/*  459 */     if (paramInt2 < 0)
/*  460 */       throw new IllegalArgumentException("An array index cannot be negative: " + paramInt2); 
/*  461 */     if (paramInt3 == 0)
/*  462 */       return this; 
/*  463 */     if (paramInt3 < 0) {
/*  464 */       throw new IllegalArgumentException("Size cannot be negative: " + paramInt3);
/*      */     }
/*  466 */     ArrayList<ArgumentLoader.ForMethodParameterArrayElement.OfParameter> arrayList = new ArrayList(paramInt3);
/*  467 */     for (byte b = 0; b < paramInt3; b++) {
/*  468 */       arrayList.add(new ArgumentLoader.ForMethodParameterArrayElement.OfParameter(paramInt1, paramInt2 + b));
/*      */     }
/*  470 */     return with((List)arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall withThis() {
/*  480 */     return with(new ArgumentLoader.Factory[] { ArgumentLoader.ForThisReference.Factory.INSTANCE });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall withOwnType() {
/*  490 */     return with(new ArgumentLoader.Factory[] { ArgumentLoader.ForInstrumentedType.Factory.INSTANCE });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall withField(String... paramVarArgs) {
/*  500 */     return withField((FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall withField(FieldLocator.Factory paramFactory, String... paramVarArgs) {
/*  511 */     ArrayList<ArgumentLoader.ForField.Factory> arrayList = new ArrayList(paramVarArgs.length); int i; byte b;
/*  512 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/*  513 */       arrayList.add(new ArgumentLoader.ForField.Factory(str, paramFactory)); b++; }
/*      */     
/*  515 */     return with((List)arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall withMethodCall(MethodCall paramMethodCall) {
/*  525 */     return with(new ArgumentLoader.Factory[] { new ArgumentLoader.ForMethodCall.Factory(paramMethodCall) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall with(StackManipulation paramStackManipulation, Type paramType) {
/*  536 */     return with(paramStackManipulation, (TypeDefinition)TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall with(StackManipulation paramStackManipulation, TypeDefinition paramTypeDefinition) {
/*  547 */     return with(new ArgumentLoader.Factory[] { new ArgumentLoader.ForStackManipulation(paramStackManipulation, paramTypeDefinition) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall with(ArgumentLoader.Factory... paramVarArgs) {
/*  557 */     return with(Arrays.asList(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodCall with(List<? extends ArgumentLoader.Factory> paramList) {
/*  567 */     return new MethodCall(this.methodLocator, this.targetHandler, 
/*      */         
/*  569 */         CompoundList.of(this.argumentLoaders, paramList), this.methodInvoker, this.terminationHandler, this.assigner, this.typing);
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
/*      */   public FieldSetting setsField(Field paramField) {
/*  584 */     return setsField((FieldDescription)new FieldDescription.ForLoadedField(paramField));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldSetting setsField(FieldDescription paramFieldDescription) {
/*  595 */     return new FieldSetting(new MethodCall(this.methodLocator, this.targetHandler, this.argumentLoaders, this.methodInvoker, new TerminationHandler.FieldSetting.Explicit(paramFieldDescription), this.assigner, this.typing));
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
/*      */   public FieldSetting setsField(ElementMatcher<? super FieldDescription> paramElementMatcher) {
/*  612 */     return new FieldSetting(new MethodCall(this.methodLocator, this.targetHandler, this.argumentLoaders, this.methodInvoker, new TerminationHandler.FieldSetting.Implicit(paramElementMatcher), this.assigner, this.typing));
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
/*      */   public Implementation.Composable withAssigner(Assigner paramAssigner, Assigner.Typing paramTyping) {
/*  633 */     return new MethodCall(this.methodLocator, this.targetHandler, this.argumentLoaders, this.methodInvoker, this.terminationHandler, paramAssigner, paramTyping);
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
/*      */   public Implementation andThen(Implementation paramImplementation) {
/*  646 */     return new Implementation.Compound(new Implementation[] { new MethodCall(this.methodLocator, this.targetHandler, this.argumentLoaders, this.methodInvoker, TerminationHandler.Simple.DROPPING, this.assigner, this.typing), paramImplementation });
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
/*  659 */     return new Implementation.Compound.Composable(new MethodCall(this.methodLocator, this.targetHandler, this.argumentLoaders, this.methodInvoker, TerminationHandler.Simple.DROPPING, this.assigner, this.typing), paramComposable);
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
/*  672 */     for (Iterator<ArgumentLoader.Factory> iterator = this.argumentLoaders.iterator(); iterator.hasNext();) {
/*  673 */       paramInstrumentedType = (prepareable = iterator.next()).prepare(paramInstrumentedType);
/*      */     }
/*  675 */     return this.targetHandler.prepare(paramInstrumentedType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/*  682 */     return new Appender(this, paramTarget, this.terminationHandler.make(paramTarget.getInstrumentedType()));
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
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.typing.equals(((MethodCall)paramObject).typing) ? false : (!this.methodLocator.equals(((MethodCall)paramObject).methodLocator) ? false : (!this.targetHandler.equals(((MethodCall)paramObject).targetHandler) ? false : (!this.argumentLoaders.equals(((MethodCall)paramObject).argumentLoaders) ? false : (!this.methodInvoker.equals(((MethodCall)paramObject).methodInvoker) ? false : (!this.terminationHandler.equals(((MethodCall)paramObject).terminationHandler) ? false : (!!this.assigner.equals(((MethodCall)paramObject).assigner))))))))));
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
/*      */   public int hashCode() {
/*      */     return ((((((getClass().hashCode() * 31 + this.methodLocator.hashCode()) * 31 + this.targetHandler.hashCode()) * 31 + this.argumentLoaders.hashCode()) * 31 + this.methodInvoker.hashCode()) * 31 + this.terminationHandler.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.typing.hashCode();
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
/*      */   public enum ForInstrumentedMethod
/*      */     implements MethodLocator, MethodLocator.Factory
/*      */   {
/*  722 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodCall.MethodLocator make(TypeDescription param1TypeDescription) {
/*  728 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodDescription resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription) {
/*  735 */       return param1MethodDescription;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForExplicitMethod
/*      */     implements MethodLocator, MethodLocator.Factory
/*      */   {
/*      */     private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForExplicitMethod(MethodDescription param1MethodDescription) {
/*  756 */       this.methodDescription = param1MethodDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodCall.MethodLocator make(TypeDescription param1TypeDescription) {
/*  763 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription)
/*      */     {
/*  770 */       return this.methodDescription; } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.methodDescription.equals(((ForExplicitMethod)param1Object).methodDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.methodDescription.hashCode(); } } public static interface MethodLocator { MethodDescription resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription); public static interface Factory { MethodCall.MethodLocator make(TypeDescription param2TypeDescription); } public enum ForInstrumentedMethod implements MethodLocator, Factory { INSTANCE; public final MethodCall.MethodLocator make(TypeDescription param2TypeDescription) { return this; } public final MethodDescription resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) { return param2MethodDescription; } } @Enhance public static class ForExplicitMethod implements MethodLocator, Factory { private final MethodDescription methodDescription; protected ForExplicitMethod(MethodDescription param2MethodDescription) { this.methodDescription = param2MethodDescription; } public MethodCall.MethodLocator make(TypeDescription param2TypeDescription) { return this; } public MethodDescription resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) { return this.methodDescription; }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.methodDescription.equals(((ForExplicitMethod)param2Object).methodDescription))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.methodDescription.hashCode();
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForElementMatcher
/*      */       implements MethodLocator
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */       
/*      */       private final ElementMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */       
/*      */       private final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForElementMatcher(TypeDescription param2TypeDescription, ElementMatcher<? super MethodDescription> param2ElementMatcher, MethodGraph.Compiler param2Compiler) {
/*  803 */         this.instrumentedType = param2TypeDescription;
/*  804 */         this.matcher = param2ElementMatcher;
/*  805 */         this.methodGraphCompiler = param2Compiler;
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
/*      */       public MethodDescription resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) {
/*      */         List<?> list;
/*      */         TypeDescription.Generic generic;
/*  819 */         if ((list = CompoundList.of(((generic = this.instrumentedType.getSuperClass()) == null) ? Collections.emptyList() : (List)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and(this.matcher)), (List)this.instrumentedType.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isVirtual()).and(this.matcher)), (List)this.methodGraphCompiler.compile((TypeDefinition)param2TypeDescription, this.instrumentedType).listNodes().asMethodList().filter(this.matcher))).size() == 1) {
/*  820 */           return (MethodDescription)list.get(0);
/*      */         }
/*  822 */         throw new IllegalStateException(this.instrumentedType + " does not define exactly one virtual method or constructor for " + this.matcher + " but contained " + list
/*  823 */             .size() + " candidates: " + list);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedType.equals(((ForElementMatcher)param2Object).instrumentedType) ? false : (!this.matcher.equals(((ForElementMatcher)param2Object).matcher) ? false : (!!this.methodGraphCompiler.equals(((ForElementMatcher)param2Object).methodGraphCompiler))))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.matcher.hashCode()) * 31 + this.methodGraphCompiler.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Factory
/*      */         implements MethodCall.MethodLocator.Factory
/*      */       {
/*      */         private final ElementMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */         
/*      */         private final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */         
/*      */         public Factory(ElementMatcher<? super MethodDescription> param3ElementMatcher, MethodGraph.Compiler param3Compiler) {
/*  851 */           this.matcher = param3ElementMatcher;
/*  852 */           this.methodGraphCompiler = param3Compiler;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodCall.MethodLocator make(TypeDescription param3TypeDescription)
/*      */         {
/*  859 */           return new MethodCall.MethodLocator.ForElementMatcher(param3TypeDescription, this.matcher, this.methodGraphCompiler); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.matcher.equals(((Factory)param3Object).matcher) ? false : (!!this.methodGraphCompiler.equals(((Factory)param3Object).methodGraphCompiler))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.methodGraphCompiler.hashCode(); } } } } @Enhance public static class ForElementMatcher implements MethodLocator { private final TypeDescription instrumentedType; private final ElementMatcher<? super MethodDescription> matcher; private final MethodGraph.Compiler methodGraphCompiler; protected ForElementMatcher(TypeDescription param1TypeDescription, ElementMatcher<? super MethodDescription> param1ElementMatcher, MethodGraph.Compiler param1Compiler) { this.instrumentedType = param1TypeDescription; this.matcher = param1ElementMatcher; this.methodGraphCompiler = param1Compiler; } public MethodDescription resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription) { List<?> list; TypeDescription.Generic generic; if ((list = CompoundList.of(((generic = this.instrumentedType.getSuperClass()) == null) ? Collections.emptyList() : (List)generic.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and(this.matcher)), (List)this.instrumentedType.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isVirtual()).and(this.matcher)), (List)this.methodGraphCompiler.compile((TypeDefinition)param1TypeDescription, this.instrumentedType).listNodes().asMethodList().filter(this.matcher))).size() == 1) return (MethodDescription)list.get(0);  throw new IllegalStateException(this.instrumentedType + " does not define exactly one virtual method or constructor for " + this.matcher + " but contained " + list.size() + " candidates: " + list); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.instrumentedType.equals(((ForElementMatcher)param1Object).instrumentedType) ? false : (!this.matcher.equals(((ForElementMatcher)param1Object).matcher) ? false : (!!this.methodGraphCompiler.equals(((ForElementMatcher)param1Object).methodGraphCompiler)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.matcher.hashCode()) * 31 + this.methodGraphCompiler.hashCode(); } @Enhance public static class Factory implements MethodCall.MethodLocator.Factory { private final ElementMatcher<? super MethodDescription> matcher; private final MethodGraph.Compiler methodGraphCompiler; public Factory(ElementMatcher<? super MethodDescription> param3ElementMatcher, MethodGraph.Compiler param3Compiler) { this.matcher = param3ElementMatcher; this.methodGraphCompiler = param3Compiler; } public MethodCall.MethodLocator make(TypeDescription param3TypeDescription) { return new MethodCall.MethodLocator.ForElementMatcher(param3TypeDescription, this.matcher, this.methodGraphCompiler); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.matcher.equals(((Factory)param3Object).matcher) ? false : (!!this.methodGraphCompiler.equals(((Factory)param3Object).methodGraphCompiler))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.methodGraphCompiler.hashCode(); } } } @Enhance public static class Factory implements MethodLocator.Factory { private final ElementMatcher<? super MethodDescription> matcher; private final MethodGraph.Compiler methodGraphCompiler; public Factory(ElementMatcher<? super MethodDescription> param1ElementMatcher, MethodGraph.Compiler param1Compiler) { this.matcher = param1ElementMatcher; this.methodGraphCompiler = param1Compiler; } public MethodCall.MethodLocator make(TypeDescription param1TypeDescription) { return new MethodCall.MethodLocator.ForElementMatcher(param1TypeDescription, this.matcher, this.methodGraphCompiler); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.matcher.equals(((Factory)param1Object).matcher) ? false : (!!this.methodGraphCompiler.equals(((Factory)param1Object).methodGraphCompiler)))));
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
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.methodGraphCompiler.hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum ForNullConstant
/*      */     implements ArgumentLoader, ArgumentLoader.ArgumentProvider, ArgumentLoader.Factory
/*      */   {
/*  918 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/*  924 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) {
/*  931 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) {
/*  938 */       return Collections.singletonList(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*  945 */       if (param1ParameterDescription.getType().isPrimitive()) {
/*  946 */         throw new IllegalStateException("Cannot assign null to " + param1ParameterDescription);
/*      */       }
/*  948 */       return (StackManipulation)NullConstant.INSTANCE;
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
/*      */   public static class ForThisReference
/*      */     implements ArgumentLoader, ArgumentLoader.ArgumentProvider
/*      */   {
/*      */     private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForThisReference(TypeDescription param1TypeDescription) {
/*  970 */       this.instrumentedType = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) {
/*  977 */       if (param1MethodDescription1.isStatic()) {
/*  978 */         throw new IllegalStateException(param1MethodDescription1 + " is static and cannot supply an invoker instance");
/*      */       }
/*  980 */       return Collections.singletonList(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*      */       StackManipulation.Compound compound;
/*  990 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), param1Assigner.assign(this.instrumentedType.asGenericType(), param1ParameterDescription.getType(), param1Typing) })).isValid()) {
/*  991 */         throw new IllegalStateException("Cannot assign " + this.instrumentedType + " to " + param1ParameterDescription);
/*      */       }
/*  993 */       return (StackManipulation)compound;
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForThisReference)param1Object).instrumentedType))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */     }
/*      */     
/* 1004 */     public enum Factory implements MethodCall.ArgumentLoader.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1010 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target)
/*      */       {
/* 1017 */         return new MethodCall.ArgumentLoader.ForThisReference(param3Target.getInstrumentedType()); } } } public enum Factory implements ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return new MethodCall.ArgumentLoader.ForThisReference(param1Target.getInstrumentedType()); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForInstrumentedType
/*      */     implements ArgumentLoader, ArgumentLoader.ArgumentProvider
/*      */   {
/*      */     private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForInstrumentedType(TypeDescription param1TypeDescription) {
/* 1039 */       this.instrumentedType = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) {
/* 1046 */       return Collections.singletonList(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*      */       StackManipulation.Compound compound;
/* 1056 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { ClassConstant.of(this.instrumentedType), param1Assigner.assign(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class), param1ParameterDescription.getType(), param1Typing) })).isValid()) {
/* 1057 */         throw new IllegalStateException("Cannot assign Class value to " + param1ParameterDescription);
/*      */       }
/* 1059 */       return (StackManipulation)compound;
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForInstrumentedType)param1Object).instrumentedType))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */     }
/*      */     
/* 1070 */     public enum Factory implements MethodCall.ArgumentLoader.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1076 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target)
/*      */       {
/* 1083 */         return new MethodCall.ArgumentLoader.ForInstrumentedType(param3Target.getInstrumentedType()); } } } public enum Factory implements ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return new MethodCall.ArgumentLoader.ForInstrumentedType(param1Target.getInstrumentedType()); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForMethodParameter
/*      */     implements ArgumentLoader
/*      */   {
/*      */     private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDescription instrumentedMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForMethodParameter(int param1Int, MethodDescription param1MethodDescription) {
/* 1111 */       this.index = param1Int;
/* 1112 */       this.instrumentedMethod = param1MethodDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1119 */       ParameterDescription parameterDescription = (ParameterDescription)this.instrumentedMethod.getParameters().get(this.index);
/*      */       
/*      */       StackManipulation.Compound compound;
/*      */       
/* 1123 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(parameterDescription), param1Assigner.assign(parameterDescription.getType(), param1ParameterDescription.getType(), param1Typing) })).isValid()) {
/* 1124 */         throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + param1ParameterDescription + " for " + this.instrumentedMethod);
/*      */       }
/* 1126 */       return (StackManipulation)compound;
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.index != ((ForMethodParameter)param1Object).index) ? false : (!!this.instrumentedMethod.equals(((ForMethodParameter)param1Object).instrumentedMethod)))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.index) * 31 + this.instrumentedMethod.hashCode();
/*      */     }
/*      */     
/* 1137 */     protected enum OfInstrumentedMethod implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1143 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) {
/* 1150 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) {
/* 1157 */         ArrayList<MethodCall.ArgumentLoader.ForMethodParameter> arrayList = new ArrayList(param3MethodDescription1.getParameters().size());
/* 1158 */         for (ParameterDescription parameterDescription : param3MethodDescription1.getParameters()) {
/* 1159 */           arrayList.add(new MethodCall.ArgumentLoader.ForMethodParameter(parameterDescription.getIndex(), param3MethodDescription1));
/*      */         }
/* 1161 */         return (List)arrayList;
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Factory
/*      */       implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory
/*      */     {
/*      */       private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Factory(int param3Int) {
/* 1182 */         this.index = param3Int;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1189 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) {
/* 1196 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2)
/*      */       {
/* 1203 */         if (this.index >= param3MethodDescription1.getParameters().size()) {
/* 1204 */           throw new IllegalStateException(param3MethodDescription1 + " does not have a parameter with index " + this.index + ", " + param3MethodDescription1
/* 1205 */               .getParameters().size() + " defined");
/*      */         }
/* 1207 */         return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameter(this.index, param3MethodDescription1)); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((Factory)param3Object).index)))); } public int hashCode() { return getClass().hashCode() * 31 + this.index; } } } protected enum OfInstrumentedMethod implements ArgumentLoader.ArgumentProvider, ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return this; } public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) { ArrayList<MethodCall.ArgumentLoader.ForMethodParameter> arrayList = new ArrayList(param1MethodDescription1.getParameters().size()); for (ParameterDescription parameterDescription : param1MethodDescription1.getParameters()) arrayList.add(new MethodCall.ArgumentLoader.ForMethodParameter(parameterDescription.getIndex(), param1MethodDescription1));  return (List)arrayList; } } @Enhance public static class Factory implements ArgumentLoader.ArgumentProvider, ArgumentLoader.Factory { private final int index; public Factory(int param1Int) { this.index = param1Int; } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return this; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) { if (this.index >= param1MethodDescription1.getParameters().size()) throw new IllegalStateException(param1MethodDescription1 + " does not have a parameter with index " + this.index + ", " + param1MethodDescription1.getParameters().size() + " defined");  return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameter(this.index, param1MethodDescription1)); }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.index != ((Factory)param1Object).index))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.index;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForMethodParameterArray
/*      */     implements ArgumentLoader
/*      */   {
/*      */     private final ParameterList<?> parameters;
/*      */     
/*      */     public ForMethodParameterArray(ParameterList<?> param1ParameterList) {
/* 1229 */       this.parameters = param1ParameterList;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*      */       TypeDescription.Generic generic;
/* 1238 */       if (param1ParameterDescription.getType().represents(Object.class)) {
/* 1239 */         generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
/* 1240 */       } else if (generic.getType().isArray()) {
/* 1241 */         generic = generic.getType().getComponentType();
/*      */       } else {
/* 1243 */         throw new IllegalStateException("Cannot set method parameter array for non-array type: " + generic);
/*      */       } 
/* 1245 */       ArrayList<StackManipulation.Compound> arrayList = new ArrayList(this.parameters.size());
/* 1246 */       for (ParameterDescription parameterDescription : this.parameters) {
/*      */         StackManipulation.Compound compound;
/*      */ 
/*      */ 
/*      */         
/* 1251 */         if ((compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(parameterDescription), param1Assigner.assign(parameterDescription.getType(), generic, param1Typing) })).isValid()) {
/* 1252 */           arrayList.add(compound); continue;
/*      */         } 
/* 1254 */         throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + generic);
/*      */       } 
/*      */       
/* 1257 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { ArrayFactory.forType(generic).withValues(arrayList) });
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.parameters.equals(((ForMethodParameterArray)param1Object).parameters))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.parameters.hashCode();
/*      */     }
/*      */     
/* 1268 */     public enum ForInstrumentedMethod implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1274 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) {
/* 1281 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2)
/*      */       {
/* 1288 */         return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameterArray(param3MethodDescription1.getParameters())); } } } public enum ForInstrumentedMethod implements ArgumentLoader.ArgumentProvider, ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return this; } public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) { return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameterArray(param1MethodDescription1.getParameters())); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForMethodParameterArrayElement
/*      */     implements ArgumentLoader
/*      */   {
/*      */     private final ParameterDescription parameterDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForMethodParameterArrayElement(ParameterDescription param1ParameterDescription, int param1Int) {
/* 1316 */       this.parameterDescription = param1ParameterDescription;
/* 1317 */       this.index = param1Int;
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
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*      */       StackManipulation.Compound compound;
/* 1331 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(this.parameterDescription), IntegerConstant.forValue(this.index), ArrayAccess.of((TypeDefinition)this.parameterDescription.getType().getComponentType()).load(), param1Assigner.assign(this.parameterDescription.getType().getComponentType(), param1ParameterDescription.getType(), param1Typing) })).isValid()) {
/* 1332 */         throw new IllegalStateException("Cannot assign " + this.parameterDescription.getType().getComponentType() + " to " + param1ParameterDescription);
/*      */       }
/* 1334 */       return (StackManipulation)compound;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.index != ((ForMethodParameterArrayElement)param1Object).index) ? false : (!!this.parameterDescription.equals(((ForMethodParameterArrayElement)param1Object).parameterDescription)))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.parameterDescription.hashCode()) * 31 + this.index;
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class OfParameter
/*      */       implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory
/*      */     {
/*      */       private final int index;
/*      */       
/*      */       private final int arrayIndex;
/*      */ 
/*      */       
/*      */       public OfParameter(int param3Int1, int param3Int2) {
/* 1360 */         this.index = param3Int1;
/* 1361 */         this.arrayIndex = param3Int2;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1368 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) {
/* 1375 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) {
/* 1382 */         if (param3MethodDescription1.getParameters().size() <= this.index)
/* 1383 */           throw new IllegalStateException(param3MethodDescription1 + " does not declare a parameter with index " + this.index + ", " + param3MethodDescription1
/* 1384 */               .getParameters().size() + " defined"); 
/* 1385 */         if (!((ParameterDescription)param3MethodDescription1.getParameters().get(this.index)).getType().isArray()) {
/* 1386 */           throw new IllegalStateException("Cannot access an item from non-array parameter " + param3MethodDescription1.getParameters().get(this.index) + " at index " + this.index);
/*      */         }
/*      */         
/* 1389 */         return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameterArrayElement((ParameterDescription)param3MethodDescription1.getParameters().get(this.index), this.arrayIndex));
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((OfParameter)param3Object).index) ? false : (!(this.arrayIndex != ((OfParameter)param3Object).arrayIndex)))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.index) * 31 + this.arrayIndex;
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class OfInvokedMethod
/*      */       implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory
/*      */     {
/*      */       private final int index;
/*      */       
/*      */       public OfInvokedMethod(int param3Int) {
/* 1410 */         this.index = param3Int;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1417 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) {
/* 1424 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2)
/*      */       {
/* 1431 */         if (param3MethodDescription1.getParameters().size() <= this.index)
/* 1432 */           throw new IllegalStateException(param3MethodDescription1 + " does not declare a parameter with index " + this.index + ", " + param3MethodDescription1
/* 1433 */               .getParameters().size() + " defined"); 
/* 1434 */         if (!((ParameterDescription)param3MethodDescription1.getParameters().get(this.index)).getType().isArray()) {
/* 1435 */           throw new IllegalStateException("Cannot access an item from non-array parameter " + param3MethodDescription1.getParameters().get(this.index) + " at index " + this.index);
/*      */         }
/*      */         
/* 1438 */         ArrayList<MethodCall.ArgumentLoader.ForMethodParameterArrayElement> arrayList = new ArrayList(param3MethodDescription2.getParameters().size());
/* 1439 */         for (byte b = 0; b < param3MethodDescription2.getParameters().size(); b++) {
/* 1440 */           arrayList.add(new MethodCall.ArgumentLoader.ForMethodParameterArrayElement((ParameterDescription)param3MethodDescription1.getParameters().get(this.index), b));
/*      */         }
/* 1442 */         return (List)arrayList; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((OfInvokedMethod)param3Object).index)))); } public int hashCode() { return getClass().hashCode() * 31 + this.index; } } } @Enhance public static class OfParameter implements ArgumentLoader.ArgumentProvider, ArgumentLoader.Factory { private final int index; private final int arrayIndex; public OfParameter(int param1Int1, int param1Int2) { this.index = param1Int1; this.arrayIndex = param1Int2; } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return this; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) { if (param1MethodDescription1.getParameters().size() <= this.index) throw new IllegalStateException(param1MethodDescription1 + " does not declare a parameter with index " + this.index + ", " + param1MethodDescription1.getParameters().size() + " defined");  if (!((ParameterDescription)param1MethodDescription1.getParameters().get(this.index)).getType().isArray()) throw new IllegalStateException("Cannot access an item from non-array parameter " + param1MethodDescription1.getParameters().get(this.index) + " at index " + this.index);  return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameterArrayElement((ParameterDescription)param1MethodDescription1.getParameters().get(this.index), this.arrayIndex)); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.index != ((OfParameter)param1Object).index) ? false : (!(this.arrayIndex != ((OfParameter)param1Object).arrayIndex))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.index) * 31 + this.arrayIndex; } } @Enhance public static class OfInvokedMethod implements ArgumentLoader.ArgumentProvider, ArgumentLoader.Factory { private final int index; public OfInvokedMethod(int param1Int) { this.index = param1Int; } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return this; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) { if (param1MethodDescription1.getParameters().size() <= this.index) throw new IllegalStateException(param1MethodDescription1 + " does not declare a parameter with index " + this.index + ", " + param1MethodDescription1.getParameters().size() + " defined");  if (!((ParameterDescription)param1MethodDescription1.getParameters().get(this.index)).getType().isArray()) throw new IllegalStateException("Cannot access an item from non-array parameter " + param1MethodDescription1.getParameters().get(this.index) + " at index " + this.index);  ArrayList<MethodCall.ArgumentLoader.ForMethodParameterArrayElement> arrayList = new ArrayList(param1MethodDescription2.getParameters().size()); for (byte b = 0; b < param1MethodDescription2.getParameters().size(); b++) arrayList.add(new MethodCall.ArgumentLoader.ForMethodParameterArrayElement((ParameterDescription)param1MethodDescription1.getParameters().get(this.index), b));  return (List)arrayList; }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.index != ((OfInvokedMethod)param1Object).index))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.index;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForInstance
/*      */     implements ArgumentLoader, ArgumentLoader.ArgumentProvider
/*      */   {
/*      */     private final FieldDescription fieldDescription;
/*      */     
/*      */     public ForInstance(FieldDescription param1FieldDescription) {
/* 1464 */       this.fieldDescription = param1FieldDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) {
/* 1471 */       return Collections.singletonList(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*      */       StackManipulation.Compound compound;
/* 1481 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { FieldAccess.forField(this.fieldDescription).read(), param1Assigner.assign(this.fieldDescription.getType(), param1ParameterDescription.getType(), param1Typing) })).isValid()) {
/* 1482 */         throw new IllegalStateException("Cannot assign " + this.fieldDescription.getType() + " to " + param1ParameterDescription);
/*      */       }
/* 1484 */       return (StackManipulation)compound;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.fieldDescription.equals(((ForInstance)param1Object).fieldDescription))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class Factory
/*      */       implements MethodCall.ArgumentLoader.Factory
/*      */     {
/*      */       private static final String FIELD_PREFIX = "methodCall";
/*      */ 
/*      */       
/*      */       private final Object value;
/*      */       
/*      */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*      */       private final String name;
/*      */ 
/*      */       
/*      */       public Factory(Object param3Object) {
/* 1515 */         this.value = param3Object;
/* 1516 */         this.name = "methodCall$" + RandomString.hashOf(param3Object);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1523 */         return param3InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4105, 
/*      */               
/* 1525 */               TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.value.getClass())), this.value);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target)
/*      */       {
/* 1532 */         return new MethodCall.ArgumentLoader.ForInstance((FieldDescription)((FieldList)param3Target.getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly()); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.value.equals(((Factory)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value.hashCode(); } } } @Enhance protected static class Factory implements ArgumentLoader.Factory { private static final String FIELD_PREFIX = "methodCall"; private final Object value; @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE) private final String name; public Factory(Object param1Object) { this.value = param1Object; this.name = "methodCall$" + RandomString.hashOf(param1Object); } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4105, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.value.getClass())), this.value); } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return new MethodCall.ArgumentLoader.ForInstance((FieldDescription)((FieldList)param1Target.getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly()); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.value.equals(((Factory)param1Object).value))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.value.hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForField
/*      */     implements ArgumentLoader
/*      */   {
/*      */     private final FieldDescription fieldDescription;
/*      */     
/*      */     private final MethodDescription instrumentedMethod;
/*      */ 
/*      */     
/*      */     public ForField(FieldDescription param1FieldDescription, MethodDescription param1MethodDescription) {
/* 1560 */       this.fieldDescription = param1FieldDescription;
/* 1561 */       this.instrumentedMethod = param1MethodDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 1568 */       if (!this.fieldDescription.isStatic() && this.instrumentedMethod.isStatic()) {
/* 1569 */         throw new IllegalStateException("Cannot access non-static " + this.fieldDescription + " from " + this.instrumentedMethod);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       StackManipulation.Compound compound;
/*      */ 
/*      */ 
/*      */       
/* 1578 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read(), param1Assigner.assign(this.fieldDescription.getType(), param1ParameterDescription.getType(), param1Typing) })).isValid()) {
/* 1579 */         throw new IllegalStateException("Cannot assign " + this.fieldDescription + " to " + param1ParameterDescription);
/*      */       }
/* 1581 */       return (StackManipulation)compound;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.fieldDescription.equals(((ForField)param1Object).fieldDescription) ? false : (!!this.instrumentedMethod.equals(((ForField)param1Object).instrumentedMethod)))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.instrumentedMethod.hashCode();
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     protected static class ArgumentProvider
/*      */       implements MethodCall.ArgumentLoader.ArgumentProvider
/*      */     {
/*      */       private final FieldDescription fieldDescription;
/*      */       
/*      */       protected ArgumentProvider(FieldDescription param3FieldDescription) {
/* 1601 */         this.fieldDescription = param3FieldDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) {
/* 1608 */         return Collections.singletonList(new MethodCall.ArgumentLoader.ForField(this.fieldDescription, param3MethodDescription1));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((ArgumentProvider)param3Object).fieldDescription))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class Factory
/*      */       implements MethodCall.ArgumentLoader.Factory
/*      */     {
/*      */       private final String name;
/*      */       
/*      */       private final FieldLocator.Factory fieldLocatorFactory;
/*      */ 
/*      */       
/*      */       public Factory(String param3String, FieldLocator.Factory param3Factory) {
/* 1635 */         this.name = param3String;
/* 1636 */         this.fieldLocatorFactory = param3Factory;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1643 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target)
/*      */       {
/*      */         FieldLocator.Resolution resolution;
/* 1651 */         if (!(resolution = this.fieldLocatorFactory.make(param3Target.getInstrumentedType()).locate(this.name)).isResolved()) {
/* 1652 */           throw new IllegalStateException("Could not locate field '" + this.name + "' on " + param3Target.getInstrumentedType());
/*      */         }
/* 1654 */         return new MethodCall.ArgumentLoader.ForField.ArgumentProvider(resolution.getField()); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.name.equals(((Factory)param3Object).name) ? false : (!!this.fieldLocatorFactory.equals(((Factory)param3Object).fieldLocatorFactory))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.fieldLocatorFactory.hashCode(); } } } @Enhance protected static class Factory implements ArgumentLoader.Factory { private final String name; private final FieldLocator.Factory fieldLocatorFactory; public Factory(String param1String, FieldLocator.Factory param1Factory) { this.name = param1String; this.fieldLocatorFactory = param1Factory; } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { FieldLocator.Resolution resolution; if (!(resolution = this.fieldLocatorFactory.make(param1Target.getInstrumentedType()).locate(this.name)).isResolved()) throw new IllegalStateException("Could not locate field '" + this.name + "' on " + param1Target.getInstrumentedType());  return new MethodCall.ArgumentLoader.ForField.ArgumentProvider(resolution.getField()); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.name.equals(((Factory)param1Object).name) ? false : (!!this.fieldLocatorFactory.equals(((Factory)param1Object).fieldLocatorFactory)))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.fieldLocatorFactory.hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForMethodCall
/*      */     implements ArgumentLoader
/*      */   {
/*      */     private final MethodCall.Appender appender;
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDescription methodDescription;
/*      */ 
/*      */     
/*      */     private final MethodDescription instrumentedMethod;
/*      */ 
/*      */     
/*      */     private final MethodCall.TargetHandler.Resolved targetHandler;
/*      */ 
/*      */ 
/*      */     
/*      */     public ForMethodCall(MethodCall.Appender param1Appender, MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2, MethodCall.TargetHandler.Resolved param1Resolved) {
/* 1694 */       this.appender = param1Appender;
/* 1695 */       this.methodDescription = param1MethodDescription1;
/* 1696 */       this.instrumentedMethod = param1MethodDescription2;
/* 1697 */       this.targetHandler = param1Resolved;
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
/*      */     public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*      */       StackManipulation.Compound compound;
/* 1710 */       if (!(compound = new StackManipulation.Compound(new StackManipulation[] { this.appender.toStackManipulation(this.instrumentedMethod, this.methodDescription, this.targetHandler), param1Assigner.assign(this.methodDescription.isConstructor() ? this.methodDescription.getDeclaringType().asGenericType() : this.methodDescription.getReturnType(), param1ParameterDescription.getType(), param1Typing) })).isValid()) {
/* 1711 */         throw new IllegalStateException("Cannot assign return type of " + this.methodDescription + " to " + param1ParameterDescription);
/*      */       }
/* 1713 */       return (StackManipulation)compound;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.appender.equals(((ForMethodCall)param1Object).appender) ? false : (!this.methodDescription.equals(((ForMethodCall)param1Object).methodDescription) ? false : (!this.instrumentedMethod.equals(((ForMethodCall)param1Object).instrumentedMethod) ? false : (!!this.targetHandler.equals(((ForMethodCall)param1Object).targetHandler)))))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.appender.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.instrumentedMethod.hashCode()) * 31 + this.targetHandler.hashCode();
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     protected static class ArgumentProvider
/*      */       implements MethodCall.ArgumentLoader.ArgumentProvider
/*      */     {
/*      */       private final MethodCall.Appender appender;
/*      */       
/*      */       protected ArgumentProvider(MethodCall.Appender param3Appender) {
/* 1733 */         this.appender = param3Appender;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) {
/* 1740 */         MethodCall.TargetHandler.Resolved resolved = MethodCall.Appender.a(this.appender).resolve(param3MethodDescription1);
/* 1741 */         return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodCall(this.appender, this.appender
/* 1742 */               .toInvokedMethod(param3MethodDescription1, resolved), param3MethodDescription1, resolved));
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.appender.equals(((ArgumentProvider)param3Object).appender))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.appender.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class Factory
/*      */       implements MethodCall.ArgumentLoader.Factory
/*      */     {
/*      */       private final MethodCall methodCall;
/*      */ 
/*      */       
/*      */       public Factory(MethodCall param3MethodCall) {
/* 1765 */         this.methodCall = param3MethodCall;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1772 */         return this.methodCall.prepare(param3InstrumentedType);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target)
/*      */       {
/* 1779 */         this.methodCall.getClass(); return new MethodCall.ArgumentLoader.ForMethodCall.ArgumentProvider(new MethodCall.Appender(this.methodCall, param3Target, MethodCall.TerminationHandler.Simple.IGNORING)); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.methodCall.equals(((Factory)param3Object).methodCall)))); } public int hashCode() { return getClass().hashCode() * 31 + this.methodCall.hashCode(); } } } @Enhance protected static class Factory implements ArgumentLoader.Factory { private final MethodCall methodCall; public Factory(MethodCall param1MethodCall) { this.methodCall = param1MethodCall; } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return this.methodCall.prepare(param1InstrumentedType); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.methodCall.equals(((Factory)param1Object).methodCall)))); } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { this.methodCall.getClass(); return new MethodCall.ArgumentLoader.ForMethodCall.ArgumentProvider(new MethodCall.Appender(this.methodCall, param1Target, MethodCall.TerminationHandler.Simple.IGNORING)); } public int hashCode() { return getClass().hashCode() * 31 + this.methodCall.hashCode(); } } public static interface ArgumentLoader { StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing); public static interface ArgumentProvider { List<MethodCall.ArgumentLoader> resolve(MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2); } public static interface Factory extends InstrumentedType.Prepareable { MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param2Target); } public enum ForNullConstant implements ArgumentLoader, ArgumentProvider, Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param2InstrumentedType) { return param2InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param2Target) { return this; } public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2) { return Collections.singletonList(this); } public final StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { if (param2ParameterDescription.getType().isPrimitive()) throw new IllegalStateException("Cannot assign null to " + param2ParameterDescription);  return (StackManipulation)NullConstant.INSTANCE; } } @Enhance public static class ForThisReference implements ArgumentLoader, ArgumentProvider { private final TypeDescription instrumentedType; public ForThisReference(TypeDescription param2TypeDescription) { this.instrumentedType = param2TypeDescription; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2) { if (param2MethodDescription1.isStatic()) throw new IllegalStateException(param2MethodDescription1 + " is static and cannot supply an invoker instance");  return Collections.singletonList(this); } public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { StackManipulation.Compound compound; if (!(compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), param2Assigner.assign(this.instrumentedType.asGenericType(), param2ParameterDescription.getType(), param2Typing) })).isValid()) throw new IllegalStateException("Cannot assign " + this.instrumentedType + " to " + param2ParameterDescription);  return (StackManipulation)compound; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForThisReference)param2Object).instrumentedType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.instrumentedType.hashCode(); } public enum Factory implements MethodCall.ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return new MethodCall.ArgumentLoader.ForThisReference(param3Target.getInstrumentedType()); } } } @Enhance public static class ForInstrumentedType implements ArgumentLoader, ArgumentProvider { private final TypeDescription instrumentedType; public ForInstrumentedType(TypeDescription param2TypeDescription) { this.instrumentedType = param2TypeDescription; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2) { return Collections.singletonList(this); } public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { StackManipulation.Compound compound; if (!(compound = new StackManipulation.Compound(new StackManipulation[] { ClassConstant.of(this.instrumentedType), param2Assigner.assign(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class), param2ParameterDescription.getType(), param2Typing) })).isValid()) throw new IllegalStateException("Cannot assign Class value to " + param2ParameterDescription);  return (StackManipulation)compound; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForInstrumentedType)param2Object).instrumentedType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.instrumentedType.hashCode(); } public enum Factory implements MethodCall.ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return new MethodCall.ArgumentLoader.ForInstrumentedType(param3Target.getInstrumentedType()); } } } @Enhance public static class ForMethodParameter implements ArgumentLoader { private final int index; private final MethodDescription instrumentedMethod; public ForMethodParameter(int param2Int, MethodDescription param2MethodDescription) { this.index = param2Int; this.instrumentedMethod = param2MethodDescription; } public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { ParameterDescription parameterDescription = (ParameterDescription)this.instrumentedMethod.getParameters().get(this.index); StackManipulation.Compound compound; if (!(compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(parameterDescription), param2Assigner.assign(parameterDescription.getType(), param2ParameterDescription.getType(), param2Typing) })).isValid()) throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + param2ParameterDescription + " for " + this.instrumentedMethod);  return (StackManipulation)compound; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.index != ((ForMethodParameter)param2Object).index) ? false : (!!this.instrumentedMethod.equals(((ForMethodParameter)param2Object).instrumentedMethod))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.index) * 31 + this.instrumentedMethod.hashCode(); } protected enum OfInstrumentedMethod implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return this; } public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { ArrayList<MethodCall.ArgumentLoader.ForMethodParameter> arrayList = new ArrayList(param3MethodDescription1.getParameters().size()); for (ParameterDescription parameterDescription : param3MethodDescription1.getParameters()) arrayList.add(new MethodCall.ArgumentLoader.ForMethodParameter(parameterDescription.getIndex(), param3MethodDescription1));  return (List)arrayList; } } @Enhance public static class Factory implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory { private final int index; public Factory(int param3Int) { this.index = param3Int; } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return this; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { if (this.index >= param3MethodDescription1.getParameters().size()) throw new IllegalStateException(param3MethodDescription1 + " does not have a parameter with index " + this.index + ", " + param3MethodDescription1.getParameters().size() + " defined");  return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameter(this.index, param3MethodDescription1)); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((Factory)param3Object).index)))); } public int hashCode() { return getClass().hashCode() * 31 + this.index; } } } @Enhance public static class ForMethodParameterArray implements ArgumentLoader { private final ParameterList<?> parameters; public ForMethodParameterArray(ParameterList<?> param2ParameterList) { this.parameters = param2ParameterList; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.") public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { TypeDescription.Generic generic; if (param2ParameterDescription.getType().represents(Object.class)) { generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class); } else if (generic.getType().isArray()) { generic = generic.getType().getComponentType(); } else { throw new IllegalStateException("Cannot set method parameter array for non-array type: " + generic); }  ArrayList<StackManipulation.Compound> arrayList = new ArrayList(this.parameters.size()); for (ParameterDescription parameterDescription : this.parameters) { StackManipulation.Compound compound; if ((compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(parameterDescription), param2Assigner.assign(parameterDescription.getType(), generic, param2Typing) })).isValid()) { arrayList.add(compound); continue; }  throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + generic); }  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { ArrayFactory.forType(generic).withValues(arrayList) }); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.parameters.equals(((ForMethodParameterArray)param2Object).parameters)))); } public int hashCode() { return getClass().hashCode() * 31 + this.parameters.hashCode(); } public enum ForInstrumentedMethod implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public final MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return this; } public final List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameterArray(param3MethodDescription1.getParameters())); } } } @Enhance public static class ForMethodParameterArrayElement implements ArgumentLoader { private final ParameterDescription parameterDescription; private final int index; public ForMethodParameterArrayElement(ParameterDescription param2ParameterDescription, int param2Int) { this.parameterDescription = param2ParameterDescription; this.index = param2Int; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.") public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { StackManipulation.Compound compound; if (!(compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(this.parameterDescription), IntegerConstant.forValue(this.index), ArrayAccess.of((TypeDefinition)this.parameterDescription.getType().getComponentType()).load(), param2Assigner.assign(this.parameterDescription.getType().getComponentType(), param2ParameterDescription.getType(), param2Typing) })).isValid()) throw new IllegalStateException("Cannot assign " + this.parameterDescription.getType().getComponentType() + " to " + param2ParameterDescription);  return (StackManipulation)compound; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.index != ((ForMethodParameterArrayElement)param2Object).index) ? false : (!!this.parameterDescription.equals(((ForMethodParameterArrayElement)param2Object).parameterDescription))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.parameterDescription.hashCode()) * 31 + this.index; } @Enhance public static class OfParameter implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory { private final int index; private final int arrayIndex; public OfParameter(int param3Int1, int param3Int2) { this.index = param3Int1; this.arrayIndex = param3Int2; } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return this; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { if (param3MethodDescription1.getParameters().size() <= this.index) throw new IllegalStateException(param3MethodDescription1 + " does not declare a parameter with index " + this.index + ", " + param3MethodDescription1.getParameters().size() + " defined");  if (!((ParameterDescription)param3MethodDescription1.getParameters().get(this.index)).getType().isArray()) throw new IllegalStateException("Cannot access an item from non-array parameter " + param3MethodDescription1.getParameters().get(this.index) + " at index " + this.index);  return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodParameterArrayElement((ParameterDescription)param3MethodDescription1.getParameters().get(this.index), this.arrayIndex)); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((OfParameter)param3Object).index) ? false : (!(this.arrayIndex != ((OfParameter)param3Object).arrayIndex))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.index) * 31 + this.arrayIndex; } } @Enhance public static class OfInvokedMethod implements MethodCall.ArgumentLoader.ArgumentProvider, MethodCall.ArgumentLoader.Factory { private final int index; public OfInvokedMethod(int param3Int) { this.index = param3Int; } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return this; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { if (param3MethodDescription1.getParameters().size() <= this.index) throw new IllegalStateException(param3MethodDescription1 + " does not declare a parameter with index " + this.index + ", " + param3MethodDescription1.getParameters().size() + " defined");  if (!((ParameterDescription)param3MethodDescription1.getParameters().get(this.index)).getType().isArray()) throw new IllegalStateException("Cannot access an item from non-array parameter " + param3MethodDescription1.getParameters().get(this.index) + " at index " + this.index);  ArrayList<MethodCall.ArgumentLoader.ForMethodParameterArrayElement> arrayList = new ArrayList(param3MethodDescription2.getParameters().size()); for (byte b = 0; b < param3MethodDescription2.getParameters().size(); b++) arrayList.add(new MethodCall.ArgumentLoader.ForMethodParameterArrayElement((ParameterDescription)param3MethodDescription1.getParameters().get(this.index), b));  return (List)arrayList; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((OfInvokedMethod)param3Object).index)))); } public int hashCode() { return getClass().hashCode() * 31 + this.index; } } } @Enhance public static class ForInstance implements ArgumentLoader, ArgumentProvider { private final FieldDescription fieldDescription; public ForInstance(FieldDescription param2FieldDescription) { this.fieldDescription = param2FieldDescription; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2) { return Collections.singletonList(this); } public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { StackManipulation.Compound compound; if (!(compound = new StackManipulation.Compound(new StackManipulation[] { FieldAccess.forField(this.fieldDescription).read(), param2Assigner.assign(this.fieldDescription.getType(), param2ParameterDescription.getType(), param2Typing) })).isValid()) throw new IllegalStateException("Cannot assign " + this.fieldDescription.getType() + " to " + param2ParameterDescription);  return (StackManipulation)compound; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldDescription.equals(((ForInstance)param2Object).fieldDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.fieldDescription.hashCode(); } @Enhance protected static class Factory implements MethodCall.ArgumentLoader.Factory { private static final String FIELD_PREFIX = "methodCall"; private final Object value; @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE) private final String name; public Factory(Object param3Object) { this.value = param3Object; this.name = "methodCall$" + RandomString.hashOf(param3Object); } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4105, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.value.getClass())), this.value); } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { return new MethodCall.ArgumentLoader.ForInstance((FieldDescription)((FieldList)param3Target.getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly()); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.value.equals(((Factory)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value.hashCode(); } } } @Enhance public static class ForField implements ArgumentLoader { private final FieldDescription fieldDescription; private final MethodDescription instrumentedMethod; public ForField(FieldDescription param2FieldDescription, MethodDescription param2MethodDescription) { this.fieldDescription = param2FieldDescription; this.instrumentedMethod = param2MethodDescription; } public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { if (!this.fieldDescription.isStatic() && this.instrumentedMethod.isStatic()) throw new IllegalStateException("Cannot access non-static " + this.fieldDescription + " from " + this.instrumentedMethod);  StackManipulation.Compound compound; if (!(compound = new StackManipulation.Compound(new StackManipulation[] { this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read(), param2Assigner.assign(this.fieldDescription.getType(), param2ParameterDescription.getType(), param2Typing) })).isValid()) throw new IllegalStateException("Cannot assign " + this.fieldDescription + " to " + param2ParameterDescription);  return (StackManipulation)compound; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldDescription.equals(((ForField)param2Object).fieldDescription) ? false : (!!this.instrumentedMethod.equals(((ForField)param2Object).instrumentedMethod))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.instrumentedMethod.hashCode(); } @Enhance protected static class ArgumentProvider implements MethodCall.ArgumentLoader.ArgumentProvider { private final FieldDescription fieldDescription; protected ArgumentProvider(FieldDescription param3FieldDescription) { this.fieldDescription = param3FieldDescription; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { return Collections.singletonList(new MethodCall.ArgumentLoader.ForField(this.fieldDescription, param3MethodDescription1)); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((ArgumentProvider)param3Object).fieldDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.fieldDescription.hashCode(); } } @Enhance protected static class Factory implements MethodCall.ArgumentLoader.Factory { private final String name; private final FieldLocator.Factory fieldLocatorFactory; public Factory(String param3String, FieldLocator.Factory param3Factory) { this.name = param3String; this.fieldLocatorFactory = param3Factory; } public InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { FieldLocator.Resolution resolution; if (!(resolution = this.fieldLocatorFactory.make(param3Target.getInstrumentedType()).locate(this.name)).isResolved()) throw new IllegalStateException("Could not locate field '" + this.name + "' on " + param3Target.getInstrumentedType());  return new MethodCall.ArgumentLoader.ForField.ArgumentProvider(resolution.getField()); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.name.equals(((Factory)param3Object).name) ? false : (!!this.fieldLocatorFactory.equals(((Factory)param3Object).fieldLocatorFactory))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.fieldLocatorFactory.hashCode(); } } } @Enhance public static class ForMethodCall implements ArgumentLoader { private final MethodCall.Appender appender; private final MethodDescription methodDescription; private final MethodDescription instrumentedMethod; private final MethodCall.TargetHandler.Resolved targetHandler; public ForMethodCall(MethodCall.Appender param2Appender, MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2, MethodCall.TargetHandler.Resolved param2Resolved) { this.appender = param2Appender; this.methodDescription = param2MethodDescription1; this.instrumentedMethod = param2MethodDescription2; this.targetHandler = param2Resolved; } public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { StackManipulation.Compound compound; if (!(compound = new StackManipulation.Compound(new StackManipulation[] { this.appender.toStackManipulation(this.instrumentedMethod, this.methodDescription, this.targetHandler), param2Assigner.assign(this.methodDescription.isConstructor() ? this.methodDescription.getDeclaringType().asGenericType() : this.methodDescription.getReturnType(), param2ParameterDescription.getType(), param2Typing) })).isValid()) throw new IllegalStateException("Cannot assign return type of " + this.methodDescription + " to " + param2ParameterDescription);  return (StackManipulation)compound; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.appender.equals(((ForMethodCall)param2Object).appender) ? false : (!this.methodDescription.equals(((ForMethodCall)param2Object).methodDescription) ? false : (!this.instrumentedMethod.equals(((ForMethodCall)param2Object).instrumentedMethod) ? false : (!!this.targetHandler.equals(((ForMethodCall)param2Object).targetHandler))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.appender.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.instrumentedMethod.hashCode()) * 31 + this.targetHandler.hashCode(); } @Enhance protected static class ArgumentProvider implements MethodCall.ArgumentLoader.ArgumentProvider { private final MethodCall.Appender appender; protected ArgumentProvider(MethodCall.Appender param3Appender) { this.appender = param3Appender; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { MethodCall.TargetHandler.Resolved resolved = MethodCall.Appender.a(this.appender).resolve(param3MethodDescription1); return Collections.singletonList(new MethodCall.ArgumentLoader.ForMethodCall(this.appender, this.appender.toInvokedMethod(param3MethodDescription1, resolved), param3MethodDescription1, resolved)); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.appender.equals(((ArgumentProvider)param3Object).appender)))); } public int hashCode() { return getClass().hashCode() * 31 + this.appender.hashCode(); } } @Enhance protected static class Factory implements MethodCall.ArgumentLoader.Factory { public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param3Target) { this.methodCall.getClass(); return new MethodCall.ArgumentLoader.ForMethodCall.ArgumentProvider(new MethodCall.Appender(this.methodCall, param3Target, MethodCall.TerminationHandler.Simple.IGNORING)); }
/*      */ 
/*      */         
/*      */         private final MethodCall methodCall;
/*      */         
/*      */         public Factory(MethodCall param3MethodCall) {
/*      */           this.methodCall = param3MethodCall;
/*      */         }
/*      */         
/*      */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/*      */           return this.methodCall.prepare(param3InstrumentedType);
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.methodCall.equals(((Factory)param3Object).methodCall))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.methodCall.hashCode();
/*      */         } } }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForStackManipulation implements ArgumentLoader, ArgumentProvider, Factory {
/*      */       private final StackManipulation stackManipulation;
/*      */       private final TypeDefinition typeDefinition;
/*      */       
/*      */       public ForStackManipulation(StackManipulation param2StackManipulation, Type param2Type) {
/* 1807 */         this(param2StackManipulation, (TypeDefinition)TypeDefinition.Sort.describe(param2Type));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ForStackManipulation(StackManipulation param2StackManipulation, TypeDefinition param2TypeDefinition) {
/* 1817 */         this.stackManipulation = param2StackManipulation;
/* 1818 */         this.typeDefinition = param2TypeDefinition;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static MethodCall.ArgumentLoader.Factory of(@MaybeNull Object param2Object) {
/* 1829 */         if (param2Object == null)
/* 1830 */           return MethodCall.ArgumentLoader.ForNullConstant.INSTANCE; 
/* 1831 */         if (param2Object instanceof Boolean)
/* 1832 */           return new ForStackManipulation(IntegerConstant.forValue(((Boolean)param2Object).booleanValue()), boolean.class); 
/* 1833 */         if (param2Object instanceof Byte)
/* 1834 */           return new ForStackManipulation(IntegerConstant.forValue(((Byte)param2Object).byteValue()), byte.class); 
/* 1835 */         if (param2Object instanceof Short)
/* 1836 */           return new ForStackManipulation(IntegerConstant.forValue(((Short)param2Object).shortValue()), short.class); 
/* 1837 */         if (param2Object instanceof Character)
/* 1838 */           return new ForStackManipulation(IntegerConstant.forValue(((Character)param2Object).charValue()), char.class); 
/* 1839 */         if (param2Object instanceof Integer)
/* 1840 */           return new ForStackManipulation(IntegerConstant.forValue(((Integer)param2Object).intValue()), int.class); 
/* 1841 */         if (param2Object instanceof Long)
/* 1842 */           return new ForStackManipulation(LongConstant.forValue(((Long)param2Object).longValue()), long.class); 
/* 1843 */         if (param2Object instanceof Float)
/* 1844 */           return new ForStackManipulation(FloatConstant.forValue(((Float)param2Object).floatValue()), float.class); 
/* 1845 */         if (param2Object instanceof Double)
/* 1846 */           return new ForStackManipulation(DoubleConstant.forValue(((Double)param2Object).doubleValue()), double.class); 
/* 1847 */         if (param2Object instanceof String)
/* 1848 */           return new ForStackManipulation((StackManipulation)new TextConstant((String)param2Object), String.class); 
/* 1849 */         if (param2Object instanceof Class)
/* 1850 */           return new ForStackManipulation(ClassConstant.of(TypeDescription.ForLoadedType.of((Class)param2Object)), Class.class); 
/* 1851 */         if (param2Object instanceof TypeDescription)
/* 1852 */           return new ForStackManipulation(ClassConstant.of((TypeDescription)param2Object), Class.class); 
/* 1853 */         if (param2Object instanceof Enum) {
/* 1854 */           param2Object = new EnumerationDescription.ForLoadedEnumeration((Enum)param2Object);
/* 1855 */           return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription)param2Object), (TypeDefinition)param2Object.getEnumerationType());
/* 1856 */         }  if (param2Object instanceof EnumerationDescription)
/* 1857 */           return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription)param2Object), (TypeDefinition)((EnumerationDescription)param2Object).getEnumerationType()); 
/* 1858 */         if (JavaType.METHOD_HANDLE.isInstance(param2Object))
/* 1859 */           return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.ofLoaded(param2Object)), (TypeDefinition)JavaType.METHOD_HANDLE.getTypeStub()); 
/* 1860 */         if (JavaType.METHOD_TYPE.isInstance(param2Object))
/* 1861 */           return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodType.ofLoaded(param2Object)), (TypeDefinition)JavaType.METHOD_TYPE.getTypeStub()); 
/* 1862 */         if (param2Object instanceof JavaConstant) {
/* 1863 */           return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)param2Object), (TypeDefinition)((JavaConstant)param2Object).getTypeDescription());
/*      */         }
/* 1865 */         return new MethodCall.ArgumentLoader.ForInstance.Factory(param2Object);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1873 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param2Target) {
/* 1880 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodCall.ArgumentLoader> resolve(MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2) {
/* 1887 */         return Collections.singletonList(this);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation toStackManipulation(ParameterDescription param2ParameterDescription, Assigner param2Assigner, Assigner.Typing param2Typing)
/*      */       {
/*      */         StackManipulation stackManipulation;
/* 1895 */         if (!(stackManipulation = param2Assigner.assign(this.typeDefinition.asGenericType(), param2ParameterDescription.getType(), param2Typing)).isValid()) {
/* 1896 */           throw new IllegalStateException("Cannot assign " + param2ParameterDescription + " to " + this.typeDefinition);
/*      */         }
/* 1898 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.stackManipulation, stackManipulation }); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.stackManipulation.equals(((ForStackManipulation)param2Object).stackManipulation) ? false : (!!this.typeDefinition.equals(((ForStackManipulation)param2Object).typeDefinition))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.typeDefinition.hashCode(); } } } @Enhance public static class ForStackManipulation implements ArgumentLoader, ArgumentLoader.ArgumentProvider, ArgumentLoader.Factory { private final StackManipulation stackManipulation; private final TypeDefinition typeDefinition; public ForStackManipulation(StackManipulation param1StackManipulation, Type param1Type) { this(param1StackManipulation, (TypeDefinition)TypeDefinition.Sort.describe(param1Type)); } public ForStackManipulation(StackManipulation param1StackManipulation, TypeDefinition param1TypeDefinition) { this.stackManipulation = param1StackManipulation; this.typeDefinition = param1TypeDefinition; } public static MethodCall.ArgumentLoader.Factory of(@MaybeNull Object param1Object) { if (param1Object == null) return MethodCall.ArgumentLoader.ForNullConstant.INSTANCE;  if (param1Object instanceof Boolean) return new ForStackManipulation(IntegerConstant.forValue(((Boolean)param1Object).booleanValue()), boolean.class);  if (param1Object instanceof Byte) return new ForStackManipulation(IntegerConstant.forValue(((Byte)param1Object).byteValue()), byte.class);  if (param1Object instanceof Short) return new ForStackManipulation(IntegerConstant.forValue(((Short)param1Object).shortValue()), short.class);  if (param1Object instanceof Character) return new ForStackManipulation(IntegerConstant.forValue(((Character)param1Object).charValue()), char.class);  if (param1Object instanceof Integer) return new ForStackManipulation(IntegerConstant.forValue(((Integer)param1Object).intValue()), int.class);  if (param1Object instanceof Long) return new ForStackManipulation(LongConstant.forValue(((Long)param1Object).longValue()), long.class);  if (param1Object instanceof Float) return new ForStackManipulation(FloatConstant.forValue(((Float)param1Object).floatValue()), float.class);  if (param1Object instanceof Double) return new ForStackManipulation(DoubleConstant.forValue(((Double)param1Object).doubleValue()), double.class);  if (param1Object instanceof String) return new ForStackManipulation((StackManipulation)new TextConstant((String)param1Object), String.class);  if (param1Object instanceof Class) return new ForStackManipulation(ClassConstant.of(TypeDescription.ForLoadedType.of((Class)param1Object)), Class.class);  if (param1Object instanceof TypeDescription) return new ForStackManipulation(ClassConstant.of((TypeDescription)param1Object), Class.class);  if (param1Object instanceof Enum) { param1Object = new EnumerationDescription.ForLoadedEnumeration((Enum)param1Object); return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription)param1Object), (TypeDefinition)param1Object.getEnumerationType()); }  if (param1Object instanceof EnumerationDescription) return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription)param1Object), (TypeDefinition)((EnumerationDescription)param1Object).getEnumerationType());  if (JavaType.METHOD_HANDLE.isInstance(param1Object)) return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.ofLoaded(param1Object)), (TypeDefinition)JavaType.METHOD_HANDLE.getTypeStub());  if (JavaType.METHOD_TYPE.isInstance(param1Object)) return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodType.ofLoaded(param1Object)), (TypeDefinition)JavaType.METHOD_TYPE.getTypeStub());  if (param1Object instanceof JavaConstant) return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)param1Object), (TypeDefinition)((JavaConstant)param1Object).getTypeDescription());  return new MethodCall.ArgumentLoader.ForInstance.Factory(param1Object); } public InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target) { return this; } public List<MethodCall.ArgumentLoader> resolve(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2) { return Collections.singletonList(this); } public StackManipulation toStackManipulation(ParameterDescription param1ParameterDescription, Assigner param1Assigner, Assigner.Typing param1Typing) { StackManipulation stackManipulation; if (!(stackManipulation = param1Assigner.assign(this.typeDefinition.asGenericType(), param1ParameterDescription.getType(), param1Typing)).isValid()) throw new IllegalStateException("Cannot assign " + param1ParameterDescription + " to " + this.typeDefinition);  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.stackManipulation, stackManipulation }); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.stackManipulation.equals(((ForStackManipulation)param1Object).stackManipulation) ? false : (!!this.typeDefinition.equals(((ForStackManipulation)param1Object).typeDefinition)))));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */       return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.typeDefinition.hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public static class ForConstructingInvocation
/*      */     implements TargetHandler, TargetHandler.Resolved
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForConstructingInvocation(TypeDescription param1TypeDescription) {
/* 2148 */       this.instrumentedType = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodCall.TargetHandler.Resolved resolve(MethodDescription param1MethodDescription) {
/* 2155 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getTypeDescription() {
/* 2162 */       return this.instrumentedType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation toStackManipulation(MethodDescription param1MethodDescription, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 2169 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(param1MethodDescription.getDeclaringType().asErasure()), (StackManipulation)Duplication.SINGLE });
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForConstructingInvocation)param1Object).instrumentedType))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */     }
/*      */     
/* 2180 */     enum Factory implements MethodCall.TargetHandler.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 2186 */         return param3InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodCall.TargetHandler make(Implementation.Target param3Target)
/*      */       {
/* 2193 */         return new MethodCall.TargetHandler.ForConstructingInvocation(param3Target.getInstrumentedType()); } } } enum Factory implements TargetHandler.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param1InstrumentedType) { return param1InstrumentedType; } public final MethodCall.TargetHandler make(Implementation.Target param1Target) { return new MethodCall.TargetHandler.ForConstructingInvocation(param1Target.getInstrumentedType()); } } protected static interface TargetHandler { Resolved resolve(MethodDescription param1MethodDescription); public static interface Resolved { TypeDescription getTypeDescription(); StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Assigner param2Assigner, Assigner.Typing param2Typing); } public static interface Factory extends InstrumentedType.Prepareable { MethodCall.TargetHandler make(Implementation.Target param2Target); } @Enhance public static class Simple implements TargetHandler, Factory, Resolved { private final TypeDescription typeDescription; private final StackManipulation stackManipulation; protected Simple(TypeDescription param2TypeDescription, StackManipulation param2StackManipulation) { this.typeDescription = param2TypeDescription; this.stackManipulation = param2StackManipulation; } public MethodCall.TargetHandler make(Implementation.Target param2Target) { return this; } public InstrumentedType prepare(InstrumentedType param2InstrumentedType) { return param2InstrumentedType; } public MethodCall.TargetHandler.Resolved resolve(MethodDescription param2MethodDescription) { return this; } public TypeDescription getTypeDescription() { return this.typeDescription; } public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { return this.stackManipulation; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typeDescription.equals(((Simple)param2Object).typeDescription) ? false : (!!this.stackManipulation.equals(((Simple)param2Object).stackManipulation))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.stackManipulation.hashCode(); } } @Enhance public static class ForSelfOrStaticInvocation implements TargetHandler { private final TypeDescription instrumentedType; protected ForSelfOrStaticInvocation(TypeDescription param2TypeDescription) { this.instrumentedType = param2TypeDescription; } public MethodCall.TargetHandler.Resolved resolve(MethodDescription param2MethodDescription) { return new Resolved(this.instrumentedType, param2MethodDescription); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForSelfOrStaticInvocation)param2Object).instrumentedType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.instrumentedType.hashCode(); } @Enhance protected static class Resolved implements MethodCall.TargetHandler.Resolved { private final TypeDescription instrumentedType; private final MethodDescription instrumentedMethod; protected Resolved(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) { this.instrumentedType = param3TypeDescription; this.instrumentedMethod = param3MethodDescription; } public TypeDescription getTypeDescription() { return this.instrumentedType; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.") public StackManipulation toStackManipulation(MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) { if (this.instrumentedMethod.isStatic() && !param3MethodDescription.isStatic() && !param3MethodDescription.isConstructor()) throw new IllegalStateException("Cannot invoke " + param3MethodDescription + " from " + this.instrumentedMethod);  if (param3MethodDescription.isConstructor() && (!this.instrumentedMethod.isConstructor() || (!this.instrumentedType.equals(param3MethodDescription.getDeclaringType().asErasure()) && (this.instrumentedType.getSuperClass() == null || !this.instrumentedType.getSuperClass().asErasure().equals(param3MethodDescription.getDeclaringType().asErasure()))))) throw new IllegalStateException("Cannot invoke " + param3MethodDescription + " from " + this.instrumentedMethod + " in " + this.instrumentedType);  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param3MethodDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), param3MethodDescription.isConstructor() ? (StackManipulation)Duplication.SINGLE : (StackManipulation)StackManipulation.Trivial.INSTANCE }); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.instrumentedType.equals(((Resolved)param3Object).instrumentedType) ? false : (!!this.instrumentedMethod.equals(((Resolved)param3Object).instrumentedMethod))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.instrumentedMethod.hashCode(); } } protected enum Factory implements MethodCall.TargetHandler.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public final MethodCall.TargetHandler make(Implementation.Target param3Target) { return new MethodCall.TargetHandler.ForSelfOrStaticInvocation(param3Target.getInstrumentedType()); } } } @Enhance public static class ForConstructingInvocation implements TargetHandler, Resolved { private final TypeDescription instrumentedType; protected ForConstructingInvocation(TypeDescription param2TypeDescription) { this.instrumentedType = param2TypeDescription; } public MethodCall.TargetHandler.Resolved resolve(MethodDescription param2MethodDescription) { return this; } public TypeDescription getTypeDescription() { return this.instrumentedType; } public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Assigner param2Assigner, Assigner.Typing param2Typing) { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(param2MethodDescription.getDeclaringType().asErasure()), (StackManipulation)Duplication.SINGLE }); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForConstructingInvocation)param2Object).instrumentedType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.instrumentedType.hashCode(); } enum Factory implements MethodCall.TargetHandler.Factory { INSTANCE; public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) { return param3InstrumentedType; } public final MethodCall.TargetHandler make(Implementation.Target param3Target) { return new MethodCall.TargetHandler.ForConstructingInvocation(param3Target.getInstrumentedType()); }
/*      */          }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForValue
/*      */       implements TargetHandler, Resolved
/*      */     {
/*      */       private final FieldDescription.InDefinedShape fieldDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForValue(FieldDescription.InDefinedShape param2InDefinedShape) {
/* 2215 */         this.fieldDescription = param2InDefinedShape;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.TargetHandler.Resolved resolve(MethodDescription param2MethodDescription) {
/* 2222 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getTypeDescription() {
/* 2229 */         return this.fieldDescription.getType().asErasure();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Assigner param2Assigner, Assigner.Typing param2Typing) {
/*      */         StackManipulation stackManipulation;
/* 2237 */         if (!(stackManipulation = param2Assigner.assign(this.fieldDescription.getType(), param2MethodDescription.getDeclaringType().asGenericType(), param2Typing)).isValid()) {
/* 2238 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " on " + this.fieldDescription);
/*      */         }
/* 2240 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 2241 */               FieldAccess.forField(this.fieldDescription).read(), stackManipulation
/*      */             });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldDescription.equals(((ForValue)param2Object).fieldDescription))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Factory
/*      */         implements MethodCall.TargetHandler.Factory
/*      */       {
/*      */         private static final String FIELD_PREFIX = "invocationTarget";
/*      */ 
/*      */         
/*      */         private final Object target;
/*      */ 
/*      */         
/*      */         private final TypeDescription.Generic fieldType;
/*      */ 
/*      */         
/*      */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */         
/*      */         protected Factory(Object param3Object, TypeDescription.Generic param3Generic) {
/* 2280 */           this.target = param3Object;
/* 2281 */           this.fieldType = param3Generic;
/* 2282 */           this.name = "invocationTarget$" + RandomString.hashOf(param3Object);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 2289 */           return param3InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4169, this.fieldType), this.target);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodCall.TargetHandler make(Implementation.Target param3Target) {
/* 2298 */           return new MethodCall.TargetHandler.ForValue((FieldDescription.InDefinedShape)((FieldList)param3Target.getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly());
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.target.equals(((Factory)param3Object).target) ? false : (!!this.fieldType.equals(((Factory)param3Object).fieldType)))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.fieldType.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class ForField
/*      */       implements TargetHandler, Resolved
/*      */     {
/*      */       private final FieldDescription fieldDescription;
/*      */       
/*      */       protected ForField(FieldDescription param2FieldDescription) {
/* 2320 */         this.fieldDescription = param2FieldDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.TargetHandler.Resolved resolve(MethodDescription param2MethodDescription) {
/* 2327 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getTypeDescription() {
/* 2334 */         return this.fieldDescription.getType().asErasure();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Assigner param2Assigner, Assigner.Typing param2Typing) {
/* 2341 */         if (!param2MethodDescription.isMethod() || 
/* 2342 */           !param2MethodDescription.isVirtual() || 
/* 2343 */           !param2MethodDescription.isVisibleTo(this.fieldDescription.getType().asErasure())) {
/* 2344 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " on " + this.fieldDescription);
/*      */         }
/*      */         StackManipulation stackManipulation;
/* 2347 */         if (!(stackManipulation = param2Assigner.assign(this.fieldDescription.getType(), param2MethodDescription.getDeclaringType().asGenericType(), param2Typing)).isValid()) {
/* 2348 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " on " + this.fieldDescription);
/*      */         }
/* 2350 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { (param2MethodDescription.isStatic() || this.fieldDescription.isStatic()) ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*      */               
/* 2352 */               MethodVariableAccess.loadThis(), 
/* 2353 */               FieldAccess.forField(this.fieldDescription).read(), stackManipulation });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldDescription.equals(((ForField)param2Object).fieldDescription))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static interface Location
/*      */       {
/*      */         FieldDescription resolve(TypeDescription param3TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForImplicitField
/*      */           implements Location
/*      */         {
/*      */           private final String name;
/*      */ 
/*      */           
/*      */           private final FieldLocator.Factory fieldLocatorFactory;
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForImplicitField(String param4String, FieldLocator.Factory param4Factory) {
/* 2392 */             this.name = param4String;
/* 2393 */             this.fieldLocatorFactory = param4Factory;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public FieldDescription resolve(TypeDescription param4TypeDescription) {
/*      */             FieldLocator.Resolution resolution;
/* 2401 */             if (!(resolution = this.fieldLocatorFactory.make(param4TypeDescription).locate(this.name)).isResolved()) {
/* 2402 */               throw new IllegalStateException("Could not locate field name " + this.name + " on " + param4TypeDescription);
/*      */             }
/* 2404 */             return resolution.getField();
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.name.equals(((ForImplicitField)param4Object).name) ? false : (!!this.fieldLocatorFactory.equals(((ForImplicitField)param4Object).fieldLocatorFactory)))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.fieldLocatorFactory.hashCode();
/*      */           }
/*      */         }
/*      */         
/*      */         @Enhance
/*      */         public static class ForExplicitField
/*      */           implements Location
/*      */         {
/*      */           private final FieldDescription fieldDescription;
/*      */           
/*      */           protected ForExplicitField(FieldDescription param4FieldDescription) {
/* 2425 */             this.fieldDescription = param4FieldDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public FieldDescription resolve(TypeDescription param4TypeDescription) {
/* 2432 */             return this.fieldDescription;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.fieldDescription.equals(((ForExplicitField)param4Object).fieldDescription))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       protected static class Factory
/*      */         implements MethodCall.TargetHandler.Factory
/*      */       {
/*      */         private final MethodCall.TargetHandler.ForField.Location location;
/*      */         
/*      */         protected Factory(MethodCall.TargetHandler.ForField.Location param3Location) {
/* 2454 */           this.location = param3Location;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 2461 */           return param3InstrumentedType;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*      */         public MethodCall.TargetHandler make(Implementation.Target param3Target) {
/*      */           FieldDescription fieldDescription;
/* 2470 */           if (!(fieldDescription = this.location.resolve(param3Target.getInstrumentedType())).isStatic() && !param3Target.getInstrumentedType().isAssignableTo(fieldDescription.getDeclaringType().asErasure())) {
/* 2471 */             throw new IllegalStateException("Cannot access " + fieldDescription + " from " + param3Target.getInstrumentedType());
/*      */           }
/* 2473 */           return new MethodCall.TargetHandler.ForField(fieldDescription);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.location.equals(((Factory)param3Object).location))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.location.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class ForMethodParameter
/*      */       implements TargetHandler, Factory
/*      */     {
/*      */       private final int index;
/*      */       
/*      */       protected ForMethodParameter(int param2Int) {
/* 2495 */         this.index = param2Int;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 2502 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.TargetHandler make(Implementation.Target param2Target) {
/* 2509 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.TargetHandler.Resolved resolve(MethodDescription param2MethodDescription) {
/* 2516 */         if (this.index >= param2MethodDescription.getParameters().size()) {
/* 2517 */           throw new IllegalArgumentException(param2MethodDescription + " does not have a parameter with index " + this.index);
/*      */         }
/* 2519 */         return new Resolved((ParameterDescription)param2MethodDescription.getParameters().get(this.index));
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!(this.index != ((ForMethodParameter)param2Object).index))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.index;
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       protected static class Resolved
/*      */         implements MethodCall.TargetHandler.Resolved
/*      */       {
/*      */         private final ParameterDescription parameterDescription;
/*      */         
/*      */         protected Resolved(ParameterDescription param3ParameterDescription) {
/* 2539 */           this.parameterDescription = param3ParameterDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getTypeDescription() {
/* 2546 */           return this.parameterDescription.getType().asErasure();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public StackManipulation toStackManipulation(MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) {
/*      */           StackManipulation stackManipulation;
/* 2554 */           if (!(stackManipulation = param3Assigner.assign(this.parameterDescription.getType(), param3MethodDescription.getDeclaringType().asGenericType(), param3Typing)).isValid()) {
/* 2555 */             throw new IllegalStateException("Cannot invoke " + param3MethodDescription + " on " + this.parameterDescription.getType());
/*      */           }
/* 2557 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.load(this.parameterDescription), stackManipulation });
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.parameterDescription.equals(((Resolved)param3Object).parameterDescription))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.parameterDescription.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class ForMethodCall
/*      */       implements TargetHandler
/*      */     {
/*      */       private final MethodCall.Appender appender;
/*      */       
/*      */       protected ForMethodCall(MethodCall.Appender param2Appender) {
/* 2579 */         this.appender = param2Appender;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodCall.TargetHandler.Resolved resolve(MethodDescription param2MethodDescription) {
/* 2586 */         MethodCall.TargetHandler.Resolved resolved = MethodCall.Appender.a(this.appender).resolve(param2MethodDescription);
/* 2587 */         return new Resolved(this.appender, this.appender.toInvokedMethod(param2MethodDescription, resolved), param2MethodDescription, resolved);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.appender.equals(((ForMethodCall)param2Object).appender))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.appender.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Resolved
/*      */         implements MethodCall.TargetHandler.Resolved
/*      */       {
/*      */         private final MethodCall.Appender appender;
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodDescription methodDescription;
/*      */ 
/*      */         
/*      */         private final MethodDescription instrumentedMethod;
/*      */ 
/*      */         
/*      */         private final MethodCall.TargetHandler.Resolved targetHandler;
/*      */ 
/*      */ 
/*      */         
/*      */         protected Resolved(MethodCall.Appender param3Appender, MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, MethodCall.TargetHandler.Resolved param3Resolved) {
/* 2626 */           this.appender = param3Appender;
/* 2627 */           this.methodDescription = param3MethodDescription1;
/* 2628 */           this.instrumentedMethod = param3MethodDescription2;
/* 2629 */           this.targetHandler = param3Resolved;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription getTypeDescription() {
/* 2636 */           if (this.methodDescription.isConstructor())
/* 2637 */             return this.methodDescription.getDeclaringType().asErasure();  return this.methodDescription
/* 2638 */             .getReturnType().asErasure();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public StackManipulation toStackManipulation(MethodDescription param3MethodDescription, Assigner param3Assigner, Assigner.Typing param3Typing) {
/*      */           StackManipulation stackManipulation;
/* 2648 */           if (!(stackManipulation = param3Assigner.assign(this.methodDescription.isConstructor() ? this.methodDescription.getDeclaringType().asGenericType() : this.methodDescription.getReturnType(), param3MethodDescription.getDeclaringType().asGenericType(), param3Typing)).isValid()) {
/* 2649 */             throw new IllegalStateException("Cannot invoke " + param3MethodDescription + " on " + (this.methodDescription.isConstructor() ? this.methodDescription
/* 2650 */                 .getDeclaringType() : this.methodDescription
/* 2651 */                 .getReturnType()));
/*      */           }
/* 2653 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.appender.toStackManipulation(this.instrumentedMethod, this.methodDescription, this.targetHandler), stackManipulation });
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.appender.equals(((Resolved)param3Object).appender) ? false : (!this.methodDescription.equals(((Resolved)param3Object).methodDescription) ? false : (!this.instrumentedMethod.equals(((Resolved)param3Object).instrumentedMethod) ? false : (!!this.targetHandler.equals(((Resolved)param3Object).targetHandler)))))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (((getClass().hashCode() * 31 + this.appender.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.instrumentedMethod.hashCode()) * 31 + this.targetHandler.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Factory
/*      */         implements MethodCall.TargetHandler.Factory
/*      */       {
/*      */         private final MethodCall methodCall;
/*      */ 
/*      */         
/*      */         public Factory(MethodCall param3MethodCall) {
/* 2676 */           this.methodCall = param3MethodCall;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 2683 */           return this.methodCall.prepare(param3InstrumentedType);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodCall.TargetHandler make(Implementation.Target param3Target) {
/* 2690 */           this.methodCall.getClass(); return new MethodCall.TargetHandler.ForMethodCall(new MethodCall.Appender(this.methodCall, param3Target, MethodCall.TerminationHandler.Simple.IGNORING));
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
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.methodCall.equals(((Factory)param3Object).methodCall))));
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
/*      */           return getClass().hashCode() * 31 + this.methodCall.hashCode();
/*      */         }
/*      */       }
/*      */     } }
/*      */ 
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
/*      */   public static class ForContextualInvocation
/*      */     implements MethodInvoker
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
/*      */     
/*      */     protected ForContextualInvocation(TypeDescription param1TypeDescription) {
/* 2743 */       this.instrumentedType = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation toStackManipulation(MethodDescription param1MethodDescription, Implementation.Target param1Target) {
/* 2750 */       if (param1MethodDescription.isVirtual() && !param1MethodDescription.isInvokableOn(this.instrumentedType)) {
/* 2751 */         throw new IllegalStateException("Cannot invoke " + param1MethodDescription + " on " + this.instrumentedType);
/*      */       }
/* 2753 */       if (param1MethodDescription.isVirtual())
/* 2754 */         return MethodInvocation.invoke(param1MethodDescription).virtual(this.instrumentedType); 
/* 2755 */       return (StackManipulation)MethodInvocation.invoke(param1MethodDescription);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForContextualInvocation)param1Object).instrumentedType))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */     }
/*      */     
/* 2766 */     enum Factory implements MethodCall.MethodInvoker.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodCall.MethodInvoker make(TypeDescription param3TypeDescription)
/*      */       {
/* 2772 */         return new MethodCall.MethodInvoker.ForContextualInvocation(param3TypeDescription); } } } enum Factory implements MethodInvoker.Factory { INSTANCE; public final MethodCall.MethodInvoker make(TypeDescription param1TypeDescription) { return new MethodCall.MethodInvoker.ForContextualInvocation(param1TypeDescription); } } protected static interface MethodInvoker { StackManipulation toStackManipulation(MethodDescription param1MethodDescription, Implementation.Target param1Target); public static interface Factory { MethodCall.MethodInvoker make(TypeDescription param2TypeDescription); } @Enhance public static class ForContextualInvocation implements MethodInvoker { private final TypeDescription instrumentedType; protected ForContextualInvocation(TypeDescription param2TypeDescription) { this.instrumentedType = param2TypeDescription; } public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Implementation.Target param2Target) { if (param2MethodDescription.isVirtual() && !param2MethodDescription.isInvokableOn(this.instrumentedType)) throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " on " + this.instrumentedType);  if (param2MethodDescription.isVirtual()) return MethodInvocation.invoke(param2MethodDescription).virtual(this.instrumentedType);  return (StackManipulation)MethodInvocation.invoke(param2MethodDescription); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForContextualInvocation)param2Object).instrumentedType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.instrumentedType.hashCode(); } enum Factory implements MethodCall.MethodInvoker.Factory { INSTANCE; public final MethodCall.MethodInvoker make(TypeDescription param3TypeDescription) { return new MethodCall.MethodInvoker.ForContextualInvocation(param3TypeDescription); }
/*      */          }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForVirtualInvocation
/*      */       implements MethodInvoker
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForVirtualInvocation(TypeDescription param2TypeDescription) {
/* 2794 */         this.typeDescription = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Implementation.Target param2Target) {
/* 2801 */         if (!param2MethodDescription.isInvokableOn(this.typeDescription)) {
/* 2802 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " on " + this.typeDescription);
/*      */         }
/* 2804 */         return MethodInvocation.invoke(param2MethodDescription).virtual(this.typeDescription);
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((ForVirtualInvocation)param2Object).typeDescription))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */       }
/*      */       
/* 2815 */       protected enum WithImplicitType implements MethodCall.MethodInvoker, MethodCall.MethodInvoker.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final MethodCall.MethodInvoker make(TypeDescription param3TypeDescription) {
/* 2821 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final StackManipulation toStackManipulation(MethodDescription param3MethodDescription, Implementation.Target param3Target) {
/* 2828 */           if (!param3MethodDescription.isAccessibleTo(param3Target.getInstrumentedType()) || !param3MethodDescription.isVirtual()) {
/* 2829 */             throw new IllegalStateException("Cannot invoke " + param3MethodDescription + " virtually");
/*      */           }
/* 2831 */           return (StackManipulation)MethodInvocation.invoke(param3MethodDescription);
/*      */         } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Factory
/*      */         implements MethodCall.MethodInvoker.Factory
/*      */       {
/*      */         private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Factory(TypeDescription param3TypeDescription) {
/* 2852 */           this.typeDescription = param3TypeDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodCall.MethodInvoker make(TypeDescription param3TypeDescription) {
/* 2859 */           if (!this.typeDescription.asErasure().isAccessibleTo(param3TypeDescription)) {
/* 2860 */             throw new IllegalStateException(this.typeDescription + " is not accessible to " + param3TypeDescription);
/*      */           }
/* 2862 */           return new MethodCall.MethodInvoker.ForVirtualInvocation(this.typeDescription);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((Factory)param3Object).typeDescription))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class ForSuperMethodInvocation
/*      */       implements MethodInvoker
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */       
/*      */       protected ForSuperMethodInvocation(TypeDescription param2TypeDescription) {
/* 2884 */         this.instrumentedType = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Implementation.Target param2Target) {
/* 2891 */         if (!param2MethodDescription.isInvokableOn(param2Target.getOriginType().asErasure())) {
/* 2892 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " as super method of " + this.instrumentedType);
/*      */         }
/*      */         
/*      */         Implementation.SpecialMethodInvocation specialMethodInvocation;
/*      */         
/* 2897 */         if (!(specialMethodInvocation = param2Target.invokeDominant(param2MethodDescription.asSignatureToken()).withCheckedCompatibilityTo(param2MethodDescription.asTypeToken())).isValid()) {
/* 2898 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " as a super method");
/*      */         }
/* 2900 */         return specialMethodInvocation;
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForSuperMethodInvocation)param2Object).instrumentedType))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */       }
/*      */       
/* 2911 */       enum Factory implements MethodCall.MethodInvoker.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final MethodCall.MethodInvoker make(TypeDescription param3TypeDescription) {
/* 2917 */           if (param3TypeDescription.getSuperClass() == null) {
/* 2918 */             throw new IllegalStateException("Cannot invoke super method for " + param3TypeDescription);
/*      */           }
/* 2920 */           return new MethodCall.MethodInvoker.ForSuperMethodInvocation(param3TypeDescription);
/*      */         } }
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForDefaultMethodInvocation
/*      */       implements MethodInvoker
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForDefaultMethodInvocation(TypeDescription param2TypeDescription) {
/* 2942 */         this.instrumentedType = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation toStackManipulation(MethodDescription param2MethodDescription, Implementation.Target param2Target) {
/* 2949 */         if (!param2MethodDescription.isInvokableOn(this.instrumentedType)) {
/* 2950 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " as default method of " + this.instrumentedType);
/*      */         }
/*      */         
/*      */         Implementation.SpecialMethodInvocation specialMethodInvocation;
/*      */         
/* 2955 */         if (!(specialMethodInvocation = param2Target.invokeDefault(param2MethodDescription.asSignatureToken(), param2MethodDescription.getDeclaringType().asErasure()).withCheckedCompatibilityTo(param2MethodDescription.asTypeToken())).isValid()) {
/* 2956 */           throw new IllegalStateException("Cannot invoke " + param2MethodDescription + " on " + this.instrumentedType);
/*      */         }
/* 2958 */         return specialMethodInvocation;
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.instrumentedType.equals(((ForDefaultMethodInvocation)param2Object).instrumentedType))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */       }
/*      */       
/* 2969 */       enum Factory implements MethodCall.MethodInvoker.Factory { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final MethodCall.MethodInvoker make(TypeDescription param3TypeDescription) {
/* 2975 */           return new MethodCall.MethodInvoker.ForDefaultMethodInvocation(param3TypeDescription);
/*      */         } }
/*      */     
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum Simple
/*      */     implements TerminationHandler, TerminationHandler.Factory
/*      */   {
/* 3027 */     RETURNING
/*      */     {
/*      */       public final StackManipulation toStackManipulation(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, Assigner param3Assigner, Assigner.Typing param3Typing)
/*      */       {
/*      */         StackManipulation stackManipulation;
/*      */ 
/*      */ 
/*      */         
/* 3035 */         if (!(stackManipulation = param3Assigner.assign(param3MethodDescription1.isConstructor() ? param3MethodDescription1.getDeclaringType().asGenericType() : param3MethodDescription1.getReturnType(), param3MethodDescription2.getReturnType(), param3Typing)).isValid()) {
/* 3036 */           throw new IllegalStateException("Cannot return " + param3MethodDescription1.getReturnType() + " from " + param3MethodDescription2);
/*      */         }
/* 3038 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { stackManipulation, MethodReturn.of((TypeDefinition)param3MethodDescription2.getReturnType())
/*      */ 
/*      */ 
/*      */             
/*      */             });
/*      */       }
/*      */     },
/* 3045 */     DROPPING
/*      */     {
/*      */       
/*      */       public final StackManipulation toStackManipulation(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, Assigner param3Assigner, Assigner.Typing param3Typing)
/*      */       {
/* 3050 */         return Removal.of(param3MethodDescription1.isConstructor() ? param3MethodDescription1
/* 3051 */             .getDeclaringType() : (TypeDefinition)param3MethodDescription1
/* 3052 */             .getReturnType());
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3059 */     IGNORING
/*      */     {
/*      */       
/*      */       public final StackManipulation toStackManipulation(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, Assigner param3Assigner, Assigner.Typing param3Typing)
/*      */       {
/* 3064 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodCall.TerminationHandler make(TypeDescription param1TypeDescription) {
/* 3072 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public StackManipulation prepare()
/*      */     {
/* 3079 */       return (StackManipulation)StackManipulation.Trivial.INSTANCE; } } protected static interface TerminationHandler { StackManipulation prepare(); StackManipulation toStackManipulation(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2, Assigner param1Assigner, Assigner.Typing param1Typing); public static interface Factory { MethodCall.TerminationHandler make(TypeDescription param2TypeDescription); } public enum Simple implements TerminationHandler, Factory { RETURNING { public final StackManipulation toStackManipulation(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, Assigner param3Assigner, Assigner.Typing param3Typing) { StackManipulation stackManipulation; if (!(stackManipulation = param3Assigner.assign(param3MethodDescription1.isConstructor() ? param3MethodDescription1.getDeclaringType().asGenericType() : param3MethodDescription1.getReturnType(), param3MethodDescription2.getReturnType(), param3Typing)).isValid()) throw new IllegalStateException("Cannot return " + param3MethodDescription1.getReturnType() + " from " + param3MethodDescription2);  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { stackManipulation, MethodReturn.of((TypeDefinition)param3MethodDescription2.getReturnType()) }); } }, DROPPING { public final StackManipulation toStackManipulation(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, Assigner param3Assigner, Assigner.Typing param3Typing) { return Removal.of(param3MethodDescription1.isConstructor() ? param3MethodDescription1.getDeclaringType() : (TypeDefinition)param3MethodDescription1.getReturnType()); } }, IGNORING { public final StackManipulation toStackManipulation(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, Assigner param3Assigner, Assigner.Typing param3Typing) { return (StackManipulation)StackManipulation.Trivial.INSTANCE; } }; public MethodCall.TerminationHandler make(TypeDescription param2TypeDescription) { return this; } public StackManipulation prepare() { return (StackManipulation)StackManipulation.Trivial.INSTANCE; }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class FieldSetting
/*      */       implements TerminationHandler
/*      */     {
/*      */       private final FieldDescription fieldDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected FieldSetting(FieldDescription param2FieldDescription) {
/* 3101 */         this.fieldDescription = param2FieldDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation prepare() {
/* 3108 */         return (StackManipulation)(this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : 
/*      */           
/* 3110 */           MethodVariableAccess.loadThis());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation toStackManipulation(MethodDescription param2MethodDescription1, MethodDescription param2MethodDescription2, Assigner param2Assigner, Assigner.Typing param2Typing) {
/*      */         StackManipulation stackManipulation;
/* 3120 */         if (!(stackManipulation = param2Assigner.assign(param2MethodDescription1.isConstructor() ? param2MethodDescription1.getDeclaringType().asGenericType() : param2MethodDescription1.getReturnType(), this.fieldDescription.getType(), param2Typing)).isValid()) {
/* 3121 */           throw new IllegalStateException("Cannot assign result of " + param2MethodDescription1 + " to " + this.fieldDescription);
/*      */         }
/* 3123 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { stackManipulation, FieldAccess.forField(this.fieldDescription).write() });
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldDescription.equals(((FieldSetting)param2Object).fieldDescription))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       protected static class Explicit
/*      */         implements MethodCall.TerminationHandler.Factory
/*      */       {
/*      */         private final FieldDescription fieldDescription;
/*      */         
/*      */         protected Explicit(FieldDescription param3FieldDescription) {
/* 3143 */           this.fieldDescription = param3FieldDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*      */         public MethodCall.TerminationHandler make(TypeDescription param3TypeDescription) {
/* 3151 */           if (!this.fieldDescription.isStatic() && !param3TypeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure()))
/* 3152 */             throw new IllegalStateException("Cannot set " + this.fieldDescription + " from " + param3TypeDescription); 
/* 3153 */           if (!this.fieldDescription.isVisibleTo(param3TypeDescription)) {
/* 3154 */             throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + param3TypeDescription);
/*      */           }
/* 3156 */           return new MethodCall.TerminationHandler.FieldSetting(this.fieldDescription);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((Explicit)param3Object).fieldDescription))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       protected static class Implicit
/*      */         implements MethodCall.TerminationHandler.Factory
/*      */       {
/*      */         private final ElementMatcher<? super FieldDescription> matcher;
/*      */         
/*      */         protected Implicit(ElementMatcher<? super FieldDescription> param3ElementMatcher) {
/* 3177 */           this.matcher = param3ElementMatcher;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodCall.TerminationHandler make(TypeDescription param3TypeDescription)
/*      */         {
/* 3184 */           TypeDescription typeDescription = param3TypeDescription;
/*      */           while (true)
/*      */           { FieldList fieldList;
/* 3187 */             if ((fieldList = (FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.isVisibleTo(param3TypeDescription).and(this.matcher))).size() == 1)
/* 3188 */               return new MethodCall.TerminationHandler.FieldSetting((FieldDescription)fieldList.getOnly()); 
/* 3189 */             if (fieldList.size() == 2) {
/* 3190 */               throw new IllegalStateException(this.matcher + " is ambiguous and resolved: " + fieldList);
/*      */             }
/*      */             TypeDescription.Generic generic;
/* 3193 */             if ((generic = typeDescription.getSuperClass()) == null)
/* 3194 */               throw new IllegalStateException(this.matcher + " does not locate any accessible fields for " + param3TypeDescription);  }  } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matcher.equals(((Implicit)param3Object).matcher)))); } public int hashCode() { return getClass().hashCode() * 31 + this.matcher.hashCode(); } } } } @Enhance public static class FieldSetting implements TerminationHandler { private final FieldDescription fieldDescription; protected FieldSetting(FieldDescription param1FieldDescription) { this.fieldDescription = param1FieldDescription; } public StackManipulation prepare() { return (StackManipulation)(this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis()); } public StackManipulation toStackManipulation(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2, Assigner param1Assigner, Assigner.Typing param1Typing) { StackManipulation stackManipulation; if (!(stackManipulation = param1Assigner.assign(param1MethodDescription1.isConstructor() ? param1MethodDescription1.getDeclaringType().asGenericType() : param1MethodDescription1.getReturnType(), this.fieldDescription.getType(), param1Typing)).isValid()) throw new IllegalStateException("Cannot assign result of " + param1MethodDescription1 + " to " + this.fieldDescription);  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { stackManipulation, FieldAccess.forField(this.fieldDescription).write() }); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.fieldDescription.equals(((FieldSetting)param1Object).fieldDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.fieldDescription.hashCode(); } @Enhance protected static class Explicit implements MethodCall.TerminationHandler.Factory { private final FieldDescription fieldDescription; protected Explicit(FieldDescription param3FieldDescription) { this.fieldDescription = param3FieldDescription; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.") public MethodCall.TerminationHandler make(TypeDescription param3TypeDescription) { if (!this.fieldDescription.isStatic() && !param3TypeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure())) throw new IllegalStateException("Cannot set " + this.fieldDescription + " from " + param3TypeDescription);  if (!this.fieldDescription.isVisibleTo(param3TypeDescription)) throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + param3TypeDescription);  return new MethodCall.TerminationHandler.FieldSetting(this.fieldDescription); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((Explicit)param3Object).fieldDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.fieldDescription.hashCode(); } } @Enhance protected static class Implicit implements MethodCall.TerminationHandler.Factory { private final ElementMatcher<? super FieldDescription> matcher; protected Implicit(ElementMatcher<? super FieldDescription> param3ElementMatcher) { this.matcher = param3ElementMatcher; } public MethodCall.TerminationHandler make(TypeDescription param3TypeDescription) { TypeDescription typeDescription = param3TypeDescription; while (true) { FieldList fieldList; if ((fieldList = (FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.isVisibleTo(param3TypeDescription).and(this.matcher))).size() == 1) return new MethodCall.TerminationHandler.FieldSetting((FieldDescription)fieldList.getOnly());  if (fieldList.size() == 2) throw new IllegalStateException(this.matcher + " is ambiguous and resolved: " + fieldList);  TypeDescription.Generic generic; if ((generic = typeDescription.getSuperClass()) == null) throw new IllegalStateException(this.matcher + " does not locate any accessible fields for " + param3TypeDescription);  }  } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matcher.equals(((Implicit)param3Object).matcher)))); } public int hashCode() { return getClass().hashCode() * 31 + this.matcher.hashCode(); } } } @Enhance protected static class Explicit implements TerminationHandler.Factory { private final FieldDescription fieldDescription; protected Explicit(FieldDescription param1FieldDescription) { this.fieldDescription = param1FieldDescription; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.") public MethodCall.TerminationHandler make(TypeDescription param1TypeDescription) { if (!this.fieldDescription.isStatic() && !param1TypeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure())) throw new IllegalStateException("Cannot set " + this.fieldDescription + " from " + param1TypeDescription);  if (!this.fieldDescription.isVisibleTo(param1TypeDescription)) throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + param1TypeDescription);  return new MethodCall.TerminationHandler.FieldSetting(this.fieldDescription); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.fieldDescription.equals(((Explicit)param1Object).fieldDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.fieldDescription.hashCode(); } } @Enhance protected static class Implicit implements TerminationHandler.Factory { private final ElementMatcher<? super FieldDescription> matcher; protected Implicit(ElementMatcher<? super FieldDescription> param1ElementMatcher) { this.matcher = param1ElementMatcher; } public MethodCall.TerminationHandler make(TypeDescription param1TypeDescription) { TypeDescription typeDescription = param1TypeDescription; while (true) { FieldList fieldList; if ((fieldList = (FieldList)typeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.isVisibleTo(param1TypeDescription).and(this.matcher))).size() == 1) return new MethodCall.TerminationHandler.FieldSetting((FieldDescription)fieldList.getOnly());  if (fieldList.size() == 2) throw new IllegalStateException(this.matcher + " is ambiguous and resolved: " + fieldList);  TypeDescription.Generic generic; if ((generic = typeDescription.getSuperClass()) == null) throw new IllegalStateException(this.matcher + " does not locate any accessible fields for " + param1TypeDescription);
/*      */          }
/*      */        }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.matcher.equals(((Implicit)param1Object).matcher))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.matcher.hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class WithoutSpecifiedTarget
/*      */     extends MethodCall
/*      */   {
/*      */     protected WithoutSpecifiedTarget(MethodCall.MethodLocator.Factory param1Factory) {
/* 3215 */       super(param1Factory, MethodCall.TargetHandler.ForSelfOrStaticInvocation.Factory.INSTANCE, 
/*      */           
/* 3217 */           Collections.emptyList(), MethodCall.MethodInvoker.ForContextualInvocation.Factory.INSTANCE, MethodCall.TerminationHandler.Simple.RETURNING, Assigner.DEFAULT, Assigner.Typing.STATIC);
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
/*      */     public MethodCall on(Object param1Object) {
/* 3232 */       return on(param1Object, (Class)param1Object.getClass());
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
/*      */     public <T> MethodCall on(T param1T, Class<? super T> param1Class) {
/* 3244 */       return new MethodCall(this.methodLocator, new MethodCall.TargetHandler.ForValue.Factory(param1T, 
/* 3245 */             TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(param1Class)), this.argumentLoaders, new MethodCall.MethodInvoker.ForVirtualInvocation.Factory(
/*      */             
/* 3247 */             TypeDescription.ForLoadedType.of(param1Class)), this.terminationHandler, this.assigner, this.typing);
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
/*      */     public MethodCall on(StackManipulation param1StackManipulation, Class<?> param1Class) {
/* 3261 */       return on(param1StackManipulation, TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodCall on(StackManipulation param1StackManipulation, TypeDescription param1TypeDescription) {
/* 3272 */       return new MethodCall(this.methodLocator, new MethodCall.TargetHandler.Simple(param1TypeDescription, param1StackManipulation), this.argumentLoaders, new MethodCall.MethodInvoker.ForVirtualInvocation.Factory(param1TypeDescription), this.terminationHandler, this.assigner, this.typing);
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
/*      */     public MethodCall onArgument(int param1Int) {
/* 3288 */       if (param1Int < 0) {
/* 3289 */         throw new IllegalArgumentException("An argument index cannot be negative: " + param1Int);
/*      */       }
/* 3291 */       return new MethodCall(this.methodLocator, new MethodCall.TargetHandler.ForMethodParameter(param1Int), this.argumentLoaders, MethodCall.MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.terminationHandler, this.assigner, this.typing);
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
/*      */     public MethodCall onField(String param1String) {
/* 3307 */       return onField(param1String, (FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodCall onField(String param1String, FieldLocator.Factory param1Factory) {
/* 3318 */       return new MethodCall(this.methodLocator, new MethodCall.TargetHandler.ForField.Factory(new MethodCall.TargetHandler.ForField.Location.ForImplicitField(param1String, param1Factory)), this.argumentLoaders, MethodCall.MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.terminationHandler, this.assigner, this.typing);
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
/*      */     public MethodCall onField(Field param1Field) {
/* 3334 */       return onField((FieldDescription)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodCall onField(FieldDescription param1FieldDescription) {
/* 3344 */       return new MethodCall(this.methodLocator, new MethodCall.TargetHandler.ForField.Factory(new MethodCall.TargetHandler.ForField.Location.ForExplicitField(param1FieldDescription)), this.argumentLoaders, MethodCall.MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.terminationHandler, this.assigner, this.typing);
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
/*      */     public MethodCall onMethodCall(MethodCall param1MethodCall) {
/* 3360 */       return new MethodCall(this.methodLocator, new MethodCall.TargetHandler.ForMethodCall.Factory(param1MethodCall), this.argumentLoaders, MethodCall.MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.terminationHandler, this.assigner, this.typing);
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
/*      */     
/*      */     public MethodCall onSuper() {
/* 3378 */       return new MethodCall(this.methodLocator, MethodCall.TargetHandler.ForSelfOrStaticInvocation.Factory.INSTANCE, this.argumentLoaders, MethodCall.MethodInvoker.ForSuperMethodInvocation.Factory.INSTANCE, this.terminationHandler, this.assigner, this.typing);
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
/*      */     public MethodCall onDefault() {
/* 3393 */       return new MethodCall(this.methodLocator, MethodCall.TargetHandler.ForSelfOrStaticInvocation.Factory.INSTANCE, this.argumentLoaders, MethodCall.MethodInvoker.ForDefaultMethodInvocation.Factory.INSTANCE, this.terminationHandler, this.assigner, this.typing);
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
/*      */   @Enhance
/*      */   public static class FieldSetting
/*      */     implements Implementation.Composable
/*      */   {
/*      */     private final MethodCall methodCall;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected FieldSetting(MethodCall param1MethodCall) {
/* 3420 */       this.methodCall = param1MethodCall;
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
/*      */     public Implementation.Composable withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 3432 */       return new FieldSetting((MethodCall)this.methodCall.withAssigner(param1Assigner, param1Typing));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 3439 */       return this.methodCall.prepare(param1InstrumentedType);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 3446 */       return (ByteCodeAppender)new ByteCodeAppender.Compound(new ByteCodeAppender[] { this.methodCall.appender(param1Target), Appender.INSTANCE });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation andThen(Implementation param1Implementation) {
/* 3453 */       return new Implementation.Compound(new Implementation[] { this.methodCall, param1Implementation });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable andThen(Implementation.Composable param1Composable) {
/* 3460 */       return new Implementation.Compound.Composable(this.methodCall, param1Composable);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.methodCall.equals(((FieldSetting)param1Object).methodCall))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.methodCall.hashCode();
/*      */     }
/*      */     
/* 3471 */     protected enum Appender implements ByteCodeAppender { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 3477 */         if (!param2MethodDescription.getReturnType().represents(void.class)) {
/* 3478 */           throw new IllegalStateException("Instrumented method " + param2MethodDescription + " does not return void for field setting method call");
/*      */         }
/* 3480 */         return new ByteCodeAppender.Size(MethodReturn.VOID.apply(param2MethodVisitor, param2Context).getMaximalSize(), param2MethodDescription.getStackSize());
/*      */       } }
/*      */   
/*      */   }
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
/*      */     private final Implementation.Target implementationTarget;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodCall.MethodLocator methodLocator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<MethodCall.ArgumentLoader.ArgumentProvider> argumentProviders;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodCall.MethodInvoker methodInvoker;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodCall.TargetHandler targetHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodCall.TerminationHandler terminationHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Appender(MethodCall this$0, Implementation.Target param1Target, MethodCall.TerminationHandler param1TerminationHandler) {
/* 3528 */       this.implementationTarget = param1Target;
/* 3529 */       this.methodLocator = this$0.methodLocator.make(param1Target.getInstrumentedType());
/* 3530 */       this.argumentProviders = new ArrayList<MethodCall.ArgumentLoader.ArgumentProvider>(this$0.argumentLoaders.size());
/* 3531 */       for (MethodCall.ArgumentLoader.Factory factory : this$0.argumentLoaders) {
/* 3532 */         this.argumentProviders.add(factory.make(param1Target));
/*      */       }
/* 3534 */       this.methodInvoker = this$0.methodInvoker.make(param1Target.getInstrumentedType());
/* 3535 */       this.targetHandler = this$0.targetHandler.make(param1Target);
/* 3536 */       this.terminationHandler = param1TerminationHandler;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 3543 */       MethodCall.TargetHandler.Resolved resolved = this.targetHandler.resolve(param1MethodDescription);
/* 3544 */       return new ByteCodeAppender.Size((new StackManipulation.Compound(new StackManipulation[] { this.terminationHandler.prepare(), toStackManipulation(param1MethodDescription, 
/* 3545 */                 toInvokedMethod(param1MethodDescription, resolved), resolved)
/* 3546 */             })).apply(param1MethodVisitor, param1Context).getMaximalSize(), param1MethodDescription.getStackSize());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected MethodDescription toInvokedMethod(MethodDescription param1MethodDescription, MethodCall.TargetHandler.Resolved param1Resolved) {
/* 3557 */       return this.methodLocator.resolve(param1Resolved.getTypeDescription(), param1MethodDescription);
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
/*      */     protected StackManipulation toStackManipulation(MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2, MethodCall.TargetHandler.Resolved param1Resolved) {
/* 3569 */       ArrayList<MethodCall.ArgumentLoader> arrayList = new ArrayList();
/* 3570 */       for (MethodCall.ArgumentLoader.ArgumentProvider argumentProvider : this.argumentProviders) {
/* 3571 */         arrayList.addAll(argumentProvider.resolve(param1MethodDescription1, param1MethodDescription2));
/*      */       }
/*      */       ParameterList parameterList;
/* 3574 */       if ((parameterList = param1MethodDescription2.getParameters()).size() != arrayList.size()) {
/* 3575 */         throw new IllegalStateException(param1MethodDescription2 + " does not accept " + arrayList.size() + " arguments");
/*      */       }
/* 3577 */       Iterator<ParameterDescription> iterator = parameterList.iterator();
/* 3578 */       ArrayList<StackManipulation> arrayList1 = new ArrayList(arrayList.size());
/* 3579 */       for (MethodCall.ArgumentLoader argumentLoader : arrayList) {
/* 3580 */         arrayList1.add(argumentLoader.toStackManipulation(iterator.next(), this.a.assigner, this.a.typing));
/*      */       }
/* 3582 */       return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param1Resolved
/* 3583 */             .toStackManipulation(param1MethodDescription2, this.a.assigner, this.a.typing), (StackManipulation)new StackManipulation.Compound(arrayList1), this.methodInvoker
/*      */             
/* 3585 */             .toStackManipulation(param1MethodDescription2, this.implementationTarget), this.terminationHandler
/* 3586 */             .toStackManipulation(param1MethodDescription2, param1MethodDescription1, this.a.assigner, this.a.typing) });
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.implementationTarget.equals(((Appender)param1Object).implementationTarget) ? false : (!this.methodLocator.equals(((Appender)param1Object).methodLocator) ? false : (!this.argumentProviders.equals(((Appender)param1Object).argumentProviders) ? false : (!this.methodInvoker.equals(((Appender)param1Object).methodInvoker) ? false : (!this.targetHandler.equals(((Appender)param1Object).targetHandler) ? false : (!this.terminationHandler.equals(((Appender)param1Object).terminationHandler) ? false : (!!this.a.equals(((Appender)param1Object).a))))))))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return ((((((getClass().hashCode() * 31 + this.implementationTarget.hashCode()) * 31 + this.methodLocator.hashCode()) * 31 + this.argumentProviders.hashCode()) * 31 + this.methodInvoker.hashCode()) * 31 + this.targetHandler.hashCode()) * 31 + this.terminationHandler.hashCode()) * 31 + this.a.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface Factory {
/*      */     MethodCall.MethodLocator make(TypeDescription param1TypeDescription);
/*      */   }
/*      */   
/*      */   public static interface Factory extends InstrumentedType.Prepareable {
/*      */     MethodCall.TargetHandler make(Implementation.Target param1Target);
/*      */   }
/*      */   
/*      */   public static interface Factory extends InstrumentedType.Prepareable {
/*      */     MethodCall.ArgumentLoader.ArgumentProvider make(Implementation.Target param1Target);
/*      */   }
/*      */   
/*      */   public static interface Factory {
/*      */     MethodCall.MethodInvoker make(TypeDescription param1TypeDescription);
/*      */   }
/*      */   
/*      */   public static interface Factory {
/*      */     MethodCall.TerminationHandler make(TypeDescription param1TypeDescription);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\MethodCall.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */