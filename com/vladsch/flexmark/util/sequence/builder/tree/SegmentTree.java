/*     */ package com.vladsch.flexmark.util.sequence.builder.tree;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.DelimitedBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.Seg;
/*     */ import java.util.Arrays;
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
/*     */ public class SegmentTree
/*     */ {
/*     */   public static final int MAX_VALUE = 536870911;
/*     */   public static final int F_ANCHOR_FLAGS = -536870912;
/*     */   protected final int[] treeData;
/*     */   protected final byte[] segmentBytes;
/*     */   
/*     */   protected SegmentTree(int[] paramArrayOfint, byte[] paramArrayOfbyte) {
/*  27 */     this.treeData = paramArrayOfint;
/*  28 */     this.segmentBytes = paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   public int[] getTreeData() {
/*  32 */     return this.treeData;
/*     */   }
/*     */   
/*     */   public byte[] getSegmentBytes() {
/*  36 */     return this.segmentBytes;
/*     */   }
/*     */   
/*     */   public int size() {
/*  40 */     return this.treeData.length / 2;
/*     */   }
/*     */   
/*     */   public int aggrLength(int paramInt) {
/*  44 */     return (paramInt < 0) ? 0 : this.treeData[paramInt << 1];
/*     */   }
/*     */   
/*     */   public int byteOffsetData(int paramInt) {
/*  48 */     return this.treeData[(paramInt << 1) + 1];
/*     */   }
/*     */   
/*     */   public int byteOffset(int paramInt) {
/*  52 */     return getByteOffset(this.treeData[(paramInt << 1) + 1]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getByteOffset(int paramInt) {
/*  57 */     return ((paramInt = paramInt & 0x1FFFFFFF) == 536870911) ? -1 : paramInt;
/*     */   }
/*     */   
/*     */   public static int getAnchorOffset(int paramInt) {
/*  61 */     return (paramInt & 0xE0000000) >>> 29;
/*     */   }
/*     */   
/*     */   public boolean hasPreviousAnchor(int paramInt) {
/*  65 */     return (getAnchorOffset(this.treeData[(paramInt << 1) + 1]) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int previousAnchorOffset(int paramInt) {
/*  70 */     return getByteOffset(paramInt = byteOffsetData(paramInt)) - getAnchorOffset(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public SegmentTreePos findSegmentPos(int paramInt) {
/*  75 */     return findSegmentPos(paramInt, this.treeData, 0, size());
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment getSegment(int paramInt1, int paramInt2, int paramInt3, BasedSequence paramBasedSequence) {
/*  80 */     return Segment.getSegment(this.segmentBytes, paramInt1, paramInt2, paramInt3, paramBasedSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment findSegment(int paramInt, BasedSequence paramBasedSequence, Segment paramSegment) {
/*  85 */     return findSegment(paramInt, 0, size(), paramBasedSequence, paramSegment);
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment findSegment(int paramInt1, int paramInt2, int paramInt3, BasedSequence paramBasedSequence, Segment paramSegment) {
/*  90 */     if (paramSegment != null) {
/*     */       
/*  92 */       int i = paramSegment.getStartIndex();
/*  93 */       if (paramInt1 >= i) {
/*  94 */         int j = paramSegment.getEndIndex();
/*  95 */         assert paramInt1 >= j : String.format("FindSegment should not be called, index %d is in range [%d, %d) of hint segment: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), paramSegment });
/*  96 */         if (paramSegment.pos + 1 >= paramInt3) return null; 
/*  97 */         paramInt2 = aggrLength(paramSegment.pos + 1);
/*  98 */         if (paramInt1 < paramInt2)
/*     */         {
/*     */           
/* 101 */           return Segment.getSegment(this.segmentBytes, byteOffset(paramSegment.pos + 1), paramSegment.pos + 1, j, paramBasedSequence);
/*     */         }
/*     */         
/* 104 */         paramInt2 = paramSegment.pos + 2;
/*     */       } else {
/*     */         
/* 107 */         if (paramSegment.pos == paramInt2) return null;
/*     */         
/* 109 */         int j = aggrLength(paramSegment.pos - 2);
/* 110 */         if (paramInt1 >= j)
/*     */         {
/*     */ 
/*     */           
/* 114 */           return Segment.getSegment(this.segmentBytes, byteOffset(paramSegment.pos - 1), paramSegment.pos - 1, j, paramBasedSequence);
/*     */         }
/*     */         
/* 117 */         paramInt3 = paramSegment.pos - 1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 122 */     if (paramInt2 >= 0 && paramInt2 < size()) {
/* 123 */       int i = aggrLength(paramInt2);
/* 124 */       if (paramInt1 < i) {
/* 125 */         int j = aggrLength(paramInt2 - 1);
/* 126 */         if (paramInt1 >= j)
/*     */         {
/*     */           
/* 129 */           return Segment.getSegment(this.segmentBytes, byteOffset(paramInt2), paramInt2, j, paramBasedSequence);
/*     */         }
/*     */         
/* 132 */         paramInt3 = paramInt2;
/*     */       } else {
/*     */         
/* 135 */         paramInt2++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 140 */     if (paramInt3 - 1 >= paramInt2) {
/*     */       
/* 142 */       int i = aggrLength(paramInt3 - 2);
/* 143 */       if (paramInt1 >= i) {
/* 144 */         int j = aggrLength(paramInt3 - 1);
/* 145 */         if (paramInt1 >= j) return null;
/*     */ 
/*     */ 
/*     */         
/* 149 */         return Segment.getSegment(this.segmentBytes, byteOffset(paramInt3 - 1), paramInt3 - 1, i, paramBasedSequence);
/*     */       } 
/*     */       
/* 152 */       paramInt3--;
/*     */     } 
/*     */ 
/*     */     
/*     */     SegmentTreePos segmentTreePos;
/*     */     
/* 158 */     if ((segmentTreePos = findSegmentPos(paramInt1, paramInt2, paramInt3)) != null) {
/* 159 */       return Segment.getSegment(this.segmentBytes, byteOffset(segmentTreePos.pos), segmentTreePos.pos, segmentTreePos.startIndex, paramBasedSequence);
/*     */     }
/* 161 */     return null;
/*     */   }
/*     */   public SegmentTreeRange getSegmentRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BasedSequence paramBasedSequence, Segment paramSegment) {
/*     */     Segment segment1;
/*     */     Segment segment2;
/*     */     int i;
/*     */     int j;
/*     */     Segment segment3;
/* 169 */     if (paramInt1 == paramInt2) {
/*     */ 
/*     */       
/* 172 */       if ((segment3 = (Segment)((paramSegment == null || paramSegment.notInSegment(paramInt1)) ? findSegment(paramInt1, paramInt3, paramInt4, paramBasedSequence, paramSegment) : paramSegment)) == null) {
/* 173 */         assert paramInt1 > 0;
/*     */         
/* 175 */         segment3 = (paramSegment == null || paramSegment.notInSegment(paramInt1 - 1)) ? findSegment(paramInt1 - 1, paramInt3, paramInt4, paramBasedSequence, paramSegment) : paramSegment;
/* 176 */         assert segment3 != null;
/*     */ 
/*     */         
/* 179 */         if (segment3.notInSegment(paramInt1) && segment3.pos + 1 < size() && 
/*     */           
/* 181 */           !(segment2 = getSegment(segment3.pos + 1, paramBasedSequence)).notInSegment(paramInt1)) {
/* 182 */           segment3 = segment2;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 187 */       segment1 = segment3;
/*     */     } else {
/* 189 */       segment3 = (paramSegment == null || paramSegment.notInSegment(paramInt1)) ? findSegment(paramInt1, segment1, segment2, paramBasedSequence, paramSegment) : paramSegment;
/* 190 */       assert segment3 != null;
/* 191 */       segment1 = !segment3.notInSegment(paramInt2 - 1) ? segment3 : ((paramSegment == null || paramSegment.notInSegment(paramInt2 - 1)) ? findSegment(paramInt2 - 1, segment1, segment2, paramBasedSequence, segment3) : paramSegment);
/* 192 */       assert segment1 != null;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     if (segment3.isText()) {
/* 200 */       i = getTextStartOffset(segment3, paramBasedSequence);
/*     */     } else {
/* 202 */       i = segment3.getStartOffset() + paramInt1 - segment3.getStartIndex();
/*     */     } 
/*     */ 
/*     */     
/* 206 */     if (segment1.isText()) {
/* 207 */       j = getTextEndOffset(segment1, paramBasedSequence);
/*     */     } else {
/* 209 */       j = segment1.getStartOffset() + paramInt2 - segment1.getStartIndex();
/*     */     } 
/*     */     
/* 212 */     if (i < 0) {
/* 213 */       if (segment3.pos + 1 < size()) {
/*     */         int k;
/*     */         Segment segment;
/* 216 */         if ((k = (segment = getSegment(segment3.pos + 1, paramBasedSequence)).getStartOffset()) > j && j != -1) k = j; 
/*     */       } else {
/* 218 */         i = j;
/*     */       } 
/*     */     }
/*     */     
/* 222 */     if (j < i) j = i;
/*     */     
/* 224 */     if (i > paramBasedSequence.length()) {
/* 225 */       throw new IllegalStateException(String.format("startOffset:%d > baseSeq.length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBasedSequence.length()) }));
/*     */     }
/*     */     
/* 228 */     if (j > paramBasedSequence.length()) {
/* 229 */       throw new IllegalStateException(String.format("endOffset:%d > baseSeq.length: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramBasedSequence.length()) }));
/*     */     }
/*     */     
/* 232 */     return new SegmentTreeRange(paramInt1, paramInt2, i, j, segment3.pos, segment1.pos + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextEndOffset(Segment paramSegment, BasedSequence paramBasedSequence) {
/* 243 */     assert paramSegment.isText();
/*     */     
/* 245 */     if (paramSegment.pos + 1 < size() && (
/*     */       
/* 247 */       paramSegment = getSegment(paramSegment.pos + 1, paramBasedSequence)).isBase()) {
/* 248 */       return paramSegment.getStartOffset();
/*     */     }
/*     */     
/* 251 */     return -1;
/*     */   }
/*     */   
/*     */   public int getTextStartOffset(Segment paramSegment, BasedSequence paramBasedSequence) {
/* 255 */     assert paramSegment.isText();
/*     */     
/*     */     Segment segment;
/* 258 */     if ((segment = getPrevAnchor(paramSegment.pos, paramBasedSequence)) == null && paramSegment.pos > 0) {
/* 259 */       segment = getSegment(paramSegment.pos - 1, paramBasedSequence);
/*     */     }
/*     */     
/* 262 */     if (segment != null && segment.isBase()) {
/* 263 */       return segment.getEndOffset();
/*     */     }
/* 265 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder, SegmentTreeRange paramSegmentTreeRange) {
/* 275 */     addSegments(paramIBasedSegmentBuilder, paramSegmentTreeRange.startIndex, paramSegmentTreeRange.endIndex, paramSegmentTreeRange.startOffset, paramSegmentTreeRange.endOffset, paramSegmentTreeRange.startPos, paramSegmentTreeRange.endPos);
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
/*     */   public void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 291 */     if (paramInt3 != -1) {
/* 292 */       paramIBasedSegmentBuilder.appendAnchor(paramInt3);
/*     */     }
/*     */     
/* 295 */     paramInt3 = paramInt3;
/* 296 */     BasedSequence basedSequence = paramIBasedSegmentBuilder.getBaseSequence();
/*     */     
/* 298 */     for (int i = paramInt5; i < paramInt6; i++) {
/*     */       Segment segment;
/*     */       
/* 301 */       if ((segment = getSegment(i, basedSequence)).isText()) {
/*     */         Segment segment1;
/*     */         
/* 304 */         if ((segment1 = getPrevAnchor(i, basedSequence)) != null) paramIBasedSegmentBuilder.appendAnchor(segment1.getStartOffset());
/*     */       
/*     */       } 
/*     */ 
/*     */       
/* 309 */       CharSequence charSequence = getCharSequence(segment, paramInt1, paramInt2, paramInt5, paramInt6);
/*     */       
/* 311 */       if (segment.isText()) {
/* 312 */         paramIBasedSegmentBuilder.append(charSequence);
/*     */         Segment segment1;
/*     */         int j;
/* 315 */         if ((j = segment.byteOffset + segment.getByteLength()) < this.segmentBytes.length && (i + 1 >= size() || j != byteOffset(i + 1)) && (
/*     */           
/* 317 */           segment1 = Segment.getSegment(this.segmentBytes, j, 0, 0, basedSequence)).isAnchor()) {
/* 318 */           paramIBasedSegmentBuilder.appendAnchor(segment1.getStartOffset());
/*     */         }
/*     */       } else {
/*     */         
/* 322 */         assert charSequence instanceof BasedSequence;
/* 323 */         BasedSequence basedSequence1 = (BasedSequence)charSequence;
/* 324 */         paramInt3 = Math.max(paramInt3, basedSequence1.getEndOffset());
/* 325 */         paramIBasedSegmentBuilder.append(basedSequence1.getStartOffset(), basedSequence1.getEndOffset());
/*     */       } 
/*     */     } 
/*     */     
/* 329 */     if (paramInt4 != -1) {
/* 330 */       paramIBasedSegmentBuilder.appendAnchor(Math.max(paramInt3, paramInt4));
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
/*     */   public static CharSequence getCharSequence(Segment paramSegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     CharSequence charSequence;
/*     */     int i;
/* 349 */     if ((i = paramSegment.pos) == paramInt3 && i + 1 == paramInt4) {
/*     */       
/* 351 */       charSequence = paramSegment.getCharSequence().subSequence(paramInt1 - paramSegment.getStartIndex(), paramInt2 - paramSegment.getStartIndex());
/* 352 */     } else if (i == paramInt3) {
/*     */       
/* 354 */       charSequence = charSequence.getCharSequence().subSequence(paramInt1 - charSequence.getStartIndex(), charSequence.length());
/* 355 */     } else if (i + 1 == paramInt4) {
/*     */       
/* 357 */       charSequence = charSequence.getCharSequence().subSequence(0, paramInt2 - charSequence.getStartIndex());
/*     */     } else {
/* 359 */       charSequence = charSequence.getCharSequence();
/*     */     } 
/*     */     
/* 362 */     return charSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public SegmentTreePos findSegmentPos(int paramInt1, int paramInt2, int paramInt3) {
/* 367 */     return findSegmentPos(paramInt1, this.treeData, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment getSegment(int paramInt, BasedSequence paramBasedSequence) {
/* 372 */     return Segment.getSegment(this.segmentBytes, byteOffset(paramInt), paramInt, aggrLength(paramInt - 1), paramBasedSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment getPrevAnchor(int paramInt, BasedSequence paramBasedSequence) {
/* 377 */     return getPrevAnchor(paramInt, this.treeData, this.segmentBytes, paramBasedSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(BasedSequence paramBasedSequence) {
/*     */     DelimitedBuilder delimitedBuilder;
/* 383 */     (delimitedBuilder = new DelimitedBuilder(", ")).append(getClass().getSimpleName()).append("{aggr: {");
/* 384 */     int i = size(); int j;
/* 385 */     for (j = 0; j < i; j++) {
/* 386 */       delimitedBuilder.append("[").append(aggrLength(j)).append(", ").append(byteOffset(j)).append(":");
/* 387 */       if (hasPreviousAnchor(j)) {
/* 388 */         delimitedBuilder.append(", ").append(previousAnchorOffset(j)).append(":");
/*     */       }
/* 390 */       delimitedBuilder.append("]").mark();
/*     */     } 
/*     */     
/* 393 */     delimitedBuilder.unmark().append(" }, seg: { ");
/* 394 */     j = 0;
/* 395 */     while (j < this.segmentBytes.length) {
/* 396 */       Segment segment = Segment.getSegment(this.segmentBytes, j, 0, 0, paramBasedSequence);
/* 397 */       delimitedBuilder.append(j).append(":").append(segment).mark();
/* 398 */       j += segment.getByteLength();
/*     */     } 
/* 400 */     delimitedBuilder.unmark().append(" } }");
/* 401 */     return delimitedBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 407 */     return toString(BasedSequence.NULL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int aggrLength(int paramInt, int[] paramArrayOfint) {
/* 412 */     return (paramInt < 0) ? 0 : paramArrayOfint[paramInt << 1];
/*     */   }
/*     */   
/*     */   public static int byteOffsetData(int paramInt, int[] paramArrayOfint) {
/* 416 */     return paramArrayOfint[(paramInt << 1) + 1];
/*     */   }
/*     */   
/*     */   public static int byteOffset(int paramInt, int[] paramArrayOfint) {
/* 420 */     return getByteOffset(byteOffsetData(paramInt, paramArrayOfint));
/*     */   }
/*     */   
/*     */   public static void setTreeData(int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3, int paramInt4) {
/* 424 */     assert paramInt3 <= 536870911;
/* 425 */     paramArrayOfint[paramInt1 << 1] = paramInt2;
/* 426 */     paramArrayOfint[(paramInt1 << 1) + 1] = paramInt3 | ((paramInt4 == 0) ? 0 : (paramInt4 << 29));
/*     */   }
/*     */   
/*     */   public static boolean hasPreviousAnchor(int paramInt, int[] paramArrayOfint) {
/* 430 */     return (getAnchorOffset(paramArrayOfint[(paramInt << 1) + 1]) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int previousAnchorOffset(int paramInt, int[] paramArrayOfint) {
/* 435 */     return getByteOffset(paramInt = byteOffsetData(paramInt, paramArrayOfint)) - getAnchorOffset(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SegmentTreePos findSegmentPos(int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3) {
/* 442 */     if (paramInt1 == 0 && paramInt2 == 0) return new SegmentTreePos(0, 0, 0);
/*     */     
/* 444 */     byte b = 0;
/* 445 */     while (paramInt2 < paramInt3) {
/* 446 */       int i = paramInt2 + paramInt3 >> 1;
/* 447 */       int j = paramInt2;
/* 448 */       int k = paramInt3;
/*     */       
/* 450 */       b++;
/*     */ 
/*     */       
/* 453 */       int m = aggrLength(i, paramArrayOfint);
/* 454 */       if (paramInt1 >= m) {
/* 455 */         paramInt2 = i + 1;
/*     */       } else {
/* 457 */         paramInt3 = aggrLength(i - 1, paramArrayOfint);
/* 458 */         if (paramInt1 < paramInt3) {
/* 459 */           paramInt3 = i;
/*     */         } else {
/*     */           
/* 462 */           return new SegmentTreePos(i, paramInt3, b);
/*     */         } 
/*     */       } 
/*     */       
/* 466 */       assert j != paramInt2 || k != paramInt3 : "Range and position did not change after iteration: pos=" + i + ", startPos=" + paramInt2 + ", endPos=" + paramInt3 + "\n" + 
/* 467 */         Arrays.toString(paramArrayOfint);
/*     */     } 
/*     */     
/* 470 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Segment findSegment(int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3, byte[] paramArrayOfbyte, BasedSequence paramBasedSequence) {
/*     */     SegmentTreePos segmentTreePos;
/* 476 */     if ((segmentTreePos = findSegmentPos(paramInt1, paramArrayOfint, paramInt2, paramInt3)) != null) {
/* 477 */       return Segment.getSegment(paramArrayOfbyte, byteOffset(segmentTreePos.pos, paramArrayOfint), segmentTreePos.pos, segmentTreePos.startIndex, paramBasedSequence);
/*     */     }
/* 479 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Segment getSegment(int paramInt, int[] paramArrayOfint, byte[] paramArrayOfbyte, BasedSequence paramBasedSequence) {
/* 484 */     return Segment.getSegment(paramArrayOfbyte, byteOffset(paramInt, paramArrayOfint), paramInt, aggrLength(paramInt, paramArrayOfint), paramBasedSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Segment getPrevAnchor(int paramInt, int[] paramArrayOfint, byte[] paramArrayOfbyte, BasedSequence paramBasedSequence) {
/*     */     int i;
/* 491 */     if ((i = getAnchorOffset(paramInt = byteOffsetData(paramInt, paramArrayOfint))) > 0) {
/* 492 */       paramInt = getByteOffset(paramInt) - i;
/* 493 */       Segment segment = Segment.getSegment(paramArrayOfbyte, paramInt, -1, 0, paramBasedSequence);
/* 494 */       assert segment.isAnchor();
/* 495 */       return segment;
/*     */     } 
/* 497 */     return null;
/*     */   }
/*     */   
/*     */   protected static class SegmentTreeData
/*     */   {
/*     */     public final int[] treeData;
/*     */     public final byte[] segmentBytes;
/*     */     public final int[] startIndices;
/*     */     
/*     */     public SegmentTreeData(int[] param1ArrayOfint1, byte[] param1ArrayOfbyte, int[] param1ArrayOfint2) {
/* 507 */       this.treeData = param1ArrayOfint1;
/* 508 */       this.segmentBytes = param1ArrayOfbyte;
/* 509 */       this.startIndices = param1ArrayOfint2;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static SegmentTree build(Iterable<Seg> paramIterable, CharSequence paramCharSequence) {
/* 515 */     SegmentTreeData segmentTreeData = buildTreeData(paramIterable, paramCharSequence, true);
/* 516 */     return new SegmentTree(segmentTreeData.treeData, segmentTreeData.segmentBytes);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SegmentTree build(BasedSegmentBuilder paramBasedSegmentBuilder) {
/* 521 */     SegmentTreeData segmentTreeData = buildTreeData(paramBasedSegmentBuilder.getSegments(), paramBasedSegmentBuilder.getText(), true);
/* 522 */     return new SegmentTree(segmentTreeData.treeData, segmentTreeData.segmentBytes);
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
/*     */   public static SegmentTreeData buildTreeData(Iterable<Seg> paramIterable, CharSequence paramCharSequence, boolean paramBoolean) {
/* 541 */     int i = 0;
/* 542 */     byte b1 = 0;
/* 543 */     int j = 0;
/*     */     
/* 545 */     for (Iterator<Seg> iterator = paramIterable.iterator(); iterator.hasNext(); ) {
/* 546 */       Seg seg; Segment.SegType segType = Segment.getSegType(seg = iterator.next(), paramCharSequence);
/*     */       
/* 548 */       i += Segment.getSegByteLength(segType, seg.getSegStart(), seg.length());
/* 549 */       if (paramBoolean ? (segType != Segment.SegType.ANCHOR) : (segType == Segment.SegType.BASE || segType == Segment.SegType.ANCHOR)) b1++; 
/* 550 */       j = seg.getEnd();
/*     */     } 
/*     */ 
/*     */     
/* 554 */     int[] arrayOfInt2 = new int[b1 << 1];
/* 555 */     byte[] arrayOfByte = new byte[i];
/* 556 */     int[] arrayOfInt3 = paramBoolean ? null : new int[b1];
/* 557 */     int[] arrayOfInt1 = paramBoolean ? null : new int[2];
/* 558 */     b1 = 0;
/*     */     
/* 560 */     int k = -1;
/*     */     
/* 562 */     byte b2 = 0;
/* 563 */     int m = 0;
/* 564 */     int n = 0;
/*     */ 
/*     */     
/* 567 */     for (Seg seg : paramIterable) {
/* 568 */       int i1 = m;
/*     */       
/* 570 */       m = Segment.addSegBytes(arrayOfByte, m, seg, paramCharSequence);
/* 571 */       Segment.SegType segType = Segment.SegType.fromTypeMask(arrayOfByte[i1]);
/*     */ 
/*     */ 
/*     */       
/* 575 */       if (paramBoolean) {
/* 576 */         if (segType == Segment.SegType.ANCHOR) {
/* 577 */           k = i1; continue;
/*     */         } 
/* 579 */         n += seg.length();
/* 580 */         setTreeData(b2, arrayOfInt2, n, i1, (k == -1) ? 0 : (i1 - k));
/* 581 */         b2++;
/* 582 */         k = -1;
/*     */         continue;
/*     */       } 
/* 585 */       arrayOfInt3[b2] = n;
/*     */       
/* 587 */       if (b1 > 0 && seg.getStart() >= 0) {
/*     */         
/* 589 */         b1 = b1;
/* 590 */         for (byte b = 0; b < b1; b++) {
/* 591 */           arrayOfInt2[arrayOfInt1[b] << 1] = seg.getStart();
/*     */         }
/* 593 */         b1 = 0;
/*     */       } 
/*     */       
/* 596 */       n += seg.length();
/*     */       
/* 598 */       if (segType == Segment.SegType.BASE || segType == Segment.SegType.ANCHOR) {
/*     */         
/* 600 */         setTreeData(b2, arrayOfInt2, seg.getEnd(), i1, 0);
/* 601 */         arrayOfInt1[b1++] = b2;
/* 602 */         b2++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 608 */     if (!paramBoolean) {
/* 609 */       for (byte b = 0; b < b1; b++) {
/* 610 */         arrayOfInt2[arrayOfInt1[b] << 1] = j;
/*     */       }
/*     */     }
/*     */     
/* 614 */     return new SegmentTreeData(arrayOfInt2, arrayOfByte, arrayOfInt3);
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
/*     */   public SegmentOffsetTree getSegmentOffsetTree(BasedSequence paramBasedSequence) {
/* 628 */     byte b1 = 0;
/* 629 */     int i = this.segmentBytes.length;
/* 630 */     int j = 0;
/* 631 */     int k = 0;
/*     */     
/* 633 */     while (j < i) {
/* 634 */       Segment segment = Segment.getSegment(this.segmentBytes, j, b1, 0, paramBasedSequence);
/* 635 */       j += segment.getByteLength();
/* 636 */       if (segment.isBase()) {
/* 637 */         b1++;
/* 638 */         k = segment.getEndOffset();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 643 */     int[] arrayOfInt1 = new int[b1 << 1];
/* 644 */     int[] arrayOfInt2 = new int[b1];
/*     */     
/* 646 */     byte b2 = 0;
/* 647 */     j = 0;
/* 648 */     int m = 0;
/* 649 */     int[] arrayOfInt3 = new int[2];
/* 650 */     byte b3 = 0;
/*     */     
/* 652 */     while (j < i) {
/* 653 */       Segment segment = Segment.getSegment(this.segmentBytes, j, b1, m, paramBasedSequence);
/*     */ 
/*     */ 
/*     */       
/* 657 */       if (b3 && segment.getStartOffset() >= 0) {
/*     */         
/* 659 */         b3 = b3;
/* 660 */         for (byte b = 0; b < b3; b++) {
/* 661 */           arrayOfInt1[arrayOfInt3[b] << 1] = segment.getStartOffset();
/*     */         }
/* 663 */         b3 = 0;
/*     */       } 
/*     */       
/* 666 */       if (segment.isBase()) {
/*     */         
/* 668 */         setTreeData(b2, arrayOfInt1, segment.getEndOffset(), j, 0);
/* 669 */         arrayOfInt3[b3++] = b2;
/* 670 */         arrayOfInt2[b2] = m;
/*     */         
/* 672 */         b2++;
/*     */       } 
/*     */       
/* 675 */       j += segment.getByteLength();
/* 676 */       m += segment.length();
/*     */     } 
/*     */ 
/*     */     
/* 680 */     for (byte b4 = 0; b4 < b3; b4++) {
/* 681 */       arrayOfInt1[arrayOfInt3[b4] << 1] = k;
/*     */     }
/*     */     
/* 684 */     return new SegmentOffsetTree(arrayOfInt1, this.segmentBytes, arrayOfInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\tree\SegmentTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */