/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class IndependentAttributeProviderFactory
/*    */   implements AttributeProviderFactory
/*    */ {
/*    */   public Set<Class<?>> getAfterDependents() {
/* 11 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getBeforeDependents() {
/* 17 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean affectsGlobalScope() {
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\IndependentAttributeProviderFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */