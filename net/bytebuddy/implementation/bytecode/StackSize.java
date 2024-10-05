/*     */ package net.bytebuddy.implementation.bytecode;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
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
/*     */ public enum StackSize
/*     */ {
/*  31 */   ZERO(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   SINGLE(1),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   DOUBLE(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   StackSize(int paramInt1) {
/*  54 */     this.size = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackSize of(Class<?> paramClass) {
/*  64 */     if (paramClass == void.class)
/*  65 */       return ZERO; 
/*  66 */     if (paramClass == double.class || paramClass == long.class) {
/*  67 */       return DOUBLE;
/*     */     }
/*  69 */     return SINGLE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackSize of(int paramInt) {
/*  80 */     switch (paramInt) {
/*     */       case 0:
/*  82 */         return ZERO;
/*     */       case 1:
/*  84 */         return SINGLE;
/*     */       case 2:
/*  86 */         return DOUBLE;
/*     */     } 
/*  88 */     throw new IllegalArgumentException("Unexpected stack size value: " + paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int of(TypeDefinition... paramVarArgs) {
/*  99 */     return of(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int of(Collection<? extends TypeDefinition> paramCollection) {
/* 109 */     int i = 0;
/* 110 */     for (TypeDefinition typeDefinition : paramCollection) {
/* 111 */       i += typeDefinition.getStackSize().getSize();
/*     */     }
/* 113 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSize() {
/* 122 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size toIncreasingSize() {
/* 133 */     return new StackManipulation.Size(getSize(), getSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size toDecreasingSize() {
/* 144 */     return new StackManipulation.Size(-1 * getSize(), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackSize maximum(StackSize paramStackSize) {
/* 154 */     switch (null.a[ordinal()]) {
/*     */       case 3:
/* 156 */         return paramStackSize;
/*     */       case 2:
/* 158 */         switch (null.a[paramStackSize.ordinal()]) {
/*     */           case 1:
/* 160 */             return paramStackSize;
/*     */           case 2:
/*     */           case 3:
/* 163 */             return this;
/*     */         } 
/* 165 */         throw new AssertionError();
/*     */       
/*     */       case 1:
/* 168 */         return this;
/*     */     } 
/* 170 */     throw new AssertionError();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\StackSize.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */