/*     */ package com.vladsch.flexmark.youtrack.converter.internal;
/*     */ import com.vladsch.flexmark.ast.BlockQuote;
/*     */ import com.vladsch.flexmark.ast.BulletList;
/*     */ import com.vladsch.flexmark.ast.FencedCodeBlock;
/*     */ import com.vladsch.flexmark.ast.Heading;
/*     */ import com.vladsch.flexmark.ast.HtmlBlock;
/*     */ import com.vladsch.flexmark.ast.HtmlBlockBase;
/*     */ import com.vladsch.flexmark.ast.HtmlInlineBase;
/*     */ import com.vladsch.flexmark.ast.ImageRef;
/*     */ import com.vladsch.flexmark.ast.Link;
/*     */ import com.vladsch.flexmark.ast.LinkRef;
/*     */ import com.vladsch.flexmark.ast.ListBlock;
/*     */ import com.vladsch.flexmark.ast.ListItem;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.Reference;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.LinkType;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public class YouTrackConverterNodeRenderer implements NodeRenderer {
/*     */   private final ReferenceRepository referenceRepository;
/*  28 */   private int inBlockQuote = 0; private final ListOptions listOptions;
/*     */   private final boolean recheckUndefinedReferences;
/*     */   
/*     */   public YouTrackConverterNodeRenderer(DataHolder paramDataHolder) {
/*  32 */     this.referenceRepository = (ReferenceRepository)Parser.REFERENCES.get(paramDataHolder);
/*  33 */     this.recheckUndefinedReferences = ((Boolean)HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(paramDataHolder)).booleanValue();
/*  34 */     this.listOptions = ListOptions.get(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*  39 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler(AutoLink.class, this::render), new NodeRenderingHandler(BlockQuote.class, this::render), new NodeRenderingHandler(BulletList.class, this::render), new NodeRenderingHandler(BulletListItem.class, this::render), new NodeRenderingHandler(Code.class, this::render), new NodeRenderingHandler(Document.class, this::render), new NodeRenderingHandler(Emphasis.class, this::render), new NodeRenderingHandler(FencedCodeBlock.class, this::render), new NodeRenderingHandler(HardLineBreak.class, this::render), new NodeRenderingHandler(Heading.class, this::render), new NodeRenderingHandler(HtmlBlock.class, this::render), new NodeRenderingHandler(HtmlCommentBlock.class, this::render), new NodeRenderingHandler(HtmlEntity.class, this::render), new NodeRenderingHandler(HtmlInline.class, this::render), new NodeRenderingHandler(HtmlInlineComment.class, this::render), new NodeRenderingHandler(HtmlInnerBlock.class, this::render), new NodeRenderingHandler(HtmlInnerBlockComment.class, this::render), new NodeRenderingHandler(Image.class, this::render), new NodeRenderingHandler(ImageRef.class, this::render), new NodeRenderingHandler(IndentedCodeBlock.class, this::render), new NodeRenderingHandler(Link.class, this::render), new NodeRenderingHandler(LinkRef.class, this::render), new NodeRenderingHandler(MailLink.class, this::render), new NodeRenderingHandler(OrderedList.class, this::render), new NodeRenderingHandler(OrderedListItem.class, this::render), new NodeRenderingHandler(Paragraph.class, this::render), new NodeRenderingHandler(Reference.class, this::render), new NodeRenderingHandler(SoftLineBreak.class, this::render), new NodeRenderingHandler(StrongEmphasis.class, this::render), new NodeRenderingHandler(Text.class, this::render), new NodeRenderingHandler(TextBase.class, this::render), new NodeRenderingHandler(ThematicBreak.class, this::render) }));
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
/*     */   private void render(Document paramDocument, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  77 */     paramNodeRendererContext.renderChildren((Node)paramDocument);
/*     */   }
/*     */   
/*     */   private String repeat(String paramString, int paramInt) {
/*  81 */     StringBuilder stringBuilder = new StringBuilder();
/*  82 */     for (byte b = 0; b < paramInt; b++) {
/*  83 */       stringBuilder.append(paramString);
/*     */     }
/*  85 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void render(Heading paramHeading, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  89 */     String str = repeat("=", paramHeading.getLevel());
/*  90 */     ((HtmlWriter)paramHtmlWriter.line()).raw(str);
/*  91 */     paramNodeRendererContext.renderChildren((Node)paramHeading);
/*  92 */     paramHtmlWriter.raw(str);
/*  93 */     tailBlankLine((Node)paramHeading, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private HtmlWriter tailBlankLine(Node paramNode, HtmlWriter paramHtmlWriter) {
/*  97 */     return tailBlankLine(paramNode, 1, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   public boolean isLastBlockQuoteChild(Node paramNode) {
/*     */     Node node;
/* 102 */     if (node = paramNode.getParent() instanceof BlockQuote && node.getLastChild() == paramNode) return true;  return false;
/*     */   }
/*     */   
/*     */   public HtmlWriter tailBlankLine(Node paramNode, int paramInt, HtmlWriter paramHtmlWriter) {
/* 106 */     if (isLastBlockQuoteChild(paramNode)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       BasedSequence basedSequence = paramHtmlWriter.getPrefix();
/* 114 */       paramHtmlWriter.popPrefix();
/* 115 */       paramHtmlWriter.blankLine(paramInt);
/* 116 */       paramHtmlWriter.pushPrefix();
/* 117 */       paramHtmlWriter.setPrefix((CharSequence)basedSequence, false);
/*     */     } else {
/* 119 */       paramHtmlWriter.blankLine(paramInt);
/*     */     } 
/* 121 */     return paramHtmlWriter;
/*     */   }
/*     */   
/*     */   private void render(BlockQuote paramBlockQuote, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 125 */     this.inBlockQuote++;
/* 126 */     String str = repeat(">", this.inBlockQuote) + " ";
/*     */     
/* 128 */     paramHtmlWriter.pushPrefix();
/* 129 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).setPrefix("")).raw(str);
/* 130 */     paramHtmlWriter.setPrefix(str);
/* 131 */     paramNodeRendererContext.renderChildren((Node)paramBlockQuote);
/*     */     
/* 133 */     this.inBlockQuote--;
/* 134 */     paramHtmlWriter.popPrefix();
/*     */     
/* 136 */     tailBlankLine((Node)paramBlockQuote, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(FencedCodeBlock paramFencedCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     BasedSequence basedSequence;
/* 141 */     if ((basedSequence = paramFencedCodeBlock.getInfo()).isNotNull() && !basedSequence.isBlank()) {
/* 142 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code:lang=" + basedSequence.unescape() + "}")).line();
/*     */     } else {
/* 144 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code}")).line();
/*     */     } 
/*     */     
/* 147 */     paramHtmlWriter.raw(paramFencedCodeBlock.getContentChars().normalizeEOL());
/* 148 */     ((HtmlWriter)paramHtmlWriter.line()).raw("{code}");
/* 149 */     tailBlankLine((Node)paramFencedCodeBlock, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(ThematicBreak paramThematicBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 153 */     ((HtmlWriter)paramHtmlWriter.line()).raw("-----");
/* 154 */     tailBlankLine((Node)paramThematicBreak, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(IndentedCodeBlock paramIndentedCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 158 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{noformat}")).line();
/* 159 */     paramHtmlWriter.raw(((BasedSequence)paramIndentedCodeBlock.getContentChars().trimTailBlankLines()).normalizeEndWithEOL());
/* 160 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{noformat}")).line();
/*     */   }
/*     */   
/*     */   private void renderListItemPrefix(ListItem paramListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 164 */     paramListItem = paramListItem;
/* 165 */     StringBuilder stringBuilder = new StringBuilder();
/* 166 */     while (paramListItem instanceof ListBlock || paramListItem instanceof ListItem) {
/* 167 */       if (paramListItem instanceof BulletList) {
/* 168 */         stringBuilder.append('*');
/* 169 */       } else if (paramListItem instanceof OrderedList) {
/* 170 */         stringBuilder.append('#');
/*     */       } 
/* 172 */       Node node = paramListItem.getParent();
/*     */     } 
/*     */     
/* 175 */     if (stringBuilder.length() > 0) {
/* 176 */       stringBuilder.append(' ');
/*     */     }
/* 178 */     ((HtmlWriter)paramHtmlWriter.line()).raw(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   private void renderListItem(ListItem paramListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 182 */     renderListItemPrefix(paramListItem, paramNodeRendererContext, paramHtmlWriter);
/* 183 */     if (this.listOptions.isTightListItem(paramListItem)) {
/* 184 */       paramNodeRendererContext.renderChildren((Node)paramListItem); return;
/*     */     } 
/* 186 */     paramNodeRendererContext.renderChildren((Node)paramListItem);
/* 187 */     if (paramListItem.getFirstChild().getNext() != null) {
/* 188 */       tailBlankLine((Node)paramListItem, paramHtmlWriter);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderList(ListBlock paramListBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 194 */     paramNodeRendererContext.renderChildren((Node)paramListBlock);
/* 195 */     if (paramListBlock.getParent() instanceof Document && (
/* 196 */       paramListBlock.getLastChild() == null || this.listOptions.isTightListItem((ListItem)paramListBlock.getLastChild()))) {
/* 197 */       tailBlankLine((Node)paramListBlock, paramHtmlWriter);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(BulletList paramBulletList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 203 */     renderList((ListBlock)paramBulletList, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(OrderedList paramOrderedList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 207 */     renderList((ListBlock)paramOrderedList, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(BulletListItem paramBulletListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 211 */     renderListItem((ListItem)paramBulletListItem, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(OrderedListItem paramOrderedListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 215 */     renderListItem((ListItem)paramOrderedListItem, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private static void renderTextBlockParagraphLines(Node paramNode, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 219 */     paramNodeRendererContext.renderChildren(paramNode);
/* 220 */     paramHtmlWriter.line();
/*     */   }
/*     */   
/*     */   private void renderLooseParagraph(Paragraph paramParagraph, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 224 */     renderTextBlockParagraphLines((Node)paramParagraph, paramNodeRendererContext, paramHtmlWriter);
/*     */     
/* 226 */     if (this.inBlockQuote > 0 && paramParagraph.getNext() == null) {
/* 227 */       paramHtmlWriter.line(); return;
/*     */     } 
/* 229 */     tailBlankLine((Node)paramParagraph, paramHtmlWriter);
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Paragraph paramParagraph, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 234 */     if (!(paramParagraph.getParent() instanceof ParagraphItemContainer) || 
/* 235 */       !((ParagraphItemContainer)paramParagraph.getParent()).isParagraphWrappingDisabled(paramParagraph, this.listOptions, paramNodeRendererContext.getOptions())) {
/* 236 */       renderLooseParagraph(paramParagraph, paramNodeRendererContext, paramHtmlWriter); return;
/*     */     } 
/* 238 */     renderTextBlockParagraphLines((Node)paramParagraph, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSequence getSoftLineBreakSpan(Node paramNode) {
/* 243 */     if (paramNode == null) return BasedSequence.NULL;
/*     */     
/* 245 */     Node node1 = paramNode;
/* 246 */     Node node2 = paramNode.getNext();
/*     */     
/* 248 */     while (node2 != null && !(node2 instanceof SoftLineBreak)) {
/* 249 */       node1 = node2;
/* 250 */       node2 = node2.getNext();
/*     */     } 
/*     */     
/* 253 */     return Node.spanningChars(new BasedSequence[] { paramNode.getChars(), node1.getChars() });
/*     */   }
/*     */   
/*     */   private void render(SoftLineBreak paramSoftLineBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 257 */     paramHtmlWriter.raw(" ");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(HardLineBreak paramHardLineBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 262 */     paramHtmlWriter.line();
/*     */   }
/*     */   
/*     */   private void render(Emphasis paramEmphasis, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 266 */     paramHtmlWriter.raw("''");
/* 267 */     paramNodeRendererContext.renderChildren((Node)paramEmphasis);
/* 268 */     paramHtmlWriter.raw("''");
/*     */   }
/*     */   
/*     */   private void render(StrongEmphasis paramStrongEmphasis, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 272 */     paramHtmlWriter.raw("*");
/* 273 */     paramNodeRendererContext.renderChildren((Node)paramStrongEmphasis);
/* 274 */     paramHtmlWriter.raw("*");
/*     */   }
/*     */   
/*     */   private void render(Text paramText, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 278 */     paramHtmlWriter.raw(Escaping.normalizeEOL(paramText.getChars().unescape()));
/*     */   }
/*     */   
/*     */   private void render(TextBase paramTextBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 282 */     paramNodeRendererContext.renderChildren((Node)paramTextBase);
/*     */   }
/*     */   
/*     */   private void render(Code paramCode, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 286 */     paramHtmlWriter.raw("`");
/* 287 */     paramHtmlWriter.raw(Escaping.collapseWhitespace((CharSequence)paramCode.getText(), true));
/* 288 */     paramHtmlWriter.raw("`");
/*     */   }
/*     */   
/*     */   private void render(HtmlBlock paramHtmlBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 292 */     if (paramHtmlBlock.hasChildren()) {
/*     */       
/* 294 */       paramNodeRendererContext.renderChildren((Node)paramHtmlBlock); return;
/*     */     } 
/* 296 */     renderHtmlBlock((HtmlBlockBase)paramHtmlBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlBlocks);
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(HtmlCommentBlock paramHtmlCommentBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 301 */     renderHtmlBlock((HtmlBlockBase)paramHtmlCommentBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlCommentBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlCommentBlocks);
/*     */   }
/*     */   
/*     */   private void render(HtmlInnerBlock paramHtmlInnerBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 305 */     renderHtmlBlock((HtmlBlockBase)paramHtmlInnerBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlBlocks);
/*     */   }
/*     */   
/*     */   private void render(HtmlInnerBlockComment paramHtmlInnerBlockComment, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 309 */     renderHtmlBlock((HtmlBlockBase)paramHtmlInnerBlockComment, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlCommentBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlCommentBlocks);
/*     */   }
/*     */   
/*     */   public void renderHtmlBlock(HtmlBlockBase paramHtmlBlockBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, boolean paramBoolean1, boolean paramBoolean2) {
/* 313 */     if (paramBoolean1)
/*     */       return; 
/* 315 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code:html}")).line();
/* 316 */     paramHtmlWriter.raw(paramHtmlBlockBase.getContentChars().normalizeEOL());
/* 317 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code:html}")).line();
/*     */   }
/*     */   
/*     */   private void render(HtmlInline paramHtmlInline, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 321 */     renderInlineHtml((HtmlInlineBase)paramHtmlInline, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressInlineHtml, (paramNodeRendererContext.getHtmlOptions()).escapeInlineHtml);
/*     */   }
/*     */   
/*     */   private void render(HtmlInlineComment paramHtmlInlineComment, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 325 */     renderInlineHtml((HtmlInlineBase)paramHtmlInlineComment, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressInlineHtmlComments, (paramNodeRendererContext.getHtmlOptions()).escapeInlineHtmlComments);
/*     */   }
/*     */   
/*     */   public void renderInlineHtml(HtmlInlineBase paramHtmlInlineBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, boolean paramBoolean1, boolean paramBoolean2) {
/* 329 */     if (paramBoolean1)
/* 330 */       return;  ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("`")).raw(paramHtmlInlineBase.getChars().normalizeEOL())).raw("`");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Reference paramReference, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*     */ 
/*     */   
/*     */   private void render(HtmlEntity paramHtmlEntity, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 338 */     paramHtmlWriter.raw(paramHtmlEntity.getChars().unescape());
/*     */   }
/*     */   
/*     */   private void render(AutoLink paramAutoLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 342 */     String str = paramAutoLink.getText().toString();
/* 343 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 344 */       paramHtmlWriter.text(str); return;
/*     */     } 
/* 346 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, str, null);
/* 347 */     ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("[")).raw(str)).raw("|")).raw(resolvedLink.getUrl());
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(MailLink paramMailLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 352 */     String str = paramMailLink.getText().unescape();
/* 353 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 354 */       paramHtmlWriter.text(str); return;
/*     */     } 
/* 356 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, str, null);
/* 357 */     ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("[")).raw(str)).raw("|mailto:")).raw(resolvedLink.getUrl())).raw("]");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Image paramImage, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 362 */     if (!paramNodeRendererContext.isDoNotRenderLinks()) {
/* 363 */       ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, paramImage.getUrl().unescape(), null);
/* 364 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("!")).raw(resolvedLink.getUrl())).raw("!");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void render(Link paramLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 369 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 370 */       paramNodeRendererContext.renderChildren((Node)paramLink); return;
/*     */     } 
/* 372 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramLink.getUrl().unescape(), null);
/* 373 */     paramHtmlWriter.raw("[");
/* 374 */     paramNodeRendererContext.renderChildren((Node)paramLink);
/* 375 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("|")).raw(resolvedLink.getUrl())).raw("]");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(ImageRef paramImageRef, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 380 */     if (!paramImageRef.isDefined() && this.recheckUndefinedReferences && 
/* 381 */       paramImageRef.getReferenceNode(this.referenceRepository) != null) {
/* 382 */       paramImageRef.setDefined(true);
/*     */     }
/*     */ 
/*     */     
/* 386 */     if (!paramImageRef.isDefined()) {
/*     */       
/* 388 */       assert !paramImageRef.isDefined();
/* 389 */       paramHtmlWriter.text(paramImageRef.getChars().unescape()); return;
/*     */     } 
/* 391 */     if (!paramNodeRendererContext.isDoNotRenderLinks()) {
/* 392 */       Reference reference = paramImageRef.getReferenceNode(this.referenceRepository);
/* 393 */       assert reference != null;
/* 394 */       ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, reference.getUrl().unescape(), null);
/* 395 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("!")).raw(resolvedLink.getUrl())).raw("!");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(LinkRef paramLinkRef, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 401 */     if (!paramLinkRef.isDefined() && this.recheckUndefinedReferences && 
/* 402 */       paramLinkRef.getReferenceNode(this.referenceRepository) != null) {
/* 403 */       paramLinkRef.setDefined(true);
/*     */     }
/*     */ 
/*     */     
/* 407 */     if (!paramLinkRef.isDefined()) {
/*     */       
/* 409 */       assert !paramLinkRef.isDefined();
/* 410 */       paramHtmlWriter.raw("[");
/* 411 */       paramNodeRendererContext.renderChildren((Node)paramLinkRef);
/* 412 */       paramHtmlWriter.raw("]");
/*     */       
/* 414 */       if (!paramLinkRef.isReferenceTextCombined()) {
/* 415 */         paramHtmlWriter.raw("[");
/* 416 */         paramHtmlWriter.raw(paramLinkRef.getReference().unescape());
/* 417 */         paramHtmlWriter.raw("]"); return;
/*     */       } 
/*     */     } else {
/* 420 */       if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 421 */         paramNodeRendererContext.renderChildren((Node)paramLinkRef); return;
/*     */       } 
/* 423 */       Reference reference = paramLinkRef.getReferenceNode(this.referenceRepository);
/* 424 */       assert reference != null;
/*     */       
/* 426 */       ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, reference.getUrl().unescape(), null);
/*     */       
/* 428 */       paramHtmlWriter.raw("[");
/* 429 */       paramNodeRendererContext.renderChildren((Node)paramLinkRef);
/* 430 */       paramHtmlWriter.raw("|");
/* 431 */       paramHtmlWriter.raw(resolvedLink.getUrl());
/* 432 */       paramHtmlWriter.raw("]");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 441 */       return new YouTrackConverterNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\youtrack\converter\internal\YouTrackConverterNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */