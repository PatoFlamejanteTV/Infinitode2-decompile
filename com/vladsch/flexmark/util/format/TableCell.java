/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.html.CellAlignment;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableCell
/*     */ {
/*  13 */   public static final TableCell NULL = new TableCell(null, (CharSequence)BasedSequence.NULL, " ", (CharSequence)BasedSequence.NULL, 1, 0, CellAlignment.NONE);
/*  14 */   public static final TableCell DEFAULT_CELL = new TableCell(null, (CharSequence)BasedSequence.NULL, " ", (CharSequence)BasedSequence.NULL, 1, 1, CellAlignment.NONE);
/*     */   
/*     */   public static final int NOT_TRACKED = 2147483647;
/*     */   public final Node tableCellNode;
/*     */   public final BasedSequence openMarker;
/*     */   public final BasedSequence text;
/*     */   public final BasedSequence closeMarker;
/*     */   public final int columnSpan;
/*     */   public final int rowSpan;
/*     */   public final CellAlignment alignment;
/*     */   public final int trackedTextOffset;
/*     */   public final int spanTrackedOffset;
/*     */   public final int trackedTextAdjust;
/*     */   public final boolean afterSpace;
/*     */   public final boolean afterDelete;
/*     */   
/*     */   public TableCell(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  31 */     this(null, (CharSequence)BasedSequence.NULL, paramCharSequence, (CharSequence)BasedSequence.NULL, paramInt1, paramInt2, CellAlignment.NONE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCell(Node paramNode, CharSequence paramCharSequence, int paramInt1, int paramInt2, CellAlignment paramCellAlignment) {
/*  41 */     this(paramNode, (CharSequence)BasedSequence.NULL, paramCharSequence, (CharSequence)BasedSequence.NULL, paramInt1, paramInt2, paramCellAlignment);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCell(Node paramNode, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, int paramInt2) {
/*  52 */     this(paramNode, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt1, paramInt2, CellAlignment.NONE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCell(Node paramNode, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, int paramInt2, CellAlignment paramCellAlignment) {
/*  64 */     this(paramNode, paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt1, paramInt2, paramCellAlignment, 2147483647, 2147483647, 0, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCell(Node paramNode, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt1, int paramInt2, CellAlignment paramCellAlignment, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2) {
/*  82 */     BasedSequence basedSequence2 = BasedSequence.of(paramCharSequence2);
/*  83 */     this.tableCellNode = paramNode;
/*  84 */     this.openMarker = BasedSequence.of(paramCharSequence1);
/*  85 */     this.closeMarker = BasedSequence.of(paramCharSequence3);
/*  86 */     BasedSequence basedSequence1 = this.openMarker.isEmpty() ? this.closeMarker.subSequence(0, 0) : (BasedSequence)this.openMarker.subSequence(this.openMarker.length());
/*  87 */     this.text = (basedSequence2.isEmpty() && basedSequence2 != BasedSequence.NULL) ? (BasedSequence)PrefixedSubSequence.prefixOf(" ", basedSequence1) : basedSequence2;
/*  88 */     this.rowSpan = paramInt1;
/*  89 */     this.columnSpan = paramInt2;
/*  90 */     this.alignment = (paramCellAlignment != null) ? paramCellAlignment : CellAlignment.NONE;
/*  91 */     this.trackedTextOffset = paramInt3;
/*  92 */     this.spanTrackedOffset = paramInt4;
/*  93 */     this.trackedTextAdjust = paramInt5;
/*  94 */     this.afterSpace = paramBoolean1;
/*  95 */     this.afterDelete = paramBoolean2;
/*     */   }
/*     */   
/*     */   public TableCell(TableCell paramTableCell, boolean paramBoolean, int paramInt1, int paramInt2, CellAlignment paramCellAlignment) {
/*  99 */     this.tableCellNode = paramBoolean ? paramTableCell.tableCellNode : null;
/* 100 */     this.openMarker = paramTableCell.openMarker;
/* 101 */     this.closeMarker = paramTableCell.closeMarker;
/* 102 */     BasedSequence basedSequence = this.openMarker.isEmpty() ? this.closeMarker.subSequence(0, 0) : (BasedSequence)this.openMarker.subSequence(this.openMarker.length());
/* 103 */     this.text = (paramTableCell.text == BasedSequence.NULL) ? (BasedSequence)PrefixedSubSequence.prefixOf(" ", basedSequence) : paramTableCell.text;
/* 104 */     this.rowSpan = paramInt1;
/* 105 */     this.columnSpan = paramInt2;
/* 106 */     this.alignment = (paramCellAlignment != null) ? paramCellAlignment : CellAlignment.NONE;
/* 107 */     this.trackedTextOffset = paramTableCell.trackedTextOffset;
/* 108 */     this.spanTrackedOffset = paramTableCell.spanTrackedOffset;
/* 109 */     this.trackedTextAdjust = paramTableCell.trackedTextAdjust;
/* 110 */     this.afterSpace = paramTableCell.afterSpace;
/* 111 */     this.afterDelete = paramTableCell.afterDelete;
/*     */   }
/*     */   public TableCell withColumnSpan(int paramInt) {
/* 114 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, this.rowSpan, paramInt, this.alignment, this.trackedTextOffset, (this.spanTrackedOffset == Integer.MAX_VALUE) ? Integer.MAX_VALUE : Utils.min(this.spanTrackedOffset, new int[] { paramInt }), this.trackedTextAdjust, this.afterSpace, this.afterDelete);
/*     */   } public TableCell withText(CharSequence paramCharSequence) {
/* 116 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, paramCharSequence, (CharSequence)this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, 2147483647, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCell withText(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3) {
/* 122 */     return new TableCell(this.tableCellNode, paramCharSequence1, paramCharSequence2, paramCharSequence3, this.rowSpan, this.columnSpan, this.alignment, 2147483647, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
/*     */   } public TableCell withRowSpan(int paramInt) {
/* 124 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, paramInt, this.columnSpan, this.alignment, this.trackedTextOffset, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
/*     */   } public TableCell withAlignment(CellAlignment paramCellAlignment) {
/* 126 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, this.rowSpan, this.columnSpan, paramCellAlignment, this.trackedTextOffset, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
/*     */   } public TableCell withTrackedOffset(int paramInt) {
/* 128 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, paramInt, this.spanTrackedOffset, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCell withTrackedOffset(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 134 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, paramInt, this.spanTrackedOffset, this.trackedTextAdjust, paramBoolean1, paramBoolean2);
/*     */   } public TableCell withSpanTrackedOffset(int paramInt) {
/* 136 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, this.trackedTextOffset, paramInt, this.trackedTextAdjust, this.afterSpace, this.afterDelete);
/*     */   } public TableCell withTrackedTextAdjust(int paramInt) {
/* 138 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, this.trackedTextOffset, this.spanTrackedOffset, paramInt, this.afterSpace, this.afterDelete);
/*     */   } public TableCell withAfterSpace(boolean paramBoolean) {
/* 140 */     return new TableCell(this.tableCellNode, (CharSequence)this.openMarker, (CharSequence)this.text, (CharSequence)this.closeMarker, this.rowSpan, this.columnSpan, this.alignment, this.trackedTextOffset, this.spanTrackedOffset, this.trackedTextAdjust, paramBoolean, this.afterDelete);
/*     */   }
/*     */   BasedSequence getLastSegment() {
/* 143 */     return !this.closeMarker.isEmpty() ? this.closeMarker : this.text;
/*     */   }
/*     */   
/*     */   public int getEndOffset() {
/* 147 */     return !this.closeMarker.isEmpty() ? this.closeMarker.getEndOffset() : this.text.getEndOffset();
/*     */   }
/*     */   
/*     */   public int getStartOffset(TableCell paramTableCell) {
/* 151 */     return (paramTableCell != null) ? paramTableCell.getEndOffset() : (!this.openMarker.isEmpty() ? this.openMarker.getStartOffset() : this.text.getStartOffset());
/*     */   }
/*     */   
/*     */   public int getInsideStartOffset(TableCell paramTableCell) {
/* 155 */     return (paramTableCell != null) ? paramTableCell.getEndOffset() : (!this.openMarker.isEmpty() ? this.openMarker.getEndOffset() : this.text.getStartOffset());
/*     */   }
/*     */   
/*     */   public int getTextStartOffset(TableCell paramTableCell) {
/* 159 */     if (!this.text.isEmpty()) return this.text.getStartOffset(); 
/* 160 */     if (!this.openMarker.isEmpty()) return this.openMarker.getEndOffset() + 1; 
/* 161 */     if (paramTableCell != null) return paramTableCell.getEndOffset() + 1; 
/* 162 */     return this.closeMarker.getStartOffset() - 1;
/*     */   }
/*     */   
/*     */   public int getTextEndOffset(TableCell paramTableCell) {
/* 166 */     if (!this.text.isEmpty()) return this.text.getEndOffset(); 
/* 167 */     if (!this.openMarker.isEmpty()) return this.openMarker.getEndOffset() + 1; 
/* 168 */     if (paramTableCell != null) return paramTableCell.getEndOffset() + 1; 
/* 169 */     return this.closeMarker.getStartOffset() - 1;
/*     */   }
/*     */   
/*     */   public int getInsideEndOffset() {
/* 173 */     return !this.closeMarker.isEmpty() ? this.closeMarker.getStartOffset() : this.text.getEndOffset();
/*     */   }
/*     */   
/*     */   public int getCellSize(TableCell paramTableCell) {
/* 177 */     return getEndOffset() - getStartOffset(paramTableCell);
/*     */   }
/*     */   
/*     */   public int insideToTextOffset(int paramInt, TableCell paramTableCell) {
/* 181 */     return Utils.maxLimit(this.text.length(), new int[] { Utils.minLimit(paramInt - getInsideStartOffset(paramTableCell) + getTextStartOffset(paramTableCell), new int[] { 0 }) });
/*     */   }
/*     */   
/*     */   public int textToInsideOffset(int paramInt, TableCell paramTableCell) {
/* 185 */     return Utils.maxLimit(getCellSize(paramTableCell), new int[] { Utils.minLimit(paramInt - getTextStartOffset(paramTableCell) + getInsideStartOffset(paramTableCell), new int[] { 0 }) });
/*     */   }
/*     */   
/*     */   public boolean isInsideCell(int paramInt, TableCell paramTableCell) {
/* 189 */     return (paramInt >= getInsideStartOffset(paramTableCell) && paramInt <= getInsideEndOffset());
/*     */   }
/*     */   
/*     */   public boolean isAtCell(int paramInt, TableCell paramTableCell) {
/* 193 */     return (paramInt >= getInsideStartOffset(paramTableCell) && paramInt <= getInsideEndOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCellLength(TableCell paramTableCell) {
/* 203 */     return getEndOffset() - getStartOffset(paramTableCell);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCellPrefixLength(TableCell paramTableCell) {
/* 213 */     return getInsideStartOffset(paramTableCell) - getStartOffset(paramTableCell);
/*     */   }
/*     */   
/*     */   private CharSequence dumpSequence(BasedSequence paramBasedSequence) {
/*     */     StringBuilder stringBuilder;
/* 218 */     (stringBuilder = new StringBuilder()).append("{ \"").append((CharSequence)paramBasedSequence.replace("\"", "\\\"")).append("\" [")
/* 219 */       .append(paramBasedSequence.getStartOffset()).append(", ").append(paramBasedSequence.getEndOffset()).append("), length=").append(paramBasedSequence.length())
/* 220 */       .append("}");
/* 221 */     return stringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 227 */     return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "{openMarker=" + 
/* 228 */       dumpSequence(this.openMarker) + ", text=" + 
/* 229 */       dumpSequence(this.text) + ", closeMarker=" + 
/* 230 */       dumpSequence(this.closeMarker) + ", columnSpan=" + this.columnSpan + ", rowSpan=" + this.rowSpan + ", alignment=" + this.alignment + ", trackedTextOffset=" + this.trackedTextOffset + ", spanTrackedOffset=" + this.spanTrackedOffset + ", trackedTextAdjust=" + this.trackedTextAdjust + ", afterSpace=" + this.afterSpace + ", afterDelete=" + this.afterDelete + '}';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableCell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */