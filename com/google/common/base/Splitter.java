/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Splitter
/*     */ {
/*     */   private final CharMatcher trimmer;
/*     */   private final boolean omitEmptyStrings;
/*     */   private final Strategy strategy;
/*     */   private final int limit;
/*     */   
/*     */   private Splitter(Strategy paramStrategy) {
/* 109 */     this(paramStrategy, false, CharMatcher.none(), 2147483647);
/*     */   }
/*     */   
/*     */   private Splitter(Strategy paramStrategy, boolean paramBoolean, CharMatcher paramCharMatcher, int paramInt) {
/* 113 */     this.strategy = paramStrategy;
/* 114 */     this.omitEmptyStrings = paramBoolean;
/* 115 */     this.trimmer = paramCharMatcher;
/* 116 */     this.limit = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Splitter on(char paramChar) {
/* 127 */     return on(CharMatcher.is(paramChar));
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
/*     */   public static Splitter on(final CharMatcher separatorMatcher) {
/* 141 */     Preconditions.checkNotNull(separatorMatcher);
/*     */     
/* 143 */     return new Splitter(new Strategy()
/*     */         {
/*     */           public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence)
/*     */           {
/* 147 */             return new Splitter.SplittingIterator(param1Splitter, param1CharSequence)
/*     */               {
/*     */                 int separatorStart(int param2Int) {
/* 150 */                   return separatorMatcher.indexIn(this.toSplit, param2Int);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 int separatorEnd(int param2Int) {
/* 155 */                   return param2Int + 1;
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
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
/*     */   public static Splitter on(final String separator) {
/* 171 */     Preconditions.checkArgument((separator.length() != 0), "The separator may not be the empty string.");
/* 172 */     if (separator.length() == 1) {
/* 173 */       return on(separator.charAt(0));
/*     */     }
/* 175 */     return new Splitter(new Strategy()
/*     */         {
/*     */           public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence)
/*     */           {
/* 179 */             return new Splitter.SplittingIterator(param1Splitter, param1CharSequence)
/*     */               {
/*     */                 public int separatorStart(int param2Int) {
/* 182 */                   int i = separator.length();
/*     */                   
/*     */                   int j;
/* 185 */                   for (param2Int = param2Int, j = this.toSplit.length() - i; param2Int <= j; param2Int++) {
/* 186 */                     byte b = 0; while (true) { if (b < i) {
/* 187 */                         if (this.toSplit.charAt(b + param2Int) == separator.charAt(b)) {
/*     */                           b++; continue;
/*     */                         }  break;
/*     */                       } 
/* 191 */                       return param2Int; }
/*     */                   
/* 193 */                   }  return -1;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int separatorEnd(int param2Int) {
/* 198 */                   return param2Int + separator.length();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
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
/*     */   public static Splitter on(Pattern paramPattern) {
/* 217 */     return on(new JdkPattern(paramPattern));
/*     */   }
/*     */   
/*     */   private static Splitter on(final CommonPattern separatorPattern) {
/* 221 */     Preconditions.checkArgument(
/* 222 */         !separatorPattern.matcher("").matches(), "The pattern may not match the empty string: %s", separatorPattern);
/*     */ 
/*     */ 
/*     */     
/* 226 */     return new Splitter(new Strategy()
/*     */         {
/*     */           public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence)
/*     */           {
/* 230 */             final CommonMatcher matcher = separatorPattern.matcher(param1CharSequence);
/* 231 */             return new Splitter.SplittingIterator(this, param1Splitter, param1CharSequence)
/*     */               {
/*     */                 public int separatorStart(int param2Int) {
/* 234 */                   return matcher.find(param2Int) ? matcher.start() : -1;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int separatorEnd(int param2Int) {
/* 239 */                   return matcher.end();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
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
/*     */   public static Splitter onPattern(String paramString) {
/* 260 */     return on(Platform.compilePattern(paramString));
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
/*     */   public static Splitter fixedLength(final int length) {
/* 282 */     Preconditions.checkArgument((length > 0), "The length may not be less than 1");
/*     */     
/* 284 */     return new Splitter(new Strategy()
/*     */         {
/*     */           public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence)
/*     */           {
/* 288 */             return new Splitter.SplittingIterator(param1Splitter, param1CharSequence)
/*     */               {
/*     */                 public int separatorStart(int param2Int)
/*     */                 {
/* 292 */                   return ((param2Int = param2Int + length) < this.toSplit.length()) ? param2Int : -1;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int separatorEnd(int param2Int) {
/* 297 */                   return param2Int;
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
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
/*     */   public final Splitter omitEmptyStrings() {
/* 321 */     return new Splitter(this.strategy, true, this.trimmer, this.limit);
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
/*     */   public final Splitter limit(int paramInt) {
/* 341 */     Preconditions.checkArgument((paramInt > 0), "must be greater than zero: %s", paramInt);
/* 342 */     return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, paramInt);
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
/*     */   public final Splitter trimResults() {
/* 355 */     return trimResults(CharMatcher.whitespace());
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
/*     */   public final Splitter trimResults(CharMatcher paramCharMatcher) {
/* 370 */     Preconditions.checkNotNull(paramCharMatcher);
/* 371 */     return new Splitter(this.strategy, this.omitEmptyStrings, paramCharMatcher, this.limit);
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
/*     */   public final Iterable<String> split(final CharSequence sequence) {
/* 383 */     Preconditions.checkNotNull(sequence);
/*     */     
/* 385 */     return new Iterable<String>()
/*     */       {
/*     */         public Iterator<String> iterator() {
/* 388 */           return Splitter.this.splittingIterator(sequence);
/*     */         }
/*     */ 
/*     */         
/*     */         public String toString() {
/* 393 */           return Joiner.on(", ")
/* 394 */             .appendTo(new StringBuilder("["), this)
/* 395 */             .append(']')
/* 396 */             .toString();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private Iterator<String> splittingIterator(CharSequence paramCharSequence) {
/* 402 */     return this.strategy.iterator(this, paramCharSequence);
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
/*     */   public final List<String> splitToList(CharSequence paramCharSequence) {
/* 414 */     Preconditions.checkNotNull(paramCharSequence);
/*     */     
/* 416 */     Iterator<String> iterator = splittingIterator(paramCharSequence);
/* 417 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 419 */     while (iterator.hasNext()) {
/* 420 */       arrayList.add(iterator.next());
/*     */     }
/*     */     
/* 423 */     return Collections.unmodifiableList(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MapSplitter withKeyValueSeparator(String paramString) {
/* 434 */     return withKeyValueSeparator(on(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MapSplitter withKeyValueSeparator(char paramChar) {
/* 445 */     return withKeyValueSeparator(on(paramChar));
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
/*     */   public final MapSplitter withKeyValueSeparator(Splitter paramSplitter) {
/* 469 */     return new MapSplitter(this, paramSplitter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class MapSplitter
/*     */   {
/*     */     private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
/*     */ 
/*     */     
/*     */     private final Splitter outerSplitter;
/*     */ 
/*     */     
/*     */     private final Splitter entrySplitter;
/*     */ 
/*     */ 
/*     */     
/*     */     private MapSplitter(Splitter param1Splitter1, Splitter param1Splitter2) {
/* 487 */       this.outerSplitter = param1Splitter1;
/* 488 */       this.entrySplitter = Preconditions.<Splitter>checkNotNull(param1Splitter2);
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
/*     */ 
/*     */     
/*     */     public final Map<String, String> split(CharSequence param1CharSequence) {
/* 503 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 504 */       for (String str1 : this.outerSplitter.split(param1CharSequence)) {
/*     */         Iterator<?> iterator;
/*     */         
/* 507 */         Preconditions.checkArgument((iterator = this.entrySplitter.splittingIterator(str1)).hasNext(), "Chunk [%s] is not a valid entry", str1);
/* 508 */         String str2 = (String)iterator.next();
/* 509 */         Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
/*     */         
/* 511 */         Preconditions.checkArgument(iterator.hasNext(), "Chunk [%s] is not a valid entry", str1);
/* 512 */         String str3 = (String)iterator.next();
/* 513 */         linkedHashMap.put(str2, str3);
/*     */         
/* 515 */         Preconditions.checkArgument(!iterator.hasNext(), "Chunk [%s] is not a valid entry", str1);
/*     */       } 
/* 517 */       return (Map)Collections.unmodifiableMap(linkedHashMap);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static interface Strategy
/*     */   {
/*     */     Iterator<String> iterator(Splitter param1Splitter, CharSequence param1CharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class SplittingIterator
/*     */     extends AbstractIterator<String>
/*     */   {
/*     */     final CharSequence toSplit;
/*     */ 
/*     */     
/*     */     final CharMatcher trimmer;
/*     */ 
/*     */     
/*     */     final boolean omitEmptyStrings;
/*     */ 
/*     */     
/* 542 */     int offset = 0;
/*     */     int limit;
/*     */     
/*     */     protected SplittingIterator(Splitter param1Splitter, CharSequence param1CharSequence) {
/* 546 */       this.trimmer = param1Splitter.trimmer;
/* 547 */       this.omitEmptyStrings = param1Splitter.omitEmptyStrings;
/* 548 */       this.limit = param1Splitter.limit;
/* 549 */       this.toSplit = param1CharSequence;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String computeNext() {
/* 560 */       int i = this.offset;
/* 561 */       while (this.offset != -1) {
/* 562 */         int k, j = i;
/*     */         
/*     */         int m;
/*     */         
/* 566 */         if ((m = separatorStart(this.offset)) == -1) {
/* 567 */           k = this.toSplit.length();
/* 568 */           this.offset = -1;
/*     */         } else {
/* 570 */           k = m;
/* 571 */           this.offset = separatorEnd(m);
/*     */         } 
/* 573 */         if (this.offset == i) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 580 */           this.offset++;
/* 581 */           if (this.offset > this.toSplit.length()) {
/* 582 */             this.offset = -1;
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 587 */         while (j < k && this.trimmer.matches(this.toSplit.charAt(j))) {
/* 588 */           j++;
/*     */         }
/* 590 */         while (k > j && this.trimmer.matches(this.toSplit.charAt(k - 1))) {
/* 591 */           k--;
/*     */         }
/*     */         
/* 594 */         if (this.omitEmptyStrings && j == k) {
/*     */           
/* 596 */           i = this.offset;
/*     */           
/*     */           continue;
/*     */         } 
/* 600 */         if (this.limit == 1) {
/*     */ 
/*     */ 
/*     */           
/* 604 */           k = this.toSplit.length();
/* 605 */           this.offset = -1;
/*     */           
/* 607 */           while (k > j && this.trimmer.matches(this.toSplit.charAt(k - 1))) {
/* 608 */             k--;
/*     */           }
/*     */         } else {
/* 611 */           this.limit--;
/*     */         } 
/*     */         
/* 614 */         return this.toSplit.subSequence(j, k).toString();
/*     */       } 
/* 616 */       return endOfData();
/*     */     }
/*     */     
/*     */     abstract int separatorStart(int param1Int);
/*     */     
/*     */     abstract int separatorEnd(int param1Int);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Splitter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */