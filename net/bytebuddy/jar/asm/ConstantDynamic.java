/*     */ package net.bytebuddy.jar.asm;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ public final class ConstantDynamic
/*     */ {
/*     */   private final String name;
/*     */   private final String descriptor;
/*     */   private final Handle bootstrapMethod;
/*     */   private final Object[] bootstrapMethodArguments;
/*     */   
/*     */   public ConstantDynamic(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/*  68 */     this.name = paramString1;
/*  69 */     this.descriptor = paramString2;
/*  70 */     this.bootstrapMethod = paramHandle;
/*  71 */     this.bootstrapMethodArguments = paramVarArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/*  80 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getDescriptor() {
/*  89 */     return this.descriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Handle getBootstrapMethod() {
/*  98 */     return this.bootstrapMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getBootstrapMethodArgumentCount() {
/* 109 */     return this.bootstrapMethodArguments.length;
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
/*     */   public final Object getBootstrapMethodArgument(int paramInt) {
/* 121 */     return this.bootstrapMethodArguments[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final Object[] a() {
/* 132 */     return this.bootstrapMethodArguments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSize() {
/*     */     char c;
/* 142 */     if ((c = this.descriptor.charAt(0)) == 'J' || c == 'D') return 2;  return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 147 */     if (paramObject == this) {
/* 148 */       return true;
/*     */     }
/* 150 */     if (!(paramObject instanceof ConstantDynamic)) {
/* 151 */       return false;
/*     */     }
/* 153 */     paramObject = paramObject;
/* 154 */     if (this.name.equals(((ConstantDynamic)paramObject).name) && this.descriptor
/* 155 */       .equals(((ConstantDynamic)paramObject).descriptor) && this.bootstrapMethod
/* 156 */       .equals(((ConstantDynamic)paramObject).bootstrapMethod) && 
/* 157 */       Arrays.equals(this.bootstrapMethodArguments, ((ConstantDynamic)paramObject).bootstrapMethodArguments)) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 162 */     return this.name.hashCode() ^ 
/* 163 */       Integer.rotateLeft(this.descriptor.hashCode(), 8) ^ 
/* 164 */       Integer.rotateLeft(this.bootstrapMethod.hashCode(), 16) ^ 
/* 165 */       Integer.rotateLeft(Arrays.hashCode(this.bootstrapMethodArguments), 24);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 170 */     return this.name + " : " + this.descriptor + ' ' + this.bootstrapMethod + ' ' + 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       Arrays.toString(this.bootstrapMethodArguments);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\ConstantDynamic.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */