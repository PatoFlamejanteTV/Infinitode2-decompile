/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
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
/*     */ public class Label
/*     */   extends Widget
/*     */ {
/*  34 */   private static final Color tempColor = new Color();
/*  35 */   private static final GlyphLayout prefSizeLayout = new GlyphLayout();
/*     */   
/*     */   private LabelStyle style;
/*  38 */   private final GlyphLayout layout = new GlyphLayout();
/*     */   private float prefWidth;
/*  40 */   private final StringBuilder text = new StringBuilder(); private float prefHeight;
/*  41 */   private int intValue = Integer.MIN_VALUE;
/*     */   private BitmapFontCache cache;
/*  43 */   private int labelAlign = 8;
/*  44 */   private int lineAlign = 8;
/*     */   private boolean wrap;
/*     */   private float lastPrefHeight;
/*     */   private boolean prefSizeInvalid = true;
/*  48 */   private float fontScaleX = 1.0F; private float fontScaleY = 1.0F; private boolean fontScaleChanged = false;
/*     */   @Null
/*     */   private String ellipsis;
/*     */   
/*     */   public Label(@Null CharSequence paramCharSequence, Skin paramSkin) {
/*  53 */     this(paramCharSequence, paramSkin.<LabelStyle>get(LabelStyle.class));
/*     */   }
/*     */   
/*     */   public Label(@Null CharSequence paramCharSequence, Skin paramSkin, String paramString) {
/*  57 */     this(paramCharSequence, paramSkin.<LabelStyle>get(paramString, LabelStyle.class));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Label(@Null CharSequence paramCharSequence, Skin paramSkin, String paramString, Color paramColor) {
/*  63 */     this(paramCharSequence, new LabelStyle(paramSkin.getFont(paramString), paramColor));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Label(@Null CharSequence paramCharSequence, Skin paramSkin, String paramString1, String paramString2) {
/*  69 */     this(paramCharSequence, new LabelStyle(paramSkin.getFont(paramString1), paramSkin.getColor(paramString2)));
/*     */   }
/*     */   
/*     */   public Label(@Null CharSequence paramCharSequence, LabelStyle paramLabelStyle) {
/*  73 */     if (paramCharSequence != null) this.text.append(paramCharSequence); 
/*  74 */     setStyle(paramLabelStyle);
/*  75 */     if (paramCharSequence != null && paramCharSequence.length() > 0) setSize(getPrefWidth(), getPrefHeight()); 
/*     */   }
/*     */   
/*     */   public void setStyle(LabelStyle paramLabelStyle) {
/*  79 */     if (paramLabelStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  80 */     if (paramLabelStyle.font == null) throw new IllegalArgumentException("Missing LabelStyle font."); 
/*  81 */     this.style = paramLabelStyle;
/*     */     
/*  83 */     this.cache = paramLabelStyle.font.newFontCache();
/*  84 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LabelStyle getStyle() {
/*  90 */     return this.style;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setText(int paramInt) {
/*  97 */     if (this.intValue == paramInt) return false; 
/*  98 */     this.text.clear();
/*  99 */     this.text.append(paramInt);
/* 100 */     this.intValue = paramInt;
/* 101 */     invalidateHierarchy();
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setText(@Null CharSequence paramCharSequence) {
/* 107 */     if (paramCharSequence == null) {
/* 108 */       if (this.text.length == 0)
/* 109 */         return;  this.text.clear();
/* 110 */     } else if (paramCharSequence instanceof StringBuilder) {
/* 111 */       if (this.text.equals(paramCharSequence))
/* 112 */         return;  this.text.clear();
/* 113 */       this.text.append((StringBuilder)paramCharSequence);
/*     */     } else {
/* 115 */       if (textEquals(paramCharSequence))
/* 116 */         return;  this.text.clear();
/* 117 */       this.text.append(paramCharSequence);
/*     */     } 
/* 119 */     this.intValue = Integer.MIN_VALUE;
/* 120 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public boolean textEquals(CharSequence paramCharSequence) {
/* 124 */     int i = this.text.length;
/* 125 */     char[] arrayOfChar = this.text.chars;
/* 126 */     if (i != paramCharSequence.length()) return false; 
/* 127 */     for (byte b = 0; b < i; b++) {
/* 128 */       if (arrayOfChar[b] != paramCharSequence.charAt(b)) return false; 
/* 129 */     }  return true;
/*     */   }
/*     */   
/*     */   public StringBuilder getText() {
/* 133 */     return this.text;
/*     */   }
/*     */   
/*     */   public void invalidate() {
/* 137 */     super.invalidate();
/* 138 */     this.prefSizeInvalid = true;
/*     */   }
/*     */   
/*     */   private void scaleAndComputePrefSize() {
/*     */     BitmapFont bitmapFont;
/* 143 */     float f1 = (bitmapFont = this.cache.getFont()).getScaleX();
/* 144 */     float f2 = bitmapFont.getScaleY();
/* 145 */     if (this.fontScaleChanged) bitmapFont.getData().setScale(this.fontScaleX, this.fontScaleY);
/*     */     
/* 147 */     computePrefSize(prefSizeLayout);
/*     */     
/* 149 */     if (this.fontScaleChanged) bitmapFont.getData().setScale(f1, f2); 
/*     */   }
/*     */   
/*     */   protected void computePrefSize(GlyphLayout paramGlyphLayout) {
/* 153 */     this.prefSizeInvalid = false;
/* 154 */     if (this.wrap && this.ellipsis == null) {
/* 155 */       float f = getWidth();
/* 156 */       if (this.style.background != null)
/*     */       {
/* 158 */         f = Math.max(f, this.style.background.getMinWidth()) - this.style.background.getLeftWidth() - this.style.background.getRightWidth();
/*     */       }
/* 160 */       paramGlyphLayout.setText(this.cache.getFont(), (CharSequence)this.text, Color.WHITE, f, 8, true);
/*     */     } else {
/* 162 */       paramGlyphLayout.setText(this.cache.getFont(), (CharSequence)this.text);
/* 163 */     }  this.prefWidth = paramGlyphLayout.width;
/* 164 */     this.prefHeight = paramGlyphLayout.height;
/*     */   }
/*     */   public void layout() {
/*     */     float f7, f8;
/*     */     BitmapFont bitmapFont;
/* 169 */     float f1 = (bitmapFont = this.cache.getFont()).getScaleX();
/* 170 */     float f2 = bitmapFont.getScaleY();
/* 171 */     if (this.fontScaleChanged) bitmapFont.getData().setScale(this.fontScaleX, this.fontScaleY); 
/*     */     boolean bool;
/*     */     float f3;
/* 174 */     if ((bool = (this.wrap && this.ellipsis == null) ? true : false) && (
/*     */       
/* 176 */       f3 = getPrefHeight()) != this.lastPrefHeight) {
/* 177 */       this.lastPrefHeight = f3;
/* 178 */       invalidateHierarchy();
/*     */     } 
/*     */ 
/*     */     
/* 182 */     f3 = getWidth(); float f4 = getHeight();
/* 183 */     Drawable drawable = this.style.background;
/* 184 */     float f5 = 0.0F, f6 = 0.0F;
/* 185 */     if (drawable != null) {
/* 186 */       f5 = drawable.getLeftWidth();
/* 187 */       f6 = drawable.getBottomHeight();
/* 188 */       f3 -= drawable.getLeftWidth() + drawable.getRightWidth();
/* 189 */       f4 -= drawable.getBottomHeight() + drawable.getTopHeight();
/*     */     } 
/*     */     
/* 192 */     GlyphLayout glyphLayout = this.layout;
/*     */     
/* 194 */     if (bool || this.text.indexOf("\n") != -1) {
/*     */       
/* 196 */       glyphLayout.setText(bitmapFont, (CharSequence)this.text, 0, this.text.length, Color.WHITE, f3, this.lineAlign, bool, this.ellipsis);
/* 197 */       f7 = glyphLayout.width;
/* 198 */       f8 = glyphLayout.height;
/*     */       
/* 200 */       if ((this.labelAlign & 0x8) == 0)
/* 201 */         if ((this.labelAlign & 0x10) != 0) {
/* 202 */           f5 += f3 - f7;
/*     */         } else {
/* 204 */           f5 += (f3 - f7) / 2.0F;
/*     */         }  
/*     */     } else {
/* 207 */       f7 = f3;
/* 208 */       f8 = (bitmapFont.getData()).capHeight;
/*     */     } 
/*     */     
/* 211 */     if ((this.labelAlign & 0x2) != 0) {
/*     */       
/* 213 */       f6 = (f6 = f6 + (this.cache.getFont().isFlipped() ? 0.0F : (f4 - f8))) + this.style.font.getDescent();
/* 214 */     } else if ((this.labelAlign & 0x4) != 0) {
/*     */       
/* 216 */       f6 = (f6 = f6 + (this.cache.getFont().isFlipped() ? (f4 - f8) : 0.0F)) - this.style.font.getDescent();
/*     */     } else {
/* 218 */       f6 += (f4 - f8) / 2.0F;
/*     */     } 
/* 220 */     if (!this.cache.getFont().isFlipped()) f6 += f8;
/*     */     
/* 222 */     glyphLayout.setText(bitmapFont, (CharSequence)this.text, 0, this.text.length, Color.WHITE, f7, this.lineAlign, bool, this.ellipsis);
/* 223 */     this.cache.setText(glyphLayout, f5, f6);
/*     */     
/* 225 */     if (this.fontScaleChanged) bitmapFont.getData().setScale(f1, f2); 
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 229 */     validate();
/*     */     Color color;
/* 231 */     (color = tempColor.set(getColor())).a *= paramFloat;
/* 232 */     if (this.style.background != null) {
/* 233 */       paramBatch.setColor(color.r, color.g, color.b, color.a);
/* 234 */       this.style.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
/*     */     } 
/* 236 */     if (this.style.fontColor != null) color.mul(this.style.fontColor); 
/* 237 */     this.cache.tint(color);
/* 238 */     this.cache.setPosition(getX(), getY());
/* 239 */     this.cache.draw(paramBatch);
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 243 */     if (this.wrap) return 0.0F; 
/* 244 */     if (this.prefSizeInvalid) scaleAndComputePrefSize(); 
/* 245 */     float f = this.prefWidth;
/*     */     Drawable drawable;
/* 247 */     if ((drawable = this.style.background) != null)
/* 248 */       f = Math.max(f + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth()); 
/* 249 */     return f;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 253 */     if (this.prefSizeInvalid) scaleAndComputePrefSize(); 
/* 254 */     float f = 1.0F;
/* 255 */     if (this.fontScaleChanged) f = this.fontScaleY / this.style.font.getScaleY(); 
/* 256 */     f = this.prefHeight - this.style.font.getDescent() * f * 2.0F;
/*     */     Drawable drawable;
/* 258 */     if ((drawable = this.style.background) != null)
/* 259 */       f = Math.max(f + drawable.getTopHeight() + drawable.getBottomHeight(), drawable.getMinHeight()); 
/* 260 */     return f;
/*     */   }
/*     */   
/*     */   public GlyphLayout getGlyphLayout() {
/* 264 */     return this.layout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWrap(boolean paramBoolean) {
/* 275 */     this.wrap = paramBoolean;
/* 276 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public boolean getWrap() {
/* 280 */     return this.wrap;
/*     */   }
/*     */   
/*     */   public int getLabelAlign() {
/* 284 */     return this.labelAlign;
/*     */   }
/*     */   
/*     */   public int getLineAlign() {
/* 288 */     return this.lineAlign;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 295 */     setAlignment(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(int paramInt1, int paramInt2) {
/* 302 */     this.labelAlign = paramInt1;
/*     */     
/* 304 */     if ((paramInt2 & 0x8) != 0) {
/* 305 */       this.lineAlign = 8;
/* 306 */     } else if ((paramInt2 & 0x10) != 0) {
/* 307 */       this.lineAlign = 16;
/*     */     } else {
/* 309 */       this.lineAlign = 1;
/*     */     } 
/* 311 */     invalidate();
/*     */   }
/*     */   
/*     */   public void setFontScale(float paramFloat) {
/* 315 */     setFontScale(paramFloat, paramFloat);
/*     */   }
/*     */   
/*     */   public void setFontScale(float paramFloat1, float paramFloat2) {
/* 319 */     this.fontScaleChanged = true;
/* 320 */     this.fontScaleX = paramFloat1;
/* 321 */     this.fontScaleY = paramFloat2;
/* 322 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public float getFontScaleX() {
/* 326 */     return this.fontScaleX;
/*     */   }
/*     */   
/*     */   public void setFontScaleX(float paramFloat) {
/* 330 */     setFontScale(paramFloat, this.fontScaleY);
/*     */   }
/*     */   
/*     */   public float getFontScaleY() {
/* 334 */     return this.fontScaleY;
/*     */   }
/*     */   
/*     */   public void setFontScaleY(float paramFloat) {
/* 338 */     setFontScale(this.fontScaleX, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEllipsis(@Null String paramString) {
/* 344 */     this.ellipsis = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEllipsis(boolean paramBoolean) {
/* 350 */     if (paramBoolean) {
/* 351 */       this.ellipsis = "..."; return;
/*     */     } 
/* 353 */     this.ellipsis = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected BitmapFontCache getBitmapFontCache() {
/* 358 */     return this.cache;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 363 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 366 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 367 */     return ((str.indexOf('$') != -1) ? "Label " : "") + str + ": " + this.text;
/*     */   }
/*     */   
/*     */   public static class LabelStyle
/*     */   {
/*     */     public BitmapFont font;
/*     */     @Null
/*     */     public Color fontColor;
/*     */     @Null
/*     */     public Drawable background;
/*     */     
/*     */     public LabelStyle() {}
/*     */     
/*     */     public LabelStyle(BitmapFont param1BitmapFont, @Null Color param1Color) {
/* 381 */       this.font = param1BitmapFont;
/* 382 */       this.fontColor = param1Color;
/*     */     }
/*     */     
/*     */     public LabelStyle(LabelStyle param1LabelStyle) {
/* 386 */       this.font = param1LabelStyle.font;
/* 387 */       if (param1LabelStyle.fontColor != null) this.fontColor = new Color(param1LabelStyle.fontColor); 
/* 388 */       this.background = param1LabelStyle.background;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Label.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */