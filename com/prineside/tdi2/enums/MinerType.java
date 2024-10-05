/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum MinerType {
/*  7 */   SCALAR,
/*  8 */   VECTOR,
/*  9 */   MATRIX,
/* 10 */   TENSOR,
/* 11 */   INFIAR;
/*    */   public static final ResourceType[] toResourceType;
/*    */   
/*    */   static {
/* 15 */     (toResourceType = new ResourceType[5])[SCALAR.ordinal()] = ResourceType.SCALAR;
/* 16 */     toResourceType[VECTOR.ordinal()] = ResourceType.VECTOR;
/* 17 */     toResourceType[MATRIX.ordinal()] = ResourceType.MATRIX;
/* 18 */     toResourceType[TENSOR.ordinal()] = ResourceType.TENSOR;
/* 19 */     toResourceType[INFIAR.ordinal()] = ResourceType.INFIAR;
/*    */ 
/*    */     
/* 22 */     values = values();
/*    */   }
/*    */   
/*    */   public static final MinerType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\MinerType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */