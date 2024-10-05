/*    */ package com.prineside.tdi2.screens.account;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Threads;
/*    */ import com.prineside.tdi2.managers.AuthManager;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.ui.Table;
/*    */ import com.prineside.tdi2.ui.actors.FancyButton;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*    */ import com.prineside.tdi2.ui.shared.Dialog;
/*    */ import com.prineside.tdi2.ui.shared.Notifications;
/*    */ import java.util.Locale;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class AccountSignUpGoogleScreen
/*    */   extends GenericAccountScreen {
/*    */   private FancyButton a;
/*    */   
/*    */   public AccountSignUpGoogleScreen() {
/* 21 */     super(Game.i.localeManager.i18n.get("sign_up") + " / Google", AccountScreen::goToScreen);
/*    */     
/* 23 */     Table table = new Table();
/* 24 */     this.uiLayer.getTable().add((Actor)table).row();
/*    */     
/* 26 */     String str = Game.i.localeManager.i18n.get("optional");
/* 27 */     str = " (" + str.toLowerCase(Locale.US) + ")";
/*    */     
/*    */     Label label;
/*    */     
/* 31 */     (label = new Label(Game.i.localeManager.i18n.get("nickname"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 32 */     table.add((Actor)label).padBottom(8.0F).row();
/*    */     
/* 34 */     TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/* 35 */     table.add((Actor)textFieldXPlatform2).size(400.0F, 56.0F).padBottom(16.0F).row();
/*    */ 
/*    */     
/* 38 */     (label = new Label(Game.i.localeManager.i18n.get("invite_code") + str, Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 39 */     table.add((Actor)label).height(64.0F).row();
/*    */     
/* 41 */     TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyleWithVariant(30, false));
/* 42 */     table.add((Actor)textFieldXPlatform1).size(400.0F, 56.0F).padBottom(8.0F).row();
/*    */ 
/*    */     
/* 45 */     (label = new Label(Game.i.localeManager.i18n.get("invite_code_sign_up_hint"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 46 */     label.setAlignment(1);
/* 47 */     label.setWrap(true);
/* 48 */     table.add((Actor)label).fillX().row();
/*    */     
/* 50 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 90 */       .a = (new FancyButton("regularButton.a", () -> { String str1 = paramTextFieldXPlatform1.getText().trim(); String str2 = paramTextFieldXPlatform2.getText().trim(); if (str1.length() < 3) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("nickname_is_too_short")); return; }  Pattern pattern; if (!(pattern = Pattern.compile("^[a-zA-Z0-9_]+$")).matcher(str1).matches()) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("nickname_is_invalid")); return; }  this.a.label.setText(Game.i.localeManager.i18n.get("signing_up...")); a(); Game.i.authManager.signUpWithGoogle(str1, str2, ()); })).withLabel(30, Game.i.localeManager.i18n.get("sign_up"));
/* 91 */     table.add((Actor)this.a).size(320.0F, 64.0F).padTop(32.0F).padBottom(64.0F).row();
/*    */   }
/*    */   
/*    */   private void a() {
/* 95 */     this.a.setEnabled(false);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\AccountSignUpGoogleScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */