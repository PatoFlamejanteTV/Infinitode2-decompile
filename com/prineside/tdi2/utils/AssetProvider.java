/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface AssetProvider<T>
/*    */ {
/*    */   T get(String paramString);
/*    */   
/*    */   default T getDefault() {
/* 11 */     return get("default");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\AssetProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */