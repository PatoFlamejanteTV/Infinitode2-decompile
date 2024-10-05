/*     */ package net.bytebuddy.description;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.description.annotation.AnnotationSource;
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
/*     */ public interface ByteCodeElement
/*     */   extends DeclaredByType, ModifierReviewable, NamedElement.WithDescriptor, NamedElement.WithRuntimeName, AnnotationSource
/*     */ {
/*     */   boolean isVisibleTo(TypeDescription paramTypeDescription);
/*     */   
/*     */   boolean isAccessibleTo(TypeDescription paramTypeDescription);
/*     */   
/*     */   public static interface Token<T extends Token<T>>
/*     */   {
/*     */     T accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor);
/*     */     
/*     */     public static class TokenList<S extends Token<S>>
/*     */       extends FilterableList.AbstractBase<S, TokenList<S>>
/*     */     {
/*     */       private final List<? extends S> tokens;
/*     */       
/*     */       public TokenList(S... param2VarArgs) {
/* 139 */         this(Arrays.asList(param2VarArgs));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TokenList(List<? extends S> param2List) {
/* 148 */         this.tokens = param2List;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TokenList<S> accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param2Visitor) {
/* 158 */         ArrayList<? extends S> arrayList = new ArrayList(this.tokens.size());
/* 159 */         for (ByteCodeElement.Token token : this.tokens) {
/* 160 */           arrayList.add(token.accept(param2Visitor));
/*     */         }
/* 162 */         return new TokenList(arrayList);
/*     */       }
/*     */ 
/*     */       
/*     */       protected TokenList<S> wrap(List<S> param2List) {
/* 167 */         return new TokenList(param2List);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public S get(int param2Int) {
/* 174 */         return this.tokens.get(param2Int);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int size() {
/* 181 */         return this.tokens.size();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface TypeDependant<T extends TypeDependant<?, S>, S extends Token<S>> {
/*     */     T asDefined();
/*     */     
/*     */     S asToken(ElementMatcher<? super TypeDescription> param1ElementMatcher);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\ByteCodeElement.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */