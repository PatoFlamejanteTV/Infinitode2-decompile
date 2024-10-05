/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.IntFloatMap;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ public final class IntFloatMapSerializer
/*    */   extends Serializer<IntFloatMap> {
/* 13 */   private static final Array<IntFloatMap.Entry> a = new Array(IntFloatMap.Entry.class);
/*    */   static {
/* 15 */     b = ((paramEntry1, paramEntry2) -> Float.compare(paramEntry1.key, paramEntry2.key));
/*    */   }
/*    */   private static final Comparator<IntFloatMap.Entry> b;
/*    */   public final void write(Kryo paramKryo, Output paramOutput, IntFloatMap paramIntFloatMap) {
/* 19 */     int i = paramIntFloatMap.size;
/* 20 */     paramOutput.writeVarInt(i, true);
/*    */     
/* 22 */     a.clear();
/*    */     
/* 24 */     for (IntFloatMap.Entry entry1 : paramIntFloatMap) {
/*    */       IntFloatMap.Entry entry2;
/* 26 */       (entry2 = new IntFloatMap.Entry()).key = entry1.key;
/* 27 */       entry2.value = entry1.value;
/*    */       
/* 29 */       a.add(entry2);
/*    */     } 
/*    */     
/* 32 */     a.sort(b);
/* 33 */     for (i = 0; i < a.size; i++) {
/* 34 */       IntFloatMap.Entry entry = ((IntFloatMap.Entry[])a.items)[i];
/*    */       
/* 36 */       paramOutput.writeInt(entry.key);
/* 37 */       paramOutput.writeFloat(entry.value);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntFloatMap read(Kryo paramKryo, Input paramInput, Class<? extends IntFloatMap> paramClass) {
/* 43 */     int i = paramInput.readVarInt(true);
/* 44 */     IntFloatMap intFloatMap = new IntFloatMap(i);
/* 45 */     paramKryo.reference(intFloatMap);
/*    */     
/* 47 */     for (byte b = 0; b < i; b++) {
/* 48 */       int j = paramInput.readInt();
/* 49 */       float f = paramInput.readFloat();
/* 50 */       intFloatMap.put(j, f);
/*    */     } 
/* 52 */     return intFloatMap;
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntFloatMap copy(Kryo paramKryo, IntFloatMap paramIntFloatMap) {
/* 57 */     IntFloatMap intFloatMap = new IntFloatMap(paramIntFloatMap.size);
/* 58 */     paramKryo.reference(intFloatMap);
/* 59 */     intFloatMap.putAll(paramIntFloatMap);
/* 60 */     return intFloatMap;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\IntFloatMapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */