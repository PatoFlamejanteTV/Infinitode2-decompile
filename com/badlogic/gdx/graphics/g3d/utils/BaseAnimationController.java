/*     */ package com.badlogic.gdx.graphics.g3d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Animation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Node;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaseAnimationController
/*     */ {
/*     */   public static final class Transform
/*     */     implements Pool.Poolable
/*     */   {
/*  41 */     public final Vector3 translation = new Vector3();
/*  42 */     public final Quaternion rotation = new Quaternion();
/*  43 */     public final Vector3 scale = new Vector3(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Transform idt() {
/*  49 */       this.translation.set(0.0F, 0.0F, 0.0F);
/*  50 */       this.rotation.idt();
/*  51 */       this.scale.set(1.0F, 1.0F, 1.0F);
/*  52 */       return this;
/*     */     }
/*     */     
/*     */     public final Transform set(Vector3 param1Vector31, Quaternion param1Quaternion, Vector3 param1Vector32) {
/*  56 */       this.translation.set(param1Vector31);
/*  57 */       this.rotation.set(param1Quaternion);
/*  58 */       this.scale.set(param1Vector32);
/*  59 */       return this;
/*     */     }
/*     */     
/*     */     public final Transform set(Transform param1Transform) {
/*  63 */       return set(param1Transform.translation, param1Transform.rotation, param1Transform.scale);
/*     */     }
/*     */     
/*     */     public final Transform lerp(Transform param1Transform, float param1Float) {
/*  67 */       return lerp(param1Transform.translation, param1Transform.rotation, param1Transform.scale, param1Float);
/*     */     }
/*     */     
/*     */     public final Transform lerp(Vector3 param1Vector31, Quaternion param1Quaternion, Vector3 param1Vector32, float param1Float) {
/*  71 */       this.translation.lerp(param1Vector31, param1Float);
/*  72 */       this.rotation.slerp(param1Quaternion, param1Float);
/*  73 */       this.scale.lerp(param1Vector32, param1Float);
/*  74 */       return this;
/*     */     }
/*     */     
/*     */     public final Matrix4 toMatrix4(Matrix4 param1Matrix4) {
/*  78 */       return param1Matrix4.set(this.translation, this.rotation, this.scale);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void reset() {
/*  83 */       idt();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/*  88 */       return this.translation.toString() + " - " + this.rotation.toString() + " - " + this.scale.toString();
/*     */     }
/*     */   }
/*     */   
/*  92 */   private final Pool<Transform> transformPool = new Pool<Transform>()
/*     */     {
/*     */       protected BaseAnimationController.Transform newObject() {
/*  95 */         return new BaseAnimationController.Transform();
/*     */       }
/*     */     };
/*  98 */   private static final ObjectMap<Node, Transform> transforms = new ObjectMap();
/*     */   
/*     */   private boolean applying = false;
/*     */   
/*     */   public final ModelInstance target;
/*     */ 
/*     */   
/*     */   public BaseAnimationController(ModelInstance paramModelInstance) {
/* 106 */     this.target = paramModelInstance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void begin() {
/* 112 */     if (this.applying) throw new GdxRuntimeException("You must call end() after each call to being()"); 
/* 113 */     this.applying = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void apply(Animation paramAnimation, float paramFloat1, float paramFloat2) {
/* 119 */     if (!this.applying) throw new GdxRuntimeException("You must call begin() before adding an animation"); 
/* 120 */     applyAnimation(transforms, this.transformPool, paramFloat2, paramAnimation, paramFloat1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void end() {
/* 125 */     if (!this.applying) throw new GdxRuntimeException("You must call begin() first"); 
/* 126 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = transforms.entries().iterator(); entries.hasNext(); ) {
/* 127 */       ObjectMap.Entry entry; ((Transform)(entry = entries.next()).value).toMatrix4(((Node)entry.key).localTransform);
/* 128 */       this.transformPool.free(entry.value);
/*     */     } 
/* 130 */     transforms.clear();
/* 131 */     this.target.calculateTransforms();
/* 132 */     this.applying = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyAnimation(Animation paramAnimation, float paramFloat) {
/* 137 */     if (this.applying) throw new GdxRuntimeException("Call end() first"); 
/* 138 */     applyAnimation(null, null, 1.0F, paramAnimation, paramFloat);
/* 139 */     this.target.calculateTransforms();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyAnimations(Animation paramAnimation1, float paramFloat1, Animation paramAnimation2, float paramFloat2, float paramFloat3) {
/* 145 */     if (paramAnimation2 == null || paramFloat3 == 0.0F) {
/* 146 */       applyAnimation(paramAnimation1, paramFloat1); return;
/* 147 */     }  if (paramAnimation1 == null || paramFloat3 == 1.0F) {
/* 148 */       applyAnimation(paramAnimation2, paramFloat2); return;
/* 149 */     }  if (this.applying) {
/* 150 */       throw new GdxRuntimeException("Call end() first");
/*     */     }
/* 152 */     begin();
/* 153 */     apply(paramAnimation1, paramFloat1, 1.0F);
/* 154 */     apply(paramAnimation2, paramFloat2, paramFloat3);
/* 155 */     end();
/*     */   }
/*     */ 
/*     */   
/* 159 */   private static final Transform tmpT = new Transform();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final <T> int getFirstKeyframeIndexAtTime(Array<NodeKeyframe<T>> paramArray, float paramFloat) {
/*     */     int i;
/* 169 */     if ((i = paramArray.size - 1) <= 0 || paramFloat < ((NodeKeyframe)paramArray.get(0)).keytime || paramFloat > ((NodeKeyframe)paramArray.get(i)).keytime) {
/* 170 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 174 */     int j = 0;
/* 175 */     i = i;
/*     */     
/* 177 */     while (j < i) {
/* 178 */       int k = (j + i) / 2;
/* 179 */       if (paramFloat > ((NodeKeyframe)paramArray.get(k + 1)).keytime) {
/* 180 */         j = k + 1; continue;
/* 181 */       }  if (paramFloat < ((NodeKeyframe)paramArray.get(k)).keytime) {
/* 182 */         i = k - 1; continue;
/*     */       } 
/* 184 */       return k;
/*     */     } 
/*     */     
/* 187 */     return j;
/*     */   }
/*     */   
/*     */   private static final Vector3 getTranslationAtTime(NodeAnimation paramNodeAnimation, float paramFloat, Vector3 paramVector3) {
/* 191 */     if (paramNodeAnimation.translation == null) return paramVector3.set(paramNodeAnimation.node.translation); 
/* 192 */     if (paramNodeAnimation.translation.size == 1) return paramVector3.set((Vector3)((NodeKeyframe)paramNodeAnimation.translation.get(0)).value);
/*     */     
/* 194 */     int i = getFirstKeyframeIndexAtTime(paramNodeAnimation.translation, paramFloat);
/* 195 */     NodeKeyframe nodeKeyframe = (NodeKeyframe)paramNodeAnimation.translation.get(i);
/* 196 */     paramVector3.set((Vector3)nodeKeyframe.value);
/*     */     
/* 198 */     if (++i < paramNodeAnimation.translation.size) {
/* 199 */       NodeKeyframe nodeKeyframe1 = (NodeKeyframe)paramNodeAnimation.translation.get(i);
/* 200 */       paramFloat = (paramFloat - nodeKeyframe.keytime) / (nodeKeyframe1.keytime - nodeKeyframe.keytime);
/* 201 */       paramVector3.lerp((Vector3)nodeKeyframe1.value, paramFloat);
/*     */     } 
/* 203 */     return paramVector3;
/*     */   }
/*     */   
/*     */   private static final Quaternion getRotationAtTime(NodeAnimation paramNodeAnimation, float paramFloat, Quaternion paramQuaternion) {
/* 207 */     if (paramNodeAnimation.rotation == null) return paramQuaternion.set(paramNodeAnimation.node.rotation); 
/* 208 */     if (paramNodeAnimation.rotation.size == 1) return paramQuaternion.set((Quaternion)((NodeKeyframe)paramNodeAnimation.rotation.get(0)).value);
/*     */     
/* 210 */     int i = getFirstKeyframeIndexAtTime(paramNodeAnimation.rotation, paramFloat);
/* 211 */     NodeKeyframe nodeKeyframe = (NodeKeyframe)paramNodeAnimation.rotation.get(i);
/* 212 */     paramQuaternion.set((Quaternion)nodeKeyframe.value);
/*     */     
/* 214 */     if (++i < paramNodeAnimation.rotation.size) {
/* 215 */       NodeKeyframe nodeKeyframe1 = (NodeKeyframe)paramNodeAnimation.rotation.get(i);
/* 216 */       paramFloat = (paramFloat - nodeKeyframe.keytime) / (nodeKeyframe1.keytime - nodeKeyframe.keytime);
/* 217 */       paramQuaternion.slerp((Quaternion)nodeKeyframe1.value, paramFloat);
/*     */     } 
/* 219 */     return paramQuaternion;
/*     */   }
/*     */   
/*     */   private static final Vector3 getScalingAtTime(NodeAnimation paramNodeAnimation, float paramFloat, Vector3 paramVector3) {
/* 223 */     if (paramNodeAnimation.scaling == null) return paramVector3.set(paramNodeAnimation.node.scale); 
/* 224 */     if (paramNodeAnimation.scaling.size == 1) return paramVector3.set((Vector3)((NodeKeyframe)paramNodeAnimation.scaling.get(0)).value);
/*     */     
/* 226 */     int i = getFirstKeyframeIndexAtTime(paramNodeAnimation.scaling, paramFloat);
/* 227 */     NodeKeyframe nodeKeyframe = (NodeKeyframe)paramNodeAnimation.scaling.get(i);
/* 228 */     paramVector3.set((Vector3)nodeKeyframe.value);
/*     */     
/* 230 */     if (++i < paramNodeAnimation.scaling.size) {
/* 231 */       NodeKeyframe nodeKeyframe1 = (NodeKeyframe)paramNodeAnimation.scaling.get(i);
/* 232 */       paramFloat = (paramFloat - nodeKeyframe.keytime) / (nodeKeyframe1.keytime - nodeKeyframe.keytime);
/* 233 */       paramVector3.lerp((Vector3)nodeKeyframe1.value, paramFloat);
/*     */     } 
/* 235 */     return paramVector3;
/*     */   }
/*     */   
/*     */   private static final Transform getNodeAnimationTransform(NodeAnimation paramNodeAnimation, float paramFloat) {
/* 239 */     Transform transform = tmpT;
/* 240 */     getTranslationAtTime(paramNodeAnimation, paramFloat, transform.translation);
/* 241 */     getRotationAtTime(paramNodeAnimation, paramFloat, transform.rotation);
/* 242 */     getScalingAtTime(paramNodeAnimation, paramFloat, transform.scale);
/* 243 */     return transform;
/*     */   }
/*     */   
/*     */   private static final void applyNodeAnimationDirectly(NodeAnimation paramNodeAnimation, float paramFloat) {
/*     */     Node node;
/* 248 */     (node = paramNodeAnimation.node).isAnimated = true;
/*     */     Transform transform;
/* 250 */     (transform = getNodeAnimationTransform(paramNodeAnimation, paramFloat)).toMatrix4(node.localTransform);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final void applyNodeAnimationBlending(NodeAnimation paramNodeAnimation, ObjectMap<Node, Transform> paramObjectMap, Pool<Transform> paramPool, float paramFloat1, float paramFloat2) {
/*     */     Node node;
/* 257 */     (node = paramNodeAnimation.node).isAnimated = true;
/* 258 */     Transform transform1 = getNodeAnimationTransform(paramNodeAnimation, paramFloat2);
/*     */     
/*     */     Transform transform2;
/* 261 */     if ((transform2 = (Transform)paramObjectMap.get(node, null)) != null) {
/* 262 */       if (paramFloat1 > 0.999999F) {
/* 263 */         transform2.set(transform1); return;
/*     */       } 
/* 265 */       transform2.lerp(transform1, paramFloat1); return;
/*     */     } 
/* 267 */     if (paramFloat1 > 0.999999F) {
/* 268 */       paramObjectMap.put(node, ((Transform)paramPool.obtain()).set(transform1)); return;
/*     */     } 
/* 270 */     paramObjectMap.put(node, ((Transform)paramPool.obtain()).set(node.translation, node.rotation, node.scale).lerp(transform1, paramFloat1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void applyAnimation(ObjectMap<Node, Transform> paramObjectMap, Pool<Transform> paramPool, float paramFloat1, Animation paramAnimation, float paramFloat2) {
/* 278 */     if (paramObjectMap == null) {
/* 279 */       for (Array.ArrayIterator<NodeAnimation> arrayIterator1 = paramAnimation.nodeAnimations.iterator(); arrayIterator1.hasNext();)
/* 280 */         applyNodeAnimationDirectly(nodeAnimation = arrayIterator1.next(), paramFloat2);  return;
/*     */     } 
/* 282 */     for (ObjectMap.Keys<Node> keys = paramObjectMap.keys().iterator(); keys.hasNext();)
/* 283 */       (node = keys.next()).isAnimated = false; 
/* 284 */     for (Array.ArrayIterator<NodeAnimation> arrayIterator = paramAnimation.nodeAnimations.iterator(); arrayIterator.hasNext();)
/* 285 */       applyNodeAnimationBlending(nodeAnimation = arrayIterator.next(), paramObjectMap, paramPool, paramFloat1, paramFloat2); 
/* 286 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = paramObjectMap.entries().iterator(); entries.hasNext();) {
/* 287 */       if (!((Node)(entry = entries.next()).key).isAnimated) {
/* 288 */         ((Node)entry.key).isAnimated = true;
/* 289 */         ((Transform)entry.value).lerp(((Node)entry.key).translation, ((Node)entry.key).rotation, ((Node)entry.key).scale, paramFloat1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAnimation(Animation paramAnimation) {
/* 298 */     for (Array.ArrayIterator<NodeAnimation> arrayIterator = paramAnimation.nodeAnimations.iterator(); arrayIterator.hasNext();)
/* 299 */       (nodeAnimation = arrayIterator.next()).node.isAnimated = false; 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\BaseAnimationController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */