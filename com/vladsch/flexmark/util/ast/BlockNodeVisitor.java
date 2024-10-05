/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.function.BiConsumer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockNodeVisitor
/*    */   extends NodeVisitor
/*    */ {
/*    */   public BlockNodeVisitor() {}
/*    */   
/*    */   public BlockNodeVisitor(VisitHandler... paramVarArgs) {
/* 20 */     super(paramVarArgs);
/*    */   }
/*    */   
/*    */   public BlockNodeVisitor(VisitHandler[]... paramVarArgs) {
/* 24 */     super(paramVarArgs);
/*    */   }
/*    */   
/*    */   public BlockNodeVisitor(Collection<VisitHandler> paramCollection) {
/* 28 */     super(paramCollection);
/*    */   }
/*    */ 
/*    */   
/*    */   public void processNode(Node paramNode, boolean paramBoolean, BiConsumer<Node, Visitor<Node>> paramBiConsumer) {
/* 33 */     if (paramNode instanceof Block)
/* 34 */       super.processNode(paramNode, paramBoolean, paramBiConsumer); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\BlockNodeVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */