/*     */ package com.prineside.tdi2.ui.actors;
/*     */ import com.badlogic.gdx.graphics.Color;
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
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class RightSideMenuButton extends Group {
/*  16 */   private static final Color k = new Color(1.0F, 1.0F, 1.0F, 0.56F);
/*     */   
/*     */   public static final float WIDTH = 388.0F;
/*     */   
/*     */   public static final float HEIGHT = 108.0F;
/*     */   
/*     */   private boolean l = true;
/*     */   
/*     */   private boolean m = false;
/*     */   private boolean n = false;
/*     */   private Image o;
/*     */   private Image p;
/*     */   private Label q;
/*  29 */   private Color r = MaterialColor.LIGHT_BLUE.P800.cpy();
/*  30 */   private Color s = MaterialColor.LIGHT_BLUE.P700.cpy();
/*  31 */   private Color t = MaterialColor.LIGHT_BLUE.P900.cpy();
/*  32 */   private Color u = MaterialColor.GREY.P800.cpy();
/*  33 */   private Color v = Color.WHITE.cpy();
/*     */   
/*     */   private Runnable w;
/*     */   
/*     */   public RightSideMenuButton(String paramString1, String paramString2, Runnable paramRunnable) {
/*  38 */     Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(30);
/*  39 */     this.w = paramRunnable;
/*     */ 
/*     */ 
/*     */     
/*  43 */     setTransform(false);
/*  44 */     setSize(388.0F, 108.0F);
/*     */     
/*  46 */     this.o = new Image((Drawable)Game.i.assetManager.getDrawable("ui-right-menu-button"));
/*  47 */     this.o.setSize(488.0F, 108.0F);
/*  48 */     addActor((Actor)this.o);
/*     */     
/*  50 */     this.p = new Image((Drawable)Game.i.assetManager.getDrawable(paramString2));
/*  51 */     this.p.setSize(40.0F, 40.0F);
/*  52 */     this.p.setPosition(32.0F, 40.0F);
/*  53 */     addActor((Actor)this.p);
/*     */     
/*  55 */     this.q = new Label(paramString1, labelStyle);
/*  56 */     this.q.setSize(300.0F, 96.0F);
/*  57 */     this.q.setPosition(88.0F, 12.0F);
/*  58 */     addActor((Actor)this.q);
/*     */     
/*  60 */     setTouchable(Touchable.enabled);
/*  61 */     addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  64 */             if (RightSideMenuButton.a(this.a) != null) {
/*  65 */               RightSideMenuButton.a(this.a).run();
/*  66 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  72 */             RightSideMenuButton.a(this.a, true);
/*  73 */             RightSideMenuButton.b(this.a);
/*     */             
/*  75 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  80 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */             
/*  82 */             RightSideMenuButton.a(this.a, false);
/*  83 */             RightSideMenuButton.b(this.a);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  88 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/*  90 */             if (param1Int == -1) {
/*  91 */               RightSideMenuButton.b(this.a, true);
/*  92 */               RightSideMenuButton.b(this.a);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  98 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/* 100 */             if (param1Int == -1) {
/* 101 */               RightSideMenuButton.b(this.a, false);
/* 102 */               RightSideMenuButton.b(this.a);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 107 */     d();
/*     */   }
/*     */   
/*     */   public void setClickHandler(Runnable paramRunnable) {
/* 111 */     this.w = paramRunnable;
/*     */   }
/*     */   
/*     */   public void setColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 115 */     this.r.set(paramColor1);
/* 116 */     this.s.set(paramColor2);
/* 117 */     this.t.set(paramColor3);
/* 118 */     this.v.set(paramColor4);
/*     */     
/* 120 */     d();
/*     */   }
/*     */   
/*     */   private void d() {
/* 124 */     if (this.l) {
/* 125 */       if (this.m) {
/* 126 */         this.o.setColor(this.t);
/*     */       }
/* 128 */       else if (this.n) {
/* 129 */         this.o.setColor(this.s);
/*     */       } else {
/* 131 */         this.o.setColor(this.r);
/*     */       } 
/*     */       
/* 134 */       this.p.setColor(this.v);
/* 135 */       this.q.setColor(this.v); return;
/*     */     } 
/* 137 */     this.p.setColor(k);
/* 138 */     this.q.setColor(k);
/* 139 */     this.o.setColor(this.u);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEnabled(boolean paramBoolean) {
/* 144 */     if (paramBoolean != this.l) {
/* 145 */       this.l = paramBoolean;
/*     */       
/* 147 */       d();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setText(CharSequence paramCharSequence) {
/* 152 */     this.q.setText(paramCharSequence);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\RightSideMenuButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */