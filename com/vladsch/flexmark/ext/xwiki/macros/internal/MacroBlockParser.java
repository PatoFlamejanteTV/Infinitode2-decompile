/*     */ package com.vladsch.flexmark.ext.xwiki.macros.internal;
/*     */ import com.vladsch.flexmark.ext.xwiki.macros.Macro;
/*     */ import com.vladsch.flexmark.ext.xwiki.macros.MacroAttribute;
/*     */ import com.vladsch.flexmark.ext.xwiki.macros.MacroBlock;
/*     */ import com.vladsch.flexmark.ext.xwiki.macros.MacroClose;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
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
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ 
/*     */ public class MacroBlockParser extends AbstractBlockParser {
/*  25 */   private final MacroBlock block = new MacroBlock();
/*  26 */   private BlockContent content = new BlockContent();
/*     */   private final MacroParsing parsing;
/*     */   private final BasedSequence macroName;
/*     */   private final boolean oneLine;
/*     */   private boolean hadClose;
/*     */   
/*     */   MacroBlockParser(DataHolder paramDataHolder, MacroParsing paramMacroParsing, BasedSequence paramBasedSequence, boolean paramBoolean) {
/*  33 */     this.parsing = paramMacroParsing;
/*  34 */     this.macroName = paramBasedSequence;
/*  35 */     this.oneLine = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  40 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  45 */     if (this.hadClose) {
/*  46 */       return BlockContinue.none();
/*     */     }
/*     */     
/*  49 */     BasedSequence basedSequence = paramParserState.getLine();
/*     */     Matcher matcher;
/*  51 */     if ((matcher = this.parsing.MACRO_CLOSE.matcher((CharSequence)basedSequence)).find())
/*     */     {
/*  53 */       if (this.macroName.equals(matcher.group(1))) {
/*  54 */         List<BlockParser> list = paramParserState.getActiveBlockParsers();
/*  55 */         boolean bool = false; BlockParser blockParser;
/*  56 */         for (int i = list.size(); i-- > 0 && (
/*     */           
/*  58 */           blockParser = list.get(i)) != this;) {
/*     */           
/*  60 */           if (blockParser instanceof MacroBlockParser && 
/*  61 */             !((MacroBlockParser)blockParser).hadClose && ((MacroBlockParser)blockParser).macroName.equals(this.macroName)) {
/*  62 */             bool = true;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/*  67 */         if (!bool) {
/*  68 */           this.hadClose = true;
/*     */ 
/*     */           
/*     */           MacroClose macroClose;
/*     */           
/*  73 */           (macroClose = new MacroClose(basedSequence.subSequence(matcher.start(), matcher.start() + 3), basedSequence.subSequence(matcher.start(1), matcher.end(1)), basedSequence.subSequence(matcher.end() - 2, matcher.end()))).setCharsFromContent();
/*     */           
/*  75 */           this.block.appendChild((Node)macroClose);
/*  76 */           return BlockContinue.atIndex(paramParserState.getLineEndIndex());
/*     */         } 
/*     */       } 
/*     */     }
/*  80 */     return BlockContinue.atIndex(paramParserState.getIndex());
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  85 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/* 101 */     if (this.oneLine) {
/* 102 */       BasedSequence basedSequence; ArrayList<BasedSequence> arrayList = new ArrayList();
/* 103 */       Macro macro = (Macro)this.block.getFirstChild();
/*     */       
/*     */       Node node;
/* 106 */       if (node = this.block.getLastChild() instanceof MacroClose) {
/* 107 */         basedSequence = macro.baseSubSequence(macro.getEndOffset(), node.getStartOffset());
/*     */       } else {
/* 109 */         basedSequence = basedSequence.baseSubSequence(basedSequence.getEndOffset(), basedSequence.getEndOffset());
/*     */       } 
/*     */       
/* 112 */       arrayList.add(basedSequence);
/* 113 */       this.block.setContent(arrayList);
/*     */     
/*     */     }
/* 116 */     else if (this.hadClose) {
/* 117 */       List list = this.content.getLines();
/* 118 */       this.block.setContent(list);
/*     */     } else {
/* 120 */       List list = this.content.getLines();
/* 121 */       this.block.setContent(list.subList(0, list.size()));
/*     */     } 
/*     */ 
/*     */     
/* 125 */     this.block.setCharsFromContent();
/* 126 */     this.content = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {
/*     */     Node node;
/* 132 */     if (node = this.block.getLastChild() instanceof MacroClose) {
/* 133 */       node.unlink();
/*     */     }
/*     */     
/* 136 */     paramInlineParser.parse(this.block.getContentChars(), (Node)this.block);
/*     */     
/* 138 */     if (node instanceof MacroClose) {
/* 139 */       this.block.appendChild(node);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 147 */       return null;
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
/* 162 */       return null;
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
/* 176 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 182 */       return (BlockParserFactory)new MacroBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final MacroParsing parsing;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 190 */       super(param1DataHolder);
/* 191 */       this.parsing = new MacroParsing(new Parsing(param1DataHolder));
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 196 */       BasedSequence basedSequence2 = param1ParserState.getLine();
/*     */ 
/*     */       
/* 199 */       BasedSequence basedSequence1 = (BasedSequence)basedSequence2.subSequence(param1ParserState.getIndex());
/*     */       Matcher matcher;
/*     */       int i;
/* 202 */       if ((i = param1ParserState.getIndent()) == 0 && !(param1MatchedBlockParser.getBlockParser().getBlock() instanceof com.vladsch.flexmark.ast.Paragraph) && (matcher = this.parsing.MACRO_OPEN.matcher((CharSequence)basedSequence1)).find()) {
/*     */         
/* 204 */         basedSequence2 = basedSequence2.subSequence(matcher.start(1), matcher.end(1));
/* 205 */         BasedSequence basedSequence = basedSequence1.subSequence(0, matcher.end());
/* 206 */         basedSequence1 = (BasedSequence)basedSequence1.subSequence(matcher.end());
/* 207 */         boolean bool1 = false;
/* 208 */         boolean bool2 = false;
/* 209 */         MacroClose macroClose = null;
/*     */         
/* 211 */         if (basedSequence.endsWith("/}}")) {
/*     */           
/* 213 */           if (basedSequence1.isBlank()) {
/*     */             
/* 215 */             bool1 = true;
/* 216 */             bool2 = true;
/*     */           } else {
/* 218 */             return BlockStart.none();
/*     */           }
/*     */         
/*     */         }
/* 222 */         else if (!basedSequence1.isBlank()) {
/*     */           Matcher matcher1;
/* 224 */           if ((matcher1 = this.parsing.MACRO_CLOSE_END.matcher((CharSequence)basedSequence1)).find() && 
/* 225 */             basedSequence2.equals(matcher1.group(1)) && (matcher1.groupCount() < 2 || matcher1.start(2) == -1 || (matcher1.group(2).length() & 0x1) == 1)) {
/*     */             
/* 227 */             bool1 = true;
/*     */ 
/*     */ 
/*     */             
/* 231 */             (macroClose = new MacroClose(basedSequence1.subSequence(matcher1.start(), matcher1.start() + 3), basedSequence1.subSequence(matcher1.start(1), matcher1.end(1)), basedSequence1.subSequence(matcher1.end() - 2, matcher1.end()))).setCharsFromContent();
/*     */           } 
/*     */ 
/*     */           
/* 235 */           if (!bool1) {
/* 236 */             return BlockStart.none();
/*     */           }
/*     */         } 
/*     */         
/*     */         Macro macro;
/*     */         
/* 242 */         (macro = new Macro(basedSequence.subSequence(0, 2), basedSequence2, (BasedSequence)basedSequence.endSequence(bool2 ? 3 : 2))).setCharsFromContent();
/*     */ 
/*     */         
/* 245 */         if (!(basedSequence1 = (BasedSequence)basedSequence.baseSubSequence(basedSequence2.getEndOffset(), macro.getClosingMarker().getStartOffset()).trim()).isEmpty()) {
/*     */           
/* 247 */           macro.setAttributeText(basedSequence1);
/*     */ 
/*     */           
/* 250 */           Matcher matcher1 = this.parsing.MACRO_ATTRIBUTE.matcher((CharSequence)basedSequence1);
/* 251 */           while (matcher1.find()) {
/* 252 */             BasedSequence basedSequence3 = basedSequence1.subSequence(matcher1.start(1), matcher1.end(1));
/* 253 */             BasedSequence basedSequence4 = (matcher1.groupCount() == 1 || matcher1.start(2) == -1) ? BasedSequence.NULL : (BasedSequence)basedSequence1.subSequence(matcher1.end(1), matcher1.start(2)).trim();
/*     */             BasedSequence basedSequence5;
/*     */             boolean bool;
/* 256 */             BasedSequence basedSequence6 = !(bool = ((basedSequence5 = (matcher1.groupCount() == 1 || matcher1.start(2) == -1) ? BasedSequence.NULL : basedSequence1.subSequence(matcher1.start(2), matcher1.end(2))).length() >= 2 && ((basedSequence5.charAt(0) == '"' && basedSequence5.endCharAt(1) == '"') || (basedSequence5.charAt(0) == '\'' && basedSequence5.endCharAt(1) == '\''))) ? true : false) ? BasedSequence.NULL : basedSequence5.subSequence(0, 1);
/* 257 */             BasedSequence basedSequence7 = !bool ? BasedSequence.NULL : (BasedSequence)basedSequence5.endSequence(1, 0);
/*     */             
/* 259 */             if (bool) {
/* 260 */               basedSequence5 = (BasedSequence)basedSequence5.midSequence(1, -1);
/*     */             }
/*     */             
/* 263 */             MacroAttribute macroAttribute = new MacroAttribute(basedSequence3, basedSequence4, basedSequence6, basedSequence5, basedSequence7);
/* 264 */             macro.appendChild((Node)macroAttribute);
/*     */           } 
/*     */         } 
/*     */         
/* 268 */         MacroBlockParser macroBlockParser = new MacroBlockParser((DataHolder)param1ParserState.getProperties(), this.parsing, basedSequence2, bool1);
/* 269 */         if (bool1) {
/* 270 */           macroBlockParser.hadClose = true;
/*     */         }
/*     */         
/* 273 */         macroBlockParser.block.appendChild((Node)macro);
/* 274 */         if (macroClose != null) macroBlockParser.block.appendChild((Node)macroClose);
/*     */         
/* 276 */         return BlockStart.of(new BlockParser[] { (BlockParser)macroBlockParser
/* 277 */             }).atIndex(param1ParserState.getLineEndIndex());
/*     */       } 
/*     */ 
/*     */       
/* 281 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\internal\MacroBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */