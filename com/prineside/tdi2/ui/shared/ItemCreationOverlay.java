/*      */ package com.prineside.tdi2.ui.shared;
/*      */ import com.badlogic.gdx.Input;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameValueConfig;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.AbilityType;
/*      */ import com.prineside.tdi2.enums.BlueprintType;
/*      */ import com.prineside.tdi2.enums.BossTileType;
/*      */ import com.prineside.tdi2.enums.BossType;
/*      */ import com.prineside.tdi2.enums.CaseType;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.GateType;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.gates.BarrierTypeGate;
/*      */ import com.prineside.tdi2.gates.TeleportGate;
/*      */ import com.prineside.tdi2.ibxm.Instrument;
/*      */ import com.prineside.tdi2.ibxm.Module;
/*      */ import com.prineside.tdi2.items.AbilityItem;
/*      */ import com.prineside.tdi2.items.BlueprintItem;
/*      */ import com.prineside.tdi2.items.CaseKeyItem;
/*      */ import com.prineside.tdi2.items.GateItem;
/*      */ import com.prineside.tdi2.items.RandomTileItem;
/*      */ import com.prineside.tdi2.items.ResourceItem;
/*      */ import com.prineside.tdi2.items.TileItem;
/*      */ import com.prineside.tdi2.managers.GameValueManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.CheckBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.tiles.BossTile;
/*      */ import com.prineside.tdi2.tiles.GameValueTile;
/*      */ import com.prineside.tdi2.tiles.PlatformTile;
/*      */ import com.prineside.tdi2.tiles.TargetTile;
/*      */ import com.prineside.tdi2.tiles.XmMusicTrackTile;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.RectButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ 
/*      */ public class ItemCreationOverlay extends UiManager.UiComponent.Adapter {
/*   72 */   private static final TLog a = TLog.forClass(ItemCreationOverlay.class);
/*      */   public static ItemCreationOverlay i() {
/*   74 */     return (ItemCreationOverlay)Game.i.uiManager.getComponent(ItemCreationOverlay.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   81 */   private static final ItemType[] b = new ItemType[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   88 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 150, "ItemCreationOverlay main");
/*      */   
/*   90 */   private final ObjectMap<ItemType, RectButton> d = new ObjectMap();
/*      */   
/*      */   public final SelectBox.SelectBoxStyle selectBoxStyle;
/*      */   public final TextField.TextFieldStyle textFieldStyle;
/*      */   private final CheckBox.CheckBoxStyle e;
/*      */   public final Table form;
/*      */   public Item currentItem;
/*   97 */   public ObjectConsumer<Item> changeListener = null;
/*      */   
/*      */   public Item originalItem;
/*      */   
/*      */   public boolean inPlaceItemTypeChangeAllowed;
/*      */   private final RectButton f;
/*      */   private final Group g;
/*  104 */   public int customIntA = -1;
/*  105 */   public int customIntB = -1;
/*  106 */   public Object customObject = null;
/*      */ 
/*      */   
/*      */   public ItemCreationOverlay() {
/*  110 */     this
/*      */ 
/*      */       
/*  113 */       .e = new CheckBox.CheckBoxStyle(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.RED.P500), Game.i.assetManager.getDrawable("blank").tint(MaterialColor.GREEN.P500), (BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*      */ 
/*      */     
/*  116 */     this.e.checkboxOff.setLeftWidth(24.0F);
/*  117 */     this.e.checkboxOff.setBottomHeight(24.0F);
/*      */     
/*  119 */     this.selectBoxStyle = Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(24), true);
/*  120 */     this.textFieldStyle = Game.i.assetManager.getTextFieldStyle(24);
/*      */     
/*      */     Group group1;
/*      */     
/*  124 */     (group1 = new Group()).setTransform(false);
/*  125 */     this.c.getTable().add((Actor)group1).size(1200.0F, 1000.0F);
/*      */     
/*      */     Image image;
/*  128 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(1200.0F, 1000.0F);
/*  129 */     image.setColor(new Color(858993663));
/*  130 */     group1.addActor((Actor)image);
/*      */     
/*  132 */     Table table = new Table();
/*      */     ScrollPane scrollPane2;
/*  134 */     UiUtils.enableMouseMoveScrollFocus(scrollPane2 = new ScrollPane((Actor)table, Game.i.assetManager.getScrollPaneStyle(8.0F)));
/*  135 */     scrollPane2.setSize(240.0F, 1000.0F);
/*  136 */     scrollPane2.setScrollingDisabled(true, false);
/*  137 */     group1.addActor((Actor)scrollPane2); ItemType[] arrayOfItemType; int i;
/*      */     byte b;
/*  139 */     for (i = (arrayOfItemType = ItemType.values).length, b = 0; b < i; ) { ItemType itemType = arrayOfItemType[b]; ItemType[] arrayOfItemType1;
/*  140 */       int j = (arrayOfItemType1 = b).length; byte b1 = 0; while (true) { if (b1 < j) { ItemType itemType1 = arrayOfItemType1[b1];
/*  141 */           if (itemType != itemType1) {
/*      */             b1++;
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*      */           break; }
/*      */         
/*      */         RectButton rectButton;
/*  150 */         (rectButton = new RectButton(itemType.name(), Game.i.assetManager.getLabelStyle(24), () -> { this.currentItem = Game.i.itemManager.getFactory(paramItemType).createDefault(); if (!this.inPlaceItemTypeChangeAllowed) setInPlaceEditingItem(null, null, false);  updateForm(); })).setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  151 */         table.add((Actor)rectButton).size(240.0F, 48.0F).padBottom(2.0F).row();
/*  152 */         this.d.put(itemType, rectButton); break; }
/*      */        b++; }
/*      */     
/*  155 */     table.add().width(1.0F).height(96.0F);
/*      */     
/*  157 */     this.form = new Table();
/*  158 */     this.form.setSize(940.0F, 906.0F);
/*      */     ScrollPane scrollPane1;
/*  160 */     UiUtils.enableMouseMoveScrollFocus(scrollPane1 = new ScrollPane((Actor)this.form, Game.i.assetManager.getScrollPaneStyle(16.0F)));
/*  161 */     scrollPane1.setSize(940.0F, 906.0F);
/*  162 */     scrollPane1.setPosition(250.0F, 84.0F);
/*  163 */     group1.addActor((Actor)scrollPane1);
/*      */     
/*      */     Group group2;
/*  166 */     (group2 = new Group()).setTransform(false);
/*  167 */     group2.setPosition(250.0F, 10.0F);
/*  168 */     group1.addActor((Actor)group2);
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform1;
/*  171 */     (textFieldXPlatform1 = new TextFieldXPlatform("<", this.textFieldStyle)).setSize(220.0F, 64.0F);
/*  172 */     textFieldXPlatform1.setPosition(210.0F, 0.0F);
/*  173 */     group2.addActor((Actor)textFieldXPlatform1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     RectButton rectButton1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  197 */     (rectButton1 = new RectButton("From json", Game.i.assetManager.getLabelStyle(24), () -> { Game.i.soundManager.playStatic(StaticSoundType.BUTTON); Game.i.uiManager.getTextInput(new Input.TextInputListener(this) { public void input(String param1String) { Threads.i().runOnMainThread(() -> { try { JsonValue jsonValue = (new JsonReader()).parse(param1String); this.a.currentItem = Item.fromJson(jsonValue); this.a.updateForm(); return; } catch (Exception exception) { Notifications.i().add("Failed to parse JSON", null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL); return; }  }); } public void canceled() {} }"From json", "", "Enter JSON of item"); })).setSize(230.0F, 64.0F);
/*  198 */     rectButton1.setPosition(-240.0F, 0.0F);
/*  199 */     group2.addActor((Actor)rectButton1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     RectButton rectButton2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  216 */     (rectButton2 = new RectButton("Get json", Game.i.assetManager.getLabelStyle(24), () -> { Game.i.soundManager.playStatic(StaticSoundType.BUTTON); Json json = new Json(JsonWriter.OutputType.json); StringWriter stringWriter = new StringWriter(); json.setWriter(stringWriter); json.writeObjectStart(); this.currentItem.toJson(json); json.writeObjectEnd(); a.i(stringWriter.toString(), new Object[0]); paramTextFieldXPlatform.setText(stringWriter.toString()); paramTextFieldXPlatform.getStage().setKeyboardFocus((Actor)paramTextFieldXPlatform); paramTextFieldXPlatform.selectAll(); })).setSize(200.0F, 64.0F);
/*  217 */     rectButton2.setPosition(0.0F, 0.0F);
/*  218 */     group2.addActor((Actor)rectButton2);
/*      */     
/*  220 */     this.g = new Group();
/*  221 */     this.g.setPosition(456.0F, 0.0F);
/*  222 */     this.g.setSize(64.0F, 64.0F);
/*  223 */     group2.addActor((Actor)this.g);
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform2;
/*  226 */     (textFieldXPlatform2 = new TextFieldXPlatform("1", this.textFieldStyle)).setSize(200.0F, 64.0F);
/*  227 */     textFieldXPlatform2.setPosition(530.0F, 0.0F);
/*  228 */     group2.addActor((Actor)textFieldXPlatform2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     RectButton rectButton3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  258 */     (rectButton3 = new RectButton("Give", Game.i.assetManager.getLabelStyle(24), () -> { Game.i.soundManager.playStatic(StaticSoundType.BUTTON); int i = 1; try { i = Integer.parseInt(paramTextFieldXPlatform.getText()); } catch (Exception exception) { Dialog.i().showAlert("Please enter correct items count"); }  if (this.currentItem != null) { Item item = this.currentItem.cpy(); Game.i.progressManager.addItems(item, i, "dev_mode"); a.i("item added: " + item.toString(), new Object[0]); Label label; (label = new Label("Done!", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREEN.P500); label.setPosition(740.0F, 0.0F); label.setSize(200.0F, 64.0F); label.setAlignment(1); label.setTouchable(Touchable.disabled); paramGroup.addActor((Actor)label); label.addAction((Action)Actions.sequence((Action)Actions.moveBy(0.0F, 64.0F, 0.3F, (Interpolation)Interpolation.exp5Out), (Action)Actions.fadeOut(0.2F), (Action)Actions.removeActor())); }  })).setSize(200.0F, 64.0F);
/*  259 */     rectButton3.setPosition(740.0F, 0.0F);
/*  260 */     group2.addActor((Actor)rectButton3);
/*      */     
/*  262 */     this.f = new RectButton("Apply", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */           Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */           
/*      */           if (this.currentItem != null && this.originalItem != null) {
/*      */             if (this.originalItem.getType() == this.currentItem.getType()) {
/*      */               try {
/*      */                 Item item = this.originalItem.from(this.currentItem);
/*      */                 this.changeListener.accept(item);
/*  270 */               } catch (Exception exception) {
/*      */                 a.e("failed to apply item changes", new Object[] { exception });
/*      */                 
/*      */                 this.changeListener.accept(this.currentItem);
/*      */               } 
/*      */             } else {
/*      */               a.i("type changed, new item", new Object[0]);
/*      */               
/*      */               this.changeListener.accept(this.currentItem);
/*      */             } 
/*      */             
/*      */             Label label;
/*      */             
/*      */             (label = new Label("Done!", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREEN.P500);
/*      */             
/*      */             label.setPosition(740.0F, 0.0F);
/*      */             label.setSize(200.0F, 64.0F);
/*      */             label.setAlignment(1);
/*      */             label.setTouchable(Touchable.disabled);
/*      */             paramGroup.addActor((Actor)label);
/*      */             label.addAction((Action)Actions.sequence((Action)Actions.moveBy(0.0F, 64.0F, 0.3F, (Interpolation)Interpolation.exp5Out), (Action)Actions.fadeOut(0.2F), (Action)Actions.removeActor()));
/*      */             return;
/*      */           } 
/*      */           a.e("current " + this.currentItem + " original " + this.originalItem, new Object[0]);
/*      */         });
/*  295 */     this.f.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.GRAY);
/*  296 */     this.f.setSize(200.0F, 64.0F);
/*  297 */     this.f.setPosition(960.0F, 0.0F);
/*  298 */     group2.addActor((Actor)this.f);
/*      */     
/*  300 */     this.currentItem = (Item)Item.D.GREEN_PAPER;
/*  301 */     updateForm();
/*      */     
/*  303 */     hide();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPersistent() {
/*  308 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Label hintLabel(String paramString, boolean paramBoolean) {
/*      */     Label label;
/*  316 */     (label = new Label(paramString, Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  317 */     label.setWrap(true);
/*  318 */     this.form.add((Actor)label).top().left().pad(0.0F, 0.0F, 10.0F, 0.0F).top().left().fillX().expandX();
/*  319 */     if (paramBoolean) this.form.row();
/*      */     
/*  321 */     return label;
/*      */   }
/*      */   
/*      */   public Label labelEndRow(String paramString, boolean paramBoolean) {
/*  325 */     Label label = new Label(paramString, Game.i.assetManager.getLabelStyle(24));
/*  326 */     this.form.add((Actor)label).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).top().left();
/*  327 */     if (paramBoolean) this.form.row();
/*      */     
/*  329 */     return label;
/*      */   }
/*      */   
/*      */   public Label label(String paramString) {
/*  333 */     return labelEndRow(paramString, true);
/*      */   }
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public LabelToggleButton toggle(String paramString, boolean paramBoolean, ObjectConsumer<Boolean> paramObjectConsumer) {
/*  338 */     return toggle(true, paramString, paramBoolean, paramObjectConsumer);
/*      */   }
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public LabelToggleButton toggle(boolean paramBoolean1, String paramString, boolean paramBoolean2, ObjectConsumer<Boolean> paramObjectConsumer) {
/*  343 */     LabelToggleButton labelToggleButton = new LabelToggleButton(paramString, paramBoolean2, 24, 32.0F, paramObjectConsumer);
/*  344 */     if (paramBoolean1) this.form.add((Actor)labelToggleButton).height(48.0F).top().left().row();
/*      */     
/*  346 */     return labelToggleButton;
/*      */   }
/*      */   
/*      */   public void selectBox(SelectBox paramSelectBox) {
/*  350 */     this.form.add((Actor)paramSelectBox).size(400.0F, 48.0F).top().left().row();
/*      */   }
/*      */   
/*      */   public TextFieldXPlatform textFieldOfWidth(String paramString, float paramFloat, ObjectConsumer<String> paramObjectConsumer) {
/*  354 */     return textFieldEndRow(paramString, paramFloat, paramObjectConsumer, true);
/*      */   }
/*      */   
/*      */   public TextFieldXPlatform textFieldEndRow(String paramString, float paramFloat, ObjectConsumer<String> paramObjectConsumer, boolean paramBoolean) {
/*      */     TextFieldXPlatform textFieldXPlatform;
/*  359 */     (textFieldXPlatform = new TextFieldXPlatform(paramString, this.textFieldStyle)).setSize(paramFloat, 64.0F);
/*  360 */     this.form.add((Actor)textFieldXPlatform).top().left().size(paramFloat, 48.0F);
/*  361 */     if (paramBoolean) this.form.row();
/*      */     
/*  363 */     textFieldXPlatform.addListener((EventListener)new ChangeListener(this, paramObjectConsumer, textFieldXPlatform)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  366 */             this.a.accept(this.b.getText());
/*      */           }
/*      */         });
/*      */     
/*  370 */     return textFieldXPlatform;
/*      */   }
/*      */   
/*      */   public TextFieldXPlatform textField(String paramString, ObjectConsumer<String> paramObjectConsumer) {
/*  374 */     return textFieldOfWidth(paramString, 300.0F, paramObjectConsumer);
/*      */   }
/*      */   
/*      */   public void updateItemIcon() {
/*  378 */     this.g.clear();
/*  379 */     this.g.addActor(this.currentItem.generateIcon(64.0F, true)); } public void updateForm() { TileItem tileItem; SelectBox selectBox1; Table table1; Module module; Array array2; byte b1; Array array1; BlueprintItem blueprintItem; CaseKeyItem caseKeyItem; AbilityItem abilityItem; GateItem gateItem; BarrierTypeGate barrierTypeGate; TeleportGate teleportGate; ResourceItem resourceItem; RandomTileItem randomTileItem; PlatformTile platformTile; BossTile bossTile; XmMusicTrackTile xmMusicTrackTile; TargetTile targetTile; GameValueTile gameValueTile; SelectBox selectBox2; Array array3; Table table3; GameValueType[] arrayOfGameValueType1; SelectBox selectBox3; Table table2; SpaceTileBonusType[] arrayOfSpaceTileBonusType; BossTileType[] arrayOfBossTileType; int i; EnemyType[] arrayOfEnemyType; int k; Table table4; int j; byte b3; Array array4; byte b2; GameValueType[] arrayOfGameValueType2; SelectBox selectBox4;
/*      */     int m;
/*      */     RectButton rectButton;
/*      */     byte b4;
/*  383 */     updateItemIcon();
/*      */     
/*  385 */     for (ObjectMap.Values<RectButton> values = this.d.values().iterator(); values.hasNext();) {
/*  386 */       (rectButton1 = values.next()).setEnabled(true);
/*      */     }
/*  388 */     ((RectButton)this.d.get(this.currentItem.getType())).setEnabled(false);
/*      */     
/*  390 */     this.form.clearChildren();
/*      */     
/*  392 */     this.currentItem.fillItemCreationForm(this);
/*      */     
/*  394 */     switch (null.d[this.currentItem.getType().ordinal()]) {
/*      */       case 1:
/*  396 */         tileItem = (TileItem)this.currentItem;
/*      */         
/*  398 */         switch (null.b[tileItem.tile.type.ordinal()]) {
/*      */           case 1:
/*  400 */             platformTile = (PlatformTile)tileItem.tile;
/*      */             
/*  402 */             label("Bonus type");
/*  403 */             selectBox1 = new SelectBox(this.selectBoxStyle);
/*      */             
/*  405 */             (array3 = new Array()).add("None");
/*  406 */             for (k = (arrayOfSpaceTileBonusType = SpaceTileBonusType.values).length, b3 = 0; b3 < k; ) { SpaceTileBonusType spaceTileBonusType = arrayOfSpaceTileBonusType[b3];
/*  407 */               array3.add(spaceTileBonusType.name()); b3++; }
/*      */             
/*  409 */             selectBox1.setItems(array3);
/*  410 */             selectBox1.setSelected((platformTile.bonusType == null) ? "None" : platformTile.bonusType.name());
/*  411 */             selectBox1.addListener((EventListener)new ChangeListener(this, selectBox1, platformTile)
/*      */                 {
/*      */                   public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  414 */                     if (((String)this.a.getSelected()).equals("None")) {
/*  415 */                       this.b.bonusType = null;
/*  416 */                       this.b.bonusLevel = 0;
/*      */                     } else {
/*  418 */                       this.b.bonusType = SpaceTileBonusType.valueOf((String)this.a.getSelected());
/*      */                     } 
/*  420 */                     this.c.updateForm();
/*      */                   }
/*      */                 });
/*  423 */             selectBox(selectBox1);
/*      */             
/*  425 */             if (platformTile.bonusType != null) {
/*  426 */               label("Bonus level");
/*  427 */               textField(String.valueOf(platformTile.bonusLevel), paramString -> {
/*      */                     try {
/*      */                       paramPlatformTile.bonusLevel = Integer.parseInt(paramString);
/*      */                       if (paramPlatformTile.bonusLevel < 0 || paramPlatformTile.bonusLevel > 5)
/*      */                         paramPlatformTile.bonusLevel = 0; 
/*      */                       updateItemIcon();
/*      */                       return;
/*  434 */                     } catch (Exception exception) {
/*      */                       a.e("bad value: " + paramString, new Object[0]);
/*      */                       return;
/*      */                     } 
/*      */                   });
/*      */             } 
/*      */             break;
/*      */           
/*      */           case 2:
/*  443 */             bossTile = (BossTile)((TileItem)selectBox1).tile;
/*      */             
/*  445 */             label("Type");
/*  446 */             selectBox1 = new SelectBox(this.selectBoxStyle);
/*  447 */             array3 = new Array();
/*  448 */             for (k = (arrayOfBossTileType = BossTileType.values).length, b3 = 0; b3 < k; ) { BossTileType bossTileType = arrayOfBossTileType[b3];
/*  449 */               array3.add(bossTileType); b3++; }
/*      */             
/*  451 */             selectBox1.setItems(array3);
/*  452 */             selectBox1.setSelected(bossTile.getBossTileType());
/*  453 */             selectBox1.addListener((EventListener)new ChangeListener(this, bossTile, selectBox1)
/*      */                 {
/*      */                   public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  456 */                     this.a.setBossTileType((BossTileType)this.b.getSelected());
/*  457 */                     this.c.updateForm();
/*      */                   }
/*      */                 });
/*  460 */             selectBox(selectBox1);
/*      */             
/*  462 */             if (bossTile.getBossTileType() == BossTileType.ONE) {
/*  463 */               label("Boss type");
/*      */               SelectBox selectBox;
/*  465 */               (selectBox = new SelectBox(this.selectBoxStyle)).setItems(new Array((Object[])BossType.values));
/*  466 */               selectBox.setSelected(bossTile.oneBossType);
/*  467 */               selectBox.addListener((EventListener)new ChangeListener(this, bossTile, selectBox)
/*      */                   {
/*      */                     public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  470 */                       this.a.oneBossType = (BossType)this.b.getSelected();
/*  471 */                       this.c.updateForm();
/*      */                     }
/*      */                   });
/*  474 */               selectBox(selectBox); break;
/*  475 */             }  if (bossTile.getBossTileType() == BossTileType.CUSTOM) {
/*  476 */               label("Effects");
/*  477 */               Array array5 = bossTile.customEffects;
/*  478 */               Table table5 = new Table();
/*  479 */               this.form.add((Actor)table5).top().left().row();
/*      */ 
/*      */ 
/*      */               
/*  483 */               if (array5.size != 0) {
/*  484 */                 Label label1 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  485 */                 table5.add((Actor)label1);
/*      */                 
/*  487 */                 label1 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  488 */                 table5.add((Actor)label1);
/*      */                 
/*  490 */                 label1 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  491 */                 table5.add((Actor)label1);
/*      */                 
/*  493 */                 label1 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  494 */                 table5.add((Actor)label1).padBottom(8.0F).row();
/*      */               } 
/*      */               
/*  497 */               for (byte b6 = 0; b6 < array5.size; b6++) {
/*  498 */                 GameValueConfig gameValueConfig = (GameValueConfig)array5.get(b6);
/*      */                 
/*      */                 Label label1;
/*  501 */                 (label1 = new Label(gameValueConfig.getType().name(), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.AMBER.P300);
/*  502 */                 table5.add((Actor)label1).width(300.0F).padLeft(10.0F).padRight(10.0F).top().left().height(48.0F).padBottom(4.0F);
/*      */                 
/*  504 */                 TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(gameValueConfig.getValue()), this.textFieldStyle);
/*  505 */                 table5.add((Actor)textFieldXPlatform1).width(160.0F).top().left().height(48.0F);
/*  506 */                 textFieldXPlatform1.addListener((EventListener)new ChangeListener(this, textFieldXPlatform1, gameValueConfig)
/*      */                     {
/*      */                       public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  509 */                         String str = this.a.getText();
/*      */                         try {
/*  511 */                           this.b.setValue(Double.parseDouble(str));
/*  512 */                         } catch (Exception exception) {
/*  513 */                           ItemCreationOverlay.a().e("bad value: " + str, new Object[0]);
/*      */                         } 
/*  515 */                         this.c.updateItemIcon();
/*      */                       }
/*      */                     });
/*      */                 
/*  519 */                 Label label2 = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  520 */                 table5.add((Actor)label2).width(60.0F).padLeft(10.0F).top().left().height(48.0F);
/*      */                 
/*  522 */                 switch (null.a[(Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType())).units.ordinal()]) { case 1:
/*  523 */                     label2.setText("0/1"); break;
/*  524 */                   case 2: label2.setText("s"); break;
/*  525 */                   case 3: label2.setText("%"); break;
/*  526 */                   case 4: label2.setText("/s"); break;
/*  527 */                   case 5: label2.setText("%/s");
/*      */                     break; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 PaddedImageButton paddedImageButton;
/*  535 */                 (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> { paramBossTile.customEffects.removeValue(paramGameValueConfig, true); updateForm(); Game.i.soundManager.playStatic(StaticSoundType.BUTTON); }MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setIconSize(32.0F, 32.0F);
/*  536 */                 paddedImageButton.setIconPosition(8.0F, 8.0F);
/*  537 */                 table5.add((Actor)paddedImageButton).padLeft(32.0F).size(48.0F).top().left().row();
/*      */               } 
/*      */               
/*  540 */               Table table6 = new Table();
/*  541 */               this.form.add((Actor)table6).top().left().height(48.0F).padTop(10.0F).row();
/*      */               
/*  543 */               Array array6 = new Array(); GameValueType[] arrayOfGameValueType; int n; byte b7;
/*  544 */               for (n = (arrayOfGameValueType = GameValueType.values).length, b7 = 0; b7 < n; ) { GameValueType gameValueType = arrayOfGameValueType[b7];
/*  545 */                 boolean bool = false;
/*  546 */                 for (byte b = 0; b < bossTile.customEffects.size; b++) {
/*  547 */                   if (((GameValueConfig)bossTile.customEffects.get(b)).getType() == gameValueType) {
/*  548 */                     bool = true;
/*      */                   }
/*      */                 } 
/*  551 */                 if (!bool)
/*  552 */                   array6.add(gameValueType); 
/*      */                 b7++; }
/*      */               
/*      */               SelectBox selectBox;
/*  556 */               (selectBox = new SelectBox(this.selectBoxStyle)).setItems(array6);
/*  557 */               table6.add((Actor)selectBox).size(400.0F, 48.0F).padRight(10.0F);
/*      */               
/*  559 */               RectButton rectButton1 = new RectButton("Add", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */                     GameValueConfig gameValueConfig = new GameValueConfig((GameValueType)paramSelectBox.getSelected(), 0.0D, false, true);
/*      */ 
/*      */                     
/*      */                     paramBossTile.customEffects.add(gameValueConfig);
/*      */                     
/*      */                     updateForm();
/*      */                     
/*      */                     Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                   });
/*      */               
/*  570 */               table6.add((Actor)rectButton1).size(200.0F, 48.0F);
/*      */               
/*  572 */               label("Waves");
/*  573 */               BossTile.BossWavesConfig bossWavesConfig = bossTile.customBossWaveConfig;
/*      */               
/*  575 */               table1 = new Table();
/*  576 */               this.form.add((Actor)table1).top().left().padTop(10.0F).row();
/*      */               
/*      */               Label label;
/*  579 */               (label = new Label("Start delay", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  580 */               table1.add((Actor)label).padRight(16.0F);
/*      */               
/*      */               TextFieldXPlatform textFieldXPlatform;
/*  583 */               (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(bossWavesConfig.startDelay), this.textFieldStyle)).addListener((EventListener)new ChangeListener(this, bossWavesConfig)
/*      */                   {
/*      */                     public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  586 */                       String str = ((TextFieldXPlatform)param1Actor).getText();
/*      */                       try {
/*  588 */                         this.a.startDelay = Integer.parseInt(str);
/*  589 */                         if (this.a.startDelay < 0) this.a.startDelay = 0; 
/*  590 */                         this.b.updateItemIcon(); return;
/*  591 */                       } catch (Exception exception) {
/*  592 */                         ItemCreationOverlay.a().e("bad value: " + str, new Object[0]);
/*      */                         return;
/*      */                       }  }
/*      */                   });
/*  596 */               table1.add((Actor)textFieldXPlatform).size(200.0F, 48.0F).padBottom(4.0F).row();
/*      */ 
/*      */               
/*  599 */               (label = new Label("Cycle length", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  600 */               table1.add((Actor)label).padRight(16.0F);
/*      */ 
/*      */               
/*  603 */               (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(bossWavesConfig.cycleLength), this.textFieldStyle)).addListener((EventListener)new ChangeListener(this, bossWavesConfig)
/*      */                   {
/*      */                     public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  606 */                       String str = ((TextFieldXPlatform)param1Actor).getText();
/*      */                       try {
/*  608 */                         this.a.cycleLength = Integer.parseInt(str);
/*  609 */                         if (this.a.cycleLength <= 0) this.a.cycleLength = 1; 
/*  610 */                         this.b.updateItemIcon(); return;
/*  611 */                       } catch (Exception exception) {
/*  612 */                         ItemCreationOverlay.a().e("bad value: " + str, new Object[0]);
/*      */                         return;
/*      */                       }  }
/*      */                   });
/*  616 */               table1.add((Actor)textFieldXPlatform).size(200.0F, 48.0F).padBottom(4.0F).row();
/*      */ 
/*      */               
/*  619 */               (label = new Label("Repeat count", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  620 */               table1.add((Actor)label).padRight(16.0F);
/*      */ 
/*      */               
/*  623 */               (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(bossWavesConfig.repeatCount), this.textFieldStyle)).addListener((EventListener)new ChangeListener(this, bossWavesConfig)
/*      */                   {
/*      */                     public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  626 */                       String str = ((TextFieldXPlatform)param1Actor).getText();
/*      */                       try {
/*  628 */                         this.a.repeatCount = Integer.parseInt(str);
/*  629 */                         this.b.updateItemIcon(); return;
/*  630 */                       } catch (Exception exception) {
/*  631 */                         ItemCreationOverlay.a().e("bad value: " + str, new Object[0]);
/*      */                         return;
/*      */                       }  }
/*      */                   });
/*  635 */               table1.add((Actor)textFieldXPlatform).size(200.0F, 48.0F).padBottom(4.0F).row();
/*      */ 
/*      */               
/*  638 */               table1 = new Table();
/*  639 */               this.form.add((Actor)table1).top().left().row();
/*      */               
/*  641 */               if (bossWavesConfig.bossWavePairs.size != 0) {
/*  642 */                 Label label1 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  643 */                 table1.add((Actor)label1);
/*      */                 
/*  645 */                 label1 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  646 */                 table1.add((Actor)label1);
/*      */                 
/*  648 */                 label1 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  649 */                 table1.add((Actor)label1).padBottom(8.0F).row();
/*      */               } 
/*      */               
/*  652 */               for (byte b5 = 0; b5 < bossWavesConfig.bossWavePairs.size; b5++) {
/*  653 */                 BossTile.BossTypeWavePair bossTypeWavePair = (BossTile.BossTypeWavePair)bossWavesConfig.bossWavePairs.get(b5);
/*      */                 
/*      */                 SelectBox selectBox5;
/*  656 */                 (selectBox5 = new SelectBox(this.selectBoxStyle)).setItems((Object[])BossType.values);
/*  657 */                 selectBox5.setSelected(bossTypeWavePair.bossType);
/*  658 */                 selectBox5.addListener((EventListener)new ChangeListener(this, bossTypeWavePair, selectBox5)
/*      */                     {
/*      */                       public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  661 */                         this.a.bossType = (BossType)this.b.getSelected();
/*  662 */                         this.c.updateForm();
/*      */                       }
/*      */                     });
/*  665 */                 table1.add((Actor)selectBox5).width(260.0F).top().left().height(48.0F).padBottom(4.0F);
/*      */                 
/*  667 */                 TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(bossTypeWavePair.wave), this.textFieldStyle);
/*  668 */                 table1.add((Actor)textFieldXPlatform1).width(160.0F).top().left().padLeft(4.0F).height(48.0F);
/*  669 */                 textFieldXPlatform1.addListener((EventListener)new ChangeListener(this, textFieldXPlatform1, bossTypeWavePair)
/*      */                     {
/*      */                       public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  672 */                         String str = this.a.getText();
/*      */                         try {
/*  674 */                           this.b.wave = Integer.parseInt(str);
/*  675 */                         } catch (Exception exception) {
/*  676 */                           ItemCreationOverlay.a().e("bad value: " + str, new Object[0]);
/*      */                         } 
/*  678 */                         this.c.updateItemIcon();
/*      */                       }
/*      */                     });
/*      */ 
/*      */ 
/*      */                 
/*      */                 PaddedImageButton paddedImageButton;
/*      */ 
/*      */                 
/*  687 */                 (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> { paramBossWavesConfig.bossWavePairs.removeValue(paramBossTypeWavePair, true); updateForm(); Game.i.soundManager.playStatic(StaticSoundType.BUTTON); }MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setIconSize(32.0F, 32.0F);
/*  688 */                 paddedImageButton.setIconPosition(8.0F, 8.0F);
/*  689 */                 table1.add((Actor)paddedImageButton).padLeft(32.0F).size(48.0F).top().left().row();
/*      */               } 
/*      */               
/*  692 */               rectButton1 = new RectButton("Add", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */                     BossTile.BossTypeWavePair bossTypeWavePair = new BossTile.BossTypeWavePair(1, BossType.BROOT);
/*      */                     paramBossTile.customBossWaveConfig.bossWavePairs.add(bossTypeWavePair);
/*      */                     updateForm();
/*      */                     Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                   });
/*  698 */               this.form.add((Actor)rectButton1).top().left().padTop(16.0F).size(200.0F, 48.0F);
/*      */             } 
/*      */             break;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 3:
/*  706 */             xmMusicTrackTile = (XmMusicTrackTile)((TileItem)table1).tile;
/*      */             
/*  708 */             label("ID");
/*  709 */             textField(String.valueOf(xmMusicTrackTile.getId()), paramString -> {
/*      */                   try {
/*      */                     paramXmMusicTrackTile.setId(Long.parseLong(paramString)); updateItemIcon();
/*      */                     return;
/*  713 */                   } catch (Exception exception) {
/*      */                     a.e("bad value: " + paramString, new Object[0]);
/*      */                     return;
/*      */                   } 
/*      */                 });
/*  718 */             label("Track");
/*  719 */             textField(String.valueOf(xmMusicTrackTile.getTrackBase64()), paramString -> {
/*      */                   try {
/*      */                     paramXmMusicTrackTile.setTrack(paramString); paramXmMusicTrackTile.getModule();
/*      */                     updateItemIcon();
/*      */                     updateForm();
/*      */                     return;
/*  725 */                   } catch (Exception exception) {
/*      */                     paramXmMusicTrackTile.setTrack(null);
/*      */                     return;
/*      */                   } 
/*      */                 });
/*      */             try {
/*  731 */               module = xmMusicTrackTile.getModule();
/*      */               Label label;
/*  733 */               (label = label(module.songName)).setColor(MaterialColor.AMBER.P500);
/*      */               Instrument[] arrayOfInstrument;
/*  735 */               for (k = (arrayOfInstrument = module.instruments).length, b3 = 0; b3 < k; b3++) {
/*      */                 Instrument instrument; String str;
/*  737 */                 if ((str = (instrument = arrayOfInstrument[b3]).name.trim()).length() != 0)
/*      */                 { Label label1;
/*      */                   
/*  740 */                   (label1 = label(str)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  741 */                   label1.setStyle(Game.i.assetManager.getLabelStyle(21)); } 
/*      */               } 
/*  743 */             } catch (Exception exception) {
/*  744 */               label("Module can't be loaded");
/*      */             } 
/*      */             break;
/*      */ 
/*      */           
/*      */           case 4:
/*  750 */             targetTile = (TargetTile)((TileItem)module).tile;
/*      */             
/*  752 */             toggle("Disable abilities", targetTile.isDisableAbilities(), paramBoolean -> {
/*      */                   paramTargetTile.setDisableAbilities(paramBoolean.booleanValue());
/*      */                   
/*      */                   updateForm();
/*      */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                 });
/*  758 */             toggle("Ignore researches & trophies", targetTile.isUseStockGameValues(), paramBoolean -> {
/*      */                   paramTargetTile.setUseStockGameValues(paramBoolean.booleanValue());
/*      */                   
/*      */                   updateForm();
/*      */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                 });
/*  764 */             label("Effects");
/*      */             
/*  766 */             array2 = targetTile.getGameValues();
/*  767 */             table3 = new Table();
/*  768 */             this.form.add((Actor)table3).top().left().row();
/*      */ 
/*      */             
/*  771 */             if (array2.size != 0) {
/*  772 */               Label label = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  773 */               table3.add((Actor)label);
/*      */               
/*  775 */               label = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  776 */               table3.add((Actor)label);
/*      */               
/*  778 */               label = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  779 */               table3.add((Actor)label);
/*      */               
/*  781 */               if (!targetTile.isUseStockGameValues()) {
/*  782 */                 label = new Label("Consider researches", Game.i.assetManager.getLabelStyle(21));
/*  783 */                 table3.add((Actor)label).top().right().padLeft(24.0F);
/*      */               } 
/*      */               
/*  786 */               label = new Label("Overwrite", Game.i.assetManager.getLabelStyle(21));
/*  787 */               table3.add((Actor)label).top().right().padLeft(24.0F);
/*      */               
/*  789 */               label = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  790 */               table3.add((Actor)label).padBottom(8.0F).row();
/*      */             } 
/*      */             
/*  793 */             for (k = 0; k < array2.size; k++) {
/*  794 */               GameValueConfig gameValueConfig = (GameValueConfig)array2.get(k);
/*      */               
/*      */               Label label1;
/*  797 */               (label1 = new Label(gameValueConfig.getType().name(), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.AMBER.P300);
/*  798 */               table3.add((Actor)label1).width(300.0F).padLeft(10.0F).padRight(10.0F).top().left().height(48.0F).padBottom(4.0F);
/*      */               
/*  800 */               TextFieldXPlatform textFieldXPlatform = new TextFieldXPlatform(String.valueOf(gameValueConfig.getValue()), this.textFieldStyle);
/*  801 */               table3.add((Actor)textFieldXPlatform).width(160.0F).top().left().height(48.0F);
/*  802 */               textFieldXPlatform.addListener((EventListener)new ChangeListener(this, textFieldXPlatform, gameValueConfig, targetTile)
/*      */                   {
/*      */                     public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  805 */                       String str = this.a.getText();
/*      */                       try {
/*  807 */                         this.b.setValue(Double.parseDouble(str));
/*  808 */                         this.c.updateAppearance();
/*  809 */                       } catch (Exception exception) {
/*  810 */                         ItemCreationOverlay.a().e("bad value: " + str, new Object[0]);
/*      */                       } 
/*  812 */                       this.d.updateItemIcon();
/*      */                     }
/*      */                   });
/*      */               
/*  816 */               Label label2 = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  817 */               table3.add((Actor)label2).width(60.0F).padLeft(10.0F).top().left().height(48.0F);
/*      */               
/*  819 */               switch (null.a[(Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType())).units.ordinal()]) { case 1:
/*  820 */                   label2.setText("0/1"); break;
/*  821 */                 case 2: label2.setText("s"); break;
/*  822 */                 case 3: label2.setText("%"); break;
/*  823 */                 case 4: label2.setText("/s"); break;
/*  824 */                 case 5: label2.setText("%/s");
/*      */                   break; }
/*      */               
/*  827 */               if (!targetTile.isUseStockGameValues()) {
/*  828 */                 LabelToggleButton labelToggleButton1 = toggle(false, "", gameValueConfig.isAllowBonuses(), paramBoolean -> {
/*      */                       paramGameValueConfig.setAllowBonuses(paramBoolean.booleanValue());
/*      */                       paramTargetTile.updateAppearance();
/*      */                       updateForm();
/*      */                     });
/*  833 */                 table3.add((Actor)labelToggleButton1).size(96.0F, 48.0F).top().right();
/*      */               } 
/*      */               
/*  836 */               LabelToggleButton labelToggleButton = toggle(false, "", gameValueConfig.isOverwrite(), paramBoolean -> {
/*      */                     paramGameValueConfig.setOverwrite(paramBoolean.booleanValue());
/*      */                     paramTargetTile.updateAppearance();
/*      */                     updateForm();
/*      */                     Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                   });
/*  842 */               table3.add((Actor)labelToggleButton).size(96.0F, 48.0F).top().right();
/*      */ 
/*      */ 
/*      */               
/*      */               PaddedImageButton paddedImageButton;
/*      */ 
/*      */ 
/*      */               
/*  850 */               (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> { paramTargetTile.getGameValues().removeValue(paramGameValueConfig, true); paramTargetTile.removeGameValue(paramGameValueConfig); updateForm(); Game.i.soundManager.playStatic(StaticSoundType.BUTTON); }MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setIconSize(32.0F, 32.0F);
/*  851 */               paddedImageButton.setIconPosition(8.0F, 8.0F);
/*  852 */               table3.add((Actor)paddedImageButton).padLeft(32.0F).size(48.0F).top().left().row();
/*      */             } 
/*      */             
/*  855 */             table4 = new Table();
/*  856 */             this.form.add((Actor)table4).top().left().height(48.0F).padTop(10.0F).row();
/*      */             
/*  858 */             array4 = new Array();
/*  859 */             for (m = (arrayOfGameValueType2 = GameValueType.values).length, b4 = 0; b4 < m; ) { GameValueType gameValueType = arrayOfGameValueType2[b4];
/*  860 */               boolean bool = false;
/*  861 */               for (b1 = 0; b1 < (targetTile.getGameValues()).size; b1++) {
/*  862 */                 if (((GameValueConfig)targetTile.getGameValues().get(b1)).getType() == gameValueType) {
/*  863 */                   bool = true;
/*      */                 }
/*      */               } 
/*  866 */               if (!bool) {
/*  867 */                 array4.add(gameValueType);
/*      */               }
/*      */               b4++; }
/*      */             
/*  871 */             (selectBox4 = new SelectBox(this.selectBoxStyle)).setItems(array4);
/*  872 */             table4.add((Actor)selectBox4).size(400.0F, 48.0F).padRight(10.0F);
/*      */             
/*  874 */             rectButton = new RectButton("Add", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */                   GameValueConfig gameValueConfig = new GameValueConfig((GameValueType)paramSelectBox.getSelected(), 0.0D, false, true);
/*      */ 
/*      */                   
/*      */                   paramTargetTile.addGameValue(gameValueConfig);
/*      */                   
/*      */                   updateForm();
/*      */                   
/*      */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                 });
/*      */             
/*  885 */             table4.add((Actor)rectButton).size(200.0F, 48.0F);
/*      */             break;
/*      */ 
/*      */           
/*      */           case 5:
/*  890 */             gameValueTile = (GameValueTile)b1.tile;
/*      */             
/*  892 */             label("Game value");
/*  893 */             array1 = new Array();
/*  894 */             for (i = (arrayOfGameValueType1 = GameValueType.values).length, j = 0; j < i; ) { GameValueType gameValueType = arrayOfGameValueType1[j];
/*  895 */               array1.add(gameValueType);
/*      */               j++; }
/*      */             
/*  898 */             (selectBox3 = new SelectBox(this.selectBoxStyle)).setItems(array1);
/*  899 */             selectBox3.setSelected(gameValueTile.getGameValueType());
/*  900 */             selectBox3.addListener((EventListener)new ChangeListener(this, gameValueTile, selectBox3)
/*      */                 {
/*      */                   public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  903 */                     this.a.setGameValueType((GameValueType)this.b.getSelected());
/*  904 */                     this.c.updateForm();
/*      */                   }
/*      */                 });
/*  907 */             this.form.add((Actor)selectBox3).size(400.0F, 48.0F).top().left().row();
/*      */             
/*  909 */             toggle("Overwrite", gameValueTile.isOverwrite(), paramBoolean -> {
/*      */                   paramGameValueTile.setOverwrite(paramBoolean.booleanValue());
/*      */                   
/*      */                   updateItemIcon();
/*      */                 });
/*  914 */             toggle("Final multiplier", gameValueTile.isFinalMultiplier(), paramBoolean -> {
/*      */                   paramGameValueTile.setFinalMultiplier(paramBoolean.booleanValue());
/*      */                   
/*      */                   updateItemIcon();
/*      */                 });
/*  919 */             label("Delta");
/*  920 */             textField(String.valueOf(gameValueTile.getDelta()), paramString -> {
/*      */                   try {
/*      */                     paramGameValueTile.setDelta(Double.parseDouble(paramString)); updateItemIcon();
/*      */                     return;
/*  924 */                   } catch (Exception exception) {
/*      */                     a.e("bad value: " + paramString, new Object[0]);
/*      */                     return;
/*      */                   } 
/*      */                 });
/*      */             break;
/*      */         } 
/*      */         
/*      */         break;
/*      */       case 2:
/*  934 */         blueprintItem = (BlueprintItem)this.currentItem;
/*      */         
/*  936 */         label("Blueprint type");
/*      */ 
/*      */         
/*  939 */         (selectBox2 = new SelectBox(this.selectBoxStyle)).setItems((Object[])BlueprintType.values);
/*  940 */         selectBox2.setSelected(blueprintItem.getBlueprintType());
/*  941 */         selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2)
/*      */             {
/*      */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  944 */                 this.b.currentItem = (Item)Item.D.F_BLUEPRINT.create((BlueprintType)this.a
/*  945 */                     .getSelected());
/*      */                 
/*  947 */                 this.b.updateForm();
/*      */               }
/*      */             });
/*  950 */         selectBox(selectBox2);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 3:
/*  955 */         caseKeyItem = (CaseKeyItem)this.currentItem;
/*      */         
/*  957 */         label("Case type");
/*      */ 
/*      */         
/*  960 */         (selectBox2 = new SelectBox(this.selectBoxStyle)).setItems((Object[])CaseType.values);
/*  961 */         selectBox2.setSelected(caseKeyItem.caseType);
/*  962 */         selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2)
/*      */             {
/*      */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  965 */                 this.b.currentItem = (Item)Item.D.F_CASE_KEY.create((CaseType)this.a
/*  966 */                     .getSelected());
/*      */                 
/*  968 */                 this.b.updateForm();
/*      */               }
/*      */             });
/*  971 */         selectBox(selectBox2);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 4:
/*  976 */         abilityItem = (AbilityItem)this.currentItem;
/*      */         
/*  978 */         label("Ability type");
/*      */ 
/*      */         
/*  981 */         (selectBox2 = new SelectBox(this.selectBoxStyle)).setItems((Object[])AbilityType.values);
/*  982 */         selectBox2.setSelected(abilityItem.abilityType);
/*  983 */         selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2)
/*      */             {
/*      */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  986 */                 this.b.currentItem = (Item)Item.D.F_ABILITY.create((AbilityType)this.a
/*  987 */                     .getSelected());
/*      */                 
/*  989 */                 this.b.updateForm();
/*      */               }
/*      */             });
/*  992 */         selectBox(selectBox2);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 5:
/*  997 */         gateItem = (GateItem)this.currentItem;
/*      */         
/*  999 */         label("Gate type");
/*      */         
/* 1001 */         (selectBox2 = new SelectBox(this.selectBoxStyle)).setItems((Object[])GateType.values);
/* 1002 */         selectBox2.setSelected(gateItem.gate.getType());
/* 1003 */         selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2)
/*      */             {
/*      */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1006 */                 this.b.currentItem = (Item)Item.D.F_GATE.create(Game.i.gateManager
/* 1007 */                     .getFactory((GateType)this.a.getSelected()).create());
/*      */                 
/* 1009 */                 this.b.updateForm();
/*      */               }
/*      */             });
/* 1012 */         selectBox(selectBox2);
/*      */         
/* 1014 */         switch (null.c[gateItem.gate.getType().ordinal()]) {
/*      */           case 1:
/* 1016 */             barrierTypeGate = (BarrierTypeGate)gateItem.gate;
/*      */             
/* 1018 */             label("Blocked enemies");
/* 1019 */             table2 = new Table();
/* 1020 */             this.form.add((Actor)table2).top().left().row();
/* 1021 */             for (j = (arrayOfEnemyType = EnemyType.values).length, b2 = 0; b2 < j; ) { EnemyType enemyType = arrayOfEnemyType[b2];
/* 1022 */               Image image = new Image(Game.i.enemyManager.getFactory(enemyType).getTexture());
/* 1023 */               table2.add((Actor)image).size(32.0F).pad(8.0F).padRight(12.0F);
/*      */               
/* 1025 */               LabelToggleButton labelToggleButton = toggle(false, Game.i.enemyManager.getFactory(enemyType).getTitle(), barrierTypeGate.isEnemyBlocked(enemyType), paramBoolean -> {
/*      */                     paramBarrierTypeGate.setEnemyBlocked(paramEnemyType, paramBoolean.booleanValue());
/*      */                     updateForm();
/*      */                     Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                   });
/* 1030 */               table2.add((Actor)labelToggleButton).height(48.0F).width(400.0F).padLeft(16.0F).padBottom(4.0F).row();
/*      */               b2++; }
/*      */             
/*      */             break;
/*      */           
/*      */           case 2:
/* 1036 */             teleportGate = (TeleportGate)((GateItem)barrierTypeGate).gate;
/*      */             
/* 1038 */             label("Index");
/* 1039 */             textField(String.valueOf(teleportGate.index), paramString -> {
/*      */                   try {
/*      */                     int i;
/*      */                     if ((i = Integer.parseInt(paramString)) < 0 || i > TeleportGate.MAX_INDEX)
/*      */                       throw new RuntimeException("Index is out of range (0, " + TeleportGate.MAX_INDEX + ")"); 
/*      */                     paramTeleportGate.index = i;
/*      */                     updateItemIcon();
/*      */                     return;
/* 1047 */                   } catch (Exception exception) {
/*      */                     a.e("bad value: " + paramString, new Object[] { exception });
/*      */                     return;
/*      */                   } 
/*      */                 });
/*      */             break;
/*      */         } 
/*      */ 
/*      */         
/*      */         break;
/*      */       
/*      */       case 6:
/* 1059 */         resourceItem = (ResourceItem)this.currentItem;
/*      */         
/* 1061 */         label("Resource type");
/*      */         
/* 1063 */         (selectBox2 = new SelectBox(this.selectBoxStyle)).setItems((Object[])ResourceType.values);
/* 1064 */         selectBox2.setSelected(resourceItem.resourceType);
/* 1065 */         selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2)
/*      */             {
/*      */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1068 */                 this.b.currentItem = (Item)Item.D.F_RESOURCE.create((ResourceType)this.a.getSelected());
/* 1069 */                 this.b.updateForm();
/*      */               }
/*      */             });
/* 1072 */         selectBox(selectBox2);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 7:
/* 1077 */         label("Quality");
/*      */         
/* 1079 */         randomTileItem = (RandomTileItem)this.currentItem;
/*      */         
/* 1081 */         textField(String.valueOf(randomTileItem.quality), paramString -> {
/*      */               try {
/*      */                 this.currentItem = (Item)Item.D.F_RANDOM_TILE.create(Float.parseFloat(paramString)); updateItemIcon();
/*      */                 return;
/* 1085 */               } catch (Exception exception) {
/*      */                 a.e("bad value: " + paramString, new Object[0]);
/*      */                 return;
/*      */               } 
/*      */             });
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1112 */     this.form.add().row();
/* 1113 */     this.form.add().width(1.0F).height(80.0F).row();
/* 1114 */     this.form.add().expand().fill().row();
/*      */     
/* 1116 */     this.f.setVisible((this.changeListener != null)); }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInPlaceEditingItem(Item paramItem, ObjectConsumer<Item> paramObjectConsumer, boolean paramBoolean) {
/* 1122 */     this.changeListener = paramObjectConsumer;
/* 1123 */     this.originalItem = paramItem;
/* 1124 */     this.inPlaceItemTypeChangeAllowed = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void hide() {
/* 1129 */     DarkOverlay.i().removeCaller("ItemCreationOverlay");
/* 1130 */     this.c.getTable().setVisible(false);
/*      */     
/* 1132 */     setInPlaceEditingItem(null, null, false);
/*      */     
/* 1134 */     Game.i.uiManager.stage.unfocusAll();
/*      */   }
/*      */   
/*      */   public void show() {
/* 1138 */     if (!Config.isModdingMode() && !Game.i.progressManager.isDeveloperModeEnabled()) {
/* 1139 */       Dialog.i().showAlert("Developer mode research required");
/*      */       
/*      */       return;
/*      */     } 
/* 1143 */     DarkOverlay.i().addCallerOverlayLayer("ItemCreationOverlay", this.c.zIndex - 1, () -> {
/*      */           hide();
/*      */           return true;
/*      */         });
/* 1147 */     this.c.getTable().setVisible(true);
/*      */   }
/*      */   
/*      */   public void showForItem(Item paramItem) {
/* 1151 */     this.currentItem = paramItem.cpy();
/* 1152 */     setInPlaceEditingItem(null, null, false);
/* 1153 */     updateForm();
/* 1154 */     show();
/*      */   }
/*      */   
/*      */   public void showForItemListenable(Item paramItem, ObjectConsumer<Item> paramObjectConsumer, boolean paramBoolean) {
/* 1158 */     this.currentItem = paramItem.cpy();
/* 1159 */     setInPlaceEditingItem(paramItem, paramObjectConsumer, paramBoolean);
/*      */ 
/*      */     
/* 1162 */     updateForm();
/* 1163 */     show();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\ItemCreationOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */