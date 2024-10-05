/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.gates.BarrierTypeGate;
/*     */ import com.prineside.tdi2.gates.TeleportGate;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class GateMenu implements Disposable {
/*  26 */   private static final TLog a = TLog.forClass(GateMenu.class);
/*     */ 
/*     */   
/*  29 */   private static final Color b = new Color(623191551);
/*     */   
/*     */   private final SideMenu.SideMenuContainer c;
/*     */   
/*     */   private boolean d;
/*     */   
/*     */   private Table e;
/*     */   
/*     */   private Label f;
/*     */   
/*     */   private Label g;
/*     */   
/*     */   private Group h;
/*     */   
/*     */   private Group i;
/*     */   
/*     */   private Group j;
/*     */   private final GameSystemProvider k;
/*  47 */   private final _SideMenuListener l = new _SideMenuListener((byte)0);
/*     */   
/*  49 */   private static final StringBuilder m = new StringBuilder();
/*     */   
/*     */   public GateMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  52 */     this.k = paramGameSystemProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     this.c = paramSideMenu.createContainer("GateMenu");
/*     */     
/*  59 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */ 
/*     */     
/*  62 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(36));
/*  63 */     this.f.setSize(460.0F, 26.0F);
/*  64 */     this.f.setPosition(40.0F, 994.0F + i);
/*  65 */     this.c.addActor((Actor)this.f);
/*     */ 
/*     */     
/*  68 */     this.g = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  69 */     this.g.setSize(520.0F, 100.0F);
/*  70 */     this.g.setPosition(40.0F, 884.0F + i);
/*  71 */     this.g.setAlignment(10);
/*  72 */     this.g.setWrap(true);
/*  73 */     this.c.addActor((Actor)this.g);
/*     */     
/*  75 */     this.h = new Group();
/*  76 */     this.h.setTransform(false);
/*  77 */     this.h.setSize(600.0F, 940.0F + i);
/*  78 */     this.c.addActor((Actor)this.h);
/*     */     
/*  80 */     this.i = new Group();
/*  81 */     this.i.setTransform(false);
/*  82 */     this.i.setSize(600.0F, 940.0F + i);
/*  83 */     this.c.addActor((Actor)this.i);
/*     */     
/*  85 */     this.j = new Group();
/*  86 */     this.j.setTransform(false);
/*  87 */     this.j.setSize(600.0F, 940.0F + i);
/*  88 */     this.c.addActor((Actor)this.j);
/*     */     
/*     */     Label label;
/*     */     
/*  92 */     (label = new Label(Game.i.localeManager.i18n.get("blocked_enemies").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/*  93 */     label.setPosition(40.0F, 906.0F + i);
/*  94 */     label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  95 */     this.h.addActor((Actor)label);
/*     */     
/*  97 */     this.e = new Table();
/*     */     ScrollPane scrollPane;
/*  99 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.e));
/* 100 */     scrollPane.setSize(600.0F, 890.0F + i);
/* 101 */     this.h.addActor((Actor)scrollPane);
/*     */ 
/*     */     
/* 104 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.l);
/*     */     
/* 106 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Gate gate;
/*     */           
/*     */           if ((gate = paramGameSystemProvider._gameMapSelection.getSelectedGate()) != null) {
/*     */             a();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*     */         });
/* 116 */     this.c.hide();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 120 */     if (this.d != paramBoolean) {
/* 121 */       this.d = paramBoolean;
/* 122 */       if (paramBoolean) {
/* 123 */         this.c.show();
/*     */       } else {
/*     */         
/* 126 */         this.c.hide();
/*     */       } 
/*     */       
/* 129 */       a.i(paramBoolean ? "shown" : "hidden", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a() {
/* 134 */     this.e.clearChildren();
/*     */     
/* 136 */     this.i.setVisible(false);
/* 137 */     this.h.setVisible(false);
/* 138 */     this.j.setVisible(false);
/*     */     
/* 140 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/*     */     Gate gate;
/* 143 */     if ((gate = this.k._gameMapSelection.getSelectedGate()) != null) {
/* 144 */       BarrierTypeGate barrierTypeGate; this.f.setText(Game.i.gateManager.getFactory(gate.getType()).getTitle(gate));
/* 145 */       this.g.setText(Game.i.gateManager.getFactory(gate.getType()).getDescription(gate));
/*     */       
/* 147 */       if (gate.getType() == GateType.BARRIER_TYPE) {
/*     */         
/* 149 */         this.h.setVisible(true);
/* 150 */         barrierTypeGate = (BarrierTypeGate)gate; EnemyType[] arrayOfEnemyType;
/*     */         byte b;
/* 152 */         for (i = (arrayOfEnemyType = EnemyType.values).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 153 */           if (barrierTypeGate.isEnemyBlocked(enemyType))
/*     */           { Group group;
/*     */             
/* 156 */             (group = new Group()).setTransform(false);
/*     */             
/*     */             Image image;
/* 159 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/* 160 */             image.setColor(b);
/* 161 */             group.addActor((Actor)image);
/*     */ 
/*     */             
/* 164 */             (image = new Image(this.k.enemy.getTexture(enemyType))).setPosition(48.0F, 6.0F);
/* 165 */             image.setSize(40.0F, 40.0F);
/* 166 */             group.addActor((Actor)image);
/*     */             
/*     */             Label label;
/* 169 */             (label = new Label(Game.i.enemyManager.getFactory(enemyType).getTitle(), Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 52.0F);
/* 170 */             label.setPosition(100.0F, 0.0F);
/* 171 */             group.addActor((Actor)label);
/*     */             
/* 173 */             this.e.add((Actor)group).size(600.0F, 52.0F).padBottom(4.0F).row(); }  b++; }
/*     */       
/* 175 */       } else if (barrierTypeGate.getType() == GateType.TELEPORT) {
/*     */         
/* 177 */         this.j.setVisible(true);
/* 178 */         this.j.clearChildren();
/*     */         
/* 180 */         TeleportGate teleportGate = (TeleportGate)barrierTypeGate;
/*     */         
/* 182 */         m.setLength(0);
/* 183 */         m.append(TeleportGate.INDEX_NAMES[teleportGate.index]).append(" (").append(teleportGate.index).append(")");
/*     */         
/*     */         Label label;
/* 186 */         (label = new Label((CharSequence)m, Game.i.assetManager.getLabelStyle(24))).setPosition(40.0F, 880.0F + i);
/* 187 */         label.setSize(520.0F, 17.0F);
/* 188 */         label.setWrap(true);
/* 189 */         this.j.addActor((Actor)label);
/*     */       } 
/*     */     } 
/*     */     
/* 193 */     this.e.add().expandX().fillX().height(40.0F).row();
/* 194 */     this.e.add().expand().fill();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */   
/*     */   private class _SideMenuListener
/*     */     extends SideMenu.SideMenuListener.SideMenuListenerAdapter
/*     */   {
/*     */     private _SideMenuListener(GateMenu this$0) {}
/*     */     
/*     */     public void offscreenChanged() {
/* 206 */       GateMenu.a(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\GateMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */