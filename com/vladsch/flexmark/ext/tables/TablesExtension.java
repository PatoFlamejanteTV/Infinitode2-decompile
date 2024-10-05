/*    */ package com.vladsch.flexmark.ext.tables;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.tables.internal.TableJiraRenderer;
/*    */ import com.vladsch.flexmark.ext.tables.internal.TableNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.tables.internal.TableNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.tables.internal.TableParagraphPreProcessor;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*    */ import com.vladsch.flexmark.util.format.CharWidthProvider;
/*    */ import com.vladsch.flexmark.util.format.TableFormatOptions;
/*    */ import com.vladsch.flexmark.util.format.TableManipulator;
/*    */ import com.vladsch.flexmark.util.format.options.DiscretionaryText;
/*    */ import com.vladsch.flexmark.util.format.options.TableCaptionHandling;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TablesExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 29 */   public static final DataKey<Boolean> TRIM_CELL_WHITESPACE = new DataKey("TRIM_CELL_WHITESPACE", Boolean.TRUE);
/* 30 */   public static final DataKey<Integer> MIN_SEPARATOR_DASHES = new DataKey("MIN_SEPARATOR_DASHES", Integer.valueOf(3));
/* 31 */   public static final DataKey<Integer> MAX_HEADER_ROWS = new DataKey("MAX_HEADER_ROWS", Integer.valueOf(2147483647));
/* 32 */   public static final DataKey<Integer> MIN_HEADER_ROWS = new DataKey("MIN_HEADER_ROWS", Integer.valueOf(0));
/* 33 */   public static final DataKey<Boolean> APPEND_MISSING_COLUMNS = new DataKey("APPEND_MISSING_COLUMNS", Boolean.FALSE);
/* 34 */   public static final DataKey<Boolean> DISCARD_EXTRA_COLUMNS = new DataKey("DISCARD_EXTRA_COLUMNS", Boolean.FALSE);
/* 35 */   public static final DataKey<Boolean> COLUMN_SPANS = new DataKey("COLUMN_SPANS", Boolean.TRUE);
/* 36 */   public static final DataKey<Boolean> HEADER_SEPARATOR_COLUMN_MATCH = new DataKey("HEADER_SEPARATOR_COLUMN_MATCH", Boolean.FALSE);
/* 37 */   public static final DataKey<String> CLASS_NAME = new DataKey("CLASS_NAME", "");
/* 38 */   public static final DataKey<Boolean> WITH_CAPTION = new DataKey("WITH_CAPTION", Boolean.TRUE);
/*    */ 
/*    */   
/* 41 */   public static final DataKey<Boolean> FORMAT_TABLE_TRIM_CELL_WHITESPACE = TableFormatOptions.FORMAT_TABLE_TRIM_CELL_WHITESPACE;
/* 42 */   public static final DataKey<Boolean> FORMAT_TABLE_LEAD_TRAIL_PIPES = TableFormatOptions.FORMAT_TABLE_LEAD_TRAIL_PIPES;
/* 43 */   public static final DataKey<Boolean> FORMAT_TABLE_SPACE_AROUND_PIPES = TableFormatOptions.FORMAT_TABLE_SPACE_AROUND_PIPES;
/* 44 */   public static final DataKey<Boolean> FORMAT_TABLE_ADJUST_COLUMN_WIDTH = TableFormatOptions.FORMAT_TABLE_ADJUST_COLUMN_WIDTH;
/* 45 */   public static final DataKey<Boolean> FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT = TableFormatOptions.FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT;
/* 46 */   public static final DataKey<Boolean> FORMAT_TABLE_FILL_MISSING_COLUMNS = TableFormatOptions.FORMAT_TABLE_FILL_MISSING_COLUMNS;
/*    */ 
/*    */   
/* 49 */   public static final NullableDataKey<Integer> FORMAT_TABLE_FILL_MISSING_MIN_COLUMN = TableFormatOptions.FORMAT_TABLE_FILL_MISSING_MIN_COLUMN;
/*    */   
/* 51 */   public static final DataKey<DiscretionaryText> FORMAT_TABLE_LEFT_ALIGN_MARKER = TableFormatOptions.FORMAT_TABLE_LEFT_ALIGN_MARKER;
/* 52 */   public static final DataKey<Integer> FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH = TableFormatOptions.FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH;
/* 53 */   public static final DataKey<Integer> FORMAT_TABLE_MIN_SEPARATOR_DASHES = TableFormatOptions.FORMAT_TABLE_MIN_SEPARATOR_DASHES;
/* 54 */   public static final DataKey<CharWidthProvider> FORMAT_CHAR_WIDTH_PROVIDER = TableFormatOptions.FORMAT_CHAR_WIDTH_PROVIDER;
/* 55 */   public static final DataKey<TableManipulator> FORMAT_TABLE_MANIPULATOR = TableFormatOptions.FORMAT_TABLE_MANIPULATOR;
/* 56 */   public static final DataKey<TableCaptionHandling> FORMAT_TABLE_CAPTION = TableFormatOptions.FORMAT_TABLE_CAPTION;
/* 57 */   public static final DataKey<DiscretionaryText> FORMAT_TABLE_CAPTION_SPACES = TableFormatOptions.FORMAT_TABLE_CAPTION_SPACES;
/* 58 */   public static final DataKey<String> FORMAT_TABLE_INDENT_PREFIX = TableFormatOptions.FORMAT_TABLE_INDENT_PREFIX;
/*    */   
/*    */   public static TablesExtension create() {
/* 61 */     return new TablesExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 66 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new TableNodeFormatter.Factory());
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
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 81 */     paramBuilder.paragraphPreProcessorFactory(TableParagraphPreProcessor.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 86 */     if (paramBuilder.isRendererType("HTML")) {
/* 87 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new TableNodeRenderer.Factory()); return;
/* 88 */     }  if (paramBuilder.isRendererType("JIRA"))
/* 89 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new TableJiraRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TablesExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */