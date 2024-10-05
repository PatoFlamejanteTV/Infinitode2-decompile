/*    */ package com.vladsch.flexmark.ext.xwiki.macros;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class MacroAttribute
/*    */   extends Node
/*    */   implements DoNotDecorate
/*    */ {
/* 12 */   protected BasedSequence attribute = BasedSequence.NULL;
/* 13 */   protected BasedSequence separator = BasedSequence.NULL;
/* 14 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 15 */   protected BasedSequence value = BasedSequence.NULL;
/* 16 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 22 */     return new BasedSequence[] { this.attribute, this.separator, this.openingMarker, this.value, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 27 */     segmentSpanChars(paramStringBuilder, this.attribute, "attribute");
/* 28 */     segmentSpanChars(paramStringBuilder, this.separator, "separator");
/* 29 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.value, this.closingMarker, "value");
/*    */   }
/*    */ 
/*    */   
/*    */   public MacroAttribute() {}
/*    */   
/*    */   public MacroAttribute(BasedSequence paramBasedSequence) {
/* 36 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public MacroAttribute(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5) {
/* 40 */     super(spanningChars(new BasedSequence[] { paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5 }));
/* 41 */     this.attribute = paramBasedSequence1;
/* 42 */     this.separator = paramBasedSequence2;
/* 43 */     this.openingMarker = paramBasedSequence3;
/* 44 */     this.value = paramBasedSequence4;
/* 45 */     this.closingMarker = paramBasedSequence5;
/*    */   }
/*    */   
/*    */   public BasedSequence getAttribute() {
/* 49 */     return this.attribute;
/*    */   }
/*    */   
/*    */   public void setAttribute(BasedSequence paramBasedSequence) {
/* 53 */     this.attribute = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getSeparator() {
/* 57 */     return this.separator;
/*    */   }
/*    */   
/*    */   public void setSeparator(BasedSequence paramBasedSequence) {
/* 61 */     this.separator = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 65 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 69 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getValue() {
/* 73 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(BasedSequence paramBasedSequence) {
/* 77 */     this.value = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 81 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 85 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\MacroAttribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */