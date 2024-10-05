/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Animation;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import java.lang.ref.WeakReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCell
/*     */   extends Group
/*     */ {
/*     */   public static final float WIDTH = 128.0F;
/*     */   public static final float HEIGHT = 140.0F;
/*     */   public static final float COMPACT_SIZE_COEFF = 0.75F;
/*     */   private AttentionRaysUnderlay k;
/*     */   private ParticlesCanvas l;
/*     */   private Image m;
/*     */   private Group n;
/*     */   private Image o;
/*     */   private Group p;
/*     */   private Image q;
/*     */   private Image r;
/*     */   private Label s;
/*     */   private Image t;
/*     */   private Label u;
/*     */   private Label v;
/*     */   private boolean w = false;
/*     */   private boolean x = false;
/*     */   private Item y;
/*  47 */   private int z = 0;
/*     */   private int A;
/*     */   private int B;
/*     */   private boolean C;
/*     */   private boolean D;
/*     */   private boolean E;
/*     */   private boolean F;
/*     */   private boolean G;
/*     */   private boolean H;
/*     */   private boolean I;
/*  57 */   private String J = null;
/*  58 */   private Actor K = null;
/*  59 */   private float L = 1.0F;
/*     */   
/*     */   public Group overlay;
/*     */   
/*     */   private long M;
/*     */   private WeakReference<GcListener> N;
/*  65 */   private static float[] O = new float[3];
/*  66 */   private static Color P = new Color();
/*     */   
/*     */   public ItemCell() {
/*  69 */     setTransform(false);
/*     */     
/*  71 */     setSize(128.0F, 140.0F);
/*     */     
/*  73 */     this.n = new Group();
/*  74 */     this.n.setTransform(false);
/*  75 */     this.n.setSize(128.0F, 140.0F);
/*  76 */     this.n.setOrigin(64.0F, 70.0F);
/*  77 */     addActor((Actor)this.n);
/*     */     
/*  79 */     this.overlay = new Group();
/*  80 */     this.overlay.setTransform(false);
/*  81 */     addActor((Actor)this.overlay);
/*     */   }
/*     */   
/*     */   public void act(float paramFloat) {
/*  85 */     super.act(paramFloat);
/*     */     
/*  87 */     if (this.x) {
/*  88 */       f();
/*     */     }
/*     */   }
/*     */   
/*     */   private void d() {
/*  93 */     if (this.k != null) this.k.setZIndex(0); 
/*  94 */     if (this.l != null) this.l.setZIndex(1); 
/*  95 */     if (this.m != null) this.m.setZIndex(2); 
/*  96 */     if (this.n != null) this.n.setZIndex(3); 
/*  97 */     if (this.o != null) this.o.setZIndex(4); 
/*  98 */     if (this.p != null) this.p.setZIndex(5); 
/*  99 */     if (this.q != null) this.q.setZIndex(6); 
/* 100 */     if (this.s != null) this.s.setZIndex(7); 
/* 101 */     if (this.t != null) this.t.setZIndex(8); 
/* 102 */     if (this.u != null) this.u.setZIndex(9); 
/* 103 */     if (this.v != null) this.v.setZIndex(10); 
/* 104 */     if (this.r != null) this.r.setZIndex(11); 
/* 105 */     this.overlay.setZIndex(50);
/*     */   }
/*     */   
/*     */   public void markStarred(boolean paramBoolean) {
/* 109 */     this.I = paramBoolean;
/*     */     
/* 111 */     if (this.w) {
/* 112 */       if (paramBoolean && this.y != null) {
/* 113 */         if (this.r == null) {
/* 114 */           this.r = new Image();
/* 115 */           this.n.addActor((Actor)this.r);
/* 116 */           d();
/*     */         } 
/* 118 */         float f = this.D ? 0.75F : 1.0F;
/* 119 */         this.r.setSize(128.0F * f, 140.0F * f);
/*     */         
/* 121 */         if ((this.A + this.B) % 2 == 0) {
/* 122 */           this.r.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.itemCellStarA"));
/*     */         } else {
/* 124 */           this.r.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.itemCellStarB"));
/*     */         } 
/*     */         
/* 127 */         this.r.setVisible(true); return;
/* 128 */       }  if (this.r != null) {
/* 129 */         this.r.setVisible(false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 136 */     if (!this.w) {
/* 137 */       e();
/*     */     }
/*     */     
/* 140 */     this.M = Game.getTimestampMillis();
/*     */     
/* 142 */     super.draw(paramBatch, paramFloat);
/*     */     
/*     */     GcListener gcListener;
/* 145 */     if ((gcListener = (GcListener)((this.N == null) ? null : this.N.get())) == null) {
/* 146 */       this.N = new WeakReference<>(new GcListener((byte)0));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void e() {
/* 152 */     this.w = true;
/*     */     
/* 154 */     if (this.y != null) {
/* 155 */       Item item = this.y;
/* 156 */       this.y = null;
/* 157 */       setItem(item, this.z);
/*     */     } else {
/* 159 */       setIconAndCount(this.K, this.L, this.z);
/*     */     } 
/* 161 */     if (this.J != null) setCornerText(this.J); 
/* 162 */     setNotificationBubbleEnabled(this.H);
/* 163 */     setSelected(this.F);
/* 164 */     showRays(this.G);
/* 165 */     setCovered(this.E);
/* 166 */     markStarred(this.I);
/*     */   }
/*     */   
/*     */   private void f() {
/* 170 */     this.x = false;
/* 171 */     if (!this.w)
/*     */       return; 
/* 173 */     this.w = false;
/*     */     
/* 175 */     if (getStage() != null) {
/* 176 */       if (this.k != null) this.k.remove(); 
/* 177 */       if (this.l != null) this.l.remove(); 
/* 178 */       if (this.m != null) this.m.remove(); 
/* 179 */       if (this.o != null) this.o.remove(); 
/* 180 */       if (this.p != null) this.p.remove(); 
/* 181 */       if (this.q != null) this.q.remove(); 
/* 182 */       if (this.r != null) this.r.remove(); 
/* 183 */       if (this.s != null) this.s.remove(); 
/* 184 */       if (this.t != null) this.t.remove(); 
/* 185 */       if (this.u != null) this.u.remove(); 
/* 186 */       if (this.v != null) this.v.remove();
/*     */     
/*     */     } 
/* 189 */     this.k = null;
/* 190 */     this.l = null;
/* 191 */     this.m = null;
/* 192 */     this.o = null;
/* 193 */     this.p = null;
/* 194 */     this.r = null;
/* 195 */     this.q = null;
/* 196 */     this.s = null;
/* 197 */     this.t = null;
/* 198 */     this.u = null;
/* 199 */     this.v = null;
/*     */     
/* 201 */     if (this.y != null) {
/* 202 */       this.K = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void showRays(boolean paramBoolean) {
/* 207 */     this.G = paramBoolean;
/*     */     
/* 209 */     if (this.w) {
/* 210 */       if (paramBoolean) {
/* 211 */         if (this.k == null) {
/* 212 */           this.k = new AttentionRaysUnderlay(192.0F, Color.WHITE);
/* 213 */           addActor((Actor)this.k);
/* 214 */           d();
/*     */         } 
/*     */         
/* 217 */         float f = this.D ? 0.75F : 1.0F;
/* 218 */         this.k.size = 192.0F * f;
/* 219 */         this.k.setPosition(-64.0F * f * 0.5F, -52.0F * f * 0.5F);
/* 220 */         this.k.restart();
/*     */         
/* 222 */         if (this.y != null) {
/* 223 */           this.k.setColor(Game.i.progressManager.getRarityBrightColor(this.y.getRarity()));
/*     */         }
/* 225 */         this.k.setVisible(true); return;
/* 226 */       }  if (this.k != null) {
/* 227 */         this.k.setVisible(false);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCornerText(CharSequence paramCharSequence) {
/* 233 */     this.J = paramCharSequence.toString();
/*     */     
/* 235 */     if (this.w) {
/* 236 */       if (this.t == null) {
/* 237 */         this.t = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-number-bg"));
/* 238 */         this.t.setSize(43.0F, 36.0F);
/* 239 */         this.t.setPosition(7.0F, 97.0F);
/* 240 */         this.n.addActor((Actor)this.t);
/*     */         
/* 242 */         this.u = new Label(paramCharSequence, Game.i.assetManager.getLabelStyle(21));
/* 243 */         this.u.setPosition(11.0F, 105.0F);
/* 244 */         this.u.setSize(38.0F, 18.0F);
/* 245 */         this.u.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 246 */         this.u.setAlignment(1);
/* 247 */         this.n.addActor((Actor)this.u);
/*     */         
/* 249 */         this.v = new Label(paramCharSequence, Game.i.assetManager.getLabelStyle(21));
/* 250 */         this.v.setPosition(9.0F, 107.0F);
/* 251 */         this.v.setSize(38.0F, 18.0F);
/* 252 */         this.v.setAlignment(1);
/* 253 */         this.n.addActor((Actor)this.v);
/*     */         
/* 255 */         d(); return;
/*     */       } 
/* 257 */       this.v.setText(paramCharSequence);
/* 258 */       this.u.setText(paramCharSequence);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNotificationBubbleEnabled(boolean paramBoolean) {
/* 264 */     this.H = paramBoolean;
/*     */     
/* 266 */     if (this.w) {
/* 267 */       if (paramBoolean) {
/* 268 */         if (this.q == null) {
/* 269 */           this.q = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"));
/* 270 */           this.q.setSize(32.25F, 36.75F);
/* 271 */           this.q.setPosition(98.0F, 108.0F);
/* 272 */           this.q.setVisible(false);
/* 273 */           this.n.addActor((Actor)this.q);
/* 274 */           d();
/*     */         } 
/*     */         
/* 277 */         this.q.setVisible(true); return;
/* 278 */       }  if (this.q != null) {
/* 279 */         this.q.setVisible(false);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setNoRarityBackground(boolean paramBoolean) {
/* 285 */     this.C = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setCompact() {
/* 289 */     setSize(96.0F, 105.0F);
/* 290 */     this.n.setSize(96.0F, 105.0F);
/*     */     
/* 292 */     if (this.w && !this.D) {
/* 293 */       this.D = true;
/* 294 */       f();
/* 295 */       e(); return;
/*     */     } 
/* 297 */     this.D = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSelected() {
/* 302 */     return this.F;
/*     */   }
/*     */   
/*     */   public void setSelected(boolean paramBoolean) {
/* 306 */     this.F = paramBoolean;
/*     */     
/* 308 */     if (this.w) {
/* 309 */       if (paramBoolean) {
/* 310 */         if (this.m == null) {
/* 311 */           this.m = new Image();
/* 312 */           addActor((Actor)this.m);
/* 313 */           d();
/*     */         } 
/*     */         
/* 316 */         float f = this.D ? 0.75F : 1.0F;
/* 317 */         this.m.setSize(138.24F * f, 151.20001F * f);
/* 318 */         this.m.setPosition(-5.12F * f, -5.6F * f);
/*     */         
/* 320 */         if ((this.A + this.B) % 2 == 0) {
/* 321 */           this.m.setDrawable((Drawable)Game.i.assetManager.getDrawable("item-cell-a-shape"));
/*     */         } else {
/* 323 */           this.m.setDrawable((Drawable)Game.i.assetManager.getDrawable("item-cell-b-shape"));
/*     */         } 
/*     */         
/* 326 */         this.m.setVisible(true); return;
/*     */       } 
/* 328 */       if (this.m != null) this.m.setVisible(false);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void g() {
/* 334 */     if (!this.w) {
/* 335 */       throw new IllegalStateException("Actor not set up yet");
/*     */     }
/*     */     
/* 338 */     if (this.o == null) {
/* 339 */       this.o = new Image();
/* 340 */       this.n.addActor((Actor)this.o);
/* 341 */       d();
/*     */     } 
/*     */     
/* 344 */     float f = this.D ? 0.75F : 1.0F;
/* 345 */     this.o.setSize(128.0F * f, 140.0F * f);
/*     */     
/* 347 */     if (this.y == null || this.C) {
/*     */       
/* 349 */       this.o.setDrawable(Game.i.uiManager.itemCellShapes[(this.A + this.B) % 2]);
/* 350 */       this.o.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*     */     } else {
/* 352 */       RarityType rarityType = this.y.getRarity();
/* 353 */       if (this.E) {
/* 354 */         this.o.setDrawable(Game.i.uiManager.getItemCellRarityCoat(rarityType, (this.A + this.B) % 2));
/* 355 */         this.o.setColor(Color.WHITE);
/*     */       } else {
/* 357 */         if ((this.A + this.B) % 2 == 0) {
/* 358 */           this.o.setDrawable((Drawable)Game.i.assetManager.getDrawable("item-cell-a"));
/*     */         } else {
/* 360 */           this.o.setDrawable((Drawable)Game.i.assetManager.getDrawable("item-cell-b"));
/*     */         } 
/*     */         
/* 363 */         this.o.setColor(Game.i.progressManager.getRarityColor(rarityType));
/*     */         
/* 365 */         if (this.t != null) {
/* 366 */           this.t.setColor(Game.i.progressManager.getRarityColor(rarityType));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 371 */     markStarred(this.I);
/*     */     
/* 373 */     this.overlay.setZIndex(500);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColRow(int paramInt1, int paramInt2) {
/* 381 */     this.A = paramInt1;
/* 382 */     this.B = paramInt2;
/*     */     
/* 384 */     if (this.w) {
/* 385 */       g();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setCovered(boolean paramBoolean) {
/* 390 */     this.E = paramBoolean;
/*     */     
/* 392 */     if (this.w) {
/* 393 */       g();
/* 394 */       setIconAndCount(this.K, this.L, this.z);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void reveal() {
/* 399 */     if (!this.w) {
/* 400 */       e();
/*     */     }
/*     */     
/* 403 */     if (!this.E) setCovered(true);
/*     */     
/* 405 */     this.n.setTransform(true);
/* 406 */     this.n.addAction((Action)Actions.sequence(
/* 407 */           (Action)Actions.delay(0.1F), 
/* 408 */           (Action)Actions.scaleTo(0.0F, 1.0F, 0.25F, Interpolation.sine), 
/* 409 */           (Action)Actions.parallel(
/* 410 */             (Action)Actions.scaleTo(1.1F, 1.1F, 0.25F, Interpolation.sine), 
/* 411 */             (Action)Actions.run(() -> {
/*     */                 setCovered(false);
/*     */                 
/*     */                 Game.i.soundManager.playRarity(this.y.getRarity());
/*     */                 
/*     */                 shine(true, true);
/* 417 */               })), (Action)Actions.scaleTo(1.0F, 1.0F, 0.1F, (Interpolation)Interpolation.exp5In), 
/* 418 */           (Action)Actions.run(() -> this.n.setTransform(false))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shine(boolean paramBoolean1, boolean paramBoolean2) {
/* 426 */     if (this.y == null)
/* 427 */       return;  if (!this.w) {
/* 428 */       e();
/*     */     }
/*     */     
/* 431 */     RarityType rarityType = this.y.getRarity();
/*     */     
/* 433 */     float f = this.D ? 0.75F : 1.0F;
/* 434 */     Color color = Game.i.progressManager.getRarityBrightColor(rarityType);
/*     */     
/* 436 */     if (paramBoolean1) {
/*     */       
/* 438 */       if (this.l == null) {
/* 439 */         float f3 = this.D ? 0.75F : 1.0F;
/* 440 */         this.l = new ParticlesCanvas();
/* 441 */         this.l.setSize(128.0F * f3, 140.0F * f3);
/* 442 */         this.l.setPosition(0.0F, 0.0F);
/* 443 */         addActor(this.l);
/* 444 */         d();
/*     */       } 
/*     */       
/* 447 */       this.l.clearParticles();
/* 448 */       ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.uiManager.itemCellFlashParticles.obtain();
/*     */       
/* 450 */       O[0] = color.r;
/* 451 */       O[1] = color.g;
/* 452 */       O[2] = color.b;
/* 453 */       for (Array.ArrayIterator<ParticleEmitter> arrayIterator = pooledEffect.getEmitters().iterator(); arrayIterator.hasNext(); ) {
/* 454 */         ParticleEmitter particleEmitter; (particleEmitter = arrayIterator.next()).getTint().setColors(O);
/* 455 */         particleEmitter.setMinParticleCount(8 + 8 * rarityType.ordinal());
/* 456 */         particleEmitter.setMaxParticleCount(8 + 8 * rarityType.ordinal());
/* 457 */         particleEmitter.getLife().setHigh(1200.0F + rarityType.ordinal() * 500.0F);
/* 458 */         particleEmitter.getVelocity().setHigh(100.0F + rarityType.ordinal() * 10.0F, 400.0F + rarityType.ordinal() * 40.0F);
/*     */       } 
/*     */       
/* 461 */       float f1 = 64.0F * f;
/* 462 */       float f2 = 70.0F * f;
/* 463 */       this.l.addParticle((ParticleEffect)pooledEffect, f1, f2);
/*     */     } 
/*     */ 
/*     */     
/* 467 */     if (paramBoolean2) {
/*     */       Image image;
/* 469 */       if ((this.A + this.B) % 2 == 0) {
/* 470 */         image = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-a-shape"));
/*     */       } else {
/* 472 */         image = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-b-shape"));
/*     */       } 
/* 474 */       image.setColor(color);
/* 475 */       image.setSize(128.0F * f, 140.0F * f);
/* 476 */       image.addAction((Action)Actions.sequence(
/* 477 */             (Action)Actions.delay(0.15F + rarityType.ordinal() * 0.02F), 
/* 478 */             (Action)Actions.parallel(
/* 479 */               (Action)Actions.run(() -> {
/*     */                   AnimatedImage animatedImage = new AnimatedImage(new Animation(0.01665F, Game.i.assetManager.getTextureRegions("item-cell-glow")));
/*     */ 
/*     */                   
/*     */                   P.set(paramColor).lerp(Color.WHITE, 0.5F);
/*     */                   
/*     */                   animatedImage.setColor(P);
/*     */                   
/*     */                   animatedImage.setSize(128.0F * paramFloat, 140.0F * paramFloat);
/*     */                   
/*     */                   addActor((Actor)animatedImage);
/*     */                   
/*     */                   animatedImage.addAction((Action)Actions.sequence((Action)Actions.delay(1.0F), (Action)Actions.removeActor()));
/* 492 */                 }), (Action)Actions.sequence(
/* 493 */                 (Action)Actions.fadeOut(0.4F + rarityType.ordinal() * 0.05F), 
/* 494 */                 (Action)Actions.removeActor()))));
/*     */ 
/*     */ 
/*     */       
/* 498 */       this.n.addActor((Actor)image);
/*     */       return;
/*     */     } 
/* 501 */     AnimatedImage animatedImage = new AnimatedImage(new Animation(0.01665F, Game.i.assetManager.getTextureRegions("item-cell-glow")));
/* 502 */     P.set(color).lerp(Color.WHITE, 0.5F);
/* 503 */     animatedImage.setColor(P);
/* 504 */     animatedImage.setSize(128.0F * f, 140.0F * f);
/* 505 */     addActor((Actor)animatedImage);
/*     */     
/* 507 */     animatedImage.addAction((Action)Actions.sequence(
/* 508 */           (Action)Actions.delay(1.0F), 
/* 509 */           (Action)Actions.removeActor()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIconAndCount(Actor paramActor, float paramFloat, int paramInt) {
/* 515 */     this.K = paramActor;
/* 516 */     this.L = paramFloat;
/*     */     
/* 518 */     if (this.w) {
/* 519 */       if (this.p == null) {
/* 520 */         this.p = new Group();
/* 521 */         this.p.setTransform(false);
/* 522 */         this.n.addActor((Actor)this.p);
/* 523 */         d();
/*     */       } 
/*     */       
/* 526 */       float f = this.D ? 0.75F : 1.0F;
/* 527 */       this.p.setSize(80.0F * f, 80.0F * f);
/* 528 */       this.p.setPosition(24.0F * f, 46.0F * f);
/*     */       
/* 530 */       f = -(paramFloat - 1.0F) * this.p.getWidth() * 0.5F;
/* 531 */       this.p.clearChildren();
/*     */       
/* 533 */       if (paramActor != null) {
/* 534 */         paramActor.setSize(this.p.getWidth() * paramFloat, this.p.getHeight() * paramFloat);
/* 535 */         this.p.addActor(paramActor);
/*     */       } 
/*     */       
/* 538 */       if (this.D) {
/* 539 */         if (paramInt > 0) {
/* 540 */           this.p.setPosition(f + 18.0F, f + 35.0F);
/*     */         } else {
/* 542 */           this.p.setPosition(f + 18.0F, f + 23.0F);
/*     */         }
/*     */       
/* 545 */       } else if (paramInt > 0) {
/* 546 */         this.p.setPosition(f + 24.0F, f + 46.0F);
/*     */       } else {
/* 548 */         this.p.setPosition(f + 24.0F, f + 30.0F);
/*     */       } 
/*     */ 
/*     */       
/* 552 */       this.p.setVisible(!this.E);
/* 553 */       if (this.t != null) {
/* 554 */         this.t.setVisible(!this.E);
/* 555 */         this.v.setVisible(!this.E);
/* 556 */         this.u.setVisible(!this.E);
/*     */       } 
/*     */     } 
/*     */     
/* 560 */     setCount(paramInt);
/*     */   }
/*     */   
/*     */   public void setItemStack(ItemStack paramItemStack) {
/* 564 */     setItem(paramItemStack.getItem(), paramItemStack.getCount());
/*     */   }
/*     */   
/*     */   public void setItem(Item paramItem, int paramInt) {
/* 568 */     if (this.w) {
/* 569 */       if (this.y != paramItem) {
/* 570 */         if (paramItem == null) {
/* 571 */           setIconAndCount((Actor)null, 1.0F, 0);
/*     */         } else {
/* 573 */           float f = this.D ? 0.75F : 1.0F;
/*     */           
/* 575 */           Actor actor = paramItem.generateIcon(80.0F * f, false);
/* 576 */           if (!paramItem.isCountable()) paramInt = 0;
/*     */           
/* 578 */           setIconAndCount(actor, 1.0F, paramInt);
/*     */         } 
/* 580 */         this.y = paramItem;
/* 581 */         g(); return;
/*     */       } 
/*     */     } else {
/* 584 */       this.y = paramItem;
/* 585 */       setCount(paramInt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Item getItem() {
/* 590 */     return this.y;
/*     */   }
/*     */   
/*     */   public void setCount(int paramInt) {
/* 594 */     this.z = paramInt;
/*     */     
/* 596 */     if (this.w) {
/* 597 */       if (this.s == null) {
/* 598 */         this.s = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 599 */         this.s.setAlignment(1);
/* 600 */         this.n.addActor((Actor)this.s);
/* 601 */         d();
/*     */       } 
/*     */       
/* 604 */       float f = this.D ? 0.75F : 1.0F;
/* 605 */       this.s.setPosition(0.0F, 16.0F * f);
/* 606 */       this.s.setSize(128.0F * f, 18.0F * f);
/*     */       
/* 608 */       if (paramInt > 0) {
/* 609 */         this.s.setVisible(!this.E);
/* 610 */         if (paramInt < 10000000) {
/* 611 */           this.s.setText((CharSequence)StringFormatter.commaSeparatedNumber(paramInt)); return;
/*     */         } 
/* 613 */         this.s.setText((CharSequence)StringFormatter.compactNumber(paramInt, false));
/*     */         return;
/*     */       } 
/* 616 */       this.s.setVisible(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCount() {
/* 622 */     return this.z;
/*     */   }
/*     */   
/*     */   private class GcListener { private GcListener(ItemCell this$0) {}
/*     */     
/*     */     public void finalize() {
/* 628 */       if (ItemCell.a(this.a)) {
/*     */         long l;
/* 630 */         if ((l = Game.getTimestampMillis() - ItemCell.b(this.a)) >= 700L)
/*     */         {
/* 632 */           ItemCell.a(this.a, true);
/*     */         }
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
/* 644 */         ItemCell.a(this.a, (WeakReference)null);
/*     */       } 
/*     */       
/* 647 */       super.finalize();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ItemCell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */