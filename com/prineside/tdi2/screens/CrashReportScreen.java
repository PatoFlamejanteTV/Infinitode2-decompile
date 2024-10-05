/*     */ package com.prineside.tdi2.screens;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.viewport.ScreenViewport;
/*     */ import com.badlogic.gdx.utils.viewport.Viewport;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class CrashReportScreen extends Screen {
/*  23 */   private static final TLog a = TLog.forClass(CrashReportScreen.class);
/*     */   
/*     */   private final BitmapFont b;
/*     */   private final BitmapFont c;
/*     */   private final SpriteBatch d;
/*     */   private final Stage e;
/*     */   private final ScreenViewport f;
/*     */   private final Table g;
/*     */   private final Label.LabelStyle h;
/*     */   private final Label.LabelStyle i;
/*     */   
/*     */   public CrashReportScreen(String paramString1, String paramString2, String paramString3, String paramString4) {
/*  35 */     this.d = new SpriteBatch(8191, RenderingManager.createDefaultSpriteBatchShader());
/*  36 */     this.b = new BitmapFont(Gdx.files.internal("resourcepacks/default/futura.fnt"));
/*  37 */     this.b.getData().setScale((this.b.getData()).scaleX * 0.5F);
/*  38 */     this.b.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*  39 */     this.c = new BitmapFont(Gdx.files.internal("resourcepacks/default/futura.fnt"));
/*  40 */     this.c.getData().setScale((this.c.getData()).scaleX * 0.8F);
/*  41 */     this.c.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*  42 */     this.f = new ScreenViewport();
/*  43 */     this.e = new Stage((Viewport)this.f, (Batch)this.d);
/*     */     
/*  45 */     String str1 = paramString1 + " " + paramString3 + " " + paramString4;
/*  46 */     String str2 = null;
/*  47 */     if (str1.contains("OutOfMemory")) {
/*  48 */       str2 = "Not enough memory (RAM) - try to disable some graphical effects / sell some tiles from your inventory";
/*  49 */     } else if (str1.contains("ENOSPC") || str1.contains("Test")) {
/*  50 */       str2 = "Not enough of free disk space - make sure your disk drive is not completely full and the game is allowed to create new files";
/*     */     } 
/*     */     
/*  53 */     this.g = new Table();
/*  54 */     this.e.addActor((Actor)this.g);
/*     */     
/*  56 */     this.h = new Label.LabelStyle(this.b, Color.WHITE);
/*  57 */     this.i = new Label.LabelStyle(this.c, Color.WHITE);
/*     */     
/*  59 */     a("Crash detected", MaterialColor.AMBER.P500, true, true);
/*     */     
/*  61 */     if (str2 != null) {
/*  62 */       a("Possible reason:", MaterialColor.CYAN.P500);
/*  63 */       a(str2, Color.WHITE, true, true);
/*     */     } 
/*     */     
/*  66 */     a("Error:", MaterialColor.CYAN.P500);
/*  67 */     a(paramString1 + ": " + paramString3, Color.WHITE, true);
/*     */     
/*  69 */     a("Thread name:", MaterialColor.CYAN.P500);
/*  70 */     a(paramString2, Color.WHITE, true);
/*     */     
/*  72 */     a("Stacktrace:", MaterialColor.CYAN.P500);
/*     */     
/*  74 */     StringBuilder stringBuilder = new StringBuilder();
/*  75 */     String[] arrayOfString = paramString4.replaceAll("\t", "    ").split("\n");
/*  76 */     for (byte b = 0; b < arrayOfString.length; b++) {
/*  77 */       stringBuilder.append(arrayOfString[b]).append("\n");
/*  78 */       if (b == 16) {
/*  79 */         stringBuilder.append("...");
/*     */         break;
/*     */       } 
/*     */     } 
/*  83 */     Label label2 = new Label(stringBuilder.toString(), this.h);
/*  84 */     this.g.add((Actor)label2).minWidth(100.0F).padBottom(20.0F).top().left().row();
/*     */     
/*  86 */     this.g.add().height(40.0F).width(1.0F).row();
/*     */     Label label1;
/*  88 */     (label1 = a("Tap the screen or press any key to continue", MaterialColor.LIGHT_GREEN.P500, true, true)).addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.color(MaterialColor.LIGHT_GREEN.P900, 0.5F), (Action)Actions.color(MaterialColor.LIGHT_GREEN.P500, 0.3F))));
/*     */   }
/*     */   
/*     */   private Label a(String paramString, Color paramColor) {
/*  92 */     return a(paramString, paramColor, false, false);
/*     */   }
/*     */   
/*     */   private Label a(String paramString, Color paramColor, boolean paramBoolean) {
/*  96 */     return a(paramString, paramColor, true, false);
/*     */   }
/*     */   
/*     */   private Label a(String paramString, Color paramColor, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     Label label;
/* 101 */     (label = new Label(paramString, paramBoolean2 ? this.i : this.h)).setColor(paramColor);
/* 102 */     label.setWrap(true);
/* 103 */     this.g.add((Actor)label).growX().padBottom(paramBoolean1 ? 20.0F : 0.0F).top().left().row();
/*     */     
/* 105 */     return label;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resize(int paramInt1, int paramInt2) {
/* 110 */     if (paramInt1 > 0 && paramInt2 > 0) {
/*     */ 
/*     */       
/* 113 */       float f1 = 960.0F / paramInt2;
/* 114 */       float f2 = paramInt1 / paramInt2;
/*     */       
/* 116 */       this.f.setUnitsPerPixel(f1);
/* 117 */       this.f.update(paramInt1, paramInt2, true);
/*     */       
/* 119 */       this.g.setSize(960.0F * f2 - 160.0F, 880.0F);
/* 120 */       this.g.setPosition(80.0F, 40.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(float paramFloat) {
/* 126 */     Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
/* 127 */     Gdx.gl.glClear(16640);
/*     */     
/* 129 */     this.e.act(paramFloat);
/* 130 */     this.e.draw();
/*     */     
/* 132 */     if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(-1)) {
/*     */       try {
/* 134 */         Gdx.files.local("cache/crash-report.json").delete();
/* 135 */       } catch (Exception exception) {
/* 136 */         a.e("failed to delete crash report", new Object[0]);
/*     */       } 
/* 138 */       Game.i.screenManager.goToLoadingScreen(Game.i.gameSyncLoader);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 144 */     this.e.dispose();
/* 145 */     this.d.dispose();
/* 146 */     this.b.dispose();
/* 147 */     this.c.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\CrashReportScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */