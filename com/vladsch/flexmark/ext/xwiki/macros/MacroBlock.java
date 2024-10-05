/*    */ package com.vladsch.flexmark.ext.xwiki.macros;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MacroBlock
/*    */   extends Block
/*    */ {
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 18 */     if (isClosedTag()) paramStringBuilder.append(" isClosed"); 
/* 19 */     segmentSpanChars(paramStringBuilder, getMacroContentChars(), "macroContent");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 25 */     return Node.EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public MacroBlock() {}
/*    */   
/*    */   public MacroBlock(BasedSequence paramBasedSequence) {
/* 32 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public MacroBlock(Node paramNode) {
/* 37 */     appendChild(paramNode);
/* 38 */     setCharsFromContent();
/*    */   }
/*    */   
/*    */   public Map<String, String> getAttributes() {
/* 42 */     return getMacroNode().getAttributes();
/*    */   }
/*    */   
/*    */   public Macro getMacroNode() {
/* 46 */     Node node = getFirstChild();
/* 47 */     assert node instanceof Macro;
/* 48 */     return (Macro)node;
/*    */   }
/*    */   
/*    */   public boolean isClosedTag() {
/* 52 */     return getMacroNode().isClosedTag();
/*    */   }
/*    */   
/*    */   public BasedSequence getMacroContentChars() {
/* 56 */     Node node1 = getFirstChild();
/* 57 */     Node node2 = getLastChild();
/* 58 */     Node node3 = node1.getNext();
/* 59 */     node2 = (node2 instanceof MacroClose) ? node2.getPrevious() : node2;
/*    */ 
/*    */     
/*    */     BasedSequence basedSequence;
/*    */ 
/*    */     
/* 65 */     return basedSequence = Node.spanningChars(new BasedSequence[] { (node3 == null || node3 instanceof MacroClose) ? BasedSequence.NULL : node3.getChars(), (node2 == null || node2 == node1) ? BasedSequence.NULL : node2.getChars() });
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\MacroBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */