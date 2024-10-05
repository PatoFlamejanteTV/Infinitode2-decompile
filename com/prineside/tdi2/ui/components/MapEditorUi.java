/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.events.mapEditor.HistoryUpdate;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapEditorSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class MapEditorUi implements Disposable {
/*     */   private final UiManager.UiLayer a;
/*     */   private Label b;
/*     */   private GameSystemProvider c;
/*     */   public final Array<ToolButton> toolButtons;
/*     */   private Table d;
/*     */   private PaddedImageButton e;
/*     */   private ToolButton f;
/*     */   
/*     */   public MapEditorUi(GameSystemProvider paramGameSystemProvider) {
/*     */     String str;
/*  32 */     this.a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 102, "MapEditorUi");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  37 */     this.toolButtons = new Array(true, 1, ToolButton.class);
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
/*  49 */     this.m = new Array(true, 1, PreparedTooltip.class);
/*     */     
/*  51 */     this.n = this::d;
/*     */ 
/*     */     
/*  54 */     this.c = paramGameSystemProvider;
/*     */     
/*  56 */     paramGameSystemProvider.events.getListeners(HistoryUpdate.class).add(paramHistoryUpdate -> Game.i.uiManager.runOnStageActOnce(this.n)).setDescription("MapEditorUi - updates prestige score");
/*     */     
/*  58 */     Game.i.settingsManager.getScaledViewportHeight();
/*     */     
/*     */     Table table2;
/*  61 */     (table2 = this.a.getTable()).setName("main_map_editor_ui");
/*     */     
/*     */     Group group;
/*  64 */     (group = new Group()).setTransform(false);
/*  65 */     group.setSize(144.0F, Game.i.settingsManager.getScaledViewportHeight());
/*  66 */     group.setTouchable(Touchable.childrenOnly);
/*  67 */     table2.add((Actor)group).expand().top().left().row();
/*     */     
/*  69 */     if (Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.PRESTIGE_MODE)) {
/*     */       Image image1;
/*  71 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"))).setPosition(170.0F, Game.i.settingsManager.getScaledViewportHeight() - 80.0F);
/*  72 */       image1.setSize(32.0F, 32.0F);
/*  73 */       image1.setColor(MaterialColor.AMBER.P500);
/*  74 */       group.addActor((Actor)image1);
/*     */       
/*  76 */       this.b = new Label("0 mP", Game.i.assetManager.getLabelStyle(24));
/*  77 */       this.b.setPosition(214.0F, Game.i.settingsManager.getScaledViewportHeight() - 80.0F);
/*  78 */       this.b.setColor(MaterialColor.AMBER.P500);
/*  79 */       group.addActor((Actor)this.b);
/*  80 */       this.b.setTouchable(Touchable.disabled);
/*     */     } 
/*     */     
/*  83 */     d();
/*     */ 
/*     */     
/*  86 */     float f = Game.i.settingsManager.getScaledViewportHeight();
/*     */     
/*     */     Table table3;
/*     */     
/*  90 */     (table3 = new Table()).setSize(144.0F, f);
/*  91 */     group.addActor((Actor)table3);
/*     */     
/*     */     Image image;
/*  94 */     (image = new Image((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorUi.toolPaneBackground"))).setSize(144.0F, f);
/*  95 */     table3.addActor((Actor)image);
/*     */ 
/*     */     
/*  98 */     Table table1 = new Table();
/*  99 */     table3.add((Actor)table1).width(144.0F).row();
/*     */ 
/*     */     
/* 102 */     this
/*     */       
/* 104 */       .e = (new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-house"), () -> paramGameSystemProvider._mapEditor.goToPreviousScreen(), new Color(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P600)).setIconPosition(24.0F, 16.0F).setIconSize(96.0F, 96.0F);
/* 105 */     table1.add((Actor)this.e).size(144.0F, 144.0F).row();
/*     */ 
/*     */     
/* 108 */     this.f = new ToolButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"), () -> paramGameSystemProvider._mapEditor.startMap(), null);
/* 109 */     table1.add((Actor)this.f).size(144.0F, 96.0F).row();
/*     */     
/* 111 */     this.g = new ToolButton((Drawable)Game.i.assetManager.getDrawable("icon-info"), this::b, null);
/* 112 */     table1.add((Actor)this.g).size(144.0F, 96.0F).row();
/*     */     
/* 114 */     this.h = new Table();
/* 115 */     table1.add((Actor)this.h).size(144.0F, 96.0F).row();
/*     */     
/* 117 */     this.i = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-left-hollow"), () -> paramGameSystemProvider._mapEditor.historyBack(), new Color(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500);
/* 118 */     this.i.setIconSize(48.0F, 48.0F);
/* 119 */     this.i.setIconPosition(18.0F, 24.0F);
/* 120 */     this.i.setDisabledColor(new Color(0.0F, 0.0F, 0.0F, 0.56F));
/* 121 */     this.h.add((Actor)this.i).size(72.0F, 96.0F);
/*     */     
/* 123 */     this.j = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right-hollow"), () -> paramGameSystemProvider._mapEditor.historyForward(), new Color(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500);
/* 124 */     this.j.setIconSize(48.0F, 48.0F);
/* 125 */     this.j.setIconPosition(6.0F, 24.0F);
/* 126 */     this.j.setDisabledColor(new Color(0.0F, 0.0F, 0.0F, 0.56F));
/* 127 */     this.h.add((Actor)this.j).size(72.0F, 96.0F);
/*     */     
/* 129 */     this.k = new LabelButton("Ctrl", Game.i.assetManager.getLabelStyle(24), this::toggleCtrlButton);
/* 130 */     this.k.setAlignment(1);
/* 131 */     table1.add((Actor)this.k).size(144.0F, 48.0F).row();
/* 132 */     toggleCtrlButton();
/* 133 */     toggleCtrlButton();
/*     */ 
/*     */     
/* 136 */     this.d = new Table();
/*     */     ScrollPane scrollPane;
/* 138 */     (scrollPane = new ScrollPane((Actor)this.d, Game.i.assetManager.getScrollPaneStyle(0.0F))).setScrollingDisabled(true, false);
/* 139 */     table3.add((Actor)scrollPane).growY().width(144.0F);
/*     */ 
/*     */ 
/*     */     
/* 143 */     if (paramGameSystemProvider._mapEditor.basicLevelEditor) {
/* 144 */       str = Game.i.localeManager.i18n.get("basic_level");
/*     */     } else {
/* 146 */       str = Game.i.localeManager.i18n.get("custom_map");
/*     */     } 
/*     */     Label label;
/* 149 */     (label = new Label(str + ": " + (paramGameSystemProvider._mapEditor.basicLevelEditor ? paramGameSystemProvider._mapEditor.basicLevel.name : paramGameSystemProvider._mapEditor.userMap.name), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 150 */     label.setPosition(166.0F, 20.0F);
/* 151 */     label.setTouchable(Touchable.disabled);
/* 152 */     group.addActor((Actor)label);
/*     */     
/* 154 */     a();
/* 155 */     paramGameSystemProvider.events.getListeners(HistoryUpdate.class).add(paramHistoryUpdate -> a());
/*     */   }
/*     */   private ToolButton g; private Table h; private PaddedImageButton i; private PaddedImageButton j; private LabelButton k; private boolean l; private final Array<PreparedTooltip> m; private final Runnable n;
/*     */   public boolean isCtrlButtonEnabled() {
/* 159 */     return this.l;
/*     */   }
/*     */   
/*     */   public void toggleCtrlButton() {
/* 163 */     this.l = !this.l;
/* 164 */     if (this.l) {
/* 165 */       this.k.setColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P300);
/* 166 */       this.k.setStyle(Game.i.assetManager.getLabelStyle(30)); return;
/*     */     } 
/* 168 */     this.k.setColors(new Color(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P300);
/* 169 */     this.k.setStyle(Game.i.assetManager.getLabelStyle(24));
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 174 */     this.i.setEnabled(this.c._mapEditor.hasHistoryBack());
/* 175 */     this.j.setEnabled(this.c._mapEditor.hasHistoryForward());
/*     */   }
/*     */   
/*     */   private void b() {
/* 179 */     TooltipsOverlay.i().hideAll(false);
/* 180 */     this.m.clear();
/* 181 */     this.m.add(new PreparedTooltip("map_editor_1", (Actor)this.e, Game.i.localeManager.i18n.get("map_editor_tooltip_home_button")));
/* 182 */     this.m.add(new PreparedTooltip("map_editor_2", (Actor)this.f, Game.i.localeManager.i18n.get("map_editor_tooltip_play_button")));
/* 183 */     this.m.add(new PreparedTooltip("map_editor_3", (Actor)this.g, Game.i.localeManager.i18n.get("map_editor_tooltip_help_button")));
/* 184 */     this.m.add(new PreparedTooltip("map_editor_4", (Actor)this.h, Game.i.localeManager.i18n.get("map_editor_tooltip_history_buttons")));
/*     */     
/* 186 */     for (Array.ArrayIterator<MapEditorSystem.Tool> arrayIterator = this.c._mapEditor.getTools().iterator(); arrayIterator.hasNext();) {
/*     */       
/* 188 */       if ((preparedTooltip = (tool = arrayIterator.next()).getTooltip()) != null) {
/* 189 */         this.m.add(preparedTooltip);
/*     */       }
/*     */     } 
/*     */     
/* 193 */     c();
/*     */   }
/*     */   
/*     */   private void c() {
/* 197 */     if (this.m.size != 0) {
/*     */       PreparedTooltip preparedTooltip;
/* 199 */       if ((preparedTooltip = (PreparedTooltip)this.m.removeIndex(0)) != null) {
/* 200 */         (TooltipsOverlay.i().showText(preparedTooltip.id, preparedTooltip.forActor, preparedTooltip.message, this.a.mainUiLayer, this.a.zIndex + 1, 16)).onDispose = this::c; return;
/*     */       } 
/* 202 */       c();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void d() {
/* 208 */     if (this.b != null) {
/* 209 */       double d1 = Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.PRESTIGE_DUST_DROP_RATE);
/* 210 */       double d2 = this.c.map.getMap().getPrestigeScore() * d1;
/*     */       
/* 212 */       String str = StringFormatter.commaSeparatedNumber(StrictMath.round(d2 * 1000.0D)) + " mP";
/* 213 */       if (d1 > 1.0D) {
/* 214 */         str = str + " [#808080](x" + StringFormatter.compactNumberWithPrecision(d1, 2) + ")[]";
/*     */       }
/* 216 */       this.b.setText(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addToolButton(ToolButton paramToolButton) {
/* 221 */     this.toolButtons.add(paramToolButton);
/* 222 */     updateButtonsLayout();
/*     */   }
/*     */   
/*     */   public void updateButtonsLayout() {
/* 226 */     this.d.clear();
/* 227 */     this.d.add().width(1.0F).growY().minHeight(24.0F).row();
/*     */     
/* 229 */     for (Array.ArrayIterator<ToolButton> arrayIterator = this.toolButtons.iterator(); arrayIterator.hasNext(); ) { ToolButton toolButton = arrayIterator.next();
/* 230 */       this.d.add((Actor)toolButton).size(144.0F, 104.0F).row(); }
/*     */ 
/*     */     
/* 233 */     this.d.row();
/* 234 */     this.d.add().width(1.0F).height(24.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 240 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */   
/*     */   public static class ToolButton
/*     */     extends TableButton {
/*     */     public static final float WIDTH = 144.0F;
/*     */     public static final float HEIGHT = 104.0F;
/*     */     public static final float ICON_SIZE = 64.0F;
/*     */     public static final float ICON_SIZE_ACTIVE = 80.0F;
/*     */     private Drawable k;
/*     */     
/*     */     public ToolButton(Drawable param1Drawable, Runnable param1Runnable1, Runnable param1Runnable2) {
/* 252 */       super(param1Runnable1, param1Runnable2);
/*     */       
/* 254 */       this.k = param1Drawable;
/*     */       
/* 256 */       setBackgroundDrawable((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorUi.toolButtonActive"));
/* 257 */       setActive(false);
/*     */     }
/*     */     
/*     */     public void setActive(boolean param1Boolean) {
/* 261 */       clearChildren();
/* 262 */       if (param1Boolean) {
/* 263 */         add((Actor)new Image(this.k)).size(80.0F);
/* 264 */         setContentColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P500);
/* 265 */         setBackgroundDrawable((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorUi.toolButtonActive")); return;
/*     */       } 
/* 267 */       add((Actor)new Image(this.k)).size(64.0F);
/* 268 */       setContentColors(new Color(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500, Color.BLACK);
/* 269 */       setBackgroundDrawable(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class PreparedTooltip
/*     */   {
/*     */     public String id;
/*     */     public Actor forActor;
/*     */     public CharSequence message;
/*     */     
/*     */     public PreparedTooltip() {}
/*     */     
/*     */     public PreparedTooltip(String param1String, Actor param1Actor, CharSequence param1CharSequence) {
/* 282 */       this.id = param1String;
/* 283 */       this.forActor = param1Actor;
/* 284 */       this.message = param1CharSequence;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\MapEditorUi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */