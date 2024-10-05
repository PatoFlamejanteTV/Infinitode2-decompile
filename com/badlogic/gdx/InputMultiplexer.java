/*     */ package com.badlogic.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
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
/*     */ public class InputMultiplexer
/*     */   implements InputProcessor
/*     */ {
/*  26 */   private SnapshotArray<InputProcessor> processors = new SnapshotArray(4);
/*     */ 
/*     */   
/*     */   public InputMultiplexer() {}
/*     */   
/*     */   public InputMultiplexer(InputProcessor... paramVarArgs) {
/*  32 */     this.processors.addAll((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public void addProcessor(int paramInt, InputProcessor paramInputProcessor) {
/*  36 */     if (paramInputProcessor == null) throw new NullPointerException("processor cannot be null"); 
/*  37 */     this.processors.insert(paramInt, paramInputProcessor);
/*     */   }
/*     */   
/*     */   public void removeProcessor(int paramInt) {
/*  41 */     this.processors.removeIndex(paramInt);
/*     */   }
/*     */   
/*     */   public void addProcessor(InputProcessor paramInputProcessor) {
/*  45 */     if (paramInputProcessor == null) throw new NullPointerException("processor cannot be null"); 
/*  46 */     this.processors.add(paramInputProcessor);
/*     */   }
/*     */   
/*     */   public void removeProcessor(InputProcessor paramInputProcessor) {
/*  50 */     this.processors.removeValue(paramInputProcessor, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  55 */     return this.processors.size;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  59 */     this.processors.clear();
/*     */   }
/*     */   
/*     */   public void setProcessors(InputProcessor... paramVarArgs) {
/*  63 */     this.processors.clear();
/*  64 */     this.processors.addAll((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public void setProcessors(Array<InputProcessor> paramArray) {
/*  68 */     this.processors.clear();
/*  69 */     this.processors.addAll(paramArray);
/*     */   }
/*     */   
/*     */   public SnapshotArray<InputProcessor> getProcessors() {
/*  73 */     return this.processors;
/*     */   }
/*     */   
/*     */   public boolean keyDown(int paramInt) {
/*  77 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/*  79 */       for (b = 0, i = this.processors.size; b < i; b++) {
/*  80 */         if (((InputProcessor)arrayOfObject[b]).keyDown(paramInt)) return true; 
/*     */       }  }
/*  82 */     finally { this.processors.end(); }
/*     */     
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public boolean keyUp(int paramInt) {
/*  88 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/*  90 */       for (b = 0, i = this.processors.size; b < i; b++) {
/*  91 */         if (((InputProcessor)arrayOfObject[b]).keyUp(paramInt)) return true; 
/*     */       }  }
/*  93 */     finally { this.processors.end(); }
/*     */     
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public boolean keyTyped(char paramChar) {
/*  99 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/* 101 */       for (b = 0, i = this.processors.size; b < i; b++) {
/* 102 */         if (((InputProcessor)arrayOfObject[b]).keyTyped(paramChar)) return true; 
/*     */       }  }
/* 104 */     finally { this.processors.end(); }
/*     */     
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 110 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/* 112 */       for (b = 0, i = this.processors.size; b < i; b++) {
/* 113 */         if (((InputProcessor)arrayOfObject[b]).touchDown(paramInt1, paramInt2, paramInt3, paramInt4)) return true; 
/*     */       }  }
/* 115 */     finally { this.processors.end(); }
/*     */     
/* 117 */     return false;
/*     */   }
/*     */   
/*     */   public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 121 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/* 123 */       for (b = 0, i = this.processors.size; b < i; b++) {
/* 124 */         if (((InputProcessor)arrayOfObject[b]).touchUp(paramInt1, paramInt2, paramInt3, paramInt4)) return true; 
/*     */       }  }
/* 126 */     finally { this.processors.end(); }
/*     */     
/* 128 */     return false;
/*     */   }
/*     */   
/*     */   public boolean touchCancelled(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 132 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/* 134 */       for (b = 0, i = this.processors.size; b < i; b++) {
/* 135 */         if (((InputProcessor)arrayOfObject[b]).touchCancelled(paramInt1, paramInt2, paramInt3, paramInt4)) return true; 
/*     */       }  }
/* 137 */     finally { this.processors.end(); }
/*     */     
/* 139 */     return false;
/*     */   }
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/* 143 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/* 145 */       for (b = 0, i = this.processors.size; b < i; b++) {
/* 146 */         if (((InputProcessor)arrayOfObject[b]).touchDragged(paramInt1, paramInt2, paramInt3)) return true; 
/*     */       }  }
/* 148 */     finally { this.processors.end(); }
/*     */     
/* 150 */     return false;
/*     */   }
/*     */   
/*     */   public boolean mouseMoved(int paramInt1, int paramInt2) {
/* 154 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/* 156 */       for (b = 0, i = this.processors.size; b < i; b++) {
/* 157 */         if (((InputProcessor)arrayOfObject[b]).mouseMoved(paramInt1, paramInt2)) return true; 
/*     */       }  }
/* 159 */     finally { this.processors.end(); }
/*     */     
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   public boolean scrolled(float paramFloat1, float paramFloat2) {
/* 165 */     Object[] arrayOfObject = this.processors.begin(); 
/*     */     try { byte b; int i;
/* 167 */       for (b = 0, i = this.processors.size; b < i; b++) {
/* 168 */         if (((InputProcessor)arrayOfObject[b]).scrolled(paramFloat1, paramFloat2)) return true; 
/*     */       }  }
/* 170 */     finally { this.processors.end(); }
/*     */     
/* 172 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\InputMultiplexer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */