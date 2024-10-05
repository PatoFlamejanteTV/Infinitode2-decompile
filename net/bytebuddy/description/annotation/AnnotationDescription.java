/*      */ package net.bytebuddy.description.annotation;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.AnnotationTypeMismatchException;
/*      */ import java.lang.annotation.Documented;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.annotation.IncompleteAnnotationException;
/*      */ import java.lang.annotation.Inherited;
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ import java.lang.annotation.Target;
/*      */ import java.lang.reflect.InvocationHandler;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Proxy;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.privilege.SetAccessibleAction;
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
/*      */ public interface AnnotationDescription
/*      */ {
/*      */   @AlwaysNull
/*   63 */   public static final Loadable<?> UNDEFINED = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   AnnotationValue<?, ?> getValue(String paramString);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape paramInDefinedShape);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TypeDescription getAnnotationType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   <T extends Annotation> Loadable<T> prepare(Class<T> paramClass);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   RetentionPolicy getRetention();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Set<ElementType> getElementTypes();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isSupportedOn(ElementType paramElementType);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isSupportedOn(String paramString);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isInherited();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isDocumented();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Loadable<S extends Annotation>
/*      */     extends AnnotationDescription
/*      */   {
/*      */     S load();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum RenderingDispatcher
/*      */   {
/*  170 */     LEGACY_VM,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  175 */     JAVA_14_CAPABLE_VM
/*      */     {
/*      */       public final void appendPrefix(StringBuilder param2StringBuilder, String param2String, int param2Int) {
/*  178 */         if (param2Int > 1 || !param2String.equals("value")) {
/*  179 */           super.appendPrefix(param2StringBuilder, param2String, param2Int);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */       }
/*      */     },
/*  187 */     JAVA_19_CAPABLE_VM
/*      */     {
/*      */       public final void appendPrefix(StringBuilder param2StringBuilder, String param2String, int param2Int) {
/*  190 */         if (param2Int > 1 || !param2String.equals("value")) {
/*  191 */           super.appendPrefix(param2StringBuilder, param2String, param2Int);
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       public final void appendType(StringBuilder param2StringBuilder, TypeDescription param2TypeDescription) {
/*  197 */         param2StringBuilder.append(param2TypeDescription.getCanonicalName());
/*      */       }
/*      */     };
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
/*  216 */     public static final RenderingDispatcher CURRENT = LEGACY_VM;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendPrefix(StringBuilder param1StringBuilder, String param1String, int param1Int) {
/*  228 */       param1StringBuilder.append(param1String).append('=');
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendType(StringBuilder param1StringBuilder, TypeDescription param1TypeDescription) {
/*  238 */       param1StringBuilder.append(param1TypeDescription.getName());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class AnnotationInvocationHandler<T extends Annotation>
/*      */     implements InvocationHandler
/*      */   {
/*      */     private static final String HASH_CODE = "hashCode";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String EQUALS = "equals";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String TO_STRING = "toString";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String ANNOTATION_TYPE = "annotationType";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  272 */     private static final Object[] NO_ARGUMENT = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Class<? extends Annotation> annotationType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final LinkedHashMap<Method, AnnotationValue.Loaded<?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected AnnotationInvocationHandler(Class<T> param1Class, LinkedHashMap<Method, AnnotationValue.Loaded<?>> param1LinkedHashMap) {
/*  291 */       this.annotationType = param1Class;
/*  292 */       this.values = param1LinkedHashMap;
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
/*      */     public static <S extends Annotation> S of(@MaybeNull ClassLoader param1ClassLoader, Class<S> param1Class, Map<String, ? extends AnnotationValue<?, ?>> param1Map) {
/*  308 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(); Method[] arrayOfMethod; int i; byte b;
/*  309 */       for (i = (arrayOfMethod = param1Class.getDeclaredMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/*      */         Object object;
/*  311 */         if ((object = param1Map.get(method.getName())) == null) {
/*  312 */           object = method.getDefaultValue();
/*  313 */           linkedHashMap.put(method, ((object == null) ? new AnnotationValue.ForMissingValue<Object, Object>((TypeDescription)new TypeDescription.ForLoadedType(method
/*  314 */                   .getDeclaringClass()), method.getName()) : 
/*  315 */               AnnotationDescription.ForLoadedAnnotation.asValue(object, method.getReturnType())).load(param1ClassLoader));
/*      */         } else {
/*  317 */           linkedHashMap.put(method, object.filter((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(method)).load(param1ClassLoader));
/*      */         }  b++; }
/*      */       
/*  320 */       return (S)Proxy.newProxyInstance(param1ClassLoader, new Class[] { param1Class }, new AnnotationInvocationHandler<S>(param1Class, (LinkedHashMap)linkedHashMap));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Object param1Object, Method param1Method, @MaybeNull Object[] param1ArrayOfObject) {
/*  327 */       if (param1Method.getDeclaringClass() != this.annotationType) {
/*  328 */         if (param1Method.getName().equals("hashCode"))
/*  329 */           return Integer.valueOf(hashCodeRepresentation()); 
/*  330 */         if (param1Method.getName().equals("equals") && (param1Method.getParameterTypes()).length == 1)
/*  331 */           return Boolean.valueOf(equalsRepresentation(param1Object, param1ArrayOfObject[0])); 
/*  332 */         if (param1Method.getName().equals("toString"))
/*  333 */           return toStringRepresentation(); 
/*  334 */         if (param1Method.getName().equals("annotationType")) {
/*  335 */           return this.annotationType;
/*      */         }
/*  337 */         throw new IllegalStateException("Unexpected method: " + param1Method);
/*      */       } 
/*      */       
/*  340 */       return ((AnnotationValue.Loaded)this.values.get(param1Method)).resolve();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected String toStringRepresentation() {
/*      */       StringBuilder stringBuilder;
/*  350 */       (stringBuilder = new StringBuilder()).append('@');
/*  351 */       AnnotationDescription.RenderingDispatcher.CURRENT.appendType(stringBuilder, TypeDescription.ForLoadedType.of(this.annotationType));
/*  352 */       stringBuilder.append('(');
/*  353 */       boolean bool = true;
/*  354 */       for (Iterator<Map.Entry> iterator = this.values.entrySet().iterator(); iterator.hasNext();) {
/*  355 */         if (((AnnotationValue.Loaded)(entry = iterator.next()).getValue()).getState().isDefined()) {
/*      */ 
/*      */           
/*  358 */           if (bool) {
/*  359 */             bool = false;
/*      */           } else {
/*  361 */             stringBuilder.append(", ");
/*      */           } 
/*  363 */           AnnotationDescription.RenderingDispatcher.CURRENT.appendPrefix(stringBuilder, ((Method)entry.getKey()).getName(), this.values.entrySet().size());
/*  364 */           stringBuilder.append(((AnnotationValue.Loaded)entry.getValue()).toString());
/*      */         } 
/*  366 */       }  stringBuilder.append(')');
/*  367 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int hashCodeRepresentation() {
/*  376 */       int i = 0;
/*  377 */       for (Iterator<Map.Entry> iterator = this.values.entrySet().iterator(); iterator.hasNext();) {
/*  378 */         if (((AnnotationValue.Loaded)(entry = iterator.next()).getValue()).getState().isDefined())
/*      */         {
/*      */           
/*  381 */           i += 127 * ((Method)entry.getKey()).getName().hashCode() ^ ((AnnotationValue.Loaded)entry.getValue()).hashCode(); } 
/*      */       } 
/*  383 */       return i;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean equalsRepresentation(Object param1Object1, Object param1Object2) {
/*  394 */       if (param1Object1 == param1Object2)
/*  395 */         return true; 
/*  396 */       if (!this.annotationType.isInstance(param1Object2))
/*  397 */         return false; 
/*  398 */       if (Proxy.isProxyClass(param1Object2.getClass()) && 
/*      */         
/*  400 */         param1Object1 = Proxy.getInvocationHandler(param1Object2) instanceof AnnotationInvocationHandler) {
/*  401 */         return param1Object1.equals(this);
/*      */       }
/*      */       
/*      */       try {
/*  405 */         for (param1Object1 = this.values.entrySet().iterator(); param1Object1.hasNext(); ) { Map.Entry entry = param1Object1.next();
/*      */           try {
/*  407 */             if (!((AnnotationValue.Loaded)entry.getValue()).represents(((Method)entry.getKey()).invoke(param1Object2, NO_ARGUMENT))) {
/*  408 */               return false;
/*      */             }
/*  410 */           } catch (RuntimeException runtimeException) {
/*  411 */             return false;
/*      */           }  }
/*      */         
/*  414 */         return true;
/*  415 */       } catch (InvocationTargetException invocationTargetException) {
/*  416 */         return false;
/*  417 */       } catch (IllegalAccessException illegalAccessException) {
/*  418 */         throw new IllegalStateException("Could not access annotation property", illegalAccessException);
/*      */       } 
/*      */     }
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*      */       AnnotationInvocationHandler annotationInvocationHandler;
/*  425 */       int k = (annotationInvocationHandler = this).annotationType.hashCode();
/*  426 */       k = k * 31 + annotationInvocationHandler.values.hashCode();
/*  427 */       for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : annotationInvocationHandler.values.entrySet())
/*  428 */         k = k * 31 + entry.getValue().hashCode(); 
/*      */       int i, j;
/*  430 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : k)) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*  435 */       if (this == param1Object)
/*  436 */         return true; 
/*  437 */       if (!(param1Object instanceof AnnotationInvocationHandler)) {
/*  438 */         return false;
/*      */       }
/*  440 */       param1Object = param1Object;
/*  441 */       if (!this.annotationType.equals(((AnnotationInvocationHandler)param1Object).annotationType)) {
/*  442 */         return false;
/*      */       }
/*  444 */       for (Iterator<Map.Entry> iterator = this.values.entrySet().iterator(); iterator.hasNext();) {
/*  445 */         if (!((AnnotationValue.Loaded)(entry = iterator.next()).getValue()).equals(((AnnotationInvocationHandler)param1Object).values.get(entry.getKey()))) {
/*  446 */           return false;
/*      */         }
/*      */       } 
/*  449 */       return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class AbstractBase
/*      */     implements AnnotationDescription
/*      */   {
/*  478 */     private static final Set<ElementType> DEFAULT_TARGET = new HashSet<ElementType>(); static { ElementType[] arrayOfElementType; int i; byte b;
/*  479 */       for (i = (arrayOfElementType = ElementType.values()).length, b = 0; b < i; b++) {
/*  480 */         ElementType elementType; if (!(elementType = arrayOfElementType[b]).name().equals("TYPE_PARAMETER"))
/*  481 */           DEFAULT_TARGET.add(elementType); 
/*      */       }  }
/*      */     
/*  484 */     private static final MethodDescription.InDefinedShape RETENTION_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Retention.class)
/*  485 */       .getDeclaredMethods()
/*  486 */       .filter((ElementMatcher)ElementMatchers.named("value")))
/*  487 */       .getOnly();
/*  488 */     private static final MethodDescription.InDefinedShape TARGET_VALUE = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Target.class)
/*  489 */       .getDeclaredMethods()
/*  490 */       .filter((ElementMatcher)ElementMatchers.named("value")))
/*  491 */       .getOnly();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<?, ?> getValue(String param1String) {
/*      */       MethodList methodList;
/*  502 */       if ((methodList = (MethodList)getAnnotationType().getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named(param1String).and((ElementMatcher)ElementMatchers.takesArguments(0)).and((ElementMatcher)ElementMatchers.isPublic()).and((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isStatic())))).size() == 1) {
/*  503 */         return getValue((MethodDescription.InDefinedShape)methodList.getOnly());
/*      */       }
/*  505 */       throw new IllegalArgumentException("Unknown property of " + getAnnotationType() + ": " + param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RetentionPolicy getRetention() {
/*      */       AnnotationDescription.Loadable<Retention> loadable;
/*  514 */       return ((loadable = getAnnotationType().getDeclaredAnnotations().<Annotation>ofType(Retention.class)) == null) ? RetentionPolicy.CLASS : (RetentionPolicy)loadable
/*      */         
/*  516 */         .getValue(RETENTION_VALUE).load(ClassLoadingStrategy.BOOTSTRAP_LOADER).resolve(RetentionPolicy.class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<ElementType> getElementTypes() {
/*      */       AnnotationDescription.Loadable<Target> loadable;
/*  524 */       if ((loadable = getAnnotationType().getDeclaredAnnotations().<Annotation>ofType(Target.class)) == null)
/*  525 */         return Collections.unmodifiableSet(DEFAULT_TARGET);  return new HashSet<ElementType>(
/*  526 */           Arrays.asList((Object[])loadable.getValue(TARGET_VALUE).load(ClassLoadingStrategy.BOOTSTRAP_LOADER).resolve(ElementType[].class)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSupportedOn(ElementType param1ElementType) {
/*  533 */       return isSupportedOn(param1ElementType.name());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSupportedOn(String param1String) {
/*      */       Iterator<ElementType> iterator;
/*      */       AnnotationDescription.Loadable<Target> loadable;
/*  541 */       if ((loadable = getAnnotationType().getDeclaredAnnotations().<Annotation>ofType(Target.class)) == null) {
/*  542 */         if (param1String.equals("TYPE_USE")) {
/*  543 */           return true;
/*      */         }
/*  545 */         for (iterator = DEFAULT_TARGET.iterator(); iterator.hasNext();) {
/*  546 */           if ((elementType = iterator.next()).name().equals(param1String))
/*  547 */             return true; 
/*      */         } 
/*      */       } else {
/*      */         EnumerationDescription[] arrayOfEnumerationDescription; int i; byte b;
/*  551 */         for (i = (arrayOfEnumerationDescription = iterator.getValue(TARGET_VALUE).<EnumerationDescription[]>resolve((Class)EnumerationDescription[].class)).length, b = 0; b < i; b++) {
/*  552 */           EnumerationDescription enumerationDescription; if ((enumerationDescription = arrayOfEnumerationDescription[b]).getValue().equals(param1String)) {
/*  553 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*  557 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isInherited() {
/*  564 */       return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent((Class)Inherited.class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDocumented() {
/*  571 */       return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent((Class)Documented.class);
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/*  577 */       AbstractBase abstractBase = this; int k = 0;
/*  578 */       for (MethodDescription.InDefinedShape inDefinedShape : abstractBase.getAnnotationType().getDeclaredMethods())
/*  579 */         k += 31 * abstractBase.getValue(inDefinedShape).hashCode(); 
/*      */       int i, j;
/*  581 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : k)) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*  586 */       if (this == param1Object)
/*  587 */         return true; 
/*  588 */       if (!(param1Object instanceof AnnotationDescription)) {
/*  589 */         return false;
/*      */       }
/*  591 */       param1Object = param1Object;
/*  592 */       TypeDescription typeDescription = getAnnotationType();
/*  593 */       if (!param1Object.getAnnotationType().equals(typeDescription)) {
/*  594 */         return false;
/*      */       }
/*  596 */       for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
/*  597 */         if (!getValue(inDefinedShape).equals(param1Object.getValue(inDefinedShape))) {
/*  598 */           return false;
/*      */         }
/*      */       } 
/*  601 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  606 */       TypeDescription typeDescription = getAnnotationType();
/*  607 */       StringBuilder stringBuilder = new StringBuilder("@");
/*  608 */       AnnotationDescription.RenderingDispatcher.CURRENT.appendType(stringBuilder, typeDescription);
/*  609 */       stringBuilder.append('(');
/*  610 */       boolean bool = true;
/*  611 */       for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
/*      */         AnnotationValue<?, ?> annotationValue;
/*  613 */         if ((annotationValue = getValue(inDefinedShape)).getState() != AnnotationValue.State.UNDEFINED) {
/*      */           
/*  615 */           if (bool) {
/*  616 */             bool = false;
/*      */           } else {
/*  618 */             stringBuilder.append(", ");
/*      */           } 
/*  620 */           AnnotationDescription.RenderingDispatcher.CURRENT.appendPrefix(stringBuilder, inDefinedShape.getName(), typeDescription.getDeclaredMethods().size());
/*  621 */           stringBuilder.append(annotationValue);
/*      */         } 
/*  623 */       }  return stringBuilder.append(')').toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForLoadedAnnotation<S extends Annotation>
/*      */     extends AbstractBase
/*      */     implements Loadable<S>
/*      */   {
/*  637 */     private static final Object[] NO_ARGUMENT = new Object[0]; private final S annotation; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Class<S> annotationType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final boolean ACCESS_CONTROLLER;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForLoadedAnnotation(S param1S) {
/*  657 */       this(param1S, (Class)param1S.annotationType());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private ForLoadedAnnotation(S param1S, Class<S> param1Class) {
/*  668 */       this.annotation = param1S;
/*  669 */       this.annotationType = param1Class;
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
/*  681 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static <U extends Annotation> AnnotationDescription.Loadable<U> of(U param1U) {
/*  692 */       return new ForLoadedAnnotation<U>(param1U);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public S load() {
/*  699 */       return (this.annotationType == this.annotation.annotationType()) ? this.annotation : 
/*      */         
/*  701 */         AnnotationDescription.AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, asValue((Annotation)this.annotation));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static Map<String, AnnotationValue<?, ?>> asValue(Annotation param1Annotation) {
/*  712 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>(); Method[] arrayOfMethod; int i; byte b;
/*  713 */       for (i = (arrayOfMethod = param1Annotation.annotationType().getDeclaredMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/*      */         try {
/*  715 */           hashMap.put(method.getName(), asValue(method.invoke(param1Annotation, NO_ARGUMENT), method.getReturnType()));
/*  716 */         } catch (InvocationTargetException invocationTargetException2) {
/*      */           Throwable throwable; InvocationTargetException invocationTargetException1;
/*  718 */           if (throwable = (invocationTargetException1 = null).getTargetException() instanceof TypeNotPresentException) {
/*  719 */             hashMap.put(method.getName(), new AnnotationValue.ForMissingType<Object, Object>(((TypeNotPresentException)throwable).typeName()));
/*  720 */           } else if (throwable instanceof EnumConstantNotPresentException) {
/*  721 */             hashMap.put(method.getName(), new AnnotationValue.ForEnumerationDescription.WithUnknownConstant<Enum>((TypeDescription)new TypeDescription.ForLoadedType(((EnumConstantNotPresentException)throwable)
/*  722 */                     .enumType()), ((EnumConstantNotPresentException)throwable)
/*  723 */                   .constantName()));
/*  724 */           } else if (throwable instanceof AnnotationTypeMismatchException) {
/*  725 */             hashMap.put(method.getName(), new AnnotationValue.ForMismatchedType<Object, Object>((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(((AnnotationTypeMismatchException)throwable)
/*  726 */                     .element()), ((AnnotationTypeMismatchException)throwable)
/*  727 */                   .foundType()));
/*  728 */           } else if (!(throwable instanceof IncompleteAnnotationException)) {
/*  729 */             throw new IllegalStateException("Cannot read " + method, throwable);
/*      */           } 
/*  731 */         } catch (IllegalAccessException illegalAccessException) {
/*  732 */           throw new IllegalStateException("Cannot access " + method, illegalAccessException);
/*      */         }  b++; }
/*      */       
/*  735 */       return (Map)hashMap;
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
/*      */     public static AnnotationValue<?, ?> asValue(Object param1Object, Class<?> param1Class) {
/*  748 */       if (Enum.class.isAssignableFrom(param1Class))
/*  749 */         return AnnotationValue.ForEnumerationDescription.of((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)param1Object)); 
/*  750 */       if (Enum[].class.isAssignableFrom(param1Class)) {
/*      */         
/*  752 */         EnumerationDescription[] arrayOfEnumerationDescription = new EnumerationDescription[(param1Object = param1Object).length];
/*  753 */         byte b1 = 0; int i; byte b2;
/*  754 */         for (i = (param1Object = param1Object).length, b2 = 0; b2 < i; ) { Object object = param1Object[b2];
/*  755 */           arrayOfEnumerationDescription[b1++] = (EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)object); b2++; }
/*      */         
/*  757 */         return AnnotationValue.ForDescriptionArray.of(TypeDescription.ForLoadedType.of(param1Class.getComponentType()), arrayOfEnumerationDescription);
/*  758 */       }  if (Annotation.class.isAssignableFrom(param1Class))
/*  759 */         return AnnotationValue.ForAnnotationDescription.of(TypeDescription.ForLoadedType.of(param1Class), asValue((Annotation)param1Object)); 
/*  760 */       if (Annotation[].class.isAssignableFrom(param1Class)) {
/*      */         
/*  762 */         AnnotationDescription[] arrayOfAnnotationDescription = new AnnotationDescription[(param1Object = param1Object).length];
/*  763 */         byte b1 = 0; int i; byte b2;
/*  764 */         for (i = (param1Object = param1Object).length, b2 = 0; b2 < i; ) { Object object = param1Object[b2];
/*  765 */           arrayOfAnnotationDescription[b1++] = new AnnotationDescription.Latent(TypeDescription.ForLoadedType.of(param1Class.getComponentType()), asValue((Annotation)object)); b2++; }
/*      */         
/*  767 */         return AnnotationValue.ForDescriptionArray.of(TypeDescription.ForLoadedType.of(param1Class.getComponentType()), arrayOfAnnotationDescription);
/*  768 */       }  if (Class.class.isAssignableFrom(param1Class))
/*  769 */         return AnnotationValue.ForTypeDescription.of(TypeDescription.ForLoadedType.of((Class)param1Object)); 
/*  770 */       if (Class[].class.isAssignableFrom(param1Class)) {
/*      */         
/*  772 */         TypeDescription[] arrayOfTypeDescription = new TypeDescription[(param1Object = param1Object).length];
/*  773 */         byte b1 = 0; int i; byte b2;
/*  774 */         for (i = (param1Object = param1Object).length, b2 = 0; b2 < i; ) { Object object = param1Object[b2];
/*  775 */           arrayOfTypeDescription[b1++] = TypeDescription.ForLoadedType.of((Class)object); b2++; }
/*      */         
/*  777 */         return AnnotationValue.ForDescriptionArray.of(arrayOfTypeDescription);
/*      */       } 
/*  779 */       return AnnotationValue.ForConstant.of(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should always be wrapped for clarity.")
/*      */     public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape param1InDefinedShape) {
/*  789 */       if (!param1InDefinedShape.getDeclaringType().represents(this.annotation.annotationType())) {
/*  790 */         throw new IllegalArgumentException(param1InDefinedShape + " does not represent " + this.annotation.annotationType());
/*      */       }
/*      */       try {
/*  793 */         boolean bool = param1InDefinedShape.getDeclaringType().isPublic();
/*      */         
/*      */         Method method;
/*      */         
/*  797 */         if ((method = (Method)((param1InDefinedShape instanceof MethodDescription.ForLoadedMethod) ? ((MethodDescription.ForLoadedMethod)param1InDefinedShape).getLoadedMethod() : null)) == null || method.getDeclaringClass() != this.annotation.annotationType() || (!bool && !method.isAccessible())) {
/*  798 */           method = this.annotation.annotationType().getMethod(param1InDefinedShape.getName(), new Class[0]);
/*  799 */           if (!bool) {
/*  800 */             doPrivileged((PrivilegedAction<?>)new SetAccessibleAction(method));
/*      */           }
/*      */         } 
/*  803 */         return asValue(method.invoke(this.annotation, NO_ARGUMENT), method.getReturnType()).filter(param1InDefinedShape);
/*  804 */       } catch (InvocationTargetException invocationTargetException2) {
/*      */         InvocationTargetException invocationTargetException1; Throwable throwable;
/*  806 */         if (throwable = (invocationTargetException1 = null).getTargetException() instanceof TypeNotPresentException)
/*  807 */           return new AnnotationValue.ForMissingType<Object, Object>(((TypeNotPresentException)throwable).typeName()); 
/*  808 */         if (throwable instanceof EnumConstantNotPresentException)
/*  809 */           return new AnnotationValue.ForEnumerationDescription.WithUnknownConstant((TypeDescription)new TypeDescription.ForLoadedType(((EnumConstantNotPresentException)throwable)
/*  810 */                 .enumType()), ((EnumConstantNotPresentException)throwable)
/*  811 */               .constantName()); 
/*  812 */         if (throwable instanceof AnnotationTypeMismatchException)
/*  813 */           return new AnnotationValue.ForMismatchedType<Object, Object>((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(((AnnotationTypeMismatchException)throwable)
/*  814 */                 .element()), ((AnnotationTypeMismatchException)throwable)
/*  815 */               .foundType()); 
/*  816 */         if (throwable instanceof IncompleteAnnotationException) {
/*  817 */           return new AnnotationValue.ForMissingValue<Object, Object>((TypeDescription)new TypeDescription.ForLoadedType(((IncompleteAnnotationException)throwable)
/*  818 */                 .annotationType()), ((IncompleteAnnotationException)throwable)
/*  819 */               .elementName());
/*      */         }
/*  821 */         throw new IllegalStateException("Error reading annotation property " + param1InDefinedShape, throwable);
/*      */       }
/*  823 */       catch (Exception exception) {
/*  824 */         throw new IllegalStateException("Cannot access annotation property " + param1InDefinedShape, exception);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <T extends Annotation> AnnotationDescription.Loadable<T> prepare(Class<T> param1Class) {
/*  833 */       if (!this.annotation.annotationType().getName().equals(param1Class.getName())) {
/*  834 */         throw new IllegalArgumentException(param1Class + " does not represent " + this.annotation.annotationType());
/*      */       }
/*  836 */       return (param1Class == this.annotation.annotationType()) ? this : new ForLoadedAnnotation(this.annotation, param1Class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getAnnotationType() {
/*  845 */       return TypeDescription.ForLoadedType.of(this.annotation.annotationType());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Latent
/*      */     extends AbstractBase
/*      */   {
/*      */     private final TypeDescription annotationType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Map<String, ? extends AnnotationValue<?, ?>> annotationValues;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Latent(TypeDescription param1TypeDescription, Map<String, ? extends AnnotationValue<?, ?>> param1Map) {
/*  871 */       this.annotationType = param1TypeDescription;
/*  872 */       this.annotationValues = param1Map;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape param1InDefinedShape) {
/*  879 */       if (!param1InDefinedShape.getDeclaringType().equals(this.annotationType)) {
/*  880 */         throw new IllegalArgumentException("Not a property of " + this.annotationType + ": " + param1InDefinedShape);
/*      */       }
/*      */       AnnotationValue<?, ?> annotationValue;
/*  883 */       if ((annotationValue = this.annotationValues.get(param1InDefinedShape.getName())) != null) {
/*  884 */         return annotationValue.filter(param1InDefinedShape);
/*      */       }
/*      */       
/*  887 */       return ((annotationValue = param1InDefinedShape.getDefaultValue()) == null) ? new AnnotationValue.ForMissingValue<Object, Object>(this.annotationType, param1InDefinedShape
/*  888 */           .getName()) : annotationValue;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getAnnotationType() {
/*  896 */       return this.annotationType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <T extends Annotation> Loadable<T> prepare(Class<T> param1Class) {
/*  903 */       if (!this.annotationType.represents(param1Class)) {
/*  904 */         throw new IllegalArgumentException(param1Class + " does not represent " + this.annotationType);
/*      */       }
/*  906 */       return new Loadable<T>(this, param1Class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected class Loadable<S extends Annotation>
/*      */       extends AnnotationDescription.AbstractBase
/*      */       implements AnnotationDescription.Loadable<S>
/*      */     {
/*      */       private final Class<S> annotationType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Loadable(AnnotationDescription.Latent this$0, Class<S> param2Class) {
/*  927 */         this.annotationType = param2Class;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public S load() {
/*  934 */         return AnnotationDescription.AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, AnnotationDescription.Latent.a(this.a));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape param2InDefinedShape) {
/*  941 */         return this.a.getValue(param2InDefinedShape);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription getAnnotationType() {
/*  948 */         return TypeDescription.ForLoadedType.of(this.annotationType);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public <T extends Annotation> AnnotationDescription.Loadable<T> prepare(Class<T> param2Class) {
/*  955 */         return this.a.prepare(param2Class);
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
/*      */   @Enhance
/*      */   public static class Builder
/*      */   {
/*      */     private final TypeDescription annotationType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Map<String, AnnotationValue<?, ?>> annotationValues;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Builder(TypeDescription param1TypeDescription, Map<String, AnnotationValue<?, ?>> param1Map) {
/*  983 */       this.annotationType = param1TypeDescription;
/*  984 */       this.annotationValues = param1Map;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder ofType(Class<? extends Annotation> param1Class) {
/*  994 */       return ofType(TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder ofType(TypeDescription param1TypeDescription) {
/* 1004 */       if (!param1TypeDescription.isAnnotation()) {
/* 1005 */         throw new IllegalArgumentException("Not an annotation type: " + param1TypeDescription);
/*      */       }
/* 1007 */       return new Builder(param1TypeDescription, Collections.emptyMap());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, AnnotationValue<?, ?> param1AnnotationValue) {
/*      */       MethodList methodList;
/* 1019 */       if ((methodList = (MethodList)this.annotationType.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.named(param1String))).isEmpty()) {
/* 1020 */         throw new IllegalArgumentException(this.annotationType + " does not define a property named " + param1String);
/*      */       }
/*      */       HashMap<String, AnnotationValue<?, ?>> hashMap;
/* 1023 */       if ((hashMap = new HashMap<String, AnnotationValue<?, ?>>(this.annotationValues)).put(((MethodDescription.InDefinedShape)methodList.getOnly()).getName(), param1AnnotationValue) != null) {
/* 1024 */         throw new IllegalArgumentException("Property already defined: " + param1String);
/*      */       }
/* 1026 */       return new Builder(this.annotationType, hashMap);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, Enum<?> param1Enum) {
/* 1037 */       return define(param1String, (EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration(param1Enum));
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
/*      */     public Builder define(String param1String1, TypeDescription param1TypeDescription, String param1String2) {
/* 1049 */       return define(param1String1, (EnumerationDescription)new EnumerationDescription.Latent(param1TypeDescription, param1String2));
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
/*      */     public Builder define(String param1String, EnumerationDescription param1EnumerationDescription) {
/* 1061 */       return define(param1String, AnnotationValue.ForEnumerationDescription.of(param1EnumerationDescription));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, Annotation param1Annotation) {
/* 1072 */       return define(param1String, new AnnotationDescription.ForLoadedAnnotation<Annotation>(param1Annotation));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, AnnotationDescription param1AnnotationDescription) {
/* 1083 */       return define(param1String, new AnnotationValue.ForAnnotationDescription(param1AnnotationDescription));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, Class<?> param1Class) {
/* 1094 */       return define(param1String, TypeDescription.ForLoadedType.of(param1Class));
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
/*      */     public Builder define(String param1String, TypeDescription param1TypeDescription) {
/* 1106 */       return define(param1String, AnnotationValue.ForTypeDescription.of(param1TypeDescription));
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
/*      */     public <T extends Enum<?>> Builder defineEnumerationArray(String param1String, Class<T> param1Class, T... param1VarArgs) {
/* 1120 */       EnumerationDescription[] arrayOfEnumerationDescription = new EnumerationDescription[param1VarArgs.length];
/* 1121 */       byte b1 = 0; int i; byte b2;
/* 1122 */       for (i = (param1VarArgs = param1VarArgs).length, b2 = 0; b2 < i; ) { T t = param1VarArgs[b2];
/* 1123 */         arrayOfEnumerationDescription[b1++] = (EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)t); b2++; }
/*      */       
/* 1125 */       return defineEnumerationArray(param1String, TypeDescription.ForLoadedType.of(param1Class), arrayOfEnumerationDescription);
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
/*      */     public Builder defineEnumerationArray(String param1String, TypeDescription param1TypeDescription, String... param1VarArgs) {
/* 1137 */       if (!param1TypeDescription.isEnum()) {
/* 1138 */         throw new IllegalArgumentException("Not an enumeration type: " + param1TypeDescription);
/*      */       }
/* 1140 */       EnumerationDescription[] arrayOfEnumerationDescription = new EnumerationDescription[param1VarArgs.length];
/* 1141 */       for (byte b = 0; b < param1VarArgs.length; b++) {
/* 1142 */         arrayOfEnumerationDescription[b] = (EnumerationDescription)new EnumerationDescription.Latent(param1TypeDescription, param1VarArgs[b]);
/*      */       }
/* 1144 */       return defineEnumerationArray(param1String, param1TypeDescription, arrayOfEnumerationDescription);
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
/*      */     public Builder defineEnumerationArray(String param1String, TypeDescription param1TypeDescription, EnumerationDescription... param1VarArgs) {
/* 1157 */       return define(param1String, AnnotationValue.ForDescriptionArray.of(param1TypeDescription, param1VarArgs));
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
/*      */     public <T extends Annotation> Builder defineAnnotationArray(String param1String, Class<T> param1Class, T... param1VarArgs) {
/* 1171 */       return defineAnnotationArray(param1String, 
/* 1172 */           TypeDescription.ForLoadedType.of(param1Class), (AnnotationDescription[])(new AnnotationList.ForLoadedAnnotations((Annotation[])param1VarArgs))
/* 1173 */           .toArray((Object[])new AnnotationDescription[0]));
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
/*      */     public Builder defineAnnotationArray(String param1String, TypeDescription param1TypeDescription, AnnotationDescription... param1VarArgs) {
/* 1185 */       return define(param1String, AnnotationValue.ForDescriptionArray.of(param1TypeDescription, param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineTypeArray(String param1String, Class<?>... param1VarArgs) {
/* 1196 */       return defineTypeArray(param1String, (TypeDescription[])(new TypeList.ForLoadedTypes(param1VarArgs)).toArray((Object[])new TypeDescription[0]));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineTypeArray(String param1String, TypeDescription... param1VarArgs) {
/* 1207 */       return define(param1String, AnnotationValue.ForDescriptionArray.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, boolean param1Boolean) {
/* 1218 */       return define(param1String, AnnotationValue.ForConstant.of(param1Boolean));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, byte param1Byte) {
/* 1229 */       return define(param1String, AnnotationValue.ForConstant.of(param1Byte));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, char param1Char) {
/* 1240 */       return define(param1String, AnnotationValue.ForConstant.of(param1Char));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, short param1Short) {
/* 1251 */       return define(param1String, AnnotationValue.ForConstant.of(param1Short));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, int param1Int) {
/* 1262 */       return define(param1String, AnnotationValue.ForConstant.of(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, long param1Long) {
/* 1273 */       return define(param1String, AnnotationValue.ForConstant.of(param1Long));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, float param1Float) {
/* 1284 */       return define(param1String, AnnotationValue.ForConstant.of(param1Float));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String, double param1Double) {
/* 1295 */       return define(param1String, AnnotationValue.ForConstant.of(param1Double));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder define(String param1String1, String param1String2) {
/* 1306 */       return define(param1String1, AnnotationValue.ForConstant.of(param1String2));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, boolean... param1VarArgs) {
/* 1317 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, byte... param1VarArgs) {
/* 1328 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, char... param1VarArgs) {
/* 1339 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, short... param1VarArgs) {
/* 1350 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, int... param1VarArgs) {
/* 1361 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, long... param1VarArgs) {
/* 1372 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, float... param1VarArgs) {
/* 1383 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, double... param1VarArgs) {
/* 1394 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder defineArray(String param1String, String... param1VarArgs) {
/* 1405 */       return define(param1String, AnnotationValue.ForConstant.of(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationDescription build() {
/* 1415 */       for (MethodDescription.InDefinedShape inDefinedShape : this.annotationType.getDeclaredMethods()) {
/*      */         AnnotationValue annotationValue;
/* 1417 */         if ((annotationValue = this.annotationValues.get(inDefinedShape.getName())) == null && inDefinedShape.getDefaultValue() == null)
/* 1418 */           throw new IllegalStateException("No value or default value defined for " + inDefinedShape.getName()); 
/* 1419 */         if (annotationValue != null && annotationValue.filter(inDefinedShape).getState() != AnnotationValue.State.RESOLVED) {
/* 1420 */           throw new IllegalStateException("Illegal annotation value for " + inDefinedShape + ": " + annotationValue);
/*      */         }
/*      */       } 
/* 1423 */       return new AnnotationDescription.Latent(this.annotationType, this.annotationValues);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationDescription build(boolean param1Boolean) {
/* 1433 */       if (param1Boolean)
/* 1434 */         return build();  return new AnnotationDescription.Latent(this.annotationType, this.annotationValues);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.annotationType.equals(((Builder)param1Object).annotationType) ? false : (!!this.annotationValues.equals(((Builder)param1Object).annotationValues)))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.annotationType.hashCode()) * 31 + this.annotationValues.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\annotation\AnnotationDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */