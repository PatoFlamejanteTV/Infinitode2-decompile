/*    */ package com.vladsch.flexmark.ext.yaml.front.matter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class YamlFrontMatterNode
/*    */   extends Node
/*    */ {
/*    */   private BasedSequence key;
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 17 */     return new BasedSequence[] { this.key };
/*    */   }
/*    */   
/*    */   public YamlFrontMatterNode(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 21 */     this.key = paramBasedSequence;
/*    */     
/* 23 */     for (BasedSequence basedSequence : paramList) {
/* 24 */       appendChild(new YamlFrontMatterValue(basedSequence));
/*    */     }
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 29 */     return this.key.toString();
/*    */   }
/*    */   
/*    */   public BasedSequence getKeySequence() {
/* 33 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setKey(BasedSequence paramBasedSequence) {
/* 37 */     this.key = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public List<String> getValues() {
/* 41 */     ArrayList<String> arrayList = new ArrayList();
/* 42 */     Node node = getFirstChild();
/* 43 */     while (node != null) {
/* 44 */       arrayList.add(node.getChars().toString());
/* 45 */       node = node.getNext();
/*    */     } 
/* 47 */     return arrayList;
/*    */   }
/*    */   
/*    */   public List<BasedSequence> getValuesSequences() {
/* 51 */     ArrayList<BasedSequence> arrayList = new ArrayList();
/* 52 */     Node node = getFirstChild();
/* 53 */     while (node != null) {
/* 54 */       arrayList.add(node.getChars());
/* 55 */       node = node.getNext();
/*    */     } 
/* 57 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\yaml\front\matter\YamlFrontMatterNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */