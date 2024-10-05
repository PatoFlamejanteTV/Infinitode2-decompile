/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface BasedUtils
/*    */ {
/*    */   static {
/*    */   
/*    */   }
/*    */   
/*    */   static void generateSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder, BasedSequence paramBasedSequence) {
/* 15 */     int i = -1;
/* 16 */     int j = -1;
/* 17 */     boolean bool = false;
/*    */     
/* 19 */     StringBuilder stringBuilder = null;
/*    */     
/* 21 */     int k = paramBasedSequence.length();
/* 22 */     for (byte b = 0; b < k; b++) {
/*    */       int m;
/*    */       
/* 25 */       if ((m = paramBasedSequence.getIndexOffset(b)) >= 0) {
/* 26 */         if (i == -1) {
/* 27 */           if (stringBuilder != null) {
/* 28 */             if (!bool) {
/* 29 */               paramIBasedSegmentBuilder.appendAnchor(paramBasedSequence.getStartOffset());
/* 30 */               bool = true;
/*    */             } 
/* 32 */             paramIBasedSegmentBuilder.append(stringBuilder.toString());
/* 33 */             stringBuilder = null;
/*    */           } 
/*    */           
/* 36 */           i = m;
/*    */         }
/* 38 */         else if (m > j + 1) {
/*    */           
/* 40 */           paramIBasedSegmentBuilder.append(i, j + 1);
/* 41 */           i = m;
/*    */         } 
/*    */ 
/*    */         
/* 45 */         j = m;
/*    */       } else {
/* 47 */         if (i != -1) {
/* 48 */           paramIBasedSegmentBuilder.append(i, j + 1);
/* 49 */           j = i = -1;
/* 50 */           bool = true;
/*    */         } 
/*    */         
/* 53 */         if (stringBuilder == null) stringBuilder = new StringBuilder(); 
/* 54 */         stringBuilder.append(paramBasedSequence.charAt(b));
/*    */       } 
/*    */     } 
/*    */     
/* 58 */     if (i != -1) {
/* 59 */       paramIBasedSegmentBuilder.append(i, j + 1);
/* 60 */       bool = true;
/*    */     } 
/*    */     
/* 63 */     if (stringBuilder != null) {
/* 64 */       if (!bool) {
/* 65 */         paramIBasedSegmentBuilder.appendAnchor(paramBasedSequence.getStartOffset());
/* 66 */         bool = true;
/*    */       } 
/* 68 */       paramIBasedSegmentBuilder.append(stringBuilder.toString());
/* 69 */       paramIBasedSegmentBuilder.appendAnchor(paramBasedSequence.getEndOffset());
/*    */     } 
/*    */     
/* 72 */     if (!bool) {
/* 73 */       if (!null.$assertionsDisabled && paramBasedSequence.length() != 0) throw new AssertionError(); 
/* 74 */       paramIBasedSegmentBuilder.appendAnchor(paramBasedSequence.getStartOffset());
/*    */     } 
/*    */   }
/*    */   static BasedSequence asBased(CharSequence paramCharSequence) {
/* 78 */     return BasedSequence.of(paramCharSequence);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\BasedUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */