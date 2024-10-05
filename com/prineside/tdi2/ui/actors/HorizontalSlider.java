/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ 
/*     */ 
/*     */ public class HorizontalSlider
/*     */   extends Group
/*     */ {
/*     */   public static final float HEIGHT = 48.0F;
/*     */   public static final float HANDLE_WIDTH = 56.0F;
/*     */   private ObjectConsumer<Double> k;
/*     */   private Group l;
/*     */   
/*     */   public HorizontalSlider(float paramFloat, double paramDouble1, double paramDouble2, double paramDouble3, ObjectConsumer<Double> paramObjectConsumer) {
/*  25 */     setTransform(false);
/*  26 */     setSize(paramFloat, 48.0F);
/*     */     
/*  28 */     this.k = paramObjectConsumer;
/*  29 */     this.n = paramDouble1;
/*  30 */     this.o = paramDouble2;
/*  31 */     this.p = paramDouble3;
/*     */     
/*     */     Image image;
/*     */     
/*  35 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(paramFloat - 16.0F, 10.0F);
/*  36 */     image.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  37 */     image.setPosition(8.0F, 19.0F);
/*  38 */     addActor((Actor)image);
/*     */ 
/*     */     
/*  41 */     this.l = new Group();
/*  42 */     this.l.setTransform(false);
/*  43 */     this.l.setSize(56.0F, 64.0F);
/*  44 */     this.l.addListener((EventListener)new InputListener(this, paramFloat, paramDouble3, paramDouble2) {
/*  45 */           private float a = this.e - 56.0F;
/*  46 */           private double b = (this.f - this.g) / this.a;
/*     */           private double c;
/*     */           private float d;
/*     */           
/*     */           private double a(float param1Float) {
/*  51 */             double d1 = (param1Float - this.d) * this.b;
/*     */             
/*     */             double d2;
/*  54 */             if ((d2 = this.c + d1) < this.g) {
/*  55 */               d2 = this.g;
/*  56 */             } else if (d2 > this.f) {
/*  57 */               d2 = this.f;
/*     */             } 
/*     */             
/*  60 */             return d2;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  65 */             param1InputEvent.cancel();
/*  66 */             this.d = param1InputEvent.getStageX();
/*  67 */             this.c = HorizontalSlider.a(this.h);
/*  68 */             HorizontalSlider.b(this.h).setColor(MaterialColor.LIGHT_BLUE.P700);
/*  69 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  74 */             this.h.setValue(a(param1InputEvent.getStageX()), true);
/*  75 */             HorizontalSlider.b(this.h).setColor(MaterialColor.LIGHT_BLUE.P600);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  80 */             this.h.setValue(a(param1InputEvent.getStageX()), HorizontalSlider.c(this.h));
/*     */           }
/*     */         });
/*  83 */     addActor((Actor)this.l);
/*     */     
/*  85 */     this.m = new Image((Drawable)Game.i.assetManager.getDrawable("ui-horizontal-slider-handle"));
/*  86 */     this.m.setSize(32.0F, 48.0F);
/*  87 */     this.m.setPosition(12.0F, 8.0F);
/*  88 */     this.m.setColor(MaterialColor.LIGHT_BLUE.P600);
/*  89 */     this.l.addActor((Actor)this.m);
/*     */     
/*  91 */     addListener((EventListener)new ClickListener(this, paramDouble2, paramDouble3)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*     */             double d;
/*  95 */             if ((d = (param1Float1 / this.c.getWidth())) < 0.0D) {
/*  96 */               d = 0.0D;
/*  97 */             } else if (d > 1.0D) {
/*  98 */               d = 1.0D;
/*     */             } 
/*     */             
/* 101 */             this.c.setValue(this.a + (this.b - this.a) * d, true);
/*     */           }
/*     */         });
/*     */     
/* 105 */     setValue(paramDouble1, false);
/*     */   } private Image m; private double n; private double o; private double p; private boolean q;
/*     */   
/*     */   public void setNotifyOnDrag(boolean paramBoolean) {
/* 109 */     this.q = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setValue(double paramDouble, boolean paramBoolean) {
/* 113 */     if (paramDouble < this.o) paramDouble = this.o; 
/* 114 */     if (paramDouble > this.p) paramDouble = this.p;
/*     */     
/* 116 */     this.n = paramDouble;
/*     */     
/*     */     double d;
/* 119 */     float f = (float)(d = (paramDouble - this.o) / (this.p - this.o)) * (getWidth() - 56.0F);
/* 120 */     this.l.setPosition(f, -8.0F);
/*     */     
/* 122 */     if (this.k != null && paramBoolean) {
/* 123 */       this.k.accept(Double.valueOf(paramDouble));
/*     */     }
/*     */   }
/*     */   
/*     */   public double getValue() {
/* 128 */     return this.n;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\HorizontalSlider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */