/*     */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceBlock;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceLink;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceRendering;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceText;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferences;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.RenderingPhase;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class EnumeratedReferenceNodeRenderer implements PhasedNodeRenderer {
/*     */   private final EnumeratedReferenceOptions options;
/*     */   private EnumeratedReferences enumeratedOrdinals;
/*     */   
/*     */   public EnumeratedReferenceNodeRenderer(DataHolder paramDataHolder) {
/*  25 */     this.options = new EnumeratedReferenceOptions(paramDataHolder);
/*  26 */     this.ordinalRunnable = null;
/*  27 */     this.headerIdGenerator = (HtmlIdGenerator)(new HeaderIdGenerator.Factory()).create();
/*     */   }
/*     */   private Runnable ordinalRunnable; private final HtmlIdGenerator headerIdGenerator;
/*     */   
/*     */   public Set<RenderingPhase> getRenderingPhases() {
/*     */     LinkedHashSet<RenderingPhase> linkedHashSet;
/*  33 */     (linkedHashSet = new LinkedHashSet<>()).add(RenderingPhase.HEAD_TOP);
/*  34 */     linkedHashSet.add(RenderingPhase.BODY_TOP);
/*  35 */     return linkedHashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDocument(NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, Document paramDocument, RenderingPhase paramRenderingPhase) {
/*  40 */     if (paramRenderingPhase == RenderingPhase.HEAD_TOP) {
/*  41 */       this.headerIdGenerator.generateIds(paramDocument); return;
/*  42 */     }  if (paramRenderingPhase == RenderingPhase.BODY_TOP) {
/*  43 */       this.enumeratedOrdinals = (EnumeratedReferences)EnumeratedReferenceExtension.ENUMERATED_REFERENCE_ORDINALS.get((DataHolder)paramDocument);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*     */     HashSet<NodeRenderingHandler> hashSet;
/*  51 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(EnumeratedReferenceText.class, this::render));
/*  52 */     hashSet.add(new NodeRenderingHandler(EnumeratedReferenceLink.class, this::render));
/*  53 */     hashSet.add(new NodeRenderingHandler(EnumeratedReferenceBlock.class, this::render));
/*     */     
/*  55 */     return (Set)hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(final EnumeratedReferenceLink node, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     final String text;
/*  61 */     if ((str = node.getText().toString()).isEmpty())
/*     */     
/*  63 */     { if (this.ordinalRunnable != null) { this.ordinalRunnable.run(); return; }
/*     */        }
/*  65 */     else { this.enumeratedOrdinals.renderReferenceOrdinals(str, new OrdinalRenderer(this, paramNodeRendererContext, paramHtmlWriter)
/*     */           {
/*     */             public void startRendering(EnumeratedReferenceRendering[] param1ArrayOfEnumeratedReferenceRendering) {
/*  68 */               String str = (new EnumRefTextCollectingVisitor()).collectAndGetText(node.getChars().getBaseSequence(), param1ArrayOfEnumeratedReferenceRendering, null);
/*  69 */               ((HtmlWriter)((HtmlWriter)this.html.withAttr().attr("href", "#" + text)).attr("title", str)).tag("a");
/*     */             }
/*     */ 
/*     */             
/*     */             public void endRendering() {
/*  74 */               this.html.tag("/a");
/*     */             }
/*     */           }); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(EnumeratedReferenceText paramEnumeratedReferenceText, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     String str;
/*  83 */     if ((str = paramEnumeratedReferenceText.getText().toString()).isEmpty()) {
/*     */       
/*  85 */       if (this.ordinalRunnable != null) { this.ordinalRunnable.run(); return; }
/*     */     
/*     */     } else {
/*     */       Node node; String str1;
/*  89 */       if (((str1 = EnumeratedReferenceRepository.getType(str.toString())).isEmpty() || str.equals(str1 + ":")) && 
/*     */ 
/*     */         
/*  92 */         node = paramEnumeratedReferenceText.getAncestorOfType(new Class[] { Heading.class }) instanceof Heading) {
/*  93 */         str = (str1.isEmpty() ? str : str1) + ":" + this.headerIdGenerator.getId(node);
/*     */       }
/*     */ 
/*     */       
/*  97 */       this.enumeratedOrdinals.renderReferenceOrdinals(str, new OrdinalRenderer(this, paramNodeRendererContext, paramHtmlWriter));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class OrdinalRenderer implements EnumeratedOrdinalRenderer {
/*     */     final EnumeratedReferenceNodeRenderer renderer;
/*     */     final NodeRendererContext context;
/*     */     final HtmlWriter html;
/*     */     
/*     */     public OrdinalRenderer(EnumeratedReferenceNodeRenderer param1EnumeratedReferenceNodeRenderer, NodeRendererContext param1NodeRendererContext, HtmlWriter param1HtmlWriter) {
/* 107 */       this.renderer = param1EnumeratedReferenceNodeRenderer;
/* 108 */       this.context = param1NodeRendererContext;
/* 109 */       this.html = param1HtmlWriter;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void startRendering(EnumeratedReferenceRendering[] param1ArrayOfEnumeratedReferenceRendering) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void setEnumOrdinalRunnable(Runnable param1Runnable) {
/* 119 */       this.renderer.ordinalRunnable = param1Runnable;
/*     */     }
/*     */ 
/*     */     
/*     */     public Runnable getEnumOrdinalRunnable() {
/* 124 */       return this.renderer.ordinalRunnable;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(int param1Int, EnumeratedReferenceBlock param1EnumeratedReferenceBlock, String param1String, boolean param1Boolean) {
/* 129 */       Runnable runnable = this.renderer.ordinalRunnable;
/*     */       
/* 131 */       if (param1EnumeratedReferenceBlock != null) {
/* 132 */         this.renderer.ordinalRunnable = (() -> {
/*     */             if (param1Runnable != null)
/*     */               param1Runnable.run();  this.html.text(String.valueOf(param1Int));
/*     */             if (param1Boolean)
/*     */               this.html.text("."); 
/*     */           });
/* 138 */         this.context.renderChildren((Node)param1EnumeratedReferenceBlock); return;
/*     */       } 
/* 140 */       this.html.text(param1String + " ");
/* 141 */       if (runnable != null) runnable.run(); 
/* 142 */       this.html.text(String.valueOf(param1Int));
/* 143 */       if (param1Boolean) this.html.text(".");
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void endRendering() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(EnumeratedReferenceBlock paramEnumeratedReferenceBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 161 */       return (NodeRenderer)new EnumeratedReferenceNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */