/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.html.Attributes;
/*    */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import org.jsoup.nodes.Node;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HtmlConverterState
/*    */ {
/*    */   final Node myParent;
/*    */   final List<Node> myElements;
/*    */   int myIndex;
/*    */   final MutableAttributes myAttributes;
/*    */   private LinkedList<Runnable> myPrePopActions;
/*    */   
/*    */   HtmlConverterState(Node paramNode) {
/* 20 */     this.myParent = paramNode;
/* 21 */     this.myElements = paramNode.childNodes();
/* 22 */     this.myIndex = 0;
/* 23 */     this.myAttributes = new MutableAttributes();
/* 24 */     this.myPrePopActions = null;
/*    */   }
/*    */   
/*    */   public Node getParent() {
/* 28 */     return this.myParent;
/*    */   }
/*    */   
/*    */   public List<Node> getElements() {
/* 32 */     return this.myElements;
/*    */   }
/*    */   
/*    */   public int getIndex() {
/* 36 */     return this.myIndex;
/*    */   }
/*    */   
/*    */   public Attributes getAttributes() {
/* 40 */     return (Attributes)this.myAttributes;
/*    */   }
/*    */   
/*    */   public LinkedList<Runnable> getPrePopActions() {
/* 44 */     return this.myPrePopActions;
/*    */   }
/*    */   
/*    */   public void addPrePopAction(Runnable paramRunnable) {
/* 48 */     if (this.myPrePopActions == null) {
/* 49 */       this.myPrePopActions = new LinkedList<>();
/*    */     }
/* 51 */     this.myPrePopActions.add(paramRunnable);
/*    */   }
/*    */   
/*    */   public void runPrePopActions() {
/* 55 */     if (this.myPrePopActions != null)
/*    */     {
/* 57 */       for (int i = this.myPrePopActions.size(); i-- > 0;) {
/* 58 */         ((Runnable)this.myPrePopActions.get(i)).run();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     return "State{myParent=" + this.myParent + ", myElements=" + this.myElements + ", myIndex=" + this.myIndex + ", myAttributes=" + this.myAttributes + '}';
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlConverterState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */