/*    */ package com.vladsch.flexmark.util.sequence.builder;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.Range;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public interface ISegmentBuilder<S extends ISegmentBuilder<S>>
/*    */   extends Iterable<Object>
/*    */ {
/*    */   public enum Options
/*    */   {
/* 12 */     INCLUDE_ANCHORS,
/* 13 */     TRACK_FIRST256;
/*    */   }
/*    */   
/* 16 */   public static final Options O_INCLUDE_ANCHORS = Options.INCLUDE_ANCHORS;
/* 17 */   public static final Options O_TRACK_FIRST256 = Options.TRACK_FIRST256;
/*    */   
/* 19 */   public static final int F_INCLUDE_ANCHORS = BitFieldSet.intMask(O_INCLUDE_ANCHORS);
/* 20 */   public static final int F_TRACK_FIRST256 = BitFieldSet.intMask(O_TRACK_FIRST256);
/*    */   
/* 22 */   public static final int F_DEFAULT = F_INCLUDE_ANCHORS | F_TRACK_FIRST256;
/*    */   
/*    */   int getOptions();
/*    */   
/*    */   boolean isIncludeAnchors();
/*    */   
/*    */   boolean isEmpty();
/*    */   
/*    */   boolean isBaseSubSequenceRange();
/*    */   
/*    */   Range getBaseSubSequenceRange();
/*    */   
/*    */   boolean haveOffsets();
/*    */   
/*    */   int getSpan();
/*    */   
/*    */   int getStartOffset();
/*    */   
/*    */   int getEndOffset();
/*    */   
/*    */   int size();
/*    */   
/*    */   CharSequence getText();
/*    */   
/*    */   int noAnchorsSize();
/*    */   
/*    */   int length();
/*    */   
/*    */   boolean isTrackTextFirst256();
/*    */   
/*    */   int getTextLength();
/*    */   
/*    */   int getTextSegments();
/*    */   
/*    */   int getTextSpaceLength();
/*    */   
/*    */   int getTextSpaceSegments();
/*    */   
/*    */   int getTextFirst256Length();
/*    */   
/*    */   int getTextFirst256Segments();
/*    */   
/*    */   Iterator<Object> iterator();
/*    */   
/*    */   Iterable<Seg> getSegments();
/*    */   
/*    */   S append(int paramInt1, int paramInt2);
/*    */   
/*    */   S append(CharSequence paramCharSequence);
/*    */   
/*    */   S appendAnchor(int paramInt);
/*    */   
/*    */   S append(Range paramRange);
/*    */   
/*    */   String toStringWithRangesVisibleWhitespace(CharSequence paramCharSequence);
/*    */   
/*    */   String toStringWithRanges(CharSequence paramCharSequence);
/*    */   
/*    */   String toString(CharSequence paramCharSequence);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\ISegmentBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */