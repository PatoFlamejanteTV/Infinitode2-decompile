/*    */ package com.esotericsoftware.kryo;
/*    */ 
/*    */ import com.esotericsoftware.kryo.util.Util;
/*    */ import com.esotericsoftware.minlog.Log;
/*    */ import org.c.a.a;
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
/*    */ public class Registration
/*    */ {
/*    */   private final Class type;
/*    */   private final boolean typeNameAscii;
/*    */   private final int id;
/*    */   private Serializer serializer;
/*    */   private a instantiator;
/*    */   
/*    */   public Registration(Class paramClass, Serializer paramSerializer, int paramInt) {
/* 37 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/* 38 */     if (paramSerializer == null) throw new IllegalArgumentException("serializer cannot be null."); 
/* 39 */     this.type = paramClass;
/* 40 */     this.serializer = paramSerializer;
/* 41 */     this.id = paramInt;
/* 42 */     this.typeNameAscii = Util.isAscii(paramClass.getName());
/*    */   }
/*    */   
/*    */   public Class getType() {
/* 46 */     return this.type;
/*    */   }
/*    */   
/*    */   public boolean isTypeNameAscii() {
/* 50 */     return this.typeNameAscii;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getId() {
/* 56 */     return this.id;
/*    */   }
/*    */   
/*    */   public Serializer getSerializer() {
/* 60 */     return this.serializer;
/*    */   }
/*    */   
/*    */   public void setSerializer(Serializer paramSerializer) {
/* 64 */     if (paramSerializer == null) throw new IllegalArgumentException("serializer cannot be null."); 
/* 65 */     this.serializer = paramSerializer;
/* 66 */     if (Log.TRACE) Log.trace("kryo", "Update registered serializer: " + this.type.getName() + " (" + paramSerializer.getClass().getName() + ")");
/*    */   
/*    */   }
/*    */   
/*    */   public a getInstantiator() {
/* 71 */     return this.instantiator;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setInstantiator(a parama) {
/* 76 */     if (parama == null) throw new IllegalArgumentException("instantiator cannot be null."); 
/* 77 */     this.instantiator = parama;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     return "[" + this.id + ", " + Util.className(this.type) + "]";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\Registration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */