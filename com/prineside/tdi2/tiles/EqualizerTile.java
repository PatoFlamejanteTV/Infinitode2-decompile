/*      */ package com.prineside.tdi2.tiles;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Pools;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.enums.ItemSortingType;
/*      */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.managers.AssetManager;
/*      */ import com.prineside.tdi2.managers.MusicManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.ui.Widget;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*      */ import com.prineside.tdi2.ui.actors.RectButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*      */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Arrays;
/*      */ import java.util.Locale;
/*      */ 
/*      */ @REGS
/*      */ public class EqualizerTile extends Tile {
/*   55 */   private static final TLog c = TLog.forClass(EqualizerTile.class);
/*      */   
/*      */   public static final int CHANNEL_LEFT = 0;
/*      */   
/*      */   public static final int CHANNEL_RIGHT = 1;
/*      */   
/*      */   public static final int CHANNEL_BOTH = 2;
/*      */   public static final int DIRECTION_TOP = 0;
/*      */   public static final int DIRECTION_BOTTOM = 1;
/*      */   public static final int DIRECTION_LEFT = 2;
/*      */   public static final int DIRECTION_RIGHT = 3;
/*      */   public static final int INTERPOLATION_LINEAR = 0;
/*      */   public static final int INTERPOLATION_POW2 = 1;
/*      */   public static final int INTERPOLATION_POW3 = 2;
/*      */   public static final int INTERPOLATION_EXP5 = 3;
/*      */   public static final int INTERPOLATION_EXP10 = 4;
/*      */   @NAGS
/*   72 */   private final DelayedRemovalArray<Particle> d = new DelayedRemovalArray(true, 1, Particle.class); @NAGS
/*      */   public boolean drawAlways;
/*      */   @NAGS
/*   75 */   public int barInterpolation = 1; @NAGS
/*   76 */   public float spectrumDropoff = 0.15F; @NAGS
/*   77 */   public int channel = 2; @NAGS
/*   78 */   public float cutout = 0.02F; @NAGS
/*   79 */   public int direction = 0; @NAGS
/*   80 */   public Color colorLow = MaterialColor.ORANGE.P500.cpy(); @NAGS
/*   81 */   public Color colorHigh = MaterialColor.LIGHT_GREEN.P500.cpy(); @NAGS
/*   82 */   public float barsWidth = 1.0F; @NAGS
/*   83 */   public float barsHeight = 2.0F; @NAGS
/*      */   public boolean revertBars; @NAGS
/*      */   public boolean particlesEnabled = true;
/*      */   @NAGS
/*   87 */   public Array<MusicManager.FrequencyRange> spectrumFrequencies = new Array(true, 1, MusicManager.FrequencyRange.class);
/*      */   
/*      */   @NAGS
/*      */   public float maxValueEasing;
/*      */   
/*      */   @NAGS
/*      */   public float fixedMaxValue;
/*      */   
/*      */   @NAGS
/*      */   public float barSpacing;
/*      */   
/*      */   @NAGS
/*      */   public float shiftX;
/*      */   
/*      */   @NAGS
/*      */   public float shiftY;
/*      */   
/*      */   @NAGS
/*      */   private float[] e;
/*      */   
/*      */   @NAGS
/*      */   private float[] f;
/*      */   
/*      */   @NAGS
/*      */   private float[] g;
/*      */   @NAGS
/*      */   private float[] h;
/*      */   @NAGS
/*      */   private float[] i;
/*      */   @NAGS
/*      */   private Particle[] j;
/*      */   @NAGS
/*      */   public MusicManager.SpectrumConfig spectrumConfig;
/*  120 */   private static final Color k = new Color();
/*      */ 
/*      */   
/*      */   public void write(Kryo paramKryo, Output paramOutput) {
/*  124 */     super.write(paramKryo, paramOutput);
/*  125 */     paramOutput.writeVarInt(this.barInterpolation, true);
/*  126 */     paramOutput.writeFloat(this.spectrumDropoff);
/*  127 */     paramOutput.writeVarInt(this.channel, true);
/*  128 */     paramOutput.writeFloat(this.cutout);
/*  129 */     paramOutput.writeVarInt(this.direction, true);
/*  130 */     paramKryo.writeObject(paramOutput, this.colorLow);
/*  131 */     paramKryo.writeObject(paramOutput, this.colorHigh);
/*  132 */     paramOutput.writeFloat(this.barsWidth);
/*  133 */     paramOutput.writeFloat(this.barsHeight);
/*  134 */     paramOutput.writeBoolean(this.revertBars);
/*  135 */     paramOutput.writeBoolean(this.particlesEnabled);
/*      */     
/*  137 */     paramKryo.writeObject(paramOutput, this.spectrumFrequencies);
/*  138 */     paramOutput.writeFloat(this.maxValueEasing);
/*  139 */     paramOutput.writeFloat(this.fixedMaxValue);
/*  140 */     paramOutput.writeFloat(this.barSpacing);
/*  141 */     paramOutput.writeFloat(this.shiftX);
/*  142 */     paramOutput.writeFloat(this.shiftY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(Kryo paramKryo, Input paramInput) {
/*  149 */     super.read(paramKryo, paramInput);
/*  150 */     this.barInterpolation = paramInput.readVarInt(true);
/*  151 */     this.spectrumDropoff = paramInput.readFloat();
/*  152 */     this.channel = paramInput.readVarInt(true);
/*  153 */     this.cutout = paramInput.readFloat();
/*  154 */     this.direction = paramInput.readVarInt(true);
/*  155 */     this.colorLow = (Color)paramKryo.readObject(paramInput, Color.class);
/*  156 */     this.colorHigh = (Color)paramKryo.readObject(paramInput, Color.class);
/*  157 */     this.barsWidth = paramInput.readFloat();
/*  158 */     this.barsHeight = paramInput.readFloat();
/*  159 */     this.revertBars = paramInput.readBoolean();
/*  160 */     this.particlesEnabled = paramInput.readBoolean();
/*      */     
/*  162 */     this.spectrumFrequencies = (Array<MusicManager.FrequencyRange>)paramKryo.readObject(paramInput, Array.class);
/*  163 */     this.maxValueEasing = paramInput.readFloat();
/*  164 */     this.fixedMaxValue = paramInput.readFloat();
/*  165 */     this.barSpacing = paramInput.readFloat();
/*  166 */     this.shiftX = paramInput.readFloat();
/*  167 */     this.shiftY = paramInput.readFloat();
/*      */ 
/*      */ 
/*      */     
/*  171 */     handleConfigChanged();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleConfigChanged() {
/*  182 */     if (Config.isHeadless())
/*      */       return; 
/*  184 */     int i = this.spectrumFrequencies.size;
/*      */     
/*  186 */     this.e = new float[i];
/*  187 */     this.f = new float[i];
/*  188 */     this.g = new float[i];
/*  189 */     this.h = new float[i];
/*  190 */     this.i = new float[i];
/*  191 */     this.j = new Particle[i];
/*      */     
/*  193 */     this.spectrumConfig = new MusicManager.SpectrumConfig(this.spectrumFrequencies);
/*  194 */     this.spectrumConfig.maxValueEasing = this.maxValueEasing;
/*  195 */     this.spectrumConfig.fixedMaxValue = this.fixedMaxValue;
/*  196 */     this.spectrumConfig = Game.i.musicManager.getSpectrumConfig(this.spectrumConfig);
/*      */   }
/*      */   
/*      */   public EqualizerTile() {
/*  200 */     super(TileType.EQUALIZER); for (Array.ArrayIterator<MusicManager.FrequencyRange> arrayIterator = MusicManager.SpectrumConfig.DEFAULT.frequencies.iterator(); arrayIterator.hasNext(); ) { MusicManager.FrequencyRange frequencyRange = arrayIterator.next(); this.spectrumFrequencies.add(new MusicManager.FrequencyRange(frequencyRange.min, frequencyRange.max)); }
/*  201 */      this.maxValueEasing = 0.998F; this.fixedMaxValue = 0.0F; this.barSpacing = 2.0F; handleConfigChanged();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canBeSelected() {
/*  206 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillInventoryWithInfo(Table paramTable, float paramFloat) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/*  227 */     return 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isRoadType() {
/*  232 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public RarityType getRarity() {
/*  237 */     return RarityType.COMMON;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemSubcategoryType getInventorySubcategory() {
/*  242 */     return ItemSubcategoryType.ME_SPECIAL;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean sameAs(Tile paramTile) {
/*  247 */     if (!super.sameAs(paramTile)) return false;
/*      */     
/*  249 */     paramTile = paramTile;
/*  250 */     if (this.barInterpolation != ((EqualizerTile)paramTile).barInterpolation) return false; 
/*  251 */     if (this.spectrumDropoff != ((EqualizerTile)paramTile).spectrumDropoff) return false; 
/*  252 */     if (this.channel != ((EqualizerTile)paramTile).channel) return false; 
/*  253 */     if (this.cutout != ((EqualizerTile)paramTile).cutout) return false; 
/*  254 */     if (this.direction != ((EqualizerTile)paramTile).direction) return false; 
/*  255 */     if (!this.colorLow.equals(((EqualizerTile)paramTile).colorLow)) return false; 
/*  256 */     if (!this.colorHigh.equals(((EqualizerTile)paramTile).colorHigh)) return false; 
/*  257 */     if (this.barsWidth != ((EqualizerTile)paramTile).barsWidth) return false; 
/*  258 */     if (this.barsHeight != ((EqualizerTile)paramTile).barsHeight) return false; 
/*  259 */     if (this.revertBars != ((EqualizerTile)paramTile).revertBars) return false; 
/*  260 */     if (this.particlesEnabled != ((EqualizerTile)paramTile).particlesEnabled) return false;
/*      */     
/*  262 */     if (this.spectrumFrequencies.size != ((EqualizerTile)paramTile).spectrumFrequencies.size) return false; 
/*  263 */     for (byte b = 0; b < this.spectrumFrequencies.size; b++) {
/*  264 */       if (!((MusicManager.FrequencyRange[])this.spectrumFrequencies.items)[b].sameAs(((MusicManager.FrequencyRange[])((EqualizerTile)paramTile).spectrumFrequencies.items)[b])) {
/*  265 */         return false;
/*      */       }
/*      */     } 
/*  268 */     if (this.maxValueEasing != ((EqualizerTile)paramTile).maxValueEasing) return false; 
/*  269 */     if (this.fixedMaxValue != ((EqualizerTile)paramTile).fixedMaxValue) return false; 
/*  270 */     if (this.barSpacing != ((EqualizerTile)paramTile).barSpacing) return false; 
/*  271 */     if (this.shiftX != ((EqualizerTile)paramTile).shiftX) return false; 
/*  272 */     if (this.shiftY != ((EqualizerTile)paramTile).shiftY) return false;
/*      */ 
/*      */ 
/*      */     
/*  276 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void from(Tile paramTile) {
/*  282 */     super.from(paramTile);
/*  283 */     paramTile = paramTile;
/*      */     
/*  285 */     this.barInterpolation = ((EqualizerTile)paramTile).barInterpolation;
/*  286 */     this.spectrumDropoff = ((EqualizerTile)paramTile).spectrumDropoff;
/*  287 */     this.channel = ((EqualizerTile)paramTile).channel;
/*  288 */     this.cutout = ((EqualizerTile)paramTile).cutout;
/*  289 */     this.direction = ((EqualizerTile)paramTile).direction;
/*  290 */     this.colorLow.set(((EqualizerTile)paramTile).colorLow);
/*  291 */     this.colorHigh.set(((EqualizerTile)paramTile).colorHigh);
/*  292 */     this.barsWidth = ((EqualizerTile)paramTile).barsWidth;
/*  293 */     this.barsHeight = ((EqualizerTile)paramTile).barsHeight;
/*  294 */     this.revertBars = ((EqualizerTile)paramTile).revertBars;
/*  295 */     this.particlesEnabled = ((EqualizerTile)paramTile).particlesEnabled;
/*      */     
/*  297 */     this.spectrumFrequencies.clear();
/*  298 */     this.spectrumFrequencies.addAll(((EqualizerTile)paramTile).spectrumFrequencies);
/*  299 */     this.maxValueEasing = ((EqualizerTile)paramTile).maxValueEasing;
/*  300 */     this.fixedMaxValue = ((EqualizerTile)paramTile).fixedMaxValue;
/*      */     
/*  302 */     this.barSpacing = ((EqualizerTile)paramTile).barSpacing;
/*  303 */     this.shiftX = ((EqualizerTile)paramTile).shiftX;
/*  304 */     this.shiftY = ((EqualizerTile)paramTile).shiftY;
/*      */ 
/*      */     
/*  307 */     handleConfigChanged();
/*      */   }
/*      */ 
/*      */   
/*      */   public Group generateUiIcon(float paramFloat) {
/*      */     Group group;
/*  313 */     (group = new Group()).setTransform(false);
/*  314 */     group.setSize(paramFloat, paramFloat);
/*      */     
/*      */     EqualizerTile equalizerTile;
/*  317 */     (equalizerTile = new EqualizerTile()).from(this);
/*  318 */     equalizerTile.barsWidth = 1.0F;
/*  319 */     equalizerTile.barsHeight = 1.0F;
/*  320 */     equalizerTile.shiftX = 0.0F;
/*  321 */     equalizerTile.shiftY = 0.0F;
/*  322 */     equalizerTile.drawAlways = true;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Image image;
/*      */ 
/*      */ 
/*      */     
/*  331 */     (image = new Image(this, equalizerTile, paramFloat) { public void draw(Batch param1Batch, float param1Float) { validate(); this.j.drawFancy(param1Batch, Gdx.graphics.getDeltaTime(), getX(), getY(), this.k); } }).setSize(paramFloat, paramFloat);
/*  332 */     group.addActor((Actor)image);
/*      */     
/*  334 */     return group;
/*      */   }
/*      */ 
/*      */   
/*      */   public void toJson(Json paramJson) {
/*  339 */     super.toJson(paramJson);
/*      */     
/*  341 */     paramJson.writeObjectStart("d");
/*  342 */     paramJson.writeValue("bi", Integer.valueOf(this.barInterpolation));
/*  343 */     paramJson.writeValue("sd", Float.valueOf(this.spectrumDropoff));
/*  344 */     paramJson.writeValue("c", Integer.valueOf(this.channel));
/*  345 */     paramJson.writeValue("co", Float.valueOf(this.cutout));
/*  346 */     paramJson.writeValue("d", Integer.valueOf(this.direction));
/*  347 */     paramJson.writeValue("cl", this.colorLow.toString());
/*  348 */     paramJson.writeValue("ch", this.colorHigh.toString());
/*  349 */     paramJson.writeValue("bw", Float.valueOf(this.barsWidth));
/*  350 */     paramJson.writeValue("bh", Float.valueOf(this.barsHeight));
/*  351 */     paramJson.writeValue("rb", Boolean.valueOf(this.revertBars));
/*  352 */     paramJson.writeValue("pe", Boolean.valueOf(this.particlesEnabled));
/*      */     
/*  354 */     paramJson.writeArrayStart("f");
/*  355 */     for (Array.ArrayIterator<MusicManager.FrequencyRange> arrayIterator = this.spectrumFrequencies.iterator(); arrayIterator.hasNext(); ) { MusicManager.FrequencyRange frequencyRange = arrayIterator.next();
/*  356 */       paramJson.writeArrayStart();
/*  357 */       paramJson.writeValue(Float.valueOf(frequencyRange.min));
/*  358 */       paramJson.writeValue(Float.valueOf(frequencyRange.max));
/*  359 */       paramJson.writeArrayEnd(); }
/*      */     
/*  361 */     paramJson.writeArrayEnd();
/*      */     
/*  363 */     paramJson.writeValue("mve", Float.valueOf(this.maxValueEasing));
/*  364 */     paramJson.writeValue("fmv", Float.valueOf(this.fixedMaxValue));
/*  365 */     paramJson.writeValue("bs", Float.valueOf(this.barSpacing));
/*  366 */     paramJson.writeValue("sx", Float.valueOf(this.shiftX));
/*  367 */     paramJson.writeValue("sy", Float.valueOf(this.shiftY));
/*      */ 
/*      */ 
/*      */     
/*  371 */     paramJson.writeObjectEnd();
/*      */   }
/*      */   public void drawFancy(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*      */     float[] arrayOfFloat;
/*  375 */     if (this.e.length == 0)
/*      */       return; 
/*  377 */     if (!this.drawAlways && Game.i.musicManager.getPlayingMusic() == null && Game.i.musicManager.getMainVolume() > 0.0F) {
/*  378 */       for (byte b = 0; b < this.e.length; b++) {
/*  379 */         this.h[b] = this.h[b] * 0.99F;
/*  380 */         this.i[b] = this.i[b] * 0.99F;
/*  381 */         this.g[b] = this.g[b] * 0.99F;
/*  382 */         this.e[b] = this.e[b] * 0.99F;
/*      */       } 
/*      */     } else {
/*      */       
/*  386 */       if (this.spectrumConfig == null) {
/*  387 */         handleConfigChanged();
/*      */       }
/*      */       MusicManager.SpectrumConfig spectrumConfig;
/*  390 */       (spectrumConfig = Game.i.musicManager.getSpectrumConfig(this.spectrumConfig)).copySpectrum(this.h, true);
/*  391 */       spectrumConfig.copySpectrum(this.i, false);
/*      */     } 
/*      */     
/*  394 */     if (this.channel == 2) {
/*  395 */       for (byte b = 0; b < this.h.length; b++) {
/*  396 */         this.h[b] = (this.h[b] + this.i[b]) * 0.5F;
/*      */       }
/*  398 */       arrayOfFloat = this.h;
/*  399 */     } else if (this.channel == 0) {
/*  400 */       arrayOfFloat = this.h;
/*      */     } else {
/*  402 */       arrayOfFloat = this.i;
/*      */     } 
/*      */     
/*  405 */     for (byte b1 = 0; b1 < arrayOfFloat.length; b1++) {
/*  406 */       Interpolation.PowIn powIn; Interpolation.ExpIn expIn; float f8; Interpolation interpolation = Interpolation.linear;
/*  407 */       switch (this.barInterpolation) { case 1:
/*  408 */           powIn = Interpolation.pow2In; break;
/*  409 */         case 2: powIn = Interpolation.pow3In; break;
/*  410 */         case 3: expIn = Interpolation.exp5In; break;
/*  411 */         case 4: expIn = Interpolation.exp10In;
/*      */           break; }
/*      */       
/*      */       float f7;
/*  415 */       if ((f7 = expIn.apply(arrayOfFloat[b1]) * (((MusicManager.FrequencyRange[])this.spectrumFrequencies.items)[b1]).multiplier) <= this.e[b1]) {
/*      */         
/*  417 */         f8 = this.e[b1] - this.f[b1];
/*  418 */         this.f[b1] = this.f[b1] + paramFloat1 * this.spectrumDropoff;
/*  419 */         if (f8 < f7) f8 = f7;
/*      */         
/*  421 */         if (this.particlesEnabled && this.g[b1] > 0.15F && Game.i.settingsManager.isParticlesDrawing()) {
/*      */           Particle particle;
/*  423 */           (particle = (Particle)Pools.obtain(Particle.class)).vX = 0.0F;
/*  424 */           particle.vY = 0.0F;
/*  425 */           particle.t = 0.0F;
/*  426 */           switch (this.direction) { case 1:
/*  427 */               particle.vY = -this.g[b1]; break;
/*  428 */             case 0: particle.vY = this.g[b1]; break;
/*  429 */             case 2: particle.vX = -this.g[b1]; break;
/*  430 */             case 3: particle.vX = this.g[b1]; break; }
/*      */           
/*  432 */           particle.vX *= 0.9F + FastRandom.getFloat() * 0.1F;
/*  433 */           particle.vY *= 0.9F + FastRandom.getFloat() * 0.1F;
/*  434 */           this.j[b1] = particle;
/*      */         } 
/*  436 */         this.g[b1] = 0.0F;
/*      */       } else {
/*      */         
/*  439 */         float f = f7 - this.e[b1];
/*  440 */         this.g[b1] = f;
/*      */         
/*  442 */         f8 = f7;
/*  443 */         this.f[b1] = 0.0F;
/*      */       } 
/*  445 */       this.e[b1] = f8;
/*      */     } 
/*      */ 
/*      */     
/*  449 */     paramFloat2 += this.shiftX;
/*  450 */     paramFloat3 += this.shiftY;
/*      */     
/*  452 */     float f2 = this.barSpacing / 128.0F;
/*      */     
/*  454 */     ResourcePack.AtlasTextureRegion atlasTextureRegion1 = Game.i.assetManager.getBlankWhiteTextureRegion();
/*      */     
/*      */     float f3;
/*  457 */     if ((f3 = 1.0F - (this.e.length - 1) * f2) < 0.0F) f3 = 0.0F;
/*      */ 
/*      */     
/*  460 */     float f4, f5 = (f4 = f3 / this.e.length) + f2;
/*  461 */     float f1 = 0.0F;
/*      */     
/*  463 */     if (this.revertBars) {
/*  464 */       f5 = -f5;
/*  465 */       f1 = 1.0F - f4;
/*      */     } 
/*      */     
/*  468 */     f2 = paramFloat4;
/*  469 */     f3 = paramFloat4;
/*  470 */     float f6 = 0.0F;
/*  471 */     switch (this.direction) {
/*      */       case 2:
/*      */       case 3:
/*  474 */         f2 = this.barsHeight * paramFloat4;
/*  475 */         f3 = this.barsWidth * paramFloat4;
/*  476 */         f6 = f4 * f3;
/*      */         break;
/*      */       
/*      */       case 0:
/*      */       case 1:
/*  481 */         f2 = this.barsWidth * paramFloat4;
/*  482 */         f3 = this.barsHeight * paramFloat4;
/*  483 */         f6 = f4 * f2;
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  488 */     for (byte b2 = 0; b2 < this.e.length; b2++) {
/*  489 */       float f = Math.max(0.0F, this.e[b2] - this.cutout) / (1.0F - this.cutout);
/*      */       
/*  491 */       if (this.e.length == 1) {
/*  492 */         k.set(this.colorLow);
/*      */       } else {
/*  494 */         k.set(this.colorLow).lerp(this.colorHigh, b2 / (this.e.length - 1));
/*      */       } 
/*  496 */       paramBatch.setColor(k);
/*      */       
/*      */       Particle particle;
/*  499 */       if ((particle = this.j[b2]) != null) {
/*  500 */         particle.color.set(k);
/*  501 */         this.d.add(particle);
/*      */       } 
/*      */       
/*  504 */       switch (this.direction) {
/*      */         case 2:
/*  506 */           paramBatch.draw((TextureRegion)atlasTextureRegion1, paramFloat2 - f * f2 + paramFloat4, paramFloat3 + f1 * f3, f * f2, f4 * f3);
/*  507 */           if (particle != null) {
/*  508 */             particle.x = paramFloat2 + paramFloat4 - f * f2;
/*  509 */             particle.y = paramFloat3 + (f1 + f4 * 0.5F) * f3;
/*      */           } 
/*      */           break;
/*      */         
/*      */         case 0:
/*  514 */           paramBatch.draw((TextureRegion)atlasTextureRegion1, paramFloat2 + f1 * f2, paramFloat3, f4 * f2, f * f3);
/*  515 */           if (particle != null) {
/*  516 */             particle.x = paramFloat2 + f1 * f2 + f4 * f2 * 0.5F;
/*  517 */             particle.y = paramFloat3 + f * f3;
/*      */           } 
/*      */           break;
/*      */         
/*      */         case 3:
/*  522 */           paramBatch.draw((TextureRegion)atlasTextureRegion1, paramFloat2, paramFloat3 + f1 * f3, f * f2, f4 * f3);
/*  523 */           if (particle != null) {
/*  524 */             particle.x = paramFloat2 + f * f2;
/*  525 */             particle.y = paramFloat3 + (f1 + f4 * 0.5F) * f3;
/*      */           } 
/*      */           break;
/*      */ 
/*      */         
/*      */         case 1:
/*  531 */           paramBatch.draw((TextureRegion)atlasTextureRegion1, paramFloat2 + f1 * f2, paramFloat3 - f * f3 + paramFloat4, f4 * f2, f * f3);
/*  532 */           if (particle != null) {
/*  533 */             particle.x = paramFloat2 + (f1 + f4 * 0.5F) * f2;
/*  534 */             particle.y = paramFloat3 - f * f3 + paramFloat4;
/*      */           } 
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/*  540 */       f1 += f5;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  547 */     ResourcePack.AtlasTextureRegion atlasTextureRegion2 = Game.i.assetManager.getBlankWhiteTextureRegion();
/*  548 */     this.d.begin();
/*  549 */     for (byte b3 = 0; b3 < this.d.size; b3++) {
/*  550 */       Particle particle = ((Particle[])this.d.items)[b3];
/*  551 */       k.set(particle.color);
/*  552 */       k.a = MathUtils.clamp(1.0F - particle.t, 0.0F, 1.0F) * particle.color.a;
/*  553 */       paramBatch.setColor(k);
/*  554 */       paramBatch.draw((TextureRegion)atlasTextureRegion2, particle.x - f6 * 0.5F, particle.y - f6 * 0.5F, f6, f6);
/*      */       
/*  556 */       particle.t += paramFloat1;
/*  557 */       if (particle.t > 1.0F) {
/*  558 */         this.d.removeIndex(b3);
/*  559 */         Pools.free(particle);
/*      */       } else {
/*  561 */         particle.x += particle.vX * paramFloat1 * 400.0F;
/*  562 */         particle.y += particle.vY * paramFloat1 * 400.0F;
/*  563 */         particle.vX *= 0.995F;
/*  564 */         particle.vY *= 0.995F;
/*      */       } 
/*      */     } 
/*  567 */     this.d.end();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  573 */     Arrays.fill((Object[])this.j, (Object)null);
/*  574 */     paramBatch.setColor(Color.WHITE);
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/*  579 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*      */     
/*  581 */     if (paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/*      */       
/*  583 */       paramBatch.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  584 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).iconOrgan, paramFloat1 + paramFloat3 * 0.5F * 0.5F, paramFloat2 + paramFloat4 * 0.5F * 0.5F, paramFloat3 * 0.5F, paramFloat4 * 0.5F);
/*  585 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {
/*  591 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_SPECTRUM_ENABLED) != 0.0D) {
/*  592 */       drawFancy(paramBatch, Gdx.graphics.getDeltaTime(), paramFloat2, paramFloat3, paramFloat4);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/*  598 */     paramItemCreationOverlay.label("Bar interpolation");
/*  599 */     paramItemCreationOverlay.hintLabel("Bar height function, use linear for 1:1 representation of the spectrum", true);
/*      */     SelectBox selectBox;
/*  601 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])new String[] { "linear", "pow2", "pow3", "exp5", "exp10" });
/*  602 */     switch (this.barInterpolation) { case 0:
/*  603 */         selectBox.setSelected("linear"); break;
/*  604 */       case 1: selectBox.setSelected("pow2"); break;
/*  605 */       case 2: selectBox.setSelected("pow3"); break;
/*  606 */       case 3: selectBox.setSelected("exp5"); break;
/*  607 */       case 4: selectBox.setSelected("exp10"); break; }
/*      */     
/*  609 */     selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramItemCreationOverlay)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  612 */             switch ((String)this.a.getSelected()) { case "linear":
/*  613 */                 this.c.barInterpolation = 0; break;
/*  614 */               case "pow2": this.c.barInterpolation = 1; break;
/*  615 */               case "pow3": this.c.barInterpolation = 2; break;
/*  616 */               case "exp5": this.c.barInterpolation = 3; break;
/*  617 */               case "exp10": this.c.barInterpolation = 4; break; }
/*      */             
/*  619 */             this.b.updateItemIcon();
/*      */           }
/*      */         });
/*  622 */     paramItemCreationOverlay.selectBox(selectBox);
/*      */     
/*  624 */     paramItemCreationOverlay.label("Drop-off");
/*  625 */     paramItemCreationOverlay.hintLabel("How fast will bars return to zero. Per-frame bar height reduction multiplier", true);
/*  626 */     paramItemCreationOverlay.textField(String.valueOf(this.spectrumDropoff), paramString -> {
/*      */           try {
/*      */             this.spectrumDropoff = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  630 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  635 */     paramItemCreationOverlay.label("Cutout");
/*  636 */     paramItemCreationOverlay.hintLabel("Minimum value of the spectrum [0..1] to render", true);
/*  637 */     paramItemCreationOverlay.textField(String.valueOf(this.cutout), paramString -> {
/*      */           try {
/*      */             this.cutout = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  641 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  646 */     paramItemCreationOverlay.label("Channel");
/*      */     
/*  648 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])new String[] { "left", "right", "both" });
/*  649 */     switch (this.channel) { case 0:
/*  650 */         selectBox.setSelected("left"); break;
/*  651 */       case 1: selectBox.setSelected("right"); break;
/*  652 */       case 2: selectBox.setSelected("both"); break; }
/*      */     
/*  654 */     selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramItemCreationOverlay)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  657 */             switch ((String)this.a.getSelected()) { case "left":
/*  658 */                 this.c.channel = 0; break;
/*  659 */               case "right": this.c.channel = 1; break;
/*  660 */               case "both": this.c.channel = 2; break; }
/*      */             
/*  662 */             this.b.updateItemIcon();
/*      */           }
/*      */         });
/*  665 */     paramItemCreationOverlay.selectBox(selectBox);
/*      */     
/*  667 */     paramItemCreationOverlay.label("Direction");
/*      */     
/*  669 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])new String[] { "left", "right", "top", "bottom" });
/*  670 */     switch (this.direction) { case 1:
/*  671 */         selectBox.setSelected("bottom"); break;
/*  672 */       case 0: selectBox.setSelected("top"); break;
/*  673 */       case 2: selectBox.setSelected("left"); break;
/*  674 */       case 3: selectBox.setSelected("right"); break; }
/*      */     
/*  676 */     selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramItemCreationOverlay)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  679 */             switch ((String)this.a.getSelected()) { case "bottom":
/*  680 */                 this.c.direction = 1; break;
/*  681 */               case "top": this.c.direction = 0; break;
/*  682 */               case "left": this.c.direction = 2; break;
/*  683 */               case "right": this.c.direction = 3; break; }
/*      */             
/*  685 */             this.b.updateItemIcon();
/*      */           }
/*      */         });
/*  688 */     paramItemCreationOverlay.selectBox(selectBox);
/*      */     
/*  690 */     paramItemCreationOverlay.label("Bar thickness");
/*  691 */     paramItemCreationOverlay.hintLabel("How many tiles will this Equalizer take along the frequency axis", true);
/*  692 */     paramItemCreationOverlay.textField(String.valueOf(this.barsWidth), paramString -> {
/*      */           try {
/*      */             this.barsWidth = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  696 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  701 */     paramItemCreationOverlay.label("Bar length");
/*  702 */     paramItemCreationOverlay.hintLabel("How many tiles will this Equalizer take along the spectrum value axis", true);
/*  703 */     paramItemCreationOverlay.textField(String.valueOf(this.barsHeight), paramString -> {
/*      */           try {
/*      */             this.barsHeight = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  707 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  712 */     paramItemCreationOverlay.label("Low color");
/*  713 */     paramItemCreationOverlay.textField(this.colorLow.toString().toUpperCase(Locale.US), paramString -> {
/*      */           try {
/*      */             this.colorLow.set(Color.valueOf(paramString)); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  717 */           } catch (Exception exception) {
/*      */             return;
/*      */           } 
/*  720 */         }); paramItemCreationOverlay.label("High color");
/*  721 */     paramItemCreationOverlay.textField(this.colorHigh.toString().toUpperCase(Locale.US), paramString -> {
/*      */           try {
/*      */             this.colorHigh.set(Color.valueOf(paramString)); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  725 */           } catch (Exception exception) {
/*      */             return;
/*      */           } 
/*  728 */         }); paramItemCreationOverlay.toggle("Revert bars", this.revertBars, paramBoolean -> {
/*      */           this.revertBars = paramBoolean.booleanValue();
/*      */           paramItemCreationOverlay.updateItemIcon();
/*      */         });
/*  732 */     paramItemCreationOverlay.hintLabel("Swap low and high frequency sides of the spectrum", true);
/*      */     
/*  734 */     paramItemCreationOverlay.toggle("Particles", this.particlesEnabled, paramBoolean -> {
/*      */           this.particlesEnabled = paramBoolean.booleanValue();
/*      */           paramItemCreationOverlay.updateItemIcon();
/*      */         });
/*  738 */     paramItemCreationOverlay.hintLabel("Show particles if available for this visualization type", true);
/*      */     
/*  740 */     paramItemCreationOverlay.label("Bar spacing");
/*  741 */     paramItemCreationOverlay.textField(String.valueOf(this.barSpacing), paramString -> {
/*      */           try {
/*      */             this.barSpacing = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  745 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  750 */     paramItemCreationOverlay.label("Shift X");
/*  751 */     paramItemCreationOverlay.textField(String.valueOf(this.shiftX), paramString -> {
/*      */           try {
/*      */             this.shiftX = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  755 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  760 */     paramItemCreationOverlay.label("Shift Y");
/*  761 */     paramItemCreationOverlay.textField(String.valueOf(this.shiftY), paramString -> {
/*      */           try {
/*      */             this.shiftY = Float.parseFloat(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  765 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  770 */     paramItemCreationOverlay.label("Frequencies");
/*  771 */     Table table1 = new Table();
/*  772 */     paramItemCreationOverlay.form.add((Actor)table1).width(800.0F).top().left().row();
/*      */     
/*  774 */     TextureRegionDrawable textureRegionDrawable = Game.i.assetManager.getDrawable("blank");
/*      */ 
/*      */ 
/*      */     
/*  778 */     byte b = 0;
/*  779 */     for (Array.ArrayIterator<MusicManager.FrequencyRange> arrayIterator = this.spectrumFrequencies.iterator(); arrayIterator.hasNext(); ) { MusicManager.FrequencyRange frequencyRange = arrayIterator.next();
/*  780 */       Table table3 = new Table();
/*  781 */       table1.add((Actor)table3).expandX().fillX().row();
/*      */       
/*  783 */       Table table4 = new Table();
/*  784 */       table3.add((Actor)table4).top().left().padBottom(10.0F).padRight(10.0F).minHeight(32.0F);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform;
/*  787 */       (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(frequencyRange.min), paramItemCreationOverlay.textFieldStyle)).setSize(120.0F, 32.0F);
/*  788 */       textFieldXPlatform.addListener((EventListener)new ChangeListener(this, textFieldXPlatform, frequencyRange, paramItemCreationOverlay)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  792 */                 double d = Double.parseDouble(this.a.getText());
/*  793 */                 this.b.min = (float)d;
/*  794 */                 this.d.handleConfigChanged();
/*  795 */                 this.c.updateItemIcon(); return;
/*  796 */               } catch (Exception exception) {
/*  797 */                 EqualizerTile.a().e("invalid value", new Object[] { exception });
/*      */                 return;
/*      */               }  }
/*      */           });
/*  801 */       table4.add((Actor)textFieldXPlatform).size(120.0F, 32.0F).top().left();
/*      */ 
/*      */       
/*  804 */       (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(frequencyRange.max), paramItemCreationOverlay.textFieldStyle)).setSize(120.0F, 32.0F);
/*  805 */       textFieldXPlatform.addListener((EventListener)new ChangeListener(this, textFieldXPlatform, frequencyRange, paramItemCreationOverlay)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  809 */                 double d = Double.parseDouble(this.a.getText());
/*  810 */                 this.b.max = (float)d;
/*  811 */                 this.d.handleConfigChanged();
/*  812 */                 this.c.updateItemIcon(); return;
/*  813 */               } catch (Exception exception) {
/*  814 */                 EqualizerTile.a().e("invalid value", new Object[] { exception });
/*      */                 return;
/*      */               }  }
/*      */           });
/*  818 */       table4.add((Actor)textFieldXPlatform).size(120.0F, 32.0F).padLeft(15.0F).top().left();
/*      */ 
/*      */       
/*  821 */       (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(frequencyRange.multiplier), paramItemCreationOverlay.textFieldStyle)).setSize(120.0F, 32.0F);
/*  822 */       textFieldXPlatform.addListener((EventListener)new ChangeListener(this, textFieldXPlatform, frequencyRange, paramItemCreationOverlay)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  826 */                 double d = Double.parseDouble(this.a.getText());
/*  827 */                 this.b.multiplier = (float)d;
/*  828 */                 this.d.handleConfigChanged();
/*  829 */                 this.c.updateItemIcon(); return;
/*  830 */               } catch (Exception exception) {
/*  831 */                 EqualizerTile.a().e("invalid value", new Object[] { exception });
/*      */                 return;
/*      */               }  }
/*      */           });
/*  835 */       table4.add((Actor)textFieldXPlatform).size(120.0F, 32.0F).padLeft(15.0F).top().left();
/*      */       
/*  837 */       table4.add().expandX().fillX();
/*      */       
/*  839 */       if (b) {
/*  840 */         byte b2 = b;
/*      */ 
/*      */ 
/*      */         
/*      */         RectButton rectButton2;
/*      */ 
/*      */         
/*  847 */         (rectButton2 = new RectButton("", Game.i.assetManager.getLabelStyle(21), () -> { this.spectrumFrequencies.swap(paramInt, paramInt - 1); handleConfigChanged(); paramItemCreationOverlay.updateItemIcon(); paramItemCreationOverlay.updateForm(); })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"), 4.0F, 4.0F, 24.0F, 24.0F);
/*  848 */         rectButton2.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 32.0F, 32.0F);
/*  849 */         rectButton2.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.RED.P900);
/*  850 */         table3.add((Actor)rectButton2).top().left().size(32.0F);
/*      */       } 
/*  852 */       if (b != this.spectrumFrequencies.size - 1) {
/*  853 */         byte b2 = b;
/*      */ 
/*      */ 
/*      */         
/*      */         RectButton rectButton2;
/*      */ 
/*      */         
/*  860 */         (rectButton2 = new RectButton("", Game.i.assetManager.getLabelStyle(21), () -> { this.spectrumFrequencies.swap(paramInt, paramInt + 1); handleConfigChanged(); paramItemCreationOverlay.updateItemIcon(); paramItemCreationOverlay.updateForm(); })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"), 4.0F, 4.0F, 24.0F, 24.0F);
/*  861 */         rectButton2.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 32.0F, 32.0F);
/*  862 */         rectButton2.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.RED.P900);
/*  863 */         table3.add((Actor)rectButton2).top().left().size(32.0F);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       RectButton rectButton1;
/*      */ 
/*      */ 
/*      */       
/*  872 */       (rectButton1 = new RectButton("", Game.i.assetManager.getLabelStyle(21), () -> { this.spectrumFrequencies.removeValue(paramFrequencyRange, true); handleConfigChanged(); paramItemCreationOverlay.updateItemIcon(); paramItemCreationOverlay.updateForm(); })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 4.0F, 4.0F, 24.0F, 24.0F);
/*  873 */       rectButton1.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 32.0F, 32.0F);
/*  874 */       rectButton1.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, MaterialColor.RED.P900);
/*  875 */       table3.add((Actor)rectButton1).top().left().size(32.0F);
/*      */       
/*  877 */       table3.add().height(1.0F).growX();
/*      */ 
/*      */       
/*  880 */       byte b1 = b;
/*  881 */       Widget widget = new Widget(this, 150.0F, b1, (Drawable)textureRegionDrawable, 32.0F)
/*      */         {
/*      */           public void draw(Batch param1Batch, float param1Float) {
/*  884 */             validate();
/*      */             
/*  886 */             if (this.n.spectrumConfig != null) {
/*  887 */               MusicManager.SpectrumConfig spectrumConfig = Game.i.musicManager.getSpectrumConfig(this.n.spectrumConfig);
/*      */               
/*  889 */               param1Batch.setColor(MaterialColor.LIGHT_GREEN.P500.r, MaterialColor.LIGHT_GREEN.P500.g, MaterialColor.LIGHT_GREEN.P500.b, param1Float);
/*      */               
/*  891 */               param1Float = getX();
/*  892 */               float f2 = getY();
/*  893 */               float f1 = this.j * spectrumConfig.spectrumLeft[this.k];
/*      */               
/*  895 */               this.l.draw(param1Batch, param1Float + this.j - f1, f2, f1, this.m);
/*      */             } 
/*      */           }
/*      */         };
/*  899 */       table3.add((Actor)widget).top().left().size(150.0F, 32.0F).padLeft(10.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Image image;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  911 */       (image = new Image(this, (Drawable)Game.i.assetManager.getDrawable("blank"), b1) { public void draw(Batch param1Batch, float param1Float) { if (this.k.spectrumConfig != null) { MusicManager.SpectrumConfig spectrumConfig = Game.i.musicManager.getSpectrumConfig(this.k.spectrumConfig); setScaleX(spectrumConfig.spectrumRight[this.j]); }  super.draw(param1Batch, param1Float); } }).setColor(MaterialColor.LIGHT_BLUE.P500);
/*  912 */       table3.add((Actor)image).top().left().size(150.0F, 32.0F).padLeft(1.0F);
/*      */       
/*  914 */       table3.row();
/*      */       
/*  916 */       b++; }
/*      */ 
/*      */     
/*  919 */     Table table2 = new Table();
/*  920 */     table1.add((Actor)table2).expandX().fillX().row();
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform1;
/*  923 */     (textFieldXPlatform1 = new TextFieldXPlatform("", paramItemCreationOverlay.textFieldStyle)).setMessageText("Min");
/*  924 */     table2.add((Actor)textFieldXPlatform1).size(200.0F, 32.0F).padRight(15.0F);
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform2;
/*  927 */     (textFieldXPlatform2 = new TextFieldXPlatform("", paramItemCreationOverlay.textFieldStyle)).setMessageText("Max");
/*  928 */     table2.add((Actor)textFieldXPlatform2).size(200.0F, 32.0F).padRight(10.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     RectButton rectButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  943 */     (rectButton = new RectButton("", Game.i.assetManager.getLabelStyle(21), () -> { if (paramTextFieldXPlatform1.getText().length() > 0) try { float f1 = Float.parseFloat(paramTextFieldXPlatform1.getText()); float f2 = Float.parseFloat(paramTextFieldXPlatform2.getText()); this.spectrumFrequencies.add(new MusicManager.FrequencyRange(f1, f2)); handleConfigChanged(); paramItemCreationOverlay.updateForm(); return; } catch (Exception exception) { c.e("invalid value", new Object[] { exception }); }   })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-plus"), 36.0F, 4.0F, 24.0F, 24.0F);
/*  944 */     rectButton.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 32.0F, 32.0F);
/*  945 */     rectButton.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900);
/*  946 */     table2.add((Actor)rectButton).top().left().size(96.0F, 32.0F);
/*      */     
/*  948 */     table2.add().expandX().fillX();
/*      */     
/*  950 */     paramItemCreationOverlay.label("Max value easing");
/*  951 */     paramItemCreationOverlay.hintLabel("By default, max value of the spectrum is determined automatically and it can become very high during some loud periods. Bar values are calculated according to the max observed value of the spectrum, and to smooth it out for a more quiet periods, max value drops over time. Set to 1 to disable (bars may become too small in this case). Too low values may render bars too high for a quiet periods.", true);
/*  952 */     paramItemCreationOverlay.textField(String.valueOf(this.maxValueEasing), paramString -> {
/*      */           try {
/*      */             this.maxValueEasing = Float.parseFloat(paramString); handleConfigChanged();
/*      */             paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  957 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  962 */     paramItemCreationOverlay.label("Fixed max value");
/*  963 */     paramItemCreationOverlay.hintLabel("If set to >0, spectrum analyzer won't determine max value automatically and 'Max value easing' will be ignored", true);
/*  964 */     paramItemCreationOverlay.textField(String.valueOf(this.fixedMaxValue), paramString -> {
/*      */           try {
/*      */             this.fixedMaxValue = Float.parseFloat(paramString); handleConfigChanged();
/*      */             paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  969 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*      */   }
/*      */   
/*      */   public void addSellItems(Array<ItemStack> paramArray) {
/*  977 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 1));
/*      */   }
/*      */ 
/*      */   
/*      */   public double getPrestigeScore() {
/*  982 */     return 0.0D;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canBeUpgraded() {
/*  987 */     return false;
/*      */   }
/*      */   
/*      */   public static final class Particle {
/*      */     public float x;
/*      */     public float y;
/*      */     public float vX;
/*      */     public float vY;
/*      */     public float t;
/*  996 */     public Color color = new Color();
/*      */   }
/*      */   
/*      */   public static class EqualizerTileFactory extends Tile.Factory.AbstractFactory<EqualizerTile> {
/*      */     public EqualizerTileFactory() {
/* 1001 */       super(TileType.EQUALIZER);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 1006 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setupAssets() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public EqualizerTile create() {
/* 1016 */       return new EqualizerTile();
/*      */     }
/*      */ 
/*      */     
/*      */     public EqualizerTile fromJson(JsonValue param1JsonValue) {
/* 1021 */       EqualizerTile equalizerTile = (EqualizerTile)super.fromJson(param1JsonValue);
/*      */ 
/*      */       
/* 1024 */       if ((param1JsonValue = param1JsonValue.get("d")) != null) {
/*      */         try {
/* 1026 */           equalizerTile.barInterpolation = param1JsonValue.getInt("bi", equalizerTile.barInterpolation);
/* 1027 */           equalizerTile.spectrumDropoff = param1JsonValue.getFloat("sd", equalizerTile.spectrumDropoff);
/* 1028 */           equalizerTile.channel = param1JsonValue.getInt("c", equalizerTile.channel);
/* 1029 */           equalizerTile.cutout = param1JsonValue.getFloat("co", equalizerTile.cutout);
/* 1030 */           equalizerTile.direction = param1JsonValue.getInt("d", equalizerTile.direction);
/*      */           try {
/* 1032 */             equalizerTile.colorLow = Color.valueOf(param1JsonValue.getString("cl"));
/* 1033 */           } catch (Exception exception) {}
/*      */           try {
/* 1035 */             equalizerTile.colorHigh = Color.valueOf(param1JsonValue.getString("ch"));
/* 1036 */           } catch (Exception exception) {}
/* 1037 */           equalizerTile.barsWidth = param1JsonValue.getFloat("bw", equalizerTile.barsWidth);
/* 1038 */           equalizerTile.barsHeight = param1JsonValue.getFloat("bh", equalizerTile.barsHeight);
/* 1039 */           equalizerTile.revertBars = param1JsonValue.getBoolean("rb", equalizerTile.revertBars);
/* 1040 */           equalizerTile.particlesEnabled = param1JsonValue.getBoolean("pe", equalizerTile.particlesEnabled);
/*      */           
/*      */           JsonValue jsonValue;
/* 1043 */           if ((jsonValue = param1JsonValue.get("f")) != null) {
/* 1044 */             equalizerTile.spectrumFrequencies.clear();
/* 1045 */             for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 1046 */               equalizerTile.spectrumFrequencies.add(new MusicManager.FrequencyRange(jsonValue1.getFloat(0), jsonValue1.getFloat(1))); }
/*      */           
/*      */           } 
/*      */           
/* 1050 */           equalizerTile.maxValueEasing = param1JsonValue.getFloat("mve", equalizerTile.maxValueEasing);
/* 1051 */           equalizerTile.fixedMaxValue = param1JsonValue.getFloat("fmv", equalizerTile.fixedMaxValue);
/* 1052 */           equalizerTile.barSpacing = param1JsonValue.getFloat("bs", equalizerTile.barSpacing);
/* 1053 */           equalizerTile.shiftX = param1JsonValue.getFloat("sx", equalizerTile.shiftX);
/* 1054 */           equalizerTile.shiftY = param1JsonValue.getFloat("sy", equalizerTile.shiftY);
/*      */         }
/* 1056 */         catch (Exception exception) {
/* 1057 */           EqualizerTile.a().e("failed to load from json", new Object[] { exception });
/*      */         } 
/*      */       }
/* 1060 */       equalizerTile.handleConfigChanged();
/*      */       
/* 1062 */       return equalizerTile;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\EqualizerTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */