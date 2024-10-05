/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResourceData<T>
/*     */   implements Json.Serializable
/*     */ {
/*     */   public static class SaveData
/*     */     implements Json.Serializable
/*     */   {
/*     */     ObjectMap<String, Object> data;
/*     */     IntArray assets;
/*     */     private int loadIndex;
/*     */     protected ResourceData resources;
/*     */     
/*     */     public SaveData() {
/*  60 */       this.data = new ObjectMap();
/*  61 */       this.assets = new IntArray();
/*  62 */       this.loadIndex = 0;
/*     */     }
/*     */     
/*     */     public SaveData(ResourceData param1ResourceData) {
/*  66 */       this.data = new ObjectMap();
/*  67 */       this.assets = new IntArray();
/*  68 */       this.loadIndex = 0;
/*  69 */       this.resources = param1ResourceData;
/*     */     }
/*     */     
/*     */     public <K> void saveAsset(String param1String, Class<K> param1Class) {
/*     */       int i;
/*  74 */       if ((i = this.resources.getAssetData(param1String, param1Class)) == -1) {
/*  75 */         this.resources.sharedAssets.add(new ResourceData.AssetData<>(param1String, param1Class));
/*  76 */         i = this.resources.sharedAssets.size - 1;
/*     */       } 
/*  78 */       this.assets.add(i);
/*     */     }
/*     */     
/*     */     public void save(String param1String, Object param1Object) {
/*  82 */       this.data.put(param1String, param1Object);
/*     */     }
/*     */     
/*     */     public AssetDescriptor loadAsset() {
/*  86 */       if (this.loadIndex == this.assets.size) return null; 
/*  87 */       ResourceData.AssetData assetData = (ResourceData.AssetData)this.resources.sharedAssets.get(this.assets.get(this.loadIndex++));
/*  88 */       return new AssetDescriptor(assetData.filename, assetData.type);
/*     */     }
/*     */     
/*     */     public <K> K load(String param1String) {
/*  92 */       return (K)this.data.get(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(Json param1Json) {
/*  97 */       param1Json.writeValue("data", this.data, ObjectMap.class);
/*  98 */       param1Json.writeValue("indices", this.assets.toArray(), int[].class);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Json param1Json, JsonValue param1JsonValue) {
/* 103 */       this.data = (ObjectMap<String, Object>)param1Json.readValue("data", ObjectMap.class, param1JsonValue);
/* 104 */       this.assets.addAll((int[])param1Json.readValue("indices", int[].class, param1JsonValue));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class AssetData<T>
/*     */     implements Json.Serializable
/*     */   {
/*     */     public String filename;
/*     */     public Class<T> type;
/*     */     
/*     */     public AssetData() {}
/*     */     
/*     */     public AssetData(String param1String, Class<T> param1Class) {
/* 117 */       this.filename = param1String;
/* 118 */       this.type = param1Class;
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(Json param1Json) {
/* 123 */       param1Json.writeValue("filename", this.filename);
/* 124 */       param1Json.writeValue("type", this.type.getName());
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Json param1Json, JsonValue param1JsonValue) {
/* 129 */       this.filename = (String)param1Json.readValue("filename", String.class, param1JsonValue);
/* 130 */       String str = (String)param1Json.readValue("type", String.class, param1JsonValue);
/*     */       try {
/* 132 */         this.type = ClassReflection.forName(str); return;
/* 133 */       } catch (ReflectionException reflectionException) {
/* 134 */         throw new GdxRuntimeException("Class not found: " + str, reflectionException);
/*     */       } 
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
/* 152 */   private ObjectMap<String, SaveData> uniqueData = new ObjectMap();
/* 153 */   private Array<SaveData> data = new Array(true, 3, SaveData.class);
/* 154 */   Array<AssetData> sharedAssets = new Array();
/* 155 */   private int currentLoadIndex = 0;
/*     */   public T resource;
/*     */   
/*     */   public ResourceData(T paramT) {
/* 159 */     this();
/* 160 */     this.resource = paramT;
/*     */   }
/*     */   public ResourceData() {}
/*     */   <K> int getAssetData(String paramString, Class<K> paramClass) {
/* 164 */     byte b = 0;
/* 165 */     for (Array.ArrayIterator<AssetData> arrayIterator = this.sharedAssets.iterator(); arrayIterator.hasNext(); ) {
/* 166 */       AssetData assetData; if ((assetData = arrayIterator.next()).filename.equals(paramString) && assetData.type.equals(paramClass)) {
/* 167 */         return b;
/*     */       }
/* 169 */       b++;
/*     */     } 
/* 171 */     return -1;
/*     */   }
/*     */   
/*     */   public Array<AssetDescriptor> getAssetDescriptors() {
/* 175 */     Array<AssetDescriptor> array = new Array();
/* 176 */     for (Array.ArrayIterator<AssetData> arrayIterator = this.sharedAssets.iterator(); arrayIterator.hasNext(); ) { AssetData assetData = arrayIterator.next();
/* 177 */       array.add(new AssetDescriptor(assetData.filename, assetData.type)); }
/*     */     
/* 179 */     return array;
/*     */   }
/*     */   
/*     */   public Array<AssetData> getAssets() {
/* 183 */     return this.sharedAssets;
/*     */   }
/*     */ 
/*     */   
/*     */   public SaveData createSaveData() {
/* 188 */     SaveData saveData = new SaveData(this);
/* 189 */     this.data.add(saveData);
/* 190 */     return saveData;
/*     */   }
/*     */ 
/*     */   
/*     */   public SaveData createSaveData(String paramString) {
/* 195 */     SaveData saveData = new SaveData(this);
/* 196 */     if (this.uniqueData.containsKey(paramString)) throw new RuntimeException("Key already used, data must be unique, use a different key"); 
/* 197 */     this.uniqueData.put(paramString, saveData);
/* 198 */     return saveData;
/*     */   }
/*     */ 
/*     */   
/*     */   public SaveData getSaveData() {
/* 203 */     return (SaveData)this.data.get(this.currentLoadIndex++);
/*     */   }
/*     */ 
/*     */   
/*     */   public SaveData getSaveData(String paramString) {
/* 208 */     return (SaveData)this.uniqueData.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 213 */     paramJson.writeValue("unique", this.uniqueData, ObjectMap.class);
/* 214 */     paramJson.writeValue("data", this.data, Array.class, SaveData.class);
/* 215 */     paramJson.writeValue("assets", this.sharedAssets.toArray(AssetData.class), AssetData[].class);
/* 216 */     paramJson.writeValue("resource", this.resource, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 221 */     this.uniqueData = (ObjectMap<String, SaveData>)paramJson.readValue("unique", ObjectMap.class, paramJsonValue);
/* 222 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.uniqueData.entries().iterator(); entries.hasNext();) {
/* 223 */       ((SaveData)(entry = entries.next()).value).resources = this;
/*     */     }
/*     */     
/* 226 */     this.data = (Array<SaveData>)paramJson.readValue("data", Array.class, SaveData.class, paramJsonValue);
/* 227 */     for (Array.ArrayIterator<SaveData> arrayIterator = this.data.iterator(); arrayIterator.hasNext();) {
/* 228 */       (saveData = arrayIterator.next()).resources = this;
/*     */     }
/*     */     
/* 231 */     this.sharedAssets.addAll((Array)paramJson.readValue("assets", Array.class, AssetData.class, paramJsonValue));
/* 232 */     this.resource = (T)paramJson.readValue("resource", null, paramJsonValue);
/*     */   }
/*     */   
/*     */   public static interface Configurable<T> {
/*     */     void save(AssetManager param1AssetManager, ResourceData<T> param1ResourceData);
/*     */     
/*     */     void load(AssetManager param1AssetManager, ResourceData<T> param1ResourceData);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ResourceData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */