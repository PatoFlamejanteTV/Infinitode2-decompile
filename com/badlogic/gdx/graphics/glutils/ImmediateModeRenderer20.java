/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class ImmediateModeRenderer20
/*     */   implements ImmediateModeRenderer
/*     */ {
/*     */   private int primitiveType;
/*     */   private int vertexIdx;
/*     */   private int numSetTexCoords;
/*     */   private final int maxVertices;
/*     */   private int numVertices;
/*     */   private final Mesh mesh;
/*     */   private ShaderProgram shader;
/*     */   private boolean ownsShader;
/*     */   private final int numTexCoords;
/*     */   private final int vertexSize;
/*     */   private final int normalOffset;
/*     */   private final int colorOffset;
/*     */   private final int texCoordOffset;
/*  45 */   private final Matrix4 projModelView = new Matrix4();
/*     */   private final float[] vertices;
/*     */   private final String[] shaderUniformNames;
/*     */   
/*     */   public ImmediateModeRenderer20(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/*  50 */     this(5000, paramBoolean1, paramBoolean2, paramInt, createDefaultShader(paramBoolean1, paramBoolean2, paramInt));
/*  51 */     this.ownsShader = true;
/*     */   }
/*     */   
/*     */   public ImmediateModeRenderer20(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {
/*  55 */     this(paramInt1, paramBoolean1, paramBoolean2, paramInt2, createDefaultShader(paramBoolean1, paramBoolean2, paramInt2));
/*  56 */     this.ownsShader = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ImmediateModeRenderer20(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, ShaderProgram paramShaderProgram) {
/*  61 */     this.maxVertices = paramInt1;
/*  62 */     this.numTexCoords = paramInt2;
/*  63 */     this.shader = paramShaderProgram;
/*     */     
/*  65 */     VertexAttribute[] arrayOfVertexAttribute = buildVertexAttributes(paramBoolean1, paramBoolean2, paramInt2);
/*  66 */     this.mesh = new Mesh(false, paramInt1, 0, arrayOfVertexAttribute);
/*     */     
/*  68 */     this.vertices = new float[paramInt1 * (this.mesh.getVertexAttributes()).vertexSize / 4];
/*  69 */     this.vertexSize = (this.mesh.getVertexAttributes()).vertexSize / 4;
/*  70 */     this.normalOffset = (this.mesh.getVertexAttribute(8) != null) ? ((this.mesh.getVertexAttribute(8)).offset / 4) : 0;
/*  71 */     this
/*  72 */       .colorOffset = (this.mesh.getVertexAttribute(4) != null) ? ((this.mesh.getVertexAttribute(4)).offset / 4) : 0;
/*  73 */     this
/*     */       
/*  75 */       .texCoordOffset = (this.mesh.getVertexAttribute(16) != null) ? ((this.mesh.getVertexAttribute(16)).offset / 4) : 0;
/*     */     
/*  77 */     this.shaderUniformNames = new String[paramInt2];
/*  78 */     for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
/*  79 */       this.shaderUniformNames[paramInt1] = "u_sampler" + paramInt1;
/*     */     }
/*     */   }
/*     */   
/*     */   private VertexAttribute[] buildVertexAttributes(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/*     */     Array array;
/*  85 */     (array = new Array()).add(new VertexAttribute(1, 3, "a_position"));
/*  86 */     if (paramBoolean1) array.add(new VertexAttribute(8, 3, "a_normal")); 
/*  87 */     if (paramBoolean2) array.add(new VertexAttribute(4, 4, "a_color")); 
/*  88 */     for (paramBoolean1 = false; paramBoolean1 < paramInt; paramBoolean1++) {
/*  89 */       array.add(new VertexAttribute(16, 2, "a_texCoord" + paramBoolean1));
/*     */     }
/*  91 */     VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[array.size];
/*  92 */     for (paramBoolean2 = false; paramBoolean2 < array.size; paramBoolean2++)
/*  93 */       arrayOfVertexAttribute[paramBoolean2] = (VertexAttribute)array.get(paramBoolean2); 
/*  94 */     return arrayOfVertexAttribute;
/*     */   }
/*     */   
/*     */   public void setShader(ShaderProgram paramShaderProgram) {
/*  98 */     if (this.ownsShader) this.shader.dispose(); 
/*  99 */     this.shader = paramShaderProgram;
/* 100 */     this.ownsShader = false;
/*     */   }
/*     */   
/*     */   public ShaderProgram getShader() {
/* 104 */     return this.shader;
/*     */   }
/*     */   
/*     */   public void begin(Matrix4 paramMatrix4, int paramInt) {
/* 108 */     this.projModelView.set(paramMatrix4);
/* 109 */     this.primitiveType = paramInt;
/*     */   }
/*     */   
/*     */   public void color(Color paramColor) {
/* 113 */     this.vertices[this.vertexIdx + this.colorOffset] = paramColor.toFloatBits();
/*     */   }
/*     */   
/*     */   public void color(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 117 */     this.vertices[this.vertexIdx + this.colorOffset] = Color.toFloatBits(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void color(float paramFloat) {
/* 121 */     this.vertices[this.vertexIdx + this.colorOffset] = paramFloat;
/*     */   }
/*     */   
/*     */   public void texCoord(float paramFloat1, float paramFloat2) {
/* 125 */     int i = this.vertexIdx + this.texCoordOffset;
/* 126 */     this.vertices[i + this.numSetTexCoords] = paramFloat1;
/* 127 */     this.vertices[i + this.numSetTexCoords + 1] = paramFloat2;
/* 128 */     this.numSetTexCoords += 2;
/*     */   }
/*     */   
/*     */   public void normal(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 132 */     int i = this.vertexIdx + this.normalOffset;
/* 133 */     this.vertices[i] = paramFloat1;
/* 134 */     this.vertices[i + 1] = paramFloat2;
/* 135 */     this.vertices[i + 2] = paramFloat3;
/*     */   }
/*     */   
/*     */   public void vertex(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 139 */     int i = this.vertexIdx;
/* 140 */     this.vertices[i] = paramFloat1;
/* 141 */     this.vertices[i + 1] = paramFloat2;
/* 142 */     this.vertices[i + 2] = paramFloat3;
/*     */     
/* 144 */     this.numSetTexCoords = 0;
/* 145 */     this.vertexIdx += this.vertexSize;
/* 146 */     this.numVertices++;
/*     */   }
/*     */   
/*     */   public void flush() {
/* 150 */     if (this.numVertices == 0)
/* 151 */       return;  this.shader.bind();
/* 152 */     this.shader.setUniformMatrix("u_projModelView", this.projModelView);
/* 153 */     for (byte b = 0; b < this.numTexCoords; b++)
/* 154 */       this.shader.setUniformi(this.shaderUniformNames[b], b); 
/* 155 */     this.mesh.setVertices(this.vertices, 0, this.vertexIdx);
/* 156 */     this.mesh.render(this.shader, this.primitiveType);
/*     */     
/* 158 */     this.numSetTexCoords = 0;
/* 159 */     this.vertexIdx = 0;
/* 160 */     this.numVertices = 0;
/*     */   }
/*     */   
/*     */   public void end() {
/* 164 */     flush();
/*     */   }
/*     */   
/*     */   public int getNumVertices() {
/* 168 */     return this.numVertices;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxVertices() {
/* 173 */     return this.maxVertices;
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 177 */     if (this.ownsShader && this.shader != null) this.shader.dispose(); 
/* 178 */     this.mesh.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String createVertexShader(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 184 */     String str = "attribute vec4 a_position;\n" + (paramBoolean1 ? "attribute vec3 a_normal;\n" : "") + (paramBoolean2 ? "attribute vec4 a_color;\n" : "");
/*     */     byte b;
/* 186 */     for (b = 0; b < paramInt; b++) {
/* 187 */       str = str + "attribute vec2 a_texCoord" + b + ";\n";
/*     */     }
/*     */ 
/*     */     
/* 191 */     str = str + "uniform mat4 u_projModelView;\n" + (paramBoolean2 ? "varying vec4 v_col;\n" : "");
/*     */     
/* 193 */     for (b = 0; b < paramInt; b++) {
/* 194 */       str = str + "varying vec2 v_tex" + b + ";\n";
/*     */     }
/*     */     
/* 197 */     str = str + "void main() {\n   gl_Position = u_projModelView * a_position;\n";
/* 198 */     if (paramBoolean2) {
/* 199 */       str = str + "   v_col = a_color;\n   v_col.a *= 255.0 / 254.0;\n";
/*     */     }
/*     */ 
/*     */     
/* 203 */     for (b = 0; b < paramInt; b++) {
/* 204 */       str = str + "   v_tex" + b + " = a_texCoord" + b + ";\n";
/*     */     }
/*     */ 
/*     */     
/* 208 */     return str = str + "   gl_PointSize = 1.0;\n}\n";
/*     */   }
/*     */   
/*     */   private static String createFragmentShader(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 212 */     String str = "#ifdef GL_ES\nprecision mediump float;\n#endif\n";
/*     */     
/* 214 */     if (paramBoolean2) str = str + "varying vec4 v_col;\n";  byte b;
/* 215 */     for (b = 0; b < paramInt; b++) {
/* 216 */       str = str + "varying vec2 v_tex" + b + ";\n";
/* 217 */       str = str + "uniform sampler2D u_sampler" + b + ";\n";
/*     */     } 
/*     */ 
/*     */     
/* 221 */     str = str + "void main() {\n   gl_FragColor = " + (paramBoolean2 ? "v_col" : "vec4(1, 1, 1, 1)");
/*     */     
/* 223 */     if (paramInt > 0) str = str + " * ";
/*     */     
/* 225 */     for (b = 0; b < paramInt; b++) {
/* 226 */       if (b == paramInt - 1) {
/* 227 */         str = str + " texture2D(u_sampler" + b + ",  v_tex" + b + ")";
/*     */       } else {
/* 229 */         str = str + " texture2D(u_sampler" + b + ",  v_tex" + b + ") *";
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 234 */     return str = str + ";\n}";
/*     */   }
/*     */ 
/*     */   
/*     */   public static ShaderProgram createDefaultShader(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 239 */     String str2 = createVertexShader(paramBoolean1, paramBoolean2, paramInt);
/* 240 */     String str1 = createFragmentShader(paramBoolean1, paramBoolean2, paramInt);
/*     */     ShaderProgram shaderProgram;
/* 242 */     if (!(shaderProgram = new ShaderProgram(str2, str1)).isCompiled()) throw new GdxRuntimeException("Error compiling shader: " + shaderProgram.getLog()); 
/* 243 */     return shaderProgram;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\ImmediateModeRenderer20.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */