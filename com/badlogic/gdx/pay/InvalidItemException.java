/*    */ package com.badlogic.gdx.pay;
/*    */ 
/*    */ 
/*    */ public class InvalidItemException
/*    */   extends GdxPayException
/*    */ {
/*    */   public InvalidItemException() {
/*  8 */     this("");
/*    */   }
/*    */   
/*    */   public InvalidItemException(String paramString) {
/* 12 */     super("Purchase failed, invalid product identifier " + paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\InvalidItemException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */