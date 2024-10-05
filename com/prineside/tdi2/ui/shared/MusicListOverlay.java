/*      */ package com.prineside.tdi2.ui.shared;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.IntSet;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.UserMap;
/*      */ import com.prineside.tdi2.ibxm.Module;
/*      */ import com.prineside.tdi2.managers.MusicManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.music.LiveMusicManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.screens.GameScreen;
/*      */ import com.prineside.tdi2.tiles.EqualizerTile;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.HorizontalSlider;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.QuadDrawable;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.HashMap;
/*      */ 
/*      */ public final class MusicListOverlay extends UiManager.UiComponent.Adapter {
/*   50 */   private static final TLog a = TLog.forClass(MusicListOverlay.class);
/*      */   public static MusicListOverlay i() {
/*   52 */     return (MusicListOverlay)Game.i.uiManager.getComponent(MusicListOverlay.class);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*   57 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 249, "MusicListOverlay main");
/*      */   
/*      */   public static final float LIST_ITEM_HEIGHT = 64.0F;
/*      */   
/*      */   private final Group c;
/*      */   
/*      */   private final ScrollPane d;
/*      */   
/*      */   private final Table e;
/*      */   
/*      */   private final Label f;
/*      */   
/*      */   private final PaddedImageButton g;
/*      */   
/*      */   private final Table h;
/*      */   
/*      */   private final Image i;
/*      */   
/*      */   private final HorizontalSlider j;
/*      */   
/*      */   private final LabelToggleButton k;
/*      */   private int l;
/*      */   private int m;
/*      */   private int n;
/*      */   private int o;
/*   82 */   private float p = 0.0F;
/*   83 */   private int q = 0;
/*      */   
/*   85 */   private byte r = 0;
/*   86 */   private Array<MusicItem> s = new Array(MusicItem.class);
/*      */ 
/*      */   
/*      */   private boolean t = false;
/*      */   
/*      */   private boolean u;
/*      */   
/*   93 */   private final IntArray v = new IntArray(true, 8);
/*      */ 
/*      */   
/*      */   public MusicListOverlay() {
/*      */     Group group;
/*   98 */     (group = new Group()).setTransform(false);
/*   99 */     group.setOrigin(320.0F, 477.0F);
/*  100 */     this.b.getTable().add((Actor)group).size(640.0F, 954.0F);
/*      */     
/*  102 */     this.c = new Group();
/*  103 */     this.c.setTransform(false);
/*  104 */     this.c.setOrigin(320.0F, 477.0F);
/*  105 */     this.c.setSize(640.0F, 954.0F);
/*  106 */     group.addActor((Actor)this.c);
/*      */ 
/*      */ 
/*      */     
/*      */     QuadActor quadActor3;
/*      */ 
/*      */ 
/*      */     
/*  114 */     (quadActor3 = new QuadActor(new Color(724249599), new float[] { 0.0F, 0.0F, 0.0F, 11.0F, 640.0F, 0.0F, 640.0F, 0.0F })).setPosition(0.0F, 943.0F);
/*  115 */     this.c.addActor((Actor)quadActor3);
/*      */     
/*      */     Image image5;
/*  118 */     (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(724249599));
/*  119 */     image5.setSize(640.0F, 932.0F);
/*  120 */     image5.setPosition(0.0F, 11.0F);
/*  121 */     this.c.addActor((Actor)image5);
/*      */     
/*  123 */     QuadActor quadActor2 = new QuadActor(new Color(724249599), new float[] { 0.0F, 0.0F, 0.0F, 11.0F, 640.0F, 11.0F, 640.0F, 11.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  129 */     this.c.addActor((Actor)quadActor2);
/*      */     
/*  131 */     this.e = new Table();
/*  132 */     this.e.setTouchable(Touchable.childrenOnly);
/*      */     
/*  134 */     this.d = new ScrollPane((Actor)this.e);
/*  135 */     UiUtils.enableMouseMoveScrollFocus(this.d);
/*  136 */     this.d.setTransform(true);
/*  137 */     this.d.setSize(760.0F, 930.0F);
/*  138 */     this.d.setPosition(0.0F, 13.0F);
/*  139 */     this.d.setTouchable(Touchable.enabled);
/*  140 */     this.c.addActor((Actor)this.d);
/*      */     
/*      */     Image image4;
/*  143 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(new Color(724249599));
/*  144 */     image4.setSize(640.0F, 16.0F);
/*  145 */     image4.setPosition(0.0F, 928.0F);
/*  146 */     image4.setTouchable(Touchable.disabled);
/*  147 */     this.c.addActor((Actor)image4);
/*      */ 
/*      */     
/*  150 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*  151 */     image4.setSize(640.0F, 16.0F);
/*  152 */     image4.setPosition(0.0F, 183.0F);
/*  153 */     image4.setTouchable(Touchable.disabled);
/*  154 */     this.c.addActor((Actor)image4);
/*      */ 
/*      */ 
/*      */     
/*      */     QuadActor quadActor1;
/*      */ 
/*      */ 
/*      */     
/*  162 */     (quadActor1 = new QuadActor(new Color(858993663), new float[] { 0.0F, 0.0F, 0.0F, 183.0F, 640.0F, 183.0F, 640.0F, 11.0F })).setTouchable(Touchable.enabled);
/*  163 */     this.c.addActor((Actor)quadActor1);
/*      */     
/*  165 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  166 */     this.f.setPosition(40.0F, 131.0F);
/*  167 */     this.f.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  168 */     this.f.setSize(100.0F, 20.0F);
/*  169 */     this.c.addActor((Actor)this.f);
/*      */     
/*  171 */     this.g = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-thumbs-up"), () -> {
/*      */           MusicItem musicItem;
/*      */           
/*      */           if ((musicItem = b()) != null) {
/*      */             boolean bool = !Game.i.musicManager.isMusicThumbsUp(musicItem.hash) ? true : false;
/*      */             Game.i.musicManager.voteThumbsUp(musicItem.hash, bool);
/*      */             h();
/*      */             musicItem.updateUi();
/*      */             try {
/*      */               Net.HttpRequest httpRequest;
/*      */               (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.VOTE_MUSIC_URL);
/*      */               HashMap<Object, Object> hashMap = new HashMap<>();
/*      */               long l = musicItem.hash & 0xFFFFFFFFL;
/*      */               hashMap.put("hash", l);
/*      */               hashMap.put("vote", bool ? "up" : "down");
/*      */               hashMap.put("playerid", Game.i.authManager.getPlayerId());
/*      */               if (Game.i.authManager.isSignedIn()) {
/*      */                 hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*      */               }
/*      */               httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */               String str2 = musicItem.getBase64();
/*      */               String str1 = musicItem.name;
/*      */               Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, l, str2, str1)
/*      */                   {
/*      */                     public void handleHttpResponse(Net.HttpResponse param1HttpResponse)
/*      */                     {
/*  197 */                       String str = param1HttpResponse.getResultAsString();
/*      */                       
/*      */                       JsonValue jsonValue;
/*      */                       
/*  201 */                       if ((jsonValue = (new JsonReader()).parse(str)).has("infoRequired")) {
/*      */                         
/*  203 */                         MusicListOverlay.a().i("server asks for music " + this.b, new Object[0]);
/*  204 */                         if (MusicListOverlay.f(this.a)) {
/*  205 */                           MusicListOverlay.a().i("already sending music, abort", new Object[0]);
/*      */                           
/*      */                           return;
/*      */                         } 
/*  209 */                         Threads.i().runOnMainThread(() -> {
/*      */                               if (Game.i.authManager.isSignedIn() && param1String1 != null) {
/*      */                                 MusicListOverlay.a().i("sending music to server", new Object[0]);
/*      */                                 
/*      */                                 MusicListOverlay.a(this.a, true);
/*      */                                 
/*      */                                 Net.HttpRequest httpRequest;
/*      */                                 
/*      */                                 (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.SUBMIT_MUSIC_URL);
/*      */                                 
/*      */                                 HashMap<Object, Object> hashMap;
/*      */                                 (hashMap = new HashMap<>()).put("hash", param1Long);
/*      */                                 hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*      */                                 hashMap.put("file", param1String1);
/*      */                                 hashMap.put("title", param1String2);
/*      */                                 httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */                                 Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*      */                                     {
/*      */                                       public void handleHttpResponse(Net.HttpResponse param2HttpResponse)
/*      */                                       {
/*  229 */                                         MusicListOverlay.a(this.a.a, false);
/*      */                                       }
/*      */ 
/*      */ 
/*      */                                       
/*      */                                       public void failed(Throwable param2Throwable) {
/*  235 */                                         MusicListOverlay.a(this.a.a, false);
/*      */                                       }
/*      */ 
/*      */                                       
/*      */                                       public void cancelled() {
/*  240 */                                         MusicListOverlay.a(this.a.a, false);
/*      */                                       }
/*      */                                     });
/*      */                               } 
/*      */                             });
/*      */                       } 
/*      */                     }
/*      */                     
/*      */                     public void failed(Throwable param1Throwable) {
/*  249 */                       MusicListOverlay.a().e("Failed", new Object[] { param1Throwable });
/*      */                     }
/*      */                     
/*      */                     public void cancelled() {}
/*      */                   });
/*      */               return;
/*  255 */             } catch (Exception exception) {}
/*      */           } 
/*      */         }MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P400, MaterialColor.LIGHT_GREEN.P600);
/*      */     
/*  259 */     this.g.setSize(96.0F, 96.0F);
/*  260 */     this.g.setIconSize(64.0F, 64.0F);
/*  261 */     this.g.setPosition(520.0F, 74.0F);
/*  262 */     this.g.setIconPosition(16.0F, 16.0F);
/*  263 */     this.c.addActor((Actor)this.g);
/*      */     
/*  265 */     this.h = new Table();
/*      */     ScrollPane scrollPane;
/*  267 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.h, Game.i.assetManager.getScrollPaneStyle(4.0F)));
/*  268 */     scrollPane.setScrollingDisabled(false, true);
/*  269 */     scrollPane.setSize(500.0F, 52.0F);
/*  270 */     scrollPane.setPosition(20.0F, 78.0F);
/*  271 */     this.c.addActor((Actor)scrollPane);
/*      */     
/*      */     Image image3;
/*  274 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setColor(new Color(858993663));
/*  275 */     image3.setSize(20.0F, 52.0F);
/*  276 */     image3.setPosition(19.0F, 78.0F);
/*  277 */     image3.setTouchable(Touchable.disabled);
/*  278 */     this.c.addActor((Actor)image3);
/*      */ 
/*      */     
/*  281 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-right"))).setColor(new Color(858993663));
/*  282 */     image3.setSize(20.0F, 52.0F);
/*  283 */     image3.setPosition(501.0F, 78.0F);
/*  284 */     image3.setTouchable(Touchable.disabled);
/*  285 */     this.c.addActor((Actor)image3);
/*      */     
/*      */     Table table;
/*  288 */     (table = new Table()).setSize(640.0F, 32.0F);
/*  289 */     table.setPosition(0.0F, 32.0F);
/*  290 */     this.c.addActor((Actor)table);
/*      */     
/*  292 */     this.i = new Image((Drawable)Game.i.assetManager.getDrawable("icon-speaker"));
/*  293 */     table.add((Actor)this.i).size(32.0F).padRight(8.0F).padLeft(40.0F);
/*      */     
/*  295 */     this.j = new HorizontalSlider(150.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME), 0.0D, 1.0D, paramDouble -> {
/*      */           MusicItem musicItem;
/*      */           double d = Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME);
/*      */           Game.i.settingsManager.setMusicVolume(paramDouble.doubleValue());
/*      */           if (d == 0.0D && paramDouble.doubleValue() > 0.0D) {
/*      */             if ((musicItem = b()) != null) {
/*      */               musicItem.play();
/*      */               this.o = musicItem.hash;
/*      */             } 
/*      */           } else if (d > 0.0D && musicItem.doubleValue() == 0.0D) {
/*      */             Game.i.musicManager.stopMusic();
/*      */           } 
/*      */           e();
/*      */           h();
/*      */           f();
/*      */         });
/*  311 */     this.j.setNotifyOnDrag(true);
/*  312 */     table.add((Actor)this.j).size(150.0F, 48.0F).padRight(16.0F);
/*      */     
/*  314 */     table.add().expand().fill();
/*      */     
/*  316 */     this
/*      */       
/*  318 */       .k = new LabelToggleButton("", (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.IGNORE_MAP_MUSIC) != 0.0D), 24, 32.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.IGNORE_MAP_MUSIC, paramBoolean.booleanValue() ? 1.0D : 0.0D));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  324 */     table.add((Actor)this.k).padRight(40.0F);
/*      */     
/*  326 */     EqualizerTile equalizerTile2 = (EqualizerTile)Game.i.tileManager.createTileFromJsonString("{\"type\":\"EQUALIZER\",\"y\":5,\"d\":{\"bi\":0,\"sd\":0.08,\"c\":0,\"co\":0,\"d\":2,\"cl\":\"ad1457FF\",\"ch\":\"6a1b9aFF\",\"bw\":7.45,\"bh\":2,\"rb\":false,\"pe\":true,\"f\":[[10.8,34.65],[32.7,55],[55,77.78],[77.78,98],[98,123.47],[123.47,146.83],[146.83,164.81],[164.81,185],[185,207.65],[207.65,233.08],[233.08,261.63],[261.63,277.18],[277.18,293.66],[293.66,329.63],[329.63,349.23],[349.23,369.99],[369.99,392],[392,415.3],[415.3,440],[440,466.16],[466.16,493.88],[493.88,523.25],[523.25,554.37],[554.37,587.33],[587.33,622.25],[622.25,659.26],[659.26,698.46],[698.46,739.99],[739.99,783.99],[783.99,830.61],[830.61,880],[880,932.33],[932.33,987.77],[987.77,1046.5],[1046.5,1108.73],[1108.73,1174.66],[1174.66,1244.51],[1244.51,1318.51],[1318.51,1396.91],[1396.91,1479.98],[1479.98,1567.98],[1567.98,1661.22],[1661.22,1760],[1760,1864.66],[1864.66,1975.53],[1975.53,2093],[2093,2217.46],[2217.46,2349.32],[2349.32,2489.02],[2489.02,2637.02],[2637.02,2793.83],[2793.83,2959.96],[2959.96,3135.96],[3135.96,3322.44],[3322.44,3520],[3520,3729.31],[3729.31,3951.07],[3951.07,4186.01],[4186.01,4434.92],[4434.92,4698.64],[4698.64,4978.03],[4978.03,5274.04],[5274.04,5587.65],[5587.65,5919.91],[5919.91,6271.93],[6271.93,6644.88],[6644.88,7040],[7040,7458.62],[7458.62,7902.13],[7902.13,8372.02],[8372.02,8869.84],[8869.84,9397.27],[9397.27,9956.06],[9956.06,10548],[10548,11175],[11175,11839],[11839,12543],[12543,13289],[13289,14080],[14080,14917],[14917,15804],[15804,16744],[16744,17739],[17739,18794],[18794,19912]],\"mve\":0.99,\"fmv\":0,\"bs\":0.2,\"sx\":0,\"sy\":0}}");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Image image2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  336 */     (image2 = new Image(this, equalizerTile2) { public void draw(Batch param1Batch, float param1Float) { validate(); if (Game.i.musicManager.getMainVolume() != 0.0F) this.j.drawFancy(param1Batch, Gdx.graphics.getDeltaTime(), getX(), getY(), 128.0F);  } }).setPosition(-128.0F, 0.0F);
/*  337 */     this.c.addActor((Actor)image2);
/*      */ 
/*      */     
/*  340 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-right"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  341 */     image2.setSize(32.0F, 954.0F);
/*  342 */     image2.setPosition(-32.0F, 0.0F);
/*  343 */     this.c.addActor((Actor)image2);
/*      */     
/*  345 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-right"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  346 */     image2.setSize(16.0F, 954.0F);
/*  347 */     image2.setPosition(-16.0F, 0.0F);
/*  348 */     this.c.addActor((Actor)image2);
/*      */     
/*  350 */     EqualizerTile equalizerTile1 = (EqualizerTile)Game.i.tileManager.createTileFromJsonString("{\"type\":\"EQUALIZER\",\"y\":5,\"d\":{\"bi\":0,\"sd\":0.08,\"c\":0,\"co\":0,\"d\":2,\"cl\":\"ad1457FF\",\"ch\":\"6a1b9aFF\",\"bw\":7.29,\"bh\":2,\"rb\":false,\"pe\":true,\"f\":[[10.8,34.65],[32.7,55],[55,77.78],[77.78,98],[98,123.47],[123.47,146.83],[146.83,164.81],[164.81,185],[185,207.65],[207.65,233.08],[233.08,261.63],[261.63,277.18],[277.18,293.66],[293.66,329.63],[329.63,349.23],[349.23,369.99],[369.99,392],[392,415.3],[415.3,440],[440,466.16],[466.16,493.88],[493.88,523.25],[523.25,554.37],[554.37,587.33],[587.33,622.25],[622.25,659.26],[659.26,698.46],[698.46,739.99],[739.99,783.99],[783.99,830.61],[830.61,880],[880,932.33],[932.33,987.77],[987.77,1046.5],[1046.5,1108.73],[1108.73,1174.66],[1174.66,1244.51],[1244.51,1318.51],[1318.51,1396.91],[1396.91,1479.98],[1479.98,1567.98],[1567.98,1661.22],[1661.22,1760],[1760,1864.66],[1864.66,1975.53],[1975.53,2093],[2093,2217.46],[2217.46,2349.32],[2349.32,2489.02],[2489.02,2637.02],[2637.02,2793.83],[2793.83,2959.96],[2959.96,3135.96],[3135.96,3322.44],[3322.44,3520],[3520,3729.31],[3729.31,3951.07],[3951.07,4186.01],[4186.01,4434.92],[4434.92,4698.64],[4698.64,4978.03],[4978.03,5274.04],[5274.04,5587.65],[5587.65,5919.91],[5919.91,6271.93],[6271.93,6644.88],[6644.88,7040],[7040,7458.62],[7458.62,7902.13],[7902.13,8372.02],[8372.02,8869.84],[8869.84,9397.27],[9397.27,9956.06],[9956.06,10548],[10548,11175],[11175,11839],[11839,12543],[12543,13289],[13289,14080],[14080,14917],[14917,15804],[15804,16744],[16744,17739],[17739,18794],[18794,19912]],\"mve\":0.99,\"fmv\":0,\"bs\":0.2,\"sx\":0,\"sy\":0}}");
/*  351 */     Image image6 = new Image(this, equalizerTile1)
/*      */       {
/*      */         public void draw(Batch param1Batch, float param1Float) {
/*  354 */           validate();
/*  355 */           if (Game.i.musicManager.getMainVolume() != 0.0F) {
/*  356 */             this.j.drawFancy(param1Batch, Gdx.graphics.getDeltaTime(), getX(), getY(), 128.0F);
/*      */           }
/*      */         }
/*      */       };
/*  360 */     equalizerTile1.channel = 1;
/*  361 */     equalizerTile1.direction = 3;
/*  362 */     image6.setPosition(640.0F, 11.0F);
/*  363 */     this.c.addActor((Actor)image6);
/*      */     
/*      */     Image image1;
/*  366 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  367 */     image1.setSize(32.0F, 932.0F);
/*  368 */     image1.setPosition(640.0F, 11.0F);
/*  369 */     this.c.addActor((Actor)image1);
/*      */     
/*  371 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  372 */     image1.setSize(16.0F, 932.0F);
/*  373 */     image1.setPosition(640.0F, 11.0F);
/*  374 */     this.c.addActor((Actor)image1);
/*      */     
/*      */     PaddedImageButton paddedImageButton;
/*  377 */     (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> hide(), MaterialColor.ORANGE.P500, MaterialColor.ORANGE.P400, MaterialColor.ORANGE.P600)).setIconSize(48.0F, 48.0F);
/*  378 */     paddedImageButton.setIconPosition(16.0F, 16.0F);
/*  379 */     paddedImageButton.setSize(64.0F, 64.0F);
/*  380 */     paddedImageButton.setIconPosition(16.0F, 16.0F);
/*  381 */     paddedImageButton.setPosition(592.0F, 892.0F);
/*  382 */     paddedImageButton.setName("music_list_overlay_close_button");
/*  383 */     this.c.addActor((Actor)paddedImageButton);
/*      */     
/*  385 */     this.b.getTable().setVisible(false);
/*      */   }
/*      */   
/*      */   private MusicItem b() {
/*  389 */     for (byte b = 0; b < this.s.size; b++) {
/*  390 */       if ((((MusicItem[])this.s.items)[b]).hash == this.o) {
/*  391 */         return ((MusicItem[])this.s.items)[b];
/*      */       }
/*      */     } 
/*      */     
/*  395 */     return null;
/*      */   }
/*      */   
/*      */   private int c() {
/*  399 */     if (Game.i.musicManager.getPlayingMusic() == null) {
/*  400 */       return -1;
/*      */     }
/*  402 */     return this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d() {
/*  411 */     Runnable runnable = () -> {
/*      */         if (this.r == 1) {
/*      */           a.e("another thread in progress", new Object[0]);
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */ 
/*      */         
/*      */         this.r = 1;
/*      */ 
/*      */         
/*      */         try {
/*      */           int i = 7;
/*      */ 
/*      */           
/*      */           Array array = Game.i.userMapManager.getUserMaps();
/*      */ 
/*      */           
/*      */           for (byte b = 0; b < array.size; b++) {
/*      */             UserMap userMap;
/*      */ 
/*      */             
/*      */             Module module;
/*      */ 
/*      */             
/*      */             if ((userMap = ((UserMap[])array.items)[b]).map.getMusicTile() != null && (module = userMap.map.getMusicTile().getModule()) != null) {
/*      */               int j = Game.i.musicManager.getMusicB64hash(userMap.map.getMusicTile().getTrackBase64());
/*      */ 
/*      */               
/*      */               i = (i = i * 31 + userMap.id.hashCode()) * 31 + j;
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/*      */           if (i != this.q) {
/*      */             this.q = i;
/*      */ 
/*      */             
/*      */             this.s.clear();
/*      */ 
/*      */             
/*      */             Module module;
/*      */ 
/*      */             
/*      */             if ((module = Game.i.assetManager.getMenuXmSoundTrack()) != null) {
/*      */               MusicItem musicItem;
/*      */ 
/*      */               
/*      */               (musicItem = new MusicItem((byte)0)).source = MusicManager.MusicSource.DEFAULT;
/*      */ 
/*      */               
/*      */               musicItem.name = module.songName;
/*      */ 
/*      */               
/*      */               this.s.add(musicItem);
/*      */             } 
/*      */ 
/*      */             
/*      */             IntSet intSet = new IntSet();
/*      */ 
/*      */             
/*      */             byte b1;
/*      */ 
/*      */             
/*      */             for (b1 = 0; b1 < Game.i.basicLevelManager.levelsOrdered.size; b1++) {
/*      */               Module module1;
/*      */               
/*      */               BasicLevel basicLevel;
/*      */               
/*      */               if ((basicLevel = ((BasicLevel[])Game.i.basicLevelManager.levelsOrdered.items)[b1]).getMap().getMusicTile() != null && (module1 = basicLevel.getMap().getMusicTile().getModule()) != null) {
/*      */                 int j = Game.i.musicManager.getMusicB64hash(basicLevel.getMap().getMusicTile().getTrackBase64());
/*      */                 
/*      */                 if (!intSet.contains(j)) {
/*      */                   intSet.add(j);
/*      */                   
/*      */                   MusicItem musicItem;
/*      */                   
/*      */                   (musicItem = new MusicItem((byte)0)).source = new MusicManager.MusicSource(MusicManager.MusicSourceType.BASIC_LEVEL, basicLevel.name);
/*      */                   
/*      */                   musicItem.hash = j;
/*      */                   
/*      */                   musicItem.name = (basicLevel.getMap().getMusicTile().getModule()).songName;
/*      */                   
/*      */                   this.s.add(musicItem);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/*      */             for (b1 = 0; b1 < array.size; b1++) {
/*      */               Module module1;
/*      */               
/*      */               UserMap userMap;
/*      */               
/*      */               if ((userMap = ((UserMap[])array.items)[b1]).map.getMusicTile() != null && (module1 = userMap.map.getMusicTile().getModule()) != null) {
/*      */                 int j = Game.i.musicManager.getMusicB64hash(userMap.map.getMusicTile().getTrackBase64());
/*      */                 
/*      */                 if (!intSet.contains(j)) {
/*      */                   intSet.add(j);
/*      */                   
/*      */                   MusicItem musicItem;
/*      */                   
/*      */                   (musicItem = new MusicItem((byte)0)).source = new MusicManager.MusicSource(MusicManager.MusicSourceType.USER_MAP, userMap.id);
/*      */                   
/*      */                   musicItem.hash = j;
/*      */                   
/*      */                   musicItem.name = (userMap.map.getMusicTile().getModule()).songName;
/*      */                   
/*      */                   this.s.add(musicItem);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*      */           this.r = 2;
/*      */           
/*      */           Threads.i().postRunnable(this::j);
/*      */           
/*      */           return;
/*  530 */         } catch (Exception exception) {
/*      */           a.e("failed to update music list", new Object[] { exception });
/*      */           
/*      */           this.r = 3;
/*      */           Threads.i().postRunnable(this::j);
/*      */           return;
/*      */         } 
/*      */       };
/*  538 */     (runnable = new Thread(runnable, "MusicListOverlay update")).start();
/*      */   }
/*      */   
/*      */   private void e() {
/*  542 */     if (this.r == 2) {
/*  543 */       for (byte b = 0; b < this.s.size; b++)
/*  544 */         ((MusicItem[])this.s.items)[b].updateUi(); 
/*      */       return;
/*      */     } 
/*  547 */     a.e("music list is not prepared yet", new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   private void f() {
/*  552 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME) == 0.0D) {
/*  553 */       this.i.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-speaker-crossed"));
/*      */     } else {
/*  555 */       this.i.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-speaker"));
/*      */     } 
/*  557 */     this.j.setValue(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME), false);
/*      */   }
/*      */   
/*      */   private void g() {
/*  561 */     while (this.v.size > 3)
/*  562 */       this.v.removeIndex(0); 
/*      */     int i;
/*  564 */     if (this.v.size == 3 && (
/*      */       
/*  566 */       i = this.v.get(0) * 7151 + this.v.get(1) * 5717 + this.v.get(2)) == 217451) {
/*  567 */       Game.i.screenManager.startNewBasicLevel(Game.i.basicLevelManager.getLevel("music_spectrum"), null);
/*      */     }
/*      */   }
/*      */   
/*      */   private void h() {
/*      */     Module module;
/*  573 */     if ((module = Game.i.musicManager.getPlayingMusic()) != null) {
/*  574 */       this.f.setText(module.songName);
/*      */     } else {
/*  576 */       this.f.setText("");
/*      */     } 
/*      */     LiveMusicManager liveMusicManager;
/*  579 */     if (Game.i.musicManager instanceof LiveMusicManager && module != null && 
/*      */ 
/*      */       
/*  582 */       (liveMusicManager = (LiveMusicManager)Game.i.musicManager).ibxm != null) {
/*  583 */       int i = liveMusicManager.ibxm.getSequencePos();
/*  584 */       int j = module.sequenceLength;
/*  585 */       int k = module.restartPos;
/*      */       
/*  587 */       if (this.m != i || this.l != j || this.n != k) {
/*  588 */         this.m = i;
/*  589 */         this.l = j;
/*  590 */         this.n = k;
/*      */         
/*  592 */         this.h.clear();
/*  593 */         this.h.add().height(1.0F).width(20.0F);
/*  594 */         for (byte b = 0; b < j; b++) {
/*      */           Group group;
/*  596 */           (group = new Group()).setTransform(false);
/*      */           
/*  598 */           group.setTouchable(Touchable.enabled);
/*      */           
/*  600 */           byte b1 = b;
/*  601 */           group.addListener((EventListener)new ClickListener(this, liveMusicManager, b1)
/*      */               {
/*      */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*      */                   try {
/*  605 */                     this.a.ibxm.lastSeqPos = 0;
/*  606 */                     this.a.ibxm.setSequencePosApplyEffects(this.b);
/*  607 */                     MusicListOverlay.a(this.c).add(this.b);
/*  608 */                     MusicListOverlay.b(this.c);
/*  609 */                     MusicListOverlay.c(this.c); return;
/*  610 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  }
/*      */               });
/*  614 */           this.h.add((Actor)group).size(32.0F, 32.0F).padRight(4.0F);
/*      */           
/*  616 */           Image image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  617 */           if (b == i) {
/*  618 */             image.setSize(32.0F, 32.0F);
/*  619 */             image.setColor(MaterialColor.LIGHT_GREEN.P500);
/*      */           } else {
/*  621 */             image.setSize(32.0F, 20.0F);
/*  622 */             image.setPosition(0.0F, 6.0F);
/*  623 */             image.setColor(MaterialColor.LIGHT_GREEN.P800);
/*      */           } 
/*  625 */           group.addActor((Actor)image);
/*      */           
/*  627 */           if (k == b) {
/*      */             
/*  629 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right-hollow"))).setSize(16.0F, 16.0F);
/*  630 */             image.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  631 */             image.setPosition(8.0F, 8.0F);
/*  632 */             group.addActor((Actor)image);
/*      */           } else {
/*      */             Label label;
/*  635 */             (label = new Label(String.valueOf(b), Game.i.assetManager.getLabelStyle(21))).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  636 */             label.setSize(32.0F, 20.0F);
/*  637 */             label.setPosition(0.0F, 6.0F);
/*  638 */             label.setAlignment(1);
/*  639 */             group.addActor((Actor)label);
/*      */           } 
/*      */         } 
/*  642 */         this.h.add().height(1.0F).width(20.0F);
/*  643 */         this.h.add().height(1.0F).expandX().fillX();
/*      */       } 
/*      */     } 
/*      */     
/*      */     MusicItem musicItem;
/*      */     
/*  649 */     if ((musicItem = b()) != null && module != null) {
/*  650 */       this.g.setVisible(true);
/*  651 */       if (Game.i.musicManager.isMusicThumbsUp(musicItem.hash)) {
/*  652 */         this.g.setColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P400, MaterialColor.LIGHT_GREEN.P600); return;
/*      */       } 
/*  654 */       this.g.setColors(MaterialColor.GREY.P700, MaterialColor.GREY.P500, MaterialColor.GREY.P800);
/*      */       return;
/*      */     } 
/*  657 */     this.g.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void show() {
/*  662 */     long l = Game.getRealTickCount();
/*  663 */     this.j.setVisible(false);
/*  664 */     this.k.setText(Game.i.localeManager.i18n.get("settings_ignore_map_music"));
/*      */     
/*  666 */     this.e.clear();
/*      */     
/*  668 */     if (this.r == 2) {
/*  669 */       Threads.i().postRunnable(this::j);
/*  670 */     } else if (this.r != 1) {
/*  671 */       d();
/*      */     } 
/*      */     
/*  674 */     if ((Game.i.musicManager.getCurrentlyPlayingMenuThemeSource()).type != MusicManager.MusicSourceType.DEFAULT) {
/*  675 */       for (byte b = 0; b < this.s.size; b++) {
/*  676 */         if ((((MusicItem[])this.s.items)[b]).source.equals(Game.i.musicManager.getCurrentlyPlayingMenuThemeSource())) {
/*  677 */           this.o = (((MusicItem[])this.s.items)[b]).hash;
/*      */         }
/*      */       } 
/*      */     } else {
/*  681 */       this.o = 0;
/*      */     } 
/*      */     
/*      */     Image image;
/*  685 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"))).setOrigin(32.0F, 32.0F);
/*  686 */     image.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F)));
/*  687 */     this.e.add((Actor)image).size(64.0F).padRight(120.0F).row();
/*      */     
/*  689 */     a(true);
/*      */     
/*  691 */     Game.i.uiManager.stage.setScrollFocus((Actor)this.d);
/*      */     
/*  693 */     if (Game.i.debugManager != null) Game.i.debugManager.registerFrameJob("MusicListOverlay-show", Game.getRealTickCount() - l);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void j() {
/*  701 */     if (!this.u)
/*      */       return; 
/*  703 */     long l = Game.getRealTickCount();
/*      */     
/*  705 */     this.e.clear();
/*  706 */     this.e.add().width(1.0F).height(32.0F).row();
/*      */     
/*  708 */     Table table = new Table();
/*  709 */     this.e.add((Actor)table).width(760.0F).row();
/*      */     
/*      */     Group group;
/*  712 */     (group = new Group()).setTransform(false);
/*  713 */     table.add((Actor)group).size(760.0F, 46.0F).row();
/*      */ 
/*      */     
/*      */     Label label;
/*      */     
/*  718 */     (label = new Label(Game.i.localeManager.i18n.get("title"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  719 */     label.setSize(100.0F, 46.0F);
/*  720 */     label.setPosition(40.0F, 0.0F);
/*  721 */     group.addActor((Actor)label);
/*      */ 
/*      */     
/*  724 */     (label = new Label(Game.i.localeManager.i18n.get("level"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  725 */     label.setAlignment(16);
/*  726 */     label.setSize(100.0F, 46.0F);
/*  727 */     label.setPosition(320.0F, 0.0F);
/*  728 */     group.addActor((Actor)label);
/*      */ 
/*      */     
/*  731 */     (label = new Label(Game.i.localeManager.i18n.get("music_list_header_menu_theme"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  732 */     label.setSize(100.0F, 46.0F);
/*  733 */     label.setPosition(460.0F, 0.0F);
/*  734 */     group.addActor((Actor)label);
/*      */     
/*  736 */     for (byte b = 0; b < this.s.size; b++) {
/*      */       MusicItem musicItem;
/*      */       
/*  739 */       if ((musicItem = ((MusicItem[])this.s.items)[b]).container == null) {
/*      */         Group group1;
/*  741 */         (group1 = new Group()).setTransform(false);
/*  742 */         table.add((Actor)group1).size(760.0F, 64.0F).padBottom(4.0F).row();
/*      */         
/*      */         Image image;
/*  745 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(623191551));
/*  746 */         image.setSize(640.0F, 64.0F);
/*  747 */         group1.addActor((Actor)image);
/*      */         
/*  749 */         musicItem.container = group1;
/*      */       } else {
/*  751 */         table.add((Actor)musicItem.container).size(760.0F, 64.0F).padBottom(4.0F).row();
/*      */       } 
/*      */     } 
/*      */     
/*  755 */     this.e.add().width(1.0F).height(185.0F).row();
/*      */     
/*  757 */     this.j.setVisible(true);
/*      */     
/*  759 */     h();
/*  760 */     e();
/*  761 */     f();
/*      */     
/*  763 */     if (Game.i.debugManager != null) Game.i.debugManager.registerFrameJob("MusicListOverlay-rebuildMusicListUI", Game.getRealTickCount() - l); 
/*      */   }
/*      */   
/*      */   public final boolean isVisible() {
/*  767 */     return this.u;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void hide() {
/*  772 */     if (this.u) {
/*  773 */       a(false);
/*      */       
/*  775 */       if (Game.i.screenManager.getCurrentScreen() instanceof GameScreen) {
/*      */         try {
/*      */           GameScreen gameScreen;
/*  778 */           (gameScreen = (GameScreen)Game.i.screenManager.getCurrentScreen()).S._sound.updateMusicPlayback(); return;
/*  779 */         } catch (Exception exception) {}
/*      */       }
/*      */ 
/*      */       
/*  783 */       Game.i.musicManager.continuePlayingMenuMusicTrack();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(boolean paramBoolean) {
/*  789 */     if (paramBoolean) {
/*  790 */       DarkOverlay.i().addCallerOverlayLayer("MusicListOverlay", this.b.zIndex - 1, () -> {
/*      */             hide();
/*      */             return true;
/*      */           });
/*  794 */       UiUtils.bouncyShowOverlay(null, (Actor)this.b.getTable(), this.c);
/*      */     } else {
/*  796 */       DarkOverlay.i().removeCaller("MusicListOverlay");
/*  797 */       UiUtils.bouncyHideOverlay(null, (Actor)this.b.getTable(), this.c);
/*      */     } 
/*      */     
/*  800 */     this.u = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void postRender(float paramFloat) {
/*  805 */     if (this.u) {
/*      */       
/*  807 */       this.p += paramFloat;
/*  808 */       if (this.p > 0.33F) {
/*  809 */         this.p = 0.0F;
/*  810 */         h();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private class MusicItem
/*      */   {
/*      */     public static final int AMPLITUDES_PREVIEW_WIDTH = 460;
/*      */ 
/*      */     
/*      */     public int hash;
/*      */ 
/*      */     
/*      */     public MusicManager.MusicSource source;
/*      */ 
/*      */     
/*      */     public String name;
/*      */ 
/*      */     
/*      */     public Group container;
/*      */ 
/*      */     
/*      */     public Label nameLabel;
/*      */ 
/*      */     
/*      */     public Label authorLabel;
/*      */ 
/*      */     
/*      */     public ComplexButton playButton;
/*      */ 
/*      */     
/*      */     public PaddedImageButton menuThemeButton;
/*      */ 
/*      */     
/*      */     public Image thumbsUpIcon;
/*      */ 
/*      */     
/*      */     public Group repeatsGroupScrollDependable;
/*      */ 
/*      */     
/*      */     public Label repeatsLabel;
/*      */ 
/*      */     
/*      */     public PaddedImageButton lessRepeatsButton;
/*      */     
/*      */     public PaddedImageButton moreRepeatsButton;
/*      */ 
/*      */     
/*      */     private MusicItem(MusicListOverlay this$0) {}
/*      */ 
/*      */     
/*      */     public String getLevelName() {
/*  864 */       if (this.source.type == MusicManager.MusicSourceType.BASIC_LEVEL) return this.source.id; 
/*  865 */       if (this.source.type == MusicManager.MusicSourceType.USER_MAP) return (Game.i.userMapManager.getUserMap(this.source.id)).name;
/*      */       
/*  867 */       return "";
/*      */     }
/*      */     
/*      */     public void play() {
/*      */       try {
/*  872 */         Game.i.musicManager.playMusic(getModule());
/*  873 */         Game.i.musicManager.setVolumeToStartNewTrack(); return;
/*  874 */       } catch (Exception exception) {
/*  875 */         MusicListOverlay.a().e("failed to play " + this.source, new Object[] { exception });
/*      */         return;
/*      */       } 
/*      */     }
/*      */     public String getBase64() {
/*  880 */       return this.source.getBase64();
/*      */     }
/*      */     
/*      */     public Module getModule() {
/*      */       Module module;
/*  885 */       if ((module = this.source.getModule()) == null) {
/*  886 */         module = Game.i.assetManager.getMenuXmSoundTrack();
/*      */       }
/*  888 */       return module;
/*      */     }
/*      */     
/*      */     public boolean isAvailable() {
/*  892 */       if (this.source.type == MusicManager.MusicSourceType.BASIC_LEVEL) {
/*  893 */         return Game.i.basicLevelManager.isOpened(Game.i.basicLevelManager.getLevel(this.source.id));
/*      */       }
/*  895 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void toggleAsMenuTheme() {
/*  900 */       if (Game.i.musicManager.isMenuMusicSourceEnabled(this.source)) {
/*  901 */         Game.i.musicManager.removeMenuMusicSource(this.source); return;
/*      */       } 
/*  903 */       Game.i.musicManager.addMenuMusicSource(this.source);
/*      */     }
/*      */ 
/*      */     
/*      */     public void updateUi() {
/*  908 */       boolean bool = isAvailable();
/*      */       
/*  910 */       if (this.thumbsUpIcon == null) {
/*      */         
/*  912 */         Module module = this.source.getModule();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  962 */         this.thumbsUpIcon = new Image((Drawable)Game.i.assetManager.getDrawable("icon-thumbs-up"));
/*  963 */         this.thumbsUpIcon.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  964 */         this.thumbsUpIcon.setSize(24.0F, 24.0F);
/*  965 */         this.thumbsUpIcon.setPosition(6.0F, 20.0F);
/*  966 */         this.container.addActor((Actor)this.thumbsUpIcon);
/*      */         
/*      */         Label label;
/*  969 */         (label = new Label(getLevelName(), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  970 */         label.setSize(100.0F, 64.0F);
/*  971 */         label.setAlignment(16);
/*  972 */         label.setPosition(320.0F, 0.0F);
/*  973 */         this.container.addActor((Actor)label);
/*      */         
/*  975 */         this.nameLabel = new Label(this.name, Game.i.assetManager.getLabelStyle(24));
/*  976 */         this.nameLabel.setSize(100.0F, 48.0F);
/*  977 */         this.nameLabel.setPosition(40.0F, 16.0F);
/*  978 */         this.container.addActor((Actor)this.nameLabel);
/*      */         
/*  980 */         Array array = module.getInfoFromInstrumentNames();
/*  981 */         StringBuilder stringBuilder = new StringBuilder();
/*  982 */         for (byte b = 0; b < array.size; b++) {
/*      */           Module.TrackInfoEntry trackInfoEntry;
/*  984 */           if ((trackInfoEntry = (Module.TrackInfoEntry)array.get(b)).type == Module.TrackInfoEntry.EntryType.AUTHOR) {
/*  985 */             if (stringBuilder.length() != 0) {
/*  986 */               stringBuilder.append(", ");
/*      */             }
/*  988 */             stringBuilder.append(trackInfoEntry.value);
/*      */           } 
/*      */         } 
/*      */         
/*  992 */         this.authorLabel = new Label(stringBuilder.toString(), Game.i.assetManager.getLabelStyle(18));
/*  993 */         this.authorLabel.setSize(100.0F, 14.0F);
/*  994 */         this.authorLabel.setPosition(40.0F, 10.0F);
/*  995 */         this.authorLabel.setColor(1.0F, 1.0F, 1.0F, 0.4F);
/*  996 */         this.container.addActor((Actor)this.authorLabel);
/*      */         
/*  998 */         this.menuThemeButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("settings-toggle-on"), () -> { toggleAsMenuTheme(); MusicListOverlay.e(this.a); }Color.WHITE, Color.WHITE, Color.WHITE);
/*      */ 
/*      */ 
/*      */         
/* 1002 */         this.menuThemeButton.setSize(64.0F, 64.0F);
/* 1003 */         this.menuThemeButton.setPosition(460.0F, 0.0F);
/* 1004 */         this.menuThemeButton.setIconSize(64.0F, 32.0F);
/* 1005 */         this.menuThemeButton.setIconPosition(0.0F, 14.0F);
/* 1006 */         this.container.addActor((Actor)this.menuThemeButton);
/*      */         
/* 1008 */         this.playButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */               play();
/*      */               
/*      */               MusicListOverlay.a(this.a, this.hash);
/*      */               MusicListOverlay.e(this.a);
/*      */               MusicListOverlay.c(this.a);
/*      */             });
/* 1015 */         this.playButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 8.0F, 64.0F, 100.0F, 64.0F, 100.0F, 0.0F })), 0.0F, 0.0F, 100.0F, 64.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1021 */         this.playButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"), 36.0F, 16.0F, 32.0F, 32.0F);
/* 1022 */         this.playButton.setPosition(540.0F, 0.0F);
/* 1023 */         this.container.addActor((Actor)this.playButton);
/*      */         
/* 1025 */         this.repeatsGroupScrollDependable = new Group();
/* 1026 */         this.repeatsGroupScrollDependable.setTransform(false);
/* 1027 */         this.repeatsGroupScrollDependable.setSize(120.0F, 52.0F);
/* 1028 */         this.repeatsGroupScrollDependable.setPosition(640.0F, 0.0F);
/* 1029 */         this.container.addActor((Actor)this.repeatsGroupScrollDependable);
/*      */         
/* 1031 */         this.repeatsLabel = new Label("x1", Game.i.assetManager.getLabelStyle(24));
/* 1032 */         this.repeatsLabel.setSize(120.0F, 52.0F);
/* 1033 */         this.repeatsLabel.setAlignment(1);
/* 1034 */         this.repeatsLabel.setPosition(0.0F, 0.0F);
/* 1035 */         this.repeatsGroupScrollDependable.addActor((Actor)this.repeatsLabel);
/* 1036 */         this.repeatsGroupScrollDependable.setVisible(false);
/*      */         
/* 1038 */         this.lessRepeatsButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"), () -> { Array array = Game.i.musicManager.getMenuThemeSources(); for (byte b = 0; b < array.size; b++) { if (((MusicManager.MusicSource[])array.items)[b].sameAs(this.source)) { if ((((MusicManager.MusicSource[])array.items)[b]).repeats > 1) { if ((((MusicManager.MusicSource[])array.items)[b]).repeats > 4) { (((MusicManager.MusicSource[])array.items)[b]).repeats = 4; } else if ((((MusicManager.MusicSource[])array.items)[b]).repeats > 2) { (((MusicManager.MusicSource[])array.items)[b]).repeats = 2; } else { (((MusicManager.MusicSource[])array.items)[b]).repeats = 1; }  SettingsPrefs.i().requireSave(); updateUi(); }  return; }  }  }MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P200, MaterialColor.LIGHT_BLUE.P500);
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
/* 1057 */         this.lessRepeatsButton.setPosition(0.0F, 0.0F);
/* 1058 */         this.lessRepeatsButton.setSize(60.0F, 52.0F);
/* 1059 */         this.lessRepeatsButton.setIconPosition(18.0F, 14.0F);
/* 1060 */         this.lessRepeatsButton.setIconSize(24.0F, 24.0F);
/* 1061 */         this.repeatsGroupScrollDependable.addActor((Actor)this.lessRepeatsButton);
/*      */         
/* 1063 */         this.moreRepeatsButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"), () -> { Array array = Game.i.musicManager.getMenuThemeSources(); for (byte b = 0; b < array.size; b++) { if (((MusicManager.MusicSource[])array.items)[b].sameAs(this.source)) { if ((((MusicManager.MusicSource[])array.items)[b]).repeats < 8) { if ((((MusicManager.MusicSource[])array.items)[b]).repeats < 2) { (((MusicManager.MusicSource[])array.items)[b]).repeats = 2; } else if ((((MusicManager.MusicSource[])array.items)[b]).repeats < 4) { (((MusicManager.MusicSource[])array.items)[b]).repeats = 4; } else { (((MusicManager.MusicSource[])array.items)[b]).repeats = 8; }  SettingsPrefs.i().requireSave(); updateUi(); }  return; }  }  }MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P200, MaterialColor.LIGHT_BLUE.P500);
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
/* 1082 */         this.moreRepeatsButton.setPosition(60.0F, 0.0F);
/* 1083 */         this.moreRepeatsButton.setSize(60.0F, 52.0F);
/* 1084 */         this.moreRepeatsButton.setIconPosition(18.0F, 14.0F);
/* 1085 */         this.moreRepeatsButton.setIconSize(24.0F, 24.0F);
/* 1086 */         this.repeatsGroupScrollDependable.addActor((Actor)this.moreRepeatsButton);
/*      */       } 
/*      */ 
/*      */       
/* 1090 */       this.thumbsUpIcon.setVisible(Game.i.musicManager.isMusicThumbsUp(this.hash));
/* 1091 */       if (MusicListOverlay.d(this.a) == this.hash) {
/* 1092 */         this.nameLabel.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 1093 */         this.playButton.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-pause"));
/* 1094 */         this.playButton.setEnabled(true);
/*      */       } else {
/* 1096 */         this.playButton.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"));
/*      */         
/* 1098 */         if (bool) {
/* 1099 */           this.playButton.setEnabled(true);
/* 1100 */           this.nameLabel.setColor(Color.WHITE);
/*      */         } else {
/* 1102 */           this.playButton.setEnabled(false);
/* 1103 */           this.nameLabel.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */         } 
/*      */       } 
/*      */       
/* 1107 */       this.menuThemeButton.setVisible(bool);
/*      */       
/* 1109 */       if (Game.i.musicManager.isMenuMusicSourceEnabled(this.source)) {
/* 1110 */         this.menuThemeButton.setIcon((Drawable)Game.i.assetManager.getDrawable("settings-toggle-on"));
/*      */         
/* 1112 */         int i = Game.i.musicManager.getMenuMusicSourceRepeatCount(this.source);
/* 1113 */         this.repeatsLabel.setText("x" + i);
/*      */         
/* 1115 */         this.lessRepeatsButton.setVisible((i > 1));
/* 1116 */         this.moreRepeatsButton.setVisible((i < 8));
/* 1117 */         this.repeatsLabel.setVisible(true); return;
/*      */       } 
/* 1119 */       this.menuThemeButton.setIcon((Drawable)Game.i.assetManager.getDrawable("settings-toggle-off"));
/* 1120 */       this.moreRepeatsButton.setVisible(false);
/* 1121 */       this.lessRepeatsButton.setVisible(false);
/* 1122 */       this.repeatsLabel.setVisible(false);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\MusicListOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */