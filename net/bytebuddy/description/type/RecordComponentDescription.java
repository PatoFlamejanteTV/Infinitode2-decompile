/*     */ package net.bytebuddy.description.type;
/*     */ 
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.GenericSignatureFormatError;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Type;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.description.ByteCodeElement;
/*     */ import net.bytebuddy.description.DeclaredByType;
/*     */ import net.bytebuddy.description.NamedElement;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.annotation.AnnotationSource;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureVisitor;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureWriter;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface RecordComponentDescription
/*     */   extends ByteCodeElement.TypeDependant<RecordComponentDescription.InDefinedShape, RecordComponentDescription.Token>, DeclaredByType.WithMandatoryDeclaration, NamedElement.WithDescriptor, AnnotationSource
/*     */ {
/*     */   TypeDescription.Generic getType();
/*     */   
/*     */   MethodDescription getAccessor();
/*     */   
/*     */   Token asToken(ElementMatcher<? super TypeDescription> paramElementMatcher);
/*     */   
/*     */   public static interface InGenericShape
/*     */     extends RecordComponentDescription
/*     */   {
/*     */     MethodDescription.InGenericShape getAccessor();
/*     */   }
/*     */   
/*     */   public static interface InDefinedShape
/*     */     extends RecordComponentDescription
/*     */   {
/*     */     MethodDescription.InDefinedShape getAccessor();
/*     */     
/*     */     TypeDescription getDeclaringType();
/*     */     
/*     */     public static abstract class AbstractBase
/*     */       extends RecordComponentDescription.AbstractBase
/*     */       implements InDefinedShape
/*     */     {
/*     */       public MethodDescription.InDefinedShape getAccessor() {
/* 109 */         return (MethodDescription.InDefinedShape)((MethodList)getDeclaringType().getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named(getActualName()))).getOnly();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public RecordComponentDescription.InDefinedShape asDefined() {
/* 116 */         return this;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     implements RecordComponentDescription
/*     */   {
/*     */     public RecordComponentDescription.Token asToken(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/* 130 */       return new RecordComponentDescription.Token(getActualName(), 
/* 131 */           getType().<TypeDescription.Generic>accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(param1ElementMatcher)), (List<? extends AnnotationDescription>)
/* 132 */           getDeclaredAnnotations());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDescriptor() {
/* 139 */       return getType().asErasure().getDescriptor();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public String getGenericSignature() {
/* 147 */       TypeDescription.Generic generic = getType();
/*     */       try {
/* 149 */         return generic.getSort().isNonGeneric() ? NON_GENERIC_SIGNATURE : ((SignatureVisitor)generic
/*     */           
/* 151 */           .<SignatureVisitor>accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor((SignatureVisitor)new SignatureWriter()))).toString();
/* 152 */       } catch (GenericSignatureFormatError genericSignatureFormatError) {
/* 153 */         return NON_GENERIC_SIGNATURE;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 159 */       return getActualName().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 164 */       if (this == param1Object)
/* 165 */         return true; 
/* 166 */       if (!(param1Object instanceof RecordComponentDescription)) {
/* 167 */         return false;
/*     */       }
/* 169 */       param1Object = param1Object;
/* 170 */       return getActualName().equals(param1Object.getActualName());
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 175 */       return getType().getTypeName() + " " + getActualName();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedRecordComponent
/*     */     extends InDefinedShape.AbstractBase
/*     */   {
/* 187 */     protected static final RecordComponent RECORD_COMPONENT = doPrivileged(JavaDispatcher.of(RecordComponent.class)); static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */        }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final AnnotatedElement recordComponent;
/*     */ 
/*     */     
/*     */     private static final boolean ACCESS_CONTROLLER;
/*     */ 
/*     */     
/*     */     protected ForLoadedRecordComponent(AnnotatedElement param1AnnotatedElement) {
/* 200 */       this.recordComponent = param1AnnotatedElement;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 212 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static RecordComponentDescription of(Object param1Object) {
/* 222 */       if (!RECORD_COMPONENT.isInstance(param1Object)) {
/* 223 */         throw new IllegalArgumentException("Not a record component: " + param1Object);
/*     */       }
/* 225 */       return new ForLoadedRecordComponent((AnnotatedElement)param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 232 */       return new TypeDescription.Generic.LazyProjection.OfRecordComponent(this.recordComponent);
/*     */     }
/*     */ 
/*     */     
/*     */     public MethodDescription.InDefinedShape getAccessor() {
/* 237 */       return (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(RECORD_COMPONENT.getAccessor(this.recordComponent));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getDeclaringType() {
/* 245 */       return TypeDescription.ForLoadedType.of(RECORD_COMPONENT.getDeclaringRecord(this.recordComponent));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getActualName() {
/* 252 */       return RECORD_COMPONENT.getName(this.recordComponent);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public String getGenericSignature() {
/* 258 */       return RECORD_COMPONENT.getGenericSignature(this.recordComponent);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getDeclaredAnnotations() {
/* 265 */       return (AnnotationList)new AnnotationList.ForLoadedAnnotations(this.recordComponent.getDeclaredAnnotations());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Proxied("java.lang.reflect.RecordComponent")
/*     */     protected static interface RecordComponent
/*     */     {
/*     */       @Instance
/*     */       @Proxied("isInstance")
/*     */       boolean isInstance(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getName")
/*     */       String getName(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getDeclaringRecord")
/*     */       Class<?> getDeclaringRecord(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getAccessor")
/*     */       Method getAccessor(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getType")
/*     */       Class<?> getType(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getGenericType")
/*     */       Type getGenericType(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       @Proxied("getGenericSignature")
/*     */       String getGenericSignature(Object param2Object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getAnnotatedType")
/*     */       AnnotatedElement getAnnotatedType(Object param2Object);
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
/*     */     
/*     */     public Latent(TypeDescription param1TypeDescription, RecordComponentDescription.Token param1Token) {
/* 374 */       this(param1TypeDescription, param1Token
/* 375 */           .getName(), param1Token
/* 376 */           .getType(), (List<? extends AnnotationDescription>)param1Token
/* 377 */           .getAnnotations());
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
/*     */     public Latent(TypeDescription param1TypeDescription, String param1String, TypeDescription.Generic param1Generic, List<? extends AnnotationDescription> param1List) {
/* 389 */       this.declaringType = param1TypeDescription;
/* 390 */       this.name = param1String;
/* 391 */       this.type = param1Generic;
/* 392 */       this.annotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 399 */       return this.type.<TypeDescription.Generic>accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getDeclaringType() {
/* 407 */       return this.declaringType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getActualName() {
/* 414 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getDeclaredAnnotations() {
/* 421 */       return (AnnotationList)new AnnotationList.Explicit(this.annotations);
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
/*     */     private final RecordComponentDescription recordComponentDescription;
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
/*     */     public TypeSubstituting(TypeDescription.Generic param1Generic, RecordComponentDescription param1RecordComponentDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 455 */       this.declaringType = param1Generic;
/* 456 */       this.recordComponentDescription = param1RecordComponentDescription;
/* 457 */       this.visitor = param1Visitor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDescription.InGenericShape getAccessor() {
/* 464 */       return (MethodDescription.InGenericShape)((MethodList)this.declaringType.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named(getActualName()))).getOnly();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 471 */       return this.recordComponentDescription.getType().<TypeDescription.Generic>accept((TypeDescription.Generic.Visitor)this.visitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RecordComponentDescription.InDefinedShape asDefined() {
/* 478 */       return (RecordComponentDescription.InDefinedShape)this.recordComponentDescription.asDefined();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDefinition getDeclaringType() {
/* 486 */       return this.declaringType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getActualName() {
/* 493 */       return this.recordComponentDescription.getActualName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getDeclaredAnnotations() {
/* 500 */       return this.recordComponentDescription.getDeclaredAnnotations();
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
/*     */     public Token(String param1String, TypeDescription.Generic param1Generic) {
/* 531 */       this(param1String, param1Generic, Collections.emptyList());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Token(String param1String, TypeDescription.Generic param1Generic, List<? extends AnnotationDescription> param1List) {
/* 542 */       this.name = param1String;
/* 543 */       this.type = param1Generic;
/* 544 */       this.annotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 553 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription.Generic getType() {
/* 562 */       return this.type;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getAnnotations() {
/* 571 */       return (AnnotationList)new AnnotationList.Explicit(this.annotations);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 578 */       return new Token(this.name, this.type.<TypeDescription.Generic>accept((TypeDescription.Generic.Visitor)param1Visitor), this.annotations);
/*     */     }
/*     */     
/*     */     @Enhance("hashCode")
/*     */     public int hashCode() {
/*     */       Token token;
/* 584 */       int k = (token = this).name.hashCode();
/* 585 */       k = k * 31 + token.type.hashCode();
/*     */       int j, i;
/* 587 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + token.annotations.hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 592 */       if (this == param1Object)
/* 593 */         return true; 
/* 594 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 595 */         return false;
/*     */       }
/* 597 */       param1Object = param1Object;
/* 598 */       if (this.name.equals(((Token)param1Object).name) && this.type
/* 599 */         .equals(((Token)param1Object).type) && this.annotations
/* 600 */         .equals(((Token)param1Object).annotations)) return true; 
/*     */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\type\RecordComponentDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */