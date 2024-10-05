/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Action;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.managers.ReplayManager;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class StateSystem
/*     */   extends GameSystem {
/*  19 */   private static final TLog c = TLog.forClass(StateSystem.class);
/*     */   
/*     */   @NAGS
/*     */   public boolean updateRequired;
/*     */   @NAGS
/*     */   private boolean d = false;
/*     */   @NAGS
/*     */   private int e;
/*     */   @NAGS
/*     */   public ReplayManager.ReplayRecord replayRecord;
/*     */   @NAGS
/*     */   public StateSystem duplicateActionsTo;
/*     */   @NAGS
/*     */   public boolean inUpdateStage = false;
/*     */   public int updateNumber;
/*  34 */   protected IntMap<ActionsArray> a = new IntMap();
/*  35 */   protected Array<ActionUpdatePair> b = new Array(ActionUpdatePair.class); @NAGS
/*     */   public boolean replayMode;
/*     */   @NAGS
/*     */   public long replayFrameCount;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  41 */     super.write(paramKryo, paramOutput);
/*  42 */     paramOutput.writeInt(this.updateNumber);
/*  43 */     paramKryo.writeObject(paramOutput, this.a);
/*  44 */     paramKryo.writeObject(paramOutput, this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  49 */     super.read(paramKryo, paramInput);
/*  50 */     this.updateNumber = paramInput.readInt();
/*  51 */     this.a = (IntMap<ActionsArray>)paramKryo.readObject(paramInput, IntMap.class);
/*  52 */     this.b = (Array<ActionUpdatePair>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean affectsGameState() {
/*  57 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSystemName() {
/*  62 */     return "State";
/*     */   }
/*     */   
/*     */   public boolean isFastForwarding() {
/*  66 */     return this.d;
/*     */   }
/*     */   
/*     */   public int getFastForwardUpdateNumber() {
/*  70 */     return this.e;
/*     */   }
/*     */   
/*     */   public void startFastForwarding(int paramInt) {
/*  74 */     this.d = true;
/*  75 */     this.e = paramInt;
/*     */   }
/*     */   
/*     */   public void stopFastForwarding() {
/*  79 */     if (this.d) {
/*  80 */       c.i("stopped fast forwarding on frame " + this.updateNumber + " / " + this.e, new Object[0]);
/*     */       
/*  82 */       this.d = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkGameplayUpdateAllowed() {
/*  92 */     if (!this.inUpdateStage) {
/*  93 */       throw new IllegalStateException("Game updates are not allowed now");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canSkipMediaUpdate() {
/*  98 */     return (this.d && this.e - this.updateNumber > 60);
/*     */   }
/*     */   
/*     */   public void pushActionNextUpdate(Action paramAction) {
/* 102 */     pushAction(paramAction, this.updateNumber + 1);
/*     */   }
/*     */   
/*     */   public void pushAction(Action paramAction, int paramInt) {
/* 106 */     if (this.replayMode) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     if (!this.a.containsKey(paramInt)) {
/* 114 */       this.a.put(paramInt, new ActionsArray());
/*     */     }
/* 116 */     ((ActionsArray)this.a.get(paramInt)).add(paramAction);
/*     */     
/*     */     ActionUpdatePair actionUpdatePair;
/* 119 */     (actionUpdatePair = new ActionUpdatePair()).action = paramAction;
/* 120 */     actionUpdatePair.update = paramInt;
/* 121 */     this.b.add(actionUpdatePair);
/*     */     
/* 123 */     this.updateRequired = true;
/*     */ 
/*     */     
/* 126 */     if (this.duplicateActionsTo != null) {
/* 127 */       this.duplicateActionsTo.pushAction(paramAction, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public void requireUpdate() {
/* 132 */     this.updateRequired = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 137 */     this.a.clear();
/* 138 */     this.b.clear();
/* 139 */     this.replayRecord = null;
/* 140 */     this.duplicateActionsTo = null;
/*     */     
/* 142 */     super.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public ActionsArray getCurrentUpdateActions() {
/* 149 */     checkGameplayUpdateAllowed();
/*     */     
/* 151 */     return (ActionsArray)this.a.get(this.updateNumber);
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class ActionUpdatePair
/*     */     implements KryoSerializable {
/*     */     public Action action;
/*     */     public int update;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 161 */       param1Kryo.writeClassAndObject(param1Output, this.action);
/* 162 */       param1Output.writeVarInt(this.update, true);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 167 */       this.action = (Action)param1Kryo.readClassAndObject(param1Input);
/* 168 */       this.update = param1Input.readVarInt(true);
/*     */     } }
/*     */   @REGS
/*     */   public static class ActionsArray implements KryoSerializable { public Action[] actions;
/*     */     
/*     */     public ActionsArray() {
/* 174 */       this.actions = new Action[1];
/*     */     }
/*     */     public int size;
/*     */     public void add(Action param1Action) {
/* 178 */       if (this.size == this.actions.length) {
/* 179 */         a();
/*     */       }
/*     */       
/* 182 */       this.actions[this.size++] = param1Action;
/*     */     }
/*     */     
/*     */     private void a() {
/* 186 */       Action[] arrayOfAction = new Action[this.size + this.size];
/* 187 */       System.arraycopy(this.actions, 0, arrayOfAction, 0, this.size);
/* 188 */       this.actions = arrayOfAction;
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 193 */       param1Kryo.writeObject(param1Output, this.actions);
/* 194 */       param1Output.writeVarInt(this.size, true);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 199 */       this.actions = (Action[])param1Kryo.readObject(param1Input, Action[].class);
/* 200 */       this.size = param1Input.readVarInt(true);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\StateSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */