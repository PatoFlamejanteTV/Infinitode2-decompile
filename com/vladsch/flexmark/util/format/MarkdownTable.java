/*      */ package com.vladsch.flexmark.util.format;
/*      */ 
/*      */ import com.vladsch.flexmark.util.ast.Node;
/*      */ import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
/*      */ import com.vladsch.flexmark.util.collection.MaxAggregator;
/*      */ import com.vladsch.flexmark.util.collection.MinAggregator;
/*      */ import com.vladsch.flexmark.util.data.DataHolder;
/*      */ import com.vladsch.flexmark.util.format.options.DiscretionaryText;
/*      */ import com.vladsch.flexmark.util.format.options.TableCaptionHandling;
/*      */ import com.vladsch.flexmark.util.html.CellAlignment;
/*      */ import com.vladsch.flexmark.util.misc.ArrayUtils;
/*      */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*      */ import com.vladsch.flexmark.util.misc.Pair;
/*      */ import com.vladsch.flexmark.util.misc.Ref;
/*      */ import com.vladsch.flexmark.util.misc.Utils;
/*      */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*      */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*      */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*      */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*      */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*      */ import java.util.ArrayList;
/*      */ import java.util.BitSet;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.function.BiFunction;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MarkdownTable
/*      */ {
/*      */   public final TableSection header;
/*      */   public final TableSection separator;
/*      */   public final TableSection body;
/*      */   public final TableSection caption;
/*      */   public TableFormatOptions options;
/*      */   private boolean isHeading;
/*      */   private boolean isSeparator;
/*      */   CharSequence formatTableIndentPrefix;
/*      */   private CellAlignment[] alignments;
/*      */   private int[] columnWidths;
/*   44 */   private final ArrayList<TrackedOffset> trackedOffsets = new ArrayList<>();
/*      */   
/*      */   private final TableSection[] ALL_SECTIONS;
/*      */   private final TableSection[] ALL_TABLE_ROWS;
/*      */   private final TableSection[] ALL_CONTENT_ROWS;
/*      */   private final TableSection[] ALL_HEADER_ROWS;
/*      */   private final TableSection[] ALL_BODY_ROWS;
/*   51 */   public static final CharPredicate COLON_TRIM_CHARS = CharPredicate.anyOf(new char[] { ':' });
/*      */   private final CharSequence tableChars;
/*      */   public static final NumericSuffixPredicate NO_SUFFIXES = paramString -> false;
/*      */   public static final NumericSuffixPredicate ALL_SUFFIXES_SORT = paramString -> true;
/*      */   
/*   56 */   public static final NumericSuffixPredicate ALL_SUFFIXES_NO_SORT = new NumericSuffixPredicate()
/*      */     {
/*      */       public final boolean test(String param1String) {
/*   59 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public final boolean sortSuffix(String param1String) {
/*   64 */         return false;
/*      */       }
/*      */     };
/*      */   
/*      */   public MarkdownTable(CharSequence paramCharSequence, DataHolder paramDataHolder) {
/*   69 */     this(paramCharSequence, new TableFormatOptions(paramDataHolder));
/*      */   }
/*      */   
/*      */   public MarkdownTable(CharSequence paramCharSequence, TableFormatOptions paramTableFormatOptions) {
/*   73 */     this.tableChars = paramCharSequence;
/*   74 */     this.formatTableIndentPrefix = (paramTableFormatOptions == null) ? "" : paramTableFormatOptions.formatTableIndentPrefix;
/*   75 */     this.header = new TableSection(TableSectionType.HEADER);
/*   76 */     this.separator = new TableSeparatorSection(TableSectionType.SEPARATOR);
/*   77 */     this.body = new TableSection(TableSectionType.BODY);
/*   78 */     this.caption = new TableCaptionSection(TableSectionType.CAPTION);
/*   79 */     this.isHeading = true;
/*   80 */     this.isSeparator = false;
/*   81 */     this.options = (paramTableFormatOptions == null) ? new TableFormatOptions(null) : paramTableFormatOptions;
/*      */     
/*   83 */     this.ALL_SECTIONS = new TableSection[] { this.header, this.separator, this.body, this.caption };
/*   84 */     this.ALL_TABLE_ROWS = new TableSection[] { this.header, this.separator, this.body };
/*   85 */     this.ALL_CONTENT_ROWS = new TableSection[] { this.header, this.body };
/*   86 */     this.ALL_HEADER_ROWS = new TableSection[] { this.header };
/*   87 */     this.ALL_BODY_ROWS = new TableSection[] { this.body };
/*      */   }
/*      */   
/*      */   public CharSequence getTableChars() {
/*   91 */     return this.tableChars;
/*      */   }
/*      */   
/*      */   public TableCell getCaptionCell() {
/*   95 */     return (this.caption.rows.size() > 0 && ((TableRow)this.caption.rows.get(0)).cells.size() > 0) ? ((TableRow)this.caption.rows.get(0)).cells.get(0) : TableCaptionSection.NULL_CELL;
/*      */   }
/*      */   
/*      */   public CharSequence getFormatTableIndentPrefix() {
/*   99 */     return this.formatTableIndentPrefix;
/*      */   }
/*      */   
/*      */   public void setFormatTableIndentPrefix(CharSequence paramCharSequence) {
/*  103 */     this.formatTableIndentPrefix = paramCharSequence;
/*      */   }
/*      */   
/*      */   public void setCaptionCell(TableCell paramTableCell) {
/*  107 */     if (this.caption.rows.size() == 0) {
/*  108 */       this.caption.rows.add(this.caption.defaultRow());
/*      */     }
/*      */     
/*  111 */     ((TableRow)this.caption.rows.get(0)).cells.clear();
/*  112 */     ((TableRow)this.caption.rows.get(0)).cells.add(paramTableCell);
/*      */   }
/*      */   
/*      */   public BasedSequence getCaption() {
/*  116 */     return (getCaptionCell()).text;
/*      */   }
/*      */   
/*      */   public void setCaption(CharSequence paramCharSequence) {
/*  120 */     TableCell tableCell = getCaptionCell();
/*  121 */     setCaptionCell(tableCell.withText(tableCell.openMarker.isEmpty() ? "[" : (CharSequence)tableCell.openMarker, paramCharSequence, tableCell.closeMarker.isEmpty() ? "]" : (CharSequence)tableCell.closeMarker));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCaptionWithMarkers(Node paramNode, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3) {
/*  134 */     setCaptionCell(new TableCell(paramNode, paramCharSequence1, (this.options.formatTableCaptionSpaces == DiscretionaryText.AS_IS) ? paramCharSequence2 : (CharSequence)BasedSequence.of(paramCharSequence2).trim(), paramCharSequence3, 1, 1));
/*      */   }
/*      */   
/*      */   public int getHeadingRowCount() {
/*  138 */     return this.header.rows.size();
/*      */   }
/*      */   
/*      */   public int getSeparatorRowCount() {
/*  142 */     return this.separator.rows.size();
/*      */   }
/*      */   
/*      */   public int getBodyRowCount() {
/*  146 */     return this.body.rows.size();
/*      */   }
/*      */   
/*      */   public int getCaptionRowCount() {
/*  150 */     return this.caption.rows.size();
/*      */   }
/*      */   
/*      */   public int getMaxHeadingColumns() {
/*  154 */     return this.header.getMaxColumns();
/*      */   }
/*      */   
/*      */   public int getMaxSeparatorColumns() {
/*  158 */     return this.separator.getMaxColumns();
/*      */   }
/*      */   
/*      */   public int getMaxBodyColumns() {
/*  162 */     return this.body.getMaxColumns();
/*      */   }
/*      */   
/*      */   public boolean getHaveCaption() {
/*  166 */     return (this.caption.rows.size() > 0 && ((TableRow)this.caption.rows.get(0)).cells.size() > 0 && ((TableCell)((TableRow)this.caption.rows.get(0)).cells.get(0)).columnSpan != 0);
/*      */   }
/*      */   
/*      */   public int getMinColumns() {
/*  170 */     int i = this.header.getMinColumns();
/*  171 */     int j = this.separator.getMinColumns();
/*  172 */     int k = this.body.getMinColumns();
/*  173 */     return Utils.min((i == 0) ? Integer.MAX_VALUE : i, new int[] { j, (k == 0) ? Integer.MAX_VALUE : k });
/*      */   }
/*      */   
/*      */   public int getMaxColumns() {
/*  177 */     int i = this.header.getMaxColumns();
/*  178 */     int j = this.separator.getMaxColumns();
/*  179 */     int k = this.body.getMaxColumns();
/*  180 */     return Utils.max(i, new int[] { j, k });
/*      */   }
/*      */   
/*      */   public int getMinColumnsWithoutColumns(boolean paramBoolean, int... paramVarArgs) {
/*  184 */     return aggregateTotalColumnsWithoutColumns(paramBoolean ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, (BiFunction<Integer, Integer, Integer>)MinAggregator.INSTANCE, paramVarArgs);
/*      */   }
/*      */   
/*      */   public int getMaxColumnsWithoutColumns(boolean paramBoolean, int... paramVarArgs) {
/*  188 */     return aggregateTotalColumnsWithoutColumns(paramBoolean ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, (BiFunction<Integer, Integer, Integer>)MaxAggregator.INSTANCE, paramVarArgs);
/*      */   }
/*      */   
/*      */   public int getMinColumnsWithoutRows(boolean paramBoolean, int... paramVarArgs) {
/*  192 */     return aggregateTotalColumnsWithoutRows(paramBoolean ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, (BiFunction<Integer, Integer, Integer>)MinAggregator.INSTANCE, paramVarArgs);
/*      */   }
/*      */   
/*      */   public int getMaxColumnsWithoutRows(boolean paramBoolean, int... paramVarArgs) {
/*  196 */     return aggregateTotalColumnsWithoutRows(paramBoolean ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, (BiFunction<Integer, Integer, Integer>)MaxAggregator.INSTANCE, paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public List<TrackedOffset> getTrackedOffsets() {
/*  201 */     return this.trackedOffsets;
/*      */   }
/*      */ 
/*      */   
/*      */   private TrackedOffset findTrackedOffset(int paramInt) {
/*  206 */     for (Iterator<TrackedOffset> iterator = this.trackedOffsets.iterator(); iterator.hasNext(); ) {
/*  207 */       TrackedOffset trackedOffset; if ((trackedOffset = iterator.next()).getOffset() == paramInt) return trackedOffset; 
/*  208 */       if (trackedOffset.getOffset() <= paramInt);
/*      */     } 
/*  210 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public TrackedOffset getTrackedOffset(int paramInt) {
/*  215 */     return findTrackedOffset(paramInt);
/*      */   }
/*      */   
/*      */   public int getTrackedOffsetIndex(int paramInt) {
/*      */     TrackedOffset trackedOffset;
/*  220 */     return ((trackedOffset = findTrackedOffset(paramInt)) == null) ? paramInt : trackedOffset.getIndex();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTableStartOffset() {
/*      */     List<TableRow> list;
/*  226 */     if (!(list = getAllRows()).isEmpty()) {
/*      */       TableRow tableRow;
/*  228 */       (tableRow = list.get(0)).normalizeIfNeeded();
/*      */       
/*  230 */       if (tableRow.cells.size() > 0) {
/*  231 */         return ((TableCell)tableRow.cells.get(0)).getStartOffset(null);
/*      */       }
/*      */     } 
/*  234 */     return 0;
/*      */   }
/*      */   
/*      */   public TableCellOffsetInfo getCellOffsetInfo(int paramInt) {
/*  238 */     byte b = 0;
/*  239 */     for (Iterator<TableRow> iterator = getAllSectionRows().iterator(); iterator.hasNext(); ) {
/*  240 */       TableRow tableRow; (tableRow = iterator.next()).normalizeIfNeeded();
/*      */       TableCell tableCell;
/*      */       BasedSequence basedSequence;
/*      */       int i;
/*  244 */       if ((i = (basedSequence = (tableCell = tableRow.cells.get(tableRow.cells.size() - 1)).getLastSegment()).baseEndOfLineAnyEOL()) == -1) i = basedSequence.getEndOffset();
/*      */       
/*  246 */       if (paramInt <= i) {
/*      */ 
/*      */         
/*  249 */         byte b1 = 0;
/*  250 */         basedSequence = null;
/*  251 */         for (Iterator<TableCell> iterator1 = tableRow.cells.iterator(); iterator1.hasNext(); ) {
/*  252 */           TableCell tableCell2; if (!(tableCell2 = iterator1.next()).closeMarker.isEmpty() ? (paramInt < tableCell2.closeMarker.getEndOffset()) : (paramInt <= tableCell2.text.getEndOffset())) {
/*  253 */             if (paramInt >= tableCell2.getInsideStartOffset((TableCell)basedSequence) && paramInt <= tableCell2.getInsideEndOffset())
/*      */             {
/*  255 */               return new TableCellOffsetInfo(paramInt, this, getAllRowsSection(b), tableRow, tableCell2, b, b1, Integer.valueOf(b1), Integer.valueOf(paramInt - tableCell2.getInsideStartOffset((TableCell)basedSequence)));
/*      */             }
/*      */             
/*  258 */             return new TableCellOffsetInfo(paramInt, this, getAllRowsSection(b), tableRow, tableCell2, b, b1, null, null);
/*      */           } 
/*      */           
/*  261 */           b1++;
/*  262 */           TableCell tableCell1 = tableCell2;
/*      */         } 
/*      */         
/*  265 */         return new TableCellOffsetInfo(paramInt, this, getAllRowsSection(b), tableRow, tableCell, b, b1, null, null);
/*      */       } 
/*  267 */       b++;
/*      */     } 
/*      */     
/*  270 */     TableSection tableSection = getAllRowsSection(b - 1);
/*  271 */     return new TableCellOffsetInfo(paramInt, this, tableSection, null, null, b, 0, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean addTrackedOffset(int paramInt) {
/*  280 */     return addTrackedOffset(TrackedOffset.track(paramInt, null, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean addTrackedOffset(int paramInt, boolean paramBoolean) {
/*  289 */     return addTrackedOffset(TrackedOffset.track(paramInt, paramBoolean ? Character.valueOf(' ') : null, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean addTrackedOffset(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  298 */     return addTrackedOffset(TrackedOffset.track(paramInt, paramBoolean1 ? Character.valueOf(' ') : null, paramBoolean2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean addTrackedOffset(int paramInt, Character paramCharacter, boolean paramBoolean) {
/*  307 */     return addTrackedOffset(TrackedOffset.track(paramInt, paramCharacter, paramBoolean));
/*      */   }
/*      */   
/*      */   public boolean addTrackedOffset(TrackedOffset paramTrackedOffset) {
/*  311 */     int i = paramTrackedOffset.getOffset();
/*  312 */     this.trackedOffsets.removeIf(paramTrackedOffset -> (paramTrackedOffset.getOffset() == paramInt));
/*  313 */     this.trackedOffsets.add(paramTrackedOffset);
/*      */     
/*      */     TableCellOffsetInfo tableCellOffsetInfo;
/*  316 */     if ((tableCellOffsetInfo = getCellOffsetInfo(i)).getInsideColumn()) {
/*      */       
/*  318 */       tableCellOffsetInfo.tableRow.cells.set(tableCellOffsetInfo.column, tableCellOffsetInfo.tableCell
/*  319 */           .withTrackedOffset(i - tableCellOffsetInfo.tableCell
/*  320 */             .getTextStartOffset((tableCellOffsetInfo.column == 0) ? null : tableCellOffsetInfo.tableRow.cells.get(tableCellOffsetInfo.column - 1)), paramTrackedOffset
/*  321 */             .isAfterSpaceEdit(), paramTrackedOffset.isAfterDelete()));
/*      */ 
/*      */       
/*  324 */       return true;
/*  325 */     }  if (tableCellOffsetInfo.isBeforeCells()) {
/*      */ 
/*      */       
/*  328 */       tableCellOffsetInfo.tableRow.setBeforeOffset(i);
/*  329 */       return true;
/*  330 */     }  if (tableCellOffsetInfo.isInCellSpan()) {
/*      */       
/*  332 */       tableCellOffsetInfo.tableRow.cells.set(tableCellOffsetInfo.column, tableCellOffsetInfo.tableCell.withSpanTrackedOffset(i - tableCellOffsetInfo.tableCell.getInsideEndOffset()));
/*  333 */       return true;
/*  334 */     }  if (tableCellOffsetInfo.isAfterCells()) {
/*      */       
/*  336 */       tableCellOffsetInfo.tableRow.setAfterOffset(i);
/*  337 */       return true;
/*      */     } 
/*      */     
/*  340 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<TableRow> getAllRows() {
/*  347 */     return getAllSectionsRows(this.ALL_TABLE_ROWS);
/*      */   }
/*      */   
/*      */   public List<TableRow> getAllContentRows() {
/*  351 */     return getAllSectionsRows(this.ALL_CONTENT_ROWS);
/*      */   }
/*      */   
/*      */   public List<TableRow> getAllSectionRows() {
/*  355 */     return getAllSectionsRows(this.ALL_SECTIONS);
/*      */   }
/*      */   
/*      */   private List<TableRow> getAllSectionsRows(TableSection... paramVarArgs) {
/*  359 */     ArrayList<TableRow> arrayList = new ArrayList(this.header.rows.size() + this.body.rows.size()); int i; byte b;
/*  360 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { TableSection tableSection = paramVarArgs[b];
/*  361 */       arrayList.addAll(tableSection.rows); b++; }
/*      */     
/*  363 */     return arrayList;
/*      */   }
/*      */   
/*      */   public boolean isAllRowsSeparator(int paramInt) {
/*  367 */     return (paramInt >= this.header.rows.size() && paramInt < this.header.rows.size() + this.separator.rows.size()); } public TableSection getAllRowsSection(int paramInt) {
/*      */     TableSection[] arrayOfTableSection;
/*      */     int i;
/*      */     byte b;
/*  371 */     for (i = (arrayOfTableSection = this.ALL_SECTIONS).length, b = 0; b < i; ) { TableSection tableSection = arrayOfTableSection[b];
/*  372 */       if (paramInt < tableSection.rows.size()) return tableSection; 
/*  373 */       paramInt -= tableSection.rows.size(); b++; }
/*      */     
/*  375 */     return null;
/*      */   }
/*      */   
/*      */   public int getAllRowsCount() {
/*  379 */     return this.header.rows.size() + this.separator.rows.size() + this.body.rows.size();
/*      */   }
/*      */   
/*      */   public int getAllContentRowsCount() {
/*  383 */     return this.header.rows.size() + this.body.rows.size();
/*      */   }
/*      */   
/*      */   public int getAllSectionsRowsCount() {
/*  387 */     return this.header.rows.size() + this.separator.rows.size() + this.body.rows.size() + this.caption.rows.size();
/*      */   }
/*      */   
/*      */   public void forAllRows(TableRowManipulator paramTableRowManipulator) {
/*  391 */     forAllSectionsRows(0, 2147483647, this.ALL_TABLE_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllRows(int paramInt, TableRowManipulator paramTableRowManipulator) {
/*  395 */     forAllSectionsRows(paramInt, 2147483647, this.ALL_TABLE_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllRows(int paramInt1, int paramInt2, TableRowManipulator paramTableRowManipulator) {
/*  399 */     forAllSectionsRows(paramInt1, paramInt2, this.ALL_TABLE_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllContentRows(TableRowManipulator paramTableRowManipulator) {
/*  403 */     forAllSectionsRows(0, 2147483647, this.ALL_CONTENT_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllContentRows(int paramInt, TableRowManipulator paramTableRowManipulator) {
/*  407 */     forAllSectionsRows(paramInt, 2147483647, this.ALL_CONTENT_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllContentRows(int paramInt1, int paramInt2, TableRowManipulator paramTableRowManipulator) {
/*  411 */     forAllSectionsRows(paramInt1, paramInt2, this.ALL_CONTENT_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllSectionRows(TableRowManipulator paramTableRowManipulator) {
/*  415 */     forAllSectionsRows(0, 2147483647, this.ALL_SECTIONS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllSectionRows(int paramInt, TableRowManipulator paramTableRowManipulator) {
/*  419 */     forAllSectionsRows(paramInt, 2147483647, this.ALL_SECTIONS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllSectionRows(int paramInt1, int paramInt2, TableRowManipulator paramTableRowManipulator) {
/*  423 */     forAllSectionsRows(paramInt1, paramInt2, this.ALL_SECTIONS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllHeaderRows(TableRowManipulator paramTableRowManipulator) {
/*  427 */     forAllSectionsRows(0, 2147483647, this.ALL_HEADER_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllHeaderRows(int paramInt, TableRowManipulator paramTableRowManipulator) {
/*  431 */     forAllSectionsRows(paramInt, 2147483647, this.ALL_HEADER_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllHeaderRows(int paramInt1, int paramInt2, TableRowManipulator paramTableRowManipulator) {
/*  435 */     forAllSectionsRows(paramInt1, paramInt2, this.ALL_HEADER_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllBodyRows(TableRowManipulator paramTableRowManipulator) {
/*  439 */     forAllSectionsRows(0, 2147483647, this.ALL_BODY_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllBodyRows(int paramInt, TableRowManipulator paramTableRowManipulator) {
/*  443 */     forAllSectionsRows(paramInt, 2147483647, this.ALL_HEADER_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void forAllBodyRows(int paramInt1, int paramInt2, TableRowManipulator paramTableRowManipulator) {
/*  447 */     forAllSectionsRows(paramInt1, paramInt2, this.ALL_HEADER_ROWS, paramTableRowManipulator);
/*      */   }
/*      */   
/*      */   public void deleteRows(int paramInt1, int paramInt2) {
/*  451 */     if (paramInt1 <= this.header.rows.size()) {
/*  452 */       int i = paramInt2;
/*  453 */       while (i-- > 0 && paramInt1 < this.header.rows.size())
/*  454 */         this.header.rows.remove(paramInt1);  return;
/*      */     } 
/*  456 */     if (paramInt1 >= this.header.rows.size() + this.separator.rows.size()) {
/*  457 */       int i = paramInt1 - this.header.rows.size() - this.separator.rows.size();
/*  458 */       paramInt1 = paramInt2;
/*  459 */       while (paramInt1-- > 0 && i < this.body.rows.size()) {
/*  460 */         this.body.rows.remove(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void insertRows(int paramInt1, int paramInt2) {
/*  466 */     int i = getMaxColumns();
/*  467 */     if (paramInt1 <= this.header.rows.size()) {
/*  468 */       insertRows(this.header.rows, paramInt1, paramInt2, i); return;
/*      */     } 
/*  470 */     insertRows(this.body.rows, Utils.rangeLimit(paramInt1 - this.header.rows.size() - this.separator.rows.size(), 0, this.body.rows.size()), paramInt2, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void insertRows(ArrayList<TableRow> paramArrayList, int paramInt1, int paramInt2, int paramInt3) {
/*  480 */     paramInt2 = paramInt2;
/*  481 */     while (paramInt2-- > 0) {
/*      */       TableRow tableRow;
/*  483 */       (tableRow = new TableRow()).appendColumns(paramInt3);
/*  484 */       if (paramInt1 >= paramArrayList.size()) {
/*  485 */         paramArrayList.add(tableRow); continue;
/*      */       } 
/*  487 */       paramArrayList.add(paramInt1, tableRow);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void insertColumns(int paramInt1, int paramInt2) {
/*  493 */     forAllContentRows((paramTableRow, paramInt3, paramArrayList, paramInt4) -> {
/*      */           ((TableRow)paramArrayList.get(paramInt4)).insertColumns(paramInt1, paramInt2);
/*      */           
/*      */           return 0;
/*      */         });
/*      */     
/*  499 */     for (Iterator<TableRow> iterator = this.separator.rows.iterator(); iterator.hasNext();) {
/*  500 */       (tableRow = iterator.next()).insertColumns(paramInt1, paramInt2);
/*      */     }
/*      */   }
/*      */   
/*      */   public void deleteColumns(int paramInt1, int paramInt2) {
/*  505 */     forAllContentRows((paramTableRow, paramInt3, paramArrayList, paramInt4) -> {
/*      */           ((TableRow)paramArrayList.get(paramInt4)).deleteColumns(paramInt1, paramInt2);
/*      */           
/*      */           return 0;
/*      */         });
/*      */     
/*  511 */     for (Iterator<TableRow> iterator = this.separator.rows.iterator(); iterator.hasNext();) {
/*  512 */       (tableRow = iterator.next()).deleteColumns(paramInt1, paramInt2);
/*      */     }
/*      */   }
/*      */   
/*      */   public void moveColumn(int paramInt1, int paramInt2) {
/*  517 */     forAllContentRows((paramTableRow, paramInt3, paramArrayList, paramInt4) -> {
/*      */           ((TableRow)paramArrayList.get(paramInt4)).moveColumn(paramInt1, paramInt2);
/*      */           
/*      */           return 0;
/*      */         });
/*      */     
/*  523 */     for (Iterator<TableRow> iterator = this.separator.rows.iterator(); iterator.hasNext();) {
/*  524 */       (tableRow = iterator.next()).moveColumn(paramInt1, paramInt2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmptyColumn(int paramInt) {
/*  536 */     boolean[] arrayOfBoolean = { true };
/*  537 */     forAllContentRows((paramTableRow, paramInt2, paramArrayList, paramInt3) -> {
/*      */           if (!paramTableRow.isEmptyColumn(paramInt1)) {
/*      */             paramArrayOfboolean[0] = false;
/*      */             
/*      */             return Integer.MIN_VALUE;
/*      */           } 
/*      */           return 0;
/*      */         });
/*  545 */     return arrayOfBoolean[0];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAllRowsEmptyAt(int paramInt) {
/*  555 */     return isEmptyRowAt(paramInt, this.ALL_TABLE_ROWS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isContentRowsEmptyAt(int paramInt) {
/*  565 */     return isEmptyRowAt(paramInt, this.ALL_CONTENT_ROWS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isEmptyRowAt(int paramInt, TableSection[] paramArrayOfTableSection) {
/*  576 */     boolean[] arrayOfBoolean = { false };
/*  577 */     forAllSectionsRows(paramInt, 1, paramArrayOfTableSection, (paramTableRow, paramInt1, paramArrayList, paramInt2) -> {
/*      */           if (paramTableRow.isEmpty()) {
/*      */             paramArrayOfboolean[0] = true;
/*      */           }
/*      */           
/*      */           return Integer.MIN_VALUE;
/*      */         });
/*  584 */     return arrayOfBoolean[0];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHeader() {
/*  594 */     return this.isHeading;
/*      */   }
/*      */   
/*      */   public void setHeader(boolean paramBoolean) {
/*  598 */     this.isHeading = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isSeparator() {
/*  602 */     return this.isSeparator;
/*      */   }
/*      */   
/*      */   public void setSeparator(boolean paramBoolean) {
/*  606 */     this.isSeparator = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setHeader() {
/*  610 */     this.isHeading = true;
/*  611 */     this.isSeparator = false;
/*      */   }
/*      */   
/*      */   public void setSeparator() {
/*  615 */     this.isSeparator = true;
/*  616 */     this.isHeading = false;
/*      */   }
/*      */   
/*      */   public void setBody() {
/*  620 */     this.isSeparator = false;
/*  621 */     this.isHeading = false;
/*      */   }
/*      */   
/*      */   public void nextRow() {
/*  625 */     if (this.isSeparator) throw new IllegalStateException("Only one separator row allowed"); 
/*  626 */     if (this.isHeading) {
/*  627 */       this.header.nextRow(); return;
/*      */     } 
/*  629 */     this.body.nextRow();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCell(TableCell paramTableCell) {
/*  637 */     TableSection tableSection = this.isSeparator ? this.separator : (this.isHeading ? this.header : this.body);
/*      */     
/*  639 */     if (this.isSeparator && (paramTableCell.columnSpan != 1 || paramTableCell.rowSpan != 1)) throw new IllegalStateException("Separator columns cannot span rows/columns");
/*      */     
/*  641 */     TableRow tableRow = tableSection.get(tableSection.row);
/*      */ 
/*      */     
/*  644 */     for (; tableSection.column < tableRow.cells.size() && tableRow.cells.get(tableSection.column) != null; tableSection.column++);
/*      */     
/*  646 */     byte b = 0;
/*  647 */     while (b < paramTableCell.rowSpan) {
/*  648 */       tableSection.get(tableSection.row + b).set(tableSection.column, paramTableCell);
/*      */ 
/*      */       
/*  651 */       byte b1 = 1;
/*  652 */       while (b1 < paramTableCell.columnSpan) {
/*  653 */         tableSection.expandTo(tableSection.row + b, tableSection.column + b1);
/*  654 */         if ((tableSection.get(tableSection.row + b)).cells.get(tableSection.column + b1) == null) {
/*      */           
/*  656 */           ((TableRow)tableSection.rows.get(tableSection.row + b)).set(tableSection.column + b1, TableCell.NULL);
/*  657 */           b1++;
/*      */         } 
/*  659 */       }  b++;
/*      */     } 
/*      */     
/*  662 */     tableSection.column += paramTableCell.columnSpan;
/*      */   }
/*      */   
/*      */   public void normalize() {
/*  666 */     this.header.normalize();
/*  667 */     this.separator.normalize();
/*  668 */     this.body.normalize();
/*      */   }
/*      */ 
/*      */   
/*      */   public void finalizeTable() {
/*  673 */     normalize();
/*      */     
/*  675 */     if (this.options.fillMissingColumns) {
/*  676 */       fillMissingColumns(this.options.formatTableFillMissingMinColumn);
/*      */     }
/*      */     
/*  679 */     int i = getMaxColumns();
/*  680 */     this.alignments = new CellAlignment[i];
/*  681 */     this.columnWidths = new int[i];
/*  682 */     BitSet bitSet = new BitSet(i);
/*  683 */     ArrayList<ColumnSpan> arrayList = new ArrayList();
/*  684 */     Ref<Integer> ref = new Ref(Integer.valueOf(0));
/*      */     
/*  686 */     if (this.separator.rows.size() > 0) {
/*  687 */       TableRow tableRow = this.separator.rows.get(0);
/*      */       
/*  689 */       int j = 0;
/*  690 */       ref.value = Integer.valueOf(0);
/*  691 */       for (TableCell tableCell : tableRow.cells) {
/*      */         
/*  693 */         if ((this.alignments[j] == null || (tableCell.columnSpan == 1 && bitSet.get(j))) && tableCell.alignment != CellAlignment.NONE) {
/*  694 */           this.alignments[j] = tableCell.alignment;
/*  695 */           if (tableCell.columnSpan > 1) bitSet.set(j);
/*      */         
/*      */         } 
/*  698 */         j += tableCell.columnSpan;
/*      */       } 
/*      */     } 
/*      */     
/*  702 */     if (this.header.rows.size() > 0)
/*      */     {
/*  704 */       for (TableRow tableRow : this.header.rows) {
/*  705 */         byte b1 = 0;
/*  706 */         int j = 0;
/*  707 */         int k = tableRow.cells.size();
/*  708 */         for (byte b2 = 0; b2 < k; b2++) {
/*  709 */           TableCell tableCell = tableRow.cells.get(b2);
/*      */ 
/*      */           
/*  712 */           if ((this.alignments[j] == null || (tableCell.columnSpan == 1 && bitSet.get(j))) && tableCell.alignment != CellAlignment.NONE) {
/*  713 */             this.alignments[j] = tableCell.alignment;
/*  714 */             if (tableCell.columnSpan > 1) bitSet.set(j);
/*      */           
/*      */           } 
/*  717 */           ref.value = Integer.valueOf(0);
/*  718 */           BasedSequence basedSequence = cellText(tableRow.cells, b2, false, true, 0, null, ref);
/*  719 */           int m = this.options.charWidthProvider.getStringWidth((CharSequence)basedSequence) + this.options.spacePad + this.options.pipeWidth * tableCell.columnSpan;
/*  720 */           if (tableCell.columnSpan > 1)
/*  721 */           { arrayList.add(new ColumnSpan(b1, tableCell.columnSpan, m)); }
/*      */           
/*  723 */           else if (this.columnWidths[j] < m) { this.columnWidths[j] = m; }
/*      */ 
/*      */           
/*  726 */           b1++;
/*  727 */           j += tableCell.columnSpan;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  733 */     if (this.body.rows.size() > 0)
/*      */     {
/*  735 */       for (TableRow tableRow : this.body.rows) {
/*      */         
/*  737 */         int j = 0;
/*  738 */         int k = tableRow.cells.size();
/*  739 */         for (byte b = 0; b < k; b++) {
/*  740 */           TableCell tableCell = tableRow.cells.get(b);
/*  741 */           ref.value = Integer.valueOf(0);
/*  742 */           BasedSequence basedSequence = cellText(tableRow.cells, b, false, false, 0, null, ref);
/*  743 */           int m = this.options.charWidthProvider.getStringWidth((CharSequence)basedSequence) + this.options.spacePad + this.options.pipeWidth * tableCell.columnSpan;
/*  744 */           if (tableCell.columnSpan > 1)
/*  745 */           { arrayList.add(new ColumnSpan(j, tableCell.columnSpan, m)); }
/*      */           
/*  747 */           else if (this.columnWidths[j] < m) { this.columnWidths[j] = m; }
/*      */ 
/*      */ 
/*      */           
/*  751 */           j += tableCell.columnSpan;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  758 */     if (this.separator.rows.size() == 0 || this.body.rows.size() > 0 || this.header.rows.size() > 0) {
/*  759 */       byte b1 = 0;
/*  760 */       ref.value = Integer.valueOf(0); CellAlignment[] arrayOfCellAlignment; int j; byte b2;
/*  761 */       for (j = (arrayOfCellAlignment = this.alignments).length, b2 = 0; b2 < j; ) { CellAlignment cellAlignment1 = arrayOfCellAlignment[b2];
/*      */         CellAlignment cellAlignment2;
/*  763 */         byte b = ((cellAlignment2 = adjustCellAlignment(cellAlignment1)) == CellAlignment.LEFT || cellAlignment2 == CellAlignment.RIGHT) ? 1 : ((cellAlignment2 == CellAlignment.CENTER) ? 2 : 0);
/*  764 */         int k = 0;
/*  765 */         int m = Utils.minLimit(0, new int[] { this.options.minSeparatorColumnWidth - b, this.options.minSeparatorDashes });
/*  766 */         if (m > 0) k = m; 
/*  767 */         int n = k * this.options.dashWidth + b * this.options.colonWidth + this.options.pipeWidth;
/*  768 */         if (this.columnWidths[b1] < n) this.columnWidths[b1] = n; 
/*  769 */         b1++;
/*      */         b2++; }
/*      */     
/*      */     } else {
/*  773 */       byte b = 0;
/*  774 */       ref.value = Integer.valueOf(0);
/*  775 */       for (TableCell tableCell : ((TableRow)this.separator.rows.get(0)).cells) {
/*      */         CellAlignment cellAlignment;
/*  777 */         byte b1 = ((cellAlignment = adjustCellAlignment(tableCell.alignment)) == CellAlignment.LEFT || cellAlignment == CellAlignment.RIGHT) ? 1 : ((cellAlignment == CellAlignment.CENTER) ? 2 : 0);
/*      */         
/*      */         BasedSequence basedSequence;
/*  780 */         int j, k = Utils.minLimit(j = (basedSequence = (BasedSequence)tableCell.text.trim(COLON_TRIM_CHARS)).length(), new int[] { this.options.minSeparatorColumnWidth - b1, this.options.minSeparatorDashes });
/*  781 */         if (j < k) j = k; 
/*  782 */         int m = j * this.options.dashWidth + b1 * this.options.colonWidth + this.options.pipeWidth;
/*  783 */         if (this.columnWidths[b] < m) this.columnWidths[b] = m; 
/*  784 */         b++;
/*      */       } 
/*      */     } 
/*      */     
/*  788 */     if (!arrayList.isEmpty()) {
/*      */       
/*  790 */       BitSet bitSet1 = new BitSet(i);
/*  791 */       ArrayList<ColumnSpan> arrayList1 = new ArrayList(arrayList.size());
/*      */       
/*  793 */       for (ColumnSpan columnSpan : arrayList) {
/*      */         int j;
/*  795 */         if ((j = spanWidth(columnSpan.startColumn, columnSpan.columnSpan)) < columnSpan.width) {
/*      */           
/*  797 */           bitSet1.set(columnSpan.startColumn, columnSpan.startColumn + columnSpan.columnSpan);
/*  798 */           arrayList1.add(columnSpan);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  803 */       while (!arrayList1.isEmpty()) {
/*  804 */         arrayList = arrayList1;
/*      */         
/*  806 */         BitSet bitSet2 = new BitSet(i);
/*  807 */         arrayList1.clear();
/*      */ 
/*      */         
/*  810 */         for (ColumnSpan columnSpan : arrayList) {
/*  811 */           int j = spanWidth(columnSpan.startColumn, columnSpan.columnSpan);
/*  812 */           int k = spanFixedWidth(bitSet1, columnSpan.startColumn, columnSpan.columnSpan);
/*      */           
/*  814 */           if (j <= k) {
/*  815 */             bitSet2.set(columnSpan.startColumn, columnSpan.startColumn + columnSpan.columnSpan); continue;
/*      */           } 
/*  817 */           arrayList1.add(columnSpan);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  822 */         bitSet1.andNot(bitSet2);
/*  823 */         arrayList = arrayList1;
/*  824 */         arrayList1.clear();
/*      */         
/*  826 */         for (ColumnSpan columnSpan : arrayList) {
/*  827 */           int j = spanWidth(columnSpan.startColumn, columnSpan.columnSpan);
/*  828 */           int k = spanFixedWidth(bitSet1, columnSpan.startColumn, columnSpan.columnSpan);
/*      */           
/*  830 */           if (j > k) {
/*      */             
/*  832 */             int n = j - k;
/*  833 */             int i1 = bitSet1.get(columnSpan.startColumn, columnSpan.startColumn + columnSpan.columnSpan).cardinality();
/*  834 */             int i2 = n / i1;
/*  835 */             int m = n - i2 * i1;
/*      */             
/*  837 */             for (byte b = 0; b < columnSpan.columnSpan; b++) {
/*  838 */               if (bitSet1.get(columnSpan.startColumn + b)) {
/*  839 */                 this.columnWidths[columnSpan.startColumn + b] = this.columnWidths[columnSpan.startColumn + b] + i2;
/*  840 */                 if (m > 0) {
/*  841 */                   this.columnWidths[columnSpan.startColumn + b] = this.columnWidths[columnSpan.startColumn + b] + 1;
/*  842 */                   m--;
/*      */                 } 
/*      */               } 
/*      */             } 
/*  846 */             arrayList1.add(columnSpan);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void fillMissingColumns() {
/*  854 */     fillMissingColumns(null);
/*      */   }
/*      */   
/*      */   public void fillMissingColumns(Integer paramInteger) {
/*  858 */     int i = getMinColumns();
/*  859 */     int j = getMaxColumns();
/*  860 */     if (i < j) {
/*      */       Iterator<TableRow> iterator;
/*  862 */       for (iterator = this.header.rows.iterator(); iterator.hasNext();) {
/*  863 */         (tableRow = iterator.next()).fillMissingColumns(paramInteger, j);
/*      */       }
/*      */       
/*  866 */       for (iterator = this.body.rows.iterator(); iterator.hasNext();) {
/*  867 */         (tableRow = iterator.next()).fillMissingColumns(paramInteger, j);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean setTrackedOffsetIndex(int paramInt1, int paramInt2) {
/*      */     TrackedOffset trackedOffset;
/*  874 */     if ((trackedOffset = findTrackedOffset(paramInt1)) != null) {
/*  875 */       trackedOffset.setIndex(paramInt2);
/*  876 */       return true;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  882 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MarkdownTable transposed(int paramInt) {
/*      */     MarkdownTable markdownTable;
/*  893 */     (markdownTable = new MarkdownTable(this.tableChars, this.options)).trackedOffsets.addAll(this.trackedOffsets);
/*      */     
/*  895 */     int i = getAllRowsCount() - 1;
/*  896 */     int j = getMaxColumns();
/*  897 */     TableCell[][] arrayOfTableCell = new TableCell[i][]; int k;
/*  898 */     for (k = 0; k < i; k++) {
/*  899 */       arrayOfTableCell[k] = new TableCell[j];
/*      */     }
/*      */ 
/*      */     
/*  903 */     forAllSectionsRows(0, 2147483647, this.ALL_CONTENT_ROWS, (paramTableRow, paramInt1, paramArrayList, paramInt2) -> {
/*      */           TableCell[] arrayOfTableCell = paramArrayOfTableCell[paramInt1];
/*      */           
/*      */           paramInt1 = paramTableRow.cells.size();
/*      */           byte b = 0;
/*      */           for (paramInt2 = 0; paramInt2 < paramInt1; paramInt2++) {
/*      */             TableCell tableCell = paramTableRow.cells.get(paramInt2);
/*      */             for (byte b1 = 0; b1 < tableCell.columnSpan; b1++) {
/*      */               arrayOfTableCell[b++] = new TableCell(tableCell, (b1 == 0), 1, 1, null);
/*      */             }
/*      */           } 
/*      */           return 0;
/*      */         });
/*  916 */     markdownTable.setHeader();
/*  917 */     k = Math.min(Math.max(0, paramInt), j);
/*  918 */     for (paramInt = 0; paramInt < k; paramInt++) {
/*  919 */       for (byte b = 0; b < i; b++) {
/*  920 */         TableCell tableCell = arrayOfTableCell[b][paramInt];
/*  921 */         markdownTable.addCell((tableCell == null) ? TableCell.DEFAULT_CELL : tableCell);
/*      */       } 
/*  923 */       markdownTable.nextRow();
/*      */     } 
/*      */     
/*  926 */     TableRow tableRow = this.separator.rows.get(0);
/*  927 */     markdownTable.setSeparator();
/*  928 */     int m = tableRow.cells.size(); int n;
/*  929 */     for (n = 0; n < i; n++) {
/*  930 */       if (n < m) {
/*  931 */         markdownTable.addCell(new TableCell(tableRow.cells.get(n), true, 1, 1, null));
/*      */       } else {
/*  933 */         markdownTable.addCell(new TableCell("---", 1, 1));
/*      */       } 
/*      */     } 
/*      */     
/*  937 */     markdownTable.setBody();
/*  938 */     for (n = k; n < j; n++) {
/*  939 */       for (byte b = 0; b < i; b++) {
/*  940 */         TableCell tableCell = arrayOfTableCell[b][n];
/*  941 */         markdownTable.addCell((tableCell == null) ? TableCell.DEFAULT_CELL : tableCell);
/*      */       } 
/*  943 */       markdownTable.nextRow();
/*      */     } 
/*      */     
/*  946 */     markdownTable.setCaptionCell(getCaptionCell());
/*      */     
/*  948 */     return markdownTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MarkdownTable sorted(ColumnSort[] paramArrayOfColumnSort, int paramInt, NumericSuffixPredicate paramNumericSuffixPredicate) {
/*      */     MarkdownTable markdownTable;
/*  961 */     (markdownTable = new MarkdownTable(this.tableChars, this.options)).trackedOffsets.addAll(this.trackedOffsets);
/*      */     
/*  963 */     markdownTable.setHeader();
/*  964 */     forAllSectionsRows(0, 2147483647, this.ALL_HEADER_ROWS, (paramTableRow, paramInt1, paramArrayList, paramInt2) -> {
/*      */           paramInt1 = paramTableRow.cells.size();
/*      */           
/*      */           for (byte b = 0; b < paramInt1; b++) {
/*      */             TableCell tableCell = paramTableRow.cells.get(b);
/*      */             paramMarkdownTable.addCell((tableCell == TableCell.DEFAULT_CELL) ? tableCell : new TableCell(tableCell, true, tableCell.rowSpan, tableCell.columnSpan, tableCell.alignment));
/*      */           } 
/*      */           paramMarkdownTable.nextRow();
/*      */           return 0;
/*      */         });
/*  974 */     markdownTable.setSeparator();
/*      */     TableRow tableRow;
/*      */     int j;
/*  977 */     CellAlignment[] arrayOfCellAlignment = new CellAlignment[j = (tableRow = this.separator.rows.get(0)).cells.size()];
/*      */     
/*  979 */     for (byte b1 = 0; b1 < j; b1++) {
/*  980 */       TableCell tableCell = tableRow.cells.get(b1);
/*  981 */       markdownTable.addCell((tableCell == TableCell.DEFAULT_CELL) ? tableCell : new TableCell(tableCell, true, tableCell.rowSpan, tableCell.columnSpan, tableCell.alignment));
/*  982 */       arrayOfCellAlignment[b1] = tableCell.alignment;
/*      */     } 
/*      */     
/*  985 */     List<TableRow> list = getAllSectionsRows(new TableSection[] { this.body });
/*  986 */     int[] arrayOfInt = new int[j];
/*      */     
/*  988 */     int i = list.size();
/*  989 */     j = getMaxBodyColumns();
/*      */     
/*  991 */     for (byte b2 = 0; b2 < i; b2++) {
/*  992 */       ColumnSort[] arrayOfColumnSort; int k; byte b; for (k = (arrayOfColumnSort = paramArrayOfColumnSort).length, b = 0; b < k; ) {
/*      */         ColumnSort columnSort; int m;
/*  994 */         if ((m = (columnSort = arrayOfColumnSort[b]).column) >= 0 && m < j) {
/*      */           
/*  996 */           IndexSpanOffset indexSpanOffset = ((TableRow)list.get(b2)).indexOf(m);
/*      */           
/*  998 */           TableCell tableCell = ((TableRow)list.get(b2)).cells.get(indexSpanOffset.index);
/*  999 */           if (indexSpanOffset.index == m && tableCell != null)
/*      */           {
/* 1001 */             arrayOfInt[m] = Math.max(arrayOfInt[m], tableCell.text.length());
/*      */           }
/*      */         } 
/*      */         b++;
/*      */       } 
/*      */     } 
/* 1007 */     TextCollectingVisitor textCollectingVisitor = new TextCollectingVisitor();
/*      */     
/* 1009 */     NumericSuffixPredicate numericSuffixPredicate = (paramNumericSuffixPredicate == null) ? ALL_SUFFIXES_SORT : paramNumericSuffixPredicate;
/* 1010 */     Comparator<? super TableRow> comparator = (paramTableRow1, paramTableRow2) -> {
/*      */         int i = (paramArrayOfColumnSort = paramArrayOfColumnSort).length;
/*      */         for (byte b = 0; b < i; b++) {
/*      */           ColumnSort columnSort;
/*      */           int j;
/*      */           int k;
/*      */           if ((j = (columnSort = paramArrayOfColumnSort[b]).column) >= 0 && j < paramInt1 && (k = paramArrayOfint[j]) > 0) {
/*      */             String str1;
/*      */             String str2;
/*      */             int m;
/*      */             String str3;
/*      */             Sort sort;
/*      */             boolean bool2 = (sort = columnSort.sort).isDescending();
/*      */             boolean bool3 = sort.isNumeric();
/*      */             boolean bool1 = sort.isNumericLast();
/*      */             IndexSpanOffset indexSpanOffset1 = paramTableRow1.indexOf(j);
/*      */             TableCell tableCell1 = paramTableRow1.cells.get(indexSpanOffset1.index);
/*      */             IndexSpanOffset indexSpanOffset2 = paramTableRow2.indexOf(j);
/*      */             TableCell tableCell2 = paramTableRow2.cells.get(indexSpanOffset2.index);
/*      */             if (indexSpanOffset1.index == j && tableCell1 != null && indexSpanOffset2.index == j && tableCell2 != null) {
/*      */               int n = 0;
/*      */               m = 0;
/*      */               int i1 = 0;
/*      */               int i2 = 0;
/*      */               str2 = (tableCell1.tableCellNode == null) ? tableCell1.text.toString() : paramTextCollectingVisitor.collectAndGetText(tableCell1.tableCellNode, paramInt2).trim();
/*      */               str3 = (tableCell2.tableCellNode == null) ? tableCell2.text.toString() : paramTextCollectingVisitor.collectAndGetText(tableCell2.tableCellNode, paramInt2).trim();
/*      */               int i3 = k - str2.length();
/*      */               int i4 = k - str3.length();
/*      */               switch (paramArrayOfCellAlignment[j]) {
/*      */                 case CENTER:
/*      */                   n = i3 >> 1;
/*      */                   i1 = k - n;
/*      */                   m = i4 >> 1;
/*      */                   i2 = k - m;
/*      */                   break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 case RIGHT:
/*      */                   n = i3;
/*      */                   m = i4;
/*      */                   break;
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (bool3) {
/*      */                 String str;
/*      */                 Pair pair1 = SequenceUtils.parseNumberPrefixOrNull(str2, paramNumericSuffixPredicate);
/*      */                 Pair pair2 = SequenceUtils.parseNumberPrefixOrNull(str3, paramNumericSuffixPredicate);
/*      */                 if (pair1 != null && pair2 != null) {
/*      */                   j = Utils.compare((Number)pair1.getFirst(), (Number)pair2.getFirst());
/*      */                   str = (String)pair1.getSecond();
/*      */                   str1 = (String)pair2.getSecond();
/*      */                   if (j == 0 && (paramNumericSuffixPredicate.sortSuffix(str) || paramNumericSuffixPredicate.sortSuffix(str1))) {
/*      */                     if (!str.isEmpty() && paramNumericSuffixPredicate.sortSuffix(str) && !str1.isEmpty() && paramNumericSuffixPredicate.sortSuffix(str1)) {
/*      */                       j = str.compareTo((String)pair2.getSecond());
/*      */                     } else if (!str.isEmpty() && paramNumericSuffixPredicate.sortSuffix(str)) {
/*      */                       j = bool1 ? -1 : 1;
/*      */                       bool2 = false;
/*      */                     } else if (!str1.isEmpty() && paramNumericSuffixPredicate.sortSuffix(str1)) {
/*      */                       j = bool1 ? 1 : -1;
/*      */                       bool2 = false;
/*      */                     } 
/*      */                   }
/*      */                 } else if (str != null) {
/*      */                   j = bool1 ? 1 : -1;
/*      */                   bool2 = false;
/*      */                 } else if (pair2 != null) {
/*      */                   j = bool1 ? -1 : 1;
/*      */                   bool2 = false;
/*      */                 } else {
/*      */                   str = RepeatedSequence.ofSpaces(str1).toString() + str2 + RepeatedSequence.ofSpaces(i1);
/*      */                   str1 = RepeatedSequence.ofSpaces(m).toString() + str3 + RepeatedSequence.ofSpaces(i2);
/*      */                   j = str.compareTo(str1);
/*      */                 } 
/*      */               } else {
/*      */                 String str4 = RepeatedSequence.ofSpaces(str1).toString() + str2 + RepeatedSequence.ofSpaces(i1);
/*      */                 String str5 = RepeatedSequence.ofSpaces(m).toString() + str3 + RepeatedSequence.ofSpaces(i2);
/*      */                 j = str4.compareTo(str5);
/*      */               } 
/*      */             } else if (((IndexSpanOffset)str1).index == j && str2 != null) {
/*      */               j = 1;
/*      */             } else if (m.index == j && str3 != null) {
/*      */               j = -1;
/*      */             } else {
/*      */               j = 0;
/*      */             } 
/*      */             if (j != 0) {
/*      */               return bool2 ? -j : j;
/*      */             }
/*      */           } 
/*      */         } 
/*      */         return 0;
/*      */       };
/* 1113 */     list.sort(comparator);
/*      */     
/* 1115 */     markdownTable.setBody();
/* 1116 */     i = list.size();
/* 1117 */     for (byte b3 = 0; b3 < i; b3++) {
/*      */       TableRow tableRow1;
/* 1119 */       j = (tableRow1 = list.get(b3)).cells.size();
/* 1120 */       for (byte b = 0; b < j; b++) {
/* 1121 */         TableCell tableCell = tableRow1.cells.get(b);
/* 1122 */         markdownTable.addCell((tableCell == TableCell.DEFAULT_CELL) ? tableCell : new TableCell(tableCell, true, tableCell.rowSpan, tableCell.columnSpan, tableCell.alignment));
/*      */       } 
/* 1124 */       markdownTable.nextRow();
/*      */     } 
/*      */     
/* 1127 */     markdownTable.setCaptionCell(getCaptionCell());
/* 1128 */     return markdownTable;
/*      */   }
/*      */   
/*      */   int appendDashes(LineAppendable paramLineAppendable, int paramInt1, BasedSequence paramBasedSequence, int paramInt2) {
/* 1132 */     int i = paramBasedSequence.length();
/*      */     
/*      */     int j;
/* 1135 */     if ((j = Math.max(0, i - paramInt2)) >= paramInt1) {
/* 1136 */       paramLineAppendable.append((CharSequence)paramBasedSequence.subSequence(paramInt2, paramInt2 + paramInt1));
/* 1137 */       j -= paramInt1;
/*      */     } else {
/* 1139 */       byte b = 0;
/* 1140 */       if (j > 1) {
/* 1141 */         paramLineAppendable.append((CharSequence)paramBasedSequence.subSequence(paramInt2, paramInt2 + 1));
/* 1142 */         j--;
/* 1143 */         b++;
/*      */       } 
/*      */       
/* 1146 */       paramLineAppendable.append('-', paramInt1 - Math.max(0, j + b));
/*      */       
/* 1148 */       if (j > 0) {
/* 1149 */         paramLineAppendable.append((CharSequence)paramBasedSequence.subSequence(paramInt2, paramInt2 + j));
/* 1150 */         j = 0;
/*      */       } 
/*      */     } 
/* 1153 */     return i - j;
/*      */   }
/*      */ 
/*      */   
/*      */   public void appendTable(LineAppendable paramLineAppendable) {
/* 1158 */     CharSequence charSequence = this.formatTableIndentPrefix;
/*      */     
/* 1160 */     this.trackedOffsets.sort(Comparator.comparing(TrackedOffset::getOffset));
/*      */     
/* 1162 */     paramLineAppendable.pushOptions();
/* 1163 */     paramLineAppendable.removeOptions(LineAppendable.F_WHITESPACE_REMOVAL);
/*      */     
/* 1165 */     finalizeTable();
/*      */     
/* 1167 */     appendRows(paramLineAppendable, this.header.rows, true, charSequence);
/*      */ 
/*      */     
/* 1170 */     paramLineAppendable.append(charSequence);
/*      */     
/*      */     TableRow tableRow;
/*      */     
/* 1174 */     if ((tableRow = (TableRow)((this.separator.rows.size() > 0) ? this.separator.rows.get(0) : null)) != null && tableRow.beforeOffset != Integer.MAX_VALUE) {
/* 1175 */       setTrackedOffsetIndex(tableRow.beforeOffset, paramLineAppendable.offsetWithPending());
/*      */     }
/*      */     
/* 1178 */     byte b1 = 0;
/* 1179 */     Ref ref = new Ref(Integer.valueOf(0)); CellAlignment[] arrayOfCellAlignment; int i; byte b2;
/* 1180 */     for (i = (arrayOfCellAlignment = this.alignments).length, b2 = 0; b2 < i; ) { CellAlignment cellAlignment1 = arrayOfCellAlignment[b2];
/*      */       
/*      */       CellAlignment cellAlignment2;
/* 1183 */       int j = ((cellAlignment2 = adjustCellAlignment(cellAlignment1)) == CellAlignment.LEFT || cellAlignment2 == CellAlignment.RIGHT) ? 1 : ((cellAlignment2 == CellAlignment.CENTER) ? 2 : 0);
/* 1184 */       int k = this.columnWidths[b1] - j * this.options.colonWidth - this.options.pipeWidth;
/*      */       int m;
/* 1186 */       j = Utils.minLimit(m = (((Integer)ref.value).intValue() + k) / this.options.dashWidth, new int[] { this.options.minSeparatorColumnWidth - j, this.options.minSeparatorDashes });
/* 1187 */       if (m < j) m = j;
/*      */       
/* 1189 */       if (Math.abs(((Integer)ref.value).intValue() + k - (m + 1) * this.options.dashWidth) < Math.abs(((Integer)ref.value).intValue() + k - m * this.options.dashWidth)) {
/* 1190 */         m++;
/*      */       }
/*      */       Ref ref1;
/* 1193 */       (ref1 = ref).value = Integer.valueOf(((Integer)ref1.value).intValue() + k - m * this.options.dashWidth);
/*      */ 
/*      */       
/* 1196 */       TableCell tableCell1 = null;
/* 1197 */       TableCell tableCell2 = null;
/*      */       
/* 1199 */       if (tableRow != null) {
/* 1200 */         List<TableCell> list = tableRow.cells;
/* 1201 */         if (b1 < list.size()) {
/* 1202 */           tableCell1 = list.get(b1);
/* 1203 */           if (b1 > 0) tableCell2 = list.get(b1 - 1);
/*      */         
/*      */         } 
/*      */       } 
/* 1207 */       int n = (tableCell1 == null) ? Integer.MAX_VALUE : Utils.minLimit(tableCell1.trackedTextOffset, new int[] { 0 });
/* 1208 */       BasedSequence basedSequence = (tableCell1 == null) ? BasedSequence.NULL : (BasedSequence)tableCell1.text.trim(COLON_TRIM_CHARS);
/*      */ 
/*      */       
/* 1211 */       if (n != Integer.MAX_VALUE) {
/* 1212 */         if (this.options.leadTrailPipes && b1 == 0) paramLineAppendable.append('|'); 
/* 1213 */         int i1 = (n == 0 && tableCell1.text.charAt(n) == ':') ? 1 : 0;
/* 1214 */         boolean bool1 = (n == 1 && tableCell1.text.charAt(n - 1) == ':') ? true : false;
/* 1215 */         boolean bool2 = (n == tableCell1.text.length() - 1 && tableCell1.text.charAt(n) == ':') ? true : false;
/* 1216 */         boolean bool3 = (n == tableCell1.text.length() && tableCell1.text.charAt(n - 1) == ':') ? true : false;
/* 1217 */         boolean bool4 = (n == tableCell1.text.length() && tableCell1.text.charAt(n - 1) == '-') ? true : false;
/*      */         
/* 1219 */         if (cellAlignment2 == CellAlignment.LEFT || cellAlignment2 == CellAlignment.CENTER) {
/* 1220 */           if (i1) {
/* 1221 */             setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1222 */             n = Integer.MAX_VALUE;
/* 1223 */             paramLineAppendable.append(':');
/* 1224 */           } else if (bool1) {
/* 1225 */             paramLineAppendable.append(':');
/* 1226 */             setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1227 */             n = Integer.MAX_VALUE;
/*      */           } else {
/* 1229 */             paramLineAppendable.append(':');
/*      */           } 
/*      */         } else {
/* 1232 */           i1 = 0;
/* 1233 */           bool1 = false;
/*      */         } 
/*      */         
/* 1236 */         if (!bool1 && !i1 && !bool3 && !bool2) {
/* 1237 */           if (n == 0) {
/* 1238 */             setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1239 */             n = Integer.MAX_VALUE;
/* 1240 */             appendDashes(paramLineAppendable, m, basedSequence, 0);
/* 1241 */           } else if (!bool4 && n < m) {
/* 1242 */             i1 = appendDashes(paramLineAppendable, n, basedSequence, 0);
/* 1243 */             setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1244 */             appendDashes(paramLineAppendable, m - n, basedSequence, i1);
/* 1245 */             n = Integer.MAX_VALUE;
/*      */           } else {
/* 1247 */             appendDashes(paramLineAppendable, m, basedSequence, 0);
/* 1248 */             setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1249 */             n = Integer.MAX_VALUE;
/*      */           } 
/*      */         } else {
/* 1252 */           appendDashes(paramLineAppendable, m, basedSequence, 0);
/*      */         } 
/*      */         
/* 1255 */         if (cellAlignment2 == CellAlignment.RIGHT || cellAlignment2 == CellAlignment.CENTER) {
/* 1256 */           if (bool3) {
/* 1257 */             paramLineAppendable.append(':');
/* 1258 */             setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1259 */             n = Integer.MAX_VALUE;
/* 1260 */           } else if (bool2) {
/* 1261 */             setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1262 */             n = Integer.MAX_VALUE;
/* 1263 */             paramLineAppendable.append(':');
/*      */           } else {
/* 1265 */             paramLineAppendable.append(':');
/*      */           } 
/* 1267 */         } else if (bool3 || bool2) {
/* 1268 */           setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getInsideStartOffset(tableCell2), paramLineAppendable.offsetWithPending());
/* 1269 */           n = Integer.MAX_VALUE;
/*      */         } 
/*      */         
/* 1272 */         assert n == Integer.MAX_VALUE;
/*      */       } else {
/* 1274 */         if (this.options.leadTrailPipes && b1 == 0) paramLineAppendable.append('|'); 
/* 1275 */         if (cellAlignment2 == CellAlignment.LEFT || cellAlignment2 == CellAlignment.CENTER) paramLineAppendable.append(':');
/*      */         
/* 1277 */         appendDashes(paramLineAppendable, m, basedSequence, 0);
/*      */         
/* 1279 */         if (cellAlignment2 == CellAlignment.RIGHT || cellAlignment2 == CellAlignment.CENTER) paramLineAppendable.append(':');
/*      */       
/*      */       } 
/* 1282 */       b1++;
/* 1283 */       if (this.options.leadTrailPipes || b1 < this.alignments.length) paramLineAppendable.append('|'); 
/*      */       b2++; }
/*      */     
/* 1286 */     if (tableRow != null && tableRow.afterOffset != Integer.MAX_VALUE) {
/* 1287 */       setTrackedOffsetIndex(tableRow.afterOffset, paramLineAppendable.offsetWithPending());
/*      */     }
/*      */     
/* 1290 */     paramLineAppendable.line();
/*      */ 
/*      */     
/* 1293 */     appendRows(paramLineAppendable, this.body.rows, false, charSequence);
/*      */     
/*      */     TableCell tableCell;
/*      */     String str;
/* 1297 */     if ((str = formattedCaption((tableCell = getCaptionCell()).text, this.options)) != null) {
/* 1298 */       BasedSequence basedSequence = BasedSequence.of(str).subSequence(0, str.length());
/* 1299 */       boolean bool = false;
/*      */       
/* 1301 */       if (this.caption.rows.size() > 0) {
/* 1302 */         TableRow tableRow1 = this.caption.rows.get(0);
/* 1303 */         if (tableCell.trackedTextOffset != Integer.MAX_VALUE || tableRow1.beforeOffset != Integer.MAX_VALUE || tableRow1.afterOffset != Integer.MAX_VALUE) {
/* 1304 */           TableCell tableCell1 = tableCell;
/*      */           
/* 1306 */           paramLineAppendable.line();
/*      */           
/* 1308 */           if (tableRow1.beforeOffset != Integer.MAX_VALUE) {
/* 1309 */             setTrackedOffsetIndex(tableRow1.beforeOffset, paramLineAppendable.offsetWithPending());
/*      */           }
/*      */           
/* 1312 */           tableCell = tableCell.withText((CharSequence)tableCell.text.trim());
/* 1313 */           if (tableCell1.trackedTextOffset != Integer.MAX_VALUE) {
/* 1314 */             tableCell = tableCell.withTrackedOffset(Utils.minLimit(tableCell1.trackedTextOffset - ((BasedSequence)tableCell1.text.trimmedStart()).length(), new int[] { 0 }));
/*      */           }
/*      */           
/* 1317 */           boolean bool1 = false;
/* 1318 */           boolean bool2 = false;
/*      */           
/* 1320 */           if (!tableCell.text.isBlank()) {
/* 1321 */             switch (this.options.formatTableCaptionSpaces) {
/*      */               case LEFT:
/* 1323 */                 bool1 = true;
/* 1324 */                 bool2 = true;
/*      */                 break;
/*      */ 
/*      */               
/*      */               case RIGHT:
/*      */                 break;
/*      */               
/*      */               default:
/* 1332 */                 bool1 = tableCell1.text.startsWith(" ");
/* 1333 */                 bool2 = tableCell1.text.endsWith(" ");
/*      */                 break;
/*      */             } 
/*      */           
/*      */           }
/* 1338 */           paramLineAppendable.append(charSequence);
/* 1339 */           paramLineAppendable.append('[');
/* 1340 */           if (bool1) paramLineAppendable.append(' ');
/*      */           
/* 1342 */           int j = paramLineAppendable.offsetWithPending();
/*      */           
/* 1344 */           tableRow1.cells.set(0, tableCell);
/* 1345 */           Ref<Integer> ref1 = new Ref(Integer.valueOf(0));
/* 1346 */           BasedSequence basedSequence1 = cellText(tableRow1.cells, 0, true, false, 0, CellAlignment.LEFT, ref1);
/* 1347 */           paramLineAppendable.offsetWithPending();
/*      */           
/* 1349 */           if (tableRow1.cells.size() > 0) {
/* 1350 */             TableCell tableCell2; if (tableCell1.trackedTextOffset != Integer.MAX_VALUE && 
/*      */               
/* 1352 */               (tableCell2 = tableRow1.cells.get(0)).trackedTextOffset != Integer.MAX_VALUE) {
/* 1353 */               setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.text.getStartOffset(), j + (basedSequence1.isBlank() ? 1 : (Utils.minLimit(tableCell2.trackedTextOffset, new int[] { 0 }) + tableCell2.trackedTextAdjust)));
/*      */             }
/*      */             
/* 1356 */             tableRow1.cells.set(0, tableCell1);
/*      */           } else {
/* 1358 */             tableRow1.cells.add(tableCell1);
/*      */           } 
/*      */           
/* 1361 */           paramLineAppendable.append((CharSequence)basedSequence1);
/*      */           
/* 1363 */           if (bool2) paramLineAppendable.append(' '); 
/* 1364 */           paramLineAppendable.append(']');
/*      */           
/* 1366 */           if (tableRow1.afterOffset != Integer.MAX_VALUE) {
/* 1367 */             setTrackedOffsetIndex(tableRow1.afterOffset, paramLineAppendable.offsetWithPending());
/*      */           }
/* 1369 */           paramLineAppendable.line();
/*      */           
/* 1371 */           bool = true;
/*      */         } 
/*      */       } 
/*      */       
/* 1375 */       if (!bool) {
/* 1376 */         paramLineAppendable.popOptions().pushOptions();
/* 1377 */         paramLineAppendable.line().append(charSequence).append('[').append((CharSequence)basedSequence).append(']').line();
/*      */       } 
/*      */     } 
/* 1380 */     paramLineAppendable.popOptions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void appendFormattedCaption(LineAppendable paramLineAppendable, BasedSequence paramBasedSequence, TableFormatOptions paramTableFormatOptions) {
/*      */     String str;
/* 1389 */     if ((str = formattedCaption(paramBasedSequence, paramTableFormatOptions)) != null) {
/* 1390 */       paramLineAppendable.line().append('[').append(str).append(']').line();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String formattedCaption(BasedSequence paramBasedSequence, TableFormatOptions paramTableFormatOptions) {
/* 1398 */     boolean bool = paramBasedSequence.isNotNull();
/*      */     
/* 1400 */     switch (paramTableFormatOptions.formatTableCaption) {
/*      */       case LEFT:
/* 1402 */         bool = true;
/*      */         break;
/*      */       
/*      */       case RIGHT:
/* 1406 */         bool = !paramBasedSequence.isBlank();
/*      */         break;
/*      */       
/*      */       case CENTER:
/* 1410 */         bool = false;
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1418 */     if (bool) {
/* 1419 */       String str = "";
/*      */       
/* 1421 */       switch (paramTableFormatOptions.formatTableCaptionSpaces) {
/*      */         case LEFT:
/* 1423 */           str = " ";
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1433 */       return str + paramBasedSequence.toString() + str;
/*      */     } 
/* 1435 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean pipeNeedsSpaceBefore(TableCell paramTableCell) {
/* 1442 */     return (paramTableCell.text.equals(" ") || !paramTableCell.text.endsWith(" "));
/*      */   }
/*      */   
/*      */   private boolean pipeNeedsSpaceAfter(TableCell paramTableCell) {
/* 1446 */     return (paramTableCell.text.equals(" ") || !paramTableCell.text.startsWith(" "));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void appendRows(LineAppendable paramLineAppendable, List<TableRow> paramList, boolean paramBoolean, CharSequence paramCharSequence) {
/* 1455 */     for (TableRow tableRow : paramList) {
/* 1456 */       byte b1 = 0;
/* 1457 */       int i = 0;
/* 1458 */       Ref<Integer> ref = new Ref(Integer.valueOf(0));
/*      */       
/* 1460 */       paramLineAppendable.append(paramCharSequence);
/*      */       
/* 1462 */       if (tableRow.beforeOffset != Integer.MAX_VALUE) {
/* 1463 */         setTrackedOffsetIndex(tableRow.beforeOffset, paramLineAppendable.offsetWithPending());
/*      */       }
/*      */       
/* 1466 */       int j = tableRow.cells.size();
/* 1467 */       for (byte b2 = 0; b2 < j; b2++) {
/* 1468 */         TableCell tableCell1 = tableRow.cells.get(b2);
/*      */         
/* 1470 */         if (!b1)
/* 1471 */         { if (this.options.leadTrailPipes) {
/* 1472 */             paramLineAppendable.append('|');
/* 1473 */             if (this.options.spaceAroundPipes && pipeNeedsSpaceAfter(tableCell1)) paramLineAppendable.append(' ');
/*      */           
/*      */           }  }
/* 1476 */         else if (this.options.spaceAroundPipes && pipeNeedsSpaceAfter(tableCell1)) { paramLineAppendable.append(' '); }
/*      */ 
/*      */         
/* 1479 */         CellAlignment cellAlignment = (paramBoolean && tableCell1.alignment != CellAlignment.NONE) ? tableCell1.alignment : this.alignments[i];
/*      */         
/* 1481 */         BasedSequence basedSequence = cellText(tableRow.cells, b2, true, paramBoolean, 
/* 1482 */             spanWidth(i, tableCell1.columnSpan) - this.options.spacePad - this.options.pipeWidth * tableCell1.columnSpan, cellAlignment, ref);
/*      */         
/*      */         TableCell tableCell2;
/* 1485 */         if (tableCell1.trackedTextOffset != Integer.MAX_VALUE && 
/*      */           
/* 1487 */           (tableCell2 = tableRow.cells.get(b2)).trackedTextOffset != Integer.MAX_VALUE) {
/* 1488 */           int k = paramLineAppendable.offsetWithPending();
/* 1489 */           byte b = tableCell1.text.isBlank() ? -1 : 0;
/* 1490 */           if (!setTrackedOffsetIndex(tableCell1.trackedTextOffset + tableCell1.getTextStartOffset((b2 == 0) ? null : tableRow.cells.get(b2 - 1)), k + Utils.minLimit(tableCell2.trackedTextOffset + b, new int[] { 0 }) + tableCell2.trackedTextAdjust))
/*      */           {
/* 1492 */             System.out.println(String.format("Offset not found: cell.trackedTextOffset: %d, adjusted trackedOffset: %d in offsets: %s", new Object[] {
/* 1493 */                     Integer.valueOf(tableCell1.trackedTextOffset), 
/* 1494 */                     Integer.valueOf(tableCell1.trackedTextOffset + tableCell1.getTextStartOffset((b2 == 0) ? null : tableRow.cells.get(b2 - 1))), this.trackedOffsets
/*      */                   }));
/*      */           }
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1501 */         paramLineAppendable.append((CharSequence)basedSequence);
/*      */         
/* 1503 */         b1++;
/* 1504 */         i += tableCell1.columnSpan;
/*      */         
/* 1506 */         if (b1 < this.alignments.length) {
/* 1507 */           if (this.options.spaceAroundPipes && pipeNeedsSpaceBefore(tableCell1)) paramLineAppendable.append(' '); 
/* 1508 */           appendColumnSpan(paramLineAppendable, tableCell1.columnSpan, tableCell1.getInsideEndOffset(), tableCell1.spanTrackedOffset);
/* 1509 */         } else if (this.options.leadTrailPipes) {
/* 1510 */           if (this.options.spaceAroundPipes && pipeNeedsSpaceBefore(tableCell1)) paramLineAppendable.append(' '); 
/* 1511 */           appendColumnSpan(paramLineAppendable, tableCell1.columnSpan, tableCell1.getInsideEndOffset(), tableCell1.spanTrackedOffset);
/*      */         } else {
/* 1513 */           if (this.options.spaceAroundPipes && pipeNeedsSpaceBefore(tableCell1)) paramLineAppendable.append(' '); 
/* 1514 */           appendColumnSpan(paramLineAppendable, tableCell1.columnSpan - 1, tableCell1.getInsideEndOffset(), tableCell1.spanTrackedOffset);
/*      */         } 
/*      */       } 
/*      */       
/* 1518 */       if (tableRow.afterOffset != Integer.MAX_VALUE) {
/* 1519 */         setTrackedOffsetIndex(tableRow.afterOffset, paramLineAppendable.offsetWithPending());
/*      */       }
/*      */       
/* 1522 */       if (b1 > 0) paramLineAppendable.line();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void appendColumnSpan(LineAppendable paramLineAppendable, int paramInt1, int paramInt2, int paramInt3) {
/* 1532 */     if (paramInt3 == Integer.MAX_VALUE) {
/* 1533 */       paramLineAppendable.append('|', paramInt1); return;
/*      */     } 
/* 1535 */     if (paramInt3 == 0) {
/* 1536 */       setTrackedOffsetIndex(paramInt2 + paramInt3, paramLineAppendable.offsetWithPending());
/* 1537 */       paramLineAppendable.append('|', paramInt1); return;
/* 1538 */     }  if (paramInt3 < paramInt1) {
/* 1539 */       paramLineAppendable.append('|', paramInt3);
/* 1540 */       setTrackedOffsetIndex(paramInt2 + paramInt3, paramLineAppendable.offsetWithPending());
/* 1541 */       paramLineAppendable.append('|', paramInt1 - paramInt3); return;
/*      */     } 
/* 1543 */     paramLineAppendable.append('|', paramInt1);
/* 1544 */     setTrackedOffsetIndex(paramInt2 + paramInt3, paramLineAppendable.offsetWithPending());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BasedSequence cellText(List<TableCell> paramList, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, CellAlignment paramCellAlignment, Ref<Integer> paramRef) {
/* 1559 */     TableCell tableCell1 = paramList.get(paramInt1), tableCell2 = tableCell1;
/* 1560 */     BasedSequence basedSequence = tableCell1.text;
/* 1561 */     boolean bool1 = (tableCell1.trackedTextOffset != Integer.MAX_VALUE && tableCell1.trackedTextOffset >= tableCell1.text.length()) ? true : false;
/* 1562 */     boolean bool2 = false;
/*      */     
/* 1564 */     if (tableCell1.trackedTextOffset != Integer.MAX_VALUE) {
/* 1565 */       if (tableCell1.trackedTextOffset > tableCell1.text.length()) {
/*      */         
/* 1567 */         int j = tableCell1.trackedTextOffset - tableCell1.text.length() - 1;
/* 1568 */         basedSequence = (BasedSequence)basedSequence.append(new CharSequence[] { RepeatedSequence.repeatOf(' ', j) });
/* 1569 */       } else if (tableCell1.trackedTextOffset < 0) {
/* 1570 */         bool2 = true;
/*      */       } 
/*      */     }
/*      */     
/* 1574 */     int i = this.options.charWidthProvider.getStringWidth((CharSequence)basedSequence);
/* 1575 */     if (this.options.adjustColumnWidth && (i < paramInt2 || tableCell1.trackedTextOffset > tableCell1.text.length())) {
/* 1576 */       int k; PrefixedSubSequence prefixedSubSequence; if (!this.options.applyColumnAlignment || paramCellAlignment == null || paramCellAlignment == CellAlignment.NONE) {
/* 1577 */         paramCellAlignment = (paramBoolean2 && this.options.leftAlignMarker != DiscretionaryText.ADD) ? CellAlignment.CENTER : CellAlignment.LEFT;
/* 1578 */       } else if (paramBoolean2 && paramCellAlignment == CellAlignment.LEFT && this.options.leftAlignMarker == DiscretionaryText.REMOVE) {
/* 1579 */         paramCellAlignment = CellAlignment.CENTER;
/*      */       } 
/*      */       
/* 1582 */       int j = paramInt2 - i;
/* 1583 */       i = (((Integer)paramRef.value).intValue() + j) / this.options.spaceWidth;
/*      */       
/* 1585 */       if (paramInt2 > 0 && Math.abs(((Integer)paramRef.value).intValue() + j - (i + 1) * this.options.spaceWidth) < Math.abs(((Integer)paramRef.value).intValue() + j - i * this.options.spaceWidth)) {
/* 1586 */         i++;
/*      */       }
/*      */       Ref<Integer> ref;
/* 1589 */       (ref = paramRef).value = Integer.valueOf(((Integer)ref.value).intValue() + j - i * this.options.spaceWidth);
/*      */       
/* 1591 */       switch (paramCellAlignment) {
/*      */         case LEFT:
/* 1593 */           if (i > 0) {
/* 1594 */             basedSequence = (BasedSequence)basedSequence.append(new CharSequence[] { (CharSequence)PrefixedSubSequence.repeatOf(" ", i, basedSequence.getEmptySuffix()) });
/*      */           }
/*      */           
/* 1597 */           if (paramBoolean1 && bool1 && tableCell1.afterSpace)
/*      */           {
/* 1599 */             if (i <= 0) tableCell2 = tableCell2.withTrackedTextAdjust(1);
/*      */           
/*      */           }
/*      */           break;
/*      */         case RIGHT:
/* 1604 */           if (i > 0) {
/* 1605 */             prefixedSubSequence = PrefixedSubSequence.repeatOf(" ", i, basedSequence);
/*      */             
/* 1607 */             if (paramBoolean1 && tableCell1.trackedTextOffset != Integer.MAX_VALUE) {
/* 1608 */               tableCell2 = tableCell1.withTrackedOffset(Utils.maxLimit(prefixedSubSequence.length(), new int[] { tableCell1.trackedTextOffset + i }));
/*      */             }
/*      */             
/* 1611 */             if (paramBoolean1 && bool2 && tableCell1.afterSpace) {
/* 1612 */               tableCell2 = tableCell2.withTrackedTextAdjust(1);
/*      */             }
/*      */           } 
/*      */           
/* 1616 */           if (paramBoolean1 && bool1 && tableCell1.afterSpace && (
/* 1617 */             i <= 0 || !tableCell1.afterDelete)) tableCell2 = tableCell2.withTrackedTextAdjust(1);
/*      */           
/*      */           break;
/*      */         
/*      */         case CENTER:
/* 1622 */           k = i / 2;
/* 1623 */           if (i > 0) {
/* 1624 */             basedSequence = (BasedSequence)PrefixedSubSequence.repeatOf(" ", k, (BasedSequence)prefixedSubSequence).append(new CharSequence[] { (CharSequence)PrefixedSubSequence.repeatOf(" ", i - k, prefixedSubSequence.getEmptySuffix()) });
/*      */             
/* 1626 */             if (paramBoolean1 && tableCell1.trackedTextOffset != Integer.MAX_VALUE) {
/* 1627 */               tableCell2 = tableCell1.withTrackedOffset(Utils.maxLimit(basedSequence.length(), new int[] { tableCell1.trackedTextOffset + k }));
/*      */             }
/*      */             
/* 1630 */             if (paramBoolean1 && bool2 && tableCell1.afterSpace)
/* 1631 */               tableCell2 = tableCell2.withTrackedTextAdjust(1); 
/*      */             break;
/*      */           } 
/* 1634 */           if (paramBoolean1 && bool1 && tableCell1.afterSpace) {
/* 1635 */             tableCell2 = tableCell2.withTrackedTextAdjust(1);
/*      */           }
/*      */           break;
/*      */       } 
/*      */ 
/*      */     
/*      */     } 
/* 1642 */     if (paramBoolean1 && tableCell2.trackedTextOffset != Integer.MAX_VALUE) {
/*      */       
/* 1644 */       if (tableCell2.trackedTextOffset > basedSequence.length()) {
/* 1645 */         tableCell2 = tableCell2.withTrackedOffset(basedSequence.length());
/*      */       }
/*      */       
/* 1648 */       if (tableCell2 != tableCell1) paramList.set(paramInt1, tableCell2);
/*      */     
/*      */     } 
/* 1651 */     return basedSequence;
/*      */   }
/*      */   
/*      */   private int spanWidth(int paramInt1, int paramInt2) {
/* 1655 */     if (paramInt2 > 1) {
/* 1656 */       int i = 0;
/* 1657 */       for (byte b = 0; b < paramInt2; b++) {
/* 1658 */         i += this.columnWidths[b + paramInt1];
/*      */       }
/* 1660 */       return i;
/*      */     } 
/* 1662 */     return this.columnWidths[paramInt1];
/*      */   }
/*      */ 
/*      */   
/*      */   private int spanFixedWidth(BitSet paramBitSet, int paramInt1, int paramInt2) {
/* 1667 */     if (paramInt2 > 1) {
/* 1668 */       int i = 0;
/* 1669 */       for (byte b = 0; b < paramInt2; b++) {
/* 1670 */         if (!paramBitSet.get(b)) {
/* 1671 */           i += this.columnWidths[b + paramInt1];
/*      */         }
/*      */       } 
/* 1674 */       return i;
/*      */     } 
/* 1676 */     return paramBitSet.get(paramInt1) ? 0 : this.columnWidths[paramInt1];
/*      */   }
/*      */   
/*      */   private static class ColumnSpan
/*      */   {
/*      */     final int startColumn;
/*      */     final int columnSpan;
/*      */     final int width;
/*      */     int additionalWidth;
/*      */     
/*      */     public ColumnSpan(int param1Int1, int param1Int2, int param1Int3) {
/* 1687 */       this.startColumn = param1Int1;
/* 1688 */       this.columnSpan = param1Int2;
/* 1689 */       this.width = param1Int3;
/* 1690 */       this.additionalWidth = 0;
/*      */     }
/*      */   }
/*      */   
/*      */   private CellAlignment adjustCellAlignment(CellAlignment paramCellAlignment) {
/* 1695 */     switch (this.options.leftAlignMarker) {
/*      */       case LEFT:
/* 1697 */         if (paramCellAlignment == null || paramCellAlignment == CellAlignment.NONE) paramCellAlignment = CellAlignment.LEFT; 
/*      */         break;
/*      */       case RIGHT:
/* 1700 */         if (paramCellAlignment == CellAlignment.LEFT) paramCellAlignment = CellAlignment.NONE;
/*      */         
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/* 1706 */     return paramCellAlignment;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int aggregateTotalColumnsWithoutColumns(TableSection[] paramArrayOfTableSection, BiFunction<Integer, Integer, Integer> paramBiFunction, int... paramVarArgs) {
/* 1714 */     Integer[] arrayOfInteger = { null };
/*      */     
/* 1716 */     forAllSectionsRows(0, 2147483647, paramArrayOfTableSection, (paramTableRow, paramInt1, paramArrayList, paramInt2) -> {
/*      */           paramInt1 = paramTableRow.cells.size();
/*      */           int i = 0;
/*      */           for (paramInt2 = 0; paramInt2 < paramInt1; paramInt2++) {
/*      */             if (!ArrayUtils.contained(paramInt2, paramArrayOfint)) {
/*      */               i += ((TableCell)paramTableRow.cells.get(paramInt2)).columnSpan;
/*      */             }
/*      */           } 
/*      */           if (i != 0)
/*      */             paramArrayOfInteger[0] = paramBiFunction.apply(paramArrayOfInteger[0], Integer.valueOf(i)); 
/*      */           return 0;
/*      */         });
/* 1728 */     return (arrayOfInteger[0] == null) ? 0 : arrayOfInteger[0].intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int aggregateTotalColumnsWithoutRows(TableSection[] paramArrayOfTableSection, BiFunction<Integer, Integer, Integer> paramBiFunction, int... paramVarArgs) {
/* 1736 */     Integer[] arrayOfInteger = { null };
/*      */     
/* 1738 */     forAllSectionsRows(0, 2147483647, paramArrayOfTableSection, (paramTableRow, paramInt1, paramArrayList, paramInt2) -> {
/*      */           int i;
/*      */           
/*      */           if (!ArrayUtils.contained(paramInt1, paramArrayOfint) && (i = paramTableRow.getTotalColumns()) > 0) {
/*      */             paramArrayOfInteger[0] = paramBiFunction.apply(paramArrayOfInteger[0], Integer.valueOf(i));
/*      */           }
/*      */           return 0;
/*      */         });
/* 1746 */     return (arrayOfInteger[0] == null) ? 0 : arrayOfInteger[0].intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void forAllSectionsRows(int paramInt1, int paramInt2, TableSection[] paramArrayOfTableSection, TableRowManipulator paramTableRowManipulator) {
/* 1755 */     if (paramInt2 <= 0)
/* 1756 */       return;  paramInt2 = paramInt2;
/* 1757 */     int i = paramInt1;
/* 1758 */     paramInt1 = paramInt1; int j;
/*      */     byte b;
/* 1760 */     for (j = (paramArrayOfTableSection = paramArrayOfTableSection).length, b = 0; b < j; ) { TableSection tableSection = paramArrayOfTableSection[b];
/*      */ 
/*      */       
/* 1763 */       if (i >= tableSection.rows.size()) {
/* 1764 */         i -= tableSection.rows.size();
/*      */       } else {
/*      */         
/* 1767 */         int k = i;
/* 1768 */         i = 0;
/*      */ 
/*      */         
/* 1771 */         while (k < tableSection.rows.size()) {
/*      */           int m;
/* 1773 */           if ((m = paramTableRowManipulator.apply(tableSection.rows.get(k), paramInt1, tableSection.rows, k)) == Integer.MIN_VALUE)
/* 1774 */             return;  if (m < 0) {
/* 1775 */             paramInt1 -= m;
/* 1776 */             paramInt2 += m;
/*      */           } else {
/* 1778 */             k += m + 1;
/* 1779 */             paramInt2--;
/*      */           } 
/* 1781 */           if (paramInt2 <= 0)
/* 1782 */             return;  paramInt1++;
/*      */         } 
/*      */       } 
/*      */       b++; }
/*      */   
/*      */   }
/*      */   public static class IndexSpanOffset { public final int index;
/*      */     public final int spanOffset;
/*      */     
/*      */     public IndexSpanOffset(int param1Int1, int param1Int2) {
/* 1792 */       this.index = param1Int1;
/* 1793 */       this.spanOffset = param1Int2;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1798 */       return "IndexSpanOffset{index=" + this.index + ", spanOffset=" + this.spanOffset + '}';
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1808 */     return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "{header=" + this.header + ",\nseparator=" + this.separator + ",\nbody=" + this.body + ",\ncaption=" + this.caption + ",\noptions=" + this.options + ",\ntrackedOffsets=" + this.trackedOffsets + "}";
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\MarkdownTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */