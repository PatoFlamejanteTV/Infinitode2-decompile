/*    */ package com.vladsch.flexmark.parser.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*    */ import java.util.List;
/*    */ 
/*    */ public class LinkRefProcessorData
/*    */ {
/*    */   public final List<LinkRefProcessorFactory> processors;
/*    */   public final int maxNesting;
/*    */   public final int[] nestingIndex;
/*    */   
/*    */   public LinkRefProcessorData(List<LinkRefProcessorFactory> paramList, int paramInt, int[] paramArrayOfint) {
/* 13 */     this.processors = paramList;
/* 14 */     this.maxNesting = paramInt;
/* 15 */     this.nestingIndex = paramArrayOfint;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\LinkRefProcessorData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */