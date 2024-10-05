/*    */ package com.badlogic.gdx.graphics.g3d.decals;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.IntMap;
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
/*    */ public abstract class PluggableGroupStrategy
/*    */   implements GroupStrategy
/*    */ {
/* 25 */   private IntMap<GroupPlug> plugs = new IntMap();
/*    */ 
/*    */   
/*    */   public void beforeGroup(int paramInt, Array<Decal> paramArray) {
/* 29 */     ((GroupPlug)this.plugs.get(paramInt)).beforeGroup(paramArray);
/*    */   }
/*    */ 
/*    */   
/*    */   public void afterGroup(int paramInt) {
/* 34 */     ((GroupPlug)this.plugs.get(paramInt)).afterGroup();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void plugIn(GroupPlug paramGroupPlug, int paramInt) {
/* 41 */     this.plugs.put(paramInt, paramGroupPlug);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public GroupPlug unPlug(int paramInt) {
/* 48 */     return (GroupPlug)this.plugs.remove(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\decals\PluggableGroupStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */