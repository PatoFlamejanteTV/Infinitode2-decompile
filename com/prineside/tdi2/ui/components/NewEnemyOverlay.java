/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ 
/*     */ public class NewEnemyOverlay implements Disposable, Listener<EnemySpawn> {
/*  25 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 120, "NewEnemyOverlay");
/*     */   
/*     */   private boolean b;
/*     */   
/*     */   private Image c;
/*     */   
/*     */   private Label d;
/*     */   
/*     */   private Label e;
/*     */   
/*     */   private float f;
/*     */   private final GameSystemProvider g;
/*     */   
/*     */   public NewEnemyOverlay(GameSystemProvider paramGameSystemProvider) {
/*  39 */     this.g = paramGameSystemProvider;
/*     */ 
/*     */     
/*  42 */     this.a.getTable().setBackground(Game.i.assetManager.getOverlayBackground());
/*  43 */     this.a.getTable().setTouchable(Touchable.enabled);
/*  44 */     this.a.getTable().addListener((EventListener)new InputVoid());
/*  45 */     this.a.getTable().addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  48 */             this.a.hide();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  53 */     this.c = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  54 */     this.a.getTable().add((Actor)this.c).size(96.0F).padBottom(32.0F).row();
/*     */ 
/*     */     
/*  57 */     this.d = new Label("", Game.i.assetManager.getLabelStyle(36));
/*  58 */     this.a.getTable().add((Actor)this.d).row();
/*     */ 
/*     */     
/*  61 */     this.e = new Label("", Game.i.assetManager.getLabelStyle(30));
/*  62 */     this.e.setWrap(true);
/*  63 */     this.e.setAlignment(1);
/*  64 */     this.a.getTable().add((Actor)this.e).width(1000.0F).padTop(32.0F).row();
/*     */     
/*     */     Label label;
/*  67 */     (label = new Label(Game.i.localeManager.i18n.get("tap_screen_to_continue"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREY.P500);
/*  68 */     label.addAction((Action)Actions.forever(
/*  69 */           (Action)Actions.sequence(
/*  70 */             (Action)Actions.alpha(1.0F, 0.5F), 
/*  71 */             (Action)Actions.alpha(0.5F, 0.5F))));
/*     */ 
/*     */     
/*  74 */     this.a.getTable().add((Actor)label).padTop(32.0F);
/*     */     
/*  76 */     this.a.getTable().addAction((Action)Actions.alpha(0.0F));
/*  77 */     this.a.getTable().setVisible(false);
/*     */     
/*  79 */     paramGameSystemProvider.events.getListeners(EnemySpawn.class).add(this).setDescription("Shows an overlay if new enemy type has spawned");
/*     */   }
/*     */   
/*     */   public void show(EnemyType paramEnemyType) {
/*  83 */     if (this.b) {
/*  84 */       hide();
/*     */     }
/*     */     
/*     */     String str;
/*  88 */     if ((str = Game.i.enemyManager.getFactory(paramEnemyType).getTitle()).equals("-")) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  93 */     this.b = true;
/*     */     
/*  95 */     this.f = this.g.gameState.getNonAnimatedGameSpeed();
/*  96 */     this.g.gameState.setGameSpeed(0.0F);
/*     */     
/*  98 */     this.c.setDrawable((Drawable)new TextureRegionDrawable(Game.i.enemyManager.getFactory(paramEnemyType).getTexture()));
/*     */     
/* 100 */     this.d.setText(str);
/* 101 */     this.e.setText(Game.i.enemyManager.getFactory(paramEnemyType).getDescription());
/*     */     
/* 103 */     this.a.getTable().setVisible(true);
/* 104 */     this.a.getTable().clearActions();
/* 105 */     this.a.getTable().addAction((Action)Actions.alpha(1.0F, 0.3F));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 110 */     if (!this.b)
/*     */       return; 
/* 112 */     this.g.gameState.setGameSpeed(this.f);
/* 113 */     this.b = false;
/*     */     
/* 115 */     this.a.getTable().clearActions();
/* 116 */     this.a.getTable().addAction((Action)Actions.sequence(
/* 117 */           (Action)Actions.alpha(0.0F, 0.5F), 
/* 118 */           (Action)Actions.hide()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 126 */     Game.i.uiManager.removeLayer(this.a);
/*     */     
/* 128 */     this.g.events.getListeners(EnemySpawn.class).remove(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleEvent(EnemySpawn paramEnemySpawn) {
/* 133 */     if (this.g.gameState.isFastForwarding())
/*     */       return; 
/*     */     Enemy enemy;
/* 136 */     if ((enemy = paramEnemySpawn.getEnemy()).type != EnemyType.GENERIC) {
/* 137 */       if (Game.i.enemyManager.isEnemyTypeNewForPlayer(enemy.type, true)) {
/* 138 */         show(enemy.type);
/*     */       }
/* 140 */       Game.i.enemyManager.markEnemyTypeAsNotNewForPlayer(enemy.type);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\NewEnemyOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */