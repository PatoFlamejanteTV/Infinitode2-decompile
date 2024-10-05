/*     */ package net.bytebuddy.description.type;
/*     */ 
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.FilterableList;
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
/*     */ public interface RecordComponentList<T extends RecordComponentDescription>
/*     */   extends FilterableList<T, RecordComponentList<T>>
/*     */ {
/*     */   ByteCodeElement.Token.TokenList<RecordComponentDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> paramElementMatcher);
/*     */   
/*     */   TypeList.Generic asTypeList();
/*     */   
/*     */   RecordComponentList<RecordComponentDescription.InDefinedShape> asDefined();
/*     */   
/*     */   public static abstract class AbstractBase<S extends RecordComponentDescription>
/*     */     extends FilterableList.AbstractBase<S, RecordComponentList<S>>
/*     */     implements RecordComponentList<S>
/*     */   {
/*     */     public ByteCodeElement.Token.TokenList<RecordComponentDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/*  68 */       ArrayList<RecordComponentDescription.Token> arrayList = new ArrayList(size());
/*  69 */       for (RecordComponentDescription recordComponentDescription : this) {
/*  70 */         arrayList.add(recordComponentDescription.asToken(param1ElementMatcher));
/*     */       }
/*  72 */       return new ByteCodeElement.Token.TokenList(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeList.Generic asTypeList() {
/*  79 */       ArrayList<TypeDescription.Generic> arrayList = new ArrayList(size());
/*  80 */       for (RecordComponentDescription recordComponentDescription : this) {
/*  81 */         arrayList.add(recordComponentDescription.getType());
/*     */       }
/*  83 */       return new TypeList.Generic.Explicit((List)arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RecordComponentList<RecordComponentDescription.InDefinedShape> asDefined() {
/*  90 */       ArrayList<ByteCodeElement.TypeDependant> arrayList = new ArrayList(size());
/*  91 */       for (RecordComponentDescription recordComponentDescription : this) {
/*  92 */         arrayList.add(recordComponentDescription.asDefined());
/*     */       }
/*  94 */       return (RecordComponentList)new RecordComponentList.Explicit<ByteCodeElement.TypeDependant>(arrayList);
/*     */     }
/*     */ 
/*     */     
/*     */     protected RecordComponentList<S> wrap(List<S> param1List) {
/*  99 */       return new RecordComponentList.Explicit<S>(param1List);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedRecordComponents
/*     */     extends AbstractBase<RecordComponentDescription.InDefinedShape>
/*     */   {
/*     */     private final List<?> recordComponents;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForLoadedRecordComponents(Object... param1VarArgs) {
/* 119 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForLoadedRecordComponents(List<?> param1List) {
/* 128 */       this.recordComponents = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RecordComponentDescription.InDefinedShape get(int param1Int) {
/* 135 */       return new RecordComponentDescription.ForLoadedRecordComponent((AnnotatedElement)this.recordComponents.get(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 142 */       return this.recordComponents.size();
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
/*     */   public static class Explicit<S extends RecordComponentDescription>
/*     */     extends AbstractBase<S>
/*     */   {
/*     */     private final List<? extends S> recordComponents;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(S... param1VarArgs) {
/* 165 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(List<? extends S> param1List) {
/* 174 */       this.recordComponents = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S get(int param1Int) {
/* 181 */       return this.recordComponents.get(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 188 */       return this.recordComponents.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForTokens
/*     */     extends AbstractBase<RecordComponentDescription.InDefinedShape>
/*     */   {
/*     */     private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends RecordComponentDescription.Token> tokens;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForTokens(TypeDescription param1TypeDescription, RecordComponentDescription.Token... param1VarArgs) {
/* 214 */       this(param1TypeDescription, Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForTokens(TypeDescription param1TypeDescription, List<? extends RecordComponentDescription.Token> param1List) {
/* 224 */       this.typeDescription = param1TypeDescription;
/* 225 */       this.tokens = param1List;
/*     */     }
/*     */ 
/*     */     
/*     */     public RecordComponentDescription.InDefinedShape get(int param1Int) {
/* 230 */       return new RecordComponentDescription.Latent(this.typeDescription, this.tokens.get(param1Int));
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 235 */       return this.tokens.size();
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
/*     */     extends AbstractBase<RecordComponentDescription.InGenericShape>
/*     */   {
/*     */     private final TypeDescription.Generic declaringType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends RecordComponentDescription> recordComponentDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeSubstituting(TypeDescription.Generic param1Generic, List<? extends RecordComponentDescription> param1List, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 269 */       this.declaringType = param1Generic;
/* 270 */       this.recordComponentDescriptions = param1List;
/* 271 */       this.visitor = param1Visitor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RecordComponentDescription.InGenericShape get(int param1Int) {
/* 278 */       return new RecordComponentDescription.TypeSubstituting(this.declaringType, this.recordComponentDescriptions.get(param1Int), this.visitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 285 */       return this.recordComponentDescriptions.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Empty<S extends RecordComponentDescription>
/*     */     extends FilterableList.Empty<S, RecordComponentList<S>>
/*     */     implements RecordComponentList<S>
/*     */   {
/*     */     public RecordComponentList<RecordComponentDescription.InDefinedShape> asDefined() {
/* 300 */       return new Empty();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeElement.Token.TokenList<RecordComponentDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 307 */       return new ByteCodeElement.Token.TokenList((ByteCodeElement.Token[])new RecordComponentDescription.Token[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeList.Generic asTypeList() {
/* 314 */       return new TypeList.Generic.Empty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\type\RecordComponentList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */