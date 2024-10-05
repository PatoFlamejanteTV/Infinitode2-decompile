/*     */ package net.bytebuddy.implementation.bind;
/*     */ 
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.method.ParameterList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*     */ public enum ArgumentTypeResolver
/*     */   implements MethodDelegationBinder.AmbiguityResolver
/*     */ {
/*  50 */   INSTANCE;
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
/*     */   private static MethodDelegationBinder.AmbiguityResolver.Resolution resolveRivalBinding(TypeDescription paramTypeDescription, int paramInt1, MethodDelegationBinder.MethodBinding paramMethodBinding1, int paramInt2, MethodDelegationBinder.MethodBinding paramMethodBinding2) {
/*  67 */     TypeDescription typeDescription1 = ((ParameterDescription)paramMethodBinding1.getTarget().getParameters().get(paramInt1)).getType().asErasure();
/*  68 */     TypeDescription typeDescription2 = ((ParameterDescription)paramMethodBinding2.getTarget().getParameters().get(paramInt2)).getType().asErasure();
/*  69 */     if (!typeDescription1.equals(typeDescription2)) {
/*  70 */       if (typeDescription1.isPrimitive() && typeDescription2.isPrimitive())
/*  71 */         return PrimitiveTypePrecedence.forPrimitive(typeDescription1).resolve(PrimitiveTypePrecedence.forPrimitive(typeDescription2)); 
/*  72 */       if (typeDescription1.isPrimitive())
/*  73 */         return paramTypeDescription.isPrimitive() ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT; 
/*  74 */       if (typeDescription2.isPrimitive()) {
/*  75 */         return paramTypeDescription.isPrimitive() ? MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT : MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
/*     */       }
/*     */       
/*  78 */       if (typeDescription1.isAssignableFrom(typeDescription2))
/*  79 */         return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT; 
/*  80 */       if (typeDescription2.isAssignableFrom(typeDescription1)) {
/*  81 */         return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
/*     */       }
/*  83 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS;
/*     */     } 
/*     */ 
/*     */     
/*  87 */     return MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
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
/*     */   private static MethodDelegationBinder.AmbiguityResolver.Resolution resolveByScore(int paramInt) {
/* 100 */     if (paramInt == 0)
/* 101 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS; 
/* 102 */     if (paramInt > 0) {
/* 103 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
/*     */     }
/* 105 */     return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription paramMethodDescription, MethodDelegationBinder.MethodBinding paramMethodBinding1, MethodDelegationBinder.MethodBinding paramMethodBinding2) {
/* 115 */     MethodDelegationBinder.AmbiguityResolver.Resolution resolution = MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
/* 116 */     ParameterList parameterList = paramMethodDescription.getParameters();
/* 117 */     byte b1 = 0, b2 = 0;
/* 118 */     for (byte b3 = 0; b3 < parameterList.size(); b3++) {
/* 119 */       ParameterIndexToken parameterIndexToken = new ParameterIndexToken(b3);
/* 120 */       Integer integer2 = paramMethodBinding1.getTargetParameterIndex(parameterIndexToken);
/* 121 */       Integer integer1 = paramMethodBinding2.getTargetParameterIndex(parameterIndexToken);
/* 122 */       if (integer2 != null && integer1 != null) {
/* 123 */         resolution = resolution.merge(resolveRivalBinding(((ParameterDescription)parameterList.get(b3)).getType().asErasure(), integer2
/* 124 */               .intValue(), paramMethodBinding1, integer1
/*     */               
/* 126 */               .intValue(), paramMethodBinding2));
/*     */       }
/* 128 */       else if (integer2 != null) {
/* 129 */         b1++;
/* 130 */       } else if (integer1 != null) {
/* 131 */         b2++;
/*     */       } 
/*     */     } 
/* 134 */     if (resolution == MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN)
/* 135 */       return resolveByScore(b1 - b2);  return resolution;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum PrimitiveTypePrecedence
/*     */   {
/* 147 */     BOOLEAN(0),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     BYTE(1),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     SHORT(2),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     INTEGER(3),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     CHARACTER(4),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     LONG(5),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     FLOAT(6),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     DOUBLE(7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int score;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PrimitiveTypePrecedence(int param1Int1) {
/* 195 */       this.score = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static PrimitiveTypePrecedence forPrimitive(TypeDescription param1TypeDescription) {
/* 205 */       if (param1TypeDescription.represents(boolean.class))
/* 206 */         return BOOLEAN; 
/* 207 */       if (param1TypeDescription.represents(byte.class))
/* 208 */         return BYTE; 
/* 209 */       if (param1TypeDescription.represents(short.class))
/* 210 */         return SHORT; 
/* 211 */       if (param1TypeDescription.represents(int.class))
/* 212 */         return INTEGER; 
/* 213 */       if (param1TypeDescription.represents(char.class))
/* 214 */         return CHARACTER; 
/* 215 */       if (param1TypeDescription.represents(long.class))
/* 216 */         return LONG; 
/* 217 */       if (param1TypeDescription.represents(float.class))
/* 218 */         return FLOAT; 
/* 219 */       if (param1TypeDescription.represents(double.class)) {
/* 220 */         return DOUBLE;
/*     */       }
/* 222 */       throw new IllegalArgumentException("Not a non-void, primitive type " + param1TypeDescription);
/*     */     }
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
/*     */     public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(PrimitiveTypePrecedence param1PrimitiveTypePrecedence) {
/* 237 */       if (this.score - param1PrimitiveTypePrecedence.score == 0)
/* 238 */         return MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN; 
/* 239 */       if (this.score - param1PrimitiveTypePrecedence.score > 0) {
/* 240 */         return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
/*     */       }
/* 242 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
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
/*     */   public static class ParameterIndexToken
/*     */   {
/*     */     private final int parameterIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ParameterIndexToken(int param1Int) {
/* 266 */       this.parameterIndex = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 271 */       return this.parameterIndex;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 276 */       if (this == param1Object)
/* 277 */         return true; 
/* 278 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 279 */         return false;
/*     */       }
/* 281 */       param1Object = param1Object;
/* 282 */       return (this.parameterIndex == ((ParameterIndexToken)param1Object).parameterIndex);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\ArgumentTypeResolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */