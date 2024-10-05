/*     */ package net.bytebuddy.description.method;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.FilterableList;
/*     */ import net.bytebuddy.utility.ConstructorComparator;
/*     */ import net.bytebuddy.utility.GraalImageCode;
/*     */ import net.bytebuddy.utility.MethodComparator;
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
/*     */ 
/*     */ public interface MethodList<T extends MethodDescription>
/*     */   extends FilterableList<T, MethodList<T>>
/*     */ {
/*     */   ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> paramElementMatcher);
/*     */   
/*     */   List<MethodDescription.SignatureToken> asSignatureTokenList();
/*     */   
/*     */   List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> paramElementMatcher, TypeDescription paramTypeDescription);
/*     */   
/*     */   MethodList<MethodDescription.InDefinedShape> asDefined();
/*     */   
/*     */   public static abstract class AbstractBase<S extends MethodDescription>
/*     */     extends FilterableList.AbstractBase<S, MethodList<S>>
/*     */     implements MethodList<S>
/*     */   {
/*     */     protected MethodList<S> wrap(List<S> param1List) {
/*  81 */       return new MethodList.Explicit<S>(param1List);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/*  88 */       ArrayList<ByteCodeElement.Token> arrayList = new ArrayList(size());
/*  89 */       for (MethodDescription methodDescription : this) {
/*  90 */         arrayList.add(methodDescription.asToken(param1ElementMatcher));
/*     */       }
/*  92 */       return new ByteCodeElement.Token.TokenList(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<MethodDescription.SignatureToken> asSignatureTokenList() {
/*  99 */       ArrayList<MethodDescription.SignatureToken> arrayList = new ArrayList(size());
/* 100 */       for (MethodDescription methodDescription : this) {
/* 101 */         arrayList.add(methodDescription.asSignatureToken());
/*     */       }
/* 103 */       return arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher, TypeDescription param1TypeDescription) {
/* 110 */       ArrayList<MethodDescription.SignatureToken> arrayList = new ArrayList(size());
/* 111 */       for (MethodDescription methodDescription : this) {
/* 112 */         arrayList.add(((MethodDescription.Token)methodDescription.asToken(param1ElementMatcher)).asSignatureToken(param1TypeDescription));
/*     */       }
/* 114 */       return arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodList<MethodDescription.InDefinedShape> asDefined() {
/* 121 */       ArrayList<ByteCodeElement.TypeDependant> arrayList = new ArrayList(size());
/* 122 */       for (MethodDescription methodDescription : this) {
/* 123 */         arrayList.add(methodDescription.asDefined());
/*     */       }
/* 125 */       return (MethodList)new MethodList.Explicit<ByteCodeElement.TypeDependant>(arrayList);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedMethods
/*     */     extends AbstractBase<MethodDescription.InDefinedShape>
/*     */   {
/*     */     private final List<? extends Method> methods;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends Constructor<?>> constructors;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedMethods(Class<?> param1Class) {
/* 151 */       this((Constructor<?>[])GraalImageCode.getCurrent().sorted((Object[])param1Class.getDeclaredConstructors(), (Comparator)ConstructorComparator.INSTANCE), 
/* 152 */           (Method[])GraalImageCode.getCurrent().sorted((Object[])param1Class.getDeclaredMethods(), (Comparator)MethodComparator.INSTANCE));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedMethods(Constructor<?>[] param1ArrayOfConstructor, Method[] param1ArrayOfMethod) {
/* 163 */       this(Arrays.asList(param1ArrayOfConstructor), Arrays.asList(param1ArrayOfMethod));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedMethods(List<? extends Constructor<?>> param1List, List<? extends Method> param1List1) {
/* 174 */       this.constructors = param1List;
/* 175 */       this.methods = param1List1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDescription.InDefinedShape get(int param1Int) {
/* 182 */       return (MethodDescription.InDefinedShape)((param1Int < this.constructors.size()) ? new MethodDescription.ForLoadedConstructor(this.constructors
/* 183 */           .get(param1Int)) : new MethodDescription.ForLoadedMethod(this.methods
/* 184 */           .get(param1Int - this.constructors.size())));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 192 */       return this.constructors.size() + this.methods.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Explicit<S extends MethodDescription>
/*     */     extends AbstractBase<S>
/*     */   {
/*     */     private final List<? extends S> methodDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(S... param1VarArgs) {
/* 215 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(List<? extends S> param1List) {
/* 224 */       this.methodDescriptions = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S get(int param1Int) {
/* 231 */       return this.methodDescriptions.get(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 238 */       return this.methodDescriptions.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForTokens
/*     */     extends AbstractBase<MethodDescription.InDefinedShape>
/*     */   {
/*     */     private final TypeDescription declaringType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends MethodDescription.Token> tokens;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForTokens(TypeDescription param1TypeDescription, MethodDescription.Token... param1VarArgs) {
/* 264 */       this(param1TypeDescription, Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForTokens(TypeDescription param1TypeDescription, List<? extends MethodDescription.Token> param1List) {
/* 274 */       this.declaringType = param1TypeDescription;
/* 275 */       this.tokens = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDescription.InDefinedShape get(int param1Int) {
/* 282 */       return new MethodDescription.Latent(this.declaringType, this.tokens.get(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 289 */       return this.tokens.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class TypeSubstituting
/*     */     extends AbstractBase<MethodDescription.InGenericShape>
/*     */   {
/*     */     protected final TypeDescription.Generic declaringType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final List<? extends MethodDescription> methodDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeSubstituting(TypeDescription.Generic param1Generic, List<? extends MethodDescription> param1List, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 323 */       this.declaringType = param1Generic;
/* 324 */       this.methodDescriptions = param1List;
/* 325 */       this.visitor = param1Visitor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDescription.InGenericShape get(int param1Int) {
/* 332 */       return new MethodDescription.TypeSubstituting(this.declaringType, this.methodDescriptions.get(param1Int), this.visitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 339 */       return this.methodDescriptions.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Empty<S extends MethodDescription>
/*     */     extends FilterableList.Empty<S, MethodList<S>>
/*     */     implements MethodList<S>
/*     */   {
/*     */     public ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 354 */       return new ByteCodeElement.Token.TokenList((ByteCodeElement.Token[])new MethodDescription.Token[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<MethodDescription.SignatureToken> asSignatureTokenList() {
/* 361 */       return Collections.emptyList();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher, TypeDescription param1TypeDescription) {
/* 368 */       return Collections.emptyList();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodList<MethodDescription.InDefinedShape> asDefined() {
/* 376 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\method\MethodList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */