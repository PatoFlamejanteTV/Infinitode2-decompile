/*     */ package net.bytebuddy.description.field;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.GenericSignatureFormatError;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.description.DeclaredByType;
/*     */ import net.bytebuddy.description.ModifierReviewable;
/*     */ import net.bytebuddy.description.NamedElement;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureVisitor;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureWriter;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface FieldDescription
/*     */   extends ByteCodeElement, ByteCodeElement.TypeDependant<FieldDescription.InDefinedShape, FieldDescription.Token>, DeclaredByType.WithMandatoryDeclaration, ModifierReviewable.ForFieldDescription, NamedElement.WithGenericName
/*     */ {
/*     */   @AlwaysNull
/*  54 */   public static final Object NO_DEFAULT_VALUE = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TypeDescription.Generic getType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getActualModifiers();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SignatureToken asSignatureToken();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface InGenericShape
/*     */     extends FieldDescription
/*     */   {
/*     */     TypeDescription.Generic getDeclaringType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface InDefinedShape
/*     */     extends FieldDescription
/*     */   {
/*     */     TypeDescription getDeclaringType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static abstract class AbstractBase
/*     */       extends FieldDescription.AbstractBase
/*     */       implements InDefinedShape
/*     */     {
/*     */       public FieldDescription.InDefinedShape asDefined() {
/* 110 */         return this;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     extends ModifierReviewable.AbstractBase
/*     */     implements FieldDescription
/*     */   {
/*     */     public String getInternalName() {
/* 124 */       return getName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getActualName() {
/* 131 */       return getName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDescriptor() {
/* 138 */       return getType().asErasure().getDescriptor();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public String getGenericSignature() {
/* 146 */       TypeDescription.Generic generic = getType();
/*     */       try {
/* 148 */         return generic.getSort().isNonGeneric() ? NON_GENERIC_SIGNATURE : ((SignatureVisitor)generic
/*     */           
/* 150 */           .accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.ForSignatureVisitor((SignatureVisitor)new SignatureWriter()))).toString();
/* 151 */       } catch (GenericSignatureFormatError genericSignatureFormatError) {
/* 152 */         return NON_GENERIC_SIGNATURE;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public boolean isVisibleTo(TypeDescription param1TypeDescription) {
/* 161 */       if (getDeclaringType().asErasure().isVisibleTo(param1TypeDescription) && (
/* 162 */         isPublic() || param1TypeDescription
/* 163 */         .equals(getDeclaringType().asErasure()) || (
/* 164 */         isProtected() && getDeclaringType().asErasure().isAssignableFrom(param1TypeDescription)) || (
/* 165 */         !isPrivate() && param1TypeDescription.isSamePackage(getDeclaringType().asErasure())) || (
/* 166 */         isPrivate() && param1TypeDescription.isNestMateOf(getDeclaringType().asErasure())))) return true;
/*     */       
/*     */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public boolean isAccessibleTo(TypeDescription param1TypeDescription) {
/* 174 */       if (isPublic() || param1TypeDescription
/* 175 */         .equals(getDeclaringType().asErasure()) || (
/* 176 */         !isPrivate() && param1TypeDescription.isSamePackage(getDeclaringType().asErasure())) || (
/* 177 */         isPrivate() && param1TypeDescription.isNestMateOf(getDeclaringType().asErasure()))) return true;
/*     */       
/*     */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getActualModifiers() {
/* 184 */       return getModifiers() | (getDeclaredAnnotations().isAnnotationPresent(Deprecated.class) ? 131072 : 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDescription.Token asToken(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 193 */       return new FieldDescription.Token(getName(), 
/* 194 */           getModifiers(), (TypeDescription.Generic)
/* 195 */           getType().accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(param1ElementMatcher)), (List<? extends AnnotationDescription>)
/* 196 */           getDeclaredAnnotations());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDescription.SignatureToken asSignatureToken() {
/* 203 */       return new FieldDescription.SignatureToken(getInternalName(), getType().asErasure());
/*     */     } @Enhance("hashCode")
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public int hashCode() {
/*     */       int i;
/*     */       int j;
/*     */       AbstractBase abstractBase;
/* 210 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : ((abstractBase = this).getDeclaringType().hashCode() + 31 * (17 + abstractBase.getName().hashCode())))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*     */     }
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 216 */       if (this == param1Object)
/* 217 */         return true; 
/* 218 */       if (!(param1Object instanceof FieldDescription)) {
/* 219 */         return false;
/*     */       }
/* 221 */       param1Object = param1Object;
/* 222 */       return (getName().equals(param1Object.getName()) && getDeclaringType().equals(param1Object.getDeclaringType()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public String toGenericString() {
/* 230 */       StringBuilder stringBuilder = new StringBuilder();
/* 231 */       if (getModifiers() != 0) {
/* 232 */         stringBuilder.append(Modifier.toString(getModifiers())).append(' ');
/*     */       }
/* 234 */       stringBuilder.append(getType().getActualName()).append(' ');
/* 235 */       stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
/* 236 */       return stringBuilder.append(getName()).toString();
/*     */     }
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*     */     public String toString() {
/* 242 */       StringBuilder stringBuilder = new StringBuilder();
/* 243 */       if (getModifiers() != 0) {
/* 244 */         stringBuilder.append(Modifier.toString(getModifiers())).append(' ');
/*     */       }
/* 246 */       stringBuilder.append(getType().asErasure().getActualName()).append(' ');
/* 247 */       stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
/* 248 */       return stringBuilder.append(getName()).toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedField
/*     */     extends InDefinedShape.AbstractBase
/*     */   {
/*     */     private final Field field;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedField(Field param1Field) {
/* 268 */       this.field = param1Field;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 275 */       if (TypeDescription.AbstractBase.RAW_TYPES) {
/* 276 */         return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.field.getType());
/*     */       }
/* 278 */       return (TypeDescription.Generic)new TypeDescription.Generic.LazyProjection.ForLoadedFieldType(this.field);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance("declaredAnnotations")
/*     */     public AnnotationList getDeclaredAnnotations() {
/*     */       AnnotationList annotationList1;
/* 286 */       ForLoadedField forLoadedField = this; AnnotationList.ForLoadedAnnotations forLoadedAnnotations; AnnotationList annotationList2; if ((forLoadedAnnotations = (AnnotationList.ForLoadedAnnotations)(((annotationList2 = this.declaredAnnotations) != null) ? null : new AnnotationList.ForLoadedAnnotations(forLoadedField.field.getDeclaredAnnotations()))) == null) { annotationList1 = this.declaredAnnotations; } else { this.declaredAnnotations = annotationList1; }  return annotationList1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 293 */       return this.field.getName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getDeclaringType() {
/* 301 */       return TypeDescription.ForLoadedType.of(this.field.getDeclaringClass());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getModifiers() {
/* 308 */       return this.field.getModifiers();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSynthetic() {
/* 315 */       return this.field.isSynthetic();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Latent
/*     */     extends InDefinedShape.AbstractBase
/*     */   {
/*     */     private final TypeDescription declaringType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int modifiers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription.Generic fieldType;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends AnnotationDescription> declaredAnnotations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Latent(TypeDescription param1TypeDescription, FieldDescription.Token param1Token) {
/* 357 */       this(param1TypeDescription, param1Token
/* 358 */           .getName(), param1Token
/* 359 */           .getModifiers(), param1Token
/* 360 */           .getType(), (List<? extends AnnotationDescription>)param1Token
/* 361 */           .getAnnotations());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Latent(TypeDescription param1TypeDescription, String param1String, int param1Int, TypeDescription.Generic param1Generic, List<? extends AnnotationDescription> param1List) {
/* 378 */       this.declaringType = param1TypeDescription;
/* 379 */       this.name = param1String;
/* 380 */       this.modifiers = param1Int;
/* 381 */       this.fieldType = param1Generic;
/* 382 */       this.declaredAnnotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 389 */       return (TypeDescription.Generic)this.fieldType.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getDeclaredAnnotations() {
/* 396 */       return (AnnotationList)new AnnotationList.Explicit(this.declaredAnnotations);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 403 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getDeclaringType() {
/* 411 */       return this.declaringType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getModifiers() {
/* 418 */       return this.modifiers;
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
/*     */     extends AbstractBase
/*     */     implements InGenericShape
/*     */   {
/*     */     private final TypeDescription.Generic declaringType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final FieldDescription fieldDescription;
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
/*     */     public TypeSubstituting(TypeDescription.Generic param1Generic, FieldDescription param1FieldDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 452 */       this.declaringType = param1Generic;
/* 453 */       this.fieldDescription = param1FieldDescription;
/* 454 */       this.visitor = param1Visitor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 461 */       return (TypeDescription.Generic)this.fieldDescription.getType().accept(this.visitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getDeclaredAnnotations() {
/* 468 */       return this.fieldDescription.getDeclaredAnnotations();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getDeclaringType() {
/* 476 */       return this.declaringType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getModifiers() {
/* 483 */       return this.fieldDescription.getModifiers();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 490 */       return this.fieldDescription.getName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDescription.InDefinedShape asDefined() {
/* 497 */       return (FieldDescription.InDefinedShape)this.fieldDescription.asDefined();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Token
/*     */     implements ByteCodeElement.Token<Token>
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int modifiers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription.Generic type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends AnnotationDescription> annotations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Token(String param1String, int param1Int, TypeDescription.Generic param1Generic) {
/* 534 */       this(param1String, param1Int, param1Generic, Collections.emptyList());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Token(String param1String, int param1Int, TypeDescription.Generic param1Generic, List<? extends AnnotationDescription> param1List) {
/* 546 */       this.name = param1String;
/* 547 */       this.modifiers = param1Int;
/* 548 */       this.type = param1Generic;
/* 549 */       this.annotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 558 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 567 */       return this.type;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getModifiers() {
/* 576 */       return this.modifiers;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getAnnotations() {
/* 585 */       return (AnnotationList)new AnnotationList.Explicit(this.annotations);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 592 */       return new Token(this.name, this.modifiers, (TypeDescription.Generic)this.type
/*     */           
/* 594 */           .accept(param1Visitor), this.annotations);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDescription.SignatureToken asSignatureToken(TypeDescription param1TypeDescription) {
/* 605 */       return new FieldDescription.SignatureToken(this.name, (TypeDescription)this.type.accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Reducing(param1TypeDescription, new net.bytebuddy.description.type.TypeVariableToken[0])));
/*     */     }
/*     */     
/*     */     @Enhance("hashCode")
/*     */     public int hashCode() {
/*     */       Token token;
/* 611 */       int k = (token = this).name.hashCode();
/* 612 */       k = k * 31 + token.modifiers;
/* 613 */       k = k * 31 + token.type.hashCode();
/*     */       int i, j;
/* 615 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + token.annotations.hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 620 */       if (this == param1Object)
/* 621 */         return true; 
/* 622 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 623 */         return false;
/*     */       }
/* 625 */       param1Object = param1Object;
/* 626 */       if (this.modifiers == ((Token)param1Object).modifiers && this.name
/* 627 */         .equals(((Token)param1Object).name) && this.type
/* 628 */         .equals(((Token)param1Object).type) && this.annotations
/* 629 */         .equals(((Token)param1Object).annotations)) return true;
/*     */       
/*     */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SignatureToken
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeDescription type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SignatureToken(String param1String, TypeDescription param1TypeDescription) {
/* 655 */       this.name = param1String;
/* 656 */       this.type = param1TypeDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 665 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getType() {
/* 674 */       return this.type;
/*     */     }
/*     */     
/*     */     @Enhance("hashCode")
/*     */     public int hashCode() {
/*     */       SignatureToken signatureToken;
/* 680 */       int k = (signatureToken = this).name.hashCode();
/*     */       int j, i;
/* 682 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + signatureToken.type.hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 687 */       if (this == param1Object)
/* 688 */         return true; 
/* 689 */       if (!(param1Object instanceof SignatureToken)) {
/* 690 */         return false;
/*     */       }
/* 692 */       param1Object = param1Object;
/* 693 */       return (this.name.equals(((SignatureToken)param1Object).name) && this.type.equals(((SignatureToken)param1Object).type));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 698 */       return this.type + " " + this.name;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\field\FieldDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */