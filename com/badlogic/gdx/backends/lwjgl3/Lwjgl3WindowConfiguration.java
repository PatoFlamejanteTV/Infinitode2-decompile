/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import java.util.Arrays;
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
/*     */ public class Lwjgl3WindowConfiguration
/*     */ {
/*  28 */   int windowX = -1;
/*  29 */   int windowY = -1;
/*  30 */   int windowWidth = 640;
/*  31 */   int windowHeight = 480;
/*  32 */   int windowMinWidth = -1; int windowMinHeight = -1; int windowMaxWidth = -1; int windowMaxHeight = -1;
/*     */   boolean windowResizable = true;
/*     */   boolean windowDecorated = true;
/*     */   boolean windowMaximized = false;
/*     */   Lwjgl3Graphics.Lwjgl3Monitor maximizedMonitor;
/*     */   boolean autoIconify = true;
/*     */   Files.FileType windowIconFileType;
/*     */   String[] windowIconPaths;
/*     */   Lwjgl3WindowListener windowListener;
/*     */   Lwjgl3Graphics.Lwjgl3DisplayMode fullscreenMode;
/*     */   String title;
/*  43 */   Color initialBackgroundColor = Color.BLACK;
/*     */   boolean initialVisible = true;
/*     */   boolean vSyncEnabled = true;
/*     */   
/*     */   void setWindowConfiguration(Lwjgl3WindowConfiguration paramLwjgl3WindowConfiguration) {
/*  48 */     this.windowX = paramLwjgl3WindowConfiguration.windowX;
/*  49 */     this.windowY = paramLwjgl3WindowConfiguration.windowY;
/*  50 */     this.windowWidth = paramLwjgl3WindowConfiguration.windowWidth;
/*  51 */     this.windowHeight = paramLwjgl3WindowConfiguration.windowHeight;
/*  52 */     this.windowMinWidth = paramLwjgl3WindowConfiguration.windowMinWidth;
/*  53 */     this.windowMinHeight = paramLwjgl3WindowConfiguration.windowMinHeight;
/*  54 */     this.windowMaxWidth = paramLwjgl3WindowConfiguration.windowMaxWidth;
/*  55 */     this.windowMaxHeight = paramLwjgl3WindowConfiguration.windowMaxHeight;
/*  56 */     this.windowResizable = paramLwjgl3WindowConfiguration.windowResizable;
/*  57 */     this.windowDecorated = paramLwjgl3WindowConfiguration.windowDecorated;
/*  58 */     this.windowMaximized = paramLwjgl3WindowConfiguration.windowMaximized;
/*  59 */     this.maximizedMonitor = paramLwjgl3WindowConfiguration.maximizedMonitor;
/*  60 */     this.autoIconify = paramLwjgl3WindowConfiguration.autoIconify;
/*  61 */     this.windowIconFileType = paramLwjgl3WindowConfiguration.windowIconFileType;
/*  62 */     if (paramLwjgl3WindowConfiguration.windowIconPaths != null) this.windowIconPaths = Arrays.<String>copyOf(paramLwjgl3WindowConfiguration.windowIconPaths, paramLwjgl3WindowConfiguration.windowIconPaths.length); 
/*  63 */     this.windowListener = paramLwjgl3WindowConfiguration.windowListener;
/*  64 */     this.fullscreenMode = paramLwjgl3WindowConfiguration.fullscreenMode;
/*  65 */     this.title = paramLwjgl3WindowConfiguration.title;
/*  66 */     this.initialBackgroundColor = paramLwjgl3WindowConfiguration.initialBackgroundColor;
/*  67 */     this.initialVisible = paramLwjgl3WindowConfiguration.initialVisible;
/*  68 */     this.vSyncEnabled = paramLwjgl3WindowConfiguration.vSyncEnabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInitialVisible(boolean paramBoolean) {
/*  73 */     this.initialVisible = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWindowedMode(int paramInt1, int paramInt2) {
/*  81 */     this.windowWidth = paramInt1;
/*  82 */     this.windowHeight = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setResizable(boolean paramBoolean) {
/*  87 */     this.windowResizable = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDecorated(boolean paramBoolean) {
/*  92 */     this.windowDecorated = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaximized(boolean paramBoolean) {
/*  97 */     this.windowMaximized = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaximizedMonitor(Graphics.Monitor paramMonitor) {
/* 102 */     this.maximizedMonitor = (Lwjgl3Graphics.Lwjgl3Monitor)paramMonitor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoIconify(boolean paramBoolean) {
/* 108 */     this.autoIconify = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWindowPosition(int paramInt1, int paramInt2) {
/* 113 */     this.windowX = paramInt1;
/* 114 */     this.windowY = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWindowSizeLimits(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 120 */     this.windowMinWidth = paramInt1;
/* 121 */     this.windowMinHeight = paramInt2;
/* 122 */     this.windowMaxWidth = paramInt3;
/* 123 */     this.windowMaxHeight = paramInt4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWindowIcon(String... paramVarArgs) {
/* 130 */     setWindowIcon(Files.FileType.Internal, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWindowIcon(Files.FileType paramFileType, String... paramVarArgs) {
/* 138 */     this.windowIconFileType = paramFileType;
/* 139 */     this.windowIconPaths = paramVarArgs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWindowListener(Lwjgl3WindowListener paramLwjgl3WindowListener) {
/* 144 */     this.windowListener = paramLwjgl3WindowListener;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFullscreenMode(Graphics.DisplayMode paramDisplayMode) {
/* 150 */     this.fullscreenMode = (Lwjgl3Graphics.Lwjgl3DisplayMode)paramDisplayMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTitle(String paramString) {
/* 155 */     this.title = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInitialBackgroundColor(Color paramColor) {
/* 160 */     this.initialBackgroundColor = paramColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void useVsync(boolean paramBoolean) {
/* 168 */     this.vSyncEnabled = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3WindowConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */