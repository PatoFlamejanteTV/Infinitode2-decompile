/*      */ package net.bytebuddy.dynamic.scaffold;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.Transformer;
/*      */ import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*      */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.matcher.LatentMatcher;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface MethodRegistry
/*      */ {
/*      */   MethodRegistry prepend(LatentMatcher<? super MethodDescription> paramLatentMatcher, Handler paramHandler, MethodAttributeAppender.Factory paramFactory, Transformer<MethodDescription> paramTransformer);
/*      */   
/*      */   MethodRegistry append(LatentMatcher<? super MethodDescription> paramLatentMatcher, Handler paramHandler, MethodAttributeAppender.Factory paramFactory, Transformer<MethodDescription> paramTransformer);
/*      */   
/*      */   Prepared prepare(InstrumentedType paramInstrumentedType, MethodGraph.Compiler paramCompiler, TypeValidation paramTypeValidation, VisibilityBridgeStrategy paramVisibilityBridgeStrategy, LatentMatcher<? super MethodDescription> paramLatentMatcher);
/*      */   
/*      */   public static interface Handler
/*      */     extends InstrumentedType.Prepareable
/*      */   {
/*      */     Compiled compile(Implementation.Target param1Target);
/*      */     
/*      */     public enum ForAbstractMethod
/*      */       implements Handler, Compiled
/*      */     {
/*  110 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  116 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MethodRegistry.Handler.Compiled compile(Implementation.Target param2Target) {
/*  123 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final TypeWriter.MethodPool.Record assemble(MethodDescription param2MethodDescription, MethodAttributeAppender param2MethodAttributeAppender, Visibility param2Visibility) {
/*  130 */         return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithoutBody(param2MethodDescription, param2MethodAttributeAppender, param2Visibility);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum ForVisibilityBridge
/*      */       implements Handler
/*      */     {
/*  142 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  148 */         throw new IllegalStateException("A visibility bridge handler must not apply any preparations");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Compiled compile(Implementation.Target param2Target) {
/*  155 */         return new Compiled(param2Target.getInstrumentedType());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Compiled
/*      */         implements MethodRegistry.Handler.Compiled
/*      */       {
/*      */         private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Compiled(TypeDescription param3TypeDescription) {
/*  175 */           this.instrumentedType = param3TypeDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record assemble(MethodDescription param3MethodDescription, MethodAttributeAppender param3MethodAttributeAppender, Visibility param3Visibility) {
/*  182 */           return TypeWriter.MethodPool.Record.ForDefinedMethod.OfVisibilityBridge.of(this.instrumentedType, param3MethodDescription, param3MethodAttributeAppender);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.instrumentedType.equals(((Compiled)param3Object).instrumentedType))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Compiled
/*      */     {
/*      */       TypeWriter.MethodPool.Record assemble(MethodDescription param2MethodDescription, MethodAttributeAppender param2MethodAttributeAppender, Visibility param2Visibility);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForImplementation
/*      */       implements Handler
/*      */     {
/*      */       private final Implementation implementation;
/*      */ 
/*      */ 
/*      */       
/*      */       public ForImplementation(Implementation param2Implementation) {
/*  220 */         this.implementation = param2Implementation;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  227 */         return this.implementation.prepare(param2InstrumentedType);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Compiled compile(Implementation.Target param2Target) {
/*  234 */         return new Compiled(this.implementation.appender(param2Target));
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.implementation.equals(((ForImplementation)param2Object).implementation))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.implementation.hashCode();
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       protected static class Compiled
/*      */         implements MethodRegistry.Handler.Compiled
/*      */       {
/*      */         private final ByteCodeAppender byteCodeAppender;
/*      */         
/*      */         protected Compiled(ByteCodeAppender param3ByteCodeAppender) {
/*  254 */           this.byteCodeAppender = param3ByteCodeAppender;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record assemble(MethodDescription param3MethodDescription, MethodAttributeAppender param3MethodAttributeAppender, Visibility param3Visibility) {
/*  261 */           return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithBody(param3MethodDescription, this.byteCodeAppender, param3MethodAttributeAppender, param3Visibility);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.byteCodeAppender.equals(((Compiled)param3Object).byteCodeAppender))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.byteCodeAppender.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class ForAnnotationValue
/*      */       implements Handler, Compiled
/*      */     {
/*      */       private final AnnotationValue<?, ?> annotationValue;
/*      */       
/*      */       public ForAnnotationValue(AnnotationValue<?, ?> param2AnnotationValue) {
/*  283 */         this.annotationValue = param2AnnotationValue;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  290 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodRegistry.Handler.Compiled compile(Implementation.Target param2Target) {
/*  297 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeWriter.MethodPool.Record assemble(MethodDescription param2MethodDescription, MethodAttributeAppender param2MethodAttributeAppender, Visibility param2Visibility) {
/*  304 */         return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithAnnotationDefaultValue(param2MethodDescription, this.annotationValue, param2MethodAttributeAppender);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.annotationValue.equals(((ForAnnotationValue)param2Object).annotationValue))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.annotationValue.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Prepared
/*      */   {
/*      */     TypeDescription getInstrumentedType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodList<?> getMethods();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodList<?> getInstrumentedMethods();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     LoadedTypeInitializer getLoadedTypeInitializer();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TypeInitializer getTypeInitializer();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodRegistry.Compiled compile(Implementation.Target.Factory param1Factory, ClassFileVersion param1ClassFileVersion);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Compiled
/*      */     extends TypeWriter.MethodPool
/*      */   {
/*      */     TypeDescription getInstrumentedType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodList<?> getMethods();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodList<?> getInstrumentedMethods();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     LoadedTypeInitializer getLoadedTypeInitializer();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TypeInitializer getTypeInitializer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Default
/*      */     implements MethodRegistry
/*      */   {
/*      */     private final List<Entry> entries;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Default() {
/*  415 */       this.entries = Collections.emptyList();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Default(List<Entry> param1List) {
/*  424 */       this.entries = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodRegistry prepend(LatentMatcher<? super MethodDescription> param1LatentMatcher, MethodRegistry.Handler param1Handler, MethodAttributeAppender.Factory param1Factory, Transformer<MethodDescription> param1Transformer) {
/*  434 */       return new Default(CompoundList.of(new Entry(param1LatentMatcher, param1Handler, param1Factory, param1Transformer), this.entries));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodRegistry append(LatentMatcher<? super MethodDescription> param1LatentMatcher, MethodRegistry.Handler param1Handler, MethodAttributeAppender.Factory param1Factory, Transformer<MethodDescription> param1Transformer) {
/*  444 */       return new Default(CompoundList.of(this.entries, new Entry(param1LatentMatcher, param1Handler, param1Factory, param1Transformer)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodRegistry.Prepared prepare(InstrumentedType param1InstrumentedType, MethodGraph.Compiler param1Compiler, TypeValidation param1TypeValidation, VisibilityBridgeStrategy param1VisibilityBridgeStrategy, LatentMatcher<? super MethodDescription> param1LatentMatcher) {
/*  455 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  456 */       HashSet<MethodRegistry.Handler> hashSet = new HashSet();
/*  457 */       HashSet<MethodDescription> hashSet1 = new HashSet((Collection<?>)param1InstrumentedType.getDeclaredMethods());
/*  458 */       for (Entry entry : this.entries) {
/*  459 */         if (hashSet.add(entry.getHandler())) {
/*  460 */           InstrumentedType instrumentedType = entry.getHandler().prepare(param1InstrumentedType);
/*  461 */           if (param1InstrumentedType != instrumentedType) {
/*  462 */             for (MethodDescription methodDescription : instrumentedType.getDeclaredMethods()) {
/*  463 */               if (!hashSet1.contains(methodDescription)) {
/*  464 */                 linkedHashMap.put(methodDescription, entry.asSupplementaryEntry(methodDescription));
/*  465 */                 hashSet1.add(methodDescription);
/*      */               } 
/*      */             } 
/*  468 */             param1InstrumentedType = instrumentedType;
/*      */           } 
/*      */         } 
/*      */       } 
/*  472 */       MethodGraph.Linked linked = param1Compiler.compile((TypeDefinition)param1InstrumentedType);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  477 */       ElementMatcher.Junction junction = ElementMatchers.not((ElementMatcher)ElementMatchers.anyOf(linkedHashMap.keySet())).and((ElementMatcher)ElementMatchers.returns((ElementMatcher)ElementMatchers.isVisibleTo(param1InstrumentedType))).and((ElementMatcher)ElementMatchers.hasParameters((ElementMatcher)ElementMatchers.whereNone((ElementMatcher)ElementMatchers.hasType((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isVisibleTo(param1InstrumentedType)))))).and(param1LatentMatcher.resolve(param1InstrumentedType));
/*  478 */       ArrayList<MethodDescription> arrayList = new ArrayList();
/*  479 */       for (null = linked.listNodes().iterator(); null.hasNext(); ) {
/*  480 */         MethodGraph.Node node; MethodDescription methodDescription = (node = null.next()).getRepresentative();
/*  481 */         boolean bool = (param1InstrumentedType.isPublic() && !param1InstrumentedType.isInterface()) ? true : false;
/*  482 */         if (junction.matches(methodDescription)) {
/*  483 */           for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext();) {
/*  484 */             if ((entry = iterator.next()).resolve(param1InstrumentedType).matches(methodDescription)) {
/*  485 */               linkedHashMap.put(methodDescription, entry.asPreparedEntry(param1InstrumentedType, methodDescription, node
/*      */                     
/*  487 */                     .getMethodTypes(), node
/*  488 */                     .getVisibility()));
/*  489 */               bool = false;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*  494 */         if (bool && 
/*  495 */           !node.getSort().isMadeVisible() && methodDescription
/*  496 */           .isPublic() && 
/*  497 */           !methodDescription.isAbstract() && !methodDescription.isFinal() && methodDescription
/*  498 */           .getDeclaringType().isPackagePrivate() && param1VisibilityBridgeStrategy
/*  499 */           .generateVisibilityBridge(methodDescription))
/*      */         {
/*  501 */           linkedHashMap.put(methodDescription, Prepared.Entry.forVisibilityBridge(methodDescription, node.getVisibility()));
/*      */         }
/*  503 */         arrayList.add(methodDescription);
/*      */       } 
/*  505 */       for (MethodDescription methodDescription : CompoundList.of((List)param1InstrumentedType
/*  506 */           .getDeclaredMethods().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isVirtual()).and((ElementMatcher)junction)), new MethodDescription.Latent.TypeInitializer(param1InstrumentedType))) {
/*      */         
/*  508 */         for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext();) {
/*  509 */           if ((param1LatentMatcher = iterator.next()).resolve(param1InstrumentedType).matches(methodDescription)) {
/*  510 */             linkedHashMap.put(methodDescription, param1LatentMatcher.asPreparedEntry(param1InstrumentedType, methodDescription, methodDescription.getVisibility()));
/*      */             break;
/*      */           } 
/*      */         } 
/*  514 */         arrayList.add(methodDescription);
/*      */       } 
/*  516 */       return new Prepared((LinkedHashMap)linkedHashMap, param1InstrumentedType
/*  517 */           .getLoadedTypeInitializer(), param1InstrumentedType
/*  518 */           .getTypeInitializer(), 
/*  519 */           param1TypeValidation.isEnabled() ? param1InstrumentedType
/*  520 */           .validated() : param1InstrumentedType, linked, (MethodList<?>)new MethodList.Explicit(arrayList));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.entries.equals(((Default)param1Object).entries))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.entries.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class Entry
/*      */       implements LatentMatcher<MethodDescription>
/*      */     {
/*      */       private final LatentMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodRegistry.Handler handler;
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodAttributeAppender.Factory attributeAppenderFactory;
/*      */ 
/*      */ 
/*      */       
/*      */       private final Transformer<MethodDescription> transformer;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Entry(LatentMatcher<? super MethodDescription> param2LatentMatcher, MethodRegistry.Handler param2Handler, MethodAttributeAppender.Factory param2Factory, Transformer<MethodDescription> param2Transformer) {
/*  564 */         this.matcher = param2LatentMatcher;
/*  565 */         this.handler = param2Handler;
/*  566 */         this.attributeAppenderFactory = param2Factory;
/*  567 */         this.transformer = param2Transformer;
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
/*      */       protected MethodRegistry.Default.Prepared.Entry asPreparedEntry(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Visibility param2Visibility) {
/*  579 */         return asPreparedEntry(param2TypeDescription, param2MethodDescription, Collections.emptySet(), param2Visibility);
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
/*      */       protected MethodRegistry.Default.Prepared.Entry asPreparedEntry(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Set<MethodDescription.TypeToken> param2Set, Visibility param2Visibility) {
/*  595 */         return new MethodRegistry.Default.Prepared.Entry(this.handler, this.attributeAppenderFactory, (MethodDescription)this.transformer
/*      */             
/*  597 */             .transform(param2TypeDescription, param2MethodDescription), param2Set, param2Visibility, false);
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
/*      */       protected MethodRegistry.Default.Prepared.Entry asSupplementaryEntry(MethodDescription param2MethodDescription) {
/*  610 */         return new MethodRegistry.Default.Prepared.Entry(this.handler, 
/*  611 */             MethodAttributeAppender.Explicit.of(param2MethodDescription), param2MethodDescription, 
/*      */             
/*  613 */             Collections.emptySet(), param2MethodDescription
/*  614 */             .getVisibility(), false);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected MethodRegistry.Handler getHandler() {
/*  624 */         return this.handler;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ElementMatcher<? super MethodDescription> resolve(TypeDescription param2TypeDescription) {
/*  631 */         return this.matcher.resolve(param2TypeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.matcher.equals(((Entry)param2Object).matcher) ? false : (!this.handler.equals(((Entry)param2Object).handler) ? false : (!this.attributeAppenderFactory.equals(((Entry)param2Object).attributeAppenderFactory) ? false : (!!this.transformer.equals(((Entry)param2Object).transformer)))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.handler.hashCode()) * 31 + this.attributeAppenderFactory.hashCode()) * 31 + this.transformer.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class Prepared
/*      */       implements MethodRegistry.Prepared
/*      */     {
/*      */       private final LinkedHashMap<MethodDescription, Entry> implementations;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final LoadedTypeInitializer loadedTypeInitializer;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeInitializer typeInitializer;
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodGraph.Linked methodGraph;
/*      */ 
/*      */ 
/*      */       
/*      */       private final MethodList<?> methods;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Prepared(LinkedHashMap<MethodDescription, Entry> param2LinkedHashMap, LoadedTypeInitializer param2LoadedTypeInitializer, TypeInitializer param2TypeInitializer, TypeDescription param2TypeDescription, MethodGraph.Linked param2Linked, MethodList<?> param2MethodList) {
/*  687 */         this.implementations = param2LinkedHashMap;
/*  688 */         this.loadedTypeInitializer = param2LoadedTypeInitializer;
/*  689 */         this.typeInitializer = param2TypeInitializer;
/*  690 */         this.instrumentedType = param2TypeDescription;
/*  691 */         this.methodGraph = param2Linked;
/*  692 */         this.methods = param2MethodList;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getInstrumentedType() {
/*  699 */         return this.instrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public LoadedTypeInitializer getLoadedTypeInitializer() {
/*  706 */         return this.loadedTypeInitializer;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeInitializer getTypeInitializer() {
/*  713 */         return this.typeInitializer;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodList<?> getMethods() {
/*  720 */         return this.methods;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodList<?> getInstrumentedMethods() {
/*  727 */         return (MethodList)(new MethodList.Explicit(new ArrayList(this.implementations.keySet()))).filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isTypeInitializer()));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodRegistry.Compiled compile(Implementation.Target.Factory param2Factory, ClassFileVersion param2ClassFileVersion) {
/*  734 */         HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/*  735 */         HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/*  736 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  737 */         Implementation.Target target = param2Factory.make(this.instrumentedType, this.methodGraph, param2ClassFileVersion);
/*  738 */         for (Map.Entry<MethodDescription, Entry> entry : this.implementations.entrySet()) {
/*      */           MethodRegistry.Handler.Compiled compiled;
/*  740 */           if ((compiled = (MethodRegistry.Handler.Compiled)hashMap1.get(((Entry)entry.getValue()).getHandler())) == null) {
/*  741 */             compiled = ((Entry)entry.getValue()).getHandler().compile(target);
/*  742 */             hashMap1.put(((Entry)entry.getValue()).getHandler(), compiled);
/*      */           } 
/*      */           MethodAttributeAppender methodAttributeAppender;
/*  745 */           if ((methodAttributeAppender = (MethodAttributeAppender)hashMap2.get(((Entry)entry.getValue()).getAppenderFactory())) == null) {
/*  746 */             methodAttributeAppender = ((Entry)entry.getValue()).getAppenderFactory().make(this.instrumentedType);
/*  747 */             hashMap2.put(((Entry)entry.getValue()).getAppenderFactory(), methodAttributeAppender);
/*      */           } 
/*  749 */           linkedHashMap.put(entry.getKey(), new MethodRegistry.Default.Compiled.Entry(compiled, methodAttributeAppender, ((Entry)entry
/*      */                 
/*  751 */                 .getValue()).getMethodDescription(), ((Entry)entry
/*  752 */                 .getValue()).resolveBridgeTypes(), ((Entry)entry
/*  753 */                 .getValue()).getVisibility(), ((Entry)entry
/*  754 */                 .getValue()).isBridgeMethod()));
/*      */         } 
/*  756 */         return new MethodRegistry.Default.Compiled(this.instrumentedType, this.loadedTypeInitializer, this.typeInitializer, this.methods, (LinkedHashMap)linkedHashMap, param2ClassFileVersion
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  761 */             .isAtLeast(ClassFileVersion.JAVA_V5));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.implementations.equals(((Prepared)param2Object).implementations) ? false : (!this.loadedTypeInitializer.equals(((Prepared)param2Object).loadedTypeInitializer) ? false : (!this.typeInitializer.equals(((Prepared)param2Object).typeInitializer) ? false : (!this.instrumentedType.equals(((Prepared)param2Object).instrumentedType) ? false : (!this.methodGraph.equals(((Prepared)param2Object).methodGraph) ? false : (!!this.methods.equals(((Prepared)param2Object).methods)))))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (((((getClass().hashCode() * 31 + this.implementations.hashCode()) * 31 + this.loadedTypeInitializer.hashCode()) * 31 + this.typeInitializer.hashCode()) * 31 + this.instrumentedType.hashCode()) * 31 + this.methodGraph.hashCode()) * 31 + this.methods.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Entry
/*      */       {
/*      */         private final MethodRegistry.Handler handler;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodAttributeAppender.Factory attributeAppenderFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Set<MethodDescription.TypeToken> typeTokens;
/*      */ 
/*      */ 
/*      */         
/*      */         private final Visibility visibility;
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean bridgeMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Entry(MethodRegistry.Handler param3Handler, MethodAttributeAppender.Factory param3Factory, MethodDescription param3MethodDescription, Set<MethodDescription.TypeToken> param3Set, Visibility param3Visibility, boolean param3Boolean) {
/*  816 */           this.handler = param3Handler;
/*  817 */           this.attributeAppenderFactory = param3Factory;
/*  818 */           this.methodDescription = param3MethodDescription;
/*  819 */           this.typeTokens = param3Set;
/*  820 */           this.visibility = param3Visibility;
/*  821 */           this.bridgeMethod = param3Boolean;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static Entry forVisibilityBridge(MethodDescription param3MethodDescription, Visibility param3Visibility) {
/*  832 */           return new Entry(MethodRegistry.Handler.ForVisibilityBridge.INSTANCE, 
/*  833 */               MethodAttributeAppender.Explicit.of(param3MethodDescription), param3MethodDescription, 
/*      */               
/*  835 */               Collections.emptySet(), param3Visibility, true);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected MethodRegistry.Handler getHandler() {
/*  846 */           return this.handler;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected MethodAttributeAppender.Factory getAppenderFactory() {
/*  855 */           return this.attributeAppenderFactory;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected MethodDescription getMethodDescription() {
/*  864 */           return this.methodDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Set<MethodDescription.TypeToken> resolveBridgeTypes() {
/*      */           HashSet<MethodDescription.TypeToken> hashSet;
/*  874 */           (hashSet = new HashSet<MethodDescription.TypeToken>(this.typeTokens)).remove(this.methodDescription.asTypeToken());
/*  875 */           return hashSet;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Visibility getVisibility() {
/*  884 */           return this.visibility;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected boolean isBridgeMethod()
/*      */         {
/*  893 */           return this.bridgeMethod; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.bridgeMethod != ((Entry)param3Object).bridgeMethod) ? false : (!this.visibility.equals(((Entry)param3Object).visibility) ? false : (!this.handler.equals(((Entry)param3Object).handler) ? false : (!this.attributeAppenderFactory.equals(((Entry)param3Object).attributeAppenderFactory) ? false : (!this.methodDescription.equals(((Entry)param3Object).methodDescription) ? false : (!!this.typeTokens.equals(((Entry)param3Object).typeTokens))))))))); } public int hashCode() { return (((((getClass().hashCode() * 31 + this.handler.hashCode()) * 31 + this.attributeAppenderFactory.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.typeTokens.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.bridgeMethod; } } } @Enhance protected static class Entry { private final MethodRegistry.Handler handler; private final MethodAttributeAppender.Factory attributeAppenderFactory; private final MethodDescription methodDescription; protected boolean isBridgeMethod() { return this.bridgeMethod; }
/*      */       
/*      */       private final Set<MethodDescription.TypeToken> typeTokens; private final Visibility visibility;
/*      */       private final boolean bridgeMethod;
/*      */       
/*      */       protected Entry(MethodRegistry.Handler param2Handler, MethodAttributeAppender.Factory param2Factory, MethodDescription param2MethodDescription, Set<MethodDescription.TypeToken> param2Set, Visibility param2Visibility, boolean param2Boolean) {
/*      */         this.handler = param2Handler;
/*      */         this.attributeAppenderFactory = param2Factory;
/*      */         this.methodDescription = param2MethodDescription;
/*      */         this.typeTokens = param2Set;
/*      */         this.visibility = param2Visibility;
/*      */         this.bridgeMethod = param2Boolean;
/*      */       }
/*      */       
/*      */       protected static Entry forVisibilityBridge(MethodDescription param2MethodDescription, Visibility param2Visibility) {
/*      */         return new Entry(MethodRegistry.Handler.ForVisibilityBridge.INSTANCE, MethodAttributeAppender.Explicit.of(param2MethodDescription), param2MethodDescription, Collections.emptySet(), param2Visibility, true);
/*      */       }
/*      */       
/*      */       protected MethodRegistry.Handler getHandler() {
/*      */         return this.handler;
/*      */       }
/*      */       
/*      */       protected MethodAttributeAppender.Factory getAppenderFactory() {
/*      */         return this.attributeAppenderFactory;
/*      */       }
/*      */       
/*      */       protected MethodDescription getMethodDescription() {
/*      */         return this.methodDescription;
/*      */       }
/*      */       
/*      */       protected Set<MethodDescription.TypeToken> resolveBridgeTypes() {
/*      */         HashSet<MethodDescription.TypeToken> hashSet;
/*      */         (hashSet = new HashSet<MethodDescription.TypeToken>(this.typeTokens)).remove(this.methodDescription.asTypeToken());
/*      */         return hashSet;
/*      */       }
/*      */       
/*      */       protected Visibility getVisibility() {
/*      */         return this.visibility;
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.bridgeMethod != ((Entry)param2Object).bridgeMethod) ? false : (!this.visibility.equals(((Entry)param2Object).visibility) ? false : (!this.handler.equals(((Entry)param2Object).handler) ? false : (!this.attributeAppenderFactory.equals(((Entry)param2Object).attributeAppenderFactory) ? false : (!this.methodDescription.equals(((Entry)param2Object).methodDescription) ? false : (!!this.typeTokens.equals(((Entry)param2Object).typeTokens)))))))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return (((((getClass().hashCode() * 31 + this.handler.hashCode()) * 31 + this.attributeAppenderFactory.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.typeTokens.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.bridgeMethod;
/*      */       } }
/*      */     
/*      */     @Enhance
/*      */     protected static class Compiled implements MethodRegistry.Compiled { private final TypeDescription instrumentedType;
/*      */       private final LoadedTypeInitializer loadedTypeInitializer;
/*      */       private final TypeInitializer typeInitializer;
/*      */       private final MethodList<?> methods;
/*      */       private final LinkedHashMap<MethodDescription, Entry> implementations;
/*      */       private final boolean supportsBridges;
/*      */       
/*      */       protected Compiled(TypeDescription param2TypeDescription, LoadedTypeInitializer param2LoadedTypeInitializer, TypeInitializer param2TypeInitializer, MethodList<?> param2MethodList, LinkedHashMap<MethodDescription, Entry> param2LinkedHashMap, boolean param2Boolean) {
/*  950 */         this.instrumentedType = param2TypeDescription;
/*  951 */         this.loadedTypeInitializer = param2LoadedTypeInitializer;
/*  952 */         this.typeInitializer = param2TypeInitializer;
/*  953 */         this.methods = param2MethodList;
/*  954 */         this.implementations = param2LinkedHashMap;
/*  955 */         this.supportsBridges = param2Boolean;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getInstrumentedType() {
/*  962 */         return this.instrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public LoadedTypeInitializer getLoadedTypeInitializer() {
/*  969 */         return this.loadedTypeInitializer;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeInitializer getTypeInitializer() {
/*  976 */         return this.typeInitializer;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodList<?> getMethods() {
/*  983 */         return this.methods;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodList<?> getInstrumentedMethods() {
/*  990 */         return (MethodList)(new MethodList.Explicit(new ArrayList(this.implementations.keySet()))).filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isTypeInitializer()));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeWriter.MethodPool.Record target(MethodDescription param2MethodDescription) {
/*      */         Entry entry;
/*  998 */         return ((entry = this.implementations.get(param2MethodDescription)) == null) ? new TypeWriter.MethodPool.Record.ForNonImplementedMethod(param2MethodDescription) : entry
/*      */           
/* 1000 */           .bind(this.instrumentedType, this.supportsBridges);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.supportsBridges != ((Compiled)param2Object).supportsBridges) ? false : (!this.instrumentedType.equals(((Compiled)param2Object).instrumentedType) ? false : (!this.loadedTypeInitializer.equals(((Compiled)param2Object).loadedTypeInitializer) ? false : (!this.typeInitializer.equals(((Compiled)param2Object).typeInitializer) ? false : (!this.methods.equals(((Compiled)param2Object).methods) ? false : (!!this.implementations.equals(((Compiled)param2Object).implementations)))))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (((((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.loadedTypeInitializer.hashCode()) * 31 + this.typeInitializer.hashCode()) * 31 + this.methods.hashCode()) * 31 + this.implementations.hashCode()) * 31 + this.supportsBridges;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Entry
/*      */       {
/*      */         private final MethodRegistry.Handler.Compiled handler;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodAttributeAppender attributeAppender;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Set<MethodDescription.TypeToken> bridgeTypes;
/*      */ 
/*      */ 
/*      */         
/*      */         private final Visibility visibility;
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean bridgeMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Entry(MethodRegistry.Handler.Compiled param3Compiled, MethodAttributeAppender param3MethodAttributeAppender, MethodDescription param3MethodDescription, Set<MethodDescription.TypeToken> param3Set, Visibility param3Visibility, boolean param3Boolean) {
/* 1055 */           this.handler = param3Compiled;
/* 1056 */           this.attributeAppender = param3MethodAttributeAppender;
/* 1057 */           this.methodDescription = param3MethodDescription;
/* 1058 */           this.bridgeTypes = param3Set;
/* 1059 */           this.visibility = param3Visibility;
/* 1060 */           this.bridgeMethod = param3Boolean;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected TypeWriter.MethodPool.Record bind(TypeDescription param3TypeDescription, boolean param3Boolean) {
/* 1071 */           if (this.bridgeMethod && !param3Boolean) {
/* 1072 */             return new TypeWriter.MethodPool.Record.ForNonImplementedMethod(this.methodDescription);
/*      */           }
/* 1074 */           TypeWriter.MethodPool.Record record = this.handler.assemble(this.methodDescription, this.attributeAppender, this.visibility);
/* 1075 */           if (param3Boolean)
/* 1076 */             return TypeWriter.MethodPool.Record.AccessBridgeWrapper.of(record, param3TypeDescription, this.methodDescription, this.bridgeTypes, this.attributeAppender);  return record;
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.bridgeMethod != ((Entry)param3Object).bridgeMethod) ? false : (!this.visibility.equals(((Entry)param3Object).visibility) ? false : (!this.handler.equals(((Entry)param3Object).handler) ? false : (!this.attributeAppender.equals(((Entry)param3Object).attributeAppender) ? false : (!this.methodDescription.equals(((Entry)param3Object).methodDescription) ? false : (!!this.bridgeTypes.equals(((Entry)param3Object).bridgeTypes)))))))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return (((((getClass().hashCode() * 31 + this.handler.hashCode()) * 31 + this.attributeAppender.hashCode()) * 31 + this.methodDescription.hashCode()) * 31 + this.bridgeTypes.hashCode()) * 31 + this.visibility.hashCode()) * 31 + this.bridgeMethod;
/*      */         }
/*      */       } }
/*      */   
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\MethodRegistry.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */