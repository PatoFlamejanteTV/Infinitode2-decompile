/*    */ package com.vladsch.flexmark.parser.core;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.AbstractBlockParser;
/*    */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*    */ import com.vladsch.flexmark.parser.block.BlockParser;
/*    */ import com.vladsch.flexmark.parser.block.ParserState;
/*    */ import com.vladsch.flexmark.util.ast.BlankLineContainer;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class DocumentBlockParser
/*    */   extends AbstractBlockParser
/*    */   implements BlankLineContainer
/*    */ {
/*    */   private Document document;
/*    */   
/*    */   public void initializeDocument(DataHolder paramDataHolder, BasedSequence paramBasedSequence) {
/* 22 */     this.document = new Document(paramDataHolder, paramBasedSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isContainer() {
/* 27 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/* 32 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public Document getBlock() {
/* 37 */     return this.document;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockContinue tryContinue(ParserState paramParserState) {
/* 42 */     return BlockContinue.atIndex(paramParserState.getIndex());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {}
/*    */ 
/*    */   
/*    */   public void closeBlock(ParserState paramParserState) {
/* 51 */     if (((Boolean)Parser.TRACK_DOCUMENT_LINES.get((DataHolder)paramParserState.getProperties())).booleanValue())
/* 52 */       this.document.setContent(paramParserState.getLineSegments()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\DocumentBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */