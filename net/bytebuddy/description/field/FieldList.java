/*     */ package net.bytebuddy.description.field;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.description.type.TypeDescription;
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
/*     */ public interface FieldList<T extends FieldDescription>
/*     */   extends FilterableList<T, FieldList<T>>
/*     */ {
/*     */   ByteCodeElement.Token.TokenList<FieldDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> paramElementMatcher);
/*     */   
/*     */   FieldList<FieldDescription.InDefinedShape> asDefined();
/*     */   
/*     */   public static abstract class AbstractBase<S extends FieldDescription>
/*     */     extends FilterableList.AbstractBase<S, FieldList<S>>
/*     */     implements FieldList<S>
/*     */   {
/*     */     public ByteCodeElement.Token.TokenList<FieldDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/*  62 */       ArrayList<ByteCodeElement.Token> arrayList = new ArrayList(size());
/*  63 */       for (FieldDescription fieldDescription : this) {
/*  64 */         arrayList.add(fieldDescription.asToken(param1ElementMatcher));
/*     */       }
/*  66 */       return new ByteCodeElement.Token.TokenList(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldList<FieldDescription.InDefinedShape> asDefined() {
/*  73 */       ArrayList<ByteCodeElement.TypeDependant> arrayList = new ArrayList(size());
/*  74 */       for (FieldDescription fieldDescription : this) {
/*  75 */         arrayList.add(fieldDescription.asDefined());
/*     */       }
/*  77 */       return (FieldList)new FieldList.Explicit<ByteCodeElement.TypeDependant>(arrayList);
/*     */     }
/*     */ 
/*     */     
/*     */     protected FieldList<S> wrap(List<S> param1List) {
/*  82 */       return new FieldList.Explicit<S>(param1List);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedFields
/*     */     extends AbstractBase<FieldDescription.InDefinedShape>
/*     */   {
/*     */     private final List<? extends Field> fields;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedFields(Field... param1VarArgs) {
/* 102 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedFields(List<? extends Field> param1List) {
/* 111 */       this.fields = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDescription.InDefinedShape get(int param1Int) {
/* 118 */       return new FieldDescription.ForLoadedField(this.fields.get(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 125 */       return this.fields.size();
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
/*     */   public static class Explicit<S extends FieldDescription>
/*     */     extends AbstractBase<S>
/*     */   {
/*     */     private final List<? extends S> fieldDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(S... param1VarArgs) {
/* 148 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(List<? extends S> param1List) {
/* 157 */       this.fieldDescriptions = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S get(int param1Int) {
/* 164 */       return this.fieldDescriptions.get(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 171 */       return this.fieldDescriptions.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForTokens
/*     */     extends AbstractBase<FieldDescription.InDefinedShape>
/*     */   {
/*     */     private final TypeDescription declaringType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends FieldDescription.Token> tokens;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForTokens(TypeDescription param1TypeDescription, FieldDescription.Token... param1VarArgs) {
/* 197 */       this(param1TypeDescription, Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForTokens(TypeDescription param1TypeDescription, List<? extends FieldDescription.Token> param1List) {
/* 207 */       this.declaringType = param1TypeDescription;
/* 208 */       this.tokens = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDescription.InDefinedShape get(int param1Int) {
/* 215 */       return new FieldDescription.Latent(this.declaringType, this.tokens.get(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 222 */       return this.tokens.size();
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
/*     */     extends AbstractBase<FieldDescription.InGenericShape>
/*     */   {
/*     */     private final TypeDescription.Generic declaringType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends FieldDescription> fieldDescriptions;
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
/*     */     public TypeSubstituting(TypeDescription.Generic param1Generic, List<? extends FieldDescription> param1List, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 256 */       this.declaringType = param1Generic;
/* 257 */       this.fieldDescriptions = param1List;
/* 258 */       this.visitor = param1Visitor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDescription.InGenericShape get(int param1Int) {
/* 265 */       return new FieldDescription.TypeSubstituting(this.declaringType, this.fieldDescriptions.get(param1Int), this.visitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 272 */       return this.fieldDescriptions.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Empty<S extends FieldDescription>
/*     */     extends FilterableList.Empty<S, FieldList<S>>
/*     */     implements FieldList<S>
/*     */   {
/*     */     public ByteCodeElement.Token.TokenList<FieldDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 287 */       return new ByteCodeElement.Token.TokenList((ByteCodeElement.Token[])new FieldDescription.Token[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldList<FieldDescription.InDefinedShape> asDefined() {
/* 295 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\field\FieldList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */