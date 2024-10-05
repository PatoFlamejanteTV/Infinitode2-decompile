/*     */ package com.vladsch.flexmark.util.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SegmentOptimizer;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ 
/*     */ public class SpaceInsertingSequenceBuilder implements ISequenceBuilder<SpaceInsertingSequenceBuilder, BasedSequence> {
/*     */   final SequenceBuilder out;
/*     */   Node lastNode;
/*     */   
/*     */   public static SpaceInsertingSequenceBuilder emptyBuilder(BasedSequence paramBasedSequence) {
/*  17 */     return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(paramBasedSequence), false);
/*     */   }
/*     */   boolean needEol; final boolean addSpacesBetweenNodes; boolean addSpaces;
/*     */   
/*     */   public static SpaceInsertingSequenceBuilder emptyBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer) {
/*  22 */     return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(paramBasedSequence, paramSegmentOptimizer), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SpaceInsertingSequenceBuilder emptyBuilder(BasedSequence paramBasedSequence, int paramInt) {
/*  27 */     return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(paramBasedSequence, paramInt), BitFieldSet.any(paramInt, TextContainer.F_ADD_SPACES_BETWEEN_NODES));
/*     */   }
/*     */ 
/*     */   
/*     */   public static SpaceInsertingSequenceBuilder emptyBuilder(BasedSequence paramBasedSequence, int paramInt, SegmentOptimizer paramSegmentOptimizer) {
/*  32 */     return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(paramBasedSequence, paramInt, paramSegmentOptimizer), BitFieldSet.any(paramInt, TextContainer.F_ADD_SPACES_BETWEEN_NODES));
/*     */   }
/*     */ 
/*     */   
/*     */   public static SpaceInsertingSequenceBuilder emptyBuilder(SequenceBuilder paramSequenceBuilder) {
/*  37 */     return new SpaceInsertingSequenceBuilder(paramSequenceBuilder, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SpaceInsertingSequenceBuilder(SequenceBuilder paramSequenceBuilder, boolean paramBoolean) {
/*  47 */     this.out = paramSequenceBuilder;
/*  48 */     this.addSpacesBetweenNodes = paramBoolean;
/*     */   }
/*     */   
/*     */   public SequenceBuilder getOut() {
/*  52 */     return this.out;
/*     */   }
/*     */ 
/*     */   
/*     */   public char charAt(int paramInt) {
/*  57 */     return this.out.charAt(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isNeedEol() {
/*  61 */     return this.needEol;
/*     */   }
/*     */   
/*     */   public void setNeedEol(boolean paramBoolean) {
/*  65 */     this.needEol = paramBoolean;
/*     */   }
/*     */   
/*     */   public Node getLastNode() {
/*  69 */     return this.lastNode;
/*     */   }
/*     */   
/*     */   public void setLastNode(Node paramNode) {
/*  73 */     if (paramNode instanceof Document)
/*     */       return; 
/*  75 */     if (this.lastNode != null && this.lastNode.getEndOffset() < paramNode.getStartOffset()) {
/*  76 */       BasedSequence basedSequence = getBaseSequence().subSequence(this.lastNode.getEndOffset(), paramNode.getStartOffset());
/*  77 */       this.needEol = (((BasedSequence)basedSequence.trim(CharPredicate.SPACE_TAB)).length() > 0 && ((BasedSequence)basedSequence.trim(CharPredicate.WHITESPACE)).isEmpty());
/*     */     } 
/*     */     
/*  80 */     this.addSpaces = this.addSpacesBetweenNodes;
/*  81 */     this.lastNode = paramNode;
/*     */   }
/*     */   
/*     */   public boolean needSpace() {
/*  85 */     int i = this.out.getSegmentBuilder().size();
/*  86 */     while (i >= 0) {
/*     */       Object object;
/*  88 */       if (object = this.out.getSegmentBuilder().getPart(i) instanceof Range) {
/*  89 */         if (((Range)object).isNotNull() && (
/*     */           
/*  91 */           object = getBaseSequence().subSequence(((Range)object).getStart(), ((Range)object).getEnd())).length() > 0) {
/*  92 */           return !CharPredicate.WHITESPACE.test(object.charAt(object.length() - 1));
/*     */         }
/*     */       }
/*  95 */       else if (object instanceof CharSequence) {
/*     */         
/*  97 */         if ((object = object).length() > 0) {
/*  98 */           return !CharPredicate.WHITESPACE.test(object.charAt(object.length() - 1));
/*     */         }
/*     */       } else {
/* 101 */         throw new IllegalStateException("Invalid part type " + object.getClass().getSimpleName());
/*     */       } 
/*     */       
/* 104 */       i--;
/*     */     } 
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public void appendEol() {
/* 110 */     append('\n');
/* 111 */     this.needEol = false;
/*     */   }
/*     */   
/*     */   public boolean needEol() {
/* 115 */     if (this.needEol) return true;
/*     */     
/* 117 */     int i = this.out.getSegmentBuilder().size();
/* 118 */     while (i >= 0) {
/*     */       Object object;
/* 120 */       if (object = this.out.getSegmentBuilder().getPart(i) instanceof Range) {
/* 121 */         if (((Range)object).isNotNull() && (
/*     */           
/* 123 */           object = getBaseSequence().subSequence(((Range)object).getStart(), ((Range)object).getEnd())).length() > 0) {
/* 124 */           return !CharPredicate.EOL.test(object.charAt(object.length() - 1));
/*     */         }
/*     */       }
/* 127 */       else if (object instanceof CharSequence) {
/*     */         
/* 129 */         if ((object = object).length() > 0) {
/* 130 */           return !CharPredicate.EOL.test(object.charAt(object.length() - 1));
/*     */         }
/*     */       } else {
/* 133 */         throw new IllegalStateException("Invalid part type " + object.getClass().getSimpleName());
/*     */       } 
/*     */       
/* 136 */       i--;
/*     */     } 
/* 138 */     return false;
/*     */   }
/*     */   
/*     */   public BasedSequence getBaseSequence() {
/* 142 */     return this.out.getBaseSequence();
/*     */   }
/*     */   public BasedSegmentBuilder getSegmentBuilder() {
/* 145 */     return this.out.getSegmentBuilder();
/*     */   }
/*     */   
/*     */   public BasedSequence getSingleBasedSequence() {
/* 149 */     return this.out.getSingleBasedSequence();
/*     */   }
/*     */   
/*     */   public SpaceInsertingSequenceBuilder getBuilder() {
/* 153 */     return new SpaceInsertingSequenceBuilder(this.out.getBuilder(), this.addSpacesBetweenNodes);
/*     */   }
/*     */ 
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 158 */     if (this.addSpaces && paramCharSequence != null && paramInt1 < paramInt2 && !CharPredicate.WHITESPACE.test(paramCharSequence.charAt(paramInt1)) && needSpace()) {
/* 159 */       this.out.append(' ');
/* 160 */       this.addSpaces = false;
/*     */     } 
/* 162 */     this.out.append(paramCharSequence, paramInt1, paramInt2);
/* 163 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(char paramChar) {
/* 169 */     if (this.addSpaces && !CharPredicate.WHITESPACE.test(paramChar) && needSpace()) {
/* 170 */       this.out.append(' ');
/* 171 */       this.addSpaces = false;
/*     */     } 
/* 173 */     this.out.append(paramChar);
/* 174 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(char paramChar, int paramInt) {
/* 180 */     if (this.addSpaces && !CharPredicate.WHITESPACE.test(paramChar) && needSpace()) {
/* 181 */       this.out.append(' ');
/* 182 */       this.addSpaces = false;
/*     */     } 
/* 184 */     this.out.append(paramChar, paramInt);
/* 185 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(int paramInt1, int paramInt2) {
/* 190 */     if (this.addSpaces && paramInt1 < paramInt2 && !CharPredicate.WHITESPACE.test(this.out.getBaseSequence().charAt(paramInt1)) && needSpace()) {
/* 191 */       this.out.append(' ');
/* 192 */       this.addSpaces = false;
/*     */     } 
/* 194 */     this.out.append(paramInt1, paramInt2);
/* 195 */     return this;
/*     */   }
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(Range paramRange) {
/* 199 */     return append(paramRange.getStart(), paramRange.getEnd());
/*     */   }
/*     */   public SpaceInsertingSequenceBuilder addRange(Range paramRange) {
/* 202 */     return append(paramRange.getStart(), paramRange.getEnd());
/*     */   }
/*     */   public SpaceInsertingSequenceBuilder addByOffsets(int paramInt1, int paramInt2) {
/* 205 */     return append(paramInt1, paramInt2);
/*     */   }
/*     */   public SpaceInsertingSequenceBuilder addByLength(int paramInt1, int paramInt2) {
/* 208 */     return append(paramInt1, paramInt1 + paramInt2);
/*     */   }
/*     */   
/*     */   public BasedSequence toSequence() {
/* 212 */     return this.out.toSequence();
/*     */   }
/*     */   public int length() {
/* 215 */     return this.out.length();
/*     */   }
/*     */   public String toStringWithRanges() {
/* 218 */     return this.out.toStringWithRanges();
/*     */   }
/*     */   public String toString() {
/* 221 */     return this.out.toString();
/*     */   } public String toStringNoAddedSpaces() {
/* 223 */     return this.out.toStringNoAddedSpaces();
/*     */   }
/*     */ 
/*     */   
/*     */   public SpaceInsertingSequenceBuilder addAll(Iterable<? extends CharSequence> paramIterable) {
/* 228 */     return append(paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(Iterable<? extends CharSequence> paramIterable) {
/* 234 */     for (CharSequence charSequence : paramIterable) {
/* 235 */       append(charSequence);
/*     */     }
/* 237 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpaceInsertingSequenceBuilder add(CharSequence paramCharSequence) {
/* 242 */     return append(paramCharSequence);
/*     */   }
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(CharSequence paramCharSequence) {
/* 246 */     return (paramCharSequence == null) ? this : append(paramCharSequence, 0, paramCharSequence.length());
/*     */   }
/*     */   
/*     */   public SpaceInsertingSequenceBuilder append(CharSequence paramCharSequence, int paramInt) {
/* 250 */     return (paramCharSequence == null) ? this : append(paramCharSequence, paramInt, paramCharSequence.length());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\SpaceInsertingSequenceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */