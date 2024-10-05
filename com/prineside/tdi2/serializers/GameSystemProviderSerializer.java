/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.GameSystem;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ 
/*    */ @Deprecated
/*    */ public class GameSystemProviderSerializer
/*    */   extends Serializer<GameSystemProvider> {
/*    */   public void write(Kryo paramKryo, Output paramOutput, GameSystemProvider paramGameSystemProvider) {
/* 15 */     byte b1 = 0;
/*    */     
/* 17 */     Array array = paramGameSystemProvider.getSystemsOrdered();
/*    */     byte b2;
/* 19 */     for (b2 = 0; b2 < array.size; b2++) {
/*    */       GameSystem gameSystem;
/* 21 */       if ((gameSystem = ((GameSystem[])array.items)[b2]).affectsGameState()) {
/* 22 */         b1++;
/*    */       }
/*    */     } 
/*    */     
/* 26 */     paramOutput.writeByte(b1);
/* 27 */     for (b2 = 0; b2 < array.size; b2++) {
/*    */       GameSystem gameSystem;
/* 29 */       if ((gameSystem = ((GameSystem[])array.items)[b2]).affectsGameState())
/*    */       {
/* 31 */         paramKryo.writeClassAndObject(paramOutput, gameSystem);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public GameSystemProvider read(Kryo paramKryo, Input paramInput, Class<? extends GameSystemProvider> paramClass) {
/* 38 */     GameSystemProvider gameSystemProvider = new GameSystemProvider(new GameSystemProvider.SystemsConfig(GameSystemProvider.SystemsConfig.Setup.GAME, true));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 43 */     byte b = paramInput.readByte();
/* 44 */     for (byte b1 = 0; b1 < b; b1++)
/*    */     {
/* 46 */       gameSystemProvider.addSystem((GameSystem)paramKryo.readClassAndObject(paramInput));
/*    */     }
/* 48 */     return gameSystemProvider;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\GameSystemProviderSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */