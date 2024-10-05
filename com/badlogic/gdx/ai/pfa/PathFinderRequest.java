/*    */ package com.badlogic.gdx.ai.pfa;
/*    */ 
/*    */ import com.badlogic.gdx.ai.msg.MessageDispatcher;
/*    */ import com.badlogic.gdx.ai.msg.MessageManager;
/*    */ import com.badlogic.gdx.ai.msg.Telegraph;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathFinderRequest<N>
/*    */ {
/*    */   public static final int SEARCH_NEW = 0;
/*    */   public static final int SEARCH_INITIALIZED = 1;
/*    */   public static final int SEARCH_DONE = 2;
/*    */   public static final int SEARCH_FINALIZED = 3;
/*    */   public N startNode;
/*    */   public N endNode;
/*    */   public Heuristic<N> heuristic;
/*    */   public GraphPath<N> resultPath;
/*    */   public int executionFrames;
/*    */   public boolean pathFound;
/*    */   public int status;
/*    */   public boolean statusChanged;
/*    */   public Telegraph client;
/*    */   public int responseMessageCode;
/*    */   public MessageDispatcher dispatcher;
/*    */   
/*    */   public PathFinderRequest() {}
/*    */   
/*    */   public PathFinderRequest(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<N> paramGraphPath) {
/* 55 */     this(paramN1, paramN2, paramHeuristic, paramGraphPath, (MessageDispatcher)MessageManager.getInstance());
/*    */   }
/*    */ 
/*    */   
/*    */   public PathFinderRequest(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<N> paramGraphPath, MessageDispatcher paramMessageDispatcher) {
/* 60 */     this.startNode = paramN1;
/* 61 */     this.endNode = paramN2;
/* 62 */     this.heuristic = paramHeuristic;
/* 63 */     this.resultPath = paramGraphPath;
/* 64 */     this.dispatcher = paramMessageDispatcher;
/*    */     
/* 66 */     this.executionFrames = 0;
/* 67 */     this.pathFound = false;
/* 68 */     this.status = 0;
/* 69 */     this.statusChanged = false;
/*    */   }
/*    */   
/*    */   public void changeStatus(int paramInt) {
/* 73 */     this.status = paramInt;
/* 74 */     this.statusChanged = true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean initializeSearch(long paramLong) {
/* 81 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean search(PathFinder<N> paramPathFinder, long paramLong) {
/* 88 */     return paramPathFinder.search(this, paramLong);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean finalizeSearch(long paramLong) {
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\PathFinderRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */