/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ 
/*    */ public abstract class AllNodesVisitor
/*    */ {
/*    */   protected abstract void process(Node paramNode);
/*    */   
/*    */   public void visit(Node paramNode) {
/*  9 */     visitChildren(paramNode);
/*    */   }
/*    */   
/*    */   private void visitChildren(Node paramNode) {
/* 13 */     paramNode = paramNode.getFirstChild();
/* 14 */     while (paramNode != null) {
/*    */ 
/*    */       
/* 17 */       Node node = paramNode.getNext();
/* 18 */       process(paramNode);
/* 19 */       visit(paramNode);
/* 20 */       paramNode = node;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\AllNodesVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */