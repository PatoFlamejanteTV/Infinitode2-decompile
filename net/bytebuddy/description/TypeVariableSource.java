/*     */ package net.bytebuddy.description;
/*     */ 
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
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
/*     */ public interface TypeVariableSource
/*     */   extends ModifierReviewable.OfAbstraction
/*     */ {
/*     */   @AlwaysNull
/*  35 */   public static final TypeVariableSource UNDEFINED = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TypeList.Generic getTypeVariables();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   TypeVariableSource getEnclosingSource();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isInferrable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   TypeDescription.Generic findVariable(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TypeDescription.Generic findExpectedVariable(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   <T> T accept(Visitor<T> paramVisitor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isGenerified();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Visitor<T>
/*     */   {
/*     */     T onType(TypeDescription param1TypeDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     T onMethod(MethodDescription.InDefinedShape param1InDefinedShape);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum NoOp
/*     */       implements Visitor<TypeVariableSource>
/*     */     {
/* 129 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final TypeVariableSource onType(TypeDescription param2TypeDescription) {
/* 135 */         return (TypeVariableSource)param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final TypeVariableSource onMethod(MethodDescription.InDefinedShape param2InDefinedShape) {
/* 142 */         return (TypeVariableSource)param2InDefinedShape;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     extends ModifierReviewable.AbstractBase
/*     */     implements TypeVariableSource
/*     */   {
/*     */     @MaybeNull
/*     */     public TypeDescription.Generic findVariable(String param1String) {
/*     */       TypeVariableSource typeVariableSource;
/*     */       TypeList.Generic generic;
/* 158 */       if ((generic = (TypeList.Generic)getTypeVariables().filter((ElementMatcher)ElementMatchers.named(param1String))).isEmpty())
/*     */       {
/* 160 */         return ((typeVariableSource = getEnclosingSource()) == null) ? TypeDescription.Generic.UNDEFINED : typeVariableSource
/*     */           
/* 162 */           .findVariable(param1String);
/*     */       }
/* 164 */       return (TypeDescription.Generic)typeVariableSource.getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic findExpectedVariable(String param1String) {
/*     */       TypeDescription.Generic generic;
/* 173 */       if ((generic = findVariable(param1String)) == null) {
/* 174 */         throw new IllegalArgumentException("Cannot resolve " + param1String + " from " + toSafeString());
/*     */       }
/* 176 */       return generic;
/*     */     }
/*     */     
/*     */     protected abstract String toSafeString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\TypeVariableSource.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */