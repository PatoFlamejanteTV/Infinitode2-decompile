/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.SharedLibrary;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class MacOSXLibrary
/*    */   extends SharedLibrary.Default
/*    */ {
/*    */   protected MacOSXLibrary(String paramString, long paramLong) {
/* 15 */     super(paramString, paramLong);
/*    */   }
/*    */   
/*    */   public static MacOSXLibrary getWithIdentifier(String paramString) {
/* 19 */     APIUtil.apiLog("Loading library: " + paramString);
/* 20 */     MacOSXLibraryBundle macOSXLibraryBundle = MacOSXLibraryBundle.getWithIdentifier(paramString);
/* 21 */     APIUtil.apiLogMore("Success");
/* 22 */     return macOSXLibraryBundle;
/*    */   }
/*    */   
/*    */   public static MacOSXLibrary create(String paramString) {
/* 26 */     if (paramString.endsWith(".framework"))
/* 27 */       return MacOSXLibraryBundle.create(paramString);  return new MacOSXLibraryDL(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\MacOSXLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */