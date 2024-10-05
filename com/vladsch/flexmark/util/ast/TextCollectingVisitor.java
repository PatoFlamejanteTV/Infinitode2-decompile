/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.function.BiConsumer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TextCollectingVisitor
/*    */ {
/* 14 */   private final NodeVisitor myVisitor = new NodeVisitor()
/*    */     {
/*    */       public void processNode(Node param1Node, boolean param1Boolean, BiConsumer<Node, Visitor<Node>> param1BiConsumer) {
/* 17 */         if (!param1Node.isOrDescendantOfType(new Class[] { DoNotCollectText.class }))
/* 18 */           if (param1Node instanceof TextContainer) {
/* 19 */             TextCollectingVisitor.this.out.setLastNode(param1Node);
/* 20 */             if (((TextContainer)param1Node).collectText(TextCollectingVisitor.this.out, TextCollectingVisitor.this.flags, TextCollectingVisitor.this.myVisitor)) {
/* 21 */               if (param1Node instanceof BlankLineBreakNode && TextCollectingVisitor.this.out.isNotEmpty()) {
/* 22 */                 TextCollectingVisitor.this.out.appendEol();
/*    */               }
/* 24 */               processChildren(param1Node, param1BiConsumer);
/* 25 */               if (param1Node instanceof LineBreakNode && TextCollectingVisitor.this.out.needEol()) {
/* 26 */                 TextCollectingVisitor.this.out.appendEol(); return;
/*    */               } 
/*    */             } 
/*    */           } else {
/* 30 */             TextCollectingVisitor.this.out.setLastNode(param1Node);
/* 31 */             if (param1Node instanceof BlankLineBreakNode && TextCollectingVisitor.this.out.isNotEmpty()) {
/* 32 */               TextCollectingVisitor.this.out.appendEol();
/*    */             }
/* 34 */             processChildren(param1Node, param1BiConsumer);
/* 35 */             if (param1Node instanceof LineBreakNode && TextCollectingVisitor.this.out.needEol())
/* 36 */               TextCollectingVisitor.this.out.appendEol(); 
/*    */           }  
/*    */       }
/*    */     };
/*    */   
/*    */   SpaceInsertingSequenceBuilder out;
/*    */   int flags;
/*    */   
/*    */   public String getText() {
/* 45 */     return this.out.toString();
/*    */   }
/*    */   
/*    */   public BasedSequence getSequence() {
/* 49 */     return this.out.toSequence();
/*    */   }
/*    */   
/*    */   public void collect(Node paramNode) {
/* 53 */     collect(paramNode, 0);
/*    */   }
/*    */   
/*    */   public String collectAndGetText(Node paramNode) {
/* 57 */     return collectAndGetText(paramNode, 0);
/*    */   }
/*    */   
/*    */   public BasedSequence collectAndGetSequence(Node paramNode) {
/* 61 */     return collectAndGetSequence(paramNode, 0);
/*    */   }
/*    */   
/*    */   public void collect(Node paramNode, int paramInt) {
/* 65 */     this.out = SpaceInsertingSequenceBuilder.emptyBuilder(paramNode.getChars(), paramInt);
/* 66 */     this.flags = paramInt;
/* 67 */     this.myVisitor.visit(paramNode);
/*    */   }
/*    */   
/*    */   public String collectAndGetText(Node paramNode, int paramInt) {
/* 71 */     collect(paramNode, paramInt);
/* 72 */     return this.out.toString();
/*    */   }
/*    */   
/*    */   public BasedSequence collectAndGetSequence(Node paramNode, int paramInt) {
/* 76 */     collect(paramNode, paramInt);
/* 77 */     return this.out.toSequence();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\TextCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */