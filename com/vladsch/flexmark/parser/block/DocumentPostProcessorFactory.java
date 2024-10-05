/*    */ package com.vladsch.flexmark.parser.block;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DocumentPostProcessorFactory
/*    */   implements PostProcessorFactory
/*    */ {
/*    */   public final Map<Class<?>, Set<Class<?>>> getNodeTypes() {
/* 17 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getAfterDependents() {
/* 23 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getBeforeDependents() {
/* 29 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean affectsGlobalScope() {
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\DocumentPostProcessorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */