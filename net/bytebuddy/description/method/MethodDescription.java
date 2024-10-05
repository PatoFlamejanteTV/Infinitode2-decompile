/*      */ package net.bytebuddy.description.method;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.AnnotatedElement;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.GenericSignatureFormatError;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Type;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*      */ import net.bytebuddy.description.ByteCodeElement;
/*      */ import net.bytebuddy.description.DeclaredByType;
/*      */ import net.bytebuddy.description.ModifierReviewable;
/*      */ import net.bytebuddy.description.NamedElement;
/*      */ import net.bytebuddy.description.TypeVariableSource;
/*      */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*      */ import net.bytebuddy.description.modifier.ModifierContributor;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.description.type.TypeVariableToken;
/*      */ import net.bytebuddy.jar.asm.Type;
/*      */ import net.bytebuddy.jar.asm.signature.SignatureWriter;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.JavaType;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface MethodDescription
/*      */   extends ByteCodeElement, ByteCodeElement.TypeDependant<MethodDescription.InDefinedShape, MethodDescription.Token>, DeclaredByType.WithMandatoryDeclaration, ModifierReviewable.ForMethodDescription, NamedElement.WithGenericName, TypeVariableSource
/*      */ {
/*      */   public static final String CONSTRUCTOR_INTERNAL_NAME = "<init>";
/*      */   public static final String TYPE_INITIALIZER_INTERNAL_NAME = "<clinit>";
/*      */   public static final int TYPE_INITIALIZER_MODIFIER = 8;
/*      */   @AlwaysNull
/*   82 */   public static final InDefinedShape UNDEFINED = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TypeDescription.Generic getReturnType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ParameterList<?> getParameters();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TypeList.Generic getExceptionTypes();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int getActualModifiers();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int getActualModifiers(boolean paramBoolean);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int getActualModifiers(boolean paramBoolean, Visibility paramVisibility);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isConstructor();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isMethod();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isTypeInitializer();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean represents(Method paramMethod);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean represents(Constructor<?> paramConstructor);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isVirtual();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int getStackSize();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isDefaultMethod();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isSpecializableFor(TypeDescription paramTypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @MaybeNull
/*      */   AnnotationValue<?, ?> getDefaultValue();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @MaybeNull
/*      */   <T> T getDefaultValue(Class<T> paramClass);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isInvokableOn(TypeDescription paramTypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isInvokeBootstrap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isInvokeBootstrap(List<? extends TypeDefinition> paramList);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isConstantBootstrap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isConstantBootstrap(List<? extends TypeDefinition> paramList);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isDefaultValue();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isDefaultValue(AnnotationValue<?, ?> paramAnnotationValue);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @MaybeNull
/*      */   TypeDescription.Generic getReceiverType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   SignatureToken asSignatureToken();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TypeToken asTypeToken();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isBridgeCompatible(TypeToken paramTypeToken);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface InGenericShape
/*      */     extends MethodDescription
/*      */   {
/*      */     TypeDescription.Generic getDeclaringType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ParameterList<ParameterDescription.InGenericShape> getParameters();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface InDefinedShape
/*      */     extends MethodDescription
/*      */   {
/*      */     TypeDescription getDeclaringType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ParameterList<ParameterDescription.InDefinedShape> getParameters();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static abstract class AbstractBase
/*      */       extends MethodDescription.AbstractBase
/*      */       implements InDefinedShape
/*      */     {
/*      */       public MethodDescription.InDefinedShape asDefined() {
/*  350 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public TypeDescription.Generic getReceiverType() {
/*  358 */         if (isStatic())
/*  359 */           return TypeDescription.Generic.UNDEFINED; 
/*  360 */         if (isConstructor()) {
/*  361 */           TypeDescription typeDescription1 = getDeclaringType(); TypeDescription typeDescription2;
/*  362 */           if ((typeDescription2 = getDeclaringType().getEnclosingType()) == null) {
/*  363 */             return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(typeDescription1);
/*      */           }
/*  365 */           if (typeDescription1.isStatic())
/*  366 */             return typeDescription2.asGenericType(); 
/*  367 */           return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(typeDescription2);
/*      */         } 
/*      */         
/*  370 */         return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(getDeclaringType());
/*      */       }
/*      */       
/*      */       @Proxied("java.lang.reflect.Executable")
/*      */       protected static interface Executable
/*      */       {
/*      */         @MaybeNull
/*      */         @Defaults
/*      */         @Proxied("getAnnotatedReceiverType")
/*      */         AnnotatedElement getAnnotatedReceiverType(Object param3Object);
/*      */       }
/*      */       
/*      */       protected static abstract class ForLoadedExecutable<T extends AnnotatedElement>
/*      */         extends AbstractBase {
/*  384 */         protected static final MethodDescription.InDefinedShape.AbstractBase.Executable EXECUTABLE = doPrivileged(JavaDispatcher.of(MethodDescription.InDefinedShape.AbstractBase.Executable.class)); static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */            }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final T executable;
/*      */ 
/*      */         
/*      */         private static final boolean ACCESS_CONTROLLER;
/*      */ 
/*      */         
/*      */         protected ForLoadedExecutable(T param3T) {
/*  397 */           this.executable = param3T;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         private static <T> T doPrivileged(PrivilegedAction<T> param3PrivilegedAction) {
/*  409 */           return ACCESS_CONTROLLER ? AccessController.doPrivileged(param3PrivilegedAction) : param3PrivilegedAction.run();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic getReceiverType() {
/*      */           AnnotatedElement annotatedElement;
/*  417 */           if ((annotatedElement = EXECUTABLE.getAnnotatedReceiverType(this.executable)) == null)
/*  418 */             return super.getReceiverType(); 
/*  419 */           return TypeDefinition.Sort.describeAnnotated(annotatedElement);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class AbstractBase
/*      */     extends TypeVariableSource.AbstractBase
/*      */     implements MethodDescription
/*      */   {
/*      */     private static final int SOURCE_MODIFIERS = 1343;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getStackSize() {
/*  463 */       return getParameters().asTypeList().getStackSize() + (isStatic() ? 0 : 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isMethod() {
/*  470 */       return (!isConstructor() && !isTypeInitializer());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isConstructor() {
/*  477 */       return "<init>".equals(getInternalName());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isTypeInitializer() {
/*  484 */       return "<clinit>".equals(getInternalName());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean represents(Method param1Method) {
/*  491 */       return equals(new MethodDescription.ForLoadedMethod(param1Method));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean represents(Constructor<?> param1Constructor) {
/*  498 */       return equals(new MethodDescription.ForLoadedConstructor(param1Constructor));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/*  505 */       if (isMethod())
/*  506 */         return getInternalName(); 
/*  507 */       return getDeclaringType().asErasure().getName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getActualName() {
/*  514 */       if (isMethod())
/*  515 */         return getName();  return "";
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getDescriptor() {
/*  523 */       StringBuilder stringBuilder = new StringBuilder("(");
/*  524 */       for (TypeDescription typeDescription : getParameters().asTypeList().asErasures()) {
/*  525 */         stringBuilder.append(typeDescription.getDescriptor());
/*      */       }
/*  527 */       return stringBuilder.append(')').append(getReturnType().asErasure().getDescriptor()).toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public String getGenericSignature() {
/*      */       try {
/*  536 */         SignatureWriter signatureWriter = new SignatureWriter();
/*  537 */         boolean bool = false;
/*  538 */         for (TypeDescription.Generic generic2 : getTypeVariables()) {
/*  539 */           signatureWriter.visitFormalTypeParameter(generic2.getSymbol());
/*  540 */           boolean bool1 = true;
/*  541 */           for (Iterator<TypeDescription.Generic> iterator1 = generic2.getUpperBounds().iterator(); iterator1.hasNext(); ) {
/*  542 */             TypeDescription.Generic generic3; (generic3 = iterator1.next()).accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.ForSignatureVisitor(bool1 ? signatureWriter
/*  543 */                   .visitClassBound() : signatureWriter
/*  544 */                   .visitInterfaceBound()));
/*  545 */             bool1 = false;
/*      */           } 
/*  547 */           bool = true;
/*      */         } 
/*  549 */         for (Iterator<TypeDescription.Generic> iterator = getParameters().asTypeList().iterator(); iterator.hasNext(); ) {
/*  550 */           TypeDescription.Generic generic2; (generic2 = iterator.next()).accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitParameterType()));
/*  551 */           bool = (bool || !generic2.getSort().isNonGeneric()) ? true : false;
/*      */         } 
/*      */         TypeDescription.Generic generic;
/*  554 */         (generic = getReturnType()).accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitReturnType()));
/*  555 */         bool = (bool || !generic.getSort().isNonGeneric()) ? true : false;
/*      */         TypeList.Generic generic1;
/*  557 */         if (!((TypeList.Generic)(generic1 = getExceptionTypes()).filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.ofSort(TypeDefinition.Sort.NON_GENERIC)))).isEmpty()) {
/*  558 */           for (Iterator<TypeDescription.Generic> iterator1 = generic1.iterator(); iterator1.hasNext(); ) {
/*  559 */             TypeDescription.Generic generic2; (generic2 = iterator1.next()).accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitExceptionType()));
/*  560 */             bool = (bool || !generic2.getSort().isNonGeneric()) ? true : false;
/*      */           } 
/*      */         }
/*  563 */         if (bool)
/*  564 */           return signatureWriter.toString();  return NON_GENERIC_SIGNATURE;
/*      */       }
/*  566 */       catch (GenericSignatureFormatError genericSignatureFormatError) {
/*  567 */         return NON_GENERIC_SIGNATURE;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getActualModifiers() {
/*  575 */       return getModifiers() | (getDeclaredAnnotations().isAnnotationPresent(Deprecated.class) ? 131072 : 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getActualModifiers(boolean param1Boolean) {
/*  584 */       if (param1Boolean)
/*  585 */         return getActualModifiers() & 0xFFFFFAFF; 
/*  586 */       return getActualModifiers() & 0xFFFFFEFF | 0x400;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getActualModifiers(boolean param1Boolean, Visibility param1Visibility) {
/*  593 */       return ModifierContributor.Resolver.of(Collections.singleton(getVisibility().expandTo(param1Visibility))).resolve(getActualModifiers(param1Boolean));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isVisibleTo(TypeDescription param1TypeDescription) {
/*  600 */       if ((isVirtual() || getDeclaringType().asErasure().isVisibleTo(param1TypeDescription)) && (
/*  601 */         isPublic() || param1TypeDescription
/*  602 */         .equals(getDeclaringType().asErasure()) || (
/*  603 */         isProtected() && getDeclaringType().asErasure().isAssignableFrom(param1TypeDescription)) || (
/*  604 */         !isPrivate() && param1TypeDescription.isSamePackage(getDeclaringType().asErasure())) || (
/*  605 */         isPrivate() && param1TypeDescription.isNestMateOf(getDeclaringType().asErasure())))) return true;
/*      */       
/*      */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isAccessibleTo(TypeDescription param1TypeDescription) {
/*  612 */       if (((isVirtual() || getDeclaringType().asErasure().isVisibleTo(param1TypeDescription)) && (
/*  613 */         isPublic() || param1TypeDescription
/*  614 */         .equals(getDeclaringType().asErasure()) || (
/*  615 */         !isPrivate() && param1TypeDescription.isSamePackage(getDeclaringType().asErasure())))) || (
/*  616 */         isPrivate() && param1TypeDescription.isNestMateOf(getDeclaringType().asErasure()))) return true;
/*      */       
/*      */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isVirtual() {
/*  623 */       return (!isConstructor() && !isPrivate() && !isStatic() && !isTypeInitializer());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDefaultMethod() {
/*  630 */       return (!isAbstract() && !isBridge() && getDeclaringType().isInterface());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSpecializableFor(TypeDescription param1TypeDescription) {
/*  637 */       if (isStatic())
/*  638 */         return false; 
/*  639 */       if (isPrivate() || isConstructor()) {
/*  640 */         return getDeclaringType().equals(param1TypeDescription);
/*      */       }
/*  642 */       return (!isAbstract() && getDeclaringType().asErasure().isAssignableFrom(param1TypeDescription));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public <T> T getDefaultValue(Class<T> param1Class) {
/*  651 */       return param1Class.cast(getDefaultValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isInvokableOn(TypeDescription param1TypeDescription) {
/*  658 */       if (!isStatic() && 
/*  659 */         !isTypeInitializer() && 
/*  660 */         isVisibleTo(param1TypeDescription) && (
/*  661 */         isVirtual() ? 
/*  662 */         getDeclaringType().asErasure().isAssignableFrom(param1TypeDescription) : 
/*  663 */         getDeclaringType().asErasure().equals(param1TypeDescription))) return true;
/*      */       
/*      */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*      */     private boolean isBootstrap(TypeDescription param1TypeDescription) {
/*      */       TypeList typeList;
/*  675 */       switch ((typeList = getParameters().asTypeList().asErasures()).size()) {
/*      */         case 0:
/*  677 */           return false;
/*      */         case 1:
/*  679 */           return ((TypeDescription)typeList.getOnly()).represents(Object[].class);
/*      */         case 2:
/*  681 */           if (JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription)typeList.get(0)) && ((TypeDescription)typeList
/*  682 */             .get(1)).represents(Object[].class)) return true;  return false;
/*      */         case 3:
/*  684 */           if (JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription)typeList.get(0)) && (((TypeDescription)typeList
/*  685 */             .get(1)).represents(Object.class) || ((TypeDescription)typeList.get(1)).represents(String.class)) && ((((TypeDescription)typeList
/*  686 */             .get(2)).isArray() && ((TypeDescription)typeList.get(2)).getComponentType().isAssignableFrom(param1TypeDescription)) || ((TypeDescription)typeList.get(2)).isAssignableFrom(param1TypeDescription))) return true;  return false;
/*      */       } 
/*  688 */       if (JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription)typeList.get(0)) && (((TypeDescription)typeList
/*  689 */         .get(1)).represents(Object.class) || ((TypeDescription)typeList.get(1)).represents(String.class)) && ((TypeDescription)typeList
/*  690 */         .get(2)).isAssignableFrom(param1TypeDescription)) return true;
/*      */       
/*      */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*      */     private boolean isBootstrapping(List<? extends TypeDefinition> param1List) {
/*      */       TypeDefinition typeDefinition;
/*      */       TypeList typeList;
/*  704 */       if ((typeList = getParameters().asTypeList().asErasures()).size() < 4) {
/*  705 */         if (param1List.isEmpty())
/*  706 */           return true; 
/*  707 */         if (((TypeDescription)typeList.get(typeList.size() - 1)).isArray()) {
/*  708 */           for (Iterator<? extends TypeDefinition> iterator1 = param1List.iterator(); iterator1.hasNext();) {
/*  709 */             if (!(typeDefinition = iterator1.next()).asErasure().isAssignableTo(((TypeDescription)typeList.get(typeList.size() - 1)).getComponentType())) {
/*  710 */               return false;
/*      */             }
/*      */           } 
/*  713 */           return true;
/*      */         } 
/*  715 */         return false;
/*      */       } 
/*      */       
/*  718 */       Iterator<TypeDescription> iterator = ((TypeList)typeList.subList(3, typeList.size())).iterator();
/*  719 */       for (TypeDefinition typeDefinition1 : typeDefinition) {
/*  720 */         if (!iterator.hasNext()) {
/*  721 */           return false;
/*      */         }
/*  723 */         TypeDescription typeDescription = iterator.next();
/*  724 */         if (!iterator.hasNext() && typeDescription.isArray())
/*  725 */           return true; 
/*  726 */         if (!typeDefinition1.asErasure().isAssignableTo(typeDescription)) {
/*  727 */           return false;
/*      */         }
/*      */       } 
/*  730 */       if (iterator.hasNext()) {
/*  731 */         return (((TypeDescription)iterator.next()).isArray() && !iterator.hasNext());
/*      */       }
/*  733 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isInvokeBootstrap() {
/*  742 */       TypeDescription typeDescription = getReturnType().asErasure();
/*  743 */       if ((isMethod() && (!isStatic() || (
/*  744 */         !JavaType.CALL_SITE.getTypeStub().isAssignableFrom(typeDescription) && !JavaType.CALL_SITE.getTypeStub().isAssignableTo(typeDescription)))) || (
/*  745 */         isConstructor() && !JavaType.CALL_SITE.getTypeStub().isAssignableFrom(getDeclaringType().asErasure()))) {
/*  746 */         return false;
/*      */       }
/*  748 */       return isBootstrap(JavaType.METHOD_TYPE.getTypeStub());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isInvokeBootstrap(List<? extends TypeDefinition> param1List) {
/*  755 */       return (isInvokeBootstrap() && isBootstrapping(param1List));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isConstantBootstrap() {
/*  762 */       return isBootstrap(TypeDescription.ForLoadedType.of(Class.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isConstantBootstrap(List<? extends TypeDefinition> param1List) {
/*  769 */       return (isConstantBootstrap() && isBootstrapping(param1List));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDefaultValue() {
/*  776 */       if (!isConstructor() && 
/*  777 */         !isStatic() && 
/*  778 */         getReturnType().asErasure().isAnnotationReturnType() && 
/*  779 */         getParameters().isEmpty()) return true;
/*      */       
/*      */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*      */     public boolean isDefaultValue(AnnotationValue<?, ?> param1AnnotationValue) {
/*  787 */       if (!isDefaultValue()) {
/*  788 */         return false;
/*      */       }
/*  790 */       TypeDescription typeDescription = getReturnType().asErasure();
/*  791 */       Object object = param1AnnotationValue.resolve();
/*  792 */       if ((typeDescription.represents(boolean.class) && object instanceof Boolean) || (typeDescription
/*  793 */         .represents(byte.class) && object instanceof Byte) || (typeDescription
/*  794 */         .represents(char.class) && object instanceof Character) || (typeDescription
/*  795 */         .represents(short.class) && object instanceof Short) || (typeDescription
/*  796 */         .represents(int.class) && object instanceof Integer) || (typeDescription
/*  797 */         .represents(long.class) && object instanceof Long) || (typeDescription
/*  798 */         .represents(float.class) && object instanceof Float) || (typeDescription
/*  799 */         .represents(double.class) && object instanceof Double) || (typeDescription
/*  800 */         .represents(String.class) && object instanceof String) || (typeDescription
/*  801 */         .isAssignableTo(Enum.class) && object instanceof EnumerationDescription && isEnumerationType(typeDescription, new EnumerationDescription[] { (EnumerationDescription)object })) || (typeDescription
/*  802 */         .isAssignableTo(Annotation.class) && object instanceof AnnotationDescription && isAnnotationType(typeDescription, new AnnotationDescription[] { (AnnotationDescription)object })) || (typeDescription
/*  803 */         .represents(Class.class) && object instanceof TypeDescription) || (typeDescription
/*  804 */         .represents(boolean[].class) && object instanceof boolean[]) || (typeDescription
/*  805 */         .represents(byte[].class) && object instanceof byte[]) || (typeDescription
/*  806 */         .represents(char[].class) && object instanceof char[]) || (typeDescription
/*  807 */         .represents(short[].class) && object instanceof short[]) || (typeDescription
/*  808 */         .represents(int[].class) && object instanceof int[]) || (typeDescription
/*  809 */         .represents(long[].class) && object instanceof long[]) || (typeDescription
/*  810 */         .represents(float[].class) && object instanceof float[]) || (typeDescription
/*  811 */         .represents(double[].class) && object instanceof double[]) || (typeDescription
/*  812 */         .represents(String[].class) && object instanceof String[]) || (typeDescription
/*  813 */         .isAssignableTo(Enum[].class) && object instanceof EnumerationDescription[] && isEnumerationType(typeDescription.getComponentType(), (EnumerationDescription[])object)) || (typeDescription
/*  814 */         .isAssignableTo(Annotation[].class) && object instanceof AnnotationDescription[] && isAnnotationType(typeDescription.getComponentType(), (AnnotationDescription[])object)) || (typeDescription
/*  815 */         .represents(Class[].class) && object instanceof TypeDescription[])) return true;
/*      */       
/*      */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static boolean isEnumerationType(TypeDescription param1TypeDescription, EnumerationDescription... param1VarArgs) {
/*      */       int i;
/*      */       byte b;
/*  826 */       for (i = (param1VarArgs = param1VarArgs).length, b = 0; b < i; b++) {
/*  827 */         EnumerationDescription enumerationDescription; if (!(enumerationDescription = param1VarArgs[b]).getEnumerationType().equals(param1TypeDescription)) {
/*  828 */           return false;
/*      */         }
/*      */       } 
/*  831 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static boolean isAnnotationType(TypeDescription param1TypeDescription, AnnotationDescription... param1VarArgs) {
/*      */       int i;
/*      */       byte b;
/*  842 */       for (i = (param1VarArgs = param1VarArgs).length, b = 0; b < i; b++) {
/*  843 */         AnnotationDescription annotationDescription; if (!(annotationDescription = param1VarArgs[b]).getAnnotationType().equals(param1TypeDescription)) {
/*  844 */           return false;
/*      */         }
/*      */       } 
/*  847 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeVariableSource getEnclosingSource() {
/*  855 */       return (TypeVariableSource)(isStatic() ? TypeVariableSource.UNDEFINED : 
/*      */         
/*  857 */         getDeclaringType().asErasure());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isInferrable() {
/*  864 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T accept(TypeVariableSource.Visitor<T> param1Visitor) {
/*  871 */       return (T)param1Visitor.onMethod((MethodDescription.InDefinedShape)asDefined());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isGenerified() {
/*  878 */       return !getTypeVariables().isEmpty();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.Token asToken(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/*  885 */       TypeDescription.Generic generic = getReceiverType();
/*  886 */       return new MethodDescription.Token(getInternalName(), 
/*  887 */           getModifiers(), (List<? extends TypeVariableToken>)
/*  888 */           getTypeVariables().asTokenList(param1ElementMatcher), (TypeDescription.Generic)
/*  889 */           getReturnType().accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(param1ElementMatcher)), (List<? extends ParameterDescription.Token>)
/*  890 */           getParameters().asTokenList(param1ElementMatcher), (List<? extends TypeDescription.Generic>)
/*  891 */           getExceptionTypes().accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(param1ElementMatcher)), (List<? extends AnnotationDescription>)
/*  892 */           getDeclaredAnnotations(), 
/*  893 */           getDefaultValue(), (generic == null) ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic)generic
/*      */ 
/*      */           
/*  896 */           .accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(param1ElementMatcher)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.SignatureToken asSignatureToken() {
/*  903 */       return new MethodDescription.SignatureToken(getInternalName(), getReturnType().asErasure(), (List<? extends TypeDescription>)getParameters().asTypeList().asErasures());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.TypeToken asTypeToken() {
/*  910 */       return new MethodDescription.TypeToken(getReturnType().asErasure(), (List<? extends TypeDescription>)getParameters().asTypeList().asErasures());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isBridgeCompatible(MethodDescription.TypeToken param1TypeToken) {
/*  917 */       TypeList<TypeDescription> typeList = getParameters().asTypeList().asErasures(); List<TypeDescription> list = param1TypeToken.getParameterTypes();
/*  918 */       if (typeList.size() != list.size()) {
/*  919 */         return false;
/*      */       }
/*  921 */       for (byte b = 0; b < typeList.size(); b++) {
/*  922 */         if (!((TypeDescription)typeList.get(b)).equals(list.get(b)) && (((TypeDescription)typeList.get(b)).isPrimitive() || ((TypeDescription)list.get(b)).isPrimitive())) {
/*  923 */           return false;
/*      */         }
/*      */       } 
/*  926 */       TypeDescription typeDescription2 = getReturnType().asErasure(), typeDescription1 = param1TypeToken.getReturnType();
/*  927 */       return (typeDescription2.equals(typeDescription1) || (!typeDescription2.isPrimitive() && !typeDescription1.isPrimitive()));
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*  933 */       AbstractBase abstractBase = this; int k = 17 + abstractBase.getDeclaringType().hashCode();
/*  934 */       k = k * 31 + abstractBase.getInternalName().hashCode();
/*  935 */       k = k * 31 + abstractBase.getReturnType().asErasure().hashCode(); int j, i;
/*  936 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k * 31 + abstractBase.getParameters().asTypeList().asErasures().hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*  941 */       if (this == param1Object)
/*  942 */         return true; 
/*  943 */       if (!(param1Object instanceof MethodDescription)) {
/*  944 */         return false;
/*      */       }
/*  946 */       param1Object = param1Object;
/*  947 */       if (getInternalName().equals(param1Object.getInternalName()) && 
/*  948 */         getDeclaringType().equals(param1Object.getDeclaringType()) && 
/*  949 */         getReturnType().asErasure().equals(param1Object.getReturnType().asErasure()) && 
/*  950 */         getParameters().asTypeList().asErasures().equals(param1Object.getParameters().asTypeList().asErasures())) return true;
/*      */       
/*      */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toGenericString() {
/*  957 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       int i;
/*  959 */       if ((i = getModifiers() & 0x53F) != 0) {
/*  960 */         stringBuilder.append(Modifier.toString(i)).append(' ');
/*      */       }
/*  962 */       if (isMethod()) {
/*  963 */         stringBuilder.append(getReturnType().getActualName()).append(' ');
/*  964 */         stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
/*      */       } 
/*  966 */       stringBuilder.append(getName()).append('(');
/*  967 */       i = 1;
/*  968 */       for (TypeDescription.Generic generic1 : getParameters().asTypeList()) {
/*  969 */         if (i == 0) {
/*  970 */           stringBuilder.append(',');
/*      */         } else {
/*  972 */           i = 0;
/*      */         } 
/*  974 */         stringBuilder.append(generic1.getActualName());
/*      */       } 
/*  976 */       stringBuilder.append(')');
/*      */       TypeList.Generic generic;
/*  978 */       if (!(generic = getExceptionTypes()).isEmpty()) {
/*  979 */         stringBuilder.append(" throws ");
/*  980 */         i = 1;
/*  981 */         for (TypeDescription.Generic generic1 : generic) {
/*  982 */           if (i == 0) {
/*  983 */             stringBuilder.append(',');
/*      */           } else {
/*  985 */             i = 0;
/*      */           } 
/*  987 */           stringBuilder.append(generic1.getActualName());
/*      */         } 
/*      */       } 
/*  990 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  995 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       int i;
/*  997 */       if ((i = getModifiers() & 0x53F) != 0) {
/*  998 */         stringBuilder.append(Modifier.toString(i)).append(' ');
/*      */       }
/* 1000 */       if (isMethod()) {
/* 1001 */         stringBuilder.append(getReturnType().asErasure().getActualName()).append(' ');
/* 1002 */         stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
/*      */       } 
/* 1004 */       stringBuilder.append(getName()).append('(');
/* 1005 */       i = 1;
/* 1006 */       for (TypeDescription typeDescription : getParameters().asTypeList().asErasures()) {
/* 1007 */         if (i == 0) {
/* 1008 */           stringBuilder.append(',');
/*      */         } else {
/* 1010 */           i = 0;
/*      */         } 
/* 1012 */         stringBuilder.append(typeDescription.getActualName());
/*      */       } 
/* 1014 */       stringBuilder.append(')');
/*      */       TypeList typeList;
/* 1016 */       if (!(typeList = getExceptionTypes().asErasures()).isEmpty()) {
/* 1017 */         stringBuilder.append(" throws ");
/* 1018 */         i = 1;
/* 1019 */         for (TypeDescription typeDescription : typeList) {
/* 1020 */           if (i == 0) {
/* 1021 */             stringBuilder.append(',');
/*      */           } else {
/* 1023 */             i = 0;
/*      */           } 
/* 1025 */           stringBuilder.append(typeDescription.getActualName());
/*      */         } 
/*      */       } 
/* 1028 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     protected String toSafeString() {
/* 1033 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       int i;
/* 1035 */       if ((i = getModifiers() & 0x53F) != 0) {
/* 1036 */         stringBuilder.append(Modifier.toString(i)).append(' ');
/*      */       }
/* 1038 */       if (isMethod()) {
/* 1039 */         stringBuilder.append(getReturnType().asErasure().getActualName()).append(' ');
/* 1040 */         stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
/*      */       } 
/* 1042 */       return stringBuilder.append(getName()).append("(?)").toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForLoadedConstructor
/*      */     extends InDefinedShape.AbstractBase.ForLoadedExecutable<Constructor<?>>
/*      */     implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
/*      */   {
/*      */     public ForLoadedConstructor(Constructor<?> param1Constructor) {
/* 1057 */       super(param1Constructor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getDeclaringType() {
/* 1065 */       return TypeDescription.ForLoadedType.of(this.executable.getDeclaringClass());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getReturnType() {
/* 1072 */       return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class);
/*      */     }
/*      */     
/*      */     @Enhance("parameters")
/*      */     public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/*      */       ForLoadedConstructor forLoadedConstructor;
/*      */       ParameterList<ParameterDescription.InDefinedShape> parameterList;
/*      */       ParameterList parameterList1;
/* 1080 */       if ((parameterList = (ParameterList<ParameterDescription.InDefinedShape>)(((parameterList1 = this.parameters) != null) ? null : ParameterList.ForLoadedExecutable.of((forLoadedConstructor = this).executable, forLoadedConstructor))) == null) { parameterList = this.parameters; } else { this.parameters = parameterList; }  return parameterList;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getExceptionTypes() {
/* 1087 */       return (TypeList.Generic)new TypeList.Generic.OfConstructorExceptionTypes(this.executable);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isConstructor() {
/* 1094 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isTypeInitializer() {
/* 1101 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean represents(Method param1Method) {
/* 1108 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean represents(Constructor<?> param1Constructor) {
/* 1115 */       return (this.executable.equals(param1Constructor) || equals(new ForLoadedConstructor(param1Constructor)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 1122 */       return this.executable.getName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/* 1129 */       return this.executable.getModifiers();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSynthetic() {
/* 1136 */       return this.executable.isSynthetic();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getInternalName() {
/* 1143 */       return "<init>";
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getDescriptor() {
/* 1150 */       return Type.getConstructorDescriptor(this.executable);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @AlwaysNull
/*      */     public AnnotationValue<?, ?> getDefaultValue() {
/* 1158 */       return AnnotationValue.UNDEFINED;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance("declaredAnnotations")
/*      */     public AnnotationList getDeclaredAnnotations() {
/*      */       AnnotationList annotationList1;
/* 1166 */       ForLoadedConstructor forLoadedConstructor = this; AnnotationList.ForLoadedAnnotations forLoadedAnnotations; AnnotationList annotationList2; if ((forLoadedAnnotations = (AnnotationList.ForLoadedAnnotations)(((annotationList2 = this.declaredAnnotations) != null) ? null : new AnnotationList.ForLoadedAnnotations(forLoadedConstructor.executable.getDeclaredAnnotations()))) == null) { annotationList1 = this.declaredAnnotations; } else { this.declaredAnnotations = annotationList1; }  return annotationList1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getTypeVariables() {
/* 1173 */       return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of(this.executable);
/*      */     }
/*      */     
/*      */     @Enhance("parameterAnnotations")
/*      */     public Annotation[][] getParameterAnnotations() {
/*      */       Annotation[][] arrayOfAnnotation2;
/*      */       Annotation[][] arrayOfAnnotation1;
/*      */       ForLoadedConstructor forLoadedConstructor;
/* 1181 */       if ((arrayOfAnnotation1 = (Annotation[][])(((arrayOfAnnotation2 = this.parameterAnnotations) != null) ? null : (forLoadedConstructor = this).executable.getParameterAnnotations())) == null) { arrayOfAnnotation1 = this.parameterAnnotations; } else { this.parameterAnnotations = arrayOfAnnotation1; }  return arrayOfAnnotation1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForLoadedMethod
/*      */     extends InDefinedShape.AbstractBase.ForLoadedExecutable<Method>
/*      */     implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
/*      */   {
/*      */     public ForLoadedMethod(Method param1Method) {
/* 1196 */       super(param1Method);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getDeclaringType() {
/* 1204 */       return TypeDescription.ForLoadedType.of(this.executable.getDeclaringClass());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getReturnType() {
/* 1211 */       if (TypeDescription.AbstractBase.RAW_TYPES) {
/* 1212 */         return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.executable.getReturnType());
/*      */       }
/* 1214 */       return (TypeDescription.Generic)new TypeDescription.Generic.LazyProjection.ForLoadedReturnType(this.executable);
/*      */     }
/*      */     
/*      */     @Enhance("parameters")
/*      */     public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/*      */       ParameterList parameterList1;
/*      */       ParameterList<ParameterDescription.InDefinedShape> parameterList;
/*      */       ForLoadedMethod forLoadedMethod;
/* 1222 */       if ((parameterList = (ParameterList<ParameterDescription.InDefinedShape>)(((parameterList1 = this.parameters) != null) ? null : ParameterList.ForLoadedExecutable.of((forLoadedMethod = this).executable, forLoadedMethod))) == null) { parameterList = this.parameters; } else { this.parameters = parameterList; }  return parameterList;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getExceptionTypes() {
/* 1229 */       if (TypeDescription.AbstractBase.RAW_TYPES) {
/* 1230 */         return (TypeList.Generic)new TypeList.Generic.ForLoadedTypes((Type[])this.executable.getExceptionTypes());
/*      */       }
/* 1232 */       return (TypeList.Generic)new TypeList.Generic.OfMethodExceptionTypes(this.executable);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isConstructor() {
/* 1239 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isTypeInitializer() {
/* 1246 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isBridge() {
/* 1253 */       return this.executable.isBridge();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean represents(Method param1Method) {
/* 1260 */       return (this.executable.equals(param1Method) || equals(new ForLoadedMethod(param1Method)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean represents(Constructor<?> param1Constructor) {
/* 1267 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 1274 */       return this.executable.getName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/* 1281 */       return this.executable.getModifiers();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSynthetic() {
/* 1288 */       return this.executable.isSynthetic();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getInternalName() {
/* 1295 */       return this.executable.getName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getDescriptor() {
/* 1302 */       return Type.getMethodDescriptor(this.executable);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Method getLoadedMethod() {
/* 1311 */       return this.executable;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance("declaredAnnotations")
/*      */     public AnnotationList getDeclaredAnnotations() {
/*      */       AnnotationList annotationList1;
/* 1319 */       ForLoadedMethod forLoadedMethod = this; AnnotationList annotationList2; AnnotationList.ForLoadedAnnotations forLoadedAnnotations; if ((forLoadedAnnotations = (AnnotationList.ForLoadedAnnotations)(((annotationList2 = this.declaredAnnotations) != null) ? null : new AnnotationList.ForLoadedAnnotations(forLoadedMethod.executable.getDeclaredAnnotations()))) == null) { annotationList1 = this.declaredAnnotations; } else { this.declaredAnnotations = annotationList1; }  return annotationList1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public AnnotationValue<?, ?> getDefaultValue() {
/*      */       Object object;
/* 1328 */       return ((object = this.executable.getDefaultValue()) == null) ? AnnotationValue.UNDEFINED : 
/*      */         
/* 1330 */         AnnotationDescription.ForLoadedAnnotation.asValue(object, this.executable.getReturnType());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getTypeVariables() {
/* 1337 */       if (TypeDescription.AbstractBase.RAW_TYPES) {
/* 1338 */         return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */       }
/* 1340 */       return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of(this.executable);
/*      */     }
/*      */     
/*      */     @Enhance("parameterAnnotations")
/*      */     public Annotation[][] getParameterAnnotations() {
/*      */       ForLoadedMethod forLoadedMethod;
/*      */       Annotation[][] arrayOfAnnotation2;
/*      */       Annotation[][] arrayOfAnnotation1;
/* 1348 */       if ((arrayOfAnnotation1 = (Annotation[][])(((arrayOfAnnotation2 = this.parameterAnnotations) != null) ? null : (forLoadedMethod = this).executable.getParameterAnnotations())) == null) { arrayOfAnnotation1 = this.parameterAnnotations; } else { this.parameterAnnotations = arrayOfAnnotation1; }  return arrayOfAnnotation1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Latent
/*      */     extends InDefinedShape.AbstractBase
/*      */   {
/*      */     private final TypeDescription declaringType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final String internalName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeVariableToken> typeVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription.Generic returnType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends ParameterDescription.Token> parameterTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription.Generic> exceptionTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends AnnotationDescription> declaredAnnotations;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final AnnotationValue<?, ?> defaultValue;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final TypeDescription.Generic receiverType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Latent(TypeDescription param1TypeDescription, MethodDescription.Token param1Token) {
/* 1417 */       this(param1TypeDescription, param1Token
/* 1418 */           .getName(), param1Token
/* 1419 */           .getModifiers(), (List<? extends TypeVariableToken>)param1Token
/* 1420 */           .getTypeVariableTokens(), param1Token
/* 1421 */           .getReturnType(), (List<? extends ParameterDescription.Token>)param1Token
/* 1422 */           .getParameterTokens(), (List<? extends TypeDescription.Generic>)param1Token
/* 1423 */           .getExceptionTypes(), (List<? extends AnnotationDescription>)param1Token
/* 1424 */           .getAnnotations(), param1Token
/* 1425 */           .getDefaultValue(), param1Token
/* 1426 */           .getReceiverType());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Latent(TypeDescription param1TypeDescription, String param1String, int param1Int, List<? extends TypeVariableToken> param1List, TypeDescription.Generic param1Generic1, List<? extends ParameterDescription.Token> param1List1, List<? extends TypeDescription.Generic> param1List2, List<? extends AnnotationDescription> param1List3, @MaybeNull AnnotationValue<?, ?> param1AnnotationValue, @MaybeNull TypeDescription.Generic param1Generic2) {
/* 1453 */       this.declaringType = param1TypeDescription;
/* 1454 */       this.internalName = param1String;
/* 1455 */       this.modifiers = param1Int;
/* 1456 */       this.typeVariables = param1List;
/* 1457 */       this.returnType = param1Generic1;
/* 1458 */       this.parameterTokens = param1List1;
/* 1459 */       this.exceptionTypes = param1List2;
/* 1460 */       this.declaredAnnotations = param1List3;
/* 1461 */       this.defaultValue = param1AnnotationValue;
/* 1462 */       this.receiverType = param1Generic2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getTypeVariables() {
/* 1469 */       return TypeList.Generic.ForDetachedTypes.attachVariables(this, this.typeVariables);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getReturnType() {
/* 1476 */       return (TypeDescription.Generic)this.returnType.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1483 */       return new ParameterList.ForTokens(this, this.parameterTokens);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getExceptionTypes() {
/* 1490 */       return TypeList.Generic.ForDetachedTypes.attach(this, this.exceptionTypes);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getDeclaredAnnotations() {
/* 1497 */       return (AnnotationList)new AnnotationList.Explicit(this.declaredAnnotations);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getInternalName() {
/* 1504 */       return this.internalName;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getDeclaringType() {
/* 1512 */       return this.declaringType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/* 1519 */       return this.modifiers;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public AnnotationValue<?, ?> getDefaultValue() {
/* 1527 */       return this.defaultValue;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription.Generic getReceiverType() {
/* 1535 */       if (this.receiverType == null)
/* 1536 */         return super.getReceiverType();  return (TypeDescription.Generic)this.receiverType
/* 1537 */         .accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class TypeInitializer
/*      */       extends MethodDescription.InDefinedShape.AbstractBase
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeInitializer(TypeDescription param2TypeDescription) {
/* 1556 */         this.typeDescription = param2TypeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic getReturnType() {
/* 1563 */         return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1570 */         return new ParameterList.Empty<ParameterDescription.InDefinedShape>();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic getExceptionTypes() {
/* 1577 */         return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/*      */       public AnnotationValue<?, ?> getDefaultValue() {
/* 1585 */         return AnnotationValue.UNDEFINED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic getTypeVariables() {
/* 1592 */         return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationList getDeclaredAnnotations() {
/* 1599 */         return (AnnotationList)new AnnotationList.Empty();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getDeclaringType() {
/* 1607 */         return this.typeDescription;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getModifiers() {
/* 1614 */         return 8;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getInternalName() {
/* 1621 */         return "<clinit>";
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class TypeSubstituting
/*      */     extends AbstractBase
/*      */     implements InGenericShape
/*      */   {
/*      */     private final TypeDescription.Generic declaringType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeSubstituting(TypeDescription.Generic param1Generic, MethodDescription param1MethodDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 1656 */       this.declaringType = param1Generic;
/* 1657 */       this.methodDescription = param1MethodDescription;
/* 1658 */       this.visitor = param1Visitor;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getReturnType() {
/* 1665 */       return (TypeDescription.Generic)this.methodDescription.getReturnType().accept(this.visitor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getTypeVariables() {
/* 1672 */       return (TypeList.Generic)this.methodDescription.getTypeVariables().accept(this.visitor).filter((ElementMatcher)ElementMatchers.ofSort(TypeDefinition.Sort.VARIABLE));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ParameterList<ParameterDescription.InGenericShape> getParameters() {
/* 1679 */       return new ParameterList.TypeSubstituting(this, (List)this.methodDescription.getParameters(), this.visitor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getExceptionTypes() {
/* 1686 */       return (TypeList.Generic)new TypeList.Generic.ForDetachedTypes((List)this.methodDescription.getExceptionTypes(), this.visitor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public AnnotationValue<?, ?> getDefaultValue() {
/* 1694 */       return this.methodDescription.getDefaultValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getReceiverType() {
/*      */       TypeDescription.Generic generic;
/* 1702 */       return ((generic = this.methodDescription.getReceiverType()) == null) ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic)generic
/*      */         
/* 1704 */         .accept(this.visitor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getDeclaredAnnotations() {
/* 1711 */       return this.methodDescription.getDeclaredAnnotations();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getDeclaringType() {
/* 1719 */       return this.declaringType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/* 1726 */       return this.methodDescription.getModifiers();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getInternalName() {
/* 1733 */       return this.methodDescription.getInternalName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.InDefinedShape asDefined() {
/* 1740 */       return (MethodDescription.InDefinedShape)this.methodDescription.asDefined();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isConstructor() {
/* 1747 */       return this.methodDescription.isConstructor();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isMethod() {
/* 1754 */       return this.methodDescription.isMethod();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isTypeInitializer() {
/* 1761 */       return this.methodDescription.isTypeInitializer();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Token
/*      */     implements ByteCodeElement.Token<Token>
/*      */   {
/*      */     private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeVariableToken> typeVariableTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription.Generic returnType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends ParameterDescription.Token> parameterTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription.Generic> exceptionTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends AnnotationDescription> annotations;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final AnnotationValue<?, ?> defaultValue;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final TypeDescription.Generic receiverType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token(int param1Int) {
/* 1824 */       this("<init>", param1Int, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token(String param1String, int param1Int, TypeDescription.Generic param1Generic) {
/* 1836 */       this(param1String, param1Int, param1Generic, Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token(String param1String, int param1Int, TypeDescription.Generic param1Generic, List<? extends TypeDescription.Generic> param1List) {
/* 1848 */       this(param1String, param1Int, 
/*      */           
/* 1850 */           Collections.emptyList(), param1Generic, new ParameterDescription.Token.TypeList((List)param1List), 
/*      */ 
/*      */           
/* 1853 */           Collections.emptyList(), 
/* 1854 */           Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token(String param1String, int param1Int, List<? extends TypeVariableToken> param1List, TypeDescription.Generic param1Generic1, List<? extends ParameterDescription.Token> param1List1, List<? extends TypeDescription.Generic> param1List2, List<? extends AnnotationDescription> param1List3, @MaybeNull AnnotationValue<?, ?> param1AnnotationValue, @MaybeNull TypeDescription.Generic param1Generic2) {
/* 1881 */       this.name = param1String;
/* 1882 */       this.modifiers = param1Int;
/* 1883 */       this.typeVariableTokens = param1List;
/* 1884 */       this.returnType = param1Generic1;
/* 1885 */       this.parameterTokens = param1List1;
/* 1886 */       this.exceptionTypes = param1List2;
/* 1887 */       this.annotations = param1List3;
/* 1888 */       this.defaultValue = param1AnnotationValue;
/* 1889 */       this.receiverType = param1Generic2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 1898 */       return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/* 1907 */       return this.modifiers;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeElement.Token.TokenList<TypeVariableToken> getTypeVariableTokens() {
/* 1916 */       return new ByteCodeElement.Token.TokenList(this.typeVariableTokens);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getReturnType() {
/* 1925 */       return this.returnType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeElement.Token.TokenList<ParameterDescription.Token> getParameterTokens() {
/* 1934 */       return new ByteCodeElement.Token.TokenList(this.parameterTokens);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getExceptionTypes() {
/* 1943 */       return (TypeList.Generic)new TypeList.Generic.Explicit(this.exceptionTypes);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getAnnotations() {
/* 1952 */       return (AnnotationList)new AnnotationList.Explicit(this.annotations);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public AnnotationValue<?, ?> getDefaultValue() {
/* 1962 */       return this.defaultValue;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription.Generic getReceiverType() {
/* 1972 */       return this.receiverType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 1979 */       return new Token(this.name, this.modifiers, (List<? extends TypeVariableToken>)
/*      */           
/* 1981 */           getTypeVariableTokens().accept(param1Visitor), (TypeDescription.Generic)this.returnType
/* 1982 */           .accept(param1Visitor), (List<? extends ParameterDescription.Token>)
/* 1983 */           getParameterTokens().accept(param1Visitor), (List<? extends TypeDescription.Generic>)
/* 1984 */           getExceptionTypes().accept(param1Visitor), this.annotations, this.defaultValue, (this.receiverType == null) ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic)this.receiverType
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1989 */           .accept(param1Visitor));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.SignatureToken asSignatureToken(TypeDescription param1TypeDescription) {
/* 1999 */       TypeDescription.Generic.Visitor.Reducing reducing = new TypeDescription.Generic.Visitor.Reducing(param1TypeDescription, this.typeVariableTokens);
/* 2000 */       ArrayList<Object> arrayList = new ArrayList(this.parameterTokens.size());
/* 2001 */       for (ParameterDescription.Token token : this.parameterTokens) {
/* 2002 */         arrayList.add(token.getType().accept((TypeDescription.Generic.Visitor)reducing));
/*      */       }
/* 2004 */       return new MethodDescription.SignatureToken(this.name, (TypeDescription)this.returnType.accept((TypeDescription.Generic.Visitor)reducing), arrayList);
/*      */     }
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*      */       Token token;
/* 2010 */       int k = (token = this).name.hashCode();
/* 2011 */       k = k * 31 + token.modifiers;
/* 2012 */       k = k * 31 + token.typeVariableTokens.hashCode();
/* 2013 */       k = k * 31 + token.returnType.hashCode();
/* 2014 */       k = k * 31 + token.parameterTokens.hashCode();
/* 2015 */       k = k * 31 + token.exceptionTypes.hashCode();
/* 2016 */       k = k * 31 + token.annotations.hashCode();
/* 2017 */       k = k * 31 + ((token.defaultValue != null) ? token.defaultValue.hashCode() : 0);
/*      */       int j, i;
/* 2019 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + ((token.receiverType != null) ? token.receiverType.hashCode() : 0)))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 2024 */       if (this == param1Object)
/* 2025 */         return true; 
/* 2026 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 2027 */         return false;
/*      */       }
/* 2029 */       param1Object = param1Object;
/* 2030 */       if (this.modifiers == ((Token)param1Object).modifiers && this.name
/* 2031 */         .equals(((Token)param1Object).name) && this.typeVariableTokens
/* 2032 */         .equals(((Token)param1Object).typeVariableTokens) && this.returnType
/* 2033 */         .equals(((Token)param1Object).returnType) && this.parameterTokens
/* 2034 */         .equals(((Token)param1Object).parameterTokens) && this.exceptionTypes
/* 2035 */         .equals(((Token)param1Object).exceptionTypes) && this.annotations
/* 2036 */         .equals(((Token)param1Object).annotations) && ((this.defaultValue != null) ? this.defaultValue
/* 2037 */         .equals(((Token)param1Object).defaultValue) : (((Token)param1Object).defaultValue == null)) && ((this.receiverType != null) ? this.receiverType
/* 2038 */         .equals(((Token)param1Object).receiverType) : (((Token)param1Object).receiverType == null))) return true; 
/*      */       return false;
/*      */     }
/*      */     
/*      */     public String toString() {
/* 2043 */       return "MethodDescription.Token{name='" + this.name + '\'' + ", modifiers=" + this.modifiers + ", typeVariableTokens=" + this.typeVariableTokens + ", returnType=" + this.returnType + ", parameterTokens=" + this.parameterTokens + ", exceptionTypes=" + this.exceptionTypes + ", annotations=" + this.annotations + ", defaultValue=" + this.defaultValue + ", receiverType=" + this.receiverType + '}';
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SignatureToken
/*      */   {
/*      */     private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription returnType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription> parameterTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SignatureToken(String param1String, TypeDescription param1TypeDescription, TypeDescription... param1VarArgs) {
/* 2085 */       this(param1String, param1TypeDescription, Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SignatureToken(String param1String, TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List) {
/* 2096 */       this.name = param1String;
/* 2097 */       this.returnType = param1TypeDescription;
/* 2098 */       this.parameterTypes = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 2107 */       return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getReturnType() {
/* 2116 */       return this.returnType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<TypeDescription> getParameterTypes() {
/* 2126 */       return (List)this.parameterTypes;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.TypeToken asTypeToken() {
/* 2135 */       return new MethodDescription.TypeToken(this.returnType, this.parameterTypes);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getDescriptor() {
/* 2144 */       StringBuilder stringBuilder = new StringBuilder("(");
/* 2145 */       for (TypeDescription typeDescription : this.parameterTypes) {
/* 2146 */         stringBuilder.append(typeDescription.getDescriptor());
/*      */       }
/* 2148 */       return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
/*      */     }
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*      */       SignatureToken signatureToken;
/* 2154 */       int k = (signatureToken = this).name.hashCode();
/* 2155 */       k = k * 31 + signatureToken.returnType.hashCode();
/*      */       int i, j;
/* 2157 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + signatureToken.parameterTypes.hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 2162 */       if (this == param1Object)
/* 2163 */         return true; 
/* 2164 */       if (!(param1Object instanceof SignatureToken)) {
/* 2165 */         return false;
/*      */       }
/* 2167 */       param1Object = param1Object;
/* 2168 */       if (this.name.equals(((SignatureToken)param1Object).name) && this.returnType
/* 2169 */         .equals(((SignatureToken)param1Object).returnType) && this.parameterTypes
/* 2170 */         .equals(((SignatureToken)param1Object).parameterTypes)) return true; 
/*      */       return false;
/*      */     }
/*      */     
/*      */     public String toString() {
/* 2175 */       StringBuilder stringBuilder = (new StringBuilder()).append(this.returnType).append(' ').append(this.name).append('(');
/* 2176 */       boolean bool = true;
/* 2177 */       for (TypeDescription typeDescription : this.parameterTypes) {
/* 2178 */         if (bool) {
/* 2179 */           bool = false;
/*      */         } else {
/* 2181 */           stringBuilder.append(',');
/*      */         } 
/* 2183 */         stringBuilder.append(typeDescription);
/*      */       } 
/* 2185 */       return stringBuilder.append(')').toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class TypeToken
/*      */   {
/*      */     private final TypeDescription returnType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription> parameterTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeToken(TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List) {
/* 2211 */       this.returnType = param1TypeDescription;
/* 2212 */       this.parameterTypes = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getReturnType() {
/* 2221 */       return this.returnType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<TypeDescription> getParameterTypes() {
/* 2231 */       return (List)this.parameterTypes;
/*      */     }
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*      */       TypeToken typeToken;
/* 2237 */       int k = (typeToken = this).returnType.hashCode();
/*      */       int j, i;
/* 2239 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + typeToken.parameterTypes.hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 2244 */       if (this == param1Object)
/* 2245 */         return true; 
/* 2246 */       if (!(param1Object instanceof TypeToken)) {
/* 2247 */         return false;
/*      */       }
/* 2249 */       param1Object = param1Object;
/* 2250 */       return (this.returnType.equals(((TypeToken)param1Object).returnType) && this.parameterTypes.equals(((TypeToken)param1Object).parameterTypes));
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2255 */       StringBuilder stringBuilder = new StringBuilder("(");
/* 2256 */       for (TypeDescription typeDescription : this.parameterTypes) {
/* 2257 */         stringBuilder.append(typeDescription.getDescriptor());
/*      */       }
/* 2259 */       return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\method\MethodDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */