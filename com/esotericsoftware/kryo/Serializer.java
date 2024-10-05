/*    */ package com.esotericsoftware.kryo;
/*    */ 
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
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
/*    */ public abstract class Serializer<T>
/*    */ {
/*    */   private boolean acceptsNull;
/*    */   private boolean immutable;
/*    */   
/*    */   public Serializer() {}
/*    */   
/*    */   public Serializer(boolean paramBoolean) {
/* 35 */     this.acceptsNull = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Serializer(boolean paramBoolean1, boolean paramBoolean2) {
/* 41 */     this.acceptsNull = paramBoolean1;
/* 42 */     this.immutable = paramBoolean2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void write(Kryo paramKryo, Output paramOutput, T paramT);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getAcceptsNull() {
/* 64 */     return this.acceptsNull;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAcceptsNull(boolean paramBoolean) {
/* 73 */     this.acceptsNull = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean isImmutable() {
/* 77 */     return this.immutable;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setImmutable(boolean paramBoolean) {
/* 83 */     this.immutable = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T copy(Kryo paramKryo, T paramT) {
/* 95 */     if (isImmutable()) return paramT; 
/* 96 */     throw new KryoException("Serializer does not support copy: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\Serializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */