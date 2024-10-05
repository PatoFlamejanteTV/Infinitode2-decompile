/*    */ package com.vladsch.flexmark.ext.yaml.front.matter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class YamlFrontMatterValue
/*    */   extends Node
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 11 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public YamlFrontMatterValue() {}
/*    */   
/*    */   public YamlFrontMatterValue(BasedSequence paramBasedSequence) {
/* 18 */     super(paramBasedSequence);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\yaml\front\matter\YamlFrontMatterValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */