/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum ResourceType {
/*  7 */   SCALAR,
/*  8 */   VECTOR,
/*  9 */   MATRIX,
/* 10 */   TENSOR,
/* 11 */   INFIAR;
/*    */   public static final MinerType[] toMinerType;
/*    */   
/*    */   static {
/* 15 */     (toMinerType = new MinerType[5])[SCALAR.ordinal()] = MinerType.SCALAR;
/* 16 */     toMinerType[VECTOR.ordinal()] = MinerType.VECTOR;
/* 17 */     toMinerType[MATRIX.ordinal()] = MinerType.MATRIX;
/* 18 */     toMinerType[TENSOR.ordinal()] = MinerType.TENSOR;
/* 19 */     toMinerType[INFIAR.ordinal()] = MinerType.INFIAR;
/*    */ 
/*    */     
/* 22 */     values = values();
/*    */   }
/*    */   
/*    */   public static final ResourceType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\ResourceType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */