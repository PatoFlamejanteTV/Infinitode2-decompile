/*     */ package com.prineside.tdi2.tiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.kryo.FixedInput;
/*     */ import com.prineside.kryo.FixedOutput;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.QuadRegion;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ import java.util.Objects;
/*     */ 
/*     */ @REGS
/*     */ public class QuadTile extends Tile {
/*  45 */   private static final TLog c = TLog.forClass(QuadTile.class);
/*     */   
/*     */   public boolean isStatic = true;
/*  48 */   public Color color = Color.WHITE.cpy(); @NAGS
/*  49 */   public Quad quad = new Quad(1.0F, 1.0F);
/*     */   
/*  51 */   private static final FixedOutput d = new FixedOutput(128, -1);
/*  52 */   private static final FixedInput e = new FixedInput();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  56 */     super.write(paramKryo, paramOutput);
/*  57 */     paramOutput.writeBoolean(this.isStatic);
/*  58 */     paramKryo.writeObject(paramOutput, this.color);
/*     */     
/*  60 */     d.clear();
/*  61 */     if (this.quad == null) {
/*  62 */       paramOutput.writeVarInt(0, true); return;
/*     */     } 
/*  64 */     this.quad.toBytes(d);
/*  65 */     paramOutput.writeVarInt(d.position(), true);
/*  66 */     paramOutput.writeBytes(d.getBuffer(), 0, d.position());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  72 */     super.read(paramKryo, paramInput);
/*  73 */     this.isStatic = paramInput.readBoolean();
/*  74 */     this.color = (Color)paramKryo.readObject(paramInput, Color.class);
/*     */     int i;
/*  76 */     if ((i = paramInput.readVarInt(true)) != 0) {
/*  77 */       byte[] arrayOfByte = paramInput.readBytes(i);
/*     */       try {
/*  79 */         e.setBuffer(arrayOfByte);
/*  80 */         this.quad = Quad.fromBytes(e); return;
/*  81 */       } catch (Exception exception) {}
/*     */     } 
/*     */   }
/*     */   
/*     */   private QuadTile() {
/*  86 */     super(TileType.QUAD);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeSelected() {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/*  96 */     Label label = new Label(this.isStatic ? "Static" : "Dynamic", Game.i.assetManager.getLabelStyle(24));
/*  97 */     if (this.isStatic) {
/*  98 */       label.setColor(MaterialColor.GREEN.P500);
/*     */     } else {
/* 100 */       label.setColor(MaterialColor.YELLOW.P500);
/*     */     } 
/* 102 */     paramTable.add((Actor)label);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillInventoryWithInfo(Table paramTable, float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/* 112 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRoadType() {
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 122 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getInventorySubcategory() {
/* 127 */     return ItemSubcategoryType.ME_SPECIAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Tile paramTile) {
/* 132 */     if (!super.sameAs(paramTile)) return false;
/*     */     
/*     */     QuadTile quadTile;
/* 135 */     if ((quadTile = (QuadTile)paramTile).isStatic != this.isStatic) return false; 
/* 136 */     if (!Objects.equals(this.color, quadTile.color)) return false;
/*     */     
/* 138 */     return Objects.equals(this.quad, ((QuadTile)paramTile).quad);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void from(Tile paramTile) {
/* 144 */     super.from(paramTile);
/* 145 */     paramTile = paramTile;
/*     */     
/* 147 */     this.color.set(((QuadTile)paramTile).color);
/* 148 */     this.isStatic = ((QuadTile)paramTile).isStatic;
/* 149 */     this.quad = new Quad(((QuadTile)paramTile).quad, true);
/*     */   }
/*     */   @Null
/*     */   public Quad getQuad() {
/* 153 */     return this.quad;
/*     */   }
/*     */ 
/*     */   
/*     */   public Group generateUiIcon(float paramFloat) {
/* 158 */     Quad quad1 = getQuad();
/*     */     
/*     */     Rectangle rectangle;
/* 161 */     (rectangle = new Rectangle()).height = quad1.getHeight();
/* 162 */     rectangle.width = quad1.getWidth();
/* 163 */     for (byte b1 = 0; b1 < (quad1.getRegions()).size; b1++) {
/* 164 */       QuadRegion quadRegion = ((QuadRegion[])(quad1.getRegions()).items)[b1];
/* 165 */       rectangle.x = Math.min(rectangle.x, quadRegion.getX());
/* 166 */       rectangle.y = Math.min(rectangle.y, quadRegion.getY());
/* 167 */       rectangle.width = Math.max(rectangle.width, quadRegion.getWidth() + quadRegion.getX());
/* 168 */       rectangle.height = Math.max(rectangle.height, quadRegion.getHeight() + quadRegion.getY());
/*     */     } 
/*     */ 
/*     */     
/*     */     Quad quad2;
/*     */     
/* 174 */     (quad2 = new Quad(quad1, true)).setWidth(-rectangle.x + rectangle.width);
/* 175 */     quad2.setHeight(-rectangle.y + rectangle.height);
/* 176 */     for (byte b2 = 0; b2 < (quad2.getRegions()).size; b2++) {
/*     */       QuadRegion quadRegion;
/* 178 */       (quadRegion = ((QuadRegion[])(quad2.getRegions()).items)[b2]).translate(-rectangle.x, -rectangle.y);
/*     */     } 
/*     */     
/*     */     Group group;
/* 182 */     (group = new Group()).setTransform(false);
/* 183 */     group.setSize(paramFloat, paramFloat);
/*     */     
/*     */     Image image;
/* 186 */     (image = new Image((Drawable)quad2)).setColor(this.color);
/* 187 */     image.setSize(paramFloat, paramFloat);
/* 188 */     group.addActor((Actor)image);
/*     */     
/* 190 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 195 */     super.toJson(paramJson);
/*     */     
/* 197 */     paramJson.writeObjectStart("d");
/*     */     
/* 199 */     paramJson.writeValue("q", this.quad.toBase64());
/*     */     
/* 201 */     if (this.color != null) paramJson.writeValue("c", this.color.toString()); 
/* 202 */     paramJson.writeValue("s", Boolean.valueOf(this.isStatic));
/*     */     
/* 204 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 209 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */     
/* 211 */     if (paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/* 212 */       paramBatch.setColor(1.0F, 1.0F, 0.0F, 0.07F);
/* 213 */       paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 214 */       paramBatch.setColor(Color.WHITE);
/*     */     } 
/*     */     
/* 217 */     if (this.isStatic) {
/* 218 */       paramBatch.setColor(this.color);
/* 219 */       getQuad().draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 220 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {
/* 226 */     if (!this.isStatic) {
/* 227 */       paramBatch.setColor(this.color);
/* 228 */       getQuad().draw(paramBatch, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
/* 229 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 235 */     paramItemCreationOverlay.label("Quad code");
/* 236 */     paramItemCreationOverlay.textFieldOfWidth(this.quad.toBase64(), 800.0F, paramString -> {
/*     */           try {
/*     */             this.quad = Quad.fromString(paramString);
/* 239 */           } catch (Exception exception) {}
/*     */           
/*     */           paramItemCreationOverlay.updateItemIcon();
/*     */         });
/*     */     
/* 244 */     paramItemCreationOverlay.label("Color");
/* 245 */     paramItemCreationOverlay.textField(this.color.toString().toUpperCase(Locale.US), paramString -> {
/*     */           try {
/*     */             this.color.set(Color.valueOf(paramString)); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 249 */           } catch (Exception exception) {
/*     */             return;
/*     */           } 
/* 252 */         }); paramItemCreationOverlay.toggle(true, "Static", this.isStatic, paramBoolean -> {
/*     */           this.isStatic = paramBoolean.booleanValue();
/*     */           paramItemCreationOverlay.updateForm();
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/* 260 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPrestigeScore() {
/* 265 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeUpgraded() {
/* 270 */     return false;
/*     */   }
/*     */   
/*     */   public static class QuadTileFactory extends Tile.Factory.AbstractFactory<QuadTile> {
/*     */     public QuadTileFactory() {
/* 275 */       super(TileType.QUAD);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 280 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public QuadTile create() {
/* 290 */       return new QuadTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public QuadTile fromJson(JsonValue param1JsonValue) {
/* 295 */       QuadTile quadTile = (QuadTile)super.fromJson(param1JsonValue);
/*     */ 
/*     */       
/* 298 */       if ((param1JsonValue = param1JsonValue.get("d")) != null) {
/*     */         try {
/* 300 */           quadTile.quad = Quad.fromString(param1JsonValue.getString("q"));
/* 301 */         } catch (Exception exception) {
/* 302 */           QuadTile.a().e("failed to load quad from json", new Object[] { exception });
/* 303 */           quadTile.quad = new Quad(Quad.getNoQuad(), true);
/*     */         } 
/*     */         
/*     */         try {
/* 307 */           quadTile.color.set(Color.valueOf(param1JsonValue.getString("c", Color.WHITE.toString())));
/* 308 */         } catch (Exception exception) {}
/* 309 */         quadTile.isStatic = param1JsonValue.getBoolean("s", true);
/*     */       } 
/*     */       
/* 312 */       return quadTile;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\QuadTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */