/*    */ package com.vladsch.flexmark.parser.block;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.PostProcessor;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class NodePostProcessor
/*    */   implements PostProcessor
/*    */ {
/*    */   public final Document processDocument(Document paramDocument) {
/* 15 */     return paramDocument;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\NodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */