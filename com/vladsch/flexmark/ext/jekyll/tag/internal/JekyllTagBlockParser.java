/*     */ package com.vladsch.flexmark.ext.jekyll.tag.internal;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTag;
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagBlock;
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
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
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ 
/*     */ public class JekyllTagBlockParser extends AbstractBlockParser {
/*  23 */   final JekyllTagBlock block = new JekyllTagBlock(); public static final String INCLUDE_TAG = "include";
/*  24 */   private BlockContent content = new BlockContent();
/*     */ 
/*     */   
/*     */   JekyllTagBlockParser(DataHolder paramDataHolder) {}
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  31 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  36 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  41 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  46 */     this.block.setContent(this.content);
/*     */     
/*  48 */     this.content = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {}
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  60 */       return null;
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
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  75 */       return null;
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
/*     */     public boolean affectsGlobalScope() {
/*  89 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/*  95 */       return (BlockParserFactory)new JekyllTagBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final JekyllTagParsing parsing;
/*     */     private final boolean listIncludesOnly;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 104 */       super(param1DataHolder);
/* 105 */       this.parsing = new JekyllTagParsing(new Parsing(param1DataHolder));
/* 106 */       this.listIncludesOnly = ((Boolean)JekyllTagExtension.LIST_INCLUDES_ONLY.get(param1DataHolder)).booleanValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 111 */       BasedSequence basedSequence2 = param1ParserState.getLine();
/*     */ 
/*     */       
/* 114 */       BasedSequence basedSequence1 = (BasedSequence)basedSequence2.subSequence(param1ParserState.getIndex());
/*     */       int i;
/*     */       Matcher matcher;
/* 117 */       if ((i = param1ParserState.getIndent()) == 0 && !(param1MatchedBlockParser.getBlockParser().getBlock() instanceof com.vladsch.flexmark.ast.Paragraph) && (matcher = this.parsing.MACRO_OPEN.matcher((CharSequence)basedSequence1)).find()) {
/*     */         
/* 119 */         BasedSequence basedSequence = basedSequence1.subSequence(0, matcher.end());
/* 120 */         basedSequence2 = basedSequence2.subSequence(matcher.start(1), matcher.end(1));
/* 121 */         basedSequence1 = (BasedSequence)basedSequence1.subSequence(matcher.end(1), matcher.end() - 2).trim();
/*     */         
/*     */         JekyllTag jekyllTag;
/* 124 */         (jekyllTag = new JekyllTag(basedSequence.subSequence(0, 2), basedSequence2, basedSequence1, (BasedSequence)basedSequence.endSequence(2))).setCharsFromContent();
/*     */         
/*     */         JekyllTagBlockParser jekyllTagBlockParser;
/* 127 */         (jekyllTagBlockParser = new JekyllTagBlockParser((DataHolder)param1ParserState.getProperties())).block.appendChild((Node)jekyllTag);
/*     */ 
/*     */         
/* 130 */         if (!this.listIncludesOnly || basedSequence2.equals("include")) {
/*     */           List<JekyllTag> list;
/* 132 */           (list = (List<JekyllTag>)JekyllTagExtension.TAG_LIST.get((DataHolder)param1ParserState.getProperties())).add(jekyllTag);
/*     */         } 
/*     */         
/* 135 */         return BlockStart.of(new BlockParser[] { (BlockParser)jekyllTagBlockParser
/* 136 */             }).atIndex(param1ParserState.getLineEndIndex());
/*     */       } 
/*     */ 
/*     */       
/* 140 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\internal\JekyllTagBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */