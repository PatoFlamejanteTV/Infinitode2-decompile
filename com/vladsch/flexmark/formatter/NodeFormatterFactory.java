/*    */ package com.vladsch.flexmark.formatter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.dependency.Dependent;
/*    */ import java.util.Set;
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
/*    */ public interface NodeFormatterFactory
/*    */   extends Dependent
/*    */ {
/*    */   NodeFormatter create(DataHolder paramDataHolder);
/*    */   
/*    */   default Set<Class<?>> getAfterDependents() {
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default Set<Class<?>> getBeforeDependents() {
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean affectsGlobalScope() {
/* 45 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\NodeFormatterFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */