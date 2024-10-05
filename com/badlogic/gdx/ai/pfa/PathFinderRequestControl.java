/*    */ package com.badlogic.gdx.ai.pfa;
/*    */ 
/*    */ import com.badlogic.gdx.ai.msg.MessageManager;
/*    */ import com.badlogic.gdx.ai.msg.Telegraph;
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
/*    */ public class PathFinderRequestControl<N>
/*    */ {
/*    */   private static final String TAG = "PathFinderRequestControl";
/*    */   public static final boolean DEBUG = false;
/*    */   Telegraph server;
/*    */   PathFinder<N> pathFinder;
/*    */   long lastTime;
/*    */   long timeToRun;
/*    */   long timeTolerance;
/*    */   
/*    */   public boolean execute(PathFinderRequest<N> paramPathFinderRequest) {
/* 50 */     paramPathFinderRequest.executionFrames++;
/*    */ 
/*    */ 
/*    */     
/*    */     while (true) {
/* 55 */       if (paramPathFinderRequest.status == 0) {
/* 56 */         long l = TimeUtils.nanoTime();
/* 57 */         this.timeToRun -= l - this.lastTime;
/* 58 */         if (this.timeToRun <= this.timeTolerance) return false;
/*    */         
/* 60 */         if (!paramPathFinderRequest.initializeSearch(this.timeToRun)) return false; 
/* 61 */         paramPathFinderRequest.changeStatus(1);
/* 62 */         this.lastTime = l;
/*    */       } 
/*    */ 
/*    */       
/* 66 */       if (paramPathFinderRequest.status == 1) {
/* 67 */         long l = TimeUtils.nanoTime();
/* 68 */         this.timeToRun -= l - this.lastTime;
/* 69 */         if (this.timeToRun <= this.timeTolerance) return false;
/*    */         
/* 71 */         if (!paramPathFinderRequest.search(this.pathFinder, this.timeToRun)) return false; 
/* 72 */         paramPathFinderRequest.changeStatus(2);
/* 73 */         this.lastTime = l;
/*    */       } 
/*    */ 
/*    */       
/* 77 */       if (paramPathFinderRequest.status == 2) {
/* 78 */         long l = TimeUtils.nanoTime();
/* 79 */         this.timeToRun -= l - this.lastTime;
/* 80 */         if (this.timeToRun <= this.timeTolerance) return false;
/*    */         
/* 82 */         if (!paramPathFinderRequest.finalizeSearch(this.timeToRun)) return false; 
/* 83 */         paramPathFinderRequest.changeStatus(3);
/*    */ 
/*    */         
/* 86 */         if (this.server != null) {
/*    */           Object object;
/* 88 */           (object = (paramPathFinderRequest.dispatcher != null) ? paramPathFinderRequest.dispatcher : MessageManager.getInstance()).dispatchMessage(this.server, paramPathFinderRequest.client, paramPathFinderRequest.responseMessageCode, paramPathFinderRequest);
/*    */         } 
/*    */         
/* 91 */         this.lastTime = l;
/*    */         
/* 93 */         if (!paramPathFinderRequest.statusChanged || paramPathFinderRequest.status != 0)
/*    */           break; 
/*    */         continue;
/*    */       } 
/*    */       break;
/*    */     } 
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\PathFinderRequestControl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */