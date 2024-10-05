/*    */ package com.prineside.tdi2.screens.account;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.AuthManager;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.ui.Table;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.ui.actors.FancyButton;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*    */ import com.prineside.tdi2.ui.shared.Dialog;
/*    */ import com.prineside.tdi2.ui.shared.Notifications;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.StringFormatter;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class AccountPasswordResetScreen extends GenericAccountScreen {
/*    */   private FancyButton a;
/*    */   
/*    */   public AccountPasswordResetScreen() {
/* 20 */     super(Game.i.localeManager.i18n.get("reset_password"), AccountScreen::goToScreen);
/*    */     
/* 22 */     Table table = new Table();
/* 23 */     this.uiLayer.getTable().add((Actor)table).row();
/*    */     
/*    */     Label label;
/* 26 */     (label = new Label(Game.i.localeManager.i18n.get("email_or_nickname"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 27 */     table.add((Actor)label).height(64.0F).row();
/*    */     
/* 29 */     TextFieldXPlatform textFieldXPlatform = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/* 30 */     table.add((Actor)textFieldXPlatform).size(400.0F, 56.0F).row();
/*    */     
/* 32 */     this
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
/* 71 */       .a = (new FancyButton("regularButton.b", () -> { String str = paramTextFieldXPlatform.getText().trim(); if (!StringFormatter.VALID_EMAIL_ADDRESS_REGEX.matcher(str).matches()) { Pattern pattern; if (!(pattern = Pattern.compile("^[a-zA-Z0-9_]+$")).matcher(str).matches()) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("email_or_nickname_is_incorrect")); return; }  }  Notifications.i().add(Game.i.localeManager.i18n.get("requesting..."), (Drawable)Game.i.assetManager.getDrawable("icon-user"), MaterialColor.LIGHT_BLUE.P800, null); a(); Game.i.authManager.resetPassword(str, ()); })).withLabel(30, Game.i.localeManager.i18n.get("reset_password"));
/* 72 */     table.add((Actor)this.a).size(400.0F, 64.0F).padTop(16.0F).row();
/*    */   }
/*    */   
/*    */   private void a() {
/* 76 */     this.a.setEnabled(false);
/*    */   }
/*    */   
/*    */   private void b() {
/* 80 */     this.a.setEnabled(true);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\AccountPasswordResetScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */