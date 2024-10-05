/*     */ package com.badlogic.gdx;public interface Graphics { boolean isGL30Available(); boolean isGL31Available(); boolean isGL32Available();
/*     */   GL20 getGL20();
/*     */   GL30 getGL30();
/*     */   GL31 getGL31();
/*     */   GL32 getGL32();
/*     */   void setGL20(GL20 paramGL20);
/*     */   void setGL30(GL30 paramGL30);
/*     */   void setGL31(GL31 paramGL31);
/*     */   void setGL32(GL32 paramGL32);
/*     */   int getWidth();
/*     */   int getHeight();
/*     */   int getBackBufferWidth();
/*     */   int getBackBufferHeight();
/*     */   float getBackBufferScale();
/*     */   int getSafeInsetLeft();
/*     */   int getSafeInsetTop();
/*     */   int getSafeInsetBottom();
/*     */   int getSafeInsetRight();
/*     */   long getFrameId();
/*     */   float getDeltaTime();
/*     */   @Deprecated
/*     */   float getRawDeltaTime();
/*     */   int getFramesPerSecond();
/*     */   GraphicsType getType();
/*     */   GLVersion getGLVersion();
/*     */   float getPpiX();
/*     */   float getPpiY();
/*     */   float getPpcX();
/*     */   float getPpcY();
/*     */   float getDensity();
/*     */   boolean supportsDisplayModeChange();
/*     */   Monitor getPrimaryMonitor();
/*     */   Monitor getMonitor();
/*     */   Monitor[] getMonitors();
/*     */   DisplayMode[] getDisplayModes();
/*     */   DisplayMode[] getDisplayModes(Monitor paramMonitor);
/*     */   DisplayMode getDisplayMode();
/*     */   DisplayMode getDisplayMode(Monitor paramMonitor);
/*     */   boolean setFullscreenMode(DisplayMode paramDisplayMode);
/*     */   boolean setWindowedMode(int paramInt1, int paramInt2);
/*     */   void setTitle(String paramString);
/*     */   void setUndecorated(boolean paramBoolean);
/*     */   void setResizable(boolean paramBoolean);
/*     */   void setVSync(boolean paramBoolean);
/*     */   void setForegroundFPS(int paramInt);
/*     */   BufferFormat getBufferFormat();
/*     */   boolean supportsExtension(String paramString);
/*     */   void setContinuousRendering(boolean paramBoolean);
/*     */   boolean isContinuousRendering();
/*     */   void requestRendering();
/*     */   boolean isFullscreen();
/*     */   Cursor newCursor(Pixmap paramPixmap, int paramInt1, int paramInt2);
/*     */   void setCursor(Cursor paramCursor);
/*     */   void setSystemCursor(Cursor.SystemCursor paramSystemCursor);
/*  55 */   public enum GraphicsType { AndroidGL, LWJGL, WebGL, iOSGL, JGLFW, Mock, LWJGL3; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DisplayMode
/*     */   {
/*     */     public final int width;
/*     */     
/*     */     public final int height;
/*     */     
/*     */     public final int refreshRate;
/*     */     
/*     */     public final int bitsPerPixel;
/*     */ 
/*     */     
/*     */     protected DisplayMode(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  72 */       this.width = param1Int1;
/*  73 */       this.height = param1Int2;
/*  74 */       this.refreshRate = param1Int3;
/*  75 */       this.bitsPerPixel = param1Int4;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  79 */       return this.width + "x" + this.height + ", bpp: " + this.bitsPerPixel + ", hz: " + this.refreshRate;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Monitor
/*     */   {
/*     */     public final int virtualX;
/*     */     
/*     */     public final int virtualY;
/*     */     public final String name;
/*     */     
/*     */     protected Monitor(int param1Int1, int param1Int2, String param1String) {
/*  92 */       this.virtualX = param1Int1;
/*  93 */       this.virtualY = param1Int2;
/*  94 */       this.name = param1String;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BufferFormat
/*     */   {
/*     */     public final int r;
/*     */     public final int g;
/*     */     public final int b;
/*     */     public final int a;
/*     */     public final int depth;
/*     */     public final int stencil;
/*     */     public final int samples;
/*     */     public final boolean coverageSampling;
/*     */     
/*     */     public BufferFormat(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, boolean param1Boolean) {
/* 110 */       this.r = param1Int1;
/* 111 */       this.g = param1Int2;
/* 112 */       this.b = param1Int3;
/* 113 */       this.a = param1Int4;
/* 114 */       this.depth = param1Int5;
/* 115 */       this.stencil = param1Int6;
/* 116 */       this.samples = param1Int7;
/* 117 */       this.coverageSampling = param1Boolean;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 121 */       return "r: " + this.r + ", g: " + this.g + ", b: " + this.b + ", a: " + this.a + ", depth: " + this.depth + ", stencil: " + this.stencil + ", num samples: " + this.samples + ", coverage sampling: " + this.coverageSampling;
/*     */     }
/*     */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Graphics.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */