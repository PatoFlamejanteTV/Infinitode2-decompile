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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapObjects
/*     */   implements Iterable<MapObject>
/*     */ {
/*  31 */   private Array<MapObject> objects = new Array();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapObject get(int paramInt) {
/*  37 */     return (MapObject)this.objects.get(paramInt);
/*     */   }
/*     */   
/*     */   public MapObject get(String paramString) {
/*     */     byte b;
/*     */     int i;
/*  43 */     for (b = 0, i = this.objects.size; b < i; b++) {
/*  44 */       MapObject mapObject = (MapObject)this.objects.get(b);
/*  45 */       if (paramString.equals(mapObject.getName())) {
/*  46 */         return mapObject;
/*     */       }
/*     */     } 
/*  49 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIndex(String paramString) {
/*  54 */     return getIndex(get(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIndex(MapObject paramMapObject) {
/*  59 */     return this.objects.indexOf(paramMapObject, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCount() {
/*  64 */     return this.objects.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(MapObject paramMapObject) {
/*  69 */     this.objects.add(paramMapObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(int paramInt) {
/*  74 */     this.objects.removeIndex(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(MapObject paramMapObject) {
/*  79 */     this.objects.removeValue(paramMapObject, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends MapObject> Array<T> getByType(Class<T> paramClass) {
/*  85 */     return getByType(paramClass, new Array());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends MapObject> Array<T> getByType(Class<T> paramClass, Array<T> paramArray) {
/*  92 */     paramArray.clear(); byte b; int i;
/*  93 */     for (b = 0, i = this.objects.size; b < i; b++) {
/*  94 */       MapObject mapObject = (MapObject)this.objects.get(b);
/*  95 */       if (ClassReflection.isInstance(paramClass, mapObject)) {
/*  96 */         paramArray.add(mapObject);
/*     */       }
/*     */     } 
/*  99 */     return paramArray;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<MapObject> iterator() {
/* 105 */     return (Iterator<MapObject>)this.objects.iterator();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\MapObjects.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */