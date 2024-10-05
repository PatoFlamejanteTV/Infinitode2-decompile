/*      */ package net.bytebuddy.implementation.bind;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.bind.annotation.BindingPriority;
/*      */ import net.bytebuddy.implementation.bytecode.Removal;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.utility.CompoundList;
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
/*      */ public interface MethodDelegationBinder
/*      */ {
/*      */   Record compile(MethodDescription paramMethodDescription);
/*      */   
/*      */   public static interface Record
/*      */   {
/*      */     MethodDelegationBinder.MethodBinding bind(Implementation.Target param1Target, MethodDescription param1MethodDescription, MethodDelegationBinder.TerminationHandler param1TerminationHandler, MethodDelegationBinder.MethodInvoker param1MethodInvoker, Assigner param1Assigner);
/*      */     
/*      */     public enum Illegal
/*      */       implements Record
/*      */     {
/*   84 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDelegationBinder.MethodBinding bind(Implementation.Target param2Target, MethodDescription param2MethodDescription, MethodDelegationBinder.TerminationHandler param2TerminationHandler, MethodDelegationBinder.MethodInvoker param2MethodInvoker, Assigner param2Assigner) {
/*   94 */         return MethodDelegationBinder.MethodBinding.Illegal.INSTANCE;
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
/*      */   public static interface MethodInvoker
/*      */   {
/*      */     StackManipulation invoke(MethodDescription param1MethodDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Simple
/*      */       implements MethodInvoker
/*      */     {
/*  122 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final StackManipulation invoke(MethodDescription param2MethodDescription) {
/*  128 */         return (StackManipulation)MethodInvocation.invoke(param2MethodDescription);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Virtual
/*      */       implements MethodInvoker
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Virtual(TypeDescription param2TypeDescription) {
/*  149 */         this.typeDescription = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation invoke(MethodDescription param2MethodDescription) {
/*  156 */         return MethodInvocation.invoke(param2MethodDescription).virtual(this.typeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((Virtual)param2Object).typeDescription))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface ParameterBinding<T>
/*      */     extends StackManipulation
/*      */   {
/*      */     T getIdentificationToken();
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Illegal
/*      */       implements ParameterBinding<Void>
/*      */     {
/*  188 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Void getIdentificationToken() {
/*  194 */         throw new IllegalStateException("An illegal binding does not define an identification token");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isValid() {
/*  201 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  208 */         throw new IllegalStateException("An illegal parameter binding must not be applied");
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Anonymous
/*      */       implements ParameterBinding<Object>
/*      */     {
/*      */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*      */       private final Object anonymousToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final StackManipulation delegate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Anonymous(StackManipulation param2StackManipulation) {
/*  236 */         this.delegate = param2StackManipulation;
/*  237 */         this.anonymousToken = new Object();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Object getIdentificationToken() {
/*  244 */         return this.anonymousToken;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isValid() {
/*  251 */         return this.delegate.isValid();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  258 */         return this.delegate.apply(param2MethodVisitor, param2Context);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.delegate.equals(((Anonymous)param2Object).delegate))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.delegate.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Unique<T>
/*      */       implements ParameterBinding<T>
/*      */     {
/*      */       private final T identificationToken;
/*      */ 
/*      */       
/*      */       private final StackManipulation delegate;
/*      */ 
/*      */ 
/*      */       
/*      */       public Unique(StackManipulation param2StackManipulation, T param2T) {
/*  290 */         this.delegate = param2StackManipulation;
/*  291 */         this.identificationToken = param2T;
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
/*      */       public static <S> Unique<S> of(StackManipulation param2StackManipulation, S param2S) {
/*  303 */         return new Unique<S>(param2StackManipulation, param2S);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public T getIdentificationToken() {
/*  310 */         return this.identificationToken;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isValid() {
/*  317 */         return this.delegate.isValid();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  324 */         return this.delegate.apply(param2MethodVisitor, param2Context);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.identificationToken.equals(((Unique)param2Object).identificationToken) ? false : (!!this.delegate.equals(((Unique)param2Object).delegate)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.identificationToken.hashCode()) * 31 + this.delegate.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface MethodBinding
/*      */     extends StackManipulation
/*      */   {
/*      */     @MaybeNull
/*      */     Integer getTargetParameterIndex(Object param1Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodDescription getTarget();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Illegal
/*      */       implements MethodBinding
/*      */     {
/*  370 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Integer getTargetParameterIndex(Object param2Object) {
/*  376 */         throw new IllegalStateException("Method is not bound");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDescription getTarget() {
/*  383 */         throw new IllegalStateException("Method is not bound");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isValid() {
/*  390 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/*  397 */         throw new IllegalStateException("Cannot delegate to an unbound method");
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Builder
/*      */     {
/*      */       private final MethodDelegationBinder.MethodInvoker methodInvoker;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodDescription candidate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<StackManipulation> parameterStackManipulations;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final LinkedHashMap<Object, Integer> registeredTargetIndices;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int nextParameterIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder(MethodDelegationBinder.MethodInvoker param2MethodInvoker, MethodDescription param2MethodDescription) {
/*  440 */         this.methodInvoker = param2MethodInvoker;
/*  441 */         this.candidate = param2MethodDescription;
/*  442 */         this.parameterStackManipulations = new ArrayList<StackManipulation>(param2MethodDescription.getParameters().size());
/*  443 */         this.registeredTargetIndices = new LinkedHashMap<Object, Integer>();
/*  444 */         this.nextParameterIndex = 0;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean append(MethodDelegationBinder.ParameterBinding<?> param2ParameterBinding) {
/*  455 */         this.parameterStackManipulations.add(param2ParameterBinding);
/*  456 */         return (this.registeredTargetIndices.put(param2ParameterBinding.getIdentificationToken(), Integer.valueOf(this.nextParameterIndex++)) == null);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegationBinder.MethodBinding build(StackManipulation param2StackManipulation) {
/*  466 */         if (this.candidate.getParameters().size() != this.nextParameterIndex) {
/*  467 */           throw new IllegalStateException("The number of parameters bound does not equal the target's number of parameters");
/*      */         }
/*  469 */         return new Build(this.candidate, this.registeredTargetIndices, this.methodInvoker
/*      */             
/*  471 */             .invoke(this.candidate), this.parameterStackManipulations, param2StackManipulation);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Build
/*      */         implements MethodDelegationBinder.MethodBinding
/*      */       {
/*      */         private final MethodDescription target;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Map<?, Integer> registeredTargetIndices;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final StackManipulation methodInvocation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<StackManipulation> parameterStackManipulations;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final StackManipulation terminatingStackManipulation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Build(MethodDescription param3MethodDescription, Map<?, Integer> param3Map, StackManipulation param3StackManipulation1, List<StackManipulation> param3List, StackManipulation param3StackManipulation2) {
/*  524 */           this.target = param3MethodDescription;
/*  525 */           this.registeredTargetIndices = new HashMap<Object, Integer>(param3Map);
/*  526 */           this.methodInvocation = param3StackManipulation1;
/*  527 */           this.parameterStackManipulations = new ArrayList<StackManipulation>(param3List);
/*  528 */           this.terminatingStackManipulation = param3StackManipulation2;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isValid() {
/*  535 */           boolean bool = (this.methodInvocation.isValid() && this.terminatingStackManipulation.isValid());
/*  536 */           Iterator<StackManipulation> iterator = this.parameterStackManipulations.iterator();
/*  537 */           while (bool && iterator.hasNext()) {
/*  538 */             bool = ((StackManipulation)iterator.next()).isValid();
/*      */           }
/*  540 */           return bool;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public Integer getTargetParameterIndex(Object param3Object) {
/*  548 */           return this.registeredTargetIndices.get(param3Object);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodDescription getTarget() {
/*  555 */           return this.target;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public StackManipulation.Size apply(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/*  562 */           return (new StackManipulation.Compound(
/*  563 */               CompoundList.of(this.parameterStackManipulations, Arrays.asList(new StackManipulation[] { this.methodInvocation, this.terminatingStackManipulation
/*  564 */                   })))).apply(param3MethodVisitor, param3Context);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.target.equals(((Build)param3Object).target) ? false : (!this.registeredTargetIndices.equals(((Build)param3Object).registeredTargetIndices) ? false : (!this.methodInvocation.equals(((Build)param3Object).methodInvocation) ? false : (!this.parameterStackManipulations.equals(((Build)param3Object).parameterStackManipulations) ? false : (!!this.terminatingStackManipulation.equals(((Build)param3Object).terminatingStackManipulation))))))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.registeredTargetIndices.hashCode()) * 31 + this.methodInvocation.hashCode()) * 31 + this.parameterStackManipulations.hashCode()) * 31 + this.terminatingStackManipulation.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface BindingResolver
/*      */   {
/*      */     MethodDelegationBinder.MethodBinding resolve(MethodDelegationBinder.AmbiguityResolver param1AmbiguityResolver, MethodDescription param1MethodDescription, List<MethodDelegationBinder.MethodBinding> param1List);
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Default
/*      */       implements BindingResolver
/*      */     {
/*  593 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final int RIGHT = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final int LEFT = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final int ONLY = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDelegationBinder.MethodBinding resolve(MethodDelegationBinder.AmbiguityResolver param2AmbiguityResolver, MethodDescription param2MethodDescription, List<MethodDelegationBinder.MethodBinding> param2List) {
/*  614 */         return doResolve(param2AmbiguityResolver, param2MethodDescription, new ArrayList<MethodDelegationBinder.MethodBinding>(param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private MethodDelegationBinder.MethodBinding doResolve(MethodDelegationBinder.AmbiguityResolver param2AmbiguityResolver, MethodDescription param2MethodDescription, List<MethodDelegationBinder.MethodBinding> param2List) {
/*      */         MethodDelegationBinder.MethodBinding methodBinding1;
/*  626 */         switch (param2List.size()) {
/*      */           case 1:
/*  628 */             return param2List.get(0);
/*      */           case 2:
/*  630 */             methodBinding2 = param2List.get(0);
/*  631 */             methodBinding3 = param2List.get(1);
/*  632 */             switch (MethodDelegationBinder.null.a[param2AmbiguityResolver.resolve(param2MethodDescription, methodBinding2, methodBinding3).ordinal()]) {
/*      */               case 1:
/*  634 */                 return methodBinding2;
/*      */               case 2:
/*  636 */                 return methodBinding3;
/*      */               case 3:
/*      */               case 4:
/*  639 */                 throw new IllegalArgumentException("Cannot resolve ambiguous delegation of " + param2MethodDescription + " to " + methodBinding2.getTarget() + " or " + methodBinding3.getTarget());
/*      */             } 
/*  641 */             throw new AssertionError();
/*      */         } 
/*      */ 
/*      */         
/*  645 */         MethodDelegationBinder.MethodBinding methodBinding2 = param2List.get(0);
/*  646 */         MethodDelegationBinder.MethodBinding methodBinding3 = param2List.get(1);
/*  647 */         switch (MethodDelegationBinder.null.a[param2AmbiguityResolver.resolve(param2MethodDescription, methodBinding2, methodBinding3).ordinal()]) {
/*      */           case 1:
/*  649 */             param2List.remove(1);
/*  650 */             return doResolve(param2AmbiguityResolver, param2MethodDescription, param2List);
/*      */           case 2:
/*  652 */             param2List.remove(0);
/*  653 */             return doResolve(param2AmbiguityResolver, param2MethodDescription, param2List);
/*      */           case 3:
/*      */           case 4:
/*  656 */             param2List.remove(1);
/*  657 */             param2List.remove(0);
/*  658 */             methodBinding1 = doResolve(param2AmbiguityResolver, param2MethodDescription, param2List);
/*  659 */             switch (MethodDelegationBinder.null.a[param2AmbiguityResolver.resolve(param2MethodDescription, methodBinding2, methodBinding1).merge(param2AmbiguityResolver.resolve(param2MethodDescription, methodBinding3, methodBinding1)).ordinal()]) {
/*      */               case 2:
/*  661 */                 return methodBinding1;
/*      */               case 1:
/*      */               case 3:
/*      */               case 4:
/*  665 */                 throw new IllegalArgumentException("Cannot resolve ambiguous delegation of " + param2MethodDescription + " to " + methodBinding2.getTarget() + " or " + methodBinding3.getTarget());
/*      */             } 
/*  667 */             throw new AssertionError();
/*      */         } 
/*      */         
/*  670 */         throw new IllegalStateException("Unexpected amount of targets: " + methodBinding1.size());
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
/*      */     public enum Unique
/*      */       implements BindingResolver
/*      */     {
/*  685 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final int ONLY = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDelegationBinder.MethodBinding resolve(MethodDelegationBinder.AmbiguityResolver param2AmbiguityResolver, MethodDescription param2MethodDescription, List<MethodDelegationBinder.MethodBinding> param2List) {
/*  696 */         if (param2List.size() == 1) {
/*  697 */           return param2List.get(0);
/*      */         }
/*  699 */         throw new IllegalStateException(param2MethodDescription + " allowed for more than one binding: " + param2List);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class StreamWriting
/*      */       implements BindingResolver
/*      */     {
/*      */       private final MethodDelegationBinder.BindingResolver delegate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final PrintStream printStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StreamWriting(MethodDelegationBinder.BindingResolver param2BindingResolver, PrintStream param2PrintStream) {
/*  727 */         this.delegate = param2BindingResolver;
/*  728 */         this.printStream = param2PrintStream;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static MethodDelegationBinder.BindingResolver toSystemOut() {
/*  737 */         return toSystemOut(MethodDelegationBinder.BindingResolver.Default.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static MethodDelegationBinder.BindingResolver toSystemOut(MethodDelegationBinder.BindingResolver param2BindingResolver) {
/*  747 */         return new StreamWriting(param2BindingResolver, System.out);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static MethodDelegationBinder.BindingResolver toSystemError() {
/*  756 */         return toSystemError(MethodDelegationBinder.BindingResolver.Default.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static MethodDelegationBinder.BindingResolver toSystemError(MethodDelegationBinder.BindingResolver param2BindingResolver) {
/*  766 */         return new StreamWriting(param2BindingResolver, System.err);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegationBinder.MethodBinding resolve(MethodDelegationBinder.AmbiguityResolver param2AmbiguityResolver, MethodDescription param2MethodDescription, List<MethodDelegationBinder.MethodBinding> param2List) {
/*  773 */         MethodDelegationBinder.MethodBinding methodBinding = this.delegate.resolve(param2AmbiguityResolver, param2MethodDescription, param2List);
/*  774 */         this.printStream.println("Binding " + param2MethodDescription + " as delegation to " + methodBinding.getTarget());
/*  775 */         return methodBinding;
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.delegate.equals(((StreamWriting)param2Object).delegate) ? false : (!!this.printStream.equals(((StreamWriting)param2Object).printStream)))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.delegate.hashCode()) * 31 + this.printStream.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @SuppressFBWarnings(value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"}, justification = "Safe initialization is implied.")
/*      */   public static interface AmbiguityResolver {
/*  790 */     public static final AmbiguityResolver DEFAULT = new Compound(new AmbiguityResolver[] { (AmbiguityResolver)BindingPriority.Resolver.INSTANCE, DeclaringTypeResolver.INSTANCE, ArgumentTypeResolver.INSTANCE, MethodNameEqualityResolver.INSTANCE, ParameterLengthResolver.INSTANCE });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Resolution resolve(MethodDescription param1MethodDescription, MethodDelegationBinder.MethodBinding param1MethodBinding1, MethodDelegationBinder.MethodBinding param1MethodBinding2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Resolution
/*      */     {
/*  818 */       UNKNOWN(true),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  823 */       LEFT(false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  828 */       RIGHT(false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  833 */       AMBIGUOUS(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean unresolved;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Resolution(boolean param2Boolean) {
/*  846 */         this.unresolved = param2Boolean;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isUnresolved() {
/*  855 */         return this.unresolved;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Resolution merge(Resolution param2Resolution) {
/*  865 */         switch (MethodDelegationBinder.null.a[ordinal()]) {
/*      */           case 4:
/*  867 */             return param2Resolution;
/*      */           case 3:
/*  869 */             return AMBIGUOUS;
/*      */           case 1:
/*      */           case 2:
/*  872 */             return (param2Resolution == UNKNOWN || param2Resolution == this) ? this : AMBIGUOUS;
/*      */         } 
/*      */ 
/*      */         
/*  876 */         throw new AssertionError();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum NoOp
/*      */       implements AmbiguityResolver
/*      */     {
/*  889 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription param2MethodDescription, MethodDelegationBinder.MethodBinding param2MethodBinding1, MethodDelegationBinder.MethodBinding param2MethodBinding2) {
/*  895 */         return MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Directional
/*      */       implements AmbiguityResolver
/*      */     {
/*  908 */       LEFT(true),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  914 */       RIGHT(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean left;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Directional(boolean param2Boolean) {
/*  927 */         this.left = param2Boolean;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription param2MethodDescription, MethodDelegationBinder.MethodBinding param2MethodBinding1, MethodDelegationBinder.MethodBinding param2MethodBinding2) {
/*  934 */         return this.left ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
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
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Compound
/*      */       implements AmbiguityResolver
/*      */     {
/*      */       public Compound(MethodDelegationBinder.AmbiguityResolver... param2VarArgs) {
/*  958 */         this(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  967 */       private final List<MethodDelegationBinder.AmbiguityResolver> ambiguityResolvers = new ArrayList<MethodDelegationBinder.AmbiguityResolver>(); public Compound(List<? extends MethodDelegationBinder.AmbiguityResolver> param2List) {
/*  968 */         for (Iterator<? extends MethodDelegationBinder.AmbiguityResolver> iterator = param2List.iterator(); iterator.hasNext(); ) {
/*  969 */           MethodDelegationBinder.AmbiguityResolver ambiguityResolver; if (ambiguityResolver = iterator.next() instanceof Compound) {
/*  970 */             this.ambiguityResolvers.addAll(((Compound)ambiguityResolver).ambiguityResolvers); continue;
/*  971 */           }  if (!(ambiguityResolver instanceof MethodDelegationBinder.AmbiguityResolver.NoOp)) {
/*  972 */             this.ambiguityResolvers.add(ambiguityResolver);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription param2MethodDescription, MethodDelegationBinder.MethodBinding param2MethodBinding1, MethodDelegationBinder.MethodBinding param2MethodBinding2) {
/*  981 */         MethodDelegationBinder.AmbiguityResolver.Resolution resolution = MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
/*  982 */         Iterator<MethodDelegationBinder.AmbiguityResolver> iterator = this.ambiguityResolvers.iterator();
/*  983 */         while (resolution.isUnresolved() && iterator.hasNext()) {
/*  984 */           resolution = ((MethodDelegationBinder.AmbiguityResolver)iterator.next()).resolve(param2MethodDescription, param2MethodBinding1, param2MethodBinding2);
/*      */         }
/*  986 */         return resolution;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.ambiguityResolvers.equals(((Compound)param2Object).ambiguityResolvers))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.ambiguityResolvers.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface TerminationHandler
/*      */   {
/*      */     StackManipulation resolve(Assigner param1Assigner, Assigner.Typing param1Typing, MethodDescription param1MethodDescription1, MethodDescription param1MethodDescription2);
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Default
/*      */       implements TerminationHandler
/*      */     {
/* 1016 */       RETURNING
/*      */       {
/*      */         public final StackManipulation resolve(Assigner param3Assigner, Assigner.Typing param3Typing, MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) {
/* 1019 */           return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { param3Assigner.assign(param3MethodDescription2.isConstructor() ? param3MethodDescription2
/* 1020 */                   .getDeclaringType().asGenericType() : param3MethodDescription2
/* 1021 */                   .getReturnType(), param3MethodDescription1
/* 1022 */                   .getReturnType(), param3Typing), 
/* 1023 */                 MethodReturn.of((TypeDefinition)param3MethodDescription1.getReturnType())
/*      */ 
/*      */ 
/*      */               
/*      */               });
/*      */         }
/*      */       },
/* 1030 */       DROPPING
/*      */       {
/*      */         public final StackManipulation resolve(Assigner param3Assigner, Assigner.Typing param3Typing, MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) {
/* 1033 */           return Removal.of(param3MethodDescription2.isConstructor() ? param3MethodDescription2
/* 1034 */               .getDeclaringType() : (TypeDefinition)param3MethodDescription2
/* 1035 */               .getReturnType());
/*      */         }
/*      */       };
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
/*      */   @Enhance
/*      */   public static class Processor
/*      */     implements Record
/*      */   {
/*      */     private final List<? extends MethodDelegationBinder.Record> records;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDelegationBinder.AmbiguityResolver ambiguityResolver;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDelegationBinder.BindingResolver bindingResolver;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Processor(List<? extends MethodDelegationBinder.Record> param1List, MethodDelegationBinder.AmbiguityResolver param1AmbiguityResolver, MethodDelegationBinder.BindingResolver param1BindingResolver) {
/* 1078 */       this.records = param1List;
/* 1079 */       this.ambiguityResolver = param1AmbiguityResolver;
/* 1080 */       this.bindingResolver = param1BindingResolver;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDelegationBinder.MethodBinding bind(Implementation.Target param1Target, MethodDescription param1MethodDescription, MethodDelegationBinder.TerminationHandler param1TerminationHandler, MethodDelegationBinder.MethodInvoker param1MethodInvoker, Assigner param1Assigner) {
/* 1091 */       ArrayList<MethodDelegationBinder.MethodBinding> arrayList = new ArrayList();
/* 1092 */       for (Iterator<? extends MethodDelegationBinder.Record> iterator = this.records.iterator(); iterator.hasNext();) {
/*      */         
/* 1094 */         if ((methodBinding = (record = iterator.next()).bind(param1Target, param1MethodDescription, param1TerminationHandler, param1MethodInvoker, param1Assigner)).isValid()) {
/* 1095 */           arrayList.add(methodBinding);
/*      */         }
/*      */       } 
/* 1098 */       if (arrayList.isEmpty()) {
/* 1099 */         throw new IllegalArgumentException("None of " + this.records + " allows for delegation from " + param1MethodDescription);
/*      */       }
/* 1101 */       return this.bindingResolver.resolve(this.ambiguityResolver, param1MethodDescription, arrayList);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.records.equals(((Processor)param1Object).records) ? false : (!this.ambiguityResolver.equals(((Processor)param1Object).ambiguityResolver) ? false : (!!this.bindingResolver.equals(((Processor)param1Object).bindingResolver))))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return ((getClass().hashCode() * 31 + this.records.hashCode()) * 31 + this.ambiguityResolver.hashCode()) * 31 + this.bindingResolver.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\MethodDelegationBinder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */