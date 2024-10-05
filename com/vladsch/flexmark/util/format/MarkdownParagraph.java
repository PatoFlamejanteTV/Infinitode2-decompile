/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.SharedDataKeys;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.BasedOffsetTracker;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.OffsetInfo;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpaceMapper;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MarkdownParagraph
/*     */ {
/*     */   private static final char MARKDOWN_START_LINE_CHAR = ' ';
/*  27 */   public static final List<SpecialLeadInHandler> EMPTY_LEAD_IN_HANDLERS = Collections.emptyList();
/*  28 */   public static final List<TrackedOffset> EMPTY_OFFSET_LIST = Collections.emptyList();
/*     */   
/*     */   final BasedSequence baseSeq;
/*     */   
/*     */   final BasedSequence altSeq;
/*     */   final CharWidthProvider charWidthProvider;
/*  34 */   private BasedSequence firstIndent = BasedSequence.NULL;
/*  35 */   private BasedSequence indent = BasedSequence.NULL;
/*  36 */   private int firstWidthOffset = 0;
/*  37 */   int width = 0;
/*     */   boolean keepHardLineBreaks = true;
/*     */   boolean keepSoftLineBreaks = false;
/*     */   boolean unEscapeSpecialLeadInChars = true;
/*     */   boolean escapeSpecialLeadInChars = true;
/*     */   boolean restoreTrackedSpaces = false;
/*  43 */   DataHolder options = null;
/*     */   
/*  45 */   List<? extends SpecialLeadInHandler> leadInHandlers = EMPTY_LEAD_IN_HANDLERS;
/*  46 */   private List<TrackedOffset> trackedOffsets = EMPTY_OFFSET_LIST;
/*     */   private boolean trackedOffsetsSorted = true;
/*     */   
/*     */   public MarkdownParagraph(CharSequence paramCharSequence) {
/*  50 */     this(BasedSequence.of(paramCharSequence));
/*     */   }
/*     */   
/*     */   public MarkdownParagraph(BasedSequence paramBasedSequence) {
/*  54 */     this(paramBasedSequence, paramBasedSequence, CharWidthProvider.NULL);
/*     */   }
/*     */   
/*     */   public MarkdownParagraph(BasedSequence paramBasedSequence, CharWidthProvider paramCharWidthProvider) {
/*  58 */     this(paramBasedSequence, paramBasedSequence, paramCharWidthProvider);
/*     */   }
/*     */   
/*     */   public MarkdownParagraph(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, CharWidthProvider paramCharWidthProvider) {
/*  62 */     this.baseSeq = paramBasedSequence1;
/*  63 */     this.altSeq = paramBasedSequence2;
/*  64 */     this.charWidthProvider = paramCharWidthProvider;
/*     */   }
/*     */   
/*     */   public BasedSequence wrapTextNotTracked() {
/*  68 */     if (getFirstWidth() <= 0) return this.baseSeq;
/*     */     
/*     */     LeftAlignedWrapping leftAlignedWrapping;
/*  71 */     return (leftAlignedWrapping = new LeftAlignedWrapping(this.baseSeq)).wrapText();
/*     */   }
/*     */ 
/*     */   
/*     */   public Range getContinuationStartSplice(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  76 */     BasedSequence basedSequence = this.altSeq.getBaseSequence();
/*  77 */     assert paramInt >= 0 && paramInt <= basedSequence.length();
/*     */     
/*  79 */     BasedOffsetTracker basedOffsetTracker = BasedOffsetTracker.create(this.altSeq);
/*     */     int i, j;
/*  81 */     if (paramBoolean1 && paramBoolean2 && (i = basedSequence.startOfLine(paramInt)) > this.altSeq.getStartOffset() && !basedSequence.isCharAt(paramInt, CharPredicate.SPACE_TAB_NBSP_LINE_SEP) && (
/*     */       
/*  83 */       j = basedSequence.lastIndexOfAnyNot(CharPredicate.SPACE_TAB_NBSP_EOL, paramInt - 1)) < i) {
/*     */       OffsetInfo offsetInfo;
/*     */       
/*  86 */       int k = (offsetInfo = basedOffsetTracker.getOffsetInfo(paramInt, true)).endIndex;
/*     */       int m;
/*  88 */       return Range.of((m = this.altSeq.lastIndexOfAnyNot(CharPredicate.SPACE_TAB_NBSP_EOL, k - 1)) + 1, k);
/*     */     } 
/*     */ 
/*     */     
/*  92 */     return Range.NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence resolveTrackedOffsets(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/*  98 */     BasedOffsetTracker basedOffsetTracker = BasedOffsetTracker.create(paramBasedSequence2);
/*     */     
/* 100 */     for (int i = this.trackedOffsets.size(); i-- > 0; ) {
/*     */       TrackedOffset trackedOffset;
/* 102 */       int j = (trackedOffset = this.trackedOffsets.get(i)).getOffset();
/*     */       
/*     */       boolean bool;
/* 105 */       if ((bool = paramBasedSequence1.isBaseCharAt(j, CharPredicate.WHITESPACE_NBSP)) && !paramBasedSequence1.isBaseCharAt(j - 1, CharPredicate.WHITESPACE_NBSP)) {
/*     */         
/* 107 */         offsetInfo = basedOffsetTracker.getOffsetInfo(j - 1, false);
/* 108 */         trackedOffset.setIndex(offsetInfo.endIndex); continue;
/* 109 */       }  if (!bool && paramBasedSequence1.isBaseCharAt(offsetInfo + 1, CharPredicate.WHITESPACE_NBSP)) {
/*     */         
/* 111 */         offsetInfo = basedOffsetTracker.getOffsetInfo(offsetInfo, false);
/* 112 */         trackedOffset.setIndex(offsetInfo.startIndex); continue;
/*     */       } 
/* 114 */       OffsetInfo offsetInfo = basedOffsetTracker.getOffsetInfo(offsetInfo, true);
/* 115 */       trackedOffset.setIndex(offsetInfo.endIndex);
/*     */     } 
/*     */     
/* 118 */     return paramBasedSequence2;
/*     */   }
/*     */   
/*     */   public BasedSequence wrapText() {
/* 122 */     if (getFirstWidth() <= 0) return this.baseSeq; 
/* 123 */     if (this.trackedOffsets.isEmpty()) return wrapTextNotTracked();
/*     */ 
/*     */     
/* 126 */     sortedTrackedOffsets();
/*     */ 
/*     */     
/* 129 */     BasedSequence basedSequence1 = this.baseSeq;
/* 130 */     BasedSequence basedSequence2 = this.altSeq;
/* 131 */     Range range = Range.NULL;
/*     */ 
/*     */ 
/*     */     
/* 135 */     for (int i = this.trackedOffsets.size(); i-- > 0; ) {
/* 136 */       TrackedOffset trackedOffset = this.trackedOffsets.get(i);
/* 137 */       if ((range.isEmpty() || !range.contains(trackedOffset.getOffset())) && (
/*     */         
/* 139 */         range = getContinuationStartSplice(trackedOffset.getOffset(), trackedOffset.isAfterSpaceEdit(), trackedOffset.isAfterDelete())).isNotEmpty()) {
/* 140 */         trackedOffset.setSpliced(true);
/* 141 */         basedSequence1 = (BasedSequence)basedSequence1.delete(range.getStart(), range.getEnd());
/* 142 */         basedSequence2 = (BasedSequence)basedSequence2.delete(range.getStart(), range.getEnd());
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 148 */     assert basedSequence1.equals(basedSequence2);
/*     */     
/*     */     LeftAlignedWrapping leftAlignedWrapping;
/* 151 */     BasedSequence basedSequence3 = (leftAlignedWrapping = new LeftAlignedWrapping(basedSequence1)).wrapText();
/*     */     
/* 153 */     if (this.restoreTrackedSpaces) {
/* 154 */       if (this.indent.isNotEmpty() || this.firstIndent.isNotEmpty()) throw new IllegalStateException("restoreTrackedSpaces is not supported with indentation applied by MarkdownParagraph");
/*     */       
/* 156 */       basedSequence3 = resolveTrackedOffsetsEdit(basedSequence1, basedSequence2, basedSequence3);
/*     */     } else {
/*     */       
/* 159 */       basedSequence3 = resolveTrackedOffsets(this.baseSeq, basedSequence3);
/*     */     } 
/*     */     
/* 162 */     return basedSequence3;
/*     */   }
/*     */   
/*     */   BasedSequence resolveTrackedOffsetsEdit(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 166 */     Boolean bool = (Boolean)SharedDataKeys.RUNNING_TESTS.get(this.options);
/* 167 */     paramBasedSequence1 = BasedSequence.of(paramBasedSequence1.toString());
/* 168 */     LeftAlignedWrapping leftAlignedWrapping = new LeftAlignedWrapping(paramBasedSequence1);
/* 169 */     paramBasedSequence1 = ((SequenceBuilder)paramBasedSequence1.getBuilder().append((CharSequence)leftAlignedWrapping.wrapText())).toSequence(paramBasedSequence2, CharPredicate.LINE_SEP, CharPredicate.SPACE_TAB_EOL);
/*     */     
/* 171 */     BasedOffsetTracker basedOffsetTracker1 = BasedOffsetTracker.create(this.altSeq);
/* 172 */     BasedOffsetTracker basedOffsetTracker2 = BasedOffsetTracker.create(paramBasedSequence1);
/*     */     
/* 174 */     int i = this.trackedOffsets.size();
/* 175 */     BasedSequence basedSequence1 = this.altSeq.getBaseSequence();
/* 176 */     BasedSequence basedSequence2 = this.altSeq;
/*     */ 
/*     */     
/* 179 */     int j = 0;
/*     */ 
/*     */     
/* 182 */     for (int k = i; k-- > 0; ) {
/*     */       TrackedOffset trackedOffset;
/*     */       
/* 185 */       int m = (trackedOffset = this.trackedOffsets.get(k)).getOffset();
/* 186 */       int n = basedSequence1.countTrailing(CharPredicate.SPACE_TAB_NBSP, m);
/* 187 */       int i1 = basedSequence1.countLeading(CharPredicate.SPACE_TAB_NBSP, m);
/* 188 */       int i2 = basedSequence1.countTrailing(CharPredicate.SPACE_TAB_NBSP_EOL, m);
/* 189 */       int i3 = basedSequence1.countLeading(CharPredicate.SPACE_TAB_NBSP_EOL, m);
/*     */       
/* 191 */       if (bool.booleanValue()) {
/* 192 */         assert trackedOffset.getSpacesBefore() == n;
/* 193 */         assert trackedOffset.getSpacesAfter() == i1;
/*     */       } 
/*     */       
/* 196 */       int i4 = basedSequence1.safeCharAt(m);
/* 197 */       char c1 = basedSequence1.safeCharAt(m - n - 1);
/* 198 */       char c2 = basedSequence1.safeCharAt(m + i1);
/*     */ 
/*     */       
/* 201 */       byte b = 0;
/*     */       
/* 203 */       boolean bool1 = false;
/* 204 */       String str = "";
/*     */       
/* 206 */       if (bool.booleanValue()) {
/* 207 */         System.out.println(trackedOffset);
/*     */       }
/*     */       
/* 210 */       if (!CharPredicate.SPACE_TAB_NBSP.test(i4)) {
/* 211 */         i2 = m;
/* 212 */         i3 = (basedOffsetTracker1.getOffsetInfo(i2, false)).startIndex;
/*     */         
/* 214 */         if (basedSequence2.safeCharAt(i3 - 1) == ' ')
/*     */         {
/* 216 */           bool1 = true;
/* 217 */           str = "LSep ";
/*     */         }
/*     */       
/* 220 */       } else if (!CharPredicate.SPACE_TAB_NBSP_EOL.test(c1)) {
/* 221 */         i2 = m - i2;
/* 222 */         i3 = (basedOffsetTracker1.getOffsetInfo(i2 - 1, false)).endIndex;
/* 223 */         str = "Prev ";
/* 224 */       } else if (!CharPredicate.SPACE_TAB_NBSP_EOL.test(c2)) {
/* 225 */         i2 = m + i3;
/* 226 */         i3 = (basedOffsetTracker1.getOffsetInfo(i2, false)).startIndex;
/* 227 */         str = "Next ";
/*     */       } else {
/* 229 */         throw new IllegalStateException(String.format("Should not be here. altSeq: '%s'", new Object[] { basedSequence2 }));
/*     */       } 
/*     */ 
/*     */       
/* 233 */       if (bool.booleanValue()) {
/* 234 */         System.out.println(String.format("%sBaseSequence offset: `%s`", new Object[] { str, ((BasedSequence)basedSequence1.safeSubSequence(m - 10, m)).toVisibleWhitespaceString() + "|" + ((BasedSequence)basedSequence1.safeSubSequence(m, m + 10)).toVisibleWhitespaceString() }));
/* 235 */         System.out.println(String.format("%sBaseSequence anchor: `%s`", new Object[] { str, ((BasedSequence)basedSequence1.safeSubSequence(i2 - 10, i2)).toVisibleWhitespaceString() + "|" + ((BasedSequence)basedSequence1.safeSubSequence(i2, i2 + 10)).toVisibleWhitespaceString() }));
/* 236 */         System.out.println(String.format("%saltUnwrapped anchor: `%s`", new Object[] { str, ((BasedSequence)basedSequence2.safeSubSequence(i3 - 10, i3)).toVisibleWhitespaceString() + "|" + ((BasedSequence)basedSequence2.safeSubSequence(i3, i3 + 10)).toVisibleWhitespaceString() }));
/*     */       } 
/*     */ 
/*     */       
/* 240 */       m = (basedOffsetTracker2.getOffsetInfo(i2, false)).startIndex;
/*     */       
/* 242 */       if (bool.booleanValue()) {
/* 243 */         System.out.println(String.format("altWrapped anchor: `%s`", new Object[] { ((BasedSequence)paramBasedSequence1.safeSubSequence(m - 10, m)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence1.safeSubSequence(m, m + 10)).toVisibleWhitespaceString() }));
/* 244 */         System.out.println(String.format("wrapped anchor: `%s`", new Object[] { ((BasedSequence)paramBasedSequence3.safeSubSequence(m - 10, m)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence3.safeSubSequence(m, m + 10)).toVisibleWhitespaceString() }));
/*     */       } 
/*     */ 
/*     */       
/* 248 */       assert SpaceMapper.areEquivalent(basedSequence1.safeCharAt(i2), basedSequence2.safeCharAt(i3)) || (basedSequence1
/*     */         
/* 250 */         .isCharAt(i2, CharPredicate.WHITESPACE_NBSP_OR_NUL) && basedSequence2.isCharAt(i3, CharPredicate.WHITESPACE_NBSP_OR_NUL)) : 
/* 251 */         String.format("baseSeq.charAt(%d): '%s':0x%04x != altUnwrapped.charAt(%d=%d+%d): '%s':0x%04x, baseSequence anchor: '%s', altUnwrapped anchor: '%s', altWrapped anchor: '%s', wrapped anchor: '%s'", new Object[] { 
/* 252 */             Integer.valueOf(i2), 
/* 253 */             String.valueOf(basedSequence1.safeCharAt(i2)), 
/* 254 */             Integer.valueOf(basedSequence1.safeCharAt(i2)), 
/* 255 */             Integer.valueOf(i3), 
/* 256 */             Integer.valueOf(i3), 
/* 257 */             Integer.valueOf(false), 
/* 258 */             String.valueOf(basedSequence2.safeCharAt(i3)), 
/* 259 */             Integer.valueOf(basedSequence2.safeCharAt(i3)), ((BasedSequence)basedSequence1
/* 260 */             .safeSubSequence(i2 - 10, i2)).toVisibleWhitespaceString() + "|" + ((BasedSequence)basedSequence1.safeSubSequence(i2, i2 + 10)).toVisibleWhitespaceString(), ((BasedSequence)basedSequence2
/* 261 */             .safeSubSequence(i3 - 10, i3)).toVisibleWhitespaceString() + "|" + ((BasedSequence)basedSequence2.safeSubSequence(i3, i3 + 10)).toVisibleWhitespaceString(), ((BasedSequence)paramBasedSequence1
/* 262 */             .safeSubSequence(m - 10, m)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence1.safeSubSequence(m, m + 10)).toVisibleWhitespaceString(), ((BasedSequence)paramBasedSequence3
/* 263 */             .safeSubSequence(m - 10, m)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence3.safeSubSequence(m, m + 10)).toVisibleWhitespaceString() });
/*     */ 
/*     */       
/* 266 */       i2 = 0;
/* 267 */       i4 = 0;
/* 268 */       c1 = Character.MIN_VALUE;
/*     */       
/* 270 */       if (CharPredicate.WHITESPACE_NBSP.test(basedSequence2.safeCharAt(i3))) {
/*     */         
/* 272 */         if (CharPredicate.WHITESPACE_NBSP_OR_NUL.test(paramBasedSequence1.safeCharAt(m))) {
/* 273 */           byte b1 = -1;
/* 274 */           i2 = -1;
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 281 */           c1 = '\001';
/* 282 */           i4 = basedSequence2.countLeading(CharPredicate.WHITESPACE_NBSP, i3);
/*     */         } 
/* 284 */       } else if (basedSequence2.safeCharAt(i3) == ' ') {
/*     */         
/* 286 */         if (!CharPredicate.WHITESPACE_NBSP.test(basedSequence2.safeCharAt(i3 - 1))) {
/* 287 */           i2--;
/* 288 */           i4--;
/*     */         } else {
/*     */           
/* 291 */           b++;
/* 292 */           assert !CharPredicate.WHITESPACE_NBSP.test(basedSequence2.safeCharAt(i3 + 1)) : 
/* 293 */             String.format("Character(%s) after LS should not be whitespace.", new Object[] {
/* 294 */                 SequenceUtils.toVisibleWhitespaceString(Character.toString(basedSequence2.safeCharAt(i3 + true)))
/*     */               });
/* 296 */           bool1 = true;
/*     */         } 
/*     */       } 
/*     */       
/* 300 */       if (bool.booleanValue()) {
/* 301 */         int i5 = i3 + b + i4;
/* 302 */         System.out.println(String.format("adjusted altWrapped anchor: `%s`", new Object[] { ((BasedSequence)paramBasedSequence1.safeSubSequence(i5 - 10, i5)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence1.safeSubSequence(i5, i5 + 10)).toVisibleWhitespaceString() }));
/* 303 */         int i6 = m + i2;
/* 304 */         System.out.println(String.format("adjusted wrapped anchor: `%s`", new Object[] { ((BasedSequence)paramBasedSequence3.safeSubSequence(i6 - 10, i6)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence3.safeSubSequence(i6, i6 + 10)).toVisibleWhitespaceString() }));
/*     */       } 
/*     */       
/* 307 */       c2 = basedSequence2.safeCharAt(i3 + b + i4);
/* 308 */       char c3 = paramBasedSequence3.safeCharAt(m + i2);
/*     */ 
/*     */       
/* 311 */       assert SpaceMapper.areEquivalent(c2, c3) || (CharPredicate.WHITESPACE_NBSP
/* 312 */         .test(c2) && CharPredicate.WHITESPACE_NBSP.test(c3)) : 
/* 313 */         String.format("altUnwrapped.charAt: '%s'(%d) != wrapped.charAt: '%s'(%d) for width=%d, unwrapped: '%s', wrapped: '%s'", new Object[] {
/* 314 */             SequenceUtils.toVisibleWhitespaceString(Character.toString(c2)), 
/* 315 */             Integer.valueOf(c2), 
/* 316 */             SequenceUtils.toVisibleWhitespaceString(Character.toString(c3)), 
/* 317 */             Integer.valueOf(c3), 
/* 318 */             Integer.valueOf(this.width), 
/* 319 */             SequenceUtils.toVisibleWhitespaceString((CharSequence)basedSequence2), 
/* 320 */             SequenceUtils.toVisibleWhitespaceString((CharSequence)paramBasedSequence1)
/*     */           });
/*     */ 
/*     */       
/* 324 */       if (bool1) {
/* 325 */         m = Math.max(0, m - 1);
/* 326 */         if (bool.booleanValue()) {
/* 327 */           System.out.println(String.format("LSep Adj wrapped anchor: `%s`", new Object[] { ((BasedSequence)paramBasedSequence3.safeSubSequence(m - 10, m)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence3.safeSubSequence(m, m + 10)).toVisibleWhitespaceString() }));
/*     */         }
/*     */       } 
/*     */       
/* 331 */       if (paramBasedSequence3.isCharAt(m - 1, CharPredicate.ANY_EOL) && i1 > 0)
/*     */       {
/* 333 */         m -= paramBasedSequence3.eolEndLength(m);
/*     */       }
/*     */ 
/*     */       
/* 337 */       i2 = paramBasedSequence3.countTrailing(CharPredicate.SPACE_TAB_NBSP, m);
/* 338 */       i3 = paramBasedSequence3.countLeading(CharPredicate.SPACE_TAB_NBSP, m);
/*     */       
/* 340 */       if (trackedOffset.isAfterSpaceEdit()) {
/* 341 */         if (trackedOffset.isAfterInsert()) {
/*     */           
/* 343 */           n = Math.max(1, n);
/* 344 */         } else if (trackedOffset.isAfterDelete()) {
/* 345 */           n = 0;
/*     */         } 
/*     */       }
/*     */       
/* 349 */       n = trackedOffset.isSpliced() ? 0 : Math.max(0, n - i2);
/*     */       
/* 351 */       i1 = Math.max(c1, i1 - i3);
/*     */       
/* 353 */       if (paramBasedSequence3.isCharAt(m, CharPredicate.ANY_EOL_NUL)) {
/*     */         
/* 355 */         i1 = 0;
/* 356 */         if (trackedOffset.isAfterDelete()) n = Math.min(1, n); 
/* 357 */       } else if (!paramBasedSequence3.isCharAt(m - 1, CharPredicate.ANY_EOL_NUL)) {
/*     */ 
/*     */         
/* 360 */         n = Math.min(1, n);
/* 361 */       } else if (trackedOffset.isAfterDelete() && !trackedOffset.isAfterSpaceEdit()) {
/*     */ 
/*     */         
/* 364 */         n = 0;
/* 365 */         i1 = Math.min(1, i1);
/*     */       } else {
/*     */         
/* 368 */         if (!trackedOffset.isAfterInsert() && !trackedOffset.isAfterDelete()) i1 = 0; 
/* 369 */         n = 0;
/*     */       } 
/*     */       
/* 372 */       if (n + i1 > 0) {
/* 373 */         i2 = paramBasedSequence3.lastIndexOfAnyNot(CharPredicate.WHITESPACE_NBSP);
/* 374 */         if (m <= i2) {
/*     */           
/* 376 */           paramBasedSequence3 = (BasedSequence)paramBasedSequence3.insert(m, RepeatedSequence.ofSpaces(n + i1));
/*     */ 
/*     */           
/* 379 */           for (i2 = k + 1; i2 < i; i2++) {
/*     */             TrackedOffset trackedOffset1;
/* 381 */             i4 = (trackedOffset1 = this.trackedOffsets.get(i2)).getIndex();
/* 382 */             trackedOffset1.setIndex(i4 + n + i1);
/*     */           } 
/*     */         } else {
/* 385 */           j = Math.max(j, n);
/*     */         } 
/*     */         
/* 388 */         m += n;
/*     */       } 
/*     */       
/* 391 */       trackedOffset.setIndex(m);
/*     */       
/* 393 */       if (bool.booleanValue()) {
/* 394 */         System.out.println(String.format("Adj wrapped anchor: `%s`", new Object[] { ((BasedSequence)paramBasedSequence3.safeSubSequence(m - 20, m)).toVisibleWhitespaceString() + "|" + ((BasedSequence)paramBasedSequence3.safeSubSequence(m, m + 20)).toVisibleWhitespaceString() }));
/* 395 */         System.out.println();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 400 */     if (j > 0) {
/* 401 */       paramBasedSequence3 = (BasedSequence)paramBasedSequence3.appendSpaces(j);
/*     */     }
/*     */     
/* 404 */     return paramBasedSequence3;
/*     */   }
/*     */   
/*     */   public void addTrackedOffset(TrackedOffset paramTrackedOffset) {
/* 408 */     if (this.trackedOffsets == EMPTY_OFFSET_LIST) this.trackedOffsets = new ArrayList<>(); 
/* 409 */     assert paramTrackedOffset.getOffset() >= 0 && paramTrackedOffset.getOffset() <= this.altSeq.getBaseSequence().length();
/* 410 */     this.trackedOffsets.removeIf(paramTrackedOffset2 -> (paramTrackedOffset2.getOffset() == paramTrackedOffset1.getOffset()));
/* 411 */     this.trackedOffsets.add(paramTrackedOffset);
/* 412 */     this.trackedOffsetsSorted = false;
/*     */   }
/*     */   
/*     */   public List<TrackedOffset> getTrackedOffsets() {
/* 416 */     return sortedTrackedOffsets();
/*     */   }
/*     */   
/*     */   private List<TrackedOffset> sortedTrackedOffsets() {
/* 420 */     if (!this.trackedOffsetsSorted) {
/* 421 */       this.trackedOffsets.sort(Comparator.comparing(TrackedOffset::getOffset));
/* 422 */       this.trackedOffsetsSorted = true;
/*     */     } 
/* 424 */     return this.trackedOffsets;
/*     */   }
/*     */ 
/*     */   
/*     */   public TrackedOffset getTrackedOffset(int paramInt) {
/* 429 */     sortedTrackedOffsets();
/*     */     
/* 431 */     for (Iterator<TrackedOffset> iterator = this.trackedOffsets.iterator(); iterator.hasNext(); ) {
/* 432 */       TrackedOffset trackedOffset; if ((trackedOffset = iterator.next()).getOffset() == paramInt) return trackedOffset; 
/* 433 */       if (trackedOffset.getOffset() <= paramInt);
/*     */     } 
/* 435 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<? extends SpecialLeadInHandler> getLeadInHandlers() {
/* 440 */     return this.leadInHandlers;
/*     */   }
/*     */   
/*     */   public void setLeadInHandlers(List<? extends SpecialLeadInHandler> paramList) {
/* 444 */     this.leadInHandlers = paramList;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataHolder getOptions() {
/* 449 */     return this.options;
/*     */   }
/*     */   
/*     */   public void setOptions(DataHolder paramDataHolder) {
/* 453 */     this.options = paramDataHolder;
/*     */   }
/*     */   
/*     */   public boolean isRestoreTrackedSpaces() {
/* 457 */     return this.restoreTrackedSpaces;
/*     */   }
/*     */   
/*     */   public void setRestoreTrackedSpaces(boolean paramBoolean) {
/* 461 */     this.restoreTrackedSpaces = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getChars() {
/* 466 */     return this.baseSeq;
/*     */   }
/*     */   
/*     */   public CharSequence getFirstIndent() {
/* 470 */     return (CharSequence)this.firstIndent;
/*     */   }
/*     */   
/*     */   public void setFirstIndent(CharSequence paramCharSequence) {
/* 474 */     this.firstIndent = BasedSequence.of(paramCharSequence);
/*     */   }
/*     */   
/*     */   public CharSequence getIndent() {
/* 478 */     return (CharSequence)this.indent;
/*     */   }
/*     */   
/*     */   public void setIndent(CharSequence paramCharSequence) {
/* 482 */     this.indent = BasedSequence.of(paramCharSequence);
/* 483 */     if (this.firstIndent.isNull()) this.firstIndent = this.indent; 
/*     */   }
/*     */   
/*     */   public int getFirstWidth() {
/* 487 */     return (this.width == 0) ? 0 : Math.max(0, this.width + this.firstWidthOffset);
/*     */   }
/*     */   
/*     */   public int getFirstWidthOffset() {
/* 491 */     return this.firstWidthOffset;
/*     */   }
/*     */   
/*     */   public void setFirstWidthOffset(int paramInt) {
/* 495 */     this.firstWidthOffset = paramInt;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 499 */     return this.width;
/*     */   }
/*     */   
/*     */   public void setWidth(int paramInt) {
/* 503 */     this.width = Math.max(0, paramInt);
/*     */   }
/*     */   
/*     */   public boolean getKeepHardBreaks() {
/* 507 */     return this.keepHardLineBreaks;
/*     */   }
/*     */   
/*     */   public void setKeepHardBreaks(boolean paramBoolean) {
/* 511 */     this.keepHardLineBreaks = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getKeepSoftBreaks() {
/* 515 */     return this.keepSoftLineBreaks;
/*     */   }
/*     */   
/*     */   public boolean isUnEscapeSpecialLeadIn() {
/* 519 */     return this.unEscapeSpecialLeadInChars;
/*     */   }
/*     */   
/*     */   public void setUnEscapeSpecialLeadIn(boolean paramBoolean) {
/* 523 */     this.unEscapeSpecialLeadInChars = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isEscapeSpecialLeadIn() {
/* 527 */     return this.escapeSpecialLeadInChars;
/*     */   }
/*     */   
/*     */   public void setEscapeSpecialLeadIn(boolean paramBoolean) {
/* 531 */     this.escapeSpecialLeadInChars = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setKeepSoftBreaks(boolean paramBoolean) {
/* 535 */     this.keepSoftLineBreaks = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharWidthProvider getCharWidthProvider() {
/* 540 */     return this.charWidthProvider;
/*     */   }
/*     */   
/*     */   public enum TextType {
/* 544 */     WORD,
/* 545 */     SPACE,
/* 546 */     BREAK,
/* 547 */     MARKDOWN_BREAK,
/* 548 */     MARKDOWN_START_LINE;
/*     */   }
/*     */   
/*     */   public static class Token {
/*     */     public final MarkdownParagraph.TextType type;
/*     */     public final Range range;
/*     */     public final boolean isFirstWord;
/*     */     
/*     */     private Token(MarkdownParagraph.TextType param1TextType, Range param1Range, boolean param1Boolean) {
/* 557 */       this.type = param1TextType;
/* 558 */       this.range = param1Range;
/* 559 */       this.isFirstWord = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 564 */       return "token: " + this.type + " " + this.range + (this.isFirstWord ? " isFirst" : "");
/*     */     }
/*     */     
/*     */     public BasedSequence subSequence(BasedSequence param1BasedSequence) {
/* 568 */       return this.range.basedSubSequence((CharSequence)param1BasedSequence);
/*     */     }
/*     */     
/*     */     public CharSequence subSequence(CharSequence param1CharSequence) {
/* 572 */       return this.range.charSubSequence(param1CharSequence);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Token of(MarkdownParagraph.TextType param1TextType, Range param1Range) {
/* 577 */       return new Token(param1TextType, param1Range, false);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Token of(MarkdownParagraph.TextType param1TextType, int param1Int1, int param1Int2) {
/* 582 */       return new Token(param1TextType, Range.of(param1Int1, param1Int2), false);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Token of(MarkdownParagraph.TextType param1TextType, Range param1Range, boolean param1Boolean) {
/* 587 */       return new Token(param1TextType, param1Range, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Token of(MarkdownParagraph.TextType param1TextType, int param1Int1, int param1Int2, boolean param1Boolean) {
/* 592 */       return new Token(param1TextType, Range.of(param1Int1, param1Int2), param1Boolean);
/*     */     }
/*     */   }
/*     */   
/*     */   class LeftAlignedWrapping {
/*     */     final BasedSequence baseSeq;
/*     */     final SequenceBuilder result;
/*     */     final MarkdownParagraph.TextTokenizer tokenizer;
/* 600 */     int col = 0;
/* 601 */     int lineCount = 0;
/* 602 */     final int spaceWidth = MarkdownParagraph.this.charWidthProvider.getSpaceWidth();
/* 603 */     CharSequence lineIndent = MarkdownParagraph.this.getFirstIndent();
/* 604 */     final CharSequence nextIndent = MarkdownParagraph.this.getIndent();
/* 605 */     int lineWidth = this.spaceWidth * MarkdownParagraph.this.getFirstWidth();
/* 606 */     final int nextWidth = (MarkdownParagraph.this.width <= 0) ? Integer.MAX_VALUE : (this.spaceWidth * MarkdownParagraph.this.width);
/* 607 */     int wordsOnLine = 0;
/* 608 */     BasedSequence lastSpace = null;
/* 609 */     List<? extends SpecialLeadInHandler> leadInHandlers = MarkdownParagraph.this.leadInHandlers;
/* 610 */     boolean unEscapeSpecialLeadInChars = MarkdownParagraph.this.unEscapeSpecialLeadInChars;
/* 611 */     boolean escapeSpecialLeadInChars = MarkdownParagraph.this.escapeSpecialLeadInChars;
/*     */     
/*     */     LeftAlignedWrapping(BasedSequence param1BasedSequence) {
/* 614 */       this.baseSeq = param1BasedSequence;
/* 615 */       this.result = SequenceBuilder.emptyBuilder(param1BasedSequence);
/* 616 */       this.tokenizer = new MarkdownParagraph.TextTokenizer((CharSequence)param1BasedSequence);
/*     */     }
/*     */     
/*     */     void advance() {
/* 620 */       this.tokenizer.next();
/*     */     }
/*     */     
/*     */     void addToken(MarkdownParagraph.Token param1Token) {
/* 624 */       addChars((CharSequence)this.baseSeq.subSequence(param1Token.range.getStart(), param1Token.range.getEnd()));
/*     */     }
/*     */     
/*     */     void addChars(CharSequence param1CharSequence) {
/* 628 */       this.result.append(param1CharSequence);
/* 629 */       this.col += MarkdownParagraph.this.charWidthProvider.getStringWidth(param1CharSequence);
/*     */     }
/*     */     
/*     */     void addSpaces(int param1Int) {
/* 633 */       this.result.append(' ', param1Int);
/* 634 */       this.col += MarkdownParagraph.this.charWidthProvider.getSpaceWidth() * param1Int;
/*     */     }
/*     */     
/*     */     BasedSequence addSpaces(BasedSequence param1BasedSequence, int param1Int) {
/* 638 */       if (param1Int <= 0) return param1BasedSequence;
/*     */       
/* 640 */       BasedSequence basedSequence = null;
/*     */ 
/*     */       
/* 643 */       if (param1BasedSequence != null) {
/* 644 */         addChars((CharSequence)param1BasedSequence.subSequence(0, Math.min(param1BasedSequence.length(), param1Int)));
/*     */         
/* 646 */         if (param1BasedSequence.length() > param1Int) {
/* 647 */           basedSequence = (BasedSequence)param1BasedSequence.subSequence(param1Int);
/*     */         }
/*     */         
/* 650 */         param1Int = Math.max(0, param1Int - param1BasedSequence.length());
/*     */       } 
/*     */ 
/*     */       
/* 654 */       if (param1Int > 0) {
/* 655 */         addSpaces(param1Int);
/*     */       }
/*     */       
/* 658 */       return basedSequence;
/*     */     }
/*     */     
/*     */     void afterLineBreak() {
/* 662 */       this.col = 0;
/* 663 */       this.wordsOnLine = 0;
/* 664 */       this.lineCount++;
/* 665 */       this.lineIndent = this.nextIndent;
/* 666 */       this.lineWidth = this.nextWidth;
/* 667 */       this.lastSpace = null;
/*     */     }
/*     */     
/*     */     void processLeadInEscape(List<? extends SpecialLeadInHandler> param1List, BasedSequence param1BasedSequence) {
/* 671 */       if (param1BasedSequence.isNotEmpty() && this.escapeSpecialLeadInChars)
/* 672 */         for (Iterator<? extends SpecialLeadInHandler> iterator = param1List.iterator(); iterator.hasNext();) {
/* 673 */           if ((specialLeadInHandler = iterator.next()).escape(param1BasedSequence, MarkdownParagraph.this.options, this::addChars))
/*     */             return; 
/*     */         }  
/* 676 */       addChars((CharSequence)param1BasedSequence);
/*     */     }
/*     */     
/*     */     void processLeadInUnEscape(List<? extends SpecialLeadInHandler> param1List, BasedSequence param1BasedSequence) {
/* 680 */       if (param1BasedSequence.isNotEmpty() && this.unEscapeSpecialLeadInChars)
/* 681 */         for (Iterator<? extends SpecialLeadInHandler> iterator = param1List.iterator(); iterator.hasNext();) {
/* 682 */           if ((specialLeadInHandler = iterator.next()).unEscape(param1BasedSequence, MarkdownParagraph.this.options, this::addChars))
/*     */             return; 
/*     */         }  
/* 685 */       addChars((CharSequence)param1BasedSequence);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     BasedSequence wrapText() {
/*     */       MarkdownParagraph.Token token;
/* 692 */       while ((token = this.tokenizer.getToken()) != null) {
/* 693 */         switch (token.type) {
/*     */           case SPACE:
/* 695 */             if (this.col != 0) this.lastSpace = (BasedSequence)this.baseSeq.subSequence(token.range); 
/* 696 */             advance();
/*     */ 
/*     */ 
/*     */           
/*     */           case WORD:
/* 701 */             if (this.col == 0 || this.col + MarkdownParagraph.this.charWidthProvider.getStringWidth((CharSequence)token.subSequence(this.baseSeq)) + this.spaceWidth <= this.lineWidth) {
/*     */               
/* 703 */               boolean bool = (this.col == 0) ? true : false;
/*     */ 
/*     */               
/* 706 */               if (this.col > 0) {
/* 707 */                 this.lastSpace = addSpaces(this.lastSpace, 1);
/*     */               }
/* 709 */               else if (!SequenceUtils.isEmpty(this.lineIndent)) {
/* 710 */                 addChars(this.lineIndent);
/*     */               } 
/*     */ 
/*     */               
/* 714 */               if (bool && !token.isFirstWord) {
/* 715 */                 processLeadInEscape(this.leadInHandlers, (BasedSequence)this.baseSeq.subSequence(token.range));
/* 716 */               } else if (!bool && token.isFirstWord) {
/* 717 */                 processLeadInUnEscape(this.leadInHandlers, (BasedSequence)this.baseSeq.subSequence(token.range));
/*     */               } else {
/* 719 */                 addToken(token);
/*     */               } 
/*     */               
/* 722 */               advance();
/* 723 */               this.wordsOnLine++;
/*     */               continue;
/*     */             } 
/* 726 */             addChars("\n");
/* 727 */             afterLineBreak();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case MARKDOWN_START_LINE:
/* 734 */             if (this.col > 0) {
/* 735 */               addChars("\n");
/* 736 */               afterLineBreak();
/*     */             } 
/* 738 */             advance();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case MARKDOWN_BREAK:
/* 744 */             if (MarkdownParagraph.this.keepHardLineBreaks) {
/* 745 */               if (this.col > 0) {
/* 746 */                 addToken(token);
/* 747 */                 afterLineBreak();
/*     */               } 
/*     */             } else {
/*     */               
/* 751 */               this.lastSpace = (BasedSequence)this.baseSeq.subSequence(token.range);
/*     */             } 
/* 753 */             advance();
/*     */ 
/*     */ 
/*     */           
/*     */           case BREAK:
/* 758 */             if (this.col > 0 && MarkdownParagraph.this.keepSoftLineBreaks) {
/*     */               
/* 760 */               addToken(token);
/* 761 */               afterLineBreak();
/*     */             } 
/* 763 */             advance();
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/* 769 */       return this.result.toSequence();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TextTokenizer {
/*     */     private final CharSequence chars;
/*     */     private final int maxIndex;
/* 776 */     private int index = 0;
/* 777 */     private int lastPos = 0;
/*     */     private boolean isInWord = false;
/*     */     private boolean isFirstNonBlank = true;
/* 780 */     private int lastConsecutiveSpaces = 0;
/* 781 */     private MarkdownParagraph.Token token = null;
/*     */     
/*     */     TextTokenizer(CharSequence param1CharSequence) {
/* 784 */       this.chars = param1CharSequence;
/* 785 */       this.maxIndex = this.chars.length();
/* 786 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 790 */       this.index = 0;
/* 791 */       this.lastPos = 0;
/* 792 */       this.isInWord = false;
/* 793 */       this.token = null;
/* 794 */       this.lastConsecutiveSpaces = 0;
/* 795 */       this.isFirstNonBlank = true;
/* 796 */       next();
/*     */     }
/*     */ 
/*     */     
/*     */     MarkdownParagraph.Token getToken() {
/* 801 */       return this.token;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<MarkdownParagraph.Token> asList() {
/* 806 */       ArrayList<MarkdownParagraph.Token> arrayList = new ArrayList();
/* 807 */       reset();
/*     */       
/* 809 */       while (this.token != null) {
/* 810 */         arrayList.add(this.token);
/* 811 */         next();
/*     */       } 
/*     */       
/* 814 */       return arrayList;
/*     */     }
/*     */     
/*     */     void next() {
/* 818 */       this.token = null;
/* 819 */       while (this.index < this.maxIndex) {
/* 820 */         boolean bool; char c = this.chars.charAt(this.index);
/* 821 */         if (this.isInWord) {
/* 822 */           if (c == ' ' || c == '\t' || c == '\n' || c == ' ') {
/* 823 */             this.isInWord = false;
/* 824 */             bool = this.isFirstNonBlank;
/* 825 */             this.isFirstNonBlank = false;
/*     */             
/* 827 */             if (this.lastPos < this.index) {
/*     */               
/* 829 */               this.token = MarkdownParagraph.Token.of(MarkdownParagraph.TextType.WORD, this.lastPos, this.index, bool);
/* 830 */               this.lastPos = this.index; break;
/*     */             } 
/*     */             continue;
/*     */           } 
/* 834 */           this.index++;
/*     */           
/*     */           continue;
/*     */         } 
/* 838 */         if (bool != 32 && bool != 9 && bool != 10 && bool != 8232) {
/* 839 */           if (this.lastPos < this.index) {
/* 840 */             this.token = MarkdownParagraph.Token.of(MarkdownParagraph.TextType.SPACE, this.lastPos, this.index);
/* 841 */             this.lastPos = this.index;
/* 842 */             this.isInWord = true;
/* 843 */             this.lastConsecutiveSpaces = 0;
/*     */             break;
/*     */           } 
/* 846 */           this.isInWord = true;
/* 847 */           this.lastConsecutiveSpaces = 0;
/*     */           continue;
/*     */         } 
/* 850 */         if (bool == 10) {
/* 851 */           if (this.lastConsecutiveSpaces >= 2) {
/* 852 */             this.token = MarkdownParagraph.Token.of(MarkdownParagraph.TextType.MARKDOWN_BREAK, this.index - this.lastConsecutiveSpaces, this.index + 1);
/*     */           } else {
/* 854 */             this.token = MarkdownParagraph.Token.of(MarkdownParagraph.TextType.BREAK, this.index, this.index + 1);
/*     */           } 
/*     */           
/* 857 */           this.lastPos = this.index + 1;
/* 858 */           this.lastConsecutiveSpaces = 0;
/* 859 */           this.isFirstNonBlank = true;
/* 860 */           this.index++; break;
/*     */         } 
/* 862 */         if (bool == 8232) {
/* 863 */           this.token = MarkdownParagraph.Token.of(MarkdownParagraph.TextType.MARKDOWN_START_LINE, this.index, this.index + 1);
/* 864 */           this.lastPos = this.index + 1;
/* 865 */           this.lastConsecutiveSpaces = 0;
/* 866 */           this.index++;
/*     */           break;
/*     */         } 
/* 869 */         if (bool == 32) { this.lastConsecutiveSpaces++; }
/* 870 */         else { this.lastConsecutiveSpaces = 0; }
/* 871 */          this.index++;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 877 */       if (this.lastPos < this.index) {
/* 878 */         if (this.isInWord) {
/* 879 */           this.token = MarkdownParagraph.Token.of(MarkdownParagraph.TextType.WORD, this.lastPos, this.index, this.isFirstNonBlank);
/* 880 */           this.isFirstNonBlank = false;
/*     */         } else {
/* 882 */           this.token = MarkdownParagraph.Token.of(MarkdownParagraph.TextType.SPACE, this.lastPos, this.index);
/*     */         } 
/* 884 */         this.lastPos = this.index;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\MarkdownParagraph.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */