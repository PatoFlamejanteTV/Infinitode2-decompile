/*    */ package io.github.classgraph;
/*    */ 
/*    */ import java.util.Collection;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModuleInfoList
/*    */   extends MappableInfoList<ModuleInfo>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   ModuleInfoList() {}
/*    */   
/*    */   ModuleInfoList(int paramInt) {
/* 52 */     super(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ModuleInfoList(Collection<ModuleInfo> paramCollection) {
/* 62 */     super(paramCollection);
/*    */   }
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
/*    */   public ModuleInfoList filter(ModuleInfoFilter paramModuleInfoFilter) {
/* 93 */     ModuleInfoList moduleInfoList = new ModuleInfoList();
/* 94 */     for (ModuleInfo moduleInfo : this) {
/* 95 */       if (paramModuleInfoFilter.accept(moduleInfo)) {
/* 96 */         moduleInfoList.add(moduleInfo);
/*    */       }
/*    */     } 
/* 99 */     return moduleInfoList;
/*    */   }
/*    */   
/*    */   @FunctionalInterface
/*    */   public static interface ModuleInfoFilter {
/*    */     boolean accept(ModuleInfo param1ModuleInfo);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ModuleInfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */