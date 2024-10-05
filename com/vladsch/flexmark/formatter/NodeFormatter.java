/*    */ package com.vladsch.flexmark.formatter;
/*    */ 
/*    */ import java.util.Set;
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
/*    */ public interface NodeFormatter
/*    */ {
/*    */   Set<NodeFormattingHandler<?>> getNodeFormattingHandlers();
/*    */   
/*    */   Set<Class<?>> getNodeClasses();
/*    */   
/*    */   default char getBlockQuoteLikePrefixChar() {
/* 31 */     return Character.MIN_VALUE;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\NodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */