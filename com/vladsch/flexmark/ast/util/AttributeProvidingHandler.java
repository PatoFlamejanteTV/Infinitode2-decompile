/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*    */ import com.vladsch.flexmark.util.visitor.AstAction;
/*    */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*    */ 
/*    */ public class AttributeProvidingHandler<N extends Node> extends AstHandler<N, AttributeProvidingHandler.AttributeProvidingVisitor<N>> {
/*    */   public AttributeProvidingHandler(Class<N> paramClass, AttributeProvidingVisitor<N> paramAttributeProvidingVisitor) {
/* 11 */     super(paramClass, paramAttributeProvidingVisitor);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAttributes(Node paramNode, AttributablePart paramAttributablePart, MutableAttributes paramMutableAttributes) {
/* 16 */     ((AttributeProvidingVisitor<Node>)getAdapter()).setAttributes(paramNode, paramAttributablePart, paramMutableAttributes);
/*    */   }
/*    */   
/*    */   public static interface AttributeProvidingVisitor<N extends Node> extends AstAction<N> {
/*    */     void setAttributes(N param1N, AttributablePart param1AttributablePart, MutableAttributes param1MutableAttributes);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\AttributeProvidingHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */