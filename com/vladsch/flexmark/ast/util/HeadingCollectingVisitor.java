/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Heading;
/*    */ import com.vladsch.flexmark.util.ast.BlockNodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class HeadingCollectingVisitor
/*    */ {
/* 12 */   private final ArrayList<Heading> headings = new ArrayList<>();
/*    */   private final NodeVisitor myVisitor;
/*    */   
/*    */   public HeadingCollectingVisitor() {
/* 16 */     this.myVisitor = (NodeVisitor)new BlockNodeVisitor(new VisitHandler[] { new VisitHandler(Heading.class, this.headings::add) });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void collect(Node paramNode) {
/* 22 */     this.myVisitor.visit(paramNode);
/*    */   }
/*    */   
/*    */   public ArrayList<Heading> collectAndGetHeadings(Node paramNode) {
/* 26 */     this.myVisitor.visit(paramNode);
/* 27 */     return this.headings;
/*    */   }
/*    */   
/*    */   public ArrayList<Heading> getHeadings() {
/* 31 */     return this.headings;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\HeadingCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */