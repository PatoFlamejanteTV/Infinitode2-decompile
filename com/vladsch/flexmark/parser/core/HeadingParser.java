/*     */ package com.vladsch.flexmark.parser.core;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Heading;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInCharsHandler;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInStartsWithCharsHandler;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class HeadingParser extends AbstractBlockParser {
/*     */   static class HeadingParsing extends Parsing { private final Pattern ATX_HEADING;
/*     */     
/*     */     public HeadingParsing(DataHolder param1DataHolder) {
/*  33 */       super(param1DataHolder);
/*     */       
/*  35 */       this.ATX_HEADING = ((Boolean)Parser.HEADING_NO_ATX_SPACE.get(param1DataHolder)).booleanValue() ? Pattern.compile("^#{1,6}(?:[ \t]*|$)") : (((Boolean)Parser.HEADING_NO_EMPTY_HEADING_WITHOUT_SPACE.get(param1DataHolder)).booleanValue() ? Pattern.compile("^#{1,6}(?:[ \t]*(?=[^ \t#])|[ \t]+$)") : Pattern.compile("^#{1,6}(?:[ \t]+|$)"));
/*  36 */       this.ATX_TRAILING = ((Boolean)Parser.HEADING_NO_ATX_SPACE.get(param1DataHolder)).booleanValue() ? Pattern.compile("[ \t]*#+[ \t]*$") : Pattern.compile("(^| |\t)[ \t]*#+[ \t]*$");
/*     */       
/*  38 */       int i = ((Integer)Parser.HEADING_SETEXT_MARKER_LENGTH.get(param1DataHolder)).intValue();
/*  39 */       this.SETEXT_HEADING = (i <= 1) ? Pattern.compile("^(?:=+|-+)[ \t]*$") : Pattern.compile("^(?:={" + i + ",}|-{" + i + ",})[ \t]*$");
/*     */     }
/*     */     private final Pattern ATX_TRAILING;
/*     */     private final Pattern SETEXT_HEADING; }
/*  43 */   final Heading block = new Heading();
/*     */   
/*     */   public HeadingParser(int paramInt) {
/*  46 */     this.block.setLevel(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  51 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  57 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {
/*  62 */     paramInlineParser.parse(this.block.getText(), (Node)this.block);
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {}
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*     */       HashSet<Class<BlockQuoteParser.Factory>> hashSet;
/*  74 */       (hashSet = new HashSet<>()).add(BlockQuoteParser.Factory.class);
/*  75 */       return hashSet;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  91 */       return new HashSet<>(Arrays.asList(new Class[] { FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 104 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public SpecialLeadInHandler getLeadInHandler(DataHolder param1DataHolder) {
/*     */       boolean bool;
/* 110 */       return (bool = (((Boolean)Parser.ESCAPE_HEADING_NO_ATX_SPACE.get(param1DataHolder)).booleanValue() || ((Boolean)Parser.HEADING_NO_ATX_SPACE.get(param1DataHolder)).booleanValue()) ? true : false) ? HeadingParser.HeadingLeadInHandler.HANDLER_NO_SPACE : HeadingParser.HeadingLeadInHandler.HANDLER_SPACE;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 116 */       return (BlockParserFactory)new HeadingParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   static class HeadingLeadInHandler {
/* 121 */     static final SpecialLeadInHandler HANDLER_NO_SPACE = (SpecialLeadInHandler)SpecialLeadInStartsWithCharsHandler.create('#');
/* 122 */     static final SpecialLeadInHandler HANDLER_SPACE = (SpecialLeadInHandler)SpecialLeadInCharsHandler.create('#');
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final HeadingParser.HeadingOptions options;
/*     */     private final HeadingParser.HeadingParsing myParsing;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 130 */       super(param1DataHolder);
/* 131 */       this.options = new HeadingParser.HeadingOptions(param1DataHolder);
/* 132 */       this.myParsing = new HeadingParser.HeadingParsing(param1DataHolder);
/*     */     }
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/*     */       BasedSequence basedSequence1;
/* 137 */       if (param1ParserState.getIndent() >= 4 || (this.options.noLeadSpace && param1ParserState.getIndent() > 0)) {
/* 138 */         return BlockStart.none();
/*     */       }
/*     */       
/* 141 */       if (param1ParserState.getActiveBlockParser() instanceof FencedCodeBlockParser) {
/* 142 */         return BlockStart.none();
/*     */       }
/*     */       
/* 145 */       if (!this.options.canInterruptItemParagraph) {
/*     */         BlockParser blockParser;
/*     */         
/*     */         boolean bool;
/*     */         boolean bool1;
/* 150 */         if (bool1 = ((bool = (blockParser = param1MatchedBlockParser.getBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof com.vladsch.flexmark.ast.ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) ? true : false) {
/* 151 */           return BlockStart.none();
/*     */         }
/*     */       } 
/*     */       
/* 155 */       BasedSequence basedSequence2 = param1ParserState.getLine();
/* 156 */       int i = param1ParserState.getNextNonSpaceIndex();
/* 157 */       BasedSequence basedSequence3 = param1MatchedBlockParser.getParagraphContent();
/*     */       
/* 159 */       BasedSequence basedSequence4 = basedSequence2.subSequence(i, basedSequence2.length());
/*     */       Matcher matcher;
/* 161 */       if ((matcher = this.myParsing.ATX_HEADING.matcher((CharSequence)basedSequence4)).find()) {
/*     */         
/* 163 */         i += matcher.group(0).length();
/* 164 */         int k = matcher.start();
/* 165 */         int j = matcher.end();
/*     */         
/* 167 */         int m = (basedSequence3 = (BasedSequence)basedSequence4.subSequence(k, j).trim()).length();
/*     */         
/*     */         BlockContent blockContent;
/* 170 */         (blockContent = new BlockContent()).add((BasedSequence)param1ParserState.getLineWithEOL().subSequence(i), param1ParserState.getIndent());
/*     */         
/* 172 */         BasedSequence basedSequence = (BasedSequence)basedSequence4.subSequence(j);
/* 173 */         basedSequence1 = null;
/*     */         Matcher matcher1;
/* 175 */         if ((matcher1 = this.myParsing.ATX_TRAILING.matcher((CharSequence)basedSequence)).find()) {
/*     */           
/* 177 */           i = matcher1.start();
/* 178 */           int n = matcher1.end();
/* 179 */           basedSequence1 = (BasedSequence)basedSequence.subSequence(i, n).trim();
/* 180 */           basedSequence = basedSequence.subSequence(0, i);
/*     */         } 
/*     */         
/*     */         HeadingParser headingParser;
/* 184 */         (headingParser = new HeadingParser(m)).block.setOpeningMarker(basedSequence3);
/* 185 */         headingParser.block.setText((BasedSequence)basedSequence.trim());
/* 186 */         headingParser.block.setClosingMarker(basedSequence1);
/* 187 */         headingParser.block.setCharsFromContent();
/*     */         
/* 189 */         return BlockStart.of(new BlockParser[] { (BlockParser)headingParser
/* 190 */             }).atIndex(basedSequence2.length());
/*     */       } 
/* 192 */       if ((matcher = this.myParsing.SETEXT_HEADING.matcher((CharSequence)basedSequence4)).find()) {
/* 193 */         if (basedSequence3 != null) {
/*     */           
/* 195 */           i = (matcher.group(0).charAt(0) == '=') ? 1 : 2;
/*     */           
/*     */           BlockContent blockContent;
/* 198 */           (blockContent = new BlockContent()).addAll(basedSequence1.getParagraphLines(), basedSequence1.getParagraphEolLengths());
/* 199 */           basedSequence1 = (BasedSequence)blockContent.getContents().trim();
/* 200 */           BasedSequence basedSequence = (BasedSequence)basedSequence2.trim();
/*     */           
/*     */           HeadingParser headingParser;
/* 203 */           (headingParser = new HeadingParser(i)).block.setText(basedSequence1);
/* 204 */           headingParser.block.setClosingMarker(basedSequence);
/* 205 */           headingParser.block.setCharsFromContent();
/*     */           
/* 207 */           return BlockStart.of(new BlockParser[] { (BlockParser)headingParser
/* 208 */               }).atIndex(basedSequence2.length())
/* 209 */             .replaceActiveBlockParser();
/*     */         } 
/* 211 */         return BlockStart.none();
/*     */       } 
/*     */       
/* 214 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class HeadingOptions
/*     */   {
/*     */     final boolean noAtxSpace;
/*     */     final boolean noEmptyHeadingWithoutSpace;
/*     */     final boolean noLeadSpace;
/*     */     final boolean canInterruptItemParagraph;
/*     */     final int setextMarkerLength;
/*     */     
/*     */     public HeadingOptions(DataHolder param1DataHolder) {
/* 228 */       this.noAtxSpace = ((Boolean)Parser.HEADING_NO_ATX_SPACE.get(param1DataHolder)).booleanValue();
/* 229 */       this.noEmptyHeadingWithoutSpace = ((Boolean)Parser.HEADING_NO_EMPTY_HEADING_WITHOUT_SPACE.get(param1DataHolder)).booleanValue();
/* 230 */       this.noLeadSpace = ((Boolean)Parser.HEADING_NO_LEAD_SPACE.get(param1DataHolder)).booleanValue();
/* 231 */       this.canInterruptItemParagraph = ((Boolean)Parser.HEADING_CAN_INTERRUPT_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 232 */       this.setextMarkerLength = ((Integer)Parser.HEADING_SETEXT_MARKER_LENGTH.get(param1DataHolder)).intValue();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\HeadingParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */