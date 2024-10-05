/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.AbstractList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class Joiner
/*     */ {
/*     */   private final String separator;
/*     */   
/*     */   public static Joiner on(String paramString) {
/*  72 */     return new Joiner(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Joiner on(char paramChar) {
/*  77 */     return new Joiner(String.valueOf(paramChar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Joiner(String paramString) {
/*  83 */     this.separator = Preconditions.<String>checkNotNull(paramString);
/*     */   }
/*     */   
/*     */   private Joiner(Joiner paramJoiner) {
/*  87 */     this.separator = paramJoiner.separator;
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
/*     */   public <A extends Appendable> A appendTo(A paramA, Iterable<? extends Object> paramIterable) {
/* 103 */     return appendTo(paramA, paramIterable.iterator());
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
/*     */   public <A extends Appendable> A appendTo(A paramA, Iterator<? extends Object> paramIterator) {
/* 115 */     Preconditions.checkNotNull(paramA);
/* 116 */     if (paramIterator.hasNext()) {
/* 117 */       paramA.append(toString(paramIterator.next()));
/* 118 */       while (paramIterator.hasNext()) {
/* 119 */         paramA.append(this.separator);
/* 120 */         paramA.append(toString(paramIterator.next()));
/*     */       } 
/*     */     } 
/* 123 */     return paramA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <A extends Appendable> A appendTo(A paramA, Object[] paramArrayOfObject) {
/* 133 */     return appendTo(paramA, Arrays.asList(paramArrayOfObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <A extends Appendable> A appendTo(A paramA, Object paramObject1, Object paramObject2, Object... paramVarArgs) {
/* 144 */     return appendTo(paramA, iterable(paramObject1, paramObject2, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable<? extends Object> paramIterable) {
/* 155 */     return appendTo(paramStringBuilder, paramIterable.iterator());
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
/*     */   public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterator<? extends Object> paramIterator) {
/*     */     try {
/* 169 */       appendTo(paramStringBuilder, paramIterator);
/* 170 */     } catch (IOException iOException) {
/* 171 */       throw new AssertionError(iOException);
/*     */     } 
/* 173 */     return (StringBuilder)iOException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object[] paramArrayOfObject) {
/* 183 */     return appendTo(paramStringBuilder, Arrays.asList(paramArrayOfObject));
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
/*     */   public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object paramObject1, Object paramObject2, Object... paramVarArgs) {
/* 197 */     return appendTo(paramStringBuilder, iterable(paramObject1, paramObject2, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String join(Iterable<? extends Object> paramIterable) {
/* 205 */     return join(paramIterable.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String join(Iterator<? extends Object> paramIterator) {
/* 215 */     return appendTo(new StringBuilder(), paramIterator).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String join(Object[] paramArrayOfObject) {
/* 223 */     return join(Arrays.asList(paramArrayOfObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String join(Object paramObject1, Object paramObject2, Object... paramVarArgs) {
/* 232 */     return join(iterable(paramObject1, paramObject2, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Joiner useForNull(final String nullText) {
/* 240 */     Preconditions.checkNotNull(nullText);
/* 241 */     return new Joiner(this)
/*     */       {
/*     */         CharSequence toString(Object param1Object) {
/* 244 */           return (param1Object == null) ? nullText : Joiner.this.toString(param1Object);
/*     */         }
/*     */ 
/*     */         
/*     */         public Joiner useForNull(String param1String) {
/* 249 */           throw new UnsupportedOperationException("already specified useForNull");
/*     */         }
/*     */ 
/*     */         
/*     */         public Joiner skipNulls() {
/* 254 */           throw new UnsupportedOperationException("already specified useForNull");
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Joiner skipNulls() {
/* 264 */     return new Joiner(this)
/*     */       {
/*     */         public <A extends Appendable> A appendTo(A param1A, Iterator<? extends Object> param1Iterator)
/*     */         {
/* 268 */           Preconditions.checkNotNull(param1A, "appendable");
/* 269 */           Preconditions.checkNotNull(param1Iterator, "parts");
/* 270 */           while (param1Iterator.hasNext()) {
/*     */             Object object;
/* 272 */             if ((object = param1Iterator.next()) != null) {
/* 273 */               param1A.append(Joiner.this.toString(object));
/*     */               break;
/*     */             } 
/*     */           } 
/* 277 */           while (param1Iterator.hasNext()) {
/*     */             Object object;
/* 279 */             if ((object = param1Iterator.next()) != null) {
/* 280 */               param1A.append(Joiner.this.separator);
/* 281 */               param1A.append(Joiner.this.toString(object));
/*     */             } 
/*     */           } 
/* 284 */           return param1A;
/*     */         }
/*     */ 
/*     */         
/*     */         public Joiner useForNull(String param1String) {
/* 289 */           throw new UnsupportedOperationException("already specified skipNulls");
/*     */         }
/*     */ 
/*     */         
/*     */         public Joiner.MapJoiner withKeyValueSeparator(String param1String) {
/* 294 */           throw new UnsupportedOperationException("can't use .skipNulls() with maps");
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
/*     */   public MapJoiner withKeyValueSeparator(char paramChar) {
/* 306 */     return withKeyValueSeparator(String.valueOf(paramChar));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapJoiner withKeyValueSeparator(String paramString) {
/* 314 */     return new MapJoiner(this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class MapJoiner
/*     */   {
/*     */     private final Joiner joiner;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String keyValueSeparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private MapJoiner(Joiner param1Joiner, String param1String) {
/* 340 */       this.joiner = param1Joiner;
/* 341 */       this.keyValueSeparator = Preconditions.<String>checkNotNull(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final <A extends Appendable> A appendTo(A param1A, Map<?, ?> param1Map) {
/* 350 */       return appendTo(param1A, param1Map.entrySet());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StringBuilder appendTo(StringBuilder param1StringBuilder, Map<?, ?> param1Map) {
/* 360 */       return appendTo(param1StringBuilder, param1Map.entrySet());
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
/*     */     public final <A extends Appendable> A appendTo(A param1A, Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
/* 373 */       return appendTo(param1A, param1Iterable.iterator());
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
/*     */     public final <A extends Appendable> A appendTo(A param1A, Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
/* 386 */       Preconditions.checkNotNull(param1A);
/* 387 */       if (param1Iterator.hasNext()) {
/* 388 */         Map.Entry entry = param1Iterator.next();
/* 389 */         param1A.append(this.joiner.toString(entry.getKey()));
/* 390 */         param1A.append(this.keyValueSeparator);
/* 391 */         param1A.append(this.joiner.toString(entry.getValue()));
/* 392 */         while (param1Iterator.hasNext()) {
/* 393 */           param1A.append(this.joiner.separator);
/* 394 */           entry = param1Iterator.next();
/* 395 */           param1A.append(this.joiner.toString(entry.getKey()));
/* 396 */           param1A.append(this.keyValueSeparator);
/* 397 */           param1A.append(this.joiner.toString(entry.getValue()));
/*     */         } 
/*     */       } 
/* 400 */       return param1A;
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
/*     */     public final StringBuilder appendTo(StringBuilder param1StringBuilder, Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
/* 413 */       return appendTo(param1StringBuilder, param1Iterable.iterator());
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
/*     */     public final StringBuilder appendTo(StringBuilder param1StringBuilder, Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
/*     */       try {
/* 427 */         appendTo(param1StringBuilder, param1Iterator);
/* 428 */       } catch (IOException iOException) {
/* 429 */         throw new AssertionError(iOException);
/*     */       } 
/* 431 */       return (StringBuilder)iOException;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String join(Map<?, ?> param1Map) {
/* 439 */       return join(param1Map.entrySet());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String join(Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
/* 450 */       return join(param1Iterable.iterator());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String join(Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
/* 461 */       return appendTo(new StringBuilder(), param1Iterator).toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MapJoiner useForNull(String param1String) {
/* 469 */       return new MapJoiner(this.joiner.useForNull(param1String), this.keyValueSeparator);
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
/*     */   CharSequence toString(Object paramObject) {
/* 491 */     Objects.requireNonNull(paramObject);
/* 492 */     return (paramObject instanceof CharSequence) ? (CharSequence)paramObject : paramObject.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static Iterable<Object> iterable(final Object first, final Object second, final Object[] rest) {
/* 497 */     Preconditions.checkNotNull(rest);
/* 498 */     return new AbstractList()
/*     */       {
/*     */         public int size() {
/* 501 */           return rest.length + 2;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public Object get(int param1Int) {
/* 507 */           switch (param1Int) {
/*     */             case 0:
/* 509 */               return first;
/*     */             case 1:
/* 511 */               return second;
/*     */           } 
/* 513 */           return rest[param1Int - 2];
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Joiner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */