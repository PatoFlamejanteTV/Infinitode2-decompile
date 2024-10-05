/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class InputMultiplexerExtended
/*     */   implements InputProcessor {
/*  12 */   private static final TLog a = TLog.forClass(InputMultiplexerExtended.class);
/*     */   
/*  14 */   private final SnapshotArray<InputProcessor> b = new SnapshotArray(4);
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   public InputMultiplexerExtended() {}
/*     */   
/*     */   public InputMultiplexerExtended(InputProcessor... paramVarArgs) {
/*  21 */     this.b.addAll((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public void setLogging(boolean paramBoolean) {
/*  25 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isLogging() {
/*  29 */     return this.c;
/*     */   }
/*     */   
/*     */   public void addProcessorAtIndex(int paramInt, InputProcessor paramInputProcessor) {
/*  33 */     if (this.c) a.i("addProcessor " + paramInt + " " + paramInputProcessor, new Object[0]); 
/*  34 */     Preconditions.checkNotNull(paramInputProcessor, "InputProcessor can not be null");
/*  35 */     this.b.insert(paramInt, paramInputProcessor);
/*     */   }
/*     */   
/*     */   public void removeProcessorAtIndex(int paramInt) {
/*  39 */     if (this.c) a.i("removeProcessor " + paramInt, new Object[0]); 
/*  40 */     this.b.removeIndex(paramInt);
/*     */   }
/*     */   
/*     */   public void addProcessor(InputProcessor paramInputProcessor) {
/*  44 */     if (this.c) a.i("addProcessor " + paramInputProcessor, new Object[0]); 
/*  45 */     Preconditions.checkNotNull(paramInputProcessor, "InputProcessor can not be null");
/*  46 */     this.b.add(paramInputProcessor);
/*     */   }
/*     */   
/*     */   public void removeProcessor(InputProcessor paramInputProcessor) {
/*  50 */     if (this.c) a.i("removeProcessor " + paramInputProcessor, new Object[0]); 
/*  51 */     this.b.removeValue(paramInputProcessor, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  56 */     return this.b.size;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  60 */     this.b.clear();
/*     */   }
/*     */   
/*     */   public void setProcessors(InputProcessor... paramVarArgs) {
/*  64 */     if (this.c) a.i("setProcessors " + Arrays.toString((Object[])paramVarArgs), new Object[0]); 
/*  65 */     this.b.clear();
/*  66 */     this.b.addAll((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public void setProcessorsArray(Array<InputProcessor> paramArray) {
/*  70 */     if (this.c) a.i("setProcessors " + paramArray.toString(), new Object[0]); 
/*  71 */     this.b.clear();
/*  72 */     this.b.addAll(paramArray);
/*     */   }
/*     */   
/*     */   public SnapshotArray<InputProcessor> getProcessors() {
/*  76 */     return this.b;
/*     */   }
/*     */   
/*     */   public boolean keyDown(int paramInt) {
/*  80 */     if (this.c) a.i("keyDown " + paramInt + " (" + this.b.size + " processors)", new Object[0]); 
/*  81 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/*  83 */       for (b = 0, i = this.b.size; b < i; b++) {
/*  84 */         if (this.c) a.i("- (keyDown) " + b + ": " + arrayOfObject[b], new Object[0]); 
/*  85 */         if (((InputProcessor)arrayOfObject[b]).keyDown(paramInt)) {
/*  86 */           if (this.c) a.i("- (keyDown) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/*  87 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/*  91 */       this.b.end();
/*     */     } 
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public boolean keyUp(int paramInt) {
/*  97 */     if (this.c) a.i("keyUp " + paramInt + " (" + this.b.size + " processors)", new Object[0]); 
/*  98 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 100 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 101 */         if (this.c) a.i("- (keyUp) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 102 */         if (((InputProcessor)arrayOfObject[b]).keyUp(paramInt)) {
/* 103 */           if (this.c) a.i("- (keyUp) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 104 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 108 */       this.b.end();
/*     */     } 
/* 110 */     return false;
/*     */   }
/*     */   
/*     */   public boolean keyTyped(char paramChar) {
/* 114 */     if (this.c) a.i("keyTyped " + paramChar + " (" + this.b.size + " processors)", new Object[0]); 
/* 115 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 117 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 118 */         if (this.c) a.i("- (keyTyped) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 119 */         if (((InputProcessor)arrayOfObject[b]).keyTyped(paramChar)) {
/* 120 */           if (this.c) a.i("- (keyTyped) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 121 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 125 */       this.b.end();
/*     */     } 
/* 127 */     return false;
/*     */   }
/*     */   
/*     */   public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 131 */     if (this.c) a.i("touchDown " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + " (" + this.b.size + " processors)", new Object[0]); 
/* 132 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 134 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 135 */         if (this.c) a.i("- (touchDown) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 136 */         if (((InputProcessor)arrayOfObject[b]).touchDown(paramInt1, paramInt2, paramInt3, paramInt4)) {
/* 137 */           if (this.c) a.i("- (touchDown) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 138 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 142 */       this.b.end();
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */   
/*     */   public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 148 */     if (this.c) a.i("touchUp " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + " (" + this.b.size + " processors)", new Object[0]); 
/* 149 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 151 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 152 */         if (this.c) a.i("- (touchUp) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 153 */         if (((InputProcessor)arrayOfObject[b]).touchUp(paramInt1, paramInt2, paramInt3, paramInt4)) {
/* 154 */           if (this.c) a.i("- (touchUp) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 155 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 159 */       this.b.end();
/*     */     } 
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchCancelled(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 166 */     if (this.c) a.i("touchCancelled " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + " (" + this.b.size + " processors)", new Object[0]); 
/* 167 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 169 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 170 */         if (this.c) a.i("- (touchCancelled) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 171 */         if (((InputProcessor)arrayOfObject[b]).touchCancelled(paramInt1, paramInt2, paramInt3, paramInt4)) {
/* 172 */           if (this.c) a.i("- (touchCancelled) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 173 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 177 */       this.b.end();
/*     */     } 
/* 179 */     return false;
/*     */   }
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/* 183 */     if (this.c) a.i("touchDragged " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + " (" + this.b.size + " processors)", new Object[0]); 
/* 184 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 186 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 187 */         if (this.c) a.i("- (touchDragged) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 188 */         if (((InputProcessor)arrayOfObject[b]).touchDragged(paramInt1, paramInt2, paramInt3)) {
/* 189 */           if (this.c) a.i("- (touchDragged) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 190 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 194 */       this.b.end();
/*     */     } 
/* 196 */     return false;
/*     */   }
/*     */   
/*     */   public boolean mouseMoved(int paramInt1, int paramInt2) {
/* 200 */     if (this.c) a.i("mouseMoved " + paramInt1 + ", " + paramInt2 + " (" + this.b.size + " processors)", new Object[0]); 
/* 201 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 203 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 204 */         if (this.c) a.i("- (mouseMoved) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 205 */         if (((InputProcessor)arrayOfObject[b]).mouseMoved(paramInt1, paramInt2)) {
/* 206 */           if (this.c) a.i("- (mouseMoved) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 207 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 211 */       this.b.end();
/*     */     } 
/* 213 */     return false;
/*     */   }
/*     */   
/*     */   public boolean scrolled(float paramFloat1, float paramFloat2) {
/* 217 */     if (this.c) a.i("scrolled " + paramFloat1 + ", " + paramFloat2 + " (" + this.b.size + " processors)", new Object[0]); 
/* 218 */     Object[] arrayOfObject = this.b.begin(); try {
/*     */       byte b; int i;
/* 220 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 221 */         if (this.c) a.i("- (scrolled) " + b + ": " + arrayOfObject[b], new Object[0]); 
/* 222 */         if (((InputProcessor)arrayOfObject[b]).scrolled(paramFloat1, paramFloat2)) {
/* 223 */           if (this.c) a.i("- (scrolled) " + arrayOfObject[b] + " cancels event", new Object[0]); 
/* 224 */           return true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 228 */       this.b.end();
/*     */     } 
/* 230 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\InputMultiplexerExtended.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */