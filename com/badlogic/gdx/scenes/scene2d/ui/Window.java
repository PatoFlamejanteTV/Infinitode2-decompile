/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Group;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ public class Window
/*     */   extends Table
/*     */ {
/*  41 */   private static final Vector2 tmpPosition = new Vector2();
/*  42 */   private static final Vector2 tmpSize = new Vector2(); private static final int MOVE = 32;
/*     */   private WindowStyle style;
/*     */   boolean isMovable = true;
/*     */   boolean isModal;
/*     */   boolean isResizable;
/*  47 */   int resizeBorder = 8;
/*     */   
/*     */   boolean keepWithinStage = true;
/*     */   Label titleLabel;
/*     */   Table titleTable;
/*     */   boolean drawTitleTable;
/*     */   protected int edge;
/*     */   protected boolean dragging;
/*     */   
/*     */   public Window(String paramString, Skin paramSkin) {
/*  57 */     this(paramString, paramSkin.<WindowStyle>get(WindowStyle.class));
/*  58 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public Window(String paramString1, Skin paramSkin, String paramString2) {
/*  62 */     this(paramString1, paramSkin.<WindowStyle>get(paramString2, WindowStyle.class));
/*  63 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public Window(String paramString, WindowStyle paramWindowStyle) {
/*  67 */     if (paramString == null) throw new IllegalArgumentException("title cannot be null."); 
/*  68 */     setTouchable(Touchable.enabled);
/*  69 */     setClip(true);
/*     */     
/*  71 */     this.titleLabel = newLabel(paramString, new Label.LabelStyle(paramWindowStyle.titleFont, paramWindowStyle.titleFontColor));
/*  72 */     this.titleLabel.setEllipsis(true);
/*     */     
/*  74 */     this.titleTable = new Table() {
/*     */         public void draw(Batch param1Batch, float param1Float) {
/*  76 */           if (Window.this.drawTitleTable) super.draw(param1Batch, param1Float); 
/*     */         }
/*     */       };
/*  79 */     this.titleTable.<Label>add(this.titleLabel).expandX().fillX().minWidth(0.0F);
/*  80 */     addActor((Actor)this.titleTable);
/*     */     
/*  82 */     setStyle(paramWindowStyle);
/*  83 */     setWidth(150.0F);
/*  84 */     setHeight(150.0F);
/*     */     
/*  86 */     addCaptureListener((EventListener)new InputListener() {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  88 */             Window.this.toFront();
/*  89 */             return false;
/*     */           }
/*     */         });
/*  92 */     addListener((EventListener)new InputListener() { float startX;
/*     */           float startY;
/*     */           
/*     */           private void updateEdge(float param1Float1, float param1Float2) {
/*  96 */             float f1 = Window.this.resizeBorder / 2.0F;
/*  97 */             float f2 = Window.this.getWidth(), f3 = Window.this.getHeight();
/*  98 */             float f4 = Window.this.getPadTop(), f5 = Window.this.getPadLeft(), f6 = Window.this.getPadBottom(), f7 = Window.this.getPadRight();
/*  99 */             f2 -= f7;
/* 100 */             Window.this.edge = 0;
/* 101 */             if (Window.this.isResizable && param1Float1 >= f5 - f1 && param1Float1 <= f2 + f1 && param1Float2 >= f6 - f1) {
/* 102 */               if (param1Float1 < f5 + f1) Window.this.edge |= 0x8; 
/* 103 */               if (param1Float1 > f2 - f1) Window.this.edge |= 0x10; 
/* 104 */               if (param1Float2 < f6 + f1) Window.this.edge |= 0x4; 
/* 105 */               if (Window.this.edge != 0) f1 += 25.0F; 
/* 106 */               if (param1Float1 < f5 + f1) Window.this.edge |= 0x8; 
/* 107 */               if (param1Float1 > f2 - f1) Window.this.edge |= 0x10; 
/* 108 */               if (param1Float2 < f6 + f1) Window.this.edge |= 0x4; 
/*     */             } 
/* 110 */             if (Window.this.isMovable && Window.this.edge == 0 && param1Float2 <= f3 && param1Float2 >= f3 - f4 && param1Float1 >= f5 && param1Float1 <= f2) Window.this.edge = 32; 
/*     */           }
/*     */           float lastX; float lastY;
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 114 */             if (param1Int2 == 0) {
/* 115 */               updateEdge(param1Float1, param1Float2);
/* 116 */               Window.this.dragging = (Window.this.edge != 0);
/* 117 */               this.startX = param1Float1;
/* 118 */               this.startY = param1Float2;
/* 119 */               this.lastX = param1Float1 - Window.this.getWidth();
/* 120 */               this.lastY = param1Float2 - Window.this.getHeight();
/*     */             } 
/* 122 */             return (Window.this.edge != 0 || Window.this.isModal);
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 126 */             Window.this.dragging = false;
/*     */           }
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/* 130 */             if (!Window.this.dragging)
/* 131 */               return;  float f1 = Window.this.getWidth(), f2 = Window.this.getHeight();
/* 132 */             float f3 = Window.this.getX(), f4 = Window.this.getY();
/*     */             
/* 134 */             float f5 = Window.this.getMinWidth(); Window.this.getMaxWidth();
/* 135 */             float f6 = Window.this.getMinHeight(); Window.this.getMaxHeight();
/* 136 */             Stage stage = Window.this.getStage();
/* 137 */             boolean bool = (Window.this.keepWithinStage && stage != null && Window.this.getParent() == stage.getRoot()) ? true : false;
/*     */             
/* 139 */             if ((Window.this.edge & 0x20) != 0) {
/* 140 */               float f7 = param1Float1 - this.startX, f8 = param1Float2 - this.startY;
/* 141 */               f3 += f7;
/* 142 */               f4 += f8;
/*     */             } 
/* 144 */             if ((Window.this.edge & 0x8) != 0) {
/* 145 */               float f = param1Float1 - this.startX;
/* 146 */               if (f1 - f < f5) f = -(f5 - f1); 
/* 147 */               if (bool && f3 + f < 0.0F) f = -f3; 
/* 148 */               f1 -= f;
/* 149 */               f3 += f;
/*     */             } 
/* 151 */             if ((Window.this.edge & 0x4) != 0) {
/* 152 */               float f = param1Float2 - this.startY;
/* 153 */               if (f2 - f < f6) f = -(f6 - f2); 
/* 154 */               if (bool && f4 + f < 0.0F) f = -f4; 
/* 155 */               f2 -= f;
/* 156 */               f4 += f;
/*     */             } 
/* 158 */             if ((Window.this.edge & 0x10) != 0) {
/* 159 */               float f = param1Float1 - this.lastX - f1;
/* 160 */               if (f1 + f < f5) f = f5 - f1; 
/* 161 */               if (bool && f3 + f1 + f > stage.getWidth()) f = stage.getWidth() - f3 - f1; 
/* 162 */               f1 += f;
/*     */             } 
/* 164 */             if ((Window.this.edge & 0x2) != 0) {
/* 165 */               float f = param1Float2 - this.lastY - f2;
/* 166 */               if (f2 + f < f6) f = f6 - f2; 
/* 167 */               if (bool && f4 + f2 + f > stage.getHeight())
/* 168 */                 f = stage.getHeight() - f4 - f2; 
/* 169 */               f2 += f;
/*     */             } 
/* 171 */             Window.this.setBounds(Math.round(f3), Math.round(f4), Math.round(f1), Math.round(f2));
/*     */           }
/*     */           
/*     */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 175 */             updateEdge(param1Float1, param1Float2);
/* 176 */             return Window.this.isModal;
/*     */           }
/*     */           
/*     */           public boolean scrolled(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/* 180 */             return Window.this.isModal;
/*     */           }
/*     */           
/*     */           public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/* 184 */             return Window.this.isModal;
/*     */           }
/*     */           
/*     */           public boolean keyUp(InputEvent param1InputEvent, int param1Int) {
/* 188 */             return Window.this.isModal;
/*     */           }
/*     */           
/*     */           public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/* 192 */             return Window.this.isModal;
/*     */           } }
/*     */       );
/*     */   }
/*     */   
/*     */   protected Label newLabel(String paramString, Label.LabelStyle paramLabelStyle) {
/* 198 */     return new Label(paramString, paramLabelStyle);
/*     */   }
/*     */   
/*     */   public void setStyle(WindowStyle paramWindowStyle) {
/* 202 */     if (paramWindowStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 203 */     this.style = paramWindowStyle;
/*     */     
/* 205 */     setBackground(paramWindowStyle.background);
/* 206 */     this.titleLabel.setStyle(new Label.LabelStyle(paramWindowStyle.titleFont, paramWindowStyle.titleFontColor));
/* 207 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WindowStyle getStyle() {
/* 213 */     return this.style;
/*     */   }
/*     */   public void keepWithinStage() {
/*     */     float f;
/* 217 */     if (!this.keepWithinStage)
/*     */       return;  Stage stage;
/* 219 */     if ((stage = getStage()) == null)
/*     */       return;  Camera camera;
/* 221 */     if (camera = stage.getCamera() instanceof OrthographicCamera) {
/* 222 */       OrthographicCamera orthographicCamera = (OrthographicCamera)camera;
/* 223 */       float f1 = stage.getWidth();
/* 224 */       f = stage.getHeight();
/* 225 */       if (getX(16) - camera.position.x > f1 / 2.0F / orthographicCamera.zoom)
/* 226 */         setPosition(camera.position.x + f1 / 2.0F / orthographicCamera.zoom, getY(16), 16); 
/* 227 */       if (getX(8) - camera.position.x < -f1 / 2.0F / orthographicCamera.zoom)
/* 228 */         setPosition(camera.position.x - f1 / 2.0F / orthographicCamera.zoom, getY(8), 8); 
/* 229 */       if (getY(2) - camera.position.y > f / 2.0F / orthographicCamera.zoom)
/* 230 */         setPosition(getX(2), camera.position.y + f / 2.0F / orthographicCamera.zoom, 2); 
/* 231 */       if (getY(4) - camera.position.y < -f / 2.0F / orthographicCamera.zoom)
/* 232 */         setPosition(getX(4), camera.position.y - f / 2.0F / orthographicCamera.zoom, 4);  return;
/* 233 */     }  if (getParent() == f.getRoot()) {
/* 234 */       float f1 = f.getWidth();
/* 235 */       float f2 = f.getHeight();
/* 236 */       if (getX() < 0.0F) setX(0.0F); 
/* 237 */       if (getRight() > f1) setX(f1 - getWidth()); 
/* 238 */       if (getY() < 0.0F) setY(0.0F); 
/* 239 */       if (getTop() > f2) setY(f2 - getHeight()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     Stage stage;
/* 245 */     if ((stage = getStage()) != null) {
/* 246 */       if (stage.getKeyboardFocus() == null) stage.setKeyboardFocus((Actor)this);
/*     */       
/* 248 */       keepWithinStage();
/*     */       
/* 250 */       if (this.style.stageBackground != null) {
/* 251 */         stageToLocalCoordinates(tmpPosition.set(0.0F, 0.0F));
/* 252 */         stageToLocalCoordinates(tmpSize.set(stage.getWidth(), stage.getHeight()));
/* 253 */         drawStageBackground(paramBatch, paramFloat, getX() + tmpPosition.x, getY() + tmpPosition.y, getX() + tmpSize.x, 
/* 254 */             getY() + tmpSize.y);
/*     */       } 
/*     */     } 
/* 257 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   protected void drawStageBackground(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 261 */     Color color = getColor();
/* 262 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat1);
/* 263 */     this.style.stageBackground.draw(paramBatch, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
/*     */   }
/*     */   
/*     */   protected void drawBackground(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 267 */     super.drawBackground(paramBatch, paramFloat1, paramFloat2, paramFloat3);
/*     */ 
/*     */     
/* 270 */     (this.titleTable.getColor()).a = (getColor()).a;
/* 271 */     paramFloat2 = getPadTop(); paramFloat3 = getPadLeft();
/* 272 */     this.titleTable.setSize(getWidth() - paramFloat3 - getPadRight(), paramFloat2);
/* 273 */     this.titleTable.setPosition(paramFloat3, getHeight() - paramFloat2);
/* 274 */     this.drawTitleTable = true;
/* 275 */     this.titleTable.draw(paramBatch, paramFloat1);
/* 276 */     this.drawTitleTable = false;
/*     */   }
/*     */   @Null
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 280 */     if (!isVisible()) return null; 
/*     */     Actor actor;
/* 282 */     if ((actor = super.hit(paramFloat1, paramFloat2, paramBoolean)) == null && this.isModal && (!paramBoolean || getTouchable() == Touchable.enabled)) return (Actor)this; 
/* 283 */     float f = getHeight();
/* 284 */     if (actor == null || actor == this) return actor; 
/* 285 */     if (paramFloat2 <= f && paramFloat2 >= f - getPadTop() && paramFloat1 >= 0.0F && paramFloat1 <= getWidth()) {
/*     */       Group group;
/* 287 */       Actor actor1 = actor;
/* 288 */       while (actor1.getParent() != this)
/* 289 */         group = actor1.getParent(); 
/* 290 */       if (getCell(group) != null) return (Actor)this; 
/*     */     } 
/* 292 */     return actor;
/*     */   }
/*     */   
/*     */   public boolean isMovable() {
/* 296 */     return this.isMovable;
/*     */   }
/*     */   
/*     */   public void setMovable(boolean paramBoolean) {
/* 300 */     this.isMovable = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isModal() {
/* 304 */     return this.isModal;
/*     */   }
/*     */   
/*     */   public void setModal(boolean paramBoolean) {
/* 308 */     this.isModal = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setKeepWithinStage(boolean paramBoolean) {
/* 312 */     this.keepWithinStage = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isResizable() {
/* 316 */     return this.isResizable;
/*     */   }
/*     */   
/*     */   public void setResizable(boolean paramBoolean) {
/* 320 */     this.isResizable = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setResizeBorder(int paramInt) {
/* 324 */     this.resizeBorder = paramInt;
/*     */   }
/*     */   
/*     */   public boolean isDragging() {
/* 328 */     return this.dragging;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 332 */     return Math.max(super.getPrefWidth(), this.titleTable.getPrefWidth() + getPadLeft() + getPadRight());
/*     */   }
/*     */   
/*     */   public Table getTitleTable() {
/* 336 */     return this.titleTable;
/*     */   }
/*     */   
/*     */   public Label getTitleLabel() {
/* 340 */     return this.titleLabel;
/*     */   }
/*     */   
/*     */   public static class WindowStyle {
/*     */     @Null
/*     */     public Drawable background;
/*     */     public BitmapFont titleFont;
/*     */     @Null
/* 348 */     public Color titleFontColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     @Null
/*     */     public Drawable stageBackground;
/*     */     
/*     */     public WindowStyle() {}
/*     */     
/*     */     public WindowStyle(BitmapFont param1BitmapFont, Color param1Color, @Null Drawable param1Drawable) {
/* 355 */       this.titleFont = param1BitmapFont;
/* 356 */       this.titleFontColor.set(param1Color);
/* 357 */       this.background = param1Drawable;
/*     */     }
/*     */     
/*     */     public WindowStyle(WindowStyle param1WindowStyle) {
/* 361 */       this.titleFont = param1WindowStyle.titleFont;
/* 362 */       if (param1WindowStyle.titleFontColor != null) this.titleFontColor = new Color(param1WindowStyle.titleFontColor); 
/* 363 */       this.background = param1WindowStyle.background;
/* 364 */       this.stageBackground = param1WindowStyle.stageBackground;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Window.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */