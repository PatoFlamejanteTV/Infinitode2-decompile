/*     */ package com.prineside.tdi2.modifiers;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ @REGS
/*     */ public final class PowerModifier extends Modifier {
/*     */   private float a;
/*     */   private static final Comparator<Tower> b;
/*     */   
/*     */   static {
/*  26 */     b = ((paramTower1, paramTower2) -> Float.compare(paramTower2.experience, paramTower1.experience));
/*     */   }
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  30 */     super.write(paramKryo, paramOutput);
/*  31 */     paramOutput.writeFloat(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  36 */     super.read(paramKryo, paramInput);
/*  37 */     this.a = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private PowerModifier() {
/*  41 */     super(ModifierType.POWER);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean connectsToMiners() {
/*  46 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  51 */     super.update(paramFloat);
/*     */     
/*  53 */     this.a += paramFloat;
/*     */     
/*  55 */     if (this.a >= 1.0F) {
/*  56 */       this.a--;
/*     */       
/*  58 */       Array array = this.S.TSH.getTowerArray();
/*  59 */       this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */             PlatformTile platformTile;
/*     */             
/*     */             if (paramTile instanceof PlatformTile && (platformTile = (PlatformTile)paramTile).building instanceof Tower) {
/*     */               paramArray.add(platformTile.building);
/*     */             }
/*     */             
/*     */             return true;
/*     */           });
/*     */       
/*  69 */       float f = array.size;
/*  70 */       this.S.TSH.sort.sort(array, b);
/*  71 */       for (byte b = 0; b < array.size; b++) {
/*     */         Tower tower;
/*  73 */         if ((tower = (Tower)array.get(b)).isRegistered()) {
/*     */           float f1;
/*     */ 
/*     */           
/*  77 */           if ((f1 = StrictMath.min(f, tower.currentLevelExperience)) != 0.0F) {
/*  78 */             f -= f1;
/*  79 */             this.S.experience.removeExperienceRaw(tower, f1);
/*     */             
/*  81 */             if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*  82 */               for (byte b1 = 0; b1 < f1; b1++) {
/*  83 */                 this.S._particle.addOrbParticle(PowerModifierFactory.a(Game.i.modifierManager.F.POWER), 12.0F, tower.getTile().getX(), tower.getTile().getY(), getTile().getX(), getTile().getY());
/*     */               }
/*     */             }
/*  86 */             if (f != 0.0F)
/*     */               continue;  break;
/*     */           } 
/*     */         }  continue;
/*  90 */       }  this.S.TSH.freeTowerArray(array);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class PowerModifierFactory
/*     */     extends Modifier.Factory<PowerModifier>
/*     */   {
/*     */     private TextureRegion c;
/*     */     private TextureRegion d;
/*     */     
/*     */     public PowerModifierFactory() {
/* 101 */       super(ModifierType.POWER, MaterialColor.PINK.P500, "icon-power");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int) {
/* 106 */       return a((int)(100.0F * (float)StrictMath.pow(1.5D, param1Int)));
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 111 */       float f = MathUtils.round((float)(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.MODIFIER_POWER_VALUE) * 1000.0D)) * 0.1F;
/*     */       
/* 113 */       return Game.i.localeManager.i18n.format("modifier_description_POWER", new Object[] { Float.valueOf(f) });
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getBaseTexture() {
/* 118 */       return this.c;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 124 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-base-power");
/* 125 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("xp-orb");
/*     */     }
/*     */ 
/*     */     
/*     */     public PowerModifier create() {
/* 130 */       return new PowerModifier((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\PowerModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */