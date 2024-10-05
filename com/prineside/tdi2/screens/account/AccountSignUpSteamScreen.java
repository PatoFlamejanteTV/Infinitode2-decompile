/*     */ package com.prineside.tdi2.screens.account;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class AccountSignUpSteamScreen extends GenericAccountScreen {
/*     */   private FancyButton a;
/*     */   
/*     */   public AccountSignUpSteamScreen() {
/*  23 */     super(Game.i.localeManager.i18n.get("sign_up") + " / Steam", AccountScreen::goToScreen);
/*     */     
/*  25 */     Table table = new Table();
/*  26 */     this.uiLayer.getTable().add((Actor)table).row();
/*     */     
/*  28 */     String str = Game.i.localeManager.i18n.get("optional");
/*  29 */     str = " (" + str.toLowerCase(Locale.US) + ")";
/*     */     
/*     */     Label label2;
/*  32 */     (label2 = new Label(Game.i.localeManager.i18n.get("nickname"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  33 */     table.add((Actor)label2).padBottom(8.0F).row();
/*     */     
/*  35 */     TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/*  36 */     table.add((Actor)textFieldXPlatform2).size(400.0F, 56.0F).padBottom(16.0F).row();
/*     */ 
/*     */     
/*  39 */     (label2 = new Label(Game.i.localeManager.i18n.get("email") + str, Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  40 */     table.add((Actor)label2).padBottom(8.0F).row();
/*     */     
/*  42 */     TextFieldXPlatform textFieldXPlatform3 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyleWithVariant(30, false));
/*  43 */     table.add((Actor)textFieldXPlatform3).size(400.0F, 56.0F).padBottom(8.0F).row();
/*     */ 
/*     */     
/*  46 */     (label2 = new Label(Game.i.localeManager.i18n.get("email_filed_pro_tip"), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*  47 */     label2.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  48 */     label2.setAlignment(1);
/*  49 */     table.add((Actor)label2).minWidth(1200.0F).growX().padBottom(8.0F).row();
/*     */     
/*  51 */     LabelButton labelButton2 = new LabelButton(Game.i.localeManager.i18n.get("why_account_link"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.WHY_ACCOUNT_URL));
/*     */ 
/*     */     
/*  54 */     table.add((Actor)labelButton2).height(48.0F).padBottom(16.0F).row();
/*     */     
/*     */     Label label1;
/*  57 */     (label1 = new Label(Game.i.localeManager.i18n.get("invite_code") + str, Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  58 */     table.add((Actor)label1).height(64.0F).row();
/*     */     
/*  60 */     TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/*  61 */     table.add((Actor)textFieldXPlatform1).size(400.0F, 56.0F).padBottom(8.0F).row();
/*     */ 
/*     */     
/*  64 */     (label1 = new Label(Game.i.localeManager.i18n.get("invite_code_sign_up_hint"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  65 */     label1.setAlignment(1);
/*  66 */     label1.setWrap(true);
/*  67 */     table.add((Actor)label1).fillX().row();
/*     */     
/*  69 */     this
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
/* 127 */       .a = (new FancyButton("regularButton.b", () -> { String str1 = paramTextFieldXPlatform1.getText(); String str2 = paramTextFieldXPlatform2.getText().trim(); String str3 = paramTextFieldXPlatform3.getText().trim(); if (str1.length() < 3) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("nickname_is_too_short")); return; }  Pattern pattern; if (!(pattern = Pattern.compile("^[a-zA-Z0-9_]+$")).matcher(str1).matches()) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("nickname_is_invalid")); return; }  if (str2.length() != 0 && !StringFormatter.VALID_EMAIL_ADDRESS_REGEX.matcher(str2).matches()) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("email_is_invalid")); return; }  this.a.label.setText(Game.i.localeManager.i18n.get("signing_up...")); a(); Game.i.authManager.signUpWithSteam(str1, str2, str3, ()); })).withLabel(30, Game.i.localeManager.i18n.get("sign_up"));
/* 128 */     table.add((Actor)this.a).size(400.0F, 64.0F).padTop(16.0F).row();
/*     */     
/* 130 */     LabelButton labelButton1 = new LabelButton(Game.i.localeManager.i18n.get("privacy_policy"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.PRIVACY_POLICY_URL));
/* 131 */     table.add((Actor)labelButton1).height(32.0F).padTop(32.0F).padBottom(16.0F).row();
/*     */     
/* 133 */     labelButton1 = new LabelButton(Game.i.localeManager.i18n.get("terms_and_conditions"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.TERMS_AND_CONDITIONS_URL));
/* 134 */     table.add((Actor)labelButton1).height(32.0F).padBottom(40.0F);
/*     */   }
/*     */   
/*     */   private void a() {
/* 138 */     this.a.setEnabled(false);
/*     */   }
/*     */   
/*     */   private void b() {
/* 142 */     this.a.label.setText(Game.i.localeManager.i18n.get("sign_up"));
/* 143 */     this.a.setEnabled(true);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\AccountSignUpSteamScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */