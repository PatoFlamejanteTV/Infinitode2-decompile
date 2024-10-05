/*       */ package net.bytebuddy.asm;
/*       */ 
/*       */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*       */ import java.io.IOException;
/*       */ import java.io.Serializable;
/*       */ import java.lang.annotation.Annotation;
/*       */ import java.lang.annotation.Documented;
/*       */ import java.lang.annotation.ElementType;
/*       */ import java.lang.annotation.Repeatable;
/*       */ import java.lang.annotation.Retention;
/*       */ import java.lang.annotation.RetentionPolicy;
/*       */ import java.lang.annotation.Target;
/*       */ import java.lang.reflect.Constructor;
/*       */ import java.lang.reflect.Field;
/*       */ import java.lang.reflect.Method;
/*       */ import java.lang.reflect.Type;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Arrays;
/*       */ import java.util.Collection;
/*       */ import java.util.Collections;
/*       */ import java.util.HashMap;
/*       */ import java.util.IdentityHashMap;
/*       */ import java.util.Iterator;
/*       */ import java.util.LinkedHashMap;
/*       */ import java.util.List;
/*       */ import java.util.Map;
/*       */ import java.util.SortedMap;
/*       */ import java.util.TreeMap;
/*       */ import net.bytebuddy.ClassFileVersion;
/*       */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*       */ import net.bytebuddy.build.RepeatedAnnotationPlugin.Enhance;
/*       */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*       */ import net.bytebuddy.description.annotation.AnnotationValue;
/*       */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*       */ import net.bytebuddy.description.field.FieldDescription;
/*       */ import net.bytebuddy.description.method.MethodDescription;
/*       */ import net.bytebuddy.description.method.MethodList;
/*       */ import net.bytebuddy.description.method.ParameterDescription;
/*       */ import net.bytebuddy.description.method.ParameterList;
/*       */ import net.bytebuddy.description.type.TypeDefinition;
/*       */ import net.bytebuddy.description.type.TypeDescription;
/*       */ import net.bytebuddy.description.type.TypeList;
/*       */ import net.bytebuddy.dynamic.ClassFileLocator;
/*       */ import net.bytebuddy.dynamic.TargetType;
/*       */ import net.bytebuddy.dynamic.scaffold.FieldLocator;
/*       */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*       */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*       */ import net.bytebuddy.implementation.FieldAccessor;
/*       */ import net.bytebuddy.implementation.Implementation;
/*       */ import net.bytebuddy.implementation.SuperMethodCall;
/*       */ import net.bytebuddy.implementation.bytecode.Addition;
/*       */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*       */ import net.bytebuddy.implementation.bytecode.Duplication;
/*       */ import net.bytebuddy.implementation.bytecode.Removal;
/*       */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*       */ import net.bytebuddy.implementation.bytecode.StackSize;
/*       */ import net.bytebuddy.implementation.bytecode.Throw;
/*       */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*       */ import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
/*       */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
/*       */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*       */ import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
/*       */ import net.bytebuddy.implementation.bytecode.constant.LongConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*       */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*       */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*       */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*       */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*       */ import net.bytebuddy.jar.asm.Attribute;
/*       */ import net.bytebuddy.jar.asm.ClassReader;
/*       */ import net.bytebuddy.jar.asm.ClassVisitor;
/*       */ import net.bytebuddy.jar.asm.Handle;
/*       */ import net.bytebuddy.jar.asm.Label;
/*       */ import net.bytebuddy.jar.asm.MethodVisitor;
/*       */ import net.bytebuddy.jar.asm.Opcodes;
/*       */ import net.bytebuddy.jar.asm.Type;
/*       */ import net.bytebuddy.jar.asm.TypePath;
/*       */ import net.bytebuddy.matcher.ElementMatcher;
/*       */ import net.bytebuddy.matcher.ElementMatchers;
/*       */ import net.bytebuddy.pool.TypePool;
/*       */ import net.bytebuddy.utility.CompoundList;
/*       */ import net.bytebuddy.utility.JavaConstant;
/*       */ import net.bytebuddy.utility.JavaType;
/*       */ import net.bytebuddy.utility.OpenedClassReader;
/*       */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*       */ import net.bytebuddy.utility.nullability.MaybeNull;
/*       */ import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
/*       */ import net.bytebuddy.utility.visitor.LineNumberPrependingMethodVisitor;
/*       */ import net.bytebuddy.utility.visitor.StackAwareMethodVisitor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ @Enhance
/*       */ public class Advice
/*       */   implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper, Implementation
/*       */ {
/*       */   @AlwaysNull
/*   168 */   private static final ClassReader UNDEFINED = null;
/*       */ 
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape SKIP_ON;
/*       */ 
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape PREPEND_LINE_NUMBER;
/*       */ 
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape INLINE_ENTER;
/*       */ 
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape SUPPRESS_ENTER;
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape REPEAT_ON;
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape ON_THROWABLE;
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape BACKUP_ARGUMENTS;
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape INLINE_EXIT;
/*       */ 
/*       */   
/*       */   private static final MethodDescription.InDefinedShape SUPPRESS_EXIT;
/*       */ 
/*       */   
/*       */   private final Dispatcher.Resolved.ForMethodEnter methodEnter;
/*       */ 
/*       */   
/*       */   private final Dispatcher.Resolved.ForMethodExit methodExit;
/*       */ 
/*       */   
/*       */   private final Assigner assigner;
/*       */ 
/*       */   
/*       */   private final ExceptionHandler exceptionHandler;
/*       */ 
/*       */   
/*       */   private final Implementation delegate;
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/*       */     MethodList methodList;
/*   220 */     SKIP_ON = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(OnMethodEnter.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("skipOn"))).getOnly();
/*   221 */     PREPEND_LINE_NUMBER = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("prependLineNumber"))).getOnly();
/*   222 */     INLINE_ENTER = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("inline"))).getOnly();
/*   223 */     SUPPRESS_ENTER = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("suppress"))).getOnly();
/*       */     
/*   225 */     REPEAT_ON = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(OnMethodExit.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("repeatOn"))).getOnly();
/*   226 */     ON_THROWABLE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("onThrowable"))).getOnly();
/*   227 */     BACKUP_ARGUMENTS = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("backupArguments"))).getOnly();
/*   228 */     INLINE_EXIT = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("inline"))).getOnly();
/*   229 */     SUPPRESS_EXIT = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("suppress"))).getOnly();
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   protected Advice(Dispatcher.Resolved.ForMethodEnter paramForMethodEnter, Dispatcher.Resolved.ForMethodExit paramForMethodExit) {
/*   264 */     this(paramForMethodEnter, paramForMethodExit, Assigner.DEFAULT, ExceptionHandler.Default.SUPPRESSING, (Implementation)SuperMethodCall.INSTANCE);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private Advice(Dispatcher.Resolved.ForMethodEnter paramForMethodEnter, Dispatcher.Resolved.ForMethodExit paramForMethodExit, Assigner paramAssigner, ExceptionHandler paramExceptionHandler, Implementation paramImplementation) {
/*   281 */     this.methodEnter = paramForMethodEnter;
/*   282 */     this.methodExit = paramForMethodExit;
/*   283 */     this.assigner = paramAssigner;
/*   284 */     this.exceptionHandler = paramExceptionHandler;
/*   285 */     this.delegate = paramImplementation;
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(Class<?> paramClass) {
/*   296 */     return to(paramClass, ClassFileLocator.ForClassLoader.of(paramClass.getClassLoader()));
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(Class<?> paramClass, ClassFileLocator paramClassFileLocator) {
/*   307 */     return to(TypeDescription.ForLoadedType.of(paramClass), paramClassFileLocator);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(TypeDescription paramTypeDescription) {
/*   319 */     return to(paramTypeDescription, (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/*   330 */     return to(paramTypeDescription, PostProcessor.NoOp.INSTANCE, paramClassFileLocator, Collections.emptyList(), Delegator.ForStaticInvocation.INSTANCE);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   protected static Advice to(TypeDescription paramTypeDescription, PostProcessor.Factory paramFactory, ClassFileLocator paramClassFileLocator, List<? extends OffsetMapping.Factory<?>> paramList, Delegator paramDelegator) {
/*   348 */     Dispatcher.Unresolved unresolved1 = Dispatcher.Inactive.INSTANCE, unresolved2 = Dispatcher.Inactive.INSTANCE;
/*   349 */     for (MethodDescription.InDefinedShape inDefinedShape : paramTypeDescription.getDeclaredMethods()) {
/*   350 */       unresolved1 = locate((Class)OnMethodEnter.class, INLINE_ENTER, unresolved1, inDefinedShape, paramDelegator);
/*   351 */       unresolved2 = locate((Class)OnMethodExit.class, INLINE_EXIT, unresolved2, inDefinedShape, paramDelegator);
/*       */     } 
/*   353 */     if (!unresolved1.isAlive() && !unresolved2.isAlive()) {
/*   354 */       throw new IllegalArgumentException("No advice defined by " + paramTypeDescription);
/*       */     }
/*       */     
/*       */     try {
/*   358 */       ClassReader classReader = (unresolved1.isBinary() || unresolved2.isBinary()) ? OpenedClassReader.of(paramClassFileLocator.locate(paramTypeDescription.getName()).resolve()) : UNDEFINED;
/*       */       
/*   360 */       return new Advice(unresolved1.asMethodEnter(paramList, classReader, unresolved2, paramFactory), unresolved2.asMethodExit(paramList, classReader, unresolved1, paramFactory));
/*   361 */     } catch (IOException iOException) {
/*   362 */       throw new IllegalStateException("Error reading class file of " + paramTypeDescription, iOException);
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(Class<?> paramClass1, Class<?> paramClass2) {
/*   375 */     ClassLoader classLoader1 = paramClass1.getClassLoader(), classLoader2 = paramClass2.getClassLoader();
/*   376 */     return to(paramClass1, paramClass2, (classLoader1 == classLoader2) ? 
/*   377 */         ClassFileLocator.ForClassLoader.of(classLoader1) : (ClassFileLocator)new ClassFileLocator.Compound(new ClassFileLocator[] {
/*   378 */             ClassFileLocator.ForClassLoader.of(classLoader1), ClassFileLocator.ForClassLoader.of(classLoader2)
/*       */           }));
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(Class<?> paramClass1, Class<?> paramClass2, ClassFileLocator paramClassFileLocator) {
/*   390 */     return to(TypeDescription.ForLoadedType.of(paramClass1), TypeDescription.ForLoadedType.of(paramClass2), paramClassFileLocator);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(TypeDescription paramTypeDescription1, TypeDescription paramTypeDescription2) {
/*   403 */     return to(paramTypeDescription1, paramTypeDescription2, (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static Advice to(TypeDescription paramTypeDescription1, TypeDescription paramTypeDescription2, ClassFileLocator paramClassFileLocator) {
/*   415 */     return to(paramTypeDescription1, paramTypeDescription2, PostProcessor.NoOp.INSTANCE, paramClassFileLocator, Collections.emptyList(), Delegator.ForStaticInvocation.INSTANCE);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   protected static Advice to(TypeDescription paramTypeDescription1, TypeDescription paramTypeDescription2, PostProcessor.Factory paramFactory, ClassFileLocator paramClassFileLocator, List<? extends OffsetMapping.Factory<?>> paramList, Delegator paramDelegator) {
/*   435 */     Dispatcher.Unresolved unresolved1 = Dispatcher.Inactive.INSTANCE, unresolved2 = Dispatcher.Inactive.INSTANCE;
/*   436 */     for (MethodDescription.InDefinedShape inDefinedShape : paramTypeDescription1.getDeclaredMethods()) {
/*   437 */       unresolved1 = locate((Class)OnMethodEnter.class, INLINE_ENTER, unresolved1, inDefinedShape, paramDelegator);
/*       */     }
/*   439 */     if (!unresolved1.isAlive()) {
/*   440 */       throw new IllegalArgumentException("No enter advice defined by " + paramTypeDescription1);
/*       */     }
/*   442 */     for (MethodDescription.InDefinedShape inDefinedShape : paramTypeDescription2.getDeclaredMethods()) {
/*   443 */       unresolved2 = locate((Class)OnMethodExit.class, INLINE_EXIT, unresolved2, inDefinedShape, paramDelegator);
/*       */     }
/*   445 */     if (!unresolved2.isAlive()) {
/*   446 */       throw new IllegalArgumentException("No exit advice defined by " + paramTypeDescription2);
/*       */     }
/*       */     try {
/*   449 */       return new Advice(unresolved1.asMethodEnter(paramList, unresolved1.isBinary() ? 
/*   450 */             OpenedClassReader.of(paramClassFileLocator.locate(paramTypeDescription1.getName()).resolve()) : UNDEFINED, unresolved2, paramFactory), unresolved2
/*   451 */           .asMethodExit(paramList, unresolved2.isBinary() ? 
/*   452 */             OpenedClassReader.of(paramClassFileLocator.locate(paramTypeDescription2.getName()).resolve()) : UNDEFINED, unresolved1, paramFactory));
/*       */     }
/*   454 */     catch (IOException iOException) {
/*   455 */       throw new IllegalStateException("Error reading class file of " + paramTypeDescription1 + " or " + paramTypeDescription2, iOException);
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private static Dispatcher.Unresolved locate(Class<? extends Annotation> paramClass, MethodDescription.InDefinedShape paramInDefinedShape1, Dispatcher.Unresolved paramUnresolved, MethodDescription.InDefinedShape paramInDefinedShape2, Delegator paramDelegator) {
/*       */     AnnotationDescription.Loadable loadable;
/*   475 */     if ((loadable = paramInDefinedShape2.getDeclaredAnnotations().ofType(paramClass)) == null)
/*   476 */       return paramUnresolved; 
/*   477 */     if (paramUnresolved.isAlive())
/*   478 */       throw new IllegalStateException("Duplicate advice for " + paramUnresolved + " and " + paramInDefinedShape2); 
/*   479 */     if (!paramInDefinedShape2.isStatic()) {
/*   480 */       throw new IllegalStateException("Advice for " + paramInDefinedShape2 + " is not static");
/*       */     }
/*   482 */     return (Dispatcher.Unresolved)(((Boolean)loadable.getValue(paramInDefinedShape1).resolve(Boolean.class)).booleanValue() ? new Dispatcher.Inlining(paramInDefinedShape2) : new Dispatcher.Delegating(paramInDefinedShape2, paramDelegator));
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static WithCustomMapping withCustomMapping() {
/*   495 */     return new WithCustomMapping();
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/*   505 */     return (new AsmVisitorWrapper.ForDeclaredMethods()).invokable(paramElementMatcher, new AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper[] { this });
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public MethodVisitor wrap(TypeDescription paramTypeDescription, MethodDescription paramMethodDescription, MethodVisitor paramMethodVisitor, Implementation.Context paramContext, TypePool paramTypePool, int paramInt1, int paramInt2) {
/*   518 */     return (paramMethodDescription.isAbstract() || paramMethodDescription.isNative()) ? paramMethodVisitor : 
/*       */       
/*   520 */       doWrap(paramTypeDescription, paramMethodDescription, paramMethodVisitor, paramContext, paramInt1, paramInt2);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   protected MethodVisitor doWrap(TypeDescription paramTypeDescription, MethodDescription paramMethodDescription, MethodVisitor paramMethodVisitor, Implementation.Context paramContext, int paramInt1, int paramInt2) {
/*       */     LineNumberPrependingMethodVisitor lineNumberPrependingMethodVisitor;
/*   540 */     if (this.methodEnter.isPrependLineNumber()) {
/*   541 */       lineNumberPrependingMethodVisitor = new LineNumberPrependingMethodVisitor(paramMethodVisitor);
/*       */     }
/*   543 */     if (!this.methodExit.isAlive()) {
/*   544 */       return (MethodVisitor)new AdviceVisitor.WithoutExitAdvice((MethodVisitor)lineNumberPrependingMethodVisitor, paramContext, this.assigner, this.exceptionHandler
/*       */ 
/*       */           
/*   547 */           .resolve(paramMethodDescription, paramTypeDescription), paramTypeDescription, paramMethodDescription, this.methodEnter, paramInt1, paramInt2);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*   553 */     if (this.methodExit.getThrowable().represents(NoExceptionHandler.class)) {
/*   554 */       return (MethodVisitor)new AdviceVisitor.WithExitAdvice.WithoutExceptionHandling((MethodVisitor)lineNumberPrependingMethodVisitor, paramContext, this.assigner, this.exceptionHandler
/*       */ 
/*       */           
/*   557 */           .resolve(paramMethodDescription, paramTypeDescription), paramTypeDescription, paramMethodDescription, this.methodEnter, this.methodExit, paramInt1, paramInt2);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*   564 */     if (paramMethodDescription.isConstructor()) {
/*   565 */       throw new IllegalStateException("Cannot catch exception during constructor call for " + paramMethodDescription);
/*       */     }
/*   567 */     return (MethodVisitor)new AdviceVisitor.WithExitAdvice.WithExceptionHandling((MethodVisitor)lineNumberPrependingMethodVisitor, paramContext, this.assigner, this.exceptionHandler
/*       */ 
/*       */         
/*   570 */         .resolve(paramMethodDescription, paramTypeDescription), paramTypeDescription, paramMethodDescription, this.methodEnter, this.methodExit, paramInt1, paramInt2, this.methodExit
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*   577 */         .getThrowable());
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/*   585 */     return this.delegate.prepare(paramInstrumentedType);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/*   592 */     return new Appender(this, paramTarget, this.delegate.appender(paramTarget));
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public Advice withAssigner(Assigner paramAssigner) {
/*   602 */     return new Advice(this.methodEnter, this.methodExit, paramAssigner, this.exceptionHandler, this.delegate);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public Advice withExceptionPrinting() {
/*   611 */     return withExceptionHandler(ExceptionHandler.Default.PRINTING);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public Advice withExceptionHandler(StackManipulation paramStackManipulation) {
/*   622 */     return withExceptionHandler(new ExceptionHandler.Simple(paramStackManipulation));
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public Advice withExceptionHandler(ExceptionHandler paramExceptionHandler) {
/*   633 */     return new Advice(this.methodEnter, this.methodExit, this.assigner, paramExceptionHandler, this.delegate);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public Implementation wrap(Implementation paramImplementation) {
/*   643 */     return new Advice(this.methodEnter, this.methodExit, this.assigner, this.exceptionHandler, paramImplementation);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public boolean equals(@MaybeNull Object paramObject) {
/*       */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.methodEnter.equals(((Advice)paramObject).methodEnter) ? false : (!this.methodExit.equals(((Advice)paramObject).methodExit) ? false : (!this.assigner.equals(((Advice)paramObject).assigner) ? false : (!this.exceptionHandler.equals(((Advice)paramObject).exceptionHandler) ? false : (!!this.delegate.equals(((Advice)paramObject).delegate))))))));
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public int hashCode() {
/*       */     return ((((getClass().hashCode() * 31 + this.methodEnter.hashCode()) * 31 + this.methodExit.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.exceptionHandler.hashCode()) * 31 + this.delegate.hashCode();
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface Factory<T extends Annotation>
/*       */   {
/*       */     Class<T> getAnnotationType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     Advice.OffsetMapping make(ParameterDescription.InDefinedShape param1InDefinedShape, AnnotationDescription.Loadable<T> param1Loadable, AdviceType param1AdviceType);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum AdviceType
/*       */     {
/*  1447 */       DELEGATION(true),
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  1452 */       INLINING(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean delegation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AdviceType(boolean param3Boolean) {
/*  1465 */         this.delegation = param3Boolean;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isDelegation() {
/*  1474 */         return this.delegation;
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Simple<T extends Annotation>
/*       */       implements Factory<T>
/*       */     {
/*       */       private final Class<T> annotationType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Advice.OffsetMapping offsetMapping;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Simple(Class<T> param3Class, Advice.OffsetMapping param3OffsetMapping) {
/*  1503 */         this.annotationType = param3Class;
/*  1504 */         this.offsetMapping = param3OffsetMapping;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Class<T> getAnnotationType() {
/*  1511 */         return this.annotationType;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  1518 */         return this.offsetMapping;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param3Object) {
/*       */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationType.equals(((Simple)param3Object).annotationType) ? false : (!!this.offsetMapping.equals(((Simple)param3Object).offsetMapping)))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.offsetMapping.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Illegal<T extends Annotation>
/*       */       implements Factory<T>
/*       */     {
/*       */       private final Class<T> annotationType;
/*       */ 
/*       */       
/*       */       public Illegal(Class<T> param3Class) {
/*  1541 */         this.annotationType = param3Class;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Class<T> getAnnotationType() {
/*  1548 */         return this.annotationType;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType)
/*       */       {
/*  1555 */         throw new IllegalStateException("Usage of " + this.annotationType + " is not allowed on " + param3InDefinedShape); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.annotationType.equals(((Illegal)param3Object).annotationType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.annotationType.hashCode(); } } } public static interface OffsetMapping { Target resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Advice.ArgumentHandler param1ArgumentHandler, Sort param1Sort); public static interface Target { StackManipulation resolveRead(); StackManipulation resolveWrite(); StackManipulation resolveIncrement(int param2Int); public static abstract class AbstractReadOnlyAdapter implements Target { public StackManipulation resolveWrite() { throw new IllegalStateException("Cannot write to read-only value"); } public StackManipulation resolveIncrement(int param3Int) { throw new IllegalStateException("Cannot write to read-only value"); } } @Enhance public static abstract class ForDefaultValue implements Target { protected final TypeDefinition typeDefinition; protected final StackManipulation readAssignment; protected ForDefaultValue(TypeDefinition param3TypeDefinition, StackManipulation param3StackManipulation) { this.typeDefinition = param3TypeDefinition; this.readAssignment = param3StackManipulation; } public StackManipulation resolveRead() { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { DefaultValue.of(this.typeDefinition), this.readAssignment }); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typeDefinition.equals(((ForDefaultValue)param3Object).typeDefinition) ? false : (!!this.readAssignment.equals(((ForDefaultValue)param3Object).readAssignment))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.typeDefinition.hashCode()) * 31 + this.readAssignment.hashCode(); } public static class ReadOnly extends ForDefaultValue { public ReadOnly(TypeDefinition param4TypeDefinition) { this(param4TypeDefinition, (StackManipulation)StackManipulation.Trivial.INSTANCE); } public ReadOnly(TypeDefinition param4TypeDefinition, StackManipulation param4StackManipulation) { super(param4TypeDefinition, param4StackManipulation); } public StackManipulation resolveWrite() { throw new IllegalStateException("Cannot write to read-only default value"); } public StackManipulation resolveIncrement(int param4Int) { throw new IllegalStateException("Cannot write to read-only default value"); } } public static class ReadWrite extends ForDefaultValue { public ReadWrite(TypeDefinition param4TypeDefinition) { this(param4TypeDefinition, (StackManipulation)StackManipulation.Trivial.INSTANCE); } public ReadWrite(TypeDefinition param4TypeDefinition, StackManipulation param4StackManipulation) { super(param4TypeDefinition, param4StackManipulation); } public StackManipulation resolveWrite() { return Removal.of(this.typeDefinition); } public StackManipulation resolveIncrement(int param4Int) { return (StackManipulation)StackManipulation.Trivial.INSTANCE; } } } @Enhance public static abstract class ForVariable implements Target { protected final TypeDefinition typeDefinition; protected final int offset; protected final StackManipulation readAssignment; protected ForVariable(TypeDefinition param3TypeDefinition, int param3Int, StackManipulation param3StackManipulation) { this.typeDefinition = param3TypeDefinition; this.offset = param3Int; this.readAssignment = param3StackManipulation; } public StackManipulation resolveRead() { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.of(this.typeDefinition).loadFrom(this.offset), this.readAssignment }); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.offset != ((ForVariable)param3Object).offset) ? false : (!this.typeDefinition.equals(((ForVariable)param3Object).typeDefinition) ? false : (!!this.readAssignment.equals(((ForVariable)param3Object).readAssignment)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.typeDefinition.hashCode()) * 31 + this.offset) * 31 + this.readAssignment.hashCode(); } public static class ReadOnly extends ForVariable { public ReadOnly(TypeDefinition param4TypeDefinition, int param4Int) { this(param4TypeDefinition, param4Int, (StackManipulation)StackManipulation.Trivial.INSTANCE); } public ReadOnly(TypeDefinition param4TypeDefinition, int param4Int, StackManipulation param4StackManipulation) { super(param4TypeDefinition, param4Int, param4StackManipulation); } public StackManipulation resolveWrite() { throw new IllegalStateException("Cannot write to read-only parameter " + this.typeDefinition + " at " + this.offset); } public StackManipulation resolveIncrement(int param4Int) { throw new IllegalStateException("Cannot write to read-only variable " + this.typeDefinition + " at " + this.offset); } } @Enhance public static class ReadWrite extends ForVariable { private final StackManipulation writeAssignment; public ReadWrite(TypeDefinition param4TypeDefinition, int param4Int) { this(param4TypeDefinition, param4Int, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE); } public ReadWrite(TypeDefinition param4TypeDefinition, int param4Int, StackManipulation param4StackManipulation1, StackManipulation param4StackManipulation2) { super(param4TypeDefinition, param4Int, param4StackManipulation1); this.writeAssignment = param4StackManipulation2; } public StackManipulation resolveWrite() { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.writeAssignment, MethodVariableAccess.of(this.typeDefinition).storeAt(this.offset) }); } public StackManipulation resolveIncrement(int param4Int) { if (this.typeDefinition.represents(int.class)) return MethodVariableAccess.of(this.typeDefinition).increment(this.offset, param4Int);  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { resolveRead(), IntegerConstant.forValue(1), (StackManipulation)Addition.INTEGER, resolveWrite() }); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.writeAssignment.equals(((ReadWrite)param4Object).writeAssignment))))); } public int hashCode() { return super.hashCode() * 31 + this.writeAssignment.hashCode(); } } } @Enhance public static abstract class ForArray implements Target { protected final TypeDescription.Generic target; protected final List<? extends StackManipulation> valueReads; protected ForArray(TypeDescription.Generic param3Generic, List<? extends StackManipulation> param3List) { this.target = param3Generic; this.valueReads = param3List; } public StackManipulation resolveRead() { return ArrayFactory.forType(this.target).withValues(this.valueReads); } public StackManipulation resolveIncrement(int param3Int) { throw new IllegalStateException("Cannot increment read-only array value"); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.target.equals(((ForArray)param3Object).target) ? false : (!!this.valueReads.equals(((ForArray)param3Object).valueReads))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.valueReads.hashCode(); } public static class ReadOnly extends ForArray { public ReadOnly(TypeDescription.Generic param4Generic, List<? extends StackManipulation> param4List) { super(param4Generic, param4List); } public StackManipulation resolveWrite() { throw new IllegalStateException("Cannot write to read-only array value"); } } @Enhance public static class ReadWrite extends ForArray { private final List<? extends StackManipulation> valueWrites; public ReadWrite(TypeDescription.Generic param4Generic, List<? extends StackManipulation> param4List1, List<? extends StackManipulation> param4List2) { super(param4Generic, param4List1); this.valueWrites = param4List2; } public StackManipulation resolveWrite() { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { ArrayAccess.of((TypeDefinition)this.target).forEach(this.valueWrites), (StackManipulation)Removal.SINGLE }); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.valueWrites.equals(((ReadWrite)param4Object).valueWrites))))); } public int hashCode() { return super.hashCode() * 31 + this.valueWrites.hashCode(); } } } @Enhance public static abstract class ForField implements Target { protected final FieldDescription fieldDescription; protected final StackManipulation readAssignment; protected ForField(FieldDescription param3FieldDescription, StackManipulation param3StackManipulation) { this.fieldDescription = param3FieldDescription; this.readAssignment = param3StackManipulation; } public StackManipulation resolveRead() { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read(), this.readAssignment }); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fieldDescription.equals(((ForField)param3Object).fieldDescription) ? false : (!!this.readAssignment.equals(((ForField)param3Object).readAssignment))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.readAssignment.hashCode(); } public static class ReadOnly extends ForField { public ReadOnly(FieldDescription param4FieldDescription) { this(param4FieldDescription, (StackManipulation)StackManipulation.Trivial.INSTANCE); } public ReadOnly(FieldDescription param4FieldDescription, StackManipulation param4StackManipulation) { super(param4FieldDescription, param4StackManipulation); } public StackManipulation resolveWrite() { throw new IllegalStateException("Cannot write to read-only field value"); } public StackManipulation resolveIncrement(int param4Int) { throw new IllegalStateException("Cannot write to read-only field value"); } } @Enhance public static class WriteOnly implements Advice.OffsetMapping.Target { private final FieldDescription fieldDescription; private final StackManipulation writeAssignment; protected WriteOnly(FieldDescription param4FieldDescription, StackManipulation param4StackManipulation) { this.fieldDescription = param4FieldDescription; this.writeAssignment = param4StackManipulation; } public StackManipulation resolveRead() { throw new IllegalStateException("Cannot read write-only field value"); } public StackManipulation resolveWrite() { StackManipulation.Compound compound; if (this.fieldDescription.isStatic()) { StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE; } else { compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), Duplication.SINGLE.flipOver((TypeDefinition)this.fieldDescription.getType()), (StackManipulation)Removal.SINGLE }); }  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.writeAssignment, (StackManipulation)compound, FieldAccess.forField(this.fieldDescription).write() }); } public StackManipulation resolveIncrement(int param4Int) { throw new IllegalStateException("Cannot increment write-only field value"); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.fieldDescription.equals(((WriteOnly)param4Object).fieldDescription) ? false : (!!this.writeAssignment.equals(((WriteOnly)param4Object).writeAssignment))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.writeAssignment.hashCode(); } } @Enhance public static class ReadWrite extends ForField { private final StackManipulation writeAssignment; public ReadWrite(FieldDescription param4FieldDescription) { this(param4FieldDescription, (StackManipulation)StackManipulation.Trivial.INSTANCE, (StackManipulation)StackManipulation.Trivial.INSTANCE); } public ReadWrite(FieldDescription param4FieldDescription, StackManipulation param4StackManipulation1, StackManipulation param4StackManipulation2) { super(param4FieldDescription, param4StackManipulation1); this.writeAssignment = param4StackManipulation2; } public StackManipulation resolveWrite() { StackManipulation.Compound compound; if (this.fieldDescription.isStatic()) { StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE; } else { compound = new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), Duplication.SINGLE.flipOver((TypeDefinition)this.fieldDescription.getType()), (StackManipulation)Removal.SINGLE }); }  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.writeAssignment, (StackManipulation)compound, FieldAccess.forField(this.fieldDescription).write() }); } public StackManipulation resolveIncrement(int param4Int) { return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { resolveRead(), IntegerConstant.forValue(param4Int), (StackManipulation)Addition.INTEGER, resolveWrite() }); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.writeAssignment.equals(((ReadWrite)param4Object).writeAssignment))))); } public int hashCode() { return super.hashCode() * 31 + this.writeAssignment.hashCode(); } } } @Enhance public static class ForStackManipulation implements Target { private final StackManipulation stackManipulation; public ForStackManipulation(StackManipulation param3StackManipulation) { this.stackManipulation = param3StackManipulation; } public static Advice.OffsetMapping.Target of(MethodDescription.InDefinedShape param3InDefinedShape) { return new ForStackManipulation((StackManipulation)MethodConstant.of(param3InDefinedShape)); } public static Advice.OffsetMapping.Target of(TypeDescription param3TypeDescription) { return new ForStackManipulation(ClassConstant.of(param3TypeDescription)); } public static Advice.OffsetMapping.Target of(Object param3Object) { if (param3Object == null) return new ForStackManipulation((StackManipulation)NullConstant.INSTANCE);  if (param3Object instanceof Boolean) return new ForStackManipulation(IntegerConstant.forValue(((Boolean)param3Object).booleanValue()));  if (param3Object instanceof Byte) return new ForStackManipulation(IntegerConstant.forValue(((Byte)param3Object).byteValue()));  if (param3Object instanceof Short) return new ForStackManipulation(IntegerConstant.forValue(((Short)param3Object).shortValue()));  if (param3Object instanceof Character) return new ForStackManipulation(IntegerConstant.forValue(((Character)param3Object).charValue()));  if (param3Object instanceof Integer) return new ForStackManipulation(IntegerConstant.forValue(((Integer)param3Object).intValue()));  if (param3Object instanceof Long) return new ForStackManipulation(LongConstant.forValue(((Long)param3Object).longValue()));  if (param3Object instanceof Float) return new ForStackManipulation(FloatConstant.forValue(((Float)param3Object).floatValue()));  if (param3Object instanceof Double) return new ForStackManipulation(DoubleConstant.forValue(((Double)param3Object).doubleValue()));  if (param3Object instanceof String) return new ForStackManipulation((StackManipulation)new TextConstant((String)param3Object));  if (param3Object instanceof Enum) return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)param3Object)));  if (param3Object instanceof EnumerationDescription) return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription)param3Object));  if (param3Object instanceof Class) return new ForStackManipulation(ClassConstant.of(TypeDescription.ForLoadedType.of((Class)param3Object)));  if (param3Object instanceof TypeDescription) return new ForStackManipulation(ClassConstant.of((TypeDescription)param3Object));  if (JavaType.METHOD_HANDLE.isInstance(param3Object)) return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.ofLoaded(param3Object)));  if (JavaType.METHOD_TYPE.isInstance(param3Object)) return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodType.ofLoaded(param3Object)));  if (param3Object instanceof JavaConstant) return new ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)param3Object));  throw new IllegalArgumentException("Not a constant value: " + param3Object); } public StackManipulation resolveRead() { return this.stackManipulation; } public StackManipulation resolveWrite() { throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation); } public StackManipulation resolveIncrement(int param3Int) { throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.stackManipulation.equals(((ForStackManipulation)param3Object).stackManipulation)))); } public int hashCode() { return getClass().hashCode() * 31 + this.stackManipulation.hashCode(); } @Enhance public static class Writable implements Advice.OffsetMapping.Target { private final StackManipulation read; private final StackManipulation write; public Writable(StackManipulation param4StackManipulation1, StackManipulation param4StackManipulation2) { this.read = param4StackManipulation1; this.write = param4StackManipulation2; } public StackManipulation resolveRead() { return this.read; } public StackManipulation resolveWrite() { return this.write; } public StackManipulation resolveIncrement(int param4Int) { throw new IllegalStateException("Cannot increment mutable constant value: " + this.write); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.read.equals(((Writable)param4Object).read) ? false : (!!this.write.equals(((Writable)param4Object).write))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.read.hashCode()) * 31 + this.write.hashCode(); } } } } public static interface Factory<T extends Annotation> { Class<T> getAnnotationType(); Advice.OffsetMapping make(ParameterDescription.InDefinedShape param2InDefinedShape, AnnotationDescription.Loadable<T> param2Loadable, AdviceType param2AdviceType); public enum AdviceType { DELEGATION(true), INLINING(false); private final boolean delegation; AdviceType(boolean param3Boolean) { this.delegation = param3Boolean; } public final boolean isDelegation() { return this.delegation; } } @Enhance public static class Simple<T extends Annotation> implements Factory<T> { private final Class<T> annotationType; private final Advice.OffsetMapping offsetMapping; public Simple(Class<T> param3Class, Advice.OffsetMapping param3OffsetMapping) { this.annotationType = param3Class; this.offsetMapping = param3OffsetMapping; } public Class<T> getAnnotationType() { return this.annotationType; } public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) { return this.offsetMapping; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationType.equals(((Simple)param3Object).annotationType) ? false : (!!this.offsetMapping.equals(((Simple)param3Object).offsetMapping))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.offsetMapping.hashCode(); } } @Enhance public static class Illegal<T extends Annotation> implements Factory<T> { private final Class<T> annotationType; public Illegal(Class<T> param3Class) { this.annotationType = param3Class; } public Class<T> getAnnotationType() { return this.annotationType; } public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) { throw new IllegalStateException("Usage of " + this.annotationType + " is not allowed on " + param3InDefinedShape); }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.annotationType.equals(((Illegal)param3Object).annotationType))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.annotationType.hashCode();
/*       */         } } }
/*       */ 
/*       */     
/*       */     public enum Sort {
/*  1568 */       ENTER
/*       */       {
/*       */         public final boolean isPremature(MethodDescription param3MethodDescription) {
/*  1571 */           return param3MethodDescription.isConstructor();
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  1578 */       EXIT
/*       */       {
/*       */         public final boolean isPremature(MethodDescription param3MethodDescription) {
/*  1581 */           return false;
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public abstract boolean isPremature(MethodDescription param2MethodDescription);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static abstract class ForArgument
/*       */       implements OffsetMapping
/*       */     {
/*       */       protected final TypeDescription.Generic target;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final boolean readOnly;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForArgument(TypeDescription.Generic param2Generic, boolean param2Boolean, Assigner.Typing param2Typing) {
/*  1624 */         this.target = param2Generic;
/*  1625 */         this.readOnly = param2Boolean;
/*  1626 */         this.typing = param2Typing;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  1637 */         ParameterDescription parameterDescription = resolve(param2MethodDescription);
/*       */         StackManipulation stackManipulation1;
/*  1639 */         if (!(stackManipulation1 = param2Assigner.assign(parameterDescription.getType(), this.target, this.typing)).isValid())
/*  1640 */           throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.target); 
/*  1641 */         if (this.readOnly) {
/*  1642 */           return new Advice.OffsetMapping.Target.ForVariable.ReadOnly((TypeDefinition)parameterDescription.getType(), param2ArgumentHandler.argument(parameterDescription.getOffset()), stackManipulation1);
/*       */         }
/*       */         StackManipulation stackManipulation2;
/*  1645 */         if (!(stackManipulation2 = param2Assigner.assign(this.target, parameterDescription.getType(), this.typing)).isValid()) {
/*  1646 */           throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.target);
/*       */         }
/*  1648 */         return new Advice.OffsetMapping.Target.ForVariable.ReadWrite((TypeDefinition)parameterDescription.getType(), param2ArgumentHandler.argument(parameterDescription.getOffset()), stackManipulation1, stackManipulation2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract ParameterDescription resolve(MethodDescription param2MethodDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForArgument)param2Object).readOnly) ? false : (!this.typing.equals(((ForArgument)param2Object).typing) ? false : (!!this.target.equals(((ForArgument)param2Object).target))))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Unresolved
/*       */         extends ForArgument
/*       */       {
/*       */         private final int index;
/*       */ 
/*       */         
/*       */         private final boolean optional;
/*       */ 
/*       */ 
/*       */         
/*       */         protected Unresolved(TypeDescription.Generic param3Generic, AnnotationDescription.Loadable<Advice.Argument> param3Loadable) {
/*  1683 */           this(param3Generic, ((Boolean)param3Loadable.getValue(Factory.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param3Loadable
/*  1684 */               .getValue(Factory.b()).load(Advice.Argument.class.getClassLoader()).resolve(Assigner.Typing.class), ((Integer)param3Loadable
/*  1685 */               .getValue(Factory.c()).resolve(Integer.class)).intValue(), ((Boolean)param3Loadable
/*  1686 */               .getValue(Factory.d()).resolve(Boolean.class)).booleanValue());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Unresolved(ParameterDescription param3ParameterDescription) {
/*  1695 */           this(param3ParameterDescription.getType(), true, Assigner.Typing.STATIC, param3ParameterDescription.getIndex());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Unresolved(TypeDescription.Generic param3Generic, boolean param3Boolean, Assigner.Typing param3Typing, int param3Int) {
/*  1707 */           this(param3Generic, param3Boolean, param3Typing, param3Int, false);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Unresolved(TypeDescription.Generic param3Generic, boolean param3Boolean1, Assigner.Typing param3Typing, int param3Int, boolean param3Boolean2) {
/*  1720 */           super(param3Generic, param3Boolean1, param3Typing);
/*  1721 */           this.index = param3Int;
/*  1722 */           this.optional = param3Boolean2;
/*       */         }
/*       */ 
/*       */         
/*       */         protected ParameterDescription resolve(MethodDescription param3MethodDescription) {
/*       */           ParameterList parameterList;
/*  1728 */           if ((parameterList = param3MethodDescription.getParameters()).size() <= this.index) {
/*  1729 */             throw new IllegalStateException(param3MethodDescription + " does not define an index " + this.index);
/*       */           }
/*  1731 */           return (ParameterDescription)parameterList.get(this.index);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping.Target resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Advice.ArgumentHandler param3ArgumentHandler, Advice.OffsetMapping.Sort param3Sort) {
/*  1743 */           if (this.optional && param3MethodDescription.getParameters().size() <= this.index) {
/*  1744 */             return (Advice.OffsetMapping.Target)(this.readOnly ? new Advice.OffsetMapping.Target.ForDefaultValue.ReadOnly((TypeDefinition)this.target) : new Advice.OffsetMapping.Target.ForDefaultValue.ReadWrite((TypeDefinition)this.target));
/*       */           }
/*       */ 
/*       */           
/*  1748 */           return super.resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ArgumentHandler, param3Sort);
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((Unresolved)param3Object).index) ? false : (!(this.optional != ((Unresolved)param3Object).optional))))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return (super.hashCode() * 31 + this.index) * 31 + this.optional;
/*       */         }
/*       */         
/*  1759 */         protected enum Factory implements Advice.OffsetMapping.Factory<Advice.Argument> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape ARGUMENT_OPTIONAL;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape ARGUMENT_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape ARGUMENT_READ_ONLY;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape ARGUMENT_VALUE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           static {
/*       */             MethodList methodList;
/*  1786 */             ARGUMENT_VALUE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.Argument.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/*  1787 */             ARGUMENT_READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  1788 */             ARGUMENT_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*  1789 */             ARGUMENT_OPTIONAL = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("optional"))).getOnly();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.Argument> getAnnotationType() {
/*  1796 */             return Advice.Argument.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param4InDefinedShape, AnnotationDescription.Loadable<Advice.Argument> param4Loadable, Advice.OffsetMapping.Factory.AdviceType param4AdviceType) {
/*  1805 */             if (param4AdviceType.isDelegation() && !((Boolean)param4Loadable.getValue(ARGUMENT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
/*  1806 */               throw new IllegalStateException("Cannot define writable field access for " + param4InDefinedShape + " when using delegation");
/*       */             }
/*  1808 */             return new Advice.OffsetMapping.ForArgument.Unresolved(param4InDefinedShape.getType(), param4Loadable);
/*       */           } }
/*       */       
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Resolved
/*       */         extends ForArgument
/*       */       {
/*       */         private final ParameterDescription parameterDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Resolved(TypeDescription.Generic param3Generic, boolean param3Boolean, Assigner.Typing param3Typing, ParameterDescription param3ParameterDescription) {
/*  1834 */           super(param3Generic, param3Boolean, param3Typing);
/*  1835 */           this.parameterDescription = param3ParameterDescription;
/*       */         }
/*       */ 
/*       */         
/*       */         protected ParameterDescription resolve(MethodDescription param3MethodDescription) {
/*  1840 */           if (!this.parameterDescription.getDeclaringMethod().equals(param3MethodDescription)) {
/*  1841 */             throw new IllegalStateException(this.parameterDescription + " is not a parameter of " + param3MethodDescription);
/*       */           }
/*  1843 */           return this.parameterDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.parameterDescription.equals(((Resolved)param3Object).parameterDescription)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.parameterDescription.hashCode();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class Factory<T extends Annotation>
/*       */           implements Advice.OffsetMapping.Factory<T>
/*       */         {
/*       */           private final Class<T> annotationType;
/*       */ 
/*       */           
/*       */           private final ParameterDescription parameterDescription;
/*       */ 
/*       */           
/*       */           private final boolean readOnly;
/*       */ 
/*       */           
/*       */           private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */           
/*       */           public Factory(Class<T> param4Class, ParameterDescription param4ParameterDescription) {
/*  1881 */             this(param4Class, param4ParameterDescription, true, Assigner.Typing.STATIC);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Factory(Class<T> param4Class, ParameterDescription param4ParameterDescription, boolean param4Boolean, Assigner.Typing param4Typing) {
/*  1893 */             this.annotationType = param4Class;
/*  1894 */             this.parameterDescription = param4ParameterDescription;
/*  1895 */             this.readOnly = param4Boolean;
/*  1896 */             this.typing = param4Typing;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Class<T> getAnnotationType() {
/*  1903 */             return this.annotationType;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param4InDefinedShape, AnnotationDescription.Loadable<T> param4Loadable, Advice.OffsetMapping.Factory.AdviceType param4AdviceType) {
/*  1912 */             return new Advice.OffsetMapping.ForArgument.Resolved(param4InDefinedShape.getType(), this.readOnly, this.typing, this.parameterDescription);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.readOnly != ((Factory)param4Object).readOnly) ? false : (!this.typing.equals(((Factory)param4Object).typing) ? false : (!this.annotationType.equals(((Factory)param4Object).annotationType) ? false : (!!this.parameterDescription.equals(((Factory)param4Object).parameterDescription)))))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (((getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.parameterDescription.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForThisReference
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */       
/*       */       private final boolean readOnly;
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */       
/*       */       private final boolean optional;
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForThisReference(TypeDescription.Generic param2Generic, AnnotationDescription.Loadable<Advice.This> param2Loadable) {
/*  1951 */         this(param2Generic, ((Boolean)param2Loadable
/*  1952 */             .getValue(Factory.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param2Loadable
/*  1953 */             .getValue(Factory.b()).load(Advice.This.class.getClassLoader()).resolve(Assigner.Typing.class), ((Boolean)param2Loadable
/*  1954 */             .getValue(Factory.c()).resolve(Boolean.class)).booleanValue());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForThisReference(TypeDescription.Generic param2Generic, boolean param2Boolean1, Assigner.Typing param2Typing, boolean param2Boolean2) {
/*  1966 */         this.target = param2Generic;
/*  1967 */         this.readOnly = param2Boolean1;
/*  1968 */         this.typing = param2Typing;
/*  1969 */         this.optional = param2Boolean2;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  1980 */         if (param2MethodDescription.isStatic() || param2Sort.isPremature(param2MethodDescription)) {
/*  1981 */           if (this.optional) {
/*  1982 */             return (Advice.OffsetMapping.Target)(this.readOnly ? new Advice.OffsetMapping.Target.ForDefaultValue.ReadOnly((TypeDefinition)param2TypeDescription) : new Advice.OffsetMapping.Target.ForDefaultValue.ReadWrite((TypeDefinition)param2TypeDescription));
/*       */           }
/*       */ 
/*       */           
/*  1986 */           throw new IllegalStateException("Cannot map this reference for static method or constructor start: " + param2MethodDescription);
/*       */         } 
/*       */         
/*       */         StackManipulation stackManipulation1;
/*  1990 */         if (!(stackManipulation1 = param2Assigner.assign(param2TypeDescription.asGenericType(), this.target, this.typing)).isValid())
/*  1991 */           throw new IllegalStateException("Cannot assign " + param2TypeDescription + " to " + this.target); 
/*  1992 */         if (this.readOnly) {
/*  1993 */           return new Advice.OffsetMapping.Target.ForVariable.ReadOnly((TypeDefinition)param2TypeDescription.asGenericType(), param2ArgumentHandler.argument(0), stackManipulation1);
/*       */         }
/*       */         StackManipulation stackManipulation2;
/*  1996 */         if (!(stackManipulation2 = param2Assigner.assign(this.target, param2TypeDescription.asGenericType(), this.typing)).isValid()) {
/*  1997 */           throw new IllegalStateException("Cannot assign " + this.target + " to " + param2TypeDescription);
/*       */         }
/*  1999 */         return new Advice.OffsetMapping.Target.ForVariable.ReadWrite((TypeDefinition)param2TypeDescription.asGenericType(), param2ArgumentHandler.argument(0), stackManipulation1, stackManipulation2);
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForThisReference)param2Object).readOnly) ? false : ((this.optional != ((ForThisReference)param2Object).optional) ? false : (!this.typing.equals(((ForThisReference)param2Object).typing) ? false : (!!this.target.equals(((ForThisReference)param2Object).target)))))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode()) * 31 + this.optional;
/*       */       }
/*       */       
/*       */       protected enum Factory implements Advice.OffsetMapping.Factory<Advice.This> {
/*  2011 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape THIS_OPTIONAL;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape THIS_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape THIS_READ_ONLY;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         static {
/*       */           MethodList methodList;
/*  2033 */           THIS_READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.This.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  2034 */           THIS_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*  2035 */           THIS_OPTIONAL = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("optional"))).getOnly();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Class<Advice.This> getAnnotationType() {
/*  2042 */           return Advice.This.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.This> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  2051 */           if (param3AdviceType.isDelegation() && !((Boolean)param3Loadable.getValue(THIS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
/*  2052 */             throw new IllegalStateException("Cannot write to this reference for " + param3InDefinedShape + " in read-only context");
/*       */           }
/*  2054 */           return new Advice.OffsetMapping.ForThisReference(param3InDefinedShape.getType(), param3Loadable);
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForAllArguments
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean readOnly;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean nullIfEmpty;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForAllArguments(TypeDescription.Generic param2Generic, AnnotationDescription.Loadable<Advice.AllArguments> param2Loadable) {
/*  2094 */         this(param2Generic, ((Boolean)param2Loadable.getValue(Factory.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param2Loadable
/*  2095 */             .getValue(Factory.b()).load(Advice.AllArguments.class.getClassLoader()).resolve(Assigner.Typing.class), ((Boolean)param2Loadable
/*  2096 */             .getValue(Factory.c()).resolve(Boolean.class)).booleanValue());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAllArguments(TypeDescription.Generic param2Generic, boolean param2Boolean1, Assigner.Typing param2Typing, boolean param2Boolean2) {
/*  2109 */         this.target = param2Generic;
/*  2110 */         this.readOnly = param2Boolean1;
/*  2111 */         this.typing = param2Typing;
/*  2112 */         this.nullIfEmpty = param2Boolean2;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  2123 */         if (this.nullIfEmpty && param2MethodDescription.getParameters().isEmpty()) {
/*  2124 */           return (Advice.OffsetMapping.Target)(this.readOnly ? new Advice.OffsetMapping.Target.ForStackManipulation((StackManipulation)NullConstant.INSTANCE) : new Advice.OffsetMapping.Target.ForStackManipulation.Writable((StackManipulation)NullConstant.INSTANCE, (StackManipulation)Removal.SINGLE));
/*       */         }
/*       */ 
/*       */         
/*  2128 */         ArrayList<StackManipulation.Compound> arrayList1 = new ArrayList(param2MethodDescription.getParameters().size());
/*  2129 */         for (ParameterDescription parameterDescription : param2MethodDescription.getParameters()) {
/*       */           StackManipulation stackManipulation;
/*  2131 */           if (!(stackManipulation = param2Assigner.assign(parameterDescription.getType(), this.target, this.typing)).isValid()) {
/*  2132 */             throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.target);
/*       */           }
/*  2134 */           arrayList1.add(new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.of((TypeDefinition)parameterDescription.getType())
/*  2135 */                   .loadFrom(param2ArgumentHandler.argument(parameterDescription.getOffset())), stackManipulation }));
/*       */         } 
/*  2137 */         if (this.readOnly) {
/*  2138 */           return new Advice.OffsetMapping.Target.ForArray.ReadOnly(this.target, (List)arrayList1);
/*       */         }
/*  2140 */         ArrayList<StackManipulation.Compound> arrayList2 = new ArrayList(param2MethodDescription.getParameters().size());
/*  2141 */         for (ParameterDescription parameterDescription : param2MethodDescription.getParameters()) {
/*       */           StackManipulation stackManipulation;
/*  2143 */           if (!(stackManipulation = param2Assigner.assign(this.target, parameterDescription.getType(), this.typing)).isValid()) {
/*  2144 */             throw new IllegalStateException("Cannot assign " + this.target + " to " + parameterDescription);
/*       */           }
/*  2146 */           arrayList2.add(new StackManipulation.Compound(new StackManipulation[] { stackManipulation, MethodVariableAccess.of((TypeDefinition)parameterDescription.getType())
/*  2147 */                   .storeAt(param2ArgumentHandler.argument(parameterDescription.getOffset())) }));
/*       */         } 
/*  2149 */         return new Advice.OffsetMapping.Target.ForArray.ReadWrite(this.target, (List)arrayList1, (List)arrayList2);
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForAllArguments)param2Object).readOnly) ? false : ((this.nullIfEmpty != ((ForAllArguments)param2Object).nullIfEmpty) ? false : (!this.typing.equals(((ForAllArguments)param2Object).typing) ? false : (!!this.target.equals(((ForAllArguments)param2Object).target)))))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode()) * 31 + this.nullIfEmpty;
/*       */       }
/*       */       
/*       */       protected enum Factory implements Advice.OffsetMapping.Factory<Advice.AllArguments> {
/*  2161 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_NULL_IF_EMPTY;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_READ_ONLY;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         static {
/*       */           MethodList methodList;
/*  2183 */           ALL_ARGUMENTS_READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.AllArguments.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  2184 */           ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*  2185 */           ALL_ARGUMENTS_NULL_IF_EMPTY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("nullIfEmpty"))).getOnly();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Class<Advice.AllArguments> getAnnotationType() {
/*  2192 */           return Advice.AllArguments.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.AllArguments> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  2202 */           if (!param3InDefinedShape.getType().represents(Object.class) && !param3InDefinedShape.getType().isArray())
/*  2203 */             throw new IllegalStateException("Cannot use AllArguments annotation on a non-array type"); 
/*  2204 */           if (param3AdviceType.isDelegation() && !((Boolean)param3Loadable.getValue(ALL_ARGUMENTS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
/*  2205 */             throw new IllegalStateException("Cannot define writable field access for " + param3InDefinedShape);
/*       */           }
/*  2207 */           return new Advice.OffsetMapping.ForAllArguments(param3InDefinedShape.getType().represents(Object.class) ? 
/*  2208 */               TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class) : param3InDefinedShape
/*  2209 */               .getType().getComponentType(), param3Loadable);
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum ForInstrumentedType
/*       */       implements OffsetMapping
/*       */     {
/*  2223 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  2233 */         return Advice.OffsetMapping.Target.ForStackManipulation.of(param2TypeDescription);
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum ForInstrumentedMethod
/*       */       implements OffsetMapping
/*       */     {
/*  2245 */       METHOD
/*       */       {
/*       */         protected final boolean isRepresentable(MethodDescription param3MethodDescription) {
/*  2248 */           return param3MethodDescription.isMethod();
/*       */         }
/*       */ 
/*       */         
/*       */         protected final Advice.OffsetMapping.Target resolve(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  2253 */           return Advice.OffsetMapping.Target.ForStackManipulation.of(param3InDefinedShape);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2260 */       CONSTRUCTOR
/*       */       {
/*       */         protected final boolean isRepresentable(MethodDescription param3MethodDescription) {
/*  2263 */           return param3MethodDescription.isConstructor();
/*       */         }
/*       */ 
/*       */         
/*       */         protected final Advice.OffsetMapping.Target resolve(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  2268 */           return Advice.OffsetMapping.Target.ForStackManipulation.of(param3InDefinedShape);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2275 */       EXECUTABLE
/*       */       {
/*       */         protected final boolean isRepresentable(MethodDescription param3MethodDescription) {
/*  2278 */           return true;
/*       */         }
/*       */ 
/*       */         
/*       */         protected final Advice.OffsetMapping.Target resolve(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  2283 */           return Advice.OffsetMapping.Target.ForStackManipulation.of(param3InDefinedShape);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2291 */       METHOD_HANDLE
/*       */       {
/*       */         protected final boolean isRepresentable(MethodDescription param3MethodDescription) {
/*  2294 */           return true;
/*       */         }
/*       */ 
/*       */         
/*       */         protected final Advice.OffsetMapping.Target resolve(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  2299 */           return new Advice.OffsetMapping.Target.ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.of(param3InDefinedShape)));
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2306 */       METHOD_TYPE
/*       */       {
/*       */         protected final boolean isRepresentable(MethodDescription param3MethodDescription) {
/*  2309 */           return true;
/*       */         }
/*       */ 
/*       */         
/*       */         protected final Advice.OffsetMapping.Target resolve(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  2314 */           return new Advice.OffsetMapping.Target.ForStackManipulation((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodType.of((MethodDescription)param3InDefinedShape)));
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  2326 */         if (!isRepresentable(param2MethodDescription)) {
/*  2327 */           throw new IllegalStateException("Cannot represent " + param2MethodDescription + " as the specified constant");
/*       */         }
/*  2329 */         return resolve((MethodDescription.InDefinedShape)param2MethodDescription.asDefined());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract boolean isRepresentable(MethodDescription param2MethodDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract Advice.OffsetMapping.Target resolve(MethodDescription.InDefinedShape param2InDefinedShape);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static abstract class ForField
/*       */       implements OffsetMapping
/*       */     {
/*       */       private static final MethodDescription.InDefinedShape VALUE;
/*       */ 
/*       */ 
/*       */       
/*       */       private static final MethodDescription.InDefinedShape DECLARING_TYPE;
/*       */ 
/*       */ 
/*       */       
/*       */       private static final MethodDescription.InDefinedShape READ_ONLY;
/*       */ 
/*       */ 
/*       */       
/*       */       private static final MethodDescription.InDefinedShape TYPING;
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean readOnly;
/*       */ 
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */       
/*       */       static {
/*       */         MethodList methodList;
/*  2380 */         VALUE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.FieldValue.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/*  2381 */         DECLARING_TYPE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("declaringType"))).getOnly();
/*  2382 */         READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  2383 */         TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForField(TypeDescription.Generic param2Generic, boolean param2Boolean, Assigner.Typing param2Typing) {
/*  2409 */         this.target = param2Generic;
/*  2410 */         this.readOnly = param2Boolean;
/*  2411 */         this.typing = param2Typing;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*       */         FieldDescription fieldDescription;
/*  2423 */         if (!(fieldDescription = resolve(param2TypeDescription, param2MethodDescription)).isStatic() && param2MethodDescription.isStatic()) {
/*  2424 */           throw new IllegalStateException("Cannot read non-static field " + fieldDescription + " from static method " + param2MethodDescription);
/*       */         }
/*  2426 */         if (param2Sort.isPremature(param2MethodDescription) && !fieldDescription.isStatic()) {
/*  2427 */           if (this.readOnly) {
/*  2428 */             throw new IllegalStateException("Cannot assign " + fieldDescription + " to " + this.target);
/*       */           }
/*       */           StackManipulation stackManipulation;
/*  2431 */           if (!(stackManipulation = param2Assigner.assign(this.target, fieldDescription.getType(), this.typing)).isValid()) {
/*  2432 */             throw new IllegalStateException("Cannot assign " + this.target + " to " + fieldDescription);
/*       */           }
/*  2434 */           return new Advice.OffsetMapping.Target.ForField.WriteOnly((FieldDescription)fieldDescription.asDefined(), stackManipulation);
/*       */         } 
/*       */         
/*       */         StackManipulation stackManipulation1;
/*  2438 */         if (!(stackManipulation1 = param2Assigner.assign(fieldDescription.getType(), this.target, this.typing)).isValid())
/*  2439 */           throw new IllegalStateException("Cannot assign " + fieldDescription + " to " + this.target); 
/*  2440 */         if (this.readOnly) {
/*  2441 */           return new Advice.OffsetMapping.Target.ForField.ReadOnly(fieldDescription, stackManipulation1);
/*       */         }
/*       */         StackManipulation stackManipulation2;
/*  2444 */         if (!(stackManipulation2 = param2Assigner.assign(this.target, fieldDescription.getType(), this.typing)).isValid()) {
/*  2445 */           throw new IllegalStateException("Cannot assign " + this.target + " to " + fieldDescription);
/*       */         }
/*  2447 */         return new Advice.OffsetMapping.Target.ForField.ReadWrite((FieldDescription)fieldDescription.asDefined(), stackManipulation1, stackManipulation2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract FieldDescription resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForField)param2Object).readOnly) ? false : (!this.typing.equals(((ForField)param2Object).typing) ? false : (!!this.target.equals(((ForField)param2Object).target))))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static abstract class Unresolved
/*       */         extends ForField
/*       */       {
/*       */         protected static final String BEAN_PROPERTY = "";
/*       */ 
/*       */ 
/*       */         
/*       */         private final String name;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Unresolved(TypeDescription.Generic param3Generic, boolean param3Boolean, Assigner.Typing param3Typing, String param3String) {
/*  2486 */           super(param3Generic, param3Boolean, param3Typing);
/*  2487 */           this.name = param3String;
/*       */         }
/*       */ 
/*       */         
/*       */         protected FieldDescription resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  2492 */           FieldLocator fieldLocator = fieldLocator(param3TypeDescription);
/*       */           
/*       */           FieldLocator.Resolution resolution;
/*       */           
/*  2496 */           if (!(resolution = this.name.equals("") ? resolveAccessor(fieldLocator, param3MethodDescription) : fieldLocator.locate(this.name)).isResolved()) {
/*  2497 */             throw new IllegalStateException("Cannot locate field named " + this.name + " for " + param3TypeDescription);
/*       */           }
/*  2499 */           return resolution.getField();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static FieldLocator.Resolution resolveAccessor(FieldLocator param3FieldLocator, MethodDescription param3MethodDescription) {
/*       */           String str;
/*  2512 */           if (ElementMatchers.isSetter().matches(param3MethodDescription)) {
/*  2513 */             str = param3MethodDescription.getInternalName().substring(3);
/*  2514 */           } else if (ElementMatchers.isGetter().matches(str)) {
/*  2515 */             str = str.getInternalName().substring(str.getInternalName().startsWith("is") ? 2 : 3);
/*       */           } else {
/*  2517 */             return (FieldLocator.Resolution)FieldLocator.Resolution.Illegal.INSTANCE;
/*       */           } 
/*  2519 */           return param3FieldLocator.locate(Character.toLowerCase(str.charAt(0)) + str.substring(1));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract FieldLocator fieldLocator(TypeDescription param3TypeDescription);
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.name.equals(((Unresolved)param3Object).name)))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.name.hashCode();
/*       */         }
/*       */ 
/*       */         
/*       */         public static class WithImplicitType
/*       */           extends Unresolved
/*       */         {
/*       */           protected WithImplicitType(TypeDescription.Generic param4Generic, AnnotationDescription.Loadable<Advice.FieldValue> param4Loadable) {
/*  2542 */             this(param4Generic, ((Boolean)param4Loadable
/*  2543 */                 .getValue(Advice.OffsetMapping.ForField.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param4Loadable
/*  2544 */                 .getValue(Advice.OffsetMapping.ForField.b()).load(Assigner.Typing.class.getClassLoader()).resolve(Assigner.Typing.class), (String)param4Loadable
/*  2545 */                 .getValue(Advice.OffsetMapping.ForField.c()).resolve(String.class));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public WithImplicitType(TypeDescription.Generic param4Generic, boolean param4Boolean, Assigner.Typing param4Typing, String param4String) {
/*  2557 */             super(param4Generic, param4Boolean, param4Typing, param4String);
/*       */           }
/*       */ 
/*       */           
/*       */           protected FieldLocator fieldLocator(TypeDescription param4TypeDescription) {
/*  2562 */             return (FieldLocator)new FieldLocator.ForClassHierarchy(param4TypeDescription);
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class WithExplicitType
/*       */           extends Unresolved
/*       */         {
/*       */           private final TypeDescription declaringType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected WithExplicitType(TypeDescription.Generic param4Generic, AnnotationDescription.Loadable<Advice.FieldValue> param4Loadable, TypeDescription param4TypeDescription) {
/*  2587 */             this(param4Generic, ((Boolean)param4Loadable
/*  2588 */                 .getValue(Advice.OffsetMapping.ForField.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param4Loadable
/*  2589 */                 .getValue(Advice.OffsetMapping.ForField.b()).load(Assigner.Typing.class.getClassLoader()).resolve(Assigner.Typing.class), (String)param4Loadable
/*  2590 */                 .getValue(Advice.OffsetMapping.ForField.c()).resolve(String.class), param4TypeDescription);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public WithExplicitType(TypeDescription.Generic param4Generic, boolean param4Boolean, Assigner.Typing param4Typing, String param4String, TypeDescription param4TypeDescription) {
/*  2608 */             super(param4Generic, param4Boolean, param4Typing, param4String);
/*  2609 */             this.declaringType = param4TypeDescription;
/*       */           }
/*       */ 
/*       */           
/*       */           protected FieldLocator fieldLocator(TypeDescription param4TypeDescription) {
/*  2614 */             if (!this.declaringType.represents(TargetType.class) && !param4TypeDescription.isAssignableTo(this.declaringType)) {
/*  2615 */               throw new IllegalStateException(this.declaringType + " is no super type of " + param4TypeDescription);
/*       */             }
/*  2617 */             return (FieldLocator)new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, param4TypeDescription));
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.declaringType.equals(((WithExplicitType)param4Object).declaringType)))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return super.hashCode() * 31 + this.declaringType.hashCode();
/*       */           } }
/*       */         
/*       */         protected enum Factory implements Advice.OffsetMapping.Factory<Advice.FieldValue> {
/*  2629 */           INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.FieldValue> getAnnotationType() {
/*  2635 */             return Advice.FieldValue.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param4InDefinedShape, AnnotationDescription.Loadable<Advice.FieldValue> param4Loadable, Advice.OffsetMapping.Factory.AdviceType param4AdviceType) {
/*  2644 */             if (param4AdviceType.isDelegation() && !((Boolean)param4Loadable.getValue(Advice.OffsetMapping.ForField.a()).resolve(Boolean.class)).booleanValue()) {
/*  2645 */               throw new IllegalStateException("Cannot write to field for " + param4InDefinedShape + " in read-only context");
/*       */             }
/*       */             TypeDescription typeDescription;
/*  2648 */             return (Advice.OffsetMapping)((typeDescription = (TypeDescription)param4Loadable.getValue(Advice.OffsetMapping.ForField.d()).resolve(TypeDescription.class)).represents(void.class) ? new Advice.OffsetMapping.ForField.Unresolved.WithImplicitType(param4InDefinedShape
/*  2649 */                 .getType(), param4Loadable) : new Advice.OffsetMapping.ForField.Unresolved.WithExplicitType(param4InDefinedShape
/*  2650 */                 .getType(), param4Loadable, typeDescription));
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Resolved
/*       */         extends ForField
/*       */       {
/*       */         private final FieldDescription fieldDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Resolved(TypeDescription.Generic param3Generic, boolean param3Boolean, Assigner.Typing param3Typing, FieldDescription param3FieldDescription) {
/*  2676 */           super(param3Generic, param3Boolean, param3Typing);
/*  2677 */           this.fieldDescription = param3FieldDescription;
/*       */         }
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*       */         protected FieldDescription resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  2683 */           if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(param3TypeDescription))
/*  2684 */             throw new IllegalStateException(this.fieldDescription + " is no member of " + param3TypeDescription); 
/*  2685 */           if (!this.fieldDescription.isVisibleTo(param3TypeDescription)) {
/*  2686 */             throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + param3TypeDescription);
/*       */           }
/*  2688 */           return this.fieldDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((Resolved)param3Object).fieldDescription)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.fieldDescription.hashCode();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class Factory<T extends Annotation>
/*       */           implements Advice.OffsetMapping.Factory<T>
/*       */         {
/*       */           private final Class<T> annotationType;
/*       */ 
/*       */           
/*       */           private final FieldDescription fieldDescription;
/*       */ 
/*       */           
/*       */           private final boolean readOnly;
/*       */ 
/*       */           
/*       */           private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */           
/*       */           public Factory(Class<T> param4Class, FieldDescription param4FieldDescription) {
/*  2726 */             this(param4Class, param4FieldDescription, true, Assigner.Typing.STATIC);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Factory(Class<T> param4Class, FieldDescription param4FieldDescription, boolean param4Boolean, Assigner.Typing param4Typing) {
/*  2738 */             this.annotationType = param4Class;
/*  2739 */             this.fieldDescription = param4FieldDescription;
/*  2740 */             this.readOnly = param4Boolean;
/*  2741 */             this.typing = param4Typing;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Class<T> getAnnotationType() {
/*  2748 */             return this.annotationType;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param4InDefinedShape, AnnotationDescription.Loadable<T> param4Loadable, Advice.OffsetMapping.Factory.AdviceType param4AdviceType) {
/*  2757 */             return new Advice.OffsetMapping.ForField.Resolved(param4InDefinedShape.getType(), this.readOnly, this.typing, this.fieldDescription);
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.readOnly != ((Factory)param4Object).readOnly) ? false : (!this.typing.equals(((Factory)param4Object).typing) ? false : (!this.annotationType.equals(((Factory)param4Object).annotationType) ? false : (!!this.fieldDescription.equals(((Factory)param4Object).fieldDescription)))))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (((getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.fieldDescription.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForOrigin
/*       */       implements OffsetMapping
/*       */     {
/*       */       private static final char DELIMITER = '#';
/*       */ 
/*       */       
/*       */       private static final char ESCAPE = '\\';
/*       */       
/*       */       private final List<Renderer> renderers;
/*       */ 
/*       */       
/*       */       public ForOrigin(List<Renderer> param2List) {
/*  2790 */         this.renderers = param2List;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Advice.OffsetMapping parse(String param2String) {
/*  2800 */         if (param2String.equals("")) {
/*  2801 */           return new ForOrigin(Collections.singletonList(Renderer.ForStringRepresentation.INSTANCE));
/*       */         }
/*  2803 */         ArrayList<Renderer.ForConstantValue> arrayList = new ArrayList(param2String.length());
/*  2804 */         int i = 0;
/*  2805 */         for (int j = param2String.indexOf('#'); j != -1; j = param2String.indexOf('#', i)) {
/*  2806 */           if (j != 0 && param2String.charAt(j - 1) == '\\' && (j == 1 || param2String.charAt(j - 2) != '\\')) {
/*  2807 */             arrayList.add(new Renderer.ForConstantValue(param2String.substring(i, Math.max(0, j - 1)) + '#'));
/*  2808 */             i = j + 1;
/*       */           } else {
/*  2810 */             if (param2String.length() == j + 1) {
/*  2811 */               throw new IllegalStateException("Missing sort descriptor for " + param2String + " at index " + j);
/*       */             }
/*  2813 */             arrayList.add(new Renderer.ForConstantValue(param2String.substring(i, j).replace("\\\\", "\\")));
/*  2814 */             switch (param2String.charAt(j + 1)) {
/*       */               case 'm':
/*  2816 */                 arrayList.add(Renderer.ForMethodName.INSTANCE);
/*       */                 break;
/*       */               case 't':
/*  2819 */                 arrayList.add(Renderer.ForTypeName.INSTANCE);
/*       */                 break;
/*       */               case 'd':
/*  2822 */                 arrayList.add(Renderer.ForDescriptor.INSTANCE);
/*       */                 break;
/*       */               case 'r':
/*  2825 */                 arrayList.add(Renderer.ForReturnTypeName.INSTANCE);
/*       */                 break;
/*       */               case 's':
/*  2828 */                 arrayList.add(Renderer.ForJavaSignature.INSTANCE);
/*       */                 break;
/*       */               case 'p':
/*  2831 */                 arrayList.add(Renderer.ForPropertyName.INSTANCE);
/*       */                 break;
/*       */               default:
/*  2834 */                 throw new IllegalStateException("Illegal sort descriptor " + param2String.charAt(j + 1) + " for " + param2String);
/*       */             } 
/*  2836 */             i = j + 2;
/*       */           } 
/*  2838 */         }  arrayList.add(new Renderer.ForConstantValue(param2String.substring(i)));
/*  2839 */         return new ForOrigin((List)arrayList);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  2851 */         StringBuilder stringBuilder = new StringBuilder();
/*  2852 */         for (Renderer renderer : this.renderers) {
/*  2853 */           stringBuilder.append(renderer.apply(param2TypeDescription, param2MethodDescription));
/*       */         }
/*  2855 */         return Advice.OffsetMapping.Target.ForStackManipulation.of(stringBuilder.toString());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.renderers.equals(((ForOrigin)param2Object).renderers))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.renderers.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForMethodName
/*       */         implements Renderer
/*       */       {
/*  2880 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static final char SYMBOL = 'm';
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  2891 */           return param3MethodDescription.getInternalName();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForTypeName
/*       */         implements Renderer
/*       */       {
/*  2903 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static final char SYMBOL = 't';
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  2914 */           return param3TypeDescription.getName();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForDescriptor
/*       */         implements Renderer
/*       */       {
/*  2926 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static final char SYMBOL = 'd';
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  2937 */           return param3MethodDescription.getDescriptor();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForJavaSignature
/*       */         implements Renderer
/*       */       {
/*  2949 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static final char SYMBOL = 's';
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  2960 */           StringBuilder stringBuilder = new StringBuilder("(");
/*  2961 */           boolean bool = false;
/*  2962 */           for (TypeDescription typeDescription : param3MethodDescription.getParameters().asTypeList().asErasures()) {
/*  2963 */             if (bool) {
/*  2964 */               stringBuilder.append(',');
/*       */             } else {
/*  2966 */               bool = true;
/*       */             } 
/*  2968 */             stringBuilder.append(typeDescription.getName());
/*       */           } 
/*  2970 */           return stringBuilder.append(')').toString();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForReturnTypeName
/*       */         implements Renderer
/*       */       {
/*  2982 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static final char SYMBOL = 'r';
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  2993 */           return param3MethodDescription.getReturnType().asErasure().getName();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForStringRepresentation
/*       */         implements Renderer
/*       */       {
/*  3005 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) {
/*  3011 */           return param3MethodDescription.toString();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForConstantValue
/*       */         implements Renderer
/*       */       {
/*       */         private final String value;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForConstantValue(String param3String) {
/*  3032 */           this.value = param3String;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription)
/*       */         {
/*  3039 */           return this.value; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.value.equals(((ForConstantValue)param3Object).value)))); } public int hashCode() { return getClass().hashCode() * 31 + this.value.hashCode(); } } public static interface Renderer { String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription); public enum ForMethodName implements Renderer { INSTANCE; public static final char SYMBOL = 'm'; public final String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) { return param4MethodDescription.getInternalName(); } } public enum ForTypeName implements Renderer { INSTANCE; public static final char SYMBOL = 't'; public final String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) { return param4TypeDescription.getName(); } } public enum ForDescriptor implements Renderer { INSTANCE; public static final char SYMBOL = 'd'; public final String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) { return param4MethodDescription.getDescriptor(); } } public enum ForJavaSignature implements Renderer { INSTANCE; public static final char SYMBOL = 's'; public final String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) { StringBuilder stringBuilder = new StringBuilder("("); boolean bool = false; for (TypeDescription typeDescription : param4MethodDescription.getParameters().asTypeList().asErasures()) { if (bool) { stringBuilder.append(','); } else { bool = true; }  stringBuilder.append(typeDescription.getName()); }  return stringBuilder.append(')').toString(); } } public enum ForReturnTypeName implements Renderer { INSTANCE; public static final char SYMBOL = 'r'; public final String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) { return param4MethodDescription.getReturnType().asErasure().getName(); } } public enum ForStringRepresentation implements Renderer { INSTANCE; public final String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) { return param4MethodDescription.toString(); } } @Enhance public static class ForConstantValue implements Renderer { private final String value; public ForConstantValue(String param4String) { this.value = param4String; } public String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) { return this.value; }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.value.equals(((ForConstantValue)param4Object).value))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.value.hashCode();
/*       */           } }
/*       */ 
/*       */         
/*  3051 */         public enum ForPropertyName implements Renderer { INSTANCE;
/*       */ 
/*       */ 
/*       */           
/*       */           public static final char SYMBOL = 'p';
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final String apply(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription)
/*       */           {
/*  3062 */             return FieldAccessor.FieldNameExtractor.ForBeanProperty.INSTANCE.resolve(param4MethodDescription); } } } public enum ForPropertyName implements Renderer { INSTANCE; public static final char SYMBOL = 'p'; public final String apply(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription) { return FieldAccessor.FieldNameExtractor.ForBeanProperty.INSTANCE.resolve(param3MethodDescription); }
/*       */          }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected enum Factory
/*       */         implements Advice.OffsetMapping.Factory<Advice.Origin>
/*       */       {
/*  3075 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  3080 */         private static final MethodDescription.InDefinedShape ORIGIN_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Advice.Origin.class)
/*  3081 */           .getDeclaredMethods()
/*  3082 */           .filter((ElementMatcher)ElementMatchers.named("value")))
/*  3083 */           .getOnly();
/*       */         static {
/*       */         
/*       */         }
/*       */         
/*       */         public final Class<Advice.Origin> getAnnotationType() {
/*  3089 */           return Advice.Origin.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.Origin> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  3098 */           if (param3InDefinedShape.getType().asErasure().represents(Class.class))
/*  3099 */             return Advice.OffsetMapping.ForInstrumentedType.INSTANCE; 
/*  3100 */           if (param3InDefinedShape.getType().asErasure().represents(Method.class))
/*  3101 */             return Advice.OffsetMapping.ForInstrumentedMethod.METHOD; 
/*  3102 */           if (param3InDefinedShape.getType().asErasure().represents(Constructor.class))
/*  3103 */             return Advice.OffsetMapping.ForInstrumentedMethod.CONSTRUCTOR; 
/*  3104 */           if (JavaType.EXECUTABLE.getTypeStub().equals(param3InDefinedShape.getType().asErasure()))
/*  3105 */             return Advice.OffsetMapping.ForInstrumentedMethod.EXECUTABLE; 
/*  3106 */           if (JavaType.METHOD_HANDLE.getTypeStub().equals(param3InDefinedShape.getType().asErasure()))
/*  3107 */             return Advice.OffsetMapping.ForInstrumentedMethod.METHOD_HANDLE; 
/*  3108 */           if (JavaType.METHOD_TYPE.getTypeStub().equals(param3InDefinedShape.getType().asErasure()))
/*  3109 */             return Advice.OffsetMapping.ForInstrumentedMethod.METHOD_TYPE; 
/*  3110 */           if (JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().equals(param3InDefinedShape.getType().asErasure())) {
/*  3111 */             return new Advice.OffsetMapping.ForStackManipulation(MethodInvocation.lookup(), JavaType.METHOD_HANDLES_LOOKUP
/*  3112 */                 .getTypeStub().asGenericType(), param3InDefinedShape
/*  3113 */                 .getType(), Assigner.Typing.STATIC);
/*       */           }
/*  3115 */           if (param3InDefinedShape.getType().asErasure().isAssignableFrom(String.class)) {
/*  3116 */             return Advice.OffsetMapping.ForOrigin.parse((String)param3Loadable.getValue(ORIGIN_VALUE).resolve(String.class));
/*       */           }
/*  3118 */           throw new IllegalStateException("Non-supported type " + param3InDefinedShape.getType() + " for @Origin annotation");
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForUnusedValue
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDefinition target;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForUnusedValue(TypeDefinition param2TypeDefinition) {
/*  3141 */         this.target = param2TypeDefinition;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  3152 */         return new Advice.OffsetMapping.Target.ForDefaultValue.ReadWrite(this.target);
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.target.equals(((ForUnusedValue)param2Object).target))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.target.hashCode();
/*       */       }
/*       */       
/*  3163 */       protected enum Factory implements Advice.OffsetMapping.Factory<Advice.Unused> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Class<Advice.Unused> getAnnotationType() {
/*  3169 */           return Advice.Unused.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.Unused> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  3178 */           return new Advice.OffsetMapping.ForUnusedValue((TypeDefinition)param3InDefinedShape.getType());
/*       */         } }
/*       */     
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum ForStubValue
/*       */       implements OffsetMapping, Factory<Advice.StubValue>
/*       */     {
/*  3192 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  3202 */         return new Advice.OffsetMapping.Target.ForDefaultValue.ReadOnly((TypeDefinition)param2MethodDescription.getReturnType(), param2Assigner.assign(param2MethodDescription.getReturnType(), 
/*  3203 */               TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Assigner.Typing.DYNAMIC));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Class<Advice.StubValue> getAnnotationType() {
/*  3211 */         return Advice.StubValue.class;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param2InDefinedShape, AnnotationDescription.Loadable<Advice.StubValue> param2Loadable, Advice.OffsetMapping.Factory.AdviceType param2AdviceType) {
/*  3220 */         if (!param2InDefinedShape.getType().represents(Object.class)) {
/*  3221 */           throw new IllegalStateException("Cannot use StubValue on non-Object parameter type " + param2InDefinedShape);
/*       */         }
/*  3223 */         return this;
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForEnterValue
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypeDescription.Generic enterType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean readOnly;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForEnterValue(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, AnnotationDescription.Loadable<Advice.Enter> param2Loadable) {
/*  3262 */         this(param2Generic1, param2Generic2, ((Boolean)param2Loadable
/*       */             
/*  3264 */             .getValue(Factory.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param2Loadable
/*  3265 */             .getValue(Factory.b()).load(Advice.Enter.class.getClassLoader()).resolve(Assigner.Typing.class));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForEnterValue(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, boolean param2Boolean, Assigner.Typing param2Typing) {
/*  3277 */         this.target = param2Generic1;
/*  3278 */         this.enterType = param2Generic2;
/*  3279 */         this.readOnly = param2Boolean;
/*  3280 */         this.typing = param2Typing;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*       */         StackManipulation stackManipulation1;
/*  3292 */         if (!(stackManipulation1 = param2Assigner.assign(this.enterType, this.target, this.typing)).isValid())
/*  3293 */           throw new IllegalStateException("Cannot assign " + this.enterType + " to " + this.target); 
/*  3294 */         if (this.readOnly) {
/*  3295 */           return new Advice.OffsetMapping.Target.ForVariable.ReadOnly((TypeDefinition)this.target, param2ArgumentHandler.enter(), stackManipulation1);
/*       */         }
/*       */         StackManipulation stackManipulation2;
/*  3298 */         if (!(stackManipulation2 = param2Assigner.assign(this.target, this.enterType, this.typing)).isValid()) {
/*  3299 */           throw new IllegalStateException("Cannot assign " + this.target + " to " + this.enterType);
/*       */         }
/*  3301 */         return new Advice.OffsetMapping.Target.ForVariable.ReadWrite((TypeDefinition)this.target, param2ArgumentHandler.enter(), stackManipulation1, stackManipulation2);
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForEnterValue)param2Object).readOnly) ? false : (!this.typing.equals(((ForEnterValue)param2Object).typing) ? false : (!this.target.equals(((ForEnterValue)param2Object).target) ? false : (!!this.enterType.equals(((ForEnterValue)param2Object).enterType)))))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.enterType.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class Factory
/*       */         implements Advice.OffsetMapping.Factory<Advice.Enter>
/*       */       {
/*       */         private static final MethodDescription.InDefinedShape ENTER_READ_ONLY;
/*       */         
/*       */         private static final MethodDescription.InDefinedShape ENTER_TYPING;
/*       */         private final TypeDefinition enterType;
/*       */         
/*       */         static {
/*       */           MethodList methodList;
/*  3326 */           ENTER_READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.Enter.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  3327 */           ENTER_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Factory(TypeDefinition param3TypeDefinition) {
/*  3341 */           this.enterType = param3TypeDefinition;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static Advice.OffsetMapping.Factory<Advice.Enter> of(TypeDefinition param3TypeDefinition) {
/*  3351 */           return (Advice.OffsetMapping.Factory<Advice.Enter>)(param3TypeDefinition.represents(void.class) ? new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class) : new Factory(param3TypeDefinition));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<Advice.Enter> getAnnotationType() {
/*  3360 */           return Advice.Enter.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.Enter> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  3369 */           if (param3AdviceType.isDelegation() && !((Boolean)param3Loadable.getValue(ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
/*  3370 */             throw new IllegalStateException("Cannot use writable " + param3InDefinedShape + " on read-only parameter");
/*       */           }
/*  3372 */           return new Advice.OffsetMapping.ForEnterValue(param3InDefinedShape.getType(), this.enterType.asGenericType(), param3Loadable);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.enterType.equals(((Factory)param3Object).enterType))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.enterType.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForExitValue
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */       
/*       */       private final TypeDescription.Generic exitType;
/*       */ 
/*       */       
/*       */       private final boolean readOnly;
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForExitValue(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, AnnotationDescription.Loadable<Advice.Exit> param2Loadable) {
/*  3412 */         this(param2Generic1, param2Generic2, ((Boolean)param2Loadable
/*       */             
/*  3414 */             .getValue(Factory.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param2Loadable
/*  3415 */             .getValue(Factory.b()).load(Advice.Exit.class.getClassLoader()).resolve(Assigner.Typing.class));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForExitValue(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, boolean param2Boolean, Assigner.Typing param2Typing) {
/*  3427 */         this.target = param2Generic1;
/*  3428 */         this.exitType = param2Generic2;
/*  3429 */         this.readOnly = param2Boolean;
/*  3430 */         this.typing = param2Typing;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*       */         StackManipulation stackManipulation1;
/*  3442 */         if (!(stackManipulation1 = param2Assigner.assign(this.exitType, this.target, this.typing)).isValid())
/*  3443 */           throw new IllegalStateException("Cannot assign " + this.exitType + " to " + this.target); 
/*  3444 */         if (this.readOnly) {
/*  3445 */           return new Advice.OffsetMapping.Target.ForVariable.ReadOnly((TypeDefinition)this.target, param2ArgumentHandler.exit(), stackManipulation1);
/*       */         }
/*       */         StackManipulation stackManipulation2;
/*  3448 */         if (!(stackManipulation2 = param2Assigner.assign(this.target, this.exitType, this.typing)).isValid()) {
/*  3449 */           throw new IllegalStateException("Cannot assign " + this.target + " to " + this.exitType);
/*       */         }
/*  3451 */         return new Advice.OffsetMapping.Target.ForVariable.ReadWrite((TypeDefinition)this.target, param2ArgumentHandler.exit(), stackManipulation1, stackManipulation2);
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForExitValue)param2Object).readOnly) ? false : (!this.typing.equals(((ForExitValue)param2Object).typing) ? false : (!this.target.equals(((ForExitValue)param2Object).target) ? false : (!!this.exitType.equals(((ForExitValue)param2Object).exitType)))))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.exitType.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class Factory
/*       */         implements Advice.OffsetMapping.Factory<Advice.Exit>
/*       */       {
/*       */         private static final MethodDescription.InDefinedShape EXIT_READ_ONLY;
/*       */         
/*       */         private static final MethodDescription.InDefinedShape EXIT_TYPING;
/*       */         private final TypeDefinition exitType;
/*       */         
/*       */         static {
/*       */           MethodList methodList;
/*  3476 */           EXIT_READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.Exit.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  3477 */           EXIT_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Factory(TypeDefinition param3TypeDefinition) {
/*  3491 */           this.exitType = param3TypeDefinition;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static Advice.OffsetMapping.Factory<Advice.Exit> of(TypeDefinition param3TypeDefinition) {
/*  3501 */           return (Advice.OffsetMapping.Factory<Advice.Exit>)(param3TypeDefinition.represents(void.class) ? new Advice.OffsetMapping.Factory.Illegal<Advice.Exit>(Advice.Exit.class) : new Factory(param3TypeDefinition));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<Advice.Exit> getAnnotationType() {
/*  3510 */           return Advice.Exit.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.Exit> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  3519 */           if (param3AdviceType.isDelegation() && !((Boolean)param3Loadable.getValue(EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
/*  3520 */             throw new IllegalStateException("Cannot use writable " + param3InDefinedShape + " on read-only parameter");
/*       */           }
/*  3522 */           return new Advice.OffsetMapping.ForExitValue(param3InDefinedShape.getType(), this.exitType.asGenericType(), param3Loadable);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.exitType.equals(((Factory)param3Object).exitType))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.exitType.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForLocalValue
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */       
/*       */       private final TypeDescription.Generic localType;
/*       */ 
/*       */       
/*       */       private final String name;
/*       */ 
/*       */ 
/*       */       
/*       */       public ForLocalValue(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, String param2String) {
/*  3557 */         this.target = param2Generic1;
/*  3558 */         this.localType = param2Generic2;
/*  3559 */         this.name = param2String;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*  3570 */         StackManipulation stackManipulation1 = param2Assigner.assign(this.localType, this.target, Assigner.Typing.STATIC);
/*  3571 */         StackManipulation stackManipulation2 = param2Assigner.assign(this.target, this.localType, Assigner.Typing.STATIC);
/*  3572 */         if (!stackManipulation1.isValid() || !stackManipulation2.isValid()) {
/*  3573 */           throw new IllegalStateException("Cannot assign " + this.localType + " to " + this.target);
/*       */         }
/*  3575 */         return new Advice.OffsetMapping.Target.ForVariable.ReadWrite((TypeDefinition)this.target, param2ArgumentHandler.named(this.name), stackManipulation1, stackManipulation2);
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.name.equals(((ForLocalValue)param2Object).name) ? false : (!this.target.equals(((ForLocalValue)param2Object).target) ? false : (!!this.localType.equals(((ForLocalValue)param2Object).localType))))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.localType.hashCode()) * 31 + this.name.hashCode();
/*       */       }
/*       */       
/*       */       @Enhance
/*       */       protected static class Factory implements Advice.OffsetMapping.Factory<Advice.Local> {
/*  3588 */         protected static final MethodDescription.InDefinedShape LOCAL_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Advice.Local.class)
/*  3589 */           .getDeclaredMethods()
/*  3590 */           .filter((ElementMatcher)ElementMatchers.named("value")))
/*  3591 */           .getOnly();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Map<String, TypeDefinition> namedTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Factory(Map<String, TypeDefinition> param3Map) {
/*  3604 */           this.namedTypes = param3Map;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<Advice.Local> getAnnotationType() {
/*  3611 */           return Advice.Local.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.Local> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  3620 */           String str = (String)param3Loadable.getValue(LOCAL_VALUE).resolve(String.class);
/*       */           TypeDefinition typeDefinition;
/*  3622 */           if ((typeDefinition = this.namedTypes.get(str)) == null) {
/*  3623 */             throw new IllegalStateException("Named local variable is unknown: " + str);
/*       */           }
/*  3625 */           return new Advice.OffsetMapping.ForLocalValue(param3InDefinedShape.getType(), typeDefinition.asGenericType(), str);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.namedTypes.equals(((Factory)param3Object).namedTypes))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.namedTypes.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForReturnValue
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */       
/*       */       private final boolean readOnly;
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */       
/*       */       protected ForReturnValue(TypeDescription.Generic param2Generic, AnnotationDescription.Loadable<Advice.Return> param2Loadable) {
/*  3658 */         this(param2Generic, ((Boolean)param2Loadable
/*  3659 */             .getValue(Factory.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param2Loadable
/*  3660 */             .getValue(Factory.b()).load(Advice.Return.class.getClassLoader()).resolve(Assigner.Typing.class));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForReturnValue(TypeDescription.Generic param2Generic, boolean param2Boolean, Assigner.Typing param2Typing) {
/*  3671 */         this.target = param2Generic;
/*  3672 */         this.readOnly = param2Boolean;
/*  3673 */         this.typing = param2Typing;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*       */         StackManipulation stackManipulation1;
/*  3685 */         if (!(stackManipulation1 = param2Assigner.assign(param2MethodDescription.getReturnType(), this.target, this.typing)).isValid())
/*  3686 */           throw new IllegalStateException("Cannot assign " + param2MethodDescription.getReturnType() + " to " + this.target); 
/*  3687 */         if (this.readOnly) {
/*  3688 */           return (Advice.OffsetMapping.Target)(param2MethodDescription.getReturnType().represents(void.class) ? new Advice.OffsetMapping.Target.ForDefaultValue.ReadOnly((TypeDefinition)this.target) : new Advice.OffsetMapping.Target.ForVariable.ReadOnly((TypeDefinition)param2MethodDescription
/*       */               
/*  3690 */               .getReturnType(), param2ArgumentHandler.returned(), stackManipulation1));
/*       */         }
/*       */         StackManipulation stackManipulation2;
/*  3693 */         if (!(stackManipulation2 = param2Assigner.assign(this.target, param2MethodDescription.getReturnType(), this.typing)).isValid()) {
/*  3694 */           throw new IllegalStateException("Cannot assign " + this.target + " to " + param2MethodDescription.getReturnType());
/*       */         }
/*  3696 */         return (Advice.OffsetMapping.Target)(param2MethodDescription.getReturnType().represents(void.class) ? new Advice.OffsetMapping.Target.ForDefaultValue.ReadWrite((TypeDefinition)this.target) : new Advice.OffsetMapping.Target.ForVariable.ReadWrite((TypeDefinition)param2MethodDescription
/*       */             
/*  3698 */             .getReturnType(), param2ArgumentHandler.returned(), stackManipulation1, stackManipulation2));
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForReturnValue)param2Object).readOnly) ? false : (!this.typing.equals(((ForReturnValue)param2Object).typing) ? false : (!!this.target.equals(((ForReturnValue)param2Object).target))))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */       }
/*       */       
/*       */       protected enum Factory implements Advice.OffsetMapping.Factory<Advice.Return> {
/*  3710 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape RETURN_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape RETURN_READ_ONLY;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         static {
/*       */           MethodList methodList;
/*  3727 */           RETURN_READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.Return.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  3728 */           RETURN_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Class<Advice.Return> getAnnotationType() {
/*  3735 */           return Advice.Return.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.Return> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  3744 */           if (param3AdviceType.isDelegation() && !((Boolean)param3Loadable.getValue(RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
/*  3745 */             throw new IllegalStateException("Cannot write return value for " + param3InDefinedShape + " in read-only context");
/*       */           }
/*  3747 */           return new Advice.OffsetMapping.ForReturnValue(param3InDefinedShape.getType(), param3Loadable);
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForThrowable
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean readOnly;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForThrowable(TypeDescription.Generic param2Generic, AnnotationDescription.Loadable<Advice.Thrown> param2Loadable) {
/*  3781 */         this(param2Generic, ((Boolean)param2Loadable
/*  3782 */             .getValue(Factory.a()).resolve(Boolean.class)).booleanValue(), (Assigner.Typing)param2Loadable
/*  3783 */             .getValue(Factory.b()).load(Advice.Thrown.class.getClassLoader()).resolve(Assigner.Typing.class));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForThrowable(TypeDescription.Generic param2Generic, boolean param2Boolean, Assigner.Typing param2Typing) {
/*  3794 */         this.target = param2Generic;
/*  3795 */         this.readOnly = param2Boolean;
/*  3796 */         this.typing = param2Typing;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*       */         StackManipulation stackManipulation1;
/*  3808 */         if (!(stackManipulation1 = param2Assigner.assign(TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.target, this.typing)).isValid())
/*  3809 */           throw new IllegalStateException("Cannot assign Throwable to " + this.target); 
/*  3810 */         if (this.readOnly) {
/*  3811 */           return new Advice.OffsetMapping.Target.ForVariable.ReadOnly((TypeDefinition)TypeDescription.ForLoadedType.of(Throwable.class), param2ArgumentHandler.thrown(), stackManipulation1);
/*       */         }
/*       */         StackManipulation stackManipulation2;
/*  3814 */         if (!(stackManipulation2 = param2Assigner.assign(this.target, TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.typing)).isValid()) {
/*  3815 */           throw new IllegalStateException("Cannot assign " + this.target + " to Throwable");
/*       */         }
/*  3817 */         return new Advice.OffsetMapping.Target.ForVariable.ReadWrite((TypeDefinition)TypeDescription.ForLoadedType.of(Throwable.class), param2ArgumentHandler.thrown(), stackManipulation1, stackManipulation2);
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.readOnly != ((ForThrowable)param2Object).readOnly) ? false : (!this.typing.equals(((ForThrowable)param2Object).typing) ? false : (!!this.target.equals(((ForThrowable)param2Object).target))))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.readOnly) * 31 + this.typing.hashCode();
/*       */       }
/*       */       
/*       */       protected enum Factory implements Advice.OffsetMapping.Factory<Advice.Thrown> {
/*  3829 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape THROWN_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private static final MethodDescription.InDefinedShape THROWN_READ_ONLY;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         static {
/*       */           MethodList methodList;
/*  3846 */           THROWN_READ_ONLY = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.Thrown.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("readOnly"))).getOnly();
/*  3847 */           THROWN_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */         protected static Advice.OffsetMapping.Factory<?> of(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  3859 */           if (((TypeDescription)param3InDefinedShape.getDeclaredAnnotations()
/*  3860 */             .ofType(Advice.OnMethodExit.class)
/*  3861 */             .getValue(Advice.a())
/*  3862 */             .resolve(TypeDescription.class))
/*  3863 */             .represents(Advice.NoExceptionHandler.class)) return new Advice.OffsetMapping.Factory.Illegal(Advice.Thrown.class);  return INSTANCE;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Class<Advice.Thrown> getAnnotationType() {
/*  3870 */           return Advice.Thrown.class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<Advice.Thrown> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  3879 */           if (param3AdviceType.isDelegation() && !((Boolean)param3Loadable.getValue(THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
/*  3880 */             throw new IllegalStateException("Cannot use writable " + param3InDefinedShape + " on read-only parameter");
/*       */           }
/*  3882 */           return new Advice.OffsetMapping.ForThrowable(param3InDefinedShape.getType(), param3Loadable);
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForStackManipulation
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final StackManipulation stackManipulation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypeDescription.Generic typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypeDescription.Generic targetType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForStackManipulation(StackManipulation param2StackManipulation, TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, Assigner.Typing param2Typing) {
/*  3926 */         this.stackManipulation = param2StackManipulation;
/*  3927 */         this.typeDescription = param2Generic1;
/*  3928 */         this.targetType = param2Generic2;
/*  3929 */         this.typing = param2Typing;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*       */         StackManipulation stackManipulation;
/*  3941 */         if (!(stackManipulation = param2Assigner.assign(this.typeDescription, this.targetType, this.typing)).isValid()) {
/*  3942 */           throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.targetType);
/*       */         }
/*  3944 */         return new Advice.OffsetMapping.Target.ForStackManipulation((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.stackManipulation, stackManipulation }));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typing.equals(((ForStackManipulation)param2Object).typing) ? false : (!this.stackManipulation.equals(((ForStackManipulation)param2Object).stackManipulation) ? false : (!this.typeDescription.equals(((ForStackManipulation)param2Object).typeDescription) ? false : (!!this.targetType.equals(((ForStackManipulation)param2Object).targetType)))))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.typeDescription.hashCode()) * 31 + this.targetType.hashCode()) * 31 + this.typing.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Factory<T extends Annotation>
/*       */         implements Advice.OffsetMapping.Factory<T>
/*       */       {
/*       */         private final Class<T> annotationType;
/*       */ 
/*       */         
/*       */         private final StackManipulation stackManipulation;
/*       */ 
/*       */         
/*       */         private final TypeDescription.Generic typeDescription;
/*       */ 
/*       */ 
/*       */         
/*       */         public Factory(Class<T> param3Class, TypeDescription param3TypeDescription) {
/*  3977 */           this(param3Class, ClassConstant.of(param3TypeDescription), TypeDescription.ForLoadedType.of(Class.class).asGenericType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Factory(Class<T> param3Class, EnumerationDescription param3EnumerationDescription) {
/*  3987 */           this(param3Class, FieldAccess.forEnumeration(param3EnumerationDescription), param3EnumerationDescription.getEnumerationType().asGenericType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Factory(Class<T> param3Class, StackManipulation param3StackManipulation, TypeDescription.Generic param3Generic) {
/*  3998 */           this.annotationType = param3Class;
/*  3999 */           this.stackManipulation = param3StackManipulation;
/*  4000 */           this.typeDescription = param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static <S extends Annotation> Advice.OffsetMapping.Factory<S> of(Class<S> param3Class, @MaybeNull Object param3Object) {
/*       */           JavaConstantValue javaConstantValue;
/*  4014 */           if (param3Object == null)
/*  4015 */             return new Advice.OffsetMapping.ForStackManipulation.OfDefaultValue<S>(param3Class); 
/*  4016 */           if (param3Object instanceof Boolean) {
/*  4017 */             StackManipulation stackManipulation = IntegerConstant.forValue(((Boolean)param3Object).booleanValue());
/*  4018 */             param3Object = TypeDescription.ForLoadedType.of(boolean.class);
/*  4019 */           } else if (param3Object instanceof Byte) {
/*  4020 */             StackManipulation stackManipulation = IntegerConstant.forValue(((Byte)param3Object).byteValue());
/*  4021 */             param3Object = TypeDescription.ForLoadedType.of(byte.class);
/*  4022 */           } else if (param3Object instanceof Short) {
/*  4023 */             StackManipulation stackManipulation = IntegerConstant.forValue(((Short)param3Object).shortValue());
/*  4024 */             param3Object = TypeDescription.ForLoadedType.of(short.class);
/*  4025 */           } else if (param3Object instanceof Character) {
/*  4026 */             StackManipulation stackManipulation = IntegerConstant.forValue(((Character)param3Object).charValue());
/*  4027 */             param3Object = TypeDescription.ForLoadedType.of(char.class);
/*  4028 */           } else if (param3Object instanceof Integer) {
/*  4029 */             StackManipulation stackManipulation = IntegerConstant.forValue(((Integer)param3Object).intValue());
/*  4030 */             param3Object = TypeDescription.ForLoadedType.of(int.class);
/*  4031 */           } else if (param3Object instanceof Long) {
/*  4032 */             StackManipulation stackManipulation = LongConstant.forValue(((Long)param3Object).longValue());
/*  4033 */             param3Object = TypeDescription.ForLoadedType.of(long.class);
/*  4034 */           } else if (param3Object instanceof Float) {
/*  4035 */             StackManipulation stackManipulation = FloatConstant.forValue(((Float)param3Object).floatValue());
/*  4036 */             param3Object = TypeDescription.ForLoadedType.of(float.class);
/*  4037 */           } else if (param3Object instanceof Double) {
/*  4038 */             StackManipulation stackManipulation = DoubleConstant.forValue(((Double)param3Object).doubleValue());
/*  4039 */             param3Object = TypeDescription.ForLoadedType.of(double.class);
/*  4040 */           } else if (param3Object instanceof String) {
/*  4041 */             TextConstant textConstant = new TextConstant((String)param3Object);
/*  4042 */             param3Object = TypeDescription.ForLoadedType.of(String.class);
/*  4043 */           } else if (param3Object instanceof Class) {
/*  4044 */             StackManipulation stackManipulation = ClassConstant.of(TypeDescription.ForLoadedType.of((Class)param3Object));
/*  4045 */             param3Object = TypeDescription.ForLoadedType.of(Class.class);
/*  4046 */           } else if (param3Object instanceof TypeDescription) {
/*  4047 */             StackManipulation stackManipulation = ClassConstant.of((TypeDescription)param3Object);
/*  4048 */             param3Object = TypeDescription.ForLoadedType.of(Class.class);
/*  4049 */           } else if (param3Object instanceof Enum) {
/*  4050 */             StackManipulation stackManipulation = FieldAccess.forEnumeration((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)param3Object));
/*  4051 */             param3Object = TypeDescription.ForLoadedType.of(((Enum)param3Object).getDeclaringClass());
/*  4052 */           } else if (param3Object instanceof EnumerationDescription) {
/*  4053 */             StackManipulation stackManipulation = FieldAccess.forEnumeration((EnumerationDescription)param3Object);
/*  4054 */             param3Object = ((EnumerationDescription)param3Object).getEnumerationType();
/*  4055 */           } else if (JavaType.METHOD_HANDLE.isInstance(param3Object)) {
/*  4056 */             param3Object = JavaConstant.MethodHandle.ofLoaded(param3Object);
/*  4057 */             javaConstantValue = new JavaConstantValue((JavaConstant)param3Object);
/*  4058 */             param3Object = param3Object.getTypeDescription();
/*  4059 */           } else if (JavaType.METHOD_TYPE.isInstance(param3Object)) {
/*  4060 */             param3Object = JavaConstant.MethodType.ofLoaded(param3Object);
/*  4061 */             javaConstantValue = new JavaConstantValue((JavaConstant)param3Object);
/*  4062 */             param3Object = param3Object.getTypeDescription();
/*  4063 */           } else if (param3Object instanceof JavaConstant) {
/*  4064 */             javaConstantValue = new JavaConstantValue((JavaConstant)param3Object);
/*  4065 */             param3Object = ((JavaConstant)param3Object).getTypeDescription();
/*       */           } else {
/*  4067 */             throw new IllegalStateException("Not a constant value: " + param3Object);
/*       */           } 
/*  4069 */           return new Factory<S>(param3Class, (StackManipulation)javaConstantValue, param3Object.asGenericType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<T> getAnnotationType() {
/*  4076 */           return this.annotationType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  4085 */           return new Advice.OffsetMapping.ForStackManipulation(this.stackManipulation, this.typeDescription, param3InDefinedShape.getType(), Assigner.Typing.STATIC);
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationType.equals(((Factory)param3Object).annotationType) ? false : (!this.stackManipulation.equals(((Factory)param3Object).stackManipulation) ? false : (!!this.typeDescription.equals(((Factory)param3Object).typeDescription))))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.stackManipulation.hashCode()) * 31 + this.typeDescription.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class OfDefaultValue<T extends Annotation>
/*       */         implements Advice.OffsetMapping.Factory<T>
/*       */       {
/*       */         private final Class<T> annotationType;
/*       */ 
/*       */         
/*       */         public OfDefaultValue(Class<T> param3Class) {
/*  4108 */           this.annotationType = param3Class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<T> getAnnotationType() {
/*  4115 */           return this.annotationType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  4122 */           return new Advice.OffsetMapping.ForStackManipulation(DefaultValue.of((TypeDefinition)param3InDefinedShape.getType()), param3InDefinedShape.getType(), param3InDefinedShape.getType(), Assigner.Typing.STATIC);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.annotationType.equals(((OfDefaultValue)param3Object).annotationType))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.annotationType.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class OfAnnotationProperty<T extends Annotation>
/*       */         implements Advice.OffsetMapping.Factory<T>
/*       */       {
/*       */         private final Class<T> annotationType;
/*       */ 
/*       */         
/*       */         private final MethodDescription.InDefinedShape property;
/*       */ 
/*       */         
/*       */         protected OfAnnotationProperty(Class<T> param3Class, MethodDescription.InDefinedShape param3InDefinedShape) {
/*  4151 */           this.annotationType = param3Class;
/*  4152 */           this.property = param3InDefinedShape;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static <S extends Annotation> Advice.OffsetMapping.Factory<S> of(Class<S> param3Class, String param3String) {
/*  4164 */           if (!param3Class.isAnnotation()) {
/*  4165 */             throw new IllegalArgumentException("Not an annotation type: " + param3Class);
/*       */           }
/*       */           try {
/*  4168 */             return new OfAnnotationProperty<S>(param3Class, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param3Class.getMethod(param3String, new Class[0])));
/*  4169 */           } catch (NoSuchMethodException noSuchMethodException) {
/*  4170 */             throw new IllegalArgumentException("Cannot find a property " + param3String + " on " + param3Class, noSuchMethodException);
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<T> getAnnotationType() {
/*  4178 */           return this.annotationType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*       */           Object<T> object;
/*  4187 */           if (object = (Object<T>)param3Loadable.getValue(this.property).resolve() instanceof TypeDescription)
/*  4188 */           { object = (Object<T>)new Advice.OffsetMapping.ForStackManipulation.Factory<T>(this.annotationType, (TypeDescription)object); }
/*  4189 */           else if (object instanceof EnumerationDescription)
/*  4190 */           { object = (Object<T>)new Advice.OffsetMapping.ForStackManipulation.Factory<T>(this.annotationType, (EnumerationDescription)object); }
/*  4191 */           else { if (object instanceof AnnotationDescription) {
/*  4192 */               throw new IllegalStateException("Cannot bind annotation as fixed value for " + this.property);
/*       */             }
/*  4194 */             object = Advice.OffsetMapping.ForStackManipulation.Factory.of(this.annotationType, object); }
/*       */           
/*  4196 */           return object.make(param3InDefinedShape, param3Loadable, param3AdviceType);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationType.equals(((OfAnnotationProperty)param3Object).annotationType) ? false : (!!this.property.equals(((OfAnnotationProperty)param3Object).property)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.property.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class OfDynamicInvocation<T extends Annotation>
/*       */         implements Advice.OffsetMapping.Factory<T>
/*       */       {
/*       */         private final Class<T> annotationType;
/*       */ 
/*       */         
/*       */         private final MethodDescription.InDefinedShape bootstrapMethod;
/*       */ 
/*       */         
/*       */         private final List<? extends JavaConstant> arguments;
/*       */ 
/*       */ 
/*       */         
/*       */         public OfDynamicInvocation(Class<T> param3Class, MethodDescription.InDefinedShape param3InDefinedShape, List<? extends JavaConstant> param3List) {
/*  4231 */           this.annotationType = param3Class;
/*  4232 */           this.bootstrapMethod = param3InDefinedShape;
/*  4233 */           this.arguments = param3List;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<T> getAnnotationType() {
/*  4240 */           return this.annotationType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  4247 */           if (!param3InDefinedShape.getType().isInterface())
/*  4248 */             throw new IllegalArgumentException(param3InDefinedShape.getType() + " is not an interface"); 
/*  4249 */           if (!param3InDefinedShape.getType().getInterfaces().isEmpty())
/*  4250 */             throw new IllegalArgumentException(param3InDefinedShape.getType() + " must not extend other interfaces"); 
/*  4251 */           if (!param3InDefinedShape.getType().isPublic()) {
/*  4252 */             throw new IllegalArgumentException(param3InDefinedShape.getType() + " is mot public");
/*       */           }
/*       */           MethodList methodList;
/*  4255 */           if ((methodList = (MethodList)param3InDefinedShape.getType().getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isAbstract())).size() != 1) {
/*  4256 */             throw new IllegalArgumentException(param3InDefinedShape.getType() + " must declare exactly one abstract method");
/*       */           }
/*  4258 */           return new Advice.OffsetMapping.ForStackManipulation(MethodInvocation.invoke(this.bootstrapMethod).dynamic(((MethodDescription)methodList.getOnly()).getInternalName(), param3InDefinedShape
/*  4259 */                 .getType().asErasure(), 
/*  4260 */                 Collections.emptyList(), this.arguments), param3InDefinedShape
/*  4261 */               .getType(), param3InDefinedShape.getType(), Assigner.Typing.STATIC);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationType.equals(((OfDynamicInvocation)param3Object).annotationType) ? false : (!this.bootstrapMethod.equals(((OfDynamicInvocation)param3Object).bootstrapMethod) ? false : (!!this.arguments.equals(((OfDynamicInvocation)param3Object).arguments))))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.bootstrapMethod.hashCode()) * 31 + this.arguments.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForSerializedValue
/*       */       implements OffsetMapping
/*       */     {
/*       */       private final TypeDescription.Generic target;
/*       */ 
/*       */       
/*       */       private final TypeDescription typeDescription;
/*       */ 
/*       */       
/*       */       private final StackManipulation deserialization;
/*       */ 
/*       */ 
/*       */       
/*       */       public ForSerializedValue(TypeDescription.Generic param2Generic, TypeDescription param2TypeDescription, StackManipulation param2StackManipulation) {
/*  4295 */         this.target = param2Generic;
/*  4296 */         this.typeDescription = param2TypeDescription;
/*  4297 */         this.deserialization = param2StackManipulation;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.OffsetMapping.Target resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.OffsetMapping.Sort param2Sort) {
/*       */         StackManipulation stackManipulation;
/*  4309 */         if (!(stackManipulation = param2Assigner.assign(this.typeDescription.asGenericType(), this.target, Assigner.Typing.DYNAMIC)).isValid()) {
/*  4310 */           throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.target);
/*       */         }
/*  4312 */         return new Advice.OffsetMapping.Target.ForStackManipulation((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.deserialization, stackManipulation }));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.target.equals(((ForSerializedValue)param2Object).target) ? false : (!this.typeDescription.equals(((ForSerializedValue)param2Object).typeDescription) ? false : (!!this.deserialization.equals(((ForSerializedValue)param2Object).deserialization))))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.typeDescription.hashCode()) * 31 + this.deserialization.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Factory<T extends Annotation>
/*       */         implements Advice.OffsetMapping.Factory<T>
/*       */       {
/*       */         private final Class<T> annotationType;
/*       */ 
/*       */         
/*       */         private final TypeDescription typeDescription;
/*       */ 
/*       */         
/*       */         private final StackManipulation deserialization;
/*       */ 
/*       */ 
/*       */         
/*       */         protected Factory(Class<T> param3Class, TypeDescription param3TypeDescription, StackManipulation param3StackManipulation) {
/*  4346 */           this.annotationType = param3Class;
/*  4347 */           this.typeDescription = param3TypeDescription;
/*  4348 */           this.deserialization = param3StackManipulation;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static <S extends Annotation> Advice.OffsetMapping.Factory<S> of(Class<S> param3Class, Serializable param3Serializable, Class<?> param3Class1) {
/*  4361 */           if (!param3Class1.isInstance(param3Serializable)) {
/*  4362 */             throw new IllegalArgumentException(param3Serializable + " is no instance of " + param3Class1);
/*       */           }
/*  4364 */           return new Factory<S>(param3Class, TypeDescription.ForLoadedType.of(param3Class1), SerializedConstant.of(param3Serializable));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<T> getAnnotationType() {
/*  4371 */           return this.annotationType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.OffsetMapping make(ParameterDescription.InDefinedShape param3InDefinedShape, AnnotationDescription.Loadable<T> param3Loadable, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  4378 */           return new Advice.OffsetMapping.ForSerializedValue(param3InDefinedShape.getType(), this.typeDescription, this.deserialization);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationType.equals(((Factory)param3Object).annotationType) ? false : (!this.typeDescription.equals(((Factory)param3Object).typeDescription) ? false : (!!this.deserialization.equals(((Factory)param3Object).deserialization))))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.typeDescription.hashCode()) * 31 + this.deserialization.hashCode();
/*       */         }
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface ArgumentHandler
/*       */   {
/*       */     public static final int THIS_REFERENCE = 0;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     int argument(int param1Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     int exit();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     int enter();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     int named(String param1String);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     int returned();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     int thrown();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ForInstrumentedMethod
/*       */       extends ArgumentHandler
/*       */     {
/*       */       int variable(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       int prepare(MethodVisitor param2MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Advice.ArgumentHandler.ForAdvice bindEnter(MethodDescription param2MethodDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Advice.ArgumentHandler.ForAdvice bindExit(MethodDescription param2MethodDescription, boolean param2Boolean);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       boolean isCopyingArguments();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       List<TypeDescription> getNamedTypes();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static abstract class Default
/*       */         implements ForInstrumentedMethod
/*       */       {
/*       */         protected final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final TypeDefinition exitType;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final SortedMap<String, TypeDefinition> namedTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final TypeDefinition enterType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Default(MethodDescription param3MethodDescription, TypeDefinition param3TypeDefinition1, SortedMap<String, TypeDefinition> param3SortedMap, TypeDefinition param3TypeDefinition2) {
/*  4527 */           this.instrumentedMethod = param3MethodDescription;
/*  4528 */           this.namedTypes = param3SortedMap;
/*  4529 */           this.exitType = param3TypeDefinition1;
/*  4530 */           this.enterType = param3TypeDefinition2;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int exit() {
/*  4537 */           return this.instrumentedMethod.getStackSize();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int named(String param3String) {
/*  4544 */           return this.instrumentedMethod.getStackSize() + this.exitType
/*  4545 */             .getStackSize().getSize() + 
/*  4546 */             StackSize.of(this.namedTypes.headMap(param3String).values());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int enter() {
/*  4553 */           return this.instrumentedMethod.getStackSize() + this.exitType
/*  4554 */             .getStackSize().getSize() + 
/*  4555 */             StackSize.of(this.namedTypes.values());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int returned() {
/*  4562 */           return this.instrumentedMethod.getStackSize() + this.exitType
/*  4563 */             .getStackSize().getSize() + 
/*  4564 */             StackSize.of(this.namedTypes.values()) + this.enterType
/*  4565 */             .getStackSize().getSize();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int thrown() {
/*  4572 */           return this.instrumentedMethod.getStackSize() + this.exitType
/*  4573 */             .getStackSize().getSize() + 
/*  4574 */             StackSize.of(this.namedTypes.values()) + this.enterType
/*  4575 */             .getStackSize().getSize() + this.instrumentedMethod
/*  4576 */             .getReturnType().getStackSize().getSize();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.ArgumentHandler.ForAdvice bindEnter(MethodDescription param3MethodDescription) {
/*  4583 */           return new Advice.ArgumentHandler.ForAdvice.Default.ForMethodEnter(this.instrumentedMethod, param3MethodDescription, this.exitType, this.namedTypes);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.ArgumentHandler.ForAdvice bindExit(MethodDescription param3MethodDescription, boolean param3Boolean) {
/*  4590 */           return new Advice.ArgumentHandler.ForAdvice.Default.ForMethodExit(this.instrumentedMethod, param3MethodDescription, this.exitType, this.namedTypes, this.enterType, param3Boolean ? StackSize.ZERO : StackSize.SINGLE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public List<TypeDescription> getNamedTypes() {
/*  4602 */           ArrayList<TypeDescription> arrayList = new ArrayList(this.namedTypes.size());
/*  4603 */           for (TypeDefinition typeDefinition : this.namedTypes.values()) {
/*  4604 */             arrayList.add(typeDefinition.asErasure());
/*       */           }
/*  4606 */           return arrayList;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class Simple
/*       */           extends Default
/*       */         {
/*       */           protected Simple(MethodDescription param4MethodDescription, TypeDefinition param4TypeDefinition1, SortedMap<String, TypeDefinition> param4SortedMap, TypeDefinition param4TypeDefinition2) {
/*  4627 */             super(param4MethodDescription, param4TypeDefinition1, param4SortedMap, param4TypeDefinition2);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int argument(int param4Int) {
/*  4634 */             return (param4Int < this.instrumentedMethod.getStackSize()) ? param4Int : (param4Int + this.exitType
/*       */               
/*  4636 */               .getStackSize().getSize() + StackSize.of(this.namedTypes.values()) + this.enterType.getStackSize().getSize());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int variable(int param4Int) {
/*  4643 */             return (param4Int < (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size()) ? param4Int : (param4Int + (
/*       */               
/*  4645 */               this.exitType.represents(void.class) ? 0 : 1) + this.namedTypes.size() + (this.enterType.represents(void.class) ? 0 : 1));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCopyingArguments() {
/*  4652 */             return false;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int prepare(MethodVisitor param4MethodVisitor) {
/*  4659 */             return 0;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : (!(getClass() != param4Object.getClass())));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class Copying
/*       */           extends Default
/*       */         {
/*       */           protected Copying(MethodDescription param4MethodDescription, TypeDefinition param4TypeDefinition1, SortedMap<String, TypeDefinition> param4SortedMap, TypeDefinition param4TypeDefinition2) {
/*  4681 */             super(param4MethodDescription, param4TypeDefinition1, param4SortedMap, param4TypeDefinition2);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int argument(int param4Int) {
/*  4688 */             return this.instrumentedMethod.getStackSize() + this.exitType
/*  4689 */               .getStackSize().getSize() + 
/*  4690 */               StackSize.of(this.namedTypes.values()) + this.enterType
/*  4691 */               .getStackSize().getSize() + param4Int;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int variable(int param4Int) {
/*  4699 */             return (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod
/*  4700 */               .getParameters().size() + (
/*  4701 */               this.exitType.represents(void.class) ? 0 : 1) + this.namedTypes
/*  4702 */               .size() + (
/*  4703 */               this.enterType.represents(void.class) ? 0 : 1) + param4Int;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCopyingArguments() {
/*  4711 */             return true;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int prepare(MethodVisitor param4MethodVisitor) {
/*       */             StackSize stackSize;
/*  4719 */             if (!this.instrumentedMethod.isStatic()) {
/*  4720 */               param4MethodVisitor.visitVarInsn(25, 0);
/*  4721 */               param4MethodVisitor.visitVarInsn(58, this.instrumentedMethod.getStackSize() + this.exitType
/*  4722 */                   .getStackSize().getSize() + 
/*  4723 */                   StackSize.of(this.namedTypes.values()) + this.enterType
/*  4724 */                   .getStackSize().getSize());
/*  4725 */               stackSize = StackSize.SINGLE;
/*       */             } else {
/*  4727 */               stackSize = StackSize.ZERO;
/*       */             } 
/*  4729 */             for (Iterator<ParameterDescription> iterator = this.instrumentedMethod.getParameters().iterator(); iterator.hasNext(); ) {
/*  4730 */               ParameterDescription parameterDescription; Type type = Type.getType((parameterDescription = iterator.next()).getType().asErasure().getDescriptor());
/*  4731 */               param4MethodVisitor.visitVarInsn(type.getOpcode(21), parameterDescription.getOffset());
/*  4732 */               param4MethodVisitor.visitVarInsn(type.getOpcode(54), this.instrumentedMethod.getStackSize() + this.exitType
/*  4733 */                   .getStackSize().getSize() + 
/*  4734 */                   StackSize.of(this.namedTypes.values()) + this.enterType
/*  4735 */                   .getStackSize().getSize() + parameterDescription
/*  4736 */                   .getOffset());
/*  4737 */               stackSize = stackSize.maximum(parameterDescription.getType().getStackSize());
/*       */             } 
/*  4739 */             return stackSize.getSize();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : (!(getClass() != param4Object.getClass())));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ForAdvice
/*       */       extends ArgumentHandler
/*       */     {
/*       */       int mapped(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static abstract class Default
/*       */         implements ForAdvice
/*       */       {
/*       */         protected final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */         
/*       */         protected final MethodDescription adviceMethod;
/*       */ 
/*       */ 
/*       */         
/*       */         protected final TypeDefinition exitType;
/*       */ 
/*       */ 
/*       */         
/*       */         protected final SortedMap<String, TypeDefinition> namedTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Default(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, TypeDefinition param3TypeDefinition, SortedMap<String, TypeDefinition> param3SortedMap) {
/*  4795 */           this.instrumentedMethod = param3MethodDescription1;
/*  4796 */           this.adviceMethod = param3MethodDescription2;
/*  4797 */           this.exitType = param3TypeDefinition;
/*  4798 */           this.namedTypes = param3SortedMap;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int argument(int param3Int) {
/*  4805 */           return param3Int;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int exit() {
/*  4812 */           return this.instrumentedMethod.getStackSize();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int named(String param3String) {
/*  4819 */           return this.instrumentedMethod.getStackSize() + this.exitType
/*  4820 */             .getStackSize().getSize() + 
/*  4821 */             StackSize.of(this.namedTypes.headMap(param3String).values());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int enter() {
/*  4828 */           return this.instrumentedMethod.getStackSize() + this.exitType
/*  4829 */             .getStackSize().getSize() + 
/*  4830 */             StackSize.of(this.namedTypes.values());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class ForMethodEnter
/*       */           extends Default
/*       */         {
/*       */           protected ForMethodEnter(MethodDescription param4MethodDescription1, MethodDescription param4MethodDescription2, TypeDefinition param4TypeDefinition, SortedMap<String, TypeDefinition> param4SortedMap) {
/*  4851 */             super(param4MethodDescription1, param4MethodDescription2, param4TypeDefinition, param4SortedMap);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int returned() {
/*  4858 */             throw new IllegalStateException("Cannot resolve the return value offset during enter advice");
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int thrown() {
/*  4865 */             throw new IllegalStateException("Cannot resolve the thrown value offset during enter advice");
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int mapped(int param4Int) {
/*  4872 */             return this.instrumentedMethod.getStackSize() + this.exitType
/*  4873 */               .getStackSize().getSize() + 
/*  4874 */               StackSize.of(this.namedTypes.values()) - this.adviceMethod
/*  4875 */               .getStackSize() + param4Int;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : (!(getClass() != param4Object.getClass())));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class ForMethodExit
/*       */           extends Default
/*       */         {
/*       */           private final TypeDefinition enterType;
/*       */ 
/*       */ 
/*       */           
/*       */           private final StackSize throwableSize;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ForMethodExit(MethodDescription param4MethodDescription1, MethodDescription param4MethodDescription2, TypeDefinition param4TypeDefinition1, SortedMap<String, TypeDefinition> param4SortedMap, TypeDefinition param4TypeDefinition2, StackSize param4StackSize) {
/*  4911 */             super(param4MethodDescription1, param4MethodDescription2, param4TypeDefinition1, param4SortedMap);
/*  4912 */             this.enterType = param4TypeDefinition2;
/*  4913 */             this.throwableSize = param4StackSize;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int returned() {
/*  4920 */             return this.instrumentedMethod.getStackSize() + this.exitType
/*  4921 */               .getStackSize().getSize() + 
/*  4922 */               StackSize.of(this.namedTypes.values()) + this.enterType
/*  4923 */               .getStackSize().getSize();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int thrown() {
/*  4930 */             return this.instrumentedMethod.getStackSize() + this.exitType
/*  4931 */               .getStackSize().getSize() + 
/*  4932 */               StackSize.of(this.namedTypes.values()) + this.enterType
/*  4933 */               .getStackSize().getSize() + this.instrumentedMethod
/*  4934 */               .getReturnType().getStackSize().getSize();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int mapped(int param4Int) {
/*  4941 */             return this.instrumentedMethod.getStackSize() + this.exitType
/*  4942 */               .getStackSize().getSize() + 
/*  4943 */               StackSize.of(this.namedTypes.values()) + this.enterType
/*  4944 */               .getStackSize().getSize() + this.instrumentedMethod
/*  4945 */               .getReturnType().getStackSize().getSize() + this.throwableSize
/*  4946 */               .getSize() - this.adviceMethod
/*  4947 */               .getStackSize() + param4Int;
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.throwableSize.equals(((ForMethodExit)param4Object).throwableSize) ? false : (!!this.enterType.equals(((ForMethodExit)param4Object).enterType)))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return (getClass().hashCode() * 31 + this.enterType.hashCode()) * 31 + this.throwableSize.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */     
/*       */     public enum Factory {
/*  4962 */       SIMPLE
/*       */       {
/*       */ 
/*       */         
/*       */         protected final Advice.ArgumentHandler.ForInstrumentedMethod resolve(MethodDescription param3MethodDescription, TypeDefinition param3TypeDefinition1, TypeDefinition param3TypeDefinition2, SortedMap<String, TypeDefinition> param3SortedMap)
/*       */         {
/*  4968 */           return new Advice.ArgumentHandler.ForInstrumentedMethod.Default.Simple(param3MethodDescription, param3TypeDefinition2, param3SortedMap, param3TypeDefinition1);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  4978 */       COPYING
/*       */       {
/*       */ 
/*       */         
/*       */         protected final Advice.ArgumentHandler.ForInstrumentedMethod resolve(MethodDescription param3MethodDescription, TypeDefinition param3TypeDefinition1, TypeDefinition param3TypeDefinition2, SortedMap<String, TypeDefinition> param3SortedMap)
/*       */         {
/*  4984 */           return new Advice.ArgumentHandler.ForInstrumentedMethod.Default.Copying(param3MethodDescription, param3TypeDefinition2, param3SortedMap, param3TypeDefinition1);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract Advice.ArgumentHandler.ForInstrumentedMethod resolve(MethodDescription param2MethodDescription, TypeDefinition param2TypeDefinition1, TypeDefinition param2TypeDefinition2, SortedMap<String, TypeDefinition> param2SortedMap);
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface Factory
/*       */   {
/*       */     Advice.PostProcessor make(MethodDescription.InDefinedShape param1InDefinedShape, boolean param1Boolean);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Compound
/*       */       implements Factory
/*       */     {
/*       */       public Compound(Advice.PostProcessor.Factory... param3VarArgs) {
/*  5075 */         this(Arrays.asList(param3VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5084 */       private final List<Advice.PostProcessor.Factory> factories = new ArrayList<Advice.PostProcessor.Factory>(); public Compound(List<? extends Advice.PostProcessor.Factory> param3List) {
/*  5085 */         for (Iterator<? extends Advice.PostProcessor.Factory> iterator = param3List.iterator(); iterator.hasNext(); ) {
/*  5086 */           Advice.PostProcessor.Factory factory; if (factory = iterator.next() instanceof Compound) {
/*  5087 */             this.factories.addAll(((Compound)factory).factories); continue;
/*  5088 */           }  if (!(factory instanceof Advice.PostProcessor.NoOp)) {
/*  5089 */             this.factories.add(factory);
/*       */           }
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.PostProcessor make(MethodDescription.InDefinedShape param3InDefinedShape, boolean param3Boolean) {
/*  5098 */         ArrayList<Advice.PostProcessor> arrayList = new ArrayList(this.factories.size());
/*  5099 */         for (Advice.PostProcessor.Factory factory : this.factories) {
/*  5100 */           arrayList.add(factory.make(param3InDefinedShape, param3Boolean));
/*       */         }
/*  5102 */         return new Advice.PostProcessor.Compound(arrayList);
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param3Object) {
/*       */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.factories.equals(((Compound)param3Object).factories))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.factories.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*  5115 */   public enum NoOp implements PostProcessor, PostProcessor.Factory { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final StackManipulation resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Advice.ArgumentHandler param1ArgumentHandler, Advice.StackMapFrameHandler.ForPostProcessor param1ForPostProcessor, StackManipulation param1StackManipulation) {
/*  5126 */       return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public final Advice.PostProcessor make(MethodDescription.InDefinedShape param1InDefinedShape, boolean param1Boolean)
/*       */     {
/*  5133 */       return this; } } public static interface PostProcessor { StackManipulation resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Advice.ArgumentHandler param1ArgumentHandler, Advice.StackMapFrameHandler.ForPostProcessor param1ForPostProcessor, StackManipulation param1StackManipulation); public static interface Factory { Advice.PostProcessor make(MethodDescription.InDefinedShape param2InDefinedShape, boolean param2Boolean); @Enhance public static class Compound implements Factory { public Compound(Advice.PostProcessor.Factory... param3VarArgs) { this(Arrays.asList(param3VarArgs)); } private final List<Advice.PostProcessor.Factory> factories = new ArrayList<Advice.PostProcessor.Factory>(); public Compound(List<? extends Advice.PostProcessor.Factory> param3List) { for (Iterator<? extends Advice.PostProcessor.Factory> iterator = param3List.iterator(); iterator.hasNext(); ) { Advice.PostProcessor.Factory factory; if (factory = iterator.next() instanceof Compound) { this.factories.addAll(((Compound)factory).factories); continue; }  if (!(factory instanceof Advice.PostProcessor.NoOp)) this.factories.add(factory);  }  } public Advice.PostProcessor make(MethodDescription.InDefinedShape param3InDefinedShape, boolean param3Boolean) { ArrayList<Advice.PostProcessor> arrayList = new ArrayList(this.factories.size()); for (Advice.PostProcessor.Factory factory : this.factories) arrayList.add(factory.make(param3InDefinedShape, param3Boolean));  return new Advice.PostProcessor.Compound(arrayList); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.factories.equals(((Compound)param3Object).factories)))); } public int hashCode() { return getClass().hashCode() * 31 + this.factories.hashCode(); } } } public enum NoOp implements PostProcessor, Factory { INSTANCE; public final StackManipulation resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.StackMapFrameHandler.ForPostProcessor param2ForPostProcessor, StackManipulation param2StackManipulation) { return (StackManipulation)StackManipulation.Trivial.INSTANCE; } public final Advice.PostProcessor make(MethodDescription.InDefinedShape param2InDefinedShape, boolean param2Boolean) { return this; }
/*       */        }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Compound
/*       */       implements PostProcessor
/*       */     {
/*       */       private final List<Advice.PostProcessor> postProcessors;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Compound(List<Advice.PostProcessor> param2List) {
/*  5154 */         this.postProcessors = param2List;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackManipulation resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, Advice.StackMapFrameHandler.ForPostProcessor param2ForPostProcessor, StackManipulation param2StackManipulation) {
/*  5166 */         ArrayList<StackManipulation> arrayList = new ArrayList(this.postProcessors.size());
/*  5167 */         for (Advice.PostProcessor postProcessor : this.postProcessors) {
/*  5168 */           arrayList.add(postProcessor.resolve(param2TypeDescription, param2MethodDescription, param2Assigner, param2ArgumentHandler, param2ForPostProcessor, param2StackManipulation));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  5175 */         return (StackManipulation)new StackManipulation.Compound(arrayList);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.postProcessors.equals(((Compound)param2Object).postProcessors))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.postProcessors.hashCode();
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public enum ForStaticInvocation
/*       */     implements Delegator
/*       */   {
/*  5208 */     INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final void apply(MethodVisitor param1MethodVisitor, MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, boolean param1Boolean)
/*       */     {
/*  5218 */       param1MethodVisitor.visitMethodInsn(184, param1InDefinedShape
/*  5219 */           .getDeclaringType().getInternalName(), param1InDefinedShape
/*  5220 */           .getInternalName(), param1InDefinedShape
/*  5221 */           .getDescriptor(), false); } } protected static interface Delegator { void apply(MethodVisitor param1MethodVisitor, MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, boolean param1Boolean); public enum ForStaticInvocation implements Delegator { INSTANCE; public final void apply(MethodVisitor param2MethodVisitor, MethodDescription.InDefinedShape param2InDefinedShape, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, boolean param2Boolean) { param2MethodVisitor.visitMethodInsn(184, param2InDefinedShape.getDeclaringType().getInternalName(), param2InDefinedShape.getInternalName(), param2InDefinedShape.getDescriptor(), false); }
/*       */        }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForDynamicInvocation
/*       */       implements Delegator
/*       */     {
/*       */       private final MethodDescription.InDefinedShape bootstrapMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForDynamicInvocation(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  5243 */         this.bootstrapMethod = param2InDefinedShape;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static Advice.Delegator of(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  5253 */         if (!param2InDefinedShape.isInvokeBootstrap()) {
/*  5254 */           throw new IllegalArgumentException("Not a suitable bootstrap target: " + param2InDefinedShape);
/*       */         }
/*  5256 */         return new ForDynamicInvocation(param2InDefinedShape);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void apply(MethodVisitor param2MethodVisitor, MethodDescription.InDefinedShape param2InDefinedShape, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, boolean param2Boolean) {
/*       */         Object[] arrayOfObject;
/*  5268 */         if (param2MethodDescription.isTypeInitializer()) {
/*  5269 */           if (!this.bootstrapMethod.isInvokeBootstrap(Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(String.class), 
/*  5270 */                   TypeDescription.ForLoadedType.of(int.class), 
/*  5271 */                   TypeDescription.ForLoadedType.of(Class.class), 
/*  5272 */                   TypeDescription.ForLoadedType.of(String.class) }))) {
/*  5273 */             throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments");
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*  5278 */           arrayOfObject = new Object[] { param2InDefinedShape.getDeclaringType().getName(), Integer.valueOf(param2Boolean ? 1 : 0), Type.getType(param2TypeDescription.getDescriptor()), param2MethodDescription.getInternalName() };
/*       */         } else {
/*  5280 */           if (!this.bootstrapMethod.isInvokeBootstrap(Arrays.asList(new TypeDescription[] { TypeDescription.ForLoadedType.of(String.class), 
/*  5281 */                   TypeDescription.ForLoadedType.of(int.class), 
/*  5282 */                   TypeDescription.ForLoadedType.of(Class.class), 
/*  5283 */                   TypeDescription.ForLoadedType.of(String.class), JavaType.METHOD_HANDLE
/*  5284 */                   .getTypeStub() }))) {
/*  5285 */             throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments");
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  5291 */           arrayOfObject = new Object[] { param2InDefinedShape.getDeclaringType().getName(), Integer.valueOf(param2Boolean ? 1 : 0), Type.getType(arrayOfObject.getDescriptor()), param2MethodDescription.getInternalName(), JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape)param2MethodDescription.asDefined()).accept((JavaConstant.Visitor)JavaConstantValue.Visitor.INSTANCE) };
/*       */         } 
/*  5293 */         param2MethodVisitor.visitInvokeDynamicInsn(param2InDefinedShape.getInternalName(), param2InDefinedShape
/*  5294 */             .getDescriptor(), new Handle(
/*  5295 */               this.bootstrapMethod.isConstructor() ? 8 : 6, this.bootstrapMethod
/*  5296 */               .getDeclaringType().getInternalName(), this.bootstrapMethod
/*  5297 */               .getInternalName(), this.bootstrapMethod
/*  5298 */               .getDescriptor(), false), arrayOfObject);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.bootstrapMethod.equals(((ForDynamicInvocation)param2Object).bootstrapMethod))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.bootstrapMethod.hashCode();
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   protected static interface MethodSizeHandler
/*       */   {
/*       */     public static final int UNDEFINED_SIZE = 32767;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void requireStackSize(int param1Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void requireLocalVariableLength(int param1Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ForInstrumentedMethod
/*       */       extends MethodSizeHandler
/*       */     {
/*       */       Advice.MethodSizeHandler.ForAdvice bindEnter(MethodDescription.InDefinedShape param2InDefinedShape);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Advice.MethodSizeHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param2InDefinedShape);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       int compoundStackSize(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       int compoundLocalVariableLength(int param2Int);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ForAdvice
/*       */       extends MethodSizeHandler
/*       */     {
/*       */       void requireStackSizePadding(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void requireLocalVariableLengthPadding(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void recordMaxima(int param2Int1, int param2Int2);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements ForAdvice, ForInstrumentedMethod
/*       */     {
/*  5404 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.MethodSizeHandler.ForAdvice bindEnter(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  5410 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.MethodSizeHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  5417 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final int compoundStackSize(int param2Int) {
/*  5424 */         return 32767;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final int compoundLocalVariableLength(int param2Int) {
/*  5431 */         return 32767;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void requireStackSize(int param2Int) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void requireLocalVariableLength(int param2Int) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void requireStackSizePadding(int param2Int) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void requireLocalVariableLengthPadding(int param2Int) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void recordMaxima(int param2Int1, int param2Int2) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class Default
/*       */       implements ForInstrumentedMethod
/*       */     {
/*       */       protected final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends TypeDescription> initialTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends TypeDescription> preMethodTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends TypeDescription> postMethodTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected int stackSize;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected int localVariableLength;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Default(MethodDescription param2MethodDescription, List<? extends TypeDescription> param2List1, List<? extends TypeDescription> param2List2, List<? extends TypeDescription> param2List3) {
/*  5517 */         this.instrumentedMethod = param2MethodDescription;
/*  5518 */         this.initialTypes = param2List1;
/*  5519 */         this.preMethodTypes = param2List2;
/*  5520 */         this.postMethodTypes = param2List3;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static Advice.MethodSizeHandler.ForInstrumentedMethod of(MethodDescription param2MethodDescription, List<? extends TypeDescription> param2List1, List<? extends TypeDescription> param2List2, List<? extends TypeDescription> param2List3, boolean param2Boolean, int param2Int) {
/*  5540 */         if ((param2Int & 0x3) != 0)
/*  5541 */           return Advice.MethodSizeHandler.NoOp.INSTANCE; 
/*  5542 */         if (param2Boolean) {
/*  5543 */           return new WithCopiedArguments(param2MethodDescription, param2List1, param2List2, param2List3);
/*       */         }
/*  5545 */         return new WithRetainedArguments(param2MethodDescription, param2List1, param2List2, param2List3);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.MethodSizeHandler.ForAdvice bindEnter(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  5553 */         return new ForAdvice(this, param2InDefinedShape, this.instrumentedMethod.getStackSize() + StackSize.of(this.initialTypes));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void requireStackSize(int param2Int) {
/*  5560 */         this.stackSize = Math.max(this.stackSize, param2Int);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void requireLocalVariableLength(int param2Int) {
/*  5567 */         this.localVariableLength = Math.max(this.localVariableLength, param2Int);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int compoundStackSize(int param2Int) {
/*  5574 */         return Math.max(this.stackSize, param2Int);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int compoundLocalVariableLength(int param2Int) {
/*  5581 */         return Math.max(this.localVariableLength, param2Int + 
/*  5582 */             StackSize.of(this.postMethodTypes) + 
/*  5583 */             StackSize.of(this.initialTypes) + 
/*  5584 */             StackSize.of(this.preMethodTypes));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class WithRetainedArguments
/*       */         extends Default
/*       */       {
/*       */         protected WithRetainedArguments(MethodDescription param3MethodDescription, List<? extends TypeDescription> param3List1, List<? extends TypeDescription> param3List2, List<? extends TypeDescription> param3List3) {
/*  5604 */           super(param3MethodDescription, param3List1, param3List2, param3List3);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.MethodSizeHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  5611 */           return new Advice.MethodSizeHandler.Default.ForAdvice(this, param3InDefinedShape, this.instrumentedMethod.getStackSize() + 
/*  5612 */               StackSize.of(this.postMethodTypes) + 
/*  5613 */               StackSize.of(this.initialTypes) + 
/*  5614 */               StackSize.of(this.preMethodTypes));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int compoundLocalVariableLength(int param3Int) {
/*  5621 */           return Math.max(this.localVariableLength, param3Int + 
/*  5622 */               StackSize.of(this.postMethodTypes) + 
/*  5623 */               StackSize.of(this.initialTypes) + 
/*  5624 */               StackSize.of(this.preMethodTypes));
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class WithCopiedArguments
/*       */         extends Default
/*       */       {
/*       */         protected WithCopiedArguments(MethodDescription param3MethodDescription, List<? extends TypeDescription> param3List1, List<? extends TypeDescription> param3List2, List<? extends TypeDescription> param3List3) {
/*  5645 */           super(param3MethodDescription, param3List1, param3List2, param3List3);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.MethodSizeHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  5652 */           return new Advice.MethodSizeHandler.Default.ForAdvice(this, param3InDefinedShape, 2 * this.instrumentedMethod.getStackSize() + 
/*  5653 */               StackSize.of(this.initialTypes) + 
/*  5654 */               StackSize.of(this.preMethodTypes) + 
/*  5655 */               StackSize.of(this.postMethodTypes));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int compoundLocalVariableLength(int param3Int) {
/*  5662 */           return Math.max(this.localVariableLength, param3Int + this.instrumentedMethod
/*  5663 */               .getStackSize() + 
/*  5664 */               StackSize.of(this.postMethodTypes) + 
/*  5665 */               StackSize.of(this.initialTypes) + 
/*  5666 */               StackSize.of(this.preMethodTypes));
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected class ForAdvice
/*       */         implements Advice.MethodSizeHandler.ForAdvice
/*       */       {
/*       */         private final MethodDescription.InDefinedShape adviceMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int baseLocalVariableLength;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private int stackSizePadding;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private int localVariableLengthPadding;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForAdvice(Advice.MethodSizeHandler.Default this$0, MethodDescription.InDefinedShape param3InDefinedShape, int param3Int) {
/*  5703 */           this.adviceMethod = param3InDefinedShape;
/*  5704 */           this.baseLocalVariableLength = param3Int;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void requireStackSize(int param3Int) {
/*  5711 */           this.a.requireStackSize(param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void requireLocalVariableLength(int param3Int) {
/*  5718 */           this.a.requireLocalVariableLength(param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void requireStackSizePadding(int param3Int) {
/*  5725 */           this.stackSizePadding = Math.max(this.stackSizePadding, param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void requireLocalVariableLengthPadding(int param3Int) {
/*  5732 */           this.localVariableLengthPadding = Math.max(this.localVariableLengthPadding, param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void recordMaxima(int param3Int1, int param3Int2) {
/*  5739 */           this.a.requireStackSize(param3Int1 + this.stackSizePadding);
/*  5740 */           this.a.requireLocalVariableLength(param3Int2 - this.adviceMethod
/*  5741 */               .getStackSize() + this.baseLocalVariableLength + this.localVariableLengthPadding);
/*       */         }
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface StackMapFrameHandler
/*       */   {
/*       */     void translateFrame(MethodVisitor param1MethodVisitor, int param1Int1, int param1Int2, @MaybeNull Object[] param1ArrayOfObject1, int param1Int3, @MaybeNull Object[] param1ArrayOfObject2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void injectReturnFrame(MethodVisitor param1MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void injectExceptionFrame(MethodVisitor param1MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void injectCompletionFrame(MethodVisitor param1MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ForPostProcessor
/*       */     {
/*       */       void injectIntermediateFrame(MethodVisitor param2MethodVisitor, List<? extends TypeDescription> param2List);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ForInstrumentedMethod
/*       */       extends StackMapFrameHandler
/*       */     {
/*       */       Advice.StackMapFrameHandler.ForAdvice bindEnter(MethodDescription.InDefinedShape param2InDefinedShape);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Advice.StackMapFrameHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param2InDefinedShape);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       int getReaderHint();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void injectInitializationFrame(MethodVisitor param2MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void injectStartFrame(MethodVisitor param2MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void injectPostCompletionFrame(MethodVisitor param2MethodVisitor);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ForAdvice
/*       */       extends StackMapFrameHandler, ForPostProcessor {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements ForAdvice, ForInstrumentedMethod
/*       */     {
/*  5872 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.StackMapFrameHandler.ForAdvice bindEnter(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  5878 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.StackMapFrameHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  5885 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final int getReaderHint() {
/*  5892 */         return 4;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void translateFrame(MethodVisitor param2MethodVisitor, int param2Int1, int param2Int2, @MaybeNull Object[] param2ArrayOfObject1, int param2Int3, @MaybeNull Object[] param2ArrayOfObject2) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void injectReturnFrame(MethodVisitor param2MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void injectExceptionFrame(MethodVisitor param2MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void injectCompletionFrame(MethodVisitor param2MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void injectInitializationFrame(MethodVisitor param2MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void injectStartFrame(MethodVisitor param2MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void injectPostCompletionFrame(MethodVisitor param2MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void injectIntermediateFrame(MethodVisitor param2MethodVisitor, List<? extends TypeDescription> param2List) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class Default
/*       */       implements ForInstrumentedMethod
/*       */     {
/*  5965 */       protected static final Object[] EMPTY = new Object[0];
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final TypeDescription instrumentedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends TypeDescription> initialTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends TypeDescription> latentTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends TypeDescription> preMethodTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends TypeDescription> postMethodTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final boolean expandFrames;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected int currentFrameDivergence;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Default(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, List<? extends TypeDescription> param2List1, List<? extends TypeDescription> param2List2, List<? extends TypeDescription> param2List3, List<? extends TypeDescription> param2List4, boolean param2Boolean) {
/*  6025 */         this.instrumentedType = param2TypeDescription;
/*  6026 */         this.instrumentedMethod = param2MethodDescription;
/*  6027 */         this.initialTypes = param2List1;
/*  6028 */         this.latentTypes = param2List2;
/*  6029 */         this.preMethodTypes = param2List3;
/*  6030 */         this.postMethodTypes = param2List4;
/*  6031 */         this.expandFrames = param2Boolean;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static Advice.StackMapFrameHandler.ForInstrumentedMethod of(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, List<? extends TypeDescription> param2List1, List<? extends TypeDescription> param2List2, List<? extends TypeDescription> param2List3, List<? extends TypeDescription> param2List4, boolean param2Boolean1, boolean param2Boolean2, ClassFileVersion param2ClassFileVersion, int param2Int1, int param2Int2) {
/*  6061 */         if ((param2Int1 & 0x2) != 0 || param2ClassFileVersion.isLessThan(ClassFileVersion.JAVA_V6))
/*  6062 */           return Advice.StackMapFrameHandler.NoOp.INSTANCE; 
/*  6063 */         if (!param2Boolean1 && param2List1.isEmpty()) {
/*  6064 */           return new Trivial(param2TypeDescription, param2MethodDescription, param2List2, ((param2Int2 & 0x8) != 0));
/*       */         }
/*       */ 
/*       */         
/*  6068 */         if (param2Boolean2) {
/*  6069 */           return new WithPreservedArguments.WithArgumentCopy(param2TypeDescription, param2MethodDescription, param2List1, param2List2, param2List3, param2List4, ((param2Int2 & 0x8) != 0));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6077 */         return new WithPreservedArguments.WithoutArgumentCopy(param2TypeDescription, param2MethodDescription, param2List1, param2List2, param2List3, param2List4, ((param2Int2 & 0x8) != 0), 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  6084 */             !param2MethodDescription.isConstructor());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.StackMapFrameHandler.ForAdvice bindEnter(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  6092 */         return new ForAdvice(this, param2InDefinedShape, this.initialTypes, this.latentTypes, this.preMethodTypes, TranslationMode.ENTER, this.instrumentedMethod.isConstructor() ? Initialization.UNITIALIZED : Initialization.INITIALIZED);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getReaderHint() {
/*  6101 */         return this.expandFrames ? 8 : 0;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected void translateFrame(MethodVisitor param2MethodVisitor, TranslationMode param2TranslationMode, MethodDescription param2MethodDescription, List<? extends TypeDescription> param2List, int param2Int1, int param2Int2, @MaybeNull Object[] param2ArrayOfObject1, int param2Int3, @MaybeNull Object[] param2ArrayOfObject2) {
/*       */         int i;
/*       */         byte b1, b2;
/*       */         Object[] arrayOfObject;
/*  6128 */         switch (param2Int1) {
/*       */           case 3:
/*       */           case 4:
/*       */             break;
/*       */           case 1:
/*  6133 */             this.currentFrameDivergence += param2Int2;
/*       */             break;
/*       */           case 2:
/*  6136 */             this.currentFrameDivergence -= param2Int2;
/*  6137 */             if (this.currentFrameDivergence < 0) {
/*  6138 */               throw new IllegalStateException(param2MethodDescription + " dropped " + Math.abs(this.currentFrameDivergence) + " implicit frames");
/*       */             }
/*       */             break;
/*       */           case -1:
/*       */           case 0:
/*  6143 */             if (param2MethodDescription.getParameters().size() + (param2MethodDescription.isStatic() ? 0 : 1) > param2Int2) {
/*  6144 */               throw new IllegalStateException("Inconsistent frame length for " + param2MethodDescription + ": " + param2Int2);
/*       */             }
/*       */             
/*  6147 */             if (param2MethodDescription.isStatic()) {
/*  6148 */               b1 = 0;
/*       */             } else {
/*  6150 */               if (!param2TranslationMode.isPossibleThisFrameValue(this.instrumentedType, this.instrumentedMethod, param2ArrayOfObject1[0])) {
/*  6151 */                 throw new IllegalStateException(param2MethodDescription + " is inconsistent for 'this' reference: " + param2ArrayOfObject1[0]);
/*       */               }
/*  6153 */               b1 = 1;
/*       */             } 
/*  6155 */             for (b2 = 0; b2 < param2MethodDescription.getParameters().size(); b2++) {
/*  6156 */               if (!Initialization.INITIALIZED.toFrame(((ParameterDescription)param2MethodDescription.getParameters().get(b2)).getType().asErasure()).equals(param2ArrayOfObject1[b2 + b1])) {
/*  6157 */                 throw new IllegalStateException(param2MethodDescription + " is inconsistent at " + b2 + ": " + param2ArrayOfObject1[b2 + b1]);
/*       */               }
/*       */             } 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  6165 */             arrayOfObject = new Object[param2Int2 - (param2MethodDescription.isStatic() ? 0 : 1) - param2MethodDescription.getParameters().size() + (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size() + param2List.size()];
/*  6166 */             i = param2TranslationMode.copy(this.instrumentedType, this.instrumentedMethod, param2MethodDescription, param2ArrayOfObject1, arrayOfObject);
/*  6167 */             for (TypeDescription typeDescription : param2List) {
/*  6168 */               arrayOfObject[i++] = Initialization.INITIALIZED.toFrame(typeDescription);
/*       */             }
/*  6170 */             System.arraycopy(param2ArrayOfObject1, param2MethodDescription
/*  6171 */                 .getParameters().size() + (param2MethodDescription.isStatic() ? 0 : 1), arrayOfObject, i, arrayOfObject.length - i);
/*       */ 
/*       */ 
/*       */             
/*  6175 */             param2Int2 = arrayOfObject.length;
/*  6176 */             param2ArrayOfObject1 = arrayOfObject;
/*  6177 */             this.currentFrameDivergence = arrayOfObject.length - i;
/*       */             break;
/*       */           default:
/*  6180 */             throw new IllegalArgumentException("Unexpected frame type: " + param2Int1);
/*       */         } 
/*  6182 */         param2MethodVisitor.visitFrame(param2Int1, param2Int2, param2ArrayOfObject1, param2Int3, param2ArrayOfObject2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected void injectFullFrame(MethodVisitor param2MethodVisitor, Initialization param2Initialization, List<? extends TypeDescription> param2List1, List<? extends TypeDescription> param2List2) {
/*  6199 */         Object[] arrayOfObject2 = new Object[this.instrumentedMethod.getParameters().size() + (this.instrumentedMethod.isStatic() ? 0 : 1) + param2List1.size()];
/*  6200 */         byte b = 0;
/*  6201 */         if (!this.instrumentedMethod.isStatic()) {
/*  6202 */           b++; arrayOfObject2[0] = param2Initialization.toFrame(this.instrumentedType);
/*       */         } 
/*  6204 */         for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
/*  6205 */           arrayOfObject2[b++] = Initialization.INITIALIZED.toFrame(typeDescription);
/*       */         }
/*  6207 */         for (TypeDescription typeDescription : param2List1) {
/*  6208 */           arrayOfObject2[b++] = Initialization.INITIALIZED.toFrame(typeDescription);
/*       */         }
/*  6210 */         b = 0;
/*  6211 */         Object[] arrayOfObject1 = new Object[param2List2.size()];
/*  6212 */         for (TypeDescription typeDescription : param2List2) {
/*  6213 */           arrayOfObject1[b++] = Initialization.INITIALIZED.toFrame(typeDescription);
/*       */         }
/*  6215 */         param2MethodVisitor.visitFrame(this.expandFrames ? -1 : 0, arrayOfObject2.length, arrayOfObject2, arrayOfObject1.length, arrayOfObject1);
/*  6216 */         this.currentFrameDivergence = 0;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected enum TranslationMode
/*       */       {
/*  6227 */         COPY
/*       */         {
/*       */ 
/*       */ 
/*       */           
/*       */           protected final int copy(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription1, MethodDescription param4MethodDescription2, Object[] param4ArrayOfObject1, Object[] param4ArrayOfObject2)
/*       */           {
/*  6234 */             int i = param4MethodDescription1.getParameters().size() + (param4MethodDescription1.isStatic() ? 0 : 1);
/*  6235 */             System.arraycopy(param4ArrayOfObject1, 0, param4ArrayOfObject2, 0, i);
/*  6236 */             return i;
/*       */           }
/*       */ 
/*       */           
/*       */           protected final boolean isPossibleThisFrameValue(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Object param4Object) {
/*  6241 */             return ((param4MethodDescription.isConstructor() && Opcodes.UNINITIALIZED_THIS.equals(param4Object)) || Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(param4TypeDescription).equals(param4Object));
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6248 */         ENTER
/*       */         {
/*       */ 
/*       */ 
/*       */           
/*       */           protected final int copy(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription1, MethodDescription param4MethodDescription2, Object[] param4ArrayOfObject1, Object[] param4ArrayOfObject2)
/*       */           {
/*  6255 */             byte b = 0;
/*  6256 */             if (!param4MethodDescription1.isStatic()) {
/*  6257 */               b++; param4ArrayOfObject2[0] = param4MethodDescription1.isConstructor() ? Opcodes.UNINITIALIZED_THIS : Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
/*       */                 
/*  6259 */                 .toFrame(param4TypeDescription);
/*       */             } 
/*  6261 */             for (TypeDescription typeDescription : param4MethodDescription1.getParameters().asTypeList().asErasures()) {
/*  6262 */               param4ArrayOfObject2[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */             }
/*  6264 */             return b;
/*       */           }
/*       */ 
/*       */           
/*       */           protected final boolean isPossibleThisFrameValue(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Object param4Object) {
/*  6269 */             if (param4MethodDescription.isConstructor())
/*  6270 */               return Opcodes.UNINITIALIZED_THIS.equals(param4Object);  return Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
/*  6271 */               .toFrame(param4TypeDescription).equals(param4Object);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6278 */         EXIT
/*       */         {
/*       */ 
/*       */ 
/*       */           
/*       */           protected final int copy(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription1, MethodDescription param4MethodDescription2, Object[] param4ArrayOfObject1, Object[] param4ArrayOfObject2)
/*       */           {
/*  6285 */             byte b = 0;
/*  6286 */             if (!param4MethodDescription1.isStatic()) {
/*  6287 */               b++; param4ArrayOfObject2[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(param4TypeDescription);
/*       */             } 
/*  6289 */             for (TypeDescription typeDescription : param4MethodDescription1.getParameters().asTypeList().asErasures()) {
/*  6290 */               param4ArrayOfObject2[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */             }
/*  6292 */             return b;
/*       */           }
/*       */ 
/*       */           
/*       */           protected final boolean isPossibleThisFrameValue(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Object param4Object) {
/*  6297 */             return Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(param4TypeDescription).equals(param4Object);
/*       */           }
/*       */         };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract int copy(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2, Object[] param3ArrayOfObject1, Object[] param3ArrayOfObject2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract boolean isPossibleThisFrameValue(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Object param3Object);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected enum Initialization
/*       */       {
/*  6336 */         UNITIALIZED
/*       */         {
/*       */           
/*       */           protected final Object toFrame(TypeDescription param4TypeDescription)
/*       */           {
/*  6341 */             if (param4TypeDescription.isPrimitive()) {
/*  6342 */               throw new IllegalArgumentException("Cannot assume primitive uninitialized value: " + param4TypeDescription);
/*       */             }
/*  6344 */             return Opcodes.UNINITIALIZED_THIS;
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6351 */         INITIALIZED
/*       */         {
/*       */           
/*       */           protected final Object toFrame(TypeDescription param4TypeDescription)
/*       */           {
/*  6356 */             if (param4TypeDescription.represents(boolean.class) || param4TypeDescription
/*  6357 */               .represents(byte.class) || param4TypeDescription
/*  6358 */               .represents(short.class) || param4TypeDescription
/*  6359 */               .represents(char.class) || param4TypeDescription
/*  6360 */               .represents(int.class))
/*  6361 */               return Opcodes.INTEGER; 
/*  6362 */             if (param4TypeDescription.represents(long.class))
/*  6363 */               return Opcodes.LONG; 
/*  6364 */             if (param4TypeDescription.represents(float.class))
/*  6365 */               return Opcodes.FLOAT; 
/*  6366 */             if (param4TypeDescription.represents(double.class)) {
/*  6367 */               return Opcodes.DOUBLE;
/*       */             }
/*  6369 */             return param4TypeDescription.getInternalName();
/*       */           }
/*       */         };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract Object toFrame(TypeDescription param3TypeDescription);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class Trivial
/*       */         extends Default
/*       */       {
/*       */         protected Trivial(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, List<? extends TypeDescription> param3List, boolean param3Boolean) {
/*  6397 */           super(param3TypeDescription, param3MethodDescription, 
/*       */               
/*  6399 */               Collections.emptyList(), param3List, 
/*       */               
/*  6401 */               Collections.emptyList(), 
/*  6402 */               Collections.emptyList(), param3Boolean);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void translateFrame(MethodVisitor param3MethodVisitor, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2) {
/*  6415 */           param3MethodVisitor.visitFrame(param3Int1, param3Int2, param3ArrayOfObject1, param3Int3, param3ArrayOfObject2);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.StackMapFrameHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  6422 */           throw new IllegalStateException("Did not expect exit advice " + param3InDefinedShape + " for " + this.instrumentedMethod);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectReturnFrame(MethodVisitor param3MethodVisitor) {
/*  6429 */           throw new IllegalStateException("Did not expect return frame for " + this.instrumentedMethod);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectExceptionFrame(MethodVisitor param3MethodVisitor) {
/*  6436 */           throw new IllegalStateException("Did not expect exception frame for " + this.instrumentedMethod);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectCompletionFrame(MethodVisitor param3MethodVisitor) {
/*  6443 */           throw new IllegalStateException("Did not expect completion frame for " + this.instrumentedMethod);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectPostCompletionFrame(MethodVisitor param3MethodVisitor) {
/*  6450 */           throw new IllegalStateException("Did not expect post completion frame for " + this.instrumentedMethod);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectInitializationFrame(MethodVisitor param3MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectStartFrame(MethodVisitor param3MethodVisitor) {}
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static abstract class WithPreservedArguments
/*       */         extends Default
/*       */       {
/*       */         protected boolean allowCompactCompletionFrame;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected WithPreservedArguments(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, List<? extends TypeDescription> param3List1, List<? extends TypeDescription> param3List2, List<? extends TypeDescription> param3List3, List<? extends TypeDescription> param3List4, boolean param3Boolean1, boolean param3Boolean2) {
/*  6498 */           super(param3TypeDescription, param3MethodDescription, param3List1, param3List2, param3List3, param3List4, param3Boolean1);
/*  6499 */           this.allowCompactCompletionFrame = param3Boolean2;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"RC_REF_COMPARISON_BAD_PRACTICE"}, justification = "ASM models frames by reference identity.")
/*       */         protected void translateFrame(MethodVisitor param3MethodVisitor, Advice.StackMapFrameHandler.Default.TranslationMode param3TranslationMode, MethodDescription param3MethodDescription, List<? extends TypeDescription> param3List, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2) {
/*  6513 */           if (param3Int1 == 0 && param3Int2 > 0 && param3ArrayOfObject1[0] != Opcodes.UNINITIALIZED_THIS) {
/*  6514 */             this.allowCompactCompletionFrame = true;
/*       */           }
/*  6516 */           super.translateFrame(param3MethodVisitor, param3TranslationMode, param3MethodDescription, param3List, param3Int1, param3Int2, param3ArrayOfObject1, param3Int3, param3ArrayOfObject2);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.StackMapFrameHandler.ForAdvice bindExit(MethodDescription.InDefinedShape param3InDefinedShape) {
/*  6523 */           return new Advice.StackMapFrameHandler.Default.ForAdvice(this, param3InDefinedShape, 
/*  6524 */               CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), 
/*  6525 */               Collections.emptyList(), 
/*  6526 */               Collections.emptyList(), Advice.StackMapFrameHandler.Default.TranslationMode.EXIT, Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectReturnFrame(MethodVisitor param3MethodVisitor) {
/*  6535 */           if (!this.expandFrames && this.currentFrameDivergence == 0) {
/*  6536 */             if (this.instrumentedMethod.getReturnType().represents(void.class)) {
/*  6537 */               param3MethodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY); return;
/*       */             } 
/*  6539 */             param3MethodVisitor.visitFrame(4, EMPTY.length, EMPTY, 1, new Object[] { Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
/*       */ 
/*       */ 
/*       */                   
/*  6543 */                   .toFrame(this.instrumentedMethod.getReturnType().asErasure()) });
/*       */             return;
/*       */           } 
/*  6546 */           injectFullFrame(param3MethodVisitor, Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes), this.instrumentedMethod.getReturnType().represents(void.class) ? 
/*  6547 */               Collections.<TypeDescription>emptyList() : 
/*  6548 */               Collections.<TypeDescription>singletonList(this.instrumentedMethod.getReturnType().asErasure()));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectExceptionFrame(MethodVisitor param3MethodVisitor) {
/*  6556 */           if (!this.expandFrames && this.currentFrameDivergence == 0) {
/*  6557 */             param3MethodVisitor.visitFrame(4, EMPTY.length, EMPTY, 1, new Object[] { Type.getInternalName(Throwable.class) }); return;
/*       */           } 
/*  6559 */           injectFullFrame(param3MethodVisitor, Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes), Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectCompletionFrame(MethodVisitor param3MethodVisitor) {
/*  6567 */           if (this.allowCompactCompletionFrame && !this.expandFrames && this.currentFrameDivergence == 0 && this.postMethodTypes.size() < 4) {
/*  6568 */             if (this.postMethodTypes.isEmpty()) {
/*  6569 */               param3MethodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY); return;
/*       */             } 
/*  6571 */             Object[] arrayOfObject = new Object[this.postMethodTypes.size()];
/*  6572 */             byte b = 0;
/*  6573 */             for (TypeDescription typeDescription : this.postMethodTypes) {
/*  6574 */               arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */             }
/*  6576 */             param3MethodVisitor.visitFrame(1, arrayOfObject.length, arrayOfObject, EMPTY.length, EMPTY);
/*       */             return;
/*       */           } 
/*  6579 */           injectFullFrame(param3MethodVisitor, Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), Collections.emptyList());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectPostCompletionFrame(MethodVisitor param3MethodVisitor) {
/*  6587 */           if (!this.expandFrames && this.currentFrameDivergence == 0) {
/*  6588 */             param3MethodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY); return;
/*       */           } 
/*  6590 */           injectFullFrame(param3MethodVisitor, Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), Collections.emptyList());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectInitializationFrame(MethodVisitor param3MethodVisitor) {
/*  6598 */           if (!this.initialTypes.isEmpty()) {
/*  6599 */             if (!this.expandFrames && this.initialTypes.size() < 4) {
/*  6600 */               Object[] arrayOfObject1 = new Object[this.initialTypes.size()];
/*  6601 */               byte b1 = 0;
/*  6602 */               for (TypeDescription typeDescription : this.initialTypes) {
/*  6603 */                 arrayOfObject1[b1++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */               }
/*  6605 */               param3MethodVisitor.visitFrame(1, arrayOfObject1.length, arrayOfObject1, EMPTY.length, EMPTY);
/*       */               
/*       */               return;
/*       */             } 
/*  6609 */             Object[] arrayOfObject = new Object[(this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size() + this.initialTypes.size()];
/*  6610 */             byte b = 0;
/*  6611 */             if (this.instrumentedMethod.isConstructor()) {
/*  6612 */               b++; arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS;
/*  6613 */             } else if (!this.instrumentedMethod.isStatic()) {
/*  6614 */               b++; arrayOfObject[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType);
/*       */             } 
/*  6616 */             for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
/*  6617 */               arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */             }
/*  6619 */             for (TypeDescription typeDescription : this.initialTypes) {
/*  6620 */               arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */             }
/*  6622 */             param3MethodVisitor.visitFrame(this.expandFrames ? -1 : 0, arrayOfObject.length, arrayOfObject, EMPTY.length, EMPTY);
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class WithoutArgumentCopy
/*       */           extends WithPreservedArguments
/*       */         {
/*       */           protected WithoutArgumentCopy(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, List<? extends TypeDescription> param4List1, List<? extends TypeDescription> param4List2, List<? extends TypeDescription> param4List3, List<? extends TypeDescription> param4List4, boolean param4Boolean1, boolean param4Boolean2) {
/*  6652 */             super(param4TypeDescription, param4MethodDescription, param4List1, param4List2, param4List3, param4List4, param4Boolean1, param4Boolean2);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void injectStartFrame(MethodVisitor param4MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void translateFrame(MethodVisitor param4MethodVisitor, int param4Int1, int param4Int2, @MaybeNull Object[] param4ArrayOfObject1, int param4Int3, @MaybeNull Object[] param4ArrayOfObject2) {
/*  6671 */             translateFrame(param4MethodVisitor, Advice.StackMapFrameHandler.Default.TranslationMode.COPY, this.instrumentedMethod, 
/*       */ 
/*       */                 
/*  6674 */                 CompoundList.of(this.initialTypes, this.preMethodTypes), param4Int1, param4Int2, param4ArrayOfObject1, param4Int3, param4ArrayOfObject2);
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class WithArgumentCopy
/*       */           extends WithPreservedArguments
/*       */         {
/*       */           protected WithArgumentCopy(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, List<? extends TypeDescription> param4List1, List<? extends TypeDescription> param4List2, List<? extends TypeDescription> param4List3, List<? extends TypeDescription> param4List4, boolean param4Boolean) {
/*  6706 */             super(param4TypeDescription, param4MethodDescription, param4List1, param4List2, param4List3, param4List4, param4Boolean, true);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void injectStartFrame(MethodVisitor param4MethodVisitor) {
/*  6713 */             if (!this.instrumentedMethod.isStatic() || !this.instrumentedMethod.getParameters().isEmpty()) {
/*  6714 */               if (!this.expandFrames && (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size() < 4) {
/*  6715 */                 Object[] arrayOfObject = new Object[(this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size()];
/*  6716 */                 byte b = 0;
/*  6717 */                 if (this.instrumentedMethod.isConstructor()) {
/*  6718 */                   b++; arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS;
/*  6719 */                 } else if (!this.instrumentedMethod.isStatic()) {
/*  6720 */                   b++; arrayOfObject[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType);
/*       */                 } 
/*  6722 */                 for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
/*  6723 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6725 */                 param4MethodVisitor.visitFrame(1, arrayOfObject.length, arrayOfObject, EMPTY.length, EMPTY);
/*       */               
/*       */               }
/*       */               else {
/*       */                 
/*  6730 */                 Object[] arrayOfObject = new Object[(this.instrumentedMethod.isStatic() ? 0 : 2) + (this.instrumentedMethod.getParameters().size() << 1) + this.initialTypes.size() + this.preMethodTypes.size()];
/*  6731 */                 byte b = 0;
/*  6732 */                 if (this.instrumentedMethod.isConstructor()) {
/*  6733 */                   b++; arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS;
/*  6734 */                 } else if (!this.instrumentedMethod.isStatic()) {
/*  6735 */                   b++; arrayOfObject[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType);
/*       */                 } 
/*  6737 */                 for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
/*  6738 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6740 */                 for (TypeDescription typeDescription : this.initialTypes) {
/*  6741 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6743 */                 for (TypeDescription typeDescription : this.preMethodTypes) {
/*  6744 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6746 */                 if (this.instrumentedMethod.isConstructor()) {
/*  6747 */                   arrayOfObject[b++] = Opcodes.UNINITIALIZED_THIS;
/*  6748 */                 } else if (!this.instrumentedMethod.isStatic()) {
/*  6749 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType);
/*       */                 } 
/*  6751 */                 for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
/*  6752 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6754 */                 param4MethodVisitor.visitFrame(this.expandFrames ? -1 : 0, arrayOfObject.length, arrayOfObject, EMPTY.length, EMPTY);
/*       */               } 
/*       */             }
/*  6757 */             this.currentFrameDivergence = (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"RC_REF_COMPARISON_BAD_PRACTICE"}, justification = "ASM models frames by reference identity.")
/*       */           public void translateFrame(MethodVisitor param4MethodVisitor, int param4Int1, int param4Int2, @MaybeNull Object[] param4ArrayOfObject1, int param4Int3, @MaybeNull Object[] param4ArrayOfObject2)
/*       */           {
/*       */             Object[] arrayOfObject;
/*       */             byte b;
/*  6770 */             switch (param4Int1) {
/*       */               case 3:
/*       */               case 4:
/*       */                 break;
/*       */               case 1:
/*  6775 */                 this.currentFrameDivergence += param4Int2;
/*       */                 break;
/*       */               case 2:
/*  6778 */                 this.currentFrameDivergence -= param4Int2;
/*       */                 break;
/*       */ 
/*       */ 
/*       */ 
/*       */               
/*       */               case -1:
/*       */               case 0:
/*  6786 */                 arrayOfObject = new Object[param4Int2 + (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size() + this.initialTypes.size() + this.preMethodTypes.size()];
/*  6787 */                 b = 0;
/*  6788 */                 if (this.instrumentedMethod.isConstructor()) {
/*  6789 */                   Advice.StackMapFrameHandler.Default.Initialization initialization = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED;
/*  6790 */                   for (byte b1 = 0; b1 < param4Int2; b1++) {
/*  6791 */                     if (param4ArrayOfObject1[b1] == Opcodes.UNINITIALIZED_THIS) {
/*  6792 */                       initialization = Advice.StackMapFrameHandler.Default.Initialization.UNITIALIZED;
/*       */                       break;
/*       */                     } 
/*       */                   } 
/*  6796 */                   b++; arrayOfObject[0] = initialization.toFrame(this.instrumentedType);
/*  6797 */                 } else if (!this.instrumentedMethod.isStatic()) {
/*  6798 */                   b++; arrayOfObject[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType);
/*       */                 } 
/*  6800 */                 for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
/*  6801 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6803 */                 for (TypeDescription typeDescription : this.initialTypes) {
/*  6804 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6806 */                 for (TypeDescription typeDescription : this.preMethodTypes) {
/*  6807 */                   arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */                 }
/*  6809 */                 if (param4Int2 > 0) {
/*  6810 */                   System.arraycopy(param4ArrayOfObject1, 0, arrayOfObject, b, param4Int2);
/*       */                 }
/*  6812 */                 param4Int2 = arrayOfObject.length;
/*  6813 */                 param4ArrayOfObject1 = arrayOfObject;
/*  6814 */                 this.currentFrameDivergence = param4Int2;
/*       */                 break;
/*       */               default:
/*  6817 */                 throw new IllegalArgumentException("Unexpected frame type: " + param4Int1);
/*       */             } 
/*  6819 */             param4MethodVisitor.visitFrame(param4Int1, param4Int2, param4ArrayOfObject1, param4Int3, param4ArrayOfObject2); } } } protected static class WithoutArgumentCopy extends WithPreservedArguments { protected WithoutArgumentCopy(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, List<? extends TypeDescription> param3List1, List<? extends TypeDescription> param3List2, List<? extends TypeDescription> param3List3, List<? extends TypeDescription> param3List4, boolean param3Boolean1, boolean param3Boolean2) { super(param3TypeDescription, param3MethodDescription, param3List1, param3List2, param3List3, param3List4, param3Boolean1, param3Boolean2); } public void injectStartFrame(MethodVisitor param3MethodVisitor) {} public void translateFrame(MethodVisitor param3MethodVisitor, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2) { translateFrame(param3MethodVisitor, Advice.StackMapFrameHandler.Default.TranslationMode.COPY, this.instrumentedMethod, CompoundList.of(this.initialTypes, this.preMethodTypes), param3Int1, param3Int2, param3ArrayOfObject1, param3Int3, param3ArrayOfObject2); } } protected static class WithArgumentCopy extends WithPreservedArguments { protected WithArgumentCopy(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, List<? extends TypeDescription> param3List1, List<? extends TypeDescription> param3List2, List<? extends TypeDescription> param3List3, List<? extends TypeDescription> param3List4, boolean param3Boolean) { super(param3TypeDescription, param3MethodDescription, param3List1, param3List2, param3List3, param3List4, param3Boolean, true); } public void injectStartFrame(MethodVisitor param3MethodVisitor) { if (!this.instrumentedMethod.isStatic() || !this.instrumentedMethod.getParameters().isEmpty()) if (!this.expandFrames && (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size() < 4) { Object[] arrayOfObject = new Object[(this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size()]; byte b = 0; if (this.instrumentedMethod.isConstructor()) { b++; arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS; } else if (!this.instrumentedMethod.isStatic()) { b++; arrayOfObject[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType); }  for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  param3MethodVisitor.visitFrame(1, arrayOfObject.length, arrayOfObject, EMPTY.length, EMPTY); } else { Object[] arrayOfObject = new Object[(this.instrumentedMethod.isStatic() ? 0 : 2) + (this.instrumentedMethod.getParameters().size() << 1) + this.initialTypes.size() + this.preMethodTypes.size()]; byte b = 0; if (this.instrumentedMethod.isConstructor()) { b++; arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS; } else if (!this.instrumentedMethod.isStatic()) { b++; arrayOfObject[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType); }  for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  for (TypeDescription typeDescription : this.initialTypes) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  for (TypeDescription typeDescription : this.preMethodTypes) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  if (this.instrumentedMethod.isConstructor()) { arrayOfObject[b++] = Opcodes.UNINITIALIZED_THIS; } else if (!this.instrumentedMethod.isStatic()) { arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType); }  for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  param3MethodVisitor.visitFrame(this.expandFrames ? -1 : 0, arrayOfObject.length, arrayOfObject, EMPTY.length, EMPTY); }   this.currentFrameDivergence = (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size(); } @SuppressFBWarnings(value = {"RC_REF_COMPARISON_BAD_PRACTICE"}, justification = "ASM models frames by reference identity.") public void translateFrame(MethodVisitor param3MethodVisitor, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2) { Object[] arrayOfObject; byte b; switch (param3Int1) { case 3: case 4: break;case 1: this.currentFrameDivergence += param3Int2; break;case 2: this.currentFrameDivergence -= param3Int2; break;case -1: case 0: arrayOfObject = new Object[param3Int2 + (this.instrumentedMethod.isStatic() ? 0 : 1) + this.instrumentedMethod.getParameters().size() + this.initialTypes.size() + this.preMethodTypes.size()]; b = 0; if (this.instrumentedMethod.isConstructor()) { Advice.StackMapFrameHandler.Default.Initialization initialization = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED; for (byte b1 = 0; b1 < param3Int2; b1++) { if (param3ArrayOfObject1[b1] == Opcodes.UNINITIALIZED_THIS) { initialization = Advice.StackMapFrameHandler.Default.Initialization.UNITIALIZED; break; }  }  b++; arrayOfObject[0] = initialization.toFrame(this.instrumentedType); } else if (!this.instrumentedMethod.isStatic()) { b++; arrayOfObject[0] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(this.instrumentedType); }  for (TypeDescription typeDescription : this.instrumentedMethod.getParameters().asTypeList().asErasures()) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  for (TypeDescription typeDescription : this.initialTypes) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  for (TypeDescription typeDescription : this.preMethodTypes) arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);  if (param3Int2 > 0) System.arraycopy(param3ArrayOfObject1, 0, arrayOfObject, b, param3Int2);  param3Int2 = arrayOfObject.length; param3ArrayOfObject1 = arrayOfObject; this.currentFrameDivergence = param3Int2; break;default: throw new IllegalArgumentException("Unexpected frame type: " + param3Int1); }  param3MethodVisitor.visitFrame(param3Int1, param3Int2, param3ArrayOfObject1, param3Int3, param3ArrayOfObject2); }
/*       */          }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected class ForAdvice
/*       */         implements Advice.StackMapFrameHandler.ForAdvice
/*       */       {
/*       */         protected final MethodDescription.InDefinedShape adviceMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final List<? extends TypeDescription> startTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final List<? extends TypeDescription> intermediateTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final List<? extends TypeDescription> endTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Advice.StackMapFrameHandler.Default.TranslationMode translationMode;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Advice.StackMapFrameHandler.Default.Initialization initialization;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private boolean intermedate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForAdvice(Advice.StackMapFrameHandler.Default this$0, MethodDescription.InDefinedShape param3InDefinedShape, List<? extends TypeDescription> param3List1, List<? extends TypeDescription> param3List2, List<? extends TypeDescription> param3List3, Advice.StackMapFrameHandler.Default.TranslationMode param3TranslationMode, Advice.StackMapFrameHandler.Default.Initialization param3Initialization) {
/*  6881 */           this.adviceMethod = param3InDefinedShape;
/*  6882 */           this.startTypes = param3List1;
/*  6883 */           this.intermediateTypes = param3List2;
/*  6884 */           this.endTypes = param3List3;
/*  6885 */           this.translationMode = param3TranslationMode;
/*  6886 */           this.initialization = param3Initialization;
/*  6887 */           this.intermedate = false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void translateFrame(MethodVisitor param3MethodVisitor, int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2) {
/*  6899 */           this.a.translateFrame(param3MethodVisitor, this.translationMode, (MethodDescription)this.adviceMethod, this.startTypes, param3Int1, param3Int2, param3ArrayOfObject1, param3Int3, param3ArrayOfObject2);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectReturnFrame(MethodVisitor param3MethodVisitor) {
/*  6914 */           if (!this.a.expandFrames && this.a.currentFrameDivergence == 0) {
/*  6915 */             if (this.adviceMethod.getReturnType().represents(void.class)) {
/*  6916 */               param3MethodVisitor.visitFrame(3, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY); return;
/*       */             } 
/*  6918 */             param3MethodVisitor.visitFrame(4, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY, 1, new Object[] { Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
/*       */ 
/*       */ 
/*       */                   
/*  6922 */                   .toFrame(this.adviceMethod.getReturnType().asErasure()) });
/*       */             return;
/*       */           } 
/*  6925 */           this.a.injectFullFrame(param3MethodVisitor, this.initialization, this.startTypes, this.adviceMethod.getReturnType().represents(void.class) ? 
/*  6926 */               Collections.<TypeDescription>emptyList() : 
/*  6927 */               Collections.<TypeDescription>singletonList(this.adviceMethod.getReturnType().asErasure()));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectExceptionFrame(MethodVisitor param3MethodVisitor) {
/*  6935 */           if (!this.a.expandFrames && this.a.currentFrameDivergence == 0) {
/*  6936 */             param3MethodVisitor.visitFrame(4, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY, 1, new Object[] { Type.getInternalName(Throwable.class) }); return;
/*       */           } 
/*  6938 */           this.a.injectFullFrame(param3MethodVisitor, this.initialization, this.startTypes, Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectCompletionFrame(MethodVisitor param3MethodVisitor) {
/*  6946 */           if (!this.a.expandFrames) {
/*       */             
/*  6948 */             if (this.a.currentFrameDivergence == 0 && (this.intermedate || this.endTypes.size() < 4)) {
/*  6949 */               if (this.intermedate || this.endTypes.isEmpty()) {
/*  6950 */                 param3MethodVisitor.visitFrame(3, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY); return;
/*       */               } 
/*  6952 */               Object[] arrayOfObject = new Object[this.endTypes.size()];
/*  6953 */               byte b = 0;
/*  6954 */               for (TypeDescription typeDescription : this.endTypes) {
/*  6955 */                 arrayOfObject[b++] = Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED.toFrame(typeDescription);
/*       */               }
/*  6957 */               param3MethodVisitor.visitFrame(1, arrayOfObject.length, arrayOfObject, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY); return;
/*       */             } 
/*  6959 */             if (this.a.currentFrameDivergence < 3 && this.endTypes.isEmpty()) {
/*  6960 */               param3MethodVisitor.visitFrame(2, this.a.currentFrameDivergence, Advice.StackMapFrameHandler.Default.EMPTY, Advice.StackMapFrameHandler.Default.EMPTY.length, Advice.StackMapFrameHandler.Default.EMPTY);
/*  6961 */               this.a.currentFrameDivergence = 0; return;
/*       */             } 
/*  6963 */           }  this.a.injectFullFrame(param3MethodVisitor, this.initialization, CompoundList.of(this.startTypes, this.endTypes), Collections.emptyList());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void injectIntermediateFrame(MethodVisitor param3MethodVisitor, List<? extends TypeDescription> param3List) {
/*       */           // Byte code:
/*       */           //   0: aload_0
/*       */           //   1: getfield a : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default;
/*       */           //   4: getfield expandFrames : Z
/*       */           //   7: ifne -> 367
/*       */           //   10: aload_0
/*       */           //   11: getfield intermedate : Z
/*       */           //   14: ifeq -> 95
/*       */           //   17: aload_2
/*       */           //   18: invokeinterface size : ()I
/*       */           //   23: iconst_2
/*       */           //   24: if_icmpge -> 95
/*       */           //   27: aload_2
/*       */           //   28: invokeinterface isEmpty : ()Z
/*       */           //   33: ifeq -> 56
/*       */           //   36: aload_1
/*       */           //   37: iconst_3
/*       */           //   38: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   41: arraylength
/*       */           //   42: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   45: dup
/*       */           //   46: arraylength
/*       */           //   47: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   50: invokevirtual visitFrame : (II[Ljava/lang/Object;I[Ljava/lang/Object;)V
/*       */           //   53: goto -> 391
/*       */           //   56: aload_1
/*       */           //   57: iconst_4
/*       */           //   58: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   61: arraylength
/*       */           //   62: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   65: iconst_1
/*       */           //   66: iconst_1
/*       */           //   67: anewarray java/lang/Object
/*       */           //   70: dup
/*       */           //   71: iconst_0
/*       */           //   72: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization.INITIALIZED : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization;
/*       */           //   75: aload_2
/*       */           //   76: iconst_0
/*       */           //   77: invokeinterface get : (I)Ljava/lang/Object;
/*       */           //   82: checkcast net/bytebuddy/description/type/TypeDescription
/*       */           //   85: invokevirtual toFrame : (Lnet/bytebuddy/description/type/TypeDescription;)Ljava/lang/Object;
/*       */           //   88: aastore
/*       */           //   89: invokevirtual visitFrame : (II[Ljava/lang/Object;I[Ljava/lang/Object;)V
/*       */           //   92: goto -> 391
/*       */           //   95: aload_0
/*       */           //   96: getfield a : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default;
/*       */           //   99: getfield currentFrameDivergence : I
/*       */           //   102: ifne -> 312
/*       */           //   105: aload_0
/*       */           //   106: getfield intermediateTypes : Ljava/util/List;
/*       */           //   109: invokeinterface size : ()I
/*       */           //   114: iconst_4
/*       */           //   115: if_icmpge -> 312
/*       */           //   118: aload_2
/*       */           //   119: invokeinterface isEmpty : ()Z
/*       */           //   124: ifne -> 149
/*       */           //   127: aload_2
/*       */           //   128: invokeinterface size : ()I
/*       */           //   133: iconst_2
/*       */           //   134: if_icmpge -> 312
/*       */           //   137: aload_0
/*       */           //   138: getfield intermediateTypes : Ljava/util/List;
/*       */           //   141: invokeinterface isEmpty : ()Z
/*       */           //   146: ifeq -> 312
/*       */           //   149: aload_0
/*       */           //   150: getfield intermediateTypes : Ljava/util/List;
/*       */           //   153: invokeinterface isEmpty : ()Z
/*       */           //   158: ifeq -> 229
/*       */           //   161: aload_2
/*       */           //   162: invokeinterface isEmpty : ()Z
/*       */           //   167: ifeq -> 190
/*       */           //   170: aload_1
/*       */           //   171: iconst_3
/*       */           //   172: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   175: arraylength
/*       */           //   176: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   179: dup
/*       */           //   180: arraylength
/*       */           //   181: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   184: invokevirtual visitFrame : (II[Ljava/lang/Object;I[Ljava/lang/Object;)V
/*       */           //   187: goto -> 391
/*       */           //   190: aload_1
/*       */           //   191: iconst_4
/*       */           //   192: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   195: arraylength
/*       */           //   196: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   199: iconst_1
/*       */           //   200: iconst_1
/*       */           //   201: anewarray java/lang/Object
/*       */           //   204: dup
/*       */           //   205: iconst_0
/*       */           //   206: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization.INITIALIZED : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization;
/*       */           //   209: aload_2
/*       */           //   210: iconst_0
/*       */           //   211: invokeinterface get : (I)Ljava/lang/Object;
/*       */           //   216: checkcast net/bytebuddy/description/type/TypeDescription
/*       */           //   219: invokevirtual toFrame : (Lnet/bytebuddy/description/type/TypeDescription;)Ljava/lang/Object;
/*       */           //   222: aastore
/*       */           //   223: invokevirtual visitFrame : (II[Ljava/lang/Object;I[Ljava/lang/Object;)V
/*       */           //   226: goto -> 391
/*       */           //   229: aload_0
/*       */           //   230: getfield intermediateTypes : Ljava/util/List;
/*       */           //   233: invokeinterface size : ()I
/*       */           //   238: anewarray java/lang/Object
/*       */           //   241: astore_2
/*       */           //   242: iconst_0
/*       */           //   243: istore_3
/*       */           //   244: aload_0
/*       */           //   245: getfield intermediateTypes : Ljava/util/List;
/*       */           //   248: invokeinterface iterator : ()Ljava/util/Iterator;
/*       */           //   253: astore #4
/*       */           //   255: aload #4
/*       */           //   257: invokeinterface hasNext : ()Z
/*       */           //   262: ifeq -> 294
/*       */           //   265: aload #4
/*       */           //   267: invokeinterface next : ()Ljava/lang/Object;
/*       */           //   272: checkcast net/bytebuddy/description/type/TypeDescription
/*       */           //   275: astore #5
/*       */           //   277: aload_2
/*       */           //   278: iload_3
/*       */           //   279: iinc #3, 1
/*       */           //   282: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization.INITIALIZED : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization;
/*       */           //   285: aload #5
/*       */           //   287: invokevirtual toFrame : (Lnet/bytebuddy/description/type/TypeDescription;)Ljava/lang/Object;
/*       */           //   290: aastore
/*       */           //   291: goto -> 255
/*       */           //   294: aload_1
/*       */           //   295: iconst_1
/*       */           //   296: aload_2
/*       */           //   297: arraylength
/*       */           //   298: aload_2
/*       */           //   299: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   302: arraylength
/*       */           //   303: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   306: invokevirtual visitFrame : (II[Ljava/lang/Object;I[Ljava/lang/Object;)V
/*       */           //   309: goto -> 391
/*       */           //   312: aload_0
/*       */           //   313: getfield a : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default;
/*       */           //   316: getfield currentFrameDivergence : I
/*       */           //   319: iconst_3
/*       */           //   320: if_icmpge -> 367
/*       */           //   323: aload_0
/*       */           //   324: getfield intermediateTypes : Ljava/util/List;
/*       */           //   327: invokeinterface isEmpty : ()Z
/*       */           //   332: ifeq -> 367
/*       */           //   335: aload_2
/*       */           //   336: invokeinterface isEmpty : ()Z
/*       */           //   341: ifeq -> 367
/*       */           //   344: aload_1
/*       */           //   345: iconst_2
/*       */           //   346: aload_0
/*       */           //   347: getfield a : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default;
/*       */           //   350: getfield currentFrameDivergence : I
/*       */           //   353: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   356: dup
/*       */           //   357: arraylength
/*       */           //   358: getstatic net/bytebuddy/asm/Advice$StackMapFrameHandler$Default.EMPTY : [Ljava/lang/Object;
/*       */           //   361: invokevirtual visitFrame : (II[Ljava/lang/Object;I[Ljava/lang/Object;)V
/*       */           //   364: goto -> 391
/*       */           //   367: aload_0
/*       */           //   368: getfield a : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default;
/*       */           //   371: aload_1
/*       */           //   372: aload_0
/*       */           //   373: getfield initialization : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization;
/*       */           //   376: aload_0
/*       */           //   377: getfield startTypes : Ljava/util/List;
/*       */           //   380: aload_0
/*       */           //   381: getfield intermediateTypes : Ljava/util/List;
/*       */           //   384: invokestatic of : (Ljava/util/List;Ljava/util/List;)Ljava/util/List;
/*       */           //   387: aload_2
/*       */           //   388: invokevirtual injectFullFrame : (Lnet/bytebuddy/jar/asm/MethodVisitor;Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default$Initialization;Ljava/util/List;Ljava/util/List;)V
/*       */           //   391: aload_0
/*       */           //   392: getfield a : Lnet/bytebuddy/asm/Advice$StackMapFrameHandler$Default;
/*       */           //   395: aload_0
/*       */           //   396: getfield intermediateTypes : Ljava/util/List;
/*       */           //   399: invokeinterface size : ()I
/*       */           //   404: aload_0
/*       */           //   405: getfield endTypes : Ljava/util/List;
/*       */           //   408: invokeinterface size : ()I
/*       */           //   413: isub
/*       */           //   414: putfield currentFrameDivergence : I
/*       */           //   417: aload_0
/*       */           //   418: iconst_1
/*       */           //   419: putfield intermedate : Z
/*       */           //   422: return
/*       */           // Line number table:
/*       */           //   Java source line number -> byte code offset
/*       */           //   #6971	-> 0
/*       */           //   #6973	-> 10
/*       */           //   #6974	-> 27
/*       */           //   #6975	-> 36
/*       */           //   #6977	-> 56
/*       */           //   #6979	-> 95
/*       */           //   #6980	-> 109
/*       */           //   #6981	-> 119
/*       */           //   #6982	-> 149
/*       */           //   #6983	-> 161
/*       */           //   #6984	-> 170
/*       */           //   #6986	-> 190
/*       */           //   #6989	-> 229
/*       */           //   #6990	-> 242
/*       */           //   #6991	-> 244
/*       */           //   #6992	-> 277
/*       */           //   #6993	-> 291
/*       */           //   #6994	-> 294
/*       */           //   #6995	-> 309
/*       */           //   #6996	-> 312
/*       */           //   #6997	-> 344
/*       */           //   #6999	-> 367
/*       */           //   #7001	-> 391
/*       */           //   #7002	-> 417
/*       */           //   #7003	-> 422
/*       */         }
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public enum Default
/*       */     implements ExceptionHandler
/*       */   {
/*  7030 */     SUPPRESSING
/*       */     {
/*       */       public final StackManipulation resolve(MethodDescription param3MethodDescription, TypeDescription param3TypeDescription) {
/*  7033 */         return (StackManipulation)Removal.SINGLE;
/*       */       }
/*       */     },
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7040 */     PRINTING
/*       */     {
/*       */       public final StackManipulation resolve(MethodDescription param3MethodDescription, TypeDescription param3TypeDescription) {
/*       */         try {
/*  7044 */           return (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Throwable.class.getMethod("printStackTrace", new Class[0])));
/*  7045 */         } catch (NoSuchMethodException noSuchMethodException) {
/*  7046 */           throw new IllegalStateException("Cannot locate Throwable::printStackTrace");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         }
/*       */       
/*       */       }
/*       */     },
/*  7056 */     RETHROWING
/*       */     {
/*       */       public final StackManipulation resolve(MethodDescription param3MethodDescription, TypeDescription param3TypeDescription) {
/*  7059 */         return (StackManipulation)Throw.INSTANCE; } }; } public static interface ExceptionHandler { StackManipulation resolve(MethodDescription param1MethodDescription, TypeDescription param1TypeDescription); public enum Default implements ExceptionHandler { SUPPRESSING { public final StackManipulation resolve(MethodDescription param3MethodDescription, TypeDescription param3TypeDescription) { return (StackManipulation)Removal.SINGLE; } }, PRINTING { public final StackManipulation resolve(MethodDescription param3MethodDescription, TypeDescription param3TypeDescription) { try { return (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Throwable.class.getMethod("printStackTrace", new Class[0]))); } catch (NoSuchMethodException noSuchMethodException) { throw new IllegalStateException("Cannot locate Throwable::printStackTrace"); }  } }, RETHROWING { public final StackManipulation resolve(MethodDescription param3MethodDescription, TypeDescription param3TypeDescription) { return (StackManipulation)Throw.INSTANCE; }
/*       */          }
/*       */       ; }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Simple
/*       */       implements ExceptionHandler
/*       */     {
/*       */       private final StackManipulation stackManipulation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Simple(StackManipulation param2StackManipulation) {
/*  7081 */         this.stackManipulation = param2StackManipulation;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public StackManipulation resolve(MethodDescription param2MethodDescription, TypeDescription param2TypeDescription)
/*       */       {
/*  7088 */         return this.stackManipulation; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.stackManipulation.equals(((Simple)param2Object).stackManipulation)))); } public int hashCode() { return getClass().hashCode() * 31 + this.stackManipulation.hashCode(); } } } @Enhance public static class Simple implements ExceptionHandler { private final StackManipulation stackManipulation; public Simple(StackManipulation param1StackManipulation) { this.stackManipulation = param1StackManipulation; } public StackManipulation resolve(MethodDescription param1MethodDescription, TypeDescription param1TypeDescription) { return this.stackManipulation; }
/*       */ 
/*       */     
/*       */     public boolean equals(@MaybeNull Object param1Object) {
/*       */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.stackManipulation.equals(((Simple)param1Object).stackManipulation))));
/*       */     }
/*       */     
/*       */     public int hashCode() {
/*       */       return getClass().hashCode() * 31 + this.stackManipulation.hashCode();
/*       */     } }
/*       */ 
/*       */   
/*       */   protected static interface Dispatcher {
/*       */     @AlwaysNull
/*  7102 */     public static final MethodVisitor IGNORE_METHOD = null;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @AlwaysNull
/*  7108 */     public static final AnnotationVisitor IGNORE_ANNOTATION = null;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     boolean isAlive();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypeDefinition getAdviceType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Unresolved
/*       */       extends Dispatcher
/*       */     {
/*       */       boolean isBinary();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Map<String, TypeDefinition> getNamedTypes();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface SuppressionHandler
/*       */     {
/*       */       Bound bind(StackManipulation param2StackManipulation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static interface Bound
/*       */       {
/*       */         void onPrepare(MethodVisitor param3MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         void onStart(MethodVisitor param3MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         void onEnd(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Advice.MethodSizeHandler.ForAdvice param3ForAdvice, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice1, TypeDefinition param3TypeDefinition);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         void onEndWithSkip(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Advice.MethodSizeHandler.ForAdvice param3ForAdvice, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice1, TypeDefinition param3TypeDefinition);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum NoOp
/*       */         implements SuppressionHandler, Bound
/*       */       {
/*  7243 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Advice.Dispatcher.SuppressionHandler.Bound bind(StackManipulation param3StackManipulation) {
/*  7249 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onPrepare(MethodVisitor param3MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onStart(MethodVisitor param3MethodVisitor) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onEnd(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Advice.MethodSizeHandler.ForAdvice param3ForAdvice, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice1, TypeDefinition param3TypeDefinition) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onEndWithSkip(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Advice.MethodSizeHandler.ForAdvice param3ForAdvice, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice1, TypeDefinition param3TypeDefinition) {}
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Suppressing
/*       */         implements SuppressionHandler
/*       */       {
/*       */         private final TypeDescription suppressedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Suppressing(TypeDescription param3TypeDescription) {
/*  7306 */           this.suppressedType = param3TypeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static Advice.Dispatcher.SuppressionHandler of(TypeDescription param3TypeDescription) {
/*  7316 */           return (Advice.Dispatcher.SuppressionHandler)(param3TypeDescription.represents(Advice.NoExceptionHandler.class) ? Advice.Dispatcher.SuppressionHandler.NoOp.INSTANCE : new Suppressing(param3TypeDescription));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.Dispatcher.SuppressionHandler.Bound bind(StackManipulation param3StackManipulation) {
/*  7325 */           return new Bound(this.suppressedType, param3StackManipulation);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.suppressedType.equals(((Suppressing)param3Object).suppressedType))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.suppressedType.hashCode();
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class Bound
/*       */           implements Advice.Dispatcher.SuppressionHandler.Bound
/*       */         {
/*       */           private final TypeDescription suppressedType;
/*       */ 
/*       */           
/*       */           private final StackManipulation exceptionHandler;
/*       */ 
/*       */           
/*       */           private final Label startOfMethod;
/*       */ 
/*       */           
/*       */           private final Label endOfMethod;
/*       */ 
/*       */ 
/*       */           
/*       */           protected Bound(TypeDescription param4TypeDescription, StackManipulation param4StackManipulation) {
/*  7360 */             this.suppressedType = param4TypeDescription;
/*  7361 */             this.exceptionHandler = param4StackManipulation;
/*  7362 */             this.startOfMethod = new Label();
/*  7363 */             this.endOfMethod = new Label();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void onPrepare(MethodVisitor param4MethodVisitor) {
/*  7370 */             param4MethodVisitor.visitTryCatchBlock(this.startOfMethod, this.endOfMethod, this.endOfMethod, this.suppressedType.getInternalName());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void onStart(MethodVisitor param4MethodVisitor) {
/*  7377 */             param4MethodVisitor.visitLabel(this.startOfMethod);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void onEnd(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Advice.MethodSizeHandler.ForAdvice param4ForAdvice, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice1, TypeDefinition param4TypeDefinition) {
/*  7388 */             param4MethodVisitor.visitLabel(this.endOfMethod);
/*  7389 */             param4ForAdvice1.injectExceptionFrame(param4MethodVisitor);
/*  7390 */             param4ForAdvice.requireStackSize(1 + this.exceptionHandler.apply(param4MethodVisitor, param4Context).getMaximalSize());
/*  7391 */             if (param4TypeDefinition.represents(boolean.class) || param4TypeDefinition
/*  7392 */               .represents(byte.class) || param4TypeDefinition
/*  7393 */               .represents(short.class) || param4TypeDefinition
/*  7394 */               .represents(char.class) || param4TypeDefinition
/*  7395 */               .represents(int.class)) {
/*  7396 */               param4MethodVisitor.visitInsn(3); return;
/*  7397 */             }  if (param4TypeDefinition.represents(long.class)) {
/*  7398 */               param4MethodVisitor.visitInsn(9); return;
/*  7399 */             }  if (param4TypeDefinition.represents(float.class)) {
/*  7400 */               param4MethodVisitor.visitInsn(11); return;
/*  7401 */             }  if (param4TypeDefinition.represents(double.class)) {
/*  7402 */               param4MethodVisitor.visitInsn(14); return;
/*  7403 */             }  if (!param4TypeDefinition.represents(void.class)) {
/*  7404 */               param4MethodVisitor.visitInsn(1);
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void onEndWithSkip(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Advice.MethodSizeHandler.ForAdvice param4ForAdvice, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice1, TypeDefinition param4TypeDefinition) {
/*  7416 */             Label label = new Label();
/*  7417 */             param4MethodVisitor.visitJumpInsn(167, label);
/*  7418 */             onEnd(param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4TypeDefinition);
/*  7419 */             param4MethodVisitor.visitLabel(label);
/*  7420 */             param4ForAdvice1.injectReturnFrame(param4MethodVisitor);
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface RelocationHandler
/*       */     {
/*       */       Bound bind(MethodDescription param2MethodDescription, Relocation param2Relocation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static interface Relocation
/*       */       {
/*       */         void apply(MethodVisitor param3MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForLabel
/*       */           implements Relocation
/*       */         {
/*       */           private final Label label;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ForLabel(Label param4Label) {
/*  7469 */             this.label = param4Label;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void apply(MethodVisitor param4MethodVisitor) {
/*  7476 */             param4MethodVisitor.visitJumpInsn(167, this.label);
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.label.equals(((ForLabel)param4Object).label))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.label.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public static interface Bound
/*       */       {
/*       */         public static final int NO_REQUIRED_SIZE = 0;
/*       */ 
/*       */ 
/*       */         
/*       */         int apply(MethodVisitor param3MethodVisitor, int param3Int);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public enum Disabled
/*       */         implements RelocationHandler, Bound
/*       */       {
/*  7509 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Advice.Dispatcher.RelocationHandler.Bound bind(MethodDescription param3MethodDescription, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) {
/*  7515 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final int apply(MethodVisitor param3MethodVisitor, int param3Int) {
/*  7522 */           return 0;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForValue
/*       */         implements RelocationHandler
/*       */       {
/*  7534 */         INTEGER(21, 154, 153, 0)
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final void convertValue(MethodVisitor param4MethodVisitor) {}
/*       */         },
/*  7544 */         LONG(22, 154, 153, 0)
/*       */         {
/*       */           protected final void convertValue(MethodVisitor param4MethodVisitor) {
/*  7547 */             param4MethodVisitor.visitInsn(136);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7554 */         FLOAT(23, 154, 153, 2)
/*       */         {
/*       */           protected final void convertValue(MethodVisitor param4MethodVisitor) {
/*  7557 */             param4MethodVisitor.visitInsn(11);
/*  7558 */             param4MethodVisitor.visitInsn(149);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7565 */         DOUBLE(24, 154, 153, 4)
/*       */         {
/*       */           protected final void convertValue(MethodVisitor param4MethodVisitor) {
/*  7568 */             param4MethodVisitor.visitInsn(14);
/*  7569 */             param4MethodVisitor.visitInsn(151);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7576 */         REFERENCE(25, 199, 198, 0)
/*       */         {
/*       */           protected final void convertValue(MethodVisitor param4MethodVisitor) {}
/*       */         };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int load;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int defaultJump;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int nonDefaultJump;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int requiredSize;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         ForValue(int param3Int1, int param3Int2, int param3Int3, int param3Int4) {
/*  7612 */           this.load = param3Int1;
/*  7613 */           this.defaultJump = param3Int2;
/*  7614 */           this.nonDefaultJump = param3Int3;
/*  7615 */           this.requiredSize = param3Int4;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static Advice.Dispatcher.RelocationHandler of(TypeDefinition param3TypeDefinition, boolean param3Boolean) {
/*       */           ForValue forValue;
/*  7627 */           if (param3TypeDefinition.represents(long.class))
/*  7628 */           { forValue = LONG; }
/*  7629 */           else if (forValue.represents(float.class))
/*  7630 */           { forValue = FLOAT; }
/*  7631 */           else if (forValue.represents(double.class))
/*  7632 */           { forValue = DOUBLE; }
/*  7633 */           else { if (forValue.represents(void.class))
/*  7634 */               throw new IllegalStateException("Cannot skip on default value for void return type"); 
/*  7635 */             if (forValue.isPrimitive()) {
/*  7636 */               forValue = INTEGER;
/*       */             } else {
/*  7638 */               forValue = REFERENCE;
/*       */             }  }
/*  7640 */            if (param3Boolean) { forValue.getClass(); return new Inverted(forValue); }  return forValue;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.Dispatcher.RelocationHandler.Bound bind(MethodDescription param3MethodDescription, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) {
/*  7656 */           return new Bound(this, param3MethodDescription, param3Relocation, false);
/*       */         }
/*       */ 
/*       */         
/*       */         protected abstract void convertValue(MethodVisitor param3MethodVisitor);
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         protected class Inverted
/*       */           implements Advice.Dispatcher.RelocationHandler
/*       */         {
/*       */           protected Inverted(Advice.Dispatcher.RelocationHandler.ForValue this$0) {}
/*       */           
/*       */           public Advice.Dispatcher.RelocationHandler.Bound bind(MethodDescription param4MethodDescription, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) {
/*  7669 */             return new Advice.Dispatcher.RelocationHandler.ForValue.Bound(this.a, param4MethodDescription, param4Relocation, true);
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.a.equals(((Inverted)param4Object).a))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.a.hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         protected class Bound
/*       */           implements Advice.Dispatcher.RelocationHandler.Bound
/*       */         {
/*       */           private final MethodDescription instrumentedMethod;
/*       */ 
/*       */           
/*       */           private final Advice.Dispatcher.RelocationHandler.Relocation relocation;
/*       */ 
/*       */           
/*       */           private final boolean inverted;
/*       */ 
/*       */ 
/*       */           
/*       */           protected Bound(Advice.Dispatcher.RelocationHandler.ForValue this$0, MethodDescription param4MethodDescription, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation, boolean param4Boolean) {
/*  7702 */             this.instrumentedMethod = param4MethodDescription;
/*  7703 */             this.relocation = param4Relocation;
/*  7704 */             this.inverted = param4Boolean;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int apply(MethodVisitor param4MethodVisitor, int param4Int) {
/*  7711 */             if (this.instrumentedMethod.isConstructor()) {
/*  7712 */               throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
/*       */             }
/*  7714 */             param4MethodVisitor.visitVarInsn(Advice.Dispatcher.RelocationHandler.ForValue.a(this.a), param4Int);
/*  7715 */             this.a.convertValue(param4MethodVisitor);
/*  7716 */             Label label = new Label();
/*  7717 */             param4MethodVisitor.visitJumpInsn(this.inverted ? 
/*  7718 */                 Advice.Dispatcher.RelocationHandler.ForValue.b(this.a) : 
/*  7719 */                 Advice.Dispatcher.RelocationHandler.ForValue.c(this.a), label);
/*  7720 */             this.relocation.apply(param4MethodVisitor);
/*  7721 */             param4MethodVisitor.visitLabel(label);
/*  7722 */             return Advice.Dispatcher.RelocationHandler.ForValue.d(this.a);
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.inverted != ((Bound)param4Object).inverted) ? false : (!this.a.equals(((Bound)param4Object).a) ? false : (!this.instrumentedMethod.equals(((Bound)param4Object).instrumentedMethod) ? false : (!!this.relocation.equals(((Bound)param4Object).relocation)))))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (((getClass().hashCode() * 31 + this.instrumentedMethod.hashCode()) * 31 + this.relocation.hashCode()) * 31 + this.inverted) * 31 + this.a.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */       
/*       */       @Enhance
/*       */       public static class ForType
/*       */         implements RelocationHandler
/*       */       {
/*       */         private final TypeDescription typeDescription;
/*       */         
/*       */         protected ForType(TypeDescription param3TypeDescription) {
/*  7744 */           this.typeDescription = param3TypeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static Advice.Dispatcher.RelocationHandler of(TypeDescription param3TypeDescription, TypeDefinition param3TypeDefinition) {
/*  7755 */           if (param3TypeDescription.represents(void.class))
/*  7756 */             return Advice.Dispatcher.RelocationHandler.Disabled.INSTANCE; 
/*  7757 */           if (param3TypeDescription.represents(Advice.OnDefaultValue.class))
/*  7758 */             return Advice.Dispatcher.RelocationHandler.ForValue.of(param3TypeDefinition, false); 
/*  7759 */           if (param3TypeDescription.represents(Advice.OnNonDefaultValue.class))
/*  7760 */             return Advice.Dispatcher.RelocationHandler.ForValue.of(param3TypeDefinition, true); 
/*  7761 */           if (param3TypeDescription.isPrimitive() || param3TypeDefinition.isPrimitive()) {
/*  7762 */             throw new IllegalStateException("Cannot skip method by instance type for primitive return type " + param3TypeDefinition);
/*       */           }
/*  7764 */           return new ForType(param3TypeDescription);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.Dispatcher.RelocationHandler.Bound bind(MethodDescription param3MethodDescription, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) {
/*  7772 */           return new Bound(this, param3MethodDescription, param3Relocation);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.typeDescription.equals(((ForType)param3Object).typeDescription))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         protected class Bound
/*       */           implements Advice.Dispatcher.RelocationHandler.Bound
/*       */         {
/*       */           private final MethodDescription instrumentedMethod;
/*       */           
/*       */           private final Advice.Dispatcher.RelocationHandler.Relocation relocation;
/*       */ 
/*       */           
/*       */           protected Bound(Advice.Dispatcher.RelocationHandler.ForType this$0, MethodDescription param4MethodDescription, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) {
/*  7798 */             this.instrumentedMethod = param4MethodDescription;
/*  7799 */             this.relocation = param4Relocation;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int apply(MethodVisitor param4MethodVisitor, int param4Int) {
/*  7806 */             if (this.instrumentedMethod.isConstructor()) {
/*  7807 */               throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
/*       */             }
/*  7809 */             param4MethodVisitor.visitVarInsn(25, param4Int);
/*  7810 */             param4MethodVisitor.visitTypeInsn(193, Advice.Dispatcher.RelocationHandler.ForType.a(this.a).getInternalName());
/*  7811 */             Label label = new Label();
/*  7812 */             param4MethodVisitor.visitJumpInsn(153, label);
/*  7813 */             this.relocation.apply(param4MethodVisitor);
/*  7814 */             param4MethodVisitor.visitLabel(label);
/*  7815 */             return 0;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.instrumentedMethod.equals(((Bound)param4Object).instrumentedMethod) ? false : (!this.relocation.equals(((Bound)param4Object).relocation) ? false : (!!this.a.equals(((Bound)param4Object).a))))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return ((getClass().hashCode() * 31 + this.instrumentedMethod.hashCode()) * 31 + this.relocation.hashCode()) * 31 + this.a.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Resolved
/*       */       extends Dispatcher
/*       */     {
/*       */       Map<String, TypeDefinition> getNamedTypes();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Advice.Dispatcher.Bound bind(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, MethodVisitor param2MethodVisitor, Implementation.Context param2Context, Assigner param2Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param2ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param2ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param2ForInstrumentedMethod2, StackManipulation param2StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param2Relocation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static abstract class AbstractBase
/*       */         implements Resolved
/*       */       {
/*       */         protected final MethodDescription.InDefinedShape adviceMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Advice.PostProcessor postProcessor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Map<Integer, Advice.OffsetMapping> offsetMappings;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Advice.Dispatcher.SuppressionHandler suppressionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Advice.Dispatcher.RelocationHandler relocationHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected AbstractBase(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) {
/*  7947 */           this.adviceMethod = param3InDefinedShape;
/*  7948 */           this.postProcessor = param3PostProcessor;
/*  7949 */           HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  7950 */           for (Advice.OffsetMapping.Factory<?> factory : param3List) {
/*  7951 */             hashMap.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);
/*       */           }
/*  7953 */           this.offsetMappings = new LinkedHashMap<Integer, Advice.OffsetMapping>();
/*  7954 */           for (ParameterDescription.InDefinedShape inDefinedShape : param3InDefinedShape.getParameters()) {
/*  7955 */             Advice.OffsetMapping offsetMapping = null;
/*  7956 */             for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) {
/*       */               Advice.OffsetMapping.Factory factory;
/*  7958 */               if ((factory = (Advice.OffsetMapping.Factory)hashMap.get(annotationDescription.getAnnotationType())) != null) {
/*       */                 
/*  7960 */                 Advice.OffsetMapping offsetMapping1 = factory.make(inDefinedShape, annotationDescription
/*  7961 */                     .prepare(factory.getAnnotationType()), param3AdviceType);
/*       */                 
/*  7963 */                 if (offsetMapping == null) {
/*  7964 */                   offsetMapping = offsetMapping1; continue;
/*       */                 } 
/*  7966 */                 throw new IllegalStateException(inDefinedShape + " is bound to both " + offsetMapping1 + " and " + offsetMapping);
/*       */               } 
/*       */             } 
/*       */             
/*  7970 */             this.offsetMappings.put(Integer.valueOf(inDefinedShape.getOffset()), (offsetMapping == null) ? new Advice.OffsetMapping.ForArgument.Unresolved((ParameterDescription)inDefinedShape) : offsetMapping);
/*       */           } 
/*       */ 
/*       */           
/*  7974 */           this.suppressionHandler = Advice.Dispatcher.SuppressionHandler.Suppressing.of(param3TypeDescription1);
/*  7975 */           this.relocationHandler = Advice.Dispatcher.RelocationHandler.ForType.of(param3TypeDescription2, (TypeDefinition)param3InDefinedShape.getReturnType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isAlive() {
/*  7982 */           return true;
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.adviceMethod.equals(((AbstractBase)param3Object).adviceMethod) ? false : (!this.postProcessor.equals(((AbstractBase)param3Object).postProcessor) ? false : (!this.offsetMappings.equals(((AbstractBase)param3Object).offsetMappings) ? false : (!this.suppressionHandler.equals(((AbstractBase)param3Object).suppressionHandler) ? false : (!!this.relocationHandler.equals(((AbstractBase)param3Object).relocationHandler))))))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return ((((getClass().hashCode() * 31 + this.adviceMethod.hashCode()) * 31 + this.postProcessor.hashCode()) * 31 + this.offsetMappings.hashCode()) * 31 + this.suppressionHandler.hashCode()) * 31 + this.relocationHandler.hashCode();
/*       */         }
/*       */       }
/*       */       
/*       */       public static interface ForMethodExit extends Resolved {
/*       */         TypeDescription getThrowable();
/*       */         
/*       */         Advice.ArgumentHandler.Factory getArgumentHandlerFactory();
/*       */       }
/*       */       
/*       */       public static interface ForMethodEnter extends Resolved {
/*       */         boolean isPrependLineNumber();
/*       */         
/*       */         TypeDefinition getActualAdviceType();
/*       */       }
/*       */     }
/*       */     
/*       */     public static interface Bound {
/*       */       void prepare();
/*       */       
/*       */       void initialize();
/*       */       
/*       */       void apply();
/*       */     }
/*       */     
/*       */     public enum Inactive implements Bound, Resolved.ForMethodEnter, Resolved.ForMethodExit, Unresolved {
/*  8016 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isAlive() {
/*  8022 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isBinary() {
/*  8029 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypeDescription getAdviceType() {
/*  8036 */         return TypeDescription.ForLoadedType.of(void.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isPrependLineNumber() {
/*  8043 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypeDefinition getActualAdviceType() {
/*  8050 */         return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Map<String, TypeDefinition> getNamedTypes() {
/*  8057 */         return Collections.emptyMap();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypeDescription getThrowable() {
/*  8064 */         return Advice.NoExceptionHandler.a();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.ArgumentHandler.Factory getArgumentHandlerFactory() {
/*  8071 */         return Advice.ArgumentHandler.Factory.SIMPLE;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Advice.Dispatcher.Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory) {
/*  8081 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Advice.Dispatcher.Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory) {
/*  8091 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void prepare() {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void initialize() {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void apply() {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Advice.Dispatcher.Bound bind(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, MethodVisitor param2MethodVisitor, Implementation.Context param2Context, Assigner param2Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param2ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param2ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param2ForInstrumentedMethod2, StackManipulation param2StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param2Relocation) {
/*  8128 */         return this;
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Inlining
/*       */       implements Unresolved
/*       */     {
/*       */       protected final MethodDescription.InDefinedShape adviceMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Map<String, TypeDefinition> namedTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Inlining(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  8154 */         this.adviceMethod = param2InDefinedShape;
/*  8155 */         this.namedTypes = new HashMap<String, TypeDefinition>();
/*  8156 */         for (Iterator<ParameterDescription> iterator = param2InDefinedShape.getParameters().iterator(); iterator.hasNext(); ) {
/*       */ 
/*       */           
/*  8159 */           String str = (String)loadable.getValue(Advice.OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class); ParameterDescription parameterDescription; AnnotationDescription.Loadable loadable;
/*       */           TypeDefinition typeDefinition;
/*  8161 */           if ((loadable = (parameterDescription = iterator.next()).getDeclaredAnnotations().ofType(Advice.Local.class)) != null && (typeDefinition = (TypeDefinition)this.namedTypes.put(str, parameterDescription.getType())) != null && !typeDefinition.equals(parameterDescription.getType())) {
/*  8162 */             throw new IllegalStateException("Local variable for " + str + " is defined with inconsistent types");
/*       */           }
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isAlive() {
/*  8172 */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isBinary() {
/*  8179 */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription getAdviceType() {
/*  8186 */         return this.adviceMethod.getReturnType().asErasure();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Map<String, TypeDefinition> getNamedTypes() {
/*  8193 */         return this.namedTypes;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Advice.Dispatcher.Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory) {
/*  8203 */         if (param2ClassReader == null) {
/*  8204 */           throw new IllegalStateException("Class reader not expected null");
/*       */         }
/*  8206 */         return Resolved.ForMethodEnter.of(this.adviceMethod, param2Factory
/*  8207 */             .make(this.adviceMethod, false), this.namedTypes, param2List, param2Unresolved
/*       */ 
/*       */             
/*  8210 */             .getAdviceType(), param2ClassReader, param2Unresolved
/*       */             
/*  8212 */             .isAlive());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Advice.Dispatcher.Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory) {
/*  8222 */         HashMap<String, TypeDefinition> hashMap = new HashMap<String, TypeDefinition>(param2Unresolved.getNamedTypes()); HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/*  8223 */         for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) {
/*  8224 */           TypeDefinition typeDefinition1 = hashMap.get(entry.getKey()), typeDefinition2 = (TypeDefinition)hashMap1.get(entry.getKey());
/*  8225 */           if (typeDefinition1 == null && typeDefinition2 == null) {
/*  8226 */             hashMap.put((String)entry.getKey(), (TypeDefinition)entry.getValue());
/*  8227 */             hashMap1.put(entry.getKey(), entry.getValue()); continue;
/*  8228 */           }  if (!((typeDefinition1 == null) ? typeDefinition2 : typeDefinition1).equals(entry.getValue())) {
/*  8229 */             throw new IllegalStateException("Local variable for " + (String)entry.getKey() + " is defined with inconsistent types");
/*       */           }
/*       */         } 
/*  8232 */         return Resolved.ForMethodExit.of(this.adviceMethod, param2Factory.make(this.adviceMethod, true), hashMap, (Map)hashMap1, param2List, param2ClassReader, param2Unresolved.getAdviceType());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.adviceMethod.equals(((Inlining)param2Object).adviceMethod) ? false : (!!this.namedTypes.equals(((Inlining)param2Object).namedTypes)))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (getClass().hashCode() * 31 + this.adviceMethod.hashCode()) * 31 + this.namedTypes.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static abstract class Resolved
/*       */         extends Advice.Dispatcher.Resolved.AbstractBase
/*       */       {
/*       */         protected final ClassReader classReader;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Resolved(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2, ClassReader param3ClassReader) {
/*  8261 */           super(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDescription1, param3TypeDescription2, Advice.OffsetMapping.Factory.AdviceType.INLINING);
/*  8262 */           this.classReader = param3ClassReader;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param3ArgumentHandler);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract MethodVisitor apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected class AdviceMethodInliner
/*       */           extends ClassVisitor
/*       */           implements Advice.Dispatcher.Bound
/*       */         {
/*       */           protected final TypeDescription instrumentedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final MethodVisitor methodVisitor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Implementation.Context implementationContext;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Assigner assigner;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.ArgumentHandler.ForInstrumentedMethod argumentHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.Dispatcher.SuppressionHandler.Bound suppressionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.Dispatcher.RelocationHandler.Bound relocationHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final StackManipulation exceptionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final ClassReader classReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final List<Label> labels;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected AdviceMethodInliner(Advice.Dispatcher.Inlining.Resolved this$0, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation, ClassReader param4ClassReader) {
/*  8400 */             super(OpenedClassReader.ASM_API);
/*  8401 */             this.instrumentedType = param4TypeDescription;
/*  8402 */             this.instrumentedMethod = param4MethodDescription;
/*  8403 */             this.methodVisitor = param4MethodVisitor;
/*  8404 */             this.implementationContext = param4Context;
/*  8405 */             this.assigner = param4Assigner;
/*  8406 */             this.argumentHandler = param4ForInstrumentedMethod;
/*  8407 */             this.methodSizeHandler = param4ForInstrumentedMethod1;
/*  8408 */             this.stackMapFrameHandler = param4ForInstrumentedMethod2;
/*  8409 */             this.suppressionHandler = param4Bound;
/*  8410 */             this.relocationHandler = param4Bound1;
/*  8411 */             this.exceptionHandler = param4StackManipulation;
/*  8412 */             this.classReader = param4ClassReader;
/*  8413 */             this.labels = new ArrayList<Label>();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void prepare() {
/*  8420 */             this.classReader.accept(new ExceptionTableExtractor(this), 6);
/*  8421 */             this.suppressionHandler.onPrepare(this.methodVisitor);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void initialize() {
/*  8428 */             for (Iterator<Map.Entry> iterator = this.a.resolveInitializationTypes(this.argumentHandler).entrySet().iterator(); iterator.hasNext(); ) {
/*  8429 */               Map.Entry<?, TypeDefinition> entry; if (((TypeDefinition)(entry = iterator.next()).getValue()).represents(boolean.class) || ((TypeDefinition)entry
/*  8430 */                 .getValue()).represents(byte.class) || ((TypeDefinition)entry
/*  8431 */                 .getValue()).represents(short.class) || ((TypeDefinition)entry
/*  8432 */                 .getValue()).represents(char.class) || ((TypeDefinition)entry
/*  8433 */                 .getValue()).represents(int.class)) {
/*  8434 */                 this.methodVisitor.visitInsn(3);
/*  8435 */                 this.methodVisitor.visitVarInsn(54, ((Integer)entry.getKey()).intValue());
/*  8436 */               } else if (((TypeDefinition)entry.getValue()).represents(long.class)) {
/*  8437 */                 this.methodVisitor.visitInsn(9);
/*  8438 */                 this.methodVisitor.visitVarInsn(55, ((Integer)entry.getKey()).intValue());
/*  8439 */               } else if (((TypeDefinition)entry.getValue()).represents(float.class)) {
/*  8440 */                 this.methodVisitor.visitInsn(11);
/*  8441 */                 this.methodVisitor.visitVarInsn(56, ((Integer)entry.getKey()).intValue());
/*  8442 */               } else if (((TypeDefinition)entry.getValue()).represents(double.class)) {
/*  8443 */                 this.methodVisitor.visitInsn(14);
/*  8444 */                 this.methodVisitor.visitVarInsn(57, ((Integer)entry.getKey()).intValue());
/*       */               } else {
/*  8446 */                 this.methodVisitor.visitInsn(1);
/*  8447 */                 this.methodVisitor.visitVarInsn(58, ((Integer)entry.getKey()).intValue());
/*       */               } 
/*  8449 */               this.methodSizeHandler.requireStackSize(((TypeDefinition)entry.getValue()).getStackSize().getSize());
/*       */             } 
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void apply() {
/*  8457 */             this.classReader.accept(this, 0x2 | this.stackMapFrameHandler.getReaderHint());
/*       */           }
/*       */ 
/*       */           
/*       */           @MaybeNull
/*       */           public MethodVisitor visitMethod(int param4Int, String param4String1, String param4String2, @MaybeNull String param4String3, @MaybeNull String[] param4ArrayOfString) {
/*  8463 */             return (this.a.adviceMethod.getInternalName().equals(param4String1) && this.a.adviceMethod.getDescriptor().equals(param4String2)) ? new ExceptionTableSubstitutor(this, this.a
/*  8464 */                 .apply(this.methodVisitor, this.implementationContext, this.assigner, this.argumentHandler, this.methodSizeHandler, this.stackMapFrameHandler, this.instrumentedType, this.instrumentedMethod, this.suppressionHandler, this.relocationHandler, this.exceptionHandler)) : Advice.Dispatcher.IGNORE_METHOD;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected class ExceptionTableExtractor
/*       */             extends ClassVisitor
/*       */           {
/*       */             protected ExceptionTableExtractor(Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner this$0) {
/*  8486 */               super(OpenedClassReader.ASM_API);
/*       */             }
/*       */ 
/*       */             
/*       */             @MaybeNull
/*       */             public MethodVisitor visitMethod(int param5Int, String param5String1, String param5String2, @MaybeNull String param5String3, @MaybeNull String[] param5ArrayOfString) {
/*  8492 */               return (this.a.a.adviceMethod.getInternalName().equals(param5String1) && this.a.a.adviceMethod.getDescriptor().equals(param5String2)) ? new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner.ExceptionTableCollector(this.a, this.a.methodVisitor) : Advice.Dispatcher.IGNORE_METHOD;
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected class ExceptionTableCollector
/*       */             extends MethodVisitor
/*       */           {
/*       */             private final MethodVisitor methodVisitor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected ExceptionTableCollector(Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner this$0, MethodVisitor param5MethodVisitor) {
/*  8515 */               super(OpenedClassReader.ASM_API);
/*  8516 */               this.methodVisitor = param5MethodVisitor;
/*       */             }
/*       */ 
/*       */             
/*       */             public void visitTryCatchBlock(Label param5Label1, Label param5Label2, Label param5Label3, @MaybeNull String param5String) {
/*  8521 */               this.methodVisitor.visitTryCatchBlock(param5Label1, param5Label2, param5Label3, param5String);
/*  8522 */               this.a.labels.addAll(Arrays.asList(new Label[] { param5Label1, param5Label2, param5Label3 }));
/*       */             }
/*       */ 
/*       */             
/*       */             @MaybeNull
/*       */             public AnnotationVisitor visitTryCatchAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) {
/*  8528 */               return this.methodVisitor.visitTryCatchAnnotation(param5Int, param5TypePath, param5String, param5Boolean);
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected class ExceptionTableSubstitutor
/*       */             extends MethodVisitor
/*       */           {
/*       */             private final Map<Label, Label> substitutions;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             private int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected ExceptionTableSubstitutor(Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner this$0, MethodVisitor param5MethodVisitor) {
/*  8556 */               super(OpenedClassReader.ASM_API, param5MethodVisitor);
/*  8557 */               this.substitutions = new IdentityHashMap<Label, Label>();
/*       */             }
/*       */ 
/*       */             
/*       */             public void visitTryCatchBlock(Label param5Label1, Label param5Label2, Label param5Label3, String param5String) {
/*  8562 */               this.substitutions.put(param5Label1, this.a.labels.get(this.index++));
/*  8563 */               this.substitutions.put(param5Label2, this.a.labels.get(this.index++));
/*  8564 */               param5Label1 = this.a.labels.get(this.index++);
/*  8565 */               this.substitutions.put(param5Label3, param5Label1);
/*  8566 */               ((Advice.Dispatcher.Inlining.CodeTranslationVisitor)this.mv).propagateHandler(param5Label1);
/*       */             }
/*       */ 
/*       */             
/*       */             @MaybeNull
/*       */             public AnnotationVisitor visitTryCatchAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) {
/*  8572 */               return Advice.Dispatcher.IGNORE_ANNOTATION;
/*       */             }
/*       */ 
/*       */             
/*       */             public void visitLabel(Label param5Label) {
/*  8577 */               super.visitLabel(resolve(param5Label));
/*       */             }
/*       */ 
/*       */             
/*       */             public void visitJumpInsn(int param5Int, Label param5Label) {
/*  8582 */               super.visitJumpInsn(param5Int, resolve(param5Label));
/*       */             }
/*       */ 
/*       */             
/*       */             public void visitTableSwitchInsn(int param5Int1, int param5Int2, Label param5Label, Label... param5VarArgs) {
/*  8587 */               super.visitTableSwitchInsn(param5Int1, param5Int2, param5Label, resolve(param5VarArgs));
/*       */             }
/*       */ 
/*       */             
/*       */             public void visitLookupSwitchInsn(Label param5Label, int[] param5ArrayOfint, Label[] param5ArrayOfLabel) {
/*  8592 */               super.visitLookupSwitchInsn(resolve(param5Label), param5ArrayOfint, resolve(param5ArrayOfLabel));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             private Label[] resolve(Label[] param5ArrayOfLabel) {
/*  8602 */               Label[] arrayOfLabel = new Label[param5ArrayOfLabel.length];
/*  8603 */               byte b1 = 0; int i; byte b2;
/*  8604 */               for (i = (param5ArrayOfLabel = param5ArrayOfLabel).length, b2 = 0; b2 < i; ) { Label label = param5ArrayOfLabel[b2];
/*  8605 */                 arrayOfLabel[b1++] = resolve(label); b2++; }
/*       */               
/*  8607 */               return arrayOfLabel;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             private Label resolve(Label param5Label) {
/*       */               Label label;
/*  8618 */               return ((label = this.substitutions.get(param5Label)) == null) ? param5Label : label;
/*       */             }
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static abstract class ForMethodEnter
/*       */           extends Resolved
/*       */           implements Advice.Dispatcher.Resolved.ForMethodEnter
/*       */         {
/*       */           private final Map<String, TypeDefinition> namedTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final boolean prependLineNumber;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */           protected ForMethodEnter(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, ClassReader param4ClassReader) {
/*  8659 */             super(param4InDefinedShape, param4PostProcessor, 
/*       */                 
/*  8661 */                 CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */                       
/*  8669 */                       Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param4TypeDefinition), new Advice.OffsetMapping.ForLocalValue.Factory(param4Map), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class)
/*       */                     },
/*       */ 
/*       */ 
/*       */                   
/*  8674 */                   ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape
/*  8675 */                 .getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param4ClassReader);
/*       */             
/*  8677 */             this.namedTypes = param4Map;
/*  8678 */             this.prependLineNumber = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, ClassReader param4ClassReader, boolean param4Boolean) {
/*  8700 */             return (Advice.Dispatcher.Resolved.ForMethodEnter)(param4Boolean ? new WithRetainedEnterType(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, param4ClassReader) : new WithDiscardedEnterType(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, param4ClassReader));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param4ArgumentHandler) {
/*  8707 */             TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/*  8708 */             for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) {
/*  8709 */               treeMap.put(Integer.valueOf(param4ArgumentHandler.named((String)entry.getKey())), entry.getValue());
/*       */             }
/*  8711 */             return (Map)treeMap;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Advice.Dispatcher.Bound bind(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) {
/*  8727 */             return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod, param4ForInstrumentedMethod1, param4ForInstrumentedMethod2, this.suppressionHandler
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */                 
/*  8735 */                 .bind(param4StackManipulation), this.relocationHandler
/*  8736 */                 .bind(param4MethodDescription, param4Relocation), param4StackManipulation, this.classReader);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isPrependLineNumber() {
/*  8745 */             return this.prependLineNumber;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDefinition getActualAdviceType() {
/*  8752 */             return (TypeDefinition)this.adviceMethod.getReturnType();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Map<String, TypeDefinition> getNamedTypes() {
/*  8759 */             return this.namedTypes;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected MethodVisitor apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) {
/*  8774 */             return doApply(param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod
/*       */ 
/*       */                 
/*  8777 */                 .bindEnter((MethodDescription)this.adviceMethod), param4ForInstrumentedMethod1
/*  8778 */                 .bindEnter(this.adviceMethod), param4ForInstrumentedMethod2
/*  8779 */                 .bindEnter(this.adviceMethod), param4TypeDescription, param4MethodDescription, param4Bound, param4Bound1, param4StackManipulation);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected MethodVisitor doApply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) {
/*  8814 */             HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  8815 */             for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) {
/*  8816 */               hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.ENTER));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  8822 */             return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4TypeDescription, param4MethodDescription, param4Assigner, this.adviceMethod, (Map)hashMap, param4Bound, param4Bound1, param4StackManipulation, this.postProcessor, false);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.prependLineNumber != ((ForMethodEnter)param4Object).prependLineNumber) ? false : (!!this.namedTypes.equals(((ForMethodEnter)param4Object).namedTypes))))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (super.hashCode() * 31 + this.namedTypes.hashCode()) * 31 + this.prependLineNumber;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class WithRetainedEnterType
/*       */             extends ForMethodEnter
/*       */           {
/*       */             protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) {
/*  8861 */               super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDefinition getAdviceType() {
/*  8868 */               return (TypeDefinition)this.adviceMethod.getReturnType();
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class WithDiscardedEnterType
/*       */             extends ForMethodEnter
/*       */           {
/*       */             protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) {
/*  8893 */               super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDefinition getAdviceType() {
/*  8900 */               return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected MethodVisitor doApply(MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) {
/*  8917 */               param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize());
/*  8918 */               return super.doApply(param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5TypeDescription, param5MethodDescription, param5Bound, param5Bound1, param5StackManipulation);
/*       */             }
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static abstract class ForMethodExit
/*       */           extends Resolved
/*       */           implements Advice.Dispatcher.Resolved.ForMethodExit
/*       */         {
/*       */           private final Map<String, TypeDefinition> uninitializedNamedTypes;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final boolean backupArguments;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */           protected ForMethodExit(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map1, Map<String, TypeDefinition> param4Map2, List<? extends Advice.OffsetMapping.Factory<?>> param4List, ClassReader param4ClassReader, TypeDefinition param4TypeDefinition) {
/*  8969 */             super(param4InDefinedShape, param4PostProcessor, 
/*       */                 
/*  8971 */                 CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */                       
/*  8978 */                       Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param4TypeDefinition), 
/*  8979 */                       Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param4InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param4Map1), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, 
/*       */ 
/*       */                       
/*  8982 */                       Advice.OffsetMapping.ForThrowable.Factory.of(param4InDefinedShape)
/*       */                     },
/*  8984 */                   ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape
/*  8985 */                 .getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param4ClassReader);
/*       */             
/*  8987 */             this.uninitializedNamedTypes = param4Map2;
/*  8988 */             this.backupArguments = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */           protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map1, Map<String, TypeDefinition> param4Map2, List<? extends Advice.OffsetMapping.Factory<?>> param4List, ClassReader param4ClassReader, TypeDefinition param4TypeDefinition) {
/*       */             TypeDescription typeDescription;
/*  9014 */             return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map1, param4Map2, param4List, param4ClassReader, param4TypeDefinition) : new WithExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map1, param4Map2, param4List, param4ClassReader, param4TypeDefinition, typeDescription));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Map<String, TypeDefinition> getNamedTypes() {
/*  9023 */             return this.uninitializedNamedTypes;
/*       */           }
/*       */ 
/*       */           
/*       */           protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param4ArgumentHandler) {
/*  9028 */             TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/*  9029 */             for (Map.Entry<String, TypeDefinition> entry : this.uninitializedNamedTypes.entrySet()) {
/*  9030 */               treeMap.put(Integer.valueOf(param4ArgumentHandler.named((String)entry.getKey())), entry.getValue());
/*       */             }
/*  9032 */             if (!this.adviceMethod.getReturnType().represents(void.class)) {
/*  9033 */               treeMap.put(Integer.valueOf(param4ArgumentHandler.exit()), this.adviceMethod.getReturnType());
/*       */             }
/*  9035 */             return (Map)treeMap;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected MethodVisitor apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) {
/*  9050 */             return doApply(param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod
/*       */ 
/*       */                 
/*  9053 */                 .bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param4ForInstrumentedMethod1
/*  9054 */                 .bindExit(this.adviceMethod), param4ForInstrumentedMethod2
/*  9055 */                 .bindExit(this.adviceMethod), param4TypeDescription, param4MethodDescription, param4Bound, param4Bound1, param4StackManipulation);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private MethodVisitor doApply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) {
/*  9090 */             HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  9091 */             for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) {
/*  9092 */               hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.EXIT));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  9098 */             return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4TypeDescription, param4MethodDescription, param4Assigner, this.adviceMethod, (Map)hashMap, param4Bound, param4Bound1, param4StackManipulation, this.postProcessor, true);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() {
/*  9119 */             return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDefinition getAdviceType() {
/*  9128 */             return (TypeDefinition)this.adviceMethod.getReturnType();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Advice.Dispatcher.Bound bind(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) {
/*  9144 */             return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod, param4ForInstrumentedMethod1, param4ForInstrumentedMethod2, this.suppressionHandler
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */                 
/*  9152 */                 .bind(param4StackManipulation), this.relocationHandler
/*  9153 */                 .bind(param4MethodDescription, param4Relocation), param4StackManipulation, this.classReader);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.backupArguments != ((ForMethodExit)param4Object).backupArguments) ? false : (!!this.uninitializedNamedTypes.equals(((ForMethodExit)param4Object).uninitializedNamedTypes))))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (super.hashCode() * 31 + this.uninitializedNamedTypes.hashCode()) * 31 + this.backupArguments;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @Enhance
/*       */           protected static class WithExceptionHandler
/*       */             extends ForMethodExit
/*       */           {
/*       */             private final TypeDescription throwable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription) {
/*  9190 */               super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition);
/*  9191 */               this.throwable = param5TypeDescription;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDescription getThrowable() {
/*  9198 */               return this.throwable;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean equals(@MaybeNull Object param5Object) {
/*       */               return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable)))));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public int hashCode() {
/*       */               return super.hashCode() * 31 + this.throwable.hashCode();
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class WithoutExceptionHandler
/*       */             extends ForMethodExit
/*       */           {
/*       */             protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition) {
/*  9226 */               super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition);
/*       */             }
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDescription getThrowable()
/*       */             {
/*  9233 */               return Advice.NoExceptionHandler.a(); } } } } @Enhance protected static abstract class ForMethodEnter extends Resolved implements Advice.Dispatcher.Resolved.ForMethodEnter { private final Map<String, TypeDefinition> namedTypes; private final boolean prependLineNumber; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodEnter(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, ClassReader param3ClassReader) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param3TypeDefinition), new Advice.OffsetMapping.ForLocalValue.Factory(param3Map), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param3ClassReader); this.namedTypes = param3Map; this.prependLineNumber = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue(); } protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, ClassReader param3ClassReader, boolean param3Boolean) { return (Advice.Dispatcher.Resolved.ForMethodEnter)(param3Boolean ? new WithRetainedEnterType(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, param3ClassReader) : new WithDiscardedEnterType(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, param3ClassReader)); } protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param3ArgumentHandler) { TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) treeMap.put(Integer.valueOf(param3ArgumentHandler.named((String)entry.getKey())), entry.getValue());  return (Map)treeMap; } public Advice.Dispatcher.Bound bind(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod, param3ForInstrumentedMethod1, param3ForInstrumentedMethod2, this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation, this.classReader); } public boolean isPrependLineNumber() { return this.prependLineNumber; } public TypeDefinition getActualAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public Map<String, TypeDefinition> getNamedTypes() { return this.namedTypes; } protected MethodVisitor apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { return doApply(param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindEnter((MethodDescription)this.adviceMethod), param3ForInstrumentedMethod1.bindEnter(this.adviceMethod), param3ForInstrumentedMethod2.bindEnter(this.adviceMethod), param3TypeDescription, param3MethodDescription, param3Bound, param3Bound1, param3StackManipulation); } protected MethodVisitor doApply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.ENTER));  return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3TypeDescription, param3MethodDescription, param3Assigner, this.adviceMethod, (Map)hashMap, param3Bound, param3Bound1, param3StackManipulation, this.postProcessor, false); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.prependLineNumber != ((ForMethodEnter)param3Object).prependLineNumber) ? false : (!!this.namedTypes.equals(((ForMethodEnter)param3Object).namedTypes)))))); } public int hashCode() { return (super.hashCode() * 31 + this.namedTypes.hashCode()) * 31 + this.prependLineNumber; } protected static class WithRetainedEnterType extends ForMethodEnter { protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader); } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } } protected static class WithDiscardedEnterType extends ForMethodEnter { protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader); } public TypeDefinition getAdviceType() { return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class); } protected MethodVisitor doApply(MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) { param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize()); return super.doApply(param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5TypeDescription, param5MethodDescription, param5Bound, param5Bound1, param5StackManipulation); } } } @Enhance protected static abstract class ForMethodExit extends Resolved implements Advice.Dispatcher.Resolved.ForMethodExit { private final Map<String, TypeDefinition> uninitializedNamedTypes; private final boolean backupArguments; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodExit(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map1, Map<String, TypeDefinition> param3Map2, List<? extends Advice.OffsetMapping.Factory<?>> param3List, ClassReader param3ClassReader, TypeDefinition param3TypeDefinition) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param3TypeDefinition), Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param3InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param3Map1), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.of(param3InDefinedShape) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param3ClassReader); this.uninitializedNamedTypes = param3Map2; this.backupArguments = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue(); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map1, Map<String, TypeDefinition> param3Map2, List<? extends Advice.OffsetMapping.Factory<?>> param3List, ClassReader param3ClassReader, TypeDefinition param3TypeDefinition) { TypeDescription typeDescription; return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map1, param3Map2, param3List, param3ClassReader, param3TypeDefinition) : new WithExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map1, param3Map2, param3List, param3ClassReader, param3TypeDefinition, typeDescription)); } public Map<String, TypeDefinition> getNamedTypes() { return this.uninitializedNamedTypes; } protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param3ArgumentHandler) { TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); for (Map.Entry<String, TypeDefinition> entry : this.uninitializedNamedTypes.entrySet()) treeMap.put(Integer.valueOf(param3ArgumentHandler.named((String)entry.getKey())), entry.getValue());  if (!this.adviceMethod.getReturnType().represents(void.class)) treeMap.put(Integer.valueOf(param3ArgumentHandler.exit()), this.adviceMethod.getReturnType());  return (Map)treeMap; } protected MethodVisitor apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { return doApply(param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param3ForInstrumentedMethod1.bindExit(this.adviceMethod), param3ForInstrumentedMethod2.bindExit(this.adviceMethod), param3TypeDescription, param3MethodDescription, param3Bound, param3Bound1, param3StackManipulation); } private MethodVisitor doApply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.EXIT));  return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3TypeDescription, param3MethodDescription, param3Assigner, this.adviceMethod, (Map)hashMap, param3Bound, param3Bound1, param3StackManipulation, this.postProcessor, true); } public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() { return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE; } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public Advice.Dispatcher.Bound bind(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod, param3ForInstrumentedMethod1, param3ForInstrumentedMethod2, this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation, this.classReader); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.backupArguments != ((ForMethodExit)param3Object).backupArguments) ? false : (!!this.uninitializedNamedTypes.equals(((ForMethodExit)param3Object).uninitializedNamedTypes)))))); } public int hashCode() { return (super.hashCode() * 31 + this.uninitializedNamedTypes.hashCode()) * 31 + this.backupArguments; } @Enhance protected static class WithExceptionHandler extends ForMethodExit { private final TypeDescription throwable; protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription) { super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition); this.throwable = param5TypeDescription; } public TypeDescription getThrowable() { return this.throwable; } public boolean equals(@MaybeNull Object param5Object) { return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable))))); } public int hashCode() { return super.hashCode() * 31 + this.throwable.hashCode(); } } protected static class WithoutExceptionHandler extends ForMethodExit { protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition) { super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition); } public TypeDescription getThrowable() { return Advice.NoExceptionHandler.a(); }
/*       */            }
/*       */          }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class CodeTranslationVisitor
/*       */         extends MethodVisitor
/*       */       {
/*       */         protected final MethodVisitor methodVisitor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Implementation.Context implementationContext;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Advice.ArgumentHandler.ForAdvice argumentHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Advice.MethodSizeHandler.ForAdvice methodSizeHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Advice.StackMapFrameHandler.ForAdvice stackMapFrameHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription instrumentedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Assigner assigner;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final MethodDescription.InDefinedShape adviceMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Map<Integer, Advice.OffsetMapping.Target> offsetMappings;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Advice.Dispatcher.SuppressionHandler.Bound suppressionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Advice.Dispatcher.RelocationHandler.Bound relocationHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final StackManipulation exceptionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Advice.PostProcessor postProcessor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean exit;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Label endOfMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected CodeTranslationVisitor(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, MethodDescription.InDefinedShape param3InDefinedShape, Map<Integer, Advice.OffsetMapping.Target> param3Map, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation, Advice.PostProcessor param3PostProcessor, boolean param3Boolean) {
/*  9358 */           super(OpenedClassReader.ASM_API, StackAwareMethodVisitor.of(param3MethodVisitor, param3MethodDescription));
/*  9359 */           this.methodVisitor = param3MethodVisitor;
/*  9360 */           this.implementationContext = param3Context;
/*  9361 */           this.argumentHandler = param3ForAdvice;
/*  9362 */           this.methodSizeHandler = param3ForAdvice1;
/*  9363 */           this.stackMapFrameHandler = param3ForAdvice2;
/*  9364 */           this.instrumentedType = param3TypeDescription;
/*  9365 */           this.instrumentedMethod = param3MethodDescription;
/*  9366 */           this.assigner = param3Assigner;
/*  9367 */           this.adviceMethod = param3InDefinedShape;
/*  9368 */           this.offsetMappings = param3Map;
/*  9369 */           this.suppressionHandler = param3Bound;
/*  9370 */           this.relocationHandler = param3Bound1;
/*  9371 */           this.exceptionHandler = param3StackManipulation;
/*  9372 */           this.postProcessor = param3PostProcessor;
/*  9373 */           this.exit = param3Boolean;
/*  9374 */           this.endOfMethod = new Label();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected void propagateHandler(Label param3Label) {
/*  9384 */           ((StackAwareMethodVisitor)this.mv).register(param3Label, Collections.singletonList(StackSize.SINGLE));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void visitParameter(String param3String, int param3Int) {}
/*       */ 
/*       */ 
/*       */         
/*       */         public void visitAnnotableParameterCount(int param3Int, boolean param3Boolean) {}
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public AnnotationVisitor visitAnnotationDefault() {
/*  9400 */           return Advice.Dispatcher.IGNORE_ANNOTATION;
/*       */         }
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public AnnotationVisitor visitAnnotation(String param3String, boolean param3Boolean) {
/*  9406 */           return Advice.Dispatcher.IGNORE_ANNOTATION;
/*       */         }
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public AnnotationVisitor visitTypeAnnotation(int param3Int, @MaybeNull TypePath param3TypePath, String param3String, boolean param3Boolean) {
/*  9412 */           return Advice.Dispatcher.IGNORE_ANNOTATION;
/*       */         }
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public AnnotationVisitor visitParameterAnnotation(int param3Int, String param3String, boolean param3Boolean) {
/*  9418 */           return Advice.Dispatcher.IGNORE_ANNOTATION;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public void visitAttribute(Attribute param3Attribute) {}
/*       */ 
/*       */ 
/*       */         
/*       */         public void visitCode() {
/*  9428 */           this.suppressionHandler.onStart(this.methodVisitor);
/*       */         }
/*       */ 
/*       */         
/*       */         public void visitFrame(int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2) {
/*  9433 */           this.stackMapFrameHandler.translateFrame(this.methodVisitor, param3Int1, param3Int2, param3ArrayOfObject1, param3Int3, param3ArrayOfObject2);
/*       */         }
/*       */         public void visitVarInsn(int param3Int1, int param3Int2) {
/*       */           StackManipulation stackManipulation;
/*       */           StackSize stackSize;
/*       */           Advice.OffsetMapping.Target target;
/*  9439 */           if ((target = this.offsetMappings.get(Integer.valueOf(param3Int2))) != null) {
/*       */ 
/*       */             
/*  9442 */             switch (param3Int1) {
/*       */               case 21:
/*       */               case 23:
/*       */               case 25:
/*  9446 */                 stackManipulation = target.resolveRead();
/*  9447 */                 stackSize = StackSize.SINGLE;
/*       */                 break;
/*       */               case 22:
/*       */               case 24:
/*  9451 */                 stackManipulation = target.resolveRead();
/*  9452 */                 stackSize = StackSize.DOUBLE;
/*       */                 break;
/*       */               case 54:
/*       */               case 55:
/*       */               case 56:
/*       */               case 57:
/*       */               case 58:
/*  9459 */                 stackManipulation = target.resolveWrite();
/*  9460 */                 stackSize = StackSize.ZERO;
/*       */                 break;
/*       */               default:
/*  9463 */                 throw new IllegalStateException("Unexpected opcode: " + stackManipulation);
/*       */             } 
/*  9465 */             this.methodSizeHandler.requireStackSizePadding(stackManipulation.apply(this.mv, this.implementationContext).getMaximalSize() - stackSize.getSize()); return;
/*       */           } 
/*  9467 */           this.mv.visitVarInsn(stackManipulation, this.argumentHandler.mapped(stackSize));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public void visitIincInsn(int param3Int1, int param3Int2) {
/*       */           Advice.OffsetMapping.Target target;
/*  9474 */           if ((target = this.offsetMappings.get(Integer.valueOf(param3Int1))) != null) {
/*  9475 */             this.methodSizeHandler.requireStackSizePadding(target.resolveIncrement(param3Int2).apply(this.mv, this.implementationContext).getMaximalSize()); return;
/*       */           } 
/*  9477 */           this.mv.visitIincInsn(this.argumentHandler.mapped(param3Int1), param3Int2);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public void visitInsn(int param3Int) {
/*  9483 */           switch (param3Int) {
/*       */             case 177:
/*  9485 */               ((StackAwareMethodVisitor)this.mv).drainStack();
/*       */               break;
/*       */             case 172:
/*  9488 */               this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(54, 21, StackSize.SINGLE));
/*       */               break;
/*       */             case 176:
/*  9491 */               this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(58, 25, StackSize.SINGLE));
/*       */               break;
/*       */             case 174:
/*  9494 */               this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(56, 23, StackSize.SINGLE));
/*       */               break;
/*       */             case 173:
/*  9497 */               this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(55, 22, StackSize.DOUBLE));
/*       */               break;
/*       */             case 175:
/*  9500 */               this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(57, 24, StackSize.DOUBLE));
/*       */               break;
/*       */             default:
/*  9503 */               this.mv.visitInsn(param3Int);
/*       */               return;
/*       */           } 
/*  9506 */           this.mv.visitJumpInsn(167, this.endOfMethod);
/*       */         }
/*       */ 
/*       */         
/*       */         public void visitEnd() {
/*  9511 */           this.suppressionHandler.onEnd(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, (TypeDefinition)this.adviceMethod.getReturnType());
/*  9512 */           this.methodVisitor.visitLabel(this.endOfMethod);
/*  9513 */           if (this.adviceMethod.getReturnType().represents(boolean.class) || this.adviceMethod
/*  9514 */             .getReturnType().represents(byte.class) || this.adviceMethod
/*  9515 */             .getReturnType().represents(short.class) || this.adviceMethod
/*  9516 */             .getReturnType().represents(char.class) || this.adviceMethod
/*  9517 */             .getReturnType().represents(int.class)) {
/*  9518 */             this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
/*  9519 */             this.methodVisitor.visitVarInsn(54, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9520 */           } else if (this.adviceMethod.getReturnType().represents(long.class)) {
/*  9521 */             this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
/*  9522 */             this.methodVisitor.visitVarInsn(55, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9523 */           } else if (this.adviceMethod.getReturnType().represents(float.class)) {
/*  9524 */             this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
/*  9525 */             this.methodVisitor.visitVarInsn(56, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9526 */           } else if (this.adviceMethod.getReturnType().represents(double.class)) {
/*  9527 */             this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
/*  9528 */             this.methodVisitor.visitVarInsn(57, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9529 */           } else if (!this.adviceMethod.getReturnType().represents(void.class)) {
/*  9530 */             this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
/*  9531 */             this.methodVisitor.visitVarInsn(58, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*       */           } 
/*  9533 */           this.methodSizeHandler.requireStackSize(this.postProcessor
/*  9534 */               .resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler)
/*  9535 */               .apply(this.methodVisitor, this.implementationContext).getMaximalSize());
/*  9536 */           this.methodSizeHandler.requireStackSize(this.relocationHandler.apply(this.methodVisitor, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()));
/*  9537 */           this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
/*       */         }
/*       */ 
/*       */         
/*       */         public void visitMaxs(int param3Int1, int param3Int2) {
/*  9542 */           this.methodSizeHandler.recordMaxima(param3Int1, param3Int2);
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Delegating
/*       */       implements Unresolved
/*       */     {
/*       */       protected final MethodDescription.InDefinedShape adviceMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final Advice.Delegator delegator;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Delegating(MethodDescription.InDefinedShape param2InDefinedShape, Advice.Delegator param2Delegator) {
/*  9570 */         this.adviceMethod = param2InDefinedShape;
/*  9571 */         this.delegator = param2Delegator;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isAlive() {
/*  9578 */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isBinary() {
/*  9585 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription getAdviceType() {
/*  9592 */         return this.adviceMethod.getReturnType().asErasure();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Map<String, TypeDefinition> getNamedTypes() {
/*  9599 */         return Collections.emptyMap();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Advice.Dispatcher.Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory) {
/*  9609 */         return Resolved.ForMethodEnter.of(this.adviceMethod, param2Factory.make(this.adviceMethod, false), this.delegator, param2List, param2Unresolved.getAdviceType(), param2Unresolved.isAlive());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param2List, @MaybeNull ClassReader param2ClassReader, Advice.Dispatcher.Unresolved param2Unresolved, Advice.PostProcessor.Factory param2Factory) {
/*  9619 */         Map<String, TypeDefinition> map = param2Unresolved.getNamedTypes();
/*  9620 */         for (Iterator<ParameterDescription> iterator = this.adviceMethod.getParameters().iterator(); iterator.hasNext();) {
/*       */           
/*  9622 */           if ((loadable = (parameterDescription = iterator.next()).getDeclaredAnnotations().ofType(Advice.Local.class)) != null) {
/*  9623 */             String str = (String)loadable.getValue(Advice.OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class);
/*       */             TypeDefinition typeDefinition;
/*  9625 */             if ((typeDefinition = map.get(str)) == null)
/*  9626 */               throw new IllegalStateException(this.adviceMethod + " attempts use of undeclared local variable " + str); 
/*  9627 */             if (!typeDefinition.equals(parameterDescription.getType())) {
/*  9628 */               throw new IllegalStateException(this.adviceMethod + " does not read variable " + str + " as " + typeDefinition);
/*       */             }
/*       */           } 
/*       */         } 
/*  9632 */         return Resolved.ForMethodExit.of(this.adviceMethod, param2Factory.make(this.adviceMethod, true), this.delegator, map, param2List, param2Unresolved.getAdviceType());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.adviceMethod.equals(((Delegating)param2Object).adviceMethod) ? false : (!!this.delegator.equals(((Delegating)param2Object).delegator)))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (getClass().hashCode() * 31 + this.adviceMethod.hashCode()) * 31 + this.delegator.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static abstract class Resolved
/*       */         extends Advice.Dispatcher.Resolved.AbstractBase
/*       */       {
/*       */         protected final Advice.Delegator delegator;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Resolved(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2, Advice.Delegator param3Delegator) {
/*  9661 */           super(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDescription1, param3TypeDescription2, Advice.OffsetMapping.Factory.AdviceType.DELEGATION);
/*  9662 */           this.delegator = param3Delegator;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Map<String, TypeDefinition> getNamedTypes() {
/*  9669 */           return Collections.emptyMap();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Advice.Dispatcher.Bound bind(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) {
/*  9685 */           if (!this.adviceMethod.isVisibleTo(param3TypeDescription)) {
/*  9686 */             throw new IllegalStateException(this.adviceMethod + " is not visible to " + param3MethodDescription.getDeclaringType());
/*       */           }
/*  9688 */           return resolve(param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod, param3ForInstrumentedMethod1, param3ForInstrumentedMethod2, param3StackManipulation, param3Relocation);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract Advice.Dispatcher.Bound resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static abstract class AdviceMethodWriter
/*       */           implements Advice.Dispatcher.Bound
/*       */         {
/*       */           protected final MethodDescription.InDefinedShape adviceMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeDescription instrumentedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final Assigner assigner;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final List<Advice.OffsetMapping.Target> offsetMappings;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final MethodVisitor methodVisitor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Implementation.Context implementationContext;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.ArgumentHandler.ForAdvice argumentHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.MethodSizeHandler.ForAdvice methodSizeHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final Advice.StackMapFrameHandler.ForAdvice stackMapFrameHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final Advice.Dispatcher.SuppressionHandler.Bound suppressionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final Advice.Dispatcher.RelocationHandler.Bound relocationHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final StackManipulation exceptionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final Advice.PostProcessor postProcessor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final Advice.Delegator delegator;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected AdviceMethodWriter(MethodDescription.InDefinedShape param4InDefinedShape, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Assigner param4Assigner, Advice.PostProcessor param4PostProcessor, List<Advice.OffsetMapping.Target> param4List, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation, Advice.Delegator param4Delegator) {
/*  9841 */             this.adviceMethod = param4InDefinedShape;
/*  9842 */             this.instrumentedType = param4TypeDescription;
/*  9843 */             this.instrumentedMethod = param4MethodDescription;
/*  9844 */             this.assigner = param4Assigner;
/*  9845 */             this.postProcessor = param4PostProcessor;
/*  9846 */             this.offsetMappings = param4List;
/*  9847 */             this.methodVisitor = param4MethodVisitor;
/*  9848 */             this.implementationContext = param4Context;
/*  9849 */             this.argumentHandler = param4ForAdvice;
/*  9850 */             this.methodSizeHandler = param4ForAdvice1;
/*  9851 */             this.stackMapFrameHandler = param4ForAdvice2;
/*  9852 */             this.suppressionHandler = param4Bound;
/*  9853 */             this.relocationHandler = param4Bound1;
/*  9854 */             this.exceptionHandler = param4StackManipulation;
/*  9855 */             this.delegator = param4Delegator;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void prepare() {
/*  9862 */             this.suppressionHandler.onPrepare(this.methodVisitor);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void apply() {
/*  9869 */             this.suppressionHandler.onStart(this.methodVisitor);
/*  9870 */             byte b = 0; int i = 0, j = 0;
/*  9871 */             for (Advice.OffsetMapping.Target target : this.offsetMappings) {
/*  9872 */               i += ((ParameterDescription.InDefinedShape)this.adviceMethod.getParameters().get(b++)).getType().getStackSize().getSize();
/*  9873 */               j = Math.max(j, i + target.resolveRead()
/*  9874 */                   .apply(this.methodVisitor, this.implementationContext)
/*  9875 */                   .getMaximalSize());
/*       */             } 
/*  9877 */             this.delegator.apply(this.methodVisitor, this.adviceMethod, this.instrumentedType, this.instrumentedMethod, isExitAdvice());
/*  9878 */             this.suppressionHandler.onEndWithSkip(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, (TypeDefinition)this.adviceMethod
/*       */ 
/*       */ 
/*       */                 
/*  9882 */                 .getReturnType());
/*  9883 */             if (this.adviceMethod.getReturnType().represents(boolean.class) || this.adviceMethod
/*  9884 */               .getReturnType().represents(byte.class) || this.adviceMethod
/*  9885 */               .getReturnType().represents(short.class) || this.adviceMethod
/*  9886 */               .getReturnType().represents(char.class) || this.adviceMethod
/*  9887 */               .getReturnType().represents(int.class)) {
/*  9888 */               this.methodVisitor.visitVarInsn(54, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9889 */             } else if (this.adviceMethod.getReturnType().represents(long.class)) {
/*  9890 */               this.methodVisitor.visitVarInsn(55, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9891 */             } else if (this.adviceMethod.getReturnType().represents(float.class)) {
/*  9892 */               this.methodVisitor.visitVarInsn(56, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9893 */             } else if (this.adviceMethod.getReturnType().represents(double.class)) {
/*  9894 */               this.methodVisitor.visitVarInsn(57, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*  9895 */             } else if (!this.adviceMethod.getReturnType().represents(void.class)) {
/*  9896 */               this.methodVisitor.visitVarInsn(58, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
/*       */             } 
/*  9898 */             this.methodSizeHandler.requireStackSize(this.postProcessor
/*  9899 */                 .resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler)
/*  9900 */                 .apply(this.methodVisitor, this.implementationContext).getMaximalSize());
/*  9901 */             this.methodSizeHandler.requireStackSize(this.relocationHandler.apply(this.methodVisitor, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()));
/*  9902 */             this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
/*  9903 */             this.methodSizeHandler.requireStackSize(Math.max(j, this.adviceMethod.getReturnType().getStackSize().getSize()));
/*  9904 */             this.methodSizeHandler.requireLocalVariableLength(this.instrumentedMethod.getStackSize() + this.adviceMethod.getReturnType().getStackSize().getSize());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected abstract boolean isExitAdvice();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class ForMethodEnter
/*       */             extends AdviceMethodWriter
/*       */           {
/*       */             protected ForMethodEnter(MethodDescription.InDefinedShape param5InDefinedShape, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Assigner param5Assigner, Advice.PostProcessor param5PostProcessor, List<Advice.OffsetMapping.Target> param5List, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation, Advice.Delegator param5Delegator) {
/*  9953 */               super(param5InDefinedShape, param5TypeDescription, param5MethodDescription, param5Assigner, param5PostProcessor, param5List, param5MethodVisitor, param5Context, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation, param5Delegator);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public void initialize() {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected boolean isExitAdvice() {
/*  9979 */               return false;
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class ForMethodExit
/*       */             extends AdviceMethodWriter
/*       */           {
/*       */             protected ForMethodExit(MethodDescription.InDefinedShape param5InDefinedShape, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Assigner param5Assigner, Advice.PostProcessor param5PostProcessor, List<Advice.OffsetMapping.Target> param5List, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation, Advice.Delegator param5Delegator) {
/* 10022 */               super(param5InDefinedShape, param5TypeDescription, param5MethodDescription, param5Assigner, param5PostProcessor, param5List, param5MethodVisitor, param5Context, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation, param5Delegator);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public void initialize() {
/* 10043 */               if (this.adviceMethod.getReturnType().represents(boolean.class) || this.adviceMethod
/* 10044 */                 .getReturnType().represents(byte.class) || this.adviceMethod
/* 10045 */                 .getReturnType().represents(short.class) || this.adviceMethod
/* 10046 */                 .getReturnType().represents(char.class) || this.adviceMethod
/* 10047 */                 .getReturnType().represents(int.class)) {
/* 10048 */                 this.methodVisitor.visitInsn(3);
/* 10049 */                 this.methodVisitor.visitVarInsn(54, this.argumentHandler.exit());
/* 10050 */               } else if (this.adviceMethod.getReturnType().represents(long.class)) {
/* 10051 */                 this.methodVisitor.visitInsn(9);
/* 10052 */                 this.methodVisitor.visitVarInsn(55, this.argumentHandler.exit());
/* 10053 */               } else if (this.adviceMethod.getReturnType().represents(float.class)) {
/* 10054 */                 this.methodVisitor.visitInsn(11);
/* 10055 */                 this.methodVisitor.visitVarInsn(56, this.argumentHandler.exit());
/* 10056 */               } else if (this.adviceMethod.getReturnType().represents(double.class)) {
/* 10057 */                 this.methodVisitor.visitInsn(14);
/* 10058 */                 this.methodVisitor.visitVarInsn(57, this.argumentHandler.exit());
/* 10059 */               } else if (!this.adviceMethod.getReturnType().represents(void.class)) {
/* 10060 */                 this.methodVisitor.visitInsn(1);
/* 10061 */                 this.methodVisitor.visitVarInsn(58, this.argumentHandler.exit());
/*       */               } 
/* 10063 */               this.methodSizeHandler.requireStackSize(this.adviceMethod.getReturnType().getStackSize().getSize());
/*       */             }
/*       */ 
/*       */             
/*       */             protected boolean isExitAdvice() {
/* 10068 */               return true;
/*       */             }
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static abstract class ForMethodEnter
/*       */           extends Resolved
/*       */           implements Advice.Dispatcher.Resolved.ForMethodEnter
/*       */         {
/*       */           private final boolean prependLineNumber;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */           protected ForMethodEnter(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, Advice.Delegator param4Delegator) {
/* 10100 */             super(param4InDefinedShape, param4PostProcessor, 
/*       */                 
/* 10102 */                 CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */                       
/* 10109 */                       Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param4TypeDefinition), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Local>(Advice.Local.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class)
/*       */                     },
/*       */ 
/*       */ 
/*       */                   
/* 10114 */                   ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape
/* 10115 */                 .getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param4Delegator);
/*       */             
/* 10117 */             this.prependLineNumber = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Advice.Delegator param4Delegator, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, boolean param4Boolean) {
/* 10137 */             return (Advice.Dispatcher.Resolved.ForMethodEnter)(param4Boolean ? new WithRetainedEnterType(param4InDefinedShape, param4PostProcessor, param4List, param4TypeDefinition, param4Delegator) : new WithDiscardedEnterType(param4InDefinedShape, param4PostProcessor, param4List, param4TypeDefinition, param4Delegator));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isPrependLineNumber() {
/* 10146 */             return this.prependLineNumber;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDefinition getActualAdviceType() {
/* 10153 */             return (TypeDefinition)this.adviceMethod.getReturnType();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected Advice.Dispatcher.Bound resolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) {
/* 10167 */             return doResolve(param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod
/*       */ 
/*       */ 
/*       */ 
/*       */                 
/* 10172 */                 .bindEnter((MethodDescription)this.adviceMethod), param4ForInstrumentedMethod1
/* 10173 */                 .bindEnter(this.adviceMethod), param4ForInstrumentedMethod2
/* 10174 */                 .bindEnter(this.adviceMethod), this.suppressionHandler
/* 10175 */                 .bind(param4StackManipulation), this.relocationHandler
/* 10176 */                 .bind(param4MethodDescription, param4Relocation), param4StackManipulation);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected Advice.Dispatcher.Bound doResolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) {
/* 10207 */             ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size());
/* 10208 */             for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) {
/* 10209 */               arrayList.add(offsetMapping.resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.ENTER));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/* 10215 */             return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodEnter(this.adviceMethod, param4TypeDescription, param4MethodDescription, param4Assigner, this.postProcessor, arrayList, param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4Bound, param4Bound1, param4StackManipulation, this.delegator);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!(this.prependLineNumber != ((ForMethodEnter)param4Object).prependLineNumber)))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return super.hashCode() * 31 + this.prependLineNumber;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class WithRetainedEnterType
/*       */             extends ForMethodEnter
/*       */           {
/*       */             protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) {
/* 10251 */               super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDefinition getAdviceType() {
/* 10258 */               return (TypeDefinition)this.adviceMethod.getReturnType();
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class WithDiscardedEnterType
/*       */             extends ForMethodEnter
/*       */           {
/*       */             protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) {
/* 10281 */               super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDefinition getAdviceType() {
/* 10288 */               return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected Advice.Dispatcher.Bound doResolve(TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) {
/* 10305 */               param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize());
/* 10306 */               return super.doResolve(param5TypeDescription, param5MethodDescription, param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation);
/*       */             }
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static abstract class ForMethodExit
/*       */           extends Resolved
/*       */           implements Advice.Dispatcher.Resolved.ForMethodExit
/*       */         {
/*       */           private final boolean backupArguments;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */           protected ForMethodExit(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, Advice.Delegator param4Delegator) {
/* 10350 */             super(param4InDefinedShape, param4PostProcessor, 
/*       */                 
/* 10352 */                 CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */                       
/* 10359 */                       Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param4TypeDefinition), 
/* 10360 */                       Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param4InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param4Map), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, 
/*       */ 
/*       */                       
/* 10363 */                       Advice.OffsetMapping.ForThrowable.Factory.of(param4InDefinedShape)
/*       */                     },
/* 10365 */                   ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape
/* 10366 */                 .getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param4Delegator);
/*       */             
/* 10368 */             this.backupArguments = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */           protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Advice.Delegator param4Delegator, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition) {
/*       */             TypeDescription typeDescription;
/* 10393 */             return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, param4Delegator) : new WithExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, typeDescription, param4Delegator));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected Advice.Dispatcher.Bound resolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) {
/* 10409 */             return doResolve(param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod
/*       */ 
/*       */ 
/*       */ 
/*       */                 
/* 10414 */                 .bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param4ForInstrumentedMethod1
/* 10415 */                 .bindExit(this.adviceMethod), param4ForInstrumentedMethod2
/* 10416 */                 .bindExit(this.adviceMethod), this.suppressionHandler
/* 10417 */                 .bind(param4StackManipulation), this.relocationHandler
/* 10418 */                 .bind(param4MethodDescription, param4Relocation), param4StackManipulation);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private Advice.Dispatcher.Bound doResolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) {
/* 10449 */             ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size());
/* 10450 */             for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) {
/* 10451 */               arrayList.add(offsetMapping.resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.EXIT));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/* 10457 */             return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodExit(this.adviceMethod, param4TypeDescription, param4MethodDescription, param4Assigner, this.postProcessor, arrayList, param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4Bound, param4Bound1, param4StackManipulation, this.delegator);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() {
/* 10478 */             return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDefinition getAdviceType() {
/* 10487 */             return (TypeDefinition)this.adviceMethod.getReturnType();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!(this.backupArguments != ((ForMethodExit)param4Object).backupArguments)))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return super.hashCode() * 31 + this.backupArguments;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @Enhance
/*       */           protected static class WithExceptionHandler
/*       */             extends ForMethodExit
/*       */           {
/*       */             private final TypeDescription throwable;
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription, Advice.Delegator param5Delegator) {
/* 10520 */               super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator);
/* 10521 */               this.throwable = param5TypeDescription;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDescription getThrowable() {
/* 10528 */               return this.throwable;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean equals(@MaybeNull Object param5Object) {
/*       */               return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable)))));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public int hashCode() {
/*       */               return super.hashCode() * 31 + this.throwable.hashCode();
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class WithoutExceptionHandler
/*       */             extends ForMethodExit
/*       */           {
/*       */             protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) {
/* 10554 */               super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator);
/*       */             }
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDescription getThrowable()
/*       */             {
/* 10561 */               return Advice.NoExceptionHandler.a(); } } } } @Enhance protected static abstract class ForMethodEnter extends Resolved implements Advice.Dispatcher.Resolved.ForMethodEnter { private final boolean prependLineNumber; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodEnter(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, Advice.Delegator param3Delegator) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param3TypeDefinition), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Local>(Advice.Local.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param3Delegator); this.prependLineNumber = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue(); } protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Advice.Delegator param3Delegator, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, boolean param3Boolean) { return (Advice.Dispatcher.Resolved.ForMethodEnter)(param3Boolean ? new WithRetainedEnterType(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDefinition, param3Delegator) : new WithDiscardedEnterType(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDefinition, param3Delegator)); } public boolean isPrependLineNumber() { return this.prependLineNumber; } public TypeDefinition getActualAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } protected Advice.Dispatcher.Bound resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return doResolve(param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindEnter((MethodDescription)this.adviceMethod), param3ForInstrumentedMethod1.bindEnter(this.adviceMethod), param3ForInstrumentedMethod2.bindEnter(this.adviceMethod), this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation); } protected Advice.Dispatcher.Bound doResolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size()); for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) arrayList.add(offsetMapping.resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.ENTER));  return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodEnter(this.adviceMethod, param3TypeDescription, param3MethodDescription, param3Assigner, this.postProcessor, arrayList, param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3Bound, param3Bound1, param3StackManipulation, this.delegator); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.prependLineNumber != ((ForMethodEnter)param3Object).prependLineNumber))))); } public int hashCode() { return super.hashCode() * 31 + this.prependLineNumber; } protected static class WithRetainedEnterType extends ForMethodEnter { protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator); } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } } protected static class WithDiscardedEnterType extends ForMethodEnter { protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator); } public TypeDefinition getAdviceType() { return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class); } protected Advice.Dispatcher.Bound doResolve(TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) { param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize()); return super.doResolve(param5TypeDescription, param5MethodDescription, param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation); } } } @Enhance protected static abstract class ForMethodExit extends Resolved implements Advice.Dispatcher.Resolved.ForMethodExit { private final boolean backupArguments; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodExit(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, Advice.Delegator param3Delegator) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param3TypeDefinition), Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param3InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param3Map), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.of(param3InDefinedShape) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param3Delegator); this.backupArguments = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue(); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Advice.Delegator param3Delegator, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition) { TypeDescription typeDescription; return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, param3Delegator) : new WithExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, typeDescription, param3Delegator)); } protected Advice.Dispatcher.Bound resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return doResolve(param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param3ForInstrumentedMethod1.bindExit(this.adviceMethod), param3ForInstrumentedMethod2.bindExit(this.adviceMethod), this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation); } private Advice.Dispatcher.Bound doResolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size()); for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) arrayList.add(offsetMapping.resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.EXIT));  return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodExit(this.adviceMethod, param3TypeDescription, param3MethodDescription, param3Assigner, this.postProcessor, arrayList, param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3Bound, param3Bound1, param3StackManipulation, this.delegator); } public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() { return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE; } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.backupArguments != ((ForMethodExit)param3Object).backupArguments))))); } public int hashCode() { return super.hashCode() * 31 + this.backupArguments; } @Enhance protected static class WithExceptionHandler extends ForMethodExit { private final TypeDescription throwable; protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator); this.throwable = param5TypeDescription; } public TypeDescription getThrowable() { return this.throwable; } public boolean equals(@MaybeNull Object param5Object) { return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable))))); } public int hashCode() { return super.hashCode() * 31 + this.throwable.hashCode(); } } protected static class WithoutExceptionHandler extends ForMethodExit { protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator); } public TypeDescription getThrowable() { return Advice.NoExceptionHandler.a(); } } } } } public static interface Resolved extends Dispatcher { Map<String, TypeDefinition> getNamedTypes(); Advice.Dispatcher.Bound bind(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, MethodVisitor param1MethodVisitor, Implementation.Context param1Context, Assigner param1Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param1ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param1ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param1ForInstrumentedMethod2, StackManipulation param1StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param1Relocation); @Enhance public static abstract class AbstractBase implements Resolved { protected final MethodDescription.InDefinedShape adviceMethod; protected final Advice.PostProcessor postProcessor; protected final Map<Integer, Advice.OffsetMapping> offsetMappings; protected final Advice.Dispatcher.SuppressionHandler suppressionHandler; protected final Advice.Dispatcher.RelocationHandler relocationHandler; protected AbstractBase(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2, Advice.OffsetMapping.Factory.AdviceType param3AdviceType) { this.adviceMethod = param3InDefinedShape; this.postProcessor = param3PostProcessor; HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); for (Advice.OffsetMapping.Factory<?> factory : param3List) hashMap.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);  this.offsetMappings = new LinkedHashMap<Integer, Advice.OffsetMapping>(); for (ParameterDescription.InDefinedShape inDefinedShape : param3InDefinedShape.getParameters()) { Advice.OffsetMapping offsetMapping = null; for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) { Advice.OffsetMapping.Factory factory; if ((factory = (Advice.OffsetMapping.Factory)hashMap.get(annotationDescription.getAnnotationType())) != null) { Advice.OffsetMapping offsetMapping1 = factory.make(inDefinedShape, annotationDescription.prepare(factory.getAnnotationType()), param3AdviceType); if (offsetMapping == null) { offsetMapping = offsetMapping1; continue; }  throw new IllegalStateException(inDefinedShape + " is bound to both " + offsetMapping1 + " and " + offsetMapping); }  }  this.offsetMappings.put(Integer.valueOf(inDefinedShape.getOffset()), (offsetMapping == null) ? new Advice.OffsetMapping.ForArgument.Unresolved((ParameterDescription)inDefinedShape) : offsetMapping); }  this.suppressionHandler = Advice.Dispatcher.SuppressionHandler.Suppressing.of(param3TypeDescription1); this.relocationHandler = Advice.Dispatcher.RelocationHandler.ForType.of(param3TypeDescription2, (TypeDefinition)param3InDefinedShape.getReturnType()); } public boolean isAlive() { return true; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.adviceMethod.equals(((AbstractBase)param3Object).adviceMethod) ? false : (!this.postProcessor.equals(((AbstractBase)param3Object).postProcessor) ? false : (!this.offsetMappings.equals(((AbstractBase)param3Object).offsetMappings) ? false : (!this.suppressionHandler.equals(((AbstractBase)param3Object).suppressionHandler) ? false : (!!this.relocationHandler.equals(((AbstractBase)param3Object).relocationHandler)))))))); } public int hashCode() { return ((((getClass().hashCode() * 31 + this.adviceMethod.hashCode()) * 31 + this.postProcessor.hashCode()) * 31 + this.offsetMappings.hashCode()) * 31 + this.suppressionHandler.hashCode()) * 31 + this.relocationHandler.hashCode(); } } public static interface ForMethodExit extends Resolved { TypeDescription getThrowable(); Advice.ArgumentHandler.Factory getArgumentHandlerFactory(); } public static interface ForMethodEnter extends Resolved { boolean isPrependLineNumber(); TypeDefinition getActualAdviceType(); } } public enum Inactive implements Dispatcher.Bound, Dispatcher.Resolved.ForMethodEnter, Dispatcher.Resolved.ForMethodExit, Dispatcher.Unresolved { INSTANCE; public final boolean isAlive() { return false; } public final boolean isBinary() { return false; } public final TypeDescription getAdviceType() { return TypeDescription.ForLoadedType.of(void.class); } public final boolean isPrependLineNumber() { return false; } public final TypeDefinition getActualAdviceType() { return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class); } public final Map<String, TypeDefinition> getNamedTypes() { return Collections.emptyMap(); } public final TypeDescription getThrowable() { return Advice.NoExceptionHandler.a(); } public final Advice.ArgumentHandler.Factory getArgumentHandlerFactory() { return Advice.ArgumentHandler.Factory.SIMPLE; } public final Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Advice.Dispatcher.Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory) { return this; } public final Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Advice.Dispatcher.Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory) { return this; } public final void prepare() {} public final void initialize() {} public final void apply() {} public final Advice.Dispatcher.Bound bind(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, MethodVisitor param1MethodVisitor, Implementation.Context param1Context, Assigner param1Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param1ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param1ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param1ForInstrumentedMethod2, StackManipulation param1StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param1Relocation) { return this; } } @Enhance public static class Inlining implements Dispatcher.Unresolved { protected final MethodDescription.InDefinedShape adviceMethod; private final Map<String, TypeDefinition> namedTypes; protected Inlining(MethodDescription.InDefinedShape param1InDefinedShape) { this.adviceMethod = param1InDefinedShape; this.namedTypes = new HashMap<String, TypeDefinition>(); for (Iterator<ParameterDescription> iterator = param1InDefinedShape.getParameters().iterator(); iterator.hasNext(); ) { String str = (String)loadable.getValue(Advice.OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class); ParameterDescription parameterDescription; AnnotationDescription.Loadable loadable; TypeDefinition typeDefinition; if ((loadable = (parameterDescription = iterator.next()).getDeclaredAnnotations().ofType(Advice.Local.class)) != null && (typeDefinition = (TypeDefinition)this.namedTypes.put(str, parameterDescription.getType())) != null && !typeDefinition.equals(parameterDescription.getType())) throw new IllegalStateException("Local variable for " + str + " is defined with inconsistent types");  }  } public boolean isAlive() { return true; } public boolean isBinary() { return true; } public TypeDescription getAdviceType() { return this.adviceMethod.getReturnType().asErasure(); } public Map<String, TypeDefinition> getNamedTypes() { return this.namedTypes; } public Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Advice.Dispatcher.Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory) { if (param1ClassReader == null) throw new IllegalStateException("Class reader not expected null");  return Resolved.ForMethodEnter.of(this.adviceMethod, param1Factory.make(this.adviceMethod, false), this.namedTypes, param1List, param1Unresolved.getAdviceType(), param1ClassReader, param1Unresolved.isAlive()); } public Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Advice.Dispatcher.Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory) { HashMap<String, TypeDefinition> hashMap = new HashMap<String, TypeDefinition>(param1Unresolved.getNamedTypes()); HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(); for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) { TypeDefinition typeDefinition1 = hashMap.get(entry.getKey()), typeDefinition2 = (TypeDefinition)hashMap1.get(entry.getKey()); if (typeDefinition1 == null && typeDefinition2 == null) { hashMap.put((String)entry.getKey(), (TypeDefinition)entry.getValue()); hashMap1.put(entry.getKey(), entry.getValue()); continue; }  if (!((typeDefinition1 == null) ? typeDefinition2 : typeDefinition1).equals(entry.getValue())) throw new IllegalStateException("Local variable for " + (String)entry.getKey() + " is defined with inconsistent types");  }  return Resolved.ForMethodExit.of(this.adviceMethod, param1Factory.make(this.adviceMethod, true), hashMap, (Map)hashMap1, param1List, param1ClassReader, param1Unresolved.getAdviceType()); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.adviceMethod.equals(((Inlining)param1Object).adviceMethod) ? false : (!!this.namedTypes.equals(((Inlining)param1Object).namedTypes))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.adviceMethod.hashCode()) * 31 + this.namedTypes.hashCode(); } protected static abstract class Resolved extends Advice.Dispatcher.Resolved.AbstractBase { protected final ClassReader classReader; protected Resolved(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2, ClassReader param3ClassReader) { super(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDescription1, param3TypeDescription2, Advice.OffsetMapping.Factory.AdviceType.INLINING); this.classReader = param3ClassReader; } protected abstract Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param3ArgumentHandler); protected abstract MethodVisitor apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation); protected class AdviceMethodInliner extends ClassVisitor implements Advice.Dispatcher.Bound { protected final TypeDescription instrumentedType; protected final MethodDescription instrumentedMethod; protected final MethodVisitor methodVisitor; protected final Implementation.Context implementationContext; protected final Assigner assigner; protected final Advice.ArgumentHandler.ForInstrumentedMethod argumentHandler; protected final Advice.MethodSizeHandler.ForInstrumentedMethod methodSizeHandler; protected final Advice.StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler; protected final Advice.Dispatcher.SuppressionHandler.Bound suppressionHandler; protected final Advice.Dispatcher.RelocationHandler.Bound relocationHandler; protected final StackManipulation exceptionHandler; protected final ClassReader classReader; protected final List<Label> labels; protected AdviceMethodInliner(Advice.Dispatcher.Inlining.Resolved this$0, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation, ClassReader param4ClassReader) { super(OpenedClassReader.ASM_API); this.instrumentedType = param4TypeDescription; this.instrumentedMethod = param4MethodDescription; this.methodVisitor = param4MethodVisitor; this.implementationContext = param4Context; this.assigner = param4Assigner; this.argumentHandler = param4ForInstrumentedMethod; this.methodSizeHandler = param4ForInstrumentedMethod1; this.stackMapFrameHandler = param4ForInstrumentedMethod2; this.suppressionHandler = param4Bound; this.relocationHandler = param4Bound1; this.exceptionHandler = param4StackManipulation; this.classReader = param4ClassReader; this.labels = new ArrayList<Label>(); } public void prepare() { this.classReader.accept(new ExceptionTableExtractor(this), 6); this.suppressionHandler.onPrepare(this.methodVisitor); } public void initialize() { for (Iterator<Map.Entry> iterator = this.a.resolveInitializationTypes(this.argumentHandler).entrySet().iterator(); iterator.hasNext(); ) { Map.Entry<?, TypeDefinition> entry; if (((TypeDefinition)(entry = iterator.next()).getValue()).represents(boolean.class) || ((TypeDefinition)entry.getValue()).represents(byte.class) || ((TypeDefinition)entry.getValue()).represents(short.class) || ((TypeDefinition)entry.getValue()).represents(char.class) || ((TypeDefinition)entry.getValue()).represents(int.class)) { this.methodVisitor.visitInsn(3); this.methodVisitor.visitVarInsn(54, ((Integer)entry.getKey()).intValue()); } else if (((TypeDefinition)entry.getValue()).represents(long.class)) { this.methodVisitor.visitInsn(9); this.methodVisitor.visitVarInsn(55, ((Integer)entry.getKey()).intValue()); } else if (((TypeDefinition)entry.getValue()).represents(float.class)) { this.methodVisitor.visitInsn(11); this.methodVisitor.visitVarInsn(56, ((Integer)entry.getKey()).intValue()); } else if (((TypeDefinition)entry.getValue()).represents(double.class)) { this.methodVisitor.visitInsn(14); this.methodVisitor.visitVarInsn(57, ((Integer)entry.getKey()).intValue()); } else { this.methodVisitor.visitInsn(1); this.methodVisitor.visitVarInsn(58, ((Integer)entry.getKey()).intValue()); }  this.methodSizeHandler.requireStackSize(((TypeDefinition)entry.getValue()).getStackSize().getSize()); }  } public void apply() { this.classReader.accept(this, 0x2 | this.stackMapFrameHandler.getReaderHint()); } @MaybeNull public MethodVisitor visitMethod(int param4Int, String param4String1, String param4String2, @MaybeNull String param4String3, @MaybeNull String[] param4ArrayOfString) { return (this.a.adviceMethod.getInternalName().equals(param4String1) && this.a.adviceMethod.getDescriptor().equals(param4String2)) ? new ExceptionTableSubstitutor(this, this.a.apply(this.methodVisitor, this.implementationContext, this.assigner, this.argumentHandler, this.methodSizeHandler, this.stackMapFrameHandler, this.instrumentedType, this.instrumentedMethod, this.suppressionHandler, this.relocationHandler, this.exceptionHandler)) : Advice.Dispatcher.IGNORE_METHOD; } protected class ExceptionTableExtractor extends ClassVisitor { protected ExceptionTableExtractor(Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner this$0) { super(OpenedClassReader.ASM_API); } @MaybeNull public MethodVisitor visitMethod(int param5Int, String param5String1, String param5String2, @MaybeNull String param5String3, @MaybeNull String[] param5ArrayOfString) { return (this.a.a.adviceMethod.getInternalName().equals(param5String1) && this.a.a.adviceMethod.getDescriptor().equals(param5String2)) ? new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner.ExceptionTableCollector(this.a, this.a.methodVisitor) : Advice.Dispatcher.IGNORE_METHOD; } } protected class ExceptionTableCollector extends MethodVisitor { private final MethodVisitor methodVisitor; protected ExceptionTableCollector(Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner this$0, MethodVisitor param5MethodVisitor) { super(OpenedClassReader.ASM_API); this.methodVisitor = param5MethodVisitor; } public void visitTryCatchBlock(Label param5Label1, Label param5Label2, Label param5Label3, @MaybeNull String param5String) { this.methodVisitor.visitTryCatchBlock(param5Label1, param5Label2, param5Label3, param5String); this.a.labels.addAll(Arrays.asList(new Label[] { param5Label1, param5Label2, param5Label3 })); } @MaybeNull public AnnotationVisitor visitTryCatchAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) { return this.methodVisitor.visitTryCatchAnnotation(param5Int, param5TypePath, param5String, param5Boolean); } } protected class ExceptionTableSubstitutor extends MethodVisitor { private final Map<Label, Label> substitutions; private int index; protected ExceptionTableSubstitutor(Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner this$0, MethodVisitor param5MethodVisitor) { super(OpenedClassReader.ASM_API, param5MethodVisitor); this.substitutions = new IdentityHashMap<Label, Label>(); } public void visitTryCatchBlock(Label param5Label1, Label param5Label2, Label param5Label3, String param5String) { this.substitutions.put(param5Label1, this.a.labels.get(this.index++)); this.substitutions.put(param5Label2, this.a.labels.get(this.index++)); param5Label1 = this.a.labels.get(this.index++); this.substitutions.put(param5Label3, param5Label1); ((Advice.Dispatcher.Inlining.CodeTranslationVisitor)this.mv).propagateHandler(param5Label1); } @MaybeNull public AnnotationVisitor visitTryCatchAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) { return Advice.Dispatcher.IGNORE_ANNOTATION; } public void visitLabel(Label param5Label) { super.visitLabel(resolve(param5Label)); } public void visitJumpInsn(int param5Int, Label param5Label) { super.visitJumpInsn(param5Int, resolve(param5Label)); } public void visitTableSwitchInsn(int param5Int1, int param5Int2, Label param5Label, Label... param5VarArgs) { super.visitTableSwitchInsn(param5Int1, param5Int2, param5Label, resolve(param5VarArgs)); } public void visitLookupSwitchInsn(Label param5Label, int[] param5ArrayOfint, Label[] param5ArrayOfLabel) { super.visitLookupSwitchInsn(resolve(param5Label), param5ArrayOfint, resolve(param5ArrayOfLabel)); } private Label[] resolve(Label[] param5ArrayOfLabel) { Label[] arrayOfLabel = new Label[param5ArrayOfLabel.length]; byte b1 = 0; int i; byte b2; for (i = (param5ArrayOfLabel = param5ArrayOfLabel).length, b2 = 0; b2 < i; ) { Label label = param5ArrayOfLabel[b2]; arrayOfLabel[b1++] = resolve(label); b2++; }  return arrayOfLabel; } private Label resolve(Label param5Label) { Label label; return ((label = this.substitutions.get(param5Label)) == null) ? param5Label : label; } } } @Enhance protected static abstract class ForMethodEnter extends Resolved implements Advice.Dispatcher.Resolved.ForMethodEnter { private final Map<String, TypeDefinition> namedTypes; private final boolean prependLineNumber; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodEnter(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, ClassReader param4ClassReader) { super(param4InDefinedShape, param4PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param4TypeDefinition), new Advice.OffsetMapping.ForLocalValue.Factory(param4Map), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class) }, ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param4ClassReader); this.namedTypes = param4Map; this.prependLineNumber = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue(); } protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, ClassReader param4ClassReader, boolean param4Boolean) { return (Advice.Dispatcher.Resolved.ForMethodEnter)(param4Boolean ? new WithRetainedEnterType(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, param4ClassReader) : new WithDiscardedEnterType(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, param4ClassReader)); } protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param4ArgumentHandler) { TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) treeMap.put(Integer.valueOf(param4ArgumentHandler.named((String)entry.getKey())), entry.getValue());  return (Map)treeMap; } public Advice.Dispatcher.Bound bind(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) { return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod, param4ForInstrumentedMethod1, param4ForInstrumentedMethod2, this.suppressionHandler.bind(param4StackManipulation), this.relocationHandler.bind(param4MethodDescription, param4Relocation), param4StackManipulation, this.classReader); } public boolean isPrependLineNumber() { return this.prependLineNumber; } public TypeDefinition getActualAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public Map<String, TypeDefinition> getNamedTypes() { return this.namedTypes; } protected MethodVisitor apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) { return doApply(param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod.bindEnter((MethodDescription)this.adviceMethod), param4ForInstrumentedMethod1.bindEnter(this.adviceMethod), param4ForInstrumentedMethod2.bindEnter(this.adviceMethod), param4TypeDescription, param4MethodDescription, param4Bound, param4Bound1, param4StackManipulation); } protected MethodVisitor doApply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) { HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.ENTER));  return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4TypeDescription, param4MethodDescription, param4Assigner, this.adviceMethod, (Map)hashMap, param4Bound, param4Bound1, param4StackManipulation, this.postProcessor, false); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.prependLineNumber != ((ForMethodEnter)param4Object).prependLineNumber) ? false : (!!this.namedTypes.equals(((ForMethodEnter)param4Object).namedTypes)))))); } public int hashCode() { return (super.hashCode() * 31 + this.namedTypes.hashCode()) * 31 + this.prependLineNumber; } protected static class WithRetainedEnterType extends ForMethodEnter { protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader); } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } } protected static class WithDiscardedEnterType extends ForMethodEnter { protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader); } public TypeDefinition getAdviceType() { return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class); } protected MethodVisitor doApply(MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) { param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize()); return super.doApply(param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5TypeDescription, param5MethodDescription, param5Bound, param5Bound1, param5StackManipulation); } } } @Enhance protected static abstract class ForMethodExit extends Resolved implements Advice.Dispatcher.Resolved.ForMethodExit { private final Map<String, TypeDefinition> uninitializedNamedTypes; private final boolean backupArguments; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodExit(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map1, Map<String, TypeDefinition> param4Map2, List<? extends Advice.OffsetMapping.Factory<?>> param4List, ClassReader param4ClassReader, TypeDefinition param4TypeDefinition) { super(param4InDefinedShape, param4PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param4TypeDefinition), Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param4InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param4Map1), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.of(param4InDefinedShape) }, ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param4ClassReader); this.uninitializedNamedTypes = param4Map2; this.backupArguments = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue(); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map1, Map<String, TypeDefinition> param4Map2, List<? extends Advice.OffsetMapping.Factory<?>> param4List, ClassReader param4ClassReader, TypeDefinition param4TypeDefinition) { TypeDescription typeDescription; return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map1, param4Map2, param4List, param4ClassReader, param4TypeDefinition) : new WithExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map1, param4Map2, param4List, param4ClassReader, param4TypeDefinition, typeDescription)); } public Map<String, TypeDefinition> getNamedTypes() { return this.uninitializedNamedTypes; } protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param4ArgumentHandler) { TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); for (Map.Entry<String, TypeDefinition> entry : this.uninitializedNamedTypes.entrySet()) treeMap.put(Integer.valueOf(param4ArgumentHandler.named((String)entry.getKey())), entry.getValue());  if (!this.adviceMethod.getReturnType().represents(void.class)) treeMap.put(Integer.valueOf(param4ArgumentHandler.exit()), this.adviceMethod.getReturnType());  return (Map)treeMap; } protected MethodVisitor apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) { return doApply(param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod.bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param4ForInstrumentedMethod1.bindExit(this.adviceMethod), param4ForInstrumentedMethod2.bindExit(this.adviceMethod), param4TypeDescription, param4MethodDescription, param4Bound, param4Bound1, param4StackManipulation); } private MethodVisitor doApply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) { HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.EXIT));  return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4TypeDescription, param4MethodDescription, param4Assigner, this.adviceMethod, (Map)hashMap, param4Bound, param4Bound1, param4StackManipulation, this.postProcessor, true); } public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() { return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE; } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public Advice.Dispatcher.Bound bind(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) { return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod, param4ForInstrumentedMethod1, param4ForInstrumentedMethod2, this.suppressionHandler.bind(param4StackManipulation), this.relocationHandler.bind(param4MethodDescription, param4Relocation), param4StackManipulation, this.classReader); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.backupArguments != ((ForMethodExit)param4Object).backupArguments) ? false : (!!this.uninitializedNamedTypes.equals(((ForMethodExit)param4Object).uninitializedNamedTypes)))))); } public int hashCode() { return (super.hashCode() * 31 + this.uninitializedNamedTypes.hashCode()) * 31 + this.backupArguments; } @Enhance protected static class WithExceptionHandler extends ForMethodExit { private final TypeDescription throwable; protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription) { super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition); this.throwable = param5TypeDescription; } public TypeDescription getThrowable() { return this.throwable; } public boolean equals(@MaybeNull Object param5Object) { return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable))))); } public int hashCode() { return super.hashCode() * 31 + this.throwable.hashCode(); } } protected static class WithoutExceptionHandler extends ForMethodExit { protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition) { super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition); } public TypeDescription getThrowable() { return Advice.NoExceptionHandler.a(); } } } } @Enhance protected static abstract class ForMethodEnter extends Resolved implements Advice.Dispatcher.Resolved.ForMethodEnter { private final Map<String, TypeDefinition> namedTypes; private final boolean prependLineNumber; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodEnter(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, ClassReader param3ClassReader) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param3TypeDefinition), new Advice.OffsetMapping.ForLocalValue.Factory(param3Map), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param3ClassReader); this.namedTypes = param3Map; this.prependLineNumber = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue(); } protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, ClassReader param3ClassReader, boolean param3Boolean) { return (Advice.Dispatcher.Resolved.ForMethodEnter)(param3Boolean ? new WithRetainedEnterType(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, param3ClassReader) : new WithDiscardedEnterType(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, param3ClassReader)); } protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param3ArgumentHandler) { TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) treeMap.put(Integer.valueOf(param3ArgumentHandler.named((String)entry.getKey())), entry.getValue());  return (Map)treeMap; } public Advice.Dispatcher.Bound bind(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod, param3ForInstrumentedMethod1, param3ForInstrumentedMethod2, this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation, this.classReader); } public boolean isPrependLineNumber() { return this.prependLineNumber; } public TypeDefinition getActualAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public Map<String, TypeDefinition> getNamedTypes() { return this.namedTypes; } protected MethodVisitor apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { return doApply(param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindEnter((MethodDescription)this.adviceMethod), param3ForInstrumentedMethod1.bindEnter(this.adviceMethod), param3ForInstrumentedMethod2.bindEnter(this.adviceMethod), param3TypeDescription, param3MethodDescription, param3Bound, param3Bound1, param3StackManipulation); } protected MethodVisitor doApply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.ENTER));  return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3TypeDescription, param3MethodDescription, param3Assigner, this.adviceMethod, (Map)hashMap, param3Bound, param3Bound1, param3StackManipulation, this.postProcessor, false); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.prependLineNumber != ((ForMethodEnter)param3Object).prependLineNumber) ? false : (!!this.namedTypes.equals(((ForMethodEnter)param3Object).namedTypes)))))); } public int hashCode() { return (super.hashCode() * 31 + this.namedTypes.hashCode()) * 31 + this.prependLineNumber; } protected static class WithRetainedEnterType extends ForMethodEnter { protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader); } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } } protected static class WithDiscardedEnterType extends ForMethodEnter { protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, ClassReader param5ClassReader) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5ClassReader); } public TypeDefinition getAdviceType() { return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class); } protected MethodVisitor doApply(MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) { param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize()); return super.doApply(param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5TypeDescription, param5MethodDescription, param5Bound, param5Bound1, param5StackManipulation); } } } @Enhance protected static abstract class ForMethodExit extends Resolved implements Advice.Dispatcher.Resolved.ForMethodExit { private final Map<String, TypeDefinition> uninitializedNamedTypes; private final boolean backupArguments; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodExit(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map1, Map<String, TypeDefinition> param3Map2, List<? extends Advice.OffsetMapping.Factory<?>> param3List, ClassReader param3ClassReader, TypeDefinition param3TypeDefinition) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param3TypeDefinition), Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param3InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param3Map1), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.of(param3InDefinedShape) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param3ClassReader); this.uninitializedNamedTypes = param3Map2; this.backupArguments = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue(); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map1, Map<String, TypeDefinition> param3Map2, List<? extends Advice.OffsetMapping.Factory<?>> param3List, ClassReader param3ClassReader, TypeDefinition param3TypeDefinition) { TypeDescription typeDescription; return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map1, param3Map2, param3List, param3ClassReader, param3TypeDefinition) : new WithExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map1, param3Map2, param3List, param3ClassReader, param3TypeDefinition, typeDescription)); } public Map<String, TypeDefinition> getNamedTypes() { return this.uninitializedNamedTypes; } protected Map<Integer, TypeDefinition> resolveInitializationTypes(Advice.ArgumentHandler param3ArgumentHandler) { TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); for (Map.Entry<String, TypeDefinition> entry : this.uninitializedNamedTypes.entrySet()) treeMap.put(Integer.valueOf(param3ArgumentHandler.named((String)entry.getKey())), entry.getValue());  if (!this.adviceMethod.getReturnType().represents(void.class)) treeMap.put(Integer.valueOf(param3ArgumentHandler.exit()), this.adviceMethod.getReturnType());  return (Map)treeMap; } protected MethodVisitor apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { return doApply(param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param3ForInstrumentedMethod1.bindExit(this.adviceMethod), param3ForInstrumentedMethod2.bindExit(this.adviceMethod), param3TypeDescription, param3MethodDescription, param3Bound, param3Bound1, param3StackManipulation); } private MethodVisitor doApply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); for (Map.Entry<Integer, Advice.OffsetMapping> entry : this.offsetMappings.entrySet()) hashMap.put(entry.getKey(), ((Advice.OffsetMapping)entry.getValue()).resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.EXIT));  return new Advice.Dispatcher.Inlining.CodeTranslationVisitor(param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3TypeDescription, param3MethodDescription, param3Assigner, this.adviceMethod, (Map)hashMap, param3Bound, param3Bound1, param3StackManipulation, this.postProcessor, true); } public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() { return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE; } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public Advice.Dispatcher.Bound bind(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return new Advice.Dispatcher.Inlining.Resolved.AdviceMethodInliner(this, param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod, param3ForInstrumentedMethod1, param3ForInstrumentedMethod2, this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation, this.classReader); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.backupArguments != ((ForMethodExit)param3Object).backupArguments) ? false : (!!this.uninitializedNamedTypes.equals(((ForMethodExit)param3Object).uninitializedNamedTypes)))))); } public int hashCode() { return (super.hashCode() * 31 + this.uninitializedNamedTypes.hashCode()) * 31 + this.backupArguments; } @Enhance protected static class WithExceptionHandler extends ForMethodExit { private final TypeDescription throwable; protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription) { super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition); this.throwable = param5TypeDescription; } public TypeDescription getThrowable() { return this.throwable; } public boolean equals(@MaybeNull Object param5Object) { return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable))))); } public int hashCode() { return super.hashCode() * 31 + this.throwable.hashCode(); } } protected static class WithoutExceptionHandler extends ForMethodExit { protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map1, Map<String, TypeDefinition> param5Map2, List<? extends Advice.OffsetMapping.Factory<?>> param5List, ClassReader param5ClassReader, TypeDefinition param5TypeDefinition) { super(param5InDefinedShape, param5PostProcessor, param5Map1, param5Map2, param5List, param5ClassReader, param5TypeDefinition); } public TypeDescription getThrowable() { return Advice.NoExceptionHandler.a(); } } } protected static class CodeTranslationVisitor extends MethodVisitor { protected final MethodVisitor methodVisitor; protected final Implementation.Context implementationContext; protected final Advice.ArgumentHandler.ForAdvice argumentHandler; protected final Advice.MethodSizeHandler.ForAdvice methodSizeHandler; protected final Advice.StackMapFrameHandler.ForAdvice stackMapFrameHandler; private final TypeDescription instrumentedType; private final MethodDescription instrumentedMethod; private final Assigner assigner; protected final MethodDescription.InDefinedShape adviceMethod; private final Map<Integer, Advice.OffsetMapping.Target> offsetMappings; private final Advice.Dispatcher.SuppressionHandler.Bound suppressionHandler; private final Advice.Dispatcher.RelocationHandler.Bound relocationHandler; private final StackManipulation exceptionHandler; private final Advice.PostProcessor postProcessor; private final boolean exit; protected final Label endOfMethod; protected CodeTranslationVisitor(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, MethodDescription.InDefinedShape param3InDefinedShape, Map<Integer, Advice.OffsetMapping.Target> param3Map, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation, Advice.PostProcessor param3PostProcessor, boolean param3Boolean) { super(OpenedClassReader.ASM_API, StackAwareMethodVisitor.of(param3MethodVisitor, param3MethodDescription)); this.methodVisitor = param3MethodVisitor; this.implementationContext = param3Context; this.argumentHandler = param3ForAdvice; this.methodSizeHandler = param3ForAdvice1; this.stackMapFrameHandler = param3ForAdvice2; this.instrumentedType = param3TypeDescription; this.instrumentedMethod = param3MethodDescription; this.assigner = param3Assigner; this.adviceMethod = param3InDefinedShape; this.offsetMappings = param3Map; this.suppressionHandler = param3Bound; this.relocationHandler = param3Bound1; this.exceptionHandler = param3StackManipulation; this.postProcessor = param3PostProcessor; this.exit = param3Boolean; this.endOfMethod = new Label(); } protected void propagateHandler(Label param3Label) { ((StackAwareMethodVisitor)this.mv).register(param3Label, Collections.singletonList(StackSize.SINGLE)); } public void visitParameter(String param3String, int param3Int) {} public void visitAnnotableParameterCount(int param3Int, boolean param3Boolean) {} @MaybeNull public AnnotationVisitor visitAnnotationDefault() { return Advice.Dispatcher.IGNORE_ANNOTATION; } @MaybeNull public AnnotationVisitor visitAnnotation(String param3String, boolean param3Boolean) { return Advice.Dispatcher.IGNORE_ANNOTATION; } @MaybeNull public AnnotationVisitor visitTypeAnnotation(int param3Int, @MaybeNull TypePath param3TypePath, String param3String, boolean param3Boolean) { return Advice.Dispatcher.IGNORE_ANNOTATION; } @MaybeNull public AnnotationVisitor visitParameterAnnotation(int param3Int, String param3String, boolean param3Boolean) { return Advice.Dispatcher.IGNORE_ANNOTATION; } public void visitAttribute(Attribute param3Attribute) {} public void visitCode() { this.suppressionHandler.onStart(this.methodVisitor); } public void visitFrame(int param3Int1, int param3Int2, @MaybeNull Object[] param3ArrayOfObject1, int param3Int3, @MaybeNull Object[] param3ArrayOfObject2) { this.stackMapFrameHandler.translateFrame(this.methodVisitor, param3Int1, param3Int2, param3ArrayOfObject1, param3Int3, param3ArrayOfObject2); } public void visitVarInsn(int param3Int1, int param3Int2) { StackManipulation stackManipulation; StackSize stackSize; Advice.OffsetMapping.Target target; if ((target = this.offsetMappings.get(Integer.valueOf(param3Int2))) != null) { switch (param3Int1) { case 21: case 23: case 25: stackManipulation = target.resolveRead(); stackSize = StackSize.SINGLE; break;case 22: case 24: stackManipulation = target.resolveRead(); stackSize = StackSize.DOUBLE; break;case 54: case 55: case 56: case 57: case 58: stackManipulation = target.resolveWrite(); stackSize = StackSize.ZERO; break;default: throw new IllegalStateException("Unexpected opcode: " + stackManipulation); }  this.methodSizeHandler.requireStackSizePadding(stackManipulation.apply(this.mv, this.implementationContext).getMaximalSize() - stackSize.getSize()); return; }  this.mv.visitVarInsn(stackManipulation, this.argumentHandler.mapped(stackSize)); } public void visitIincInsn(int param3Int1, int param3Int2) { Advice.OffsetMapping.Target target; if ((target = this.offsetMappings.get(Integer.valueOf(param3Int1))) != null) { this.methodSizeHandler.requireStackSizePadding(target.resolveIncrement(param3Int2).apply(this.mv, this.implementationContext).getMaximalSize()); return; }  this.mv.visitIincInsn(this.argumentHandler.mapped(param3Int1), param3Int2); } public void visitInsn(int param3Int) { switch (param3Int) { case 177: ((StackAwareMethodVisitor)this.mv).drainStack(); break;case 172: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(54, 21, StackSize.SINGLE)); break;case 176: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(58, 25, StackSize.SINGLE)); break;case 174: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(56, 23, StackSize.SINGLE)); break;case 173: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(55, 22, StackSize.DOUBLE)); break;case 175: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(57, 24, StackSize.DOUBLE)); break;default: this.mv.visitInsn(param3Int); return; }  this.mv.visitJumpInsn(167, this.endOfMethod); } public void visitEnd() { this.suppressionHandler.onEnd(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, (TypeDefinition)this.adviceMethod.getReturnType()); this.methodVisitor.visitLabel(this.endOfMethod); if (this.adviceMethod.getReturnType().represents(boolean.class) || this.adviceMethod.getReturnType().represents(byte.class) || this.adviceMethod.getReturnType().represents(short.class) || this.adviceMethod.getReturnType().represents(char.class) || this.adviceMethod.getReturnType().represents(int.class)) { this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor); this.methodVisitor.visitVarInsn(54, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (this.adviceMethod.getReturnType().represents(long.class)) { this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor); this.methodVisitor.visitVarInsn(55, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (this.adviceMethod.getReturnType().represents(float.class)) { this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor); this.methodVisitor.visitVarInsn(56, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (this.adviceMethod.getReturnType().represents(double.class)) { this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor); this.methodVisitor.visitVarInsn(57, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (!this.adviceMethod.getReturnType().represents(void.class)) { this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor); this.methodVisitor.visitVarInsn(58, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()); }  this.methodSizeHandler.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler).apply(this.methodVisitor, this.implementationContext).getMaximalSize()); this.methodSizeHandler.requireStackSize(this.relocationHandler.apply(this.methodVisitor, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter())); this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor); } public void visitMaxs(int param3Int1, int param3Int2) { this.methodSizeHandler.recordMaxima(param3Int1, param3Int2); } } } @Enhance public static class Delegating implements Dispatcher.Unresolved { protected final MethodDescription.InDefinedShape adviceMethod; protected final Advice.Delegator delegator; protected Delegating(MethodDescription.InDefinedShape param1InDefinedShape, Advice.Delegator param1Delegator) { this.adviceMethod = param1InDefinedShape; this.delegator = param1Delegator; } public boolean isAlive() { return true; } public boolean isBinary() { return false; } public TypeDescription getAdviceType() { return this.adviceMethod.getReturnType().asErasure(); } public Map<String, TypeDefinition> getNamedTypes() { return Collections.emptyMap(); } public Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Advice.Dispatcher.Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory) { return Resolved.ForMethodEnter.of(this.adviceMethod, param1Factory.make(this.adviceMethod, false), this.delegator, param1List, param1Unresolved.getAdviceType(), param1Unresolved.isAlive()); } public Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Advice.Dispatcher.Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory) { Map<String, TypeDefinition> map = param1Unresolved.getNamedTypes(); for (Iterator<ParameterDescription> iterator = this.adviceMethod.getParameters().iterator(); iterator.hasNext();) { if ((loadable = (parameterDescription = iterator.next()).getDeclaredAnnotations().ofType(Advice.Local.class)) != null) { String str = (String)loadable.getValue(Advice.OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class); TypeDefinition typeDefinition; if ((typeDefinition = map.get(str)) == null) throw new IllegalStateException(this.adviceMethod + " attempts use of undeclared local variable " + str);  if (!typeDefinition.equals(parameterDescription.getType())) throw new IllegalStateException(this.adviceMethod + " does not read variable " + str + " as " + typeDefinition);  }  }  return Resolved.ForMethodExit.of(this.adviceMethod, param1Factory.make(this.adviceMethod, true), this.delegator, map, param1List, param1Unresolved.getAdviceType()); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.adviceMethod.equals(((Delegating)param1Object).adviceMethod) ? false : (!!this.delegator.equals(((Delegating)param1Object).delegator))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.adviceMethod.hashCode()) * 31 + this.delegator.hashCode(); } protected static abstract class Resolved extends Advice.Dispatcher.Resolved.AbstractBase { protected final Advice.Delegator delegator; protected Resolved(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2, Advice.Delegator param3Delegator) { super(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDescription1, param3TypeDescription2, Advice.OffsetMapping.Factory.AdviceType.DELEGATION); this.delegator = param3Delegator; } public Map<String, TypeDefinition> getNamedTypes() { return Collections.emptyMap(); } public Advice.Dispatcher.Bound bind(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { if (!this.adviceMethod.isVisibleTo(param3TypeDescription)) throw new IllegalStateException(this.adviceMethod + " is not visible to " + param3MethodDescription.getDeclaringType());  return resolve(param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod, param3ForInstrumentedMethod1, param3ForInstrumentedMethod2, param3StackManipulation, param3Relocation); } protected abstract Advice.Dispatcher.Bound resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation); protected static abstract class AdviceMethodWriter implements Advice.Dispatcher.Bound { protected final MethodDescription.InDefinedShape adviceMethod; private final TypeDescription instrumentedType; private final MethodDescription instrumentedMethod; private final Assigner assigner; private final List<Advice.OffsetMapping.Target> offsetMappings; protected final MethodVisitor methodVisitor; protected final Implementation.Context implementationContext; protected final Advice.ArgumentHandler.ForAdvice argumentHandler; protected final Advice.MethodSizeHandler.ForAdvice methodSizeHandler; protected final Advice.StackMapFrameHandler.ForAdvice stackMapFrameHandler; private final Advice.Dispatcher.SuppressionHandler.Bound suppressionHandler; private final Advice.Dispatcher.RelocationHandler.Bound relocationHandler; private final StackManipulation exceptionHandler; private final Advice.PostProcessor postProcessor; private final Advice.Delegator delegator; protected AdviceMethodWriter(MethodDescription.InDefinedShape param4InDefinedShape, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, Assigner param4Assigner, Advice.PostProcessor param4PostProcessor, List<Advice.OffsetMapping.Target> param4List, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation, Advice.Delegator param4Delegator) { this.adviceMethod = param4InDefinedShape; this.instrumentedType = param4TypeDescription; this.instrumentedMethod = param4MethodDescription; this.assigner = param4Assigner; this.postProcessor = param4PostProcessor; this.offsetMappings = param4List; this.methodVisitor = param4MethodVisitor; this.implementationContext = param4Context; this.argumentHandler = param4ForAdvice; this.methodSizeHandler = param4ForAdvice1; this.stackMapFrameHandler = param4ForAdvice2; this.suppressionHandler = param4Bound; this.relocationHandler = param4Bound1; this.exceptionHandler = param4StackManipulation; this.delegator = param4Delegator; } public void prepare() { this.suppressionHandler.onPrepare(this.methodVisitor); } public void apply() { this.suppressionHandler.onStart(this.methodVisitor); byte b = 0; int i = 0, j = 0; for (Advice.OffsetMapping.Target target : this.offsetMappings) { i += ((ParameterDescription.InDefinedShape)this.adviceMethod.getParameters().get(b++)).getType().getStackSize().getSize(); j = Math.max(j, i + target.resolveRead().apply(this.methodVisitor, this.implementationContext).getMaximalSize()); }  this.delegator.apply(this.methodVisitor, this.adviceMethod, this.instrumentedType, this.instrumentedMethod, isExitAdvice()); this.suppressionHandler.onEndWithSkip(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, (TypeDefinition)this.adviceMethod.getReturnType()); if (this.adviceMethod.getReturnType().represents(boolean.class) || this.adviceMethod.getReturnType().represents(byte.class) || this.adviceMethod.getReturnType().represents(short.class) || this.adviceMethod.getReturnType().represents(char.class) || this.adviceMethod.getReturnType().represents(int.class)) { this.methodVisitor.visitVarInsn(54, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (this.adviceMethod.getReturnType().represents(long.class)) { this.methodVisitor.visitVarInsn(55, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (this.adviceMethod.getReturnType().represents(float.class)) { this.methodVisitor.visitVarInsn(56, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (this.adviceMethod.getReturnType().represents(double.class)) { this.methodVisitor.visitVarInsn(57, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()); } else if (!this.adviceMethod.getReturnType().represents(void.class)) { this.methodVisitor.visitVarInsn(58, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()); }  this.methodSizeHandler.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler).apply(this.methodVisitor, this.implementationContext).getMaximalSize()); this.methodSizeHandler.requireStackSize(this.relocationHandler.apply(this.methodVisitor, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter())); this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor); this.methodSizeHandler.requireStackSize(Math.max(j, this.adviceMethod.getReturnType().getStackSize().getSize())); this.methodSizeHandler.requireLocalVariableLength(this.instrumentedMethod.getStackSize() + this.adviceMethod.getReturnType().getStackSize().getSize()); } protected abstract boolean isExitAdvice(); protected static class ForMethodEnter extends AdviceMethodWriter { protected ForMethodEnter(MethodDescription.InDefinedShape param5InDefinedShape, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Assigner param5Assigner, Advice.PostProcessor param5PostProcessor, List<Advice.OffsetMapping.Target> param5List, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5TypeDescription, param5MethodDescription, param5Assigner, param5PostProcessor, param5List, param5MethodVisitor, param5Context, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation, param5Delegator); } public void initialize() {} protected boolean isExitAdvice() { return false; } } protected static class ForMethodExit extends AdviceMethodWriter { protected ForMethodExit(MethodDescription.InDefinedShape param5InDefinedShape, TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, Assigner param5Assigner, Advice.PostProcessor param5PostProcessor, List<Advice.OffsetMapping.Target> param5List, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5TypeDescription, param5MethodDescription, param5Assigner, param5PostProcessor, param5List, param5MethodVisitor, param5Context, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation, param5Delegator); } public void initialize() { if (this.adviceMethod.getReturnType().represents(boolean.class) || this.adviceMethod.getReturnType().represents(byte.class) || this.adviceMethod.getReturnType().represents(short.class) || this.adviceMethod.getReturnType().represents(char.class) || this.adviceMethod.getReturnType().represents(int.class)) { this.methodVisitor.visitInsn(3); this.methodVisitor.visitVarInsn(54, this.argumentHandler.exit()); } else if (this.adviceMethod.getReturnType().represents(long.class)) { this.methodVisitor.visitInsn(9); this.methodVisitor.visitVarInsn(55, this.argumentHandler.exit()); } else if (this.adviceMethod.getReturnType().represents(float.class)) { this.methodVisitor.visitInsn(11); this.methodVisitor.visitVarInsn(56, this.argumentHandler.exit()); } else if (this.adviceMethod.getReturnType().represents(double.class)) { this.methodVisitor.visitInsn(14); this.methodVisitor.visitVarInsn(57, this.argumentHandler.exit()); } else if (!this.adviceMethod.getReturnType().represents(void.class)) { this.methodVisitor.visitInsn(1); this.methodVisitor.visitVarInsn(58, this.argumentHandler.exit()); }  this.methodSizeHandler.requireStackSize(this.adviceMethod.getReturnType().getStackSize().getSize()); } protected boolean isExitAdvice() { return true; } } } @Enhance protected static abstract class ForMethodEnter extends Resolved implements Advice.Dispatcher.Resolved.ForMethodEnter { private final boolean prependLineNumber; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodEnter(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, Advice.Delegator param4Delegator) { super(param4InDefinedShape, param4PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param4TypeDefinition), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Local>(Advice.Local.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class) }, ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param4Delegator); this.prependLineNumber = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue(); } protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Advice.Delegator param4Delegator, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, boolean param4Boolean) { return (Advice.Dispatcher.Resolved.ForMethodEnter)(param4Boolean ? new WithRetainedEnterType(param4InDefinedShape, param4PostProcessor, param4List, param4TypeDefinition, param4Delegator) : new WithDiscardedEnterType(param4InDefinedShape, param4PostProcessor, param4List, param4TypeDefinition, param4Delegator)); } public boolean isPrependLineNumber() { return this.prependLineNumber; } public TypeDefinition getActualAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } protected Advice.Dispatcher.Bound resolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) { return doResolve(param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod.bindEnter((MethodDescription)this.adviceMethod), param4ForInstrumentedMethod1.bindEnter(this.adviceMethod), param4ForInstrumentedMethod2.bindEnter(this.adviceMethod), this.suppressionHandler.bind(param4StackManipulation), this.relocationHandler.bind(param4MethodDescription, param4Relocation), param4StackManipulation); } protected Advice.Dispatcher.Bound doResolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) { ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size()); for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) arrayList.add(offsetMapping.resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.ENTER));  return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodEnter(this.adviceMethod, param4TypeDescription, param4MethodDescription, param4Assigner, this.postProcessor, arrayList, param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4Bound, param4Bound1, param4StackManipulation, this.delegator); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!(this.prependLineNumber != ((ForMethodEnter)param4Object).prependLineNumber))))); } public int hashCode() { return super.hashCode() * 31 + this.prependLineNumber; } protected static class WithRetainedEnterType extends ForMethodEnter { protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator); } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } } protected static class WithDiscardedEnterType extends ForMethodEnter { protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator); } public TypeDefinition getAdviceType() { return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class); } protected Advice.Dispatcher.Bound doResolve(TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) { param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize()); return super.doResolve(param5TypeDescription, param5MethodDescription, param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation); } } } @Enhance protected static abstract class ForMethodExit extends Resolved implements Advice.Dispatcher.Resolved.ForMethodExit { private final boolean backupArguments; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodExit(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition, Advice.Delegator param4Delegator) { super(param4InDefinedShape, param4PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param4TypeDefinition), Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param4InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param4Map), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.of(param4InDefinedShape) }, ), param4List), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param4Delegator); this.backupArguments = ((Boolean)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue(); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param4InDefinedShape, Advice.PostProcessor param4PostProcessor, Advice.Delegator param4Delegator, Map<String, TypeDefinition> param4Map, List<? extends Advice.OffsetMapping.Factory<?>> param4List, TypeDefinition param4TypeDefinition) { TypeDescription typeDescription; return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, param4Delegator) : new WithExceptionHandler(param4InDefinedShape, param4PostProcessor, param4Map, param4List, param4TypeDefinition, typeDescription, param4Delegator)); } protected Advice.Dispatcher.Bound resolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param4ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param4ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param4ForInstrumentedMethod2, StackManipulation param4StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param4Relocation) { return doResolve(param4TypeDescription, param4MethodDescription, param4MethodVisitor, param4Context, param4Assigner, param4ForInstrumentedMethod.bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param4ForInstrumentedMethod1.bindExit(this.adviceMethod), param4ForInstrumentedMethod2.bindExit(this.adviceMethod), this.suppressionHandler.bind(param4StackManipulation), this.relocationHandler.bind(param4MethodDescription, param4Relocation), param4StackManipulation); } private Advice.Dispatcher.Bound doResolve(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodVisitor param4MethodVisitor, Implementation.Context param4Context, Assigner param4Assigner, Advice.ArgumentHandler.ForAdvice param4ForAdvice, Advice.MethodSizeHandler.ForAdvice param4ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param4ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param4Bound, Advice.Dispatcher.RelocationHandler.Bound param4Bound1, StackManipulation param4StackManipulation) { ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size()); for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) arrayList.add(offsetMapping.resolve(param4TypeDescription, param4MethodDescription, param4Assigner, param4ForAdvice, Advice.OffsetMapping.Sort.EXIT));  return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodExit(this.adviceMethod, param4TypeDescription, param4MethodDescription, param4Assigner, this.postProcessor, arrayList, param4MethodVisitor, param4Context, param4ForAdvice, param4ForAdvice1, param4ForAdvice2, param4Bound, param4Bound1, param4StackManipulation, this.delegator); } public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() { return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE; } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!(this.backupArguments != ((ForMethodExit)param4Object).backupArguments))))); } public int hashCode() { return super.hashCode() * 31 + this.backupArguments; } @Enhance protected static class WithExceptionHandler extends ForMethodExit { private final TypeDescription throwable; protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator); this.throwable = param5TypeDescription; } public TypeDescription getThrowable() { return this.throwable; } public boolean equals(@MaybeNull Object param5Object) { return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable))))); } public int hashCode() { return super.hashCode() * 31 + this.throwable.hashCode(); } } protected static class WithoutExceptionHandler extends ForMethodExit { public TypeDescription getThrowable() { return Advice.NoExceptionHandler.a(); } protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator); } } } } @Enhance protected static abstract class ForMethodEnter extends Resolved implements Advice.Dispatcher.Resolved.ForMethodEnter { private final boolean prependLineNumber; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodEnter(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, Advice.Delegator param3Delegator) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForExitValue.Factory.of(param3TypeDefinition), new Advice.OffsetMapping.Factory.Illegal<Advice.Thrown>(Advice.Thrown.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Enter>(Advice.Enter.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Local>(Advice.Local.class), new Advice.OffsetMapping.Factory.Illegal<Advice.Return>(Advice.Return.class) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.b()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.c()).resolve(TypeDescription.class), param3Delegator); this.prependLineNumber = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodEnter.class).getValue(Advice.d()).resolve(Boolean.class)).booleanValue(); } protected static Advice.Dispatcher.Resolved.ForMethodEnter of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Advice.Delegator param3Delegator, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, boolean param3Boolean) { return (Advice.Dispatcher.Resolved.ForMethodEnter)(param3Boolean ? new WithRetainedEnterType(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDefinition, param3Delegator) : new WithDiscardedEnterType(param3InDefinedShape, param3PostProcessor, param3List, param3TypeDefinition, param3Delegator)); } public boolean isPrependLineNumber() { return this.prependLineNumber; } public TypeDefinition getActualAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } protected Advice.Dispatcher.Bound resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return doResolve(param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindEnter((MethodDescription)this.adviceMethod), param3ForInstrumentedMethod1.bindEnter(this.adviceMethod), param3ForInstrumentedMethod2.bindEnter(this.adviceMethod), this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation); } protected Advice.Dispatcher.Bound doResolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size()); for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) arrayList.add(offsetMapping.resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.ENTER));  return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodEnter(this.adviceMethod, param3TypeDescription, param3MethodDescription, param3Assigner, this.postProcessor, arrayList, param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3Bound, param3Bound1, param3StackManipulation, this.delegator); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.prependLineNumber != ((ForMethodEnter)param3Object).prependLineNumber))))); } public int hashCode() { return super.hashCode() * 31 + this.prependLineNumber; } protected static class WithRetainedEnterType extends ForMethodEnter { protected WithRetainedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator); } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } } protected static class WithDiscardedEnterType extends ForMethodEnter { protected WithDiscardedEnterType(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5List, param5TypeDefinition, param5Delegator); } public TypeDefinition getAdviceType() { return (TypeDefinition)TypeDescription.ForLoadedType.of(void.class); } protected Advice.Dispatcher.Bound doResolve(TypeDescription param5TypeDescription, MethodDescription param5MethodDescription, MethodVisitor param5MethodVisitor, Implementation.Context param5Context, Assigner param5Assigner, Advice.ArgumentHandler.ForAdvice param5ForAdvice, Advice.MethodSizeHandler.ForAdvice param5ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param5ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param5Bound, Advice.Dispatcher.RelocationHandler.Bound param5Bound1, StackManipulation param5StackManipulation) { param5ForAdvice1.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize()); return super.doResolve(param5TypeDescription, param5MethodDescription, param5MethodVisitor, param5Context, param5Assigner, param5ForAdvice, param5ForAdvice1, param5ForAdvice2, param5Bound, param5Bound1, param5StackManipulation); } } } @Enhance protected static abstract class ForMethodExit extends Resolved implements Advice.Dispatcher.Resolved.ForMethodExit { private final boolean backupArguments; @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected ForMethodExit(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition, Advice.Delegator param3Delegator) { super(param3InDefinedShape, param3PostProcessor, CompoundList.of(Arrays.asList(new Advice.OffsetMapping.Factory[] { Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE, Advice.OffsetMapping.ForThisReference.Factory.INSTANCE, Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE, Advice.OffsetMapping.ForOrigin.Factory.INSTANCE, Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE, Advice.OffsetMapping.ForStubValue.INSTANCE, Advice.OffsetMapping.ForEnterValue.Factory.of(param3TypeDefinition), Advice.OffsetMapping.ForExitValue.Factory.of((TypeDefinition)param3InDefinedShape.getReturnType()), new Advice.OffsetMapping.ForLocalValue.Factory(param3Map), Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE, Advice.OffsetMapping.ForThrowable.Factory.of(param3InDefinedShape) }, ), param3List), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.e()).resolve(TypeDescription.class), (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.f()).resolve(TypeDescription.class), param3Delegator); this.backupArguments = ((Boolean)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.g()).resolve(Boolean.class)).booleanValue(); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.") protected static Advice.Dispatcher.Resolved.ForMethodExit of(MethodDescription.InDefinedShape param3InDefinedShape, Advice.PostProcessor param3PostProcessor, Advice.Delegator param3Delegator, Map<String, TypeDefinition> param3Map, List<? extends Advice.OffsetMapping.Factory<?>> param3List, TypeDefinition param3TypeDefinition) { TypeDescription typeDescription; return (Advice.Dispatcher.Resolved.ForMethodExit)((typeDescription = (TypeDescription)param3InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class) ? new WithoutExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, param3Delegator) : new WithExceptionHandler(param3InDefinedShape, param3PostProcessor, param3Map, param3List, param3TypeDefinition, typeDescription, param3Delegator)); } protected Advice.Dispatcher.Bound resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForInstrumentedMethod param3ForInstrumentedMethod, Advice.MethodSizeHandler.ForInstrumentedMethod param3ForInstrumentedMethod1, Advice.StackMapFrameHandler.ForInstrumentedMethod param3ForInstrumentedMethod2, StackManipulation param3StackManipulation, Advice.Dispatcher.RelocationHandler.Relocation param3Relocation) { return doResolve(param3TypeDescription, param3MethodDescription, param3MethodVisitor, param3Context, param3Assigner, param3ForInstrumentedMethod.bindExit((MethodDescription)this.adviceMethod, getThrowable().represents(Advice.NoExceptionHandler.class)), param3ForInstrumentedMethod1.bindExit(this.adviceMethod), param3ForInstrumentedMethod2.bindExit(this.adviceMethod), this.suppressionHandler.bind(param3StackManipulation), this.relocationHandler.bind(param3MethodDescription, param3Relocation), param3StackManipulation); } private Advice.Dispatcher.Bound doResolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, Advice.ArgumentHandler.ForAdvice param3ForAdvice, Advice.MethodSizeHandler.ForAdvice param3ForAdvice1, Advice.StackMapFrameHandler.ForAdvice param3ForAdvice2, Advice.Dispatcher.SuppressionHandler.Bound param3Bound, Advice.Dispatcher.RelocationHandler.Bound param3Bound1, StackManipulation param3StackManipulation) { ArrayList<Advice.OffsetMapping.Target> arrayList = new ArrayList(this.offsetMappings.size()); for (Advice.OffsetMapping offsetMapping : this.offsetMappings.values()) arrayList.add(offsetMapping.resolve(param3TypeDescription, param3MethodDescription, param3Assigner, param3ForAdvice, Advice.OffsetMapping.Sort.EXIT));  return new Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter.ForMethodExit(this.adviceMethod, param3TypeDescription, param3MethodDescription, param3Assigner, this.postProcessor, arrayList, param3MethodVisitor, param3Context, param3ForAdvice, param3ForAdvice1, param3ForAdvice2, param3Bound, param3Bound1, param3StackManipulation, this.delegator); } public Advice.ArgumentHandler.Factory getArgumentHandlerFactory() { return this.backupArguments ? Advice.ArgumentHandler.Factory.COPYING : Advice.ArgumentHandler.Factory.SIMPLE; } public TypeDefinition getAdviceType() { return (TypeDefinition)this.adviceMethod.getReturnType(); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.backupArguments != ((ForMethodExit)param3Object).backupArguments))))); } public int hashCode() { return super.hashCode() * 31 + this.backupArguments; } @Enhance protected static class WithExceptionHandler extends ForMethodExit { private final TypeDescription throwable; protected WithExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, TypeDescription param5TypeDescription, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator); this.throwable = param5TypeDescription; } public TypeDescription getThrowable() { return this.throwable; } public boolean equals(@MaybeNull Object param5Object) { return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.throwable.equals(((WithExceptionHandler)param5Object).throwable))))); } public int hashCode() { return super.hashCode() * 31 + this.throwable.hashCode(); } } protected static class WithoutExceptionHandler extends ForMethodExit { protected WithoutExceptionHandler(MethodDescription.InDefinedShape param5InDefinedShape, Advice.PostProcessor param5PostProcessor, Map<String, TypeDefinition> param5Map, List<? extends Advice.OffsetMapping.Factory<?>> param5List, TypeDefinition param5TypeDefinition, Advice.Delegator param5Delegator) { super(param5InDefinedShape, param5PostProcessor, param5Map, param5List, param5TypeDefinition, param5Delegator); } public TypeDescription getThrowable() { return Advice.NoExceptionHandler.a(); }
/*       */          }
/*       */        }
/*       */      }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   protected static abstract class AdviceVisitor
/*       */     extends ExceptionTableSensitiveMethodVisitor
/*       */     implements Dispatcher.RelocationHandler.Relocation
/*       */   {
/*       */     private static final int THIS_VARIABLE_INDEX = 0;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private static final String THIS_VARIABLE_NAME = "this";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final MethodDescription instrumentedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final Label preparationStart;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final Advice.Dispatcher.Bound methodEnter;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final Advice.Dispatcher.Bound methodExit;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final Advice.ArgumentHandler.ForInstrumentedMethod argumentHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final Advice.MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final Advice.StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected AdviceVisitor(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, Assigner param1Assigner, StackManipulation param1StackManipulation, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param1ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param1ForMethodExit, List<? extends TypeDescription> param1List, int param1Int1, int param1Int2) {
/* 10645 */       super(OpenedClassReader.ASM_API, param1MethodVisitor);
/* 10646 */       this.instrumentedMethod = param1MethodDescription;
/* 10647 */       this.preparationStart = new Label();
/*       */       TreeMap<Object, Object> treeMap;
/* 10649 */       (treeMap = new TreeMap<Object, Object>()).putAll(param1ForMethodEnter.getNamedTypes());
/* 10650 */       treeMap.putAll(param1ForMethodExit.getNamedTypes());
/* 10651 */       this.argumentHandler = param1ForMethodExit.getArgumentHandlerFactory().resolve(param1MethodDescription, param1ForMethodEnter
/* 10652 */           .getAdviceType(), param1ForMethodExit
/* 10653 */           .getAdviceType(), (SortedMap)treeMap);
/*       */       
/* 10655 */       List<? extends TypeDescription> list = CompoundList.of(param1ForMethodExit.getAdviceType().represents(void.class) ? 
/* 10656 */           Collections.emptyList() : 
/* 10657 */           Collections.<TypeDescription>singletonList(param1ForMethodExit.getAdviceType().asErasure()), this.argumentHandler.getNamedTypes());
/*       */ 
/*       */       
/* 10660 */       List<T> list1 = param1ForMethodEnter.getActualAdviceType().represents(void.class) ? Collections.<T>emptyList() : Collections.<T>singletonList((T)param1ForMethodEnter.getActualAdviceType().asErasure());
/*       */ 
/*       */       
/* 10663 */       List<T> list2 = param1ForMethodEnter.getAdviceType().represents(void.class) ? Collections.<T>emptyList() : Collections.<T>singletonList((T)param1ForMethodEnter.getAdviceType().asErasure());
/* 10664 */       this.methodSizeHandler = Advice.MethodSizeHandler.Default.of(param1MethodDescription, list, (List)list2, param1List, this.argumentHandler
/*       */ 
/*       */ 
/*       */           
/* 10668 */           .isCopyingArguments(), param1Int1);
/*       */       
/* 10670 */       this.stackMapFrameHandler = Advice.StackMapFrameHandler.Default.of(param1TypeDescription, param1MethodDescription, list, (List)list1, (List)list2, param1List, param1ForMethodExit
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 10676 */           .isAlive(), this.argumentHandler
/* 10677 */           .isCopyingArguments(), param1Context
/* 10678 */           .getClassFileVersion(), param1Int1, param1Int2);
/*       */ 
/*       */       
/* 10681 */       this.methodEnter = param1ForMethodEnter.bind(param1TypeDescription, param1MethodDescription, param1MethodVisitor, param1Context, param1Assigner, this.argumentHandler, this.methodSizeHandler, this.stackMapFrameHandler, param1StackManipulation, this);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/* 10691 */       this.methodExit = param1ForMethodExit.bind(param1TypeDescription, param1MethodDescription, param1MethodVisitor, param1Context, param1Assigner, this.argumentHandler, this.methodSizeHandler, this.stackMapFrameHandler, param1StackManipulation, new Advice.Dispatcher.RelocationHandler.Relocation.ForLabel(this.preparationStart));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected void onAfterExceptionTable() {
/* 10705 */       this.methodEnter.prepare();
/* 10706 */       onUserPrepare();
/* 10707 */       this.methodExit.prepare();
/* 10708 */       this.methodEnter.initialize();
/* 10709 */       this.methodExit.initialize();
/* 10710 */       this.stackMapFrameHandler.injectInitializationFrame(this.mv);
/* 10711 */       this.methodEnter.apply();
/* 10712 */       this.mv.visitLabel(this.preparationStart);
/* 10713 */       this.methodSizeHandler.requireStackSize(this.argumentHandler.prepare(this.mv));
/* 10714 */       this.stackMapFrameHandler.injectStartFrame(this.mv);
/* 10715 */       this.mv.visitInsn(0);
/* 10716 */       onUserStart();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract void onUserPrepare();
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract void onUserStart();
/*       */ 
/*       */ 
/*       */     
/*       */     protected void onVisitVarInsn(int param1Int1, int param1Int2) {
/* 10731 */       this.mv.visitVarInsn(param1Int1, this.argumentHandler.argument(param1Int2));
/*       */     }
/*       */ 
/*       */     
/*       */     protected void onVisitIincInsn(int param1Int1, int param1Int2) {
/* 10736 */       this.mv.visitIincInsn(this.argumentHandler.argument(param1Int1), param1Int2);
/*       */     }
/*       */ 
/*       */     
/*       */     public void onVisitFrame(int param1Int1, int param1Int2, @MaybeNull Object[] param1ArrayOfObject1, int param1Int3, @MaybeNull Object[] param1ArrayOfObject2) {
/* 10741 */       this.stackMapFrameHandler.translateFrame(this.mv, param1Int1, param1Int2, param1ArrayOfObject1, param1Int3, param1ArrayOfObject2);
/*       */     }
/*       */ 
/*       */     
/*       */     public void visitMaxs(int param1Int1, int param1Int2) {
/* 10746 */       onUserEnd();
/* 10747 */       this.mv.visitMaxs(this.methodSizeHandler.compoundStackSize(param1Int1), this.methodSizeHandler.compoundLocalVariableLength(param1Int2));
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public void visitLocalVariable(String param1String1, String param1String2, String param1String3, Label param1Label1, Label param1Label2, int param1Int) {
/* 10753 */       this.mv.visitLocalVariable(param1String1, param1String2, param1String3, param1Label1, param1Label2, (param1Int == 0 && "this".equals(param1String1)) ? param1Int : this.argumentHandler
/*       */           
/* 10755 */           .variable(param1Int));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AnnotationVisitor visitLocalVariableAnnotation(int param1Int, TypePath param1TypePath, Label[] param1ArrayOfLabel1, Label[] param1ArrayOfLabel2, int[] param1ArrayOfint, String param1String, boolean param1Boolean) {
/* 10766 */       int[] arrayOfInt = new int[param1ArrayOfint.length];
/* 10767 */       for (byte b = 0; b < param1ArrayOfint.length; b++) {
/* 10768 */         arrayOfInt[b] = this.argumentHandler.variable(param1ArrayOfint[b]);
/*       */       }
/* 10770 */       return this.mv.visitLocalVariableAnnotation(param1Int, param1TypePath, param1ArrayOfLabel1, param1ArrayOfLabel2, arrayOfInt, param1String, param1Boolean);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract void onUserEnd();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected static class WithoutExitAdvice
/*       */       extends AdviceVisitor
/*       */     {
/*       */       protected WithoutExitAdvice(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, Assigner param2Assigner, StackManipulation param2StackManipulation, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param2ForMethodEnter, int param2Int1, int param2Int2) {
/* 10805 */         super(param2MethodVisitor, param2Context, param2Assigner, param2StackManipulation, param2TypeDescription, param2MethodDescription, param2ForMethodEnter, Advice.Dispatcher.Inactive.INSTANCE, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/* 10813 */             Collections.emptyList(), param2Int1, param2Int2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void apply(MethodVisitor param2MethodVisitor) {
/* 10822 */         if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod
/* 10823 */           .getReturnType().represents(byte.class) || this.instrumentedMethod
/* 10824 */           .getReturnType().represents(short.class) || this.instrumentedMethod
/* 10825 */           .getReturnType().represents(char.class) || this.instrumentedMethod
/* 10826 */           .getReturnType().represents(int.class)) {
/* 10827 */           param2MethodVisitor.visitInsn(3);
/* 10828 */           param2MethodVisitor.visitInsn(172); return;
/* 10829 */         }  if (this.instrumentedMethod.getReturnType().represents(long.class)) {
/* 10830 */           param2MethodVisitor.visitInsn(9);
/* 10831 */           param2MethodVisitor.visitInsn(173); return;
/* 10832 */         }  if (this.instrumentedMethod.getReturnType().represents(float.class)) {
/* 10833 */           param2MethodVisitor.visitInsn(11);
/* 10834 */           param2MethodVisitor.visitInsn(174); return;
/* 10835 */         }  if (this.instrumentedMethod.getReturnType().represents(double.class)) {
/* 10836 */           param2MethodVisitor.visitInsn(14);
/* 10837 */           param2MethodVisitor.visitInsn(175); return;
/* 10838 */         }  if (this.instrumentedMethod.getReturnType().represents(void.class)) {
/* 10839 */           param2MethodVisitor.visitInsn(177); return;
/*       */         } 
/* 10841 */         param2MethodVisitor.visitInsn(1);
/* 10842 */         param2MethodVisitor.visitInsn(176);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected void onUserPrepare() {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected void onUserStart() {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected void onUserEnd() {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected static abstract class WithExitAdvice
/*       */       extends AdviceVisitor
/*       */     {
/*       */       protected final Label returnHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected WithExitAdvice(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, Assigner param2Assigner, StackManipulation param2StackManipulation, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param2ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param2ForMethodExit, List<? extends TypeDescription> param2List, int param2Int1, int param2Int2) {
/* 10898 */         super(StackAwareMethodVisitor.of(param2MethodVisitor, param2MethodDescription), param2Context, param2Assigner, param2StackManipulation, param2TypeDescription, param2MethodDescription, param2ForMethodEnter, param2ForMethodExit, param2List, param2Int1, param2Int2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10909 */         this.returnHandler = new Label();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void apply(MethodVisitor param2MethodVisitor) {
/* 10916 */         if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod
/* 10917 */           .getReturnType().represents(byte.class) || this.instrumentedMethod
/* 10918 */           .getReturnType().represents(short.class) || this.instrumentedMethod
/* 10919 */           .getReturnType().represents(char.class) || this.instrumentedMethod
/* 10920 */           .getReturnType().represents(int.class)) {
/* 10921 */           param2MethodVisitor.visitInsn(3);
/* 10922 */         } else if (this.instrumentedMethod.getReturnType().represents(long.class)) {
/* 10923 */           param2MethodVisitor.visitInsn(9);
/* 10924 */         } else if (this.instrumentedMethod.getReturnType().represents(float.class)) {
/* 10925 */           param2MethodVisitor.visitInsn(11);
/* 10926 */         } else if (this.instrumentedMethod.getReturnType().represents(double.class)) {
/* 10927 */           param2MethodVisitor.visitInsn(14);
/* 10928 */         } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) {
/* 10929 */           param2MethodVisitor.visitInsn(1);
/*       */         } 
/* 10931 */         param2MethodVisitor.visitJumpInsn(167, this.returnHandler);
/*       */       }
/*       */ 
/*       */       
/*       */       protected void onVisitInsn(int param2Int) {
/* 10936 */         switch (param2Int) {
/*       */           case 177:
/* 10938 */             ((StackAwareMethodVisitor)this.mv).drainStack();
/*       */             break;
/*       */           case 172:
/* 10941 */             this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(54, 21, StackSize.SINGLE));
/*       */             break;
/*       */           case 174:
/* 10944 */             this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(56, 23, StackSize.SINGLE));
/*       */             break;
/*       */           case 175:
/* 10947 */             this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(57, 24, StackSize.DOUBLE));
/*       */             break;
/*       */           case 173:
/* 10950 */             this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(55, 22, StackSize.DOUBLE));
/*       */             break;
/*       */           case 176:
/* 10953 */             this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(58, 25, StackSize.SINGLE));
/*       */             break;
/*       */           default:
/* 10956 */             this.mv.visitInsn(param2Int);
/*       */             return;
/*       */         } 
/* 10959 */         this.mv.visitJumpInsn(167, this.returnHandler);
/*       */       }
/*       */ 
/*       */       
/*       */       protected void onUserEnd() {
/* 10964 */         this.mv.visitLabel(this.returnHandler);
/* 10965 */         onUserReturn();
/* 10966 */         this.stackMapFrameHandler.injectCompletionFrame(this.mv);
/* 10967 */         this.methodExit.apply();
/* 10968 */         onExitAdviceReturn();
/* 10969 */         if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod
/* 10970 */           .getReturnType().represents(byte.class) || this.instrumentedMethod
/* 10971 */           .getReturnType().represents(short.class) || this.instrumentedMethod
/* 10972 */           .getReturnType().represents(char.class) || this.instrumentedMethod
/* 10973 */           .getReturnType().represents(int.class)) {
/* 10974 */           this.mv.visitVarInsn(21, this.argumentHandler.returned());
/* 10975 */           this.mv.visitInsn(172);
/* 10976 */         } else if (this.instrumentedMethod.getReturnType().represents(long.class)) {
/* 10977 */           this.mv.visitVarInsn(22, this.argumentHandler.returned());
/* 10978 */           this.mv.visitInsn(173);
/* 10979 */         } else if (this.instrumentedMethod.getReturnType().represents(float.class)) {
/* 10980 */           this.mv.visitVarInsn(23, this.argumentHandler.returned());
/* 10981 */           this.mv.visitInsn(174);
/* 10982 */         } else if (this.instrumentedMethod.getReturnType().represents(double.class)) {
/* 10983 */           this.mv.visitVarInsn(24, this.argumentHandler.returned());
/* 10984 */           this.mv.visitInsn(175);
/* 10985 */         } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) {
/* 10986 */           this.mv.visitVarInsn(25, this.argumentHandler.returned());
/* 10987 */           this.mv.visitInsn(176);
/*       */         } else {
/* 10989 */           this.mv.visitInsn(177);
/*       */         } 
/* 10991 */         this.methodSizeHandler.requireStackSize(this.instrumentedMethod.getReturnType().getStackSize().getSize());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract void onUserReturn();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract void onExitAdviceReturn();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class WithoutExceptionHandling
/*       */         extends WithExitAdvice
/*       */       {
/*       */         protected WithoutExceptionHandling(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, StackManipulation param3StackManipulation, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param3ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param3ForMethodExit, int param3Int1, int param3Int2) {
/* 11033 */           super(param3MethodVisitor, param3Context, param3Assigner, param3StackManipulation, param3TypeDescription, param3MethodDescription, param3ForMethodEnter, param3ForMethodExit, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */               
/* 11041 */               param3MethodDescription.getReturnType().represents(void.class) ? 
/* 11042 */               Collections.<TypeDescription>emptyList() : 
/* 11043 */               Collections.<TypeDescription>singletonList(param3MethodDescription.getReturnType().asErasure()), param3Int1, param3Int2);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected void onUserPrepare() {}
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected void onUserStart() {}
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected void onUserReturn() {
/* 11060 */           if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod
/* 11061 */             .getReturnType().represents(byte.class) || this.instrumentedMethod
/* 11062 */             .getReturnType().represents(short.class) || this.instrumentedMethod
/* 11063 */             .getReturnType().represents(char.class) || this.instrumentedMethod
/* 11064 */             .getReturnType().represents(int.class)) {
/* 11065 */             this.stackMapFrameHandler.injectReturnFrame(this.mv);
/* 11066 */             this.mv.visitVarInsn(54, this.argumentHandler.returned()); return;
/* 11067 */           }  if (this.instrumentedMethod.getReturnType().represents(long.class)) {
/* 11068 */             this.stackMapFrameHandler.injectReturnFrame(this.mv);
/* 11069 */             this.mv.visitVarInsn(55, this.argumentHandler.returned()); return;
/* 11070 */           }  if (this.instrumentedMethod.getReturnType().represents(float.class)) {
/* 11071 */             this.stackMapFrameHandler.injectReturnFrame(this.mv);
/* 11072 */             this.mv.visitVarInsn(56, this.argumentHandler.returned()); return;
/* 11073 */           }  if (this.instrumentedMethod.getReturnType().represents(double.class)) {
/* 11074 */             this.stackMapFrameHandler.injectReturnFrame(this.mv);
/* 11075 */             this.mv.visitVarInsn(57, this.argumentHandler.returned()); return;
/* 11076 */           }  if (!this.instrumentedMethod.getReturnType().represents(void.class)) {
/* 11077 */             this.stackMapFrameHandler.injectReturnFrame(this.mv);
/* 11078 */             this.mv.visitVarInsn(58, this.argumentHandler.returned());
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected void onExitAdviceReturn() {}
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class WithExceptionHandling
/*       */         extends WithExitAdvice
/*       */       {
/*       */         private final TypeDescription throwable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Label exceptionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final Label userStart;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected WithExceptionHandling(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, StackManipulation param3StackManipulation, TypeDescription param3TypeDescription1, MethodDescription param3MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param3ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param3ForMethodExit, int param3Int1, int param3Int2, TypeDescription param3TypeDescription2) {
/* 11134 */           super(param3MethodVisitor, param3Context, param3Assigner, param3StackManipulation, param3TypeDescription1, param3MethodDescription, param3ForMethodEnter, param3ForMethodExit, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */               
/* 11142 */               param3MethodDescription.getReturnType().represents(void.class) ? 
/* 11143 */               Collections.<TypeDescription>singletonList(TypeDescription.ForLoadedType.of(Throwable.class)) : 
/* 11144 */               Arrays.<TypeDescription>asList(new TypeDescription[] { param3MethodDescription.getReturnType().asErasure(), TypeDescription.ForLoadedType.of(Throwable.class) }, ), param3Int1, param3Int2);
/*       */ 
/*       */           
/* 11147 */           this.throwable = param3TypeDescription2;
/* 11148 */           this.exceptionHandler = new Label();
/* 11149 */           this.userStart = new Label();
/*       */         }
/*       */ 
/*       */         
/*       */         protected void onUserPrepare() {
/* 11154 */           this.mv.visitTryCatchBlock(this.userStart, this.returnHandler, this.exceptionHandler, this.throwable.getInternalName());
/*       */         }
/*       */ 
/*       */         
/*       */         protected void onUserStart() {
/* 11159 */           this.mv.visitLabel(this.userStart);
/*       */         }
/*       */ 
/*       */         
/*       */         protected void onUserReturn() {
/* 11164 */           this.stackMapFrameHandler.injectReturnFrame(this.mv);
/* 11165 */           if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod
/* 11166 */             .getReturnType().represents(byte.class) || this.instrumentedMethod
/* 11167 */             .getReturnType().represents(short.class) || this.instrumentedMethod
/* 11168 */             .getReturnType().represents(char.class) || this.instrumentedMethod
/* 11169 */             .getReturnType().represents(int.class)) {
/* 11170 */             this.mv.visitVarInsn(54, this.argumentHandler.returned());
/* 11171 */           } else if (this.instrumentedMethod.getReturnType().represents(long.class)) {
/* 11172 */             this.mv.visitVarInsn(55, this.argumentHandler.returned());
/* 11173 */           } else if (this.instrumentedMethod.getReturnType().represents(float.class)) {
/* 11174 */             this.mv.visitVarInsn(56, this.argumentHandler.returned());
/* 11175 */           } else if (this.instrumentedMethod.getReturnType().represents(double.class)) {
/* 11176 */             this.mv.visitVarInsn(57, this.argumentHandler.returned());
/* 11177 */           } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) {
/* 11178 */             this.mv.visitVarInsn(58, this.argumentHandler.returned());
/*       */           } 
/* 11180 */           this.mv.visitInsn(1);
/* 11181 */           this.mv.visitVarInsn(58, this.argumentHandler.thrown());
/* 11182 */           Label label = new Label();
/* 11183 */           this.mv.visitJumpInsn(167, label);
/* 11184 */           this.mv.visitLabel(this.exceptionHandler);
/* 11185 */           this.stackMapFrameHandler.injectExceptionFrame(this.mv);
/* 11186 */           this.mv.visitVarInsn(58, this.argumentHandler.thrown());
/* 11187 */           if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod
/* 11188 */             .getReturnType().represents(byte.class) || this.instrumentedMethod
/* 11189 */             .getReturnType().represents(short.class) || this.instrumentedMethod
/* 11190 */             .getReturnType().represents(char.class) || this.instrumentedMethod
/* 11191 */             .getReturnType().represents(int.class)) {
/* 11192 */             this.mv.visitInsn(3);
/* 11193 */             this.mv.visitVarInsn(54, this.argumentHandler.returned());
/* 11194 */           } else if (this.instrumentedMethod.getReturnType().represents(long.class)) {
/* 11195 */             this.mv.visitInsn(9);
/* 11196 */             this.mv.visitVarInsn(55, this.argumentHandler.returned());
/* 11197 */           } else if (this.instrumentedMethod.getReturnType().represents(float.class)) {
/* 11198 */             this.mv.visitInsn(11);
/* 11199 */             this.mv.visitVarInsn(56, this.argumentHandler.returned());
/* 11200 */           } else if (this.instrumentedMethod.getReturnType().represents(double.class)) {
/* 11201 */             this.mv.visitInsn(14);
/* 11202 */             this.mv.visitVarInsn(57, this.argumentHandler.returned());
/* 11203 */           } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) {
/* 11204 */             this.mv.visitInsn(1);
/* 11205 */             this.mv.visitVarInsn(58, this.argumentHandler.returned());
/*       */           } 
/* 11207 */           this.mv.visitLabel(label);
/* 11208 */           this.methodSizeHandler.requireStackSize(StackSize.SINGLE.getSize());
/*       */         }
/*       */         
/*       */         protected void onExitAdviceReturn()
/*       */         {
/* 11213 */           this.mv.visitVarInsn(25, this.argumentHandler.thrown());
/* 11214 */           Label label = new Label();
/* 11215 */           this.mv.visitJumpInsn(198, label);
/* 11216 */           this.mv.visitVarInsn(25, this.argumentHandler.thrown());
/* 11217 */           this.mv.visitInsn(191);
/* 11218 */           this.mv.visitLabel(label);
/* 11219 */           this.stackMapFrameHandler.injectPostCompletionFrame(this.mv); } } } } protected static class WithoutExitAdvice extends AdviceVisitor { protected WithoutExitAdvice(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, Assigner param1Assigner, StackManipulation param1StackManipulation, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param1ForMethodEnter, int param1Int1, int param1Int2) { super(param1MethodVisitor, param1Context, param1Assigner, param1StackManipulation, param1TypeDescription, param1MethodDescription, param1ForMethodEnter, Advice.Dispatcher.Inactive.INSTANCE, Collections.emptyList(), param1Int1, param1Int2); } public void apply(MethodVisitor param1MethodVisitor) { if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { param1MethodVisitor.visitInsn(3); param1MethodVisitor.visitInsn(172); return; }  if (this.instrumentedMethod.getReturnType().represents(long.class)) { param1MethodVisitor.visitInsn(9); param1MethodVisitor.visitInsn(173); return; }  if (this.instrumentedMethod.getReturnType().represents(float.class)) { param1MethodVisitor.visitInsn(11); param1MethodVisitor.visitInsn(174); return; }  if (this.instrumentedMethod.getReturnType().represents(double.class)) { param1MethodVisitor.visitInsn(14); param1MethodVisitor.visitInsn(175); return; }  if (this.instrumentedMethod.getReturnType().represents(void.class)) { param1MethodVisitor.visitInsn(177); return; }  param1MethodVisitor.visitInsn(1); param1MethodVisitor.visitInsn(176); } protected void onUserPrepare() {} protected void onUserStart() {} protected void onUserEnd() {} } protected static abstract class WithExitAdvice extends AdviceVisitor { protected final Label returnHandler; protected WithExitAdvice(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, Assigner param1Assigner, StackManipulation param1StackManipulation, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param1ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param1ForMethodExit, List<? extends TypeDescription> param1List, int param1Int1, int param1Int2) { super(StackAwareMethodVisitor.of(param1MethodVisitor, param1MethodDescription), param1Context, param1Assigner, param1StackManipulation, param1TypeDescription, param1MethodDescription, param1ForMethodEnter, param1ForMethodExit, param1List, param1Int1, param1Int2); this.returnHandler = new Label(); } public void apply(MethodVisitor param1MethodVisitor) { if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { param1MethodVisitor.visitInsn(3); } else if (this.instrumentedMethod.getReturnType().represents(long.class)) { param1MethodVisitor.visitInsn(9); } else if (this.instrumentedMethod.getReturnType().represents(float.class)) { param1MethodVisitor.visitInsn(11); } else if (this.instrumentedMethod.getReturnType().represents(double.class)) { param1MethodVisitor.visitInsn(14); } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) { param1MethodVisitor.visitInsn(1); }  param1MethodVisitor.visitJumpInsn(167, this.returnHandler); } protected void onVisitInsn(int param1Int) { switch (param1Int) { case 177: ((StackAwareMethodVisitor)this.mv).drainStack(); break;case 172: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(54, 21, StackSize.SINGLE)); break;case 174: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(56, 23, StackSize.SINGLE)); break;case 175: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(57, 24, StackSize.DOUBLE)); break;case 173: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(55, 22, StackSize.DOUBLE)); break;case 176: this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor)this.mv).drainStack(58, 25, StackSize.SINGLE)); break;default: this.mv.visitInsn(param1Int); return; }  this.mv.visitJumpInsn(167, this.returnHandler); } protected void onUserEnd() { this.mv.visitLabel(this.returnHandler); onUserReturn(); this.stackMapFrameHandler.injectCompletionFrame(this.mv); this.methodExit.apply(); onExitAdviceReturn(); if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { this.mv.visitVarInsn(21, this.argumentHandler.returned()); this.mv.visitInsn(172); } else if (this.instrumentedMethod.getReturnType().represents(long.class)) { this.mv.visitVarInsn(22, this.argumentHandler.returned()); this.mv.visitInsn(173); } else if (this.instrumentedMethod.getReturnType().represents(float.class)) { this.mv.visitVarInsn(23, this.argumentHandler.returned()); this.mv.visitInsn(174); } else if (this.instrumentedMethod.getReturnType().represents(double.class)) { this.mv.visitVarInsn(24, this.argumentHandler.returned()); this.mv.visitInsn(175); } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) { this.mv.visitVarInsn(25, this.argumentHandler.returned()); this.mv.visitInsn(176); } else { this.mv.visitInsn(177); }  this.methodSizeHandler.requireStackSize(this.instrumentedMethod.getReturnType().getStackSize().getSize()); } protected abstract void onUserReturn(); protected abstract void onExitAdviceReturn(); protected static class WithoutExceptionHandling extends WithExitAdvice { protected WithoutExceptionHandling(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, StackManipulation param3StackManipulation, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param3ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param3ForMethodExit, int param3Int1, int param3Int2) { super(param3MethodVisitor, param3Context, param3Assigner, param3StackManipulation, param3TypeDescription, param3MethodDescription, param3ForMethodEnter, param3ForMethodExit, param3MethodDescription.getReturnType().represents(void.class) ? Collections.<TypeDescription>emptyList() : Collections.<TypeDescription>singletonList(param3MethodDescription.getReturnType().asErasure()), param3Int1, param3Int2); } protected void onUserPrepare() {} protected void onUserStart() {} protected void onUserReturn() { if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(54, this.argumentHandler.returned()); return; }  if (this.instrumentedMethod.getReturnType().represents(long.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(55, this.argumentHandler.returned()); return; }  if (this.instrumentedMethod.getReturnType().represents(float.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(56, this.argumentHandler.returned()); return; }  if (this.instrumentedMethod.getReturnType().represents(double.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(57, this.argumentHandler.returned()); return; }  if (!this.instrumentedMethod.getReturnType().represents(void.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(58, this.argumentHandler.returned()); }  } protected void onExitAdviceReturn() {} } protected static class WithExceptionHandling extends WithExitAdvice { private final TypeDescription throwable; private final Label exceptionHandler; protected final Label userStart; protected WithExceptionHandling(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, Assigner param3Assigner, StackManipulation param3StackManipulation, TypeDescription param3TypeDescription1, MethodDescription param3MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param3ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param3ForMethodExit, int param3Int1, int param3Int2, TypeDescription param3TypeDescription2) { super(param3MethodVisitor, param3Context, param3Assigner, param3StackManipulation, param3TypeDescription1, param3MethodDescription, param3ForMethodEnter, param3ForMethodExit, param3MethodDescription.getReturnType().represents(void.class) ? Collections.<TypeDescription>singletonList(TypeDescription.ForLoadedType.of(Throwable.class)) : Arrays.<TypeDescription>asList(new TypeDescription[] { param3MethodDescription.getReturnType().asErasure(), TypeDescription.ForLoadedType.of(Throwable.class) }, ), param3Int1, param3Int2); this.throwable = param3TypeDescription2; this.exceptionHandler = new Label(); this.userStart = new Label(); } protected void onUserPrepare() { this.mv.visitTryCatchBlock(this.userStart, this.returnHandler, this.exceptionHandler, this.throwable.getInternalName()); } protected void onUserStart() { this.mv.visitLabel(this.userStart); } protected void onUserReturn() { this.stackMapFrameHandler.injectReturnFrame(this.mv); if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { this.mv.visitVarInsn(54, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(long.class)) { this.mv.visitVarInsn(55, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(float.class)) { this.mv.visitVarInsn(56, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(double.class)) { this.mv.visitVarInsn(57, this.argumentHandler.returned()); } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) { this.mv.visitVarInsn(58, this.argumentHandler.returned()); }  this.mv.visitInsn(1); this.mv.visitVarInsn(58, this.argumentHandler.thrown()); Label label = new Label(); this.mv.visitJumpInsn(167, label); this.mv.visitLabel(this.exceptionHandler); this.stackMapFrameHandler.injectExceptionFrame(this.mv); this.mv.visitVarInsn(58, this.argumentHandler.thrown()); if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { this.mv.visitInsn(3); this.mv.visitVarInsn(54, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(long.class)) { this.mv.visitInsn(9); this.mv.visitVarInsn(55, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(float.class)) { this.mv.visitInsn(11); this.mv.visitVarInsn(56, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(double.class)) { this.mv.visitInsn(14); this.mv.visitVarInsn(57, this.argumentHandler.returned()); } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) { this.mv.visitInsn(1); this.mv.visitVarInsn(58, this.argumentHandler.returned()); }  this.mv.visitLabel(label); this.methodSizeHandler.requireStackSize(StackSize.SINGLE.getSize()); } protected void onExitAdviceReturn() { this.mv.visitVarInsn(25, this.argumentHandler.thrown()); Label label = new Label(); this.mv.visitJumpInsn(198, label); this.mv.visitVarInsn(25, this.argumentHandler.thrown()); this.mv.visitInsn(191); this.mv.visitLabel(label); this.stackMapFrameHandler.injectPostCompletionFrame(this.mv); } } } protected static class WithoutExceptionHandling extends AdviceVisitor.WithExitAdvice { protected WithoutExceptionHandling(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, Assigner param1Assigner, StackManipulation param1StackManipulation, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param1ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param1ForMethodExit, int param1Int1, int param1Int2) { super(param1MethodVisitor, param1Context, param1Assigner, param1StackManipulation, param1TypeDescription, param1MethodDescription, param1ForMethodEnter, param1ForMethodExit, param1MethodDescription.getReturnType().represents(void.class) ? Collections.<TypeDescription>emptyList() : Collections.<TypeDescription>singletonList(param1MethodDescription.getReturnType().asErasure()), param1Int1, param1Int2); } protected void onUserPrepare() {} protected void onUserStart() {} protected void onUserReturn() { if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(54, this.argumentHandler.returned()); return; }  if (this.instrumentedMethod.getReturnType().represents(long.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(55, this.argumentHandler.returned()); return; }  if (this.instrumentedMethod.getReturnType().represents(float.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(56, this.argumentHandler.returned()); return; }  if (this.instrumentedMethod.getReturnType().represents(double.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(57, this.argumentHandler.returned()); return; }  if (!this.instrumentedMethod.getReturnType().represents(void.class)) { this.stackMapFrameHandler.injectReturnFrame(this.mv); this.mv.visitVarInsn(58, this.argumentHandler.returned()); }  } protected void onExitAdviceReturn() {} } protected static class WithExceptionHandling extends AdviceVisitor.WithExitAdvice { private final TypeDescription throwable; private final Label exceptionHandler; protected final Label userStart; protected WithExceptionHandling(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, Assigner param1Assigner, StackManipulation param1StackManipulation, TypeDescription param1TypeDescription1, MethodDescription param1MethodDescription, Advice.Dispatcher.Resolved.ForMethodEnter param1ForMethodEnter, Advice.Dispatcher.Resolved.ForMethodExit param1ForMethodExit, int param1Int1, int param1Int2, TypeDescription param1TypeDescription2) { super(param1MethodVisitor, param1Context, param1Assigner, param1StackManipulation, param1TypeDescription1, param1MethodDescription, param1ForMethodEnter, param1ForMethodExit, param1MethodDescription.getReturnType().represents(void.class) ? Collections.<TypeDescription>singletonList(TypeDescription.ForLoadedType.of(Throwable.class)) : Arrays.<TypeDescription>asList(new TypeDescription[] { param1MethodDescription.getReturnType().asErasure(), TypeDescription.ForLoadedType.of(Throwable.class) }, ), param1Int1, param1Int2); this.throwable = param1TypeDescription2; this.exceptionHandler = new Label(); this.userStart = new Label(); } protected void onUserPrepare() { this.mv.visitTryCatchBlock(this.userStart, this.returnHandler, this.exceptionHandler, this.throwable.getInternalName()); } protected void onUserStart() { this.mv.visitLabel(this.userStart); } protected void onUserReturn() { this.stackMapFrameHandler.injectReturnFrame(this.mv); if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { this.mv.visitVarInsn(54, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(long.class)) { this.mv.visitVarInsn(55, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(float.class)) { this.mv.visitVarInsn(56, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(double.class)) { this.mv.visitVarInsn(57, this.argumentHandler.returned()); } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) { this.mv.visitVarInsn(58, this.argumentHandler.returned()); }  this.mv.visitInsn(1); this.mv.visitVarInsn(58, this.argumentHandler.thrown()); Label label = new Label(); this.mv.visitJumpInsn(167, label); this.mv.visitLabel(this.exceptionHandler); this.stackMapFrameHandler.injectExceptionFrame(this.mv); this.mv.visitVarInsn(58, this.argumentHandler.thrown()); if (this.instrumentedMethod.getReturnType().represents(boolean.class) || this.instrumentedMethod.getReturnType().represents(byte.class) || this.instrumentedMethod.getReturnType().represents(short.class) || this.instrumentedMethod.getReturnType().represents(char.class) || this.instrumentedMethod.getReturnType().represents(int.class)) { this.mv.visitInsn(3); this.mv.visitVarInsn(54, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(long.class)) { this.mv.visitInsn(9); this.mv.visitVarInsn(55, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(float.class)) { this.mv.visitInsn(11); this.mv.visitVarInsn(56, this.argumentHandler.returned()); } else if (this.instrumentedMethod.getReturnType().represents(double.class)) { this.mv.visitInsn(14); this.mv.visitVarInsn(57, this.argumentHandler.returned()); } else if (!this.instrumentedMethod.getReturnType().represents(void.class)) { this.mv.visitInsn(1); this.mv.visitVarInsn(58, this.argumentHandler.returned()); }  this.mv.visitLabel(label); this.methodSizeHandler.requireStackSize(StackSize.SINGLE.getSize()); } protected void onExitAdviceReturn() { this.mv.visitVarInsn(25, this.argumentHandler.thrown()); Label label = new Label(); this.mv.visitJumpInsn(198, label); this.mv.visitVarInsn(25, this.argumentHandler.thrown()); this.mv.visitInsn(191); this.mv.visitLabel(label); this.stackMapFrameHandler.injectPostCompletionFrame(this.mv); }
/*       */      }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Enhance
/*       */   protected static class Appender
/*       */     implements ByteCodeAppender
/*       */   {
/*       */     private final Advice advice;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final Implementation.Target implementationTarget;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final ByteCodeAppender delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Appender(Advice param1Advice, Implementation.Target param1Target, ByteCodeAppender param1ByteCodeAppender) {
/* 11254 */       this.advice = param1Advice;
/* 11255 */       this.implementationTarget = param1Target;
/* 11256 */       this.delegate = param1ByteCodeAppender;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 11263 */       EmulatingMethodVisitor emulatingMethodVisitor = new EmulatingMethodVisitor(param1MethodVisitor, this.delegate);
/* 11264 */       param1MethodVisitor = this.advice.doWrap(this.implementationTarget.getInstrumentedType(), param1MethodDescription, emulatingMethodVisitor, param1Context, 0, 0);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/* 11270 */       return emulatingMethodVisitor.resolve(param1MethodVisitor, param1Context, param1MethodDescription);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean equals(@MaybeNull Object param1Object) {
/*       */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.advice.equals(((Appender)param1Object).advice) ? false : (!this.implementationTarget.equals(((Appender)param1Object).implementationTarget) ? false : (!!this.delegate.equals(((Appender)param1Object).delegate))))));
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int hashCode() {
/*       */       return ((getClass().hashCode() * 31 + this.advice.hashCode()) * 31 + this.implementationTarget.hashCode()) * 31 + this.delegate.hashCode();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected static class EmulatingMethodVisitor
/*       */       extends MethodVisitor
/*       */     {
/*       */       private final ByteCodeAppender delegate;
/*       */ 
/*       */       
/*       */       private int stackSize;
/*       */ 
/*       */       
/*       */       private int localVariableLength;
/*       */ 
/*       */ 
/*       */       
/*       */       protected EmulatingMethodVisitor(MethodVisitor param2MethodVisitor, ByteCodeAppender param2ByteCodeAppender) {
/* 11301 */         super(OpenedClassReader.ASM_API, param2MethodVisitor);
/* 11302 */         this.delegate = param2ByteCodeAppender;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ByteCodeAppender.Size resolve(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 11316 */         param2MethodVisitor.visitCode();
/* 11317 */         ByteCodeAppender.Size size = this.delegate.apply(param2MethodVisitor, param2Context, param2MethodDescription);
/* 11318 */         param2MethodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
/* 11319 */         param2MethodVisitor.visitEnd();
/* 11320 */         return new ByteCodeAppender.Size(this.stackSize, this.localVariableLength);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public void visitCode() {}
/*       */ 
/*       */ 
/*       */       
/*       */       public void visitMaxs(int param2Int1, int param2Int2) {
/* 11330 */         this.stackSize = param2Int1;
/* 11331 */         this.localVariableLength = param2Int2;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void visitEnd() {}
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Enhance
/*       */   public static abstract class AssignReturned
/*       */     implements PostProcessor
/*       */   {
/*       */     public static final int NO_INDEX = -1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final TypeDescription.Generic type;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final ExceptionHandler.Factory exceptionHandlerFactory;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final boolean exit;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected final boolean skipOnDefaultValue;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected AssignReturned(TypeDescription.Generic param1Generic, ExceptionHandler.Factory param1Factory, boolean param1Boolean1, boolean param1Boolean2) {
/* 12063 */       this.type = param1Generic;
/* 12064 */       this.exceptionHandlerFactory = param1Factory;
/* 12065 */       this.exit = param1Boolean1;
/* 12066 */       this.skipOnDefaultValue = param1Boolean2;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public StackManipulation resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, Assigner param1Assigner, Advice.ArgumentHandler param1ArgumentHandler, Advice.StackMapFrameHandler.ForPostProcessor param1ForPostProcessor, StackManipulation param1StackManipulation) {
/* 12078 */       ArrayList<StackManipulation> arrayList = new ArrayList(getHandlers().size());
/* 12079 */       for (Handler handler : getHandlers()) {
/* 12080 */         arrayList.add(handler.resolve(param1TypeDescription, param1MethodDescription, param1Assigner, param1ArgumentHandler, 
/*       */ 
/*       */ 
/*       */               
/* 12084 */               getType(), 
/* 12085 */               toLoadInstruction(handler, this.exit ? param1ArgumentHandler.exit() : param1ArgumentHandler.enter())));
/*       */       }
/* 12087 */       StackManipulation stackManipulation = this.exceptionHandlerFactory.wrap((StackManipulation)new StackManipulation.Compound(arrayList), param1StackManipulation, param1ForPostProcessor);
/*       */ 
/*       */       
/* 12090 */       if (this.skipOnDefaultValue)
/* 12091 */         return DefaultValueSkip.of(stackManipulation, param1ForPostProcessor, this.exit ? param1ArgumentHandler.exit() : param1ArgumentHandler.enter(), (TypeDefinition)this.type);  return stackManipulation;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract TypeDescription.Generic getType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract Collection<Handler> getHandlers();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract StackManipulation toLoadInstruction(Handler param1Handler, int param1Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean equals(@MaybeNull Object param1Object) {
/*       */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.exit != ((AssignReturned)param1Object).exit) ? false : ((this.skipOnDefaultValue != ((AssignReturned)param1Object).skipOnDefaultValue) ? false : (!this.type.equals(((AssignReturned)param1Object).type) ? false : (!!this.exceptionHandlerFactory.equals(((AssignReturned)param1Object).exceptionHandlerFactory)))))));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int hashCode() {
/*       */       return (((getClass().hashCode() * 31 + this.type.hashCode()) * 31 + this.exceptionHandlerFactory.hashCode()) * 31 + this.exit) * 31 + this.skipOnDefaultValue;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Documented
/*       */     @Retention(RetentionPolicy.RUNTIME)
/*       */     @Target({ElementType.METHOD})
/*       */     public static @interface ToArguments
/*       */     {
/*       */       ToArgument[] value();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Handler
/*       */         implements Advice.AssignReturned.Handler
/*       */       {
/*       */         private final int value;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Handler(int param3Int1, int param3Int2, Assigner.Typing param3Typing) {
/* 12218 */           this.value = param3Int1;
/* 12219 */           this.index = param3Int2;
/* 12220 */           this.typing = param3Typing;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int getIndex() {
/* 12227 */           return this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public StackManipulation resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Advice.ArgumentHandler param3ArgumentHandler, TypeDescription.Generic param3Generic, StackManipulation param3StackManipulation) {
/* 12239 */           if (param3MethodDescription.getParameters().size() < this.value) {
/* 12240 */             throw new IllegalStateException(param3MethodDescription + " declares less then " + this.value + " parameters");
/*       */           }
/*       */           
/*       */           StackManipulation stackManipulation;
/*       */           
/* 12245 */           if (!(stackManipulation = param3Assigner.assign(param3Generic, ((ParameterDescription)param3MethodDescription.getParameters().get(this.value)).getType(), this.typing)).isValid()) {
/* 12246 */             throw new IllegalStateException("Cannot assign " + param3Generic + " to " + ((ParameterDescription)param3MethodDescription.getParameters().get(this.value)).getType());
/*       */           }
/* 12248 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param3StackManipulation, stackManipulation, 
/*       */                 
/* 12250 */                 MethodVariableAccess.of((TypeDefinition)((ParameterDescription)param3MethodDescription.getParameters().get(this.value)).getType())
/* 12251 */                 .storeAt(param3ArgumentHandler.argument(((ParameterDescription)param3MethodDescription.getParameters().get(this.value)).getOffset())) });
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.value != ((Handler)param3Object).value) ? false : ((this.index != ((Handler)param3Object).index) ? false : (!!this.typing.equals(((Handler)param3Object).typing))))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.value) * 31 + this.index) * 31 + this.typing.hashCode();
/*       */         }
/*       */         
/* 12262 */         public enum Factory implements Advice.AssignReturned.Handler.Factory<Advice.AssignReturned.ToArguments> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_ARGUMENT_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_ARGUMENT_INDEX;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_ARGUMENT_VALUE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 12288 */           private static final MethodDescription.InDefinedShape TO_ARGUMENTS_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToArguments.class)
/* 12289 */             .getDeclaredMethods()
/* 12290 */             .filter((ElementMatcher)ElementMatchers.named("value")))
/* 12291 */             .getOnly(); static {
/*       */             MethodList methodList;
/* 12293 */             TO_ARGUMENT_VALUE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToArguments.ToArgument.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/* 12294 */             TO_ARGUMENT_INDEX = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("index"))).getOnly();
/* 12295 */             TO_ARGUMENT_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.AssignReturned.ToArguments> getAnnotationType() {
/* 12302 */             return Advice.AssignReturned.ToArguments.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param4InDefinedShape, boolean param4Boolean, AnnotationDescription.Loadable<? extends Advice.AssignReturned.ToArguments> param4Loadable) {
/* 12311 */             ArrayList<Advice.AssignReturned.ToArguments.Handler> arrayList = new ArrayList(); AnnotationDescription[] arrayOfAnnotationDescription; int i; byte b;
/* 12312 */             for (i = (arrayOfAnnotationDescription = (AnnotationDescription[])param4Loadable.getValue(TO_ARGUMENTS_VALUE).resolve(AnnotationDescription[].class)).length, b = 0; b < i; b++) {
/*       */               AnnotationDescription annotationDescription; int j;
/* 12314 */               if ((j = ((Integer)(annotationDescription = arrayOfAnnotationDescription[b]).getValue(TO_ARGUMENT_VALUE).resolve(Integer.class)).intValue()) < 0) {
/* 12315 */                 throw new IllegalStateException("An argument cannot have a negative index for " + param4InDefinedShape);
/*       */               }
/* 12317 */               arrayList.add(new Advice.AssignReturned.ToArguments.Handler(j, ((Integer)annotationDescription
/* 12318 */                     .getValue(TO_ARGUMENT_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing)annotationDescription
/* 12319 */                     .getValue(TO_ARGUMENT_TYPING).load(Advice.AssignReturned.ToArguments.class.getClassLoader()).resolve(Assigner.Typing.class)));
/*       */             } 
/* 12321 */             return (List)arrayList;
/*       */           } }
/*       */       
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Target({})
/*       */       @Enhance(ToArguments.class)
/*       */       @Repeatable(ToArguments.class)
/*       */       public static @interface ToArgument
/*       */       {
/*       */         int value();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         int index() default -1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Documented
/*       */     @Retention(RetentionPolicy.RUNTIME)
/*       */     @Target({ElementType.METHOD})
/*       */     public static @interface ToAllArguments
/*       */     {
/*       */       int index() default -1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Handler
/*       */         implements Advice.AssignReturned.Handler
/*       */       {
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */         
/*       */         private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Handler(int param3Int, Assigner.Typing param3Typing) {
/* 12385 */           this.index = param3Int;
/* 12386 */           this.typing = param3Typing;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int getIndex() {
/* 12393 */           return this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public StackManipulation resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Advice.ArgumentHandler param3ArgumentHandler, TypeDescription.Generic param3Generic, StackManipulation param3StackManipulation) {
/*       */           StackManipulation.Compound compound;
/* 12406 */           ArrayList<StackManipulation.Compound> arrayList = new ArrayList(param3MethodDescription.getParameters().size());
/* 12407 */           if (!param3Generic.isArray()) {
/*       */             StackManipulation stackManipulation;
/* 12409 */             if (!(stackManipulation = param3Assigner.assign(param3Generic, TypeDefinition.Sort.describe(Object[].class), this.typing)).isValid()) {
/* 12410 */               throw new IllegalStateException("Cannot assign " + param3Generic + " to " + Object[].class);
/*       */             }
/* 12412 */             param3Generic = TypeDefinition.Sort.describe(Object[].class);
/* 12413 */             compound = new StackManipulation.Compound(new StackManipulation[] { param3StackManipulation, stackManipulation });
/*       */           } 
/* 12415 */           for (ParameterDescription parameterDescription : param3MethodDescription.getParameters()) {
/*       */             StackManipulation stackManipulation;
/* 12417 */             if (!(stackManipulation = param3Assigner.assign(param3Generic.getComponentType(), parameterDescription.getType(), this.typing)).isValid()) {
/* 12418 */               throw new IllegalStateException("Cannot assign " + param3Generic.getComponentType() + " to " + parameterDescription);
/*       */             }
/* 12420 */             arrayList.add(new StackManipulation.Compound(new StackManipulation[] { stackManipulation, MethodVariableAccess.of((TypeDefinition)parameterDescription.getType())
/* 12421 */                     .storeAt(param3ArgumentHandler.argument(parameterDescription.getOffset())) }));
/*       */           } 
/* 12423 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { (StackManipulation)compound, ArrayAccess.of((TypeDefinition)param3Generic.getComponentType()).forEach(arrayList), (StackManipulation)Removal.SINGLE });
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((Handler)param3Object).index) ? false : (!!this.typing.equals(((Handler)param3Object).typing)))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.index) * 31 + this.typing.hashCode();
/*       */         }
/*       */         
/* 12434 */         public enum Factory implements Advice.AssignReturned.Handler.Factory<Advice.AssignReturned.ToAllArguments> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_INDEX;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           static {
/*       */             MethodList methodList;
/* 12451 */             TO_ALL_ARGUMENTS_INDEX = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToAllArguments.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("index"))).getOnly();
/* 12452 */             TO_ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.AssignReturned.ToAllArguments> getAnnotationType() {
/* 12459 */             return Advice.AssignReturned.ToAllArguments.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param4InDefinedShape, boolean param4Boolean, AnnotationDescription.Loadable<? extends Advice.AssignReturned.ToAllArguments> param4Loadable) {
/* 12468 */             return Collections.singletonList(new Advice.AssignReturned.ToAllArguments.Handler(((Integer)param4Loadable.getValue(TO_ALL_ARGUMENTS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing)param4Loadable
/* 12469 */                   .getValue(TO_ALL_ARGUMENTS_TYPING).load(Advice.AssignReturned.ToAllArguments.class.getClassLoader()).resolve(Assigner.Typing.class)));
/*       */           } }
/*       */       
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Documented
/*       */     @Retention(RetentionPolicy.RUNTIME)
/*       */     @Target({ElementType.METHOD})
/*       */     public static @interface ToThis
/*       */     {
/*       */       int index() default -1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Handler
/*       */         implements Advice.AssignReturned.Handler
/*       */       {
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean exit;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Handler(int param3Int, Assigner.Typing param3Typing, boolean param3Boolean) {
/* 12534 */           this.index = param3Int;
/* 12535 */           this.typing = param3Typing;
/* 12536 */           this.exit = param3Boolean;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int getIndex() {
/* 12543 */           return this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public StackManipulation resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Advice.ArgumentHandler param3ArgumentHandler, TypeDescription.Generic param3Generic, StackManipulation param3StackManipulation) {
/* 12555 */           if (param3MethodDescription.isStatic())
/* 12556 */             throw new IllegalStateException("Cannot assign this reference for static method " + param3MethodDescription); 
/* 12557 */           if (!this.exit && param3MethodDescription.isConstructor()) {
/* 12558 */             throw new IllegalStateException("Cannot assign this reference in constructor prior to initialization for " + param3MethodDescription);
/*       */           }
/*       */           
/*       */           StackManipulation stackManipulation;
/*       */           
/* 12563 */           if (!(stackManipulation = param3Assigner.assign(param3Generic, param3TypeDescription.asGenericType(), this.typing)).isValid()) {
/* 12564 */             throw new IllegalStateException("Cannot assign " + param3Generic + " to " + param3TypeDescription);
/*       */           }
/* 12566 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param3StackManipulation, stackManipulation, MethodVariableAccess.REFERENCE
/*       */                 
/* 12568 */                 .storeAt(param3ArgumentHandler.argument(0)) });
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((Handler)param3Object).index) ? false : ((this.exit != ((Handler)param3Object).exit) ? false : (!!this.typing.equals(((Handler)param3Object).typing))))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.index) * 31 + this.typing.hashCode()) * 31 + this.exit;
/*       */         }
/*       */         
/*       */         public enum Factory implements Advice.AssignReturned.Handler.Factory<Advice.AssignReturned.ToThis> {
/* 12580 */           INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_THIS_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_THIS_INDEX;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           static {
/*       */             MethodList methodList;
/* 12597 */             TO_THIS_INDEX = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToThis.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("index"))).getOnly();
/* 12598 */             TO_THIS_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.AssignReturned.ToThis> getAnnotationType() {
/* 12605 */             return Advice.AssignReturned.ToThis.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param4InDefinedShape, boolean param4Boolean, AnnotationDescription.Loadable<? extends Advice.AssignReturned.ToThis> param4Loadable) {
/* 12614 */             return Collections.singletonList(new Advice.AssignReturned.ToThis.Handler(((Integer)param4Loadable.getValue(TO_THIS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing)param4Loadable
/* 12615 */                   .getValue(TO_THIS_TYPING).load(Advice.AssignReturned.ToThis.class.getClassLoader()).resolve(Assigner.Typing.class), param4Boolean));
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Documented
/*       */     @Retention(RetentionPolicy.RUNTIME)
/*       */     @Target({ElementType.METHOD})
/*       */     public static @interface ToFields
/*       */     {
/*       */       ToField[] value();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Handler
/*       */         implements Advice.AssignReturned.Handler
/*       */       {
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final String name;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription declaringType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Handler(int param3Int, String param3String, TypeDescription param3TypeDescription, Assigner.Typing param3Typing) {
/* 12727 */           this.index = param3Int;
/* 12728 */           this.name = param3String;
/* 12729 */           this.declaringType = param3TypeDescription;
/* 12730 */           this.typing = param3Typing;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int getIndex() {
/* 12737 */           return this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public StackManipulation resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Advice.ArgumentHandler param3ArgumentHandler, TypeDescription.Generic param3Generic, StackManipulation param3StackManipulation) {
/*       */           StackManipulation.Trivial trivial;
/*       */           StackManipulation stackManipulation1;
/* 12750 */           param3ArgumentHandler = this.declaringType.represents(void.class) ? (Advice.ArgumentHandler)new FieldLocator.ForClassHierarchy(param3TypeDescription) : (Advice.ArgumentHandler)new FieldLocator.ForExactType(this.declaringType);
/*       */ 
/*       */ 
/*       */           
/*       */           FieldLocator.Resolution resolution;
/*       */ 
/*       */           
/* 12757 */           if (!(resolution = this.name.equals("") ? Advice.OffsetMapping.ForField.Unresolved.a((FieldLocator)param3ArgumentHandler, param3MethodDescription) : param3ArgumentHandler.locate(this.name)).isResolved())
/* 12758 */             throw new IllegalStateException("Cannot resolve field " + this.name + " for " + param3TypeDescription); 
/* 12759 */           if (!resolution.getField().isVisibleTo(param3TypeDescription))
/* 12760 */             throw new IllegalStateException(resolution.getField() + " is not visible to " + param3TypeDescription); 
/* 12761 */           if (resolution.getField().isStatic())
/* 12762 */           { trivial = StackManipulation.Trivial.INSTANCE; }
/* 12763 */           else { if (param3MethodDescription.isStatic())
/* 12764 */               throw new IllegalStateException("Cannot access member field " + resolution.getField() + " from static " + param3MethodDescription); 
/* 12765 */             if (!trivial.isAssignableTo(resolution.getField().getDeclaringType().asErasure())) {
/* 12766 */               throw new IllegalStateException(trivial + " does not define " + resolution.getField());
/*       */             }
/* 12768 */             stackManipulation1 = MethodVariableAccess.loadThis(); }
/*       */ 
/*       */           
/*       */           StackManipulation stackManipulation2;
/*       */           
/* 12773 */           if (!(stackManipulation2 = param3Assigner.assign(param3Generic, resolution.getField().getType(), this.typing)).isValid()) {
/* 12774 */             throw new IllegalStateException("Cannot assign " + param3Generic + " to " + resolution.getField());
/*       */           }
/* 12776 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { stackManipulation1, param3StackManipulation, stackManipulation2, 
/*       */ 
/*       */                 
/* 12779 */                 FieldAccess.forField(resolution.getField()).write() });
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((Handler)param3Object).index) ? false : (!this.typing.equals(((Handler)param3Object).typing) ? false : (!this.name.equals(((Handler)param3Object).name) ? false : (!!this.declaringType.equals(((Handler)param3Object).declaringType)))))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return (((getClass().hashCode() * 31 + this.index) * 31 + this.name.hashCode()) * 31 + this.declaringType.hashCode()) * 31 + this.typing.hashCode();
/*       */         }
/*       */         
/* 12790 */         public enum Factory implements Advice.AssignReturned.Handler.Factory<Advice.AssignReturned.ToFields> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_FIELD_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_FIELD_DECLARING_TYPE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_FIELD_INDEX;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_FIELD_VALUE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 12821 */           private static final MethodDescription.InDefinedShape TO_FIELDS_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToFields.class)
/* 12822 */             .getDeclaredMethods()
/* 12823 */             .filter((ElementMatcher)ElementMatchers.named("value")))
/* 12824 */             .getOnly(); static {
/*       */             MethodList methodList;
/* 12826 */             TO_FIELD_VALUE = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToFields.ToField.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("value"))).getOnly();
/* 12827 */             TO_FIELD_INDEX = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("index"))).getOnly();
/* 12828 */             TO_FIELD_DECLARING_TYPE = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("declaringType"))).getOnly();
/* 12829 */             TO_FIELD_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.AssignReturned.ToFields> getAnnotationType() {
/* 12836 */             return Advice.AssignReturned.ToFields.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param4InDefinedShape, boolean param4Boolean, AnnotationDescription.Loadable<? extends Advice.AssignReturned.ToFields> param4Loadable) {
/* 12845 */             ArrayList<Advice.AssignReturned.ToFields.Handler> arrayList = new ArrayList(); AnnotationDescription[] arrayOfAnnotationDescription; int i; byte b;
/* 12846 */             for (i = (arrayOfAnnotationDescription = (AnnotationDescription[])param4Loadable.getValue(TO_FIELDS_VALUE).resolve(AnnotationDescription[].class)).length, b = 0; b < i; ) { AnnotationDescription annotationDescription = arrayOfAnnotationDescription[b];
/* 12847 */               arrayList.add(new Advice.AssignReturned.ToFields.Handler(((Integer)annotationDescription.getValue(TO_FIELD_INDEX).resolve(Integer.class)).intValue(), (String)annotationDescription
/* 12848 */                     .getValue(TO_FIELD_VALUE).resolve(String.class), (TypeDescription)annotationDescription
/* 12849 */                     .getValue(TO_FIELD_DECLARING_TYPE).resolve(TypeDescription.class), (Assigner.Typing)annotationDescription
/* 12850 */                     .getValue(TO_FIELD_TYPING).load(Advice.AssignReturned.ToFields.class.getClassLoader()).resolve(Assigner.Typing.class))); b++; }
/*       */             
/* 12852 */             return (List)arrayList;
/*       */           } }
/*       */       
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Target({})
/*       */       @Enhance(ToFields.class)
/*       */       @Repeatable(ToFields.class)
/*       */       public static @interface ToField
/*       */       {
/*       */         String value() default "";
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         Class<?> declaringType() default void.class;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         int index() default -1;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Documented
/*       */     @Retention(RetentionPolicy.RUNTIME)
/*       */     @Target({ElementType.METHOD})
/*       */     public static @interface ToReturned
/*       */     {
/*       */       int index() default -1;
/*       */ 
/*       */ 
/*       */       
/*       */       Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Handler
/*       */         implements Advice.AssignReturned.Handler
/*       */       {
/*       */         private final int index;
/*       */ 
/*       */         
/*       */         private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */         
/*       */         protected Handler(int param3Int, Assigner.Typing param3Typing) {
/* 12912 */           this.index = param3Int;
/* 12913 */           this.typing = param3Typing;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int getIndex() {
/* 12920 */           return this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public StackManipulation resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Advice.ArgumentHandler param3ArgumentHandler, TypeDescription.Generic param3Generic, StackManipulation param3StackManipulation) {
/* 12932 */           if (param3MethodDescription.getReturnType().represents(void.class)) {
/* 12933 */             return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*       */           }
/*       */           StackManipulation stackManipulation;
/* 12936 */           if (!(stackManipulation = param3Assigner.assign(param3Generic, param3MethodDescription.getReturnType(), this.typing)).isValid()) {
/* 12937 */             throw new IllegalStateException("Cannot assign " + param3Generic + " to " + param3MethodDescription.getReturnType());
/*       */           }
/* 12939 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param3StackManipulation, stackManipulation, 
/*       */                 
/* 12941 */                 MethodVariableAccess.of((TypeDefinition)param3MethodDescription.getReturnType()).storeAt(param3ArgumentHandler.returned()) });
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((Handler)param3Object).index) ? false : (!!this.typing.equals(((Handler)param3Object).typing)))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.index) * 31 + this.typing.hashCode();
/*       */         }
/*       */         
/* 12952 */         public enum Factory implements Advice.AssignReturned.Handler.Factory<Advice.AssignReturned.ToReturned> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_RETURNED_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_RETURNED_INDEX;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           static {
/*       */             MethodList methodList;
/* 12969 */             TO_RETURNED_INDEX = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToReturned.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("index"))).getOnly();
/* 12970 */             TO_RETURNED_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.AssignReturned.ToReturned> getAnnotationType() {
/* 12977 */             return Advice.AssignReturned.ToReturned.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param4InDefinedShape, boolean param4Boolean, AnnotationDescription.Loadable<? extends Advice.AssignReturned.ToReturned> param4Loadable) {
/* 12986 */             if (!param4Boolean) {
/* 12987 */               throw new IllegalStateException("Cannot write returned value from enter advice " + param4InDefinedShape);
/*       */             }
/* 12989 */             return Collections.singletonList(new Advice.AssignReturned.ToReturned.Handler(((Integer)param4Loadable.getValue(TO_RETURNED_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing)param4Loadable
/* 12990 */                   .getValue(TO_RETURNED_TYPING).load(Advice.AssignReturned.ToReturned.class.getClassLoader()).resolve(Assigner.Typing.class)));
/*       */           } }
/*       */       
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Documented
/*       */     @Retention(RetentionPolicy.RUNTIME)
/*       */     @Target({ElementType.METHOD})
/*       */     public static @interface ToThrown
/*       */     {
/*       */       int index() default -1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Handler
/*       */         implements Advice.AssignReturned.Handler
/*       */       {
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Assigner.Typing typing;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Handler(int param3Int, Assigner.Typing param3Typing) {
/* 13050 */           this.index = param3Int;
/* 13051 */           this.typing = param3Typing;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int getIndex() {
/* 13058 */           return this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public StackManipulation resolve(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Assigner param3Assigner, Advice.ArgumentHandler param3ArgumentHandler, TypeDescription.Generic param3Generic, StackManipulation param3StackManipulation) {
/* 13070 */           if (param3MethodDescription.getReturnType().represents(void.class)) {
/* 13071 */             return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*       */           }
/*       */           StackManipulation stackManipulation;
/* 13074 */           if (!(stackManipulation = param3Assigner.assign(param3Generic, TypeDefinition.Sort.describe(Throwable.class), this.typing)).isValid()) {
/* 13075 */             throw new IllegalStateException("Cannot assign " + param3Generic + " to " + Throwable.class.getName());
/*       */           }
/* 13077 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param3StackManipulation, stackManipulation, MethodVariableAccess.REFERENCE
/*       */                 
/* 13079 */                 .storeAt(param3ArgumentHandler.thrown()) });
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.index != ((Handler)param3Object).index) ? false : (!!this.typing.equals(((Handler)param3Object).typing)))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.index) * 31 + this.typing.hashCode();
/*       */         }
/*       */         
/* 13090 */         public enum Factory implements Advice.AssignReturned.Handler.Factory<Advice.AssignReturned.ToThrown> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_THROWN_TYPING;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final MethodDescription.InDefinedShape TO_THROWN_INDEX;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           static {
/*       */             MethodList methodList;
/* 13107 */             TO_THROWN_INDEX = (MethodDescription.InDefinedShape)((MethodList)(methodList = TypeDescription.ForLoadedType.of(Advice.AssignReturned.ToThrown.class).getDeclaredMethods()).filter((ElementMatcher)ElementMatchers.named("index"))).getOnly();
/* 13108 */             TO_THROWN_TYPING = (MethodDescription.InDefinedShape)((MethodList)methodList.filter((ElementMatcher)ElementMatchers.named("typing"))).getOnly();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Class<Advice.AssignReturned.ToThrown> getAnnotationType() {
/* 13115 */             return Advice.AssignReturned.ToThrown.class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming annotation for exit advice.")
/*       */           public final List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param4InDefinedShape, boolean param4Boolean, AnnotationDescription.Loadable<? extends Advice.AssignReturned.ToThrown> param4Loadable) {
/* 13125 */             if (!param4Boolean)
/* 13126 */               throw new IllegalStateException("Cannot assign thrown value from enter advice " + param4InDefinedShape); 
/* 13127 */             if (((TypeDescription)param4InDefinedShape.getDeclaredAnnotations().ofType(Advice.OnMethodExit.class).getValue(Advice.a()).resolve(TypeDescription.class)).represents(Advice.NoExceptionHandler.class)) {
/* 13128 */               throw new IllegalStateException("Cannot assign thrown value for non-catching exit advice " + param4InDefinedShape);
/*       */             }
/* 13130 */             return Collections.singletonList(new Advice.AssignReturned.ToThrown.Handler(((Integer)param4Loadable.getValue(TO_THROWN_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing)param4Loadable
/* 13131 */                   .getValue(TO_THROWN_TYPING).load(Advice.AssignReturned.ToThrown.class.getClassLoader()).resolve(Assigner.Typing.class)));
/*       */           } }
/*       */       
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     protected static class ForArray
/*       */       extends AssignReturned
/*       */     {
/*       */       private final Map<Advice.AssignReturned.Handler, Integer> handlers;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForArray(TypeDescription.Generic param2Generic, Advice.AssignReturned.ExceptionHandler.Factory param2Factory, boolean param2Boolean, Collection<List<Advice.AssignReturned.Handler>> param2Collection) {
/* 13160 */         super(param2Generic, param2Factory, param2Boolean, true);
/* 13161 */         this.handlers = new LinkedHashMap<Advice.AssignReturned.Handler, Integer>();
/* 13162 */         for (Iterator<List<Advice.AssignReturned.Handler>> iterator = param2Collection.iterator(); iterator.hasNext();) {
/* 13163 */           for (Iterator<?> iterator1 = (list = iterator.next()).iterator(); iterator1.hasNext(); ) {
/*       */             Advice.AssignReturned.Handler handler; int i;
/* 13165 */             if ((i = (handler = (Advice.AssignReturned.Handler)iterator1.next()).getIndex()) < 0) {
/* 13166 */               throw new IllegalStateException("Handler on array requires positive index for " + handler);
/*       */             }
/* 13168 */             this.handlers.put(handler, Integer.valueOf(i));
/*       */           } 
/*       */         } 
/*       */       }
/*       */ 
/*       */       
/*       */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */       protected TypeDescription.Generic getType() {
/* 13176 */         return this.type.getComponentType();
/*       */       }
/*       */ 
/*       */       
/*       */       protected Collection<Advice.AssignReturned.Handler> getHandlers() {
/* 13181 */         return this.handlers.keySet();
/*       */       }
/*       */ 
/*       */       
/*       */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */       protected StackManipulation toLoadInstruction(Advice.AssignReturned.Handler param2Handler, int param2Int) {
/* 13187 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.REFERENCE.loadFrom(param2Int), 
/* 13188 */               IntegerConstant.forValue(((Integer)this.handlers.get(param2Handler)).intValue()), 
/* 13189 */               ArrayAccess.of((TypeDefinition)this.type.getComponentType()).load() });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.handlers.equals(((ForArray)param2Object).handlers)))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return super.hashCode() * 31 + this.handlers.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     protected static class ForScalar
/*       */       extends AssignReturned
/*       */     {
/*       */       private final List<Advice.AssignReturned.Handler> handlers;
/*       */ 
/*       */ 
/*       */       
/*       */       protected ForScalar(TypeDescription.Generic param2Generic, Advice.AssignReturned.ExceptionHandler.Factory param2Factory, boolean param2Boolean1, boolean param2Boolean2, Collection<List<Advice.AssignReturned.Handler>> param2Collection) {
/* 13218 */         super(param2Generic, param2Factory, param2Boolean1, param2Boolean2);
/* 13219 */         this.handlers = new ArrayList<Advice.AssignReturned.Handler>();
/* 13220 */         for (Iterator<List<Advice.AssignReturned.Handler>> iterator = param2Collection.iterator(); iterator.hasNext();) {
/* 13221 */           for (Iterator<?> iterator1 = (list = iterator.next()).iterator(); iterator1.hasNext(); ) {
/*       */             Advice.AssignReturned.Handler handler; int i;
/* 13223 */             if ((i = (handler = (Advice.AssignReturned.Handler)iterator1.next()).getIndex()) >= 0) {
/* 13224 */               throw new IllegalStateException("Handler on array requires negative index for " + handler);
/*       */             }
/* 13226 */             this.handlers.add(handler);
/*       */           } 
/*       */         } 
/*       */       }
/*       */ 
/*       */       
/*       */       protected TypeDescription.Generic getType() {
/* 13233 */         return this.type;
/*       */       }
/*       */ 
/*       */       
/*       */       protected Collection<Advice.AssignReturned.Handler> getHandlers() {
/* 13238 */         return this.handlers;
/*       */       }
/*       */ 
/*       */       
/*       */       protected StackManipulation toLoadInstruction(Advice.AssignReturned.Handler param2Handler, int param2Int) {
/* 13243 */         return MethodVariableAccess.of((TypeDefinition)this.type).loadFrom(param2Int);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.handlers.equals(((ForScalar)param2Object).handlers)))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return super.hashCode() * 31 + this.handlers.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     protected static class DefaultValueSkip
/*       */       implements StackManipulation
/*       */     {
/*       */       private final StackManipulation stackManipulation;
/*       */ 
/*       */ 
/*       */       
/*       */       private final Advice.StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;
/*       */ 
/*       */ 
/*       */       
/*       */       private final int offset;
/*       */ 
/*       */ 
/*       */       
/*       */       private final Dispatcher dispatcher;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected DefaultValueSkip(StackManipulation param2StackManipulation, Advice.StackMapFrameHandler.ForPostProcessor param2ForPostProcessor, int param2Int, Dispatcher param2Dispatcher) {
/* 13286 */         this.stackManipulation = param2StackManipulation;
/* 13287 */         this.stackMapFrameHandler = param2ForPostProcessor;
/* 13288 */         this.offset = param2Int;
/* 13289 */         this.dispatcher = param2Dispatcher;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static StackManipulation of(StackManipulation param2StackManipulation, Advice.StackMapFrameHandler.ForPostProcessor param2ForPostProcessor, int param2Int, TypeDefinition param2TypeDefinition) {
/*       */         Dispatcher dispatcher;
/* 13306 */         if (param2TypeDefinition.isPrimitive()) {
/* 13307 */           if (param2TypeDefinition.represents(boolean.class) || param2TypeDefinition
/* 13308 */             .represents(byte.class) || param2TypeDefinition
/* 13309 */             .represents(short.class) || param2TypeDefinition
/* 13310 */             .represents(char.class) || param2TypeDefinition
/* 13311 */             .represents(int.class)) {
/* 13312 */             dispatcher = Dispatcher.INTEGER;
/* 13313 */           } else if (dispatcher.represents(long.class)) {
/* 13314 */             dispatcher = Dispatcher.LONG;
/* 13315 */           } else if (dispatcher.represents(float.class)) {
/* 13316 */             dispatcher = Dispatcher.FLOAT;
/* 13317 */           } else if (dispatcher.represents(double.class)) {
/* 13318 */             dispatcher = Dispatcher.DOUBLE;
/*       */           } else {
/* 13320 */             throw new IllegalArgumentException("Cannot apply skip for " + dispatcher);
/*       */           } 
/*       */         } else {
/* 13323 */           dispatcher = Dispatcher.REFERENCE;
/*       */         } 
/* 13325 */         return new DefaultValueSkip(param2StackManipulation, param2ForPostProcessor, param2Int, dispatcher);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isValid() {
/* 13332 */         return this.stackManipulation.isValid();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 13339 */         Label label = new Label();
/* 13340 */         StackManipulation.Size size = this.dispatcher.apply(param2MethodVisitor, this.offset, label).aggregate(this.stackManipulation.apply(param2MethodVisitor, param2Context));
/* 13341 */         param2MethodVisitor.visitLabel(label);
/* 13342 */         this.stackMapFrameHandler.injectIntermediateFrame(param2MethodVisitor, Collections.emptyList());
/* 13343 */         param2MethodVisitor.visitInsn(0);
/* 13344 */         return size;
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.offset != ((DefaultValueSkip)param2Object).offset) ? false : (!this.dispatcher.equals(((DefaultValueSkip)param2Object).dispatcher) ? false : (!this.stackManipulation.equals(((DefaultValueSkip)param2Object).stackManipulation) ? false : (!!this.stackMapFrameHandler.equals(((DefaultValueSkip)param2Object).stackMapFrameHandler)))))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.stackMapFrameHandler.hashCode()) * 31 + this.offset) * 31 + this.dispatcher.hashCode();
/*       */       }
/*       */       
/* 13355 */       protected enum Dispatcher { INTEGER
/*       */         {
/*       */           protected final StackManipulation.Size apply(MethodVisitor param4MethodVisitor, int param4Int, Label param4Label) {
/* 13358 */             param4MethodVisitor.visitVarInsn(21, param4Int);
/* 13359 */             param4MethodVisitor.visitJumpInsn(153, param4Label);
/* 13360 */             return new StackManipulation.Size(0, 1);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 13367 */         LONG
/*       */         {
/*       */           protected final StackManipulation.Size apply(MethodVisitor param4MethodVisitor, int param4Int, Label param4Label) {
/* 13370 */             param4MethodVisitor.visitVarInsn(22, param4Int);
/* 13371 */             param4MethodVisitor.visitInsn(9);
/* 13372 */             param4MethodVisitor.visitInsn(148);
/* 13373 */             param4MethodVisitor.visitJumpInsn(153, param4Label);
/* 13374 */             return new StackManipulation.Size(0, 4);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 13381 */         FLOAT
/*       */         {
/*       */           protected final StackManipulation.Size apply(MethodVisitor param4MethodVisitor, int param4Int, Label param4Label) {
/* 13384 */             param4MethodVisitor.visitVarInsn(23, param4Int);
/* 13385 */             param4MethodVisitor.visitInsn(11);
/* 13386 */             param4MethodVisitor.visitInsn(149);
/* 13387 */             param4MethodVisitor.visitJumpInsn(153, param4Label);
/* 13388 */             return new StackManipulation.Size(0, 2);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 13395 */         DOUBLE
/*       */         {
/*       */           protected final StackManipulation.Size apply(MethodVisitor param4MethodVisitor, int param4Int, Label param4Label) {
/* 13398 */             param4MethodVisitor.visitVarInsn(24, param4Int);
/* 13399 */             param4MethodVisitor.visitInsn(14);
/* 13400 */             param4MethodVisitor.visitInsn(151);
/* 13401 */             param4MethodVisitor.visitJumpInsn(153, param4Label);
/* 13402 */             return new StackManipulation.Size(0, 4);
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 13409 */         REFERENCE
/*       */         {
/*       */           protected final StackManipulation.Size apply(MethodVisitor param4MethodVisitor, int param4Int, Label param4Label) {
/* 13412 */             param4MethodVisitor.visitVarInsn(25, param4Int);
/* 13413 */             param4MethodVisitor.visitJumpInsn(198, param4Label);
/* 13414 */             return new StackManipulation.Size(0, 2);
/*       */           }
/*       */         };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract StackManipulation.Size apply(MethodVisitor param3MethodVisitor, int param3Int, Label param3Label); }
/*       */     
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     protected static class ExceptionHandler
/*       */       implements StackManipulation
/*       */     {
/*       */       private final StackManipulation stackManipulation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final StackManipulation exceptionHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypeDescription exceptionType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Advice.StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ExceptionHandler(StackManipulation param2StackManipulation1, StackManipulation param2StackManipulation2, TypeDescription param2TypeDescription, Advice.StackMapFrameHandler.ForPostProcessor param2ForPostProcessor) {
/* 13468 */         this.stackManipulation = param2StackManipulation1;
/* 13469 */         this.exceptionHandler = param2StackManipulation2;
/* 13470 */         this.exceptionType = param2TypeDescription;
/* 13471 */         this.stackMapFrameHandler = param2ForPostProcessor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isValid() {
/* 13478 */         return (this.stackManipulation.isValid() && this.exceptionHandler.isValid());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 13485 */         Label label1 = new Label(), label2 = new Label(), label3 = new Label();
/* 13486 */         param2MethodVisitor.visitTryCatchBlock(label1, label2, label2, this.exceptionType.getInternalName());
/* 13487 */         param2MethodVisitor.visitLabel(label1);
/* 13488 */         StackManipulation.Size size = this.stackManipulation.apply(param2MethodVisitor, param2Context);
/* 13489 */         param2MethodVisitor.visitJumpInsn(167, label3);
/* 13490 */         param2MethodVisitor.visitLabel(label2);
/* 13491 */         this.stackMapFrameHandler.injectIntermediateFrame(param2MethodVisitor, Collections.singletonList(this.exceptionType));
/* 13492 */         size = this.exceptionHandler.apply(param2MethodVisitor, param2Context).aggregate(size);
/* 13493 */         param2MethodVisitor.visitLabel(label3);
/* 13494 */         this.stackMapFrameHandler.injectIntermediateFrame(param2MethodVisitor, Collections.emptyList());
/* 13495 */         return size;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.stackManipulation.equals(((ExceptionHandler)param2Object).stackManipulation) ? false : (!this.exceptionHandler.equals(((ExceptionHandler)param2Object).exceptionHandler) ? false : (!this.exceptionType.equals(((ExceptionHandler)param2Object).exceptionType) ? false : (!!this.stackMapFrameHandler.equals(((ExceptionHandler)param2Object).stackMapFrameHandler)))))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.exceptionHandler.hashCode()) * 31 + this.exceptionType.hashCode()) * 31 + this.stackMapFrameHandler.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public static interface Factory
/*       */       {
/*       */         StackManipulation wrap(StackManipulation param3StackManipulation1, StackManipulation param3StackManipulation2, Advice.StackMapFrameHandler.ForPostProcessor param3ForPostProcessor);
/*       */ 
/*       */ 
/*       */         
/*       */         public enum NoOp
/*       */           implements Factory
/*       */         {
/* 13523 */           INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final StackManipulation wrap(StackManipulation param4StackManipulation1, StackManipulation param4StackManipulation2, Advice.StackMapFrameHandler.ForPostProcessor param4ForPostProcessor) {
/* 13531 */             return param4StackManipulation1;
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class Enabled
/*       */           implements Factory
/*       */         {
/*       */           private final TypeDescription exceptionType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected Enabled(TypeDescription param4TypeDescription) {
/* 13552 */             this.exceptionType = param4TypeDescription;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public StackManipulation wrap(StackManipulation param4StackManipulation1, StackManipulation param4StackManipulation2, Advice.StackMapFrameHandler.ForPostProcessor param4ForPostProcessor)
/*       */           {
/* 13561 */             return new Advice.AssignReturned.ExceptionHandler(param4StackManipulation1, param4StackManipulation2, this.exceptionType, param4ForPostProcessor); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.exceptionType.equals(((Enabled)param4Object).exceptionType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.exceptionType.hashCode(); } } } } public static interface Factory { StackManipulation wrap(StackManipulation param2StackManipulation1, StackManipulation param2StackManipulation2, Advice.StackMapFrameHandler.ForPostProcessor param2ForPostProcessor); public enum NoOp implements Factory { INSTANCE; public final StackManipulation wrap(StackManipulation param4StackManipulation1, StackManipulation param4StackManipulation2, Advice.StackMapFrameHandler.ForPostProcessor param4ForPostProcessor) { return param4StackManipulation1; } } @Enhance public static class Enabled implements Factory { private final TypeDescription exceptionType; protected Enabled(TypeDescription param4TypeDescription) { this.exceptionType = param4TypeDescription; } public StackManipulation wrap(StackManipulation param4StackManipulation1, StackManipulation param4StackManipulation2, Advice.StackMapFrameHandler.ForPostProcessor param4ForPostProcessor) { return new Advice.AssignReturned.ExceptionHandler(param4StackManipulation1, param4StackManipulation2, this.exceptionType, param4ForPostProcessor); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param4Object) {
/*       */           return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.exceptionType.equals(((Enabled)param4Object).exceptionType))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.exceptionType.hashCode();
/*       */         } }
/*       */        }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Handler
/*       */     {
/*       */       int getIndex();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       StackManipulation resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, Advice.ArgumentHandler param2ArgumentHandler, TypeDescription.Generic param2Generic, StackManipulation param2StackManipulation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static interface Factory<T extends Annotation>
/*       */       {
/*       */         Class<T> getAnnotationType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param3InDefinedShape, boolean param3Boolean, AnnotationDescription.Loadable<? extends T> param3Loadable);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class Simple<S extends Annotation>
/*       */           implements Factory<S>
/*       */         {
/*       */           private final Class<S> type;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final List<Advice.AssignReturned.Handler> handlers;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Simple(Class<S> param4Class, List<Advice.AssignReturned.Handler> param4List) {
/* 13651 */             this.type = param4Class;
/* 13652 */             this.handlers = param4List;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Class<S> getAnnotationType() {
/* 13659 */             return this.type;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public List<Advice.AssignReturned.Handler> make(MethodDescription.InDefinedShape param4InDefinedShape, boolean param4Boolean, AnnotationDescription.Loadable<? extends S> param4Loadable) {
/* 13668 */             return this.handlers;
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.type.equals(((Simple)param4Object).type) ? false : (!!this.handlers.equals(((Simple)param4Object).handlers)))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return (getClass().hashCode() * 31 + this.type.hashCode()) * 31 + this.handlers.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */     
/*       */     @Enhance
/*       */     public static class Factory implements Advice.PostProcessor.Factory {
/* 13684 */       private static final MethodDescription.InDefinedShape SKIP_ON_DEFAULT_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Advice.AssignReturned.AsScalar.class)
/* 13685 */         .getDeclaredMethods()
/* 13686 */         .filter((ElementMatcher)ElementMatchers.named("skipOnDefaultValue")))
/* 13687 */         .getOnly();
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final List<? extends Advice.AssignReturned.Handler.Factory<?>> factories;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final Advice.AssignReturned.ExceptionHandler.Factory exceptionHandlerFactory;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Factory() {
/* 13704 */         this((List)Arrays.asList((Object[])new Enum[] { Advice.AssignReturned.ToArguments.Handler.Factory.INSTANCE, Advice.AssignReturned.ToAllArguments.Handler.Factory.INSTANCE, Advice.AssignReturned.ToThis.Handler.Factory.INSTANCE, Advice.AssignReturned.ToFields.Handler.Factory.INSTANCE, Advice.AssignReturned.ToReturned.Handler.Factory.INSTANCE, Advice.AssignReturned.ToThrown.Handler.Factory.INSTANCE }, ), Advice.AssignReturned.ExceptionHandler.Factory.NoOp.INSTANCE);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Factory(List<? extends Advice.AssignReturned.Handler.Factory<?>> param2List, Advice.AssignReturned.ExceptionHandler.Factory param2Factory) {
/* 13719 */         this.factories = param2List;
/* 13720 */         this.exceptionHandlerFactory = param2Factory;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Factory with(Class<? extends Annotation> param2Class, Advice.AssignReturned.Handler... param2VarArgs) {
/* 13731 */         return with(param2Class, Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Factory with(Class<? extends Annotation> param2Class, List<Advice.AssignReturned.Handler> param2List) {
/* 13743 */         return with(new Advice.AssignReturned.Handler.Factory.Simple(param2Class, param2List));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Factory with(Advice.AssignReturned.Handler.Factory<?> param2Factory) {
/* 13753 */         return new Factory(CompoundList.of(this.factories, param2Factory), this.exceptionHandlerFactory);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.PostProcessor.Factory withSuppressed(Class<? extends Throwable> param2Class) {
/* 13763 */         return withSuppressed(TypeDescription.ForLoadedType.of(param2Class));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.PostProcessor.Factory withSuppressed(TypeDescription param2TypeDescription) {
/* 13773 */         if (!param2TypeDescription.isAssignableTo(Throwable.class)) {
/* 13774 */           throw new IllegalArgumentException(param2TypeDescription + " is not a throwable type");
/*       */         }
/* 13776 */         return new Factory(this.factories, new Advice.AssignReturned.ExceptionHandler.Factory.Enabled(param2TypeDescription));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Advice.PostProcessor make(MethodDescription.InDefinedShape param2InDefinedShape, boolean param2Boolean) {
/* 13784 */         if (param2InDefinedShape.getReturnType().represents(void.class)) {
/* 13785 */           return Advice.PostProcessor.NoOp.INSTANCE;
/*       */         }
/* 13787 */         HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 13788 */         for (Advice.AssignReturned.Handler.Factory<?> factory : this.factories) {
/* 13789 */           if (hashMap.put(factory.getAnnotationType().getName(), factory) != null) {
/* 13790 */             throw new IllegalStateException("Duplicate registration of handler for " + factory.getAnnotationType());
/*       */           }
/*       */         } 
/* 13793 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 13794 */         boolean bool = false; boolean bool1 = true;
/* 13795 */         for (Iterator<AnnotationDescription> iterator = param2InDefinedShape.getDeclaredAnnotations().iterator(); iterator.hasNext(); ) {
/* 13796 */           AnnotationDescription annotationDescription; if ((annotationDescription = iterator.next()).getAnnotationType().represents(Advice.AssignReturned.AsScalar.class)) {
/* 13797 */             bool = true;
/* 13798 */             bool1 = ((Boolean)annotationDescription.getValue(SKIP_ON_DEFAULT_VALUE).resolve(Boolean.class)).booleanValue();
/*       */             continue;
/*       */           } 
/*       */           Advice.AssignReturned.Handler.Factory factory;
/* 13802 */           if ((factory = (Advice.AssignReturned.Handler.Factory)hashMap.get(annotationDescription.getAnnotationType().getName())) != null && 
/* 13803 */             linkedHashMap.put(factory.getAnnotationType(), factory.make(param2InDefinedShape, param2Boolean, annotationDescription
/*       */                 
/* 13805 */                 .prepare(factory.getAnnotationType()))) != null) {
/* 13806 */             throw new IllegalStateException("Duplicate handler registration for " + annotationDescription.getAnnotationType());
/*       */           }
/*       */         } 
/*       */         
/* 13810 */         if (linkedHashMap.isEmpty()) {
/* 13811 */           return Advice.PostProcessor.NoOp.INSTANCE;
/*       */         }
/* 13813 */         return (Advice.PostProcessor)((!bool && param2InDefinedShape.getReturnType().isArray()) ? new Advice.AssignReturned.ForArray(param2InDefinedShape
/* 13814 */             .getReturnType(), this.exceptionHandlerFactory, param2Boolean, linkedHashMap.values()) : new Advice.AssignReturned.ForScalar(param2InDefinedShape
/* 13815 */             .getReturnType(), this.exceptionHandlerFactory, param2Boolean, bool1, linkedHashMap.values()));
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.factories.equals(((Factory)param2Object).factories) ? false : (!!this.exceptionHandlerFactory.equals(((Factory)param2Object).exceptionHandlerFactory)))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (getClass().hashCode() * 31 + this.factories.hashCode()) * 31 + this.exceptionHandlerFactory.hashCode();
/*       */       }
/*       */     }
/*       */     
/*       */     @Documented
/*       */     @Retention(RetentionPolicy.RUNTIME)
/*       */     @Target({ElementType.METHOD})
/*       */     public static @interface AsScalar
/*       */     {
/*       */       boolean skipOnDefaultValue() default true;
/*       */     }
/*       */   }
/*       */   
/*       */   @Enhance
/*       */   public static class WithCustomMapping
/*       */   {
/*       */     private final Advice.PostProcessor.Factory postProcessorFactory;
/*       */     private final Advice.Delegator delegator;
/*       */     private final Map<Class<? extends Annotation>, Advice.OffsetMapping.Factory<?>> offsetMappings;
/*       */     
/*       */     protected WithCustomMapping() {
/* 13846 */       this(Advice.PostProcessor.NoOp.INSTANCE, Collections.emptyMap(), Advice.Delegator.ForStaticInvocation.INSTANCE);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected WithCustomMapping(Advice.PostProcessor.Factory param1Factory, Map<Class<? extends Annotation>, Advice.OffsetMapping.Factory<?>> param1Map, Advice.Delegator param1Delegator) {
/* 13859 */       this.postProcessorFactory = param1Factory;
/* 13860 */       this.offsetMappings = param1Map;
/* 13861 */       this.delegator = param1Delegator;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, @MaybeNull Object param1Object) {
/* 13874 */       return bind(Advice.OffsetMapping.ForStackManipulation.Factory.of(param1Class, param1Object));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, Field param1Field) {
/* 13887 */       return bind(param1Class, (FieldDescription)new FieldDescription.ForLoadedField(param1Field));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, FieldDescription param1FieldDescription) {
/* 13901 */       return bind(new Advice.OffsetMapping.ForField.Resolved.Factory(param1Class, param1FieldDescription));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, Method param1Method, int param1Int) {
/* 13914 */       if (param1Int < 0)
/* 13915 */         throw new IllegalArgumentException("A parameter cannot be negative: " + param1Int); 
/* 13916 */       if ((param1Method.getParameterTypes()).length <= param1Int) {
/* 13917 */         throw new IllegalArgumentException(param1Method + " does not declare a parameter with index " + param1Int);
/*       */       }
/* 13919 */       return bind(param1Class, (ParameterDescription)(new MethodDescription.ForLoadedMethod(param1Method)).getParameters().get(param1Int));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, Constructor<?> param1Constructor, int param1Int) {
/* 13932 */       if (param1Int < 0)
/* 13933 */         throw new IllegalArgumentException("A parameter cannot be negative: " + param1Int); 
/* 13934 */       if ((param1Constructor.getParameterTypes()).length <= param1Int) {
/* 13935 */         throw new IllegalArgumentException(param1Constructor + " does not declare a parameter with index " + param1Int);
/*       */       }
/* 13937 */       return bind(param1Class, (ParameterDescription)(new MethodDescription.ForLoadedConstructor(param1Constructor)).getParameters().get(param1Int));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, ParameterDescription param1ParameterDescription) {
/* 13950 */       return bind(new Advice.OffsetMapping.ForArgument.Resolved.Factory(param1Class, param1ParameterDescription));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, Class<?> param1Class1) {
/* 13962 */       return bind(param1Class, TypeDescription.ForLoadedType.of(param1Class1));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, TypeDescription param1TypeDescription) {
/* 13974 */       return bind(new Advice.OffsetMapping.ForStackManipulation.Factory(param1Class, param1TypeDescription));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, Enum<?> param1Enum) {
/* 13986 */       return bind(param1Class, (EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration(param1Enum));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, EnumerationDescription param1EnumerationDescription) {
/* 13998 */       return bind(new Advice.OffsetMapping.ForStackManipulation.Factory(param1Class, param1EnumerationDescription));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindSerialized(Class<T> param1Class, Serializable param1Serializable) {
/* 14011 */       return bindSerialized(param1Class, param1Serializable, param1Serializable.getClass());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation, S extends Serializable> WithCustomMapping bindSerialized(Class<T> param1Class, S param1S, Class<? super S> param1Class1) {
/* 14025 */       return bind(Advice.OffsetMapping.ForSerializedValue.Factory.of(param1Class, (Serializable)param1S, param1Class1));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindProperty(Class<T> param1Class, String param1String) {
/* 14037 */       return bind(Advice.OffsetMapping.ForStackManipulation.OfAnnotationProperty.of(param1Class, param1String));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, JavaConstant param1JavaConstant) {
/* 14049 */       return bind(new Advice.OffsetMapping.ForStackManipulation.Factory(param1Class, (StackManipulation)new JavaConstantValue(param1JavaConstant), param1JavaConstant.getTypeDescription().asGenericType()));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, StackManipulation param1StackManipulation, Type param1Type) {
/* 14062 */       return bind(param1Class, param1StackManipulation, TypeDefinition.Sort.describe(param1Type));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, StackManipulation param1StackManipulation, TypeDescription.Generic param1Generic) {
/* 14075 */       return bind(new Advice.OffsetMapping.ForStackManipulation.Factory(param1Class, param1StackManipulation, param1Generic));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindLambda(Class<T> param1Class, Constructor<?> param1Constructor, Class<?> param1Class1) {
/* 14090 */       return bindLambda(param1Class, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param1Constructor), 
/*       */           
/* 14092 */           TypeDescription.ForLoadedType.of(param1Class1));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindLambda(Class<T> param1Class, Constructor<?> param1Constructor, Class<?> param1Class1, MethodGraph.Compiler param1Compiler) {
/* 14109 */       return bindLambda(param1Class, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param1Constructor), 
/*       */           
/* 14111 */           TypeDescription.ForLoadedType.of(param1Class1), param1Compiler);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindLambda(Class<T> param1Class, Method param1Method, Class<?> param1Class1) {
/* 14127 */       return bindLambda(param1Class, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method), 
/*       */           
/* 14129 */           TypeDescription.ForLoadedType.of(param1Class1));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindLambda(Class<T> param1Class, Method param1Method, Class<?> param1Class1, MethodGraph.Compiler param1Compiler) {
/* 14146 */       return bindLambda(param1Class, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method), 
/*       */           
/* 14148 */           TypeDescription.ForLoadedType.of(param1Class1), param1Compiler);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindLambda(Class<T> param1Class, MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription param1TypeDescription) {
/* 14164 */       return bindLambda(param1Class, param1InDefinedShape, param1TypeDescription, MethodGraph.Compiler.DEFAULT);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindLambda(Class<T> param1Class, MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription param1TypeDescription, MethodGraph.Compiler param1Compiler) {
/* 14181 */       if (!param1TypeDescription.isInterface()) {
/* 14182 */         throw new IllegalArgumentException(param1TypeDescription + " is not an interface type");
/*       */       }
/*       */ 
/*       */       
/*       */       MethodList methodList;
/*       */       
/* 14188 */       if ((methodList = (MethodList)param1Compiler.compile((TypeDefinition)param1TypeDescription).listNodes().asMethodList().filter((ElementMatcher)ElementMatchers.isAbstract())).size() != 1) {
/* 14189 */         throw new IllegalArgumentException(param1TypeDescription + " does not define exactly one abstract method: " + methodList);
/*       */       }
/* 14191 */       return bindDynamic(param1Class, (MethodDescription.InDefinedShape)new MethodDescription.Latent((TypeDescription)new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, 
/*       */               
/* 14193 */               TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new TypeDescription.Generic[0]), "metafactory", 9, 
/*       */ 
/*       */             
/* 14196 */             Collections.emptyList(), JavaType.CALL_SITE
/* 14197 */             .getTypeStub().asGenericType(), 
/* 14198 */             Arrays.asList(new ParameterDescription.Token[] { new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType()), new ParameterDescription.Token(
/* 14199 */                   TypeDescription.ForLoadedType.of(String.class).asGenericType()), new ParameterDescription.Token(JavaType.METHOD_TYPE
/* 14200 */                   .getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_TYPE
/* 14201 */                   .getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE
/* 14202 */                   .getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_TYPE
/* 14203 */                   .getTypeStub().asGenericType())
/* 14204 */               }, ), Collections.emptyList(), 
/* 14205 */             Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), new Object[] {
/*       */ 
/*       */             
/* 14208 */             JavaConstant.MethodType.of((MethodDescription)methodList.asDefined().getOnly()), 
/* 14209 */             JavaConstant.MethodHandle.of(param1InDefinedShape), 
/* 14210 */             JavaConstant.MethodType.of((MethodDescription)methodList.asDefined().getOnly())
/*       */           });
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> param1Class, Method param1Method, Object... param1VarArgs) {
/* 14223 */       return bindDynamic(param1Class, param1Method, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> param1Class, Method param1Method, List<?> param1List) {
/* 14236 */       return bindDynamic(param1Class, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method), param1List);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> param1Class, Constructor<?> param1Constructor, Object... param1VarArgs) {
/* 14249 */       return bindDynamic(param1Class, param1Constructor, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> param1Class, Constructor<?> param1Constructor, List<?> param1List) {
/* 14262 */       return bindDynamic(param1Class, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param1Constructor), param1List);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> param1Class, MethodDescription.InDefinedShape param1InDefinedShape, Object... param1VarArgs) {
/* 14275 */       return bindDynamic(param1Class, param1InDefinedShape, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> param1Class, MethodDescription.InDefinedShape param1InDefinedShape, List<?> param1List) {
/* 14288 */       param1List = JavaConstant.Simple.wrap(param1List);
/* 14289 */       if (!param1InDefinedShape.isInvokeBootstrap((List)TypeList.Explicit.of(param1List))) {
/* 14290 */         throw new IllegalArgumentException("Not a valid bootstrap method " + param1InDefinedShape + " for " + param1List);
/*       */       }
/* 14292 */       return bind(new Advice.OffsetMapping.ForStackManipulation.OfDynamicInvocation(param1Class, param1InDefinedShape, (List)param1List));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T extends Annotation> WithCustomMapping bind(Class<T> param1Class, Advice.OffsetMapping param1OffsetMapping) {
/* 14304 */       return bind(new Advice.OffsetMapping.Factory.Simple(param1Class, param1OffsetMapping));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public WithCustomMapping bind(Advice.OffsetMapping.Factory<?> param1Factory) {
/* 14315 */       HashMap<Class<? extends Annotation>, Advice.OffsetMapping.Factory<?>> hashMap = new HashMap<Class<? extends Annotation>, Advice.OffsetMapping.Factory<?>>(this.offsetMappings);
/* 14316 */       if (!param1Factory.getAnnotationType().isAnnotation())
/* 14317 */         throw new IllegalArgumentException("Not an annotation type: " + param1Factory.getAnnotationType()); 
/* 14318 */       if (hashMap.put((Class)param1Factory.getAnnotationType(), param1Factory) != null) {
/* 14319 */         throw new IllegalArgumentException("Annotation type already mapped: " + param1Factory.getAnnotationType());
/*       */       }
/* 14321 */       return new WithCustomMapping(this.postProcessorFactory, hashMap, this.delegator);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public WithCustomMapping bootstrap(Constructor<?> param1Constructor) {
/* 14342 */       return bootstrap((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param1Constructor));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public WithCustomMapping bootstrap(Method param1Method) {
/* 14363 */       return bootstrap((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public WithCustomMapping bootstrap(MethodDescription.InDefinedShape param1InDefinedShape) {
/* 14384 */       return new WithCustomMapping(this.postProcessorFactory, this.offsetMappings, Advice.Delegator.ForDynamicInvocation.of(param1InDefinedShape));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public WithCustomMapping with(Advice.PostProcessor.Factory param1Factory) {
/* 14394 */       return new WithCustomMapping(new Advice.PostProcessor.Factory.Compound(new Advice.PostProcessor.Factory[] { this.postProcessorFactory, param1Factory }, ), this.offsetMappings, this.delegator);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Advice to(Class<?> param1Class) {
/* 14405 */       return to(param1Class, ClassFileLocator.ForClassLoader.of(param1Class.getClassLoader()));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Advice to(Class<?> param1Class, ClassFileLocator param1ClassFileLocator) {
/* 14416 */       return to(TypeDescription.ForLoadedType.of(param1Class), param1ClassFileLocator);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Advice to(TypeDescription param1TypeDescription, ClassFileLocator param1ClassFileLocator) {
/* 14427 */       return Advice.to(param1TypeDescription, this.postProcessorFactory, param1ClassFileLocator, new ArrayList<Advice.OffsetMapping.Factory<?>>(this.offsetMappings.values()), this.delegator);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Advice to(Class<?> param1Class1, Class<?> param1Class2) {
/* 14439 */       ClassLoader classLoader1 = param1Class1.getClassLoader(), classLoader2 = param1Class2.getClassLoader();
/* 14440 */       return to(param1Class1, param1Class2, (classLoader1 == classLoader2) ? 
/* 14441 */           ClassFileLocator.ForClassLoader.of(classLoader1) : (ClassFileLocator)new ClassFileLocator.Compound(new ClassFileLocator[] {
/* 14442 */               ClassFileLocator.ForClassLoader.of(classLoader1), ClassFileLocator.ForClassLoader.of(classLoader2)
/*       */             }));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Advice to(Class<?> param1Class1, Class<?> param1Class2, ClassFileLocator param1ClassFileLocator) {
/* 14454 */       return to(TypeDescription.ForLoadedType.of(param1Class1), TypeDescription.ForLoadedType.of(param1Class2), param1ClassFileLocator);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Advice to(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/* 14467 */       return to(param1TypeDescription1, param1TypeDescription2, (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Advice to(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2, ClassFileLocator param1ClassFileLocator) {
/* 14479 */       return Advice.to(param1TypeDescription1, param1TypeDescription2, this.postProcessorFactory, param1ClassFileLocator, new ArrayList<Advice.OffsetMapping.Factory<?>>(this.offsetMappings.values()), this.delegator);
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean equals(@MaybeNull Object param1Object) {
/*       */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.postProcessorFactory.equals(((WithCustomMapping)param1Object).postProcessorFactory) ? false : (!this.delegator.equals(((WithCustomMapping)param1Object).delegator) ? false : (!!this.offsetMappings.equals(((WithCustomMapping)param1Object).offsetMappings))))));
/*       */     }
/*       */     
/*       */     public int hashCode() {
/*       */       return ((getClass().hashCode() * 31 + this.postProcessorFactory.hashCode()) * 31 + this.delegator.hashCode()) * 31 + this.offsetMappings.hashCode();
/*       */     }
/*       */   }
/*       */   
/*       */   private static class NoExceptionHandler
/*       */     extends Throwable
/*       */   {
/*       */     private static final long serialVersionUID = 1L;
/* 14496 */     private static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(NoExceptionHandler.class);
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private NoExceptionHandler() {
/* 14502 */       throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class OnDefaultValue
/*       */   {
/*       */     private OnDefaultValue() {
/* 14519 */       throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class OnNonDefaultValue
/*       */   {
/*       */     private OnNonDefaultValue() {
/* 14536 */       throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
/*       */     }
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Unused {}
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface StubValue {}
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Local {
/*       */     String value();
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Exit {
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Enter {
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Origin {
/*       */     public static final String DEFAULT = "";
/*       */     
/*       */     String value() default "";
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface FieldValue {
/*       */     String value() default "";
/*       */     
/*       */     Class<?> declaringType() default void.class;
/*       */     
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Thrown {
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.DYNAMIC;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Return {
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface AllArguments {
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */     
/*       */     boolean nullIfEmpty() default false;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface Argument {
/*       */     int value();
/*       */     
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */     
/*       */     boolean optional() default false;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.PARAMETER})
/*       */   public static @interface This {
/*       */     boolean readOnly() default true;
/*       */     
/*       */     Assigner.Typing typing() default Assigner.Typing.STATIC;
/*       */     
/*       */     boolean optional() default false;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.METHOD})
/*       */   public static @interface OnMethodExit {
/*       */     Class<?> repeatOn() default void.class;
/*       */     
/*       */     Class<? extends Throwable> onThrowable() default Advice.NoExceptionHandler.class;
/*       */     
/*       */     boolean backupArguments() default true;
/*       */     
/*       */     boolean inline() default true;
/*       */     
/*       */     Class<? extends Throwable> suppress() default Advice.NoExceptionHandler.class;
/*       */   }
/*       */   
/*       */   @Documented
/*       */   @Retention(RetentionPolicy.RUNTIME)
/*       */   @Target({ElementType.METHOD})
/*       */   public static @interface OnMethodEnter {
/*       */     Class<?> skipOn() default void.class;
/*       */     
/*       */     boolean prependLineNumber() default true;
/*       */     
/*       */     boolean inline() default true;
/*       */     
/*       */     Class<? extends Throwable> suppress() default Advice.NoExceptionHandler.class;
/*       */   }
/*       */   
/*       */   public static interface ForMethodEnter extends Dispatcher.Resolved {
/*       */     boolean isPrependLineNumber();
/*       */     
/*       */     TypeDefinition getActualAdviceType();
/*       */   }
/*       */   
/*       */   public static interface ForMethodExit extends Dispatcher.Resolved {
/*       */     TypeDescription getThrowable();
/*       */     
/*       */     Advice.ArgumentHandler.Factory getArgumentHandlerFactory();
/*       */   }
/*       */   
/*       */   public static interface Unresolved extends Dispatcher {
/*       */     boolean isBinary();
/*       */     
/*       */     Map<String, TypeDefinition> getNamedTypes();
/*       */     
/*       */     Advice.Dispatcher.Resolved.ForMethodEnter asMethodEnter(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory);
/*       */     
/*       */     Advice.Dispatcher.Resolved.ForMethodExit asMethodExit(List<? extends Advice.OffsetMapping.Factory<?>> param1List, @MaybeNull ClassReader param1ClassReader, Unresolved param1Unresolved, Advice.PostProcessor.Factory param1Factory);
/*       */   }
/*       */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\Advice.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */