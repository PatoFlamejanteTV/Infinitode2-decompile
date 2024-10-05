/*    */ package com.vladsch.flexmark.ext.yaml.front.matter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbstractYamlFrontMatterVisitor
/*    */   implements YamlFrontMatterVisitor
/*    */ {
/* 19 */   private final NodeVisitor myVisitor = new NodeVisitor((VisitHandler[])YamlFrontMatterVisitorExt.VISIT_HANDLERS(this));
/* 20 */   private final Map<String, List<String>> data = new LinkedHashMap<>();
/*    */ 
/*    */   
/*    */   public void visit(Node paramNode) {
/* 24 */     this.myVisitor.visit(paramNode);
/*    */   }
/*    */ 
/*    */   
/*    */   public void visit(YamlFrontMatterNode paramYamlFrontMatterNode) {
/* 29 */     this.data.put(paramYamlFrontMatterNode.getKey(), paramYamlFrontMatterNode.getValues());
/*    */   }
/*    */ 
/*    */   
/*    */   public void visit(YamlFrontMatterBlock paramYamlFrontMatterBlock) {
/* 34 */     this.myVisitor.visitChildren((Node)paramYamlFrontMatterBlock);
/*    */   }
/*    */   
/*    */   public Map<String, List<String>> getData() {
/* 38 */     return this.data;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\yaml\front\matter\AbstractYamlFrontMatterVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */