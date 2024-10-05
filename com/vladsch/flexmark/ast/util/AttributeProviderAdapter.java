/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*    */ import com.vladsch.flexmark.util.visitor.AstActionHandler;
/*    */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class AttributeProviderAdapter
/*    */   extends AstActionHandler<AttributeProviderAdapter, Node, AttributeProvidingHandler.AttributeProvidingVisitor<Node>, AttributeProvidingHandler<Node>>
/*    */   implements AttributeProvidingHandler.AttributeProvidingVisitor<Node> {
/* 13 */   protected static final AttributeProvidingHandler[] EMPTY_HANDLERS = new AttributeProvidingHandler[0];
/*    */   
/*    */   public AttributeProviderAdapter(AttributeProvidingHandler... paramVarArgs) {
/* 16 */     super(Node.AST_ADAPTER);
/* 17 */     addActionHandlers((AstHandler[][])new AttributeProvidingHandler[][] { paramVarArgs });
/*    */   }
/*    */   
/*    */   public AttributeProviderAdapter(AttributeProvidingHandler[]... paramVarArgs) {
/* 21 */     super(Node.AST_ADAPTER);
/*    */     
/* 23 */     addActionHandlers((AstHandler[][])paramVarArgs);
/*    */   }
/*    */   
/*    */   public AttributeProviderAdapter(Collection<AttributeProvidingHandler> paramCollection) {
/* 27 */     super(Node.AST_ADAPTER);
/* 28 */     addHandlers(paramCollection);
/*    */   }
/*    */   
/*    */   public AttributeProviderAdapter addHandlers(Collection<AttributeProvidingHandler> paramCollection) {
/* 32 */     return addHandlers(paramCollection.<AttributeProvidingHandler>toArray(EMPTY_HANDLERS));
/*    */   }
/*    */ 
/*    */   
/*    */   public AttributeProviderAdapter addHandlers(AttributeProvidingHandler... paramVarArgs) {
/* 37 */     return (AttributeProviderAdapter)addActionHandlers((AstHandler[][])new AttributeProvidingHandler[][] { paramVarArgs });
/*    */   }
/*    */ 
/*    */   
/*    */   public AttributeProviderAdapter addHandlers(AttributeProvidingHandler[]... paramVarArgs) {
/* 42 */     return (AttributeProviderAdapter)addActionHandlers((AstHandler[][])paramVarArgs);
/*    */   }
/*    */ 
/*    */   
/*    */   public AttributeProviderAdapter addHandler(AttributeProvidingHandler paramAttributeProvidingHandler) {
/* 47 */     return (AttributeProviderAdapter)addActionHandler(paramAttributeProvidingHandler);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAttributes(Node paramNode, AttributablePart paramAttributablePart, MutableAttributes paramMutableAttributes) {
/* 52 */     processNode(paramNode, false, (paramNode, paramAttributeProvidingVisitor) -> paramAttributeProvidingVisitor.setAttributes(paramNode, paramAttributablePart, paramMutableAttributes));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\AttributeProviderAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */