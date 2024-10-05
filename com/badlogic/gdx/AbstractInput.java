/*    */ package com.badlogic.gdx;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntSet;
/*    */ 
/*    */ public abstract class AbstractInput
/*    */   implements Input {
/*    */   protected final boolean[] pressedKeys;
/*    */   protected final boolean[] justPressedKeys;
/*  9 */   private final IntSet keysToCatch = new IntSet();
/*    */   protected int pressedKeyCount;
/*    */   protected boolean keyJustPressed;
/*    */   
/*    */   public AbstractInput() {
/* 14 */     this.pressedKeys = new boolean[256];
/* 15 */     this.justPressedKeys = new boolean[256];
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isKeyPressed(int paramInt) {
/* 20 */     if (paramInt == -1) {
/* 21 */       return (this.pressedKeyCount > 0);
/*    */     }
/* 23 */     if (paramInt < 0 || paramInt > 255) {
/* 24 */       return false;
/*    */     }
/* 26 */     return this.pressedKeys[paramInt];
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isKeyJustPressed(int paramInt) {
/* 31 */     if (paramInt == -1) {
/* 32 */       return this.keyJustPressed;
/*    */     }
/* 34 */     if (paramInt < 0 || paramInt > 255) {
/* 35 */       return false;
/*    */     }
/* 37 */     return this.justPressedKeys[paramInt];
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCatchBackKey() {
/* 42 */     return this.keysToCatch.contains(4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCatchBackKey(boolean paramBoolean) {
/* 47 */     setCatchKey(4, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCatchMenuKey() {
/* 52 */     return this.keysToCatch.contains(82);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCatchMenuKey(boolean paramBoolean) {
/* 57 */     setCatchKey(82, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCatchKey(int paramInt, boolean paramBoolean) {
/* 62 */     if (!paramBoolean) {
/* 63 */       this.keysToCatch.remove(paramInt); return;
/*    */     } 
/* 65 */     this.keysToCatch.add(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isCatchKey(int paramInt) {
/* 71 */     return this.keysToCatch.contains(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\AbstractInput.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */