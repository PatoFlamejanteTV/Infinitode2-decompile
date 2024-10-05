/*    */ package com.vladsch.flexmark.ext.definition;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.ListItem;
/*    */ import com.vladsch.flexmark.ast.Paragraph;
/*    */ import com.vladsch.flexmark.parser.ListOptions;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefinitionTerm
/*    */   extends ListItem
/*    */ {
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {}
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 23 */     return Node.EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public DefinitionTerm() {}
/*    */   
/*    */   public DefinitionTerm(BasedSequence paramBasedSequence) {
/* 30 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public DefinitionTerm(Node paramNode) {
/* 35 */     appendChild(paramNode);
/* 36 */     setCharsFromContent();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isParagraphWrappingDisabled(Paragraph paramParagraph, ListOptions paramListOptions, DataHolder paramDataHolder) {
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\DefinitionTerm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */