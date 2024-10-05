/*     */ package com.badlogic.gdx.ai.fsm;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ public class StackStateMachine<E, S extends State<E>>
/*     */   extends DefaultStateMachine<E, S>
/*     */ {
/*     */   private Array<S> stateStack;
/*     */   
/*     */   public StackStateMachine() {
/*  35 */     this((E)null, (S)null, (S)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StackStateMachine(E paramE) {
/*  41 */     this(paramE, (S)null, (S)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackStateMachine(E paramE, S paramS) {
/*  48 */     this(paramE, paramS, (S)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackStateMachine(E paramE, S paramS1, S paramS2) {
/*  56 */     super(paramE, paramS1, paramS2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInitialState(S paramS) {
/*  61 */     if (this.stateStack == null) {
/*  62 */       this.stateStack = new Array();
/*     */     }
/*     */     
/*  65 */     this.stateStack.clear();
/*  66 */     this.currentState = paramS;
/*     */   }
/*     */ 
/*     */   
/*     */   public S getCurrentState() {
/*  71 */     return this.currentState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public S getPreviousState() {
/*  77 */     if (this.stateStack.size == 0) {
/*  78 */       return null;
/*     */     }
/*  80 */     return (S)this.stateStack.peek();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeState(S paramS) {
/*  86 */     changeState(paramS, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean revertToPreviousState() {
/*  94 */     if (this.stateStack.size == 0) {
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     State state = (State)this.stateStack.pop();
/*  99 */     changeState((S)state, false);
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   private void changeState(S paramS, boolean paramBoolean) {
/* 104 */     if (paramBoolean && this.currentState != null) {
/* 105 */       this.stateStack.add(this.currentState);
/*     */     }
/*     */ 
/*     */     
/* 109 */     if (this.currentState != null) this.currentState.exit(this.owner);
/*     */ 
/*     */     
/* 112 */     this.currentState = paramS;
/*     */ 
/*     */     
/* 115 */     this.currentState.enter(this.owner);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fsm\StackStateMachine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */