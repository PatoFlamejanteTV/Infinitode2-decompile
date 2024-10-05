/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.TextArea;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public final class RatingForm extends UiManager.UiComponent.Adapter {
/*  32 */   private static final TLog a = TLog.forClass(RatingForm.class);
/*     */   public static RatingForm i() {
/*  34 */     return (RatingForm)Game.i.uiManager.getComponent(RatingForm.class);
/*     */   }
/*     */   
/*  37 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 110, "RatingForm tint");
/*  38 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 111, "RatingForm main");
/*     */   
/*     */   private Group d;
/*     */   
/*     */   private Group e;
/*     */   
/*     */   private Group f;
/*     */   private Group g;
/*     */   
/*     */   public RatingForm() {
/*     */     Image image;
/*  49 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  50 */     (image.getColor()).a = 0.78F;
/*  51 */     this.b.getTable().add((Actor)image).expand().fill();
/*  52 */     this.b.getTable().setTouchable(Touchable.enabled);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     this.b.getTable().addListener((EventListener)new InputVoid());
/*     */     
/*     */     Group group;
/*  62 */     (group = new Group()).setTransform(false);
/*  63 */     group.setOrigin(360.0F, 285.0F);
/*  64 */     this.c.getTable().add((Actor)group).size(720.0F, 570.0F);
/*     */     
/*  66 */     this.d = new Group();
/*  67 */     this.d.setTransform(false);
/*  68 */     this.d.setOrigin(360.0F, 285.0F);
/*  69 */     this.d.setSize(720.0F, 570.0F);
/*  70 */     group.addActor((Actor)this.d);
/*     */     
/*  72 */     this.e = new Group();
/*  73 */     this.e.setTransform(false);
/*  74 */     this.e.setSize(720.0F, 300.0F);
/*  75 */     this.e.setPosition(0.0F, 130.0F);
/*  76 */     this.d.addActor((Actor)this.e);
/*     */     
/*  78 */     this.f = new Group();
/*  79 */     this.f.setTransform(false);
/*  80 */     this.f.setSize(720.0F, 300.0F);
/*  81 */     this.f.setPosition(0.0F, 130.0F);
/*  82 */     this.d.addActor((Actor)this.f);
/*     */     
/*  84 */     this.g = new Group();
/*  85 */     this.g.setTransform(false);
/*  86 */     this.g.setSize(720.0F, 570.0F);
/*  87 */     this.d.addActor((Actor)this.g);
/*     */     
/*  89 */     this.b.getTable().addAction((Action)Actions.alpha(0.0F));
/*  90 */     this.b.getTable().setVisible(false);
/*  91 */     this.c.getTable().setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setVisible(boolean paramBoolean) {
/*  96 */     if (paramBoolean) {
/*  97 */       UiUtils.bouncyShowOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d); return;
/*     */     } 
/*  99 */     UiUtils.bouncyHideOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void showRatePrompt() {
/* 106 */     this.e.setVisible(true);
/* 107 */     this.f.setVisible(false);
/* 108 */     this.g.setVisible(false);
/*     */     
/* 110 */     this.e.clearChildren();
/*     */     
/* 112 */     QuadActor quadActor = new QuadActor(new Color(791621631), new float[] { 15.0F, 0.0F, 0.0F, 300.0F, 720.0F, 288.0F, 705.0F, 7.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     this.e.addActor((Actor)quadActor);
/*     */     
/*     */     Label label;
/* 121 */     (label = new Label(Game.i.localeManager.i18n.get("rating_form_prompt"), Game.i.assetManager.getLabelStyle(36))).setAlignment(1);
/* 122 */     label.setSize(640.0F, 30.0F);
/* 123 */     label.setWrap(true);
/* 124 */     label.setPosition(40.0F, 175.0F);
/* 125 */     this.e.addActor((Actor)label);
/*     */ 
/*     */     
/*     */     ComplexButton complexButton;
/*     */ 
/*     */     
/* 131 */     (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("never"), Game.i.assetManager.getLabelStyle(30), () -> { hide(); Game.i.ratingManager.promptAnsweredNever(); })).setSize(251.0F, 101.0F);
/* 132 */     complexButton.setPosition(0.0F, -11.0F);
/* 133 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 50.0F, 22.0F, 48.0F, 48.0F);
/* 134 */     complexButton.setLabel(115.0F, 0.0F, 100.0F, 96.0F, 8);
/* 135 */     complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 11.0F, 0.0F, 0.0F, 101.0F, 245.0F, 93.0F, 251.0F, 0.0F })), 0.0F, 0.0F, 251.0F, 101.0F);
/* 136 */     complexButton.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.WHITE);
/* 137 */     this.e.addActor((Actor)complexButton);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("later"), Game.i.assetManager.getLabelStyle(30), () -> { hide(); Game.i.ratingManager.promptAnsweredLater(); })).setSize(218.0F, 96.0F);
/* 144 */     complexButton.setPosition(251.0F, -11.0F);
/* 145 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-clock"), 47.0F, 22.0F, 48.0F, 48.0F);
/* 146 */     complexButton.setLabel(103.0F, 0.0F, 100.0F, 96.0F, 8);
/* 147 */     complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 7.0F, 0.0F, 0.0F, 93.0F, 218.0F, 96.0F, 212.0F, 0.0F })), 0.0F, 0.0F, 218.0F, 96.0F);
/* 148 */     complexButton.setBackgroundColors(MaterialColor.AMBER.P800, MaterialColor.AMBER.P900, MaterialColor.AMBER.P700, Color.WHITE);
/* 149 */     this.e.addActor((Actor)complexButton);
/*     */ 
/*     */     
/* 152 */     (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("rate"), Game.i.assetManager.getLabelStyle(30), () -> showStarsForm())).setSize(251.0F, 101.0F);
/* 153 */     complexButton.setPosition(469.0F, -11.0F);
/* 154 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-star"), 50.0F, 22.0F, 48.0F, 48.0F);
/* 155 */     complexButton.setLabel(115.0F, 0.0F, 100.0F, 96.0F, 8);
/* 156 */     complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 7.0F, 96.0F, 251.0F, 101.0F, 240.0F, 0.0F })), 0.0F, 0.0F, 251.0F, 101.0F);
/* 157 */     complexButton.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.WHITE);
/* 158 */     this.e.addActor((Actor)complexButton);
/*     */     
/* 160 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public final void showStarsForm() {
/* 164 */     this.e.setVisible(false);
/* 165 */     this.f.setVisible(true);
/* 166 */     this.g.setVisible(false);
/*     */     
/* 168 */     this.f.clearChildren();
/*     */     
/* 170 */     QuadActor quadActor = new QuadActor(new Color(791621631), new float[] { 15.0F, 0.0F, 0.0F, 300.0F, 720.0F, 288.0F, 705.0F, 7.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     this.f.addActor((Actor)quadActor);
/*     */     
/* 178 */     int[] arrayOfInt = { 5 };
/*     */     
/*     */     ComplexButton complexButton;
/* 181 */     (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("cancel"), Game.i.assetManager.getLabelStyle(30), () -> hide())).setSize(251.0F, 101.0F);
/* 182 */     complexButton.setPosition(0.0F, -11.0F);
/* 183 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 50.0F, 22.0F, 48.0F, 48.0F);
/* 184 */     complexButton.setLabel(115.0F, 0.0F, 100.0F, 96.0F, 8);
/* 185 */     complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 11.0F, 0.0F, 0.0F, 101.0F, 245.0F, 93.0F, 251.0F, 0.0F })), 0.0F, 0.0F, 251.0F, 101.0F);
/* 186 */     complexButton.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.WHITE);
/* 187 */     this.f.addActor((Actor)complexButton);
/*     */ 
/*     */     
/* 190 */     (complexButton = new ComplexButton("5", Game.i.assetManager.getLabelStyle(30), () -> showFeedbackForm(paramArrayOfint[0]))).setSize(251.0F, 101.0F);
/* 191 */     complexButton.setPosition(469.0F, -11.0F);
/* 192 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-star"), 82.0F, 22.0F, 48.0F, 48.0F);
/* 193 */     complexButton.setLabel(140.0F, 0.0F, 100.0F, 96.0F, 8);
/* 194 */     complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 7.0F, 96.0F, 251.0F, 101.0F, 240.0F, 0.0F })), 0.0F, 0.0F, 251.0F, 101.0F);
/* 195 */     complexButton.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, MaterialColor.GREY.P800);
/* 196 */     complexButton.setEnabled(false);
/* 197 */     this.f.addActor((Actor)complexButton);
/*     */ 
/*     */     
/* 200 */     Image[] arrayOfImage = new Image[5];
/* 201 */     for (byte b = 0; b < 5; b++) {
/*     */       Image image;
/* 203 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setPosition(128.0F + b * 96.0F, 152.0F);
/* 204 */       image.setSize(80.0F, 80.0F);
/* 205 */       image.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 206 */       arrayOfImage[b] = image;
/* 207 */       this.f.addActor((Actor)image);
/*     */       
/* 209 */       image.setTouchable(Touchable.enabled);
/* 210 */       byte b1 = b;
/* 211 */       image.addListener((EventListener)new ClickListener(this, arrayOfInt, b1, arrayOfImage, complexButton) {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*     */               Color color;
/* 214 */               this.a[0] = this.b + 1;
/* 215 */               for (byte b1 = 0; b1 < 5; b1++) {
/* 216 */                 this.c[b1].setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */               }
/*     */               
/* 219 */               if (this.a[0] < 3) {
/* 220 */                 color = MaterialColor.RED.P500;
/* 221 */               } else if (this.a[0] < 5) {
/* 222 */                 color = MaterialColor.AMBER.P500;
/*     */               } else {
/* 224 */                 color = MaterialColor.GREEN.P500;
/*     */               } 
/*     */               
/* 227 */               for (byte b2 = 0; b2 < this.a[0]; b2++) {
/* 228 */                 this.c[b2].setColor(color);
/*     */               }
/* 230 */               this.d.setText(String.valueOf(this.a[0]));
/* 231 */               this.d.setEnabled(true);
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 236 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public final void showFeedbackForm(int paramInt) {
/* 240 */     if (Config.isHeadless())
/*     */       return; 
/* 242 */     if (paramInt == 5) {
/*     */       Net.HttpRequest httpRequest;
/*     */       
/* 245 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.REVIEW_URL);
/*     */       HashMap<Object, Object> hashMap;
/* 247 */       (hashMap = new HashMap<>()).put("playerid", Game.i.authManager.getPlayerId());
/* 248 */       if (Game.i.authManager.isSignedIn()) hashMap.put("sessionid", Game.i.authManager.getSessionId()); 
/* 249 */       hashMap.put("stars", "5");
/* 250 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 251 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*     */           {
/*     */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 254 */               RatingForm.a().i("response: " + param1HttpResponse.getResultAsString(), new Object[0]);
/*     */             }
/*     */ 
/*     */             
/*     */             public void failed(Throwable param1Throwable) {
/* 259 */               RatingForm.a().e("failed", new Object[] { param1Throwable });
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void cancelled() {}
/*     */           });
/* 268 */       if (Gdx.app.getType() == Application.ApplicationType.iOS) {
/* 269 */         str = "App Store";
/*     */       } else {
/* 271 */         str = "Google Play";
/*     */       } 
/* 273 */       String str = Game.i.localeManager.i18n.format("rating_form_thanks_market_prompt", new Object[] { str });
/* 274 */       Dialog.i().showConfirm(str, () -> {
/*     */             if (Gdx.app.getType() == Application.ApplicationType.Android) {
/*     */               Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.prineside.tdi2");
/*     */             } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
/*     */               Gdx.net.openURI("https://apps.apple.com/us/app/infinitode-2/id1480178308");
/*     */             } 
/*     */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("thanks_for_feedback"));
/*     */           });
/* 282 */       hide();
/*     */       
/* 284 */       Game.i.ratingManager.madeReview(paramInt, null);
/*     */       return;
/*     */     } 
/* 287 */     this.e.setVisible(false);
/* 288 */     this.f.setVisible(false);
/* 289 */     this.g.setVisible(true);
/*     */     
/* 291 */     this.g.clearChildren();
/*     */     
/* 293 */     QuadActor quadActor = new QuadActor(new Color(791621631), new float[] { 15.0F, 0.0F, 0.0F, 570.0F, 720.0F, 558.0F, 705.0F, 7.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     this.g.addActor((Actor)quadActor);
/*     */     
/*     */     Label label2;
/* 302 */     (label2 = new Label(Game.i.localeManager.i18n.get("thanks_for_feedback"), Game.i.assetManager.getLabelStyle(36))).setPosition(55.0F, 485.0F);
/* 303 */     label2.setSize(100.0F, 27.0F);
/* 304 */     label2.setColor(MaterialColor.GREEN.P500);
/* 305 */     this.g.addActor((Actor)label2);
/*     */     
/*     */     Label label1;
/* 308 */     (label1 = new Label(Game.i.localeManager.i18n.get("rating_form_comment_prompt"), Game.i.assetManager.getLabelStyle(30))).setPosition(55.0F, 396.0F);
/* 309 */     label1.setSize(600.0F, 58.0F);
/* 310 */     label1.setWrap(true);
/* 311 */     label1.setAlignment(10);
/* 312 */     this.g.addActor((Actor)label1);
/*     */ 
/*     */     
/* 315 */     (label1 = new Label("[#AAAAAA]" + Game.i.localeManager.i18n.get("if_problems_contact_us") + ": [][#03A9F4]sup.prineside@gmail.com" + "[]", Game.i.assetManager.getLabelStyle(24))).setPosition(55.0F, 310.0F);
/* 316 */     label1.setSize(600.0F, 42.0F);
/* 317 */     label1.setWrap(true);
/* 318 */     label1.setAlignment(10);
/* 319 */     this.g.addActor((Actor)label1);
/* 320 */     label1.setTouchable(Touchable.enabled);
/* 321 */     label1.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 324 */             Gdx.net.openURI("mailto:sup.prineside@gmail.com");
/*     */           }
/*     */         });
/*     */     
/*     */     TextArea textArea;
/* 329 */     (textArea = new TextArea("", Game.i.assetManager.getTextFieldStyle(24))).setMessageText(Game.i.localeManager.i18n.get("please_write_your_thoughts"));
/* 330 */     textArea.setPosition(55.0F, 148.0F);
/* 331 */     textArea.setSize(608.0F, 120.0F);
/* 332 */     this.g.addActor((Actor)textArea);
/*     */     
/*     */     ComplexButton complexButton2;
/* 335 */     (complexButton2 = new ComplexButton(Game.i.localeManager.i18n.get("close"), Game.i.assetManager.getLabelStyle(30), () -> hide())).setSize(251.0F, 101.0F);
/* 336 */     complexButton2.setPosition(0.0F, -11.0F);
/* 337 */     complexButton2.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 50.0F, 22.0F, 48.0F, 48.0F);
/* 338 */     complexButton2.setLabel(115.0F, 0.0F, 100.0F, 96.0F, 8);
/* 339 */     complexButton2.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 11.0F, 0.0F, 0.0F, 101.0F, 245.0F, 93.0F, 251.0F, 0.0F })), 0.0F, 0.0F, 251.0F, 101.0F);
/* 340 */     complexButton2.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.WHITE);
/* 341 */     this.g.addActor((Actor)complexButton2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     (complexButton2 = new ComplexButton(Game.i.localeManager.i18n.get("market"), Game.i.assetManager.getLabelStyle(30), () -> { if (Gdx.app.getType() == Application.ApplicationType.Android) { Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.prineside.tdi2"); return; }  if (Gdx.app.getType() == Application.ApplicationType.iOS) Gdx.net.openURI("https://apps.apple.com/us/app/infinitode-2/id1480178308");  })).setSize(218.0F, 96.0F);
/* 351 */     complexButton2.setPosition(251.0F, -11.0F);
/* 352 */     if (Gdx.app.getType() == Application.ApplicationType.Android) {
/* 353 */       complexButton2.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-google-play"), 47.0F, 22.0F, 48.0F, 48.0F);
/* 354 */     } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
/* 355 */       complexButton2.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-ios-app-store"), 47.0F, 22.0F, 48.0F, 48.0F);
/*     */     } 
/* 357 */     complexButton2.setLabel(103.0F, 0.0F, 100.0F, 96.0F, 8);
/* 358 */     complexButton2.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 7.0F, 0.0F, 0.0F, 93.0F, 218.0F, 96.0F, 212.0F, 0.0F })), 0.0F, 0.0F, 218.0F, 96.0F);
/* 359 */     complexButton2.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, Color.WHITE);
/* 360 */     this.g.addActor((Actor)complexButton2);
/* 361 */     if (paramInt < 4) {
/* 362 */       complexButton2.setVisible(false);
/*     */     }
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
/*     */     ComplexButton complexButton1;
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
/* 394 */     (complexButton1 = new ComplexButton(Game.i.localeManager.i18n.get("send"), Game.i.assetManager.getLabelStyle(30), () -> { Net.HttpRequest httpRequest; (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.REVIEW_URL); HashMap<Object, Object> hashMap; (hashMap = new HashMap<>()).put("playerid", Game.i.authManager.getPlayerId()); if (Game.i.authManager.isSignedIn()) hashMap.put("sessionid", Game.i.authManager.getSessionId());  hashMap.put("stars", String.valueOf(paramInt)); if (paramTextArea.getText().length() > 0) hashMap.put("message", paramTextArea.getText());  httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap)); Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this) { public void handleHttpResponse(Net.HttpResponse param1HttpResponse) { RatingForm.a().i("response: " + param1HttpResponse.getResultAsString(), new Object[0]); } public void failed(Throwable param1Throwable) { RatingForm.a().e("failed", new Object[] { param1Throwable }); } public void cancelled() {} }); hide(); Dialog.i().showAlert(Game.i.localeManager.i18n.get("thanks_for_feedback")); Game.i.ratingManager.madeReview(paramInt, paramTextArea.getText()); })).setSize(251.0F, 101.0F);
/* 395 */     complexButton1.setPosition(469.0F, -11.0F);
/* 396 */     complexButton1.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-letter"), 50.0F, 22.0F, 48.0F, 48.0F);
/* 397 */     complexButton1.setLabel(115.0F, 0.0F, 100.0F, 96.0F, 8);
/* 398 */     complexButton1.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 7.0F, 96.0F, 251.0F, 101.0F, 240.0F, 0.0F })), 0.0F, 0.0F, 251.0F, 101.0F);
/* 399 */     complexButton1.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.WHITE);
/* 400 */     this.g.addActor((Actor)complexButton1);
/*     */     
/* 402 */     setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 408 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\RatingForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */