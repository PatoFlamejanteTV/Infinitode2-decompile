/*     */ package net.bytebuddy.description.type;
/*     */ 
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.lang.reflect.WildcardType;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.description.ModifierReviewable;
/*     */ import net.bytebuddy.description.NamedElement;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ import net.bytebuddy.utility.nullability.UnknownNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface TypeDefinition
/*     */   extends Iterable<TypeDefinition>, ModifierReviewable.ForTypeDefinition, NamedElement
/*     */ {
/*     */   public static final String RAW_TYPES_PROPERTY = "net.bytebuddy.raw";
/*     */   
/*     */   TypeDescription.Generic asGenericType();
/*     */   
/*     */   TypeDescription asErasure();
/*     */   
/*     */   @MaybeNull
/*     */   TypeDescription.Generic getSuperClass();
/*     */   
/*     */   TypeList.Generic getInterfaces();
/*     */   
/*     */   FieldList<?> getDeclaredFields();
/*     */   
/*     */   MethodList<?> getDeclaredMethods();
/*     */   
/*     */   @MaybeNull
/*     */   TypeDefinition getComponentType();
/*     */   
/*     */   RecordComponentList<?> getRecordComponents();
/*     */   
/*     */   Sort getSort();
/*     */   
/*     */   String getTypeName();
/*     */   
/*     */   StackSize getStackSize();
/*     */   
/*     */   boolean isArray();
/*     */   
/*     */   boolean isRecord();
/*     */   
/*     */   boolean isPrimitive();
/*     */   
/*     */   boolean represents(Type paramType);
/*     */   
/*     */   public enum Sort
/*     */   {
/* 192 */     NON_GENERIC,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 197 */     GENERIC_ARRAY,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     PARAMETERIZED,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     WILDCARD,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     VARIABLE,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     VARIABLE_SYMBOLIC;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     private static final AnnotatedType ANNOTATED_TYPE = doPrivileged(JavaDispatcher.of(AnnotatedType.class)); static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */        }
/*     */     
/*     */     private static final boolean ACCESS_CONTROLLER;
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 234 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static TypeDescription.Generic describe(Type param1Type) {
/* 244 */       return describe(param1Type, TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static TypeDescription.Generic describeAnnotated(AnnotatedElement param1AnnotatedElement) {
/* 254 */       if (!ANNOTATED_TYPE.isInstance(param1AnnotatedElement)) {
/* 255 */         throw new IllegalArgumentException("Not an instance of AnnotatedType: " + param1AnnotatedElement);
/*     */       }
/* 257 */       return describe(ANNOTATED_TYPE.getType(param1AnnotatedElement), new TypeDescription.Generic.AnnotationReader.Delegator.Simple(param1AnnotatedElement));
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
/*     */     protected static TypeDescription.Generic describe(Type param1Type, TypeDescription.Generic.AnnotationReader param1AnnotationReader) {
/* 269 */       if (param1Type instanceof Class)
/* 270 */         return new TypeDescription.Generic.OfNonGenericType.ForLoadedType((Class)param1Type, param1AnnotationReader); 
/* 271 */       if (param1Type instanceof GenericArrayType)
/* 272 */         return new TypeDescription.Generic.OfGenericArray.ForLoadedType((GenericArrayType)param1Type, param1AnnotationReader); 
/* 273 */       if (param1Type instanceof ParameterizedType)
/* 274 */         return new TypeDescription.Generic.OfParameterizedType.ForLoadedType((ParameterizedType)param1Type, param1AnnotationReader); 
/* 275 */       if (param1Type instanceof TypeVariable)
/* 276 */         return new TypeDescription.Generic.OfTypeVariable.ForLoadedType((TypeVariable)param1Type, param1AnnotationReader); 
/* 277 */       if (param1Type instanceof WildcardType) {
/* 278 */         return new TypeDescription.Generic.OfWildcardType.ForLoadedType((WildcardType)param1Type, param1AnnotationReader);
/*     */       }
/* 280 */       throw new IllegalArgumentException("Unknown type: " + param1Type);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isNonGeneric() {
/* 290 */       return (this == NON_GENERIC);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isParameterized() {
/* 299 */       return (this == PARAMETERIZED);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isGenericArray() {
/* 308 */       return (this == GENERIC_ARRAY);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isWildcard() {
/* 317 */       return (this == WILDCARD);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isTypeVariable() {
/* 326 */       return (this == VARIABLE || this == VARIABLE_SYMBOLIC);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Proxied("java.lang.reflect.AnnotatedType")
/*     */     protected static interface AnnotatedType
/*     */     {
/*     */       @Instance
/*     */       @Proxied("isInstance")
/*     */       boolean isInstance(AnnotatedElement param2AnnotatedElement);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Proxied("getType")
/*     */       Type getType(AnnotatedElement param2AnnotatedElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SuperClassIterator
/*     */     implements Iterator<TypeDefinition>
/*     */   {
/*     */     @UnknownNull
/*     */     private TypeDefinition nextClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SuperClassIterator(TypeDefinition param1TypeDefinition) {
/* 371 */       this.nextClass = param1TypeDefinition;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 378 */       return (this.nextClass != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDefinition next() {
/* 385 */       if (!hasNext()) {
/* 386 */         throw new NoSuchElementException("End of type hierarchy");
/*     */       }
/*     */       try {
/* 389 */         return this.nextClass;
/*     */       } finally {
/* 391 */         this.nextClass = this.nextClass.getSuperClass();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 399 */       throw new UnsupportedOperationException("remove");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\type\TypeDefinition.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */