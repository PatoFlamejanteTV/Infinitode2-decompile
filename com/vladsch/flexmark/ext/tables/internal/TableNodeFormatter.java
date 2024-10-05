/*     */ package com.vladsch.flexmark.ext.tables.internal;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ext.tables.TableBlock;
/*     */ import com.vladsch.flexmark.ext.tables.TableBody;
/*     */ import com.vladsch.flexmark.ext.tables.TableCaption;
/*     */ import com.vladsch.flexmark.ext.tables.TableCell;
/*     */ import com.vladsch.flexmark.ext.tables.TableHead;
/*     */ import com.vladsch.flexmark.ext.tables.TableRow;
/*     */ import com.vladsch.flexmark.ext.tables.TableSeparator;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*     */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*     */ import com.vladsch.flexmark.formatter.RenderPurpose;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.format.MarkdownTable;
/*     */ import com.vladsch.flexmark.util.format.TableFormatOptions;
/*     */ import com.vladsch.flexmark.util.format.TrackedOffset;
/*     */ import com.vladsch.flexmark.util.format.TrackedOffsetList;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class TableNodeFormatter implements NodeFormatter {
/*     */   public TableNodeFormatter(DataHolder paramDataHolder) {
/*  31 */     this.options = new TableFormatOptions(paramDataHolder);
/*  32 */     this.parserTrimCellWhiteSpace = ((Boolean)TablesExtension.TRIM_CELL_WHITESPACE.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */   private final TableFormatOptions options; private final boolean parserTrimCellWhiteSpace;
/*     */   private MarkdownTable myTable;
/*     */   
/*     */   public Set<Class<?>> getNodeClasses() {
/*  38 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*  44 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(TableBlock.class, this::render), new NodeFormattingHandler(TableHead.class, this::render), new NodeFormattingHandler(TableSeparator.class, this::render), new NodeFormattingHandler(TableBody.class, this::render), new NodeFormattingHandler(TableRow.class, this::render), new NodeFormattingHandler(TableCell.class, this::render), new NodeFormattingHandler(TableCaption.class, this::render), new NodeFormattingHandler(Text.class, this::render) }));
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
/*     */   private void render(TableBlock paramTableBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*     */     TrackedOffsetList trackedOffsetList1, trackedOffsetList2;
/*  57 */     this.myTable = new MarkdownTable((CharSequence)paramTableBlock.getChars(), this.options);
/*     */     
/*  59 */     switch (paramNodeFormatterContext.getRenderPurpose()) {
/*     */       case TRANSLATION_SPANS:
/*     */       case TRANSLATED_SPANS:
/*     */       case TRANSLATED:
/*  63 */         paramMarkdownWriter.blankLine();
/*  64 */         paramNodeFormatterContext.renderChildren((Node)paramTableBlock);
/*  65 */         paramMarkdownWriter.tailBlankLine();
/*     */         break;
/*     */ 
/*     */       
/*     */       default:
/*  70 */         paramNodeFormatterContext.renderChildren((Node)paramTableBlock);
/*     */ 
/*     */         
/*  73 */         trackedOffsetList2 = (trackedOffsetList1 = paramNodeFormatterContext.getTrackedOffsets()).getTrackedOffsets(paramTableBlock.getStartOffset(), paramTableBlock.getEndOffset());
/*     */         
/*  75 */         if (!trackedOffsetList1.isEmpty()) {
/*  76 */           for (TrackedOffset trackedOffset : trackedOffsetList2) {
/*  77 */             assert trackedOffset.getOffset() >= paramTableBlock.getStartOffset() && trackedOffset.getOffset() <= paramTableBlock.getEndOffset();
/*  78 */             this.myTable.addTrackedOffset(trackedOffset);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*  83 */         if (this.options.tableManipulator != TableManipulator.NULL) {
/*  84 */           this.myTable.normalize();
/*  85 */           this.options.tableManipulator.apply(this.myTable, (Node)paramTableBlock);
/*     */         } 
/*     */         
/*  88 */         if (this.myTable.getMaxColumns() > 0) {
/*     */           
/*  90 */           paramMarkdownWriter.blankLine();
/*     */           
/*  92 */           BasedSequence basedSequence = paramMarkdownWriter.getPrefix();
/*  93 */           this.myTable.setFormatTableIndentPrefix((CharSequence)basedSequence);
/*  94 */           MarkdownWriter markdownWriter = new MarkdownWriter(paramMarkdownWriter.getOptions());
/*  95 */           this.myTable.appendTable((LineAppendable)markdownWriter);
/*     */           
/*  97 */           List list = this.myTable.getTrackedOffsets();
/*  98 */           int i = paramMarkdownWriter.offsetWithPending();
/*  99 */           if (!trackedOffsetList2.isEmpty()) {
/* 100 */             assert trackedOffsetList2.size() == list.size();
/*     */ 
/*     */             
/* 103 */             for (TrackedOffset trackedOffset : trackedOffsetList2) {
/* 104 */               assert trackedOffset.getOffset() >= paramTableBlock.getStartOffset() && trackedOffset.getOffset() <= paramTableBlock.getEndOffset();
/*     */               
/* 106 */               if (trackedOffset.isResolved()) {
/* 107 */                 trackedOffset.setIndex(trackedOffset.getIndex() + i);
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 112 */           ((MarkdownWriter)((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.pushPrefix()).setPrefix("", false))
/* 113 */             .pushOptions())
/* 114 */             .removeOptions(LineAppendable.F_WHITESPACE_REMOVAL)
/* 115 */             .append((LineAppendable)markdownWriter)
/* 116 */             .popOptions()
/* 117 */             .popPrefix(false);
/*     */ 
/*     */           
/* 120 */           paramMarkdownWriter.tailBlankLine();
/*     */           
/* 122 */           if (this.myTable.getMaxColumns() > 0 && !trackedOffsetList2.isEmpty() && 
/* 123 */             this.options.dumpIntellijOffsets) {
/* 124 */             ((MarkdownWriter)paramMarkdownWriter.append("\nTracked Offsets")).line();
/* 125 */             String str = "  ";
/* 126 */             byte b = 0;
/* 127 */             for (TrackedOffset trackedOffset : list) {
/* 128 */               b++;
/* 129 */               ((MarkdownWriter)paramMarkdownWriter.append(str)).append(String.format(Locale.US, "%d:[%d,%d] was:[%d,%d]", new Object[] { Integer.valueOf(b), Integer.valueOf(trackedOffset.getIndex()), Integer.valueOf(trackedOffset.getIndex() + 1), Integer.valueOf(trackedOffset.getOffset()), Integer.valueOf(trackedOffset.getOffset() + 1) }));
/* 130 */               str = " ";
/*     */             } 
/* 132 */             paramMarkdownWriter.append("\n");
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     } 
/*     */     
/* 138 */     this.myTable = null;
/*     */   }
/*     */   
/*     */   private void render(TableHead paramTableHead, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 142 */     this.myTable.setSeparator(false);
/* 143 */     this.myTable.setHeader(true);
/* 144 */     paramNodeFormatterContext.renderChildren((Node)paramTableHead);
/*     */   }
/*     */   
/*     */   private void render(TableSeparator paramTableSeparator, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 148 */     this.myTable.setSeparator(true);
/* 149 */     paramNodeFormatterContext.renderChildren((Node)paramTableSeparator);
/*     */   }
/*     */   
/*     */   private void render(TableBody paramTableBody, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 153 */     this.myTable.setSeparator(false);
/* 154 */     this.myTable.setHeader(false);
/* 155 */     paramNodeFormatterContext.renderChildren((Node)paramTableBody);
/*     */   }
/*     */   
/*     */   private void render(TableRow paramTableRow, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 159 */     paramNodeFormatterContext.renderChildren((Node)paramTableRow);
/* 160 */     if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT)
/* 161 */     { if (!this.myTable.isSeparator()) { this.myTable.nextRow(); return; }
/*     */        }
/* 163 */     else { paramMarkdownWriter.line(); }
/*     */   
/*     */   }
/*     */   
/*     */   private void render(TableCaption paramTableCaption, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 168 */     if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
/* 169 */       this.myTable.setCaptionWithMarkers((Node)paramTableCaption, (CharSequence)paramTableCaption.getOpeningMarker(), (CharSequence)paramTableCaption.getText(), (CharSequence)paramTableCaption.getClosingMarker());
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     String str;
/* 175 */     if ((str = MarkdownTable.formattedCaption(BasedSequence.of(str = (String)(paramTableCaption.hasChildren() ? "dummy" : "")).subSequence(0, str.length()), this.options)) != null) {
/* 176 */       ((MarkdownWriter)paramMarkdownWriter.line()).append((CharSequence)paramTableCaption.getOpeningMarker());
/* 177 */       paramNodeFormatterContext.renderChildren((Node)paramTableCaption);
/* 178 */       ((MarkdownWriter)paramMarkdownWriter.append((CharSequence)paramTableCaption.getClosingMarker())).line();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(TableCell paramTableCell, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 184 */     if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
/* 185 */       BasedSequence basedSequence = paramTableCell.getText();
/* 186 */       if (this.options.trimCellWhitespace) {
/* 187 */         if (basedSequence.isBlank() && !basedSequence.isEmpty()) {
/* 188 */           basedSequence = basedSequence.subSequence(0, 1);
/*     */         } else {
/* 190 */           basedSequence = (BasedSequence)basedSequence.trim();
/*     */         } 
/*     */       }
/* 193 */       this.myTable.addCell(new TableCell((Node)paramTableCell, (CharSequence)paramTableCell.getOpeningMarker(), (CharSequence)basedSequence, (CharSequence)paramTableCell.getClosingMarker(), 1, paramTableCell.getSpan(), (paramTableCell.getAlignment() == null) ? CellAlignment.NONE : paramTableCell.getAlignment().cellAlignment())); return;
/*     */     } 
/* 195 */     if (paramTableCell.getPrevious() == null)
/* 196 */     { if (this.options.leadTrailPipes && paramTableCell.getOpeningMarker().isEmpty()) { paramMarkdownWriter.append('|'); }
/* 197 */       else { paramMarkdownWriter.append((CharSequence)paramTableCell.getOpeningMarker()); }
/*     */        }
/* 199 */     else { paramMarkdownWriter.append((CharSequence)paramTableCell.getOpeningMarker()); }
/*     */ 
/*     */     
/* 202 */     if (!this.myTable.isSeparator() && this.options.spaceAroundPipes && (!paramTableCell.getText().startsWith(" ") || this.parserTrimCellWhiteSpace)) paramMarkdownWriter.append(' ');
/*     */     
/* 204 */     String[] arrayOfString = { "" };
/*     */     
/* 206 */     paramNodeFormatterContext.translatingSpan((paramNodeFormatterContext, paramMarkdownWriter) -> {
/*     */           paramNodeFormatterContext.renderChildren((Node)paramTableCell);
/*     */           
/*     */           paramArrayOfString[0] = paramMarkdownWriter.toString(-1, -1);
/*     */         });
/* 211 */     if (!this.myTable.isSeparator() && this.options.spaceAroundPipes && (!arrayOfString[0].endsWith(" ") || this.parserTrimCellWhiteSpace)) paramMarkdownWriter.append(' '); 
/* 212 */     if (paramTableCell.getNext() == null) {
/* 213 */       if (this.options.leadTrailPipes && paramTableCell.getClosingMarker().isEmpty()) { paramMarkdownWriter.append('|'); return; }
/* 214 */        paramMarkdownWriter.append((CharSequence)paramTableCell.getClosingMarker()); return;
/*     */     } 
/* 216 */     paramMarkdownWriter.append((CharSequence)paramTableCell.getClosingMarker());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(Text paramText, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 223 */     if (this.myTable != null && this.myTable.isSeparator()) {
/*     */       Node node;
/* 225 */       if (node = paramText.getAncestorOfType(new Class[] { Paragraph.class }) instanceof Paragraph && ((Paragraph)node).hasTableSeparator()) {
/* 226 */         ((MarkdownWriter)((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(" ")).append((CharSequence)paramText.getChars())).popPrefix();
/*     */       } else {
/* 228 */         paramMarkdownWriter.append((CharSequence)paramText.getChars()); return;
/*     */       } 
/*     */     } else {
/* 231 */       paramMarkdownWriter.append((CharSequence)paramText.getChars());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements NodeFormatterFactory
/*     */   {
/*     */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 239 */       return new TableNodeFormatter(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\internal\TableNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */