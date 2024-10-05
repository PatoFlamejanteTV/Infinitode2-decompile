package com.badlogic.gdx.pay;

public interface PurchaseManager extends InformationFinder {
  String storeName();
  
  void install(PurchaseObserver paramPurchaseObserver, PurchaseManagerConfig paramPurchaseManagerConfig, boolean paramBoolean);
  
  boolean installed();
  
  void dispose();
  
  void purchase(String paramString);
  
  void purchaseRestore();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\PurchaseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */