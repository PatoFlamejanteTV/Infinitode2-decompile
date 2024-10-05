/*     */ package net.bytebuddy.dynamic;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.description.TypeVariableSource;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.annotation.AnnotationSource;
/*     */ import net.bytebuddy.description.annotation.AnnotationValue;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.method.ParameterList;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ public interface Transformer<T>
/*     */ {
/*     */   T transform(TypeDescription paramTypeDescription, T paramT);
/*     */   
/*     */   public enum NoOp
/*     */     implements Transformer<Object>
/*     */   {
/*  64 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static <T> Transformer<T> make() {
/*  74 */       return INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object transform(TypeDescription param1TypeDescription, Object param1Object) {
/*  81 */       return param1Object;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForField
/*     */     implements Transformer<FieldDescription>
/*     */   {
/*     */     private final Transformer<FieldDescription.Token> transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForField(Transformer<FieldDescription.Token> param1Transformer) {
/* 102 */       this.transformer = param1Transformer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Transformer<FieldDescription> withModifiers(ModifierContributor.ForField... param1VarArgs) {
/* 112 */       return withModifiers(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Transformer<FieldDescription> withModifiers(List<? extends ModifierContributor.ForField> param1List) {
/* 122 */       return new ForField(new FieldModifierTransformer(ModifierContributor.Resolver.of(param1List)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public FieldDescription transform(TypeDescription param1TypeDescription, FieldDescription param1FieldDescription) {
/* 130 */       return (FieldDescription)new TransformedField(param1TypeDescription, param1FieldDescription
/* 131 */           .getDeclaringType(), (FieldDescription.Token)this.transformer
/* 132 */           .transform(param1TypeDescription, param1FieldDescription.asToken((ElementMatcher)ElementMatchers.none())), (FieldDescription.InDefinedShape)param1FieldDescription
/* 133 */           .asDefined());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.transformer.equals(((ForField)param1Object).transformer))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.transformer.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     protected static class FieldModifierTransformer
/*     */       implements Transformer<FieldDescription.Token>
/*     */     {
/*     */       private final ModifierContributor.Resolver<ModifierContributor.ForField> resolver;
/*     */       
/*     */       protected FieldModifierTransformer(ModifierContributor.Resolver<ModifierContributor.ForField> param2Resolver) {
/* 153 */         this.resolver = param2Resolver;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public FieldDescription.Token transform(TypeDescription param2TypeDescription, FieldDescription.Token param2Token) {
/* 160 */         return new FieldDescription.Token(param2Token.getName(), this.resolver
/* 161 */             .resolve(param2Token.getModifiers()), param2Token
/* 162 */             .getType(), (List)param2Token
/* 163 */             .getAnnotations());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.resolver.equals(((FieldModifierTransformer)param2Object).resolver))));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.resolver.hashCode();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class TransformedField
/*     */       extends FieldDescription.AbstractBase
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */       
/*     */       private final TypeDefinition declaringType;
/*     */ 
/*     */ 
/*     */       
/*     */       private final FieldDescription.Token token;
/*     */ 
/*     */ 
/*     */       
/*     */       private final FieldDescription.InDefinedShape fieldDescription;
/*     */ 
/*     */ 
/*     */       
/*     */       protected TransformedField(TypeDescription param2TypeDescription, TypeDefinition param2TypeDefinition, FieldDescription.Token param2Token, FieldDescription.InDefinedShape param2InDefinedShape) {
/* 204 */         this.instrumentedType = param2TypeDescription;
/* 205 */         this.declaringType = param2TypeDefinition;
/* 206 */         this.token = param2Token;
/* 207 */         this.fieldDescription = param2InDefinedShape;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeDescription.Generic getType() {
/* 214 */         return (TypeDescription.Generic)this.token.getType().accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this.instrumentedType));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public AnnotationList getDeclaredAnnotations() {
/* 221 */         return this.token.getAnnotations();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeDefinition getDeclaringType() {
/* 229 */         return this.declaringType;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int getModifiers() {
/* 236 */         return this.token.getModifiers();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public FieldDescription.InDefinedShape asDefined() {
/* 243 */         return this.fieldDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getName() {
/* 250 */         return this.token.getName();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForMethod
/*     */     implements Transformer<MethodDescription>
/*     */   {
/*     */     private final Transformer<MethodDescription.Token> transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForMethod(Transformer<MethodDescription.Token> param1Transformer) {
/* 272 */       this.transformer = param1Transformer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Transformer<MethodDescription> withModifiers(ModifierContributor.ForMethod... param1VarArgs) {
/* 283 */       return withModifiers(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Transformer<MethodDescription> withModifiers(List<? extends ModifierContributor.ForMethod> param1List) {
/* 294 */       return new ForMethod(new MethodModifierTransformer(ModifierContributor.Resolver.of(param1List)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDescription transform(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription) {
/* 301 */       return (MethodDescription)new TransformedMethod(param1TypeDescription, param1MethodDescription
/* 302 */           .getDeclaringType(), (MethodDescription.Token)this.transformer
/* 303 */           .transform(param1TypeDescription, param1MethodDescription.asToken((ElementMatcher)ElementMatchers.none())), (MethodDescription.InDefinedShape)param1MethodDescription
/* 304 */           .asDefined());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.transformer.equals(((ForMethod)param1Object).transformer))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.transformer.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     protected static class MethodModifierTransformer
/*     */       implements Transformer<MethodDescription.Token>
/*     */     {
/*     */       private final ModifierContributor.Resolver<ModifierContributor.ForMethod> resolver;
/*     */       
/*     */       protected MethodModifierTransformer(ModifierContributor.Resolver<ModifierContributor.ForMethod> param2Resolver) {
/* 324 */         this.resolver = param2Resolver;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodDescription.Token transform(TypeDescription param2TypeDescription, MethodDescription.Token param2Token) {
/* 331 */         return new MethodDescription.Token(param2Token.getName(), this.resolver
/* 332 */             .resolve(param2Token.getModifiers()), (List)param2Token
/* 333 */             .getTypeVariableTokens(), param2Token
/* 334 */             .getReturnType(), (List)param2Token
/* 335 */             .getParameterTokens(), (List)param2Token
/* 336 */             .getExceptionTypes(), (List)param2Token
/* 337 */             .getAnnotations(), param2Token
/* 338 */             .getDefaultValue(), param2Token
/* 339 */             .getReceiverType());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.resolver.equals(((MethodModifierTransformer)param2Object).resolver))));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.resolver.hashCode();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class TransformedMethod
/*     */       extends MethodDescription.AbstractBase
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */       
/*     */       private final TypeDefinition declaringType;
/*     */ 
/*     */ 
/*     */       
/*     */       private final MethodDescription.Token token;
/*     */ 
/*     */ 
/*     */       
/*     */       private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */ 
/*     */       
/*     */       protected TransformedMethod(TypeDescription param2TypeDescription, TypeDefinition param2TypeDefinition, MethodDescription.Token param2Token, MethodDescription.InDefinedShape param2InDefinedShape) {
/* 380 */         this.instrumentedType = param2TypeDescription;
/* 381 */         this.declaringType = param2TypeDefinition;
/* 382 */         this.token = param2Token;
/* 383 */         this.methodDescription = param2InDefinedShape;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeList.Generic getTypeVariables() {
/* 390 */         return (TypeList.Generic)new TypeList.Generic.ForDetachedTypes.OfTypeVariables((TypeVariableSource)this, (List)this.token.getTypeVariableTokens(), (TypeDescription.Generic.Visitor)new AttachmentVisitor(this));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeDescription.Generic getReturnType() {
/* 397 */         return (TypeDescription.Generic)this.token.getReturnType().accept((TypeDescription.Generic.Visitor)new AttachmentVisitor(this));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ParameterList<?> getParameters() {
/* 404 */         return (ParameterList<?>)new TransformedParameterList(this);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeList.Generic getExceptionTypes() {
/* 411 */         return (TypeList.Generic)new TypeList.Generic.ForDetachedTypes((List)this.token.getExceptionTypes(), (TypeDescription.Generic.Visitor)new AttachmentVisitor(this));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public AnnotationList getDeclaredAnnotations() {
/* 418 */         return this.token.getAnnotations();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getInternalName() {
/* 425 */         return this.token.getName();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeDefinition getDeclaringType() {
/* 433 */         return this.declaringType;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int getModifiers() {
/* 440 */         return this.token.getModifiers();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public AnnotationValue<?, ?> getDefaultValue() {
/* 448 */         return this.token.getDefaultValue();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodDescription.InDefinedShape asDefined() {
/* 455 */         return this.methodDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeDescription.Generic getReceiverType() {
/*     */         TypeDescription.Generic generic;
/* 463 */         return ((generic = this.token.getReceiverType()) == null) ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic)generic
/*     */           
/* 465 */           .accept((TypeDescription.Generic.Visitor)new AttachmentVisitor(this));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected class TransformedParameterList
/*     */         extends ParameterList.AbstractBase<ParameterDescription>
/*     */       {
/*     */         protected TransformedParameterList(Transformer.ForMethod.TransformedMethod this$0) {}
/*     */ 
/*     */         
/*     */         public ParameterDescription get(int param3Int) {
/* 477 */           return (ParameterDescription)new Transformer.ForMethod.TransformedMethod.TransformedParameter(this.a, param3Int, (ParameterDescription.Token)Transformer.ForMethod.TransformedMethod.a(this.a).getParameterTokens().get(param3Int));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int size() {
/* 484 */           return Transformer.ForMethod.TransformedMethod.a(this.a).getParameterTokens().size();
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected class TransformedParameter
/*     */         extends ParameterDescription.AbstractBase
/*     */       {
/*     */         private final int index;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final ParameterDescription.Token parameterToken;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected TransformedParameter(Transformer.ForMethod.TransformedMethod this$0, int param3Int, ParameterDescription.Token param3Token) {
/* 510 */           this.index = param3Int;
/* 511 */           this.parameterToken = param3Token;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeDescription.Generic getType() {
/* 518 */           return (TypeDescription.Generic)this.parameterToken.getType().accept((TypeDescription.Generic.Visitor)new Transformer.ForMethod.TransformedMethod.AttachmentVisitor(this.a));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public MethodDescription getDeclaringMethod() {
/* 525 */           return (MethodDescription)this.a;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int getIndex() {
/* 532 */           return this.index;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean isNamed() {
/* 539 */           return (this.parameterToken.getName() != null);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hasModifiers() {
/* 546 */           return (this.parameterToken.getModifiers() != null);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String getName() {
/*     */           String str;
/* 554 */           if ((str = this.parameterToken.getName()) == null)
/* 555 */             return super.getName();  return str;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int getModifiers() {
/*     */           Integer integer;
/* 564 */           if ((integer = this.parameterToken.getModifiers()) == null)
/* 565 */             return super.getModifiers();  return integer
/* 566 */             .intValue();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AnnotationList getDeclaredAnnotations() {
/* 573 */           return this.parameterToken.getAnnotations();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ParameterDescription.InDefinedShape asDefined() {
/* 580 */           return (ParameterDescription.InDefinedShape)Transformer.ForMethod.TransformedMethod.b(this.a).getParameters().get(this.index);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance(includeSyntheticFields = true)
/*     */       protected class AttachmentVisitor
/*     */         extends TypeDescription.Generic.Visitor.Substitutor.WithoutTypeSubstitution
/*     */       {
/*     */         protected AttachmentVisitor(Transformer.ForMethod.TransformedMethod this$0) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param3Generic) {
/* 596 */           TypeList.Generic generic = (TypeList.Generic)this.a.getTypeVariables().filter((ElementMatcher)ElementMatchers.named(param3Generic.getSymbol()));
/* 597 */           return (TypeDescription.Generic)new TypeDescription.Generic.OfTypeVariable.WithAnnotationOverlay(generic.isEmpty() ? 
/* 598 */               Transformer.ForMethod.TransformedMethod.c(this.a).findExpectedVariable(param3Generic.getSymbol()) : (TypeDescription.Generic)generic
/* 599 */               .getOnly(), (AnnotationSource)param3Generic);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.a.equals(((AttachmentVisitor)param3Object).a))));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return getClass().hashCode() * 31 + this.a.hashCode();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Compound<S>
/*     */     implements Transformer<S>
/*     */   {
/*     */     public Compound(Transformer<S>... param1VarArgs) {
/* 625 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 634 */     private final List<Transformer<S>> transformers = new ArrayList<Transformer<S>>(); public Compound(List<? extends Transformer<S>> param1List) {
/* 635 */       for (Iterator<? extends Transformer<S>> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 636 */         Transformer<S> transformer; if (transformer = iterator.next() instanceof Compound) {
/* 637 */           this.transformers.addAll(((Compound)transformer).transformers); continue;
/* 638 */         }  if (!(transformer instanceof Transformer.NoOp)) {
/* 639 */           this.transformers.add(transformer);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S transform(TypeDescription param1TypeDescription, S param1S) {
/* 648 */       for (Iterator<Transformer<S>> iterator = this.transformers.iterator(); iterator.hasNext();) {
/* 649 */         param1S = (transformer = iterator.next()).transform(param1TypeDescription, param1S);
/*     */       }
/* 651 */       return param1S;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.transformers.equals(((Compound)param1Object).transformers))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.transformers.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\Transformer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */