/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.prineside.tdi2.enums.ResourceType;
/*    */ 
/*    */ public class Resource {
/*    */   public static final String[] NAMES;
/*    */   
/*    */   static {
/*  9 */     (NAMES = new String[ResourceType.values.length])[ResourceType.SCALAR.ordinal()] = "Scalar";
/* 10 */     NAMES[ResourceType.VECTOR.ordinal()] = "Vector";
/* 11 */     NAMES[ResourceType.MATRIX.ordinal()] = "Matrix";
/* 12 */     NAMES[ResourceType.TENSOR.ordinal()] = "Tensor";
/* 13 */     NAMES[ResourceType.INFIAR.ordinal()] = "Infiar";
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 18 */     (TEXTURE_REGION_NAMES = new String[ResourceType.values.length])[ResourceType.SCALAR.ordinal()] = "resource-scalar";
/* 19 */     TEXTURE_REGION_NAMES[ResourceType.VECTOR.ordinal()] = "resource-vector";
/* 20 */     TEXTURE_REGION_NAMES[ResourceType.MATRIX.ordinal()] = "resource-matrix";
/* 21 */     TEXTURE_REGION_NAMES[ResourceType.TENSOR.ordinal()] = "resource-tensor";
/* 22 */     TEXTURE_REGION_NAMES[ResourceType.INFIAR.ordinal()] = "resource-infiar";
/*    */   }
/*    */   
/*    */   public static final String[] TEXTURE_REGION_NAMES;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Resource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */