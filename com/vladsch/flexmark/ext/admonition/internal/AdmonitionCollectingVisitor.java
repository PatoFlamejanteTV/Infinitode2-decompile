/*    */ package com.vladsch.flexmark.ext.admonition.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.admonition.AdmonitionBlock;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*    */ import java.util.LinkedHashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdmonitionCollectingVisitor
/*    */ {
/*    */   private LinkedHashSet<String> qualifiers;
/* 17 */   private final NodeVisitor myVisitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(AdmonitionBlock.class, this::visit) });
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LinkedHashSet<String> getQualifiers() {
/* 23 */     return this.qualifiers;
/*    */   }
/*    */   
/*    */   public void collect(Node paramNode) {
/* 27 */     this.qualifiers = new LinkedHashSet<>();
/* 28 */     this.myVisitor.visit(paramNode);
/*    */   }
/*    */   
/*    */   public Set<String> collectAndGetQualifiers(Node paramNode) {
/* 32 */     collect(paramNode);
/* 33 */     return this.qualifiers;
/*    */   }
/*    */   
/*    */   void visit(AdmonitionBlock paramAdmonitionBlock) {
/* 37 */     this.qualifiers.add(paramAdmonitionBlock.getInfo().toString());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\admonition\internal\AdmonitionCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */