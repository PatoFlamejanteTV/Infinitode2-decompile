/*     */ package com.badlogic.gdx.ai.pfa;
/*     */ 
/*     */ import com.badlogic.gdx.ai.GdxAI;
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
/*     */ public class HierarchicalPathFinder<N>
/*     */   implements PathFinder<N>
/*     */ {
/*     */   private static final String TAG = "HierarchicalPathFinder";
/*     */   public static boolean DEBUG = false;
/*     */   HierarchicalGraph<N> graph;
/*     */   PathFinder<N> levelPathFinder;
/*     */   LevelPathFinderRequest<N> levelRequest;
/*     */   PathFinderRequestControl<N> levelRequestControl;
/*     */   
/*     */   public HierarchicalPathFinder(HierarchicalGraph<N> paramHierarchicalGraph, PathFinder<N> paramPathFinder) {
/*  48 */     this.graph = paramHierarchicalGraph;
/*  49 */     this.levelPathFinder = paramPathFinder;
/*  50 */     this.levelRequest = null;
/*  51 */     this.levelRequestControl = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean searchNodePath(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<N> paramGraphPath) {
/*  57 */     if (paramN1 == paramN2) return true;
/*     */ 
/*     */ 
/*     */     
/*  61 */     N n = paramN2;
/*  62 */     int i = 0;
/*     */ 
/*     */     
/*  65 */     int j = this.graph.getLevelCount() - 1;
/*  66 */     while (j >= 0) {
/*     */       
/*  68 */       N n1 = this.graph.convertNodeBetweenLevels(0, paramN1, j);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  73 */       n = this.graph.convertNodeBetweenLevels(i, n, j); N n2;
/*  74 */       if (j == 0 && (
/*     */         
/*  76 */         n2 = this.graph.convertNodeBetweenLevels(0, n, 1)) == this.graph.convertNodeBetweenLevels(0, paramN2, 1) && n2 == this.graph
/*  77 */         .convertNodeBetweenLevels(0, paramN1, 1)) {
/*  78 */         n = paramN2;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  83 */       i = j;
/*  84 */       j--;
/*  85 */       if (n1 != n) {
/*     */ 
/*     */         
/*  88 */         this.graph.setLevel(i);
/*  89 */         paramGraphPath.clear();
/*     */         
/*     */         boolean bool;
/*  92 */         if (!(bool = this.levelPathFinder.searchNodePath(n1, n, paramHeuristic, paramGraphPath))) return false;
/*     */ 
/*     */         
/*  95 */         n = paramGraphPath.get(1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean searchConnectionPath(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<Connection<N>> paramGraphPath) {
/* 106 */     if (paramN1 == paramN2) return true;
/*     */ 
/*     */ 
/*     */     
/* 110 */     N n = paramN2;
/* 111 */     int i = 0;
/*     */ 
/*     */     
/* 114 */     int j = this.graph.getLevelCount() - 1;
/* 115 */     while (j >= 0) {
/*     */       
/* 117 */       N n1 = this.graph.convertNodeBetweenLevels(0, paramN1, j);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 122 */       n = this.graph.convertNodeBetweenLevels(i, n, j); N n2;
/* 123 */       if (j == 0 && (
/*     */         
/* 125 */         n2 = this.graph.convertNodeBetweenLevels(0, n, 1)) == this.graph.convertNodeBetweenLevels(0, paramN2, 1) && n2 == this.graph
/* 126 */         .convertNodeBetweenLevels(0, paramN1, 1)) {
/* 127 */         n = paramN2;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 132 */       i = j;
/* 133 */       j--;
/* 134 */       if (n1 != n) {
/*     */ 
/*     */         
/* 137 */         this.graph.setLevel(i);
/* 138 */         paramGraphPath.clear();
/*     */         
/*     */         boolean bool;
/* 141 */         if (!(bool = this.levelPathFinder.searchConnectionPath(n1, n, paramHeuristic, paramGraphPath))) return false;
/*     */ 
/*     */         
/* 144 */         n = ((Connection<N>)paramGraphPath.get(0)).getToNode();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean search(PathFinderRequest<N> paramPathFinderRequest, long paramLong) {
/* 154 */     if (DEBUG) GdxAI.getLogger().debug("HierarchicalPathFinder", "Enter interruptible HPF; request.status = " + paramPathFinderRequest.status);
/*     */ 
/*     */     
/* 157 */     if (this.levelRequest == null) {
/* 158 */       this.levelRequest = new LevelPathFinderRequest<>();
/* 159 */       this.levelRequestControl = new PathFinderRequestControl<>();
/*     */     } 
/*     */ 
/*     */     
/* 163 */     if (paramPathFinderRequest.statusChanged) {
/* 164 */       if (DEBUG) GdxAI.getLogger().debug("HierarchicalPathFinder", "-- statusChanged");
/*     */ 
/*     */       
/* 167 */       if (paramPathFinderRequest.startNode == paramPathFinderRequest.endNode) return true;
/*     */ 
/*     */       
/* 170 */       this.levelRequestControl.lastTime = TimeUtils.nanoTime();
/* 171 */       this.levelRequestControl.timeToRun = paramLong;
/* 172 */       this.levelRequestControl.timeTolerance = 100L;
/* 173 */       this.levelRequestControl.server = null;
/* 174 */       this.levelRequestControl.pathFinder = this.levelPathFinder;
/*     */ 
/*     */       
/* 177 */       this.levelRequest.hpf = this;
/* 178 */       this.levelRequest.hpfRequest = paramPathFinderRequest;
/* 179 */       this.levelRequest.status = 0;
/* 180 */       this.levelRequest.statusChanged = true;
/* 181 */       this.levelRequest.heuristic = paramPathFinderRequest.heuristic;
/* 182 */       this.levelRequest.resultPath = paramPathFinderRequest.resultPath;
/* 183 */       this.levelRequest.startNode = paramPathFinderRequest.startNode;
/* 184 */       this.levelRequest.endNode = paramPathFinderRequest.endNode;
/* 185 */       this.levelRequest.levelOfNodes = 0;
/* 186 */       this.levelRequest.currentLevel = this.graph.getLevelCount() - 1;
/*     */     } 
/*     */     
/* 189 */     while (this.levelRequest.currentLevel >= 0) {
/*     */       boolean bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       if (!(bool = this.levelRequestControl.execute(this.levelRequest))) {
/* 198 */         return false;
/*     */       }
/*     */       
/* 201 */       this.levelRequest.executionFrames = 0;
/*     */       
/* 203 */       this.levelRequest.status = 0;
/* 204 */       this.levelRequest.statusChanged = true;
/*     */       
/* 206 */       if (!this.levelRequest.pathFound) return true;
/*     */     
/*     */     } 
/*     */     
/* 210 */     if (DEBUG) GdxAI.getLogger().debug("HierarchicalPathFinder", "-- before exit");
/*     */     
/* 212 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   static class LevelPathFinderRequest<N>
/*     */     extends PathFinderRequest<N>
/*     */   {
/*     */     HierarchicalPathFinder<N> hpf;
/*     */     
/*     */     PathFinderRequest<N> hpfRequest;
/*     */     
/*     */     int levelOfNodes;
/*     */     
/*     */     int currentLevel;
/*     */     
/*     */     public boolean initializeSearch(long param1Long) {
/* 228 */       this.executionFrames = 0;
/* 229 */       this.pathFound = false;
/* 230 */       this.status = 0;
/* 231 */       this.statusChanged = false;
/*     */ 
/*     */       
/*     */       while (true) {
/* 235 */         this.startNode = this.hpf.graph.convertNodeBetweenLevels(0, this.hpfRequest.startNode, this.currentLevel);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 240 */         this.endNode = this.hpf.graph.convertNodeBetweenLevels(this.levelOfNodes, this.endNode, this.currentLevel);
/* 241 */         if (this.currentLevel == 0 && (
/*     */           
/* 243 */           param1Long = this.hpf.graph.convertNodeBetweenLevels(0, this.endNode, 1)) == this.hpf.graph.convertNodeBetweenLevels(0, this.hpfRequest.endNode, 1) && param1Long == this.hpf.graph
/* 244 */           .convertNodeBetweenLevels(0, this.hpfRequest.startNode, 1)) {
/* 245 */           this.endNode = this.hpfRequest.endNode;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 251 */         if (HierarchicalPathFinder.DEBUG) GdxAI.getLogger().debug("HierarchicalPathFinder", "LevelPathFinder initializeSearch"); 
/* 252 */         this.levelOfNodes = this.currentLevel;
/* 253 */         this.currentLevel--;
/* 254 */         if (this.startNode == this.endNode) {
/*     */           
/* 256 */           if (this.currentLevel < 0)
/*     */             break;  continue;
/*     */         }  break;
/* 259 */       }  this.hpf.graph.setLevel(this.levelOfNodes);
/* 260 */       this.resultPath.clear();
/* 261 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean search(PathFinder<N> param1PathFinder, long param1Long) {
/* 266 */       if (HierarchicalPathFinder.DEBUG) GdxAI.getLogger().debug("HierarchicalPathFinder", "LevelPathFinder search; status: " + this.status); 
/* 267 */       return super.search(param1PathFinder, param1Long);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean finalizeSearch(long param1Long) {
/* 272 */       this.hpfRequest.pathFound = this.pathFound;
/* 273 */       if (this.pathFound)
/*     */       {
/* 275 */         this.endNode = this.resultPath.get(1);
/*     */       }
/* 277 */       if (HierarchicalPathFinder.DEBUG) GdxAI.getLogger().debug("HierarchicalPathFinder", "LevelPathFinder finalizeSearch; status: " + this.status); 
/* 278 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\HierarchicalPathFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */