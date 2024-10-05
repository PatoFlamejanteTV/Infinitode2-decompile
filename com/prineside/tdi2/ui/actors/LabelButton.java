/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.enums.StaticSoundType;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.EventListener;
/*    */ import com.prineside.tdi2.scene2d.InputEvent;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
/*    */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ 
/*    */ public class LabelButton
/*    */   extends Label
/*    */ {
/* 17 */   public Color normalColor = MaterialColor.LIGHT_BLUE.P300;
/* 18 */   public Color hoverColor = Color.WHITE;
/*    */   private boolean j;
/*    */   @Null
/*    */   private Runnable k;
/*    */   
/*    */   public LabelButton(CharSequence paramCharSequence, Label.LabelStyle paramLabelStyle, @Null Runnable paramRunnable) {
/* 24 */     super(paramCharSequence, paramLabelStyle);
/*    */     
/* 26 */     this.k = paramRunnable;
/*    */     
/* 28 */     setColor(MaterialColor.LIGHT_BLUE.P300);
/*    */ 
/*    */ 
/*    */     
/* 32 */     setTouchable(Touchable.enabled);
/* 33 */     addListener((EventListener)new ClickListener(this)
/*    */         {
/*    */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 36 */             if (LabelButton.a(this.a) != null) {
/* 37 */               LabelButton.a(this.a).run();
/* 38 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*    */             } 
/*    */           }
/*    */ 
/*    */           
/*    */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 44 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*    */             
/* 46 */             if (param1Int == -1) {
/* 47 */               LabelButton.a(this.a, true);
/* 48 */               LabelButton.b(this.a);
/*    */             } 
/*    */           }
/*    */ 
/*    */           
/*    */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 54 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*    */             
/* 56 */             if (param1Int == -1) {
/* 57 */               LabelButton.a(this.a, false);
/* 58 */               LabelButton.b(this.a);
/*    */             } 
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   public void setClickHandler(@Null Runnable paramRunnable) {
/* 65 */     this.k = paramRunnable;
/*    */   }
/*    */   
/*    */   public void setColors(Color paramColor1, Color paramColor2) {
/* 69 */     this.normalColor = paramColor1;
/* 70 */     this.hoverColor = paramColor2;
/* 71 */     c();
/*    */   }
/*    */   
/*    */   private void c() {
/* 75 */     if (this.j) {
/* 76 */       setColor(this.hoverColor); return;
/*    */     } 
/* 78 */     setColor(this.normalColor);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\LabelButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */