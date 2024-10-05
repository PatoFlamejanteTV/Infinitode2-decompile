/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.DelegatingNodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.dependency.Dependent;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.function.Function;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DelegatingNodeRendererFactoryWrapper
/*    */   implements DelegatingNodeRendererFactory, Dependent, Function<DataHolder, NodeRenderer>
/*    */ {
/*    */   private final NodeRendererFactory nodeRendererFactory;
/*    */   private List<DelegatingNodeRendererFactoryWrapper> nodeRenderers;
/* 22 */   private Set<Class<?>> myDelegates = null;
/*    */   
/*    */   public DelegatingNodeRendererFactoryWrapper(List<DelegatingNodeRendererFactoryWrapper> paramList, NodeRendererFactory paramNodeRendererFactory) {
/* 25 */     this.nodeRendererFactory = paramNodeRendererFactory;
/* 26 */     this.nodeRenderers = paramList;
/*    */   }
/*    */ 
/*    */   
/*    */   public NodeRenderer apply(DataHolder paramDataHolder) {
/* 31 */     return this.nodeRendererFactory.apply(paramDataHolder);
/*    */   }
/*    */   
/*    */   public NodeRendererFactory getFactory() {
/* 35 */     return this.nodeRendererFactory;
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getDelegates() {
/* 40 */     return (this.nodeRendererFactory instanceof DelegatingNodeRendererFactory) ? ((DelegatingNodeRendererFactory)this.nodeRendererFactory).getDelegates() : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Set<Class<?>> getAfterDependents() {
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getBeforeDependents() {
/* 50 */     if (this.myDelegates == null && this.nodeRenderers != null) {
/*    */       Set<Class<?>> set;
/* 52 */       if ((set = getDelegates()) != null) {
/* 53 */         this.myDelegates = new HashSet<>();
/* 54 */         for (DelegatingNodeRendererFactoryWrapper delegatingNodeRendererFactoryWrapper : this.nodeRenderers) {
/* 55 */           if (set.contains(delegatingNodeRendererFactoryWrapper.getFactory().getClass())) {
/* 56 */             this.myDelegates.add(delegatingNodeRendererFactoryWrapper.getFactory().getClass());
/*    */           }
/*    */         } 
/*    */       } 
/*    */ 
/*    */       
/* 62 */       this.nodeRenderers = null;
/*    */     } 
/* 64 */     return this.myDelegates;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean affectsGlobalScope() {
/* 69 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\DelegatingNodeRendererFactoryWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */