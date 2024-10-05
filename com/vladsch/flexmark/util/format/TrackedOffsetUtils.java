/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*    */ import com.vladsch.flexmark.util.sequence.LineInfo;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*    */ import com.vladsch.flexmark.util.sequence.builder.tree.BasedOffsetTracker;
/*    */ import com.vladsch.flexmark.util.sequence.builder.tree.OffsetInfo;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TrackedOffsetUtils
/*    */ {
/*    */   public static void resolveTrackedOffsets(BasedSequence paramBasedSequence, LineAppendable paramLineAppendable, List<TrackedOffset> paramList, int paramInt, boolean paramBoolean) {
/* 27 */     if (!paramList.isEmpty()) {
/*    */ 
/*    */ 
/*    */       
/* 31 */       int i = (paramList = TrackedOffsetList.create(paramBasedSequence, paramList)).size();
/* 32 */       int j = 0;
/*    */       ISequenceBuilder iSequenceBuilder;
/* 34 */       paramBasedSequence = (iSequenceBuilder = paramLineAppendable.getBuilder() instanceof SequenceBuilder) ? ((SequenceBuilder)iSequenceBuilder).getBaseSequence() : paramBasedSequence.getBaseSequence();
/*    */       
/* 36 */       for (Iterator<LineInfo> iterator = paramLineAppendable.getLinesInfo(paramInt, 0, paramLineAppendable.getLineCount()).iterator(); iterator.hasNext(); ) {
/* 37 */         LineInfo lineInfo; BasedSequence basedSequence = (lineInfo = iterator.next()).getLine();
/*    */         
/*    */         TrackedOffsetList trackedOffsetList;
/* 40 */         if (!(trackedOffsetList = paramList.getTrackedOffsets(basedSequence.getStartOffset(), basedSequence.getEndOffset())).isEmpty()) {
/* 41 */           for (TrackedOffset trackedOffset : trackedOffsetList) {
/* 42 */             BasedOffsetTracker basedOffsetTracker = BasedOffsetTracker.create(basedSequence);
/*    */             
/* 44 */             if (!trackedOffset.isResolved()) {
/* 45 */               OffsetInfo offsetInfo; int k = trackedOffset.getOffset();
/*    */               
/*    */               boolean bool;
/* 48 */               if ((bool = paramBasedSequence.isCharAt(k, CharPredicate.WHITESPACE)) && !paramBasedSequence.isCharAt(k - 1, CharPredicate.WHITESPACE)) {
/*    */                 
/* 50 */                 offsetInfo = basedOffsetTracker.getOffsetInfo(k - 1, false);
/* 51 */                 trackedOffset.setIndex(offsetInfo.endIndex + j);
/* 52 */               } else if (!bool && paramBasedSequence.isCharAt(k + 1, CharPredicate.WHITESPACE)) {
/*    */                 
/* 54 */                 offsetInfo = offsetInfo.getOffsetInfo(k, false);
/* 55 */                 trackedOffset.setIndex(offsetInfo.startIndex + j);
/*    */               } else {
/* 57 */                 offsetInfo = offsetInfo.getOffsetInfo(k, true);
/* 58 */                 trackedOffset.setIndex(offsetInfo.endIndex + j);
/*    */               } 
/* 60 */               if (paramBoolean) {
/* 61 */                 System.out.println(String.format("Resolved %d to %d, start: %d, in line[%d]: '%s'", new Object[] { Integer.valueOf(k), Integer.valueOf(trackedOffset.getIndex()), Integer.valueOf(j), Integer.valueOf(lineInfo.index), ((SequenceBuilder)basedSequence.getBuilder().append((CharSequence)basedSequence)).toStringWithRanges(true) }));
/*    */               }
/* 63 */               i--;
/*    */             } 
/*    */           } 
/*    */         }
/*    */         
/* 68 */         j += basedSequence.length();
/* 69 */         if (i > 0);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TrackedOffsetUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */