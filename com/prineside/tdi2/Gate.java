/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(arrayLevels = 3, classOnly = true)
/*     */ public abstract class Gate
/*     */   extends Registrable
/*     */ {
/*     */   public static final float THICKNESS = 28.0F;
/*     */   private GateType a;
/*     */   private boolean b;
/*     */   private int c;
/*     */   private int d;
/*     */   @NAGS
/*     */   public ParticleEffectPool.PooledEffect highlightParticleA;
/*     */   @NAGS
/*     */   public ParticleEffectPool.PooledEffect highlightParticleB;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  42 */     super.write(paramKryo, paramOutput);
/*  43 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GateType.class);
/*  44 */     paramOutput.writeBoolean(this.b);
/*  45 */     paramOutput.writeVarInt(this.c, true);
/*  46 */     paramOutput.writeVarInt(this.d, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  51 */     super.read(paramKryo, paramInput);
/*  52 */     this.a = (GateType)paramKryo.readObjectOrNull(paramInput, GateType.class);
/*  53 */     this.b = paramInput.readBoolean();
/*  54 */     this.c = paramInput.readVarInt(true);
/*  55 */     this.d = paramInput.readVarInt(true);
/*     */   }
/*     */   
/*     */   protected Gate(GateType paramGateType) {
/*  59 */     this.a = paramGateType;
/*     */   }
/*     */   
/*     */   public GateType getType() {
/*  63 */     return this.a;
/*     */   }
/*     */   
/*     */   public abstract RarityType getRarity();
/*     */   
/*     */   public abstract Gate cloneGate();
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {}
/*     */   
/*     */   public void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {}
/*     */   
/*     */   public Rectangle getBoundingBox() {
/*  75 */     if (this.b) {
/*  76 */       return new Rectangle((this.c << 7) - 14.0F, (this.d << 7), 28.0F, 128.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     return new Rectangle((this.c << 7), (this.d << 7) - 14.0F, 128.0F, 28.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract double getPrestigeScore();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getSortingScore(ItemSortingType paramItemSortingType);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Actor generateIcon(float paramFloat, boolean paramBoolean);
/*     */ 
/*     */   
/*     */   public abstract void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */ 
/*     */   
/*     */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
/*     */ 
/*     */   
/*     */   public boolean sameAs(Gate paramGate) {
/* 106 */     if (paramGate == null) return false; 
/* 107 */     return (paramGate.getType() == getType());
/*     */   }
/*     */   
/*     */   public int getX() {
/* 111 */     return this.c;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 115 */     return this.d;
/*     */   }
/*     */   
/*     */   public boolean isLeftSide() {
/* 119 */     return this.b;
/*     */   }
/*     */   
/*     */   public void setPosition(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 123 */     this.c = paramInt1;
/* 124 */     this.d = paramInt2;
/* 125 */     this.b = paramBoolean;
/*     */   }
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 129 */     paramJson.writeValue("type", this.a.name());
/* 130 */     if (this.c != 0) paramJson.writeValue("x", Integer.valueOf(this.c)); 
/* 131 */     if (this.d != 0) paramJson.writeValue("y", Integer.valueOf(this.d)); 
/* 132 */     if (this.b) paramJson.writeValue("side", "LEFT"); 
/*     */   }
/*     */   public static interface Factory<T extends Gate> extends Disposable, EntityFactory { void setup();
/*     */     CharSequence getTitle(Gate param1Gate);
/*     */     
/*     */     CharSequence getDescription(Gate param1Gate);
/*     */     
/*     */     T create();
/*     */     
/*     */     T createRandom(float param1Float, RandomXS128 param1RandomXS128);
/*     */     
/*     */     T fromJson(JsonValue param1JsonValue);
/*     */     
/*     */     public static abstract class AbstractFactory<T extends Gate> implements Factory<T> { private final String a;
/*     */       
/*     */       public AbstractFactory(GateType param2GateType) {
/* 148 */         this.a = "gate_name_" + param2GateType.name();
/* 149 */         this.b = "gate_description_" + param2GateType.name();
/*     */       }
/*     */       private final String b;
/*     */       
/*     */       public CharSequence getTitle(Gate param2Gate) {
/* 154 */         return Game.i.localeManager.i18n.get(this.a);
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence getDescription(Gate param2Gate) {
/* 159 */         return Game.i.localeManager.i18n.get(this.b);
/*     */       }
/*     */ 
/*     */       
/*     */       public void setup() {
/* 164 */         if (Game.i.assetManager != null) {
/* 165 */           setupAssets();
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public void setupAssets() {}
/*     */       
/*     */       public T fromJson(JsonValue param2JsonValue) {
/* 173 */         T t = create();
/* 174 */         int i = param2JsonValue.getInt("x", 0);
/* 175 */         int j = param2JsonValue.getInt("y", 0);
/*     */         
/* 177 */         boolean bool = false;
/* 178 */         if (param2JsonValue.get("side") != null) {
/* 179 */           bool = "LEFT".equals(param2JsonValue.getString("side"));
/*     */         }
/* 181 */         t.setPosition(i, j, bool);
/*     */         
/* 183 */         return t;
/*     */       }
/*     */       
/*     */       public void dispose() {} }
/*     */      }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class Pos
/*     */     implements KryoSerializable, MapElementPos
/*     */   {
/*     */     private int a;
/*     */     private int b;
/*     */     private boolean c;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 199 */       param1Output.writeVarInt(this.a, true);
/* 200 */       param1Output.writeVarInt(this.b, true);
/* 201 */       param1Output.writeBoolean(this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 206 */       this.a = param1Input.readVarInt(true);
/* 207 */       this.b = param1Input.readVarInt(true);
/* 208 */       this.c = param1Input.readBoolean();
/*     */     }
/*     */     
/*     */     public Pos() {}
/*     */     
/*     */     public Pos(Pos param1Pos) {
/* 214 */       this(param1Pos.getX(), param1Pos.getY(), param1Pos.c);
/*     */     }
/*     */     
/*     */     public Pos(Gate param1Gate) {
/* 218 */       this(param1Gate.getX(), param1Gate.getY(), param1Gate.isLeftSide());
/*     */     }
/*     */     
/*     */     public Pos(int param1Int1, int param1Int2, boolean param1Boolean) {
/* 222 */       this.a = param1Int1;
/* 223 */       this.b = param1Int2;
/* 224 */       this.c = param1Boolean;
/*     */     }
/*     */     
/*     */     public void set(Pos param1Pos) {
/* 228 */       Preconditions.checkNotNull(param1Pos);
/* 229 */       this.a = param1Pos.getX();
/* 230 */       this.b = param1Pos.getY();
/* 231 */       this.c = param1Pos.isLeft();
/*     */     }
/*     */     
/*     */     public int getX() {
/* 235 */       return this.a;
/*     */     }
/*     */     
/*     */     public void setX(int param1Int) {
/* 239 */       this.a = param1Int;
/*     */     }
/*     */     
/*     */     public int getY() {
/* 243 */       return this.b;
/*     */     }
/*     */     
/*     */     public void setY(int param1Int) {
/* 247 */       this.b = param1Int;
/*     */     }
/*     */     
/*     */     public boolean isLeft() {
/* 251 */       return this.c;
/*     */     }
/*     */     
/*     */     public void setLeft(boolean param1Boolean) {
/* 255 */       this.c = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean is(int param1Int1, int param1Int2, boolean param1Boolean) {
/* 259 */       return (param1Int1 == this.a && param1Int2 == this.b && this.c == param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 264 */       return super.toString() + " (" + this.a + ":" + this.b + ":" + this.c + ")";
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 269 */       if (param1Object == this)
/* 270 */         return true; 
/* 271 */       if (!(param1Object instanceof Pos)) {
/* 272 */         return false;
/*     */       }
/* 274 */       if (((Pos)(param1Object = param1Object)).a == this.a && ((Pos)param1Object).b == this.b && ((Pos)param1Object).c == this.c) return true;  return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 280 */       int i = 961 + this.a;
/* 281 */       i = i * 31 + this.b;
/*     */       
/* 283 */       return i = i * 31 + (this.c ? 1 : 2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Gate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */