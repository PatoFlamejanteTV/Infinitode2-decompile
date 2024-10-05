/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.projectiles.BulletWallProjectile;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class BulletWallAbility
/*     */   extends Ability
/*     */ {
/*  34 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 700, 800, 850 };
/*     */ 
/*     */   
/*  37 */   private static final int[][] c = new int[][] { { 5, 10, 25, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 5, 10, 30, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 10, 20, 40, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 10, 25, 50, 0, 100 }, { 0, 0, 0, 0, 0, 0, 0, 10, 25, 80, 150 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   public Array<PreparedBullet> preparedBullets = new Array(true, 1, PreparedBullet.class);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     super.write(paramKryo, paramOutput);
/*  50 */     paramKryo.writeObject(paramOutput, this.preparedBullets);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  55 */     super.read(paramKryo, paramInput);
/*  56 */     this.preparedBullets = (Array<PreparedBullet>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private BulletWallAbility() {
/*  60 */     super(AbilityType.BULLET_WALL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  65 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_BULLET_WALL_COINS);
/*     */     
/*  67 */     float f1 = MathUtils.round(this.S.gameValue.getFloatValue(GameValueType.ABILITY_BULLET_WALL_DENSITY) * 10.0F) / 10.0F;
/*     */     float f2;
/*  69 */     if ((f2 = (float)paramDouble * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_BULLET_WALL_DAMAGE)) <= 0.0F)
/*     */       return; 
/*  71 */     byte b = 0; float f3;
/*  72 */     for (f3 = 0.0F; f3 < this.S.map.getMap().getHeight(); f3 += 1.0F / f1) {
/*     */       PreparedBullet preparedBullet;
/*     */ 
/*     */ 
/*     */       
/*  77 */       (preparedBullet = new PreparedBullet()).damage = f2;
/*  78 */       preparedBullet.startVector.set(0.0F, f3 * 128.0F);
/*  79 */       preparedBullet.endVector.set((this.S.map.getMap().getWidth() + 1.0F) * 128.0F, f3 * 128.0F);
/*  80 */       preparedBullet.speed = 5.0F + PMath.sin((b * 10)) * 0.5F;
/*  81 */       this.preparedBullets.add(preparedBullet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  87 */       b++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  93 */     if (this.preparedBullets.size == 0) {
/*  94 */       if (this.S._gameUi != null) {
/*  95 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/*  97 */       return false;
/*     */     } 
/*     */     
/* 100 */     for (byte b = 0; b < this.preparedBullets.size; b++) {
/* 101 */       PreparedBullet preparedBullet = ((PreparedBullet[])this.preparedBullets.items)[b];
/* 102 */       BulletWallProjectile bulletWallProjectile = (BulletWallProjectile)this.S.projectile.F.BULLET_WALL.obtain();
/* 103 */       this.S.projectile.register((Projectile)bulletWallProjectile);
/* 104 */       bulletWallProjectile.setup(preparedBullet.damage, preparedBullet.startVector, preparedBullet.endVector, preparedBullet.speed);
/*     */     } 
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */   
/*     */   public static class BulletWallAbilityFactory
/*     */     extends Ability.Factory<BulletWallAbility>
/*     */   {
/*     */     public BulletWallAbilityFactory(AbilityType param1AbilityType) {
/* 125 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public BulletWallAbility create() {
/* 135 */       return new BulletWallAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 140 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 145 */       return MaterialColor.TEAL.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 150 */       float f1 = MathUtils.round((float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_BULLET_WALL_DAMAGE) * 1000.0F) / 10.0F;
/* 151 */       float f2 = MathUtils.round(param1GameValueProvider.getFloatValue(GameValueType.ABILITY_BULLET_WALL_DENSITY) * 10.0F) / 10.0F;
/* 152 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_BULLET_WALL_COINS) * 100.0D);
/*     */       
/* 154 */       String str2 = Game.i.localeManager.i18n.format("ability_description_BULLET_WALL", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
/* 155 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 156 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 161 */       return MaterialColor.TEAL.P800;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 166 */       return BulletWallAbility.a()[StrictMath.min(param1Int, (BulletWallAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 171 */       return BulletWallAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (BulletWallAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 176 */       return Game.i.assetManager.getDrawable("icon-bullet-wall");
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class PreparedBullet implements KryoSerializable {
/*     */     public float damage;
/*     */     public float speed;
/* 184 */     public Vector2 startVector = new Vector2();
/* 185 */     public Vector2 endVector = new Vector2();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 191 */       param1Output.writeFloat(this.damage);
/* 192 */       param1Output.writeFloat(this.speed);
/* 193 */       param1Kryo.writeObject(param1Output, this.startVector);
/* 194 */       param1Kryo.writeObject(param1Output, this.endVector);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 199 */       this.damage = param1Input.readFloat();
/* 200 */       this.speed = param1Input.readFloat();
/* 201 */       this.startVector = (Vector2)param1Kryo.readObject(param1Input, Vector2.class);
/* 202 */       this.endVector = (Vector2)param1Kryo.readObject(param1Input, Vector2.class);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\BulletWallAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */