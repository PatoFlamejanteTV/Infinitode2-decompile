/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.prineside.tdi2.scene2d.ui.TextField;
/*    */ 
/*    */ public class TextFieldXPlatform
/*    */   extends TextField {
/*    */   public TextFieldXPlatform(String paramString, TextField.TextFieldStyle paramTextFieldStyle) {
/*  9 */     super(paramString, paramTextFieldStyle);
/* 10 */     e();
/*    */   }
/*    */   
/*    */   private void e() {
/* 14 */     if (((getStyle()).font.getData()).markupEnabled) {
/* 15 */       throw new IllegalArgumentException("font must have disabled markup");
/*    */     }
/*    */     
/* 18 */     Gdx.app.getType();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\TextFieldXPlatform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */