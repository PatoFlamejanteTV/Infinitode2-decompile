/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ @NAGS
/*     */ public final class ProjectileTrailSystem
/*     */   extends GameSystem
/*     */ {
/*  28 */   private final DelayedRemovalArray<ProjectileTrail> a = new DelayedRemovalArray(false, 16, ProjectileTrail.class);
/*  29 */   private final DelayedRemovalArray<ProjectileTrail> b = new DelayedRemovalArray(false, 16, ProjectileTrail.class);
/*     */   
/*     */   private boolean c;
/*  32 */   private static final IntArray d = new IntArray();
/*     */   
/*  34 */   private final int e = Math.max(2, Runtime.getRuntime().availableProcessors());
/*  35 */   private final ExecutorService f = Executors.newFixedThreadPool(this.e, new ThreadFactory(this) {
/*  36 */         private int a = 0;
/*     */ 
/*     */ 
/*     */         
/*     */         public Thread newThread(Runnable param1Runnable) {
/*  41 */           (param1Runnable = new Thread(param1Runnable, "ProjectileTrailSystem-" + this.a++)).setDaemon(true);
/*  42 */           return (Thread)param1Runnable;
/*     */         }
/*     */       });
/*     */   private float g;
/*  46 */   private final ArrayList<TrailsHandler> h = new ArrayList<>();
/*     */   public ProjectileTrailSystem() {
/*  48 */     for (byte b = 0; b < this.e; b++) {
/*  49 */       this.h.add(new TrailsHandler((byte)0));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  55 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PROJECTILE_TRAIL_UPDATE_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> updateDraw(paramFloat2)))
/*     */ 
/*     */         
/*  58 */         .setName("ProjectileTrail-updateDraw"));
/*     */     
/*  60 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PROJECTILE_TRAIL_DRAW_OPAQUE, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawOpaque(paramBatch)))
/*     */ 
/*     */         
/*  63 */         .setName("ProjectileTrail-drawOpaque"));
/*     */     
/*  65 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PROJECTILE_TRAIL_DRAW, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch)))
/*     */ 
/*     */         
/*  68 */         .setName("ProjectileTrail-draw"));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/*  78 */     return "ProjectileTrail";
/*     */   }
/*     */   
/*     */   public final void addTrail(ProjectileTrail paramProjectileTrail) {
/*  82 */     if (!isEnabled()) {
/*  83 */       paramProjectileTrail.free();
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     this.b.add(paramProjectileTrail);
/*     */   }
/*     */   
/*     */   public final void addOpaqueTrail(ProjectileTrail paramProjectileTrail) {
/*  91 */     if (!isEnabled()) {
/*  92 */       paramProjectileTrail.free();
/*     */       
/*     */       return;
/*     */     } 
/*  96 */     this.a.add(paramProjectileTrail);
/*     */   }
/*     */   
/*     */   public final boolean isEnabled() {
/* 100 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void updateDraw(float paramFloat) {
/* 104 */     if (!isEnabled()) {
/*     */       return;
/*     */     }
/* 107 */     this.g = paramFloat;
/*     */ 
/*     */     
/* 110 */     d.clear();
/* 111 */     if (this.b.size > Math.max(this.e * 10, 200) && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MULTITHREADING) != 0.0D) {
/* 112 */       a();
/* 113 */       for (byte b1 = 0; b1 < this.e; b1++) {
/*     */         TrailsHandler trailsHandler;
/* 115 */         if ((TrailsHandler.a(trailsHandler = this.h.get(b1))).size != 0) {
/* 116 */           d.addAll(TrailsHandler.a(trailsHandler));
/*     */         }
/*     */       } 
/* 119 */       d.sort();
/*     */     } else {
/* 121 */       byte b1; int j; for (b1 = 0, j = this.b.size; b1 < j; b1++) {
/*     */         ProjectileTrail projectileTrail;
/* 123 */         (projectileTrail = ((ProjectileTrail[])this.b.items)[b1]).update(paramFloat);
/* 124 */         if (projectileTrail.isFinished()) {
/* 125 */           d.add(b1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     if (d.size != 0) {
/* 131 */       for (byte b1 = 0; b1 < d.size; b1++) {
/* 132 */         int j = d.items[b1];
/* 133 */         ((ProjectileTrail[])this.b.items)[j].free();
/*     */       } 
/* 135 */       d.reverse();
/* 136 */       PMath.removeArrayIndicesDirect((Array)this.b, d);
/* 137 */       d.clear();
/*     */     } 
/*     */ 
/*     */     
/* 141 */     d.clear(); byte b; int i;
/* 142 */     for (b = 0, i = this.a.size; b < i; b++) {
/*     */       ProjectileTrail projectileTrail;
/* 144 */       (projectileTrail = ((ProjectileTrail[])this.a.items)[b]).update(paramFloat);
/* 145 */       if (projectileTrail.isFinished()) {
/* 146 */         d.add(b);
/*     */       }
/*     */     } 
/* 149 */     if (d.size != 0) {
/* 150 */       for (b = 0; b < d.size; b++) {
/* 151 */         i = d.items[b];
/* 152 */         ((ProjectileTrail[])this.a.items)[i].free();
/*     */       } 
/* 154 */       d.reverse();
/* 155 */       PMath.removeArrayIndicesDirect((Array)this.a, d);
/* 156 */       d.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 162 */     double d1 = this.b.size / this.e;
/* 163 */     double d2 = 0.0D;
/*     */     
/* 165 */     for (byte b = 0; b < this.e; b++) {
/* 166 */       int i = (int)d2;
/* 167 */       d2 += d1;
/* 168 */       int j = (b == this.e - 1) ? (this.b.size - 1) : ((int)d2 - 1);
/*     */       TrailsHandler trailsHandler;
/* 170 */       TrailsHandler.a(trailsHandler = this.h.get(b), i);
/* 171 */       TrailsHandler.b(trailsHandler, j);
/*     */     } 
/*     */     try {
/* 174 */       this.f.invokeAll((Collection)this.h); return;
/* 175 */     } catch (InterruptedException interruptedException) {
/* 176 */       throw new IllegalStateException("Failed to loop through the array", interruptedException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void drawOpaque(Batch paramBatch) {
/* 181 */     if (isEnabled()) {
/* 182 */       byte b; int i; for (b = 0, i = this.a.size; b < i; b++) {
/* 183 */         ((ProjectileTrail[])this.a.items)[b].draw(paramBatch);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch) {
/* 189 */     this.c = (Game.i.settingsManager.isProjectileTrailsDrawing() && Game.i.settingsManager.isProjectilesDrawing() && !this.S.gameState.canSkipMediaUpdate());
/* 190 */     if (isEnabled()) {
/* 191 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS); byte b; int i;
/* 192 */       for (b = 0, i = this.b.size; b < i; b++) {
/* 193 */         ((ProjectileTrail[])this.b.items)[b].draw(paramBatch);
/*     */       }
/*     */     } 
/*     */     
/* 197 */     if (Game.i.debugManager.isEnabled()) {
/* 198 */       Game.i.debugManager.registerValue("Projectile trails").append(this.b.size);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 204 */     Game.i.debugManager.unregisterValue("Particles count");
/*     */     
/* 206 */     this.b.clear();
/* 207 */     this.a.clear();
/* 208 */     this.f.shutdown();
/*     */     
/* 210 */     super.dispose();
/*     */   }
/*     */   
/*     */   private final class TrailsHandler implements Callable<Object> { private int a;
/*     */     
/*     */     private TrailsHandler(ProjectileTrailSystem this$0) {
/* 216 */       this.c = new IntArray();
/*     */     }
/*     */     private int b; private final IntArray c;
/*     */     
/*     */     public final Object call() {
/* 221 */       this.c.clear();
/* 222 */       for (int i = this.a, j = this.b; i <= j; i++) {
/*     */         ProjectileTrail projectileTrail;
/* 224 */         (projectileTrail = ((ProjectileTrail[])(ProjectileTrailSystem.a(this.d)).items)[i]).update(ProjectileTrailSystem.b(this.d));
/* 225 */         if (projectileTrail.isFinished()) {
/* 226 */           this.c.add(i);
/*     */         }
/*     */       } 
/* 229 */       return null;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\ProjectileTrailSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */