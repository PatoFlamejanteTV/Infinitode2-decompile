/*     */ package com.vladsch.flexmark.ext.abbreviation.internal;
/*     */ import com.vladsch.flexmark.ext.abbreviation.Abbreviation;
/*     */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationBlock;
/*     */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class AbbreviationNodeFormatter extends NodeRepositoryFormatter<AbbreviationRepository, AbbreviationBlock, Abbreviation> {
/*  18 */   public static final DataKey<Map<String, String>> ABBREVIATION_TRANSLATION_MAP = new DataKey("ABBREVIATION_TRANSLATION_MAP", new HashMap<>());
/*  19 */   public static final DataKey<Map<String, String>> ABBREVIATION_UNIQUIFICATION_MAP = new DataKey("ABBREVIATION_UNIQUIFICATION_MAP", new HashMap<>());
/*     */   private final AbbreviationFormatOptions options;
/*     */   private final boolean transformUnderscores;
/*     */   private final boolean makeMergedAbbreviationsUnique;
/*     */   
/*     */   public AbbreviationNodeFormatter(DataHolder paramDataHolder) {
/*  25 */     super(paramDataHolder, ABBREVIATION_TRANSLATION_MAP, ABBREVIATION_UNIQUIFICATION_MAP);
/*  26 */     this.options = new AbbreviationFormatOptions(paramDataHolder);
/*     */     
/*  28 */     String str = String.format((String)Formatter.TRANSLATION_ID_FORMAT.get(paramDataHolder), new Object[] { Integer.valueOf(1) });
/*  29 */     this.transformUnderscores = (str.startsWith("_") && str.endsWith("_"));
/*  30 */     this.makeMergedAbbreviationsUnique = ((Boolean)AbbreviationExtension.MAKE_MERGED_ABBREVIATIONS_UNIQUE.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean makeReferencesUnique() {
/*  35 */     return this.makeMergedAbbreviationsUnique;
/*     */   }
/*     */ 
/*     */   
/*     */   public AbbreviationRepository getRepository(DataHolder paramDataHolder) {
/*  40 */     return (AbbreviationRepository)AbbreviationExtension.ABBREVIATIONS.get(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public ElementPlacement getReferencePlacement() {
/*  45 */     return this.options.abbreviationsPlacement;
/*     */   }
/*     */ 
/*     */   
/*     */   public ElementPlacementSort getReferenceSort() {
/*  50 */     return this.options.abbreviationsSort;
/*     */   }
/*     */ 
/*     */   
/*     */   public String modifyTransformedReference(String paramString, NodeFormatterContext paramNodeFormatterContext) {
/*  55 */     if (this.transformUnderscores && paramNodeFormatterContext.isTransformingText()) {
/*  56 */       if (paramString.startsWith("-") && paramString.endsWith("-")) {
/*  57 */         paramString = "_" + paramString.substring(1, paramString.length() - 1) + "_";
/*  58 */       } else if (paramString.startsWith("_") && paramString.endsWith("_")) {
/*  59 */         paramString = "-" + paramString.substring(1, paramString.length() - 1) + "-";
/*     */       } 
/*     */     }
/*     */     
/*  63 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderReferenceBlock(AbbreviationBlock paramAbbreviationBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  68 */     paramMarkdownWriter.append((CharSequence)paramAbbreviationBlock.getOpeningMarker());
/*  69 */     paramMarkdownWriter.append(transformReferenceId(paramAbbreviationBlock.getText().toString(), paramNodeFormatterContext));
/*  70 */     ((MarkdownWriter)paramMarkdownWriter.append((CharSequence)paramAbbreviationBlock.getClosingMarker())).append(' ');
/*  71 */     paramMarkdownWriter.appendTranslating((CharSequence)paramAbbreviationBlock.getAbbreviation()).line();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*  77 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(Abbreviation.class, this::render), new NodeFormattingHandler(AbbreviationBlock.class, this::render) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Class<?>> getNodeClasses() {
/*  86 */     if (this.options.abbreviationsPlacement.isNoChange() || !this.options.abbreviationsSort.isUnused()) return null;
/*     */     
/*  88 */     return new HashSet<>(Arrays.asList(new Class[] { Abbreviation.class }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(AbbreviationBlock paramAbbreviationBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  94 */     renderReference((Node)paramAbbreviationBlock, paramNodeFormatterContext, paramMarkdownWriter);
/*     */   }
/*     */   private void render(Abbreviation paramAbbreviation, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*     */     String str;
/*  98 */     if (paramNodeFormatterContext.isTransformingText()) {
/*  99 */       str = transformReferenceId(paramAbbreviation.getChars().toString(), paramNodeFormatterContext);
/* 100 */       paramMarkdownWriter.append(str); return;
/*     */     } 
/* 102 */     paramMarkdownWriter.append((CharSequence)str.getChars());
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeFormatterFactory
/*     */   {
/*     */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 110 */       return (NodeFormatter)new AbbreviationNodeFormatter(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\internal\AbbreviationNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */