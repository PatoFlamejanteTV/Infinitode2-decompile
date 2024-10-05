/*       */ package net.bytebuddy.description.type;
/*       */ 
/*       */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*       */ import java.io.Serializable;
/*       */ import java.lang.annotation.Annotation;
/*       */ import java.lang.reflect.AccessibleObject;
/*       */ import java.lang.reflect.AnnotatedElement;
/*       */ import java.lang.reflect.Constructor;
/*       */ import java.lang.reflect.Field;
/*       */ import java.lang.reflect.GenericArrayType;
/*       */ import java.lang.reflect.GenericSignatureFormatError;
/*       */ import java.lang.reflect.InvocationHandler;
/*       */ import java.lang.reflect.InvocationTargetException;
/*       */ import java.lang.reflect.Method;
/*       */ import java.lang.reflect.ParameterizedType;
/*       */ import java.lang.reflect.Proxy;
/*       */ import java.lang.reflect.Type;
/*       */ import java.lang.reflect.TypeVariable;
/*       */ import java.lang.reflect.WildcardType;
/*       */ import java.security.AccessController;
/*       */ import java.security.PrivilegedAction;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Arrays;
/*       */ import java.util.Collection;
/*       */ import java.util.Collections;
/*       */ import java.util.Comparator;
/*       */ import java.util.HashMap;
/*       */ import java.util.HashSet;
/*       */ import java.util.Iterator;
/*       */ import java.util.List;
/*       */ import java.util.Map;
/*       */ import net.bytebuddy.ClassFileVersion;
/*       */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*       */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*       */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*       */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*       */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*       */ import net.bytebuddy.description.ByteCodeElement;
/*       */ import net.bytebuddy.description.ModifierReviewable;
/*       */ import net.bytebuddy.description.TypeVariableSource;
/*       */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*       */ import net.bytebuddy.description.annotation.AnnotationList;
/*       */ import net.bytebuddy.description.annotation.AnnotationSource;
/*       */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*       */ import net.bytebuddy.description.field.FieldDescription;
/*       */ import net.bytebuddy.description.field.FieldList;
/*       */ import net.bytebuddy.description.method.MethodDescription;
/*       */ import net.bytebuddy.description.method.MethodList;
/*       */ import net.bytebuddy.description.method.ParameterDescription;
/*       */ import net.bytebuddy.dynamic.TargetType;
/*       */ import net.bytebuddy.implementation.bytecode.StackSize;
/*       */ import net.bytebuddy.jar.asm.Type;
/*       */ import net.bytebuddy.jar.asm.signature.SignatureVisitor;
/*       */ import net.bytebuddy.jar.asm.signature.SignatureWriter;
/*       */ import net.bytebuddy.matcher.ElementMatcher;
/*       */ import net.bytebuddy.matcher.ElementMatchers;
/*       */ import net.bytebuddy.utility.CompoundList;
/*       */ import net.bytebuddy.utility.FieldComparator;
/*       */ import net.bytebuddy.utility.GraalImageCode;
/*       */ import net.bytebuddy.utility.JavaType;
/*       */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*       */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
/*       */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
/*       */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
/*       */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*       */ import net.bytebuddy.utility.nullability.MaybeNull;
/*       */ import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
/*       */ 
/*       */ public interface TypeDescription extends ByteCodeElement, TypeVariableSource, TypeDefinition {
/*       */   @Deprecated
/*    71 */   public static final TypeDescription OBJECT = LazyProxy.of(Object.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Deprecated
/*    79 */   public static final TypeDescription STRING = LazyProxy.of(String.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Deprecated
/*    87 */   public static final TypeDescription CLASS = LazyProxy.of(Class.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Deprecated
/*    95 */   public static final TypeDescription THROWABLE = LazyProxy.of(Throwable.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Deprecated
/*   103 */   public static final TypeDescription VOID = LazyProxy.of(void.class);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*   108 */   public static final TypeList.Generic ARRAY_INTERFACES = new TypeList.Generic.ForLoadedTypes(new Type[] { Cloneable.class, Serializable.class });
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @AlwaysNull
/*   115 */   public static final TypeDescription UNDEFINED = null;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   FieldList<FieldDescription.InDefinedShape> getDeclaredFields();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   MethodList<MethodDescription.InDefinedShape> getDeclaredMethods();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isInstance(Object paramObject);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAssignableFrom(Class<?> paramClass);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAssignableFrom(TypeDescription paramTypeDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAssignableTo(Class<?> paramClass);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAssignableTo(TypeDescription paramTypeDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isInHierarchyWith(Class<?> paramClass);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isInHierarchyWith(TypeDescription paramTypeDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   TypeDescription getComponentType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   TypeDescription getDeclaringType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   TypeList getDeclaredTypes();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   MethodDescription.InDefinedShape getEnclosingMethod();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   TypeDescription getEnclosingType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   int getActualModifiers(boolean paramBoolean);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   String getSimpleName();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   String getLongSimpleName();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   String getCanonicalName();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAnonymousType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isLocalType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isMemberType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   PackageDescription getPackage();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   AnnotationList getInheritedAnnotations();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isSamePackage(TypeDescription paramTypeDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isPrimitiveWrapper();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAnnotationReturnType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAnnotationValue();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isAnnotationValue(Object paramObject);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isPackageType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   int getInnerClassCount();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isInnerClass();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isNestedClass();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   TypeDescription asBoxed();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   TypeDescription asUnboxed();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   Object getDefaultValue();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   TypeDescription getNestHost();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   TypeList getNestMembers();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isNestHost();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isNestMateOf(Class<?> paramClass);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isNestMateOf(TypeDescription paramTypeDescription);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isCompileTimeConstant();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   TypeList getPermittedSubtypes();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   boolean isSealed();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @MaybeNull
/*       */   ClassFileVersion getClassFileVersion();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static interface Generic
/*       */     extends AnnotationSource, TypeDefinition
/*       */   {
/*       */     @Deprecated
/*   494 */     public static final Generic OBJECT = LazyProxy.of(Object.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Deprecated
/*   502 */     public static final Generic CLASS = LazyProxy.of(Class.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Deprecated
/*   510 */     public static final Generic VOID = LazyProxy.of(void.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Deprecated
/*   518 */     public static final Generic ANNOTATION = LazyProxy.of(Annotation.class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @AlwaysNull
/*   525 */     public static final Generic UNDEFINED = null;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     Generic asRawType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypeList.Generic getUpperBounds();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypeList.Generic getLowerBounds();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypeList.Generic getTypeArguments();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     Generic getOwnerType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     Generic findBindingOf(Generic param1Generic);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     TypeVariableSource getTypeVariableSource();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     String getSymbol();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     Generic getComponentType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     FieldList<FieldDescription.InGenericShape> getDeclaredFields();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     MethodList<MethodDescription.InGenericShape> getDeclaredMethods();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     <T> T accept(Visitor<T> param1Visitor);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface Visitor<T>
/*       */     {
/*       */       T onGenericArray(TypeDescription.Generic param2Generic);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       T onWildcard(TypeDescription.Generic param2Generic);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       T onParameterizedType(TypeDescription.Generic param2Generic);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       T onTypeVariable(TypeDescription.Generic param2Generic);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       T onNonGenericType(TypeDescription.Generic param2Generic);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum NoOp
/*       */         implements Visitor<TypeDescription.Generic>
/*       */       {
/*   711 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onGenericArray(TypeDescription.Generic param3Generic) {
/*   717 */           return param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onWildcard(TypeDescription.Generic param3Generic) {
/*   724 */           return param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onParameterizedType(TypeDescription.Generic param3Generic) {
/*   731 */           return param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onTypeVariable(TypeDescription.Generic param3Generic) {
/*   738 */           return param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onNonGenericType(TypeDescription.Generic param3Generic) {
/*   745 */           return param3Generic;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum TypeErasing
/*       */         implements Visitor<TypeDescription.Generic>
/*       */       {
/*   757 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onGenericArray(TypeDescription.Generic param3Generic) {
/*   763 */           return param3Generic.asRawType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onWildcard(TypeDescription.Generic param3Generic) {
/*   770 */           throw new IllegalArgumentException("Cannot erase a wildcard type: " + param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onParameterizedType(TypeDescription.Generic param3Generic) {
/*   777 */           return param3Generic.asRawType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onTypeVariable(TypeDescription.Generic param3Generic) {
/*   784 */           return param3Generic.asRawType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onNonGenericType(TypeDescription.Generic param3Generic) {
/*   791 */           return param3Generic.asRawType();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum AnnotationStripper
/*       */         implements Visitor<TypeDescription.Generic>
/*       */       {
/*   803 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public final TypeDescription.Generic onGenericArray(TypeDescription.Generic param3Generic) {
/*   810 */           return new TypeDescription.Generic.OfGenericArray.Latent(param3Generic.getComponentType().<TypeDescription.Generic>accept(this), (AnnotationSource)AnnotationSource.Empty.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onWildcard(TypeDescription.Generic param3Generic) {
/*   817 */           return new TypeDescription.Generic.OfWildcardType.Latent((List<? extends TypeDescription.Generic>)param3Generic.getUpperBounds().accept(this), (List<? extends TypeDescription.Generic>)param3Generic.getLowerBounds().accept(this), (AnnotationSource)AnnotationSource.Empty.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onParameterizedType(TypeDescription.Generic param3Generic) {
/*   824 */           TypeDescription.Generic generic = param3Generic.getOwnerType();
/*   825 */           return new TypeDescription.Generic.OfParameterizedType.Latent(param3Generic.asErasure(), (generic == null) ? TypeDescription.Generic.UNDEFINED : generic
/*       */ 
/*       */               
/*   828 */               .<TypeDescription.Generic>accept(this), (List<? extends TypeDescription.Generic>)param3Generic
/*   829 */               .getTypeArguments().accept(this), (AnnotationSource)AnnotationSource.Empty.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic onTypeVariable(TypeDescription.Generic param3Generic) {
/*   837 */           return new NonAnnotatedTypeVariable(param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public final TypeDescription.Generic onNonGenericType(TypeDescription.Generic param3Generic) {
/*   845 */           return (TypeDescription.Generic)(param3Generic.isArray() ? new TypeDescription.Generic.OfGenericArray.Latent(
/*   846 */               onNonGenericType(param3Generic.getComponentType()), (AnnotationSource)AnnotationSource.Empty.INSTANCE) : new TypeDescription.Generic.OfNonGenericType.Latent(param3Generic
/*   847 */               .asErasure(), (AnnotationSource)AnnotationSource.Empty.INSTANCE));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class NonAnnotatedTypeVariable
/*       */           extends TypeDescription.Generic.OfTypeVariable
/*       */         {
/*       */           private final TypeDescription.Generic typeVariable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected NonAnnotatedTypeVariable(TypeDescription.Generic param4Generic) {
/*   866 */             this.typeVariable = param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeList.Generic getUpperBounds() {
/*   873 */             return this.typeVariable.getUpperBounds();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeVariableSource getTypeVariableSource() {
/*   880 */             return this.typeVariable.getTypeVariableSource();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public String getSymbol() {
/*   887 */             return this.typeVariable.getSymbol();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotationList getDeclaredAnnotations() {
/*   894 */             return (AnnotationList)new AnnotationList.Empty();
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum Assigner
/*       */         implements Visitor<Assigner.Dispatcher>
/*       */       {
/*   909 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Dispatcher onGenericArray(TypeDescription.Generic param3Generic) {
/*   915 */           return new Dispatcher.ForGenericArray(param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Dispatcher onWildcard(TypeDescription.Generic param3Generic) {
/*   922 */           throw new IllegalArgumentException("A wildcard is not a first level type: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Dispatcher onParameterizedType(TypeDescription.Generic param3Generic) {
/*   929 */           return new Dispatcher.ForParameterizedType(param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Dispatcher onTypeVariable(TypeDescription.Generic param3Generic) {
/*   936 */           return new Dispatcher.ForTypeVariable(param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Dispatcher onNonGenericType(TypeDescription.Generic param3Generic) {
/*   943 */           return new Dispatcher.ForNonGenericType(param3Generic.asErasure());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForNonGenericType
/*       */           extends Dispatcher.AbstractBase
/*       */         {
/*       */           private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ForNonGenericType(TypeDescription param4TypeDescription) {
/*   989 */             this.typeDescription = param4TypeDescription;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */           public Boolean onGenericArray(TypeDescription.Generic param4Generic) {
/*   997 */             return Boolean.valueOf(this.typeDescription.isArray() ? ((Boolean)param4Generic
/*   998 */                 .getComponentType().<Boolean>accept(new ForNonGenericType(this.typeDescription.getComponentType()))).booleanValue() : ((this.typeDescription
/*   999 */                 .represents(Object.class) || TypeDescription.ARRAY_INTERFACES.contains(this.typeDescription.asGenericType()))));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onWildcard(TypeDescription.Generic param4Generic) {
/*  1006 */             throw new IllegalArgumentException("A wildcard is not a first-level type: " + param4Generic);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1013 */             if (this.typeDescription.equals(param4Generic.asErasure())) {
/*  1014 */               return Boolean.TRUE;
/*       */             }
/*       */             
/*  1017 */             if ((generic = param4Generic.getSuperClass()) != null && isAssignableFrom(generic)) {
/*  1018 */               return Boolean.TRUE;
/*       */             }
/*  1020 */             for (TypeDescription.Generic generic : param4Generic.getInterfaces()) {
/*  1021 */               if (isAssignableFrom(generic)) {
/*  1022 */                 return Boolean.TRUE;
/*       */               }
/*       */             } 
/*  1025 */             return Boolean.valueOf(this.typeDescription.represents(Object.class));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onTypeVariable(TypeDescription.Generic param4Generic) {
/*  1032 */             for (TypeDescription.Generic generic : param4Generic.getUpperBounds()) {
/*  1033 */               if (isAssignableFrom(generic)) {
/*  1034 */                 return Boolean.TRUE;
/*       */               }
/*       */             } 
/*  1037 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1044 */             return Boolean.valueOf(this.typeDescription.isAssignableFrom(param4Generic.asErasure()));
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((ForNonGenericType)param4Object).typeDescription))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*       */           }
/*       */         }
/*       */         
/*       */         @Enhance
/*       */         public static class ForTypeVariable
/*       */           extends Dispatcher.AbstractBase
/*       */         {
/*       */           private final TypeDescription.Generic typeVariable;
/*       */           
/*       */           protected ForTypeVariable(TypeDescription.Generic param4Generic) {
/*  1065 */             this.typeVariable = param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onGenericArray(TypeDescription.Generic param4Generic) {
/*  1072 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onWildcard(TypeDescription.Generic param4Generic) {
/*  1079 */             throw new IllegalArgumentException("A wildcard is not a first-level type: " + param4Generic);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1086 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onTypeVariable(TypeDescription.Generic param4Generic) {
/*  1093 */             if (param4Generic.equals(this.typeVariable)) {
/*  1094 */               return Boolean.TRUE;
/*       */             }
/*  1096 */             for (TypeDescription.Generic generic : param4Generic.getUpperBounds()) {
/*  1097 */               if (isAssignableFrom(generic)) {
/*  1098 */                 return Boolean.TRUE;
/*       */               }
/*       */             } 
/*  1101 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1108 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeVariable.equals(((ForTypeVariable)param4Object).typeVariable))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.typeVariable.hashCode();
/*       */           }
/*       */         }
/*       */         
/*       */         @Enhance
/*       */         public static class ForParameterizedType
/*       */           extends Dispatcher.AbstractBase
/*       */         {
/*       */           private final TypeDescription.Generic parameterizedType;
/*       */           
/*       */           protected ForParameterizedType(TypeDescription.Generic param4Generic) {
/*  1129 */             this.parameterizedType = param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onGenericArray(TypeDescription.Generic param4Generic) {
/*  1136 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onWildcard(TypeDescription.Generic param4Generic) {
/*  1143 */             throw new IllegalArgumentException("A wildcard is not a first-level type: " + param4Generic);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*       */             // Byte code:
/*       */             //   0: aload_0
/*       */             //   1: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */             //   4: invokeinterface asErasure : ()Lnet/bytebuddy/description/type/TypeDescription;
/*       */             //   9: aload_1
/*       */             //   10: invokeinterface asErasure : ()Lnet/bytebuddy/description/type/TypeDescription;
/*       */             //   15: invokevirtual equals : (Ljava/lang/Object;)Z
/*       */             //   18: ifeq -> 204
/*       */             //   21: aload_0
/*       */             //   22: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */             //   25: invokeinterface getOwnerType : ()Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */             //   30: astore_2
/*       */             //   31: aload_1
/*       */             //   32: invokeinterface getOwnerType : ()Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */             //   37: astore_3
/*       */             //   38: aload_2
/*       */             //   39: ifnull -> 71
/*       */             //   42: aload_3
/*       */             //   43: ifnull -> 71
/*       */             //   46: aload_2
/*       */             //   47: getstatic net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner.INSTANCE : Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner;
/*       */             //   50: invokeinterface accept : (Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor;)Ljava/lang/Object;
/*       */             //   55: checkcast net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher
/*       */             //   58: aload_3
/*       */             //   59: invokeinterface isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */             //   64: ifne -> 71
/*       */             //   67: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*       */             //   70: areturn
/*       */             //   71: aload_0
/*       */             //   72: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */             //   75: invokeinterface getTypeArguments : ()Lnet/bytebuddy/description/type/TypeList$Generic;
/*       */             //   80: astore_2
/*       */             //   81: aload_1
/*       */             //   82: invokeinterface getTypeArguments : ()Lnet/bytebuddy/description/type/TypeList$Generic;
/*       */             //   87: astore_3
/*       */             //   88: aload_2
/*       */             //   89: invokeinterface size : ()I
/*       */             //   94: aload_3
/*       */             //   95: invokeinterface size : ()I
/*       */             //   100: if_icmpne -> 168
/*       */             //   103: iconst_0
/*       */             //   104: istore_1
/*       */             //   105: iload_1
/*       */             //   106: aload_2
/*       */             //   107: invokeinterface size : ()I
/*       */             //   112: if_icmpge -> 164
/*       */             //   115: aload_2
/*       */             //   116: iload_1
/*       */             //   117: invokeinterface get : (I)Ljava/lang/Object;
/*       */             //   122: checkcast net/bytebuddy/description/type/TypeDescription$Generic
/*       */             //   125: getstatic net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner.INSTANCE : Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner;
/*       */             //   128: invokeinterface accept : (Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor;)Ljava/lang/Object;
/*       */             //   133: checkcast net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher
/*       */             //   136: aload_3
/*       */             //   137: iload_1
/*       */             //   138: invokeinterface get : (I)Ljava/lang/Object;
/*       */             //   143: checkcast net/bytebuddy/description/type/TypeDescription$Generic
/*       */             //   146: invokeinterface isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */             //   151: ifne -> 158
/*       */             //   154: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*       */             //   157: areturn
/*       */             //   158: iinc #1, 1
/*       */             //   161: goto -> 105
/*       */             //   164: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*       */             //   167: areturn
/*       */             //   168: new java/lang/IllegalArgumentException
/*       */             //   171: dup
/*       */             //   172: new java/lang/StringBuilder
/*       */             //   175: dup
/*       */             //   176: ldc 'Incompatible generic types: '
/*       */             //   178: invokespecial <init> : (Ljava/lang/String;)V
/*       */             //   181: aload_1
/*       */             //   182: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*       */             //   185: ldc ' and '
/*       */             //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*       */             //   190: aload_0
/*       */             //   191: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */             //   194: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*       */             //   197: invokevirtual toString : ()Ljava/lang/String;
/*       */             //   200: invokespecial <init> : (Ljava/lang/String;)V
/*       */             //   203: athrow
/*       */             //   204: aload_1
/*       */             //   205: invokeinterface getSuperClass : ()Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */             //   210: dup
/*       */             //   211: astore_2
/*       */             //   212: ifnull -> 227
/*       */             //   215: aload_0
/*       */             //   216: aload_2
/*       */             //   217: invokevirtual isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */             //   220: ifeq -> 227
/*       */             //   223: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*       */             //   226: areturn
/*       */             //   227: aload_1
/*       */             //   228: invokeinterface getInterfaces : ()Lnet/bytebuddy/description/type/TypeList$Generic;
/*       */             //   233: invokeinterface iterator : ()Ljava/util/Iterator;
/*       */             //   238: astore_3
/*       */             //   239: aload_3
/*       */             //   240: invokeinterface hasNext : ()Z
/*       */             //   245: ifeq -> 273
/*       */             //   248: aload_3
/*       */             //   249: invokeinterface next : ()Ljava/lang/Object;
/*       */             //   254: checkcast net/bytebuddy/description/type/TypeDescription$Generic
/*       */             //   257: astore_2
/*       */             //   258: aload_0
/*       */             //   259: aload_2
/*       */             //   260: invokevirtual isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */             //   263: ifeq -> 270
/*       */             //   266: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*       */             //   269: areturn
/*       */             //   270: goto -> 239
/*       */             //   273: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*       */             //   276: areturn
/*       */             // Line number table:
/*       */             //   Java source line number -> byte code offset
/*       */             //   #1150	-> 0
/*       */             //   #1151	-> 21
/*       */             //   #1152	-> 38
/*       */             //   #1153	-> 67
/*       */             //   #1155	-> 71
/*       */             //   #1156	-> 88
/*       */             //   #1157	-> 103
/*       */             //   #1158	-> 115
/*       */             //   #1159	-> 154
/*       */             //   #1157	-> 158
/*       */             //   #1162	-> 164
/*       */             //   #1164	-> 168
/*       */             //   #1167	-> 204
/*       */             //   #1168	-> 211
/*       */             //   #1169	-> 223
/*       */             //   #1171	-> 227
/*       */             //   #1172	-> 258
/*       */             //   #1173	-> 266
/*       */             //   #1175	-> 270
/*       */             //   #1176	-> 273
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onTypeVariable(TypeDescription.Generic param4Generic) {
/*  1183 */             for (TypeDescription.Generic generic : param4Generic.getUpperBounds()) {
/*  1184 */               if (isAssignableFrom(generic)) {
/*  1185 */                 return Boolean.TRUE;
/*       */               }
/*       */             } 
/*  1188 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1195 */             if (this.parameterizedType.asErasure().equals(param4Generic.asErasure())) {
/*  1196 */               return Boolean.TRUE;
/*       */             }
/*       */             
/*  1199 */             if ((generic = param4Generic.getSuperClass()) != null && isAssignableFrom(generic)) {
/*  1200 */               return Boolean.TRUE;
/*       */             }
/*  1202 */             for (TypeDescription.Generic generic : param4Generic.getInterfaces()) {
/*  1203 */               if (isAssignableFrom(generic)) {
/*  1204 */                 return Boolean.TRUE;
/*       */               }
/*       */             } 
/*  1207 */             return Boolean.FALSE;
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.parameterizedType.equals(((ForParameterizedType)param4Object).parameterizedType))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.parameterizedType.hashCode();
/*       */           }
/*       */           
/*  1218 */           protected enum ParameterAssigner implements TypeDescription.Generic.Visitor<TypeDescription.Generic.Visitor.Assigner.Dispatcher> { INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onGenericArray(TypeDescription.Generic param6Generic) {
/*  1224 */               return new InvariantBinding(param6Generic);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onWildcard(TypeDescription.Generic param6Generic) {
/*       */               TypeList.Generic generic;
/*  1232 */               return (TypeDescription.Generic.Visitor.Assigner.Dispatcher)((generic = param6Generic.getLowerBounds()).isEmpty() ? new CovariantBinding((TypeDescription.Generic)param6Generic
/*  1233 */                   .getUpperBounds().getOnly()) : new ContravariantBinding((TypeDescription.Generic)generic
/*  1234 */                   .getOnly()));
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onParameterizedType(TypeDescription.Generic param6Generic) {
/*  1241 */               return new InvariantBinding(param6Generic);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onTypeVariable(TypeDescription.Generic param6Generic) {
/*  1248 */               return new InvariantBinding(param6Generic);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onNonGenericType(TypeDescription.Generic param6Generic) {
/*  1255 */               return new InvariantBinding(param6Generic);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             @Enhance
/*       */             protected static class InvariantBinding
/*       */               implements TypeDescription.Generic.Visitor.Assigner.Dispatcher
/*       */             {
/*       */               private final TypeDescription.Generic typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */               
/*       */               protected InvariantBinding(TypeDescription.Generic param7Generic) {
/*  1275 */                 this.typeDescription = param7Generic;
/*       */               }
/*       */ 
/*       */ 
/*       */ 
/*       */               
/*       */               public boolean isAssignableFrom(TypeDescription.Generic param7Generic) {
/*  1282 */                 return param7Generic.equals(this.typeDescription);
/*       */               }
/*       */ 
/*       */               
/*       */               public boolean equals(@MaybeNull Object param7Object) {
/*       */                 return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!!this.typeDescription.equals(((InvariantBinding)param7Object).typeDescription))));
/*       */               }
/*       */ 
/*       */               
/*       */               public int hashCode() {
/*       */                 return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*       */               }
/*       */             }
/*       */             
/*       */             @Enhance
/*       */             protected static class CovariantBinding
/*       */               implements TypeDescription.Generic.Visitor.Assigner.Dispatcher
/*       */             {
/*       */               private final TypeDescription.Generic upperBound;
/*       */               
/*       */               protected CovariantBinding(TypeDescription.Generic param7Generic) {
/*  1303 */                 this.upperBound = param7Generic;
/*       */               }
/*       */ 
/*       */ 
/*       */ 
/*       */               
/*       */               public boolean isAssignableFrom(TypeDescription.Generic param7Generic) {
/*  1310 */                 if (param7Generic.getSort().isWildcard()) {
/*  1311 */                   if (param7Generic.getLowerBounds().isEmpty() && ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.upperBound.<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE))
/*  1312 */                     .isAssignableFrom((TypeDescription.Generic)param7Generic.getUpperBounds().getOnly())) return true;  return false;
/*       */                 } 
/*  1314 */                 return ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.upperBound.<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(param7Generic);
/*       */               }
/*       */ 
/*       */               
/*       */               public boolean equals(@MaybeNull Object param7Object) {
/*       */                 return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!!this.upperBound.equals(((CovariantBinding)param7Object).upperBound))));
/*       */               }
/*       */ 
/*       */               
/*       */               public int hashCode() {
/*       */                 return getClass().hashCode() * 31 + this.upperBound.hashCode();
/*       */               }
/*       */             }
/*       */ 
/*       */             
/*       */             @Enhance
/*       */             protected static class ContravariantBinding
/*       */               implements TypeDescription.Generic.Visitor.Assigner.Dispatcher
/*       */             {
/*       */               private final TypeDescription.Generic lowerBound;
/*       */               
/*       */               protected ContravariantBinding(TypeDescription.Generic param7Generic) {
/*  1336 */                 this.lowerBound = param7Generic;
/*       */               }
/*       */ 
/*       */ 
/*       */               
/*       */               public boolean isAssignableFrom(TypeDescription.Generic param7Generic) {
/*       */                 TypeList.Generic generic;
/*  1343 */                 if (param7Generic.getSort().isWildcard()) {
/*       */                   
/*  1345 */                   if (!(generic = param7Generic.getLowerBounds()).isEmpty() && ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)((TypeDescription.Generic)generic.getOnly()).<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(this.lowerBound)) return true;  return false;
/*       */                 } 
/*  1347 */                 return (generic.getSort().isWildcard() || ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)generic.<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(this.lowerBound));
/*       */               }
/*       */ 
/*       */               
/*       */               public boolean equals(@MaybeNull Object param7Object) {
/*       */                 return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!!this.lowerBound.equals(((ContravariantBinding)param7Object).lowerBound))));
/*       */               }
/*       */ 
/*       */               
/*       */               public int hashCode() {
/*       */                 return getClass().hashCode() * 31 + this.lowerBound.hashCode();
/*       */               }
/*       */             } }
/*       */         
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForGenericArray
/*       */           extends Dispatcher.AbstractBase
/*       */         {
/*       */           private final TypeDescription.Generic genericArray;
/*       */           
/*       */           protected ForGenericArray(TypeDescription.Generic param4Generic) {
/*  1371 */             this.genericArray = param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */           public Boolean onGenericArray(TypeDescription.Generic param4Generic) {
/*  1379 */             return Boolean.valueOf(((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.genericArray.getComponentType().<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(param4Generic.getComponentType()));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onWildcard(TypeDescription.Generic param4Generic) {
/*  1386 */             throw new IllegalArgumentException("A wildcard is not a first-level type: " + param4Generic);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1393 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public Boolean onTypeVariable(TypeDescription.Generic param4Generic) {
/*  1400 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */           public Boolean onNonGenericType(TypeDescription.Generic param4Generic)
/*       */           {
/*  1408 */             return Boolean.valueOf((param4Generic.isArray() && ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.genericArray
/*  1409 */                 .getComponentType().<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(param4Generic.getComponentType()))); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.genericArray.equals(((ForGenericArray)param4Object).genericArray)))); } public int hashCode() { return getClass().hashCode() * 31 + this.genericArray.hashCode(); } } public static interface Dispatcher { boolean isAssignableFrom(TypeDescription.Generic param4Generic); public static abstract class AbstractBase implements TypeDescription.Generic.Visitor<Boolean>, Dispatcher { public boolean isAssignableFrom(TypeDescription.Generic param5Generic) { return ((Boolean)param5Generic.<Boolean>accept(this)).booleanValue(); } } @Enhance public static class ForNonGenericType extends AbstractBase { private final TypeDescription typeDescription; protected ForNonGenericType(TypeDescription param5TypeDescription) { this.typeDescription = param5TypeDescription; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.") public Boolean onGenericArray(TypeDescription.Generic param5Generic) { return Boolean.valueOf(this.typeDescription.isArray() ? ((Boolean)param5Generic.getComponentType().<Boolean>accept(new ForNonGenericType(this.typeDescription.getComponentType()))).booleanValue() : ((this.typeDescription.represents(Object.class) || TypeDescription.ARRAY_INTERFACES.contains(this.typeDescription.asGenericType())))); } public Boolean onWildcard(TypeDescription.Generic param5Generic) { throw new IllegalArgumentException("A wildcard is not a first-level type: " + param5Generic); } public Boolean onParameterizedType(TypeDescription.Generic param5Generic) { if (this.typeDescription.equals(param5Generic.asErasure())) return Boolean.TRUE;  if ((generic = param5Generic.getSuperClass()) != null && isAssignableFrom(generic)) return Boolean.TRUE;  for (TypeDescription.Generic generic : param5Generic.getInterfaces()) { if (isAssignableFrom(generic)) return Boolean.TRUE;  }  return Boolean.valueOf(this.typeDescription.represents(Object.class)); } public Boolean onTypeVariable(TypeDescription.Generic param5Generic) { for (TypeDescription.Generic generic : param5Generic.getUpperBounds()) { if (isAssignableFrom(generic)) return Boolean.TRUE;  }  return Boolean.FALSE; } public Boolean onNonGenericType(TypeDescription.Generic param5Generic) { return Boolean.valueOf(this.typeDescription.isAssignableFrom(param5Generic.asErasure())); } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.typeDescription.equals(((ForNonGenericType)param5Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } @Enhance public static class ForTypeVariable extends AbstractBase { private final TypeDescription.Generic typeVariable; protected ForTypeVariable(TypeDescription.Generic param5Generic) { this.typeVariable = param5Generic; } public Boolean onGenericArray(TypeDescription.Generic param5Generic) { return Boolean.FALSE; } public Boolean onWildcard(TypeDescription.Generic param5Generic) { throw new IllegalArgumentException("A wildcard is not a first-level type: " + param5Generic); } public Boolean onParameterizedType(TypeDescription.Generic param5Generic) { return Boolean.FALSE; } public Boolean onTypeVariable(TypeDescription.Generic param5Generic) { if (param5Generic.equals(this.typeVariable)) return Boolean.TRUE;  for (TypeDescription.Generic generic : param5Generic.getUpperBounds()) { if (isAssignableFrom(generic)) return Boolean.TRUE;  }  return Boolean.FALSE; } public Boolean onNonGenericType(TypeDescription.Generic param5Generic) { return Boolean.FALSE; } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.typeVariable.equals(((ForTypeVariable)param5Object).typeVariable)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeVariable.hashCode(); } } @Enhance public static class ForParameterizedType extends AbstractBase { private final TypeDescription.Generic parameterizedType; protected ForParameterizedType(TypeDescription.Generic param5Generic) { this.parameterizedType = param5Generic; } public Boolean onGenericArray(TypeDescription.Generic param5Generic) { return Boolean.FALSE; } public Boolean onWildcard(TypeDescription.Generic param5Generic) { throw new IllegalArgumentException("A wildcard is not a first-level type: " + param5Generic); } public Boolean onParameterizedType(TypeDescription.Generic param5Generic) { // Byte code:
/*       */               //   0: aload_0
/*       */               //   1: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */               //   4: invokeinterface asErasure : ()Lnet/bytebuddy/description/type/TypeDescription;
/*       */               //   9: aload_1
/*       */               //   10: invokeinterface asErasure : ()Lnet/bytebuddy/description/type/TypeDescription;
/*       */               //   15: invokevirtual equals : (Ljava/lang/Object;)Z
/*       */               //   18: ifeq -> 204
/*       */               //   21: aload_0
/*       */               //   22: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */               //   25: invokeinterface getOwnerType : ()Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */               //   30: astore_2
/*       */               //   31: aload_1
/*       */               //   32: invokeinterface getOwnerType : ()Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */               //   37: astore_3
/*       */               //   38: aload_2
/*       */               //   39: ifnull -> 71
/*       */               //   42: aload_3
/*       */               //   43: ifnull -> 71
/*       */               //   46: aload_2
/*       */               //   47: getstatic net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner.INSTANCE : Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner;
/*       */               //   50: invokeinterface accept : (Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor;)Ljava/lang/Object;
/*       */               //   55: checkcast net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher
/*       */               //   58: aload_3
/*       */               //   59: invokeinterface isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */               //   64: ifne -> 71
/*       */               //   67: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*       */               //   70: areturn
/*       */               //   71: aload_0
/*       */               //   72: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */               //   75: invokeinterface getTypeArguments : ()Lnet/bytebuddy/description/type/TypeList$Generic;
/*       */               //   80: astore_2
/*       */               //   81: aload_1
/*       */               //   82: invokeinterface getTypeArguments : ()Lnet/bytebuddy/description/type/TypeList$Generic;
/*       */               //   87: astore_3
/*       */               //   88: aload_2
/*       */               //   89: invokeinterface size : ()I
/*       */               //   94: aload_3
/*       */               //   95: invokeinterface size : ()I
/*       */               //   100: if_icmpne -> 168
/*       */               //   103: iconst_0
/*       */               //   104: istore_1
/*       */               //   105: iload_1
/*       */               //   106: aload_2
/*       */               //   107: invokeinterface size : ()I
/*       */               //   112: if_icmpge -> 164
/*       */               //   115: aload_2
/*       */               //   116: iload_1
/*       */               //   117: invokeinterface get : (I)Ljava/lang/Object;
/*       */               //   122: checkcast net/bytebuddy/description/type/TypeDescription$Generic
/*       */               //   125: getstatic net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner.INSTANCE : Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner;
/*       */               //   128: invokeinterface accept : (Lnet/bytebuddy/description/type/TypeDescription$Generic$Visitor;)Ljava/lang/Object;
/*       */               //   133: checkcast net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher
/*       */               //   136: aload_3
/*       */               //   137: iload_1
/*       */               //   138: invokeinterface get : (I)Ljava/lang/Object;
/*       */               //   143: checkcast net/bytebuddy/description/type/TypeDescription$Generic
/*       */               //   146: invokeinterface isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */               //   151: ifne -> 158
/*       */               //   154: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*       */               //   157: areturn
/*       */               //   158: iinc #1, 1
/*       */               //   161: goto -> 105
/*       */               //   164: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*       */               //   167: areturn
/*       */               //   168: new java/lang/IllegalArgumentException
/*       */               //   171: dup
/*       */               //   172: new java/lang/StringBuilder
/*       */               //   175: dup
/*       */               //   176: ldc 'Incompatible generic types: '
/*       */               //   178: invokespecial <init> : (Ljava/lang/String;)V
/*       */               //   181: aload_1
/*       */               //   182: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*       */               //   185: ldc ' and '
/*       */               //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*       */               //   190: aload_0
/*       */               //   191: getfield parameterizedType : Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */               //   194: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*       */               //   197: invokevirtual toString : ()Ljava/lang/String;
/*       */               //   200: invokespecial <init> : (Ljava/lang/String;)V
/*       */               //   203: athrow
/*       */               //   204: aload_1
/*       */               //   205: invokeinterface getSuperClass : ()Lnet/bytebuddy/description/type/TypeDescription$Generic;
/*       */               //   210: dup
/*       */               //   211: astore_2
/*       */               //   212: ifnull -> 227
/*       */               //   215: aload_0
/*       */               //   216: aload_2
/*       */               //   217: invokevirtual isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */               //   220: ifeq -> 227
/*       */               //   223: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*       */               //   226: areturn
/*       */               //   227: aload_1
/*       */               //   228: invokeinterface getInterfaces : ()Lnet/bytebuddy/description/type/TypeList$Generic;
/*       */               //   233: invokeinterface iterator : ()Ljava/util/Iterator;
/*       */               //   238: astore_3
/*       */               //   239: aload_3
/*       */               //   240: invokeinterface hasNext : ()Z
/*       */               //   245: ifeq -> 273
/*       */               //   248: aload_3
/*       */               //   249: invokeinterface next : ()Ljava/lang/Object;
/*       */               //   254: checkcast net/bytebuddy/description/type/TypeDescription$Generic
/*       */               //   257: astore_2
/*       */               //   258: aload_0
/*       */               //   259: aload_2
/*       */               //   260: invokevirtual isAssignableFrom : (Lnet/bytebuddy/description/type/TypeDescription$Generic;)Z
/*       */               //   263: ifeq -> 270
/*       */               //   266: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*       */               //   269: areturn
/*       */               //   270: goto -> 239
/*       */               //   273: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*       */               //   276: areturn
/*       */               // Line number table:
/*       */               //   Java source line number -> byte code offset
/*       */               //   #1150	-> 0
/*       */               //   #1151	-> 21
/*       */               //   #1152	-> 38
/*       */               //   #1153	-> 67
/*       */               //   #1155	-> 71
/*       */               //   #1156	-> 88
/*       */               //   #1157	-> 103
/*       */               //   #1158	-> 115
/*       */               //   #1159	-> 154
/*       */               //   #1157	-> 158
/*       */               //   #1162	-> 164
/*       */               //   #1164	-> 168
/*       */               //   #1167	-> 204
/*       */               //   #1168	-> 211
/*       */               //   #1169	-> 223
/*       */               //   #1171	-> 227
/*       */               //   #1172	-> 258
/*       */               //   #1173	-> 266
/*       */               //   #1175	-> 270
/*  1409 */               //   #1176	-> 273 } public Boolean onTypeVariable(TypeDescription.Generic param5Generic) { for (TypeDescription.Generic generic : param5Generic.getUpperBounds()) { if (isAssignableFrom(generic)) return Boolean.TRUE;  }  return Boolean.FALSE; } public Boolean onNonGenericType(TypeDescription.Generic param5Generic) { if (this.parameterizedType.asErasure().equals(param5Generic.asErasure())) return Boolean.TRUE;  if ((generic = param5Generic.getSuperClass()) != null && isAssignableFrom(generic)) return Boolean.TRUE;  for (TypeDescription.Generic generic : param5Generic.getInterfaces()) { if (isAssignableFrom(generic)) return Boolean.TRUE;  }  return Boolean.FALSE; } public boolean equals(@MaybeNull Object param5Object) { return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.parameterizedType.equals(((ForParameterizedType)param5Object).parameterizedType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.parameterizedType.hashCode(); } protected enum ParameterAssigner implements TypeDescription.Generic.Visitor<TypeDescription.Generic.Visitor.Assigner.Dispatcher> { INSTANCE; public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onGenericArray(TypeDescription.Generic param6Generic) { return new InvariantBinding(param6Generic); } public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onWildcard(TypeDescription.Generic param6Generic) { TypeList.Generic generic; return (TypeDescription.Generic.Visitor.Assigner.Dispatcher)((generic = param6Generic.getLowerBounds()).isEmpty() ? new CovariantBinding((TypeDescription.Generic)param6Generic.getUpperBounds().getOnly()) : new ContravariantBinding((TypeDescription.Generic)generic.getOnly())); } public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onParameterizedType(TypeDescription.Generic param6Generic) { return new InvariantBinding(param6Generic); } public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onTypeVariable(TypeDescription.Generic param6Generic) { return new InvariantBinding(param6Generic); } public final TypeDescription.Generic.Visitor.Assigner.Dispatcher onNonGenericType(TypeDescription.Generic param6Generic) { return new InvariantBinding(param6Generic); } @Enhance protected static class InvariantBinding implements TypeDescription.Generic.Visitor.Assigner.Dispatcher { private final TypeDescription.Generic typeDescription; protected InvariantBinding(TypeDescription.Generic param7Generic) { this.typeDescription = param7Generic; } public boolean isAssignableFrom(TypeDescription.Generic param7Generic) { return param7Generic.equals(this.typeDescription); } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!!this.typeDescription.equals(((InvariantBinding)param7Object).typeDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.typeDescription.hashCode(); } } @Enhance protected static class CovariantBinding implements TypeDescription.Generic.Visitor.Assigner.Dispatcher { private final TypeDescription.Generic upperBound; protected CovariantBinding(TypeDescription.Generic param7Generic) { this.upperBound = param7Generic; } public boolean isAssignableFrom(TypeDescription.Generic param7Generic) { if (param7Generic.getSort().isWildcard()) { if (param7Generic.getLowerBounds().isEmpty() && ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.upperBound.<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom((TypeDescription.Generic)param7Generic.getUpperBounds().getOnly())) return true;  return false; }  return ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.upperBound.<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(param7Generic); } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!!this.upperBound.equals(((CovariantBinding)param7Object).upperBound)))); } public int hashCode() { return getClass().hashCode() * 31 + this.upperBound.hashCode(); } } @Enhance protected static class ContravariantBinding implements TypeDescription.Generic.Visitor.Assigner.Dispatcher { private final TypeDescription.Generic lowerBound; protected ContravariantBinding(TypeDescription.Generic param7Generic) { this.lowerBound = param7Generic; } public boolean isAssignableFrom(TypeDescription.Generic param7Generic) { TypeList.Generic generic; if (param7Generic.getSort().isWildcard()) { if (!(generic = param7Generic.getLowerBounds()).isEmpty() && ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)((TypeDescription.Generic)generic.getOnly()).<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(this.lowerBound)) return true;  return false; }  return (generic.getSort().isWildcard() || ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)generic.<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(this.lowerBound)); } public boolean equals(@MaybeNull Object param7Object) { return (this == param7Object) ? true : ((param7Object == null) ? false : ((getClass() != param7Object.getClass()) ? false : (!!this.lowerBound.equals(((ContravariantBinding)param7Object).lowerBound)))); } public int hashCode() { return getClass().hashCode() * 31 + this.lowerBound.hashCode(); } } } } @Enhance public static class ForGenericArray extends AbstractBase { private final TypeDescription.Generic genericArray; protected ForGenericArray(TypeDescription.Generic param5Generic) { this.genericArray = param5Generic; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.") public Boolean onGenericArray(TypeDescription.Generic param5Generic) { return Boolean.valueOf(((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.genericArray.getComponentType().<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(param5Generic.getComponentType())); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.") public Boolean onNonGenericType(TypeDescription.Generic param5Generic) { return Boolean.valueOf((param5Generic.isArray() && ((TypeDescription.Generic.Visitor.Assigner.Dispatcher)this.genericArray.getComponentType().<TypeDescription.Generic.Visitor.Assigner.Dispatcher>accept(TypeDescription.Generic.Visitor.Assigner.INSTANCE)).isAssignableFrom(param5Generic.getComponentType()))); }
/*       */              public Boolean onWildcard(TypeDescription.Generic param5Generic) {
/*       */               throw new IllegalArgumentException("A wildcard is not a first-level type: " + param5Generic);
/*       */             } public Boolean onParameterizedType(TypeDescription.Generic param5Generic) {
/*       */               return Boolean.FALSE;
/*       */             } public Boolean onTypeVariable(TypeDescription.Generic param5Generic) {
/*       */               return Boolean.FALSE;
/*       */             }
/*       */             public boolean equals(@MaybeNull Object param5Object) {
/*       */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.genericArray.equals(((ForGenericArray)param5Object).genericArray))));
/*       */             }
/*       */             public int hashCode() {
/*       */               return getClass().hashCode() * 31 + this.genericArray.hashCode();
/*       */             } } } }
/*  1423 */       public enum Validator implements Visitor<Boolean> { SUPER_CLASS(false, false, false, false)
/*       */         {
/*       */           public final Boolean onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1426 */             return Boolean.valueOf((super.onNonGenericType(param4Generic).booleanValue() && !param4Generic.isInterface()));
/*       */           }
/*       */ 
/*       */           
/*       */           public final Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1431 */             return Boolean.valueOf(!param4Generic.isInterface());
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1438 */         INTERFACE(false, false, false, false)
/*       */         {
/*       */           public final Boolean onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1441 */             return Boolean.valueOf((super.onNonGenericType(param4Generic).booleanValue() && param4Generic.isInterface()));
/*       */           }
/*       */ 
/*       */           
/*       */           public final Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1446 */             return Boolean.valueOf(param4Generic.isInterface());
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1453 */         TYPE_VARIABLE(false, false, true, false),
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1458 */         FIELD(true, true, true, false),
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1463 */         METHOD_RETURN(true, true, true, true),
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1468 */         METHOD_PARAMETER(true, true, true, false),
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1473 */         EXCEPTION(false, false, true, false)
/*       */         {
/*       */           public final Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1476 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */           
/*       */           public final Boolean onTypeVariable(TypeDescription.Generic param4Generic) {
/*  1481 */             for (Iterator<TypeDescription.Generic> iterator = param4Generic.getUpperBounds().iterator(); iterator.hasNext();) {
/*  1482 */               if (((Boolean)(generic = iterator.next()).<Boolean>accept(this)).booleanValue()) {
/*  1483 */                 return Boolean.TRUE;
/*       */               }
/*       */             } 
/*  1486 */             return Boolean.FALSE;
/*       */           }
/*       */ 
/*       */           
/*       */           public final Boolean onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1491 */             return Boolean.valueOf(param4Generic.asErasure().isAssignableTo(Throwable.class));
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1498 */         RECEIVER(false, false, false, false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean acceptsArray;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean acceptsPrimitive;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean acceptsVariable;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final boolean acceptsVoid;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         Validator(boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) {
/*  1529 */           this.acceptsArray = param3Boolean1;
/*  1530 */           this.acceptsPrimitive = param3Boolean2;
/*  1531 */           this.acceptsVariable = param3Boolean3;
/*  1532 */           this.acceptsVoid = param3Boolean4;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Boolean onGenericArray(TypeDescription.Generic param3Generic) {
/*  1539 */           return Boolean.valueOf(this.acceptsArray);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Boolean onWildcard(TypeDescription.Generic param3Generic) {
/*  1546 */           return Boolean.FALSE;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Boolean onParameterizedType(TypeDescription.Generic param3Generic) {
/*  1553 */           return Boolean.TRUE;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Boolean onTypeVariable(TypeDescription.Generic param3Generic) {
/*  1560 */           return Boolean.valueOf(this.acceptsVariable);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Boolean onNonGenericType(TypeDescription.Generic param3Generic) {
/*  1567 */           return Boolean.valueOf(((this.acceptsArray || !param3Generic.isArray()) && (this.acceptsPrimitive || 
/*  1568 */               !param3Generic.isPrimitive()) && (this.acceptsVoid || 
/*  1569 */               !param3Generic.represents(void.class))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public enum ForTypeAnnotations
/*       */           implements TypeDescription.Generic.Visitor<Boolean>
/*       */         {
/*  1580 */           INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final String TYPE_PARAMETER = "TYPE_PARAMETER";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private static final String TYPE_USE = "TYPE_USE";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public static boolean ofFormalTypeVariable(TypeDescription.Generic param4Generic) {
/*  1599 */             HashSet<TypeDescription> hashSet = new HashSet();
/*  1600 */             for (Iterator<AnnotationDescription> iterator = param4Generic.getDeclaredAnnotations().iterator(); iterator.hasNext();) {
/*  1601 */               if (!(annotationDescription = iterator.next()).isSupportedOn("TYPE_PARAMETER") || !hashSet.add(annotationDescription.getAnnotationType())) {
/*  1602 */                 return false;
/*       */               }
/*       */             } 
/*  1605 */             return true;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */           public final Boolean onGenericArray(TypeDescription.Generic param4Generic) {
/*  1613 */             return Boolean.valueOf((isValid(param4Generic) && ((Boolean)param4Generic.getComponentType().<Boolean>accept(this)).booleanValue()));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Boolean onWildcard(TypeDescription.Generic param4Generic) {
/*  1620 */             if (!isValid(param4Generic))
/*  1621 */               return Boolean.FALSE; 
/*       */             TypeList.Generic generic;
/*  1623 */             return ((TypeDescription.Generic)(
/*  1624 */               (generic = param4Generic.getLowerBounds()).isEmpty() ? param4Generic
/*  1625 */               .getUpperBounds() : generic)
/*  1626 */               .getOnly()).<Boolean>accept(this);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Boolean onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1633 */             if (!isValid(param4Generic)) {
/*  1634 */               return Boolean.FALSE;
/*       */             }
/*       */             TypeDescription.Generic generic;
/*  1637 */             if ((generic = param4Generic.getOwnerType()) != null && !((Boolean)generic.<Boolean>accept(this)).booleanValue()) {
/*  1638 */               return Boolean.FALSE;
/*       */             }
/*  1640 */             for (Iterator<TypeDescription.Generic> iterator = param4Generic.getTypeArguments().iterator(); iterator.hasNext();) {
/*  1641 */               if (!((Boolean)(generic = iterator.next()).<Boolean>accept(this)).booleanValue()) {
/*  1642 */                 return Boolean.FALSE;
/*       */               }
/*       */             } 
/*  1645 */             return Boolean.TRUE;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public final Boolean onTypeVariable(TypeDescription.Generic param4Generic) {
/*  1652 */             return Boolean.valueOf(isValid(param4Generic));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */           public final Boolean onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1660 */             return Boolean.valueOf((isValid(param4Generic) && (!param4Generic.isArray() || ((Boolean)param4Generic.getComponentType().<Boolean>accept(this)).booleanValue())));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private boolean isValid(TypeDescription.Generic param4Generic) {
/*  1670 */             HashSet<TypeDescription> hashSet = new HashSet();
/*  1671 */             for (Iterator<AnnotationDescription> iterator = param4Generic.getDeclaredAnnotations().iterator(); iterator.hasNext();) {
/*  1672 */               if (!(annotationDescription = iterator.next()).isSupportedOn("TYPE_USE") || !hashSet.add(annotationDescription.getAnnotationType())) {
/*  1673 */                 return false;
/*       */               }
/*       */             } 
/*  1676 */             return true;
/*       */           }
/*       */         } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum Reifying
/*       */         implements Visitor<TypeDescription.Generic>
/*       */       {
/*  1690 */         INITIATING
/*       */         {
/*       */           public final TypeDescription.Generic onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1693 */             return param4Generic;
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  1701 */         INHERITING
/*       */         {
/*       */           public final TypeDescription.Generic onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1704 */             return new TypeDescription.Generic.OfParameterizedType.ForReifiedType(param4Generic);
/*       */           }
/*       */         };
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onGenericArray(TypeDescription.Generic param3Generic) {
/*  1712 */           throw new IllegalArgumentException("Cannot reify a generic array: " + param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onWildcard(TypeDescription.Generic param3Generic) {
/*  1719 */           throw new IllegalArgumentException("Cannot reify a wildcard: " + param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param3Generic) {
/*  1726 */           throw new IllegalArgumentException("Cannot reify a type variable: " + param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onNonGenericType(TypeDescription.Generic param3Generic) {
/*       */           TypeDescription typeDescription;
/*  1734 */           return (typeDescription = param3Generic.asErasure()).isGenerified() ? new TypeDescription.Generic.OfNonGenericType.ForReifiedErasure(typeDescription) : param3Generic;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForSignatureVisitor
/*       */         implements Visitor<SignatureVisitor>
/*       */       {
/*       */         private static final int ONLY_CHARACTER = 0;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected final SignatureVisitor signatureVisitor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForSignatureVisitor(SignatureVisitor param3SignatureVisitor) {
/*  1762 */           this.signatureVisitor = param3SignatureVisitor;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public SignatureVisitor onGenericArray(TypeDescription.Generic param3Generic) {
/*  1770 */           param3Generic.getComponentType().accept(new ForSignatureVisitor(this.signatureVisitor.visitArrayType()));
/*  1771 */           return this.signatureVisitor;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public SignatureVisitor onWildcard(TypeDescription.Generic param3Generic) {
/*  1778 */           throw new IllegalStateException("Unexpected wildcard: " + param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public SignatureVisitor onParameterizedType(TypeDescription.Generic param3Generic) {
/*  1785 */           onOwnableType(param3Generic);
/*  1786 */           this.signatureVisitor.visitEnd();
/*  1787 */           return this.signatureVisitor;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private void onOwnableType(TypeDescription.Generic param3Generic) {
/*       */           TypeDescription.Generic generic;
/*  1797 */           if ((generic = param3Generic.getOwnerType()) != null && generic.getSort().isParameterized()) {
/*  1798 */             onOwnableType(generic);
/*  1799 */             this.signatureVisitor.visitInnerClassType(param3Generic.asErasure().getSimpleName());
/*       */           } else {
/*  1801 */             this.signatureVisitor.visitClassType(param3Generic.asErasure().getInternalName());
/*       */           } 
/*  1803 */           for (Iterator<TypeDescription.Generic> iterator = param3Generic.getTypeArguments().iterator(); iterator.hasNext();) {
/*  1804 */             (generic = iterator.next()).accept(new OfTypeArgument(this.signatureVisitor));
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public SignatureVisitor onTypeVariable(TypeDescription.Generic param3Generic) {
/*  1812 */           this.signatureVisitor.visitTypeVariable(param3Generic.getSymbol());
/*  1813 */           return this.signatureVisitor;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public SignatureVisitor onNonGenericType(TypeDescription.Generic param3Generic) {
/*  1821 */           if (param3Generic.isArray()) {
/*  1822 */             param3Generic.getComponentType().accept(new ForSignatureVisitor(this.signatureVisitor.visitArrayType()));
/*  1823 */           } else if (param3Generic.isPrimitive()) {
/*  1824 */             this.signatureVisitor.visitBaseType(param3Generic.asErasure().getDescriptor().charAt(0));
/*       */           } else {
/*  1826 */             this.signatureVisitor.visitClassType(param3Generic.asErasure().getInternalName());
/*  1827 */             this.signatureVisitor.visitEnd();
/*       */           } 
/*  1829 */           return this.signatureVisitor;
/*       */         }
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.signatureVisitor.equals(((ForSignatureVisitor)param3Object).signatureVisitor))));
/*       */         }
/*       */         
/*       */         public int hashCode() {
/*       */           return getClass().hashCode() * 31 + this.signatureVisitor.hashCode();
/*       */         }
/*       */         
/*       */         protected static class OfTypeArgument
/*       */           extends ForSignatureVisitor {
/*       */           protected OfTypeArgument(SignatureVisitor param4SignatureVisitor) {
/*  1843 */             super(param4SignatureVisitor);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public SignatureVisitor onWildcard(TypeDescription.Generic param4Generic) {
/*  1850 */             TypeList.Generic generic2 = param4Generic.getUpperBounds(); TypeList.Generic generic1;
/*  1851 */             if ((generic1 = param4Generic.getLowerBounds()).isEmpty() && ((TypeDescription.Generic)generic2.getOnly()).represents(Object.class)) {
/*  1852 */               this.signatureVisitor.visitTypeArgument();
/*  1853 */             } else if (!generic1.isEmpty()) {
/*  1854 */               ((TypeDescription.Generic)generic1.getOnly()).accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('-')));
/*       */             } else {
/*  1856 */               ((TypeDescription.Generic)generic2.getOnly()).accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('+')));
/*       */             } 
/*  1858 */             return this.signatureVisitor;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public SignatureVisitor onGenericArray(TypeDescription.Generic param4Generic) {
/*  1865 */             param4Generic.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
/*  1866 */             return this.signatureVisitor;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public SignatureVisitor onParameterizedType(TypeDescription.Generic param4Generic) {
/*  1873 */             param4Generic.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
/*  1874 */             return this.signatureVisitor;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public SignatureVisitor onTypeVariable(TypeDescription.Generic param4Generic) {
/*  1881 */             param4Generic.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
/*  1882 */             return this.signatureVisitor;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public SignatureVisitor onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1889 */             param4Generic.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
/*  1890 */             return this.signatureVisitor;
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static abstract class Substitutor
/*       */         implements Visitor<TypeDescription.Generic>
/*       */       {
/*       */         public TypeDescription.Generic onParameterizedType(TypeDescription.Generic param3Generic) {
/*  1905 */           TypeDescription.Generic generic = param3Generic.getOwnerType();
/*  1906 */           ArrayList<? extends TypeDescription.Generic> arrayList = new ArrayList(param3Generic.getTypeArguments().size());
/*  1907 */           for (TypeDescription.Generic generic1 : param3Generic.getTypeArguments()) {
/*  1908 */             arrayList.add(generic1.accept(this));
/*       */           }
/*  1910 */           return new TypeDescription.Generic.OfParameterizedType.Latent(((TypeDescription.Generic)param3Generic.asRawType().<TypeDescription.Generic>accept(this)).asErasure(), (generic == null) ? TypeDescription.Generic.UNDEFINED : generic
/*       */ 
/*       */               
/*  1913 */               .<TypeDescription.Generic>accept(this), arrayList, param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public TypeDescription.Generic onGenericArray(TypeDescription.Generic param3Generic) {
/*  1923 */           return new TypeDescription.Generic.OfGenericArray.Latent(param3Generic.getComponentType().<TypeDescription.Generic>accept(this), param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onWildcard(TypeDescription.Generic param3Generic) {
/*  1930 */           return new TypeDescription.Generic.OfWildcardType.Latent((List<? extends TypeDescription.Generic>)param3Generic.getUpperBounds().accept(this), (List<? extends TypeDescription.Generic>)param3Generic.getLowerBounds().accept(this), param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public TypeDescription.Generic onNonGenericType(TypeDescription.Generic param3Generic) {
/*  1938 */           return param3Generic.isArray() ? new TypeDescription.Generic.OfGenericArray.Latent(param3Generic
/*  1939 */               .getComponentType().<TypeDescription.Generic>accept(this), param3Generic) : 
/*  1940 */             onSimpleType(param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract TypeDescription.Generic onSimpleType(TypeDescription.Generic param3Generic);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static abstract class WithoutTypeSubstitution
/*       */           extends Substitutor
/*       */         {
/*       */           public TypeDescription.Generic onNonGenericType(TypeDescription.Generic param4Generic) {
/*  1960 */             return param4Generic;
/*       */           }
/*       */ 
/*       */           
/*       */           protected TypeDescription.Generic onSimpleType(TypeDescription.Generic param4Generic) {
/*  1965 */             return param4Generic;
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForAttachment
/*       */           extends Substitutor
/*       */         {
/*       */           private final TypeDescription declaringType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeVariableSource typeVariableSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ForAttachment(TypeDefinition param4TypeDefinition, TypeVariableSource param4TypeVariableSource) {
/*  1993 */             this(param4TypeDefinition.asErasure(), param4TypeVariableSource);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ForAttachment(TypeDescription param4TypeDescription, TypeVariableSource param4TypeVariableSource) {
/*  2003 */             this.declaringType = param4TypeDescription;
/*  2004 */             this.typeVariableSource = param4TypeVariableSource;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public static ForAttachment of(TypeDescription param4TypeDescription) {
/*  2014 */             return new ForAttachment(param4TypeDescription, param4TypeDescription);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*       */           public static ForAttachment of(FieldDescription param4FieldDescription) {
/*  2025 */             return new ForAttachment(param4FieldDescription.getDeclaringType(), param4FieldDescription.getDeclaringType().asErasure());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public static ForAttachment of(MethodDescription param4MethodDescription) {
/*  2035 */             return new ForAttachment(param4MethodDescription.getDeclaringType(), (TypeVariableSource)param4MethodDescription);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public static ForAttachment of(ParameterDescription param4ParameterDescription) {
/*  2045 */             return new ForAttachment(param4ParameterDescription.getDeclaringMethod().getDeclaringType(), (TypeVariableSource)param4ParameterDescription.getDeclaringMethod());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public static ForAttachment of(RecordComponentDescription param4RecordComponentDescription) {
/*  2055 */             return new ForAttachment(param4RecordComponentDescription.getDeclaringType(), param4RecordComponentDescription.getDeclaringType().asErasure());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param4Generic) {
/*  2062 */             return new TypeDescription.Generic.OfTypeVariable.WithAnnotationOverlay(this.typeVariableSource.findExpectedVariable(param4Generic.getSymbol()), param4Generic);
/*       */           }
/*       */ 
/*       */           
/*       */           protected TypeDescription.Generic onSimpleType(TypeDescription.Generic param4Generic) {
/*  2067 */             return param4Generic.represents(TargetType.class) ? new TypeDescription.Generic.OfNonGenericType.Latent(this.declaringType, param4Generic) : param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.declaringType.equals(((ForAttachment)param4Object).declaringType) ? false : (!!this.typeVariableSource.equals(((ForAttachment)param4Object).typeVariableSource)))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (getClass().hashCode() * 31 + this.declaringType.hashCode()) * 31 + this.typeVariableSource.hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForDetachment
/*       */           extends Substitutor
/*       */         {
/*       */           private final ElementMatcher<? super TypeDescription> typeMatcher;
/*       */ 
/*       */           
/*       */           public ForDetachment(ElementMatcher<? super TypeDescription> param4ElementMatcher) {
/*  2092 */             this.typeMatcher = param4ElementMatcher;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public static TypeDescription.Generic.Visitor<TypeDescription.Generic> of(TypeDefinition param4TypeDefinition) {
/*  2102 */             return new ForDetachment((ElementMatcher<? super TypeDescription>)ElementMatchers.is(param4TypeDefinition));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param4Generic) {
/*  2109 */             return new TypeDescription.Generic.OfTypeVariable.Symbolic(param4Generic.getSymbol(), param4Generic);
/*       */           }
/*       */ 
/*       */           
/*       */           protected TypeDescription.Generic onSimpleType(TypeDescription.Generic param4Generic) {
/*  2114 */             return this.typeMatcher.matches(param4Generic.asErasure()) ? new TypeDescription.Generic.OfNonGenericType.Latent(TargetType.DESCRIPTION, param4Generic
/*  2115 */                 .getOwnerType(), param4Generic) : param4Generic;
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeMatcher.equals(((ForDetachment)param4Object).typeMatcher))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.typeMatcher.hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForTypeVariableBinding
/*       */           extends WithoutTypeSubstitution
/*       */         {
/*       */           private final TypeDescription.Generic parameterizedType;
/*       */           
/*       */           protected ForTypeVariableBinding(TypeDescription.Generic param4Generic) {
/*  2137 */             this.parameterizedType = param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param4Generic) {
/*  2144 */             return (TypeDescription.Generic)param4Generic.getTypeVariableSource().accept(new TypeVariableSubstitutor(this, param4Generic));
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.parameterizedType.equals(((ForTypeVariableBinding)param4Object).parameterizedType))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.parameterizedType.hashCode();
/*       */           }
/*       */ 
/*       */           
/*       */           @Enhance(includeSyntheticFields = true)
/*       */           protected class TypeVariableSubstitutor
/*       */             implements TypeVariableSource.Visitor<TypeDescription.Generic>
/*       */           {
/*       */             private final TypeDescription.Generic typeVariable;
/*       */             
/*       */             protected TypeVariableSubstitutor(TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding this$0, TypeDescription.Generic param5Generic) {
/*  2165 */               this.typeVariable = param5Generic;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDescription.Generic onType(TypeDescription param5TypeDescription) {
/*       */               TypeDescription.Generic generic;
/*  2174 */               if ((generic = TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding.a(this.a).findBindingOf(this.typeVariable)) == null)
/*  2175 */                 return this.typeVariable.asRawType();  return generic;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeDescription.Generic onMethod(MethodDescription.InDefinedShape param5InDefinedShape) {
/*  2183 */               return new TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding.RetainedMethodTypeVariable(this.a, this.typeVariable);
/*       */             }
/*       */ 
/*       */             
/*       */             public boolean equals(@MaybeNull Object param5Object) {
/*       */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.typeVariable.equals(((TypeVariableSubstitutor)param5Object).typeVariable) ? false : (!!this.a.equals(((TypeVariableSubstitutor)param5Object).a)))));
/*       */             }
/*       */ 
/*       */             
/*       */             public int hashCode() {
/*       */               return (getClass().hashCode() * 31 + this.typeVariable.hashCode()) * 31 + this.a.hashCode();
/*       */             }
/*       */           }
/*       */           
/*       */           protected class RetainedMethodTypeVariable
/*       */             extends TypeDescription.Generic.OfTypeVariable
/*       */           {
/*       */             private final TypeDescription.Generic typeVariable;
/*       */             
/*       */             protected RetainedMethodTypeVariable(TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding this$0, TypeDescription.Generic param5Generic) {
/*  2203 */               this.typeVariable = param5Generic;
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeList.Generic getUpperBounds() {
/*  2210 */               return this.typeVariable.getUpperBounds().accept(this.a);
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public TypeVariableSource getTypeVariableSource() {
/*  2217 */               return this.typeVariable.getTypeVariableSource();
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public String getSymbol() {
/*  2224 */               return this.typeVariable.getSymbol();
/*       */             }
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*       */             public AnnotationList getDeclaredAnnotations() {
/*  2231 */               return this.typeVariable.getDeclaredAnnotations();
/*       */             }
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForTokenNormalization
/*       */           extends Substitutor
/*       */         {
/*       */           private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ForTokenNormalization(TypeDescription param4TypeDescription) {
/*  2253 */             this.typeDescription = param4TypeDescription;
/*       */           }
/*       */ 
/*       */           
/*       */           protected TypeDescription.Generic onSimpleType(TypeDescription.Generic param4Generic) {
/*  2258 */             return param4Generic.represents(TargetType.class) ? new TypeDescription.Generic.OfNonGenericType.Latent(this.typeDescription, param4Generic) : param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param4Generic) {
/*  2267 */             return new TypeDescription.Generic.OfTypeVariable.Symbolic(param4Generic.getSymbol(), param4Generic);
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((ForTokenNormalization)param4Object).typeDescription))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*       */           }
/*       */         }
/*       */         
/*       */         @Enhance
/*       */         public static class ForReplacement
/*       */           extends Substitutor
/*       */         {
/*       */           private final TypeDescription typeDescription;
/*       */           
/*       */           public ForReplacement(TypeDescription param4TypeDescription) {
/*  2288 */             this.typeDescription = param4TypeDescription;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param4Generic) {
/*  2295 */             return param4Generic;
/*       */           }
/*       */ 
/*       */           
/*       */           protected TypeDescription.Generic onSimpleType(TypeDescription.Generic param4Generic) {
/*  2300 */             return param4Generic.asErasure().equals(this.typeDescription) ? new TypeDescription.Generic.OfNonGenericType.Latent(this.typeDescription, param4Generic) : param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeDescription.equals(((ForReplacement)param4Object).typeDescription))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       public static class ForRawType
/*       */         implements Visitor<TypeDescription.Generic>
/*       */       {
/*       */         private final TypeDescription declaringType;
/*       */ 
/*       */         
/*       */         public ForRawType(TypeDescription param3TypeDescription) {
/*  2324 */           this.declaringType = param3TypeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onGenericArray(TypeDescription.Generic param3Generic) {
/*  2331 */           return this.declaringType.isGenerified() ? new TypeDescription.Generic.OfNonGenericType.Latent(param3Generic
/*  2332 */               .asErasure(), param3Generic) : param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onWildcard(TypeDescription.Generic param3Generic) {
/*  2340 */           throw new IllegalStateException("Did not expect wildcard on top-level: " + param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onParameterizedType(TypeDescription.Generic param3Generic) {
/*  2347 */           return this.declaringType.isGenerified() ? new TypeDescription.Generic.OfNonGenericType.Latent(param3Generic
/*  2348 */               .asErasure(), param3Generic) : param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onTypeVariable(TypeDescription.Generic param3Generic) {
/*  2356 */           return this.declaringType.isGenerified() ? new TypeDescription.Generic.OfNonGenericType.Latent(param3Generic
/*  2357 */               .asErasure(), param3Generic) : param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic onNonGenericType(TypeDescription.Generic param3Generic) {
/*  2365 */           return param3Generic;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class Reducing
/*       */         implements Visitor<TypeDescription>
/*       */       {
/*       */         private final TypeDescription declaringType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final List<? extends TypeVariableToken> typeVariableTokens;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Reducing(TypeDescription param3TypeDescription, TypeVariableToken... param3VarArgs) {
/*  2392 */           this(param3TypeDescription, Arrays.asList(param3VarArgs));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Reducing(TypeDescription param3TypeDescription, List<? extends TypeVariableToken> param3List) {
/*  2402 */           this.declaringType = param3TypeDescription;
/*  2403 */           this.typeVariableTokens = param3List;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public TypeDescription onGenericArray(TypeDescription.Generic param3Generic) {
/*  2411 */           TypeDescription.Generic generic = param3Generic;
/*  2412 */           byte b = 0;
/*       */           while (true) {
/*  2414 */             generic = generic.getComponentType();
/*  2415 */             b++;
/*  2416 */             if (!generic.isArray()) {
/*  2417 */               if (generic.getSort().isTypeVariable()) {
/*  2418 */                 for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
/*  2419 */                   if (generic.getSymbol().equals(typeVariableToken.getSymbol())) {
/*  2420 */                     return TypeDescription.ArrayProjection.of(((TypeDescription.Generic)typeVariableToken.getBounds().get(0)).<TypeDescription>accept(this), b);
/*       */                   }
/*       */                 } 
/*  2423 */                 return TargetType.resolve(TypeDescription.ArrayProjection.of(this.declaringType
/*  2424 */                       .findExpectedVariable(generic.getSymbol()).asErasure(), b), this.declaringType);
/*       */               } 
/*       */               
/*  2427 */               return TargetType.resolve(param3Generic.asErasure(), this.declaringType);
/*       */             } 
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription onWildcard(TypeDescription.Generic param3Generic) {
/*  2435 */           throw new IllegalStateException("A wildcard cannot be a top-level type: " + param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription onParameterizedType(TypeDescription.Generic param3Generic) {
/*  2442 */           return TargetType.resolve(param3Generic.asErasure(), this.declaringType);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription onTypeVariable(TypeDescription.Generic param3Generic) {
/*  2449 */           for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
/*  2450 */             if (param3Generic.getSymbol().equals(typeVariableToken.getSymbol())) {
/*  2451 */               return ((TypeDescription.Generic)typeVariableToken.getBounds().get(0)).<TypeDescription>accept(this);
/*       */             }
/*       */           } 
/*  2454 */           return TargetType.resolve(this.declaringType.findExpectedVariable(param3Generic.getSymbol()).asErasure(), this.declaringType);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription onNonGenericType(TypeDescription.Generic param3Generic) {
/*  2461 */           return TargetType.resolve(param3Generic.asErasure(), this.declaringType);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.declaringType.equals(((Reducing)param3Object).declaringType) ? false : (!!this.typeVariableTokens.equals(((Reducing)param3Object).typeVariableTokens)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return (getClass().hashCode() * 31 + this.declaringType.hashCode()) * 31 + this.typeVariableTokens.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static interface AnnotationReader
/*       */     {
/*       */       AnnotatedElement resolve();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationList asList();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationReader ofWildcardUpperBoundType(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationReader ofWildcardLowerBoundType(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationReader ofTypeVariableBoundType(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationReader ofTypeArgument(int param2Int);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationReader ofOwnerType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationReader ofOuterClass();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       AnnotationReader ofComponentType();
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public enum NoOp
/*       */         implements AnnotatedElement, AnnotationReader
/*       */       {
/*  2557 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final AnnotatedElement resolve() {
/*  2563 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final AnnotationList asList() {
/*  2570 */           return (AnnotationList)new AnnotationList.Empty();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.AnnotationReader ofWildcardUpperBoundType(int param3Int) {
/*  2577 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.AnnotationReader ofWildcardLowerBoundType(int param3Int) {
/*  2584 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.AnnotationReader ofTypeVariableBoundType(int param3Int) {
/*  2591 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.AnnotationReader ofTypeArgument(int param3Int) {
/*  2598 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.AnnotationReader ofOwnerType() {
/*  2605 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.AnnotationReader ofOuterClass() {
/*  2612 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.AnnotationReader ofComponentType() {
/*  2619 */           return this;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final boolean isAnnotationPresent(Class<? extends Annotation> param3Class) {
/*  2626 */           throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final <T extends Annotation> T getAnnotation(Class<T> param3Class) {
/*  2633 */           throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Annotation[] getAnnotations() {
/*  2640 */           throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final Annotation[] getDeclaredAnnotations() {
/*  2647 */           return new Annotation[0];
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static abstract class Delegator
/*       */         implements AnnotationReader
/*       */       {
/*       */         private static final boolean ACCESS_CONTROLLER;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         static <T> T a(PrivilegedAction<T> param3PrivilegedAction) {
/*  2665 */           return ACCESS_CONTROLLER ? AccessController.doPrivileged(param3PrivilegedAction) : param3PrivilegedAction.run();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic.AnnotationReader ofWildcardUpperBoundType(int param3Int) {
/*  2672 */           return new TypeDescription.Generic.AnnotationReader.ForWildcardUpperBoundType(this, param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic.AnnotationReader ofWildcardLowerBoundType(int param3Int) {
/*  2679 */           return new TypeDescription.Generic.AnnotationReader.ForWildcardLowerBoundType(this, param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic.AnnotationReader ofTypeVariableBoundType(int param3Int) {
/*  2686 */           return new TypeDescription.Generic.AnnotationReader.ForTypeVariableBoundType(this, param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic.AnnotationReader ofTypeArgument(int param3Int) {
/*  2693 */           return new TypeDescription.Generic.AnnotationReader.ForTypeArgument(this, param3Int);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic.AnnotationReader ofOwnerType() {
/*  2700 */           return new TypeDescription.Generic.AnnotationReader.ForOwnerType(this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic.AnnotationReader ofOuterClass() {
/*  2707 */           return new TypeDescription.Generic.AnnotationReader.ForOwnerType(this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic.AnnotationReader ofComponentType() {
/*  2714 */           return new TypeDescription.Generic.AnnotationReader.ForComponentType(this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList asList() {
/*  2721 */           return (AnnotationList)new AnnotationList.ForLoadedAnnotations(resolve().getDeclaredAnnotations());
/*       */         }
/*       */         static {
/*       */           try {
/*       */             Class.forName("java.security.AccessController", false, (ClassLoader)null);
/*       */             ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
/*       */             return;
/*       */           } catch (ClassNotFoundException classNotFoundException) {
/*       */             ACCESS_CONTROLLER = false;
/*       */             return;
/*       */           } catch (SecurityException securityException) {
/*       */             ACCESS_CONTROLLER = true;
/*       */             return;
/*       */           } 
/*       */         }
/*       */         
/*       */         @Enhance
/*       */         public static class Simple extends Delegator { private final AnnotatedElement annotatedElement;
/*       */           
/*       */           public Simple(AnnotatedElement param4AnnotatedElement) {
/*  2741 */             this.annotatedElement = param4AnnotatedElement;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*  2748 */             return this.annotatedElement;
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.annotatedElement.equals(((Simple)param4Object).annotatedElement))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.annotatedElement.hashCode();
/*       */           } }
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static abstract class Chained
/*       */           extends Delegator
/*       */         {
/*       */           protected final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */           
/*       */           protected Chained(TypeDescription.Generic.AnnotationReader param4AnnotationReader) {
/*  2769 */             this.annotationReader = param4AnnotationReader;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*  2776 */             return resolve(this.annotationReader.resolve());
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           protected abstract AnnotatedElement resolve(AnnotatedElement param4AnnotatedElement);
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.annotationReader.equals(((Chained)param4Object).annotationReader))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.annotationReader.hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         public static class ForLoadedTypeVariable
/*       */           extends Delegator
/*       */         {
/*       */           private final TypeVariable<?> typeVariable;
/*       */ 
/*       */           
/*       */           public ForLoadedTypeVariable(TypeVariable<?> param4TypeVariable) {
/*  2805 */             this.typeVariable = param4TypeVariable;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"BC_VACUOUS_INSTANCEOF"}, justification = "Cast is required for JVMs before Java 8.")
/*       */           public AnnotatedElement resolve() {
/*  2814 */             return (AnnotatedElement)((this.typeVariable instanceof AnnotatedElement) ? this.typeVariable : TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic.AnnotationReader ofTypeVariableBoundType(int param4Int) {
/*  2823 */             return new TypeDescription.Generic.AnnotationReader.ForTypeVariableBoundType.OfFormalTypeVariable(this.typeVariable, param4Int);
/*       */           }
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.typeVariable.equals(((ForLoadedTypeVariable)param4Object).typeVariable))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.typeVariable.hashCode();
/*       */           }
/*       */         }
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         public static class ForLoadedSuperClass
/*       */           extends Delegator
/*       */         {
/*       */           private final Class<?> type;
/*       */           
/*       */           public ForLoadedSuperClass(Class<?> param4Class) {
/*  2844 */             this.type = param4Class;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*       */             AnnotatedElement annotatedElement;
/*  2852 */             return ((annotatedElement = TypeDescription.ForLoadedType.a().getAnnotatedSuperclass(this.type)) == null) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : annotatedElement;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.type.equals(((ForLoadedSuperClass)param4Object).type))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.type.hashCode();
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         public static class ForLoadedInterface
/*       */           extends Delegator
/*       */         {
/*       */           private final Class<?> type;
/*       */ 
/*       */           
/*       */           private final int index;
/*       */ 
/*       */           
/*       */           public ForLoadedInterface(Class<?> param4Class, int param4Int) {
/*  2881 */             this.type = param4Class;
/*  2882 */             this.index = param4Int;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*       */             AnnotatedElement[] arrayOfAnnotatedElement;
/*  2890 */             return ((arrayOfAnnotatedElement = TypeDescription.ForLoadedType.a().getAnnotatedInterfaces(this.type)).length == 0) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : arrayOfAnnotatedElement[this.index];
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.index != ((ForLoadedInterface)param4Object).index) ? false : (!!this.type.equals(((ForLoadedInterface)param4Object).type)))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return (getClass().hashCode() * 31 + this.type.hashCode()) * 31 + this.index;
/*       */           } }
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         public static class ForLoadedField extends Delegator {
/*  2903 */           protected static final Dispatcher DISPATCHER = a(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final Field field;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ForLoadedField(Field param4Field) {
/*  2916 */             this.field = param4Field;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*       */             AnnotatedElement annotatedElement;
/*  2924 */             return ((annotatedElement = DISPATCHER.getAnnotatedType(this.field)) == null) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : annotatedElement;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.field.equals(((ForLoadedField)param4Object).field))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.field.hashCode();
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           @Proxied("java.lang.reflect.Field")
/*       */           protected static interface Dispatcher
/*       */           {
/*       */             @MaybeNull
/*       */             @Defaults
/*       */             @Proxied("getAnnotatedType")
/*       */             AnnotatedElement getAnnotatedType(Field param5Field);
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         public static class ForLoadedMethodReturnType
/*       */           extends Delegator
/*       */         {
/*  2956 */           protected static final Dispatcher DISPATCHER = a(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final Method method;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ForLoadedMethodReturnType(Method param4Method) {
/*  2969 */             this.method = param4Method;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*       */             AnnotatedElement annotatedElement;
/*  2977 */             return ((annotatedElement = DISPATCHER.getAnnotatedReturnType(this.method)) == null) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : annotatedElement;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.method.equals(((ForLoadedMethodReturnType)param4Object).method))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return getClass().hashCode() * 31 + this.method.hashCode();
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           @Proxied("java.lang.reflect.Method")
/*       */           protected static interface Dispatcher
/*       */           {
/*       */             @MaybeNull
/*       */             @Defaults
/*       */             @Proxied("getAnnotatedReturnType")
/*       */             AnnotatedElement getAnnotatedReturnType(Method param5Method);
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         public static class ForLoadedExecutableParameterType
/*       */           extends Delegator
/*       */         {
/*  3009 */           protected static final Dispatcher DISPATCHER = a(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AccessibleObject executable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ForLoadedExecutableParameterType(AccessibleObject param4AccessibleObject, int param4Int) {
/*  3028 */             this.executable = param4AccessibleObject;
/*  3029 */             this.index = param4Int;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*       */             AnnotatedElement[] arrayOfAnnotatedElement;
/*  3037 */             return ((arrayOfAnnotatedElement = DISPATCHER.getAnnotatedParameterTypes(this.executable)).length == 0) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : arrayOfAnnotatedElement[this.index];
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.index != ((ForLoadedExecutableParameterType)param4Object).index) ? false : (!!this.executable.equals(((ForLoadedExecutableParameterType)param4Object).executable)))));
/*       */           }
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (getClass().hashCode() * 31 + this.executable.hashCode()) * 31 + this.index;
/*       */           }
/*       */ 
/*       */           
/*       */           @Proxied("java.lang.reflect.Executable")
/*       */           protected static interface Dispatcher
/*       */           {
/*       */             @Defaults
/*       */             @Proxied("getAnnotatedParameterTypes")
/*       */             AnnotatedElement[] getAnnotatedParameterTypes(Object param5Object);
/*       */           }
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance(includeSyntheticFields = true)
/*       */         public static class ForLoadedExecutableExceptionType
/*       */           extends Delegator
/*       */         {
/*  3066 */           protected static final Dispatcher DISPATCHER = a(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final AccessibleObject executable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public ForLoadedExecutableExceptionType(AccessibleObject param4AccessibleObject, int param4Int) {
/*  3085 */             this.executable = param4AccessibleObject;
/*  3086 */             this.index = param4Int;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*       */             AnnotatedElement[] arrayOfAnnotatedElement;
/*  3094 */             return ((arrayOfAnnotatedElement = DISPATCHER.getAnnotatedExceptionTypes(this.executable)).length == 0) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : arrayOfAnnotatedElement[this.index];
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.index != ((ForLoadedExecutableExceptionType)param4Object).index) ? false : (!!this.executable.equals(((ForLoadedExecutableExceptionType)param4Object).executable)))));
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           public int hashCode() {
/*       */             return (getClass().hashCode() * 31 + this.executable.hashCode()) * 31 + this.index;
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           @Proxied("java.lang.reflect.Executable")
/*       */           protected static interface Dispatcher
/*       */           {
/*       */             @Defaults
/*       */             @Proxied("getAnnotatedExceptionTypes")
/*       */             AnnotatedElement[] getAnnotatedExceptionTypes(Object param5Object);
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public static class ForLoadedRecordComponent
/*       */           extends Delegator
/*       */         {
/*       */           private final Object recordComponent;
/*       */ 
/*       */ 
/*       */           
/*       */           public ForLoadedRecordComponent(Object param4Object) {
/*  3130 */             this.recordComponent = param4Object;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*  3137 */             return RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getAnnotatedType(this.recordComponent);
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForWildcardUpperBoundType
/*       */         extends Delegator.Chained
/*       */       {
/*  3151 */         private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = a(JavaDispatcher.of(AnnotatedWildcardType.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForWildcardUpperBoundType(TypeDescription.Generic.AnnotationReader param3AnnotationReader, int param3Int) {
/*  3165 */           super(param3AnnotationReader);
/*  3166 */           this.index = param3Int;
/*       */         }
/*       */ 
/*       */         
/*       */         protected AnnotatedElement resolve(AnnotatedElement param3AnnotatedElement) {
/*  3171 */           if (!ANNOTATED_WILDCARD_TYPE.isInstance(param3AnnotatedElement)) {
/*  3172 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           }
/*       */           try {
/*       */             AnnotatedElement[] arrayOfAnnotatedElement;
/*  3176 */             return ((arrayOfAnnotatedElement = ANNOTATED_WILDCARD_TYPE.getAnnotatedUpperBounds(param3AnnotatedElement)).length == 0) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : arrayOfAnnotatedElement[this.index];
/*       */           
/*       */           }
/*  3179 */           catch (ClassCastException classCastException) {
/*  3180 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((ForWildcardUpperBoundType)param3Object).index)))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @Proxied("java.lang.reflect.AnnotatedWildcardType")
/*       */         protected static interface AnnotatedWildcardType
/*       */         {
/*       */           @Instance
/*       */           @Proxied("isInstance")
/*       */           boolean isInstance(AnnotatedElement param4AnnotatedElement);
/*       */ 
/*       */ 
/*       */           
/*       */           @Proxied("getAnnotatedUpperBounds")
/*       */           AnnotatedElement[] getAnnotatedUpperBounds(AnnotatedElement param4AnnotatedElement);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForWildcardLowerBoundType
/*       */         extends Delegator.Chained
/*       */       {
/*  3218 */         private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = a(JavaDispatcher.of(AnnotatedWildcardType.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForWildcardLowerBoundType(TypeDescription.Generic.AnnotationReader param3AnnotationReader, int param3Int) {
/*  3232 */           super(param3AnnotationReader);
/*  3233 */           this.index = param3Int;
/*       */         }
/*       */ 
/*       */         
/*       */         protected AnnotatedElement resolve(AnnotatedElement param3AnnotatedElement) {
/*  3238 */           if (!ANNOTATED_WILDCARD_TYPE.isInstance(param3AnnotatedElement)) {
/*  3239 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           }
/*       */           try {
/*  3242 */             return ANNOTATED_WILDCARD_TYPE.getAnnotatedLowerBounds(param3AnnotatedElement)[this.index];
/*  3243 */           } catch (ClassCastException classCastException) {
/*  3244 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((ForWildcardLowerBoundType)param3Object).index)))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @Proxied("java.lang.reflect.AnnotatedWildcardType")
/*       */         protected static interface AnnotatedWildcardType
/*       */         {
/*       */           @Instance
/*       */           @Proxied("isInstance")
/*       */           boolean isInstance(AnnotatedElement param4AnnotatedElement);
/*       */ 
/*       */ 
/*       */           
/*       */           @Proxied("getAnnotatedLowerBounds")
/*       */           AnnotatedElement[] getAnnotatedLowerBounds(AnnotatedElement param4AnnotatedElement);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       public static class ForTypeVariableBoundType
/*       */         extends Delegator.Chained
/*       */       {
/*  3282 */         private static final AnnotatedTypeVariable ANNOTATED_TYPE_VARIABLE = a(JavaDispatcher.of(AnnotatedTypeVariable.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForTypeVariableBoundType(TypeDescription.Generic.AnnotationReader param3AnnotationReader, int param3Int) {
/*  3296 */           super(param3AnnotationReader);
/*  3297 */           this.index = param3Int;
/*       */         }
/*       */ 
/*       */         
/*       */         protected AnnotatedElement resolve(AnnotatedElement param3AnnotatedElement) {
/*  3302 */           if (!ANNOTATED_TYPE_VARIABLE.isInstance(param3AnnotatedElement)) {
/*  3303 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           }
/*       */           try {
/*  3306 */             return ANNOTATED_TYPE_VARIABLE.getAnnotatedBounds(param3AnnotatedElement)[this.index];
/*  3307 */           } catch (ClassCastException classCastException) {
/*  3308 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((ForTypeVariableBoundType)param3Object).index)))));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance
/*       */         protected static class OfFormalTypeVariable
/*       */           extends TypeDescription.Generic.AnnotationReader.Delegator
/*       */         {
/*  3345 */           private static final FormalTypeVariable TYPE_VARIABLE = a(JavaDispatcher.of(FormalTypeVariable.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeVariable<?> typeVariable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected OfFormalTypeVariable(TypeVariable<?> param4TypeVariable, int param4Int) {
/*  3364 */             this.typeVariable = param4TypeVariable;
/*  3365 */             this.index = param4Int;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotatedElement resolve() {
/*       */             try {
/*       */               AnnotatedElement[] arrayOfAnnotatedElement;
/*  3374 */               return ((arrayOfAnnotatedElement = TYPE_VARIABLE.getAnnotatedBounds(this.typeVariable)).length == 0) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : arrayOfAnnotatedElement[this.index];
/*       */             
/*       */             }
/*  3377 */             catch (ClassCastException classCastException) {
/*  3378 */               return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */             } 
/*       */           }
/*       */           
/*       */           public boolean equals(@MaybeNull Object param4Object) {
/*       */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.index != ((OfFormalTypeVariable)param4Object).index) ? false : (!!this.typeVariable.equals(((OfFormalTypeVariable)param4Object).typeVariable)))));
/*       */           }
/*       */           
/*       */           public int hashCode() {
/*       */             return (getClass().hashCode() * 31 + this.typeVariable.hashCode()) * 31 + this.index;
/*       */           }
/*       */           
/*       */           @Proxied("java.lang.reflect.TypeVariable")
/*       */           protected static interface FormalTypeVariable {
/*       */             @Defaults
/*       */             @Proxied("getAnnotatedBounds")
/*       */             AnnotatedElement[] getAnnotatedBounds(Object param5Object);
/*       */           }
/*       */         }
/*       */         
/*       */         @Proxied("java.lang.reflect.AnnotatedTypeVariable")
/*       */         protected static interface AnnotatedTypeVariable {
/*       */           @Instance
/*       */           @Proxied("isInstance")
/*       */           boolean isInstance(AnnotatedElement param4AnnotatedElement);
/*       */           
/*       */           @Proxied("getAnnotatedBounds")
/*       */           AnnotatedElement[] getAnnotatedBounds(AnnotatedElement param4AnnotatedElement);
/*       */         }
/*       */       }
/*       */       
/*       */       @Enhance
/*       */       public static class ForTypeArgument extends Delegator.Chained {
/*  3411 */         private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = a(JavaDispatcher.of(AnnotatedParameterizedType.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForTypeArgument(TypeDescription.Generic.AnnotationReader param3AnnotationReader, int param3Int) {
/*  3425 */           super(param3AnnotationReader);
/*  3426 */           this.index = param3Int;
/*       */         }
/*       */ 
/*       */         
/*       */         protected AnnotatedElement resolve(AnnotatedElement param3AnnotatedElement) {
/*  3431 */           if (!ANNOTATED_PARAMETERIZED_TYPE.isInstance(param3AnnotatedElement)) {
/*  3432 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           }
/*       */           try {
/*  3435 */             return ANNOTATED_PARAMETERIZED_TYPE.getAnnotatedActualTypeArguments(param3AnnotatedElement)[this.index];
/*  3436 */           } catch (ClassCastException classCastException) {
/*  3437 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!(this.index != ((ForTypeArgument)param3Object).index)))));
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.index;
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @Proxied("java.lang.reflect.AnnotatedParameterizedType")
/*       */         protected static interface AnnotatedParameterizedType
/*       */         {
/*       */           @Instance
/*       */           @Proxied("isInstance")
/*       */           boolean isInstance(AnnotatedElement param4AnnotatedElement);
/*       */ 
/*       */ 
/*       */           
/*       */           @Proxied("getAnnotatedActualTypeArguments")
/*       */           AnnotatedElement[] getAnnotatedActualTypeArguments(AnnotatedElement param4AnnotatedElement);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForComponentType
/*       */         extends Delegator.Chained
/*       */       {
/*  3474 */         private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = a(JavaDispatcher.of(AnnotatedParameterizedType.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForComponentType(TypeDescription.Generic.AnnotationReader param3AnnotationReader) {
/*  3482 */           super(param3AnnotationReader);
/*       */         }
/*       */ 
/*       */         
/*       */         protected AnnotatedElement resolve(AnnotatedElement param3AnnotatedElement) {
/*  3487 */           if (!ANNOTATED_PARAMETERIZED_TYPE.isInstance(param3AnnotatedElement)) {
/*  3488 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           }
/*       */           try {
/*  3491 */             return ANNOTATED_PARAMETERIZED_TYPE.getAnnotatedGenericComponentType(param3AnnotatedElement);
/*  3492 */           } catch (ClassCastException classCastException) {
/*  3493 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Proxied("java.lang.reflect.AnnotatedArrayType")
/*       */         protected static interface AnnotatedParameterizedType
/*       */         {
/*       */           @Instance
/*       */           @Proxied("isInstance")
/*       */           boolean isInstance(AnnotatedElement param4AnnotatedElement);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @Proxied("getAnnotatedGenericComponentType")
/*       */           AnnotatedElement getAnnotatedGenericComponentType(AnnotatedElement param4AnnotatedElement);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForOwnerType
/*       */         extends Delegator.Chained
/*       */       {
/*  3530 */         private static final AnnotatedType ANNOTATED_TYPE = a(JavaDispatcher.of(AnnotatedType.class));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForOwnerType(TypeDescription.Generic.AnnotationReader param3AnnotationReader) {
/*  3538 */           super(param3AnnotationReader);
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         protected AnnotatedElement resolve(AnnotatedElement param3AnnotatedElement) {
/*       */           try {
/*  3545 */             return ((param3AnnotatedElement = ANNOTATED_TYPE.getAnnotatedOwnerType(param3AnnotatedElement)) == null) ? TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE : param3AnnotatedElement;
/*       */           
/*       */           }
/*  3548 */           catch (ClassCastException classCastException) {
/*  3549 */             return TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE;
/*       */           } 
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Proxied("java.lang.reflect.AnnotatedType")
/*       */         protected static interface AnnotatedType
/*       */         {
/*       */           @MaybeNull
/*       */           @Defaults
/*       */           @Proxied("getAnnotatedOwnerType")
/*       */           AnnotatedElement getAnnotatedOwnerType(AnnotatedElement param4AnnotatedElement);
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class AbstractBase
/*       */       extends ModifierReviewable.AbstractBase
/*       */       implements Generic
/*       */     {
/*       */       public int getModifiers() {
/*  3581 */         return asErasure().getModifiers();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asGenericType() {
/*  3588 */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asRawType() {
/*  3595 */         return asErasure().asGenericType();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean represents(Type param2Type) {
/*  3602 */         return equals(TypeDefinition.Sort.describe(param2Type));
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static class LazyProxy
/*       */       implements InvocationHandler
/*       */     {
/*       */       private final Class<?> type;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected LazyProxy(Class<?> param2Class) {
/*  3624 */         this.type = param2Class;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected static TypeDescription.Generic of(Class<?> param2Class) {
/*  3634 */         return (TypeDescription.Generic)Proxy.newProxyInstance(TypeDescription.Generic.class.getClassLoader(), new Class[] { TypeDescription.Generic.class }, new LazyProxy(param2Class));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Object invoke(Object param2Object, Method param2Method, @MaybeNull Object[] param2ArrayOfObject) {
/*       */         try {
/*  3644 */           return param2Method.invoke(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.type), param2ArrayOfObject);
/*  3645 */         } catch (InvocationTargetException invocationTargetException) {
/*  3646 */           throw (param2Object = null).getTargetException();
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.type.equals(((LazyProxy)param2Object).type))));
/*       */       }
/*       */ 
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.type.hashCode();
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     public static abstract class OfNonGenericType
/*       */       extends AbstractBase
/*       */     {
/*       */       public TypeDefinition.Sort getSort() {
/*  3667 */         return TypeDefinition.Sort.NON_GENERIC;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getSuperClass() {
/*       */         TypeDescription typeDescription;
/*  3676 */         TypeDescription.Generic generic = (typeDescription = asErasure()).getSuperClass();
/*  3677 */         if (TypeDescription.AbstractBase.RAW_TYPES) {
/*  3678 */           return generic;
/*       */         }
/*  3680 */         return (generic == null) ? TypeDescription.Generic.UNDEFINED : new TypeDescription.Generic.LazyProjection.WithResolvedErasure(generic, new TypeDescription.Generic.Visitor.ForRawType(typeDescription), (AnnotationSource)AnnotationSource.Empty.INSTANCE);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getInterfaces() {
/*  3689 */         TypeDescription typeDescription = asErasure();
/*  3690 */         if (TypeDescription.AbstractBase.RAW_TYPES) {
/*  3691 */           return typeDescription.getInterfaces();
/*       */         }
/*  3693 */         return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure((List<? extends TypeDescription.Generic>)typeDescription.getInterfaces(), new TypeDescription.Generic.Visitor.ForRawType(typeDescription));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  3700 */         TypeDescription typeDescription = asErasure();
/*  3701 */         return (FieldList<FieldDescription.InGenericShape>)new FieldList.TypeSubstituting(this, (List)typeDescription.getDeclaredFields(), TypeDescription.AbstractBase.RAW_TYPES ? TypeDescription.Generic.Visitor.NoOp.INSTANCE : new TypeDescription.Generic.Visitor.ForRawType(typeDescription));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  3710 */         TypeDescription typeDescription = asErasure();
/*  3711 */         return (MethodList<MethodDescription.InGenericShape>)new MethodList.TypeSubstituting(this, (List)typeDescription.getDeclaredMethods(), TypeDescription.AbstractBase.RAW_TYPES ? TypeDescription.Generic.Visitor.NoOp.INSTANCE : new TypeDescription.Generic.Visitor.ForRawType(typeDescription));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
/*  3720 */         TypeDescription typeDescription = asErasure();
/*  3721 */         return new RecordComponentList.TypeSubstituting(this, (List)typeDescription.getRecordComponents(), TypeDescription.AbstractBase.RAW_TYPES ? TypeDescription.Generic.Visitor.NoOp.INSTANCE : new TypeDescription.Generic.Visitor.ForRawType(typeDescription));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getTypeArguments() {
/*  3730 */         throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic findBindingOf(TypeDescription.Generic param2Generic) {
/*  3737 */         throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public <T> T accept(TypeDescription.Generic.Visitor<T> param2Visitor) {
/*  3744 */         return param2Visitor.onNonGenericType(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getTypeName() {
/*  3751 */         return asErasure().getTypeName();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getUpperBounds() {
/*  3758 */         throw new IllegalStateException("A non-generic type does not imply upper type bounds: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getLowerBounds() {
/*  3765 */         throw new IllegalStateException("A non-generic type does not imply lower type bounds: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeVariableSource getTypeVariableSource() {
/*  3772 */         throw new IllegalStateException("A non-generic type does not imply a type variable source: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getSymbol() {
/*  3779 */         throw new IllegalStateException("A non-generic type does not imply a symbol: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackSize getStackSize() {
/*  3786 */         return asErasure().getStackSize();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getActualName() {
/*  3793 */         return asErasure().getActualName();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isArray() {
/*  3800 */         return asErasure().isArray();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isPrimitive() {
/*  3807 */         return asErasure().isPrimitive();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isRecord() {
/*  3814 */         return asErasure().isRecord();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean represents(Type param2Type) {
/*  3821 */         return asErasure().represents(param2Type);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Iterator<TypeDefinition> iterator() {
/*  3828 */         return new TypeDefinition.SuperClassIterator(this);
/*       */       } @Enhance("hashCode")
/*       */       public int hashCode() {
/*       */         OfNonGenericType ofNonGenericType;
/*       */         int j;
/*       */         int i;
/*  3834 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : (ofNonGenericType = this).asErasure().hashCode())) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*       */       }
/*       */ 
/*       */       
/*       */       @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"}, justification = "Type check is performed by erasure implementation.")
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*  3840 */         return (this == param2Object || asErasure().equals(param2Object));
/*       */       }
/*       */ 
/*       */       
/*       */       public String toString() {
/*  3845 */         return asErasure().toString();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedType
/*       */         extends OfNonGenericType
/*       */       {
/*       */         private static final Map<Class<?>, TypeDescription.Generic> TYPE_CACHE;
/*       */ 
/*       */         
/*       */         private final Class<?> type;
/*       */ 
/*       */         
/*       */         private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */         
/*       */         static {
/*  3863 */           (TYPE_CACHE = new HashMap<Class<?>, TypeDescription.Generic>()).put(TargetType.class, new ForLoadedType(TargetType.class));
/*  3864 */           TYPE_CACHE.put(Class.class, new ForLoadedType(Class.class));
/*  3865 */           TYPE_CACHE.put(Throwable.class, new ForLoadedType(Throwable.class));
/*  3866 */           TYPE_CACHE.put(Annotation.class, new ForLoadedType(Annotation.class));
/*  3867 */           TYPE_CACHE.put(Object.class, new ForLoadedType(Object.class));
/*  3868 */           TYPE_CACHE.put(String.class, new ForLoadedType(String.class));
/*  3869 */           TYPE_CACHE.put(Boolean.class, new ForLoadedType(Boolean.class));
/*  3870 */           TYPE_CACHE.put(Byte.class, new ForLoadedType(Byte.class));
/*  3871 */           TYPE_CACHE.put(Short.class, new ForLoadedType(Short.class));
/*  3872 */           TYPE_CACHE.put(Character.class, new ForLoadedType(Character.class));
/*  3873 */           TYPE_CACHE.put(Integer.class, new ForLoadedType(Integer.class));
/*  3874 */           TYPE_CACHE.put(Long.class, new ForLoadedType(Long.class));
/*  3875 */           TYPE_CACHE.put(Float.class, new ForLoadedType(Float.class));
/*  3876 */           TYPE_CACHE.put(Double.class, new ForLoadedType(Double.class));
/*  3877 */           TYPE_CACHE.put(void.class, new ForLoadedType(void.class));
/*  3878 */           TYPE_CACHE.put(boolean.class, new ForLoadedType(boolean.class));
/*  3879 */           TYPE_CACHE.put(byte.class, new ForLoadedType(byte.class));
/*  3880 */           TYPE_CACHE.put(short.class, new ForLoadedType(short.class));
/*  3881 */           TYPE_CACHE.put(char.class, new ForLoadedType(char.class));
/*  3882 */           TYPE_CACHE.put(int.class, new ForLoadedType(int.class));
/*  3883 */           TYPE_CACHE.put(long.class, new ForLoadedType(long.class));
/*  3884 */           TYPE_CACHE.put(float.class, new ForLoadedType(float.class));
/*  3885 */           TYPE_CACHE.put(double.class, new ForLoadedType(double.class));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForLoadedType(Class<?> param3Class) {
/*  3905 */           this(param3Class, TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForLoadedType(Class<?> param3Class, TypeDescription.Generic.AnnotationReader param3AnnotationReader) {
/*  3916 */           this.type = param3Class;
/*  3917 */           this.annotationReader = param3AnnotationReader;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static TypeDescription.Generic of(Class<?> param3Class) {
/*       */           TypeDescription.Generic generic;
/*  3928 */           return ((generic = TYPE_CACHE.get(param3Class)) == null) ? new ForLoadedType(param3Class) : generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  3937 */           return TypeDescription.ForLoadedType.of(this.type);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*       */           Class<?> clazz;
/*  3946 */           return ((clazz = this.type.getDeclaringClass()) == null) ? TypeDescription.Generic.UNDEFINED : new ForLoadedType(clazz, this.annotationReader
/*       */               
/*  3948 */               .ofOuterClass());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getComponentType() {
/*       */           Class<?> clazz;
/*  3957 */           return ((clazz = this.type.getComponentType()) == null) ? TypeDescription.Generic.UNDEFINED : new ForLoadedType(clazz, this.annotationReader
/*       */               
/*  3959 */               .ofComponentType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  3966 */           return this.annotationReader.asList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean represents(Type param3Type) {
/*  3973 */           return (this.type == param3Type || super.represents(param3Type));
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForErasure
/*       */         extends OfNonGenericType
/*       */       {
/*       */         private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForErasure(TypeDescription param3TypeDescription) {
/*  3995 */           this.typeDescription = param3TypeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  4002 */           return this.typeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*       */           TypeDescription typeDescription;
/*  4011 */           return ((typeDescription = this.typeDescription.getDeclaringType()) == null) ? TypeDescription.Generic.UNDEFINED : typeDescription
/*       */             
/*  4013 */             .asGenericType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getComponentType() {
/*       */           TypeDescription typeDescription;
/*  4022 */           return ((typeDescription = this.typeDescription.getComponentType()) == null) ? TypeDescription.Generic.UNDEFINED : typeDescription
/*       */             
/*  4024 */             .asGenericType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  4031 */           return (AnnotationList)new AnnotationList.Empty();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class Latent
/*       */         extends OfNonGenericType
/*       */       {
/*       */         private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         private final TypeDescription.Generic declaringType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AnnotationSource annotationSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Latent(TypeDescription param3TypeDescription, AnnotationSource param3AnnotationSource) {
/*  4063 */           this(param3TypeDescription, param3TypeDescription.getDeclaringType(), param3AnnotationSource);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private Latent(TypeDescription param3TypeDescription1, @MaybeNull TypeDescription param3TypeDescription2, AnnotationSource param3AnnotationSource) {
/*  4074 */           this(param3TypeDescription1, (param3TypeDescription2 == null) ? TypeDescription.Generic.UNDEFINED : param3TypeDescription2
/*       */ 
/*       */               
/*  4077 */               .asGenericType(), param3AnnotationSource);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Latent(TypeDescription param3TypeDescription, @MaybeNull TypeDescription.Generic param3Generic, AnnotationSource param3AnnotationSource) {
/*  4089 */           this.typeDescription = param3TypeDescription;
/*  4090 */           this.declaringType = param3Generic;
/*  4091 */           this.annotationSource = param3AnnotationSource;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*  4099 */           return this.declaringType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getComponentType() {
/*       */           TypeDescription typeDescription;
/*  4108 */           return ((typeDescription = this.typeDescription.getComponentType()) == null) ? TypeDescription.Generic.UNDEFINED : typeDescription
/*       */             
/*  4110 */             .asGenericType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  4117 */           return this.annotationSource.getDeclaredAnnotations();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  4124 */           return this.typeDescription;
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForReifiedErasure
/*       */         extends OfNonGenericType
/*       */       {
/*       */         private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForReifiedErasure(TypeDescription param3TypeDescription) {
/*  4145 */           this.typeDescription = param3TypeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static TypeDescription.Generic of(TypeDescription param3TypeDescription) {
/*  4155 */           return (TypeDescription.Generic)(param3TypeDescription.isGenerified() ? new ForReifiedErasure(param3TypeDescription) : new TypeDescription.Generic.OfNonGenericType.ForErasure(param3TypeDescription));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getSuperClass() {
/*       */           TypeDescription.Generic generic;
/*  4166 */           return ((generic = this.typeDescription.getSuperClass()) == null) ? TypeDescription.Generic.UNDEFINED : new TypeDescription.Generic.LazyProjection.WithResolvedErasure(generic, TypeDescription.Generic.Visitor.Reifying.INHERITING);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getInterfaces() {
/*  4175 */           return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure((List<? extends TypeDescription.Generic>)this.typeDescription.getInterfaces(), TypeDescription.Generic.Visitor.Reifying.INHERITING);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  4182 */           return (FieldList<FieldDescription.InGenericShape>)new FieldList.TypeSubstituting(this, (List)this.typeDescription.getDeclaredFields(), TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  4189 */           return (MethodList<MethodDescription.InGenericShape>)new MethodList.TypeSubstituting(this, (List)this.typeDescription.getDeclaredMethods(), TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  4196 */           return this.typeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*       */           TypeDescription typeDescription;
/*  4205 */           return ((typeDescription = this.typeDescription.getDeclaringType()) == null) ? TypeDescription.Generic.UNDEFINED : 
/*       */             
/*  4207 */             of(typeDescription);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getComponentType() {
/*       */           TypeDescription typeDescription;
/*  4216 */           return ((typeDescription = this.typeDescription.getComponentType()) == null) ? TypeDescription.Generic.UNDEFINED : 
/*       */             
/*  4218 */             of(typeDescription);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  4225 */           return (AnnotationList)new AnnotationList.Empty();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class OfGenericArray
/*       */       extends AbstractBase
/*       */     {
/*       */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */       public TypeDefinition.Sort getSort() {
/*  4241 */         return getComponentType().getSort().isNonGeneric() ? TypeDefinition.Sort.NON_GENERIC : TypeDefinition.Sort.GENERIC_ARRAY;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */       public TypeDescription asErasure() {
/*  4251 */         return TypeDescription.ArrayProjection.of(getComponentType().asErasure(), 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getSuperClass() {
/*  4259 */         return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getInterfaces() {
/*  4266 */         return TypeDescription.ARRAY_INTERFACES;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  4273 */         return (FieldList<FieldDescription.InGenericShape>)new FieldList.Empty();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  4280 */         return (MethodList<MethodDescription.InGenericShape>)new MethodList.Empty();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
/*  4287 */         return new RecordComponentList.Empty<RecordComponentDescription.InGenericShape>();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getUpperBounds() {
/*  4294 */         throw new IllegalStateException("A generic array type does not imply upper type bounds: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getLowerBounds() {
/*  4301 */         throw new IllegalStateException("A generic array type does not imply lower type bounds: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeVariableSource getTypeVariableSource() {
/*  4308 */         throw new IllegalStateException("A generic array type does not imply a type variable source: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getTypeArguments() {
/*  4315 */         throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic findBindingOf(TypeDescription.Generic param2Generic) {
/*  4322 */         throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getOwnerType() {
/*  4330 */         return TypeDescription.Generic.UNDEFINED;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getSymbol() {
/*  4337 */         throw new IllegalStateException("A generic array type does not imply a symbol: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getTypeName() {
/*  4344 */         if (getSort().isNonGeneric())
/*  4345 */           return asErasure().getTypeName(); 
/*  4346 */         return toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getActualName() {
/*  4353 */         if (getSort().isNonGeneric())
/*  4354 */           return asErasure().getActualName(); 
/*  4355 */         return toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isArray() {
/*  4362 */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isPrimitive() {
/*  4369 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isRecord() {
/*  4376 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Iterator<TypeDefinition> iterator() {
/*  4383 */         return new TypeDefinition.SuperClassIterator(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public <T> T accept(TypeDescription.Generic.Visitor<T> param2Visitor) {
/*  4390 */         if (getSort().isNonGeneric())
/*  4391 */           return param2Visitor.onNonGenericType(this);  return param2Visitor
/*  4392 */           .onGenericArray(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackSize getStackSize() {
/*  4399 */         return StackSize.SINGLE;
/*       */       } @Enhance("hashCode")
/*       */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */       public int hashCode() {
/*       */         int j;
/*       */         OfGenericArray ofGenericArray;
/*       */         int i;
/*  4406 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : ((ofGenericArray = this).getSort().isNonGeneric() ? ofGenericArray
/*  4407 */           .asErasure().hashCode() : ofGenericArray
/*  4408 */           .getComponentType().hashCode()))) {
/*       */           i = this.hashCode;
/*       */         } else {
/*       */           this.hashCode = i;
/*       */         } 
/*       */         return i;
/*       */       } @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS", "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Type check is performed by erasure implementation. Assuming component type for array type.")
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*  4416 */         if (this == param2Object)
/*  4417 */           return true; 
/*  4418 */         if (getSort().isNonGeneric()) {
/*  4419 */           return asErasure().equals(param2Object);
/*       */         }
/*  4421 */         if (!(param2Object instanceof TypeDescription.Generic)) {
/*  4422 */           return false;
/*       */         }
/*       */         
/*  4425 */         if ((param2Object = param2Object).getSort().isGenericArray() && getComponentType().equals(param2Object.getComponentType())) return true;  return false;
/*       */       }
/*       */ 
/*       */       
/*       */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */       public String toString() {
/*  4431 */         if (getSort().isNonGeneric())
/*  4432 */           return asErasure().toString(); 
/*  4433 */         return getComponentType().getTypeName() + "[]";
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedType
/*       */         extends OfGenericArray
/*       */       {
/*       */         private final GenericArrayType genericArrayType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForLoadedType(GenericArrayType param3GenericArrayType) {
/*  4457 */           this(param3GenericArrayType, TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForLoadedType(GenericArrayType param3GenericArrayType, TypeDescription.Generic.AnnotationReader param3AnnotationReader) {
/*  4467 */           this.genericArrayType = param3GenericArrayType;
/*  4468 */           this.annotationReader = param3AnnotationReader;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getComponentType() {
/*  4476 */           return TypeDefinition.Sort.describe(this.genericArrayType.getGenericComponentType(), this.annotationReader.ofComponentType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  4483 */           return this.annotationReader.asList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean represents(Type param3Type) {
/*  4490 */           return (this.genericArrayType == param3Type || super.represents(param3Type));
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class Latent
/*       */         extends OfGenericArray
/*       */       {
/*       */         private final TypeDescription.Generic componentType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AnnotationSource annotationSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Latent(TypeDescription.Generic param3Generic, AnnotationSource param3AnnotationSource) {
/*  4516 */           this.componentType = param3Generic;
/*  4517 */           this.annotationSource = param3AnnotationSource;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic getComponentType() {
/*  4524 */           return this.componentType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  4531 */           return this.annotationSource.getDeclaredAnnotations();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class OfWildcardType
/*       */       extends AbstractBase
/*       */     {
/*       */       public static final String SYMBOL = "?";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDefinition.Sort getSort() {
/*  4550 */         return TypeDefinition.Sort.WILDCARD;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription asErasure() {
/*  4557 */         throw new IllegalStateException("A wildcard does not represent an erasable type: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getSuperClass() {
/*  4565 */         throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getInterfaces() {
/*  4572 */         throw new IllegalStateException("A wildcard does not imply an interface type definition: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  4579 */         throw new IllegalStateException("A wildcard does not imply field definitions: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  4586 */         throw new IllegalStateException("A wildcard does not imply method definitions: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
/*  4593 */         throw new IllegalStateException("A wildcard does not imply record component definitions: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic getComponentType() {
/*  4600 */         throw new IllegalStateException("A wildcard does not imply a component type: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeVariableSource getTypeVariableSource() {
/*  4607 */         throw new IllegalStateException("A wildcard does not imply a type variable source: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getTypeArguments() {
/*  4614 */         throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic findBindingOf(TypeDescription.Generic param2Generic) {
/*  4621 */         throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic getOwnerType() {
/*  4628 */         throw new IllegalStateException("A wildcard does not imply an owner type: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getSymbol() {
/*  4635 */         throw new IllegalStateException("A wildcard does not imply a symbol: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getTypeName() {
/*  4642 */         return toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getActualName() {
/*  4649 */         return toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isPrimitive() {
/*  4656 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isArray() {
/*  4663 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isRecord() {
/*  4670 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean represents(Type param2Type) {
/*  4677 */         return equals(TypeDefinition.Sort.describe(param2Type));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Iterator<TypeDefinition> iterator() {
/*  4684 */         throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public <T> T accept(TypeDescription.Generic.Visitor<T> param2Visitor) {
/*  4691 */         return param2Visitor.onWildcard(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackSize getStackSize() {
/*  4698 */         throw new IllegalStateException("A wildcard does not imply an operand stack size: " + this);
/*       */       }
/*       */ 
/*       */       
/*       */       @Enhance("hashCode")
/*       */       public int hashCode() {
/*  4704 */         OfWildcardType ofWildcardType = this; int k = 1, m = 1;
/*  4705 */         for (TypeDescription.Generic generic : ofWildcardType.getLowerBounds()) {
/*  4706 */           k = k * 31 + generic.hashCode();
/*       */         }
/*  4708 */         for (TypeDescription.Generic generic : ofWildcardType.getUpperBounds())
/*  4709 */           m = m * 31 + generic.hashCode(); 
/*       */         int j, i;
/*  4711 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : (k ^ m))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*  4716 */         if (this == param2Object)
/*  4717 */           return true; 
/*  4718 */         if (!(param2Object instanceof TypeDescription.Generic)) {
/*  4719 */           return false;
/*       */         }
/*       */         
/*  4722 */         if ((param2Object = param2Object).getSort().isWildcard() && 
/*  4723 */           getUpperBounds().equals(param2Object.getUpperBounds()) && 
/*  4724 */           getLowerBounds().equals(param2Object.getLowerBounds())) return true; 
/*       */         return false;
/*       */       }
/*       */       
/*       */       public String toString() {
/*  4729 */         StringBuilder stringBuilder = new StringBuilder("?");
/*       */         TypeList.Generic generic;
/*  4731 */         if (!(generic = getLowerBounds()).isEmpty()) {
/*  4732 */           stringBuilder.append(" super ");
/*       */         } else {
/*       */           
/*  4735 */           if (((TypeDescription.Generic)(generic = getUpperBounds()).getOnly()).equals(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class))) {
/*  4736 */             return "?";
/*       */           }
/*  4738 */           stringBuilder.append(" extends ");
/*       */         } 
/*  4740 */         return stringBuilder.append(((TypeDescription.Generic)generic.getOnly()).getTypeName()).toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedType
/*       */         extends OfWildcardType
/*       */       {
/*       */         private final WildcardType wildcardType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForLoadedType(WildcardType param3WildcardType) {
/*  4764 */           this(param3WildcardType, TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForLoadedType(WildcardType param3WildcardType, TypeDescription.Generic.AnnotationReader param3AnnotationReader) {
/*  4774 */           this.wildcardType = param3WildcardType;
/*  4775 */           this.annotationReader = param3AnnotationReader;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getUpperBounds() {
/*  4782 */           return new WildcardUpperBoundTypeList(this.wildcardType.getUpperBounds(), this.annotationReader);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getLowerBounds() {
/*  4789 */           return new WildcardLowerBoundTypeList(this.wildcardType.getLowerBounds(), this.annotationReader);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  4796 */           return this.annotationReader.asList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean represents(Type param3Type) {
/*  4803 */           return (this.wildcardType == param3Type || super.represents(param3Type));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class WildcardUpperBoundTypeList
/*       */           extends TypeList.Generic.AbstractBase
/*       */         {
/*       */           private final Type[] upperBound;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected WildcardUpperBoundTypeList(Type[] param4ArrayOfType, TypeDescription.Generic.AnnotationReader param4AnnotationReader) {
/*  4828 */             this.upperBound = param4ArrayOfType;
/*  4829 */             this.annotationReader = param4AnnotationReader;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic get(int param4Int) {
/*  4836 */             return TypeDefinition.Sort.describe(this.upperBound[param4Int], this.annotationReader.ofWildcardUpperBoundType(param4Int));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int size() {
/*  4843 */             return this.upperBound.length;
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class WildcardLowerBoundTypeList
/*       */           extends TypeList.Generic.AbstractBase
/*       */         {
/*       */           private final Type[] lowerBound;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected WildcardLowerBoundTypeList(Type[] param4ArrayOfType, TypeDescription.Generic.AnnotationReader param4AnnotationReader) {
/*  4869 */             this.lowerBound = param4ArrayOfType;
/*  4870 */             this.annotationReader = param4AnnotationReader;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic get(int param4Int) {
/*  4877 */             return TypeDefinition.Sort.describe(this.lowerBound[param4Int], this.annotationReader.ofWildcardLowerBoundType(param4Int));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int size() {
/*  4884 */             return this.lowerBound.length;
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class Latent
/*       */         extends OfWildcardType
/*       */       {
/*       */         private final List<? extends TypeDescription.Generic> upperBounds;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final List<? extends TypeDescription.Generic> lowerBounds;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AnnotationSource annotationSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected Latent(List<? extends TypeDescription.Generic> param3List1, List<? extends TypeDescription.Generic> param3List2, AnnotationSource param3AnnotationSource) {
/*  4917 */           this.upperBounds = param3List1;
/*  4918 */           this.lowerBounds = param3List2;
/*  4919 */           this.annotationSource = param3AnnotationSource;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static TypeDescription.Generic unbounded(AnnotationSource param3AnnotationSource) {
/*  4929 */           return new Latent(Collections.singletonList(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)), Collections.emptyList(), param3AnnotationSource);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static TypeDescription.Generic boundedAbove(TypeDescription.Generic param3Generic, AnnotationSource param3AnnotationSource) {
/*  4940 */           return new Latent(Collections.singletonList(param3Generic), Collections.emptyList(), param3AnnotationSource);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static TypeDescription.Generic boundedBelow(TypeDescription.Generic param3Generic, AnnotationSource param3AnnotationSource) {
/*  4951 */           return new Latent(Collections.singletonList(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)), Collections.singletonList(param3Generic), param3AnnotationSource);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getUpperBounds() {
/*  4958 */           return new TypeList.Generic.Explicit((List)this.upperBounds);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getLowerBounds() {
/*  4965 */           return new TypeList.Generic.Explicit((List)this.lowerBounds);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  4972 */           return this.annotationSource.getDeclaredAnnotations();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class OfParameterizedType
/*       */       extends AbstractBase
/*       */     {
/*       */       public TypeDefinition.Sort getSort() {
/*  4986 */         return TypeDefinition.Sort.PARAMETERIZED;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getSuperClass() {
/*       */         TypeDescription.Generic generic;
/*  4995 */         return ((generic = asErasure().getSuperClass()) == null) ? TypeDescription.Generic.UNDEFINED : new TypeDescription.Generic.LazyProjection.WithResolvedErasure(generic, new TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding(this));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getInterfaces() {
/*  5004 */         return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure((List<? extends TypeDescription.Generic>)asErasure().getInterfaces(), new TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding(this));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  5011 */         return (FieldList<FieldDescription.InGenericShape>)new FieldList.TypeSubstituting(this, (List)asErasure().getDeclaredFields(), new TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding(this));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  5018 */         return (MethodList<MethodDescription.InGenericShape>)new MethodList.TypeSubstituting(this, (List)asErasure().getDeclaredMethods(), new TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding(this));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
/*  5025 */         return new RecordComponentList.TypeSubstituting(this, (List)asErasure().getRecordComponents(), new TypeDescription.Generic.Visitor.Substitutor.ForTypeVariableBinding(this));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic findBindingOf(TypeDescription.Generic param2Generic) {
/*  5033 */         OfParameterizedType ofParameterizedType = this; TypeDescription.Generic generic;
/*       */         do {
/*  5035 */           TypeList.Generic generic1 = ofParameterizedType.getTypeArguments(), generic2 = ofParameterizedType.asErasure().getTypeVariables();
/*  5036 */           for (byte b = 0; b < Math.min(generic1.size(), generic2.size()); b++) {
/*  5037 */             if (param2Generic.equals(generic2.get(b))) {
/*  5038 */               return (TypeDescription.Generic)generic1.get(b);
/*       */             }
/*       */           }
/*       */         
/*  5042 */         } while ((generic = ofParameterizedType.getOwnerType()) != null && generic.getSort().isParameterized());
/*  5043 */         return TypeDescription.Generic.UNDEFINED;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getUpperBounds() {
/*  5050 */         throw new IllegalStateException("A parameterized type does not imply upper bounds: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getLowerBounds() {
/*  5057 */         throw new IllegalStateException("A parameterized type does not imply lower bounds: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic getComponentType() {
/*  5064 */         throw new IllegalStateException("A parameterized type does not imply a component type: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeVariableSource getTypeVariableSource() {
/*  5071 */         throw new IllegalStateException("A parameterized type does not imply a type variable source: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getSymbol() {
/*  5078 */         throw new IllegalStateException("A parameterized type does not imply a symbol: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getTypeName() {
/*  5085 */         return toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getActualName() {
/*  5092 */         return toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isPrimitive() {
/*  5099 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isArray() {
/*  5106 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isRecord() {
/*  5113 */         return asErasure().isRecord();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean represents(Type param2Type) {
/*  5120 */         return equals(TypeDefinition.Sort.describe(param2Type));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Iterator<TypeDefinition> iterator() {
/*  5127 */         return new TypeDefinition.SuperClassIterator(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public <T> T accept(TypeDescription.Generic.Visitor<T> param2Visitor) {
/*  5134 */         return param2Visitor.onParameterizedType(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackSize getStackSize() {
/*  5141 */         return StackSize.SINGLE;
/*       */       }
/*       */       
/*       */       @Enhance("hashCode")
/*       */       public int hashCode()
/*       */       {
/*  5147 */         OfParameterizedType ofParameterizedType = this; int k = 1;
/*  5148 */         for (TypeDescription.Generic generic1 : ofParameterizedType.getTypeArguments()) {
/*  5149 */           k = k * 31 + generic1.hashCode();
/*       */         }
/*  5151 */         TypeDescription.Generic generic = ofParameterizedType.getOwnerType(); int j, i;
/*  5152 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : (k ^ ((generic == null) ? ofParameterizedType
/*  5153 */           .asErasure().hashCode() : generic
/*  5154 */           .hashCode())))) {
/*       */           i = this.hashCode;
/*       */         } else {
/*       */           this.hashCode = i;
/*       */         } 
/*  5159 */         return i; } public boolean equals(@MaybeNull Object param2Object) { if (this == param2Object)
/*  5160 */           return true; 
/*  5161 */         if (!(param2Object instanceof TypeDescription.Generic)) {
/*  5162 */           return false;
/*       */         }
/*       */         
/*  5165 */         if (!(param2Object = param2Object).getSort().isParameterized()) {
/*  5166 */           return false;
/*       */         }
/*  5168 */         TypeDescription.Generic generic1 = getOwnerType(), generic2 = param2Object.getOwnerType();
/*  5169 */         if (asErasure().equals(param2Object.asErasure()) && (generic1 != null || generic2 == null) && (generic1 == null || generic1
/*  5170 */           .equals(generic2)) && 
/*  5171 */           getTypeArguments().equals(param2Object.getTypeArguments())) return true; 
/*       */         return false; }
/*       */ 
/*       */       
/*       */       public String toString() {
/*  5176 */         StringBuilder stringBuilder = new StringBuilder();
/*  5177 */         RenderingDelegate.CURRENT.apply(stringBuilder, asErasure(), getOwnerType());
/*       */         TypeList.Generic generic;
/*  5179 */         if (!(generic = getTypeArguments()).isEmpty()) {
/*  5180 */           stringBuilder.append('<');
/*  5181 */           boolean bool = false;
/*  5182 */           for (TypeDescription.Generic generic1 : generic) {
/*  5183 */             if (bool) {
/*  5184 */               stringBuilder.append(", ");
/*       */             }
/*  5186 */             stringBuilder.append(generic1.getTypeName());
/*  5187 */             bool = true;
/*       */           } 
/*  5189 */           stringBuilder.append('>');
/*       */         } 
/*  5191 */         return stringBuilder.toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected enum RenderingDelegate
/*       */       {
/*  5203 */         FOR_LEGACY_VM
/*       */         {
/*       */           protected final void apply(StringBuilder param4StringBuilder, TypeDescription param4TypeDescription, @MaybeNull TypeDescription.Generic param4Generic) {
/*  5206 */             if (param4Generic != null) {
/*  5207 */               param4StringBuilder.append(param4Generic.getTypeName()).append('.').append(param4Generic.getSort().isParameterized() ? param4TypeDescription
/*  5208 */                   .getSimpleName() : param4TypeDescription
/*  5209 */                   .getName()); return;
/*       */             } 
/*  5211 */             param4StringBuilder.append(param4TypeDescription.getName());
/*       */           }
/*       */         },
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  5219 */         FOR_JAVA_8_CAPABLE_VM
/*       */         {
/*       */           protected final void apply(StringBuilder param4StringBuilder, TypeDescription param4TypeDescription, @MaybeNull TypeDescription.Generic param4Generic) {
/*  5222 */             if (param4Generic != null) {
/*  5223 */               param4StringBuilder.append(param4Generic.getTypeName()).append('$');
/*  5224 */               if (param4Generic.getSort().isParameterized()) {
/*  5225 */                 param4StringBuilder.append(param4TypeDescription.getName().replace(param4Generic.asErasure().getName() + "$", "")); return;
/*       */               } 
/*  5227 */               param4StringBuilder.append(param4TypeDescription.getSimpleName());
/*       */               return;
/*       */             } 
/*  5230 */             param4StringBuilder.append(param4TypeDescription.getName());
/*       */           }
/*       */         };
/*       */ 
/*       */         
/*       */         protected abstract void apply(StringBuilder param3StringBuilder, TypeDescription param3TypeDescription, @MaybeNull TypeDescription.Generic param3Generic);
/*       */ 
/*       */         
/*  5238 */         protected static final RenderingDelegate CURRENT = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V8) ? FOR_JAVA_8_CAPABLE_VM : FOR_LEGACY_VM;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         static {
/*       */         
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedType
/*       */         extends OfParameterizedType
/*       */       {
/*       */         private final ParameterizedType parameterizedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForLoadedType(ParameterizedType param3ParameterizedType) {
/*  5273 */           this(param3ParameterizedType, TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForLoadedType(ParameterizedType param3ParameterizedType, TypeDescription.Generic.AnnotationReader param3AnnotationReader) {
/*  5283 */           this.parameterizedType = param3ParameterizedType;
/*  5284 */           this.annotationReader = param3AnnotationReader;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getTypeArguments() {
/*  5291 */           return new ParameterArgumentTypeList(this.parameterizedType.getActualTypeArguments(), this.annotationReader);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*       */           Type type;
/*  5300 */           return ((type = this.parameterizedType.getOwnerType()) == null) ? TypeDescription.Generic.UNDEFINED : 
/*       */             
/*  5302 */             TypeDefinition.Sort.describe(type, this.annotationReader.ofOwnerType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  5309 */           return TypeDescription.ForLoadedType.of((Class)this.parameterizedType.getRawType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  5316 */           return this.annotationReader.asList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean represents(Type param3Type) {
/*  5323 */           return (this.parameterizedType == param3Type || super.represents(param3Type));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class ParameterArgumentTypeList
/*       */           extends TypeList.Generic.AbstractBase
/*       */         {
/*       */           private final Type[] argumentType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected ParameterArgumentTypeList(Type[] param4ArrayOfType, TypeDescription.Generic.AnnotationReader param4AnnotationReader) {
/*  5348 */             this.argumentType = param4ArrayOfType;
/*  5349 */             this.annotationReader = param4AnnotationReader;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic get(int param4Int) {
/*  5357 */             return TypeDefinition.Sort.describe(this.argumentType[param4Int], this.annotationReader.ofTypeArgument(param4Int));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int size() {
/*  5364 */             return this.argumentType.length;
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class Latent
/*       */         extends OfParameterizedType
/*       */       {
/*       */         private final TypeDescription rawType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         private final TypeDescription.Generic ownerType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final List<? extends TypeDescription.Generic> parameters;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AnnotationSource annotationSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Latent(TypeDescription param3TypeDescription, @MaybeNull TypeDescription.Generic param3Generic, List<? extends TypeDescription.Generic> param3List, AnnotationSource param3AnnotationSource) {
/*  5407 */           this.rawType = param3TypeDescription;
/*  5408 */           this.ownerType = param3Generic;
/*  5409 */           this.parameters = param3List;
/*  5410 */           this.annotationSource = param3AnnotationSource;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  5417 */           return this.rawType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*  5425 */           return this.ownerType;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getTypeArguments() {
/*  5432 */           return new TypeList.Generic.Explicit((List)this.parameters);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  5439 */           return this.annotationSource.getDeclaredAnnotations();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForReifiedType
/*       */         extends OfParameterizedType
/*       */       {
/*       */         private final TypeDescription.Generic parameterizedType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForReifiedType(TypeDescription.Generic param3Generic) {
/*  5461 */           this.parameterizedType = param3Generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getSuperClass() {
/*       */           TypeDescription.Generic generic;
/*  5470 */           return ((generic = super.getSuperClass()) == null) ? TypeDescription.Generic.UNDEFINED : new TypeDescription.Generic.LazyProjection.WithResolvedErasure(generic, TypeDescription.Generic.Visitor.Reifying.INHERITING);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getInterfaces() {
/*  5479 */           return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure((List<? extends TypeDescription.Generic>)super.getInterfaces(), TypeDescription.Generic.Visitor.Reifying.INHERITING);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  5486 */           return (FieldList<FieldDescription.InGenericShape>)new FieldList.TypeSubstituting(this, (List)super.getDeclaredFields(), TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  5493 */           return (MethodList<MethodDescription.InGenericShape>)new MethodList.TypeSubstituting(this, (List)super.getDeclaredMethods(), TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getTypeArguments() {
/*  5500 */           return new TypeList.Generic.ForDetachedTypes((List<? extends TypeDescription.Generic>)this.parameterizedType.getTypeArguments(), TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*       */           TypeDescription.Generic generic;
/*  5509 */           return ((generic = this.parameterizedType.getOwnerType()) == null) ? TypeDescription.Generic.UNDEFINED : generic
/*       */             
/*  5511 */             .<TypeDescription.Generic>accept(TypeDescription.Generic.Visitor.Reifying.INHERITING);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  5518 */           return this.parameterizedType.asErasure();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  5525 */           return (AnnotationList)new AnnotationList.Empty();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForGenerifiedErasure
/*       */         extends OfParameterizedType
/*       */       {
/*       */         private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForGenerifiedErasure(TypeDescription param3TypeDescription) {
/*  5545 */           this.typeDescription = param3TypeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public static TypeDescription.Generic of(TypeDescription param3TypeDescription) {
/*  5555 */           return (TypeDescription.Generic)(param3TypeDescription.isGenerified() ? new ForGenerifiedErasure(param3TypeDescription) : new TypeDescription.Generic.OfNonGenericType.ForErasure(param3TypeDescription));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  5564 */           return this.typeDescription;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getTypeArguments() {
/*  5571 */           return new TypeList.Generic.ForDetachedTypes((List<? extends TypeDescription.Generic>)this.typeDescription.getTypeVariables(), TypeDescription.Generic.Visitor.AnnotationStripper.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getOwnerType() {
/*       */           TypeDescription typeDescription;
/*  5580 */           return ((typeDescription = this.typeDescription.getDeclaringType()) == null) ? TypeDescription.Generic.UNDEFINED : 
/*       */             
/*  5582 */             of(typeDescription);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  5589 */           return (AnnotationList)new AnnotationList.Empty();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class OfTypeVariable
/*       */       extends AbstractBase
/*       */     {
/*       */       public TypeDefinition.Sort getSort() {
/*  5603 */         return TypeDefinition.Sort.VARIABLE;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription asErasure() {
/*       */         TypeList.Generic generic;
/*  5611 */         if ((generic = getUpperBounds()).isEmpty())
/*  5612 */           return TypeDescription.ForLoadedType.of(Object.class);  return ((TypeDescription.Generic)generic
/*  5613 */           .get(0)).asErasure();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getSuperClass() {
/*  5621 */         throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getInterfaces() {
/*  5628 */         throw new IllegalStateException("A type variable does not imply an interface type definition: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  5635 */         throw new IllegalStateException("A type variable does not imply field definitions: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  5642 */         throw new IllegalStateException("A type variable does not imply method definitions: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
/*  5649 */         throw new IllegalStateException("A type variable does not imply record component definitions: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic getComponentType() {
/*  5656 */         throw new IllegalStateException("A type variable does not imply a component type: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getTypeArguments() {
/*  5663 */         throw new IllegalStateException("A type variable does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic findBindingOf(TypeDescription.Generic param2Generic) {
/*  5670 */         throw new IllegalStateException("A type variable does not imply type arguments: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getLowerBounds() {
/*  5677 */         throw new IllegalStateException("A type variable does not imply lower bounds: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic getOwnerType() {
/*  5684 */         throw new IllegalStateException("A type variable does not imply an owner type: " + this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getTypeName() {
/*  5691 */         return toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getActualName() {
/*  5698 */         return getSymbol();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public <T> T accept(TypeDescription.Generic.Visitor<T> param2Visitor) {
/*  5705 */         return param2Visitor.onTypeVariable(this);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackSize getStackSize() {
/*  5712 */         return StackSize.SINGLE;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isArray() {
/*  5719 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isPrimitive() {
/*  5726 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isRecord() {
/*  5733 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean represents(Type param2Type) {
/*  5740 */         return equals(TypeDefinition.Sort.describe(param2Type));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Iterator<TypeDefinition> iterator() {
/*  5747 */         throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
/*       */       } @Enhance("hashCode")
/*       */       public int hashCode() {
/*       */         int i;
/*       */         OfTypeVariable ofTypeVariable;
/*       */         int j;
/*  5753 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : ((ofTypeVariable = this).getTypeVariableSource().hashCode() ^ ofTypeVariable.getSymbol().hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*  5758 */         if (this == param2Object)
/*  5759 */           return true; 
/*  5760 */         if (!(param2Object instanceof TypeDescription.Generic)) {
/*  5761 */           return false;
/*       */         }
/*       */         
/*  5764 */         if ((param2Object = param2Object).getSort().isTypeVariable() && 
/*  5765 */           getSymbol().equals(param2Object.getSymbol()) && 
/*  5766 */           getTypeVariableSource().equals(param2Object.getTypeVariableSource())) return true; 
/*       */         return false;
/*       */       }
/*       */       
/*       */       public String toString() {
/*  5771 */         return getSymbol();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class Symbolic
/*       */         extends TypeDescription.Generic.AbstractBase
/*       */       {
/*       */         private final String symbol;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AnnotationSource annotationSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Symbolic(String param3String, AnnotationSource param3AnnotationSource) {
/*  5796 */           this.symbol = param3String;
/*  5797 */           this.annotationSource = param3AnnotationSource;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDefinition.Sort getSort() {
/*  5804 */           return TypeDefinition.Sort.VARIABLE_SYMBOLIC;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public String getSymbol() {
/*  5811 */           return this.symbol;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  5818 */           return this.annotationSource.getDeclaredAnnotations();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  5825 */           throw new IllegalStateException("A symbolic type variable does not imply an erasure: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getUpperBounds() {
/*  5832 */           throw new IllegalStateException("A symbolic type variable does not imply an upper type bound: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeVariableSource getTypeVariableSource() {
/*  5839 */           throw new IllegalStateException("A symbolic type variable does not imply a variable source: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getSuperClass() {
/*  5847 */           throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getInterfaces() {
/*  5854 */           throw new IllegalStateException("A symbolic type variable does not imply an interface type definition: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  5861 */           throw new IllegalStateException("A symbolic type variable does not imply field definitions: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  5868 */           throw new IllegalStateException("A symbolic type variable does not imply method definitions: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
/*  5875 */           throw new IllegalStateException("A symbolic type variable does not imply record component definitions: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic getComponentType() {
/*  5882 */           throw new IllegalStateException("A symbolic type variable does not imply a component type: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getTypeArguments() {
/*  5889 */           throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic findBindingOf(TypeDescription.Generic param3Generic) {
/*  5896 */           throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getLowerBounds() {
/*  5903 */           throw new IllegalStateException("A symbolic type variable does not imply lower bounds: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription.Generic getOwnerType() {
/*  5910 */           throw new IllegalStateException("A symbolic type variable does not imply an owner type: " + this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public String getTypeName() {
/*  5917 */           return toString();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public String getActualName() {
/*  5924 */           return getSymbol();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public <T> T accept(TypeDescription.Generic.Visitor<T> param3Visitor) {
/*  5931 */           return param3Visitor.onTypeVariable(this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public StackSize getStackSize() {
/*  5938 */           return StackSize.SINGLE;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isArray() {
/*  5945 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isPrimitive() {
/*  5952 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isRecord() {
/*  5959 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean represents(Type param3Type) {
/*  5966 */           if (param3Type == null) {
/*  5967 */             throw new NullPointerException();
/*       */           }
/*  5969 */           return false;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterator<TypeDefinition> iterator() {
/*  5976 */           throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*  5981 */           return this.symbol.hashCode();
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*  5986 */           if (this == param3Object)
/*  5987 */             return true; 
/*  5988 */           if (!(param3Object instanceof TypeDescription.Generic)) {
/*  5989 */             return false;
/*       */           }
/*       */           
/*  5992 */           if ((param3Object = param3Object).getSort().isTypeVariable() && getSymbol().equals(param3Object.getSymbol())) return true;  return false;
/*       */         }
/*       */ 
/*       */         
/*       */         public String toString() {
/*  5997 */           return getSymbol();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedType
/*       */         extends OfTypeVariable
/*       */       {
/*       */         private final TypeVariable<?> typeVariable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForLoadedType(TypeVariable<?> param3TypeVariable) {
/*  6022 */           this(param3TypeVariable, TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForLoadedType(TypeVariable<?> param3TypeVariable, TypeDescription.Generic.AnnotationReader param3AnnotationReader) {
/*  6032 */           this.typeVariable = param3TypeVariable;
/*  6033 */           this.annotationReader = param3AnnotationReader;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeVariableSource getTypeVariableSource() {
/*       */           Object object;
/*  6041 */           if (object = this.typeVariable.getGenericDeclaration() instanceof Class)
/*  6042 */             return TypeDescription.ForLoadedType.of((Class)object); 
/*  6043 */           if (object instanceof Method)
/*  6044 */             return (TypeVariableSource)new MethodDescription.ForLoadedMethod((Method)object); 
/*  6045 */           if (object instanceof Constructor) {
/*  6046 */             return (TypeVariableSource)new MethodDescription.ForLoadedConstructor((Constructor)object);
/*       */           }
/*  6048 */           throw new IllegalStateException("Unknown declaration: " + object);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getUpperBounds() {
/*  6056 */           return new TypeVariableBoundList(this.typeVariable.getBounds(), this.annotationReader);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public String getSymbol() {
/*  6063 */           return this.typeVariable.getName();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  6070 */           return this.annotationReader.asList();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean represents(Type param3Type) {
/*  6077 */           return (this.typeVariable == param3Type || super.represents(param3Type));
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class TypeVariableBoundList
/*       */           extends TypeList.Generic.AbstractBase
/*       */         {
/*       */           private final Type[] bound;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeDescription.Generic.AnnotationReader annotationReader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected TypeVariableBoundList(Type[] param4ArrayOfType, TypeDescription.Generic.AnnotationReader param4AnnotationReader) {
/*  6102 */             this.bound = param4ArrayOfType;
/*  6103 */             this.annotationReader = param4AnnotationReader;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic get(int param4Int) {
/*  6110 */             return TypeDefinition.Sort.describe(this.bound[param4Int], this.annotationReader.ofTypeVariableBoundType(param4Int));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int size() {
/*  6117 */             return this.bound.length;
/*       */           }
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class WithAnnotationOverlay
/*       */         extends OfTypeVariable
/*       */       {
/*       */         private final TypeDescription.Generic typeVariable;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AnnotationSource annotationSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public WithAnnotationOverlay(TypeDescription.Generic param3Generic, AnnotationSource param3AnnotationSource) {
/*  6144 */           this.typeVariable = param3Generic;
/*  6145 */           this.annotationSource = param3AnnotationSource;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  6152 */           return this.annotationSource.getDeclaredAnnotations();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getUpperBounds() {
/*  6159 */           return this.typeVariable.getUpperBounds();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeVariableSource getTypeVariableSource() {
/*  6166 */           return this.typeVariable.getTypeVariableSource();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public String getSymbol() {
/*  6173 */           return this.typeVariable.getSymbol();
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class LazyProjection
/*       */       extends AbstractBase
/*       */     {
/*       */       public TypeDefinition.Sort getSort() {
/*  6196 */         return resolve().getSort();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
/*  6203 */         return resolve().getDeclaredFields();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
/*  6210 */         return resolve().getDeclaredMethods();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
/*  6217 */         return resolve().getRecordComponents();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getUpperBounds() {
/*  6224 */         return resolve().getUpperBounds();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getLowerBounds() {
/*  6231 */         return resolve().getLowerBounds();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getComponentType() {
/*  6239 */         return resolve().getComponentType();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeList.Generic getTypeArguments() {
/*  6246 */         return resolve().getTypeArguments();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic findBindingOf(TypeDescription.Generic param2Generic) {
/*  6254 */         return resolve().findBindingOf(param2Generic);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeVariableSource getTypeVariableSource() {
/*  6261 */         return resolve().getTypeVariableSource();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription.Generic getOwnerType() {
/*  6269 */         return resolve().getOwnerType();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getTypeName() {
/*  6276 */         return resolve().getTypeName();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getSymbol() {
/*  6283 */         return resolve().getSymbol();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getActualName() {
/*  6290 */         return resolve().getActualName();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public <T> T accept(TypeDescription.Generic.Visitor<T> param2Visitor) {
/*  6297 */         return resolve().accept(param2Visitor);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackSize getStackSize() {
/*  6304 */         return asErasure().getStackSize();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isArray() {
/*  6311 */         return asErasure().isArray();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isPrimitive() {
/*  6318 */         return asErasure().isPrimitive();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isRecord() {
/*  6325 */         return asErasure().isRecord();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean represents(Type param2Type) {
/*  6332 */         return resolve().represents(param2Type);
/*       */       } @Enhance("hashCode")
/*       */       public int hashCode() {
/*       */         int j;
/*       */         LazyProjection lazyProjection;
/*       */         int i;
/*  6338 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : (lazyProjection = this).resolve().hashCode())) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*  6343 */         return (this == param2Object || (param2Object instanceof TypeDefinition && resolve().equals(param2Object)));
/*       */       }
/*       */ 
/*       */       
/*       */       public String toString() {
/*  6348 */         return resolve().toString();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract TypeDescription.Generic resolve();
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static abstract class WithLazyNavigation
/*       */         extends LazyProjection
/*       */       {
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getSuperClass() {
/*  6364 */           return LazySuperClass.of(this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getInterfaces() {
/*  6371 */           return LazyInterfaceList.of(this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterator<TypeDefinition> iterator() {
/*  6378 */           return new TypeDefinition.SuperClassIterator(this);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class LazySuperClass
/*       */           extends WithLazyNavigation
/*       */         {
/*       */           private final TypeDescription.Generic.LazyProjection delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected LazySuperClass(TypeDescription.Generic.LazyProjection param4LazyProjection) {
/*  6397 */             this.delegate = param4LazyProjection;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @MaybeNull
/*       */           protected static TypeDescription.Generic of(TypeDescription.Generic.LazyProjection param4LazyProjection) {
/*  6408 */             return (param4LazyProjection.asErasure().getSuperClass() == null) ? TypeDescription.Generic.UNDEFINED : new LazySuperClass(param4LazyProjection);
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotationList getDeclaredAnnotations() {
/*  6417 */             return resolve().getDeclaredAnnotations();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming super class for given instance.")
/*       */           public TypeDescription asErasure() {
/*  6425 */             return this.delegate.asErasure().getSuperClass().asErasure();
/*       */           }
/*       */           
/*       */           @Enhance("resolved")
/*       */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming super class for given instance.")
/*       */           protected TypeDescription.Generic resolve() {
/*       */             TypeDescription.Generic generic;
/*  6432 */             if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : ((LazySuperClass)(generic = this)).delegate.resolve().getSuperClass())) == null) { generic = this.resolved; } else { this.resolved = generic; }  return generic;
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class LazyInterfaceType
/*       */           extends WithLazyNavigation
/*       */         {
/*       */           private final TypeDescription.Generic.LazyProjection delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeDescription.Generic rawInterface;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected LazyInterfaceType(TypeDescription.Generic.LazyProjection param4LazyProjection, int param4Int, TypeDescription.Generic param4Generic) {
/*  6464 */             this.delegate = param4LazyProjection;
/*  6465 */             this.index = param4Int;
/*  6466 */             this.rawInterface = param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public AnnotationList getDeclaredAnnotations() {
/*  6473 */             return resolve().getDeclaredAnnotations();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription asErasure() {
/*  6480 */             return this.rawInterface.asErasure();
/*       */           }
/*       */           
/*       */           @Enhance("resolved")
/*       */           protected TypeDescription.Generic resolve() {
/*       */             TypeDescription.Generic generic;
/*  6486 */             if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : ((LazyInterfaceType)(generic = this)).delegate.resolve().getInterfaces().get(((LazyInterfaceType)generic).index))) == null) { generic = this.resolved; } else { this.resolved = generic; }  return generic;
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static class LazyInterfaceList
/*       */           extends TypeList.Generic.AbstractBase
/*       */         {
/*       */           private final TypeDescription.Generic.LazyProjection delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           private final TypeList.Generic rawInterfaces;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected LazyInterfaceList(TypeDescription.Generic.LazyProjection param4LazyProjection, TypeList.Generic param4Generic) {
/*  6512 */             this.delegate = param4LazyProjection;
/*  6513 */             this.rawInterfaces = param4Generic;
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected static TypeList.Generic of(TypeDescription.Generic.LazyProjection param4LazyProjection) {
/*  6523 */             return new LazyInterfaceList(param4LazyProjection, param4LazyProjection.asErasure().getInterfaces());
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public TypeDescription.Generic get(int param4Int) {
/*  6530 */             return new TypeDescription.Generic.LazyProjection.WithLazyNavigation.LazyInterfaceType(this.delegate, param4Int, (TypeDescription.Generic)this.rawInterfaces.get(param4Int));
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           public int size() {
/*  6537 */             return this.rawInterfaces.size();
/*       */           }
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static abstract class OfAnnotatedElement
/*       */           extends WithLazyNavigation
/*       */         {
/*       */           public AnnotationList getDeclaredAnnotations() {
/*  6557 */             return getAnnotationReader().asList();
/*       */           }
/*       */ 
/*       */ 
/*       */           
/*       */           protected abstract TypeDescription.Generic.AnnotationReader getAnnotationReader();
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       public static abstract class WithEagerNavigation
/*       */         extends LazyProjection
/*       */       {
/*       */         @MaybeNull
/*       */         public TypeDescription.Generic getSuperClass() {
/*  6572 */           return resolve().getSuperClass();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getInterfaces() {
/*  6579 */           return resolve().getInterfaces();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public Iterator<TypeDefinition> iterator() {
/*  6586 */           return resolve().iterator();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected static abstract class OfAnnotatedElement
/*       */           extends WithEagerNavigation
/*       */         {
/*       */           public AnnotationList getDeclaredAnnotations() {
/*  6605 */             return getAnnotationReader().asList();
/*       */           }
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           protected abstract TypeDescription.Generic.AnnotationReader getAnnotationReader();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedSuperClass
/*       */         extends WithLazyNavigation.OfAnnotatedElement
/*       */       {
/*       */         private final Class<?> type;
/*       */ 
/*       */ 
/*       */         
/*       */         protected ForLoadedSuperClass(Class<?> param3Class) {
/*  6626 */           this.type = param3Class;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public static TypeDescription.Generic of(Class<?> param3Class) {
/*  6637 */           return (param3Class.getSuperclass() == null) ? TypeDescription.Generic.UNDEFINED : new ForLoadedSuperClass(param3Class);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @Enhance("resolved")
/*       */         protected TypeDescription.Generic resolve() {
/*       */           TypeDescription.Generic generic;
/*  6647 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : TypeDefinition.Sort.describe(((ForLoadedSuperClass)(generic = this)).type.getGenericSuperclass(), generic.getAnnotationReader()))) == null) { generic = this.resolved; } else { this.resolved = generic; }  return generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  6654 */           return TypeDescription.ForLoadedType.of(this.type.getSuperclass());
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  6659 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedSuperClass(this.type);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedFieldType
/*       */         extends WithEagerNavigation.OfAnnotatedElement
/*       */       {
/*       */         private final Field field;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForLoadedFieldType(Field param3Field) {
/*  6679 */           this.field = param3Field;
/*       */         }
/*       */         
/*       */         @Enhance("resolved")
/*       */         protected TypeDescription.Generic resolve() {
/*       */           TypeDescription.Generic generic;
/*  6685 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : TypeDefinition.Sort.describe(((ForLoadedFieldType)(generic = this)).field.getGenericType(), generic.getAnnotationReader()))) == null) { generic = this.resolved; } else { this.resolved = generic; }  return generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  6692 */           return TypeDescription.ForLoadedType.of(this.field.getType());
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  6697 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedField(this.field);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class ForLoadedReturnType
/*       */         extends WithEagerNavigation.OfAnnotatedElement
/*       */       {
/*       */         private final Method method;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public ForLoadedReturnType(Method param3Method) {
/*  6717 */           this.method = param3Method;
/*       */         }
/*       */         
/*       */         @Enhance("resolved")
/*       */         protected TypeDescription.Generic resolve() {
/*       */           TypeDescription.Generic generic;
/*  6723 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : TypeDefinition.Sort.describe(((ForLoadedReturnType)(generic = this)).method.getGenericReturnType(), generic.getAnnotationReader()))) == null) { generic = this.resolved; } else { this.resolved = generic; }  return generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  6730 */           return TypeDescription.ForLoadedType.of(this.method.getReturnType());
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  6735 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedMethodReturnType(this.method);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class OfConstructorParameter
/*       */         extends WithEagerNavigation.OfAnnotatedElement
/*       */       {
/*       */         private final Constructor<?> constructor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Class<?>[] erasure;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not modified by class contract.")
/*       */         public OfConstructorParameter(Constructor<?> param3Constructor, int param3Int, Class<?>[] param3ArrayOfClass) {
/*  6768 */           this.constructor = param3Constructor;
/*  6769 */           this.index = param3Int;
/*  6770 */           this.erasure = param3ArrayOfClass;
/*       */         }
/*       */         
/*       */         @Enhance("delegate")
/*       */         protected TypeDescription.Generic resolve() {
/*       */           TypeDescription.Generic generic;
/*  6776 */           Type[] arrayOfType = ((OfConstructorParameter)(generic = this)).constructor.getGenericParameterTypes();
/*  6777 */           if ((generic = (TypeDescription.Generic)(((generic = this.delegate) != null) ? null : ((((OfConstructorParameter)generic).erasure.length == arrayOfType.length) ? 
/*  6778 */             TypeDefinition.Sort.describe(arrayOfType[((OfConstructorParameter)generic).index], generic.getAnnotationReader()) : 
/*  6779 */             TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((OfConstructorParameter)generic).erasure[((OfConstructorParameter)generic).index])))) == null) {
/*       */             generic = this.delegate;
/*       */           } else {
/*       */             this.delegate = generic;
/*       */           } 
/*       */           return generic;
/*       */         } public TypeDescription asErasure() {
/*  6786 */           return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  6791 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.constructor, this.index);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class OfMethodParameter
/*       */         extends WithEagerNavigation.OfAnnotatedElement
/*       */       {
/*       */         private final Method method;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final int index;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final Class<?>[] erasure;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not modified by class contract.")
/*       */         public OfMethodParameter(Method param3Method, int param3Int, Class<?>[] param3ArrayOfClass) {
/*  6824 */           this.method = param3Method;
/*  6825 */           this.index = param3Int;
/*  6826 */           this.erasure = param3ArrayOfClass;
/*       */         }
/*       */         
/*       */         @Enhance("resolved")
/*       */         protected TypeDescription.Generic resolve() {
/*       */           TypeDescription.Generic generic;
/*  6832 */           Type[] arrayOfType = ((OfMethodParameter)(generic = this)).method.getGenericParameterTypes();
/*  6833 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : ((((OfMethodParameter)generic).erasure.length == arrayOfType.length) ? 
/*  6834 */             TypeDefinition.Sort.describe(arrayOfType[((OfMethodParameter)generic).index], generic.getAnnotationReader()) : 
/*  6835 */             TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((OfMethodParameter)generic).erasure[((OfMethodParameter)generic).index])))) == null) {
/*       */             generic = this.resolved;
/*       */           } else {
/*       */             this.resolved = generic;
/*       */           } 
/*       */           return generic;
/*       */         } public TypeDescription asErasure() {
/*  6842 */           return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  6847 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.method, this.index);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class OfRecordComponent
/*       */         extends WithEagerNavigation.OfAnnotatedElement
/*       */       {
/*       */         private final Object recordComponent;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfRecordComponent(Object param3Object) {
/*  6867 */           this.recordComponent = param3Object;
/*       */         }
/*       */ 
/*       */         
/*       */         @Enhance("resolved")
/*       */         protected TypeDescription.Generic resolve() {
/*  6873 */           TypeDescription.Generic generic = this; if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : TypeDefinition.Sort.describe(RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getGenericType(((OfRecordComponent)generic).recordComponent), generic.getAnnotationReader()))) == null) { generic = this.resolved; } else { this.resolved = generic; }  return generic;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  6880 */           return TypeDescription.ForLoadedType.of(RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getType(this.recordComponent));
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  6885 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedRecordComponent(this.recordComponent);
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static class WithResolvedErasure
/*       */         extends WithEagerNavigation
/*       */       {
/*       */         private final TypeDescription.Generic delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         private final AnnotationSource annotationSource;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public WithResolvedErasure(TypeDescription.Generic param3Generic, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param3Visitor) {
/*  6916 */           this(param3Generic, param3Visitor, param3Generic);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public WithResolvedErasure(TypeDescription.Generic param3Generic, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param3Visitor, AnnotationSource param3AnnotationSource) {
/*  6927 */           this.delegate = param3Generic;
/*  6928 */           this.visitor = param3Visitor;
/*  6929 */           this.annotationSource = param3AnnotationSource;
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  6936 */           return this.annotationSource.getDeclaredAnnotations();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription asErasure() {
/*  6943 */           return this.delegate.asErasure();
/*       */         }
/*       */         
/*       */         @Enhance("resolved")
/*       */         protected TypeDescription.Generic resolve() {
/*       */           TypeDescription.Generic generic;
/*  6949 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : ((WithResolvedErasure)(generic = this)).delegate.accept((TypeDescription.Generic.Visitor)((WithResolvedErasure)generic).visitor))) == null) { generic = this.resolved; } else { this.resolved = generic; }  return generic;
/*       */         }
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     public static abstract class Builder
/*       */     {
/*       */       @AlwaysNull
/*  6964 */       private static final Type UNDEFINED = null;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected final List<? extends AnnotationDescription> annotations;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected Builder(List<? extends AnnotationDescription> param2List) {
/*  6977 */         this.annotations = param2List;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder of(Type param2Type) {
/*  6987 */         return of(TypeDefinition.Sort.describe(param2Type));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder of(TypeDescription.Generic param2Generic) {
/*  6997 */         return param2Generic.<Builder>accept(Visitor.INSTANCE);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder rawType(Class<?> param2Class) {
/*  7007 */         return rawType(TypeDescription.ForLoadedType.of(param2Class));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder rawType(TypeDescription param2TypeDescription) {
/*  7017 */         return new OfNonGenericType(param2TypeDescription);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder rawType(Class<?> param2Class, @MaybeNull TypeDescription.Generic param2Generic) {
/*  7028 */         return rawType(TypeDescription.ForLoadedType.of(param2Class), param2Generic);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder rawType(TypeDescription param2TypeDescription, @MaybeNull TypeDescription.Generic param2Generic) {
/*       */         TypeDescription typeDescription;
/*  7040 */         if ((typeDescription = param2TypeDescription.getDeclaringType()) == null && param2Generic != null)
/*  7041 */           throw new IllegalArgumentException(param2TypeDescription + " does not have a declaring type: " + param2Generic); 
/*  7042 */         if (typeDescription != null && (param2Generic == null || !typeDescription.equals(param2Generic.asErasure()))) {
/*  7043 */           throw new IllegalArgumentException(param2Generic + " is not the declaring type of " + param2TypeDescription);
/*       */         }
/*  7045 */         return new OfNonGenericType(param2TypeDescription, param2Generic);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static TypeDescription.Generic unboundWildcard() {
/*  7054 */         return unboundWildcard(Collections.emptySet());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static TypeDescription.Generic unboundWildcard(Annotation... param2VarArgs) {
/*  7064 */         return unboundWildcard(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static TypeDescription.Generic unboundWildcard(List<? extends Annotation> param2List) {
/*  7074 */         return unboundWildcard((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param2List));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static TypeDescription.Generic unboundWildcard(AnnotationDescription... param2VarArgs) {
/*  7084 */         return unboundWildcard(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static TypeDescription.Generic unboundWildcard(Collection<? extends AnnotationDescription> param2Collection) {
/*  7094 */         return TypeDescription.Generic.OfWildcardType.Latent.unbounded((AnnotationSource)new AnnotationSource.Explicit(new ArrayList<AnnotationDescription>(param2Collection)));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder typeVariable(String param2String) {
/*  7104 */         return new OfTypeVariable(param2String);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder parameterizedType(Class<?> param2Class, Type... param2VarArgs) {
/*  7115 */         return parameterizedType(param2Class, Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder parameterizedType(Class<?> param2Class, List<? extends Type> param2List) {
/*  7126 */         return parameterizedType(param2Class, UNDEFINED, param2List);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder parameterizedType(Class<?> param2Class, @MaybeNull Type param2Type, List<? extends Type> param2List) {
/*  7140 */         return parameterizedType(TypeDescription.ForLoadedType.of(param2Class), (param2Type == null) ? null : 
/*       */ 
/*       */             
/*  7143 */             TypeDefinition.Sort.describe(param2Type), (Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param2List));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder parameterizedType(TypeDescription param2TypeDescription, TypeDefinition... param2VarArgs) {
/*  7155 */         return parameterizedType(param2TypeDescription, Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder parameterizedType(TypeDescription param2TypeDescription, Collection<? extends TypeDefinition> param2Collection) {
/*  7166 */         return parameterizedType(param2TypeDescription, TypeDescription.Generic.UNDEFINED, param2Collection);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static Builder parameterizedType(TypeDescription param2TypeDescription, @MaybeNull TypeDescription.Generic param2Generic, Collection<? extends TypeDefinition> param2Collection) {
/*  7180 */         TypeDescription typeDescription = param2TypeDescription.getDeclaringType();
/*  7181 */         if (param2Generic == null && typeDescription != null && param2TypeDescription.isStatic()) {
/*  7182 */           param2Generic = typeDescription.asGenericType();
/*       */         }
/*  7184 */         if (!param2TypeDescription.represents(TargetType.class)) {
/*  7185 */           if (!param2TypeDescription.isGenerified())
/*  7186 */             throw new IllegalArgumentException(param2TypeDescription + " is not a parameterized type"); 
/*  7187 */           if (param2Generic == null && typeDescription != null && !param2TypeDescription.isStatic())
/*  7188 */             throw new IllegalArgumentException(param2TypeDescription + " requires an owner type"); 
/*  7189 */           if (param2Generic != null && !param2Generic.asErasure().equals(typeDescription))
/*  7190 */             throw new IllegalArgumentException(param2Generic + " does not represent required owner for " + param2TypeDescription); 
/*  7191 */           if (param2Generic != null && (param2TypeDescription.isStatic() ^ param2Generic.getSort().isNonGeneric()) != 0)
/*  7192 */             throw new IllegalArgumentException(param2Generic + " does not define the correct parameters for owning " + param2TypeDescription); 
/*  7193 */           if (param2TypeDescription.getTypeVariables().size() != param2Collection.size()) {
/*  7194 */             throw new IllegalArgumentException(param2Collection + " does not contain number of required parameters for " + param2TypeDescription);
/*       */           }
/*       */         } 
/*  7197 */         return new OfParameterizedType(param2TypeDescription, param2Generic, (List<? extends TypeDescription.Generic>)new TypeList.Generic.Explicit(new ArrayList<TypeDefinition>(param2Collection)));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardUpperBound() {
/*  7206 */         return asWildcardUpperBound(Collections.emptySet());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardUpperBound(Annotation... param2VarArgs) {
/*  7216 */         return asWildcardUpperBound(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardUpperBound(List<? extends Annotation> param2List) {
/*  7226 */         return asWildcardUpperBound((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param2List));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardUpperBound(AnnotationDescription... param2VarArgs) {
/*  7236 */         return asWildcardUpperBound(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardUpperBound(Collection<? extends AnnotationDescription> param2Collection) {
/*  7246 */         return TypeDescription.Generic.OfWildcardType.Latent.boundedAbove(build(), (AnnotationSource)new AnnotationSource.Explicit(new ArrayList<AnnotationDescription>(param2Collection)));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardLowerBound() {
/*  7255 */         return asWildcardLowerBound(Collections.emptySet());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardLowerBound(Annotation... param2VarArgs) {
/*  7265 */         return asWildcardLowerBound(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardLowerBound(List<? extends Annotation> param2List) {
/*  7275 */         return asWildcardLowerBound((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param2List));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardLowerBound(AnnotationDescription... param2VarArgs) {
/*  7285 */         return asWildcardLowerBound(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic asWildcardLowerBound(Collection<? extends AnnotationDescription> param2Collection) {
/*  7295 */         return TypeDescription.Generic.OfWildcardType.Latent.boundedBelow(build(), (AnnotationSource)new AnnotationSource.Explicit(new ArrayList<AnnotationDescription>(param2Collection)));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder asArray() {
/*  7304 */         return asArray(1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder asArray(int param2Int) {
/*  7314 */         if (param2Int <= 0) {
/*  7315 */           throw new IllegalArgumentException("Cannot define an array of a non-positive arity: " + param2Int);
/*       */         }
/*  7317 */         TypeDescription.Generic generic = build();
/*  7318 */         while (--param2Int > 0) {
/*  7319 */           generic = new TypeDescription.Generic.OfGenericArray.Latent(generic, (AnnotationSource)AnnotationSource.Empty.INSTANCE);
/*       */         }
/*  7321 */         return new OfGenericArrayType(generic);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder annotate(Annotation... param2VarArgs) {
/*  7331 */         return annotate(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder annotate(List<? extends Annotation> param2List) {
/*  7341 */         return annotate((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param2List));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder annotate(AnnotationDescription... param2VarArgs) {
/*  7351 */         return annotate(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder annotate(Collection<? extends AnnotationDescription> param2Collection) {
/*  7361 */         return doAnnotate(new ArrayList<AnnotationDescription>(param2Collection));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected abstract Builder doAnnotate(List<? extends AnnotationDescription> param2List);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic build() {
/*  7378 */         return doBuild();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic build(Annotation... param2VarArgs) {
/*  7388 */         return build(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic build(List<? extends Annotation> param2List) {
/*  7398 */         return build((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param2List));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic build(AnnotationDescription... param2VarArgs) {
/*  7408 */         return build(Arrays.asList(param2VarArgs));
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic build(Collection<? extends AnnotationDescription> param2Collection) {
/*  7418 */         return doAnnotate(new ArrayList<AnnotationDescription>(param2Collection)).doBuild();
/*       */       }
/*       */ 
/*       */       
/*       */       protected abstract TypeDescription.Generic doBuild();
/*       */ 
/*       */       
/*       */       public boolean equals(@MaybeNull Object param2Object) {
/*       */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.annotations.equals(((Builder)param2Object).annotations))));
/*       */       }
/*       */       
/*       */       public int hashCode() {
/*       */         return getClass().hashCode() * 31 + this.annotations.hashCode();
/*       */       }
/*       */       
/*       */       protected enum Visitor
/*       */         implements TypeDescription.Generic.Visitor<Builder>
/*       */       {
/*  7436 */         INSTANCE;
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public final TypeDescription.Generic.Builder onGenericArray(TypeDescription.Generic param3Generic) {
/*  7443 */           return new TypeDescription.Generic.Builder.OfGenericArrayType(param3Generic.getComponentType(), (List<? extends AnnotationDescription>)param3Generic.getDeclaredAnnotations());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.Builder onWildcard(TypeDescription.Generic param3Generic) {
/*  7450 */           throw new IllegalArgumentException("Cannot resolve wildcard type " + param3Generic + " to builder");
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.Builder onParameterizedType(TypeDescription.Generic param3Generic) {
/*  7457 */           return new TypeDescription.Generic.Builder.OfParameterizedType(param3Generic.asErasure(), param3Generic
/*  7458 */               .getOwnerType(), (List<? extends TypeDescription.Generic>)param3Generic
/*  7459 */               .getTypeArguments(), (List<? extends AnnotationDescription>)param3Generic
/*  7460 */               .getDeclaredAnnotations());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public final TypeDescription.Generic.Builder onTypeVariable(TypeDescription.Generic param3Generic) {
/*  7467 */           return new TypeDescription.Generic.Builder.OfTypeVariable(param3Generic.getSymbol(), (List<? extends AnnotationDescription>)param3Generic.getDeclaredAnnotations());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */         public final TypeDescription.Generic.Builder onNonGenericType(TypeDescription.Generic param3Generic) {
/*  7475 */           if (param3Generic.isArray())
/*  7476 */             return ((TypeDescription.Generic.Builder)param3Generic.getComponentType().<TypeDescription.Generic.Builder>accept(this)).asArray().annotate((Collection<? extends AnnotationDescription>)param3Generic.getDeclaredAnnotations());  return new TypeDescription.Generic.Builder.OfNonGenericType(param3Generic
/*  7477 */               .asErasure(), param3Generic.getOwnerType(), (List<? extends AnnotationDescription>)param3Generic.getDeclaredAnnotations());
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class OfNonGenericType
/*       */         extends Builder
/*       */       {
/*       */         private final TypeDescription typeDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final TypeDescription.Generic ownerType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfNonGenericType(TypeDescription param3TypeDescription) {
/*  7505 */           this(param3TypeDescription, param3TypeDescription.getDeclaringType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfNonGenericType(TypeDescription param3TypeDescription1, @MaybeNull TypeDescription param3TypeDescription2) {
/*  7515 */           this(param3TypeDescription1, (param3TypeDescription2 == null) ? TypeDescription.Generic.UNDEFINED : param3TypeDescription2
/*       */               
/*  7517 */               .asGenericType());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfNonGenericType(TypeDescription param3TypeDescription, @MaybeNull TypeDescription.Generic param3Generic) {
/*  7527 */           this(param3TypeDescription, param3Generic, Collections.emptyList());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfNonGenericType(TypeDescription param3TypeDescription, @MaybeNull TypeDescription.Generic param3Generic, List<? extends AnnotationDescription> param3List) {
/*  7540 */           super(param3List);
/*  7541 */           this.ownerType = param3Generic;
/*  7542 */           this.typeDescription = param3TypeDescription;
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.Builder doAnnotate(List<? extends AnnotationDescription> param3List) {
/*  7547 */           return new OfNonGenericType(this.typeDescription, this.ownerType, CompoundList.of(this.annotations, param3List));
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic doBuild() {
/*  7552 */           if (this.typeDescription.represents(void.class) && !this.annotations.isEmpty()) {
/*  7553 */             throw new IllegalArgumentException("The void non-type cannot be annotated");
/*       */           }
/*  7555 */           return new TypeDescription.Generic.OfNonGenericType.Latent(this.typeDescription, this.ownerType, (AnnotationSource)new AnnotationSource.Explicit(this.annotations));
/*       */         }
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           TypeDescription.Generic generic;
/*       */           if (!super.equals(param3Object))
/*       */             return false; 
/*       */           if (this == param3Object)
/*       */             return true; 
/*       */           if (param3Object == null)
/*       */             return false; 
/*       */           if (getClass() != param3Object.getClass())
/*       */             return false; 
/*       */           if (!this.typeDescription.equals(((OfNonGenericType)param3Object).typeDescription))
/*       */             return false; 
/*       */           param3Object = ((OfNonGenericType)param3Object).ownerType;
/*       */           if (param3Object != null) {
/*       */             if ((generic = this.ownerType) != null) {
/*       */               if (!generic.equals(param3Object))
/*       */                 return false; 
/*       */             } else {
/*       */               return false;
/*       */             } 
/*       */           } else if ((generic = this.ownerType) != null) {
/*       */             return false;
/*       */           } 
/*       */           return true;
/*       */         }
/*       */         public int hashCode() {
/*       */           TypeDescription.Generic generic;
/*       */           if ((generic = this.ownerType) != null);
/*       */           return (super.hashCode() * 31 + this.typeDescription.hashCode()) * 31 + generic.hashCode();
/*       */         } }
/*       */       @Enhance
/*       */       protected static class OfParameterizedType extends Builder { private final TypeDescription rawType; @MaybeNull
/*       */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*       */         private final TypeDescription.Generic ownerType; private final List<? extends TypeDescription.Generic> parameterTypes;
/*       */         protected OfParameterizedType(TypeDescription param3TypeDescription, @MaybeNull TypeDescription.Generic param3Generic, List<? extends TypeDescription.Generic> param3List) {
/*  7592 */           this(param3TypeDescription, param3Generic, param3List, Collections.emptyList());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfParameterizedType(TypeDescription param3TypeDescription, @MaybeNull TypeDescription.Generic param3Generic, List<? extends TypeDescription.Generic> param3List, List<? extends AnnotationDescription> param3List1) {
/*  7607 */           super(param3List1);
/*  7608 */           this.rawType = param3TypeDescription;
/*  7609 */           this.ownerType = param3Generic;
/*  7610 */           this.parameterTypes = param3List;
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.Builder doAnnotate(List<? extends AnnotationDescription> param3List) {
/*  7615 */           return new OfParameterizedType(this.rawType, this.ownerType, this.parameterTypes, CompoundList.of(this.annotations, param3List));
/*       */         }
/*       */         
/*       */         protected TypeDescription.Generic doBuild()
/*       */         {
/*  7620 */           return new TypeDescription.Generic.OfParameterizedType.Latent(this.rawType, this.ownerType, this.parameterTypes, (AnnotationSource)new AnnotationSource.Explicit(this.annotations));
/*       */         } public boolean equals(@MaybeNull Object param3Object) { TypeDescription.Generic generic2; if (!super.equals(param3Object))
/*       */             return false;  if (this == param3Object)
/*       */             return true;  if (param3Object == null)
/*       */             return false;  if (getClass() != param3Object.getClass())
/*       */             return false;  if (!this.rawType.equals(((OfParameterizedType)param3Object).rawType))
/*       */             return false; 
/*       */           TypeDescription.Generic generic1 = ((OfParameterizedType)param3Object).ownerType;
/*       */           if (generic1 != null) {
/*       */             if ((generic2 = this.ownerType) != null) {
/*       */               if (!generic2.equals(generic1))
/*       */                 return false; 
/*       */             } else {
/*       */               return false;
/*       */             } 
/*       */           } else if ((generic2 = this.ownerType) != null) {
/*       */             return false;
/*       */           } 
/*       */           return !!this.parameterTypes.equals(((OfParameterizedType)param3Object).parameterTypes); } public int hashCode() { TypeDescription.Generic generic;
/*       */           if ((generic = this.ownerType) != null);
/*       */           return ((super.hashCode() * 31 + this.rawType.hashCode()) * 31 + generic.hashCode()) * 31 + this.parameterTypes.hashCode(); } } @Enhance protected static class OfGenericArrayType extends Builder { private final TypeDescription.Generic componentType;
/*  7641 */         protected OfGenericArrayType(TypeDescription.Generic param3Generic) { this(param3Generic, Collections.emptyList()); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfGenericArrayType(TypeDescription.Generic param3Generic, List<? extends AnnotationDescription> param3List) {
/*  7651 */           super(param3List);
/*  7652 */           this.componentType = param3Generic;
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.Builder doAnnotate(List<? extends AnnotationDescription> param3List) {
/*  7657 */           return new OfGenericArrayType(this.componentType, CompoundList.of(this.annotations, param3List));
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic doBuild() {
/*  7662 */           return new TypeDescription.Generic.OfGenericArray.Latent(this.componentType, (AnnotationSource)new AnnotationSource.Explicit(this.annotations));
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.componentType.equals(((OfGenericArrayType)param3Object).componentType)))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.componentType.hashCode();
/*       */         } }
/*       */ 
/*       */       
/*       */       @Enhance
/*       */       protected static class OfTypeVariable
/*       */         extends Builder
/*       */       {
/*       */         private final String symbol;
/*       */         
/*       */         protected OfTypeVariable(String param3String) {
/*  7683 */           this(param3String, Collections.emptyList());
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected OfTypeVariable(String param3String, List<? extends AnnotationDescription> param3List) {
/*  7693 */           super(param3List);
/*  7694 */           this.symbol = param3String;
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic.Builder doAnnotate(List<? extends AnnotationDescription> param3List) {
/*  7699 */           return new OfTypeVariable(this.symbol, CompoundList.of(this.annotations, param3List));
/*       */         }
/*       */ 
/*       */         
/*       */         protected TypeDescription.Generic doBuild() {
/*  7704 */           return new TypeDescription.Generic.OfTypeVariable.Symbolic(this.symbol, (AnnotationSource)new AnnotationSource.Explicit(this.annotations));
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean equals(@MaybeNull Object param3Object) {
/*       */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.symbol.equals(((OfTypeVariable)param3Object).symbol)))));
/*       */         }
/*       */ 
/*       */         
/*       */         public int hashCode() {
/*       */           return super.hashCode() * 31 + this.symbol.hashCode();
/*       */         }
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static abstract class AbstractBase
/*       */     extends TypeVariableSource.AbstractBase
/*       */     implements TypeDescription
/*       */   {
/*       */     public static final boolean RAW_TYPES;
/*       */     private static final boolean ACCESS_CONTROLLER;
/*       */     
/*       */     static {
/*       */       boolean bool;
/*       */       
/*  7731 */       try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*       */       
/*       */       try {
/*       */         bool = Boolean.parseBoolean(doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("net.bytebuddy.raw")));
/*       */       } catch (Exception exception) {
/*       */         bool = false;
/*       */       } 
/*       */       RAW_TYPES = bool;
/*       */     }
/*       */     @Enhance
/*       */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/*  7742 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     private static boolean isAssignable(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/*  7757 */       if (param1TypeDescription1.equals(param1TypeDescription2)) {
/*  7758 */         return true;
/*       */       }
/*       */       
/*  7761 */       if (param1TypeDescription2.isArray()) {
/*  7762 */         if (param1TypeDescription1.isArray())
/*  7763 */           return isAssignable(param1TypeDescription1.getComponentType(), param1TypeDescription2.getComponentType());  if (param1TypeDescription1
/*  7764 */           .represents(Object.class) || ARRAY_INTERFACES.contains(param1TypeDescription1.asGenericType())) return true; 
/*       */         return false;
/*       */       } 
/*  7767 */       if (param1TypeDescription1.represents(Object.class)) {
/*  7768 */         return !param1TypeDescription2.isPrimitive();
/*       */       }
/*       */       
/*       */       TypeDescription.Generic generic;
/*  7772 */       if ((generic = param1TypeDescription2.getSuperClass()) != null && param1TypeDescription1.isAssignableFrom(generic.asErasure())) {
/*  7773 */         return true;
/*       */       }
/*       */       
/*  7776 */       if (param1TypeDescription1.isInterface()) {
/*  7777 */         for (TypeDescription typeDescription : param1TypeDescription2.getInterfaces().asErasures()) {
/*  7778 */           if (param1TypeDescription1.isAssignableFrom(typeDescription)) {
/*  7779 */             return true;
/*       */           }
/*       */         } 
/*       */       }
/*       */       
/*  7784 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAssignableFrom(Class<?> param1Class) {
/*  7791 */       return isAssignableFrom(TypeDescription.ForLoadedType.of(param1Class));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAssignableFrom(TypeDescription param1TypeDescription) {
/*  7798 */       return isAssignable(this, param1TypeDescription);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAssignableTo(Class<?> param1Class) {
/*  7805 */       return isAssignableTo(TypeDescription.ForLoadedType.of(param1Class));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAssignableTo(TypeDescription param1TypeDescription) {
/*  7812 */       return isAssignable(param1TypeDescription, this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isInHierarchyWith(Class<?> param1Class) {
/*  7819 */       return (isAssignableTo(param1Class) || isAssignableFrom(param1Class));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isInHierarchyWith(TypeDescription param1TypeDescription) {
/*  7826 */       return (isAssignableTo(param1TypeDescription) || isAssignableFrom(param1TypeDescription));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription asErasure() {
/*  7833 */       return this;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription.Generic asGenericType() {
/*  7840 */       return new TypeDescription.Generic.OfNonGenericType.ForErasure(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDefinition.Sort getSort() {
/*  7847 */       return TypeDefinition.Sort.NON_GENERIC;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isInstance(Object param1Object) {
/*  7854 */       return isAssignableFrom(param1Object.getClass());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAnnotationValue(Object param1Object) {
/*  7861 */       if ((represents(Class.class) && param1Object instanceof TypeDescription) || (param1Object instanceof AnnotationDescription && ((AnnotationDescription)param1Object)
/*  7862 */         .getAnnotationType().equals(this)) || (param1Object instanceof EnumerationDescription && ((EnumerationDescription)param1Object)
/*  7863 */         .getEnumerationType().equals(this)) || (
/*  7864 */         represents(String.class) && param1Object instanceof String) || (
/*  7865 */         represents(boolean.class) && param1Object instanceof Boolean) || (
/*  7866 */         represents(byte.class) && param1Object instanceof Byte) || (
/*  7867 */         represents(short.class) && param1Object instanceof Short) || (
/*  7868 */         represents(char.class) && param1Object instanceof Character) || (
/*  7869 */         represents(int.class) && param1Object instanceof Integer) || (
/*  7870 */         represents(long.class) && param1Object instanceof Long) || (
/*  7871 */         represents(float.class) && param1Object instanceof Float) || (
/*  7872 */         represents(double.class) && param1Object instanceof Double) || (
/*  7873 */         represents(String[].class) && param1Object instanceof String[]) || (
/*  7874 */         represents(boolean[].class) && param1Object instanceof boolean[]) || (
/*  7875 */         represents(byte[].class) && param1Object instanceof byte[]) || (
/*  7876 */         represents(short[].class) && param1Object instanceof short[]) || (
/*  7877 */         represents(char[].class) && param1Object instanceof char[]) || (
/*  7878 */         represents(int[].class) && param1Object instanceof int[]) || (
/*  7879 */         represents(long[].class) && param1Object instanceof long[]) || (
/*  7880 */         represents(float[].class) && param1Object instanceof float[]) || (
/*  7881 */         represents(double[].class) && param1Object instanceof double[]) || (
/*  7882 */         represents(Class[].class) && param1Object instanceof TypeDescription[]))
/*  7883 */         return true; 
/*  7884 */       if (isAssignableTo(Annotation[].class) && param1Object instanceof AnnotationDescription[]) {
/*  7885 */         int i; byte b; for (i = (param1Object = param1Object).length, b = 0; b < i; b++) {
/*  7886 */           Object object; if (!(object = param1Object[b]).getAnnotationType().equals(getComponentType())) {
/*  7887 */             return false;
/*       */           }
/*       */         } 
/*  7890 */         return true;
/*  7891 */       }  if (isAssignableTo(Enum[].class) && param1Object instanceof EnumerationDescription[]) {
/*  7892 */         int i; byte b; for (i = (param1Object = param1Object).length, b = 0; b < i; b++) {
/*  7893 */           Object object; if (!(object = param1Object[b]).getEnumerationType().equals(getComponentType())) {
/*  7894 */             return false;
/*       */           }
/*       */         } 
/*  7897 */         return true;
/*       */       } 
/*  7899 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getInternalName() {
/*  7907 */       return getName().replace('.', '/');
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getActualModifiers(boolean param1Boolean) {
/*  7916 */       int i = getModifiers() | (getDeclaredAnnotations().isAnnotationPresent(Deprecated.class) ? 131072 : 0) | (isRecord() ? 65536 : 0) | (param1Boolean ? 32 : 0);
/*       */       
/*  7918 */       if (isPrivate())
/*  7919 */         return i & 0xFFFFFFF5; 
/*  7920 */       if (isProtected()) {
/*  7921 */         return i & 0xFFFFFFF3 | 0x1;
/*       */       }
/*  7923 */       return i & 0xFFFFFFF7;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public String getGenericSignature() {
/*       */       try {
/*  7933 */         SignatureWriter signatureWriter = new SignatureWriter();
/*  7934 */         boolean bool = false;
/*  7935 */         for (TypeDescription.Generic generic1 : getTypeVariables()) {
/*  7936 */           signatureWriter.visitFormalTypeParameter(generic1.getSymbol());
/*  7937 */           for (Iterator<TypeDescription.Generic> iterator1 = generic1.getUpperBounds().iterator(); iterator1.hasNext();) {
/*  7938 */             (generic2 = iterator1.next()).accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(generic2.asErasure().isInterface() ? signatureWriter
/*  7939 */                   .visitInterfaceBound() : signatureWriter
/*  7940 */                   .visitClassBound()));
/*       */           }
/*  7942 */           bool = true;
/*       */         } 
/*       */         
/*       */         TypeDescription.Generic generic;
/*  7946 */         if ((generic = getSuperClass()) == null) {
/*  7947 */           generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
/*       */         }
/*  7949 */         generic.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitSuperclass()));
/*  7950 */         bool = (bool || !generic.getSort().isNonGeneric()) ? true : false;
/*  7951 */         for (Iterator<TypeDescription.Generic> iterator = getInterfaces().iterator(); iterator.hasNext(); ) {
/*  7952 */           TypeDescription.Generic generic1; (generic1 = iterator.next()).accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitInterface()));
/*  7953 */           bool = (bool || !generic1.getSort().isNonGeneric()) ? true : false;
/*       */         } 
/*  7955 */         if (bool)
/*  7956 */           return signatureWriter.toString();  return NON_GENERIC_SIGNATURE;
/*       */       }
/*  7958 */       catch (GenericSignatureFormatError genericSignatureFormatError) {
/*  7959 */         return NON_GENERIC_SIGNATURE;
/*       */       } 
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isSamePackage(TypeDescription param1TypeDescription) {
/*  7967 */       PackageDescription packageDescription2 = getPackage(), packageDescription1 = param1TypeDescription.getPackage();
/*  7968 */       return (packageDescription2 == null || packageDescription1 == null) ? ((packageDescription2 == packageDescription1)) : packageDescription2
/*       */         
/*  7970 */         .equals(packageDescription1);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     public boolean isVisibleTo(TypeDescription param1TypeDescription) {
/*  7978 */       if (isPrimitive() || (isArray() ? 
/*  7979 */         getComponentType().isVisibleTo(param1TypeDescription) : (
/*  7980 */         isPublic() || isProtected() || isSamePackage(param1TypeDescription)))) return true;
/*       */       
/*       */       return false;
/*       */     }
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     public boolean isAccessibleTo(TypeDescription param1TypeDescription) {
/*  7988 */       if (isPrimitive() || (isArray() ? 
/*  7989 */         getComponentType().isVisibleTo(param1TypeDescription) : (
/*  7990 */         isPublic() || isSamePackage(param1TypeDescription)))) return true;
/*       */       
/*       */       return false;
/*       */     }
/*       */ 
/*       */     
/*       */     public AnnotationList getInheritedAnnotations() {
/*  7997 */       TypeDescription.Generic generic = getSuperClass();
/*  7998 */       AnnotationList annotationList = getDeclaredAnnotations();
/*  7999 */       if (generic == null) {
/*  8000 */         return annotationList;
/*       */       }
/*  8002 */       HashSet<TypeDescription> hashSet = new HashSet();
/*  8003 */       for (AnnotationDescription annotationDescription : annotationList) {
/*  8004 */         hashSet.add(annotationDescription.getAnnotationType());
/*       */       }
/*  8006 */       return (AnnotationList)new AnnotationList.Explicit(CompoundList.of((List)annotationList, (List)generic.asErasure().getInheritedAnnotations().inherited(hashSet)));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     public String getActualName() {
/*  8015 */       if (isArray()) {
/*  8016 */         AbstractBase abstractBase = this;
/*  8017 */         byte b2 = 0; TypeDescription typeDescription;
/*       */         do {
/*  8019 */           b2++;
/*       */         }
/*  8021 */         while ((typeDescription = abstractBase.getComponentType()).isArray());
/*       */         StringBuilder stringBuilder;
/*  8023 */         (stringBuilder = new StringBuilder()).append(typeDescription.getActualName());
/*  8024 */         for (byte b1 = 0; b1 < b2; b1++) {
/*  8025 */           stringBuilder.append("[]");
/*       */         }
/*  8027 */         return stringBuilder.toString();
/*       */       } 
/*  8029 */       return getName();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getLongSimpleName() {
/*       */       TypeDescription typeDescription;
/*  8038 */       if ((typeDescription = getDeclaringType()) == null)
/*  8039 */         return getSimpleName();  return typeDescription
/*  8040 */         .getLongSimpleName() + "." + getSimpleName();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isPrimitiveWrapper() {
/*  8047 */       if (represents(Boolean.class) || 
/*  8048 */         represents(Byte.class) || 
/*  8049 */         represents(Short.class) || 
/*  8050 */         represents(Character.class) || 
/*  8051 */         represents(Integer.class) || 
/*  8052 */         represents(Long.class) || 
/*  8053 */         represents(Float.class) || 
/*  8054 */         represents(Double.class)) return true;
/*       */       
/*       */       return false;
/*       */     }
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     public boolean isAnnotationReturnType() {
/*  8062 */       if (isPrimitive() || 
/*  8063 */         represents(String.class) || (
/*  8064 */         isAssignableTo(Enum.class) && !represents(Enum.class)) || (
/*  8065 */         isAssignableTo(Annotation.class) && !represents(Annotation.class)) || 
/*  8066 */         represents(Class.class) || (
/*  8067 */         isArray() && !getComponentType().isArray() && getComponentType().isAnnotationReturnType())) return true;
/*       */       
/*       */       return false;
/*       */     }
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     public boolean isAnnotationValue() {
/*  8075 */       if (isPrimitive() || 
/*  8076 */         represents(String.class) || 
/*  8077 */         isAssignableTo(TypeDescription.class) || 
/*  8078 */         isAssignableTo(AnnotationDescription.class) || 
/*  8079 */         isAssignableTo(EnumerationDescription.class) || (
/*  8080 */         isArray() && !getComponentType().isArray() && getComponentType().isAnnotationValue())) return true;
/*       */       
/*       */       return false;
/*       */     }
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"EC_UNRELATED_CLASS_AND_INTERFACE"}, justification = "Fits equality contract for type definitions.")
/*       */     public boolean represents(Type param1Type) {
/*  8088 */       return equals(TypeDefinition.Sort.describe(param1Type));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getTypeName() {
/*  8095 */       return getName();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeVariableSource getEnclosingSource() {
/*       */       MethodDescription.InDefinedShape inDefinedShape;
/*  8104 */       if ((inDefinedShape = getEnclosingMethod()) == null)
/*  8105 */         return isStatic() ? TypeVariableSource.UNDEFINED : getEnclosingType();  return (TypeVariableSource)inDefinedShape;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isInferrable() {
/*  8113 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public <T> T accept(TypeVariableSource.Visitor<T> param1Visitor) {
/*  8120 */       return (T)param1Visitor.onType(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isPackageType() {
/*  8127 */       return getSimpleName().equals("package-info");
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isGenerified() {
/*  8134 */       if (!getTypeVariables().isEmpty())
/*  8135 */         return true;  TypeDescription typeDescription;
/*  8136 */       if (!isStatic() && (
/*       */         
/*  8138 */         typeDescription = getDeclaringType()) != null && typeDescription.isGenerified()) {
/*  8139 */         return true;
/*       */       }
/*       */       
/*       */       try {
/*       */         MethodDescription.InDefinedShape inDefinedShape;
/*  8144 */         if ((inDefinedShape = getEnclosingMethod()) != null && inDefinedShape.isGenerified()) return true;  return false;
/*  8145 */       } catch (Throwable throwable) {
/*  8146 */         return false;
/*       */       } 
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getInnerClassCount() {
/*  8154 */       if (isStatic()) {
/*  8155 */         return 0;
/*       */       }
/*       */       TypeDescription typeDescription;
/*  8158 */       return ((typeDescription = getDeclaringType()) == null) ? 0 : (typeDescription
/*       */         
/*  8160 */         .getInnerClassCount() + 1);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isInnerClass() {
/*  8167 */       return (!isStatic() && isNestedClass());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isNestedClass() {
/*  8174 */       return (getDeclaringType() != null);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription asBoxed() {
/*  8181 */       if (represents(boolean.class))
/*  8182 */         return TypeDescription.ForLoadedType.of(Boolean.class); 
/*  8183 */       if (represents(byte.class))
/*  8184 */         return TypeDescription.ForLoadedType.of(Byte.class); 
/*  8185 */       if (represents(short.class))
/*  8186 */         return TypeDescription.ForLoadedType.of(Short.class); 
/*  8187 */       if (represents(char.class))
/*  8188 */         return TypeDescription.ForLoadedType.of(Character.class); 
/*  8189 */       if (represents(int.class))
/*  8190 */         return TypeDescription.ForLoadedType.of(Integer.class); 
/*  8191 */       if (represents(long.class))
/*  8192 */         return TypeDescription.ForLoadedType.of(Long.class); 
/*  8193 */       if (represents(float.class))
/*  8194 */         return TypeDescription.ForLoadedType.of(Float.class); 
/*  8195 */       if (represents(double.class)) {
/*  8196 */         return TypeDescription.ForLoadedType.of(Double.class);
/*       */       }
/*  8198 */       return this;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription asUnboxed() {
/*  8206 */       if (represents(Boolean.class))
/*  8207 */         return TypeDescription.ForLoadedType.of(boolean.class); 
/*  8208 */       if (represents(Byte.class))
/*  8209 */         return TypeDescription.ForLoadedType.of(byte.class); 
/*  8210 */       if (represents(Short.class))
/*  8211 */         return TypeDescription.ForLoadedType.of(short.class); 
/*  8212 */       if (represents(Character.class))
/*  8213 */         return TypeDescription.ForLoadedType.of(char.class); 
/*  8214 */       if (represents(Integer.class))
/*  8215 */         return TypeDescription.ForLoadedType.of(int.class); 
/*  8216 */       if (represents(Long.class))
/*  8217 */         return TypeDescription.ForLoadedType.of(long.class); 
/*  8218 */       if (represents(Float.class))
/*  8219 */         return TypeDescription.ForLoadedType.of(float.class); 
/*  8220 */       if (represents(Double.class)) {
/*  8221 */         return TypeDescription.ForLoadedType.of(double.class);
/*       */       }
/*  8223 */       return this;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public Object getDefaultValue() {
/*  8232 */       if (represents(boolean.class))
/*  8233 */         return Boolean.FALSE; 
/*  8234 */       if (represents(byte.class))
/*  8235 */         return Byte.valueOf((byte)0); 
/*  8236 */       if (represents(short.class))
/*  8237 */         return Short.valueOf((short)0); 
/*  8238 */       if (represents(char.class))
/*  8239 */         return Character.valueOf(false); 
/*  8240 */       if (represents(int.class))
/*  8241 */         return Integer.valueOf(0); 
/*  8242 */       if (represents(long.class))
/*  8243 */         return Long.valueOf(0L); 
/*  8244 */       if (represents(float.class))
/*  8245 */         return Float.valueOf(0.0F); 
/*  8246 */       if (represents(double.class)) {
/*  8247 */         return Double.valueOf(0.0D);
/*       */       }
/*  8249 */       return null;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isNestHost() {
/*  8257 */       return equals(getNestHost());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isNestMateOf(Class<?> param1Class) {
/*  8264 */       return isNestMateOf(TypeDescription.ForLoadedType.of(param1Class));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isNestMateOf(TypeDescription param1TypeDescription) {
/*  8271 */       return getNestHost().equals(param1TypeDescription.getNestHost());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isMemberType() {
/*  8278 */       return (!isLocalType() && !isAnonymousType() && getDeclaringType() != null);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isCompileTimeConstant() {
/*  8285 */       if (represents(int.class) || 
/*  8286 */         represents(long.class) || 
/*  8287 */         represents(float.class) || 
/*  8288 */         represents(double.class) || 
/*  8289 */         represents(String.class) || 
/*  8290 */         represents(Class.class) || 
/*  8291 */         equals(JavaType.METHOD_TYPE.getTypeStub()) || 
/*  8292 */         equals(JavaType.METHOD_HANDLE.getTypeStub())) return true;
/*       */       
/*       */       return false;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isSealed() {
/*  8299 */       return (!isPrimitive() && !isArray() && !getPermittedSubtypes().isEmpty());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public ClassFileVersion getClassFileVersion() {
/*  8307 */       return null;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Iterator<TypeDefinition> iterator() {
/*  8314 */       return new TypeDefinition.SuperClassIterator(this);
/*       */     } @Enhance("hashCode")
/*       */     public int hashCode() {
/*       */       AbstractBase abstractBase;
/*       */       int i;
/*       */       int j;
/*  8320 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (abstractBase = this).getName().hashCode())) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean equals(@MaybeNull Object param1Object) {
/*  8325 */       if (this == param1Object)
/*  8326 */         return true; 
/*  8327 */       if (!(param1Object instanceof TypeDefinition)) {
/*  8328 */         return false;
/*       */       }
/*       */       
/*  8331 */       if ((param1Object = param1Object).getSort().isNonGeneric() && getName().equals(param1Object.asErasure().getName())) return true;  return false;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8336 */       return (isPrimitive() ? "" : ((isInterface() ? "interface" : "class") + " ")) + getName();
/*       */     }
/*       */ 
/*       */     
/*       */     protected String toSafeString() {
/*  8341 */       return toString();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static abstract class OfSimpleType
/*       */       extends AbstractBase
/*       */     {
/*       */       public boolean isPrimitive() {
/*  8354 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean isArray() {
/*  8361 */         return false;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public TypeDescription getComponentType() {
/*  8369 */         return TypeDescription.UNDEFINED;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getDescriptor() {
/*  8376 */         return "L" + getInternalName() + ";";
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       public String getCanonicalName() {
/*  8384 */         if (isAnonymousType() || isLocalType()) {
/*  8385 */           return NO_NAME;
/*       */         }
/*  8387 */         String str = getInternalName();
/*       */         TypeDescription typeDescription;
/*  8389 */         if ((typeDescription = getEnclosingType()) != null && str.startsWith(typeDescription.getInternalName() + "$")) {
/*  8390 */           return typeDescription.getCanonicalName() + "." + str.substring(typeDescription.getInternalName().length() + 1);
/*       */         }
/*  8392 */         return getName();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getSimpleName() {
/*       */         int i;
/*  8400 */         String str = getInternalName();
/*       */         
/*       */         TypeDescription typeDescription;
/*  8403 */         if ((typeDescription = getEnclosingType()) != null && str.startsWith(typeDescription.getInternalName() + "$")) {
/*  8404 */           i = typeDescription.getInternalName().length() + 1;
/*       */         
/*       */         }
/*  8407 */         else if ((i = str.lastIndexOf('/')) == -1) {
/*  8408 */           return str;
/*       */         } 
/*       */         
/*  8411 */         while (i < str.length() && !Character.isLetter(str.charAt(i))) {
/*  8412 */           i++;
/*       */         }
/*  8414 */         return str.substring(i);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public StackSize getStackSize() {
/*  8421 */         return StackSize.SINGLE;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static abstract class WithDelegation
/*       */         extends OfSimpleType
/*       */       {
/*       */         public TypeDescription.Generic getSuperClass() {
/*  8440 */           return delegate().getSuperClass();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getInterfaces() {
/*  8447 */           return delegate().getInterfaces();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/*  8454 */           return delegate().getDeclaredFields();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/*  8461 */           return delegate().getDeclaredMethods();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription getDeclaringType() {
/*  8469 */           return delegate().getDeclaringType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public MethodDescription.InDefinedShape getEnclosingMethod() {
/*  8477 */           return delegate().getEnclosingMethod();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public TypeDescription getEnclosingType() {
/*  8485 */           return delegate().getEnclosingType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList getDeclaredTypes() {
/*  8492 */           return delegate().getDeclaredTypes();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isAnonymousType() {
/*  8499 */           return delegate().isAnonymousType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isLocalType() {
/*  8506 */           return delegate().isLocalType();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public PackageDescription getPackage() {
/*  8514 */           return delegate().getPackage();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public AnnotationList getDeclaredAnnotations() {
/*  8521 */           return delegate().getDeclaredAnnotations();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList.Generic getTypeVariables() {
/*  8528 */           return delegate().getTypeVariables();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public int getModifiers() {
/*  8535 */           return delegate().getModifiers();
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public String getGenericSignature() {
/*  8542 */           return delegate().getGenericSignature();
/*       */         }
/*       */ 
/*       */ 
/*       */         
/*       */         public int getActualModifiers(boolean param3Boolean) {
/*  8548 */           return delegate().getActualModifiers(param3Boolean);
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeDescription getNestHost() {
/*  8555 */           return delegate().getNestHost();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList getNestMembers() {
/*  8562 */           return delegate().getNestMembers();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/*  8569 */           return delegate().getRecordComponents();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public boolean isRecord() {
/*  8576 */           return delegate().isRecord();
/*       */         }
/*       */ 
/*       */         
/*       */         public boolean isSealed() {
/*  8581 */           return delegate().isSealed();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         public TypeList getPermittedSubtypes() {
/*  8588 */           return delegate().getPermittedSubtypes();
/*       */         }
/*       */ 
/*       */         
/*       */         @MaybeNull
/*       */         public ClassFileVersion getClassFileVersion() {
/*  8594 */           return delegate().getClassFileVersion();
/*       */         }
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*       */         protected abstract TypeDescription delegate();
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   @Enhance
/*       */   public static class LazyProxy
/*       */     implements InvocationHandler
/*       */   {
/*       */     private final Class<?> type;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected LazyProxy(Class<?> param1Class) {
/*  8618 */       this.type = param1Class;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected static TypeDescription of(Class<?> param1Class) {
/*  8628 */       return (TypeDescription)Proxy.newProxyInstance(TypeDescription.class.getClassLoader(), new Class[] { TypeDescription.class }, new LazyProxy(param1Class));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Object invoke(Object param1Object, Method param1Method, @MaybeNull Object[] param1ArrayOfObject) {
/*       */       try {
/*  8638 */         return param1Method.invoke(TypeDescription.ForLoadedType.of(this.type), param1ArrayOfObject);
/*  8639 */       } catch (InvocationTargetException invocationTargetException) {
/*  8640 */         throw (param1Object = null).getTargetException();
/*       */       } 
/*       */     }
/*       */     
/*       */     public boolean equals(@MaybeNull Object param1Object) {
/*       */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.type.equals(((LazyProxy)param1Object).type))));
/*       */     }
/*       */     
/*       */     public int hashCode() {
/*       */       return getClass().hashCode() * 31 + this.type.hashCode();
/*       */     }
/*       */   }
/*       */   
/*       */   @SuppressFBWarnings(value = {"SE_TRANSIENT_FIELD_NOT_RESTORED"}, justification = "Field is only used as a cache store and is implicitly recomputed")
/*       */   public static class ForLoadedType
/*       */     extends AbstractBase
/*       */     implements Serializable
/*       */   {
/*       */     private static final long serialVersionUID = 1L;
/*  8659 */     private static final Dispatcher DISPATCHER = doPrivileged(JavaDispatcher.of(Dispatcher.class));
/*       */ 
/*       */     
/*       */     private static final Map<Class<?>, TypeDescription> TYPE_CACHE;
/*       */     
/*       */     private final Class<?> type;
/*       */     
/*       */     private static final boolean ACCESS_CONTROLLER;
/*       */ 
/*       */     
/*       */     static
/*       */     {
/*  8671 */       (TYPE_CACHE = new HashMap<Class<?>, TypeDescription>()).put(TargetType.class, new ForLoadedType(TargetType.class));
/*  8672 */       TYPE_CACHE.put(Class.class, new ForLoadedType(Class.class));
/*  8673 */       TYPE_CACHE.put(Throwable.class, new ForLoadedType(Throwable.class));
/*  8674 */       TYPE_CACHE.put(Annotation.class, new ForLoadedType(Annotation.class));
/*  8675 */       TYPE_CACHE.put(Object.class, new ForLoadedType(Object.class));
/*  8676 */       TYPE_CACHE.put(String.class, new ForLoadedType(String.class));
/*  8677 */       TYPE_CACHE.put(Boolean.class, new ForLoadedType(Boolean.class));
/*  8678 */       TYPE_CACHE.put(Byte.class, new ForLoadedType(Byte.class));
/*  8679 */       TYPE_CACHE.put(Short.class, new ForLoadedType(Short.class));
/*  8680 */       TYPE_CACHE.put(Character.class, new ForLoadedType(Character.class));
/*  8681 */       TYPE_CACHE.put(Integer.class, new ForLoadedType(Integer.class));
/*  8682 */       TYPE_CACHE.put(Long.class, new ForLoadedType(Long.class));
/*  8683 */       TYPE_CACHE.put(Float.class, new ForLoadedType(Float.class));
/*  8684 */       TYPE_CACHE.put(Double.class, new ForLoadedType(Double.class));
/*  8685 */       TYPE_CACHE.put(void.class, new ForLoadedType(void.class));
/*  8686 */       TYPE_CACHE.put(boolean.class, new ForLoadedType(boolean.class));
/*  8687 */       TYPE_CACHE.put(byte.class, new ForLoadedType(byte.class));
/*  8688 */       TYPE_CACHE.put(short.class, new ForLoadedType(short.class));
/*  8689 */       TYPE_CACHE.put(char.class, new ForLoadedType(char.class));
/*  8690 */       TYPE_CACHE.put(int.class, new ForLoadedType(int.class));
/*  8691 */       TYPE_CACHE.put(long.class, new ForLoadedType(long.class));
/*  8692 */       TYPE_CACHE.put(float.class, new ForLoadedType(float.class));
/*  8693 */       TYPE_CACHE.put(double.class, new ForLoadedType(double.class)); } static { 
/*  8694 */       try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*       */        }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ForLoadedType(Class<?> param1Class) {
/*  8708 */       this.type = param1Class;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance
/*       */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/*  8720 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static String getName(Class<?> param1Class) {
/*       */       String str;
/*       */       int i;
/*  8734 */       return ((i = (str = param1Class.getName()).indexOf('/')) == -1) ? str : str
/*       */         
/*  8736 */         .substring(0, i);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TypeDescription of(Class<?> param1Class) {
/*       */       TypeDescription typeDescription;
/*  8747 */       return ((typeDescription = TYPE_CACHE.get(param1Class)) == null) ? new ForLoadedType(param1Class) : typeDescription;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAssignableFrom(Class<?> param1Class) {
/*  8754 */       return (this.type.isAssignableFrom(param1Class) || super.isAssignableFrom(param1Class));
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isAssignableFrom(TypeDescription param1TypeDescription) {
/*  8759 */       return ((param1TypeDescription instanceof ForLoadedType && this.type.isAssignableFrom(((ForLoadedType)param1TypeDescription).type)) || super.isAssignableFrom(param1TypeDescription));
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isAssignableTo(Class<?> param1Class) {
/*  8764 */       return (param1Class.isAssignableFrom(this.type) || super.isAssignableTo(param1Class));
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isAssignableTo(TypeDescription param1TypeDescription) {
/*  8769 */       return ((param1TypeDescription instanceof ForLoadedType && ((ForLoadedType)param1TypeDescription).type.isAssignableFrom(this.type)) || super.isAssignableTo(param1TypeDescription));
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isInHierarchyWith(Class<?> param1Class) {
/*  8774 */       return (param1Class.isAssignableFrom(this.type) || this.type.isAssignableFrom(param1Class) || super.isInHierarchyWith(param1Class));
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isInHierarchyWith(TypeDescription param1TypeDescription) {
/*  8779 */       if ((param1TypeDescription instanceof ForLoadedType && (((ForLoadedType)param1TypeDescription).type.isAssignableFrom(this.type) || this.type
/*  8780 */         .isAssignableFrom(((ForLoadedType)param1TypeDescription).type))) || super.isInHierarchyWith(param1TypeDescription)) return true; 
/*       */       return false;
/*       */     }
/*       */     
/*       */     public boolean represents(Type param1Type) {
/*  8785 */       return (param1Type == this.type || super.represents(param1Type));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getComponentType() {
/*       */       Class<?> clazz;
/*  8794 */       return ((clazz = this.type.getComponentType()) == null) ? TypeDescription.UNDEFINED : 
/*       */         
/*  8796 */         of(clazz);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isArray() {
/*  8803 */       return this.type.isArray();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isPrimitive() {
/*  8810 */       return this.type.isPrimitive();
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isAnnotation() {
/*  8815 */       return this.type.isAnnotation();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription.Generic getSuperClass() {
/*  8823 */       if (RAW_TYPES) {
/*  8824 */         return (this.type.getSuperclass() == null) ? TypeDescription.Generic.UNDEFINED : 
/*       */           
/*  8826 */           TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.type.getSuperclass());
/*       */       }
/*  8828 */       return TypeDescription.Generic.LazyProjection.ForLoadedSuperClass.of(this.type);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getInterfaces() {
/*  8835 */       if (RAW_TYPES) {
/*  8836 */         return isArray() ? ARRAY_INTERFACES : new TypeList.Generic.ForLoadedTypes((Type[])this.type
/*       */             
/*  8838 */             .getInterfaces());
/*       */       }
/*  8840 */       return isArray() ? ARRAY_INTERFACES : new TypeList.Generic.OfLoadedInterfaceTypes(this.type);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getDeclaringType() {
/*       */       Class<?> clazz;
/*  8851 */       return ((clazz = this.type.getDeclaringClass()) == null) ? TypeDescription.UNDEFINED : 
/*       */         
/*  8853 */         of(clazz);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public MethodDescription.InDefinedShape getEnclosingMethod() {
/*  8861 */       Method method = this.type.getEnclosingMethod();
/*  8862 */       Constructor<?> constructor = this.type.getEnclosingConstructor();
/*  8863 */       if (method != null)
/*  8864 */         return (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(method); 
/*  8865 */       if (constructor != null) {
/*  8866 */         return (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(constructor);
/*       */       }
/*  8868 */       return MethodDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getEnclosingType() {
/*       */       Class<?> clazz;
/*  8877 */       return ((clazz = this.type.getEnclosingClass()) == null) ? TypeDescription.UNDEFINED : 
/*       */         
/*  8879 */         of(clazz);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getDeclaredTypes() {
/*  8886 */       return new TypeList.ForLoadedTypes(this.type.getDeclaredClasses());
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getSimpleName() {
/*       */       String str;
/*       */       int i;
/*  8895 */       if ((i = (str = this.type.getSimpleName()).indexOf('/')) == -1) {
/*  8896 */         return str;
/*       */       }
/*  8898 */       StringBuilder stringBuilder = new StringBuilder(str.substring(0, i));
/*  8899 */       Class<?> clazz = this.type;
/*  8900 */       while (clazz.isArray()) {
/*  8901 */         stringBuilder.append("[]");
/*  8902 */         clazz = clazz.getComponentType();
/*       */       } 
/*  8904 */       return stringBuilder.toString();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAnonymousType() {
/*  8912 */       return this.type.isAnonymousClass();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isLocalType() {
/*  8919 */       return this.type.isLocalClass();
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isMemberType() {
/*  8924 */       return this.type.isMemberClass();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance("declaredFields")
/*       */     public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/*       */       FieldList<FieldDescription.InDefinedShape> fieldList;
/*  8932 */       ForLoadedType forLoadedType = this; FieldList.ForLoadedFields forLoadedFields; FieldList fieldList1; if ((forLoadedFields = (FieldList.ForLoadedFields)(((fieldList1 = this.declaredFields) != null) ? null : new FieldList.ForLoadedFields((Field[])GraalImageCode.getCurrent().sorted((Object[])forLoadedType.type.getDeclaredFields(), (Comparator)FieldComparator.INSTANCE)))) == null) { fieldList = this.declaredFields; } else { this.declaredFields = fieldList; }  return fieldList;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance("declaredMethods")
/*       */     public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/*       */       MethodList<MethodDescription.InDefinedShape> methodList;
/*  8940 */       ForLoadedType forLoadedType = this; MethodList.ForLoadedMethods forLoadedMethods; MethodList methodList1; if ((forLoadedMethods = (MethodList.ForLoadedMethods)(((methodList1 = this.declaredMethods) != null) ? null : new MethodList.ForLoadedMethods(forLoadedType.type))) == null) { methodList = this.declaredMethods; } else { this.declaredMethods = methodList; }  return methodList;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public PackageDescription getPackage() {
/*       */       String str;
/*  8948 */       if (this.type.isArray() || this.type.isPrimitive()) {
/*  8949 */         return PackageDescription.UNDEFINED;
/*       */       }
/*       */       Package package_;
/*  8952 */       if ((package_ = this.type.getPackage()) == null) {
/*       */         int i;
/*       */         
/*  8955 */         return ((i = (str = this.type.getName()).lastIndexOf('.')) == -1) ? PackageDescription.DEFAULT : new PackageDescription.Simple(str
/*       */             
/*  8957 */             .substring(0, i));
/*       */       } 
/*  8959 */       return new PackageDescription.ForLoadedPackage((Package)str);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public StackSize getStackSize() {
/*  8968 */       return StackSize.of(this.type);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*  8975 */       return getName(this.type);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public String getCanonicalName() {
/*       */       String str;
/*  8984 */       if ((str = this.type.getCanonicalName()) == null) {
/*  8985 */         return NO_NAME;
/*       */       }
/*       */       int i;
/*  8988 */       if ((i = str.indexOf('/')) == -1) {
/*  8989 */         return str;
/*       */       }
/*  8991 */       StringBuilder stringBuilder = new StringBuilder(str.substring(0, i));
/*  8992 */       Class<?> clazz = this.type;
/*  8993 */       while (clazz.isArray()) {
/*  8994 */         stringBuilder.append("[]");
/*  8995 */         clazz = clazz.getComponentType();
/*       */       } 
/*  8997 */       return stringBuilder.toString();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getDescriptor() {
/*       */       String str;
/*       */       int i;
/*  9007 */       if ((i = (str = this.type.getName()).indexOf('/')) == -1)
/*  9008 */         return Type.getDescriptor(this.type);  return "L" + str
/*  9009 */         .substring(0, i).replace('.', '/') + ";";
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getModifiers() {
/*  9016 */       return this.type.getModifiers();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getTypeVariables() {
/*  9023 */       if (RAW_TYPES) {
/*  9024 */         return new TypeList.Generic.Empty();
/*       */       }
/*  9026 */       return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of(this.type);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     @Enhance("declaredAnnotations")
/*       */     public AnnotationList getDeclaredAnnotations() {
/*       */       AnnotationList annotationList1;
/*  9034 */       ForLoadedType forLoadedType = this; AnnotationList.ForLoadedAnnotations forLoadedAnnotations; AnnotationList annotationList2; if ((forLoadedAnnotations = (AnnotationList.ForLoadedAnnotations)(((annotationList2 = this.declaredAnnotations) != null) ? null : new AnnotationList.ForLoadedAnnotations(forLoadedType.type.getDeclaredAnnotations()))) == null) { annotationList1 = this.declaredAnnotations; } else { this.declaredAnnotations = annotationList1; }  return annotationList1;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription.Generic asGenericType() {
/*  9041 */       return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.type);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getNestHost() {
/*       */       Class<?> clazz;
/*  9049 */       return ((clazz = DISPATCHER.getNestHost(this.type)) == null) ? this : 
/*       */         
/*  9051 */         of(clazz);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getNestMembers() {
/*  9058 */       Class[] arrayOfClass = DISPATCHER.getNestMembers(this.type);
/*  9059 */       (new Class[1])[0] = this.type; return new TypeList.ForLoadedTypes((arrayOfClass.length == 0) ? new Class[1] : arrayOfClass);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isNestHost() {
/*       */       Class<?> clazz;
/*  9067 */       if ((clazz = DISPATCHER.getNestHost(this.type)) == null || clazz == this.type) return true;  return false;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isNestMateOf(Class<?> param1Class) {
/*  9072 */       return (DISPATCHER.isNestmateOf(this.type, param1Class) || super.isNestMateOf(of(param1Class)));
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isNestMateOf(TypeDescription param1TypeDescription) {
/*  9077 */       return ((param1TypeDescription instanceof ForLoadedType && DISPATCHER.isNestmateOf(this.type, ((ForLoadedType)param1TypeDescription).type)) || super.isNestMateOf(param1TypeDescription));
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/*       */       Object[] arrayOfObject;
/*  9084 */       return 
/*  9085 */         ((arrayOfObject = DISPATCHER.getRecordComponents(this.type)) == null) ? new RecordComponentList.Empty<RecordComponentDescription.InDefinedShape>() : new RecordComponentList.ForLoadedRecordComponents(arrayOfObject);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isRecord() {
/*  9094 */       return DISPATCHER.isRecord(this.type);
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isSealed() {
/*  9099 */       return DISPATCHER.isSealed(this.type);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getPermittedSubtypes() {
/*       */       Class[] arrayOfClass;
/*  9106 */       return 
/*  9107 */         ((arrayOfClass = DISPATCHER.getPermittedSubclasses(this.type)) == null) ? new TypeList.Empty() : new TypeList.ForLoadedTypes(arrayOfClass);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     @Enhance("classFileVersion")
/*       */     public ClassFileVersion getClassFileVersion() {
/*       */       ClassFileVersion classFileVersion1;
/*  9117 */       ForLoadedType forLoadedType = this; try {  }
/*  9118 */       catch (Throwable throwable) {} ClassFileVersion classFileVersion2;
/*  9119 */       if ((forLoadedType = (ForLoadedType)(((classFileVersion2 = this.classFileVersion) != null) ? null : null)) == null) { classFileVersion1 = this.classFileVersion; } else { this.classFileVersion = classFileVersion1; }  return classFileVersion1;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @Defaults
/*       */     @Proxied("java.lang.Class")
/*       */     protected static interface Dispatcher
/*       */     {
/*       */       @MaybeNull
/*       */       @Proxied("getAnnotatedSuperclass")
/*       */       AnnotatedElement getAnnotatedSuperclass(Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Proxied("getAnnotatedInterfaces")
/*       */       AnnotatedElement[] getAnnotatedInterfaces(Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       @Proxied("getNestHost")
/*       */       Class<?> getNestHost(Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Proxied("getNestMembers")
/*       */       Class<?>[] getNestMembers(Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Proxied("isNestmateOf")
/*       */       boolean isNestmateOf(Class<?> param2Class1, Class<?> param2Class2);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Proxied("isSealed")
/*       */       boolean isSealed(Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       @Proxied("getPermittedSubclasses")
/*       */       Class<?>[] getPermittedSubclasses(Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Proxied("isRecord")
/*       */       boolean isRecord(Class<?> param2Class);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       @Proxied("getRecordComponents")
/*       */       Object[] getRecordComponents(Class<?> param2Class);
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static class ArrayProjection
/*       */     extends AbstractBase
/*       */   {
/*       */     private static final int ARRAY_IMPLIED = 1040;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private static final int ARRAY_EXCLUDED = 8712;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final TypeDescription componentType;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final int arity;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected ArrayProjection(TypeDescription param1TypeDescription, int param1Int) {
/*  9242 */       this.componentType = param1TypeDescription;
/*  9243 */       this.arity = param1Int;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TypeDescription of(TypeDescription param1TypeDescription) {
/*  9253 */       return of(param1TypeDescription, 1);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     public static TypeDescription of(TypeDescription param1TypeDescription, int param1Int) {
/*  9265 */       if (param1Int < 0) {
/*  9266 */         throw new IllegalArgumentException("Arrays cannot have a negative arity");
/*       */       }
/*  9268 */       while (param1TypeDescription.isArray()) {
/*  9269 */         param1TypeDescription = param1TypeDescription.getComponentType();
/*  9270 */         param1Int++;
/*       */       } 
/*  9272 */       return (param1Int == 0) ? param1TypeDescription : new ArrayProjection(param1TypeDescription, param1Int);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isArray() {
/*  9281 */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getComponentType() {
/*  9289 */       return (this.arity == 1) ? this.componentType : new ArrayProjection(this.componentType, this.arity - 1);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isPrimitive() {
/*  9298 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription.Generic getSuperClass() {
/*  9306 */       return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getInterfaces() {
/*  9313 */       return ARRAY_INTERFACES;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public MethodDescription.InDefinedShape getEnclosingMethod() {
/*  9321 */       return MethodDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getEnclosingType() {
/*  9329 */       return TypeDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getDeclaredTypes() {
/*  9336 */       return new TypeList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getSimpleName() {
/*  9343 */       StringBuilder stringBuilder = new StringBuilder(this.componentType.getSimpleName());
/*  9344 */       for (byte b = 0; b < this.arity; b++) {
/*  9345 */         stringBuilder.append("[]");
/*       */       }
/*  9347 */       return stringBuilder.toString();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public String getCanonicalName() {
/*       */       String str;
/*  9356 */       if ((str = this.componentType.getCanonicalName()) == null) {
/*  9357 */         return NO_NAME;
/*       */       }
/*  9359 */       StringBuilder stringBuilder = new StringBuilder(str);
/*  9360 */       for (byte b = 0; b < this.arity; b++) {
/*  9361 */         stringBuilder.append("[]");
/*       */       }
/*  9363 */       return stringBuilder.toString();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAnonymousType() {
/*  9370 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isLocalType() {
/*  9377 */       return false;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isMemberType() {
/*  9382 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/*  9389 */       return (FieldList<FieldDescription.InDefinedShape>)new FieldList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/*  9396 */       return (MethodList<MethodDescription.InDefinedShape>)new MethodList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public StackSize getStackSize() {
/*  9403 */       return StackSize.SINGLE;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AnnotationList getDeclaredAnnotations() {
/*  9410 */       return (AnnotationList)new AnnotationList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AnnotationList getInheritedAnnotations() {
/*  9417 */       return (AnnotationList)new AnnotationList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public PackageDescription getPackage() {
/*  9425 */       return PackageDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*  9432 */       String str = this.componentType.getDescriptor();
/*  9433 */       StringBuilder stringBuilder = new StringBuilder(str.length() + this.arity); byte b;
/*  9434 */       for (b = 0; b < this.arity; b++) {
/*  9435 */         stringBuilder.append('[');
/*       */       }
/*  9437 */       for (b = 0; b < str.length(); b++) {
/*  9438 */         char c = str.charAt(b);
/*  9439 */         stringBuilder.append((c == '/') ? 46 : c);
/*       */       } 
/*  9441 */       return stringBuilder.toString();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getDescriptor() {
/*  9448 */       StringBuilder stringBuilder = new StringBuilder();
/*  9449 */       for (byte b = 0; b < this.arity; b++) {
/*  9450 */         stringBuilder.append('[');
/*       */       }
/*  9452 */       return stringBuilder.append(this.componentType.getDescriptor()).toString();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @AlwaysNull
/*       */     public TypeDescription getDeclaringType() {
/*  9460 */       return TypeDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*       */     public int getModifiers() {
/*  9468 */       return getComponentType().getModifiers() & 0xFFFFDDF7 | 0x410;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getTypeVariables() {
/*  9475 */       return new TypeList.Generic.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getNestHost() {
/*  9482 */       return this;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getNestMembers() {
/*  9489 */       return new TypeList.Explicit(new TypeDescription[] { this });
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/*  9496 */       return new RecordComponentList.Empty<RecordComponentDescription.InDefinedShape>();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isRecord() {
/*  9503 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getPermittedSubtypes() {
/*  9510 */       return new TypeList.Empty();
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static class Latent
/*       */     extends AbstractBase.OfSimpleType
/*       */   {
/*       */     private final String name;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final int modifiers;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     private final TypeDescription.Generic superClass;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final List<? extends TypeDescription.Generic> interfaces;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Latent(String param1String, int param1Int, @MaybeNull TypeDescription.Generic param1Generic, TypeDescription.Generic... param1VarArgs) {
/*  9555 */       this(param1String, param1Int, param1Generic, Arrays.asList(param1VarArgs));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Latent(String param1String, int param1Int, @MaybeNull TypeDescription.Generic param1Generic, List<? extends TypeDescription.Generic> param1List) {
/*  9567 */       this.name = param1String;
/*  9568 */       this.modifiers = param1Int;
/*  9569 */       this.superClass = param1Generic;
/*  9570 */       this.interfaces = param1List;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription.Generic getSuperClass() {
/*  9578 */       return this.superClass;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getInterfaces() {
/*  9585 */       return new TypeList.Generic.Explicit((List)this.interfaces);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MethodDescription.InDefinedShape getEnclosingMethod() {
/*  9592 */       throw new IllegalStateException("Cannot resolve enclosing method of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getEnclosingType() {
/*  9599 */       throw new IllegalStateException("Cannot resolve enclosing type of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getDeclaredTypes() {
/*  9606 */       throw new IllegalStateException("Cannot resolve inner types of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAnonymousType() {
/*  9613 */       throw new IllegalStateException("Cannot resolve anonymous type property of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isLocalType() {
/*  9620 */       throw new IllegalStateException("Cannot resolve local class property of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/*  9627 */       throw new IllegalStateException("Cannot resolve declared fields of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/*  9634 */       throw new IllegalStateException("Cannot resolve declared methods of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public PackageDescription getPackage() {
/*       */       String str;
/*       */       int i;
/*  9644 */       return ((i = (str = getName()).lastIndexOf('.')) == -1) ? PackageDescription.DEFAULT : new PackageDescription.Simple(str
/*       */           
/*  9646 */           .substring(0, i));
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AnnotationList getDeclaredAnnotations() {
/*  9653 */       throw new IllegalStateException("Cannot resolve declared annotations of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getDeclaringType() {
/*  9660 */       throw new IllegalStateException("Cannot resolve declared type of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getModifiers() {
/*  9667 */       return this.modifiers;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*  9674 */       return this.name;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getTypeVariables() {
/*  9681 */       throw new IllegalStateException("Cannot resolve type variables of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getNestHost() {
/*  9688 */       throw new IllegalStateException("Cannot resolve nest host of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getNestMembers() {
/*  9695 */       throw new IllegalStateException("Cannot resolve nest mates of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/*  9702 */       throw new IllegalStateException("Cannot resolve record components of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isRecord() {
/*  9709 */       throw new IllegalStateException("Cannot resolve record attribute of a latent type description: " + this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getPermittedSubtypes() {
/*  9716 */       throw new IllegalStateException("Cannot resolve permitted subclasses of a latent type description: " + this);
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static class ForPackageDescription
/*       */     extends AbstractBase.OfSimpleType
/*       */   {
/*       */     private final PackageDescription packageDescription;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ForPackageDescription(PackageDescription param1PackageDescription) {
/*  9736 */       this.packageDescription = param1PackageDescription;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription.Generic getSuperClass() {
/*  9744 */       return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getInterfaces() {
/*  9751 */       return new TypeList.Generic.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public MethodDescription.InDefinedShape getEnclosingMethod() {
/*  9759 */       return MethodDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getEnclosingType() {
/*  9767 */       return TypeDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAnonymousType() {
/*  9774 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isLocalType() {
/*  9781 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getDeclaredTypes() {
/*  9788 */       return new TypeList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/*  9795 */       return (FieldList<FieldDescription.InDefinedShape>)new FieldList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/*  9802 */       return (MethodList<MethodDescription.InDefinedShape>)new MethodList.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public PackageDescription getPackage() {
/*  9809 */       return this.packageDescription;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AnnotationList getDeclaredAnnotations() {
/*  9816 */       return this.packageDescription.getDeclaredAnnotations();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getDeclaringType() {
/*  9824 */       return TypeDescription.UNDEFINED;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getTypeVariables() {
/*  9831 */       return new TypeList.Generic.Empty();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getModifiers() {
/*  9838 */       return 5632;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*  9845 */       return this.packageDescription.getName() + ".package-info";
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getNestHost() {
/*  9852 */       return this;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getNestMembers() {
/*  9859 */       return new TypeList.Explicit(new TypeDescription[] { this });
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/*  9866 */       return new RecordComponentList.Empty<RecordComponentDescription.InDefinedShape>();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isRecord() {
/*  9873 */       return false;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getPermittedSubtypes() {
/*  9880 */       return new TypeList.Empty();
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static class SuperTypeLoading
/*       */     extends AbstractBase
/*       */   {
/*       */     private final TypeDescription delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     private final ClassLoader classLoader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private final ClassLoadingDelegate classLoadingDelegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public SuperTypeLoading(TypeDescription param1TypeDescription, @MaybeNull ClassLoader param1ClassLoader) {
/*  9912 */       this(param1TypeDescription, param1ClassLoader, ClassLoadingDelegate.Simple.INSTANCE);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public SuperTypeLoading(TypeDescription param1TypeDescription, @MaybeNull ClassLoader param1ClassLoader, ClassLoadingDelegate param1ClassLoadingDelegate) {
/*  9923 */       this.delegate = param1TypeDescription;
/*  9924 */       this.classLoader = param1ClassLoader;
/*  9925 */       this.classLoadingDelegate = param1ClassLoadingDelegate;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public AnnotationList getDeclaredAnnotations() {
/*  9932 */       return this.delegate.getDeclaredAnnotations();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getModifiers() {
/*  9939 */       return this.delegate.getModifiers();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getTypeVariables() {
/*  9946 */       return this.delegate.getTypeVariables();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getDescriptor() {
/*  9953 */       return this.delegate.getDescriptor();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*  9960 */       return this.delegate.getName();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription.Generic getSuperClass() {
/*       */       TypeDescription.Generic generic;
/*  9969 */       return ((generic = this.delegate.getSuperClass()) == null) ? TypeDescription.Generic.UNDEFINED : new ClassLoadingTypeProjection(generic, this.classLoader, this.classLoadingDelegate);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList.Generic getInterfaces() {
/*  9978 */       return new ClassLoadingTypeList(this.delegate.getInterfaces(), this.classLoader, this.classLoadingDelegate);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/*  9985 */       return this.delegate.getDeclaredFields();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/*  9992 */       return this.delegate.getDeclaredMethods();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public StackSize getStackSize() {
/*  9999 */       return this.delegate.getStackSize();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isArray() {
/* 10006 */       return this.delegate.isArray();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isPrimitive() {
/* 10013 */       return this.delegate.isPrimitive();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getComponentType() {
/* 10021 */       return this.delegate.getComponentType();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getDeclaringType() {
/* 10029 */       return this.delegate.getDeclaringType();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getDeclaredTypes() {
/* 10036 */       return this.delegate.getDeclaredTypes();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public MethodDescription.InDefinedShape getEnclosingMethod() {
/* 10044 */       return this.delegate.getEnclosingMethod();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public TypeDescription getEnclosingType() {
/* 10052 */       return this.delegate.getEnclosingType();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getSimpleName() {
/* 10059 */       return this.delegate.getSimpleName();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public String getCanonicalName() {
/* 10067 */       return this.delegate.getCanonicalName();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isAnonymousType() {
/* 10074 */       return this.delegate.isAnonymousType();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isLocalType() {
/* 10081 */       return this.delegate.isLocalType();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public PackageDescription getPackage() {
/* 10089 */       return this.delegate.getPackage();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeDescription getNestHost() {
/* 10096 */       return this.delegate.getNestHost();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getNestMembers() {
/* 10103 */       return this.delegate.getNestMembers();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/* 10110 */       return this.delegate.getRecordComponents();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean isRecord() {
/* 10117 */       return this.delegate.isRecord();
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean isSealed() {
/* 10122 */       return this.delegate.isSealed();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TypeList getPermittedSubtypes() {
/* 10129 */       return this.delegate.getPermittedSubtypes();
/*       */     }
/*       */ 
/*       */     
/*       */     @MaybeNull
/*       */     public ClassFileVersion getClassFileVersion() {
/* 10135 */       return this.delegate.getClassFileVersion();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public enum Simple
/*       */       implements ClassLoadingDelegate
/*       */     {
/* 10161 */       INSTANCE;
/*       */ 
/*       */ 
/*       */       
/*       */       public final Class<?> load(String param2String, @MaybeNull ClassLoader param2ClassLoader)
/*       */       {
/* 10167 */         return Class.forName(param2String, false, param2ClassLoader); } } public static interface ClassLoadingDelegate { Class<?> load(String param2String, @MaybeNull ClassLoader param2ClassLoader); public enum Simple implements ClassLoadingDelegate { INSTANCE; public final Class<?> load(String param3String, @MaybeNull ClassLoader param3ClassLoader) { return Class.forName(param3String, false, param3ClassLoader); }
/*       */          }
/*       */        }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected static class ClassLoadingTypeProjection
/*       */       extends TypeDescription.Generic.LazyProjection
/*       */     {
/*       */       private final TypeDescription.Generic delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       private final ClassLoader classLoader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypeDescription.SuperTypeLoading.ClassLoadingDelegate classLoadingDelegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ClassLoadingTypeProjection(TypeDescription.Generic param2Generic, @MaybeNull ClassLoader param2ClassLoader, TypeDescription.SuperTypeLoading.ClassLoadingDelegate param2ClassLoadingDelegate) {
/* 10201 */         this.delegate = param2Generic;
/* 10202 */         this.classLoader = param2ClassLoader;
/* 10203 */         this.classLoadingDelegate = param2ClassLoadingDelegate;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public AnnotationList getDeclaredAnnotations() {
/* 10210 */         return this.delegate.getDeclaredAnnotations();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance("erasure")
/*       */       public TypeDescription asErasure() {
/* 10219 */         ClassLoadingTypeProjection classLoadingTypeProjection = this; try {  }
/* 10220 */         catch (ClassNotFoundException classNotFoundException) {} TypeDescription typeDescription2, typeDescription1;
/* 10221 */         if ((typeDescription1 = (TypeDescription)(((typeDescription2 = this.erasure) != null) ? null : classLoadingTypeProjection.delegate.asErasure())) == null) { typeDescription1 = this.erasure; } else { this.erasure = typeDescription1; }  return typeDescription1;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected TypeDescription.Generic resolve() {
/* 10227 */         return this.delegate;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       @Enhance("superClass")
/*       */       public TypeDescription.Generic getSuperClass() {
/*       */         try {
/*       */         
/* 10244 */         } catch (ClassNotFoundException classNotFoundException) {} TypeDescription.Generic generic1; TypeDescription.Generic generic2;
/* 10245 */         if ((generic1 = (TypeDescription.Generic)(((generic1 = this.superClass) != null) ? null : (((generic2 = ((ClassLoadingTypeProjection)(generic1 = this)).delegate.getSuperClass()) == null) ? TypeDescription.Generic.UNDEFINED : generic2))) == null) { generic1 = this.superClass; } else { this.superClass = generic1; }  return generic1;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @Enhance("interfaces")
/*       */       public TypeList.Generic getInterfaces() {
/*       */         ClassLoadingTypeProjection classLoadingTypeProjection;
/* 10255 */         TypeList.Generic generic3 = (classLoadingTypeProjection = this).delegate.getInterfaces();
/*       */ 
/*       */         
/*       */         try {
/*       */         
/* 10260 */         } catch (ClassNotFoundException classNotFoundException) {} TypeList.Generic generic1, generic2;
/* 10261 */         if ((generic1 = (TypeList.Generic)(((generic2 = this.interfaces) != null) ? null : generic3)) == null) { generic1 = this.interfaces; } else { this.interfaces = generic1; }  return generic1;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Iterator<TypeDefinition> iterator() {
/* 10269 */         return new TypeDefinition.SuperClassIterator(this);
/*       */       }
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected static class ClassLoadingTypeList
/*       */       extends TypeList.Generic.AbstractBase
/*       */     {
/*       */       private final TypeList.Generic delegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       @MaybeNull
/*       */       private final ClassLoader classLoader;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private final TypeDescription.SuperTypeLoading.ClassLoadingDelegate classLoadingDelegate;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected ClassLoadingTypeList(TypeList.Generic param2Generic, @MaybeNull ClassLoader param2ClassLoader, TypeDescription.SuperTypeLoading.ClassLoadingDelegate param2ClassLoadingDelegate) {
/* 10302 */         this.delegate = param2Generic;
/* 10303 */         this.classLoader = param2ClassLoader;
/* 10304 */         this.classLoadingDelegate = param2ClassLoadingDelegate;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TypeDescription.Generic get(int param2Int) {
/* 10311 */         return new TypeDescription.SuperTypeLoading.ClassLoadingTypeProjection((TypeDescription.Generic)this.delegate.get(param2Int), this.classLoader, this.classLoadingDelegate);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int size() {
/* 10318 */         return this.delegate.size();
/*       */       }
/*       */     }
/*       */   }
/*       */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\type\TypeDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */