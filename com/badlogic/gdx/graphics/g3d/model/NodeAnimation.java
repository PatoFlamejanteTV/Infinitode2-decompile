/*    */ package com.badlogic.gdx.graphics.g3d.model;
/*    */ 
/*    */ import com.badlogic.gdx.math.Quaternion;
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ public class NodeAnimation
/*    */ {
/*    */   public Node node;
/* 31 */   public Array<NodeKeyframe<Vector3>> translation = null;
/*    */   
/* 33 */   public Array<NodeKeyframe<Quaternion>> rotation = null;
/*    */   
/* 35 */   public Array<NodeKeyframe<Vector3>> scaling = null;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\NodeAnimation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */