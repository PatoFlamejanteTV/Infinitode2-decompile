/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotLinkDecorate;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.TextContainer;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.Escaping;
/*    */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public abstract class LinkNode
/*    */   extends LinkNodeBase
/*    */   implements DoNotLinkDecorate, TextContainer {
/*    */   public LinkNode() {}
/*    */   
/*    */   public LinkNode(BasedSequence paramBasedSequence) {
/* 17 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/*    */     BasedSequence basedSequence;
/* 26 */     switch (paramInt = paramInt & F_LINK_TEXT_TYPE) {
/*    */       case 1:
/* 28 */         basedSequence = getPageRef();
/*    */         break;
/*    */       case 2:
/* 31 */         basedSequence = getAnchorRef();
/*    */         break;
/*    */       case 3:
/* 34 */         basedSequence = getUrl();
/*    */         break;
/*    */       
/*    */       case 4:
/* 38 */         basedSequence = BasedSequence.NULL;
/*    */         break;
/*    */ 
/*    */       
/*    */       default:
/* 43 */         return true;
/*    */     } 
/*    */     
/* 46 */     if (paramInt == 4) {
/* 47 */       paramISequenceBuilder.append((CharSequence)getChars());
/*    */     } else {
/* 49 */       ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(basedSequence);
/*    */       
/* 51 */       BasedSequence basedSequence1 = Escaping.percentDecodeUrl(basedSequence = Escaping.unescape(basedSequence, replacedTextMapper), replacedTextMapper);
/* 52 */       paramISequenceBuilder.append((CharSequence)basedSequence1);
/*    */     } 
/*    */     
/* 55 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\LinkNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */