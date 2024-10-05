/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.html.renderer.LinkResolverContext;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.html.Attributes;
/*    */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmbeddedAttributeProvider
/*    */   implements AttributeProvider
/*    */ {
/* 16 */   public static final IndependentAttributeProviderFactory Factory = new IndependentAttributeProviderFactory()
/*    */     {
/*    */       public final AttributeProvider apply(LinkResolverContext param1LinkResolverContext)
/*    */       {
/* 20 */         return new EmbeddedAttributeProvider();
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAttributes(Node paramNode, AttributablePart paramAttributablePart, MutableAttributes paramMutableAttributes) {
/* 29 */     if (paramAttributablePart == AttributablePart.NODE && 
/*    */       
/* 31 */       paramNode = paramNode.getChildOfType(new Class[] { EmbeddedNodeAttributes.class }) instanceof EmbeddedNodeAttributes) {
/* 32 */       paramMutableAttributes.addValues(((EmbeddedNodeAttributes)paramNode).attributes);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class EmbeddedNodeAttributes
/*    */     extends Node
/*    */   {
/*    */     final Attributes attributes;
/*    */     
/*    */     public EmbeddedNodeAttributes(Node param1Node, Attributes param1Attributes) {
/* 42 */       super(param1Node.getChars().subSequence(0, 0));
/* 43 */       this.attributes = param1Attributes;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public BasedSequence[] getSegments() {
/* 49 */       return Node.EMPTY_SEGMENTS;
/*    */     }
/*    */ 
/*    */     
/*    */     public void astString(StringBuilder param1StringBuilder, boolean param1Boolean) {
/* 54 */       param1StringBuilder.append(EmbeddedNodeAttributes.class.getSimpleName());
/* 55 */       param1StringBuilder.append("[").append(getStartOffset()).append(", ").append(getEndOffset()).append("]");
/* 56 */       param1StringBuilder.append(", attributes: ").append(this.attributes.toString());
/*    */       
/* 58 */       if (param1Boolean) getAstExtra(param1StringBuilder); 
/*    */     }
/*    */     
/*    */     public void astExtraChars(StringBuilder param1StringBuilder) {}
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\EmbeddedAttributeProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */