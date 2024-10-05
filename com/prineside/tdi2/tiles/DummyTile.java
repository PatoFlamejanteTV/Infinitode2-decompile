/*     */ package com.prineside.tdi2.tiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.ui.TextArea;
/*     */ import com.prineside.tdi2.scene2d.ui.TextField;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ @REGS
/*     */ public final class DummyTile extends Tile {
/*  51 */   private static final TLog c = TLog.forClass(DummyTile.class);
/*     */   
/*  53 */   public static float DEFAULT_SCALE = 0.75F;
/*     */   
/*     */   @NAGS
/*     */   private long d;
/*  57 */   public ObjectMap<String, Object> data = new ObjectMap();
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean selectable = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean visible = false;
/*     */ 
/*     */ 
/*     */   
/*  69 */   public float iconScale = DEFAULT_SCALE;
/*     */   public String icon;
/*     */   public String description;
/*  72 */   public Color color = Color.WHITE.cpy();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  76 */     super.write(paramKryo, paramOutput);
/*  77 */     paramOutput.writeLong(this.d);
/*  78 */     paramOutput.writeBoolean(this.selectable);
/*  79 */     paramOutput.writeBoolean(this.visible);
/*  80 */     paramOutput.writeFloat(this.iconScale);
/*  81 */     paramKryo.writeObject(paramOutput, this.data);
/*  82 */     paramKryo.writeObjectOrNull(paramOutput, this.icon, String.class);
/*  83 */     paramKryo.writeObjectOrNull(paramOutput, this.description, String.class);
/*  84 */     paramKryo.writeObject(paramOutput, this.color);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  89 */     super.read(paramKryo, paramInput);
/*  90 */     this.d = paramInput.readLong();
/*  91 */     this.selectable = paramInput.readBoolean();
/*  92 */     this.visible = paramInput.readBoolean();
/*  93 */     this.iconScale = paramInput.readFloat();
/*  94 */     this.data = (ObjectMap<String, Object>)paramKryo.readObject(paramInput, ObjectMap.class);
/*  95 */     this.icon = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*  96 */     this.description = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*  97 */     this.color = (Color)paramKryo.readObject(paramInput, Color.class);
/*     */   }
/*     */   
/*     */   private DummyTile() {
/* 101 */     super(TileType.DUMMY);
/*     */     
/* 103 */     setId(PMath.generateNewId());
/*     */   }
/*     */   
/*     */   public final long getId() {
/* 107 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void setId(long paramLong) {
/* 111 */     this.d = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 116 */     return (this.description == null) ? "" : this.description;
/*     */   }
/*     */   
/*     */   public final Object getData(String paramString) {
/* 120 */     return this.data.get(paramString, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeSelected() {
/* 125 */     return this.selectable;
/*     */   }
/*     */   
/*     */   public final void removeData(String paramString) {
/* 129 */     this.data.remove(paramString);
/*     */   }
/*     */   
/*     */   public final void setData(String paramString, Object paramObject) {
/* 133 */     switch (paramString.charAt(0)) {
/*     */       case 'c':
/* 135 */         if (paramObject == null) paramObject = Color.WHITE.cpy();
/*     */         
/* 137 */         if (paramObject instanceof Color) {
/* 138 */           this.data.put(paramString, paramObject); return;
/*     */         } 
/* 140 */         c.e("key " + paramString + " is for Color, " + paramObject.getClass().getSimpleName() + " given", new Object[0]);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 'i':
/* 145 */         if (paramObject == null) paramObject = Integer.valueOf(0);
/*     */         
/* 147 */         if (paramObject instanceof Integer) {
/* 148 */           this.data.put(paramString, paramObject); return;
/*     */         } 
/* 150 */         c.e("key " + paramString + " is for Integer, " + paramObject.getClass().getSimpleName() + " given", new Object[0]);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 'd':
/* 155 */         if (paramObject == null) paramObject = Double.valueOf(0.0D);
/*     */         
/* 157 */         if (paramObject instanceof Double) {
/* 158 */           this.data.put(paramString, paramObject); return;
/*     */         } 
/* 160 */         c.e("key " + paramString + " is for Double, " + paramObject.getClass().getSimpleName() + " given", new Object[0]);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 'b':
/* 165 */         if (paramObject == null) paramObject = Boolean.FALSE;
/*     */         
/* 167 */         if (paramObject instanceof Boolean) {
/* 168 */           this.data.put(paramString, paramObject); return;
/*     */         } 
/* 170 */         c.e("key " + paramString + " is for Boolean, " + paramObject.getClass().getSimpleName() + " given", new Object[0]);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 'S':
/*     */       case 's':
/* 176 */         if (paramObject == null) paramObject = "";
/*     */         
/* 178 */         if (paramObject instanceof String) {
/* 179 */           this.data.put(paramString, paramObject); return;
/*     */         } 
/* 181 */         c.e("key " + paramString + " is for String, " + paramObject.getClass().getSimpleName() + " given", new Object[0]);
/*     */         return;
/*     */     } 
/*     */ 
/*     */     
/* 186 */     c.e("key \"" + paramString + "\" is invalid and should start with data type (idbscS)", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/* 193 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/* 195 */     Table table2 = new Table();
/* 196 */     paramTable.add((Actor)table2).padBottom(4.0F).growX().row();
/*     */     
/* 198 */     table2.add().height(1.0F).growX();
/*     */     
/*     */     Label label2;
/* 201 */     (label2 = new Label(Long.toHexString(getId()), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 202 */     label2.setAlignment(16);
/* 203 */     table2.add((Actor)label2);
/*     */     
/* 205 */     Label label1 = new Label(this.selectable ? "Can be selected" : "Can not be selected", Game.i.assetManager.getLabelStyle(21));
/* 206 */     if (this.selectable) {
/* 207 */       label1.setColor(MaterialColor.GREEN.P500);
/*     */     } else {
/* 209 */       label1.setColor(MaterialColor.YELLOW.P500);
/*     */     } 
/* 211 */     paramTable.add((Actor)label1).growX().padBottom(8.0F).row();
/*     */     
/* 213 */     label1 = new Label(this.visible ? "Visible" : "Not visible", Game.i.assetManager.getLabelStyle(21));
/* 214 */     if (this.visible) {
/* 215 */       label1.setColor(MaterialColor.GREEN.P500);
/*     */     } else {
/* 217 */       label1.setColor(MaterialColor.YELLOW.P500);
/*     */     } 
/* 219 */     paramTable.add((Actor)label1).growX().row();
/*     */ 
/*     */     
/* 222 */     (label1 = new Label(getDescription(), Game.i.assetManager.getLabelStyle(21))).setAlignment(10);
/* 223 */     label1.setWrap(true);
/* 224 */     paramTable.add((Actor)label1).padTop(8.0F).padBottom(8.0F).growX().row();
/*     */ 
/*     */     
/* 227 */     Table table1 = new Table();
/* 228 */     paramTable.add((Actor)table1).growX().row();
/*     */     
/* 230 */     byte b = 0;
/* 231 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.data.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 232 */       Table table = new Table();
/* 233 */       paramMapEditorItemInfoMenu.listRowBg(b, table);
/* 234 */       table1.add((Actor)table).growX().minHeight(32.0F).row();
/*     */       
/*     */       Label label4;
/* 237 */       (label4 = new Label((CharSequence)entry.key, Game.i.assetManager.getSmallDebugLabelStyle())).setAlignment(8);
/* 238 */       label4.setColor(MaterialColor.AMBER.P500);
/* 239 */       table.add((Actor)label4).top().left().width(120.0F).padBottom(4.0F).padTop(4.0F);
/*     */       
/*     */       String str;
/* 242 */       if ((str = String.valueOf(entry.value)).length() > 250) {
/* 243 */         str = str.substring(0, 250) + "...";
/*     */       }
/*     */       Label label3;
/* 246 */       (label3 = new Label(str, Game.i.assetManager.getSmallDebugLabelStyle())).setWrap(true);
/* 247 */       table.add((Actor)label3).top().left().growX().padBottom(4.0F).padTop(4.0F).row();
/*     */       
/* 249 */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*     */     Label label;
/* 256 */     if (this.selectable) {
/*     */       
/* 258 */       (label = new Label("Can be selected", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.GREEN.P500);
/*     */     } else {
/*     */       
/* 261 */       (label = new Label("Can not be selected", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.YELLOW.P500);
/*     */     } 
/* 263 */     paramTable.add((Actor)label).row();
/*     */ 
/*     */     
/* 266 */     if (this.visible) {
/*     */       
/* 268 */       (label = new Label("Visible", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.GREEN.P500);
/*     */     } else {
/*     */       
/* 271 */       (label = new Label("Invisible", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.YELLOW.P500);
/*     */     } 
/* 273 */     paramTable.add((Actor)label).row();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/* 278 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 283 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 288 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 293 */     return ItemSubcategoryType.ME_SPECIAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 298 */     if (!super.sameAs(paramTile)) return false;
/*     */     
/* 300 */     return (getId() == ((DummyTile)paramTile).getId());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 306 */     super.from(paramTile);
/* 307 */     paramTile = paramTile;
/*     */     
/* 309 */     setId(paramTile.getId());
/* 310 */     this.selectable = ((DummyTile)paramTile).selectable;
/* 311 */     this.visible = ((DummyTile)paramTile).visible;
/* 312 */     this.iconScale = ((DummyTile)paramTile).iconScale;
/* 313 */     this.description = ((DummyTile)paramTile).description;
/* 314 */     this.icon = ((DummyTile)paramTile).icon;
/* 315 */     this.data.clear();
/* 316 */     this.data.putAll(((DummyTile)paramTile).data);
/* 317 */     this.color.set(((DummyTile)paramTile).color);
/*     */   }
/*     */   
/*     */   public final TextureRegion getTexture() {
/* 321 */     if (this.icon == null) {
/* 322 */       return (TextureRegion)Game.i.assetManager.getTextureRegion("icon-question");
/*     */     }
/*     */     ResourcePack.AtlasTextureRegion atlasTextureRegion;
/* 325 */     if ((atlasTextureRegion = Game.i.assetManager.getTextureRegionSetThrowing(this.icon, false)) == null) {
/* 326 */       atlasTextureRegion = Game.i.assetManager.getTextureRegion("icon-question");
/*     */     }
/*     */     
/* 329 */     return (TextureRegion)atlasTextureRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/*     */     Group group;
/* 335 */     (group = new Group()).setTransform(false);
/* 336 */     group.setSize(paramFloat, paramFloat);
/*     */     
/*     */     Image image;
/* 339 */     (image = new Image(getTexture())).setColor(this.color);
/* 340 */     image.setSize(paramFloat * this.iconScale, paramFloat * this.iconScale);
/* 341 */     image.setPosition(paramFloat * (1.0F - this.iconScale) * 0.5F, paramFloat * (1.0F - this.iconScale) * 0.5F);
/* 342 */     group.addActor((Actor)image);
/*     */     
/* 344 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 349 */     super.toJson(paramJson);
/*     */     
/* 351 */     paramJson.writeObjectStart("d");
/*     */     
/* 353 */     paramJson.writeValue("id", Long.valueOf(getId()));
/* 354 */     paramJson.writeObjectStart("d");
/* 355 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.data.iterator(); entries.hasNext(); ) {
/* 356 */       ObjectMap.Entry entry; if (((String)(entry = entries.next()).key).charAt(0) == 'c') {
/* 357 */         paramJson.writeValue((String)entry.key, ((Color)entry.value).toString()); continue;
/*     */       } 
/* 359 */       paramJson.writeValue((String)entry.key, entry.value);
/*     */     } 
/*     */     
/* 362 */     paramJson.writeObjectEnd();
/*     */     
/* 364 */     if (this.selectable) paramJson.writeValue("s", Boolean.valueOf(this.selectable)); 
/* 365 */     if (this.visible) paramJson.writeValue("v", Boolean.valueOf(this.visible)); 
/* 366 */     if (this.icon != null) paramJson.writeValue("i", this.icon); 
/* 367 */     paramJson.writeValue("is", Float.valueOf(this.iconScale));
/* 368 */     if (this.description != null) paramJson.writeValue("dsc", this.description); 
/* 369 */     if (this.color != null) paramJson.writeValue("c", this.color.toString());
/*     */     
/* 371 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 376 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */     
/* 378 */     if (this.visible || paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/* 379 */       paramBatch.setColor(this.color);
/* 380 */       paramBatch.draw(getTexture(), paramFloat1 + paramFloat3 * (1.0F - this.iconScale) * 0.5F, paramFloat2 + paramFloat4 * (1.0F - this.iconScale) * 0.5F, paramFloat3 * this.iconScale, paramFloat4 * this.iconScale);
/* 381 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 387 */     paramItemCreationOverlay.label("ID");
/* 388 */     paramItemCreationOverlay.textFieldEndRow(String.valueOf(getId()), 300.0F, paramString -> {
/*     */           try {
/*     */             setId(Long.parseLong(paramString)); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 392 */           } catch (Exception exception) {
/*     */             c.e("bad value: " + paramString, new Object[0]);
/*     */             
/*     */             return;
/*     */           } 
/*     */         }false);
/*     */     
/*     */     PaddedImageButton paddedImageButton;
/*     */     
/* 401 */     (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-restart"), () -> { setId(PMath.generateNewId()); paramItemCreationOverlay.updateForm(); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setIconSize(40.0F, 40.0F);
/* 402 */     paddedImageButton.setIconPosition(12.0F, 12.0F);
/* 403 */     paramItemCreationOverlay.form.add((Actor)paddedImageButton).top().left().padLeft(10.0F).size(64.0F).row();
/*     */     
/* 405 */     paramItemCreationOverlay.toggle("Can be selected", this.selectable, paramBoolean -> this.selectable = paramBoolean.booleanValue());
/* 406 */     paramItemCreationOverlay.toggle("Visible", this.visible, paramBoolean -> this.visible = paramBoolean.booleanValue());
/*     */     
/* 408 */     paramItemCreationOverlay.label("Icon scale");
/* 409 */     paramItemCreationOverlay.textFieldOfWidth(this.iconScale, 300.0F, paramString -> {
/*     */           try {
/*     */             this.iconScale = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 413 */           } catch (Exception exception) {
/*     */             return;
/*     */           } 
/* 416 */         }); paramItemCreationOverlay.label("Description");
/* 417 */     paramItemCreationOverlay.textFieldOfWidth((this.description == null) ? "" : this.description, 800.0F, paramString -> this.description = paramString.equals("") ? null : paramString);
/*     */     
/* 419 */     paramItemCreationOverlay.label("Icon");
/* 420 */     paramItemCreationOverlay.textField((this.icon == null) ? "" : this.icon, paramString -> {
/*     */           this.icon = paramString.equals("") ? null : paramString;
/*     */           
/*     */           paramItemCreationOverlay.updateItemIcon();
/*     */         });
/* 425 */     paramItemCreationOverlay.label("Color");
/* 426 */     paramItemCreationOverlay.textField(this.color.toString().toUpperCase(Locale.US), paramString -> {
/*     */           try {
/*     */             this.color.set(Color.valueOf(paramString)); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 430 */           } catch (Exception exception) {
/*     */             return;
/*     */           } 
/* 433 */         }); paramItemCreationOverlay.label("Data");
/* 434 */     Table table1 = new Table();
/* 435 */     paramItemCreationOverlay.form.add((Actor)table1).width(800.0F).top().left().row();
/*     */     
/* 437 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.data.iterator(); entries.hasNext(); ) {
/* 438 */       ScrollPane scrollPane; TextFieldXPlatform textFieldXPlatform2; Image image; TextFieldXPlatform textFieldXPlatform1; TextField.TextFieldStyle textFieldStyle; TextFieldXPlatform textFieldXPlatform3; TextArea textArea; ObjectMap.Entry entry; String str = (String)(entry = entries.next()).key;
/*     */       
/* 440 */       Table table3 = new Table();
/* 441 */       table1.add((Actor)table3).expandX().fillX().row();
/*     */       
/* 443 */       Table table4 = new Table();
/* 444 */       table3.add((Actor)table4).top().left().width(200.0F).padRight(10.0F).minHeight(48.0F);
/*     */       
/*     */       Label label;
/* 447 */       (label = new Label((CharSequence)entry.key, Game.i.assetManager.getLabelStyle(24))).setAlignment(8);
/* 448 */       label.setColor(MaterialColor.AMBER.P500);
/* 449 */       table4.add((Actor)label).top().left().width(200.0F).row();
/*     */ 
/*     */       
/* 452 */       (label = new Label("", Game.i.assetManager.getLabelStyle(21))).setAlignment(8);
/* 453 */       label.setColor(MaterialColor.GREY.P500);
/* 454 */       table4.add((Actor)label).top().left().row();
/* 455 */       switch (((String)entry.key).charAt(0)) { case 'c':
/* 456 */           label.setText("color"); break;
/* 457 */         case 's': label.setText("string"); break;
/* 458 */         case 'S': label.setText("multiline string"); break;
/* 459 */         case 'd': label.setText("double"); break;
/* 460 */         case 'b': label.setText("boolean"); break;
/* 461 */         case 'i': label.setText("int");
/*     */           break; }
/*     */       
/* 464 */       table4 = new Table();
/* 465 */       table3.add((Actor)table4).top().left().width(532.0F).padBottom(10.0F).padRight(10.0F).minHeight(48.0F);
/*     */       
/* 467 */       switch (((String)entry.key).charAt(0)) {
/*     */         
/*     */         case 'i':
/* 470 */           (textFieldXPlatform2 = new TextFieldXPlatform(String.valueOf(entry.value), paramItemCreationOverlay.textFieldStyle)).setSize(200.0F, 48.0F);
/* 471 */           textFieldXPlatform2.addListener((EventListener)new ChangeListener(this, textFieldXPlatform2, str)
/*     */               {
/*     */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */                   try {
/* 475 */                     int i = Integer.parseInt(this.a.getText());
/* 476 */                     this.c.setData(this.b, Integer.valueOf(i)); return;
/* 477 */                   } catch (Exception exception) {
/* 478 */                     DummyTile.a().e("invalid value", new Object[] { exception });
/*     */                     return;
/*     */                   }  }
/*     */               });
/* 482 */           table4.add((Actor)textFieldXPlatform2).size(200.0F, 48.0F).top().left();
/* 483 */           table4.add().expandX().fillX();
/*     */           break;
/*     */ 
/*     */         
/*     */         case 'd':
/* 488 */           (textFieldXPlatform2 = new TextFieldXPlatform(String.valueOf(entry.value), paramItemCreationOverlay.textFieldStyle)).setSize(200.0F, 48.0F);
/* 489 */           textFieldXPlatform2.addListener((EventListener)new ChangeListener(this, textFieldXPlatform2, str)
/*     */               {
/*     */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */                   try {
/* 493 */                     double d = Double.parseDouble(this.a.getText());
/* 494 */                     this.c.setData(this.b, Double.valueOf(d)); return;
/* 495 */                   } catch (Exception exception) {
/* 496 */                     DummyTile.a().e("invalid value", new Object[] { exception });
/*     */                     return;
/*     */                   }  }
/*     */               });
/* 500 */           table4.add((Actor)textFieldXPlatform2).size(200.0F, 48.0F).top().left();
/* 501 */           table4.add().expandX().fillX();
/*     */           break;
/*     */         
/*     */         case 'c':
/* 505 */           image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*     */ 
/*     */           
/* 508 */           (textFieldXPlatform3 = new TextFieldXPlatform(entry.value.toString().toUpperCase(), paramItemCreationOverlay.textFieldStyle)).setSize(200.0F, 48.0F);
/* 509 */           textFieldXPlatform3.addListener((EventListener)new ChangeListener(this, textFieldXPlatform3, str, image)
/*     */               {
/*     */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */                   try {
/* 513 */                     Color color = Color.valueOf(this.a.getText());
/* 514 */                     this.d.setData(this.b, color);
/* 515 */                     this.c.setColor(color); return;
/* 516 */                   } catch (Exception exception) {
/* 517 */                     DummyTile.a().e("invalid value", new Object[] { exception });
/*     */                     return;
/*     */                   }  }
/*     */               });
/* 521 */           table4.add((Actor)textFieldXPlatform3).size(200.0F, 48.0F).top().left();
/*     */           
/* 523 */           image.setColor((Color)entry.value);
/* 524 */           table4.add((Actor)image).size(48.0F).padLeft(10.0F).top().left();
/*     */           
/* 526 */           table4.add().expandX().fillX();
/*     */           break;
/*     */ 
/*     */         
/*     */         case 's':
/* 531 */           (textFieldXPlatform1 = new TextFieldXPlatform((String)entry.value, paramItemCreationOverlay.textFieldStyle)).setSize(590.0F, 48.0F);
/* 532 */           textFieldXPlatform1.addListener((EventListener)new ChangeListener(this, str, textFieldXPlatform1)
/*     */               {
/*     */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */                   try {
/* 536 */                     this.c.setData(this.a, this.b.getText()); return;
/* 537 */                   } catch (Exception exception) {
/* 538 */                     DummyTile.a().e("invalid value", new Object[] { exception });
/*     */                     return;
/*     */                   }  }
/*     */               });
/* 542 */           table4.add((Actor)textFieldXPlatform1).height(48.0F).top().left().expandX().fillX();
/*     */           break;
/*     */ 
/*     */         
/*     */         case 'S':
/* 547 */           (textFieldStyle = Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true)).background.setLeftWidth(textFieldStyle.background.getLeftWidth() + 10.0F);
/* 548 */           textFieldStyle.background.setRightWidth(textFieldStyle.background.getRightWidth() + 10.0F);
/* 549 */           textFieldStyle.background.setBottomHeight(textFieldStyle.background.getBottomHeight() + 5.0F);
/* 550 */           textFieldStyle.background.setTopHeight(textFieldStyle.background.getTopHeight() + 10.0F);
/*     */           
/* 552 */           textArea = new TextArea((String)entry.value, textFieldStyle);
/*     */           
/* 554 */           UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)textArea, Game.i.assetManager.getScrollPaneStyle(12.0F)));
/* 555 */           textArea.setOnlyFontChars(false);
/* 556 */           textArea.setProgrammaticChangeEvents(true);
/*     */           
/* 558 */           textArea.addListener((EventListener)new ChangeListener(this, str, textArea)
/*     */               {
/*     */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */                   try {
/* 562 */                     this.c.setData(this.a, this.b.getText()); return;
/* 563 */                   } catch (Exception exception) {
/* 564 */                     DummyTile.a().e("invalid value", new Object[] { exception });
/*     */                     return;
/*     */                   }  }
/*     */               });
/* 568 */           table4.add((Actor)scrollPane).height(144.0F).top().left().expandX().fillX();
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       RectButton rectButton1;
/* 577 */       (rectButton1 = new RectButton("", Game.i.assetManager.getLabelStyle(21), () -> { removeData(paramString); paramItemCreationOverlay.updateForm(); })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 8.0F, 8.0F, 32.0F, 32.0F);
/* 578 */       rectButton1.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 48.0F, 48.0F);
/* 579 */       rectButton1.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, MaterialColor.RED.P900);
/* 580 */       table3.add((Actor)rectButton1).top().left().size(48.0F).row();
/*     */     } 
/*     */     
/* 583 */     Table table2 = new Table();
/* 584 */     table1.add((Actor)table2).expandX().fillX().row();
/*     */     
/*     */     TextFieldXPlatform textFieldXPlatform;
/* 587 */     (textFieldXPlatform = new TextFieldXPlatform("", paramItemCreationOverlay.textFieldStyle)).setMessageText("idbscS");
/* 588 */     table2.add((Actor)textFieldXPlatform).size(200.0F, 48.0F).padRight(10.0F);
/*     */ 
/*     */ 
/*     */     
/*     */     RectButton rectButton;
/*     */ 
/*     */ 
/*     */     
/* 596 */     (rectButton = new RectButton("", Game.i.assetManager.getLabelStyle(21), () -> { if (paramTextFieldXPlatform.getText().length() > 1) { setData(paramTextFieldXPlatform.getText(), null); paramItemCreationOverlay.updateForm(); }  })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-plus"), 32.0F, 8.0F, 32.0F, 32.0F);
/* 597 */     rectButton.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 48.0F, 48.0F);
/* 598 */     rectButton.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900);
/* 599 */     table2.add((Actor)rectButton).top().left().size(96.0F, 48.0F);
/*     */     
/* 601 */     table2.add().expandX().fillX();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 606 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 611 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeUpgraded() {
/* 616 */     return false;
/*     */   }
/*     */   
/*     */   public static class DummyTileFactory extends Tile.Factory.AbstractFactory<DummyTile> {
/*     */     public DummyTileFactory() {
/* 621 */       super(TileType.DUMMY);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 626 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public DummyTile create() {
/* 636 */       return new DummyTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyTile fromJson(JsonValue param1JsonValue) {
/* 641 */       DummyTile dummyTile = (DummyTile)super.fromJson(param1JsonValue);
/*     */ 
/*     */       
/* 644 */       if ((param1JsonValue = param1JsonValue.get("d")) != null) {
/* 645 */         dummyTile.setId(param1JsonValue.getLong("id", PMath.generateNewId()));
/*     */         JsonValue jsonValue;
/* 647 */         if ((jsonValue = param1JsonValue.get("d")) != null) {
/* 648 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext();) {
/* 649 */             switch ((jsonValue1 = jsonIterator.next()).name.charAt(0)) {
/*     */               case 'c':
/*     */                 try {
/* 652 */                   dummyTile.data.put(jsonValue1.name, Color.valueOf(jsonValue1.asString()));
/* 653 */                 } catch (Exception exception) {}
/*     */ 
/*     */               
/*     */               case 'S':
/*     */               case 's':
/* 658 */                 dummyTile.data.put(jsonValue1.name, jsonValue1.asString());
/* 659 */               case 'b': dummyTile.data.put(jsonValue1.name, Boolean.valueOf(jsonValue1.asBoolean()));
/* 660 */               case 'i': dummyTile.data.put(jsonValue1.name, Integer.valueOf(jsonValue1.asInt()));
/* 661 */               case 'd': dummyTile.data.put(jsonValue1.name, Double.valueOf(jsonValue1.asDouble()));
/*     */             } 
/*     */           
/*     */           } 
/*     */         }
/* 666 */         dummyTile.visible = param1JsonValue.getBoolean("v", false);
/* 667 */         dummyTile.selectable = param1JsonValue.getBoolean("s", false);
/* 668 */         dummyTile.icon = param1JsonValue.getString("i", null);
/* 669 */         dummyTile.iconScale = param1JsonValue.getFloat("is", DummyTile.DEFAULT_SCALE);
/* 670 */         dummyTile.description = param1JsonValue.getString("dsc", null);
/*     */         try {
/* 672 */           dummyTile.color.set(Color.valueOf(param1JsonValue.getString("c", Color.WHITE.toString())));
/* 673 */         } catch (Exception exception) {}
/*     */       } 
/*     */       
/* 676 */       return dummyTile;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\DummyTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */