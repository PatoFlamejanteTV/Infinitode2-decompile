/*    */ package com.prineside.tdi2.screens.account;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.ui.Table;
/*    */ import com.prineside.tdi2.ui.actors.FancyButton;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*    */ import com.prineside.tdi2.ui.shared.Notifications;
/*    */ 
/*    */ public class AccountSetPasswordScreen extends GenericAccountScreen {
/*    */   private FancyButton a;
/*    */   
/*    */   public AccountSetPasswordScreen() {
/* 15 */     super(Game.i.localeManager.i18n.get("account_screen_title_set_password"), AccountScreen::goToScreen);
/*    */     
/* 17 */     Table table = new Table();
/* 18 */     this.uiLayer.getTable().add((Actor)table).row();
/*    */     
/*    */     Label label;
/* 21 */     (label = new Label(Game.i.localeManager.i18n.get("password"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 22 */     table.add((Actor)label).height(64.0F).row();
/*    */     
/*    */     TextFieldXPlatform textFieldXPlatform2;
/* 25 */     (textFieldXPlatform2 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30))).setPasswordMode(true);
/* 26 */     textFieldXPlatform2.setPasswordCharacter('*');
/* 27 */     table.add((Actor)textFieldXPlatform2).size(320.0F, 56.0F).row();
/*    */ 
/*    */     
/* 30 */     (label = new Label(Game.i.localeManager.i18n.get("repeat_password"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 31 */     table.add((Actor)label).height(64.0F).row();
/*    */     
/*    */     TextFieldXPlatform textFieldXPlatform1;
/* 34 */     (textFieldXPlatform1 = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyleWithVariant(30, false))).setPasswordMode(true);
/* 35 */     textFieldXPlatform1.setPasswordCharacter('*');
/* 36 */     table.add((Actor)textFieldXPlatform1).size(320.0F, 56.0F).row();
/*    */     
/* 38 */     this
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
/* 57 */       .a = (new FancyButton("regularButton.a", () -> { String str1 = paramTextFieldXPlatform1.getText().trim(); String str2 = paramTextFieldXPlatform2.getText().trim(); if (!str1.equals(str2)) { Notifications.i().addFailure(Game.i.localeManager.i18n.get("passwords_do_not_match")); return; }  a(); Game.i.authManager.setPassword(str1, ()); })).withLabel(30, Game.i.localeManager.i18n.get("account_screen_title_set_password"));
/* 58 */     table.add((Actor)this.a).size(320.0F, 64.0F).padTop(16.0F).row();
/*    */   }
/*    */   
/*    */   private void a() {
/* 62 */     this.a.setEnabled(false);
/*    */   }
/*    */   
/*    */   private void b() {
/* 66 */     this.a.setEnabled(true);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\AccountSetPasswordScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */