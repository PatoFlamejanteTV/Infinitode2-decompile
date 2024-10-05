/*     */ package com.vladsch.flexmark.ext.gitlab.internal;
/*     */ import com.vladsch.flexmark.ast.FencedCodeBlock;
/*     */ import com.vladsch.flexmark.ast.Image;
/*     */ import com.vladsch.flexmark.ast.ImageRef;
/*     */ import com.vladsch.flexmark.ast.Reference;
/*     */ import com.vladsch.flexmark.ast.util.ReferenceRepository;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabDel;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabInlineMath;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabIns;
/*     */ import com.vladsch.flexmark.html.HtmlRendererOptions;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*     */ import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.LinkType;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.html.Attributes;
/*     */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class GitLabNodeRenderer implements NodeRenderer {
/*  31 */   public static final AttributablePart VIDEO = new AttributablePart("VIDEO");
/*  32 */   public static final AttributablePart VIDEO_LINK = new AttributablePart("VIDEO_LINK");
/*     */   
/*     */   final GitLabOptions options;
/*     */   private final boolean codeContentBlock;
/*     */   private final ReferenceRepository referenceRepository;
/*     */   private final boolean recheckUndefinedReferences;
/*     */   
/*     */   public GitLabNodeRenderer(DataHolder paramDataHolder) {
/*  40 */     this.options = new GitLabOptions(paramDataHolder);
/*  41 */     this.codeContentBlock = ((Boolean)Parser.FENCED_CODE_CONTENT_BLOCK.get(paramDataHolder)).booleanValue();
/*  42 */     this.referenceRepository = (ReferenceRepository)Parser.REFERENCES.get(paramDataHolder);
/*  43 */     this.recheckUndefinedReferences = ((Boolean)HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*     */     HashSet<NodeRenderingHandler> hashSet;
/*  50 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(GitLabIns.class, this::render));
/*  51 */     hashSet.add(new NodeRenderingHandler(GitLabDel.class, this::render));
/*  52 */     hashSet.add(new NodeRenderingHandler(GitLabInlineMath.class, this::render));
/*  53 */     hashSet.add(new NodeRenderingHandler(GitLabBlockQuote.class, this::render));
/*  54 */     if (this.options.renderBlockMath || this.options.renderBlockMermaid) {
/*  55 */       hashSet.add(new NodeRenderingHandler(FencedCodeBlock.class, this::render));
/*     */     }
/*  57 */     if (this.options.renderVideoImages) {
/*  58 */       hashSet.add(new NodeRenderingHandler(Image.class, this::render));
/*  59 */       hashSet.add(new NodeRenderingHandler(ImageRef.class, this::render));
/*     */     } 
/*     */     
/*  62 */     return (Set)hashSet;
/*     */   }
/*     */   
/*     */   private void render(GitLabIns paramGitLabIns, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  66 */     paramHtmlWriter.withAttr().tag("ins", false, false, () -> paramNodeRendererContext.renderChildren((Node)paramGitLabIns));
/*     */   }
/*     */   
/*     */   private void render(GitLabDel paramGitLabDel, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  70 */     paramHtmlWriter.withAttr().tag("del", false, false, () -> paramNodeRendererContext.renderChildren((Node)paramGitLabDel));
/*     */   }
/*     */   
/*     */   private void render(GitLabInlineMath paramGitLabInlineMath, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  74 */     ((HtmlWriter)paramHtmlWriter.withAttr().attr("class", this.options.inlineMathClass)).withAttr().tag("span");
/*  75 */     paramHtmlWriter.text((CharSequence)paramGitLabInlineMath.getText());
/*  76 */     paramHtmlWriter.tag("/span");
/*     */   }
/*     */   
/*     */   private void render(GitLabBlockQuote paramGitLabBlockQuote, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  80 */     paramHtmlWriter.withAttr().tagLineIndent("blockquote", () -> paramNodeRendererContext.renderChildren((Node)paramGitLabBlockQuote));
/*     */   }
/*     */   
/*     */   private void render(FencedCodeBlock paramFencedCodeBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  84 */     HtmlRendererOptions htmlRendererOptions = paramNodeRendererContext.getHtmlOptions();
/*  85 */     BasedSequence basedSequence = paramFencedCodeBlock.getInfoDelimitedByAny(htmlRendererOptions.languageDelimiterSet);
/*     */     
/*  87 */     if (this.options.renderBlockMath && basedSequence.isIn(this.options.mathLanguages)) {
/*  88 */       paramHtmlWriter.line();
/*  89 */       ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPosWithTrailingEOL(paramFencedCodeBlock.getChars()).attr("class", this.options.blockMathClass)).withAttr().tag("div")).line()).openPre();
/*  90 */       if (this.codeContentBlock) {
/*  91 */         paramNodeRendererContext.renderChildren((Node)paramFencedCodeBlock);
/*     */       } else {
/*  93 */         paramHtmlWriter.text(paramFencedCodeBlock.getContentChars().normalizeEOL());
/*     */       } 
/*  95 */       ((HtmlWriter)paramHtmlWriter.closePre()).tag("/div");
/*     */       
/*  97 */       paramHtmlWriter.lineIf(htmlRendererOptions.htmlBlockCloseTagEol); return;
/*  98 */     }  if (this.options.renderBlockMermaid && basedSequence.isIn(this.options.mermaidLanguages)) {
/*  99 */       paramHtmlWriter.line();
/* 100 */       ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPosWithTrailingEOL(paramFencedCodeBlock.getChars()).attr("class", this.options.blockMermaidClass)).withAttr().tag("div")).line()).openPre();
/* 101 */       if (this.codeContentBlock) {
/* 102 */         paramNodeRendererContext.renderChildren((Node)paramFencedCodeBlock);
/*     */       } else {
/* 104 */         paramHtmlWriter.text(paramFencedCodeBlock.getContentChars().normalizeEOL());
/*     */       } 
/* 106 */       ((HtmlWriter)paramHtmlWriter.closePre()).tag("/div");
/*     */       
/* 108 */       paramHtmlWriter.lineIf(htmlRendererOptions.htmlBlockCloseTagEol); return;
/*     */     } 
/* 110 */     paramNodeRendererContext.delegateRender();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean renderVideoImage(Node paramNode, String paramString1, String paramString2, Attributes paramAttributes, HtmlWriter paramHtmlWriter) {
/* 115 */     String str = paramString1;
/*     */     int i;
/* 117 */     if ((i = paramString1.indexOf('?')) != -1) {
/* 118 */       str = paramString1.substring(0, i);
/*     */     }
/*     */ 
/*     */     
/* 122 */     if ((i = str.lastIndexOf('.')) != -1) {
/* 123 */       str = str.substring(i + 1);
/* 124 */       if (this.options.videoImageExtensionSet.contains(str)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 129 */         ((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("class", this.options.videoImageClass)).attr(paramAttributes)).withAttr().tagLineIndent("div", () -> {
/*     */               ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPos(paramNode.getChars()).attr("src", paramString1)).attr("width", "400")).attr("controls", "true")).withAttr(VIDEO).tag("video")).tag("/video")).line();
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
/*     */               if (this.options.renderVideoLink) {
/*     */                 ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.tag("p")).attr("href", paramString1)).attr("target", "_blank")).attr("rel", "noopener noreferrer")).attr("title", String.format(this.options.videoImageLinkTextFormat, new Object[] { paramString2 }))).withAttr(VIDEO_LINK).tag("a")).text(paramString2)).tag("/a")).tag("/p")).line();
/*     */               }
/*     */             });
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
/* 155 */         return true;
/*     */       } 
/*     */     } 
/* 158 */     return false;
/*     */   }
/*     */   
/*     */   private void render(Image paramImage, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 162 */     if (!paramNodeRendererContext.isDoNotRenderLinks() && !CoreNodeRenderer.isSuppressedLinkPrefix((CharSequence)paramImage.getUrl(), paramNodeRendererContext)) {
/* 163 */       String str1 = (new TextCollectingVisitor()).collectAndGetText((Node)paramImage);
/*     */       ResolvedLink resolvedLink;
/* 165 */       String str2 = (resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, paramImage.getUrl().unescape(), null, null)).getUrl();
/*     */       
/* 167 */       if (paramImage.getUrlContent().isEmpty()) {
/* 168 */         Attributes attributes = resolvedLink.getNonNullAttributes();
/*     */ 
/*     */         
/* 171 */         MutableAttributes mutableAttributes = paramNodeRendererContext.extendRenderingNodeAttributes((Node)paramImage, AttributablePart.NODE, attributes);
/*     */         
/* 173 */         if (renderVideoImage((Node)paramImage, str2, str1, (Attributes)mutableAttributes, paramHtmlWriter)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       
/* 178 */       paramNodeRendererContext.delegateRender();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void render(ImageRef paramImageRef, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     ResolvedLink resolvedLink;
/* 184 */     boolean bool = false;
/*     */     
/* 186 */     if (!paramImageRef.isDefined() && this.recheckUndefinedReferences && 
/* 187 */       paramImageRef.getReferenceNode(this.referenceRepository) != null) {
/* 188 */       paramImageRef.setDefined(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     if (paramImageRef.isDefined()) {
/*     */       Reference reference;
/*     */       String str;
/* 197 */       bool = CoreNodeRenderer.isSuppressedLinkPrefix(str = (reference = paramImageRef.getReferenceNode(this.referenceRepository)).getUrl().unescape(), paramNodeRendererContext);
/*     */       
/* 199 */       resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, str, null, null);
/* 200 */       if (reference.getTitle().isNotNull()) {
/* 201 */         resolvedLink = resolvedLink.withTitle(reference.getTitle().unescape());
/*     */       }
/*     */     } else {
/*     */       
/* 205 */       String str = this.referenceRepository.normalizeKey((CharSequence)paramImageRef.getReference());
/*     */       
/* 207 */       if ((resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE_REF, str, null, null)).getStatus() == LinkStatus.UNKNOWN) {
/* 208 */         resolvedLink = null;
/*     */       }
/*     */     } 
/*     */     
/* 212 */     if (resolvedLink != null && 
/* 213 */       !paramNodeRendererContext.isDoNotRenderLinks() && !bool) {
/* 214 */       String str2 = (new TextCollectingVisitor()).collectAndGetText((Node)paramImageRef);
/* 215 */       String str1 = resolvedLink.getUrl();
/* 216 */       Attributes attributes = resolvedLink.getNonNullAttributes();
/* 217 */       if (renderVideoImage((Node)paramImageRef, str1, str2, attributes, paramHtmlWriter)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 223 */     paramNodeRendererContext.delegateRender();
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 230 */       return new GitLabNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\internal\GitLabNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */