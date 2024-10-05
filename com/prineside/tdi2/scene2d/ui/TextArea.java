/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
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
/*     */ 
/*     */ public class TextArea
/*     */   extends TextField
/*     */ {
/*     */   IntArray k;
/*     */   private String O;
/*     */   int l;
/*     */   int m;
/*     */   private int P;
/*     */   float n;
/*     */   public boolean prefSizeDependsOnContents;
/*     */   private float Q;
/*     */   
/*     */   public TextArea(String paramString, TextField.TextFieldStyle paramTextFieldStyle) {
/*  59 */     super(paramString, paramTextFieldStyle);
/*     */   }
/*     */   
/*     */   protected final void d() {
/*  63 */     super.d();
/*  64 */     this.writeEnters = true;
/*  65 */     this.k = new IntArray();
/*  66 */     this.l = 0;
/*  67 */     this.m = 0;
/*  68 */     this.n = -1.0F;
/*  69 */     this.P = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int letterUnderCursor(float paramFloat) {
/*  74 */     if (this.k.size > 0) {
/*  75 */       if (this.l << 1 >= this.k.size) {
/*  76 */         return this.o.length();
/*     */       }
/*  78 */       float[] arrayOfFloat = this.s.items;
/*  79 */       int i = this.k.items[this.l << 1];
/*  80 */       paramFloat += arrayOfFloat[i];
/*  81 */       int j = this.k.items[(this.l << 1) + 1];
/*  82 */       i = i;
/*  83 */       for (; i < j && 
/*  84 */         arrayOfFloat[i] <= paramFloat; i++);
/*  85 */       if (i > 0 && arrayOfFloat[i] - paramFloat <= paramFloat - arrayOfFloat[i - 1]) return i; 
/*  86 */       return Math.max(0, i - 1);
/*     */     } 
/*     */     
/*  89 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyle(TextField.TextFieldStyle paramTextFieldStyle) {
/*  95 */     if (paramTextFieldStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  96 */     this.t = paramTextFieldStyle;
/*     */ 
/*     */     
/*  99 */     this.H = paramTextFieldStyle.font.getCapHeight() - paramTextFieldStyle.font.getDescent();
/* 100 */     if (this.o != null) j(); 
/* 101 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrefRows(float paramFloat) {
/* 106 */     this.Q = paramFloat;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 110 */     if (this.prefSizeDependsOnContents) {
/* 111 */       float f1 = (float)Math.ceil((this.t.font.getLineHeight() * getLines()));
/* 112 */       if (this.t.background != null) {
/* 113 */         f1 = Math.max(f1 + this.t.background.getBottomHeight() + this.t.background.getTopHeight(), this.t.background
/* 114 */             .getMinHeight());
/*     */       }
/* 116 */       return f1;
/*     */     } 
/* 118 */     if (this.Q <= 0.0F) {
/* 119 */       return super.getPrefHeight();
/*     */     }
/*     */ 
/*     */     
/* 123 */     float f = (float)Math.ceil((this.t.font.getLineHeight() * this.Q));
/* 124 */     if (this.t.background != null) {
/* 125 */       f = Math.max(f + this.t.background.getBottomHeight() + this.t.background.getTopHeight(), this.t.background
/* 126 */           .getMinHeight());
/*     */     }
/* 128 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLines() {
/* 135 */     return this.k.size / 2 + (newLineAtEnd() ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean newLineAtEnd() {
/* 140 */     if (this.o.length() != 0 && (this.o
/* 141 */       .charAt(this.o.length() - 1) == '\n' || this.o.charAt(this.o.length() - 1) == '\r')) return true;
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
/*     */   
/*     */   public void moveCursorLine(int paramInt) {
/*     */     // Byte code:
/*     */     //   0: iload_1
/*     */     //   1: ifge -> 23
/*     */     //   4: aload_0
/*     */     //   5: iconst_0
/*     */     //   6: putfield l : I
/*     */     //   9: aload_0
/*     */     //   10: iconst_0
/*     */     //   11: putfield p : I
/*     */     //   14: aload_0
/*     */     //   15: ldc -1.0
/*     */     //   17: putfield n : F
/*     */     //   20: goto -> 292
/*     */     //   23: iload_1
/*     */     //   24: aload_0
/*     */     //   25: invokevirtual getLines : ()I
/*     */     //   28: if_icmplt -> 79
/*     */     //   31: aload_0
/*     */     //   32: invokevirtual getLines : ()I
/*     */     //   35: iconst_1
/*     */     //   36: isub
/*     */     //   37: istore_2
/*     */     //   38: aload_0
/*     */     //   39: dup
/*     */     //   40: getfield o : Ljava/lang/String;
/*     */     //   43: invokevirtual length : ()I
/*     */     //   46: putfield p : I
/*     */     //   49: iload_1
/*     */     //   50: aload_0
/*     */     //   51: invokevirtual getLines : ()I
/*     */     //   54: if_icmpgt -> 65
/*     */     //   57: iload_2
/*     */     //   58: aload_0
/*     */     //   59: getfield l : I
/*     */     //   62: if_icmpne -> 71
/*     */     //   65: aload_0
/*     */     //   66: ldc -1.0
/*     */     //   68: putfield n : F
/*     */     //   71: aload_0
/*     */     //   72: iload_2
/*     */     //   73: putfield l : I
/*     */     //   76: goto -> 292
/*     */     //   79: iload_1
/*     */     //   80: aload_0
/*     */     //   81: getfield l : I
/*     */     //   84: if_icmpeq -> 292
/*     */     //   87: aload_0
/*     */     //   88: getfield n : F
/*     */     //   91: fconst_0
/*     */     //   92: fcmpg
/*     */     //   93: ifge -> 152
/*     */     //   96: aload_0
/*     */     //   97: dup
/*     */     //   98: getfield k : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   101: getfield size : I
/*     */     //   104: aload_0
/*     */     //   105: getfield l : I
/*     */     //   108: iconst_1
/*     */     //   109: ishl
/*     */     //   110: if_icmpgt -> 117
/*     */     //   113: fconst_0
/*     */     //   114: goto -> 149
/*     */     //   117: aload_0
/*     */     //   118: getfield s : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   121: aload_0
/*     */     //   122: getfield p : I
/*     */     //   125: invokevirtual get : (I)F
/*     */     //   128: aload_0
/*     */     //   129: getfield s : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   132: aload_0
/*     */     //   133: getfield k : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   136: aload_0
/*     */     //   137: getfield l : I
/*     */     //   140: iconst_1
/*     */     //   141: ishl
/*     */     //   142: invokevirtual get : (I)I
/*     */     //   145: invokevirtual get : (I)F
/*     */     //   148: fsub
/*     */     //   149: putfield n : F
/*     */     //   152: aload_0
/*     */     //   153: iload_1
/*     */     //   154: putfield l : I
/*     */     //   157: aload_0
/*     */     //   158: dup
/*     */     //   159: getfield l : I
/*     */     //   162: iconst_1
/*     */     //   163: ishl
/*     */     //   164: aload_0
/*     */     //   165: getfield k : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   168: getfield size : I
/*     */     //   171: if_icmplt -> 184
/*     */     //   174: aload_0
/*     */     //   175: getfield o : Ljava/lang/String;
/*     */     //   178: invokevirtual length : ()I
/*     */     //   181: goto -> 197
/*     */     //   184: aload_0
/*     */     //   185: getfield k : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   188: aload_0
/*     */     //   189: getfield l : I
/*     */     //   192: iconst_1
/*     */     //   193: ishl
/*     */     //   194: invokevirtual get : (I)I
/*     */     //   197: putfield p : I
/*     */     //   200: aload_0
/*     */     //   201: getfield p : I
/*     */     //   204: aload_0
/*     */     //   205: getfield o : Ljava/lang/String;
/*     */     //   208: invokevirtual length : ()I
/*     */     //   211: if_icmpge -> 288
/*     */     //   214: aload_0
/*     */     //   215: getfield p : I
/*     */     //   218: aload_0
/*     */     //   219: getfield k : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   222: aload_0
/*     */     //   223: getfield l : I
/*     */     //   226: iconst_1
/*     */     //   227: ishl
/*     */     //   228: iconst_1
/*     */     //   229: iadd
/*     */     //   230: invokevirtual get : (I)I
/*     */     //   233: iconst_1
/*     */     //   234: isub
/*     */     //   235: if_icmpgt -> 288
/*     */     //   238: aload_0
/*     */     //   239: getfield s : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   242: aload_0
/*     */     //   243: getfield p : I
/*     */     //   246: invokevirtual get : (I)F
/*     */     //   249: aload_0
/*     */     //   250: getfield s : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   253: aload_0
/*     */     //   254: getfield k : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   257: aload_0
/*     */     //   258: getfield l : I
/*     */     //   261: iconst_1
/*     */     //   262: ishl
/*     */     //   263: invokevirtual get : (I)I
/*     */     //   266: invokevirtual get : (I)F
/*     */     //   269: fsub
/*     */     //   270: aload_0
/*     */     //   271: getfield n : F
/*     */     //   274: fcmpg
/*     */     //   275: ifge -> 288
/*     */     //   278: aload_0
/*     */     //   279: dup
/*     */     //   280: getfield p : I
/*     */     //   283: iconst_1
/*     */     //   284: iadd
/*     */     //   285: goto -> 197
/*     */     //   288: aload_0
/*     */     //   289: invokevirtual f : ()V
/*     */     //   292: aload_0
/*     */     //   293: invokevirtual updateContextMenu : ()V
/*     */     //   296: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #146	-> 0
/*     */     //   #147	-> 4
/*     */     //   #148	-> 9
/*     */     //   #149	-> 14
/*     */     //   #150	-> 23
/*     */     //   #151	-> 31
/*     */     //   #152	-> 38
/*     */     //   #153	-> 49
/*     */     //   #154	-> 65
/*     */     //   #156	-> 71
/*     */     //   #157	-> 76
/*     */     //   #158	-> 87
/*     */     //   #159	-> 96
/*     */     //   #160	-> 117
/*     */     //   #162	-> 152
/*     */     //   #163	-> 157
/*     */     //   #164	-> 200
/*     */     //   #165	-> 246
/*     */     //   #166	-> 278
/*     */     //   #168	-> 288
/*     */     //   #170	-> 292
/*     */     //   #171	-> 296
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
/*     */   final void e() {
/* 176 */     int i, j = (i = b(this.p)) / 2;
/*     */ 
/*     */     
/* 179 */     if (i % 2 == 0 || i + 1 >= this.k.size || this.p != this.k.items[i] || this.k.items[i + 1] != this.k.items[i])
/*     */     {
/* 181 */       if (j < this.k.size / 2 || this.o.length() == 0 || this.o.charAt(this.o.length() - 1) == '\n' || this.o
/* 182 */         .charAt(this.o.length() - 1) == '\r') {
/* 183 */         this.l = j;
/*     */       }
/*     */     }
/* 186 */     l();
/*     */   }
/*     */ 
/*     */   
/*     */   final void f() {
/* 191 */     e();
/* 192 */     l();
/*     */   }
/*     */   
/*     */   private void l() {
/* 196 */     if (this.l != this.m) {
/* 197 */       byte b = (this.l >= this.m) ? 1 : -1;
/* 198 */       while (this.m > this.l || this.m + this.P - 1 < this.l) {
/* 199 */         this.m += b;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int b(int paramInt) {
/* 206 */     byte b = 0;
/* 207 */     while (b < this.k.size && paramInt > this.k.items[b]) {
/* 208 */       b++;
/*     */     }
/* 210 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void sizeChanged() {
/* 216 */     this.O = null;
/*     */ 
/*     */     
/* 219 */     BitmapFont bitmapFont = this.t.font;
/* 220 */     Drawable drawable = this.t.background;
/* 221 */     float f = getHeight() - ((drawable == null) ? 0.0F : (drawable.getBottomHeight() + drawable.getTopHeight()));
/* 222 */     this.P = (int)Math.floor((f / bitmapFont.getLineHeight()));
/*     */   }
/*     */   
/*     */   protected final float a(BitmapFont paramBitmapFont, @Null Drawable paramDrawable) {
/* 226 */     float f = getHeight();
/* 227 */     if (paramDrawable != null) {
/* 228 */       f -= paramDrawable.getTopHeight();
/*     */     }
/* 230 */     if (paramBitmapFont.usesIntegerPositions()) f = (int)f; 
/* 231 */     return f;
/*     */   }
/*     */   
/*     */   protected final void a(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/* 235 */     int i = this.m << 1;
/* 236 */     float f1 = 0.0F;
/* 237 */     int j = Math.min(this.p, this.q);
/* 238 */     int k = Math.max(this.p, this.q);
/* 239 */     BitmapFont.BitmapFontData bitmapFontData = paramBitmapFont.getData();
/* 240 */     float f2 = this.t.font.getLineHeight();
/* 241 */     while (i + 1 < this.k.size && i < this.m + this.P << 1) {
/*     */       
/* 243 */       int m = this.k.get(i);
/* 244 */       int n = this.k.get(i + 1);
/*     */       
/* 246 */       if ((j >= m || j >= n || k >= m || k >= n) && (j <= m || j <= n || k <= m || k <= n)) {
/*     */ 
/*     */         
/* 249 */         int i1 = Math.max(m, j);
/* 250 */         int i2 = Math.min(n, k);
/*     */         
/* 252 */         float f5 = 0.0F;
/* 253 */         float f6 = 0.0F;
/*     */         
/*     */         BitmapFont.Glyph glyph;
/*     */         
/* 257 */         if ((glyph = bitmapFontData.getGlyph(this.u.charAt(m))) != null)
/*     */         {
/*     */           
/* 260 */           if (i1 == m) {
/* 261 */             f6 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */           } else {
/* 263 */             f5 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */           } 
/*     */         }
/* 266 */         float f3 = this.s.get(i1) - this.s.get(m);
/* 267 */         float f4 = this.s.get(i2) - this.s.get(i1);
/* 268 */         if (i2 == n && i2 < k) {
/* 269 */           f4 = 4096.0F;
/*     */         }
/* 271 */         paramDrawable.draw(paramBatch, paramFloat1 + f3 + f5, paramFloat2 - f2 - f1, f4 + f6, paramBitmapFont
/* 272 */             .getLineHeight());
/*     */       } 
/*     */       
/* 275 */       f1 += paramBitmapFont.getLineHeight();
/* 276 */       i += 2;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void a(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/* 281 */     float f = -(this.t.font.getLineHeight() - this.H) / 2.0F;
/* 282 */     for (int i = this.m << 1; i < this.m + this.P << 1 && i < this.k.size; i += 2) {
/* 283 */       paramBitmapFont.draw(paramBatch, this.u, paramFloat1, paramFloat2 + f, this.k.items[i], this.k.items[i + 1], 0.0F, 8, false);
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
/* 294 */       f -= paramBitmapFont.getLineHeight();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void b(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2) {
/* 299 */     paramDrawable.draw(paramBatch, paramFloat1 + getCursorX(), paramFloat2 + getCursorY(), paramDrawable.getMinWidth(), paramBitmapFont.getLineHeight());
/*     */   }
/*     */   
/*     */   public void getSelectionBoundingBox(Rectangle paramRectangle) {
/* 303 */     g();
/* 304 */     float f1 = 0.0F;
/*     */     Drawable drawable;
/* 306 */     if ((drawable = i()) != null) {
/* 307 */       f1 = drawable.getLeftWidth();
/*     */     }
/* 309 */     float f2 = a(this.t.font, drawable);
/*     */     
/* 311 */     if (this.J && this.r && this.p != this.q) {
/*     */       
/* 313 */       float f3 = 100000.0F;
/* 314 */       float f4 = 100000.0F;
/* 315 */       float f5 = -100000.0F;
/* 316 */       float f6 = -100000.0F;
/*     */       
/* 318 */       int i = this.m << 1;
/* 319 */       float f7 = 0.0F;
/* 320 */       int j = Math.min(this.p, this.q);
/* 321 */       int k = Math.max(this.p, this.q);
/* 322 */       BitmapFont.BitmapFontData bitmapFontData = this.t.font.getData();
/* 323 */       float f8 = this.t.font.getLineHeight();
/* 324 */       while (i + 1 < this.k.size && i < this.m + this.P << 1) {
/*     */         
/* 326 */         int m = this.k.get(i);
/* 327 */         int n = this.k.get(i + 1);
/*     */         
/* 329 */         if ((j >= m || j >= n || k >= m || k >= n) && (j <= m || j <= n || k <= m || k <= n)) {
/*     */ 
/*     */           
/* 332 */           int i1 = Math.max(m, j);
/* 333 */           n = Math.min(n, k);
/*     */           
/* 335 */           float f12 = 0.0F;
/* 336 */           float f13 = 0.0F;
/*     */           
/*     */           BitmapFont.Glyph glyph;
/*     */           
/* 340 */           if ((glyph = bitmapFontData.getGlyph(this.u.charAt(m))) != null)
/*     */           {
/*     */             
/* 343 */             if (i1 == m) {
/* 344 */               f13 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */             } else {
/* 346 */               f12 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */             } 
/*     */           }
/* 349 */           float f9 = this.s.get(i1) - this.s.get(m);
/* 350 */           float f10 = this.s.get(n) - this.s.get(i1);
/*     */           
/* 352 */           f9 = f1 + f9 + f12;
/* 353 */           float f11 = f2 - f8 - f7;
/*     */           
/* 355 */           f3 = Math.min(f3, f9);
/* 356 */           f4 = Math.min(f4, f11);
/* 357 */           f5 = Math.max(f5, f9 + f10 + f13);
/* 358 */           f6 = Math.max(f6, f11 + this.t.font.getLineHeight());
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 364 */         f7 += this.t.font.getLineHeight();
/* 365 */         i += 2;
/*     */       } 
/* 367 */       paramRectangle.x = f3;
/* 368 */       paramRectangle.y = f4;
/* 369 */       paramRectangle.width = f5 - f3;
/* 370 */       paramRectangle.height = f6 - f4;
/*     */       return;
/*     */     } 
/* 373 */     paramRectangle.x = f1 + getCursorX();
/* 374 */     paramRectangle.y = f2 + getCursorY();
/* 375 */     paramRectangle.width = 0.0F;
/* 376 */     paramRectangle.height = this.t.font.getLineHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void g() {
/* 381 */     super.g();
/* 382 */     if (!this.o.equals(this.O)) {
/* 383 */       this.O = this.o;
/* 384 */       BitmapFont bitmapFont = this.t.font;
/*     */       
/* 386 */       float f = getWidth() - ((this.t.background != null) ? (this.t.background.getLeftWidth() + this.t.background.getRightWidth()) : 0.0F);
/* 387 */       this.k.clear();
/* 388 */       int i = 0;
/* 389 */       int j = 0;
/*     */       
/*     */       Pool pool;
/* 392 */       GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 393 */       for (byte b = 0; b < this.o.length(); b++) {
/*     */         char c;
/* 395 */         if ((c = this.o.charAt(b)) == '\r' || c == '\n') {
/* 396 */           this.k.add(i);
/* 397 */           this.k.add(b);
/* 398 */           i = b + 1;
/*     */         } else {
/* 400 */           j = a(b, 0) ? j : b;
/* 401 */           glyphLayout.setText(bitmapFont, this.o.subSequence(i, b + 1));
/* 402 */           if (glyphLayout.width > f) {
/* 403 */             if (i >= j) {
/* 404 */               j = b - 1;
/*     */             }
/* 406 */             this.k.add(i);
/* 407 */             this.k.add(j + 1);
/*     */             
/* 409 */             j = i = j + 1;
/*     */           } 
/*     */         } 
/*     */       } 
/* 413 */       pool.free(glyphLayout);
/*     */       
/* 415 */       if (i < this.o.length()) {
/* 416 */         this.k.add(i);
/* 417 */         this.k.add(this.o.length());
/*     */       } 
/* 419 */       f();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final InputListener h() {
/* 424 */     return (InputListener)new TextAreaListener(this);
/*     */   }
/*     */   
/*     */   public void setSelection(int paramInt1, int paramInt2) {
/* 428 */     super.setSelection(paramInt1, paramInt2);
/* 429 */     e();
/*     */   }
/*     */   
/*     */   protected final void a(boolean paramBoolean1, boolean paramBoolean2) {
/* 433 */     byte b = paramBoolean1 ? 1 : -1;
/*     */     int i;
/* 435 */     if ((i = (this.l << 1) + b) >= 0 && i + 1 < this.k.size && this.k.items[i] == this.p && this.k.items[i + 1] == this.p) {
/*     */       
/* 437 */       this.l += b;
/* 438 */       if (paramBoolean2) {
/* 439 */         super.a(paramBoolean1, paramBoolean2);
/*     */       }
/* 441 */       f();
/*     */     } else {
/* 443 */       super.a(paramBoolean1, paramBoolean2);
/*     */     } 
/* 445 */     e();
/*     */   }
/*     */ 
/*     */   
/*     */   protected final boolean a(int paramInt1, int paramInt2) {
/* 450 */     int i = b(paramInt1 + paramInt2);
/* 451 */     return (super.a(paramInt1, paramInt2) && (i < 0 || i >= this.k.size - 2 || this.k.items[i + 1] != paramInt1 || this.k.items[i + 1] == this.k.items[i + 2]));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCursorLine() {
/* 456 */     return this.l;
/*     */   }
/*     */   
/*     */   public int getFirstLineShowing() {
/* 460 */     return this.m;
/*     */   }
/*     */   
/*     */   public int getLinesShowing() {
/* 464 */     return this.P;
/*     */   }
/*     */   
/*     */   public float getCursorX() {
/* 468 */     float f = 0.0F;
/* 469 */     BitmapFont.BitmapFontData bitmapFontData = this.t.font.getData();
/* 470 */     if (this.p < this.s.size && this.l << 1 < this.k.size) {
/* 471 */       int i = this.k.items[this.l << 1];
/* 472 */       float f1 = 0.0F;
/*     */       BitmapFont.Glyph glyph;
/* 474 */       if ((glyph = bitmapFontData.getGlyph(this.u.charAt(i))) != null)
/*     */       {
/* 476 */         f1 = glyph.fixedWidth ? 0.0F : (-glyph.xoffset * bitmapFontData.scaleX - bitmapFontData.padLeft);
/*     */       }
/* 478 */       f = this.s.get(this.p) - this.s.get(i) + f1;
/*     */     } 
/* 480 */     return f + bitmapFontData.cursorX;
/*     */   }
/*     */   
/*     */   public float getCursorY() {
/* 484 */     BitmapFont bitmapFont = this.t.font;
/* 485 */     return -(this.l - this.m + 1) * bitmapFont.getLineHeight();
/*     */   }
/*     */   
/*     */   public class TextAreaListener extends TextField.TextFieldClickListener { public TextAreaListener(TextArea this$0) {
/* 489 */       super(this$0);
/*     */     }
/*     */     protected final void a(float param1Float1, float param1Float2) {
/* 492 */       this.a.n = -1.0F;
/*     */       
/* 494 */       Drawable drawable = this.a.t.background;
/* 495 */       BitmapFont bitmapFont = this.a.t.font;
/*     */       
/* 497 */       float f = this.a.getHeight();
/*     */       
/* 499 */       if (drawable != null) {
/* 500 */         f -= drawable.getTopHeight();
/* 501 */         param1Float1 -= drawable.getLeftWidth();
/*     */       } 
/* 503 */       param1Float1 = Math.max(0.0F, param1Float1);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 508 */       this.a.l = (int)Math.floor(((f - param1Float2) / bitmapFont.getLineHeight())) + this.a.m;
/* 509 */       this.a.l = Math.max(0, Math.min(this.a.l, this.a.getLines() - 1));
/*     */       
/* 511 */       super.a(param1Float1, param1Float2);
/* 512 */       this.a.e();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/* 517 */       boolean bool = super.keyDown(param1InputEvent, param1Int);
/* 518 */       if (this.a.hasKeyboardFocus()) {
/* 519 */         bool = false;
/* 520 */         boolean bool1 = (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) ? true : false;
/* 521 */         if (param1Int == 20) {
/* 522 */           if (bool1) {
/* 523 */             if (!this.a.r) {
/* 524 */               this.a.q = this.a.p;
/* 525 */               this.a.r = true;
/*     */             } 
/*     */           } else {
/* 528 */             this.a.clearSelection();
/*     */           } 
/* 530 */           this.a.moveCursorLine(this.a.l + 1);
/* 531 */           bool = true;
/* 532 */           this.a.updateContextMenu();
/* 533 */         } else if (param1Int == 19) {
/* 534 */           if (bool1) {
/* 535 */             if (!this.a.r) {
/* 536 */               this.a.q = this.a.p;
/* 537 */               this.a.r = true;
/*     */             } 
/*     */           } else {
/* 540 */             this.a.clearSelection();
/*     */           } 
/* 542 */           this.a.moveCursorLine(this.a.l - 1);
/* 543 */           bool = true;
/* 544 */           this.a.updateContextMenu();
/*     */         } else {
/* 546 */           this.a.n = -1.0F;
/*     */         } 
/* 548 */         if (bool) {
/* 549 */           a(param1Int);
/*     */         }
/* 551 */         this.a.updateContextMenu();
/* 552 */         this.a.f();
/* 553 */         return true;
/*     */       } 
/* 555 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final boolean a(char param1Char) {
/* 560 */       return (this.a.A && param1Char == '\t');
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/* 565 */       boolean bool = super.keyTyped(param1InputEvent, param1Char);
/* 566 */       this.a.f();
/* 567 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final void a(boolean param1Boolean) {
/* 572 */       if (param1Boolean) {
/* 573 */         this.a.p = 0;
/* 574 */       } else if (this.a.l << 1 < this.a.k.size) {
/* 575 */         this.a.p = this.a.k.get(this.a.l << 1);
/*     */       } 
/* 577 */       this.a.updateContextMenu();
/*     */     }
/*     */ 
/*     */     
/*     */     protected final void b(boolean param1Boolean) {
/* 582 */       if (param1Boolean || this.a.l >= this.a.getLines()) {
/* 583 */         this.a.p = this.a.o.length();
/* 584 */       } else if ((this.a.l << 1) + 1 < this.a.k.size) {
/* 585 */         this.a.p = this.a.k.get((this.a.l << 1) + 1);
/*     */       } 
/* 587 */       this.a.updateContextMenu();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\TextArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */