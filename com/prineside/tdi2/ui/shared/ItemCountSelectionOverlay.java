/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public final class ItemCountSelectionOverlay extends UiManager.UiComponent.Adapter {
/*  26 */   private static final TLog a = TLog.forClass(ItemCountSelectionOverlay.class);
/*     */   public static ItemCountSelectionOverlay i() {
/*  28 */     return (ItemCountSelectionOverlay)Game.i.uiManager.getComponent(ItemCountSelectionOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  33 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 292, "ItemCountSelectionOverlay main");
/*     */   
/*     */   private Group c;
/*     */   
/*     */   private Table d;
/*     */   
/*     */   private ItemCell e;
/*     */   
/*     */   private Label f;
/*     */   private ComplexButton g;
/*     */   private Image h;
/*     */   private ComplexButton i;
/*     */   private ComplexButton j;
/*     */   private ComplexButton k;
/*     */   private ComplexButton l;
/*     */   private Group m;
/*     */   private int n;
/*     */   private int o;
/*     */   private int p;
/*     */   private ItemCountSelectionListener q;
/*     */   
/*     */   public ItemCountSelectionOverlay() {
/*     */     Group group;
/*  56 */     (group = new Group()).setTransform(false);
/*  57 */     group.setOrigin(400.0F, 142.0F);
/*  58 */     this.b.getTable().add().expand().fill().row();
/*  59 */     this.b.getTable().add((Actor)group).size(800.0F, 284.0F).padBottom(128.0F);
/*     */     
/*  61 */     this.c = new Group();
/*  62 */     this.c.setTransform(false);
/*  63 */     this.c.setSize(800.0F, 284.0F);
/*  64 */     this.c.setOrigin(400.0F, 142.0F);
/*  65 */     group.addActor((Actor)this.c);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/*  73 */     (quadActor = new QuadActor(new Color(72), new float[] { 9.0F, 0.0F, 0.0F, 284.0F, 800.0F, 275.0F, 793.0F, 7.0F })).setPosition(10.0F, -10.0F);
/*  74 */     this.c.addActor((Actor)quadActor);
/*     */     
/*  76 */     quadActor = new QuadActor(new Color(791621631), new float[] { 9.0F, 0.0F, 0.0F, 284.0F, 800.0F, 275.0F, 793.0F, 7.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     this.c.addActor((Actor)quadActor);
/*     */     
/*  84 */     this.e = new ItemCell();
/*  85 */     this.e.setPosition(31.0F, 114.0F);
/*  86 */     this.c.addActor((Actor)this.e);
/*     */     
/*  88 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(30));
/*  89 */     this.f.setPosition(190.0F, 212.0F);
/*  90 */     this.f.setSize(100.0F, 25.0F);
/*  91 */     this.f.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  92 */     this.c.addActor((Actor)this.f);
/*     */ 
/*     */     
/*  95 */     this.m = new Group();
/*  96 */     this.m.setTransform(false);
/*  97 */     this.m.setPosition(160.0F, 141.0F);
/*  98 */     this.m.setSize(620.0F, 72.0F);
/*  99 */     this.m.addListener((EventListener)new InputListener(this)
/*     */         {
/*     */           private void a(float param1Float) {
/* 102 */             if ((param1Float = (param1Float - 30.0F) / 560.0F) <= 0.0F) {
/* 103 */               this.a.setSelectedCount(ItemCountSelectionOverlay.a(this.a)); return;
/* 104 */             }  if (param1Float >= 1.0F) {
/* 105 */               this.a.setSelectedCount(ItemCountSelectionOverlay.b(this.a));
/*     */               return;
/*     */             } 
/*     */             int i;
/* 109 */             if ((i = MathUtils.round(param1Float * (ItemCountSelectionOverlay.b(this.a) - ItemCountSelectionOverlay.a(this.a)) + ItemCountSelectionOverlay.a(this.a))) > 10000) {
/* 110 */               i = MathUtils.round(i / 50.0F) * 50;
/* 111 */             } else if (i > 1000) {
/* 112 */               i = MathUtils.round(i / 10.0F) * 10;
/*     */             } 
/* 114 */             this.a.setSelectedCount(i);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 120 */             a(param1Float1);
/*     */             
/* 122 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/* 127 */             a(param1Float1);
/*     */           }
/*     */         });
/* 130 */     this.c.addActor((Actor)this.m);
/*     */     
/*     */     Image image;
/* 133 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(560.0F, 12.0F);
/* 134 */     image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 135 */     image.setPosition(30.0F, 30.0F);
/* 136 */     this.m.addActor((Actor)image);
/*     */     
/* 138 */     this.h = new Image((Drawable)Game.i.assetManager.getDrawable("ui-item-count-selector-scroll-button"));
/* 139 */     this.h.setSize(41.0F, 25.0F);
/* 140 */     this.m.addActor((Actor)this.h);
/*     */     
/* 142 */     this.g = new ComplexButton("", Game.i.assetManager.getLabelStyle(36), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this)
/*     */           {
/*     */             public void input(String param1String) {
/*     */               try {
/* 146 */                 int i = Integer.valueOf(param1String).intValue();
/* 147 */                 this.a.setSelectedCount(i); return;
/* 148 */               } catch (Exception exception) {
/* 149 */                 ItemCountSelectionOverlay.a().e("invalid value", new Object[] { exception });
/*     */                 return;
/*     */               } 
/*     */             }
/*     */             
/*     */             public void canceled() {}
/*     */           }this.n + " <=> " + this.o, this.p, ""));
/* 156 */     this.g.setLabel(0.0F, 0.0F, 156.0F, 40.0F, 16);
/* 157 */     this.g.setSize(156.0F, 40.0F);
/* 158 */     this.g.setPosition(594.0F, 208.0F);
/* 159 */     this.g.setLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P400, MaterialColor.LIGHT_BLUE.P600, Color.GRAY);
/* 160 */     this.c.addActor((Actor)this.g);
/*     */     
/*     */     ComplexButton complexButton;
/* 163 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(36), () -> setSelectedCount(this.p - 1))).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-item-count-selector-minus-button"), 0.0F, 0.0F, 48.0F, 53.0F);
/* 164 */     complexButton.setSize(48.0F, 53.0F);
/* 165 */     complexButton.setBackgroundColors(MaterialColor.BLUE_GREY.P700, MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P600, MaterialColor.GREY.P700);
/* 166 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-minus"), 9.0F, 13.0F, 32.0F, 32.0F);
/* 167 */     complexButton.setPosition(766.0F, 149.0F);
/* 168 */     this.c.addActor((Actor)complexButton);
/*     */ 
/*     */     
/* 171 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(36), () -> setSelectedCount(this.p + 1))).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-item-count-selector-plus-button"), 0.0F, 0.0F, 51.0F, 57.0F);
/* 172 */     complexButton.setSize(51.0F, 57.0F);
/* 173 */     complexButton.setBackgroundColors(MaterialColor.BLUE_GREY.P700, MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P600, MaterialColor.GREY.P700);
/* 174 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-plus"), 10.0F, 17.0F, 32.0F, 32.0F);
/* 175 */     complexButton.setPosition(768.0F, 202.0F);
/* 176 */     this.c.addActor((Actor)complexButton);
/*     */     
/* 178 */     this.i = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> setSelectedCount(this.n));
/* 179 */     this.i.setPosition(160.0F, 121.0F);
/* 180 */     this.i.setLabel(32.0F, 16.0F, 50.0F, 18.0F, 8);
/* 181 */     this.i.setSize(60.0F, 40.0F);
/* 182 */     this.i.setLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P400, MaterialColor.LIGHT_BLUE.P600, MaterialColor.GREY.P700);
/* 183 */     this.c.addActor((Actor)this.i);
/*     */     
/* 185 */     this.j = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> setSelectedCount(this.o));
/* 186 */     this.j.setPosition(654.0F, 121.0F);
/* 187 */     this.j.setLabel(0.0F, 16.0F, 96.0F, 18.0F, 16);
/* 188 */     this.j.setSize(96.0F, 40.0F);
/* 189 */     this.j.setLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P400, MaterialColor.LIGHT_BLUE.P600, MaterialColor.GREY.P700);
/* 190 */     this.c.addActor((Actor)this.j);
/*     */     
/* 192 */     this.k = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> setSelectedCount((this.o - this.n) / 2 + this.n));
/* 193 */     this.k.setPosition(423.0F, 121.0F);
/* 194 */     this.k.setLabel(0.0F, 16.0F, 96.0F, 18.0F, 1);
/* 195 */     this.k.setSize(96.0F, 40.0F);
/* 196 */     this.k.setLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P400, MaterialColor.LIGHT_BLUE.P600, MaterialColor.GREY.P700);
/* 197 */     this.c.addActor((Actor)this.k);
/*     */     
/* 199 */     this.d = new Table();
/* 200 */     this.d.setSize(470.0F, 80.0F);
/* 201 */     this.d.setPosition(35.0F, 25.0F);
/* 202 */     this.c.addActor((Actor)this.d);
/*     */     
/* 204 */     this.l = new ComplexButton("", Game.i.assetManager.getLabelStyle(36), () -> {
/*     */           if (this.q != null)
/*     */             this.q.selectionConfirmed(this.p);  hide();
/*     */         });
/* 208 */     this.l.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-item-count-selector-cancel-button"), 0.0F, 0.0F, 146.0F, 99.0F);
/* 209 */     this.l.setSize(146.0F, 99.0F);
/* 210 */     this.l.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.GREY.P700);
/* 211 */     this.l.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-check"), 40.0F, 18.0F, 64.0F, 64.0F);
/* 212 */     this.l.setPosition(523.0F, -11.0F);
/* 213 */     this.c.addActor((Actor)this.l);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 219 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(36), () -> { if (this.q != null) this.q.selectionCanceled();  hide(); })).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-item-count-selector-confirm-button"), 0.0F, 0.0F, 146.0F, 99.0F);
/* 220 */     complexButton.setSize(138.0F, 99.0F);
/* 221 */     complexButton.setBackgroundColors(MaterialColor.BLUE_GREY.P700, MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P600, MaterialColor.GREY.P700);
/* 222 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 40.0F, 16.0F, 64.0F, 64.0F);
/* 223 */     complexButton.setPosition(669.0F, -7.0F);
/* 224 */     this.c.addActor((Actor)complexButton);
/*     */     
/* 226 */     this.b.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public final void setConfirmButtonEnabled(boolean paramBoolean) {
/* 230 */     this.l.setEnabled(paramBoolean);
/*     */   } public static interface ItemCountSelectionListener {
/*     */     void countChanged(int param1Int); void selectionConfirmed(int param1Int); void selectionCanceled(); }
/*     */   public final int getMinCount() {
/* 234 */     return this.n;
/*     */   }
/*     */   
/*     */   public final int getMaxCount() {
/* 238 */     return this.o;
/*     */   }
/*     */   
/*     */   public final void setMinMaxCount(int paramInt1, int paramInt2) {
/* 242 */     this.n = paramInt1;
/* 243 */     this.o = paramInt2;
/*     */     
/* 245 */     this.i.setTextFromInt(paramInt1);
/* 246 */     this.j.setTextFromInt(paramInt2);
/* 247 */     if (paramInt2 - paramInt1 > 2) {
/* 248 */       this.k.setTextFromInt((paramInt2 - paramInt1) / 2 + paramInt1);
/*     */     }
/*     */     
/* 251 */     if (this.p < this.n) this.p = this.n; 
/* 252 */     if (this.p > this.o) this.p = this.o; 
/* 253 */     this.g.setText("x" + StringFormatter.commaSeparatedNumber(this.p));
/*     */     
/* 255 */     b();
/*     */   }
/*     */   
/*     */   public final void setSelectedCount(int paramInt) {
/* 259 */     int i = this.p;
/*     */     
/* 261 */     if (paramInt < this.n) paramInt = this.n; 
/* 262 */     if (paramInt > this.o) paramInt = this.o;
/*     */     
/* 264 */     this.p = paramInt;
/* 265 */     this.g.setText("x" + StringFormatter.commaSeparatedNumber(paramInt));
/*     */     
/* 267 */     b();
/*     */     
/* 269 */     if (this.q != null && i != paramInt) {
/* 270 */       this.q.countChanged(this.p);
/*     */     }
/*     */   }
/*     */   
/*     */   public final int getSelectedCount() {
/* 275 */     return this.p;
/*     */   }
/*     */   
/*     */   private void b() {
/* 279 */     if (this.n == this.o) {
/* 280 */       this.m.setVisible(false);
/* 281 */       this.i.setVisible(false);
/* 282 */       this.j.setVisible(false);
/* 283 */       this.k.setVisible(false); return;
/*     */     } 
/* 285 */     float f = (this.p - this.n) / (this.o - this.n);
/* 286 */     this.h.setPosition(30.0F + f * 519.0F, 24.0F);
/* 287 */     this.m.setVisible(true);
/*     */     
/* 289 */     if (this.o - this.n > 2) {
/* 290 */       this.k.setVisible(true);
/*     */     } else {
/* 292 */       this.k.setVisible(false);
/*     */     } 
/* 294 */     this.i.setVisible(true);
/* 295 */     this.j.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void show(CharSequence paramCharSequence, int paramInt1, int paramInt2, Item paramItem, ItemCountSelectionListener paramItemCountSelectionListener) {
/* 303 */     setConfirmButtonEnabled(true);
/*     */     
/* 305 */     this.e.setItem(paramItem, 0);
/* 306 */     this.f.setText(paramCharSequence);
/*     */     
/* 308 */     this.p = paramInt1;
/* 309 */     setMinMaxCount(paramInt1, paramInt2);
/*     */     
/* 311 */     DarkOverlay.i().addCallerOverlayLayer("ItemCountSelectionOverlay", this.b.zIndex - 1, () -> {
/*     */           hide();
/*     */           return true;
/*     */         });
/* 315 */     UiUtils.bouncyShowOverlay(null, (Actor)this.b.getTable(), this.c);
/*     */     
/* 317 */     b();
/*     */     
/* 319 */     this.q = paramItemCountSelectionListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Table getInfoContainer() {
/* 326 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 331 */     this.q = null;
/* 332 */     this.d.clear();
/* 333 */     UiUtils.bouncyHideOverlay(null, (Actor)this.b.getTable(), this.c);
/* 334 */     DarkOverlay.i().removeCaller("ItemCountSelectionOverlay");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\ItemCountSelectionOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */