/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
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
/*    */ class DelegatingNodeRendererFactoryWrapper
/*    */   implements DelegatingNodeRendererFactory, Dependent, Function<DataHolder, HtmlNodeRenderer>
/*    */ {
/*    */   private final HtmlNodeRendererFactory nodeRendererFactory;
/*    */   private List<DelegatingNodeRendererFactoryWrapper> nodeRenderers;
/* 18 */   private Set<Class<?>> myDelegates = null;
/*    */   
/*    */   public DelegatingNodeRendererFactoryWrapper(List<DelegatingNodeRendererFactoryWrapper> paramList, HtmlNodeRendererFactory paramHtmlNodeRendererFactory) {
/* 21 */     this.nodeRendererFactory = paramHtmlNodeRendererFactory;
/* 22 */     this.nodeRenderers = paramList;
/*    */   }
/*    */ 
/*    */   
/*    */   public HtmlNodeRenderer apply(DataHolder paramDataHolder) {
/* 27 */     return this.nodeRendererFactory.apply(paramDataHolder);
/*    */   }
/*    */   
/*    */   public HtmlNodeRendererFactory getFactory() {
/* 31 */     return this.nodeRendererFactory;
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getDelegates() {
/* 36 */     return (this.nodeRendererFactory instanceof DelegatingNodeRendererFactory) ? ((DelegatingNodeRendererFactory)this.nodeRendererFactory).getDelegates() : null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Set<Class<?>> getAfterDependents() {
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getBeforeDependents() {
/* 48 */     if (this.myDelegates == null && this.nodeRenderers != null) {
/*    */       Set<Class<?>> set;
/* 50 */       if ((set = getDelegates()) != null) {
/* 51 */         this.myDelegates = new HashSet<>();
/* 52 */         for (DelegatingNodeRendererFactoryWrapper delegatingNodeRendererFactoryWrapper : this.nodeRenderers) {
/* 53 */           if (set.contains(delegatingNodeRendererFactoryWrapper.getFactory().getClass())) {
/* 54 */             this.myDelegates.add(delegatingNodeRendererFactoryWrapper.getFactory().getClass());
/*    */           }
/*    */         } 
/*    */       } 
/*    */ 
/*    */       
/* 60 */       this.nodeRenderers = null;
/*    */     } 
/* 62 */     return this.myDelegates;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean affectsGlobalScope() {
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\DelegatingNodeRendererFactoryWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */