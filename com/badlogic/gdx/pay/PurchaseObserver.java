package com.badlogic.gdx.pay;

public interface PurchaseObserver {
  void handleInstall();
  
  void handleInstallError(Throwable paramThrowable);
  
  void handleRestore(Transaction[] paramArrayOfTransaction);
  
  void handleRestoreError(Throwable paramThrowable);
  
  void handlePurchase(Transaction paramTransaction);
  
  void handlePurchaseError(Throwable paramThrowable);
  
  void handlePurchaseCanceled();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\PurchaseObserver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */