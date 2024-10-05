/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.graphics.g3d.ModelBatch;
/*     */ import com.badlogic.gdx.graphics.glutils.FrameBuffer;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = RenderingManager.Serializer.class)
/*     */ public class RenderingManager extends Manager.ManagerAdapter {
/*     */   public final ShapeRenderer shapeRenderer;
/*     */   public final SpriteBatch batch;
/*     */   public final ModelBatch modelBatch;
/*  26 */   private static final TLog a = TLog.forClass(RenderingManager.class); private final Matrix4 b;
/*     */   private final Matrix4 c;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<RenderingManager> { public RenderingManager read() {
/*  30 */       return Game.i.renderingManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private final Array<ObjectPair<String, FrameBuffer>> d = new Array(true, 1, ObjectPair.class);
/*     */   
/*  42 */   private final DelayedRemovalArray<DebugPoint> e = new DelayedRemovalArray(true, 1, DebugPoint.class);
/*     */   
/*     */   public RenderingManager() {
/*  45 */     this.shapeRenderer = new ShapeRenderer(5000, createDefaultShapeRendererShader());
/*  46 */     this.b = new Matrix4(this.shapeRenderer.getTransformMatrix());
/*     */     
/*  48 */     this.modelBatch = new ModelBatch();
/*     */     
/*  50 */     this.batch = new SpriteBatch(8191, createDefaultSpriteBatchShader());
/*  51 */     this.c = new Matrix4(this.batch.getTransformMatrix());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {}
/*     */ 
/*     */   
/*     */   public int getMSAASampleCount() {
/*  59 */     return Game.i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS);
/*     */   }
/*     */   
/*     */   public int getCurrentRenderTargetWidth() {
/*     */     ObjectPair<String, FrameBuffer> objectPair;
/*  64 */     if ((objectPair = getCurrentFBO()) != null) {
/*  65 */       return ((FrameBuffer)objectPair.second).getWidth();
/*     */     }
/*  67 */     return Game.i.uiManager.getScreenWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCurrentRenderTargetHeight() {
/*     */     ObjectPair<String, FrameBuffer> objectPair;
/*  73 */     if ((objectPair = getCurrentFBO()) != null) {
/*  74 */       return ((FrameBuffer)objectPair.second).getHeight();
/*     */     }
/*  76 */     return Game.i.uiManager.getScreenHeight();
/*     */   }
/*     */   
/*     */   @Null
/*     */   public ObjectPair<String, FrameBuffer> getCurrentFBO() {
/*  81 */     return (this.d.size == 0) ? null : (ObjectPair<String, FrameBuffer>)this.d.get(this.d.size - 1);
/*     */   }
/*     */   
/*     */   public void startFBO(FrameBuffer paramFrameBuffer, String paramString) {
/*  85 */     Preconditions.checkNotNull(paramFrameBuffer, "buffer can not be null");
/*  86 */     Preconditions.checkNotNull(paramString, "name can not be null");
/*     */     
/*     */     ObjectPair<String, FrameBuffer> objectPair;
/*  89 */     if ((objectPair = getCurrentFBO()) != null && objectPair.second == paramFrameBuffer) {
/*  90 */       throw new IllegalArgumentException("Can't start currently active FBO");
/*     */     }
/*     */     
/*  93 */     if (objectPair != null) {
/*  94 */       ((FrameBuffer)objectPair.second).end();
/*     */     }
/*  96 */     this.d.add(new ObjectPair(paramString, paramFrameBuffer));
/*  97 */     paramFrameBuffer.begin();
/*     */   }
/*     */   
/*     */   public void endFBO(String paramString) {
/* 101 */     Preconditions.checkNotNull(paramString, "name can not be null");
/*     */     
/*     */     ObjectPair<String, FrameBuffer> objectPair;
/* 104 */     if ((objectPair = getCurrentFBO()) == null) {
/* 105 */       throw new IllegalArgumentException("No FBO currently active");
/*     */     }
/* 107 */     if (!((String)objectPair.first).equals(paramString)) {
/* 108 */       throw new IllegalArgumentException("Incorrect active FBO provided (" + paramString + ") - some other FBO is currently active (" + (String)objectPair.first + ")");
/*     */     }
/* 110 */     ((FrameBuffer)objectPair.second).end();
/* 111 */     this.d.pop();
/* 112 */     if (this.d.size != 0) {
/* 113 */       ((FrameBuffer)((ObjectPair)this.d.get(this.d.size - 1)).second).begin();
/*     */     }
/*     */   }
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
/*     */   public void preRender(float paramFloat) {
/* 130 */     resetTransformState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDebugPoint(float paramFloat1, float paramFloat2, float paramFloat3, Color paramColor) {
/*     */     try {
/*     */       DebugPoint debugPoint;
/* 141 */       (debugPoint = new DebugPoint((byte)0)).x = paramFloat1;
/* 142 */       debugPoint.y = Gdx.graphics.getHeight() - paramFloat2;
/* 143 */       debugPoint.size = paramFloat3;
/* 144 */       debugPoint.color = paramColor;
/* 145 */       debugPoint.duration = 1.0F;
/* 146 */       debugPoint.existsTime = 0.0F;
/* 147 */       this.e.add(debugPoint); return;
/* 148 */     } catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public void postRender(float paramFloat) {
/* 153 */     if (this.e.size != 0) {
/* 154 */       this.e.begin();
/* 155 */       for (byte b = 0; b < this.e.size; b++) {
/*     */         DebugPoint debugPoint;
/* 157 */         (debugPoint = (DebugPoint)this.e.get(b)).existsTime += paramFloat;
/* 158 */         if (debugPoint.existsTime >= debugPoint.duration) {
/* 159 */           this.e.removeIndex(b);
/*     */         }
/*     */       } 
/* 162 */       this.e.end();
/*     */       
/* 164 */       if (this.e.size != 0) {
/* 165 */         prepareBatch(this.batch, false);
/*     */         Matrix4 matrix4;
/* 167 */         (matrix4 = this.batch.getProjectionMatrix()).setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/* 168 */         this.batch.setProjectionMatrix(matrix4);
/* 169 */         for (byte b1 = 0; b1 < this.e.size; b1++) {
/* 170 */           DebugPoint debugPoint = (DebugPoint)this.e.get(b1);
/* 171 */           this.batch.setColor(debugPoint.color);
/* 172 */           float f = (debugPoint.duration - debugPoint.existsTime) / debugPoint.duration;
/* 173 */           this.batch.setColor(this.batch.getColor().mul(1.0F, 1.0F, 1.0F, f));
/* 174 */           this.batch.draw((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle, debugPoint.x - debugPoint.size * 0.5F, debugPoint.y - debugPoint.size * 0.5F, debugPoint.size, debugPoint.size);
/*     */         } 
/* 176 */         this.batch.end();
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTransformState() {
/* 208 */     this.batch.setTransformMatrix(this.c);
/* 209 */     this.shapeRenderer.setTransformMatrix(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 214 */     this.shapeRenderer.dispose();
/* 215 */     this.batch.dispose();
/*     */   }
/*     */   
/*     */   public static void setBatchAdditiveBlending(Batch paramBatch, boolean paramBoolean) {
/* 219 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DISABLE_ADDITIVE_BLENDING) != 0.0D)
/*     */     {
/* 221 */       paramBoolean = false;
/*     */     }
/*     */     
/* 224 */     if (paramBoolean) {
/* 225 */       if (paramBatch.getBlendSrcFunc() != 770 || paramBatch.getBlendDstFunc() != 1) {
/* 226 */         if (paramBatch.isDrawing()) paramBatch.flush(); 
/* 227 */         paramBatch.setBlendFunction(770, 1);
/*     */         return;
/*     */       } 
/* 230 */     } else if (paramBatch.getBlendSrcFunc() != 770 || paramBatch.getBlendDstFunc() != 771) {
/* 231 */       if (paramBatch.isDrawing()) paramBatch.flush(); 
/* 232 */       paramBatch.setBlendFunction(770, 771);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isAdditiveBatch(Batch paramBatch) {
/* 238 */     return (paramBatch.getBlendSrcFunc() == 770 && paramBatch.getBlendDstFunc() == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Batch> T prepareBatch(T paramT, boolean paramBoolean) {
/* 245 */     paramT.flush();
/* 246 */     setBatchAdditiveBlending((Batch)paramT, paramBoolean);
/* 247 */     if (!paramT.isDrawing()) paramT.begin(); 
/* 248 */     paramT.setColor(Color.WHITE);
/* 249 */     return paramT;
/*     */   }
/*     */   
/*     */   public void stopAnyBatchDrawing() {
/* 253 */     if (this.batch.isDrawing()) this.batch.end(); 
/* 254 */     if (this.shapeRenderer.isDrawing()) this.shapeRenderer.end();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ShaderProgram createShader(String paramString) {
/* 264 */     a.d("createShader %s", new Object[] { paramString });
/*     */     
/* 266 */     String str = AssetManager.localOrInternalFile("shaders/" + paramString + ".vert.glsl").readString("UTF-8");
/* 267 */     paramString = AssetManager.localOrInternalFile("shaders/" + paramString + ".frag.glsl").readString("UTF-8");
/*     */     try {
/*     */       ShaderProgram shaderProgram;
/* 270 */       if (!(shaderProgram = new ShaderProgram(str, paramString)).isCompiled()) {
/* 271 */         throw new IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog());
/*     */       }
/* 273 */       a.i("successfully compiled the original shader", new Object[0]);
/* 274 */       return shaderProgram;
/* 275 */     } catch (Throwable throwable) {
/* 276 */       a.w("failed to compile original shader, adding #version", new Object[0]);
/* 277 */       str = "#version 330\n" + str;
/* 278 */       paramString = "#version 330\n" + paramString;
/*     */       ShaderProgram shaderProgram;
/* 280 */       if (!(shaderProgram = new ShaderProgram(str, paramString)).isCompiled()) {
/* 281 */         throw new IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog() + "\nVertex:\n" + str + "\nFragment:\n" + paramString);
/*     */       }
/* 283 */       a.i("successfully compiled the shader with #version", new Object[0]);
/* 284 */       return shaderProgram;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static ShaderProgram createDefaultSpriteBatchShader() {
/* 289 */     return createShader("SpriteBatch");
/*     */   }
/*     */   
/*     */   public static ShaderProgram createDefaultShapeRendererShader() {
/* 293 */     return createShader("ShapeRenderer");
/*     */   }
/*     */   
/*     */   private static final class DebugPoint {
/*     */     public float x;
/*     */     public float y;
/*     */     public float size;
/*     */     public Color color;
/*     */     public float duration;
/*     */     public float existsTime;
/*     */     
/*     */     private DebugPoint() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\RenderingManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */