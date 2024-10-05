/*     */ package com.vladsch.flexmark.ext.wikilink.internal;
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiImage;
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiLink;
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiNode;
/*     */ import com.vladsch.flexmark.formatter.FormattingPhase;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*     */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*     */ import com.vladsch.flexmark.formatter.RenderPurpose;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpaceMapper;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class WikiLinkNodeFormatter implements PhasedNodeFormatter {
/*  23 */   public static final HashSet<FormattingPhase> FORMATTING_PHASES = new HashSet<>(Arrays.asList(new FormattingPhase[] { FormattingPhase.COLLECT, FormattingPhase.DOCUMENT_TOP }));
/*     */ 
/*     */   
/*     */   private Map<String, String> attributeUniquificationIdMap;
/*     */ 
/*     */   
/*     */   private WikiLinkOptions options;
/*     */ 
/*     */ 
/*     */   
/*     */   public WikiLinkNodeFormatter(DataHolder paramDataHolder) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*  38 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(WikiLink.class, this::render), new NodeFormattingHandler(WikiImage.class, this::render) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Class<?>> getNodeClasses() {
/*  47 */     return new HashSet<>(Arrays.asList(new Class[] { WikiLink.class, WikiImage.class }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<FormattingPhase> getFormattingPhases() {
/*  56 */     return FORMATTING_PHASES;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDocument(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument, FormattingPhase paramFormattingPhase) {
/*  61 */     this.attributeUniquificationIdMap = (Map<String, String>)Formatter.ATTRIBUTE_UNIQUIFICATION_ID_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/*  62 */     this.options = new WikiLinkOptions((DataHolder)paramDocument);
/*     */   }
/*     */   
/*     */   private void render(WikiLink paramWikiLink, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  66 */     paramMarkdownWriter.append((CharSequence)paramWikiLink.getOpeningMarker());
/*  67 */     if (paramWikiLink.isLinkIsFirst()) {
/*  68 */       renderLink((WikiNode)paramWikiLink, paramNodeFormatterContext, paramMarkdownWriter);
/*  69 */       renderText((WikiNode)paramWikiLink, paramNodeFormatterContext, paramMarkdownWriter);
/*     */     } else {
/*  71 */       renderText((WikiNode)paramWikiLink, paramNodeFormatterContext, paramMarkdownWriter);
/*  72 */       renderLink((WikiNode)paramWikiLink, paramNodeFormatterContext, paramMarkdownWriter);
/*     */     } 
/*  74 */     paramMarkdownWriter.append((CharSequence)paramWikiLink.getClosingMarker());
/*     */   }
/*     */   
/*     */   private void render(WikiImage paramWikiImage, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  78 */     paramMarkdownWriter.append((CharSequence)paramWikiImage.getOpeningMarker());
/*  79 */     if (paramWikiImage.isLinkIsFirst()) {
/*  80 */       renderLink((WikiNode)paramWikiImage, paramNodeFormatterContext, paramMarkdownWriter);
/*  81 */       renderText((WikiNode)paramWikiImage, paramNodeFormatterContext, paramMarkdownWriter);
/*     */     } else {
/*  83 */       renderText((WikiNode)paramWikiImage, paramNodeFormatterContext, paramMarkdownWriter);
/*  84 */       renderLink((WikiNode)paramWikiImage, paramNodeFormatterContext, paramMarkdownWriter);
/*     */     } 
/*  86 */     paramMarkdownWriter.append((CharSequence)paramWikiImage.getClosingMarker());
/*     */   }
/*     */   
/*     */   private void renderText(WikiNode paramWikiNode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  90 */     if (!paramNodeFormatterContext.isTransformingText()) {
/*  91 */       if (paramWikiNode.getText().isNotNull()) {
/*  92 */         if (paramWikiNode.isLinkIsFirst()) {
/*  93 */           paramMarkdownWriter.append((CharSequence)paramWikiNode.getTextSeparatorMarker());
/*     */         }
/*     */         
/*  96 */         if ((paramNodeFormatterContext.getFormatterOptions()).rightMargin > 0) {
/*     */           
/*  98 */           paramMarkdownWriter.append((CharSequence)paramWikiNode.getText().toMapped(SpaceMapper.toNonBreakSpace));
/*     */         } else {
/* 100 */           paramNodeFormatterContext.renderChildren((Node)paramWikiNode);
/*     */         } 
/*     */         
/* 103 */         if (!paramWikiNode.isLinkIsFirst()) {
/* 104 */           paramMarkdownWriter.append((CharSequence)paramWikiNode.getTextSeparatorMarker()); return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 108 */       BasedSequence basedSequence; switch (paramNodeFormatterContext.getRenderPurpose()) {
/*     */         case TRANSLATION_SPANS:
/*     */         case TRANSLATED_SPANS:
/* 111 */           if (paramWikiNode.isLinkIsFirst()) {
/* 112 */             paramMarkdownWriter.append('|');
/*     */           }
/*     */           
/* 115 */           basedSequence = paramWikiNode.getText().isNull() ? paramWikiNode.getPageRef() : paramWikiNode.getText();
/* 116 */           if (this.options.allowInlines) {
/* 117 */             paramNodeFormatterContext.renderChildren((Node)paramWikiNode);
/*     */           } else {
/* 119 */             paramMarkdownWriter.appendTranslating(basedSequence.unescape());
/*     */           } 
/*     */           
/* 122 */           if (!paramWikiNode.isLinkIsFirst()) {
/* 123 */             paramMarkdownWriter.append('|');
/*     */             return;
/*     */           } 
/*     */           return;
/*     */         case TRANSLATED:
/* 128 */           if (paramWikiNode.isLinkIsFirst()) {
/* 129 */             paramMarkdownWriter.append((CharSequence)paramWikiNode.getTextSeparatorMarker());
/*     */           }
/*     */           
/* 132 */           if (this.options.allowInlines) {
/* 133 */             paramNodeFormatterContext.renderChildren((Node)paramWikiNode);
/*     */           } else {
/* 135 */             CharSequence charSequence = paramNodeFormatterContext.transformTranslating(null, (CharSequence)paramWikiNode.getText(), null, null);
/* 136 */             paramMarkdownWriter.append(escapePipeAnchors(charSequence));
/*     */           } 
/*     */           
/* 139 */           if (!paramWikiNode.isLinkIsFirst()) {
/* 140 */             paramMarkdownWriter.append((CharSequence)paramWikiNode.getTextSeparatorMarker());
/*     */             return;
/*     */           } 
/*     */           return;
/*     */       } 
/*     */       
/* 146 */       throw new IllegalStateException("Unexpected renderer purpose");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private CharSequence escapeUnescapedPipeAnchors(CharSequence paramCharSequence) {
/* 153 */     boolean bool = false;
/* 154 */     int i = paramCharSequence.length();
/* 155 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 157 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/*     */       
/* 160 */       switch (c = paramCharSequence.charAt(b)) {
/*     */         case '\\':
/* 162 */           bool = !bool ? true : false;
/*     */           break;
/*     */         
/*     */         case '|':
/* 166 */           if (!bool && this.options.allowPipeEscape) stringBuilder.append('\\');
/*     */           
/*     */           break;
/*     */         case '#':
/* 170 */           if (!bool && this.options.allowAnchors && this.options.allowAnchorEscape) stringBuilder.append('\\');
/*     */           
/*     */           break;
/*     */         default:
/* 174 */           bool = false;
/*     */           break;
/*     */       } 
/*     */       
/* 178 */       stringBuilder.append(c);
/*     */     } 
/*     */     
/* 181 */     if (bool)
/*     */     {
/* 183 */       stringBuilder.append('\\');
/*     */     }
/*     */     
/* 186 */     return stringBuilder;
/*     */   }
/*     */ 
/*     */   
/*     */   private CharSequence escapePipeAnchors(CharSequence paramCharSequence) {
/* 191 */     int i = paramCharSequence.length();
/* 192 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 194 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/*     */       
/* 197 */       switch (c = paramCharSequence.charAt(b)) {
/*     */         case '\\':
/* 199 */           stringBuilder.append('\\');
/*     */           break;
/*     */         
/*     */         case '|':
/* 203 */           if (this.options.allowPipeEscape) stringBuilder.append('\\');
/*     */           
/*     */           break;
/*     */         case '#':
/* 207 */           if (this.options.allowAnchors && this.options.allowAnchorEscape) stringBuilder.append('\\');
/*     */           
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 214 */       stringBuilder.append(c);
/*     */     } 
/*     */     
/* 217 */     return stringBuilder;
/*     */   }
/*     */   
/*     */   private void renderLink(WikiNode paramWikiNode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 221 */     if (!paramNodeFormatterContext.isTransformingText()) {
/* 222 */       if ((paramNodeFormatterContext.getFormatterOptions()).rightMargin > 0) {
/*     */         
/* 224 */         paramMarkdownWriter.append((CharSequence)paramWikiNode.getLink().toMapped(SpaceMapper.toNonBreakSpace)); return;
/*     */       } 
/* 226 */       paramMarkdownWriter.append((CharSequence)paramWikiNode.getLink());
/*     */       return;
/*     */     } 
/* 229 */     if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
/* 230 */       paramMarkdownWriter.appendNonTranslating((CharSequence)paramWikiNode.getPageRef());
/* 231 */       paramMarkdownWriter.append((CharSequence)paramWikiNode.getAnchorMarker());
/* 232 */       if (paramWikiNode.getAnchorRef().isNotNull()) {
/* 233 */         CharSequence charSequence = paramNodeFormatterContext.transformAnchorRef((CharSequence)paramWikiNode.getPageRef(), (CharSequence)paramWikiNode.getAnchorRef());
/* 234 */         paramMarkdownWriter.append(charSequence); return;
/*     */       } 
/*     */     } else {
/* 237 */       CharSequence charSequence = paramNodeFormatterContext.transformNonTranslating(null, (CharSequence)paramWikiNode.getPageRef(), null, null);
/*     */       
/* 239 */       paramMarkdownWriter.append(escapeUnescapedPipeAnchors(charSequence));
/* 240 */       paramMarkdownWriter.append((CharSequence)paramWikiNode.getAnchorMarker());
/* 241 */       if (paramWikiNode.getAnchorRef().isNotNull()) {
/* 242 */         CharSequence charSequence1 = paramNodeFormatterContext.transformAnchorRef((CharSequence)paramWikiNode.getPageRef(), (CharSequence)paramWikiNode.getAnchorRef());
/* 243 */         if (this.attributeUniquificationIdMap != null && paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED && paramNodeFormatterContext.getMergeContext() != null) {
/* 244 */           charSequence1 = String.valueOf(charSequence1);
/* 245 */           if (charSequence.length() == 0) {
/* 246 */             charSequence1 = this.attributeUniquificationIdMap.getOrDefault(charSequence1, charSequence1);
/*     */           }
/* 248 */           paramMarkdownWriter.append(charSequence1); return;
/*     */         } 
/* 250 */         paramMarkdownWriter.append(charSequence1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeFormatterFactory
/*     */   {
/*     */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 261 */       return (NodeFormatter)new WikiLinkNodeFormatter(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\internal\WikiLinkNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */