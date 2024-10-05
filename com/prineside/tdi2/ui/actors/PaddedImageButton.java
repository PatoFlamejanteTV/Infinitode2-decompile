/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PaddedImageButton
/*     */   extends Group
/*     */ {
/*     */   private boolean k = false;
/*     */   private boolean l = false;
/*     */   private boolean m = true;
/*     */   private final Image n;
/*     */   private final Image o;
/*     */   private Color p;
/*     */   private Color q;
/*     */   private Color r;
/*  30 */   private final Color s = new Color();
/*     */   @Null
/*     */   private Runnable t;
/*     */   public boolean disableClickThrough;
/*     */   
/*     */   public PaddedImageButton(Drawable paramDrawable, Runnable paramRunnable, Color paramColor1, Color paramColor2, Color paramColor3) {
/*  36 */     this.p = paramColor1;
/*  37 */     this.q = paramColor2;
/*  38 */     this.r = paramColor3;
/*  39 */     this.s.set(paramColor1);
/*  40 */     this.s.a *= 0.56F;
/*     */     
/*  42 */     this.t = paramRunnable;
/*     */     
/*  44 */     setTransform(false);
/*     */     
/*  46 */     this.n = new Image();
/*  47 */     this.n.setVisible(false);
/*  48 */     addActor((Actor)this.n);
/*     */     
/*  50 */     this.o = new Image(paramDrawable);
/*  51 */     addActor((Actor)this.o);
/*     */ 
/*     */ 
/*     */     
/*  55 */     setTouchable(Touchable.enabled);
/*  56 */     addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  59 */             if (PaddedImageButton.a(this.a) && PaddedImageButton.b(this.a) != null) {
/*  60 */               PaddedImageButton.b(this.a).run();
/*  61 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */               
/*  63 */               if (this.a.disableClickThrough) {
/*  64 */                 param1InputEvent.stop();
/*  65 */                 param1InputEvent.cancel();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  72 */             PaddedImageButton.a(this.a, true);
/*  73 */             this.a.updateColors();
/*     */             
/*  75 */             return (super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2) || this.a.disableClickThrough);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  80 */             PaddedImageButton.a(this.a, false);
/*  81 */             this.a.updateColors();
/*     */             
/*  83 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  88 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/*  90 */             if (param1Int == -1) {
/*  91 */               PaddedImageButton.b(this.a, true);
/*  92 */               this.a.updateColors();
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  99 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/* 101 */             if (param1Int == -1) {
/* 102 */               PaddedImageButton.b(this.a, false);
/* 103 */               this.a.updateColors();
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 108 */     updateColors();
/*     */   }
/*     */   
/*     */   public Runnable getClickHandler() {
/* 112 */     return this.t;
/*     */   }
/*     */   
/*     */   public void setClickHandler(Runnable paramRunnable) {
/* 116 */     this.t = paramRunnable;
/*     */   }
/*     */   
/*     */   public void setShadow(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor) {
/* 120 */     this.n.setDrawable(paramDrawable);
/* 121 */     this.n.setPosition(paramFloat1, paramFloat2);
/* 122 */     this.n.setSize(paramFloat3, paramFloat4);
/* 123 */     this.n.setColor(paramColor);
/*     */     
/* 125 */     this.n.setVisible(true);
/*     */   }
/*     */   
/*     */   public void hideShadow() {
/* 129 */     this.n.setVisible(false);
/*     */   }
/*     */   
/*     */   public Color getDisabledColor() {
/* 133 */     return this.s;
/*     */   }
/*     */   
/*     */   public void setColors(Color paramColor1, Color paramColor2, Color paramColor3) {
/* 137 */     this.p = paramColor1;
/* 138 */     this.q = paramColor2;
/* 139 */     this.r = paramColor3;
/*     */     
/* 141 */     updateColors();
/*     */   }
/*     */   
/*     */   public void setDisabledColor(Color paramColor) {
/* 145 */     this.s.set(paramColor);
/*     */     
/* 147 */     updateColors();
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean paramBoolean) {
/* 151 */     this.m = paramBoolean;
/*     */     
/* 153 */     updateColors();
/*     */   }
/*     */   
/*     */   public PaddedImageButton setIconSize(float paramFloat1, float paramFloat2) {
/* 157 */     this.o.setSize(paramFloat1, paramFloat2);
/*     */     
/* 159 */     return this;
/*     */   }
/*     */   
/*     */   public PaddedImageButton setIcon(Drawable paramDrawable) {
/* 163 */     this.o.setDrawable(paramDrawable);
/*     */     
/* 165 */     return this;
/*     */   }
/*     */   
/*     */   public PaddedImageButton setIconPosition(float paramFloat1, float paramFloat2) {
/* 169 */     this.o.setPosition(paramFloat1, paramFloat2);
/*     */     
/* 171 */     return this;
/*     */   }
/*     */   
/*     */   public Image getIcon() {
/* 175 */     return this.o;
/*     */   }
/*     */   
/*     */   public void updateColors() {
/* 179 */     if (this.m) {
/* 180 */       if (this.k) {
/* 181 */         this.o.setColor(this.r); return;
/* 182 */       }  if (this.l) {
/* 183 */         this.o.setColor(this.q); return;
/*     */       } 
/* 185 */       this.o.setColor(this.p);
/*     */       return;
/*     */     } 
/* 188 */     this.o.setColor(this.s);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\PaddedImageButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */