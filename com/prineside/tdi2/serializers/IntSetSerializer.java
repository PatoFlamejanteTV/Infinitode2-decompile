/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntArray;
/*    */ import com.badlogic.gdx.utils.IntSet;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class IntSetSerializer extends Serializer<IntSet> {
/* 11 */   private static final IntArray a = new IntArray();
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, IntSet paramIntSet) {
/* 15 */     paramOutput.writeVarInt(paramIntSet.size, true);
/* 16 */     IntSet.IntSetIterator intSetIterator = paramIntSet.iterator();
/* 17 */     a.clear();
/* 18 */     while (intSetIterator.hasNext) {
/* 19 */       a.add(intSetIterator.next());
/*    */     }
/* 21 */     a.sort();
/*    */     
/* 23 */     for (byte b = 0; b < a.size; b++) {
/* 24 */       paramOutput.writeInt(a.items[b]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntSet read(Kryo paramKryo, Input paramInput, Class<? extends IntSet> paramClass) {
/* 30 */     int i = paramInput.readVarInt(true);
/* 31 */     IntSet intSet = new IntSet(i);
/* 32 */     paramKryo.reference(intSet);
/* 33 */     for (byte b = 0; b < i; b++) {
/* 34 */       intSet.add(paramInput.readInt());
/*    */     }
/* 36 */     return intSet;
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntSet copy(Kryo paramKryo, IntSet paramIntSet) {
/*    */     IntSet intSet;
/* 42 */     (intSet = new IntSet(paramIntSet.size)).addAll(paramIntSet);
/* 43 */     return intSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\IntSetSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */