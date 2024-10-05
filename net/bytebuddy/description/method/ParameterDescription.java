/*      */ package net.bytebuddy.description.method;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.AbstractList;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.ByteCodeElement;
/*      */ import net.bytebuddy.description.ModifierReviewable;
/*      */ import net.bytebuddy.description.NamedElement;
/*      */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.annotation.AnnotationSource;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.implementation.bytecode.StackSize;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface ParameterDescription
/*      */   extends ByteCodeElement.TypeDependant<ParameterDescription.InDefinedShape, ParameterDescription.Token>, ModifierReviewable.ForParameterDescription, NamedElement.WithOptionalName, NamedElement.WithRuntimeName, AnnotationSource
/*      */ {
/*      */   public static final String NAME_PREFIX = "arg";
/*      */   
/*      */   TypeDescription.Generic getType();
/*      */   
/*      */   MethodDescription getDeclaringMethod();
/*      */   
/*      */   int getIndex();
/*      */   
/*      */   boolean hasModifiers();
/*      */   
/*      */   int getOffset();
/*      */   
/*      */   public static interface InGenericShape
/*      */     extends ParameterDescription
/*      */   {
/*      */     MethodDescription.InGenericShape getDeclaringMethod();
/*      */   }
/*      */   
/*      */   public static interface InDefinedShape
/*      */     extends ParameterDescription
/*      */   {
/*      */     MethodDescription.InDefinedShape getDeclaringMethod();
/*      */     
/*      */     public static abstract class AbstractBase
/*      */       extends ParameterDescription.AbstractBase
/*      */       implements InDefinedShape
/*      */     {
/*      */       public ParameterDescription.InDefinedShape asDefined() {
/*  127 */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class AbstractBase
/*      */     extends ModifierReviewable.AbstractBase
/*      */     implements ParameterDescription
/*      */   {
/*      */     public String getName() {
/*  141 */       return "arg".concat(String.valueOf(getIndex()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getInternalName() {
/*  148 */       return getName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getActualName() {
/*  155 */       if (isNamed())
/*  156 */         return getName();  return "";
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/*  164 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getOffset() {
/*  171 */       net.bytebuddy.description.type.TypeList typeList = getDeclaringMethod().getParameters().asTypeList().asErasures();
/*      */ 
/*      */       
/*  174 */       int i = getDeclaringMethod().isStatic() ? StackSize.ZERO.getSize() : StackSize.SINGLE.getSize();
/*  175 */       for (byte b = 0; b < getIndex(); b++) {
/*  176 */         i += ((TypeDescription)typeList.get(b)).getStackSize().getSize();
/*      */       }
/*  178 */       return i;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ParameterDescription.Token asToken(ElementMatcher<? super TypeDescription> param1ElementMatcher) {
/*  185 */       return new ParameterDescription.Token((TypeDescription.Generic)getType().accept((TypeDescription.Generic.Visitor)new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(param1ElementMatcher)), (List<? extends AnnotationDescription>)
/*  186 */           getDeclaredAnnotations(), 
/*  187 */           isNamed() ? 
/*  188 */           getName() : ParameterDescription.Token.NO_NAME, 
/*      */           
/*  190 */           hasModifiers() ? 
/*  191 */           Integer.valueOf(getModifiers()) : ParameterDescription.Token.NO_MODIFIERS);
/*      */     }
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*      */       int j;
/*      */       AbstractBase abstractBase;
/*      */       int i;
/*  198 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : ((abstractBase = this).getDeclaringMethod().hashCode() ^ abstractBase.getIndex()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*  203 */       if (this == param1Object)
/*  204 */         return true; 
/*  205 */       if (!(param1Object instanceof ParameterDescription)) {
/*  206 */         return false;
/*      */       }
/*  208 */       param1Object = param1Object;
/*  209 */       return (getDeclaringMethod().equals(param1Object.getDeclaringMethod()) && getIndex() == param1Object.getIndex());
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  214 */       StringBuilder stringBuilder = new StringBuilder(Modifier.toString(getModifiers()));
/*  215 */       if (getModifiers() != 0) {
/*  216 */         stringBuilder.append(' ');
/*      */       }
/*  218 */       stringBuilder.append(isVarArgs() ? 
/*  219 */           getType().asErasure().getName().replaceFirst("\\[]$", "...") : 
/*  220 */           getType().asErasure().getName());
/*  221 */       return stringBuilder.append(' ').append(getName()).toString();
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
/*      */   public static abstract class ForLoadedParameter<T extends AccessibleObject>
/*      */     extends InDefinedShape.AbstractBase
/*      */   {
/*  235 */     private static final Parameter PARAMETER = doPrivileged(JavaDispatcher.of(Parameter.class)); static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected final T executable;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final int index;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final ParameterAnnotationSource parameterAnnotationSource;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final boolean ACCESS_CONTROLLER;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForLoadedParameter(T param1T, int param1Int, ParameterAnnotationSource param1ParameterAnnotationSource) {
/*  260 */       this.executable = param1T;
/*  261 */       this.index = param1Int;
/*  262 */       this.parameterAnnotationSource = param1ParameterAnnotationSource;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/*  274 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/*  281 */       return PARAMETER.getName(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getIndex() {
/*  288 */       return this.index;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isNamed() {
/*  295 */       return PARAMETER.isNamePresent(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/*  302 */       return PARAMETER.getModifiers(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasModifiers() {
/*  311 */       return (isNamed() || getModifiers() != 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface ParameterAnnotationSource
/*      */     {
/*      */       Annotation[][] getParameterAnnotations();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForLoadedConstructor
/*      */         implements ParameterAnnotationSource
/*      */       {
/*      */         private final Constructor<?> constructor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForLoadedConstructor(Constructor<?> param3Constructor) {
/*  343 */           this.constructor = param3Constructor;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Annotation[][] getParameterAnnotations() {
/*  350 */           return this.constructor.getParameterAnnotations();
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.constructor.equals(((ForLoadedConstructor)param3Object).constructor))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.constructor.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class ForLoadedMethod
/*      */         implements ParameterAnnotationSource
/*      */       {
/*      */         private final Method method;
/*      */         
/*      */         public ForLoadedMethod(Method param3Method) {
/*  371 */           this.method = param3Method;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Annotation[][] getParameterAnnotations() {
/*  378 */           return this.method.getParameterAnnotations();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.method.equals(((ForLoadedMethod)param3Object).method))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.method.hashCode();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Proxied("java.lang.reflect.Parameter")
/*      */     protected static interface Parameter
/*      */     {
/*      */       @Proxied("getModifiers")
/*      */       int getModifiers(Object param2Object);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("isNamePresent")
/*      */       boolean isNamePresent(Object param2Object);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("getName")
/*      */       String getName(Object param2Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class OfMethod
/*      */       extends ForLoadedParameter<Method>
/*      */     {
/*      */       protected OfMethod(Method param2Method, int param2Int, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/*  427 */         super(param2Method, param2Int, param2ParameterAnnotationSource);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs.")
/*      */       public MethodDescription.InDefinedShape getDeclaringMethod() {
/*  435 */         return new MethodDescription.ForLoadedMethod(this.executable);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs.")
/*      */       public TypeDescription.Generic getType() {
/*  443 */         if (TypeDescription.AbstractBase.RAW_TYPES) {
/*  444 */           return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.executable.getParameterTypes()[this.index]);
/*      */         }
/*  446 */         return (TypeDescription.Generic)new TypeDescription.Generic.LazyProjection.OfMethodParameter(this.executable, this.index, this.executable.getParameterTypes());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs.")
/*      */       public AnnotationList getDeclaredAnnotations() {
/*  454 */         return (AnnotationList)new AnnotationList.ForLoadedAnnotations(this.parameterAnnotationSource.getParameterAnnotations()[this.index]);
/*      */       }
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
/*      */     protected static class OfConstructor
/*      */       extends ForLoadedParameter<Constructor<?>>
/*      */     {
/*      */       protected OfConstructor(Constructor<?> param2Constructor, int param2Int, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/*  471 */         super(param2Constructor, param2Int, param2ParameterAnnotationSource);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs.")
/*      */       public MethodDescription.InDefinedShape getDeclaringMethod() {
/*  479 */         return new MethodDescription.ForLoadedConstructor(this.executable);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs.")
/*      */       public TypeDescription.Generic getType() {
/*  487 */         if (TypeDescription.AbstractBase.RAW_TYPES) {
/*  488 */           return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.executable.getParameterTypes()[this.index]);
/*      */         }
/*  490 */         return (TypeDescription.Generic)new TypeDescription.Generic.LazyProjection.OfConstructorParameter(this.executable, this.index, this.executable.getParameterTypes());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs")
/*      */       public AnnotationList getDeclaredAnnotations() {
/*  498 */         Annotation[][] arrayOfAnnotation = this.parameterAnnotationSource.getParameterAnnotations();
/*  499 */         MethodDescription.InDefinedShape inDefinedShape = getDeclaringMethod();
/*  500 */         if (arrayOfAnnotation.length != inDefinedShape.getParameters().size() && inDefinedShape.getDeclaringType().isInnerClass()) {
/*  501 */           return (this.index == 0) ? (AnnotationList)new AnnotationList.Empty() : (AnnotationList)new AnnotationList.ForLoadedAnnotations(arrayOfAnnotation[this.index - 1]);
/*      */         }
/*      */ 
/*      */         
/*  505 */         return (AnnotationList)new AnnotationList.ForLoadedAnnotations(arrayOfAnnotation[this.index]);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class OfLegacyVmMethod
/*      */       extends ParameterDescription.InDefinedShape.AbstractBase
/*      */     {
/*      */       private final Method method;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Class<?>[] parameterType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfLegacyVmMethod(Method param2Method, int param2Int, Class<?>[] param2ArrayOfClass, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/*  545 */         this.method = param2Method;
/*  546 */         this.index = param2Int;
/*  547 */         this.parameterType = param2ArrayOfClass;
/*  548 */         this.parameterAnnotationSource = param2ParameterAnnotationSource;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic getType() {
/*  555 */         if (TypeDescription.AbstractBase.RAW_TYPES) {
/*  556 */           return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.parameterType[this.index]);
/*      */         }
/*  558 */         return (TypeDescription.Generic)new TypeDescription.Generic.LazyProjection.OfMethodParameter(this.method, this.index, this.parameterType);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape getDeclaringMethod() {
/*  565 */         return new MethodDescription.ForLoadedMethod(this.method);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getIndex() {
/*  572 */         return this.index;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isNamed() {
/*  579 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasModifiers() {
/*  586 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationList getDeclaredAnnotations() {
/*  593 */         return (AnnotationList)new AnnotationList.ForLoadedAnnotations(this.parameterAnnotationSource.getParameterAnnotations()[this.index]);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class OfLegacyVmConstructor
/*      */       extends ParameterDescription.InDefinedShape.AbstractBase
/*      */     {
/*      */       private final Constructor<?> constructor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Class<?>[] parameterType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfLegacyVmConstructor(Constructor<?> param2Constructor, int param2Int, Class<?>[] param2ArrayOfClass, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource param2ParameterAnnotationSource) {
/*  632 */         this.constructor = param2Constructor;
/*  633 */         this.index = param2Int;
/*  634 */         this.parameterType = param2ArrayOfClass;
/*  635 */         this.parameterAnnotationSource = param2ParameterAnnotationSource;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic getType() {
/*  642 */         if (TypeDescription.AbstractBase.RAW_TYPES) {
/*  643 */           return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.parameterType[this.index]);
/*      */         }
/*  645 */         return (TypeDescription.Generic)new TypeDescription.Generic.LazyProjection.OfConstructorParameter(this.constructor, this.index, this.parameterType);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public MethodDescription.InDefinedShape getDeclaringMethod() {
/*  652 */         return new MethodDescription.ForLoadedConstructor(this.constructor);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getIndex() {
/*  659 */         return this.index;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isNamed() {
/*  666 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasModifiers() {
/*  673 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationList getDeclaredAnnotations() {
/*  680 */         MethodDescription.InDefinedShape inDefinedShape = getDeclaringMethod();
/*      */         Annotation[][] arrayOfAnnotation;
/*  682 */         if ((arrayOfAnnotation = this.parameterAnnotationSource.getParameterAnnotations()).length != inDefinedShape.getParameters().size() && inDefinedShape.getDeclaringType().isInnerClass()) {
/*  683 */           return (this.index == 0) ? (AnnotationList)new AnnotationList.Empty() : (AnnotationList)new AnnotationList.ForLoadedAnnotations(arrayOfAnnotation[this.index - 1]);
/*      */         }
/*      */ 
/*      */         
/*  687 */         return (AnnotationList)new AnnotationList.ForLoadedAnnotations(arrayOfAnnotation[this.index]);
/*      */       }
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
/*      */     private final MethodDescription.InDefinedShape declaringMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription.Generic parameterType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends AnnotationDescription> declaredAnnotations;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final Integer modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int offset;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Latent(MethodDescription.InDefinedShape param1InDefinedShape, ParameterDescription.Token param1Token, int param1Int1, int param1Int2) {
/*  744 */       this(param1InDefinedShape, param1Token
/*  745 */           .getType(), (List<? extends AnnotationDescription>)param1Token
/*  746 */           .getAnnotations(), param1Token
/*  747 */           .getName(), param1Token
/*  748 */           .getModifiers(), param1Int1, param1Int2);
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
/*      */     public Latent(MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription.Generic param1Generic, int param1Int1, int param1Int2) {
/*  765 */       this(param1InDefinedShape, param1Generic, 
/*      */           
/*  767 */           Collections.emptyList(), ParameterDescription.Token.NO_NAME, ParameterDescription.Token.NO_MODIFIERS, param1Int1, param1Int2);
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
/*      */     public Latent(MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription.Generic param1Generic, List<? extends AnnotationDescription> param1List, @MaybeNull String param1String, @MaybeNull Integer param1Integer, int param1Int1, int param1Int2) {
/*  792 */       this.declaringMethod = param1InDefinedShape;
/*  793 */       this.parameterType = param1Generic;
/*  794 */       this.declaredAnnotations = param1List;
/*  795 */       this.name = param1String;
/*  796 */       this.modifiers = param1Integer;
/*  797 */       this.index = param1Int1;
/*  798 */       this.offset = param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getType() {
/*  805 */       return (TypeDescription.Generic)this.parameterType.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.InDefinedShape getDeclaringMethod() {
/*  812 */       return this.declaringMethod;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getIndex() {
/*  819 */       return this.index;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getOffset() {
/*  826 */       return this.offset;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isNamed() {
/*  833 */       return (this.name != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasModifiers() {
/*  840 */       return (this.modifiers != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/*  847 */       if (this.name == null)
/*  848 */         return super.getName();  return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/*  856 */       if (this.modifiers == null)
/*  857 */         return super.getModifiers();  return this.modifiers
/*  858 */         .intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getDeclaredAnnotations() {
/*  865 */       return (AnnotationList)new AnnotationList.Explicit(this.declaredAnnotations);
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
/*      */   public static class TypeSubstituting
/*      */     extends AbstractBase
/*      */     implements InGenericShape
/*      */   {
/*      */     private final MethodDescription.InGenericShape declaringMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final ParameterDescription parameterDescription;
/*      */ 
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
/*      */     
/*      */     public TypeSubstituting(MethodDescription.InGenericShape param1InGenericShape, ParameterDescription param1ParameterDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/*  904 */       this.declaringMethod = param1InGenericShape;
/*  905 */       this.parameterDescription = param1ParameterDescription;
/*  906 */       this.visitor = param1Visitor;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getType() {
/*  913 */       return (TypeDescription.Generic)this.parameterDescription.getType().accept(this.visitor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodDescription.InGenericShape getDeclaringMethod() {
/*  920 */       return this.declaringMethod;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getIndex() {
/*  927 */       return this.parameterDescription.getIndex();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isNamed() {
/*  934 */       return this.parameterDescription.isNamed();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasModifiers() {
/*  941 */       return this.parameterDescription.hasModifiers();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getOffset() {
/*  948 */       return this.parameterDescription.getOffset();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/*  955 */       return this.parameterDescription.getName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/*  962 */       return this.parameterDescription.getModifiers();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getDeclaredAnnotations() {
/*  969 */       return this.parameterDescription.getDeclaredAnnotations();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ParameterDescription.InDefinedShape asDefined() {
/*  976 */       return (ParameterDescription.InDefinedShape)this.parameterDescription.asDefined();
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
/*      */     @AlwaysNull
/*  989 */     public static final String NO_NAME = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @AlwaysNull
/*  995 */     public static final Integer NO_MODIFIERS = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription.Generic type;
/*      */ 
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
/*      */     private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final Integer modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token(TypeDescription.Generic param1Generic) {
/* 1026 */       this(param1Generic, Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token(TypeDescription.Generic param1Generic, List<? extends AnnotationDescription> param1List) {
/* 1036 */       this(param1Generic, param1List, NO_NAME, NO_MODIFIERS);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token(TypeDescription.Generic param1Generic, @MaybeNull String param1String, @MaybeNull Integer param1Integer) {
/* 1047 */       this(param1Generic, Collections.emptyList(), param1String, param1Integer);
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
/*      */     public Token(TypeDescription.Generic param1Generic, List<? extends AnnotationDescription> param1List, @MaybeNull String param1String, @MaybeNull Integer param1Integer) {
/* 1062 */       this.type = param1Generic;
/* 1063 */       this.annotations = param1List;
/* 1064 */       this.name = param1String;
/* 1065 */       this.modifiers = param1Integer;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription.Generic getType() {
/* 1074 */       return this.type;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getAnnotations() {
/* 1083 */       return (AnnotationList)new AnnotationList.Explicit(this.annotations);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public String getName() {
/* 1093 */       return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public Integer getModifiers() {
/* 1103 */       return this.modifiers;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor) {
/* 1110 */       return new Token((TypeDescription.Generic)this.type.accept(param1Visitor), this.annotations, this.name, this.modifiers);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*      */       Token token;
/* 1119 */       int k = (token = this).type.hashCode();
/* 1120 */       k = k * 31 + token.annotations.hashCode();
/* 1121 */       k = k * 31 + ((token.name != null) ? token.name.hashCode() : 0);
/*      */       int j, i;
/* 1123 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (k = k * 31 + ((token.modifiers != null) ? token.modifiers.hashCode() : 0)))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 1128 */       if (this == param1Object)
/* 1129 */         return true; 
/* 1130 */       if (!(param1Object instanceof Token)) {
/* 1131 */         return false;
/*      */       }
/* 1133 */       param1Object = param1Object;
/* 1134 */       if (this.type.equals(((Token)param1Object).type) && this.annotations
/* 1135 */         .equals(((Token)param1Object).annotations) && ((this.name != null) ? this.name
/* 1136 */         .equals(((Token)param1Object).name) : (((Token)param1Object).name == null)) && ((this.modifiers != null) ? this.modifiers
/* 1137 */         .equals(((Token)param1Object).modifiers) : (((Token)param1Object).modifiers == null))) return true; 
/*      */       return false;
/*      */     }
/*      */     
/*      */     public String toString() {
/* 1142 */       return "ParameterDescription.Token{type=" + this.type + ", annotations=" + this.annotations + ", name='" + this.name + '\'' + ", modifiers=" + this.modifiers + '}';
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
/*      */     public static class TypeList
/*      */       extends AbstractList<Token>
/*      */     {
/*      */       private final List<? extends TypeDefinition> typeDescriptions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList(List<? extends TypeDefinition> param2List) {
/* 1166 */         this.typeDescriptions = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ParameterDescription.Token get(int param2Int) {
/* 1173 */         return new ParameterDescription.Token(((TypeDefinition)this.typeDescriptions.get(param2Int)).asGenericType());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int size() {
/* 1180 */         return this.typeDescriptions.size();
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\method\ParameterDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */