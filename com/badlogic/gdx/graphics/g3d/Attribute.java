/*    */ package com.badlogic.gdx.graphics.g3d;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ public abstract class Attribute
/*    */   implements Comparable<Attribute>
/*    */ {
/* 28 */   private static final Array<String> types = new Array();
/*    */   
/*    */   private static final int MAX_ATTRIBUTE_COUNT = 64;
/*    */   public final long type;
/*    */   private final int typeBit;
/*    */   
/*    */   public static final long getAttributeType(String paramString) {
/* 35 */     for (byte b = 0; b < types.size; b++) {
/* 36 */       if (((String)types.get(b)).compareTo(paramString) == 0) return 1L << b; 
/* 37 */     }  return 0L;
/*    */   }
/*    */ 
/*    */   
/*    */   public static final String getAttributeAlias(long paramLong) {
/* 42 */     byte b = -1; do {  }
/* 43 */     while (paramLong != 0L && ++b < 63 && (paramLong >> b & 0x1L) == 0L);
/*    */     
/* 45 */     return (b >= 0 && b < types.size) ? (String)types.get(b) : null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected static final long register(String paramString) {
/*    */     long l;
/* 56 */     if ((l = getAttributeType(paramString)) > 0L) return l; 
/* 57 */     if (types.size >= 64) {
/* 58 */       throw new GdxRuntimeException("Cannot register " + paramString + ", maximum registered attribute count reached.");
/*    */     }
/* 60 */     types.add(paramString);
/* 61 */     return 1L << types.size - 1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Attribute(long paramLong) {
/* 70 */     this.type = paramLong;
/* 71 */     this.typeBit = Long.numberOfTrailingZeros(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract Attribute copy();
/*    */   
/*    */   protected boolean equals(Attribute paramAttribute) {
/* 78 */     return (paramAttribute.hashCode() == hashCode());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 83 */     if (paramObject == null) return false; 
/* 84 */     if (paramObject == this) return true; 
/* 85 */     if (!(paramObject instanceof Attribute)) return false; 
/* 86 */     paramObject = paramObject;
/* 87 */     if (this.type != ((Attribute)paramObject).type) return false; 
/* 88 */     return equals((Attribute)paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 93 */     return getAttributeAlias(this.type);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 98 */     return 7489 * this.typeBit;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\Attribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */