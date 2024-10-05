/*    */ package com.vladsch.flexmark.ext.macros.internal;
/*    */ import com.vladsch.flexmark.ext.macros.MacroDefinitionBlock;
/*    */ import com.vladsch.flexmark.ext.macros.MacroReference;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MacrosNodeFormatter extends NodeRepositoryFormatter<MacroDefinitionRepository, MacroDefinitionBlock, MacroReference> {
/* 19 */   public static final DataKey<Map<String, String>> MACROS_TRANSLATION_MAP = new DataKey("MACROS_TRANSLATION_MAP", new HashMap<>());
/* 20 */   public static final DataKey<Map<String, String>> MACROS_UNIQUIFICATION_MAP = new DataKey("MACROS_UNIQUIFICATION_MAP", new HashMap<>());
/*    */   private final MacroFormatOptions options;
/*    */   
/*    */   public MacrosNodeFormatter(DataHolder paramDataHolder) {
/* 24 */     super(paramDataHolder, MACROS_TRANSLATION_MAP, MACROS_UNIQUIFICATION_MAP);
/* 25 */     this.options = new MacroFormatOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public MacroDefinitionRepository getRepository(DataHolder paramDataHolder) {
/* 30 */     return (MacroDefinitionRepository)MacrosExtension.MACRO_DEFINITIONS.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public ElementPlacement getReferencePlacement() {
/* 35 */     return this.options.macrosPlacement;
/*    */   }
/*    */ 
/*    */   
/*    */   public ElementPlacementSort getReferenceSort() {
/* 40 */     return this.options.macrosSort;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderReferenceBlock(MacroDefinitionBlock paramMacroDefinitionBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 45 */     ((MarkdownWriter)((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.blankLine()).append(">>>")).append(transformReferenceId(paramMacroDefinitionBlock.getName().toString(), paramNodeFormatterContext))).line();
/*    */     Node node;
/* 47 */     if (node = paramMacroDefinitionBlock.getFirstChild() instanceof com.vladsch.flexmark.ast.Paragraph && node == paramMacroDefinitionBlock.getLastChild()) {
/*    */       
/* 49 */       paramNodeFormatterContext.renderChildren(node);
/*    */     } else {
/* 51 */       paramNodeFormatterContext.renderChildren((Node)paramMacroDefinitionBlock);
/*    */     } 
/* 53 */     ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.line()).append("<<<")).blankLine();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/* 59 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(MacroReference.class, this::render), new NodeFormattingHandler(MacroDefinitionBlock.class, this::render) }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 68 */     if (this.options.macrosPlacement.isNoChange() || !this.options.macrosSort.isUnused()) return null;
/*    */     
/* 70 */     return new HashSet<>(Arrays.asList(new Class[] { MacroReference.class }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(MacroDefinitionBlock paramMacroDefinitionBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 76 */     renderReference((Node)paramMacroDefinitionBlock, paramNodeFormatterContext, paramMarkdownWriter);
/*    */   }
/*    */   private void render(MacroReference paramMacroReference, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*    */     String str;
/* 80 */     paramMarkdownWriter.append("<<<");
/* 81 */     if (paramNodeFormatterContext.isTransformingText()) {
/* 82 */       str = transformReferenceId(paramMacroReference.getText().toString(), paramNodeFormatterContext);
/* 83 */       paramNodeFormatterContext.nonTranslatingSpan((paramNodeFormatterContext, paramMarkdownWriter) -> paramMarkdownWriter.append(paramString));
/*    */     } else {
/* 85 */       paramMarkdownWriter.append((CharSequence)str.getText());
/*    */     } 
/* 87 */     paramMarkdownWriter.append(">>>");
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 94 */       return (NodeFormatter)new MacrosNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\internal\MacrosNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */