/*    */ package com.badlogic.gdx.pay;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FetchItemInformationException
/*    */   extends GdxPayException
/*    */ {
/*    */   public FetchItemInformationException() {
/* 13 */     super("Failed to fetch item list - check your connection");
/*    */   }
/*    */   
/*    */   public FetchItemInformationException(String paramString) {
/* 17 */     super("Failed to fetch item list - check your connection (" + paramString + ")");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\FetchItemInformationException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */