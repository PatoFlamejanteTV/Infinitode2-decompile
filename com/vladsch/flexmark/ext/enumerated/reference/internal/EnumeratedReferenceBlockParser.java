/*     */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceBlock;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceRepository;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class EnumeratedReferenceBlockParser extends AbstractBlockParser {
/*  22 */   static String ENUM_REF_ID = "(?:[^0-9].*)?";
/*  23 */   static Pattern ENUM_REF_ID_PATTERN = Pattern.compile("\\[[\\@|#]\\s*(" + ENUM_REF_ID + ")\\s*\\]");
/*  24 */   static Pattern ENUM_REF_DEF_PATTERN = Pattern.compile("^(\\[[\\@]\\s*(" + ENUM_REF_ID + ")\\s*\\]:)\\s+");
/*     */   
/*  26 */   final EnumeratedReferenceBlock block = new EnumeratedReferenceBlock();
/*  27 */   private BlockContent content = new BlockContent();
/*     */ 
/*     */   
/*     */   public EnumeratedReferenceBlockParser(EnumeratedReferenceOptions paramEnumeratedReferenceOptions, int paramInt) {}
/*     */ 
/*     */   
/*     */   public BlockContent getBlockContent() {
/*  34 */     return this.content;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  39 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  44 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  49 */     throw new IllegalStateException("Abbreviation Blocks hold a single line");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  55 */     this.block.setCharsFromContent();
/*  56 */     this.block.setEnumeratedReference((BasedSequence)((BasedSequence)this.block.getChars().subSequence(this.block.getClosingMarker().getEndOffset() - this.block.getStartOffset())).trimStart());
/*  57 */     this.content = null;
/*     */     
/*     */     EnumeratedReferenceRepository enumeratedReferenceRepository;
/*     */     
/*  61 */     (enumeratedReferenceRepository = (EnumeratedReferenceRepository)EnumeratedReferenceExtension.ENUMERATED_REFERENCES.get((DataHolder)paramParserState.getProperties())).put(this.block.getText().toString(), this.block);
/*     */   }
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {
/*     */     Node node;
/*  67 */     if ((node = this.block.getFirstChild()) != null) {
/*  68 */       paramInlineParser.parse(node.getChars(), node);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  79 */     return paramBlockParser.isParagraphParser();
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  86 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  92 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/*  97 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 103 */       return (BlockParserFactory)new EnumeratedReferenceBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final EnumeratedReferenceOptions options;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 111 */       super(param1DataHolder);
/* 112 */       this.options = new EnumeratedReferenceOptions(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 117 */       if (param1ParserState.getIndent() >= 4) {
/* 118 */         return BlockStart.none();
/*     */       }
/*     */       
/* 121 */       BasedSequence basedSequence1 = param1ParserState.getLineWithEOL();
/* 122 */       int i = param1ParserState.getNextNonSpaceIndex();
/*     */       
/* 124 */       BasedSequence basedSequence2 = basedSequence1.subSequence(i, basedSequence1.length());
/*     */       Matcher matcher;
/* 126 */       if ((matcher = EnumeratedReferenceBlockParser.ENUM_REF_DEF_PATTERN.matcher((CharSequence)basedSequence2)).find()) {
/*     */         
/* 128 */         int j = i + matcher.start(1);
/* 129 */         i += matcher.end(1);
/* 130 */         BasedSequence basedSequence4 = basedSequence1.subSequence(j, j + 2);
/* 131 */         BasedSequence basedSequence5 = basedSequence1.subSequence(matcher.start(2), matcher.end(2));
/* 132 */         BasedSequence basedSequence3 = basedSequence1.subSequence(i - 2, i);
/*     */         
/* 134 */         int k = this.options.contentIndent;
/*     */         
/*     */         EnumeratedReferenceBlockParser enumeratedReferenceBlockParser;
/* 137 */         (enumeratedReferenceBlockParser = new EnumeratedReferenceBlockParser(this.options, k)).block.setOpeningMarker(basedSequence4);
/* 138 */         enumeratedReferenceBlockParser.block.setText(basedSequence5);
/* 139 */         enumeratedReferenceBlockParser.block.setClosingMarker(basedSequence3);
/* 140 */         basedSequence3 = (BasedSequence)basedSequence2.subSequence(matcher.end());
/* 141 */         enumeratedReferenceBlockParser.block.setEnumeratedReference(basedSequence3);
/* 142 */         Paragraph paragraph = new Paragraph(basedSequence3);
/* 143 */         enumeratedReferenceBlockParser.block.appendChild((Node)paragraph);
/* 144 */         enumeratedReferenceBlockParser.block.setCharsFromContent();
/*     */         
/* 146 */         return BlockStart.of(new BlockParser[] { (BlockParser)enumeratedReferenceBlockParser
/* 147 */             }).atIndex(basedSequence1.length());
/*     */       } 
/* 149 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */