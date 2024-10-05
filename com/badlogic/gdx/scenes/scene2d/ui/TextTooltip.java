/*    */ package com.badlogic.gdx.scenes.scene2d.ui;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*    */ import com.badlogic.gdx.utils.Null;
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
/*    */ public class TextTooltip
/*    */   extends Tooltip<Label>
/*    */ {
/*    */   public TextTooltip(@Null String paramString, Skin paramSkin) {
/* 27 */     this(paramString, TooltipManager.getInstance(), paramSkin.<TextTooltipStyle>get(TextTooltipStyle.class));
/*    */   }
/*    */   
/*    */   public TextTooltip(@Null String paramString1, Skin paramSkin, String paramString2) {
/* 31 */     this(paramString1, TooltipManager.getInstance(), paramSkin.<TextTooltipStyle>get(paramString2, TextTooltipStyle.class));
/*    */   }
/*    */   
/*    */   public TextTooltip(@Null String paramString, TextTooltipStyle paramTextTooltipStyle) {
/* 35 */     this(paramString, TooltipManager.getInstance(), paramTextTooltipStyle);
/*    */   }
/*    */   
/*    */   public TextTooltip(@Null String paramString, TooltipManager paramTooltipManager, Skin paramSkin) {
/* 39 */     this(paramString, paramTooltipManager, paramSkin.<TextTooltipStyle>get(TextTooltipStyle.class));
/*    */   }
/*    */   
/*    */   public TextTooltip(@Null String paramString1, TooltipManager paramTooltipManager, Skin paramSkin, String paramString2) {
/* 43 */     this(paramString1, paramTooltipManager, paramSkin.<TextTooltipStyle>get(paramString2, TextTooltipStyle.class));
/*    */   }
/*    */   
/*    */   public TextTooltip(@Null String paramString, TooltipManager paramTooltipManager, TextTooltipStyle paramTextTooltipStyle) {
/* 47 */     super(null, paramTooltipManager);
/*    */     
/* 49 */     this.container.setActor(newLabel(paramString, paramTextTooltipStyle.label));
/*    */     
/* 51 */     setStyle(paramTextTooltipStyle);
/*    */   }
/*    */   
/*    */   protected Label newLabel(String paramString, Label.LabelStyle paramLabelStyle) {
/* 55 */     return new Label(paramString, paramLabelStyle);
/*    */   }
/*    */   
/*    */   public void setStyle(TextTooltipStyle paramTextTooltipStyle) {
/* 59 */     if (paramTextTooltipStyle == null) throw new NullPointerException("style cannot be null"); 
/* 60 */     this.container.setBackground(paramTextTooltipStyle.background);
/* 61 */     this.container.maxWidth(paramTextTooltipStyle.wrapWidth);
/*    */     
/* 63 */     boolean bool = (paramTextTooltipStyle.wrapWidth != 0.0F) ? true : false;
/* 64 */     this.container.fill(bool);
/*    */     
/*    */     Label label;
/* 67 */     (label = this.container.getActor()).setStyle(paramTextTooltipStyle.label);
/* 68 */     label.setWrap(bool);
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
/* 83 */       this.label = param1LabelStyle;
/* 84 */       this.background = param1Drawable;
/*    */     }
/*    */     
/*    */     public TextTooltipStyle(TextTooltipStyle param1TextTooltipStyle) {
/* 88 */       this.label = new Label.LabelStyle(param1TextTooltipStyle.label);
/* 89 */       this.background = param1TextTooltipStyle.background;
/* 90 */       this.wrapWidth = param1TextTooltipStyle.wrapWidth;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\TextTooltip.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */