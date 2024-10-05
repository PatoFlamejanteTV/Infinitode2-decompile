/*    */ package net.bytebuddy.build;
/*    */ 
/*    */ import net.bytebuddy.description.type.TypeDescription;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface AndroidDescriptor
/*    */ {
/*    */   TypeScope getTypeScope(TypeDescription paramTypeDescription);
/*    */   
/*    */   public enum TypeScope
/*    */   {
/* 42 */     LOCAL,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     EXTERNAL;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public enum Trivial
/*    */     implements AndroidDescriptor
/*    */   {
/* 58 */     LOCAL((String)AndroidDescriptor.TypeScope.LOCAL),
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 63 */     EXTERNAL((String)AndroidDescriptor.TypeScope.EXTERNAL);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     private final AndroidDescriptor.TypeScope typeScope;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     Trivial(AndroidDescriptor.TypeScope param1TypeScope) {
/* 76 */       this.typeScope = param1TypeScope;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final AndroidDescriptor.TypeScope getTypeScope(TypeDescription param1TypeDescription) {
/* 83 */       return this.typeScope;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\AndroidDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */