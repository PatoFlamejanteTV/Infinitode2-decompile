/*     */ package com.vladsch.flexmark.ext.tables.internal;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ext.tables.TableBlock;
/*     */ import com.vladsch.flexmark.ext.tables.TableBody;
/*     */ import com.vladsch.flexmark.ext.tables.TableCaption;
/*     */ import com.vladsch.flexmark.ext.tables.TableCell;
/*     */ import com.vladsch.flexmark.ext.tables.TableHead;
/*     */ import com.vladsch.flexmark.ext.tables.TableRow;
/*     */ import com.vladsch.flexmark.ext.tables.TableSeparator;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.block.CharacterNodeFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.parser.core.ReferencePreProcessorFactory;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TableParagraphPreProcessor implements ParagraphPreProcessor {
/*  26 */   private static BitSet pipeCharacters = new BitSet();
/*  27 */   private static BitSet separatorCharacters = new BitSet(); private static HashMap<Character, CharacterNodeFactory> pipeNodeMap; private static HashMap<Character, CharacterNodeFactory> pipeIntelliJNodeMap; private final TableParserOptions options; Pattern TABLE_HEADER_SEPARATOR;
/*     */   static {
/*  29 */     pipeCharacters.set(124);
/*     */     
/*  31 */     separatorCharacters.set(124);
/*  32 */     separatorCharacters.set(58);
/*  33 */     separatorCharacters.set(45);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     (pipeNodeMap = new HashMap<>()).put(Character.valueOf('|'), new CharacterNodeFactory()
/*     */         {
/*     */           public final boolean skipNext(char param1Char) {
/*  41 */             return (param1Char == ' ' || param1Char == '\t');
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final boolean skipPrev(char param1Char) {
/*  47 */             return (param1Char == ' ' || param1Char == '\t');
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final boolean wantSkippedWhitespace() {
/*  53 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public final Node get() {
/*  58 */             return new TableColumnSeparator();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  64 */     (pipeIntelliJNodeMap = new HashMap<>()).put(Character.valueOf('|'), new CharacterNodeFactory()
/*     */         {
/*     */           public final boolean skipNext(char param1Char) {
/*  67 */             return (param1Char == ' ' || param1Char == '\t');
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final boolean skipPrev(char param1Char) {
/*  73 */             return (param1Char == ' ' || param1Char == '\t');
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final boolean wantSkippedWhitespace() {
/*  79 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public final Node get() {
/*  84 */             return new TableColumnSeparator();
/*     */           }
/*     */         });
/*     */   }
/*     */   public static ParagraphPreProcessorFactory Factory() {
/*  89 */     return new ParagraphPreProcessorFactory()
/*     */       {
/*     */         public final boolean affectsGlobalScope() {
/*  92 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public final Set<Class<?>> getAfterDependents() {
/*     */           HashSet<Class<ReferencePreProcessorFactory>> hashSet;
/*  99 */           (hashSet = new HashSet<>()).add(ReferencePreProcessorFactory.class);
/* 100 */           return hashSet;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public final Set<Class<?>> getBeforeDependents() {
/* 106 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public final ParagraphPreProcessor apply(ParserState param1ParserState) {
/* 111 */           return new TableParagraphPreProcessor((DataHolder)param1ParserState.getProperties());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pattern getTableHeaderSeparator(int paramInt, String paramString) {
/* 120 */     boolean bool1 = (paramInt > 0) ? paramInt : true;
/* 121 */     boolean bool2 = (paramInt >= 2) ? (paramInt - 1) : true;
/* 122 */     paramInt = (paramInt >= 3) ? (paramInt - 2) : 1;
/*     */     
/* 124 */     String str1 = String.format(Locale.US, "(?:\\s*-{%d,}\\s*|\\s*:-{%d,}\\s*|\\s*-{%d,}:\\s*|\\s*:-{%d,}:\\s*)", new Object[] { Integer.valueOf(bool1), Integer.valueOf(bool2), Integer.valueOf(bool2), Integer.valueOf(paramInt) });
/*     */     
/*     */     boolean bool;
/* 127 */     String str3 = (bool = paramString.isEmpty()) ? "" : TableFormatOptions.INTELLIJ_DUMMY_IDENTIFIER;
/* 128 */     String str4 = bool ? "\\s" : ("(?:\\s" + str3 + "?)");
/* 129 */     String str5 = bool ? "-" : ("(?:-" + str3 + "?)");
/* 130 */     String str2 = bool ? "\\|" : ("(?:" + str3 + "?\\|" + str3 + "?)");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     return Pattern.compile(str1 = (str1 = "\\|" + str1 + "\\|?\\s*|" + str1 + "\\|\\s*|\\|?(?:" + str1 + "\\|)+" + str1 + "\\|?\\s*").replace("\\s", str4).replace("\\|", str2).replace("-", str5));
/*     */   }
/*     */   
/*     */   private TableParagraphPreProcessor(DataHolder paramDataHolder) {
/* 143 */     this.options = new TableParserOptions(paramDataHolder);
/*     */ 
/*     */     
/* 146 */     this.TABLE_HEADER_SEPARATOR = getTableHeaderSeparator(this.options.minSeparatorDashes, "");
/*     */   }
/*     */   
/*     */   private static class TableSeparatorRow
/*     */     extends TableRow implements DoNotDecorate {
/*     */     public TableSeparatorRow() {}
/*     */     
/*     */     public TableSeparatorRow(BasedSequence param1BasedSequence) {
/* 154 */       super(param1BasedSequence);
/*     */     }
/*     */   }
/*     */   
/*     */   public int preProcessBlock(Paragraph paramParagraph, ParserState paramParserState) {
/*     */     TableBody tableBody;
/* 160 */     InlineParser inlineParser = paramParserState.getInlineParser();
/*     */     
/* 162 */     ArrayList<BasedSequence> arrayList = new ArrayList();
/* 163 */     int i = -1;
/* 164 */     BasedSequence basedSequence1 = null;
/* 165 */     int j = paramParagraph.getLineIndent(0);
/* 166 */     BasedSequence basedSequence2 = null;
/* 167 */     BitSet bitSet = separatorCharacters;
/* 168 */     HashMap<Character, CharacterNodeFactory> hashMap = pipeNodeMap;
/*     */ 
/*     */     
/* 171 */     for (BasedSequence basedSequence3 : paramParagraph.getContentLines()) {
/* 172 */       int n = arrayList.size();
/* 173 */       if (i == -1 && n > this.options.maxHeaderRows) return 0;
/*     */       
/* 175 */       if (basedSequence3.indexOf('|') < 0) {
/* 176 */         if (i == -1) return 0; 
/*     */         BasedSequence basedSequence;
/* 178 */         if (this.options.withCaption && (
/*     */           
/* 180 */           basedSequence = (BasedSequence)basedSequence3.trim()).startsWith("[") && basedSequence.endsWith("]")) {
/* 181 */           basedSequence2 = basedSequence;
/*     */         }
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */       
/* 188 */       BasedSequence basedSequence4 = (BasedSequence)basedSequence3.subSequence(paramParagraph.getLineIndent(n));
/*     */       
/* 190 */       if (i == -1 && 
/* 191 */         n >= this.options.minHeaderRows && this.TABLE_HEADER_SEPARATOR
/* 192 */         .matcher((CharSequence)basedSequence4).matches())
/*     */       {
/* 194 */         if ((basedSequence3.charAt(0) != ' ' && basedSequence3.charAt(0) != '\t') || basedSequence3.charAt(0) != '|') {
/* 195 */           i = n;
/* 196 */           basedSequence1 = basedSequence4;
/* 197 */         } else if (basedSequence3.charAt(0) == ' ' || basedSequence3.charAt(0) == '\t') {
/* 198 */           paramParagraph.setHasTableSeparator(true);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 203 */       arrayList.add(basedSequence4);
/*     */     } 
/*     */ 
/*     */     
/* 207 */     if (i == -1) return 0;
/*     */     
/* 209 */     ArrayList<TableRow> arrayList1 = new ArrayList();
/* 210 */     for (BasedSequence basedSequence3 : arrayList) {
/* 211 */       int i1; List<Node> list1; int n = arrayList1.size();
/*     */       
/* 213 */       BasedSequence basedSequence4 = (paramParagraph.getLineIndent(n) <= j) ? (BasedSequence)basedSequence3.trimEOL() : basedSequence3.baseSubSequence(basedSequence3.getStartOffset() - paramParagraph.getLineIndent(n) - j, basedSequence3.getEndOffset() - basedSequence3.eolEndLength());
/* 214 */       boolean bool = (n == i) ? true : false;
/* 215 */       TableRow tableRow = new TableRow(basedSequence4);
/*     */ 
/*     */ 
/*     */       
/* 219 */       if (bool) {
/* 220 */         TableSeparatorRow tableSeparatorRow = new TableSeparatorRow(basedSequence4);
/* 221 */         list1 = inlineParser.parseCustom(basedSequence4, (Node)tableSeparatorRow, bitSet, hashMap);
/* 222 */         tableRow.takeChildren((Node)tableSeparatorRow);
/*     */         
/* 224 */         i1 = 0;
/*     */       } else {
/* 226 */         list1 = inlineParser.parseCustom(basedSequence4, (Node)tableRow, pipeCharacters, pipeNodeMap);
/* 227 */         if (n < i) { i1 = n + 1; }
/* 228 */         else { i1 = n - i; }
/*     */ 
/*     */ 
/*     */         
/* 232 */         if (list1 != null) {
/* 233 */           list1 = cleanUpInlinedSeparators(inlineParser, tableRow, list1);
/*     */         }
/*     */       } 
/*     */       
/* 237 */       if (list1 == null) {
/* 238 */         if (n <= i) return 0;
/*     */         
/*     */         break;
/*     */       } 
/* 242 */       tableRow.setRowNumber(i1);
/* 243 */       arrayList1.add(tableRow);
/*     */     } 
/*     */ 
/*     */     
/* 247 */     TableBlock tableBlock = new TableBlock(arrayList.subList(0, arrayList1.size()));
/* 248 */     TableHead tableHead = new TableHead(((BasedSequence)arrayList.get(0)).subSequence(0, 0));
/* 249 */     tableBlock.appendChild((Node)tableHead);
/*     */     
/* 251 */     List<TableCell.Alignment> list = parseAlignment(basedSequence1);
/*     */     
/* 253 */     int k = 0;
/* 254 */     int m = list.size();
/* 255 */     for (TableRow tableRow2 : arrayList1) {
/* 256 */       TableSeparator tableSeparator; if (k == i) {
/* 257 */         tableHead.setCharsFromContent();
/* 258 */         tableSeparator = new TableSeparator();
/* 259 */         tableBlock.appendChild((Node)tableSeparator);
/* 260 */       } else if (k == i + 1) {
/* 261 */         tableSeparator.setCharsFromContent();
/* 262 */         tableBody = new TableBody();
/* 263 */         tableBlock.appendChild((Node)tableBody);
/*     */       } 
/*     */       
/* 266 */       boolean bool = true;
/* 267 */       byte b = 0;
/* 268 */       NodeIterator nodeIterator = new NodeIterator(tableRow2.getFirstChild());
/*     */       TableRow tableRow1;
/* 270 */       (tableRow1 = new TableRow(tableRow2.getChars())).setRowNumber(tableRow2.getRowNumber());
/* 271 */       j = 0;
/*     */       
/* 273 */       while (nodeIterator.hasNext()) {
/* 274 */         BasedSequence basedSequence; if (b >= m && this.options.discardExtraColumns) {
/* 275 */           if (this.options.headerSeparatorColumnMatch && k < i)
/*     */           {
/* 277 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 284 */         TableCell tableCell = new TableCell();
/*     */         
/* 286 */         if (bool && nodeIterator.peek() instanceof TableColumnSeparator) {
/* 287 */           Node node = nodeIterator.next();
/* 288 */           tableCell.setOpeningMarker(node.getChars());
/* 289 */           node.unlink();
/* 290 */           bool = false;
/*     */         } 
/*     */         
/* 293 */         TableCell.Alignment alignment = (b + j < m) ? list.get(b + j) : null;
/* 294 */         tableCell.setHeader((k < i));
/* 295 */         tableCell.setAlignment(alignment);
/*     */ 
/*     */         
/* 298 */         while (nodeIterator.hasNext() && 
/* 299 */           !(nodeIterator.peek() instanceof TableColumnSeparator)) {
/* 300 */           tableCell.appendChild(nodeIterator.next());
/*     */         }
/*     */ 
/*     */         
/* 304 */         alignment = null;
/* 305 */         byte b1 = 1;
/* 306 */         while (nodeIterator.hasNext() && 
/* 307 */           nodeIterator.peek() instanceof TableColumnSeparator) {
/* 308 */           if (alignment == null) {
/* 309 */             basedSequence = nodeIterator.next().getChars();
/* 310 */             if (!this.options.columnSpans)
/*     */               break;  continue;
/* 312 */           }  BasedSequence basedSequence3 = nodeIterator.peek().getChars();
/*     */           
/* 314 */           if (basedSequence.isContinuedBy(basedSequence3)) {
/* 315 */             basedSequence = basedSequence.spliceAtEnd(basedSequence3);
/* 316 */             nodeIterator.next().unlink();
/* 317 */             b1++;
/*     */           } 
/*     */         } 
/*     */         
/* 321 */         j += b1 - 1;
/*     */         
/* 323 */         if (basedSequence != null) tableCell.setClosingMarker(basedSequence); 
/* 324 */         tableCell.setChars(tableCell.getChildChars());
/*     */         
/* 326 */         if (this.options.trimCellWhitespace) { tableCell.trimWhiteSpace(); }
/* 327 */         else { tableCell.mergeWhiteSpace(); }
/*     */ 
/*     */         
/* 330 */         tableCell.setText(tableCell.getChildChars());
/*     */         
/* 332 */         tableCell.setCharsFromContent();
/* 333 */         tableCell.setSpan(b1);
/* 334 */         tableRow1.appendChild((Node)tableCell);
/* 335 */         b++;
/*     */       } 
/*     */       
/* 338 */       if (this.options.headerSeparatorColumnMatch && k < i && b < m)
/*     */       {
/* 340 */         return 0;
/*     */       }
/*     */       
/* 343 */       while (this.options.appendMissingColumns && b < m) {
/*     */         TableCell tableCell;
/* 345 */         (tableCell = new TableCell()).setHeader((k < i));
/* 346 */         tableCell.setAlignment(list.get(b));
/* 347 */         tableRow1.appendChild((Node)tableCell);
/* 348 */         b++;
/*     */       } 
/*     */       
/* 351 */       tableRow1.setCharsFromContent();
/* 352 */       tableBody.appendChild((Node)tableRow1);
/*     */       
/* 354 */       k++;
/*     */     } 
/*     */     
/* 357 */     tableBody.setCharsFromContent();
/*     */     
/* 359 */     if (tableBody instanceof TableSeparator) {
/* 360 */       TableBody tableBody1 = new TableBody((BasedSequence)tableBody.getChars().subSequence(tableBody.getChars().length()));
/* 361 */       tableBlock.appendChild((Node)tableBody1);
/*     */     } 
/*     */ 
/*     */     
/* 365 */     if (basedSequence2 != null) {
/* 366 */       TableCaption tableCaption = new TableCaption(basedSequence2.subSequence(0, 1), basedSequence2.subSequence(1, basedSequence2.length() - 1), (BasedSequence)basedSequence2.subSequence(basedSequence2.length() - 1));
/* 367 */       inlineParser.parse(tableCaption.getText(), (Node)tableCaption);
/* 368 */       tableCaption.setCharsFromContent();
/* 369 */       tableBlock.appendChild((Node)tableCaption);
/*     */     } 
/*     */     
/* 372 */     tableBlock.setCharsFromContent();
/*     */     
/* 374 */     paramParagraph.insertBefore((Node)tableBlock);
/* 375 */     paramParserState.blockAdded((Block)tableBlock);
/* 376 */     return tableBlock.getChars().length();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   List<Node> cleanUpInlinedSeparators(InlineParser paramInlineParser, TableRow paramTableRow, List<Node> paramList) {
/* 382 */     ArrayList<Node> arrayList1 = null;
/* 383 */     ArrayList<Node> arrayList2 = null; Iterator<Node> iterator;
/* 384 */     for (iterator = paramList.iterator(); iterator.hasNext();) {
/* 385 */       if ((node = iterator.next()).getParent() != null && node.getParent() != paramTableRow) {
/*     */         
/* 387 */         Node node1 = (node.getPrevious() instanceof com.vladsch.flexmark.ast.WhiteSpace) ? node.getPrevious() : node;
/* 388 */         Node node2 = (node.getNext() instanceof com.vladsch.flexmark.ast.WhiteSpace) ? node.getNext() : node;
/*     */         
/* 390 */         Text text = new Text(node.baseSubSequence(node1.getStartOffset(), node2.getEndOffset()));
/* 391 */         node.insertBefore((Node)text);
/* 392 */         node.unlink();
/* 393 */         node1.unlink();
/* 394 */         node2.unlink();
/*     */         
/* 396 */         if (arrayList1 == null) {
/* 397 */           arrayList1 = new ArrayList();
/* 398 */           arrayList2 = new ArrayList();
/*     */         } 
/*     */         
/* 401 */         arrayList1.add(node);
/* 402 */         arrayList2.add(text.getParent());
/*     */       } 
/*     */     } 
/*     */     
/* 406 */     if (arrayList2 != null) {
/* 407 */       for (Node node : arrayList2) {
/* 408 */         paramInlineParser.mergeTextNodes(node.getFirstChild(), node.getLastChild());
/*     */       }
/*     */       
/* 411 */       if (arrayList1.size() == paramList.size()) {
/* 412 */         return null;
/*     */       }
/*     */       ArrayList<Node> arrayList;
/* 415 */       (arrayList = new ArrayList<>(paramList)).removeAll(arrayList1);
/* 416 */       return arrayList;
/*     */     } 
/*     */ 
/*     */     
/* 420 */     return paramList;
/*     */   }
/*     */   
/*     */   private List<TableCell.Alignment> parseAlignment(BasedSequence paramBasedSequence) {
/* 424 */     List<BasedSequence> list = split(paramBasedSequence, false, false);
/* 425 */     ArrayList<TableCell.Alignment> arrayList = new ArrayList();
/* 426 */     for (Iterator<BasedSequence> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */       BasedSequence basedSequence;
/* 428 */       boolean bool2 = (basedSequence = (BasedSequence)(basedSequence = iterator.next()).trim()).startsWith(":");
/* 429 */       boolean bool1 = basedSequence.endsWith(":");
/* 430 */       TableCell.Alignment alignment = getAlignment(bool2, bool1);
/* 431 */       arrayList.add(alignment);
/*     */     } 
/* 433 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<BasedSequence> split(BasedSequence paramBasedSequence, boolean paramBoolean1, boolean paramBoolean2) {
/* 439 */     int i = (paramBasedSequence = (BasedSequence)paramBasedSequence.trim()).length();
/* 440 */     ArrayList<BasedSequence> arrayList = new ArrayList();
/*     */     
/* 442 */     if (paramBasedSequence.startsWith("|")) {
/* 443 */       if (paramBoolean2) arrayList.add(paramBasedSequence.subSequence(0, 1)); 
/* 444 */       paramBasedSequence = paramBasedSequence.subSequence(1, i);
/* 445 */       i--;
/*     */     } 
/*     */     
/* 448 */     boolean bool = false;
/* 449 */     int j = 0;
/* 450 */     byte b1 = 0;
/* 451 */     for (byte b2 = 0; b2 < i; b2++) {
/* 452 */       char c = paramBasedSequence.charAt(b2);
/* 453 */       if (bool) {
/* 454 */         bool = false;
/*     */       }
/*     */       
/* 457 */       switch (c) {
/*     */         case '\\':
/* 459 */           bool = true;
/*     */ 
/*     */ 
/*     */         
/*     */         case '|':
/* 464 */           if (!paramBoolean1 || j < b2) arrayList.add(paramBasedSequence.subSequence(j, b2)); 
/* 465 */           if (paramBoolean2) arrayList.add(paramBasedSequence.subSequence(b2, b2 + 1)); 
/* 466 */           j = b2 + 1;
/* 467 */           b1 = 0;
/*     */           break;
/*     */         default:
/* 470 */           b1++;
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 475 */     if (b1 > 0) {
/* 476 */       arrayList.add(paramBasedSequence.subSequence(j, i));
/*     */     }
/* 478 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static TableCell.Alignment getAlignment(boolean paramBoolean1, boolean paramBoolean2) {
/* 482 */     if (paramBoolean1 && paramBoolean2)
/* 483 */       return TableCell.Alignment.CENTER; 
/* 484 */     if (paramBoolean1)
/* 485 */       return TableCell.Alignment.LEFT; 
/* 486 */     if (paramBoolean2) {
/* 487 */       return TableCell.Alignment.RIGHT;
/*     */     }
/* 489 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\internal\TableParagraphPreProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */