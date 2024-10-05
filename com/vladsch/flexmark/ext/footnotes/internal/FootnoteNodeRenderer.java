/*     */ package com.vladsch.flexmark.ext.footnotes.internal;
/*     */ import com.vladsch.flexmark.ext.footnotes.Footnote;
/*     */ import com.vladsch.flexmark.ext.footnotes.FootnoteBlock;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.RenderingPhase;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*     */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class FootnoteNodeRenderer implements PhasedNodeRenderer {
/*     */   private final FootnoteRepository footnoteRepository;
/*     */   private final FootnoteOptions options;
/*     */   private final boolean recheckUndefinedReferences;
/*     */   
/*     */   public FootnoteNodeRenderer(DataHolder paramDataHolder) {
/*  27 */     this.options = new FootnoteOptions(paramDataHolder);
/*  28 */     this.footnoteRepository = (FootnoteRepository)FootnoteExtension.FOOTNOTES.get(paramDataHolder);
/*  29 */     this.recheckUndefinedReferences = ((Boolean)HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(paramDataHolder)).booleanValue();
/*  30 */     this.footnoteRepository.resolveFootnoteOrdinals();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*  35 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler(Footnote.class, this::render), new NodeRenderingHandler(FootnoteBlock.class, this::render) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<RenderingPhase> getRenderingPhases() {
/*     */     HashSet<RenderingPhase> hashSet;
/*  44 */     (hashSet = new HashSet<>()).add(RenderingPhase.BODY_TOP);
/*  45 */     hashSet.add(RenderingPhase.BODY_BOTTOM);
/*  46 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDocument(NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, Document paramDocument, RenderingPhase paramRenderingPhase) {
/*  51 */     if (paramRenderingPhase == RenderingPhase.BODY_TOP && 
/*  52 */       this.recheckUndefinedReferences) {
/*     */       
/*  54 */       boolean[] arrayOfBoolean = { false };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       NodeVisitor nodeVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  69 */       (nodeVisitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(Footnote.class, paramFootnote -> { FootnoteBlock footnoteBlock; if (!paramFootnote.isDefined() && (footnoteBlock = paramFootnote.getFootnoteBlock(this.footnoteRepository)) != null) { this.footnoteRepository.addFootnoteReference(footnoteBlock, paramFootnote); paramFootnote.setFootnoteBlock(footnoteBlock); paramArrayOfboolean[0] = true; }  }) })).visit((Node)paramDocument);
/*  70 */       if (arrayOfBoolean[0]) {
/*  71 */         this.footnoteRepository.resolveFootnoteOrdinals();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  76 */     if (paramRenderingPhase == RenderingPhase.BODY_BOTTOM)
/*     */     {
/*  78 */       if (this.footnoteRepository.getReferencedFootnoteBlocks().size() > 0) {
/*  79 */         ((HtmlWriter)paramHtmlWriter.attr("class", "footnotes")).withAttr().tagIndent("div", () -> {
/*     */               paramHtmlWriter.tagVoidLine("hr");
/*     */               paramHtmlWriter.tagIndent("ol", ());
/*     */             });
/*     */       }
/*     */     }
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
/*     */   private void render(FootnoteBlock paramFootnoteBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
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
/*     */   private void render(Footnote paramFootnote, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     FootnoteBlock footnoteBlock;
/* 110 */     if ((footnoteBlock = paramFootnote.getFootnoteBlock()) == null) {
/*     */       
/* 112 */       paramHtmlWriter.raw("[^");
/* 113 */       paramNodeRendererContext.renderChildren((Node)paramFootnote);
/* 114 */       paramHtmlWriter.raw("]"); return;
/*     */     } 
/* 116 */     int i = footnoteBlock.getFootnoteOrdinal();
/* 117 */     int j = paramFootnote.getReferenceOrdinal();
/* 118 */     paramHtmlWriter.attr("id", "fnref-" + i + ((j == 0) ? "" : String.format(Locale.US, "-%d", new Object[] { Integer.valueOf(j) })));
/* 119 */     paramHtmlWriter.srcPos(paramFootnote.getChars()).withAttr().tag("sup", false, false, () -> {
/*     */           if (!this.options.footnoteLinkRefClass.isEmpty())
/*     */             paramHtmlWriter.attr("class", this.options.footnoteLinkRefClass); 
/*     */           paramHtmlWriter.attr("href", "#fn-" + paramInt);
/*     */           paramHtmlWriter.withAttr().tag("a");
/*     */           paramHtmlWriter.raw(this.options.footnoteRefPrefix + paramInt + this.options.footnoteRefSuffix);
/*     */           paramHtmlWriter.tag("/a");
/*     */         });
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 133 */       return (NodeRenderer)new FootnoteNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\internal\FootnoteNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */