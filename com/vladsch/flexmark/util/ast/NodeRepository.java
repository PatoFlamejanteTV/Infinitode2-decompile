/*     */ package com.vladsch.flexmark.util.ast;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Consumer;
/*     */ 
/*     */ public abstract class NodeRepository<T> implements Map<String, T> {
/*  11 */   protected final ArrayList<T> nodeList = new ArrayList<>();
/*  12 */   protected final Map<String, T> nodeMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   protected final KeepType keepType;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SafeVarargs
/*     */   protected final void visitNodes(Node paramNode, Consumer<Node> paramConsumer, Class<? extends Node>... paramVarArgs) {
/*  23 */     NodeVisitor nodeVisitor = new NodeVisitor(); int i; byte b;
/*  24 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Class<? extends Node> clazz = paramVarArgs[b];
/*  25 */       nodeVisitor.addHandler(new VisitHandler<>(clazz, paramConsumer::accept)); b++; }
/*     */     
/*  27 */     nodeVisitor.visit(paramNode);
/*     */   }
/*     */   
/*     */   public NodeRepository(KeepType paramKeepType) {
/*  31 */     this.keepType = (paramKeepType == null) ? KeepType.LOCKED : paramKeepType;
/*     */   }
/*     */   
/*     */   public String normalizeKey(CharSequence paramCharSequence) {
/*  35 */     return paramCharSequence.toString();
/*     */   }
/*     */   
/*     */   public T getFromRaw(CharSequence paramCharSequence) {
/*  39 */     return this.nodeMap.get(normalizeKey(paramCharSequence));
/*     */   }
/*     */   
/*     */   public T putRawKey(CharSequence paramCharSequence, T paramT) {
/*  43 */     return put(normalizeKey(paramCharSequence), paramT);
/*     */   }
/*     */   
/*     */   public Collection<T> getValues() {
/*  47 */     return this.nodeMap.values();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> boolean transferReferences(NodeRepository<T> paramNodeRepository1, NodeRepository<T> paramNodeRepository2, boolean paramBoolean, Map<String, String> paramMap) {
/*  52 */     boolean bool = false;
/*  53 */     for (Iterator<Map.Entry> iterator = paramNodeRepository2.entrySet().iterator(); iterator.hasNext(); ) {
/*  54 */       Map.Entry<String, ?> entry; String str = (entry = iterator.next()).getKey();
/*     */ 
/*     */       
/*  57 */       if (paramMap != null) paramMap.getOrDefault(str, str);
/*     */       
/*  59 */       if (!paramBoolean || !paramNodeRepository1.containsKey(str)) {
/*  60 */         paramNodeRepository1.put(str, (T)entry.getValue());
/*  61 */         bool = true;
/*     */       } 
/*     */     } 
/*  64 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public T put(String paramString, T paramT) {
/*  69 */     this.nodeList.add(paramT);
/*     */     
/*  71 */     if (this.keepType == KeepType.LOCKED) throw new IllegalStateException("Not allowed to modify LOCKED repository");  T t;
/*  72 */     if (this.keepType != KeepType.LAST && (
/*     */       
/*  74 */       t = this.nodeMap.get(paramString)) != null) {
/*  75 */       if (this.keepType == KeepType.FAIL) throw new IllegalStateException("Duplicate key " + paramString); 
/*  76 */       return t;
/*     */     } 
/*     */     
/*  79 */     return this.nodeMap.put(paramString, paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends String, ? extends T> paramMap) {
/*  84 */     if (this.keepType == KeepType.LOCKED) throw new IllegalStateException("Not allowed to modify LOCKED repository"); 
/*  85 */     if (this.keepType != KeepType.LAST) {
/*  86 */       for (String str : paramMap.keySet())
/*  87 */         this.nodeMap.put(str, paramMap.get(str)); 
/*     */       return;
/*     */     } 
/*  90 */     this.nodeMap.putAll(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T remove(Object paramObject) {
/*  96 */     if (this.keepType == KeepType.LOCKED) throw new IllegalStateException("Not allowed to modify LOCKED repository"); 
/*  97 */     return this.nodeMap.remove(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 102 */     if (this.keepType == KeepType.LOCKED) throw new IllegalStateException("Not allowed to modify LOCKED repository"); 
/* 103 */     this.nodeMap.clear();
/*     */   }
/*     */   
/*     */   public int size() {
/* 107 */     return this.nodeMap.size();
/*     */   }
/*     */   public boolean isEmpty() {
/* 110 */     return this.nodeMap.isEmpty();
/*     */   }
/*     */   public boolean containsKey(Object paramObject) {
/* 113 */     return this.nodeMap.containsKey(paramObject);
/*     */   }
/*     */   public boolean containsValue(Object paramObject) {
/* 116 */     return this.nodeMap.containsValue(paramObject);
/*     */   }
/*     */   public T get(Object paramObject) {
/* 119 */     return this.nodeMap.get(paramObject);
/*     */   }
/*     */   
/*     */   public Set<String> keySet() {
/* 123 */     return this.nodeMap.keySet();
/*     */   }
/*     */   
/*     */   public List<T> values() {
/* 127 */     return this.nodeList;
/*     */   }
/*     */   
/*     */   public Set<Map.Entry<String, T>> entrySet() {
/* 131 */     return this.nodeMap.entrySet();
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 135 */     return this.nodeMap.equals(paramObject);
/*     */   }
/*     */   public int hashCode() {
/* 138 */     return this.nodeMap.hashCode();
/*     */   }
/*     */   
/*     */   public abstract DataKey<? extends NodeRepository<T>> getDataKey();
/*     */   
/*     */   public abstract DataKey<KeepType> getKeepDataKey();
/*     */   
/*     */   public abstract Set<T> getReferencedElements(Node paramNode);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */