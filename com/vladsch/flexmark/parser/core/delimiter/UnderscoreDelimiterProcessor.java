/*    */ package com.vladsch.flexmark.parser.core.delimiter;
/*    */ 
/*    */ public class UnderscoreDelimiterProcessor extends EmphasisDelimiterProcessor {
/*    */   public UnderscoreDelimiterProcessor(boolean paramBoolean) {
/*  5 */     super('_', paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 10 */     return (paramBoolean1 && (!paramBoolean2 || paramBoolean3));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 15 */     return (paramBoolean2 && (!paramBoolean1 || paramBoolean4));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\delimiter\UnderscoreDelimiterProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */