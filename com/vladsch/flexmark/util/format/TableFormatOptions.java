/*     */ package com.vladsch.flexmark.util.format;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*     */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*     */ import com.vladsch.flexmark.util.format.options.DiscretionaryText;
/*     */ import com.vladsch.flexmark.util.format.options.TableCaptionHandling;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ 
/*     */ public class TableFormatOptions implements MutableDataSetter {
/*     */   public static final char INTELLIJ_DUMMY_IDENTIFIER_CHAR = '\037';
/*  14 */   public static final String INTELLIJ_DUMMY_IDENTIFIER = SequenceUtils.US_CHARS; static {
/*  15 */     INTELLIJ_DUMMY_IDENTIFIER_SET = (paramInt -> (paramInt == 31));
/*     */   }
/*  17 */   public static final CharPredicate INTELLIJ_DUMMY_IDENTIFIER_SET; public static final DataKey<Boolean> FORMAT_TABLE_LEAD_TRAIL_PIPES = new DataKey("FORMAT_TABLE_LEAD_TRAIL_PIPES", Boolean.TRUE);
/*  18 */   public static final DataKey<Boolean> FORMAT_TABLE_SPACE_AROUND_PIPES = new DataKey("FORMAT_TABLE_SPACE_AROUND_PIPES", Boolean.TRUE);
/*  19 */   public static final DataKey<Boolean> FORMAT_TABLE_ADJUST_COLUMN_WIDTH = new DataKey("FORMAT_TABLE_ADJUST_COLUMN_WIDTH", Boolean.TRUE);
/*  20 */   public static final DataKey<Boolean> FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT = new DataKey("FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT", Boolean.TRUE);
/*  21 */   public static final DataKey<Boolean> FORMAT_TABLE_FILL_MISSING_COLUMNS = new DataKey("FORMAT_TABLE_FILL_MISSING_COLUMNS", Boolean.FALSE);
/*     */ 
/*     */ 
/*     */   
/*  25 */   public static final NullableDataKey<Integer> FORMAT_TABLE_FILL_MISSING_MIN_COLUMN = new NullableDataKey("FORMAT_TABLE_FILL_MISSING_MIN_COLUMN", null);
/*     */   
/*  27 */   public static final DataKey<DiscretionaryText> FORMAT_TABLE_LEFT_ALIGN_MARKER = new DataKey("FORMAT_TABLE_LEFT_ALIGN_MARKER", DiscretionaryText.AS_IS);
/*  28 */   public static final DataKey<Integer> FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH = new DataKey("FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH", Integer.valueOf(3));
/*  29 */   public static final DataKey<Integer> FORMAT_TABLE_MIN_SEPARATOR_DASHES = new DataKey("FORMAT_TABLE_MIN_SEPARATOR_DASHES", Integer.valueOf(1));
/*  30 */   public static final DataKey<Boolean> FORMAT_TABLE_TRIM_CELL_WHITESPACE = new DataKey("FORMAT_TABLE_TRIM_CELL_WHITESPACE", Boolean.TRUE);
/*  31 */   public static final DataKey<TableCaptionHandling> FORMAT_TABLE_CAPTION = new DataKey("FORMAT_TABLE_CAPTION", TableCaptionHandling.AS_IS);
/*  32 */   public static final DataKey<DiscretionaryText> FORMAT_TABLE_CAPTION_SPACES = new DataKey("FORMAT_TABLE_CAPTION_SPACES", DiscretionaryText.AS_IS);
/*  33 */   public static final DataKey<String> FORMAT_TABLE_INDENT_PREFIX = new DataKey("FORMAT_TABLE_INDENT_PREFIX", "");
/*  34 */   public static final DataKey<TableManipulator> FORMAT_TABLE_MANIPULATOR = new DataKey("FORMAT_TABLE_MANIPULATOR", TableManipulator.NULL);
/*     */   
/*  36 */   public static final DataKey<CharWidthProvider> FORMAT_CHAR_WIDTH_PROVIDER = new DataKey("FORMAT_CHAR_WIDTH_PROVIDER", CharWidthProvider.NULL);
/*  37 */   public static final DataKey<Boolean> FORMAT_TABLE_DUMP_TRACKING_OFFSETS = new DataKey("FORMAT_TABLE_DUMP_TRACKING_OFFSETS", Boolean.FALSE);
/*     */   
/*     */   public final boolean leadTrailPipes;
/*     */   
/*     */   public final boolean spaceAroundPipes;
/*     */   
/*     */   public final boolean adjustColumnWidth;
/*     */   public final boolean applyColumnAlignment;
/*     */   public final boolean fillMissingColumns;
/*     */   public final Integer formatTableFillMissingMinColumn;
/*     */   public final boolean trimCellWhitespace;
/*     */   public final boolean dumpIntellijOffsets;
/*     */   public final DiscretionaryText leftAlignMarker;
/*     */   public final TableCaptionHandling formatTableCaption;
/*     */   public final DiscretionaryText formatTableCaptionSpaces;
/*     */   public final int minSeparatorColumnWidth;
/*     */   public final int minSeparatorDashes;
/*     */   public final CharWidthProvider charWidthProvider;
/*     */   public final String formatTableIndentPrefix;
/*     */   public final TableManipulator tableManipulator;
/*     */   public final int spaceWidth;
/*     */   public final int spacePad;
/*     */   public final int pipeWidth;
/*     */   public final int colonWidth;
/*     */   public final int dashWidth;
/*     */   
/*     */   public TableFormatOptions() {
/*  64 */     this(null);
/*     */   }
/*     */   
/*     */   public TableFormatOptions(DataHolder paramDataHolder) {
/*  68 */     this.leadTrailPipes = ((Boolean)FORMAT_TABLE_LEAD_TRAIL_PIPES.get(paramDataHolder)).booleanValue();
/*  69 */     this.spaceAroundPipes = ((Boolean)FORMAT_TABLE_SPACE_AROUND_PIPES.get(paramDataHolder)).booleanValue();
/*  70 */     this.adjustColumnWidth = ((Boolean)FORMAT_TABLE_ADJUST_COLUMN_WIDTH.get(paramDataHolder)).booleanValue();
/*  71 */     this.applyColumnAlignment = ((Boolean)FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT.get(paramDataHolder)).booleanValue();
/*  72 */     this.fillMissingColumns = ((Boolean)FORMAT_TABLE_FILL_MISSING_COLUMNS.get(paramDataHolder)).booleanValue();
/*  73 */     this.formatTableFillMissingMinColumn = (Integer)FORMAT_TABLE_FILL_MISSING_MIN_COLUMN.get(paramDataHolder);
/*  74 */     this.leftAlignMarker = (DiscretionaryText)FORMAT_TABLE_LEFT_ALIGN_MARKER.get(paramDataHolder);
/*  75 */     this.minSeparatorColumnWidth = ((Integer)FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH.get(paramDataHolder)).intValue();
/*  76 */     this.minSeparatorDashes = ((Integer)FORMAT_TABLE_MIN_SEPARATOR_DASHES.get(paramDataHolder)).intValue();
/*  77 */     this.charWidthProvider = (CharWidthProvider)FORMAT_CHAR_WIDTH_PROVIDER.get(paramDataHolder);
/*  78 */     this.formatTableCaption = (TableCaptionHandling)FORMAT_TABLE_CAPTION.get(paramDataHolder);
/*  79 */     this.formatTableCaptionSpaces = (DiscretionaryText)FORMAT_TABLE_CAPTION_SPACES.get(paramDataHolder);
/*  80 */     this.formatTableIndentPrefix = (String)FORMAT_TABLE_INDENT_PREFIX.get(paramDataHolder);
/*  81 */     this.trimCellWhitespace = ((Boolean)FORMAT_TABLE_TRIM_CELL_WHITESPACE.get(paramDataHolder)).booleanValue();
/*  82 */     this.tableManipulator = (TableManipulator)FORMAT_TABLE_MANIPULATOR.get(paramDataHolder);
/*  83 */     this.dumpIntellijOffsets = ((Boolean)FORMAT_TABLE_DUMP_TRACKING_OFFSETS.get(paramDataHolder)).booleanValue();
/*     */     
/*  85 */     this.spaceWidth = this.charWidthProvider.getSpaceWidth();
/*  86 */     this.spacePad = this.spaceAroundPipes ? (2 * this.spaceWidth) : 0;
/*  87 */     this.pipeWidth = this.charWidthProvider.getCharWidth('|');
/*  88 */     this.colonWidth = this.charWidthProvider.getCharWidth(':');
/*  89 */     this.dashWidth = this.charWidthProvider.getCharWidth('-');
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/*  95 */     paramMutableDataHolder.set(FORMAT_TABLE_LEAD_TRAIL_PIPES, Boolean.valueOf(this.leadTrailPipes));
/*  96 */     paramMutableDataHolder.set(FORMAT_TABLE_SPACE_AROUND_PIPES, Boolean.valueOf(this.spaceAroundPipes));
/*  97 */     paramMutableDataHolder.set(FORMAT_TABLE_ADJUST_COLUMN_WIDTH, Boolean.valueOf(this.adjustColumnWidth));
/*  98 */     paramMutableDataHolder.set(FORMAT_TABLE_APPLY_COLUMN_ALIGNMENT, Boolean.valueOf(this.applyColumnAlignment));
/*  99 */     paramMutableDataHolder.set(FORMAT_TABLE_FILL_MISSING_COLUMNS, Boolean.valueOf(this.fillMissingColumns));
/* 100 */     paramMutableDataHolder.set(FORMAT_TABLE_FILL_MISSING_MIN_COLUMN, this.formatTableFillMissingMinColumn);
/* 101 */     paramMutableDataHolder.set(FORMAT_TABLE_LEFT_ALIGN_MARKER, this.leftAlignMarker);
/* 102 */     paramMutableDataHolder.set(FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH, Integer.valueOf(this.minSeparatorColumnWidth));
/* 103 */     paramMutableDataHolder.set(FORMAT_TABLE_MIN_SEPARATOR_DASHES, Integer.valueOf(this.minSeparatorDashes));
/* 104 */     paramMutableDataHolder.set(FORMAT_CHAR_WIDTH_PROVIDER, this.charWidthProvider);
/* 105 */     paramMutableDataHolder.set(FORMAT_TABLE_CAPTION, this.formatTableCaption);
/* 106 */     paramMutableDataHolder.set(FORMAT_TABLE_CAPTION_SPACES, this.formatTableCaptionSpaces);
/* 107 */     paramMutableDataHolder.set(FORMAT_TABLE_INDENT_PREFIX, this.formatTableIndentPrefix);
/* 108 */     paramMutableDataHolder.set(FORMAT_TABLE_TRIM_CELL_WHITESPACE, Boolean.valueOf(this.trimCellWhitespace));
/* 109 */     paramMutableDataHolder.set(FORMAT_TABLE_MANIPULATOR, this.tableManipulator);
/* 110 */     paramMutableDataHolder.set(FORMAT_TABLE_DUMP_TRACKING_OFFSETS, Boolean.valueOf(this.dumpIntellijOffsets));
/* 111 */     return paramMutableDataHolder;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */