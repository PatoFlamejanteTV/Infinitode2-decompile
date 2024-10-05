/*     */ package com.vladsch.flexmark.parser.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.collection.OrderedSet;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.dependency.DependencyResolver;
/*     */ import com.vladsch.flexmark.util.dependency.DependentItem;
/*     */ import com.vladsch.flexmark.util.dependency.DependentItemMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PostProcessorManager
/*     */ {
/*     */   private final List<PostProcessorDependencyStage> postProcessorDependencies;
/*  26 */   private final OrderedSet<Node> allPostProcessNodes = new OrderedSet();
/*     */   
/*     */   public PostProcessorManager(List<PostProcessorDependencyStage> paramList) {
/*  29 */     this.postProcessorDependencies = paramList;
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
/*     */   public static List<PostProcessorDependencyStage> calculatePostProcessors(DataHolder paramDataHolder, List<PostProcessorFactory> paramList) {
/*  44 */     List list = DependencyResolver.resolveDependencies(paramList, PostProcessorManager::prioritizePostProcessors, null);
/*  45 */     paramList = new ArrayList<>(list.size());
/*  46 */     for (List<PostProcessorFactory> list1 : (Iterable<List<PostProcessorFactory>>)list) {
/*  47 */       paramList.add(new PostProcessorDependencyStage(list1));
/*     */     }
/*     */     
/*  50 */     return (List)paramList;
/*     */   }
/*     */   
/*     */   public static Document processDocument(Document paramDocument, List<PostProcessorDependencyStage> paramList) {
/*  54 */     if (!paramList.isEmpty()) {
/*     */       PostProcessorManager postProcessorManager;
/*  56 */       paramDocument = (postProcessorManager = new PostProcessorManager(paramList)).postProcess(paramDocument);
/*     */     } 
/*  58 */     return paramDocument;
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
/*     */   public Document postProcess(Document paramDocument) {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore_2
/*     */     //   2: aload_0
/*     */     //   3: getfield postProcessorDependencies : Ljava/util/List;
/*     */     //   6: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   11: astore_3
/*     */     //   12: aload_3
/*     */     //   13: invokeinterface hasNext : ()Z
/*     */     //   18: ifeq -> 385
/*     */     //   21: aload_3
/*     */     //   22: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   27: checkcast com/vladsch/flexmark/parser/internal/PostProcessorManager$PostProcessorDependencyStage
/*     */     //   30: astore #4
/*     */     //   32: iconst_0
/*     */     //   33: istore #5
/*     */     //   35: aload #4
/*     */     //   37: getfield dependents : Ljava/util/List;
/*     */     //   40: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   45: astore #6
/*     */     //   47: aload #6
/*     */     //   49: invokeinterface hasNext : ()Z
/*     */     //   54: ifeq -> 382
/*     */     //   57: aload #6
/*     */     //   59: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   64: checkcast com/vladsch/flexmark/parser/PostProcessorFactory
/*     */     //   67: dup
/*     */     //   68: astore #7
/*     */     //   70: invokeinterface affectsGlobalScope : ()Z
/*     */     //   75: ifeq -> 101
/*     */     //   78: aload #7
/*     */     //   80: aload_1
/*     */     //   81: invokeinterface apply : (Lcom/vladsch/flexmark/util/ast/Document;)Lcom/vladsch/flexmark/parser/PostProcessor;
/*     */     //   86: aload_1
/*     */     //   87: invokeinterface processDocument : (Lcom/vladsch/flexmark/util/ast/Document;)Lcom/vladsch/flexmark/util/ast/Document;
/*     */     //   92: astore_1
/*     */     //   93: iconst_1
/*     */     //   94: istore #5
/*     */     //   96: aconst_null
/*     */     //   97: astore_2
/*     */     //   98: goto -> 47
/*     */     //   101: getstatic com/vladsch/flexmark/parser/internal/PostProcessorManager.$assertionsDisabled : Z
/*     */     //   104: ifne -> 120
/*     */     //   107: iload #5
/*     */     //   109: ifeq -> 120
/*     */     //   112: new java/lang/AssertionError
/*     */     //   115: dup
/*     */     //   116: invokespecial <init> : ()V
/*     */     //   119: athrow
/*     */     //   120: aload_2
/*     */     //   121: ifnonnull -> 141
/*     */     //   124: new com/vladsch/flexmark/util/ast/NodeClassifierVisitor
/*     */     //   127: dup
/*     */     //   128: aload #4
/*     */     //   130: getfield myNodeMap : Ljava/util/Map;
/*     */     //   133: invokespecial <init> : (Ljava/util/Map;)V
/*     */     //   136: aload_1
/*     */     //   137: invokevirtual classify : (Lcom/vladsch/flexmark/util/ast/Node;)Lcom/vladsch/flexmark/util/ast/ClassifyingNodeTracker;
/*     */     //   140: astore_2
/*     */     //   141: aload #7
/*     */     //   143: invokeinterface getNodeTypes : ()Ljava/util/Map;
/*     */     //   148: astore #8
/*     */     //   150: aload #7
/*     */     //   152: aload_1
/*     */     //   153: invokeinterface apply : (Lcom/vladsch/flexmark/util/ast/Document;)Lcom/vladsch/flexmark/parser/PostProcessor;
/*     */     //   158: astore #7
/*     */     //   160: new java/util/BitSet
/*     */     //   163: dup
/*     */     //   164: invokespecial <init> : ()V
/*     */     //   167: astore #9
/*     */     //   169: aload #8
/*     */     //   171: ifnull -> 379
/*     */     //   174: aload #8
/*     */     //   176: invokeinterface values : ()Ljava/util/Collection;
/*     */     //   181: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   186: astore #10
/*     */     //   188: aload #10
/*     */     //   190: invokeinterface hasNext : ()Z
/*     */     //   195: ifeq -> 231
/*     */     //   198: aload #10
/*     */     //   200: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   205: checkcast java/util/Set
/*     */     //   208: astore #11
/*     */     //   210: aload_2
/*     */     //   211: invokevirtual getExclusionSet : ()Lcom/vladsch/flexmark/util/collection/OrderedSet;
/*     */     //   214: aload #11
/*     */     //   216: invokevirtual indexBitSet : (Ljava/lang/Iterable;)Ljava/util/BitSet;
/*     */     //   219: astore #12
/*     */     //   221: aload #9
/*     */     //   223: aload #12
/*     */     //   225: invokevirtual or : (Ljava/util/BitSet;)V
/*     */     //   228: goto -> 188
/*     */     //   231: aload_2
/*     */     //   232: ldc com/vladsch/flexmark/util/ast/Node
/*     */     //   234: aload #8
/*     */     //   236: invokeinterface keySet : ()Ljava/util/Set;
/*     */     //   241: invokevirtual getCategoryItems : (Ljava/lang/Class;Ljava/util/Set;)Lcom/vladsch/flexmark/util/collection/iteration/ReversibleIterable;
/*     */     //   244: dup
/*     */     //   245: astore #10
/*     */     //   247: invokeinterface iterator : ()Lcom/vladsch/flexmark/util/collection/iteration/ReversibleIterator;
/*     */     //   252: astore #11
/*     */     //   254: aload #11
/*     */     //   256: invokeinterface hasNext : ()Z
/*     */     //   261: ifeq -> 379
/*     */     //   264: aload #11
/*     */     //   266: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   271: checkcast com/vladsch/flexmark/util/ast/Node
/*     */     //   274: dup
/*     */     //   275: astore #12
/*     */     //   277: invokevirtual getParent : ()Lcom/vladsch/flexmark/util/ast/Node;
/*     */     //   280: ifnull -> 254
/*     */     //   283: aload #8
/*     */     //   285: aload #12
/*     */     //   287: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   290: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   295: checkcast java/util/Set
/*     */     //   298: dup
/*     */     //   299: astore #10
/*     */     //   301: ifnull -> 366
/*     */     //   304: aload_2
/*     */     //   305: invokevirtual getItems : ()Lcom/vladsch/flexmark/util/collection/OrderedSet;
/*     */     //   308: aload #12
/*     */     //   310: invokevirtual indexOf : (Ljava/lang/Object;)I
/*     */     //   313: dup
/*     */     //   314: istore #9
/*     */     //   316: iconst_m1
/*     */     //   317: if_icmpeq -> 366
/*     */     //   320: aload_2
/*     */     //   321: invokevirtual getNodeAncestryMap : ()Ljava/util/HashMap;
/*     */     //   324: iload #9
/*     */     //   326: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   329: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   332: checkcast java/util/BitSet
/*     */     //   335: dup
/*     */     //   336: astore #9
/*     */     //   338: ifnull -> 366
/*     */     //   341: aload_2
/*     */     //   342: invokevirtual getExclusionSet : ()Lcom/vladsch/flexmark/util/collection/OrderedSet;
/*     */     //   345: aload #10
/*     */     //   347: invokevirtual indexBitSet : (Ljava/lang/Iterable;)Ljava/util/BitSet;
/*     */     //   350: dup
/*     */     //   351: astore #10
/*     */     //   353: aload #9
/*     */     //   355: invokevirtual and : (Ljava/util/BitSet;)V
/*     */     //   358: aload #10
/*     */     //   360: invokevirtual isEmpty : ()Z
/*     */     //   363: ifeq -> 254
/*     */     //   366: aload #7
/*     */     //   368: aload_2
/*     */     //   369: aload #12
/*     */     //   371: invokeinterface process : (Lcom/vladsch/flexmark/util/ast/NodeTracker;Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   376: goto -> 254
/*     */     //   379: goto -> 47
/*     */     //   382: goto -> 12
/*     */     //   385: aload_1
/*     */     //   386: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #65	-> 0
/*     */     //   #66	-> 2
/*     */     //   #70	-> 32
/*     */     //   #71	-> 35
/*     */     //   #72	-> 68
/*     */     //   #73	-> 78
/*     */     //   #74	-> 93
/*     */     //   #76	-> 96
/*     */     //   #78	-> 101
/*     */     //   #80	-> 120
/*     */     //   #82	-> 124
/*     */     //   #85	-> 141
/*     */     //   #86	-> 150
/*     */     //   #87	-> 160
/*     */     //   #88	-> 169
/*     */     //   #89	-> 174
/*     */     //   #90	-> 210
/*     */     //   #91	-> 221
/*     */     //   #92	-> 228
/*     */     //   #94	-> 231
/*     */     //   #95	-> 245
/*     */     //   #96	-> 275
/*     */     //   #101	-> 283
/*     */     //   #102	-> 299
/*     */     //   #103	-> 304
/*     */     //   #104	-> 314
/*     */     //   #105	-> 320
/*     */     //   #106	-> 336
/*     */     //   #107	-> 341
/*     */     //   #108	-> 351
/*     */     //   #109	-> 358
/*     */     //   #116	-> 366
/*     */     //   #117	-> 376
/*     */     //   #120	-> 379
/*     */     //   #121	-> 382
/*     */     //   #123	-> 385
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
/*     */   static DependentItemMap<PostProcessorFactory> prioritizePostProcessors(DependentItemMap<PostProcessorFactory> paramDependentItemMap) {
/*     */     List<?> list;
/* 129 */     (list = paramDependentItemMap.entries()).sort((paramEntry1, paramEntry2) -> {
/*     */           byte b1 = ((DependentItem)paramEntry1.getValue()).isGlobalScope ? 1 : 0;
/*     */           
/*     */           byte b2 = ((DependentItem)paramEntry2.getValue()).isGlobalScope ? 1 : 0;
/*     */           return b1 - b2;
/*     */         });
/*     */     BitSet bitSet;
/* 136 */     if ((bitSet = paramDependentItemMap.keySet().keyDifferenceBitSet(list)).isEmpty()) {
/* 137 */       return paramDependentItemMap;
/*     */     }
/*     */ 
/*     */     
/* 141 */     (paramDependentItemMap = new DependentItemMap(list.size())).addAll(list);
/*     */     
/* 143 */     return paramDependentItemMap;
/*     */   }
/*     */   
/*     */   public static class PostProcessorDependencyStage
/*     */   {
/*     */     final Map<Class<? extends Node>, Set<Class<?>>> myNodeMap;
/*     */     final List<PostProcessorFactory> dependents;
/*     */     
/*     */     public PostProcessorDependencyStage(List<PostProcessorFactory> param1List) {
/* 152 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/* 154 */       for (Iterator<PostProcessorFactory> iterator = param1List.iterator(); iterator.hasNext(); ) {
/*     */         PostProcessorFactory postProcessorFactory; Map map;
/* 156 */         if (((map = (postProcessorFactory = iterator.next()).getNodeTypes()) == null || map.isEmpty()) && !postProcessorFactory.affectsGlobalScope()) {
/* 157 */           throw new IllegalStateException("PostProcessorFactory " + postProcessorFactory + " is not document post processor and has empty node map, does nothing, should not be registered.");
/*     */         }
/*     */         
/* 160 */         if (map != null) {
/* 161 */           for (Map.Entry entry : map.entrySet()) {
/* 162 */             if (Node.class.isAssignableFrom((Class)entry.getKey())) {
/* 163 */               Set<?> set1 = (Set)hashMap.get(entry.getKey());
/* 164 */               Set<?> set2 = (Set)entry.getValue();
/* 165 */               if (set1 == null) {
/*     */                 
/* 167 */                 set1 = new HashSet(set2);
/*     */                 
/* 169 */                 hashMap.put(entry.getKey(), set1); continue;
/*     */               } 
/*     */               try {
/* 172 */                 set1.addAll(set2);
/* 173 */               } catch (UnsupportedOperationException unsupportedOperationException) {
/*     */                 
/* 175 */                 (set1 = new HashSet(set1)).addAll(set2);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 183 */       this.dependents = param1List;
/* 184 */       this.myNodeMap = (Map)hashMap;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\PostProcessorManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */