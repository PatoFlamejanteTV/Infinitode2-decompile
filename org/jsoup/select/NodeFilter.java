/*    */ package org.jsoup.select;
/*    */ 
/*    */ import org.jsoup.nodes.Node;
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
/*    */ public interface NodeFilter
/*    */ {
/*    */   FilterResult head(Node paramNode, int paramInt);
/*    */   
/*    */   public enum FilterResult
/*    */   {
/* 32 */     CONTINUE,
/*    */     
/* 34 */     SKIP_CHILDREN,
/*    */     
/* 36 */     SKIP_ENTIRELY,
/*    */     
/* 38 */     REMOVE,
/*    */     
/* 40 */     STOP;
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FilterResult tail(Node paramNode, int paramInt) {
/* 59 */     return FilterResult.CONTINUE;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\NodeFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */