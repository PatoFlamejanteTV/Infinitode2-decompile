/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*    */ 
/*    */ 
/*    */ public class VisitHandler<N extends Node>
/*    */   extends AstHandler<N, Visitor<N>>
/*    */   implements Visitor<Node>
/*    */ {
/*    */   public VisitHandler(Class<N> paramClass, Visitor<N> paramVisitor) {
/* 11 */     super(paramClass, paramVisitor);
/*    */   }
/*    */ 
/*    */   
/*    */   public void visit(Node paramNode) {
/* 16 */     ((Visitor<Node>)getAdapter()).visit(paramNode);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\VisitHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */