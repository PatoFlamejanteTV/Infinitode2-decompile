/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ public class PP_Inventory
/*     */   implements PrefSubcategory {
/*  25 */   private static final TLog a = TLog.forClass(PP_Inventory.class);
/*     */   
/*  27 */   private final DelayedRemovalArray<ItemStack> b = new DelayedRemovalArray(false, 1, ItemStack.class);
/*  28 */   private final ObjectMap<ItemType, DelayedRemovalArray<Item>> c = new ObjectMap();
/*  29 */   public Array<AbilityType> lastSelectedAbilities = new Array(true, 1, AbilityType.class);
/*     */ 
/*     */   
/*  32 */   private final ObjectMap<ItemType, DelayedRemovalArray<ItemStack>> d = new ObjectMap();
/*  33 */   private final ObjectMap<ItemCategoryType, DelayedRemovalArray<ItemStack>> e = new ObjectMap();
/*  34 */   private final ObjectMap<ItemSubcategoryType, DelayedRemovalArray<ItemStack>> f = new ObjectMap();
/*     */ 
/*     */   
/*     */   public synchronized void load(PrefMap paramPrefMap) {
/*  38 */     this.b.clear();
/*  39 */     this.d.clear();
/*  40 */     this.e.clear();
/*  41 */     this.f.clear();
/*  42 */     this.c.clear();
/*     */ 
/*     */     
/*  45 */     String str = paramPrefMap.get("items", null);
/*  46 */     boolean bool = Config.isHeadless();
/*  47 */     if (str != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/*     */         
/*  51 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/*  53 */             ItemStack itemStack = ItemStack.fromJson(jsonValue1);
/*     */             
/*  55 */             if (bool) {
/*  56 */               if (itemStack.getItem().getType() == ItemType.TROPHY)
/*  57 */                 addItems(itemStack.getItem(), itemStack.getCount()); 
/*     */               continue;
/*     */             } 
/*  60 */             addItems(itemStack.getItem(), itemStack.getCount());
/*     */           }
/*  62 */           catch (Exception exception) {
/*  63 */             a.e("failed to load items", new Object[] { exception });
/*     */           }
/*     */            }
/*     */       
/*  67 */       } catch (Exception exception) {
/*  68 */         a.e("failed to load items", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     if ((str = paramPrefMap.get("starredItems", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/*  78 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/*  80 */             Item item = Item.fromJson(jsonValue1);
/*     */ 
/*     */             
/*  83 */             bool = false;
/*  84 */             DelayedRemovalArray<ItemStack> delayedRemovalArray = getItemsByType(item.getType());
/*  85 */             for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*     */               ItemStack itemStack;
/*  87 */               if ((itemStack = (ItemStack)delayedRemovalArray.get(b)).getItem().sameAs(item)) {
/*  88 */                 bool = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/*  92 */             if (bool) {
/*  93 */               setStarred(item, true); continue;
/*     */             } 
/*  95 */             a.i("warning: item not found in inventory and won't be starred: " + item, new Object[0]);
/*  96 */             a.i("  " + item.toJsonString(), new Object[0]);
/*     */           }
/*  98 */           catch (Exception exception) {
/*  99 */             a.e("failed to load starred item: " + jsonValue1, new Object[] { exception });
/*     */           }  }
/*     */       
/* 102 */       } catch (Exception exception) {
/* 103 */         a.e("failed to load starred items", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/* 107 */     this.lastSelectedAbilities.clear();
/*     */     
/* 109 */     if ((str = paramPrefMap.get("lastAbilitiesConfiguration", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 112 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) {
/* 113 */           JsonValue jsonValue1; if ((jsonValue1 = jsonIterator.next()).type() == JsonValue.ValueType.stringValue) {
/*     */             try {
/* 115 */               this.lastSelectedAbilities.add(AbilityType.valueOf(jsonValue1.asString()));
/* 116 */             } catch (Exception exception) {} continue;
/*     */           } 
/* 118 */           this.lastSelectedAbilities.add(null);
/*     */         } 
/*     */         return;
/* 121 */       } catch (Exception exception) {
/* 122 */         a.e("failed to load previous abilities configuration", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void save(PrefMap paramPrefMap) {
/* 130 */     if (this.b.size != 0) {
/* 131 */       Json json1 = new Json(JsonWriter.OutputType.minimal);
/* 132 */       StringWriter stringWriter1 = new StringWriter();
/* 133 */       json1.setWriter(stringWriter1);
/* 134 */       json1.writeArrayStart();
/* 135 */       for (byte b1 = 0; b1 < this.b.size; b1++) {
/* 136 */         json1.writeObjectStart();
/* 137 */         ((ItemStack[])this.b.items)[b1].toJson(json1);
/* 138 */         json1.writeObjectEnd();
/*     */       } 
/* 140 */       json1.writeArrayEnd();
/* 141 */       paramPrefMap.set("items", stringWriter1.toString());
/*     */     } 
/*     */ 
/*     */     
/* 145 */     if (this.c.size != 0) {
/* 146 */       Json json1 = new Json(JsonWriter.OutputType.minimal);
/* 147 */       StringWriter stringWriter1 = new StringWriter();
/* 148 */       json1.setWriter(stringWriter1);
/* 149 */       json1.writeArrayStart();
/* 150 */       for (ObjectMap.Values<DelayedRemovalArray> values = this.c.values().iterator(); values.hasNext();) {
/* 151 */         for (Array.ArrayIterator<Item> arrayIterator = (delayedRemovalArray = values.next()).iterator(); arrayIterator.hasNext(); ) { Item item = arrayIterator.next();
/* 152 */           json1.writeObjectStart();
/* 153 */           item.toJson(json1);
/* 154 */           json1.writeObjectEnd(); }
/*     */       
/*     */       } 
/* 157 */       json1.writeArrayEnd();
/* 158 */       paramPrefMap.set("starredItems", stringWriter1.toString());
/*     */     } 
/*     */     
/* 161 */     Json json = new Json(JsonWriter.OutputType.json);
/* 162 */     StringWriter stringWriter = new StringWriter();
/* 163 */     json.setWriter(stringWriter);
/* 164 */     json.writeArrayStart();
/* 165 */     for (byte b = 0; b < this.lastSelectedAbilities.size; b++) {
/* 166 */       if (this.lastSelectedAbilities.get(b) == null) {
/* 167 */         json.writeValue(Boolean.FALSE);
/*     */       } else {
/* 169 */         json.writeValue(((AbilityType)this.lastSelectedAbilities.get(b)).name());
/*     */       } 
/*     */     } 
/* 172 */     json.writeArrayEnd();
/* 173 */     paramPrefMap.set("lastAbilitiesConfiguration", stringWriter.toString());
/*     */   }
/*     */   
/*     */   public boolean isStarred(Item paramItem) {
/*     */     DelayedRemovalArray delayedRemovalArray;
/* 178 */     if ((delayedRemovalArray = (DelayedRemovalArray)this.c.get(paramItem.getType())) == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     for (byte b = 0; b < delayedRemovalArray.size; b++) {
/* 182 */       if (((Item)delayedRemovalArray.get(b)).sameAs(paramItem)) {
/* 183 */         return true;
/*     */       }
/*     */     } 
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean setStarred(Item paramItem, boolean paramBoolean) {
/*     */     DelayedRemovalArray delayedRemovalArray;
/* 194 */     if ((delayedRemovalArray = (DelayedRemovalArray)this.c.get(paramItem.getType())) == null) {
/* 195 */       if (!paramBoolean) {
/* 196 */         return false;
/*     */       }
/* 198 */       delayedRemovalArray = new DelayedRemovalArray(false, 1, Item.class);
/* 199 */       this.c.put(paramItem.getType(), delayedRemovalArray);
/*     */     } 
/*     */ 
/*     */     
/* 203 */     if (paramBoolean) {
/* 204 */       for (paramBoolean = false; paramBoolean < delayedRemovalArray.size; paramBoolean++) {
/* 205 */         if (((Item)delayedRemovalArray.get(paramBoolean)).sameAs(paramItem)) {
/* 206 */           return false;
/*     */         }
/*     */       } 
/* 209 */       delayedRemovalArray.add(paramItem);
/* 210 */       return true;
/*     */     } 
/* 212 */     for (paramBoolean = false; paramBoolean < delayedRemovalArray.size; paramBoolean++) {
/* 213 */       if (((Item)delayedRemovalArray.get(paramBoolean)).sameAs(paramItem)) {
/* 214 */         delayedRemovalArray.removeIndex(paramBoolean);
/* 215 */         return true;
/*     */       } 
/*     */     } 
/* 218 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public DelayedRemovalArray<ItemStack> getItemsByType(ItemType paramItemType) {
/* 223 */     if (this.d.get(paramItemType) == null) {
/* 224 */       this.d.put(paramItemType, new DelayedRemovalArray(false, 1, ItemStack.class));
/*     */     }
/* 226 */     return (DelayedRemovalArray<ItemStack>)this.d.get(paramItemType);
/*     */   }
/*     */   
/*     */   public int getItemsCount(Item paramItem) {
/* 230 */     DelayedRemovalArray<ItemStack> delayedRemovalArray = getItemsByType(paramItem.getType());
/* 231 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/* 232 */       if (((ItemStack)delayedRemovalArray.get(b)).getItem().sameAs(paramItem)) {
/* 233 */         return ((ItemStack)delayedRemovalArray.get(b)).getCount();
/*     */       }
/*     */     } 
/*     */     
/* 237 */     return 0;
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray<ItemStack> getItemsByCategory(ItemCategoryType paramItemCategoryType) {
/* 241 */     if (this.e.get(paramItemCategoryType) == null) {
/* 242 */       this.e.put(paramItemCategoryType, new DelayedRemovalArray(false, 1));
/*     */     }
/* 244 */     return (DelayedRemovalArray<ItemStack>)this.e.get(paramItemCategoryType);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray<ItemStack> getItemsBySubcategory(ItemSubcategoryType paramItemSubcategoryType) {
/* 248 */     if (this.f.get(paramItemSubcategoryType) == null) {
/* 249 */       this.f.put(paramItemSubcategoryType, new DelayedRemovalArray(false, 1));
/*     */     }
/* 251 */     return (DelayedRemovalArray<ItemStack>)this.f.get(paramItemSubcategoryType);
/*     */   }
/*     */   
/*     */   public synchronized void addItems(Item paramItem, int paramInt) {
/* 255 */     if (paramInt <= 0) throw new IllegalArgumentException("Count is " + paramInt);
/*     */ 
/*     */     
/* 258 */     ItemStack itemStack = ProgressManager.addItemToStacksArray((Array)this.b, paramItem, paramInt);
/*     */     
/*     */     DelayedRemovalArray<ItemStack> delayedRemovalArray2;
/* 261 */     if (!(delayedRemovalArray2 = getItemsByType(paramItem.getType())).contains(itemStack, true)) {
/* 262 */       delayedRemovalArray2.add(itemStack);
/*     */     }
/*     */ 
/*     */     
/* 266 */     if (!(delayedRemovalArray2 = getItemsByCategory(paramItem.getCategory())).contains(itemStack, true)) {
/* 267 */       delayedRemovalArray2.add(itemStack);
/*     */     }
/*     */     
/*     */     DelayedRemovalArray<ItemStack> delayedRemovalArray1;
/* 271 */     if (!(delayedRemovalArray1 = getItemsBySubcategory(paramItem.getSubcategory())).contains(itemStack, true)) {
/* 272 */       delayedRemovalArray1.add(itemStack);
/*     */     }
/*     */   }
/*     */   
/*     */   public Array<ItemStack> getAllItems() {
/* 277 */     return (Array<ItemStack>)this.b;
/*     */   }
/*     */   
/*     */   public synchronized void removeAllItems() {
/* 281 */     this.b.clear();
/* 282 */     this.e.clear();
/* 283 */     this.f.clear();
/* 284 */     this.d.clear();
/* 285 */     this.c.clear();
/*     */   }
/*     */   
/*     */   public boolean hasAnyItem() {
/* 289 */     return (this.b.size != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized ItemRemoveResult removeItems(Item paramItem, int paramInt) {
/* 296 */     DelayedRemovalArray<ItemStack> delayedRemovalArray = getItemsByType(paramItem.getType());
/* 297 */     ItemRemoveResult itemRemoveResult = new ItemRemoveResult((byte)0);
/*     */     
/* 299 */     delayedRemovalArray.begin();
/* 300 */     for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*     */       ItemStack itemStack;
/* 302 */       if ((itemStack = (ItemStack)delayedRemovalArray.get(b)).getItem().sameAs(paramItem)) {
/*     */         int i;
/*     */         
/* 305 */         if ((i = itemStack.getCount()) == paramInt) {
/*     */           
/* 307 */           delayedRemovalArray.removeIndex(b);
/*     */           
/* 309 */           if (!this.b.removeValue(itemStack, true)) {
/* 310 */             a.e("allItems had no such item", new Object[0]);
/*     */           }
/* 312 */           if (!getItemsByCategory(paramItem.getCategory()).removeValue(itemStack, true)) {
/* 313 */             a.e("itemsByCategory had no such item", new Object[0]);
/*     */           }
/* 315 */           if (!getItemsBySubcategory(paramItem.getSubcategory()).removeValue(itemStack, true)) {
/* 316 */             a.e("itemsBySubcategory had no such item", new Object[0]);
/*     */           }
/*     */           
/* 319 */           itemRemoveResult.removedRequiredAmount = true;
/* 320 */           itemRemoveResult.remainingCount = 0; break;
/* 321 */         }  if (i > paramInt) {
/*     */           
/* 323 */           itemStack.setCount(i - paramInt);
/* 324 */           itemRemoveResult.removedRequiredAmount = true;
/* 325 */           itemRemoveResult.remainingCount = itemStack.getCount();
/*     */         } 
/*     */         break;
/*     */       } 
/*     */     } 
/* 330 */     delayedRemovalArray.end();
/*     */     
/* 332 */     return itemRemoveResult;
/*     */   }
/*     */   
/*     */   public static final class ItemRemoveResult {
/*     */     public boolean removedRequiredAmount;
/*     */     public int remainingCount;
/*     */     
/*     */     private ItemRemoveResult() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Inventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */