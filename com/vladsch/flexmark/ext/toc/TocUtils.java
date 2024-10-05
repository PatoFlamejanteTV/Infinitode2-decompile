/*     */ package com.vladsch.flexmark.ext.toc;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Heading;
/*     */ import com.vladsch.flexmark.ext.toc.internal.SimTocOptionsParser;
/*     */ import com.vladsch.flexmark.ext.toc.internal.TocOptions;
/*     */ import com.vladsch.flexmark.ext.toc.internal.TocOptionsParser;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import com.vladsch.flexmark.util.misc.DelimitedBuilder;
/*     */ import com.vladsch.flexmark.util.misc.Extension;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.misc.Paired;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Escaping;
/*     */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ 
/*     */ public class TocUtils {
/*  37 */   public static final AttributablePart TOC_CONTENT = new AttributablePart("TOC_CONTENT");
/*  38 */   public static final AttributablePart TOC_LIST = new AttributablePart("TOC_LIST");
/*     */   
/*     */   public static String getTocPrefix(TocOptions paramTocOptions1, TocOptions paramTocOptions2) {
/*     */     DelimitedBuilder delimitedBuilder;
/*  42 */     (delimitedBuilder = new DelimitedBuilder(" ")).append("[TOC").mark();
/*     */     
/*  44 */     TocOptionsParser tocOptionsParser = new TocOptionsParser();
/*  45 */     delimitedBuilder.append(tocOptionsParser.getOptionText(paramTocOptions1, paramTocOptions2));
/*  46 */     delimitedBuilder.unmark().append("]");
/*  47 */     delimitedBuilder.append("\n").unmark();
/*  48 */     return delimitedBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String getSimTocPrefix(TocOptions paramTocOptions1, TocOptions paramTocOptions2) {
/*     */     DelimitedBuilder delimitedBuilder;
/*  53 */     (delimitedBuilder = new DelimitedBuilder(" ")).append("[TOC").mark();
/*     */     
/*  55 */     SimTocOptionsParser simTocOptionsParser = new SimTocOptionsParser();
/*  56 */     delimitedBuilder.append(simTocOptionsParser.getOptionText(paramTocOptions1, paramTocOptions2));
/*  57 */     delimitedBuilder.unmark().append("]:").mark().append('#').mark();
/*     */     
/*  59 */     String str1 = paramTocOptions1.getTitleHeading();
/*  60 */     String str2 = paramTocOptions1.title;
/*     */     
/*  62 */     if (paramTocOptions2 == null || !str1.equals(paramTocOptions2.getTitleHeading())) {
/*  63 */       if (!str2.isEmpty()) {
/*  64 */         delimitedBuilder.append('"');
/*  65 */         if (paramTocOptions2 == null || paramTocOptions1.titleLevel != paramTocOptions2.titleLevel) {
/*  66 */           delimitedBuilder.append(str1.trim().replace("\\", "\\\\").replace("\"", "\\\""));
/*     */         } else {
/*  68 */           delimitedBuilder.append(str2.trim().replace("\\", "\\\\").replace("\"", "\\\""));
/*     */         } 
/*  70 */         delimitedBuilder.append('"').mark();
/*     */       } else {
/*  72 */         delimitedBuilder.append("\"\"").mark();
/*     */       } 
/*     */     }
/*     */     
/*  76 */     delimitedBuilder.unmark().append("\n").unmark();
/*  77 */     return delimitedBuilder.toString(); } public static void renderTocContent(MarkdownWriter paramMarkdownWriter, TocOptions paramTocOptions1, TocOptions paramTocOptions2, List<Heading> paramList, List<String> paramList1) {
/*     */     Document document1;
/*     */     byte b;
/*     */     Node node;
/*  81 */     if (paramList.isEmpty())
/*     */       return; 
/*  83 */     Document document2 = ((Heading)paramList.get(0)).getDocument();
/*     */     
/*  85 */     if (paramTocOptions1.isHtml) {
/*  86 */       MarkdownWriter markdownWriter = new MarkdownWriter(paramMarkdownWriter.getOptions());
/*  87 */       for (Heading heading : paramList) {
/*  88 */         ((MarkdownWriter)markdownWriter.append((CharSequence)heading.getChars())).line();
/*     */       }
/*  90 */       markdownWriter.append(getTocPrefix(paramTocOptions1, paramTocOptions2));
/*     */       
/*  92 */       MutableDataSet mutableDataSet = new MutableDataSet((DataHolder)document2);
/*  93 */       paramTocOptions2.setIn((MutableDataHolder)mutableDataSet);
/*  94 */       paramTocOptions1.setIn((MutableDataHolder)mutableDataSet);
/*     */       
/*  96 */       if (!mutableDataSet.contains((DataKeyBase)HtmlRenderer.INDENT_SIZE)) mutableDataSet.set(HtmlRenderer.INDENT_SIZE, Integer.valueOf(2)); 
/*  97 */       mutableDataSet.set(HtmlRenderer.RENDER_HEADER_ID, Boolean.FALSE);
/*  98 */       mutableDataSet.set(HtmlRenderer.GENERATE_HEADER_ID, Boolean.FALSE);
/*     */       
/*     */       ArrayList<?> arrayList;
/* 101 */       (arrayList = new ArrayList((Collection)Parser.EXTENSIONS.get((DataHolder)mutableDataSet))).removeIf(paramExtension -> paramExtension instanceof SimTocExtension);
/* 102 */       arrayList.add(TocExtension.create());
/* 103 */       mutableDataSet.set(Parser.EXTENSIONS, arrayList);
/*     */       
/* 105 */       Parser parser = Parser.builder((DataHolder)mutableDataSet).build();
/* 106 */       HtmlRenderer htmlRenderer = HtmlRenderer.builder((DataHolder)mutableDataSet).build();
/*     */       
/* 108 */       document1 = parser.parse(markdownWriter.toString());
/*     */       
/* 110 */       b = 0;
/* 111 */       for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = document1.getChildren().iterator(); reversiblePeekingIterator.hasNext();) {
/* 112 */         if (node1 = reversiblePeekingIterator.next() instanceof Heading) {
/* 113 */           ((Heading)node1).setAnchorRefId(((Heading)paramList.get(b)).getAnchorRefId());
/* 114 */           b++;
/*     */         } 
/*     */       } 
/*     */       
/* 118 */       node = document1.getFirstChildAny(new Class[] { TocBlock.class });
/* 119 */       assert node != null;
/*     */       
/* 121 */       paramMarkdownWriter.openPreFormatted(false);
/* 122 */       htmlRenderer.render(node, (Appendable)paramMarkdownWriter);
/* 123 */       paramMarkdownWriter.closePreFormatted(); return;
/*     */     } 
/*     */     String str;
/* 126 */     if (!(str = document1.getTitleHeading()).isEmpty()) {
/* 127 */       paramMarkdownWriter.append(str);
/*     */     }
/*     */     
/* 130 */     if (((ParserEmulationProfile)Parser.PARSER_EMULATION_PROFILE.get((DataHolder)node)).family == ParserEmulationProfile.FIXED_INDENT) {
/* 131 */       paramMarkdownWriter.setIndentPrefix(RepeatedSequence.ofSpaces(4));
/*     */     } else {
/* 133 */       paramMarkdownWriter.setIndentPrefix(RepeatedSequence.ofSpaces(((TocOptions)document1).isNumbered ? 3 : 2));
/*     */     } 
/*     */     
/* 136 */     renderMarkdownToc(paramMarkdownWriter, (List<Integer>)paramList.stream().map(Heading::getLevel).collect(Collectors.toList()), b, (TocOptions)document1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderHtmlToc(HtmlWriter paramHtmlWriter, BasedSequence paramBasedSequence, List<Integer> paramList, List<String> paramList1, List<String> paramList2, TocOptions paramTocOptions) {
/* 141 */     if (paramList.size() > 0 && (paramBasedSequence.isNotNull() || !paramTocOptions.title.trim().isEmpty())) {
/* 142 */       if (paramBasedSequence.isNotNull()) paramHtmlWriter.srcPos(paramBasedSequence); 
/* 143 */       ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("class", paramTocOptions.divClass)).withAttr(TOC_CONTENT).tag("div")).line()).indent();
/* 144 */       if (!paramTocOptions.title.trim().isEmpty()) {
/* 145 */         ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.tag("h" + paramTocOptions.titleLevel)).text(paramTocOptions.title)).tag("/h" + paramTocOptions.titleLevel)).line();
/*     */       }
/*     */     } 
/*     */     
/* 149 */     byte b1 = -1;
/* 150 */     byte b2 = -1;
/* 151 */     String str1 = paramTocOptions.isNumbered ? "ol" : "ul";
/* 152 */     String str2 = "/" + str1;
/* 153 */     boolean[] arrayOfBoolean1 = new boolean[7];
/* 154 */     boolean[] arrayOfBoolean2 = new boolean[7];
/* 155 */     int[] arrayOfInt = new int[7];
/*     */     byte b3;
/* 157 */     for (b3 = 0; b3 < paramList.size(); b3++) {
/* 158 */       String str3 = paramList1.get(b3);
/* 159 */       byte b = (paramTocOptions.listType != TocOptions.ListType.HIERARCHY) ? 1 : ((Integer)paramList.get(b3)).intValue();
/*     */       
/* 161 */       if (b1 == -1) {
/* 162 */         b1 = b;
/* 163 */         b2 = b;
/* 164 */         ((HtmlWriter)((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("class", paramTocOptions.listClass)).withAttr(TOC_LIST).line()).tag(str1)).indent()).line();
/* 165 */         arrayOfBoolean2[0] = true;
/*     */       } 
/*     */       
/* 168 */       if (b2 < b) {
/* 169 */         for (byte b4 = b2; b4 < b; b4++) {
/* 170 */           arrayOfBoolean1[b4 + 1] = false;
/* 171 */           arrayOfBoolean2[b4 + 1] = false;
/*     */         } 
/*     */         
/* 174 */         if (!arrayOfBoolean2[b2]) {
/* 175 */           ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.withAttr().indent()).line()).tag(str1)).indent();
/* 176 */           arrayOfBoolean2[b2] = true;
/*     */         } 
/* 178 */       } else if (b2 == b) {
/* 179 */         if (arrayOfBoolean1[b2]) {
/* 180 */           if (arrayOfBoolean2[b2]) ((HtmlWriter)((HtmlWriter)paramHtmlWriter.unIndent()).tag(str2)).line(); 
/* 181 */           ((HtmlWriter)((HtmlWriter)paramHtmlWriter.lineIf((arrayOfInt[b2] != paramHtmlWriter.offsetWithPending()))).tag("/li")).line();
/*     */         } 
/* 183 */         arrayOfBoolean1[b2] = false;
/* 184 */         arrayOfBoolean2[b2] = false;
/*     */       } else {
/*     */         
/* 187 */         for (byte b4 = b2; b4 >= b; b4--) {
/* 188 */           if (arrayOfBoolean1[b4]) {
/* 189 */             if (arrayOfBoolean2[b4]) ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.unIndent()).tag(str2)).unIndent()).line(); 
/* 190 */             ((HtmlWriter)((HtmlWriter)paramHtmlWriter.lineIf((arrayOfInt[b2] != paramHtmlWriter.offsetWithPending()))).tag("/li")).line();
/*     */           } 
/* 192 */           arrayOfBoolean1[b4] = false;
/* 193 */           arrayOfBoolean2[b4] = false;
/*     */         } 
/*     */       } 
/*     */       
/* 197 */       ((HtmlWriter)paramHtmlWriter.line()).tag("li");
/* 198 */       arrayOfBoolean1[b] = true;
/*     */       String str4;
/* 200 */       if ((str4 = paramList2.get(b3)) == null || str4.isEmpty()) {
/* 201 */         paramHtmlWriter.raw(str3);
/*     */       } else {
/* 203 */         ((HtmlWriter)paramHtmlWriter.attr("href", "#" + str4)).withAttr().tag("a");
/* 204 */         paramHtmlWriter.raw(str3);
/* 205 */         paramHtmlWriter.tag("/a");
/*     */       } 
/*     */       
/* 208 */       b2 = b;
/* 209 */       arrayOfInt[b] = paramHtmlWriter.offsetWithPending();
/*     */     } 
/*     */     
/* 212 */     for (b3 = b2; b3 > 0; b3--) {
/* 213 */       if (arrayOfBoolean1[b3]) {
/* 214 */         if (arrayOfBoolean2[b3]) ((HtmlWriter)((HtmlWriter)((HtmlWriter)paramHtmlWriter.unIndent()).tag(str2)).unIndent()).line(); 
/* 215 */         ((HtmlWriter)((HtmlWriter)paramHtmlWriter.lineIf((arrayOfInt[b2] != paramHtmlWriter.offsetWithPending()))).tag("/li")).line();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 220 */     if (arrayOfBoolean2[0]) ((HtmlWriter)((HtmlWriter)paramHtmlWriter.unIndent()).tag(str2)).line();
/*     */     
/* 222 */     if (paramList.size() > 0 && (paramBasedSequence.isNotNull() || !paramTocOptions.title.trim().isEmpty())) {
/* 223 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.line()).unIndent()).tag("/div");
/*     */     }
/*     */     
/* 226 */     paramHtmlWriter.line();
/*     */   }
/*     */   
/*     */   public static List<Heading> filteredHeadings(List<Heading> paramList, TocOptions paramTocOptions) {
/* 230 */     ArrayList<Heading> arrayList = new ArrayList(paramList.size());
/*     */     
/* 232 */     for (Heading heading : paramList) {
/* 233 */       if (paramTocOptions.isLevelIncluded(heading.getLevel()) && !(heading.getParent() instanceof SimTocContent)) {
/* 234 */         arrayList.add(heading);
/*     */       }
/*     */     } 
/*     */     
/* 238 */     return arrayList;
/*     */   }
/*     */   
/*     */   public static Paired<List<Heading>, List<String>> htmlHeadingTexts(NodeRendererContext paramNodeRendererContext, List<Heading> paramList, TocOptions paramTocOptions) {
/* 242 */     ArrayList<String> arrayList = new ArrayList(paramList.size());
/* 243 */     boolean bool1 = (paramTocOptions.listType == TocOptions.ListType.SORTED_REVERSED || paramTocOptions.listType == TocOptions.ListType.FLAT_REVERSED) ? true : false;
/* 244 */     boolean bool2 = (paramTocOptions.listType == TocOptions.ListType.SORTED || paramTocOptions.listType == TocOptions.ListType.SORTED_REVERSED) ? true : false;
/*     */     boolean bool3;
/* 246 */     HashMap<String, Heading> hashMap = !(bool3 = (bool1 || bool2) ? true : false) ? null : new HashMap<>(paramList.size());
/* 247 */     HashMap<String, String> hashMap1 = (!bool3 || paramTocOptions.isTextOnly) ? null : new HashMap<>(paramList.size());
/*     */     
/* 249 */     for (Heading heading : paramList) {
/*     */       String str;
/*     */       
/* 252 */       if (paramTocOptions.isTextOnly) {
/* 253 */         str = getHeadingText(heading);
/*     */       } else {
/* 255 */         str = getHeadingContent(paramNodeRendererContext, heading);
/*     */         
/* 257 */         if (bool3) {
/* 258 */           hashMap1.put(str, getHeadingText(heading));
/*     */         }
/*     */       } 
/*     */       
/* 262 */       if (bool3) {
/* 263 */         hashMap.put(str, heading);
/*     */       }
/*     */       
/* 266 */       arrayList.add(str);
/*     */     } 
/*     */     
/* 269 */     if (bool2 || bool1) {
/* 270 */       if (paramTocOptions.isTextOnly) {
/* 271 */         if (bool2) {
/* 272 */           arrayList.sort((paramString1, paramString2) -> paramBoolean ? paramString2.compareTo(paramString1) : paramString1.compareTo(paramString2));
/*     */         } else {
/* 274 */           Collections.reverse(arrayList);
/*     */         }
/*     */       
/* 277 */       } else if (bool2) {
/* 278 */         arrayList.sort((paramString1, paramString2) -> {
/*     */               paramString1 = (String)paramHashMap.get(paramString1);
/*     */               String str = (String)paramHashMap.get(paramString2);
/*     */               return paramBoolean ? str.compareTo(paramString1) : paramString1.compareTo(str);
/*     */             });
/*     */       } else {
/* 284 */         Collections.reverse(arrayList);
/*     */       } 
/*     */ 
/*     */       
/* 288 */       paramList = new ArrayList<>();
/* 289 */       for (String str : arrayList) {
/* 290 */         paramList.add(hashMap.get(str));
/*     */       }
/*     */     } 
/*     */     
/* 294 */     return (Paired<List<Heading>, List<String>>)Pair.of(paramList, arrayList);
/*     */   }
/*     */   
/*     */   private static String getHeadingText(Heading paramHeading) {
/* 298 */     return Escaping.escapeHtml((new TextCollectingVisitor()).collectAndGetText((Node)paramHeading), false);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getHeadingContent(NodeRendererContext paramNodeRendererContext, Heading paramHeading) {
/* 303 */     (paramNodeRendererContext = paramNodeRendererContext.getSubContext(false)).doNotRenderLinks();
/* 304 */     paramNodeRendererContext.renderChildren((Node)paramHeading);
/* 305 */     return paramNodeRendererContext.getHtmlWriter().toString(-1, -1);
/*     */   }
/*     */   
/*     */   public static Pair<List<Heading>, List<String>> markdownHeaderTexts(List<Heading> paramList, TocOptions paramTocOptions) {
/* 309 */     ArrayList<String> arrayList = new ArrayList(paramList.size());
/* 310 */     boolean bool1 = (paramTocOptions.listType == TocOptions.ListType.SORTED_REVERSED || paramTocOptions.listType == TocOptions.ListType.FLAT_REVERSED) ? true : false;
/* 311 */     boolean bool2 = (paramTocOptions.listType == TocOptions.ListType.SORTED || paramTocOptions.listType == TocOptions.ListType.SORTED_REVERSED) ? true : false;
/*     */     boolean bool3;
/* 313 */     HashMap<String, Heading> hashMap = !(bool3 = (bool1 || bool2) ? true : false) ? null : new HashMap<>(paramList.size());
/* 314 */     HashMap<String, String> hashMap1 = (!bool3 || paramTocOptions.isTextOnly) ? null : new HashMap<>(paramList.size());
/*     */     
/* 316 */     for (Heading heading : paramList) {
/*     */ 
/*     */       
/* 319 */       String str1, str2 = (paramTocOptions.isTextOnly || bool3) ? (new TextCollectingVisitor()).collectAndGetText((Node)heading) : "";
/*     */       
/* 321 */       if (paramTocOptions.isTextOnly) {
/* 322 */         str1 = str2;
/*     */       } else {
/* 324 */         str1 = heading.getText().toString();
/*     */       } 
/*     */       
/*     */       String str3;
/*     */       
/* 329 */       if ((str3 = heading.getAnchorRefId()) == null || str1.isEmpty()) {
/* 330 */         str1 = str1;
/*     */       } else {
/* 332 */         str1 = "[" + str1 + "](#" + str3 + ")";
/*     */       } 
/*     */       
/* 335 */       if (bool3) {
/* 336 */         if (!paramTocOptions.isTextOnly) hashMap1.put(str1, str2); 
/* 337 */         hashMap.put(str1, heading);
/*     */       } 
/*     */       
/* 340 */       arrayList.add(str1);
/*     */     } 
/*     */     
/* 343 */     if (bool2 || bool1) {
/* 344 */       if (paramTocOptions.isTextOnly) {
/* 345 */         if (bool2) {
/* 346 */           arrayList.sort((paramString1, paramString2) -> paramBoolean ? paramString2.compareTo(paramString1) : paramString1.compareTo(paramString2));
/*     */         } else {
/* 348 */           Collections.reverse(arrayList);
/*     */         }
/*     */       
/* 351 */       } else if (bool2) {
/* 352 */         arrayList.sort((paramString1, paramString2) -> {
/*     */               paramString1 = (String)paramHashMap.get(paramString1);
/*     */               String str = (String)paramHashMap.get(paramString2);
/*     */               return paramBoolean ? str.compareTo(paramString1) : paramString1.compareTo(str);
/*     */             });
/*     */       } else {
/* 358 */         Collections.reverse(arrayList);
/*     */       } 
/*     */ 
/*     */       
/* 362 */       paramList = new ArrayList<>();
/* 363 */       for (String str : arrayList) {
/* 364 */         paramList.add(hashMap.get(str));
/*     */       }
/*     */     } 
/*     */     
/* 368 */     return Pair.of(paramList, arrayList);
/*     */   }
/*     */   
/*     */   public static void renderMarkdownToc(MarkdownWriter paramMarkdownWriter, List<Integer> paramList, List<String> paramList1, TocOptions paramTocOptions) {
/* 372 */     byte b1 = -1;
/* 373 */     byte b2 = -1;
/* 374 */     boolean[] arrayOfBoolean1 = new boolean[7];
/* 375 */     boolean[] arrayOfBoolean2 = new boolean[7];
/* 376 */     int[] arrayOfInt = new int[7];
/*     */     byte b3;
/* 378 */     for (b3 = 0; b3 < paramList.size(); b3++) {
/* 379 */       String str = paramList1.get(b3);
/* 380 */       byte b = (paramTocOptions.listType != TocOptions.ListType.HIERARCHY) ? 1 : ((Integer)paramList.get(b3)).intValue();
/*     */       
/* 382 */       if (b1 == -1) {
/* 383 */         b1 = b;
/* 384 */         b2 = b;
/* 385 */         paramMarkdownWriter.line();
/* 386 */         arrayOfBoolean2[0] = true;
/*     */       } 
/*     */       
/* 389 */       if (b2 < b) {
/* 390 */         for (byte b4 = b2; b4 < b; b4++) {
/* 391 */           arrayOfBoolean1[b4 + 1] = false;
/* 392 */           arrayOfBoolean2[b4 + 1] = false;
/*     */         } 
/*     */         
/* 395 */         if (!arrayOfBoolean2[b2]) {
/* 396 */           paramMarkdownWriter.indent();
/* 397 */           arrayOfBoolean2[b2] = true;
/*     */         } 
/* 399 */       } else if (b2 == b) {
/* 400 */         if (arrayOfBoolean1[b2]) {
/* 401 */           if (arrayOfBoolean2[b2]) paramMarkdownWriter.unIndent(); 
/* 402 */           ((MarkdownWriter)paramMarkdownWriter.lineIf((arrayOfInt[b2] != paramMarkdownWriter.offsetWithPending()))).line();
/*     */         } 
/* 404 */         arrayOfBoolean1[b2] = false;
/* 405 */         arrayOfBoolean2[b2] = false;
/*     */       } else {
/*     */         
/* 408 */         for (byte b4 = b2; b4 >= b; b4--) {
/* 409 */           if (arrayOfBoolean1[b4]) {
/* 410 */             if (arrayOfBoolean2[b4]) paramMarkdownWriter.unIndent(); 
/* 411 */             ((MarkdownWriter)paramMarkdownWriter.lineIf((arrayOfInt[b2] != paramMarkdownWriter.offsetWithPending()))).line();
/*     */           } 
/* 413 */           arrayOfBoolean1[b4] = false;
/* 414 */           arrayOfBoolean2[b4] = false;
/*     */         } 
/*     */       } 
/*     */       
/* 418 */       ((MarkdownWriter)paramMarkdownWriter.line()).append(paramTocOptions.isNumbered ? "1. " : "- ");
/* 419 */       arrayOfBoolean1[b] = true;
/* 420 */       paramMarkdownWriter.append(str);
/* 421 */       b2 = b;
/* 422 */       arrayOfInt[b] = paramMarkdownWriter.offsetWithPending();
/*     */     } 
/*     */     
/* 425 */     for (b3 = b2; b3 > 0; b3--) {
/* 426 */       if (arrayOfBoolean1[b3]) {
/* 427 */         if (arrayOfBoolean2[b3]) paramMarkdownWriter.unIndent(); 
/* 428 */         ((MarkdownWriter)paramMarkdownWriter.lineIf((arrayOfInt[b2] != paramMarkdownWriter.offsetWithPending()))).line();
/*     */       } 
/*     */     } 
/*     */     
/* 432 */     paramMarkdownWriter.line();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\TocUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */