/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.NinePatch;
/*     */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.SerializationException;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ import com.badlogic.gdx.utils.reflect.Method;
/*     */ import com.badlogic.gdx.utils.reflect.ReflectionException;
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
/*     */ public class Skin
/*     */   implements Disposable
/*     */ {
/*  59 */   ObjectMap<Class, ObjectMap<String, Object>> resources = new ObjectMap();
/*     */   TextureAtlas atlas;
/*  61 */   float scale = 1.0F;
/*     */   
/*  63 */   private final ObjectMap<String, Class> jsonClassTags = new ObjectMap(defaultTagClasses.length); public Skin() { Class[] arrayOfClass; int i;
/*     */     byte b;
/*  65 */     for (i = (arrayOfClass = defaultTagClasses).length, b = 0; b < i; ) { Class clazz = arrayOfClass[b];
/*  66 */       this.jsonClassTags.put(clazz.getSimpleName(), clazz); b++; }  } public Skin(FileHandle paramFileHandle) { Class[] arrayOfClass; int i; byte b; for (i = (arrayOfClass = defaultTagClasses).length, b = 0; b < i; ) { Class clazz = arrayOfClass[b]; this.jsonClassTags.put(clazz.getSimpleName(), clazz);
/*     */ 
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FileHandle fileHandle;
/*     */ 
/*     */     
/*  78 */     if ((fileHandle = paramFileHandle.sibling(paramFileHandle.nameWithoutExtension() + ".atlas")).exists()) {
/*  79 */       this.atlas = new TextureAtlas(fileHandle);
/*  80 */       addRegions(this.atlas);
/*     */     } 
/*     */     
/*  83 */     load(paramFileHandle); } public Skin(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas) { Class[] arrayOfClass; int i; byte b;
/*     */     for (i = (arrayOfClass = defaultTagClasses).length, b = 0; b < i; ) {
/*     */       Class clazz = arrayOfClass[b];
/*     */       this.jsonClassTags.put(clazz.getSimpleName(), clazz);
/*     */       b++;
/*     */     } 
/*  89 */     this.atlas = paramTextureAtlas;
/*  90 */     addRegions(paramTextureAtlas);
/*  91 */     load(paramFileHandle); } public Skin(TextureAtlas paramTextureAtlas) { Class[] arrayOfClass; int i; byte b;
/*     */     for (i = (arrayOfClass = defaultTagClasses).length, b = 0; b < i; ) {
/*     */       Class clazz = arrayOfClass[b];
/*     */       this.jsonClassTags.put(clazz.getSimpleName(), clazz);
/*     */       b++;
/*     */     } 
/*  97 */     this.atlas = paramTextureAtlas;
/*  98 */     addRegions(paramTextureAtlas); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileHandle paramFileHandle) {
/*     */     try {
/* 104 */       getJsonLoader(paramFileHandle).fromJson(Skin.class, paramFileHandle); return;
/* 105 */     } catch (SerializationException serializationException) {
/* 106 */       throw new SerializationException("Error reading file: " + paramFileHandle, serializationException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRegions(TextureAtlas paramTextureAtlas) {
/* 112 */     Array array = paramTextureAtlas.getRegions(); byte b; int i;
/* 113 */     for (b = 0, i = array.size; b < i; b++) {
/*     */       TextureAtlas.AtlasRegion atlasRegion;
/* 115 */       String str = (atlasRegion = (TextureAtlas.AtlasRegion)array.get(b)).name;
/* 116 */       if (atlasRegion.index != -1) {
/* 117 */         str = str + "_" + atlasRegion.index;
/*     */       }
/* 119 */       add(str, atlasRegion, TextureRegion.class);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void add(String paramString, Object paramObject) {
/* 124 */     add(paramString, paramObject, paramObject.getClass());
/*     */   }
/*     */   
/*     */   public void add(String paramString, Object paramObject, Class<TextureRegion> paramClass) {
/* 128 */     if (paramString == null) throw new IllegalArgumentException("name cannot be null."); 
/* 129 */     if (paramObject == null) throw new IllegalArgumentException("resource cannot be null."); 
/*     */     ObjectMap objectMap;
/* 131 */     if ((objectMap = (ObjectMap)this.resources.get(paramClass)) == null) {
/* 132 */       objectMap = new ObjectMap((paramClass == TextureRegion.class || paramClass == Drawable.class || paramClass == Sprite.class) ? 256 : 64);
/* 133 */       this.resources.put(paramClass, objectMap);
/*     */     } 
/* 135 */     objectMap.put(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void remove(String paramString, Class paramClass) {
/* 139 */     if (paramString == null) throw new IllegalArgumentException("name cannot be null."); 
/*     */     ObjectMap objectMap;
/* 141 */     (objectMap = (ObjectMap)this.resources.get(paramClass)).remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T get(Class<T> paramClass) {
/* 147 */     return get("default", paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T get(String paramString, Class<T> paramClass) {
/* 153 */     if (paramString == null) throw new IllegalArgumentException("name cannot be null."); 
/* 154 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null.");
/*     */     
/* 156 */     if (paramClass == Drawable.class) return (T)getDrawable(paramString); 
/* 157 */     if (paramClass == TextureRegion.class) return (T)getRegion(paramString); 
/* 158 */     if (paramClass == NinePatch.class) return (T)getPatch(paramString); 
/* 159 */     if (paramClass == Sprite.class) return (T)getSprite(paramString);
/*     */     
/*     */     ObjectMap objectMap;
/* 162 */     if ((objectMap = (ObjectMap)this.resources.get(paramClass)) == null) throw new GdxRuntimeException("No " + paramClass.getName() + " registered with name: " + paramString); 
/*     */     Object object;
/* 164 */     if ((object = objectMap.get(paramString)) == null) throw new GdxRuntimeException("No " + paramClass.getName() + " registered with name: " + paramString); 
/* 165 */     return (T)object;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public <T> T optional(String paramString, Class<T> paramClass) {
/* 171 */     if (paramString == null) throw new IllegalArgumentException("name cannot be null."); 
/* 172 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*     */     ObjectMap objectMap;
/* 174 */     if ((objectMap = (ObjectMap)this.resources.get(paramClass)) == null) return null; 
/* 175 */     return (T)objectMap.get(paramString);
/*     */   }
/*     */   
/*     */   public boolean has(String paramString, Class paramClass) {
/*     */     ObjectMap objectMap;
/* 180 */     if ((objectMap = (ObjectMap)this.resources.get(paramClass)) == null) return false; 
/* 181 */     return objectMap.containsKey(paramString);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public <T> ObjectMap<String, T> getAll(Class<T> paramClass) {
/* 186 */     return (ObjectMap<String, T>)this.resources.get(paramClass);
/*     */   }
/*     */   
/*     */   public Color getColor(String paramString) {
/* 190 */     return get(paramString, Color.class);
/*     */   }
/*     */   
/*     */   public BitmapFont getFont(String paramString) {
/* 194 */     return get(paramString, BitmapFont.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegion getRegion(String paramString) {
/*     */     TextureRegion textureRegion2;
/* 201 */     if ((textureRegion2 = optional(paramString, TextureRegion.class)) != null) return textureRegion2;
/*     */     
/*     */     Texture texture;
/* 204 */     if ((texture = optional(paramString, Texture.class)) == null) throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + paramString); 
/* 205 */     TextureRegion textureRegion1 = new TextureRegion(texture);
/* 206 */     add(paramString, textureRegion1, TextureRegion.class);
/* 207 */     return textureRegion1;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Array<TextureRegion> getRegions(String paramString) {
/* 212 */     Array<TextureRegion> array = null;
/* 213 */     byte b = 0;
/* 214 */     b++; TextureRegion textureRegion;
/* 215 */     if ((textureRegion = optional(paramString + "_" + Character.MIN_VALUE, TextureRegion.class)) != null) {
/* 216 */       array = new Array();
/* 217 */       while (textureRegion != null) {
/* 218 */         array.add(textureRegion);
/* 219 */         textureRegion = optional(paramString + "_" + b++, TextureRegion.class);
/*     */       } 
/*     */     } 
/* 222 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TiledDrawable getTiledDrawable(String paramString) {
/*     */     TiledDrawable tiledDrawable;
/* 229 */     if ((tiledDrawable = optional(paramString, TiledDrawable.class)) != null) return tiledDrawable;
/*     */ 
/*     */     
/* 232 */     (tiledDrawable = new TiledDrawable(getRegion(paramString))).setName(paramString);
/* 233 */     if (this.scale != 1.0F) {
/* 234 */       scale((Drawable)tiledDrawable);
/* 235 */       tiledDrawable.setScale(this.scale);
/*     */     } 
/* 237 */     add(paramString, tiledDrawable, TiledDrawable.class);
/* 238 */     return tiledDrawable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NinePatch getPatch(String paramString) {
/*     */     NinePatch ninePatch;
/* 246 */     if ((ninePatch = optional(paramString, NinePatch.class)) != null) return ninePatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 253 */       ninePatch = new NinePatch(textureRegion, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]); TextureRegion textureRegion;
/*     */       int[] arrayOfInt;
/* 255 */       if (textureRegion = getRegion(paramString) instanceof TextureAtlas.AtlasRegion && (arrayOfInt = ((TextureAtlas.AtlasRegion)textureRegion).findValue("split")) != null && (arrayOfInt = ((TextureAtlas.AtlasRegion)textureRegion).findValue("pad")) != null) ninePatch.setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
/*     */ 
/*     */       
/* 258 */       if (ninePatch == null) ninePatch = new NinePatch(textureRegion); 
/* 259 */       if (this.scale != 1.0F) ninePatch.scale(this.scale, this.scale); 
/* 260 */       add(paramString, ninePatch, NinePatch.class);
/* 261 */       return ninePatch;
/* 262 */     } catch (GdxRuntimeException gdxRuntimeException) {
/* 263 */       throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sprite getSprite(String paramString) {
/*     */     Sprite sprite;
/* 272 */     if ((sprite = optional(paramString, Sprite.class)) != null) return sprite;  try {
/*     */       TextureAtlas.AtlasSprite atlasSprite; Sprite sprite1;
/*     */       TextureRegion textureRegion;
/*     */       TextureAtlas.AtlasRegion atlasRegion;
/* 276 */       if (textureRegion = getRegion(paramString) instanceof TextureAtlas.AtlasRegion && (
/*     */         
/* 278 */         (atlasRegion = (TextureAtlas.AtlasRegion)textureRegion).rotate || atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight)) {
/* 279 */         atlasSprite = new TextureAtlas.AtlasSprite(atlasRegion);
/*     */       }
/* 281 */       if (atlasSprite == null) sprite1 = new Sprite(textureRegion); 
/* 282 */       if (this.scale != 1.0F) sprite1.setSize(sprite1.getWidth() * this.scale, sprite1.getHeight() * this.scale); 
/* 283 */       add(paramString, sprite1, Sprite.class);
/* 284 */       return sprite1;
/* 285 */     } catch (GdxRuntimeException gdxRuntimeException) {
/* 286 */       throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Drawable getDrawable(String paramString) {
/*     */     TextureRegionDrawable textureRegionDrawable;
/*     */     SpriteDrawable spriteDrawable;
/*     */     Drawable drawable;
/* 294 */     if ((drawable = optional(paramString, Drawable.class)) != null) return drawable;
/*     */ 
/*     */     
/*     */     try {
/*     */       TextureRegion textureRegion;
/* 299 */       if (textureRegion = getRegion(paramString) instanceof TextureAtlas.AtlasRegion) {
/*     */         TextureAtlas.AtlasRegion atlasRegion;
/* 301 */         if ((atlasRegion = (TextureAtlas.AtlasRegion)textureRegion).findValue("split") != null) {
/* 302 */           NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getPatch(paramString));
/* 303 */         } else if (atlasRegion.rotate || atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
/* 304 */           spriteDrawable = new SpriteDrawable(getSprite(paramString));
/*     */         } 
/* 306 */       }  if (spriteDrawable == null) {
/* 307 */         textureRegionDrawable = new TextureRegionDrawable(textureRegion);
/* 308 */         if (this.scale != 1.0F) scale((Drawable)textureRegionDrawable); 
/*     */       } 
/* 310 */     } catch (GdxRuntimeException gdxRuntimeException) {}
/*     */ 
/*     */ 
/*     */     
/* 314 */     if (textureRegionDrawable == null) {
/*     */       NinePatch ninePatch;
/* 316 */       if ((ninePatch = optional(paramString, NinePatch.class)) != null) {
/* 317 */         NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(ninePatch);
/*     */       } else {
/*     */         Sprite sprite;
/* 320 */         if ((sprite = optional(paramString, Sprite.class)) != null) {
/* 321 */           spriteDrawable = new SpriteDrawable(sprite);
/*     */         } else {
/* 323 */           throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + paramString);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 328 */     if (spriteDrawable instanceof BaseDrawable) ((BaseDrawable)spriteDrawable).setName(paramString);
/*     */     
/* 330 */     add(paramString, spriteDrawable, Drawable.class);
/* 331 */     return (Drawable)spriteDrawable;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public String find(Object paramObject) {
/* 337 */     if (paramObject == null) throw new IllegalArgumentException("style cannot be null."); 
/*     */     ObjectMap objectMap;
/* 339 */     if ((objectMap = (ObjectMap)this.resources.get(paramObject.getClass())) == null) return null; 
/* 340 */     return (String)objectMap.findKey(paramObject, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable newDrawable(String paramString) {
/* 345 */     return newDrawable(getDrawable(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable newDrawable(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 350 */     return newDrawable(getDrawable(paramString), new Color(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable newDrawable(String paramString, Color paramColor) {
/* 355 */     return newDrawable(getDrawable(paramString), paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable newDrawable(Drawable paramDrawable) {
/* 360 */     if (paramDrawable instanceof TiledDrawable) return (Drawable)new TiledDrawable((TextureRegionDrawable)paramDrawable); 
/* 361 */     if (paramDrawable instanceof TextureRegionDrawable) return (Drawable)new TextureRegionDrawable((TextureRegionDrawable)paramDrawable); 
/* 362 */     if (paramDrawable instanceof NinePatchDrawable) return (Drawable)new NinePatchDrawable((NinePatchDrawable)paramDrawable); 
/* 363 */     if (paramDrawable instanceof SpriteDrawable) return (Drawable)new SpriteDrawable((SpriteDrawable)paramDrawable); 
/* 364 */     throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + paramDrawable.getClass());
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable newDrawable(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 369 */     return newDrawable(paramDrawable, new Color(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable newDrawable(Drawable paramDrawable, Color paramColor) {
/*     */     SpriteDrawable spriteDrawable;
/* 375 */     if (paramDrawable instanceof TextureRegionDrawable) {
/* 376 */       Drawable drawable = ((TextureRegionDrawable)paramDrawable).tint(paramColor);
/* 377 */     } else if (paramDrawable instanceof NinePatchDrawable) {
/* 378 */       NinePatchDrawable ninePatchDrawable = ((NinePatchDrawable)paramDrawable).tint(paramColor);
/* 379 */     } else if (paramDrawable instanceof SpriteDrawable) {
/* 380 */       spriteDrawable = ((SpriteDrawable)paramDrawable).tint(paramColor);
/*     */     } else {
/* 382 */       throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + paramDrawable.getClass());
/*     */     } 
/* 384 */     if (spriteDrawable instanceof BaseDrawable) {
/* 385 */       BaseDrawable baseDrawable = (BaseDrawable)spriteDrawable;
/* 386 */       if (paramDrawable instanceof BaseDrawable) {
/* 387 */         baseDrawable.setName(((BaseDrawable)paramDrawable).getName() + " (" + paramColor + ")");
/*     */       } else {
/* 389 */         baseDrawable.setName(" (" + paramColor + ")");
/*     */       } 
/*     */     } 
/* 392 */     return (Drawable)spriteDrawable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void scale(Drawable paramDrawable) {
/* 399 */     paramDrawable.setLeftWidth(paramDrawable.getLeftWidth() * this.scale);
/* 400 */     paramDrawable.setRightWidth(paramDrawable.getRightWidth() * this.scale);
/* 401 */     paramDrawable.setBottomHeight(paramDrawable.getBottomHeight() * this.scale);
/* 402 */     paramDrawable.setTopHeight(paramDrawable.getTopHeight() * this.scale);
/* 403 */     paramDrawable.setMinWidth(paramDrawable.getMinWidth() * this.scale);
/* 404 */     paramDrawable.setMinHeight(paramDrawable.getMinHeight() * this.scale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat) {
/* 414 */     this.scale = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabled(Actor paramActor, boolean paramBoolean) {
/*     */     Method method2;
/* 424 */     if ((method2 = findMethod(paramActor.getClass(), "getStyle")) == null)
/*     */       return; 
/*     */     try {
/* 427 */       object = method2.invoke(paramActor, new Object[0]);
/* 428 */     } catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */     
/*     */     String str;
/* 433 */     if ((str = find(object)) == null)
/* 434 */       return;  str = str.replace("-disabled", "") + (paramBoolean ? "" : "-disabled");
/* 435 */     Object object = get(str, object.getClass());
/*     */     
/*     */     Method method1;
/* 438 */     if ((method1 = findMethod(paramActor.getClass(), "setStyle")) == null)
/*     */       return;  try {
/* 440 */       method1.invoke(paramActor, new Object[] { object }); return;
/* 441 */     } catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   @Null
/*     */   public TextureAtlas getAtlas() {
/* 447 */     return this.atlas;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 452 */     if (this.atlas != null) this.atlas.dispose(); 
/* 453 */     for (ObjectMap.Values<ObjectMap> values = this.resources.values().iterator(); values.hasNext();) {
/* 454 */       for (ObjectMap.Values<Object> values1 = (objectMap = values.next()).values().iterator(); values1.hasNext();) {
/* 455 */         if (disposable = (Disposable)values1.next() instanceof Disposable) ((Disposable)disposable).dispose(); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   protected Json getJsonLoader(final FileHandle skinFile) {
/* 460 */     final Skin skin = this;
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
/*     */     Json json;
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
/* 498 */     (json = new Json() { private static final String parentFieldName = "parent"; public <T> T readValue(Class<T> param1Class, Class param1Class1, JsonValue param1JsonValue) { if (param1JsonValue != null && param1JsonValue.isString() && !ClassReflection.isAssignableFrom(CharSequence.class, param1Class)) return Skin.this.get(param1JsonValue.asString(), param1Class);  return (T)super.readValue(param1Class, param1Class1, param1JsonValue); } protected boolean ignoreUnknownField(Class param1Class, String param1String) { return param1String.equals("parent"); } public void readFields(Object param1Object, JsonValue param1JsonValue) { if (param1JsonValue.has("parent")) { String str = (String)readValue("parent", String.class, param1JsonValue); Class<?> clazz = param1Object.getClass(); while (true) { try { copyFields(Skin.this.get(str, clazz), param1Object); break; } catch (GdxRuntimeException gdxRuntimeException) { if ((clazz = clazz.getSuperclass()) == Object.class) { (param1Object = new SerializationException("Unable to find parent resource with name: " + str)).addTrace(param1JsonValue.child.trace()); throw param1Object; }  }  }  }  super.readFields(param1Object, param1JsonValue); } }).setTypeName(null);
/* 499 */     json.setUsePrototypes(false);
/*     */     
/* 501 */     json.setSerializer(Skin.class, (Json.Serializer)new Json.ReadOnlySerializer<Skin>() {
/*     */           public Skin read(Json param1Json, JsonValue param1JsonValue, Class param1Class) {
/* 503 */             for (param1JsonValue = param1JsonValue.child; param1JsonValue != null; param1JsonValue = param1JsonValue.next) {
/*     */               
/*     */               try {
/* 506 */                 if ((param1Class = param1Json.getClass(param1JsonValue.name())) == null) param1Class = ClassReflection.forName(param1JsonValue.name()); 
/* 507 */                 readNamedObjects(param1Json, param1Class, param1JsonValue);
/* 508 */               } catch (ReflectionException reflectionException) {
/* 509 */                 throw new SerializationException(reflectionException);
/*     */               } 
/*     */             } 
/* 512 */             return skin;
/*     */           }
/*     */           
/*     */           private void readNamedObjects(Json param1Json, Class<Skin.TintedDrawable> param1Class, JsonValue param1JsonValue) {
/* 516 */             Class<Drawable> clazz = (Class<Drawable>)((param1Class == Skin.TintedDrawable.class) ? Drawable.class : param1Class);
/* 517 */             for (param1JsonValue = param1JsonValue.child; param1JsonValue != null; param1JsonValue = param1JsonValue.next) {
/*     */               Object object;
/* 519 */               if ((object = param1Json.readValue(param1Class, param1JsonValue)) != null) {
/*     */                 try {
/* 521 */                   Skin.this.add(param1JsonValue.name, object, clazz);
/* 522 */                   if (clazz != Drawable.class && ClassReflection.isAssignableFrom(Drawable.class, clazz))
/* 523 */                     Skin.this.add(param1JsonValue.name, object, Drawable.class); 
/* 524 */                 } catch (Exception exception) {
/* 525 */                   throw new SerializationException("Error reading " + 
/* 526 */                       ClassReflection.getSimpleName(param1Class) + ": " + param1JsonValue.name, exception);
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           }
/*     */         });
/* 532 */     json.setSerializer(BitmapFont.class, (Json.Serializer)new Json.ReadOnlySerializer<BitmapFont>() {
/*     */           public BitmapFont read(Json param1Json, JsonValue param1JsonValue, Class param1Class) {
/* 534 */             String str = (String)param1Json.readValue("file", String.class, param1JsonValue);
/* 535 */             float f = ((Float)param1Json.readValue("scaledSize", float.class, Float.valueOf(-1.0F), param1JsonValue)).floatValue();
/* 536 */             Boolean bool2 = (Boolean)param1Json.readValue("flip", Boolean.class, Boolean.FALSE, param1JsonValue);
/* 537 */             Boolean bool3 = (Boolean)param1Json.readValue("markupEnabled", Boolean.class, Boolean.FALSE, param1JsonValue);
/* 538 */             Boolean bool1 = (Boolean)param1Json.readValue("useIntegerPositions", Boolean.class, Boolean.TRUE, param1JsonValue);
/*     */             
/*     */             FileHandle fileHandle;
/* 541 */             if (!(fileHandle = skinFile.parent().child(str)).exists()) fileHandle = Gdx.files.internal(str); 
/* 542 */             if (!fileHandle.exists()) throw new SerializationException("Font file not found: " + fileHandle);
/*     */ 
/*     */             
/* 545 */             str = fileHandle.nameWithoutExtension();
/*     */             try {
/*     */               BitmapFont bitmapFont;
/*     */               Array<TextureRegion> array;
/* 549 */               if ((array = skin.getRegions(str)) != null) {
/* 550 */                 bitmapFont = new BitmapFont(new BitmapFont.BitmapFontData(fileHandle, bool2.booleanValue()), array, true);
/*     */               } else {
/*     */                 TextureRegion textureRegion;
/* 553 */                 if ((textureRegion = skin.optional((String)bitmapFont, TextureRegion.class)) != null) {
/* 554 */                   bitmapFont = new BitmapFont(fileHandle, textureRegion, bool2.booleanValue());
/*     */                 } else {
/*     */                   FileHandle fileHandle1;
/* 557 */                   if ((fileHandle1 = fileHandle.parent().child(bitmapFont + ".png")).exists()) {
/* 558 */                     BitmapFont bitmapFont1 = new BitmapFont(fileHandle, fileHandle1, bool2.booleanValue());
/*     */                   } else {
/* 560 */                     bitmapFont = new BitmapFont(fileHandle, bool2.booleanValue());
/*     */                   } 
/*     */                 } 
/* 563 */               }  (bitmapFont.getData()).markupEnabled = bool3.booleanValue();
/* 564 */               bitmapFont.setUseIntegerPositions(bool1.booleanValue());
/*     */               
/* 566 */               if (f != -1.0F) bitmapFont.getData().setScale(f / bitmapFont.getCapHeight()); 
/* 567 */               return bitmapFont;
/* 568 */             } catch (RuntimeException runtimeException) {
/* 569 */               throw new SerializationException("Error loading bitmap font: " + fileHandle, runtimeException);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 574 */     json.setSerializer(Color.class, (Json.Serializer)new Json.ReadOnlySerializer<Color>() {
/*     */           public Color read(Json param1Json, JsonValue param1JsonValue, Class param1Class) {
/* 576 */             if (param1JsonValue.isString()) return Skin.this.<Color>get(param1JsonValue.asString(), Color.class); 
/*     */             String str;
/* 578 */             if ((str = (String)param1Json.readValue("hex", String.class, null, param1JsonValue)) != null) return Color.valueOf(str); 
/* 579 */             float f2 = ((Float)param1Json.readValue("r", float.class, Float.valueOf(0.0F), param1JsonValue)).floatValue();
/* 580 */             float f3 = ((Float)param1Json.readValue("g", float.class, Float.valueOf(0.0F), param1JsonValue)).floatValue();
/* 581 */             float f4 = ((Float)param1Json.readValue("b", float.class, Float.valueOf(0.0F), param1JsonValue)).floatValue();
/* 582 */             float f1 = ((Float)param1Json.readValue("a", float.class, Float.valueOf(1.0F), param1JsonValue)).floatValue();
/* 583 */             return new Color(f2, f3, f4, f1);
/*     */           }
/*     */         });
/*     */     
/* 587 */     json.setSerializer(TintedDrawable.class, (Json.Serializer)new Json.ReadOnlySerializer() {
/*     */           public Object read(Json param1Json, JsonValue param1JsonValue, Class param1Class) {
/* 589 */             String str = (String)param1Json.readValue("name", String.class, param1JsonValue);
/*     */             Color color;
/* 591 */             if ((color = (Color)param1Json.readValue("color", Color.class, param1JsonValue)) == null) throw new SerializationException("TintedDrawable missing color: " + param1JsonValue); 
/*     */             Drawable drawable;
/* 593 */             if (drawable = Skin.this.newDrawable(str, color) instanceof BaseDrawable) {
/*     */               BaseDrawable baseDrawable;
/* 595 */               (baseDrawable = (BaseDrawable)drawable).setName(param1JsonValue.name + " (" + str + ", " + color + ")");
/*     */             } 
/* 597 */             return drawable;
/*     */           }
/*     */         });
/*     */     
/* 601 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.jsonClassTags.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 602 */       json.addClassTag((String)entry.key, (Class)entry.value); }
/*     */     
/* 604 */     return json;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap<String, Class> getJsonClassTags() {
/* 611 */     return this.jsonClassTags;
/*     */   }
/*     */   
/* 614 */   private static final Class[] defaultTagClasses = new Class[] { BitmapFont.class, Color.class, TintedDrawable.class, NinePatchDrawable.class, SpriteDrawable.class, TextureRegionDrawable.class, TiledDrawable.class, Button.ButtonStyle.class, CheckBox.CheckBoxStyle.class, ImageButton.ImageButtonStyle.class, ImageTextButton.ImageTextButtonStyle.class, Label.LabelStyle.class, List.ListStyle.class, ProgressBar.ProgressBarStyle.class, ScrollPane.ScrollPaneStyle.class, SelectBox.SelectBoxStyle.class, Slider.SliderStyle.class, SplitPane.SplitPaneStyle.class, TextButton.TextButtonStyle.class, TextField.TextFieldStyle.class, TextTooltip.TextTooltipStyle.class, Touchpad.TouchpadStyle.class, Tree.TreeStyle.class, Window.WindowStyle.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   private static Method findMethod(Class paramClass, String paramString) {
/* 623 */     Method[] arrayOfMethod = ClassReflection.getMethods(paramClass); byte b; int i;
/* 624 */     for (b = 0, i = arrayOfMethod.length; b < i; b++) {
/*     */       Method method;
/* 626 */       if ((method = arrayOfMethod[b]).getName().equals(paramString)) return method; 
/*     */     } 
/* 628 */     return null;
/*     */   }
/*     */   
/*     */   public static class TintedDrawable {
/*     */     public String name;
/*     */     public Color color;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Skin.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */