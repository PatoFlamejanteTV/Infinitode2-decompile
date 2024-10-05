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
/*    */ public class ListReferenceResolver
/*    */   implements ReferenceResolver
/*    */ {
/*    */   protected Kryo kryo;
/* 34 */   protected final ArrayList seenObjects = new ArrayList();
/*    */   
/*    */   public void setKryo(Kryo paramKryo) {
/* 37 */     this.kryo = paramKryo;
/*    */   }
/*    */   
/*    */   public int addWrittenObject(Object paramObject) {
/* 41 */     int i = this.seenObjects.size();
/* 42 */     this.seenObjects.add(paramObject);
/* 43 */     return i;
/*    */   } public int getWrittenId(Object paramObject) {
/*    */     byte b;
/*    */     int i;
/* 47 */     for (b = 0, i = this.seenObjects.size(); b < i; b++) {
/* 48 */       if (this.seenObjects.get(b) == paramObject) return b; 
/* 49 */     }  return -1;
/*    */   }
/*    */   
/*    */   public int nextReadId(Class paramClass) {
/* 53 */     int i = this.seenObjects.size();
/* 54 */     this.seenObjects.add(null);
/* 55 */     return i;
/*    */   }
/*    */   
/*    */   public void setReadObject(int paramInt, Object paramObject) {
/* 59 */     this.seenObjects.set(paramInt, paramObject);
/*    */   }
/*    */   
/*    */   public Object getReadObject(Class paramClass, int paramInt) {
/* 63 */     return this.seenObjects.get(paramInt);
/*    */   }
/*    */   
/*    */   public void reset() {
/* 67 */     this.seenObjects.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean useReferences(Class paramClass) {
/* 72 */     return (!Util.isWrapperClass(paramClass) && !Util.isEnum(paramClass));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\ListReferenceResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */