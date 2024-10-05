/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Environment;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.PointLight;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Node;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Research;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.TrophyType;
/*     */ import com.prineside.tdi2.managers.TrophyManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ActorGestureListener;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.ModelView;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ 
/*     */ public final class MainMenuUiScene extends UiManager.UiComponent.Adapter {
/*  43 */   private static final TLog a = TLog.forClass(MainMenuUiScene.class); private ModelView b;
/*     */   public static MainMenuUiScene i() {
/*  45 */     return (MainMenuUiScene)Game.i.uiManager.getComponent(MainMenuUiScene.class);
/*     */   }
/*     */ 
/*     */   
/*  49 */   private Table c = new Table();
/*     */   
/*  51 */   private final AtomicBoolean d = new AtomicBoolean(false);
/*  52 */   private int e = -1;
/*     */   
/*  54 */   private static final float[] f = new float[9];
/*  55 */   private static final Color g = new Color();
/*     */   
/*     */   public MainMenuUiScene() {
/*  58 */     recreate();
/*     */   }
/*     */   
/*     */   public final void recreate() {
/*  62 */     long l = Game.getTimestampMillis();
/*  63 */     this.e = -1;
/*     */     
/*  65 */     if (!Game.i.settingsManager.isThreeDeeModelsEnabled()) {
/*     */       
/*  67 */       if (this.b != null) {
/*  68 */         this.b.dispose();
/*  69 */         this.b = null;
/*     */       } 
/*     */       
/*  72 */       this.c.clearListeners();
/*  73 */       this.c.addListener((EventListener)new ClickListener(this)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  76 */               TrophiesListOverlay.i().show();
/*     */             }
/*     */           });
/*  79 */       this.c.setTouchable(Touchable.enabled);
/*     */     
/*     */     }
/*  82 */     else if (this.b == null) {
/*     */       Environment environment;
/*  84 */       (environment = new Environment()).set((Attribute)new ColorAttribute(ColorAttribute.AmbientLight, 0.65F, 0.65F, 0.65F, 1.0F));
/*  85 */       PointLight pointLight1 = new PointLight();
/*  86 */       environment.add(pointLight1);
/*     */       
/*     */       PointLight pointLight2;
/*  89 */       (pointLight2 = new PointLight()).set(MaterialColor.CYAN.P200, 0.0F, 0.5F, 0.0F, 0.3F);
/*  90 */       environment.add(pointLight2);
/*     */ 
/*     */       
/*  93 */       boolean[] arrayOfBoolean = { true };
/*  94 */       float[] arrayOfFloat1 = { 0.0F };
/*  95 */       float[] arrayOfFloat2 = { 0.45F };
/*     */ 
/*     */ 
/*     */       
/*  99 */       float[] arrayOfFloat3 = { 0.0F };
/*     */       
/* 101 */       int i = Game.i.uiManager.getScreenWidth();
/* 102 */       int j = Game.i.uiManager.getScreenHeight();
/*     */       
/* 104 */       this.b = new ModelView(i, j, new ModelView.Transformer(this, arrayOfBoolean, arrayOfFloat3, arrayOfFloat1, arrayOfFloat2, pointLight1) {
/* 105 */             private float a = 20.0F;
/* 106 */             private float b = 360.0F;
/* 107 */             private float c = 25.0F;
/*     */ 
/*     */             
/*     */             public void transform(ModelView param1ModelView, float param1Float1, float param1Float2) {
/* 111 */               if (this.d[0]) {
/* 112 */                 param1Float2 = this.c * param1Float1;
/* 113 */                 if (this.e[0] < -this.b) {
/* 114 */                   this.e[0] = -this.b;
/* 115 */                 } else if (this.e[0] > this.b) {
/* 116 */                   this.e[0] = this.b;
/*     */                 } 
/*     */                 
/* 119 */                 if ((this.e[0] < 0.0F && this.a > 0.0F) || (this.e[0] > 0.0F && this.a < 0.0F)) {
/* 120 */                   this.a = -this.a;
/*     */                 }
/*     */                 
/* 123 */                 if (this.e[0] < this.a) {
/*     */                   
/* 125 */                   this.e[0] = this.e[0] + param1Float2;
/* 126 */                   if (this.e[0] > this.a) {
/* 127 */                     this.e[0] = this.a;
/*     */                   }
/* 129 */                 } else if (this.e[0] > this.a) {
/*     */                   
/* 131 */                   this.e[0] = this.e[0] - param1Float2;
/* 132 */                   if (this.e[0] < this.a) {
/* 133 */                     this.e[0] = this.a;
/*     */                   }
/*     */                 } 
/*     */                 
/* 137 */                 this.f[0] = this.f[0] + this.e[0] * param1Float1;
/*     */               } 
/*     */               
/* 140 */               this.f[0] = this.f[0] % 360.0F;
/*     */               
/* 142 */               param1Float2 = Interpolation.circleOut.apply(1.0F - this.g[0] / 1.15F * 0.99F);
/* 143 */               Vector2 vector21 = new Vector2();
/* 144 */               PMath.getPointByAngleFromPoint(0.0F, 0.0F, this.f[0], 1.1F * param1Float2, vector21);
/* 145 */               if (param1ModelView == null) throw new IllegalStateException("modelView is null"); 
/* 146 */               if (param1ModelView.camera == null) throw new IllegalStateException("modelView.camera is null"); 
/* 147 */               if (param1ModelView.camera.position == null) throw new IllegalStateException("modelView.camera.position is null");
/*     */ 
/*     */               
/* 150 */               param1ModelView.camera.position.set(vector21.x, this.g[0], vector21.y);
/* 151 */               param1ModelView.camera.up.set(0.0F, 1.0F, 0.0F);
/*     */ 
/*     */               
/* 154 */               param1ModelView.camera.lookAt(0.0F, 0.35F * param1Float2, 0.0F);
/* 155 */               param1ModelView.camera.update();
/*     */               
/* 157 */               Vector2 vector22 = new Vector2();
/* 158 */               PMath.getPointByAngleFromPoint(0.0F, 0.0F, this.f[0] - 45.0F, 3.0F, vector22);
/*     */ 
/*     */ 
/*     */               
/* 162 */               PMath.getPointByAngleFromPoint(vector21.x, vector21.y, this.f[0] - 90.0F, 1.0F, vector22);
/* 163 */               this.h.set(0.55F, 0.55F, 0.55F, vector22.x, this.g[0] + 1.0F, vector22.y, 2.5F);
/*     */               
/* 165 */               param1ModelView.requireRedraw();
/*     */             }
/*     */           }environment, true);
/* 168 */       this.b.addListener((EventListener)new ActorGestureListener(this, arrayOfBoolean, arrayOfFloat3, arrayOfFloat1, arrayOfFloat2)
/*     */           {
/*     */             public void touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 171 */               this.e[0] = false;
/* 172 */               this.f[0] = 0.0F;
/*     */             }
/*     */ 
/*     */             
/*     */             public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 177 */               this.e[0] = true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void fling(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/* 182 */               this.f[0] = param1Float1 * 0.05F;
/*     */             }
/*     */ 
/*     */             
/*     */             public void pan(InputEvent param1InputEvent, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 187 */               this.g[0] = this.g[0] + param1Float3 * 0.1F;
/* 188 */               this.h[0] = this.h[0] - param1Float4 * 0.001F;
/* 189 */               this.h[0] = MathUtils.clamp(this.h[0], 0.3F, 1.15F);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void zoom(InputEvent param1InputEvent, float param1Float1, float param1Float2) {}
/*     */ 
/*     */             
/*     */             public void tap(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 198 */               TrophiesListOverlay.i().show();
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 203 */     a.d("recreate took " + (Game.getTimestampMillis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public final Actor getContents() {
/* 207 */     return (Actor)((this.b == null) ? this.c : this.b);
/*     */   }
/*     */   
/*     */   public final void rebuildIfNeeded() {
/* 211 */     long l = Game.getTimestampMillis();
/*     */ 
/*     */     
/* 214 */     int i = Game.i.uiManager.getScreenWidth() * 31 + Game.i.uiManager.getScreenHeight();
/*     */     
/* 216 */     Array array1 = Game.i.researchManager.getInstances();
/* 217 */     Array array2 = Game.i.researchManager.getLinks();
/*     */     
/* 219 */     for (byte b1 = 0; b1 < array1.size; b1++) {
/* 220 */       Research research = (Research)array1.get(b1);
/* 221 */       i = i * 29 + research.getInstalledLevel();
/*     */     }  TrophyType[] arrayOfTrophyType; int j; byte b2;
/* 223 */     for (j = (arrayOfTrophyType = TrophyType.values).length, b2 = 0; b2 < j; ) { TrophyType trophyType = arrayOfTrophyType[b2];
/* 224 */       if (Game.i.trophyManager.getConfig(trophyType).isReceived()) {
/* 225 */         i = i * 29 + 1;
/*     */       }
/*     */       b2++; }
/*     */     
/* 229 */     if (this.e != i) {
/*     */       try {
/*     */         Table table; byte b;
/* 232 */         this.e = i;
/* 233 */         if (this.b == null) {
/*     */           
/* 235 */           this.c.clearChildren();
/*     */           
/* 237 */           Table table1 = new Table();
/* 238 */           this.c.add((Actor)table1).expand().fill().padRight(340.0F);
/*     */           
/* 240 */           ResourcePack.AtlasTextureRegion atlasTextureRegion1 = Game.i.assetManager.getTextureRegion("small-circle");
/* 241 */           ResourcePack.AtlasTextureRegion atlasTextureRegion2 = Game.i.assetManager.getTextureRegion("blank");
/* 242 */           Research research = Game.i.researchManager.getResearchInstance(ResearchType.ROOT);
/*     */           
/* 244 */           float[] arrayOfFloat = { 10.0F };
/* 245 */           Actor actor = new Actor(this, arrayOfFloat, array2, (TextureRegion)atlasTextureRegion2, array1, research, (TextureRegion)atlasTextureRegion1)
/*     */             {
/*     */               public void draw(Batch param1Batch, float param1Float) {
/* 248 */                 this.j[0] = this.j[0] + Gdx.graphics.getDeltaTime();
/*     */                 
/* 250 */                 int i = Game.i.researchManager.getMapMinX();
/* 251 */                 int j = Game.i.researchManager.getMapMinY();
/* 252 */                 float f1 = 640.0F / Game.i.researchManager.getMapWidth();
/* 253 */                 float f2 = 640.0F / Game.i.researchManager.getMapHeight();
/* 254 */                 f1 = StrictMath.min(f1, f2);
/*     */                 
/* 256 */                 f2 = getX();
/* 257 */                 float f3 = getY();
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 262 */                 for (Array.ArrayIterator<Research.ResearchLink> arrayIterator = this.k.iterator(); arrayIterator.hasNext(); ) { Research.ResearchLink researchLink = arrayIterator.next();
/* 263 */                   Color color = Color.BLACK;
/* 264 */                   if (researchLink.parent.getInstalledLevel() > 0 && researchLink.child.getInstalledLevel() > 0) {
/* 265 */                     color = MaterialColor.CYAN.P900;
/*     */                   }
/*     */                   
/* 268 */                   MainMenuUiScene.a()[0] = (researchLink.parent.x - i) * f1 + f2;
/* 269 */                   MainMenuUiScene.a()[1] = (researchLink.parent.y - j) * f1 + f3;
/* 270 */                   MainMenuUiScene.a()[2] = color.toFloatBits();
/*     */                   
/* 272 */                   MainMenuUiScene.a()[3] = (researchLink.pivotX - i) * f1 + f2;
/* 273 */                   MainMenuUiScene.a()[4] = (researchLink.pivotY - j) * f1 + f3;
/* 274 */                   MainMenuUiScene.a()[5] = MainMenuUiScene.a()[2];
/*     */                   
/* 276 */                   MainMenuUiScene.a()[6] = (researchLink.child.x - i) * f1 + f2;
/* 277 */                   MainMenuUiScene.a()[7] = (researchLink.child.y - j) * f1 + f3;
/* 278 */                   MainMenuUiScene.a()[8] = MainMenuUiScene.a()[2];
/*     */                   
/* 280 */                   DrawUtils.texturedMultiLine(param1Batch, 2.0F, this.l, MainMenuUiScene.a()); }
/*     */                  byte b;
/*     */                 int k;
/* 283 */                 for (b = 0, k = this.m.size; b < k; b++) {
/*     */                   Research research;
/*     */                   
/* 286 */                   float f4 = ((research = (Research)this.m.get(b)).x - i) * f1 + f2;
/* 287 */                   float f5 = (research.y - j) * f1 + f3;
/*     */ 
/*     */                   
/* 290 */                   if (research.getInstalledLevel() > 0) {
/* 291 */                     float f = PMath.getSquareDistanceBetweenPoints(research.x, research.y, this.n.x, this.n.y);
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/* 296 */                     if ((f = 1.0F + (-this.j[0] * 0.4F + f * 1.0E-7F) % 1.0F) < 0.5F) {
/*     */                       
/* 298 */                       f = 0.0F;
/*     */                     } else {
/* 300 */                       f = (f - 0.5F) * 2.0F;
/*     */                     } 
/*     */                     
/* 303 */                     if (f < 0.85F) {
/* 304 */                       f /= 0.85F;
/*     */                     } else {
/* 306 */                       f = 1.0F - (f - 0.85F) / 0.15F;
/*     */                     } 
/* 308 */                     MainMenuUiScene.b().set(MaterialColor.CYAN.P900);
/* 309 */                     MainMenuUiScene.b().lerp(MaterialColor.CYAN.P400, f);
/*     */                     
/* 311 */                     param1Batch.setColor(MainMenuUiScene.b());
/* 312 */                     param1Batch.draw(this.o, f4 - 4.0F, f5 - 4.0F, 8.0F, 8.0F);
/*     */                   } else {
/* 314 */                     param1Batch.setColor(Color.BLACK);
/* 315 */                     param1Batch.draw(this.o, f4 - 4.0F, f5 - 4.0F, 8.0F, 8.0F);
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             };
/* 320 */           table1.add(actor).size(640.0F, 640.0F).row();
/*     */           
/* 322 */           table = new Table();
/* 323 */           b = 0; TrophyType[] arrayOfTrophyType1; int k; byte b3;
/* 324 */           for (k = (arrayOfTrophyType1 = TrophyType.values).length, b3 = 0; b3 < k; ) { TrophyType trophyType = arrayOfTrophyType1[b3];
/* 325 */             TrophyManager.TrophyConfig trophyConfig = Game.i.trophyManager.getConfig(trophyType);
/* 326 */             Image image = new Image();
/* 327 */             if (trophyConfig.isReceived()) {
/* 328 */               image.setDrawable((Drawable)new TextureRegionDrawable(trophyConfig.getIconTexture()));
/*     */             } else {
/* 330 */               image.setDrawable((Drawable)new TextureRegionDrawable(trophyConfig.getWhiteTexture()));
/* 331 */               image.setColor(Color.BLACK);
/*     */             } 
/* 333 */             table.add((Actor)image).size(48.0F).pad(4.0F);
/*     */             
/* 335 */             b++;
/* 336 */             if (b % 12 == 0) {
/* 337 */               table.row();
/*     */             }
/*     */             b3++; }
/*     */           
/* 341 */           table1.add((Actor)table).padTop(32.0F).padBottom(32.0F);
/*     */         } else {
/*     */           
/* 344 */           int k = Game.i.uiManager.getScreenWidth();
/* 345 */           j = Game.i.uiManager.getScreenHeight();
/* 346 */           if (this.b.width != k || this.b.height != j) {
/* 347 */             this.b.setSize(k, j);
/*     */           }
/*     */           
/* 350 */           if (!this.d.get()) {
/* 351 */             this.d.set(true);
/* 352 */             Game.i.assetManager.getSceneModel(paramModel -> {
/*     */                   ModelInstance modelInstance;
/*     */ 
/*     */                   
/*     */                   Node node1;
/*     */ 
/*     */                   
/*     */                   if ((node1 = (modelInstance = new ModelInstance(paramModel)).getNode("researches")) != null) {
/*     */                     byte b;
/*     */                     
/*     */                     for (b = 0; b < paramArray1.size; b++) {
/*     */                       String str = researchLink.parent.getShortName() + "-" + researchLink.child.getShortName();
/*     */                       
/*     */                       Research.ResearchLink researchLink;
/*     */                       
/*     */                       Node node;
/*     */                       
/*     */                       if (((researchLink = (Research.ResearchLink)paramArray1.get(b)).child.getInstalledLevel() == 0 || researchLink.parent.getInstalledLevel() == 0) && (node = node1.getChild(str, false, false)) != null) {
/*     */                         node.detach();
/*     */                       }
/*     */                     } 
/*     */                     
/*     */                     for (b = 0; b < paramArray2.size; b++) {
/*     */                       Research research = (Research)paramArray2.get(b);
/*     */                       
/*     */                       Node node = node1.getChild(research.type.name(), false, false);
/*     */                       
/*     */                       if (research.getInstalledLevel() == 0) {
/*     */                         if (node == null) {
/*     */                           a.e("3d scene node not exists for research " + research.type.name(), new Object[0]);
/*     */                         } else {
/*     */                           node.detach();
/*     */                         } 
/*     */                       }
/*     */                     } 
/*     */                   } 
/*     */                   
/*     */                   Node node2;
/*     */                   
/*     */                   if ((node2 = modelInstance.getNode("trophies")) != null) {
/*     */                     TrophyType[] arrayOfTrophyType;
/*     */                     
/*     */                     int i = (arrayOfTrophyType = TrophyType.values).length;
/*     */                     
/*     */                     for (byte b = 0; b < i; b++) {
/*     */                       TrophyType trophyType = arrayOfTrophyType[b];
/*     */                       
/*     */                       node2.getChild("t-" + trophyType.name(), false, false).detach();
/*     */                       
/*     */                       Node node;
/*     */                       
/*     */                       if (!Game.i.trophyManager.getConfig(trophyType).isReceived() && (node = node2.getChild("t-" + trophyType.name() + "-beam", false, false)) != null) {
/*     */                         node.detach();
/*     */                       }
/*     */                     } 
/*     */                   } 
/*     */                   
/*     */                   Threads.i().runOnMainThread(());
/*     */                 });
/*     */           } else {
/* 412 */             a.i("skipped - already rebuilding", new Object[0]);
/*     */           } 
/*     */         } 
/* 415 */       } catch (Exception exception) {
/* 416 */         this.e = i;
/* 417 */         a.e("Failed to build 3d scene", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/* 421 */     a.d("rebuildIfNeeded took " + (Game.getTimestampMillis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public final void hide() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\MainMenuUiScene.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */