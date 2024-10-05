/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class NodeVisitorBase
/*    */ {
/*    */   protected abstract void visit(Node paramNode);
/*    */   
/*    */   public void visitChildren(Node paramNode) {
/* 15 */     paramNode = paramNode.getFirstChild();
/* 16 */     while (paramNode != null) {
/*    */ 
/*    */       
/* 19 */       Node node = paramNode.getNext();
/* 20 */       visit(paramNode);
/* 21 */       paramNode = node;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeVisitorBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */