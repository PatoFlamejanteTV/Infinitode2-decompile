/*     */ package com.prineside.tdi2.screens.account;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class AccountSignUpScreen extends GenericAccountScreen {
/*     */   private FancyButton a;
/*     */   
/*     */   public AccountSignUpScreen() {
/*  25 */     super(Game.i.localeManager.i18n.get("sign_up"), AccountScreen::goToScreen);
/*     */     
/*  27 */     Table table1 = new Table();
/*  28 */     this.uiLayer.getTable().add((Actor)table1).row();
/*     */     
/*  30 */     Table table2 = new Table();
/*  31 */     table1.add((Actor)table2).colspan(2).height(64.0F).minWidth(1.0F).padTop(16.0F).padBottom(32.0F).row();
/*     */     
/*  33 */     if (Game.i.actionResolver.hasGoogleAuth()) {
/*     */       
/*  35 */       RectButton rectButton = AccountScreen.createGoogleSignInButton(this::a, this::b, true);
/*  36 */       table2.add((Actor)rectButton).size(320.0F, 64.0F);
/*     */     } 
/*  38 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*  39 */       if (Game.i.actionResolver.hasGoogleAuth()) {
/*  40 */         table2.add().height(1.0F).width(16.0F);
/*     */       }
/*  42 */       RectButton rectButton = AccountScreen.createSteamSignInButton(this::a, this::b, true);
/*  43 */       table2.add((Actor)rectButton).size(320.0F, 64.0F);
/*     */     } 
/*     */     
/*  46 */     String str = Game.i.localeManager.i18n.get("optional");
/*  47 */     str = " (" + str.toLowerCase(Locale.US) + ")";
/*     */     
/*     */     Label label;
/*  50 */     (label = new Label(Game.i.localeManager.i18n.get("nickname"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  51 */     table1.add((Actor)label).size(320.0F, 48.0F).colspan(2).padBottom(8.0F).row();
/*     */     
/*  53 */     TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/*  54 */     table1.add((Actor)textFieldXPlatform2).size(320.0F, 56.0F).colspan(2).padBottom(16.0F).row();
/*     */ 
/*     */     
/*  57 */     (label = new Label(Game.i.localeManager.i18n.get("email") + str, Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  58 */     table1.add((Actor)label).size(320.0F, 48.0F).colspan(2).padBottom(8.0F).row();
/*     */     
/*  60 */     TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyleWithVariant(30, false));
/*  61 */     table1.add((Actor)textFieldXPlatform1).size(320.0F, 56.0F).colspan(2).padBottom(16.0F).row();
/*     */ 
/*     */     
/*  64 */     (label = new Label(Game.i.localeManager.i18n.get("email_filed_pro_tip"), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*  65 */     label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  66 */     label.setAlignment(1);
/*  67 */     table1.add((Actor)label).growX().minWidth(1200.0F).colspan(2).padBottom(8.0F).row();
/*     */ 
/*     */     
/*  70 */     (label = new Label(Game.i.localeManager.i18n.get("password"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  71 */     label.setAlignment(1);
/*  72 */     table1.add((Actor)label).size(320.0F, 48.0F).right().padRight(24.0F).padBottom(8.0F);
/*     */ 
/*     */     
/*  75 */     (label = new Label(Game.i.localeManager.i18n.get("repeat_password"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  76 */     label.setAlignment(1);
/*  77 */     table1.add((Actor)label).size(320.0F, 48.0F).left().padBottom(8.0F).row();
/*     */     
/*     */     TextFieldXPlatform textFieldXPlatform3;
/*  80 */     (textFieldXPlatform3 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyleWithVariant(30, false))).setPasswordMode(true);
/*  81 */     textFieldXPlatform3.setPasswordCharacter('*');
/*  82 */     table1.add((Actor)textFieldXPlatform3).size(320.0F, 56.0F).padBottom(16.0F).padRight(24.0F).right();
/*     */     
/*     */     TextFieldXPlatform textFieldXPlatform4;
/*  85 */     (textFieldXPlatform4 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30))).setPasswordMode(true);
/*  86 */     textFieldXPlatform4.setPasswordCharacter('*');
/*  87 */     table1.add((Actor)textFieldXPlatform4).size(320.0F, 56.0F).padBottom(16.0F).left().row();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     (label = new Label(Game.i.localeManager.i18n.get("invite_code") + " (" + Game.i.localeManager.i18n.get("optional").toLowerCase(Locale.ENGLISH) + ")", Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  94 */     table1.add((Actor)label).height(64.0F).colspan(2).row();
/*     */     
/*  96 */     TextFieldXPlatform textFieldXPlatform5 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/*  97 */     table1.add((Actor)textFieldXPlatform5).size(320.0F, 56.0F).padBottom(8.0F).colspan(2).row();
/*     */ 
/*     */     
/* 100 */     (label = new Label(Game.i.localeManager.i18n.get("invite_code_sign_up_hint"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 101 */     label.setAlignment(1);
/* 102 */     label.setWrap(true);
/* 103 */     label.setWidth(600.0F);
/* 104 */     table1.add((Actor)label).width(600.0F).colspan(2).row();
/*     */     
/* 106 */     this
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
/* 175 */       .a = (new FancyButton("regularButton.a", () -> { String str1 = paramTextFieldXPlatform1.getText(); String str2 = paramTextFieldXPlatform2.getText(); String str3 = paramTextFieldXPlatform3.getText(); String str4 = paramTextFieldXPlatform4.getText().trim(); String str5 = paramTextFieldXPlatform5.getText().trim(); if (str1.length() < 3) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("nickname_is_too_short")); return; }  Pattern pattern; if (!(pattern = Pattern.compile("^[a-zA-Z0-9_]+$")).matcher(str1).matches()) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("nickname_is_invalid")); return; }  if (str2.length() < 6) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("password_is_too_short")); return; }  if (!str2.equals(str3)) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("passwords_do_not_match")); return; }  if (str4.length() != 0 && !StringFormatter.VALID_EMAIL_ADDRESS_REGEX.matcher(str4).matches()) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("email_is_invalid")); return; }  this.a.label.setText(Game.i.localeManager.i18n.get("signing_up...")); a(); Game.i.authManager.signUp(str1, str2, str4, str5, ()); })).withLabel(30, Game.i.localeManager.i18n.get("sign_up"));
/* 176 */     table1.add((Actor)this.a).size(320.0F, 64.0F).padTop(16.0F).colspan(2).row();
/*     */     
/* 178 */     LabelButton labelButton = new LabelButton(Game.i.localeManager.i18n.get("why_account_link"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.WHY_ACCOUNT_URL));
/* 179 */     table1.add((Actor)labelButton).height(40.0F).padTop(32.0F).padBottom(8.0F).colspan(2).row();
/*     */ 
/*     */     
/* 182 */     (labelButton = new LabelButton(Game.i.localeManager.i18n.get("privacy_policy"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.PRIVACY_POLICY_URL))).setAlignment(1);
/* 183 */     table1.add((Actor)labelButton).height(40.0F).padTop(8.0F).width(320.0F).right().padRight(20.0F).padBottom(16.0F);
/*     */ 
/*     */     
/* 186 */     (labelButton = new LabelButton(Game.i.localeManager.i18n.get("terms_and_conditions"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI(Config.TERMS_AND_CONDITIONS_URL))).setAlignment(1);
/* 187 */     table1.add((Actor)labelButton).height(40.0F).padTop(8.0F).width(320.0F).padLeft(20.0F).left().padBottom(16.0F);
/*     */   }
/*     */   
/*     */   private void a() {
/* 191 */     this.a.setEnabled(false);
/*     */   }
/*     */   
/*     */   private void b() {
/* 195 */     this.a.setEnabled(true);
/* 196 */     this.a.label.setText(Game.i.localeManager.i18n.get("sign_up"));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\AccountSignUpScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */