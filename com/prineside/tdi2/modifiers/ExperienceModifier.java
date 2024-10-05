/*     */ package com.prineside.tdi2.modifiers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.MinerResourceChange;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import java.util.Locale;
/*     */ 
/*     */ @REGS
/*     */ public final class ExperienceModifier
/*     */   extends Modifier
/*     */ {
/*     */   private float a;
/*  43 */   public boolean[] minerActive = new boolean[8];
/*  44 */   private OnMinerResourceChange b = new OnMinerResourceChange(this, (byte)0);
/*     */   
/*  46 */   private static final StringBuilder c = new StringBuilder();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  50 */     super.write(paramKryo, paramOutput);
/*  51 */     paramOutput.writeFloat(this.a);
/*  52 */     paramKryo.writeObject(paramOutput, this.minerActive);
/*  53 */     paramKryo.writeObjectOrNull(paramOutput, this.b, OnMinerResourceChange.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  58 */     super.read(paramKryo, paramInput);
/*  59 */     this.a = paramInput.readFloat();
/*  60 */     this.minerActive = (boolean[])paramKryo.readObject(paramInput, boolean[].class);
/*  61 */     this.b = (OnMinerResourceChange)paramKryo.readObjectOrNull(paramInput, OnMinerResourceChange.class);
/*     */   }
/*     */   
/*     */   private ExperienceModifier() {
/*  65 */     super(ModifierType.EXPERIENCE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/*  70 */     super.setRegistered(paramGameSystemProvider);
/*     */     
/*  72 */     this.S.events.getListeners(MinerResourceChange.class).addStateAffecting(this.b).setDescription("Notifies nearby modifiers about the mined resource");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  77 */     this.S.events.getListeners(MinerResourceChange.class).remove(this.b);
/*     */     
/*  79 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(int paramInt1, int paramInt2) {
/*  84 */     if (!this.minerActive[paramInt1])
/*     */       return; 
/*  86 */     Array array = this.S.TSH.getTowerArray();
/*  87 */     this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */           PlatformTile platformTile;
/*     */           
/*     */           if (paramTile instanceof PlatformTile && (platformTile = (PlatformTile)paramTile).building instanceof Tower) {
/*     */             paramArray.add(platformTile.building);
/*     */           }
/*     */           
/*     */           return true;
/*     */         });
/*  96 */     if (array.size != 0 && paramInt2 > 0) {
/*  97 */       float f = this.S.gameValue.getIntValue(GameValueType.MODIFIER_EXPERIENCE_VALUE) / array.size * paramInt2;
/*  98 */       for (byte b = 0; b < array.size; b++) {
/*     */         Tower tower;
/* 100 */         if ((tower = ((Tower[])array.items)[b]).isRegistered()) {
/*     */ 
/*     */ 
/*     */           
/* 104 */           this.S.experience.addExperienceRaw(tower, f);
/*     */           
/* 106 */           this.S.statistics.addStatistic(StatisticsType.XPG_EM, f);
/*     */           
/* 108 */           if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S.gameState.canSkipMediaUpdate())
/* 109 */             this.S._particle.addXpOrbParticle(f, getTile().getX(), getTile().getY(), tower.getTile().getX(), tower.getTile().getY()); 
/*     */         } 
/*     */       } 
/*     */     } 
/* 113 */     this.S.TSH.freeTowerArray(array);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillModifierMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 118 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/* 120 */     Array array1 = new Array(true, 1, Tower.class);
/* 121 */     Array array2 = new Array(true, 1, Miner.class);
/* 122 */     this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */           PlatformTile platformTile;
/*     */           
/*     */           if (paramTile instanceof PlatformTile) {
/*     */             if ((platformTile = (PlatformTile)paramTile).building instanceof Tower) {
/*     */               paramArray1.add(platformTile.building);
/*     */             }
/*     */           } else {
/*     */             SourceTile sourceTile;
/*     */             if (platformTile instanceof SourceTile && (sourceTile = (SourceTile)platformTile).miner != null) {
/*     */               paramArray2.add(sourceTile.miner);
/*     */             }
/*     */           } 
/*     */           return true;
/*     */         });
/* 137 */     int j = 1; int k;
/* 138 */     for (k = 0; k < array2.size; k++) {
/* 139 */       j = j * 31 + (((Miner[])array2.items)[k]).id;
/*     */     }
/* 141 */     for (k = 0; k < array1.size; k++) {
/* 142 */       j = j * 31 + (((Tower[])array1.items)[k]).id;
/*     */     }
/*     */     
/* 145 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(j))) {
/*     */       
/* 147 */       paramGroup.clear();
/*     */ 
/*     */       
/*     */       Group group2;
/*     */ 
/*     */       
/* 153 */       (group2 = new Group()).setTransform(false);
/* 154 */       group2.setSize(288.0F, 288.0F);
/* 155 */       group2.setPosition(156.0F, (i + 150));
/* 156 */       paramGroup.addActor((Actor)group2);
/*     */       
/*     */       Group group1;
/*     */       
/* 160 */       (group1 = new Group()).setTransform(false);
/* 161 */       group1.setPosition(96.0F, 96.0F);
/* 162 */       group1.setSize(96.0F, 96.0F);
/* 163 */       group2.addActor((Actor)group1);
/*     */       
/*     */       Image image1;
/* 166 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tile-type-platform"))).setSize(96.0F, 96.0F);
/* 167 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 168 */       group1.addActor((Actor)image1); Modifier.ConnectionSide[] arrayOfConnectionSide; int m;
/*     */       byte b2;
/* 170 */       for (m = (arrayOfConnectionSide = Modifier.ConnectionSide.values).length, b2 = 0; b2 < m; ) { Modifier.ConnectionSide connectionSide = arrayOfConnectionSide[b2];
/* 171 */         if (this.visuallyConnectedSides[connectionSide.ordinal()]) {
/* 172 */           float[] arrayOfFloat = WIRES_TEXTURES_CONFIG[connectionSide.ordinal()];
/*     */           
/*     */           Image image;
/* 175 */           (image = new Image((Drawable)new TextureRegionDrawable((Game.i.modifierManager.getFactory(this.type)).wires[connectionSide.ordinal()]))).setPosition(48.0F + arrayOfFloat[0] * 0.75F, 48.0F + arrayOfFloat[1] * 0.75F);
/* 176 */           image.setSize(arrayOfFloat[2] * 0.75F, arrayOfFloat[3] * 0.75F);
/* 177 */           group1.addActor((Actor)image);
/*     */         } 
/*     */         b2++; }
/*     */       
/*     */       Image image2;
/* 182 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("modifier-base-experience"))).setSize(96.0F, 96.0F);
/* 183 */       group1.addActor((Actor)image2);
/*     */       
/*     */       Label label1;
/* 186 */       (label1 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(0.0F, 32.0F);
/* 187 */       label1.setSize(96.0F, 32.0F);
/* 188 */       label1.setAlignment(1);
/* 189 */       group1.addActor((Actor)label1);
/*     */ 
/*     */       
/* 192 */       Image[] arrayOfImage1 = new Image[8];
/* 193 */       Label[] arrayOfLabel1 = new Label[8];
/*     */       
/* 195 */       int n = getTile().getX();
/* 196 */       int i1 = getTile().getY(); byte b1;
/* 197 */       for (b1 = 0; b1 < array2.size; b1++) {
/* 198 */         Miner miner = ((Miner[])array2.items)[b1];
/* 199 */         k = n - miner.getTile().getX();
/* 200 */         int i2 = i1 - miner.getTile().getY();
/*     */         
/*     */         Group group;
/* 203 */         (group = new Group()).setTransform(false);
/* 204 */         group.setSize(96.0F, 96.0F);
/* 205 */         group.setPosition(96.0F - k * 96.0F, 96.0F - i2 * 96.0F);
/* 206 */         group2.addActor((Actor)group);
/*     */         
/*     */         Image image;
/* 209 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("tile-type-platform"))).setSize(96.0F, 96.0F);
/* 210 */         image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 211 */         group.addActor((Actor)image);
/*     */ 
/*     */         
/* 214 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-miner-top"))).setSize(48.0F, 48.0F);
/* 215 */         image.setPosition(24.0F, 34.0F);
/* 216 */         group.addActor((Actor)image);
/* 217 */         arrayOfImage1[b1] = image;
/*     */         
/*     */         Label label2;
/* 220 */         (label2 = new Label("", Game.i.assetManager.getLabelStyle(21))).setPosition(0.0F, 12.0F);
/* 221 */         label2.setSize(96.0F, 18.0F);
/* 222 */         label2.setAlignment(1);
/* 223 */         group.addActor((Actor)label2);
/* 224 */         arrayOfLabel1[b1] = label2;
/*     */       } 
/*     */ 
/*     */       
/* 228 */       for (b1 = 0; b1 < array1.size; b1++) {
/* 229 */         Tower tower = ((Tower[])array1.items)[b1];
/* 230 */         k = n - tower.getTile().getX();
/* 231 */         int i2 = i1 - tower.getTile().getY();
/*     */         
/*     */         Group group;
/* 234 */         (group = new Group()).setTransform(false);
/* 235 */         group.setSize(96.0F, 96.0F);
/* 236 */         group.setPosition(96.0F - k * 96.0F, 96.0F - i2 * 96.0F);
/* 237 */         group2.addActor((Actor)group);
/*     */         
/*     */         Image image;
/* 240 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("tile-type-platform"))).setSize(96.0F, 96.0F);
/* 241 */         image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 242 */         group.addActor((Actor)image);
/*     */ 
/*     */         
/* 245 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-tower-top"))).setSize(48.0F, 48.0F);
/* 246 */         image.setPosition(24.0F, 24.0F);
/* 247 */         image.setColor(MaterialColor.LIGHT_BLUE.P500);
/* 248 */         group.addActor((Actor)image);
/*     */       } 
/*     */       
/* 251 */       paramObjectMap.put("state", Integer.valueOf(j));
/* 252 */       paramObjectMap.put("minerIcons", arrayOfImage1);
/* 253 */       paramObjectMap.put("minerLabels", arrayOfLabel1);
/* 254 */       paramObjectMap.put("modifierCooldown", label1);
/*     */     } 
/*     */     
/* 257 */     Image[] arrayOfImage = (Image[])paramObjectMap.get("minerIcons");
/* 258 */     Label[] arrayOfLabel = (Label[])paramObjectMap.get("minerLabels");
/* 259 */     Label label = (Label)paramObjectMap.get("modifierCooldown");
/*     */     
/* 261 */     i = array1.size;
/*     */     
/* 263 */     for (byte b = 0; b < array2.size; b++) {
/* 264 */       Miner miner = ((Miner[])array2.items)[b];
/* 265 */       if (this.minerActive[b]) {
/* 266 */         arrayOfImage[b].setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */       } else {
/* 268 */         arrayOfImage[b].setColor(MaterialColor.ORANGE.P500);
/*     */       } 
/*     */       
/* 271 */       c.setLength(0);
/* 272 */       int m = 0; ResourceType[] arrayOfResourceType; int n; byte b1;
/* 273 */       for (n = (arrayOfResourceType = ResourceType.values).length, b1 = 0; b1 < n; ) { ResourceType resourceType = arrayOfResourceType[b1];
/* 274 */         m += miner.minedResources[resourceType.ordinal()]; b1++; }
/*     */       
/* 276 */       if (m >= i) {
/* 277 */         c.append("[#8BC34A]");
/*     */       } else {
/* 279 */         c.append("[#FF9800]");
/*     */       } 
/* 281 */       c.append(StringFormatter.compactNumber(m, false));
/* 282 */       c.append("[] / [#808080]").append(i).append("[]");
/* 283 */       arrayOfLabel[b].setText((CharSequence)c);
/*     */     } 
/*     */     
/* 286 */     label.setText((CharSequence)StringFormatter.compactNumberWithPrecision(this.a, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 292 */     super.update(paramFloat);
/*     */     
/* 294 */     if (this.S.gameState.isGameRealTimePasses()) {
/*     */       
/* 296 */       this.a -= paramFloat;
/* 297 */       if (this.a <= 0.0F) {
/* 298 */         this.a += 10.0F;
/*     */         
/* 300 */         Array array1 = this.S.TSH.getTowerArray();
/* 301 */         Array array2 = this.S.TSH.getMinerArray();
/* 302 */         this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */               PlatformTile platformTile;
/*     */               
/*     */               if (paramTile instanceof PlatformTile) {
/*     */                 if ((platformTile = (PlatformTile)paramTile).building instanceof Tower) {
/*     */                   paramArray1.add(platformTile.building);
/*     */                 }
/*     */               } else {
/*     */                 SourceTile sourceTile;
/*     */                 if (platformTile instanceof SourceTile && (sourceTile = (SourceTile)platformTile).miner != null) {
/*     */                   paramArray2.add(sourceTile.miner);
/*     */                 }
/*     */               } 
/*     */               return true;
/*     */             });
/*     */         int i;
/* 318 */         if ((i = array1.size) > 0)
/* 319 */           for (byte b = 0; b < array2.size; b++) {
/* 320 */             Miner miner = ((Miner[])array2.items)[b];
/*     */             
/* 322 */             int j = 0; ResourceType[] arrayOfResourceType; int m;
/* 323 */             for (int k = (arrayOfResourceType = ResourceType.values).length; m < k; ) { ResourceType resourceType = arrayOfResourceType[m];
/* 324 */               j += miner.minedResources[resourceType.ordinal()]; m++; }
/*     */             
/* 326 */             if (j < i) {
/*     */               
/* 328 */               this.minerActive[b] = false;
/*     */             } else {
/* 330 */               this.minerActive[b] = true;
/* 331 */               int n = i; ResourceType[] arrayOfResourceType1; byte b1;
/* 332 */               for (m = (arrayOfResourceType1 = ResourceType.values).length, b1 = 0; b1 < m; ) { ResourceType resourceType = arrayOfResourceType1[b1];
/*     */                 int i1;
/* 334 */                 if ((i1 = miner.minedResources[resourceType.ordinal()]) > 0) {
/* 335 */                   i1 = StrictMath.min(i1, n);
/* 336 */                   this.S.miner.removeResources(miner, resourceType, i1);
/*     */                   
/* 338 */                   if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 339 */                     for (byte b2 = 0; b2 < i1; b2++) {
/* 340 */                       this.S._particle.addOrbParticle(ExperienceModifierFactory.a(Game.i.modifierManager.F.EXPERIENCE)[resourceType.ordinal()], 18.0F, miner.getTile().getX(), miner.getTile().getY(), getTile().getX(), getTile().getY());
/*     */                     }
/*     */                   }
/*     */ 
/*     */                   
/* 345 */                   if ((n = n - i1) != 0)
/*     */                     continue;  break;
/*     */                 } 
/*     */                 continue;
/*     */                 b1++; }
/*     */             
/*     */             } 
/*     */           }  
/* 353 */         this.S.TSH.freeTowerArray(array1);
/* 354 */         this.S.TSH.freeMinerArray(array2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnMinerResourceChange
/*     */     implements KryoSerializable, Listener<MinerResourceChange> {
/*     */     private ExperienceModifier a;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 365 */       param1Kryo.writeObjectOrNull(param1Output, this.a, ExperienceModifier.class);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 370 */       this.a = (ExperienceModifier)param1Kryo.readObjectOrNull(param1Input, ExperienceModifier.class);
/*     */     }
/*     */     
/*     */     @Deprecated
/*     */     private OnMinerResourceChange() {}
/*     */     
/*     */     private OnMinerResourceChange(ExperienceModifier param1ExperienceModifier) {
/* 377 */       this.a = param1ExperienceModifier;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(MinerResourceChange param1MinerResourceChange) {
/* 382 */       if (!param1MinerResourceChange.isMined())
/*     */         return; 
/* 384 */       Miner miner = param1MinerResourceChange.getMiner();
/* 385 */       ResourceType resourceType = param1MinerResourceChange.getResourceType();
/* 386 */       int i = param1MinerResourceChange.getDelta();
/*     */       
/* 388 */       Array array = this.a.S.TSH.getMinerArray();
/* 389 */       this.a.S.map.traverseNeighborTilesAroundTile((Tile)this.a.getTile(), param1Tile -> {
/*     */             SourceTile sourceTile;
/*     */             
/*     */             if (param1Tile instanceof SourceTile && (sourceTile = (SourceTile)param1Tile).miner != null) {
/*     */               param1Array.add(sourceTile.miner);
/*     */             }
/*     */             
/*     */             return true;
/*     */           });
/*     */       
/* 399 */       for (byte b = 0; b < array.size; b++) {
/* 400 */         if (((Miner[])array.items)[b] == miner) {
/*     */           
/* 402 */           ExperienceModifier.a(this.a, b, resourceType, i);
/*     */           return;
/*     */         } 
/*     */       } 
/* 406 */       this.a.S.TSH.freeMinerArray(array);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ExperienceModifierFactory
/*     */     extends Modifier.Factory<ExperienceModifier> {
/*     */     private TextureRegion c;
/* 413 */     private TextureRegion[] d = new TextureRegion[ResourceType.values.length];
/*     */     
/*     */     public ExperienceModifierFactory() {
/* 416 */       super(ModifierType.EXPERIENCE, MaterialColor.CYAN.P500, "icon-experience-generation-lite");
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 421 */       int i = param1GameValueProvider.getIntValue(GameValueType.MODIFIER_EXPERIENCE_VALUE);
/*     */       
/* 423 */       return Game.i.localeManager.i18n.format("modifier_description_EXPERIENCE", new Object[] { Integer.valueOf(i), Integer.valueOf(10) });
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int) {
/* 428 */       return a((int)(100.0F * (float)StrictMath.pow(1.5D, param1Int)));
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 433 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-base-experience");
/* 434 */       Game.i.assetManager.getTextureRegion("xp-orb"); ResourceType[] arrayOfResourceType; int i;
/*     */       byte b;
/* 436 */       for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 437 */         this.d[resourceType.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("resource-orb-" + resourceType.name().toLowerCase(Locale.ENGLISH));
/*     */         b++; }
/*     */     
/*     */     }
/*     */     
/*     */     public TextureRegion getBaseTexture() {
/* 443 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public ExperienceModifier create() {
/* 448 */       return new ExperienceModifier((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\ExperienceModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */