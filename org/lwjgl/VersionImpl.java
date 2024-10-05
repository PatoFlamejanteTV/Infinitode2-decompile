/*    */ package org.lwjgl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class VersionImpl
/*    */ {
/*    */   static String find() {
/*    */     Package package_;
/* 18 */     String str2 = (package_ = Version.class.getPackage()).getSpecificationVersion();
/* 19 */     String str1 = package_.getImplementationVersion();
/* 20 */     if (str2 != null && str1 != null) {
/* 21 */       return Version.createImplementation(str2, str1);
/*    */     }
/*    */ 
/*    */     
/* 25 */     if ((str1 = Version.findImplementationFromManifest()) != null) {
/* 26 */       return str1;
/*    */     }
/*    */     
/* 29 */     return "-snapshot";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\VersionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */