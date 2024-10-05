/*    */ package com.badlogic.gdx.maps;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectMap;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapProperties
/*    */ {
/* 31 */   private ObjectMap<String, Object> properties = new ObjectMap();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean containsKey(String paramString) {
/* 37 */     return this.properties.containsKey(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object get(String paramString) {
/* 43 */     return this.properties.get(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T get(String paramString, Class<T> paramClass) {
/* 52 */     return (T)get(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T get(String paramString, T paramT, Class<T> paramClass) {
/*    */     Object object;
/* 63 */     return (T)(((object = get(paramString)) == null) ? (Object)paramT : object);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void put(String paramString, Object paramObject) {
/* 69 */     this.properties.put(paramString, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void putAll(MapProperties paramMapProperties) {
/* 74 */     this.properties.putAll(paramMapProperties.properties);
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove(String paramString) {
/* 79 */     this.properties.remove(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 84 */     this.properties.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<String> getKeys() {
/* 89 */     return (Iterator<String>)this.properties.keys();
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<Object> getValues() {
/* 94 */     return (Iterator<Object>)this.properties.values();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\MapProperties.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */