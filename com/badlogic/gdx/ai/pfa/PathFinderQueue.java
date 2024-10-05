/*    */ package com.badlogic.gdx.ai.pfa;
/*    */ 
/*    */ import com.badlogic.gdx.ai.msg.Telegram;
/*    */ import com.badlogic.gdx.ai.msg.Telegraph;
/*    */ import com.badlogic.gdx.ai.sched.Schedulable;
/*    */ import com.badlogic.gdx.ai.utils.CircularBuffer;
/*    */ import com.badlogic.gdx.utils.TimeUtils;
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
/*    */ public class PathFinderQueue<N>
/*    */   implements Telegraph, Schedulable
/*    */ {
/*    */   public static final long TIME_TOLERANCE = 100L;
/*    */   CircularBuffer<PathFinderRequest<N>> requestQueue;
/*    */   PathFinder<N> pathFinder;
/*    */   PathFinderRequest<N> currentRequest;
/*    */   PathFinderRequestControl<N> requestControl;
/*    */   
/*    */   public PathFinderQueue(PathFinder<N> paramPathFinder) {
/* 41 */     this.pathFinder = paramPathFinder;
/* 42 */     this.requestQueue = new CircularBuffer(16);
/* 43 */     this.currentRequest = null;
/* 44 */     this.requestControl = new PathFinderRequestControl<>();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void run(long paramLong) {
/* 50 */     this.requestControl.lastTime = TimeUtils.nanoTime();
/* 51 */     this.requestControl.timeToRun = paramLong;
/*    */     
/* 53 */     this.requestControl.timeTolerance = 100L;
/* 54 */     this.requestControl.pathFinder = this.pathFinder;
/* 55 */     this.requestControl.server = this;
/*    */ 
/*    */     
/* 58 */     if (this.currentRequest == null) this.currentRequest = (PathFinderRequest<N>)this.requestQueue.read();
/*    */     
/* 60 */     while (this.currentRequest != null) {
/*    */       boolean bool;
/*    */ 
/*    */       
/* 64 */       if (!(bool = this.requestControl.execute(this.currentRequest))) {
/*    */         return;
/*    */       }
/* 67 */       this.currentRequest = (PathFinderRequest<N>)this.requestQueue.read();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean handleMessage(Telegram paramTelegram) {
/*    */     PathFinderRequest pathFinderRequest;
/* 75 */     (pathFinderRequest = (PathFinderRequest)paramTelegram.extraInfo).client = paramTelegram.sender;
/* 76 */     pathFinderRequest.status = 0;
/* 77 */     pathFinderRequest.statusChanged = true;
/* 78 */     pathFinderRequest.executionFrames = 0;
/* 79 */     this.requestQueue.store(pathFinderRequest);
/* 80 */     return true;
/*    */   }
/*    */   
/*    */   public int size() {
/* 84 */     return this.requestQueue.size();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\PathFinderQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */