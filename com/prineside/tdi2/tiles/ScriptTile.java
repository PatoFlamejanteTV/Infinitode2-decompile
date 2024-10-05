/*     */ package com.prineside.tdi2.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.ui.TextArea;
/*     */ import com.prineside.tdi2.scene2d.ui.TextField;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TableButton;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.ui.shared.FullScreenTextEditor;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class ScriptTile extends Tile {
/*  56 */   private static final TLog c = TLog.forClass(ScriptTile.class);
/*     */   @NAGS
/*     */   private long d;
/*     */   @NAGS
/*     */   private String e;
/*  61 */   private static final StringBuilder f = new StringBuilder();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  65 */     super.write(paramKryo, paramOutput);
/*  66 */     paramOutput.writeLong(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  71 */     super.read(paramKryo, paramInput);
/*  72 */     this.d = paramInput.readLong();
/*     */   }
/*     */   
/*     */   private ScriptTile() {
/*  76 */     super(TileType.SCRIPT);
/*     */     
/*  78 */     setId(PMath.generateNewId());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/*  83 */     paramItemCreationOverlay.label("ID");
/*  84 */     paramItemCreationOverlay.textFieldEndRow(String.valueOf(getId()), 300.0F, paramString -> {
/*     */           try {
/*     */             setId(Long.parseLong(paramString)); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/*  88 */           } catch (Exception exception) {
/*     */             c.e("bad value: " + paramString, new Object[0]);
/*     */             
/*     */             return;
/*     */           } 
/*     */         }false);
/*     */     
/*     */     PaddedImageButton paddedImageButton;
/*     */     
/*  97 */     (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-restart"), () -> { setId(PMath.generateNewId()); paramItemCreationOverlay.updateForm(); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setIconSize(40.0F, 40.0F);
/*  98 */     paddedImageButton.setIconPosition(12.0F, 12.0F);
/*  99 */     paramItemCreationOverlay.form.add((Actor)paddedImageButton).top().left().padLeft(10.0F).size(64.0F).row();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/* 109 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/* 111 */     Table table1 = new Table();
/* 112 */     paramTable.add((Actor)table1).padTop(8.0F).padBottom(4.0F).growX().row();
/*     */     
/*     */     Label label;
/* 115 */     (label = new Label("Source code".toUpperCase(), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 116 */     label.setAlignment(8);
/* 117 */     table1.add((Actor)label).growX();
/*     */ 
/*     */     
/* 120 */     (label = new Label(Long.toHexString(getId()), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 121 */     label.setAlignment(16);
/* 122 */     table1.add((Actor)label);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TextField.TextFieldStyle textFieldStyle;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     (textFieldStyle = new TextField.TextFieldStyle(Game.i.assetManager.getDebugFont(false), Color.WHITE, (Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion()), (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(MaterialColor.BLUE.P500), (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(0.0F, 0.0F, 0.0F, 0.24F)))).cursor.setMinWidth(2.0F);
/* 133 */     textFieldStyle.background.setLeftWidth(textFieldStyle.background.getLeftWidth() + 24.0F);
/* 134 */     textFieldStyle.background.setRightWidth(textFieldStyle.background.getRightWidth() + 24.0F);
/* 135 */     textFieldStyle.background.setBottomHeight(textFieldStyle.background.getBottomHeight() + 10.0F);
/* 136 */     textFieldStyle.background.setTopHeight(textFieldStyle.background.getTopHeight() + 10.0F);
/*     */     
/*     */     Group group;
/*     */     
/* 140 */     (group = new Group()).setTransform(false);
/* 141 */     paramTable.add((Actor)group).size(paramTable.getWidth(), 364.0F).row();
/*     */     
/*     */     TextArea textArea;
/* 144 */     (textArea = new TextArea(getScript(), textFieldStyle)).setOnlyFontChars(false);
/* 145 */     textArea.setProgrammaticChangeEvents(true);
/* 146 */     textArea.setSize(paramTable.getWidth() + 48.0F, 364.0F);
/* 147 */     textArea.setPosition(-24.0F, 0.0F);
/* 148 */     group.addActor((Actor)textArea);
/*     */     
/* 150 */     TableButton tableButton = new TableButton(() -> FullScreenTextEditor.i().show(paramTextArea.getText(), new ObjectConsumer<String>(this, paramTextArea)
/*     */           {
/*     */             public void accept(String param1String)
/*     */             {
/* 154 */               this.a.setText(param1String);
/*     */             }
/*     */           }));
/*     */     
/* 158 */     Image image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-enlarge"));
/* 159 */     tableButton.add((Actor)image).size(40.0F);
/* 160 */     tableButton.setSize(64.0F, 64.0F);
/* 161 */     tableButton.setPosition(paramTable.getWidth() - 64.0F + 24.0F, 300.0F);
/* 162 */     tableButton.setContentColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P800, Color.WHITE);
/* 163 */     tableButton.background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.56F)));
/* 164 */     group.addActor((Actor)tableButton);
/*     */     
/* 166 */     Table table2 = new Table();
/* 167 */     paramTable.add((Actor)table2).growX().padTop(8.0F).row();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RectButton rectButton;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     (rectButton = new RectButton(Game.i.localeManager.i18n.get("do_save"), Game.i.assetManager.getLabelStyle(21), () -> { DelayedRemovalArray delayedRemovalArray; String str; if ((str = paramTextArea.getText()).length() == 0) { c.i("removed code", new Object[0]); if (getScript() != null) { setScript(null); delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.TILE); for (byte b = 0; b < delayedRemovalArray.size; b++) { ItemStack itemStack; TileItem tileItem; ScriptTile scriptTile; if ((tileItem = (TileItem)(itemStack = ((ItemStack[])delayedRemovalArray.items)[b]).getItem()).tile.type == TileType.SCRIPT && (scriptTile = (ScriptTile)tileItem.tile).getId() == getId()) { scriptTile.setScript(null); ProgressPrefs.i().requireSave(); c.i("updated real item", new Object[0]); break; }  }  paramMapEditorItemInfoMenu.notifySelectedElementChanged(); paramMapEditorItemInfoMenu.update(); Game.i.soundManager.playStatic(StaticSoundType.SUCCESS); return; }  } else { if (str.length() > 100000) { Notifications.i().add("Script is too long - max 100k characters per tile", null, null, StaticSoundType.FAIL); delayedRemovalArray.setText(""); return; }  setScript(str); delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.TILE); for (byte b = 0; b < delayedRemovalArray.size; b++) { ItemStack itemStack; TileItem tileItem; ScriptTile scriptTile; if ((tileItem = (TileItem)(itemStack = ((ItemStack[])delayedRemovalArray.items)[b]).getItem()).tile.type == TileType.SCRIPT && (scriptTile = (ScriptTile)tileItem.tile).getId() == getId()) { scriptTile.setScript(str); ProgressPrefs.i().requireSave(); break; }  }  paramMapEditorItemInfoMenu.notifySelectedElementChanged(); paramMapEditorItemInfoMenu.update(); Game.i.soundManager.playStatic(StaticSoundType.SUCCESS); }  })).setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, MaterialColor.GREY.P800);
/* 232 */     table2.add((Actor)rectButton).growX().height(40.0F).padRight(2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     (rectButton = new RectButton("Copy", Game.i.assetManager.getLabelStyle(21), () -> { if (getScript() != null) { Gdx.app.getClipboard().setContents(getScript()); Notifications.i().add(Game.i.localeManager.i18n.get("copied_to_clipboard"), (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.BLUE_GREY.P800, StaticSoundType.SUCCESS); }  })).setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.GREY.P800);
/* 241 */     table2.add((Actor)rectButton).growX().height(40.0F).padRight(2.0F);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     (rectButton = new RectButton("Paste", Game.i.assetManager.getLabelStyle(21), () -> { String str; if ((str = Gdx.app.getClipboard().getContents()) != null && str.length() > 0) { str = str.replaceAll("\r", ""); setScript(str); DelayedRemovalArray delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.TILE); for (byte b = 0; b < delayedRemovalArray.size; b++) { ItemStack itemStack; ScriptTile scriptTile; TileItem tileItem; if ((tileItem = (TileItem)(itemStack = ((ItemStack[])delayedRemovalArray.items)[b]).getItem()).tile.type == TileType.SCRIPT && (scriptTile = (ScriptTile)tileItem.tile).getId() == getId()) { scriptTile.setScript(str); ProgressPrefs.i().requireSave(); break; }  }  paramMapEditorItemInfoMenu.notifySelectedElementChanged(); paramMapEditorItemInfoMenu.update(); Game.i.soundManager.playStatic(StaticSoundType.SUCCESS); }  })).setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.GREY.P800);
/* 272 */     table2.add((Actor)rectButton).growX().height(40.0F);
/*     */   }
/*     */   
/*     */   public final long getId() {
/* 276 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void setId(long paramLong) {
/* 280 */     this.d = paramLong;
/*     */   }
/*     */   
/*     */   public final String getScript() {
/* 284 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void setScript(String paramString) {
/* 288 */     this.e = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 293 */     if (!super.sameAs(paramTile)) return false;
/*     */     
/* 295 */     paramTile = paramTile;
/*     */     
/* 297 */     return (getId() == paramTile.getId());
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/* 302 */     if (paramItemSortingType == ItemSortingType.KIND) {
/* 303 */       return 30000;
/*     */     }
/* 305 */     return getRarity().ordinal() * 1000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 311 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 316 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 321 */     return ItemSubcategoryType.ME_SPECIAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 326 */     super.from(paramTile);
/* 327 */     paramTile = paramTile;
/*     */     
/* 329 */     setId(paramTile.getId());
/* 330 */     this.e = ((ScriptTile)paramTile).e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 335 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */     
/* 337 */     if (a(paramDrawMode))
/*     */     {
/* 339 */       paramBatch.draw(ScriptTileFactory.a(Game.i.tileManager.F.SCRIPT), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     }
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
/*     */ 
/*     */ 
/*     */   
/*     */   private StringBuilder a() {
/*     */     // Byte code:
/*     */     //   0: getstatic com/prineside/tdi2/tiles/ScriptTile.f : Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   3: iconst_0
/*     */     //   4: invokevirtual setLength : (I)V
/*     */     //   7: aload_0
/*     */     //   8: getfield e : Ljava/lang/String;
/*     */     //   11: ifnonnull -> 18
/*     */     //   14: getstatic com/prineside/tdi2/tiles/ScriptTile.f : Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   17: areturn
/*     */     //   18: iconst_0
/*     */     //   19: istore_1
/*     */     //   20: iconst_0
/*     */     //   21: istore_2
/*     */     //   22: iconst_1
/*     */     //   23: istore_3
/*     */     //   24: iconst_0
/*     */     //   25: istore #4
/*     */     //   27: aload_0
/*     */     //   28: getfield e : Ljava/lang/String;
/*     */     //   31: invokevirtual length : ()I
/*     */     //   34: istore #5
/*     */     //   36: iload #4
/*     */     //   38: iload #5
/*     */     //   40: if_icmpge -> 146
/*     */     //   43: aload_0
/*     */     //   44: getfield e : Ljava/lang/String;
/*     */     //   47: iload #4
/*     */     //   49: invokevirtual charAt : (I)C
/*     */     //   52: istore #6
/*     */     //   54: iload_2
/*     */     //   55: bipush #13
/*     */     //   57: if_icmpge -> 95
/*     */     //   60: iload #6
/*     */     //   62: bipush #10
/*     */     //   64: if_icmpeq -> 95
/*     */     //   67: getstatic com/prineside/tdi2/tiles/ScriptTile.f : Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   70: iload #6
/*     */     //   72: invokevirtual append : (C)Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   75: pop
/*     */     //   76: iload #6
/*     */     //   78: bipush #45
/*     */     //   80: if_icmpeq -> 92
/*     */     //   83: iload #6
/*     */     //   85: bipush #91
/*     */     //   87: if_icmpeq -> 92
/*     */     //   90: iconst_0
/*     */     //   91: istore_3
/*     */     //   92: iinc #2, 1
/*     */     //   95: iload #6
/*     */     //   97: bipush #10
/*     */     //   99: if_icmpne -> 140
/*     */     //   102: iload_3
/*     */     //   103: ifeq -> 120
/*     */     //   106: iload_2
/*     */     //   107: ifeq -> 120
/*     */     //   110: getstatic com/prineside/tdi2/tiles/ScriptTile.f : Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   113: iconst_0
/*     */     //   114: invokevirtual setLength : (I)V
/*     */     //   117: goto -> 138
/*     */     //   120: getstatic com/prineside/tdi2/tiles/ScriptTile.f : Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   123: bipush #10
/*     */     //   125: invokevirtual append : (C)Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   128: pop
/*     */     //   129: iinc #1, 1
/*     */     //   132: iload_1
/*     */     //   133: bipush #6
/*     */     //   135: if_icmpeq -> 146
/*     */     //   138: iconst_0
/*     */     //   139: istore_2
/*     */     //   140: iinc #4, 1
/*     */     //   143: goto -> 36
/*     */     //   146: getstatic com/prineside/tdi2/tiles/ScriptTile.f : Lcom/badlogic/gdx/utils/StringBuilder;
/*     */     //   149: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #344	-> 0
/*     */     //   #345	-> 7
/*     */     //   #347	-> 18
/*     */     //   #348	-> 20
/*     */     //   #349	-> 22
/*     */     //   #350	-> 24
/*     */     //   #351	-> 43
/*     */     //   #353	-> 54
/*     */     //   #354	-> 67
/*     */     //   #355	-> 76
/*     */     //   #356	-> 90
/*     */     //   #358	-> 92
/*     */     //   #360	-> 95
/*     */     //   #361	-> 102
/*     */     //   #362	-> 110
/*     */     //   #364	-> 120
/*     */     //   #365	-> 129
/*     */     //   #366	-> 132
/*     */     //   #368	-> 138
/*     */     //   #350	-> 140
/*     */     //   #372	-> 146
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(MapRenderingSystem.DrawMode paramDrawMode) {
/* 376 */     if (paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) return true;
/*     */     
/* 378 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawExtras(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 383 */     if (this.e == null || this.e.length() == 0)
/*     */       return; 
/* 385 */     if (a(paramDrawMode)) {
/* 386 */       float f1 = paramFloat4 * 0.0078125F;
/*     */       
/*     */       BitmapFont bitmapFont;
/* 389 */       (bitmapFont = Game.i.assetManager.getSmallDebugFont()).setColor(Color.WHITE);
/* 390 */       float f2 = (bitmapFont.getData()).scaleX;
/* 391 */       float f3 = (bitmapFont.getData()).scaleY;
/* 392 */       bitmapFont.getData().setScale(f2 * f1, f3 * f1);
/* 393 */       bitmapFont.draw(paramBatch, (CharSequence)a(), paramFloat1 + 16.0F * f1, paramFloat2 + paramFloat4 - 16.0F * f1, paramFloat3, 8, false);
/* 394 */       bitmapFont.getData().setScale(f2, f3);
/* 395 */       bitmapFont.setColor(Color.WHITE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/* 401 */     paramFloat /= 128.0F;
/*     */     
/* 403 */     Group group = new Group();
/* 404 */     if (paramFloat != 1.0F) {
/* 405 */       group.setTransform(true);
/* 406 */       group.setScale(paramFloat);
/*     */     } else {
/* 408 */       group.setTransform(false);
/*     */     } 
/*     */     
/*     */     Image image;
/*     */     
/* 413 */     (image = new Image(ScriptTileFactory.a(Game.i.tileManager.F.SCRIPT))).setSize(128.0F, 128.0F);
/* 414 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 417 */     StringBuilder stringBuilder = a();
/*     */     Label label;
/* 419 */     (label = new Label((CharSequence)stringBuilder, Game.i.assetManager.getSmallDebugLabelStyle())).setPosition(16.0F, 16.0F);
/* 420 */     label.setSize(96.0F, 96.0F);
/* 421 */     label.setAlignment(10);
/* 422 */     group.addActor((Actor)label);
/*     */     
/* 424 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 429 */     super.toJson(paramJson);
/*     */     
/* 431 */     paramJson.writeObjectStart("d");
/* 432 */     paramJson.writeValue("id", Long.valueOf(getId()));
/* 433 */     if (this.e != null) {
/* 434 */       paramJson.writeValue("script", this.e);
/*     */     }
/* 436 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 441 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeSelected() {
/* 446 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 451 */     return 0.1D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 456 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (id: " + getId() + ", has script: " + ((this.e == null) ? "false" : "true") + ")";
/*     */   }
/*     */   
/*     */   public static class ScriptTileFactory extends Tile.Factory.AbstractFactory<ScriptTile> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public ScriptTileFactory() {
/* 463 */       super(TileType.SCRIPT);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 468 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 473 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-script");
/*     */     }
/*     */ 
/*     */     
/*     */     public ScriptTile create() {
/* 478 */       return new ScriptTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public ScriptTile fromJson(JsonValue param1JsonValue) {
/* 483 */       ScriptTile scriptTile = (ScriptTile)super.fromJson(param1JsonValue);
/*     */       
/* 485 */       if (param1JsonValue.has("d")) {
/* 486 */         scriptTile.setId(param1JsonValue.get("d").getLong("id", PMath.generateNewId()));
/* 487 */         ScriptTile.a(scriptTile, param1JsonValue.get("d").getString("script", null));
/*     */       } 
/*     */       
/* 490 */       return scriptTile;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\ScriptTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */