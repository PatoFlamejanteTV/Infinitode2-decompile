/*     */ package com.vladsch.flexmark.ext.admonition.internal;
/*     */ import com.vladsch.flexmark.ext.admonition.AdmonitionBlock;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.RenderingPhase;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class AdmonitionNodeRenderer implements PhasedNodeRenderer {
/*  18 */   public static AttributablePart ADMONITION_SVG_OBJECT_PART = new AttributablePart("ADMONITION_SVG_OBJECT_PART");
/*  19 */   public static AttributablePart ADMONITION_HEADING_PART = new AttributablePart("ADMONITION_HEADING_PART");
/*  20 */   public static AttributablePart ADMONITION_ICON_PART = new AttributablePart("ADMONITION_ICON_PART");
/*  21 */   public static AttributablePart ADMONITION_TITLE_PART = new AttributablePart("ADMONITION_TITLE_PART");
/*  22 */   public static AttributablePart ADMONITION_BODY_PART = new AttributablePart("ADMONITION_BODY_PART");
/*     */   
/*     */   private final AdmonitionOptions options;
/*     */   
/*     */   public AdmonitionNodeRenderer(DataHolder paramDataHolder) {
/*  27 */     this.options = new AdmonitionOptions(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*     */     HashSet<NodeRenderingHandler> hashSet;
/*  33 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(AdmonitionBlock.class, this::render));
/*  34 */     return (Set)hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<RenderingPhase> getRenderingPhases() {
/*     */     LinkedHashSet<RenderingPhase> linkedHashSet;
/*  40 */     (linkedHashSet = new LinkedHashSet<>()).add(RenderingPhase.BODY_TOP);
/*  41 */     return linkedHashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDocument(NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, Document paramDocument, RenderingPhase paramRenderingPhase) {
/*  46 */     if (paramRenderingPhase == RenderingPhase.BODY_TOP) {
/*     */ 
/*     */       
/*  49 */       HashSet<String> hashSet = new HashSet();
/*     */       
/*     */       Set<String> set;
/*  52 */       for (String str1 : set = (new AdmonitionCollectingVisitor()).collectAndGetQualifiers((Node)paramDocument)) {
/*     */         String str2;
/*  54 */         if ((str2 = this.options.qualifierTypeMap.get(str1)) == null) str2 = this.options.unresolvedQualifier; 
/*  55 */         hashSet.add(str2);
/*     */       } 
/*     */       
/*  58 */       if (!hashSet.isEmpty()) {
/*  59 */         ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).attr("xmlns", "http://www.w3.org/2000/svg")).attr("class", "adm-hidden")).withAttr(ADMONITION_SVG_OBJECT_PART)
/*  60 */           .tag("svg")).indent()).line();
/*  61 */         for (String str1 : hashSet) {
/*     */           String str2;
/*  63 */           if ((str2 = this.options.typeSvgMap.get(str1)) != null && !str2.isEmpty()) {
/*  64 */             ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("<symbol id=\"adm-")).raw(str1)).raw("\">")).indent()).line())
/*  65 */               .raw(str2)).line())
/*  66 */               .unIndent()).raw("</symbol>")).line();
/*     */           }
/*     */         } 
/*  69 */         ((HtmlWriter)((HtmlWriter)paramHtmlWriter.unIndent()).closeTag("svg")).line();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void render(AdmonitionBlock paramAdmonitionBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  75 */     String str3, str1 = paramAdmonitionBlock.getInfo().toString().toLowerCase();
/*     */     String str2;
/*  77 */     if ((str2 = this.options.qualifierTypeMap.get(str1)) == null) {
/*  78 */       str2 = this.options.unresolvedQualifier;
/*     */     }
/*     */ 
/*     */     
/*  82 */     if (paramAdmonitionBlock.getTitle().isNull()) {
/*     */       
/*  84 */       if ((str3 = this.options.qualifierTitleMap.get(str1)) == null) {
/*  85 */         str3 = str1.substring(0, 1).toUpperCase() + str1.substring(1);
/*     */       }
/*     */     } else {
/*  88 */       str3 = paramAdmonitionBlock.getTitle().toString();
/*     */     } 
/*     */ 
/*     */     
/*  92 */     if (paramAdmonitionBlock.getOpeningMarker().equals("???")) { str1 = " adm-collapsed"; }
/*  93 */     else if (paramAdmonitionBlock.getOpeningMarker().equals("???+")) { str1 = "adm-open"; }
/*  94 */     else { str1 = null; }
/*     */     
/*  96 */     if (str3.isEmpty()) {
/*  97 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPos(paramAdmonitionBlock.getChars()).withAttr()
/*  98 */         .attr("class", "adm-block"))
/*  99 */         .attr("class", "adm-" + str2))
/* 100 */         .tag("div", false).line();
/*     */       
/* 102 */       ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("class", "adm-body")).withAttr(ADMONITION_BODY_PART).tag("div")).indent()).line();
/*     */       
/* 104 */       paramNodeRendererContext.renderChildren((Node)paramAdmonitionBlock);
/*     */       
/* 106 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.unIndent()).closeTag("div")).line();
/* 107 */       ((HtmlWriter)paramHtmlWriter.closeTag("div")).line(); return;
/*     */     } 
/* 109 */     ((HtmlWriter)paramHtmlWriter.srcPos(paramAdmonitionBlock.getChars())
/* 110 */       .attr("class", "adm-block")).attr("class", "adm-" + str2);
/*     */     
/* 112 */     if (str1 != null) {
/* 113 */       ((HtmlWriter)paramHtmlWriter.attr("class", str1)).attr("class", "adm-" + str2);
/*     */     }
/*     */     
/* 116 */     paramHtmlWriter.withAttr().tag("div", false).line();
/* 117 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("class", "adm-heading")).withAttr(ADMONITION_HEADING_PART).tag("div")).line();
/* 118 */     ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("class", "adm-icon")).withAttr(ADMONITION_ICON_PART).tag("svg")).raw("<use xlink:href=\"#adm-")).raw(str2)).raw("\" />")).closeTag("svg");
/* 119 */     ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.withAttr(ADMONITION_TITLE_PART).tag("span")).text(str3)).closeTag("span")).line();
/* 120 */     ((HtmlWriter)paramHtmlWriter.closeTag("div")).line();
/*     */     
/* 122 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("class", "adm-body")).withAttr(ADMONITION_BODY_PART).withCondIndent()).tagLine("div", () -> paramNodeRendererContext.renderChildren((Node)paramAdmonitionBlock));
/*     */     
/* 124 */     ((HtmlWriter)paramHtmlWriter.closeTag("div")).line();
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 132 */       return (NodeRenderer)new AdmonitionNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\admonition\internal\AdmonitionNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */