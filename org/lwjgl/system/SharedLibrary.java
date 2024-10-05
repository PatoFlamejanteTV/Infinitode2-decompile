/*    */ package org.lwjgl.system;
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
/*    */ public interface SharedLibrary
/*    */   extends FunctionProvider, NativeResource, Pointer
/*    */ {
/*    */   String getName();
/*    */   
/*    */   String getPath();
/*    */   
/*    */   public static abstract class Default
/*    */     extends Pointer.Default
/*    */     implements SharedLibrary
/*    */   {
/*    */     private final String name;
/*    */     
/*    */     protected Default(String param1String, long param1Long) {
/* 28 */       super(param1Long);
/* 29 */       this.name = param1String;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getName() {
/* 34 */       return this.name;
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract class Delegate
/*    */     implements SharedLibrary
/*    */   {
/*    */     protected final SharedLibrary library;
/*    */     
/*    */     protected Delegate(SharedLibrary param1SharedLibrary) {
/* 44 */       this.library = param1SharedLibrary;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getName() {
/* 49 */       return this.library.getName();
/*    */     }
/*    */ 
/*    */     
/*    */     public String getPath() {
/* 54 */       return this.library.getPath();
/*    */     }
/*    */ 
/*    */     
/*    */     public long address() {
/* 59 */       return this.library.address();
/*    */     }
/*    */ 
/*    */     
/*    */     public void free() {
/* 64 */       this.library.free();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\SharedLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */