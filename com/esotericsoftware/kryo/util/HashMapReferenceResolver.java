/*    */ package com.esotericsoftware.kryo.util;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.ReferenceResolver;
/*    */ import java.util.ArrayList;
/*    */ import java.util.IdentityHashMap;
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
/*    */ public class HashMapReferenceResolver
/*    */   implements ReferenceResolver
/*    */ {
/*    */   protected Kryo kryo;
/* 34 */   protected final IdentityHashMap<Object, Integer> writtenObjects = new IdentityHashMap<>();
/* 35 */   protected final ArrayList readObjects = new ArrayList();
/*    */   
/*    */   public void setKryo(Kryo paramKryo) {
/* 38 */     this.kryo = paramKryo;
/*    */   }
/*    */   
/*    */   public int addWrittenObject(Object paramObject) {
/* 42 */     int i = this.writtenObjects.size();
/* 43 */     this.writtenObjects.put(paramObject, Integer.valueOf(i));
/* 44 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getWrittenId(Object paramObject) {
/* 49 */     if ((paramObject = this.writtenObjects.get(paramObject)) == null) return -1; 
/* 50 */     return paramObject.intValue();
/*    */   }
/*    */   
/*    */   public int nextReadId(Class paramClass) {
/* 54 */     int i = this.readObjects.size();
/* 55 */     this.readObjects.add(null);
/* 56 */     return i;
/*    */   }
/*    */   
/*    */   public void setReadObject(int paramInt, Object paramObject) {
/* 60 */     this.readObjects.set(paramInt, paramObject);
/*    */   }
/*    */   
/*    */   public Object getReadObject(Class paramClass, int paramInt) {
/* 64 */     return this.readObjects.get(paramInt);
/*    */   }
/*    */   
/*    */   public void reset() {
/* 68 */     this.readObjects.clear();
/* 69 */     this.writtenObjects.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean useReferences(Class paramClass) {
/* 74 */     return (!Util.isWrapperClass(paramClass) && !Util.isEnum(paramClass));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\HashMapReferenceResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */