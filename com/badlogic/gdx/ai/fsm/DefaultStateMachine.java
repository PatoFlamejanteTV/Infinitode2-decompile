/*     */ package com.badlogic.gdx.ai.fsm;
/*     */ 
/*     */ import com.badlogic.gdx.ai.msg.Telegram;
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
/*     */ public class DefaultStateMachine<E, S extends State<E>>
/*     */   implements StateMachine<E, S>
/*     */ {
/*     */   protected E owner;
/*     */   protected S currentState;
/*     */   protected S previousState;
/*     */   protected S globalState;
/*     */   
/*     */   public DefaultStateMachine() {
/*  43 */     this(null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultStateMachine(E paramE) {
/*  49 */     this(paramE, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultStateMachine(E paramE, S paramS) {
/*  56 */     this(paramE, paramS, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultStateMachine(E paramE, S paramS1, S paramS2) {
/*  64 */     this.owner = paramE;
/*  65 */     setInitialState(paramS1);
/*  66 */     setGlobalState(paramS2);
/*     */   }
/*     */   
/*     */   public E getOwner() {
/*  70 */     return this.owner;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwner(E paramE) {
/*  76 */     this.owner = paramE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInitialState(S paramS) {
/*  81 */     this.previousState = null;
/*  82 */     this.currentState = paramS;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGlobalState(S paramS) {
/*  87 */     this.globalState = paramS;
/*     */   }
/*     */ 
/*     */   
/*     */   public S getCurrentState() {
/*  92 */     return this.currentState;
/*     */   }
/*     */ 
/*     */   
/*     */   public S getGlobalState() {
/*  97 */     return this.globalState;
/*     */   }
/*     */ 
/*     */   
/*     */   public S getPreviousState() {
/* 102 */     return this.previousState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/* 110 */     if (this.globalState != null) this.globalState.update(this.owner);
/*     */ 
/*     */     
/* 113 */     if (this.currentState != null) this.currentState.update(this.owner);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void changeState(S paramS) {
/* 119 */     this.previousState = this.currentState;
/*     */ 
/*     */     
/* 122 */     if (this.currentState != null) this.currentState.exit(this.owner);
/*     */ 
/*     */     
/* 125 */     this.currentState = paramS;
/*     */ 
/*     */     
/* 128 */     if (this.currentState != null) this.currentState.enter(this.owner);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean revertToPreviousState() {
/* 133 */     if (this.previousState == null) {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     changeState(this.previousState);
/* 138 */     return true;
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
/*     */   public boolean isInState(S paramS) {
/* 150 */     return (this.currentState == paramS);
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
/*     */   public boolean handleMessage(Telegram paramTelegram) {
/* 162 */     if (this.currentState != null && this.currentState.onMessage(this.owner, paramTelegram)) {
/* 163 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (this.globalState != null && this.globalState.onMessage(this.owner, paramTelegram)) {
/* 169 */       return true;
/*     */     }
/*     */     
/* 172 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fsm\DefaultStateMachine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */