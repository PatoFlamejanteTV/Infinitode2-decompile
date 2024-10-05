/*     */ package com.vladsch.flexmark.ext.attributes.internal;
/*     */ import com.vladsch.flexmark.ast.AnchorRefTarget;
/*     */ import com.vladsch.flexmark.ext.attributes.AttributeImplicitName;
/*     */ import com.vladsch.flexmark.ext.attributes.AttributeNode;
/*     */ import com.vladsch.flexmark.ext.attributes.AttributesNode;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.RenderPurpose;
/*     */ import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class AttributesNodeFormatter implements ExplicitAttributeIdProvider, PhasedNodeFormatter {
/*  27 */   public static final DataKey<Map<String, String>> ATTRIBUTE_TRANSLATION_MAP = new DataKey("ATTRIBUTE_TRANSLATION_MAP", HashMap::new);
/*  28 */   public static final DataKey<Map<String, String>> ATTRIBUTE_TRANSLATED_MAP = new DataKey("ATTRIBUTE_TRANSLATED_MAP", HashMap::new);
/*  29 */   public static final DataKey<Map<String, String>> ATTRIBUTE_ORIGINAL_ID_MAP = new DataKey("ATTRIBUTE_ORIGINAL_ID_MAP", HashMap::new);
/*  30 */   public static final DataKey<Set<Node>> PROCESSED_ATTRIBUTES = new DataKey("PROCESSED_ATTRIBUTES", HashSet::new);
/*     */ 
/*     */   
/*  33 */   public static final DataKey<Map<String, String>> ATTRIBUTE_UNIQUIFICATION_ID_MAP = Formatter.ATTRIBUTE_UNIQUIFICATION_ID_MAP;
/*     */   
/*  35 */   public static final DataKey<Map<String, String>> ATTRIBUTE_UNIQUIFICATION_CATEGORY_MAP = new DataKey("ATTRIBUTE_UNIQUIFICATION_CATEGORY_MAP", HashMap::new);
/*  36 */   public static final DataKey<Integer> ATTRIBUTE_TRANSLATION_ID = new DataKey("ATTRIBUTE_TRANSLATION_ID", Integer.valueOf(0));
/*     */   
/*     */   private Map<String, String> attributeTranslationMap;
/*     */   private Map<String, String> attributeTranslatedMap;
/*     */   private Map<String, String> attributeOriginalIdMap;
/*     */   private Map<String, String> attributeUniquificationIdMap;
/*     */   private int attributeOriginalId;
/*     */   private final AttributesFormatOptions formatOptions;
/*     */   
/*     */   public AttributesNodeFormatter(DataHolder paramDataHolder) {
/*  46 */     this.formatOptions = new AttributesFormatOptions(paramDataHolder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Class<?>> getNodeClasses() {
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<FormattingPhase> getFormattingPhases() {
/*  58 */     return Collections.singleton(FormattingPhase.COLLECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addExplicitId(Node paramNode, String paramString, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  63 */     if (paramString != null && paramNode instanceof com.vladsch.flexmark.ast.Heading)
/*     */     {
/*  65 */       if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED && 
/*  66 */         hasNoIdAttribute(paramNode) && this.attributeUniquificationIdMap != null) {
/*     */         String str;
/*     */         
/*  69 */         if (!(str = this.attributeUniquificationIdMap.getOrDefault(paramString, paramString)).equals(paramString)) {
/*  70 */           paramMarkdownWriter.append(" {.");
/*  71 */           paramMarkdownWriter.append(str);
/*  72 */           paramMarkdownWriter.append("}");
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   boolean hasNoIdAttribute(Node paramNode) {
/*  80 */     boolean bool = false;
/*     */     
/*  82 */     for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramNode.getChildren().iterator(); reversiblePeekingIterator.hasNext();) {
/*  83 */       if (node = reversiblePeekingIterator.next() instanceof AttributesNode) {
/*  84 */         for (ReversiblePeekingIterator<Node> reversiblePeekingIterator1 = node.getChildren().iterator(); reversiblePeekingIterator1.hasNext();) {
/*  85 */           if (node1 = reversiblePeekingIterator1.next() instanceof AttributeNode && (
/*  86 */             (AttributeNode)node1).isId()) {
/*  87 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*  92 */         if (!bool)
/*     */           continue;  break;
/*     */       } 
/*  95 */     }  return !bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderDocument(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument, FormattingPhase paramFormattingPhase) {
/* 101 */     if (paramNodeFormatterContext.isTransformingText()) {
/* 102 */       paramNodeFormatterContext.getTranslationStore().set(ATTRIBUTE_TRANSLATION_ID, Integer.valueOf(0));
/* 103 */       this.attributeOriginalId = 0;
/*     */       
/* 105 */       if (paramFormattingPhase == FormattingPhase.COLLECT) {
/*     */         
/* 107 */         paramNodeFormatterContext.getDocument().remove((DataKeyBase)PROCESSED_ATTRIBUTES);
/*     */ 
/*     */         
/* 110 */         paramNodeFormatterContext.getTranslationStore().set(ATTRIBUTE_TRANSLATION_MAP, new HashMap<>());
/* 111 */         paramNodeFormatterContext.getTranslationStore().set(ATTRIBUTE_TRANSLATED_MAP, new HashMap<>());
/* 112 */         paramNodeFormatterContext.getTranslationStore().set(ATTRIBUTE_ORIGINAL_ID_MAP, new HashMap<>());
/*     */         
/*     */         MergeContext mergeContext;
/* 115 */         if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS && (mergeContext = paramNodeFormatterContext.getMergeContext()) != null) {
/*     */           
/* 117 */           final HashSet mergedUniquified = new HashSet();
/*     */ 
/*     */           
/* 120 */           mergeContext.forEachPrecedingDocument(paramDocument, (paramTranslationContext, paramDocument2, paramInt) -> {
/*     */                 NodeAttributeRepository nodeAttributeRepository = (NodeAttributeRepository)AttributesExtension.NODE_ATTRIBUTES.get((DataHolder)paramDocument2);
/*     */                 
/*     */                 final Map idUniquificationMap = (Map)ATTRIBUTE_UNIQUIFICATION_ID_MAP.get((DataHolder)paramTranslationContext.getTranslationStore());
/*     */                 
/*     */                 Iterator<ArrayList<AttributesNode>> iterator = nodeAttributeRepository.values().iterator();
/*     */                 
/*     */                 while (iterator.hasNext()) {
/*     */                   List<?> list;
/*     */                   Iterator<?> iterator1 = (list = iterator.next()).iterator();
/*     */                   while (iterator1.hasNext()) {
/*     */                     AttributesNode attributesNode;
/*     */                     ReversiblePeekingIterator<Node> reversiblePeekingIterator = (attributesNode = (AttributesNode)iterator1.next()).getChildren().iterator();
/*     */                     while (reversiblePeekingIterator.hasNext()) {
/*     */                       Node node;
/*     */                       AttributeNode attributeNode;
/*     */                       if (node = reversiblePeekingIterator.next() instanceof AttributeNode && (attributeNode = (AttributeNode)node).isId()) {
/*     */                         String str = attributeNode.getValue().toString();
/*     */                         str = (String)map.getOrDefault(str, str);
/*     */                         if (!paramHashSet.contains(str)) {
/*     */                           paramHashSet.add(str);
/*     */                         }
/*     */                       } 
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */                 final HtmlIdGenerator generator;
/*     */                 if ((htmlIdGenerator = paramNodeFormatterContext.getIdGenerator()) != null) {
/*     */                   (new AnchorRefTargetBlockVisitor()
/*     */                     {
/*     */                       protected void visit(AnchorRefTarget param1AnchorRefTarget)
/*     */                       {
/* 152 */                         Node node = (Node)param1AnchorRefTarget;
/* 153 */                         if (AttributesNodeFormatter.this.hasNoIdAttribute(node)) {
/*     */                           String str;
/*     */                           
/* 156 */                           if ((str = generator.getId(node)) == null) {
/* 157 */                             str = param1AnchorRefTarget.getAnchorRefText();
/* 158 */                             str = generator.getId(str);
/* 159 */                             param1AnchorRefTarget.setAnchorRefId(str);
/*     */                           } 
/*     */                           
/* 162 */                           if (str != null) {
/* 163 */                             str = (String)idUniquificationMap.getOrDefault(str, str);
/*     */                             
/* 165 */                             if (!mergedUniquified.contains(str))
/*     */                             {
/*     */                               
/* 168 */                               mergedUniquified.add(str);
/*     */                             }
/*     */                           } 
/*     */                         } 
/*     */                       }
/*     */                     }).visit((Node)paramDocument1);
/*     */                 }
/*     */               });
/*     */ 
/*     */           
/* 178 */           NodeAttributeRepository nodeAttributeRepository = (NodeAttributeRepository)AttributesExtension.NODE_ATTRIBUTES.get((DataHolder)paramDocument);
/* 179 */           final Map idUniquificationMap = (Map)ATTRIBUTE_UNIQUIFICATION_CATEGORY_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/* 180 */           final HashMap<Object, Object> idMap = new HashMap<>();
/*     */           
/* 182 */           for (Iterator<ArrayList<AttributesNode>> iterator = nodeAttributeRepository.values().iterator(); iterator.hasNext();) {
/* 183 */             for (Iterator<?> iterator1 = (list = iterator.next()).iterator(); iterator1.hasNext();) {
/* 184 */               for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = (attributesNode = (AttributesNode)iterator1.next()).getChildren().iterator(); reversiblePeekingIterator.hasNext();) {
/* 185 */                 if (node = reversiblePeekingIterator.next() instanceof AttributeNode && (
/*     */ 
/*     */                   
/* 188 */                   attributeNode = (AttributeNode)node).isId()) {
/*     */                   BasedSequence basedSequence;
/*     */ 
/*     */                   
/* 192 */                   String str2 = (basedSequence = attributeNode.getValue()).toString(), str3 = str2;
/*     */                   
/*     */                   int i;
/* 195 */                   if ((i = basedSequence.indexOf(':')) != -1) {
/* 196 */                     String str5 = basedSequence.subSequence(0, i).toString();
/* 197 */                     String str4 = ((BasedSequence)basedSequence.subSequence(i + 1)).toString();
/*     */ 
/*     */ 
/*     */                     
/* 201 */                     str3 = (String)map.getOrDefault(str5, str5);
/*     */                     
/* 203 */                     str3 = String.format("%s:%s", new Object[] { str3, str4 });
/*     */                   } 
/*     */                   
/* 206 */                   byte b = 0;
/* 207 */                   String str1 = str3;
/*     */                   
/* 209 */                   while (hashSet.contains(str1)) {
/*     */                     
/* 211 */                     str1 = String.format("%s%d", new Object[] { str3, Integer.valueOf(++b) });
/*     */                   } 
/*     */                   
/* 214 */                   if (b > 0 || !str1.equals(str2)) {
/* 215 */                     hashMap.put(str2, str1);
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/*     */           final HtmlIdGenerator generator;
/*     */           
/* 225 */           if ((htmlIdGenerator = paramNodeFormatterContext.getIdGenerator()) != null) {
/* 226 */             (new AnchorRefTargetBlockVisitor()
/*     */               {
/*     */                 protected void visit(AnchorRefTarget param1AnchorRefTarget) {
/* 229 */                   Node node = (Node)param1AnchorRefTarget;
/*     */                   
/* 231 */                   if (AttributesNodeFormatter.this.hasNoIdAttribute(node)) {
/*     */                     String str;
/*     */                     
/* 234 */                     if ((str = generator.getId(node)) == null) {
/* 235 */                       String str1 = param1AnchorRefTarget.getAnchorRefText();
/* 236 */                       str = generator.getId(str1);
/* 237 */                       param1AnchorRefTarget.setAnchorRefId(str);
/*     */                     } 
/*     */                     
/* 240 */                     if (str != null) {
/* 241 */                       byte b = 0;
/* 242 */                       String str1 = str;
/*     */                       
/* 244 */                       while (mergedUniquified.contains(str1)) {
/*     */                         
/* 246 */                         str1 = String.format("%s%d", new Object[] { str, Integer.valueOf(++b) });
/*     */                       } 
/*     */                       
/* 249 */                       if (b > 0 || !str1.equals(str)) {
/* 250 */                         idMap.put(str, str1);
/*     */                       }
/*     */                     } 
/*     */                   } 
/*     */                 }
/* 255 */               }).visit((Node)paramDocument);
/*     */           }
/*     */           
/* 258 */           if (!hashMap.isEmpty()) {
/* 259 */             paramNodeFormatterContext.getTranslationStore().set(ATTRIBUTE_UNIQUIFICATION_ID_MAP, hashMap);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 267 */     this.attributeUniquificationIdMap = (Map<String, String>)ATTRIBUTE_UNIQUIFICATION_ID_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/*     */ 
/*     */     
/* 270 */     this.attributeTranslationMap = (Map<String, String>)ATTRIBUTE_TRANSLATION_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/* 271 */     this.attributeTranslatedMap = (Map<String, String>)ATTRIBUTE_TRANSLATED_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/* 272 */     this.attributeOriginalIdMap = (Map<String, String>)ATTRIBUTE_ORIGINAL_ID_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*     */     HashSet<NodeFormattingHandler> hashSet;
/* 280 */     (hashSet = new HashSet<>()).add(new NodeFormattingHandler(AttributesNode.class, this::render));
/* 281 */     hashSet.add(new NodeFormattingHandler(AttributesDelimiter.class, this::render));
/* 282 */     return (Set)hashSet;
/*     */   }
/*     */   
/*     */   public static String getEncodedIdAttribute(String paramString1, String paramString2, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 286 */     Map<String, String> map1 = (Map)ATTRIBUTE_TRANSLATION_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/* 287 */     Map<String, String> map2 = (Map)ATTRIBUTE_TRANSLATED_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/* 288 */     paramString1 = getEncodedIdAttribute(paramString1, paramString2, paramNodeFormatterContext, paramMarkdownWriter, map1, map2);
/*     */     Map<?, ?> map;
/* 290 */     if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED && 
/*     */       
/* 292 */       !(map = (Map<?, ?>)ATTRIBUTE_UNIQUIFICATION_ID_MAP.get((DataHolder)paramNodeFormatterContext.getTranslationStore())).isEmpty()) {
/* 293 */       return (String)map.getOrDefault(paramString1, paramString1);
/*     */     }
/*     */     
/* 296 */     return paramString1;
/*     */   }
/*     */   
/*     */   private static String getEncodedIdAttribute(String paramString1, String paramString2, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Map<String, String> paramMap1, Map<String, String> paramMap2) {
/* 300 */     String str1 = paramString1;
/* 301 */     String str2 = paramString2;
/* 302 */     int i = ((Integer)ATTRIBUTE_TRANSLATION_ID.get((DataHolder)paramNodeFormatterContext.getTranslationStore())).intValue();
/*     */     
/* 304 */     switch (paramNodeFormatterContext.getRenderPurpose()) {
/*     */       case AS_IS:
/* 306 */         if (!paramMap1.containsKey(paramString1)) {
/* 307 */           str1 = String.format((paramNodeFormatterContext.getFormatterOptions()).translationIdFormat, new Object[] { Integer.valueOf(++i) });
/* 308 */           paramMap1.put(paramString1, str1);
/* 309 */           paramMap2.put(str1, paramString1);
/*     */         } else {
/* 311 */           str1 = paramMap1.get(paramString1);
/*     */         } 
/*     */         
/* 314 */         if (paramString2 != null && !paramMap1.containsKey(paramString2)) {
/* 315 */           str2 = String.format((paramNodeFormatterContext.getFormatterOptions()).translationIdFormat, new Object[] { Integer.valueOf(++i) });
/* 316 */           paramMap1.put(paramString2, str2);
/* 317 */           paramMap2.put(str2, paramString2); break;
/*     */         } 
/* 319 */         str2 = paramMap1.get(paramString2);
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case EXPLICIT_PREFERRED:
/* 330 */         str1 = paramMap2.get(paramString1);
/* 331 */         if (paramString2 != null) {
/* 332 */           str2 = paramMap2.get(paramString2);
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     paramNodeFormatterContext.getTranslationStore().set(ATTRIBUTE_TRANSLATION_ID, Integer.valueOf(i));
/*     */     
/* 344 */     if (str2 == null) {
/* 345 */       return str1;
/*     */     }
/* 347 */     return str1 + ':' + str2;
/*     */   }
/*     */   
/*     */   private String getEncodedOriginalId(String paramString, NodeFormatterContext paramNodeFormatterContext) {
/*     */     String str;
/* 352 */     switch (paramNodeFormatterContext.getRenderPurpose()) {
/*     */       
/*     */       case AS_IS:
/* 355 */         str = "#" + String.format((paramNodeFormatterContext.getFormatterOptions()).translationIdFormat, new Object[] { Integer.valueOf(++this.attributeOriginalId) });
/* 356 */         this.attributeOriginalIdMap.put(str, paramString);
/* 357 */         return str;
/*     */ 
/*     */       
/*     */       case IMPLICIT_PREFERRED:
/* 361 */         return "#" + String.format((str.getFormatterOptions()).translationIdFormat, new Object[] { Integer.valueOf(++this.attributeOriginalId) });
/*     */       
/*     */       case EXPLICIT_PREFERRED:
/* 364 */         this.attributeOriginalId++;
/* 365 */         paramString = this.attributeOriginalIdMap.get(paramString);
/*     */         
/* 367 */         if (this.attributeUniquificationIdMap != null) {
/* 368 */           return this.attributeUniquificationIdMap.getOrDefault(paramString, paramString);
/*     */         }
/* 370 */         return paramString;
/*     */     } 
/*     */ 
/*     */     
/* 374 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   void render(AttributesNode paramAttributesNode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*     */     Node node;
/* 380 */     if ((node = paramAttributesNode.getPrevious()) != null && !node.getChars().isContinuedBy(paramAttributesNode.getChars()) && !node.getChars().endsWith(" ") && !paramAttributesNode.getChars().startsWith(" ")) {
/* 381 */       paramMarkdownWriter.append(' ');
/*     */     }
/*     */     
/* 384 */     if (paramNodeFormatterContext.isTransformingText()) {
/* 385 */       paramMarkdownWriter.append((CharSequence)paramAttributesNode.getOpeningMarker());
/* 386 */       boolean bool = true;
/* 387 */       for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramAttributesNode.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) {
/* 388 */         Node node1; AttributeNode attributeNode = (AttributeNode)(node1 = reversiblePeekingIterator.next());
/* 389 */         if (!bool) paramMarkdownWriter.append(' '); 
/* 390 */         if (attributeNode.isId()) {
/*     */           BasedSequence basedSequence;
/*     */           
/*     */           int i;
/* 394 */           if ((i = (basedSequence = attributeNode.getValue()).indexOf(':')) == -1) {
/* 395 */             String str = getEncodedOriginalId(attributeNode.getChars().toString(), paramNodeFormatterContext);
/*     */             
/* 397 */             if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED && 
/* 398 */               !this.attributeUniquificationIdMap.isEmpty()) {
/* 399 */               String str1 = str.substring(1);
/* 400 */               str = "#" + (String)this.attributeUniquificationIdMap.getOrDefault(str1, str1);
/*     */             } 
/*     */ 
/*     */             
/* 404 */             paramMarkdownWriter.append(str);
/*     */           } else {
/* 406 */             String str1, str5, str2 = basedSequence.subSequence(0, i).toString();
/* 407 */             String str3 = ((BasedSequence)basedSequence.subSequence(i + 1)).toString();
/* 408 */             String str4 = getEncodedIdAttribute(str2, str3, paramNodeFormatterContext, paramMarkdownWriter, this.attributeTranslationMap, this.attributeTranslatedMap);
/* 409 */             switch (paramNodeFormatterContext.getRenderPurpose()) {
/*     */               
/*     */               case AS_IS:
/*     */               case IMPLICIT_PREFERRED:
/* 413 */                 str1 = "#" + str4;
/* 414 */                 this.attributeOriginalIdMap.put(str1, attributeNode.getChars().toString());
/* 415 */                 ((MarkdownWriter)paramMarkdownWriter.append('#')).append(str4);
/*     */                 break;
/*     */               
/*     */               case EXPLICIT_PREFERRED:
/* 419 */                 str5 = this.attributeOriginalIdMap.get("#" + str1.toString());
/*     */                 
/* 421 */                 if (this.attributeUniquificationIdMap != null)
/*     */                 {
/*     */                   
/* 424 */                   if (!this.attributeUniquificationIdMap.isEmpty()) {
/* 425 */                     String str = str5.substring(1);
/* 426 */                     str5 = "#" + (String)this.attributeUniquificationIdMap.getOrDefault(str, str);
/*     */                   } 
/*     */                 }
/*     */                 
/* 430 */                 paramMarkdownWriter.append((str5 == null) ? attributeNode.getChars().toString() : str5);
/*     */                 break;
/*     */ 
/*     */               
/*     */               default:
/* 435 */                 paramMarkdownWriter.append((CharSequence)attributeNode.getChars());
/*     */                 break;
/*     */             } 
/*     */           } 
/*     */         } else {
/* 440 */           paramMarkdownWriter.appendNonTranslating(".", (CharSequence)attributeNode.getChars());
/*     */         } 
/* 442 */         bool = false;
/*     */       } 
/* 444 */       paramMarkdownWriter.append((CharSequence)paramAttributesNode.getClosingMarker());
/*     */     } else {
/*     */       Collection collection; Set<?> set;
/* 447 */       if ((set = (Set)PROCESSED_ATTRIBUTES.get((DataHolder)paramNodeFormatterContext.getDocument())).contains(paramAttributesNode))
/*     */         return; 
/* 449 */       BasedSequence basedSequence1 = paramAttributesNode.getChars();
/* 450 */       BasedSequence basedSequence2 = paramAttributesNode.getOpeningMarker();
/* 451 */       BasedSequence basedSequence3 = paramAttributesNode.getClosingMarker();
/* 452 */       basedSequence2 = (basedSequence1.safeBaseCharAt(basedSequence2.getEndOffset()) == ' ') ? basedSequence1.baseSubSequence(basedSequence2.getEndOffset(), basedSequence2.getEndOffset() + 1) : BasedSequence.NULL;
/* 453 */       BasedSequence basedSequence4 = (basedSequence1.safeBaseCharAt(basedSequence3.getStartOffset() - 1) == ' ') ? basedSequence1.baseSubSequence(basedSequence3.getStartOffset() - 1, basedSequence3.getStartOffset()) : BasedSequence.NULL;
/*     */       
/* 455 */       switch (this.formatOptions.attributesSpaces) {
/*     */ 
/*     */         
/*     */         case IMPLICIT_PREFERRED:
/* 459 */           basedSequence2 = BasedSequence.SPACE;
/* 460 */           basedSequence4 = BasedSequence.SPACE;
/*     */           break;
/*     */         case EXPLICIT_PREFERRED:
/* 463 */           basedSequence2 = BasedSequence.NULL;
/* 464 */           basedSequence4 = BasedSequence.NULL;
/*     */           break;
/*     */       } 
/*     */       
/* 468 */       paramMarkdownWriter.append((CharSequence)paramAttributesNode.getOpeningMarker());
/* 469 */       paramMarkdownWriter.append((CharSequence)basedSequence2);
/* 470 */       AttributeValueQuotes attributeValueQuotes = this.formatOptions.attributeValueQuotes;
/*     */       
/* 472 */       boolean bool = true;
/*     */       
/* 474 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */       
/* 476 */       if (this.formatOptions.attributesCombineConsecutive) {
/*     */         NodeAttributeRepository nodeAttributeRepository;
/*     */         
/* 479 */         for (Iterator<Map.Entry<Node, ArrayList<AttributesNode>>> iterator1 = (nodeAttributeRepository = (NodeAttributeRepository)AttributesExtension.NODE_ATTRIBUTES.get((DataHolder)paramNodeFormatterContext.getDocument())).entrySet().iterator(); iterator1.hasNext();) {
/* 480 */           if (((ArrayList)(entry = (Map.Entry)iterator1.next()).getValue()).contains(paramAttributesNode)) {
/*     */             
/* 482 */             for (AttributesNode attributesNode : entry.getValue()) {
/* 483 */               set.add(attributesNode);
/*     */               
/* 485 */               for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = attributesNode.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) {
/* 486 */                 Node node1; AttributeNode attributeNode = (AttributeNode)(node1 = reversiblePeekingIterator.next());
/* 487 */                 linkedHashMap.put(attributeNode.getName().toString(), combineAttributes((LinkedHashMap)linkedHashMap, attributeNode));
/*     */               } 
/*     */             } 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 495 */       if (linkedHashMap.isEmpty()) {
/* 496 */         for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramAttributesNode.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) {
/* 497 */           Node node1; AttributeNode attributeNode = (AttributeNode)(node1 = reversiblePeekingIterator.next());
/* 498 */           linkedHashMap.put(attributeNode.getName().toString(), combineAttributes((LinkedHashMap)linkedHashMap, attributeNode));
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 503 */       if (this.formatOptions.attributesSort) {
/*     */         ArrayList<?> arrayList;
/* 505 */         (arrayList = new ArrayList(linkedHashMap.entrySet())).sort((paramEntry1, paramEntry2) -> ((AttributeNode)paramEntry1.getValue()).isId() ? -1 : (((AttributeNode)paramEntry2.getValue()).isId() ? 1 : (((AttributeNode)paramEntry1.getValue()).isClass() ? -1 : (((AttributeNode)paramEntry2.getValue()).isClass() ? 1 : ((AttributeNode)paramEntry1.getValue()).getName().compareTo(((AttributeNode)paramEntry2.getValue()).getName())))));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 513 */         ArrayList arrayList1 = new ArrayList(arrayList.size());
/* 514 */         for (Map.Entry entry : arrayList) {
/* 515 */           arrayList1.add(entry.getValue());
/*     */         }
/* 517 */         collection = arrayList1;
/*     */       } else {
/* 519 */         collection = linkedHashMap.values();
/*     */       } 
/*     */       
/* 522 */       for (Iterator<Node> iterator = collection.iterator(); iterator.hasNext(); ) {
/* 523 */         PrefixedSubSequence prefixedSubSequence1, prefixedSubSequence2; Node node1; AttributeNode attributeNode = (AttributeNode)(node1 = iterator.next());
/*     */         
/* 525 */         if (!bool) paramMarkdownWriter.append(' ');
/*     */ 
/*     */         
/* 528 */         basedSequence1 = attributeNode.getChars();
/*     */         
/* 530 */         BasedSequence basedSequence6 = attributeNode.getName();
/* 531 */         basedSequence3 = attributeNode.getValue();
/* 532 */         BasedSequence basedSequence7 = attributeNode.getAttributeSeparator();
/*     */         
/* 534 */         BasedSequence basedSequence5 = (basedSequence1.safeBaseCharAt(basedSequence7.getStartOffset() - 1) == ' ') ? basedSequence1.baseSubSequence(basedSequence7.getStartOffset() - 1, basedSequence7.getStartOffset()) : BasedSequence.NULL;
/* 535 */         basedSequence1 = (basedSequence1.safeBaseCharAt(basedSequence7.getEndOffset()) == ' ') ? basedSequence1.baseSubSequence(basedSequence7.getEndOffset(), basedSequence7.getEndOffset() + 1) : BasedSequence.NULL;
/*     */         
/* 537 */         switch (this.formatOptions.attributeEqualSpace) {
/*     */ 
/*     */           
/*     */           case IMPLICIT_PREFERRED:
/* 541 */             basedSequence5 = BasedSequence.SPACE;
/* 542 */             basedSequence1 = BasedSequence.SPACE;
/*     */             break;
/*     */           case EXPLICIT_PREFERRED:
/* 545 */             basedSequence5 = BasedSequence.NULL;
/* 546 */             basedSequence1 = BasedSequence.NULL;
/*     */             break;
/*     */         } 
/*     */         
/* 550 */         String str1 = attributeNode.isImplicitName() ? "" : attributeValueQuotes.quotesFor((CharSequence)basedSequence3, (CharSequence)attributeNode.getOpeningMarker());
/* 551 */         String str2 = AttributeValueQuotes.NO_QUOTES_DOUBLE_PREFERRED.quotesFor((CharSequence)basedSequence3, "");
/*     */         
/* 553 */         if (attributeNode.isId()) {
/* 554 */           switch (str2.isEmpty() ? this.formatOptions.attributeIdFormat : AttributeImplicitName.EXPLICIT_PREFERRED) {
/*     */             case AS_IS:
/*     */               break;
/*     */             case IMPLICIT_PREFERRED:
/* 558 */               if (!attributeNode.isImplicitName()) {
/* 559 */                 prefixedSubSequence1 = PrefixedSubSequence.prefixOf("#", basedSequence6.getEmptyPrefix());
/* 560 */                 basedSequence7 = BasedSequence.NULL;
/* 561 */                 str1 = "";
/*     */               } 
/*     */               break;
/*     */             
/*     */             case EXPLICIT_PREFERRED:
/* 566 */               if (attributeNode.isImplicitName()) {
/* 567 */                 prefixedSubSequence1 = PrefixedSubSequence.prefixOf("id", prefixedSubSequence1.getEmptyPrefix());
/* 568 */                 prefixedSubSequence2 = PrefixedSubSequence.prefixOf("=", prefixedSubSequence1.getEmptySuffix());
/* 569 */                 if (str1.isEmpty() && (
/*     */                   
/* 571 */                   str1 = attributeValueQuotes.quotesFor((CharSequence)basedSequence3, (CharSequence)attributeNode.getOpeningMarker())).isEmpty()) str1 = str2;
/*     */               
/*     */               } 
/*     */               break;
/*     */             default:
/* 576 */               throw new IllegalStateException("Unexpected value: " + this.formatOptions.attributeIdFormat);
/*     */           } 
/* 578 */         } else if (attributeNode.isClass()) {
/* 579 */           switch (str2.isEmpty() ? this.formatOptions.attributeClassFormat : AttributeImplicitName.EXPLICIT_PREFERRED) {
/*     */             case AS_IS:
/*     */               break;
/*     */             case IMPLICIT_PREFERRED:
/* 583 */               if (!attributeNode.isImplicitName()) {
/* 584 */                 prefixedSubSequence1 = PrefixedSubSequence.prefixOf(".", prefixedSubSequence1.getEmptyPrefix());
/* 585 */                 basedSequence7 = BasedSequence.NULL;
/* 586 */                 str1 = "";
/*     */               } 
/*     */               break;
/*     */             
/*     */             case EXPLICIT_PREFERRED:
/* 591 */               if (attributeNode.isImplicitName()) {
/* 592 */                 prefixedSubSequence1 = PrefixedSubSequence.prefixOf("class", prefixedSubSequence1.getEmptyPrefix());
/* 593 */                 prefixedSubSequence2 = PrefixedSubSequence.prefixOf("=", prefixedSubSequence1.getEmptySuffix());
/* 594 */                 if (str1.isEmpty() && (
/*     */                   
/* 596 */                   str1 = attributeValueQuotes.quotesFor((CharSequence)basedSequence3, (CharSequence)attributeNode.getOpeningMarker())).isEmpty()) str1 = str2;
/*     */               
/*     */               } 
/*     */               break;
/*     */             default:
/* 601 */               throw new IllegalStateException("Unexpected value: " + this.formatOptions.attributeIdFormat);
/*     */           } 
/*     */         
/*     */         } 
/* 605 */         paramMarkdownWriter.append((CharSequence)prefixedSubSequence1);
/* 606 */         if (!prefixedSubSequence2.isEmpty()) ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.append((CharSequence)basedSequence5)).append((CharSequence)prefixedSubSequence2)).append((CharSequence)basedSequence1);
/*     */         
/* 608 */         if (!str1.isEmpty()) {
/* 609 */           String str = str1.equals("'") ? "&apos;" : (str1.equals("\"") ? "&quot;" : "");
/* 610 */           paramMarkdownWriter.append(str1);
/* 611 */           paramMarkdownWriter.append((CharSequence)basedSequence3.replace(str1, str));
/* 612 */           paramMarkdownWriter.append(str1);
/*     */         } else {
/* 614 */           paramMarkdownWriter.append((CharSequence)basedSequence3);
/*     */         } 
/*     */         
/* 617 */         boolean bool1 = false;
/*     */       } 
/*     */       
/* 620 */       paramMarkdownWriter.append((CharSequence)basedSequence4);
/* 621 */       paramMarkdownWriter.append((CharSequence)paramAttributesNode.getClosingMarker());
/*     */     } 
/*     */ 
/*     */     
/* 625 */     if ((node = paramAttributesNode.getNext()) != null && !(node instanceof AttributesNode) && !paramAttributesNode.getChars().isContinuedBy(node.getChars()) && !paramAttributesNode.getChars().endsWith(" ") && !node.getChars().startsWith(" "))
/* 626 */       paramMarkdownWriter.append(' '); 
/*     */   }
/*     */   
/*     */   static AttributeNode combineAttributes(LinkedHashMap<String, AttributeNode> paramLinkedHashMap, AttributeNode paramAttributeNode) {
/*     */     PrefixedSubSequence prefixedSubSequence;
/* 631 */     if (paramAttributeNode.isId()) {
/* 632 */       paramLinkedHashMap.remove("id");
/* 633 */       paramLinkedHashMap.remove("#");
/* 634 */       return paramAttributeNode;
/* 635 */     }  if (paramAttributeNode.isClass()) {
/* 636 */       AttributeNode attributeNode2 = paramAttributeNode;
/* 637 */       AttributeNode attributeNode3 = paramLinkedHashMap.remove("class");
/* 638 */       AttributeNode attributeNode1 = paramLinkedHashMap.remove(".");
/* 639 */       if (attributeNode3 != null || attributeNode1 != null) {
/* 640 */         MutableAttributes mutableAttributes = new MutableAttributes();
/* 641 */         if (attributeNode3 != null) mutableAttributes.addValue("class", (CharSequence)attributeNode3.getValue()); 
/* 642 */         if (attributeNode1 != null) mutableAttributes.addValue("class", (CharSequence)attributeNode1.getValue()); 
/* 643 */         String str = mutableAttributes.getValue("class");
/* 644 */         if (!paramAttributeNode.getValue().equals(str)) {
/* 645 */           prefixedSubSequence = PrefixedSubSequence.prefixOf(str + " ", paramAttributeNode.getValue());
/* 646 */           attributeNode2 = new AttributeNode(paramAttributeNode.getName(), paramAttributeNode.getAttributeSeparator(), paramAttributeNode.getOpeningMarker(), (BasedSequence)prefixedSubSequence, paramAttributeNode.getClosingMarker());
/*     */         } 
/*     */       } 
/* 649 */       return attributeNode2;
/* 650 */     }  if (paramAttributeNode.getName().equals("style")) {
/* 651 */       AttributeNode attributeNode1 = paramAttributeNode;
/*     */       AttributeNode attributeNode2;
/* 653 */       if ((attributeNode2 = (AttributeNode)prefixedSubSequence.remove("style")) != null) {
/*     */         MutableAttributes mutableAttributes;
/* 655 */         (mutableAttributes = new MutableAttributes()).addValue("style", (CharSequence)attributeNode2.getValue());
/* 656 */         String str = mutableAttributes.getValue("style");
/* 657 */         if (!paramAttributeNode.getValue().equals(str)) {
/* 658 */           PrefixedSubSequence prefixedSubSequence1 = PrefixedSubSequence.prefixOf(str + ";", paramAttributeNode.getValue());
/* 659 */           attributeNode1 = new AttributeNode(paramAttributeNode.getName(), paramAttributeNode.getAttributeSeparator(), paramAttributeNode.getOpeningMarker(), (BasedSequence)prefixedSubSequence1, paramAttributeNode.getClosingMarker());
/*     */         } 
/*     */       } 
/* 662 */       return attributeNode1;
/*     */     } 
/* 664 */     return paramAttributeNode;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeFormatterFactory
/*     */   {
/*     */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 672 */       return (NodeFormatter)new AttributesNodeFormatter(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributesNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */