/*      */ package com.badlogic.gdx.scenes.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*      */ import com.badlogic.gdx.scenes.scene2d.Event;
/*      */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*      */ import com.badlogic.gdx.scenes.scene2d.Group;
/*      */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*      */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*      */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Clipboard;
/*      */ import com.badlogic.gdx.utils.FloatArray;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.Pools;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TextField
/*      */   extends Widget
/*      */   implements Disableable
/*      */ {
/*      */   protected static final char BACKSPACE = '\b';
/*      */   protected static final char CARRIAGE_RETURN = '\r';
/*      */   protected static final char NEWLINE = '\n';
/*      */   protected static final char TAB = '\t';
/*      */   protected static final char DELETE = '';
/*      */   protected static final char BULLET = '';
/*   73 */   private static final Vector2 tmp1 = new Vector2();
/*   74 */   private static final Vector2 tmp2 = new Vector2();
/*   75 */   private static final Vector2 tmp3 = new Vector2();
/*      */   
/*   77 */   public static float keyRepeatInitialTime = 0.4F;
/*   78 */   public static float keyRepeatTime = 0.1F;
/*      */   protected String text;
/*      */   protected int cursor;
/*      */   protected int selectionStart;
/*      */   protected boolean hasSelection;
/*      */   protected boolean writeEnters;
/*   84 */   protected final GlyphLayout layout = new GlyphLayout();
/*   85 */   protected final FloatArray glyphPositions = new FloatArray(); TextFieldStyle style;
/*      */   private String messageText;
/*      */   protected CharSequence displayText;
/*      */   Clipboard clipboard;
/*      */   InputListener inputListener;
/*      */   @Null
/*      */   TextFieldListener listener;
/*      */   @Null
/*      */   TextFieldFilter filter;
/*   94 */   OnscreenKeyboard keyboard = new DefaultOnscreenKeyboard(); boolean focusTraversal = true; boolean onlyFontChars = true;
/*      */   boolean disabled;
/*   96 */   private int textHAlign = 8;
/*      */   private float selectionX;
/*      */   private float selectionWidth;
/*   99 */   String undoText = "";
/*      */   
/*      */   long lastChangeTime;
/*      */   boolean passwordMode;
/*      */   private StringBuilder passwordBuffer;
/*  104 */   private char passwordCharacter = ''; protected float fontOffset;
/*      */   protected float textHeight;
/*      */   protected float textOffset;
/*      */   float renderOffset;
/*      */   protected int visibleTextStart;
/*      */   protected int visibleTextEnd;
/*      */   private int maxLength;
/*      */   boolean focused;
/*      */   boolean cursorOn;
/*  113 */   float blinkTime = 0.32F;
/*  114 */   final Timer.Task blinkTask = new Timer.Task() {
/*      */       public void run() {
/*  116 */         if (TextField.this.getStage() == null) {
/*  117 */           cancel();
/*      */           return;
/*      */         } 
/*  120 */         TextField.this.cursorOn = !TextField.this.cursorOn;
/*  121 */         Gdx.graphics.requestRendering();
/*      */       }
/*      */     };
/*      */   
/*  125 */   final KeyRepeatTask keyRepeatTask = new KeyRepeatTask();
/*      */   boolean programmaticChangeEvents;
/*      */   
/*      */   public TextField(@Null String paramString, Skin paramSkin) {
/*  129 */     this(paramString, paramSkin.<TextFieldStyle>get(TextFieldStyle.class));
/*      */   }
/*      */   
/*      */   public TextField(@Null String paramString1, Skin paramSkin, String paramString2) {
/*  133 */     this(paramString1, paramSkin.<TextFieldStyle>get(paramString2, TextFieldStyle.class));
/*      */   }
/*      */   
/*      */   public TextField(@Null String paramString, TextFieldStyle paramTextFieldStyle) {
/*  137 */     setStyle(paramTextFieldStyle);
/*  138 */     this.clipboard = Gdx.app.getClipboard();
/*  139 */     initialize();
/*  140 */     setText(paramString);
/*  141 */     setSize(getPrefWidth(), getPrefHeight());
/*      */   }
/*      */   
/*      */   protected void initialize() {
/*  145 */     addListener((EventListener)(this.inputListener = createInputListener()));
/*      */   }
/*      */   
/*      */   protected InputListener createInputListener() {
/*  149 */     return (InputListener)new TextFieldClickListener();
/*      */   }
/*      */   
/*      */   protected int letterUnderCursor(float paramFloat) {
/*  153 */     paramFloat -= this.textOffset + this.fontOffset - (this.style.font.getData()).cursorX - this.glyphPositions.get(this.visibleTextStart);
/*      */     Drawable drawable;
/*  155 */     if ((drawable = getBackgroundDrawable()) != null) paramFloat -= this.style.background.getLeftWidth(); 
/*  156 */     int i = this.glyphPositions.size;
/*  157 */     float[] arrayOfFloat = this.glyphPositions.items;
/*  158 */     for (byte b = 1; b < i; b++) {
/*  159 */       if (arrayOfFloat[b] > paramFloat) {
/*  160 */         if (arrayOfFloat[b] - paramFloat <= paramFloat - arrayOfFloat[b - 1]) return b; 
/*  161 */         return b - 1;
/*      */       } 
/*      */     } 
/*  164 */     return i - 1;
/*      */   }
/*      */   
/*      */   protected boolean isWordCharacter(char paramChar) {
/*  168 */     return Character.isLetterOrDigit(paramChar);
/*      */   }
/*      */   
/*      */   protected int[] wordUnderCursor(int paramInt) {
/*      */     String str;
/*  173 */     int i = (str = this.text).length(), j = 0, k = paramInt;
/*  174 */     if (paramInt >= str.length()) {
/*  175 */       j = str.length();
/*  176 */       i = 0;
/*      */     } else {
/*  178 */       for (; k < i; k++) {
/*  179 */         if (!isWordCharacter(str.charAt(k))) {
/*  180 */           i = k;
/*      */           break;
/*      */         } 
/*      */       } 
/*  184 */       for (k = paramInt - 1; k >= 0; k--) {
/*  185 */         if (!isWordCharacter(str.charAt(k))) {
/*  186 */           j = k + 1;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*  191 */     return new int[] { j, i };
/*      */   }
/*      */   
/*      */   int[] wordUnderCursor(float paramFloat) {
/*  195 */     return wordUnderCursor(letterUnderCursor(paramFloat));
/*      */   }
/*      */   
/*      */   boolean withinMaxLength(int paramInt) {
/*  199 */     return (this.maxLength <= 0 || paramInt < this.maxLength);
/*      */   }
/*      */   
/*      */   public void setMaxLength(int paramInt) {
/*  203 */     this.maxLength = paramInt;
/*      */   }
/*      */   
/*      */   public int getMaxLength() {
/*  207 */     return this.maxLength;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOnlyFontChars(boolean paramBoolean) {
/*  214 */     this.onlyFontChars = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setStyle(TextFieldStyle paramTextFieldStyle) {
/*  218 */     if (paramTextFieldStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  219 */     this.style = paramTextFieldStyle;
/*      */     
/*  221 */     this.textHeight = paramTextFieldStyle.font.getCapHeight() - paramTextFieldStyle.font.getDescent() * 2.0F;
/*  222 */     if (this.text != null) updateDisplayText(); 
/*  223 */     invalidateHierarchy();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TextFieldStyle getStyle() {
/*  229 */     return this.style;
/*      */   }
/*      */   
/*      */   protected void calculateOffsets() {
/*  233 */     float f1 = getWidth();
/*      */     Drawable drawable;
/*  235 */     if ((drawable = getBackgroundDrawable()) != null) f1 -= drawable.getLeftWidth() + drawable.getRightWidth();
/*      */     
/*  237 */     int i = this.glyphPositions.size;
/*  238 */     float[] arrayOfFloat = this.glyphPositions.items;
/*      */ 
/*      */     
/*  241 */     this.cursor = MathUtils.clamp(this.cursor, 0, i - 1);
/*      */     float f2;
/*  243 */     if ((f2 = arrayOfFloat[Math.max(0, this.cursor - 1)] + this.renderOffset) <= 0.0F) {
/*  244 */       this.renderOffset -= f2;
/*      */     } else {
/*  246 */       int m = Math.min(i - 1, this.cursor + 1);
/*  247 */       float f = arrayOfFloat[m] - f1;
/*  248 */       if (-this.renderOffset < f) this.renderOffset = -f;
/*      */     
/*      */     } 
/*      */     
/*  252 */     f2 = 0.0F;
/*  253 */     float f3 = arrayOfFloat[i - 1];
/*  254 */     for (int j = i - 2; j >= 0; ) {
/*  255 */       float f = arrayOfFloat[j];
/*  256 */       if (f3 - f <= f1) {
/*  257 */         f2 = f; j--;
/*      */       } 
/*  259 */     }  if (-this.renderOffset > f2) this.renderOffset = -f2;
/*      */ 
/*      */     
/*  262 */     this.visibleTextStart = 0;
/*  263 */     float f4 = 0.0F; int k;
/*  264 */     for (k = 0; k < i; k++) {
/*  265 */       if (arrayOfFloat[k] >= -this.renderOffset) {
/*  266 */         this.visibleTextStart = k;
/*  267 */         f4 = arrayOfFloat[k];
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/*  273 */     k = this.visibleTextStart + 1;
/*  274 */     f2 = f1 - this.renderOffset;
/*  275 */     for (i = Math.min(this.displayText.length(), i); k <= i && 
/*  276 */       arrayOfFloat[k] <= f2; k++);
/*  277 */     this.visibleTextEnd = Math.max(0, k - 1);
/*      */     
/*  279 */     if ((this.textHAlign & 0x8) == 0) {
/*  280 */       this.textOffset = f1 - arrayOfFloat[this.visibleTextEnd] - this.fontOffset + f4;
/*  281 */       if ((this.textHAlign & 0x1) != 0) this.textOffset = Math.round(this.textOffset * 0.5F); 
/*      */     } else {
/*  283 */       this.textOffset = f4 + this.renderOffset;
/*      */     } 
/*      */     
/*  286 */     if (this.hasSelection) {
/*  287 */       i = Math.min(this.cursor, this.selectionStart);
/*  288 */       int m = Math.max(this.cursor, this.selectionStart);
/*  289 */       float f = Math.max(arrayOfFloat[i] - arrayOfFloat[this.visibleTextStart], -this.textOffset);
/*  290 */       f1 = Math.min(arrayOfFloat[m] - arrayOfFloat[this.visibleTextStart], f1 - this.textOffset);
/*  291 */       this.selectionX = f;
/*  292 */       this.selectionWidth = f1 - f - (this.style.font.getData()).cursorX;
/*      */     } 
/*      */   }
/*      */   @Null
/*      */   protected Drawable getBackgroundDrawable() {
/*  297 */     if (this.disabled && this.style.disabledBackground != null) return this.style.disabledBackground; 
/*  298 */     if (this.style.focusedBackground != null && hasKeyboardFocus()) return this.style.focusedBackground; 
/*  299 */     return this.style.background;
/*      */   }
/*      */   
/*      */   public void draw(Batch paramBatch, float paramFloat) {
/*      */     boolean bool;
/*  304 */     if ((bool = hasKeyboardFocus()) != this.focused || (bool && !this.blinkTask.isScheduled())) {
/*  305 */       this.focused = bool;
/*  306 */       this.blinkTask.cancel();
/*  307 */       this.cursorOn = bool;
/*  308 */       if (bool)
/*  309 */       { Timer.schedule(this.blinkTask, this.blinkTime, this.blinkTime); }
/*      */       else
/*  311 */       { this.keyRepeatTask.cancel(); } 
/*  312 */     } else if (!bool) {
/*  313 */       this.cursorOn = false;
/*      */     } 
/*  315 */     BitmapFont bitmapFont = this.style.font;
/*      */     
/*  317 */     Color color1 = (this.disabled && this.style.disabledFontColor != null) ? this.style.disabledFontColor : ((bool && this.style.focusedFontColor != null) ? this.style.focusedFontColor : this.style.fontColor);
/*  318 */     Drawable drawable1 = this.style.selection;
/*  319 */     Drawable drawable2 = this.style.cursor;
/*  320 */     Drawable drawable3 = getBackgroundDrawable();
/*      */     
/*  322 */     Color color2 = getColor();
/*  323 */     float f3 = getX();
/*  324 */     float f4 = getY();
/*  325 */     float f5 = getWidth();
/*  326 */     float f6 = getHeight();
/*      */     
/*  328 */     paramBatch.setColor(color2.r, color2.g, color2.b, color2.a * paramFloat);
/*  329 */     float f7 = 0.0F, f8 = 0.0F;
/*  330 */     if (drawable3 != null) {
/*  331 */       drawable3.draw(paramBatch, f3, f4, f5, f6);
/*  332 */       f7 = drawable3.getLeftWidth();
/*  333 */       f8 = drawable3.getRightWidth();
/*      */     } 
/*      */     
/*  336 */     float f2 = getTextY(bitmapFont, drawable3);
/*  337 */     calculateOffsets();
/*      */     
/*  339 */     if (bool && this.hasSelection && drawable1 != null) {
/*  340 */       drawSelection(drawable1, paramBatch, bitmapFont, f3 + f7, f4 + f2);
/*      */     }
/*      */     
/*  343 */     float f1 = bitmapFont.isFlipped() ? -this.textHeight : 0.0F;
/*  344 */     if (this.displayText.length() == 0) {
/*  345 */       if ((!bool || this.disabled) && this.messageText != null) {
/*  346 */         BitmapFont bitmapFont1 = (this.style.messageFont != null) ? this.style.messageFont : bitmapFont;
/*  347 */         if (this.style.messageFontColor != null) {
/*  348 */           bitmapFont1.setColor(this.style.messageFontColor.r, this.style.messageFontColor.g, this.style.messageFontColor.b, this.style.messageFontColor.a * color2.a * paramFloat);
/*      */         } else {
/*      */           
/*  351 */           bitmapFont1.setColor(0.7F, 0.7F, 0.7F, color2.a * paramFloat);
/*  352 */         }  drawMessageText(paramBatch, bitmapFont1, f3 + f7, f4 + f2 + f1, f5 - f7 - f8);
/*      */       } 
/*      */     } else {
/*      */       BitmapFont.BitmapFontData bitmapFontData;
/*  356 */       boolean bool1 = (bitmapFontData = bitmapFont.getData()).markupEnabled;
/*  357 */       bitmapFontData.markupEnabled = false;
/*  358 */       bitmapFont.setColor(color1.r, color1.g, color1.b, color1.a * color2.a * paramFloat);
/*  359 */       drawText(paramBatch, bitmapFont, f3 + f7, f4 + f2 + f1);
/*  360 */       bitmapFontData.markupEnabled = bool1;
/*      */     } 
/*  362 */     if (!this.disabled && this.cursorOn && drawable2 != null) {
/*  363 */       drawCursor(drawable2, paramBatch, bitmapFont, f3 + f7, f4 + f2);
/*      */     }
/*      */   }
/*      */   
/*      */   protected float getTextY(BitmapFont paramBitmapFont, @Null Drawable paramDrawable) {
/*  368 */     float f1 = getHeight();
/*  369 */     float f2 = this.textHeight / 2.0F + paramBitmapFont.getDescent();
/*  370 */     if (paramDrawable != null) {
/*  371 */       float f = paramDrawable.getBottomHeight();
/*  372 */       f2 = f2 + (f1 - paramDrawable.getTopHeight() - f) / 2.0F + f;
/*      */     } else {
/*  374 */       f2 += f1 / 2.0F;
/*      */     } 
/*  376 */     if (paramBitmapFont.usesIntegerPositions()) f2 = (int)f2; 
/*  377 */     return f2;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void drawSelection(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/*  382 */     paramDrawable.draw(paramBatch, paramFloat1 + this.textOffset + this.selectionX + this.fontOffset, paramFloat2 - this.textHeight - paramBitmapFont.getDescent(), this.selectionWidth, this.textHeight);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void drawText(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/*  387 */     paramBitmapFont.draw(paramBatch, this.displayText, paramFloat1 + this.textOffset, paramFloat2, this.visibleTextStart, this.visibleTextEnd, 0.0F, 8, false);
/*      */   }
/*      */   
/*      */   protected void drawMessageText(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  391 */     paramBitmapFont.draw(paramBatch, this.messageText, paramFloat1, paramFloat2, 0, this.messageText.length(), paramFloat3, this.textHAlign, false, "...");
/*      */   }
/*      */   
/*      */   protected void drawCursor(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/*  395 */     paramDrawable.draw(paramBatch, paramFloat1 + this.textOffset + this.glyphPositions
/*  396 */         .get(this.cursor) - this.glyphPositions.get(this.visibleTextStart) + this.fontOffset + (paramBitmapFont.getData()).cursorX, paramFloat2 - this.textHeight - paramBitmapFont
/*  397 */         .getDescent(), paramDrawable.getMinWidth(), this.textHeight);
/*      */   }
/*      */   
/*      */   void updateDisplayText() {
/*      */     BitmapFont bitmapFont;
/*  402 */     BitmapFont.BitmapFontData bitmapFontData = (bitmapFont = this.style.font).getData();
/*      */     String str1;
/*  404 */     int i = (str1 = this.text).length();
/*      */     
/*  406 */     StringBuilder stringBuilder = new StringBuilder();
/*  407 */     for (byte b = 0; b < i; b++) {
/*  408 */       char c = str1.charAt(b);
/*  409 */       stringBuilder.append(bitmapFontData.hasGlyph(c) ? c : 32);
/*      */     } 
/*  411 */     String str2 = stringBuilder.toString();
/*      */     
/*  413 */     if (this.passwordMode && bitmapFontData.hasGlyph(this.passwordCharacter)) {
/*  414 */       if (this.passwordBuffer == null) this.passwordBuffer = new StringBuilder(str2.length()); 
/*  415 */       if (this.passwordBuffer.length() > i) {
/*  416 */         this.passwordBuffer.setLength(i);
/*      */       } else {
/*  418 */         for (int j = this.passwordBuffer.length(); j < i; j++)
/*  419 */           this.passwordBuffer.append(this.passwordCharacter); 
/*      */       } 
/*  421 */       this.displayText = this.passwordBuffer;
/*      */     } else {
/*  423 */       this.displayText = str2;
/*      */     } 
/*  425 */     boolean bool = bitmapFontData.markupEnabled;
/*  426 */     bitmapFontData.markupEnabled = false;
/*  427 */     this.layout.setText(bitmapFont, this.displayText.toString().replace('\r', ' ').replace('\n', ' '));
/*  428 */     bitmapFontData.markupEnabled = bool;
/*      */     
/*  430 */     this.glyphPositions.clear();
/*  431 */     float f = 0.0F;
/*  432 */     if (this.layout.runs.size > 0) {
/*      */       GlyphLayout.GlyphRun glyphRun;
/*  434 */       FloatArray floatArray = (glyphRun = (GlyphLayout.GlyphRun)this.layout.runs.first()).xAdvances;
/*  435 */       this.fontOffset = floatArray.first(); byte b1; int j;
/*  436 */       for (b1 = 1, j = floatArray.size; b1 < j; b1++) {
/*  437 */         this.glyphPositions.add(f);
/*  438 */         f += floatArray.get(b1);
/*      */       } 
/*      */     } else {
/*  441 */       this.fontOffset = 0.0F;
/*  442 */     }  this.glyphPositions.add(f);
/*      */     
/*  444 */     this.visibleTextStart = Math.min(this.visibleTextStart, this.glyphPositions.size - 1);
/*  445 */     this.visibleTextEnd = MathUtils.clamp(this.visibleTextEnd, this.visibleTextStart, this.glyphPositions.size - 1);
/*      */     
/*  447 */     if (this.selectionStart > str2.length()) this.selectionStart = i;
/*      */   
/*      */   }
/*      */   
/*      */   public void copy() {
/*  452 */     if (this.hasSelection && !this.passwordMode) {
/*  453 */       this.clipboard.setContents(this.text.substring(Math.min(this.cursor, this.selectionStart), Math.max(this.cursor, this.selectionStart)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void cut() {
/*  460 */     cut(this.programmaticChangeEvents);
/*      */   }
/*      */   
/*      */   void cut(boolean paramBoolean) {
/*  464 */     if (this.hasSelection && !this.passwordMode) {
/*  465 */       copy();
/*  466 */       this.cursor = delete(paramBoolean);
/*  467 */       updateDisplayText();
/*      */     } 
/*      */   }
/*      */   
/*      */   void paste(@Null String paramString, boolean paramBoolean) {
/*  472 */     if (paramString == null)
/*  473 */       return;  StringBuilder stringBuilder = new StringBuilder();
/*  474 */     int i = this.text.length();
/*  475 */     if (this.hasSelection) i -= Math.abs(this.cursor - this.selectionStart); 
/*  476 */     BitmapFont.BitmapFontData bitmapFontData = this.style.font.getData(); byte b; int j;
/*  477 */     for (b = 0, j = paramString.length(); b < j && 
/*  478 */       withinMaxLength(i + stringBuilder.length()); b++) {
/*  479 */       char c = paramString.charAt(b);
/*  480 */       if ((this.writeEnters && (c == '\n' || c == '\r')) || (
/*  481 */         c != '\r' && c != '\n' && (
/*  482 */         !this.onlyFontChars || bitmapFontData.hasGlyph(c)) && (
/*  483 */         this.filter == null || this.filter.acceptChar(this, c))))
/*      */       {
/*  485 */         stringBuilder.append(c); } 
/*      */     } 
/*  487 */     paramString = stringBuilder.toString();
/*      */     
/*  489 */     if (this.hasSelection) this.cursor = delete(paramBoolean); 
/*  490 */     if (paramBoolean) {
/*  491 */       changeText(this.text, insert(this.cursor, paramString, this.text));
/*      */     } else {
/*  493 */       this.text = insert(this.cursor, paramString, this.text);
/*  494 */     }  updateDisplayText();
/*  495 */     this.cursor += paramString.length();
/*      */   }
/*      */   
/*      */   String insert(int paramInt, CharSequence paramCharSequence, String paramString) {
/*  499 */     if (paramString.length() == 0) return paramCharSequence.toString(); 
/*  500 */     return paramString.substring(0, paramInt) + paramCharSequence + paramString.substring(paramInt, paramString.length());
/*      */   }
/*      */   
/*      */   int delete(boolean paramBoolean) {
/*  504 */     int i = this.selectionStart;
/*  505 */     int j = this.cursor;
/*  506 */     int k = Math.min(i, j);
/*  507 */     i = Math.max(i, j);
/*      */     
/*  509 */     String str = ((k > 0) ? this.text.substring(0, k) : "") + ((i < this.text.length()) ? this.text.substring(i, this.text.length()) : "");
/*  510 */     if (paramBoolean) {
/*  511 */       changeText(this.text, str);
/*      */     } else {
/*  513 */       this.text = str;
/*  514 */     }  clearSelection();
/*  515 */     return k;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void next(boolean paramBoolean) {
/*      */     Stage stage;
/*  523 */     if ((stage = getStage()) == null)
/*      */       return;  TextField textField;
/*  525 */     Vector2 vector21 = (textField = this).getParent().localToStageCoordinates(tmp2.set(textField.getX(), textField.getY()));
/*  526 */     Vector2 vector22 = tmp1;
/*      */     while (true) {
/*      */       TextField textField1;
/*  529 */       if ((textField1 = textField.findNextTextField(stage.getActors(), (TextField)null, vector22, vector21, paramBoolean)) == null) {
/*  530 */         if (paramBoolean) {
/*  531 */           vector21.set(-3.4028235E38F, -3.4028235E38F);
/*      */         } else {
/*  533 */           vector21.set(Float.MAX_VALUE, Float.MAX_VALUE);
/*  534 */         }  textField1 = textField.findNextTextField(stage.getActors(), (TextField)null, vector22, vector21, paramBoolean);
/*      */       } 
/*  536 */       if (textField1 == null) {
/*  537 */         Gdx.input.setOnscreenKeyboardVisible(false);
/*      */         return;
/*      */       } 
/*  540 */       if (stage.setKeyboardFocus(textField1)) {
/*  541 */         textField1.selectAll();
/*      */         return;
/*      */       } 
/*  544 */       textField = textField1;
/*  545 */       vector21.set(vector22);
/*      */     } 
/*      */   }
/*      */   @Null
/*      */   private TextField findNextTextField(Array<Actor> paramArray, @Null TextField paramTextField, Vector2 paramVector21, Vector2 paramVector22, boolean paramBoolean) {
/*      */     byte b;
/*      */     int i;
/*  552 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*      */       Actor actor;
/*  554 */       if (actor = (Actor)paramArray.get(b) instanceof TextField) {
/*  555 */         TextField textField; if (actor != this && 
/*      */           
/*  557 */           !(textField = (TextField)actor).isDisabled() && textField.focusTraversal && textField.ascendantsVisible()) {
/*      */           Vector2 vector2;
/*  559 */           boolean bool1 = ((vector2 = actor.getParent().localToStageCoordinates(tmp3.set(actor.getX(), actor.getY()))).y != paramVector22.y && (((vector2.y < paramVector22.y) ? 1 : 0) ^ paramBoolean) != 0) ? true : false;
/*  560 */           boolean bool2 = (vector2.y == paramVector22.y && (((vector2.x > paramVector22.x) ? 1 : 0) ^ paramBoolean) != 0) ? true : false;
/*  561 */           if (bool1 || bool2)
/*      */           
/*  563 */           { if (!(bool1 = (paramTextField == null || (vector2.y != paramVector21.y && (((vector2.y > paramVector21.y) ? 1 : 0) ^ paramBoolean) != 0)) ? true : false)) bool1 = (vector2.y == paramVector21.y && (((vector2.x < paramVector21.x) ? 1 : 0) ^ paramBoolean) != 0) ? true : false; 
/*  564 */             if (bool1)
/*  565 */             { paramTextField = (TextField)actor;
/*  566 */               paramVector21.set(vector2); }  } 
/*      */         } 
/*  568 */       } else if (actor instanceof Group) {
/*  569 */         paramTextField = findNextTextField((Array<Actor>)((Group)actor).getChildren(), paramTextField, paramVector21, paramVector22, paramBoolean);
/*      */       } 
/*  571 */     }  return paramTextField;
/*      */   }
/*      */   
/*      */   public InputListener getDefaultInputListener() {
/*  575 */     return this.inputListener;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTextFieldListener(@Null TextFieldListener paramTextFieldListener) {
/*  580 */     this.listener = paramTextFieldListener;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTextFieldFilter(@Null TextFieldFilter paramTextFieldFilter) {
/*  585 */     this.filter = paramTextFieldFilter;
/*      */   }
/*      */   @Null
/*      */   public TextFieldFilter getTextFieldFilter() {
/*  589 */     return this.filter;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFocusTraversal(boolean paramBoolean) {
/*  594 */     this.focusTraversal = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getFocusTraversal() {
/*  598 */     return this.focusTraversal;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public String getMessageText() {
/*  603 */     return this.messageText;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMessageText(@Null String paramString) {
/*  609 */     this.messageText = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   public void appendText(@Null String paramString) {
/*  614 */     if (paramString == null) paramString = "";
/*      */     
/*  616 */     clearSelection();
/*  617 */     this.cursor = this.text.length();
/*  618 */     paste(paramString, this.programmaticChangeEvents);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setText(@Null String paramString) {
/*  623 */     if (paramString == null) paramString = ""; 
/*  624 */     if (paramString.equals(this.text))
/*      */       return; 
/*  626 */     clearSelection();
/*  627 */     String str = this.text;
/*  628 */     this.text = "";
/*  629 */     paste(paramString, false);
/*  630 */     if (this.programmaticChangeEvents) changeText(str, this.text); 
/*  631 */     this.cursor = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getText() {
/*  636 */     return this.text;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean changeText(String paramString1, String paramString2) {
/*  641 */     if (paramString2.equals(paramString1)) return false; 
/*  642 */     this.text = paramString2;
/*  643 */     ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/*      */     boolean bool;
/*  645 */     if (bool = fire((Event)changeEvent)) this.text = paramString1; 
/*  646 */     Pools.free(changeEvent);
/*  647 */     return !bool;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/*  653 */     this.programmaticChangeEvents = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getProgrammaticChangeEvents() {
/*  657 */     return this.programmaticChangeEvents;
/*      */   }
/*      */   
/*      */   public int getSelectionStart() {
/*  661 */     return this.selectionStart;
/*      */   }
/*      */   
/*      */   public String getSelection() {
/*  665 */     return this.hasSelection ? this.text.substring(Math.min(this.selectionStart, this.cursor), Math.max(this.selectionStart, this.cursor)) : "";
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSelection(int paramInt1, int paramInt2) {
/*  670 */     if (paramInt1 < 0) throw new IllegalArgumentException("selectionStart must be >= 0"); 
/*  671 */     if (paramInt2 < 0) throw new IllegalArgumentException("selectionEnd must be >= 0"); 
/*  672 */     paramInt1 = Math.min(this.text.length(), paramInt1);
/*      */     
/*  674 */     if ((paramInt2 = Math.min(this.text.length(), paramInt2)) == paramInt1) {
/*  675 */       clearSelection();
/*      */       return;
/*      */     } 
/*  678 */     if (paramInt2 < paramInt1) {
/*  679 */       int i = paramInt2;
/*  680 */       paramInt2 = paramInt1;
/*  681 */       paramInt1 = i;
/*      */     } 
/*      */     
/*  684 */     this.hasSelection = true;
/*  685 */     this.selectionStart = paramInt1;
/*  686 */     this.cursor = paramInt2;
/*      */   }
/*      */   
/*      */   public void selectAll() {
/*  690 */     setSelection(0, this.text.length());
/*      */   }
/*      */   
/*      */   public void clearSelection() {
/*  694 */     this.hasSelection = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCursorPosition(int paramInt) {
/*  699 */     if (paramInt < 0) throw new IllegalArgumentException("cursorPosition must be >= 0"); 
/*  700 */     clearSelection();
/*  701 */     this.cursor = Math.min(paramInt, this.text.length());
/*      */   }
/*      */   
/*      */   public int getCursorPosition() {
/*  705 */     return this.cursor;
/*      */   }
/*      */ 
/*      */   
/*      */   public OnscreenKeyboard getOnscreenKeyboard() {
/*  710 */     return this.keyboard;
/*      */   }
/*      */   
/*      */   public void setOnscreenKeyboard(OnscreenKeyboard paramOnscreenKeyboard) {
/*  714 */     this.keyboard = paramOnscreenKeyboard;
/*      */   }
/*      */   
/*      */   public void setClipboard(Clipboard paramClipboard) {
/*  718 */     this.clipboard = paramClipboard;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  722 */     return 150.0F;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  726 */     float f1 = 0.0F, f2 = 0.0F;
/*  727 */     if (this.style.background != null) {
/*  728 */       f1 = Math.max(0.0F, this.style.background.getBottomHeight() + this.style.background.getTopHeight());
/*  729 */       f2 = Math.max(0.0F, this.style.background.getMinHeight());
/*      */     } 
/*  731 */     if (this.style.focusedBackground != null) {
/*  732 */       f1 = Math.max(f1, this.style.focusedBackground
/*  733 */           .getBottomHeight() + this.style.focusedBackground.getTopHeight());
/*  734 */       f2 = Math.max(f2, this.style.focusedBackground.getMinHeight());
/*      */     } 
/*  736 */     if (this.style.disabledBackground != null) {
/*  737 */       f1 = Math.max(f1, this.style.disabledBackground
/*  738 */           .getBottomHeight() + this.style.disabledBackground.getTopHeight());
/*  739 */       f2 = Math.max(f2, this.style.disabledBackground.getMinHeight());
/*      */     } 
/*  741 */     return Math.max(f1 + this.textHeight, f2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlignment(int paramInt) {
/*  747 */     this.textHAlign = paramInt;
/*      */   }
/*      */   
/*      */   public int getAlignment() {
/*  751 */     return this.textHAlign;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPasswordMode(boolean paramBoolean) {
/*  757 */     this.passwordMode = paramBoolean;
/*  758 */     updateDisplayText();
/*      */   }
/*      */   
/*      */   public boolean isPasswordMode() {
/*  762 */     return this.passwordMode;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPasswordCharacter(char paramChar) {
/*  768 */     this.passwordCharacter = paramChar;
/*  769 */     if (this.passwordMode) updateDisplayText(); 
/*      */   }
/*      */   
/*      */   public void setBlinkTime(float paramFloat) {
/*  773 */     this.blinkTime = paramFloat;
/*      */   }
/*      */   
/*      */   public void setDisabled(boolean paramBoolean) {
/*  777 */     this.disabled = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isDisabled() {
/*  781 */     return this.disabled;
/*      */   }
/*      */   
/*      */   protected void moveCursor(boolean paramBoolean1, boolean paramBoolean2) {
/*  785 */     byte b = paramBoolean1 ? this.text.length() : 0;
/*  786 */     boolean bool = paramBoolean1 ? false : true; do {  }
/*  787 */     while ((paramBoolean1 ? (++this.cursor < b) : (--this.cursor > b)) && paramBoolean2 && 
/*  788 */       continueCursor(this.cursor, bool));
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean continueCursor(int paramInt1, int paramInt2) {
/*  793 */     paramInt1 = this.text.charAt(paramInt1 + paramInt2);
/*  794 */     return isWordCharacter(paramInt1);
/*      */   }
/*      */   
/*      */   class KeyRepeatTask extends Timer.Task {
/*      */     int keycode;
/*      */     
/*      */     public void run() {
/*  801 */       if (TextField.this.getStage() == null) {
/*  802 */         cancel();
/*      */         return;
/*      */       } 
/*  805 */       TextField.this.inputListener.keyDown(null, this.keycode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface TextFieldFilter
/*      */   {
/*      */     boolean acceptChar(TextField param1TextField, char param1Char);
/*      */ 
/*      */ 
/*      */     
/*      */     public static class DigitsOnlyFilter
/*      */       implements TextFieldFilter
/*      */     {
/*      */       public boolean acceptChar(TextField param2TextField, char param2Char) {
/*  822 */         return Character.isDigit(param2Char);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class DefaultOnscreenKeyboard
/*      */     implements OnscreenKeyboard
/*      */   {
/*      */     public void show(boolean param1Boolean) {
/*  838 */       Gdx.input.setOnscreenKeyboardVisible(param1Boolean);
/*      */     }
/*      */   }
/*      */   
/*      */   public class TextFieldClickListener
/*      */     extends ClickListener {
/*      */     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*      */       int i;
/*  846 */       if ((i = getTapCount() % 4) == 0) TextField.this.clearSelection(); 
/*  847 */       if (i == 2) {
/*  848 */         int[] arrayOfInt = TextField.this.wordUnderCursor(param1Float1);
/*  849 */         TextField.this.setSelection(arrayOfInt[0], arrayOfInt[1]);
/*      */       } 
/*  851 */       if (i == 3) TextField.this.selectAll(); 
/*      */     }
/*      */     
/*      */     public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  855 */       if (!super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2)) return false; 
/*  856 */       if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  857 */       if (TextField.this.disabled) return true; 
/*  858 */       setCursorPosition(param1Float1, param1Float2);
/*  859 */       TextField.this.selectionStart = TextField.this.cursor;
/*      */       Stage stage;
/*  861 */       if ((stage = TextField.this.getStage()) != null) stage.setKeyboardFocus(TextField.this); 
/*  862 */       TextField.this.keyboard.show(true);
/*  863 */       TextField.this.hasSelection = true;
/*  864 */       return true;
/*      */     }
/*      */     
/*      */     public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  868 */       super.touchDragged(param1InputEvent, param1Float1, param1Float2, param1Int);
/*  869 */       setCursorPosition(param1Float1, param1Float2);
/*      */     }
/*      */     
/*      */     public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  873 */       if (TextField.this.selectionStart == TextField.this.cursor) TextField.this.hasSelection = false; 
/*  874 */       super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*      */     }
/*      */     
/*      */     protected void setCursorPosition(float param1Float1, float param1Float2) {
/*  878 */       TextField.this.cursor = TextField.this.letterUnderCursor(param1Float1);
/*      */       
/*  880 */       TextField.this.cursorOn = TextField.this.focused;
/*  881 */       TextField.this.blinkTask.cancel();
/*  882 */       if (TextField.this.focused) Timer.schedule(TextField.this.blinkTask, TextField.this.blinkTime, TextField.this.blinkTime); 
/*      */     }
/*      */     
/*      */     protected void goHome(boolean param1Boolean) {
/*  886 */       TextField.this.cursor = 0;
/*      */     }
/*      */     
/*      */     protected void goEnd(boolean param1Boolean) {
/*  890 */       TextField.this.cursor = TextField.this.text.length();
/*      */     }
/*      */     
/*      */     public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/*  894 */       if (TextField.this.disabled) return false;
/*      */       
/*  896 */       TextField.this.cursorOn = TextField.this.focused;
/*  897 */       TextField.this.blinkTask.cancel();
/*  898 */       if (TextField.this.focused) Timer.schedule(TextField.this.blinkTask, TextField.this.blinkTime, TextField.this.blinkTime);
/*      */       
/*  900 */       if (!TextField.this.hasKeyboardFocus()) return false;
/*      */       
/*  902 */       boolean bool1 = false;
/*      */       boolean bool;
/*  904 */       boolean bool2 = ((bool = UIUtils.ctrl()) && !TextField.this.passwordMode) ? true : false;
/*  905 */       boolean bool3 = true;
/*      */       
/*  907 */       if (bool) {
/*  908 */         String str; switch (param1Int) {
/*      */           case 50:
/*  910 */             TextField.this.paste(TextField.this.clipboard.getContents(), true);
/*  911 */             bool1 = true;
/*      */             break;
/*      */           case 31:
/*      */           case 124:
/*  915 */             TextField.this.copy();
/*  916 */             return true;
/*      */           case 52:
/*  918 */             TextField.this.cut(true);
/*  919 */             return true;
/*      */           case 29:
/*  921 */             TextField.this.selectAll();
/*  922 */             return true;
/*      */           case 54:
/*  924 */             str = TextField.this.text;
/*  925 */             TextField.this.setText(TextField.this.undoText);
/*  926 */             TextField.this.undoText = str;
/*  927 */             TextField.this.updateDisplayText();
/*  928 */             return true;
/*      */           default:
/*  930 */             bool3 = false;
/*      */             break;
/*      */         } 
/*      */       } 
/*  934 */       if (UIUtils.shift())
/*  935 */       { switch (param1Int) {
/*      */           case 124:
/*  937 */             TextField.this.paste(TextField.this.clipboard.getContents(), true);
/*      */             break;
/*      */           case 112:
/*  940 */             TextField.this.cut(true);
/*      */             break;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  946 */         int i = TextField.this.cursor;
/*      */ 
/*      */         
/*  949 */         switch (param1Int)
/*      */         { case 21:
/*  951 */             TextField.this.moveCursor(false, bool2);
/*  952 */             bool1 = true;
/*  953 */             bool3 = true;
/*      */             break;
/*      */           case 22:
/*  956 */             TextField.this.moveCursor(true, bool2);
/*  957 */             bool1 = true;
/*  958 */             bool3 = true;
/*      */             break;
/*      */           case 3:
/*  961 */             goHome(bool2);
/*  962 */             bool3 = true;
/*      */             break;
/*      */           case 123:
/*  965 */             goEnd(bool2);
/*  966 */             bool3 = true;
/*      */             break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           default:
/* 1004 */             TextField.this.cursor = MathUtils.clamp(TextField.this.cursor, 0, TextField.this.text.length());
/*      */             
/* 1006 */             if (bool1) scheduleKeyRepeatTask(param1Int); 
/* 1007 */             return bool3; }  if (!TextField.this.hasSelection) { TextField.this.selectionStart = i; TextField.this.hasSelection = true; }  }  switch (param1Int) { case 21: TextField.this.moveCursor(false, bool2); TextField.this.clearSelection(); bool1 = true; bool3 = true;
/*      */         case 22: TextField.this.moveCursor(true, bool2); TextField.this.clearSelection(); bool1 = true; bool3 = true;
/*      */         case 3: goHome(bool2); TextField.this.clearSelection(); bool3 = true;
/*      */         case 123:
/* 1011 */           goEnd(bool2); TextField.this.clearSelection(); bool3 = true; }  } protected void scheduleKeyRepeatTask(int param1Int) { if (!TextField.this.keyRepeatTask.isScheduled() || TextField.this.keyRepeatTask.keycode != param1Int) {
/* 1012 */         TextField.this.keyRepeatTask.keycode = param1Int;
/* 1013 */         TextField.this.keyRepeatTask.cancel();
/* 1014 */         Timer.schedule(TextField.this.keyRepeatTask, TextField.keyRepeatInitialTime, TextField.keyRepeatTime);
/*      */       }  }
/*      */ 
/*      */     
/*      */     public boolean keyUp(InputEvent param1InputEvent, int param1Int) {
/* 1019 */       if (TextField.this.disabled) return false; 
/* 1020 */       TextField.this.keyRepeatTask.cancel();
/* 1021 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean checkFocusTraversal(char param1Char) {
/* 1029 */       return (TextField.this.focusTraversal && (param1Char == '\t' || ((param1Char == '\r' || param1Char == '\n') && (UIUtils.isAndroid || UIUtils.isIos))));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/* 1034 */       if (TextField.this.disabled) return false;
/*      */ 
/*      */       
/* 1037 */       switch (param1Char) {
/*      */         case '\b':
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\r':
/*      */           break;
/*      */         default:
/* 1044 */           if (param1Char < ' ') return false; 
/*      */           break;
/*      */       } 
/* 1047 */       if (!TextField.this.hasKeyboardFocus()) return false;
/*      */       
/* 1049 */       if (UIUtils.isMac && Gdx.input.isKeyPressed(63)) return true;
/*      */       
/* 1051 */       if (checkFocusTraversal(param1Char)) {
/* 1052 */         TextField.this.next(UIUtils.shift());
/*      */       } else {
/* 1054 */         boolean bool1 = (param1Char == '\r' || param1Char == '\n') ? true : false;
/* 1055 */         boolean bool2 = (param1Char == '') ? true : false;
/* 1056 */         boolean bool3 = (param1Char == '\b') ? true : false;
/* 1057 */         boolean bool4 = bool1 ? TextField.this.writeEnters : ((!TextField.this.onlyFontChars || TextField.this.style.font.getData().hasGlyph(param1Char)) ? true : false);
/* 1058 */         boolean bool5 = (bool3 || bool2) ? true : false;
/* 1059 */         if (bool4 || bool5) {
/* 1060 */           String str = TextField.this.text;
/* 1061 */           int i = TextField.this.cursor;
/* 1062 */           if (bool5) {
/* 1063 */             if (TextField.this.hasSelection) {
/* 1064 */               TextField.this.cursor = TextField.this.delete(false);
/*      */             } else {
/* 1066 */               if (bool3 && TextField.this.cursor > 0) {
/* 1067 */                 TextField.this.text = TextField.this.text.substring(0, TextField.this.cursor - 1) + TextField.this.text.substring(TextField.this.cursor--);
/* 1068 */                 TextField.this.renderOffset = 0.0F;
/*      */               } 
/* 1070 */               if (bool2 && TextField.this.cursor < TextField.this.text.length()) {
/* 1071 */                 TextField.this.text = TextField.this.text.substring(0, TextField.this.cursor) + TextField.this.text.substring(TextField.this.cursor + 1);
/*      */               }
/*      */             } 
/*      */           }
/* 1075 */           if (bool4 && !bool5) {
/*      */             
/* 1077 */             if (!bool1 && TextField.this.filter != null && !TextField.this.filter.acceptChar(TextField.this, param1Char)) return true; 
/* 1078 */             if (!TextField.this.withinMaxLength(TextField.this.text.length() - (TextField.this.hasSelection ? Math.abs(TextField.this.cursor - TextField.this.selectionStart) : 0))) return true; 
/* 1079 */             if (TextField.this.hasSelection) TextField.this.cursor = TextField.this.delete(false); 
/* 1080 */             String str1 = bool1 ? "\n" : String.valueOf(param1Char);
/* 1081 */             TextField.this.text = TextField.this.insert(TextField.this.cursor++, str1, TextField.this.text);
/*      */           } 
/*      */           
/* 1084 */           if (TextField.this.changeText(str, TextField.this.text)) {
/*      */             long l;
/* 1086 */             if ((l = System.currentTimeMillis()) - 750L > TextField.this.lastChangeTime) TextField.this.undoText = str; 
/* 1087 */             TextField.this.lastChangeTime = l;
/* 1088 */             TextField.this.updateDisplayText();
/* 1089 */           } else if (!TextField.this.text.equals(str)) {
/* 1090 */             TextField.this.cursor = i;
/*      */           } 
/*      */         } 
/* 1093 */       }  if (TextField.this.listener != null) TextField.this.listener.keyTyped(TextField.this, param1Char); 
/* 1094 */       return true;
/*      */     } }
/*      */   public static class TextFieldStyle { public BitmapFont font; public Color fontColor; @Null
/*      */     public Color focusedFontColor; @Null
/*      */     public Color disabledFontColor; @Null
/*      */     public Drawable background; @Null
/*      */     public Drawable focusedBackground; @Null
/*      */     public Drawable disabledBackground;
/*      */     @Null
/*      */     public Drawable cursor;
/*      */     @Null
/*      */     public Drawable selection;
/*      */     @Null
/*      */     public BitmapFont messageFont;
/*      */     @Null
/*      */     public Color messageFontColor;
/*      */     
/*      */     public TextFieldStyle() {}
/*      */     
/*      */     public TextFieldStyle(BitmapFont param1BitmapFont, Color param1Color, @Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3) {
/* 1114 */       this.font = param1BitmapFont;
/* 1115 */       this.fontColor = param1Color;
/* 1116 */       this.cursor = param1Drawable1;
/* 1117 */       this.selection = param1Drawable2;
/* 1118 */       this.background = param1Drawable3;
/*      */     }
/*      */     
/*      */     public TextFieldStyle(TextFieldStyle param1TextFieldStyle) {
/* 1122 */       this.font = param1TextFieldStyle.font;
/* 1123 */       if (param1TextFieldStyle.fontColor != null) this.fontColor = new Color(param1TextFieldStyle.fontColor); 
/* 1124 */       if (param1TextFieldStyle.focusedFontColor != null) this.focusedFontColor = new Color(param1TextFieldStyle.focusedFontColor); 
/* 1125 */       if (param1TextFieldStyle.disabledFontColor != null) this.disabledFontColor = new Color(param1TextFieldStyle.disabledFontColor);
/*      */       
/* 1127 */       this.background = param1TextFieldStyle.background;
/* 1128 */       this.focusedBackground = param1TextFieldStyle.focusedBackground;
/* 1129 */       this.disabledBackground = param1TextFieldStyle.disabledBackground;
/* 1130 */       this.cursor = param1TextFieldStyle.cursor;
/* 1131 */       this.selection = param1TextFieldStyle.selection;
/*      */       
/* 1133 */       this.messageFont = param1TextFieldStyle.messageFont;
/* 1134 */       if (param1TextFieldStyle.messageFontColor != null) this.messageFontColor = new Color(param1TextFieldStyle.messageFontColor); 
/*      */     } }
/*      */ 
/*      */   
/*      */   public static interface OnscreenKeyboard {
/*      */     void show(boolean param1Boolean);
/*      */   }
/*      */   
/*      */   public static interface TextFieldListener {
/*      */     void keyTyped(TextField param1TextField, char param1Char);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\TextField.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */