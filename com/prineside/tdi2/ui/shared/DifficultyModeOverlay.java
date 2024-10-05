/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public class DifficultyModeOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static DifficultyModeOverlay i() {
/*  23 */     return (DifficultyModeOverlay)Game.i.uiManager.getComponent(DifficultyModeOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  28 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 111, "DifficultyModeOverlay main");
/*     */ 
/*     */ 
/*     */   
/*     */   private Group b;
/*     */ 
/*     */ 
/*     */   
/*     */   public DifficultyModeOverlay() {
/*     */     Group group;
/*  38 */     (group = new Group()).setTransform(false);
/*  39 */     group.setOrigin(602.0F, 300.0F);
/*  40 */     this.a.getTable().add((Actor)group).size(1204.0F, 600.0F);
/*     */     
/*  42 */     this.b = new Group();
/*  43 */     this.b.setTransform(true);
/*  44 */     this.b.setOrigin(602.0F, 300.0F);
/*  45 */     this.b.setSize(1204.0F, 600.0F);
/*  46 */     group.addActor((Actor)this.b);
/*     */     
/*  48 */     a();
/*     */     
/*  50 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   private void a() {
/*  54 */     this.b.clearChildren();
/*     */ 
/*     */     
/*     */     Group group1;
/*     */     
/*  59 */     (group1 = new Group()).setTransform(false);
/*  60 */     group1.setTouchable(Touchable.enabled);
/*  61 */     group1.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  64 */             Game.i.progressManager.setDifficultyMode(DifficultyMode.EASY);
/*  65 */             this.a.setVisible(false);
/*  66 */             Game.i.screenManager.goToMainMenu();
/*     */           }
/*     */         });
/*  69 */     group1.setSize(372.0F, 600.0F);
/*  70 */     this.b.addActor((Actor)group1);
/*     */     
/*  72 */     if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.EASY) {
/*  73 */       QuadActor quadActor = new QuadActor(new Color(-1950135553), new float[] { 0.0F, -10.0F, -10.0F, 610.0F, 382.0F, 610.0F, 372.0F, -10.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  79 */       group1.addActor((Actor)quadActor);
/*     */       
/*  81 */       quadActor = new QuadActor(Config.BACKGROUND_COLOR, new float[] { 5.0F, -5.0F, -5.0F, 605.0F, 377.0F, 605.0F, 367.0F, -5.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  87 */       group1.addActor((Actor)quadActor);
/*     */     } 
/*     */     
/*  90 */     QuadActor quadActor3 = new QuadActor(new Color(779956957), new float[] { 10.0F, 0.0F, 0.0F, 600.0F, 372.0F, 600.0F, 362.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     group1.addActor((Actor)quadActor3);
/*     */     
/*     */     Label label3;
/*  99 */     (label3 = new Label(Game.i.localeManager.i18n.get("difficulty_mode_EASY").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setPosition(0.0F, 500.0F);
/* 100 */     label3.setSize(372.0F, 96.0F);
/* 101 */     label3.setAlignment(1);
/* 102 */     label3.setColor(MaterialColor.LIGHT_GREEN.P200);
/* 103 */     group1.addActor((Actor)label3);
/*     */ 
/*     */     
/* 106 */     (label3 = new Label(Game.i.localeManager.i18n.get("dm_no_leaderboards"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 107 */     label3.setWrap(true);
/* 108 */     label3.setPosition(30.0F, 400.0F);
/* 109 */     label3.setSize(312.0F, 96.0F);
/* 110 */     group1.addActor((Actor)label3);
/*     */ 
/*     */     
/* 113 */     (label3 = new Label(Game.i.localeManager.i18n.get("dm_waves_on_demand"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 114 */     label3.setWrap(true);
/* 115 */     label3.setPosition(30.0F, 300.0F);
/* 116 */     label3.setSize(312.0F, 96.0F);
/* 117 */     group1.addActor((Actor)label3);
/*     */ 
/*     */     
/* 120 */     (label3 = new Label(Game.i.localeManager.i18n.get("dm_regular_research"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 121 */     label3.setWrap(true);
/* 122 */     label3.setPosition(30.0F, 200.0F);
/* 123 */     label3.setSize(312.0F, 96.0F);
/* 124 */     group1.addActor((Actor)label3);
/*     */ 
/*     */     
/* 127 */     (label3 = new Label(Game.i.localeManager.i18n.get("dm_easy_enemies_prizes"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 128 */     label3.setWrap(true);
/* 129 */     label3.setPosition(30.0F, 100.0F);
/* 130 */     label3.setSize(312.0F, 96.0F);
/* 131 */     group1.addActor((Actor)label3);
/*     */ 
/*     */     
/* 134 */     (label3 = new Label(Game.i.localeManager.i18n.get("dm_no_special_loot"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 135 */     label3.setWrap(true);
/* 136 */     label3.setPosition(30.0F, 0.0F);
/* 137 */     label3.setSize(312.0F, 96.0F);
/* 138 */     label3.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 139 */     group1.addActor((Actor)label3);
/*     */ 
/*     */ 
/*     */     
/* 143 */     (group1 = new Group()).setTransform(false);
/* 144 */     group1.setTouchable(Touchable.enabled);
/* 145 */     group1.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 148 */             Game.i.progressManager.setDifficultyMode(DifficultyMode.NORMAL);
/* 149 */             this.a.setVisible(false);
/* 150 */             Game.i.screenManager.goToMainMenu();
/*     */           }
/*     */         });
/* 153 */     group1.setSize(372.0F, 600.0F);
/* 154 */     group1.setPosition(416.0F, 0.0F);
/* 155 */     this.b.addActor((Actor)group1);
/*     */     
/* 157 */     if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL) {
/* 158 */       QuadActor quadActor5 = new QuadActor(new Color(61469951), new float[] { -10.0F, -10.0F, 0.0F, 610.0F, 372.0F, 610.0F, 382.0F, -10.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       group1.addActor((Actor)quadActor5);
/*     */       
/* 166 */       QuadActor quadActor4 = new QuadActor(Config.BACKGROUND_COLOR, new float[] { -5.0F, -5.0F, 5.0F, 605.0F, 367.0F, 605.0F, 377.0F, -5.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       group1.addActor((Actor)quadActor4);
/*     */     } 
/*     */     
/* 175 */     QuadActor quadActor2 = new QuadActor(new Color(41401821), new float[] { 0.0F, 0.0F, 10.0F, 600.0F, 362.0F, 600.0F, 372.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     group1.addActor((Actor)quadActor2);
/*     */     
/*     */     Label label2;
/* 184 */     (label2 = new Label(Game.i.localeManager.i18n.get("difficulty_mode_NORMAL").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setPosition(0.0F, 500.0F);
/* 185 */     label2.setSize(372.0F, 96.0F);
/* 186 */     label2.setAlignment(1);
/* 187 */     label2.setColor(MaterialColor.LIGHT_BLUE.P200);
/* 188 */     group1.addActor((Actor)label2);
/*     */ 
/*     */     
/* 191 */     (label2 = new Label(Game.i.localeManager.i18n.get("dm_regular_leaderboards"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 192 */     label2.setWrap(true);
/* 193 */     label2.setPosition(30.0F, 400.0F);
/* 194 */     label2.setSize(312.0F, 96.0F);
/* 195 */     group1.addActor((Actor)label2);
/*     */ 
/*     */     
/* 198 */     (label2 = new Label(Game.i.localeManager.i18n.get("dm_waves_by_timer"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 199 */     label2.setWrap(true);
/* 200 */     label2.setPosition(30.0F, 300.0F);
/* 201 */     label2.setSize(312.0F, 96.0F);
/* 202 */     group1.addActor((Actor)label2);
/*     */ 
/*     */     
/* 205 */     (label2 = new Label(Game.i.localeManager.i18n.get("dm_regular_research"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 206 */     label2.setWrap(true);
/* 207 */     label2.setPosition(30.0F, 200.0F);
/* 208 */     label2.setSize(312.0F, 96.0F);
/* 209 */     group1.addActor((Actor)label2);
/*     */ 
/*     */     
/* 212 */     (label2 = new Label(Game.i.localeManager.i18n.get("dm_normal_enemies_prizes"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 213 */     label2.setWrap(true);
/* 214 */     label2.setPosition(30.0F, 100.0F);
/* 215 */     label2.setSize(312.0F, 96.0F);
/* 216 */     group1.addActor((Actor)label2);
/*     */ 
/*     */     
/* 219 */     (label2 = new Label(Game.i.localeManager.i18n.get("dm_no_special_loot"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 220 */     label2.setWrap(true);
/* 221 */     label2.setPosition(30.0F, 0.0F);
/* 222 */     label2.setSize(312.0F, 96.0F);
/* 223 */     group1.addActor((Actor)label2);
/*     */     
/*     */     Group group2;
/*     */     
/* 227 */     (group2 = new Group()).setTransform(false);
/* 228 */     group2.setTouchable(Touchable.enabled);
/* 229 */     group2.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 232 */             if (Game.i.progressManager.difficultyModeAvailable(DifficultyMode.ENDLESS_I)) {
/* 233 */               Game.i.progressManager.setDifficultyMode(DifficultyMode.ENDLESS_I);
/* 234 */               this.a.setVisible(false);
/* 235 */               Game.i.screenManager.goToMainMenu();
/*     */             } 
/*     */           }
/*     */         });
/* 239 */     group2.setSize(372.0F, 600.0F);
/* 240 */     group2.setPosition(832.0F, 0.0F);
/* 241 */     this.b.addActor((Actor)group2);
/*     */     
/* 243 */     if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.ENDLESS_I) {
/* 244 */       QuadActor quadActor5 = new QuadActor(new Color(-4126721), new float[] { 0.0F, -10.0F, -10.0F, 610.0F, 382.0F, 610.0F, 372.0F, -10.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 250 */       group2.addActor((Actor)quadActor5);
/*     */       
/* 252 */       QuadActor quadActor4 = new QuadActor(Config.BACKGROUND_COLOR, new float[] { 5.0F, -5.0F, -5.0F, 605.0F, 377.0F, 605.0F, 367.0F, -5.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 258 */       group2.addActor((Actor)quadActor4);
/*     */     } 
/*     */     
/* 261 */     QuadActor quadActor1 = new QuadActor(new Color(-176220195), new float[] { 10.0F, 0.0F, 0.0F, 600.0F, 372.0F, 600.0F, 362.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     group2.addActor((Actor)quadActor1);
/*     */     
/*     */     Label label1;
/* 270 */     (label1 = new Label(Game.i.localeManager.i18n.get("difficulty_mode_ENDLESS_I").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setPosition(0.0F, 500.0F);
/* 271 */     label1.setSize(372.0F, 96.0F);
/* 272 */     label1.setAlignment(1);
/* 273 */     label1.setColor(MaterialColor.AMBER.P200);
/* 274 */     group2.addActor((Actor)label1);
/*     */ 
/*     */     
/* 277 */     (label1 = new Label(Game.i.localeManager.i18n.get("dm_endless_leaderboards_limited"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 278 */     label1.setWrap(true);
/* 279 */     label1.setPosition(30.0F, 400.0F);
/* 280 */     label1.setSize(312.0F, 96.0F);
/* 281 */     group2.addActor((Actor)label1);
/*     */ 
/*     */     
/* 284 */     (label1 = new Label(Game.i.localeManager.i18n.get("dm_waves_by_timer"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 285 */     label1.setWrap(true);
/* 286 */     label1.setPosition(30.0F, 300.0F);
/* 287 */     label1.setSize(312.0F, 96.0F);
/* 288 */     group2.addActor((Actor)label1);
/*     */ 
/*     */     
/* 291 */     (label1 = new Label(Game.i.localeManager.i18n.get("dm_endless_researches"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 292 */     label1.setWrap(true);
/* 293 */     label1.setPosition(30.0F, 200.0F);
/* 294 */     label1.setSize(312.0F, 96.0F);
/* 295 */     group2.addActor((Actor)label1);
/*     */ 
/*     */     
/* 298 */     (label1 = new Label(Game.i.localeManager.i18n.get("dm_endless_i_enemies_prizes"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 299 */     label1.setWrap(true);
/* 300 */     label1.setPosition(30.0F, 100.0F);
/* 301 */     label1.setSize(312.0F, 96.0F);
/* 302 */     group2.addActor((Actor)label1);
/*     */ 
/*     */     
/* 305 */     (label1 = new Label(Game.i.localeManager.i18n.get("dm_drop_special_loot"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 306 */     label1.setWrap(true);
/* 307 */     label1.setPosition(30.0F, 0.0F);
/* 308 */     label1.setSize(312.0F, 96.0F);
/* 309 */     group2.addActor((Actor)label1);
/*     */     
/* 311 */     if (!Game.i.progressManager.difficultyModeAvailable(DifficultyMode.ENDLESS_I)) {
/* 312 */       QuadActor quadActor = new QuadActor(new Color(170), new float[] { 10.0F, 0.0F, 0.0F, 600.0F, 372.0F, 600.0F, 362.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 318 */       group2.addActor((Actor)quadActor);
/*     */       
/*     */       Table table;
/* 321 */       (table = new Table()).setSize(372.0F, 600.0F);
/* 322 */       group2.addActor((Actor)table);
/*     */       
/* 324 */       Image image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-lock"));
/* 325 */       table.add((Actor)image).size(64.0F).padBottom(16.0F).row();
/*     */       
/* 327 */       Label label = new Label(Game.i.localeManager.i18n.get("complete_story_line_to_unlock"), Game.i.assetManager.getLabelStyle(30));
/* 328 */       table.add((Actor)label).width(312.0F);
/* 329 */       label.setWrap(true);
/* 330 */       label.setAlignment(1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 335 */     if (paramBoolean) {
/* 336 */       a();
/*     */       
/* 338 */       UiUtils.bouncyShowOverlay(null, (Actor)this.a.getTable(), this.b);
/* 339 */       DarkOverlay.i().addCaller("DifficultyModeOverlay", UiManager.MainUiLayer.SHARED_COMPONENTS, this.a.zIndex - 1, () -> {
/*     */             setVisible(false);
/*     */             
/*     */             return true;
/*     */           });
/* 344 */       TooltipsOverlay.i().hideEntry("MainMenu.endlessModeHint");
/* 345 */       TooltipsOverlay.i().markTagShown("MainMenu.endlessModeHint"); return;
/*     */     } 
/* 347 */     UiUtils.bouncyHideOverlay(null, (Actor)this.a.getTable(), this.b);
/* 348 */     DarkOverlay.i().removeCaller("DifficultyModeOverlay");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 356 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\DifficultyModeOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */