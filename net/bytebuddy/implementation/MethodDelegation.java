/*      */ package net.bytebuddy.implementation;
/*      */ 
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.scaffold.FieldLocator;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*      */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*      */ import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.Duplication;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public class MethodDelegation
/*      */   implements Implementation.Composable
/*      */ {
/*      */   private final ImplementationDelegate implementationDelegate;
/*      */   private final List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
/*      */   private final MethodDelegationBinder.AmbiguityResolver ambiguityResolver;
/*      */   private final MethodDelegationBinder.TerminationHandler terminationHandler;
/*      */   private final MethodDelegationBinder.BindingResolver bindingResolver;
/*      */   private final Assigner assigner;
/*      */   
/*      */   protected MethodDelegation(ImplementationDelegate paramImplementationDelegate, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> paramList, MethodDelegationBinder.AmbiguityResolver paramAmbiguityResolver, MethodDelegationBinder.BindingResolver paramBindingResolver) {
/*  230 */     this(paramImplementationDelegate, paramList, paramAmbiguityResolver, (MethodDelegationBinder.TerminationHandler)MethodDelegationBinder.TerminationHandler.Default.RETURNING, paramBindingResolver, Assigner.DEFAULT);
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
/*      */   private MethodDelegation(ImplementationDelegate paramImplementationDelegate, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> paramList, MethodDelegationBinder.AmbiguityResolver paramAmbiguityResolver, MethodDelegationBinder.TerminationHandler paramTerminationHandler, MethodDelegationBinder.BindingResolver paramBindingResolver, Assigner paramAssigner) {
/*  254 */     this.implementationDelegate = paramImplementationDelegate;
/*  255 */     this.parameterBinders = paramList;
/*  256 */     this.terminationHandler = paramTerminationHandler;
/*  257 */     this.ambiguityResolver = paramAmbiguityResolver;
/*  258 */     this.bindingResolver = paramBindingResolver;
/*  259 */     this.assigner = paramAssigner;
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
/*      */   public static MethodDelegation to(Class<?> paramClass) {
/*  273 */     return withDefaultConfiguration().to(paramClass);
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
/*      */   public static MethodDelegation to(TypeDescription paramTypeDescription) {
/*  287 */     return withDefaultConfiguration().to(paramTypeDescription);
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
/*      */   public static MethodDelegation to(Object paramObject) {
/*  301 */     return withDefaultConfiguration().to(paramObject);
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
/*      */   public static MethodDelegation to(Object paramObject, MethodGraph.Compiler paramCompiler) {
/*  316 */     return withDefaultConfiguration().to(paramObject, paramCompiler);
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
/*      */   public static MethodDelegation to(Object paramObject, String paramString) {
/*  331 */     return withDefaultConfiguration().to(paramObject, paramString);
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
/*      */   public static MethodDelegation to(Object paramObject, String paramString, MethodGraph.Compiler paramCompiler) {
/*  347 */     return withDefaultConfiguration().to(paramObject, paramString, paramCompiler);
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
/*      */   public static MethodDelegation to(Object paramObject, Type paramType) {
/*  362 */     return withDefaultConfiguration().to(paramObject, paramType);
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
/*      */   public static MethodDelegation to(Object paramObject, Type paramType, MethodGraph.Compiler paramCompiler) {
/*  378 */     return withDefaultConfiguration().to(paramObject, paramType, paramCompiler);
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
/*      */   public static MethodDelegation to(Object paramObject, Type paramType, String paramString) {
/*  394 */     return withDefaultConfiguration().to(paramObject, paramType, paramString);
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
/*      */   public static MethodDelegation to(Object paramObject, Type paramType, String paramString, MethodGraph.Compiler paramCompiler) {
/*  411 */     return withDefaultConfiguration().to(paramObject, paramType, paramString, paramCompiler);
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
/*      */   public static MethodDelegation to(Object paramObject, TypeDefinition paramTypeDefinition) {
/*  426 */     return withDefaultConfiguration().to(paramObject, paramTypeDefinition);
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
/*      */   public static MethodDelegation to(Object paramObject, TypeDefinition paramTypeDefinition, MethodGraph.Compiler paramCompiler) {
/*  442 */     return withDefaultConfiguration().to(paramObject, paramTypeDefinition, paramCompiler);
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
/*      */   public static MethodDelegation to(Object paramObject, TypeDefinition paramTypeDefinition, String paramString) {
/*  458 */     return withDefaultConfiguration().to(paramObject, paramTypeDefinition, paramString);
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
/*      */   public static MethodDelegation to(Object paramObject, TypeDefinition paramTypeDefinition, String paramString, MethodGraph.Compiler paramCompiler) {
/*  475 */     return withDefaultConfiguration().to(paramObject, paramTypeDefinition, paramString, paramCompiler);
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
/*      */   public static MethodDelegation toConstructor(Class<?> paramClass) {
/*  489 */     return withDefaultConfiguration().toConstructor(paramClass);
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
/*      */   public static MethodDelegation toConstructor(TypeDescription paramTypeDescription) {
/*  503 */     return withDefaultConfiguration().toConstructor(paramTypeDescription);
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
/*      */   public static MethodDelegation toField(String paramString) {
/*  517 */     return withDefaultConfiguration().toField(paramString);
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
/*      */   public static MethodDelegation toField(String paramString, FieldLocator.Factory paramFactory) {
/*  532 */     return withDefaultConfiguration().toField(paramString, paramFactory);
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
/*      */   public static MethodDelegation toField(String paramString, MethodGraph.Compiler paramCompiler) {
/*  547 */     return withDefaultConfiguration().toField(paramString, paramCompiler);
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
/*      */   public static MethodDelegation toField(String paramString, FieldLocator.Factory paramFactory, MethodGraph.Compiler paramCompiler) {
/*  563 */     return withDefaultConfiguration().toField(paramString, paramFactory, paramCompiler);
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
/*      */   public static MethodDelegation toMethodReturnOf(String paramString) {
/*  577 */     return withDefaultConfiguration().toMethodReturnOf(paramString);
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
/*      */   public static MethodDelegation toMethodReturnOf(String paramString, MethodGraph.Compiler paramCompiler) {
/*  592 */     return withDefaultConfiguration().toMethodReturnOf(paramString, paramCompiler);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WithCustomProperties withDefaultConfiguration() {
/*  603 */     return new WithCustomProperties(MethodDelegationBinder.AmbiguityResolver.DEFAULT, TargetMethodAnnotationDrivenBinder.ParameterBinder.DEFAULTS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WithCustomProperties withEmptyConfiguration() {
/*  614 */     return new WithCustomProperties((MethodDelegationBinder.AmbiguityResolver)MethodDelegationBinder.AmbiguityResolver.NoOp.INSTANCE, Collections.emptyList());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Implementation.Composable withAssigner(Assigner paramAssigner) {
/*  624 */     return new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, this.terminationHandler, this.bindingResolver, paramAssigner);
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
/*  636 */     return new Implementation.Compound(new Implementation[] { new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, (MethodDelegationBinder.TerminationHandler)MethodDelegationBinder.TerminationHandler.Default.DROPPING, this.bindingResolver, this.assigner), paramImplementation });
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
/*      */   public Implementation.Composable andThen(Implementation.Composable paramComposable) {
/*  648 */     return new Implementation.Compound.Composable(new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, (MethodDelegationBinder.TerminationHandler)MethodDelegationBinder.TerminationHandler.Default.DROPPING, this.bindingResolver, this.assigner), paramComposable);
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
/*      */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/*  660 */     return this.implementationDelegate.prepare(paramInstrumentedType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteCodeAppender appender(Implementation.Target paramTarget) {
/*  667 */     ImplementationDelegate.Compiled compiled = this.implementationDelegate.compile(paramTarget.getInstrumentedType());
/*  668 */     return new Appender(paramTarget, (MethodDelegationBinder.Record)new MethodDelegationBinder.Processor(compiled
/*  669 */           .getRecords(), this.ambiguityResolver, this.bindingResolver), this.terminationHandler, this.assigner, compiled);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.implementationDelegate.equals(((MethodDelegation)paramObject).implementationDelegate) ? false : (!this.parameterBinders.equals(((MethodDelegation)paramObject).parameterBinders) ? false : (!this.ambiguityResolver.equals(((MethodDelegation)paramObject).ambiguityResolver) ? false : (!this.terminationHandler.equals(((MethodDelegation)paramObject).terminationHandler) ? false : (!this.bindingResolver.equals(((MethodDelegation)paramObject).bindingResolver) ? false : (!!this.assigner.equals(((MethodDelegation)paramObject).assigner)))))))));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*      */     return (((((getClass().hashCode() * 31 + this.implementationDelegate.hashCode()) * 31 + this.parameterBinders.hashCode()) * 31 + this.ambiguityResolver.hashCode()) * 31 + this.terminationHandler.hashCode()) * 31 + this.bindingResolver.hashCode()) * 31 + this.assigner.hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Compiled
/*      */   {
/*      */     StackManipulation prepare(MethodDescription param1MethodDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodDelegationBinder.MethodInvoker invoke();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     List<MethodDelegationBinder.Record> getRecords();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForStaticCall
/*      */       implements Compiled
/*      */     {
/*      */       private final List<MethodDelegationBinder.Record> records;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForStaticCall(List<MethodDelegationBinder.Record> param3List) {
/*  737 */         this.records = param3List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation prepare(MethodDescription param3MethodDescription) {
/*  744 */         return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegationBinder.MethodInvoker invoke() {
/*  751 */         return (MethodDelegationBinder.MethodInvoker)MethodDelegationBinder.MethodInvoker.Simple.INSTANCE;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodDelegationBinder.Record> getRecords() {
/*  758 */         return this.records;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.records.equals(((ForStaticCall)param3Object).records))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.records.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForField
/*      */       implements Compiled
/*      */     {
/*      */       private final FieldDescription fieldDescription;
/*      */       
/*      */       private final List<MethodDelegationBinder.Record> records;
/*      */ 
/*      */       
/*      */       protected ForField(FieldDescription param3FieldDescription, List<MethodDelegationBinder.Record> param3List) {
/*  785 */         this.fieldDescription = param3FieldDescription;
/*  786 */         this.records = param3List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation prepare(MethodDescription param3MethodDescription) {
/*  793 */         if (param3MethodDescription.isStatic() && !this.fieldDescription.isStatic()) {
/*  794 */           throw new IllegalStateException("Cannot read " + this.fieldDescription + " from " + param3MethodDescription);
/*      */         }
/*  796 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*      */               
/*  798 */               MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read() });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegationBinder.MethodInvoker invoke() {
/*  805 */         return (MethodDelegationBinder.MethodInvoker)new MethodDelegationBinder.MethodInvoker.Virtual(this.fieldDescription.getType().asErasure());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodDelegationBinder.Record> getRecords() {
/*  812 */         return this.records;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fieldDescription.equals(((ForField)param3Object).fieldDescription) ? false : (!!this.records.equals(((ForField)param3Object).records)))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.records.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForMethodReturn
/*      */       implements Compiled
/*      */     {
/*      */       private final MethodDescription methodDescription;
/*      */       
/*      */       private final List<MethodDelegationBinder.Record> records;
/*      */ 
/*      */       
/*      */       protected ForMethodReturn(MethodDescription param3MethodDescription, List<MethodDelegationBinder.Record> param3List) {
/*  839 */         this.methodDescription = param3MethodDescription;
/*  840 */         this.records = param3List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation prepare(MethodDescription param3MethodDescription) {
/*  847 */         if (param3MethodDescription.isStatic() && !this.methodDescription.isStatic()) {
/*  848 */           throw new IllegalStateException("Cannot invoke " + this.methodDescription + " from " + param3MethodDescription);
/*      */         }
/*  850 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.methodDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*      */               
/*  852 */               MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(this.methodDescription) });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegationBinder.MethodInvoker invoke() {
/*  859 */         return (MethodDelegationBinder.MethodInvoker)new MethodDelegationBinder.MethodInvoker.Virtual(this.methodDescription.getReturnType().asErasure());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<MethodDelegationBinder.Record> getRecords() {
/*  866 */         return this.records;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.methodDescription.equals(((ForMethodReturn)param3Object).methodDescription) ? false : (!!this.records.equals(((ForMethodReturn)param3Object).records)))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.records.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForConstruction
/*      */       implements Compiled
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */       
/*      */       private final List<MethodDelegationBinder.Record> records;
/*      */ 
/*      */       
/*      */       protected ForConstruction(TypeDescription param3TypeDescription, List<MethodDelegationBinder.Record> param3List) {
/*  893 */         this.typeDescription = param3TypeDescription;
/*  894 */         this.records = param3List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation prepare(MethodDescription param3MethodDescription) {
/*  901 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(this.typeDescription), (StackManipulation)Duplication.SINGLE });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegationBinder.MethodInvoker invoke() {
/*  908 */         return (MethodDelegationBinder.MethodInvoker)MethodDelegationBinder.MethodInvoker.Simple.INSTANCE;
/*      */       }
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typeDescription.equals(((ForConstruction)param3Object).typeDescription) ? false : (!!this.records.equals(((ForConstruction)param3Object).records)))));
/*      */       } public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.records.hashCode();
/*      */       }
/*  915 */       public List<MethodDelegationBinder.Record> getRecords() { return this.records; } } } protected static interface ImplementationDelegate extends InstrumentedType.Prepareable { public static final String FIELD_NAME_PREFIX = "delegate"; Compiled compile(TypeDescription param1TypeDescription); public static interface Compiled { StackManipulation prepare(MethodDescription param2MethodDescription); MethodDelegationBinder.MethodInvoker invoke(); List<MethodDelegationBinder.Record> getRecords(); @Enhance public static class ForStaticCall implements Compiled { private final List<MethodDelegationBinder.Record> records; protected ForStaticCall(List<MethodDelegationBinder.Record> param3List) { this.records = param3List; } public StackManipulation prepare(MethodDescription param3MethodDescription) { return (StackManipulation)StackManipulation.Trivial.INSTANCE; } public MethodDelegationBinder.MethodInvoker invoke() { return (MethodDelegationBinder.MethodInvoker)MethodDelegationBinder.MethodInvoker.Simple.INSTANCE; } public List<MethodDelegationBinder.Record> getRecords() { return this.records; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.records.equals(((ForStaticCall)param3Object).records)))); } public int hashCode() { return getClass().hashCode() * 31 + this.records.hashCode(); } } @Enhance public static class ForField implements Compiled { private final FieldDescription fieldDescription; private final List<MethodDelegationBinder.Record> records; protected ForField(FieldDescription param3FieldDescription, List<MethodDelegationBinder.Record> param3List) { this.fieldDescription = param3FieldDescription; this.records = param3List; } public StackManipulation prepare(MethodDescription param3MethodDescription) { if (param3MethodDescription.isStatic() && !this.fieldDescription.isStatic()) throw new IllegalStateException("Cannot read " + this.fieldDescription + " from " + param3MethodDescription);  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read() }); } public MethodDelegationBinder.MethodInvoker invoke() { return (MethodDelegationBinder.MethodInvoker)new MethodDelegationBinder.MethodInvoker.Virtual(this.fieldDescription.getType().asErasure()); } public List<MethodDelegationBinder.Record> getRecords() { return this.records; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fieldDescription.equals(((ForField)param3Object).fieldDescription) ? false : (!!this.records.equals(((ForField)param3Object).records))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.records.hashCode(); } } @Enhance public static class ForMethodReturn implements Compiled { private final MethodDescription methodDescription; private final List<MethodDelegationBinder.Record> records; protected ForMethodReturn(MethodDescription param3MethodDescription, List<MethodDelegationBinder.Record> param3List) { this.methodDescription = param3MethodDescription; this.records = param3List; } public StackManipulation prepare(MethodDescription param3MethodDescription) { if (param3MethodDescription.isStatic() && !this.methodDescription.isStatic()) throw new IllegalStateException("Cannot invoke " + this.methodDescription + " from " + param3MethodDescription);  return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.methodDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(this.methodDescription) }); } public MethodDelegationBinder.MethodInvoker invoke() { return (MethodDelegationBinder.MethodInvoker)new MethodDelegationBinder.MethodInvoker.Virtual(this.methodDescription.getReturnType().asErasure()); } public List<MethodDelegationBinder.Record> getRecords() { return this.records; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.methodDescription.equals(((ForMethodReturn)param3Object).methodDescription) ? false : (!!this.records.equals(((ForMethodReturn)param3Object).records))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.records.hashCode(); } } @Enhance public static class ForConstruction implements Compiled { private final TypeDescription typeDescription; private final List<MethodDelegationBinder.Record> records; public List<MethodDelegationBinder.Record> getRecords() { return this.records; }
/*      */         
/*      */         protected ForConstruction(TypeDescription param3TypeDescription, List<MethodDelegationBinder.Record> param3List) {
/*      */           this.typeDescription = param3TypeDescription;
/*      */           this.records = param3List;
/*      */         }
/*      */         public StackManipulation prepare(MethodDescription param3MethodDescription) {
/*      */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { TypeCreation.of(this.typeDescription), (StackManipulation)Duplication.SINGLE });
/*      */         }
/*      */         public MethodDelegationBinder.MethodInvoker invoke() {
/*      */           return (MethodDelegationBinder.MethodInvoker)MethodDelegationBinder.MethodInvoker.Simple.INSTANCE;
/*      */         }
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typeDescription.equals(((ForConstruction)param3Object).typeDescription) ? false : (!!this.records.equals(((ForConstruction)param3Object).records)))));
/*      */         }
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.records.hashCode();
/*      */         } } }
/*      */     @Enhance
/*      */     public static class ForStaticMethod implements ImplementationDelegate { private final List<MethodDelegationBinder.Record> records;
/*      */       
/*      */       protected ForStaticMethod(List<MethodDelegationBinder.Record> param2List) {
/*  937 */         this.records = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static MethodDelegation.ImplementationDelegate of(MethodList<?> param2MethodList, MethodDelegationBinder param2MethodDelegationBinder) {
/*  948 */         ArrayList<MethodDelegationBinder.Record> arrayList = new ArrayList(param2MethodList.size());
/*  949 */         for (MethodDescription methodDescription : param2MethodList) {
/*  950 */           arrayList.add(param2MethodDelegationBinder.compile(methodDescription));
/*      */         }
/*  952 */         return new ForStaticMethod(arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  959 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegation.ImplementationDelegate.Compiled compile(TypeDescription param2TypeDescription) {
/*  966 */         return new MethodDelegation.ImplementationDelegate.Compiled.ForStaticCall(this.records);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.records.equals(((ForStaticMethod)param2Object).records))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.records.hashCode();
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static abstract class ForField
/*      */       implements ImplementationDelegate
/*      */     {
/*      */       protected final String fieldName;
/*      */ 
/*      */ 
/*      */       
/*      */       protected final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */ 
/*      */       
/*      */       protected final List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
/*      */ 
/*      */ 
/*      */       
/*      */       protected final ElementMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForField(String param2String, MethodGraph.Compiler param2Compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param2List, ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/* 1008 */         this.fieldName = param2String;
/* 1009 */         this.methodGraphCompiler = param2Compiler;
/* 1010 */         this.parameterBinders = param2List;
/* 1011 */         this.matcher = param2ElementMatcher;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegation.ImplementationDelegate.Compiled compile(TypeDescription param2TypeDescription) {
/*      */         FieldDescription fieldDescription;
/* 1019 */         if (!(fieldDescription = resolve(param2TypeDescription)).getType().asErasure().isVisibleTo(param2TypeDescription)) {
/* 1020 */           throw new IllegalStateException(fieldDescription + " is not visible to " + param2TypeDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1025 */         MethodList methodList = (MethodList)this.methodGraphCompiler.compile((TypeDefinition)fieldDescription.getType(), param2TypeDescription).listNodes().asMethodList().filter(this.matcher);
/* 1026 */         ArrayList<MethodDelegationBinder.Record> arrayList = new ArrayList(methodList.size());
/* 1027 */         MethodDelegationBinder methodDelegationBinder = TargetMethodAnnotationDrivenBinder.of(this.parameterBinders);
/* 1028 */         for (MethodDescription methodDescription : methodList) {
/* 1029 */           arrayList.add(methodDelegationBinder.compile(methodDescription));
/*      */         }
/* 1031 */         return new MethodDelegation.ImplementationDelegate.Compiled.ForField(fieldDescription, arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected abstract FieldDescription resolve(TypeDescription param2TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldName.equals(((ForField)param2Object).fieldName) ? false : (!this.methodGraphCompiler.equals(((ForField)param2Object).methodGraphCompiler) ? false : (!this.parameterBinders.equals(((ForField)param2Object).parameterBinders) ? false : (!!this.matcher.equals(((ForField)param2Object).matcher)))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (((getClass().hashCode() * 31 + this.fieldName.hashCode()) * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.parameterBinders.hashCode()) * 31 + this.matcher.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class WithInstance
/*      */         extends ForField
/*      */       {
/*      */         private final Object target;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription.Generic fieldType;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected WithInstance(String param3String, MethodGraph.Compiler param3Compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param3List, ElementMatcher<? super MethodDescription> param3ElementMatcher, Object param3Object, TypeDescription.Generic param3Generic) {
/* 1075 */           super(param3String, param3Compiler, param3List, param3ElementMatcher);
/* 1076 */           this.target = param3Object;
/* 1077 */           this.fieldType = param3Generic;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1084 */           return param3InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.fieldName, 4169, this.fieldType), this.target);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected FieldDescription resolve(TypeDescription param3TypeDescription) {
/* 1091 */           if (!this.fieldType.asErasure().isVisibleTo(param3TypeDescription)) {
/* 1092 */             throw new IllegalStateException(this.fieldType + " is not visible to " + param3TypeDescription);
/*      */           }
/* 1094 */           return (FieldDescription)((FieldList)param3TypeDescription.getDeclaredFields()
/* 1095 */             .filter((ElementMatcher)ElementMatchers.named(this.fieldName).and((ElementMatcher)ElementMatchers.fieldType(this.fieldType.asErasure()))))
/* 1096 */             .getOnly();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.target.equals(((WithInstance)param3Object).target) ? false : (!!this.fieldType.equals(((WithInstance)param3Object).fieldType))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (super.hashCode() * 31 + this.target.hashCode()) * 31 + this.fieldType.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class WithLookup
/*      */         extends ForField
/*      */       {
/*      */         private final FieldLocator.Factory fieldLocatorFactory;
/*      */ 
/*      */ 
/*      */         
/*      */         protected WithLookup(String param3String, MethodGraph.Compiler param3Compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param3List, ElementMatcher<? super MethodDescription> param3ElementMatcher, FieldLocator.Factory param3Factory) {
/* 1126 */           super(param3String, param3Compiler, param3List, param3ElementMatcher);
/* 1127 */           this.fieldLocatorFactory = param3Factory;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 1134 */           return param3InstrumentedType;
/*      */         }
/*      */ 
/*      */         
/*      */         protected FieldDescription resolve(TypeDescription param3TypeDescription) {
/*      */           FieldLocator.Resolution resolution;
/* 1140 */           if (!(resolution = this.fieldLocatorFactory.make(param3TypeDescription).locate(this.fieldName)).isResolved()) {
/* 1141 */             throw new IllegalStateException("Could not locate " + this.fieldName + " on " + param3TypeDescription);
/*      */           }
/* 1143 */           return resolution.getField();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldLocatorFactory.equals(((WithLookup)param3Object).fieldLocatorFactory)))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return super.hashCode() * 31 + this.fieldLocatorFactory.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForMethodReturn
/*      */       implements ImplementationDelegate
/*      */     {
/*      */       private final String name;
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
/*      */ 
/*      */ 
/*      */       
/*      */       private final ElementMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForMethodReturn(String param2String, MethodGraph.Compiler param2Compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param2List, ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/* 1187 */         this.name = param2String;
/* 1188 */         this.methodGraphCompiler = param2Compiler;
/* 1189 */         this.parameterBinders = param2List;
/* 1190 */         this.matcher = param2ElementMatcher;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegation.ImplementationDelegate.Compiled compile(TypeDescription param2TypeDescription) {
/*      */         MethodList methodList2;
/* 1201 */         if ((methodList2 = (MethodList)(new MethodList.Explicit(CompoundList.of((List)param2TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isStatic().or((ElementMatcher)ElementMatchers.isPrivate())), (List)this.methodGraphCompiler.compile((TypeDefinition)param2TypeDescription).listNodes().asMethodList()))).filter((ElementMatcher)ElementMatchers.named(this.name).and((ElementMatcher)ElementMatchers.takesArguments(0)).and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.returns((ElementMatcher)ElementMatchers.isPrimitive().or((ElementMatcher)ElementMatchers.isArray())))))).size() != 1)
/* 1202 */           throw new IllegalStateException(param2TypeDescription + " does not define method without arguments with name " + this.name + ": " + methodList2); 
/* 1203 */         if (!((MethodDescription)methodList2.getOnly()).getReturnType().asErasure().isVisibleTo(param2TypeDescription)) {
/* 1204 */           throw new IllegalStateException(methodList2.getOnly() + " is not visible to " + param2TypeDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1209 */         MethodList methodList1 = (MethodList)this.methodGraphCompiler.compile((TypeDefinition)((MethodDescription)methodList2.getOnly()).getReturnType(), param2TypeDescription).listNodes().asMethodList().filter(this.matcher);
/* 1210 */         ArrayList<MethodDelegationBinder.Record> arrayList = new ArrayList(methodList1.size());
/* 1211 */         MethodDelegationBinder methodDelegationBinder = TargetMethodAnnotationDrivenBinder.of(this.parameterBinders);
/* 1212 */         for (MethodDescription methodDescription : methodList1) {
/* 1213 */           arrayList.add(methodDelegationBinder.compile(methodDescription));
/*      */         }
/* 1215 */         return new MethodDelegation.ImplementationDelegate.Compiled.ForMethodReturn((MethodDescription)methodList2.get(0), arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1223 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.name.equals(((ForMethodReturn)param2Object).name) ? false : (!this.methodGraphCompiler.equals(((ForMethodReturn)param2Object).methodGraphCompiler) ? false : (!this.parameterBinders.equals(((ForMethodReturn)param2Object).parameterBinders) ? false : (!!this.matcher.equals(((ForMethodReturn)param2Object).matcher)))))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.parameterBinders.hashCode()) * 31 + this.matcher.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForConstruction
/*      */       implements ImplementationDelegate
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */       
/*      */       private final List<MethodDelegationBinder.Record> records;
/*      */ 
/*      */       
/*      */       protected ForConstruction(TypeDescription param2TypeDescription, List<MethodDelegationBinder.Record> param2List) {
/* 1250 */         this.typeDescription = param2TypeDescription;
/* 1251 */         this.records = param2List;
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
/*      */       protected static MethodDelegation.ImplementationDelegate of(TypeDescription param2TypeDescription, MethodList<?> param2MethodList, MethodDelegationBinder param2MethodDelegationBinder) {
/* 1265 */         ArrayList<MethodDelegationBinder.Record> arrayList = new ArrayList(param2MethodList.size());
/* 1266 */         for (MethodDescription methodDescription : param2MethodList) {
/* 1267 */           arrayList.add(param2MethodDelegationBinder.compile(methodDescription));
/*      */         }
/* 1269 */         return new ForConstruction(param2TypeDescription, arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1276 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegation.ImplementationDelegate.Compiled compile(TypeDescription param2TypeDescription) {
/* 1283 */         return new MethodDelegation.ImplementationDelegate.Compiled.ForConstruction(this.typeDescription, this.records);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typeDescription.equals(((ForConstruction)param2Object).typeDescription) ? false : (!!this.records.equals(((ForConstruction)param2Object).records)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.records.hashCode();
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class Appender
/*      */     implements ByteCodeAppender
/*      */   {
/*      */     private final Implementation.Target implementationTarget;
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDelegationBinder.Record processor;
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDelegationBinder.TerminationHandler terminationHandler;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Assigner assigner;
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDelegation.ImplementationDelegate.Compiled compiled;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Appender(Implementation.Target param1Target, MethodDelegationBinder.Record param1Record, MethodDelegationBinder.TerminationHandler param1TerminationHandler, Assigner param1Assigner, MethodDelegation.ImplementationDelegate.Compiled param1Compiled) {
/* 1333 */       this.implementationTarget = param1Target;
/* 1334 */       this.processor = param1Record;
/* 1335 */       this.terminationHandler = param1TerminationHandler;
/* 1336 */       this.assigner = param1Assigner;
/* 1337 */       this.compiled = param1Compiled;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 1347 */       StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { this.compiled.prepare(param1MethodDescription), (StackManipulation)this.processor.bind(this.implementationTarget, param1MethodDescription, this.terminationHandler, this.compiled.invoke(), this.assigner) })).apply(param1MethodVisitor, param1Context);
/* 1348 */       return new ByteCodeAppender.Size(size.getMaximalSize(), param1MethodDescription.getStackSize());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.implementationTarget.equals(((Appender)param1Object).implementationTarget) ? false : (!this.processor.equals(((Appender)param1Object).processor) ? false : (!this.terminationHandler.equals(((Appender)param1Object).terminationHandler) ? false : (!this.assigner.equals(((Appender)param1Object).assigner) ? false : (!!this.compiled.equals(((Appender)param1Object).compiled))))))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return ((((getClass().hashCode() * 31 + this.implementationTarget.hashCode()) * 31 + this.processor.hashCode()) * 31 + this.terminationHandler.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.compiled.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class WithCustomProperties
/*      */   {
/*      */     private final MethodDelegationBinder.AmbiguityResolver ambiguityResolver;
/*      */ 
/*      */     
/*      */     private final List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
/*      */ 
/*      */     
/*      */     private final MethodDelegationBinder.BindingResolver bindingResolver;
/*      */ 
/*      */     
/*      */     private final ElementMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */ 
/*      */     
/*      */     protected WithCustomProperties(MethodDelegationBinder.AmbiguityResolver param1AmbiguityResolver, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param1List) {
/* 1386 */       this(param1AmbiguityResolver, param1List, (MethodDelegationBinder.BindingResolver)MethodDelegationBinder.BindingResolver.Default.INSTANCE, (ElementMatcher<? super MethodDescription>)ElementMatchers.any());
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
/*      */     private WithCustomProperties(MethodDelegationBinder.AmbiguityResolver param1AmbiguityResolver, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param1List, MethodDelegationBinder.BindingResolver param1BindingResolver, ElementMatcher<? super MethodDescription> param1ElementMatcher) {
/* 1401 */       this.ambiguityResolver = param1AmbiguityResolver;
/* 1402 */       this.parameterBinders = param1List;
/* 1403 */       this.bindingResolver = param1BindingResolver;
/* 1404 */       this.matcher = param1ElementMatcher;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WithCustomProperties withResolvers(MethodDelegationBinder.AmbiguityResolver... param1VarArgs) {
/* 1415 */       return withResolvers(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WithCustomProperties withResolvers(List<? extends MethodDelegationBinder.AmbiguityResolver> param1List) {
/* 1426 */       return new WithCustomProperties((MethodDelegationBinder.AmbiguityResolver)new MethodDelegationBinder.AmbiguityResolver.Compound(CompoundList.of(this.ambiguityResolver, param1List)), this.parameterBinders, this.bindingResolver, this.matcher);
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
/*      */     public WithCustomProperties withBinders(TargetMethodAnnotationDrivenBinder.ParameterBinder<?>... param1VarArgs) {
/* 1438 */       return withBinders(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WithCustomProperties withBinders(List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param1List) {
/* 1449 */       return new WithCustomProperties(this.ambiguityResolver, CompoundList.of(this.parameterBinders, param1List), this.bindingResolver, this.matcher);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WithCustomProperties withBindingResolver(MethodDelegationBinder.BindingResolver param1BindingResolver) {
/* 1460 */       return new WithCustomProperties(this.ambiguityResolver, this.parameterBinders, param1BindingResolver, this.matcher);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WithCustomProperties filter(ElementMatcher<? super MethodDescription> param1ElementMatcher) {
/* 1471 */       return new WithCustomProperties(this.ambiguityResolver, this.parameterBinders, this.bindingResolver, (ElementMatcher<? super MethodDescription>)new ElementMatcher.Junction.Conjunction(new ElementMatcher[] { this.matcher, param1ElementMatcher }));
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
/*      */     public MethodDelegation to(Class<?> param1Class) {
/* 1488 */       return to(TypeDescription.ForLoadedType.of(param1Class));
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
/*      */     public MethodDelegation to(TypeDescription param1TypeDescription) {
/* 1502 */       if (param1TypeDescription.isArray())
/* 1503 */         throw new IllegalArgumentException("Cannot delegate to array " + param1TypeDescription); 
/* 1504 */       if (param1TypeDescription.isPrimitive()) {
/* 1505 */         throw new IllegalArgumentException("Cannot delegate to primitive " + param1TypeDescription);
/*      */       }
/* 1507 */       return new MethodDelegation(MethodDelegation.ImplementationDelegate.ForStaticMethod.of((MethodList)param1TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isStatic().and(this.matcher)), 
/* 1508 */             TargetMethodAnnotationDrivenBinder.of(this.parameterBinders)), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
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
/*      */     public MethodDelegation to(Object param1Object) {
/* 1522 */       return to(param1Object, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation to(Object param1Object, MethodGraph.Compiler param1Compiler) {
/* 1537 */       return to(param1Object, param1Object.getClass(), param1Compiler);
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
/*      */     public MethodDelegation to(Object param1Object, String param1String) {
/* 1552 */       return to(param1Object, param1String, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation to(Object param1Object, String param1String, MethodGraph.Compiler param1Compiler) {
/* 1568 */       return to(param1Object, param1Object.getClass(), param1String, param1Compiler);
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
/*      */     public MethodDelegation to(Object param1Object, Type param1Type) {
/* 1583 */       return to(param1Object, param1Type, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation to(Object param1Object, Type param1Type, MethodGraph.Compiler param1Compiler) {
/* 1599 */       return to(param1Object, param1Type, "delegate$" + 
/*      */           
/* 1601 */           RandomString.hashOf(param1Object), param1Compiler);
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
/*      */     public MethodDelegation to(Object param1Object, Type param1Type, String param1String) {
/* 1618 */       return to(param1Object, param1Type, param1String, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation to(Object param1Object, Type param1Type, String param1String, MethodGraph.Compiler param1Compiler) {
/* 1635 */       return to(param1Object, (TypeDefinition)TypeDefinition.Sort.describe(param1Type), param1String, param1Compiler);
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
/*      */     public MethodDelegation to(Object param1Object, TypeDefinition param1TypeDefinition) {
/* 1650 */       return to(param1Object, param1TypeDefinition, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation to(Object param1Object, TypeDefinition param1TypeDefinition, MethodGraph.Compiler param1Compiler) {
/* 1666 */       return to(param1Object, param1TypeDefinition, "delegate$" + 
/*      */           
/* 1668 */           RandomString.hashOf(param1Object), param1Compiler);
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
/*      */     public MethodDelegation to(Object param1Object, TypeDefinition param1TypeDefinition, String param1String) {
/* 1685 */       return to(param1Object, param1TypeDefinition, param1String, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation to(Object param1Object, TypeDefinition param1TypeDefinition, String param1String, MethodGraph.Compiler param1Compiler) {
/* 1702 */       if (!param1TypeDefinition.asErasure().isInstance(param1Object)) {
/* 1703 */         throw new IllegalArgumentException(param1Object + " is not an instance of " + param1TypeDefinition);
/*      */       }
/* 1705 */       return new MethodDelegation(new MethodDelegation.ImplementationDelegate.ForField.WithInstance(param1String, param1Compiler, this.parameterBinders, this.matcher, param1Object, param1TypeDefinition
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1710 */             .asGenericType()), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
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
/*      */     public MethodDelegation toConstructor(Class<?> param1Class) {
/* 1724 */       return toConstructor(TypeDescription.ForLoadedType.of(param1Class));
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
/*      */     public MethodDelegation toConstructor(TypeDescription param1TypeDescription) {
/* 1738 */       return new MethodDelegation(MethodDelegation.ImplementationDelegate.ForConstruction.of(param1TypeDescription, (MethodList)param1TypeDescription
/* 1739 */             .getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor().and(this.matcher)), 
/* 1740 */             TargetMethodAnnotationDrivenBinder.of(this.parameterBinders)), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
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
/*      */     public MethodDelegation toField(String param1String) {
/* 1754 */       return toField(param1String, (FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE);
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
/*      */     public MethodDelegation toField(String param1String, FieldLocator.Factory param1Factory) {
/* 1769 */       return toField(param1String, param1Factory, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation toField(String param1String, MethodGraph.Compiler param1Compiler) {
/* 1784 */       return toField(param1String, (FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE, param1Compiler);
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
/*      */     public MethodDelegation toField(String param1String, FieldLocator.Factory param1Factory, MethodGraph.Compiler param1Compiler) {
/* 1800 */       return new MethodDelegation(new MethodDelegation.ImplementationDelegate.ForField.WithLookup(param1String, param1Compiler, this.parameterBinders, this.matcher, param1Factory), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
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
/*      */     public MethodDelegation toMethodReturnOf(String param1String) {
/* 1818 */       return toMethodReturnOf(param1String, MethodGraph.Compiler.DEFAULT);
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
/*      */     public MethodDelegation toMethodReturnOf(String param1String, MethodGraph.Compiler param1Compiler) {
/* 1833 */       return new MethodDelegation(new MethodDelegation.ImplementationDelegate.ForMethodReturn(param1String, param1Compiler, this.parameterBinders, this.matcher), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.ambiguityResolver.equals(((WithCustomProperties)param1Object).ambiguityResolver) ? false : (!this.parameterBinders.equals(((WithCustomProperties)param1Object).parameterBinders) ? false : (!this.bindingResolver.equals(((WithCustomProperties)param1Object).bindingResolver) ? false : (!!this.matcher.equals(((WithCustomProperties)param1Object).matcher)))))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.ambiguityResolver.hashCode()) * 31 + this.parameterBinders.hashCode()) * 31 + this.bindingResolver.hashCode()) * 31 + this.matcher.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\MethodDelegation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */