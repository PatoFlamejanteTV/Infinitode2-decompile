/*     */ package com.badlogic.gdx.backends.headless.mock.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.AbstractGraphics;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.graphics.Cursor;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.GL30;
/*     */ import com.badlogic.gdx.graphics.GL31;
/*     */ import com.badlogic.gdx.graphics.GL32;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.glutils.GLVersion;
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
/*     */ public class MockGraphics
/*     */   extends AbstractGraphics
/*     */ {
/*  33 */   long frameId = -1L;
/*  34 */   float deltaTime = 0.0F;
/*  35 */   long frameStart = 0L;
/*  36 */   int frames = 0;
/*     */   int fps;
/*  38 */   long lastTime = System.nanoTime();
/*     */   long targetRenderInterval;
/*  40 */   GLVersion glVersion = new GLVersion(Application.ApplicationType.HeadlessDesktop, "", "", "");
/*     */ 
/*     */   
/*     */   public boolean isGL30Available() {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGL31Available() {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGL32Available() {
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public GL20 getGL20() {
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGL20(GL20 paramGL20) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public GL30 getGL30() {
/*  69 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGL30(GL30 paramGL30) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public GL31 getGL31() {
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGL31(GL31 paramGL31) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public GL32 getGL32() {
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGL32(GL32 paramGL32) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  99 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 104 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBackBufferWidth() {
/* 109 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBackBufferHeight() {
/* 114 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFrameId() {
/* 119 */     return this.frameId;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDeltaTime() {
/* 124 */     return this.deltaTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFramesPerSecond() {
/* 129 */     return this.fps;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.GraphicsType getType() {
/* 134 */     return Graphics.GraphicsType.Mock;
/*     */   }
/*     */ 
/*     */   
/*     */   public GLVersion getGLVersion() {
/* 139 */     return this.glVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpiX() {
/* 144 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpiY() {
/* 149 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpcX() {
/* 154 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpcY() {
/* 159 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean supportsDisplayModeChange() {
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode[] getDisplayModes() {
/* 169 */     return new Graphics.DisplayMode[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode getDisplayMode() {
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetLeft() {
/* 179 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetTop() {
/* 184 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetBottom() {
/* 189 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetRight() {
/* 194 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setFullscreenMode(Graphics.DisplayMode paramDisplayMode) {
/* 199 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setWindowedMode(int paramInt1, int paramInt2) {
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitle(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVSync(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForegroundFPS(int paramInt) {
/* 223 */     this.targetRenderInterval = (long)((paramInt <= 0) ? ((paramInt == 0) ? false : -1) : (1.0F / paramInt * 1.0E9F));
/*     */   }
/*     */   
/*     */   public long getTargetRenderInterval() {
/* 227 */     return this.targetRenderInterval;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.BufferFormat getBufferFormat() {
/* 232 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean supportsExtension(String paramString) {
/* 237 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContinuousRendering(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isContinuousRendering() {
/* 247 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void requestRendering() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullscreen() {
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   public void updateTime() {
/* 261 */     long l = System.nanoTime();
/* 262 */     this.deltaTime = (float)(l - this.lastTime) / 1.0E9F;
/* 263 */     this.lastTime = l;
/*     */     
/* 265 */     if (l - this.frameStart >= 1000000000L) {
/* 266 */       this.fps = this.frames;
/* 267 */       this.frames = 0;
/* 268 */       this.frameStart = l;
/*     */     } 
/* 270 */     this.frames++;
/*     */   }
/*     */   
/*     */   public void incrementFrameId() {
/* 274 */     this.frameId++;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor newCursor(Pixmap paramPixmap, int paramInt1, int paramInt2) {
/* 279 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursor(Cursor paramCursor) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSystemCursor(Cursor.SystemCursor paramSystemCursor) {}
/*     */ 
/*     */   
/*     */   public Graphics.Monitor getPrimaryMonitor() {
/* 292 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.Monitor getMonitor() {
/* 297 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.Monitor[] getMonitors() {
/* 302 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode[] getDisplayModes(Graphics.Monitor paramMonitor) {
/* 307 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode getDisplayMode(Graphics.Monitor paramMonitor) {
/* 312 */     return null;
/*     */   }
/*     */   
/*     */   public void setUndecorated(boolean paramBoolean) {}
/*     */   
/*     */   public void setResizable(boolean paramBoolean) {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\mock\graphics\MockGraphics.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */