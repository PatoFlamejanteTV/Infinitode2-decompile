/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
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
/*     */ class ParameterizedTypeImpl
/*     */   implements ParameterizedType
/*     */ {
/*     */   private final Type[] actualTypeArguments;
/*     */   private final Class<?> rawType;
/*     */   private final Type ownerType;
/*  51 */   public static final Type MAP_OF_UNKNOWN_TYPE = new ParameterizedTypeImpl(Map.class, new Type[] { Object.class, Object.class }, null);
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static final Type LIST_OF_UNKNOWN_TYPE = new ParameterizedTypeImpl(List.class, new Type[] { Object.class }, null);
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
/*     */   ParameterizedTypeImpl(Class<?> paramClass, Type[] paramArrayOfType, Type paramType) {
/*  69 */     this.actualTypeArguments = paramArrayOfType;
/*  70 */     this.rawType = paramClass;
/*  71 */     this.ownerType = (paramType != null) ? paramType : paramClass.getDeclaringClass();
/*  72 */     if ((paramClass.getTypeParameters()).length != paramArrayOfType.length) {
/*  73 */       throw new IllegalArgumentException("Argument length mismatch");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Type[] getActualTypeArguments() {
/*  82 */     return (Type[])this.actualTypeArguments.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getRawType() {
/*  90 */     return this.rawType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Type getOwnerType() {
/*  98 */     return this.ownerType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 106 */     if (paramObject == this)
/* 107 */       return true; 
/* 108 */     if (!(paramObject instanceof ParameterizedType)) {
/* 109 */       return false;
/*     */     }
/* 111 */     paramObject = paramObject;
/* 112 */     if (Objects.equals(this.ownerType, paramObject.getOwnerType()) && Objects.equals(this.rawType, paramObject.getRawType()) && 
/* 113 */       Arrays.equals((Object[])this.actualTypeArguments, (Object[])paramObject.getActualTypeArguments())) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return Arrays.hashCode((Object[])this.actualTypeArguments) ^ Objects.hashCode(this.ownerType) ^ Objects.hashCode(this.rawType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 129 */     StringBuilder stringBuilder = new StringBuilder();
/* 130 */     if (this.ownerType == null) {
/* 131 */       stringBuilder.append(this.rawType.getName());
/*     */     } else {
/* 133 */       if (this.ownerType instanceof Class) {
/* 134 */         stringBuilder.append(((Class)this.ownerType).getName());
/*     */       } else {
/* 136 */         stringBuilder.append(this.ownerType);
/*     */       } 
/* 138 */       stringBuilder.append('$');
/* 139 */       if (this.ownerType instanceof ParameterizedTypeImpl) {
/*     */         
/* 141 */         String str = this.rawType.getName().replace(((ParameterizedTypeImpl)this.ownerType).rawType.getName() + "$", "");
/* 142 */         stringBuilder.append(str);
/*     */       } else {
/* 144 */         stringBuilder.append(this.rawType.getSimpleName());
/*     */       } 
/*     */     } 
/* 147 */     if (this.actualTypeArguments != null && this.actualTypeArguments.length > 0) {
/* 148 */       stringBuilder.append('<');
/* 149 */       boolean bool = true; Type[] arrayOfType; int i; byte b;
/* 150 */       for (i = (arrayOfType = this.actualTypeArguments).length, b = 0; b < i; ) { Type type = arrayOfType[b];
/* 151 */         if (bool) {
/* 152 */           bool = false;
/*     */         } else {
/* 154 */           stringBuilder.append(", ");
/*     */         } 
/* 156 */         stringBuilder.append(type.toString()); b++; }
/*     */       
/* 158 */       stringBuilder.append('>');
/*     */     } 
/* 160 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\ParameterizedTypeImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */