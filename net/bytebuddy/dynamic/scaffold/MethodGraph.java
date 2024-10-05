/*      */ package net.bytebuddy.dynamic.scaffold;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.matcher.FilterableList;
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
/*      */ public interface MethodGraph
/*      */ {
/*      */   Node locate(MethodDescription.SignatureToken paramSignatureToken);
/*      */   
/*      */   NodeList listNodes();
/*      */   
/*      */   public enum Empty
/*      */     implements Compiler, Linked
/*      */   {
/*   63 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodGraph.Node locate(MethodDescription.SignatureToken param1SignatureToken) {
/*   69 */       return MethodGraph.Node.Unresolved.INSTANCE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodGraph.NodeList listNodes() {
/*   76 */       return new MethodGraph.NodeList(Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodGraph getSuperClassGraph() {
/*   83 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodGraph getInterfaceGraph(TypeDescription param1TypeDescription) {
/*   90 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodGraph.Linked compile(TypeDefinition param1TypeDefinition) {
/*   97 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Deprecated
/*      */     public final MethodGraph.Linked compile(TypeDescription param1TypeDescription) {
/*  105 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MethodGraph.Linked compile(TypeDefinition param1TypeDefinition, TypeDescription param1TypeDescription) {
/*  112 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Deprecated
/*      */     public final MethodGraph.Linked compile(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/*  120 */       return this;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Linked
/*      */     extends MethodGraph
/*      */   {
/*      */     MethodGraph getSuperClassGraph();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodGraph getInterfaceGraph(TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Delegation
/*      */       implements Linked
/*      */     {
/*      */       private final MethodGraph methodGraph;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodGraph superClassGraph;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Map<TypeDescription, MethodGraph> interfaceGraphs;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Delegation(MethodGraph param2MethodGraph1, MethodGraph param2MethodGraph2, Map<TypeDescription, MethodGraph> param2Map) {
/*  174 */         this.methodGraph = param2MethodGraph1;
/*  175 */         this.superClassGraph = param2MethodGraph2;
/*  176 */         this.interfaceGraphs = param2Map;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodGraph getSuperClassGraph() {
/*  183 */         return this.superClassGraph;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodGraph getInterfaceGraph(TypeDescription param2TypeDescription) {
/*      */         MethodGraph methodGraph;
/*  191 */         return ((methodGraph = this.interfaceGraphs.get(param2TypeDescription)) == null) ? MethodGraph.Empty.INSTANCE : methodGraph;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodGraph.Node locate(MethodDescription.SignatureToken param2SignatureToken) {
/*  200 */         return this.methodGraph.locate(param2SignatureToken);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodGraph.NodeList listNodes() {
/*  207 */         return this.methodGraph.listNodes();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.methodGraph.equals(((Delegation)param2Object).methodGraph) ? false : (!this.superClassGraph.equals(((Delegation)param2Object).superClassGraph) ? false : (!!this.interfaceGraphs.equals(((Delegation)param2Object).interfaceGraphs))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.methodGraph.hashCode()) * 31 + this.superClassGraph.hashCode()) * 31 + this.interfaceGraphs.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Node
/*      */   {
/*      */     Sort getSort();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodDescription getRepresentative();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Set<MethodDescription.TypeToken> getMethodTypes();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Visibility getVisibility();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Sort
/*      */     {
/*  254 */       VISIBLE(true, true, true),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  259 */       RESOLVED(true, true, false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  264 */       AMBIGUOUS(true, false, false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  269 */       UNRESOLVED(false, false, false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean resolved;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean unique;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean madeVisible;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Sort(boolean param2Boolean1, boolean param2Boolean2, boolean param2Boolean3) {
/*  294 */         this.resolved = param2Boolean1;
/*  295 */         this.unique = param2Boolean2;
/*  296 */         this.madeVisible = param2Boolean3;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isResolved() {
/*  305 */         return this.resolved;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isUnique() {
/*  314 */         return this.unique;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isMadeVisible() {
/*  323 */         return this.madeVisible;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Unresolved
/*      */       implements Node
/*      */     {
/*  335 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodGraph.Node.Sort getSort() {
/*  341 */         return MethodGraph.Node.Sort.UNRESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodDescription getRepresentative() {
/*  348 */         throw new IllegalStateException("Cannot resolve the method of an illegal node");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Set<MethodDescription.TypeToken> getMethodTypes() {
/*  355 */         throw new IllegalStateException("Cannot resolve bridge method of an illegal node");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Visibility getVisibility() {
/*  362 */         throw new IllegalStateException("Cannot resolve visibility of an illegal node");
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Simple
/*      */       implements Node
/*      */     {
/*      */       private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Simple(MethodDescription param2MethodDescription) {
/*  383 */         this.methodDescription = param2MethodDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodGraph.Node.Sort getSort() {
/*  390 */         return MethodGraph.Node.Sort.RESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription getRepresentative() {
/*  397 */         return this.methodDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Set<MethodDescription.TypeToken> getMethodTypes() {
/*  404 */         return Collections.emptySet();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Visibility getVisibility() {
/*  411 */         return this.methodDescription.getVisibility();
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.methodDescription.equals(((Simple)param2Object).methodDescription))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.methodDescription.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @SuppressFBWarnings(value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"}, justification = "Safe initialization is implied.")
/*  425 */   public static interface Compiler { public static final Compiler DEFAULT = Default.forJavaHierarchy();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodGraph.Linked compile(TypeDefinition param1TypeDefinition);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Deprecated
/*      */     MethodGraph.Linked compile(TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodGraph.Linked compile(TypeDefinition param1TypeDefinition, TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Deprecated
/*      */     MethodGraph.Linked compile(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum ForDeclaredMethods
/*      */       implements Compiler
/*      */     {
/*  473 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodGraph.Linked compile(TypeDefinition param2TypeDefinition) {
/*  479 */         return compile(param2TypeDefinition, param2TypeDefinition.asErasure());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Deprecated
/*      */       public final MethodGraph.Linked compile(TypeDescription param2TypeDescription) {
/*  487 */         return compile((TypeDefinition)param2TypeDescription, param2TypeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodGraph.Linked compile(TypeDefinition param2TypeDefinition, TypeDescription param2TypeDescription) {
/*  494 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  495 */         for (MethodDescription methodDescription : param2TypeDefinition.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isVirtual().and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isBridge())).and((ElementMatcher)ElementMatchers.isVisibleTo(param2TypeDescription)))) {
/*  496 */           linkedHashMap.put(methodDescription.asSignatureToken(), new MethodGraph.Node.Simple(methodDescription));
/*      */         }
/*  498 */         return new MethodGraph.Linked.Delegation(new MethodGraph.Simple((LinkedHashMap)linkedHashMap), MethodGraph.Empty.INSTANCE, Collections.emptyMap());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Deprecated
/*      */       public final MethodGraph.Linked compile(TypeDescription param2TypeDescription1, TypeDescription param2TypeDescription2) {
/*  506 */         return compile((TypeDefinition)param2TypeDescription1, param2TypeDescription2);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static abstract class AbstractBase
/*      */       implements Compiler
/*      */     {
/*      */       public MethodGraph.Linked compile(TypeDefinition param2TypeDefinition) {
/*  519 */         return compile(param2TypeDefinition, param2TypeDefinition.asErasure());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Deprecated
/*      */       public MethodGraph.Linked compile(TypeDescription param2TypeDescription) {
/*  527 */         return compile((TypeDefinition)param2TypeDescription, param2TypeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Deprecated
/*      */       public MethodGraph.Linked compile(TypeDescription param2TypeDescription1, TypeDescription param2TypeDescription2) {
/*  535 */         return compile((TypeDefinition)param2TypeDescription1, param2TypeDescription2);
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
/*      */     public static class Default<T>
/*      */       extends AbstractBase
/*      */     {
/*      */       private final Harmonizer<T> harmonizer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Merger merger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Default(Harmonizer<T> param2Harmonizer, Merger param2Merger, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param2Visitor) {
/*  570 */         this.harmonizer = param2Harmonizer;
/*  571 */         this.merger = param2Merger;
/*  572 */         this.visitor = param2Visitor;
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
/*      */       public static <S> MethodGraph.Compiler of(Harmonizer<S> param2Harmonizer, Merger param2Merger) {
/*  584 */         return new Default<S>(param2Harmonizer, param2Merger, (TypeDescription.Generic.Visitor<? extends TypeDescription.Generic>)TypeDescription.Generic.Visitor.Reifying.INITIATING);
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
/*      */       public static <S> MethodGraph.Compiler of(Harmonizer<S> param2Harmonizer, Merger param2Merger, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param2Visitor) {
/*  597 */         return new Default<S>(param2Harmonizer, param2Merger, param2Visitor);
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
/*      */       public static MethodGraph.Compiler forJavaHierarchy() {
/*  613 */         return of(Harmonizer.ForJavaMethod.INSTANCE, Merger.Directional.LEFT);
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
/*      */       public static MethodGraph.Compiler forJVMHierarchy() {
/*  629 */         return of(Harmonizer.ForJVMMethod.INSTANCE, Merger.Directional.LEFT);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodGraph.Linked compile(TypeDefinition param2TypeDefinition, TypeDescription param2TypeDescription) {
/*      */         Key.Store store;
/*  636 */         HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/*  637 */         Key.Store<T> store1 = doAnalyze(param2TypeDefinition, (Map)hashMap1, (ElementMatcher<? super MethodDescription>)ElementMatchers.isVirtual().and((ElementMatcher)ElementMatchers.isVisibleTo(param2TypeDescription)));
/*  638 */         TypeDescription.Generic generic1 = param2TypeDefinition.getSuperClass();
/*  639 */         TypeList.Generic generic = param2TypeDefinition.getInterfaces();
/*  640 */         HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/*  641 */         for (TypeDescription.Generic generic2 : generic) {
/*      */           Key.Store store2;
/*  643 */           if ((store2 = (Key.Store)hashMap1.get(generic2)) == null) {
/*  644 */             throw new IllegalStateException("Failed to resolve interface type " + generic2 + " from " + hashMap1.keySet());
/*      */           }
/*  646 */           hashMap2.put(generic2.asErasure(), store2.asGraph(this.merger));
/*      */         } 
/*      */         
/*  649 */         if (generic1 == null) {
/*  650 */           generic = null;
/*      */         
/*      */         }
/*  653 */         else if ((store = (Key.Store)hashMap1.get(generic1)) == null) {
/*  654 */           throw new IllegalStateException("Failed to resolve super class " + generic1 + " from " + hashMap1.keySet());
/*      */         } 
/*      */         
/*  657 */         return new MethodGraph.Linked.Delegation(store1.asGraph(this.merger), (store == null) ? MethodGraph.Empty.INSTANCE : store
/*      */ 
/*      */             
/*  660 */             .asGraph(this.merger), (Map)hashMap2);
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
/*      */       protected Key.Store<T> analyze(TypeDefinition param2TypeDefinition1, TypeDefinition param2TypeDefinition2, Map<TypeDefinition, Key.Store<T>> param2Map, ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/*      */         Key.Store<T> store;
/*  678 */         if ((store = param2Map.get(param2TypeDefinition2)) == null) {
/*  679 */           store = doAnalyze(param2TypeDefinition1, param2Map, param2ElementMatcher);
/*  680 */           param2Map.put(param2TypeDefinition2, store);
/*      */         } 
/*  682 */         return store;
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
/*      */       protected Key.Store<T> analyzeNullable(@MaybeNull TypeDescription.Generic param2Generic, Map<TypeDefinition, Key.Store<T>> param2Map, ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/*  696 */         return (param2Generic == null) ? new Key.Store<T>() : 
/*      */           
/*  698 */           analyze((TypeDefinition)param2Generic.accept(this.visitor), (TypeDefinition)param2Generic, param2Map, param2ElementMatcher);
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
/*      */       protected Key.Store<T> doAnalyze(TypeDefinition param2TypeDefinition, Map<TypeDefinition, Key.Store<T>> param2Map, ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/*  712 */         Key.Store<T> store1 = analyzeNullable(param2TypeDefinition.getSuperClass(), param2Map, param2ElementMatcher);
/*  713 */         Key.Store<T> store2 = new Key.Store();
/*  714 */         for (TypeDescription.Generic generic : param2TypeDefinition.getInterfaces()) {
/*  715 */           store2 = store2.combineWith(analyze((TypeDefinition)generic.accept(this.visitor), (TypeDefinition)generic, param2Map, param2ElementMatcher));
/*      */         }
/*  717 */         return store1.inject(store2).registerTopLevel((List<? extends MethodDescription>)param2TypeDefinition.getDeclaredMethods().filter(param2ElementMatcher), this.harmonizer);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.harmonizer.equals(((Default)param2Object).harmonizer) ? false : (!this.merger.equals(((Default)param2Object).merger) ? false : (!!this.visitor.equals(((Default)param2Object).visitor))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.harmonizer.hashCode()) * 31 + this.merger.hashCode()) * 31 + this.visitor.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum ForJavaMethod
/*      */         implements Harmonizer<Harmonizer.ForJavaMethod.Token>
/*      */       {
/*  744 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final Token harmonize(MethodDescription.TypeToken param3TypeToken) {
/*  750 */           return new Token(param3TypeToken);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class Token
/*      */         {
/*      */           private final MethodDescription.TypeToken typeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final int hashCode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Token(MethodDescription.TypeToken param5TypeToken) {
/*  774 */             this.typeToken = param5TypeToken;
/*  775 */             this.hashCode = param5TypeToken.getParameterTypes().hashCode();
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*  780 */             return this.hashCode;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param5Object) {
/*  785 */             return (this == param5Object || (param5Object instanceof Token && this.typeToken.getParameterTypes().equals(((Token)param5Object).typeToken.getParameterTypes())));
/*      */           }
/*      */           
/*      */           public String toString()
/*      */           {
/*  790 */             return this.typeToken.getParameterTypes().toString(); } } } public static interface Harmonizer<S> { S harmonize(MethodDescription.TypeToken param3TypeToken); public enum ForJavaMethod implements Harmonizer<ForJavaMethod.Token> { INSTANCE; public final Token harmonize(MethodDescription.TypeToken param4TypeToken) { return new Token(param4TypeToken); } protected static class Token { private final MethodDescription.TypeToken typeToken; private final int hashCode; protected Token(MethodDescription.TypeToken param5TypeToken) { this.typeToken = param5TypeToken; this.hashCode = param5TypeToken.getParameterTypes().hashCode(); } public int hashCode() { return this.hashCode; } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object || (param5Object instanceof Token && this.typeToken.getParameterTypes().equals(((Token)param5Object).typeToken.getParameterTypes()))); } public String toString() { return this.typeToken.getParameterTypes().toString(); }
/*      */              }
/*      */            }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public enum ForJVMMethod
/*      */           implements Harmonizer<ForJVMMethod.Token>
/*      */         {
/*  803 */           INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final Token harmonize(MethodDescription.TypeToken param4TypeToken) {
/*  809 */             return new Token(param4TypeToken);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static class Token
/*      */           {
/*      */             private final MethodDescription.TypeToken typeToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final int hashCode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Token(MethodDescription.TypeToken param5TypeToken) {
/*  833 */               this.typeToken = param5TypeToken;
/*  834 */               this.hashCode = param5TypeToken.getReturnType().hashCode() + 31 * param5TypeToken.getParameterTypes().hashCode();
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*  839 */               return this.hashCode;
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*  844 */               if (this == param5Object)
/*  845 */                 return true; 
/*  846 */               if (!(param5Object instanceof Token)) {
/*  847 */                 return false;
/*      */               }
/*  849 */               param5Object = param5Object;
/*  850 */               if (this.typeToken.getReturnType().equals(((Token)param5Object).typeToken.getReturnType()) && this.typeToken
/*  851 */                 .getParameterTypes().equals(((Token)param5Object).typeToken.getParameterTypes())) return true; 
/*      */               return false;
/*      */             }
/*      */             
/*      */             public String toString() {
/*  856 */               return this.typeToken.toString(); } } } } public enum ForJVMMethod implements Harmonizer<Harmonizer.ForJVMMethod.Token> { INSTANCE; public final Token harmonize(MethodDescription.TypeToken param3TypeToken) { return new Token(param3TypeToken); } protected static class Token { private final MethodDescription.TypeToken typeToken; private final int hashCode; public Token(MethodDescription.TypeToken param5TypeToken) { this.typeToken = param5TypeToken; this.hashCode = param5TypeToken.getReturnType().hashCode() + 31 * param5TypeToken.getParameterTypes().hashCode(); } public int hashCode() { return this.hashCode; } public boolean equals(@MaybeNull Object param5Object) { if (this == param5Object) return true;  if (!(param5Object instanceof Token)) return false;  param5Object = param5Object; if (this.typeToken.getReturnType().equals(((Token)param5Object).typeToken.getReturnType()) && this.typeToken.getParameterTypes().equals(((Token)param5Object).typeToken.getParameterTypes())) return true;  return false; } public String toString() { return this.typeToken.toString(); }
/*      */            }
/*      */          }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Merger
/*      */       {
/*      */         MethodDescription merge(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public enum Directional
/*      */           implements Merger
/*      */         {
/*  885 */           LEFT(true),
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  890 */           RIGHT(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final boolean left;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           Directional(boolean param4Boolean) {
/*  903 */             this.left = param4Boolean;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public final MethodDescription merge(MethodDescription param4MethodDescription1, MethodDescription param4MethodDescription2)
/*      */           {
/*  910 */             return this.left ? param4MethodDescription1 : param4MethodDescription2; } } } public enum Directional implements Merger { LEFT(true), RIGHT(false); private final boolean left; Directional(boolean param3Boolean) { this.left = param3Boolean; } public final MethodDescription merge(MethodDescription param3MethodDescription1, MethodDescription param3MethodDescription2) { return this.left ? param3MethodDescription1 : param3MethodDescription2; }
/*      */          }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static abstract class Key<S>
/*      */       {
/*      */         protected final String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final int parameterCount;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Key(String param3String, int param3Int) {
/*  942 */           this.internalName = param3String;
/*  943 */           this.parameterCount = param3Int;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract Set<S> getIdentifiers();
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*  955 */           return this.internalName.hashCode() + 31 * this.parameterCount;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*  960 */           if (this == param3Object)
/*  961 */             return true; 
/*  962 */           if (!(param3Object instanceof Key)) {
/*  963 */             return false;
/*      */           }
/*  965 */           param3Object = param3Object;
/*  966 */           if (this.internalName.equals(((Key)param3Object).internalName) && this.parameterCount == ((Key)param3Object).parameterCount && 
/*      */             
/*  968 */             !Collections.disjoint(getIdentifiers(), param3Object.getIdentifiers())) return true;
/*      */           
/*      */           return false;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class Harmonized<V>
/*      */           extends Key<V>
/*      */         {
/*      */           private final Map<V, Set<MethodDescription.TypeToken>> identifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Harmonized(String param4String, int param4Int, Map<V, Set<MethodDescription.TypeToken>> param4Map) {
/*  992 */             super(param4String, param4Int);
/*  993 */             this.identifiers = param4Map;
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
/*      */           protected static <Q> Harmonized<Q> of(MethodDescription param4MethodDescription, MethodGraph.Compiler.Default.Harmonizer<Q> param4Harmonizer) {
/* 1005 */             MethodDescription.TypeToken typeToken = param4MethodDescription.asTypeToken();
/* 1006 */             return new Harmonized<Q>(param4MethodDescription.getInternalName(), param4MethodDescription
/* 1007 */                 .getParameters().size(), 
/* 1008 */                 Collections.singletonMap(param4Harmonizer.harmonize(typeToken), Collections.emptySet()));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected MethodGraph.Compiler.Default.Key.Detached detach(MethodDescription.TypeToken param4TypeToken) {
/* 1018 */             HashSet<MethodDescription.TypeToken> hashSet = new HashSet();
/* 1019 */             for (Set<MethodDescription.TypeToken> set : this.identifiers.values()) {
/* 1020 */               hashSet.addAll(set);
/*      */             }
/* 1022 */             hashSet.add(param4TypeToken);
/* 1023 */             return new MethodGraph.Compiler.Default.Key.Detached(this.internalName, this.parameterCount, hashSet);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Harmonized<V> combineWith(Harmonized<V> param4Harmonized) {
/* 1033 */             HashMap<V, Set<MethodDescription.TypeToken>> hashMap = new HashMap<V, Set<MethodDescription.TypeToken>>(this.identifiers);
/* 1034 */             for (Map.Entry<V, Set<MethodDescription.TypeToken>> entry : param4Harmonized.identifiers.entrySet()) {
/*      */               Set<?> set;
/* 1036 */               if ((set = hashMap.get(entry.getKey())) == null) {
/* 1037 */                 hashMap.put((V)entry.getKey(), (Set<MethodDescription.TypeToken>)entry.getValue());
/*      */                 continue;
/*      */               } 
/* 1040 */               (set = new HashSet(set)).addAll((Collection)entry.getValue());
/* 1041 */               hashMap.put((V)entry.getKey(), set);
/*      */             } 
/*      */             
/* 1044 */             return new Harmonized(this.internalName, this.parameterCount, hashMap);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Harmonized<V> extend(MethodDescription.InDefinedShape param4InDefinedShape, MethodGraph.Compiler.Default.Harmonizer<V> param4Harmonizer) {
/* 1055 */             HashMap<V, Set<MethodDescription.TypeToken>> hashMap = new HashMap<V, Set<MethodDescription.TypeToken>>(this.identifiers);
/* 1056 */             MethodDescription.TypeToken typeToken = param4InDefinedShape.asTypeToken();
/* 1057 */             param4Harmonizer = (MethodGraph.Compiler.Default.Harmonizer<V>)param4Harmonizer.harmonize(typeToken);
/*      */             Set<?> set;
/* 1059 */             if ((set = hashMap.get(param4Harmonizer)) == null) {
/* 1060 */               hashMap.put((V)param4Harmonizer, Collections.singleton(typeToken));
/*      */             } else {
/*      */               
/* 1063 */               (set = new HashSet(set)).add(typeToken);
/* 1064 */               hashMap.put((V)param4Harmonizer, set);
/*      */             } 
/* 1066 */             return new Harmonized(this.internalName, this.parameterCount, hashMap);
/*      */           }
/*      */ 
/*      */           
/*      */           protected Set<V> getIdentifiers() {
/* 1071 */             return this.identifiers.keySet();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class Detached
/*      */           extends Key<MethodDescription.TypeToken>
/*      */         {
/*      */           private final Set<MethodDescription.TypeToken> identifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Detached(String param4String, int param4Int, Set<MethodDescription.TypeToken> param4Set) {
/* 1093 */             super(param4String, param4Int);
/* 1094 */             this.identifiers = param4Set;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected static Detached of(MethodDescription.SignatureToken param4SignatureToken) {
/* 1104 */             return new Detached(param4SignatureToken.getName(), param4SignatureToken.getParameterTypes().size(), Collections.singleton(param4SignatureToken.asTypeToken()));
/*      */           }
/*      */ 
/*      */           
/*      */           protected Set<MethodDescription.TypeToken> getIdentifiers() {
/* 1109 */             return this.identifiers;
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         protected static class Store<V>
/*      */         {
/*      */           private final LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> entries;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Store() {
/* 1130 */             this(new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private Store(LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> param4LinkedHashMap) {
/* 1139 */             this.entries = param4LinkedHashMap;
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
/*      */           private static <W> Entry<W> combine(Entry<W> param4Entry1, Entry<W> param4Entry2) {
/* 1151 */             Set<MethodDescription> set1 = param4Entry1.getCandidates(), set2 = param4Entry2.getCandidates();
/*      */             LinkedHashSet<MethodDescription> linkedHashSet;
/* 1153 */             (linkedHashSet = new LinkedHashSet<MethodDescription>()).addAll(set1);
/* 1154 */             linkedHashSet.addAll(set2);
/* 1155 */             for (Iterator<MethodDescription> iterator = set1.iterator(); iterator.hasNext(); ) {
/* 1156 */               MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure();
/* 1157 */               for (Iterator<MethodDescription> iterator1 = set2.iterator(); iterator1.hasNext(); ) {
/* 1158 */                 MethodDescription methodDescription1; TypeDescription typeDescription1 = (methodDescription1 = iterator1.next()).getDeclaringType().asErasure();
/* 1159 */                 if (!typeDescription.equals(typeDescription1)) {
/*      */                   
/* 1161 */                   if (typeDescription.isAssignableTo(typeDescription1)) {
/* 1162 */                     linkedHashSet.remove(methodDescription1); break;
/*      */                   } 
/* 1164 */                   if (typeDescription.isAssignableFrom(typeDescription1)) {
/* 1165 */                     linkedHashSet.remove(methodDescription);
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/* 1170 */             MethodGraph.Compiler.Default.Key.Harmonized<W> harmonized = param4Entry1.getKey().combineWith(param4Entry2.getKey());
/* 1171 */             Visibility visibility = param4Entry1.getVisibility().expandTo(param4Entry2.getVisibility());
/* 1172 */             return (Entry<W>)((linkedHashSet.size() == 1) ? new Entry.Resolved<W>(harmonized, linkedHashSet
/* 1173 */                 .iterator().next(), visibility, false) : new Entry.Ambiguous<W>(harmonized, linkedHashSet, visibility));
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
/*      */           protected Store<V> registerTopLevel(List<? extends MethodDescription> param4List, MethodGraph.Compiler.Default.Harmonizer<V> param4Harmonizer) {
/* 1185 */             if (param4List.isEmpty()) {
/* 1186 */               return this;
/*      */             }
/* 1188 */             LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> linkedHashMap = new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>(this.entries);
/* 1189 */             for (Iterator<? extends MethodDescription> iterator = param4List.iterator(); iterator.hasNext(); ) {
/* 1190 */               MethodDescription methodDescription; MethodGraph.Compiler.Default.Key.Harmonized<V> harmonized = MethodGraph.Compiler.Default.Key.Harmonized.of(methodDescription = iterator.next(), param4Harmonizer);
/*      */ 
/*      */               
/* 1193 */               Entry<V> entry2, entry1 = (((entry2 = (Entry)linkedHashMap.remove(harmonized)) == null) ? new Entry.Initial<V>(harmonized) : entry2).extendBy(methodDescription, param4Harmonizer);
/* 1194 */               linkedHashMap.put(entry1.getKey(), entry1);
/*      */             } 
/* 1196 */             return new Store(linkedHashMap);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Store<V> combineWith(Store<V> param4Store) {
/* 1206 */             if (this.entries.isEmpty())
/* 1207 */               return param4Store; 
/* 1208 */             if (param4Store.entries.isEmpty()) {
/* 1209 */               return this;
/*      */             }
/* 1211 */             LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> linkedHashMap = new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>(this.entries);
/* 1212 */             for (Entry<?> entry1 : param4Store.entries.values()) {
/*      */               Entry<?> entry2;
/*      */               
/* 1215 */               entry1 = ((entry2 = linkedHashMap.remove(entry1.getKey())) == null) ? entry1 : combine(entry2, entry1);
/* 1216 */               linkedHashMap.put((MethodGraph.Compiler.Default.Key.Harmonized)entry1.getKey(), entry1);
/*      */             } 
/* 1218 */             return new Store(linkedHashMap);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Store<V> inject(Store<V> param4Store) {
/* 1228 */             if (this.entries.isEmpty())
/* 1229 */               return param4Store; 
/* 1230 */             if (param4Store.entries.isEmpty()) {
/* 1231 */               return this;
/*      */             }
/* 1233 */             LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> linkedHashMap = new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>(this.entries);
/* 1234 */             for (Entry<V> entry : param4Store.entries.values()) {
/*      */               Entry entry1;
/*      */               
/* 1237 */               entry = ((entry1 = linkedHashMap.remove(entry.getKey())) == null) ? entry : entry1.inject(entry);
/* 1238 */               linkedHashMap.put(entry.getKey(), entry);
/*      */             } 
/* 1240 */             return new Store(linkedHashMap);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected MethodGraph asGraph(MethodGraph.Compiler.Default.Merger param4Merger) {
/* 1250 */             LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 1251 */             for (Iterator<Entry> iterator = this.entries.values().iterator(); iterator.hasNext(); ) {
/* 1252 */               Entry<?> entry; MethodGraph.Node node = (entry = iterator.next()).asNode(param4Merger);
/* 1253 */               linkedHashMap.put(entry.getKey().detach(node.getRepresentative().asTypeToken()), node);
/*      */             } 
/* 1255 */             return new Graph((LinkedHashMap)linkedHashMap);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.entries.equals(((Store)param4Object).entries))));
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
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.entries.hashCode();
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
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public static class Initial<U>
/*      */             implements Entry<U>
/*      */           {
/*      */             private final MethodGraph.Compiler.Default.Key.Harmonized<U> key;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Initial(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized) {
/* 1329 */               this.key = param5Harmonized;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() {
/* 1336 */               throw new IllegalStateException("Cannot extract key from initial entry:" + this);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Set<MethodDescription> getCandidates() {
/* 1343 */               throw new IllegalStateException("Cannot extract method from initial entry:" + this);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Visibility getVisibility() {
/* 1350 */               throw new IllegalStateException("Cannot extract visibility from initial entry:" + this);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param5Harmonizer) {
/* 1357 */               return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key.extend((MethodDescription.InDefinedShape)param5MethodDescription.asDefined(), param5Harmonizer), param5MethodDescription, param5MethodDescription
/*      */                   
/* 1359 */                   .getVisibility(), false);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param5Entry) {
/* 1367 */               throw new IllegalStateException("Cannot inject into initial entry without a registered method: " + this);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger) {
/* 1374 */               throw new IllegalStateException("Cannot transform initial entry without a registered method: " + this);
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/* 1379 */               return this.key.hashCode();
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/* 1384 */               if (this == param5Object)
/* 1385 */                 return true; 
/* 1386 */               if (param5Object == null || getClass() != param5Object.getClass()) {
/* 1387 */                 return false;
/*      */               }
/* 1389 */               param5Object = param5Object;
/* 1390 */               return this.key.equals(((Initial)param5Object).key);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           public static class Resolved<U>
/*      */             implements Entry<U>
/*      */           {
/*      */             private static final int MADE_VISIBLE = 5;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private static final boolean NOT_MADE_VISIBLE = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final MethodGraph.Compiler.Default.Key.Harmonized<U> key;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final Visibility visibility;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final boolean madeVisible;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized, MethodDescription param5MethodDescription, Visibility param5Visibility) {
/* 1441 */               this(param5Harmonized, param5MethodDescription, param5Visibility, false);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized, MethodDescription param5MethodDescription, Visibility param5Visibility, boolean param5Boolean) {
/* 1453 */               this.key = param5Harmonized;
/* 1454 */               this.methodDescription = param5MethodDescription;
/* 1455 */               this.visibility = param5Visibility;
/* 1456 */               this.madeVisible = param5Boolean;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private static <V> MethodGraph.Compiler.Default.Key.Store.Entry<V> of(MethodGraph.Compiler.Default.Key.Harmonized<V> param5Harmonized, MethodDescription param5MethodDescription1, MethodDescription param5MethodDescription2, Visibility param5Visibility) {
/* 1470 */               param5Visibility = param5Visibility.expandTo(param5MethodDescription2.getVisibility()).expandTo(param5MethodDescription1.getVisibility());
/* 1471 */               return param5MethodDescription1.isBridge() ? new Resolved<V>(param5Harmonized, param5MethodDescription2, param5Visibility, 
/* 1472 */                   ((param5MethodDescription2.getDeclaringType().getModifiers() & 0x5) == 0)) : new Resolved<V>(param5Harmonized, param5MethodDescription1, param5Visibility, false);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() {
/* 1480 */               return this.key;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Set<MethodDescription> getCandidates() {
/* 1487 */               return Collections.singleton(this.methodDescription);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Visibility getVisibility() {
/* 1494 */               return this.visibility;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param5Harmonizer) {
/* 1501 */               MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param5MethodDescription.asDefined(), param5Harmonizer);
/* 1502 */               Visibility visibility = this.visibility.expandTo(param5MethodDescription.getVisibility());
/* 1503 */               if (param5MethodDescription.getDeclaringType().equals(this.methodDescription.getDeclaringType()))
/* 1504 */                 return MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous.of(harmonized, param5MethodDescription, this.methodDescription, visibility); 
/* 1505 */               return of(harmonized, param5MethodDescription, this.methodDescription, visibility);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param5Entry) {
/* 1512 */               if (this.methodDescription.getDeclaringType().isInterface()) {
/*      */                 LinkedHashSet<MethodDescription> linkedHashSet;
/* 1514 */                 (linkedHashSet = new LinkedHashSet<MethodDescription>()).add(this.methodDescription);
/* 1515 */                 TypeDescription typeDescription = this.methodDescription.getDeclaringType().asErasure();
/* 1516 */                 for (Iterator<MethodDescription> iterator = param5Entry.getCandidates().iterator(); iterator.hasNext(); ) {
/* 1517 */                   MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription)) {
/* 1518 */                     linkedHashSet.remove(this.methodDescription);
/* 1519 */                     linkedHashSet.add(methodDescription); continue;
/* 1520 */                   }  if (!methodDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
/* 1521 */                     linkedHashSet.add(methodDescription);
/*      */                   }
/*      */                 } 
/* 1524 */                 return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new Resolved(this.key
/* 1525 */                     .combineWith(param5Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param5Entry.getVisibility()), this.madeVisible) : new MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous<U>(this.key
/* 1526 */                     .combineWith(param5Entry.getKey()), linkedHashSet, this.visibility.expandTo(param5Entry.getVisibility())));
/*      */               } 
/* 1528 */               return new Resolved(this.key.combineWith(param5Entry.getKey()), this.methodDescription, this.visibility.expandTo(param5Entry.getVisibility()), this.madeVisible);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger) {
/* 1536 */               return new Node(this.key.detach(this.methodDescription.asTypeToken()), this.methodDescription, this.visibility, this.madeVisible);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : ((this.madeVisible != ((Resolved)param5Object).madeVisible) ? false : (!this.visibility.equals(((Resolved)param5Object).visibility) ? false : (!this.key.equals(((Resolved)param5Object).key) ? false : (!!this.methodDescription.equals(((Resolved)param5Object).methodDescription)))))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.madeVisible;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             @Enhance
/*      */             protected static class Node
/*      */               implements MethodGraph.Node
/*      */             {
/*      */               private final MethodGraph.Compiler.Default.Key.Detached key;
/*      */ 
/*      */               
/*      */               private final MethodDescription methodDescription;
/*      */ 
/*      */               
/*      */               private final Visibility visibility;
/*      */ 
/*      */               
/*      */               private final boolean visible;
/*      */ 
/*      */ 
/*      */               
/*      */               protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility, boolean param7Boolean) {
/* 1574 */                 this.key = param7Detached;
/* 1575 */                 this.methodDescription = param7MethodDescription;
/* 1576 */                 this.visibility = param7Visibility;
/* 1577 */                 this.visible = param7Boolean;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public MethodGraph.Node.Sort getSort() {
/* 1584 */                 return this.visible ? MethodGraph.Node.Sort.VISIBLE : MethodGraph.Node.Sort.RESOLVED;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public MethodDescription getRepresentative() {
/* 1593 */                 return this.methodDescription;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public Set<MethodDescription.TypeToken> getMethodTypes() {
/* 1600 */                 return this.key.getIdentifiers();
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*      */               public Visibility getVisibility()
/*      */               {
/* 1607 */                 return this.visibility; } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : ((this.visible != ((Node)param7Object).visible) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.visible; } } } protected static interface Entry<W> { MethodGraph.Compiler.Default.Key.Harmonized<W> getKey(); Set<MethodDescription> getCandidates(); Visibility getVisibility(); Entry<W> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<W> param5Harmonizer); Entry<W> inject(Entry<W> param5Entry); MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger); public static class Initial<U> implements Entry<U> { private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; protected Initial(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized) { this.key = param6Harmonized; } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { throw new IllegalStateException("Cannot extract key from initial entry:" + this); } public Set<MethodDescription> getCandidates() { throw new IllegalStateException("Cannot extract method from initial entry:" + this); } public Visibility getVisibility() { throw new IllegalStateException("Cannot extract visibility from initial entry:" + this); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param6MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param6Harmonizer) { return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key.extend((MethodDescription.InDefinedShape)param6MethodDescription.asDefined(), param6Harmonizer), param6MethodDescription, param6MethodDescription.getVisibility(), false); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param6Entry) { throw new IllegalStateException("Cannot inject into initial entry without a registered method: " + this); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param6Merger) { throw new IllegalStateException("Cannot transform initial entry without a registered method: " + this); } public int hashCode() { return this.key.hashCode(); } public boolean equals(@MaybeNull Object param6Object) { if (this == param6Object) return true;  if (param6Object == null || getClass() != param6Object.getClass()) return false;  param6Object = param6Object; return this.key.equals(((Initial)param6Object).key); } } @Enhance public static class Resolved<U> implements Entry<U> { private static final int MADE_VISIBLE = 5; private static final boolean NOT_MADE_VISIBLE = false; private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; private final MethodDescription methodDescription; private final Visibility visibility; private final boolean madeVisible; protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized, MethodDescription param6MethodDescription, Visibility param6Visibility) { this(param6Harmonized, param6MethodDescription, param6Visibility, false); } protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized, MethodDescription param6MethodDescription, Visibility param6Visibility, boolean param6Boolean) { this.key = param6Harmonized; this.methodDescription = param6MethodDescription; this.visibility = param6Visibility; this.madeVisible = param6Boolean; } private static <V> MethodGraph.Compiler.Default.Key.Store.Entry<V> of(MethodGraph.Compiler.Default.Key.Harmonized<V> param6Harmonized, MethodDescription param6MethodDescription1, MethodDescription param6MethodDescription2, Visibility param6Visibility) { param6Visibility = param6Visibility.expandTo(param6MethodDescription2.getVisibility()).expandTo(param6MethodDescription1.getVisibility()); return param6MethodDescription1.isBridge() ? new Resolved<V>(param6Harmonized, param6MethodDescription2, param6Visibility, ((param6MethodDescription2.getDeclaringType().getModifiers() & 0x5) == 0)) : new Resolved<V>(param6Harmonized, param6MethodDescription1, param6Visibility, false); } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { return this.key; } public Set<MethodDescription> getCandidates() { return Collections.singleton(this.methodDescription); } public Visibility getVisibility() { return this.visibility; } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param6MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param6Harmonizer) { MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param6MethodDescription.asDefined(), param6Harmonizer); Visibility visibility = this.visibility.expandTo(param6MethodDescription.getVisibility()); if (param6MethodDescription.getDeclaringType().equals(this.methodDescription.getDeclaringType())) return MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous.of(harmonized, param6MethodDescription, this.methodDescription, visibility);  return of(harmonized, param6MethodDescription, this.methodDescription, visibility); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param6Entry) { if (this.methodDescription.getDeclaringType().isInterface()) { LinkedHashSet<MethodDescription> linkedHashSet; (linkedHashSet = new LinkedHashSet<MethodDescription>()).add(this.methodDescription); TypeDescription typeDescription = this.methodDescription.getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator = param6Entry.getCandidates().iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription)) { linkedHashSet.remove(this.methodDescription); linkedHashSet.add(methodDescription); continue; }  if (!methodDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) linkedHashSet.add(methodDescription);  }  return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new Resolved(this.key.combineWith(param6Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param6Entry.getVisibility()), this.madeVisible) : new MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous<U>(this.key.combineWith(param6Entry.getKey()), linkedHashSet, this.visibility.expandTo(param6Entry.getVisibility()))); }  return new Resolved(this.key.combineWith(param6Entry.getKey()), this.methodDescription, this.visibility.expandTo(param6Entry.getVisibility()), this.madeVisible); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param6Merger) { return new Node(this.key.detach(this.methodDescription.asTypeToken()), this.methodDescription, this.visibility, this.madeVisible); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : ((this.madeVisible != ((Resolved)param6Object).madeVisible) ? false : (!this.visibility.equals(((Resolved)param6Object).visibility) ? false : (!this.key.equals(((Resolved)param6Object).key) ? false : (!!this.methodDescription.equals(((Resolved)param6Object).methodDescription))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.madeVisible; } @Enhance protected static class Node implements MethodGraph.Node { private final MethodGraph.Compiler.Default.Key.Detached key; private final MethodDescription methodDescription; private final Visibility visibility; private final boolean visible; protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility, boolean param7Boolean) { this.key = param7Detached; this.methodDescription = param7MethodDescription; this.visibility = param7Visibility; this.visible = param7Boolean; } public MethodGraph.Node.Sort getSort() { return this.visible ? MethodGraph.Node.Sort.VISIBLE : MethodGraph.Node.Sort.RESOLVED; } public MethodDescription getRepresentative() { return this.methodDescription; } public Set<MethodDescription.TypeToken> getMethodTypes() { return this.key.getIdentifiers(); } public Visibility getVisibility() { return this.visibility; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public boolean equals(@MaybeNull Object param7Object) {
/*      */                   return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : ((this.visible != ((Node)param7Object).visible) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription)))))));
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public int hashCode() {
/*      */                   return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.visible;
/*      */                 } }
/*      */                }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             @Enhance
/*      */             public static class Ambiguous<U>
/*      */               implements Entry<U>
/*      */             {
/*      */               private final MethodGraph.Compiler.Default.Key.Harmonized<U> key;
/*      */ 
/*      */               
/*      */               private final LinkedHashSet<MethodDescription> methodDescriptions;
/*      */ 
/*      */               
/*      */               private final Visibility visibility;
/*      */ 
/*      */ 
/*      */               
/*      */               protected Ambiguous(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized, LinkedHashSet<MethodDescription> param6LinkedHashSet, Visibility param6Visibility) {
/* 1643 */                 this.key = param6Harmonized;
/* 1644 */                 this.methodDescriptions = param6LinkedHashSet;
/* 1645 */                 this.visibility = param6Visibility;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected static <Q> MethodGraph.Compiler.Default.Key.Store.Entry<Q> of(MethodGraph.Compiler.Default.Key.Harmonized<Q> param6Harmonized, MethodDescription param6MethodDescription1, MethodDescription param6MethodDescription2, Visibility param6Visibility) {
/* 1659 */                 param6Visibility = param6Visibility.expandTo(param6MethodDescription1.getVisibility()).expandTo(param6MethodDescription2.getVisibility());
/* 1660 */                 return (MethodGraph.Compiler.Default.Key.Store.Entry<Q>)(((param6MethodDescription1.isBridge() ^ param6MethodDescription2.isBridge()) != 0) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<Q>(param6Harmonized, 
/* 1661 */                     param6MethodDescription1.isBridge() ? param6MethodDescription2 : param6MethodDescription1, param6Visibility, false) : new Ambiguous<Q>(param6Harmonized, new LinkedHashSet<MethodDescription>(
/* 1662 */                       Arrays.asList(new MethodDescription[] { param6MethodDescription1, param6MethodDescription2 }, )), param6Visibility));
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() {
/* 1669 */                 return this.key;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public Set<MethodDescription> getCandidates() {
/* 1676 */                 return this.methodDescriptions;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public Visibility getVisibility() {
/* 1683 */                 return this.visibility;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param6MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param6Harmonizer) {
/* 1690 */                 MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param6MethodDescription.asDefined(), param6Harmonizer);
/* 1691 */                 LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet();
/* 1692 */                 TypeDescription typeDescription = param6MethodDescription.getDeclaringType().asErasure();
/* 1693 */                 boolean bool = param6MethodDescription.isBridge();
/* 1694 */                 Visibility visibility = this.visibility;
/* 1695 */                 for (Iterator<MethodDescription> iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) {
/* 1696 */                   MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().equals(typeDescription)) {
/* 1697 */                     if (methodDescription.isBridge() ^ bool) {
/* 1698 */                       linkedHashSet.add(bool ? methodDescription : param6MethodDescription);
/*      */                     } else {
/* 1700 */                       linkedHashSet.add(param6MethodDescription);
/* 1701 */                       linkedHashSet.add(methodDescription);
/*      */                     } 
/*      */                   }
/* 1704 */                   visibility = visibility.expandTo(methodDescription.getVisibility());
/*      */                 } 
/* 1706 */                 if (linkedHashSet.isEmpty())
/* 1707 */                   return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, param6MethodDescription, visibility, bool); 
/* 1708 */                 if (linkedHashSet.size() == 1) {
/* 1709 */                   return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, linkedHashSet.iterator().next(), visibility, false);
/*      */                 }
/* 1711 */                 return new Ambiguous(harmonized, linkedHashSet, visibility);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param6Entry) {
/* 1719 */                 LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet();
/*      */                 Iterator<MethodDescription> iterator;
/* 1721 */                 label29: for (iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) {
/* 1722 */                   MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure();
/* 1723 */                   for (Iterator<MethodDescription> iterator1 = param6Entry.getCandidates().iterator(); iterator1.hasNext(); ) {
/*      */                     MethodDescription methodDescription1; TypeDescription typeDescription1;
/* 1725 */                     if ((typeDescription1 = (methodDescription1 = iterator1.next()).getDeclaringType().asErasure()).equals(typeDescription) || !typeDescription1.isAssignableTo(typeDescription))
/*      */                       continue; 
/*      */                     continue label29;
/*      */                   } 
/* 1729 */                   linkedHashSet.add(methodDescription);
/*      */                 } 
/*      */                 
/* 1732 */                 label28: for (iterator = param6Entry.getCandidates().iterator(); iterator.hasNext(); ) {
/* 1733 */                   MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure();
/* 1734 */                   for (Iterator<MethodDescription> iterator1 = this.methodDescriptions.iterator(); iterator1.hasNext(); ) {
/* 1735 */                     MethodDescription methodDescription1; if (!(methodDescription1 = iterator1.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription))
/*      */                       continue; 
/*      */                     continue label28;
/*      */                   } 
/* 1739 */                   linkedHashSet.add(methodDescription);
/*      */                 } 
/* 1741 */                 return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key
/* 1742 */                     .combineWith(param6Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param6Entry.getVisibility())) : new Ambiguous(this.key
/* 1743 */                     .combineWith(param6Entry.getKey()), linkedHashSet, this.visibility.expandTo(param6Entry.getVisibility())));
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param6Merger) {
/*      */                 Iterator<MethodDescription> iterator;
/* 1751 */                 MethodDescription methodDescription = (iterator = this.methodDescriptions.iterator()).next();
/* 1752 */                 while (iterator.hasNext()) {
/* 1753 */                   methodDescription = param6Merger.merge(methodDescription, iterator.next());
/*      */                 }
/* 1755 */                 return new Node(this.key.detach(methodDescription.asTypeToken()), methodDescription, this.visibility);
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*      */               public boolean equals(@MaybeNull Object param6Object) {
/*      */                 return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!this.visibility.equals(((Ambiguous)param6Object).visibility) ? false : (!this.key.equals(((Ambiguous)param6Object).key) ? false : (!!this.methodDescriptions.equals(((Ambiguous)param6Object).methodDescriptions))))));
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*      */               public int hashCode() {
/*      */                 return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescriptions.hashCode()) * 31 + this.visibility.hashCode();
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*      */               @Enhance
/*      */               protected static class Node
/*      */                 implements MethodGraph.Node
/*      */               {
/*      */                 private final MethodGraph.Compiler.Default.Key.Detached key;
/*      */ 
/*      */                 
/*      */                 private final MethodDescription methodDescription;
/*      */                 
/*      */                 private final Visibility visibility;
/*      */ 
/*      */                 
/*      */                 protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility) {
/* 1785 */                   this.key = param7Detached;
/* 1786 */                   this.methodDescription = param7MethodDescription;
/* 1787 */                   this.visibility = param7Visibility;
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public MethodGraph.Node.Sort getSort() {
/* 1794 */                   return MethodGraph.Node.Sort.AMBIGUOUS;
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public MethodDescription getRepresentative() {
/* 1801 */                   return this.methodDescription;
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public Set<MethodDescription.TypeToken> getMethodTypes() {
/* 1808 */                   return this.key.getIdentifiers();
/*      */                 }
/*      */ 
/*      */ 
/*      */                 
/*      */                 public Visibility getVisibility()
/*      */                 {
/* 1815 */                   return this.visibility; } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode(); } } } } @Enhance public static class Ambiguous<U> implements Entry<U> { private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; private final LinkedHashSet<MethodDescription> methodDescriptions; private final Visibility visibility; protected Ambiguous(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized, LinkedHashSet<MethodDescription> param5LinkedHashSet, Visibility param5Visibility) { this.key = param5Harmonized; this.methodDescriptions = param5LinkedHashSet; this.visibility = param5Visibility; } protected static <Q> MethodGraph.Compiler.Default.Key.Store.Entry<Q> of(MethodGraph.Compiler.Default.Key.Harmonized<Q> param5Harmonized, MethodDescription param5MethodDescription1, MethodDescription param5MethodDescription2, Visibility param5Visibility) { param5Visibility = param5Visibility.expandTo(param5MethodDescription1.getVisibility()).expandTo(param5MethodDescription2.getVisibility()); return (MethodGraph.Compiler.Default.Key.Store.Entry<Q>)(((param5MethodDescription1.isBridge() ^ param5MethodDescription2.isBridge()) != 0) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<Q>(param5Harmonized, param5MethodDescription1.isBridge() ? param5MethodDescription2 : param5MethodDescription1, param5Visibility, false) : new Ambiguous<Q>(param5Harmonized, new LinkedHashSet<MethodDescription>(Arrays.asList(new MethodDescription[] { param5MethodDescription1, param5MethodDescription2 }, )), param5Visibility)); } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { return this.key; } public Set<MethodDescription> getCandidates() { return this.methodDescriptions; } public Visibility getVisibility() { return this.visibility; } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param5Harmonizer) { MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param5MethodDescription.asDefined(), param5Harmonizer); LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet(); TypeDescription typeDescription = param5MethodDescription.getDeclaringType().asErasure(); boolean bool = param5MethodDescription.isBridge(); Visibility visibility = this.visibility; for (Iterator<MethodDescription> iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().equals(typeDescription)) if (methodDescription.isBridge() ^ bool) { linkedHashSet.add(bool ? methodDescription : param5MethodDescription); } else { linkedHashSet.add(param5MethodDescription); linkedHashSet.add(methodDescription); }   visibility = visibility.expandTo(methodDescription.getVisibility()); }  if (linkedHashSet.isEmpty()) return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, param5MethodDescription, visibility, bool);  if (linkedHashSet.size() == 1) return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, linkedHashSet.iterator().next(), visibility, false);  return new Ambiguous(harmonized, linkedHashSet, visibility); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param5Entry) { LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet(); Iterator<MethodDescription> iterator; label29: for (iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator1 = param5Entry.getCandidates().iterator(); iterator1.hasNext(); ) { TypeDescription typeDescription1; MethodDescription methodDescription1; if ((typeDescription1 = (methodDescription1 = iterator1.next()).getDeclaringType().asErasure()).equals(typeDescription) || !typeDescription1.isAssignableTo(typeDescription)) continue;  continue label29; }  linkedHashSet.add(methodDescription); }  label28: for (iterator = param5Entry.getCandidates().iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator1 = this.methodDescriptions.iterator(); iterator1.hasNext(); ) { MethodDescription methodDescription1; if (!(methodDescription1 = iterator1.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription)) continue;  continue label28; }  linkedHashSet.add(methodDescription); }  return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key.combineWith(param5Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param5Entry.getVisibility())) : new Ambiguous(this.key.combineWith(param5Entry.getKey()), linkedHashSet, this.visibility.expandTo(param5Entry.getVisibility()))); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger) { Iterator<MethodDescription> iterator; MethodDescription methodDescription = (iterator = this.methodDescriptions.iterator()).next(); while (iterator.hasNext()) methodDescription = param5Merger.merge(methodDescription, iterator.next());  return new Node(this.key.detach(methodDescription.asTypeToken()), methodDescription, this.visibility); } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.visibility.equals(((Ambiguous)param5Object).visibility) ? false : (!this.key.equals(((Ambiguous)param5Object).key) ? false : (!!this.methodDescriptions.equals(((Ambiguous)param5Object).methodDescriptions)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescriptions.hashCode()) * 31 + this.visibility.hashCode(); } @Enhance protected static class Node implements MethodGraph.Node { private final MethodGraph.Compiler.Default.Key.Detached key; private final MethodDescription methodDescription; private final Visibility visibility; protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility) { this.key = param7Detached; this.methodDescription = param7MethodDescription; this.visibility = param7Visibility; } public MethodGraph.Node.Sort getSort() { return MethodGraph.Node.Sort.AMBIGUOUS; } public MethodDescription getRepresentative() { return this.methodDescription; } public Set<MethodDescription.TypeToken> getMethodTypes() { return this.key.getIdentifiers(); } public Visibility getVisibility() { return this.visibility; }
/*      */ 
/*      */ 
/*      */               
/*      */               public boolean equals(@MaybeNull Object param7Object) {
/*      */                 return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription))))));
/*      */               }
/*      */ 
/*      */               
/*      */               public int hashCode() {
/*      */                 return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode();
/*      */               } }
/*      */              }
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           protected static class Graph
/*      */             implements MethodGraph
/*      */           {
/*      */             private final LinkedHashMap<MethodGraph.Compiler.Default.Key<MethodDescription.TypeToken>, MethodGraph.Node> entries;
/*      */             
/*      */             protected Graph(LinkedHashMap<MethodGraph.Compiler.Default.Key<MethodDescription.TypeToken>, MethodGraph.Node> param5LinkedHashMap) {
/* 1838 */               this.entries = param5LinkedHashMap;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public MethodGraph.Node locate(MethodDescription.SignatureToken param5SignatureToken) {
/*      */               MethodGraph.Node node;
/* 1846 */               return ((node = this.entries.get(MethodGraph.Compiler.Default.Key.Detached.of(param5SignatureToken))) == null) ? MethodGraph.Node.Unresolved.INSTANCE : node;
/*      */             }
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.entries.equals(((Graph)param5Object).entries))));
/*      */             }
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.entries.hashCode();
/*      */             }
/*      */             
/* 1855 */             public MethodGraph.NodeList listNodes() { return new MethodGraph.NodeList(new ArrayList<MethodGraph.Node>(this.entries.values())); } } } } @Enhance protected static class Store<V> { private final LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> entries; protected Store() { this(new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>()); } private Store(LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> param3LinkedHashMap) { this.entries = param3LinkedHashMap; } private static <W> Entry<W> combine(Entry<W> param3Entry1, Entry<W> param3Entry2) { Set<MethodDescription> set1 = param3Entry1.getCandidates(), set2 = param3Entry2.getCandidates(); LinkedHashSet<MethodDescription> linkedHashSet; (linkedHashSet = new LinkedHashSet<MethodDescription>()).addAll(set1); linkedHashSet.addAll(set2); for (Iterator<MethodDescription> iterator = set1.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator1 = set2.iterator(); iterator1.hasNext(); ) { MethodDescription methodDescription1; TypeDescription typeDescription1 = (methodDescription1 = iterator1.next()).getDeclaringType().asErasure(); if (!typeDescription.equals(typeDescription1)) { if (typeDescription.isAssignableTo(typeDescription1)) { linkedHashSet.remove(methodDescription1); break; }  if (typeDescription.isAssignableFrom(typeDescription1)) linkedHashSet.remove(methodDescription);  }  }  }  MethodGraph.Compiler.Default.Key.Harmonized<W> harmonized = param3Entry1.getKey().combineWith(param3Entry2.getKey()); Visibility visibility = param3Entry1.getVisibility().expandTo(param3Entry2.getVisibility()); return (Entry<W>)((linkedHashSet.size() == 1) ? new Entry.Resolved<W>(harmonized, linkedHashSet.iterator().next(), visibility, false) : new Entry.Ambiguous<W>(harmonized, linkedHashSet, visibility)); } protected Store<V> registerTopLevel(List<? extends MethodDescription> param3List, MethodGraph.Compiler.Default.Harmonizer<V> param3Harmonizer) { if (param3List.isEmpty()) return this;  LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> linkedHashMap = new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>(this.entries); for (Iterator<? extends MethodDescription> iterator = param3List.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; MethodGraph.Compiler.Default.Key.Harmonized<V> harmonized = MethodGraph.Compiler.Default.Key.Harmonized.of(methodDescription = iterator.next(), param3Harmonizer); Entry<V> entry2, entry1 = (((entry2 = (Entry)linkedHashMap.remove(harmonized)) == null) ? new Entry.Initial<V>(harmonized) : entry2).extendBy(methodDescription, param3Harmonizer); linkedHashMap.put(entry1.getKey(), entry1); }  return new Store(linkedHashMap); } protected Store<V> combineWith(Store<V> param3Store) { if (this.entries.isEmpty()) return param3Store;  if (param3Store.entries.isEmpty()) return this;  LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> linkedHashMap = new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>(this.entries); for (Entry<?> entry1 : param3Store.entries.values()) { Entry<?> entry2; entry1 = ((entry2 = linkedHashMap.remove(entry1.getKey())) == null) ? entry1 : combine(entry2, entry1); linkedHashMap.put((MethodGraph.Compiler.Default.Key.Harmonized)entry1.getKey(), entry1); }  return new Store(linkedHashMap); } protected Store<V> inject(Store<V> param3Store) { if (this.entries.isEmpty()) return param3Store;  if (param3Store.entries.isEmpty()) return this;  LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>> linkedHashMap = new LinkedHashMap<MethodGraph.Compiler.Default.Key.Harmonized<V>, Entry<V>>(this.entries); for (Entry<V> entry : param3Store.entries.values()) { Entry entry1; entry = ((entry1 = linkedHashMap.remove(entry.getKey())) == null) ? entry : entry1.inject(entry); linkedHashMap.put(entry.getKey(), entry); }  return new Store(linkedHashMap); } protected MethodGraph asGraph(MethodGraph.Compiler.Default.Merger param3Merger) { LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(); for (Iterator<Entry> iterator = this.entries.values().iterator(); iterator.hasNext(); ) { Entry<?> entry; MethodGraph.Node node = (entry = iterator.next()).asNode(param3Merger); linkedHashMap.put(entry.getKey().detach(node.getRepresentative().asTypeToken()), node); }  return new Graph((LinkedHashMap)linkedHashMap); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.entries.equals(((Store)param3Object).entries)))); } public int hashCode() { return getClass().hashCode() * 31 + this.entries.hashCode(); } public static class Initial<U> implements Entry<U> { private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; protected Initial(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized) { this.key = param5Harmonized; } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { throw new IllegalStateException("Cannot extract key from initial entry:" + this); } public Set<MethodDescription> getCandidates() { throw new IllegalStateException("Cannot extract method from initial entry:" + this); } public Visibility getVisibility() { throw new IllegalStateException("Cannot extract visibility from initial entry:" + this); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param5Harmonizer) { return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key.extend((MethodDescription.InDefinedShape)param5MethodDescription.asDefined(), param5Harmonizer), param5MethodDescription, param5MethodDescription.getVisibility(), false); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param5Entry) { throw new IllegalStateException("Cannot inject into initial entry without a registered method: " + this); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger) { throw new IllegalStateException("Cannot transform initial entry without a registered method: " + this); } public int hashCode() { return this.key.hashCode(); } public boolean equals(@MaybeNull Object param5Object) { if (this == param5Object) return true;  if (param5Object == null || getClass() != param5Object.getClass()) return false;  param5Object = param5Object; return this.key.equals(((Initial)param5Object).key); } } @Enhance public static class Resolved<U> implements Entry<U> { private static final int MADE_VISIBLE = 5; private static final boolean NOT_MADE_VISIBLE = false; private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; private final MethodDescription methodDescription; private final Visibility visibility; private final boolean madeVisible; protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized, MethodDescription param5MethodDescription, Visibility param5Visibility) { this(param5Harmonized, param5MethodDescription, param5Visibility, false); } protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized, MethodDescription param5MethodDescription, Visibility param5Visibility, boolean param5Boolean) { this.key = param5Harmonized; this.methodDescription = param5MethodDescription; this.visibility = param5Visibility; this.madeVisible = param5Boolean; } private static <V> MethodGraph.Compiler.Default.Key.Store.Entry<V> of(MethodGraph.Compiler.Default.Key.Harmonized<V> param5Harmonized, MethodDescription param5MethodDescription1, MethodDescription param5MethodDescription2, Visibility param5Visibility) { param5Visibility = param5Visibility.expandTo(param5MethodDescription2.getVisibility()).expandTo(param5MethodDescription1.getVisibility()); return param5MethodDescription1.isBridge() ? new Resolved<V>(param5Harmonized, param5MethodDescription2, param5Visibility, ((param5MethodDescription2.getDeclaringType().getModifiers() & 0x5) == 0)) : new Resolved<V>(param5Harmonized, param5MethodDescription1, param5Visibility, false); } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { return this.key; } public Set<MethodDescription> getCandidates() { return Collections.singleton(this.methodDescription); } public Visibility getVisibility() { return this.visibility; } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param5Harmonizer) { MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param5MethodDescription.asDefined(), param5Harmonizer); Visibility visibility = this.visibility.expandTo(param5MethodDescription.getVisibility()); if (param5MethodDescription.getDeclaringType().equals(this.methodDescription.getDeclaringType())) return MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous.of(harmonized, param5MethodDescription, this.methodDescription, visibility);  return of(harmonized, param5MethodDescription, this.methodDescription, visibility); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param5Entry) { if (this.methodDescription.getDeclaringType().isInterface()) { LinkedHashSet<MethodDescription> linkedHashSet; (linkedHashSet = new LinkedHashSet<MethodDescription>()).add(this.methodDescription); TypeDescription typeDescription = this.methodDescription.getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator = param5Entry.getCandidates().iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription)) { linkedHashSet.remove(this.methodDescription); linkedHashSet.add(methodDescription); continue; }  if (!methodDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) linkedHashSet.add(methodDescription);  }  return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new Resolved(this.key.combineWith(param5Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param5Entry.getVisibility()), this.madeVisible) : new MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous<U>(this.key.combineWith(param5Entry.getKey()), linkedHashSet, this.visibility.expandTo(param5Entry.getVisibility()))); }  return new Resolved(this.key.combineWith(param5Entry.getKey()), this.methodDescription, this.visibility.expandTo(param5Entry.getVisibility()), this.madeVisible); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger) { return new Node(this.key.detach(this.methodDescription.asTypeToken()), this.methodDescription, this.visibility, this.madeVisible); } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : ((this.madeVisible != ((Resolved)param5Object).madeVisible) ? false : (!this.visibility.equals(((Resolved)param5Object).visibility) ? false : (!this.key.equals(((Resolved)param5Object).key) ? false : (!!this.methodDescription.equals(((Resolved)param5Object).methodDescription))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.madeVisible; } @Enhance protected static class Node implements MethodGraph.Node { private final MethodGraph.Compiler.Default.Key.Detached key; private final MethodDescription methodDescription; private final Visibility visibility; private final boolean visible; protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility, boolean param7Boolean) { this.key = param7Detached; this.methodDescription = param7MethodDescription; this.visibility = param7Visibility; this.visible = param7Boolean; } public MethodGraph.Node.Sort getSort() { return this.visible ? MethodGraph.Node.Sort.VISIBLE : MethodGraph.Node.Sort.RESOLVED; } public MethodDescription getRepresentative() { return this.methodDescription; } public Set<MethodDescription.TypeToken> getMethodTypes() { return this.key.getIdentifiers(); } public Visibility getVisibility() { return this.visibility; } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : ((this.visible != ((Node)param7Object).visible) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.visible; } } } protected static interface Entry<W> { MethodGraph.Compiler.Default.Key.Harmonized<W> getKey(); Set<MethodDescription> getCandidates(); Visibility getVisibility(); Entry<W> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<W> param5Harmonizer); Entry<W> inject(Entry<W> param5Entry); MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger); public static class Initial<U> implements Entry<U> { private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; protected Initial(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized) { this.key = param6Harmonized; } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { throw new IllegalStateException("Cannot extract key from initial entry:" + this); } public Set<MethodDescription> getCandidates() { throw new IllegalStateException("Cannot extract method from initial entry:" + this); } public Visibility getVisibility() { throw new IllegalStateException("Cannot extract visibility from initial entry:" + this); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param6MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param6Harmonizer) { return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key.extend((MethodDescription.InDefinedShape)param6MethodDescription.asDefined(), param6Harmonizer), param6MethodDescription, param6MethodDescription.getVisibility(), false); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param6Entry) { throw new IllegalStateException("Cannot inject into initial entry without a registered method: " + this); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param6Merger) { throw new IllegalStateException("Cannot transform initial entry without a registered method: " + this); } public int hashCode() { return this.key.hashCode(); } public boolean equals(@MaybeNull Object param6Object) { if (this == param6Object) return true;  if (param6Object == null || getClass() != param6Object.getClass()) return false;  param6Object = param6Object; return this.key.equals(((Initial)param6Object).key); } } @Enhance public static class Resolved<U> implements Entry<U> { private static final int MADE_VISIBLE = 5; private static final boolean NOT_MADE_VISIBLE = false; private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; private final MethodDescription methodDescription; private final Visibility visibility; private final boolean madeVisible; protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized, MethodDescription param6MethodDescription, Visibility param6Visibility) { this(param6Harmonized, param6MethodDescription, param6Visibility, false); } protected Resolved(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized, MethodDescription param6MethodDescription, Visibility param6Visibility, boolean param6Boolean) { this.key = param6Harmonized; this.methodDescription = param6MethodDescription; this.visibility = param6Visibility; this.madeVisible = param6Boolean; } private static <V> MethodGraph.Compiler.Default.Key.Store.Entry<V> of(MethodGraph.Compiler.Default.Key.Harmonized<V> param6Harmonized, MethodDescription param6MethodDescription1, MethodDescription param6MethodDescription2, Visibility param6Visibility) { param6Visibility = param6Visibility.expandTo(param6MethodDescription2.getVisibility()).expandTo(param6MethodDescription1.getVisibility()); return param6MethodDescription1.isBridge() ? new Resolved<V>(param6Harmonized, param6MethodDescription2, param6Visibility, ((param6MethodDescription2.getDeclaringType().getModifiers() & 0x5) == 0)) : new Resolved<V>(param6Harmonized, param6MethodDescription1, param6Visibility, false); } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { return this.key; } public Set<MethodDescription> getCandidates() { return Collections.singleton(this.methodDescription); } public Visibility getVisibility() { return this.visibility; } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param6MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param6Harmonizer) { MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param6MethodDescription.asDefined(), param6Harmonizer); Visibility visibility = this.visibility.expandTo(param6MethodDescription.getVisibility()); if (param6MethodDescription.getDeclaringType().equals(this.methodDescription.getDeclaringType())) return MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous.of(harmonized, param6MethodDescription, this.methodDescription, visibility);  return of(harmonized, param6MethodDescription, this.methodDescription, visibility); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param6Entry) { if (this.methodDescription.getDeclaringType().isInterface()) { LinkedHashSet<MethodDescription> linkedHashSet; (linkedHashSet = new LinkedHashSet<MethodDescription>()).add(this.methodDescription); TypeDescription typeDescription = this.methodDescription.getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator = param6Entry.getCandidates().iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription)) { linkedHashSet.remove(this.methodDescription); linkedHashSet.add(methodDescription); continue; }  if (!methodDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) linkedHashSet.add(methodDescription);  }  return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new Resolved(this.key.combineWith(param6Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param6Entry.getVisibility()), this.madeVisible) : new MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous<U>(this.key.combineWith(param6Entry.getKey()), linkedHashSet, this.visibility.expandTo(param6Entry.getVisibility()))); }  return new Resolved(this.key.combineWith(param6Entry.getKey()), this.methodDescription, this.visibility.expandTo(param6Entry.getVisibility()), this.madeVisible); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param6Merger) { return new Node(this.key.detach(this.methodDescription.asTypeToken()), this.methodDescription, this.visibility, this.madeVisible); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : ((this.madeVisible != ((Resolved)param6Object).madeVisible) ? false : (!this.visibility.equals(((Resolved)param6Object).visibility) ? false : (!this.key.equals(((Resolved)param6Object).key) ? false : (!!this.methodDescription.equals(((Resolved)param6Object).methodDescription))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.madeVisible; } @Enhance protected static class Node implements MethodGraph.Node { private final MethodGraph.Compiler.Default.Key.Detached key; private final MethodDescription methodDescription; private final Visibility visibility; private final boolean visible; protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility, boolean param7Boolean) { this.key = param7Detached; this.methodDescription = param7MethodDescription; this.visibility = param7Visibility; this.visible = param7Boolean; } public MethodGraph.Node.Sort getSort() { return this.visible ? MethodGraph.Node.Sort.VISIBLE : MethodGraph.Node.Sort.RESOLVED; } public MethodDescription getRepresentative() { return this.methodDescription; } public Set<MethodDescription.TypeToken> getMethodTypes() { return this.key.getIdentifiers(); } public Visibility getVisibility() { return this.visibility; } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : ((this.visible != ((Node)param7Object).visible) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.visible; } } } @Enhance public static class Ambiguous<U> implements Entry<U> { private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; private final LinkedHashSet<MethodDescription> methodDescriptions; private final Visibility visibility; protected Ambiguous(MethodGraph.Compiler.Default.Key.Harmonized<U> param6Harmonized, LinkedHashSet<MethodDescription> param6LinkedHashSet, Visibility param6Visibility) { this.key = param6Harmonized; this.methodDescriptions = param6LinkedHashSet; this.visibility = param6Visibility; } protected static <Q> MethodGraph.Compiler.Default.Key.Store.Entry<Q> of(MethodGraph.Compiler.Default.Key.Harmonized<Q> param6Harmonized, MethodDescription param6MethodDescription1, MethodDescription param6MethodDescription2, Visibility param6Visibility) { param6Visibility = param6Visibility.expandTo(param6MethodDescription1.getVisibility()).expandTo(param6MethodDescription2.getVisibility()); return (MethodGraph.Compiler.Default.Key.Store.Entry<Q>)(((param6MethodDescription1.isBridge() ^ param6MethodDescription2.isBridge()) != 0) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<Q>(param6Harmonized, param6MethodDescription1.isBridge() ? param6MethodDescription2 : param6MethodDescription1, param6Visibility, false) : new Ambiguous<Q>(param6Harmonized, new LinkedHashSet<MethodDescription>(Arrays.asList(new MethodDescription[] { param6MethodDescription1, param6MethodDescription2 }, )), param6Visibility)); } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { return this.key; } public Set<MethodDescription> getCandidates() { return this.methodDescriptions; } public Visibility getVisibility() { return this.visibility; } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param6MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param6Harmonizer) { MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param6MethodDescription.asDefined(), param6Harmonizer); LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet(); TypeDescription typeDescription = param6MethodDescription.getDeclaringType().asErasure(); boolean bool = param6MethodDescription.isBridge(); Visibility visibility = this.visibility; for (Iterator<MethodDescription> iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().equals(typeDescription)) if (methodDescription.isBridge() ^ bool) { linkedHashSet.add(bool ? methodDescription : param6MethodDescription); } else { linkedHashSet.add(param6MethodDescription); linkedHashSet.add(methodDescription); }   visibility = visibility.expandTo(methodDescription.getVisibility()); }  if (linkedHashSet.isEmpty()) return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, param6MethodDescription, visibility, bool);  if (linkedHashSet.size() == 1) return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, linkedHashSet.iterator().next(), visibility, false);  return new Ambiguous(harmonized, linkedHashSet, visibility); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param6Entry) { LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet(); Iterator<MethodDescription> iterator; label29: for (iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator1 = param6Entry.getCandidates().iterator(); iterator1.hasNext(); ) { MethodDescription methodDescription1; TypeDescription typeDescription1; if ((typeDescription1 = (methodDescription1 = iterator1.next()).getDeclaringType().asErasure()).equals(typeDescription) || !typeDescription1.isAssignableTo(typeDescription)) continue;  continue label29; }  linkedHashSet.add(methodDescription); }  label28: for (iterator = param6Entry.getCandidates().iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator1 = this.methodDescriptions.iterator(); iterator1.hasNext(); ) { MethodDescription methodDescription1; if (!(methodDescription1 = iterator1.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription)) continue;  continue label28; }  linkedHashSet.add(methodDescription); }  return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key.combineWith(param6Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param6Entry.getVisibility())) : new Ambiguous(this.key.combineWith(param6Entry.getKey()), linkedHashSet, this.visibility.expandTo(param6Entry.getVisibility()))); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param6Merger) { Iterator<MethodDescription> iterator; MethodDescription methodDescription = (iterator = this.methodDescriptions.iterator()).next(); while (iterator.hasNext()) methodDescription = param6Merger.merge(methodDescription, iterator.next());  return new Node(this.key.detach(methodDescription.asTypeToken()), methodDescription, this.visibility); } public boolean equals(@MaybeNull Object param6Object) { return (this == param6Object) ? true : ((param6Object == null) ? false : ((getClass() != param6Object.getClass()) ? false : (!this.visibility.equals(((Ambiguous)param6Object).visibility) ? false : (!this.key.equals(((Ambiguous)param6Object).key) ? false : (!!this.methodDescriptions.equals(((Ambiguous)param6Object).methodDescriptions)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescriptions.hashCode()) * 31 + this.visibility.hashCode(); } @Enhance protected static class Node implements MethodGraph.Node { private final MethodGraph.Compiler.Default.Key.Detached key; private final MethodDescription methodDescription; private final Visibility visibility; protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility) { this.key = param7Detached; this.methodDescription = param7MethodDescription; this.visibility = param7Visibility; } public MethodGraph.Node.Sort getSort() { return MethodGraph.Node.Sort.AMBIGUOUS; } public MethodDescription getRepresentative() { return this.methodDescription; } public Set<MethodDescription.TypeToken> getMethodTypes() { return this.key.getIdentifiers(); } public Visibility getVisibility() { return this.visibility; } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode(); } } } } @Enhance public static class Ambiguous<U> implements Entry<U> { private final MethodGraph.Compiler.Default.Key.Harmonized<U> key; private final LinkedHashSet<MethodDescription> methodDescriptions; private final Visibility visibility; protected Ambiguous(MethodGraph.Compiler.Default.Key.Harmonized<U> param5Harmonized, LinkedHashSet<MethodDescription> param5LinkedHashSet, Visibility param5Visibility) { this.key = param5Harmonized; this.methodDescriptions = param5LinkedHashSet; this.visibility = param5Visibility; } protected static <Q> MethodGraph.Compiler.Default.Key.Store.Entry<Q> of(MethodGraph.Compiler.Default.Key.Harmonized<Q> param5Harmonized, MethodDescription param5MethodDescription1, MethodDescription param5MethodDescription2, Visibility param5Visibility) { param5Visibility = param5Visibility.expandTo(param5MethodDescription1.getVisibility()).expandTo(param5MethodDescription2.getVisibility()); return (MethodGraph.Compiler.Default.Key.Store.Entry<Q>)(((param5MethodDescription1.isBridge() ^ param5MethodDescription2.isBridge()) != 0) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<Q>(param5Harmonized, param5MethodDescription1.isBridge() ? param5MethodDescription2 : param5MethodDescription1, param5Visibility, false) : new Ambiguous<Q>(param5Harmonized, new LinkedHashSet<MethodDescription>(Arrays.asList(new MethodDescription[] { param5MethodDescription1, param5MethodDescription2 }, )), param5Visibility)); } public MethodGraph.Compiler.Default.Key.Harmonized<U> getKey() { return this.key; } public Set<MethodDescription> getCandidates() { return this.methodDescriptions; } public Visibility getVisibility() { return this.visibility; } public MethodGraph.Compiler.Default.Key.Store.Entry<U> extendBy(MethodDescription param5MethodDescription, MethodGraph.Compiler.Default.Harmonizer<U> param5Harmonizer) { MethodGraph.Compiler.Default.Key.Harmonized<U> harmonized = this.key.extend((MethodDescription.InDefinedShape)param5MethodDescription.asDefined(), param5Harmonizer); LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet(); TypeDescription typeDescription = param5MethodDescription.getDeclaringType().asErasure(); boolean bool = param5MethodDescription.isBridge(); Visibility visibility = this.visibility; for (Iterator<MethodDescription> iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; if ((methodDescription = iterator.next()).getDeclaringType().asErasure().equals(typeDescription)) if (methodDescription.isBridge() ^ bool) { linkedHashSet.add(bool ? methodDescription : param5MethodDescription); } else { linkedHashSet.add(param5MethodDescription); linkedHashSet.add(methodDescription); }   visibility = visibility.expandTo(methodDescription.getVisibility()); }  if (linkedHashSet.isEmpty()) return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, param5MethodDescription, visibility, bool);  if (linkedHashSet.size() == 1) return new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(harmonized, linkedHashSet.iterator().next(), visibility, false);  return new Ambiguous(harmonized, linkedHashSet, visibility); } public MethodGraph.Compiler.Default.Key.Store.Entry<U> inject(MethodGraph.Compiler.Default.Key.Store.Entry<U> param5Entry) { LinkedHashSet<MethodDescription> linkedHashSet = new LinkedHashSet(); Iterator<MethodDescription> iterator; label29: for (iterator = this.methodDescriptions.iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator1 = param5Entry.getCandidates().iterator(); iterator1.hasNext(); ) { TypeDescription typeDescription1; MethodDescription methodDescription1; if ((typeDescription1 = (methodDescription1 = iterator1.next()).getDeclaringType().asErasure()).equals(typeDescription) || !typeDescription1.isAssignableTo(typeDescription)) continue;  continue label29; }  linkedHashSet.add(methodDescription); }  label28: for (iterator = param5Entry.getCandidates().iterator(); iterator.hasNext(); ) { MethodDescription methodDescription; TypeDescription typeDescription = (methodDescription = iterator.next()).getDeclaringType().asErasure(); for (Iterator<MethodDescription> iterator1 = this.methodDescriptions.iterator(); iterator1.hasNext(); ) { MethodDescription methodDescription1; if (!(methodDescription1 = iterator1.next()).getDeclaringType().asErasure().isAssignableTo(typeDescription)) continue;  continue label28; }  linkedHashSet.add(methodDescription); }  return (MethodGraph.Compiler.Default.Key.Store.Entry<U>)((linkedHashSet.size() == 1) ? new MethodGraph.Compiler.Default.Key.Store.Entry.Resolved<U>(this.key.combineWith(param5Entry.getKey()), linkedHashSet.iterator().next(), this.visibility.expandTo(param5Entry.getVisibility())) : new Ambiguous(this.key.combineWith(param5Entry.getKey()), linkedHashSet, this.visibility.expandTo(param5Entry.getVisibility()))); } public MethodGraph.Node asNode(MethodGraph.Compiler.Default.Merger param5Merger) { Iterator<MethodDescription> iterator; MethodDescription methodDescription = (iterator = this.methodDescriptions.iterator()).next(); while (iterator.hasNext()) methodDescription = param5Merger.merge(methodDescription, iterator.next());  return new Node(this.key.detach(methodDescription.asTypeToken()), methodDescription, this.visibility); } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.visibility.equals(((Ambiguous)param5Object).visibility) ? false : (!this.key.equals(((Ambiguous)param5Object).key) ? false : (!!this.methodDescriptions.equals(((Ambiguous)param5Object).methodDescriptions)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescriptions.hashCode()) * 31 + this.visibility.hashCode(); } @Enhance protected static class Node implements MethodGraph.Node { private final MethodGraph.Compiler.Default.Key.Detached key; private final MethodDescription methodDescription; private final Visibility visibility; protected Node(MethodGraph.Compiler.Default.Key.Detached param7Detached, MethodDescription param7MethodDescription, Visibility param7Visibility) { this.key = param7Detached; this.methodDescription = param7MethodDescription; this.visibility = param7Visibility; } public MethodGraph.Node.Sort getSort() { return MethodGraph.Node.Sort.AMBIGUOUS; } public MethodDescription getRepresentative() { return this.methodDescription; } public Set<MethodDescription.TypeToken> getMethodTypes() { return this.key.getIdentifiers(); } public Visibility getVisibility() { return this.visibility; } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!this.visibility.equals(((Node)param7Object).visibility) ? false : (!this.key.equals(((Node)param7Object).key) ? false : (!!this.methodDescription.equals(((Node)param7Object).methodDescription)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.key.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.visibility.hashCode(); } } } @Enhance protected static class Graph implements MethodGraph { public MethodGraph.NodeList listNodes() { return new MethodGraph.NodeList(new ArrayList<MethodGraph.Node>(this.entries.values())); }
/*      */           
/*      */           private final LinkedHashMap<MethodGraph.Compiler.Default.Key<MethodDescription.TypeToken>, MethodGraph.Node> entries;
/*      */           
/*      */           protected Graph(LinkedHashMap<MethodGraph.Compiler.Default.Key<MethodDescription.TypeToken>, MethodGraph.Node> param5LinkedHashMap) {
/*      */             this.entries = param5LinkedHashMap;
/*      */           }
/*      */           
/*      */           public MethodGraph.Node locate(MethodDescription.SignatureToken param5SignatureToken) {
/*      */             MethodGraph.Node node;
/*      */             return ((node = this.entries.get(MethodGraph.Compiler.Default.Key.Detached.of(param5SignatureToken))) == null) ? MethodGraph.Node.Unresolved.INSTANCE : node;
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param5Object) {
/*      */             return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.entries.equals(((Graph)param5Object).entries))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.entries.hashCode();
/*      */           } } } } }
/*      */   
/*      */   public static class NodeList extends FilterableList.AbstractBase<Node, NodeList> { private final List<? extends MethodGraph.Node> nodes;
/*      */     
/*      */     public NodeList(List<? extends MethodGraph.Node> param1List) {
/* 1879 */       this.nodes = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodGraph.Node get(int param1Int) {
/* 1886 */       return this.nodes.get(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/* 1893 */       return this.nodes.size();
/*      */     }
/*      */ 
/*      */     
/*      */     protected NodeList wrap(List<MethodGraph.Node> param1List) {
/* 1898 */       return new NodeList(param1List);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodList<?> asMethodList() {
/* 1907 */       ArrayList<MethodDescription> arrayList = new ArrayList(size());
/* 1908 */       for (MethodGraph.Node node : this.nodes) {
/* 1909 */         arrayList.add(node.getRepresentative());
/*      */       }
/* 1911 */       return (MethodList<?>)new MethodList.Explicit(arrayList);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Simple
/*      */     implements MethodGraph
/*      */   {
/*      */     private final LinkedHashMap<MethodDescription.SignatureToken, MethodGraph.Node> nodes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Simple(LinkedHashMap<MethodDescription.SignatureToken, MethodGraph.Node> param1LinkedHashMap) {
/* 1932 */       this.nodes = param1LinkedHashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodGraph of(List<? extends MethodDescription> param1List) {
/* 1942 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 1943 */       for (MethodDescription methodDescription : param1List) {
/* 1944 */         linkedHashMap.put(methodDescription.asSignatureToken(), new MethodGraph.Node.Simple(methodDescription));
/*      */       }
/* 1946 */       return new Simple((LinkedHashMap)linkedHashMap);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodGraph.Node locate(MethodDescription.SignatureToken param1SignatureToken) {
/*      */       MethodGraph.Node node;
/* 1954 */       return ((node = this.nodes.get(param1SignatureToken)) == null) ? MethodGraph.Node.Unresolved.INSTANCE : node;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodGraph.NodeList listNodes() {
/* 1963 */       return new MethodGraph.NodeList(new ArrayList<MethodGraph.Node>(this.nodes.values()));
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.nodes.equals(((Simple)param1Object).nodes))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.nodes.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\MethodGraph.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */