/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.Intersector;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public abstract class EnemyFollowingProjectile
/*     */   extends Projectile {
/*     */   public static final float RAYCAST_INTERVAL_FOLLOWING_MIN = 96.0F;
/*     */   public static final float RAYCAST_INTERVAL_FOLLOWING_MIN_SQR = 9216.0F;
/*     */   
/*     */   static {
/*  28 */     TLog.forClass(EnemyFollowingProjectile.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final float DEFAULT_MAX_ROT_SPEED = 0.0F;
/*     */   
/*     */   public static final float DEFAULT_MAX_ROT_SPEED_DYNAMIC = 120.0F;
/*  35 */   private Enemy.EnemyReference d = Enemy.EnemyReference.NULL;
/*     */ 
/*     */   
/*     */   public float speed;
/*     */   
/*     */   public float maxRotationSpeed;
/*     */   
/*     */   public float maxRotationSpeedDynamic;
/*     */   
/*     */   protected boolean a;
/*     */   
/*  46 */   protected Vector2 b = new Vector2();
/*     */   
/*     */   private float e;
/*  49 */   private float f = 0.0F;
/*  50 */   private float g = 0.0F;
/*     */   
/*     */   private float h;
/*     */   private float i;
/*     */   @NAGS
/*  55 */   public Vector2 drawPosition = new Vector2();
/*     */   @NAGS
/*     */   public float drawAngle;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  60 */     super.write(paramKryo, paramOutput);
/*     */     
/*  62 */     paramKryo.writeObject(paramOutput, this.d);
/*  63 */     paramOutput.writeFloat(this.speed);
/*  64 */     paramOutput.writeFloat(this.maxRotationSpeed);
/*  65 */     paramOutput.writeFloat(this.maxRotationSpeedDynamic);
/*  66 */     paramOutput.writeBoolean(this.a);
/*  67 */     paramKryo.writeObject(paramOutput, this.b);
/*  68 */     paramOutput.writeFloat(this.e);
/*  69 */     paramOutput.writeFloat(this.f);
/*  70 */     paramOutput.writeFloat(this.g);
/*  71 */     paramKryo.writeObject(paramOutput, this.position);
/*  72 */     paramOutput.writeFloat(this.h);
/*  73 */     paramOutput.writeFloat(this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  78 */     super.read(paramKryo, paramInput);
/*     */     
/*  80 */     this.d = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  81 */     this.speed = paramInput.readFloat();
/*  82 */     this.maxRotationSpeed = paramInput.readFloat();
/*  83 */     this.maxRotationSpeedDynamic = paramInput.readFloat();
/*  84 */     this.a = paramInput.readBoolean();
/*  85 */     this.b = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  86 */     this.e = paramInput.readFloat();
/*  87 */     this.f = paramInput.readFloat();
/*  88 */     this.g = paramInput.readFloat();
/*  89 */     this.position = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  90 */     this.h = paramInput.readFloat();
/*  91 */     this.i = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   protected EnemyFollowingProjectile(ProjectileType paramProjectileType) {
/*  95 */     super(paramProjectileType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setup(Vector2 paramVector2, Enemy paramEnemy, float paramFloat) {
/* 102 */     float f = PMath.getAngleBetweenPoints(paramVector2, paramEnemy.getPosition());
/*     */     
/* 104 */     setup(paramVector2, paramEnemy, f, paramFloat, 0.0F, 120.0F);
/*     */   }
/*     */   
/*     */   protected void setup(Vector2 paramVector2, Enemy paramEnemy, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 108 */     setup();
/*     */     
/* 110 */     setTarget(paramEnemy);
/*     */ 
/*     */     
/* 113 */     this.speed = paramFloat2 * 128.0F;
/* 114 */     this.maxRotationSpeed = paramFloat3;
/* 115 */     this.maxRotationSpeedDynamic = paramFloat4;
/*     */     
/* 117 */     this.e = paramEnemy.getSize();
/* 118 */     this.b.set(paramEnemy.getPosition());
/* 119 */     this.a = false;
/*     */     
/* 121 */     this.position.set(paramVector2);
/* 122 */     this.f = paramVector2.x;
/* 123 */     this.g = paramVector2.y;
/*     */     
/* 125 */     this.h = paramFloat1;
/* 126 */     this.i = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getTimeExists() {
/* 132 */     return this.i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enemy getTarget() {
/* 139 */     return this.d.enemy;
/*     */   }
/*     */   
/*     */   public void setTarget(Enemy paramEnemy) {
/* 143 */     this.d = this.S.enemy.getReference(paramEnemy);
/*     */   }
/*     */ 
/*     */   
/*     */   public void applyDrawInterpolation(float paramFloat) {
/* 148 */     if (paramFloat == 0.0F) {
/* 149 */       this.drawPosition.set(this.position);
/* 150 */       this.drawAngle = this.h; return;
/*     */     } 
/* 152 */     this.drawAngle = a(paramFloat);
/* 153 */     Vector2 vector2 = new Vector2();
/* 154 */     paramFloat = this.speed * paramFloat;
/* 155 */     vector2.set(paramFloat, 0.0F);
/* 156 */     vector2.rotateDeg(this.drawAngle + 90.0F);
/* 157 */     this.drawPosition.set(this.position).add(vector2);
/*     */   }
/*     */ 
/*     */   
/*     */   private float a(float paramFloat) {
/* 162 */     float f1 = PMath.getAngleBetweenPoints(this.position, this.b);
/* 163 */     if (this.maxRotationSpeed == 0.0F) {
/* 164 */       return f1;
/*     */     }
/*     */     
/* 167 */     paramFloat = this.maxRotationSpeed * paramFloat;
/* 168 */     float f2 = PMath.getDistanceBetweenAngles(this.h, f1);
/* 169 */     f1 = f1;
/* 170 */     if (StrictMath.abs(f2) > paramFloat) {
/* 171 */       f1 = this.h + f2 * paramFloat / StrictMath.abs(f2);
/*     */     }
/*     */     
/* 174 */     return f1 % 360.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void flyOnEnemy(Enemy paramEnemy) {
/* 179 */     setTarget(paramEnemy);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnregistered() {
/* 184 */     this.d = Enemy.EnemyReference.NULL;
/* 185 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 190 */     super.reset();
/*     */     
/* 192 */     this.d = Enemy.EnemyReference.NULL;
/* 193 */     this.speed = 0.0F;
/* 194 */     this.e = 0.0F;
/* 195 */     this.h = 0.0F;
/* 196 */     this.i = 0.0F;
/* 197 */     this.drawAngle = 0.0F;
/* 198 */     this.maxRotationSpeed = 0.0F;
/* 199 */     this.maxRotationSpeedDynamic = 120.0F;
/* 200 */     this.a = false;
/*     */     
/* 202 */     this.b.setZero();
/* 203 */     this.f = 0.0F;
/* 204 */     this.g = 0.0F;
/* 205 */     this.drawPosition.setZero();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 getPosition() {
/* 213 */     return this.position;
/*     */   }
/*     */   
/*     */   private void b(float paramFloat) {
/* 217 */     float f1 = a(paramFloat);
/*     */     
/* 219 */     float f2 = paramFloat * this.speed;
/*     */     
/* 221 */     float f3 = (f1 + 90.0F) * 0.017453292F;
/* 222 */     float f4 = f2 * MathUtils.cos(f3);
/* 223 */     f2 *= MathUtils.sin(f3);
/*     */     
/* 225 */     this.position.add(f4, f2);
/*     */     
/* 227 */     this.h = f1;
/*     */ 
/*     */     
/* 230 */     if ((f1 = this.position.dst2(this.b)) < 9216.0F) {
/*     */       
/* 232 */       float f5 = this.b.x - this.e, f6 = this.b.y - this.e, f7 = this.b.x + this.e, f8 = this.b.y + this.e;
/* 233 */       if (this.f < this.position.x) {
/* 234 */         f1 = this.f;
/* 235 */         f3 = this.position.x;
/*     */       } else {
/* 237 */         f1 = this.position.x;
/* 238 */         f3 = this.f;
/*     */       } 
/* 240 */       if (this.g < this.position.y) {
/* 241 */         f2 = this.g;
/* 242 */         f4 = this.position.y;
/*     */       } else {
/* 244 */         f2 = this.position.y;
/* 245 */         f4 = this.g;
/*     */       } 
/*     */       
/* 248 */       if (Intersector.rectanglesOverlap(f1, f2, f3, f4, f5, f6, f7, f8) && Intersector.intersectSegmentCircle(this.f, this.g, this.position.x, this.position.y, this.b.x, this.b.y, this.e * this.e) && 
/* 249 */         !this.a) {
/* 250 */         this.a = true;
/* 251 */         hit();
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 260 */     this.f = this.position.x;
/* 261 */     this.g = this.position.y;
/*     */     
/* 263 */     this.i += paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 268 */     if (this.i > 20.0F && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_PROBLEMATIC_PROJECTILES) != 0.0D) {
/*     */       StringBuilder stringBuilder;
/* 270 */       (stringBuilder = new StringBuilder()).append("MR:").append((int)this.maxRotationSpeed);
/*     */       
/* 272 */       paramBatch.setColor(MaterialColor.LIME.P500);
/* 273 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle, this.f - 3.0F, this.g - 3.0F, 6.0F, 6.0F);
/* 274 */       DrawUtils.texturedLineB(paramBatch, (TextureRegion)(AssetManager.TextureRegions.i()).blank, this.f, this.g, this.position.x, this.position.y, 1.0F);
/* 275 */       paramBatch.setColor(Color.PURPLE);
/* 276 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle, this.b.x - this.e, this.b.y - this.e, this.e * 2.0F, this.e * 2.0F);
/* 277 */       paramBatch.setColor(Color.WHITE);
/*     */       
/*     */       float f;
/* 280 */       if ((f = this.position.dst2(this.b)) < 9216.0F) {
/* 281 */         stringBuilder.append(" C+");
/*     */       } else {
/* 283 */         stringBuilder.append(" C-/").append((int)Math.sqrt(f)).append("/96.0");
/*     */       } 
/*     */       
/*     */       BitmapFont bitmapFont;
/* 287 */       (bitmapFont = Game.i.assetManager.getSmallDebugFont()).draw(paramBatch, stringBuilder, this.position.x, this.position.y);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/*     */     Enemy enemy;
/* 294 */     if ((enemy = getTarget()) != null) {
/* 295 */       this.b.set(enemy.getPosition());
/* 296 */       this.e = enemy.getSize();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 302 */     if (this.maxRotationSpeed != 0.0F) {
/* 303 */       this.maxRotationSpeed += paramFloat * this.maxRotationSpeedDynamic;
/* 304 */       if (this.maxRotationSpeed > 5400.0F) {
/* 305 */         this.maxRotationSpeed = 0.0F;
/*     */       }
/*     */     } 
/* 308 */     b(paramFloat);
/*     */   }
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
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 323 */     return (this.a || this.i > 120.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasReachedTarget() {
/* 328 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 333 */     return super.toString() + " (target: " + this.d + ", speed: " + this.speed + ", reachedTarget: " + this.a + ", lastRayCastPosition: " + this.f + ":" + this.g + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\EnemyFollowingProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */