/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.prineside.tdi2.CraftRecipe;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.BlueprintType;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.PredefinedCoreTileType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.items.AbilityItem;
/*     */ import com.prineside.tdi2.items.AbilityTokenItem;
/*     */ import com.prineside.tdi2.items.AcceleratorItem;
/*     */ import com.prineside.tdi2.items.BitDustItem;
/*     */ import com.prineside.tdi2.items.BlueprintItem;
/*     */ import com.prineside.tdi2.items.CaseItem;
/*     */ import com.prineside.tdi2.items.CaseKeyItem;
/*     */ import com.prineside.tdi2.items.DatPaperItem;
/*     */ import com.prineside.tdi2.items.DoubleGainShardItem;
/*     */ import com.prineside.tdi2.items.GameValueGlobalItem;
/*     */ import com.prineside.tdi2.items.GameValueLevelItem;
/*     */ import com.prineside.tdi2.items.GateItem;
/*     */ import com.prineside.tdi2.items.LootBoostItem;
/*     */ import com.prineside.tdi2.items.LuckyShotTokenItem;
/*     */ import com.prineside.tdi2.items.OpenedResearchItem;
/*     */ import com.prineside.tdi2.items.PrestigeDustItem;
/*     */ import com.prineside.tdi2.items.PrestigeTokenItem;
/*     */ import com.prineside.tdi2.items.RandomBarrierItem;
/*     */ import com.prineside.tdi2.items.RandomTeleportItem;
/*     */ import com.prineside.tdi2.items.RarityBoostItem;
/*     */ import com.prineside.tdi2.items.ResearchTokenItem;
/*     */ import com.prineside.tdi2.items.ResearchTokenUsedItem;
/*     */ import com.prineside.tdi2.items.ResourceItem;
/*     */ import com.prineside.tdi2.items.SkillPointItem;
/*     */ import com.prineside.tdi2.items.StarItem;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.items.TrophyItem;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.tiles.CoreTile;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = ItemManager.Serializer.class)
/*     */ public class ItemManager extends Manager.ManagerAdapter {
/*     */   private static String[] a;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<ItemManager> {
/*     */     public ItemManager read() {
/*  65 */       return Game.i.itemManager;
/*     */     }
/*     */   }
/*     */   
/*     */   static {
/*  70 */     (a = new String[(ItemSubcategoryType.values()).length])[ItemSubcategoryType.P_DECRYPTED.ordinal()] = "icon-lock-unlocked";
/*  71 */     a[ItemSubcategoryType.P_ENCRYPTED.ordinal()] = "icon-lock";
/*  72 */     a[ItemSubcategoryType.ME_ROADS.ordinal()] = "icon-road";
/*  73 */     a[ItemSubcategoryType.ME_SOUNDS.ordinal()] = "icon-note";
/*  74 */     a[ItemSubcategoryType.ME_SOURCES.ordinal()] = "icon-pickaxe";
/*  75 */     a[ItemSubcategoryType.ME_PLATFORMS.ordinal()] = "icon-platform";
/*  76 */     a[ItemSubcategoryType.ME_BASES.ordinal()] = "icon-flag";
/*  77 */     a[ItemSubcategoryType.ME_SPAWNS.ordinal()] = "icon-skull";
/*  78 */     a[ItemSubcategoryType.ME_SPECIAL.ordinal()] = "icon-star";
/*  79 */     a[ItemSubcategoryType.M_CURRENCY.ordinal()] = "icon-money";
/*  80 */     a[ItemSubcategoryType.M_TOKENS.ordinal()] = "icon-token";
/*  81 */     a[ItemSubcategoryType.M_DUST.ordinal()] = "icon-dust";
/*  82 */     a[ItemSubcategoryType.M_BLUEPRINT.ordinal()] = "icon-blueprint";
/*  83 */     a[ItemSubcategoryType.M_RESOURCE.ordinal()] = "resource-scalar";
/*  84 */     a[ItemSubcategoryType.O_OTHER.ordinal()] = "icon-cubes-stacked";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static final CaseType[] ENCRYPTED_CASES_QUEUE = new CaseType[120];
/*     */   
/*  92 */   private final Item.Factory[] b = new Item.Factory[ItemType.values.length];
/*     */   
/*  94 */   public Array<CraftRecipe> craftRecipes = new Array(CraftRecipe.class);
/*     */   
/*     */   public ItemManager() {
/*  97 */     for (byte b2 = 0; b2 < 120; b2++) {
/*  98 */       ENCRYPTED_CASES_QUEUE[b2] = CaseType.GREEN;
/*     */     }
/* 100 */     for (float f = 3.0F; f < 120.0F; f += 2.5F)
/* 101 */       ENCRYPTED_CASES_QUEUE[MathUtils.floor(f)] = CaseType.BLUE; 
/*     */     byte b1;
/* 103 */     for (b1 = 18; b1 < 120; b1 += 12) {
/* 104 */       ENCRYPTED_CASES_QUEUE[b1] = CaseType.PURPLE;
/*     */     }
/* 106 */     for (b1 = 36; b1 < 120; b1 += 24) {
/* 107 */       ENCRYPTED_CASES_QUEUE[b1] = CaseType.ORANGE;
/*     */     }
/* 109 */     ENCRYPTED_CASES_QUEUE[119] = CaseType.CYAN;
/*     */     
/* 111 */     this.b[ItemType.ACCELERATOR.ordinal()] = (Item.Factory)new AcceleratorItem.AcceleratorItemFactory();
/* 112 */     this.b[ItemType.GREEN_PAPER.ordinal()] = (Item.Factory)new GreenPaperItem.GreenPaperItemFactory();
/* 113 */     this.b[ItemType.TILE.ordinal()] = (Item.Factory)new TileItem.TileItemFactory();
/* 114 */     this.b[ItemType.GATE.ordinal()] = (Item.Factory)new GateItem.GateItemFactory();
/* 115 */     this.b[ItemType.RANDOM_TILE.ordinal()] = (Item.Factory)new RandomTileItem.RandomTileItemFactory();
/* 116 */     this.b[ItemType.RANDOM_BARRIER.ordinal()] = (Item.Factory)new RandomBarrierItem.RandomBarrierItemFactory();
/* 117 */     this.b[ItemType.RANDOM_TELEPORT.ordinal()] = (Item.Factory)new RandomTeleportItem.RandomTeleportItemFactory();
/* 118 */     this.b[ItemType.RESOURCE.ordinal()] = (Item.Factory)new ResourceItem.ResourceItemFactory();
/* 119 */     this.b[ItemType.CASE.ordinal()] = (Item.Factory)new CaseItem.CaseItemFactory();
/* 120 */     this.b[ItemType.TROPHY.ordinal()] = (Item.Factory)new TrophyItem.TrophyItemFactory();
/* 121 */     this.b[ItemType.GAME_VALUE_GLOBAL.ordinal()] = (Item.Factory)new GameValueGlobalItem.GameValueGlobalItemFactory();
/* 122 */     this.b[ItemType.GAME_VALUE_LEVEL.ordinal()] = (Item.Factory)new GameValueLevelItem.GameValueLevelItemFactory();
/* 123 */     this.b[ItemType.OPENED_RESEARCH.ordinal()] = (Item.Factory)new OpenedResearchItem.OpenedResearchItemFactory();
/* 124 */     this.b[ItemType.STAR.ordinal()] = (Item.Factory)new StarItem.StarItemFactory();
/* 125 */     this.b[ItemType.SKILL_POINT.ordinal()] = (Item.Factory)new SkillPointItem.SkillPointItemFactory();
/* 126 */     this.b[ItemType.ABILITY.ordinal()] = (Item.Factory)new AbilityItem.AbilityItemFactory();
/* 127 */     this.b[ItemType.BIT_DUST.ordinal()] = (Item.Factory)new BitDustItem.BitDustItemFactory();
/* 128 */     this.b[ItemType.PRESTIGE_DUST.ordinal()] = (Item.Factory)new PrestigeDustItem.PrestigeDustItemFactory();
/* 129 */     this.b[ItemType.BLUEPRINT.ordinal()] = (Item.Factory)new BlueprintItem.BlueprintItemFactory();
/* 130 */     this.b[ItemType.ABILITY_TOKEN.ordinal()] = (Item.Factory)new AbilityTokenItem.AbilityTokenItemFactory();
/* 131 */     this.b[ItemType.CASE_KEY.ordinal()] = (Item.Factory)new CaseKeyItem.CaseKeyItemFactory();
/* 132 */     this.b[ItemType.RARITY_BOOST.ordinal()] = (Item.Factory)new RarityBoostItem.RarityBoostItemFactory();
/* 133 */     this.b[ItemType.LOOT_BOOST.ordinal()] = (Item.Factory)new LootBoostItem.LootBoostItemFactory();
/* 134 */     this.b[ItemType.PRESTIGE_TOKEN.ordinal()] = (Item.Factory)new PrestigeTokenItem.PrestigeTokenItemFactory();
/* 135 */     this.b[ItemType.RESEARCH_TOKEN.ordinal()] = (Item.Factory)new ResearchTokenItem.ResearchTokenItemFactory();
/* 136 */     this.b[ItemType.RESEARCH_TOKEN_USED.ordinal()] = (Item.Factory)new ResearchTokenUsedItem.ResearchTokenUsedItemFactory();
/* 137 */     this.b[ItemType.LUCKY_SHOT_TOKEN.ordinal()] = (Item.Factory)new LuckyShotTokenItem.LuckyShotTokenItemFactory();
/* 138 */     this.b[ItemType.DOUBLE_GAIN_SHARD.ordinal()] = (Item.Factory)new DoubleGainShardItem.DoubleGainShardItemFactory();
/* 139 */     this.b[ItemType.DAT_PAPER.ordinal()] = (Item.Factory)new DatPaperItem.DatPaperItemFactory(); ItemType[] arrayOfItemType; int i;
/*     */     byte b3;
/* 141 */     for (i = (arrayOfItemType = ItemType.values).length, b3 = 0; b3 < i; ) { ItemType itemType = arrayOfItemType[b3];
/* 142 */       if (this.b[itemType.ordinal()] == null) {
/* 143 */         throw new RuntimeException("Not all item factories were created");
/*     */       }
/*     */       b3++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void setup() {
/* 150 */     super.setup(); Item.Factory[] arrayOfFactory; int i;
/*     */     byte b2;
/* 152 */     for (i = (arrayOfFactory = this.b).length, b2 = 0; b2 < i; b2++) {
/* 153 */       Item.Factory factory; (factory = arrayOfFactory[b2]).setup();
/*     */     } 
/*     */ 
/*     */     
/* 157 */     Item.D.setup();
/*     */ 
/*     */     
/* 160 */     this.craftRecipes.clear();
/*     */ 
/*     */     
/*     */     BlueprintType[] arrayOfBlueprintType1, arrayOfBlueprintType2;
/*     */ 
/*     */     
/*     */     byte b3;
/*     */     
/* 168 */     for (arrayOfBlueprintType2 = arrayOfBlueprintType1 = new BlueprintType[] { BlueprintType.SPECIAL_II, BlueprintType.SPECIAL_III, BlueprintType.SPECIAL_IV }, b3 = 0; b3 < 3; ) { BlueprintType blueprintType1 = arrayOfBlueprintType2[b3];
/* 169 */       CraftRecipe craftRecipe1 = new CraftRecipe();
/* 170 */       this.craftRecipes.add(craftRecipe1);
/* 171 */       craftRecipe1.result = new ItemStack((Item)Item.D.F_BLUEPRINT.create(blueprintType1), 1);
/* 172 */       char c = Character.MIN_VALUE;
/* 173 */       switch (null.a[blueprintType1.ordinal()]) { case 1:
/* 174 */           craftRecipe1.setStockTime(300.0F); c = 'Ǵ'; break;
/* 175 */         case 2: craftRecipe1.setStockTime(1800.0F); c = 'ஸ'; break;
/* 176 */         case 3: craftRecipe1.setStockTime(7200.0F); c = '㪘'; break; }
/*     */       
/* 178 */       craftRecipe1.setStockMaxQueueStack(10);
/* 179 */       craftRecipe1.ingredients.add(new CraftRecipe.Ingredient(ItemType.GREEN_PAPER, c, new int[0]));
/*     */       
/* 181 */       BlueprintType blueprintType2 = BlueprintType.values[blueprintType1.ordinal() - 1];
/*     */       
/*     */       CraftRecipe.Ingredient ingredient;
/*     */       
/* 185 */       (ingredient = new CraftRecipe.Ingredient(ItemType.BLUEPRINT, 5, new int[] { ItemDataType.TYPE.ordinal(), blueprintType2.ordinal() }))minCount = 2;
/* 186 */       ingredient
/* 187 */         .exampleItems = new Item[] { (Item)Item.D.F_BLUEPRINT.create(blueprintType2) };
/*     */       
/* 189 */       craftRecipe1.ingredients.add(ingredient);
/*     */       
/*     */       b3++; }
/*     */ 
/*     */     
/*     */     byte b1;
/*     */     
/*     */     BlueprintType[] arrayOfBlueprintType3;
/*     */     
/* 198 */     for (arrayOfBlueprintType3 = arrayOfBlueprintType2 = new BlueprintType[] { BlueprintType.SPECIAL_I, BlueprintType.SPECIAL_II, BlueprintType.SPECIAL_III }, b1 = 0; b1 < 3; ) { BlueprintType blueprintType1 = arrayOfBlueprintType3[b1];
/* 199 */       CraftRecipe craftRecipe1 = new CraftRecipe();
/* 200 */       this.craftRecipes.add(craftRecipe1);
/* 201 */       craftRecipe1.result = new ItemStack((Item)Item.D.F_BLUEPRINT.create(blueprintType1), 3);
/* 202 */       char c = Character.MIN_VALUE;
/* 203 */       switch (null.a[blueprintType1.ordinal()]) { case 4:
/* 204 */           craftRecipe1.setStockTime(60.0F); c = 'd'; break;
/* 205 */         case 1: craftRecipe1.setStockTime(300.0F); c = 'Ǵ'; break;
/* 206 */         case 2: craftRecipe1.setStockTime(1800.0F); c = 'ஸ'; break; }
/*     */       
/* 208 */       craftRecipe1.setStockMaxQueueStack(10);
/* 209 */       craftRecipe1.ingredients.add(new CraftRecipe.Ingredient(ItemType.GREEN_PAPER, c, new int[0]));
/*     */       
/* 211 */       BlueprintType blueprintType2 = BlueprintType.values[blueprintType1.ordinal() + 1];
/*     */       
/*     */       CraftRecipe.Ingredient ingredient;
/*     */       
/* 215 */       (ingredient = new CraftRecipe.Ingredient(ItemType.BLUEPRINT, 1, new int[] { ItemDataType.TYPE.ordinal(), blueprintType2.ordinal()
/* 216 */           }))exampleItems = new Item[] { (Item)Item.D.F_BLUEPRINT.create(blueprintType2) };
/*     */       
/* 218 */       craftRecipe1.ingredients.add(ingredient);
/*     */       
/*     */       b1++; }
/*     */     
/* 222 */     CraftRecipe craftRecipe = new CraftRecipe();
/* 223 */     this.craftRecipes.add(craftRecipe);
/* 224 */     craftRecipe.result = new ItemStack((Item)Item.D.F_CASE.create(CaseType.BLUEPRINT, false), 1);
/* 225 */     craftRecipe.setStockTime(14400.0F);
/* 226 */     craftRecipe.setStockMaxQueueStack(3);
/*     */ 
/*     */     
/*     */     CraftRecipe.Ingredient ingredient1;
/*     */     
/* 231 */     (ingredient1 = new CraftRecipe.Ingredient(ItemType.BLUEPRINT, 1, new int[] { ItemDataType.TYPE.ordinal(), BlueprintType.SPECIAL_III.ordinal()
/* 232 */         }))exampleItems = new Item[] { (Item)Item.D.F_BLUEPRINT.create(BlueprintType.SPECIAL_III) };
/*     */     
/* 234 */     craftRecipe.ingredients.add(ingredient1);
/*     */ 
/*     */     
/*     */     ResourceType[] arrayOfResourceType1, arrayOfResourceType2;
/*     */ 
/*     */     
/*     */     byte b5;
/*     */ 
/*     */     
/* 243 */     for (arrayOfResourceType2 = arrayOfResourceType1 = new ResourceType[] { ResourceType.VECTOR, ResourceType.MATRIX, ResourceType.TENSOR, ResourceType.INFIAR }, b5 = 0; b5 < 4; ) { ResourceType resourceType2 = arrayOfResourceType2[b5];
/* 244 */       craftRecipe = new CraftRecipe(this, resourceType2) {
/*     */           public boolean isAvailable() {
/* 246 */             return Game.i.progressManager.isResourceOpened(this.a); }
/*     */         };
/* 248 */       this.craftRecipes.add(craftRecipe);
/* 249 */       craftRecipe.result = new ItemStack((Item)Item.D.F_RESOURCE.create(resourceType2), 1);
/*     */       
/* 251 */       byte b = 0;
/* 252 */       switch (null.b[resourceType2.ordinal()]) { case 1:
/* 253 */           craftRecipe.setStockTime(5.0F); b = 1; break;
/* 254 */         case 2: craftRecipe.setStockTime(10.0F); b = 2; break;
/* 255 */         case 3: craftRecipe.setStockTime(15.0F); b = 3; break;
/* 256 */         case 4: craftRecipe.setStockTime(20.0F); b = 4; break; }
/*     */       
/* 258 */       craftRecipe.setStockMaxQueueStack(1000);
/*     */       
/* 260 */       craftRecipe.ingredients.add(new CraftRecipe.Ingredient(ItemType.GREEN_PAPER, b));
/*     */       
/* 262 */       ResourceType resourceType1 = ResourceType.values[resourceType2.ordinal() - 1];
/*     */ 
/*     */ 
/*     */       
/* 266 */       (ingredient1 = new CraftRecipe.Ingredient(ItemType.RESOURCE, 3, new int[] { ItemDataType.TYPE.ordinal(), resourceType1.ordinal() }))minCount = 2;
/* 267 */       ingredient1
/* 268 */         .exampleItems = new Item[] { (Item)Item.D.F_RESOURCE.create(resourceType1) };
/*     */       
/* 270 */       craftRecipe.ingredients.add(ingredient1);
/*     */       
/*     */       b5++; }
/*     */     
/* 274 */     craftRecipe = new CraftRecipe();
/* 275 */     this.craftRecipes.add(craftRecipe);
/* 276 */     craftRecipe.result = new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_I, 1);
/* 277 */     craftRecipe.setStockTime(600.0F);
/* 278 */     craftRecipe.setStockMaxQueueStack(5);
/*     */     
/* 280 */     (ingredient1 = new CraftRecipe.Ingredient(ItemType.BLUEPRINT, 20, RarityType.COMMON)).minCount = 5;
/* 281 */     ingredient1.exampleItems = new Item[] { (Item)Item.D.BLUEPRINT_EXPERIENCE, (Item)Item.D.BLUEPRINT_AGILITY, (Item)Item.D.BLUEPRINT_POWER };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     craftRecipe.ingredients.add(ingredient1);
/*     */ 
/*     */     
/* 289 */     craftRecipe = new CraftRecipe();
/* 290 */     this.craftRecipes.add(craftRecipe);
/* 291 */     craftRecipe.result = new ItemStack((Item)Item.D.PRESTIGE_TOKEN, 1);
/* 292 */     craftRecipe.setStockTime(360.0F);
/* 293 */     craftRecipe.setStockMaxQueueStack(100);
/*     */     
/* 295 */     (ingredient1 = new CraftRecipe.Ingredient(ItemType.PRESTIGE_DUST, 1500)).exampleItems = new Item[] { (Item)Item.D.PRESTIGE_DUST };
/*     */ 
/*     */     
/* 298 */     craftRecipe.ingredients.add(ingredient1);
/* 299 */     craftRecipe.ingredients.add(new CraftRecipe.Ingredient(ItemType.GREEN_PAPER, 1000));
/*     */ 
/*     */     
/* 302 */     craftRecipe = new CraftRecipe();
/* 303 */     this.craftRecipes.add(craftRecipe);
/* 304 */     craftRecipe.result = new ItemStack((Item)Item.D.RESEARCH_TOKEN, 1);
/* 305 */     craftRecipe.setStockTime(3600.0F);
/* 306 */     craftRecipe.setStockMaxQueueStack(10);
/* 307 */     craftRecipe.ingredients.add(new CraftRecipe.Ingredient(ItemType.PRESTIGE_TOKEN, 100));
/* 308 */     craftRecipe.ingredients.add(new CraftRecipe.Ingredient(ItemType.LUCKY_SHOT_TOKEN, 7));
/* 309 */     craftRecipe.ingredients.add(new CraftRecipe.Ingredient(ItemType.ACCELERATOR, 80));
/*     */     
/* 311 */     craftRecipe = new CraftRecipe();
/* 312 */     this.craftRecipes.add(craftRecipe);
/* 313 */     craftRecipe.result = new ItemStack((Item)Item.D.RESEARCH_TOKEN, 1);
/* 314 */     craftRecipe.setStockTime(3600.0F);
/* 315 */     craftRecipe.setStockMaxQueueStack(10);
/*     */     CraftRecipe.Ingredient ingredient2;
/* 317 */     (ingredient2 = new CraftRecipe.Ingredient(ItemType.RESEARCH_TOKEN_USED, 2)).ignoresDiscounts = true;
/* 318 */     craftRecipe.ingredients.add(ingredient2);
/*     */     
/*     */     CoreTile.CoreTileFactory coreTileFactory;
/*     */     
/*     */     CoreTile coreTile1;
/*     */     
/* 324 */     (coreTile1 = (coreTileFactory = (CoreTile.CoreTileFactory)Game.i.tileManager.getFactory(TileType.CORE)).create()).predefinedType = PredefinedCoreTileType.DELTA;
/* 325 */     craftRecipe = new CraftRecipe();
/* 326 */     this.craftRecipes.add(craftRecipe);
/* 327 */     craftRecipe.result = new ItemStack((Item)Item.D.F_TILE.create((Tile)coreTile1), 1);
/* 328 */     craftRecipe.setStockTime(14400.0F);
/* 329 */     craftRecipe.setStockMaxQueueStack(1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 334 */     (ingredient1 = new CraftRecipe.Ingredient(ItemType.TILE, 10, new int[] { ItemDataType.TYPE.ordinal(), TileType.CORE.ordinal(), ItemDataType.TILE_PREDEFINED_CORE_TYPE.ordinal(), PredefinedCoreTileType.ALPHA.ordinal() }))minCount = 2;
/*     */     CoreTile coreTile2;
/* 336 */     (coreTile2 = coreTileFactory.create()).predefinedType = PredefinedCoreTileType.ALPHA;
/* 337 */     ingredient1
/* 338 */       .exampleItems = new Item[] { (Item)Item.D.F_TILE.create((Tile)coreTile2) };
/*     */     
/* 340 */     craftRecipe.ingredients.add(ingredient1);
/*     */ 
/*     */ 
/*     */     
/* 344 */     (coreTile1 = coreTileFactory.create()).predefinedType = PredefinedCoreTileType.ZETA;
/* 345 */     craftRecipe = new CraftRecipe();
/* 346 */     this.craftRecipes.add(craftRecipe);
/* 347 */     craftRecipe.result = new ItemStack((Item)Item.D.F_TILE.create((Tile)coreTile1), 1);
/* 348 */     craftRecipe.setStockTime(64800.0F);
/* 349 */     craftRecipe.setStockMaxQueueStack(1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 354 */     (ingredient1 = new CraftRecipe.Ingredient(ItemType.TILE, 10, new int[] { ItemDataType.TYPE.ordinal(), TileType.CORE.ordinal(), ItemDataType.TILE_PREDEFINED_CORE_TYPE.ordinal(), PredefinedCoreTileType.DELTA.ordinal() }))minCount = 2;
/*     */     
/* 356 */     (coreTile2 = coreTileFactory.create()).predefinedType = PredefinedCoreTileType.DELTA;
/* 357 */     ingredient1
/* 358 */       .exampleItems = new Item[] { (Item)Item.D.F_TILE.create((Tile)coreTile2) };
/*     */     
/* 360 */     craftRecipe.ingredients.add(ingredient1);
/*     */ 
/*     */ 
/*     */     
/* 364 */     (coreTile1 = coreTileFactory.create()).predefinedType = PredefinedCoreTileType.THETA;
/* 365 */     craftRecipe = new CraftRecipe();
/* 366 */     this.craftRecipes.add(craftRecipe);
/* 367 */     craftRecipe.result = new ItemStack((Item)Item.D.F_TILE.create((Tile)coreTile1), 1);
/* 368 */     craftRecipe.setStockTime(14400.0F);
/* 369 */     craftRecipe.setStockMaxQueueStack(1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 374 */     (ingredient1 = new CraftRecipe.Ingredient(ItemType.TILE, 10, new int[] { ItemDataType.TYPE.ordinal(), TileType.CORE.ordinal(), ItemDataType.TILE_PREDEFINED_CORE_TYPE.ordinal(), PredefinedCoreTileType.BETA.ordinal() }))minCount = 2;
/*     */     
/* 376 */     (coreTile2 = coreTileFactory.create()).predefinedType = PredefinedCoreTileType.BETA;
/* 377 */     ingredient1
/* 378 */       .exampleItems = new Item[] { (Item)Item.D.F_TILE.create((Tile)coreTile2) };
/*     */     
/* 380 */     craftRecipe.ingredients.add(ingredient1);
/*     */ 
/*     */ 
/*     */     
/* 384 */     (coreTile1 = coreTileFactory.create()).predefinedType = PredefinedCoreTileType.XI;
/* 385 */     craftRecipe = new CraftRecipe();
/* 386 */     this.craftRecipes.add(craftRecipe);
/* 387 */     craftRecipe.result = new ItemStack((Item)Item.D.F_TILE.create((Tile)coreTile1), 1);
/* 388 */     craftRecipe.setStockTime(64800.0F);
/* 389 */     craftRecipe.setStockMaxQueueStack(1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 394 */     (ingredient1 = new CraftRecipe.Ingredient(ItemType.TILE, 10, new int[] { ItemDataType.TYPE.ordinal(), TileType.CORE.ordinal(), ItemDataType.TILE_PREDEFINED_CORE_TYPE.ordinal(), PredefinedCoreTileType.THETA.ordinal() }))minCount = 2;
/*     */     
/* 396 */     (coreTile2 = coreTileFactory.create()).predefinedType = PredefinedCoreTileType.THETA;
/* 397 */     ingredient1
/* 398 */       .exampleItems = new Item[] { (Item)Item.D.F_TILE.create((Tile)coreTile2) };
/*     */     
/* 400 */     craftRecipe.ingredients.add(ingredient1);
/*     */ 
/*     */ 
/*     */     
/* 404 */     PlatformTile.SpaceTileFactory spaceTileFactory = (PlatformTile.SpaceTileFactory)Game.i.tileManager.getFactory(TileType.PLATFORM); SpaceTileBonusType[] arrayOfSpaceTileBonusType; int j; byte b4;
/* 405 */     for (j = (arrayOfSpaceTileBonusType = SpaceTileBonusType.values).length, b4 = 0; b4 < j; ) { SpaceTileBonusType spaceTileBonusType = arrayOfSpaceTileBonusType[b4];
/* 406 */       for (byte b = 2; b <= 5; b++) {
/*     */         PlatformTile platformTile1;
/*     */         
/* 409 */         (platformTile1 = spaceTileFactory.create()).bonusType = spaceTileBonusType;
/* 410 */         platformTile1.bonusLevel = b;
/*     */         
/* 412 */         craftRecipe = new CraftRecipe();
/* 413 */         this.craftRecipes.add(craftRecipe);
/* 414 */         craftRecipe.result = new ItemStack((Item)Item.D.F_TILE.create((Tile)platformTile1), 1);
/*     */         
/* 416 */         char c = Character.MIN_VALUE;
/* 417 */         switch (b) { case 2:
/* 418 */             c = 'Ǵ'; craftRecipe.setStockTime(15.0F); break;
/* 419 */           case 3: c = 'ל'; craftRecipe.setStockTime(60.0F); break;
/* 420 */           case 4: c = 'ᎈ'; craftRecipe.setStockTime(180.0F); break;
/* 421 */           case 5: c = '㪘'; craftRecipe.setStockTime(480.0F);
/*     */             break; }
/*     */         
/* 424 */         craftRecipe.setStockMaxQueueStack(5);
/*     */ 
/*     */         
/*     */         CraftRecipe.Ingredient ingredient;
/*     */ 
/*     */         
/* 430 */         (ingredient = new CraftRecipe.Ingredient(ItemType.TILE, 3, new int[] { ItemDataType.TYPE.ordinal(), TileType.PLATFORM.ordinal(), ItemDataType.BONUS_TYPE.ordinal(), spaceTileBonusType.ordinal(), ItemDataType.BONUS_LEVEL.ordinal(), b - 1 }))minCount = 2;
/*     */         PlatformTile platformTile2;
/* 432 */         (platformTile2 = spaceTileFactory.create()).bonusLevel = b - 1;
/* 433 */         platformTile2.bonusType = spaceTileBonusType;
/* 434 */         ingredient
/* 435 */           .exampleItems = new Item[] { (Item)Item.D.F_TILE.create((Tile)platformTile2) };
/*     */         
/* 437 */         craftRecipe.ingredients.add(ingredient);
/*     */         
/* 439 */         craftRecipe.ingredients.add(new CraftRecipe.Ingredient(ItemType.GREEN_PAPER, c));
/*     */       } 
/*     */       b4++; }
/*     */   
/*     */   }
/*     */   public Array<CraftRecipe> getCraftRecipes(Item paramItem) {
/* 445 */     Array<CraftRecipe> array = new Array(CraftRecipe.class);
/*     */     
/* 447 */     for (byte b = 0; b < this.craftRecipes.size; b++) {
/* 448 */       if ((((CraftRecipe[])this.craftRecipes.items)[b]).result.getItem().sameAs(paramItem)) {
/* 449 */         array.add(((CraftRecipe[])this.craftRecipes.items)[b]);
/*     */       }
/*     */     } 
/*     */     
/* 453 */     return array;
/*     */   }
/*     */   
/*     */   public String getCategoryNameAlias(ItemCategoryType paramItemCategoryType) {
/* 457 */     String str = "item_category_" + paramItemCategoryType.name();
/*     */     
/* 459 */     return Game.i.localeManager.i18n.get(str);
/*     */   }
/*     */   
/*     */   public String getSubcategoryName(ItemSubcategoryType paramItemSubcategoryType) {
/* 463 */     String str = "item_subcategory_" + paramItemSubcategoryType.name();
/*     */     
/* 465 */     return Game.i.localeManager.i18n.get(str);
/*     */   }
/*     */   
/*     */   public String getSubcategoryIconAlias(ItemSubcategoryType paramItemSubcategoryType) {
/* 469 */     return a[paramItemSubcategoryType.ordinal()];
/*     */   }
/*     */   
/*     */   public Color getSubcategoryColor(ItemSubcategoryType paramItemSubcategoryType) {
/* 473 */     switch (null.c[paramItemSubcategoryType.ordinal()]) { case 1:
/* 474 */         return MaterialColor.CYAN.P500;
/* 475 */       case 2: return MaterialColor.LIGHT_GREEN.P500;
/* 476 */       case 3: return MaterialColor.AMBER.P500;
/* 477 */       case 4: return MaterialColor.PINK.P400;
/* 478 */       case 5: return MaterialColor.PURPLE.P400;
/* 479 */       case 6: return MaterialColor.BLUE.P500;
/* 480 */       case 7: return MaterialColor.GREEN.P500;
/* 481 */       case 8: return MaterialColor.DEEP_ORANGE.P400;
/* 482 */       case 9: return MaterialColor.ORANGE.P500;
/* 483 */       case 10: return MaterialColor.PURPLE.P300;
/* 484 */       case 11: return MaterialColor.TEAL.P400;
/* 485 */       case 12: return MaterialColor.YELLOW.P500;
/* 486 */       case 13: return MaterialColor.GREY.P500;
/* 487 */       case 14: return MaterialColor.PURPLE.P400;
/* 488 */       case 15: return MaterialColor.LIGHT_GREEN.P500; }
/* 489 */      return Color.WHITE;
/*     */   }
/*     */ 
/*     */   
/*     */   public CaseType getQueuedEncryptedCaseType(int paramInt) {
/* 494 */     return ENCRYPTED_CASES_QUEUE[paramInt % ENCRYPTED_CASES_QUEUE.length];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack generateItemByRarity(RandomXS128 paramRandomXS128, RarityType paramRarityType, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean, ProgressManager.InventoryStatistics paramInventoryStatistics) {
/*     */     int i2;
/*     */     float f5;
/*     */     int i1;
/*     */     BlueprintItem blueprintItem;
/*     */     CaseItem caseItem5;
/*     */     int n;
/*     */     float f4;
/*     */     CaseItem caseItem4;
/*     */     GateItem gateItem2;
/*     */     int m;
/*     */     float f3;
/*     */     CaseItem caseItem3;
/*     */     GateItem gateItem1;
/*     */     int k;
/*     */     float f2;
/*     */     CaseItem caseItem2;
/*     */     int j;
/*     */     float f1;
/*     */     CaseItem caseItem1;
/*     */     int i;
/* 521 */     paramFloat2 *= 0.85F + 0.3F * paramRandomXS128.nextFloat();
/*     */     
/* 523 */     IntArray intArray = new IntArray();
/* 524 */     switch (null.d[paramRarityType.ordinal()]) {
/*     */       case 1:
/* 526 */         intArray.add(MathUtils.round(125.0F * paramFloat3), 1);
/* 527 */         intArray.add(120, 2);
/* 528 */         intArray.add(140, 3);
/* 529 */         intArray.add(MathUtils.round(3.0F * paramFloat6), 4);
/* 530 */         intArray.add(MathUtils.round(30.0F * paramFloat7), 5);
/*     */ 
/*     */ 
/*     */         
/* 534 */         switch (i2 = PMath.getByChance(paramRandomXS128, intArray)) {
/*     */           
/*     */           case 1:
/* 537 */             return new ItemStack((Item)Item.D.RESOURCE_SCALAR, MathUtils.clamp(MathUtils.round(200.0F * paramFloat2), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 2:
/* 541 */             f5 = paramFloat1 * 0.2F;
/*     */             
/* 543 */             if (paramBoolean) {
/* 544 */               return new ItemStack((Item)Item.D.F_RANDOM_TILE.create(MathUtils.round(f5 * 20.0F) * 0.05F), 1);
/*     */             }
/* 546 */             return new ItemStack((Item)Item.D.F_TILE.create(Game.i.tileManager.createRandomTile(f5, paramRandomXS128, paramInventoryStatistics)), 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 553 */             switch (i1 = paramRandomXS128.nextInt(3)) { case 0:
/* 554 */                 blueprintItem = Item.D.BLUEPRINT_AGILITY;
/*     */ 
/*     */ 
/*     */                 
/* 558 */                 return new ItemStack((Item)blueprintItem, MathUtils.clamp(MathUtils.round((1.0F + paramRandomXS128.nextFloat() * 2.0F) * paramFloat2), 1, 2147483647));case 1: blueprintItem = Item.D.BLUEPRINT_POWER; return new ItemStack((Item)blueprintItem, MathUtils.clamp(MathUtils.round((1.0F + paramRandomXS128.nextFloat() * 2.0F) * paramFloat2), 1, 2147483647)); }  blueprintItem = Item.D.BLUEPRINT_EXPERIENCE; return new ItemStack((Item)blueprintItem, MathUtils.clamp(MathUtils.round((1.0F + paramRandomXS128.nextFloat() * 2.0F) * paramFloat2), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 4:
/* 562 */             caseItem5 = Item.D.F_CASE.create(CaseType.GREEN, true);
/*     */             
/* 564 */             return new ItemStack((Item)caseItem5, 1);
/*     */ 
/*     */           
/*     */           case 5:
/* 568 */             return new ItemStack((Item)Item.D.CASE_KEY_BLUE, MathUtils.clamp(MathUtils.round((1.0F + paramRandomXS128.nextFloat()) * paramFloat2), 1, 2147483647));
/*     */         } 
/*     */       
/*     */       
/*     */       case 2:
/* 573 */         intArray.add(MathUtils.round(125.0F * paramFloat3), 1);
/* 574 */         intArray.add(170, 2);
/* 575 */         intArray.add(40, 3);
/* 576 */         intArray.add(MathUtils.round(paramFloat6 * 2.0F), 4);
/* 577 */         intArray.add(15, 5);
/* 578 */         intArray.add(MathUtils.round(30.0F * paramFloat7), 6);
/*     */ 
/*     */ 
/*     */         
/* 582 */         switch (n = PMath.getByChance(paramRandomXS128, intArray)) {
/*     */           
/*     */           case 1:
/* 585 */             return new ItemStack((Item)Item.D.RESOURCE_VECTOR, MathUtils.clamp(MathUtils.round(400.0F * paramFloat2), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 2:
/* 589 */             f4 = 0.2F + paramFloat1 * 0.2F;
/*     */             
/* 591 */             if (paramBoolean) {
/* 592 */               return new ItemStack((Item)Item.D.F_RANDOM_TILE.create(MathUtils.round(f4 * 20.0F) * 0.05F), 1);
/*     */             }
/* 594 */             return new ItemStack((Item)Item.D.F_TILE.create(Game.i.tileManager.createRandomTile(f4, paramRandomXS128, paramInventoryStatistics)), 1);
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 599 */             return new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_I, MathUtils.clamp(MathUtils.round(paramFloat2 * 1.0F), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 4:
/* 603 */             caseItem4 = Item.D.F_CASE.create(CaseType.BLUE, true);
/*     */             
/* 605 */             return new ItemStack((Item)caseItem4, 1);
/*     */ 
/*     */           
/*     */           case 5:
/* 609 */             gateItem2 = Item.D.F_GATE.create(Game.i.gateManager.createRandomGate(GateType.BARRIER_TYPE, paramRandomXS128.nextFloat(), paramRandomXS128));
/*     */             
/* 611 */             return new ItemStack((Item)gateItem2, 1);
/*     */ 
/*     */           
/*     */           case 6:
/* 615 */             return new ItemStack((Item)Item.D.CASE_KEY_PURPLE, MathUtils.clamp(MathUtils.round((1.0F + paramRandomXS128.nextFloat()) * paramFloat2), 1, 2147483647));
/*     */         } 
/*     */       
/*     */       
/*     */       case 3:
/* 620 */         intArray.add(MathUtils.round(125.0F * paramFloat3), 1);
/* 621 */         intArray.add(180, 2);
/* 622 */         intArray.add(40, 3);
/* 623 */         intArray.add(MathUtils.round(paramFloat6 * 2.0F), 4);
/* 624 */         intArray.add(15, 5);
/* 625 */         intArray.add(MathUtils.round(30.0F * paramFloat7), 6);
/*     */ 
/*     */ 
/*     */         
/* 629 */         switch (m = PMath.getByChance(paramRandomXS128, intArray)) {
/*     */           
/*     */           case 1:
/* 632 */             return new ItemStack((Item)Item.D.RESOURCE_MATRIX, MathUtils.clamp(MathUtils.round(600.0F * paramFloat2), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 2:
/* 636 */             f3 = 0.4F + paramFloat1 * 0.2F;
/*     */             
/* 638 */             if (paramBoolean) {
/* 639 */               return new ItemStack((Item)Item.D.F_RANDOM_TILE.create(MathUtils.round(f3 * 20.0F) * 0.05F), 1);
/*     */             }
/* 641 */             return new ItemStack((Item)Item.D.F_TILE.create(Game.i.tileManager.createRandomTile(f3, paramRandomXS128, paramInventoryStatistics)), 1);
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 646 */             return new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_II, MathUtils.clamp(MathUtils.round(paramFloat2 * 1.0F), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 4:
/* 650 */             caseItem3 = Item.D.F_CASE.create(CaseType.PURPLE, true);
/*     */             
/* 652 */             return new ItemStack((Item)caseItem3, 1);
/*     */ 
/*     */           
/*     */           case 5:
/* 656 */             gateItem1 = Item.D.F_GATE.create(Game.i.gateManager.createRandomGate(GateType.TELEPORT, paramRandomXS128.nextFloat(), paramRandomXS128));
/*     */             
/* 658 */             return new ItemStack((Item)gateItem1, 1);
/*     */ 
/*     */           
/*     */           case 6:
/* 662 */             return new ItemStack((Item)Item.D.CASE_KEY_ORANGE, MathUtils.clamp(MathUtils.round((1.0F + paramRandomXS128.nextFloat()) * paramFloat2), 1, 2147483647));
/*     */         } 
/*     */       
/*     */       
/*     */       case 4:
/* 667 */         intArray.add(MathUtils.round(125.0F * paramFloat3), 1);
/* 668 */         intArray.add(190, 2);
/* 669 */         intArray.add(40, 3);
/* 670 */         intArray.add(MathUtils.round(paramFloat6 * 1.0F), 4);
/* 671 */         intArray.add(4, 5);
/* 672 */         intArray.add(MathUtils.round(30.0F * paramFloat7), 6);
/*     */ 
/*     */         
/* 675 */         if (paramInventoryStatistics.lootBoostTimeLeft >= 0.0F && paramInventoryStatistics.lootBoostTimeLeft < 21600.0F) {
/* 676 */           float f = 1.0F - paramInventoryStatistics.lootBoostTimeLeft / 21600.0F;
/* 677 */           intArray.add(MathUtils.round((float)StrictMath.sqrt((70.0F * paramFloat4 * f))), 7);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 682 */         switch (k = PMath.getByChance(paramRandomXS128, intArray)) {
/*     */           
/*     */           case 1:
/* 685 */             return new ItemStack((Item)Item.D.RESOURCE_TENSOR, MathUtils.clamp(MathUtils.round(800.0F * paramFloat2), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 2:
/* 689 */             f2 = 0.6F + paramFloat1 * 0.2F;
/*     */             
/* 691 */             if (paramBoolean) {
/* 692 */               return new ItemStack((Item)Item.D.F_RANDOM_TILE.create(MathUtils.round(f2 * 20.0F) * 0.05F), 1);
/*     */             }
/* 694 */             return new ItemStack((Item)Item.D.F_TILE.create(Game.i.tileManager.createRandomTile(f2, paramRandomXS128, paramInventoryStatistics)), 1);
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 699 */             return new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_III, MathUtils.clamp(MathUtils.round(paramFloat2 * 1.0F), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 4:
/* 703 */             caseItem2 = Item.D.F_CASE.create(CaseType.ORANGE, true);
/*     */             
/* 705 */             return new ItemStack((Item)caseItem2, 1);
/*     */ 
/*     */           
/*     */           case 5:
/* 709 */             return new ItemStack((Item)Item.D.ABILITY_TOKEN, MathUtils.clamp(MathUtils.round(paramFloat2 * 1.0F), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 6:
/* 713 */             return new ItemStack((Item)Item.D.CASE_KEY_CYAN, MathUtils.clamp(MathUtils.round((1.0F + paramRandomXS128.nextFloat()) * paramFloat2), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 7:
/* 717 */             return new ItemStack((Item)Item.D.LOOT_BOOST, 1);
/*     */         } 
/*     */       
/*     */       
/*     */       case 5:
/* 722 */         intArray.add(MathUtils.round(125.0F * paramFloat3), 1);
/* 723 */         intArray.add(180, 2);
/* 724 */         intArray.add(30, 3);
/* 725 */         intArray.add(MathUtils.round(paramFloat6 * 1.0F), 4);
/* 726 */         intArray.add(MathUtils.round(35.0F * paramFloat5), 5);
/*     */ 
/*     */         
/* 729 */         if (paramInventoryStatistics.rarityBoostsCount >= 0 && paramInventoryStatistics.rarityBoostsCount < 100) {
/* 730 */           float f = 1.0F - paramInventoryStatistics.rarityBoostsCount / 100.0F;
/* 731 */           intArray.add(MathUtils.round((float)StrictMath.sqrt((12.5F * paramFloat4 * f))), 6);
/*     */         } else {
/* 733 */           intArray.add(0, 6);
/*     */         } 
/* 735 */         intArray.add(2, 7);
/* 736 */         if (paramRandomXS128.nextFloat() < 0.003F) {
/* 737 */           intArray.add(1, 8);
/*     */         } else {
/* 739 */           intArray.add(0, 8);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 744 */         switch (j = PMath.getByChance(paramRandomXS128, intArray)) {
/*     */           
/*     */           case 1:
/* 747 */             return new ItemStack((Item)Item.D.RESOURCE_INFIAR, MathUtils.clamp(MathUtils.round(1000.0F * paramFloat2), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 2:
/* 751 */             f1 = 0.8F + paramFloat1 * 0.2F;
/*     */             
/* 753 */             if (paramBoolean) {
/* 754 */               return new ItemStack((Item)Item.D.F_RANDOM_TILE.create(MathUtils.round(f1 * 20.0F) * 0.05F), 1);
/*     */             }
/* 756 */             return new ItemStack((Item)Item.D.F_TILE.create(Game.i.tileManager.createRandomTile(f1, paramRandomXS128, paramInventoryStatistics)), 1);
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 761 */             return new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_IV, MathUtils.clamp(MathUtils.round(paramFloat2 * 1.0F), 1, 2147483647));
/*     */ 
/*     */           
/*     */           case 4:
/* 765 */             caseItem1 = Item.D.F_CASE.create(CaseType.CYAN, true);
/*     */             
/* 767 */             return new ItemStack((Item)caseItem1, 1);
/*     */ 
/*     */           
/*     */           case 5:
/* 771 */             i = MathUtils.clamp(MathUtils.round(5.0F * paramFloat2), 1, 2147483647);
/* 772 */             return new ItemStack((Item)Item.D.BIT_DUST, i);
/*     */ 
/*     */           
/*     */           case 6:
/* 776 */             return new ItemStack((Item)Item.D.RARITY_BOOST, 1);
/*     */ 
/*     */           
/*     */           case 7:
/* 780 */             return new ItemStack((Item)Item.D.LUCKY_SHOT_TOKEN, 1);
/*     */ 
/*     */           
/*     */           case 8:
/* 784 */             return new ItemStack((Item)Item.D.RESEARCH_TOKEN, 1);
/*     */         } 
/*     */         
/*     */         break;
/*     */     } 
/*     */     
/* 790 */     throw new IllegalStateException("failed to generate item");
/*     */   }
/*     */   
/*     */   public Item.Factory<? extends Item> getFactory(ItemType paramItemType) {
/* 794 */     return this.b[paramItemType.ordinal()];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ItemManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */