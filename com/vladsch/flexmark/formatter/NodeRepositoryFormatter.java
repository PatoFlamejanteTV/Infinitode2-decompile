/*     */ package com.vladsch.flexmark.formatter;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*     */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public abstract class NodeRepositoryFormatter<R extends NodeRepository<B>, B extends Node & ReferenceNode<R, B, N>, N extends Node & ReferencingNode<R, B>> implements PhasedNodeFormatter {
/*  19 */   public static final HashSet<FormattingPhase> FORMATTING_PHASES = new HashSet<>(Arrays.asList(new FormattingPhase[] { FormattingPhase.COLLECT, FormattingPhase.DOCUMENT_TOP, FormattingPhase.DOCUMENT_BOTTOM })); protected final R referenceRepository; protected final List<B> referenceList; protected final HashSet<Node> unusedReferences; protected final B lastReference; protected boolean recheckUndefinedReferences; protected boolean repositoryNodesDone; protected final Comparator<B> myComparator;
/*     */   private Map<String, String> referenceTranslationMap;
/*     */   protected Map<String, String> referenceUniqificationMap;
/*     */   private final DataKey<Map<String, String>> myReferenceMapKey;
/*     */   private final DataKey<Map<String, String>> myReferenceUniqificationMapKey;
/*     */   
/*     */   public Comparator<B> getReferenceComparator() {
/*  26 */     return this.myComparator;
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
/*     */   protected boolean makeReferencesUnique() {
/*  40 */     return true;
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
/*     */   protected ElementPlacement getTranslationReferencePlacement(NodeFormatterContext paramNodeFormatterContext) {
/*  57 */     if (paramNodeFormatterContext.isTransformingText()) {
/*  58 */       return ElementPlacement.AS_IS;
/*     */     }
/*  60 */     return getReferencePlacement();
/*     */   }
/*     */ 
/*     */   
/*     */   public String modifyTransformedReference(String paramString, NodeFormatterContext paramNodeFormatterContext) {
/*  65 */     return paramString;
/*     */   }
/*     */   
/*     */   private void renderReferenceBlockUnique(B paramB, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  69 */     if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED) {
/*  70 */       paramNodeFormatterContext.postProcessNonTranslating(paramString -> (this.referenceUniqificationMap != null) ? (paramString = this.referenceUniqificationMap.getOrDefault(paramString, paramString)) : paramString, () -> renderReferenceBlock((B)paramNode, paramNodeFormatterContext, paramMarkdownWriter));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  80 */     renderReferenceBlock(paramB, paramNodeFormatterContext, paramMarkdownWriter);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String transformReferenceId(String paramString, NodeFormatterContext paramNodeFormatterContext) {
/*  85 */     if (paramNodeFormatterContext.isTransformingText()) {
/*     */       String str;
/*     */       
/*  88 */       switch (paramNodeFormatterContext.getRenderPurpose()) {
/*     */         case AS_IS:
/*     */         case GROUP_WITH_FIRST:
/*  91 */           if (this.referenceTranslationMap != null) {
/*  92 */             if (this.referenceTranslationMap.containsKey(paramString)) {
/*  93 */               str = this.referenceTranslationMap.get(paramString);
/*     */             } else {
/*  95 */               str = paramNodeFormatterContext.transformNonTranslating(null, paramString, null, null).toString();
/*  96 */               this.referenceTranslationMap.put(paramString, str);
/*     */             } 
/*     */           } else {
/*  99 */             str = paramNodeFormatterContext.transformNonTranslating(null, paramString, null, null).toString();
/*     */           } 
/* 101 */           return modifyTransformedReference(str, paramNodeFormatterContext);
/*     */         
/*     */         case GROUP_WITH_LAST:
/* 104 */           paramString = modifyTransformedReference(paramString, paramNodeFormatterContext);
/* 105 */           paramString = paramNodeFormatterContext.transformNonTranslating(null, paramString, null, null).toString();
/*     */ 
/*     */ 
/*     */           
/* 109 */           if (!paramNodeFormatterContext.isPostProcessingNonTranslating() && this.referenceUniqificationMap != null && this.referenceUniqificationMap.containsKey(paramString))
/*     */           {
/* 111 */             return paramString = this.referenceUniqificationMap.get(paramString);
/*     */           }
/* 113 */           return paramString;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 120 */     return paramString;
/*     */   }
/*     */   
/*     */   public NodeRepositoryFormatter(DataHolder paramDataHolder, DataKey<Map<String, String>> paramDataKey1, DataKey<Map<String, String>> paramDataKey2) {
/* 124 */     this.myReferenceMapKey = paramDataKey1;
/* 125 */     this.myReferenceUniqificationMapKey = paramDataKey2;
/* 126 */     this.referenceRepository = getRepository(paramDataHolder);
/* 127 */     this.referenceList = this.referenceRepository.values();
/* 128 */     this.lastReference = this.referenceList.isEmpty() ? null : this.referenceList.get(this.referenceList.size() - 1);
/* 129 */     this.unusedReferences = new HashSet<>();
/* 130 */     this.recheckUndefinedReferences = ((Boolean)HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(paramDataHolder)).booleanValue();
/* 131 */     this.repositoryNodesDone = false;
/*     */     
/* 133 */     this.myComparator = ((paramObject1, paramObject2) -> ((Comparable<Object>)paramObject1).compareTo(paramObject2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<FormattingPhase> getFormattingPhases() {
/* 139 */     return FORMATTING_PHASES;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderDocument(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument, FormattingPhase paramFormattingPhase) {
/* 145 */     if (paramNodeFormatterContext.isTransformingText() && this.myReferenceMapKey != null) {
/* 146 */       if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
/* 147 */         paramNodeFormatterContext.getTranslationStore().set(this.myReferenceMapKey, new HashMap<>());
/*     */       }
/* 149 */       this.referenceTranslationMap = (Map<String, String>)this.myReferenceMapKey.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/*     */     } 
/*     */     
/* 152 */     switch (paramFormattingPhase) {
/*     */       case AS_IS:
/* 154 */         this.referenceUniqificationMap = null;
/*     */         
/* 156 */         if (paramNodeFormatterContext.isTransformingText() && this.myReferenceUniqificationMapKey != null && makeReferencesUnique()) {
/* 157 */           if (paramNodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
/*     */             MergeContext mergeContext;
/*     */ 
/*     */             
/* 161 */             if ((mergeContext = paramNodeFormatterContext.getMergeContext()) != null) {
/* 162 */               uniquifyIds(paramNodeFormatterContext, paramMarkdownWriter, paramDocument);
/*     */             }
/*     */           } 
/*     */           
/* 166 */           this.referenceUniqificationMap = (Map<String, String>)this.myReferenceUniqificationMapKey.get((DataHolder)paramNodeFormatterContext.getTranslationStore());
/*     */         } 
/*     */         
/* 169 */         if (getTranslationReferencePlacement(paramNodeFormatterContext).isChange() && getReferenceSort().isUnused()) {
/*     */           
/* 171 */           this.unusedReferences.addAll(this.referenceList);
/*     */           Set<Class<?>> set;
/* 173 */           if ((set = getNodeClasses()) != null) {
/*     */             Iterable<? extends Node> iterable;
/* 175 */             for (Node node : iterable = paramNodeFormatterContext.nodesOfType(set)) {
/*     */               
/* 177 */               if ((node = (Node)((this.lastReference == null) ? null : ((ReferenceNode)this.lastReference).getReferencingNode(node))) != null && (
/*     */                 
/* 179 */                 node = (Node)((ReferencingNode)node).getReferenceNode((NodeRepository)this.referenceRepository)) != null) {
/* 180 */                 this.unusedReferences.remove(node);
/*     */               }
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         } 
/*     */         break;
/*     */       
/*     */       case GROUP_WITH_FIRST:
/* 189 */         if (getTranslationReferencePlacement(paramNodeFormatterContext) == ElementPlacement.DOCUMENT_TOP) {
/*     */           
/* 191 */           formatReferences(paramNodeFormatterContext, (MarkdownWriter)node);
/*     */           return;
/*     */         } 
/*     */         break;
/*     */       case GROUP_WITH_LAST:
/* 196 */         if (getTranslationReferencePlacement(paramNodeFormatterContext) == ElementPlacement.DOCUMENT_BOTTOM)
/*     */         {
/* 198 */           formatReferences(paramNodeFormatterContext, (MarkdownWriter)node);
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void formatReferences(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*     */     ArrayList<Node> arrayList1, arrayList2;
/* 208 */     ArrayList<B> arrayList = new ArrayList<>(this.referenceList);
/*     */     
/* 210 */     ElementPlacementSort elementPlacementSort = getReferenceSort();
/* 211 */     switch (elementPlacementSort) {
/*     */       case AS_IS:
/*     */         break;
/*     */       
/*     */       case GROUP_WITH_FIRST:
/* 216 */         arrayList.sort(getReferenceComparator());
/*     */         break;
/*     */       
/*     */       case GROUP_WITH_LAST:
/*     */       case null:
/*     */       case null:
/* 222 */         arrayList1 = new ArrayList();
/* 223 */         arrayList2 = new ArrayList();
/* 224 */         for (Node node : arrayList) {
/* 225 */           if (!this.unusedReferences.contains(node)) {
/* 226 */             arrayList1.add(node); continue;
/* 227 */           }  if (!elementPlacementSort.isDeleteUnused()) {
/* 228 */             arrayList2.add(node);
/*     */           }
/*     */         } 
/*     */         
/* 232 */         if (elementPlacementSort.isSort()) {
/* 233 */           arrayList1.sort(getReferenceComparator());
/*     */           
/* 235 */           if (!elementPlacementSort.isDeleteUnused()) {
/* 236 */             arrayList2.sort(getReferenceComparator());
/*     */           }
/*     */         } 
/*     */         
/* 240 */         arrayList.clear();
/* 241 */         arrayList.addAll((Collection)arrayList1);
/*     */         
/* 243 */         if (!elementPlacementSort.isDeleteUnused()) {
/* 244 */           arrayList.addAll((Collection)arrayList2);
/*     */         }
/*     */         break;
/*     */       
/*     */       default:
/* 249 */         throw new IllegalStateException("Unexpected value: " + elementPlacementSort);
/*     */     } 
/*     */     
/* 252 */     paramMarkdownWriter.blankLine();
/* 253 */     for (Node node : arrayList) {
/* 254 */       renderReferenceBlockUnique((B)node, paramNodeFormatterContext, paramMarkdownWriter);
/*     */     }
/* 256 */     paramMarkdownWriter.blankLine();
/* 257 */     this.repositoryNodesDone = true;
/*     */   }
/*     */   
/*     */   protected void renderReference(B paramB, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 261 */     if (!this.repositoryNodesDone) {
/* 262 */       switch (getTranslationReferencePlacement(paramNodeFormatterContext)) {
/*     */         case AS_IS:
/* 264 */           renderReferenceBlockUnique(paramB, paramNodeFormatterContext, paramMarkdownWriter);
/* 265 */           if (paramB.getNext() == null || paramB.getNext().getClass() != paramB.getClass()) {
/* 266 */             paramMarkdownWriter.blankLine();
/*     */             return;
/*     */           } 
/*     */           break;
/*     */         
/*     */         case GROUP_WITH_FIRST:
/* 272 */           formatReferences(paramNodeFormatterContext, paramMarkdownWriter);
/*     */           return;
/*     */         
/*     */         case GROUP_WITH_LAST:
/* 276 */           if (paramB == this.lastReference) {
/* 277 */             formatReferences(paramNodeFormatterContext, paramMarkdownWriter);
/*     */           }
/*     */           break;
/*     */       } 
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void uniquifyIds(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument) {
/* 295 */     paramMarkdownWriter = (MarkdownWriter)getRepository((DataHolder)new DataSet());
/* 296 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     MergeContext mergeContext;
/* 299 */     (mergeContext = paramNodeFormatterContext.getMergeContext()).forEachPrecedingDocument(paramDocument, (paramTranslationContext, paramDocument, paramInt) -> {
/*     */           paramDocument = (Document)getRepository((DataHolder)paramDocument);
/*     */           
/*     */           Map map = (Map)this.myReferenceUniqificationMapKey.get((DataHolder)paramTranslationContext.getTranslationStore());
/*     */           
/*     */           NodeRepository.transferReferences(paramNodeRepository, (NodeRepository)paramDocument, true, map);
/*     */         });
/*     */     
/* 307 */     for (Iterator<Map.Entry> iterator = (paramDocument = (Document)getRepository((DataHolder)paramDocument)).entrySet().iterator(); iterator.hasNext(); ) {
/*     */       Map.Entry<String, ?> entry;
/* 309 */       String str1 = (entry = iterator.next()).getKey(), str2 = str1;
/* 310 */       byte b = 0;
/*     */       
/* 312 */       while (paramMarkdownWriter.containsKey(str2)) {
/*     */         
/* 314 */         str2 = String.format("%s%d", new Object[] { str1, Integer.valueOf(++b) });
/*     */       } 
/*     */       
/* 317 */       if (b > 0)
/*     */       {
/* 319 */         hashMap.put(str1, str2);
/*     */       }
/*     */     } 
/*     */     
/* 323 */     if (!hashMap.isEmpty())
/*     */     {
/* 325 */       paramNodeFormatterContext.getTranslationStore().set(this.myReferenceUniqificationMapKey, hashMap);
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract R getRepository(DataHolder paramDataHolder);
/*     */   
/*     */   public abstract ElementPlacement getReferencePlacement();
/*     */   
/*     */   public abstract ElementPlacementSort getReferenceSort();
/*     */   
/*     */   protected abstract void renderReferenceBlock(B paramB, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\NodeRepositoryFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */