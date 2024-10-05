/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
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
/*    */ public interface IRender
/*    */ {
/*    */   void render(Node paramNode, Appendable paramAppendable);
/*    */   
/*    */   default String render(Node paramNode) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder();
/* 24 */     render(paramNode, stringBuilder);
/* 25 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   DataHolder getOptions();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\IRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */