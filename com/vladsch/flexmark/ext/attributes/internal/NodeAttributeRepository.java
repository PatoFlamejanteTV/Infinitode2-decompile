/*    */ package com.vladsch.flexmark.ext.attributes.internal;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesExtension;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesNode;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class NodeAttributeRepository implements Map<Node, ArrayList<AttributesNode>> {
/* 15 */   protected final HashMap<Node, ArrayList<AttributesNode>> nodeAttributesHashMap = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<NodeAttributeRepository> getDataKey() {
/* 21 */     return AttributesExtension.NODE_ATTRIBUTES;
/*    */   }
/*    */   
/*    */   public DataKey<KeepType> getKeepDataKey() {
/* 25 */     return AttributesExtension.ATTRIBUTES_KEEP;
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 30 */     return this.nodeAttributesHashMap.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEmpty() {
/* 35 */     return this.nodeAttributesHashMap.isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsKey(Object paramObject) {
/* 40 */     return this.nodeAttributesHashMap.containsKey(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsValue(Object paramObject) {
/* 45 */     return this.nodeAttributesHashMap.containsValue(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList<AttributesNode> get(Object paramObject) {
/* 50 */     return this.nodeAttributesHashMap.get(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList<AttributesNode> put(Node paramNode, ArrayList<AttributesNode> paramArrayList) {
/* 55 */     return this.nodeAttributesHashMap.put(paramNode, paramArrayList);
/*    */   }
/*    */   
/*    */   public ArrayList<AttributesNode> put(Node paramNode, AttributesNode paramAttributesNode) {
/*    */     ArrayList<AttributesNode> arrayList;
/* 60 */     if ((arrayList = this.nodeAttributesHashMap.get(paramNode)) == null) {
/* 61 */       arrayList = new ArrayList();
/* 62 */       this.nodeAttributesHashMap.put(paramNode, arrayList);
/*    */     } 
/* 64 */     arrayList.add(paramAttributesNode);
/* 65 */     return arrayList;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList<AttributesNode> remove(Object paramObject) {
/* 70 */     return this.nodeAttributesHashMap.remove(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void putAll(Map<? extends Node, ? extends ArrayList<AttributesNode>> paramMap) {
/* 75 */     this.nodeAttributesHashMap.putAll(paramMap);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 80 */     this.nodeAttributesHashMap.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Node> keySet() {
/* 86 */     return this.nodeAttributesHashMap.keySet();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection<ArrayList<AttributesNode>> values() {
/* 92 */     return this.nodeAttributesHashMap.values();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Map.Entry<Node, ArrayList<AttributesNode>>> entrySet() {
/* 98 */     return this.nodeAttributesHashMap.entrySet();
/*    */   }
/*    */   
/*    */   public NodeAttributeRepository(DataHolder paramDataHolder) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\NodeAttributeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */