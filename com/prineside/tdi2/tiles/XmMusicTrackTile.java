/*     */ package com.prineside.tdi2.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.ibxm.Module;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.FileChooser;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.util.Locale;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ 
/*     */ @REGS
/*     */ public final class XmMusicTrackTile
/*     */   extends Tile {
/*  66 */   private static final TLog c = TLog.forClass(XmMusicTrackTile.class);
/*     */ 
/*     */ 
/*     */   
/*  70 */   private static final Color[] d = new Color[] { MaterialColor.PINK.P500, MaterialColor.PURPLE.P500, MaterialColor.DEEP_PURPLE.P500, MaterialColor.INDIGO.P500, MaterialColor.BLUE.P500, MaterialColor.CYAN.P500, MaterialColor.TEAL.P500, MaterialColor.GREEN.P500, MaterialColor.YELLOW.P500, MaterialColor.ORANGE.P500, MaterialColor.BROWN.P500 };
/*     */ 
/*     */   
/*     */   @NAGS
/*     */   private long e;
/*     */ 
/*     */   
/*     */   @NAGS
/*     */   private String f;
/*     */   
/*     */   @NAGS
/*     */   private Color[] g;
/*     */   
/*     */   @NAGS
/*     */   private boolean h;
/*     */   
/*     */   @NAGS
/*     */   private String i;
/*     */   
/*     */   @NAGS
/*     */   private Array<Module.TrackInfoEntry> j;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  94 */     super.write(paramKryo, paramOutput);
/*  95 */     paramOutput.writeLong(this.e);
/*  96 */     paramKryo.writeObjectOrNull(paramOutput, this.i, String.class);
/*  97 */     paramKryo.writeObjectOrNull(paramOutput, this.j, Array.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 102 */     super.read(paramKryo, paramInput);
/* 103 */     this.e = paramInput.readLong();
/* 104 */     this.i = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 105 */     this.j = (Array<Module.TrackInfoEntry>)paramKryo.readObjectOrNull(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private XmMusicTrackTile() {
/* 109 */     super(TileType.XM_MUSIC_TRACK);
/*     */     
/* 111 */     setId(generateNewId());
/*     */   }
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/*     */     Module module;
/* 116 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */ 
/*     */     
/* 119 */     Table table = new Table();
/* 120 */     paramTable.add((Actor)table).height(32.0F).growX().padLeft(-24.0F).padRight(-24.0F).row(); Color[] arrayOfColor1, arrayOfColor2;
/*     */     int i;
/*     */     byte b1;
/* 123 */     for (i = (arrayOfColor2 = arrayOfColor1 = getIdColors()).length, b1 = 0; b1 < i; ) { Color color = arrayOfColor2[b1];
/*     */       Image image1;
/* 125 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(color);
/* 126 */       table.add((Actor)image1).height(8.0F).growX(); b1++; }
/*     */     
/* 128 */     table.row();
/*     */     
/*     */     Image image;
/* 131 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 132 */     table.add((Actor)image).colspan(arrayOfColor1.length).growX().height(4.0F);
/*     */     
/*     */     Label label2;
/* 135 */     (label2 = new Label(Game.i.localeManager.i18n.get("music_tile_editor_title_copy_from_level").toUpperCase(Locale.US), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 136 */     label2.setAlignment(8);
/* 137 */     paramTable.add((Actor)label2).growX().row();
/*     */     
/*     */     SelectBox selectBox;
/* 140 */     (selectBox = new SelectBox(paramMapEditorItemInfoMenu.selectBoxStyle)).setName("map_editor_menu_music_copy_from_select");
/*     */     Array array;
/* 142 */     (array = new Array()).add("");
/* 143 */     for (byte b2 = 0; b2 < Game.i.basicLevelManager.levelsOrdered.size; b2++) {
/* 144 */       BasicLevel basicLevel = ((BasicLevel[])Game.i.basicLevelManager.levelsOrdered.items)[b2];
/* 145 */       if (Game.i.basicLevelManager.isOpened(basicLevel) && Game.i.basicLevelManager.isLevelVisible(basicLevel) && basicLevel.getMap().getMusicTile() != null) {
/* 146 */         array.add(basicLevel.name);
/*     */       }
/*     */     } 
/* 149 */     selectBox.setItems(array);
/* 150 */     paramTable.add((Actor)selectBox).height(40.0F).growX().padBottom(8.0F).padTop(4.0F).row();
/*     */     
/*     */     Label label3;
/* 153 */     (label3 = new Label(Game.i.localeManager.i18n.get("music_tile_editor_title_load_from_url").toUpperCase(Locale.US), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 154 */     label3.setAlignment(8);
/* 155 */     paramTable.add((Actor)label3).growX().row();
/*     */     
/* 157 */     table = new Table();
/* 158 */     paramTable.add((Actor)table).padBottom(8.0F).padTop(4.0F).growX().row();
/*     */     
/* 160 */     TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform("", paramMapEditorItemInfoMenu.textFieldStyle);
/* 161 */     table.add((Actor)textFieldXPlatform2).growX().height(40.0F);
/*     */     
/* 163 */     RectButton rectButton = new RectButton(Game.i.localeManager.i18n.get("to_load"), Game.i.assetManager.getLabelStyle(21), null);
/* 164 */     table.add((Actor)rectButton).height(40.0F).width(64.0F);
/*     */     
/*     */     Label label1;
/* 167 */     (label1 = new Label(Game.i.localeManager.i18n.get("music_tile_editor_title_music_base64").toUpperCase(Locale.US), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 168 */     label1.setAlignment(8);
/* 169 */     paramTable.add((Actor)label1).growX().row();
/*     */     
/*     */     TextFieldXPlatform textFieldXPlatform1;
/* 172 */     (textFieldXPlatform1 = new TextFieldXPlatform(getTrackBase64(), paramMapEditorItemInfoMenu.textFieldStyle)).setProgrammaticChangeEvents(true);
/* 173 */     paramTable.add((Actor)textFieldXPlatform1).growX().height(40.0F).padBottom(8.0F).padTop(4.0F).row();
/* 174 */     textFieldXPlatform1.addListener((EventListener)new ChangeListener(this, textFieldXPlatform1, paramMapEditorItemInfoMenu)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */             String str;
/* 178 */             if ((str = this.a.getText()).length() == 0) {
/*     */               
/* 180 */               XmMusicTrackTile.a().i("removed track", new Object[0]);
/* 181 */               if (this.c.getTrackBase64() != null) {
/*     */                 TileItem tileItem;
/*     */                 
/* 184 */                 if ((tileItem = (TileItem)Game.i.progressManager.getItem((Item)Item.D.F_TILE.create(this.c))) != null) {
/* 185 */                   ((XmMusicTrackTile)tileItem.tile).setTrack(null);
/* 186 */                   ProgressPrefs.i().requireSave();
/* 187 */                   XmMusicTrackTile.a().i("updated real item", new Object[0]);
/*     */                 } 
/*     */                 
/* 190 */                 this.c.setTrack(null);
/*     */ 
/*     */                 
/* 193 */                 this.b.notifySelectedElementChanged();
/* 194 */                 this.b.update(); return;
/*     */               } 
/*     */             } else {
/* 197 */               if (str.length() > 524288) {
/* 198 */                 String str2 = Game.i.localeManager.i18n.format("track_string_too_long", new Object[] { Integer.valueOf(524) });
/* 199 */                 Notifications.i().add(str2, null, null, StaticSoundType.FAIL);
/* 200 */                 this.a.setText(""); return;
/*     */               } 
/* 202 */               String str1 = this.c.getTrackBase64();
/* 203 */               this.c.setTrack(str);
/*     */               try {
/*     */                 Module module;
/* 206 */                 if ((module = this.c.getModule()) == null) {
/* 207 */                   throw new IllegalArgumentException();
/*     */                 }
/*     */                 
/*     */                 TileItem tileItem;
/*     */                 
/* 212 */                 if ((tileItem = (TileItem)Game.i.progressManager.getItem((Item)Item.D.F_TILE.create(this.c))) != null) {
/* 213 */                   ((XmMusicTrackTile)tileItem.tile).setTrack(str);
/* 214 */                   ProgressPrefs.i().requireSave();
/* 215 */                   XmMusicTrackTile.a().i("updated real item", new Object[0]);
/*     */                 } 
/*     */ 
/*     */                 
/* 219 */                 this.b.notifySelectedElementChanged();
/* 220 */                 this.b.update(); return;
/* 221 */               } catch (Exception exception) {
/*     */                 
/* 223 */                 this.c.setTrack(str1);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 230 */     selectBox.addListener((EventListener)new ChangeListener(this, selectBox, textFieldXPlatform1, paramMapEditorItemInfoMenu)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 233 */             String str = (String)this.a.getSelected();
/*     */             
/*     */             try {
/* 236 */               BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(str);
/* 237 */               this.b.setText(basicLevel.getMap().getMusicTile().getTrackBase64());
/*     */               
/* 239 */               this.c.notifySelectedElementChanged();
/* 240 */               this.c.update(); return;
/* 241 */             } catch (Exception exception) {
/* 242 */               XmMusicTrackTile.a().e("failed to copy xm from level " + str, new Object[0]);
/*     */               return;
/*     */             } 
/*     */           }
/*     */         });
/* 247 */     rectButton.setClickHandler(() -> {
/*     */           String str = paramTextFieldXPlatform1.getText();
/*     */           Net.HttpRequest httpRequest;
/*     */           (httpRequest = new Net.HttpRequest("GET")).setUrl(str);
/*     */           Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramTextFieldXPlatform2, paramMapEditorItemInfoMenu, str)
/*     */               {
/*     */                 public void handleHttpResponse(Net.HttpResponse param1HttpResponse)
/*     */                 {
/* 255 */                   byte[] arrayOfByte = param1HttpResponse.getResult();
/* 256 */                   Threads.i().postRunnable(() -> {
/*     */                         try {
/*     */                           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */                           
/*     */                           ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
/*     */                           
/*     */                           ZipEntry zipEntry;
/*     */                           
/*     */                           (zipEntry = new ZipEntry("module")).setSize(param1ArrayOfbyte.length);
/*     */                           zipOutputStream.putNextEntry(zipEntry);
/*     */                           zipOutputStream.write(param1ArrayOfbyte);
/*     */                           zipOutputStream.close();
/*     */                           byteArrayOutputStream.close();
/*     */                           String str = StringFormatter.toBase64(param1ArrayOfbyte = byteArrayOutputStream.toByteArray(), 0, param1ArrayOfbyte.length);
/*     */                           Game.i.musicManager.getModule(str);
/*     */                           param1TextFieldXPlatform.setText(str);
/*     */                           param1MapEditorItemInfoMenu.notifySelectedElementChanged();
/*     */                           param1MapEditorItemInfoMenu.update();
/*     */                           return;
/* 275 */                         } catch (Exception exception) {
/*     */                           Notifications.i().add("Failed to load module: " + exception.getMessage(), null, MaterialColor.RED.P500, StaticSoundType.FAIL);
/*     */                           XmMusicTrackTile.a().e("failed to load music from url " + param1String, new Object[] { exception });
/*     */                           return;
/*     */                         } 
/*     */                       });
/*     */                 }
/*     */                 
/*     */                 public void failed(Throwable param1Throwable) {
/* 284 */                   Notifications.i().add("Request failed: " + param1Throwable.getMessage(), null, MaterialColor.RED.P500, StaticSoundType.FAIL);
/* 285 */                   XmMusicTrackTile.a().e("request for music at " + this.c + " failed", new Object[] { param1Throwable });
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void cancelled() {
/* 290 */                   XmMusicTrackTile.a().e("request for music at " + this.c + " cancelled", new Object[0]);
/*     */                 }
/*     */               });
/*     */         });
/*     */     
/* 295 */     if (Game.i.actionResolver.getFileChooser() != null && Game.i.actionResolver.getFileChooser().intentSupported(FileChooser.FileChooseIntent.OPEN)) {
/*     */       
/* 297 */       RectButton rectButton1 = new RectButton(Game.i.localeManager.i18n.get("to_select_file"), Game.i.assetManager.getLabelStyle(21), () -> {
/*     */             FileChooser.Configuration configuration;
/*     */             (configuration = new FileChooser.Configuration()).intent = FileChooser.FileChooseIntent.OPEN;
/*     */             configuration.title = "Select music file";
/*     */             Game.i.actionResolver.getFileChooser().choose(configuration, new FileChooser.Callback(this, paramTextFieldXPlatform, paramMapEditorItemInfoMenu)
/*     */                 {
/*     */                   public void onFileChoose(FileHandle param1FileHandle) {
/* 304 */                     Module module = null;
/* 305 */                     String str = null;
/*     */                     
/*     */                     try {
/*     */                       String str1;
/*     */                       
/* 310 */                       if (!(str1 = param1FileHandle.extension().toLowerCase(Locale.US)).equals("mod") && !str1.equals("xm") && !str1.equals("s3m")) {
/* 311 */                         Notifications.i().add("Supported files are .mod / .xm / .s3m", (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*     */                         return;
/*     */                       } 
/* 314 */                       if (param1FileHandle.length() > 1048576L) {
/* 315 */                         Notifications.i().add("Max file size is 1Mb", (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*     */                         
/*     */                         return;
/*     */                       } 
/*     */                       
/*     */                       try {
/* 321 */                         module = new Module(param1FileHandle.read());
/* 322 */                         str = Module.toZippedBase64(param1FileHandle.readBytes());
/* 323 */                       } catch (Exception exception) {
/*     */                         
/* 325 */                         module = Module.fromZipInputStream(param1FileHandle.read());
/*     */                         byte[] arrayOfByte;
/* 327 */                         str = StringFormatter.toBase64(arrayOfByte = param1FileHandle.readBytes(), 0, arrayOfByte.length);
/*     */                       } 
/* 329 */                     } catch (Exception exception) {
/* 330 */                       XmMusicTrackTile.a().e("failed to load music from file " + param1FileHandle, new Object[] { exception });
/*     */                     } 
/*     */                     
/* 333 */                     if (module != null) {
/*     */                       TileItem tileItem;
/*     */ 
/*     */                       
/* 337 */                       if ((tileItem = (TileItem)Game.i.progressManager.getItem((Item)Item.D.F_TILE.create(this.c))) != null) {
/* 338 */                         ((XmMusicTrackTile)tileItem.tile).setTrack(str);
/* 339 */                         ProgressPrefs.i().requireSave();
/* 340 */                         XmMusicTrackTile.a().i("updated real item", new Object[0]);
/*     */                       } else {
/* 342 */                         XmMusicTrackTile.a().i("real item not found", new Object[0]);
/*     */                       } 
/* 344 */                       this.a.setText(str);
/*     */ 
/*     */                       
/* 347 */                       this.b.notifySelectedElementChanged();
/* 348 */                       this.b.update(); return;
/*     */                     } 
/* 350 */                     Notifications.i().add("Failed to load the track from file, check console", (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*     */                   }
/*     */ 
/*     */ 
/*     */                   
/*     */                   public void onCancel() {
/* 356 */                     XmMusicTrackTile.a().i("file selection cancelled", new Object[0]);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void onError(Exception param1Exception) {
/* 361 */                     XmMusicTrackTile.a().e("error selecting a file", new Object[] { param1Exception });
/*     */                   }
/*     */                 });
/*     */           });
/* 365 */       paramTable.add((Actor)rectButton1).growX().height(48.0F).padBottom(15.0F).row();
/*     */     } 
/*     */ 
/*     */     
/* 369 */     paramMapEditorItemInfoMenu = null;
/*     */     try {
/* 371 */       module = getModule();
/*     */       
/* 373 */       if (Game.i.settingsManager.isMusicEnabled() && module != null && (
/* 374 */         Game.i.musicManager.getPlayingMusic() == null || !(Game.i.musicManager.getPlayingMusic()).songName.equals(module.songName))) {
/* 375 */         Game.i.musicManager.playMusic(module);
/* 376 */         Game.i.musicManager.setVolumeToStartNewTrack();
/*     */       }
/*     */     
/* 379 */     } catch (Exception exception) {}
/*     */     
/* 381 */     if (module != null) {
/*     */       Label label;
/* 383 */       (label = new Label(module.songName, Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.AMBER.P500);
/* 384 */       label.setAlignment(8);
/* 385 */       paramTable.add((Actor)label).growX().row();
/*     */       
/*     */       Array array1;
/* 388 */       for (Array.ArrayIterator<Module.TrackInfoEntry> arrayIterator = (array1 = module.getInfoFromInstrumentNames()).iterator(); arrayIterator.hasNext(); ) { Label label4; Module.TrackInfoEntry trackInfoEntry = arrayIterator.next();
/* 389 */         LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel(trackInfoEntry.value, 21, 18, 352.0F);
/* 390 */         switch (null.a[trackInfoEntry.type.ordinal()]) {
/*     */           
/*     */           case 1:
/* 393 */             (label4 = new Label(Game.i.localeManager.i18n.get("music_track_author") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 394 */             paramTable.add((Actor)label4).growX().padTop(8.0F).row();
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 399 */             (label4 = new Label(Game.i.localeManager.i18n.get("music_track_group") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 400 */             paramTable.add((Actor)label4).growX().padTop(8.0F).row();
/*     */             break;
/*     */           
/*     */           case 3:
/* 404 */             limitedWidthLabel.setTouchable(Touchable.enabled);
/* 405 */             limitedWidthLabel.addListener((EventListener)new ClickListener(this, (Module.TrackInfoEntry)label4)
/*     */                 {
/*     */                   public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 408 */                     Gdx.net.openURI(this.a.getCompleteLink());
/*     */                   }
/*     */                 });
/* 411 */             limitedWidthLabel.addListener((EventListener)new InputListener(this, limitedWidthLabel)
/*     */                 {
/*     */                   public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 414 */                     this.a.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */                   }
/*     */                   
/*     */                   public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 418 */                     this.a.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */                   }
/*     */                 });
/* 421 */             limitedWidthLabel.setText(limitedWidthLabel.getText() + Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-link-out>").toString());
/* 422 */             limitedWidthLabel.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */             break;
/*     */         } 
/* 425 */         limitedWidthLabel.setAlignment(8);
/* 426 */         paramTable.add((Actor)limitedWidthLabel).growX().row(); }
/*     */     
/*     */     } 
/*     */ 
/*     */     
/* 431 */     if (Game.i.actionResolver.getFileChooser() != null && Game.i.actionResolver.getFileChooser().intentSupported(FileChooser.FileChooseIntent.SAVE)) {
/*     */       
/* 433 */       RectButton rectButton1 = new RectButton(Game.i.localeManager.i18n.get("save_as_file"), Game.i.assetManager.getLabelStyle(21), () -> {
/*     */             FileChooser.Configuration configuration;
/*     */             
/*     */             (configuration = new FileChooser.Configuration()).intent = FileChooser.FileChooseIntent.SAVE;
/*     */             
/*     */             configuration.title = "Save as...";
/*     */             Game.i.actionResolver.getFileChooser().choose(configuration, new FileChooser.Callback(this)
/*     */                 {
/*     */                   public void onFileChoose(FileHandle param1FileHandle)
/*     */                   {
/*     */                     try {
/* 444 */                       (param1FileHandle = param1FileHandle.sibling(param1FileHandle.name() + "." + this.a.getModule().getFileExtension())).writeBytes(StringFormatter.fromBase64(this.a.getTrackBase64()), false);
/* 445 */                       Notifications.i().add("Saved as " + param1FileHandle, (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.GREEN.P800, StaticSoundType.SUCCESS); return;
/* 446 */                     } catch (Exception exception) {
/* 447 */                       XmMusicTrackTile.a().e("failed to save as file " + param1FileHandle, new Object[] { exception });
/*     */                       return;
/*     */                     } 
/*     */                   }
/*     */                   
/*     */                   public void onCancel() {
/* 453 */                     XmMusicTrackTile.a().i("file selection cancelled", new Object[0]);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void onError(Exception param1Exception) {
/* 458 */                     XmMusicTrackTile.a().e("error selecting a file", new Object[] { param1Exception });
/*     */                   }
/*     */                 });
/*     */           });
/* 462 */       paramTable.add((Actor)rectButton1).growX().height(48.0F).padBottom(15.0F).padTop(15.0F).row();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Module paramModule) {
/* 467 */     if (this.h || this.i != null) {
/*     */       return;
/*     */     }
/* 470 */     if ((paramModule = paramModule) == null) {
/*     */       try {
/* 472 */         if (this.f == null) {
/* 473 */           this.h = true;
/*     */           return;
/*     */         } 
/* 476 */         paramModule = Game.i.musicManager.getModule(this.f);
/* 477 */       } catch (Exception exception) {
/* 478 */         this.h = true;
/*     */         
/*     */         return;
/*     */       } 
/*     */     }
/* 483 */     if (paramModule != null) {
/* 484 */       this.i = paramModule.songName;
/*     */       
/* 486 */       this.j = paramModule.getInfoFromInstrumentNames();
/* 487 */       this.h = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final String getTitleCached() {
/* 492 */     a(null);
/* 493 */     return this.i;
/*     */   }
/*     */   
/*     */   public final Array<Module.TrackInfoEntry> getDescriptionCached() {
/* 497 */     a(null);
/* 498 */     return this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*     */     Module module;
/* 504 */     if ((module = getModule()) != null) {
/*     */       Label label;
/* 506 */       (label = new Label(module.songName, Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.AMBER.P500);
/* 507 */       label.setAlignment(8);
/* 508 */       label.setWrap(true);
/* 509 */       paramTable.add((Actor)label).growX().row();
/*     */       
/*     */       Array array;
/* 512 */       for (Array.ArrayIterator<Module.TrackInfoEntry> arrayIterator = (array = module.getInfoFromInstrumentNames()).iterator(); arrayIterator.hasNext(); ) { Label label1; Module.TrackInfoEntry trackInfoEntry = arrayIterator.next();
/* 513 */         LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel(trackInfoEntry.value, 21, 18, paramFloat);
/* 514 */         switch (null.a[trackInfoEntry.type.ordinal()]) {
/*     */           
/*     */           case 1:
/* 517 */             (label1 = new Label(Game.i.localeManager.i18n.get("music_track_author") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 518 */             paramTable.add((Actor)label1).growX().padTop(8.0F).row();
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 523 */             (label1 = new Label(Game.i.localeManager.i18n.get("music_track_group") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 524 */             paramTable.add((Actor)label1).growX().padTop(8.0F).row();
/*     */             break;
/*     */           
/*     */           case 3:
/* 528 */             limitedWidthLabel.setTouchable(Touchable.enabled);
/* 529 */             limitedWidthLabel.addListener((EventListener)new ClickListener(this, (Module.TrackInfoEntry)label1)
/*     */                 {
/*     */                   public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 532 */                     Gdx.net.openURI(this.a.getCompleteLink());
/*     */                   }
/*     */                 });
/* 535 */             limitedWidthLabel.addListener((EventListener)new InputListener(this, limitedWidthLabel)
/*     */                 {
/*     */                   public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 538 */                     this.a.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */                   }
/*     */                   
/*     */                   public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 542 */                     this.a.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */                   }
/*     */                 });
/* 545 */             limitedWidthLabel.setText(limitedWidthLabel.getText() + Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-link-out>").toString());
/* 546 */             limitedWidthLabel.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */             break;
/*     */         } 
/* 549 */         limitedWidthLabel.setAlignment(8);
/* 550 */         paramTable.add((Actor)limitedWidthLabel).growX().row(); }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public static long generateNewId() {
/* 556 */     return (Game.getTimestampSeconds() << 32L) + FastRandom.random.nextInt();
/*     */   }
/*     */   
/*     */   public final long getId() {
/* 560 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void setId(long paramLong) {
/* 564 */     this.e = paramLong;
/*     */     
/* 566 */     this.g = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getTrackBase64() {
/* 573 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Module getModule() {
/* 580 */     if (this.f == null) return null; 
/* 581 */     Module module = Game.i.musicManager.getModule(this.f);
/* 582 */     a(module);
/*     */     
/* 584 */     return module;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Color[] getIdColors() {
/* 591 */     if (this.g == null) {
/* 592 */       long l1 = FastRandom.random.getState(0);
/* 593 */       long l2 = FastRandom.random.getState(1);
/*     */       
/* 595 */       FastRandom.random.setSeed(this.e);
/*     */       
/* 597 */       this.g = new Color[5];
/* 598 */       for (byte b = 0; b < 5; b++) {
/* 599 */         this.g[b] = d[FastRandom.random.nextInt(d.length)];
/*     */       }
/*     */       
/* 602 */       FastRandom.random.setState(l1, l2);
/*     */     } 
/*     */     
/* 605 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int generateSeedSalt() {
/* 610 */     return (this.f == null) ? 0 : this.f.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 615 */     if (!super.sameAs(paramTile)) return false;
/*     */     
/* 617 */     paramTile = paramTile;
/*     */     
/* 619 */     return (getId() == paramTile.getId());
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/* 624 */     if (paramItemSortingType == ItemSortingType.KIND) {
/* 625 */       return 30000;
/*     */     }
/* 627 */     return getRarity().ordinal() * 1000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 633 */     return false;
/*     */   }
/*     */   
/*     */   public final void setTrack(String paramString) {
/* 637 */     this.f = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 642 */     return RarityType.RARE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 647 */     return ItemSubcategoryType.ME_SOUNDS;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 652 */     super.from(paramTile);
/* 653 */     paramTile = paramTile;
/*     */     
/* 655 */     setId(paramTile.getId());
/* 656 */     setTrack(((XmMusicTrackTile)paramTile).f);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 661 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */ 
/*     */     
/* 664 */     paramBatch.draw(XmMusicTrackTileFactory.a(Game.i.tileManager.F.XM_MUSIC_TRACK), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawExtras(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 670 */     Color[] arrayOfColor = getIdColors();
/* 671 */     for (byte b = 0; b < 4; b++) {
/* 672 */       paramBatch.setColor(arrayOfColor[b]);
/* 673 */       paramBatch.draw(XmMusicTrackTileFactory.b(Game.i.tileManager.F.XM_MUSIC_TRACK)[b], paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     } 
/*     */ 
/*     */     
/* 677 */     paramBatch.setColor(arrayOfColor[4]);
/* 678 */     if (getTitleCached() == null) {
/*     */       
/* 680 */       paramBatch.draw(XmMusicTrackTileFactory.c(Game.i.tileManager.F.XM_MUSIC_TRACK), paramFloat1 + paramFloat3 * 0.25F, paramFloat2 + paramFloat4 * 0.25F, paramFloat3 * 0.5F, paramFloat4 * 0.5F);
/* 681 */       paramBatch.setColor(Color.WHITE);
/*     */       return;
/*     */     } 
/* 684 */     paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), paramFloat1 + paramFloat3 * 0.32F, paramFloat2 + paramFloat4 * 0.32F, paramFloat3 * 0.36F, paramFloat4 * 0.36F);
/* 685 */     paramBatch.setColor(Color.WHITE);
/* 686 */     paramBatch.draw(XmMusicTrackTileFactory.d(Game.i.tileManager.F.XM_MUSIC_TRACK), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/*     */     Group group;
/* 693 */     (group = new Group()).setTransform(false);
/*     */     
/*     */     Image image;
/*     */     
/* 697 */     (image = new Image(XmMusicTrackTileFactory.a(Game.i.tileManager.F.XM_MUSIC_TRACK))).setSize(paramFloat, paramFloat);
/* 698 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 701 */     Color[] arrayOfColor = getIdColors();
/* 702 */     for (byte b = 0; b < 4; b++) {
/*     */       Image image1;
/* 704 */       (image1 = new Image(XmMusicTrackTileFactory.b(Game.i.tileManager.F.XM_MUSIC_TRACK)[b])).setColor(arrayOfColor[b]);
/* 705 */       image1.setSize(paramFloat, paramFloat);
/* 706 */       group.addActor((Actor)image1);
/*     */     } 
/*     */ 
/*     */     
/* 710 */     if (this.f == null) {
/*     */       Image image1;
/*     */       
/* 713 */       (image1 = new Image(XmMusicTrackTileFactory.c(Game.i.tileManager.F.XM_MUSIC_TRACK))).setPosition(paramFloat * 0.25F, paramFloat * 0.25F);
/* 714 */       image1.setSize(paramFloat * 0.5F, paramFloat * 0.5F);
/* 715 */       image1.setColor(arrayOfColor[4]);
/* 716 */       group.addActor((Actor)image1);
/*     */     } else {
/*     */       Image image1;
/*     */       
/* 720 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(paramFloat * 0.36F, paramFloat * 0.36F);
/* 721 */       image1.setPosition(paramFloat * 0.32F, paramFloat * 0.32F);
/* 722 */       image1.setColor(arrayOfColor[4]);
/* 723 */       group.addActor((Actor)image1);
/*     */       
/*     */       Image image2;
/* 726 */       (image2 = new Image(XmMusicTrackTileFactory.d(Game.i.tileManager.F.XM_MUSIC_TRACK))).setSize(paramFloat, paramFloat);
/* 727 */       group.addActor((Actor)image2);
/*     */     } 
/*     */     
/* 730 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 735 */     super.toJson(paramJson);
/*     */     
/* 737 */     paramJson.writeObjectStart("d");
/* 738 */     paramJson.writeValue("id", Long.valueOf(getId()));
/* 739 */     if (this.f != null) {
/* 740 */       paramJson.writeValue("track", this.f);
/*     */     }
/* 742 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 747 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 752 */     return 0.1D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 757 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (id: " + getId() + ", has track: " + ((this.f == null) ? "false" : "true") + ")";
/*     */   }
/*     */   
/*     */   public static class XmMusicTrackTileFactory extends Tile.Factory.AbstractFactory<XmMusicTrackTile> {
/*     */     private TextureRegion a;
/*     */     private TextureRegion b;
/*     */     private TextureRegion c;
/* 764 */     private TextureRegion[] d = new TextureRegion[4];
/*     */     
/*     */     public XmMusicTrackTileFactory() {
/* 767 */       super(TileType.XM_MUSIC_TRACK);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 773 */       if (param1Float < ProgressManager.getMinQuality(RarityType.RARE) || param1Float > ProgressManager.getMaxQuality(RarityType.RARE)) {
/* 774 */         return 0;
/*     */       }
/*     */       
/*     */       int i;
/* 778 */       if ((i = param1InventoryStatistics.byTileType[TileType.XM_MUSIC_TRACK.ordinal()]) >= 50) {
/* 779 */         return 0;
/*     */       }
/* 781 */       return 20;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 787 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-note");
/* 788 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-xm-sound-track-base");
/* 789 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-xm-sound-track-disc");
/* 790 */       for (byte b = 0; b < 4; b++) {
/* 791 */         this.d[b] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-xm-sound-track-corner-" + b);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public XmMusicTrackTile create() {
/* 797 */       return new XmMusicTrackTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public XmMusicTrackTile fromJson(JsonValue param1JsonValue) {
/* 802 */       XmMusicTrackTile xmMusicTrackTile = (XmMusicTrackTile)super.fromJson(param1JsonValue);
/*     */       
/* 804 */       if (param1JsonValue.has("d")) {
/* 805 */         xmMusicTrackTile.setId(param1JsonValue.get("d").getLong("id", -1L));
/* 806 */         xmMusicTrackTile.setTrack(param1JsonValue.get("d").getString("track", null));
/*     */       } 
/*     */       
/* 809 */       return xmMusicTrackTile;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\XmMusicTrackTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */