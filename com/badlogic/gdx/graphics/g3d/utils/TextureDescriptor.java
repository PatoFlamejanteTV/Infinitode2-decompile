/*    */ package com.badlogic.gdx.graphics.g3d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.GLTexture;
/*    */ import com.badlogic.gdx.graphics.Texture;
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
/*    */ public class TextureDescriptor<T extends GLTexture>
/*    */   implements Comparable<TextureDescriptor<T>>
/*    */ {
/* 23 */   public T texture = null;
/*    */   
/*    */   public Texture.TextureFilter minFilter;
/*    */   
/*    */   public Texture.TextureFilter magFilter;
/*    */   
/*    */   public Texture.TextureWrap uWrap;
/*    */   public Texture.TextureWrap vWrap;
/*    */   
/*    */   public TextureDescriptor(T paramT, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2) {
/* 33 */     set(paramT, paramTextureFilter1, paramTextureFilter2, paramTextureWrap1, paramTextureWrap2);
/*    */   }
/*    */   
/*    */   public TextureDescriptor(T paramT) {
/* 37 */     this(paramT, null, null, null, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void set(T paramT, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2) {
/* 45 */     this.texture = paramT;
/* 46 */     this.minFilter = paramTextureFilter1;
/* 47 */     this.magFilter = paramTextureFilter2;
/* 48 */     this.uWrap = paramTextureWrap1;
/* 49 */     this.vWrap = paramTextureWrap2;
/*    */   }
/*    */   
/*    */   public <V extends T> void set(TextureDescriptor<V> paramTextureDescriptor) {
/* 53 */     this.texture = paramTextureDescriptor.texture;
/* 54 */     this.minFilter = paramTextureDescriptor.minFilter;
/* 55 */     this.magFilter = paramTextureDescriptor.magFilter;
/* 56 */     this.uWrap = paramTextureDescriptor.uWrap;
/* 57 */     this.vWrap = paramTextureDescriptor.vWrap;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 62 */     if (paramObject == null) return false; 
/* 63 */     if (paramObject == this) return true; 
/* 64 */     if (!(paramObject instanceof TextureDescriptor)) return false;
/*    */     
/* 66 */     if (((TextureDescriptor)(paramObject = paramObject)).texture == this.texture && ((TextureDescriptor)paramObject).minFilter == this.minFilter && ((TextureDescriptor)paramObject).magFilter == this.magFilter && ((TextureDescriptor)paramObject).uWrap == this.uWrap && ((TextureDescriptor)paramObject).vWrap == this.vWrap) return true;  return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 72 */     long l = ((this.texture == null) ? 0L : ((GLTexture)this.texture).glTarget);
/* 73 */     l = 811L * l + ((this.texture == null) ? 0L : this.texture.getTextureObjectHandle());
/* 74 */     l = 811L * l + ((this.minFilter == null) ? 0L : this.minFilter.getGLEnum());
/* 75 */     l = 811L * l + ((this.magFilter == null) ? 0L : this.magFilter.getGLEnum());
/* 76 */     l = 811L * l + ((this.uWrap == null) ? 0L : this.uWrap.getGLEnum());
/*    */     
/* 78 */     return (int)((l = 811L * l + ((this.vWrap == null) ? 0L : this.vWrap.getGLEnum())) ^ l >> 32L);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(TextureDescriptor<T> paramTextureDescriptor) {
/* 83 */     if (paramTextureDescriptor == this) return 0; 
/* 84 */     byte b1 = (this.texture == null) ? 0 : ((GLTexture)this.texture).glTarget;
/* 85 */     byte b2 = (paramTextureDescriptor.texture == null) ? 0 : ((GLTexture)paramTextureDescriptor.texture).glTarget;
/* 86 */     if (b1 != b2) return b1 - b2; 
/* 87 */     b1 = (this.texture == null) ? 0 : this.texture.getTextureObjectHandle();
/* 88 */     b2 = (paramTextureDescriptor.texture == null) ? 0 : paramTextureDescriptor.texture.getTextureObjectHandle();
/* 89 */     if (b1 != b2) return b1 - b2; 
/* 90 */     if (this.minFilter != paramTextureDescriptor.minFilter)
/* 91 */       return ((this.minFilter == null) ? 0 : this.minFilter.getGLEnum()) - ((paramTextureDescriptor.minFilter == null) ? 0 : paramTextureDescriptor.minFilter.getGLEnum()); 
/* 92 */     if (this.magFilter != paramTextureDescriptor.magFilter)
/* 93 */       return ((this.magFilter == null) ? 0 : this.magFilter.getGLEnum()) - ((paramTextureDescriptor.magFilter == null) ? 0 : paramTextureDescriptor.magFilter.getGLEnum()); 
/* 94 */     if (this.uWrap != paramTextureDescriptor.uWrap) return ((this.uWrap == null) ? 0 : this.uWrap.getGLEnum()) - ((paramTextureDescriptor.uWrap == null) ? 0 : paramTextureDescriptor.uWrap.getGLEnum()); 
/* 95 */     if (this.vWrap != paramTextureDescriptor.vWrap) return ((this.vWrap == null) ? 0 : this.vWrap.getGLEnum()) - ((paramTextureDescriptor.vWrap == null) ? 0 : paramTextureDescriptor.vWrap.getGLEnum()); 
/* 96 */     return 0;
/*    */   }
/*    */   
/*    */   public TextureDescriptor() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\TextureDescriptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */