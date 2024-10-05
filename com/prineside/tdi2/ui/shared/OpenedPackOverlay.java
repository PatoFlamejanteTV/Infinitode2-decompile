/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public final class OpenedPackOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static OpenedPackOverlay i() {
/*  25 */     return (OpenedPackOverlay)Game.i.uiManager.getComponent(OpenedPackOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  30 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 194, "OpenedPackOverlay main");
/*     */   
/*     */   private final Group b;
/*     */   
/*     */   private final Group c;
/*     */   
/*     */   private final Table d;
/*     */   
/*     */   private final ScrollPane e;
/*     */   
/*     */   private long f;
/*     */   
/*     */   public OpenedPackOverlay() {
/*  43 */     float f = Game.i.settingsManager.getScaledViewportHeight();
/*     */ 
/*     */     
/*  46 */     this.b = new Group();
/*  47 */     this.b.setName("OpenedPackOverlay mainContainerWrap");
/*  48 */     this.b.setTransform(false);
/*  49 */     this.b.setTouchable(Touchable.childrenOnly);
/*  50 */     this.b.setOrigin(640.0F, f * 0.5F);
/*  51 */     this.a.getTable().add((Actor)this.b).size(1280.0F, f);
/*     */     
/*  53 */     this.c = new Group();
/*  54 */     this.c.setName("OpenedPackOverlay mainContainer");
/*  55 */     this.c.setTransform(false);
/*  56 */     this.c.setSize(1280.0F, f);
/*  57 */     this.c.setOrigin(640.0F, f * 0.5F);
/*  58 */     this.c.setTouchable(Touchable.childrenOnly);
/*  59 */     this.b.addActor((Actor)this.c);
/*     */     
/*  61 */     this.d = new Table();
/*  62 */     this.d.setName("OpenedPackOverlay cells");
/*  63 */     this.d.setSize(1280.0F, f);
/*  64 */     this.d.setTouchable(Touchable.childrenOnly);
/*     */     
/*  66 */     this.e = new ScrollPane((Actor)this.d, Game.i.assetManager.getScrollPaneStyle(0.0F));
/*  67 */     UiUtils.enableMouseMoveScrollFocus(this.e);
/*  68 */     this.e.setName("OpenedPackOverlay scrollPane");
/*  69 */     this.e.setSize(1280.0F, f);
/*  70 */     this.e.setTouchable(Touchable.childrenOnly);
/*  71 */     this.e.setScrollingDisabled(true, false);
/*  72 */     this.c.addActor((Actor)this.e);
/*     */ 
/*     */     
/*  75 */     hide();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void show(Array<ItemStack> paramArray, boolean paramBoolean) {
/*  83 */     float f2 = Game.i.settingsManager.getScaledViewportHeight();
/*     */ 
/*     */     
/*  86 */     this.b.setOrigin(640.0F, f2 * 0.5F);
/*  87 */     this.a.getTable().clear();
/*  88 */     this.a.getTable().add((Actor)this.b).size(1280.0F, f2);
/*  89 */     this.c.setSize(1280.0F, f2);
/*  90 */     this.c.setOrigin(640.0F, f2 * 0.5F);
/*  91 */     this.d.setSize(1280.0F, f2);
/*  92 */     this.e.setSize(1280.0F, f2);
/*     */ 
/*     */     
/*  95 */     this.f = Game.getTimestampMillis();
/*     */     
/*  97 */     this.d.clear();
/*  98 */     this.d.add().width(1.0F).height(40.0F).row();
/*     */     
/* 100 */     if (paramBoolean) {
/* 101 */       Table table = new Table();
/* 102 */       this.d.add((Actor)table).padBottom(16.0F).colspan(10).row();
/*     */       
/*     */       Image image;
/* 105 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-cubes-stacked-tall"))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 106 */       table.add((Actor)image).size(48.0F);
/*     */       
/*     */       Label label1;
/* 109 */       (label1 = new Label(Game.i.localeManager.i18n.get("items_were_stacked_hint"), Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 110 */       label1.setTouchable(Touchable.disabled);
/* 111 */       label1.setAlignment(1);
/* 112 */       table.add((Actor)label1).height(48.0F).padLeft(16.0F);
/*     */     } 
/*     */     
/* 115 */     float f1 = 0.1F;
/* 116 */     byte b1 = 0;
/* 117 */     byte b2 = 0;
/* 118 */     byte b3 = 0;
/* 119 */     for (byte b4 = 0; b4 < paramArray.size; b4++) {
/* 120 */       ItemStack itemStack = (ItemStack)paramArray.get(b4);
/*     */       
/*     */       ItemCell itemCell;
/*     */       
/* 124 */       (itemCell = new ItemCell()).setItemStack(itemStack);
/* 125 */       itemCell.setColRow(b2, b3);
/* 126 */       itemCell.setCovered(true);
/* 127 */       itemCell.addAction((Action)Actions.sequence(
/* 128 */             (Action)Actions.delay(f1), 
/* 129 */             (Action)Actions.run(() -> paramItemCell.reveal()), 
/* 130 */             (Action)Actions.delay(0.3F), 
/* 131 */             (Action)Actions.run(() -> {
/*     */                 if (paramItemCell.getItem().getRarity().ordinal() >= RarityType.LEGENDARY.ordinal()) {
/*     */                   paramItemCell.showRays(true);
/*     */                 }
/*     */               })));
/*     */ 
/*     */       
/* 138 */       itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 141 */               ItemDescriptionDialog.i().showWithCount(this.a.getItem(), this.a.getCount());
/*     */             }
/*     */           });
/*     */       
/*     */       float f;
/* 146 */       if ((f = 0.3F - b1 * 0.05F) < 0.05F) {
/* 147 */         f = 0.05F;
/*     */       }
/* 149 */       f1 += f;
/* 150 */       b1++;
/*     */       
/* 152 */       this.d.add((Actor)itemCell);
/*     */       
/* 154 */       b2++;
/* 155 */       if (b2 == 10) {
/* 156 */         b2 = 0;
/* 157 */         b3++;
/*     */         
/* 159 */         this.d.row();
/*     */       } 
/*     */     } 
/*     */     
/*     */     Label label;
/* 164 */     (label = new Label(Game.i.localeManager.i18n.get("tap_outside_list_to_hide"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 165 */     label.setTouchable(Touchable.disabled);
/* 166 */     label.setAlignment(1);
/* 167 */     this.d.row();
/* 168 */     this.d.add((Actor)label).width(1.0F).padTop(16.0F).colspan(10);
/* 169 */     label.addAction((Action)Actions.sequence((Action)Actions.alpha(0.0F), (Action)Actions.delay(0.75F), (Action)Actions.fadeIn(0.3F)));
/*     */     
/* 171 */     DarkOverlay.i().addCallerOverlayLayer("OpenedPackOverlay", this.a.zIndex - 1, () -> {
/*     */           if (Game.getTimestampMillis() - this.f > 500L) {
/*     */             hide();
/*     */             
/*     */             return true;
/*     */           } 
/*     */           return false;
/*     */         });
/* 179 */     UiUtils.bouncyShowOverlayWithCallback(null, (Actor)this.a.getTable(), this.c, () -> this.c.setTouchable(Touchable.childrenOnly));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     this.d.row();
/* 185 */     this.d.add().width(1.0F).height(40.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 190 */     DarkOverlay.i().removeCaller("OpenedPackOverlay");
/* 191 */     UiUtils.bouncyHideOverlay(null, (Actor)this.a.getTable(), this.c);
/*     */ 
/*     */ 
/*     */     
/* 195 */     this.d.clear();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\OpenedPackOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */