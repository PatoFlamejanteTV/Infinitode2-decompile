/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Align;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.IssuedItemsAdd;
/*     */ import com.prineside.tdi2.events.global.ScreenResize;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ import com.prineside.tdi2.utils.PooledCustomEffect;
/*     */ 
/*     */ public class FlyingItemsOverlay
/*     */   implements Disposable
/*     */ {
/*  34 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 90, "FlyingItemsOverlay papers", true);
/*  35 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 91, "FlyingItemsOverlay elements", true);
/*     */   
/*     */   private Group c;
/*     */   
/*     */   private Group d;
/*     */   
/*  41 */   private int e = 0;
/*     */   
/*     */   private final GameSystemProvider f;
/*     */   
/*  45 */   private final Pool<Paper> g = new Pool<Paper>(this, 1, 512)
/*     */     {
/*     */       private FlyingItemsOverlay.Paper a() {
/*     */         FlyingItemsOverlay.Paper paper;
/*  49 */         (paper = new FlyingItemsOverlay.Paper()).pool = this;
/*  50 */         paper.start();
/*  51 */         return paper;
/*     */       }
/*     */     };
/*     */   
/*     */   private final Listener<ScreenResize> h = paramScreenResize -> {
/*     */       this.c.setSize(Game.i.uiManager.viewport.getWorldWidth(), Game.i.uiManager.viewport.getWorldHeight());
/*     */       this.d.setSize(Game.i.uiManager.viewport.getWorldWidth(), Game.i.uiManager.viewport.getWorldHeight());
/*     */     };
/*     */   
/*     */   public FlyingItemsOverlay(GameSystemProvider paramGameSystemProvider) {
/*  61 */     this.f = paramGameSystemProvider;
/*     */     
/*  63 */     this.a.getTable().setTouchable(Touchable.disabled);
/*  64 */     this.b.getTable().setTouchable(Touchable.disabled);
/*     */     
/*  66 */     this.d = new Group();
/*  67 */     this.d.setTransform(false);
/*  68 */     this.d.setTouchable(Touchable.disabled);
/*  69 */     this.a.getTable().add((Actor)this.d).expand().fill();
/*     */     
/*  71 */     this.c = new Group();
/*  72 */     this.c.setTransform(false);
/*  73 */     this.c.setTouchable(Touchable.disabled);
/*  74 */     this.b.getTable().add((Actor)this.c).expand().fill();
/*     */     
/*  76 */     Game.EVENTS.getListeners(ScreenResize.class).add(this.h);
/*  77 */     paramGameSystemProvider.events.getListeners(IssuedItemsAdd.class).add(this::a).setDescription("FlyingItemsOverlay - draws issued items and plays a sound");
/*     */   }
/*     */   
/*     */   private void a(IssuedItemsAdd paramIssuedItemsAdd) {
/*  81 */     if (this.f.gameState.isFastForwarding() || Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.LOOT_ICONS_ENABLED) == 0.0D)
/*     */       return; 
/*  83 */     if (paramIssuedItemsAdd.getFlyAlign() < 0)
/*     */       return; 
/*  85 */     ItemStack itemStack = paramIssuedItemsAdd.getItemStack();
/*  86 */     float f1 = paramIssuedItemsAdd.getStageX();
/*  87 */     float f2 = paramIssuedItemsAdd.getStageY();
/*  88 */     int i = paramIssuedItemsAdd.getFlyAlign();
/*     */     
/*  90 */     if (itemStack.getItem().getType() == ItemType.GREEN_PAPER) {
/*  91 */       addPapers(f1, f2, itemStack.getCount()); return;
/*     */     } 
/*     */     ItemCell itemCell;
/*  94 */     (itemCell = new ItemCell()).setSize(96.0F, 105.0F);
/*  95 */     itemCell.setItemStack(itemStack);
/*  96 */     itemCell.setColRow(this.e++, 0);
/*     */     
/*  98 */     itemCell.setCovered(itemStack.covered);
/*  99 */     itemCell.shine(true, true);
/*     */     
/* 101 */     this.f._sound.playStaticParameterized(Game.i.soundManager.getRarity(itemStack.getItem().getRarity()), 0.75F, 1.0F, 0.0F);
/*     */     
/* 103 */     float f3 = 1.0F + (itemStack.getItem().getRarity().ordinal() * itemStack.getItem().getRarity().ordinal()) * 0.05F;
/* 104 */     add(f1, f2, (Actor)itemCell, itemStack.getCount(), i, 0.8F, f3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPapers(float paramFloat1, float paramFloat2, int paramInt) {
/* 109 */     if (paramInt > 1000) paramInt = 1000; 
/* 110 */     int i = 0;
/* 111 */     while (paramInt != 0) {
/*     */       byte b;
/* 113 */       if (paramInt >= 100) {
/* 114 */         b = 100;
/* 115 */       } else if (paramInt >= 20) {
/* 116 */         b = 20;
/* 117 */       } else if (paramInt >= 5) {
/* 118 */         b = 5;
/*     */       } else {
/* 120 */         b = 1;
/*     */       } 
/* 122 */       paramInt -= b;
/*     */       
/*     */       Paper paper;
/* 125 */       (paper = (Paper)this.g.obtain()).setup(b);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       this.f._gameUi.mainUi.particlesCanvas.addParticle(paper, paramFloat1, paramFloat2 + i);
/* 134 */       i = (int)(i + 3.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(float paramFloat1, float paramFloat2, Actor paramActor, int paramInt1, int paramInt2, float paramFloat3, float paramFloat4) {
/* 142 */     if (paramFloat1 > 0.0F && paramFloat1 < this.c.getWidth()) {
/* 143 */       paramActor.setPosition(paramFloat1 - paramActor.getWidth() * 0.5F, paramFloat2 - paramActor.getHeight() * 0.5F);
/* 144 */       paramActor.setOrigin(paramActor.getWidth() * 0.5F, paramActor.getHeight() * 0.5F);
/* 145 */       this.c.addActor(paramActor);
/*     */       
/* 147 */       if (paramActor instanceof Group) ((Group)paramActor).setTransform(true);
/*     */       
/* 149 */       paramFloat1 = 0.0F;
/* 150 */       paramFloat2 = 0.0F;
/* 151 */       if (Align.isLeft(paramInt2)) {
/* 152 */         paramFloat1 = -1.0F;
/* 153 */       } else if (Align.isRight(paramInt2)) {
/* 154 */         paramFloat1 = 1.0F;
/*     */       } 
/* 156 */       if (Align.isBottom(paramInt2)) {
/* 157 */         paramFloat2 = -1.0F;
/* 158 */       } else if (Align.isTop(paramInt2)) {
/* 159 */         paramFloat2 = 1.0F;
/*     */       } 
/*     */       
/* 162 */       paramActor.addAction((Action)Actions.sequence(
/* 163 */             (Action)Actions.scaleTo(0.5F * paramFloat3, 0.5F * paramFloat3), 
/* 164 */             (Action)Actions.parallel(
/* 165 */               (Action)Actions.sequence(
/* 166 */                 (Action)Actions.parallel(
/* 167 */                   (Action)Actions.sequence(
/* 168 */                     (Action)Actions.delay(0.1F), 
/* 169 */                     (Action)Actions.scaleBy(paramFloat3 * 0.5F, 0.0F, 0.3F, (Interpolation)Interpolation.swingOut)), 
/*     */                   
/* 171 */                   (Action)Actions.scaleBy(0.0F, paramFloat3 * 0.5F, 0.3F, (Interpolation)Interpolation.swingOut)), 
/*     */ 
/*     */                 
/* 174 */                 (Action)Actions.delay(paramFloat4 * 1.0F), 
/* 175 */                 (Action)Actions.parallel(
/* 176 */                   (Action)Actions.alpha(0.0F, 0.5F, (Interpolation)Interpolation.exp5In), 
/* 177 */                   (Action)Actions.moveBy(0.0F, 384.0F, 0.6F, (Interpolation)Interpolation.exp5In), 
/* 178 */                   (Action)Actions.sequence(
/* 179 */                     (Action)Actions.delay(0.1F), 
/* 180 */                     (Action)Actions.parallel(
/* 181 */                       (Action)Actions.scaleBy(-paramFloat3, 0.0F, 0.5F, (Interpolation)Interpolation.exp5Out), 
/* 182 */                       (Action)Actions.sequence(
/* 183 */                         (Action)Actions.delay(0.1F), 
/* 184 */                         (Action)Actions.scaleBy(0.0F, paramFloat3, 0.5F, (Interpolation)Interpolation.exp5Out))))), 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 189 */                 (Action)Actions.removeActor()), 
/*     */               
/* 191 */               (Action)Actions.moveBy(128.0F * paramFloat1, 128.0F * paramFloat2, 1.5F, Interpolation.circleOut))));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 201 */     Game.EVENTS.getListeners(ScreenResize.class).remove(this.h);
/*     */     
/* 203 */     Game.i.uiManager.removeLayer(this.b);
/* 204 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */   
/*     */   public static class Paper
/*     */     extends ParticleEffect
/*     */     implements PooledCustomEffect
/*     */   {
/*     */     public Pool<Paper> pool;
/* 212 */     private Vector2 a = new Vector2();
/* 213 */     private Vector2 b = new Vector2();
/*     */     
/*     */     private float c;
/*     */     
/*     */     private float d;
/*     */     private float e;
/*     */     private float f;
/*     */     private float g;
/*     */     private float h;
/* 222 */     private int i = -1;
/* 223 */     private TextureRegion j = (TextureRegion)(AssetManager.TextureRegions.i()).flyingPaper1_1;
/* 224 */     private TextureRegion[] k = new TextureRegion[4];
/*     */ 
/*     */     
/*     */     private float l;
/*     */     
/*     */     private float m;
/*     */ 
/*     */     
/*     */     public void setup(int param1Int) {
/* 233 */       this.l = 2.0F + FastRandom.getFloat() * 0.8F;
/* 234 */       AssetManager.TextureRegions textureRegions = AssetManager.TextureRegions.i();
/* 235 */       if (param1Int != this.i) {
/* 236 */         switch (param1Int) {
/*     */           case 100:
/* 238 */             this.k[0] = (TextureRegion)textureRegions.flyingPaper100_1;
/* 239 */             this.k[1] = (TextureRegion)textureRegions.flyingPaper1_2;
/* 240 */             this.k[2] = (TextureRegion)textureRegions.flyingPaper1_3;
/* 241 */             this.k[3] = (TextureRegion)textureRegions.flyingPaper1_4;
/*     */             break;
/*     */           
/*     */           case 20:
/* 245 */             this.k[0] = (TextureRegion)textureRegions.flyingPaper20_1;
/* 246 */             this.k[1] = (TextureRegion)textureRegions.flyingPaper1_2;
/* 247 */             this.k[2] = (TextureRegion)textureRegions.flyingPaper1_3;
/* 248 */             this.k[3] = (TextureRegion)textureRegions.flyingPaper1_4;
/* 249 */             this.l *= 0.85F;
/*     */             break;
/*     */           
/*     */           case 5:
/* 253 */             this.k[0] = (TextureRegion)textureRegions.flyingPaper5_1;
/* 254 */             this.k[1] = (TextureRegion)textureRegions.flyingPaper1_2;
/* 255 */             this.k[2] = (TextureRegion)textureRegions.flyingPaper1_3;
/* 256 */             this.k[3] = (TextureRegion)textureRegions.flyingPaper1_4;
/* 257 */             this.l *= 0.6F;
/*     */             break;
/*     */           
/*     */           default:
/* 261 */             this.k[0] = (TextureRegion)textureRegions.flyingPaper1_1;
/* 262 */             this.k[1] = (TextureRegion)textureRegions.flyingPaper1_2;
/* 263 */             this.k[2] = (TextureRegion)textureRegions.flyingPaper1_3;
/* 264 */             this.k[3] = (TextureRegion)textureRegions.flyingPaper1_4;
/* 265 */             this.l *= 0.5F;
/*     */             break;
/*     */         } 
/* 268 */         this.i = param1Int;
/*     */       } 
/*     */       
/* 271 */       this.m = 0.0F;
/* 272 */       this.d = FastRandom.getFloat() * 2.0F - 1.0F;
/* 273 */       this.e = 110.0F + FastRandom.getFloat() * 150.0F;
/*     */     }
/*     */ 
/*     */     
/*     */     public void start() {}
/*     */ 
/*     */     
/*     */     public void reset() {
/* 281 */       this.a.setZero();
/* 282 */       this.b.setZero();
/* 283 */       this.c = 0.0F;
/* 284 */       this.e = 0.0F;
/* 285 */       this.f = 0.0F;
/* 286 */       this.g = 0.0F;
/* 287 */       this.h = 0.0F;
/*     */     }
/*     */     
/*     */     public void update(float param1Float) {
/* 291 */       float f1 = this.m * 2.0F;
/* 292 */       float f2 = this.m * 3.0F;
/* 293 */       if (f1 > 1.0F) f1 = 1.0F; 
/* 294 */       if (f2 > 1.0F) f2 = 1.0F; 
/* 295 */       this.f = Interpolation.swingOut.apply(f1);
/* 296 */       this.g = Interpolation.swingOut.apply(f2);
/*     */       
/* 298 */       this.e -= 180.0F * param1Float;
/* 299 */       if (this.e < -180.0F) this.e = -180.0F;
/*     */       
/* 301 */       f1 = (float)Math.sin((this.l * 2.0F + this.d * 3.1415927F));
/*     */ 
/*     */       
/* 304 */       if ((f2 = 1.0F + this.m) > 1.5F) {
/* 305 */         f2 = 1.5F;
/*     */       }
/* 307 */       f2 += this.d * 0.1F;
/* 308 */       this.c = f1 * 60.0F * f2;
/*     */       
/* 310 */       this.b.x += this.c * param1Float;
/* 311 */       this.b.x += this.d * param1Float * 50.0F;
/* 312 */       this.b.y += this.e * param1Float;
/*     */       
/* 314 */       this.h = f1 * 12.0F * f2;
/*     */       
/* 316 */       if (this.l > 0.15F) {
/* 317 */         this.j = this.k[0];
/* 318 */       } else if (this.l > 0.1F) {
/* 319 */         this.j = this.k[1];
/* 320 */       } else if (this.l > 0.05F) {
/* 321 */         this.j = this.k[2];
/*     */       } else {
/* 323 */         this.j = this.k[3];
/*     */       } 
/*     */       
/* 326 */       this.l -= param1Float;
/* 327 */       this.m += param1Float;
/*     */     }
/*     */ 
/*     */     
/*     */     @IgnoreMethodOverloadLuaDefWarning
/*     */     public void draw(Batch param1Batch) {
/* 333 */       param1Batch.draw(this.j, this.a.x - 32.0F + this.b.x, this.a.y - 16.0F + this.b.y, 32.0F, 16.0F, 64.0F, 32.0F, this.f, this.g, this.h);
/*     */     }
/*     */ 
/*     */     
/*     */     @IgnoreMethodOverloadLuaDefWarning
/*     */     public void draw(Batch param1Batch, float param1Float) {
/* 339 */       update(param1Float);
/* 340 */       draw(param1Batch);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allowCompletion() {}
/*     */ 
/*     */     
/*     */     public boolean isComplete() {
/* 348 */       return (this.l <= 0.0F);
/*     */     }
/*     */     
/*     */     public void setPosition(float param1Float1, float param1Float2) {
/* 352 */       this.a.set(param1Float1, param1Float2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void free() {
/* 357 */       this.pool.free(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\FlyingItemsOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */