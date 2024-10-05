/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
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
/*     */ public class TextArea
/*     */   extends TextField
/*     */ {
/*     */   IntArray linesBreak;
/*     */   private String lastText;
/*     */   int cursorLine;
/*     */   int firstLineShowing;
/*     */   private int linesShowing;
/*     */   float moveOffset;
/*     */   private float prefRows;
/*     */   
/*     */   public TextArea(String paramString, Skin paramSkin) {
/*  56 */     super(paramString, paramSkin);
/*     */   }
/*     */   
/*     */   public TextArea(String paramString1, Skin paramSkin, String paramString2) {
/*  60 */     super(paramString1, paramSkin, paramString2);
/*     */   }
/*     */   
/*     */   public TextArea(String paramString, TextField.TextFieldStyle paramTextFieldStyle) {
/*  64 */     super(paramString, paramTextFieldStyle);
/*     */   }
/*     */   
/*     */   protected void initialize() {
/*  68 */     super.initialize();
/*  69 */     this.writeEnters = true;
/*  70 */     this.linesBreak = new IntArray();
/*  71 */     this.cursorLine = 0;
/*  72 */     this.firstLineShowing = 0;
/*  73 */     this.moveOffset = -1.0F;
/*  74 */     this.linesShowing = 0;
/*     */   }
/*     */   
/*     */   protected int letterUnderCursor(float paramFloat) {
/*  78 */     if (this.linesBreak.size > 0) {
/*  79 */       if (this.cursorLine << 1 >= this.linesBreak.size) {
/*  80 */         return this.text.length();
/*     */       }
/*  82 */       float[] arrayOfFloat = this.glyphPositions.items;
/*  83 */       int i = this.linesBreak.items[this.cursorLine << 1];
/*  84 */       paramFloat += arrayOfFloat[i];
/*  85 */       int j = this.linesBreak.items[(this.cursorLine << 1) + 1];
/*  86 */       i = i;
/*  87 */       for (; i < j && 
/*  88 */         arrayOfFloat[i] <= paramFloat; i++);
/*  89 */       if (i > 0 && arrayOfFloat[i] - paramFloat <= paramFloat - arrayOfFloat[i - 1]) return i; 
/*  90 */       return Math.max(0, i - 1);
/*     */     } 
/*     */     
/*  93 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyle(TextField.TextFieldStyle paramTextFieldStyle) {
/*  99 */     if (paramTextFieldStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 100 */     this.style = paramTextFieldStyle;
/*     */ 
/*     */     
/* 103 */     this.textHeight = paramTextFieldStyle.font.getCapHeight() - paramTextFieldStyle.font.getDescent();
/* 104 */     if (this.text != null) updateDisplayText(); 
/* 105 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrefRows(float paramFloat) {
/* 110 */     this.prefRows = paramFloat;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 114 */     if (this.prefRows <= 0.0F) {
/* 115 */       return super.getPrefHeight();
/*     */     }
/*     */ 
/*     */     
/* 119 */     float f = (float)Math.ceil((this.style.font.getLineHeight() * this.prefRows));
/* 120 */     if (this.style.background != null) {
/* 121 */       f = Math.max(f + this.style.background.getBottomHeight() + this.style.background.getTopHeight(), this.style.background
/* 122 */           .getMinHeight());
/*     */     }
/* 124 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLines() {
/* 130 */     return this.linesBreak.size / 2 + (newLineAtEnd() ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean newLineAtEnd() {
/* 135 */     if (this.text.length() != 0 && (this.text
/* 136 */       .charAt(this.text.length() - 1) == '\n' || this.text.charAt(this.text.length() - 1) == '\r')) return true;
/*     */     
/*     */     return false;
/*     */   }
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
/*     */   public void moveCursorLine(int paramInt) {
/*     */     // Byte code:
/*     */     //   0: iload_1
/*     */     //   1: ifge -> 21
/*     */     //   4: aload_0
/*     */     //   5: iconst_0
/*     */     //   6: putfield cursorLine : I
/*     */     //   9: aload_0
/*     */     //   10: iconst_0
/*     */     //   11: putfield cursor : I
/*     */     //   14: aload_0
/*     */     //   15: ldc -1.0
/*     */     //   17: putfield moveOffset : F
/*     */     //   20: return
/*     */     //   21: iload_1
/*     */     //   22: aload_0
/*     */     //   23: invokevirtual getLines : ()I
/*     */     //   26: if_icmplt -> 75
/*     */     //   29: aload_0
/*     */     //   30: invokevirtual getLines : ()I
/*     */     //   33: iconst_1
/*     */     //   34: isub
/*     */     //   35: istore_2
/*     */     //   36: aload_0
/*     */     //   37: dup
/*     */     //   38: getfield text : Ljava/lang/String;
/*     */     //   41: invokevirtual length : ()I
/*     */     //   44: putfield cursor : I
/*     */     //   47: iload_1
/*     */     //   48: aload_0
/*     */     //   49: invokevirtual getLines : ()I
/*     */     //   52: if_icmpgt -> 63
/*     */     //   55: iload_2
/*     */     //   56: aload_0
/*     */     //   57: getfield cursorLine : I
/*     */     //   60: if_icmpne -> 69
/*     */     //   63: aload_0
/*     */     //   64: ldc -1.0
/*     */     //   66: putfield moveOffset : F
/*     */     //   69: aload_0
/*     */     //   70: iload_2
/*     */     //   71: putfield cursorLine : I
/*     */     //   74: return
/*     */     //   75: iload_1
/*     */     //   76: aload_0
/*     */     //   77: getfield cursorLine : I
/*     */     //   80: if_icmpeq -> 288
/*     */     //   83: aload_0
/*     */     //   84: getfield moveOffset : F
/*     */     //   87: fconst_0
/*     */     //   88: fcmpg
/*     */     //   89: ifge -> 148
/*     */     //   92: aload_0
/*     */     //   93: dup
/*     */     //   94: getfield linesBreak : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   97: getfield size : I
/*     */     //   100: aload_0
/*     */     //   101: getfield cursorLine : I
/*     */     //   104: iconst_1
/*     */     //   105: ishl
/*     */     //   106: if_icmpgt -> 113
/*     */     //   109: fconst_0
/*     */     //   110: goto -> 145
/*     */     //   113: aload_0
/*     */     //   114: getfield glyphPositions : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   117: aload_0
/*     */     //   118: getfield cursor : I
/*     */     //   121: invokevirtual get : (I)F
/*     */     //   124: aload_0
/*     */     //   125: getfield glyphPositions : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   128: aload_0
/*     */     //   129: getfield linesBreak : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   132: aload_0
/*     */     //   133: getfield cursorLine : I
/*     */     //   136: iconst_1
/*     */     //   137: ishl
/*     */     //   138: invokevirtual get : (I)I
/*     */     //   141: invokevirtual get : (I)F
/*     */     //   144: fsub
/*     */     //   145: putfield moveOffset : F
/*     */     //   148: aload_0
/*     */     //   149: iload_1
/*     */     //   150: putfield cursorLine : I
/*     */     //   153: aload_0
/*     */     //   154: dup
/*     */     //   155: getfield cursorLine : I
/*     */     //   158: iconst_1
/*     */     //   159: ishl
/*     */     //   160: aload_0
/*     */     //   161: getfield linesBreak : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   164: getfield size : I
/*     */     //   167: if_icmplt -> 180
/*     */     //   170: aload_0
/*     */     //   171: getfield text : Ljava/lang/String;
/*     */     //   174: invokevirtual length : ()I
/*     */     //   177: goto -> 193
/*     */     //   180: aload_0
/*     */     //   181: getfield linesBreak : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   184: aload_0
/*     */     //   185: getfield cursorLine : I
/*     */     //   188: iconst_1
/*     */     //   189: ishl
/*     */     //   190: invokevirtual get : (I)I
/*     */     //   193: putfield cursor : I
/*     */     //   196: aload_0
/*     */     //   197: getfield cursor : I
/*     */     //   200: aload_0
/*     */     //   201: getfield text : Ljava/lang/String;
/*     */     //   204: invokevirtual length : ()I
/*     */     //   207: if_icmpge -> 284
/*     */     //   210: aload_0
/*     */     //   211: getfield cursor : I
/*     */     //   214: aload_0
/*     */     //   215: getfield linesBreak : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   218: aload_0
/*     */     //   219: getfield cursorLine : I
/*     */     //   222: iconst_1
/*     */     //   223: ishl
/*     */     //   224: iconst_1
/*     */     //   225: iadd
/*     */     //   226: invokevirtual get : (I)I
/*     */     //   229: iconst_1
/*     */     //   230: isub
/*     */     //   231: if_icmpgt -> 284
/*     */     //   234: aload_0
/*     */     //   235: getfield glyphPositions : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   238: aload_0
/*     */     //   239: getfield cursor : I
/*     */     //   242: invokevirtual get : (I)F
/*     */     //   245: aload_0
/*     */     //   246: getfield glyphPositions : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   249: aload_0
/*     */     //   250: getfield linesBreak : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   253: aload_0
/*     */     //   254: getfield cursorLine : I
/*     */     //   257: iconst_1
/*     */     //   258: ishl
/*     */     //   259: invokevirtual get : (I)I
/*     */     //   262: invokevirtual get : (I)F
/*     */     //   265: fsub
/*     */     //   266: aload_0
/*     */     //   267: getfield moveOffset : F
/*     */     //   270: fcmpg
/*     */     //   271: ifge -> 284
/*     */     //   274: aload_0
/*     */     //   275: dup
/*     */     //   276: getfield cursor : I
/*     */     //   279: iconst_1
/*     */     //   280: iadd
/*     */     //   281: goto -> 193
/*     */     //   284: aload_0
/*     */     //   285: invokevirtual showCursor : ()V
/*     */     //   288: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #141	-> 0
/*     */     //   #142	-> 4
/*     */     //   #143	-> 9
/*     */     //   #144	-> 14
/*     */     //   #145	-> 21
/*     */     //   #146	-> 29
/*     */     //   #147	-> 36
/*     */     //   #148	-> 47
/*     */     //   #149	-> 63
/*     */     //   #151	-> 69
/*     */     //   #152	-> 74
/*     */     //   #153	-> 83
/*     */     //   #154	-> 92
/*     */     //   #155	-> 113
/*     */     //   #157	-> 148
/*     */     //   #158	-> 153
/*     */     //   #159	-> 196
/*     */     //   #160	-> 242
/*     */     //   #161	-> 274
/*     */     //   #163	-> 284
/*     */     //   #165	-> 288
/*     */   }
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
/*     */   void updateCurrentLine() {
/* 170 */     int i, j = (i = calculateCurrentLineIndex(this.cursor)) / 2;
/*     */ 
/*     */     
/* 173 */     if (i % 2 == 0 || i + 1 >= this.linesBreak.size || this.cursor != this.linesBreak.items[i] || this.linesBreak.items[i + 1] != this.linesBreak.items[i])
/*     */     {
/* 175 */       if (j < this.linesBreak.size / 2 || this.text.length() == 0 || this.text.charAt(this.text.length() - 1) == '\n' || this.text
/* 176 */         .charAt(this.text.length() - 1) == '\r') {
/* 177 */         this.cursorLine = j;
/*     */       }
/*     */     }
/* 180 */     updateFirstLineShowing();
/*     */   }
/*     */ 
/*     */   
/*     */   void showCursor() {
/* 185 */     updateCurrentLine();
/* 186 */     updateFirstLineShowing();
/*     */   }
/*     */   
/*     */   void updateFirstLineShowing() {
/* 190 */     if (this.cursorLine != this.firstLineShowing) {
/* 191 */       byte b = (this.cursorLine >= this.firstLineShowing) ? 1 : -1;
/* 192 */       while (this.firstLineShowing > this.cursorLine || this.firstLineShowing + this.linesShowing - 1 < this.cursorLine) {
/* 193 */         this.firstLineShowing += b;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int calculateCurrentLineIndex(int paramInt) {
/* 200 */     byte b = 0;
/* 201 */     while (b < this.linesBreak.size && paramInt > this.linesBreak.items[b]) {
/* 202 */       b++;
/*     */     }
/* 204 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void sizeChanged() {
/* 210 */     this.lastText = null;
/*     */ 
/*     */     
/* 213 */     BitmapFont bitmapFont = this.style.font;
/* 214 */     Drawable drawable = this.style.background;
/* 215 */     float f = getHeight() - ((drawable == null) ? 0.0F : (drawable.getBottomHeight() + drawable.getTopHeight()));
/* 216 */     this.linesShowing = (int)Math.floor((f / bitmapFont.getLineHeight()));
/*     */   }
/*     */   
/*     */   protected float getTextY(BitmapFont paramBitmapFont, @Null Drawable paramDrawable) {
/* 220 */     float f = getHeight();
/* 221 */     if (paramDrawable != null) {
/* 222 */       f -= paramDrawable.getTopHeight();
/*     */     }
/* 224 */     if (paramBitmapFont.usesIntegerPositions()) f = (int)f; 
/* 225 */     return f;
/*     */   }
/*     */   
/*     */   protected void drawSelection(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/* 229 */     int i = this.firstLineShowing << 1;
/* 230 */     float f1 = 0.0F;
/* 231 */     int j = Math.min(this.cursor, this.selectionStart);
/* 232 */     int k = Math.max(this.cursor, this.selectionStart);
/* 233 */     BitmapFont.BitmapFontData bitmapFontData = paramBitmapFont.getData();
/* 234 */     float f2 = this.style.font.getLineHeight();
/* 235 */     while (i + 1 < this.linesBreak.size && i < this.firstLineShowing + this.linesShowing << 1) {
/*     */       
/* 237 */       int m = this.linesBreak.get(i);
/* 238 */       int n = this.linesBreak.get(i + 1);
/*     */       
/* 240 */       if ((j >= m || j >= n || k >= m || k >= n) && (j <= m || j <= n || k <= m || k <= n)) {
/*     */ 
/*     */         
/* 243 */         int i1 = Math.max(m, j);
/* 244 */         n = Math.min(n, k);
/*     */         
/* 246 */         float f5 = 0.0F;
/* 247 */         float f6 = 0.0F;
/*     */         
/*     */         BitmapFont.Glyph glyph;
/*     */         
/* 251 */         if ((glyph = bitmapFontData.getGlyph(this.displayText.charAt(m))) != null)
/*     */         {
/*     */           
/* 254 */           if (i1 == m) {
/* 255 */             f6 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */           } else {
/* 257 */             f5 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */           } 
/*     */         }
/* 260 */         float f3 = this.glyphPositions.get(i1) - this.glyphPositions.get(m);
/* 261 */         float f4 = this.glyphPositions.get(n) - this.glyphPositions.get(i1);
/* 262 */         paramDrawable.draw(paramBatch, paramFloat1 + f3 + f5, paramFloat2 - f2 - f1, f4 + f6, paramBitmapFont
/* 263 */             .getLineHeight());
/*     */       } 
/*     */       
/* 266 */       f1 += paramBitmapFont.getLineHeight();
/* 267 */       i += 2;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void drawText(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/* 272 */     float f = -(this.style.font.getLineHeight() - this.textHeight) / 2.0F;
/* 273 */     for (int i = this.firstLineShowing << 1; i < this.firstLineShowing + this.linesShowing << 1 && i < this.linesBreak.size; i += 2) {
/* 274 */       paramBitmapFont.draw(paramBatch, this.displayText, paramFloat1, paramFloat2 + f, this.linesBreak.items[i], this.linesBreak.items[i + 1], 0.0F, 8, false);
/* 275 */       f -= paramBitmapFont.getLineHeight();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void drawCursor(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/* 280 */     paramDrawable.draw(paramBatch, paramFloat1 + getCursorX(), paramFloat2 + getCursorY(), paramDrawable.getMinWidth(), paramBitmapFont.getLineHeight());
/*     */   }
/*     */   
/*     */   protected void calculateOffsets() {
/* 284 */     super.calculateOffsets();
/* 285 */     if (!this.text.equals(this.lastText)) {
/* 286 */       this.lastText = this.text;
/* 287 */       BitmapFont bitmapFont = this.style.font;
/*     */       
/* 289 */       float f = getWidth() - ((this.style.background != null) ? (this.style.background.getLeftWidth() + this.style.background.getRightWidth()) : 0.0F);
/* 290 */       this.linesBreak.clear();
/* 291 */       int i = 0;
/* 292 */       int j = 0;
/*     */       
/*     */       Pool pool;
/* 295 */       GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 296 */       for (byte b = 0; b < this.text.length(); b++) {
/*     */         char c;
/* 298 */         if ((c = this.text.charAt(b)) == '\r' || c == '\n') {
/* 299 */           this.linesBreak.add(i);
/* 300 */           this.linesBreak.add(b);
/* 301 */           i = b + 1;
/*     */         } else {
/* 303 */           j = continueCursor(b, 0) ? j : b;
/* 304 */           glyphLayout.setText(bitmapFont, this.text.subSequence(i, b + 1));
/* 305 */           if (glyphLayout.width > f) {
/* 306 */             if (i >= j) {
/* 307 */               j = b - 1;
/*     */             }
/* 309 */             this.linesBreak.add(i);
/* 310 */             this.linesBreak.add(j + 1);
/*     */             
/* 312 */             j = i = j + 1;
/*     */           } 
/*     */         } 
/*     */       } 
/* 316 */       pool.free(glyphLayout);
/*     */       
/* 318 */       if (i < this.text.length()) {
/* 319 */         this.linesBreak.add(i);
/* 320 */         this.linesBreak.add(this.text.length());
/*     */       } 
/* 322 */       showCursor();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected InputListener createInputListener() {
/* 327 */     return (InputListener)new TextAreaListener();
/*     */   }
/*     */   
/*     */   public void setSelection(int paramInt1, int paramInt2) {
/* 331 */     super.setSelection(paramInt1, paramInt2);
/* 332 */     updateCurrentLine();
/*     */   }
/*     */   
/*     */   protected void moveCursor(boolean paramBoolean1, boolean paramBoolean2) {
/* 336 */     byte b = paramBoolean1 ? 1 : -1;
/*     */     int i;
/* 338 */     if ((i = (this.cursorLine << 1) + b) >= 0 && i + 1 < this.linesBreak.size && this.linesBreak.items[i] == this.cursor && this.linesBreak.items[i + 1] == this.cursor) {
/*     */       
/* 340 */       this.cursorLine += b;
/* 341 */       if (paramBoolean2) {
/* 342 */         super.moveCursor(paramBoolean1, paramBoolean2);
/*     */       }
/* 344 */       showCursor();
/*     */     } else {
/* 346 */       super.moveCursor(paramBoolean1, paramBoolean2);
/*     */     } 
/* 348 */     updateCurrentLine();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean continueCursor(int paramInt1, int paramInt2) {
/* 353 */     int i = calculateCurrentLineIndex(paramInt1 + paramInt2);
/* 354 */     return (super.continueCursor(paramInt1, paramInt2) && (i < 0 || i >= this.linesBreak.size - 2 || this.linesBreak.items[i + 1] != paramInt1 || this.linesBreak.items[i + 1] == this.linesBreak.items[i + 2]));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCursorLine() {
/* 359 */     return this.cursorLine;
/*     */   }
/*     */   
/*     */   public int getFirstLineShowing() {
/* 363 */     return this.firstLineShowing;
/*     */   }
/*     */   
/*     */   public int getLinesShowing() {
/* 367 */     return this.linesShowing;
/*     */   }
/*     */   
/*     */   public float getCursorX() {
/* 371 */     float f = 0.0F;
/* 372 */     BitmapFont.BitmapFontData bitmapFontData = this.style.font.getData();
/* 373 */     if (this.cursor < this.glyphPositions.size && this.cursorLine << 1 < this.linesBreak.size) {
/* 374 */       int i = this.linesBreak.items[this.cursorLine << 1];
/* 375 */       float f1 = 0.0F;
/*     */       BitmapFont.Glyph glyph;
/* 377 */       if ((glyph = bitmapFontData.getGlyph(this.displayText.charAt(i))) != null)
/*     */       {
/* 379 */         f1 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */       }
/* 381 */       f = this.glyphPositions.get(this.cursor) - this.glyphPositions.get(i) + f1;
/*     */     } 
/* 383 */     return f + bitmapFontData.cursorX;
/*     */   }
/*     */   
/*     */   public float getCursorY() {
/* 387 */     BitmapFont bitmapFont = this.style.font;
/* 388 */     return -(this.cursorLine - this.firstLineShowing + 1) * bitmapFont.getLineHeight();
/*     */   }
/*     */   
/*     */   public class TextAreaListener
/*     */     extends TextField.TextFieldClickListener {
/*     */     protected void setCursorPosition(float param1Float1, float param1Float2) {
/* 394 */       TextArea.this.moveOffset = -1.0F;
/*     */       
/* 396 */       Drawable drawable = TextArea.this.style.background;
/* 397 */       BitmapFont bitmapFont = TextArea.this.style.font;
/*     */       
/* 399 */       float f = TextArea.this.getHeight();
/*     */       
/* 401 */       if (drawable != null) {
/* 402 */         f -= drawable.getTopHeight();
/* 403 */         param1Float1 -= drawable.getLeftWidth();
/*     */       } 
/* 405 */       param1Float1 = Math.max(0.0F, param1Float1);
/* 406 */       if (drawable != null) {
/* 407 */         param1Float2 -= drawable.getTopHeight();
/*     */       }
/*     */       
/* 410 */       TextArea.this.cursorLine = (int)Math.floor(((f - param1Float2) / bitmapFont.getLineHeight())) + TextArea.this.firstLineShowing;
/* 411 */       TextArea.this.cursorLine = Math.max(0, Math.min(TextArea.this.cursorLine, TextArea.this.getLines() - 1));
/*     */       
/* 413 */       super.setCursorPosition(param1Float1, param1Float2);
/* 414 */       TextArea.this.updateCurrentLine();
/*     */     }
/*     */     
/*     */     public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/* 418 */       boolean bool = super.keyDown(param1InputEvent, param1Int);
/* 419 */       if (TextArea.this.hasKeyboardFocus()) {
/* 420 */         bool = false;
/* 421 */         boolean bool1 = (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) ? true : false;
/* 422 */         if (param1Int == 20) {
/* 423 */           if (bool1) {
/* 424 */             if (!TextArea.this.hasSelection) {
/* 425 */               TextArea.this.selectionStart = TextArea.this.cursor;
/* 426 */               TextArea.this.hasSelection = true;
/*     */             } 
/*     */           } else {
/* 429 */             TextArea.this.clearSelection();
/*     */           } 
/* 431 */           TextArea.this.moveCursorLine(TextArea.this.cursorLine + 1);
/* 432 */           bool = true;
/*     */         }
/* 434 */         else if (param1Int == 19) {
/* 435 */           if (bool1) {
/* 436 */             if (!TextArea.this.hasSelection) {
/* 437 */               TextArea.this.selectionStart = TextArea.this.cursor;
/* 438 */               TextArea.this.hasSelection = true;
/*     */             } 
/*     */           } else {
/* 441 */             TextArea.this.clearSelection();
/*     */           } 
/* 443 */           TextArea.this.moveCursorLine(TextArea.this.cursorLine - 1);
/* 444 */           bool = true;
/*     */         } else {
/*     */           
/* 447 */           TextArea.this.moveOffset = -1.0F;
/*     */         } 
/* 449 */         if (bool) {
/* 450 */           scheduleKeyRepeatTask(param1Int);
/*     */         }
/* 452 */         TextArea.this.showCursor();
/* 453 */         return true;
/*     */       } 
/* 455 */       return bool;
/*     */     }
/*     */     
/*     */     protected boolean checkFocusTraversal(char param1Char) {
/* 459 */       return (TextArea.this.focusTraversal && param1Char == '\t');
/*     */     }
/*     */     
/*     */     public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/* 463 */       boolean bool = super.keyTyped(param1InputEvent, param1Char);
/* 464 */       TextArea.this.showCursor();
/* 465 */       return bool;
/*     */     }
/*     */     
/*     */     protected void goHome(boolean param1Boolean) {
/* 469 */       if (param1Boolean) {
/* 470 */         TextArea.this.cursor = 0; return;
/* 471 */       }  if (TextArea.this.cursorLine << 1 < TextArea.this.linesBreak.size) {
/* 472 */         TextArea.this.cursor = TextArea.this.linesBreak.get(TextArea.this.cursorLine << 1);
/*     */       }
/*     */     }
/*     */     
/*     */     protected void goEnd(boolean param1Boolean) {
/* 477 */       if (param1Boolean || TextArea.this.cursorLine >= TextArea.this.getLines()) {
/* 478 */         TextArea.this.cursor = TextArea.this.text.length(); return;
/* 479 */       }  if ((TextArea.this.cursorLine << 1) + 1 < TextArea.this.linesBreak.size)
/* 480 */         TextArea.this.cursor = TextArea.this.linesBreak.get((TextArea.this.cursorLine << 1) + 1); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\TextArea.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */