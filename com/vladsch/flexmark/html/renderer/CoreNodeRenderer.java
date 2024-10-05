/*     */ package com.vladsch.flexmark.html.renderer;
/*     */ import com.vladsch.flexmark.ast.AutoLink;
/*     */ import com.vladsch.flexmark.ast.BlockQuote;
/*     */ import com.vladsch.flexmark.ast.BulletList;
/*     */ import com.vladsch.flexmark.ast.Code;
/*     */ import com.vladsch.flexmark.ast.CodeBlock;
/*     */ import com.vladsch.flexmark.ast.Emphasis;
/*     */ import com.vladsch.flexmark.ast.FencedCodeBlock;
/*     */ import com.vladsch.flexmark.ast.Heading;
/*     */ import com.vladsch.flexmark.ast.HtmlBlock;
/*     */ import com.vladsch.flexmark.ast.HtmlBlockBase;
/*     */ import com.vladsch.flexmark.ast.HtmlInlineBase;
/*     */ import com.vladsch.flexmark.ast.Image;
/*     */ import com.vladsch.flexmark.ast.ImageRef;
/*     */ import com.vladsch.flexmark.ast.IndentedCodeBlock;
/*     */ import com.vladsch.flexmark.ast.Link;
/*     */ import com.vladsch.flexmark.ast.LinkRef;
/*     */ import com.vladsch.flexmark.ast.ListItem;
/*     */ import com.vladsch.flexmark.ast.MailLink;
/*     */ import com.vladsch.flexmark.ast.OrderedList;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.Reference;
/*     */ import com.vladsch.flexmark.ast.StrongEmphasis;
/*     */ import com.vladsch.flexmark.ast.util.LineCollectingVisitor;
/*     */ import com.vladsch.flexmark.html.HtmlRendererOptions;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.html.Attributes;
/*     */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Escaping;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CoreNodeRenderer implements NodeRenderer {
/*  38 */   public static final AttributablePart LOOSE_LIST_ITEM = new AttributablePart("LOOSE_LIST_ITEM");
/*  39 */   public static final AttributablePart TIGHT_LIST_ITEM = new AttributablePart("TIGHT_LIST_ITEM");
/*  40 */   public static final AttributablePart PARAGRAPH_LINE = new AttributablePart("PARAGRAPH_LINE");
/*  41 */   public static final AttributablePart CODE_CONTENT = new AttributablePart("FENCED_CODE_CONTENT");
/*     */   
/*     */   private final ListOptions listOptions;
/*     */   
/*     */   private final boolean obfuscateEmail;
/*     */   private final boolean obfuscateEmailRandom;
/*     */   private final ReferenceRepository referenceRepository;
/*     */   private final boolean recheckUndefinedReferences;
/*     */   private final boolean codeContentBlock;
/*     */   private final boolean codeSoftLineBreaks;
/*     */   private List<Range> myLines;
/*     */   private List<Integer> myEOLs;
/*     */   private int myNextLine;
/*     */   private int nextLineStartOffset;
/*     */   
/*     */   public CoreNodeRenderer(DataHolder paramDataHolder) {
/*  57 */     this.referenceRepository = (ReferenceRepository)Parser.REFERENCES.get(paramDataHolder);
/*  58 */     this.recheckUndefinedReferences = ((Boolean)HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(paramDataHolder)).booleanValue();
/*  59 */     this.listOptions = ListOptions.get(paramDataHolder);
/*  60 */     this.obfuscateEmail = ((Boolean)HtmlRenderer.OBFUSCATE_EMAIL.get(paramDataHolder)).booleanValue();
/*  61 */     this.obfuscateEmailRandom = ((Boolean)HtmlRenderer.OBFUSCATE_EMAIL_RANDOM.get(paramDataHolder)).booleanValue();
/*  62 */     this.codeContentBlock = ((Boolean)Parser.FENCED_CODE_CONTENT_BLOCK.get(paramDataHolder)).booleanValue();
/*  63 */     this.codeSoftLineBreaks = ((Boolean)Parser.CODE_SOFT_LINE_BREAKS.get(paramDataHolder)).booleanValue();
/*  64 */     this.myLines = null;
/*  65 */     this.myEOLs = null;
/*  66 */     this.myNextLine = 0;
/*  67 */     this.nextLineStartOffset = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*  73 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler<>(AutoLink.class, this::render), new NodeRenderingHandler<>(BlockQuote.class, this::render), new NodeRenderingHandler<>(BulletList.class, this::render), new NodeRenderingHandler<>(Code.class, this::render), new NodeRenderingHandler<>(CodeBlock.class, this::render), new NodeRenderingHandler<>(Document.class, this::render), new NodeRenderingHandler<>(Emphasis.class, this::render), new NodeRenderingHandler<>(FencedCodeBlock.class, this::render), new NodeRenderingHandler<>(HardLineBreak.class, this::render), new NodeRenderingHandler<>(Heading.class, this::render), new NodeRenderingHandler<>(HtmlBlock.class, this::render), new NodeRenderingHandler<>(HtmlCommentBlock.class, this::render), new NodeRenderingHandler<>(HtmlInnerBlock.class, this::render), new NodeRenderingHandler<>(HtmlInnerBlockComment.class, this::render), new NodeRenderingHandler<>(HtmlEntity.class, this::render), new NodeRenderingHandler<>(HtmlInline.class, this::render), new NodeRenderingHandler<>(HtmlInlineComment.class, this::render), new NodeRenderingHandler<>(Image.class, this::render), new NodeRenderingHandler<>(ImageRef.class, this::render), new NodeRenderingHandler<>(IndentedCodeBlock.class, this::render), new NodeRenderingHandler<>(Link.class, this::render), new NodeRenderingHandler<>(LinkRef.class, this::render), new NodeRenderingHandler<>(BulletListItem.class, this::render), new NodeRenderingHandler<>(OrderedListItem.class, this::render), new NodeRenderingHandler<>(MailLink.class, this::render), new NodeRenderingHandler<>(OrderedList.class, this::render), new NodeRenderingHandler<>(Paragraph.class, this::render), new NodeRenderingHandler<>(Reference.class, this::render), new NodeRenderingHandler<>(SoftLineBreak.class, this::render), new NodeRenderingHandler<>(StrongEmphasis.class, this::render), new NodeRenderingHandler<>(Text.class, this::render), new NodeRenderingHandler<>(TextBase.class, this::render), new NodeRenderingHandler<>(ThematicBreak.class, this::render) }));
/*     */   }
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
/*     */   void render(Document paramDocument, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 113 */     paramNodeRendererContext.renderChildren((Node)paramDocument);
/*     */   }
/*     */   
/*     */   void render(Heading paramHeading, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     String str;
/* 118 */     if ((paramNodeRendererContext.getHtmlOptions()).renderHeaderId && (
/*     */       
/* 120 */       str = paramNodeRendererContext.getNodeId((Node)paramHeading)) != null) {
/* 121 */       paramHtmlWriter.attr("id", str);
/*     */     }
/*     */ 
/*     */     
/* 125 */     if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 126 */       paramHtmlWriter.srcPos(paramHeading.getChars()).withAttr().tagLine("h" + paramHeading.getLevel(), () -> {
/*     */             paramHtmlWriter.srcPos(paramHeading.getText()).withAttr().tag("span"); paramNodeRendererContext.renderChildren((Node)paramHeading);
/*     */             paramHtmlWriter.tag("/span");
/*     */           });
/*     */       return;
/*     */     } 
/* 132 */     paramHtmlWriter.srcPos(paramHeading.getText()).withAttr().tagLine("h" + paramHeading.getLevel(), () -> paramNodeRendererContext.renderChildren((Node)paramHeading));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(BlockQuote paramBlockQuote, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 138 */     paramHtmlWriter.withAttr().tagLineIndent("blockquote", () -> paramNodeRendererContext.renderChildren((Node)paramBlockQuote));
/*     */   }
/*     */   
/*     */   void render(FencedCodeBlock paramFencedCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 142 */     paramHtmlWriter.line();
/* 143 */     ((HtmlWriter)paramHtmlWriter.srcPosWithTrailingEOL(paramFencedCodeBlock.getChars()).withAttr().tag("pre")).openPre();
/*     */     
/* 145 */     BasedSequence basedSequence = paramFencedCodeBlock.getInfo();
/* 146 */     HtmlRendererOptions htmlRendererOptions = paramNodeRendererContext.getHtmlOptions();
/* 147 */     if (basedSequence.isNotNull() && !basedSequence.isBlank()) {
/* 148 */       String str = paramFencedCodeBlock.getInfoDelimitedByAny(htmlRendererOptions.languageDelimiterSet).unescape();
/* 149 */       str = (String)htmlRendererOptions.languageClassMap.getOrDefault(str, htmlRendererOptions.languageClassPrefix + str);
/* 150 */       paramHtmlWriter.attr("class", str);
/*     */     } else {
/*     */       String str;
/* 153 */       if (!(str = htmlRendererOptions.noLanguageClass.trim()).isEmpty()) {
/* 154 */         paramHtmlWriter.attr("class", str);
/*     */       }
/*     */     } 
/*     */     
/* 158 */     paramHtmlWriter.srcPosWithEOL(paramFencedCodeBlock.getContentChars()).withAttr(CODE_CONTENT).tag("code");
/* 159 */     if (this.codeContentBlock) {
/* 160 */       paramNodeRendererContext.renderChildren((Node)paramFencedCodeBlock);
/*     */     } else {
/* 162 */       paramHtmlWriter.text(paramFencedCodeBlock.getContentChars().normalizeEOL());
/*     */     } 
/* 164 */     paramHtmlWriter.tag("/code");
/* 165 */     ((HtmlWriter)paramHtmlWriter.tag("/pre")).closePre();
/* 166 */     paramHtmlWriter.lineIf(htmlRendererOptions.htmlBlockCloseTagEol);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(ThematicBreak paramThematicBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 171 */     paramHtmlWriter.srcPos(paramThematicBreak.getChars()).withAttr().tagVoidLine("hr");
/*     */   }
/*     */   
/*     */   void render(IndentedCodeBlock paramIndentedCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 175 */     paramHtmlWriter.line();
/* 176 */     ((HtmlWriter)paramHtmlWriter.srcPosWithEOL(paramIndentedCodeBlock.getChars()).withAttr().tag("pre")).openPre();
/*     */     
/*     */     String str;
/* 179 */     if (!(str = (paramNodeRendererContext.getHtmlOptions()).noLanguageClass.trim()).isEmpty()) {
/* 180 */       paramHtmlWriter.attr("class", str);
/*     */     }
/*     */     
/* 183 */     paramHtmlWriter.srcPosWithEOL(paramIndentedCodeBlock.getContentChars()).withAttr(CODE_CONTENT).tag("code");
/* 184 */     if (this.codeContentBlock) {
/* 185 */       paramNodeRendererContext.renderChildren((Node)paramIndentedCodeBlock);
/*     */     } else {
/* 187 */       paramHtmlWriter.text(((BasedSequence)paramIndentedCodeBlock.getContentChars().trimTailBlankLines()).normalizeEndWithEOL());
/*     */     } 
/* 189 */     paramHtmlWriter.tag("/code");
/* 190 */     ((HtmlWriter)paramHtmlWriter.tag("/pre")).closePre();
/* 191 */     paramHtmlWriter.lineIf((paramNodeRendererContext.getHtmlOptions()).htmlBlockCloseTagEol);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(CodeBlock paramCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 196 */     if (paramCodeBlock.getParent() instanceof IndentedCodeBlock) {
/* 197 */       paramHtmlWriter.text(((BasedSequence)paramCodeBlock.getContentChars().trimTailBlankLines()).normalizeEndWithEOL()); return;
/*     */     } 
/* 199 */     paramHtmlWriter.text(paramCodeBlock.getContentChars().normalizeEOL());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(BulletList paramBulletList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 205 */     paramHtmlWriter.withAttr().tagIndent("ul", () -> paramNodeRendererContext.renderChildren((Node)paramBulletList));
/*     */   }
/*     */   
/*     */   void render(OrderedList paramOrderedList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 209 */     int i = paramOrderedList.getStartNumber();
/* 210 */     if (this.listOptions.isOrderedListManualStart() && i != 1) paramHtmlWriter.attr("start", String.valueOf(i)); 
/* 211 */     paramHtmlWriter.withAttr().tagIndent("ol", () -> paramNodeRendererContext.renderChildren((Node)paramOrderedList));
/*     */   }
/*     */   
/*     */   void render(BulletListItem paramBulletListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 215 */     renderListItem((ListItem)paramBulletListItem, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   void render(OrderedListItem paramOrderedListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 219 */     renderListItem((ListItem)paramOrderedListItem, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void renderListItem(ListItem paramListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 223 */     if (this.listOptions.isTightListItem(paramListItem)) {
/* 224 */       ((HtmlWriter)paramHtmlWriter.srcPosWithEOL(paramListItem.getChars()).withAttr(TIGHT_LIST_ITEM).withCondIndent()).tagLine("li", () -> {
/*     */             paramHtmlWriter.text(paramListItem.getMarkerSuffix().unescape()); paramNodeRendererContext.renderChildren((Node)paramListItem);
/*     */           });
/*     */       return;
/*     */     } 
/* 229 */     ((HtmlWriter)paramHtmlWriter.srcPosWithEOL(paramListItem.getChars()).withAttr(LOOSE_LIST_ITEM).withCondIndent()).tagLine("li", () -> {
/*     */           paramHtmlWriter.text(paramListItem.getMarkerSuffix().unescape());
/*     */           paramNodeRendererContext.renderChildren((Node)paramListItem);
/*     */         });
/*     */   }
/*     */   
/*     */   public void renderTextBlockParagraphLines(Paragraph paramParagraph, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, boolean paramBoolean) {
/*     */     LineCollectingVisitor lineCollectingVisitor;
/* 237 */     if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines && 
/* 238 */       paramParagraph.hasChildren()) {
/* 239 */       lineCollectingVisitor = new LineCollectingVisitor();
/* 240 */       this.myLines = lineCollectingVisitor.collectAndGetRanges((Node)paramParagraph);
/* 241 */       this.myEOLs = lineCollectingVisitor.getEOLs();
/* 242 */       this.myNextLine = 0;
/*     */       
/* 244 */       if (paramParagraph.getFirstChild() != null) {
/* 245 */         outputSourceLineSpan((Node)paramParagraph, paramParagraph.getFirstChild(), (Node)paramParagraph, paramHtmlWriter);
/*     */       }
/* 247 */       paramNodeRendererContext.renderChildren((Node)paramParagraph);
/* 248 */       paramHtmlWriter.tag("/span");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 253 */     if (lineCollectingVisitor != null) {
/* 254 */       paramHtmlWriter.withAttr().tag("span", false, false, () -> paramNodeRendererContext.renderChildren((Node)paramParagraph)); return;
/*     */     } 
/* 256 */     paramNodeRendererContext.renderChildren((Node)paramParagraph);
/*     */   }
/*     */ 
/*     */   
/*     */   private void outputSourceLineSpan(Node paramNode1, Node paramNode2, Node paramNode3, HtmlWriter paramHtmlWriter) {
/* 261 */     int i = paramNode2.getStartOffset();
/* 262 */     Range range = this.myLines.get(this.myNextLine);
/* 263 */     int k = ((Integer)this.myEOLs.get(this.myNextLine)).intValue();
/*     */ 
/*     */     
/* 266 */     int j = paramNode3.getEndOffset();
/* 267 */     if (range.getEnd() <= j) {
/*     */ 
/*     */       
/* 270 */       j = (j = (j = range.getEnd()) - k) - paramNode1.baseSubSequence(i, j).countTrailing(CharPredicate.SPACE_TAB);
/* 271 */       this.myNextLine++;
/* 272 */       this.nextLineStartOffset = range.getEnd();
/* 273 */       this.nextLineStartOffset += paramNode1.baseSubSequence(this.nextLineStartOffset, paramNode1.getEndOffset()).countLeading(CharPredicate.SPACE_TAB);
/*     */     } 
/*     */     
/* 276 */     if (range.getStart() > i) {
/* 277 */       i = range.getStart();
/*     */     }
/*     */     
/* 280 */     paramHtmlWriter.srcPos(i, j).withAttr(PARAGRAPH_LINE).tag("span");
/*     */   }
/*     */   
/*     */   private void outputNextLineBreakSpan(Node paramNode, HtmlWriter paramHtmlWriter, boolean paramBoolean) {
/* 284 */     Range range = this.myLines.get(this.myNextLine);
/* 285 */     int i = ((Integer)this.myEOLs.get(this.myNextLine)).intValue();
/* 286 */     this.myNextLine++;
/*     */ 
/*     */     
/* 289 */     int j = paramNode.baseSubSequence(this.nextLineStartOffset, range.getEnd() - i).countTrailing(CharPredicate.SPACE_TAB);
/* 290 */     if (!paramBoolean && j > 0) {
/* 291 */       j--;
/*     */     }
/* 293 */     i += j;
/*     */     
/* 295 */     paramHtmlWriter.srcPos(this.nextLineStartOffset, range.getEnd() - i).withAttr(PARAGRAPH_LINE).tag("span");
/* 296 */     this.nextLineStartOffset = range.getEnd();
/*     */ 
/*     */     
/* 299 */     this.nextLineStartOffset += paramNode.baseSubSequence(this.nextLineStartOffset, paramNode.getChars().getBaseSequence().length()).countLeading(CharPredicate.SPACE_TAB);
/*     */   }
/*     */   
/*     */   private void renderLooseParagraph(Paragraph paramParagraph, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 303 */     if ((paramNodeRendererContext.getHtmlOptions()).noPTagsUseBr) {
/* 304 */       renderTextBlockParagraphLines(paramParagraph, paramNodeRendererContext, paramHtmlWriter, false);
/* 305 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.tagVoid("br")).tagVoid("br")).line(); return;
/*     */     } 
/* 307 */     paramHtmlWriter.srcPosWithEOL(paramParagraph.getChars()).withAttr().tagLine("p", () -> renderTextBlockParagraphLines(paramParagraph, paramNodeRendererContext, paramHtmlWriter, false));
/*     */   }
/*     */ 
/*     */   
/*     */   void render(Paragraph paramParagraph, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 312 */     if (paramParagraph.getFirstChildAnyNot(new Class[] { NonRenderingInline.class }) != null) {
/* 313 */       if (!(paramParagraph.getParent() instanceof ParagraphItemContainer) || 
/* 314 */         !((ParagraphItemContainer)paramParagraph.getParent()).isParagraphWrappingDisabled(paramParagraph, this.listOptions, paramNodeRendererContext.getOptions())) {
/* 315 */         renderLooseParagraph(paramParagraph, paramNodeRendererContext, paramHtmlWriter); return;
/*     */       } 
/* 317 */       renderTextBlockParagraphLines(paramParagraph, paramNodeRendererContext, paramHtmlWriter, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean renderLineBreak(String paramString1, String paramString2, Node paramNode, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 323 */     if (this.myLines != null && this.myNextLine < this.myLines.size()) {
/*     */       boolean bool;
/*     */       
/*     */       List<?> list;
/*     */       
/*     */       int i;
/* 329 */       if (!(bool = ((i = (list = paramHtmlWriter.getOpenTagsAfterLast("span")).size()) == 0 || paramString2 == null || !paramString2.equalsIgnoreCase((String)list.get(i - 1))) ? true : false) && !paramHtmlWriter.isPendingSpace())
/*     */       {
/* 331 */         paramHtmlWriter.raw(" ");
/*     */       }
/*     */       
/* 334 */       for (i = i; i-- > 0;) {
/* 335 */         paramHtmlWriter.closeTag((CharSequence)list.get(i));
/*     */       }
/*     */       
/* 338 */       paramHtmlWriter.tag("/span");
/*     */       
/* 340 */       if (bool) {
/* 341 */         paramHtmlWriter.raw(paramString1);
/*     */       }
/*     */       
/* 344 */       outputNextLineBreakSpan(paramNode, paramHtmlWriter, bool);
/*     */       
/* 346 */       for (String paramString1 : list) {
/* 347 */         if (!bool && (paramNodeRendererContext.getHtmlOptions()).inlineCodeSpliceClass != null && !(paramNodeRendererContext.getHtmlOptions()).inlineCodeSpliceClass.isEmpty()) {
/* 348 */           ((HtmlWriter)paramHtmlWriter.attr("class", (paramNodeRendererContext.getHtmlOptions()).inlineCodeSpliceClass)).withAttr().tag(paramString1); continue;
/*     */         } 
/* 350 */         paramHtmlWriter.tag(paramString1);
/*     */       } 
/*     */       
/* 353 */       return true;
/*     */     } 
/* 355 */     return false;
/*     */   }
/*     */   
/*     */   void render(SoftLineBreak paramSoftLineBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 359 */     String str = (paramNodeRendererContext.getHtmlOptions()).softBreak;
/* 360 */     if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines && 
/* 361 */       renderLineBreak(str, (str.equals("\n") || str.equals("\r\n") || str.equals("\r")) ? "code" : null, (Node)paramSoftLineBreak, paramNodeRendererContext, paramHtmlWriter)) {
/*     */       return;
/*     */     }
/*     */     
/* 365 */     paramHtmlWriter.raw(str);
/*     */   }
/*     */   
/*     */   void render(HardLineBreak paramHardLineBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 369 */     if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines && 
/* 370 */       renderLineBreak((paramNodeRendererContext.getHtmlOptions()).hardBreak, null, (Node)paramHardLineBreak, paramNodeRendererContext, paramHtmlWriter)) {
/*     */       return;
/*     */     }
/*     */     
/* 374 */     paramHtmlWriter.raw((paramNodeRendererContext.getHtmlOptions()).hardBreak);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(Emphasis paramEmphasis, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     HtmlRendererOptions htmlRendererOptions;
/* 380 */     if ((htmlRendererOptions = paramNodeRendererContext.getHtmlOptions()).emphasisStyleHtmlOpen == null || htmlRendererOptions.emphasisStyleHtmlClose == null) {
/* 381 */       if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 382 */         paramHtmlWriter.withAttr().tag("em");
/*     */       } else {
/* 384 */         paramHtmlWriter.srcPos(paramEmphasis.getText()).withAttr().tag("em");
/*     */       } 
/* 386 */       paramNodeRendererContext.renderChildren((Node)paramEmphasis);
/* 387 */       paramHtmlWriter.tag("/em"); return;
/*     */     } 
/* 389 */     paramHtmlWriter.raw(htmlRendererOptions.emphasisStyleHtmlOpen);
/* 390 */     paramNodeRendererContext.renderChildren((Node)paramEmphasis);
/* 391 */     paramHtmlWriter.raw(htmlRendererOptions.emphasisStyleHtmlClose);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(StrongEmphasis paramStrongEmphasis, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     HtmlRendererOptions htmlRendererOptions;
/* 398 */     if ((htmlRendererOptions = paramNodeRendererContext.getHtmlOptions()).strongEmphasisStyleHtmlOpen == null || htmlRendererOptions.strongEmphasisStyleHtmlClose == null) {
/* 399 */       if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 400 */         paramHtmlWriter.withAttr().tag("strong");
/*     */       } else {
/* 402 */         paramHtmlWriter.srcPos(paramStrongEmphasis.getText()).withAttr().tag("strong");
/*     */       } 
/* 404 */       paramNodeRendererContext.renderChildren((Node)paramStrongEmphasis);
/* 405 */       paramHtmlWriter.tag("/strong"); return;
/*     */     } 
/* 407 */     paramHtmlWriter.raw(htmlRendererOptions.strongEmphasisStyleHtmlOpen);
/* 408 */     paramNodeRendererContext.renderChildren((Node)paramStrongEmphasis);
/* 409 */     paramHtmlWriter.raw(htmlRendererOptions.strongEmphasisStyleHtmlClose);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Text paramText, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 415 */     paramHtmlWriter.text(Escaping.normalizeEOL(paramText.getChars().unescape()));
/*     */   }
/*     */ 
/*     */   
/*     */   void render(TextBase paramTextBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 420 */     paramNodeRendererContext.renderChildren((Node)paramTextBase);
/*     */   }
/*     */   void render(Code paramCode, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     ReversiblePeekingIterator<Node> reversiblePeekingIterator;
/*     */     HtmlRendererOptions htmlRendererOptions;
/* 425 */     if ((htmlRendererOptions = paramNodeRendererContext.getHtmlOptions()).codeStyleHtmlOpen == null || htmlRendererOptions.codeStyleHtmlClose == null) {
/* 426 */       if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 427 */         paramHtmlWriter.withAttr().tag("code");
/*     */       } else {
/* 429 */         paramHtmlWriter.srcPos(paramCode.getText()).withAttr().tag("code");
/*     */       } 
/* 431 */       if (this.codeSoftLineBreaks && !htmlRendererOptions.isSoftBreakAllSpaces) {
/* 432 */         for (reversiblePeekingIterator = paramCode.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) {
/* 433 */           Node node; if (node = reversiblePeekingIterator.next() instanceof Text) {
/* 434 */             paramHtmlWriter.text(Escaping.collapseWhitespace((CharSequence)node.getChars(), true)); continue;
/*     */           } 
/* 436 */           paramNodeRendererContext.render(node);
/*     */         } 
/*     */       } else {
/*     */         
/* 440 */         paramHtmlWriter.text(Escaping.collapseWhitespace((CharSequence)reversiblePeekingIterator.getText(), true));
/*     */       } 
/* 442 */       paramHtmlWriter.tag("/code"); return;
/*     */     } 
/* 444 */     paramHtmlWriter.raw(htmlRendererOptions.codeStyleHtmlOpen);
/* 445 */     if (this.codeSoftLineBreaks && !htmlRendererOptions.isSoftBreakAllSpaces) {
/* 446 */       for (reversiblePeekingIterator = reversiblePeekingIterator.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) {
/* 447 */         Node node; if (node = reversiblePeekingIterator.next() instanceof Text) {
/* 448 */           paramHtmlWriter.text(Escaping.collapseWhitespace((CharSequence)node.getChars(), true)); continue;
/*     */         } 
/* 450 */         paramNodeRendererContext.render(node);
/*     */       } 
/*     */     } else {
/*     */       
/* 454 */       paramHtmlWriter.text(Escaping.collapseWhitespace((CharSequence)reversiblePeekingIterator.getText(), true));
/*     */     } 
/* 456 */     paramHtmlWriter.raw(htmlRendererOptions.codeStyleHtmlClose);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(HtmlBlock paramHtmlBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 462 */     paramHtmlWriter.line();
/*     */     
/*     */     HtmlRendererOptions htmlRendererOptions;
/* 465 */     if ((htmlRendererOptions = paramNodeRendererContext.getHtmlOptions()).sourceWrapHtmlBlocks) {
/* 466 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPos(paramHtmlBlock.getChars()).withAttr(AttributablePart.NODE_POSITION).tag("div")).indent()).line();
/*     */     }
/*     */     
/* 469 */     if (paramHtmlBlock.hasChildren()) {
/*     */       
/* 471 */       paramNodeRendererContext.renderChildren((Node)paramHtmlBlock);
/*     */     } else {
/* 473 */       renderHtmlBlock((HtmlBlockBase)paramHtmlBlock, paramNodeRendererContext, paramHtmlWriter, htmlRendererOptions.suppressHtmlBlocks, htmlRendererOptions.escapeHtmlBlocks, false);
/*     */     } 
/*     */     
/* 476 */     if (htmlRendererOptions.sourceWrapHtmlBlocks) {
/* 477 */       ((HtmlWriter)paramHtmlWriter.unIndent()).tag("/div");
/*     */     }
/*     */     
/* 480 */     paramHtmlWriter.lineIf(htmlRendererOptions.htmlBlockCloseTagEol);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(HtmlCommentBlock paramHtmlCommentBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 485 */     renderHtmlBlock((HtmlBlockBase)paramHtmlCommentBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlCommentBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlCommentBlocks, false);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(HtmlInnerBlock paramHtmlInnerBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 490 */     renderHtmlBlock((HtmlBlockBase)paramHtmlInnerBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlBlocks, false);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(HtmlInnerBlockComment paramHtmlInnerBlockComment, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 495 */     renderHtmlBlock((HtmlBlockBase)paramHtmlInnerBlockComment, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlCommentBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlCommentBlocks, false);
/*     */   }
/*     */   
/*     */   public static void renderHtmlBlock(HtmlBlockBase paramHtmlBlockBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 499 */     if (paramBoolean1)
/*     */       return; 
/* 501 */     if (paramHtmlBlockBase instanceof HtmlBlock) {
/* 502 */       paramHtmlWriter.line();
/*     */     }
/* 504 */     String str = (paramHtmlBlockBase instanceof HtmlBlock) ? paramHtmlBlockBase.getContentChars().normalizeEOL() : paramHtmlBlockBase.getChars().normalizeEOL();
/*     */     
/* 506 */     if (paramBoolean3) {
/* 507 */       str = str.trim();
/*     */     }
/*     */     
/* 510 */     if (paramBoolean2) {
/* 511 */       if (paramHtmlBlockBase instanceof HtmlBlock) {
/* 512 */         if (str.length() > 0 && str.charAt(str.length() - 1) == '\n')
/*     */         {
/* 514 */           str = str.substring(0, str.length() - 1);
/*     */         }
/* 516 */         ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("<p>")).text(str)).raw("</p>");
/*     */       } else {
/* 518 */         paramHtmlWriter.text(str);
/*     */       } 
/*     */     } else {
/* 521 */       paramHtmlWriter.rawPre(str);
/*     */     } 
/*     */     
/* 524 */     if (paramHtmlBlockBase instanceof HtmlBlock) {
/* 525 */       paramHtmlWriter.lineIf((paramNodeRendererContext.getHtmlOptions()).htmlBlockCloseTagEol);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(HtmlInline paramHtmlInline, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 534 */     renderInlineHtml((HtmlInlineBase)paramHtmlInline, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressInlineHtml, (paramNodeRendererContext.getHtmlOptions()).escapeInlineHtml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(HtmlInlineComment paramHtmlInlineComment, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 542 */     renderInlineHtml((HtmlInlineBase)paramHtmlInlineComment, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressInlineHtmlComments, (paramNodeRendererContext.getHtmlOptions()).escapeInlineHtmlComments);
/*     */   }
/*     */   
/*     */   public static void renderInlineHtml(HtmlInlineBase paramHtmlInlineBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, boolean paramBoolean1, boolean paramBoolean2) {
/* 546 */     if (paramBoolean1)
/*     */       return; 
/* 548 */     if (paramBoolean2) {
/* 549 */       paramHtmlWriter.text(paramHtmlInlineBase.getChars().normalizeEOL()); return;
/*     */     } 
/* 551 */     paramHtmlWriter.rawPre(paramHtmlInlineBase.getChars().normalizeEOL());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Reference paramReference, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void render(HtmlEntity paramHtmlEntity, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 561 */     if ((paramNodeRendererContext.getHtmlOptions()).unescapeHtmlEntities) {
/* 562 */       paramHtmlWriter.text(paramHtmlEntity.getChars().unescape()); return;
/*     */     } 
/* 564 */     paramHtmlWriter.raw(paramHtmlEntity.getChars().unescapeNoEntities());
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSuppressedLinkPrefix(CharSequence paramCharSequence, NodeRendererContext paramNodeRendererContext) {
/*     */     Pattern pattern;
/* 570 */     if ((pattern = (paramNodeRendererContext.getHtmlOptions()).suppressedLinks) != null) {
/*     */       Matcher matcher;
/* 572 */       return (matcher = pattern.matcher(paramCharSequence)).matches();
/*     */     } 
/* 574 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void render(AutoLink paramAutoLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 579 */     String str = paramAutoLink.getText().toString();
/* 580 */     if (paramNodeRendererContext.isDoNotRenderLinks() || isSuppressedLinkPrefix((CharSequence)paramAutoLink.getUrl(), paramNodeRendererContext)) {
/* 581 */       paramHtmlWriter.text(str); return;
/*     */     } 
/* 583 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, str, null);
/* 584 */     ((HtmlWriter)paramHtmlWriter.srcPos(paramAutoLink.getText()).attr("href", resolvedLink.getUrl().startsWith("www.") ? ((paramNodeRendererContext.getHtmlOptions()).autolinkWwwPrefix + resolvedLink.getUrl()) : resolvedLink.getUrl()))
/* 585 */       .withAttr(resolvedLink)
/* 586 */       .tag("a", false, false, () -> paramHtmlWriter.text(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   void render(MailLink paramMailLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 591 */     String str1 = paramMailLink.getText().unescape();
/* 592 */     if (paramNodeRendererContext.isDoNotRenderLinks() || isSuppressedLinkPrefix((CharSequence)paramMailLink.getUrl(), paramNodeRendererContext)) {
/* 593 */       paramHtmlWriter.text(str1); return;
/*     */     } 
/* 595 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, str1, null);
/* 596 */     if (this.obfuscateEmail) {
/* 597 */       String str = Escaping.obfuscate("mailto:" + resolvedLink.getUrl(), this.obfuscateEmailRandom);
/* 598 */       str1 = Escaping.obfuscate(str1, true);
/*     */       
/* 600 */       ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPos(paramMailLink.getText()).attr("href", str))
/* 601 */         .withAttr(resolvedLink)
/* 602 */         .tag("a"))
/* 603 */         .raw(str1))
/* 604 */         .tag("/a"); return;
/*     */     } 
/* 606 */     String str2 = resolvedLink.getUrl();
/* 607 */     ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPos(paramMailLink.getText()).attr("href", "mailto:" + str2))
/* 608 */       .withAttr(resolvedLink)
/* 609 */       .tag("a"))
/* 610 */       .text(str1))
/* 611 */       .tag("/a");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Image paramImage, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 618 */     if (!paramNodeRendererContext.isDoNotRenderLinks() && !isSuppressedLinkPrefix((CharSequence)paramImage.getUrl(), paramNodeRendererContext)) {
/* 619 */       String str1 = (new TextCollectingVisitor()).collectAndGetText((Node)paramImage);
/*     */       ResolvedLink resolvedLink;
/* 621 */       String str2 = (resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, paramImage.getUrl().unescape(), null, null)).getUrl();
/*     */       
/* 623 */       if (!paramImage.getUrlContent().isEmpty()) {
/*     */         
/* 625 */         String str = Escaping.percentEncodeUrl((CharSequence)paramImage.getUrlContent()).replace("+", "%2B").replace("%3D", "=").replace("%26", "&amp;");
/* 626 */         str2 = str2 + str;
/*     */       } 
/*     */       
/* 629 */       paramHtmlWriter.attr("src", str2);
/* 630 */       paramHtmlWriter.attr("alt", str1);
/*     */ 
/*     */       
/* 633 */       if (paramImage.getTitle().isNotNull()) {
/* 634 */         resolvedLink = resolvedLink.withTitle(paramImage.getTitle().unescape());
/*     */       }
/*     */       
/* 637 */       paramHtmlWriter.attr(resolvedLink.getNonNullAttributes());
/* 638 */       paramHtmlWriter.srcPos(paramImage.getChars()).withAttr(resolvedLink).tagVoid("img");
/*     */     } 
/*     */   }
/*     */   
/*     */   void render(Link paramLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 643 */     if (paramNodeRendererContext.isDoNotRenderLinks() || isSuppressedLinkPrefix((CharSequence)paramLink.getUrl(), paramNodeRendererContext)) {
/* 644 */       paramNodeRendererContext.renderChildren((Node)paramLink); return;
/*     */     } 
/* 646 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramLink.getUrl().unescape(), null, null);
/*     */     
/* 648 */     paramHtmlWriter.attr("href", resolvedLink.getUrl());
/*     */ 
/*     */     
/* 651 */     if (paramLink.getTitle().isNotNull()) {
/* 652 */       resolvedLink = resolvedLink.withTitle(paramLink.getTitle().unescape());
/*     */     }
/*     */     
/* 655 */     paramHtmlWriter.attr(resolvedLink.getNonNullAttributes());
/* 656 */     paramHtmlWriter.srcPos(paramLink.getChars()).withAttr(resolvedLink).tag("a");
/* 657 */     renderChildrenSourceLineWrapped((Node)paramLink, paramLink.getText(), paramNodeRendererContext, paramHtmlWriter);
/* 658 */     paramHtmlWriter.tag("/a");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderChildrenSourceLineWrapped(Node paramNode, BasedSequence paramBasedSequence, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 669 */     if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines && paramBasedSequence.indexOfAny(CharPredicate.ANY_EOL) >= 0) {
/* 670 */       if (this.myNextLine > 0) {
/* 671 */         this.myNextLine--;
/*     */       }
/*     */       
/* 674 */       outputSourceLineSpan(paramNode, paramNode, paramNode, paramHtmlWriter);
/* 675 */       paramNodeRendererContext.renderChildren(paramNode);
/* 676 */       paramHtmlWriter.tag("/span"); return;
/*     */     } 
/* 678 */     paramNodeRendererContext.renderChildren(paramNode);
/*     */   }
/*     */ 
/*     */   
/*     */   void render(ImageRef paramImageRef, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     ResolvedLink resolvedLink;
/* 684 */     boolean bool = false;
/*     */     
/* 686 */     if (!paramImageRef.isDefined() && this.recheckUndefinedReferences && 
/* 687 */       paramImageRef.getReferenceNode(this.referenceRepository) != null) {
/* 688 */       paramImageRef.setDefined(true);
/*     */     }
/*     */ 
/*     */     
/* 692 */     Reference reference = null;
/*     */     
/* 694 */     if (paramImageRef.isDefined()) {
/*     */       String str;
/*     */       
/* 697 */       bool = isSuppressedLinkPrefix(str = (reference = paramImageRef.getReferenceNode(this.referenceRepository)).getUrl().unescape(), paramNodeRendererContext);
/*     */       
/* 699 */       resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, str, null, null);
/* 700 */       if (reference.getTitle().isNotNull()) {
/* 701 */         resolvedLink = resolvedLink.withTitle(reference.getTitle().unescape());
/*     */       }
/*     */     } else {
/*     */       
/* 705 */       String str = this.referenceRepository.normalizeKey((CharSequence)paramImageRef.getReference());
/*     */       
/* 707 */       if ((resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE_REF, str, null, null)).getStatus() == LinkStatus.UNKNOWN || resolvedLink.getUrl().isEmpty()) {
/* 708 */         resolvedLink = null;
/*     */       }
/*     */     } 
/*     */     
/* 712 */     if (resolvedLink == null) {
/*     */       
/* 714 */       paramHtmlWriter.text(paramImageRef.getChars().unescape()); return;
/*     */     } 
/* 716 */     if (!paramNodeRendererContext.isDoNotRenderLinks() && !bool) {
/* 717 */       MutableAttributes mutableAttributes; String str = (new TextCollectingVisitor()).collectAndGetText((Node)paramImageRef);
/* 718 */       Attributes attributes = resolvedLink.getNonNullAttributes();
/*     */       
/* 720 */       paramHtmlWriter.attr("src", resolvedLink.getUrl());
/* 721 */       paramHtmlWriter.attr("alt", str);
/*     */ 
/*     */       
/* 724 */       if (reference != null) {
/* 725 */         mutableAttributes = paramNodeRendererContext.extendRenderingNodeAttributes((Node)reference, AttributablePart.NODE, attributes);
/*     */       }
/*     */       
/* 728 */       paramHtmlWriter.attr((Attributes)mutableAttributes);
/* 729 */       paramHtmlWriter.srcPos(paramImageRef.getChars()).withAttr(resolvedLink).tagVoid("img");
/*     */     } 
/*     */   }
/*     */   
/*     */   void render(LinkRef paramLinkRef, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     ResolvedLink resolvedLink;
/*     */     MutableAttributes mutableAttributes;
/* 736 */     boolean bool = false;
/*     */     
/* 738 */     if (!paramLinkRef.isDefined() && this.recheckUndefinedReferences && 
/* 739 */       paramLinkRef.getReferenceNode(this.referenceRepository) != null) {
/* 740 */       paramLinkRef.setDefined(true);
/*     */     }
/*     */ 
/*     */     
/* 744 */     Reference reference = null;
/* 745 */     if (paramLinkRef.isDefined()) {
/*     */       String str;
/*     */       
/* 748 */       bool = isSuppressedLinkPrefix(str = (reference = paramLinkRef.getReferenceNode(this.referenceRepository)).getUrl().unescape(), paramNodeRendererContext);
/*     */       
/* 750 */       resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, str, null, null);
/* 751 */       if (reference.getTitle().isNotNull()) {
/* 752 */         resolvedLink = resolvedLink.withTitle(reference.getTitle().unescape());
/*     */       }
/*     */     } else {
/*     */       
/* 756 */       String str = paramLinkRef.getReference().unescape();
/*     */       
/* 758 */       if ((resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK_REF, str, null, null)).getStatus() == LinkStatus.UNKNOWN || resolvedLink.getUrl().isEmpty()) {
/* 759 */         resolvedLink = null;
/*     */       }
/*     */     } 
/*     */     
/* 763 */     if (resolvedLink == null) {
/*     */       
/* 765 */       assert !paramLinkRef.isDefined();
/* 766 */       if (!paramLinkRef.hasChildren()) {
/* 767 */         paramHtmlWriter.text(paramLinkRef.getChars().unescape()); return;
/*     */       } 
/* 769 */       paramHtmlWriter.text(paramLinkRef.getChars().prefixOf(paramLinkRef.getChildChars()).unescape());
/* 770 */       renderChildrenSourceLineWrapped((Node)paramLinkRef, paramLinkRef.getText(), paramNodeRendererContext, paramHtmlWriter);
/* 771 */       paramHtmlWriter.text(paramLinkRef.getChars().suffixOf(paramLinkRef.getChildChars()).unescape());
/*     */       return;
/*     */     } 
/* 774 */     if (paramNodeRendererContext.isDoNotRenderLinks() || bool) {
/* 775 */       paramNodeRendererContext.renderChildren((Node)paramLinkRef); return;
/*     */     } 
/* 777 */     Attributes attributes = resolvedLink.getNonNullAttributes();
/*     */     
/* 779 */     paramHtmlWriter.attr("href", resolvedLink.getUrl());
/*     */     
/* 781 */     if (reference != null) {
/* 782 */       mutableAttributes = paramNodeRendererContext.extendRenderingNodeAttributes((Node)reference, AttributablePart.NODE, attributes);
/*     */     }
/*     */     
/* 785 */     paramHtmlWriter.attr((Attributes)mutableAttributes);
/* 786 */     paramHtmlWriter.srcPos(paramLinkRef.getChars()).withAttr(resolvedLink).tag("a");
/* 787 */     renderChildrenSourceLineWrapped((Node)paramLinkRef, paramLinkRef.getText(), paramNodeRendererContext, paramHtmlWriter);
/* 788 */     paramHtmlWriter.tag("/a");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 797 */       return new CoreNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\CoreNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */