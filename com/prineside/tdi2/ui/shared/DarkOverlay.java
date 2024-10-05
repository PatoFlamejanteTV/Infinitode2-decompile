/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.utils.BooleanSupplier;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public final class DarkOverlay extends UiManager.UiComponent.Adapter {
/*  17 */   private static final TLog a = TLog.forClass(DarkOverlay.class);
/*     */   public static DarkOverlay i() {
/*  19 */     return (DarkOverlay)Game.i.uiManager.getComponent(DarkOverlay.class);
/*     */   }
/*     */   
/*  22 */   private static final Color b = new Color(218959279);
/*     */   
/*  24 */   private final DelayedRemovalArray<QueuedCaller> c = new DelayedRemovalArray(true, 1, QueuedCaller.class);
/*     */   
/*     */   private boolean d;
/*     */   private final ClickListener e;
/*     */   
/*     */   public DarkOverlay() {
/*  30 */     this.e = new ClickListener(this)
/*     */       {
/*     */         public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  33 */           Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */           
/*  35 */           if ((DarkOverlay.a(this.a)).size == 0) {
/*  36 */             DarkOverlay.a().e("no callers", new Object[0]); return;
/*     */           } 
/*  38 */           DarkOverlay.QueuedCaller queuedCaller = ((DarkOverlay.QueuedCaller[])(DarkOverlay.a(this.a)).items)[(DarkOverlay.a(this.a)).size - 1];
/*  39 */           boolean bool = true;
/*  40 */           if (queuedCaller.onClick != null) {
/*  41 */             bool = queuedCaller.onClick.getAsBoolean();
/*     */           }
/*  43 */           if (bool) {
/*  44 */             this.a.removeCaller(queuedCaller.name);
/*     */           }
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hide() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final void postRender(float paramFloat) {
/*  58 */     if (this.d) {
/*  59 */       float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 5.0F : 900100.0F;
/*     */       
/*  61 */       boolean bool = false; int i;
/*  62 */       for (i = this.c.size - 1; i >= 0; i--) {
/*     */         QueuedCaller queuedCaller;
/*  64 */         if ((queuedCaller = ((QueuedCaller[])this.c.items)[i]).removing) {
/*  65 */           queuedCaller.visible = false;
/*     */         }
/*  67 */         else if (bool) {
/*  68 */           queuedCaller.visible = false;
/*     */         } else {
/*  70 */           queuedCaller.visible = true;
/*  71 */           bool = true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  76 */       this.c.begin();
/*  77 */       for (i = 0; i < this.c.size; i++) {
/*     */         QueuedCaller queuedCaller;
/*     */         
/*  80 */         if ((queuedCaller = ((QueuedCaller[])this.c.items)[i]).visible) {
/*  81 */           if (queuedCaller.alpha < 1.0F) {
/*  82 */             queuedCaller.alpha += paramFloat * f;
/*  83 */             if (queuedCaller.alpha >= 1.0F) {
/*  84 */               queuedCaller.alpha = 1.0F;
/*     */             }
/*     */           } 
/*  87 */           queuedCaller.layer.getTable().setVisible(true);
/*     */         } else {
/*  89 */           if (queuedCaller.alpha > 0.0F) {
/*  90 */             queuedCaller.alpha -= paramFloat * f;
/*  91 */             if (queuedCaller.alpha <= 0.0F) {
/*  92 */               queuedCaller.alpha = 0.0F;
/*  93 */               queuedCaller.layer.getTable().setVisible(false);
/*     */             } 
/*     */           } 
/*  96 */           if (queuedCaller.alpha == 0.0F && queuedCaller.removing) {
/*  97 */             Game.i.uiManager.removeLayer(queuedCaller.layer);
/*  98 */             this.c.removeIndex(i);
/*     */           } 
/*     */         } 
/* 101 */         (queuedCaller.tint.getColor()).a = (queuedCaller.alpha * 0.5F + Interpolation.pow2Out.apply(queuedCaller.alpha) * 0.5F) * b.a;
/*     */       } 
/* 103 */       this.c.end();
/*     */       
/* 105 */       if (this.c.size == 0) {
/* 106 */         this.d = false;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void removeCaller(String paramString) {
/* 115 */     for (byte b = 0; b < this.c.size; b++) {
/*     */       QueuedCaller queuedCaller;
/* 117 */       if ((queuedCaller = ((QueuedCaller[])this.c.items)[b]).name.equals(paramString)) {
/* 118 */         if (!(((QueuedCaller[])this.c.items)[b]).removing) {
/* 119 */           (((QueuedCaller[])this.c.items)[b]).removing = true;
/* 120 */           (((QueuedCaller[])this.c.items)[b]).layer.getTable().setTouchable(Touchable.disabled);
/*     */           
/* 122 */           a.i("remove " + paramString, new Object[0]);
/*     */           return;
/*     */         } 
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b() {
/* 132 */     this.c.sort((paramQueuedCaller1, paramQueuedCaller2) -> Integer.compare(paramQueuedCaller1.layer.mainUiLayer.ordinal() * 100000 + paramQueuedCaller1.layer.zIndex, paramQueuedCaller2.layer.mainUiLayer.ordinal() * 100000 + paramQueuedCaller2.layer.zIndex));
/*     */   }
/*     */   
/*     */   public final void addCallerOverlayLayer(String paramString, int paramInt, BooleanSupplier paramBooleanSupplier) {
/* 136 */     addCaller(paramString, UiManager.MainUiLayer.OVERLAY, paramInt, paramBooleanSupplier);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addCaller(String paramString, UiManager.MainUiLayer paramMainUiLayer, int paramInt, BooleanSupplier paramBooleanSupplier) {
/* 143 */     if (paramString == null) throw new IllegalArgumentException("callerName is null");
/*     */     
/* 145 */     for (byte b = 0; b < this.c.size; b++) {
/*     */       QueuedCaller queuedCaller1;
/* 147 */       if ((queuedCaller1 = ((QueuedCaller[])this.c.items)[b]).name.equals(paramString) && !queuedCaller1.removing) {
/*     */         
/* 149 */         queuedCaller1.onClick = paramBooleanSupplier;
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*     */     QueuedCaller queuedCaller;
/* 156 */     (queuedCaller = new QueuedCaller((byte)0)).name = paramString;
/* 157 */     queuedCaller.onClick = paramBooleanSupplier;
/* 158 */     queuedCaller.visible = true;
/* 159 */     queuedCaller.alpha = 0.0F;
/* 160 */     queuedCaller.layer = Game.i.uiManager.addLayerIgnoreSafeArea(paramMainUiLayer, paramInt, paramString + " overlay", true);
/*     */     
/*     */     Image image;
/* 163 */     (image = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setColor(b.cpy().mul(1.0F, 1.0F, 1.0F, 0.0F));
/* 164 */     queuedCaller.tint = image;
/* 165 */     queuedCaller.layer.getTable().setTouchable(Touchable.enabled);
/* 166 */     queuedCaller.layer.getTable().addListener((EventListener)this.e);
/* 167 */     queuedCaller.layer.getTable().add((Actor)image).expand().fill();
/* 168 */     queuedCaller.layer.getTable().setVisible(false);
/*     */     
/* 170 */     this.c.add(queuedCaller);
/* 171 */     b();
/*     */     
/* 173 */     this.d = true;
/*     */     
/* 175 */     a.i("add " + paramString, new Object[0]);
/*     */   }
/*     */   
/*     */   public final void printDebug() {
/* 179 */     for (byte b = 0; b < this.c.size; b++) {
/* 180 */       QueuedCaller queuedCaller = ((QueuedCaller[])this.c.items)[b];
/* 181 */       a.i("  " + queuedCaller.name + " " + queuedCaller.layer.mainUiLayer.name() + " " + queuedCaller.layer.zIndex + " " + queuedCaller.alpha + " " + queuedCaller.removing + " " + queuedCaller.visible, new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class QueuedCaller {
/*     */     public String name;
/*     */     public BooleanSupplier onClick;
/*     */     public UiManager.UiLayer layer;
/*     */     public Image tint;
/*     */     public float alpha;
/*     */     public boolean visible;
/*     */     public boolean removing;
/*     */     
/*     */     private QueuedCaller() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\DarkOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */