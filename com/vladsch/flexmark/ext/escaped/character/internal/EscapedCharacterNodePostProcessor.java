/*    */ package com.vladsch.flexmark.ext.escaped.character.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Text;
/*    */ import com.vladsch.flexmark.ast.TextBase;
/*    */ import com.vladsch.flexmark.ext.escaped.character.EscapedCharacter;
/*    */ import com.vladsch.flexmark.parser.PostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.Escaping;
/*    */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*    */ import com.vladsch.flexmark.util.sequence.ReplacedTextRegion;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class EscapedCharacterNodePostProcessor
/*    */   extends NodePostProcessor
/*    */ {
/*    */   public EscapedCharacterNodePostProcessor(Document paramDocument) {}
/*    */   
/*    */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/* 26 */     BasedSequence basedSequence = paramNode.getChars();
/* 27 */     ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(basedSequence);
/*    */     
/* 29 */     Escaping.unescape(basedSequence, replacedTextMapper);
/*    */     
/* 31 */     int i = 0;
/*    */     boolean bool;
/* 33 */     TextBase textBase = (bool = !(paramNode.getParent() instanceof TextBase) ? true : false) ? null : (TextBase)paramNode.getParent();
/*    */     
/*    */     ArrayList<?> arrayList;
/*    */     
/* 37 */     for (Iterator<?> iterator = (arrayList = replacedTextMapper.getRegions()).iterator(); iterator.hasNext(); ) {
/* 38 */       ReplacedTextRegion replacedTextRegion; int j = (replacedTextRegion = (ReplacedTextRegion)iterator.next()).getOriginalRange().getStart();
/* 39 */       int k = replacedTextRegion.getOriginalRange().getEnd();
/*    */       
/* 41 */       if (basedSequence.charAt(j) == '\\' && replacedTextRegion.getReplacedRange().getSpan() == 1 && j + 1 < basedSequence
/*    */         
/* 43 */         .length()) {
/* 44 */         if (bool) {
/* 45 */           bool = false;
/* 46 */           textBase = new TextBase(basedSequence);
/* 47 */           paramNode.insertBefore((Node)textBase);
/* 48 */           paramNodeTracker.nodeAdded((Node)textBase);
/*    */         } 
/*    */         
/* 51 */         if (j != i) {
/* 52 */           BasedSequence basedSequence3 = basedSequence.subSequence(i, j);
/* 53 */           Text text = new Text(basedSequence3);
/* 54 */           textBase.appendChild((Node)text);
/* 55 */           paramNodeTracker.nodeAdded((Node)text);
/*    */         } 
/*    */ 
/*    */         
/* 59 */         BasedSequence basedSequence1, basedSequence2 = (BasedSequence)(basedSequence1 = basedSequence.subSequence(j, k)).subSequence(1);
/* 60 */         EscapedCharacter escapedCharacter = new EscapedCharacter(basedSequence1.subSequence(0, 1), basedSequence2);
/* 61 */         textBase.appendChild((Node)escapedCharacter);
/* 62 */         paramNodeTracker.nodeAdded((Node)escapedCharacter);
/*    */         
/* 64 */         i = k;
/*    */       } 
/*    */     } 
/*    */     
/* 68 */     if (i > 0) {
/* 69 */       if (i != basedSequence.length()) {
/* 70 */         BasedSequence basedSequence1 = basedSequence.subSequence(i, basedSequence.length());
/* 71 */         Text text = new Text(basedSequence1);
/* 72 */         textBase.appendChild((Node)text);
/* 73 */         paramNodeTracker.nodeAdded((Node)text);
/*    */       } 
/*    */       
/* 76 */       paramNode.unlink();
/* 77 */       paramNodeTracker.nodeRemoved(paramNode);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class Factory extends NodePostProcessorFactory {
/*    */     public Factory() {
/* 83 */       super(false);
/* 84 */       addNodeWithExclusions(Text.class, new Class[] { DoNotDecorate.class });
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public NodePostProcessor apply(Document param1Document) {
/* 90 */       return new EscapedCharacterNodePostProcessor(param1Document);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\escaped\character\internal\EscapedCharacterNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */