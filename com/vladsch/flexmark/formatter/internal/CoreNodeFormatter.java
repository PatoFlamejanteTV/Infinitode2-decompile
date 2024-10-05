/*      */ package com.vladsch.flexmark.formatter.internal;
/*      */ import com.vladsch.flexmark.ast.Code;
/*      */ import com.vladsch.flexmark.ast.DelimitedLinkNode;
/*      */ import com.vladsch.flexmark.ast.Emphasis;
/*      */ import com.vladsch.flexmark.ast.FencedCodeBlock;
/*      */ import com.vladsch.flexmark.ast.Heading;
/*      */ import com.vladsch.flexmark.ast.HtmlBlock;
/*      */ import com.vladsch.flexmark.ast.HtmlBlockBase;
/*      */ import com.vladsch.flexmark.ast.HtmlCommentBlock;
/*      */ import com.vladsch.flexmark.ast.HtmlEntity;
/*      */ import com.vladsch.flexmark.ast.HtmlInline;
/*      */ import com.vladsch.flexmark.ast.Image;
/*      */ import com.vladsch.flexmark.ast.ImageRef;
/*      */ import com.vladsch.flexmark.ast.IndentedCodeBlock;
/*      */ import com.vladsch.flexmark.ast.Link;
/*      */ import com.vladsch.flexmark.ast.LinkRef;
/*      */ import com.vladsch.flexmark.ast.Paragraph;
/*      */ import com.vladsch.flexmark.ast.Reference;
/*      */ import com.vladsch.flexmark.ast.StrongEmphasis;
/*      */ import com.vladsch.flexmark.formatter.FormatterUtils;
/*      */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*      */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*      */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*      */ import com.vladsch.flexmark.formatter.RenderPurpose;
/*      */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*      */ import com.vladsch.flexmark.util.ast.BlankLine;
/*      */ import com.vladsch.flexmark.util.ast.Document;
/*      */ import com.vladsch.flexmark.util.ast.Node;
/*      */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*      */ import com.vladsch.flexmark.util.data.DataHolder;
/*      */ import com.vladsch.flexmark.util.data.DataKey;
/*      */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*      */ import com.vladsch.flexmark.util.format.options.CodeFenceMarker;
/*      */ import com.vladsch.flexmark.util.format.options.EqualizeTrailingMarker;
/*      */ import com.vladsch.flexmark.util.format.options.ListSpacing;
/*      */ import com.vladsch.flexmark.util.misc.Utils;
/*      */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*      */ import com.vladsch.flexmark.util.sequence.mappers.SpaceMapper;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class CoreNodeFormatter extends NodeRepositoryFormatter<ReferenceRepository, Reference, RefNode> {
/*      */   @Deprecated
/*   47 */   public static final DataKey<Map<String, String>> UNIQUIFICATION_MAP = Formatter.UNIQUIFICATION_MAP;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*   53 */   public static final DataKey<Map<String, String>> ATTRIBUTE_UNIQUIFICATION_ID_MAP = Formatter.ATTRIBUTE_UNIQUIFICATION_ID_MAP; final FormatterOptions formatterOptions; private final ListOptions listOptions; private final String myHtmlBlockPrefix; private final String myHtmlInlinePrefix; private final String myTranslationAutolinkPrefix; private int blankLines;
/*      */   MutableDataHolder myTranslationStore;
/*      */   private Map<String, String> attributeUniquificationIdMap;
/*      */   static final TranslationPlaceholderGenerator htmlEntityPlaceholderGenerator;
/*      */   
/*      */   public static class Factory implements NodeFormatterFactory { public NodeFormatter create(DataHolder param1DataHolder) {
/*   59 */       return (NodeFormatter)new CoreNodeFormatter(param1DataHolder);
/*      */     } }
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
/*      */   public CoreNodeFormatter(DataHolder paramDataHolder) {
/*   73 */     super(paramDataHolder, null, Formatter.UNIQUIFICATION_MAP);
/*   74 */     this.formatterOptions = new FormatterOptions(paramDataHolder);
/*   75 */     this.listOptions = ListOptions.get(paramDataHolder);
/*   76 */     this.blankLines = 0;
/*   77 */     this.myHtmlBlockPrefix = "<" + this.formatterOptions.translationHtmlBlockPrefix;
/*   78 */     this.myHtmlInlinePrefix = this.formatterOptions.translationHtmlInlinePrefix;
/*   79 */     this.myTranslationAutolinkPrefix = this.formatterOptions.translationAutolinkPrefix;
/*      */   }
/*      */ 
/*      */   
/*      */   public char getBlockQuoteLikePrefixChar() {
/*   84 */     return '>';
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*   90 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(Node.class, this::render), new NodeFormattingHandler(AutoLink.class, this::render), new NodeFormattingHandler(BlankLine.class, this::render), new NodeFormattingHandler(BlockQuote.class, this::render), new NodeFormattingHandler(Code.class, this::render), new NodeFormattingHandler(Document.class, this::render), new NodeFormattingHandler(Emphasis.class, this::render), new NodeFormattingHandler(FencedCodeBlock.class, this::render), new NodeFormattingHandler(HardLineBreak.class, this::render), new NodeFormattingHandler(Heading.class, this::render), new NodeFormattingHandler(HtmlBlock.class, this::render), new NodeFormattingHandler(HtmlCommentBlock.class, this::render), new NodeFormattingHandler(HtmlInnerBlock.class, this::render), new NodeFormattingHandler(HtmlInnerBlockComment.class, this::render), new NodeFormattingHandler(HtmlEntity.class, this::render), new NodeFormattingHandler(HtmlInline.class, this::render), new NodeFormattingHandler(HtmlInlineComment.class, this::render), new NodeFormattingHandler(Image.class, this::render), new NodeFormattingHandler(ImageRef.class, this::render), new NodeFormattingHandler(IndentedCodeBlock.class, this::render), new NodeFormattingHandler(Link.class, this::render), new NodeFormattingHandler(LinkRef.class, this::render), new NodeFormattingHandler(BulletList.class, this::render), new NodeFormattingHandler(OrderedList.class, this::render), new NodeFormattingHandler(BulletListItem.class, this::render), new NodeFormattingHandler(OrderedListItem.class, this::render), new NodeFormattingHandler(MailLink.class, this::render), new NodeFormattingHandler(Paragraph.class, this::render), new NodeFormattingHandler(Reference.class, this::render), new NodeFormattingHandler(SoftLineBreak.class, this::render), new NodeFormattingHandler(StrongEmphasis.class, this::render), new NodeFormattingHandler(Text.class, this::render), new NodeFormattingHandler(TextBase.class, this::render), new NodeFormattingHandler(ThematicBreak.class, this::render) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<Class<?>> getNodeClasses() {
/*  134 */     if (this.formatterOptions.referencePlacement.isNoChange() || !this.formatterOptions.referenceSort.isUnused()) return null;
/*      */     
/*  136 */     return new HashSet<>(Arrays.asList(new Class[] { RefNode.class }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ReferenceRepository getRepository(DataHolder paramDataHolder) {
/*  143 */     return (ReferenceRepository)Parser.REFERENCES.get(paramDataHolder);
/*      */   }
/*      */ 
/*      */   
/*      */   public ElementPlacement getReferencePlacement() {
/*  148 */     return this.formatterOptions.referencePlacement;
/*      */   }
/*      */ 
/*      */   
/*      */   public ElementPlacementSort getReferenceSort() {
/*  153 */     return this.formatterOptions.referenceSort;
/*      */   }
/*      */   
/*      */   void appendReference(CharSequence paramCharSequence, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  157 */     if (paramNodeFormatterContext.isTransformingText() && paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED && paramNodeFormatterContext.getMergeContext() != null) {
/*      */       
/*  159 */       paramCharSequence = String.valueOf(paramNodeFormatterContext.transformTranslating(null, paramCharSequence, null, null));
/*  160 */       paramCharSequence = (String)this.referenceUniqificationMap.getOrDefault(paramCharSequence, paramCharSequence);
/*  161 */       paramMarkdownWriter.append(paramCharSequence); return;
/*      */     } 
/*  163 */     paramMarkdownWriter.appendTranslating(paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderReferenceBlock(Reference paramReference, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  169 */     if (paramNodeFormatterContext.isTransformingText()) {
/*  170 */       String str; paramMarkdownWriter.append((CharSequence)paramReference.getOpeningMarker());
/*  171 */       appendReference((CharSequence)paramReference.getReference(), paramNodeFormatterContext, paramMarkdownWriter);
/*  172 */       paramMarkdownWriter.append((CharSequence)paramReference.getClosingMarker());
/*      */       
/*  174 */       paramMarkdownWriter.append(' ');
/*      */       
/*  176 */       paramMarkdownWriter.append((CharSequence)paramReference.getUrlOpeningMarker());
/*      */       
/*  178 */       if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
/*  179 */         ResolvedLink resolvedLink = paramNodeFormatterContext.resolveLink(LinkType.LINK, (CharSequence)paramReference.getUrl(), Boolean.FALSE);
/*  180 */         paramMarkdownWriter.appendNonTranslating(resolvedLink.getPageRef());
/*      */         
/*  182 */         if (resolvedLink.getAnchorRef() != null) {
/*  183 */           paramMarkdownWriter.append("#");
/*  184 */           CharSequence charSequence = paramNodeFormatterContext.transformAnchorRef(resolvedLink.getPageRef(), resolvedLink.getAnchorRef());
/*  185 */           if (this.attributeUniquificationIdMap != null && resolvedLink.getPageRef().isEmpty() && paramNodeFormatterContext.isTransformingText() && paramNodeFormatterContext.getMergeContext() != null) {
/*  186 */             str = String.valueOf(charSequence);
/*  187 */             str = this.attributeUniquificationIdMap.getOrDefault(str, str);
/*  188 */             paramMarkdownWriter.append(str);
/*      */           } else {
/*  190 */             paramMarkdownWriter.append(charSequence);
/*      */           } 
/*  192 */           paramMarkdownWriter.append(charSequence);
/*      */         } 
/*      */       } else {
/*  195 */         paramMarkdownWriter.appendNonTranslating((CharSequence)paramReference.getPageRef());
/*      */         
/*  197 */         paramMarkdownWriter.append((CharSequence)paramReference.getAnchorMarker());
/*  198 */         if (paramReference.getAnchorRef().isNotNull()) {
/*  199 */           CharSequence charSequence = str.transformAnchorRef((CharSequence)paramReference.getPageRef(), (CharSequence)paramReference.getAnchorRef());
/*  200 */           paramMarkdownWriter.append(charSequence);
/*      */         } 
/*      */       } 
/*      */       
/*  204 */       if (paramReference.getTitleOpeningMarker().isNotNull()) {
/*  205 */         paramMarkdownWriter.append(' ');
/*  206 */         paramMarkdownWriter.append((CharSequence)paramReference.getTitleOpeningMarker());
/*  207 */         if (paramReference.getTitle().isNotNull()) paramMarkdownWriter.appendTranslating((CharSequence)paramReference.getTitle()); 
/*  208 */         paramMarkdownWriter.append((CharSequence)paramReference.getTitleClosingMarker());
/*      */       } 
/*      */       
/*  211 */       ((MarkdownWriter)paramMarkdownWriter.append((CharSequence)paramReference.getUrlClosingMarker())).line(); return;
/*      */     } 
/*  213 */     ((MarkdownWriter)paramMarkdownWriter.append((CharSequence)paramReference.getChars())).line();
/*      */     Node node;
/*  215 */     if (node = paramReference.getNext() instanceof HtmlCommentBlock || node instanceof HtmlInnerBlockComment) {
/*  216 */       BasedSequence basedSequence = (BasedSequence)((BasedSequence)node.getChars().trim()).midSequence(4, -3);
/*  217 */       if (this.formatterOptions.linkMarkerCommentPattern != null && this.formatterOptions.linkMarkerCommentPattern.matcher((CharSequence)basedSequence).matches())
/*      */       {
/*  219 */         ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.append("<!--")).append(String.valueOf(basedSequence))).append("-->");
/*      */       }
/*      */     } 
/*  222 */     paramMarkdownWriter.line();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderDocument(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument, FormattingPhase paramFormattingPhase) {
/*  228 */     super.renderDocument(paramNodeFormatterContext, paramMarkdownWriter, paramDocument, paramFormattingPhase);
/*      */     
/*  230 */     this.attributeUniquificationIdMap = (Map<String, String>)Formatter.ATTRIBUTE_UNIQUIFICATION_ID_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/*      */     
/*  232 */     if (paramFormattingPhase == FormattingPhase.DOCUMENT_BOTTOM && 
/*  233 */       this.formatterOptions.appendTransferredReferences) {
/*      */       
/*  235 */       ArrayList<DataKeyBase> arrayList = new ArrayList();
/*      */       
/*  237 */       for (Iterator<DataKeyBase> iterator1 = paramDocument.getAll().keySet().iterator(); iterator1.hasNext();) {
/*  238 */         if ((dataKeyBase = iterator1.next()).get((DataHolder)paramDocument) instanceof NodeRepository) {
/*  239 */           arrayList.add(dataKeyBase);
/*      */         }
/*      */       } 
/*      */       
/*  243 */       arrayList.sort(Comparator.comparing(DataKeyBase::getName));
/*      */       
/*  245 */       boolean bool = true;
/*      */       
/*  247 */       for (Iterator<DataKeyBase> iterator2 = arrayList.iterator(); iterator2.hasNext();) {
/*  248 */         if ((dataKeyBase = iterator2.next()).get((DataHolder)paramDocument) instanceof NodeRepository) {
/*      */           NodeRepository nodeRepository;
/*      */           
/*      */           Set<?> set;
/*  252 */           for (Iterator<?> iterator = (set = (nodeRepository = (NodeRepository)dataKeyBase.get((DataHolder)paramDocument)).getReferencedElements((Node)paramDocument)).iterator(); iterator.hasNext();) {
/*  253 */             if (object = iterator.next() instanceof Node && (
/*      */ 
/*      */               
/*  256 */               object = object).getDocument() != paramDocument) {
/*      */               
/*  258 */               if (bool) {
/*  259 */                 bool = false;
/*  260 */                 paramMarkdownWriter.blankLine();
/*      */               } 
/*  262 */               paramNodeFormatterContext.render((Node)object);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void render(Node paramNode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  273 */     BasedSequence basedSequence = paramNode.getChars();
/*  274 */     if (paramNode instanceof Block) {
/*  275 */       BasedSequence basedSequence1 = ((Block)paramNode).getContentChars(); BasedSequence basedSequence2;
/*  276 */       if (basedSequence.isNotNull() && 
/*      */         
/*  278 */         !(basedSequence2 = basedSequence.prefixOf(basedSequence1)).isEmpty()) {
/*  279 */         paramMarkdownWriter.append((CharSequence)basedSequence2);
/*      */       }
/*      */       
/*  282 */       paramNodeFormatterContext.renderChildren(paramNode);
/*  283 */       if (basedSequence.isNotNull() && 
/*      */         
/*  285 */         !(basedSequence2 = basedSequence.suffixOf(basedSequence1)).isEmpty()) {
/*  286 */         paramMarkdownWriter.append((CharSequence)basedSequence2);
/*      */       }
/*      */       return;
/*      */     } 
/*  290 */     if (this.formatterOptions.keepSoftLineBreaks) {
/*  291 */       paramMarkdownWriter.append((CharSequence)basedSequence); return;
/*      */     } 
/*  293 */     paramMarkdownWriter.append(FormatterUtils.stripSoftLineBreak((CharSequence)basedSequence, " "));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void render(BlankLine paramBlankLine, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  299 */     if (FormatterUtils.LIST_ITEM_SPACING.get((DataHolder)paramNodeFormatterContext.getDocument()) == null && paramMarkdownWriter.offsetWithPending() > 0) {
/*  300 */       if (paramBlankLine.getPrevious() != null && !(paramBlankLine.getPrevious() instanceof BlankLine)) {
/*  301 */         this.blankLines = 0;
/*      */       }
/*  303 */       this.blankLines++;
/*  304 */       if (this.blankLines <= this.formatterOptions.maxBlankLines) paramMarkdownWriter.blankLine(this.blankLines);
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   private void render(Document paramDocument, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  310 */     this.myTranslationStore = paramNodeFormatterContext.getTranslationStore();
/*  311 */     paramNodeFormatterContext.renderChildren((Node)paramDocument);
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
/*      */   
/*      */   private void render(Heading paramHeading, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*      */     // Byte code:
/*      */     //   0: aload_3
/*      */     //   1: invokevirtual blankLine : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   4: pop
/*      */     //   5: aload_0
/*      */     //   6: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   9: getfield headingStyle : Lcom/vladsch/flexmark/util/format/options/HeadingStyle;
/*      */     //   12: astore #4
/*      */     //   14: aload_2
/*      */     //   15: invokeinterface isTransformingText : ()Z
/*      */     //   20: ifne -> 39
/*      */     //   23: aload #4
/*      */     //   25: aload_1
/*      */     //   26: invokevirtual isSetextHeading : ()Z
/*      */     //   29: aload_1
/*      */     //   30: invokevirtual getLevel : ()I
/*      */     //   33: invokevirtual isNoChange : (ZI)Z
/*      */     //   36: ifeq -> 392
/*      */     //   39: aload_1
/*      */     //   40: invokevirtual isAtxHeading : ()Z
/*      */     //   43: ifeq -> 276
/*      */     //   46: aload_3
/*      */     //   47: aload_1
/*      */     //   48: invokevirtual getOpeningMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   51: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   54: pop
/*      */     //   55: aload_0
/*      */     //   56: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   59: getfield spaceAfterAtxMarker : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   62: getstatic com/vladsch/flexmark/util/format/options/DiscretionaryText.ADD : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   65: if_acmpeq -> 102
/*      */     //   68: aload_0
/*      */     //   69: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   72: getfield spaceAfterAtxMarker : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   75: getstatic com/vladsch/flexmark/util/format/options/DiscretionaryText.AS_IS : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   78: if_acmpne -> 106
/*      */     //   81: aload_1
/*      */     //   82: invokevirtual getOpeningMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   85: invokeinterface getEndOffset : ()I
/*      */     //   90: aload_1
/*      */     //   91: invokevirtual getText : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   94: invokeinterface getStartOffset : ()I
/*      */     //   99: if_icmpge -> 106
/*      */     //   102: iconst_1
/*      */     //   103: goto -> 107
/*      */     //   106: iconst_0
/*      */     //   107: dup
/*      */     //   108: istore #4
/*      */     //   110: ifeq -> 120
/*      */     //   113: aload_3
/*      */     //   114: bipush #32
/*      */     //   116: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   119: pop
/*      */     //   120: aload_2
/*      */     //   121: aload_1
/*      */     //   122: dup
/*      */     //   123: <illegal opcode> render : (Lcom/vladsch/flexmark/ast/Heading;)Lcom/vladsch/flexmark/formatter/TranslatingSpanRender;
/*      */     //   128: invokeinterface translatingRefTargetSpan : (Lcom/vladsch/flexmark/util/ast/Node;Lcom/vladsch/flexmark/formatter/TranslatingSpanRender;)V
/*      */     //   133: getstatic com/vladsch/flexmark/formatter/internal/CoreNodeFormatter$1.$SwitchMap$com$vladsch$flexmark$util$format$options$EqualizeTrailingMarker : [I
/*      */     //   136: aload_0
/*      */     //   137: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   140: getfield atxHeadingTrailingMarker : Lcom/vladsch/flexmark/util/format/options/EqualizeTrailingMarker;
/*      */     //   143: invokevirtual ordinal : ()I
/*      */     //   146: iaload
/*      */     //   147: tableswitch default -> 211, 1 -> 172, 2 -> 184, 3 -> 208
/*      */     //   172: aload_1
/*      */     //   173: invokevirtual getClosingMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   176: invokeinterface isNull : ()Z
/*      */     //   181: ifne -> 244
/*      */     //   184: iload #4
/*      */     //   186: ifeq -> 196
/*      */     //   189: aload_3
/*      */     //   190: bipush #32
/*      */     //   192: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   195: pop
/*      */     //   196: aload_3
/*      */     //   197: aload_1
/*      */     //   198: invokevirtual getOpeningMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   201: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   204: pop
/*      */     //   205: goto -> 244
/*      */     //   208: goto -> 244
/*      */     //   211: aload_1
/*      */     //   212: invokevirtual getClosingMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   215: invokeinterface isNotNull : ()Z
/*      */     //   220: ifeq -> 244
/*      */     //   223: iload #4
/*      */     //   225: ifeq -> 235
/*      */     //   228: aload_3
/*      */     //   229: bipush #32
/*      */     //   231: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   234: pop
/*      */     //   235: aload_3
/*      */     //   236: aload_1
/*      */     //   237: invokevirtual getClosingMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   240: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   243: pop
/*      */     //   244: aload_2
/*      */     //   245: invokeinterface getIdGenerator : ()Lcom/vladsch/flexmark/html/renderer/HtmlIdGenerator;
/*      */     //   250: dup
/*      */     //   251: astore #5
/*      */     //   253: ifnull -> 273
/*      */     //   256: aload_2
/*      */     //   257: aload_1
/*      */     //   258: aload #5
/*      */     //   260: aload_1
/*      */     //   261: invokeinterface getId : (Lcom/vladsch/flexmark/util/ast/Node;)Ljava/lang/String;
/*      */     //   266: aload_2
/*      */     //   267: aload_3
/*      */     //   268: invokeinterface addExplicitId : (Lcom/vladsch/flexmark/util/ast/Node;Ljava/lang/String;Lcom/vladsch/flexmark/formatter/NodeFormatterContext;Lcom/vladsch/flexmark/formatter/MarkdownWriter;)V
/*      */     //   273: goto -> 667
/*      */     //   276: aload_2
/*      */     //   277: aload_1
/*      */     //   278: dup
/*      */     //   279: <illegal opcode> render : (Lcom/vladsch/flexmark/ast/Heading;)Lcom/vladsch/flexmark/formatter/TranslatingSpanRender;
/*      */     //   284: invokeinterface translatingRefTargetSpan : (Lcom/vladsch/flexmark/util/ast/Node;Lcom/vladsch/flexmark/formatter/TranslatingSpanRender;)V
/*      */     //   289: aload_2
/*      */     //   290: invokeinterface getIdGenerator : ()Lcom/vladsch/flexmark/html/renderer/HtmlIdGenerator;
/*      */     //   295: dup
/*      */     //   296: astore #4
/*      */     //   298: ifnull -> 318
/*      */     //   301: aload_2
/*      */     //   302: aload_1
/*      */     //   303: aload #4
/*      */     //   305: aload_1
/*      */     //   306: invokeinterface getId : (Lcom/vladsch/flexmark/util/ast/Node;)Ljava/lang/String;
/*      */     //   311: aload_2
/*      */     //   312: aload_3
/*      */     //   313: invokeinterface addExplicitId : (Lcom/vladsch/flexmark/util/ast/Node;Ljava/lang/String;Lcom/vladsch/flexmark/formatter/NodeFormatterContext;Lcom/vladsch/flexmark/formatter/MarkdownWriter;)V
/*      */     //   318: aload_3
/*      */     //   319: invokevirtual line : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   322: pop
/*      */     //   323: aload_0
/*      */     //   324: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   327: getfield setextHeadingEqualizeMarker : Z
/*      */     //   330: ifeq -> 380
/*      */     //   333: aload_3
/*      */     //   334: aload_1
/*      */     //   335: invokevirtual getClosingMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   338: iconst_0
/*      */     //   339: invokeinterface charAt : (I)C
/*      */     //   344: aload_3
/*      */     //   345: dup
/*      */     //   346: invokevirtual getLineCountWithPending : ()I
/*      */     //   349: iconst_1
/*      */     //   350: isub
/*      */     //   351: invokevirtual getLineInfo : (I)Lcom/vladsch/flexmark/util/sequence/LineInfo;
/*      */     //   354: getfield textLength : I
/*      */     //   357: iconst_1
/*      */     //   358: newarray int
/*      */     //   360: dup
/*      */     //   361: iconst_0
/*      */     //   362: aload_0
/*      */     //   363: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   366: getfield minSetextMarkerLength : I
/*      */     //   369: iastore
/*      */     //   370: invokestatic minLimit : (I[I)I
/*      */     //   373: invokevirtual append : (CI)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   376: pop
/*      */     //   377: goto -> 667
/*      */     //   380: aload_3
/*      */     //   381: aload_1
/*      */     //   382: invokevirtual getClosingMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   385: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   388: pop
/*      */     //   389: goto -> 667
/*      */     //   392: aload #4
/*      */     //   394: invokevirtual isSetext : ()Z
/*      */     //   397: ifeq -> 498
/*      */     //   400: aload_2
/*      */     //   401: aload_1
/*      */     //   402: invokeinterface renderChildren : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*      */     //   407: aload_3
/*      */     //   408: invokevirtual line : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   411: pop
/*      */     //   412: aload_1
/*      */     //   413: invokevirtual getLevel : ()I
/*      */     //   416: iconst_1
/*      */     //   417: if_icmpne -> 425
/*      */     //   420: bipush #61
/*      */     //   422: goto -> 427
/*      */     //   425: bipush #45
/*      */     //   427: istore #4
/*      */     //   429: aload_0
/*      */     //   430: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   433: getfield setextHeadingEqualizeMarker : Z
/*      */     //   436: ifeq -> 478
/*      */     //   439: aload_3
/*      */     //   440: iload #4
/*      */     //   442: aload_3
/*      */     //   443: dup
/*      */     //   444: invokevirtual getLineCountWithPending : ()I
/*      */     //   447: iconst_1
/*      */     //   448: isub
/*      */     //   449: invokevirtual getLineInfo : (I)Lcom/vladsch/flexmark/util/sequence/LineInfo;
/*      */     //   452: getfield textLength : I
/*      */     //   455: iconst_1
/*      */     //   456: newarray int
/*      */     //   458: dup
/*      */     //   459: iconst_0
/*      */     //   460: aload_0
/*      */     //   461: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   464: getfield minSetextMarkerLength : I
/*      */     //   467: iastore
/*      */     //   468: invokestatic minLimit : (I[I)I
/*      */     //   471: invokevirtual append : (CI)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   474: pop
/*      */     //   475: goto -> 667
/*      */     //   478: aload_3
/*      */     //   479: iload #4
/*      */     //   481: aload_0
/*      */     //   482: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   485: getfield minSetextMarkerLength : I
/*      */     //   488: invokestatic repeatOf : (CI)Ljava/lang/CharSequence;
/*      */     //   491: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   494: pop
/*      */     //   495: goto -> 667
/*      */     //   498: getstatic com/vladsch/flexmark/formatter/internal/CoreNodeFormatter.$assertionsDisabled : Z
/*      */     //   501: ifne -> 520
/*      */     //   504: aload #4
/*      */     //   506: invokevirtual isAtx : ()Z
/*      */     //   509: ifne -> 520
/*      */     //   512: new java/lang/AssertionError
/*      */     //   515: dup
/*      */     //   516: invokespecial <init> : ()V
/*      */     //   519: athrow
/*      */     //   520: bipush #35
/*      */     //   522: aload_1
/*      */     //   523: invokevirtual getLevel : ()I
/*      */     //   526: invokestatic repeatOf : (CI)Ljava/lang/CharSequence;
/*      */     //   529: astore #4
/*      */     //   531: aload_3
/*      */     //   532: aload #4
/*      */     //   534: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   537: pop
/*      */     //   538: aload_0
/*      */     //   539: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   542: getfield spaceAfterAtxMarker : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   545: getstatic com/vladsch/flexmark/util/format/options/DiscretionaryText.ADD : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   548: if_acmpeq -> 585
/*      */     //   551: aload_0
/*      */     //   552: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   555: getfield spaceAfterAtxMarker : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   558: getstatic com/vladsch/flexmark/util/format/options/DiscretionaryText.AS_IS : Lcom/vladsch/flexmark/util/format/options/DiscretionaryText;
/*      */     //   561: if_acmpne -> 589
/*      */     //   564: getstatic com/vladsch/flexmark/parser/Parser.HEADING_NO_ATX_SPACE : Lcom/vladsch/flexmark/util/data/DataKey;
/*      */     //   567: aload_2
/*      */     //   568: invokeinterface getOptions : ()Lcom/vladsch/flexmark/util/data/DataHolder;
/*      */     //   573: invokevirtual get : (Lcom/vladsch/flexmark/util/data/DataHolder;)Ljava/lang/Object;
/*      */     //   576: checkcast java/lang/Boolean
/*      */     //   579: invokevirtual booleanValue : ()Z
/*      */     //   582: ifne -> 589
/*      */     //   585: iconst_1
/*      */     //   586: goto -> 590
/*      */     //   589: iconst_0
/*      */     //   590: dup
/*      */     //   591: istore #5
/*      */     //   593: ifeq -> 603
/*      */     //   596: aload_3
/*      */     //   597: bipush #32
/*      */     //   599: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   602: pop
/*      */     //   603: aload_2
/*      */     //   604: aload_1
/*      */     //   605: invokeinterface renderChildren : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*      */     //   610: getstatic com/vladsch/flexmark/formatter/internal/CoreNodeFormatter$1.$SwitchMap$com$vladsch$flexmark$util$format$options$EqualizeTrailingMarker : [I
/*      */     //   613: aload_0
/*      */     //   614: getfield formatterOptions : Lcom/vladsch/flexmark/formatter/FormatterOptions;
/*      */     //   617: getfield atxHeadingTrailingMarker : Lcom/vladsch/flexmark/util/format/options/EqualizeTrailingMarker;
/*      */     //   620: invokevirtual ordinal : ()I
/*      */     //   623: iaload
/*      */     //   624: tableswitch default -> 667, 1 -> 648, 2 -> 648
/*      */     //   648: iload #5
/*      */     //   650: ifeq -> 660
/*      */     //   653: aload_3
/*      */     //   654: bipush #32
/*      */     //   656: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   659: pop
/*      */     //   660: aload_3
/*      */     //   661: aload #4
/*      */     //   663: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   666: pop
/*      */     //   667: aload_3
/*      */     //   668: invokevirtual tailBlankLine : ()Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   671: pop
/*      */     //   672: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #315	-> 0
/*      */     //   #316	-> 5
/*      */     //   #317	-> 14
/*      */     //   #318	-> 39
/*      */     //   #319	-> 46
/*      */     //   #320	-> 55
/*      */     //   #321	-> 82
/*      */     //   #323	-> 108
/*      */     //   #325	-> 120
/*      */     //   #327	-> 133
/*      */     //   #329	-> 172
/*      */     //   #332	-> 184
/*      */     //   #333	-> 196
/*      */     //   #334	-> 205
/*      */     //   #337	-> 208
/*      */     //   #341	-> 211
/*      */     //   #342	-> 223
/*      */     //   #343	-> 235
/*      */     //   #349	-> 244
/*      */     //   #350	-> 251
/*      */     //   #351	-> 256
/*      */     //   #353	-> 273
/*      */     //   #354	-> 276
/*      */     //   #357	-> 289
/*      */     //   #359	-> 296
/*      */     //   #360	-> 301
/*      */     //   #363	-> 318
/*      */     //   #365	-> 323
/*      */     //   #366	-> 333
/*      */     //   #368	-> 380
/*      */     //   #370	-> 389
/*      */     //   #371	-> 392
/*      */     //   #373	-> 400
/*      */     //   #374	-> 407
/*      */     //   #375	-> 412
/*      */     //   #377	-> 429
/*      */     //   #378	-> 439
/*      */     //   #380	-> 478
/*      */     //   #382	-> 495
/*      */     //   #384	-> 498
/*      */     //   #386	-> 520
/*      */     //   #387	-> 531
/*      */     //   #389	-> 538
/*      */     //   #390	-> 568
/*      */     //   #392	-> 591
/*      */     //   #394	-> 603
/*      */     //   #396	-> 610
/*      */     //   #399	-> 648
/*      */     //   #400	-> 660
/*      */     //   #410	-> 667
/*      */     //   #411	-> 672
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
/*      */   private void render(BlockQuote paramBlockQuote, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  414 */     FormatterUtils.renderBlockQuoteLike((BlockQuoteLike)paramBlockQuote, paramNodeFormatterContext, paramMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void render(ThematicBreak paramThematicBreak, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  418 */     paramMarkdownWriter.blankLine();
/*  419 */     if (this.formatterOptions.thematicBreak != null) {
/*  420 */       paramMarkdownWriter.append(this.formatterOptions.thematicBreak);
/*      */     } else {
/*  422 */       paramMarkdownWriter.append((CharSequence)paramThematicBreak.getChars());
/*      */     } 
/*  424 */     paramMarkdownWriter.tailBlankLine();
/*      */   }
/*      */   private void render(FencedCodeBlock paramFencedCodeBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*      */     CharSequence charSequence2;
/*  428 */     paramMarkdownWriter.blankLine();
/*      */     
/*  430 */     BasedSequence basedSequence1 = paramFencedCodeBlock.getOpeningMarker();
/*  431 */     BasedSequence basedSequence2 = paramFencedCodeBlock.getClosingMarker();
/*  432 */     char c = basedSequence1.charAt(0);
/*  433 */     int k = (basedSequence2.length() > 0) ? basedSequence2.charAt(0) : 0;
/*  434 */     int i = basedSequence1.length();
/*  435 */     int j = basedSequence2.length();
/*      */     
/*  437 */     switch (this.formatterOptions.fencedCodeMarkerType) {
/*      */ 
/*      */       
/*      */       case TRANSLATED_SPANS:
/*  441 */         c = '`';
/*  442 */         k = 96;
/*      */         break;
/*      */       case TRANSLATED:
/*  445 */         c = '~';
/*  446 */         k = 126;
/*      */         break;
/*      */     } 
/*      */     
/*  450 */     if (i < this.formatterOptions.fencedCodeMarkerLength) i = this.formatterOptions.fencedCodeMarkerLength; 
/*  451 */     if (j < this.formatterOptions.fencedCodeMarkerLength) j = this.formatterOptions.fencedCodeMarkerLength;
/*      */     
/*  453 */     CharSequence charSequence1 = RepeatedSequence.repeatOf(String.valueOf(c), i);
/*  454 */     if (this.formatterOptions.fencedCodeMatchClosingMarker || k == 0) { charSequence2 = charSequence1; } else { charSequence2 = RepeatedSequence.repeatOf(String.valueOf(k), charSequence2); }
/*      */     
/*  456 */     paramMarkdownWriter.append(charSequence1);
/*  457 */     if (this.formatterOptions.fencedCodeSpaceBeforeInfo) paramMarkdownWriter.append(' '); 
/*  458 */     paramMarkdownWriter.appendNonTranslating((CharSequence)paramFencedCodeBlock.getInfo());
/*  459 */     paramMarkdownWriter.line();
/*      */     
/*  461 */     paramMarkdownWriter.openPreFormatted(true);
/*  462 */     if (paramNodeFormatterContext.isTransformingText()) {
/*  463 */       paramMarkdownWriter.appendNonTranslating((CharSequence)paramFencedCodeBlock.getContentChars());
/*      */     }
/*  465 */     else if (this.formatterOptions.fencedCodeMinimizeIndent) {
/*      */       List list;
/*  467 */       int[] arrayOfInt = new int[(list = paramFencedCodeBlock.getContentLines()).size()];
/*  468 */       k = Integer.MAX_VALUE;
/*  469 */       byte b = 0;
/*  470 */       for (BasedSequence basedSequence : list) {
/*  471 */         arrayOfInt[b] = basedSequence.countLeadingColumns(0, CharPredicate.SPACE_TAB);
/*  472 */         k = Utils.min(k, new int[] { arrayOfInt[b] });
/*  473 */         b++;
/*      */       } 
/*  475 */       if (k > 0) {
/*  476 */         b = 0;
/*  477 */         for (BasedSequence basedSequence : list) {
/*  478 */           if (arrayOfInt[b] > k) paramMarkdownWriter.append(' ', arrayOfInt[b] - k); 
/*  479 */           paramMarkdownWriter.append((CharSequence)basedSequence.trimStart());
/*  480 */           b++;
/*      */         } 
/*      */       } else {
/*  483 */         paramMarkdownWriter.append((CharSequence)paramFencedCodeBlock.getContentChars());
/*      */       } 
/*      */     } else {
/*  486 */       paramMarkdownWriter.append((CharSequence)paramFencedCodeBlock.getContentChars());
/*      */     } 
/*      */     
/*  489 */     paramMarkdownWriter.closePreFormatted();
/*  490 */     ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.line()).append(charSequence2)).line();
/*      */     
/*  492 */     if (!(paramFencedCodeBlock.getParent() instanceof ListItem) || !FormatterUtils.isLastOfItem((Node)paramFencedCodeBlock) || FormatterUtils.LIST_ITEM_SPACING.get((DataHolder)paramNodeFormatterContext.getDocument()) == ListSpacing.LOOSE) {
/*  493 */       paramMarkdownWriter.tailBlankLine();
/*      */     }
/*      */   }
/*      */   
/*      */   private void render(IndentedCodeBlock paramIndentedCodeBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  498 */     paramMarkdownWriter.blankLine();
/*      */     
/*  500 */     if (paramNodeFormatterContext.isTransformingText()) {
/*      */       BasedSequence basedSequence;
/*      */       
/*  503 */       String str = FormatterUtils.getActualAdditionalPrefix(basedSequence = paramIndentedCodeBlock.getContentChars(), paramMarkdownWriter);
/*      */ 
/*      */       
/*  506 */       if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED) {
/*  507 */         basedSequence = (BasedSequence)basedSequence.trimStart();
/*      */       }
/*      */       
/*  510 */       ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(str);
/*  511 */       paramMarkdownWriter.openPreFormatted(true);
/*  512 */       paramMarkdownWriter.appendNonTranslating(Utils.suffixWith(basedSequence.toString(), '\n'));
/*      */     } else {
/*  514 */       String str = RepeatedSequence.repeatOf(" ", this.listOptions.getCodeIndent()).toString();
/*      */       
/*  516 */       if (this.formatterOptions.emulationProfile == ParserEmulationProfile.GITHUB_DOC && 
/*  517 */         paramIndentedCodeBlock.getParent() instanceof ListItem) {
/*  518 */         BasedSequence basedSequence = ((ListItem)paramIndentedCodeBlock.getParent()).getOpeningMarker();
/*  519 */         str = RepeatedSequence.repeatOf(" ", Utils.minLimit(8 - basedSequence.length() - 1, new int[] { 4 })).toString();
/*      */       } 
/*      */ 
/*      */       
/*  523 */       ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(str);
/*  524 */       paramMarkdownWriter.openPreFormatted(true);
/*      */       
/*  526 */       if (this.formatterOptions.indentedCodeMinimizeIndent) {
/*      */         List list;
/*  528 */         int[] arrayOfInt = new int[(list = paramIndentedCodeBlock.getContentLines()).size()];
/*  529 */         int i = Integer.MAX_VALUE;
/*  530 */         byte b = 0;
/*  531 */         for (BasedSequence basedSequence : list) {
/*  532 */           arrayOfInt[b] = basedSequence.countLeadingColumns(0, CharPredicate.SPACE_TAB);
/*  533 */           i = Utils.min(i, new int[] { arrayOfInt[b] });
/*  534 */           b++;
/*      */         } 
/*  536 */         if (i > 0) {
/*  537 */           b = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  545 */           for (BasedSequence basedSequence : list) {
/*  546 */             if (arrayOfInt[b] > i) paramMarkdownWriter.append(' ', arrayOfInt[b] - i); 
/*  547 */             paramMarkdownWriter.append((CharSequence)basedSequence.trimStart());
/*  548 */             b++;
/*      */           } 
/*      */         } else {
/*  551 */           paramMarkdownWriter.append((CharSequence)paramIndentedCodeBlock.getContentChars());
/*      */         } 
/*      */       } else {
/*  554 */         paramMarkdownWriter.append((CharSequence)paramIndentedCodeBlock.getContentChars());
/*      */       } 
/*      */     } 
/*      */     
/*  558 */     paramMarkdownWriter.closePreFormatted();
/*  559 */     paramMarkdownWriter.popPrefix(true);
/*  560 */     paramMarkdownWriter.tailBlankLine();
/*      */   }
/*      */   
/*      */   private void render(BulletList paramBulletList, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  564 */     FormatterUtils.renderList((ListBlock)paramBulletList, paramNodeFormatterContext, paramMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void render(OrderedList paramOrderedList, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  568 */     FormatterUtils.renderList((ListBlock)paramOrderedList, paramNodeFormatterContext, paramMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void render(BulletListItem paramBulletListItem, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  572 */     FormatterUtils.renderListItem((ListItem)paramBulletListItem, paramNodeFormatterContext, paramMarkdownWriter, this.listOptions, paramBulletListItem.getMarkerSuffix(), false);
/*      */   }
/*      */   
/*      */   private void render(OrderedListItem paramOrderedListItem, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  576 */     FormatterUtils.renderListItem((ListItem)paramOrderedListItem, paramNodeFormatterContext, paramMarkdownWriter, this.listOptions, paramOrderedListItem.getMarkerSuffix(), false);
/*      */   }
/*      */   
/*      */   private void render(Emphasis paramEmphasis, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  580 */     paramMarkdownWriter.append((CharSequence)paramEmphasis.getOpeningMarker());
/*  581 */     paramNodeFormatterContext.renderChildren((Node)paramEmphasis);
/*  582 */     paramMarkdownWriter.append((CharSequence)paramEmphasis.getOpeningMarker());
/*      */   }
/*      */   
/*      */   private void render(StrongEmphasis paramStrongEmphasis, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  586 */     paramMarkdownWriter.append((CharSequence)paramStrongEmphasis.getOpeningMarker());
/*  587 */     paramNodeFormatterContext.renderChildren((Node)paramStrongEmphasis);
/*  588 */     paramMarkdownWriter.append((CharSequence)paramStrongEmphasis.getOpeningMarker());
/*      */   }
/*      */   
/*      */   private void render(Paragraph paramParagraph, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  592 */     if (paramNodeFormatterContext.isTransformingText()) {
/*      */       
/*  594 */       FormatterUtils.renderTextBlockParagraphLines((Node)paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*  595 */       if (paramParagraph.isTrailingBlankLine()) {
/*  596 */         paramMarkdownWriter.tailBlankLine();
/*      */         return;
/*      */       } 
/*  599 */     } else if (!(paramParagraph.getParent() instanceof ParagraphItemContainer)) {
/*  600 */       if (paramParagraph.getParent() instanceof ParagraphContainer) {
/*  601 */         boolean bool1 = ((ParagraphContainer)paramParagraph.getParent()).isParagraphStartWrappingDisabled(paramParagraph);
/*  602 */         boolean bool2 = ((ParagraphContainer)paramParagraph.getParent()).isParagraphEndWrappingDisabled(paramParagraph);
/*  603 */         if (bool1 || bool2)
/*  604 */         { if (!bool1) paramMarkdownWriter.blankLine(); 
/*  605 */           FormatterUtils.renderTextBlockParagraphLines((Node)paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*  606 */           if (!bool2) { paramMarkdownWriter.tailBlankLine(); } else { return; }
/*      */            }
/*  608 */         else { FormatterUtils.renderLooseParagraph(paramParagraph, paramNodeFormatterContext, paramMarkdownWriter); return; }
/*      */       
/*      */       } else {
/*  611 */         if (!paramParagraph.isTrailingBlankLine() && (paramParagraph.getNext() == null || paramParagraph.getNext() instanceof ListBlock)) {
/*  612 */           FormatterUtils.renderTextBlockParagraphLines((Node)paramParagraph, paramNodeFormatterContext, paramMarkdownWriter); return;
/*      */         } 
/*  614 */         FormatterUtils.renderLooseParagraph(paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*      */         return;
/*      */       } 
/*      */     } else {
/*      */       boolean bool;
/*  619 */       if (bool = ((ParagraphItemContainer)paramParagraph.getParent()).isItemParagraph(paramParagraph)) {
/*  620 */         if (this.formatterOptions.blankLinesInAst) {
/*  621 */           FormatterUtils.renderLooseItemParagraph(paramParagraph, paramNodeFormatterContext, paramMarkdownWriter); return;
/*      */         } 
/*      */         ListSpacing listSpacing;
/*  624 */         if ((listSpacing = (ListSpacing)FormatterUtils.LIST_ITEM_SPACING.get((DataHolder)paramNodeFormatterContext.getDocument())) != ListSpacing.TIGHT)
/*      */         {
/*  626 */           if (listSpacing == ListSpacing.LOOSE) {
/*  627 */             if (paramParagraph.getParent().getNextAnyNot(new Class[] { BlankLine.class }) != null) {
/*      */ 
/*      */               
/*  630 */               FormatterUtils.renderLooseItemParagraph(paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*      */               return;
/*      */             } 
/*  633 */           } else if (!((ParagraphItemContainer)paramParagraph.getParent()).isParagraphWrappingDisabled(paramParagraph, this.listOptions, paramNodeFormatterContext.getOptions())) {
/*  634 */             FormatterUtils.renderLooseItemParagraph(paramParagraph, paramNodeFormatterContext, paramMarkdownWriter); return;
/*      */           }  } 
/*  636 */         FormatterUtils.renderTextBlockParagraphLines((Node)paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  641 */       FormatterUtils.renderLooseParagraph(paramParagraph, paramNodeFormatterContext, paramMarkdownWriter);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void render(SoftLineBreak paramSoftLineBreak, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  648 */     if (this.formatterOptions.keepSoftLineBreaks || this.formatterOptions.rightMargin > 0) {
/*  649 */       paramMarkdownWriter.append((CharSequence)paramSoftLineBreak.getChars()); return;
/*  650 */     }  if (!paramMarkdownWriter.isPendingSpace())
/*      */     {
/*  652 */       paramMarkdownWriter.append(' ');
/*      */     }
/*      */   }
/*      */   
/*      */   private void render(HardLineBreak paramHardLineBreak, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  657 */     if (this.formatterOptions.keepHardLineBreaks) {
/*  658 */       if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
/*  659 */         paramMarkdownWriter.append((CharSequence)paramHardLineBreak.getChars()); return;
/*      */       } 
/*  661 */       paramMarkdownWriter.append((CharSequence)paramHardLineBreak.getChars()); return;
/*      */     } 
/*  663 */     if (!paramMarkdownWriter.isPendingSpace())
/*      */     {
/*  665 */       paramMarkdownWriter.append(' '); } 
/*      */   }
/*      */   
/*      */   static {
/*  669 */     htmlEntityPlaceholderGenerator = (paramInt -> String.format(Locale.US, "&#%d;", new Object[] { Integer.valueOf(paramInt) }));
/*      */   }
/*      */   private void render(HtmlEntity paramHtmlEntity, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  672 */     if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
/*  673 */       paramMarkdownWriter.append((CharSequence)paramHtmlEntity.getChars()); return;
/*      */     } 
/*  675 */     paramNodeFormatterContext.customPlaceholderFormat(htmlEntityPlaceholderGenerator, (paramNodeFormatterContext, paramMarkdownWriter) -> paramMarkdownWriter.appendNonTranslating((CharSequence)paramHtmlEntity.getChars()));
/*      */   }
/*      */ 
/*      */   
/*      */   private void render(Text paramText, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  680 */     if (this.formatterOptions.keepSoftLineBreaks) {
/*  681 */       paramMarkdownWriter.append((CharSequence)paramText.getChars()); return;
/*      */     } 
/*  683 */     paramMarkdownWriter.append(FormatterUtils.stripSoftLineBreak((CharSequence)paramText.getChars(), " "));
/*      */   }
/*      */ 
/*      */   
/*      */   private void render(TextBase paramTextBase, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  688 */     paramNodeFormatterContext.renderChildren((Node)paramTextBase);
/*      */   }
/*      */   
/*      */   private void render(Code paramCode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  692 */     paramMarkdownWriter.append((CharSequence)paramCode.getOpeningMarker());
/*  693 */     if (paramNodeFormatterContext.isTransformingText() || this.formatterOptions.rightMargin == 0) {
/*  694 */       if (this.formatterOptions.keepSoftLineBreaks) {
/*  695 */         paramMarkdownWriter.appendNonTranslating((CharSequence)paramCode.getText());
/*      */       } else {
/*  697 */         paramMarkdownWriter.appendNonTranslating(FormatterUtils.stripSoftLineBreak((CharSequence)paramCode.getText(), " "));
/*      */       }
/*      */     
/*      */     }
/*  701 */     else if (this.formatterOptions.keepSoftLineBreaks) {
/*  702 */       paramMarkdownWriter.append((CharSequence)paramCode.getText());
/*      */     } else {
/*  704 */       paramMarkdownWriter.append(FormatterUtils.stripSoftLineBreak((CharSequence)paramCode.getText(), " "));
/*      */     } 
/*      */     
/*  707 */     paramMarkdownWriter.append((CharSequence)paramCode.getClosingMarker());
/*      */   }
/*      */   
/*      */   private void render(HtmlBlock paramHtmlBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  711 */     if (paramHtmlBlock.hasChildren()) {
/*      */       
/*  713 */       paramNodeFormatterContext.renderChildren((Node)paramHtmlBlock); return;
/*      */     } 
/*  715 */     paramMarkdownWriter.blankLine();
/*      */     
/*  717 */     render((HtmlBlockBase)paramHtmlBlock, paramNodeFormatterContext, paramMarkdownWriter);
/*  718 */     paramMarkdownWriter.tailBlankLine();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void render(HtmlCommentBlock paramHtmlCommentBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  724 */     BasedSequence basedSequence1 = (BasedSequence)((BasedSequence)paramHtmlCommentBlock.getChars().trim()).midSequence(4, -3);
/*  725 */     BasedSequence basedSequence2 = BasedSequence.EOL;
/*      */     
/*  727 */     if (!paramNodeFormatterContext.isTransformingText() && this.formatterOptions.linkMarkerCommentPattern != null && this.formatterOptions.linkMarkerCommentPattern.matcher((CharSequence)basedSequence1).matches()) {
/*      */       
/*  729 */       if (!(paramHtmlCommentBlock.getPrevious() instanceof Reference)) {
/*  730 */         ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.append("<!--")).append(String.valueOf(basedSequence1.toMapped(SpaceMapper.toNonBreakSpace)))).append("-->"); return;
/*      */       } 
/*      */     } else {
/*  733 */       paramMarkdownWriter.appendTranslating("<!--", (CharSequence)basedSequence1, "-->", (CharSequence)basedSequence2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void render(HtmlBlockBase paramHtmlBlockBase, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  740 */     switch (paramNodeFormatterContext.getRenderPurpose()) {
/*      */       case TRANSLATION_SPANS:
/*      */       case TRANSLATED_SPANS:
/*  743 */         paramMarkdownWriter.appendNonTranslating(this.myHtmlBlockPrefix, (CharSequence)paramHtmlBlockBase.getChars().trimEOL(), ">", (CharSequence)paramHtmlBlockBase.getChars().trimmedEOL());
/*      */         return;
/*      */       
/*      */       case TRANSLATED:
/*  747 */         paramMarkdownWriter.openPreFormatted(true);
/*  748 */         paramMarkdownWriter.appendNonTranslating((CharSequence)paramHtmlBlockBase.getChars());
/*  749 */         paramMarkdownWriter.closePreFormatted();
/*      */         return;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  755 */     paramMarkdownWriter.openPreFormatted(true);
/*      */     
/*  757 */     if ((basedSequence = paramHtmlBlockBase.getSpanningChars()).equals(paramHtmlBlockBase.getChars())) {
/*  758 */       for (BasedSequence basedSequence : paramHtmlBlockBase.getContentLines()) {
/*  759 */         paramMarkdownWriter.append((CharSequence)basedSequence);
/*      */       }
/*      */     } else {
/*  762 */       paramMarkdownWriter.append((CharSequence)paramHtmlBlockBase.getChars());
/*      */     } 
/*  764 */     ((MarkdownWriter)paramMarkdownWriter.line()).closePreFormatted();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void render(HtmlInnerBlockComment paramHtmlInnerBlockComment, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  770 */     BasedSequence basedSequence = (BasedSequence)((BasedSequence)paramHtmlInnerBlockComment.getChars().trim()).midSequence(4, -3);
/*  771 */     if (!paramNodeFormatterContext.isTransformingText() && this.formatterOptions.linkMarkerCommentPattern != null && this.formatterOptions.linkMarkerCommentPattern.matcher((CharSequence)basedSequence).matches()) {
/*      */       
/*  773 */       if (!(paramHtmlInnerBlockComment.getPrevious() instanceof Reference)) {
/*  774 */         ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.append("<!--")).append(String.valueOf(basedSequence.toMapped(SpaceMapper.toNonBreakSpace)))).append("-->"); return;
/*      */       } 
/*      */     } else {
/*  777 */       paramMarkdownWriter.appendTranslating("<!--", (CharSequence)basedSequence, "-->");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void render(HtmlInline paramHtmlInline, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*      */     String str;
/*  783 */     switch (paramNodeFormatterContext.getRenderPurpose()) {
/*      */       case TRANSLATION_SPANS:
/*      */       case TRANSLATED_SPANS:
/*  786 */         str = paramHtmlInline.getChars().startsWith("</") ? "</" : "<";
/*  787 */         paramMarkdownWriter.appendNonTranslating(str + this.myHtmlInlinePrefix, (CharSequence)paramHtmlInline.getChars(), ">");
/*      */         return;
/*      */ 
/*      */       
/*      */       case TRANSLATED:
/*  792 */         paramMarkdownWriter.appendNonTranslating((CharSequence)paramHtmlInline.getChars());
/*      */         return;
/*      */     } 
/*      */ 
/*      */     
/*  797 */     paramMarkdownWriter.append((CharSequence)paramHtmlInline.getChars());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void render(HtmlInlineComment paramHtmlInlineComment, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  803 */     BasedSequence basedSequence = (BasedSequence)((BasedSequence)paramHtmlInlineComment.getChars().trim()).midSequence(4, -3);
/*  804 */     if (!paramNodeFormatterContext.isTransformingText() && this.formatterOptions.linkMarkerCommentPattern != null && this.formatterOptions.linkMarkerCommentPattern.matcher((CharSequence)basedSequence).matches()) {
/*  805 */       ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.append("<!--")).append(String.valueOf(basedSequence.toMapped(SpaceMapper.toNonBreakSpace)))).append("-->"); return;
/*      */     } 
/*  807 */     paramMarkdownWriter.appendTranslating("<!--", (CharSequence)basedSequence, "-->");
/*      */   }
/*      */ 
/*      */   
/*      */   private void render(Reference paramReference, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  812 */     renderReference((Node)paramReference, paramNodeFormatterContext, paramMarkdownWriter);
/*      */   }
/*      */   
/*  815 */   public static final DataKey<Boolean> UNWRAPPED_AUTO_LINKS = new DataKey("UNWRAPPED_AUTO_LINKS", Boolean.FALSE);
/*  816 */   public static final DataKey<HashSet<String>> UNWRAPPED_AUTO_LINKS_MAP = new DataKey("UNWRAPPED_AUTO_LINKS_MAP", HashSet::new);
/*      */   
/*      */   private void render(AutoLink paramAutoLink, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  819 */     renderAutoLink((DelimitedLinkNode)paramAutoLink, paramNodeFormatterContext, paramMarkdownWriter, this.myTranslationAutolinkPrefix, (String)null);
/*      */   }
/*      */   
/*      */   private void render(MailLink paramMailLink, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  823 */     renderAutoLink((DelimitedLinkNode)paramMailLink, paramNodeFormatterContext, paramMarkdownWriter, this.myTranslationAutolinkPrefix, (String)null);
/*      */   }
/*      */   
/*      */   private void renderAutoLink(DelimitedLinkNode paramDelimitedLinkNode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, String paramString1, String paramString2) {
/*  827 */     if (paramNodeFormatterContext.isTransformingText()) {
/*  828 */       switch (paramNodeFormatterContext.getRenderPurpose()) {
/*      */         case TRANSLATION_SPANS:
/*  830 */           if (paramDelimitedLinkNode.getOpeningMarker().isNull()) {
/*      */             
/*  832 */             this.myTranslationStore.set(UNWRAPPED_AUTO_LINKS, Boolean.TRUE);
/*      */             
/*  834 */             paramNodeFormatterContext.postProcessNonTranslating(paramString -> {
/*      */                   ((HashSet<String>)UNWRAPPED_AUTO_LINKS_MAP.get((DataHolder)this.myTranslationStore)).add(paramString); return paramString;
/*      */                 }() -> {
/*      */                   paramMarkdownWriter.append("<");
/*      */                   paramMarkdownWriter.appendNonTranslating(paramString1, (CharSequence)paramDelimitedLinkNode.getText(), paramString2);
/*      */                   paramMarkdownWriter.append(">");
/*      */                 });
/*      */             return;
/*      */           } 
/*  843 */           paramMarkdownWriter.append("<");
/*  844 */           paramMarkdownWriter.appendNonTranslating(paramString1, (CharSequence)paramDelimitedLinkNode.getText(), paramString2);
/*  845 */           paramMarkdownWriter.append(">");
/*      */           return;
/*      */         
/*      */         case TRANSLATED_SPANS:
/*  849 */           paramMarkdownWriter.append("<");
/*  850 */           paramMarkdownWriter.appendNonTranslating(paramString1, (CharSequence)paramDelimitedLinkNode.getText(), paramString2);
/*  851 */           paramMarkdownWriter.append(">");
/*      */           return;
/*      */ 
/*      */         
/*      */         case TRANSLATED:
/*  856 */           if (((Boolean)UNWRAPPED_AUTO_LINKS.get((DataHolder)this.myTranslationStore)).booleanValue() && ((HashSet)UNWRAPPED_AUTO_LINKS_MAP.get((DataHolder)this.myTranslationStore)).contains(paramDelimitedLinkNode.getText().toString())) {
/*  857 */             paramMarkdownWriter.appendNonTranslating(paramString1, (CharSequence)paramDelimitedLinkNode.getText(), paramString2); return;
/*      */           } 
/*  859 */           paramMarkdownWriter.append("<");
/*  860 */           paramMarkdownWriter.appendNonTranslating(paramString1, (CharSequence)paramDelimitedLinkNode.getText(), paramString2);
/*  861 */           paramMarkdownWriter.append(">");
/*      */           return;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  867 */       paramMarkdownWriter.append((CharSequence)paramDelimitedLinkNode.getChars());
/*      */       
/*      */       return;
/*      */     } 
/*  871 */     paramMarkdownWriter.append((CharSequence)paramDelimitedLinkNode.getChars());
/*      */   }
/*      */ 
/*      */   
/*      */   private void render(Image paramImage, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  876 */     if (!paramNodeFormatterContext.isTransformingText() && this.formatterOptions.rightMargin > 0 && this.formatterOptions.keepImageLinksAtStart) {
/*  877 */       paramMarkdownWriter.append(' ');
/*      */     } else {
/*  879 */       paramMarkdownWriter.lineIf(this.formatterOptions.keepImageLinksAtStart);
/*      */     } 
/*      */     
/*  882 */     if (!this.formatterOptions.optimizedInlineRendering || paramNodeFormatterContext.isTransformingText()) {
/*  883 */       paramMarkdownWriter.append((CharSequence)paramImage.getTextOpeningMarker());
/*  884 */       if (!paramNodeFormatterContext.isTransformingText() || paramImage.getFirstChildAny(new Class[] { HtmlInline.class }) != null) {
/*  885 */         if (this.formatterOptions.rightMargin > 0) {
/*      */           
/*  887 */           paramMarkdownWriter.append((CharSequence)paramImage.getText().toMapped(SpaceMapper.toNonBreakSpace));
/*      */         } else {
/*  889 */           paramNodeFormatterContext.renderChildren((Node)paramImage);
/*      */         } 
/*      */       } else {
/*  892 */         paramMarkdownWriter.appendTranslating((CharSequence)paramImage.getText());
/*      */       } 
/*  894 */       paramMarkdownWriter.append((CharSequence)paramImage.getTextClosingMarker());
/*      */       
/*  896 */       paramMarkdownWriter.append((CharSequence)paramImage.getLinkOpeningMarker());
/*      */       
/*  898 */       paramMarkdownWriter.append((CharSequence)paramImage.getUrlOpeningMarker());
/*      */       
/*  900 */       if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
/*  901 */         ResolvedLink resolvedLink = paramNodeFormatterContext.resolveLink(LinkType.LINK, (CharSequence)paramImage.getUrl(), Boolean.FALSE);
/*  902 */         paramMarkdownWriter.appendNonTranslating(resolvedLink.getPageRef());
/*      */       } else {
/*  904 */         paramMarkdownWriter.append((CharSequence)paramImage.getUrlOpeningMarker());
/*  905 */         paramMarkdownWriter.appendNonTranslating((CharSequence)paramImage.getPageRef());
/*      */       } 
/*      */       
/*  908 */       paramMarkdownWriter.append((CharSequence)paramImage.getUrlClosingMarker());
/*      */       
/*  910 */       if (!paramImage.getUrlContent().isEmpty()) {
/*  911 */         paramMarkdownWriter.openPreFormatted(true);
/*  912 */         ((MarkdownWriter)paramMarkdownWriter.pushOptions()).preserveSpaces();
/*      */         
/*  914 */         if (!paramNodeFormatterContext.isTransformingText() && this.formatterOptions.rightMargin > 0) {
/*      */           BasedSequence basedSequence;
/*  916 */           int i = (basedSequence = paramImage.getUrlContent()).length();
/*  917 */           boolean bool = true;
/*  918 */           paramMarkdownWriter.append('\n');
/*      */           
/*  920 */           for (byte b = 0; b < i; b++) {
/*      */             char c;
/*      */             
/*  923 */             switch (c = basedSequence.charAt(b)) {
/*      */               case '\n':
/*      */               case '\r':
/*  926 */                 bool = true;
/*  927 */                 paramMarkdownWriter.append(basedSequence.subSequence(b, b + 1));
/*      */                 break;
/*      */               
/*      */               case ' ':
/*  931 */                 if (bool) {
/*  932 */                   paramMarkdownWriter.append(' ');
/*  933 */                   bool = false;
/*      */                 } 
/*  935 */                 paramMarkdownWriter.append(' ');
/*      */                 break;
/*      */               
/*      */               default:
/*  939 */                 if (bool) {
/*  940 */                   paramMarkdownWriter.append(' ');
/*  941 */                   bool = false;
/*      */                 } 
/*  943 */                 paramMarkdownWriter.append(basedSequence.subSequence(b, b + 1));
/*      */                 break;
/*      */             } 
/*      */           } 
/*      */         } else {
/*  948 */           paramMarkdownWriter.append((CharSequence)paramImage.getUrlContent());
/*      */         } 
/*  950 */         paramMarkdownWriter.popOptions();
/*  951 */         paramMarkdownWriter.closePreFormatted();
/*      */         
/*  953 */         paramMarkdownWriter.append(' ');
/*      */       } 
/*      */       
/*  956 */       if (paramImage.getTitleOpeningMarker().isNotNull()) {
/*  957 */         paramMarkdownWriter.append(' ');
/*  958 */         paramMarkdownWriter.append((CharSequence)paramImage.getTitleOpeningMarker());
/*  959 */         if (paramImage.getTitle().isNotNull()) paramMarkdownWriter.appendTranslating((CharSequence)paramImage.getTitle()); 
/*  960 */         paramMarkdownWriter.append((CharSequence)paramImage.getTitleClosingMarker());
/*      */       } 
/*      */       
/*  963 */       paramMarkdownWriter.append((CharSequence)paramImage.getLinkClosingMarker()); return;
/*      */     } 
/*  965 */     paramMarkdownWriter.append((CharSequence)paramImage.getChars());
/*      */   }
/*      */ 
/*      */   
/*      */   private void render(Link paramLink, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  970 */     if (!paramNodeFormatterContext.isTransformingText() && this.formatterOptions.rightMargin > 0 && this.formatterOptions.keepExplicitLinksAtStart) {
/*  971 */       paramMarkdownWriter.append(' ');
/*      */     } else {
/*  973 */       paramMarkdownWriter.lineIf(this.formatterOptions.keepExplicitLinksAtStart);
/*      */     } 
/*      */     
/*  976 */     if (!this.formatterOptions.optimizedInlineRendering || paramNodeFormatterContext.isTransformingText()) {
/*  977 */       paramMarkdownWriter.append((CharSequence)paramLink.getTextOpeningMarker());
/*  978 */       if (!paramNodeFormatterContext.isTransformingText() || paramLink.getFirstChildAny(new Class[] { HtmlInline.class }) != null) {
/*  979 */         if (this.formatterOptions.rightMargin > 0) {
/*      */           
/*  981 */           paramMarkdownWriter.append((CharSequence)paramLink.getText().toMapped(SpaceMapper.toNonBreakSpace));
/*      */         } else {
/*  983 */           paramNodeFormatterContext.renderChildren((Node)paramLink);
/*      */         } 
/*      */       } else {
/*  986 */         paramMarkdownWriter.appendTranslating((CharSequence)paramLink.getText());
/*      */       } 
/*  988 */       paramMarkdownWriter.append((CharSequence)paramLink.getTextClosingMarker());
/*      */       
/*  990 */       paramMarkdownWriter.append((CharSequence)paramLink.getLinkOpeningMarker());
/*  991 */       paramMarkdownWriter.append((CharSequence)paramLink.getUrlOpeningMarker());
/*      */       
/*  993 */       if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
/*  994 */         ResolvedLink resolvedLink = paramNodeFormatterContext.resolveLink(LinkType.LINK, (CharSequence)paramLink.getUrl(), Boolean.FALSE);
/*  995 */         paramMarkdownWriter.appendNonTranslating(resolvedLink.getPageRef());
/*      */         
/*  997 */         if (resolvedLink.getAnchorRef() != null) {
/*  998 */           paramMarkdownWriter.append("#");
/*  999 */           CharSequence charSequence = paramNodeFormatterContext.transformAnchorRef(resolvedLink.getPageRef(), resolvedLink.getAnchorRef());
/* 1000 */           paramMarkdownWriter.append(charSequence);
/*      */         } 
/*      */       } else {
/* 1003 */         CharSequence charSequence = paramNodeFormatterContext.transformNonTranslating(null, (CharSequence)paramLink.getPageRef(), null, null);
/* 1004 */         paramMarkdownWriter.append(charSequence);
/*      */         
/* 1006 */         paramMarkdownWriter.append((CharSequence)paramLink.getAnchorMarker());
/*      */         
/* 1008 */         if (paramLink.getAnchorRef().isNotNull()) {
/* 1009 */           CharSequence charSequence1 = paramNodeFormatterContext.transformAnchorRef((CharSequence)paramLink.getPageRef(), (CharSequence)paramLink.getAnchorRef());
/* 1010 */           if (this.attributeUniquificationIdMap != null && paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED && paramNodeFormatterContext.getMergeContext() != null) {
/* 1011 */             String str = String.valueOf(charSequence1);
/* 1012 */             if (charSequence.length() == 0) {
/* 1013 */               str = this.attributeUniquificationIdMap.getOrDefault(str, str);
/*      */             }
/* 1015 */             paramMarkdownWriter.append(str);
/*      */           } else {
/* 1017 */             paramMarkdownWriter.append(charSequence1);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1022 */       paramMarkdownWriter.append((CharSequence)paramLink.getUrlClosingMarker());
/*      */       
/* 1024 */       if (paramLink.getTitleOpeningMarker().isNotNull()) {
/* 1025 */         paramMarkdownWriter.append(' ');
/* 1026 */         paramMarkdownWriter.append((CharSequence)paramLink.getTitleOpeningMarker());
/* 1027 */         if (paramLink.getTitle().isNotNull()) paramMarkdownWriter.appendTranslating((CharSequence)paramLink.getTitle()); 
/* 1028 */         paramMarkdownWriter.append((CharSequence)paramLink.getTitleClosingMarker());
/*      */       } 
/*      */       
/* 1031 */       paramMarkdownWriter.append((CharSequence)paramLink.getLinkClosingMarker()); return;
/*      */     } 
/* 1033 */     paramMarkdownWriter.append((CharSequence)paramLink.getChars());
/*      */   }
/*      */ 
/*      */   
/*      */   private void render(ImageRef paramImageRef, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 1038 */     if (!this.formatterOptions.optimizedInlineRendering || paramNodeFormatterContext.isTransformingText()) {
/* 1039 */       if (paramNodeFormatterContext.isTransformingText() || this.formatterOptions.rightMargin == 0) {
/* 1040 */         if (paramImageRef.isReferenceTextCombined()) {
/* 1041 */           paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceOpeningMarker());
/* 1042 */           paramMarkdownWriter.appendTranslating((CharSequence)paramImageRef.getReference());
/* 1043 */           paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceClosingMarker());
/*      */           
/* 1045 */           paramMarkdownWriter.append((CharSequence)paramImageRef.getTextOpeningMarker());
/* 1046 */           paramMarkdownWriter.append((CharSequence)paramImageRef.getTextClosingMarker()); return;
/*      */         } 
/* 1048 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getTextOpeningMarker());
/* 1049 */         appendReference((CharSequence)paramImageRef.getText(), paramNodeFormatterContext, paramMarkdownWriter);
/* 1050 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getTextClosingMarker());
/*      */         
/* 1052 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceOpeningMarker());
/* 1053 */         paramMarkdownWriter.appendTranslating((CharSequence)paramImageRef.getReference());
/* 1054 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceClosingMarker());
/*      */         return;
/*      */       } 
/* 1057 */       if (paramImageRef.isReferenceTextCombined()) {
/* 1058 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceOpeningMarker());
/* 1059 */         if (paramImageRef.isOrDescendantOfType(new Class[] { Paragraph.class })) {
/* 1060 */           paramMarkdownWriter.append((CharSequence)paramImageRef.getReference().toMapped(SpaceMapper.toNonBreakSpace));
/*      */         } else {
/* 1062 */           paramMarkdownWriter.append((CharSequence)paramImageRef.getReference());
/*      */         } 
/* 1064 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceClosingMarker());
/*      */         
/* 1066 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getTextOpeningMarker());
/* 1067 */         paramMarkdownWriter.append((CharSequence)paramImageRef.getTextClosingMarker()); return;
/*      */       } 
/* 1069 */       paramMarkdownWriter.append((CharSequence)paramImageRef.getTextOpeningMarker());
/* 1070 */       paramNodeFormatterContext.renderChildren((Node)paramImageRef);
/* 1071 */       paramMarkdownWriter.append((CharSequence)paramImageRef.getTextClosingMarker());
/*      */       
/* 1073 */       paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceOpeningMarker());
/* 1074 */       paramMarkdownWriter.append((CharSequence)paramImageRef.getReference());
/* 1075 */       paramMarkdownWriter.append((CharSequence)paramImageRef.getReferenceClosingMarker());
/*      */       
/*      */       return;
/*      */     } 
/* 1079 */     paramMarkdownWriter.append((CharSequence)paramImageRef.getChars());
/*      */   }
/*      */ 
/*      */   
/*      */   private void render(LinkRef paramLinkRef, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 1084 */     if (!this.formatterOptions.optimizedInlineRendering || paramNodeFormatterContext.isTransformingText()) {
/* 1085 */       if (paramNodeFormatterContext.isTransformingText() || this.formatterOptions.rightMargin == 0) {
/* 1086 */         if (paramLinkRef.isReferenceTextCombined()) {
/* 1087 */           paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceOpeningMarker());
/* 1088 */           FormatterUtils.appendWhiteSpaceBetween(paramMarkdownWriter, paramLinkRef.getReferenceOpeningMarker(), paramLinkRef.getReference(), true, false, false);
/* 1089 */           appendReference((CharSequence)paramLinkRef.getReference(), paramNodeFormatterContext, paramMarkdownWriter);
/* 1090 */           paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceClosingMarker());
/*      */           
/* 1092 */           paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextOpeningMarker());
/* 1093 */           paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextClosingMarker()); return;
/*      */         } 
/* 1095 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextOpeningMarker());
/* 1096 */         if (!paramNodeFormatterContext.isTransformingText() || paramLinkRef.getFirstChildAny(new Class[] { HtmlInline.class }) != null) {
/* 1097 */           paramNodeFormatterContext.renderChildren((Node)paramLinkRef);
/*      */         } else {
/* 1099 */           appendReference((CharSequence)paramLinkRef.getText(), paramNodeFormatterContext, paramMarkdownWriter);
/*      */         } 
/* 1101 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextClosingMarker());
/*      */         
/* 1103 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceOpeningMarker());
/* 1104 */         FormatterUtils.appendWhiteSpaceBetween(paramMarkdownWriter, paramLinkRef.getReferenceOpeningMarker(), paramLinkRef.getReference(), true, false, false);
/* 1105 */         paramMarkdownWriter.appendTranslating((CharSequence)paramLinkRef.getReference());
/* 1106 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceClosingMarker());
/*      */         return;
/*      */       } 
/* 1109 */       if (paramLinkRef.isReferenceTextCombined()) {
/* 1110 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceOpeningMarker());
/* 1111 */         if (paramLinkRef.isOrDescendantOfType(new Class[] { Paragraph.class })) {
/* 1112 */           paramMarkdownWriter.append((CharSequence)paramLinkRef.getReference().toMapped(SpaceMapper.toNonBreakSpace));
/*      */         } else {
/* 1114 */           paramMarkdownWriter.append((CharSequence)paramLinkRef.getReference());
/*      */         } 
/* 1116 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceClosingMarker());
/*      */         
/* 1118 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextOpeningMarker());
/* 1119 */         paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextClosingMarker()); return;
/*      */       } 
/* 1121 */       paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextOpeningMarker());
/* 1122 */       paramNodeFormatterContext.renderChildren((Node)paramLinkRef);
/* 1123 */       paramMarkdownWriter.append((CharSequence)paramLinkRef.getTextClosingMarker());
/*      */       
/* 1125 */       paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceOpeningMarker());
/* 1126 */       paramMarkdownWriter.append((CharSequence)paramLinkRef.getReference());
/* 1127 */       paramMarkdownWriter.append((CharSequence)paramLinkRef.getReferenceClosingMarker());
/*      */       
/*      */       return;
/*      */     } 
/* 1131 */     paramMarkdownWriter.append((CharSequence)paramLinkRef.getChars());
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\internal\CoreNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */