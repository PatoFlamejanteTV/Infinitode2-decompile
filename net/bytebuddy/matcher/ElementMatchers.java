/*      */ package net.bytebuddy.matcher;
/*      */ 
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentMap;
/*      */ import net.bytebuddy.description.ByteCodeElement;
/*      */ import net.bytebuddy.description.DeclaredByType;
/*      */ import net.bytebuddy.description.ModifierReviewable;
/*      */ import net.bytebuddy.description.NamedElement;
/*      */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.method.ParameterList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
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
/*      */ public final class ElementMatchers
/*      */ {
/*      */   private ElementMatchers() {
/*   56 */     throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> ElementMatcher.Junction<T> failSafe(ElementMatcher<? super T> paramElementMatcher) {
/*   67 */     return new FailSafeMatcher<T>(paramElementMatcher, false);
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
/*      */   public static <T> ElementMatcher.Junction<T> cached(ElementMatcher<? super T> paramElementMatcher, ConcurrentMap<? super T, Boolean> paramConcurrentMap) {
/*   86 */     return new CachingMatcher<T>(paramElementMatcher, paramConcurrentMap);
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
/*      */   public static <T> ElementMatcher.Junction<T> cached(ElementMatcher<? super T> paramElementMatcher, int paramInt) {
/*  107 */     if (paramInt <= 0) {
/*  108 */       throw new IllegalArgumentException("Eviction size must be a positive number: " + paramInt);
/*      */     }
/*  110 */     return new CachingMatcher.WithInlineEviction<T>(paramElementMatcher, new ConcurrentHashMap<T, Boolean>(), paramInt);
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
/*      */   public static <T> ElementMatcher.Junction<T> is(@MaybeNull Object paramObject) {
/*  122 */     if (paramObject == null)
/*  123 */       return NullMatcher.make();  return new EqualityMatcher<T>(paramObject);
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
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> is(Field paramField) {
/*  135 */     return is((FieldDescription.InDefinedShape)new FieldDescription.ForLoadedField(paramField));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> is(FieldDescription.InDefinedShape paramInDefinedShape) {
/*  146 */     return definedField(new EqualityMatcher<FieldDescription.InDefinedShape>(paramInDefinedShape));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> definedField(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/*  157 */     return (ElementMatcher.Junction)new DefinedShapeMatcher<ByteCodeElement.TypeDependant<FieldDescription.InDefinedShape, ?>, FieldDescription.InDefinedShape>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> is(Method paramMethod) {
/*  168 */     return is((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(paramMethod));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> is(Constructor<?> paramConstructor) {
/*  179 */     return is((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(paramConstructor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> is(MethodDescription.InDefinedShape paramInDefinedShape) {
/*  190 */     return definedMethod(new EqualityMatcher<MethodDescription.InDefinedShape>(paramInDefinedShape));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> definedMethod(ElementMatcher<? super MethodDescription.InDefinedShape> paramElementMatcher) {
/*  201 */     return (ElementMatcher.Junction)new DefinedShapeMatcher<ByteCodeElement.TypeDependant<MethodDescription.InDefinedShape, ?>, MethodDescription.InDefinedShape>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ParameterDescription> ElementMatcher.Junction<T> is(ParameterDescription.InDefinedShape paramInDefinedShape) {
/*  212 */     return definedParameter(new EqualityMatcher<ParameterDescription.InDefinedShape>(paramInDefinedShape));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ParameterDescription> ElementMatcher.Junction<T> definedParameter(ElementMatcher<? super ParameterDescription.InDefinedShape> paramElementMatcher) {
/*  223 */     return (ElementMatcher.Junction)new DefinedShapeMatcher<ByteCodeElement.TypeDependant<ParameterDescription.InDefinedShape, ?>, ParameterDescription.InDefinedShape>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ParameterDescription> ElementMatcher.Junction<T> hasType(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/*  234 */     return hasGenericType(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ParameterDescription> ElementMatcher.Junction<T> hasGenericType(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/*  245 */     return new MethodParameterTypeMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ParameterDescription> ElementMatcher.Junction<T> isMandated() {
/*  255 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.MANDATED);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> is(Type paramType) {
/*  266 */     return is(TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends AnnotationDescription> ElementMatcher.Junction<T> is(Annotation paramAnnotation) {
/*  277 */     return is(AnnotationDescription.ForLoadedAnnotation.of(paramAnnotation));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> ElementMatcher.Junction<T> not(ElementMatcher<? super T> paramElementMatcher) {
/*  288 */     return new NegatingMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> ElementMatcher.Junction<T> any() {
/*  298 */     return BooleanMatcher.of(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> ElementMatcher.Junction<T> none() {
/*  308 */     return BooleanMatcher.of(false);
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
/*      */   public static <T> ElementMatcher.Junction<T> anyOf(Object... paramVarArgs) {
/*  326 */     return anyOf(Arrays.asList(paramVarArgs));
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
/*      */   public static <T> ElementMatcher.Junction<T> anyOf(Iterable<?> paramIterable) {
/*  344 */     ElementMatcher.Junction<T> junction = null;
/*  345 */     for (Object object : paramIterable)
/*      */     {
/*      */       
/*  348 */       junction = (junction == null) ? is(object) : junction.<T>or(is(object));
/*      */     }
/*  350 */     if (junction == null)
/*  351 */       return none();  return junction;
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
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> anyOf(Type... paramVarArgs) {
/*  364 */     return anyOf((Iterable<?>)new TypeList.Generic.ForLoadedTypes(paramVarArgs));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> anyOf(Constructor<?>... paramVarArgs) {
/*  376 */     return definedMethod(anyOf((Iterable<?>)new MethodList.ForLoadedMethods((Constructor[])paramVarArgs, new Method[0])));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> anyOf(Method... paramVarArgs) {
/*  388 */     return definedMethod(anyOf((Iterable<?>)new MethodList.ForLoadedMethods(new Constructor[0], paramVarArgs)));
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
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> anyOf(Field... paramVarArgs) {
/*  400 */     return definedField(anyOf((Iterable<?>)new FieldList.ForLoadedFields(paramVarArgs)));
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
/*      */   public static <T extends AnnotationDescription> ElementMatcher.Junction<T> anyOf(Annotation... paramVarArgs) {
/*  412 */     return anyOf((Iterable<?>)new AnnotationList.ForLoadedAnnotations(paramVarArgs));
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
/*      */   public static <T> ElementMatcher.Junction<T> noneOf(Object... paramVarArgs) {
/*  424 */     return noneOf(Arrays.asList(paramVarArgs));
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
/*      */   public static <T> ElementMatcher.Junction<T> noneOf(Iterable<?> paramIterable) {
/*  436 */     ElementMatcher.Junction<T> junction = null;
/*  437 */     for (Object object : paramIterable)
/*      */     {
/*      */       
/*  440 */       junction = (junction == null) ? not(is(object)) : junction.<T>and(not(is(object)));
/*      */     }
/*  442 */     if (junction == null)
/*  443 */       return any();  return junction;
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
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> noneOf(Type... paramVarArgs) {
/*  456 */     return noneOf((Iterable<?>)new TypeList.Generic.ForLoadedTypes(paramVarArgs));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> noneOf(Constructor<?>... paramVarArgs) {
/*  468 */     return definedMethod(noneOf((Iterable<?>)new MethodList.ForLoadedMethods((Constructor[])paramVarArgs, new Method[0])));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> noneOf(Method... paramVarArgs) {
/*  480 */     return definedMethod(noneOf((Iterable<?>)new MethodList.ForLoadedMethods(new Constructor[0], paramVarArgs)));
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
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> noneOf(Field... paramVarArgs) {
/*  492 */     return definedField(noneOf((Iterable<?>)new FieldList.ForLoadedFields(paramVarArgs)));
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
/*      */   public static <T extends AnnotationDescription> ElementMatcher.Junction<T> noneOf(Annotation... paramVarArgs) {
/*  504 */     return noneOf((Iterable<?>)new AnnotationList.ForLoadedAnnotations(paramVarArgs));
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
/*      */   public static <T> ElementMatcher.Junction<Iterable<? extends T>> whereAny(ElementMatcher<? super T> paramElementMatcher) {
/*  516 */     return new CollectionItemMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> ElementMatcher.Junction<Iterable<? extends T>> whereNone(ElementMatcher<? super T> paramElementMatcher) {
/*  527 */     return not(whereAny(paramElementMatcher));
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
/*      */   public static <T extends TypeDescription.Generic> ElementMatcher.Junction<T> erasure(Class<?> paramClass) {
/*  539 */     return erasure(is(paramClass));
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
/*      */   public static <T extends TypeDescription.Generic> ElementMatcher.Junction<T> erasure(TypeDescription paramTypeDescription) {
/*  551 */     return erasure(is(paramTypeDescription));
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
/*      */   public static <T extends TypeDescription.Generic> ElementMatcher.Junction<T> erasure(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/*  563 */     return (ElementMatcher.Junction)new ErasureMatcher<TypeDefinition>(paramElementMatcher);
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
/*      */   public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(Class<?>... paramVarArgs) {
/*  575 */     return erasures((Iterable<? extends TypeDescription>)new TypeList.ForLoadedTypes(paramVarArgs));
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
/*      */   public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(TypeDescription... paramVarArgs) {
/*  587 */     return erasures(Arrays.asList(paramVarArgs));
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
/*      */   public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(Iterable<? extends TypeDescription> paramIterable) {
/*  600 */     ArrayList<? extends ElementMatcher<?>> arrayList = new ArrayList();
/*  601 */     for (TypeDescription typeDescription : paramIterable) {
/*  602 */       arrayList.add(is(typeDescription));
/*      */     }
/*  604 */     return erasures(new CollectionOneToOneMatcher(arrayList));
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
/*      */   public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(ElementMatcher<? super Iterable<? extends TypeDescription>> paramElementMatcher) {
/*  617 */     return (ElementMatcher.Junction)new CollectionErasureMatcher<Iterable<? extends TypeDefinition>>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> isVariable(String paramString) {
/*  628 */     return isVariable(named(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> isVariable(ElementMatcher<? super NamedElement> paramElementMatcher) {
/*  639 */     return (new TypeSortMatcher<TypeDefinition>(anyOf(new Object[] { TypeDefinition.Sort.VARIABLE, TypeDefinition.Sort.VARIABLE_SYMBOLIC }))).and(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> named(String paramString) {
/*  650 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.EQUALS_FULLY));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> namedOneOf(String... paramVarArgs) {
/*  661 */     return new NameMatcher<T>(new StringSetMatcher(new HashSet<String>(Arrays.asList(paramVarArgs))));
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
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> namedIgnoreCase(String paramString) {
/*  673 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.EQUALS_FULLY_IGNORE_CASE));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> nameStartsWith(String paramString) {
/*  684 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.STARTS_WITH));
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
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> nameStartsWithIgnoreCase(String paramString) {
/*  696 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.STARTS_WITH_IGNORE_CASE));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> nameEndsWith(String paramString) {
/*  707 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.ENDS_WITH));
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
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> nameEndsWithIgnoreCase(String paramString) {
/*  719 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.ENDS_WITH_IGNORE_CASE));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> nameContains(String paramString) {
/*  730 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.CONTAINS));
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
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> nameContainsIgnoreCase(String paramString) {
/*  742 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.CONTAINS_IGNORE_CASE));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement> ElementMatcher.Junction<T> nameMatches(String paramString) {
/*  753 */     return new NameMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.MATCHES));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement.WithOptionalName> ElementMatcher.Junction<T> isNamed() {
/*  763 */     return new IsNamedMatcher<T>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends NamedElement.WithDescriptor> ElementMatcher.Junction<T> hasDescriptor(String paramString) {
/*  774 */     return new DescriptorMatcher<T>(new StringMatcher(paramString, StringMatcher.Mode.EQUALS_FULLY));
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
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredBy(Class<?> paramClass) {
/*  786 */     return isDeclaredBy(TypeDescription.ForLoadedType.of(paramClass));
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
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredBy(TypeDescription paramTypeDescription) {
/*  798 */     return isDeclaredBy(is(paramTypeDescription));
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
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredBy(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/*  811 */     return isDeclaredByGeneric(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredByGeneric(Type paramType) {
/*  822 */     return isDeclaredByGeneric(TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredByGeneric(TypeDescription.Generic paramGeneric) {
/*  833 */     return isDeclaredByGeneric(is(paramGeneric));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredByGeneric(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/*  844 */     return (ElementMatcher.Junction)new DeclaringTypeMatcher<DeclaredByType>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isVisibleTo(Class<?> paramClass) {
/*  855 */     return isVisibleTo(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isVisibleTo(TypeDescription paramTypeDescription) {
/*  866 */     return new VisibilityMatcher<T>(paramTypeDescription);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isAccessibleTo(Class<?> paramClass) {
/*  877 */     return isAccessibleTo(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isAccessibleTo(TypeDescription paramTypeDescription) {
/*  888 */     return new AccessibilityMatcher<T>(paramTypeDescription);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.OfAbstraction> ElementMatcher.Junction<T> isAbstract() {
/*  898 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.ABSTRACT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.OfEnumeration> ElementMatcher.Junction<T> isEnum() {
/*  908 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.ENUMERATION);
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
/*      */   public static <T extends net.bytebuddy.description.annotation.AnnotationSource> ElementMatcher.Junction<T> isAnnotatedWith(Class<? extends Annotation> paramClass) {
/*  921 */     return isAnnotatedWith(TypeDescription.ForLoadedType.of(paramClass));
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
/*      */   public static <T extends net.bytebuddy.description.annotation.AnnotationSource> ElementMatcher.Junction<T> isAnnotatedWith(TypeDescription paramTypeDescription) {
/*  935 */     return isAnnotatedWith(is(paramTypeDescription));
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
/*      */   public static <T extends net.bytebuddy.description.annotation.AnnotationSource> ElementMatcher.Junction<T> isAnnotatedWith(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/*  950 */     return declaresAnnotation(annotationType(paramElementMatcher));
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
/*      */   public static <T extends net.bytebuddy.description.annotation.AnnotationSource> ElementMatcher.Junction<T> declaresAnnotation(ElementMatcher<? super AnnotationDescription> paramElementMatcher) {
/*  965 */     return new DeclaringAnnotationMatcher<T>((ElementMatcher)new CollectionItemMatcher<AnnotationDescription>(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isPublic() {
/*  975 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.PUBLIC);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isProtected() {
/*  985 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.PROTECTED);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isPackagePrivate() {
/*  995 */     return not(isPublic().or(isProtected()).or(isPrivate()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isPrivate() {
/* 1005 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.PRIVATE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isStatic() {
/* 1015 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.STATIC);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable> ElementMatcher.Junction<T> isFinal() {
/* 1025 */     return ModifierMatcher.of(ModifierMatcher.Mode.FINAL);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable> ElementMatcher.Junction<T> isSynthetic() {
/* 1035 */     return ModifierMatcher.of(ModifierMatcher.Mode.SYNTHETIC);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isSynchronized() {
/* 1045 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.SYNCHRONIZED);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isNative() {
/* 1055 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.NATIVE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isStrict() {
/* 1065 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.STRICT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isVarArgs() {
/* 1075 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.VAR_ARGS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isBridge() {
/* 1085 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.BRIDGE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> returnsGeneric(Type paramType) {
/* 1096 */     return returnsGeneric(TypeDefinition.Sort.describe(paramType));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> returnsGeneric(TypeDescription.Generic paramGeneric) {
/* 1108 */     return returnsGeneric(is(paramGeneric));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> returns(Class<?> paramClass) {
/* 1119 */     return returnsGeneric(erasure(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> returns(TypeDescription paramTypeDescription) {
/* 1130 */     return returns(is(paramTypeDescription));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> returns(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1141 */     return returnsGeneric(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> returnsGeneric(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 1152 */     return new MethodReturnTypeMatcher<T>(paramElementMatcher);
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArgument(int paramInt, Type paramType) {
/* 1164 */     return takesGenericArgument(paramInt, TypeDefinition.Sort.describe(paramType));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArgument(int paramInt, TypeDescription.Generic paramGeneric) {
/* 1176 */     return takesGenericArgument(paramInt, is(paramGeneric));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArgument(int paramInt, ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 1188 */     return takesGenericArguments(new CollectionElementMatcher<TypeDescription.Generic>(paramInt, paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(Type... paramVarArgs) {
/* 1199 */     return takesGenericArguments((List<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(TypeDefinition... paramVarArgs) {
/* 1210 */     return takesGenericArguments(Arrays.asList(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(List<? extends TypeDefinition> paramList) {
/* 1221 */     ArrayList<? extends ElementMatcher<?>> arrayList = new ArrayList();
/* 1222 */     for (TypeDefinition typeDefinition : paramList) {
/* 1223 */       arrayList.add(is(typeDefinition));
/*      */     }
/* 1225 */     return takesGenericArguments(new CollectionOneToOneMatcher(arrayList));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(ElementMatcher<? super Iterable<? extends TypeDescription.Generic>> paramElementMatcher) {
/* 1236 */     return new MethodParametersMatcher<T>(new MethodParameterTypesMatcher<ParameterList<? extends ParameterDescription>>((ElementMatcher)paramElementMatcher));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArgument(int paramInt, Class<?> paramClass) {
/* 1248 */     return takesArgument(paramInt, TypeDescription.ForLoadedType.of(paramClass));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArgument(int paramInt, TypeDescription paramTypeDescription) {
/* 1260 */     return takesArgument(paramInt, is(paramTypeDescription));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArgument(int paramInt, ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1272 */     return takesGenericArgument(paramInt, erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(Class<?>... paramVarArgs) {
/* 1283 */     return takesGenericArguments(erasures(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(TypeDescription... paramVarArgs) {
/* 1294 */     return takesGenericArguments(erasures(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(Iterable<? extends TypeDescription> paramIterable) {
/* 1305 */     ArrayList<? extends ElementMatcher<?>> arrayList = new ArrayList();
/* 1306 */     for (TypeDescription typeDescription : paramIterable) {
/* 1307 */       arrayList.add(erasure(typeDescription));
/*      */     }
/* 1309 */     return takesGenericArguments(new CollectionOneToOneMatcher(arrayList));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(ElementMatcher<? super Iterable<? extends TypeDescription>> paramElementMatcher) {
/* 1320 */     return new MethodParametersMatcher<T>(new MethodParameterTypesMatcher<ParameterList<? extends ParameterDescription>>(erasures(paramElementMatcher)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(int paramInt) {
/* 1331 */     return new MethodParametersMatcher<T>(new CollectionSizeMatcher<ParameterList<? extends ParameterDescription>>(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> takesNoArguments() {
/* 1341 */     return takesArguments(0);
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> hasParameters(ElementMatcher<? super Iterable<? extends ParameterDescription>> paramElementMatcher) {
/* 1354 */     return new MethodParametersMatcher<T>((ElementMatcher)paramElementMatcher);
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> canThrow(Class<? extends Throwable> paramClass) {
/* 1366 */     return canThrow(TypeDescription.ForLoadedType.of(paramClass));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> canThrow(TypeDescription paramTypeDescription) {
/* 1378 */     if (paramTypeDescription.isAssignableTo(RuntimeException.class) || paramTypeDescription.isAssignableTo(Error.class))
/* 1379 */       return BooleanMatcher.of(true); 
/* 1380 */     return declaresGenericException(new CollectionItemMatcher(erasure(isSuperTypeOf(paramTypeDescription))));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresGenericException(Type paramType) {
/* 1393 */     return declaresGenericException(TypeDefinition.Sort.describe(paramType));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresGenericException(TypeDescription.Generic paramGeneric) {
/* 1406 */     if (!paramGeneric.getSort().isWildcard() && paramGeneric.asErasure().isAssignableTo(Throwable.class))
/* 1407 */       return declaresGenericException(new CollectionItemMatcher(is(paramGeneric))); 
/* 1408 */     return BooleanMatcher.of(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresException(Class<? extends Throwable> paramClass) {
/* 1419 */     return declaresException(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresException(TypeDescription paramTypeDescription) {
/* 1430 */     if (paramTypeDescription.isAssignableTo(Throwable.class))
/* 1431 */       return declaresGenericException(new CollectionItemMatcher(erasure(paramTypeDescription))); 
/* 1432 */     return BooleanMatcher.of(false);
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresGenericException(ElementMatcher<? super Iterable<? extends TypeDescription.Generic>> paramElementMatcher) {
/* 1444 */     return new MethodExceptionTypeMatcher<T>((ElementMatcher)paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFrom(Class<?> paramClass) {
/* 1455 */     return isOverriddenFrom(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFrom(TypeDescription paramTypeDescription) {
/* 1466 */     return isOverriddenFrom(is(paramTypeDescription));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFrom(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1478 */     return isOverriddenFromGeneric(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFromGeneric(Type paramType) {
/* 1489 */     return isOverriddenFromGeneric(TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFromGeneric(TypeDescription.Generic paramGeneric) {
/* 1500 */     return isOverriddenFromGeneric(is(paramGeneric));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFromGeneric(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 1512 */     return new MethodOverrideMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> isInterface() {
/* 1523 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.INTERFACE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> isAnnotation() {
/* 1533 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.ANNOTATION);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isMethod() {
/* 1543 */     return MethodSortMatcher.of(MethodSortMatcher.Sort.METHOD);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isConstructor() {
/* 1553 */     return MethodSortMatcher.of(MethodSortMatcher.Sort.CONSTRUCTOR);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isTypeInitializer() {
/* 1563 */     return MethodSortMatcher.of(MethodSortMatcher.Sort.TYPE_INITIALIZER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isVirtual() {
/* 1573 */     return MethodSortMatcher.of(MethodSortMatcher.Sort.VIRTUAL);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isDefaultMethod() {
/* 1583 */     return MethodSortMatcher.of(MethodSortMatcher.Sort.DEFAULT_METHOD);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isDefaultConstructor() {
/* 1593 */     return isConstructor().and(takesNoArguments());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isMain() {
/* 1603 */     return named("main").and(takesArguments(new Class[] { String[].class })).and(returns(TypeDescription.ForLoadedType.of(void.class)).and(isStatic()).and(isPublic()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isDefaultFinalizer() {
/* 1613 */     return isFinalizer().and(isDeclaredBy(TypeDescription.ForLoadedType.of(Object.class)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isFinalizer() {
/* 1623 */     return named("finalize").and(takesNoArguments()).and(returns(TypeDescription.ForLoadedType.of(void.class)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isHashCode() {
/* 1633 */     return named("hashCode").and(takesNoArguments()).and(returns(int.class));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isEquals() {
/* 1643 */     return named("equals").and(takesArguments(new TypeDescription[] { TypeDescription.ForLoadedType.of(Object.class) })).and(returns(boolean.class));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isClone() {
/* 1653 */     return named("clone").and(takesNoArguments());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isToString() {
/* 1663 */     return named("toString").and(takesNoArguments()).and(returns(TypeDescription.ForLoadedType.of(String.class)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter() {
/* 1673 */     return nameStartsWith("set").and(takesArguments(1)).and(returns(TypeDescription.ForLoadedType.of(void.class)));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(String paramString) {
/* 1685 */     return isSetter().and((paramString.length() == 0) ? 
/* 1686 */         named("set") : 
/* 1687 */         named("set" + Character.toUpperCase(paramString.charAt(0)) + paramString.substring(1)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(Class<?> paramClass) {
/* 1698 */     return isSetter(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericSetter(Type paramType) {
/* 1709 */     return isGenericSetter(TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(TypeDescription paramTypeDescription) {
/* 1720 */     return isSetter(is(paramTypeDescription));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericSetter(TypeDescription.Generic paramGeneric) {
/* 1731 */     return isGenericSetter(is(paramGeneric));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1742 */     return isGenericSetter(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericSetter(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 1753 */     return isSetter().and(takesGenericArguments(new CollectionOneToOneMatcher(Collections.singletonList(paramElementMatcher))));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter() {
/* 1763 */     return takesNoArguments().and(not(returns(TypeDescription.ForLoadedType.of(void.class)))).and(nameStartsWith("get").or(nameStartsWith("is").and(returnsGeneric(anyOf(new Type[] { boolean.class, Boolean.class })))));
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(String paramString) {
/* 1776 */     return isGetter().and((paramString.length() == 0) ? 
/* 1777 */         named("get").or(named("is")) : 
/* 1778 */         named("get" + Character.toUpperCase(paramString.charAt(0)) + paramString.substring(1)).or(named("is" + Character.toUpperCase(paramString.charAt(0)) + paramString.substring(1))));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(Class<?> paramClass) {
/* 1789 */     return isGetter(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericGetter(Type paramType) {
/* 1800 */     return isGenericGetter(TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(TypeDescription paramTypeDescription) {
/* 1811 */     return isGetter(is(paramTypeDescription));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericGetter(TypeDescription.Generic paramGeneric) {
/* 1822 */     return isGenericGetter(is(paramGeneric));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1833 */     return isGenericGetter(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericGetter(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 1844 */     return isGetter().and(returnsGeneric(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> hasMethodName(String paramString) {
/* 1855 */     if ("<init>".equals(paramString))
/* 1856 */       return isConstructor(); 
/* 1857 */     if ("<clinit>".equals(paramString)) {
/* 1858 */       return isTypeInitializer();
/*      */     }
/* 1860 */     return (ElementMatcher.Junction)named(paramString);
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
/*      */   public static <T extends MethodDescription> ElementMatcher.Junction<T> hasSignature(MethodDescription.SignatureToken paramSignatureToken) {
/* 1872 */     return new SignatureTokenMatcher<T>(is(paramSignatureToken));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> isSubTypeOf(Class<?> paramClass) {
/* 1883 */     return isSubTypeOf(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> isSubTypeOf(TypeDescription paramTypeDescription) {
/* 1894 */     return new SubTypeMatcher<T>(paramTypeDescription);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> isSuperTypeOf(Class<?> paramClass) {
/* 1905 */     return isSuperTypeOf(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> isSuperTypeOf(TypeDescription paramTypeDescription) {
/* 1916 */     return new SuperTypeMatcher<T>(paramTypeDescription);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> hasSuperClass(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1927 */     return hasGenericSuperClass(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> hasGenericSuperClass(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 1938 */     return new HasSuperClassMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> hasSuperType(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1949 */     return hasGenericSuperType(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> hasGenericSuperType(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 1960 */     return new HasSuperTypeMatcher<T>(paramElementMatcher);
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
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> inheritsAnnotation(Class<?> paramClass) {
/* 1972 */     return inheritsAnnotation(TypeDescription.ForLoadedType.of(paramClass));
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
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> inheritsAnnotation(TypeDescription paramTypeDescription) {
/* 1984 */     return inheritsAnnotation(is(paramTypeDescription));
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
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> inheritsAnnotation(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 1996 */     return hasAnnotation(annotationType(paramElementMatcher));
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
/*      */   public static <T extends TypeDescription> ElementMatcher.Junction<T> hasAnnotation(ElementMatcher<? super AnnotationDescription> paramElementMatcher) {
/* 2008 */     return new InheritedAnnotationMatcher<T>((ElementMatcher)new CollectionItemMatcher<AnnotationDescription>(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> declaresField(ElementMatcher<? super FieldDescription> paramElementMatcher) {
/* 2019 */     return new DeclaringFieldMatcher<T>((ElementMatcher)new CollectionItemMatcher<FieldDescription>(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> declaresMethod(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/* 2030 */     return new DeclaringMethodMatcher<T>((ElementMatcher)new CollectionItemMatcher<MethodDescription>(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> ofSort(TypeDefinition.Sort paramSort) {
/* 2041 */     return ofSort(is(paramSort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> ofSort(ElementMatcher<? super TypeDefinition.Sort> paramElementMatcher) {
/* 2052 */     return new TypeSortMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> isPrimitive() {
/* 2062 */     return new PrimitiveTypeMatcher<T>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> isArray() {
/* 2072 */     return new ArrayTypeMatcher<T>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends TypeDefinition> ElementMatcher.Junction<T> isRecord() {
/* 2082 */     return new RecordMatcher<T>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> genericFieldType(Type paramType) {
/* 2093 */     return genericFieldType(TypeDefinition.Sort.describe(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> genericFieldType(TypeDescription.Generic paramGeneric) {
/* 2104 */     return genericFieldType(is(paramGeneric));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> genericFieldType(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 2115 */     return new FieldTypeMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> fieldType(Class<?> paramClass) {
/* 2126 */     return fieldType(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> fieldType(TypeDescription paramTypeDescription) {
/* 2137 */     return fieldType(is(paramTypeDescription));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> fieldType(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 2148 */     return genericFieldType(erasure(paramElementMatcher));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> isVolatile() {
/* 2158 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.VOLATILE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends FieldDescription> ElementMatcher.Junction<T> isTransient() {
/* 2168 */     return (ElementMatcher.Junction)ModifierMatcher.of(ModifierMatcher.Mode.TRANSIENT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends AnnotationDescription> ElementMatcher.Junction<T> annotationType(Class<? extends Annotation> paramClass) {
/* 2179 */     return annotationType(TypeDescription.ForLoadedType.of(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends AnnotationDescription> ElementMatcher.Junction<T> annotationType(TypeDescription paramTypeDescription) {
/* 2190 */     return annotationType(is(paramTypeDescription));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends AnnotationDescription> ElementMatcher.Junction<T> annotationType(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 2201 */     return new AnnotationTypeMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends AnnotationDescription> ElementMatcher.Junction<T> targetsElement(ElementType paramElementType) {
/* 2212 */     return new AnnotationTargetMatcher<T>(paramElementType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ClassLoader> ElementMatcher.Junction<T> isBootstrapClassLoader() {
/* 2223 */     return NullMatcher.make();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ClassLoader> ElementMatcher.Junction<T> isSystemClassLoader() {
/* 2234 */     return new EqualityMatcher<T>(ClassLoader.getSystemClassLoader());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ClassLoader> ElementMatcher.Junction<T> isExtensionClassLoader() {
/*      */     ClassLoader classLoader;
/* 2246 */     if ((classLoader = ClassLoader.getSystemClassLoader().getParent()) == null)
/* 2247 */       return none();  return new EqualityMatcher<T>(classLoader);
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
/*      */   public static <T extends ClassLoader> ElementMatcher.Junction<T> isChildOf(@MaybeNull ClassLoader paramClassLoader) {
/* 2260 */     if (paramClassLoader == ClassLoadingStrategy.BOOTSTRAP_LOADER)
/* 2261 */       return BooleanMatcher.of(true); 
/* 2262 */     return hasChild(is(paramClassLoader));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends ClassLoader> ElementMatcher.Junction<T> hasChild(ElementMatcher<? super ClassLoader> paramElementMatcher) {
/* 2273 */     return new ClassLoaderHierarchyMatcher<T>(paramElementMatcher);
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
/*      */   public static <T extends ClassLoader> ElementMatcher.Junction<T> isParentOf(@MaybeNull ClassLoader paramClassLoader) {
/* 2285 */     if (paramClassLoader == ClassLoadingStrategy.BOOTSTRAP_LOADER)
/* 2286 */       return isBootstrapClassLoader();  return new ClassLoaderParentMatcher<T>(paramClassLoader);
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
/*      */   public static <T extends ClassLoader> ElementMatcher.Junction<T> ofType(ElementMatcher<? super TypeDescription> paramElementMatcher) {
/* 2298 */     return new InstanceTypeMatcher<T>(paramElementMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends net.bytebuddy.utility.JavaModule> ElementMatcher.Junction<T> supportsModules() {
/* 2308 */     return not(NullMatcher.make());
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\ElementMatchers.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */