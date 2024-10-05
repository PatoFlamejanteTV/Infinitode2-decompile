/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.IntIntMap;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ public final class IntIntMapSerializer
/*    */   extends Serializer<IntIntMap> {
/* 13 */   private static final Array<IntIntMap.Entry> a = new Array(IntIntMap.Entry.class);
/*    */   static {
/* 15 */     b = ((paramEntry1, paramEntry2) -> Integer.compare(paramEntry1.key, paramEntry2.key));
/*    */   }
/*    */   private static final Comparator<IntIntMap.Entry> b;
/*    */   public final void write(Kryo paramKryo, Output paramOutput, IntIntMap paramIntIntMap) {
/* 19 */     int i = paramIntIntMap.size;
/* 20 */     paramOutput.writeVarInt(i, true);
/*    */     
/* 22 */     a.clear();
/*    */     
/* 24 */     for (IntIntMap.Entry entry1 : paramIntIntMap) {
/*    */       IntIntMap.Entry entry2;
/* 26 */       (entry2 = new IntIntMap.Entry()).key = entry1.key;
/* 27 */       entry2.value = entry1.value;
/*    */       
/* 29 */       a.add(entry2);
/*    */     } 
/*    */     
/* 32 */     a.sort(b);
/* 33 */     for (i = 0; i < a.size; i++) {
/* 34 */       IntIntMap.Entry entry = ((IntIntMap.Entry[])a.items)[i];
/*    */       
/* 36 */       paramOutput.writeInt(entry.key);
/* 37 */       paramOutput.writeInt(entry.value);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntIntMap read(Kryo paramKryo, Input paramInput, Class<? extends IntIntMap> paramClass) {
/* 43 */     int i = paramInput.readVarInt(true);
/* 44 */     IntIntMap intIntMap = new IntIntMap(i);
/* 45 */     paramKryo.reference(intIntMap);
/*    */     
/* 47 */     for (byte b = 0; b < i; b++) {
/* 48 */       int j = paramInput.readInt();
/* 49 */       int k = paramInput.readInt();
/* 50 */       intIntMap.put(j, k);
/*    */     } 
/* 52 */     return intIntMap;
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntIntMap copy(Kryo paramKryo, IntIntMap paramIntIntMap) {
/* 57 */     IntIntMap intIntMap = new IntIntMap(paramIntIntMap.size);
/* 58 */     paramKryo.reference(intIntMap);
/* 59 */     intIntMap.putAll(paramIntIntMap);
/* 60 */     return intIntMap;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\IntIntMapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */