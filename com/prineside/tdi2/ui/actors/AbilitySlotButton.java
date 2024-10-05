/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class AbilitySlotButton extends Group {
/*     */   private Image k;
/*     */   private Image l;
/*     */   private Image m;
/*  24 */   private Image[] q = new Image[5]; private RadialSprite n; private Image o;
/*     */   private Label p;
/*     */   private AbilityType r;
/*     */   private int s;
/*     */   private int t;
/*  29 */   private float u = 10.0F;
/*     */   
/*     */   private boolean v;
/*     */   
/*     */   private boolean w;
/*     */   private GameValueProvider x;
/*     */   
/*     */   public AbilitySlotButton(boolean paramBoolean, GameValueProvider paramGameValueProvider) {
/*  37 */     this.v = paramBoolean;
/*  38 */     this.x = paramGameValueProvider;
/*     */     
/*  40 */     setTransform(false);
/*  41 */     setSize(106.0F, 115.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     addListener((EventListener)new InputListener(this)
/*     */         {
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  54 */             if (param1Int == -1) {
/*  55 */               AbilitySlotButton.a(this.a, true);
/*  56 */               this.a.update();
/*     */             } 
/*     */             
/*  59 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  64 */             if (param1Int == -1) {
/*  65 */               AbilitySlotButton.a(this.a, false);
/*  66 */               this.a.update();
/*     */             } 
/*     */             
/*  69 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */     
/*  73 */     this.k = new Image();
/*  74 */     addActor((Actor)this.k);
/*     */     
/*  76 */     this.n = new RadialSprite((TextureRegion)Game.i.assetManager.getTextureRegion("ui-ability-button-edges"));
/*  77 */     this.o = new Image(this.n);
/*  78 */     this.o.setSize(96.0F, 104.0F);
/*  79 */     this.o.setPosition(0.0F, 11.0F);
/*  80 */     this.o.setVisible(false);
/*  81 */     addActor((Actor)this.o);
/*     */     
/*  83 */     this.l = new Image();
/*  84 */     this.l.setSize(64.0F, 64.0F);
/*  85 */     this.l.setPosition(16.0F, 30.0F);
/*  86 */     addActor((Actor)this.l);
/*     */     
/*  88 */     this.p = new Label("0", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  89 */     this.p.setPosition(82.0F, 12.0F);
/*  90 */     this.p.setSize(8.0F, 15.0F);
/*  91 */     this.p.setAlignment(1);
/*  92 */     addActor((Actor)this.p);
/*     */     
/*  94 */     this.m = new Image((Drawable)Game.i.assetManager.getDrawable("ui-ability-button-selection"));
/*  95 */     this.m.setSize(108.0F, 118.0F);
/*  96 */     this.m.setPosition(-6.0F, 4.0F);
/*  97 */     this.m.addAction((Action)Actions.forever((Action)Actions.sequence(
/*  98 */             (Action)Actions.alpha(0.5F, 0.5F), 
/*  99 */             (Action)Actions.alpha(1.0F, 0.5F))));
/*     */     
/* 101 */     addActor((Actor)this.m);
/*     */ 
/*     */     
/* 104 */     for (paramBoolean = false; paramBoolean < this.q.length; paramBoolean++) {
/* 105 */       this.q[paramBoolean] = new Image((Drawable)Game.i.assetManager.getDrawable("ui-ability-button-energy-mark"));
/* 106 */       this.q[paramBoolean].setSize(15.0F, 16.0F);
/* 107 */       this.q[paramBoolean].setPosition(8.0F + 15.0F * paramBoolean, 8.0F - paramBoolean);
/* 108 */       addActor((Actor)this.q[paramBoolean]);
/*     */     } 
/*     */     
/* 111 */     setAbility((AbilityType)null);
/* 112 */     setSelected(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGameEnergy(float paramFloat) {
/* 119 */     this.u = paramFloat;
/* 120 */     update();
/*     */   }
/*     */   
/*     */   public float getGameEnergy() {
/* 124 */     return this.u;
/*     */   }
/*     */   
/*     */   public void setAbility(AbilityType paramAbilityType) {
/* 128 */     this.r = paramAbilityType;
/*     */     
/* 130 */     update();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbilityType getAbility() {
/* 137 */     return this.r;
/*     */   }
/*     */   
/*     */   public void setCount(int paramInt) {
/* 141 */     this.s = paramInt;
/* 142 */     update();
/*     */   }
/*     */   
/*     */   public int getCount() {
/* 146 */     return this.s;
/*     */   }
/*     */   
/*     */   public int getEnergyCost() {
/* 150 */     return this.t; } public void update() {
/*     */     Image[] arrayOfImage;
/*     */     int i;
/*     */     byte b;
/* 154 */     for (i = (arrayOfImage = this.q).length, b = 0; b < i; b++) {
/* 155 */       Image image; (image = arrayOfImage[b]).setVisible(false);
/*     */     } 
/*     */     
/* 158 */     if (this.r == null) {
/*     */       
/* 160 */       if (this.v) {
/* 161 */         this.k.setDrawable((Drawable)Game.i.assetManager.getDrawable("ui-ability-button-empty-plus"));
/* 162 */         this.k.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*     */       } else {
/* 164 */         this.k.setDrawable((Drawable)Game.i.assetManager.getDrawable("ui-ability-button-empty"));
/* 165 */         this.k.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*     */       } 
/* 167 */       this.k.setSize(96.0F, 104.0F);
/* 168 */       this.k.setPosition(0.0F, 11.0F);
/*     */       
/* 170 */       this.l.setVisible(false);
/* 171 */       this.p.setVisible(false);
/* 172 */       this.o.setVisible(false);
/*     */       return;
/*     */     } 
/* 175 */     this.o.setColor(Game.i.abilityManager.getFactory(this.r).getDarkerColor());
/* 176 */     this.k.setDrawable((Drawable)Game.i.assetManager.getDrawable("ui-ability-button"));
/* 177 */     this.t = this.x.getIntValue(Game.i.abilityManager.getEnergyCostGameValueType(this.r));
/* 178 */     if (this.s > 0) {
/*     */       
/* 180 */       if (this.t <= this.u) {
/*     */         
/* 182 */         this.l.setColor(Color.WHITE);
/*     */         
/* 184 */         if (this.w) {
/* 185 */           this.k.setColor(Game.i.abilityManager.getFactory(this.r).getColor());
/*     */         } else {
/* 187 */           this.k.setColor(Game.i.abilityManager.getFactory(this.r).getDarkerColor());
/*     */         } 
/*     */ 
/*     */         
/* 191 */         for (byte b1 = 0; b1 < this.t; b1++) {
/* 192 */           if (b1 < this.q.length) {
/* 193 */             this.q[b1].setVisible(true);
/* 194 */             this.q[b1].setColor(Color.WHITE);
/*     */           } 
/*     */         } 
/*     */         
/* 198 */         this.o.setVisible(false);
/*     */       } else {
/*     */         
/* 201 */         this.l.setColor(0.0F, 0.0F, 0.0F, 0.78F);
/*     */         
/* 203 */         this.k.setColor(Game.i.abilityManager.getFactory(this.r).getDarkerColor());
/* 204 */         (this.k.getColor()).a = 0.4F;
/*     */ 
/*     */         
/* 207 */         for (byte b1 = 0; b1 < this.t; b1++) {
/* 208 */           if (b1 < this.q.length) {
/* 209 */             this.q[b1].setVisible(true);
/* 210 */             if ((b1 + 1) <= this.u) {
/* 211 */               this.q[b1].setColor(Color.WHITE);
/*     */             } else {
/* 213 */               this.q[b1].setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 218 */         float f1 = this.u / this.t;
/* 219 */         float f2 = (1.0F - f1) * 359.99F;
/* 220 */         this.n.setAngle(f2);
/* 221 */         this.o.setVisible(true);
/*     */       } 
/*     */     } else {
/*     */       
/* 225 */       this.l.setColor(MaterialColor.GREY.P700);
/* 226 */       this.k.setColor(MaterialColor.GREY.P900);
/* 227 */       this.o.setVisible(false);
/*     */     } 
/* 229 */     this.k.setSize(106.0F, 115.0F);
/* 230 */     this.k.setPosition(0.0F, 0.0F);
/*     */     
/* 232 */     this.l.setDrawable((Drawable)Game.i.abilityManager.getFactory(this.r).getIconDrawable());
/* 233 */     this.l.setVisible(true);
/*     */     
/* 235 */     this.p.setTextFromInt(this.s);
/* 236 */     this.p.setVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelected(boolean paramBoolean) {
/* 241 */     this.m.setVisible(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSelected() {
/* 245 */     return this.m.isVisible();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\AbilitySlotButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */