/*      */ package com.prineside.tdi2.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.Cursor;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Clipboard;
/*      */ import com.badlogic.gdx.utils.FloatArray;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.Pools;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.Event;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Stage;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Disableable;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.FocusListener;
/*      */ import com.prineside.tdi2.scene2d.utils.UIUtils;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.TableButton;
/*      */ import com.prineside.tdi2.utils.IntPair;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
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
/*      */   extends WidgetGroup
/*      */   implements Disableable
/*      */ {
/*   78 */   private static final TLog k = TLog.forClass(TextField.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   87 */   private static final Vector2 l = new Vector2();
/*   88 */   private static final Vector2 m = new Vector2();
/*   89 */   private static final Vector2 n = new Vector2();
/*      */   
/*   91 */   public static float keyRepeatInitialTime = 0.3F;
/*   92 */   public static float keyRepeatTime = 0.05F;
/*      */   protected String o;
/*      */   protected int p;
/*      */   protected int q;
/*      */   protected boolean r;
/*   97 */   private int O = -1;
/*      */   private boolean P = false;
/*      */   public boolean writeEnters;
/*  100 */   private GlyphLayout Q = new GlyphLayout();
/*  101 */   protected final FloatArray s = new FloatArray(); TextFieldStyle t;
/*      */   private String R;
/*      */   protected CharSequence u;
/*      */   Clipboard v;
/*      */   InputListener w;
/*      */   @Null
/*      */   TextFieldListener x;
/*      */   @Null
/*      */   TextFieldFilter y;
/*  110 */   OnscreenKeyboard z = new DefaultOnscreenKeyboard(); boolean A = true; boolean B = true;
/*      */   boolean C;
/*  112 */   private int S = 8;
/*      */   private float T;
/*      */   private float U;
/*  115 */   String D = "";
/*      */   
/*      */   int E;
/*      */   long F;
/*      */   boolean G;
/*      */   private StringBuilder V;
/*  121 */   private char W = ''; private float X;
/*      */   protected float H;
/*      */   private float Y;
/*      */   float I;
/*      */   private int Z;
/*      */   private int aa;
/*      */   private int ab;
/*      */   public boolean replaceTabsWithSpaces = true;
/*      */   boolean J;
/*      */   boolean K;
/*  131 */   float L = 0.32F;
/*  132 */   final Timer.Task M = new Timer.Task(this) {
/*      */       public void run() {
/*  134 */         if (this.a.getStage() == null) {
/*  135 */           cancel();
/*      */           return;
/*      */         } 
/*  138 */         this.a.K = !this.a.K;
/*  139 */         Gdx.graphics.requestRendering();
/*      */       }
/*      */     };
/*      */ 
/*      */   
/*      */   private ContextMenu ac;
/*  145 */   final KeyRepeatTask N = new KeyRepeatTask(this);
/*      */   private boolean ad;
/*      */   
/*      */   public TextField(@Null String paramString, TextFieldStyle paramTextFieldStyle) {
/*  149 */     setStyle(paramTextFieldStyle);
/*  150 */     this.v = Gdx.app.getClipboard();
/*  151 */     d();
/*  152 */     setText(paramString);
/*  153 */     setSize(getPrefWidth(), getPrefHeight());
/*      */     
/*  155 */     Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this, Cursor.SystemCursor.Ibeam);
/*      */   }
/*      */   
/*      */   protected void d() {
/*  159 */     addListener((EventListener)(this.w = h()));
/*      */     
/*  161 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop)
/*      */     {
/*  163 */       addListener((EventListener)new FocusListener(this)
/*      */           {
/*      */             public void keyboardFocusChanged(FocusListener.FocusEvent param1FocusEvent, Actor param1Actor, boolean param1Boolean) {
/*  166 */               Game.i.actionResolver.handleTextFieldFocus(param1FocusEvent, this.a, param1Boolean);
/*      */             }
/*      */           });
/*      */     }
/*      */   }
/*      */   
/*      */   protected InputListener h() {
/*  173 */     return (InputListener)new TextFieldClickListener(this);
/*      */   }
/*      */   
/*      */   public int letterUnderCursor(float paramFloat) {
/*  177 */     paramFloat -= this.Y + this.X - (this.t.font.getData()).cursorX - this.s.get(this.Z);
/*      */     Drawable drawable;
/*  179 */     if ((drawable = i()) != null) paramFloat -= this.t.background.getLeftWidth(); 
/*  180 */     int i = this.s.size;
/*  181 */     float[] arrayOfFloat = this.s.items;
/*  182 */     for (byte b = 1; b < i; b++) {
/*  183 */       if (arrayOfFloat[b] > paramFloat) {
/*  184 */         if (arrayOfFloat[b] - paramFloat <= paramFloat - arrayOfFloat[b - 1]) return b; 
/*  185 */         return b - 1;
/*      */       } 
/*      */     } 
/*  188 */     return i - 1;
/*      */   }
/*      */   
/*      */   private static boolean a(char paramChar) {
/*  192 */     return Character.isLetterOrDigit(paramChar);
/*      */   }
/*      */   
/*      */   private int[] b(int paramInt) {
/*  196 */     String str = this.o;
/*  197 */     int i = paramInt, j = str.length(), k = 0, m = i;
/*  198 */     if (paramInt >= str.length()) {
/*  199 */       k = str.length();
/*  200 */       j = 0;
/*      */     } else {
/*  202 */       for (; m < j; m++) {
/*  203 */         if (!a(str.charAt(m))) {
/*  204 */           j = m;
/*      */           break;
/*      */         } 
/*      */       } 
/*  208 */       for (m = i - 1; m >= 0; m--) {
/*  209 */         if (!a(str.charAt(m))) {
/*  210 */           k = m + 1;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*  215 */     return new int[] { k, j };
/*      */   }
/*      */   
/*      */   final int[] a(float paramFloat) {
/*  219 */     return b(letterUnderCursor(paramFloat));
/*      */   }
/*      */   
/*      */   final boolean a(int paramInt) {
/*  223 */     return (this.ab <= 0 || paramInt < this.ab);
/*      */   }
/*      */   
/*      */   public void setMaxLength(int paramInt) {
/*  227 */     this.ab = paramInt;
/*      */   }
/*      */   
/*      */   public int getMaxLength() {
/*  231 */     return this.ab;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOnlyFontChars(boolean paramBoolean) {
/*  238 */     this.B = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setStyle(TextFieldStyle paramTextFieldStyle) {
/*  242 */     if (paramTextFieldStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  243 */     this.t = paramTextFieldStyle;
/*      */     
/*  245 */     this.H = paramTextFieldStyle.font.getCapHeight() - paramTextFieldStyle.font.getDescent() * 2.0F;
/*  246 */     if (this.o != null) j(); 
/*  247 */     invalidateHierarchy();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TextFieldStyle getStyle() {
/*  253 */     return this.t;
/*      */   }
/*      */   
/*      */   protected void g() {
/*  257 */     float f1 = getWidth();
/*      */     Drawable drawable;
/*  259 */     if ((drawable = i()) != null) f1 -= drawable.getLeftWidth() + drawable.getRightWidth();
/*      */     
/*  261 */     int i = this.s.size;
/*  262 */     float[] arrayOfFloat = this.s.items;
/*      */ 
/*      */     
/*  265 */     int j = this.p;
/*  266 */     this.p = MathUtils.clamp(this.p, 0, i - 1);
/*      */     float f2;
/*  268 */     if ((f2 = arrayOfFloat[Math.max(0, this.p - 1)] + this.I) <= 0.0F) {
/*  269 */       this.I -= f2;
/*      */     } else {
/*  271 */       int n = Math.min(i - 1, this.p + 1);
/*  272 */       float f = arrayOfFloat[n] - f1;
/*  273 */       if (-this.I < f) this.I = -f;
/*      */     
/*      */     } 
/*      */     
/*  277 */     f2 = 0.0F;
/*  278 */     float f3 = arrayOfFloat[i - 1];
/*  279 */     for (int k = i - 2; k >= 0; ) {
/*  280 */       float f = arrayOfFloat[k];
/*  281 */       if (f3 - f <= f1) {
/*  282 */         f2 = f; k--;
/*      */       } 
/*  284 */     }  if (-this.I > f2) this.I = -f2;
/*      */ 
/*      */     
/*  287 */     this.Z = 0;
/*  288 */     float f4 = 0.0F; int m;
/*  289 */     for (m = 0; m < i; m++) {
/*  290 */       if (arrayOfFloat[m] >= -this.I) {
/*  291 */         this.Z = m;
/*  292 */         f4 = arrayOfFloat[m];
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/*  298 */     m = this.Z + 1;
/*  299 */     f2 = f1 - this.I;
/*  300 */     for (i = Math.min(this.u.length(), i); m <= i && 
/*  301 */       arrayOfFloat[m] <= f2; m++);
/*  302 */     this.aa = Math.max(0, m - 1);
/*      */     
/*  304 */     if ((this.S & 0x8) == 0) {
/*  305 */       this.Y = f1 - arrayOfFloat[this.aa] - this.X + f4;
/*  306 */       if ((this.S & 0x1) != 0) this.Y = Math.round(this.Y * 0.5F); 
/*      */     } else {
/*  308 */       this.Y = f4 + this.I;
/*      */     } 
/*      */     
/*  311 */     if (this.r) {
/*  312 */       i = Math.min(this.p, this.q);
/*  313 */       int n = Math.max(this.p, this.q);
/*  314 */       float f = Math.max(arrayOfFloat[i] - arrayOfFloat[this.Z], -this.Y);
/*  315 */       f1 = Math.min(arrayOfFloat[n] - arrayOfFloat[this.Z], f1 - this.Y);
/*  316 */       this.T = f;
/*  317 */       this.U = f1 - f - (this.t.font.getData()).cursorX;
/*      */     } 
/*  319 */     if (j != this.p)
/*  320 */       updateContextMenu(); 
/*      */   }
/*      */   
/*      */   @Null
/*      */   protected final Drawable i() {
/*  325 */     if (this.C && this.t.disabledBackground != null) return this.t.disabledBackground; 
/*  326 */     if (this.t.focusedBackground != null && hasKeyboardFocus()) return this.t.focusedBackground; 
/*  327 */     return this.t.background;
/*      */   }
/*      */   
/*      */   public void draw(Batch paramBatch, float paramFloat) {
/*      */     boolean bool;
/*  332 */     if ((bool = hasKeyboardFocus()) != this.J || (bool && !this.M.isScheduled())) {
/*  333 */       this.J = bool;
/*  334 */       e();
/*  335 */       this.M.cancel();
/*  336 */       this.K = bool;
/*  337 */       if (bool)
/*  338 */       { Timer.schedule(this.M, this.L, this.L); }
/*      */       else
/*  340 */       { this.N.cancel(); } 
/*  341 */     } else if (!bool) {
/*  342 */       this.K = false;
/*      */     } 
/*  344 */     BitmapFont bitmapFont = this.t.font;
/*      */     
/*  346 */     Color color1 = (this.C && this.t.disabledFontColor != null) ? this.t.disabledFontColor : ((bool && this.t.focusedFontColor != null) ? this.t.focusedFontColor : this.t.fontColor);
/*  347 */     Drawable drawable1 = this.t.selection;
/*  348 */     Drawable drawable2 = this.t.cursor;
/*  349 */     Drawable drawable3 = i();
/*      */     
/*  351 */     Color color2 = getColor();
/*  352 */     float f3 = getX();
/*  353 */     float f4 = getY();
/*  354 */     float f5 = getWidth();
/*  355 */     float f6 = getHeight();
/*      */     
/*  357 */     paramBatch.setColor(color2.r, color2.g, color2.b, color2.a * paramFloat);
/*  358 */     float f7 = 0.0F, f8 = 0.0F;
/*  359 */     if (drawable3 != null) {
/*  360 */       drawable3.draw(paramBatch, f3, f4, f5, f6);
/*  361 */       f7 = drawable3.getLeftWidth();
/*  362 */       f8 = drawable3.getRightWidth();
/*      */     } 
/*      */     
/*  365 */     float f2 = a(bitmapFont, drawable3);
/*  366 */     g();
/*      */     
/*  368 */     if (bool && this.r && drawable1 != null) {
/*  369 */       a(drawable1, paramBatch, bitmapFont, f3 + f7, f4 + f2);
/*      */     }
/*      */     
/*  372 */     float f1 = bitmapFont.isFlipped() ? -this.H : 0.0F;
/*  373 */     if (this.u.length() == 0) {
/*  374 */       if ((!bool || this.C) && this.R != null) {
/*  375 */         BitmapFont bitmapFont1 = (this.t.messageFont != null) ? this.t.messageFont : bitmapFont;
/*  376 */         if (this.t.messageFontColor != null) {
/*  377 */           bitmapFont1.setColor(this.t.messageFontColor.r, this.t.messageFontColor.g, this.t.messageFontColor.b, this.t.messageFontColor.a * color2.a * paramFloat);
/*      */         } else {
/*      */           
/*  380 */           bitmapFont1.setColor(0.7F, 0.7F, 0.7F, color2.a * paramFloat);
/*  381 */         }  a(paramBatch, bitmapFont1, f3 + f7, f4 + f2 + f1, f5 - f7 - f8);
/*      */       } 
/*      */     } else {
/*      */       BitmapFont.BitmapFontData bitmapFontData;
/*  385 */       boolean bool1 = (bitmapFontData = bitmapFont.getData()).markupEnabled;
/*  386 */       bitmapFontData.markupEnabled = false;
/*  387 */       bitmapFont.setColor(color1.r, color1.g, color1.b, color1.a * color2.a * paramFloat);
/*  388 */       a(paramBatch, bitmapFont, f3 + f7, f4 + f2 + f1);
/*  389 */       bitmapFontData.markupEnabled = bool1;
/*      */     } 
/*  391 */     if (!this.C && this.K && drawable2 != null) {
/*  392 */       b(drawable2, paramBatch, bitmapFont, f3 + f7, f4 + f2);
/*      */     }
/*      */     
/*  395 */     super.draw(paramBatch, paramFloat);
/*      */   }
/*      */   
/*      */   protected float a(BitmapFont paramBitmapFont, @Null Drawable paramDrawable) {
/*  399 */     float f1 = getHeight();
/*  400 */     float f2 = this.H / 2.0F + paramBitmapFont.getDescent();
/*  401 */     if (paramDrawable != null) {
/*  402 */       float f = paramDrawable.getBottomHeight();
/*  403 */       f2 = f2 + (f1 - paramDrawable.getTopHeight() - f) / 2.0F + f;
/*      */     } else {
/*  405 */       f2 += f1 / 2.0F;
/*      */     } 
/*  407 */     if (paramBitmapFont.usesIntegerPositions()) f2 = (int)f2; 
/*  408 */     return f2;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void a(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/*  413 */     paramDrawable.draw(paramBatch, paramFloat1 + this.Y + this.T + this.X, paramFloat2 - this.H - paramBitmapFont.getDescent(), this.U, this.H);
/*      */   }
/*      */ 
/*      */   
/*      */   public void getSelectionBoundingBox(Rectangle paramRectangle) {
/*  418 */     g();
/*  419 */     float f = 0.0F;
/*      */     Drawable drawable;
/*  421 */     if ((drawable = i()) != null) {
/*  422 */       f = drawable.getLeftWidth();
/*      */     }
/*      */     
/*  425 */     if (this.J && this.r) {
/*      */       
/*  427 */       paramRectangle.x = f + this.Y + this.T + this.X;
/*  428 */       paramRectangle.y = a(this.t.font, drawable) - this.H - this.t.font.getDescent();
/*  429 */       paramRectangle.width = this.U;
/*  430 */       paramRectangle.height = this.H;
/*      */       return;
/*      */     } 
/*  433 */     paramRectangle.x = f + this.Y + this.s.get(this.p) - this.s.get(this.Z) + this.X + (this.t.font.getData()).cursorX;
/*  434 */     paramRectangle.y = a(this.t.font, drawable) - this.H - this.t.font.getDescent();
/*  435 */     paramRectangle.width = 0.0F;
/*  436 */     paramRectangle.height = this.H;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void a(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/*  441 */     paramBitmapFont.draw(paramBatch, this.u, paramFloat1 + this.Y, paramFloat2, this.Z, this.aa, 0.0F, 8, false);
/*      */   }
/*      */   
/*      */   private void a(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  445 */     paramBitmapFont.draw(paramBatch, this.R, paramFloat1, paramFloat2, 0, this.R.length(), paramFloat3, this.S, false, "...");
/*      */   }
/*      */   
/*      */   public float getCursorX() {
/*  449 */     return this.Y + this.s.get(this.p) - this.s.get(this.Z) + this.X + (this.t.font.getData()).cursorX;
/*      */   }
/*      */   
/*      */   public float getCursorY() {
/*  453 */     return this.H - this.t.font.getDescent();
/*      */   }
/*      */   
/*      */   protected void b(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/*  457 */     paramDrawable.draw(paramBatch, paramFloat1 + this.Y + this.s
/*  458 */         .get(this.p) - this.s.get(this.Z) + this.X + (paramBitmapFont.getData()).cursorX, paramFloat2 - this.H - paramBitmapFont
/*  459 */         .getDescent(), paramDrawable.getMinWidth(), this.H);
/*      */   }
/*      */   
/*      */   final void j() {
/*      */     BitmapFont bitmapFont;
/*  464 */     BitmapFont.BitmapFontData bitmapFontData = (bitmapFont = this.t.font).getData();
/*      */     String str1;
/*  466 */     int i = (str1 = this.o).length();
/*      */     
/*  468 */     StringBuilder stringBuilder = new StringBuilder();
/*  469 */     for (byte b = 0; b < i; b++) {
/*  470 */       char c = str1.charAt(b);
/*  471 */       stringBuilder.append(bitmapFontData.hasGlyph(c) ? c : 32);
/*      */     } 
/*  473 */     String str2 = stringBuilder.toString();
/*      */     
/*  475 */     if (this.G && bitmapFontData.hasGlyph(this.W)) {
/*  476 */       if (this.V == null) this.V = new StringBuilder(str2.length()); 
/*  477 */       if (this.V.length() > i) {
/*  478 */         this.V.setLength(i);
/*      */       } else {
/*  480 */         for (int j = this.V.length(); j < i; j++)
/*  481 */           this.V.append(this.W); 
/*      */       } 
/*  483 */       this.u = this.V;
/*      */     } else {
/*  485 */       this.u = str2;
/*      */     } 
/*  487 */     boolean bool = bitmapFontData.markupEnabled;
/*  488 */     bitmapFontData.markupEnabled = false;
/*  489 */     this.Q.setText(bitmapFont, this.u.toString().replace('\r', ' ').replace('\n', ' '));
/*  490 */     bitmapFontData.markupEnabled = bool;
/*      */     
/*  492 */     this.s.clear();
/*  493 */     float f = 0.0F;
/*  494 */     if (this.Q.runs.size > 0) {
/*      */       GlyphLayout.GlyphRun glyphRun;
/*  496 */       FloatArray floatArray = (glyphRun = (GlyphLayout.GlyphRun)this.Q.runs.first()).xAdvances;
/*  497 */       this.X = floatArray.first(); byte b1; int j;
/*  498 */       for (b1 = 1, j = floatArray.size; b1 < j; b1++) {
/*  499 */         this.s.add(f);
/*  500 */         f += floatArray.get(b1);
/*      */       } 
/*      */     } else {
/*  503 */       this.X = 0.0F;
/*  504 */     }  this.s.add(f);
/*      */     
/*  506 */     this.Z = Math.min(this.Z, this.s.size - 1);
/*  507 */     this.aa = MathUtils.clamp(this.aa, this.Z, this.s.size - 1);
/*      */     
/*  509 */     if (this.q > str2.length()) this.q = i;
/*      */   
/*      */   }
/*      */   
/*      */   public void copy() {
/*  514 */     if (this.r && !this.G) {
/*  515 */       this.v.setContents(this.o.substring(Math.min(this.p, this.q), Math.max(this.p, this.q)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void cut() {
/*  522 */     a(this.ad);
/*      */   }
/*      */   
/*      */   final void a(boolean paramBoolean) {
/*  526 */     if (this.r && !this.G) {
/*  527 */       copy();
/*  528 */       this.p = b(paramBoolean);
/*  529 */       j();
/*  530 */       updateContextMenu();
/*      */     } 
/*      */   }
/*      */   
/*      */   final void a(@Null String paramString, boolean paramBoolean) {
/*  535 */     if (paramString == null)
/*  536 */       return;  StringBuilder stringBuilder = new StringBuilder();
/*  537 */     int i = this.o.length();
/*  538 */     if (this.r) i -= Math.abs(this.p - this.q); 
/*  539 */     BitmapFont.BitmapFontData bitmapFontData = this.t.font.getData(); byte b; int j;
/*  540 */     for (b = 0, j = paramString.length(); b < j && 
/*  541 */       a(i + stringBuilder.length()); b++) {
/*  542 */       char c = paramString.charAt(b);
/*  543 */       if ((this.writeEnters && (c == '\n' || c == '\r')) || (
/*  544 */         c != '\r' && c != '\n' && (
/*  545 */         !this.B || bitmapFontData.hasGlyph(c)) && (
/*  546 */         this.y == null || this.y.acceptChar(this, c))))
/*      */       {
/*  548 */         stringBuilder.append(c); } 
/*      */     } 
/*  550 */     paramString = stringBuilder.toString();
/*      */     
/*  552 */     if (this.r) this.p = b(paramBoolean); 
/*  553 */     if (paramBoolean) {
/*  554 */       a(this.o, a(this.p, paramString, this.o));
/*      */     } else {
/*  556 */       this.o = a(this.p, paramString, this.o);
/*  557 */     }  j();
/*  558 */     this.p += paramString.length();
/*  559 */     updateContextMenu();
/*      */   }
/*      */   
/*      */   static String a(int paramInt, CharSequence paramCharSequence, String paramString) {
/*  563 */     if (paramString.length() == 0) return paramCharSequence.toString(); 
/*  564 */     return paramString.substring(0, paramInt) + paramCharSequence + paramString.substring(paramInt, paramString.length());
/*      */   }
/*      */   
/*      */   final int b(boolean paramBoolean) {
/*  568 */     int i = this.q;
/*  569 */     int j = this.p;
/*  570 */     int k = Math.min(i, j);
/*  571 */     i = Math.max(i, j);
/*      */     
/*  573 */     String str = ((k > 0) ? this.o.substring(0, k) : "") + ((i < this.o.length()) ? this.o.substring(i, this.o.length()) : "");
/*  574 */     if (paramBoolean) {
/*  575 */       a(this.o, str);
/*      */     } else {
/*  577 */       this.o = str;
/*  578 */     }  clearSelection();
/*  579 */     return k;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void next(boolean paramBoolean) {
/*      */     Stage stage;
/*  587 */     if ((stage = getStage()) == null)
/*      */       return;  TextField textField;
/*  589 */     Vector2 vector21 = (textField = this).getParent().localToStageCoordinates(m.set(textField.getX(), textField.getY()));
/*  590 */     Vector2 vector22 = l;
/*      */     while (true) {
/*      */       TextField textField1;
/*  593 */       if ((textField1 = textField.a(stage.getActors(), (TextField)null, vector22, vector21, paramBoolean)) == null) {
/*  594 */         if (paramBoolean) {
/*  595 */           vector21.set(-3.4028235E38F, -3.4028235E38F);
/*      */         } else {
/*  597 */           vector21.set(Float.MAX_VALUE, Float.MAX_VALUE);
/*  598 */         }  textField1 = textField.a(stage.getActors(), (TextField)null, vector22, vector21, paramBoolean);
/*      */       } 
/*  600 */       if (textField1 == null) {
/*  601 */         Gdx.input.setOnscreenKeyboardVisible(false);
/*      */         return;
/*      */       } 
/*  604 */       if (stage.setKeyboardFocus((Actor)textField1)) {
/*  605 */         textField1.selectAll();
/*      */         return;
/*      */       } 
/*  608 */       textField = textField1;
/*  609 */       vector21.set(vector22);
/*      */     } 
/*      */   }
/*      */   @Null
/*      */   private TextField a(Array<Actor> paramArray, @Null TextField paramTextField, Vector2 paramVector21, Vector2 paramVector22, boolean paramBoolean) {
/*      */     byte b;
/*      */     int i;
/*  616 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*      */       Actor actor;
/*  618 */       if (actor = (Actor)paramArray.get(b) instanceof TextField) {
/*  619 */         TextField textField; if (actor != this && 
/*      */           
/*  621 */           !(textField = (TextField)actor).isDisabled() && textField.A && textField.ascendantsVisible()) {
/*      */           Vector2 vector2;
/*  623 */           boolean bool1 = ((vector2 = actor.getParent().localToStageCoordinates(n.set(actor.getX(), actor.getY()))).y != paramVector22.y && (((vector2.y < paramVector22.y) ? 1 : 0) ^ paramBoolean) != 0) ? true : false;
/*  624 */           boolean bool2 = (vector2.y == paramVector22.y && (((vector2.x > paramVector22.x) ? 1 : 0) ^ paramBoolean) != 0) ? true : false;
/*  625 */           if (bool1 || bool2)
/*      */           
/*  627 */           { if (!(bool1 = (paramTextField == null || (vector2.y != paramVector21.y && (((vector2.y > paramVector21.y) ? 1 : 0) ^ paramBoolean) != 0)) ? true : false)) bool1 = (vector2.y == paramVector21.y && (((vector2.x < paramVector21.x) ? 1 : 0) ^ paramBoolean) != 0) ? true : false; 
/*  628 */             if (bool1)
/*  629 */             { paramTextField = (TextField)actor;
/*  630 */               paramVector21.set(vector2); }  } 
/*      */         } 
/*  632 */       } else if (actor instanceof Group) {
/*  633 */         paramTextField = a((Array<Actor>)((Group)actor).getChildren(), paramTextField, paramVector21, paramVector22, paramBoolean);
/*      */       } 
/*  635 */     }  return paramTextField;
/*      */   }
/*      */   
/*      */   public InputListener getDefaultInputListener() {
/*  639 */     return this.w;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTextFieldListener(@Null TextFieldListener paramTextFieldListener) {
/*  644 */     this.x = paramTextFieldListener;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTextFieldFilter(@Null TextFieldFilter paramTextFieldFilter) {
/*  649 */     this.y = paramTextFieldFilter;
/*      */   }
/*      */   @Null
/*      */   public TextFieldFilter getTextFieldFilter() {
/*  653 */     return this.y;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFocusTraversal(boolean paramBoolean) {
/*  658 */     this.A = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getFocusTraversal() {
/*  662 */     return this.A;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public String getMessageText() {
/*  667 */     return this.R;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMessageText(@Null String paramString) {
/*  673 */     this.R = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   public void appendText(@Null String paramString) {
/*  678 */     if (paramString == null) paramString = "";
/*      */     
/*  680 */     clearSelection();
/*  681 */     this.p = this.o.length();
/*  682 */     a(paramString, this.ad);
/*  683 */     updateContextMenu();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setText(@Null String paramString) {
/*  688 */     if (paramString == null) paramString = ""; 
/*  689 */     if (paramString.equals(this.o))
/*      */       return; 
/*  691 */     clearSelection();
/*  692 */     String str = this.o;
/*  693 */     this.o = "";
/*  694 */     a(paramString, false);
/*  695 */     if (this.ad) a(str, this.o); 
/*  696 */     this.p = 0;
/*  697 */     updateContextMenu();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getText() {
/*  702 */     return this.o;
/*      */   }
/*      */ 
/*      */   
/*      */   final boolean a(String paramString1, String paramString2) {
/*  707 */     if (paramString2.equals(paramString1)) return false; 
/*  708 */     this.o = paramString2;
/*  709 */     ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/*      */     boolean bool;
/*  711 */     if (bool = fire((Event)changeEvent)) this.o = paramString1; 
/*  712 */     Pools.free(changeEvent);
/*  713 */     return !bool;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/*  719 */     this.ad = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getProgrammaticChangeEvents() {
/*  723 */     return this.ad;
/*      */   }
/*      */   
/*      */   public int getSelectionStart() {
/*  727 */     return this.q;
/*      */   }
/*      */   
/*      */   public String getSelection() {
/*  731 */     if (this.r) {
/*  732 */       int i = Math.min(this.q, this.p);
/*  733 */       int j = Math.max(this.q, this.p);
/*  734 */       i = MathUtils.clamp(i, 0, this.o.length());
/*  735 */       j = MathUtils.clamp(j, 0, this.o.length());
/*  736 */       if (i == -1 || j == -1) {
/*  737 */         return "";
/*      */       }
/*  739 */       return this.o.substring(i, j);
/*      */     } 
/*  741 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelection(int paramInt1, int paramInt2) {
/*  747 */     if (paramInt1 < 0) throw new IllegalArgumentException("selectionStart must be >= 0"); 
/*  748 */     if (paramInt2 < 0) throw new IllegalArgumentException("selectionEnd must be >= 0"); 
/*  749 */     paramInt1 = Math.min(this.o.length(), paramInt1);
/*      */     
/*  751 */     if ((paramInt2 = Math.min(this.o.length(), paramInt2)) == paramInt1) {
/*  752 */       clearSelection();
/*      */       return;
/*      */     } 
/*  755 */     if (paramInt2 < paramInt1) {
/*  756 */       int i = paramInt2;
/*  757 */       paramInt2 = paramInt1;
/*  758 */       paramInt1 = i;
/*      */     } 
/*      */     
/*  761 */     this.r = true;
/*  762 */     this.q = paramInt1;
/*  763 */     this.p = paramInt2;
/*  764 */     updateContextMenu();
/*      */   }
/*      */   
/*      */   public void selectAll() {
/*  768 */     setSelection(0, this.o.length());
/*      */   }
/*      */   
/*      */   public void clearSelection() {
/*  772 */     this.r = false;
/*  773 */     updateContextMenu();
/*      */   }
/*      */   
/*      */   private void e() {
/*  777 */     this.O = -1;
/*  778 */     updateContextMenu();
/*      */   }
/*      */   
/*      */   public void updateContextMenu() {
/*  782 */     if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS) {
/*      */       
/*  784 */       boolean bool = false;
/*  785 */       if (this.J)
/*      */       {
/*  787 */         if (bool = (getSelection().length() != 0 || this.P) ? true : false) {
/*  788 */           if (this.ac == null) {
/*  789 */             this.ac = new ContextMenu(this);
/*  790 */             addActor((Actor)this.ac);
/*      */           } 
/*  792 */           this.ac.update();
/*      */         } 
/*      */       }
/*  795 */       if (!bool && 
/*  796 */         this.ac != null) {
/*  797 */         this.ac.remove();
/*  798 */         this.ac = null;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCursorPosition(int paramInt) {
/*  806 */     if (paramInt < 0) throw new IllegalArgumentException("cursorPosition must be >= 0"); 
/*  807 */     clearSelection();
/*  808 */     this.p = Math.min(paramInt, this.o.length());
/*  809 */     updateContextMenu();
/*      */   }
/*      */   
/*      */   public int getCursorPosition() {
/*  813 */     return this.p;
/*      */   }
/*      */ 
/*      */   
/*      */   public OnscreenKeyboard getOnscreenKeyboard() {
/*  818 */     return this.z;
/*      */   }
/*      */   
/*      */   public void setOnscreenKeyboard(OnscreenKeyboard paramOnscreenKeyboard) {
/*  822 */     this.z = paramOnscreenKeyboard;
/*      */   }
/*      */   
/*      */   public void setClipboard(Clipboard paramClipboard) {
/*  826 */     this.v = paramClipboard;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  830 */     return 150.0F;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  834 */     float f1 = 0.0F, f2 = 0.0F;
/*  835 */     if (this.t.background != null) {
/*  836 */       f1 = Math.max(0.0F, this.t.background.getBottomHeight() + this.t.background.getTopHeight());
/*  837 */       f2 = Math.max(0.0F, this.t.background.getMinHeight());
/*      */     } 
/*  839 */     if (this.t.focusedBackground != null) {
/*  840 */       f1 = Math.max(f1, this.t.focusedBackground
/*  841 */           .getBottomHeight() + this.t.focusedBackground.getTopHeight());
/*  842 */       f2 = Math.max(f2, this.t.focusedBackground.getMinHeight());
/*      */     } 
/*  844 */     if (this.t.disabledBackground != null) {
/*  845 */       f1 = Math.max(f1, this.t.disabledBackground
/*  846 */           .getBottomHeight() + this.t.disabledBackground.getTopHeight());
/*  847 */       f2 = Math.max(f2, this.t.disabledBackground.getMinHeight());
/*      */     } 
/*  849 */     return Math.max(f1 + this.H, f2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlignment(int paramInt) {
/*  855 */     this.S = paramInt;
/*      */   }
/*      */   
/*      */   public int getAlignment() {
/*  859 */     return this.S;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPasswordMode(boolean paramBoolean) {
/*  865 */     this.G = paramBoolean;
/*  866 */     j();
/*      */   }
/*      */   
/*      */   public boolean isPasswordMode() {
/*  870 */     return this.G;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPasswordCharacter(char paramChar) {
/*  876 */     this.W = paramChar;
/*  877 */     if (this.G) j(); 
/*      */   }
/*      */   
/*      */   public void setBlinkTime(float paramFloat) {
/*  881 */     this.L = paramFloat;
/*      */   }
/*      */   
/*      */   public void setDisabled(boolean paramBoolean) {
/*  885 */     this.C = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isDisabled() {
/*  889 */     return this.C;
/*      */   }
/*      */   
/*      */   protected void a(boolean paramBoolean1, boolean paramBoolean2) {
/*  893 */     byte b = paramBoolean1 ? this.o.length() : 0;
/*  894 */     boolean bool = paramBoolean1 ? false : true; do {  }
/*  895 */     while ((paramBoolean1 ? (++this.p < b) : (--this.p > b)) && paramBoolean2 && 
/*  896 */       a(this.p, bool));
/*      */     
/*  898 */     updateContextMenu();
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean a(int paramInt1, int paramInt2) {
/*  903 */     return a(paramInt1 = this.o.charAt(paramInt1 + paramInt2));
/*      */   }
/*      */   class KeyRepeatTask extends Timer.Task { int a;
/*      */     
/*      */     KeyRepeatTask(TextField this$0) {}
/*      */     
/*      */     public void run() {
/*  910 */       if (this.b.getStage() == null) {
/*  911 */         cancel();
/*      */         return;
/*      */       } 
/*  914 */       this.b.w.keyDown(null, this.a);
/*      */     } }
/*      */ 
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
/*  931 */         return Character.isDigit(param2Char);
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
/*  947 */       Gdx.input.setOnscreenKeyboardVisible(param1Boolean);
/*      */     }
/*      */   }
/*      */   
/*      */   public class TextFieldClickListener extends ClickListener {
/*      */     public TextFieldClickListener(TextField this$0) {}
/*      */     
/*      */     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*      */       int i;
/*  956 */       if ((i = getTapCount() % 4) == 0) this.a.clearSelection(); 
/*  957 */       if (i == 2) {
/*  958 */         int[] arrayOfInt = this.a.a(param1Float1);
/*  959 */         this.a.setSelection(arrayOfInt[0], arrayOfInt[1]);
/*      */       } 
/*  961 */       if (i == 3) this.a.selectAll();
/*      */     
/*      */     }
/*      */     
/*      */     public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  966 */       if (!super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2)) return false; 
/*  967 */       if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  968 */       if (this.a.C) return true; 
/*  969 */       a(param1Float1, param1Float2);
/*  970 */       if (TextField.a(this.a) == this.a.p) {
/*      */         
/*  972 */         TextField.a(this.a, true);
/*      */       } else {
/*  974 */         TextField.a(this.a, false);
/*  975 */         TextField.a(this.a, this.a.p);
/*      */       } 
/*  977 */       this.a.q = this.a.p;
/*      */       Stage stage;
/*  979 */       if ((stage = this.a.getStage()) != null) stage.setKeyboardFocus((Actor)this.a); 
/*  980 */       this.a.z.show(true);
/*  981 */       this.a.r = true;
/*  982 */       this.a.updateContextMenu();
/*  983 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  988 */       super.touchDragged(param1InputEvent, param1Float1, param1Float2, param1Int);
/*  989 */       a(param1Float1, param1Float2);
/*      */     }
/*      */ 
/*      */     
/*      */     public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  994 */       if (this.a.q == this.a.p) this.a.r = false; 
/*  995 */       this.a.updateContextMenu();
/*  996 */       super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*      */     }
/*      */     
/*      */     protected void a(float param1Float1, float param1Float2) {
/* 1000 */       this.a.p = this.a.letterUnderCursor(param1Float1);
/*      */       
/* 1002 */       this.a.K = this.a.J;
/* 1003 */       this.a.M.cancel();
/* 1004 */       if (this.a.J) Timer.schedule(this.a.M, this.a.L, this.a.L); 
/* 1005 */       this.a.updateContextMenu();
/*      */     }
/*      */     
/*      */     protected void a(boolean param1Boolean) {
/* 1009 */       this.a.p = 0;
/* 1010 */       this.a.updateContextMenu();
/*      */     }
/*      */     
/*      */     protected void b(boolean param1Boolean) {
/* 1014 */       this.a.p = this.a.o.length();
/* 1015 */       this.a.updateContextMenu();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/* 1020 */       if (this.a.C) return false;
/*      */ 
/*      */       
/* 1023 */       TextField.a(this.a, false);
/*      */       
/* 1025 */       this.a.K = this.a.J;
/* 1026 */       this.a.M.cancel();
/* 1027 */       if (this.a.J) Timer.schedule(this.a.M, this.a.L, this.a.L);
/*      */       
/* 1029 */       if (!this.a.hasKeyboardFocus()) return false;
/*      */       
/* 1031 */       int i = 0;
/*      */       boolean bool;
/* 1033 */       boolean bool1 = ((bool = UIUtils.ctrl()) && !this.a.G) ? true : false;
/* 1034 */       boolean bool2 = true;
/*      */       
/* 1036 */       if (bool) {
/* 1037 */         String str; switch (param1Int) {
/*      */           case 50:
/* 1039 */             this.a.a(this.a.v.getContents(), true);
/* 1040 */             i = 1;
/*      */             break;
/*      */           case 31:
/*      */           case 124:
/* 1044 */             this.a.copy();
/* 1045 */             return true;
/*      */           case 52:
/* 1047 */             this.a.a(true);
/* 1048 */             return true;
/*      */           case 29:
/* 1050 */             this.a.selectAll();
/* 1051 */             return true;
/*      */           case 54:
/* 1053 */             str = this.a.o;
/* 1054 */             i = this.a.p;
/* 1055 */             this.a.setText(this.a.D);
/* 1056 */             this.a.setCursorPosition(this.a.E);
/* 1057 */             this.a.D = str;
/* 1058 */             this.a.E = i;
/* 1059 */             this.a.j();
/* 1060 */             return true;
/*      */           default:
/* 1062 */             bool2 = false;
/*      */             break;
/*      */         } 
/*      */       } 
/* 1066 */       if (UIUtils.shift())
/* 1067 */       { switch (param1Int) {
/*      */           case 124:
/* 1069 */             this.a.a(this.a.v.getContents(), true);
/*      */             break;
/*      */           case 112:
/* 1072 */             this.a.a(true);
/*      */             break;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1078 */         int j = this.a.p;
/*      */ 
/*      */         
/* 1081 */         switch (param1Int)
/*      */         { case 21:
/* 1083 */             this.a.a(false, bool1);
/* 1084 */             i = 1;
/* 1085 */             bool2 = true;
/*      */             break;
/*      */           case 22:
/* 1088 */             this.a.a(true, bool1);
/* 1089 */             i = 1;
/* 1090 */             bool2 = true;
/*      */             break;
/*      */           case 3:
/* 1093 */             a(bool1);
/* 1094 */             bool2 = true;
/*      */             break;
/*      */           case 123:
/* 1097 */             b(bool1);
/* 1098 */             bool2 = true;
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
/* 1145 */             this.a.p = MathUtils.clamp(this.a.p, 0, this.a.o.length());
/* 1146 */             this.a.updateContextMenu();
/*      */             
/* 1148 */             if (i != 0) a(param1Int); 
/* 1149 */             return bool2; }  if (!this.a.r) { this.a.q = j; this.a.r = true; this.a.updateContextMenu(); }  }  switch (param1Int) { case 21: if (this.a.r) { this.a.setCursorPosition(Math.min(this.a.p, this.a.q)); } else { this.a.a(false, bool1); }  this.a.clearSelection(); i = 1; bool2 = true;
/*      */         case 22: if (this.a.r) { this.a.setCursorPosition(Math.max(this.a.p, this.a.q)); } else { this.a.a(true, bool1); }  this.a.clearSelection(); i = 1; bool2 = true;
/*      */         case 3: a(bool1); this.a.clearSelection(); bool2 = true;
/*      */         case 123:
/* 1153 */           b(bool1); this.a.clearSelection(); bool2 = true; }  } protected final void a(int param1Int) { if (!this.a.N.isScheduled() || this.a.N.a != param1Int) {
/* 1154 */         this.a.N.a = param1Int;
/* 1155 */         this.a.N.cancel();
/* 1156 */         Timer.schedule(this.a.N, TextField.keyRepeatInitialTime, TextField.keyRepeatTime);
/*      */       }  }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean keyUp(InputEvent param1InputEvent, int param1Int) {
/* 1162 */       if (this.a.C) return false; 
/* 1163 */       this.a.N.cancel();
/* 1164 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean a(char param1Char) {
/* 1172 */       return (this.a.A && (param1Char == '\t' || ((param1Char == '\r' || param1Char == '\n') && (UIUtils.isAndroid || UIUtils.isIos))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int b(int param1Int) {
/* 1180 */       for (param1Int = Math.min(param1Int, this.a.o.length()) - 1; param1Int >= 0; param1Int--) {
/* 1181 */         if (this.a.o.charAt(param1Int) == '\n') {
/* 1182 */           return param1Int;
/*      */         }
/*      */       } 
/* 1185 */       return -1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private IntPair c(int param1Int) {
/* 1192 */       param1Int = b(param1Int);
/* 1193 */       int i = 0; int j;
/* 1194 */       for (j = param1Int + 1; j < this.a.o.length() && (
/* 1195 */         this.a.o.charAt(j) == ' ' || this.a.o.charAt(j) == '\t'); j++) {
/* 1196 */         i++;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1201 */       if (i > 0) {
/*      */ 
/*      */         
/* 1204 */         if ((j = i % 4) == 0) {
/* 1205 */           j = 4;
/*      */         }
/* 1207 */         i = param1Int + 1;
/* 1208 */         param1Int = param1Int + 1 + j;
/* 1209 */         this.a.o = this.a.o.substring(0, i) + this.a.o.substring(param1Int);
/* 1210 */         return new IntPair(i, param1Int);
/*      */       } 
/* 1212 */       return new IntPair(0, 0);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/* 1218 */       if (this.a.C) return false;
/*      */ 
/*      */       
/* 1221 */       switch (param1Char) {
/*      */         case '\b':
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\r':
/*      */           break;
/*      */         default:
/* 1228 */           if (param1Char < ' ') return false; 
/*      */           break;
/*      */       } 
/* 1231 */       if (!this.a.hasKeyboardFocus()) return false;
/*      */       
/* 1233 */       if (UIUtils.isMac && Gdx.input.isKeyPressed(63)) return true;
/*      */       
/* 1235 */       String str = this.a.o;
/* 1236 */       int i = this.a.p;
/*      */       
/* 1238 */       if (a(param1Char)) {
/* 1239 */         this.a.next(UIUtils.shift());
/* 1240 */       } else if (this.a.replaceTabsWithSpaces && param1Char == '\t') {
/*      */         
/* 1242 */         if (UIUtils.shift()) {
/*      */           
/* 1244 */           if (this.a.r && this.a.q != this.a.p)
/*      */           {
/*      */             
/* 1247 */             boolean bool = (this.a.p > this.a.q) ? true : false;
/* 1248 */             int k = Math.min(this.a.q, this.a.p);
/*      */ 
/*      */             
/* 1251 */             int j = Math.max(this.a.q, this.a.p), m = j;
/* 1252 */             while (m >= 0) {
/* 1253 */               int n = b(m);
/*      */               IntPair intPair;
/* 1255 */               for (int i1 = (intPair = c(m)).a; i1 < intPair.b; i1++) {
/* 1256 */                 if (i1 < k) {
/* 1257 */                   k--;
/* 1258 */                   j--;
/* 1259 */                 } else if (i1 < j) {
/* 1260 */                   j--;
/*      */                 } 
/*      */               } 
/* 1263 */               if (n >= Math.min(this.a.q, this.a.p))
/*      */               {
/*      */                 
/* 1266 */                 int i2 = n - 1;
/*      */               }
/*      */             } 
/* 1269 */             if (bool) {
/* 1270 */               this.a.q = k;
/* 1271 */               this.a.p = j;
/*      */             } else {
/* 1273 */               this.a.q = j;
/* 1274 */               this.a.p = k;
/*      */             }
/*      */           
/*      */           }
/*      */           else
/*      */           {
/* 1280 */             int j = b(this.a.p);
/* 1281 */             IntPair intPair = c(this.a.p);
/* 1282 */             this.a.p = Math.max(this.a.p - intPair.b - intPair.a, j + 1);
/*      */           }
/*      */         
/* 1285 */         } else if (this.a.r && this.a.q != this.a.p) {
/*      */           
/* 1287 */           boolean bool = (this.a.p > this.a.q) ? true : false;
/* 1288 */           int k = Math.min(this.a.q, this.a.p);
/*      */           
/* 1290 */           int j = Math.max(this.a.q, this.a.p), m = j;
/*      */           
/* 1292 */           while (m >= 0) {
/*      */             int n;
/* 1294 */             m = (n = b(m)) + 1;
/*      */             
/* 1296 */             byte b = 0; int i1;
/* 1297 */             for (i1 = n + 1; i1 < this.a.o.length() && (
/* 1298 */               this.a.o.charAt(i1) == ' ' || this.a.o.charAt(i1) == '\t'); i1++) {
/* 1299 */               b++;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1305 */             i1 = 4 - b % 4;
/* 1306 */             StringBuilder stringBuilder = new StringBuilder(); int i2;
/* 1307 */             for (i2 = 0; i2 < i1; i2++) {
/* 1308 */               stringBuilder.append(' ');
/*      */             }
/* 1310 */             this.a.o = TextField.a(m, stringBuilder, this.a.o);
/*      */             
/* 1312 */             for (i2 = m; i2 < m + i1; i2++) {
/* 1313 */               if (i2 < k) {
/* 1314 */                 k++;
/* 1315 */                 j++;
/* 1316 */               } else if (i2 < j) {
/* 1317 */                 j++;
/*      */               } 
/*      */             } 
/*      */             
/* 1321 */             if (n >= Math.min(this.a.q, this.a.p))
/*      */             {
/*      */               
/* 1324 */               m = n - 1;
/*      */             }
/*      */           } 
/* 1327 */           if (bool) {
/* 1328 */             this.a.q = k;
/* 1329 */             this.a.p = j;
/*      */           } else {
/* 1331 */             this.a.q = j;
/* 1332 */             this.a.p = k;
/*      */           }
/*      */         
/*      */         }
/*      */         else {
/*      */           
/* 1338 */           int k, m = (k = b(this.a.p)) + 1;
/* 1339 */           int j = 4 - (this.a.p - m) % 4;
/*      */           
/* 1341 */           StringBuilder stringBuilder = new StringBuilder();
/* 1342 */           for (byte b = 0; b < j; b++) {
/* 1343 */             stringBuilder.append(' ');
/*      */           }
/* 1345 */           this.a.o = TextField.a(this.a.p, stringBuilder, this.a.o);
/* 1346 */           this.a.p += j;
/*      */         } 
/*      */       } else {
/*      */         
/* 1350 */         boolean bool2 = (param1Char == '\r' || param1Char == '\n') ? true : false;
/* 1351 */         boolean bool3 = (param1Char == '') ? true : false;
/* 1352 */         boolean bool1 = (param1Char == '\b') ? true : false;
/* 1353 */         boolean bool4 = bool2 ? this.a.writeEnters : ((!this.a.B || this.a.t.font.getData().hasGlyph(param1Char)) ? true : false);
/* 1354 */         boolean bool5 = (bool1 || bool3) ? true : false;
/* 1355 */         if (bool4 || bool5) {
/* 1356 */           if (bool5) {
/* 1357 */             if (this.a.r) {
/* 1358 */               this.a.p = this.a.b(false);
/*      */             } else {
/* 1360 */               if (bool1 && this.a.p > 0) {
/* 1361 */                 this.a.o = this.a.o.substring(0, this.a.p - 1) + this.a.o.substring(this.a.p--);
/* 1362 */                 this.a.I = 0.0F;
/*      */               } 
/* 1364 */               if (bool3 && this.a.p < this.a.o.length()) {
/* 1365 */                 this.a.o = this.a.o.substring(0, this.a.p) + this.a.o.substring(this.a.p + 1);
/*      */               }
/*      */             } 
/*      */           }
/* 1369 */           if (bool4 && !bool5) {
/*      */             
/* 1371 */             if (!bool2 && this.a.y != null && !this.a.y.acceptChar(this.a, param1Char)) return true; 
/* 1372 */             if (!this.a.a(this.a.o.length() - (this.a.r ? Math.abs(this.a.p - this.a.q) : 0))) return true; 
/* 1373 */             if (this.a.r) this.a.p = this.a.b(false); 
/* 1374 */             String str1 = bool2 ? "\n" : String.valueOf(param1Char);
/* 1375 */             this.a.o = TextField.a(this.a.p++, str1, this.a.o);
/*      */           } 
/*      */         } 
/*      */       } 
/* 1379 */       if (this.a.a(str, this.a.o)) {
/*      */         long l;
/* 1381 */         if ((l = System.currentTimeMillis()) - 500L > this.a.F) {
/* 1382 */           this.a.D = str;
/* 1383 */           this.a.E = i;
/*      */         } 
/* 1385 */         this.a.F = l;
/* 1386 */         this.a.j();
/* 1387 */       } else if (!this.a.o.equals(str)) {
/* 1388 */         this.a.p = i;
/*      */       } 
/* 1390 */       this.a.updateContextMenu();
/* 1391 */       if (this.a.x != null) this.a.x.keyTyped(this.a, param1Char); 
/* 1392 */       return true;
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
/* 1412 */       this.font = param1BitmapFont;
/* 1413 */       this.fontColor = param1Color;
/* 1414 */       this.cursor = param1Drawable1;
/* 1415 */       this.selection = param1Drawable2;
/* 1416 */       this.background = param1Drawable3;
/*      */     }
/*      */     
/*      */     public TextFieldStyle(TextFieldStyle param1TextFieldStyle) {
/* 1420 */       this.font = param1TextFieldStyle.font;
/* 1421 */       if (param1TextFieldStyle.fontColor != null) this.fontColor = new Color(param1TextFieldStyle.fontColor); 
/* 1422 */       if (param1TextFieldStyle.focusedFontColor != null) this.focusedFontColor = new Color(param1TextFieldStyle.focusedFontColor); 
/* 1423 */       if (param1TextFieldStyle.disabledFontColor != null) this.disabledFontColor = new Color(param1TextFieldStyle.disabledFontColor);
/*      */       
/* 1425 */       this.background = param1TextFieldStyle.background;
/* 1426 */       this.focusedBackground = param1TextFieldStyle.focusedBackground;
/* 1427 */       this.disabledBackground = param1TextFieldStyle.disabledBackground;
/* 1428 */       this.cursor = param1TextFieldStyle.cursor;
/* 1429 */       this.selection = param1TextFieldStyle.selection;
/*      */       
/* 1431 */       this.messageFont = param1TextFieldStyle.messageFont;
/* 1432 */       if (param1TextFieldStyle.messageFontColor != null) this.messageFontColor = new Color(param1TextFieldStyle.messageFontColor); 
/*      */     } }
/*      */ 
/*      */   
/*      */   public class ContextMenu extends Table {
/* 1437 */     private final Rectangle k = new Rectangle();
/*      */     
/*      */     private Image l;
/*      */     private TableButton n;
/*      */     private TableButton o;
/*      */     private TableButton p;
/*      */     
/*      */     public ContextMenu(TextField this$0) {
/* 1445 */       background((Drawable)Game.i.assetManager.getQuad("ui.textField.contextMenu.bg"));
/* 1446 */       this.l = new Image((Drawable)Game.i.assetManager.getQuad("ui.textField.contextMenu.bgArrow"));
/* 1447 */       addActor(this.l);
/* 1448 */       this.l.setTouchable(Touchable.disabled);
/* 1449 */       setTouchable(Touchable.enabled);
/*      */       
/* 1451 */       this.n = new TableButton(this$0::copy);
/* 1452 */       Label label = new Label(Game.i.localeManager.i18n.get("text_field_context_copy"), Game.i.assetManager.getLabelStyle(21));
/* 1453 */       this.n.add((Actor)label).pad(10.0F).padLeft(20.0F).padRight(20.0F);
/* 1454 */       this.n.setContentColors(Color.WHITE, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500, MaterialColor.BLUE_GREY.P500);
/*      */       
/* 1456 */       this.o = new TableButton(() -> this.q.a(true));
/* 1457 */       label = new Label(Game.i.localeManager.i18n.get("text_field_context_cut"), Game.i.assetManager.getLabelStyle(21));
/* 1458 */       this.o.add((Actor)label).pad(10.0F).padLeft(20.0F).padRight(20.0F);
/* 1459 */       this.o.setContentColors(Color.WHITE, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500, MaterialColor.BLUE_GREY.P500);
/*      */       
/* 1461 */       this.p = new TableButton(() -> this.q.a(Gdx.app.getClipboard().getContents(), true));
/* 1462 */       label = new Label(Game.i.localeManager.i18n.get("text_field_context_paste"), Game.i.assetManager.getLabelStyle(21));
/* 1463 */       this.p.add((Actor)label).pad(10.0F).padLeft(20.0F).padRight(20.0F);
/* 1464 */       this.p.setContentColors(Color.WHITE, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500, MaterialColor.BLUE_GREY.P500);
/*      */     }
/*      */     
/*      */     public void update() {
/*      */       try {
/* 1469 */         if (this.q.getSelection().length() != 0 || TextField.b(this.q)) {
/* 1470 */           clear();
/* 1471 */           if (this.q.getSelection().length() != 0) {
/* 1472 */             add(this.n);
/* 1473 */             add(new Image((Drawable)Game.i.assetManager.getQuad("ui.textField.contextMenu.delimiter"))).width(2.0F).fillY();
/* 1474 */             add(this.o);
/* 1475 */             add(new Image((Drawable)Game.i.assetManager.getQuad("ui.textField.contextMenu.delimiter"))).width(2.0F).fillY();
/*      */           } 
/* 1477 */           add(this.p);
/* 1478 */           addActor(this.l);
/*      */           
/* 1480 */           layout();
/* 1481 */           pack();
/*      */           
/* 1483 */           this.q.getSelectionBoundingBox(this.k);
/* 1484 */           float f1 = this.k.width * 0.5F - getWidth() * 0.5F + this.k.x;
/* 1485 */           float f2 = this.k.y + this.k.height + 20.0F;
/*      */           
/* 1487 */           setPosition(f1, f2);
/*      */           
/* 1489 */           this.l.setX(getWidth() * 0.5F - this.l.getWidth() * 0.5F);
/* 1490 */           this.l.setY(-this.l.getHeight());
/*      */ 
/*      */ 
/*      */           
/* 1494 */           float f3, f4 = (f3 = (localToStageCoordinates(new Vector2())).x) + getWidth();
/* 1495 */           float f5 = this.a.getHeight() - (localToStageCoordinates(new Vector2())).y + getHeight();
/*      */ 
/*      */           
/* 1498 */           Group group = TextField.c(this.q);
/* 1499 */           while (group != null) {
/* 1500 */             if (group instanceof ScrollPane) {
/*      */               
/* 1502 */               f4 = (f3 = (localToActorCoordinates((Actor)group, new Vector2())).x) + getWidth();
/* 1503 */               f5 = group.getHeight() - (localToActorCoordinates((Actor)group, new Vector2())).y + getHeight();
/*      */               
/*      */               break;
/*      */             } 
/* 1507 */             group = group.getParent();
/*      */           } 
/*      */ 
/*      */           
/* 1511 */           float f6 = 0.0F;
/* 1512 */           if (f3 < 0.0F) {
/* 1513 */             f6 = f3;
/* 1514 */           } else if (f4 > this.a.getWidth()) {
/* 1515 */             f6 = f4 - this.a.getWidth();
/*      */           } 
/*      */           
/* 1518 */           if (f5 < 100.0F) {
/*      */             
/* 1520 */             setPosition(f1 - f6, this.k.y - getHeight() - 20.0F);
/* 1521 */             this.l.setY(getHeight());
/* 1522 */             this.l.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.textField.contextMenu.bgArrowTop"));
/*      */           } else {
/*      */             
/* 1525 */             setPosition(f1 - f6, f2);
/* 1526 */             this.l.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.textField.contextMenu.bgArrow"));
/*      */           } 
/* 1528 */           this.l.setX(this.l.getX() + f6);
/*      */           
/* 1530 */           setVisible(true);
/*      */         } else {
/* 1532 */           setVisible(false); return;
/*      */         } 
/* 1534 */       } catch (Exception exception) {
/* 1535 */         TextField.k().w("failed to update text field context menu", new Object[] { exception });
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface OnscreenKeyboard {
/*      */     void show(boolean param1Boolean);
/*      */   }
/*      */   
/*      */   public static interface TextFieldListener {
/*      */     void keyTyped(TextField param1TextField, char param1Char);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\TextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */