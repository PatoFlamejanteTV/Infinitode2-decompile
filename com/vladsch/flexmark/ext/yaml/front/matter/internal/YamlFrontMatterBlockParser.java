/*     */ package com.vladsch.flexmark.ext.yaml.front.matter.internal;
/*     */ import com.vladsch.flexmark.ext.yaml.front.matter.YamlFrontMatterBlock;
/*     */ import com.vladsch.flexmark.ext.yaml.front.matter.YamlFrontMatterNode;
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
/*     */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SegmentedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class YamlFrontMatterBlockParser extends AbstractBlockParser {
/*  24 */   private static final Pattern REGEX_METADATA = Pattern.compile("^[ ]{0,3}([A-Za-z0-9_-]+):\\s*(.*)");
/*  25 */   private static final Pattern REGEX_METADATA_LIST = Pattern.compile("^[ ]+-\\s*(.*)");
/*  26 */   private static final Pattern REGEX_METADATA_LITERAL = Pattern.compile("^\\s*(.*)");
/*  27 */   private static final Pattern REGEX_BEGIN = Pattern.compile("^-{3}(\\s.*)?");
/*  28 */   private static final Pattern REGEX_END = Pattern.compile("^(-{3}|\\.{3})(\\s.*)?");
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean inYAMLBlock = true;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean inLiteral = false;
/*     */ 
/*     */ 
/*     */   
/*  40 */   private BasedSequence currentKey = null;
/*  41 */   private List<BasedSequence> currentValues = new ArrayList<>();
/*  42 */   private YamlFrontMatterBlock block = new YamlFrontMatterBlock();
/*  43 */   private BlockContent content = new BlockContent();
/*     */ 
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  48 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  58 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  63 */     this.block.setContent(this.content.getLines().subList(0, this.content.getLineCount()));
/*  64 */     this.block.setCharsFromContent();
/*  65 */     this.content = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  70 */     BasedSequence basedSequence = paramParserState.getLine();
/*     */     
/*  72 */     if (this.inYAMLBlock) {
/*  73 */       if (REGEX_END.matcher((CharSequence)basedSequence).matches()) {
/*  74 */         if (this.currentKey != null) {
/*     */           YamlFrontMatterNode yamlFrontMatterNode;
/*  76 */           (yamlFrontMatterNode = new YamlFrontMatterNode(this.currentKey, this.currentValues)).setCharsFromContent();
/*  77 */           this.block.appendChild((Node)yamlFrontMatterNode);
/*     */         } 
/*     */         
/*  80 */         addLine(paramParserState, basedSequence);
/*  81 */         return BlockContinue.finished();
/*     */       } 
/*     */       
/*     */       Matcher matcher;
/*  85 */       if ((matcher = REGEX_METADATA.matcher((CharSequence)basedSequence)).matches()) {
/*  86 */         if (this.currentKey != null) {
/*     */           YamlFrontMatterNode yamlFrontMatterNode;
/*  88 */           (yamlFrontMatterNode = new YamlFrontMatterNode(this.currentKey, this.currentValues)).setCharsFromContent();
/*  89 */           this.block.appendChild((Node)yamlFrontMatterNode);
/*     */         } 
/*     */         
/*  92 */         this.inLiteral = false;
/*  93 */         this.currentKey = basedSequence.subSequence(matcher.start(1), matcher.end(1));
/*  94 */         this.currentValues = new ArrayList<>();
/*  95 */         if ("|".equals(matcher.group(2))) {
/*  96 */           this.inLiteral = true;
/*  97 */         } else if (!"".equals(matcher.group(2))) {
/*  98 */           this.currentValues.add(basedSequence.subSequence(matcher.start(2), matcher.end(2)));
/*     */         } 
/*     */         
/* 101 */         return BlockContinue.atIndex(paramParserState.getIndex());
/*     */       } 
/* 103 */       if (this.inLiteral) {
/*     */         
/* 105 */         if ((matcher = REGEX_METADATA_LITERAL.matcher((CharSequence)basedSequence)).matches()) {
/* 106 */           if (this.currentValues.size() == 1) {
/* 107 */             BasedSequence basedSequence1 = SegmentedSequence.create(new BasedSequence[] { this.currentValues.get(0), (BasedSequence)PrefixedSubSequence.prefixOf("\n", (BasedSequence)basedSequence.subSequence(matcher.start(1), matcher.end(1)).trim()) });
/* 108 */             this.currentValues.set(0, basedSequence1);
/*     */           } else {
/* 110 */             this.currentValues.add(basedSequence.subSequence(matcher.start(1), matcher.end(1)).trim());
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 115 */       else if ((matcher = REGEX_METADATA_LIST.matcher((CharSequence)basedSequence)).matches()) {
/* 116 */         this.currentValues.add(basedSequence.subSequence(matcher.start(1), matcher.end(1)));
/*     */       } 
/*     */ 
/*     */       
/* 120 */       return BlockContinue.atIndex(paramParserState.getIndex());
/*     */     } 
/* 122 */     if (REGEX_BEGIN.matcher((CharSequence)basedSequence).matches()) {
/* 123 */       this.inYAMLBlock = true;
/* 124 */       return BlockContinue.atIndex(paramParserState.getIndex());
/*     */     } 
/*     */     
/* 127 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {}
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 138 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 144 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 149 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 155 */       return (BlockParserFactory)new YamlFrontMatterBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private BlockFactory(DataHolder param1DataHolder) {
/* 161 */       super(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 166 */       BasedSequence basedSequence = param1ParserState.getLine();
/*     */       
/*     */       BlockParser blockParser;
/* 169 */       if (blockParser = param1MatchedBlockParser.getBlockParser() instanceof com.vladsch.flexmark.parser.core.DocumentBlockParser && blockParser.getBlock().getFirstChild() == null && YamlFrontMatterBlockParser
/* 170 */         .REGEX_BEGIN.matcher((CharSequence)basedSequence).matches()) {
/* 171 */         return BlockStart.of(new BlockParser[] { (BlockParser)new YamlFrontMatterBlockParser() }).atIndex(param1ParserState.getNextNonSpaceIndex());
/*     */       }
/*     */       
/* 174 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\yaml\front\matter\internal\YamlFrontMatterBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */