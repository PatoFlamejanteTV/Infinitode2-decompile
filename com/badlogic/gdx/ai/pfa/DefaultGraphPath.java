/*    */ package com.badlogic.gdx.ai.pfa;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import java.util.Iterator;
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
/*    */ public class DefaultGraphPath<N>
/*    */   implements GraphPath<N>
/*    */ {
/*    */   public final Array<N> nodes;
/*    */   
/*    */   public DefaultGraphPath() {
/* 33 */     this(new Array());
/*    */   }
/*    */ 
/*    */   
/*    */   public DefaultGraphPath(int paramInt) {
/* 38 */     this(new Array(paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   public DefaultGraphPath(Array<N> paramArray) {
/* 43 */     this.nodes = paramArray;
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 48 */     this.nodes.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCount() {
/* 53 */     return this.nodes.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(N paramN) {
/* 58 */     this.nodes.add(paramN);
/*    */   }
/*    */ 
/*    */   
/*    */   public N get(int paramInt) {
/* 63 */     return (N)this.nodes.get(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public void reverse() {
/* 68 */     this.nodes.reverse();
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<N> iterator() {
/* 73 */     return this.nodes.iterator();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\DefaultGraphPath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */