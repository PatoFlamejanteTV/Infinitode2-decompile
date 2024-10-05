/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.AnchorRefTarget;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitorBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AnchorRefTargetBlockVisitor
/*    */   extends NodeVisitorBase
/*    */ {
/*    */   protected abstract void visit(AnchorRefTarget paramAnchorRefTarget);
/*    */   
/*    */   protected boolean preVisit(Node paramNode) {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public void visit(Node paramNode) {
/* 23 */     if (paramNode instanceof AnchorRefTarget) visit((AnchorRefTarget)paramNode);
/*    */     
/* 25 */     if (preVisit(paramNode) && paramNode instanceof com.vladsch.flexmark.util.ast.Block)
/* 26 */       visitChildren(paramNode); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\AnchorRefTargetBlockVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */