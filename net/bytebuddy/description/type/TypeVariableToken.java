/*     */ package net.bytebuddy.description.type;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
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
/*     */ 
/*     */ 
/*     */ public class TypeVariableToken
/*     */   implements ByteCodeElement.Token<TypeVariableToken>
/*     */ {
/*     */   private final String symbol;
/*     */   private final List<? extends TypeDescription.Generic> bounds;
/*     */   private final List<? extends AnnotationDescription> annotations;
/*     */   
/*     */   public TypeVariableToken(String paramString, List<? extends TypeDescription.Generic> paramList) {
/*  55 */     this(paramString, paramList, Collections.emptyList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeVariableToken(String paramString, List<? extends TypeDescription.Generic> paramList, List<? extends AnnotationDescription> paramList1) {
/*  66 */     this.symbol = paramString;
/*  67 */     this.bounds = paramList;
/*  68 */     this.annotations = paramList1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeVariableToken of(TypeDescription.Generic paramGeneric, ElementMatcher<? super TypeDescription> paramElementMatcher) {
/*  79 */     return new TypeVariableToken(paramGeneric.getSymbol(), (List<? extends TypeDescription.Generic>)paramGeneric
/*  80 */         .getUpperBounds().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(paramElementMatcher)), (List<? extends AnnotationDescription>)paramGeneric
/*  81 */         .getDeclaredAnnotations());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSymbol() {
/*  90 */     return this.symbol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeList.Generic getBounds() {
/*  99 */     return new TypeList.Generic.Explicit((List)this.bounds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationList getAnnotations() {
/* 108 */     return (AnnotationList)new AnnotationList.Explicit(this.annotations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeVariableToken accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> paramVisitor) {
/* 115 */     return new TypeVariableToken(this.symbol, (List<? extends TypeDescription.Generic>)getBounds().accept(paramVisitor), this.annotations);
/*     */   }
/*     */   
/*     */   @Enhance("hashCode")
/*     */   public int hashCode() {
/*     */     TypeVariableToken typeVariableToken;
/* 121 */     int k = (typeVariableToken = this).symbol.hashCode();
/* 122 */     k = k * 31 + typeVariableToken.bounds.hashCode();
/*     */     int i, j;
/* 124 */     if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + typeVariableToken.annotations.hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/* 129 */     if (this == paramObject)
/* 130 */       return true; 
/* 131 */     if (!(paramObject instanceof TypeVariableToken)) {
/* 132 */       return false;
/*     */     }
/* 134 */     paramObject = paramObject;
/* 135 */     if (this.symbol.equals(((TypeVariableToken)paramObject).symbol) && this.bounds
/* 136 */       .equals(((TypeVariableToken)paramObject).bounds) && this.annotations
/* 137 */       .equals(((TypeVariableToken)paramObject).annotations)) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 142 */     return this.symbol;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\type\TypeVariableToken.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */