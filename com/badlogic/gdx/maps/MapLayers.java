/*     */ package com.badlogic.gdx.maps;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ import java.util.Iterator;
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
/*     */ public class MapLayers
/*     */   implements Iterable<MapLayer>
/*     */ {
/*  26 */   private Array<MapLayer> layers = new Array();
/*     */ 
/*     */ 
/*     */   
/*     */   public MapLayer get(int paramInt) {
/*  31 */     return (MapLayer)this.layers.get(paramInt);
/*     */   }
/*     */   
/*     */   public MapLayer get(String paramString) {
/*     */     byte b;
/*     */     int i;
/*  37 */     for (b = 0, i = this.layers.size; b < i; b++) {
/*  38 */       MapLayer mapLayer = (MapLayer)this.layers.get(b);
/*  39 */       if (paramString.equals(mapLayer.getName())) {
/*  40 */         return mapLayer;
/*     */       }
/*     */     } 
/*  43 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIndex(String paramString) {
/*  48 */     return getIndex(get(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIndex(MapLayer paramMapLayer) {
/*  53 */     return this.layers.indexOf(paramMapLayer, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCount() {
/*  58 */     return this.layers.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(MapLayer paramMapLayer) {
/*  63 */     this.layers.add(paramMapLayer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(int paramInt) {
/*  68 */     this.layers.removeIndex(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(MapLayer paramMapLayer) {
/*  73 */     this.layers.removeValue(paramMapLayer, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  78 */     return this.layers.size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends MapLayer> Array<T> getByType(Class<T> paramClass) {
/*  84 */     return getByType(paramClass, new Array());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends MapLayer> Array<T> getByType(Class<T> paramClass, Array<T> paramArray) {
/*  91 */     paramArray.clear(); byte b; int i;
/*  92 */     for (b = 0, i = this.layers.size; b < i; b++) {
/*  93 */       MapLayer mapLayer = (MapLayer)this.layers.get(b);
/*  94 */       if (ClassReflection.isInstance(paramClass, mapLayer)) {
/*  95 */         paramArray.add(mapLayer);
/*     */       }
/*     */     } 
/*  98 */     return paramArray;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<MapLayer> iterator() {
/* 104 */     return (Iterator<MapLayer>)this.layers.iterator();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\MapLayers.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */