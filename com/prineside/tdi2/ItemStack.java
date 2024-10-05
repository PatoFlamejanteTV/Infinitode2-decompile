/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ @REGS
/*     */ public class ItemStack
/*     */   implements KryoSerializable
/*     */ {
/*     */   public static final int MAX_COUNT = 999999999;
/*     */   private Item a;
/*  23 */   private int b = 1;
/*     */   public boolean covered = false;
/*     */   public static final Comparator<ItemStack> SORT_COMPARATOR_KIND;
/*     */   
/*     */   static {
/*  28 */     SORT_COMPARATOR_KIND = ((paramItemStack1, paramItemStack2) -> Integer.compare(paramItemStack1.getItem().getSortingScore(ItemSortingType.KIND), paramItemStack2.getItem().getSortingScore(ItemSortingType.KIND)));
/*  29 */     SORT_COMPARATOR_RARITY_ASC = ((paramItemStack1, paramItemStack2) -> Integer.compare(paramItemStack1.getItem().getSortingScore(ItemSortingType.RARITY), paramItemStack2.getItem().getSortingScore(ItemSortingType.RARITY)));
/*  30 */     SORT_COMPARATOR_RARITY_DESC = ((paramItemStack1, paramItemStack2) -> Integer.compare(paramItemStack2.getItem().getSortingScore(ItemSortingType.RARITY), paramItemStack1.getItem().getSortingScore(ItemSortingType.RARITY)));
/*     */   }
/*     */   public static final Comparator<ItemStack> SORT_COMPARATOR_RARITY_ASC; public static final Comparator<ItemStack> SORT_COMPARATOR_RARITY_DESC;
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  34 */     paramKryo.writeClassAndObject(paramOutput, this.a);
/*  35 */     paramOutput.writeVarInt(this.b, true);
/*  36 */     paramOutput.writeBoolean(this.covered);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  41 */     this.a = (Item)paramKryo.readClassAndObject(paramInput);
/*  42 */     this.b = paramInput.readVarInt(true);
/*  43 */     this.covered = paramInput.readBoolean();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack(ItemStack paramItemStack) {
/*  49 */     this(paramItemStack.a, paramItemStack.b);
/*     */     
/*  51 */     this.covered = paramItemStack.covered;
/*     */   }
/*     */   
/*     */   public ItemStack(Item paramItem, int paramInt) {
/*  55 */     if (paramItem == null) throw new IllegalArgumentException("Item is null"); 
/*  56 */     if (paramInt <= 0) throw new IllegalArgumentException("Count is < 1 (" + paramInt + ")"); 
/*  57 */     this.a = paramItem;
/*  58 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */   public int getCount() {
/*  62 */     return this.b;
/*     */   }
/*     */   
/*     */   public void setCount(int paramInt) {
/*  66 */     this.b = MathUtils.clamp(paramInt, 0, 999999999);
/*     */   }
/*     */   
/*     */   public void add(int paramInt) {
/*  70 */     this.b = PMath.addWithoutOverflow(this.b, paramInt);
/*     */   }
/*     */   
/*     */   public void setItem(Item paramItem) {
/*  74 */     this.a = paramItem;
/*     */   }
/*     */   
/*     */   public ItemStack setItemAndCount(Item paramItem, int paramInt) {
/*  78 */     this.a = paramItem;
/*  79 */     setCount(paramInt);
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public Item getItem() {
/*  84 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack cpy() {
/*     */     ItemStack itemStack;
/*  90 */     (itemStack = new ItemStack(this.a, getCount())).covered = this.covered;
/*     */     
/*  92 */     return itemStack;
/*     */   }
/*     */   
/*     */   public void toJson(Json paramJson) {
/*  96 */     paramJson.writeObjectStart("i");
/*  97 */     this.a.toJson(paramJson);
/*  98 */     paramJson.writeObjectEnd();
/*     */     
/* 100 */     if (this.b > 1) paramJson.writeValue("c", Integer.valueOf(this.b));
/*     */   
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.a.toString() + " x" + this.b + ")";
/*     */   }
/*     */   @Null
/*     */   public static ItemStack fromJsonOrNull(@Null JsonValue paramJsonValue) {
/* 109 */     if (paramJsonValue == null) {
/* 110 */       return null;
/*     */     }
/* 112 */     return fromJson(paramJsonValue);
/*     */   }
/*     */   
/*     */   public static ItemStack fromJson(JsonValue paramJsonValue) {
/* 116 */     Preconditions.checkNotNull(paramJsonValue, "jsonValue can not be null");
/*     */     
/*     */     try {
/*     */       JsonValue jsonValue;
/* 120 */       if ((jsonValue = paramJsonValue.get("i")) == null) jsonValue = paramJsonValue.get("item");
/*     */       
/* 122 */       Item item = Item.fromJson(jsonValue);
/*     */       
/*     */       int i;
/* 125 */       if ((i = paramJsonValue.getInt("c", -1)) == -1) i = paramJsonValue.getInt("count", -1); 
/* 126 */       if (i == -1) i = 1;
/*     */       
/* 128 */       return new ItemStack(item, i);
/*     */ 
/*     */     
/*     */     }
/* 132 */     catch (Exception exception) {
/* 133 */       throw new RuntimeException("Unable to create ItemStack from json: " + paramJsonValue.toString(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ItemStack() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ItemStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */