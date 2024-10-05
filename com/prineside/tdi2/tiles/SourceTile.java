/*     */ package com.prineside.tdi2.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.Resource;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.ui.components.TileResources;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public final class SourceTile extends Tile {
/*  59 */   private static final TLog c = TLog.forClass(SourceTile.class);
/*     */ 
/*     */   
/*     */   private static final Color d;
/*     */   
/*  64 */   private static final Color e = d = new Color(858993663);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   private float f = 1.0F;
/*  70 */   private int[] g = new int[ResourceType.values.length]; public Miner miner;
/*     */   @NAGS
/*     */   private boolean h = true;
/*     */   @NAGS
/*  74 */   private final Color[] i = new Color[8]; @NAGS
/*  75 */   private final int[] j = new int[8];
/*     */   
/*  77 */   private static final float[] k = new float[ResourceType.values.length];
/*  78 */   private static final ResourceAmount[] l = new ResourceAmount[ResourceType.values.length];
/*     */   static {
/*  80 */     for (byte b = 0; b < l.length; b++) {
/*  81 */       l[b] = new ResourceAmount((byte)0);
/*     */     }
/*     */   }
/*     */   
/*  85 */   public int[] minedResources = new int[ResourceType.values.length];
/*     */   
/*  87 */   private static final StringBuilder m = new StringBuilder();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  91 */     super.write(paramKryo, paramOutput);
/*  92 */     paramOutput.writeFloat(this.f);
/*  93 */     paramKryo.writeObject(paramOutput, this.g);
/*  94 */     paramKryo.writeObject(paramOutput, this.minedResources);
/*  95 */     paramKryo.writeClassAndObject(paramOutput, this.miner);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 100 */     super.read(paramKryo, paramInput);
/* 101 */     this.f = paramInput.readFloat();
/* 102 */     this.g = (int[])paramKryo.readObject(paramInput, int[].class);
/* 103 */     this.minedResources = (int[])paramKryo.readObject(paramInput, int[].class);
/* 104 */     this.miner = (Miner)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   private SourceTile() {
/* 108 */     super(TileType.SOURCE);
/*     */     
/* 110 */     Arrays.fill((Object[])this.i, Color.WHITE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/* 115 */     super.setUnregistered();
/*     */     
/* 117 */     this.miner = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/* 122 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/*     */     TileResources tileResources;
/* 125 */     (tileResources = new TileResources(352.0F)).setTile(this);
/* 126 */     paramTable.add((Actor)tileResources).row();
/*     */     
/* 128 */     if (paramMapEditorItemInfoMenu.isSelectionFromInventory())
/*     */       return; 
/* 130 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/*     */       Label label;
/*     */       
/* 133 */       (label = new Label("Miner type", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 134 */       paramTable.add((Actor)label).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */       
/*     */       SelectBox selectBox;
/* 137 */       (selectBox = new SelectBox(paramMapEditorItemInfoMenu.selectBoxStyle)).setName("map_editor_menu_miner_type_select");
/*     */       Array array;
/* 139 */       (array = new Array()).add("No miner");
/* 140 */       for (byte b = 0; b < MinerType.values.length; b++) {
/* 141 */         array.add(MinerType.values[b].name());
/*     */       }
/* 143 */       selectBox.setItems(array);
/* 144 */       paramTable.add((Actor)selectBox).height(48.0F).padBottom(8.0F).growX().row();
/*     */       
/* 146 */       if (this.miner != null) {
/* 147 */         selectBox.setSelected(this.miner.type.name());
/*     */       } else {
/* 149 */         selectBox.setSelected("No miner");
/*     */       } 
/* 151 */       selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramMapEditorItemInfoMenu)
/*     */           {
/*     */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */               String str;
/* 155 */               if ((str = (String)this.a.getSelected()).equals("No miner")) {
/* 156 */                 if (this.c.miner != null) {
/* 157 */                   this.c.miner.setTile(null);
/* 158 */                   this.c.miner = null;
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 163 */                 if (this.c.miner != null) {
/* 164 */                   this.c.miner.setTile(null);
/*     */                 }
/* 166 */                 this.c.miner = Game.i.minerManager.getFactory(MinerType.valueOf(str)).create();
/* 167 */                 this.c.miner.setTile(this.c);
/*     */               } 
/* 169 */               this.b.notifySelectedElementChanged();
/* 170 */               this.b.update();
/*     */             }
/*     */           });
/*     */       
/* 174 */       if (this.miner != null) {
/*     */         Label label1;
/*     */         
/* 177 */         (label1 = new Label("Upgrade level", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 178 */         paramTable.add((Actor)label1).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */         
/*     */         SelectBox selectBox1;
/* 181 */         (selectBox1 = new SelectBox(paramMapEditorItemInfoMenu.selectBoxStyle)).setName("map_editor_menu_source_upgrade_level_select");
/* 182 */         array = new Array();
/* 183 */         for (byte b1 = 0; b1 <= 10; b1++) {
/* 184 */           array.add(String.valueOf(b1));
/*     */         }
/* 186 */         selectBox1.setItems(array);
/* 187 */         paramTable.add((Actor)selectBox1).height(48.0F).padBottom(8.0F).growX().row();
/*     */         
/* 189 */         selectBox1.setSelected(String.valueOf(this.miner.getUpgradeLevel()));
/*     */         
/* 191 */         selectBox1.addListener((EventListener)new ChangeListener(this, selectBox1, paramMapEditorItemInfoMenu)
/*     */             {
/*     */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 194 */                 String str = (String)this.a.getSelected();
/* 195 */                 this.c.miner.setUpgradeLevel(Integer.parseInt(str));
/*     */                 
/* 197 */                 this.b.notifySelectedElementChanged();
/* 198 */                 this.b.update();
/*     */               }
/*     */             });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*     */     TileResources tileResources;
/* 208 */     (tileResources = new TileResources(paramFloat)).setTile(this);
/* 209 */     paramTable.add((Actor)tileResources).width(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int generateSeedSalt() {
/* 214 */     int i = MathUtils.floor(this.f * 100.0F); ResourceType[] arrayOfResourceType; int j; byte b;
/* 215 */     for (j = (arrayOfResourceType = ResourceType.values).length, b = 0; b < j; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 216 */       i = (int)(i + StrictMath.pow(10.0D, resourceType.ordinal()) * this.g[resourceType.ordinal()]);
/*     */       b++; }
/*     */     
/* 219 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDepleted() {
/* 227 */     if (this.S != null && this.S.gameState != null && this.S.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/* 228 */       for (byte b = 0; b < ResourceType.values.length; b++) {
/* 229 */         ResourceType resourceType = ResourceType.values[b];
/*     */         int i;
/* 231 */         if ((i = getResourcesCount(resourceType)) > 0)
/*     */         {
/* 233 */           if (this.minedResources[b] < i)
/* 234 */             return false; 
/*     */         }
/*     */       } 
/* 237 */       return true;
/*     */     } 
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/* 245 */     if (paramItemSortingType == ItemSortingType.RARITY) {
/* 246 */       int j = 0; ResourceType[] arrayOfResourceType; int k;
/*     */       byte b;
/* 248 */       for (k = (arrayOfResourceType = ResourceType.values).length, b = 0; b < k; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 249 */         j += (resourceType.ordinal() + 1) * 5 * this.g[resourceType.ordinal()];
/*     */         b++; }
/*     */       
/* 252 */       j = (int)(j * this.f);
/*     */       
/* 254 */       return getRarity().ordinal() * 1000 + j;
/*     */     } 
/* 256 */     for (int i = ResourceType.values.length - 1; i >= 0; i--) {
/* 257 */       if (this.g[i] != 0) {
/* 258 */         return i;
/*     */       }
/*     */     } 
/* 261 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 267 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 272 */     if (this.g[ResourceType.INFIAR.ordinal()] != 0) {
/* 273 */       return RarityType.LEGENDARY;
/*     */     }
/* 275 */     if (this.g[ResourceType.TENSOR.ordinal()] != 0) {
/* 276 */       return RarityType.EPIC;
/*     */     }
/* 278 */     if (this.g[ResourceType.MATRIX.ordinal()] != 0) {
/* 279 */       return RarityType.VERY_RARE;
/*     */     }
/* 281 */     if (this.g[ResourceType.VECTOR.ordinal()] != 0) {
/* 282 */       return RarityType.RARE;
/*     */     }
/*     */     
/* 285 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 290 */     return ItemSubcategoryType.ME_SOURCES;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 295 */     super.from(paramTile);
/*     */     
/* 297 */     System.arraycopy(((SourceTile)(paramTile = paramTile)).g, 0, this.g, 0, this.g.length);
/* 298 */     this.f = ((SourceTile)paramTile).f;
/* 299 */     this.miner = (((SourceTile)paramTile).miner == null) ? null : ((SourceTile)paramTile).miner.cloneMiner();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 304 */     if (this.miner != null && this.miner.isRegistered()) {
/* 305 */       this.miner.updateCache();
/*     */     }
/*     */   }
/*     */   
/*     */   public final float getResourceDensity() {
/* 310 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void setResourceDensity(float paramFloat) {
/* 314 */     this.f = paramFloat;
/* 315 */     this.h = true;
/*     */   }
/*     */   
/*     */   public final int getResourcesCount(ResourceType paramResourceType) {
/* 319 */     return this.g[paramResourceType.ordinal()];
/*     */   }
/*     */   
/*     */   public final void setResourcesCount(ResourceType paramResourceType, int paramInt) {
/* 323 */     this.g[paramResourceType.ordinal()] = paramInt;
/* 324 */     this.h = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/* 331 */     this.h = false;
/*     */     
/*     */     float f1;
/* 334 */     if ((f1 = 1.0F - this.f) < 0.0F) f1 = 0.0F;
/*     */     
/* 336 */     int i = 0; ResourceType[] arrayOfResourceType; int j, k;
/* 337 */     for (j = (arrayOfResourceType = ResourceType.values).length, k = 0; k < j; ) { ResourceType resourceType = arrayOfResourceType[k];
/* 338 */       i += this.g[resourceType.ordinal()];
/*     */       k++; }
/*     */     
/* 341 */     if (i == 0) {
/*     */       
/* 343 */       for (byte b = 0; b < 8; b++) {
/* 344 */         this.i[b] = d;
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     byte b1;
/* 351 */     for (b1 = 0; b1 < ResourceType.values.length; b1++) {
/* 352 */       (l[b1]).a = ResourceType.values[b1];
/* 353 */       (l[b1]).b = this.g[b1] / i;
/*     */     } 
/* 355 */     for (b1 = 0; b1 < 8; b1++) {
/* 356 */       this.j[b1] = b1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 361 */     for (b1 = 0; b1 < ResourceType.values.length; b1++) {
/* 362 */       if ((l[b1]).b != 0.0F && (l[b1]).b < 0.125F) {
/*     */         
/* 364 */         float f4 = 0.125F - (l[b1]).b;
/* 365 */         float f5 = 0.0F;
/*     */         
/* 367 */         for (byte b = 0; b < ResourceType.values.length; b++) {
/* 368 */           if ((l[b]).b > 0.125F) {
/* 369 */             k[b] = (l[b]).b - 0.125F;
/* 370 */             f5 += k[b];
/*     */           } else {
/* 372 */             k[b] = 0.0F;
/*     */           } 
/*     */         } 
/*     */         
/* 376 */         float f6 = 1.0F - (f5 - f4) / f5;
/* 377 */         for (i = 0; i < ResourceType.values.length; i++) {
/* 378 */           if (k[i] != 0.0F) {
/* 379 */             (l[i]).b -= k[i] * f6;
/*     */           }
/*     */         } 
/*     */         
/* 383 */         (l[b1]).b = 0.125F;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 388 */     for (b1 = 0; b1 < ResourceType.values.length; b1++) {
/* 389 */       for (j = b1 + 1; j < ResourceType.values.length; j++) {
/* 390 */         if ((l[b1]).b < (l[j]).b) {
/* 391 */           ResourceAmount resourceAmount = l[b1];
/* 392 */           l[b1] = l[j];
/* 393 */           l[j] = resourceAmount;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 399 */     float f2 = f1;
/* 400 */     for (j = 0; j < ResourceType.values.length; j++) {
/* 401 */       (l[j]).c = f2;
/* 402 */       f2 += (l[j]).b * this.f;
/*     */     } 
/*     */ 
/*     */     
/* 406 */     for (j = 0; j < 8; j++) {
/* 407 */       k = FastRandom.getInt(8);
/* 408 */       int m = this.j[j];
/* 409 */       this.j[j] = this.j[k];
/* 410 */       this.j[k] = m;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 415 */     float f3 = 0.0F;
/* 416 */     for (byte b2 = 0; b2 < 8; b2++) {
/* 417 */       i = -1;
/* 418 */       for (byte b = 0; b < ResourceType.values.length; b++) {
/* 419 */         if (f3 >= (l[b]).c) {
/* 420 */           i = b;
/*     */         }
/*     */       } 
/*     */       
/* 424 */       if (i == -1) {
/* 425 */         this.i[this.j[b2]] = d;
/*     */       } else {
/* 427 */         this.i[this.j[b2]] = Game.i.resourceManager.getColor((l[i]).a);
/*     */       } 
/*     */       
/* 430 */       f3 += 0.125F;
/*     */     } 
/*     */ 
/*     */     
/* 434 */     if (this.i[0] == d) {
/* 435 */       ResourceType resourceType = null;
/* 436 */       for (i = 0; i < ResourceType.values.length; i++) {
/* 437 */         if (this.g[i] != 0) {
/* 438 */           resourceType = ResourceType.values[i];
/*     */           break;
/*     */         } 
/*     */       } 
/* 442 */       if (resourceType != null) {
/* 443 */         this.i[0] = Game.i.resourceManager.getColor(resourceType);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 450 */     float f = 0.0F; int i;
/* 451 */     for (i = 0; i < this.g.length; i++) {
/* 452 */       f += this.g[i] * (0.1F + i * 0.02F);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 457 */     if ((i = MathUtils.ceil(f = (0.25F + this.f * 0.75F) * f)) <= 0) i = 1; 
/* 458 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, i)); ResourceType[] arrayOfResourceType;
/*     */     byte b;
/* 460 */     for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/*     */       int j;
/* 462 */       if ((j = this.g[resourceType.ordinal()] / 5) > 0) {
/* 463 */         paramArray.add(new ItemStack((Item)Item.D.F_RESOURCE.create(resourceType), j));
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 471 */     double d = 0.002D;
/* 472 */     byte b1 = 0; ResourceType[] arrayOfResourceType; int i; byte b2;
/* 473 */     for (i = (arrayOfResourceType = ResourceType.values).length, b2 = 0; b2 < i; ) { ResourceType resourceType = arrayOfResourceType[b2];
/* 474 */       if (this.g[resourceType.ordinal()] > 0) {
/* 475 */         b1++;
/*     */         
/* 477 */         double d1 = this.g[resourceType.ordinal()] * 0.01D;
/* 478 */         switch (null.a[resourceType.ordinal()]) {
/*     */           case 1:
/* 480 */             d1 *= 0.05D;
/*     */             break;
/*     */           case 2:
/* 483 */             d1 *= 0.075D;
/*     */             break;
/*     */           case 3:
/* 486 */             d1 *= 0.116D;
/*     */             break;
/*     */           case 4:
/* 489 */             d1 *= 0.197D;
/*     */             break;
/*     */           case 5:
/* 492 */             d1 *= 0.355D;
/*     */             break;
/*     */         } 
/*     */         
/* 496 */         d += d1;
/*     */       } 
/*     */       
/*     */       b2++; }
/*     */     
/* 501 */     if (b1 >= 5) {
/* 502 */       d *= 0.30000001192092896D;
/* 503 */     } else if (b1 >= 4) {
/* 504 */       d *= 0.3499999940395355D;
/* 505 */     } else if (b1 >= 3) {
/* 506 */       d *= 0.44999998807907104D;
/* 507 */     } else if (b1 >= 2) {
/* 508 */       d *= 0.75D;
/*     */     } 
/*     */     
/* 511 */     return d * (this.f + 1.0F) * 0.5D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeUpgraded() {
/* 516 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 521 */     super.toJson(paramJson);
/*     */     
/* 523 */     paramJson.writeObjectStart("d");
/* 524 */     paramJson.writeValue("rd", Float.valueOf(this.f));
/* 525 */     paramJson.writeArrayStart("r"); ResourceType[] arrayOfResourceType; int i; byte b;
/* 526 */     for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 527 */       if (this.g[resourceType.ordinal()] > 0) {
/* 528 */         paramJson.writeObjectStart();
/* 529 */         paramJson.writeValue("t", resourceType.name());
/* 530 */         paramJson.writeValue("a", Integer.valueOf(this.g[resourceType.ordinal()]));
/* 531 */         paramJson.writeObjectEnd();
/*     */       }  b++; }
/*     */     
/* 534 */     paramJson.writeArrayEnd();
/* 535 */     paramJson.writeObjectEnd();
/*     */     
/* 537 */     if (this.miner != null) {
/* 538 */       paramJson.writeObjectStart("miner");
/* 539 */       this.miner.toJson(paramJson);
/* 540 */       paramJson.writeObjectEnd();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAsWithExtras(Tile paramTile) {
/* 546 */     if (!sameAs(paramTile)) return false; 
/* 547 */     paramTile = paramTile;
/* 548 */     if (this.miner == null) {
/* 549 */       return (((SourceTile)paramTile).miner == null);
/*     */     }
/* 551 */     return this.miner.sameAs(((SourceTile)paramTile).miner);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final SourceTile removeExtrasForInventory() {
/* 557 */     this.miner = null;
/* 558 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 563 */     if (!super.sameAs(paramTile)) return false;
/*     */     
/* 565 */     paramTile = paramTile;
/* 566 */     if (getResourceDensity() != paramTile.getResourceDensity()) return false;  ResourceType[] arrayOfResourceType; int i;
/*     */     byte b;
/* 568 */     for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 569 */       if (getResourcesCount(resourceType) != paramTile.getResourcesCount(resourceType)) return false; 
/*     */       b++; }
/*     */     
/* 572 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 577 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */     
/* 579 */     paramBatch.draw(Game.i.tileManager.F.SOURCE.a, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawExtras(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 584 */     if (this.h) a(); 
/* 585 */     for (byte b = 0; b < 8; b++) {
/* 586 */       if (paramDrawMode == MapRenderingSystem.DrawMode.FULL || this.miner == null) {
/* 587 */         paramBatch.setColor(this.i[b]);
/*     */       } else {
/* 589 */         paramBatch.setColor(e);
/*     */       } 
/* 591 */       paramBatch.draw(Game.i.tileManager.F.SOURCE.b[b], paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     } 
/* 593 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postDrawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {
/* 598 */     paramFloat1 = paramFloat4 * 0.0078125F;
/* 599 */     paramFloat4 = paramFloat5 * 0.0078125F;
/*     */     
/* 601 */     if (isDepleted()) {
/*     */ 
/*     */ 
/*     */       
/* 605 */       paramBatch.setColor(MaterialColor.ORANGE.P300);
/* 606 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).iconPickaxe, (paramFloat2 + 128.0F - 32.0F - 6.4F) * paramFloat1, (paramFloat3 + 6.4F) * paramFloat4, 32.0F * paramFloat1, 32.0F * paramFloat4);
/* 607 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */     
/* 610 */     if ((paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR || paramDrawMode == MapRenderingSystem.DrawMode.DETAILED) && 
/* 611 */       getResourceDensity() > 1.0F)
/*     */     {
/* 613 */       if (paramFloat1 > 0.5F) {
/* 614 */         m.setLength(0);
/* 615 */         m.append('x');
/* 616 */         m.append(StringFormatter.compactNumberWithPrecision(getResourceDensity(), 1));
/*     */         ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont;
/* 618 */         (resourcePackBitmapFont = Game.i.assetManager.getFont((int)(18.0F * paramFloat1))).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 619 */         resourcePackBitmapFont.draw(paramBatch, (CharSequence)m, paramFloat2 + 12.0F, paramFloat3 + 27.0F);
/* 620 */         resourcePackBitmapFont.setColor(Color.WHITE);
/* 621 */         resourcePackBitmapFont.draw(paramBatch, (CharSequence)m, paramFloat2 + 10.0F, paramFloat3 + 29.0F);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/* 629 */     if (this.h) a(); 
/* 630 */     float f = paramFloat / 128.0F;
/*     */     
/*     */     Group group;
/* 633 */     (group = new Group()).setTransform(false);
/*     */     
/*     */     Image image;
/* 636 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.SOURCE.a))).setSize(128.0F * f, 128.0F * f);
/* 637 */     group.addActor((Actor)image);
/*     */     byte b1;
/* 639 */     for (b1 = 0; b1 < 8; b1++) {
/*     */       Image image1;
/* 641 */       (image1 = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.SOURCE.b[b1]))).setSize(128.0F * f, 128.0F * f);
/* 642 */       image1.setColor(this.i[b1]);
/* 643 */       group.addActor((Actor)image1);
/*     */     } 
/*     */     
/* 646 */     b1 = 0; ResourceType[] arrayOfResourceType; int i; byte b2;
/* 647 */     for (i = (arrayOfResourceType = ResourceType.values).length, b2 = 0; b2 < i; ) { ResourceType resourceType = arrayOfResourceType[b2];
/* 648 */       if (this.g[resourceType.ordinal()] > 0) {
/* 649 */         m.setLength(0);
/* 650 */         m.append(StringFormatter.compactNumber(this.g[resourceType.ordinal()], false));
/*     */         
/*     */         Label label;
/* 653 */         (label = new Label((CharSequence)m, Game.i.assetManager.getLabelStyle(MathUtils.round(24.0F * f)))).setPosition(12.0F * f, (6.0F + b1 * 20.0F) * f);
/* 654 */         label.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 655 */         group.addActor((Actor)label);
/*     */ 
/*     */         
/* 658 */         (label = new Label((CharSequence)m, Game.i.assetManager.getLabelStyle(MathUtils.round(24.0F * f)))).setPosition(10.0F * f, (8.0F + b1 * 20.0F) * f);
/* 659 */         label.setColor(Game.i.resourceManager.getColor(resourceType));
/* 660 */         group.addActor((Actor)label);
/*     */         
/* 662 */         b1++;
/*     */       } 
/*     */       
/*     */       b2++; }
/*     */     
/*     */     Label label1;
/* 668 */     (label1 = new Label(MathUtils.round(this.f * 100.0F) + "%", Game.i.assetManager.getLabelStyle(MathUtils.round(24.0F * f)))).setPosition(f * 2.0F, 86.0F * f);
/* 669 */     label1.setSize(paramFloat - 10.0F * f, label1.getPrefHeight());
/* 670 */     label1.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 671 */     label1.setAlignment(16);
/* 672 */     group.addActor((Actor)label1);
/*     */     
/*     */     Label label2;
/* 675 */     (label2 = new Label(MathUtils.round(this.f * 100.0F) + "%", Game.i.assetManager.getLabelStyle(MathUtils.round(24.0F * f)))).setPosition(0.0F, 88.0F * f);
/* 676 */     label2.setSize(paramFloat - 10.0F * f, label2.getPrefHeight());
/* 677 */     label2.setColor(Color.WHITE);
/* 678 */     label2.setAlignment(16);
/* 679 */     group.addActor((Actor)label2);
/*     */     
/* 681 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 686 */     paramItemCreationOverlay.label("Resource density");
/* 687 */     paramItemCreationOverlay.textField(String.valueOf(getResourceDensity()), paramString -> {
/*     */           try {
/*     */             setResourceDensity(Float.parseFloat(paramString)); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 691 */           } catch (Exception exception) {
/*     */             c.e("bad value: " + paramString, new Object[0]);
/*     */             return;
/*     */           } 
/*     */         });
/* 696 */     paramItemCreationOverlay.label("Resources");
/* 697 */     Table table = new Table();
/* 698 */     paramItemCreationOverlay.form.add((Actor)table).top().left().row(); ResourceType[] arrayOfResourceType; int i; byte b;
/* 699 */     for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/*     */       Image image;
/* 701 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[resourceType.ordinal()]))).setColor(Game.i.resourceManager.getColor(resourceType));
/* 702 */       table.add((Actor)image).size(32.0F).pad(8.0F).padRight(16.0F);
/*     */       
/* 704 */       TextFieldXPlatform textFieldXPlatform = paramItemCreationOverlay.textField(String.valueOf(getResourcesCount(resourceType)), paramString -> {
/*     */             try {
/*     */               setResourcesCount(paramResourceType, Integer.parseInt(paramString)); paramItemCreationOverlay.updateItemIcon();
/*     */               return;
/* 708 */             } catch (Exception exception) {
/*     */               c.e("bad value: " + paramString, new Object[0]); return;
/*     */             } 
/*     */           });
/* 712 */       table.add((Actor)textFieldXPlatform).size(400.0F, 48.0F).padBottom(4.0F).row();
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 718 */     StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (density: " + getResourceDensity()); ResourceType[] arrayOfResourceType; int i; byte b;
/* 719 */     for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 720 */       stringBuilder.append(" | ").append(resourceType.name()).append(": ").append(getResourcesCount(resourceType));
/*     */       b++; }
/*     */     
/* 723 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static class ResourceAmount {
/*     */     ResourceType a;
/*     */     float b;
/*     */     float c;
/*     */     
/*     */     private ResourceAmount() {} }
/*     */   
/*     */   public static class SourceTileFactory extends Tile.Factory.AbstractFactory<SourceTile> {
/*     */     TextureRegion a;
/* 735 */     final TextureRegion[] b = new TextureRegion[8];
/*     */     
/*     */     public SourceTileFactory() {
/* 738 */       super(TileType.SOURCE);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/*     */       int i;
/* 744 */       if ((i = param1InventoryStatistics.byTileType[TileType.SOURCE.ordinal()]) >= 500) {
/* 745 */         return 0;
/*     */       }
/* 747 */       return 100;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 753 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-source-crack");
/*     */       
/* 755 */       for (byte b = 1; b <= 8; b++) {
/* 756 */         this.b[b - 1] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-source-" + b);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public SourceTile create() {
/* 762 */       return new SourceTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public SourceTile createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/* 767 */       if (param1RandomXS128 == null) {
/* 768 */         param1RandomXS128 = FastRandom.random;
/*     */       }
/*     */       
/* 771 */       SourceTile sourceTile = create();
/*     */ 
/*     */       
/* 774 */       float f = 1.0F;
/* 775 */       for (byte b1 = 0; b1 < 5; b1++) {
/* 776 */         if (param1RandomXS128.nextFloat() > param1Float * 0.25F + 0.75F) {
/* 777 */           f -= 0.2F;
/*     */         }
/*     */       } 
/* 780 */       if (f < 0.2F) f = 0.2F; 
/* 781 */       if (f > 1.0F) f = 1.0F; 
/* 782 */       sourceTile.setResourceDensity(f);
/*     */       
/*     */       RarityType rarityType;
/* 785 */       ResourceType resourceType = ((rarityType = ProgressManager.getRarityFromQuality(param1Float)).ordinal() < ResourceType.values.length) ? ResourceType.values[rarityType.ordinal()] : ResourceType.INFIAR;
/*     */       
/*     */       int i;
/*     */       
/* 789 */       if ((i = MathUtils.round(PMath.randomTriangular(param1RandomXS128) * 6.0F)) <= 0) i = 1; 
/* 790 */       if (i > resourceType.ordinal() + 1) i = resourceType.ordinal() + 1;
/*     */       
/* 792 */       for (byte b2 = 0; b2 < i; b2++) {
/*     */         int j;
/*     */         
/* 795 */         if (b2 == 0) {
/* 796 */           j = resourceType.ordinal();
/*     */         } else {
/* 798 */           j = param1RandomXS128.nextInt(i);
/*     */         } 
/*     */ 
/*     */         
/*     */         int k;
/*     */         
/* 804 */         if ((k = (k = (int)(((ResourceType.values.length - j) + 1.5F) * (55.0F + param1Float * 15.0F) / i)) - k % 10) < 0) k = 0; 
/* 805 */         k += 10;
/*     */         
/* 807 */         sourceTile.setResourcesCount(ResourceType.values[j], sourceTile.getResourcesCount(ResourceType.values[j]) + k);
/*     */       } 
/*     */ 
/*     */       
/* 811 */       return sourceTile;
/*     */     }
/*     */ 
/*     */     
/*     */     public SourceTile fromJson(JsonValue param1JsonValue) {
/* 816 */       SourceTile sourceTile = (SourceTile)super.fromJson(param1JsonValue);
/*     */       
/* 818 */       if (param1JsonValue.has("d")) {
/* 819 */         JsonValue jsonValue = param1JsonValue.get("d");
/*     */         
/* 821 */         SourceTile.a(sourceTile, jsonValue.getFloat("rd", 1.0F));
/* 822 */         if (SourceTile.a(sourceTile) > 100.0F) SourceTile.a(sourceTile, 100.0F); 
/* 823 */         if (SourceTile.a(sourceTile) < 0.0F) SourceTile.a(sourceTile, 0.0F);
/*     */ 
/*     */         
/* 826 */         if ((jsonValue = jsonValue.get("r")) != null) {
/* 827 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) {
/* 828 */             JsonValue jsonValue1; ResourceType resourceType = ResourceType.valueOf((jsonValue1 = jsonIterator.next()).getString("t"));
/*     */             int i;
/* 830 */             if ((i = jsonValue1.getInt("a")) < 0) i = 0; 
/* 831 */             SourceTile.b(sourceTile)[resourceType.ordinal()] = i;
/*     */           } 
/*     */         }
/* 834 */         SourceTile.a(sourceTile, true);
/*     */       } 
/* 836 */       if (param1JsonValue.has("miner")) {
/* 837 */         sourceTile.miner = Game.i.minerManager.fromJson(param1JsonValue.get("miner"));
/*     */       }
/*     */       
/* 840 */       return sourceTile;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\SourceTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */