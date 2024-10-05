/*     */ package net.bytebuddy.dynamic.scaffold;
/*     */ 
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.jar.asm.ClassReader;
/*     */ import net.bytebuddy.jar.asm.ClassWriter;
/*     */ import net.bytebuddy.pool.TypePool;
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
/*     */ public interface ClassWriterStrategy
/*     */ {
/*     */   ClassWriter resolve(int paramInt, TypePool paramTypePool);
/*     */   
/*     */   ClassWriter resolve(int paramInt, TypePool paramTypePool, ClassReader paramClassReader);
/*     */   
/*     */   public enum Default
/*     */     implements ClassWriterStrategy
/*     */   {
/*  55 */     CONSTANT_POOL_RETAINING
/*     */     {
/*     */       public final ClassWriter resolve(int param2Int, TypePool param2TypePool, ClassReader param2ClassReader) {
/*  58 */         return new ClassWriterStrategy.FrameComputingClassWriter(param2ClassReader, param2Int, param2TypePool);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     CONSTANT_POOL_DISCARDING
/*     */     {
/*     */       public final ClassWriter resolve(int param2Int, TypePool param2TypePool, ClassReader param2ClassReader) {
/*  68 */         return resolve(param2Int, param2TypePool);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ClassWriter resolve(int param1Int, TypePool param1TypePool) {
/*  76 */       return new ClassWriterStrategy.FrameComputingClassWriter(param1Int, param1TypePool);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FrameComputingClassWriter
/*     */     extends ClassWriter
/*     */   {
/*     */     private final TypePool typePool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FrameComputingClassWriter(int param1Int, TypePool param1TypePool) {
/*  98 */       super(param1Int);
/*  99 */       this.typePool = param1TypePool;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FrameComputingClassWriter(ClassReader param1ClassReader, int param1Int, TypePool param1TypePool) {
/* 110 */       super(param1ClassReader, param1Int);
/* 111 */       this.typePool = param1TypePool;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getCommonSuperClass(String param1String1, String param1String2) {
/* 118 */       TypeDescription typeDescription1 = this.typePool.describe(param1String1.replace('/', '.')).resolve();
/* 119 */       TypeDescription typeDescription2 = this.typePool.describe(param1String2.replace('/', '.')).resolve();
/* 120 */       if (typeDescription1.isAssignableFrom(typeDescription2))
/* 121 */         return typeDescription1.getInternalName(); 
/* 122 */       if (typeDescription1.isAssignableTo(typeDescription2))
/* 123 */         return typeDescription2.getInternalName(); 
/* 124 */       if (typeDescription1.isInterface() || typeDescription2.isInterface()) {
/* 125 */         return TypeDescription.ForLoadedType.of(Object.class).getInternalName();
/*     */       }
/*     */       while (true) {
/*     */         TypeDescription.Generic generic;
/* 129 */         if ((generic = typeDescription1.getSuperClass()) == null) {
/* 130 */           return TypeDescription.ForLoadedType.of(Object.class).getInternalName();
/*     */         }
/*     */         TypeDescription typeDescription;
/* 133 */         if ((typeDescription = generic.asErasure()).isAssignableFrom(typeDescription2))
/* 134 */           return typeDescription.getInternalName(); 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\ClassWriterStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */