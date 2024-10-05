/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.PerspectiveCamera;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.PixmapIO;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Environment;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*     */ import com.badlogic.gdx.graphics.g3d.RenderableProvider;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.PointLight;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Node;
/*     */ import com.badlogic.gdx.graphics.glutils.FrameBuffer;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ScreenUtils;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.TrophyType;
/*     */ import com.prineside.tdi2.items.TrophyItem;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = TrophyManager.Serializer.class)
/*     */ public class TrophyManager extends Manager.ManagerAdapter {
/*  37 */   private static final TLog a = TLog.forClass(TrophyManager.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<TrophyManager> {
/*     */     public TrophyManager read() {
/*  41 */       return Game.i.trophyManager;
/*     */     } }
/*     */   
/*  44 */   private final TrophyConfig[] b = new TrophyConfig[TrophyType.values.length];
/*     */   
/*     */   public TrophyManager() {
/*  47 */     for (byte b1 = 0; b1 < TrophyType.values.length; b1++) {
/*  48 */       this.b[b1] = new TrophyConfig(this);
/*     */     }
/*     */ 
/*     */     
/*  52 */     JsonValue jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/trophies.json"));
/*  53 */     byte b2 = 0;
/*  54 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */       try {
/*  56 */         TrophyType trophyType = TrophyType.valueOf(jsonValue1.name);
/*     */         TrophyConfig trophyConfig;
/*  58 */         TrophyConfig.a(trophyConfig = getConfig(trophyType), false);
/*     */         
/*  60 */         Array array = new Array(GameValueManager.GameValueEffect.class);
/*     */         JsonValue jsonValue2;
/*  62 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = (jsonValue2 = jsonValue1.get("gameValues")).iterator(); jsonIterator1.hasNext(); ) {
/*  63 */           JsonValue jsonValue3; GameValueType gameValueType = GameValueType.valueOf((jsonValue3 = jsonIterator1.next()).name);
/*  64 */           array.add(new GameValueManager.GameValueEffect(gameValueType, jsonValue3.asDouble()));
/*     */         } 
/*  66 */         TrophyConfig.a(trophyConfig, trophyType, array);
/*  67 */         b2++;
/*  68 */       } catch (Exception exception) {
/*  69 */         a.e("failed to load game value config '" + jsonValue1.name + "'", new Object[] { exception });
/*     */       }  }
/*     */ 
/*     */     
/*  73 */     if (b2 != this.b.length) {
/*  74 */       throw new RuntimeException("Loaded only " + b2 + " out of " + this.b.length + " trophy configs");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHowToObtainHint(TrophyType paramTrophyType) {
/*  80 */     switch (null.a[paramTrophyType.ordinal()]) { case 1:
/*  81 */         return Game.i.localeManager.i18n.get("trophy_obtain_hint_SPECIAL_STORYLINE");
/*  82 */       case 2: return Game.i.localeManager.i18n.get("trophy_obtain_hint_SPECIAL_DEVELOPER");
/*  83 */       case 3: return Game.i.localeManager.i18n.get("trophy_obtain_hint_SPECIAL_MILLION");
/*  84 */       case 4: return Game.i.localeManager.i18n.get("trophy_obtain_hint_SPECIAL_MASTER"); }
/*     */ 
/*     */     
/*  87 */     Array<BasicLevel> array = Game.i.basicLevelManager.levelsOrdered;
/*  88 */     for (byte b = 0; b < array.size; b++) {
/*  89 */       BasicLevel basicLevel = (BasicLevel)array.get(b);
/*  90 */       for (byte b1 = 0; b1 < basicLevel.waveQuests.size; b1++) {
/*  91 */         BasicLevel.WaveQuest waveQuest = (BasicLevel.WaveQuest)basicLevel.waveQuests.get(b1);
/*  92 */         for (byte b2 = 0; b2 < waveQuest.prizes.size; b2++) {
/*     */           ItemStack itemStack; TrophyItem trophyItem;
/*  94 */           if ((itemStack = (ItemStack)waveQuest.prizes.get(b2)).getItem() instanceof TrophyItem && 
/*     */             
/*  96 */             (trophyItem = (TrophyItem)itemStack.getItem()).trophyType == paramTrophyType) {
/*  97 */             int i = waveQuest.waves;
/*  98 */             String str = basicLevel.name;
/*  99 */             return Game.i.localeManager.i18n.format("trophy_obtain_hint_beat_wave", new Object[] { Integer.valueOf(i), str });
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     return "I don't know how obtain it";
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
/*     */   public void setup() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TrophyConfig getConfig(TrophyType paramTrophyType) {
/* 128 */     return this.b[paramTrophyType.ordinal()];
/*     */   }
/*     */   
/*     */   public TrophyConfig[] getConfigs() {
/* 132 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPreviews(String paramString, int paramInt, float paramFloat) {
/* 139 */     FrameBuffer frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, paramInt, paramInt, true);
/*     */     
/*     */     PerspectiveCamera perspectiveCamera;
/* 142 */     (perspectiveCamera = new PerspectiveCamera(67.0F, paramInt, paramInt)).position.set(0.32F, 0.4F, 0.55F);
/* 143 */     perspectiveCamera.lookAt(0.0F, 0.0F, 0.0F);
/* 144 */     perspectiveCamera.near = 0.01F;
/* 145 */     perspectiveCamera.far = 300.0F;
/* 146 */     perspectiveCamera.update();
/*     */     
/*     */     Environment environment;
/* 149 */     (environment = new Environment()).set((Attribute)new ColorAttribute(ColorAttribute.AmbientLight, 0.6F, 0.6F, 0.6F, 1.0F));
/* 150 */     PointLight pointLight = (new PointLight()).set(1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 2.0F);
/* 151 */     environment.add(pointLight);
/*     */     
/*     */     Model model;
/* 154 */     if ((model = Game.i.assetManager.getSceneModelIfLoaded()) != null) {
/* 155 */       TrophyType[] arrayOfTrophyType; int i; byte b; for (i = (arrayOfTrophyType = TrophyType.values).length, b = 0; b < i; ) { TrophyType trophyType = arrayOfTrophyType[b];
/* 156 */         String str2 = paramString + trophyType.name() + ".png";
/*     */         
/* 158 */         String str1 = "t-" + trophyType.name();
/*     */         Node node;
/*     */         ModelInstance modelInstance;
/* 161 */         (node = (modelInstance = new ModelInstance(model, str1, true, true, true)).getNode(str1)).translation.set(0.0F, 0.0F, 0.0F);
/* 162 */         node.rotation.setFromAxis(Vector3.X, -90.0F);
/*     */ 
/*     */ 
/*     */         
/* 166 */         modelInstance.calculateTransforms();
/* 167 */         modelInstance.transform.setToTranslationAndScaling(new Vector3(0.0F, 0.0F, 0.0F), new Vector3(paramFloat, paramFloat, paramFloat));
/*     */         
/* 169 */         Game.i.renderingManager.startFBO(frameBuffer, "TrophyManagerPreview");
/*     */         
/* 171 */         Gdx.gl.glClearColor(Config.BACKGROUND_COLOR.r, Config.BACKGROUND_COLOR.g, Config.BACKGROUND_COLOR.b, 0.0F);
/* 172 */         Gdx.gl.glClear(16640);
/*     */         
/* 174 */         Game.i.renderingManager.modelBatch.begin((Camera)perspectiveCamera);
/* 175 */         Game.i.renderingManager.modelBatch.render((RenderableProvider)modelInstance, environment);
/* 176 */         Game.i.renderingManager.modelBatch.end();
/*     */         
/* 178 */         byte[] arrayOfByte = ScreenUtils.getFrameBufferPixels(0, 0, frameBuffer.getWidth(), frameBuffer.getHeight(), true);
/* 179 */         Pixmap pixmap = new Pixmap(frameBuffer.getWidth(), frameBuffer.getHeight(), Pixmap.Format.RGBA8888);
/* 180 */         BufferUtils.copy(arrayOfByte, 0, pixmap.getPixels(), arrayOfByte.length);
/* 181 */         PixmapIO.writePNG(Gdx.files.local(str2), pixmap);
/* 182 */         pixmap.dispose();
/*     */         
/* 184 */         Game.i.renderingManager.endFBO("TrophyManagerPreview");
/*     */         b++; }
/*     */     
/*     */     } 
/* 188 */     frameBuffer.dispose();
/*     */     
/* 190 */     a.i("trophies rendered", new Object[0]);
/*     */   }
/*     */   
/*     */   public Array<TrophyType> getReceivedTrophies() {
/* 194 */     Array<TrophyType> array = new Array(true, 1, TrophyType.class);
/* 195 */     DelayedRemovalArray<ItemStack> delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.TROPHY);
/* 196 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/*     */       ItemStack itemStack;
/* 198 */       TrophyItem trophyItem = (TrophyItem)(itemStack = (ItemStack)delayedRemovalArray.get(b)).getItem();
/* 199 */       array.add(trophyItem.trophyType);
/*     */     } 
/* 201 */     return array;
/*     */   } public void test() {
/*     */     TrophyConfig[] arrayOfTrophyConfig;
/*     */     int i;
/*     */     byte b;
/* 206 */     for (i = (arrayOfTrophyConfig = this.b).length, b = 0; b < i; b++) {
/* 207 */       TrophyConfig trophyConfig; (trophyConfig = arrayOfTrophyConfig[b]).getTitle();
/*     */     } 
/*     */   }
/*     */   
/*     */   public class TrophyConfig {
/*     */     public TrophyType type;
/*     */     public Array<GameValueManager.GameValueEffect> gameValues;
/*     */     private String a;
/*     */     private String b;
/*     */     private String c;
/*     */     private boolean d;
/*     */     
/*     */     public TrophyConfig(TrophyManager this$0) {}
/*     */     
/*     */     private void a(TrophyType param1TrophyType, Array<GameValueManager.GameValueEffect> param1Array) {
/* 222 */       this.type = param1TrophyType;
/* 223 */       this.gameValues = param1Array;
/* 224 */       this.a = "tr_title_" + param1TrophyType.name();
/* 225 */       this.b = "trophy-" + param1TrophyType.name() + "-white";
/* 226 */       this.c = "trophy-" + param1TrophyType.name();
/*     */       
/* 228 */       this.d = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isReceived() {
/* 236 */       if (!this.d) throw new IllegalStateException("Config is not setup");
/*     */       
/* 238 */       DelayedRemovalArray<ItemStack> delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.TROPHY);
/* 239 */       for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/*     */         ItemStack itemStack;
/* 241 */         if (((TrophyItem)(itemStack = (ItemStack)delayedRemovalArray.get(b)).getItem()).trophyType == this.type) {
/* 242 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 246 */       return false;
/*     */     }
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
/*     */     public String getTitle() {
/* 260 */       return Game.i.localeManager.i18n.get(this.a);
/*     */     }
/*     */     
/*     */     public TextureRegion getIconTexture() {
/* 264 */       return (TextureRegion)Game.i.assetManager.getTextureRegion(this.c);
/*     */     }
/*     */     
/*     */     public TextureRegion getWhiteTexture() {
/* 268 */       return (TextureRegion)Game.i.assetManager.getTextureRegion(this.b);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\TrophyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */