/*     */ package com.vladsch.flexmark.jira.converter.internal;
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
/*     */ public class JiraConverterNodeRenderer implements NodeRenderer {
/*     */   private final ReferenceRepository referenceRepository;
/*  26 */   private int inBlockQuote = 0; private final ListOptions listOptions;
/*     */   private final boolean recheckUndefinedReferences;
/*     */   
/*     */   public JiraConverterNodeRenderer(DataHolder paramDataHolder) {
/*  30 */     this.referenceRepository = (ReferenceRepository)Parser.REFERENCES.get(paramDataHolder);
/*  31 */     this.recheckUndefinedReferences = ((Boolean)HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(paramDataHolder)).booleanValue();
/*  32 */     this.listOptions = ListOptions.get(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*  37 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler(AutoLink.class, this::render), new NodeRenderingHandler(BlockQuote.class, this::render), new NodeRenderingHandler(BulletList.class, this::render), new NodeRenderingHandler(BulletListItem.class, this::render), new NodeRenderingHandler(Code.class, this::render), new NodeRenderingHandler(Document.class, this::render), new NodeRenderingHandler(Emphasis.class, this::render), new NodeRenderingHandler(FencedCodeBlock.class, this::render), new NodeRenderingHandler(HardLineBreak.class, this::render), new NodeRenderingHandler(Heading.class, this::render), new NodeRenderingHandler(HtmlBlock.class, this::render), new NodeRenderingHandler(HtmlCommentBlock.class, this::render), new NodeRenderingHandler(HtmlEntity.class, this::render), new NodeRenderingHandler(HtmlInline.class, this::render), new NodeRenderingHandler(HtmlInlineComment.class, this::render), new NodeRenderingHandler(HtmlInnerBlock.class, this::render), new NodeRenderingHandler(HtmlInnerBlockComment.class, this::render), new NodeRenderingHandler(Image.class, this::render), new NodeRenderingHandler(ImageRef.class, this::render), new NodeRenderingHandler(IndentedCodeBlock.class, this::render), new NodeRenderingHandler(Link.class, this::render), new NodeRenderingHandler(LinkRef.class, this::render), new NodeRenderingHandler(MailLink.class, this::render), new NodeRenderingHandler(OrderedList.class, this::render), new NodeRenderingHandler(OrderedListItem.class, this::render), new NodeRenderingHandler(Paragraph.class, this::render), new NodeRenderingHandler(Reference.class, this::render), new NodeRenderingHandler(SoftLineBreak.class, this::render), new NodeRenderingHandler(StrongEmphasis.class, this::render), new NodeRenderingHandler(Text.class, this::render), new NodeRenderingHandler(TextBase.class, this::render), new NodeRenderingHandler(ThematicBreak.class, this::render) }));
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
/*  75 */     paramNodeRendererContext.renderChildren((Node)paramDocument);
/*     */   }
/*     */   
/*     */   private void render(Heading paramHeading, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  79 */     ((HtmlWriter)paramHtmlWriter.line()).raw("h" + paramHeading.getLevel() + ". ");
/*  80 */     paramNodeRendererContext.renderChildren((Node)paramHeading);
/*  81 */     paramHtmlWriter.blankLine();
/*     */   }
/*     */   
/*     */   private void render(BlockQuote paramBlockQuote, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  85 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{quote}")).line();
/*  86 */     paramHtmlWriter.pushPrefix();
/*  87 */     this.inBlockQuote++;
/*  88 */     paramNodeRendererContext.renderChildren((Node)paramBlockQuote);
/*  89 */     this.inBlockQuote--;
/*  90 */     paramHtmlWriter.popPrefix();
/*  91 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{quote}")).blankLine();
/*     */   }
/*     */   
/*     */   private void render(FencedCodeBlock paramFencedCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     BasedSequence basedSequence;
/*  96 */     if ((basedSequence = paramFencedCodeBlock.getInfo()).isNotNull() && !basedSequence.isBlank()) {
/*  97 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code:lang=" + basedSequence.unescape() + "}")).line();
/*     */     } else {
/*  99 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code}")).line();
/*     */     } 
/*     */     
/* 102 */     paramHtmlWriter.raw(paramFencedCodeBlock.getContentChars().normalizeEOL());
/* 103 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code}")).blankLine();
/*     */   }
/*     */   
/*     */   private void render(ThematicBreak paramThematicBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 107 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("----")).blankLine();
/*     */   }
/*     */   
/*     */   private void render(IndentedCodeBlock paramIndentedCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 111 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{noformat}")).line();
/* 112 */     paramHtmlWriter.raw(((BasedSequence)paramIndentedCodeBlock.getContentChars().trimTailBlankLines()).normalizeEndWithEOL());
/* 113 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{noformat}")).line();
/*     */   }
/*     */   
/*     */   private void renderListItemPrefix(ListItem paramListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 117 */     paramListItem = paramListItem;
/* 118 */     StringBuilder stringBuilder = new StringBuilder();
/* 119 */     while (paramListItem instanceof ListBlock || paramListItem instanceof ListItem) {
/* 120 */       if (paramListItem instanceof BulletList) {
/* 121 */         stringBuilder.append('*');
/* 122 */       } else if (paramListItem instanceof OrderedList) {
/* 123 */         stringBuilder.append('#');
/*     */       } 
/* 125 */       Node node = paramListItem.getParent();
/*     */     } 
/*     */     
/* 128 */     if (stringBuilder.length() > 0) {
/* 129 */       stringBuilder.append(' ');
/*     */     }
/* 131 */     ((HtmlWriter)paramHtmlWriter.line()).raw(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   private void renderListItem(ListItem paramListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 135 */     renderListItemPrefix(paramListItem, paramNodeRendererContext, paramHtmlWriter);
/* 136 */     if (this.listOptions.isTightListItem(paramListItem)) {
/* 137 */       paramNodeRendererContext.renderChildren((Node)paramListItem); return;
/*     */     } 
/* 139 */     paramNodeRendererContext.renderChildren((Node)paramListItem);
/* 140 */     if (paramListItem.getFirstChild().getNext() != null) {
/* 141 */       paramHtmlWriter.blankLine();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderList(ListBlock paramListBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 147 */     paramNodeRendererContext.renderChildren((Node)paramListBlock);
/* 148 */     if (paramListBlock.getParent() instanceof Document && (
/* 149 */       paramListBlock.getLastChild() == null || this.listOptions.isTightListItem((ListItem)paramListBlock.getLastChild()))) {
/* 150 */       paramHtmlWriter.blankLine();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(BulletList paramBulletList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 156 */     renderList((ListBlock)paramBulletList, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(OrderedList paramOrderedList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 160 */     renderList((ListBlock)paramOrderedList, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(BulletListItem paramBulletListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 164 */     renderListItem((ListItem)paramBulletListItem, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(OrderedListItem paramOrderedListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 168 */     renderListItem((ListItem)paramOrderedListItem, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private static void renderTextBlockParagraphLines(Node paramNode, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 172 */     paramNodeRendererContext.renderChildren(paramNode);
/* 173 */     paramHtmlWriter.line();
/*     */   }
/*     */   
/*     */   private void renderLooseParagraph(Paragraph paramParagraph, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 177 */     renderTextBlockParagraphLines((Node)paramParagraph, paramNodeRendererContext, paramHtmlWriter);
/*     */     
/* 179 */     if (this.inBlockQuote > 0 && paramParagraph.getNext() == null) {
/* 180 */       paramHtmlWriter.line(); return;
/*     */     } 
/* 182 */     paramHtmlWriter.blankLine();
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Paragraph paramParagraph, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 187 */     if (!(paramParagraph.getParent() instanceof ParagraphItemContainer) || 
/* 188 */       !((ParagraphItemContainer)paramParagraph.getParent()).isParagraphWrappingDisabled(paramParagraph, this.listOptions, paramNodeRendererContext.getOptions())) {
/* 189 */       renderLooseParagraph(paramParagraph, paramNodeRendererContext, paramHtmlWriter); return;
/*     */     } 
/* 191 */     renderTextBlockParagraphLines((Node)paramParagraph, paramNodeRendererContext, paramHtmlWriter);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSequence getSoftLineBreakSpan(Node paramNode) {
/* 196 */     if (paramNode == null) return BasedSequence.NULL;
/*     */     
/* 198 */     Node node1 = paramNode;
/* 199 */     Node node2 = paramNode.getNext();
/*     */     
/* 201 */     while (node2 != null && !(node2 instanceof SoftLineBreak)) {
/* 202 */       node1 = node2;
/* 203 */       node2 = node2.getNext();
/*     */     } 
/*     */     
/* 206 */     return Node.spanningChars(new BasedSequence[] { paramNode.getChars(), node1.getChars() });
/*     */   }
/*     */   
/*     */   private void render(SoftLineBreak paramSoftLineBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 210 */     paramHtmlWriter.raw(" ");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(HardLineBreak paramHardLineBreak, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 215 */     paramHtmlWriter.line();
/*     */   }
/*     */   
/*     */   private void render(Emphasis paramEmphasis, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 219 */     paramHtmlWriter.raw("_");
/* 220 */     paramNodeRendererContext.renderChildren((Node)paramEmphasis);
/* 221 */     paramHtmlWriter.raw("_");
/*     */   }
/*     */   
/*     */   private void render(StrongEmphasis paramStrongEmphasis, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 225 */     paramHtmlWriter.raw("*");
/* 226 */     paramNodeRendererContext.renderChildren((Node)paramStrongEmphasis);
/* 227 */     paramHtmlWriter.raw("*");
/*     */   }
/*     */   
/*     */   private void render(Text paramText, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 231 */     paramHtmlWriter.raw(Escaping.normalizeEOL(paramText.getChars().unescape()));
/*     */   }
/*     */   
/*     */   private void render(TextBase paramTextBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 235 */     paramNodeRendererContext.renderChildren((Node)paramTextBase);
/*     */   }
/*     */   
/*     */   private void render(Code paramCode, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 239 */     paramHtmlWriter.raw("{{");
/* 240 */     paramHtmlWriter.raw(Escaping.collapseWhitespace((CharSequence)paramCode.getText(), true));
/* 241 */     paramHtmlWriter.raw("}}");
/*     */   }
/*     */   
/*     */   private void render(HtmlBlock paramHtmlBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 245 */     if (paramHtmlBlock.hasChildren()) {
/*     */       
/* 247 */       paramNodeRendererContext.renderChildren((Node)paramHtmlBlock); return;
/*     */     } 
/* 249 */     renderHtmlBlock((HtmlBlockBase)paramHtmlBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlBlocks);
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(HtmlCommentBlock paramHtmlCommentBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 254 */     renderHtmlBlock((HtmlBlockBase)paramHtmlCommentBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlCommentBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlCommentBlocks);
/*     */   }
/*     */   
/*     */   private void render(HtmlInnerBlock paramHtmlInnerBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 258 */     renderHtmlBlock((HtmlBlockBase)paramHtmlInnerBlock, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlBlocks);
/*     */   }
/*     */   
/*     */   private void render(HtmlInnerBlockComment paramHtmlInnerBlockComment, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 262 */     renderHtmlBlock((HtmlBlockBase)paramHtmlInnerBlockComment, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressHtmlCommentBlocks, (paramNodeRendererContext.getHtmlOptions()).escapeHtmlCommentBlocks);
/*     */   }
/*     */   
/*     */   public void renderHtmlBlock(HtmlBlockBase paramHtmlBlockBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, boolean paramBoolean1, boolean paramBoolean2) {
/* 266 */     if (paramBoolean1)
/*     */       return; 
/* 268 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code:html}")).line();
/* 269 */     paramHtmlWriter.raw(paramHtmlBlockBase.getContentChars().normalizeEOL());
/* 270 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).raw("{code:html}")).line();
/*     */   }
/*     */   
/*     */   private void render(HtmlInline paramHtmlInline, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 274 */     renderInlineHtml((HtmlInlineBase)paramHtmlInline, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressInlineHtml, (paramNodeRendererContext.getHtmlOptions()).escapeInlineHtml);
/*     */   }
/*     */   
/*     */   private void render(HtmlInlineComment paramHtmlInlineComment, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 278 */     renderInlineHtml((HtmlInlineBase)paramHtmlInlineComment, paramNodeRendererContext, paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).suppressInlineHtmlComments, (paramNodeRendererContext.getHtmlOptions()).escapeInlineHtmlComments);
/*     */   }
/*     */   
/*     */   public void renderInlineHtml(HtmlInlineBase paramHtmlInlineBase, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, boolean paramBoolean1, boolean paramBoolean2) {
/* 282 */     if (paramBoolean1)
/* 283 */       return;  ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("{{")).raw(paramHtmlInlineBase.getChars().normalizeEOL())).raw("}}");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Reference paramReference, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*     */ 
/*     */   
/*     */   private void render(HtmlEntity paramHtmlEntity, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 291 */     paramHtmlWriter.raw(paramHtmlEntity.getChars().unescape());
/*     */   }
/*     */   
/*     */   private void render(AutoLink paramAutoLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 295 */     BasedSequence basedSequence = paramAutoLink.getText();
/* 296 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 297 */       paramHtmlWriter.text((CharSequence)basedSequence); return;
/*     */     } 
/* 299 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, (CharSequence)basedSequence, null);
/* 300 */     ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("[")).raw((CharSequence)basedSequence)).raw("|")).raw(resolvedLink.getUrl());
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(MailLink paramMailLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 305 */     String str = paramMailLink.getText().unescape();
/* 306 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 307 */       paramHtmlWriter.text(str); return;
/*     */     } 
/* 309 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, str, null);
/* 310 */     ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("[")).raw(str)).raw("|mailto:")).raw(resolvedLink.getUrl())).raw("]");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Image paramImage, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 315 */     if (!paramNodeRendererContext.isDoNotRenderLinks()) {
/* 316 */       ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, paramImage.getUrl().unescape(), null);
/* 317 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("!")).raw(resolvedLink.getUrl())).raw("!");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void render(Link paramLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 322 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 323 */       paramNodeRendererContext.renderChildren((Node)paramLink); return;
/*     */     } 
/* 325 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramLink.getUrl().unescape(), null);
/* 326 */     paramHtmlWriter.raw("[");
/* 327 */     paramNodeRendererContext.renderChildren((Node)paramLink);
/* 328 */     ((HtmlWriter)paramHtmlWriter.raw("|")).raw(resolvedLink.getUrl());
/* 329 */     if (paramLink.getTitle() != null && !paramLink.getTitle().isEmpty()) {
/* 330 */       ((HtmlWriter)paramHtmlWriter.raw("|")).raw((CharSequence)paramLink.getTitle());
/*     */     }
/* 332 */     paramHtmlWriter.raw("]");
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(ImageRef paramImageRef, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 337 */     if (!paramImageRef.isDefined() && this.recheckUndefinedReferences && 
/* 338 */       paramImageRef.getReferenceNode(this.referenceRepository) != null) {
/* 339 */       paramImageRef.setDefined(true);
/*     */     }
/*     */ 
/*     */     
/* 343 */     if (!paramImageRef.isDefined()) {
/*     */       
/* 345 */       assert !paramImageRef.isDefined();
/* 346 */       paramHtmlWriter.text(paramImageRef.getChars().unescape()); return;
/*     */     } 
/* 348 */     if (!paramNodeRendererContext.isDoNotRenderLinks()) {
/* 349 */       Reference reference = paramImageRef.getReferenceNode(this.referenceRepository);
/* 350 */       assert reference != null;
/* 351 */       ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, reference.getUrl().unescape(), null);
/* 352 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("!")).raw(resolvedLink.getUrl())).raw("!");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(LinkRef paramLinkRef, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 358 */     if (!paramLinkRef.isDefined() && this.recheckUndefinedReferences && 
/* 359 */       paramLinkRef.getReferenceNode(this.referenceRepository) != null) {
/* 360 */       paramLinkRef.setDefined(true);
/*     */     }
/*     */ 
/*     */     
/* 364 */     if (!paramLinkRef.isDefined()) {
/*     */       
/* 366 */       assert !paramLinkRef.isDefined();
/* 367 */       paramHtmlWriter.raw("[");
/* 368 */       paramNodeRendererContext.renderChildren((Node)paramLinkRef);
/* 369 */       paramHtmlWriter.raw("]");
/*     */       
/* 371 */       if (!paramLinkRef.isReferenceTextCombined()) {
/* 372 */         paramHtmlWriter.raw("[");
/* 373 */         paramHtmlWriter.raw(paramLinkRef.getReference().unescape());
/* 374 */         paramHtmlWriter.raw("]"); return;
/*     */       } 
/*     */     } else {
/* 377 */       if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 378 */         paramNodeRendererContext.renderChildren((Node)paramLinkRef); return;
/*     */       } 
/* 380 */       Reference reference = paramLinkRef.getReferenceNode(this.referenceRepository);
/* 381 */       assert reference != null;
/*     */       
/* 383 */       ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, reference.getUrl().unescape(), null);
/*     */       
/* 385 */       paramHtmlWriter.raw("[");
/* 386 */       paramNodeRendererContext.renderChildren((Node)paramLinkRef);
/* 387 */       paramHtmlWriter.raw("|");
/* 388 */       paramHtmlWriter.raw(resolvedLink.getUrl());
/* 389 */       paramHtmlWriter.raw("]");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 398 */       return new JiraConverterNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\jira\converter\internal\JiraConverterNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */