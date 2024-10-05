/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.RecordComponentDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*     */ public interface LatentMatcher<T>
/*     */ {
/*     */   ElementMatcher<? super T> resolve(TypeDescription paramTypeDescription);
/*     */   
/*     */   public enum ForSelfDeclaredMethod
/*     */     implements LatentMatcher<MethodDescription>
/*     */   {
/*  52 */     DECLARED(false),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     NOT_DECLARED(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean inverted;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ForSelfDeclaredMethod(boolean param1Boolean) {
/*  70 */       this.inverted = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ElementMatcher<? super MethodDescription> resolve(TypeDescription param1TypeDescription) {
/*  79 */       if (this.inverted)
/*  80 */         return ElementMatchers.not(ElementMatchers.isDeclaredBy(param1TypeDescription)); 
/*  81 */       return ElementMatchers.isDeclaredBy(param1TypeDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Resolved<S>
/*     */     implements LatentMatcher<S>
/*     */   {
/*     */     private final ElementMatcher<? super S> matcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Resolved(ElementMatcher<? super S> param1ElementMatcher) {
/* 104 */       this.matcher = param1ElementMatcher;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementMatcher<? super S> resolve(TypeDescription param1TypeDescription) {
/* 111 */       return this.matcher;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.matcher.equals(((Resolved)param1Object).matcher))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.matcher.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class ForFieldToken
/*     */     implements LatentMatcher<FieldDescription>
/*     */   {
/*     */     private final FieldDescription.Token token;
/*     */     
/*     */     public ForFieldToken(FieldDescription.Token param1Token) {
/* 132 */       this.token = param1Token;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementMatcher<? super FieldDescription> resolve(TypeDescription param1TypeDescription) {
/* 139 */       return new ResolvedMatcher(this.token.asSignatureToken(param1TypeDescription));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.token.equals(((ForFieldToken)param1Object).token))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.token.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     protected static class ResolvedMatcher
/*     */       extends ElementMatcher.Junction.ForNonNullValues<FieldDescription>
/*     */     {
/*     */       private final FieldDescription.SignatureToken signatureToken;
/*     */       
/*     */       protected ResolvedMatcher(FieldDescription.SignatureToken param2SignatureToken) {
/* 159 */         this.signatureToken = param2SignatureToken;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected boolean doMatch(FieldDescription param2FieldDescription) {
/* 166 */         return param2FieldDescription.asSignatureToken().equals(this.signatureToken);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.signatureToken.equals(((ResolvedMatcher)param2Object).signatureToken)))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return super.hashCode() * 31 + this.signatureToken.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class ForMethodToken
/*     */     implements LatentMatcher<MethodDescription>
/*     */   {
/*     */     private final MethodDescription.Token token;
/*     */     
/*     */     public ForMethodToken(MethodDescription.Token param1Token) {
/* 188 */       this.token = param1Token;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementMatcher<? super MethodDescription> resolve(TypeDescription param1TypeDescription) {
/* 195 */       return new ResolvedMatcher(this.token.asSignatureToken(param1TypeDescription));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.token.equals(((ForMethodToken)param1Object).token))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.token.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     protected static class ResolvedMatcher
/*     */       extends ElementMatcher.Junction.ForNonNullValues<MethodDescription>
/*     */     {
/*     */       private final MethodDescription.SignatureToken signatureToken;
/*     */       
/*     */       protected ResolvedMatcher(MethodDescription.SignatureToken param2SignatureToken) {
/* 215 */         this.signatureToken = param2SignatureToken;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean doMatch(MethodDescription param2MethodDescription) {
/* 222 */         return param2MethodDescription.asSignatureToken().equals(this.signatureToken);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.signatureToken.equals(((ResolvedMatcher)param2Object).signatureToken)))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return super.hashCode() * 31 + this.signatureToken.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class ForRecordComponentToken
/*     */     implements LatentMatcher<RecordComponentDescription>
/*     */   {
/*     */     private final RecordComponentDescription.Token token;
/*     */     
/*     */     public ForRecordComponentToken(RecordComponentDescription.Token param1Token) {
/* 244 */       this.token = param1Token;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementMatcher<? super RecordComponentDescription> resolve(TypeDescription param1TypeDescription) {
/* 251 */       return ElementMatchers.named(this.token.getName());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.token.equals(((ForRecordComponentToken)param1Object).token))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.token.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Conjunction<S>
/*     */     implements LatentMatcher<S>
/*     */   {
/*     */     private final List<? extends LatentMatcher<? super S>> matchers;
/*     */ 
/*     */     
/*     */     public Conjunction(LatentMatcher<? super S>... param1VarArgs) {
/* 275 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Conjunction(List<? extends LatentMatcher<? super S>> param1List) {
/* 284 */       this.matchers = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementMatcher<? super S> resolve(TypeDescription param1TypeDescription) {
/* 291 */       ElementMatcher.Junction<?> junction = ElementMatchers.any();
/* 292 */       for (LatentMatcher<?> latentMatcher : this.matchers) {
/* 293 */         junction = junction.and(latentMatcher.resolve(param1TypeDescription));
/*     */       }
/* 295 */       return (ElementMatcher)junction;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.matchers.equals(((Conjunction)param1Object).matchers))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.matchers.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Disjunction<S>
/*     */     implements LatentMatcher<S>
/*     */   {
/*     */     private final List<? extends LatentMatcher<? super S>> matchers;
/*     */ 
/*     */     
/*     */     public Disjunction(LatentMatcher<? super S>... param1VarArgs) {
/* 319 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Disjunction(List<? extends LatentMatcher<? super S>> param1List) {
/* 328 */       this.matchers = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementMatcher<? super S> resolve(TypeDescription param1TypeDescription) {
/* 335 */       ElementMatcher.Junction<?> junction = ElementMatchers.none();
/* 336 */       for (LatentMatcher<?> latentMatcher : this.matchers) {
/* 337 */         junction = junction.or(latentMatcher.resolve(param1TypeDescription));
/*     */       }
/* 339 */       return (ElementMatcher)junction;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.matchers.equals(((Disjunction)param1Object).matchers))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.matchers.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\LatentMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */