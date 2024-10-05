/*       */ package net.bytebuddy.agent.builder;
/*       */ 
/*       */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*       */ import java.io.File;
/*       */ import java.io.NotSerializableException;
/*       */ import java.io.ObjectInputStream;
/*       */ import java.io.ObjectOutputStream;
/*       */ import java.io.PrintStream;
/*       */ import java.io.Serializable;
/*       */ import java.lang.instrument.ClassDefinition;
/*       */ import java.lang.instrument.ClassFileTransformer;
/*       */ import java.lang.instrument.Instrumentation;
/*       */ import java.lang.ref.WeakReference;
/*       */ import java.lang.reflect.Constructor;
/*       */ import java.lang.reflect.InvocationTargetException;
/*       */ import java.lang.reflect.Type;
/*       */ import java.security.AccessControlContext;
/*       */ import java.security.AccessController;
/*       */ import java.security.PrivilegedAction;
/*       */ import java.security.ProtectionDomain;
/*       */ import java.util.AbstractSet;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Arrays;
/*       */ import java.util.Collection;
/*       */ import java.util.Collections;
/*       */ import java.util.HashMap;
/*       */ import java.util.HashSet;
/*       */ import java.util.Iterator;
/*       */ import java.util.LinkedHashMap;
/*       */ import java.util.LinkedHashSet;
/*       */ import java.util.List;
/*       */ import java.util.Map;
/*       */ import java.util.NoSuchElementException;
/*       */ import java.util.Random;
/*       */ import java.util.Set;
/*       */ import java.util.concurrent.Callable;
/*       */ import java.util.concurrent.ConcurrentHashMap;
/*       */ import java.util.concurrent.ConcurrentMap;
/*       */ import java.util.concurrent.ExecutionException;
/*       */ import java.util.concurrent.ExecutorService;
/*       */ import java.util.concurrent.Future;
/*       */ import java.util.concurrent.ScheduledExecutorService;
/*       */ import java.util.concurrent.TimeUnit;
/*       */ import java.util.concurrent.atomic.AtomicBoolean;
/*       */ import java.util.concurrent.atomic.AtomicInteger;
/*       */ import java.util.concurrent.locks.Lock;
/*       */ import java.util.concurrent.locks.ReentrantLock;
/*       */ import net.bytebuddy.ByteBuddy;
/*       */ import net.bytebuddy.ClassFileVersion;
/*       */ import net.bytebuddy.asm.Advice;
/*       */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*       */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*       */ import net.bytebuddy.build.EntryPoint;
/*       */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*       */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*       */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*       */ import net.bytebuddy.build.Plugin;
/*       */ import net.bytebuddy.description.field.FieldDescription;
/*       */ import net.bytebuddy.description.method.MethodDescription;
/*       */ import net.bytebuddy.description.method.MethodList;
/*       */ import net.bytebuddy.description.method.ParameterDescription;
/*       */ import net.bytebuddy.description.modifier.FieldManifestation;
/*       */ import net.bytebuddy.description.modifier.MethodManifestation;
/*       */ import net.bytebuddy.description.modifier.ModifierContributor;
/*       */ import net.bytebuddy.description.modifier.Ownership;
/*       */ import net.bytebuddy.description.modifier.TypeManifestation;
/*       */ import net.bytebuddy.description.modifier.Visibility;
/*       */ import net.bytebuddy.description.type.PackageDescription;
/*       */ import net.bytebuddy.description.type.TypeDefinition;
/*       */ import net.bytebuddy.description.type.TypeDescription;
/*       */ import net.bytebuddy.dynamic.ClassFileLocator;
/*       */ import net.bytebuddy.dynamic.DynamicType;
/*       */ import net.bytebuddy.dynamic.NexusAccessor;
/*       */ import net.bytebuddy.dynamic.TypeResolutionStrategy;
/*       */ import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
/*       */ import net.bytebuddy.dynamic.loading.ClassInjector;
/*       */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*       */ import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
/*       */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*       */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*       */ import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
/*       */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*       */ import net.bytebuddy.implementation.ExceptionMethod;
/*       */ import net.bytebuddy.implementation.Implementation;
/*       */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*       */ import net.bytebuddy.implementation.MethodCall;
/*       */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*       */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*       */ import net.bytebuddy.implementation.bytecode.Duplication;
/*       */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*       */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*       */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*       */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*       */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
/*       */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*       */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*       */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*       */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*       */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*       */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*       */ import net.bytebuddy.jar.asm.ConstantDynamic;
/*       */ import net.bytebuddy.jar.asm.Handle;
/*       */ import net.bytebuddy.jar.asm.Label;
/*       */ import net.bytebuddy.jar.asm.MethodVisitor;
/*       */ import net.bytebuddy.jar.asm.Opcodes;
/*       */ import net.bytebuddy.jar.asm.Type;
/*       */ import net.bytebuddy.matcher.ElementMatcher;
/*       */ import net.bytebuddy.matcher.ElementMatchers;
/*       */ import net.bytebuddy.matcher.LatentMatcher;
/*       */ import net.bytebuddy.pool.TypePool;
/*       */ import net.bytebuddy.utility.CompoundList;
/*       */ import net.bytebuddy.utility.JavaConstant;
/*       */ import net.bytebuddy.utility.JavaModule;
/*       */ import net.bytebuddy.utility.JavaType;
/*       */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*       */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
/*       */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
/*       */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*       */ import net.bytebuddy.utility.nullability.MaybeNull;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public interface AgentBuilder
/*       */ {
/*       */   AgentBuilder with(ByteBuddy paramByteBuddy);
/*       */   
/*       */   AgentBuilder with(Listener paramListener);
/*       */   
/*       */   AgentBuilder with(CircularityLock paramCircularityLock);
/*       */   
/*       */   AgentBuilder with(PoolStrategy paramPoolStrategy);
/*       */   
/*       */   AgentBuilder with(LocationStrategy paramLocationStrategy);
/*       */   
/*       */   AgentBuilder with(TypeStrategy paramTypeStrategy);
/*       */   
/*       */   AgentBuilder with(InitializationStrategy paramInitializationStrategy);
/*       */   
/*       */   RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy paramRedefinitionStrategy);
/*       */   
/*       */   AgentBuilder with(LambdaInstrumentationStrategy paramLambdaInstrumentationStrategy);
/*       */   
/*       */   AgentBuilder with(DescriptionStrategy paramDescriptionStrategy);
/*       */   
/*       */   AgentBuilder with(FallbackStrategy paramFallbackStrategy);
/*       */   
/*       */   AgentBuilder with(ClassFileBufferStrategy paramClassFileBufferStrategy);
/*       */   
/*       */   AgentBuilder with(InstallationListener paramInstallationListener);
/*       */   
/*       */   AgentBuilder with(InjectionStrategy paramInjectionStrategy);
/*       */   
/*       */   AgentBuilder with(TransformerDecorator paramTransformerDecorator);
/*       */   
/*       */   AgentBuilder enableNativeMethodPrefix(String paramString);
/*       */   
/*       */   AgentBuilder disableNativeMethodPrefix();
/*       */   
/*       */   AgentBuilder disableClassFormatChanges();
/*       */   
/*       */   AgentBuilder warmUp(Class<?>... paramVarArgs);
/*       */   
/*       */   AgentBuilder warmUp(Collection<Class<?>> paramCollection);
/*       */   
/*       */   AgentBuilder assureReadEdgeTo(Instrumentation paramInstrumentation, Class<?>... paramVarArgs);
/*       */   
/*       */   AgentBuilder assureReadEdgeTo(Instrumentation paramInstrumentation, JavaModule... paramVarArgs);
/*       */   
/*       */   AgentBuilder assureReadEdgeTo(Instrumentation paramInstrumentation, Collection<? extends JavaModule> paramCollection);
/*       */   
/*       */   AgentBuilder assureReadEdgeFromAndTo(Instrumentation paramInstrumentation, Class<?>... paramVarArgs);
/*       */   
/*       */   AgentBuilder assureReadEdgeFromAndTo(Instrumentation paramInstrumentation, JavaModule... paramVarArgs);
/*       */   
/*       */   AgentBuilder assureReadEdgeFromAndTo(Instrumentation paramInstrumentation, Collection<? extends JavaModule> paramCollection);
/*       */   
/*       */   Identified.Narrowable type(ElementMatcher<? super TypeDescription> paramElementMatcher);
/*       */   
/*       */   Identified.Narrowable type(ElementMatcher<? super TypeDescription> paramElementMatcher, ElementMatcher<? super ClassLoader> paramElementMatcher1);
/*       */   
/*       */   Identified.Narrowable type(ElementMatcher<? super TypeDescription> paramElementMatcher, ElementMatcher<? super ClassLoader> paramElementMatcher1, ElementMatcher<? super JavaModule> paramElementMatcher2);
/*       */   
/*       */   Identified.Narrowable type(RawMatcher paramRawMatcher);
/*       */   
/*       */   Ignored ignore(ElementMatcher<? super TypeDescription> paramElementMatcher);
/*       */   
/*       */   Ignored ignore(ElementMatcher<? super TypeDescription> paramElementMatcher, ElementMatcher<? super ClassLoader> paramElementMatcher1);
/*       */   
/*       */   Ignored ignore(ElementMatcher<? super TypeDescription> paramElementMatcher, ElementMatcher<? super ClassLoader> paramElementMatcher1, ElementMatcher<? super JavaModule> paramElementMatcher2);
/*       */   
/*       */   Ignored ignore(RawMatcher paramRawMatcher);
/*       */   
/*       */   ClassFileTransformer makeRaw();
/*       */   
/*       */   ResettableClassFileTransformer installOn(Instrumentation paramInstrumentation);
/*       */   
/*       */   ResettableClassFileTransformer installOnByteBuddyAgent();
/*       */   
/*       */   ResettableClassFileTransformer patchOn(Instrumentation paramInstrumentation, ResettableClassFileTransformer paramResettableClassFileTransformer);
/*       */   
/*       */   ResettableClassFileTransformer patchOn(Instrumentation paramInstrumentation, ResettableClassFileTransformer paramResettableClassFileTransformer, PatchMode paramPatchMode);
/*       */   
/*       */   ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer paramResettableClassFileTransformer);
/*       */   
/*       */   ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer paramResettableClassFileTransformer, PatchMode paramPatchMode);
/*       */   
/*       */   public static interface Narrowable
/*       */     extends Identified, Matchable<Identified.Narrowable> {}
/*       */   
/*       */   public static interface WithoutBatchStrategy
/*       */     extends RedefinitionListenable.WithImplicitDiscoveryStrategy
/*       */   {
/*       */     AgentBuilder.RedefinitionListenable.WithImplicitDiscoveryStrategy with(AgentBuilder.RedefinitionStrategy.BatchAllocator param1BatchAllocator);
/*       */   }
/*       */   
/*       */   public static interface Matchable<T extends Matchable<T>>
/*       */   {
/*       */     T and(ElementMatcher<? super TypeDescription> param1ElementMatcher);
/*       */     
/*       */     T and(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1);
/*       */     
/*       */     T and(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1, ElementMatcher<? super JavaModule> param1ElementMatcher2);
/*       */     
/*       */     T and(AgentBuilder.RawMatcher param1RawMatcher);
/*       */     
/*       */     T or(ElementMatcher<? super TypeDescription> param1ElementMatcher);
/*       */     
/*       */     T or(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1);
/*       */     
/*       */     T or(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1, ElementMatcher<? super JavaModule> param1ElementMatcher2);
/*       */     
/*       */     T or(AgentBuilder.RawMatcher param1RawMatcher);
/*       */   }
/*       */   
/*       */   public static interface Ignored
/*       */     extends AgentBuilder, Matchable<Ignored> {}
/*       */   
/*       */   public static interface RedefinitionListenable
/*       */     extends AgentBuilder
/*       */   {
/*       */     RedefinitionListenable with(AgentBuilder.RedefinitionStrategy.Listener param1Listener);
/*       */     
/*       */     WithoutResubmissionSpecification withResubmission(AgentBuilder.RedefinitionStrategy.ResubmissionScheduler param1ResubmissionScheduler);
/*       */     
/*       */     public static interface ResubmissionOnErrorMatcher
/*       */     {
/*       */       boolean matches(Throwable param2Throwable, String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule);
/*       */       
/*       */       public enum Trivial
/*       */         implements ResubmissionOnErrorMatcher
/*       */       {
/*   921 */         MATCHING(true),
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*   926 */         NON_MATCHING(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean matching;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         Trivial(boolean param3Boolean) {
/*   939 */           this.matching = param3Boolean;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final boolean matches(Throwable param3Throwable, String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*   946 */           return this.matching;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Conjunction
/*       */         implements ResubmissionOnErrorMatcher
/*       */       {
/*       */         private final List<AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> matchers;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Conjunction(AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher... param3VarArgs) {
/*   967 */           this(Arrays.asList(param3VarArgs));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Conjunction(List<? extends AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> param3List) {
/*   976 */           this.matchers = new ArrayList<AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher>(param3List.size());
/*   977 */           for (Iterator<? extends AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> iterator = param3List.iterator(); iterator.hasNext(); ) {
/*   978 */             AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher; if (resubmissionOnErrorMatcher = iterator.next() instanceof Conjunction) {
/*   979 */               this.matchers.addAll(((Conjunction)resubmissionOnErrorMatcher).matchers); continue;
/*   980 */             }  if (resubmissionOnErrorMatcher != AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher.Trivial.MATCHING) {
/*   981 */               this.matchers.add(resubmissionOnErrorMatcher);
/*       */             }
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(Throwable param3Throwable, String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*   990 */           for (Iterator<AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> iterator = this.matchers.iterator(); iterator.hasNext();) {
/*   991 */             if (!(resubmissionOnErrorMatcher = iterator.next()).matches(param3Throwable, param3String, param3ClassLoader, param3JavaModule)) {
/*   992 */               return false;
/*       */             }
/*       */           } 
/*   995 */           return true;
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matchers.equals(((Conjunction)param3Object).matchers))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.matchers.hashCode();
/*       */         }
/*       */       }
/*       */       
/*       */       @Enhance
/*       */       public static class Disjunction
/*       */         implements ResubmissionOnErrorMatcher
/*       */       {
/*       */         private final List<AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> matchers;
/*       */         
/*       */         public Disjunction(AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher... param3VarArgs) {
/*  1016 */           this(Arrays.asList(param3VarArgs));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Disjunction(List<? extends AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> param3List) {
/*  1025 */           this.matchers = new ArrayList<AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher>(param3List.size());
/*  1026 */           for (Iterator<? extends AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> iterator = param3List.iterator(); iterator.hasNext(); ) {
/*  1027 */             AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher; if (resubmissionOnErrorMatcher = iterator.next() instanceof Disjunction) {
/*  1028 */               this.matchers.addAll(((Disjunction)resubmissionOnErrorMatcher).matchers); continue;
/*  1029 */             }  if (resubmissionOnErrorMatcher != AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher.Trivial.NON_MATCHING) {
/*  1030 */               this.matchers.add(resubmissionOnErrorMatcher);
/*       */             }
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(Throwable param3Throwable, String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  1039 */           for (Iterator<AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher> iterator = this.matchers.iterator(); iterator.hasNext();) {
/*  1040 */             if ((resubmissionOnErrorMatcher = iterator.next()).matches(param3Throwable, param3String, param3ClassLoader, param3JavaModule)) {
/*  1041 */               return true;
/*       */             }
/*       */           } 
/*  1044 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matchers.equals(((Disjunction)param3Object).matchers))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.matchers.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForElementMatchers
/*       */         implements ResubmissionOnErrorMatcher
/*       */       {
/*       */         private final ElementMatcher<? super Throwable> exceptionMatcher;
/*       */ 
/*       */ 
/*       */         
/*       */         private final ElementMatcher<String> typeNameMatcher;
/*       */ 
/*       */ 
/*       */         
/*       */         private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
/*       */ 
/*       */ 
/*       */         
/*       */         private final ElementMatcher<? super JavaModule> moduleMatcher;
/*       */ 
/*       */ 
/*       */         
/*       */         public ForElementMatchers(ElementMatcher<? super Throwable> param3ElementMatcher, ElementMatcher<String> param3ElementMatcher1, ElementMatcher<? super ClassLoader> param3ElementMatcher2, ElementMatcher<? super JavaModule> param3ElementMatcher3) {
/*  1086 */           this.exceptionMatcher = param3ElementMatcher;
/*  1087 */           this.typeNameMatcher = param3ElementMatcher1;
/*  1088 */           this.classLoaderMatcher = param3ElementMatcher2;
/*  1089 */           this.moduleMatcher = param3ElementMatcher3;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(Throwable param3Throwable, String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  1096 */           if (this.exceptionMatcher.matches(param3Throwable) && this.typeNameMatcher
/*  1097 */             .matches(param3String) && this.classLoaderMatcher
/*  1098 */             .matches(param3ClassLoader) && this.moduleMatcher
/*  1099 */             .matches(param3JavaModule)) return true;
/*       */           
/*       */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.exceptionMatcher.equals(((ForElementMatchers)param3Object).exceptionMatcher) ? false : (!this.typeNameMatcher.equals(((ForElementMatchers)param3Object).typeNameMatcher) ? false : (!this.classLoaderMatcher.equals(((ForElementMatchers)param3Object).classLoaderMatcher) ? false : (!!this.moduleMatcher.equals(((ForElementMatchers)param3Object).moduleMatcher)))))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (((getClass().hashCode() * 31 + this.exceptionMatcher.hashCode()) * 31 + this.typeNameMatcher.hashCode()) * 31 + this.classLoaderMatcher.hashCode()) * 31 + this.moduleMatcher.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     public static interface ResubmissionImmediateMatcher
/*       */     {
/*       */       boolean matches(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule);
/*       */ 
/*       */       
/*       */       public enum Trivial
/*       */         implements ResubmissionImmediateMatcher
/*       */       {
/*  1127 */         MATCHING(true),
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1132 */         NON_MATCHING(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean matching;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         Trivial(boolean param3Boolean) {
/*  1145 */           this.matching = param3Boolean;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final boolean matches(String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  1152 */           return this.matching;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Conjunction
/*       */         implements ResubmissionImmediateMatcher
/*       */       {
/*       */         private final List<AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> matchers;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Conjunction(AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher... param3VarArgs) {
/*  1173 */           this(Arrays.asList(param3VarArgs));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Conjunction(List<? extends AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> param3List) {
/*  1182 */           this.matchers = new ArrayList<AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher>(param3List.size());
/*  1183 */           for (Iterator<? extends AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> iterator = param3List.iterator(); iterator.hasNext(); ) {
/*  1184 */             AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher; if (resubmissionImmediateMatcher = iterator.next() instanceof Conjunction) {
/*  1185 */               this.matchers.addAll(((Conjunction)resubmissionImmediateMatcher).matchers); continue;
/*  1186 */             }  if (resubmissionImmediateMatcher != AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher.Trivial.NON_MATCHING) {
/*  1187 */               this.matchers.add(resubmissionImmediateMatcher);
/*       */             }
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  1196 */           for (Iterator<AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> iterator = this.matchers.iterator(); iterator.hasNext();) {
/*  1197 */             if (!(resubmissionImmediateMatcher = iterator.next()).matches(param3String, param3ClassLoader, param3JavaModule)) {
/*  1198 */               return false;
/*       */             }
/*       */           } 
/*  1201 */           return true;
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matchers.equals(((Conjunction)param3Object).matchers))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.matchers.hashCode();
/*       */         }
/*       */       }
/*       */       
/*       */       @Enhance
/*       */       public static class Disjunction
/*       */         implements ResubmissionImmediateMatcher
/*       */       {
/*       */         private final List<AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> matchers;
/*       */         
/*       */         public Disjunction(AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher... param3VarArgs) {
/*  1222 */           this(Arrays.asList(param3VarArgs));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Disjunction(List<? extends AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> param3List) {
/*  1231 */           this.matchers = new ArrayList<AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher>(param3List.size());
/*  1232 */           for (Iterator<? extends AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> iterator = param3List.iterator(); iterator.hasNext(); ) {
/*  1233 */             AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher; if (resubmissionImmediateMatcher = iterator.next() instanceof Disjunction) {
/*  1234 */               this.matchers.addAll(((Disjunction)resubmissionImmediateMatcher).matchers); continue;
/*  1235 */             }  if (resubmissionImmediateMatcher != AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher.Trivial.NON_MATCHING) {
/*  1236 */               this.matchers.add(resubmissionImmediateMatcher);
/*       */             }
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  1245 */           for (Iterator<AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher> iterator = this.matchers.iterator(); iterator.hasNext();) {
/*  1246 */             if ((resubmissionImmediateMatcher = iterator.next()).matches(param3String, param3ClassLoader, param3JavaModule)) {
/*  1247 */               return true;
/*       */             }
/*       */           } 
/*  1250 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matchers.equals(((Disjunction)param3Object).matchers))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.matchers.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForElementMatchers
/*       */         implements ResubmissionImmediateMatcher
/*       */       {
/*       */         private final ElementMatcher<String> typeNameMatcher;
/*       */ 
/*       */         
/*       */         private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
/*       */ 
/*       */         
/*       */         private final ElementMatcher<? super JavaModule> moduleMatcher;
/*       */ 
/*       */ 
/*       */         
/*       */         public ForElementMatchers(ElementMatcher<String> param3ElementMatcher, ElementMatcher<? super ClassLoader> param3ElementMatcher1, ElementMatcher<? super JavaModule> param3ElementMatcher2) {
/*  1285 */           this.typeNameMatcher = param3ElementMatcher;
/*  1286 */           this.classLoaderMatcher = param3ElementMatcher1;
/*  1287 */           this.moduleMatcher = param3ElementMatcher2;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  1294 */           if (this.typeNameMatcher.matches(param3String) && this.classLoaderMatcher
/*  1295 */             .matches(param3ClassLoader) && this.moduleMatcher
/*  1296 */             .matches(param3JavaModule)) return true;
/*       */           
/*       */           return false;
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
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typeNameMatcher.equals(((ForElementMatchers)param3Object).typeNameMatcher) ? false : (!this.classLoaderMatcher.equals(((ForElementMatchers)param3Object).classLoaderMatcher) ? false : (!!this.moduleMatcher.equals(((ForElementMatchers)param3Object).moduleMatcher))))));
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
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.typeNameMatcher.hashCode()) * 31 + this.classLoaderMatcher.hashCode()) * 31 + this.moduleMatcher.hashCode();
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
/*       */     public static interface WithoutResubmissionSpecification
/*       */     {
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param2ElementMatcher);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param2ElementMatcher, ElementMatcher<String> param2ElementMatcher1);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param2ElementMatcher, ElementMatcher<String> param2ElementMatcher1, ElementMatcher<? super ClassLoader> param2ElementMatcher2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param2ElementMatcher, ElementMatcher<String> param2ElementMatcher1, ElementMatcher<? super ClassLoader> param2ElementMatcher2, ElementMatcher<? super JavaModule> param2ElementMatcher3);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher param2ResubmissionOnErrorMatcher);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> param2ElementMatcher);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1, ElementMatcher<? super JavaModule> param2ElementMatcher2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher param2ResubmissionImmediateMatcher);
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
/*       */     public static interface WithResubmissionSpecification
/*       */       extends AgentBuilder, WithoutResubmissionSpecification {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface WithImplicitDiscoveryStrategy
/*       */       extends RedefinitionListenable
/*       */     {
/*       */       AgentBuilder.RedefinitionListenable redefineOnly(Class<?>... param2VarArgs);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AgentBuilder.RedefinitionListenable with(AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param2DiscoveryStrategy);
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
/*       */     public static interface WithoutBatchStrategy
/*       */       extends WithImplicitDiscoveryStrategy
/*       */     {
/*       */       AgentBuilder.RedefinitionListenable.WithImplicitDiscoveryStrategy with(AgentBuilder.RedefinitionStrategy.BatchAllocator param2BatchAllocator);
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
/*       */   public static interface Identified
/*       */   {
/*       */     Extendable transform(AgentBuilder.Transformer param1Transformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Extendable
/*       */       extends AgentBuilder, Identified
/*       */     {
/*       */       AgentBuilder asTerminalTransformation();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Narrowable
/*       */       extends Identified, AgentBuilder.Matchable<Narrowable> {}
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface RawMatcher
/*       */   {
/*       */     boolean matches(TypeDescription param1TypeDescription, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, @MaybeNull Class<?> param1Class, ProtectionDomain param1ProtectionDomain);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Trivial
/*       */       implements RawMatcher
/*       */     {
/*  1547 */       MATCHING(true),
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  1552 */       NON_MATCHING(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean matches;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Trivial(boolean param2Boolean) {
/*  1565 */         this.matches = param2Boolean;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/*  1576 */         return this.matches;
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum ForLoadState
/*       */       implements RawMatcher
/*       */     {
/*  1588 */       LOADED(false),
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  1593 */       UNLOADED(true);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean unloaded;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       ForLoadState(boolean param2Boolean) {
/*  1606 */         this.unloaded = param2Boolean;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/*  1617 */         return (((param2Class == null)) == this.unloaded);
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum ForResolvableTypes
/*       */       implements RawMatcher
/*       */     {
/*  1630 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/*  1640 */         if (param2Class != null) {
/*       */           try {
/*  1642 */             return (Class.forName(param2Class.getName(), true, param2ClassLoader) == param2Class);
/*  1643 */           } catch (Throwable throwable) {
/*  1644 */             return false;
/*       */           } 
/*       */         }
/*  1647 */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final AgentBuilder.RawMatcher inverted() {
/*  1657 */         return new AgentBuilder.RawMatcher.Inversion(this);
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Conjunction
/*       */       implements RawMatcher
/*       */     {
/*       */       private final List<AgentBuilder.RawMatcher> matchers;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Conjunction(AgentBuilder.RawMatcher... param2VarArgs) {
/*  1678 */         this(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Conjunction(List<? extends AgentBuilder.RawMatcher> param2List) {
/*  1687 */         this.matchers = new ArrayList<AgentBuilder.RawMatcher>(param2List.size());
/*  1688 */         for (Iterator<? extends AgentBuilder.RawMatcher> iterator = param2List.iterator(); iterator.hasNext(); ) {
/*  1689 */           AgentBuilder.RawMatcher rawMatcher; if (rawMatcher = iterator.next() instanceof Conjunction) {
/*  1690 */             this.matchers.addAll(((Conjunction)rawMatcher).matchers); continue;
/*  1691 */           }  if (rawMatcher != AgentBuilder.RawMatcher.Trivial.MATCHING) {
/*  1692 */             this.matchers.add(rawMatcher);
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
/*       */       public boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/*  1705 */         for (Iterator<AgentBuilder.RawMatcher> iterator = this.matchers.iterator(); iterator.hasNext();) {
/*  1706 */           if (!(rawMatcher = iterator.next()).matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain)) {
/*  1707 */             return false;
/*       */           }
/*       */         } 
/*  1710 */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.matchers.equals(((Conjunction)param2Object).matchers))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.matchers.hashCode();
/*       */       }
/*       */     }
/*       */     
/*       */     @Enhance
/*       */     public static class Disjunction
/*       */       implements RawMatcher
/*       */     {
/*       */       private final List<AgentBuilder.RawMatcher> matchers;
/*       */       
/*       */       protected Disjunction(AgentBuilder.RawMatcher... param2VarArgs) {
/*  1731 */         this(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Disjunction(List<? extends AgentBuilder.RawMatcher> param2List) {
/*  1740 */         this.matchers = new ArrayList<AgentBuilder.RawMatcher>(param2List.size());
/*  1741 */         for (Iterator<? extends AgentBuilder.RawMatcher> iterator = param2List.iterator(); iterator.hasNext(); ) {
/*  1742 */           AgentBuilder.RawMatcher rawMatcher; if (rawMatcher = iterator.next() instanceof Disjunction) {
/*  1743 */             this.matchers.addAll(((Disjunction)rawMatcher).matchers); continue;
/*  1744 */           }  if (rawMatcher != AgentBuilder.RawMatcher.Trivial.NON_MATCHING) {
/*  1745 */             this.matchers.add(rawMatcher);
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
/*       */       public boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/*  1758 */         for (Iterator<AgentBuilder.RawMatcher> iterator = this.matchers.iterator(); iterator.hasNext();) {
/*  1759 */           if ((rawMatcher = iterator.next()).matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain)) {
/*  1760 */             return true;
/*       */           }
/*       */         } 
/*  1763 */         return false;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.matchers.equals(((Disjunction)param2Object).matchers))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.matchers.hashCode();
/*       */       }
/*       */     }
/*       */     
/*       */     @Enhance
/*       */     public static class Inversion
/*       */       implements RawMatcher
/*       */     {
/*       */       private final AgentBuilder.RawMatcher matcher;
/*       */       
/*       */       public Inversion(AgentBuilder.RawMatcher param2RawMatcher) {
/*  1784 */         this.matcher = param2RawMatcher;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/*  1795 */         return !this.matcher.matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.matcher.equals(((Inversion)param2Object).matcher))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.matcher.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForElementMatchers
/*       */       implements RawMatcher
/*       */     {
/*       */       private final ElementMatcher<? super TypeDescription> typeMatcher;
/*       */ 
/*       */       
/*       */       private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
/*       */ 
/*       */       
/*       */       private final ElementMatcher<? super JavaModule> moduleMatcher;
/*       */ 
/*       */ 
/*       */       
/*       */       public ForElementMatchers(ElementMatcher<? super TypeDescription> param2ElementMatcher) {
/*  1830 */         this(param2ElementMatcher, (ElementMatcher<? super ClassLoader>)ElementMatchers.any());
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
/*       */       public ForElementMatchers(ElementMatcher<? super TypeDescription> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1) {
/*  1843 */         this(param2ElementMatcher, param2ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.any());
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
/*       */       public ForElementMatchers(ElementMatcher<? super TypeDescription> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1, ElementMatcher<? super JavaModule> param2ElementMatcher2) {
/*  1858 */         this.typeMatcher = param2ElementMatcher;
/*  1859 */         this.classLoaderMatcher = param2ElementMatcher1;
/*  1860 */         this.moduleMatcher = param2ElementMatcher2;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/*  1871 */         return (this.moduleMatcher.matches(param2JavaModule) && this.classLoaderMatcher.matches(param2ClassLoader) && this.typeMatcher.matches(param2TypeDescription));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typeMatcher.equals(((ForElementMatchers)param2Object).typeMatcher) ? false : (!this.classLoaderMatcher.equals(((ForElementMatchers)param2Object).classLoaderMatcher) ? false : (!!this.moduleMatcher.equals(((ForElementMatchers)param2Object).moduleMatcher))))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.typeMatcher.hashCode()) * 31 + this.classLoaderMatcher.hashCode()) * 31 + this.moduleMatcher.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface Listener
/*       */   {
/*       */     public static final boolean LOADED = true;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onDiscovery(String param1String, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, boolean param1Boolean);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onTransformation(TypeDescription param1TypeDescription, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, boolean param1Boolean, DynamicType param1DynamicType);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onIgnored(TypeDescription param1TypeDescription, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, boolean param1Boolean);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onError(String param1String, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, boolean param1Boolean, Throwable param1Throwable);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onComplete(String param1String, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, boolean param1Boolean);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements Listener
/*       */     {
/*  1946 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onDiscovery(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onTransformation(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, DynamicType param2DynamicType) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onIgnored(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onError(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, Throwable param2Throwable) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onComplete(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class Adapter
/*       */       implements Listener
/*       */     {
/*       */       public void onDiscovery(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onTransformation(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, DynamicType param2DynamicType) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onIgnored(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onError(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, Throwable param2Throwable) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onComplete(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class StreamWriting
/*       */       implements Listener
/*       */     {
/*       */       protected static final String PREFIX = "[Byte Buddy]";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final PrintStream printStream;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StreamWriting(PrintStream param2PrintStream) {
/*  2048 */         this.printStream = param2PrintStream;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static StreamWriting toSystemOut() {
/*  2057 */         return new StreamWriting(System.out);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static StreamWriting toSystemError() {
/*  2066 */         return new StreamWriting(System.err);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Listener withTransformationsOnly() {
/*  2075 */         return new AgentBuilder.Listener.WithTransformationsOnly(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Listener withErrorsOnly() {
/*  2084 */         return new AgentBuilder.Listener.WithErrorsOnly(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onDiscovery(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2091 */         this.printStream.printf("[Byte Buddy] DISCOVERY %s [%s, %s, %s, loaded=%b]%n", new Object[] { param2String, param2ClassLoader, param2JavaModule, Thread.currentThread(), Boolean.valueOf(param2Boolean) });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onTransformation(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, DynamicType param2DynamicType) {
/*  2098 */         this.printStream.printf("[Byte Buddy] TRANSFORM %s [%s, %s, %s, loaded=%b]%n", new Object[] { param2TypeDescription.getName(), param2ClassLoader, param2JavaModule, Thread.currentThread(), Boolean.valueOf(param2Boolean) });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onIgnored(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2105 */         this.printStream.printf("[Byte Buddy] IGNORE %s [%s, %s, %s, loaded=%b]%n", new Object[] { param2TypeDescription.getName(), param2ClassLoader, param2JavaModule, Thread.currentThread(), Boolean.valueOf(param2Boolean) });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onError(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, Throwable param2Throwable) {
/*  2112 */         synchronized (this.printStream) {
/*  2113 */           this.printStream.printf("[Byte Buddy] ERROR %s [%s, %s, %s, loaded=%b]%n", new Object[] { param2String, param2ClassLoader, param2JavaModule, Thread.currentThread(), Boolean.valueOf(param2Boolean) });
/*  2114 */           param2Throwable.printStackTrace(this.printStream);
/*       */           return;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public void onComplete(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2122 */         this.printStream.printf("[Byte Buddy] COMPLETE %s [%s, %s, %s, loaded=%b]%n", new Object[] { param2String, param2ClassLoader, param2JavaModule, Thread.currentThread(), Boolean.valueOf(param2Boolean) });
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.printStream.equals(((StreamWriting)param2Object).printStream))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.printStream.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Filtering
/*       */       implements Listener
/*       */     {
/*       */       private final ElementMatcher<? super String> matcher;
/*       */       
/*       */       private final AgentBuilder.Listener delegate;
/*       */ 
/*       */       
/*       */       public Filtering(ElementMatcher<? super String> param2ElementMatcher, AgentBuilder.Listener param2Listener) {
/*  2149 */         this.matcher = param2ElementMatcher;
/*  2150 */         this.delegate = param2Listener;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onDiscovery(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2157 */         if (this.matcher.matches(param2String)) {
/*  2158 */           this.delegate.onDiscovery(param2String, param2ClassLoader, param2JavaModule, param2Boolean);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onTransformation(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, DynamicType param2DynamicType) {
/*  2166 */         if (this.matcher.matches(param2TypeDescription.getName())) {
/*  2167 */           this.delegate.onTransformation(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Boolean, param2DynamicType);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onIgnored(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2175 */         if (this.matcher.matches(param2TypeDescription.getName())) {
/*  2176 */           this.delegate.onIgnored(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Boolean);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onError(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, Throwable param2Throwable) {
/*  2184 */         if (this.matcher.matches(param2String)) {
/*  2185 */           this.delegate.onError(param2String, param2ClassLoader, param2JavaModule, param2Boolean, param2Throwable);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onComplete(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2193 */         if (this.matcher.matches(param2String)) {
/*  2194 */           this.delegate.onComplete(param2String, param2ClassLoader, param2JavaModule, param2Boolean);
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.matcher.equals(((Filtering)param2Object).matcher) ? false : (!!this.delegate.equals(((Filtering)param2Object).delegate)))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.delegate.hashCode();
/*       */       }
/*       */     }
/*       */     
/*       */     @Enhance
/*       */     public static class WithTransformationsOnly
/*       */       extends Adapter
/*       */     {
/*       */       private final AgentBuilder.Listener delegate;
/*       */       
/*       */       public WithTransformationsOnly(AgentBuilder.Listener param2Listener) {
/*  2216 */         this.delegate = param2Listener;
/*       */       }
/*       */ 
/*       */       
/*       */       public void onTransformation(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, DynamicType param2DynamicType) {
/*  2221 */         this.delegate.onTransformation(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Boolean, param2DynamicType);
/*       */       }
/*       */ 
/*       */       
/*       */       public void onError(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, Throwable param2Throwable) {
/*  2226 */         this.delegate.onError(param2String, param2ClassLoader, param2JavaModule, param2Boolean, param2Throwable);
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.delegate.equals(((WithTransformationsOnly)param2Object).delegate))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.delegate.hashCode();
/*       */       }
/*       */     }
/*       */     
/*       */     @Enhance
/*       */     public static class WithErrorsOnly
/*       */       extends Adapter
/*       */     {
/*       */       private final AgentBuilder.Listener delegate;
/*       */       
/*       */       public WithErrorsOnly(AgentBuilder.Listener param2Listener) {
/*  2247 */         this.delegate = param2Listener;
/*       */       }
/*       */ 
/*       */       
/*       */       public void onError(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, Throwable param2Throwable) {
/*  2252 */         this.delegate.onError(param2String, param2ClassLoader, param2JavaModule, param2Boolean, param2Throwable);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.delegate.equals(((WithErrorsOnly)param2Object).delegate))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.delegate.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ModuleReadEdgeCompleting
/*       */       extends Adapter
/*       */     {
/*       */       private final Instrumentation instrumentation;
/*       */ 
/*       */       
/*       */       private final boolean addTargetEdge;
/*       */ 
/*       */       
/*       */       private final Set<? extends JavaModule> modules;
/*       */ 
/*       */ 
/*       */       
/*       */       public ModuleReadEdgeCompleting(Instrumentation param2Instrumentation, boolean param2Boolean, Set<? extends JavaModule> param2Set) {
/*  2288 */         this.instrumentation = param2Instrumentation;
/*  2289 */         this.addTargetEdge = param2Boolean;
/*  2290 */         this.modules = param2Set;
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
/*       */       public static AgentBuilder.Listener of(Instrumentation param2Instrumentation, boolean param2Boolean, Class<?>... param2VarArgs) {
/*  2304 */         HashSet<JavaModule> hashSet = new HashSet(); int i; byte b;
/*  2305 */         for (i = (param2VarArgs = param2VarArgs).length, b = 0; b < i; ) { Class<?> clazz = param2VarArgs[b];
/*  2306 */           hashSet.add(JavaModule.ofType(clazz)); b++; }
/*       */         
/*  2308 */         return (AgentBuilder.Listener)(hashSet.isEmpty() ? AgentBuilder.Listener.NoOp.INSTANCE : new ModuleReadEdgeCompleting(param2Instrumentation, param2Boolean, hashSet));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onTransformation(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, DynamicType param2DynamicType) {
/*  2315 */         if (param2JavaModule != JavaModule.UNSUPPORTED && param2JavaModule.isNamed()) {
/*  2316 */           for (JavaModule javaModule : this.modules) {
/*  2317 */             if (!param2JavaModule.canRead(javaModule) || (this.addTargetEdge && !param2JavaModule.isOpened(param2TypeDescription.getPackage(), javaModule))) {
/*  2318 */               PackageDescription packageDescription = param2TypeDescription.getPackage();
/*  2319 */               ClassInjector.UsingInstrumentation.redefineModule(this.instrumentation, param2JavaModule, 
/*       */                   
/*  2321 */                   Collections.singleton(javaModule), 
/*  2322 */                   Collections.emptyMap(), (!this.addTargetEdge || packageDescription == null || packageDescription
/*  2323 */                   .isDefault()) ? 
/*  2324 */                   Collections.emptyMap() : 
/*  2325 */                   Collections.singletonMap(packageDescription.getName(), Collections.singleton(javaModule)), 
/*  2326 */                   Collections.emptySet(), 
/*  2327 */                   Collections.emptyMap());
/*       */             } 
/*  2329 */             if (this.addTargetEdge && !javaModule.canRead(param2JavaModule)) {
/*  2330 */               ClassInjector.UsingInstrumentation.redefineModule(this.instrumentation, javaModule, 
/*       */                   
/*  2332 */                   Collections.singleton(param2JavaModule), 
/*  2333 */                   Collections.emptyMap(), 
/*  2334 */                   Collections.emptyMap(), 
/*  2335 */                   Collections.emptySet(), 
/*  2336 */                   Collections.emptyMap());
/*       */             }
/*       */           } 
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.addTargetEdge != ((ModuleReadEdgeCompleting)param2Object).addTargetEdge) ? false : (!this.instrumentation.equals(((ModuleReadEdgeCompleting)param2Object).instrumentation) ? false : (!!this.modules.equals(((ModuleReadEdgeCompleting)param2Object).modules))))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.instrumentation.hashCode()) * 31 + this.addTargetEdge) * 31 + this.modules.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Compound
/*       */       implements Listener
/*       */     {
/*       */       public Compound(AgentBuilder.Listener... param2VarArgs) {
/*  2360 */         this(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2369 */       private final List<AgentBuilder.Listener> listeners = new ArrayList<AgentBuilder.Listener>(); public Compound(List<? extends AgentBuilder.Listener> param2List) {
/*  2370 */         for (Iterator<? extends AgentBuilder.Listener> iterator = param2List.iterator(); iterator.hasNext(); ) {
/*  2371 */           AgentBuilder.Listener listener; if (listener = iterator.next() instanceof Compound) {
/*  2372 */             this.listeners.addAll(((Compound)listener).listeners); continue;
/*  2373 */           }  if (!(listener instanceof AgentBuilder.Listener.NoOp)) {
/*  2374 */             this.listeners.add(listener);
/*       */           }
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onDiscovery(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2383 */         for (Iterator<AgentBuilder.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/*  2384 */           (listener = iterator.next()).onDiscovery(param2String, param2ClassLoader, param2JavaModule, param2Boolean);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onTransformation(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, DynamicType param2DynamicType) {
/*  2392 */         for (Iterator<AgentBuilder.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/*  2393 */           (listener = iterator.next()).onTransformation(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Boolean, param2DynamicType);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onIgnored(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2401 */         for (Iterator<AgentBuilder.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/*  2402 */           (listener = iterator.next()).onIgnored(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Boolean);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onError(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean, Throwable param2Throwable) {
/*  2410 */         for (Iterator<AgentBuilder.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/*  2411 */           (listener = iterator.next()).onError(param2String, param2ClassLoader, param2JavaModule, param2Boolean, param2Throwable);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onComplete(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  2419 */         for (Iterator<AgentBuilder.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/*  2420 */           (listener = iterator.next()).onComplete(param2String, param2ClassLoader, param2JavaModule, param2Boolean);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.listeners.equals(((Compound)param2Object).listeners))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.listeners.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface CircularityLock
/*       */   {
/*       */     boolean acquire();
/*       */ 
/*       */ 
/*       */     
/*       */     void release();
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Inactive
/*       */       implements CircularityLock
/*       */     {
/*  2454 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean acquire() {
/*  2460 */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void release() {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static class Default
/*       */       implements CircularityLock
/*       */     {
/*  2483 */       private final ConcurrentMap<Thread, Boolean> threads = new ConcurrentHashMap<Thread, Boolean>();
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean acquire() {
/*  2489 */         return (this.threads.putIfAbsent(Thread.currentThread(), Boolean.TRUE) == null);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void release() {
/*  2496 */         this.threads.remove(Thread.currentThread());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected boolean isLocked() {
/*  2505 */         return this.threads.containsKey(Thread.currentThread());
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Global
/*       */       implements CircularityLock
/*       */     {
/*       */       private final Lock lock;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final long time;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TimeUnit timeUnit;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Global() {
/*  2534 */         this(0L, TimeUnit.MILLISECONDS);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Global(long param2Long, TimeUnit param2TimeUnit) {
/*  2544 */         this.lock = new ReentrantLock();
/*  2545 */         this.time = param2Long;
/*  2546 */         this.timeUnit = param2TimeUnit;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean acquire() {
/*       */         try {
/*  2554 */           if (this.time == 0L)
/*  2555 */             return this.lock.tryLock();  return this.lock
/*  2556 */             .tryLock(this.time, this.timeUnit);
/*  2557 */         } catch (InterruptedException interruptedException) {
/*  2558 */           return false;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void release() {
/*  2566 */         this.lock.unlock();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.time != ((Global)param2Object).time) ? false : (!this.timeUnit.equals(((Global)param2Object).timeUnit) ? false : (!!this.lock.equals(((Global)param2Object).lock))))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.lock.hashCode()) * 31 + (int)(this.time ^ this.time >>> 32L)) * 31 + this.timeUnit.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface TypeStrategy
/*       */   {
/*       */     DynamicType.Builder<?> builder(TypeDescription param1TypeDescription, ByteBuddy param1ByteBuddy, ClassFileLocator param1ClassFileLocator, MethodNameTransformer param1MethodNameTransformer, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, @MaybeNull ProtectionDomain param1ProtectionDomain);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Default
/*       */       implements TypeStrategy
/*       */     {
/*  2604 */       REBASE
/*       */       {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final DynamicType.Builder<?> builder(TypeDescription param3TypeDescription, ByteBuddy param3ByteBuddy, ClassFileLocator param3ClassFileLocator, MethodNameTransformer param3MethodNameTransformer, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull ProtectionDomain param3ProtectionDomain)
/*       */         {
/*  2613 */           return param3ByteBuddy.rebase(param3TypeDescription, param3ClassFileLocator, param3MethodNameTransformer);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2630 */       REDEFINE
/*       */       {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final DynamicType.Builder<?> builder(TypeDescription param3TypeDescription, ByteBuddy param3ByteBuddy, ClassFileLocator param3ClassFileLocator, MethodNameTransformer param3MethodNameTransformer, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull ProtectionDomain param3ProtectionDomain)
/*       */         {
/*  2639 */           return param3ByteBuddy.redefine(param3TypeDescription, param3ClassFileLocator);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2657 */       REDEFINE_FROZEN
/*       */       {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final DynamicType.Builder<?> builder(TypeDescription param3TypeDescription, ByteBuddy param3ByteBuddy, ClassFileLocator param3ClassFileLocator, MethodNameTransformer param3MethodNameTransformer, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull ProtectionDomain param3ProtectionDomain)
/*       */         {
/*  2666 */           return param3ByteBuddy.with((InstrumentedType.Factory)InstrumentedType.Factory.Default.FROZEN)
/*  2667 */             .with((VisibilityBridgeStrategy)VisibilityBridgeStrategy.Default.NEVER)
/*  2668 */             .redefine(param3TypeDescription, param3ClassFileLocator)
/*  2669 */             .ignoreAlso((LatentMatcher)LatentMatcher.ForSelfDeclaredMethod.NOT_DECLARED);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  2690 */       DECORATE
/*       */       {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final DynamicType.Builder<?> builder(TypeDescription param3TypeDescription, ByteBuddy param3ByteBuddy, ClassFileLocator param3ClassFileLocator, MethodNameTransformer param3MethodNameTransformer, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull ProtectionDomain param3ProtectionDomain)
/*       */         {
/*  2699 */           return param3ByteBuddy.decorate(param3TypeDescription, param3ClassFileLocator);
/*       */         }
/*       */       };
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForBuildEntryPoint
/*       */       implements TypeStrategy
/*       */     {
/*       */       private final EntryPoint entryPoint;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForBuildEntryPoint(EntryPoint param2EntryPoint) {
/*  2721 */         this.entryPoint = param2EntryPoint;
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
/*       */       public DynamicType.Builder<?> builder(TypeDescription param2TypeDescription, ByteBuddy param2ByteBuddy, ClassFileLocator param2ClassFileLocator, MethodNameTransformer param2MethodNameTransformer, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull ProtectionDomain param2ProtectionDomain) {
/*  2734 */         return this.entryPoint.transform(param2TypeDescription, param2ByteBuddy, param2ClassFileLocator, param2MethodNameTransformer);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.entryPoint.equals(((ForBuildEntryPoint)param2Object).entryPoint))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.entryPoint.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface Transformer
/*       */   {
/*       */     DynamicType.Builder<?> transform(DynamicType.Builder<?> param1Builder, TypeDescription param1TypeDescription, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, ProtectionDomain param1ProtectionDomain);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForBuildPlugin
/*       */       implements Transformer
/*       */     {
/*       */       private final Plugin plugin;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForBuildPlugin(Plugin param2Plugin) {
/*  2779 */         this.plugin = param2Plugin;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public DynamicType.Builder<?> transform(DynamicType.Builder<?> param2Builder, TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, ProtectionDomain param2ProtectionDomain) {
/*  2790 */         return this.plugin.apply(param2Builder, param2TypeDescription, ClassFileLocator.ForClassLoader.of(param2ClassLoader));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.plugin.equals(((ForBuildPlugin)param2Object).plugin))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.plugin.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class ForAdvice
/*       */       implements Transformer
/*       */     {
/*       */       private final Advice.WithCustomMapping advice;
/*       */ 
/*       */ 
/*       */       
/*       */       private final Advice.ExceptionHandler exceptionHandler;
/*       */ 
/*       */ 
/*       */       
/*       */       private final Assigner assigner;
/*       */ 
/*       */ 
/*       */       
/*       */       private final ClassFileLocator classFileLocator;
/*       */ 
/*       */ 
/*       */       
/*       */       private final AgentBuilder.PoolStrategy poolStrategy;
/*       */ 
/*       */ 
/*       */       
/*       */       private final AgentBuilder.LocationStrategy locationStrategy;
/*       */ 
/*       */       
/*       */       private final List<Entry> entries;
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice() {
/*  2843 */         this(Advice.withCustomMapping());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice(Advice.WithCustomMapping param2WithCustomMapping) {
/*  2852 */         this(param2WithCustomMapping, (Advice.ExceptionHandler)Advice.ExceptionHandler.Default.SUPPRESSING, Assigner.DEFAULT, (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE, AgentBuilder.PoolStrategy.Default.FAST, AgentBuilder.LocationStrategy.ForClassLoader.STRONG, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  2858 */             Collections.emptyList());
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
/*       */       protected ForAdvice(Advice.WithCustomMapping param2WithCustomMapping, Advice.ExceptionHandler param2ExceptionHandler, Assigner param2Assigner, ClassFileLocator param2ClassFileLocator, AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, List<Entry> param2List) {
/*  2879 */         this.advice = param2WithCustomMapping;
/*  2880 */         this.exceptionHandler = param2ExceptionHandler;
/*  2881 */         this.assigner = param2Assigner;
/*  2882 */         this.classFileLocator = param2ClassFileLocator;
/*  2883 */         this.poolStrategy = param2PoolStrategy;
/*  2884 */         this.locationStrategy = param2LocationStrategy;
/*  2885 */         this.entries = param2List;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public DynamicType.Builder<?> transform(DynamicType.Builder<?> param2Builder, TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, ProtectionDomain param2ProtectionDomain) {
/*  2896 */         ClassFileLocator.Compound compound = new ClassFileLocator.Compound(new ClassFileLocator[] { this.classFileLocator, this.locationStrategy.classFileLocator(param2ClassLoader, param2JavaModule) });
/*  2897 */         TypePool typePool = this.poolStrategy.typePool((ClassFileLocator)compound, param2ClassLoader);
/*  2898 */         AsmVisitorWrapper.ForDeclaredMethods forDeclaredMethods = new AsmVisitorWrapper.ForDeclaredMethods();
/*  2899 */         for (Entry entry : this.entries) {
/*  2900 */           forDeclaredMethods = forDeclaredMethods.invokable(entry.getMatcher().resolve(param2TypeDescription), new AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper[] { (AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper)entry.resolve(this.advice, typePool, (ClassFileLocator)compound)
/*  2901 */                 .withAssigner(this.assigner)
/*  2902 */                 .withExceptionHandler(this.exceptionHandler) });
/*       */         } 
/*  2904 */         return param2Builder.visit((AsmVisitorWrapper)forDeclaredMethods);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice with(AgentBuilder.PoolStrategy param2PoolStrategy) {
/*  2914 */         return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, param2PoolStrategy, this.locationStrategy, this.entries);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice with(AgentBuilder.LocationStrategy param2LocationStrategy) {
/*  2925 */         return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, param2LocationStrategy, this.entries);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice withExceptionHandler(Advice.ExceptionHandler param2ExceptionHandler) {
/*  2936 */         return new ForAdvice(this.advice, param2ExceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, this.entries);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice with(Assigner param2Assigner) {
/*  2947 */         return new ForAdvice(this.advice, this.exceptionHandler, param2Assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, this.entries);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice include(ClassLoader... param2VarArgs) {
/*  2958 */         LinkedHashSet<ClassFileLocator> linkedHashSet = new LinkedHashSet(); int i; byte b;
/*  2959 */         for (i = (param2VarArgs = param2VarArgs).length, b = 0; b < i; ) { ClassLoader classLoader = param2VarArgs[b];
/*  2960 */           linkedHashSet.add(ClassFileLocator.ForClassLoader.of(classLoader)); b++; }
/*       */         
/*  2962 */         return include(new ArrayList<ClassFileLocator>(linkedHashSet));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice include(ClassFileLocator... param2VarArgs) {
/*  2973 */         return include(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ForAdvice include(List<? extends ClassFileLocator> param2List) {
/*  2984 */         return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, (ClassFileLocator)new ClassFileLocator.Compound(
/*       */ 
/*       */               
/*  2987 */               CompoundList.of(this.classFileLocator, param2List)), this.poolStrategy, this.locationStrategy, this.entries);
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
/*       */       public ForAdvice advice(ElementMatcher<? super MethodDescription> param2ElementMatcher, String param2String) {
/*  3002 */         return advice((LatentMatcher<? super MethodDescription>)new LatentMatcher.Resolved(param2ElementMatcher), param2String);
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
/*       */       public ForAdvice advice(LatentMatcher<? super MethodDescription> param2LatentMatcher, String param2String) {
/*  3014 */         return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  3020 */             CompoundList.of(this.entries, new Entry.ForUnifiedAdvice(param2LatentMatcher, param2String)));
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
/*       */       public ForAdvice advice(ElementMatcher<? super MethodDescription> param2ElementMatcher, String param2String1, String param2String2) {
/*  3033 */         return advice((LatentMatcher<? super MethodDescription>)new LatentMatcher.Resolved(param2ElementMatcher), param2String1, param2String2);
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
/*       */       public ForAdvice advice(LatentMatcher<? super MethodDescription> param2LatentMatcher, String param2String1, String param2String2) {
/*  3046 */         return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  3052 */             CompoundList.of(this.entries, new Entry.ForSplitAdvice(param2LatentMatcher, param2String1, param2String2)));
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.advice.equals(((ForAdvice)param2Object).advice) ? false : (!this.exceptionHandler.equals(((ForAdvice)param2Object).exceptionHandler) ? false : (!this.assigner.equals(((ForAdvice)param2Object).assigner) ? false : (!this.classFileLocator.equals(((ForAdvice)param2Object).classFileLocator) ? false : (!this.poolStrategy.equals(((ForAdvice)param2Object).poolStrategy) ? false : (!this.locationStrategy.equals(((ForAdvice)param2Object).locationStrategy) ? false : (!!this.entries.equals(((ForAdvice)param2Object).entries))))))))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((((((getClass().hashCode() * 31 + this.advice.hashCode()) * 31 + this.exceptionHandler.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.classFileLocator.hashCode()) * 31 + this.poolStrategy.hashCode()) * 31 + this.locationStrategy.hashCode()) * 31 + this.entries.hashCode();
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static abstract class Entry
/*       */       {
/*       */         private final LatentMatcher<? super MethodDescription> matcher;
/*       */         
/*       */         protected Entry(LatentMatcher<? super MethodDescription> param3LatentMatcher) {
/*  3072 */           this.matcher = param3LatentMatcher;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected LatentMatcher<? super MethodDescription> getMatcher() {
/*  3081 */           return this.matcher;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract Advice resolve(Advice.WithCustomMapping param3WithCustomMapping, TypePool param3TypePool, ClassFileLocator param3ClassFileLocator);
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matcher.equals(((Entry)param3Object).matcher))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.matcher.hashCode();
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class ForUnifiedAdvice
/*       */           extends Entry
/*       */         {
/*       */           protected final String name;
/*       */ 
/*       */ 
/*       */           
/*       */           protected ForUnifiedAdvice(LatentMatcher<? super MethodDescription> param4LatentMatcher, String param4String) {
/*  3112 */             super(param4LatentMatcher);
/*  3113 */             this.name = param4String;
/*       */           }
/*       */ 
/*       */           
/*       */           protected Advice resolve(Advice.WithCustomMapping param4WithCustomMapping, TypePool param4TypePool, ClassFileLocator param4ClassFileLocator) {
/*  3118 */             return param4WithCustomMapping.to(param4TypePool.describe(this.name).resolve(), param4ClassFileLocator);
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.name.equals(((ForUnifiedAdvice)param4Object).name)))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return super.hashCode() * 31 + this.name.hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class ForSplitAdvice
/*       */           extends Entry
/*       */         {
/*       */           private final String enter;
/*       */           
/*       */           private final String exit;
/*       */ 
/*       */           
/*       */           protected ForSplitAdvice(LatentMatcher<? super MethodDescription> param4LatentMatcher, String param4String1, String param4String2) {
/*  3146 */             super(param4LatentMatcher);
/*  3147 */             this.enter = param4String1;
/*  3148 */             this.exit = param4String2;
/*       */           }
/*       */           
/*       */           protected Advice resolve(Advice.WithCustomMapping param4WithCustomMapping, TypePool param4TypePool, ClassFileLocator param4ClassFileLocator)
/*       */           {
/*  3153 */             return param4WithCustomMapping.to(param4TypePool.describe(this.enter).resolve(), param4TypePool.describe(this.exit).resolve(), param4ClassFileLocator); } public boolean equals(@MaybeNull Object param4Object) { return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.enter.equals(((ForSplitAdvice)param4Object).enter) ? false : (!!this.exit.equals(((ForSplitAdvice)param4Object).exit)))))); } public int hashCode() { return (super.hashCode() * 31 + this.enter.hashCode()) * 31 + this.exit.hashCode(); } } } @Enhance protected static class ForUnifiedAdvice extends Entry { protected final String name; protected ForUnifiedAdvice(LatentMatcher<? super MethodDescription> param3LatentMatcher, String param3String) { super(param3LatentMatcher); this.name = param3String; } protected Advice resolve(Advice.WithCustomMapping param3WithCustomMapping, TypePool param3TypePool, ClassFileLocator param3ClassFileLocator) { return param3WithCustomMapping.to(param3TypePool.describe(this.name).resolve(), param3ClassFileLocator); } public boolean equals(@MaybeNull Object param3Object) { return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.name.equals(((ForUnifiedAdvice)param3Object).name))))); } public int hashCode() { return super.hashCode() * 31 + this.name.hashCode(); } } @Enhance protected static class ForSplitAdvice extends Entry { private final String enter; private final String exit; protected ForSplitAdvice(LatentMatcher<? super MethodDescription> param3LatentMatcher, String param3String1, String param3String2) { super(param3LatentMatcher); this.enter = param3String1; this.exit = param3String2; } protected Advice resolve(Advice.WithCustomMapping param3WithCustomMapping, TypePool param3TypePool, ClassFileLocator param3ClassFileLocator) { return param3WithCustomMapping.to(param3TypePool.describe(this.enter).resolve(), param3TypePool.describe(this.exit).resolve(), param3ClassFileLocator); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.enter.equals(((ForSplitAdvice)param3Object).enter) ? false : (!!this.exit.equals(((ForSplitAdvice)param3Object).exit))))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (super.hashCode() * 31 + this.enter.hashCode()) * 31 + this.exit.hashCode();
/*       */         } }
/*       */     
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface PoolStrategy
/*       */   {
/*       */     TypePool typePool(ClassFileLocator param1ClassFileLocator, @MaybeNull ClassLoader param1ClassLoader);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypePool typePool(ClassFileLocator param1ClassFileLocator, @MaybeNull ClassLoader param1ClassLoader, String param1String);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Default
/*       */       implements PoolStrategy
/*       */     {
/*  3204 */       EXTENDED((String)TypePool.Default.ReaderMode.EXTENDED),
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  3212 */       FAST((String)TypePool.Default.ReaderMode.FAST);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypePool.Default.ReaderMode readerMode;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Default(TypePool.Default.ReaderMode param2ReaderMode) {
/*  3225 */         this.readerMode = param2ReaderMode;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader) {
/*  3232 */         return (TypePool)new TypePool.Default.WithLazyResolution(TypePool.CacheProvider.Simple.withObjectType(), param2ClassFileLocator, this.readerMode);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader, String param2String) {
/*  3239 */         return typePool(param2ClassFileLocator, param2ClassLoader);
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
/*       */     public enum Eager
/*       */       implements PoolStrategy
/*       */     {
/*  3260 */       EXTENDED((String)TypePool.Default.ReaderMode.EXTENDED),
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  3268 */       FAST((String)TypePool.Default.ReaderMode.FAST);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypePool.Default.ReaderMode readerMode;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Eager(TypePool.Default.ReaderMode param2ReaderMode) {
/*  3281 */         this.readerMode = param2ReaderMode;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader) {
/*  3288 */         return (TypePool)new TypePool.Default(TypePool.CacheProvider.Simple.withObjectType(), param2ClassFileLocator, this.readerMode);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader, String param2String) {
/*  3295 */         return typePool(param2ClassFileLocator, param2ClassLoader);
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
/*       */     public enum ClassLoading
/*       */       implements PoolStrategy
/*       */     {
/*  3317 */       EXTENDED((String)TypePool.Default.ReaderMode.EXTENDED),
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  3325 */       FAST((String)TypePool.Default.ReaderMode.FAST);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypePool.Default.ReaderMode readerMode;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       ClassLoading(TypePool.Default.ReaderMode param2ReaderMode) {
/*  3338 */         this.readerMode = param2ReaderMode;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader) {
/*  3345 */         return TypePool.ClassLoading.of(param2ClassLoader, (TypePool)new TypePool.Default.WithLazyResolution(TypePool.CacheProvider.Simple.withObjectType(), param2ClassFileLocator, this.readerMode));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader, String param2String) {
/*  3352 */         return typePool(param2ClassFileLocator, param2ClassLoader);
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
/*       */     @Enhance
/*       */     public static abstract class WithTypePoolCache
/*       */       implements PoolStrategy
/*       */     {
/*       */       protected final TypePool.Default.ReaderMode readerMode;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected WithTypePoolCache(TypePool.Default.ReaderMode param2ReaderMode) {
/*  3381 */         this.readerMode = param2ReaderMode;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader) {
/*  3388 */         return (TypePool)new TypePool.Default.WithLazyResolution(locate(param2ClassLoader), param2ClassFileLocator, this.readerMode);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypePool typePool(ClassFileLocator param2ClassFileLocator, @MaybeNull ClassLoader param2ClassLoader, String param2String) {
/*  3395 */         return (TypePool)new TypePool.Default.WithLazyResolution((TypePool.CacheProvider)new TypePool.CacheProvider.Discriminating((ElementMatcher)ElementMatchers.is(param2String), (TypePool.CacheProvider)new TypePool.CacheProvider.Simple(), 
/*       */               
/*  3397 */               locate(param2ClassLoader)), param2ClassFileLocator, this.readerMode);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract TypePool.CacheProvider locate(@MaybeNull ClassLoader param2ClassLoader);
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.readerMode.equals(((WithTypePoolCache)param2Object).readerMode))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.readerMode.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Simple
/*       */         extends WithTypePoolCache
/*       */       {
/*       */         private final ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> cacheProviders;
/*       */ 
/*       */ 
/*       */         
/*       */         public Simple(ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> param3ConcurrentMap) {
/*  3428 */           this(TypePool.Default.ReaderMode.FAST, param3ConcurrentMap);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Simple(TypePool.Default.ReaderMode param3ReaderMode, ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> param3ConcurrentMap) {
/*  3438 */           super(param3ReaderMode);
/*  3439 */           this.cacheProviders = param3ConcurrentMap;
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypePool.CacheProvider locate(@MaybeNull ClassLoader param3ClassLoader) {
/*  3444 */           param3ClassLoader = (param3ClassLoader == null) ? getBootstrapMarkerLoader() : param3ClassLoader;
/*  3445 */           TypePool.CacheProvider cacheProvider = this.cacheProviders.get(param3ClassLoader);
/*  3446 */           while (cacheProvider == null) {
/*  3447 */             cacheProvider = TypePool.CacheProvider.Simple.withObjectType();
/*       */             TypePool.CacheProvider cacheProvider1;
/*  3449 */             if ((cacheProvider1 = this.cacheProviders.putIfAbsent(param3ClassLoader, cacheProvider)) != null) {
/*  3450 */               cacheProvider = cacheProvider1;
/*       */             }
/*       */           } 
/*  3453 */           return cacheProvider;
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
/*       */         protected ClassLoader getBootstrapMarkerLoader() {
/*  3471 */           return ClassLoader.getSystemClassLoader();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.cacheProviders.equals(((Simple)param3Object).cacheProviders)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.cacheProviders.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface InitializationStrategy
/*       */   {
/*       */     Dispatcher dispatcher();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Dispatcher
/*       */     {
/*       */       DynamicType.Builder<?> apply(DynamicType.Builder<?> param2Builder);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void register(DynamicType param2DynamicType, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain, AgentBuilder.InjectionStrategy param2InjectionStrategy);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements InitializationStrategy, Dispatcher
/*       */     {
/*  3523 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final AgentBuilder.InitializationStrategy.Dispatcher dispatcher() {
/*  3529 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final DynamicType.Builder<?> apply(DynamicType.Builder<?> param2Builder) {
/*  3536 */         return param2Builder;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void register(DynamicType param2DynamicType, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain, AgentBuilder.InjectionStrategy param2InjectionStrategy) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Minimal
/*       */       implements InitializationStrategy, Dispatcher
/*       */     {
/*  3557 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final AgentBuilder.InitializationStrategy.Dispatcher dispatcher() {
/*  3563 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final DynamicType.Builder<?> apply(DynamicType.Builder<?> param2Builder) {
/*  3570 */         return param2Builder;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void register(DynamicType param2DynamicType, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain, AgentBuilder.InjectionStrategy param2InjectionStrategy) {
/*  3577 */         Map<?, ?> map = param2DynamicType.getAuxiliaryTypes();
/*  3578 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(map);
/*  3579 */         for (Iterator<TypeDescription> iterator = map.keySet().iterator(); iterator.hasNext();) {
/*  3580 */           if (!(typeDescription = iterator.next()).getDeclaredAnnotations().isAnnotationPresent(AuxiliaryType.SignatureRelevant.class)) {
/*  3581 */             linkedHashMap.remove(typeDescription);
/*       */           }
/*       */         } 
/*  3584 */         if (!linkedHashMap.isEmpty()) {
/*  3585 */           ClassInjector classInjector = param2InjectionStrategy.resolve(param2ClassLoader, param2ProtectionDomain);
/*  3586 */           Map map1 = param2DynamicType.getLoadedTypeInitializers();
/*  3587 */           for (Map.Entry entry : classInjector.inject(linkedHashMap).entrySet()) {
/*  3588 */             ((LoadedTypeInitializer)map1.get(entry.getKey())).onLoad((Class)entry.getValue());
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
/*       */     @Enhance
/*       */     public static abstract class SelfInjection
/*       */       implements InitializationStrategy
/*       */     {
/*       */       protected final NexusAccessor nexusAccessor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected SelfInjection(NexusAccessor param2NexusAccessor) {
/*  3612 */         this.nexusAccessor = param2NexusAccessor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @SuppressFBWarnings(value = {"DMI_RANDOM_USED_ONLY_ONCE"}, justification = "Avoids thread-contention.")
/*       */       public AgentBuilder.InitializationStrategy.Dispatcher dispatcher() {
/*  3620 */         return dispatcher((new Random()).nextInt());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract AgentBuilder.InitializationStrategy.Dispatcher dispatcher(int param2Int);
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.nexusAccessor.equals(((SelfInjection)param2Object).nexusAccessor))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.nexusAccessor.hashCode();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static abstract class Dispatcher
/*       */         implements AgentBuilder.InitializationStrategy.Dispatcher
/*       */       {
/*       */         protected final NexusAccessor nexusAccessor;
/*       */ 
/*       */         
/*       */         protected final int identification;
/*       */ 
/*       */ 
/*       */         
/*       */         protected Dispatcher(NexusAccessor param3NexusAccessor, int param3Int) {
/*  3654 */           this.nexusAccessor = param3NexusAccessor;
/*  3655 */           this.identification = param3Int;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public DynamicType.Builder<?> apply(DynamicType.Builder<?> param3Builder) {
/*  3662 */           return param3Builder.initializer((ByteCodeAppender)new NexusAccessor.InitializationAppender(this.identification));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.identification != ((Dispatcher)param3Object).identification) ? false : (!!this.nexusAccessor.equals(((Dispatcher)param3Object).nexusAccessor)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.nexusAccessor.hashCode()) * 31 + this.identification;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class InjectingInitializer
/*       */           implements LoadedTypeInitializer
/*       */         {
/*       */           private final TypeDescription instrumentedType;
/*       */ 
/*       */ 
/*       */           
/*       */           private final Map<TypeDescription, byte[]> rawAuxiliaryTypes;
/*       */ 
/*       */ 
/*       */           
/*       */           private final Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers;
/*       */ 
/*       */ 
/*       */           
/*       */           private final ClassInjector classInjector;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected InjectingInitializer(TypeDescription param4TypeDescription, Map<TypeDescription, byte[]> param4Map, Map<TypeDescription, LoadedTypeInitializer> param4Map1, ClassInjector param4ClassInjector) {
/*  3704 */             this.instrumentedType = param4TypeDescription;
/*  3705 */             this.rawAuxiliaryTypes = param4Map;
/*  3706 */             this.loadedTypeInitializers = param4Map1;
/*  3707 */             this.classInjector = param4ClassInjector;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void onLoad(Class<?> param4Class) {
/*  3714 */             for (Map.Entry entry : this.classInjector.inject(this.rawAuxiliaryTypes).entrySet()) {
/*  3715 */               ((LoadedTypeInitializer)this.loadedTypeInitializers.get(entry.getKey())).onLoad((Class)entry.getValue());
/*       */             }
/*  3717 */             ((LoadedTypeInitializer)this.loadedTypeInitializers.get(this.instrumentedType)).onLoad(param4Class);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isAlive() {
/*  3724 */             return true;
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.instrumentedType.equals(((InjectingInitializer)param4Object).instrumentedType) ? false : (!this.rawAuxiliaryTypes.equals(((InjectingInitializer)param4Object).rawAuxiliaryTypes) ? false : (!this.loadedTypeInitializers.equals(((InjectingInitializer)param4Object).loadedTypeInitializers) ? false : (!!this.classInjector.equals(((InjectingInitializer)param4Object).classInjector)))))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return (((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.rawAuxiliaryTypes.hashCode()) * 31 + this.loadedTypeInitializers.hashCode()) * 31 + this.classInjector.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */       
/*       */       public static class Split
/*       */         extends SelfInjection {
/*       */         public Split() {
/*  3740 */           this(new NexusAccessor());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Split(NexusAccessor param3NexusAccessor) {
/*  3749 */           super(param3NexusAccessor);
/*       */         }
/*       */ 
/*       */         
/*       */         protected AgentBuilder.InitializationStrategy.Dispatcher dispatcher(int param3Int) {
/*  3754 */           return new Dispatcher(this.nexusAccessor, param3Int);
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
/*       */         protected static class Dispatcher
/*       */           extends AgentBuilder.InitializationStrategy.SelfInjection.Dispatcher
/*       */         {
/*       */           protected Dispatcher(NexusAccessor param4NexusAccessor, int param4Int) {
/*  3769 */             super(param4NexusAccessor, param4Int);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void register(DynamicType param4DynamicType, @MaybeNull ClassLoader param4ClassLoader, @MaybeNull ProtectionDomain param4ProtectionDomain, AgentBuilder.InjectionStrategy param4InjectionStrategy) {
/*       */             LoadedTypeInitializer loadedTypeInitializer;
/*       */             Map<?, ?> map;
/*  3778 */             if (!(map = param4DynamicType.getAuxiliaryTypes()).isEmpty()) {
/*  3779 */               TypeDescription typeDescription = param4DynamicType.getTypeDescription();
/*  3780 */               ClassInjector classInjector = param4InjectionStrategy.resolve(param4ClassLoader, param4ProtectionDomain);
/*  3781 */               LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>(map);
/*  3782 */               LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>(map);
/*  3783 */               for (Iterator<TypeDescription> iterator = map.keySet().iterator(); iterator.hasNext();) {
/*  3784 */                 ((typeDescription1 = iterator.next()).getDeclaredAnnotations().isAnnotationPresent(AuxiliaryType.SignatureRelevant.class) ? linkedHashMap2 : linkedHashMap1)
/*       */                   
/*  3786 */                   .remove(typeDescription1);
/*       */               }
/*  3788 */               Map<?, ?> map1 = param4DynamicType.getLoadedTypeInitializers();
/*  3789 */               if (!linkedHashMap1.isEmpty()) {
/*  3790 */                 for (Map.Entry entry : classInjector.inject(linkedHashMap1).entrySet()) {
/*  3791 */                   ((LoadedTypeInitializer)map1.get(entry.getKey())).onLoad((Class)entry.getValue());
/*       */                 }
/*       */               }
/*  3794 */               HashMap<Object, Object> hashMap = new HashMap<Object, Object>(map1);
/*  3795 */               map1.keySet().removeAll(linkedHashMap1.keySet());
/*       */ 
/*       */               
/*  3798 */               loadedTypeInitializer = (hashMap.size() > 1) ? new AgentBuilder.InitializationStrategy.SelfInjection.Dispatcher.InjectingInitializer(typeDescription, (Map)linkedHashMap2, (Map)hashMap, classInjector) : (LoadedTypeInitializer)hashMap.get(typeDescription);
/*       */             } else {
/*  3800 */               loadedTypeInitializer = (LoadedTypeInitializer)param4DynamicType.getLoadedTypeInitializers().get(param4DynamicType.getTypeDescription());
/*       */             } 
/*  3802 */             this.nexusAccessor.register(param4DynamicType.getTypeDescription().getName(), param4ClassLoader, this.identification, loadedTypeInitializer);
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class Lazy
/*       */         extends SelfInjection
/*       */       {
/*       */         public Lazy() {
/*  3816 */           this(new NexusAccessor());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Lazy(NexusAccessor param3NexusAccessor) {
/*  3825 */           super(param3NexusAccessor);
/*       */         }
/*       */ 
/*       */         
/*       */         protected AgentBuilder.InitializationStrategy.Dispatcher dispatcher(int param3Int) {
/*  3830 */           return new Dispatcher(this.nexusAccessor, param3Int);
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
/*       */         protected static class Dispatcher
/*       */           extends AgentBuilder.InitializationStrategy.SelfInjection.Dispatcher
/*       */         {
/*       */           protected Dispatcher(NexusAccessor param4NexusAccessor, int param4Int) {
/*  3845 */             super(param4NexusAccessor, param4Int);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void register(DynamicType param4DynamicType, @MaybeNull ClassLoader param4ClassLoader, @MaybeNull ProtectionDomain param4ProtectionDomain, AgentBuilder.InjectionStrategy param4InjectionStrategy) {
/*       */             Map<?, ?> map;
/*  3855 */             LoadedTypeInitializer loadedTypeInitializer = (map = param4DynamicType.getAuxiliaryTypes()).isEmpty() ? (LoadedTypeInitializer)param4DynamicType.getLoadedTypeInitializers().get(param4DynamicType.getTypeDescription()) : new AgentBuilder.InitializationStrategy.SelfInjection.Dispatcher.InjectingInitializer(param4DynamicType.getTypeDescription(), (Map)map, param4DynamicType.getLoadedTypeInitializers(), param4InjectionStrategy.resolve(param4ClassLoader, param4ProtectionDomain));
/*  3856 */             this.nexusAccessor.register(param4DynamicType.getTypeDescription().getName(), param4ClassLoader, this.identification, loadedTypeInitializer);
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class Eager
/*       */         extends SelfInjection
/*       */       {
/*       */         public Eager() {
/*  3870 */           this(new NexusAccessor());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Eager(NexusAccessor param3NexusAccessor) {
/*  3879 */           super(param3NexusAccessor);
/*       */         }
/*       */ 
/*       */         
/*       */         protected AgentBuilder.InitializationStrategy.Dispatcher dispatcher(int param3Int) {
/*  3884 */           return new Dispatcher(this.nexusAccessor, param3Int);
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
/*       */         protected static class Dispatcher
/*       */           extends AgentBuilder.InitializationStrategy.SelfInjection.Dispatcher
/*       */         {
/*       */           protected Dispatcher(NexusAccessor param4NexusAccessor, int param4Int) {
/*  3899 */             super(param4NexusAccessor, param4Int);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void register(DynamicType param4DynamicType, @MaybeNull ClassLoader param4ClassLoader, @MaybeNull ProtectionDomain param4ProtectionDomain, AgentBuilder.InjectionStrategy param4InjectionStrategy) {
/*  3906 */             Map map1 = param4DynamicType.getAuxiliaryTypes();
/*  3907 */             Map map2 = param4DynamicType.getLoadedTypeInitializers();
/*  3908 */             if (!map1.isEmpty()) {
/*  3909 */               for (Map.Entry entry : param4InjectionStrategy.resolve(param4ClassLoader, param4ProtectionDomain).inject(map1).entrySet()) {
/*  3910 */                 ((LoadedTypeInitializer)map2.get(entry.getKey())).onLoad((Class)entry.getValue());
/*       */               }
/*       */             }
/*  3913 */             LoadedTypeInitializer loadedTypeInitializer = (LoadedTypeInitializer)map2.get(param4DynamicType.getTypeDescription());
/*  3914 */             this.nexusAccessor.register(param4DynamicType.getTypeDescription().getName(), param4ClassLoader, this.identification, loadedTypeInitializer);
/*       */           }
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
/*       */   public static interface InjectionStrategy
/*       */   {
/*       */     ClassInjector resolve(@MaybeNull ClassLoader param1ClassLoader, @MaybeNull ProtectionDomain param1ProtectionDomain);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Disabled
/*       */       implements InjectionStrategy
/*       */     {
/*  3943 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final ClassInjector resolve(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain) {
/*  3949 */         throw new IllegalStateException("Class injection is disabled");
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum UsingReflection
/*       */       implements InjectionStrategy
/*       */     {
/*  3961 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final ClassInjector resolve(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain) {
/*  3967 */         if (param2ClassLoader == null)
/*  3968 */           throw new IllegalStateException("Cannot inject auxiliary class into bootstrap loader using reflection"); 
/*  3969 */         if (ClassInjector.UsingReflection.isAvailable()) {
/*  3970 */           return (ClassInjector)new ClassInjector.UsingReflection(param2ClassLoader, param2ProtectionDomain);
/*       */         }
/*  3972 */         throw new IllegalStateException("Reflection-based injection is not available on the current VM");
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum UsingUnsafe
/*       */       implements InjectionStrategy
/*       */     {
/*  3985 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final ClassInjector resolve(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain) {
/*  3991 */         if (ClassInjector.UsingUnsafe.isAvailable()) {
/*  3992 */           return (ClassInjector)new ClassInjector.UsingUnsafe(param2ClassLoader, param2ProtectionDomain);
/*       */         }
/*  3994 */         throw new IllegalStateException("Unsafe-based injection is not available on the current VM");
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class OfFactory
/*       */         implements AgentBuilder.InjectionStrategy
/*       */       {
/*       */         private final ClassInjector.UsingUnsafe.Factory factory;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public OfFactory(ClassInjector.UsingUnsafe.Factory param3Factory) {
/*  4015 */           this.factory = param3Factory;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ClassInjector resolve(@MaybeNull ClassLoader param3ClassLoader, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/*  4022 */           return this.factory.make(param3ClassLoader, param3ProtectionDomain);
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.factory.equals(((OfFactory)param3Object).factory))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.factory.hashCode();
/*       */         } }
/*       */     }
/*       */     
/*       */     public enum UsingJna implements InjectionStrategy {
/*  4035 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final ClassInjector resolve(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain) {
/*  4041 */         if (ClassInjector.UsingJna.isAvailable()) {
/*  4042 */           return (ClassInjector)new ClassInjector.UsingJna(param2ClassLoader, param2ProtectionDomain);
/*       */         }
/*  4044 */         throw new IllegalStateException("JNA-based injection is not available on the current VM");
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
/*       */     public static class UsingInstrumentation
/*       */       implements InjectionStrategy
/*       */     {
/*       */       private final Instrumentation instrumentation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final File folder;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public UsingInstrumentation(Instrumentation param2Instrumentation, File param2File) {
/*  4072 */         this.instrumentation = param2Instrumentation;
/*  4073 */         this.folder = param2File;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ClassInjector resolve(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain) {
/*  4080 */         if (param2ClassLoader == null)
/*  4081 */           return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, this.instrumentation);  return AgentBuilder.InjectionStrategy.UsingReflection.INSTANCE
/*  4082 */           .resolve(param2ClassLoader, param2ProtectionDomain);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentation.equals(((UsingInstrumentation)param2Object).instrumentation) ? false : (!!this.folder.equals(((UsingInstrumentation)param2Object).folder)))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (getClass().hashCode() * 31 + this.instrumentation.hashCode()) * 31 + this.folder.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface DescriptionStrategy
/*       */   {
/*       */     boolean isLoadedFirst();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypeDescription apply(String param1String, @MaybeNull Class<?> param1Class, TypePool param1TypePool, AgentBuilder.CircularityLock param1CircularityLock, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Default
/*       */       implements DescriptionStrategy
/*       */     {
/*  4130 */       HYBRID(true)
/*       */       {
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription apply(String param3String, @MaybeNull Class<?> param3Class, TypePool param3TypePool, AgentBuilder.CircularityLock param3CircularityLock, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule)
/*       */         {
/*  4138 */           if (param3Class == null)
/*  4139 */             return param3TypePool.describe(param3String).resolve(); 
/*  4140 */           return TypeDescription.ForLoadedType.of(param3Class);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  4157 */       POOL_ONLY(false)
/*       */       {
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription apply(String param3String, @MaybeNull Class<?> param3Class, TypePool param3TypePool, AgentBuilder.CircularityLock param3CircularityLock, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule)
/*       */         {
/*  4165 */           return param3TypePool.describe(param3String).resolve();
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  4181 */       POOL_FIRST(false)
/*       */       {
/*       */         public final TypeDescription apply(String param3String, @MaybeNull Class<?> param3Class, TypePool param3TypePool, AgentBuilder.CircularityLock param3CircularityLock, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule)
/*       */         {
/*       */           TypePool.Resolution resolution;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  4190 */           if ((resolution = param3TypePool.describe(param3String)).isResolved() || param3Class == null)
/*  4191 */             return resolution.resolve(); 
/*  4192 */           return TypeDescription.ForLoadedType.of(param3Class);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean loadedFirst;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Default(boolean param2Boolean) {
/*  4207 */         this.loadedFirst = param2Boolean;
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
/*       */       public AgentBuilder.DescriptionStrategy withSuperTypeLoading() {
/*  4219 */         return new AgentBuilder.DescriptionStrategy.SuperTypeLoading(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isLoadedFirst() {
/*  4226 */         return this.loadedFirst;
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
/*       */       public AgentBuilder.DescriptionStrategy withSuperTypeLoading(ExecutorService param2ExecutorService) {
/*  4240 */         return new AgentBuilder.DescriptionStrategy.SuperTypeLoading.Asynchronous(this, param2ExecutorService);
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
/*       */     @Enhance
/*       */     public static class SuperTypeLoading
/*       */       implements DescriptionStrategy
/*       */     {
/*       */       private final AgentBuilder.DescriptionStrategy delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SuperTypeLoading(AgentBuilder.DescriptionStrategy param2DescriptionStrategy) {
/*  4268 */         this.delegate = param2DescriptionStrategy;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isLoadedFirst() {
/*  4275 */         return this.delegate.isLoadedFirst();
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
/*       */       public TypeDescription apply(String param2String, @MaybeNull Class<?> param2Class, TypePool param2TypePool, AgentBuilder.CircularityLock param2CircularityLock, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule) {
/*       */         TypeDescription typeDescription;
/*  4288 */         return (TypeDescription)((typeDescription = this.delegate.apply(param2String, param2Class, param2TypePool, param2CircularityLock, param2ClassLoader, param2JavaModule) instanceof TypeDescription.ForLoadedType) ? typeDescription : new TypeDescription.SuperTypeLoading(typeDescription, param2ClassLoader, new UnlockingClassLoadingDelegate(param2CircularityLock)));
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.delegate.equals(((SuperTypeLoading)param2Object).delegate))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.delegate.hashCode();
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class UnlockingClassLoadingDelegate
/*       */         implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate
/*       */       {
/*       */         private final AgentBuilder.CircularityLock circularityLock;
/*       */ 
/*       */         
/*       */         protected UnlockingClassLoadingDelegate(AgentBuilder.CircularityLock param3CircularityLock) {
/*  4310 */           this.circularityLock = param3CircularityLock;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Class<?> load(String param3String, @MaybeNull ClassLoader param3ClassLoader) {
/*  4317 */           this.circularityLock.release();
/*       */           try {
/*  4319 */             return Class.forName(param3String, false, param3ClassLoader);
/*       */           } finally {
/*  4321 */             this.circularityLock.acquire();
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
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.circularityLock.equals(((UnlockingClassLoadingDelegate)param3Object).circularityLock))));
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
/*       */           return getClass().hashCode() * 31 + this.circularityLock.hashCode();
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
/*       */       public static class Asynchronous
/*       */         implements AgentBuilder.DescriptionStrategy
/*       */       {
/*       */         private final AgentBuilder.DescriptionStrategy delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final ExecutorService executorService;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Asynchronous(AgentBuilder.DescriptionStrategy param3DescriptionStrategy, ExecutorService param3ExecutorService) {
/*  4376 */           this.delegate = param3DescriptionStrategy;
/*  4377 */           this.executorService = param3ExecutorService;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isLoadedFirst() {
/*  4384 */           return this.delegate.isLoadedFirst();
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
/*       */         public TypeDescription apply(String param3String, @MaybeNull Class<?> param3Class, TypePool param3TypePool, AgentBuilder.CircularityLock param3CircularityLock, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*       */           TypeDescription typeDescription;
/*  4397 */           return (TypeDescription)((typeDescription = this.delegate.apply(param3String, param3Class, param3TypePool, param3CircularityLock, param3ClassLoader, param3JavaModule) instanceof TypeDescription.ForLoadedType) ? typeDescription : new TypeDescription.SuperTypeLoading(typeDescription, param3ClassLoader, new ThreadSwitchingClassLoadingDelegate(this.executorService)));
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.delegate.equals(((Asynchronous)param3Object).delegate) ? false : (!!this.executorService.equals(((Asynchronous)param3Object).executorService)))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.delegate.hashCode()) * 31 + this.executorService.hashCode();
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class ThreadSwitchingClassLoadingDelegate
/*       */           implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate
/*       */         {
/*       */           private final ExecutorService executorService;
/*       */ 
/*       */           
/*       */           protected ThreadSwitchingClassLoadingDelegate(ExecutorService param4ExecutorService) {
/*  4419 */             this.executorService = param4ExecutorService;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Class<?> load(String param4String, @MaybeNull ClassLoader param4ClassLoader) {
/*  4426 */             boolean bool = (param4ClassLoader != null && Thread.holdsLock(param4ClassLoader)) ? true : false;
/*  4427 */             AtomicBoolean atomicBoolean = new AtomicBoolean(bool);
/*  4428 */             Future<?> future = this.executorService.submit(bool ? new NotifyingClassLoadingAction(param4String, param4ClassLoader, atomicBoolean) : new SimpleClassLoadingAction(param4String, param4ClassLoader));
/*       */ 
/*       */             
/*       */             try {
/*  4432 */               while (bool && atomicBoolean.get()) {
/*  4433 */                 param4ClassLoader.wait();
/*       */               }
/*  4435 */               return (Class)future.get();
/*  4436 */             } catch (ExecutionException executionException) {
/*  4437 */               throw new IllegalStateException("Could not load " + param4String + " asynchronously", executionException.getCause());
/*  4438 */             } catch (Exception exception) {
/*  4439 */               throw new IllegalStateException("Could not load " + param4String + " asynchronously", exception);
/*       */             } 
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.executorService.equals(((ThreadSwitchingClassLoadingDelegate)param4Object).executorService))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.executorService.hashCode();
/*       */           }
/*       */ 
/*       */           
/*       */           @Enhance
/*       */           protected static class SimpleClassLoadingAction
/*       */             implements Callable<Class<?>>
/*       */           {
/*       */             private final String name;
/*       */             
/*       */             @MaybeNull
/*       */             @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */             private final ClassLoader classLoader;
/*       */ 
/*       */             
/*       */             protected SimpleClassLoadingAction(String param5String, @MaybeNull ClassLoader param5ClassLoader) {
/*  4468 */               this.name = param5String;
/*  4469 */               this.classLoader = param5ClassLoader;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public Class<?> call() {
/*  4476 */               return Class.forName(this.name, false, this.classLoader);
/*       */             }
/*       */             public boolean equals(@MaybeNull Object param5Object) {
/*       */               ClassLoader classLoader;
/*       */               if (this == param5Object)
/*       */                 return true; 
/*       */               if (param5Object == null)
/*       */                 return false; 
/*       */               if (getClass() != param5Object.getClass())
/*       */                 return false; 
/*       */               if (!this.name.equals(((SimpleClassLoadingAction)param5Object).name))
/*       */                 return false; 
/*       */               param5Object = ((SimpleClassLoadingAction)param5Object).classLoader;
/*       */               if (param5Object != null) {
/*       */                 if ((classLoader = this.classLoader) != null) {
/*       */                   if (!classLoader.equals(param5Object))
/*       */                     return false; 
/*       */                 } else {
/*       */                   return false;
/*       */                 } 
/*       */               } else if ((classLoader = this.classLoader) != null) {
/*       */                 return false;
/*       */               } 
/*       */               return true;
/*       */             }
/*       */             public int hashCode() {
/*       */               ClassLoader classLoader;
/*       */               if ((classLoader = this.classLoader) != null);
/*       */               return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + classLoader.hashCode();
/*       */             } }
/*       */           @Enhance
/*       */           protected static class NotifyingClassLoadingAction implements Callable<Class<?>> { private final String name; private final ClassLoader classLoader; private final AtomicBoolean signal;
/*       */             protected NotifyingClassLoadingAction(String param5String, ClassLoader param5ClassLoader, AtomicBoolean param5AtomicBoolean) {
/*  4509 */               this.name = param5String;
/*  4510 */               this.classLoader = param5ClassLoader;
/*  4511 */               this.signal = param5AtomicBoolean;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public Class<?> call() {
/*  4518 */               synchronized (this.classLoader) {
/*       */                 try {
/*  4520 */                   return Class.forName(this.name, false, this.classLoader);
/*       */                 } finally {
/*  4522 */                   this.signal.set(false);
/*  4523 */                   this.classLoader.notifyAll();
/*       */                 } 
/*       */               } 
/*       */             }
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean equals(@MaybeNull Object param5Object) {
/*       */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.name.equals(((NotifyingClassLoadingAction)param5Object).name) ? false : (!this.classLoader.equals(((NotifyingClassLoadingAction)param5Object).classLoader) ? false : (!!this.signal.equals(((NotifyingClassLoadingAction)param5Object).signal))))));
/*       */             }
/*       */ 
/*       */ 
/*       */             
/*       */             public int hashCode() {
/*       */               return ((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.classLoader.hashCode()) * 31 + this.signal.hashCode();
/*       */             } }
/*       */         
/*       */         }
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface LocationStrategy
/*       */   {
/*       */     ClassFileLocator classFileLocator(@MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule);
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements LocationStrategy
/*       */     {
/*  4555 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final ClassFileLocator classFileLocator(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule) {
/*  4561 */         return (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE;
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum ForClassLoader
/*       */       implements LocationStrategy
/*       */     {
/*  4573 */       STRONG
/*       */       {
/*       */         public final ClassFileLocator classFileLocator(@MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  4576 */           return ClassFileLocator.ForClassLoader.of(param3ClassLoader);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  4584 */       WEAK
/*       */       {
/*       */         public final ClassFileLocator classFileLocator(@MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule) {
/*  4587 */           return ClassFileLocator.ForClassLoader.WeaklyReferenced.of(param3ClassLoader);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.LocationStrategy withFallbackTo(ClassFileLocator... param2VarArgs) {
/*  4598 */         return withFallbackTo(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.LocationStrategy withFallbackTo(Collection<? extends ClassFileLocator> param2Collection) {
/*  4608 */         ArrayList<AgentBuilder.LocationStrategy.Simple> arrayList = new ArrayList(param2Collection.size());
/*  4609 */         for (ClassFileLocator classFileLocator : param2Collection) {
/*  4610 */           arrayList.add(new AgentBuilder.LocationStrategy.Simple(classFileLocator));
/*       */         }
/*  4612 */         return withFallbackTo((List)arrayList);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.LocationStrategy withFallbackTo(AgentBuilder.LocationStrategy... param2VarArgs) {
/*  4623 */         return withFallbackTo(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.LocationStrategy withFallbackTo(List<? extends AgentBuilder.LocationStrategy> param2List) {
/*       */         ArrayList<ForClassLoader> arrayList;
/*  4635 */         (arrayList = new ArrayList<ForClassLoader>(param2List.size() + 1)).add(this);
/*  4636 */         arrayList.addAll(param2List);
/*  4637 */         return new AgentBuilder.LocationStrategy.Compound((List)arrayList);
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Simple
/*       */       implements LocationStrategy
/*       */     {
/*       */       private final ClassFileLocator classFileLocator;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Simple(ClassFileLocator param2ClassFileLocator) {
/*  4658 */         this.classFileLocator = param2ClassFileLocator;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ClassFileLocator classFileLocator(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule) {
/*  4665 */         return this.classFileLocator;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.classFileLocator.equals(((Simple)param2Object).classFileLocator))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.classFileLocator.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Compound
/*       */       implements LocationStrategy
/*       */     {
/*       */       public Compound(AgentBuilder.LocationStrategy... param2VarArgs) {
/*  4686 */         this(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  4695 */       private final List<AgentBuilder.LocationStrategy> locationStrategies = new ArrayList<AgentBuilder.LocationStrategy>(); public Compound(List<? extends AgentBuilder.LocationStrategy> param2List) {
/*  4696 */         for (Iterator<? extends AgentBuilder.LocationStrategy> iterator = param2List.iterator(); iterator.hasNext(); ) {
/*  4697 */           AgentBuilder.LocationStrategy locationStrategy; if (locationStrategy = iterator.next() instanceof Compound) {
/*  4698 */             this.locationStrategies.addAll(((Compound)locationStrategy).locationStrategies); continue;
/*  4699 */           }  if (!(locationStrategy instanceof AgentBuilder.LocationStrategy.NoOp)) {
/*  4700 */             this.locationStrategies.add(locationStrategy);
/*       */           }
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ClassFileLocator classFileLocator(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule) {
/*  4709 */         ArrayList<ClassFileLocator> arrayList = new ArrayList(this.locationStrategies.size());
/*  4710 */         for (AgentBuilder.LocationStrategy locationStrategy : this.locationStrategies) {
/*  4711 */           arrayList.add(locationStrategy.classFileLocator(param2ClassLoader, param2JavaModule));
/*       */         }
/*  4713 */         return (ClassFileLocator)new ClassFileLocator.Compound(arrayList);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.locationStrategies.equals(((Compound)param2Object).locationStrategies))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.locationStrategies.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface FallbackStrategy
/*       */   {
/*       */     boolean isFallback(Class<?> param1Class, Throwable param1Throwable);
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Simple
/*       */       implements FallbackStrategy
/*       */     {
/*  4744 */       ENABLED(true),
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  4749 */       DISABLED(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean enabled;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Simple(boolean param2Boolean) {
/*  4762 */         this.enabled = param2Boolean;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isFallback(Class<?> param2Class, Throwable param2Throwable) {
/*  4769 */         return this.enabled;
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
/*       */     public static class ByThrowableType
/*       */       implements FallbackStrategy
/*       */     {
/*       */       private final Set<? extends Class<? extends Throwable>> types;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByThrowableType(Class<? extends Throwable>... param2VarArgs) {
/*  4791 */         this(new HashSet<Class<? extends Throwable>>(Arrays.asList(param2VarArgs)));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByThrowableType(Set<? extends Class<? extends Throwable>> param2Set) {
/*  4800 */         this.types = param2Set;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static AgentBuilder.FallbackStrategy ofOptionalTypes() {
/*  4810 */         return new ByThrowableType((Class<? extends Throwable>[])new Class[] { LinkageError.class, TypeNotPresentException.class });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isFallback(Class<?> param2Class, Throwable param2Throwable) {
/*  4817 */         for (Iterator<? extends Class<? extends Throwable>> iterator = this.types.iterator(); iterator.hasNext();) {
/*  4818 */           if ((clazz = iterator.next()).isInstance(param2Throwable)) {
/*  4819 */             return true;
/*       */           }
/*       */         } 
/*  4822 */         return false;
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.types.equals(((ByThrowableType)param2Object).types))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.types.hashCode();
/*       */       } }
/*       */   }
/*       */   
/*       */   public static interface InstallationListener {
/*       */     @AlwaysNull
/*  4836 */     public static final Throwable SUPPRESS_ERROR = null;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onBeforeInstall(Instrumentation param1Instrumentation, ResettableClassFileTransformer param1ResettableClassFileTransformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onInstall(Instrumentation param1Instrumentation, ResettableClassFileTransformer param1ResettableClassFileTransformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     Throwable onError(Instrumentation param1Instrumentation, ResettableClassFileTransformer param1ResettableClassFileTransformer, Throwable param1Throwable);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onReset(Instrumentation param1Instrumentation, ResettableClassFileTransformer param1ResettableClassFileTransformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onBeforeWarmUp(Set<Class<?>> param1Set, ResettableClassFileTransformer param1ResettableClassFileTransformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onWarmUpError(Class<?> param1Class, ResettableClassFileTransformer param1ResettableClassFileTransformer, Throwable param1Throwable);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     void onAfterWarmUp(Map<Class<?>, byte[]> param1Map, ResettableClassFileTransformer param1ResettableClassFileTransformer, boolean param1Boolean);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements InstallationListener
/*       */     {
/*  4910 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onBeforeInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final Throwable onError(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {
/*  4930 */         return param2Throwable;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onReset(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onBeforeWarmUp(Set<Class<?>> param2Set, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onWarmUpError(Class<?> param2Class, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onAfterWarmUp(Map<Class<?>, byte[]> param2Map, ResettableClassFileTransformer param2ResettableClassFileTransformer, boolean param2Boolean) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum ErrorSuppressing
/*       */       implements InstallationListener
/*       */     {
/*  4970 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onBeforeInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public final Throwable onError(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {
/*  4991 */         return SUPPRESS_ERROR;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onReset(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onBeforeWarmUp(Set<Class<?>> param2Set, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onWarmUpError(Class<?> param2Class, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void onAfterWarmUp(Map<Class<?>, byte[]> param2Map, ResettableClassFileTransformer param2ResettableClassFileTransformer, boolean param2Boolean) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class Adapter
/*       */       implements InstallationListener
/*       */     {
/*       */       public void onBeforeInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Throwable onError(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {
/*  5046 */         return param2Throwable;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onReset(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onBeforeWarmUp(Set<Class<?>> param2Set, ResettableClassFileTransformer param2ResettableClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onWarmUpError(Class<?> param2Class, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onAfterWarmUp(Map<Class<?>, byte[]> param2Map, ResettableClassFileTransformer param2ResettableClassFileTransformer, boolean param2Boolean) {}
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class StreamWriting
/*       */       implements InstallationListener
/*       */     {
/*       */       protected static final String PREFIX = "[Byte Buddy]";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final PrintStream printStream;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StreamWriting(PrintStream param2PrintStream) {
/*  5100 */         this.printStream = param2PrintStream;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static AgentBuilder.InstallationListener toSystemOut() {
/*  5109 */         return new StreamWriting(System.out);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static AgentBuilder.InstallationListener toSystemError() {
/*  5118 */         return new StreamWriting(System.err);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onBeforeInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5125 */         this.printStream.printf("[Byte Buddy] BEFORE_INSTALL %s on %s%n", new Object[] { param2ResettableClassFileTransformer, param2Instrumentation });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5132 */         this.printStream.printf("[Byte Buddy] INSTALL %s on %s%n", new Object[] { param2ResettableClassFileTransformer, param2Instrumentation });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Throwable onError(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {
/*  5139 */         synchronized (this.printStream) {
/*  5140 */           this.printStream.printf("[Byte Buddy] ERROR %s on %s%n", new Object[] { param2ResettableClassFileTransformer, param2Instrumentation });
/*  5141 */           param2Throwable.printStackTrace(this.printStream);
/*       */         } 
/*  5143 */         return param2Throwable;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onReset(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5150 */         this.printStream.printf("[Byte Buddy] RESET %s on %s%n", new Object[] { param2ResettableClassFileTransformer, param2Instrumentation });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onBeforeWarmUp(Set<Class<?>> param2Set, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5157 */         this.printStream.printf("[Byte Buddy] BEFORE_WARMUP %s on %s%n", new Object[] { param2ResettableClassFileTransformer, param2Set });
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onWarmUpError(Class<?> param2Class, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {
/*  5164 */         synchronized (this.printStream) {
/*  5165 */           this.printStream.printf("[Byte Buddy] ERROR_WARMUP %s on %s%n", new Object[] { param2ResettableClassFileTransformer, param2Class });
/*  5166 */           param2Throwable.printStackTrace(this.printStream);
/*       */           return;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public void onAfterWarmUp(Map<Class<?>, byte[]> param2Map, ResettableClassFileTransformer param2ResettableClassFileTransformer, boolean param2Boolean) {
/*  5174 */         this.printStream.printf("[Byte Buddy] AFTER_WARMUP %s %s on %s%n", new Object[] { param2Boolean ? "transformed" : "not transformed", param2ResettableClassFileTransformer, param2Map.keySet() });
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.printStream.equals(((StreamWriting)param2Object).printStream))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.printStream.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class Compound
/*       */       implements InstallationListener
/*       */     {
/*       */       public Compound(AgentBuilder.InstallationListener... param2VarArgs) {
/*  5195 */         this(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5204 */       private final List<AgentBuilder.InstallationListener> installationListeners = new ArrayList<AgentBuilder.InstallationListener>(); public Compound(List<? extends AgentBuilder.InstallationListener> param2List) {
/*  5205 */         for (Iterator<? extends AgentBuilder.InstallationListener> iterator = param2List.iterator(); iterator.hasNext(); ) {
/*  5206 */           AgentBuilder.InstallationListener installationListener; if (installationListener = iterator.next() instanceof Compound) {
/*  5207 */             this.installationListeners.addAll(((Compound)installationListener).installationListeners); continue;
/*  5208 */           }  if (!(installationListener instanceof AgentBuilder.InstallationListener.NoOp)) {
/*  5209 */             this.installationListeners.add(installationListener);
/*       */           }
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onBeforeInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5218 */         for (Iterator<AgentBuilder.InstallationListener> iterator = this.installationListeners.iterator(); iterator.hasNext();) {
/*  5219 */           (installationListener = iterator.next()).onBeforeInstall(param2Instrumentation, param2ResettableClassFileTransformer);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onInstall(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5227 */         for (Iterator<AgentBuilder.InstallationListener> iterator = this.installationListeners.iterator(); iterator.hasNext();) {
/*  5228 */           (installationListener = iterator.next()).onInstall(param2Instrumentation, param2ResettableClassFileTransformer);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public Throwable onError(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {
/*  5237 */         for (AgentBuilder.InstallationListener installationListener : this.installationListeners) {
/*  5238 */           if (param2Throwable == SUPPRESS_ERROR) {
/*  5239 */             return SUPPRESS_ERROR;
/*       */           }
/*  5241 */           param2Throwable = installationListener.onError(param2Instrumentation, param2ResettableClassFileTransformer, param2Throwable);
/*       */         } 
/*  5243 */         return param2Throwable;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onReset(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5250 */         for (Iterator<AgentBuilder.InstallationListener> iterator = this.installationListeners.iterator(); iterator.hasNext();) {
/*  5251 */           (installationListener = iterator.next()).onReset(param2Instrumentation, param2ResettableClassFileTransformer);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onBeforeWarmUp(Set<Class<?>> param2Set, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5259 */         for (Iterator<AgentBuilder.InstallationListener> iterator = this.installationListeners.iterator(); iterator.hasNext();) {
/*  5260 */           (installationListener = iterator.next()).onBeforeWarmUp(param2Set, param2ResettableClassFileTransformer);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onWarmUpError(Class<?> param2Class, ResettableClassFileTransformer param2ResettableClassFileTransformer, Throwable param2Throwable) {
/*  5268 */         for (Iterator<AgentBuilder.InstallationListener> iterator = this.installationListeners.iterator(); iterator.hasNext();) {
/*  5269 */           (installationListener = iterator.next()).onWarmUpError(param2Class, param2ResettableClassFileTransformer, param2Throwable);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public void onAfterWarmUp(Map<Class<?>, byte[]> param2Map, ResettableClassFileTransformer param2ResettableClassFileTransformer, boolean param2Boolean) {
/*  5277 */         for (Iterator<AgentBuilder.InstallationListener> iterator = this.installationListeners.iterator(); iterator.hasNext();) {
/*  5278 */           (installationListener = iterator.next()).onAfterWarmUp(param2Map, param2ResettableClassFileTransformer, param2Boolean);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.installationListeners.equals(((Compound)param2Object).installationListeners))));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.installationListeners.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface ClassFileBufferStrategy
/*       */   {
/*       */     ClassFileLocator resolve(String param1String, byte[] param1ArrayOfbyte, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, ProtectionDomain param1ProtectionDomain);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypePool typePool(AgentBuilder.PoolStrategy param1PoolStrategy, ClassFileLocator param1ClassFileLocator, @MaybeNull ClassLoader param1ClassLoader, String param1String);
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Default
/*       */       implements ClassFileBufferStrategy
/*       */     {
/*  5320 */       RETAINING
/*       */       {
/*       */ 
/*       */ 
/*       */         
/*       */         public final ClassFileLocator resolve(String param3String, byte[] param3ArrayOfbyte, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, ProtectionDomain param3ProtectionDomain)
/*       */         {
/*  5327 */           return ClassFileLocator.Simple.of(param3String, param3ArrayOfbyte);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypePool typePool(AgentBuilder.PoolStrategy param3PoolStrategy, ClassFileLocator param3ClassFileLocator, @MaybeNull ClassLoader param3ClassLoader, String param3String) {
/*  5335 */           return param3PoolStrategy.typePool(param3ClassFileLocator, param3ClassLoader, param3String);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5347 */       DISCARDING
/*       */       {
/*       */ 
/*       */ 
/*       */         
/*       */         public final ClassFileLocator resolve(String param3String, byte[] param3ArrayOfbyte, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, ProtectionDomain param3ProtectionDomain)
/*       */         {
/*  5354 */           return (ClassFileLocator)ClassFileLocator.NoOp.INSTANCE;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypePool typePool(AgentBuilder.PoolStrategy param3PoolStrategy, ClassFileLocator param3ClassFileLocator, @MaybeNull ClassLoader param3ClassLoader, String param3String) {
/*  5362 */           return param3PoolStrategy.typePool(param3ClassFileLocator, param3ClassLoader);
/*       */         }
/*       */       };
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
/*       */   public static interface TransformerDecorator
/*       */   {
/*       */     ResettableClassFileTransformer decorate(ResettableClassFileTransformer param1ResettableClassFileTransformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements TransformerDecorator
/*       */     {
/*  5389 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final ResettableClassFileTransformer decorate(ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5395 */         return param2ResettableClassFileTransformer;
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
/*       */     @Enhance
/*       */     public static class Compound
/*       */       implements TransformerDecorator
/*       */     {
/*       */       public Compound(AgentBuilder.TransformerDecorator... param2VarArgs) {
/*  5416 */         this(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5425 */       private final List<AgentBuilder.TransformerDecorator> transformerDecorators = new ArrayList<AgentBuilder.TransformerDecorator>(); public Compound(List<? extends AgentBuilder.TransformerDecorator> param2List) {
/*  5426 */         for (Iterator<? extends AgentBuilder.TransformerDecorator> iterator = param2List.iterator(); iterator.hasNext(); ) {
/*  5427 */           AgentBuilder.TransformerDecorator transformerDecorator; if (transformerDecorator = iterator.next() instanceof Compound) {
/*  5428 */             this.transformerDecorators.addAll(((Compound)transformerDecorator).transformerDecorators); continue;
/*  5429 */           }  if (!(transformerDecorator instanceof AgentBuilder.TransformerDecorator.NoOp)) {
/*  5430 */             this.transformerDecorators.add(transformerDecorator);
/*       */           }
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ResettableClassFileTransformer decorate(ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  5439 */         for (Iterator<AgentBuilder.TransformerDecorator> iterator = this.transformerDecorators.iterator(); iterator.hasNext();) {
/*  5440 */           param2ResettableClassFileTransformer = (transformerDecorator = iterator.next()).decorate(param2ResettableClassFileTransformer);
/*       */         }
/*  5442 */         return param2ResettableClassFileTransformer;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.transformerDecorators.equals(((Compound)param2Object).transformerDecorators))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.transformerDecorators.hashCode();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public enum RedefinitionStrategy
/*       */   {
/*  5462 */     DISABLED(false, false)
/*       */     {
/*       */       public final void apply(Instrumentation param2Instrumentation, AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, DiscoveryStrategy param2DiscoveryStrategy, AgentBuilder.LambdaInstrumentationStrategy param2LambdaInstrumentationStrategy, AgentBuilder.Listener param2Listener, Listener param2Listener1, AgentBuilder.RawMatcher param2RawMatcher, BatchAllocator param2BatchAllocator, AgentBuilder.CircularityLock param2CircularityLock) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final void check(Instrumentation param2Instrumentation) {
/*  5472 */         throw new IllegalStateException("Cannot apply redefinition on disabled strategy");
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final Collector make(AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.Listener param2Listener, AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.CircularityLock param2CircularityLock) {
/*  5483 */         throw new IllegalStateException("A disabled redefinition strategy cannot create a collector");
/*       */       }
/*       */     },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  5503 */     REDEFINITION(true, false)
/*       */     {
/*       */       protected final void check(Instrumentation param2Instrumentation) {
/*  5506 */         if (!param2Instrumentation.isRedefineClassesSupported()) {
/*  5507 */           throw new IllegalStateException("Cannot apply redefinition on " + param2Instrumentation);
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
/*       */       protected final Collector make(AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.Listener param2Listener, AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.CircularityLock param2CircularityLock) {
/*  5519 */         return new Collector.ForRedefinition(param2RawMatcher, param2PoolStrategy, param2LocationStrategy, param2DescriptionStrategy, param2Listener, param2FallbackStrategy, param2CircularityLock);
/*       */       }
/*       */     },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  5545 */     RETRANSFORMATION(true, true)
/*       */     {
/*       */       protected final void check(Instrumentation param2Instrumentation) {
/*  5548 */         if (!DISPATCHER.isRetransformClassesSupported(param2Instrumentation)) {
/*  5549 */           throw new IllegalStateException("Cannot apply retransformation on " + param2Instrumentation);
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
/*       */       protected final Collector make(AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.Listener param2Listener, AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.CircularityLock param2CircularityLock) {
/*  5561 */         return new Collector.ForRetransformation(param2RawMatcher, param2PoolStrategy, param2LocationStrategy, param2DescriptionStrategy, param2Listener, param2FallbackStrategy, param2CircularityLock);
/*       */       }
/*       */     };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  5574 */     protected static final Dispatcher DISPATCHER = (Dispatcher)AgentBuilder.Default.a(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */ 
/*       */     
/*       */     private final boolean enabled;
/*       */ 
/*       */ 
/*       */     
/*       */     private final boolean retransforming;
/*       */ 
/*       */ 
/*       */     
/*       */     static {
/*       */     
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     RedefinitionStrategy(boolean param1Boolean1, boolean param1Boolean2) {
/*  5593 */       this.enabled = param1Boolean1;
/*  5594 */       this.retransforming = param1Boolean2;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected boolean isRetransforming() {
/*  5604 */       return this.retransforming;
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
/*       */     protected boolean isEnabled() {
/*  5620 */       return this.enabled;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected void apply(Instrumentation param1Instrumentation, AgentBuilder.PoolStrategy param1PoolStrategy, AgentBuilder.LocationStrategy param1LocationStrategy, AgentBuilder.DescriptionStrategy param1DescriptionStrategy, AgentBuilder.FallbackStrategy param1FallbackStrategy, DiscoveryStrategy param1DiscoveryStrategy, AgentBuilder.LambdaInstrumentationStrategy param1LambdaInstrumentationStrategy, AgentBuilder.Listener param1Listener, Listener param1Listener1, AgentBuilder.RawMatcher param1RawMatcher, BatchAllocator param1BatchAllocator, AgentBuilder.CircularityLock param1CircularityLock) {
/*  5673 */       check(param1Instrumentation);
/*  5674 */       int i = 0;
/*  5675 */       for (Iterable<Class<?>> iterable : param1DiscoveryStrategy.resolve(param1Instrumentation)) {
/*  5676 */         Collector collector = make(param1PoolStrategy, param1LocationStrategy, param1DescriptionStrategy, param1FallbackStrategy, param1Listener, param1RawMatcher, param1CircularityLock);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  5683 */         for (Iterator<Class<?>> iterator = iterable.iterator(); iterator.hasNext();) {
/*  5684 */           if ((clazz = iterator.next()) != null && !clazz.isArray() && !clazz.isPrimitive() && param1LambdaInstrumentationStrategy.isInstrumented(clazz))
/*       */           {
/*       */             
/*  5687 */             collector.consider(clazz, (DISPATCHER.isModifiableClass(param1Instrumentation, clazz) || ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtMost(ClassFileVersion.JAVA_V5))); } 
/*       */         } 
/*  5689 */         i = collector.apply(param1Instrumentation, param1BatchAllocator, param1Listener1, i);
/*       */       } 
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract void check(Instrumentation param1Instrumentation);
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract Collector make(AgentBuilder.PoolStrategy param1PoolStrategy, AgentBuilder.LocationStrategy param1LocationStrategy, AgentBuilder.DescriptionStrategy param1DescriptionStrategy, AgentBuilder.FallbackStrategy param1FallbackStrategy, AgentBuilder.Listener param1Listener, AgentBuilder.RawMatcher param1RawMatcher, AgentBuilder.CircularityLock param1CircularityLock);
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface BatchAllocator
/*       */     {
/*       */       public static final int FIRST_BATCH = 0;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Iterable<? extends List<Class<?>>> batch(List<Class<?>> param2List);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ForTotal
/*       */         implements BatchAllocator
/*       */       {
/*  5722 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Iterable<? extends List<Class<?>>> batch(List<Class<?>> param3List) {
/*  5728 */           if (param3List.isEmpty())
/*  5729 */             return Collections.emptySet(); 
/*  5730 */           return Collections.singleton(param3List);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForFixedSize
/*       */         implements BatchAllocator
/*       */       {
/*       */         private final int size;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForFixedSize(int param3Int) {
/*  5751 */           this.size = param3Int;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static AgentBuilder.RedefinitionStrategy.BatchAllocator ofSize(int param3Int) {
/*  5761 */           if (param3Int > 0)
/*  5762 */             return new ForFixedSize(param3Int); 
/*  5763 */           if (param3Int == 0) {
/*  5764 */             return AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE;
/*       */           }
/*  5766 */           throw new IllegalArgumentException("Cannot define a batch with a negative size: " + param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> batch(List<Class<?>> param3List) {
/*  5774 */           ArrayList<? extends List<Class<?>>> arrayList = new ArrayList();
/*  5775 */           for (int i = 0; i < param3List.size(); i += this.size) {
/*  5776 */             arrayList.add(new ArrayList(param3List.subList(i, Math.min(param3List.size(), i + this.size))));
/*       */           }
/*  5778 */           return arrayList;
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.size != ((ForFixedSize)param3Object).size))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.size;
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForMatchedGrouping
/*       */         implements BatchAllocator
/*       */       {
/*       */         private final Collection<? extends ElementMatcher<? super TypeDescription>> matchers;
/*       */ 
/*       */         
/*       */         public ForMatchedGrouping(ElementMatcher<? super TypeDescription>... param3VarArgs) {
/*  5801 */           this(new LinkedHashSet<ElementMatcher<? super TypeDescription>>(Arrays.asList(param3VarArgs)));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForMatchedGrouping(Collection<? extends ElementMatcher<? super TypeDescription>> param3Collection) {
/*  5811 */           this.matchers = param3Collection;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionStrategy.BatchAllocator withMinimum(int param3Int) {
/*  5822 */           return AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing.withMinimum(param3Int, this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionStrategy.BatchAllocator withMaximum(int param3Int) {
/*  5833 */           return AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing.withMaximum(param3Int, this);
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
/*       */         public AgentBuilder.RedefinitionStrategy.BatchAllocator withinRange(int param3Int1, int param3Int2) {
/*  5845 */           return AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing.withinRange(param3Int1, param3Int2, this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> batch(List<Class<?>> param3List) {
/*  5852 */           LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  5853 */           ArrayList<Class<?>> arrayList = new ArrayList();
/*  5854 */           for (ElementMatcher<? super TypeDescription> elementMatcher : this.matchers) {
/*  5855 */             linkedHashMap.put(elementMatcher, new ArrayList());
/*       */           }
/*       */           
/*  5858 */           for (Class<?> clazz : param3List) {
/*  5859 */             for (Iterator<? extends ElementMatcher<? super TypeDescription>> iterator1 = this.matchers.iterator(); iterator1.hasNext();) {
/*  5860 */               if ((elementMatcher = iterator1.next()).matches(TypeDescription.ForLoadedType.of(clazz))) {
/*  5861 */                 ((List<Class<?>>)linkedHashMap.get(elementMatcher)).add(clazz);
/*       */               }
/*       */             } 
/*       */             
/*  5865 */             arrayList.add(clazz);
/*       */           } 
/*  5867 */           ArrayList<List<Class<?>>> arrayList1 = new ArrayList(this.matchers.size() + 1);
/*  5868 */           for (Iterator<List<Class<?>>> iterator = linkedHashMap.values().iterator(); iterator.hasNext();) {
/*  5869 */             if (!(param3List = iterator.next()).isEmpty()) {
/*  5870 */               arrayList1.add(param3List);
/*       */             }
/*       */           } 
/*  5873 */           if (!arrayList.isEmpty()) {
/*  5874 */             arrayList1.add(arrayList);
/*       */           }
/*  5876 */           return arrayList1;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matchers.equals(((ForMatchedGrouping)param3Object).matchers))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.matchers.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Slicing
/*       */         implements BatchAllocator
/*       */       {
/*       */         private final int minimum;
/*       */ 
/*       */         
/*       */         private final int maximum;
/*       */ 
/*       */         
/*       */         private final AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator;
/*       */ 
/*       */ 
/*       */         
/*       */         protected Slicing(int param3Int1, int param3Int2, AgentBuilder.RedefinitionStrategy.BatchAllocator param3BatchAllocator) {
/*  5909 */           this.minimum = param3Int1;
/*  5910 */           this.maximum = param3Int2;
/*  5911 */           this.batchAllocator = param3BatchAllocator;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static AgentBuilder.RedefinitionStrategy.BatchAllocator withMinimum(int param3Int, AgentBuilder.RedefinitionStrategy.BatchAllocator param3BatchAllocator) {
/*  5922 */           return withinRange(param3Int, 2147483647, param3BatchAllocator);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static AgentBuilder.RedefinitionStrategy.BatchAllocator withMaximum(int param3Int, AgentBuilder.RedefinitionStrategy.BatchAllocator param3BatchAllocator) {
/*  5933 */           return withinRange(1, param3Int, param3BatchAllocator);
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
/*       */         public static AgentBuilder.RedefinitionStrategy.BatchAllocator withinRange(int param3Int1, int param3Int2, AgentBuilder.RedefinitionStrategy.BatchAllocator param3BatchAllocator) {
/*  5945 */           if (param3Int1 <= 0)
/*  5946 */             throw new IllegalArgumentException("Minimum must be a positive number: " + param3Int1); 
/*  5947 */           if (param3Int1 > param3Int2) {
/*  5948 */             throw new IllegalArgumentException("Minimum must not be bigger than maximum: " + param3Int1 + " >" + param3Int2);
/*       */           }
/*  5950 */           return new Slicing(param3Int1, param3Int2, param3BatchAllocator);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> batch(List<Class<?>> param3List) {
/*  5957 */           return new SlicingIterable(this.minimum, this.maximum, this.batchAllocator.batch(param3List));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.minimum != ((Slicing)param3Object).minimum) ? false : ((this.maximum != ((Slicing)param3Object).maximum) ? false : (!!this.batchAllocator.equals(((Slicing)param3Object).batchAllocator))))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.minimum) * 31 + this.maximum) * 31 + this.batchAllocator.hashCode();
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class SlicingIterable
/*       */           implements Iterable<List<Class<?>>>
/*       */         {
/*       */           private final int minimum;
/*       */ 
/*       */           
/*       */           private final int maximum;
/*       */ 
/*       */           
/*       */           private final Iterable<? extends List<Class<?>>> iterable;
/*       */ 
/*       */ 
/*       */           
/*       */           protected SlicingIterable(int param4Int1, int param4Int2, Iterable<? extends List<Class<?>>> param4Iterable) {
/*  5988 */             this.minimum = param4Int1;
/*  5989 */             this.maximum = param4Int2;
/*  5990 */             this.iterable = param4Iterable;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Iterator<List<Class<?>>> iterator() {
/*  5997 */             return new SlicingIterator(this.minimum, this.maximum, this.iterable.iterator());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class SlicingIterator
/*       */             implements Iterator<List<Class<?>>>
/*       */           {
/*       */             private final int minimum;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             private final int maximum;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             private final Iterator<? extends List<Class<?>>> iterator;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             private List<Class<?>> buffer;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected SlicingIterator(int param5Int1, int param5Int2, Iterator<? extends List<Class<?>>> param5Iterator) {
/*  6033 */               this.minimum = param5Int1;
/*  6034 */               this.maximum = param5Int2;
/*  6035 */               this.iterator = param5Iterator;
/*  6036 */               this.buffer = new ArrayList<Class<?>>();
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean hasNext() {
/*  6043 */               return (!this.buffer.isEmpty() || this.iterator.hasNext());
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public List<Class<?>> next() {
/*  6050 */               if (this.buffer.isEmpty()) {
/*  6051 */                 this.buffer = this.iterator.next();
/*       */               }
/*  6053 */               while (this.buffer.size() < this.minimum && this.iterator.hasNext()) {
/*  6054 */                 this.buffer.addAll(this.iterator.next());
/*       */               }
/*  6056 */               if (this.buffer.size() > this.maximum) {
/*       */                 try {
/*  6058 */                   return this.buffer.subList(0, this.maximum);
/*       */                 } finally {
/*  6060 */                   this.buffer = new ArrayList<Class<?>>(this.buffer.subList(this.maximum, this.buffer.size()));
/*       */                 } 
/*       */               }
/*       */               try {
/*  6064 */                 return this.buffer;
/*       */               } finally {
/*  6066 */                 this.buffer = new ArrayList<Class<?>>();
/*       */               } 
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public void remove() {
/*  6075 */               throw new UnsupportedOperationException("remove");
/*       */             }
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Partitioning
/*       */         implements BatchAllocator
/*       */       {
/*       */         private final int parts;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Partitioning(int param3Int) {
/*  6098 */           this.parts = param3Int;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static AgentBuilder.RedefinitionStrategy.BatchAllocator of(int param3Int) {
/*  6108 */           if (param3Int <= 0) {
/*  6109 */             throw new IllegalArgumentException("A batch size must be positive: " + param3Int);
/*       */           }
/*  6111 */           return new Partitioning(param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> batch(List<Class<?>> param3List) {
/*  6118 */           if (param3List.isEmpty()) {
/*  6119 */             return Collections.emptyList();
/*       */           }
/*  6121 */           ArrayList<List> arrayList = new ArrayList();
/*  6122 */           int i = param3List.size() / this.parts; int j, k;
/*  6123 */           for (k = j = param3List.size() % this.parts; k < param3List.size(); k += i) {
/*  6124 */             arrayList.add(new ArrayList(param3List.subList(k, k + i)));
/*       */           }
/*  6126 */           if (arrayList.isEmpty()) {
/*  6127 */             return Collections.singletonList(param3List);
/*       */           }
/*  6129 */           ((List)arrayList.get(0)).addAll(0, param3List.subList(0, j));
/*  6130 */           return (Iterable)arrayList;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.parts != ((Partitioning)param3Object).parts))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.parts;
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Listener
/*       */     {
/*       */       void onBatch(int param2Int, List<Class<?>> param2List1, List<Class<?>> param2List2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Iterable<? extends List<Class<?>>> onError(int param2Int, List<Class<?>> param2List1, Throwable param2Throwable, List<Class<?>> param2List2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void onComplete(int param2Int, List<Class<?>> param2List, Map<List<Class<?>>, Throwable> param2Map);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum NoOp
/*       */         implements Listener
/*       */       {
/*  6180 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onBatch(int param3Int, List<Class<?>> param3List1, List<Class<?>> param3List2) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Iterable<? extends List<Class<?>>> onError(int param3Int, List<Class<?>> param3List1, Throwable param3Throwable, List<Class<?>> param3List2) {
/*  6193 */           return Collections.emptyList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onComplete(int param3Int, List<Class<?>> param3List, Map<List<Class<?>>, Throwable> param3Map) {}
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum Yielding
/*       */         implements Listener
/*       */       {
/*  6212 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onBatch(int param3Int, List<Class<?>> param3List1, List<Class<?>> param3List2) {
/*  6218 */           if (param3Int > 0) {
/*  6219 */             Thread.yield();
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Iterable<? extends List<Class<?>>> onError(int param3Int, List<Class<?>> param3List1, Throwable param3Throwable, List<Class<?>> param3List2) {
/*  6227 */           return Collections.emptyList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onComplete(int param3Int, List<Class<?>> param3List, Map<List<Class<?>>, Throwable> param3Map) {}
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum ErrorEscalating
/*       */         implements Listener
/*       */       {
/*  6246 */         FAIL_FAST
/*       */         {
/*       */           public final Iterable<? extends List<Class<?>>> onError(int param4Int, List<Class<?>> param4List1, Throwable param4Throwable, List<Class<?>> param4List2) {
/*  6249 */             throw new IllegalStateException("Could not transform any of " + param4List1, param4Throwable);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final void onComplete(int param4Int, List<Class<?>> param4List, Map<List<Class<?>>, Throwable> param4Map) {}
/*       */         },
/*  6261 */         FAIL_LAST
/*       */         {
/*       */           public final Iterable<? extends List<Class<?>>> onError(int param4Int, List<Class<?>> param4List1, Throwable param4Throwable, List<Class<?>> param4List2) {
/*  6264 */             return Collections.emptyList();
/*       */           }
/*       */ 
/*       */           
/*       */           public final void onComplete(int param4Int, List<Class<?>> param4List, Map<List<Class<?>>, Throwable> param4Map) {
/*  6269 */             if (!param4Map.isEmpty()) {
/*  6270 */               throw new IllegalStateException("Could not transform any of " + param4Map);
/*       */             }
/*       */           }
/*       */         };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onBatch(int param3Int, List<Class<?>> param3List1, List<Class<?>> param3List2) {}
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static abstract class Adapter
/*       */         implements Listener
/*       */       {
/*       */         public void onBatch(int param3Int, List<Class<?>> param3List1, List<Class<?>> param3List2) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> onError(int param3Int, List<Class<?>> param3List1, Throwable param3Throwable, List<Class<?>> param3List2) {
/*  6300 */           return Collections.emptyList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onComplete(int param3Int, List<Class<?>> param3List, Map<List<Class<?>>, Throwable> param3Map) {}
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : (!(getClass() != param3Object.getClass())));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class BatchReallocator
/*       */         extends Adapter
/*       */       {
/*       */         private final AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public BatchReallocator(AgentBuilder.RedefinitionStrategy.BatchAllocator param3BatchAllocator) {
/*  6336 */           this.batchAllocator = param3BatchAllocator;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static AgentBuilder.RedefinitionStrategy.Listener splitting() {
/*  6345 */           return new BatchReallocator(new AgentBuilder.RedefinitionStrategy.BatchAllocator.Partitioning(2));
/*       */         }
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> onError(int param3Int, List<Class<?>> param3List1, Throwable param3Throwable, List<Class<?>> param3List2) {
/*  6350 */           if (param3List1.size() < 2)
/*  6351 */             return Collections.emptyList();  return this.batchAllocator
/*  6352 */             .batch(param3List1);
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.batchAllocator.equals(((BatchReallocator)param3Object).batchAllocator)))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.batchAllocator.hashCode();
/*       */         }
/*       */       }
/*       */       
/*       */       @Enhance
/*       */       public static class Pausing
/*       */         extends Adapter
/*       */       {
/*       */         private final long value;
/*       */         
/*       */         protected Pausing(long param3Long) {
/*  6373 */           this.value = param3Long;
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
/*       */         public static AgentBuilder.RedefinitionStrategy.Listener of(long param3Long, TimeUnit param3TimeUnit) {
/*  6385 */           if (param3Long > 0L)
/*  6386 */             return new Pausing(param3TimeUnit.toMillis(param3Long)); 
/*  6387 */           if (param3Long == 0L) {
/*  6388 */             return AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE;
/*       */           }
/*  6390 */           throw new IllegalArgumentException("Cannot sleep for a non-positive amount of time: " + param3Long);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public void onBatch(int param3Int, List<Class<?>> param3List1, List<Class<?>> param3List2) {
/*  6396 */           if (param3Int > 0) {
/*       */             try {
/*  6398 */               Thread.sleep(this.value); return;
/*  6399 */             } catch (InterruptedException interruptedException) {
/*  6400 */               Thread.currentThread().interrupt();
/*  6401 */               throw new IllegalStateException(interruptedException);
/*       */             } 
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.value != ((Pausing)param3Object).value)))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + (int)(this.value ^ this.value >>> 32L);
/*       */         }
/*       */       }
/*       */       
/*       */       @Enhance
/*       */       public static class StreamWriting
/*       */         implements Listener
/*       */       {
/*       */         private final PrintStream printStream;
/*       */         
/*       */         public StreamWriting(PrintStream param3PrintStream) {
/*  6424 */           this.printStream = param3PrintStream;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static AgentBuilder.RedefinitionStrategy.Listener toSystemOut() {
/*  6433 */           return new StreamWriting(System.out);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static AgentBuilder.RedefinitionStrategy.Listener toSystemError() {
/*  6442 */           return new StreamWriting(System.err);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onBatch(int param3Int, List<Class<?>> param3List1, List<Class<?>> param3List2) {
/*  6449 */           this.printStream.printf("[Byte Buddy] REDEFINE BATCH #%d [%d of %d type(s)]%n", new Object[] { Integer.valueOf(param3Int), Integer.valueOf(param3List1.size()), Integer.valueOf(param3List2.size()) });
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> onError(int param3Int, List<Class<?>> param3List1, Throwable param3Throwable, List<Class<?>> param3List2) {
/*  6456 */           synchronized (this.printStream) {
/*  6457 */             this.printStream.printf("[Byte Buddy] REDEFINE ERROR #%d [%d of %d type(s)]%n", new Object[] { Integer.valueOf(param3Int), Integer.valueOf(param3List1.size()), Integer.valueOf(param3List2.size()) });
/*  6458 */             param3Throwable.printStackTrace(this.printStream);
/*       */           } 
/*  6460 */           return Collections.emptyList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onComplete(int param3Int, List<Class<?>> param3List, Map<List<Class<?>>, Throwable> param3Map) {
/*  6467 */           this.printStream.printf("[Byte Buddy] REDEFINE COMPLETE %d batch(es) containing %d types [%d failed batch(es)]%n", new Object[] { Integer.valueOf(param3Int), Integer.valueOf(param3List.size()), Integer.valueOf(param3Map.size()) });
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.printStream.equals(((StreamWriting)param3Object).printStream))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.printStream.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Compound
/*       */         implements Listener
/*       */       {
/*       */         public Compound(AgentBuilder.RedefinitionStrategy.Listener... param3VarArgs) {
/*  6488 */           this(Arrays.asList(param3VarArgs));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6497 */         private final List<AgentBuilder.RedefinitionStrategy.Listener> listeners = new ArrayList<AgentBuilder.RedefinitionStrategy.Listener>(); public Compound(List<? extends AgentBuilder.RedefinitionStrategy.Listener> param3List) {
/*  6498 */           for (Iterator<? extends AgentBuilder.RedefinitionStrategy.Listener> iterator = param3List.iterator(); iterator.hasNext(); ) {
/*  6499 */             AgentBuilder.RedefinitionStrategy.Listener listener; if (listener = iterator.next() instanceof Compound) {
/*  6500 */               this.listeners.addAll(((Compound)listener).listeners); continue;
/*  6501 */             }  if (!(listener instanceof AgentBuilder.RedefinitionStrategy.Listener.NoOp)) {
/*  6502 */               this.listeners.add(listener);
/*       */             }
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onBatch(int param3Int, List<Class<?>> param3List1, List<Class<?>> param3List2) {
/*  6511 */           for (Iterator<AgentBuilder.RedefinitionStrategy.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/*  6512 */             (listener = iterator.next()).onBatch(param3Int, param3List1, param3List2);
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<? extends List<Class<?>>> onError(int param3Int, List<Class<?>> param3List1, Throwable param3Throwable, List<Class<?>> param3List2) {
/*  6520 */           ArrayList<Iterable<? extends List<Class<?>>>> arrayList = new ArrayList();
/*  6521 */           for (AgentBuilder.RedefinitionStrategy.Listener listener : this.listeners) {
/*  6522 */             arrayList.add(listener.onError(param3Int, param3List1, param3Throwable, param3List2));
/*       */           }
/*  6524 */           return new CompoundIterable(arrayList);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onComplete(int param3Int, List<Class<?>> param3List, Map<List<Class<?>>, Throwable> param3Map) {
/*  6531 */           for (Iterator<AgentBuilder.RedefinitionStrategy.Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/*  6532 */             (listener = iterator.next()).onComplete(param3Int, param3List, param3Map);
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.listeners.equals(((Compound)param3Object).listeners))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.listeners.hashCode();
/*       */         }
/*       */         
/*       */         @Enhance
/*       */         protected static class CompoundIterable
/*       */           implements Iterable<List<Class<?>>>
/*       */         {
/*       */           private final List<Iterable<? extends List<Class<?>>>> iterables;
/*       */           
/*       */           protected CompoundIterable(List<Iterable<? extends List<Class<?>>>> param4List) {
/*  6553 */             this.iterables = param4List;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Iterator<List<Class<?>>> iterator() {
/*  6560 */             return new CompoundIterator(new ArrayList<Iterable<? extends List<Class<?>>>>(this.iterables));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.iterables.equals(((CompoundIterable)param4Object).iterables))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.iterables.hashCode();
/*       */           }
/*       */ 
/*       */           
/*       */           protected static class CompoundIterator
/*       */             implements Iterator<List<Class<?>>>
/*       */           {
/*       */             @MaybeNull
/*       */             private Iterator<? extends List<Class<?>>> current;
/*       */             
/*       */             private final List<Iterable<? extends List<Class<?>>>> backlog;
/*       */ 
/*       */             
/*       */             protected CompoundIterator(List<Iterable<? extends List<Class<?>>>> param5List) {
/*  6585 */               this.backlog = param5List;
/*  6586 */               forward();
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean hasNext() {
/*  6593 */               return (this.current != null && this.current.hasNext());
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public List<Class<?>> next() {
/*       */               try {
/*  6601 */                 if (this.current != null) {
/*  6602 */                   return this.current.next();
/*       */                 }
/*  6604 */                 throw new NoSuchElementException();
/*       */               } finally {
/*       */                 
/*  6607 */                 forward();
/*       */               } 
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             private void forward() {
/*  6615 */               while ((this.current == null || !this.current.hasNext()) && !this.backlog.isEmpty()) {
/*  6616 */                 this.current = ((Iterable<? extends List<Class<?>>>)this.backlog.remove(0)).iterator();
/*       */               }
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public void remove() {
/*  6624 */               throw new UnsupportedOperationException("remove");
/*       */             }
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
/*       */     public static interface DiscoveryStrategy
/*       */     {
/*       */       Iterable<Iterable<Class<?>>> resolve(Instrumentation param2Instrumentation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum SinglePass
/*       */         implements DiscoveryStrategy
/*       */       {
/*  6653 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Iterable<Iterable<Class<?>>> resolve(Instrumentation param3Instrumentation) {
/*  6659 */           return Collections.singleton(Arrays.asList(param3Instrumentation.getAllLoadedClasses()));
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
/*       */       public enum Reiterating
/*       */         implements DiscoveryStrategy
/*       */       {
/*  6673 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Iterable<Iterable<Class<?>>> resolve(Instrumentation param3Instrumentation) {
/*  6679 */           return new ReiteratingIterable(param3Instrumentation);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class ReiteratingIterable
/*       */           implements Iterable<Iterable<Class<?>>>
/*       */         {
/*       */           private final Instrumentation instrumentation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ReiteratingIterable(Instrumentation param4Instrumentation) {
/*  6699 */             this.instrumentation = param4Instrumentation;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Iterator<Iterable<Class<?>>> iterator() {
/*  6706 */             return new AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Reiterating.ReiteratingIterator(this.instrumentation);
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.instrumentation.equals(((ReiteratingIterable)param4Object).instrumentation))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.instrumentation.hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class ReiteratingIterator
/*       */           implements Iterator<Iterable<Class<?>>>
/*       */         {
/*       */           private final Instrumentation instrumentation;
/*       */ 
/*       */           
/*       */           private final Set<Class<?>> processed;
/*       */           
/*       */           @MaybeNull
/*       */           private List<Class<?>> types;
/*       */ 
/*       */           
/*       */           protected ReiteratingIterator(Instrumentation param4Instrumentation) {
/*  6737 */             this.instrumentation = param4Instrumentation;
/*  6738 */             this.processed = new HashSet<Class<?>>();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean hasNext() {
/*  6745 */             if (this.types == null) {
/*  6746 */               this.types = new ArrayList<Class<?>>(); Class[] arrayOfClass; int i; byte b;
/*  6747 */               for (i = (arrayOfClass = this.instrumentation.getAllLoadedClasses()).length, b = 0; b < i; ) {
/*  6748 */                 Class<?> clazz; if ((clazz = arrayOfClass[b]) != null && this.processed.add(clazz))
/*  6749 */                   this.types.add(clazz); 
/*       */                 b++;
/*       */               } 
/*       */             } 
/*  6753 */             return !this.types.isEmpty();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Iterable<Class<?>> next() {
/*  6760 */             if (hasNext()) {
/*       */               try {
/*  6762 */                 return this.types;
/*       */               } finally {
/*  6764 */                 this.types = null;
/*       */               } 
/*       */             }
/*  6767 */             throw new NoSuchElementException();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void remove() {
/*  6775 */             throw new UnsupportedOperationException("remove");
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
/*       */         enum WithSortOrderAssumption
/*       */           implements AgentBuilder.RedefinitionStrategy.DiscoveryStrategy
/*       */         {
/*  6796 */           INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Iterable<Iterable<Class<?>>> resolve(Instrumentation param4Instrumentation) {
/*  6802 */             return new OrderedReiteratingIterable(param4Instrumentation);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @Enhance
/*       */           protected static class OrderedReiteratingIterable
/*       */             implements Iterable<Iterable<Class<?>>>
/*       */           {
/*       */             private final Instrumentation instrumentation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected OrderedReiteratingIterable(Instrumentation param5Instrumentation) {
/*  6822 */               this.instrumentation = param5Instrumentation;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public Iterator<Iterable<Class<?>>> iterator() {
/*  6829 */               return new AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Reiterating.WithSortOrderAssumption.OrderedReiteratingIterator(this.instrumentation);
/*       */             }
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean equals(@MaybeNull Object param5Object) {
/*       */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.instrumentation.equals(((OrderedReiteratingIterable)param5Object).instrumentation))));
/*       */             }
/*       */ 
/*       */ 
/*       */             
/*       */             public int hashCode() {
/*       */               return getClass().hashCode() * 31 + this.instrumentation.hashCode();
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           protected static class OrderedReiteratingIterator
/*       */             implements Iterator<Iterable<Class<?>>>
/*       */           {
/*       */             private final Instrumentation instrumentation;
/*       */ 
/*       */             
/*       */             private int index;
/*       */             
/*       */             @MaybeNull
/*       */             private List<Class<?>> types;
/*       */ 
/*       */             
/*       */             protected OrderedReiteratingIterator(Instrumentation param5Instrumentation) {
/*  6860 */               this.instrumentation = param5Instrumentation;
/*  6861 */               this.index = 0;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean hasNext() {
/*  6868 */               if (this.types == null) {
/*  6869 */                 Class[] arrayOfClass = this.instrumentation.getAllLoadedClasses();
/*  6870 */                 this.types = new ArrayList<Class<?>>(Arrays.<Class<?>>asList(arrayOfClass).subList(this.index, arrayOfClass.length));
/*  6871 */                 this.index = arrayOfClass.length;
/*       */               } 
/*  6873 */               return !this.types.isEmpty();
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public Iterable<Class<?>> next() {
/*  6880 */               if (hasNext()) {
/*       */                 try {
/*  6882 */                   return this.types;
/*       */                 } finally {
/*  6884 */                   this.types = null;
/*       */                 } 
/*       */               }
/*  6887 */               throw new NoSuchElementException();
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public void remove() {
/*  6895 */               throw new UnsupportedOperationException("remove");
/*       */             }
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Explicit
/*       */         implements DiscoveryStrategy
/*       */       {
/*       */         private final Set<Class<?>> types;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Explicit(Class<?>... param3VarArgs) {
/*  6918 */           this(new LinkedHashSet<Class<?>>(Arrays.asList(param3VarArgs)));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Explicit(Set<Class<?>> param3Set) {
/*  6927 */           this.types = param3Set;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterable<Iterable<Class<?>>> resolve(Instrumentation param3Instrumentation) {
/*  6934 */           return Collections.singleton(this.types);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.types.equals(((Explicit)param3Object).types))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.types.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface ResubmissionScheduler
/*       */     {
/*       */       boolean isAlive();
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       Cancelable schedule(Runnable param2Runnable);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static interface Cancelable
/*       */       {
/*       */         void cancel();
/*       */ 
/*       */ 
/*       */         
/*       */         public enum NoOp
/*       */           implements Cancelable
/*       */         {
/*  6977 */           INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final void cancel() {}
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForFuture
/*       */           implements Cancelable
/*       */         {
/*       */           private final Future<?> future;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ForFuture(Future<?> param4Future) {
/*  7004 */             this.future = param4Future;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public void cancel() {
/*  7011 */             this.future.cancel(true);
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.future.equals(((ForFuture)param4Object).future))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.future.hashCode();
/*       */           } }
/*       */       }
/*       */       
/*       */       public enum NoOp implements ResubmissionScheduler {
/*  7024 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final boolean isAlive() {
/*  7030 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable schedule(Runnable param3Runnable) {
/*  7037 */           return AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable.NoOp.INSTANCE;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class AtFixedRate
/*       */         implements ResubmissionScheduler
/*       */       {
/*       */         private final ScheduledExecutorService scheduledExecutorService;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final long time;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TimeUnit timeUnit;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AtFixedRate(ScheduledExecutorService param3ScheduledExecutorService, long param3Long, TimeUnit param3TimeUnit) {
/*  7070 */           this.scheduledExecutorService = param3ScheduledExecutorService;
/*  7071 */           this.time = param3Long;
/*  7072 */           this.timeUnit = param3TimeUnit;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isAlive() {
/*  7079 */           return !this.scheduledExecutorService.isShutdown();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable schedule(Runnable param3Runnable) {
/*  7086 */           return new AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable.ForFuture(this.scheduledExecutorService.scheduleAtFixedRate(param3Runnable, this.time, this.time, this.timeUnit));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.time != ((AtFixedRate)param3Object).time) ? false : (!this.timeUnit.equals(((AtFixedRate)param3Object).timeUnit) ? false : (!!this.scheduledExecutorService.equals(((AtFixedRate)param3Object).scheduledExecutorService))))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.scheduledExecutorService.hashCode()) * 31 + (int)(this.time ^ this.time >>> 32L)) * 31 + this.timeUnit.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class WithFixedDelay
/*       */         implements ResubmissionScheduler
/*       */       {
/*       */         private final ScheduledExecutorService scheduledExecutorService;
/*       */ 
/*       */         
/*       */         private final long time;
/*       */ 
/*       */         
/*       */         private final TimeUnit timeUnit;
/*       */ 
/*       */ 
/*       */         
/*       */         public WithFixedDelay(ScheduledExecutorService param3ScheduledExecutorService, long param3Long, TimeUnit param3TimeUnit) {
/*  7119 */           this.scheduledExecutorService = param3ScheduledExecutorService;
/*  7120 */           this.time = param3Long;
/*  7121 */           this.timeUnit = param3TimeUnit;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isAlive() {
/*  7128 */           return !this.scheduledExecutorService.isShutdown();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable schedule(Runnable param3Runnable) {
/*  7135 */           return new AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable.ForFuture(this.scheduledExecutorService.scheduleWithFixedDelay(param3Runnable, this.time, this.time, this.timeUnit));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.time != ((WithFixedDelay)param3Object).time) ? false : (!this.timeUnit.equals(((WithFixedDelay)param3Object).timeUnit) ? false : (!!this.scheduledExecutorService.equals(((WithFixedDelay)param3Object).scheduledExecutorService))))));
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
/*       */           return ((getClass().hashCode() * 31 + this.scheduledExecutorService.hashCode()) * 31 + (int)(this.time ^ this.time >>> 32L)) * 31 + this.timeUnit.hashCode();
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
/*       */     protected static interface ResubmissionStrategy
/*       */     {
/*       */       Installation apply(Instrumentation param2Instrumentation, AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.Listener param2Listener, AgentBuilder.InstallationListener param2InstallationListener, AgentBuilder.CircularityLock param2CircularityLock, AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.RedefinitionStrategy param2RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param2BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param2Listener1);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum Disabled
/*       */         implements ResubmissionStrategy
/*       */       {
/*  7183 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Installation apply(Instrumentation param3Instrumentation, AgentBuilder.PoolStrategy param3PoolStrategy, AgentBuilder.LocationStrategy param3LocationStrategy, AgentBuilder.DescriptionStrategy param3DescriptionStrategy, AgentBuilder.FallbackStrategy param3FallbackStrategy, AgentBuilder.Listener param3Listener, AgentBuilder.InstallationListener param3InstallationListener, AgentBuilder.CircularityLock param3CircularityLock, AgentBuilder.RawMatcher param3RawMatcher, AgentBuilder.RedefinitionStrategy param3RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param3BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param3Listener1) {
/*  7200 */           return new AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Installation(param3Listener, param3InstallationListener, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer.Disabled.INSTANCE);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Enabled
/*       */         implements ResubmissionStrategy
/*       */       {
/*       */         private final AgentBuilder.RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Enabled(AgentBuilder.RedefinitionStrategy.ResubmissionScheduler param3ResubmissionScheduler, AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher param3ResubmissionOnErrorMatcher, AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher param3ResubmissionImmediateMatcher) {
/*  7235 */           this.resubmissionScheduler = param3ResubmissionScheduler;
/*  7236 */           this.resubmissionOnErrorMatcher = param3ResubmissionOnErrorMatcher;
/*  7237 */           this.resubmissionImmediateMatcher = param3ResubmissionImmediateMatcher;
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
/*       */         public AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Installation apply(Instrumentation param3Instrumentation, AgentBuilder.PoolStrategy param3PoolStrategy, AgentBuilder.LocationStrategy param3LocationStrategy, AgentBuilder.DescriptionStrategy param3DescriptionStrategy, AgentBuilder.FallbackStrategy param3FallbackStrategy, AgentBuilder.Listener param3Listener, AgentBuilder.InstallationListener param3InstallationListener, AgentBuilder.CircularityLock param3CircularityLock, AgentBuilder.RawMatcher param3RawMatcher, AgentBuilder.RedefinitionStrategy param3RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param3BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param3Listener1) {
/*  7255 */           if (this.resubmissionScheduler.isAlive()) {
/*  7256 */             ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
/*  7257 */             Resubmitter resubmitter = new Resubmitter(this.resubmissionOnErrorMatcher, this.resubmissionImmediateMatcher, (ConcurrentMap)concurrentHashMap);
/*  7258 */             return new AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Installation(new AgentBuilder.Listener.Compound(new AgentBuilder.Listener[] { resubmitter, param3Listener }, ), new AgentBuilder.InstallationListener.Compound(new AgentBuilder.InstallationListener[] { new ResubmissionInstallationListener(param3Instrumentation, this.resubmissionScheduler, param3PoolStrategy, param3LocationStrategy, param3DescriptionStrategy, param3FallbackStrategy, param3Listener, param3CircularityLock, param3RawMatcher, param3RedefinitionStrategy, param3BatchAllocator, param3Listener1, (ConcurrentMap)concurrentHashMap), param3InstallationListener }), resubmitter);
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
/*  7274 */           throw new IllegalStateException("Resubmission scheduler " + this.resubmissionScheduler + " is not alive");
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.resubmissionScheduler.equals(((Enabled)param3Object).resubmissionScheduler) ? false : (!this.resubmissionOnErrorMatcher.equals(((Enabled)param3Object).resubmissionOnErrorMatcher) ? false : (!!this.resubmissionImmediateMatcher.equals(((Enabled)param3Object).resubmissionImmediateMatcher))))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.resubmissionScheduler.hashCode()) * 31 + this.resubmissionOnErrorMatcher.hashCode()) * 31 + this.resubmissionImmediateMatcher.hashCode();
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class Resubmitter
/*       */           extends AgentBuilder.Listener.Adapter
/*       */           implements AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer
/*       */         {
/*       */           private final AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
/*       */ 
/*       */           
/*       */           private final AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
/*       */ 
/*       */           
/*       */           private final ConcurrentMap<AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey, Set<String>> types;
/*       */ 
/*       */ 
/*       */           
/*       */           protected Resubmitter(AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher param4ResubmissionOnErrorMatcher, AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher param4ResubmissionImmediateMatcher, ConcurrentMap<AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey, Set<String>> param4ConcurrentMap) {
/*  7308 */             this.resubmissionOnErrorMatcher = param4ResubmissionOnErrorMatcher;
/*  7309 */             this.resubmissionImmediateMatcher = param4ResubmissionImmediateMatcher;
/*  7310 */             this.types = param4ConcurrentMap;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"GC_UNRELATED_TYPES"}, justification = "Cross-comparison is intended.")
/*       */           public void onError(String param4String, @MaybeNull ClassLoader param4ClassLoader, @MaybeNull JavaModule param4JavaModule, boolean param4Boolean, Throwable param4Throwable) {
/*  7318 */             if (!param4Boolean && this.resubmissionOnErrorMatcher.matches(param4Throwable, param4String, param4ClassLoader, param4JavaModule)) {
/*       */ 
/*       */               
/*  7321 */               Set<String> set2 = new ConcurrentHashSet();
/*       */               Set<String> set1;
/*  7323 */               if ((set2 = this.types.get(new AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.LookupKey(param4ClassLoader))) == null && (set1 = this.types.putIfAbsent(new AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey(param4ClassLoader), set2)) != null) {
/*  7324 */                 set2 = set1;
/*       */               }
/*       */               
/*  7327 */               set2.add(param4String);
/*       */             } 
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"GC_UNRELATED_TYPES"}, justification = "Cross-comparison is intended.")
/*       */           public boolean isEnforced(String param4String, @MaybeNull ClassLoader param4ClassLoader, @MaybeNull JavaModule param4JavaModule, @MaybeNull Class<?> param4Class) {
/*  7336 */             if (param4Class == null && this.resubmissionImmediateMatcher.matches(param4String, param4ClassLoader, param4JavaModule)) {
/*       */ 
/*       */               
/*  7339 */               Set<String> set2 = new ConcurrentHashSet();
/*       */               Set<String> set1;
/*  7341 */               if ((set2 = this.types.get(new AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.LookupKey(param4ClassLoader))) == null && (set1 = this.types.putIfAbsent(new AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey(param4ClassLoader), set2)) != null) {
/*  7342 */                 set2 = set1;
/*       */               }
/*       */               
/*  7345 */               set2.add(param4String);
/*  7346 */               return true;
/*       */             } 
/*  7348 */             return false;
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
/*       */           protected static class ConcurrentHashSet<T>
/*       */             extends AbstractSet<T>
/*       */           {
/*  7368 */             private final ConcurrentMap<T, Boolean> delegate = new ConcurrentHashMap<T, Boolean>();
/*       */ 
/*       */ 
/*       */             
/*       */             public boolean add(T param5T) {
/*  7373 */               return (this.delegate.put(param5T, Boolean.TRUE) == null);
/*       */             }
/*       */ 
/*       */             
/*       */             public boolean remove(Object param5Object) {
/*  7378 */               return (this.delegate.remove(param5Object) != null);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public Iterator<T> iterator() {
/*  7385 */               return this.delegate.keySet().iterator();
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public int size() {
/*  7392 */               return this.delegate.size();
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
/*       */         protected static class ResubmissionInstallationListener
/*       */           extends AgentBuilder.InstallationListener.Adapter
/*       */           implements Runnable
/*       */         {
/*       */           private final Instrumentation instrumentation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.LocationStrategy locationStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.PoolStrategy poolStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.DescriptionStrategy descriptionStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.FallbackStrategy fallbackStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.Listener listener;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.CircularityLock circularityLock;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.RawMatcher matcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.RedefinitionStrategy redefinitionStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.RedefinitionStrategy.BatchAllocator redefinitionBatchAllocator;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AgentBuilder.RedefinitionStrategy.Listener redefinitionBatchListener;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final ConcurrentMap<AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey, Set<String>> types;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @MaybeNull
/*       */           private volatile AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable cancelable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ResubmissionInstallationListener(Instrumentation param4Instrumentation, AgentBuilder.RedefinitionStrategy.ResubmissionScheduler param4ResubmissionScheduler, AgentBuilder.PoolStrategy param4PoolStrategy, AgentBuilder.LocationStrategy param4LocationStrategy, AgentBuilder.DescriptionStrategy param4DescriptionStrategy, AgentBuilder.FallbackStrategy param4FallbackStrategy, AgentBuilder.Listener param4Listener, AgentBuilder.CircularityLock param4CircularityLock, AgentBuilder.RawMatcher param4RawMatcher, AgentBuilder.RedefinitionStrategy param4RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param4BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param4Listener1, ConcurrentMap<AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey, Set<String>> param4ConcurrentMap) {
/*  7503 */             this.instrumentation = param4Instrumentation;
/*  7504 */             this.resubmissionScheduler = param4ResubmissionScheduler;
/*  7505 */             this.poolStrategy = param4PoolStrategy;
/*  7506 */             this.locationStrategy = param4LocationStrategy;
/*  7507 */             this.descriptionStrategy = param4DescriptionStrategy;
/*  7508 */             this.fallbackStrategy = param4FallbackStrategy;
/*  7509 */             this.listener = param4Listener;
/*  7510 */             this.circularityLock = param4CircularityLock;
/*  7511 */             this.matcher = param4RawMatcher;
/*  7512 */             this.redefinitionStrategy = param4RedefinitionStrategy;
/*  7513 */             this.redefinitionBatchAllocator = param4BatchAllocator;
/*  7514 */             this.redefinitionBatchListener = param4Listener1;
/*  7515 */             this.types = param4ConcurrentMap;
/*       */           }
/*       */ 
/*       */           
/*       */           public void onInstall(Instrumentation param4Instrumentation, ResettableClassFileTransformer param4ResettableClassFileTransformer) {
/*  7520 */             this.cancelable = this.resubmissionScheduler.schedule(this);
/*       */           }
/*       */ 
/*       */           
/*       */           public void onReset(Instrumentation param4Instrumentation, ResettableClassFileTransformer param4ResettableClassFileTransformer) {
/*       */             AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable cancelable;
/*  7526 */             if ((cancelable = this.cancelable) != null) {
/*  7527 */               cancelable.cancel();
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
/*       */           public void run() {
/*       */             // Byte code:
/*       */             //   0: aload_0
/*       */             //   1: getfield circularityLock : Lnet/bytebuddy/agent/builder/AgentBuilder$CircularityLock;
/*       */             //   4: invokeinterface acquire : ()Z
/*       */             //   9: istore_1
/*       */             //   10: aload_0
/*       */             //   11: getfield redefinitionStrategy : Lnet/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy;
/*       */             //   14: aload_0
/*       */             //   15: getfield poolStrategy : Lnet/bytebuddy/agent/builder/AgentBuilder$PoolStrategy;
/*       */             //   18: aload_0
/*       */             //   19: getfield locationStrategy : Lnet/bytebuddy/agent/builder/AgentBuilder$LocationStrategy;
/*       */             //   22: aload_0
/*       */             //   23: getfield descriptionStrategy : Lnet/bytebuddy/agent/builder/AgentBuilder$DescriptionStrategy;
/*       */             //   26: aload_0
/*       */             //   27: getfield fallbackStrategy : Lnet/bytebuddy/agent/builder/AgentBuilder$FallbackStrategy;
/*       */             //   30: aload_0
/*       */             //   31: getfield listener : Lnet/bytebuddy/agent/builder/AgentBuilder$Listener;
/*       */             //   34: aload_0
/*       */             //   35: getfield matcher : Lnet/bytebuddy/agent/builder/AgentBuilder$RawMatcher;
/*       */             //   38: aload_0
/*       */             //   39: getfield circularityLock : Lnet/bytebuddy/agent/builder/AgentBuilder$CircularityLock;
/*       */             //   42: invokevirtual make : (Lnet/bytebuddy/agent/builder/AgentBuilder$PoolStrategy;Lnet/bytebuddy/agent/builder/AgentBuilder$LocationStrategy;Lnet/bytebuddy/agent/builder/AgentBuilder$DescriptionStrategy;Lnet/bytebuddy/agent/builder/AgentBuilder$FallbackStrategy;Lnet/bytebuddy/agent/builder/AgentBuilder$Listener;Lnet/bytebuddy/agent/builder/AgentBuilder$RawMatcher;Lnet/bytebuddy/agent/builder/AgentBuilder$CircularityLock;)Lnet/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$Collector;
/*       */             //   45: astore_2
/*       */             //   46: aload_0
/*       */             //   47: getfield types : Ljava/util/concurrent/ConcurrentMap;
/*       */             //   50: invokeinterface entrySet : ()Ljava/util/Set;
/*       */             //   55: invokeinterface iterator : ()Ljava/util/Iterator;
/*       */             //   60: astore_3
/*       */             //   61: aload_3
/*       */             //   62: invokeinterface hasNext : ()Z
/*       */             //   67: ifeq -> 285
/*       */             //   70: invokestatic interrupted : ()Z
/*       */             //   73: ifeq -> 80
/*       */             //   76: jsr -> 315
/*       */             //   79: return
/*       */             //   80: aload_3
/*       */             //   81: invokeinterface next : ()Ljava/lang/Object;
/*       */             //   86: checkcast java/util/Map$Entry
/*       */             //   89: dup
/*       */             //   90: astore #4
/*       */             //   92: invokeinterface getKey : ()Ljava/lang/Object;
/*       */             //   97: checkcast net/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey
/*       */             //   100: invokevirtual get : ()Ljava/lang/Object;
/*       */             //   103: checkcast java/lang/ClassLoader
/*       */             //   106: dup
/*       */             //   107: astore #5
/*       */             //   109: ifnonnull -> 128
/*       */             //   112: aload #4
/*       */             //   114: invokeinterface getKey : ()Ljava/lang/Object;
/*       */             //   119: checkcast net/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey
/*       */             //   122: invokevirtual isBootstrapLoader : ()Z
/*       */             //   125: ifeq -> 276
/*       */             //   128: aload #4
/*       */             //   130: invokeinterface getValue : ()Ljava/lang/Object;
/*       */             //   135: checkcast java/util/Set
/*       */             //   138: invokeinterface iterator : ()Ljava/util/Iterator;
/*       */             //   143: astore #4
/*       */             //   145: aload #4
/*       */             //   147: invokeinterface hasNext : ()Z
/*       */             //   152: ifeq -> 273
/*       */             //   155: invokestatic interrupted : ()Z
/*       */             //   158: ifeq -> 165
/*       */             //   161: jsr -> 315
/*       */             //   164: return
/*       */             //   165: aload #4
/*       */             //   167: invokeinterface next : ()Ljava/lang/Object;
/*       */             //   172: checkcast java/lang/String
/*       */             //   175: iconst_0
/*       */             //   176: aload #5
/*       */             //   178: invokestatic forName : (Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
/*       */             //   181: astore #6
/*       */             //   183: aload_2
/*       */             //   184: aload #6
/*       */             //   186: dup
/*       */             //   187: invokevirtual isArray : ()Z
/*       */             //   190: ifne -> 237
/*       */             //   193: aload #6
/*       */             //   195: invokevirtual isPrimitive : ()Z
/*       */             //   198: ifne -> 237
/*       */             //   201: getstatic net/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy.DISPATCHER : Lnet/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$Dispatcher;
/*       */             //   204: aload_0
/*       */             //   205: getfield instrumentation : Ljava/lang/instrument/Instrumentation;
/*       */             //   208: aload #6
/*       */             //   210: invokeinterface isModifiableClass : (Ljava/lang/instrument/Instrumentation;Ljava/lang/Class;)Z
/*       */             //   215: ifne -> 233
/*       */             //   218: getstatic net/bytebuddy/ClassFileVersion.JAVA_V5 : Lnet/bytebuddy/ClassFileVersion;
/*       */             //   221: invokestatic ofThisVm : (Lnet/bytebuddy/ClassFileVersion;)Lnet/bytebuddy/ClassFileVersion;
/*       */             //   224: getstatic net/bytebuddy/ClassFileVersion.JAVA_V5 : Lnet/bytebuddy/ClassFileVersion;
/*       */             //   227: invokevirtual isAtMost : (Lnet/bytebuddy/ClassFileVersion;)Z
/*       */             //   230: ifeq -> 237
/*       */             //   233: iconst_1
/*       */             //   234: goto -> 238
/*       */             //   237: iconst_0
/*       */             //   238: invokevirtual consider : (Ljava/lang/Class;Z)V
/*       */             //   241: jsr -> 262
/*       */             //   244: goto -> 145
/*       */             //   247: pop
/*       */             //   248: jsr -> 262
/*       */             //   251: goto -> 145
/*       */             //   254: astore #7
/*       */             //   256: jsr -> 262
/*       */             //   259: aload #7
/*       */             //   261: athrow
/*       */             //   262: astore #6
/*       */             //   264: aload #4
/*       */             //   266: invokeinterface remove : ()V
/*       */             //   271: ret #6
/*       */             //   273: goto -> 61
/*       */             //   276: aload_3
/*       */             //   277: invokeinterface remove : ()V
/*       */             //   282: goto -> 61
/*       */             //   285: aload_2
/*       */             //   286: aload_0
/*       */             //   287: getfield instrumentation : Ljava/lang/instrument/Instrumentation;
/*       */             //   290: aload_0
/*       */             //   291: getfield redefinitionBatchAllocator : Lnet/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$BatchAllocator;
/*       */             //   294: aload_0
/*       */             //   295: getfield redefinitionBatchListener : Lnet/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$Listener;
/*       */             //   298: iconst_0
/*       */             //   299: invokevirtual apply : (Ljava/lang/instrument/Instrumentation;Lnet/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$BatchAllocator;Lnet/bytebuddy/agent/builder/AgentBuilder$RedefinitionStrategy$Listener;I)I
/*       */             //   302: pop
/*       */             //   303: jsr -> 315
/*       */             //   306: return
/*       */             //   307: astore #8
/*       */             //   309: jsr -> 315
/*       */             //   312: aload #8
/*       */             //   314: athrow
/*       */             //   315: astore_2
/*       */             //   316: iload_1
/*       */             //   317: ifeq -> 329
/*       */             //   320: aload_0
/*       */             //   321: getfield circularityLock : Lnet/bytebuddy/agent/builder/AgentBuilder$CircularityLock;
/*       */             //   324: invokeinterface release : ()V
/*       */             //   329: ret #2
/*       */             // Line number table:
/*       */             //   Java source line number -> byte code offset
/*       */             //   #7535	-> 0
/*       */             //   #7537	-> 10
/*       */             //   #7544	-> 46
/*       */             //   #7545	-> 61
/*       */             //   #7546	-> 70
/*       */             //   #7547	-> 76
/*       */             //   #7549	-> 80
/*       */             //   #7550	-> 90
/*       */             //   #7551	-> 107
/*       */             //   #7552	-> 128
/*       */             //   #7553	-> 145
/*       */             //   #7554	-> 155
/*       */             //   #7555	-> 161
/*       */             //   #7558	-> 165
/*       */             //   #7559	-> 183
/*       */             //   #7560	-> 195
/*       */             //   #7561	-> 210
/*       */             //   #7562	-> 221
/*       */             //   #7559	-> 238
/*       */             //   #7563	-> 241
/*       */             //   #7567	-> 244
/*       */             //   #7563	-> 247
/*       */             //   #7565	-> 248
/*       */             //   #7567	-> 251
/*       */             //   #7566	-> 254
/*       */             //   #7567	-> 259
/*       */             //   #7566	-> 264
/*       */             //   #7569	-> 273
/*       */             //   #7570	-> 276
/*       */             //   #7572	-> 282
/*       */             //   #7573	-> 285
/*       */             //   #7577	-> 303
/*       */             //   #7581	-> 306
/*       */             //   #7578	-> 307
/*       */             //   #7581	-> 312
/*       */             //   #7578	-> 316
/*       */             //   #7579	-> 320
/*       */             // Exception table:
/*       */             //   from	to	target	type
/*       */             //   10	79	307	finally
/*       */             //   80	164	307	finally
/*       */             //   165	241	247	java/lang/Throwable
/*       */             //   165	244	254	finally
/*       */             //   165	306	307	finally
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
/*       */         protected static class LookupKey
/*       */         {
/*       */           @MaybeNull
/*       */           private final ClassLoader classLoader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final int hashCode;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected LookupKey(@MaybeNull ClassLoader param4ClassLoader) {
/*  7607 */             this.classLoader = param4ClassLoader;
/*  7608 */             this.hashCode = System.identityHashCode(param4ClassLoader);
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*  7613 */             return this.hashCode;
/*       */           }
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"}, justification = "Cross-comparison is intended.")
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*  7619 */             if (this == param4Object)
/*  7620 */               return true; 
/*  7621 */             if (param4Object instanceof LookupKey)
/*  7622 */               return (this.classLoader == ((LookupKey)param4Object).classLoader); 
/*  7623 */             if (param4Object instanceof AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey) {
/*  7624 */               param4Object = param4Object;
/*  7625 */               return (this.hashCode == AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey.a((AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey)param4Object) && this.classLoader == param4Object.get());
/*       */             } 
/*  7627 */             return false;
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class StorageKey
/*       */           extends WeakReference<ClassLoader>
/*       */         {
/*       */           private final int hashCode;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected StorageKey(@MaybeNull ClassLoader param4ClassLoader) {
/*  7648 */             super(param4ClassLoader);
/*  7649 */             this.hashCode = System.identityHashCode(param4ClassLoader);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected boolean isBootstrapLoader() {
/*  7658 */             return (this.hashCode == 0);
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*  7663 */             return this.hashCode;
/*       */           }
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"}, justification = "Cross-comparison is intended.")
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*  7669 */             if (this == param4Object)
/*  7670 */               return true; 
/*  7671 */             if (param4Object instanceof AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.LookupKey) {
/*  7672 */               param4Object = param4Object;
/*  7673 */               return (this.hashCode == AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.LookupKey.a((AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.LookupKey)param4Object) && get() == AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.LookupKey.b((AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.LookupKey)param4Object));
/*  7674 */             }  if (param4Object instanceof StorageKey) {
/*  7675 */               param4Object = param4Object;
/*  7676 */               return (this.hashCode == ((StorageKey)param4Object).hashCode && get() == param4Object.get());
/*       */             } 
/*  7678 */             return false;
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
/*       */       @Enhance
/*       */       public static class Installation
/*       */       {
/*       */         private final AgentBuilder.Listener listener;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AgentBuilder.InstallationListener installationListener;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Installation(AgentBuilder.Listener param3Listener, AgentBuilder.InstallationListener param3InstallationListener, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param3ResubmissionEnforcer) {
/*  7713 */           this.listener = param3Listener;
/*  7714 */           this.installationListener = param3InstallationListener;
/*  7715 */           this.resubmissionEnforcer = param3ResubmissionEnforcer;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected AgentBuilder.Listener getListener() {
/*  7724 */           return this.listener;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected AgentBuilder.InstallationListener getInstallationListener() {
/*  7733 */           return this.installationListener;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer getResubmissionEnforcer() {
/*  7742 */           return this.resubmissionEnforcer;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.listener.equals(((Installation)param3Object).listener) ? false : (!this.installationListener.equals(((Installation)param3Object).installationListener) ? false : (!!this.resubmissionEnforcer.equals(((Installation)param3Object).resubmissionEnforcer))))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.listener.hashCode()) * 31 + this.installationListener.hashCode()) * 31 + this.resubmissionEnforcer.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected static interface ResubmissionEnforcer
/*       */     {
/*       */       boolean isEnforced(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class);
/*       */ 
/*       */ 
/*       */       
/*       */       public enum Disabled
/*       */         implements ResubmissionEnforcer
/*       */       {
/*  7771 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final boolean isEnforced(String param3String, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull Class<?> param3Class) {
/*  7777 */           return false;
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
/*       */     @Proxied("java.lang.instrument.Instrumentation")
/*       */     protected static interface Dispatcher
/*       */     {
/*       */       @Proxied("isModifiableClass")
/*       */       boolean isModifiableClass(Instrumentation param2Instrumentation, Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Defaults
/*       */       @Proxied("isRetransformClassesSupported")
/*       */       boolean isRetransformClassesSupported(Instrumentation param2Instrumentation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Proxied("retransformClasses")
/*       */       void retransformClasses(Instrumentation param2Instrumentation, Class<?>[] param2ArrayOfClass);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected static abstract class Collector
/*       */     {
/*       */       private final AgentBuilder.RawMatcher matcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final AgentBuilder.PoolStrategy poolStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final AgentBuilder.LocationStrategy locationStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final AgentBuilder.DescriptionStrategy descriptionStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final AgentBuilder.Listener listener;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final AgentBuilder.FallbackStrategy fallbackStrategy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final AgentBuilder.CircularityLock circularityLock;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<Class<?>> types;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Collector(AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.Listener param2Listener, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.CircularityLock param2CircularityLock) {
/*  7879 */         this.matcher = param2RawMatcher;
/*  7880 */         this.poolStrategy = param2PoolStrategy;
/*  7881 */         this.locationStrategy = param2LocationStrategy;
/*  7882 */         this.descriptionStrategy = param2DescriptionStrategy;
/*  7883 */         this.listener = param2Listener;
/*  7884 */         this.fallbackStrategy = param2FallbackStrategy;
/*  7885 */         this.circularityLock = param2CircularityLock;
/*  7886 */         this.types = new ArrayList<Class<?>>();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected void consider(Class<?> param2Class, boolean param2Boolean) {
/*  7896 */         JavaModule javaModule = JavaModule.ofType(param2Class);
/*       */         try {
/*  7898 */           TypePool typePool = this.poolStrategy.typePool(this.locationStrategy.classFileLocator(param2Class.getClassLoader(), javaModule), param2Class.getClassLoader());
/*       */           try {
/*  7900 */             doConsider(this.matcher, this.listener, this.descriptionStrategy
/*       */                 
/*  7902 */                 .apply(TypeDescription.ForLoadedType.getName(param2Class), param2Class, typePool, this.circularityLock, param2Class.getClassLoader(), javaModule), param2Class, param2Class, javaModule, param2Boolean);
/*       */ 
/*       */ 
/*       */           
/*       */           }
/*  7907 */           catch (Throwable throwable) {
/*  7908 */             if (this.descriptionStrategy.isLoadedFirst() && this.fallbackStrategy.isFallback(param2Class, throwable)) {
/*  7909 */               doConsider(this.matcher, this.listener, typePool
/*       */                   
/*  7911 */                   .describe(TypeDescription.ForLoadedType.getName(param2Class)).resolve(), param2Class, null, javaModule, true);
/*       */             
/*       */             }
/*       */             else {
/*       */ 
/*       */               
/*  7917 */               throw throwable;
/*       */             } 
/*       */           } 
/*  7920 */         } catch (Throwable throwable) {
/*       */           try {
/*       */             try {
/*  7923 */               this.listener.onDiscovery(TypeDescription.ForLoadedType.getName(param2Class), param2Class.getClassLoader(), javaModule, true);
/*       */             } finally {
/*       */               try {
/*  7926 */                 this.listener.onError(TypeDescription.ForLoadedType.getName(param2Class), param2Class.getClassLoader(), javaModule, true, throwable);
/*       */               } finally {
/*  7928 */                 this.listener.onComplete(TypeDescription.ForLoadedType.getName(param2Class), param2Class.getClassLoader(), javaModule, true);
/*       */               } 
/*       */             } 
/*  7931 */           } catch (Throwable throwable1) {}
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void doConsider(AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.Listener param2Listener, TypeDescription param2TypeDescription, Class<?> param2Class1, @MaybeNull Class<?> param2Class2, @MaybeNull JavaModule param2JavaModule, boolean param2Boolean) {
/*  7955 */         if (!param2Boolean || !param2RawMatcher.matches(param2TypeDescription, param2Class1.getClassLoader(), param2JavaModule, param2Class2, param2Class1.getProtectionDomain())) {
/*       */           try {
/*       */             try {
/*  7958 */               param2Listener.onDiscovery(TypeDescription.ForLoadedType.getName(param2Class1), param2Class1.getClassLoader(), param2JavaModule, (param2Class2 != null));
/*  7959 */               param2Listener.onIgnored(param2TypeDescription, param2Class1.getClassLoader(), param2JavaModule, (param2Class2 != null));
/*  7960 */             } catch (Throwable throwable) {
/*  7961 */               param2Listener.onError(TypeDescription.ForLoadedType.getName(param2Class1), param2Class1.getClassLoader(), param2JavaModule, (param2Class2 != null), throwable);
/*       */             } finally {
/*  7963 */               param2Listener.onComplete(TypeDescription.ForLoadedType.getName(param2Class1), param2Class1.getClassLoader(), param2JavaModule, (param2Class2 != null));
/*       */             } 
/*  7965 */           } catch (Throwable throwable) {
/*       */             return;
/*       */           } 
/*       */         } else {
/*  7969 */           this.types.add(param2Class1);
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
/*       */       protected int apply(Instrumentation param2Instrumentation, AgentBuilder.RedefinitionStrategy.BatchAllocator param2BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param2Listener, int param2Int) {
/*  7986 */         HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  7987 */         PrependableIterator prependableIterator = new PrependableIterator(param2BatchAllocator.batch(this.types));
/*  7988 */         while (prependableIterator.hasNext()) {
/*  7989 */           List<Class<?>> list = prependableIterator.next();
/*  7990 */           param2Listener.onBatch(param2Int, list, this.types);
/*       */           try {
/*  7992 */             doApply(param2Instrumentation, list);
/*  7993 */           } catch (Throwable throwable) {
/*  7994 */             prependableIterator.prepend(param2Listener.onError(param2Int, list, throwable, this.types));
/*  7995 */             hashMap.put(list, throwable);
/*       */           } 
/*  7997 */           param2Int++;
/*       */         } 
/*  7999 */         param2Listener.onComplete(param2Int, this.types, (Map)hashMap);
/*  8000 */         return param2Int;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract void doApply(Instrumentation param2Instrumentation, List<Class<?>> param2List);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class PrependableIterator
/*       */         implements Iterator<List<Class<?>>>
/*       */       {
/*       */         private Iterator<? extends List<Class<?>>> current;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final List<Iterator<? extends List<Class<?>>>> backlog;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected PrependableIterator(Iterable<? extends List<Class<?>>> param3Iterable) {
/*  8035 */           this.current = param3Iterable.iterator();
/*  8036 */           this.backlog = new ArrayList<Iterator<? extends List<Class<?>>>>();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void prepend(Iterable<? extends List<Class<?>>> param3Iterable) {
/*       */           Iterator<? extends List<Class<?>>> iterator;
/*  8046 */           if ((iterator = param3Iterable.iterator()).hasNext()) {
/*  8047 */             if (this.current.hasNext()) {
/*  8048 */               this.backlog.add(this.current);
/*       */             }
/*  8050 */             this.current = iterator;
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean hasNext() {
/*  8058 */           return this.current.hasNext();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public List<Class<?>> next() {
/*       */           try {
/*  8066 */             return this.current.next();
/*       */           } finally {
/*  8068 */             while (!this.current.hasNext() && !this.backlog.isEmpty()) {
/*  8069 */               this.current = this.backlog.remove(this.backlog.size() - 1);
/*       */             }
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void remove() {
/*  8078 */           throw new UnsupportedOperationException("remove");
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class ForRedefinition
/*       */         extends Collector
/*       */       {
/*       */         protected ForRedefinition(AgentBuilder.RawMatcher param3RawMatcher, AgentBuilder.PoolStrategy param3PoolStrategy, AgentBuilder.LocationStrategy param3LocationStrategy, AgentBuilder.DescriptionStrategy param3DescriptionStrategy, AgentBuilder.Listener param3Listener, AgentBuilder.FallbackStrategy param3FallbackStrategy, AgentBuilder.CircularityLock param3CircularityLock) {
/*  8105 */           super(param3RawMatcher, param3PoolStrategy, param3LocationStrategy, param3DescriptionStrategy, param3Listener, param3FallbackStrategy, param3CircularityLock);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected void doApply(Instrumentation param3Instrumentation, List<Class<?>> param3List) {
/*  8111 */           ArrayList<ClassDefinition> arrayList = new ArrayList(param3List.size());
/*  8112 */           for (Class<?> clazz : param3List) {
/*       */             try {
/*       */               try {
/*  8115 */                 arrayList.add(new ClassDefinition(clazz, this.locationStrategy.classFileLocator(clazz.getClassLoader(), JavaModule.ofType(clazz))
/*  8116 */                       .locate(TypeDescription.ForLoadedType.getName(clazz))
/*  8117 */                       .resolve()));
/*  8118 */               } catch (Throwable throwable) {
/*  8119 */                 JavaModule javaModule = JavaModule.ofType(clazz);
/*       */                 try {
/*  8121 */                   this.listener.onDiscovery(TypeDescription.ForLoadedType.getName(clazz), clazz.getClassLoader(), javaModule, true);
/*       */                 } finally {
/*       */                   try {
/*  8124 */                     this.listener.onError(TypeDescription.ForLoadedType.getName(clazz), clazz.getClassLoader(), javaModule, true, throwable);
/*       */                   } finally {
/*  8126 */                     this.listener.onComplete(TypeDescription.ForLoadedType.getName(clazz), clazz.getClassLoader(), javaModule, true);
/*       */                   } 
/*       */                 } 
/*       */               } 
/*  8130 */             } catch (Throwable throwable) {}
/*       */           } 
/*       */ 
/*       */           
/*  8134 */           if (!arrayList.isEmpty()) {
/*  8135 */             this.circularityLock.release();
/*       */             try {
/*  8137 */               param3Instrumentation.redefineClasses(arrayList.<ClassDefinition>toArray(new ClassDefinition[0])); return;
/*       */             } finally {
/*  8139 */               this.circularityLock.acquire();
/*       */             } 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class ForRetransformation
/*       */         extends Collector
/*       */       {
/*       */         protected ForRetransformation(AgentBuilder.RawMatcher param3RawMatcher, AgentBuilder.PoolStrategy param3PoolStrategy, AgentBuilder.LocationStrategy param3LocationStrategy, AgentBuilder.DescriptionStrategy param3DescriptionStrategy, AgentBuilder.Listener param3Listener, AgentBuilder.FallbackStrategy param3FallbackStrategy, AgentBuilder.CircularityLock param3CircularityLock) {
/*  8168 */           super(param3RawMatcher, param3PoolStrategy, param3LocationStrategy, param3DescriptionStrategy, param3Listener, param3FallbackStrategy, param3CircularityLock);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected void doApply(Instrumentation param3Instrumentation, List<Class<?>> param3List) {
/*  8174 */           if (!param3List.isEmpty()) {
/*  8175 */             this.circularityLock.release();
/*       */             try {
/*  8177 */               AgentBuilder.RedefinitionStrategy.DISPATCHER.retransformClasses(param3Instrumentation, (Class[])param3List.<Class<?>[]>toArray((Class<?>[][])new Class[0])); return;
/*       */             } finally {
/*  8179 */               this.circularityLock.acquire();
/*       */             } 
/*       */           } 
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
/*       */   public enum LambdaInstrumentationStrategy
/*       */   {
/*  8210 */     ENABLED
/*       */     {
/*       */       
/*       */       protected final void apply(ByteBuddy param2ByteBuddy, Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer)
/*       */       {
/*  8215 */         if (LambdaFactory.register(param2ClassFileTransformer, new LambdaInstanceFactory(param2ByteBuddy))) {
/*       */           Class<?> clazz;
/*       */           try {
/*  8218 */             clazz = Class.forName("java.lang.invoke.LambdaMetafactory");
/*  8219 */           } catch (ClassNotFoundException classNotFoundException) {
/*       */             return;
/*       */           } 
/*  8222 */           param2ByteBuddy.with((Implementation.Context.Factory)Implementation.Context.Disabled.Factory.INSTANCE)
/*  8223 */             .redefine(clazz)
/*  8224 */             .method((ElementMatcher)ElementMatchers.isPublic().and((ElementMatcher)ElementMatchers.named("metafactory")))
/*  8225 */             .intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { LambdaMetafactoryFactory.REGULAR
/*  8226 */                 })).method((ElementMatcher)ElementMatchers.isPublic().and((ElementMatcher)ElementMatchers.named("altMetafactory")))
/*  8227 */             .intercept((Implementation)new Implementation.Simple(new ByteCodeAppender[] { LambdaMetafactoryFactory.ALTERNATIVE
/*  8228 */                 })).make()
/*  8229 */             .load(clazz.getClassLoader(), (ClassLoadingStrategy)ClassReloadingStrategy.of(param2Instrumentation));
/*       */         } 
/*       */       }
/*       */ 
/*       */       
/*       */       protected final boolean isInstrumented(@MaybeNull Class<?> param2Class) {
/*  8235 */         return true;
/*       */       }
/*       */     },
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  8242 */     DISABLED
/*       */     {
/*       */       protected final void apply(ByteBuddy param2ByteBuddy, Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final boolean isInstrumented(@MaybeNull Class<?> param2Class) {
/*  8252 */         return (param2Class == null || !param2Class.getName().contains("/"));
/*       */       }
/*       */     };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static void release(ClassFileTransformer param1ClassFileTransformer, Instrumentation param1Instrumentation) {
/*  8264 */       if (LambdaFactory.release(param1ClassFileTransformer)) {
/*       */         try {
/*  8266 */           ClassReloadingStrategy.of(param1Instrumentation).reset(new Class[] { Class.forName("java.lang.invoke.LambdaMetafactory") }); return;
/*  8267 */         } catch (Exception exception) {
/*  8268 */           throw new IllegalStateException("Could not release lambda transformer", exception);
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
/*       */     public static LambdaInstrumentationStrategy of(boolean param1Boolean) {
/*  8280 */       return param1Boolean ? ENABLED : DISABLED;
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
/*       */     public boolean isEnabled() {
/*  8300 */       return (this == ENABLED);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract void apply(ByteBuddy param1ByteBuddy, Instrumentation param1Instrumentation, ClassFileTransformer param1ClassFileTransformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract boolean isInstrumented(@MaybeNull Class<?> param1Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected enum LambdaMetafactoryFactory
/*       */       implements ByteCodeAppender
/*       */     {
/*  8390 */       REGULAR(6, 11)
/*       */       {
/*       */         protected final void onDispatch(MethodVisitor param3MethodVisitor) {
/*  8393 */           param3MethodVisitor.visitInsn(3);
/*  8394 */           param3MethodVisitor.visitVarInsn(54, 6);
/*  8395 */           param3MethodVisitor.visitMethodInsn(184, "java/util/Collections", "emptyList", "()Ljava/util/List;", false);
/*  8396 */           param3MethodVisitor.visitVarInsn(58, 7);
/*  8397 */           param3MethodVisitor.visitMethodInsn(184, "java/util/Collections", "emptyList", "()Ljava/util/List;", false);
/*  8398 */           param3MethodVisitor.visitVarInsn(58, 8);
/*  8399 */           param3MethodVisitor.visitFrame(1, 3, new Object[] { Opcodes.INTEGER, "java/util/List", "java/util/List" }, 0, null);
/*       */         }
/*       */       },
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  8406 */       ALTERNATIVE(6, 16)
/*       */       {
/*       */         protected final void onDispatch(MethodVisitor param3MethodVisitor) {
/*  8409 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8410 */           param3MethodVisitor.visitInsn(6);
/*  8411 */           param3MethodVisitor.visitInsn(50);
/*  8412 */           param3MethodVisitor.visitTypeInsn(192, "java/lang/Integer");
/*  8413 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I", false);
/*  8414 */           param3MethodVisitor.visitVarInsn(54, 4);
/*  8415 */           param3MethodVisitor.visitInsn(7);
/*  8416 */           param3MethodVisitor.visitVarInsn(54, 5);
/*  8417 */           param3MethodVisitor.visitVarInsn(21, 4);
/*  8418 */           param3MethodVisitor.visitInsn(5);
/*  8419 */           param3MethodVisitor.visitInsn(126);
/*  8420 */           Label label1 = new Label();
/*  8421 */           param3MethodVisitor.visitJumpInsn(153, label1);
/*  8422 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8423 */           param3MethodVisitor.visitVarInsn(21, 5);
/*  8424 */           param3MethodVisitor.visitIincInsn(5, 1);
/*  8425 */           param3MethodVisitor.visitInsn(50);
/*  8426 */           param3MethodVisitor.visitTypeInsn(192, "java/lang/Integer");
/*  8427 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I", false);
/*  8428 */           param3MethodVisitor.visitVarInsn(54, 7);
/*  8429 */           param3MethodVisitor.visitVarInsn(21, 7);
/*  8430 */           param3MethodVisitor.visitTypeInsn(189, "java/lang/Class");
/*  8431 */           param3MethodVisitor.visitVarInsn(58, 6);
/*  8432 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8433 */           param3MethodVisitor.visitVarInsn(21, 5);
/*  8434 */           param3MethodVisitor.visitVarInsn(25, 6);
/*  8435 */           param3MethodVisitor.visitInsn(3);
/*  8436 */           param3MethodVisitor.visitVarInsn(21, 7);
/*  8437 */           param3MethodVisitor.visitMethodInsn(184, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
/*  8438 */           param3MethodVisitor.visitVarInsn(21, 5);
/*  8439 */           param3MethodVisitor.visitVarInsn(21, 7);
/*  8440 */           param3MethodVisitor.visitInsn(96);
/*  8441 */           param3MethodVisitor.visitVarInsn(54, 5);
/*  8442 */           Label label2 = new Label();
/*  8443 */           param3MethodVisitor.visitJumpInsn(167, label2);
/*  8444 */           param3MethodVisitor.visitLabel(label1);
/*  8445 */           param3MethodVisitor.visitFrame(1, 2, new Object[] { Opcodes.INTEGER, Opcodes.INTEGER }, 0, null);
/*  8446 */           param3MethodVisitor.visitInsn(3);
/*  8447 */           param3MethodVisitor.visitTypeInsn(189, "java/lang/Class");
/*  8448 */           param3MethodVisitor.visitVarInsn(58, 6);
/*  8449 */           param3MethodVisitor.visitLabel(label2);
/*  8450 */           param3MethodVisitor.visitFrame(1, 1, new Object[] { "[Ljava/lang/Class;" }, 0, null);
/*  8451 */           param3MethodVisitor.visitVarInsn(21, 4);
/*  8452 */           param3MethodVisitor.visitInsn(5);
/*  8453 */           param3MethodVisitor.visitInsn(126);
/*  8454 */           label1 = new Label();
/*  8455 */           param3MethodVisitor.visitJumpInsn(153, label1);
/*  8456 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8457 */           param3MethodVisitor.visitVarInsn(21, 5);
/*  8458 */           param3MethodVisitor.visitIincInsn(5, 1);
/*  8459 */           param3MethodVisitor.visitInsn(50);
/*  8460 */           param3MethodVisitor.visitTypeInsn(192, "java/lang/Integer");
/*  8461 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I", false);
/*  8462 */           param3MethodVisitor.visitVarInsn(54, 8);
/*  8463 */           param3MethodVisitor.visitVarInsn(21, 8);
/*  8464 */           param3MethodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodType");
/*  8465 */           param3MethodVisitor.visitVarInsn(58, 7);
/*  8466 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8467 */           param3MethodVisitor.visitVarInsn(21, 5);
/*  8468 */           param3MethodVisitor.visitVarInsn(25, 7);
/*  8469 */           param3MethodVisitor.visitInsn(3);
/*  8470 */           param3MethodVisitor.visitVarInsn(21, 8);
/*  8471 */           param3MethodVisitor.visitMethodInsn(184, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
/*  8472 */           label2 = new Label();
/*  8473 */           param3MethodVisitor.visitJumpInsn(167, label2);
/*  8474 */           param3MethodVisitor.visitLabel(label1);
/*  8475 */           param3MethodVisitor.visitFrame(3, 0, null, 0, null);
/*  8476 */           param3MethodVisitor.visitInsn(3);
/*  8477 */           param3MethodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodType");
/*  8478 */           param3MethodVisitor.visitVarInsn(58, 7);
/*  8479 */           param3MethodVisitor.visitLabel(label2);
/*  8480 */           param3MethodVisitor.visitFrame(1, 1, new Object[] { "[Ljava/lang/invoke/MethodType;" }, 0, null);
/*  8481 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8482 */           param3MethodVisitor.visitInsn(3);
/*  8483 */           param3MethodVisitor.visitInsn(50);
/*  8484 */           param3MethodVisitor.visitTypeInsn(192, "java/lang/invoke/MethodType");
/*  8485 */           param3MethodVisitor.visitVarInsn(58, 8);
/*  8486 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8487 */           param3MethodVisitor.visitInsn(4);
/*  8488 */           param3MethodVisitor.visitInsn(50);
/*  8489 */           param3MethodVisitor.visitTypeInsn(192, "java/lang/invoke/MethodHandle");
/*  8490 */           param3MethodVisitor.visitVarInsn(58, 9);
/*  8491 */           param3MethodVisitor.visitVarInsn(25, 3);
/*  8492 */           param3MethodVisitor.visitInsn(5);
/*  8493 */           param3MethodVisitor.visitInsn(50);
/*  8494 */           param3MethodVisitor.visitTypeInsn(192, "java/lang/invoke/MethodType");
/*  8495 */           param3MethodVisitor.visitVarInsn(58, 10);
/*  8496 */           param3MethodVisitor.visitVarInsn(21, 4);
/*  8497 */           param3MethodVisitor.visitInsn(4);
/*  8498 */           param3MethodVisitor.visitInsn(126);
/*  8499 */           label1 = new Label();
/*  8500 */           param3MethodVisitor.visitJumpInsn(153, label1);
/*  8501 */           param3MethodVisitor.visitInsn(4);
/*  8502 */           label2 = new Label();
/*  8503 */           param3MethodVisitor.visitJumpInsn(167, label2);
/*  8504 */           param3MethodVisitor.visitLabel(label1);
/*  8505 */           param3MethodVisitor.visitFrame(1, 3, new Object[] { "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType" }, 0, null);
/*  8506 */           param3MethodVisitor.visitInsn(3);
/*  8507 */           param3MethodVisitor.visitLabel(label2);
/*  8508 */           param3MethodVisitor.visitFrame(4, 0, null, 1, new Object[] { Opcodes.INTEGER });
/*  8509 */           param3MethodVisitor.visitVarInsn(54, 11);
/*  8510 */           param3MethodVisitor.visitVarInsn(25, 6);
/*  8511 */           param3MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "asList", "([Ljava/lang/Object;)Ljava/util/List;", false);
/*  8512 */           param3MethodVisitor.visitVarInsn(58, 12);
/*  8513 */           param3MethodVisitor.visitVarInsn(25, 7);
/*  8514 */           param3MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "asList", "([Ljava/lang/Object;)Ljava/util/List;", false);
/*  8515 */           param3MethodVisitor.visitVarInsn(58, 13);
/*  8516 */           param3MethodVisitor.visitVarInsn(25, 8);
/*  8517 */           param3MethodVisitor.visitVarInsn(58, 3);
/*  8518 */           param3MethodVisitor.visitVarInsn(25, 9);
/*  8519 */           param3MethodVisitor.visitVarInsn(58, 4);
/*  8520 */           param3MethodVisitor.visitVarInsn(25, 10);
/*  8521 */           param3MethodVisitor.visitVarInsn(58, 5);
/*  8522 */           param3MethodVisitor.visitVarInsn(21, 11);
/*  8523 */           param3MethodVisitor.visitVarInsn(54, 6);
/*  8524 */           param3MethodVisitor.visitVarInsn(25, 12);
/*  8525 */           param3MethodVisitor.visitVarInsn(58, 7);
/*  8526 */           param3MethodVisitor.visitVarInsn(25, 13);
/*  8527 */           param3MethodVisitor.visitVarInsn(58, 8);
/*  8528 */           param3MethodVisitor.visitFrame(0, 9, new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER, "java/util/List", "java/util/List" }, 0, null);
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
/*  8543 */       private static final Loader LOADER = resolve(); private final int stackSize;
/*       */       private final int localVariableLength;
/*       */       
/*       */       static {
/*       */       
/*       */       }
/*       */       
/*       */       @SuppressFBWarnings(value = {"DE_MIGHT_IGNORE", "REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*       */       private static Loader resolve() {
/*       */         try {
/*       */           Class<?> clazz;
/*  8554 */           (clazz = Class.forName("java.lang.invoke.MethodHandles$Lookup", false, (ClassLoader)null)).getMethod("defineHiddenClass", new Class[] { byte[].class, boolean.class, 
/*       */ 
/*       */                 
/*  8557 */                 Class.forName("[Ljava.lang.invoke.MethodHandles$Lookup$ClassOption;", false, (ClassLoader)null) });
/*  8558 */           clazz.getMethod("defineHiddenClassWithClassData", new Class[] { byte[].class, Object.class, boolean.class, 
/*       */ 
/*       */ 
/*       */                 
/*  8562 */                 Class.forName("[Ljava.lang.invoke.MethodHandles$Lookup$ClassOption;", false, (ClassLoader)null) });
/*  8563 */           return Loader.UsingMethodHandleLookup.INSTANCE;
/*  8564 */         } catch (Exception exception) {
/*       */           Loader.UsingUnsafe[] arrayOfUsingUnsafe; int i;
/*       */           byte b;
/*  8567 */           for (i = (arrayOfUsingUnsafe = Loader.UsingUnsafe.values()).length, b = 0; b < i; ) { Loader.UsingUnsafe usingUnsafe = arrayOfUsingUnsafe[b];
/*       */             try {
/*  8569 */               Class.forName(usingUnsafe.getType().replace('/', '.'), false, (ClassLoader)null)
/*       */                 
/*  8571 */                 .getMethod("defineAnonymousClass", new Class[] { Class.class, byte[].class, Object[].class });
/*  8572 */               return usingUnsafe;
/*  8573 */             } catch (Exception exception1) {}
/*       */             
/*       */             b++; }
/*       */           
/*  8577 */           return Loader.Unavailable.INSTANCE;
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
/*       */ 
/*       */       
/*       */       LambdaMetafactoryFactory(int param2Int1, int param2Int2) {
/*  8597 */         this.stackSize = param2Int1;
/*  8598 */         this.localVariableLength = param2Int2;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/*  8605 */         onDispatch(param2MethodVisitor);
/*  8606 */         param2MethodVisitor.visitMethodInsn(184, "java/lang/ClassLoader", "getSystemClassLoader", "()Ljava/lang/ClassLoader;", false);
/*  8607 */         param2MethodVisitor.visitLdcInsn("net.bytebuddy.agent.builder.LambdaFactory");
/*  8608 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/ClassLoader", "loadClass", "(Ljava/lang/String;)Ljava/lang/Class;", false);
/*  8609 */         param2MethodVisitor.visitLdcInsn("make");
/*  8610 */         param2MethodVisitor.visitIntInsn(16, 9);
/*  8611 */         param2MethodVisitor.visitTypeInsn(189, "java/lang/Class");
/*  8612 */         param2MethodVisitor.visitInsn(89);
/*  8613 */         param2MethodVisitor.visitInsn(3);
/*  8614 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
/*  8615 */         param2MethodVisitor.visitInsn(83);
/*  8616 */         param2MethodVisitor.visitInsn(89);
/*  8617 */         param2MethodVisitor.visitInsn(4);
/*  8618 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"));
/*  8619 */         param2MethodVisitor.visitInsn(83);
/*  8620 */         param2MethodVisitor.visitInsn(89);
/*  8621 */         param2MethodVisitor.visitInsn(5);
/*  8622 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
/*  8623 */         param2MethodVisitor.visitInsn(83);
/*  8624 */         param2MethodVisitor.visitInsn(89);
/*  8625 */         param2MethodVisitor.visitInsn(6);
/*  8626 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
/*  8627 */         param2MethodVisitor.visitInsn(83);
/*  8628 */         param2MethodVisitor.visitInsn(89);
/*  8629 */         param2MethodVisitor.visitInsn(7);
/*  8630 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
/*  8631 */         param2MethodVisitor.visitInsn(83);
/*  8632 */         param2MethodVisitor.visitInsn(89);
/*  8633 */         param2MethodVisitor.visitInsn(8);
/*  8634 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
/*  8635 */         param2MethodVisitor.visitInsn(83);
/*  8636 */         param2MethodVisitor.visitInsn(89);
/*  8637 */         param2MethodVisitor.visitIntInsn(16, 6);
/*  8638 */         param2MethodVisitor.visitFieldInsn(178, "java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
/*  8639 */         param2MethodVisitor.visitInsn(83);
/*  8640 */         param2MethodVisitor.visitInsn(89);
/*  8641 */         param2MethodVisitor.visitIntInsn(16, 7);
/*  8642 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/util/List;"));
/*  8643 */         param2MethodVisitor.visitInsn(83);
/*  8644 */         param2MethodVisitor.visitInsn(89);
/*  8645 */         param2MethodVisitor.visitIntInsn(16, 8);
/*  8646 */         param2MethodVisitor.visitLdcInsn(Type.getType("Ljava/util/List;"));
/*  8647 */         param2MethodVisitor.visitInsn(83);
/*  8648 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/Class", "getDeclaredMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
/*  8649 */         param2MethodVisitor.visitInsn(1);
/*  8650 */         param2MethodVisitor.visitIntInsn(16, 9);
/*  8651 */         param2MethodVisitor.visitTypeInsn(189, "java/lang/Object");
/*  8652 */         param2MethodVisitor.visitInsn(89);
/*  8653 */         param2MethodVisitor.visitInsn(3);
/*  8654 */         param2MethodVisitor.visitVarInsn(25, 0);
/*  8655 */         param2MethodVisitor.visitInsn(83);
/*  8656 */         param2MethodVisitor.visitInsn(89);
/*  8657 */         param2MethodVisitor.visitInsn(4);
/*  8658 */         param2MethodVisitor.visitVarInsn(25, 1);
/*  8659 */         param2MethodVisitor.visitInsn(83);
/*  8660 */         param2MethodVisitor.visitInsn(89);
/*  8661 */         param2MethodVisitor.visitInsn(5);
/*  8662 */         param2MethodVisitor.visitVarInsn(25, 2);
/*  8663 */         param2MethodVisitor.visitInsn(83);
/*  8664 */         param2MethodVisitor.visitInsn(89);
/*  8665 */         param2MethodVisitor.visitInsn(6);
/*  8666 */         param2MethodVisitor.visitVarInsn(25, 3);
/*  8667 */         param2MethodVisitor.visitInsn(83);
/*  8668 */         param2MethodVisitor.visitInsn(89);
/*  8669 */         param2MethodVisitor.visitInsn(7);
/*  8670 */         param2MethodVisitor.visitVarInsn(25, 4);
/*  8671 */         param2MethodVisitor.visitInsn(83);
/*  8672 */         param2MethodVisitor.visitInsn(89);
/*  8673 */         param2MethodVisitor.visitInsn(8);
/*  8674 */         param2MethodVisitor.visitVarInsn(25, 5);
/*  8675 */         param2MethodVisitor.visitInsn(83);
/*  8676 */         param2MethodVisitor.visitInsn(89);
/*  8677 */         param2MethodVisitor.visitIntInsn(16, 6);
/*  8678 */         param2MethodVisitor.visitVarInsn(21, 6);
/*  8679 */         param2MethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
/*  8680 */         param2MethodVisitor.visitInsn(83);
/*  8681 */         param2MethodVisitor.visitInsn(89);
/*  8682 */         param2MethodVisitor.visitIntInsn(16, 7);
/*  8683 */         param2MethodVisitor.visitVarInsn(25, 7);
/*  8684 */         param2MethodVisitor.visitInsn(83);
/*  8685 */         param2MethodVisitor.visitInsn(89);
/*  8686 */         param2MethodVisitor.visitIntInsn(16, 8);
/*  8687 */         param2MethodVisitor.visitVarInsn(25, 8);
/*  8688 */         param2MethodVisitor.visitInsn(83);
/*  8689 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
/*  8690 */         param2MethodVisitor.visitTypeInsn(192, "[B");
/*  8691 */         param2MethodVisitor.visitVarInsn(58, 9);
/*  8692 */         LOADER.apply(param2MethodVisitor);
/*  8693 */         param2MethodVisitor.visitVarInsn(25, 2);
/*  8694 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodType", "parameterCount", "()I", false);
/*  8695 */         Label label1 = new Label();
/*  8696 */         param2MethodVisitor.visitJumpInsn(154, label1);
/*  8697 */         param2MethodVisitor.visitTypeInsn(187, "java/lang/invoke/ConstantCallSite");
/*  8698 */         param2MethodVisitor.visitInsn(89);
/*  8699 */         param2MethodVisitor.visitVarInsn(25, 2);
/*  8700 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodType", "returnType", "()Ljava/lang/Class;", false);
/*  8701 */         param2MethodVisitor.visitVarInsn(25, 10);
/*  8702 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/Class", "getDeclaredConstructors", "()[Ljava/lang/reflect/Constructor;", false);
/*  8703 */         param2MethodVisitor.visitInsn(3);
/*  8704 */         param2MethodVisitor.visitInsn(50);
/*  8705 */         param2MethodVisitor.visitInsn(3);
/*  8706 */         param2MethodVisitor.visitTypeInsn(189, "java/lang/Object");
/*  8707 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/reflect/Constructor", "newInstance", "([Ljava/lang/Object;)Ljava/lang/Object;", false);
/*  8708 */         param2MethodVisitor.visitMethodInsn(184, "java/lang/invoke/MethodHandles", "constant", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/invoke/MethodHandle;", false);
/*  8709 */         param2MethodVisitor.visitMethodInsn(183, "java/lang/invoke/ConstantCallSite", "<init>", "(Ljava/lang/invoke/MethodHandle;)V", false);
/*  8710 */         Label label2 = new Label();
/*  8711 */         param2MethodVisitor.visitJumpInsn(167, label2);
/*  8712 */         param2MethodVisitor.visitLabel(label1);
/*  8713 */         param2MethodVisitor.visitFrame(0, 11, new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER, "java/util/List", "java/util/List", "[B", "java/lang/Class" }, 0, new Object[0]);
/*  8714 */         param2MethodVisitor.visitTypeInsn(187, "java/lang/invoke/ConstantCallSite");
/*  8715 */         param2MethodVisitor.visitInsn(89);
/*  8716 */         param2MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup", "IMPL_LOOKUP", "Ljava/lang/invoke/MethodHandles$Lookup;");
/*  8717 */         param2MethodVisitor.visitVarInsn(25, 10);
/*  8718 */         param2MethodVisitor.visitLdcInsn("get$Lambda");
/*  8719 */         param2MethodVisitor.visitVarInsn(25, 2);
/*  8720 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false);
/*  8721 */         param2MethodVisitor.visitMethodInsn(183, "java/lang/invoke/ConstantCallSite", "<init>", "(Ljava/lang/invoke/MethodHandle;)V", false);
/*  8722 */         param2MethodVisitor.visitLabel(label2);
/*  8723 */         param2MethodVisitor.visitFrame(4, 0, null, 1, new Object[] { "java/lang/invoke/CallSite" });
/*  8724 */         param2MethodVisitor.visitInsn(176);
/*  8725 */         return new ByteCodeAppender.Size(Math.max(this.stackSize, LOADER.getStackSize()), Math.max(this.localVariableLength, LOADER.getLocalVariableLength()));
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
/*       */       protected abstract void onDispatch(MethodVisitor param2MethodVisitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum Unavailable
/*       */         implements Loader
/*       */       {
/*  8770 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void apply(MethodVisitor param3MethodVisitor) {
/*  8776 */           throw new IllegalStateException("No lambda expression loading strategy available on current VM");
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final int getStackSize() {
/*  8783 */           throw new IllegalStateException("No lambda expression loading strategy available on current VM");
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final int getLocalVariableLength() {
/*  8790 */           throw new IllegalStateException("No lambda expression loading strategy available on current VM");
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum UsingMethodHandleLookup
/*       */         implements Loader
/*       */       {
/*  8822 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void apply(MethodVisitor param3MethodVisitor) {
/*  8828 */           param3MethodVisitor.visitVarInsn(25, 0);
/*  8829 */           param3MethodVisitor.visitVarInsn(25, 4);
/*  8830 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "revealDirect", "(Ljava/lang/invoke/MethodHandle;)Ljava/lang/invoke/MethodHandleInfo;", false);
/*  8831 */           param3MethodVisitor.visitVarInsn(58, 10);
/*  8832 */           param3MethodVisitor.visitVarInsn(25, 10);
/*  8833 */           param3MethodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getModifiers", "()I", true);
/*  8834 */           param3MethodVisitor.visitMethodInsn(184, "java/lang/reflect/Modifier", "isProtected", "(I)Z", false);
/*  8835 */           Label label1 = new Label();
/*  8836 */           param3MethodVisitor.visitJumpInsn(153, label1);
/*  8837 */           param3MethodVisitor.visitVarInsn(25, 0);
/*  8838 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
/*  8839 */           param3MethodVisitor.visitVarInsn(25, 10);
/*  8840 */           param3MethodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getDeclaringClass", "()Ljava/lang/Class;", true);
/*  8841 */           param3MethodVisitor.visitMethodInsn(184, "sun/invoke/util/VerifyAccess", "isSamePackage", "(Ljava/lang/Class;Ljava/lang/Class;)Z", false);
/*  8842 */           Label label2 = new Label();
/*  8843 */           param3MethodVisitor.visitJumpInsn(153, label2);
/*  8844 */           param3MethodVisitor.visitLabel(label1);
/*  8845 */           param3MethodVisitor.visitFrame(0, 11, new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER, "java/util/List", "java/util/List", "[B", "java/lang/invoke/MethodHandleInfo" }, 0, new Object[0]);
/*  8846 */           param3MethodVisitor.visitVarInsn(25, 10);
/*  8847 */           param3MethodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getReferenceKind", "()I", true);
/*  8848 */           param3MethodVisitor.visitIntInsn(16, 7);
/*  8849 */           label1 = new Label();
/*  8850 */           param3MethodVisitor.visitJumpInsn(160, label1);
/*  8851 */           param3MethodVisitor.visitLabel(label2);
/*  8852 */           param3MethodVisitor.visitFrame(3, 0, null, 0, null);
/*  8853 */           param3MethodVisitor.visitInsn(4);
/*  8854 */           label2 = new Label();
/*  8855 */           param3MethodVisitor.visitJumpInsn(167, label2);
/*  8856 */           param3MethodVisitor.visitLabel(label1);
/*  8857 */           param3MethodVisitor.visitFrame(3, 0, null, 0, null);
/*  8858 */           param3MethodVisitor.visitInsn(3);
/*  8859 */           param3MethodVisitor.visitLabel(label2);
/*  8860 */           param3MethodVisitor.visitFrame(4, 0, null, 1, new Object[] { Opcodes.INTEGER });
/*  8861 */           param3MethodVisitor.visitVarInsn(54, 11);
/*  8862 */           param3MethodVisitor.visitVarInsn(21, 11);
/*  8863 */           label1 = new Label();
/*  8864 */           param3MethodVisitor.visitJumpInsn(153, label1);
/*  8865 */           param3MethodVisitor.visitVarInsn(25, 0);
/*  8866 */           param3MethodVisitor.visitVarInsn(25, 9);
/*  8867 */           param3MethodVisitor.visitVarInsn(25, 10);
/*  8868 */           param3MethodVisitor.visitInsn(4);
/*  8869 */           param3MethodVisitor.visitInsn(5);
/*  8870 */           param3MethodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodHandles$Lookup$ClassOption");
/*  8871 */           param3MethodVisitor.visitInsn(89);
/*  8872 */           param3MethodVisitor.visitInsn(3);
/*  8873 */           param3MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "NESTMATE", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
/*  8874 */           param3MethodVisitor.visitInsn(83);
/*  8875 */           param3MethodVisitor.visitInsn(89);
/*  8876 */           param3MethodVisitor.visitInsn(4);
/*  8877 */           param3MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "STRONG", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
/*  8878 */           param3MethodVisitor.visitInsn(83);
/*  8879 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "defineHiddenClassWithClassData", "([BLjava/lang/Object;Z[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;", false);
/*  8880 */           param3MethodVisitor.visitVarInsn(58, 12);
/*  8881 */           label2 = new Label();
/*  8882 */           param3MethodVisitor.visitLabel(label2);
/*  8883 */           label2 = new Label();
/*  8884 */           param3MethodVisitor.visitJumpInsn(167, label2);
/*  8885 */           param3MethodVisitor.visitLabel(label1);
/*  8886 */           param3MethodVisitor.visitFrame(1, 1, new Object[] { Opcodes.INTEGER }, 0, null);
/*  8887 */           param3MethodVisitor.visitVarInsn(25, 0);
/*  8888 */           param3MethodVisitor.visitVarInsn(25, 9);
/*  8889 */           param3MethodVisitor.visitInsn(4);
/*  8890 */           param3MethodVisitor.visitInsn(5);
/*  8891 */           param3MethodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodHandles$Lookup$ClassOption");
/*  8892 */           param3MethodVisitor.visitInsn(89);
/*  8893 */           param3MethodVisitor.visitInsn(3);
/*  8894 */           param3MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "NESTMATE", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
/*  8895 */           param3MethodVisitor.visitInsn(83);
/*  8896 */           param3MethodVisitor.visitInsn(89);
/*  8897 */           param3MethodVisitor.visitInsn(4);
/*  8898 */           param3MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "STRONG", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
/*  8899 */           param3MethodVisitor.visitInsn(83);
/*  8900 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "defineHiddenClass", "([BZ[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;", false);
/*  8901 */           param3MethodVisitor.visitVarInsn(58, 12);
/*  8902 */           param3MethodVisitor.visitLabel(label2);
/*  8903 */           param3MethodVisitor.visitFrame(1, 1, new Object[] { "java/lang/invoke/MethodHandles$Lookup" }, 0, null);
/*  8904 */           param3MethodVisitor.visitVarInsn(25, 12);
/*  8905 */           param3MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
/*  8906 */           param3MethodVisitor.visitVarInsn(58, 10);
/*  8907 */           param3MethodVisitor.visitFrame(0, 10, new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER, "java/util/List", "java/util/List", "java/lang/Class" }, 0, null);
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
/*       */         public final int getStackSize() {
/*  8923 */           return 8;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public final int getLocalVariableLength()
/*       */         {
/*  8930 */           return 15; } } protected static interface Loader { void apply(MethodVisitor param3MethodVisitor); int getStackSize(); int getLocalVariableLength(); public enum Unavailable implements Loader { INSTANCE; public final void apply(MethodVisitor param4MethodVisitor) { throw new IllegalStateException("No lambda expression loading strategy available on current VM"); } public final int getStackSize() { throw new IllegalStateException("No lambda expression loading strategy available on current VM"); } public final int getLocalVariableLength() { throw new IllegalStateException("No lambda expression loading strategy available on current VM"); } } public enum UsingMethodHandleLookup implements Loader { INSTANCE; public final void apply(MethodVisitor param4MethodVisitor) { param4MethodVisitor.visitVarInsn(25, 0); param4MethodVisitor.visitVarInsn(25, 4); param4MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "revealDirect", "(Ljava/lang/invoke/MethodHandle;)Ljava/lang/invoke/MethodHandleInfo;", false); param4MethodVisitor.visitVarInsn(58, 10); param4MethodVisitor.visitVarInsn(25, 10); param4MethodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getModifiers", "()I", true); param4MethodVisitor.visitMethodInsn(184, "java/lang/reflect/Modifier", "isProtected", "(I)Z", false); Label label1 = new Label(); param4MethodVisitor.visitJumpInsn(153, label1); param4MethodVisitor.visitVarInsn(25, 0); param4MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false); param4MethodVisitor.visitVarInsn(25, 10); param4MethodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getDeclaringClass", "()Ljava/lang/Class;", true); param4MethodVisitor.visitMethodInsn(184, "sun/invoke/util/VerifyAccess", "isSamePackage", "(Ljava/lang/Class;Ljava/lang/Class;)Z", false); Label label2 = new Label(); param4MethodVisitor.visitJumpInsn(153, label2); param4MethodVisitor.visitLabel(label1); param4MethodVisitor.visitFrame(0, 11, new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER, "java/util/List", "java/util/List", "[B", "java/lang/invoke/MethodHandleInfo" }, 0, new Object[0]); param4MethodVisitor.visitVarInsn(25, 10); param4MethodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getReferenceKind", "()I", true); param4MethodVisitor.visitIntInsn(16, 7); label1 = new Label(); param4MethodVisitor.visitJumpInsn(160, label1); param4MethodVisitor.visitLabel(label2); param4MethodVisitor.visitFrame(3, 0, null, 0, null); param4MethodVisitor.visitInsn(4); label2 = new Label(); param4MethodVisitor.visitJumpInsn(167, label2); param4MethodVisitor.visitLabel(label1); param4MethodVisitor.visitFrame(3, 0, null, 0, null); param4MethodVisitor.visitInsn(3); param4MethodVisitor.visitLabel(label2); param4MethodVisitor.visitFrame(4, 0, null, 1, new Object[] { Opcodes.INTEGER }); param4MethodVisitor.visitVarInsn(54, 11); param4MethodVisitor.visitVarInsn(21, 11); label1 = new Label(); param4MethodVisitor.visitJumpInsn(153, label1); param4MethodVisitor.visitVarInsn(25, 0); param4MethodVisitor.visitVarInsn(25, 9); param4MethodVisitor.visitVarInsn(25, 10); param4MethodVisitor.visitInsn(4); param4MethodVisitor.visitInsn(5); param4MethodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodHandles$Lookup$ClassOption"); param4MethodVisitor.visitInsn(89); param4MethodVisitor.visitInsn(3); param4MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "NESTMATE", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;"); param4MethodVisitor.visitInsn(83); param4MethodVisitor.visitInsn(89); param4MethodVisitor.visitInsn(4); param4MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "STRONG", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;"); param4MethodVisitor.visitInsn(83); param4MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "defineHiddenClassWithClassData", "([BLjava/lang/Object;Z[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;", false); param4MethodVisitor.visitVarInsn(58, 12); label2 = new Label(); param4MethodVisitor.visitLabel(label2); label2 = new Label(); param4MethodVisitor.visitJumpInsn(167, label2); param4MethodVisitor.visitLabel(label1); param4MethodVisitor.visitFrame(1, 1, new Object[] { Opcodes.INTEGER }, 0, null); param4MethodVisitor.visitVarInsn(25, 0); param4MethodVisitor.visitVarInsn(25, 9); param4MethodVisitor.visitInsn(4); param4MethodVisitor.visitInsn(5); param4MethodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodHandles$Lookup$ClassOption"); param4MethodVisitor.visitInsn(89); param4MethodVisitor.visitInsn(3); param4MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "NESTMATE", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;"); param4MethodVisitor.visitInsn(83); param4MethodVisitor.visitInsn(89); param4MethodVisitor.visitInsn(4); param4MethodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "STRONG", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;"); param4MethodVisitor.visitInsn(83); param4MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "defineHiddenClass", "([BZ[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;", false); param4MethodVisitor.visitVarInsn(58, 12); param4MethodVisitor.visitLabel(label2); param4MethodVisitor.visitFrame(1, 1, new Object[] { "java/lang/invoke/MethodHandles$Lookup" }, 0, null); param4MethodVisitor.visitVarInsn(25, 12); param4MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false); param4MethodVisitor.visitVarInsn(58, 10); param4MethodVisitor.visitFrame(0, 10, new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER, "java/util/List", "java/util/List", "java/lang/Class" }, 0, null); } public final int getLocalVariableLength() { return 15; }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final int getStackSize() {
/*       */             return 8;
/*       */           } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public enum UsingUnsafe
/*       */           implements Loader
/*       */         {
/*  8950 */           JDK_INTERNAL_MISC_UNSAFE("jdk/internal/misc/Unsafe"),
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  8955 */           SUN_MISC_UNSAFE("sun/misc/Unsafe");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final String type;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           UsingUnsafe(String param4String1) {
/*  8968 */             this.type = param4String1;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected final String getType() {
/*  8977 */             return this.type;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final void apply(MethodVisitor param4MethodVisitor) {
/*  8984 */             param4MethodVisitor.visitMethodInsn(184, this.type, "getUnsafe", "()L" + this.type + ";", false);
/*  8985 */             param4MethodVisitor.visitVarInsn(58, 11);
/*  8986 */             param4MethodVisitor.visitVarInsn(25, 11);
/*  8987 */             param4MethodVisitor.visitVarInsn(25, 0);
/*  8988 */             param4MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
/*  8989 */             param4MethodVisitor.visitVarInsn(25, 9);
/*  8990 */             param4MethodVisitor.visitInsn(1);
/*  8991 */             param4MethodVisitor.visitMethodInsn(182, this.type, "defineAnonymousClass", "(Ljava/lang/Class;[B[Ljava/lang/Object;)Ljava/lang/Class;", false);
/*  8992 */             param4MethodVisitor.visitVarInsn(58, 10);
/*  8993 */             param4MethodVisitor.visitVarInsn(25, 11);
/*  8994 */             param4MethodVisitor.visitVarInsn(25, 10);
/*  8995 */             param4MethodVisitor.visitMethodInsn(182, this.type, "ensureClassInitialized", "(Ljava/lang/Class;)V", false);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final int getStackSize() {
/*  9002 */             return 4;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public final int getLocalVariableLength()
/*       */           {
/*  9009 */             return 13; } } } public enum UsingUnsafe implements Loader { JDK_INTERNAL_MISC_UNSAFE("jdk/internal/misc/Unsafe"), SUN_MISC_UNSAFE("sun/misc/Unsafe"); private final String type; UsingUnsafe(String param3String1) { this.type = param3String1; } protected final String getType() { return this.type; } public final void apply(MethodVisitor param3MethodVisitor) { param3MethodVisitor.visitMethodInsn(184, this.type, "getUnsafe", "()L" + this.type + ";", false); param3MethodVisitor.visitVarInsn(58, 11); param3MethodVisitor.visitVarInsn(25, 11); param3MethodVisitor.visitVarInsn(25, 0); param3MethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false); param3MethodVisitor.visitVarInsn(25, 9); param3MethodVisitor.visitInsn(1); param3MethodVisitor.visitMethodInsn(182, this.type, "defineAnonymousClass", "(Ljava/lang/Class;[B[Ljava/lang/Object;)Ljava/lang/Class;", false); param3MethodVisitor.visitVarInsn(58, 10); param3MethodVisitor.visitVarInsn(25, 11); param3MethodVisitor.visitVarInsn(25, 10); param3MethodVisitor.visitMethodInsn(182, this.type, "ensureClassInitialized", "(Ljava/lang/Class;)V", false); } public final int getStackSize() { return 4; } public final int getLocalVariableLength() { return 13; }
/*       */          }
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
/*       */     protected static class LambdaInstanceFactory
/*       */     {
/*       */       private static final String LAMBDA_FACTORY = "get$Lambda";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static final String FIELD_PREFIX = "arg$";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static final String LAMBDA_TYPE_INFIX = "$$Lambda$ByteBuddy$";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @AlwaysNull
/*  9042 */       private static final Class<?> NOT_PREVIOUSLY_DEFINED = null;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  9047 */       private static final AtomicInteger LAMBDA_NAME_COUNTER = new AtomicInteger();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final ByteBuddy byteBuddy;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected LambdaInstanceFactory(ByteBuddy param2ByteBuddy) {
/*  9060 */         this.byteBuddy = param2ByteBuddy;
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
/*       */       public byte[] make(Object param2Object1, String param2String, ClassFileTransformer param2Object2, Object param2Object3, Object param2Object4, Object param2Object5, boolean param2Boolean, List<Class<?>> param2List, List<?> param2List1, Collection<? extends ClassFileTransformer> param2Collection) {
/*       */         DynamicType.Builder.FieldDefinition.Optional.Valuable valuable;
/*       */         DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition1;
/*  9088 */         param2Object2 = (ClassFileTransformer)JavaConstant.MethodType.ofLoaded(param2Object2);
/*  9089 */         param2Object3 = JavaConstant.MethodType.ofLoaded(param2Object3);
/*  9090 */         param2Object4 = JavaConstant.MethodHandle.ofLoaded(param2Object4, param2Object1);
/*  9091 */         JavaConstant.MethodType methodType = JavaConstant.MethodType.ofLoaded(param2Object5);
/*  9092 */         param2Object1 = JavaConstant.MethodHandle.lookupType(param2Object1);
/*  9093 */         String str = param2Object1.getName() + "$$Lambda$ByteBuddy$" + LAMBDA_NAME_COUNTER.incrementAndGet();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9105 */         DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition2 = this.byteBuddy.subclass((TypeDefinition)param2Object2.getReturnType(), (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).modifiers(new ModifierContributor.ForType[] { (ModifierContributor.ForType)TypeManifestation.FINAL, (ModifierContributor.ForType)Visibility.PUBLIC }).implement(param2List).name(str).defineConstructor(new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters((Collection)param2Object2.getParameterTypes()).intercept(ConstructorImplementation.INSTANCE).method((ElementMatcher)ElementMatchers.named(param2String).and((ElementMatcher)ElementMatchers.takesArguments((Iterable)param2Object3.getParameterTypes())).and((ElementMatcher)ElementMatchers.returns(param2Object3.getReturnType()))).intercept(new LambdaMethodImplementation(TypeDescription.ForLoadedType.of((Class)param2Object1), (JavaConstant.MethodHandle)param2Object4, methodType));
/*  9106 */         byte b = 0;
/*  9107 */         for (TypeDescription typeDescription : param2Object2.getParameterTypes()) {
/*  9108 */           valuable = receiverTypeDefinition2.defineField("arg$" + ++b, (TypeDefinition)typeDescription, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE, (ModifierContributor.ForField)FieldManifestation.FINAL });
/*       */         } 
/*  9110 */         if (!param2Object2.getParameterTypes().isEmpty())
/*       */         {
/*       */           
/*  9113 */           receiverTypeDefinition1 = valuable.defineMethod("get$Lambda", (TypeDefinition)param2Object2.getReturnType(), new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE, (ModifierContributor.ForMethod)Ownership.STATIC }).withParameters((Collection)param2Object2.getParameterTypes()).intercept(FactoryImplementation.INSTANCE);
/*       */         }
/*  9115 */         if (param2Boolean) {
/*  9116 */           DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional optional; if (!param2List.contains(Serializable.class)) {
/*  9117 */             optional = receiverTypeDefinition1.implement(new Type[] { Serializable.class });
/*       */           }
/*       */           
/*  9120 */           receiverTypeDefinition1 = optional.defineMethod("writeReplace", Object.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE }).intercept(new SerializationImplementation(TypeDescription.ForLoadedType.of((Class)param2Object1), param2Object2
/*  9121 */                 .getReturnType(), param2String, (JavaConstant.MethodType)param2Object3, (JavaConstant.MethodHandle)param2Object4, 
/*       */ 
/*       */ 
/*       */                 
/*  9125 */                 JavaConstant.MethodType.ofLoaded(param2Object5)));
/*  9126 */         } else if (param2Object2.getReturnType().isAssignableTo(Serializable.class)) {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  9134 */           receiverTypeDefinition1 = receiverTypeDefinition1.defineMethod("readObject", void.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE }).withParameters(new Type[] { ObjectInputStream.class }).throwing(new Type[] { NotSerializableException.class }).intercept(ExceptionMethod.throwing(NotSerializableException.class, "Non-serializable lambda")).defineMethod("writeObject", void.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PRIVATE }).withParameters(new Type[] { ObjectOutputStream.class }).throwing(new Type[] { NotSerializableException.class }).intercept(ExceptionMethod.throwing(NotSerializableException.class, "Non-serializable lambda"));
/*       */         } 
/*  9136 */         for (Iterator<?> iterator = param2List1.iterator(); iterator.hasNext(); ) {
/*  9137 */           Object object; param2Object2 = (ClassFileTransformer)JavaConstant.MethodType.ofLoaded(object = iterator.next());
/*       */ 
/*       */           
/*  9140 */           receiverTypeDefinition1 = receiverTypeDefinition1.defineMethod(param2String, (TypeDefinition)param2Object2.getReturnType(), new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)MethodManifestation.BRIDGE, (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters((Collection)param2Object2.getParameterTypes()).intercept(new BridgeMethodImplementation(param2String, (JavaConstant.MethodType)param2Object3));
/*       */         } 
/*  9142 */         byte[] arrayOfByte = receiverTypeDefinition1.make().getBytes();
/*  9143 */         for (ClassFileTransformer param2Object2 : param2Collection) {
/*       */           try {
/*       */             byte[] arrayOfByte1;
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  9150 */             arrayOfByte = ((arrayOfByte1 = param2Object2.transform(param2Object1.getClassLoader(), str.replace('.', '/'), NOT_PREVIOUSLY_DEFINED, param2Object1.getProtectionDomain(), arrayOfByte)) == null) ? arrayOfByte : arrayOfByte1;
/*       */           
/*       */           }
/*  9153 */           catch (Throwable throwable) {}
/*       */         } 
/*       */ 
/*       */         
/*  9157 */         return arrayOfByte;
/*       */       }
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.byteBuddy.equals(((LambdaInstanceFactory)param2Object).byteBuddy))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.byteBuddy.hashCode();
/*       */       }
/*       */       
/*  9168 */       protected enum ConstructorImplementation implements Implementation { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final transient MethodDescription.InDefinedShape objectConstructor;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         ConstructorImplementation() {
/*  9179 */           this.objectConstructor = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final ByteCodeAppender appender(Implementation.Target param3Target) {
/*  9186 */           return new Appender((List<FieldDescription.InDefinedShape>)param3Target.getInstrumentedType().getDeclaredFields());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/*  9193 */           return param3InstrumentedType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class Appender
/*       */           implements ByteCodeAppender
/*       */         {
/*       */           private final List<FieldDescription.InDefinedShape> declaredFields;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected Appender(List<FieldDescription.InDefinedShape> param4List) {
/*  9213 */             this.declaredFields = param4List;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/*  9220 */             ArrayList<StackManipulation> arrayList = new ArrayList(this.declaredFields.size() * 3);
/*  9221 */             for (ParameterDescription parameterDescription : param4MethodDescription.getParameters()) {
/*  9222 */               arrayList.add(MethodVariableAccess.loadThis());
/*  9223 */               arrayList.add(MethodVariableAccess.load(parameterDescription));
/*  9224 */               arrayList.add(FieldAccess.forField(this.declaredFields.get(parameterDescription.getIndex())).write());
/*       */             } 
/*  9226 */             return new ByteCodeAppender.Size((new StackManipulation.Compound(new StackManipulation[] {
/*  9227 */                     MethodVariableAccess.loadThis(), 
/*  9228 */                     (StackManipulation)MethodInvocation.invoke(AgentBuilder.LambdaInstrumentationStrategy.LambdaInstanceFactory.ConstructorImplementation.a(AgentBuilder.LambdaInstrumentationStrategy.LambdaInstanceFactory.ConstructorImplementation.INSTANCE)), (StackManipulation)new StackManipulation.Compound(arrayList), (StackManipulation)MethodReturn.VOID
/*       */                   },
/*       */                 
/*  9231 */                 )).apply(param4MethodVisitor, param4Context).getMaximalSize(), param4MethodDescription.getStackSize());
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.declaredFields.equals(((Appender)param4Object).declaredFields))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.declaredFields.hashCode();
/*       */           } } }
/*       */ 
/*       */       
/*       */       protected enum FactoryImplementation implements Implementation {
/*  9244 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final ByteCodeAppender appender(Implementation.Target param3Target) {
/*  9250 */           return new Appender(param3Target.getInstrumentedType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/*  9257 */           return param3InstrumentedType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class Appender
/*       */           implements ByteCodeAppender
/*       */         {
/*       */           private final TypeDescription instrumentedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected Appender(TypeDescription param4TypeDescription) {
/*  9277 */             this.instrumentedType = param4TypeDescription;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/*  9284 */             return new ByteCodeAppender.Size((new StackManipulation.Compound(new StackManipulation[] {
/*  9285 */                     TypeCreation.of(this.instrumentedType), (StackManipulation)Duplication.SINGLE, 
/*       */                     
/*  9287 */                     (StackManipulation)MethodVariableAccess.allArgumentsOf(param4MethodDescription), 
/*  9288 */                     (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)this.instrumentedType.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly()), (StackManipulation)MethodReturn.REFERENCE
/*       */                   },
/*  9290 */                 )).apply(param4MethodVisitor, param4Context).getMaximalSize(), param4MethodDescription.getStackSize());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.instrumentedType.equals(((Appender)param4Object).instrumentedType))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class LambdaMethodImplementation
/*       */         implements Implementation
/*       */       {
/*       */         private final TypeDescription targetType;
/*       */ 
/*       */         
/*       */         private final JavaConstant.MethodHandle targetMethod;
/*       */ 
/*       */         
/*       */         private final JavaConstant.MethodType specializedLambdaMethod;
/*       */ 
/*       */ 
/*       */         
/*       */         protected LambdaMethodImplementation(TypeDescription param3TypeDescription, JavaConstant.MethodHandle param3MethodHandle, JavaConstant.MethodType param3MethodType) {
/*  9326 */           this.targetType = param3TypeDescription;
/*  9327 */           this.targetMethod = param3MethodHandle;
/*  9328 */           this.specializedLambdaMethod = param3MethodType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ByteCodeAppender appender(Implementation.Target param3Target) {
/*  9335 */           return Appender.of((MethodDescription)((MethodList)this.targetMethod.getOwnerType()
/*  9336 */               .getDeclaredMethods()
/*  9337 */               .filter((ElementMatcher)ElementMatchers.hasMethodName(this.targetMethod.getName())
/*  9338 */                 .and((ElementMatcher)ElementMatchers.returns(this.targetMethod.getReturnType()))
/*  9339 */                 .and((ElementMatcher)ElementMatchers.takesArguments((Iterable)this.targetMethod.getParameterTypes()))))
/*  9340 */               .getOnly(), this.specializedLambdaMethod, (List<FieldDescription.InDefinedShape>)param3Target
/*       */               
/*  9342 */               .getInstrumentedType().getDeclaredFields(), this.targetMethod
/*  9343 */               .getHandleType(), this.targetType);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/*  9351 */           return param3InstrumentedType;
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.targetType.equals(((LambdaMethodImplementation)param3Object).targetType) ? false : (!this.targetMethod.equals(((LambdaMethodImplementation)param3Object).targetMethod) ? false : (!!this.specializedLambdaMethod.equals(((LambdaMethodImplementation)param3Object).specializedLambdaMethod))))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.targetType.hashCode()) * 31 + this.targetMethod.hashCode()) * 31 + this.specializedLambdaMethod.hashCode();
/*       */         }
/*       */         
/*       */         @Enhance
/*  9363 */         protected static class Appender implements ByteCodeAppender { private static final Dispatcher LOOKUP_DATA_DISPATCHER = dispatcher();
/*       */           
/*       */           private final MethodDescription targetMethod;
/*       */           private final JavaConstant.MethodType specializedLambdaMethod;
/*       */           private final List<FieldDescription.InDefinedShape> declaredFields;
/*       */           private final Dispatcher dispatcher;
/*       */           
/*       */           @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*       */           private static Dispatcher dispatcher() {
/*       */             try {
/*       */               Class<?> clazz;
/*  9374 */               (clazz = Class.forName("java.lang.invoke.MethodHandles$Lookup", false, (ClassLoader)null)).getMethod("classData", new Class[] { clazz, String.class, Class.class });
/*  9375 */               return new Dispatcher.UsingMethodHandle((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.forName("java.lang.invoke.MethodHandle", false, (ClassLoader)null)
/*       */                     
/*  9377 */                     .getMethod("invokeExact", new Class[] { Object[].class })));
/*  9378 */             } catch (Exception exception) {
/*  9379 */               return Dispatcher.UsingDirectInvocation.INSTANCE;
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
/*       */           protected Appender(MethodDescription param4MethodDescription, JavaConstant.MethodType param4MethodType, List<FieldDescription.InDefinedShape> param4List, Dispatcher param4Dispatcher) {
/*  9415 */             this.targetMethod = param4MethodDescription;
/*  9416 */             this.specializedLambdaMethod = param4MethodType;
/*  9417 */             this.declaredFields = param4List;
/*  9418 */             this.dispatcher = param4Dispatcher;
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
/*       */           protected static ByteCodeAppender of(MethodDescription param4MethodDescription, JavaConstant.MethodType param4MethodType, List<FieldDescription.InDefinedShape> param4List, JavaConstant.MethodHandle.HandleType param4HandleType, TypeDescription param4TypeDescription) {
/*  9436 */             return new Appender(param4MethodDescription, param4MethodType, param4List, (param4HandleType == JavaConstant.MethodHandle.HandleType.INVOKE_SPECIAL || 
/*       */ 
/*       */                 
/*  9439 */                 !param4MethodDescription.getDeclaringType().asErasure().isVisibleTo(param4TypeDescription)) ? LOOKUP_DATA_DISPATCHER : Dispatcher.UsingDirectInvocation.INSTANCE);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/*  9448 */             ArrayList<StackManipulation> arrayList1 = new ArrayList((this.declaredFields.size() << 1) + 1);
/*  9449 */             for (FieldDescription.InDefinedShape inDefinedShape : this.declaredFields) {
/*  9450 */               arrayList1.add(MethodVariableAccess.loadThis());
/*  9451 */               arrayList1.add(FieldAccess.forField(inDefinedShape).read());
/*       */             } 
/*  9453 */             ArrayList<StackManipulation> arrayList2 = new ArrayList(param4MethodDescription.getParameters().size() << 1);
/*  9454 */             for (ParameterDescription parameterDescription : param4MethodDescription.getParameters()) {
/*  9455 */               arrayList2.add(MethodVariableAccess.load(parameterDescription));
/*  9456 */               arrayList2.add(Assigner.DEFAULT.assign(parameterDescription.getType(), ((TypeDescription)this.specializedLambdaMethod
/*  9457 */                     .getParameterTypes().get(parameterDescription.getIndex())).asGenericType(), Assigner.Typing.DYNAMIC));
/*       */             } 
/*       */             
/*  9460 */             return new ByteCodeAppender.Size((new StackManipulation.Compound(new StackManipulation[] {
/*  9461 */                     this.targetMethod.isConstructor() ? (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/*  9462 */                         TypeCreation.of(this.targetMethod.getDeclaringType().asErasure()), (StackManipulation)Duplication.SINGLE }, ) : (StackManipulation)StackManipulation.Trivial.INSTANCE, this.dispatcher
/*       */                     
/*  9464 */                     .initialize(), (StackManipulation)new StackManipulation.Compound(arrayList1), (StackManipulation)new StackManipulation.Compound(arrayList2), this.dispatcher
/*       */ 
/*       */                     
/*  9467 */                     .invoke(this.targetMethod), Assigner.DEFAULT
/*  9468 */                     .assign(this.targetMethod.isConstructor() ? this.targetMethod
/*  9469 */                       .getDeclaringType().asGenericType() : this.targetMethod
/*  9470 */                       .getReturnType(), this.specializedLambdaMethod
/*  9471 */                       .getReturnType().asGenericType(), Assigner.Typing.DYNAMIC), 
/*       */                     
/*  9473 */                     MethodReturn.of((TypeDefinition)this.specializedLambdaMethod.getReturnType())
/*  9474 */                   })).apply(param4MethodVisitor, param4Context).getMaximalSize(), param4MethodDescription.getStackSize());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.targetMethod.equals(((Appender)param4Object).targetMethod) ? false : (!this.specializedLambdaMethod.equals(((Appender)param4Object).specializedLambdaMethod) ? false : (!this.declaredFields.equals(((Appender)param4Object).declaredFields) ? false : (!!this.dispatcher.equals(((Appender)param4Object).dispatcher)))))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (((getClass().hashCode() * 31 + this.targetMethod.hashCode()) * 31 + this.specializedLambdaMethod.hashCode()) * 31 + this.declaredFields.hashCode()) * 31 + this.dispatcher.hashCode();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public enum UsingDirectInvocation
/*       */             implements Dispatcher
/*       */           {
/*  9505 */             INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public final StackManipulation initialize() {
/*  9511 */               return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public final StackManipulation invoke(MethodDescription param5MethodDescription) {
/*  9518 */               return (StackManipulation)MethodInvocation.invoke(param5MethodDescription);
/*       */             }
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @Enhance
/*       */           public static class UsingMethodHandle
/*       */             extends StackManipulation.AbstractBase
/*       */             implements Dispatcher
/*       */           {
/*       */             private final MethodDescription.InDefinedShape invokeExact;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             protected UsingMethodHandle(MethodDescription.InDefinedShape param5InDefinedShape) {
/*  9539 */               this.invokeExact = param5InDefinedShape;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public StackManipulation initialize() {
/*  9546 */               return (StackManipulation)this;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public StackManipulation invoke(MethodDescription param5MethodDescription) {
/*  9553 */               return (StackManipulation)MethodInvocation.invoke(this.invokeExact);
/*       */             }
/*       */ 
/*       */ 
/*       */             
/*       */             public StackManipulation.Size apply(MethodVisitor param5MethodVisitor, Implementation.Context param5Context)
/*       */             {
/*  9560 */               param5MethodVisitor.visitLdcInsn(new ConstantDynamic("_", "Ljava/lang/invoke/MethodHandle;", new Handle(6, "java/lang/invoke/MethodHandles", "classData", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", false), new Object[0]));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */               
/*  9567 */               return new StackManipulation.Size(1, 1); } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.invokeExact.equals(((UsingMethodHandle)param5Object).invokeExact)))); } public int hashCode() { return getClass().hashCode() * 31 + this.invokeExact.hashCode(); } } protected static interface Dispatcher { StackManipulation initialize(); StackManipulation invoke(MethodDescription param5MethodDescription); public enum UsingDirectInvocation implements Dispatcher { INSTANCE; public final StackManipulation initialize() { return (StackManipulation)StackManipulation.Trivial.INSTANCE; } public final StackManipulation invoke(MethodDescription param6MethodDescription) { return (StackManipulation)MethodInvocation.invoke(param6MethodDescription); } } @Enhance public static class UsingMethodHandle extends StackManipulation.AbstractBase implements Dispatcher { private final MethodDescription.InDefinedShape invokeExact; protected UsingMethodHandle(MethodDescription.InDefinedShape param6InDefinedShape) { this.invokeExact = param6InDefinedShape; } public StackManipulation initialize() { return (StackManipulation)this; } public StackManipulation invoke(MethodDescription param6MethodDescription) { return (StackManipulation)MethodInvocation.invoke(this.invokeExact); } public StackManipulation.Size apply(MethodVisitor param6MethodVisitor, Implementation.Context param6Context) { param6MethodVisitor.visitLdcInsn(new ConstantDynamic("_", "Ljava/lang/invoke/MethodHandle;", new Handle(6, "java/lang/invoke/MethodHandles", "classData", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", false), new Object[0])); return new StackManipulation.Size(1, 1); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */               
/*       */               public boolean equals(@MaybeNull Object param6Object) {
/*       */                 return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!!this.invokeExact.equals(((UsingMethodHandle)param6Object).invokeExact))));
/*       */               }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */               
/*       */               public int hashCode() {
/*       */                 return getClass().hashCode() * 31 + this.invokeExact.hashCode();
/*       */               } }
/*       */              }
/*       */            }
/*       */       
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class SerializationImplementation
/*       */         implements Implementation
/*       */       {
/*       */         private final TypeDescription targetType;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription lambdaType;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final String lambdaMethodName;
/*       */ 
/*       */ 
/*       */         
/*       */         private final JavaConstant.MethodType lambdaMethod;
/*       */ 
/*       */ 
/*       */         
/*       */         private final JavaConstant.MethodHandle targetMethod;
/*       */ 
/*       */ 
/*       */         
/*       */         private final JavaConstant.MethodType specializedMethod;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected SerializationImplementation(TypeDescription param3TypeDescription1, TypeDescription param3TypeDescription2, String param3String, JavaConstant.MethodType param3MethodType1, JavaConstant.MethodHandle param3MethodHandle, JavaConstant.MethodType param3MethodType2) {
/*  9626 */           this.targetType = param3TypeDescription1;
/*  9627 */           this.lambdaType = param3TypeDescription2;
/*  9628 */           this.lambdaMethodName = param3String;
/*  9629 */           this.lambdaMethod = param3MethodType1;
/*  9630 */           this.targetMethod = param3MethodHandle;
/*  9631 */           this.specializedMethod = param3MethodType2;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ByteCodeAppender appender(Implementation.Target param3Target) {
/*       */           TypeDescription typeDescription;
/*       */           try {
/*  9640 */             typeDescription = TypeDescription.ForLoadedType.of(Class.forName("java.lang.invoke.SerializedLambda"));
/*  9641 */           } catch (ClassNotFoundException classNotFoundException) {
/*  9642 */             throw new IllegalStateException("Cannot find class for lambda serialization", classNotFoundException);
/*       */           } 
/*  9644 */           ArrayList<StackManipulation.Compound> arrayList = new ArrayList(param3Target.getInstrumentedType().getDeclaredFields().size());
/*  9645 */           for (FieldDescription.InDefinedShape inDefinedShape : param3Target.getInstrumentedType().getDeclaredFields()) {
/*  9646 */             arrayList.add(new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), 
/*  9647 */                     FieldAccess.forField(inDefinedShape).read(), Assigner.DEFAULT
/*  9648 */                     .assign(inDefinedShape.getType(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Assigner.Typing.STATIC) }));
/*       */           } 
/*  9650 */           return (ByteCodeAppender)new ByteCodeAppender.Simple(new StackManipulation[] { (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { 
/*  9651 */                     TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, 
/*       */                     
/*  9653 */                     ClassConstant.of(this.targetType), (StackManipulation)new TextConstant(this.lambdaType
/*  9654 */                       .getInternalName()), (StackManipulation)new TextConstant(this.lambdaMethodName), (StackManipulation)new TextConstant(this.lambdaMethod
/*       */                       
/*  9656 */                       .getDescriptor()), 
/*  9657 */                     IntegerConstant.forValue(this.targetMethod.getHandleType().getIdentifier()), (StackManipulation)new TextConstant(this.targetMethod
/*  9658 */                       .getOwnerType().getInternalName()), (StackManipulation)new TextConstant(this.targetMethod
/*  9659 */                       .getName()), (StackManipulation)new TextConstant(this.targetMethod
/*  9660 */                       .getDescriptor()), (StackManipulation)new TextConstant(this.specializedMethod
/*  9661 */                       .getDescriptor()), 
/*  9662 */                     ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)).withValues(arrayList), 
/*  9663 */                     (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly()), (StackManipulation)MethodReturn.REFERENCE }) });
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/*  9672 */           return param3InstrumentedType;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.lambdaMethodName.equals(((SerializationImplementation)param3Object).lambdaMethodName) ? false : (!this.targetType.equals(((SerializationImplementation)param3Object).targetType) ? false : (!this.lambdaType.equals(((SerializationImplementation)param3Object).lambdaType) ? false : (!this.lambdaMethod.equals(((SerializationImplementation)param3Object).lambdaMethod) ? false : (!this.targetMethod.equals(((SerializationImplementation)param3Object).targetMethod) ? false : (!!this.specializedMethod.equals(((SerializationImplementation)param3Object).specializedMethod)))))))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (((((getClass().hashCode() * 31 + this.targetType.hashCode()) * 31 + this.lambdaType.hashCode()) * 31 + this.lambdaMethodName.hashCode()) * 31 + this.lambdaMethod.hashCode()) * 31 + this.targetMethod.hashCode()) * 31 + this.specializedMethod.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class BridgeMethodImplementation
/*       */         implements Implementation
/*       */       {
/*       */         private final String lambdaMethodName;
/*       */         
/*       */         private final JavaConstant.MethodType lambdaMethod;
/*       */ 
/*       */         
/*       */         protected BridgeMethodImplementation(String param3String, JavaConstant.MethodType param3MethodType) {
/*  9699 */           this.lambdaMethodName = param3String;
/*  9700 */           this.lambdaMethod = param3MethodType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ByteCodeAppender appender(Implementation.Target param3Target) {
/*  9707 */           return new Appender(param3Target.invokeSuper(new MethodDescription.SignatureToken(this.lambdaMethodName, this.lambdaMethod
/*  9708 */                   .getReturnType(), (List)this.lambdaMethod
/*  9709 */                   .getParameterTypes())));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/*  9716 */           return param3InstrumentedType;
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.lambdaMethodName.equals(((BridgeMethodImplementation)param3Object).lambdaMethodName) ? false : (!!this.lambdaMethod.equals(((BridgeMethodImplementation)param3Object).lambdaMethod)))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.lambdaMethodName.hashCode()) * 31 + this.lambdaMethod.hashCode();
/*       */         }
/*       */         
/*       */         @Enhance
/*       */         protected static class Appender
/*       */           implements ByteCodeAppender
/*       */         {
/*       */           private final Implementation.SpecialMethodInvocation bridgeTargetInvocation;
/*       */           
/*       */           protected Appender(Implementation.SpecialMethodInvocation param4SpecialMethodInvocation) {
/*  9736 */             this.bridgeTargetInvocation = param4SpecialMethodInvocation;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/*  9743 */             return (new ByteCodeAppender.Compound(new ByteCodeAppender[] { (ByteCodeAppender)new ByteCodeAppender.Simple(new StackManipulation[] {
/*  9744 */                       MethodVariableAccess.allArgumentsOf(param4MethodDescription)
/*  9745 */                       .asBridgeOf(this.bridgeTargetInvocation.getMethodDescription())
/*  9746 */                       .prependThisReference(), (StackManipulation)this.bridgeTargetInvocation, 
/*       */                       
/*  9748 */                       this.bridgeTargetInvocation.getMethodDescription().getReturnType().asErasure().isAssignableTo(param4MethodDescription.getReturnType().asErasure()) ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*       */                       
/*  9750 */                       TypeCasting.to((TypeDefinition)param4MethodDescription.getReturnType()), 
/*  9751 */                       MethodReturn.of((TypeDefinition)param4MethodDescription.getReturnType())
/*       */                     
/*  9753 */                     }) })).apply(param4MethodVisitor, param4Context, param4MethodDescription);
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.bridgeTargetInvocation.equals(((Appender)param4Object).bridgeTargetInvocation))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.bridgeTargetInvocation.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public enum PatchMode
/*       */   {
/*  9771 */     GAP
/*       */     {
/*       */       protected final Handler toHandler(ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  9774 */         return new Handler.ForPatchWithGap(param2ResettableClassFileTransformer);
/*       */       }
/*       */     },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  9783 */     OVERLAP
/*       */     {
/*       */       protected final Handler toHandler(ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/*  9786 */         return new Handler.ForPatchWithOverlap(param2ResettableClassFileTransformer);
/*       */       }
/*       */     };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected abstract Handler toHandler(ResettableClassFileTransformer param1ResettableClassFileTransformer);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected static interface Handler
/*       */     {
/*       */       void onBeforeRegistration(Instrumentation param2Instrumentation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       void onAfterRegistration(Instrumentation param2Instrumentation);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum NoOp
/*       */         implements Handler
/*       */       {
/*  9825 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onBeforeRegistration(Instrumentation param3Instrumentation) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void onAfterRegistration(Instrumentation param3Instrumentation) {}
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForPatchWithGap
/*       */         implements Handler
/*       */       {
/*       */         private final ResettableClassFileTransformer classFileTransformer;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForPatchWithGap(ResettableClassFileTransformer param3ResettableClassFileTransformer) {
/*  9859 */           this.classFileTransformer = param3ResettableClassFileTransformer;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onBeforeRegistration(Instrumentation param3Instrumentation) {
/*  9866 */           if (!this.classFileTransformer.reset(param3Instrumentation, AgentBuilder.RedefinitionStrategy.DISABLED)) {
/*  9867 */             throw new IllegalArgumentException("Failed to deregister patched class file transformer: " + this.classFileTransformer);
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public void onAfterRegistration(Instrumentation param3Instrumentation) {}
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.classFileTransformer.equals(((ForPatchWithGap)param3Object).classFileTransformer))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.classFileTransformer.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForPatchWithOverlap
/*       */         implements Handler
/*       */       {
/*       */         private final ResettableClassFileTransformer classFileTransformer;
/*       */ 
/*       */         
/*       */         protected ForPatchWithOverlap(ResettableClassFileTransformer param3ResettableClassFileTransformer) {
/*  9896 */           this.classFileTransformer = param3ResettableClassFileTransformer;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onBeforeRegistration(Instrumentation param3Instrumentation) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void onAfterRegistration(Instrumentation param3Instrumentation) {
/*  9910 */           if (!this.classFileTransformer.reset(param3Instrumentation, AgentBuilder.RedefinitionStrategy.DISABLED)) {
/*  9911 */             throw new IllegalArgumentException("Failed to deregister patched class file transformer: " + this.classFileTransformer);
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.classFileTransformer.equals(((ForPatchWithOverlap)param3Object).classFileTransformer))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.classFileTransformer.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Enhance
/*       */   public static class Default
/*       */     implements AgentBuilder
/*       */   {
/*       */     private static final String INSTALLER_TYPE = "net.bytebuddy.agent.Installer";
/*       */ 
/*       */ 
/*       */     
/*       */     private static final String INSTALLER_GETTER = "getInstrumentation";
/*       */ 
/*       */     
/*       */     @AlwaysNull
/*  9947 */     private static final byte[] NO_TRANSFORMATION = null;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @AlwaysNull
/*  9953 */     private static final Class<?> NOT_PREVIOUSLY_DEFINED = null;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  9958 */     private static final Dispatcher DISPATCHER = doPrivileged(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  9964 */     private static final AgentBuilder.CircularityLock DEFAULT_LOCK = new AgentBuilder.CircularityLock.Default(); protected final ByteBuddy byteBuddy; protected final AgentBuilder.Listener listener; protected final AgentBuilder.CircularityLock circularityLock; protected final AgentBuilder.PoolStrategy poolStrategy; protected final AgentBuilder.TypeStrategy typeStrategy; protected final AgentBuilder.LocationStrategy locationStrategy; protected final NativeMethodStrategy nativeMethodStrategy; protected final WarmupStrategy warmupStrategy; protected final AgentBuilder.TransformerDecorator transformerDecorator; protected final AgentBuilder.InitializationStrategy initializationStrategy; protected final AgentBuilder.RedefinitionStrategy redefinitionStrategy; protected final AgentBuilder.RedefinitionStrategy.DiscoveryStrategy redefinitionDiscoveryStrategy; protected final AgentBuilder.RedefinitionStrategy.BatchAllocator redefinitionBatchAllocator; protected final AgentBuilder.RedefinitionStrategy.Listener redefinitionListener; protected final AgentBuilder.RedefinitionStrategy.ResubmissionStrategy redefinitionResubmissionStrategy; protected final AgentBuilder.InjectionStrategy injectionStrategy; protected final AgentBuilder.LambdaInstrumentationStrategy lambdaInstrumentationStrategy; protected final AgentBuilder.DescriptionStrategy descriptionStrategy; protected final AgentBuilder.FallbackStrategy fallbackStrategy; protected final AgentBuilder.ClassFileBufferStrategy classFileBufferStrategy; protected final AgentBuilder.InstallationListener installationListener; protected final AgentBuilder.RawMatcher ignoreMatcher; protected final List<Transformation> transformations; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Default() {
/* 10086 */       this(new ByteBuddy());
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
/*       */     public Default(ByteBuddy param1ByteBuddy) {
/* 10098 */       this(param1ByteBuddy, AgentBuilder.Listener.NoOp.INSTANCE, DEFAULT_LOCK, AgentBuilder.PoolStrategy.Default.FAST, AgentBuilder.TypeStrategy.Default.REBASE, AgentBuilder.LocationStrategy.ForClassLoader.STRONG, NativeMethodStrategy.Disabled.INSTANCE, WarmupStrategy.NoOp.INSTANCE, AgentBuilder.TransformerDecorator.NoOp.INSTANCE, new AgentBuilder.InitializationStrategy.SelfInjection.Split(), AgentBuilder.RedefinitionStrategy.DISABLED, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE, AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE, AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE, AgentBuilder.InjectionStrategy.UsingReflection.INSTANCE, AgentBuilder.LambdaInstrumentationStrategy.DISABLED, AgentBuilder.DescriptionStrategy.Default.HYBRID, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 10116 */           AgentBuilder.FallbackStrategy.ByThrowableType.ofOptionalTypes(), AgentBuilder.ClassFileBufferStrategy.Default.RETAINING, AgentBuilder.InstallationListener.NoOp.INSTANCE, new AgentBuilder.RawMatcher.Disjunction(new AgentBuilder.RawMatcher[] { new AgentBuilder.RawMatcher.ForElementMatchers(
/*       */ 
/*       */ 
/*       */                 
/* 10120 */                 (ElementMatcher<? super TypeDescription>)ElementMatchers.any(), (ElementMatcher<? super ClassLoader>)ElementMatchers.isBootstrapClassLoader().or((ElementMatcher)ElementMatchers.isExtensionClassLoader())), new AgentBuilder.RawMatcher.ForElementMatchers(
/* 10121 */                 (ElementMatcher<? super TypeDescription>)ElementMatchers.nameStartsWith("net.bytebuddy.")
/* 10122 */                 .and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.nameStartsWith("net.bytebuddy.renamed.")))
/* 10123 */                 .or((ElementMatcher)ElementMatchers.nameStartsWith("sun.reflect.").or((ElementMatcher)ElementMatchers.nameStartsWith("jdk.internal.reflect.")))
/* 10124 */                 .or((ElementMatcher)ElementMatchers.isSynthetic()))
/* 10125 */             }), Collections.emptyList());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Default(ByteBuddy param1ByteBuddy, AgentBuilder.Listener param1Listener, AgentBuilder.CircularityLock param1CircularityLock, AgentBuilder.PoolStrategy param1PoolStrategy, AgentBuilder.TypeStrategy param1TypeStrategy, AgentBuilder.LocationStrategy param1LocationStrategy, NativeMethodStrategy param1NativeMethodStrategy, WarmupStrategy param1WarmupStrategy, AgentBuilder.TransformerDecorator param1TransformerDecorator, AgentBuilder.InitializationStrategy param1InitializationStrategy, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param1DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param1BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param1Listener1, AgentBuilder.RedefinitionStrategy.ResubmissionStrategy param1ResubmissionStrategy, AgentBuilder.InjectionStrategy param1InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param1LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param1DescriptionStrategy, AgentBuilder.FallbackStrategy param1FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param1ClassFileBufferStrategy, AgentBuilder.InstallationListener param1InstallationListener, AgentBuilder.RawMatcher param1RawMatcher, List<Transformation> param1List) {
/* 10179 */       this.byteBuddy = param1ByteBuddy;
/* 10180 */       this.listener = param1Listener;
/* 10181 */       this.circularityLock = param1CircularityLock;
/* 10182 */       this.poolStrategy = param1PoolStrategy;
/* 10183 */       this.typeStrategy = param1TypeStrategy;
/* 10184 */       this.locationStrategy = param1LocationStrategy;
/* 10185 */       this.nativeMethodStrategy = param1NativeMethodStrategy;
/* 10186 */       this.warmupStrategy = param1WarmupStrategy;
/* 10187 */       this.transformerDecorator = param1TransformerDecorator;
/* 10188 */       this.initializationStrategy = param1InitializationStrategy;
/* 10189 */       this.redefinitionStrategy = param1RedefinitionStrategy;
/* 10190 */       this.redefinitionDiscoveryStrategy = param1DiscoveryStrategy;
/* 10191 */       this.redefinitionBatchAllocator = param1BatchAllocator;
/* 10192 */       this.redefinitionListener = param1Listener1;
/* 10193 */       this.redefinitionResubmissionStrategy = param1ResubmissionStrategy;
/* 10194 */       this.injectionStrategy = param1InjectionStrategy;
/* 10195 */       this.lambdaInstrumentationStrategy = param1LambdaInstrumentationStrategy;
/* 10196 */       this.descriptionStrategy = param1DescriptionStrategy;
/* 10197 */       this.fallbackStrategy = param1FallbackStrategy;
/* 10198 */       this.classFileBufferStrategy = param1ClassFileBufferStrategy;
/* 10199 */       this.installationListener = param1InstallationListener;
/* 10200 */       this.ignoreMatcher = param1RawMatcher;
/* 10201 */       this.transformations = param1List;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 10213 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AgentBuilder of(Plugin... param1VarArgs) {
/* 10223 */       return of(Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AgentBuilder of(List<? extends Plugin> param1List) {
/* 10233 */       return of((EntryPoint)EntryPoint.Default.REBASE, param1List);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AgentBuilder of(EntryPoint param1EntryPoint, Plugin... param1VarArgs) {
/* 10244 */       return of(param1EntryPoint, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AgentBuilder of(EntryPoint param1EntryPoint, List<? extends Plugin> param1List) {
/* 10255 */       return of(param1EntryPoint, ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5), param1List);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AgentBuilder of(ClassFileVersion param1ClassFileVersion, Plugin... param1VarArgs) {
/* 10266 */       return of(param1ClassFileVersion, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AgentBuilder of(ClassFileVersion param1ClassFileVersion, List<? extends Plugin> param1List) {
/* 10277 */       return of((EntryPoint)EntryPoint.Default.REBASE, param1ClassFileVersion, param1List);
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
/*       */     public static AgentBuilder of(EntryPoint param1EntryPoint, ClassFileVersion param1ClassFileVersion, Plugin... param1VarArgs) {
/* 10289 */       return of(param1EntryPoint, param1ClassFileVersion, Arrays.asList(param1VarArgs));
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
/*       */     public static AgentBuilder of(EntryPoint param1EntryPoint, ClassFileVersion param1ClassFileVersion, List<? extends Plugin> param1List) {
/* 10301 */       AgentBuilder agentBuilder = (new Default(param1EntryPoint.byteBuddy(param1ClassFileVersion))).with(new AgentBuilder.TypeStrategy.ForBuildEntryPoint(param1EntryPoint));
/* 10302 */       for (Plugin plugin : param1List) {
/* 10303 */         agentBuilder = agentBuilder.type((ElementMatcher<? super TypeDescription>)plugin).transform(new AgentBuilder.Transformer.ForBuildPlugin(plugin));
/*       */       }
/* 10305 */       return agentBuilder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(ByteBuddy param1ByteBuddy) {
/* 10312 */       return new Default(param1ByteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.Listener param1Listener) {
/* 10341 */       return new Default(this.byteBuddy, new AgentBuilder.Listener.Compound(new AgentBuilder.Listener[] { this.listener, param1Listener }, ), this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.CircularityLock param1CircularityLock) {
/* 10370 */       return new Default(this.byteBuddy, this.listener, param1CircularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.TypeStrategy param1TypeStrategy) {
/* 10399 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, param1TypeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.PoolStrategy param1PoolStrategy) {
/* 10428 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, param1PoolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.LocationStrategy param1LocationStrategy) {
/* 10457 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, param1LocationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder enableNativeMethodPrefix(String param1String) {
/* 10486 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 10492 */           NativeMethodStrategy.ForPrefix.of(param1String), this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */     
/*       */     public AgentBuilder disableNativeMethodPrefix() {
/* 10515 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, NativeMethodStrategy.Disabled.INSTANCE, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder warmUp(Class<?>... param1VarArgs) {
/* 10544 */       return warmUp(Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder warmUp(Collection<Class<?>> param1Collection) {
/* 10551 */       if (param1Collection.isEmpty()) {
/* 10552 */         return this;
/*       */       }
/* 10554 */       for (Iterator<Class<?>> iterator = param1Collection.iterator(); iterator.hasNext();) {
/* 10555 */         if ((clazz = iterator.next()).isPrimitive() || clazz.isArray()) {
/* 10556 */           throw new IllegalArgumentException("Cannot warm up primitive or array type: " + clazz);
/*       */         }
/*       */       } 
/* 10559 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 10566 */           .with(param1Collection), this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.TransformerDecorator param1TransformerDecorator) {
/* 10588 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, new AgentBuilder.TransformerDecorator.Compound(new AgentBuilder.TransformerDecorator[] { this.transformerDecorator, param1TransformerDecorator }, ), this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.RedefinitionListenable.WithoutBatchStrategy with(AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy) {
/* 10617 */       return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE, AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE, AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.InitializationStrategy param1InitializationStrategy) {
/* 10646 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, param1InitializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.LambdaInstrumentationStrategy param1LambdaInstrumentationStrategy) {
/* 10675 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, param1LambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.DescriptionStrategy param1DescriptionStrategy) {
/* 10704 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, param1DescriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.FallbackStrategy param1FallbackStrategy) {
/* 10733 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, param1FallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.ClassFileBufferStrategy param1ClassFileBufferStrategy) {
/* 10762 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, param1ClassFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.InstallationListener param1InstallationListener) {
/* 10791 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, new AgentBuilder.InstallationListener.Compound(new AgentBuilder.InstallationListener[] { this.installationListener, param1InstallationListener }, ), this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder with(AgentBuilder.InjectionStrategy param1InjectionStrategy) {
/* 10820 */       return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, param1InjectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder disableClassFormatChanges() {
/* 10849 */       return new Default(this.byteBuddy.with((Implementation.Context.Factory)Implementation.Context.Disabled.Factory.INSTANCE), this.listener, this.circularityLock, this.poolStrategy, (this.typeStrategy == AgentBuilder.TypeStrategy.Default.DECORATE) ? AgentBuilder.TypeStrategy.Default.DECORATE : AgentBuilder.TypeStrategy.Default.REDEFINE_FROZEN, this.locationStrategy, NativeMethodStrategy.Disabled.INSTANCE, this.warmupStrategy, this.transformerDecorator, AgentBuilder.InitializationStrategy.NoOp.INSTANCE, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder assureReadEdgeTo(Instrumentation param1Instrumentation, Class<?>... param1VarArgs) {
/* 10880 */       if (JavaModule.isSupported())
/* 10881 */         return with(AgentBuilder.Listener.ModuleReadEdgeCompleting.of(param1Instrumentation, false, param1VarArgs));  return this;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder assureReadEdgeTo(Instrumentation param1Instrumentation, JavaModule... param1VarArgs) {
/* 10889 */       return assureReadEdgeTo(param1Instrumentation, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder assureReadEdgeTo(Instrumentation param1Instrumentation, Collection<? extends JavaModule> param1Collection) {
/* 10896 */       return with(new AgentBuilder.Listener.ModuleReadEdgeCompleting(param1Instrumentation, false, new HashSet<JavaModule>(param1Collection)));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder assureReadEdgeFromAndTo(Instrumentation param1Instrumentation, Class<?>... param1VarArgs) {
/* 10903 */       if (JavaModule.isSupported())
/* 10904 */         return with(AgentBuilder.Listener.ModuleReadEdgeCompleting.of(param1Instrumentation, true, param1VarArgs));  return this;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder assureReadEdgeFromAndTo(Instrumentation param1Instrumentation, JavaModule... param1VarArgs) {
/* 10912 */       return assureReadEdgeFromAndTo(param1Instrumentation, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder assureReadEdgeFromAndTo(Instrumentation param1Instrumentation, Collection<? extends JavaModule> param1Collection) {
/* 10919 */       return with(new AgentBuilder.Listener.ModuleReadEdgeCompleting(param1Instrumentation, true, new HashSet<JavaModule>(param1Collection)));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Identified.Narrowable type(AgentBuilder.RawMatcher param1RawMatcher) {
/* 10926 */       return new Transforming(this, param1RawMatcher, Collections.emptyList(), false);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Identified.Narrowable type(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 10933 */       return type(param1ElementMatcher, (ElementMatcher<? super ClassLoader>)ElementMatchers.any());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Identified.Narrowable type(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1) {
/* 10940 */       return type(param1ElementMatcher, param1ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.any());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Identified.Narrowable type(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1, ElementMatcher<? super JavaModule> param1ElementMatcher2) {
/* 10949 */       return type(new AgentBuilder.RawMatcher.ForElementMatchers(param1ElementMatcher, param1ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.not((ElementMatcher)ElementMatchers.supportsModules()).or(param1ElementMatcher2)));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Ignored ignore(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 10956 */       return ignore(param1ElementMatcher, (ElementMatcher<? super ClassLoader>)ElementMatchers.any());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Ignored ignore(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1) {
/* 10963 */       return ignore(param1ElementMatcher, param1ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.any());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Ignored ignore(ElementMatcher<? super TypeDescription> param1ElementMatcher, ElementMatcher<? super ClassLoader> param1ElementMatcher1, ElementMatcher<? super JavaModule> param1ElementMatcher2) {
/* 10972 */       return ignore(new AgentBuilder.RawMatcher.ForElementMatchers(param1ElementMatcher, param1ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.not((ElementMatcher)ElementMatchers.supportsModules()).or(param1ElementMatcher2)));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AgentBuilder.Ignored ignore(AgentBuilder.RawMatcher param1RawMatcher) {
/* 10979 */       return new Ignoring(this, param1RawMatcher);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ResettableClassFileTransformer makeRaw() {
/* 10986 */       return makeRaw(this.listener, AgentBuilder.InstallationListener.NoOp.INSTANCE, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer.Disabled.INSTANCE);
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
/*       */     private ResettableClassFileTransformer makeRaw(AgentBuilder.Listener param1Listener, AgentBuilder.InstallationListener param1InstallationListener, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param1ResubmissionEnforcer) {
/* 11000 */       return ExecutingTransformer.FACTORY.make(this.byteBuddy, param1Listener, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.initializationStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, param1InstallationListener, this.ignoreMatcher, param1ResubmissionEnforcer, this.transformations, this.circularityLock);
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private static Instrumentation resolveByteBuddyAgentInstrumentation() {
/*       */       try {
/* 11026 */         Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("net.bytebuddy.agent.Installer");
/* 11027 */         JavaModule javaModule1 = JavaModule.ofType(AgentBuilder.class), javaModule2 = JavaModule.ofType(clazz);
/* 11028 */         if (javaModule1 != null && !javaModule1.canRead(javaModule2)) {
/*       */           Class<?> clazz1;
/* 11030 */           (clazz1 = Class.forName("java.lang.Module")).getMethod("addReads", new Class[] { clazz1 }).invoke(javaModule1.unwrap(), new Object[] { javaModule2.unwrap() });
/*       */         } 
/* 11032 */         return (Instrumentation)clazz.getMethod("getInstrumentation", new Class[0]).invoke(null, new Object[0]);
/* 11033 */       } catch (RuntimeException runtimeException2) {
/* 11034 */         RuntimeException runtimeException1; throw runtimeException1 = null;
/* 11035 */       } catch (Exception exception) {
/* 11036 */         throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", exception);
/*       */       } 
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ResettableClassFileTransformer installOn(Instrumentation param1Instrumentation) {
/* 11044 */       return doInstall(param1Instrumentation, new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations), AgentBuilder.PatchMode.Handler.NoOp.INSTANCE);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ResettableClassFileTransformer installOnByteBuddyAgent() {
/* 11051 */       return installOn(resolveByteBuddyAgentInstrumentation());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ResettableClassFileTransformer patchOn(Instrumentation param1Instrumentation, ResettableClassFileTransformer param1ResettableClassFileTransformer) {
/* 11058 */       return patchOn(param1Instrumentation, param1ResettableClassFileTransformer, AgentBuilder.PatchMode.OVERLAP);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ResettableClassFileTransformer patchOn(Instrumentation param1Instrumentation, ResettableClassFileTransformer param1ResettableClassFileTransformer, AgentBuilder.PatchMode param1PatchMode) {
/* 11065 */       return doInstall(param1Instrumentation, new Transformation.DifferentialMatcher(this.ignoreMatcher, this.transformations, param1ResettableClassFileTransformer), param1PatchMode.toHandler(param1ResettableClassFileTransformer));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer param1ResettableClassFileTransformer) {
/* 11072 */       return patchOnByteBuddyAgent(param1ResettableClassFileTransformer, AgentBuilder.PatchMode.OVERLAP);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer param1ResettableClassFileTransformer, AgentBuilder.PatchMode param1PatchMode) {
/* 11079 */       return patchOn(resolveByteBuddyAgentInstrumentation(), param1ResettableClassFileTransformer, param1PatchMode);
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
/*       */     private ResettableClassFileTransformer doInstall(Instrumentation param1Instrumentation, AgentBuilder.RawMatcher param1RawMatcher, AgentBuilder.PatchMode.Handler param1Handler) {
/* 11091 */       if (!this.circularityLock.acquire()) {
/* 11092 */         throw new IllegalStateException("Could not acquire the circularity lock upon installation.");
/*       */       }
/*       */       try {
/* 11095 */         AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Installation installation = this.redefinitionResubmissionStrategy.apply(param1Instrumentation, this.poolStrategy, this.locationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.listener, this.installationListener, this.circularityLock, new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations), this.redefinitionStrategy, this.redefinitionBatchAllocator, this.redefinitionListener);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 11107 */         ResettableClassFileTransformer resettableClassFileTransformer = this.transformerDecorator.decorate(makeRaw(installation.getListener(), installation
/* 11108 */               .getInstallationListener(), installation
/* 11109 */               .getResubmissionEnforcer()));
/* 11110 */         installation.getInstallationListener().onBeforeInstall(param1Instrumentation, resettableClassFileTransformer);
/*       */         try {
/* 11112 */           this.warmupStrategy.apply(resettableClassFileTransformer, this.locationStrategy, this.redefinitionStrategy, this.circularityLock, installation
/*       */ 
/*       */ 
/*       */               
/* 11116 */               .getInstallationListener());
/* 11117 */           param1Handler.onBeforeRegistration(param1Instrumentation);
/* 11118 */           if (this.redefinitionStrategy.isRetransforming()) {
/* 11119 */             DISPATCHER.addTransformer(param1Instrumentation, resettableClassFileTransformer, true);
/*       */           } else {
/* 11121 */             param1Instrumentation.addTransformer(resettableClassFileTransformer);
/*       */           } 
/* 11123 */           param1Handler.onAfterRegistration(param1Instrumentation);
/* 11124 */           this.nativeMethodStrategy.apply(param1Instrumentation, resettableClassFileTransformer);
/* 11125 */           this.lambdaInstrumentationStrategy.apply(this.byteBuddy, param1Instrumentation, resettableClassFileTransformer);
/* 11126 */           this.redefinitionStrategy.apply(param1Instrumentation, this.poolStrategy, this.locationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.redefinitionDiscoveryStrategy, this.lambdaInstrumentationStrategy, installation
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */               
/* 11133 */               .getListener(), this.redefinitionListener, param1RawMatcher, this.redefinitionBatchAllocator, this.circularityLock);
/*       */ 
/*       */ 
/*       */         
/*       */         }
/* 11138 */         catch (Throwable throwable) {
/*       */           
/* 11140 */           if ((throwable = installation.getInstallationListener().onError(param1Instrumentation, resettableClassFileTransformer, throwable)) != null) {
/* 11141 */             param1Instrumentation.removeTransformer(resettableClassFileTransformer);
/* 11142 */             throw new IllegalStateException("Could not install class file transformer", throwable);
/*       */           } 
/*       */         } 
/* 11145 */         installation.getInstallationListener().onInstall(param1Instrumentation, resettableClassFileTransformer);
/* 11146 */         return resettableClassFileTransformer;
/*       */       } finally {
/* 11148 */         this.circularityLock.release();
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
/*       */ 
/*       */     
/*       */     public boolean equals(@MaybeNull Object param1Object) {
/*       */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.redefinitionStrategy.equals(((Default)param1Object).redefinitionStrategy) ? false : (!this.lambdaInstrumentationStrategy.equals(((Default)param1Object).lambdaInstrumentationStrategy) ? false : (!this.byteBuddy.equals(((Default)param1Object).byteBuddy) ? false : (!this.listener.equals(((Default)param1Object).listener) ? false : (!this.circularityLock.equals(((Default)param1Object).circularityLock) ? false : (!this.poolStrategy.equals(((Default)param1Object).poolStrategy) ? false : (!this.typeStrategy.equals(((Default)param1Object).typeStrategy) ? false : (!this.locationStrategy.equals(((Default)param1Object).locationStrategy) ? false : (!this.nativeMethodStrategy.equals(((Default)param1Object).nativeMethodStrategy) ? false : (!this.warmupStrategy.equals(((Default)param1Object).warmupStrategy) ? false : (!this.transformerDecorator.equals(((Default)param1Object).transformerDecorator) ? false : (!this.initializationStrategy.equals(((Default)param1Object).initializationStrategy) ? false : (!this.redefinitionDiscoveryStrategy.equals(((Default)param1Object).redefinitionDiscoveryStrategy) ? false : (!this.redefinitionBatchAllocator.equals(((Default)param1Object).redefinitionBatchAllocator) ? false : (!this.redefinitionListener.equals(((Default)param1Object).redefinitionListener) ? false : (!this.redefinitionResubmissionStrategy.equals(((Default)param1Object).redefinitionResubmissionStrategy) ? false : (!this.injectionStrategy.equals(((Default)param1Object).injectionStrategy) ? false : (!this.descriptionStrategy.equals(((Default)param1Object).descriptionStrategy) ? false : (!this.fallbackStrategy.equals(((Default)param1Object).fallbackStrategy) ? false : (!this.classFileBufferStrategy.equals(((Default)param1Object).classFileBufferStrategy) ? false : (!this.installationListener.equals(((Default)param1Object).installationListener) ? false : (!this.ignoreMatcher.equals(((Default)param1Object).ignoreMatcher) ? false : (!!this.transformations.equals(((Default)param1Object).transformations))))))))))))))))))))))))));
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
/*       */     public int hashCode() {
/*       */       return ((((((((((((((((((((((getClass().hashCode() * 31 + this.byteBuddy.hashCode()) * 31 + this.listener.hashCode()) * 31 + this.circularityLock.hashCode()) * 31 + this.poolStrategy.hashCode()) * 31 + this.typeStrategy.hashCode()) * 31 + this.locationStrategy.hashCode()) * 31 + this.nativeMethodStrategy.hashCode()) * 31 + this.warmupStrategy.hashCode()) * 31 + this.transformerDecorator.hashCode()) * 31 + this.initializationStrategy.hashCode()) * 31 + this.redefinitionStrategy.hashCode()) * 31 + this.redefinitionDiscoveryStrategy.hashCode()) * 31 + this.redefinitionBatchAllocator.hashCode()) * 31 + this.redefinitionListener.hashCode()) * 31 + this.redefinitionResubmissionStrategy.hashCode()) * 31 + this.injectionStrategy.hashCode()) * 31 + this.lambdaInstrumentationStrategy.hashCode()) * 31 + this.descriptionStrategy.hashCode()) * 31 + this.fallbackStrategy.hashCode()) * 31 + this.classFileBufferStrategy.hashCode()) * 31 + this.installationListener.hashCode()) * 31 + this.ignoreMatcher.hashCode()) * 31 + this.transformations.hashCode();
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
/*       */     public enum Disabled
/*       */       implements NativeMethodStrategy
/*       */     {
/* 11214 */       INSTANCE;
/*       */ 
/*       */ 
/*       */       
/*       */       public final MethodNameTransformer resolve()
/*       */       {
/* 11220 */         return MethodNameTransformer.Suffixing.withRandomSuffix(); } public final void apply(Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer) {} } protected static interface NativeMethodStrategy { MethodNameTransformer resolve(); void apply(Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer); public enum Disabled implements NativeMethodStrategy { INSTANCE; public final MethodNameTransformer resolve() { return MethodNameTransformer.Suffixing.withRandomSuffix(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final void apply(Instrumentation param3Instrumentation, ClassFileTransformer param3ClassFileTransformer) {} }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForPrefix
/*       */         implements NativeMethodStrategy
/*       */       {
/*       */         private final String prefix;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForPrefix(String param3String) {
/* 11248 */           this.prefix = param3String;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static AgentBuilder.Default.NativeMethodStrategy of(String param3String) {
/* 11258 */           if (param3String.length() == 0) {
/* 11259 */             throw new IllegalArgumentException("A method name prefix must not be the empty string");
/*       */           }
/* 11261 */           return new ForPrefix(param3String);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public MethodNameTransformer resolve() {
/* 11268 */           return (MethodNameTransformer)new MethodNameTransformer.Prefixing(this.prefix);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public void apply(Instrumentation param3Instrumentation, ClassFileTransformer param3ClassFileTransformer)
/*       */         {
/* 11275 */           if (!AgentBuilder.Default.a().isNativeMethodPrefixSupported(param3Instrumentation)) {
/* 11276 */             throw new IllegalArgumentException("A prefix for native methods is not supported: " + param3Instrumentation);
/*       */           }
/* 11278 */           AgentBuilder.Default.a().setNativeMethodPrefix(param3Instrumentation, param3ClassFileTransformer, this.prefix); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.prefix.equals(((ForPrefix)param3Object).prefix)))); } public int hashCode() { return getClass().hashCode() * 31 + this.prefix.hashCode(); } } } @Enhance public static class ForPrefix implements NativeMethodStrategy { private final String prefix; protected ForPrefix(String param2String) { this.prefix = param2String; } protected static AgentBuilder.Default.NativeMethodStrategy of(String param2String) { if (param2String.length() == 0) throw new IllegalArgumentException("A method name prefix must not be the empty string");  return new ForPrefix(param2String); } public MethodNameTransformer resolve() { return (MethodNameTransformer)new MethodNameTransformer.Prefixing(this.prefix); } public void apply(Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer) { if (!AgentBuilder.Default.a().isNativeMethodPrefixSupported(param2Instrumentation)) throw new IllegalArgumentException("A prefix for native methods is not supported: " + param2Instrumentation);  AgentBuilder.Default.a().setNativeMethodPrefix(param2Instrumentation, param2ClassFileTransformer, this.prefix); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.prefix.equals(((ForPrefix)param2Object).prefix))));
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
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.prefix.hashCode();
/*       */       } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum NoOp
/*       */       implements WarmupStrategy
/*       */     {
/* 11320 */       INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final void apply(ResettableClassFileTransformer param2ResettableClassFileTransformer, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.RedefinitionStrategy param2RedefinitionStrategy, AgentBuilder.CircularityLock param2CircularityLock, AgentBuilder.InstallationListener param2InstallationListener) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final AgentBuilder.Default.WarmupStrategy with(Collection<Class<?>> param2Collection)
/*       */       {
/* 11337 */         return new AgentBuilder.Default.WarmupStrategy.Enabled(new LinkedHashSet<Class<?>>(param2Collection)); } } protected static interface WarmupStrategy { void apply(ResettableClassFileTransformer param2ResettableClassFileTransformer, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.RedefinitionStrategy param2RedefinitionStrategy, AgentBuilder.CircularityLock param2CircularityLock, AgentBuilder.InstallationListener param2InstallationListener); WarmupStrategy with(Collection<Class<?>> param2Collection); public enum NoOp implements WarmupStrategy { INSTANCE; public final void apply(ResettableClassFileTransformer param3ResettableClassFileTransformer, AgentBuilder.LocationStrategy param3LocationStrategy, AgentBuilder.RedefinitionStrategy param3RedefinitionStrategy, AgentBuilder.CircularityLock param3CircularityLock, AgentBuilder.InstallationListener param3InstallationListener) {} public final AgentBuilder.Default.WarmupStrategy with(Collection<Class<?>> param3Collection) { return new AgentBuilder.Default.WarmupStrategy.Enabled(new LinkedHashSet<Class<?>>(param3Collection)); }
/*       */          }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Enabled
/*       */         implements WarmupStrategy
/*       */       {
/* 11350 */         private static final Dispatcher DISPATCHER = (Dispatcher)AgentBuilder.Default.a(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Set<Class<?>> types;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Enabled(Set<Class<?>> param3Set) {
/* 11363 */           this.types = param3Set;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void apply(ResettableClassFileTransformer param3ResettableClassFileTransformer, AgentBuilder.LocationStrategy param3LocationStrategy, AgentBuilder.RedefinitionStrategy param3RedefinitionStrategy, AgentBuilder.CircularityLock param3CircularityLock, AgentBuilder.InstallationListener param3InstallationListener) {
/* 11374 */           param3InstallationListener.onBeforeWarmUp(this.types, param3ResettableClassFileTransformer);
/* 11375 */           int i = 0;
/* 11376 */           LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 11377 */           for (Class<?> clazz : this.types) {
/*       */             try {
/* 11379 */               JavaModule javaModule = JavaModule.ofType(clazz);
/*       */ 
/*       */               
/* 11382 */               byte[] arrayOfByte = param3LocationStrategy.classFileLocator(clazz.getClassLoader(), javaModule).locate(clazz.getName()).resolve();
/* 11383 */               param3CircularityLock.release();
/*       */               try {
/*       */                 byte[] arrayOfByte1;
/* 11386 */                 if (javaModule == null) {
/* 11387 */                   arrayOfByte1 = param3ResettableClassFileTransformer.transform(clazz.getClassLoader(), 
/* 11388 */                       Type.getInternalName(clazz), 
/* 11389 */                       AgentBuilder.Default.b(), clazz
/* 11390 */                       .getProtectionDomain(), arrayOfByte);
/*       */                   
/* 11392 */                   i |= (arrayOfByte1 != null) ? 1 : 0;
/* 11393 */                   if (param3RedefinitionStrategy.isEnabled()) {
/* 11394 */                     arrayOfByte1 = param3ResettableClassFileTransformer.transform(clazz.getClassLoader(), 
/* 11395 */                         Type.getInternalName(clazz), clazz, clazz
/*       */                         
/* 11397 */                         .getProtectionDomain(), arrayOfByte);
/*       */                     
/* 11399 */                     i |= (arrayOfByte1 != null) ? 1 : 0;
/*       */                   } 
/*       */                 } else {
/* 11402 */                   arrayOfByte1 = DISPATCHER.transform(param3ResettableClassFileTransformer, javaModule
/* 11403 */                       .unwrap(), clazz
/* 11404 */                       .getClassLoader(), 
/* 11405 */                       Type.getInternalName(clazz), 
/* 11406 */                       AgentBuilder.Default.b(), clazz
/* 11407 */                       .getProtectionDomain(), arrayOfByte);
/*       */                   
/* 11409 */                   i |= (arrayOfByte1 != null) ? 1 : 0;
/* 11410 */                   if (param3RedefinitionStrategy.isEnabled()) {
/* 11411 */                     arrayOfByte1 = DISPATCHER.transform(param3ResettableClassFileTransformer, javaModule
/* 11412 */                         .unwrap(), clazz
/* 11413 */                         .getClassLoader(), 
/* 11414 */                         Type.getInternalName(clazz), clazz, clazz
/*       */                         
/* 11416 */                         .getProtectionDomain(), arrayOfByte);
/*       */                     
/* 11418 */                     i |= (arrayOfByte1 != null) ? 1 : 0;
/*       */                   } 
/*       */                 } 
/* 11421 */                 linkedHashMap.put(clazz, arrayOfByte1);
/*       */               } finally {
/* 11423 */                 param3CircularityLock.acquire();
/*       */               } 
/* 11425 */             } catch (Throwable throwable) {
/* 11426 */               param3InstallationListener.onWarmUpError(clazz, param3ResettableClassFileTransformer, throwable);
/* 11427 */               linkedHashMap.put(clazz, AgentBuilder.Default.c());
/*       */             } 
/*       */           } 
/* 11430 */           param3InstallationListener.onAfterWarmUp((Map)linkedHashMap, param3ResettableClassFileTransformer, i);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.Default.WarmupStrategy with(Collection<Class<?>> param3Collection) {
/*       */           LinkedHashSet<Class<?>> linkedHashSet;
/* 11438 */           (linkedHashSet = new LinkedHashSet<Class<?>>(this.types)).addAll(param3Collection);
/* 11439 */           return new Enabled(linkedHashSet);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.types.equals(((Enabled)param3Object).types))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.types.hashCode();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Proxied("java.lang.instrument.ClassFileTransformer")
/*       */         protected static interface Dispatcher
/*       */         {
/*       */           @MaybeNull
/*       */           @Proxied("transform")
/*       */           byte[] transform(ClassFileTransformer param4ClassFileTransformer, @MaybeNull @Proxied("java.lang.Module") Object param4Object, @MaybeNull ClassLoader param4ClassLoader, String param4String, @MaybeNull Class<?> param4Class, ProtectionDomain param4ProtectionDomain, byte[] param4ArrayOfbyte);
/*       */         }
/*       */       } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     protected static class Transformation
/*       */     {
/*       */       @AlwaysNull
/* 11483 */       private static final byte[] NONE = null;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final AgentBuilder.RawMatcher matcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final List<AgentBuilder.Transformer> transformers;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final boolean terminal;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Transformation(AgentBuilder.RawMatcher param2RawMatcher, List<AgentBuilder.Transformer> param2List, boolean param2Boolean) {
/* 11508 */         this.matcher = param2RawMatcher;
/* 11509 */         this.transformers = param2List;
/* 11510 */         this.terminal = param2Boolean;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected AgentBuilder.RawMatcher getMatcher() {
/* 11519 */         return this.matcher;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected List<AgentBuilder.Transformer> getTransformers() {
/* 11528 */         return this.transformers;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected boolean isTerminal() {
/* 11537 */         return this.terminal;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.terminal != ((Transformation)param2Object).terminal) ? false : (!this.matcher.equals(((Transformation)param2Object).matcher) ? false : (!!this.transformers.equals(((Transformation)param2Object).transformers))))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return ((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.transformers.hashCode()) * 31 + this.terminal;
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class SimpleMatcher
/*       */         implements AgentBuilder.RawMatcher
/*       */       {
/*       */         private final AgentBuilder.RawMatcher ignoreMatcher;
/*       */         
/*       */         private final List<AgentBuilder.Default.Transformation> transformations;
/*       */ 
/*       */         
/*       */         protected SimpleMatcher(AgentBuilder.RawMatcher param3RawMatcher, List<AgentBuilder.Default.Transformation> param3List) {
/* 11563 */           this.ignoreMatcher = param3RawMatcher;
/* 11564 */           this.transformations = param3List;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(TypeDescription param3TypeDescription, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull Class<?> param3Class, ProtectionDomain param3ProtectionDomain) {
/* 11575 */           if (this.ignoreMatcher.matches(param3TypeDescription, param3ClassLoader, param3JavaModule, param3Class, param3ProtectionDomain)) {
/* 11576 */             return false;
/*       */           }
/* 11578 */           for (Iterator<AgentBuilder.Default.Transformation> iterator = this.transformations.iterator(); iterator.hasNext();) {
/* 11579 */             if ((transformation = iterator.next()).getMatcher().matches(param3TypeDescription, param3ClassLoader, param3JavaModule, param3Class, param3ProtectionDomain)) {
/* 11580 */               return true;
/*       */             }
/*       */           } 
/* 11583 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.ignoreMatcher.equals(((SimpleMatcher)param3Object).ignoreMatcher) ? false : (!!this.transformations.equals(((SimpleMatcher)param3Object).transformations)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.ignoreMatcher.hashCode()) * 31 + this.transformations.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class DifferentialMatcher
/*       */         implements AgentBuilder.RawMatcher
/*       */       {
/*       */         private final AgentBuilder.RawMatcher ignoreMatcher;
/*       */ 
/*       */         
/*       */         private final List<AgentBuilder.Default.Transformation> transformations;
/*       */ 
/*       */         
/*       */         private final ResettableClassFileTransformer classFileTransformer;
/*       */ 
/*       */ 
/*       */         
/*       */         protected DifferentialMatcher(AgentBuilder.RawMatcher param3RawMatcher, List<AgentBuilder.Default.Transformation> param3List, ResettableClassFileTransformer param3ResettableClassFileTransformer) {
/* 11618 */           this.ignoreMatcher = param3RawMatcher;
/* 11619 */           this.transformations = param3List;
/* 11620 */           this.classFileTransformer = param3ResettableClassFileTransformer;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean matches(TypeDescription param3TypeDescription, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull Class<?> param3Class, ProtectionDomain param3ProtectionDomain) {
/* 11631 */           Iterator<AgentBuilder.Transformer> iterator = this.classFileTransformer.iterator(param3TypeDescription, param3ClassLoader, param3JavaModule, param3Class, param3ProtectionDomain);
/* 11632 */           if (this.ignoreMatcher.matches(param3TypeDescription, param3ClassLoader, param3JavaModule, param3Class, param3ProtectionDomain)) {
/* 11633 */             return iterator.hasNext();
/*       */           }
/* 11635 */           for (Iterator<AgentBuilder.Default.Transformation> iterator1 = this.transformations.iterator(); iterator1.hasNext();) {
/* 11636 */             if ((transformation = iterator1.next()).getMatcher().matches(param3TypeDescription, param3ClassLoader, param3JavaModule, param3Class, param3ProtectionDomain)) {
/* 11637 */               for (AgentBuilder.Transformer transformer : transformation.getTransformers()) {
/* 11638 */                 if (!iterator.hasNext() || !((AgentBuilder.Transformer)iterator.next()).equals(transformer)) {
/* 11639 */                   return true;
/*       */                 }
/*       */               } 
/*       */             }
/*       */           } 
/* 11644 */           return iterator.hasNext();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.ignoreMatcher.equals(((DifferentialMatcher)param3Object).ignoreMatcher) ? false : (!this.transformations.equals(((DifferentialMatcher)param3Object).transformations) ? false : (!!this.classFileTransformer.equals(((DifferentialMatcher)param3Object).classFileTransformer))))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return ((getClass().hashCode() * 31 + this.ignoreMatcher.hashCode()) * 31 + this.transformations.hashCode()) * 31 + this.classFileTransformer.hashCode();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static class TransformerIterator
/*       */         implements Iterator<AgentBuilder.Transformer>
/*       */       {
/*       */         private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         private final ClassLoader classLoader;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         private final JavaModule module;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         private final Class<?> classBeingRedefined;
/*       */ 
/*       */ 
/*       */         
/*       */         private final ProtectionDomain protectionDomain;
/*       */ 
/*       */ 
/*       */         
/*       */         private final Iterator<AgentBuilder.Default.Transformation> transformations;
/*       */ 
/*       */ 
/*       */         
/*       */         private Iterator<AgentBuilder.Transformer> transformers;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected TransformerIterator(TypeDescription param3TypeDescription, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull JavaModule param3JavaModule, @MaybeNull Class<?> param3Class, ProtectionDomain param3ProtectionDomain, List<AgentBuilder.Default.Transformation> param3List) {
/* 11707 */           this.typeDescription = param3TypeDescription;
/* 11708 */           this.classLoader = param3ClassLoader;
/* 11709 */           this.module = param3JavaModule;
/* 11710 */           this.classBeingRedefined = param3Class;
/* 11711 */           this.protectionDomain = param3ProtectionDomain;
/* 11712 */           this.transformations = param3List.iterator();
/* 11713 */           this.transformers = Collections.<AgentBuilder.Transformer>emptySet().iterator();
/* 11714 */           while (!this.transformers.hasNext() && this.transformations.hasNext()) {
/*       */             AgentBuilder.Default.Transformation transformation;
/* 11716 */             if ((transformation = this.transformations.next()).getMatcher().matches(param3TypeDescription, param3ClassLoader, param3JavaModule, param3Class, param3ProtectionDomain)) {
/* 11717 */               this.transformers = transformation.getTransformers().iterator();
/*       */             }
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean hasNext() {
/* 11726 */           return this.transformers.hasNext();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.Transformer next() {
/*       */           try {
/* 11734 */             return this.transformers.next();
/*       */           } finally {
/* 11736 */             while (!this.transformers.hasNext() && this.transformations.hasNext()) {
/*       */               AgentBuilder.Default.Transformation transformation;
/* 11738 */               if ((transformation = this.transformations.next()).getMatcher().matches(this.typeDescription, this.classLoader, this.module, this.classBeingRedefined, this.protectionDomain)) {
/* 11739 */                 this.transformers = transformation.getTransformers().iterator();
/*       */               }
/*       */             } 
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public void remove() {
/* 11749 */           throw new UnsupportedOperationException("remove");
/*       */         } } } @Enhance protected static class SimpleMatcher implements AgentBuilder.RawMatcher { private final AgentBuilder.RawMatcher ignoreMatcher; private final List<AgentBuilder.Default.Transformation> transformations; protected SimpleMatcher(AgentBuilder.RawMatcher param2RawMatcher, List<AgentBuilder.Default.Transformation> param2List) { this.ignoreMatcher = param2RawMatcher; this.transformations = param2List; }
/*       */       public boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) { if (this.ignoreMatcher.matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain)) return false;  for (Iterator<AgentBuilder.Default.Transformation> iterator = this.transformations.iterator(); iterator.hasNext();) { if ((transformation = iterator.next()).getMatcher().matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain))
/*       */             return true;  }  return false; }
/*       */       public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.ignoreMatcher.equals(((SimpleMatcher)param2Object).ignoreMatcher) ? false : (!!this.transformations.equals(((SimpleMatcher)param2Object).transformations))))); }
/*       */       public int hashCode() { return (getClass().hashCode() * 31 + this.ignoreMatcher.hashCode()) * 31 + this.transformations.hashCode(); } }
/*       */     @Enhance protected static class DifferentialMatcher implements AgentBuilder.RawMatcher { private final AgentBuilder.RawMatcher ignoreMatcher; private final List<AgentBuilder.Default.Transformation> transformations; private final ResettableClassFileTransformer classFileTransformer;
/*       */       protected DifferentialMatcher(AgentBuilder.RawMatcher param2RawMatcher, List<AgentBuilder.Default.Transformation> param2List, ResettableClassFileTransformer param2ResettableClassFileTransformer) { this.ignoreMatcher = param2RawMatcher; this.transformations = param2List; this.classFileTransformer = param2ResettableClassFileTransformer; }
/*       */       public boolean matches(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) { Iterator<AgentBuilder.Transformer> iterator = this.classFileTransformer.iterator(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain); if (this.ignoreMatcher.matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain))
/*       */           return iterator.hasNext();  for (Iterator<AgentBuilder.Default.Transformation> iterator1 = this.transformations.iterator(); iterator1.hasNext();) { if ((transformation = iterator1.next()).getMatcher().matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain))
/*       */             for (AgentBuilder.Transformer transformer : transformation.getTransformers()) { if (!iterator.hasNext() || !((AgentBuilder.Transformer)iterator.next()).equals(transformer))
/*       */                 return true;  }   }  return iterator.hasNext(); }
/*       */       public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.ignoreMatcher.equals(((DifferentialMatcher)param2Object).ignoreMatcher) ? false : (!this.transformations.equals(((DifferentialMatcher)param2Object).transformations) ? false : (!!this.classFileTransformer.equals(((DifferentialMatcher)param2Object).classFileTransformer)))))); }
/*       */       public int hashCode() { return ((getClass().hashCode() * 31 + this.ignoreMatcher.hashCode()) * 31 + this.transformations.hashCode()) * 31 + this.classFileTransformer.hashCode(); } }
/* 11763 */     protected static class ExecutingTransformer extends ResettableClassFileTransformer.AbstractBase { protected static final Factory FACTORY = (Factory)AgentBuilder.Default.a(Factory.CreationAction.INSTANCE); private final ByteBuddy byteBuddy; private final AgentBuilder.PoolStrategy poolStrategy; private final AgentBuilder.TypeStrategy typeStrategy; private final AgentBuilder.Listener listener; private final AgentBuilder.Default.NativeMethodStrategy nativeMethodStrategy; private final AgentBuilder.InitializationStrategy initializationStrategy; private final AgentBuilder.InjectionStrategy injectionStrategy; private final AgentBuilder.LambdaInstrumentationStrategy lambdaInstrumentationStrategy; private final AgentBuilder.DescriptionStrategy descriptionStrategy; private final AgentBuilder.LocationStrategy locationStrategy; private final AgentBuilder.FallbackStrategy fallbackStrategy; private final AgentBuilder.ClassFileBufferStrategy classFileBufferStrategy; private final AgentBuilder.InstallationListener installationListener; private final AgentBuilder.RawMatcher ignoreMatcher; private final AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer; private final List<AgentBuilder.Default.Transformation> transformations; private final AgentBuilder.CircularityLock circularityLock; @MaybeNull private final Object accessControlContext; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*       */          }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ExecutingTransformer(ByteBuddy param2ByteBuddy, AgentBuilder.Listener param2Listener, AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.TypeStrategy param2TypeStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param2NativeMethodStrategy, AgentBuilder.InitializationStrategy param2InitializationStrategy, AgentBuilder.InjectionStrategy param2InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param2LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param2ClassFileBufferStrategy, AgentBuilder.InstallationListener param2InstallationListener, AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param2ResubmissionEnforcer, List<AgentBuilder.Default.Transformation> param2List, AgentBuilder.CircularityLock param2CircularityLock) {
/* 11895 */         this.byteBuddy = param2ByteBuddy;
/* 11896 */         this.typeStrategy = param2TypeStrategy;
/* 11897 */         this.poolStrategy = param2PoolStrategy;
/* 11898 */         this.locationStrategy = param2LocationStrategy;
/* 11899 */         this.listener = param2Listener;
/* 11900 */         this.nativeMethodStrategy = param2NativeMethodStrategy;
/* 11901 */         this.initializationStrategy = param2InitializationStrategy;
/* 11902 */         this.injectionStrategy = param2InjectionStrategy;
/* 11903 */         this.lambdaInstrumentationStrategy = param2LambdaInstrumentationStrategy;
/* 11904 */         this.descriptionStrategy = param2DescriptionStrategy;
/* 11905 */         this.fallbackStrategy = param2FallbackStrategy;
/* 11906 */         this.classFileBufferStrategy = param2ClassFileBufferStrategy;
/* 11907 */         this.installationListener = param2InstallationListener;
/* 11908 */         this.ignoreMatcher = param2RawMatcher;
/* 11909 */         this.resubmissionEnforcer = param2ResubmissionEnforcer;
/* 11910 */         this.transformations = param2List;
/* 11911 */         this.circularityLock = param2CircularityLock;
/* 11912 */         this.accessControlContext = getContext();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       @Enhance
/*       */       private static Object getContext() {
/* 11923 */         return ACCESS_CONTROLLER ? AccessController.getContext() : null;
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
/*       */       @Enhance
/*       */       private static <T> T doPrivileged(PrivilegedAction<T> param2PrivilegedAction, @MaybeNull Object param2Object) {
/* 11936 */         return ACCESS_CONTROLLER ? AccessController.doPrivileged(param2PrivilegedAction, (AccessControlContext)param2Object) : param2PrivilegedAction.run();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public byte[] transform(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull String param2String, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain, byte[] param2ArrayOfbyte) {
/* 11948 */         if (this.circularityLock.acquire()) {
/*       */           try {
/* 11950 */             return doPrivileged(new LegacyVmDispatcher(this, param2ClassLoader, param2String, param2Class, param2ProtectionDomain, param2ArrayOfbyte), this.accessControlContext);
/*       */           
/*       */           }
/*       */           finally {
/*       */ 
/*       */             
/* 11956 */             this.circularityLock.release();
/*       */           } 
/*       */         }
/* 11959 */         return AgentBuilder.Default.c();
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
/*       */       @MaybeNull
/*       */       protected byte[] transform(Object param2Object, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull String param2String, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain, byte[] param2ArrayOfbyte) {
/* 11982 */         if (this.circularityLock.acquire()) {
/*       */           try {
/* 11984 */             return doPrivileged(new Java9CapableVmDispatcher(this, param2Object, param2ClassLoader, param2String, param2Class, param2ProtectionDomain, param2ArrayOfbyte), this.accessControlContext);
/*       */ 
/*       */           
/*       */           }
/*       */           finally {
/*       */ 
/*       */             
/* 11991 */             this.circularityLock.release();
/*       */           } 
/*       */         }
/* 11994 */         return AgentBuilder.Default.c();
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
/*       */       @MaybeNull
/*       */       private byte[] transform(@MaybeNull JavaModule param2JavaModule, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull String param2String, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain, byte[] param2ArrayOfbyte) {
/* 12016 */         if (param2String == null || !this.lambdaInstrumentationStrategy.isInstrumented(param2Class)) {
/* 12017 */           return AgentBuilder.Default.c();
/*       */         }
/* 12019 */         param2String = param2String.replace('/', '.');
/*       */         try {
/* 12021 */           if (this.resubmissionEnforcer.isEnforced(param2String, param2ClassLoader, param2JavaModule, param2Class)) {
/* 12022 */             return AgentBuilder.Default.c();
/*       */           }
/* 12024 */         } catch (Throwable throwable) {
/*       */           try {
/* 12026 */             this.listener.onDiscovery(param2String, param2ClassLoader, param2JavaModule, (param2Class != null));
/*       */           } finally {
/* 12028 */             this.listener.onError(param2String, param2ClassLoader, param2JavaModule, (param2Class != null), throwable);
/*       */           } 
/* 12030 */           throw new IllegalStateException("Failed transformation of " + param2String, throwable);
/*       */         } 
/*       */         try {
/* 12033 */           this.listener.onDiscovery(param2String, param2ClassLoader, param2JavaModule, (param2Class != null));
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 12038 */           ClassFileLocator.Compound compound = new ClassFileLocator.Compound(new ClassFileLocator[] { this.classFileBufferStrategy.resolve(param2String, (byte[])throwable, param2ClassLoader, param2JavaModule, param2ProtectionDomain), this.locationStrategy.classFileLocator(param2ClassLoader, param2JavaModule) });
/* 12039 */           TypePool typePool = this.classFileBufferStrategy.typePool(this.poolStrategy, (ClassFileLocator)compound, param2ClassLoader, param2String);
/*       */           try {
/* 12041 */             return doTransform(param2JavaModule, param2ClassLoader, param2String, param2Class, (param2Class != null), param2ProtectionDomain, typePool, (ClassFileLocator)compound);
/* 12042 */           } catch (Throwable throwable1) {
/* 12043 */             if (param2Class != null && this.descriptionStrategy.isLoadedFirst() && this.fallbackStrategy.isFallback(param2Class, throwable1)) {
/* 12044 */               return doTransform(param2JavaModule, param2ClassLoader, param2String, AgentBuilder.Default.b(), true, param2ProtectionDomain, typePool, (ClassFileLocator)compound);
/*       */             }
/* 12046 */             throw throwable1;
/*       */           }
/*       */         
/* 12049 */         } catch (Throwable throwable1) {
/* 12050 */           this.listener.onError(param2String, param2ClassLoader, param2JavaModule, (param2Class != null), throwable1);
/* 12051 */           throw new IllegalStateException("Failed transformation of " + param2String, throwable1);
/*       */         } finally {
/* 12053 */           this.listener.onComplete(param2String, param2ClassLoader, param2JavaModule, (param2Class != null));
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       private byte[] doTransform(@MaybeNull JavaModule param2JavaModule, @MaybeNull ClassLoader param2ClassLoader, String param2String, @MaybeNull Class<?> param2Class, boolean param2Boolean, ProtectionDomain param2ProtectionDomain, TypePool param2TypePool, ClassFileLocator param2ClassFileLocator) {
/* 12079 */         TypeDescription typeDescription = this.descriptionStrategy.apply(param2String, param2Class, param2TypePool, this.circularityLock, param2ClassLoader, param2JavaModule);
/* 12080 */         ArrayList<AgentBuilder.Transformer> arrayList = new ArrayList();
/* 12081 */         if (!this.ignoreMatcher.matches(typeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain))
/* 12082 */           for (Iterator<AgentBuilder.Default.Transformation> iterator1 = this.transformations.iterator(); iterator1.hasNext();) {
/* 12083 */             if ((transformation = iterator1.next()).getMatcher().matches(typeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain)) {
/* 12084 */               arrayList.addAll(transformation.getTransformers());
/* 12085 */               if (!transformation.isTerminal()) {
/*       */                 continue;
/*       */               }
/*       */               break;
/*       */             } 
/*       */           }  
/* 12091 */         if (arrayList.isEmpty()) {
/* 12092 */           this.listener.onIgnored(typeDescription, param2ClassLoader, param2JavaModule, param2Boolean);
/* 12093 */           return AgentBuilder.Default.Transformation.a();
/*       */         } 
/* 12095 */         DynamicType.Builder<?> builder = this.typeStrategy.builder(typeDescription, this.byteBuddy, param2ClassFileLocator, this.nativeMethodStrategy
/*       */ 
/*       */             
/* 12098 */             .resolve(), param2ClassLoader, param2JavaModule, param2ProtectionDomain);
/*       */ 
/*       */ 
/*       */         
/* 12102 */         AgentBuilder.InitializationStrategy.Dispatcher dispatcher = this.initializationStrategy.dispatcher();
/* 12103 */         for (Iterator<AgentBuilder.Transformer> iterator = arrayList.iterator(); iterator.hasNext();) {
/* 12104 */           builder = (transformer = iterator.next()).transform(builder, typeDescription, param2ClassLoader, param2JavaModule, param2ProtectionDomain);
/*       */         }
/* 12106 */         DynamicType.Unloaded unloaded = dispatcher.apply(builder).make((TypeResolutionStrategy)TypeResolutionStrategy.Disabled.INSTANCE, param2TypePool);
/* 12107 */         dispatcher.register((DynamicType)unloaded, param2ClassLoader, param2ProtectionDomain, this.injectionStrategy);
/* 12108 */         this.listener.onTransformation(typeDescription, param2ClassLoader, param2JavaModule, param2Boolean, (DynamicType)unloaded);
/* 12109 */         return unloaded.getBytes();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Iterator<AgentBuilder.Transformer> iterator(TypeDescription param2TypeDescription, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull JavaModule param2JavaModule, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain) {
/* 12120 */         if (this.ignoreMatcher.matches(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain))
/* 12121 */           return Collections.<AgentBuilder.Transformer>emptySet().iterator();  return new AgentBuilder.Default.Transformation.TransformerIterator(param2TypeDescription, param2ClassLoader, param2JavaModule, param2Class, param2ProtectionDomain, this.transformations);
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
/*       */       public synchronized boolean reset(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer, AgentBuilder.RedefinitionStrategy param2RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param2DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param2BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param2Listener) {
/* 12134 */         if (param2Instrumentation.removeTransformer(param2ResettableClassFileTransformer)) {
/* 12135 */           param2RedefinitionStrategy.apply(param2Instrumentation, this.poolStrategy, this.locationStrategy, this.descriptionStrategy, this.fallbackStrategy, param2DiscoveryStrategy, this.lambdaInstrumentationStrategy, AgentBuilder.Listener.NoOp.INSTANCE, param2Listener, new AgentBuilder.Default.Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations), param2BatchAllocator, AgentBuilder.CircularityLock.Inactive.INSTANCE);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/* 12147 */           this.installationListener.onReset(param2Instrumentation, param2ResettableClassFileTransformer);
/* 12148 */           return true;
/*       */         } 
/* 12150 */         return false;
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
/*       */       public enum CreationAction
/*       */         implements PrivilegedAction<Factory>
/*       */       {
/* 12209 */         INSTANCE;
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*       */         public final AgentBuilder.Default.ExecutingTransformer.Factory run()
/*       */         {
/*       */           
/* 12217 */           try { return new AgentBuilder.Default.ExecutingTransformer.Factory.ForJava9CapableVm((new ByteBuddy())
/* 12218 */                 .with(TypeValidation.DISABLED)
/* 12219 */                 .subclass(AgentBuilder.Default.ExecutingTransformer.class)
/* 12220 */                 .name(AgentBuilder.Default.ExecutingTransformer.class.getName() + "$ByteBuddy$ModuleSupport")
/* 12221 */                 .method((ElementMatcher)ElementMatchers.named("transform").and((ElementMatcher)ElementMatchers.takesArgument(0, JavaType.MODULE.load())))
/* 12222 */                 .intercept((Implementation)MethodCall.invoke(AgentBuilder.Default.ExecutingTransformer.class.getDeclaredMethod("transform", new Class[] {
/*       */                         
/*       */                         Object.class, ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class
/*       */ 
/*       */ 
/*       */                       
/* 12228 */                       })).onSuper().withAllArguments())
/* 12229 */                 .make()
/* 12230 */                 .load(AgentBuilder.Default.ExecutingTransformer.class.getClassLoader(), (ClassLoadingStrategy)ClassLoadingStrategy.Default.WRAPPER_PERSISTENT
/* 12231 */                   .with(AgentBuilder.Default.ExecutingTransformer.class.getProtectionDomain()))
/* 12232 */                 .getLoaded()
/* 12233 */                 .getDeclaredConstructor(new Class[] { 
/*       */                     ByteBuddy.class, AgentBuilder.Listener.class, AgentBuilder.PoolStrategy.class, AgentBuilder.TypeStrategy.class, AgentBuilder.LocationStrategy.class, AgentBuilder.Default.NativeMethodStrategy.class, AgentBuilder.InitializationStrategy.class, AgentBuilder.InjectionStrategy.class, AgentBuilder.LambdaInstrumentationStrategy.class, AgentBuilder.DescriptionStrategy.class, 
/*       */                     AgentBuilder.FallbackStrategy.class, AgentBuilder.ClassFileBufferStrategy.class, AgentBuilder.InstallationListener.class, AgentBuilder.RawMatcher.class, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer.class, List.class, AgentBuilder.CircularityLock.class }));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */              }
/*       */           
/* 12250 */           catch (Exception exception)
/* 12251 */           { return AgentBuilder.Default.ExecutingTransformer.Factory.ForLegacyVm.INSTANCE; }  } } protected static interface Factory { ResettableClassFileTransformer make(ByteBuddy param3ByteBuddy, AgentBuilder.Listener param3Listener, AgentBuilder.PoolStrategy param3PoolStrategy, AgentBuilder.TypeStrategy param3TypeStrategy, AgentBuilder.LocationStrategy param3LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param3NativeMethodStrategy, AgentBuilder.InitializationStrategy param3InitializationStrategy, AgentBuilder.InjectionStrategy param3InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param3LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param3DescriptionStrategy, AgentBuilder.FallbackStrategy param3FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param3ClassFileBufferStrategy, AgentBuilder.InstallationListener param3InstallationListener, AgentBuilder.RawMatcher param3RawMatcher, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param3ResubmissionEnforcer, List<AgentBuilder.Default.Transformation> param3List, AgentBuilder.CircularityLock param3CircularityLock); public enum CreationAction implements PrivilegedAction<Factory> { INSTANCE; @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final AgentBuilder.Default.ExecutingTransformer.Factory run() { try { return new AgentBuilder.Default.ExecutingTransformer.Factory.ForJava9CapableVm((new ByteBuddy()).with(TypeValidation.DISABLED).subclass(AgentBuilder.Default.ExecutingTransformer.class).name(AgentBuilder.Default.ExecutingTransformer.class.getName() + "$ByteBuddy$ModuleSupport").method((ElementMatcher)ElementMatchers.named("transform").and((ElementMatcher)ElementMatchers.takesArgument(0, JavaType.MODULE.load()))).intercept((Implementation)MethodCall.invoke(AgentBuilder.Default.ExecutingTransformer.class.getDeclaredMethod("transform", new Class[] { Object.class, ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class })).onSuper().withAllArguments()).make().load(AgentBuilder.Default.ExecutingTransformer.class.getClassLoader(), (ClassLoadingStrategy)ClassLoadingStrategy.Default.WRAPPER_PERSISTENT.with(AgentBuilder.Default.ExecutingTransformer.class.getProtectionDomain())).getLoaded().getDeclaredConstructor(new Class[] { ByteBuddy.class, AgentBuilder.Listener.class, AgentBuilder.PoolStrategy.class, AgentBuilder.TypeStrategy.class, AgentBuilder.LocationStrategy.class, AgentBuilder.Default.NativeMethodStrategy.class, AgentBuilder.InitializationStrategy.class, AgentBuilder.InjectionStrategy.class, AgentBuilder.LambdaInstrumentationStrategy.class, AgentBuilder.DescriptionStrategy.class, AgentBuilder.FallbackStrategy.class, AgentBuilder.ClassFileBufferStrategy.class, AgentBuilder.InstallationListener.class, AgentBuilder.RawMatcher.class, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer.class, List.class, AgentBuilder.CircularityLock.class })); } catch (Exception exception) { return AgentBuilder.Default.ExecutingTransformer.Factory.ForLegacyVm.INSTANCE; }
/*       */              }
/*       */            }
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
/*       */         public static class ForJava9CapableVm
/*       */           implements Factory
/*       */         {
/*       */           private final Constructor<? extends ResettableClassFileTransformer> executingTransformer;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ForJava9CapableVm(Constructor<? extends ResettableClassFileTransformer> param4Constructor) {
/* 12276 */             this.executingTransformer = param4Constructor;
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
/*       */           public ResettableClassFileTransformer make(ByteBuddy param4ByteBuddy, AgentBuilder.Listener param4Listener, AgentBuilder.PoolStrategy param4PoolStrategy, AgentBuilder.TypeStrategy param4TypeStrategy, AgentBuilder.LocationStrategy param4LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param4NativeMethodStrategy, AgentBuilder.InitializationStrategy param4InitializationStrategy, AgentBuilder.InjectionStrategy param4InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param4LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param4DescriptionStrategy, AgentBuilder.FallbackStrategy param4FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param4ClassFileBufferStrategy, AgentBuilder.InstallationListener param4InstallationListener, AgentBuilder.RawMatcher param4RawMatcher, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param4ResubmissionEnforcer, List<AgentBuilder.Default.Transformation> param4List, AgentBuilder.CircularityLock param4CircularityLock) {
/*       */             try {
/* 12300 */               return this.executingTransformer.newInstance(new Object[] { param4ByteBuddy, param4Listener, param4PoolStrategy, param4TypeStrategy, param4LocationStrategy, param4NativeMethodStrategy, param4InitializationStrategy, param4InjectionStrategy, param4LambdaInstrumentationStrategy, param4DescriptionStrategy, param4FallbackStrategy, param4ClassFileBufferStrategy, param4InstallationListener, param4RawMatcher, param4ResubmissionEnforcer, param4List, param4CircularityLock });
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             }
/* 12317 */             catch (IllegalAccessException illegalAccessException) {
/* 12318 */               throw new IllegalStateException("Cannot access " + this.executingTransformer, illegalAccessException);
/* 12319 */             } catch (InstantiationException instantiationException) {
/* 12320 */               throw new IllegalStateException("Cannot instantiate " + this.executingTransformer.getDeclaringClass(), instantiationException);
/* 12321 */             } catch (InvocationTargetException invocationTargetException) {
/* 12322 */               throw new IllegalStateException("Cannot invoke " + this.executingTransformer, invocationTargetException.getTargetException());
/*       */             } 
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.executingTransformer.equals(((ForJava9CapableVm)param4Object).executingTransformer))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.executingTransformer.hashCode();
/*       */           } }
/*       */         
/*       */         public enum ForLegacyVm implements Factory {
/* 12335 */           INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final ResettableClassFileTransformer make(ByteBuddy param4ByteBuddy, AgentBuilder.Listener param4Listener, AgentBuilder.PoolStrategy param4PoolStrategy, AgentBuilder.TypeStrategy param4TypeStrategy, AgentBuilder.LocationStrategy param4LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param4NativeMethodStrategy, AgentBuilder.InitializationStrategy param4InitializationStrategy, AgentBuilder.InjectionStrategy param4InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param4LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param4DescriptionStrategy, AgentBuilder.FallbackStrategy param4FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param4ClassFileBufferStrategy, AgentBuilder.InstallationListener param4InstallationListener, AgentBuilder.RawMatcher param4RawMatcher, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param4ResubmissionEnforcer, List<AgentBuilder.Default.Transformation> param4List, AgentBuilder.CircularityLock param4CircularityLock) {
/* 12357 */             return new AgentBuilder.Default.ExecutingTransformer(param4ByteBuddy, param4Listener, param4PoolStrategy, param4TypeStrategy, param4LocationStrategy, param4NativeMethodStrategy, param4InitializationStrategy, param4InjectionStrategy, param4LambdaInstrumentationStrategy, param4DescriptionStrategy, param4FallbackStrategy, param4ClassFileBufferStrategy, param4InstallationListener, param4RawMatcher, param4ResubmissionEnforcer, param4List, param4CircularityLock);
/*       */           }
/*       */         } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance(includeSyntheticFields = true)
/*       */       protected class LegacyVmDispatcher
/*       */         implements PrivilegedAction<byte[]>
/*       */       {
/*       */         @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final ClassLoader classLoader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final String internalTypeName;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final Class<?> classBeingRedefined;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final ProtectionDomain protectionDomain;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final byte[] binaryRepresentation;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected LegacyVmDispatcher(@MaybeNull AgentBuilder.Default.ExecutingTransformer this$0, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull String param3String, Class<?> param3Class, ProtectionDomain param3ProtectionDomain, byte[] param3ArrayOfbyte) {
/* 12429 */           this.classLoader = param3ClassLoader;
/* 12430 */           this.internalTypeName = param3String;
/* 12431 */           this.classBeingRedefined = param3Class;
/* 12432 */           this.protectionDomain = param3ProtectionDomain;
/* 12433 */           this.binaryRepresentation = param3ArrayOfbyte;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public byte[] run() {
/* 12441 */           return AgentBuilder.Default.ExecutingTransformer.a(this.a, JavaModule.UNSUPPORTED, this.classLoader, this.internalTypeName, this.classBeingRedefined, this.protectionDomain, this.binaryRepresentation);
/*       */         }
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           String str2;
/*       */           ClassLoader classLoader2;
/*       */           Class<?> clazz2;
/*       */           if (this == param3Object)
/*       */             return true; 
/*       */           if (param3Object == null)
/*       */             return false; 
/*       */           if (getClass() != param3Object.getClass())
/*       */             return false; 
/*       */           String str1 = ((LegacyVmDispatcher)param3Object).internalTypeName;
/*       */           if (str1 != null) {
/*       */             if ((str2 = this.internalTypeName) != null) {
/*       */               if (!str2.equals(str1))
/*       */                 return false; 
/*       */             } else {
/*       */               return false;
/*       */             } 
/*       */           } else if ((str2 = this.internalTypeName) != null) {
/*       */             return false;
/*       */           } 
/*       */           ClassLoader classLoader1 = ((LegacyVmDispatcher)param3Object).classLoader;
/*       */           if (classLoader1 != null) {
/*       */             if ((classLoader2 = this.classLoader) != null) {
/*       */               if (!classLoader2.equals(classLoader1))
/*       */                 return false; 
/*       */             } else {
/*       */               return false;
/*       */             } 
/*       */           } else if ((classLoader2 = this.classLoader) != null) {
/*       */             return false;
/*       */           } 
/*       */           Class<?> clazz1 = ((LegacyVmDispatcher)param3Object).classBeingRedefined;
/*       */           if (clazz1 != null) {
/*       */             if ((clazz2 = this.classBeingRedefined) != null) {
/*       */               if (!clazz2.equals(clazz1))
/*       */                 return false; 
/*       */             } else {
/*       */               return false;
/*       */             } 
/*       */           } else if ((clazz2 = this.classBeingRedefined) != null) {
/*       */             return false;
/*       */           } 
/*       */           return !this.protectionDomain.equals(((LegacyVmDispatcher)param3Object).protectionDomain) ? false : (!Arrays.equals(this.binaryRepresentation, ((LegacyVmDispatcher)param3Object).binaryRepresentation) ? false : (!!this.a.equals(((LegacyVmDispatcher)param3Object).a)));
/*       */         }
/*       */         public int hashCode() {
/*       */           ClassLoader classLoader;
/*       */           if ((classLoader = this.classLoader) != null);
/*       */           String str;
/*       */           if ((str = this.internalTypeName) != null);
/*       */           Class<?> clazz;
/*       */           if ((clazz = this.classBeingRedefined) != null);
/*       */           return (((((getClass().hashCode() * 31 + classLoader.hashCode()) * 31 + str.hashCode()) * 31 + clazz.hashCode()) * 31 + this.protectionDomain.hashCode()) * 31 + Arrays.hashCode(this.binaryRepresentation)) * 31 + this.a.hashCode();
/*       */         } }
/*       */       @Enhance(includeSyntheticFields = true)
/*       */       protected class Java9CapableVmDispatcher implements PrivilegedAction<byte[]> { private final Object rawModule; @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final ClassLoader classLoader; @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final String internalTypeName; @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final Class<?> classBeingRedefined;
/*       */         private final ProtectionDomain protectionDomain;
/*       */         private final byte[] binaryRepresentation;
/*       */         
/* 12508 */         protected Java9CapableVmDispatcher(AgentBuilder.Default.ExecutingTransformer this$0, @MaybeNull Object param3Object, @MaybeNull ClassLoader param3ClassLoader, @MaybeNull String param3String, Class<?> param3Class, ProtectionDomain param3ProtectionDomain, byte[] param3ArrayOfbyte) { this.rawModule = param3Object;
/* 12509 */           this.classLoader = param3ClassLoader;
/* 12510 */           this.internalTypeName = param3String;
/* 12511 */           this.classBeingRedefined = param3Class;
/* 12512 */           this.protectionDomain = param3ProtectionDomain;
/* 12513 */           this.binaryRepresentation = param3ArrayOfbyte; } public boolean equals(@MaybeNull Object param3Object) { String str2; ClassLoader classLoader2; Class<?> clazz2; if (this == param3Object)
/*       */             return true;  if (param3Object == null)
/*       */             return false;  if (getClass() != param3Object.getClass())
/*       */             return false;  String str1 = ((Java9CapableVmDispatcher)param3Object).internalTypeName; if (str1 != null) { if ((str2 = this.internalTypeName) != null) { if (!str2.equals(str1))
/*       */                 return false;  } else { return false; }  } else if ((str2 = this.internalTypeName) != null) { return false; }  if (!this.rawModule.equals(((Java9CapableVmDispatcher)param3Object).rawModule))
/*       */             return false;  ClassLoader classLoader1 = ((Java9CapableVmDispatcher)param3Object).classLoader; if (classLoader1 != null) { if ((classLoader2 = this.classLoader) != null) { if (!classLoader2.equals(classLoader1))
/*       */                 return false;  } else { return false; }  } else if ((classLoader2 = this.classLoader) != null) { return false; }  Class<?> clazz1 = ((Java9CapableVmDispatcher)param3Object).classBeingRedefined; if (clazz1 != null) { if ((clazz2 = this.classBeingRedefined) != null) { if (!clazz2.equals(clazz1))
/*       */                 return false;  } else { return false; }  } else if ((clazz2 = this.classBeingRedefined) != null) { return false; }  return !this.protectionDomain.equals(((Java9CapableVmDispatcher)param3Object).protectionDomain) ? false : (!Arrays.equals(this.binaryRepresentation, ((Java9CapableVmDispatcher)param3Object).binaryRepresentation) ? false : (!!this.a.equals(((Java9CapableVmDispatcher)param3Object).a))); }
/* 12521 */         @MaybeNull public byte[] run() { return AgentBuilder.Default.ExecutingTransformer.a(this.a, JavaModule.of(this.rawModule), this.classLoader, this.internalTypeName, this.classBeingRedefined, this.protectionDomain, this.binaryRepresentation); } public int hashCode() { ClassLoader classLoader; if ((classLoader = this.classLoader) != null); String str; if ((str = this.internalTypeName) != null); Class<?> clazz; if ((clazz = this.classBeingRedefined) != null); return ((((((getClass().hashCode() * 31 + this.rawModule.hashCode()) * 31 + classLoader.hashCode()) * 31 + str.hashCode()) * 31 + clazz.hashCode()) * 31 + this.protectionDomain.hashCode()) * 31 + Arrays.hashCode(this.binaryRepresentation)) * 31 + this.a.hashCode(); } } } protected static interface Factory { ResettableClassFileTransformer make(ByteBuddy param2ByteBuddy, AgentBuilder.Listener param2Listener, AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.TypeStrategy param2TypeStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param2NativeMethodStrategy, AgentBuilder.InitializationStrategy param2InitializationStrategy, AgentBuilder.InjectionStrategy param2InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param2LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param2ClassFileBufferStrategy, AgentBuilder.InstallationListener param2InstallationListener, AgentBuilder.RawMatcher param2RawMatcher, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param2ResubmissionEnforcer, List<AgentBuilder.Default.Transformation> param2List, AgentBuilder.CircularityLock param2CircularityLock); public enum CreationAction implements PrivilegedAction<Factory> {
/*       */         INSTANCE; @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final AgentBuilder.Default.ExecutingTransformer.Factory run() { try { return new AgentBuilder.Default.ExecutingTransformer.Factory.ForJava9CapableVm((new ByteBuddy()).with(TypeValidation.DISABLED).subclass(AgentBuilder.Default.ExecutingTransformer.class).name(AgentBuilder.Default.ExecutingTransformer.class.getName() + "$ByteBuddy$ModuleSupport").method((ElementMatcher)ElementMatchers.named("transform").and((ElementMatcher)ElementMatchers.takesArgument(0, JavaType.MODULE.load()))).intercept((Implementation)MethodCall.invoke(AgentBuilder.Default.ExecutingTransformer.class.getDeclaredMethod("transform", new Class[] { Object.class, ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class })).onSuper().withAllArguments()).make().load(AgentBuilder.Default.ExecutingTransformer.class.getClassLoader(), (ClassLoadingStrategy)ClassLoadingStrategy.Default.WRAPPER_PERSISTENT.with(AgentBuilder.Default.ExecutingTransformer.class.getProtectionDomain())).getLoaded().getDeclaredConstructor(new Class[] { 
/*       */                     ByteBuddy.class, AgentBuilder.Listener.class, AgentBuilder.PoolStrategy.class, AgentBuilder.TypeStrategy.class, AgentBuilder.LocationStrategy.class, AgentBuilder.Default.NativeMethodStrategy.class, AgentBuilder.InitializationStrategy.class, AgentBuilder.InjectionStrategy.class, AgentBuilder.LambdaInstrumentationStrategy.class, AgentBuilder.DescriptionStrategy.class, 
/*       */                     AgentBuilder.FallbackStrategy.class, AgentBuilder.ClassFileBufferStrategy.class, AgentBuilder.InstallationListener.class, AgentBuilder.RawMatcher.class, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer.class, List.class, AgentBuilder.CircularityLock.class })); }
/*       */           catch (Exception exception)
/*       */           { return AgentBuilder.Default.ExecutingTransformer.Factory.ForLegacyVm.INSTANCE; }
/*       */            }
/*       */       } @Enhance public static class ForJava9CapableVm implements Factory {
/*       */         private final Constructor<? extends ResettableClassFileTransformer> executingTransformer;
/*       */         protected ForJava9CapableVm(Constructor<? extends ResettableClassFileTransformer> param4Constructor) { this.executingTransformer = param4Constructor; }
/*       */         public ResettableClassFileTransformer make(ByteBuddy param4ByteBuddy, AgentBuilder.Listener param4Listener, AgentBuilder.PoolStrategy param4PoolStrategy, AgentBuilder.TypeStrategy param4TypeStrategy, AgentBuilder.LocationStrategy param4LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param4NativeMethodStrategy, AgentBuilder.InitializationStrategy param4InitializationStrategy, AgentBuilder.InjectionStrategy param4InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param4LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param4DescriptionStrategy, AgentBuilder.FallbackStrategy param4FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param4ClassFileBufferStrategy, AgentBuilder.InstallationListener param4InstallationListener, AgentBuilder.RawMatcher param4RawMatcher, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param4ResubmissionEnforcer, List<AgentBuilder.Default.Transformation> param4List, AgentBuilder.CircularityLock param4CircularityLock) { try {
/*       */             return this.executingTransformer.newInstance(new Object[] { 
/*       */                   param4ByteBuddy, param4Listener, param4PoolStrategy, param4TypeStrategy, param4LocationStrategy, param4NativeMethodStrategy, param4InitializationStrategy, param4InjectionStrategy, param4LambdaInstrumentationStrategy, param4DescriptionStrategy, 
/*       */                   param4FallbackStrategy, param4ClassFileBufferStrategy, param4InstallationListener, param4RawMatcher, param4ResubmissionEnforcer, param4List, param4CircularityLock });
/*       */           } catch (IllegalAccessException illegalAccessException) {
/*       */             throw new IllegalStateException("Cannot access " + this.executingTransformer, illegalAccessException);
/*       */           } catch (InstantiationException instantiationException) {
/*       */             throw new IllegalStateException("Cannot instantiate " + this.executingTransformer.getDeclaringClass(), instantiationException);
/*       */           } catch (InvocationTargetException invocationTargetException) {
/*       */             throw new IllegalStateException("Cannot invoke " + this.executingTransformer, invocationTargetException.getTargetException());
/*       */           }  }
/*       */         public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.executingTransformer.equals(((ForJava9CapableVm)param4Object).executingTransformer)))); }
/*       */         public int hashCode() { return getClass().hashCode() * 31 + this.executingTransformer.hashCode(); }
/*       */       }
/*       */       public enum ForLegacyVm implements Factory { INSTANCE;
/*       */         public final ResettableClassFileTransformer make(ByteBuddy param4ByteBuddy, AgentBuilder.Listener param4Listener, AgentBuilder.PoolStrategy param4PoolStrategy, AgentBuilder.TypeStrategy param4TypeStrategy, AgentBuilder.LocationStrategy param4LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param4NativeMethodStrategy, AgentBuilder.InitializationStrategy param4InitializationStrategy, AgentBuilder.InjectionStrategy param4InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param4LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param4DescriptionStrategy, AgentBuilder.FallbackStrategy param4FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param4ClassFileBufferStrategy, AgentBuilder.InstallationListener param4InstallationListener, AgentBuilder.RawMatcher param4RawMatcher, AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer param4ResubmissionEnforcer, List<AgentBuilder.Default.Transformation> param4List, AgentBuilder.CircularityLock param4CircularityLock) { return new AgentBuilder.Default.ExecutingTransformer(param4ByteBuddy, param4Listener, param4PoolStrategy, param4TypeStrategy, param4LocationStrategy, param4NativeMethodStrategy, param4InitializationStrategy, param4InjectionStrategy, param4LambdaInstrumentationStrategy, param4DescriptionStrategy, param4FallbackStrategy, param4ClassFileBufferStrategy, param4InstallationListener, param4RawMatcher, param4ResubmissionEnforcer, param4List, param4CircularityLock); } } }
/* 12547 */     protected static abstract class Delegator implements AgentBuilder { public AgentBuilder with(ByteBuddy param2ByteBuddy) { return materialize().with(param2ByteBuddy); }
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract AgentBuilder materialize();
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.Listener param2Listener) {
/* 12554 */         return materialize().with(param2Listener);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.CircularityLock param2CircularityLock) {
/* 12561 */         return materialize().with(param2CircularityLock);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.TypeStrategy param2TypeStrategy) {
/* 12568 */         return materialize().with(param2TypeStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.PoolStrategy param2PoolStrategy) {
/* 12575 */         return materialize().with(param2PoolStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.LocationStrategy param2LocationStrategy) {
/* 12582 */         return materialize().with(param2LocationStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.InitializationStrategy param2InitializationStrategy) {
/* 12589 */         return materialize().with(param2InitializationStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.RedefinitionListenable.WithoutBatchStrategy with(AgentBuilder.RedefinitionStrategy param2RedefinitionStrategy) {
/* 12596 */         return materialize().with(param2RedefinitionStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.LambdaInstrumentationStrategy param2LambdaInstrumentationStrategy) {
/* 12603 */         return materialize().with(param2LambdaInstrumentationStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.DescriptionStrategy param2DescriptionStrategy) {
/* 12610 */         return materialize().with(param2DescriptionStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.FallbackStrategy param2FallbackStrategy) {
/* 12617 */         return materialize().with(param2FallbackStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.ClassFileBufferStrategy param2ClassFileBufferStrategy) {
/* 12624 */         return materialize().with(param2ClassFileBufferStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.InstallationListener param2InstallationListener) {
/* 12631 */         return materialize().with(param2InstallationListener);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.InjectionStrategy param2InjectionStrategy) {
/* 12638 */         return materialize().with(param2InjectionStrategy);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder with(AgentBuilder.TransformerDecorator param2TransformerDecorator) {
/* 12645 */         return materialize().with(param2TransformerDecorator);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder enableNativeMethodPrefix(String param2String) {
/* 12652 */         return materialize().enableNativeMethodPrefix(param2String);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder disableNativeMethodPrefix() {
/* 12659 */         return materialize().disableNativeMethodPrefix();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder disableClassFormatChanges() {
/* 12666 */         return materialize().disableClassFormatChanges();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder warmUp(Class<?>... param2VarArgs) {
/* 12673 */         return materialize().warmUp(param2VarArgs);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder warmUp(Collection<Class<?>> param2Collection) {
/* 12680 */         return materialize().warmUp(param2Collection);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder assureReadEdgeTo(Instrumentation param2Instrumentation, Class<?>... param2VarArgs) {
/* 12687 */         return materialize().assureReadEdgeTo(param2Instrumentation, param2VarArgs);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder assureReadEdgeTo(Instrumentation param2Instrumentation, JavaModule... param2VarArgs) {
/* 12694 */         return materialize().assureReadEdgeTo(param2Instrumentation, param2VarArgs);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder assureReadEdgeTo(Instrumentation param2Instrumentation, Collection<? extends JavaModule> param2Collection) {
/* 12701 */         return materialize().assureReadEdgeTo(param2Instrumentation, param2Collection);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder assureReadEdgeFromAndTo(Instrumentation param2Instrumentation, Class<?>... param2VarArgs) {
/* 12708 */         return materialize().assureReadEdgeFromAndTo(param2Instrumentation, param2VarArgs);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder assureReadEdgeFromAndTo(Instrumentation param2Instrumentation, JavaModule... param2VarArgs) {
/* 12715 */         return materialize().assureReadEdgeFromAndTo(param2Instrumentation, param2VarArgs);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder assureReadEdgeFromAndTo(Instrumentation param2Instrumentation, Collection<? extends JavaModule> param2Collection) {
/* 12722 */         return materialize().assureReadEdgeFromAndTo(param2Instrumentation, param2Collection);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Identified.Narrowable type(ElementMatcher<? super TypeDescription> param2ElementMatcher) {
/* 12729 */         return materialize().type(param2ElementMatcher);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Identified.Narrowable type(ElementMatcher<? super TypeDescription> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1) {
/* 12736 */         return materialize().type(param2ElementMatcher, param2ElementMatcher1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Identified.Narrowable type(ElementMatcher<? super TypeDescription> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1, ElementMatcher<? super JavaModule> param2ElementMatcher2) {
/* 12745 */         return materialize().type(param2ElementMatcher, param2ElementMatcher1, param2ElementMatcher2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Identified.Narrowable type(AgentBuilder.RawMatcher param2RawMatcher) {
/* 12752 */         return materialize().type(param2RawMatcher);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Ignored ignore(ElementMatcher<? super TypeDescription> param2ElementMatcher) {
/* 12759 */         return materialize().ignore(param2ElementMatcher);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Ignored ignore(ElementMatcher<? super TypeDescription> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1) {
/* 12766 */         return materialize().ignore(param2ElementMatcher, param2ElementMatcher1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Ignored ignore(ElementMatcher<? super TypeDescription> param2ElementMatcher, ElementMatcher<? super ClassLoader> param2ElementMatcher1, ElementMatcher<? super JavaModule> param2ElementMatcher2) {
/* 12775 */         return materialize().ignore(param2ElementMatcher, param2ElementMatcher1, param2ElementMatcher2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Ignored ignore(AgentBuilder.RawMatcher param2RawMatcher) {
/* 12782 */         return materialize().ignore(param2RawMatcher);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ClassFileTransformer makeRaw() {
/* 12789 */         return materialize().makeRaw();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ResettableClassFileTransformer installOn(Instrumentation param2Instrumentation) {
/* 12796 */         return materialize().installOn(param2Instrumentation);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ResettableClassFileTransformer installOnByteBuddyAgent() {
/* 12803 */         return materialize().installOnByteBuddyAgent();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ResettableClassFileTransformer patchOn(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/* 12810 */         return materialize().patchOn(param2Instrumentation, param2ResettableClassFileTransformer);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ResettableClassFileTransformer patchOn(Instrumentation param2Instrumentation, ResettableClassFileTransformer param2ResettableClassFileTransformer, AgentBuilder.PatchMode param2PatchMode) {
/* 12817 */         return materialize().patchOn(param2Instrumentation, param2ResettableClassFileTransformer, param2PatchMode);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer param2ResettableClassFileTransformer) {
/* 12824 */         return materialize().patchOnByteBuddyAgent(param2ResettableClassFileTransformer);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer param2ResettableClassFileTransformer, AgentBuilder.PatchMode param2PatchMode) {
/* 12831 */         return materialize().patchOnByteBuddyAgent(param2ResettableClassFileTransformer, param2PatchMode);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static abstract class Matchable<S extends AgentBuilder.Matchable<S>>
/*       */         extends Delegator
/*       */         implements AgentBuilder.Matchable<S>
/*       */       {
/*       */         public S and(ElementMatcher<? super TypeDescription> param3ElementMatcher) {
/* 12845 */           return and(param3ElementMatcher, (ElementMatcher<? super ClassLoader>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public S and(ElementMatcher<? super TypeDescription> param3ElementMatcher, ElementMatcher<? super ClassLoader> param3ElementMatcher1) {
/* 12852 */           return and(param3ElementMatcher, param3ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public S and(ElementMatcher<? super TypeDescription> param3ElementMatcher, ElementMatcher<? super ClassLoader> param3ElementMatcher1, ElementMatcher<? super JavaModule> param3ElementMatcher2) {
/* 12861 */           return and(new AgentBuilder.RawMatcher.ForElementMatchers(param3ElementMatcher, param3ElementMatcher1, param3ElementMatcher2));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public S or(ElementMatcher<? super TypeDescription> param3ElementMatcher) {
/* 12868 */           return or(param3ElementMatcher, (ElementMatcher<? super ClassLoader>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public S or(ElementMatcher<? super TypeDescription> param3ElementMatcher, ElementMatcher<? super ClassLoader> param3ElementMatcher1) {
/* 12875 */           return or(param3ElementMatcher, param3ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public S or(ElementMatcher<? super TypeDescription> param3ElementMatcher, ElementMatcher<? super ClassLoader> param3ElementMatcher1, ElementMatcher<? super JavaModule> param3ElementMatcher2) {
/* 12884 */           return or(new AgentBuilder.RawMatcher.ForElementMatchers(param3ElementMatcher, param3ElementMatcher1, param3ElementMatcher2));
/*       */         }
/*       */       } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance(includeSyntheticFields = true)
/*       */     protected class Ignoring
/*       */       extends Delegator.Matchable<AgentBuilder.Ignored>
/*       */       implements AgentBuilder.Ignored
/*       */     {
/*       */       private final AgentBuilder.RawMatcher rawMatcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Ignoring(AgentBuilder.Default this$0, AgentBuilder.RawMatcher param2RawMatcher) {
/* 12906 */         this.rawMatcher = param2RawMatcher;
/*       */       }
/*       */ 
/*       */       
/*       */       protected AgentBuilder materialize() {
/* 12911 */         return new AgentBuilder.Default(this.a.byteBuddy, this.a.listener, this.a.circularityLock, this.a.poolStrategy, this.a.typeStrategy, this.a.locationStrategy, this.a.nativeMethodStrategy, this.a.warmupStrategy, this.a.transformerDecorator, this.a.initializationStrategy, this.a.redefinitionStrategy, this.a.redefinitionDiscoveryStrategy, this.a.redefinitionBatchAllocator, this.a.redefinitionListener, this.a.redefinitionResubmissionStrategy, this.a.injectionStrategy, this.a.lambdaInstrumentationStrategy, this.a.descriptionStrategy, this.a.fallbackStrategy, this.a.classFileBufferStrategy, this.a.installationListener, this.rawMatcher, this.a.transformations);
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
/*       */       public AgentBuilder.Ignored and(AgentBuilder.RawMatcher param2RawMatcher) {
/* 12940 */         return new Ignoring(this.a, new AgentBuilder.RawMatcher.Conjunction(new AgentBuilder.RawMatcher[] { this.rawMatcher, param2RawMatcher }));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Ignored or(AgentBuilder.RawMatcher param2RawMatcher) {
/* 12947 */         return new Ignoring(this.a, new AgentBuilder.RawMatcher.Disjunction(new AgentBuilder.RawMatcher[] { this.rawMatcher, param2RawMatcher }));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.rawMatcher.equals(((Ignoring)param2Object).rawMatcher) ? false : (!!this.a.equals(((Ignoring)param2Object).a)))));
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return (getClass().hashCode() * 31 + this.rawMatcher.hashCode()) * 31 + this.a.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance(includeSyntheticFields = true)
/*       */     protected class Transforming
/*       */       extends Delegator.Matchable<AgentBuilder.Identified.Narrowable>
/*       */       implements AgentBuilder.Identified.Extendable, AgentBuilder.Identified.Narrowable
/*       */     {
/*       */       private final AgentBuilder.RawMatcher rawMatcher;
/*       */ 
/*       */       
/*       */       private final List<AgentBuilder.Transformer> transformers;
/*       */ 
/*       */       
/*       */       private final boolean terminal;
/*       */ 
/*       */ 
/*       */       
/*       */       protected Transforming(AgentBuilder.Default this$0, AgentBuilder.RawMatcher param2RawMatcher, List<AgentBuilder.Transformer> param2List, boolean param2Boolean) {
/* 12982 */         this.rawMatcher = param2RawMatcher;
/* 12983 */         this.transformers = param2List;
/* 12984 */         this.terminal = param2Boolean;
/*       */       }
/*       */ 
/*       */       
/*       */       protected AgentBuilder materialize() {
/* 12989 */         return new AgentBuilder.Default(this.a.byteBuddy, this.a.listener, this.a.circularityLock, this.a.poolStrategy, this.a.typeStrategy, this.a.locationStrategy, this.a.nativeMethodStrategy, this.a.warmupStrategy, this.a.transformerDecorator, this.a.initializationStrategy, this.a.redefinitionStrategy, this.a.redefinitionDiscoveryStrategy, this.a.redefinitionBatchAllocator, this.a.redefinitionListener, this.a.redefinitionResubmissionStrategy, this.a.injectionStrategy, this.a.lambdaInstrumentationStrategy, this.a.descriptionStrategy, this.a.fallbackStrategy, this.a.classFileBufferStrategy, this.a.installationListener, this.a.ignoreMatcher, 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/* 13011 */             CompoundList.of(this.a.transformations, new AgentBuilder.Default.Transformation(this.rawMatcher, this.transformers, this.terminal)));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Identified.Extendable transform(AgentBuilder.Transformer param2Transformer) {
/* 13018 */         return new Transforming(this.a, this.rawMatcher, CompoundList.of(this.transformers, param2Transformer), this.terminal);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder asTerminalTransformation() {
/* 13025 */         return new Transforming(this.a, this.rawMatcher, this.transformers, true);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Identified.Narrowable and(AgentBuilder.RawMatcher param2RawMatcher) {
/* 13032 */         return new Transforming(this.a, new AgentBuilder.RawMatcher.Conjunction(new AgentBuilder.RawMatcher[] { this.rawMatcher, param2RawMatcher }, ), this.transformers, this.terminal);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.Identified.Narrowable or(AgentBuilder.RawMatcher param2RawMatcher) {
/* 13039 */         return new Transforming(this.a, new AgentBuilder.RawMatcher.Disjunction(new AgentBuilder.RawMatcher[] { this.rawMatcher, param2RawMatcher }, ), this.transformers, this.terminal);
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
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.terminal != ((Transforming)param2Object).terminal) ? false : (!this.rawMatcher.equals(((Transforming)param2Object).rawMatcher) ? false : (!this.transformers.equals(((Transforming)param2Object).transformers) ? false : (!!this.a.equals(((Transforming)param2Object).a)))))));
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
/*       */       public int hashCode() {
/*       */         return (((getClass().hashCode() * 31 + this.rawMatcher.hashCode()) * 31 + this.transformers.hashCode()) * 31 + this.terminal) * 31 + this.a.hashCode();
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
/*       */     protected static class Redefining
/*       */       extends Default
/*       */       implements AgentBuilder.RedefinitionListenable.WithoutBatchStrategy
/*       */     {
/*       */       protected Redefining(ByteBuddy param2ByteBuddy, AgentBuilder.Listener param2Listener, AgentBuilder.CircularityLock param2CircularityLock, AgentBuilder.PoolStrategy param2PoolStrategy, AgentBuilder.TypeStrategy param2TypeStrategy, AgentBuilder.LocationStrategy param2LocationStrategy, AgentBuilder.Default.NativeMethodStrategy param2NativeMethodStrategy, AgentBuilder.Default.WarmupStrategy param2WarmupStrategy, AgentBuilder.TransformerDecorator param2TransformerDecorator, AgentBuilder.InitializationStrategy param2InitializationStrategy, AgentBuilder.RedefinitionStrategy param2RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param2DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param2BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param2Listener1, AgentBuilder.RedefinitionStrategy.ResubmissionStrategy param2ResubmissionStrategy, AgentBuilder.InjectionStrategy param2InjectionStrategy, AgentBuilder.LambdaInstrumentationStrategy param2LambdaInstrumentationStrategy, AgentBuilder.DescriptionStrategy param2DescriptionStrategy, AgentBuilder.FallbackStrategy param2FallbackStrategy, AgentBuilder.ClassFileBufferStrategy param2ClassFileBufferStrategy, AgentBuilder.InstallationListener param2InstallationListener, AgentBuilder.RawMatcher param2RawMatcher, List<AgentBuilder.Default.Transformation> param2List) {
/* 13099 */         super(param2ByteBuddy, param2Listener, param2CircularityLock, param2PoolStrategy, param2TypeStrategy, param2LocationStrategy, param2NativeMethodStrategy, param2WarmupStrategy, param2TransformerDecorator, param2InitializationStrategy, param2RedefinitionStrategy, param2DiscoveryStrategy, param2BatchAllocator, param2Listener1, param2ResubmissionStrategy, param2InjectionStrategy, param2LambdaInstrumentationStrategy, param2DescriptionStrategy, param2FallbackStrategy, param2ClassFileBufferStrategy, param2InstallationListener, param2RawMatcher, param2List);
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
/*       */       public AgentBuilder.RedefinitionListenable.WithImplicitDiscoveryStrategy with(AgentBuilder.RedefinitionStrategy.BatchAllocator param2BatchAllocator) {
/* 13128 */         if (!this.redefinitionStrategy.isEnabled()) {
/* 13129 */           throw new IllegalStateException("Cannot set redefinition batch allocator when redefinition is disabled");
/*       */         }
/* 13131 */         return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, param2BatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */       public AgentBuilder.RedefinitionListenable redefineOnly(Class<?>... param2VarArgs) {
/* 13160 */         return with(new AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AgentBuilder.RedefinitionListenable with(AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param2DiscoveryStrategy) {
/* 13167 */         if (!this.redefinitionStrategy.isEnabled()) {
/* 13168 */           throw new IllegalStateException("Cannot set redefinition discovery strategy when redefinition is disabled");
/*       */         }
/* 13170 */         return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, param2DiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */       public AgentBuilder.RedefinitionListenable with(AgentBuilder.RedefinitionStrategy.Listener param2Listener) {
/* 13199 */         if (!this.redefinitionStrategy.isEnabled()) {
/* 13200 */           throw new IllegalStateException("Cannot set redefinition listener when redefinition is disabled");
/*       */         }
/* 13202 */         return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, new AgentBuilder.RedefinitionStrategy.Listener.Compound(new AgentBuilder.RedefinitionStrategy.Listener[] { this.redefinitionListener, param2Listener }, ), this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
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
/*       */       public AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification withResubmission(AgentBuilder.RedefinitionStrategy.ResubmissionScheduler param2ResubmissionScheduler) {
/* 13231 */         if (!this.redefinitionStrategy.isEnabled()) {
/* 13232 */           throw new IllegalStateException("Cannot enable resubmission when redefinition is disabled");
/*       */         }
/* 13234 */         return new WithResubmission(this, param2ResubmissionScheduler, AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher.Trivial.NON_MATCHING, AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher.Trivial.NON_MATCHING);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected class WithResubmission
/*       */         extends AgentBuilder.Default.Delegator
/*       */         implements AgentBuilder.RedefinitionListenable.WithResubmissionSpecification
/*       */       {
/*       */         private final AgentBuilder.RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected WithResubmission(AgentBuilder.Default.Redefining this$0, AgentBuilder.RedefinitionStrategy.ResubmissionScheduler param3ResubmissionScheduler, AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher param3ResubmissionOnErrorMatcher, AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher param3ResubmissionImmediateMatcher) {
/* 13269 */           this.resubmissionScheduler = param3ResubmissionScheduler;
/* 13270 */           this.resubmissionOnErrorMatcher = param3ResubmissionOnErrorMatcher;
/* 13271 */           this.resubmissionImmediateMatcher = param3ResubmissionImmediateMatcher;
/*       */         }
/*       */ 
/*       */         
/*       */         protected AgentBuilder materialize() {
/* 13276 */           return new AgentBuilder.Default(this.a.byteBuddy, this.a.listener, this.a.circularityLock, this.a.poolStrategy, this.a.typeStrategy, this.a.locationStrategy, this.a.nativeMethodStrategy, this.a.warmupStrategy, this.a.transformerDecorator, this.a.initializationStrategy, this.a.redefinitionStrategy, this.a.redefinitionDiscoveryStrategy, this.a.redefinitionBatchAllocator, this.a.redefinitionListener, new AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled(this.resubmissionScheduler, this.resubmissionOnErrorMatcher, this.resubmissionImmediateMatcher), this.a.injectionStrategy, this.a.lambdaInstrumentationStrategy, this.a.descriptionStrategy, this.a.fallbackStrategy, this.a.classFileBufferStrategy, this.a.installationListener, this.a.ignoreMatcher, this.a.transformations);
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
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError() {
/* 13305 */           return resubmitOnError((ElementMatcher<? super Throwable>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param3ElementMatcher) {
/* 13312 */           return resubmitOnError(param3ElementMatcher, (ElementMatcher<String>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param3ElementMatcher, ElementMatcher<String> param3ElementMatcher1) {
/* 13320 */           return resubmitOnError(param3ElementMatcher, param3ElementMatcher1, (ElementMatcher<? super ClassLoader>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param3ElementMatcher, ElementMatcher<String> param3ElementMatcher1, ElementMatcher<? super ClassLoader> param3ElementMatcher2) {
/* 13329 */           return resubmitOnError(param3ElementMatcher, param3ElementMatcher1, param3ElementMatcher2, (ElementMatcher<? super JavaModule>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> param3ElementMatcher, ElementMatcher<String> param3ElementMatcher1, ElementMatcher<? super ClassLoader> param3ElementMatcher2, ElementMatcher<? super JavaModule> param3ElementMatcher3) {
/* 13339 */           return resubmitOnError(new AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher.ForElementMatchers(param3ElementMatcher, param3ElementMatcher1, param3ElementMatcher2, param3ElementMatcher3));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitOnError(AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher param3ResubmissionOnErrorMatcher) {
/* 13346 */           return new WithResubmission(this.a, this.resubmissionScheduler, new AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher.Disjunction(new AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher[] { this.resubmissionOnErrorMatcher, param3ResubmissionOnErrorMatcher }, ), this.resubmissionImmediateMatcher);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate() {
/* 13355 */           return resubmitImmediate((ElementMatcher<String>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> param3ElementMatcher) {
/* 13362 */           return resubmitImmediate(param3ElementMatcher, (ElementMatcher<? super ClassLoader>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> param3ElementMatcher, ElementMatcher<? super ClassLoader> param3ElementMatcher1) {
/* 13370 */           return resubmitImmediate(param3ElementMatcher, param3ElementMatcher1, (ElementMatcher<? super JavaModule>)ElementMatchers.any());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> param3ElementMatcher, ElementMatcher<? super ClassLoader> param3ElementMatcher1, ElementMatcher<? super JavaModule> param3ElementMatcher2) {
/* 13379 */           return resubmitImmediate(new AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher.ForElementMatchers(param3ElementMatcher, param3ElementMatcher1, param3ElementMatcher2));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AgentBuilder.RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher param3ResubmissionImmediateMatcher) {
/* 13386 */           return new WithResubmission(this.a, this.resubmissionScheduler, this.resubmissionOnErrorMatcher, new AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher.Disjunction(new AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher[] { this.resubmissionImmediateMatcher, param3ResubmissionImmediateMatcher }));
/*       */         }
/*       */       }
/*       */     }
/*       */     
/*       */     @Proxied("java.lang.instrument.Instrumentation")
/*       */     protected static interface Dispatcher {
/*       */       @Defaults
/*       */       @Proxied("isNativeMethodPrefixSupported")
/*       */       boolean isNativeMethodPrefixSupported(Instrumentation param2Instrumentation);
/*       */       
/*       */       @Proxied("setNativeMethodPrefix")
/*       */       void setNativeMethodPrefix(Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer, String param2String);
/*       */       
/*       */       @Proxied("addTransformer")
/*       */       void addTransformer(Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer, boolean param2Boolean);
/*       */     }
/*       */   }
/*       */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\agent\builder\AgentBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */