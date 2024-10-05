/*    */ package com.prineside.tdi2.scene2d.ui;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.ui.actors.Label;
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
/*    */ public class TextTooltip
/*    */   extends Tooltip<Label>
/*    */ {
/*    */   public TextTooltip(@Null String paramString, TextTooltipStyle paramTextTooltipStyle) {
/* 27 */     this(paramString, TooltipManager.getInstance(), paramTextTooltipStyle);
/*    */   }
/*    */   
/*    */   public TextTooltip(@Null String paramString, TooltipManager paramTooltipManager, TextTooltipStyle paramTextTooltipStyle) {
/* 31 */     super(null, paramTooltipManager);
/*    */     
/* 33 */     this.a.setActor(a(paramString, paramTextTooltipStyle.label));
/*    */     
/* 35 */     setStyle(paramTextTooltipStyle);
/*    */   }
/*    */   
/*    */   private static Label a(String paramString, Label.LabelStyle paramLabelStyle) {
/* 39 */     return new Label(paramString, paramLabelStyle);
/*    */   }
/*    */   
/*    */   public void setStyle(TextTooltipStyle paramTextTooltipStyle) {
/* 43 */     if (paramTextTooltipStyle == null) throw new NullPointerException("style cannot be null"); 
/* 44 */     this.a.setBackground(paramTextTooltipStyle.background);
/* 45 */     this.a.maxWidth(paramTextTooltipStyle.wrapWidth);
/*    */     
/* 47 */     boolean bool = (paramTextTooltipStyle.wrapWidth != 0.0F) ? true : false;
/* 48 */     this.a.fill(bool);
/*    */     
/*    */     Label label;
/* 51 */     (label = this.a.getActor()).setStyle(paramTextTooltipStyle.label);
/* 52 */     label.setWrap(bool);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class TextTooltipStyle
/*    */   {
/*    */     public Label.LabelStyle label;
/*    */     
/*    */     @Null
/*    */     public Drawable background;
/*    */     public float wrapWidth;
/*    */     
/*    */     public TextTooltipStyle() {}
/*    */     
/*    */     public TextTooltipStyle(Label.LabelStyle param1LabelStyle, @Null Drawable param1Drawable) {
/* 67 */       this.label = param1LabelStyle;
/* 68 */       this.background = param1Drawable;
/*    */     }
/*    */     
/*    */     public TextTooltipStyle(TextTooltipStyle param1TextTooltipStyle) {
/* 72 */       this.label = new Label.LabelStyle(param1TextTooltipStyle.label);
/* 73 */       this.background = param1TextTooltipStyle.background;
/* 74 */       this.wrapWidth = param1TextTooltipStyle.wrapWidth;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\TextTooltip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */