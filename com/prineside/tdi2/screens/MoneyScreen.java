/*      */ package com.prineside.tdi2.screens;
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Screen;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.pay.Information;
/*      */ import com.badlogic.gdx.pay.Transaction;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Research;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.CaseType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.items.AcceleratorItem;
/*      */ import com.prineside.tdi2.items.CaseItem;
/*      */ import com.prineside.tdi2.items.CaseKeyItem;
/*      */ import com.prineside.tdi2.items.DoubleGainShardItem;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.PurchaseManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Progress;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Purchase;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Cell;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.ui.actors.AttentionRaysUnderlay;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.FancyButton;
/*      */ import com.prineside.tdi2.ui.actors.HighlightActor;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelButton;
/*      */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*      */ import com.prineside.tdi2.ui.actors.ParticlesCanvas;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.actors.TableButton;
/*      */ import com.prineside.tdi2.ui.shared.BackButton;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.InventoryOverlay;
/*      */ import com.prineside.tdi2.ui.shared.ItemCountSelectionOverlay;
/*      */ import com.prineside.tdi2.ui.shared.ItemDescriptionDialog;
/*      */ import com.prineside.tdi2.ui.shared.LuckyWheelOverlay;
/*      */ import com.prineside.tdi2.ui.shared.ResourcesAndMoney;
/*      */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*      */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*      */ import com.prineside.tdi2.utils.InputVoid;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.QuadDrawable;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Locale;
/*      */ 
/*      */ public class MoneyScreen extends Screen {
/*   81 */   private static final TLog a = TLog.forClass(MoneyScreen.class);
/*      */   
/*      */   private Screen b;
/*      */   
/*   85 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "MoneyScreen main");
/*   86 */   private final UiManager.UiLayer d = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.OVERLAY, 101, "MoneyScreen loading overlay", true);
/*      */   
/*      */   private ComplexButton e;
/*      */   private Label f;
/*      */   private Label g;
/*      */   private float h;
/*   92 */   private final Array<TableButton> i = new Array(true, 1, TableButton.class);
/*   93 */   private int j = -1;
/*      */   
/*      */   private Table k;
/*   96 */   private final _PurchaseManagerListener l = new _PurchaseManagerListener((byte)0);
/*   97 */   private final _ProgressManagerListener m = new _ProgressManagerListener((byte)0);
/*      */   
/*      */   private Label n;
/*      */   
/*      */   private long o;
/*      */   
/*      */   private long p;
/*  104 */   private static float[] q = new float[] { 0.0F, 5.0F, 0.0F, 161.0F, 590.0F, 166.0F, 590.0F, 0.0F };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  110 */   private static float[] r = new float[] { 0.0F, 0.0F, 0.0F, 166.0F, 590.0F, 161.0F, 590.0F, 5.0F };
/*      */ 
/*      */   
/*      */   private class PaperPackConfig
/*      */   {
/*      */     String a;
/*      */     
/*      */     String b;
/*      */     
/*      */     int c;
/*      */     int d;
/*      */     int e;
/*      */     int f;
/*      */     @Null
/*      */     ItemStack g;
/*      */     
/*      */     public PaperPackConfig(MoneyScreen this$0, String param1String1, String param1String2, int param1Int1, int param1Int2, int param1Int3, @Null int param1Int4, ItemStack param1ItemStack) {
/*  127 */       this.b = param1String1;
/*  128 */       this.a = param1String2;
/*  129 */       this.c = param1Int1;
/*  130 */       this.d = param1Int2;
/*  131 */       this.e = param1Int3;
/*  132 */       this.f = param1Int4;
/*  133 */       this.g = param1ItemStack;
/*      */     } }
/*      */   
/*      */   private class AcceleratorPackConfig {
/*      */     String a;
/*      */     String b;
/*      */     int c;
/*      */     int d;
/*      */     int e;
/*      */     int f;
/*      */     @Null
/*      */     ItemStack g;
/*      */     
/*      */     public AcceleratorPackConfig(MoneyScreen this$0, String param1String1, String param1String2, int param1Int1, int param1Int2, int param1Int3, @Null int param1Int4, ItemStack param1ItemStack) {
/*  147 */       this.b = param1String1;
/*  148 */       this.a = param1String2;
/*  149 */       this.c = param1Int1;
/*  150 */       this.d = param1Int2;
/*  151 */       this.e = param1Int3;
/*  152 */       this.f = param1Int4;
/*  153 */       this.g = param1ItemStack;
/*      */     }
/*      */   }
/*      */   
/*  157 */   private Array<PaperPackConfig> s = new Array(PaperPackConfig.class);
/*  158 */   private Array<AcceleratorPackConfig> t = new Array(AcceleratorPackConfig.class);
/*      */ 
/*      */ 
/*      */   
/*      */   private ScrollPane u;
/*      */ 
/*      */ 
/*      */   
/*      */   public MoneyScreen(Screen paramScreen) {
/*  167 */     a.i("AR rewardAdsAvailable: " + Game.i.actionResolver.rewardAdsAvailable(), new Object[0]);
/*  168 */     a.i("AR getSecondsTillCanShowRewardAd: " + Game.i.actionResolver.getSecondsTillCanShowRewardAd(), new Object[0]);
/*  169 */     a.i("AR canShowRewardAd: " + Game.i.actionResolver.canShowRewardAd(), new Object[0]);
/*  170 */     a.i("PM rewardingAdsAvailable: " + Game.i.purchaseManager.rewardingAdsAvailable(), new Object[0]);
/*  171 */     a.i("PM canShowRewardingAd (REGULAR): " + Game.i.purchaseManager.canShowRewardingAd(PurchaseManager.RewardingAdsType.REGULAR), new Object[0]);
/*  172 */     a.i("PM getSecondsTillAdIsReady (REGULAR): " + Game.i.purchaseManager.getSecondsTillAdIsReady(PurchaseManager.RewardingAdsType.REGULAR), new Object[0]);
/*      */     
/*  174 */     PurchaseManager.IapOffersConfig iapOffersConfig = Game.i.purchaseManager.getIapOfferConfig();
/*      */     
/*  176 */     this.s.add(new PaperPackConfig(this, "money-pack-tiny", Game.i.purchaseManager
/*      */           
/*  178 */           .getPurchaseIdentifier(Config.ProductId.PACK_TINY), iapOffersConfig
/*  179 */           .getPurchaseBaseAmount(Config.ProductId.PACK_TINY), iapOffersConfig
/*  180 */           .getBonusPurchaseAmount(Config.ProductId.PACK_TINY), iapOffersConfig
/*  181 */           .getPurchaseBonus(Config.ProductId.PACK_TINY), 21, iapOffersConfig
/*      */           
/*  183 */           .getAdditionalItem(Config.ProductId.PACK_TINY)));
/*      */     
/*  185 */     this.s.add(new PaperPackConfig(this, "money-pack-small", Game.i.purchaseManager
/*      */           
/*  187 */           .getPurchaseIdentifier(Config.ProductId.PACK_SMALL), iapOffersConfig
/*  188 */           .getPurchaseBaseAmount(Config.ProductId.PACK_SMALL), iapOffersConfig
/*  189 */           .getBonusPurchaseAmount(Config.ProductId.PACK_SMALL), iapOffersConfig
/*  190 */           .getPurchaseBonus(Config.ProductId.PACK_SMALL), 21, iapOffersConfig
/*      */           
/*  192 */           .getAdditionalItem(Config.ProductId.PACK_SMALL)));
/*      */     
/*  194 */     this.s.add(new PaperPackConfig(this, "money-pack-medium", Game.i.purchaseManager
/*      */           
/*  196 */           .getPurchaseIdentifier(Config.ProductId.PACK_MEDIUM), iapOffersConfig
/*  197 */           .getPurchaseBaseAmount(Config.ProductId.PACK_MEDIUM), iapOffersConfig
/*  198 */           .getBonusPurchaseAmount(Config.ProductId.PACK_MEDIUM), iapOffersConfig
/*  199 */           .getPurchaseBonus(Config.ProductId.PACK_MEDIUM), 24, iapOffersConfig
/*      */           
/*  201 */           .getAdditionalItem(Config.ProductId.PACK_MEDIUM)));
/*      */     
/*  203 */     this.s.add(new PaperPackConfig(this, "money-pack-large", Game.i.purchaseManager
/*      */           
/*  205 */           .getPurchaseIdentifier(Config.ProductId.PACK_LARGE), iapOffersConfig
/*  206 */           .getPurchaseBaseAmount(Config.ProductId.PACK_LARGE), iapOffersConfig
/*  207 */           .getBonusPurchaseAmount(Config.ProductId.PACK_LARGE), iapOffersConfig
/*  208 */           .getPurchaseBonus(Config.ProductId.PACK_LARGE), 30, iapOffersConfig
/*      */           
/*  210 */           .getAdditionalItem(Config.ProductId.PACK_LARGE)));
/*      */ 
/*      */     
/*  213 */     boolean bool = false;
/*      */     
/*      */     PP_Purchase pP_Purchase;
/*      */     
/*      */     Array array;
/*      */     
/*  219 */     if ((array = (pP_Purchase = (ProgressPrefs.i()).purchase).getTransactions()).size >= 3) {
/*  220 */       bool = true;
/*      */     }
/*  222 */     for (byte b = 0; b < array.size; b++) {
/*  223 */       if (((Transaction)array
/*  224 */         .get(b)).getIdentifier().equals(Game.i.purchaseManager.getPurchaseIdentifier(Config.ProductId.PACK_MEDIUM)) || ((Transaction)array
/*  225 */         .get(b)).getIdentifier().equals(Game.i.purchaseManager.getPurchaseIdentifier(Config.ProductId.PACK_LARGE)) || ((Transaction)array
/*  226 */         .get(b)).getIdentifier().equals(Game.i.purchaseManager.getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_LARGE))) {
/*  227 */         bool = true;
/*      */       }
/*      */     } 
/*  230 */     if (bool) {
/*  231 */       this.s.add(new PaperPackConfig(this, "money-pack-huge", Game.i.purchaseManager
/*      */             
/*  233 */             .getPurchaseIdentifier(Config.ProductId.PACK_HUGE), iapOffersConfig
/*  234 */             .getPurchaseBaseAmount(Config.ProductId.PACK_HUGE), iapOffersConfig
/*  235 */             .getBonusPurchaseAmount(Config.ProductId.PACK_HUGE), iapOffersConfig
/*  236 */             .getPurchaseBonus(Config.ProductId.PACK_HUGE), 36, iapOffersConfig
/*      */             
/*  238 */             .getAdditionalItem(Config.ProductId.PACK_HUGE)));
/*      */     }
/*      */ 
/*      */     
/*  242 */     this.t.add(new AcceleratorPackConfig(this, "accelerator-pack-tiny", Game.i.purchaseManager
/*      */           
/*  244 */           .getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_TINY), iapOffersConfig
/*  245 */           .getPurchaseBaseAmount(Config.ProductId.ACCELERATOR_PACK_TINY), iapOffersConfig
/*  246 */           .getBonusPurchaseAmount(Config.ProductId.ACCELERATOR_PACK_TINY), iapOffersConfig
/*  247 */           .getPurchaseBonus(Config.ProductId.ACCELERATOR_PACK_TINY), 21, iapOffersConfig
/*      */           
/*  249 */           .getAdditionalItem(Config.ProductId.ACCELERATOR_PACK_TINY)));
/*      */     
/*  251 */     this.t.add(new AcceleratorPackConfig(this, "accelerator-pack-small", Game.i.purchaseManager
/*      */           
/*  253 */           .getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_SMALL), iapOffersConfig
/*  254 */           .getPurchaseBaseAmount(Config.ProductId.ACCELERATOR_PACK_SMALL), iapOffersConfig
/*  255 */           .getBonusPurchaseAmount(Config.ProductId.ACCELERATOR_PACK_SMALL), iapOffersConfig
/*  256 */           .getPurchaseBonus(Config.ProductId.ACCELERATOR_PACK_SMALL), 24, iapOffersConfig
/*      */           
/*  258 */           .getAdditionalItem(Config.ProductId.ACCELERATOR_PACK_SMALL)));
/*      */     
/*  260 */     this.t.add(new AcceleratorPackConfig(this, "accelerator-pack-medium", Game.i.purchaseManager
/*      */           
/*  262 */           .getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_MEDIUM), iapOffersConfig
/*  263 */           .getPurchaseBaseAmount(Config.ProductId.ACCELERATOR_PACK_MEDIUM), iapOffersConfig
/*  264 */           .getBonusPurchaseAmount(Config.ProductId.ACCELERATOR_PACK_MEDIUM), iapOffersConfig
/*  265 */           .getPurchaseBonus(Config.ProductId.ACCELERATOR_PACK_MEDIUM), 30, iapOffersConfig
/*      */           
/*  267 */           .getAdditionalItem(Config.ProductId.ACCELERATOR_PACK_MEDIUM)));
/*      */     
/*  269 */     this.t.add(new AcceleratorPackConfig(this, "accelerator-pack-large", Game.i.purchaseManager
/*      */           
/*  271 */           .getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_LARGE), iapOffersConfig
/*  272 */           .getPurchaseBaseAmount(Config.ProductId.ACCELERATOR_PACK_LARGE), iapOffersConfig
/*  273 */           .getBonusPurchaseAmount(Config.ProductId.ACCELERATOR_PACK_LARGE), iapOffersConfig
/*  274 */           .getPurchaseBonus(Config.ProductId.ACCELERATOR_PACK_LARGE), 36, iapOffersConfig
/*      */           
/*  276 */           .getAdditionalItem(Config.ProductId.ACCELERATOR_PACK_LARGE)));
/*      */ 
/*      */     
/*  279 */     if (bool) {
/*  280 */       this.t.add(new AcceleratorPackConfig(this, "accelerator-pack-huge", Game.i.purchaseManager
/*      */             
/*  282 */             .getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_HUGE), iapOffersConfig
/*  283 */             .getPurchaseBaseAmount(Config.ProductId.ACCELERATOR_PACK_HUGE), iapOffersConfig
/*  284 */             .getBonusPurchaseAmount(Config.ProductId.ACCELERATOR_PACK_HUGE), iapOffersConfig
/*  285 */             .getPurchaseBonus(Config.ProductId.ACCELERATOR_PACK_HUGE), 36, iapOffersConfig
/*      */             
/*  287 */             .getAdditionalItem(Config.ProductId.ACCELERATOR_PACK_HUGE)));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  292 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*      */     
/*  294 */     this.b = paramScreen;
/*      */ 
/*      */     
/*  297 */     Game.i.uiManager.hideAllComponents();
/*  298 */     Game.i.uiManager.setAsInputHandler();
/*      */     
/*  300 */     ResourcesAndMoney.i()
/*  301 */       .setVisible(true);
/*      */     
/*  303 */     InventoryOverlay.i()
/*  304 */       .hideWithToggleButton(true);
/*      */     
/*  306 */     ScreenTitle.i()
/*  307 */       .setText(Game.i.localeManager.i18n.get("money_screen_title"))
/*  308 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-money"))
/*  309 */       .setVisible(true);
/*      */     
/*  311 */     BackButton.i()
/*  312 */       .setVisible(true)
/*  313 */       .setText(null)
/*  314 */       .setClickHandler(() -> c());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  319 */     Game.i.purchaseManager.addListener((PurchaseManager.PurchaseManagerListener)this.l);
/*  320 */     Game.i.progressManager.addListener((ProgressManager.ProgressManagerListener)this.m);
/*      */   }
/*      */   
/*      */   public void scrollToActor(String paramString) {
/*      */     Actor actor;
/*  325 */     if ((actor = Game.i.uiManager.findActor(paramString)) == null) {
/*  326 */       a.i("scrollToActor failed: actor with name " + paramString + " not found", new Object[0]);
/*      */       return;
/*      */     } 
/*  329 */     if (this.u == null) {
/*  330 */       a.i("scrollToActor failed: mainScroll is null", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  334 */     if (!UiUtils.hasParent(actor, (Group)this.u)) {
/*  335 */       a.i("scrollToActor failed: actor " + paramString + " is not contained in mainScroll", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*      */     try {
/*  340 */       Vector2 vector2 = actor.localToAscendantCoordinates((Actor)this.u, new Vector2(0.0F, 0.0F));
/*      */       
/*  342 */       this.u.scrollTo(0.0F, this.u.getChild(0).getHeight() + vector2.y - this.u.getHeight() - this.u.getHeight() * 0.5F + actor.getHeight() * 0.5F, 1.0F, 1.0F);
/*      */       
/*  344 */       HighlightActor highlightActor = Game.i.uiManager.addHighlight(actor);
/*  345 */       actor.addListener((EventListener)new InputListener(this, highlightActor)
/*      */           {
/*      */             public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  348 */               Game.i.uiManager.removeHighlight(this.a);
/*  349 */               return false; }
/*      */           });
/*      */       return;
/*  352 */     } catch (Exception exception) {
/*  353 */       a.i("scrollToActor failed", new Object[] { exception });
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void resize(int paramInt1, int paramInt2) {
/*  359 */     super.resize(paramInt1, paramInt2);
/*      */     
/*  361 */     if (paramInt1 > 0 && paramInt2 > 0) {
/*  362 */       a();
/*      */     }
/*      */   }
/*      */   
/*      */   private Group a(boolean paramBoolean, Drawable paramDrawable) {
/*  367 */     return a(paramBoolean, paramDrawable, 0.0F);
/*      */   }
/*      */   
/*      */   private static Group a(boolean paramBoolean, Drawable paramDrawable, float paramFloat) {
/*      */     Group group;
/*  372 */     (group = new Group()).setTransform(false);
/*      */     
/*  374 */     float[] arrayOfFloat = new float[8];
/*  375 */     if (paramBoolean) {
/*  376 */       System.arraycopy(q, 0, arrayOfFloat, 0, q.length);
/*      */     } else {
/*  378 */       System.arraycopy(r, 0, arrayOfFloat, 0, r.length);
/*      */     } 
/*  380 */     arrayOfFloat[3] = arrayOfFloat[3] + paramFloat;
/*  381 */     arrayOfFloat[5] = arrayOfFloat[5] + paramFloat;
/*      */     
/*  383 */     QuadActor quadActor = new QuadActor(new Color(690563583), arrayOfFloat);
/*  384 */     group.addActor((Actor)quadActor);
/*      */     
/*  386 */     if (paramBoolean) {
/*      */       QuadActor quadActor1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  393 */       (quadActor1 = new QuadActor(new Color(943208703), new float[] { 0.0F, 0.0F, 0.0F, 6.0F, 590.0F, 10.0F, 589.0F, 8.0F })).setPosition(0.0F, paramFloat + 156.0F);
/*  394 */       group.addActor((Actor)quadActor1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  402 */       (quadActor1 = new QuadActor(new Color(943208703), new float[] { 0.0F, 0.0F, 0.0F, paramFloat + 156.0F, 6.0F, paramFloat + 156.0F, 1.0F, 0.0F })).setPosition(0.0F, 6.0F);
/*  403 */       group.addActor((Actor)quadActor1);
/*      */     } else {
/*      */       QuadActor quadActor1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  411 */       (quadActor1 = new QuadActor(new Color(943208703), new float[] { 0.0F, 1.0F, 0.0F, 6.0F, 590.0F, 1.0F, 590.0F, 0.0F })).setPosition(0.0F, paramFloat + 160.0F);
/*  412 */       group.addActor((Actor)quadActor1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  420 */       (quadActor1 = new QuadActor(new Color(943208703), new float[] { 0.0F, 0.0F, 0.0F, paramFloat + 165.0F, 5.0F, paramFloat + 164.0F, 1.0F, 0.0F })).setPosition(0.0F, 0.0F);
/*  421 */       group.addActor((Actor)quadActor1);
/*      */     } 
/*      */     
/*      */     Image image;
/*  425 */     (image = new Image(paramDrawable)).setSize(128.0F, 128.0F);
/*  426 */     image.setPosition(16.0F, 19.0F + paramFloat * 0.5F);
/*  427 */     group.addActor((Actor)image);
/*      */     
/*  429 */     return group;
/*      */   }
/*      */   
/*      */   private static ComplexButton a(CharSequence paramCharSequence, Runnable paramRunnable) {
/*      */     ComplexButton complexButton;
/*  434 */     (complexButton = new ComplexButton(paramCharSequence, Game.i.assetManager.getLabelStyle(30), paramRunnable)).setIconLabelShadowEnabled(true);
/*  435 */     complexButton.setSize(162.0F, 88.0F);
/*  436 */     complexButton.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-money-screen-button"), 0.0F, 0.0F, 162.0F, 88.0F);
/*  437 */     complexButton.setBackgroundColors(MaterialColor.LIGHT_GREEN.P600, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P500, MaterialColor.GREY.P700);
/*      */     Image image;
/*  439 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-money-screen-button-edge"))).setSize(162.0F, 88.0F);
/*  440 */     complexButton.addActor((Actor)image);
/*  441 */     complexButton.setLabel(5.0F, 39.0F, 157.0F, 21.0F, 1);
/*  442 */     complexButton.setPosition(445.0F, 11.0F);
/*      */     
/*  444 */     return complexButton;
/*      */   }
/*      */   
/*      */   private void a() {
/*  448 */     Game.i.uiManager.removeAllHighlights();
/*      */     
/*  450 */     float f1 = 0.0F;
/*  451 */     if (this.u != null) {
/*  452 */       f1 = this.u.getScrollY();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  458 */     float f2 = Game.i.uiManager.getRegularLayerWidth();
/*      */     
/*      */     Table table1;
/*  461 */     (table1 = this.c.getTable()).clear();
/*      */     
/*  463 */     Table table2 = new Table();
/*      */     ScrollPane scrollPane;
/*  465 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)table2));
/*  466 */     scrollPane.setSize(f2, Game.i.settingsManager.getScaledViewportHeight());
/*  467 */     scrollPane.setScrollingDisabled(true, false);
/*  468 */     table1.add((Actor)scrollPane).width(f2).height(Game.i.settingsManager.getScaledViewportHeight());
/*  469 */     this.u = scrollPane;
/*      */     
/*  471 */     Game.i.uiManager.stage.setScrollFocus((Actor)this.u);
/*      */     
/*  473 */     table2.add().height(128.0F).width(1.0F).row();
/*      */     
/*      */     Group group2;
/*      */     
/*  477 */     (group2 = new Group()).setTransform(false);
/*      */     
/*  479 */     QuadActor quadActor2 = new QuadActor(Color.WHITE, q);
/*  480 */     if (Game.i.progressManager.getLootBoostTimeLeft() > 0.0F) {
/*  481 */       quadActor2.setVertexColors(new Color(641146367), new Color(472258559), new Color(506009855), new Color(674963199));
/*      */     } else {
/*  483 */       quadActor2.setVertexColorsSingle(new Color(51));
/*      */     } 
/*  485 */     group2.addActor((Actor)quadActor2);
/*      */     
/*      */     Image image3;
/*  488 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("loot-token"))).setSize(128.0F, 128.0F);
/*  489 */     image3.setPosition(16.0F, 19.0F);
/*  490 */     group2.addActor((Actor)image3);
/*      */     
/*      */     Label label5;
/*  493 */     (label5 = new Label(Item.D.LOOT_BOOST.getTitle(), Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 23.0F);
/*  494 */     label5.setPosition(158.0F, 112.0F);
/*  495 */     label5.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  496 */     group2.addActor((Actor)label5);
/*      */ 
/*      */     
/*  499 */     (label5 = new Label(Item.D.LOOT_BOOST.getDescription(), Game.i.assetManager.getLabelStyle(21))).setPosition(158.0F, 19.0F);
/*  500 */     label5.setSize(290.0F, 80.0F);
/*  501 */     label5.setWrap(true);
/*  502 */     label5.setAlignment(10);
/*  503 */     group2.addActor((Actor)label5);
/*      */     
/*  505 */     this.n = new Label("", Game.i.assetManager.getLabelStyle(36));
/*  506 */     this.n.setAlignment(16);
/*  507 */     this.n.setPosition(425.0F, 25.0F);
/*  508 */     this.n.setSize(145.0F, 28.0F);
/*  509 */     group2.addActor((Actor)this.n);
/*      */     
/*  511 */     table2.add((Actor)group2).size(590.0F, 166.0F).padRight(20.0F);
/*      */ 
/*      */     
/*  514 */     int i = Game.i.progressManager.getItemsCount((Item)Item.D.RARITY_BOOST);
/*      */     Group group4;
/*  516 */     (group4 = new Group()).setTransform(false);
/*      */     
/*  518 */     QuadActor quadActor1 = new QuadActor(Color.WHITE, r);
/*  519 */     if (i > 0) {
/*  520 */       quadActor1.setVertexColors(new Color(1311839743), new Color(756879103), new Color(857804799), new Color(1429542655));
/*      */     } else {
/*  522 */       quadActor1.setVertexColorsSingle(new Color(51));
/*      */     } 
/*  524 */     group4.addActor((Actor)quadActor1);
/*      */     
/*      */     Image image2;
/*  527 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("rarity-token"))).setSize(128.0F, 128.0F);
/*  528 */     image2.setPosition(16.0F, 19.0F);
/*  529 */     group4.addActor((Actor)image2);
/*      */     
/*      */     Label label4;
/*  532 */     (label4 = new Label(Item.D.RARITY_BOOST.getTitle(), Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 23.0F);
/*  533 */     label4.setPosition(158.0F, 112.0F);
/*  534 */     label4.setColor(MaterialColor.AMBER.P400);
/*  535 */     group4.addActor((Actor)label4);
/*      */ 
/*      */     
/*  538 */     (label4 = new Label(Item.D.RARITY_BOOST.getDescription(), Game.i.assetManager.getLabelStyle(21))).setPosition(158.0F, 19.0F);
/*  539 */     label4.setSize(290.0F, 80.0F);
/*  540 */     label4.setWrap(true);
/*  541 */     label4.setAlignment(10);
/*  542 */     group4.addActor((Actor)label4);
/*      */ 
/*      */     
/*  545 */     (label4 = new Label("x" + i, Game.i.assetManager.getLabelStyle(36))).setAlignment(16);
/*  546 */     label4.setPosition(425.0F, 25.0F);
/*  547 */     label4.setSize(145.0F, 28.0F);
/*  548 */     if (i > 0) {
/*  549 */       label4.setColor(MaterialColor.AMBER.P400);
/*      */     } else {
/*  551 */       label4.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */     } 
/*  553 */     group4.addActor((Actor)label4);
/*      */     
/*  555 */     table2.add((Actor)group4).size(590.0F, 166.0F).row();
/*      */     
/*      */     Label label2;
/*      */     
/*  559 */     (label2 = new Label(Game.i.localeManager.i18n.get("shop_tokens_info"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  560 */     table2.add((Actor)label2).padTop(20.0F).padBottom(20.0F).colspan(2).row();
/*      */     
/*  562 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*  563 */       if (Game.i.authManager.isSignedIn() && Game.i.authManager.getSessionId() != null) {
/*  564 */         if (Game.i.authManager.getSteamAccountId() == null) {
/*      */           Table table;
/*      */           
/*  567 */           (table = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/*      */           
/*  569 */           (label4 = new Label(Game.i.localeManager.i18n.get("shop_steam_not_linked_no_iaps"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P300);
/*  570 */           table.add((Actor)label4).center().pad(15.0F).row();
/*      */           
/*      */           FancyButton fancyButton;
/*      */           
/*  574 */           (fancyButton = (new FancyButton("regularButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("link_steam_button"))).setClickHandler(() -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("link_steam_button_confirm"), ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  582 */           table.add((Actor)fancyButton).height(48.0F).width(320.0F).padBottom(15.0F).row();
/*      */           
/*  584 */           table2.add((Actor)table).fillX().padTop(20.0F).padBottom(20.0F).colspan(2).row();
/*      */         } 
/*      */       } else {
/*      */         Table table;
/*      */         
/*  589 */         (table = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/*      */         
/*  591 */         (label4 = new Label(Game.i.localeManager.i18n.get("shop_steam_not_logined_no_iaps"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P300);
/*  592 */         table.add((Actor)label4).center().pad(15.0F).row();
/*      */         
/*  594 */         table2.add((Actor)table).fillX().padTop(20.0F).padBottom(20.0F).colspan(2).row();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  599 */     Group group1 = a(false, (Drawable)Game.i.assetManager.getDrawable("money-pack-double-gain"), 32.0F);
/*      */     
/*  601 */     String str1 = Game.i.localeManager.i18n.get("double_gain_title");
/*  602 */     if (Game.i.progressManager.hasTemporaryDoubleGain()) {
/*      */       
/*  604 */       int j = DoubleGainShardItem.getAcceleratorsForDuration(Game.i.progressManager.getTempDoubleGainDurationLeft());
/*  605 */       str1 = str1 + Game.i.assetManager.replaceRegionAliasesWithChars(" +<@time-accelerator>" + j);
/*      */     } 
/*      */     Label label3;
/*  608 */     (label3 = new Label(str1, Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 23.0F);
/*  609 */     label3.setPosition(158.0F, 144.0F);
/*  610 */     label3.setColor(MaterialColor.AMBER.P400);
/*  611 */     group1.addActor((Actor)label3);
/*      */ 
/*      */     
/*  614 */     (label3 = new Label(Game.i.localeManager.i18n.get("double_gain_description"), Game.i.assetManager.getLabelStyle(21))).setPosition(158.0F, 19.0F);
/*  615 */     label3.setSize(275.0F, 112.0F);
/*  616 */     label3.setWrap(true);
/*  617 */     label3.setAlignment(10);
/*  618 */     group1.addActor((Actor)label3);
/*      */     
/*      */     Label label6;
/*  621 */     (label6 = new Label(Game.i.localeManager.i18n.get("double_gain_permanent_hint").toUpperCase(), Game.i.assetManager.getLabelStyle(24))).setPosition(469.0F, 149.0F);
/*  622 */     label6.setAlignment(16);
/*  623 */     label6.setSize(100.0F, 18.0F);
/*  624 */     label6.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  625 */     group1.addActor((Actor)label6);
/*      */     
/*  627 */     if (Game.i.progressManager.hasPermanentDoubleGain()) {
/*      */       
/*  629 */       (label6 = new Label(Game.i.localeManager.i18n.get("enabled"), Game.i.assetManager.getLabelStyle(30))).setAlignment(16);
/*  630 */       label6.setPosition(425.0F, 30.0F);
/*  631 */       label6.setSize(145.0F, 28.0F);
/*  632 */       label6.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  633 */       group1.addActor((Actor)label6);
/*      */     } else {
/*  635 */       ComplexButton complexButton1; label6 = null;
/*  636 */       if (Game.i.purchaseManager.isPurchasesEnabled()) {
/*      */         try {
/*      */           Information information;
/*  639 */           if ((information = Game.i.purchaseManager.purchaseManager.getInformation(Game.i.purchaseManager.getPurchaseIdentifier(Config.ProductId.DOUBLE_GAIN))) != Information.UNAVAILABLE && "true".equals(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_DOUBLE_GAIN_ENABLED))) {
/*  640 */             complexButton1 = a(information.getLocalPricing(), () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("double_gain_purchase_confirm"), ()));
/*      */ 
/*      */             
/*  643 */             group1.addActor((Actor)complexButton1);
/*      */           } 
/*  645 */         } catch (Throwable throwable) {
/*  646 */           a.e("failed to get purchase info", new Object[] { throwable });
/*      */         } 
/*      */       }
/*  649 */       if (complexButton1 == null) {
/*      */ 
/*      */ 
/*      */         
/*  653 */         (complexButton1 = a("$4.99", () -> {  })).setEnabled(false);
/*  654 */         group1.addActor((Actor)complexButton1);
/*      */       } 
/*      */     } 
/*      */     
/*  658 */     table2.add((Actor)group1).size(590.0F, 198.0F).padRight(20.0F);
/*      */ 
/*      */     
/*  661 */     if (Game.i.purchaseManager.rewardingAdsAvailable()) {
/*  662 */       boolean bool2 = Game.i.progressManager.isPremiumStatusActive();
/*      */       
/*  664 */       Group group = a(true, (Drawable)Game.i.assetManager.getDrawable(bool2 ? "icon-cubes-stacked-tall" : "rewarding-ad"), 32.0F);
/*      */       
/*  666 */       if (bool2) {
/*  667 */         label3 = new Label(Game.i.localeManager.i18n.get("free_rewards_rewarding_ads_title"), Game.i.assetManager.getLabelStyle(30));
/*      */       } else {
/*  669 */         label3 = new Label(Game.i.localeManager.i18n.get("rewarding_ads_title"), Game.i.assetManager.getLabelStyle(30));
/*      */       } 
/*  671 */       label3.setSize(100.0F, 23.0F);
/*  672 */       label3.setPosition(158.0F, 144.0F);
/*  673 */       label3.setColor(MaterialColor.AMBER.P400);
/*  674 */       group.addActor((Actor)label3);
/*      */       
/*      */       LimitedWidthLabel limitedWidthLabel;
/*  677 */       (limitedWidthLabel = new LimitedWidthLabel(Game.i.localeManager.i18n.get("rewarding_ads_description"), 21, 18, 390.0F)).setPosition(158.0F, 19.0F);
/*  678 */       limitedWidthLabel.setSize(340.0F, 112.0F);
/*  679 */       limitedWidthLabel.setWrap(false);
/*  680 */       limitedWidthLabel.setAlignment(10);
/*  681 */       group.addActor((Actor)limitedWidthLabel);
/*      */       
/*  683 */       IssuedItems issuedItems = Game.i.progressManager.getRegularRewardingAdItems((int)Game.i.statisticsManager.getAllTime(StatisticsType.RVW) + 1);
/*  684 */       for (byte b = 0; b < issuedItems.items.size && 
/*  685 */         b != 5; b++) {
/*      */         Actor actor;
/*  687 */         (actor = ((ItemStack[])issuedItems.items.items)[b].getItem().generateIcon(48.0F, true)).setPosition(158.0F + b * 56.0F, 42.0F);
/*  688 */         group.addActor(actor);
/*      */         
/*      */         Label label;
/*  691 */         (label = new Label((CharSequence)StringFormatter.compactNumber(((ItemStack[])issuedItems.items.items)[b].getCount(), false), Game.i.assetManager.getLabelStyle(18))).setPosition(158.0F + b * 56.0F, 22.0F);
/*  692 */         label.setSize(48.0F, 16.0F);
/*  693 */         label.setAlignment(1);
/*  694 */         group.addActor((Actor)label);
/*      */       } 
/*      */       
/*  697 */       this.f = new Label("", Game.i.assetManager.getLabelStyle(30));
/*  698 */       this.f.setAlignment(16);
/*  699 */       this.f.setPosition(425.0F, 30.0F);
/*  700 */       this.f.setSize(145.0F, 28.0F);
/*  701 */       this.f.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  702 */       group.addActor((Actor)this.f);
/*      */       
/*  704 */       this.e = a(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-triangle-right>"), () -> {
/*      */             if (Game.getTimestampMillis() - this.o < 1000L) {
/*      */               return;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             if (Game.i.purchaseManager.canShowRewardingAd(PurchaseManager.RewardingAdsType.REGULAR)) {
/*      */               this.o = Game.getTimestampMillis();
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               Game.i.purchaseManager.showRewardingAd(PurchaseManager.RewardingAdsType.REGULAR, ());
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               b();
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               return;
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("ad_is_not_loaded_yet"));
/*      */           });
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  740 */       this.e.setVisible(false);
/*  741 */       this.e.setBackgroundColors(MaterialColor.LIGHT_BLUE.P600, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P500, MaterialColor.GREY.P700);
/*  742 */       group.addActor((Actor)this.e);
/*      */       
/*  744 */       table2.add((Actor)group).size(590.0F, 198.0F).row();
/*      */     } 
/*      */     
/*  747 */     if (Game.i.progressManager.hasTemporaryDoubleGain()) {
/*      */       
/*  749 */       Table table = new Table();
/*      */       
/*      */       Label label;
/*  752 */       (label = new Label(Game.i.localeManager.i18n.get("temp_double_gain_active"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_GREEN.P500);
/*  753 */       table.add((Actor)label).row();
/*      */       
/*  755 */       String str = StringFormatter.timePassed(Game.i.progressManager.getTempDoubleGainDurationLeft(), true, true);
/*  756 */       this.g = new Label(str, Game.i.assetManager.getLabelStyle(24));
/*  757 */       table.add((Actor)this.g);
/*      */       
/*  759 */       table.setBackground((Drawable)new QuadDrawable(new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 0.0F, 4.0F, 10.0F, 92.0F, 500.0F, 96.0F, 510.0F, 0.0F })));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  766 */       table2.add((Actor)table).width(510.0F).height(96.0F).padLeft(40.0F).padRight(40.0F).padTop(-4.0F).padBottom(16.0F);
/*  767 */       table2.add().row();
/*      */     } 
/*      */     
/*  770 */     table2.add().row();
/*      */ 
/*      */     
/*  773 */     Group group3 = a(true, (Drawable)Game.i.assetManager.getDrawable("lucky-shot"));
/*  774 */     String str2 = Game.i.localeManager.i18n.get("lucky_shot");
/*      */     
/*  776 */     (label3 = new Label(str2, Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 23.0F);
/*  777 */     label3.setPosition(158.0F, 112.0F);
/*  778 */     label3.setColor(MaterialColor.AMBER.P400);
/*  779 */     group3.addActor((Actor)label3);
/*      */     
/*      */     Image image1;
/*  782 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-shot-token"))).setSize(48.0F, 48.0F);
/*  783 */     image1.setPosition(158.0F, 44.0F);
/*  784 */     group3.addActor((Actor)image1);
/*      */     
/*      */     Label label1;
/*  787 */     (label1 = new Label("x" + Game.i.progressManager.getItemsCount((Item)Item.D.LUCKY_SHOT_TOKEN), Game.i.assetManager.getLabelStyle(30))).setSize(48.0F, 48.0F);
/*  788 */     label1.setPosition(212.0F, 44.0F);
/*  789 */     group3.addActor((Actor)label1);
/*      */     
/*  791 */     ComplexButton complexButton = a("", () -> LuckyWheelOverlay.i().setVisible(true));
/*      */     String str3;
/*  793 */     if ((str3 = Game.i.localeManager.i18n.get("to_open")).length() <= 6) {
/*  794 */       complexButton.setText(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-lucky-wheel> " + str3));
/*      */     } else {
/*  796 */       complexButton.setText(str3);
/*      */     } 
/*      */     
/*  799 */     complexButton.setBackgroundColors(MaterialColor.LIGHT_BLUE.P600, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P500, MaterialColor.GREY.P700);
/*  800 */     group3.addActor((Actor)complexButton);
/*      */     
/*  802 */     table2.add((Actor)group3).size(590.0F, 166.0F).padRight(20.0F).padTop(20.0F);
/*      */     
/*  804 */     table2.row();
/*      */     
/*  806 */     boolean bool1 = Game.i.authManager.isProfileStatusActive("premium");
/*  807 */     if (Game.i.purchaseManager.rewardingAdsAvailable()) {
/*      */       Label label7, label8;
/*  809 */       table2.row();
/*      */       
/*      */       Group group;
/*  812 */       (group = new Group()).setTransform(false);
/*      */ 
/*      */       
/*  815 */       if (bool1) {
/*  816 */         label8 = new Label(Game.i.localeManager.i18n.get("shop_ad_bars_premium_title"), Game.i.assetManager.getLabelStyle(36));
/*      */       } else {
/*  818 */         label8 = new Label(Game.i.localeManager.i18n.get("shop_ad_bars_title"), Game.i.assetManager.getLabelStyle(36));
/*      */       } 
/*  820 */       label8.setColor(MaterialColor.GREEN.P500);
/*  821 */       label8.setPosition(0.0F, 278.0F);
/*  822 */       label8.setSize(140.0F, 27.0F);
/*  823 */       group.addActor((Actor)label8);
/*      */ 
/*      */       
/*  826 */       if (bool1) {
/*  827 */         label7 = new Label(Game.i.localeManager.i18n.get("shop_ad_bars_premium_description"), Game.i.assetManager.getLabelStyle(24));
/*      */       } else {
/*  829 */         label7 = new Label(Game.i.localeManager.i18n.get("shop_ad_bars_description"), Game.i.assetManager.getLabelStyle(24));
/*      */       } 
/*  831 */       label7.setPosition(0.0F, 201.0F);
/*  832 */       label7.setSize(540.0F, 51.0F);
/*  833 */       label7.setWrap(true);
/*  834 */       group.addActor((Actor)label7);
/*      */       
/*      */       boolean bool2;
/*  837 */       if (bool2 = Game.i.progressManager.hasPermanentDoubleGain()) {
/*      */         Label label;
/*  839 */         (label = new Label(Game.i.localeManager.i18n.get("shop_ad_bars_hint_without_double_gain"), Game.i.assetManager.getLabelStyle(24))).setSize(255.0F, 47.0F);
/*  840 */         label.setAlignment(1);
/*  841 */         label.setWrap(true);
/*  842 */         label.setPosition(615.0F, 191.0F);
/*  843 */         label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  844 */         group.addActor((Actor)label);
/*      */       } else {
/*      */         Label label;
/*  847 */         (label = new Label(Game.i.localeManager.i18n.get("shop_ad_bars_hint_with_double_gain"), Game.i.assetManager.getLabelStyle(24))).setSize(255.0F, 47.0F);
/*  848 */         label.setAlignment(1);
/*  849 */         label.setWrap(true);
/*  850 */         label.setPosition(905.0F, 191.0F);
/*  851 */         label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  852 */         group.addActor((Actor)label);
/*      */       } 
/*      */       
/*  855 */       PP_Progress pP_Progress = (ProgressPrefs.i()).progress;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       QuadActor quadActor3;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  865 */       (quadActor3 = new QuadActor(Color.WHITE, new float[] { 5.0F, 0.0F, 0.0F, 40.0F, 584.0F, 40.0F, 589.0F, 0.0F })).setPosition(0.0F, 111.0F);
/*  866 */       quadActor3.setSize(589.0F, 40.0F);
/*  867 */       quadActor3.setVertexColorsSingle(new Color(606348543));
/*  868 */       group.addActor((Actor)quadActor3);
/*      */       
/*      */       float f;
/*  871 */       if ((f = pP_Progress.getVideosWatchedForDoubleGain() / 500.0F) > 1.0F) f = 1.0F;
/*      */ 
/*      */ 
/*      */       
/*      */       QuadActor quadActor4;
/*      */ 
/*      */       
/*  878 */       (quadActor4 = new QuadActor(Color.WHITE, new float[] { 5.0F, 0.0F, 0.0F, 40.0F, 584.0F * f, 40.0F, 584.0F * f + 5.0F, 0.0F })).setPosition(0.0F, 111.0F);
/*  879 */       quadActor4.setSize(584.0F * f + 5.0F, 40.0F);
/*  880 */       quadActor4.setVertexColorsSingle(new Color(-797506305));
/*  881 */       group.addActor((Actor)quadActor4);
/*      */       
/*      */       Image image6;
/*  884 */       (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("shop-ad-bar-reflection"))).setPosition(0.0F, 111.0F);
/*  885 */       image6.setSize(589.0F, 40.0F);
/*  886 */       group.addActor((Actor)image6);
/*      */       
/*      */       Label label9;
/*  889 */       (label9 = new Label(pP_Progress.getVideosWatchedForDoubleGain() + " / 500", Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 40.0F);
/*  890 */       label9.setPosition(476.0F, 109.0F);
/*  891 */       label9.setAlignment(16);
/*  892 */       label9.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  893 */       group.addActor((Actor)label9);
/*      */       
/*      */       Label label10;
/*  896 */       (label10 = new Label(pP_Progress.getVideosWatchedForDoubleGain() + " / 500", Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 40.0F);
/*  897 */       label10.setPosition(474.0F, 111.0F);
/*  898 */       label10.setAlignment(16);
/*  899 */       group.addActor((Actor)label10);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  908 */       (quadActor3 = new QuadActor(Color.WHITE, new float[] { 5.0F, 0.0F, 0.0F, 40.0F, 584.0F, 40.0F, 589.0F, 0.0F })).setPosition(0.0F, 31.0F);
/*  909 */       quadActor3.setSize(589.0F, 40.0F);
/*  910 */       quadActor3.setVertexColorsSingle(new Color(606348543));
/*  911 */       group.addActor((Actor)quadActor3);
/*      */ 
/*      */       
/*  914 */       if ((f = pP_Progress.getVideosWatchedForLuckyShot() / 20.0F) > 1.0F) f = 1.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  921 */       (quadActor4 = new QuadActor(Color.WHITE, new float[] { 5.0F, 0.0F, 0.0F, 40.0F, 584.0F * f, 40.0F, 584.0F * f + 5.0F, 0.0F })).setPosition(0.0F, 31.0F);
/*  922 */       quadActor4.setSize(584.0F * f + 5.0F, 40.0F);
/*  923 */       quadActor4.setVertexColorsSingle(new Color(-1869573889));
/*  924 */       group.addActor((Actor)quadActor4);
/*      */ 
/*      */       
/*  927 */       (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("shop-ad-bar-reflection"))).setPosition(0.0F, 31.0F);
/*  928 */       image6.setSize(589.0F, 40.0F);
/*  929 */       group.addActor((Actor)image6);
/*      */ 
/*      */       
/*  932 */       (label9 = new Label(pP_Progress.getVideosWatchedForLuckyShot() + " / 20", Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 40.0F);
/*  933 */       label9.setPosition(476.0F, 29.0F);
/*  934 */       label9.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  935 */       label9.setAlignment(16);
/*  936 */       group.addActor((Actor)label9);
/*      */ 
/*      */       
/*  939 */       (label10 = new Label(pP_Progress.getVideosWatchedForLuckyShot() + " / 20", Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 40.0F);
/*  940 */       label10.setPosition(474.0F, 31.0F);
/*  941 */       label10.setAlignment(16);
/*  942 */       group.addActor((Actor)label10);
/*      */ 
/*      */ 
/*      */       
/*      */       QuadActor quadActor5;
/*      */ 
/*      */ 
/*      */       
/*  950 */       (quadActor5 = new QuadActor(Color.WHITE, new float[] { 0.0F, 1.0F, 25.0F, 190.0F, 31.0F, 189.0F, 6.0F, 0.0F })).setVertexColorsSingle(new Color(1.0F, 1.0F, 1.0F, 0.14F));
/*  951 */       quadActor5.setSize(31.0F, 190.0F);
/*  952 */       quadActor5.setPosition(864.0F, 0.0F);
/*  953 */       group.addActor((Actor)quadActor5);
/*      */ 
/*      */ 
/*      */       
/*  957 */       if (bool1) {
/*  958 */         image5 = new Image((Drawable)Game.i.assetManager.getDrawable("time-accelerator"));
/*      */       } else {
/*  960 */         image5 = new Image((Drawable)Game.i.assetManager.getDrawable("double-gain-shard"));
/*      */       } 
/*  962 */       image5.setPosition(622.0F, 99.0F);
/*  963 */       image5.setSize(64.0F, 64.0F);
/*  964 */       image5.setTouchable(Touchable.disabled);
/*  965 */       if (bool2) image5.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */       
/*  967 */       IssuedItems.IssueReason issueReason = bool1 ? IssuedItems.IssueReason.PREMIUM_REWARD_VIDEO : IssuedItems.IssueReason.REWARD_VIDEO;
/*      */       
/*  969 */       if (!bool2 && pP_Progress.getVideosWatchedForDoubleGain() >= 500) {
/*      */         QuadActor quadActor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  977 */         (quadActor = new QuadActor(Color.WHITE, new float[] { 8.0F, 0.0F, 0.0F, 76.0F, 253.0F, 74.0F, 244.0F, 2.0F })).setVertexColorsSingle(MaterialColor.GREEN.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F));
/*  978 */         quadActor.setPosition(609.0F, 92.0F);
/*  979 */         quadActor.setSize(253.0F, 76.0F);
/*  980 */         quadActor.addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.alpha(1.0F, 0.3F), (Action)Actions.alpha(0.78F, 0.3F))));
/*  981 */         quadActor.setTouchable(Touchable.enabled);
/*  982 */         group.addActor((Actor)quadActor);
/*      */         
/*      */         AttentionRaysUnderlay attentionRaysUnderlay;
/*  985 */         (attentionRaysUnderlay = new AttentionRaysUnderlay(96.0F, MaterialColor.AMBER.P300)).setPosition(606.0F, 83.0F);
/*  986 */         attentionRaysUnderlay.setSize(96.0F, 96.0F);
/*  987 */         attentionRaysUnderlay.setTouchable(Touchable.disabled);
/*  988 */         group.addActor((Actor)attentionRaysUnderlay);
/*      */         
/*  990 */         quadActor.addListener((EventListener)new ClickListener(this, pP_Progress, bool1, issueReason)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*      */               {
/*  994 */                 if (this.a.getVideosWatchedForDoubleGain() >= 500) {
/*  995 */                   boolean bool; DoubleGainShardItem doubleGainShardItem; this.a.setVideosWatchedForDoubleGain(this.a.getVideosWatchedForDoubleGain() - 500);
/*  996 */                   ProgressPrefs.i().requireSave();
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1001 */                   if (this.b) {
/* 1002 */                     AcceleratorItem acceleratorItem = Item.D.ACCELERATOR;
/* 1003 */                     bool = true;
/*      */                   } else {
/*      */                     
/* 1006 */                     (doubleGainShardItem = ((DoubleGainShardItem.DoubleGainShardItemFactory)Game.i.itemManager.getFactory(ItemType.DOUBLE_GAIN_SHARD)).create()).duration = 1209600;
/* 1007 */                     bool = true;
/*      */                   } 
/*      */                   
/* 1010 */                   Game.i.progressManager.addItems((Item)doubleGainShardItem, bool, "regular_ad_lots");
/*      */                   
/*      */                   IssuedItems issuedItems;
/* 1013 */                   (issuedItems = new IssuedItems(this.c, Game.getTimestampSeconds())).items.add(new ItemStack((Item)doubleGainShardItem, bool));
/* 1014 */                   Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/* 1015 */                   Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 } 
/*      */                 
/* 1018 */                 MoneyScreen.a(this.d);
/*      */               }
/*      */             });
/*      */       } 
/* 1022 */       group.addActor((Actor)image5);
/*      */ 
/*      */       
/* 1025 */       if (bool1) {
/* 1026 */         str = Game.i.localeManager.i18n.get("item_title_ACCELERATOR");
/* 1027 */         str = str + "\nx200";
/*      */       } else {
/* 1029 */         str = Game.i.localeManager.i18n.get("double_gain_title");
/* 1030 */         str = str + "\n" + Game.i.localeManager.i18n.format("n_weeks", new Object[] { Integer.valueOf(2) });
/*      */       } 
/*      */       Label label11;
/* 1033 */       (label11 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setSize(160.0F, 64.0F);
/* 1034 */       label11.setPosition(702.0F, 99.0F);
/* 1035 */       label11.setColor(MaterialColor.AMBER.P500);
/* 1036 */       label11.setTouchable(Touchable.disabled);
/* 1037 */       if (bool2) label11.setColor(label11.getColor().mul(1.0F, 1.0F, 1.0F, 0.28F)); 
/* 1038 */       group.addActor((Actor)label11);
/*      */       
/*      */       Image image5;
/*      */       
/* 1042 */       (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-shot-token"))).setPosition(622.0F, 19.0F);
/* 1043 */       image5.setSize(64.0F, 64.0F);
/* 1044 */       image5.setTouchable(Touchable.disabled);
/* 1045 */       if (bool2) image5.setColor(1.0F, 1.0F, 1.0F, 0.28F); 
/* 1046 */       if (!bool2 && pP_Progress.getVideosWatchedForLuckyShot() >= 20) {
/*      */         QuadActor quadActor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1054 */         (quadActor = new QuadActor(Color.WHITE, new float[] { 8.0F, 0.0F, 0.0F, 76.0F, 253.0F, 74.0F, 244.0F, 2.0F })).setVertexColorsSingle(MaterialColor.GREEN.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F));
/* 1055 */         quadActor.setPosition(609.0F, 12.0F);
/* 1056 */         quadActor.setSize(253.0F, 76.0F);
/* 1057 */         quadActor.addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.alpha(1.0F, 0.3F), (Action)Actions.alpha(0.78F, 0.3F))));
/* 1058 */         quadActor.setTouchable(Touchable.enabled);
/* 1059 */         group.addActor((Actor)quadActor);
/*      */         
/*      */         AttentionRaysUnderlay attentionRaysUnderlay;
/* 1062 */         (attentionRaysUnderlay = new AttentionRaysUnderlay(96.0F, MaterialColor.GREY.P300)).setPosition(606.0F, 3.0F);
/* 1063 */         attentionRaysUnderlay.setSize(96.0F, 96.0F);
/* 1064 */         attentionRaysUnderlay.setTouchable(Touchable.disabled);
/* 1065 */         group.addActor((Actor)attentionRaysUnderlay);
/*      */         
/* 1067 */         quadActor.addListener((EventListener)new ClickListener(this, pP_Progress, bool1, issueReason)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*      */               {
/* 1071 */                 if (this.a.getVideosWatchedForLuckyShot() >= 20) {
/* 1072 */                   this.a.setVideosWatchedForLuckyShot(this.a.getVideosWatchedForLuckyShot() - 20);
/* 1073 */                   ProgressPrefs.i().requireSave();
/*      */ 
/*      */                   
/* 1076 */                   byte b = 2;
/* 1077 */                   if (this.b) {
/* 1078 */                     b = 5;
/*      */                   }
/*      */                   
/* 1081 */                   Game.i.progressManager.addItems((Item)Item.D.LUCKY_SHOT_TOKEN, b, "regular_ad_many");
/*      */                   
/*      */                   IssuedItems issuedItems;
/* 1084 */                   (issuedItems = new IssuedItems(this.c, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.LUCKY_SHOT_TOKEN, b));
/* 1085 */                   Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/* 1086 */                   Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 } 
/*      */                 
/* 1089 */                 MoneyScreen.a(this.d);
/*      */               }
/*      */             });
/*      */       } 
/* 1093 */       group.addActor((Actor)image5);
/*      */       
/* 1095 */       String str = Game.i.localeManager.i18n.get("lucky_shot");
/* 1096 */       if (bool1) {
/* 1097 */         str = str + "\nx5";
/*      */       } else {
/* 1099 */         str = str + "\nx2";
/*      */       } 
/*      */       
/* 1102 */       (label11 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setSize(160.0F, 64.0F);
/* 1103 */       label11.setPosition(702.0F, 19.0F);
/* 1104 */       label11.setColor(new Color(-656877313));
/* 1105 */       label11.setTouchable(Touchable.disabled);
/* 1106 */       if (bool2) label11.setColor(label11.getColor().mul(1.0F, 1.0F, 1.0F, 0.28F)); 
/* 1107 */       group.addActor((Actor)label11);
/*      */ 
/*      */ 
/*      */       
/* 1111 */       (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("time-accelerator"))).setPosition(913.0F, 99.0F);
/* 1112 */       image5.setSize(64.0F, 64.0F);
/* 1113 */       image5.setTouchable(Touchable.disabled);
/* 1114 */       if (!bool2) image5.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */       
/* 1116 */       if (bool2 && pP_Progress.getVideosWatchedForDoubleGain() >= 500) {
/*      */         QuadActor quadActor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1124 */         (quadActor = new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 8.0F, 76.0F, 243.0F, 74.0F, 253.0F, 2.0F })).setVertexColorsSingle(MaterialColor.GREEN.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F));
/* 1125 */         quadActor.setPosition(901.0F, 92.0F);
/* 1126 */         quadActor.setSize(253.0F, 76.0F);
/* 1127 */         quadActor.addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.alpha(1.0F, 0.3F), (Action)Actions.alpha(0.78F, 0.3F))));
/* 1128 */         quadActor.setTouchable(Touchable.enabled);
/* 1129 */         group.addActor((Actor)quadActor);
/*      */         
/*      */         AttentionRaysUnderlay attentionRaysUnderlay;
/* 1132 */         (attentionRaysUnderlay = new AttentionRaysUnderlay(96.0F, MaterialColor.AMBER.P300)).setPosition(897.0F, 83.0F);
/* 1133 */         attentionRaysUnderlay.setSize(96.0F, 96.0F);
/* 1134 */         attentionRaysUnderlay.setTouchable(Touchable.disabled);
/* 1135 */         group.addActor((Actor)attentionRaysUnderlay);
/*      */         
/* 1137 */         quadActor.addListener((EventListener)new ClickListener(this, pP_Progress, bool1, issueReason)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*      */               {
/* 1141 */                 if (this.a.getVideosWatchedForDoubleGain() >= 500) {
/* 1142 */                   this.a.setVideosWatchedForDoubleGain(this.a.getVideosWatchedForDoubleGain() - 500);
/* 1143 */                   ProgressPrefs.i().requireSave();
/*      */ 
/*      */                   
/* 1146 */                   char c = 'È';
/* 1147 */                   if (this.b) {
/* 1148 */                     c = 'Ĭ';
/*      */                   }
/* 1150 */                   Game.i.progressManager.addItems((Item)Item.D.ACCELERATOR, c, "regular_ad_lots");
/*      */                   
/*      */                   IssuedItems issuedItems;
/* 1153 */                   (issuedItems = new IssuedItems(this.c, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.ACCELERATOR, c));
/* 1154 */                   Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/* 1155 */                   Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 } 
/*      */                 
/* 1158 */                 MoneyScreen.a(this.d);
/*      */               }
/*      */             });
/*      */       } 
/* 1162 */       group.addActor((Actor)image5);
/*      */       
/* 1164 */       str = Game.i.localeManager.i18n.get("item_title_ACCELERATOR");
/* 1165 */       if (bool1) {
/* 1166 */         str = str + "\nx300";
/*      */       } else {
/* 1168 */         str = str + "\nx200";
/*      */       } 
/*      */       
/* 1171 */       (label11 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setSize(160.0F, 64.0F);
/* 1172 */       label11.setPosition(993.0F, 99.0F);
/* 1173 */       label11.setColor(MaterialColor.AMBER.P500);
/* 1174 */       label11.setTouchable(Touchable.disabled);
/* 1175 */       if (!bool2) label11.setColor(label11.getColor().mul(1.0F, 1.0F, 1.0F, 0.28F)); 
/* 1176 */       group.addActor((Actor)label11);
/*      */ 
/*      */ 
/*      */       
/* 1180 */       (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-shot-token"))).setPosition(913.0F, 19.0F);
/* 1181 */       image5.setSize(64.0F, 64.0F);
/* 1182 */       image5.setTouchable(Touchable.disabled);
/* 1183 */       if (!bool2) image5.setColor(1.0F, 1.0F, 1.0F, 0.28F); 
/* 1184 */       if (bool2 && pP_Progress.getVideosWatchedForLuckyShot() >= 20) {
/*      */         QuadActor quadActor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1192 */         (quadActor = new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 8.0F, 76.0F, 243.0F, 74.0F, 253.0F, 2.0F })).setVertexColorsSingle(MaterialColor.GREEN.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F));
/* 1193 */         quadActor.setPosition(901.0F, 12.0F);
/* 1194 */         quadActor.setSize(253.0F, 76.0F);
/* 1195 */         quadActor.addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.alpha(1.0F, 0.3F), (Action)Actions.alpha(0.78F, 0.3F))));
/* 1196 */         quadActor.setTouchable(Touchable.enabled);
/* 1197 */         group.addActor((Actor)quadActor);
/*      */         
/*      */         AttentionRaysUnderlay attentionRaysUnderlay;
/* 1200 */         (attentionRaysUnderlay = new AttentionRaysUnderlay(96.0F, MaterialColor.GREY.P300)).setPosition(897.0F, 3.0F);
/* 1201 */         attentionRaysUnderlay.setSize(96.0F, 96.0F);
/* 1202 */         attentionRaysUnderlay.setTouchable(Touchable.disabled);
/* 1203 */         group.addActor((Actor)attentionRaysUnderlay);
/*      */         
/* 1205 */         quadActor.addListener((EventListener)new ClickListener(this, pP_Progress, bool1, issueReason)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*      */               {
/* 1209 */                 if (this.a.getVideosWatchedForLuckyShot() >= 20) {
/* 1210 */                   this.a.setVideosWatchedForLuckyShot(this.a.getVideosWatchedForLuckyShot() - 20);
/* 1211 */                   ProgressPrefs.i().requireSave();
/*      */ 
/*      */                   
/* 1214 */                   byte b = 5;
/* 1215 */                   if (this.b) {
/* 1216 */                     b = 7;
/*      */                   }
/* 1218 */                   Game.i.progressManager.addItems((Item)Item.D.LUCKY_SHOT_TOKEN, b, "regular_ad_many");
/*      */                   
/*      */                   IssuedItems issuedItems;
/* 1221 */                   (issuedItems = new IssuedItems(this.c, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.LUCKY_SHOT_TOKEN, b));
/* 1222 */                   Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/* 1223 */                   Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 } 
/*      */                 
/* 1226 */                 MoneyScreen.a(this.d);
/*      */               }
/*      */             });
/*      */       } 
/* 1230 */       group.addActor((Actor)image5);
/*      */       
/* 1232 */       str = Game.i.localeManager.i18n.get("lucky_shot");
/* 1233 */       if (bool1) {
/* 1234 */         str = str + "\nx7";
/*      */       } else {
/* 1236 */         str = str + "\nx5";
/*      */       } 
/*      */       
/* 1239 */       (label11 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setSize(160.0F, 64.0F);
/* 1240 */       label11.setPosition(993.0F, 19.0F);
/* 1241 */       label11.setColor(new Color(-656877313));
/* 1242 */       label11.setTouchable(Touchable.disabled);
/* 1243 */       if (!bool2) label11.setColor(label11.getColor().mul(1.0F, 1.0F, 1.0F, 0.28F)); 
/* 1244 */       group.addActor((Actor)label11);
/*      */       
/* 1246 */       table2.add((Actor)group).size(1200.0F, 309.0F).padTop(45.0F).colspan(2).row();
/*      */     } else {
/* 1248 */       table2.row();
/* 1249 */       table2.add().size(1.0F, 20.0F).row();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1305 */     table2.add().width(1.0F).height(32.0F).row();
/*      */ 
/*      */     
/* 1308 */     byte b1 = 0; CaseType[] arrayOfCaseType; byte b2;
/* 1309 */     for (arrayOfCaseType = new CaseType[] { CaseType.BLUE, CaseType.PURPLE, CaseType.ORANGE, CaseType.CYAN }, b2 = 0; b2 < 4; ) { CaseType caseType = arrayOfCaseType[b2];
/* 1310 */       CaseItem caseItem = Item.D.F_CASE.create(caseType, false);
/*      */       
/* 1312 */       Group group5 = a((!b1 || b1 == 3), caseItem.getIconDrawable());
/*      */       
/*      */       Label label7;
/* 1315 */       (label7 = new Label(caseItem.getTitle(), Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 23.0F);
/* 1316 */       label7.setPosition(158.0F, 112.0F);
/* 1317 */       label7.setColor(Game.i.progressManager.getRarityBrightColor(caseItem.getRarity()));
/* 1318 */       group5.addActor((Actor)label7);
/*      */       
/*      */       Group group6;
/* 1321 */       (group6 = new Group()).setTransform(false);
/* 1322 */       group6.setPosition(158.0F, 46.0F);
/* 1323 */       group6.setSize(1.0F, 1.0F);
/* 1324 */       group5.addActor((Actor)group6);
/*      */       
/* 1326 */       int[] arrayOfInt = caseItem.getItemRarityChances();
/* 1327 */       byte b3 = 0; RarityType[] arrayOfRarityType; int j; byte b4;
/* 1328 */       for (j = (arrayOfRarityType = RarityType.values).length, b4 = 0; b4 < j; ) { RarityType rarityType = arrayOfRarityType[b4];
/* 1329 */         if (arrayOfInt[rarityType.ordinal()] > 0) {
/* 1330 */           float f3 = b3 * 46.0F;
/*      */           
/*      */           Label label;
/* 1333 */           (label = new Label(arrayOfInt[rarityType.ordinal()], Game.i.assetManager.getLabelStyle(21))).setPosition(f3, 39.0F);
/* 1334 */           label.setSize(32.0F, 16.0F);
/* 1335 */           label.setColor(Game.i.progressManager.getRarityBrightColor(rarityType));
/* 1336 */           label.setAlignment(1);
/* 1337 */           group6.addActor((Actor)label);
/*      */           
/*      */           Image image;
/* 1340 */           (image = new Image(Game.i.uiManager.getItemCellRarityCoat(rarityType, b3 % 2))).setPosition(f3, 0.0F);
/* 1341 */           image.setSize(32.0F, 36.0F);
/* 1342 */           group6.addActor((Actor)image);
/*      */           
/* 1344 */           b3++;
/*      */         } 
/*      */         b4++; }
/*      */       
/* 1348 */       float f = b3 * 46.0F;
/*      */       Label label8;
/* 1350 */       (label8 = new Label("%", Game.i.assetManager.getLabelStyle(21))).setPosition(f, 39.0F);
/* 1351 */       label8.setSize(32.0F, 16.0F);
/* 1352 */       group6.addActor((Actor)label8);
/*      */       
/*      */       Label label9;
/* 1355 */       (label9 = new Label("x" + caseItem.getItemCount(), Game.i.assetManager.getLabelStyle(21))).setPosition(f, 0.0F);
/* 1356 */       label9.setSize(32.0F, 36.0F);
/* 1357 */       group6.addActor((Actor)label9);
/*      */       
/* 1359 */       if (caseItem.getGuaranteedItemType() != null) {
/*      */         Label label;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1366 */         (label = new Label(Game.i.localeManager.i18n.get("guaranteed") + ": [#" + Game.i.progressManager.getRarityBrightColor(caseItem.getGuaranteedItemType()).toString() + "]" + Game.i.progressManager.getRarityName(caseItem.getGuaranteedItemType()) + "[] x1", Game.i.assetManager.getLabelStyle(21))).setPosition(158.0F, 22.0F);
/* 1367 */         label.setSize(100.0F, 16.0F);
/* 1368 */         group5.addActor((Actor)label);
/*      */       } 
/*      */       
/*      */       int k;
/*      */       
/* 1373 */       if ((k = caseItem.getCasePriceInKeys()) > 0) {
/* 1374 */         CaseKeyItem caseKeyItem = Item.D.F_CASE_KEY.create(caseType);
/* 1375 */         int n = Game.i.progressManager.getItemsCount((Item)caseKeyItem);
/*      */         
/* 1377 */         Runnable runnable = null;
/*      */         int m;
/* 1379 */         if ((m = n / k) > 0) {
/* 1380 */           runnable = (() -> {
/*      */               int i = Math.min(200, paramInt1 / paramInt2);
/*      */               
/*      */               Label label = new Label("", Game.i.assetManager.getLabelStyle(30));
/*      */               
/*      */               ItemCountSelectionOverlay.ItemCountSelectionListener itemCountSelectionListener = new ItemCountSelectionOverlay.ItemCountSelectionListener(this, label, paramInt2, paramInt1, paramCaseKeyItem, paramCaseItem, paramCaseType)
/*      */                 {
/*      */                   public void countChanged(int param1Int)
/*      */                   {
/* 1389 */                     this.a.setText(
/* 1390 */                         StringFormatter.commaSeparatedNumber(this.b * ItemCountSelectionOverlay.i().getSelectedCount()) + "[#AAAAAA] / " + 
/* 1391 */                         StringFormatter.commaSeparatedNumber(this.c) + "[]");
/*      */                   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   public void selectionConfirmed(int param1Int) {
/*      */                     boolean bool;
/* 1401 */                     if (bool = Game.i.progressManager.removeItems((Item)this.d, this.e.getCasePriceInKeys() * param1Int)) {
/* 1402 */                       Game.i.progressManager.addItems((Item)this.e, param1Int, "case_purchase_keys");
/*      */                       
/*      */                       IssuedItems issuedItems;
/* 1405 */                       (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)this.e, param1Int));
/* 1406 */                       Game.i.progressManager.addIssuedPrizes(issuedItems, false);
/* 1407 */                       Game.i.progressManager.openPack((Item)this.e, param1Int, true, false);
/*      */                       
/* 1409 */                       Game.i.analyticsManager.logCurrencySpent(this.f.name().toLowerCase(Locale.ENGLISH) + "_case", "case_key_" + this.f.name(), this.e.getCasePriceInKeys());
/* 1410 */                       MoneyScreen.a(this.g); return;
/*      */                     } 
/* 1412 */                     Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_items"));
/*      */                   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   public void selectionCanceled() {}
/*      */                 };
/*      */               ItemCountSelectionOverlay.i().show(Game.i.localeManager.i18n.get("shop_buy_chests"), 1, i, (Item)paramCaseItem, itemCountSelectionListener);
/*      */               Table table;
/*      */               (table = ItemCountSelectionOverlay.i().getInfoContainer()).clear();
/*      */               Actor actor = paramCaseKeyItem.generateIcon(48.0F, false);
/*      */               table.add(actor).size(48.0F).padRight(16.0F);
/*      */               table.add((Actor)label).size(400.0F).left().height(48.0F);
/*      */               table.add().expandX().fillX();
/*      */               ItemCountSelectionOverlay.i().setSelectedCount(i);
/*      */               itemCountSelectionListener.countChanged(i);
/*      */             });
/*      */         }
/*      */         ComplexButton complexButton1;
/* 1455 */         (complexButton1 = new ComplexButton(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-key> " + n + " / " + k), Game.i.assetManager.getLabelStyle(30), () -> { boolean bool; if (bool = Game.i.progressManager.removeItems((Item)paramCaseKeyItem, paramCaseItem.getCasePriceInKeys())) { Game.i.progressManager.addItems((Item)paramCaseItem, 1, "case_purchase_keys"); IssuedItems issuedItems; (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)paramCaseItem, 1)); Game.i.progressManager.addIssuedPrizes(issuedItems, false); Game.i.progressManager.openPack((Item)paramCaseItem, 1, true, false); Game.i.analyticsManager.logCurrencySpent(paramCaseType.name().toLowerCase(Locale.ENGLISH) + "_case", "case_key_" + paramCaseType.name(), paramCaseItem.getCasePriceInKeys()); a(); return; }  Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_items")); }runnable)).setName("spend_keys_" + caseKeyItem.caseType.name());
/* 1456 */         complexButton1.setIconLabelShadowEnabled(true);
/* 1457 */         complexButton1.setSize(162.0F, 78.0F);
/* 1458 */         complexButton1.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-money-screen-button-small-top"), 0.0F, 0.0F, 162.0F, 78.0F);
/* 1459 */         complexButton1.setBackgroundColors(MaterialColor.LIGHT_BLUE.P600, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P500, MaterialColor.GREY.P800);
/*      */         
/* 1461 */         if (n < k) {
/* 1462 */           complexButton1.setEnabled(false);
/*      */         }
/*      */         
/*      */         Image image;
/* 1466 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-money-screen-button-small-top-edge"))).setSize(162.0F, 78.0F);
/* 1467 */         complexButton1.addActor((Actor)image);
/* 1468 */         complexButton1.setLabel(5.0F, 34.0F, 157.0F, 21.0F, 1);
/* 1469 */         complexButton1.setPosition(445.0F, 7.0F);
/* 1470 */         group5.addActor((Actor)complexButton1);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1601 */       Cell cell = table2.add((Actor)group5).size(590.0F, 166.0F).padBottom(20.0F);
/* 1602 */       if (b1 % 2 == 0) {
/* 1603 */         cell.padRight(20.0F);
/*      */       } else {
/* 1605 */         cell.row();
/*      */       } 
/*      */       
/* 1608 */       b1++;
/*      */       b2++; }
/*      */     
/* 1611 */     table2.row();
/* 1612 */     table2.add().height(46.0F).width(1.0F).row();
/*      */     
/*      */     Array array;
/*      */     
/* 1616 */     if ((array = Game.i.progressManager.getShopOffers()) != null && array.size != 0) {
/* 1617 */       int j; String str; table2.row();
/*      */       
/* 1619 */       Table table3 = new Table();
/* 1620 */       table2.add((Actor)table3).colspan(2).fillX().row();
/*      */       
/* 1622 */       Table table4 = new Table();
/* 1623 */       table3.add((Actor)table4).growX().row();
/*      */       
/*      */       Label label7;
/* 1626 */       (label7 = new Label(Game.i.localeManager.i18n.get("shop_title_item_market"), Game.i.assetManager.getLabelStyle(36))).setColor(MaterialColor.GREEN.P500);
/* 1627 */       table4.add((Actor)label7).growX();
/*      */ 
/*      */       
/*      */       int k;
/*      */       
/* 1632 */       if ((k = (ProgressPrefs.i()).progress.getPlayTimeUntilShopOffersUpdate()) < 600) {
/* 1633 */         j = 0;
/* 1634 */       } else if (k < 1200) {
/* 1635 */         j = 3;
/* 1636 */       } else if (k < 1800) {
/* 1637 */         j = 6;
/* 1638 */       } else if (k < 2400) {
/* 1639 */         j = 9;
/* 1640 */       } else if (k < 3000) {
/* 1641 */         j = 12;
/*      */       } else {
/* 1643 */         j = 15;
/*      */       } 
/* 1645 */       if ((ProgressPrefs.i()).progress.isCurrentShopOffersAreAfterSkip()) {
/* 1646 */         j = (int)(j * 1.7F);
/*      */       }
/*      */       
/* 1649 */       if (j == 0) {
/* 1650 */         str = Game.i.assetManager.replaceRegionAliasesWithChars(Game.i.localeManager.i18n.get("update_shop_offers_now_for_free")).toString();
/*      */       } else {
/* 1652 */         String str4 = Game.i.localeManager.i18n.format("update_shop_offers_now_for_accelerators", new Object[] { Integer.valueOf(j) });
/* 1653 */         str = Game.i.assetManager.replaceRegionAliasesWithChars(str4).toString();
/*      */       } 
/* 1655 */       int m = j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       LabelButton labelButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1675 */       (labelButton = new LabelButton(str, Game.i.assetManager.getLabelStyle(21), () -> { if (paramInt == 0) { Game.i.progressManager.generateNewShopOffers(); a(); return; }  String str = Game.i.localeManager.i18n.format("shop_offers_update_confirm", new Object[] { Integer.valueOf(paramInt) }); Dialog.i().showConfirm(Game.i.assetManager.replaceRegionAliasesWithChars(str), ()); })).setColor(1.0F, 1.0F, 1.0F, 0.78F);
/* 1676 */       labelButton.setColors(new Color(1.0F, 1.0F, 1.0F, 0.56F), Color.WHITE);
/* 1677 */       table4.add((Actor)labelButton).height(48.0F).padLeft(20.0F);
/*      */       
/* 1679 */       Table table5 = new Table();
/* 1680 */       table3.add((Actor)table5).growX().row();
/*      */       
/*      */       Label label8;
/* 1683 */       (label8 = new Label(Game.i.localeManager.i18n.get("shop_offers_subtitle"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 1684 */       table5.add((Actor)label8).growX();
/*      */       
/*      */       Label label9;
/* 1687 */       (label9 = new Label(Game.i.localeManager.i18n.get("shop_offers_next_update_in"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1688 */       table5.add((Actor)label9).padRight(8.0F);
/*      */       
/*      */       Label label10;
/* 1691 */       (label10 = new Label((CharSequence)StringFormatter.digestTimeWithZeroHours((ProgressPrefs.i()).progress.getPlayTimeUntilShopOffersUpdate(), true), Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.GREEN.P500);
/* 1692 */       table5.add((Actor)label10);
/*      */       
/* 1694 */       this.k = new Table();
/* 1695 */       this.k.setName("shop-offers-table");
/* 1696 */       table3.add((Actor)this.k).growX().padTop(20.0F).row();
/*      */ 
/*      */       
/* 1699 */       ObjectMap objectMap = new ObjectMap();
/* 1700 */       Array array1 = Game.i.researchManager.getInstances();
/* 1701 */       for (byte b = 0; b < array1.size; b++) {
/*      */         Research research;
/* 1703 */         if ((research = (Research)array1.get(b)).priceInStars == 0) {
/*      */           
/* 1705 */           Array array2 = research.getCumulativePrice(research.getInstalledLevel(), research.maxEndlessLevel, false);
/* 1706 */           for (bool1 = false; bool1 < array2.size; bool1++) {
/* 1707 */             ItemStack itemStack = (ItemStack)array2.get(bool1);
/*      */             
/* 1709 */             long l = (l = ((Long)objectMap.get(itemStack.getItem(), Long.valueOf(0L))).longValue()) + itemStack.getCount();
/* 1710 */             objectMap.put(itemStack.getItem(), Long.valueOf(l));
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1715 */       this.i.clear();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1721 */       for (b1 = 0; b1 < array.size; b1++) {
/* 1722 */         ProgressManager.ShopOffer shopOffer = (ProgressManager.ShopOffer)array.get(b1);
/*      */         
/* 1724 */         String str4 = "shop-offer-cell-" + b1;
/* 1725 */         byte b3 = b1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         TableButton tableButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1772 */         (tableButton = new TableButton(() -> { if (this.j != paramInt) { a(paramInt); return; }  if (!paramShopOffer.purchased) { if (Game.i.progressManager.removeItems(paramShopOffer.price.getItem(), paramShopOffer.price.getCount())) { Game.i.progressManager.addItemStack(paramShopOffer.item, "shop_offer"); IssuedItems issuedItems; (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack(paramShopOffer.item)); Game.i.progressManager.addIssuedPrizes(issuedItems, true); Game.i.statisticsManager.registerDelta(StatisticsType.SOP, 1.0D); paramShopOffer.purchased = true; ProgressPrefs.i().requireSave(); Game.i.actionResolver.logShopOfferPurchased(paramShopOffer.price.getItem().getAnalyticName(), paramShopOffer.price.getCount(), paramShopOffer.item.getItem().getAnalyticName(), paramShopOffer.item.getCount()); a(); Threads.i().postRunnable(()); a(-1); return; }  Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_items")); }  })).setName(str4);
/* 1773 */         this.i.add(tableButton);
/*      */         
/* 1775 */         tableButton.setBackgroundDrawables((Drawable)Game.i.assetManager
/* 1776 */             .getQuad((b1 % 2 == 0) ? "ui.shop.timedOffer.cellOdd" : "ui.shop.timedOffer.cellEven"), (Drawable)Game.i.assetManager
/* 1777 */             .getQuad((b1 % 2 == 0) ? "ui.shop.timedOffer.cellOddActive" : "ui.shop.timedOffer.cellEvenActive"), (Drawable)Game.i.assetManager
/* 1778 */             .getQuad((b1 % 2 == 0) ? "ui.shop.timedOffer.cellOddHover" : "ui.shop.timedOffer.cellEvenHover"), (Drawable)Game.i.assetManager
/* 1779 */             .getQuad((b1 % 2 == 0) ? "ui.shop.timedOffer.cellOddDisabled" : "ui.shop.timedOffer.cellEvenDisabled"));
/*      */         
/* 1781 */         tableButton.clickableWhenDisabled = true;
/*      */         
/*      */         Image image;
/* 1784 */         (image = new Image((Drawable)Game.i.assetManager.getQuad((b1 % 2 == 0) ? "ui.shop.timedOffer.selectionOdd" : "ui.shop.timedOffer.selectionEven"))).setSize(185.0F, 224.0F);
/* 1785 */         image.setTouchable(Touchable.disabled);
/* 1786 */         image.setName("shop-offer-cell-selection-" + b1);
/* 1787 */         image.setVisible(false);
/* 1788 */         tableButton.addActor((Actor)image);
/*      */         
/*      */         boolean bool2;
/* 1791 */         if (bool2 = (Game.i.progressManager.getItemsCount(shopOffer.price.getItem()) < shopOffer.price.getCount()) ? true : false) {
/*      */           Image image5;
/* 1793 */           (image5 = new Image((Drawable)Game.i.assetManager.getQuad((b1 % 2 == 0) ? "ui.shop.timedOffer.notEnoughItemsOverlayOdd" : "ui.shop.timedOffer.notEnoughItemsOverlayEven"))).setSize(185.0F, 224.0F);
/* 1794 */           tableButton.addActor((Actor)image5);
/*      */         } 
/*      */         
/*      */         Actor actor1;
/* 1798 */         (actor1 = shopOffer.item.getItem().generateIcon(96.0F, true)).setPosition(44.5F, 112.0F);
/* 1799 */         tableButton.addActor(actor1);
/*      */ 
/*      */         
/* 1802 */         (label7 = new Label("x" + StringFormatter.commaSeparatedNumber(shopOffer.item.getCount()), Game.i.assetManager.getLabelStyle(30))).setAlignment(1);
/* 1803 */         label7.setPosition(0.0F, 80.0F);
/* 1804 */         label7.setSize(185.0F, 24.0F);
/* 1805 */         tableButton.addActor((Actor)label7);
/*      */         
/*      */         Table table;
/* 1808 */         (table = new Table()).setWidth(185.0F);
/* 1809 */         table.setHeight(64.0F);
/* 1810 */         tableButton.addActor((Actor)table);
/*      */ 
/*      */ 
/*      */         
/* 1814 */         Actor actor2 = shopOffer.price.getItem().generateIcon(32.0F, false);
/* 1815 */         table.add(actor2).size(32.0F).padRight(8.0F);
/*      */         
/* 1817 */         Label label = new Label(StringFormatter.compactNumber(shopOffer.price.getCount(), false).toString(), Game.i.assetManager.getLabelStyle(24));
/* 1818 */         table.add((Actor)label);
/*      */         
/* 1820 */         if (bool2) {
/* 1821 */           label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */         }
/*      */         
/* 1824 */         if (shopOffer.purchased) {
/* 1825 */           tableButton.setEnabled(false);
/*      */           
/*      */           Image image5;
/* 1828 */           (image5 = new Image((Drawable)Game.i.assetManager.getQuad("ui.shop.timedOffer.soldOutOverlay"))).setSize(185.0F, 224.0F);
/* 1829 */           tableButton.addActor((Actor)image5);
/*      */           
/*      */           Label label11;
/* 1832 */           (label11 = new Label("Sold out", Game.i.assetManager.getLabelStyle(21))).setPosition(0.0F, 136.0F);
/* 1833 */           label11.setSize(185.0F, 14.0F);
/* 1834 */           label11.setAlignment(1);
/* 1835 */           tableButton.addActor((Actor)label11);
/*      */           
/* 1837 */           label7.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1838 */           actor1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1839 */           actor2.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1840 */           label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1901 */         if (shopOffer.discountPercent > 0) {
/*      */           Label label11;
/* 1903 */           (label11 = new Label("-" + shopOffer.discountPercent + "%", Game.i.assetManager.getLabelStyle(18))).setPosition(0.0F, 35.0F);
/* 1904 */           label11.setWidth(177.0F);
/* 1905 */           label11.setHeight(24.0F);
/* 1906 */           label11.setAlignment(16);
/* 1907 */           label11.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 1908 */           tableButton.addActor((Actor)label11);
/*      */         } 
/*      */         
/* 1911 */         Cell cell = this.k.add((Actor)tableButton).size(185.0F, 224.0F).padBottom(20.0F);
/* 1912 */         if (b1 % 6 == 5) {
/* 1913 */           cell.row();
/*      */         } else {
/* 1915 */           cell.padRight(18.0F);
/*      */         } 
/*      */       } 
/*      */       
/* 1919 */       table2.row();
/* 1920 */       table2.add().height(46.0F).width(1.0F).row();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1944 */     boolean bool = false;
/* 1945 */     for (Array.ArrayIterator<PaperPackConfig> arrayIterator = this.s.iterator(); arrayIterator.hasNext(); ) { PaperPackConfig paperPackConfig = arrayIterator.next();
/*      */       try {
/*      */         Information information;
/* 1948 */         if ((information = Game.i.purchaseManager.purchaseManager.getInformation(paperPackConfig.a)) != Information.UNAVAILABLE) {
/* 1949 */           bool = true;
/*      */           break;
/*      */         } 
/* 1952 */       } catch (Throwable throwable) {} }
/*      */ 
/*      */     
/* 1955 */     if (bool && Game.i.purchaseManager.isPurchasesEnabled() && ("true"
/*      */       
/* 1957 */       .equals(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_GREEN_PAPER_ENABLED)) || "true"
/* 1958 */       .equals(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_ACCELERATOR_ENABLED)))) {
/*      */       Label label7;
/*      */ 
/*      */       
/* 1962 */       (label7 = new Label(Game.i.localeManager.i18n.get("shop_iap_category_title"), Game.i.assetManager.getLabelStyle(36))).setColor(MaterialColor.GREEN.P500);
/* 1963 */       table2.add((Actor)label7).fillX().colspan(2).row();
/*      */       
/*      */       Label label8;
/* 1966 */       (label8 = new Label(Game.i.localeManager.i18n.get("shop_iap_category_subtitle"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 1967 */       label8.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1968 */       table2.add((Actor)label8).fillX().padBottom(20.0F).colspan(2).row();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1973 */     if (bool && Game.i.purchaseManager.isPurchasesEnabled() && "true".equals(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_GREEN_PAPER_ENABLED))) {
/*      */       
/* 1975 */       byte b = 0;
/* 1976 */       for (Array.ArrayIterator<PaperPackConfig> arrayIterator1 = this.s.iterator(); arrayIterator1.hasNext(); ) { PaperPackConfig paperPackConfig = arrayIterator1.next();
/* 1977 */         if (Game.i.progressManager.getGreenPapers() + paperPackConfig.c + paperPackConfig.d <= 999999999) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1982 */           Information information = null;
/*      */           try {
/* 1984 */             information = Game.i.purchaseManager.purchaseManager.getInformation(paperPackConfig.a);
/* 1985 */           } catch (Exception exception) {
/* 1986 */             a.w("failed to get IAP info %s", new Object[] { paperPackConfig.a, exception });
/*      */           } 
/*      */           
/* 1989 */           if (information != null && information != Information.UNAVAILABLE) {
/*      */ 
/*      */ 
/*      */             
/* 1993 */             Group group = a((!b || b == 3 || b == 4), (Drawable)Game.i.assetManager.getDrawable(paperPackConfig.b));
/*      */             
/*      */             Image image5;
/* 1996 */             (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-a-shape"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 1997 */             image5.setSize(96.0F, 106.0F);
/* 1998 */             image5.setPosition(156.0F, 29.0F);
/* 1999 */             group.addActor((Actor)image5);
/*      */             
/*      */             Image image6;
/* 2002 */             (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"))).setColor(MaterialColor.GREEN.P500);
/* 2003 */             image6.setSize(64.0F, 64.0F);
/* 2004 */             image6.setPosition(172.0F, 63.0F);
/* 2005 */             group.addActor((Actor)image6);
/*      */             
/*      */             Label label;
/* 2008 */             (label = new Label((CharSequence)StringFormatter.compactNumber(paperPackConfig.c, false), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 2009 */             label.setPosition(156.0F, 44.0F);
/* 2010 */             label.setSize(96.0F, 16.0F);
/* 2011 */             group.addActor((Actor)label);
/*      */             
/* 2013 */             if (paperPackConfig.e > 0) {
/*      */               
/* 2015 */               (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-b-shape"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 2016 */               image5.setSize(96.0F, 106.0F);
/* 2017 */               image5.setPosition(252.0F, 29.0F);
/* 2018 */               group.addActor((Actor)image5);
/*      */ 
/*      */               
/* 2021 */               (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"))).setColor(MaterialColor.GREEN.P500);
/* 2022 */               image6.setSize(64.0F, 64.0F);
/* 2023 */               image6.setPosition(268.0F, 63.0F);
/* 2024 */               group.addActor((Actor)image6);
/*      */ 
/*      */               
/* 2027 */               (label = new Label((CharSequence)StringFormatter.compactNumber(paperPackConfig.d, false), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 2028 */               label.setColor(MaterialColor.AMBER.P400);
/* 2029 */               label.setPosition(252.0F, 44.0F);
/* 2030 */               label.setSize(96.0F, 16.0F);
/* 2031 */               group.addActor((Actor)label);
/*      */               
/*      */               Image image;
/* 2034 */               (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-plus"))).setColor(MaterialColor.AMBER.P400);
/* 2035 */               image.setSize(24.0F, 24.0F);
/* 2036 */               image.setPosition(241.0F, 72.0F);
/* 2037 */               group.addActor((Actor)image);
/*      */               
/* 2039 */               if (paperPackConfig.g != null) {
/*      */                 Group group5;
/* 2041 */                 (group5 = new Group()).setTransform(false);
/* 2042 */                 group5.setSize(96.0F, 106.0F);
/* 2043 */                 group5.setPosition(348.0F, 29.0F);
/* 2044 */                 group.addActor((Actor)group5);
/*      */                 
/* 2046 */                 group5.setTouchable(Touchable.enabled);
/* 2047 */                 group5.addListener((EventListener)new ClickListener(this, paperPackConfig)
/*      */                     {
/*      */                       public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 2050 */                         ItemDescriptionDialog.i().show(this.a.g.getItem());
/*      */                       }
/*      */                     });
/*      */ 
/*      */                 
/* 2055 */                 (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-a-shape"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 2056 */                 image5.setSize(96.0F, 106.0F);
/* 2057 */                 group5.addActor((Actor)image5);
/*      */                 
/*      */                 Actor actor;
/* 2060 */                 (actor = paperPackConfig.g.getItem().generateIcon(64.0F, false)).setSize(64.0F, 64.0F);
/* 2061 */                 actor.setPosition(16.0F, 34.0F);
/* 2062 */                 group5.addActor(actor);
/*      */ 
/*      */                 
/* 2065 */                 (label = new Label((CharSequence)StringFormatter.commaSeparatedNumber(paperPackConfig.g.getCount()), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 2066 */                 label.setColor(MaterialColor.AMBER.P400);
/* 2067 */                 label.setPosition(0.0F, 15.0F);
/* 2068 */                 label.setSize(96.0F, 16.0F);
/* 2069 */                 group5.addActor((Actor)label);
/*      */ 
/*      */                 
/* 2072 */                 (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-plus"))).setTouchable(Touchable.disabled);
/* 2073 */                 image.setColor(MaterialColor.AMBER.P400);
/* 2074 */                 image.setSize(24.0F, 24.0F);
/* 2075 */                 image.setPosition(337.0F, 72.0F);
/* 2076 */                 group.addActor((Actor)image);
/*      */               } 
/*      */               
/*      */               Label label7;
/* 2080 */               (label7 = new Label("+" + paperPackConfig.e + "%", Game.i.assetManager.getLabelStyle(paperPackConfig.f))).setColor(MaterialColor.AMBER.P400);
/* 2081 */               label7.setSize(82.0F, 24.0F);
/* 2082 */               label7.setAlignment(16);
/* 2083 */               label7.setPosition(490.0F, 117.0F);
/* 2084 */               group.addActor((Actor)label7);
/*      */             } 
/*      */             
/* 2087 */             ComplexButton complexButton1 = a(information.getLocalPricing(), () -> a(paramPaperPackConfig.a));
/* 2088 */             group.addActor((Actor)complexButton1);
/*      */             
/* 2090 */             Cell cell = table2.add((Actor)group).size(590.0F, 166.0F).padBottom(20.0F);
/* 2091 */             if (b % 2 == 0) {
/* 2092 */               cell.padRight(20.0F);
/*      */             } else {
/* 2094 */               cell.row();
/*      */             } 
/*      */             
/* 2097 */             b++;
/*      */           } 
/*      */         }  }
/* 2100 */        table2.row();
/* 2101 */       table2.add().height(46.0F).width(1.0F).row();
/*      */     } else {
/* 2103 */       table2.row();
/* 2104 */       table2.add().height(192.0F).width(1.0F).row();
/*      */     } 
/*      */ 
/*      */     
/* 2108 */     if (Game.i.purchaseManager.isPurchasesEnabled() && Game.i.progressManager.getAccelerators() < 100000000 && "true".equals(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_ACCELERATOR_ENABLED))) {
/*      */       
/* 2110 */       byte b = 0;
/* 2111 */       for (Array.ArrayIterator<AcceleratorPackConfig> arrayIterator1 = this.t.iterator(); arrayIterator1.hasNext(); ) { AcceleratorPackConfig acceleratorPackConfig = arrayIterator1.next();
/* 2112 */         Information information = null;
/*      */         try {
/* 2114 */           information = Game.i.purchaseManager.purchaseManager.getInformation(acceleratorPackConfig.a);
/* 2115 */         } catch (Exception exception) {
/* 2116 */           a.w("failed to get IAP info %s", new Object[] { acceleratorPackConfig.a, exception });
/*      */         } 
/* 2118 */         if (information != null && information != Information.UNAVAILABLE) {
/*      */ 
/*      */ 
/*      */           
/* 2122 */           Group group = a((!b || b == 3 || b == 4), (Drawable)Game.i.assetManager.getDrawable(acceleratorPackConfig.b));
/*      */           
/*      */           Image image5;
/* 2125 */           (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-a-shape"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 2126 */           image5.setSize(96.0F, 106.0F);
/* 2127 */           image5.setPosition(156.0F, 29.0F);
/* 2128 */           group.addActor((Actor)image5);
/*      */           
/*      */           Image image6;
/* 2131 */           (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("time-accelerator"))).setSize(64.0F, 64.0F);
/* 2132 */           image6.setPosition(172.0F, 63.0F);
/* 2133 */           group.addActor((Actor)image6);
/*      */           
/*      */           Label label;
/* 2136 */           (label = new Label((CharSequence)StringFormatter.commaSeparatedNumber(acceleratorPackConfig.c), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 2137 */           label.setPosition(156.0F, 44.0F);
/* 2138 */           label.setSize(96.0F, 16.0F);
/* 2139 */           group.addActor((Actor)label);
/*      */           
/* 2141 */           if (acceleratorPackConfig.e > 0) {
/*      */             
/* 2143 */             (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-b-shape"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 2144 */             image5.setSize(96.0F, 106.0F);
/* 2145 */             image5.setPosition(252.0F, 29.0F);
/* 2146 */             group.addActor((Actor)image5);
/*      */ 
/*      */             
/* 2149 */             (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("time-accelerator"))).setSize(64.0F, 64.0F);
/* 2150 */             image6.setPosition(268.0F, 63.0F);
/* 2151 */             group.addActor((Actor)image6);
/*      */ 
/*      */             
/* 2154 */             (label = new Label((CharSequence)StringFormatter.commaSeparatedNumber(acceleratorPackConfig.d), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 2155 */             label.setColor(MaterialColor.AMBER.P400);
/* 2156 */             label.setPosition(252.0F, 44.0F);
/* 2157 */             label.setSize(96.0F, 16.0F);
/* 2158 */             group.addActor((Actor)label);
/*      */             
/*      */             Image image;
/* 2161 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-plus"))).setColor(MaterialColor.AMBER.P400);
/* 2162 */             image.setSize(24.0F, 24.0F);
/* 2163 */             image.setPosition(241.0F, 72.0F);
/* 2164 */             group.addActor((Actor)image);
/*      */             
/* 2166 */             if (acceleratorPackConfig.g != null) {
/*      */               Group group5;
/* 2168 */               (group5 = new Group()).setTransform(false);
/* 2169 */               group5.setSize(96.0F, 106.0F);
/* 2170 */               group5.setPosition(348.0F, 29.0F);
/* 2171 */               group.addActor((Actor)group5);
/*      */               
/* 2173 */               group5.setTouchable(Touchable.enabled);
/* 2174 */               group5.addListener((EventListener)new ClickListener(this, acceleratorPackConfig)
/*      */                   {
/*      */                     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 2177 */                       ItemDescriptionDialog.i().show(this.a.g.getItem());
/*      */                     }
/*      */                   });
/*      */ 
/*      */               
/* 2182 */               (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-a-shape"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 2183 */               image5.setSize(96.0F, 106.0F);
/* 2184 */               group5.addActor((Actor)image5);
/*      */               
/*      */               Actor actor;
/* 2187 */               (actor = acceleratorPackConfig.g.getItem().generateIcon(64.0F, false)).setSize(64.0F, 64.0F);
/* 2188 */               actor.setPosition(16.0F, 34.0F);
/* 2189 */               group5.addActor(actor);
/*      */ 
/*      */               
/* 2192 */               (label = new Label((CharSequence)StringFormatter.commaSeparatedNumber(acceleratorPackConfig.g.getCount()), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 2193 */               label.setColor(MaterialColor.AMBER.P400);
/* 2194 */               label.setPosition(0.0F, 15.0F);
/* 2195 */               label.setSize(96.0F, 16.0F);
/* 2196 */               group5.addActor((Actor)label);
/*      */ 
/*      */               
/* 2199 */               (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-plus"))).setTouchable(Touchable.disabled);
/* 2200 */               image.setColor(MaterialColor.AMBER.P400);
/* 2201 */               image.setSize(24.0F, 24.0F);
/* 2202 */               image.setPosition(337.0F, 72.0F);
/* 2203 */               group.addActor((Actor)image);
/*      */             } 
/*      */             
/*      */             Label label7;
/* 2207 */             (label7 = new Label("+" + acceleratorPackConfig.e + "%", Game.i.assetManager.getLabelStyle(acceleratorPackConfig.f))).setColor(MaterialColor.AMBER.P400);
/* 2208 */             label7.setSize(82.0F, 24.0F);
/* 2209 */             label7.setAlignment(16);
/* 2210 */             label7.setPosition(490.0F, 117.0F);
/* 2211 */             group.addActor((Actor)label7);
/*      */           } 
/*      */           
/*      */           String str;
/*      */           
/* 2216 */           ComplexButton complexButton1 = a(str = information.getLocalPricing(), () -> a(paramAcceleratorPackConfig.a));
/* 2217 */           group.addActor((Actor)complexButton1);
/*      */           
/* 2219 */           Cell cell = table2.add((Actor)group).size(590.0F, 166.0F).padBottom(20.0F);
/* 2220 */           if (b % 2 == 0) {
/* 2221 */             cell.padRight(20.0F);
/*      */           } else {
/* 2223 */             cell.row();
/*      */           } 
/*      */           
/* 2226 */           b++;
/*      */         }  }
/*      */     
/*      */     } 
/*      */     
/* 2231 */     table2.row();
/* 2232 */     table2.add().height(160.0F).width(1.0F).row();
/*      */     
/* 2234 */     b();
/*      */     
/* 2236 */     scrollPane.layout();
/* 2237 */     scrollPane.setScrollY(f1);
/* 2238 */     scrollPane.updateVisualScroll();
/*      */ 
/*      */     
/* 2241 */     this.d.getTable().clear();
/* 2242 */     this.d.getTable().addListener((EventListener)new InputVoid());
/* 2243 */     this.d.getTable().background(Game.i.assetManager.getDrawable("blank").tint(Config.BACKGROUND_COLOR.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F)));
/*      */     
/*      */     Image image4;
/* 2246 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"))).setColor(MaterialColor.CYAN.P500);
/* 2247 */     image4.addAction((Action)Actions.forever(
/* 2248 */           (Action)Actions.sequence(
/* 2249 */             (Action)Actions.color(MaterialColor.CYAN.P500, 1.0F), 
/* 2250 */             (Action)Actions.color(MaterialColor.LIGHT_GREEN.P500, 1.0F), 
/* 2251 */             (Action)Actions.color(MaterialColor.ORANGE.P500, 1.0F), 
/* 2252 */             (Action)Actions.color(MaterialColor.PINK.P500, 1.0F), 
/* 2253 */             (Action)Actions.color(MaterialColor.PURPLE.P500, 1.0F))));
/*      */ 
/*      */     
/* 2256 */     image4.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 0.5F)));
/* 2257 */     image4.setOrigin(64.0F, 64.0F);
/*      */     
/* 2259 */     this.d.getTable().add((Actor)image4).size(128.0F);
/* 2260 */     this.d.getTable().setVisible(false);
/*      */   }
/*      */   
/*      */   private void a(int paramInt) {
/* 2264 */     this.j = paramInt;
/*      */ 
/*      */     
/* 2267 */     for (byte b = 0; b < this.i.size; b++) {
/*      */       Image image;
/* 2269 */       if ((image = (Image)this.k.findActor("shop-offer-cell-selection-" + b)) != null) {
/* 2270 */         if (b == paramInt) {
/*      */           
/* 2272 */           image.setVisible(true);
/*      */         } else {
/*      */           
/* 2275 */           image.setVisible(false);
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2281 */     String str = "shop-offer-summary";
/* 2282 */     if (paramInt == -1) {
/* 2283 */       TooltipsOverlay.i().hideEntry(str); return;
/*      */     } 
/* 2285 */     Table table = new Table();
/*      */     
/*      */     Array array;
/* 2288 */     if ((array = Game.i.progressManager.getShopOffers()) != null && array.size > paramInt) {
/* 2289 */       ProgressManager.ShopOffer shopOffer = (ProgressManager.ShopOffer)array.get(paramInt);
/*      */       
/*      */       Label label2;
/* 2292 */       (label2 = new Label(shopOffer.item.getItem().getTitle(), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 2293 */       label2.setAlignment(1);
/* 2294 */       table.add((Actor)label2).growX().row();
/*      */ 
/*      */       
/* 2297 */       (label2 = new Label(shopOffer.item.getItem().getDescription(), Game.i.assetManager.getLabelStyle(18))).setWrap(true);
/* 2298 */       label2.setAlignment(1);
/* 2299 */       label2.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 2300 */       table.add((Actor)label2).growX().maxWidth(500.0F).row();
/*      */       
/*      */       Image image;
/* 2303 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.36F);
/* 2304 */       table.add((Actor)image).growX().height(1.0F).padTop(10.0F).row();
/*      */ 
/*      */       
/* 2307 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.21F);
/* 2308 */       table.add((Actor)image).growX().height(1.0F).padBottom(10.0F).row();
/*      */       
/* 2310 */       if (shopOffer.purchased) {
/*      */         Label label;
/* 2312 */         (label = new Label(Game.i.localeManager.i18n.get("already_purchased"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 2313 */         table.add((Actor)label);
/*      */       }
/* 2315 */       else if (Game.i.progressManager.getItemsCount(shopOffer.price.getItem()) < shopOffer.price.getCount()) {
/*      */         Label label;
/* 2317 */         (label = new Label(Game.i.localeManager.i18n.get("not_enough_items"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.ORANGE.P500);
/* 2318 */         table.add((Actor)label);
/*      */       } else {
/*      */         Label label;
/* 2321 */         (label = new Label(Game.i.localeManager.i18n.get("click_offer_again_to_buy"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 2322 */         table.add((Actor)label);
/*      */       } 
/*      */       
/* 2325 */       table.row();
/*      */ 
/*      */       
/* 2328 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.36F);
/* 2329 */       table.add((Actor)image).growX().height(1.0F).padTop(10.0F).row();
/*      */ 
/*      */       
/* 2332 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.21F);
/* 2333 */       table.add((Actor)image).growX().height(1.0F).padBottom(10.0F).row();
/*      */ 
/*      */       
/* 2336 */       byte b1 = 0;
/* 2337 */       long l = 0L;
/* 2338 */       Array array1 = Game.i.researchManager.getInstances(); int i;
/* 2339 */       for (i = 0; i < array1.size; i++) {
/* 2340 */         Research research = (Research)array1.get(i);
/*      */         boolean bool;
/* 2342 */         if (!(bool = Game.i.researchManager.canStartResearching(research, false))) {
/* 2343 */           bool = false;
/* 2344 */           if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.EASY || Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL) {
/* 2345 */             if (!research.isMaxNormalLevel()) {
/* 2346 */               bool = true;
/*      */             
/*      */             }
/*      */           }
/* 2350 */           else if (!research.isMaxEndlessLevel()) {
/* 2351 */             bool = true;
/*      */           } 
/*      */           
/* 2354 */           if (bool) {
/*      */             
/* 2356 */             boolean bool1 = true;
/* 2357 */             if (research.priceInStars > 0) {
/*      */               
/* 2359 */               boolean bool2 = false;
/* 2360 */               for (bool = false; bool < research.linksToParents.size; bool++) {
/*      */                 Research.ResearchLink researchLink;
/* 2362 */                 if ((researchLink = (Research.ResearchLink)research.linksToParents.get(bool)).parent.getInstalledLevel() > 0) {
/* 2363 */                   bool2 = true;
/*      */                   break;
/*      */                 } 
/*      */               } 
/* 2367 */               for (bool = false; bool < research.linksToChildren.size; bool++) {
/*      */                 Research.ResearchLink researchLink;
/* 2369 */                 if ((researchLink = (Research.ResearchLink)research.linksToChildren.get(bool)).child.getInstalledLevel() > 0) {
/* 2370 */                   bool2 = true;
/*      */                   break;
/*      */                 } 
/*      */               } 
/* 2374 */               if (!bool2) {
/* 2375 */                 bool1 = false;
/*      */               }
/*      */               
/* 2378 */               if (Game.i.researchManager.getUnusedStarsCount() < research.priceInStars) {
/* 2379 */                 bool1 = false;
/*      */               }
/*      */             } else {
/*      */               
/* 2383 */               for (byte b2 = 0; b2 < research.linksToParents.size; b2++) {
/*      */                 Research.ResearchLink researchLink;
/* 2385 */                 if ((researchLink = (Research.ResearchLink)research.linksToParents.get(b2)).requiredLevels > researchLink.parent.getInstalledLevel()) {
/*      */                   
/* 2387 */                   bool1 = false;
/*      */                   
/*      */                   break;
/*      */                 } 
/*      */               } 
/*      */             } 
/* 2393 */             if (bool1) {
/*      */               Array array2;
/*      */ 
/*      */               
/* 2397 */               if (research.levels.length > research.getInstalledLevel()) {
/*      */                 
/* 2399 */                 array2 = (research.levels[research.getInstalledLevel()]).price;
/*      */               } else {
/*      */                 
/* 2402 */                 array2 = research.endlessLevel.getPrice(research.getInstalledLevel() + 1);
/*      */               } 
/*      */               
/* 2405 */               for (bool = false; bool < array2.size; bool++) {
/*      */                 ItemStack itemStack;
/* 2407 */                 if ((itemStack = ((ItemStack[])array2.items)[bool]).getItem().sameAs(shopOffer.item.getItem()) && 
/* 2408 */                   itemStack.getCount() > Game.i.progressManager.getItemsCount(itemStack.getItem())) {
/* 2409 */                   b1++;
/*      */                 }
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2417 */         if (research.priceInStars == 0) {
/*      */           Array array2;
/* 2419 */           if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*      */             
/* 2421 */             array2 = research.getCumulativePrice(research.getInstalledLevel(), research.maxEndlessLevel, false);
/*      */           } else {
/*      */             
/* 2424 */             array2 = research.getCumulativePrice(research.getInstalledLevel(), research.levels.length, false);
/*      */           } 
/* 2426 */           for (byte b2 = 0; b2 < array2.size; b2++) {
/*      */             ItemStack itemStack;
/* 2428 */             if ((itemStack = (ItemStack)array2.get(b2)).getItem().sameAs(shopOffer.item.getItem())) {
/* 2429 */               l += itemStack.getCount();
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/* 2434 */       a.i("fullTreeRequiredCount " + l, new Object[0]);
/*      */ 
/*      */       
/* 2437 */       if (b1 != 0) {
/* 2438 */         String str3 = Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-research>" + b1).toString();
/* 2439 */         String str4 = Game.i.localeManager.i18n.format("item_required_by_research_count_tooltip", new Object[] { str3 });
/*      */         Label label;
/* 2441 */         (label = new Label(str4, Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 2442 */         table.add((Actor)label).row();
/*      */       } 
/*      */ 
/*      */       
/* 2446 */       if (l != 0L) {
/* 2447 */         String str3 = StringFormatter.compactNumber(l, false).toString();
/* 2448 */         String str4 = Game.i.localeManager.i18n.format("item_required_for_full_research_tooltip", new Object[] { str3 });
/*      */         Label label;
/* 2450 */         (label = new Label(str4, Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 2451 */         table.add((Actor)label).row();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2456 */       String str1 = StringFormatter.compactNumber((i = Game.i.progressManager.getItemsCount(shopOffer.item.getItem())), false).toString();
/* 2457 */       String str2 = Game.i.localeManager.i18n.format("you_have_n_such_items", new Object[] { str1 });
/*      */       Label label1;
/* 2459 */       (label1 = new Label(str2, Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 2460 */       table.add((Actor)label1).row();
/*      */       
/*      */       TooltipsOverlay.Entry entry;
/* 2463 */       (entry = TooltipsOverlay.i().showActor(str, (Actor)this.i.get(paramInt), (Actor)table, this.c.mainUiLayer, this.c.zIndex + 1, 4)).onDispose = (() -> {
/*      */           if (paramInt == this.j) {
/*      */             a(-1);
/*      */           }
/*      */         });
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(String paramString) {
/* 2473 */     this.d.getTable().setVisible(true);
/* 2474 */     Game.i.purchaseManager.purchaseManager.purchase(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   private void b() {
/* 2479 */     this.n.setText((CharSequence)StringFormatter.digestTimeWithZeroHours((int)Game.i.progressManager.getLootBoostTimeLeft(), true));
/* 2480 */     if (Game.i.progressManager.getLootBoostTimeLeft() > 0.0F) {
/* 2481 */       this.n.setColor(MaterialColor.LIGHT_GREEN.P500);
/*      */     } else {
/* 2483 */       this.n.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */     } 
/*      */ 
/*      */     
/* 2487 */     if (!Game.i.purchaseManager.rewardingAdsAvailable() || this.e == null)
/*      */       return; 
/* 2489 */     if (Game.i.purchaseManager.canShowRewardingAd(PurchaseManager.RewardingAdsType.REGULAR)) {
/*      */       
/* 2491 */       this.e.setVisible(true);
/* 2492 */       this.f.setVisible(false);
/*      */     } else {
/*      */       
/* 2495 */       this.e.setVisible(false);
/*      */       
/*      */       int i;
/* 2498 */       if ((i = Game.i.purchaseManager.getSecondsTillAdIsReady(PurchaseManager.RewardingAdsType.REGULAR)) > 0) {
/* 2499 */         this.f.setText((CharSequence)StringFormatter.digestTime(i));
/* 2500 */         this.f.setVisible(true);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2505 */     if (Game.i.progressManager.hasTemporaryDoubleGain() && this.g != null) {
/* 2506 */       String str = StringFormatter.timePassed(Game.i.progressManager.getTempDoubleGainDurationLeft(), true, true);
/* 2507 */       this.g.setText(str);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void c() {
/* 2512 */     dispose();
/*      */     
/* 2514 */     if (this.b instanceof AboutScreen) {
/* 2515 */       Game.i.screenManager.goToAboutScreen(); return;
/* 2516 */     }  if (this.b instanceof LevelSelectScreen) {
/* 2517 */       Game.i.screenManager.goToLevelSelectScreen(); return;
/* 2518 */     }  if (this.b instanceof CustomMapSelectScreen) {
/* 2519 */       Game.i.screenManager.goToCustomMapSelectScreen(); return;
/* 2520 */     }  if (this.b instanceof ResearchesScreen) {
/* 2521 */       Game.i.screenManager.goToResearchesScreen(); return;
/* 2522 */     }  if (this.b instanceof SettingsScreen) {
/* 2523 */       Game.i.screenManager.goToSettingsScreen(); return;
/* 2524 */     }  if (this.b instanceof StatisticsScreen) {
/* 2525 */       Game.i.screenManager.goToStatisticsScreen(); return;
/*      */     } 
/* 2527 */     Game.i.screenManager.goToMainMenu();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/* 2538 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 2539 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 2540 */     Gdx.gl.glClear(16640);
/*      */     
/* 2542 */     if (Game.i.settingsManager.isEscButtonJustPressed()) {
/*      */       
/* 2544 */       c();
/*      */       
/*      */       return;
/*      */     } 
/* 2548 */     this.h += paramFloat;
/* 2549 */     if (this.h > 1.0F) {
/* 2550 */       b();
/* 2551 */       this.h = 0.0F;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 2557 */     Game.i.uiManager.removeLayer(this.c);
/* 2558 */     Game.i.uiManager.removeLayer(this.d);
/* 2559 */     Game.i.purchaseManager.removeListener((PurchaseManager.PurchaseManagerListener)this.l);
/* 2560 */     Game.i.progressManager.removeListener((ProgressManager.ProgressManagerListener)this.m);
/*      */   }
/*      */   
/*      */   private class _ProgressManagerListener extends ProgressManager.ProgressManagerListener.ProgressManagerListenerAdapter { private _ProgressManagerListener(MoneyScreen this$0) {}
/*      */     
/*      */     public void itemsChanged(Item param1Item, int param1Int1, int param1Int2) {
/* 2566 */       if (param1Item == Item.D.LUCKY_SHOT_TOKEN || param1Item == Item.D.GREEN_PAPER || param1Item == Item.D.ACCELERATOR || param1Item == Item.D.LOOT_BOOST || param1Item == Item.D.RARITY_BOOST || param1Item == Item.D.CASE_KEY_BLUE || param1Item == Item.D.CASE_KEY_ORANGE || param1Item == Item.D.CASE_KEY_PURPLE || param1Item == Item.D.CASE_KEY_CYAN) {
/* 2567 */         MoneyScreen.a(this.a);
/*      */       }
/*      */     }
/*      */     
/*      */     public void doubleGainEnabled() {
/* 2572 */       MoneyScreen.a(this.a);
/*      */     } }
/*      */ 
/*      */   
/*      */   private class _PurchaseManagerListener extends PurchaseManager.PurchaseManagerListener.PurchaseManagerListenerAdapter {
/*      */     private _PurchaseManagerListener(MoneyScreen this$0) {}
/*      */     
/*      */     public void purchased(Transaction param1Transaction) {
/* 2580 */       MoneyScreen.a(this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public void gotResponse(String param1String, Object param1Object) {
/* 2585 */       MoneyScreen.b(this.a).getTable().setVisible(false);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\MoneyScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */