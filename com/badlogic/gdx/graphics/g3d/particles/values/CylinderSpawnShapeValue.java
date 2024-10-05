/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector3;
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
/*    */ public final class CylinderSpawnShapeValue
/*    */   extends PrimitiveSpawnShapeValue
/*    */ {
/*    */   public CylinderSpawnShapeValue(CylinderSpawnShapeValue paramCylinderSpawnShapeValue) {
/* 27 */     super(paramCylinderSpawnShapeValue);
/* 28 */     load(paramCylinderSpawnShapeValue);
/*    */   }
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
/*    */   public CylinderSpawnShapeValue() {}
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
/*    */   public final void spawnAux(Vector3 paramVector3, float paramFloat) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield spawnWidth : F
/*    */     //   4: aload_0
/*    */     //   5: getfield spawnWidthDiff : F
/*    */     //   8: aload_0
/*    */     //   9: getfield spawnWidthValue : Lcom/badlogic/gdx/graphics/g3d/particles/values/ScaledNumericValue;
/*    */     //   12: fload_2
/*    */     //   13: invokevirtual getScale : (F)F
/*    */     //   16: fmul
/*    */     //   17: fadd
/*    */     //   18: fstore_3
/*    */     //   19: aload_0
/*    */     //   20: getfield spawnHeight : F
/*    */     //   23: aload_0
/*    */     //   24: getfield spawnHeightDiff : F
/*    */     //   27: aload_0
/*    */     //   28: getfield spawnHeightValue : Lcom/badlogic/gdx/graphics/g3d/particles/values/ScaledNumericValue;
/*    */     //   31: fload_2
/*    */     //   32: invokevirtual getScale : (F)F
/*    */     //   35: fmul
/*    */     //   36: fadd
/*    */     //   37: fstore #4
/*    */     //   39: aload_0
/*    */     //   40: getfield spawnDepth : F
/*    */     //   43: aload_0
/*    */     //   44: getfield spawnDepthDiff : F
/*    */     //   47: aload_0
/*    */     //   48: getfield spawnDepthValue : Lcom/badlogic/gdx/graphics/g3d/particles/values/ScaledNumericValue;
/*    */     //   51: fload_2
/*    */     //   52: invokevirtual getScale : (F)F
/*    */     //   55: fmul
/*    */     //   56: fadd
/*    */     //   57: fstore_2
/*    */     //   58: fload #4
/*    */     //   60: fconst_2
/*    */     //   61: fdiv
/*    */     //   62: fstore #5
/*    */     //   64: fload #4
/*    */     //   66: invokestatic random : (F)F
/*    */     //   69: fload #5
/*    */     //   71: fsub
/*    */     //   72: fstore #4
/*    */     //   74: aload_0
/*    */     //   75: getfield edges : Z
/*    */     //   78: ifeq -> 92
/*    */     //   81: fload_3
/*    */     //   82: fconst_2
/*    */     //   83: fdiv
/*    */     //   84: fstore_3
/*    */     //   85: fload_2
/*    */     //   86: fconst_2
/*    */     //   87: fdiv
/*    */     //   88: fstore_2
/*    */     //   89: goto -> 106
/*    */     //   92: fload_3
/*    */     //   93: invokestatic random : (F)F
/*    */     //   96: fconst_2
/*    */     //   97: fdiv
/*    */     //   98: fstore_3
/*    */     //   99: fload_2
/*    */     //   100: invokestatic random : (F)F
/*    */     //   103: fconst_2
/*    */     //   104: fdiv
/*    */     //   105: fstore_2
/*    */     //   106: fconst_0
/*    */     //   107: fstore #5
/*    */     //   109: fload_3
/*    */     //   110: fconst_0
/*    */     //   111: fcmpl
/*    */     //   112: ifne -> 119
/*    */     //   115: iconst_1
/*    */     //   116: goto -> 120
/*    */     //   119: iconst_0
/*    */     //   120: istore #6
/*    */     //   122: fload_2
/*    */     //   123: fconst_0
/*    */     //   124: fcmpl
/*    */     //   125: ifne -> 132
/*    */     //   128: iconst_1
/*    */     //   129: goto -> 133
/*    */     //   132: iconst_0
/*    */     //   133: istore #7
/*    */     //   135: iload #6
/*    */     //   137: ifne -> 153
/*    */     //   140: iload #7
/*    */     //   142: ifne -> 153
/*    */     //   145: ldc 360.0
/*    */     //   147: invokestatic random : (F)F
/*    */     //   150: goto -> 195
/*    */     //   153: iload #6
/*    */     //   155: ifeq -> 177
/*    */     //   158: iconst_1
/*    */     //   159: invokestatic random : (I)I
/*    */     //   162: ifne -> 170
/*    */     //   165: ldc -90.0
/*    */     //   167: goto -> 172
/*    */     //   170: ldc 90.0
/*    */     //   172: fstore #5
/*    */     //   174: goto -> 197
/*    */     //   177: iload #7
/*    */     //   179: ifeq -> 197
/*    */     //   182: iconst_1
/*    */     //   183: invokestatic random : (I)I
/*    */     //   186: ifne -> 193
/*    */     //   189: fconst_0
/*    */     //   190: goto -> 195
/*    */     //   193: ldc 180.0
/*    */     //   195: fstore #5
/*    */     //   197: aload_1
/*    */     //   198: fload_3
/*    */     //   199: fload #5
/*    */     //   201: invokestatic cosDeg : (F)F
/*    */     //   204: fmul
/*    */     //   205: fload #4
/*    */     //   207: fload_2
/*    */     //   208: fload #5
/*    */     //   210: invokestatic sinDeg : (F)F
/*    */     //   213: fmul
/*    */     //   214: invokevirtual set : (FFF)Lcom/badlogic/gdx/math/Vector3;
/*    */     //   217: pop
/*    */     //   218: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #37	-> 0
/*    */     //   #38	-> 19
/*    */     //   #39	-> 39
/*    */     //   #42	-> 58
/*    */     //   #43	-> 64
/*    */     //   #46	-> 74
/*    */     //   #47	-> 81
/*    */     //   #48	-> 85
/*    */     //   #50	-> 92
/*    */     //   #51	-> 99
/*    */     //   #54	-> 106
/*    */     //   #57	-> 109
/*    */     //   #58	-> 135
/*    */     //   #59	-> 145
/*    */     //   #61	-> 153
/*    */     //   #62	-> 158
/*    */     //   #63	-> 177
/*    */     //   #66	-> 197
/*    */     //   #67	-> 218
/*    */   }
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
/*    */   public final SpawnShapeValue copy() {
/* 71 */     return new CylinderSpawnShapeValue(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\CylinderSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */