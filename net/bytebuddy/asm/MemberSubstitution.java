/*      */ package net.bytebuddy.asm;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.ByteCodeElement;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.ClassFileLocator;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.bytecode.Duplication;
/*      */ import net.bytebuddy.implementation.bytecode.Removal;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.StackSize;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.pool.TypePool;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.OpenedClassReader;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.visitor.LocalVariableAwareMethodVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public class MemberSubstitution
/*      */   implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
/*      */ {
/*      */   private final MethodGraph.Compiler methodGraphCompiler;
/*      */   private final boolean strict;
/*      */   private final TypePoolResolver typePoolResolver;
/*      */   private final Replacement.Factory replacementFactory;
/*      */   
/*      */   protected MemberSubstitution(boolean paramBoolean) {
/*   97 */     this(MethodGraph.Compiler.DEFAULT, TypePoolResolver.OfImplicitPool.INSTANCE, paramBoolean, Replacement.NoOp.INSTANCE);
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
/*      */   protected MemberSubstitution(MethodGraph.Compiler paramCompiler, TypePoolResolver paramTypePoolResolver, boolean paramBoolean, Replacement.Factory paramFactory) {
/*  112 */     this.methodGraphCompiler = paramCompiler;
/*  113 */     this.typePoolResolver = paramTypePoolResolver;
/*  114 */     this.strict = paramBoolean;
/*  115 */     this.replacementFactory = paramFactory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemberSubstitution strict() {
/*  125 */     return new MemberSubstitution(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemberSubstitution relaxed() {
/*  136 */     return new MemberSubstitution(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WithoutSpecification element(ElementMatcher<? super ByteCodeElement> paramElementMatcher) {
/*  146 */     return new WithoutSpecification.ForMatchedByteCodeElement(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WithoutSpecification.ForMatchedField field(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/*  156 */     return new WithoutSpecification.ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WithoutSpecification.ForMatchedMethod method(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/*  166 */     return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WithoutSpecification constructor(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/*  176 */     return invokable((ElementMatcher<? super MethodDescription>)ElementMatchers.isConstructor().and(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WithoutSpecification invokable(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/*  186 */     return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MemberSubstitution with(MethodGraph.Compiler paramCompiler) {
/*  196 */     return new MemberSubstitution(paramCompiler, this.typePoolResolver, this.strict, this.replacementFactory);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MemberSubstitution with(TypePoolResolver paramTypePoolResolver) {
/*  206 */     return new MemberSubstitution(this.methodGraphCompiler, paramTypePoolResolver, this.strict, this.replacementFactory);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/*  216 */     return (new AsmVisitorWrapper.ForDeclaredMethods()).invokable(paramElementMatcher, new AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper[] { this });
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
/*      */   public MethodVisitor wrap(TypeDescription paramTypeDescription, MethodDescription paramMethodDescription, MethodVisitor paramMethodVisitor, Implementation.Context paramContext, TypePool paramTypePool, int paramInt1, int paramInt2) {
/*  229 */     paramTypePool = this.typePoolResolver.resolve(paramTypeDescription, paramMethodDescription, paramTypePool);
/*  230 */     return (MethodVisitor)new SubstitutingMethodVisitor(paramMethodVisitor, paramTypeDescription, paramMethodDescription, this.methodGraphCompiler, this.strict, this.replacementFactory
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  235 */         .make(paramTypeDescription, paramMethodDescription, paramTypePool), paramContext, paramTypePool, paramContext
/*      */ 
/*      */         
/*  238 */         .getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.strict != ((MemberSubstitution)paramObject).strict) ? false : (!this.methodGraphCompiler.equals(((MemberSubstitution)paramObject).methodGraphCompiler) ? false : (!this.typePoolResolver.equals(((MemberSubstitution)paramObject).typePoolResolver) ? false : (!!this.replacementFactory.equals(((MemberSubstitution)paramObject).replacementFactory)))))));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*      */     return (((getClass().hashCode() * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.strict) * 31 + this.typePoolResolver.hashCode()) * 31 + this.replacementFactory.hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static abstract class WithoutSpecification
/*      */   {
/*      */     protected final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final MemberSubstitution.TypePoolResolver typePoolResolver;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final boolean strict;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final MemberSubstitution.Replacement.Factory replacementFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected WithoutSpecification(MethodGraph.Compiler param1Compiler, MemberSubstitution.TypePoolResolver param1TypePoolResolver, boolean param1Boolean, MemberSubstitution.Replacement.Factory param1Factory) {
/*  279 */       this.methodGraphCompiler = param1Compiler;
/*  280 */       this.typePoolResolver = param1TypePoolResolver;
/*  281 */       this.strict = param1Boolean;
/*  282 */       this.replacementFactory = param1Factory;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MemberSubstitution stub() {
/*  293 */       return replaceWith(MemberSubstitution.Substitution.Stubbing.INSTANCE);
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
/*      */     public MemberSubstitution replaceWith(Field param1Field) {
/*  311 */       return replaceWith((FieldDescription)new FieldDescription.ForLoadedField(param1Field));
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
/*      */     public MemberSubstitution replaceWith(FieldDescription param1FieldDescription) {
/*  329 */       return replaceWith(new MemberSubstitution.Substitution.ForFieldAccess.OfGivenField(param1FieldDescription));
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
/*      */     public MemberSubstitution replaceWithField(ElementMatcher<? super FieldDescription> param1ElementMatcher) {
/*  342 */       return replaceWith(new MemberSubstitution.Substitution.ForFieldAccess.OfMatchedField(param1ElementMatcher));
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
/*      */     public MemberSubstitution replaceWith(Method param1Method) {
/*  360 */       return replaceWith((MethodDescription)new MethodDescription.ForLoadedMethod(param1Method));
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
/*      */     public MemberSubstitution replaceWith(MethodDescription param1MethodDescription) {
/*  381 */       if (!param1MethodDescription.isMethod()) {
/*  382 */         throw new IllegalArgumentException("Cannot use " + param1MethodDescription + " as a replacement");
/*      */       }
/*  384 */       return replaceWith(new MemberSubstitution.Substitution.ForMethodInvocation.OfGivenMethod(param1MethodDescription));
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
/*      */     public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> param1ElementMatcher) {
/*  397 */       return replaceWithMethod(param1ElementMatcher, this.methodGraphCompiler);
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
/*      */     public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> param1ElementMatcher, MethodGraph.Compiler param1Compiler) {
/*  411 */       return replaceWith(new MemberSubstitution.Substitution.ForMethodInvocation.OfMatchedMethod(param1ElementMatcher, param1Compiler));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MemberSubstitution replaceWithInstrumentedMethod() {
/*  422 */       return replaceWith(MemberSubstitution.Substitution.ForMethodInvocation.OfInstrumentedMethod.INSTANCE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MemberSubstitution replaceWithChain(MemberSubstitution.Substitution.Chain.Step.Factory... param1VarArgs) {
/*  433 */       return replaceWithChain(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MemberSubstitution replaceWithChain(List<? extends MemberSubstitution.Substitution.Chain.Step.Factory> param1List) {
/*  444 */       return replaceWith(MemberSubstitution.Substitution.Chain.withDefaultAssigner().executing(param1List));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract MemberSubstitution replaceWith(MemberSubstitution.Substitution.Factory param1Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.strict != ((WithoutSpecification)param1Object).strict) ? false : (!this.methodGraphCompiler.equals(((WithoutSpecification)param1Object).methodGraphCompiler) ? false : (!this.typePoolResolver.equals(((WithoutSpecification)param1Object).typePoolResolver) ? false : (!!this.replacementFactory.equals(((WithoutSpecification)param1Object).replacementFactory)))))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.typePoolResolver.hashCode()) * 31 + this.strict) * 31 + this.replacementFactory.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class ForMatchedByteCodeElement
/*      */       extends WithoutSpecification
/*      */     {
/*      */       private final ElementMatcher<? super ByteCodeElement> matcher;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForMatchedByteCodeElement(MethodGraph.Compiler param2Compiler, MemberSubstitution.TypePoolResolver param2TypePoolResolver, boolean param2Boolean, MemberSubstitution.Replacement.Factory param2Factory, ElementMatcher<? super ByteCodeElement> param2ElementMatcher) {
/*  480 */         super(param2Compiler, param2TypePoolResolver, param2Boolean, param2Factory);
/*  481 */         this.matcher = param2ElementMatcher;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution replaceWith(MemberSubstitution.Substitution.Factory param2Factory) {
/*  488 */         return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new MemberSubstitution.Replacement.Factory.Compound(new MemberSubstitution.Replacement.Factory[] { this.replacementFactory, 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  493 */                 MemberSubstitution.Replacement.ForElementMatchers.Factory.of(this.matcher, param2Factory) }));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.matcher.equals(((ForMatchedByteCodeElement)param2Object).matcher)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.matcher.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForMatchedField
/*      */       extends WithoutSpecification
/*      */     {
/*      */       private final ElementMatcher<? super FieldDescription.InDefinedShape> matcher;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean matchRead;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean matchWrite;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForMatchedField(MethodGraph.Compiler param2Compiler, MemberSubstitution.TypePoolResolver param2TypePoolResolver, boolean param2Boolean, MemberSubstitution.Replacement.Factory param2Factory, ElementMatcher<? super FieldDescription.InDefinedShape> param2ElementMatcher) {
/*  532 */         this(param2Compiler, param2TypePoolResolver, param2Boolean, param2Factory, param2ElementMatcher, true, true);
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
/*      */       protected ForMatchedField(MethodGraph.Compiler param2Compiler, MemberSubstitution.TypePoolResolver param2TypePoolResolver, boolean param2Boolean1, MemberSubstitution.Replacement.Factory param2Factory, ElementMatcher<? super FieldDescription.InDefinedShape> param2ElementMatcher, boolean param2Boolean2, boolean param2Boolean3) {
/*  553 */         super(param2Compiler, param2TypePoolResolver, param2Boolean1, param2Factory);
/*  554 */         this.matcher = param2ElementMatcher;
/*  555 */         this.matchRead = param2Boolean2;
/*  556 */         this.matchWrite = param2Boolean3;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.WithoutSpecification onRead() {
/*  565 */         return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, this.matcher, true, false);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.WithoutSpecification onWrite() {
/*  574 */         return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, this.matcher, false, true);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution replaceWith(MemberSubstitution.Substitution.Factory param2Factory) {
/*  581 */         return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new MemberSubstitution.Replacement.Factory.Compound(new MemberSubstitution.Replacement.Factory[] { this.replacementFactory, 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  586 */                 MemberSubstitution.Replacement.ForElementMatchers.Factory.ofField(this.matcher, this.matchRead, this.matchWrite, param2Factory) }));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.matchRead != ((ForMatchedField)param2Object).matchRead) ? false : ((this.matchWrite != ((ForMatchedField)param2Object).matchWrite) ? false : (!!this.matcher.equals(((ForMatchedField)param2Object).matcher)))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((super.hashCode() * 31 + this.matcher.hashCode()) * 31 + this.matchRead) * 31 + this.matchWrite;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForMatchedMethod
/*      */       extends WithoutSpecification
/*      */     {
/*      */       private final ElementMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean includeVirtualCalls;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean includeSuperCalls;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForMatchedMethod(MethodGraph.Compiler param2Compiler, MemberSubstitution.TypePoolResolver param2TypePoolResolver, boolean param2Boolean, MemberSubstitution.Replacement.Factory param2Factory, ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/*  625 */         this(param2Compiler, param2TypePoolResolver, param2Boolean, param2Factory, param2ElementMatcher, true, true);
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
/*      */       protected ForMatchedMethod(MethodGraph.Compiler param2Compiler, MemberSubstitution.TypePoolResolver param2TypePoolResolver, boolean param2Boolean1, MemberSubstitution.Replacement.Factory param2Factory, ElementMatcher<? super MethodDescription> param2ElementMatcher, boolean param2Boolean2, boolean param2Boolean3) {
/*  646 */         super(param2Compiler, param2TypePoolResolver, param2Boolean1, param2Factory);
/*  647 */         this.matcher = param2ElementMatcher;
/*  648 */         this.includeVirtualCalls = param2Boolean2;
/*  649 */         this.includeSuperCalls = param2Boolean3;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.WithoutSpecification onVirtualCall() {
/*  658 */         return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, (ElementMatcher<? super MethodDescription>)ElementMatchers.isVirtual().and(this.matcher), true, false);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.WithoutSpecification onSuperCall() {
/*  667 */         return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, (ElementMatcher<? super MethodDescription>)ElementMatchers.isVirtual().and(this.matcher), false, true);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution replaceWith(MemberSubstitution.Substitution.Factory param2Factory)
/*      */       {
/*  674 */         return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new MemberSubstitution.Replacement.Factory.Compound(new MemberSubstitution.Replacement.Factory[] { this.replacementFactory, 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  679 */                 MemberSubstitution.Replacement.ForElementMatchers.Factory.ofMethod(this.matcher, this.includeVirtualCalls, this.includeSuperCalls, param2Factory) })); } public boolean equals(@MaybeNull Object param2Object) { return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.includeVirtualCalls != ((ForMatchedMethod)param2Object).includeVirtualCalls) ? false : ((this.includeSuperCalls != ((ForMatchedMethod)param2Object).includeSuperCalls) ? false : (!!this.matcher.equals(((ForMatchedMethod)param2Object).matcher))))))); } public int hashCode() { return ((super.hashCode() * 31 + this.matcher.hashCode()) * 31 + this.includeVirtualCalls) * 31 + this.includeSuperCalls; } } } @Enhance protected static class ForMatchedByteCodeElement extends WithoutSpecification { private final ElementMatcher<? super ByteCodeElement> matcher; protected ForMatchedByteCodeElement(MethodGraph.Compiler param1Compiler, MemberSubstitution.TypePoolResolver param1TypePoolResolver, boolean param1Boolean, MemberSubstitution.Replacement.Factory param1Factory, ElementMatcher<? super ByteCodeElement> param1ElementMatcher) { super(param1Compiler, param1TypePoolResolver, param1Boolean, param1Factory); this.matcher = param1ElementMatcher; } public MemberSubstitution replaceWith(MemberSubstitution.Substitution.Factory param1Factory) { return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new MemberSubstitution.Replacement.Factory.Compound(new MemberSubstitution.Replacement.Factory[] { this.replacementFactory, MemberSubstitution.Replacement.ForElementMatchers.Factory.of(this.matcher, param1Factory) })); } public boolean equals(@MaybeNull Object param1Object) { return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.matcher.equals(((ForMatchedByteCodeElement)param1Object).matcher))))); } public int hashCode() { return super.hashCode() * 31 + this.matcher.hashCode(); } } @Enhance public static class ForMatchedField extends WithoutSpecification { private final ElementMatcher<? super FieldDescription.InDefinedShape> matcher; private final boolean matchRead; private final boolean matchWrite; protected ForMatchedField(MethodGraph.Compiler param1Compiler, MemberSubstitution.TypePoolResolver param1TypePoolResolver, boolean param1Boolean, MemberSubstitution.Replacement.Factory param1Factory, ElementMatcher<? super FieldDescription.InDefinedShape> param1ElementMatcher) { this(param1Compiler, param1TypePoolResolver, param1Boolean, param1Factory, param1ElementMatcher, true, true); } protected ForMatchedField(MethodGraph.Compiler param1Compiler, MemberSubstitution.TypePoolResolver param1TypePoolResolver, boolean param1Boolean1, MemberSubstitution.Replacement.Factory param1Factory, ElementMatcher<? super FieldDescription.InDefinedShape> param1ElementMatcher, boolean param1Boolean2, boolean param1Boolean3) { super(param1Compiler, param1TypePoolResolver, param1Boolean1, param1Factory); this.matcher = param1ElementMatcher; this.matchRead = param1Boolean2; this.matchWrite = param1Boolean3; } public MemberSubstitution.WithoutSpecification onRead() { return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, this.matcher, true, false); } public MemberSubstitution.WithoutSpecification onWrite() { return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, this.matcher, false, true); } public MemberSubstitution replaceWith(MemberSubstitution.Substitution.Factory param1Factory) { return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new MemberSubstitution.Replacement.Factory.Compound(new MemberSubstitution.Replacement.Factory[] { this.replacementFactory, MemberSubstitution.Replacement.ForElementMatchers.Factory.ofField(this.matcher, this.matchRead, this.matchWrite, param1Factory) })); } public boolean equals(@MaybeNull Object param1Object) { return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.matchRead != ((ForMatchedField)param1Object).matchRead) ? false : ((this.matchWrite != ((ForMatchedField)param1Object).matchWrite) ? false : (!!this.matcher.equals(((ForMatchedField)param1Object).matcher))))))); } public int hashCode() { return ((super.hashCode() * 31 + this.matcher.hashCode()) * 31 + this.matchRead) * 31 + this.matchWrite; } } @Enhance public static class ForMatchedMethod extends WithoutSpecification { private final ElementMatcher<? super MethodDescription> matcher; private final boolean includeVirtualCalls; private final boolean includeSuperCalls; protected ForMatchedMethod(MethodGraph.Compiler param1Compiler, MemberSubstitution.TypePoolResolver param1TypePoolResolver, boolean param1Boolean, MemberSubstitution.Replacement.Factory param1Factory, ElementMatcher<? super MethodDescription> param1ElementMatcher) { this(param1Compiler, param1TypePoolResolver, param1Boolean, param1Factory, param1ElementMatcher, true, true); } protected ForMatchedMethod(MethodGraph.Compiler param1Compiler, MemberSubstitution.TypePoolResolver param1TypePoolResolver, boolean param1Boolean1, MemberSubstitution.Replacement.Factory param1Factory, ElementMatcher<? super MethodDescription> param1ElementMatcher, boolean param1Boolean2, boolean param1Boolean3) { super(param1Compiler, param1TypePoolResolver, param1Boolean1, param1Factory); this.matcher = param1ElementMatcher; this.includeVirtualCalls = param1Boolean2; this.includeSuperCalls = param1Boolean3; } public MemberSubstitution.WithoutSpecification onVirtualCall() { return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, (ElementMatcher<? super MethodDescription>)ElementMatchers.isVirtual().and(this.matcher), true, false); } public MemberSubstitution.WithoutSpecification onSuperCall() { return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, (ElementMatcher<? super MethodDescription>)ElementMatchers.isVirtual().and(this.matcher), false, true); } public MemberSubstitution replaceWith(MemberSubstitution.Substitution.Factory param1Factory) { return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new MemberSubstitution.Replacement.Factory.Compound(new MemberSubstitution.Replacement.Factory[] { this.replacementFactory, MemberSubstitution.Replacement.ForElementMatchers.Factory.ofMethod(this.matcher, this.includeVirtualCalls, this.includeSuperCalls, param1Factory) })); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.includeVirtualCalls != ((ForMatchedMethod)param1Object).includeVirtualCalls) ? false : ((this.includeSuperCalls != ((ForMatchedMethod)param1Object).includeSuperCalls) ? false : (!!this.matcher.equals(((ForMatchedMethod)param1Object).matcher)))))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return ((super.hashCode() * 31 + this.matcher.hashCode()) * 31 + this.includeVirtualCalls) * 31 + this.includeSuperCalls;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum OfImplicitPool
/*      */     implements TypePoolResolver
/*      */   {
/*  707 */     INSTANCE;
/*      */ 
/*      */ 
/*      */     
/*      */     public final TypePool resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, TypePool param1TypePool)
/*      */     {
/*  713 */       return param1TypePool; } } public static interface TypePoolResolver { TypePool resolve(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, TypePool param1TypePool); public enum OfImplicitPool implements TypePoolResolver { INSTANCE; public final TypePool resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, TypePool param2TypePool) { return param2TypePool; }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForExplicitPool
/*      */       implements TypePoolResolver
/*      */     {
/*      */       private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ForExplicitPool(TypePool param2TypePool) {
/*  734 */         this.typePool = param2TypePool;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypePool resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, TypePool param2TypePool) {
/*  741 */         return this.typePool;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typePool.equals(((ForExplicitPool)param2Object).typePool))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.typePool.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForClassFileLocator
/*      */       implements TypePoolResolver
/*      */     {
/*      */       private final ClassFileLocator classFileLocator;
/*      */       
/*      */       private final TypePool.Default.ReaderMode readerMode;
/*      */ 
/*      */       
/*      */       public ForClassFileLocator(ClassFileLocator param2ClassFileLocator) {
/*  767 */         this(param2ClassFileLocator, TypePool.Default.ReaderMode.FAST);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ForClassFileLocator(ClassFileLocator param2ClassFileLocator, TypePool.Default.ReaderMode param2ReaderMode) {
/*  777 */         this.classFileLocator = param2ClassFileLocator;
/*  778 */         this.readerMode = param2ReaderMode;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static MemberSubstitution.TypePoolResolver of(@MaybeNull ClassLoader param2ClassLoader) {
/*  788 */         return new ForClassFileLocator(ClassFileLocator.ForClassLoader.of(param2ClassLoader));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypePool resolve(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, TypePool param2TypePool) {
/*  795 */         return (TypePool)new TypePool.Default((TypePool.CacheProvider)new TypePool.CacheProvider.Simple(), this.classFileLocator, this.readerMode, param2TypePool);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.readerMode.equals(((ForClassFileLocator)param2Object).readerMode) ? false : (!!this.classFileLocator.equals(((ForClassFileLocator)param2Object).classFileLocator)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.classFileLocator.hashCode()) * 31 + this.readerMode.hashCode();
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Substitution
/*      */   {
/*      */     StackManipulation resolve(TypeDescription param1TypeDescription, ByteCodeElement param1ByteCodeElement, TypeList.Generic param1Generic, TypeDescription.Generic param1Generic1, int param1Int);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Factory
/*      */     {
/*      */       MemberSubstitution.Substitution make(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, TypePool param2TypePool);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Stubbing
/*      */       implements Substitution, Factory
/*      */     {
/*  845 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MemberSubstitution.Substitution make(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, TypePool param2TypePool) {
/*  851 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final StackManipulation resolve(TypeDescription param2TypeDescription, ByteCodeElement param2ByteCodeElement, TypeList.Generic param2Generic, TypeDescription.Generic param2Generic1, int param2Int) {
/*  862 */         ArrayList<StackManipulation> arrayList = new ArrayList(param2Generic.size());
/*  863 */         for (int i = param2Generic.size() - 1; i >= 0; i--) {
/*  864 */           arrayList.add(Removal.of((TypeDefinition)param2Generic.get(i)));
/*      */         }
/*  866 */         return (StackManipulation)new StackManipulation.Compound(CompoundList.of(arrayList, DefaultValue.of((TypeDefinition)param2Generic1.asErasure())));
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForFieldAccess
/*      */       implements Substitution
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final FieldResolver fieldResolver;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ForFieldAccess(TypeDescription param2TypeDescription, FieldResolver param2FieldResolver) {
/*  893 */         this.instrumentedType = param2TypeDescription;
/*  894 */         this.fieldResolver = param2FieldResolver;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*      */       public StackManipulation resolve(TypeDescription param2TypeDescription, ByteCodeElement param2ByteCodeElement, TypeList.Generic param2Generic, TypeDescription.Generic param2Generic1, int param2Int) {
/*      */         FieldDescription fieldDescription;
/*  907 */         if (!(fieldDescription = this.fieldResolver.resolve(param2TypeDescription, param2ByteCodeElement, param2Generic, param2Generic1)).isAccessibleTo(this.instrumentedType))
/*  908 */           throw new IllegalStateException(this.instrumentedType + " cannot access " + fieldDescription); 
/*  909 */         if (param2Generic1.represents(void.class)) {
/*  910 */           if (param2Generic.size() != (fieldDescription.isStatic() ? 1 : 2))
/*  911 */             throw new IllegalStateException("Cannot set " + fieldDescription + " with " + param2Generic); 
/*  912 */           if (!fieldDescription.isStatic() && !((TypeDescription.Generic)param2Generic.get(0)).asErasure().isAssignableTo(fieldDescription.getDeclaringType().asErasure()))
/*  913 */             throw new IllegalStateException("Cannot set " + fieldDescription + " on " + param2Generic.get(0)); 
/*  914 */           if (!((TypeDescription.Generic)param2Generic.get(fieldDescription.isStatic() ? 0 : 1)).asErasure().isAssignableTo(fieldDescription.getType().asErasure())) {
/*  915 */             throw new IllegalStateException("Cannot set " + fieldDescription + " to " + param2Generic.get(fieldDescription.isStatic() ? 0 : 1));
/*      */           }
/*  917 */           return FieldAccess.forField(fieldDescription).write();
/*      */         } 
/*  919 */         if (param2Generic.size() != (fieldDescription.isStatic() ? 0 : 1))
/*  920 */           throw new IllegalStateException("Cannot set " + fieldDescription + " with " + param2Generic); 
/*  921 */         if (!fieldDescription.isStatic() && !((TypeDescription.Generic)param2Generic.get(0)).asErasure().isAssignableTo(fieldDescription.getDeclaringType().asErasure()))
/*  922 */           throw new IllegalStateException("Cannot get " + fieldDescription + " on " + param2Generic.get(0)); 
/*  923 */         if (!fieldDescription.getType().asErasure().isAssignableTo(param2Generic1.asErasure())) {
/*  924 */           throw new IllegalStateException("Cannot get " + fieldDescription + " as " + param2Generic1);
/*      */         }
/*  926 */         return FieldAccess.forField(fieldDescription).read();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedType.equals(((ForFieldAccess)param2Object).instrumentedType) ? false : (!!this.fieldResolver.equals(((ForFieldAccess)param2Object).fieldResolver)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.fieldResolver.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface FieldResolver
/*      */       {
/*      */         FieldDescription resolve(TypeDescription param3TypeDescription, ByteCodeElement param3ByteCodeElement, TypeList.Generic param3Generic, TypeDescription.Generic param3Generic1);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Simple
/*      */           implements FieldResolver
/*      */         {
/*      */           private final FieldDescription fieldDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Simple(FieldDescription param4FieldDescription) {
/*  963 */             this.fieldDescription = param4FieldDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public FieldDescription resolve(TypeDescription param4TypeDescription, ByteCodeElement param4ByteCodeElement, TypeList.Generic param4Generic, TypeDescription.Generic param4Generic1) {
/*  970 */             return this.fieldDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.fieldDescription.equals(((Simple)param4Object).fieldDescription))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class ForElementMatcher
/*      */           implements FieldResolver
/*      */         {
/*      */           private final TypeDescription instrumentedType;
/*      */           
/*      */           private final ElementMatcher<? super FieldDescription> matcher;
/*      */ 
/*      */           
/*      */           protected ForElementMatcher(TypeDescription param4TypeDescription, ElementMatcher<? super FieldDescription> param4ElementMatcher) {
/*  997 */             this.instrumentedType = param4TypeDescription;
/*  998 */             this.matcher = param4ElementMatcher;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public FieldDescription resolve(TypeDescription param4TypeDescription, ByteCodeElement param4ByteCodeElement, TypeList.Generic param4Generic, TypeDescription.Generic param4Generic1) {
/* 1005 */             if (param4Generic.isEmpty())
/* 1006 */               throw new IllegalStateException("Cannot substitute parameterless instruction with " + param4ByteCodeElement); 
/* 1007 */             if (((TypeDescription.Generic)param4Generic.get(0)).isPrimitive() || ((TypeDescription.Generic)param4Generic.get(0)).isArray()) {
/* 1008 */               throw new IllegalStateException("Cannot access field on primitive or array type for " + param4ByteCodeElement);
/*      */             }
/* 1010 */             TypeDefinition typeDefinition = (TypeDefinition)((TypeDescription.Generic)param4Generic.get(0)).accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Substitutor.ForReplacement(this.instrumentedType));
/*      */             while (true) {
/*      */               FieldList fieldList;
/* 1013 */               if ((fieldList = (FieldList)typeDefinition.getDeclaredFields().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isStatic()).and((ElementMatcher)ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher))).size() == 1)
/* 1014 */                 return (FieldDescription)fieldList.getOnly(); 
/* 1015 */               if (fieldList.size() > 1) {
/* 1016 */                 throw new IllegalStateException("Ambiguous field location of " + fieldList);
/*      */               }
/*      */               TypeDescription.Generic generic;
/* 1019 */               if ((generic = typeDefinition.getSuperClass()) == null) {
/* 1020 */                 throw new IllegalStateException("Cannot locate field matching " + this.matcher + " on " + param4TypeDescription);
/*      */               }
/*      */             } 
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.instrumentedType.equals(((ForElementMatcher)param4Object).instrumentedType) ? false : (!!this.matcher.equals(((ForElementMatcher)param4Object).matcher)))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.matcher.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class OfGivenField
/*      */         implements MemberSubstitution.Substitution.Factory
/*      */       {
/*      */         private final FieldDescription fieldDescription;
/*      */         
/*      */         public OfGivenField(FieldDescription param3FieldDescription) {
/* 1042 */           this.fieldDescription = param3FieldDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MemberSubstitution.Substitution make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 1049 */           return new MemberSubstitution.Substitution.ForFieldAccess(param3TypeDescription, new MemberSubstitution.Substitution.ForFieldAccess.FieldResolver.Simple(this.fieldDescription));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((OfGivenField)param3Object).fieldDescription))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class OfMatchedField
/*      */         implements MemberSubstitution.Substitution.Factory
/*      */       {
/*      */         private final ElementMatcher<? super FieldDescription> matcher;
/*      */         
/*      */         public OfMatchedField(ElementMatcher<? super FieldDescription> param3ElementMatcher) {
/* 1070 */           this.matcher = param3ElementMatcher;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MemberSubstitution.Substitution make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 1077 */           return new MemberSubstitution.Substitution.ForFieldAccess(param3TypeDescription, new MemberSubstitution.Substitution.ForFieldAccess.FieldResolver.ForElementMatcher(param3TypeDescription, this.matcher));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.matcher.equals(((OfMatchedField)param3Object).matcher))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.matcher.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForMethodInvocation
/*      */       implements Substitution
/*      */     {
/*      */       private static final int THIS_REFERENCE = 0;
/*      */ 
/*      */       
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */       
/*      */       private final MethodResolver methodResolver;
/*      */ 
/*      */       
/*      */       public ForMethodInvocation(TypeDescription param2TypeDescription, MethodResolver param2MethodResolver) {
/* 1110 */         this.instrumentedType = param2TypeDescription;
/* 1111 */         this.methodResolver = param2MethodResolver;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public StackManipulation resolve(TypeDescription param2TypeDescription, ByteCodeElement param2ByteCodeElement, TypeList.Generic param2Generic, TypeDescription.Generic param2Generic1, int param2Int) {
/*      */         MethodDescription methodDescription;
/* 1123 */         if (!(methodDescription = this.methodResolver.resolve(param2TypeDescription, param2ByteCodeElement, param2Generic, param2Generic1)).isAccessibleTo(this.instrumentedType)) {
/* 1124 */           throw new IllegalStateException(this.instrumentedType + " cannot access " + methodDescription);
/*      */         }
/*      */ 
/*      */         
/* 1128 */         param2ByteCodeElement = methodDescription.isStatic() ? (ByteCodeElement)methodDescription.getParameters().asTypeList() : (ByteCodeElement)new TypeList.Generic.Explicit(CompoundList.of(methodDescription.getDeclaringType(), (List)methodDescription.getParameters().asTypeList()));
/* 1129 */         if (!methodDescription.getReturnType().asErasure().isAssignableTo(param2Generic1.asErasure()))
/* 1130 */           throw new IllegalStateException("Cannot assign return value of " + methodDescription + " to " + param2Generic1); 
/* 1131 */         if (param2ByteCodeElement.size() != param2Generic.size()) {
/* 1132 */           throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + param2Generic.size() + " parameters");
/*      */         }
/* 1134 */         for (byte b = 0; b < param2ByteCodeElement.size(); b++) {
/* 1135 */           if (!((TypeDescription.Generic)param2Generic.get(b)).asErasure().isAssignableTo(((TypeDescription.Generic)param2ByteCodeElement.get(b)).asErasure())) {
/* 1136 */             throw new IllegalStateException("Cannot invoke " + methodDescription + " on parameter " + b + " of type " + param2Generic.get(b));
/*      */           }
/*      */         } 
/* 1139 */         if (methodDescription.isVirtual())
/* 1140 */           return MethodInvocation.invoke(methodDescription).virtual(((TypeDescription.Generic)param2ByteCodeElement.get(0)).asErasure()); 
/* 1141 */         return (StackManipulation)MethodInvocation.invoke(methodDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedType.equals(((ForMethodInvocation)param2Object).instrumentedType) ? false : (!!this.methodResolver.equals(((ForMethodInvocation)param2Object).methodResolver)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.methodResolver.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface MethodResolver
/*      */       {
/*      */         MethodDescription resolve(TypeDescription param3TypeDescription, ByteCodeElement param3ByteCodeElement, TypeList.Generic param3Generic, TypeDescription.Generic param3Generic1);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Simple
/*      */           implements MethodResolver
/*      */         {
/*      */           private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */           
/*      */           public Simple(MethodDescription param4MethodDescription) {
/* 1177 */             this.methodDescription = param4MethodDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription resolve(TypeDescription param4TypeDescription, ByteCodeElement param4ByteCodeElement, TypeList.Generic param4Generic, TypeDescription.Generic param4Generic1) {
/* 1184 */             return this.methodDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.methodDescription.equals(((Simple)param4Object).methodDescription))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.methodDescription.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Matching
/*      */           implements MethodResolver
/*      */         {
/*      */           private final TypeDescription instrumentedType;
/*      */ 
/*      */           
/*      */           private final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */           
/*      */           private final ElementMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */ 
/*      */           
/*      */           public Matching(TypeDescription param4TypeDescription, MethodGraph.Compiler param4Compiler, ElementMatcher<? super MethodDescription> param4ElementMatcher) {
/* 1217 */             this.instrumentedType = param4TypeDescription;
/* 1218 */             this.methodGraphCompiler = param4Compiler;
/* 1219 */             this.matcher = param4ElementMatcher;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription resolve(TypeDescription param4TypeDescription, ByteCodeElement param4ByteCodeElement, TypeList.Generic param4Generic, TypeDescription.Generic param4Generic1) {
/* 1226 */             if (param4Generic.isEmpty())
/* 1227 */               throw new IllegalStateException("Cannot substitute parameterless instruction with " + param4ByteCodeElement); 
/* 1228 */             if (((TypeDescription.Generic)param4Generic.get(0)).isPrimitive() || ((TypeDescription.Generic)param4Generic.get(0)).isArray()) {
/* 1229 */               throw new IllegalStateException("Cannot invoke method on primitive or array type for " + param4ByteCodeElement);
/*      */             }
/* 1231 */             TypeDefinition typeDefinition = (TypeDefinition)((TypeDescription.Generic)param4Generic.get(0)).accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Substitutor.ForReplacement(this.instrumentedType));
/*      */ 
/*      */             
/*      */             List<?> list;
/*      */             
/* 1236 */             if ((list = CompoundList.of((List)this.methodGraphCompiler.compile(typeDefinition, this.instrumentedType).listNodes().asMethodList().filter(this.matcher), (List)typeDefinition.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isPrivate().and((ElementMatcher)ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher)))).size() == 1) {
/* 1237 */               return (MethodDescription)list.get(0);
/*      */             }
/* 1239 */             throw new IllegalStateException("Not exactly one method that matches " + this.matcher + ": " + list);
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.instrumentedType.equals(((Matching)param4Object).instrumentedType) ? false : (!this.methodGraphCompiler.equals(((Matching)param4Object).methodGraphCompiler) ? false : (!!this.matcher.equals(((Matching)param4Object).matcher))))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return ((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.matcher.hashCode();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       enum OfInstrumentedMethod implements MemberSubstitution.Substitution.Factory {
/* 1253 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final MemberSubstitution.Substitution make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 1259 */           return new MemberSubstitution.Substitution.ForMethodInvocation(param3TypeDescription, new MemberSubstitution.Substitution.ForMethodInvocation.MethodResolver.Simple(param3MethodDescription));
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class OfGivenMethod
/*      */         implements MemberSubstitution.Substitution.Factory
/*      */       {
/*      */         private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public OfGivenMethod(MethodDescription param3MethodDescription) {
/* 1280 */           this.methodDescription = param3MethodDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MemberSubstitution.Substitution make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 1287 */           return new MemberSubstitution.Substitution.ForMethodInvocation(param3TypeDescription, new MemberSubstitution.Substitution.ForMethodInvocation.MethodResolver.Simple(this.methodDescription));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.methodDescription.equals(((OfGivenMethod)param3Object).methodDescription))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.methodDescription.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class OfMatchedMethod
/*      */         implements MemberSubstitution.Substitution.Factory
/*      */       {
/*      */         private final ElementMatcher<? super MethodDescription> matcher;
/*      */         
/*      */         private final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */         
/*      */         public OfMatchedMethod(ElementMatcher<? super MethodDescription> param3ElementMatcher, MethodGraph.Compiler param3Compiler) {
/* 1314 */           this.matcher = param3ElementMatcher;
/* 1315 */           this.methodGraphCompiler = param3Compiler;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MemberSubstitution.Substitution make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 1322 */           return new MemberSubstitution.Substitution.ForMethodInvocation(param3TypeDescription, new MemberSubstitution.Substitution.ForMethodInvocation.MethodResolver.Matching(param3TypeDescription, this.methodGraphCompiler, this.matcher));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.matcher.equals(((OfMatchedMethod)param3Object).matcher) ? false : (!!this.methodGraphCompiler.equals(((OfMatchedMethod)param3Object).methodGraphCompiler)))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.methodGraphCompiler.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Chain
/*      */       implements Substitution
/*      */     {
/*      */       private final Assigner assigner;
/*      */ 
/*      */       
/*      */       private final Assigner.Typing typing;
/*      */ 
/*      */       
/*      */       private final List<Step> steps;
/*      */ 
/*      */ 
/*      */       
/*      */       protected Chain(Assigner param2Assigner, Assigner.Typing param2Typing, List<Step> param2List) {
/* 1356 */         this.assigner = param2Assigner;
/* 1357 */         this.typing = param2Typing;
/* 1358 */         this.steps = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static Factory withDefaultAssigner() {
/* 1367 */         return with(Assigner.DEFAULT, Assigner.Typing.STATIC);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static Factory with(Assigner param2Assigner, Assigner.Typing param2Typing) {
/* 1378 */         return new Factory(param2Assigner, param2Typing, Collections.emptyList());
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
/*      */       public StackManipulation resolve(TypeDescription param2TypeDescription, ByteCodeElement param2ByteCodeElement, TypeList.Generic param2Generic, TypeDescription.Generic param2Generic1, int param2Int) {
/* 1392 */         ArrayList<StackManipulation> arrayList = new ArrayList(1 + param2Generic.size() + (this.steps.size() << 1) + (param2Generic1.represents(void.class) ? 0 : 2));
/* 1393 */         HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1394 */         for (int i = param2Generic.size() - 1; i >= 0; i--) {
/* 1395 */           arrayList.add(MethodVariableAccess.of((TypeDefinition)param2Generic.get(i)).storeAt(param2Int));
/* 1396 */           hashMap.put(Integer.valueOf(i), Integer.valueOf(param2Int));
/* 1397 */           param2Int += ((TypeDescription.Generic)param2Generic.get(i)).getStackSize().getSize();
/*      */         } 
/* 1399 */         arrayList.add(DefaultValue.of((TypeDefinition)param2Generic1));
/* 1400 */         TypeDescription.Generic generic = param2Generic1;
/* 1401 */         for (Iterator<Step> iterator = this.steps.iterator(); iterator.hasNext(); ) {
/* 1402 */           Step step; Step.Resolution resolution = (step = iterator.next()).resolve(param2TypeDescription, param2ByteCodeElement, param2Generic, generic, (Map)hashMap, param2Int);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1408 */           arrayList.add(resolution.getStackManipulation());
/* 1409 */           generic = resolution.getResultType();
/*      */         } 
/* 1411 */         arrayList.add(this.assigner.assign(generic, param2Generic1, this.typing));
/* 1412 */         return (StackManipulation)new StackManipulation.Compound(arrayList);
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
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typing.equals(((Chain)param2Object).typing) ? false : (!this.assigner.equals(((Chain)param2Object).assigner) ? false : (!!this.steps.equals(((Chain)param2Object).steps))))));
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
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.assigner.hashCode()) * 31 + this.typing.hashCode()) * 31 + this.steps.hashCode();
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
/*      */       public static interface Resolution
/*      */       {
/*      */         StackManipulation getStackManipulation();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         TypeDescription.Generic getResultType();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Step
/*      */       {
/*      */         Resolution resolve(TypeDescription param3TypeDescription, ByteCodeElement param3ByteCodeElement, TypeList.Generic param3Generic, TypeDescription.Generic param3Generic1, Map<Integer, Integer> param3Map, int param3Int);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Simple
/*      */           implements Step, Factory, Resolution
/*      */         {
/*      */           private final StackManipulation stackManipulation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeDescription.Generic resultType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Simple(StackManipulation param4StackManipulation, TypeDescription.Generic param4Generic) {
/* 1501 */             this.stackManipulation = param4StackManipulation;
/* 1502 */             this.resultType = param4Generic;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MemberSubstitution.Substitution.Chain.Step make(Assigner param4Assigner, Assigner.Typing param4Typing, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription) {
/* 1509 */             return this;
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
/*      */           public MemberSubstitution.Substitution.Chain.Step.Resolution resolve(TypeDescription param4TypeDescription, ByteCodeElement param4ByteCodeElement, TypeList.Generic param4Generic, TypeDescription.Generic param4Generic1, Map<Integer, Integer> param4Map, int param4Int) {
/* 1521 */             return param4TypeDescription.represents(void.class) ? this : new Simple((StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/*      */                     
/* 1523 */                     Removal.of((TypeDefinition)param4TypeDescription), this.stackManipulation }, ), this.resultType);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public StackManipulation getStackManipulation() {
/* 1530 */             return this.stackManipulation;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic getResultType() {
/* 1537 */             return this.resultType;
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.stackManipulation.equals(((Simple)param4Object).stackManipulation) ? false : (!!this.resultType.equals(((Simple)param4Object).resultType)))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.stackManipulation.hashCode()) * 31 + this.resultType.hashCode();
/*      */           }
/*      */         }
/*      */         
/*      */         public static interface Factory
/*      */         {
/*      */           MemberSubstitution.Substitution.Chain.Step make(Assigner param4Assigner, Assigner.Typing param4Typing, TypeDescription param4TypeDescription, MethodDescription param4MethodDescription);
/*      */         }
/*      */         
/*      */         public static interface Resolution
/*      */         {
/*      */           StackManipulation getStackManipulation();
/*      */           
/*      */           TypeDescription.Generic getResultType();
/*      */         }
/*      */       }
/*      */       
/*      */       public static class Factory
/*      */         implements MemberSubstitution.Substitution.Factory
/*      */       {
/*      */         private final Assigner assigner;
/*      */         private final Assigner.Typing typing;
/*      */         private final List<MemberSubstitution.Substitution.Chain.Step.Factory> steps;
/*      */         
/*      */         protected Factory(Assigner param3Assigner, Assigner.Typing param3Typing, List<MemberSubstitution.Substitution.Chain.Step.Factory> param3List) {
/* 1570 */           this.assigner = param3Assigner;
/* 1571 */           this.typing = param3Typing;
/* 1572 */           this.steps = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MemberSubstitution.Substitution make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 1579 */           if (this.steps.isEmpty()) {
/* 1580 */             return MemberSubstitution.Substitution.Stubbing.INSTANCE;
/*      */           }
/* 1582 */           ArrayList<MemberSubstitution.Substitution.Chain.Step> arrayList = new ArrayList(this.steps.size());
/* 1583 */           for (MemberSubstitution.Substitution.Chain.Step.Factory factory : this.steps) {
/* 1584 */             arrayList.add(factory.make(this.assigner, this.typing, param3TypeDescription, param3MethodDescription));
/*      */           }
/* 1586 */           return new MemberSubstitution.Substitution.Chain(this.assigner, this.typing, arrayList);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Factory executing(MemberSubstitution.Substitution.Chain.Step.Factory... param3VarArgs) {
/* 1596 */           return executing(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Factory executing(List<? extends MemberSubstitution.Substitution.Chain.Step.Factory> param3List) {
/* 1606 */           return new Factory(this.assigner, this.typing, CompoundList.of(this.steps, param3List));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Factory
/*      */   {
/*      */     MemberSubstitution.Replacement make(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, TypePool param1TypePool);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */       implements Factory
/*      */     {
/*      */       protected Compound(MemberSubstitution.Replacement.Factory... param3VarArgs) {
/* 1778 */         this(Arrays.asList(param3VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1787 */       private final List<MemberSubstitution.Replacement.Factory> factories = new ArrayList<MemberSubstitution.Replacement.Factory>(); protected Compound(List<? extends MemberSubstitution.Replacement.Factory> param3List) {
/* 1788 */         for (Iterator<? extends MemberSubstitution.Replacement.Factory> iterator = param3List.iterator(); iterator.hasNext(); ) {
/* 1789 */           MemberSubstitution.Replacement.Factory factory; if (factory = iterator.next() instanceof Compound) {
/* 1790 */             this.factories.addAll(((Compound)factory).factories); continue;
/* 1791 */           }  if (!(factory instanceof MemberSubstitution.Replacement.NoOp)) {
/* 1792 */             this.factories.add(factory);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.Replacement make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 1801 */         ArrayList<MemberSubstitution.Replacement> arrayList = new ArrayList();
/* 1802 */         for (MemberSubstitution.Replacement.Factory factory : this.factories) {
/* 1803 */           arrayList.add(factory.make(param3TypeDescription, param3MethodDescription, param3TypePool));
/*      */         }
/* 1805 */         return new MemberSubstitution.Replacement.ForFirstBinding(arrayList);
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
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.factories.equals(((Compound)param3Object).factories))));
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
/*      */         return getClass().hashCode() * 31 + this.factories.hashCode();
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
/*      */   public enum NoOp
/*      */     implements Replacement, Replacement.Factory
/*      */   {
/* 1878 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MemberSubstitution.Replacement make(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, TypePool param1TypePool) {
/* 1884 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MemberSubstitution.Replacement.Binding bind(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, FieldDescription.InDefinedShape param1InDefinedShape, boolean param1Boolean) {
/* 1894 */       return MemberSubstitution.Replacement.Binding.Unresolved.INSTANCE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final MemberSubstitution.Replacement.Binding bind(TypeDescription param1TypeDescription1, MethodDescription param1MethodDescription1, TypeDescription param1TypeDescription2, MethodDescription param1MethodDescription2, MemberSubstitution.Replacement.InvocationType param1InvocationType)
/*      */     {
/* 1905 */       return MemberSubstitution.Replacement.Binding.Unresolved.INSTANCE; } } protected static interface Replacement { Binding bind(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, FieldDescription.InDefinedShape param1InDefinedShape, boolean param1Boolean); Binding bind(TypeDescription param1TypeDescription1, MethodDescription param1MethodDescription1, TypeDescription param1TypeDescription2, MethodDescription param1MethodDescription2, InvocationType param1InvocationType); public static interface Binding { boolean isBound(); StackManipulation make(TypeList.Generic param2Generic, TypeDescription.Generic param2Generic1, int param2Int); public enum Unresolved implements Binding { INSTANCE; public final boolean isBound() { return false; } public final StackManipulation make(TypeList.Generic param3Generic, TypeDescription.Generic param3Generic1, int param3Int) { throw new IllegalStateException("Cannot resolve unresolved binding"); } } @Enhance public static class Resolved implements Binding { private final TypeDescription targetType; private final ByteCodeElement target; private final MemberSubstitution.Substitution substitution; protected Resolved(TypeDescription param3TypeDescription, ByteCodeElement param3ByteCodeElement, MemberSubstitution.Substitution param3Substitution) { this.targetType = param3TypeDescription; this.target = param3ByteCodeElement; this.substitution = param3Substitution; } public boolean isBound() { return true; } public StackManipulation make(TypeList.Generic param3Generic, TypeDescription.Generic param3Generic1, int param3Int) { return this.substitution.resolve(this.targetType, this.target, param3Generic, param3Generic1, param3Int); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.targetType.equals(((Resolved)param3Object).targetType) ? false : (!this.target.equals(((Resolved)param3Object).target) ? false : (!!this.substitution.equals(((Resolved)param3Object).substitution)))))); } public int hashCode() { return ((getClass().hashCode() * 31 + this.targetType.hashCode()) * 31 + this.target.hashCode()) * 31 + this.substitution.hashCode(); } } } public static interface Factory { MemberSubstitution.Replacement make(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, TypePool param2TypePool); @Enhance public static class Compound implements Factory { protected Compound(MemberSubstitution.Replacement.Factory... param3VarArgs) { this(Arrays.asList(param3VarArgs)); } private final List<MemberSubstitution.Replacement.Factory> factories = new ArrayList<MemberSubstitution.Replacement.Factory>(); protected Compound(List<? extends MemberSubstitution.Replacement.Factory> param3List) { for (Iterator<? extends MemberSubstitution.Replacement.Factory> iterator = param3List.iterator(); iterator.hasNext(); ) { MemberSubstitution.Replacement.Factory factory; if (factory = iterator.next() instanceof Compound) { this.factories.addAll(((Compound)factory).factories); continue; }  if (!(factory instanceof MemberSubstitution.Replacement.NoOp)) this.factories.add(factory);  }  } public MemberSubstitution.Replacement make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) { ArrayList<MemberSubstitution.Replacement> arrayList = new ArrayList(); for (MemberSubstitution.Replacement.Factory factory : this.factories) arrayList.add(factory.make(param3TypeDescription, param3MethodDescription, param3TypePool));  return new MemberSubstitution.Replacement.ForFirstBinding(arrayList); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.factories.equals(((Compound)param3Object).factories)))); } public int hashCode() { return getClass().hashCode() * 31 + this.factories.hashCode(); } } } public enum InvocationType { VIRTUAL, SUPER, OTHER; protected static InvocationType of(int param2Int, MethodDescription param2MethodDescription) { switch (param2Int) { case 182: case 185: return VIRTUAL;case 183: return param2MethodDescription.isVirtual() ? SUPER : OTHER; }  return OTHER; } protected final boolean matches(boolean param2Boolean1, boolean param2Boolean2) { switch (MemberSubstitution.null.a[ordinal()]) { case 1: return param2Boolean1;case 2: return param2Boolean2; }  return true; } } public enum NoOp implements Replacement, Factory { public final MemberSubstitution.Replacement.Binding bind(TypeDescription param2TypeDescription1, MethodDescription param2MethodDescription1, TypeDescription param2TypeDescription2, MethodDescription param2MethodDescription2, MemberSubstitution.Replacement.InvocationType param2InvocationType) { return MemberSubstitution.Replacement.Binding.Unresolved.INSTANCE; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MemberSubstitution.Replacement make(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, TypePool param2TypePool) {
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final MemberSubstitution.Replacement.Binding bind(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, FieldDescription.InDefinedShape param2InDefinedShape, boolean param2Boolean) {
/*      */         return MemberSubstitution.Replacement.Binding.Unresolved.INSTANCE;
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForElementMatchers
/*      */       implements Replacement
/*      */     {
/*      */       private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
/*      */ 
/*      */ 
/*      */       
/*      */       private final ElementMatcher<? super MethodDescription> methodMatcher;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean matchFieldRead;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean matchFieldWrite;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean includeVirtualCalls;
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean includeSuperCalls;
/*      */ 
/*      */ 
/*      */       
/*      */       private final MemberSubstitution.Substitution substitution;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForElementMatchers(ElementMatcher<? super FieldDescription.InDefinedShape> param2ElementMatcher, ElementMatcher<? super MethodDescription> param2ElementMatcher1, boolean param2Boolean1, boolean param2Boolean2, boolean param2Boolean3, boolean param2Boolean4, MemberSubstitution.Substitution param2Substitution) {
/* 1968 */         this.fieldMatcher = param2ElementMatcher;
/* 1969 */         this.methodMatcher = param2ElementMatcher1;
/* 1970 */         this.matchFieldRead = param2Boolean1;
/* 1971 */         this.matchFieldWrite = param2Boolean2;
/* 1972 */         this.includeVirtualCalls = param2Boolean3;
/* 1973 */         this.includeSuperCalls = param2Boolean4;
/* 1974 */         this.substitution = param2Substitution;
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
/*      */       public MemberSubstitution.Replacement.Binding bind(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, FieldDescription.InDefinedShape param2InDefinedShape, boolean param2Boolean) {
/*      */         // Byte code:
/*      */         //   0: iload #4
/*      */         //   2: ifeq -> 15
/*      */         //   5: aload_0
/*      */         //   6: getfield matchFieldWrite : Z
/*      */         //   9: ifeq -> 54
/*      */         //   12: goto -> 22
/*      */         //   15: aload_0
/*      */         //   16: getfield matchFieldRead : Z
/*      */         //   19: ifeq -> 54
/*      */         //   22: aload_0
/*      */         //   23: getfield fieldMatcher : Lnet/bytebuddy/matcher/ElementMatcher;
/*      */         //   26: aload_3
/*      */         //   27: invokeinterface matches : (Ljava/lang/Object;)Z
/*      */         //   32: ifeq -> 54
/*      */         //   35: new net/bytebuddy/asm/MemberSubstitution$Replacement$Binding$Resolved
/*      */         //   38: dup
/*      */         //   39: aload_3
/*      */         //   40: invokeinterface getDeclaringType : ()Lnet/bytebuddy/description/type/TypeDescription;
/*      */         //   45: aload_3
/*      */         //   46: aload_0
/*      */         //   47: getfield substitution : Lnet/bytebuddy/asm/MemberSubstitution$Substitution;
/*      */         //   50: invokespecial <init> : (Lnet/bytebuddy/description/type/TypeDescription;Lnet/bytebuddy/description/ByteCodeElement;Lnet/bytebuddy/asm/MemberSubstitution$Substitution;)V
/*      */         //   53: areturn
/*      */         //   54: getstatic net/bytebuddy/asm/MemberSubstitution$Replacement$Binding$Unresolved.INSTANCE : Lnet/bytebuddy/asm/MemberSubstitution$Replacement$Binding$Unresolved;
/*      */         //   57: areturn
/*      */         // Line number table:
/*      */         //   Java source line number -> byte code offset
/*      */         //   #1984	-> 0
/*      */         //   #1985	-> 40
/*      */         //   #1984	-> 57
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.Replacement.Binding bind(TypeDescription param2TypeDescription1, MethodDescription param2MethodDescription1, TypeDescription param2TypeDescription2, MethodDescription param2MethodDescription2, MemberSubstitution.Replacement.InvocationType param2InvocationType) {
/* 1997 */         return (MemberSubstitution.Replacement.Binding)((param2InvocationType.matches(this.includeVirtualCalls, this.includeSuperCalls) && this.methodMatcher.matches(param2MethodDescription2)) ? new MemberSubstitution.Replacement.Binding.Resolved(param2TypeDescription2, (ByteCodeElement)param2MethodDescription2, this.substitution) : MemberSubstitution.Replacement.Binding.Unresolved.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.matchFieldRead != ((ForElementMatchers)param2Object).matchFieldRead) ? false : ((this.matchFieldWrite != ((ForElementMatchers)param2Object).matchFieldWrite) ? false : ((this.includeVirtualCalls != ((ForElementMatchers)param2Object).includeVirtualCalls) ? false : ((this.includeSuperCalls != ((ForElementMatchers)param2Object).includeSuperCalls) ? false : (!this.fieldMatcher.equals(((ForElementMatchers)param2Object).fieldMatcher) ? false : (!this.methodMatcher.equals(((ForElementMatchers)param2Object).methodMatcher) ? false : (!!this.substitution.equals(((ForElementMatchers)param2Object).substitution))))))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((((((getClass().hashCode() * 31 + this.fieldMatcher.hashCode()) * 31 + this.methodMatcher.hashCode()) * 31 + this.matchFieldRead) * 31 + this.matchFieldWrite) * 31 + this.includeVirtualCalls) * 31 + this.includeSuperCalls) * 31 + this.substitution.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Factory
/*      */         implements MemberSubstitution.Replacement.Factory
/*      */       {
/*      */         private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final ElementMatcher<? super MethodDescription> methodMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean matchFieldRead;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean matchFieldWrite;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean includeVirtualCalls;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean includeSuperCalls;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MemberSubstitution.Substitution.Factory substitutionFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Factory(ElementMatcher<? super FieldDescription.InDefinedShape> param3ElementMatcher, ElementMatcher<? super MethodDescription> param3ElementMatcher1, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, MemberSubstitution.Substitution.Factory param3Factory) {
/* 2061 */           this.fieldMatcher = param3ElementMatcher;
/* 2062 */           this.methodMatcher = param3ElementMatcher1;
/* 2063 */           this.matchFieldRead = param3Boolean1;
/* 2064 */           this.matchFieldWrite = param3Boolean2;
/* 2065 */           this.includeVirtualCalls = param3Boolean3;
/* 2066 */           this.includeSuperCalls = param3Boolean4;
/* 2067 */           this.substitutionFactory = param3Factory;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static MemberSubstitution.Replacement.Factory of(ElementMatcher<? super ByteCodeElement> param3ElementMatcher, MemberSubstitution.Substitution.Factory param3Factory) {
/* 2078 */           return new Factory((ElementMatcher)param3ElementMatcher, (ElementMatcher)param3ElementMatcher, true, true, true, true, param3Factory);
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
/*      */         
/*      */         protected static MemberSubstitution.Replacement.Factory ofField(ElementMatcher<? super FieldDescription.InDefinedShape> param3ElementMatcher, boolean param3Boolean1, boolean param3Boolean2, MemberSubstitution.Substitution.Factory param3Factory) {
/* 2094 */           return new Factory(param3ElementMatcher, (ElementMatcher<? super MethodDescription>)ElementMatchers.none(), param3Boolean1, param3Boolean2, false, false, param3Factory);
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
/*      */         
/*      */         protected static MemberSubstitution.Replacement.Factory ofMethod(ElementMatcher<? super MethodDescription> param3ElementMatcher, boolean param3Boolean1, boolean param3Boolean2, MemberSubstitution.Substitution.Factory param3Factory) {
/* 2110 */           return new Factory((ElementMatcher<? super FieldDescription.InDefinedShape>)ElementMatchers.none(), param3ElementMatcher, false, false, param3Boolean1, param3Boolean2, param3Factory);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MemberSubstitution.Replacement make(TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, TypePool param3TypePool) {
/* 2117 */           return new MemberSubstitution.Replacement.ForElementMatchers(this.fieldMatcher, this.methodMatcher, this.matchFieldRead, this.matchFieldWrite, this.includeVirtualCalls, this.includeSuperCalls, this.substitutionFactory
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2123 */               .make(param3TypeDescription, param3MethodDescription, param3TypePool));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : ((this.matchFieldRead != ((Factory)param3Object).matchFieldRead) ? false : ((this.matchFieldWrite != ((Factory)param3Object).matchFieldWrite) ? false : ((this.includeVirtualCalls != ((Factory)param3Object).includeVirtualCalls) ? false : ((this.includeSuperCalls != ((Factory)param3Object).includeSuperCalls) ? false : (!this.fieldMatcher.equals(((Factory)param3Object).fieldMatcher) ? false : (!this.methodMatcher.equals(((Factory)param3Object).methodMatcher) ? false : (!!this.substitutionFactory.equals(((Factory)param3Object).substitutionFactory))))))))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((((((getClass().hashCode() * 31 + this.fieldMatcher.hashCode()) * 31 + this.methodMatcher.hashCode()) * 31 + this.matchFieldRead) * 31 + this.matchFieldWrite) * 31 + this.includeVirtualCalls) * 31 + this.includeSuperCalls) * 31 + this.substitutionFactory.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class ForFirstBinding
/*      */       implements Replacement
/*      */     {
/*      */       private final List<? extends MemberSubstitution.Replacement> replacements;
/*      */       
/*      */       protected ForFirstBinding(List<? extends MemberSubstitution.Replacement> param2List) {
/* 2145 */         this.replacements = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.Replacement.Binding bind(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, FieldDescription.InDefinedShape param2InDefinedShape, boolean param2Boolean) {
/* 2155 */         for (Iterator<? extends MemberSubstitution.Replacement> iterator = this.replacements.iterator(); iterator.hasNext();) {
/*      */           
/* 2157 */           if ((binding = (replacement = iterator.next()).bind(param2TypeDescription, param2MethodDescription, param2InDefinedShape, param2Boolean)).isBound()) {
/* 2158 */             return binding;
/*      */           }
/*      */         } 
/* 2161 */         return MemberSubstitution.Replacement.Binding.Unresolved.INSTANCE;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MemberSubstitution.Replacement.Binding bind(TypeDescription param2TypeDescription1, MethodDescription param2MethodDescription1, TypeDescription param2TypeDescription2, MethodDescription param2MethodDescription2, MemberSubstitution.Replacement.InvocationType param2InvocationType) {
/* 2172 */         for (Iterator<? extends MemberSubstitution.Replacement> iterator = this.replacements.iterator(); iterator.hasNext();) {
/*      */           
/* 2174 */           if ((binding = (replacement = iterator.next()).bind(param2TypeDescription1, param2MethodDescription1, param2TypeDescription2, param2MethodDescription2, param2InvocationType)).isBound()) {
/* 2175 */             return binding;
/*      */           }
/*      */         } 
/* 2178 */         return MemberSubstitution.Replacement.Binding.Unresolved.INSTANCE;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.replacements.equals(((ForFirstBinding)param2Object).replacements))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.replacements.hashCode();
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class SubstitutingMethodVisitor
/*      */     extends LocalVariableAwareMethodVisitor
/*      */   {
/*      */     private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDescription instrumentedMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean strict;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MemberSubstitution.Replacement replacement;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Implementation.Context implementationContext;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypePool typePool;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean virtualPrivateCalls;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int stackSizeBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int localVariableExtension;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected SubstitutingMethodVisitor(MethodVisitor param1MethodVisitor, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, MethodGraph.Compiler param1Compiler, boolean param1Boolean1, MemberSubstitution.Replacement param1Replacement, Implementation.Context param1Context, TypePool param1TypePool, boolean param1Boolean2) {
/* 2260 */       super(param1MethodVisitor, param1MethodDescription);
/* 2261 */       this.instrumentedType = param1TypeDescription;
/* 2262 */       this.instrumentedMethod = param1MethodDescription;
/* 2263 */       this.methodGraphCompiler = param1Compiler;
/* 2264 */       this.strict = param1Boolean1;
/* 2265 */       this.replacement = param1Replacement;
/* 2266 */       this.implementationContext = param1Context;
/* 2267 */       this.typePool = param1TypePool;
/* 2268 */       this.virtualPrivateCalls = param1Boolean2;
/* 2269 */       this.stackSizeBuffer = 0;
/* 2270 */       this.localVariableExtension = 0;
/*      */     }
/*      */     public void visitFieldInsn(int param1Int, String param1String1, String param1String2, String param1String3) {
/*      */       TypeList.Generic.Empty empty;
/*      */       TypeDescription.Generic generic;
/*      */       TypePool.Resolution resolution;
/* 2276 */       if ((resolution = this.typePool.describe(param1String1.replace('/', '.'))).isResolved()) {
/*      */         FieldList fieldList;
/*      */ 
/*      */         
/* 2280 */         if (!(fieldList = (FieldList)resolution.resolve().getDeclaredFields().filter(this.strict ? (ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3)) : (ElementMatcher)ElementMatchers.failSafe((ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3))))).isEmpty()) {
/*      */           MemberSubstitution.Replacement.Binding binding;
/*      */ 
/*      */ 
/*      */           
/* 2285 */           if ((binding = this.replacement.bind(this.instrumentedType, this.instrumentedMethod, (FieldDescription.InDefinedShape)fieldList.getOnly(), (param1Int == 181 || param1Int == 179))).isBound()) {
/*      */             TypeList.Generic.Explicit explicit;
/*      */             
/* 2288 */             switch (param1Int) {
/*      */               case 181:
/* 2290 */                 explicit = new TypeList.Generic.Explicit(new TypeDefinition[] { (TypeDefinition)((FieldDescription.InDefinedShape)fieldList.getOnly()).getDeclaringType(), (TypeDefinition)((FieldDescription.InDefinedShape)fieldList.getOnly()).getType() });
/* 2291 */                 generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class);
/*      */                 break;
/*      */               case 179:
/* 2294 */                 explicit = new TypeList.Generic.Explicit(new TypeDefinition[] { (TypeDefinition)((FieldDescription.InDefinedShape)fieldList.getOnly()).getType() });
/* 2295 */                 generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class);
/*      */                 break;
/*      */               case 180:
/* 2298 */                 explicit = new TypeList.Generic.Explicit(new TypeDefinition[] { (TypeDefinition)((FieldDescription.InDefinedShape)fieldList.getOnly()).getDeclaringType() });
/* 2299 */                 generic = ((FieldDescription.InDefinedShape)fieldList.getOnly()).getType();
/*      */                 break;
/*      */               case 178:
/* 2302 */                 empty = new TypeList.Generic.Empty();
/* 2303 */                 generic = ((FieldDescription.InDefinedShape)fieldList.getOnly()).getType();
/*      */                 break;
/*      */               default:
/* 2306 */                 throw new IllegalStateException("Unexpected opcode: " + empty);
/*      */             } 
/* 2308 */             this.stackSizeBuffer = Math.max(this.stackSizeBuffer, binding.make((TypeList.Generic)empty, generic, getFreeOffset())
/* 2309 */                 .apply(new LocalVariableTracingMethodVisitor(this.mv, (byte)0), this.implementationContext)
/* 2310 */                 .getMaximalSize() - generic.getStackSize().getSize());
/*      */             return;
/*      */           } 
/* 2313 */         } else if (this.strict) {
/* 2314 */           throw new IllegalStateException("Could not resolve " + generic.replace('/', '.') + "." + param1String2 + param1String3 + " using " + this.typePool);
/*      */         }
/*      */       
/* 2317 */       } else if (this.strict) {
/* 2318 */         throw new IllegalStateException("Could not resolve " + generic.replace('/', '.') + " using " + this.typePool);
/*      */       } 
/* 2320 */       super.visitFieldInsn(empty, (String)generic, param1String2, param1String3);
/*      */     }
/*      */ 
/*      */     
/*      */     public void visitMethodInsn(int param1Int, String param1String1, String param1String2, String param1String3, boolean param1Boolean) {
/*      */       TypePool.Resolution resolution;
/* 2326 */       if ((resolution = this.typePool.describe(param1String1.replace('/', '.'))).isResolved()) {
/*      */         MethodList methodList;
/* 2328 */         if (param1Int == 183 && param1String2.equals("<init>")) {
/* 2329 */           methodList = (MethodList)resolution.resolve().getDeclaredMethods().filter(this.strict ? 
/* 2330 */               (ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3)) : 
/* 2331 */               (ElementMatcher)ElementMatchers.failSafe((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3))));
/* 2332 */         } else if (param1Int == 184 || param1Int == 183) {
/* 2333 */           methodList = (MethodList)resolution.resolve().getDeclaredMethods().filter(this.strict ? 
/* 2334 */               (ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3)) : 
/* 2335 */               (ElementMatcher)ElementMatchers.failSafe((ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3))));
/* 2336 */         } else if (this.virtualPrivateCalls) {
/*      */ 
/*      */ 
/*      */           
/* 2340 */           if ((methodList = (MethodList)resolution.resolve().getDeclaredMethods().filter(this.strict ? (ElementMatcher)ElementMatchers.isPrivate().and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isStatic())).and((ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3))) : (ElementMatcher)ElementMatchers.failSafe((ElementMatcher)ElementMatchers.isPrivate().and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isStatic())).and((ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3)))))).isEmpty()) {
/* 2341 */             methodList = (MethodList)this.methodGraphCompiler.compile((TypeDefinition)resolution.resolve(), this.instrumentedType).listNodes().asMethodList().filter(this.strict ? 
/* 2342 */                 (ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3)) : 
/* 2343 */                 (ElementMatcher)ElementMatchers.failSafe((ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3))));
/*      */           }
/*      */         } else {
/* 2346 */           methodList = (MethodList)this.methodGraphCompiler.compile((TypeDefinition)resolution.resolve(), this.instrumentedType).listNodes().asMethodList().filter(this.strict ? 
/* 2347 */               (ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3)) : 
/* 2348 */               (ElementMatcher)ElementMatchers.failSafe((ElementMatcher)ElementMatchers.named(param1String2).and((ElementMatcher)ElementMatchers.hasDescriptor(param1String3))));
/*      */         } 
/* 2350 */         if (!methodList.isEmpty()) {
/*      */           MemberSubstitution.Replacement.Binding binding;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2356 */           if ((binding = this.replacement.bind(this.instrumentedType, this.instrumentedMethod, resolution.resolve(), (MethodDescription)methodList.getOnly(), MemberSubstitution.Replacement.InvocationType.of(param1Int, (MethodDescription)methodList.getOnly()))).isBound()) {
/* 2357 */             this.stackSizeBuffer = Math.max(this.stackSizeBuffer, binding.make((((MethodDescription)methodList
/* 2358 */                   .getOnly()).isStatic() || ((MethodDescription)methodList.getOnly()).isConstructor()) ? ((MethodDescription)methodList
/* 2359 */                   .getOnly()).getParameters().asTypeList() : (TypeList.Generic)new TypeList.Generic.Explicit(
/* 2360 */                     CompoundList.of(resolution.resolve(), (List)((MethodDescription)methodList.getOnly()).getParameters().asTypeList())), 
/* 2361 */                   ((MethodDescription)methodList.getOnly()).isConstructor() ? ((MethodDescription)methodList
/* 2362 */                   .getOnly()).getDeclaringType().asGenericType() : ((MethodDescription)methodList
/* 2363 */                   .getOnly()).getReturnType(), 
/* 2364 */                   getFreeOffset())
/* 2365 */                 .apply(new LocalVariableTracingMethodVisitor(this.mv, (byte)0), this.implementationContext).getMaximalSize() - (((MethodDescription)methodList.getOnly()).isConstructor() ? StackSize.SINGLE : ((MethodDescription)methodList
/*      */                 
/* 2367 */                 .getOnly()).getReturnType().getStackSize()).getSize());
/* 2368 */             if (((MethodDescription)methodList.getOnly()).isConstructor()) {
/* 2369 */               this.stackSizeBuffer = Math.max(this.stackSizeBuffer, (new StackManipulation.Compound(new StackManipulation[] { Duplication.SINGLE
/* 2370 */                       .flipOver((TypeDefinition)TypeDescription.ForLoadedType.of(Object.class)), (StackManipulation)Removal.SINGLE, (StackManipulation)Removal.SINGLE, Duplication.SINGLE
/*      */ 
/*      */                       
/* 2373 */                       .flipOver((TypeDefinition)TypeDescription.ForLoadedType.of(Object.class)), (StackManipulation)Removal.SINGLE, (StackManipulation)Removal.SINGLE
/*      */ 
/*      */                     
/* 2376 */                     })).apply(this.mv, this.implementationContext).getMaximalSize() + StackSize.SINGLE.getSize());
/*      */             }
/*      */             return;
/*      */           } 
/* 2380 */         } else if (this.strict) {
/* 2381 */           throw new IllegalStateException("Could not resolve " + param1String1.replace('/', '.') + "." + param1String2 + param1String3 + " using " + this.typePool);
/*      */         }
/*      */       
/* 2384 */       } else if (this.strict) {
/* 2385 */         throw new IllegalStateException("Could not resolve " + param1String1.replace('/', '.') + " using " + this.typePool);
/*      */       } 
/* 2387 */       super.visitMethodInsn(param1Int, param1String1, param1String2, param1String3, param1Boolean);
/*      */     }
/*      */ 
/*      */     
/*      */     public void visitMaxs(int param1Int1, int param1Int2) {
/* 2392 */       super.visitMaxs(param1Int1 + this.stackSizeBuffer, Math.max(this.localVariableExtension, param1Int2));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private class LocalVariableTracingMethodVisitor
/*      */       extends MethodVisitor
/*      */     {
/*      */       private LocalVariableTracingMethodVisitor(MemberSubstitution.SubstitutingMethodVisitor this$0, MethodVisitor param2MethodVisitor) {
/* 2406 */         super(OpenedClassReader.ASM_API, param2MethodVisitor);
/*      */       }
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"SF_SWITCH_NO_DEFAULT"}, justification = "No action required on default option.")
/*      */       public void visitVarInsn(int param2Int1, int param2Int2) {
/* 2412 */         switch (param2Int1) {
/*      */           case 54:
/*      */           case 56:
/*      */           case 58:
/* 2416 */             MemberSubstitution.SubstitutingMethodVisitor.a(this.a, Math.max(MemberSubstitution.SubstitutingMethodVisitor.a(this.a), param2Int2 + 1));
/*      */             break;
/*      */           case 55:
/*      */           case 57:
/* 2420 */             MemberSubstitution.SubstitutingMethodVisitor.a(this.a, Math.max(MemberSubstitution.SubstitutingMethodVisitor.a(this.a), param2Int2 + 2));
/*      */             break;
/*      */         } 
/* 2423 */         super.visitVarInsn(param2Int1, param2Int2);
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\MemberSubstitution.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */