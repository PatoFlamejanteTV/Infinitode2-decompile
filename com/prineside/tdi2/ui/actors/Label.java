/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.scene2d.ui.Widget;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Label
/*     */   extends Widget
/*     */ {
/*  20 */   private static final Color j = new Color();
/*  21 */   private static final GlyphLayout k = new GlyphLayout();
/*     */   
/*     */   private LabelStyle l;
/*  24 */   private final GlyphLayout m = new GlyphLayout();
/*     */   private float n;
/*  26 */   private final StringBuilder p = new StringBuilder(); private float o;
/*  27 */   private int q = Integer.MIN_VALUE;
/*     */   private BitmapFontCache r;
/*  29 */   private int s = 8;
/*  30 */   private int t = 8;
/*     */   private boolean u;
/*     */   private float v;
/*     */   private boolean w = true;
/*  34 */   private float x = 1.0F; private float y = 1.0F; private boolean z = false;
/*     */   @Null
/*     */   private String A;
/*     */   
/*     */   public Label(@Null CharSequence paramCharSequence, LabelStyle paramLabelStyle) {
/*     */     try {
/*  40 */       if (paramCharSequence != null) this.p.append(paramCharSequence); 
/*  41 */       setStyle(paramLabelStyle);
/*  42 */       if (paramCharSequence != null && paramCharSequence.length() > 0) setSize(getPrefWidth(), getPrefHeight());  return;
/*  43 */     } catch (Exception exception) {
/*  44 */       throw new IllegalStateException("Label creation failed, actor path:\n" + UiUtils.getFullPathToStage(this), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setStyle(LabelStyle paramLabelStyle) {
/*  49 */     if (paramLabelStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  50 */     if (paramLabelStyle.font == null) throw new IllegalArgumentException("Missing LabelStyle font."); 
/*  51 */     this.l = paramLabelStyle;
/*     */     
/*  53 */     this.r = paramLabelStyle.font.newFontCache();
/*  54 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LabelStyle getStyle() {
/*  60 */     return this.l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTextFromInt(int paramInt) {
/*  67 */     if (this.q == paramInt) return false; 
/*  68 */     this.p.clear();
/*  69 */     this.p.append(paramInt);
/*  70 */     this.q = paramInt;
/*  71 */     invalidateHierarchy();
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setText(@Null CharSequence paramCharSequence) {
/*  77 */     if (paramCharSequence == null) {
/*  78 */       if (this.p.length == 0)
/*  79 */         return;  this.p.clear();
/*  80 */     } else if (paramCharSequence instanceof StringBuilder) {
/*  81 */       if (this.p.equals(paramCharSequence))
/*  82 */         return;  this.p.clear();
/*  83 */       this.p.append((StringBuilder)paramCharSequence);
/*     */     } else {
/*  85 */       if (textEquals(paramCharSequence))
/*  86 */         return;  this.p.clear();
/*  87 */       this.p.append(paramCharSequence);
/*     */     } 
/*  89 */     this.q = Integer.MIN_VALUE;
/*  90 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public boolean textEquals(CharSequence paramCharSequence) {
/*  94 */     int i = this.p.length;
/*  95 */     char[] arrayOfChar = this.p.chars;
/*  96 */     if (i != paramCharSequence.length()) return false; 
/*  97 */     for (byte b = 0; b < i; b++) {
/*  98 */       if (arrayOfChar[b] != paramCharSequence.charAt(b)) return false; 
/*  99 */     }  return true;
/*     */   }
/*     */   
/*     */   public StringBuilder getText() {
/* 103 */     return this.p;
/*     */   }
/*     */   
/*     */   public void invalidate() {
/* 107 */     super.invalidate();
/* 108 */     this.w = true;
/*     */   }
/*     */   
/*     */   private void c() {
/*     */     BitmapFont bitmapFont;
/* 113 */     float f1 = (bitmapFont = this.r.getFont()).getScaleX();
/* 114 */     float f2 = bitmapFont.getScaleY();
/* 115 */     if (this.z) bitmapFont.getData().setScale(this.x, this.y);
/*     */     
/* 117 */     a(k);
/*     */     
/* 119 */     if (this.z) bitmapFont.getData().setScale(f1, f2); 
/*     */   }
/*     */   
/*     */   private void a(GlyphLayout paramGlyphLayout) {
/* 123 */     this.w = false;
/* 124 */     if (this.u && this.A == null) {
/* 125 */       float f = getWidth();
/* 126 */       if (this.l.background != null)
/*     */       {
/* 128 */         f = Math.max(f, this.l.background.getMinWidth()) - this.l.background.getLeftWidth() - this.l.background.getRightWidth();
/*     */       }
/* 130 */       paramGlyphLayout.setText(this.r.getFont(), (CharSequence)this.p, Color.WHITE, f, 8, true);
/*     */     } else {
/* 132 */       paramGlyphLayout.setText(this.r.getFont(), (CharSequence)this.p);
/* 133 */     }  this.n = paramGlyphLayout.width;
/* 134 */     this.o = paramGlyphLayout.height;
/*     */   }
/*     */   public void layout() {
/*     */     try {
/*     */       float f7, f8;
/*     */       BitmapFont bitmapFont;
/* 140 */       float f1 = (bitmapFont = this.r.getFont()).getScaleX();
/* 141 */       float f2 = bitmapFont.getScaleY();
/* 142 */       if (this.z) bitmapFont.getData().setScale(this.x, this.y); 
/*     */       boolean bool;
/*     */       float f3;
/* 145 */       if ((bool = (this.u && this.A == null) ? true : false) && (
/*     */         
/* 147 */         f3 = getPrefHeight()) != this.v) {
/* 148 */         this.v = f3;
/* 149 */         invalidateHierarchy();
/*     */       } 
/*     */ 
/*     */       
/* 153 */       f3 = getWidth(); float f4 = getHeight();
/* 154 */       Drawable drawable = this.l.background;
/* 155 */       float f5 = 0.0F, f6 = 0.0F;
/* 156 */       if (drawable != null) {
/* 157 */         f5 = drawable.getLeftWidth();
/* 158 */         f6 = drawable.getBottomHeight();
/* 159 */         f3 -= drawable.getLeftWidth() + drawable.getRightWidth();
/* 160 */         f4 -= drawable.getBottomHeight() + drawable.getTopHeight();
/*     */       } 
/*     */       
/* 163 */       GlyphLayout glyphLayout = this.m;
/*     */       
/* 165 */       if (bool || this.p.indexOf("\n") != -1) {
/*     */         
/* 167 */         glyphLayout.setText(bitmapFont, (CharSequence)this.p, 0, this.p.length, Color.WHITE, f3, this.t, bool, this.A);
/* 168 */         f7 = glyphLayout.width;
/* 169 */         f8 = glyphLayout.height;
/*     */         
/* 171 */         if ((this.s & 0x8) == 0)
/* 172 */           if ((this.s & 0x10) != 0) {
/* 173 */             f5 += f3 - f7;
/*     */           } else {
/* 175 */             f5 += (f3 - f7) / 2.0F;
/*     */           }  
/*     */       } else {
/* 178 */         f7 = f3;
/* 179 */         f8 = (bitmapFont.getData()).capHeight;
/*     */       } 
/*     */       
/* 182 */       if ((this.s & 0x2) != 0) {
/*     */         
/* 184 */         f6 = (f6 = f6 + (this.r.getFont().isFlipped() ? 0.0F : (f4 - f8))) + this.l.font.getDescent();
/* 185 */       } else if ((this.s & 0x4) != 0) {
/*     */         
/* 187 */         f6 = (f6 = f6 + (this.r.getFont().isFlipped() ? (f4 - f8) : 0.0F)) - this.l.font.getDescent();
/*     */       } else {
/* 189 */         f6 += (f4 - f8) / 2.0F;
/*     */       } 
/* 191 */       if (!this.r.getFont().isFlipped()) f6 += f8;
/*     */       
/* 193 */       glyphLayout.setText(bitmapFont, (CharSequence)this.p, 0, this.p.length, Color.WHITE, f7, this.t, bool, this.A);
/* 194 */       this.r.setText(glyphLayout, f5, f6);
/*     */       
/* 196 */       if (this.z) bitmapFont.getData().setScale(f1, f2);  return;
/* 197 */     } catch (Exception exception) {
/* 198 */       throw new IllegalStateException("Label.layout failed, actor path:\n" + UiUtils.getFullPathToStage(this), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 203 */     validate();
/*     */     Color color;
/* 205 */     (color = j.set(getColor())).a *= paramFloat;
/* 206 */     if (this.l.background != null) {
/* 207 */       paramBatch.setColor(color.r, color.g, color.b, color.a);
/* 208 */       this.l.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
/*     */     } 
/* 210 */     if (this.l.fontColor != null) color.mul(this.l.fontColor); 
/* 211 */     this.r.tint(color);
/* 212 */     this.r.setPosition(getX(), getY());
/* 213 */     this.r.draw(paramBatch);
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 217 */     if (this.u) return 0.0F; 
/* 218 */     if (this.w) c(); 
/* 219 */     float f = this.n;
/*     */     Drawable drawable;
/* 221 */     if ((drawable = this.l.background) != null)
/* 222 */       f = Math.max(f + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth()); 
/* 223 */     return f;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 227 */     if (this.w) c(); 
/* 228 */     float f = 1.0F;
/* 229 */     if (this.z) f = this.y / this.l.font.getScaleY(); 
/* 230 */     f = this.o - this.l.font.getDescent() * f * 2.0F;
/*     */     Drawable drawable;
/* 232 */     if ((drawable = this.l.background) != null)
/* 233 */       f = Math.max(f + drawable.getTopHeight() + drawable.getBottomHeight(), drawable.getMinHeight()); 
/* 234 */     return f;
/*     */   }
/*     */   
/*     */   public GlyphLayout getGlyphLayout() {
/* 238 */     return this.m;
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
/* 249 */     this.u = paramBoolean;
/* 250 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public boolean getWrap() {
/* 254 */     return this.u;
/*     */   }
/*     */   
/*     */   public int getLabelAlign() {
/* 258 */     return this.s;
/*     */   }
/*     */   
/*     */   public int getLineAlign() {
/* 262 */     return this.t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 269 */     setAlignmentSeparate(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignmentSeparate(int paramInt1, int paramInt2) {
/* 276 */     this.s = paramInt1;
/*     */     
/* 278 */     if ((paramInt2 & 0x8) != 0) {
/* 279 */       this.t = 8;
/* 280 */     } else if ((paramInt2 & 0x10) != 0) {
/* 281 */       this.t = 16;
/*     */     } else {
/* 283 */       this.t = 1;
/*     */     } 
/* 285 */     invalidate();
/*     */   }
/*     */   
/*     */   public void setFontScale(float paramFloat) {
/* 289 */     setFontScaleSeparate(paramFloat, paramFloat);
/*     */   }
/*     */   
/*     */   public void setFontScaleSeparate(float paramFloat1, float paramFloat2) {
/* 293 */     this.z = true;
/* 294 */     this.x = paramFloat1;
/* 295 */     this.y = paramFloat2;
/* 296 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public float getFontScaleX() {
/* 300 */     return this.x;
/*     */   }
/*     */   
/*     */   public void setFontScaleX(float paramFloat) {
/* 304 */     setFontScaleSeparate(paramFloat, this.y);
/*     */   }
/*     */   
/*     */   public float getFontScaleY() {
/* 308 */     return this.y;
/*     */   }
/*     */   
/*     */   public void setFontScaleY(float paramFloat) {
/* 312 */     setFontScaleSeparate(this.x, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEllipsisString(@Null String paramString) {
/* 318 */     this.A = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEllipsis(boolean paramBoolean) {
/* 324 */     if (paramBoolean) {
/* 325 */       this.A = "..."; return;
/*     */     } 
/* 327 */     this.A = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final BitmapFontCache b() {
/* 332 */     return this.r;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 337 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 340 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 341 */     return ((str.indexOf('$') != -1) ? "Label " : "") + str + ": " + this.p;
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
/* 355 */       this.font = param1BitmapFont;
/* 356 */       this.fontColor = param1Color;
/*     */     }
/*     */     
/*     */     public LabelStyle(LabelStyle param1LabelStyle) {
/* 360 */       this.font = param1LabelStyle.font;
/* 361 */       if (param1LabelStyle.fontColor != null) this.fontColor = new Color(param1LabelStyle.fontColor); 
/* 362 */       this.background = param1LabelStyle.background;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\Label.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */