/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Widget;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HighlightActor
/*     */   extends Widget
/*     */ {
/*     */   private TextureRegion j;
/*     */   private TextureRegion k;
/*     */   private TextureRegion l;
/*     */   private TextureRegion m;
/*     */   private TextureRegion n;
/*     */   private TextureRegion o;
/*  25 */   private static final Vector2 v = new Vector2(); private TextureRegion p; private TextureRegion q; private TextureRegion r; private long s; private float t; private Actor u;
/*     */   
/*     */   public HighlightActor(Actor paramActor) {
/*  28 */     this.u = paramActor;
/*     */     
/*  30 */     this.j = (TextureRegion)Game.i.assetManager.getTextureRegion("blank");
/*  31 */     this.k = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-corner-bottom-left");
/*  32 */     this.l = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-corner-bottom-right");
/*  33 */     this.m = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-corner-top-right");
/*  34 */     this.n = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-corner-top-left");
/*  35 */     this.q = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-top");
/*  36 */     this.o = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-left");
/*  37 */     this.p = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-right");
/*  38 */     this.r = (TextureRegion)Game.i.assetManager.getTextureRegion("gradient-bottom");
/*  39 */     this.s = Game.getRealTickCount();
/*     */     
/*  41 */     setColor(new Color(1338242986));
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  45 */     validate();
/*     */ 
/*     */     
/*  48 */     boolean bool = true;
/*  49 */     Actor actor = this.u;
/*  50 */     while (actor != null) {
/*  51 */       if (!actor.isVisible()) {
/*  52 */         bool = false;
/*     */         break;
/*     */       } 
/*  55 */       if (actor.hasParent()) {
/*  56 */         Group group = actor.getParent(); continue;
/*     */       } 
/*  58 */       actor = null;
/*     */     } 
/*     */ 
/*     */     
/*  62 */     if (bool) {
/*  63 */       v.setZero();
/*  64 */       this.u.localToStageCoordinates(v);
/*     */       
/*  66 */       float f1 = v.x;
/*  67 */       float f2 = v.y;
/*  68 */       float f3 = this.u.getWidth();
/*  69 */       float f4 = this.u.getHeight();
/*     */       
/*  71 */       this.t += (float)(Game.getRealTickCount() - this.s) / 1000000.0F;
/*  72 */       this.s = Game.getRealTickCount();
/*     */       
/*  74 */       float f5 = Interpolation.sineOut.apply(this.t * 3.0F % 3.0F / 3.0F);
/*  75 */       float f6 = 1.0F - f5;
/*     */ 
/*     */       
/*  78 */       Color color = getColor();
/*     */ 
/*     */       
/*  81 */       paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.28F * color.a * paramFloat);
/*     */       
/*  83 */       paramBatch.draw(this.p, f1 - 256.0F - 4.0F, f2 - 4.0F, 256.0F, f4 + 8.0F);
/*  84 */       paramBatch.draw(this.o, f1 + f3 + 4.0F, f2 - 4.0F, 256.0F, f4 + 8.0F);
/*  85 */       paramBatch.draw(this.q, f1 - 4.0F, f2 - 256.0F - 4.0F, f3 + 8.0F, 256.0F);
/*  86 */       paramBatch.draw(this.r, f1 - 4.0F, f2 + f4 + 4.0F, f3 + 8.0F, 256.0F);
/*  87 */       paramBatch.draw(this.n, f1 - 256.0F - 4.0F, f2 + f4 + 4.0F, 256.0F, 256.0F);
/*  88 */       paramBatch.draw(this.m, f1 + f3 + 4.0F, f2 + f4 + 4.0F, 256.0F, 256.0F);
/*  89 */       paramBatch.draw(this.k, f1 - 256.0F - 4.0F, f2 - 256.0F - 4.0F, 256.0F, 256.0F);
/*  90 */       paramBatch.draw(this.l, f1 + f3 + 4.0F, f2 - 256.0F - 4.0F, 256.0F, 256.0F);
/*     */ 
/*     */       
/*  93 */       paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat * 0.5F * f6);
/*  94 */       f6 = 18.0F * f5;
/*  95 */       paramBatch.draw(this.j, f1 - f6 - 4.0F, f2 - 4.0F, f6, f4 + 8.0F);
/*  96 */       paramBatch.draw(this.j, f1 + f3 + 4.0F, f2 - 4.0F, f6, f4 + 8.0F);
/*  97 */       paramBatch.draw(this.j, f1 - f6 - 4.0F, f2 - f6 - 4.0F, f3 + f6 * 2.0F + 8.0F, f6);
/*  98 */       paramBatch.draw(this.j, f1 - f6 - 4.0F, f2 + f4 + 4.0F, f3 + f6 * 2.0F + 8.0F, f6);
/*     */       
/* 100 */       f6 = 40.0F * f5;
/* 101 */       paramBatch.draw(this.j, f1 - f6 - 4.0F, f2 - 4.0F, f6, f4 + 8.0F);
/* 102 */       paramBatch.draw(this.j, f1 + f3 + 4.0F, f2 - 4.0F, f6, f4 + 8.0F);
/* 103 */       paramBatch.draw(this.j, f1 - f6 - 4.0F, f2 - f6 - 4.0F, f3 + f6 * 2.0F + 8.0F, f6);
/* 104 */       paramBatch.draw(this.j, f1 - f6 - 4.0F, f2 + f4 + 4.0F, f3 + f6 * 2.0F + 8.0F, f6);
/*     */ 
/*     */ 
/*     */       
/* 108 */       paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/* 109 */       paramBatch.draw(this.j, f1 - 4.0F - 4.0F, f2 - 4.0F, 4.0F, f4 + 8.0F);
/* 110 */       paramBatch.draw(this.j, f1 + f3 + 4.0F, f2 - 4.0F, 4.0F, f4 + 8.0F);
/* 111 */       paramBatch.draw(this.j, f1 - 4.0F - 4.0F, f2 - 4.0F - 4.0F, f3 + 8.0F + 8.0F, 4.0F);
/* 112 */       paramBatch.draw(this.j, f1 - 4.0F - 4.0F, f2 + f4 + 4.0F, f3 + 8.0F + 8.0F, 4.0F);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\HighlightActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */