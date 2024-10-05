/*     */ package com.vladsch.flexmark.formatter;
/*     */ import com.vladsch.flexmark.ast.HtmlCommentBlock;
/*     */ import com.vladsch.flexmark.ast.HtmlInlineComment;
/*     */ import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
/*     */ import com.vladsch.flexmark.ast.ListBlock;
/*     */ import com.vladsch.flexmark.ast.ListItem;
/*     */ import com.vladsch.flexmark.ast.OrderedList;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.ParagraphContainer;
/*     */ import com.vladsch.flexmark.parser.ListOptions;
/*     */ import com.vladsch.flexmark.util.ast.BlankLine;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockQuoteLike;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*     */ import com.vladsch.flexmark.util.format.options.BlockQuoteMarker;
/*     */ import com.vladsch.flexmark.util.format.options.ListBulletMarker;
/*     */ import com.vladsch.flexmark.util.format.options.ListNumberedMarker;
/*     */ import com.vladsch.flexmark.util.format.options.ListSpacing;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*     */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.function.Function;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class FormatterUtils {
/*  41 */   public static final DataKey<Integer> LIST_ITEM_NUMBER = new DataKey("LIST_ITEM_NUMBER", Integer.valueOf(0));
/*  42 */   public static final DataKey<Boolean> FIRST_LIST_ITEM_CHILD = new DataKey("FIRST_LIST_ITEM_CHILD", Boolean.FALSE);
/*     */   public static final Function<CharSequence, Pair<Integer, Integer>> NULL_PADDING = paramCharSequence -> Pair.of(Integer.valueOf(0), Integer.valueOf(0));
/*  44 */   public static final DataKey<Function<CharSequence, Pair<Integer, Integer>>> LIST_ALIGN_NUMERIC = new DataKey("LIST_ITEM_NUMBER", NULL_PADDING);
/*  45 */   public static final NullableDataKey<ListSpacing> LIST_ITEM_SPACING = new NullableDataKey("LIST_ITEM_SPACING");
/*     */   
/*     */   public static String getBlockLikePrefix(BlockQuoteLike paramBlockQuoteLike, NodeFormatterContext paramNodeFormatterContext, BlockQuoteMarker paramBlockQuoteMarker, BasedSequence paramBasedSequence) {
/*  48 */     String str1, str3 = paramBlockQuoteLike.getOpeningMarker().toString();
/*     */     
/*  50 */     boolean bool = false;
/*     */     
/*  52 */     switch (paramBlockQuoteMarker) {
/*     */       case ANY:
/*  54 */         if (paramBlockQuoteLike.getFirstChild() != null) {
/*  55 */           String str = paramBlockQuoteLike.getChars().baseSubSequence(paramBlockQuoteLike.getOpeningMarker().getStartOffset(), paramBlockQuoteLike.getFirstChild().getStartOffset()).toString(); break;
/*     */         } 
/*  57 */         str1 = str3;
/*     */         break;
/*     */ 
/*     */       
/*     */       case DASH:
/*  62 */         str1 = str3.trim();
/*     */         break;
/*     */       
/*     */       case ASTERISK:
/*  66 */         bool = true;
/*  67 */         str1 = str3.trim() + " ";
/*     */         break;
/*     */       
/*     */       case PLUS:
/*  71 */         str1 = str3.trim() + " ";
/*     */         break;
/*     */       
/*     */       default:
/*  75 */         throw new IllegalStateException("Unexpected value: " + paramBlockQuoteMarker);
/*     */     } 
/*     */ 
/*     */     
/*  79 */     CharPredicate charPredicate = paramNodeFormatterContext.getBlockQuoteLikePrefixPredicate();
/*     */     
/*  81 */     String str2 = paramBasedSequence.toString();
/*  82 */     if (bool && str2.endsWith(" ") && str2.length() >= 2 && charPredicate.test(str2.charAt(str2.length() - 2))) {
/*  83 */       str2 = str2.substring(0, str2.length() - 1) + str1;
/*     */     } else {
/*  85 */       str2 = str2 + str1;
/*     */     } 
/*     */     
/*  88 */     return str2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence stripSoftLineBreak(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  93 */     StringBuffer stringBuffer = null;
/*  94 */     Matcher matcher = Pattern.compile("\\s*(?:\r\n|\r|\n)\\s*").matcher(paramCharSequence1);
/*  95 */     while (matcher.find()) {
/*  96 */       if (stringBuffer == null) stringBuffer = new StringBuffer(); 
/*  97 */       matcher.appendReplacement(stringBuffer, paramCharSequence2.toString());
/*     */     } 
/*  99 */     if (stringBuffer != null) {
/* 100 */       matcher.appendTail(stringBuffer);
/* 101 */       return stringBuffer;
/*     */     } 
/* 103 */     return paramCharSequence1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getActualAdditionalPrefix(BasedSequence paramBasedSequence, MarkdownWriter paramMarkdownWriter) {
/* 109 */     int j = paramMarkdownWriter.getPrefix().length();
/* 110 */     int i = paramBasedSequence.baseColumnAtStart();
/*     */     
/*     */     String str;
/* 113 */     return str = RepeatedSequence.repeatOf(" ", Utils.minLimit(0, new int[] { i - j })).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getAdditionalPrefix(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/* 119 */     int i = paramBasedSequence1.getStartOffset();
/* 120 */     int j = paramBasedSequence2.getStartOffset();
/*     */     
/*     */     String str;
/* 123 */     return str = RepeatedSequence.repeatOf(" ", Utils.minLimit(0, new int[] { j - i })).toString();
/*     */   }
/*     */   
/*     */   public static BasedSequence getSoftLineBreakSpan(Node paramNode) {
/* 127 */     if (paramNode == null) return BasedSequence.NULL;
/*     */     
/* 129 */     Node node1 = paramNode;
/* 130 */     Node node2 = paramNode.getNext();
/*     */     
/* 132 */     while (node2 != null && !(node2 instanceof com.vladsch.flexmark.ast.SoftLineBreak)) {
/* 133 */       node1 = node2;
/* 134 */       node2 = node2.getNext();
/*     */     } 
/*     */     
/* 137 */     return Node.spanningChars(new BasedSequence[] { paramNode.getChars(), node1.getChars() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void appendWhiteSpaceBetween(MarkdownWriter paramMarkdownWriter, Node paramNode1, Node paramNode2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 148 */     if (paramNode2 != null && paramNode1 != null && (paramBoolean1 || paramBoolean2)) {
/* 149 */       appendWhiteSpaceBetween(paramMarkdownWriter, paramNode1.getChars(), paramNode2.getChars(), paramBoolean1, paramBoolean2, paramBoolean3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void appendWhiteSpaceBetween(MarkdownWriter paramMarkdownWriter, BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 161 */     if (paramBasedSequence2 != null && paramBasedSequence1 != null && (paramBoolean1 || paramBoolean2) && 
/* 162 */       paramBasedSequence1.getEndOffset() <= paramBasedSequence2.getStartOffset() && 
/*     */       
/* 164 */       !(paramBasedSequence1 = paramBasedSequence1.baseSubSequence(paramBasedSequence1.getEndOffset(), paramBasedSequence2.getStartOffset())).isEmpty() && paramBasedSequence1.isBlank()) {
/* 165 */       if (!paramBoolean1) {
/* 166 */         if (paramBoolean3 && paramBasedSequence1.indexOfAny(CharPredicate.ANY_EOL) != -1) {
/* 167 */           paramMarkdownWriter.append('\n'); return;
/*     */         } 
/* 169 */         paramMarkdownWriter.append(' ');
/*     */         
/*     */         return;
/*     */       } 
/* 173 */       int i = paramMarkdownWriter.getOptions();
/* 174 */       paramMarkdownWriter.setOptions(i & (LineAppendable.F_TRIM_LEADING_WHITESPACE ^ 0xFFFFFFFF));
/* 175 */       paramMarkdownWriter.append((CharSequence)paramBasedSequence1);
/* 176 */       paramMarkdownWriter.setOptions(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderList(ListBlock paramListBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 186 */     if (paramNodeFormatterContext.isTransformingText()) {
/*     */       
/* 188 */       paramNodeFormatterContext.renderChildren((Node)paramListBlock); return;
/*     */     } 
/* 190 */     ArrayList<Node> arrayList = new ArrayList();
/* 191 */     Node node = paramListBlock.getFirstChild();
/* 192 */     while (node != null) {
/* 193 */       arrayList.add(node);
/* 194 */       node = node.getNext();
/*     */     } 
/* 196 */     renderList(paramListBlock, paramNodeFormatterContext, paramMarkdownWriter, arrayList);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderList(ListBlock paramListBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, List<Node> paramList) {
/*     */     FormatterOptions formatterOptions;
/* 202 */     if ((formatterOptions = paramNodeFormatterContext.getFormatterOptions()).listAddBlankLineBefore && !paramListBlock.isOrDescendantOfType(new Class[] { ListItem.class })) {
/* 203 */       paramMarkdownWriter.blankLine();
/*     */     }
/*     */     
/* 206 */     Document document = paramNodeFormatterContext.getDocument();
/* 207 */     ListSpacing listSpacing1 = (ListSpacing)LIST_ITEM_SPACING.get((DataHolder)document);
/* 208 */     int i = ((Integer)LIST_ITEM_NUMBER.get((DataHolder)document)).intValue();
/* 209 */     byte b = (paramListBlock instanceof OrderedList && (!formatterOptions.listRenumberItems || !formatterOptions.listResetFirstItemNumber)) ? ((OrderedList)paramListBlock).getStartNumber() : 1;
/* 210 */     Function function = (Function)LIST_ALIGN_NUMERIC.get((DataHolder)document);
/* 211 */     document.set(LIST_ITEM_NUMBER, Integer.valueOf(b));
/*     */     
/* 213 */     ListSpacing listSpacing2 = null;
/* 214 */     switch (formatterOptions.listSpacing) {
/*     */       case DASH:
/*     */       
/*     */ 
/*     */       
/*     */       case ASTERISK:
/*     */       
/*     */ 
/*     */       
/*     */       case PLUS:
/* 224 */         listSpacing2 = hasLooseItems(paramList) ? ListSpacing.LOOSE : ListSpacing.TIGHT;
/*     */         break;
/*     */       case null:
/* 227 */         listSpacing2 = hasLooseItems(paramList) ? ListSpacing.AS_IS : ListSpacing.TIGHT;
/*     */         break;
/*     */     } 
/*     */     
/* 231 */     document.remove((DataKeyBase)LIST_ALIGN_NUMERIC);
/*     */     
/* 233 */     if (!formatterOptions.listAlignNumeric.isNoChange() && paramListBlock instanceof OrderedList) {
/* 234 */       int j = Integer.MIN_VALUE;
/* 235 */       int k = Integer.MAX_VALUE;
/* 236 */       b = b;
/* 237 */       for (Node node : paramList) {
/* 238 */         if (!formatterOptions.listRemoveEmptyItems || (node.hasChildren() && node.getFirstChildAnyNot(new Class[] { BlankLine.class }) != null)) {
/* 239 */           int m = formatterOptions.listRenumberItems ? (Integer.toString(b).length() + 1) : ((ListItem)node).getOpeningMarker().length();
/* 240 */           j = Math.max(j, m);
/* 241 */           k = Math.min(k, m);
/* 242 */           b++;
/*     */         } 
/*     */       } 
/*     */       
/* 246 */       if (j != k) {
/* 247 */         int m = j;
/* 248 */         document.set(LIST_ALIGN_NUMERIC, formatterOptions.listAlignNumeric.isLeft() ? (paramCharSequence -> Pair.of(Integer.valueOf(0), Integer.valueOf(Math.min(4, Math.max(0, paramInt - paramCharSequence.length()))))) : (paramCharSequence -> Pair.of(Integer.valueOf(Math.min(4, Math.max(0, paramInt - paramCharSequence.length()))), Integer.valueOf(0))));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     document.set(LIST_ITEM_SPACING, (listSpacing2 == ListSpacing.LOOSE && (listSpacing1 == null || listSpacing1 == ListSpacing.LOOSE)) ? ListSpacing.LOOSE : listSpacing2);
/* 256 */     for (Node node : paramList) {
/* 257 */       if (listSpacing2 == ListSpacing.LOOSE && (listSpacing1 == null || listSpacing1 == ListSpacing.LOOSE)) {
/* 258 */         paramMarkdownWriter.blankLine();
/*     */       }
/* 260 */       paramNodeFormatterContext.render(node);
/*     */     } 
/* 262 */     document.set(LIST_ITEM_SPACING, listSpacing1);
/* 263 */     document.set(LIST_ITEM_NUMBER, Integer.valueOf(i));
/* 264 */     document.set(LIST_ALIGN_NUMERIC, function);
/*     */     
/* 266 */     if (!paramListBlock.isOrDescendantOfType(new Class[] { ListItem.class })) {
/* 267 */       paramMarkdownWriter.tailBlankLine();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderLooseParagraph(Paragraph paramParagraph, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 273 */     paramMarkdownWriter.blankLine();
/* 274 */     renderLooseItemParagraph(paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*     */   }
/*     */   
/*     */   public static boolean isFollowedByBlankLine(Node paramNode) {
/* 278 */     while (paramNode != null) {
/* 279 */       if (paramNode.getNextAnyNot(new Class[] { HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class }) instanceof BlankLine) return true; 
/* 280 */       if (paramNode.getNextAnyNot(new Class[] { BlankLine.class, HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class }) != null) return false; 
/* 281 */       paramNode = paramNode.getParent();
/*     */     } 
/* 283 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isNotLastItem(Node paramNode) {
/* 287 */     while (paramNode != null && !(paramNode instanceof Document)) {
/* 288 */       if (paramNode.getNextAnyNot(new Class[] { BlankLine.class, HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class }) != null) return true; 
/* 289 */       paramNode = paramNode.getParent();
/*     */     } 
/* 291 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isLastOfItem(Node paramNode) {
/* 295 */     return (paramNode != null && paramNode.getNextAnyNot(new Class[] { BlankLine.class, HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class }) == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderLooseItemParagraph(Paragraph paramParagraph, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 300 */     renderTextBlockParagraphLines((Node)paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*     */     Block block;
/* 302 */     if (block = paramParagraph.getParent() instanceof ListItem) {
/* 303 */       if ((paramNodeFormatterContext.getFormatterOptions()).blankLinesInAst) {
/*     */         
/* 305 */         boolean bool1, bool2 = !((ParagraphContainer)block).isParagraphEndWrappingDisabled(paramParagraph) ? true : false;
/*     */         
/* 307 */         ListItem listItem = (ListItem)block;
/* 308 */         switch ((paramNodeFormatterContext.getFormatterOptions()).listSpacing) {
/*     */ 
/*     */ 
/*     */           
/*     */           case PLUS:
/* 313 */             bool1 = (block.getParent() instanceof ListBlock && ((ListBlock)block.getParent()).isLoose() && hasLooseItems((Iterable<Node>)block.getParent().getChildren()) && ((isFollowedByBlankLine((Node)paramParagraph) && isNotLastItem((Node)block)) || !listItem.isOwnTight() || (listItem.isItemParagraph(paramParagraph) && block.getFirstChild() != null && block.getFirstChild().getNext() != null))) ? true : false;
/*     */             break;
/*     */ 
/*     */           
/*     */           case DASH:
/* 318 */             bool1 = true;
/*     */             break;
/*     */           
/*     */           case null:
/* 322 */             bool1 = (bool2 && (listItem.isItemParagraph(bool1) ? (isFollowedByBlankLine(bool1) && isNotLastItem(bool1)) : isNotLastItem(bool1))) ? true : false;
/*     */             break;
/*     */           
/*     */           case ANY:
/* 326 */             bool1 = (isFollowedByBlankLine(bool1) && isNotLastItem((Node)block)) ? true : false;
/*     */             break;
/*     */ 
/*     */           
/*     */           default:
/* 331 */             bool1 = false;
/*     */             break;
/*     */         } 
/*     */         
/* 335 */         if (bool1)
/* 336 */           paramMarkdownWriter.tailBlankLine(); 
/*     */         return;
/*     */       } 
/* 339 */       if ((paramNodeFormatterContext.getFormatterOptions()).listSpacing != ListSpacing.TIGHTEN || block.getNext() != null) {
/* 340 */         paramMarkdownWriter.tailBlankLine();
/*     */         return;
/*     */       } 
/*     */     } else {
/* 344 */       paramMarkdownWriter.tailBlankLine();
/*     */     } 
/*     */   }
/*     */   
/*     */   static boolean hasLooseItems(Iterable<Node> paramIterable) {
/* 349 */     for (Iterator<Node> iterator = paramIterable.iterator(); iterator.hasNext();) {
/* 350 */       if (node = iterator.next() instanceof ListItem && 
/* 351 */         !((ListItem)node).isOwnTight() && node.getNext() != null) {
/* 352 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 356 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderListItem(ListItem paramListItem, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, ListOptions paramListOptions, BasedSequence paramBasedSequence, boolean paramBoolean) {
/* 367 */     FormatterOptions formatterOptions = paramNodeFormatterContext.getFormatterOptions();
/* 368 */     boolean bool = ((Boolean)FIRST_LIST_ITEM_CHILD.get((DataHolder)paramNodeFormatterContext.getDocument())).booleanValue();
/*     */     
/* 370 */     if (paramNodeFormatterContext.isTransformingText()) {
/*     */       String str1, str2;
/*     */       
/*     */       BasedSequence basedSequence;
/*     */       
/* 375 */       String str3 = getActualAdditionalPrefix(basedSequence = paramListItem.getOpeningMarker(), paramMarkdownWriter);
/*     */       
/* 377 */       if (paramListItem.getFirstChild() == null) {
/*     */         
/* 379 */         int i = basedSequence.length() + (paramListOptions.isItemContentAfterSuffix() ? paramBasedSequence.length() : 0) + 1;
/* 380 */         String str = RepeatedSequence.repeatOf(' ', i).toString();
/* 381 */         str2 = str3 + str;
/*     */         
/* 383 */         str1 = " ";
/*     */       } else {
/* 385 */         BasedSequence basedSequence1 = paramListItem.getFirstChild().getChars();
/* 386 */         String str = getAdditionalPrefix(paramBasedSequence.isEmpty() ? basedSequence : paramBasedSequence, basedSequence1);
/* 387 */         str2 = str3 + str;
/*     */         
/* 389 */         str1 = getAdditionalPrefix(paramBasedSequence.isEmpty() ? basedSequence.getEmptySuffix() : paramBasedSequence.getEmptySuffix(), basedSequence1);
/*     */       } 
/*     */       
/* 392 */       ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(str2, true);
/* 393 */       ((MarkdownWriter)paramMarkdownWriter.append(str3)).append((CharSequence)basedSequence);
/*     */       
/* 395 */       if (!paramBasedSequence.isEmpty()) {
/* 396 */         String str = getAdditionalPrefix(basedSequence.getEmptySuffix(), paramBasedSequence);
/* 397 */         ((MarkdownWriter)paramMarkdownWriter.append(str)).append((CharSequence)paramBasedSequence);
/*     */       } 
/*     */       
/* 400 */       paramMarkdownWriter.append(str1);
/*     */ 
/*     */       
/* 403 */       if (!(paramListItem.getFirstChild() instanceof Paragraph)) {
/* 404 */         if (paramListItem.getFirstChild() == null) {
/* 405 */           if (!bool) {
/* 406 */             paramMarkdownWriter.append("\n");
/*     */           }
/*     */         } else {
/*     */           int i;
/* 410 */           if ((i = paramListItem.endOfLine(basedSequence.getEndOffset())) < paramListItem.getFirstChild().getStartOffset())
/*     */           {
/* 412 */             paramMarkdownWriter.append("\n");
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 417 */       paramNodeFormatterContext.renderChildren((Node)paramListItem);
/* 418 */       paramMarkdownWriter.popPrefix();
/*     */     } else {
/* 420 */       String str; if (formatterOptions.listRemoveEmptyItems && (!paramListItem.hasChildren() || paramListItem.getFirstChildAnyNot(new Class[] { BlankLine.class }) == null)) {
/*     */         return;
/*     */       }
/*     */       
/* 424 */       BasedSequence basedSequence2 = paramListItem.getOpeningMarker();
/* 425 */       if (paramListItem.isOrderedItem()) {
/* 426 */         char c = basedSequence2.charAt(basedSequence2.length() - 1);
/* 427 */         CharSequence charSequence = basedSequence2.subSequence(0, basedSequence2.length() - 1);
/*     */         
/* 429 */         switch (formatterOptions.listNumberedMarker) {
/*     */           case ANY:
/*     */             break;
/*     */           case DASH:
/* 433 */             c = '.';
/*     */             break;
/*     */           case ASTERISK:
/* 436 */             c = ')';
/*     */             break;
/*     */           default:
/* 439 */             throw new IllegalStateException("Missing case for ListNumberedMarker " + formatterOptions.listNumberedMarker.name());
/*     */         } 
/*     */         
/* 442 */         Document document = paramNodeFormatterContext.getDocument();
/*     */         
/* 444 */         if (formatterOptions.listRenumberItems) {
/* 445 */           Integer integer1 = (Integer)LIST_ITEM_NUMBER.get((DataHolder)document);
/* 446 */           Integer integer2 = integer1; integer1 = Integer.valueOf(integer1.intValue() + 1); str = String.format(Locale.US, "%d%c", new Object[] { integer2, Character.valueOf(c) });
/* 447 */           document.set(LIST_ITEM_NUMBER, integer1);
/*     */         } else {
/* 449 */           str = String.format("%s%c", new Object[] { charSequence, Character.valueOf(c) });
/*     */         } 
/*     */         
/*     */         Pair pair;
/* 453 */         if (((Integer)(pair = ((Function<String, Pair>)LIST_ALIGN_NUMERIC.get((DataHolder)document)).apply(str)).getFirst()).intValue() > 0) str = RepeatedSequence.ofSpaces(((Integer)pair.getFirst()).intValue()).toString() + str.toString(); 
/* 454 */         if (((Integer)pair.getSecond()).intValue() > 0) str = str.toString() + RepeatedSequence.ofSpaces(((Integer)pair.getSecond()).intValue()).toString();
/*     */       
/* 456 */       } else if (paramListItem.canChangeMarker()) {
/* 457 */         switch (formatterOptions.listBulletMarker) {
/*     */           case ANY:
/*     */             break;
/*     */           case DASH:
/* 461 */             str = "-";
/*     */             break;
/*     */           case ASTERISK:
/* 464 */             str = "*";
/*     */             break;
/*     */           case PLUS:
/* 467 */             str = "+";
/*     */             break;
/*     */           default:
/* 470 */             throw new IllegalStateException("Missing case for ListBulletMarker " + formatterOptions.listBulletMarker.name());
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/* 477 */       boolean bool1 = (paramListOptions.isItemContentAfterSuffix() || formatterOptions.listsItemContentAfterSuffix) ? paramBasedSequence.length() : false;
/* 478 */       int i = str.length() + (paramListOptions.isItemContentAfterSuffix() ? paramBasedSequence.length() : 0) + 1;
/* 479 */       CharSequence charSequence1 = formatterOptions.itemContentIndent ? RepeatedSequence.repeatOf(' ', bool1) : "";
/*     */ 
/*     */ 
/*     */       
/* 483 */       CharSequence charSequence2 = formatterOptions.itemContentIndent ? RepeatedSequence.repeatOf(' ', i) : RepeatedSequence.repeatOf(" ", paramListOptions.getItemIndent()).toString();
/*     */ 
/*     */       
/* 486 */       BasedSequence basedSequence3, basedSequence1 = ((SequenceBuilder)((SequenceBuilder)((SequenceBuilder)(basedSequence3 = paramListItem.getOpeningMarker()).getBuilder().append((CharSequence)basedSequence3.getEmptyPrefix())).append(str)).append((CharSequence)basedSequence3.getEmptySuffix())).toSequence();
/*     */       
/* 488 */       ((MarkdownWriter)paramMarkdownWriter.pushOptions())
/* 489 */         .preserveSpaces()
/* 490 */         .append((CharSequence)basedSequence1)
/* 491 */         .append(' ')
/* 492 */         .append((CharSequence)paramBasedSequence)
/* 493 */         .popOptions();
/*     */       
/* 495 */       ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(charSequence2, true);
/*     */       
/*     */       Node node;
/* 498 */       if ((node = paramListItem.getFirstChild()) != null && paramListItem.getFirstChildAnyNot(new Class[] { BlankLine.class }) != null) {
/* 499 */         ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(charSequence1, true);
/*     */         
/* 501 */         FIRST_LIST_ITEM_CHILD.set((MutableDataHolder)paramNodeFormatterContext.getDocument(), Boolean.TRUE);
/* 502 */         paramNodeFormatterContext.render(node);
/* 503 */         FIRST_LIST_ITEM_CHILD.set((MutableDataHolder)paramNodeFormatterContext.getDocument(), Boolean.FALSE);
/* 504 */         paramMarkdownWriter.popPrefix();
/*     */ 
/*     */ 
/*     */         
/* 508 */         while ((node = node.getNext()) != null) {
/* 509 */           paramNodeFormatterContext.render(node);
/*     */         }
/*     */         
/* 512 */         if (paramBoolean && ((paramListItem.isLoose() && (paramNodeFormatterContext.getFormatterOptions()).listSpacing == ListSpacing.LOOSEN) || (paramNodeFormatterContext.getFormatterOptions()).listSpacing == ListSpacing.LOOSE)) {
/* 513 */           paramMarkdownWriter.tailBlankLine();
/*     */         
/*     */         }
/*     */       }
/* 517 */       else if (paramListItem.isLoose()) {
/* 518 */         paramMarkdownWriter.tailBlankLine();
/*     */       }
/* 520 */       else if (!bool) {
/* 521 */         paramMarkdownWriter.line();
/*     */       } 
/*     */ 
/*     */       
/* 525 */       paramMarkdownWriter.popPrefix();
/*     */     } 
/*     */     
/* 528 */     FIRST_LIST_ITEM_CHILD.set((MutableDataHolder)paramNodeFormatterContext.getDocument(), Boolean.valueOf(bool));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderTextBlockParagraphLines(Node paramNode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokeinterface isTransformingText : ()Z
/*     */     //   6: ifeq -> 27
/*     */     //   9: aload_1
/*     */     //   10: aload_0
/*     */     //   11: <illegal opcode> render : (Lcom/vladsch/flexmark/util/ast/Node;)Lcom/vladsch/flexmark/formatter/TranslatingSpanRender;
/*     */     //   16: invokeinterface translatingSpan : (Lcom/vladsch/flexmark/formatter/TranslatingSpanRender;)V
/*     */     //   21: aload_2
/*     */     //   22: invokevirtual line : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*     */     //   25: pop
/*     */     //   26: return
/*     */     //   27: aload_1
/*     */     //   28: invokeinterface getFormatterOptions : ()Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*     */     //   33: dup
/*     */     //   34: astore_3
/*     */     //   35: getfield rightMargin : I
/*     */     //   38: ifle -> 691
/*     */     //   41: aload_1
/*     */     //   42: invokeinterface getOptions : ()Lcom/vladsch/flexmark/util/data/DataHolder;
/*     */     //   47: invokeinterface toMutable : ()Lcom/vladsch/flexmark/util/data/MutableDataHolder;
/*     */     //   52: getstatic com/vladsch/flexmark/formatter/Formatter.KEEP_SOFT_LINE_BREAKS : Lcom/vladsch/flexmark/util/data/DataKey;
/*     */     //   55: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*     */     //   58: invokeinterface set : (Lcom/vladsch/flexmark/util/data/DataKey;Ljava/lang/Object;)Lcom/vladsch/flexmark/util/data/MutableDataHolder;
/*     */     //   63: getstatic com/vladsch/flexmark/formatter/Formatter.KEEP_HARD_LINE_BREAKS : Lcom/vladsch/flexmark/util/data/DataKey;
/*     */     //   66: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*     */     //   69: invokeinterface set : (Lcom/vladsch/flexmark/util/data/DataKey;Ljava/lang/Object;)Lcom/vladsch/flexmark/util/data/MutableDataHolder;
/*     */     //   74: astore #4
/*     */     //   76: aload_1
/*     */     //   77: invokeinterface getDocument : ()Lcom/vladsch/flexmark/util/ast/Document;
/*     */     //   82: invokevirtual getChars : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   85: invokeinterface getBuilder : ()Lcom/vladsch/flexmark/util/sequence/builder/SequenceBuilder;
/*     */     //   90: astore #5
/*     */     //   92: aload_1
/*     */     //   93: aload #4
/*     */     //   95: aload #5
/*     */     //   97: invokevirtual getBuilder : ()Lcom/vladsch/flexmark/util/sequence/builder/SequenceBuilder;
/*     */     //   100: invokeinterface getSubContext : (Lcom/vladsch/flexmark/util/data/DataHolder;Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;)Lcom/vladsch/flexmark/util/format/NodeContext;
/*     */     //   105: checkcast com/vladsch/flexmark/formatter/NodeFormatterContext
/*     */     //   108: dup
/*     */     //   109: astore #4
/*     */     //   111: invokeinterface getMarkdown : ()Lcom/vladsch/flexmark/formatter/MarkdownWriter;
/*     */     //   116: dup
/*     */     //   117: astore #6
/*     */     //   119: getstatic com/vladsch/flexmark/util/sequence/LineAppendable.F_TRIM_TRAILING_WHITESPACE : I
/*     */     //   122: invokevirtual removeOptions : (I)Lcom/vladsch/flexmark/util/sequence/LineAppendable;
/*     */     //   125: pop
/*     */     //   126: aload #4
/*     */     //   128: aload_0
/*     */     //   129: invokeinterface renderChildren : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   134: aload_0
/*     */     //   135: invokevirtual getChars : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   138: invokeinterface trimEOL : ()Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   143: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   146: astore #4
/*     */     //   148: aload_0
/*     */     //   149: invokevirtual getChars : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   152: invokeinterface trimmedEnd : ()Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   157: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   160: dup
/*     */     //   161: astore_0
/*     */     //   162: invokeinterface isNotEmpty : ()Z
/*     */     //   167: ifeq -> 185
/*     */     //   170: aload #6
/*     */     //   172: invokevirtual endsWithEOL : ()Z
/*     */     //   175: ifne -> 185
/*     */     //   178: aload #6
/*     */     //   180: aload_0
/*     */     //   181: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*     */     //   184: pop
/*     */     //   185: aload #6
/*     */     //   187: invokevirtual line : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*     */     //   190: pop
/*     */     //   191: aload #6
/*     */     //   193: aload #5
/*     */     //   195: iconst_0
/*     */     //   196: iconst_m1
/*     */     //   197: invokevirtual appendToSilently : (Ljava/lang/Appendable;II)Ljava/lang/Appendable;
/*     */     //   200: pop
/*     */     //   201: aload #5
/*     */     //   203: invokevirtual toSequence : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   206: astore_0
/*     */     //   207: aload #5
/*     */     //   209: aload_1
/*     */     //   210: invokeinterface getTrackedSequence : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   215: invokevirtual toSequence : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   218: astore #5
/*     */     //   220: aload_0
/*     */     //   221: aload #5
/*     */     //   223: if_acmpeq -> 230
/*     */     //   226: iconst_1
/*     */     //   227: goto -> 231
/*     */     //   230: iconst_0
/*     */     //   231: istore #6
/*     */     //   233: aload_1
/*     */     //   234: invokeinterface getTrackedOffsets : ()Lcom/vladsch/flexmark/util/format/TrackedOffsetList;
/*     */     //   239: astore #7
/*     */     //   241: iload #6
/*     */     //   243: ifeq -> 300
/*     */     //   246: aload #5
/*     */     //   248: invokeinterface trimEnd : ()Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   253: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   256: dup
/*     */     //   257: astore #8
/*     */     //   259: invokeinterface getStartOffset : ()I
/*     */     //   264: istore #6
/*     */     //   266: aload #4
/*     */     //   268: invokeinterface countTrailingWhitespace : ()I
/*     */     //   273: aload #8
/*     */     //   275: invokeinterface countTrailingWhitespace : ()I
/*     */     //   280: isub
/*     */     //   281: istore #4
/*     */     //   283: aload #8
/*     */     //   285: invokeinterface getEndOffset : ()I
/*     */     //   290: iload #4
/*     */     //   292: iadd
/*     */     //   293: iconst_1
/*     */     //   294: iadd
/*     */     //   295: istore #4
/*     */     //   297: goto -> 318
/*     */     //   300: aload #4
/*     */     //   302: invokeinterface getStartOffset : ()I
/*     */     //   307: istore #6
/*     */     //   309: aload #4
/*     */     //   311: invokeinterface getEndOffset : ()I
/*     */     //   316: istore #4
/*     */     //   318: aload #7
/*     */     //   320: iload #6
/*     */     //   322: iload #4
/*     */     //   324: invokevirtual getTrackedOffsets : (II)Lcom/vladsch/flexmark/util/format/TrackedOffsetList;
/*     */     //   327: astore #8
/*     */     //   329: new com/vladsch/flexmark/util/format/MarkdownParagraph
/*     */     //   332: dup
/*     */     //   333: aload_0
/*     */     //   334: aload #5
/*     */     //   336: aload_3
/*     */     //   337: getfield charWidthProvider : Lcom/vladsch/flexmark/util/format/CharWidthProvider;
/*     */     //   340: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/format/CharWidthProvider;)V
/*     */     //   343: dup
/*     */     //   344: astore #4
/*     */     //   346: aload_1
/*     */     //   347: invokeinterface getOptions : ()Lcom/vladsch/flexmark/util/data/DataHolder;
/*     */     //   352: invokevirtual setOptions : (Lcom/vladsch/flexmark/util/data/DataHolder;)V
/*     */     //   355: aload #4
/*     */     //   357: aload_3
/*     */     //   358: getfield rightMargin : I
/*     */     //   361: aload_2
/*     */     //   362: invokevirtual getPrefix : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   365: invokeinterface length : ()I
/*     */     //   370: isub
/*     */     //   371: invokevirtual setWidth : (I)V
/*     */     //   374: aload #4
/*     */     //   376: iconst_0
/*     */     //   377: invokevirtual setKeepSoftBreaks : (Z)V
/*     */     //   380: aload #4
/*     */     //   382: aload_3
/*     */     //   383: getfield keepHardLineBreaks : Z
/*     */     //   386: invokevirtual setKeepHardBreaks : (Z)V
/*     */     //   389: aload #4
/*     */     //   391: aload_1
/*     */     //   392: invokeinterface isRestoreTrackedSpaces : ()Z
/*     */     //   397: invokevirtual setRestoreTrackedSpaces : (Z)V
/*     */     //   400: aload #4
/*     */     //   402: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.NULL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   405: invokevirtual setFirstIndent : (Ljava/lang/CharSequence;)V
/*     */     //   408: aload #4
/*     */     //   410: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.NULL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   413: invokevirtual setIndent : (Ljava/lang/CharSequence;)V
/*     */     //   416: aload #4
/*     */     //   418: aload_2
/*     */     //   419: invokevirtual column : ()I
/*     */     //   422: ineg
/*     */     //   423: aload_2
/*     */     //   424: invokevirtual getAfterEolPrefixDelta : ()I
/*     */     //   427: iadd
/*     */     //   428: invokevirtual setFirstWidthOffset : (I)V
/*     */     //   431: aload_3
/*     */     //   432: getfield applySpecialLeadInHandlers : Z
/*     */     //   435: ifeq -> 458
/*     */     //   438: aload #4
/*     */     //   440: getstatic com/vladsch/flexmark/parser/Parser.SPECIAL_LEAD_IN_HANDLERS : Lcom/vladsch/flexmark/util/data/DataKey;
/*     */     //   443: aload_1
/*     */     //   444: invokeinterface getDocument : ()Lcom/vladsch/flexmark/util/ast/Document;
/*     */     //   449: invokevirtual get : (Lcom/vladsch/flexmark/util/data/DataHolder;)Ljava/lang/Object;
/*     */     //   452: checkcast java/util/List
/*     */     //   455: invokevirtual setLeadInHandlers : (Ljava/util/List;)V
/*     */     //   458: aload #8
/*     */     //   460: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   463: astore_0
/*     */     //   464: aload_0
/*     */     //   465: invokeinterface hasNext : ()Z
/*     */     //   470: ifeq -> 492
/*     */     //   473: aload_0
/*     */     //   474: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   479: checkcast com/vladsch/flexmark/util/format/TrackedOffset
/*     */     //   482: astore_1
/*     */     //   483: aload #4
/*     */     //   485: aload_1
/*     */     //   486: invokevirtual addTrackedOffset : (Lcom/vladsch/flexmark/util/format/TrackedOffset;)V
/*     */     //   489: goto -> 464
/*     */     //   492: aload #4
/*     */     //   494: invokevirtual wrapText : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   497: getstatic com/vladsch/flexmark/util/sequence/mappers/SpaceMapper.fromNonBreakSpace : Lcom/vladsch/flexmark/util/sequence/mappers/CharMapper;
/*     */     //   500: invokeinterface toMapped : (Lcom/vladsch/flexmark/util/sequence/mappers/CharMapper;)Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   505: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   508: astore_0
/*     */     //   509: aload_2
/*     */     //   510: invokevirtual getLineCount : ()I
/*     */     //   513: istore_1
/*     */     //   514: aload_2
/*     */     //   515: invokevirtual column : ()I
/*     */     //   518: istore_3
/*     */     //   519: aload_2
/*     */     //   520: invokevirtual pushOptions : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*     */     //   523: checkcast com/vladsch/flexmark/formatter/MarkdownWriter
/*     */     //   526: invokevirtual preserveSpaces : ()Lcom/vladsch/flexmark/util/sequence/LineAppendable;
/*     */     //   529: aload_0
/*     */     //   530: invokeinterface append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/sequence/LineAppendable;
/*     */     //   535: invokeinterface line : ()Lcom/vladsch/flexmark/util/sequence/LineAppendable;
/*     */     //   540: invokeinterface popOptions : ()Lcom/vladsch/flexmark/util/sequence/LineAppendable;
/*     */     //   545: pop
/*     */     //   546: aload #8
/*     */     //   548: invokevirtual isEmpty : ()Z
/*     */     //   551: ifne -> 690
/*     */     //   554: aload_2
/*     */     //   555: iload_1
/*     */     //   556: invokevirtual getLineInfo : (I)Lcom/vladsch/flexmark/util/sequence/LineInfo;
/*     */     //   559: astore #4
/*     */     //   561: aload #8
/*     */     //   563: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   566: astore #5
/*     */     //   568: aload #5
/*     */     //   570: invokeinterface hasNext : ()Z
/*     */     //   575: ifeq -> 690
/*     */     //   578: aload #5
/*     */     //   580: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   585: checkcast com/vladsch/flexmark/util/format/TrackedOffset
/*     */     //   588: dup
/*     */     //   589: astore #6
/*     */     //   591: invokevirtual isResolved : ()Z
/*     */     //   594: ifeq -> 687
/*     */     //   597: aload #6
/*     */     //   599: invokevirtual getIndex : ()I
/*     */     //   602: istore #7
/*     */     //   604: aload_0
/*     */     //   605: iload #7
/*     */     //   607: invokeinterface lineColumnAtIndex : (I)Lcom/vladsch/flexmark/util/misc/Pair;
/*     */     //   612: dup
/*     */     //   613: astore #8
/*     */     //   615: invokevirtual getFirst : ()Ljava/lang/Object;
/*     */     //   618: checkcast java/lang/Integer
/*     */     //   621: invokevirtual intValue : ()I
/*     */     //   624: istore #8
/*     */     //   626: aload_2
/*     */     //   627: iload_1
/*     */     //   628: iload #8
/*     */     //   630: iadd
/*     */     //   631: invokevirtual getLineInfo : (I)Lcom/vladsch/flexmark/util/sequence/LineInfo;
/*     */     //   634: astore #8
/*     */     //   636: aload #4
/*     */     //   638: getfield sumLength : I
/*     */     //   641: aload #4
/*     */     //   643: getfield length : I
/*     */     //   646: isub
/*     */     //   647: istore #9
/*     */     //   649: aload #8
/*     */     //   651: getfield sumPrefixLength : I
/*     */     //   654: aload #4
/*     */     //   656: getfield sumPrefixLength : I
/*     */     //   659: isub
/*     */     //   660: aload #4
/*     */     //   662: getfield prefixLength : I
/*     */     //   665: iadd
/*     */     //   666: istore #8
/*     */     //   668: iload_3
/*     */     //   669: iload #9
/*     */     //   671: iadd
/*     */     //   672: iload #8
/*     */     //   674: iadd
/*     */     //   675: istore #8
/*     */     //   677: aload #6
/*     */     //   679: iload #7
/*     */     //   681: iload #8
/*     */     //   683: iadd
/*     */     //   684: invokevirtual setIndex : (I)V
/*     */     //   687: goto -> 568
/*     */     //   690: return
/*     */     //   691: aload_1
/*     */     //   692: aload_0
/*     */     //   693: invokeinterface renderChildren : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   698: aload_2
/*     */     //   699: invokevirtual line : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*     */     //   702: pop
/*     */     //   703: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #533	-> 0
/*     */     //   #534	-> 9
/*     */     //   #535	-> 21
/*     */     //   #537	-> 27
/*     */     //   #538	-> 34
/*     */     //   #539	-> 41
/*     */     //   #540	-> 76
/*     */     //   #541	-> 92
/*     */     //   #542	-> 109
/*     */     //   #543	-> 117
/*     */     //   #544	-> 126
/*     */     //   #546	-> 134
/*     */     //   #547	-> 148
/*     */     //   #548	-> 161
/*     */     //   #550	-> 178
/*     */     //   #552	-> 185
/*     */     //   #553	-> 191
/*     */     //   #555	-> 201
/*     */     //   #556	-> 207
/*     */     //   #557	-> 220
/*     */     //   #561	-> 233
/*     */     //   #562	-> 241
/*     */     //   #564	-> 246
/*     */     //   #565	-> 257
/*     */     //   #566	-> 266
/*     */     //   #567	-> 283
/*     */     //   #568	-> 297
/*     */     //   #569	-> 300
/*     */     //   #570	-> 309
/*     */     //   #573	-> 318
/*     */     //   #575	-> 329
/*     */     //   #576	-> 344
/*     */     //   #578	-> 355
/*     */     //   #579	-> 374
/*     */     //   #580	-> 380
/*     */     //   #581	-> 389
/*     */     //   #582	-> 400
/*     */     //   #583	-> 408
/*     */     //   #586	-> 416
/*     */     //   #588	-> 431
/*     */     //   #589	-> 438
/*     */     //   #592	-> 458
/*     */     //   #593	-> 483
/*     */     //   #594	-> 489
/*     */     //   #596	-> 492
/*     */     //   #597	-> 509
/*     */     //   #598	-> 514
/*     */     //   #599	-> 519
/*     */     //   #601	-> 546
/*     */     //   #602	-> 554
/*     */     //   #604	-> 561
/*     */     //   #605	-> 589
/*     */     //   #606	-> 597
/*     */     //   #607	-> 604
/*     */     //   #608	-> 613
/*     */     //   #609	-> 626
/*     */     //   #611	-> 636
/*     */     //   #612	-> 649
/*     */     //   #613	-> 668
/*     */     //   #614	-> 677
/*     */     //   #622	-> 687
/*     */     //   #624	-> 690
/*     */     //   #625	-> 691
/*     */     //   #626	-> 698
/*     */     //   #629	-> 703
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderBlockQuoteLike(BlockQuoteLike paramBlockQuoteLike, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 632 */     FormatterOptions formatterOptions = paramNodeFormatterContext.getFormatterOptions();
/*     */     
/* 634 */     String str = getBlockLikePrefix(paramBlockQuoteLike, paramNodeFormatterContext, formatterOptions.blockQuoteMarkers, paramMarkdownWriter.getPrefix());
/*     */     
/* 636 */     paramMarkdownWriter.pushPrefix();
/*     */     
/* 638 */     if (!((Boolean)FIRST_LIST_ITEM_CHILD.get((DataHolder)paramNodeFormatterContext.getDocument())).booleanValue()) {
/* 639 */       if (formatterOptions.blockQuoteBlankLines) {
/* 640 */         paramMarkdownWriter.blankLine();
/*     */       }
/* 642 */       paramMarkdownWriter.setPrefix(str, false);
/*     */     } else {
/* 644 */       String str1 = getBlockLikePrefix(paramBlockQuoteLike, paramNodeFormatterContext, formatterOptions.blockQuoteMarkers, BasedSequence.NULL);
/* 645 */       ((MarkdownWriter)paramMarkdownWriter.pushOptions()).removeOptions(LineAppendable.F_WHITESPACE_REMOVAL).append(str1).popOptions();
/* 646 */       paramMarkdownWriter.setPrefix(str, true);
/*     */     } 
/*     */     
/* 649 */     int i = paramMarkdownWriter.getLineCountWithPending();
/* 650 */     paramNodeFormatterContext.renderChildren((Node)paramBlockQuoteLike);
/* 651 */     paramMarkdownWriter.popPrefix();
/*     */     
/* 653 */     if (formatterOptions.blockQuoteBlankLines && i < paramMarkdownWriter.getLineCountWithPending() && !((Boolean)FIRST_LIST_ITEM_CHILD.get((DataHolder)paramNodeFormatterContext.getDocument())).booleanValue())
/* 654 */       paramMarkdownWriter.tailBlankLine(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\FormatterUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */