/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class Converter<A, B>
/*     */   implements Function<A, B>
/*     */ {
/*     */   private final boolean handleNullAutomatically;
/*     */   private transient Converter<B, A> reverse;
/*     */   
/*     */   protected Converter() {
/* 152 */     this(true);
/*     */   }
/*     */ 
/*     */   
/*     */   Converter(boolean paramBoolean) {
/* 157 */     this.handleNullAutomatically = paramBoolean;
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
/*     */   protected abstract B doForward(A paramA);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract A doBackward(B paramB);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final B convert(A paramA) {
/* 197 */     return correctedDoForward(paramA);
/*     */   }
/*     */ 
/*     */   
/*     */   B correctedDoForward(A paramA) {
/* 202 */     if (this.handleNullAutomatically)
/*     */     {
/* 204 */       return (paramA == null) ? null : Preconditions.checkNotNull(doForward(paramA));
/*     */     }
/* 206 */     return unsafeDoForward(paramA);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   A correctedDoBackward(B paramB) {
/* 212 */     if (this.handleNullAutomatically)
/*     */     {
/* 214 */       return (paramB == null) ? null : Preconditions.checkNotNull(doBackward(paramB));
/*     */     }
/* 216 */     return unsafeDoBackward(paramB);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private B unsafeDoForward(A paramA) {
/* 248 */     return doForward(NullnessCasts.uncheckedCastNullableTToT(paramA));
/*     */   }
/*     */ 
/*     */   
/*     */   private A unsafeDoBackward(B paramB) {
/* 253 */     return doBackward(NullnessCasts.uncheckedCastNullableTToT(paramB));
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
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<B> convertAll(final Iterable<? extends A> fromIterable) {
/* 276 */     Preconditions.checkNotNull(fromIterable, "fromIterable");
/* 277 */     return new Iterable<B>()
/*     */       {
/*     */         public Iterator<B> iterator() {
/* 280 */           return new Iterator<B>() {
/* 281 */               private final Iterator<? extends A> fromIterator = fromIterable.iterator();
/*     */ 
/*     */               
/*     */               public boolean hasNext() {
/* 285 */                 return this.fromIterator.hasNext();
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               public B next() {
/* 292 */                 return (B)Converter.this.convert(this.fromIterator.next());
/*     */               }
/*     */ 
/*     */               
/*     */               public void remove() {
/* 297 */                 this.fromIterator.remove();
/*     */               }
/*     */             };
/*     */         }
/*     */       };
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
/*     */   public Converter<B, A> reverse() {
/*     */     Converter<B, A> converter;
/* 315 */     return ((converter = this.reverse) == null) ? (this.reverse = new ReverseConverter<>(this)) : converter;
/*     */   }
/*     */   
/*     */   private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
/*     */     final Converter<A, B> original;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     ReverseConverter(Converter<A, B> param1Converter) {
/* 323 */       this.original = param1Converter;
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
/*     */     protected final A doForward(B param1B) {
/* 335 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */     
/*     */     protected final B doBackward(A param1A) {
/* 340 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     final A correctedDoForward(B param1B) {
/* 346 */       return this.original.correctedDoBackward(param1B);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     final B correctedDoBackward(A param1A) {
/* 352 */       return this.original.correctedDoForward(param1A);
/*     */     }
/*     */ 
/*     */     
/*     */     public final Converter<A, B> reverse() {
/* 357 */       return this.original;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 362 */       if (param1Object instanceof ReverseConverter) {
/* 363 */         param1Object = param1Object;
/* 364 */         return this.original.equals(((ReverseConverter)param1Object).original);
/*     */       } 
/* 366 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 371 */       return this.original.hashCode() ^ 0xFFFFFFFF;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 376 */       String str = String.valueOf(this.original); return (new StringBuilder(10 + String.valueOf(str).length())).append(str).append(".reverse()").toString();
/*     */     }
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
/*     */   public final <C> Converter<A, C> andThen(Converter<B, C> paramConverter) {
/* 390 */     return doAndThen(paramConverter);
/*     */   }
/*     */ 
/*     */   
/*     */   <C> Converter<A, C> doAndThen(Converter<B, C> paramConverter) {
/* 395 */     return new ConverterComposition<>(this, Preconditions.<Converter<?, C>>checkNotNull(paramConverter));
/*     */   }
/*     */   
/*     */   private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
/*     */     final Converter<A, B> first;
/*     */     final Converter<B, C> second;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     ConverterComposition(Converter<A, B> param1Converter, Converter<B, C> param1Converter1) {
/* 404 */       this.first = param1Converter;
/* 405 */       this.second = param1Converter1;
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
/*     */     protected final C doForward(A param1A) {
/* 417 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */     
/*     */     protected final A doBackward(C param1C) {
/* 422 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     final C correctedDoForward(A param1A) {
/* 428 */       return this.second.correctedDoForward(this.first.correctedDoForward(param1A));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     final A correctedDoBackward(C param1C) {
/* 434 */       return this.first.correctedDoBackward(this.second.correctedDoBackward(param1C));
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 439 */       if (param1Object instanceof ConverterComposition) {
/* 440 */         param1Object = param1Object;
/* 441 */         return (this.first.equals(((ConverterComposition)param1Object).first) && this.second.equals(((ConverterComposition)param1Object).second));
/*     */       } 
/* 443 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 448 */       return 31 * this.first.hashCode() + this.second.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 453 */       String str1 = String.valueOf(this.first), str2 = String.valueOf(this.second); return (new StringBuilder(10 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".andThen(").append(str2).append(")").toString();
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final B apply(A paramA) {
/* 499 */     return convert(paramA);
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
/*     */   public boolean equals(Object paramObject) {
/* 515 */     return super.equals(paramObject);
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
/*     */ 
/*     */   
/*     */   public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> paramFunction, Function<? super B, ? extends A> paramFunction1) {
/* 537 */     return new FunctionBasedConverter<>(paramFunction, paramFunction1);
/*     */   }
/*     */   
/*     */   private static final class FunctionBasedConverter<A, B>
/*     */     extends Converter<A, B>
/*     */     implements Serializable
/*     */   {
/*     */     private final Function<? super A, ? extends B> forwardFunction;
/*     */     private final Function<? super B, ? extends A> backwardFunction;
/*     */     
/*     */     private FunctionBasedConverter(Function<? super A, ? extends B> param1Function, Function<? super B, ? extends A> param1Function1) {
/* 548 */       this.forwardFunction = Preconditions.<Function<? super A, ? extends B>>checkNotNull(param1Function);
/* 549 */       this.backwardFunction = Preconditions.<Function<? super B, ? extends A>>checkNotNull(param1Function1);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final B doForward(A param1A) {
/* 554 */       return this.forwardFunction.apply(param1A);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final A doBackward(B param1B) {
/* 559 */       return this.backwardFunction.apply(param1B);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 564 */       if (param1Object instanceof FunctionBasedConverter) {
/* 565 */         param1Object = param1Object;
/* 566 */         if (this.forwardFunction.equals(((FunctionBasedConverter)param1Object).forwardFunction) && this.backwardFunction
/* 567 */           .equals(((FunctionBasedConverter)param1Object).backwardFunction)) return true;  return false;
/*     */       } 
/* 569 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 574 */       return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 579 */       String str1 = String.valueOf(this.forwardFunction), str2 = String.valueOf(this.backwardFunction); return (new StringBuilder(18 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Converter.from(").append(str1).append(", ").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Converter<T, T> identity() {
/* 586 */     return (Converter)IdentityConverter.INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class IdentityConverter<T>
/*     */     extends Converter<T, T>
/*     */     implements Serializable
/*     */   {
/* 594 */     static final IdentityConverter<?> INSTANCE = new IdentityConverter();
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     protected final T doForward(T param1T) {
/* 598 */       return param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final T doBackward(T param1T) {
/* 603 */       return param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     public final IdentityConverter<T> reverse() {
/* 608 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     final <S> Converter<T, S> doAndThen(Converter<T, S> param1Converter) {
/* 613 */       return Preconditions.<Converter<T, S>>checkNotNull(param1Converter, "otherConverter");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 623 */       return "Converter.identity()";
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 627 */       return INSTANCE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Converter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */