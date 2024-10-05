/*     */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*     */ import com.vladsch.flexmark.ext.attributes.internal.AttributesNodeFormatter;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceBlock;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceLink;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceRepository;
/*     */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceText;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*     */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class EnumeratedReferenceNodeFormatter extends NodeRepositoryFormatter<EnumeratedReferenceRepository, EnumeratedReferenceBlock, EnumeratedReferenceText> {
/*     */   public EnumeratedReferenceNodeFormatter(DataHolder paramDataHolder) {
/*  22 */     super(paramDataHolder, null, AttributesNodeFormatter.ATTRIBUTE_UNIQUIFICATION_CATEGORY_MAP);
/*  23 */     this.options = new EnumeratedReferenceFormatOptions(paramDataHolder);
/*     */   }
/*     */   private final EnumeratedReferenceFormatOptions options;
/*     */   
/*     */   public EnumeratedReferenceRepository getRepository(DataHolder paramDataHolder) {
/*  28 */     return (EnumeratedReferenceRepository)EnumeratedReferenceExtension.ENUMERATED_REFERENCES.get(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public ElementPlacement getReferencePlacement() {
/*  33 */     return this.options.enumeratedReferencePlacement;
/*     */   }
/*     */ 
/*     */   
/*     */   public ElementPlacementSort getReferenceSort() {
/*  38 */     return this.options.enumeratedReferenceSort;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderReferenceBlock(EnumeratedReferenceBlock paramEnumeratedReferenceBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  43 */     ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.blankLine()).append("[@")).appendNonTranslating((CharSequence)paramEnumeratedReferenceBlock.getText()).append("]: ");
/*  44 */     ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix("    ", true);
/*  45 */     paramNodeFormatterContext.renderChildren((Node)paramEnumeratedReferenceBlock);
/*  46 */     paramMarkdownWriter.popPrefix();
/*  47 */     paramMarkdownWriter.blankLine();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*  53 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(EnumeratedReferenceText.class, this::render), new NodeFormattingHandler(EnumeratedReferenceLink.class, this::render), new NodeFormattingHandler(EnumeratedReferenceBlock.class, this::render) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Class<?>> getNodeClasses() {
/*  63 */     if (this.options.enumeratedReferencePlacement.isNoChange() || !this.options.enumeratedReferenceSort.isUnused()) return null;
/*     */     
/*  65 */     return new HashSet<>(Arrays.asList(new Class[] { EnumeratedReferenceBlock.class }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(EnumeratedReferenceBlock paramEnumeratedReferenceBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  71 */     renderReference((Node)paramEnumeratedReferenceBlock, paramNodeFormatterContext, paramMarkdownWriter);
/*     */   }
/*     */   
/*     */   private static void renderReferenceText(BasedSequence paramBasedSequence, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  75 */     if (!paramBasedSequence.isEmpty()) {
/*     */       BasedSequence basedSequence;
/*  77 */       int i = (basedSequence = paramBasedSequence).indexOf(':');
/*     */       
/*  79 */       String str2 = null;
/*  80 */       if (i == -1) {
/*  81 */         str1 = paramBasedSequence.toString();
/*     */       } else {
/*  83 */         str1 = basedSequence.subSequence(0, i).toString();
/*  84 */         str2 = ((BasedSequence)basedSequence.subSequence(i + 1)).toString();
/*     */       } 
/*     */       
/*  87 */       String str1 = AttributesNodeFormatter.getEncodedIdAttribute(str1, str2, paramNodeFormatterContext, paramMarkdownWriter);
/*  88 */       paramMarkdownWriter.append(str1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void render(EnumeratedReferenceText paramEnumeratedReferenceText, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  93 */     paramMarkdownWriter.append("[#");
/*  94 */     if (paramNodeFormatterContext.isTransformingText()) {
/*  95 */       renderReferenceText(paramEnumeratedReferenceText.getText(), paramNodeFormatterContext, paramMarkdownWriter);
/*     */     } else {
/*  97 */       paramNodeFormatterContext.renderChildren((Node)paramEnumeratedReferenceText);
/*     */     } 
/*  99 */     paramMarkdownWriter.append("]");
/*     */   }
/*     */   
/*     */   private void render(EnumeratedReferenceLink paramEnumeratedReferenceLink, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 103 */     paramMarkdownWriter.append("[@");
/* 104 */     if (paramNodeFormatterContext.isTransformingText()) {
/* 105 */       renderReferenceText(paramEnumeratedReferenceLink.getText(), paramNodeFormatterContext, paramMarkdownWriter);
/*     */     } else {
/* 107 */       paramNodeFormatterContext.renderChildren((Node)paramEnumeratedReferenceLink);
/*     */     } 
/* 109 */     paramMarkdownWriter.append("]");
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements NodeFormatterFactory
/*     */   {
/*     */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 116 */       return (NodeFormatter)new EnumeratedReferenceNodeFormatter(param1DataHolder);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getAfterDependents() {
/*     */       HashSet<Class<AttributesNodeFormatter.Factory>> hashSet;
/* 125 */       (hashSet = new HashSet<>()).add(AttributesNodeFormatter.Factory.class);
/* 126 */       return hashSet;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 132 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */