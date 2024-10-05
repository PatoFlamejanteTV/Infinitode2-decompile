/*     */ package com.vladsch.flexmark.ext.definition.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.ext.definition.DefinitionExtension;
/*     */ import com.vladsch.flexmark.ext.definition.DefinitionItem;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.parser.core.DocumentBlockParser;
/*     */ import com.vladsch.flexmark.util.ast.BlankLine;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInCharsHandler;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class DefinitionItemBlockParser extends AbstractBlockParser {
/*     */   private final DefinitionItem block;
/*     */   private final DefinitionOptions options;
/*     */   private final ItemData itemData;
/*     */   private boolean hadBlankLine;
/*     */   
/*     */   DefinitionItemBlockParser(DataHolder paramDataHolder, ItemData paramItemData) {
/*  36 */     this.options = new DefinitionOptions(paramDataHolder);
/*  37 */     this.itemData = paramItemData;
/*  38 */     this.block = new DefinitionItem();
/*  39 */     this.block.setOpeningMarker(paramItemData.itemMarker);
/*  40 */     this.block.setTight(paramItemData.isTight);
/*     */   }
/*     */   
/*     */   static class ItemData {
/*     */     final boolean isEmpty;
/*     */     final boolean isTight;
/*     */     final int markerIndex;
/*     */     final int markerColumn;
/*     */     final int markerIndent;
/*     */     final int contentOffset;
/*     */     final BasedSequence itemMarker;
/*     */     
/*     */     ItemData(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, int param1Int3, int param1Int4, BasedSequence param1BasedSequence) {
/*  53 */       this.isEmpty = param1Boolean1;
/*  54 */       this.isTight = param1Boolean2;
/*  55 */       this.markerIndex = param1Int1;
/*  56 */       this.markerColumn = param1Int2;
/*  57 */       this.markerIndent = param1Int3;
/*  58 */       this.contentOffset = param1Int4;
/*  59 */       this.itemMarker = param1BasedSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   private int getContentIndent() {
/*  64 */     return this.itemData.markerIndent + this.itemData.itemMarker.length() + this.itemData.contentOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  69 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   static ItemData parseItemMarker(DefinitionOptions paramDefinitionOptions, ParserState paramParserState, boolean paramBoolean) {
/*  83 */     BasedSequence basedSequence1 = paramParserState.getLine();
/*  84 */     int j = paramParserState.getNextNonSpaceIndex();
/*  85 */     int k = paramParserState.getColumn() + paramParserState.getIndent();
/*  86 */     int i = paramParserState.getIndent();
/*     */     
/*     */     BasedSequence basedSequence2;
/*     */     int m;
/*  90 */     if (((m = (basedSequence2 = basedSequence1.subSequence(j, basedSequence1.length())).firstChar()) != ':' || !paramDefinitionOptions.colonMarker) && (m != 126 || !paramDefinitionOptions.tildeMarker)) {
/*  91 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  96 */     m = 0;
/*     */ 
/*     */     
/*  99 */     boolean bool = false;
/* 100 */     for (int n = j + 1; n < basedSequence1.length(); n++) {
/*     */       char c;
/* 102 */       if ((c = basedSequence1.charAt(n)) == '\t') {
/* 103 */         m = m + Parsing.columnsToNextTabStop(k + 1 + m);
/* 104 */       } else if (c == ' ') {
/* 105 */         m++;
/*     */       } else {
/* 107 */         bool = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 112 */     if (bool && m < paramDefinitionOptions.markerSpaces) {
/* 113 */       return null;
/*     */     }
/*     */     
/* 116 */     if (!bool || (paramDefinitionOptions.myParserEmulationProfile == ParserEmulationProfile.COMMONMARK && m > paramDefinitionOptions.newItemCodeIndent))
/*     */     {
/* 118 */       m = 1;
/*     */     }
/*     */     
/* 121 */     return new ItemData(!bool, paramBoolean, j, k, i, m, basedSequence2.subSequence(0, 1));
/*     */   }
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*     */     int i;
/*     */     ItemData itemData;
/*     */     Node node;
/* 127 */     boolean bool = ((node = this.block.getFirstChild()) == null) ? true : false;
/*     */     
/* 129 */     if (paramParserState.isBlank()) {
/* 130 */       if (bool || node.getNext() == null) {
/* 131 */         this.block.setHadBlankAfterItemParagraph(true);
/*     */       }
/* 133 */       this.hadBlankLine = true;
/* 134 */       return BlockContinue.atIndex(paramParserState.getNextNonSpaceIndex());
/*     */     } 
/*     */     
/*     */     ParserEmulationProfile parserEmulationProfile;
/* 138 */     if ((parserEmulationProfile = this.options.myParserEmulationProfile.family) == ParserEmulationProfile.COMMONMARK || parserEmulationProfile == ParserEmulationProfile.KRAMDOWN || parserEmulationProfile == ParserEmulationProfile.MARKDOWN) {
/* 139 */       i = paramParserState.getIndent();
/* 140 */       int j = paramParserState.getColumn() + getContentIndent();
/*     */       
/* 142 */       if (i >= getContentIndent())
/*     */       {
/* 144 */         return BlockContinue.atColumn(j);
/*     */       }
/* 146 */       if (bool) {
/* 147 */         return BlockContinue.atIndex(paramParserState.getIndex() + i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 152 */       if ((itemData = parseItemMarker(this.options, paramParserState, false)) != null) {
/* 153 */         return BlockContinue.none();
/*     */       }
/*     */       
/* 156 */       if (!this.hadBlankLine) {
/* 157 */         return BlockContinue.atIndex(paramParserState.getIndex() + i);
/*     */       }
/*     */     }
/* 160 */     else if (i == ParserEmulationProfile.FIXED_INDENT) {
/* 161 */       i = paramParserState.getIndent();
/*     */ 
/*     */       
/* 164 */       int j = paramParserState.getColumn() + this.options.itemIndent;
/*     */       
/* 166 */       if (i >= this.options.itemIndent)
/*     */       {
/* 168 */         return BlockContinue.atColumn(j);
/*     */       }
/* 170 */       if (itemData != null) {
/* 171 */         return BlockContinue.atIndex(paramParserState.getIndex() + i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 176 */       if ((itemData = parseItemMarker(this.options, paramParserState, false)) != null) {
/* 177 */         return BlockContinue.none();
/*     */       }
/*     */       
/* 180 */       if (!this.hadBlankLine) {
/* 181 */         return BlockContinue.atIndex(paramParserState.getIndex() + i);
/*     */       }
/*     */     } 
/*     */     
/* 185 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/* 195 */     this.block.setCharsFromContent();
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
/* 207 */       return null;
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
/* 222 */       return null;
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
/*     */     public SpecialLeadInHandler getLeadInHandler(DataHolder param1DataHolder) {
/* 236 */       boolean bool2 = ((Boolean)DefinitionExtension.COLON_MARKER.get(param1DataHolder)).booleanValue();
/* 237 */       boolean bool1 = ((Boolean)DefinitionExtension.TILDE_MARKER.get(param1DataHolder)).booleanValue();
/* 238 */       return (bool2 && bool1) ? DefinitionItemBlockParser.DefinitionLeadInHandler.HANDLER_COLON_TILDE : (bool2 ? DefinitionItemBlockParser.DefinitionLeadInHandler.HANDLER_COLON : (bool1 ? DefinitionItemBlockParser.DefinitionLeadInHandler.HANDLER_TILDE : null));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 243 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 249 */       return (BlockParserFactory)new DefinitionItemBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   static class DefinitionLeadInHandler {
/* 254 */     static final SpecialLeadInHandler HANDLER_COLON_TILDE = (SpecialLeadInHandler)SpecialLeadInCharsHandler.create(":~");
/* 255 */     static final SpecialLeadInHandler HANDLER_COLON = (SpecialLeadInHandler)SpecialLeadInCharsHandler.create(":");
/* 256 */     static final SpecialLeadInHandler HANDLER_TILDE = (SpecialLeadInHandler)SpecialLeadInCharsHandler.create("~");
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final DefinitionOptions options;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 263 */       super(param1DataHolder);
/* 264 */       this.options = new DefinitionOptions(param1DataHolder);
/*     */     }
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/*     */       BasedSequence basedSequence;
/*     */       BlockParser blockParser;
/* 270 */       if (blockParser = param1MatchedBlockParser.getBlockParser() instanceof DocumentBlockParser) {
/*     */         Document document;
/*     */         
/*     */         Block block;
/* 274 */         if (!(block = (Block)(document = ((DocumentBlockParser)blockParser).getBlock()).getLastChildAnyNot(new Class[] { BlankLine.class }) instanceof com.vladsch.flexmark.ast.Paragraph) && !(block instanceof DefinitionItem)) {
/* 275 */           return BlockStart.none();
/*     */         }
/*     */ 
/*     */         
/* 279 */         if (this.options.doubleBlankLineBreaksList) {
/*     */           
/* 281 */           block.setCharsFromContent();
/*     */           
/*     */           String str;
/* 284 */           if ((basedSequence = BasedSequence.of(str = param1ParserState.getLine().baseSubSequence(block.getEndOffset(), param1ParserState.getLine().getStartOffset()).normalizeEOL())).countLeading(CharPredicate.EOL) >= 2) {
/* 285 */             return BlockStart.none();
/*     */           }
/*     */         } 
/* 288 */       } else if (!(basedSequence instanceof DefinitionItemBlockParser) && !(basedSequence instanceof com.vladsch.flexmark.parser.core.ParagraphParser)) {
/* 289 */         return BlockStart.none();
/*     */       } 
/*     */       
/* 292 */       ParserEmulationProfile parserEmulationProfile = this.options.myParserEmulationProfile;
/*     */       
/* 294 */       int j = param1ParserState.getIndent();
/* 295 */       int i = (parserEmulationProfile == ParserEmulationProfile.COMMONMARK || parserEmulationProfile == ParserEmulationProfile.FIXED_INDENT) ? this.options.codeIndent : this.options.itemIndent;
/*     */       DefinitionItemBlockParser.ItemData itemData;
/* 297 */       if (j < i && (
/*     */         
/* 299 */         itemData = DefinitionItemBlockParser.parseItemMarker(this.options, param1ParserState, param1ParserState.getActiveBlockParser() instanceof com.vladsch.flexmark.parser.core.ParagraphParser)) != null) {
/*     */         BlockStart blockStart;
/*     */         
/* 302 */         return blockStart = BlockStart.of(new BlockParser[] { (BlockParser)new DefinitionItemBlockParser((DataHolder)param1ParserState.getProperties(), itemData) }).atColumn(itemData.markerColumn + itemData.itemMarker.length() + itemData.contentOffset);
/*     */       } 
/*     */       
/* 305 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\internal\DefinitionItemBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */