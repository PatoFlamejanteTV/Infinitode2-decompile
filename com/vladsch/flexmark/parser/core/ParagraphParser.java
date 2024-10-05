/*    */ package com.vladsch.flexmark.parser.core;
/*    */ import com.vladsch.flexmark.ast.Paragraph;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*    */ import com.vladsch.flexmark.parser.block.ParserState;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*    */ 
/*    */ public class ParagraphParser extends AbstractBlockParser {
/* 12 */   private final Paragraph block = new Paragraph();
/* 13 */   private BlockContent content = new BlockContent();
/*    */   
/*    */   public BlockContent getBlockContent() {
/* 16 */     return this.content;
/*    */   }
/*    */ 
/*    */   
/*    */   public Paragraph getBlock() {
/* 21 */     return this.block;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockContinue tryContinue(ParserState paramParserState) {
/* 26 */     if (!paramParserState.isBlank())
/*    */     {
/* 28 */       return BlockContinue.atIndex(paramParserState.getIndex());
/*    */     }
/* 30 */     boolean bool = paramParserState.isBlankLine();
/* 31 */     this.block.setTrailingBlankLine(bool);
/* 32 */     return BlockContinue.none();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*    */     int i;
/* 39 */     if ((i = paramParserState.getIndent()) > 0) {
/* 40 */       this.content.add((BasedSequence)PrefixedSubSequence.repeatOf(' ', i, paramBasedSequence), i); return;
/*    */     } 
/* 42 */     this.content.add(paramBasedSequence, i);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isParagraphParser() {
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isInterruptible() {
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void closeBlock(ParserState paramParserState) {
/* 58 */     this.block.setContent(this.content);
/* 59 */     this.content = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void parseInlines(InlineParser paramInlineParser) {
/* 64 */     paramInlineParser.parse(getBlock().getContentChars(), (Node)getBlock());
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements BlockParserFactory {
/*    */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 70 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\ParagraphParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */