/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
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
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public final class Predicates
/*     */ {
/*     */   public static <T> Predicate<T> alwaysTrue() {
/*  53 */     return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> alwaysFalse() {
/*  59 */     return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> isNull() {
/*  68 */     return ObjectPredicate.IS_NULL.withNarrowedType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> notNull() {
/*  77 */     return ObjectPredicate.NOT_NULL.withNarrowedType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> not(Predicate<T> paramPredicate) {
/*  85 */     return new NotPredicate<>(paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> paramIterable) {
/*  97 */     return new AndPredicate<>(defensiveCopy(paramIterable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SafeVarargs
/*     */   public static <T> Predicate<T> and(Predicate<? super T>... paramVarArgs) {
/* 109 */     return new AndPredicate<>(defensiveCopy(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> and(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 119 */     return new AndPredicate<>(asList(Preconditions.<Predicate>checkNotNull(paramPredicate1), Preconditions.<Predicate>checkNotNull(paramPredicate2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> paramIterable) {
/* 131 */     return new OrPredicate<>(defensiveCopy(paramIterable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SafeVarargs
/*     */   public static <T> Predicate<T> or(Predicate<? super T>... paramVarArgs) {
/* 143 */     return new OrPredicate<>(defensiveCopy(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> or(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 153 */     return new OrPredicate<>(asList(Preconditions.<Predicate>checkNotNull(paramPredicate1), Preconditions.<Predicate>checkNotNull(paramPredicate2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> equalTo(@ParametricNullness T paramT) {
/* 161 */     if (paramT == null)
/* 162 */       return isNull(); 
/* 163 */     return (new IsEqualToPredicate(paramT)).withNarrowedType();
/*     */   }
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
/*     */   public static <T> Predicate<T> instanceOf(Class<?> paramClass) {
/* 181 */     return new InstanceOfPredicate<>(paramClass);
/*     */   }
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
/*     */   public static Predicate<Class<?>> subtypeOf(Class<?> paramClass) {
/* 201 */     return new SubtypeOfPredicate(paramClass);
/*     */   }
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
/*     */   public static <T> Predicate<T> in(Collection<? extends T> paramCollection) {
/* 216 */     return new InPredicate<>(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <A, B> Predicate<A> compose(Predicate<B> paramPredicate, Function<A, ? extends B> paramFunction) {
/* 227 */     return new CompositionPredicate<>(paramPredicate, paramFunction);
/*     */   }
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
/*     */   public static Predicate<CharSequence> containsPattern(String paramString) {
/* 240 */     return new ContainsPatternFromStringPredicate(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Predicate<CharSequence> contains(Pattern paramPattern) {
/* 252 */     return new ContainsPatternPredicate(new JdkPattern(paramPattern));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   enum ObjectPredicate
/*     */     implements Predicate<Object>
/*     */   {
/* 260 */     ALWAYS_TRUE
/*     */     {
/*     */       public final boolean apply(Object param2Object) {
/* 263 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public final String toString() {
/* 268 */         return "Predicates.alwaysTrue()";
/*     */       }
/*     */     },
/*     */     
/* 272 */     ALWAYS_FALSE
/*     */     {
/*     */       public final boolean apply(Object param2Object) {
/* 275 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public final String toString() {
/* 280 */         return "Predicates.alwaysFalse()";
/*     */       }
/*     */     },
/*     */     
/* 284 */     IS_NULL
/*     */     {
/*     */       public final boolean apply(Object param2Object) {
/* 287 */         return (param2Object == null);
/*     */       }
/*     */ 
/*     */       
/*     */       public final String toString() {
/* 292 */         return "Predicates.isNull()";
/*     */       }
/*     */     },
/*     */     
/* 296 */     NOT_NULL
/*     */     {
/*     */       public final boolean apply(Object param2Object) {
/* 299 */         return (param2Object != null);
/*     */       }
/*     */ 
/*     */       
/*     */       public final String toString() {
/* 304 */         return "Predicates.notNull()";
/*     */       }
/*     */     };
/*     */ 
/*     */     
/*     */     <T> Predicate<T> withNarrowedType() {
/* 310 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class NotPredicate<T>
/*     */     implements Predicate<T>, Serializable {
/*     */     final Predicate<T> predicate;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     NotPredicate(Predicate<T> param1Predicate) {
/* 320 */       this.predicate = Preconditions.<Predicate<T>>checkNotNull(param1Predicate);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(@ParametricNullness T param1T) {
/* 325 */       return !this.predicate.apply(param1T);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 330 */       return this.predicate.hashCode() ^ 0xFFFFFFFF;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 335 */       if (param1Object instanceof NotPredicate) {
/* 336 */         param1Object = param1Object;
/* 337 */         return this.predicate.equals(((NotPredicate)param1Object).predicate);
/*     */       } 
/* 339 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 344 */       String str = String.valueOf(this.predicate); return (new StringBuilder(16 + String.valueOf(str).length())).append("Predicates.not(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class AndPredicate<T>
/*     */     implements Predicate<T>, Serializable
/*     */   {
/*     */     private final List<? extends Predicate<? super T>> components;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private AndPredicate(List<? extends Predicate<? super T>> param1List) {
/* 356 */       this.components = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean apply(@ParametricNullness T param1T) {
/* 362 */       for (byte b = 0; b < this.components.size(); b++) {
/* 363 */         if (!((Predicate<T>)this.components.get(b)).apply(param1T)) {
/* 364 */           return false;
/*     */         }
/*     */       } 
/* 367 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 373 */       return this.components.hashCode() + 306654252;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 378 */       if (param1Object instanceof AndPredicate) {
/* 379 */         param1Object = param1Object;
/* 380 */         return this.components.equals(((AndPredicate)param1Object).components);
/*     */       } 
/* 382 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 387 */       return Predicates.toStringHelper("and", this.components);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class OrPredicate<T>
/*     */     implements Predicate<T>, Serializable
/*     */   {
/*     */     private final List<? extends Predicate<? super T>> components;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private OrPredicate(List<? extends Predicate<? super T>> param1List) {
/* 399 */       this.components = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean apply(@ParametricNullness T param1T) {
/* 405 */       for (byte b = 0; b < this.components.size(); b++) {
/* 406 */         if (((Predicate<T>)this.components.get(b)).apply(param1T)) {
/* 407 */           return true;
/*     */         }
/*     */       } 
/* 410 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 416 */       return this.components.hashCode() + 87855567;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 421 */       if (param1Object instanceof OrPredicate) {
/* 422 */         param1Object = param1Object;
/* 423 */         return this.components.equals(((OrPredicate)param1Object).components);
/*     */       } 
/* 425 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 430 */       return Predicates.toStringHelper("or", this.components);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String toStringHelper(String paramString, Iterable<?> paramIterable) {
/* 437 */     StringBuilder stringBuilder = (new StringBuilder("Predicates.")).append(paramString).append('(');
/* 438 */     boolean bool = true;
/* 439 */     for (Object object : paramIterable) {
/* 440 */       if (!bool) {
/* 441 */         stringBuilder.append(',');
/*     */       }
/* 443 */       stringBuilder.append(object);
/* 444 */       bool = false;
/*     */     } 
/* 446 */     return stringBuilder.append(')').toString();
/*     */   }
/*     */   
/*     */   private static class IsEqualToPredicate implements Predicate<Object>, Serializable {
/*     */     private final Object target;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private IsEqualToPredicate(Object param1Object) {
/* 454 */       this.target = param1Object;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(Object param1Object) {
/* 459 */       return this.target.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 464 */       return this.target.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 469 */       if (param1Object instanceof IsEqualToPredicate) {
/* 470 */         param1Object = param1Object;
/* 471 */         return this.target.equals(((IsEqualToPredicate)param1Object).target);
/*     */       } 
/* 473 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 478 */       String str = String.valueOf(this.target); return (new StringBuilder(20 + String.valueOf(str).length())).append("Predicates.equalTo(").append(str).append(")").toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     <T> Predicate<T> withNarrowedType() {
/* 485 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class InstanceOfPredicate<T>
/*     */     implements Predicate<T>, Serializable
/*     */   {
/*     */     private final Class<?> clazz;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private InstanceOfPredicate(Class<?> param1Class) {
/* 496 */       this.clazz = Preconditions.<Class<?>>checkNotNull(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(@ParametricNullness T param1T) {
/* 501 */       return this.clazz.isInstance(param1T);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 506 */       return this.clazz.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 511 */       if (param1Object instanceof InstanceOfPredicate) {
/* 512 */         param1Object = param1Object;
/* 513 */         return (this.clazz == ((InstanceOfPredicate)param1Object).clazz);
/*     */       } 
/* 515 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 520 */       String str = this.clazz.getName(); return (new StringBuilder(23 + String.valueOf(str).length())).append("Predicates.instanceOf(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class SubtypeOfPredicate
/*     */     implements Predicate<Class<?>>, Serializable
/*     */   {
/*     */     private final Class<?> clazz;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private SubtypeOfPredicate(Class<?> param1Class) {
/* 532 */       this.clazz = Preconditions.<Class<?>>checkNotNull(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(Class<?> param1Class) {
/* 537 */       return this.clazz.isAssignableFrom(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 542 */       return this.clazz.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 547 */       if (param1Object instanceof SubtypeOfPredicate) {
/* 548 */         param1Object = param1Object;
/* 549 */         return (this.clazz == ((SubtypeOfPredicate)param1Object).clazz);
/*     */       } 
/* 551 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 556 */       String str = this.clazz.getName(); return (new StringBuilder(22 + String.valueOf(str).length())).append("Predicates.subtypeOf(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class InPredicate<T>
/*     */     implements Predicate<T>, Serializable
/*     */   {
/*     */     private final Collection<?> target;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private InPredicate(Collection<?> param1Collection) {
/* 568 */       this.target = Preconditions.<Collection>checkNotNull(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(@ParametricNullness T param1T) {
/*     */       try {
/* 574 */         return this.target.contains(param1T);
/* 575 */       } catch (NullPointerException|ClassCastException nullPointerException) {
/* 576 */         return false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 582 */       if (param1Object instanceof InPredicate) {
/* 583 */         param1Object = param1Object;
/* 584 */         return this.target.equals(((InPredicate)param1Object).target);
/*     */       } 
/* 586 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 591 */       return this.target.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 596 */       String str = String.valueOf(this.target); return (new StringBuilder(15 + String.valueOf(str).length())).append("Predicates.in(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class CompositionPredicate<A, B>
/*     */     implements Predicate<A>, Serializable
/*     */   {
/*     */     final Predicate<B> p;
/*     */     final Function<A, ? extends B> f;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private CompositionPredicate(Predicate<B> param1Predicate, Function<A, ? extends B> param1Function) {
/* 609 */       this.p = Preconditions.<Predicate<B>>checkNotNull(param1Predicate);
/* 610 */       this.f = Preconditions.<Function<A, ? extends B>>checkNotNull(param1Function);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(@ParametricNullness A param1A) {
/* 615 */       return this.p.apply(this.f.apply(param1A));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 620 */       if (param1Object instanceof CompositionPredicate) {
/* 621 */         param1Object = param1Object;
/* 622 */         return (this.f.equals(((CompositionPredicate)param1Object).f) && this.p.equals(((CompositionPredicate)param1Object).p));
/*     */       } 
/* 624 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 629 */       return this.f.hashCode() ^ this.p.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 635 */       String str1 = String.valueOf(this.p), str2 = String.valueOf(this.f); return (new StringBuilder(2 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append("(").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ContainsPatternPredicate
/*     */     implements Predicate<CharSequence>, Serializable
/*     */   {
/*     */     final CommonPattern pattern;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     ContainsPatternPredicate(CommonPattern param1CommonPattern) {
/* 647 */       this.pattern = Preconditions.<CommonPattern>checkNotNull(param1CommonPattern);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(CharSequence param1CharSequence) {
/* 652 */       return this.pattern.matcher(param1CharSequence).find();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 660 */       return Objects.hashCode(new Object[] { this.pattern.pattern(), Integer.valueOf(this.pattern.flags()) });
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 665 */       if (param1Object instanceof ContainsPatternPredicate) {
/* 666 */         param1Object = param1Object;
/*     */ 
/*     */ 
/*     */         
/* 670 */         if (Objects.equal(this.pattern.pattern(), ((ContainsPatternPredicate)param1Object).pattern.pattern()) && this.pattern
/* 671 */           .flags() == ((ContainsPatternPredicate)param1Object).pattern.flags()) return true;  return false;
/*     */       } 
/* 673 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 682 */       String str = MoreObjects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
/* 683 */       return (new StringBuilder(21 + String.valueOf(str).length())).append("Predicates.contains(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ContainsPatternFromStringPredicate
/*     */     extends ContainsPatternPredicate
/*     */   {
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     ContainsPatternFromStringPredicate(String param1String) {
/* 694 */       super(Platform.compilePattern(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 699 */       String str = this.pattern.pattern(); return (new StringBuilder(28 + String.valueOf(str).length())).append("Predicates.containsPattern(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> List<Predicate<? super T>> asList(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 708 */     return Arrays.asList((Predicate<? super T>[])new Predicate[] { paramPredicate1, paramPredicate2 });
/*     */   }
/*     */   
/*     */   private static <T> List<T> defensiveCopy(T... paramVarArgs) {
/* 712 */     return defensiveCopy(Arrays.asList(paramVarArgs));
/*     */   }
/*     */   
/*     */   static <T> List<T> defensiveCopy(Iterable<T> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_1
/*     */     //   8: aload_0
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore_0
/*     */     //   15: aload_0
/*     */     //   16: invokeinterface hasNext : ()Z
/*     */     //   21: ifeq -> 43
/*     */     //   24: aload_0
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: astore_2
/*     */     //   31: aload_1
/*     */     //   32: aload_2
/*     */     //   33: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   36: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   39: pop
/*     */     //   40: goto -> 15
/*     */     //   43: aload_1
/*     */     //   44: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #716	-> 0
/*     */     //   #717	-> 8
/*     */     //   #718	-> 31
/*     */     //   #719	-> 40
/*     */     //   #720	-> 43
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Predicates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */