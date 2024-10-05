/*    */ package com.vladsch.flexmark.ext.enumerated.reference;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.internal.EnumeratedReferenceBlockParser;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.internal.EnumeratedReferenceLinkRefProcessor;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.internal.EnumeratedReferenceNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.internal.EnumeratedReferenceNodePostProcessor;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.internal.EnumeratedReferenceNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.data.DataNotNullValueFactory;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*    */ 
/*    */ public class EnumeratedReferenceExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension, Parser.ReferenceHoldingExtension
/*    */ {
/* 29 */   public static final DataKey<KeepType> ENUMERATED_REFERENCES_KEEP = new DataKey("ENUMERATED_REFERENCES_KEEP", KeepType.FIRST);
/* 30 */   public static final DataKey<EnumeratedReferenceRepository> ENUMERATED_REFERENCES = new DataKey("ENUMERATED_REFERENCES", new EnumeratedReferenceRepository(null), EnumeratedReferenceRepository::new);
/* 31 */   public static final DataKey<EnumeratedReferences> ENUMERATED_REFERENCE_ORDINALS = new DataKey("ENUMERATED_REFERENCE_ORDINALS", new EnumeratedReferences(null), EnumeratedReferences::new);
/*    */ 
/*    */   
/* 34 */   public static final DataKey<ElementPlacement> ENUMERATED_REFERENCE_PLACEMENT = new DataKey("ENUMERATED_REFERENCE_PLACEMENT", ElementPlacement.AS_IS);
/* 35 */   public static final DataKey<ElementPlacementSort> ENUMERATED_REFERENCE_SORT = new DataKey("ENUMERATED_REFERENCE_SORT", ElementPlacementSort.AS_IS);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static EnumeratedReferenceExtension create() {
/* 41 */     return new EnumeratedReferenceExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean transferReferences(MutableDataHolder paramMutableDataHolder, DataHolder paramDataHolder) {
/* 56 */     if (paramMutableDataHolder.contains((DataKeyBase)ENUMERATED_REFERENCES) && paramDataHolder.contains((DataKeyBase)ENUMERATED_REFERENCES)) {
/* 57 */       return Parser.transferReferences((NodeRepository)ENUMERATED_REFERENCES.get((DataHolder)paramMutableDataHolder), (NodeRepository)ENUMERATED_REFERENCES.get(paramDataHolder), (ENUMERATED_REFERENCES_KEEP.get((DataHolder)paramMutableDataHolder) == KeepType.FIRST));
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 65 */     paramBuilder.postProcessorFactory((PostProcessorFactory)new EnumeratedReferenceNodePostProcessor.Factory());
/* 66 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new EnumeratedReferenceBlockParser.Factory());
/* 67 */     paramBuilder.linkRefProcessorFactory((LinkRefProcessorFactory)new EnumeratedReferenceLinkRefProcessor.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 72 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new EnumeratedReferenceNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 77 */     if (paramBuilder.isRendererType("HTML")) {
/* 78 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new EnumeratedReferenceNodeRenderer.Factory()); return;
/* 79 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedReferenceExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */