/*     */ package com.prineside.tdi2.screens.account;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class AccountSignInScreen extends GenericAccountScreen {
/*     */   private FancyButton a;
/*     */   
/*     */   public AccountSignInScreen() {
/*  24 */     super(null, () -> Game.i.screenManager.goToMainMenu());
/*     */     
/*  26 */     Table table1 = new Table();
/*  27 */     this.uiLayer.getTable().add((Actor)table1).row();
/*     */ 
/*     */ 
/*     */     
/*  31 */     table1.add().height(120.0F).width(1.0F).row();
/*     */     
/*     */     Label label3;
/*  34 */     (label3 = new Label(Game.i.localeManager.i18n.get("login"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  35 */     table1.add((Actor)label3).height(64.0F).row();
/*     */     
/*  37 */     TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/*     */     String str;
/*  39 */     if ((str = Game.i.authManager.getProgressOwnerPlayerId()) != null) {
/*  40 */       String str1 = Game.i.authManager.getProgressOwnerPlayerNickname();
/*  41 */       textFieldXPlatform1.setText(str1);
/*  42 */       str = Game.i.localeManager.i18n.format("sign_in_login_forced_by_progress_owner", new Object[] { str });
/*  43 */       TooltipsOverlay.i().showText("AccountScreen.progressOwnerForcedNickname", (Actor)textFieldXPlatform1, str, this.uiLayer.mainUiLayer, this.uiLayer.zIndex + 1, 16);
/*     */     } 
/*  45 */     table1.add((Actor)textFieldXPlatform1).size(320.0F, 56.0F).row();
/*     */     
/*     */     Label label2;
/*  48 */     (label2 = new Label(Game.i.localeManager.i18n.get("password"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  49 */     table1.add((Actor)label2).height(64.0F).row();
/*     */     
/*     */     TextFieldXPlatform textFieldXPlatform2;
/*  52 */     (textFieldXPlatform2 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyleWithVariant(30, false))).setPasswordMode(true);
/*  53 */     textFieldXPlatform2.setPasswordCharacter('*');
/*  54 */     table1.add((Actor)textFieldXPlatform2).size(320.0F, 56.0F).row();
/*     */     
/*  56 */     this
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
/*  86 */       .a = (new FancyButton("regularButton.a", () -> { if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) { Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL); return; }  this.a.label.setText(Game.i.localeManager.i18n.get("signing_in...")); a(); Game.i.authManager.signIn(paramTextFieldXPlatform1.getText(), paramTextFieldXPlatform2.getText(), ()); })).withLabel(30, Game.i.localeManager.i18n.get("sign_in"));
/*  87 */     table1.add((Actor)this.a).size(320.0F, 64.0F).padTop(32.0F).row();
/*     */     
/*  89 */     Table table3 = new Table();
/*  90 */     table1.add((Actor)table3).height(64.0F).padTop(64.0F).padBottom(16.0F).row();
/*     */     
/*  92 */     boolean bool = false;
/*  93 */     if (Game.i.actionResolver.hasGoogleAuth()) {
/*     */       
/*  95 */       RectButton rectButton = AccountScreen.createGoogleSignInButton(this::a, this::b, false);
/*  96 */       table3.add((Actor)rectButton).size(320.0F, 64.0F);
/*  97 */       bool = true;
/*     */     } 
/*  99 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*     */       
/* 101 */       RectButton rectButton = AccountScreen.createSteamSignInButton(this::a, this::b, false);
/* 102 */       Cell cell = table3.add((Actor)rectButton).size(320.0F, 64.0F);
/* 103 */       if (bool) {
/* 104 */         cell.padLeft(16.0F);
/*     */       }
/*     */     } 
/*     */     
/*     */     LabelButton labelButton2;
/* 109 */     (labelButton2 = new LabelButton(Game.i.localeManager.i18n.get("why_account_link"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.WHY_ACCOUNT_URL))).setAlignment(1);
/* 110 */     table1.add((Actor)labelButton2).size(320.0F, 32.0F).padTop(32.0F).padBottom(8.0F).row();
/*     */     
/*     */     LabelButton labelButton1;
/* 113 */     (labelButton1 = new LabelButton(Game.i.localeManager.i18n.get("privacy_policy"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.PRIVACY_POLICY_URL))).setAlignment(1);
/* 114 */     table1.add((Actor)labelButton1).size(320.0F, 32.0F).padTop(8.0F).padBottom(8.0F).row();
/*     */ 
/*     */     
/* 117 */     (labelButton1 = new LabelButton(Game.i.localeManager.i18n.get("terms_and_conditions"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.TERMS_AND_CONDITIONS_URL))).setAlignment(1);
/* 118 */     table1.add((Actor)labelButton1).size(320.0F, 32.0F).padTop(8.0F).padBottom(32.0F).row();
/*     */     
/* 120 */     Table table2 = new Table();
/* 121 */     table1.add((Actor)table2).padTop(16.0F).padBottom(160.0F).row();
/*     */     
/*     */     Label label1;
/* 124 */     (label1 = new Label(Game.i.localeManager.i18n.get("dont_have_account?"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 125 */     table2.add((Actor)label1);
/*     */ 
/*     */     
/* 128 */     (label1 = new Label(Game.i.localeManager.i18n.get("forgot_password?"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 129 */     table2.add((Actor)label1).padLeft(64.0F).row();
/*     */     
/* 131 */     table2.add((Actor)(new FancyButton("regularButton.a", () -> Game.i.screenManager.setScreen(new AccountSignUpScreen())))
/*     */ 
/*     */ 
/*     */         
/* 135 */         .withLabel(30, Game.i.localeManager.i18n.get("sign_up")))
/* 136 */       .size(320.0F, 64.0F).padTop(16.0F);
/*     */     
/* 138 */     table2.add((Actor)(new FancyButton("regularButton.b", () -> Game.i.screenManager.setScreen(new AccountPasswordResetScreen())))
/*     */ 
/*     */ 
/*     */         
/* 142 */         .withLabel(30, Game.i.localeManager.i18n.get("reset_password")))
/* 143 */       .size(320.0F, 64.0F).padTop(16.0F).padLeft(64.0F).row();
/*     */   }
/*     */   
/*     */   private void a() {
/* 147 */     this.a.setEnabled(false);
/*     */   }
/*     */   
/*     */   private void b() {
/* 151 */     this.a.label.setText(Game.i.localeManager.i18n.get("sign_in"));
/* 152 */     this.a.setEnabled(true);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\AccountSignInScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */