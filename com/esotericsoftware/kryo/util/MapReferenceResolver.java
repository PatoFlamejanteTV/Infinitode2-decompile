/*    */ package com.esotericsoftware.kryo.util;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.ReferenceResolver;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ public class MapReferenceResolver
/*    */   implements ReferenceResolver
/*    */ {
/*    */   private static final int DEFAULT_CAPACITY = 2048;
/*    */   protected Kryo kryo;
/* 36 */   protected final IdentityObjectIntMap<Object> writtenObjects = new IdentityObjectIntMap();
/* 37 */   protected final ArrayList<Object> readObjects = new ArrayList();
/*    */   
/*    */   private final int maximumCapacity;
/*    */   
/*    */   public MapReferenceResolver() {
/* 42 */     this(2048);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MapReferenceResolver(int paramInt) {
/* 49 */     this.maximumCapacity = paramInt;
/*    */   }
/*    */   
/*    */   public void setKryo(Kryo paramKryo) {
/* 53 */     this.kryo = paramKryo;
/*    */   }
/*    */   
/*    */   public int addWrittenObject(Object paramObject) {
/* 57 */     int i = this.writtenObjects.size;
/* 58 */     this.writtenObjects.put(paramObject, i);
/* 59 */     return i;
/*    */   }
/*    */   
/*    */   public int getWrittenId(Object paramObject) {
/* 63 */     return this.writtenObjects.get(paramObject, -1);
/*    */   }
/*    */   
/*    */   public int nextReadId(Class paramClass) {
/* 67 */     int i = this.readObjects.size();
/* 68 */     this.readObjects.add(null);
/* 69 */     return i;
/*    */   }
/*    */   
/*    */   public void setReadObject(int paramInt, Object paramObject) {
/* 73 */     this.readObjects.set(paramInt, paramObject);
/*    */   }
/*    */   
/*    */   public Object getReadObject(Class paramClass, int paramInt) {
/* 77 */     return this.readObjects.get(paramInt);
/*    */   }
/*    */   
/*    */   public void reset() {
/* 81 */     int i = this.readObjects.size();
/* 82 */     this.readObjects.clear();
/* 83 */     if (i > this.maximumCapacity) {
/* 84 */       this.readObjects.trimToSize();
/* 85 */       this.readObjects.ensureCapacity(this.maximumCapacity);
/*    */     } 
/* 87 */     this.writtenObjects.clear(this.maximumCapacity);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean useReferences(Class paramClass) {
/* 92 */     return (!Util.isWrapperClass(paramClass) && !Util.isEnum(paramClass));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\MapReferenceResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */