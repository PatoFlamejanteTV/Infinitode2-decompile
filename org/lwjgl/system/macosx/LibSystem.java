/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.SharedLibrary;
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
/*    */ public final class LibSystem
/*    */ {
/* 18 */   private static final SharedLibrary SYSTEM = Library.loadNative(LibSystem.class, "org.lwjgl", "System");
/*    */ 
/*    */   
/*    */   public static SharedLibrary getLibrary() {
/* 22 */     return SYSTEM;
/*    */   }
/*    */   
/*    */   private LibSystem() {
/* 26 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\LibSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */