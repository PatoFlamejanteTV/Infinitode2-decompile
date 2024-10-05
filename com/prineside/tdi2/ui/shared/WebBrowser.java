/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.Game;
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
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.WebView;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public final class WebBrowser implements Disposable, UiManager.UiComponent {
/*  25 */   private static final TLog a = TLog.forClass(WebBrowser.class);
/*     */   public static WebBrowser i() {
/*  27 */     return (WebBrowser)Game.i.uiManager.getComponent(WebBrowser.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 149, "WebBrowser main");
/*     */   
/*     */   private Group c;
/*     */   
/*     */   private ScrollPane d;
/*     */   
/*     */   private Table e;
/*     */   
/*     */   private Image f;
/*     */   
/*     */   private Group g;
/*     */   private Group h;
/*     */   private WebView i;
/*     */   public WebView webView;
/*     */   
/*     */   public WebBrowser() {
/*  51 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*  52 */     i += 960;
/*     */     
/*     */     Group group2;
/*     */     
/*  56 */     (group2 = new Group()).setTransform(false);
/*  57 */     group2.setOrigin(520.0F, i * 0.5F);
/*  58 */     this.b.getTable().add((Actor)group2).size(1040.0F, i);
/*     */     
/*  60 */     this.c = new Group();
/*  61 */     this.c.setTransform(false);
/*  62 */     this.c.setOrigin(520.0F, i * 0.5F);
/*  63 */     this.c.setSize(1040.0F, i);
/*  64 */     group2.addActor((Actor)this.c);
/*     */     
/*     */     Image image1;
/*  67 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(555819519));
/*  68 */     image1.setSize(1040.0F, i);
/*  69 */     this.c.addActor((Actor)image1);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor1;
/*     */ 
/*     */ 
/*     */     
/*  77 */     (quadActor1 = new QuadActor(new Color(555819519), new float[] { 0.0F, 0.0F, 0.0F, 12.0F, 1040.0F, 12.0F, 1040.0F, 12.0F })).setPosition(0.0F, -12.0F);
/*  78 */     this.c.addActor((Actor)quadActor1);
/*     */     
/*  80 */     this.e = new Table();
/*  81 */     this.e.setTouchable(Touchable.childrenOnly);
/*     */     
/*  83 */     this.d = new ScrollPane((Actor)this.e);
/*  84 */     UiUtils.enableMouseMoveScrollFocus(this.d);
/*  85 */     this.d.setTransform(true);
/*  86 */     this.d.setSize(1040.0F, i);
/*  87 */     this.d.setTouchable(Touchable.enabled);
/*  88 */     this.c.addActor((Actor)this.d);
/*     */ 
/*     */     
/*  91 */     this.g = new Group();
/*  92 */     this.g.setTransform(false);
/*  93 */     this.g.setSize(1040.0F, i);
/*  94 */     this.g.setVisible(false);
/*  95 */     this.c.addActor((Actor)this.g);
/*     */     
/*     */     Group group1;
/*  98 */     (group1 = new Group()).setTransform(false);
/*  99 */     group1.setSize(1040.0F, i);
/* 100 */     group1.setTouchable(Touchable.enabled);
/* 101 */     group1.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 104 */             WebBrowser.a(this.a);
/*     */           }
/*     */         });
/* 107 */     this.g.addActor((Actor)group1);
/*     */     
/*     */     Image image2;
/* 110 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(64));
/* 111 */     image2.setSize(1040.0F, i);
/* 112 */     group1.addActor((Actor)image2);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor2;
/*     */ 
/*     */ 
/*     */     
/* 120 */     (quadActor2 = new QuadActor(new Color(64), new float[] { 0.0F, 0.0F, 0.0F, 12.0F, 1040.0F, 12.0F, 1040.0F, 12.0F })).setPosition(0.0F, -12.0F);
/* 121 */     group1.addActor((Actor)quadActor2);
/*     */     
/* 123 */     this.h = new Group();
/* 124 */     this.h.setTransform(false);
/* 125 */     this.h.setSize(1040.0F, i);
/* 126 */     this.h.setTouchable(Touchable.childrenOnly);
/* 127 */     this.g.addActor((Actor)this.h);
/*     */     
/* 129 */     this.i = new WebView();
/* 130 */     this.i.addListener(new WebView.WebViewListener(this, i)
/*     */         {
/*     */           public void urlLoadStart(Net.HttpRequest param1HttpRequest) {
/* 133 */             WebBrowser.a().i("modal urlLoadStart", new Object[0]);
/*     */ 
/*     */             
/* 136 */             WebBrowser.b(this.b).clearActions();
/* 137 */             WebBrowser.b(this.b).addAction((Action)Actions.sequence(
/* 138 */                   (Action)Actions.show(), 
/* 139 */                   (Action)Actions.fadeIn(0.2F)));
/*     */ 
/*     */             
/* 142 */             WebBrowser.c(this.b).clear();
/*     */             
/*     */             Image image;
/* 145 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"))).setColor(1.0F, 1.0F, 1.0F, 0.0F);
/* 146 */             image.setTouchable(Touchable.disabled);
/* 147 */             image.setOrigin(24.0F, 24.0F);
/* 148 */             image.setPosition(496.0F, this.a * 0.5F - 24.0F);
/* 149 */             image.setSize(48.0F, 48.0F);
/* 150 */             WebBrowser.c(this.b).addActor((Actor)image);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void urlLoadFinish(boolean param1Boolean1, String param1String, boolean param1Boolean2) {
/* 156 */             WebBrowser.a().i("modal urlLoadFinish " + param1Boolean1 + " " + param1String, new Object[0]);
/* 157 */             WebBrowser.c(this.b).clear();
/*     */             
/* 159 */             if (param1Boolean1) {
/*     */               
/* 161 */               if ((WebBrowser.d(this.b)).pageWidth > 0 && (WebBrowser.d(this.b)).pageHeight > 0) {
/*     */                 Group group1;
/*     */                 
/* 164 */                 (group1 = new Group()).setTransform(false);
/* 165 */                 group1.setSize((WebBrowser.d(this.b)).pageWidth + 80.0F, (WebBrowser.d(this.b)).pageHeight + 80.0F);
/* 166 */                 float f1 = 520.0F - ((WebBrowser.d(this.b)).pageWidth + 80.0F) * 0.5F;
/* 167 */                 float f2 = this.a * 0.5F - ((WebBrowser.d(this.b)).pageHeight + 80.0F) * 0.5F;
/* 168 */                 group1.setPosition(f1, f2);
/* 169 */                 WebBrowser.c(this.b).addActor((Actor)group1);
/*     */                 
/*     */                 Group group2;
/* 172 */                 (group2 = new Group()).setTransform(false);
/* 173 */                 group2.setOrigin(((WebBrowser.d(this.b)).pageWidth + 80.0F) * 0.5F, ((WebBrowser.d(this.b)).pageHeight + 80.0F) * 0.5F);
/* 174 */                 group2.setSize((WebBrowser.d(this.b)).pageWidth + 80.0F, (WebBrowser.d(this.b)).pageHeight + 80.0F);
/* 175 */                 group1.addActor((Actor)group2);
/*     */                 
/* 177 */                 UiUtils.bouncyShowOverlay(null, null, group2);
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 QuadActor quadActor;
/*     */ 
/*     */ 
/*     */                 
/* 186 */                 (quadActor = new QuadActor(new Color(48), new float[] { 0.0F, 0.0F, 6.0F, (WebBrowser.d(this.b)).pageHeight + 80.0F, (WebBrowser.d(this.b)).pageWidth + 80.0F, (WebBrowser.d(this.b)).pageHeight + 80.0F - 6.0F, (WebBrowser.d(this.b)).pageWidth + 80.0F - 6.0F, 6.0F })).setPosition(12.0F, -8.0F);
/* 187 */                 group2.addActor((Actor)quadActor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 194 */                 quadActor = new QuadActor(new Color(606348543), new float[] { 0.0F, 0.0F, 6.0F, (WebBrowser.d(this.b)).pageHeight + 80.0F, (WebBrowser.d(this.b)).pageWidth + 80.0F, (WebBrowser.d(this.b)).pageHeight + 80.0F - 6.0F, (WebBrowser.d(this.b)).pageWidth + 80.0F - 6.0F, 6.0F });
/*     */                 
/* 196 */                 group2.addActor((Actor)quadActor);
/*     */ 
/*     */                 
/* 199 */                 WebBrowser.d(this.b).setSize((WebBrowser.d(this.b)).pageWidth, (WebBrowser.d(this.b)).pageHeight);
/* 200 */                 WebBrowser.d(this.b).setPosition(40.0F, 40.0F);
/* 201 */                 group2.addActor((Actor)WebBrowser.d(this.b));
/*     */                 
/*     */                 PaddedImageButton paddedImageButton;
/*     */                 
/* 205 */                 (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> WebBrowser.a(this.b), MaterialColor.ORANGE.P500, MaterialColor.ORANGE.P400, MaterialColor.ORANGE.P600)).setIconSize(48.0F, 48.0F);
/* 206 */                 paddedImageButton.setIconPosition(16.0F, 16.0F);
/* 207 */                 paddedImageButton.setSize(64.0F, 64.0F);
/* 208 */                 paddedImageButton.setPosition(((WebBrowser.d(this.b)).pageWidth + 40), ((WebBrowser.d(this.b)).pageHeight + 40));
/* 209 */                 group2.addActor((Actor)paddedImageButton); return;
/*     */               } 
/* 211 */               WebBrowser.a().e("modal size is unknown: " + (WebBrowser.d(this.b)).pageWidth + " " + (WebBrowser.d(this.b)).pageHeight, new Object[0]);
/* 212 */               WebBrowser.a(this.b);
/*     */               return;
/*     */             } 
/* 215 */             WebBrowser.a().e("modal loading is not successful", new Object[0]);
/* 216 */             WebBrowser.a(this.b);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void modalLoadRequested(String param1String) {
/* 222 */             WebBrowser.d(this.b).loadUrl("GET", param1String, null);
/*     */           }
/*     */         });
/*     */     
/* 226 */     this.webView = new WebView();
/*     */     
/* 228 */     this.e.add().width(1.0F).height(32.0F).row();
/* 229 */     this.e.add().width(40.0F);
/* 230 */     this.e.add((Actor)this.webView).width(960.0F).expandY().fillY();
/* 231 */     this.e.add().width(40.0F).row();
/* 232 */     this.e.add().width(1.0F).height(32.0F).row();
/*     */     
/* 234 */     this.f = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"));
/* 235 */     this.f.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/* 236 */     this.f.setTouchable(Touchable.disabled);
/* 237 */     this.f.setOrigin(24.0F, 24.0F);
/* 238 */     this.f.setPosition(496.0F, i * 0.5F - 24.0F);
/* 239 */     this.f.setSize(48.0F, 48.0F);
/* 240 */     this.c.addActor((Actor)this.f);
/*     */     
/* 242 */     this.webView.addListener(new WebView.WebViewListener(this)
/*     */         {
/*     */           public void urlLoadStart(Net.HttpRequest param1HttpRequest) {
/* 245 */             WebBrowser.e(this.a).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 246 */             WebBrowser.e(this.a).setTouchable(Touchable.disabled);
/* 247 */             WebBrowser.f(this.a).setDrawable((Drawable)Game.i.assetManager.getDrawable("loading-icon"));
/* 248 */             WebBrowser.f(this.a).clearActions();
/* 249 */             WebBrowser.f(this.a).addAction((Action)Actions.sequence(
/* 250 */                   (Action)Actions.parallel(
/* 251 */                     (Action)Actions.fadeIn(0.2F), 
/* 252 */                     (Action)Actions.forever((Action)Actions.rotateBy(90.0F, 0.5F)))));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void urlLoadFinish(boolean param1Boolean1, String param1String, boolean param1Boolean2) {
/* 259 */             WebBrowser.e(this.a).setColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 260 */             WebBrowser.e(this.a).setTouchable(Touchable.enabled);
/*     */             
/* 262 */             if (param1Boolean1) {
/* 263 */               WebBrowser.f(this.a).clearActions();
/* 264 */               WebBrowser.f(this.a).addAction((Action)Actions.fadeOut(0.2F)); return;
/*     */             } 
/* 266 */             WebBrowser.f(this.a).setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-times"));
/* 267 */             WebBrowser.f(this.a).clearActions();
/* 268 */             WebBrowser.f(this.a).addAction((Action)Actions.sequence(
/* 269 */                   (Action)Actions.rotateTo(0.0F), 
/* 270 */                   (Action)Actions.fadeIn(0.2F), 
/* 271 */                   (Action)Actions.delay(0.5F), 
/* 272 */                   (Action)Actions.fadeOut(0.2F)));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void modalLoadRequested(String param1String) {
/* 279 */             WebBrowser.d(this.a).loadUrl("GET", param1String, null);
/*     */           }
/*     */         });
/*     */     
/*     */     PaddedImageButton paddedImageButton;
/* 284 */     (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> setVisible(false), MaterialColor.ORANGE.P500, MaterialColor.ORANGE.P400, MaterialColor.ORANGE.P600)).setIconSize(48.0F, 48.0F);
/* 285 */     paddedImageButton.setIconPosition(16.0F, 16.0F);
/* 286 */     paddedImageButton.setSize(64.0F, 64.0F);
/* 287 */     paddedImageButton.setPosition(1008.0F, i - 32.0F);
/* 288 */     paddedImageButton.setName("web_browser_close_button");
/* 289 */     this.c.addActor((Actor)paddedImageButton);
/*     */     
/* 291 */     this.b.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   private void b() {
/* 295 */     a.i("hideModal", new Object[0]);
/* 296 */     this.g.clearActions();
/* 297 */     this.g.addAction((Action)Actions.sequence(
/* 298 */           (Action)Actions.fadeOut(0.2F), 
/* 299 */           (Action)Actions.hide()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 304 */     setVisible(false);
/* 305 */     b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPersistent() {
/* 310 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void preRender(float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final void postRender(float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setVisible(boolean paramBoolean) {
/* 324 */     if (paramBoolean) {
/* 325 */       DarkOverlay.i().addCallerOverlayLayer("WebBrowser", this.b.zIndex - 1, () -> {
/*     */             hide();
/*     */             return true;
/*     */           });
/* 329 */       UiUtils.bouncyShowOverlay(null, (Actor)this.b.getTable(), this.c); return;
/*     */     } 
/* 331 */     DarkOverlay.i().removeCaller("WebBrowser");
/* 332 */     UiUtils.bouncyHideOverlay(null, (Actor)this.b.getTable(), this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 340 */     Game.i.uiManager.removeLayer(this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\WebBrowser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */