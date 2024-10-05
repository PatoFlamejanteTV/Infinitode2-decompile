/*     */ package com.badlogic.gdx.ai.pfa.indexed;
/*     */ 
/*     */ import com.badlogic.gdx.ai.pfa.Connection;
/*     */ import com.badlogic.gdx.ai.pfa.GraphPath;
/*     */ import com.badlogic.gdx.ai.pfa.Heuristic;
/*     */ import com.badlogic.gdx.ai.pfa.PathFinder;
/*     */ import com.badlogic.gdx.ai.pfa.PathFinderRequest;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.BinaryHeap;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
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
/*     */ public class IndexedAStarPathFinder<N>
/*     */   implements PathFinder<N>
/*     */ {
/*     */   IndexedGraph<N> graph;
/*     */   NodeRecord<N>[] nodeRecords;
/*     */   BinaryHeap<NodeRecord<N>> openList;
/*     */   NodeRecord<N> current;
/*     */   public Metrics metrics;
/*     */   private int searchId;
/*     */   private static final int UNVISITED = 0;
/*     */   private static final int OPEN = 1;
/*     */   private static final int CLOSED = 2;
/*     */   
/*     */   public IndexedAStarPathFinder(IndexedGraph<N> paramIndexedGraph) {
/*  65 */     this(paramIndexedGraph, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexedAStarPathFinder(IndexedGraph<N> paramIndexedGraph, boolean paramBoolean) {
/*  70 */     this.graph = paramIndexedGraph;
/*  71 */     this.nodeRecords = (NodeRecord<N>[])new NodeRecord[paramIndexedGraph.getNodeCount()];
/*  72 */     this.openList = new BinaryHeap();
/*  73 */     if (paramBoolean) this.metrics = new Metrics();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean searchConnectionPath(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<Connection<N>> paramGraphPath) {
/*     */     boolean bool;
/*  82 */     if (bool = search(paramN1, paramN2, paramHeuristic))
/*     */     {
/*  84 */       generateConnectionPath(paramN1, paramGraphPath);
/*     */     }
/*     */     
/*  87 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean searchNodePath(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<N> paramGraphPath) {
/*     */     boolean bool;
/*  96 */     if (bool = search(paramN1, paramN2, paramHeuristic))
/*     */     {
/*  98 */       generateNodePath(paramN1, paramGraphPath);
/*     */     }
/*     */     
/* 101 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean search(N paramN1, N paramN2, Heuristic<N> paramHeuristic) {
/* 106 */     initSearch(paramN1, paramN2, paramHeuristic);
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 111 */       this.current = (NodeRecord<N>)this.openList.pop();
/* 112 */       this.current.category = 2;
/*     */ 
/*     */       
/* 115 */       if (this.current.node == paramN2) return true;
/*     */       
/* 117 */       visitChildren(paramN2, paramHeuristic);
/*     */     }
/* 119 */     while (this.openList.size > 0);
/*     */ 
/*     */     
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean search(PathFinderRequest<N> paramPathFinderRequest, long paramLong) {
/* 128 */     long l = TimeUtils.nanoTime();
/*     */ 
/*     */     
/* 131 */     if (paramPathFinderRequest.statusChanged) {
/* 132 */       initSearch((N)paramPathFinderRequest.startNode, (N)paramPathFinderRequest.endNode, paramPathFinderRequest.heuristic);
/* 133 */       paramPathFinderRequest.statusChanged = false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 140 */       long l1 = TimeUtils.nanoTime();
/*     */       
/* 142 */       if ((paramLong = paramLong - l1 - l) <= 100L) return false;
/*     */ 
/*     */       
/* 145 */       this.current = (NodeRecord<N>)this.openList.pop();
/* 146 */       this.current.category = 2;
/*     */ 
/*     */       
/* 149 */       if (this.current.node == paramPathFinderRequest.endNode) {
/* 150 */         paramPathFinderRequest.pathFound = true;
/*     */         
/* 152 */         generateNodePath((N)paramPathFinderRequest.startNode, paramPathFinderRequest.resultPath);
/*     */         
/* 154 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 158 */       visitChildren((N)paramPathFinderRequest.endNode, paramPathFinderRequest.heuristic);
/*     */ 
/*     */       
/* 161 */       l = l1;
/*     */     }
/* 163 */     while (this.openList.size > 0);
/*     */ 
/*     */     
/* 166 */     paramPathFinderRequest.pathFound = false;
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   protected void initSearch(N paramN1, N paramN2, Heuristic<N> paramHeuristic) {
/* 171 */     if (this.metrics != null) this.metrics.reset();
/*     */ 
/*     */     
/* 174 */     if (++this.searchId < 0) this.searchId = 1;
/*     */ 
/*     */     
/* 177 */     this.openList.clear();
/*     */     
/*     */     NodeRecord<N> nodeRecord;
/*     */     
/* 181 */     (nodeRecord = getNodeRecord(paramN1)).node = paramN1;
/* 182 */     nodeRecord.connection = null;
/* 183 */     nodeRecord.costSoFar = 0.0F;
/* 184 */     addToOpenList(nodeRecord, paramHeuristic.estimate(paramN1, paramN2));
/*     */     
/* 186 */     this.current = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void visitChildren(N paramN, Heuristic<N> paramHeuristic) {
/* 191 */     Array array = this.graph.getConnections(this.current.node);
/*     */ 
/*     */     
/* 194 */     for (byte b = 0; b < array.size; b++) {
/* 195 */       float f1; if (this.metrics != null) this.metrics.visitedNodes++;
/*     */ 
/*     */       
/*     */       Connection<N> connection;
/*     */       
/* 200 */       Object object = (connection = (Connection)array.get(b)).getToNode();
/* 201 */       float f2 = this.current.costSoFar + connection.getCost();
/*     */       
/*     */       NodeRecord<N> nodeRecord;
/*     */       
/* 205 */       if ((nodeRecord = getNodeRecord((N)object)).category == 2) {
/*     */ 
/*     */         
/* 208 */         if (nodeRecord.costSoFar > f2)
/*     */         
/*     */         { 
/*     */           
/* 212 */           f1 = nodeRecord.getEstimatedTotalCost() - nodeRecord.costSoFar; } else { continue; } 
/* 213 */       } else if (nodeRecord.category == 1) {
/*     */ 
/*     */         
/* 216 */         if (nodeRecord.costSoFar > f2) {
/*     */ 
/*     */           
/* 219 */           this.openList.remove(nodeRecord);
/*     */ 
/*     */ 
/*     */           
/* 223 */           f1 = nodeRecord.getEstimatedTotalCost() - nodeRecord.costSoFar;
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */       } else {
/* 228 */         f1 = paramHeuristic.estimate(f1, paramN);
/*     */       } 
/*     */ 
/*     */       
/* 232 */       nodeRecord.costSoFar = f2;
/* 233 */       nodeRecord.connection = connection;
/*     */ 
/*     */       
/* 236 */       addToOpenList(nodeRecord, f2 + f1);
/*     */       continue;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateConnectionPath(N paramN, GraphPath<Connection<N>> paramGraphPath) {
/* 245 */     while (this.current.node != paramN) {
/* 246 */       paramGraphPath.add(this.current.connection);
/* 247 */       this.current = this.nodeRecords[this.graph.getIndex((N)this.current.connection.getFromNode())];
/*     */     } 
/*     */ 
/*     */     
/* 251 */     paramGraphPath.reverse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateNodePath(N paramN, GraphPath<N> paramGraphPath) {
/* 258 */     while (this.current.connection != null) {
/* 259 */       paramGraphPath.add(this.current.node);
/* 260 */       this.current = this.nodeRecords[this.graph.getIndex((N)this.current.connection.getFromNode())];
/*     */     } 
/* 262 */     paramGraphPath.add(paramN);
/*     */ 
/*     */     
/* 265 */     paramGraphPath.reverse();
/*     */   }
/*     */   
/*     */   protected void addToOpenList(NodeRecord<N> paramNodeRecord, float paramFloat) {
/* 269 */     this.openList.add(paramNodeRecord, paramFloat);
/* 270 */     paramNodeRecord.category = 1;
/* 271 */     if (this.metrics != null) {
/* 272 */       this.metrics.openListAdditions++;
/* 273 */       this.metrics.openListPeak = Math.max(this.metrics.openListPeak, this.openList.size);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected NodeRecord<N> getNodeRecord(N paramN) {
/* 278 */     int i = this.graph.getIndex(paramN);
/*     */     NodeRecord<N> nodeRecord;
/* 280 */     if ((nodeRecord = this.nodeRecords[i]) != null) {
/* 281 */       if (nodeRecord.searchId != this.searchId) {
/* 282 */         nodeRecord.category = 0;
/* 283 */         nodeRecord.searchId = this.searchId;
/*     */       } 
/* 285 */       return nodeRecord;
/*     */     } 
/* 287 */     this.nodeRecords[i] = new NodeRecord<>();
/* 288 */     (nodeRecord = new NodeRecord<>()).node = paramN;
/* 289 */     nodeRecord.searchId = this.searchId;
/* 290 */     return nodeRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class NodeRecord<N>
/*     */     extends BinaryHeap.Node
/*     */   {
/*     */     N node;
/*     */ 
/*     */     
/*     */     Connection<N> connection;
/*     */ 
/*     */     
/*     */     float costSoFar;
/*     */ 
/*     */     
/*     */     int category;
/*     */ 
/*     */     
/*     */     int searchId;
/*     */ 
/*     */ 
/*     */     
/*     */     public NodeRecord() {
/* 316 */       super(0.0F);
/*     */     }
/*     */ 
/*     */     
/*     */     public float getEstimatedTotalCost() {
/* 321 */       return getValue();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Metrics
/*     */   {
/*     */     public int visitedNodes;
/*     */     
/*     */     public int openListAdditions;
/*     */     
/*     */     public int openListPeak;
/*     */ 
/*     */     
/*     */     public void reset() {
/* 337 */       this.visitedNodes = 0;
/* 338 */       this.openListAdditions = 0;
/* 339 */       this.openListPeak = 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\indexed\IndexedAStarPathFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */