/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ public class AimStrategySelector
/*     */   extends Group
/*     */ {
/*     */   private final PaddedImageButton k;
/*     */   private final PaddedImageButton l;
/*  23 */   private float m = 4.0F;
/*     */   
/*     */   private Tower.AimStrategy n;
/*     */   private float o;
/*  27 */   private final StrategyIcon[] p = new StrategyIcon[Tower.AimStrategy.values.length];
/*  28 */   private final Array<StrategyIcon> q = new Array(StrategyIcon.class);
/*     */   
/*  30 */   private final DelayedRemovalArray<AimStrategySelectorListener> r = new DelayedRemovalArray();
/*     */   static {
/*  32 */     s = ((paramStrategyIcon1, paramStrategyIcon2) -> (paramStrategyIcon1.k == paramStrategyIcon2.k) ? 0 : ((StrictMath.abs(paramStrategyIcon1.k) > StrictMath.abs(paramStrategyIcon2.k)) ? -1 : 1));
/*     */   }
/*     */   
/*     */   private static final Comparator<StrategyIcon> s;
/*     */   
/*     */   public AimStrategySelector() {
/*  38 */     setTransform(false);
/*  39 */     setSize(310.0F, 84.0F);
/*     */     
/*     */     Group group;
/*  42 */     (group = new Group()).setSize(310.0F, 84.0F);
/*  43 */     group.setTransform(false);
/*  44 */     addActor((Actor)group); Tower.AimStrategy[] arrayOfAimStrategy; int i;
/*     */     byte b;
/*  46 */     for (i = (arrayOfAimStrategy = Tower.AimStrategy.values).length, b = 0; b < i; ) { Tower.AimStrategy aimStrategy = arrayOfAimStrategy[b];
/*  47 */       StrategyIcon strategyIcon = new StrategyIcon(this, Game.i.towerManager.getAimStrategyIconAlias(aimStrategy), Game.i.towerManager.getAimStrategyColor(aimStrategy));
/*  48 */       this.p[aimStrategy.ordinal()] = strategyIcon;
/*  49 */       group.addActor((Actor)strategyIcon);
/*  50 */       this.q.add(strategyIcon);
/*     */       b++; }
/*     */     
/*  53 */     this.k = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-left"), () -> d(), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P900);
/*  54 */     this.k.setSize(155.0F, 84.0F);
/*  55 */     this.k
/*  56 */       .setIconSize(40.0F, 40.0F)
/*  57 */       .setIconPosition(6.0F, 23.0F);
/*  58 */     addActor((Actor)this.k);
/*     */     
/*  60 */     this.l = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"), () -> e(), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P900);
/*  61 */     this.l.setSize(155.0F, 84.0F);
/*  62 */     this.l.setPosition(155.0F, 0.0F);
/*  63 */     this.l
/*  64 */       .setIconSize(40.0F, 40.0F)
/*  65 */       .setIconPosition(110.0F, 23.0F);
/*  66 */     addActor((Actor)this.l);
/*     */     
/*  68 */     if (HotKeyHintLabel.isEnabled()) {
/*  69 */       addActor((Actor)new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.AIM_MODE_SWITCH_PREVIOUS), 26.0F, 6.0F));
/*  70 */       addActor((Actor)new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.AIM_MODE_SWITCH_NEXT), 285.0F, 6.0F));
/*     */     } 
/*     */     
/*  73 */     setStrategy(Tower.AimStrategy.values[0], false, false);
/*  74 */     f();
/*     */   }
/*     */   
/*     */   public void addListener(AimStrategySelectorListener paramAimStrategySelectorListener) {
/*  78 */     if (paramAimStrategySelectorListener == null) throw new IllegalArgumentException("listener is null");
/*     */     
/*  80 */     if (!this.r.contains(paramAimStrategySelectorListener, true)) this.r.add(paramAimStrategySelectorListener); 
/*     */   }
/*     */   
/*     */   public void removeListener(AimStrategySelectorListener paramAimStrategySelectorListener) {
/*  84 */     if (paramAimStrategySelectorListener == null) throw new IllegalArgumentException("listener is null");
/*     */     
/*  86 */     this.r.removeValue(paramAimStrategySelectorListener, true);
/*     */   }
/*     */   
/*     */   private void d() {
/*     */     int i;
/*  91 */     if ((i = this.n.ordinal() - 1) == -1) {
/*  92 */       i = Tower.AimStrategy.values.length - 1;
/*     */     }
/*  94 */     setStrategy(Tower.AimStrategy.values[i], true, true);
/*     */   }
/*     */   
/*     */   private void e() {
/*     */     int i;
/*  99 */     if ((i = this.n.ordinal() + 1) == Tower.AimStrategy.values.length) {
/* 100 */       i = 0;
/*     */     }
/* 102 */     setStrategy(Tower.AimStrategy.values[i], true, true);
/*     */   }
/*     */   
/*     */   public void setStrategy(Tower.AimStrategy paramAimStrategy, boolean paramBoolean1, boolean paramBoolean2) {
/* 106 */     if (this.n != paramAimStrategy) {
/* 107 */       this.n = paramAimStrategy;
/*     */       
/* 109 */       if (!paramBoolean1) {
/* 110 */         this.o = paramAimStrategy.ordinal();
/* 111 */         f();
/*     */       } else {
/*     */         
/* 114 */         this.m = StrictMath.abs(PMath.loopedDistance(this.o, paramAimStrategy.ordinal(), Tower.AimStrategy.values.length)) * 4.0F;
/* 115 */         if (this.m < 4.0F) this.m = 4.0F;
/*     */       
/*     */       } 
/* 118 */       if (paramBoolean2) {
/* 119 */         this.r.begin(); int i;
/* 120 */         for (paramBoolean1 = false, i = this.r.size; paramBoolean1 < i; paramBoolean1++) {
/* 121 */           ((AimStrategySelectorListener)this.r.get(paramBoolean1)).strategyChanged(paramAimStrategy);
/*     */         }
/* 123 */         this.r.end();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void f() {
/*     */     byte b;
/* 130 */     for (b = 0; b < Tower.AimStrategy.values.length; b++) {
/* 131 */       this.p[b].a(PMath.loopedDistance(b, this.o, Tower.AimStrategy.values.length));
/*     */     }
/*     */ 
/*     */     
/* 135 */     this.q.sort(s);
/*     */     
/* 137 */     for (b = 0; b < this.q.size; b++) {
/*     */       StrategyIcon strategyIcon;
/* 139 */       (strategyIcon = ((StrategyIcon[])this.q.items)[b]).setZIndex(99);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/* 145 */     if (this.o != this.n.ordinal()) {
/*     */       
/* 147 */       float f1 = paramFloat * this.m;
/* 148 */       if (!Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 149 */         f1 = 9001.0F;
/*     */       }
/*     */       
/*     */       float f2;
/* 153 */       if ((f2 = PMath.loopedDistance(this.o, this.n.ordinal(), Tower.AimStrategy.values.length)) > f1) {
/* 154 */         f2 = f1;
/* 155 */       } else if (f2 < -f1) {
/* 156 */         f2 = -f1;
/*     */       } 
/* 158 */       this.o -= f2;
/*     */       
/* 160 */       this.o = (this.o + this.p.length) % this.p.length;
/* 161 */       f();
/*     */     } 
/*     */     
/* 164 */     super.act(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void sizeChanged() {}
/*     */ 
/*     */   
/*     */   private class StrategyIcon
/*     */     extends Group
/*     */   {
/*     */     float k;
/*     */     
/*     */     private Image l;
/*     */     
/*     */     private Image m;
/*     */     
/* 180 */     private final Color n = new Color();
/*     */     
/*     */     StrategyIcon(AimStrategySelector this$0, String param1String, Color param1Color) {
/* 183 */       this.n.set(param1Color);
/*     */       
/* 185 */       this.l = new Image((Drawable)Game.i.assetManager.getDrawable("ui-aim-strategy-switch-item-background"));
/* 186 */       addActor((Actor)this.l);
/*     */       
/* 188 */       this.m = new Image((Drawable)Game.i.assetManager.getDrawable(param1String));
/* 189 */       addActor((Actor)this.m);
/*     */       
/* 191 */       setTransform(false);
/* 192 */       setSize(94.0F, 84.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final void a(float param1Float) {
/* 199 */       this.k = param1Float;
/*     */       
/*     */       float f1;
/* 202 */       if ((f1 = (2.0F - StrictMath.abs(param1Float)) / 2.0F) < 0.0F || f1 > 1.0F) {
/* 203 */         setVisible(false); return;
/*     */       } 
/* 205 */       setVisible(true);
/*     */       
/* 207 */       param1Float = 155.0F + 70.0F * param1Float;
/*     */       
/* 209 */       float f2 = 1.0F - (1.0F - f1) * 0.33F;
/*     */       
/* 211 */       float f3 = 94.0F * f2;
/* 212 */       float f4 = 84.0F * f2;
/* 213 */       setPosition(param1Float - f3 * 0.5F, 42.0F - f4 * 0.5F);
/* 214 */       setSize(f3, f4);
/*     */       
/* 216 */       this.n.a = f1;
/* 217 */       this.l.setColor(this.n);
/* 218 */       this.l.setSize(f3, f4);
/*     */       
/* 220 */       param1Float = 64.0F * f2;
/* 221 */       f3 = 15.0F * f2;
/* 222 */       f2 = 12.0F * f2;
/* 223 */       this.m.setColor(1.0F, 1.0F, 1.0F, f1);
/* 224 */       this.m.setSize(param1Float, param1Float);
/* 225 */       this.m.setPosition(f3, f2);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface AimStrategySelectorListener {
/*     */     void strategyChanged(Tower.AimStrategy param1AimStrategy);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\AimStrategySelector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */