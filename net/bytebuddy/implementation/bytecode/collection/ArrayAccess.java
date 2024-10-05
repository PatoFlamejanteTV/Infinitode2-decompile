/*     */ package net.bytebuddy.implementation.bytecode.collection;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*     */ public enum ArrayAccess
/*     */ {
/*  39 */   BYTE(51, 84, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   SHORT(53, 86, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   CHARACTER(52, 85, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   INTEGER(46, 79, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   LONG(47, 80, StackSize.DOUBLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   FLOAT(48, 81, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   DOUBLE(49, 82, StackSize.DOUBLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   REFERENCE(50, 83, StackSize.SINGLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int loadOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int storeOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackSize stackSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ArrayAccess(int paramInt1, int paramInt2, StackSize paramStackSize) {
/*  99 */     this.loadOpcode = paramInt1;
/* 100 */     this.storeOpcode = paramInt2;
/* 101 */     this.stackSize = paramStackSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayAccess of(TypeDefinition paramTypeDefinition) {
/* 111 */     if (!paramTypeDefinition.isPrimitive())
/* 112 */       return REFERENCE; 
/* 113 */     if (paramTypeDefinition.represents(boolean.class) || paramTypeDefinition.represents(byte.class))
/* 114 */       return BYTE; 
/* 115 */     if (paramTypeDefinition.represents(short.class))
/* 116 */       return SHORT; 
/* 117 */     if (paramTypeDefinition.represents(char.class))
/* 118 */       return CHARACTER; 
/* 119 */     if (paramTypeDefinition.represents(int.class))
/* 120 */       return INTEGER; 
/* 121 */     if (paramTypeDefinition.represents(long.class))
/* 122 */       return LONG; 
/* 123 */     if (paramTypeDefinition.represents(float.class))
/* 124 */       return FLOAT; 
/* 125 */     if (paramTypeDefinition.represents(double.class)) {
/* 126 */       return DOUBLE;
/*     */     }
/* 128 */     throw new IllegalArgumentException("Not a legal array type: " + paramTypeDefinition);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation load() {
/* 138 */     return (StackManipulation)new Loader(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation store() {
/* 147 */     return (StackManipulation)new Putter(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation forEach(List<? extends StackManipulation> paramList) {
/* 157 */     ArrayList<StackManipulation.Compound> arrayList = new ArrayList(paramList.size());
/* 158 */     byte b = 0;
/* 159 */     for (StackManipulation stackManipulation : paramList) {
/* 160 */       arrayList.add(new StackManipulation.Compound(new StackManipulation[] { (StackManipulation)Duplication.SINGLE, 
/*     */               
/* 162 */               IntegerConstant.forValue(b++), (StackManipulation)new Loader(this), stackManipulation }));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 167 */     return (StackManipulation)new StackManipulation.Compound(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class Loader
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     protected Loader(ArrayAccess this$0) {}
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 180 */       param1MethodVisitor.visitInsn(ArrayAccess.a(this.a));
/* 181 */       return ArrayAccess.b(this.a).toIncreasingSize().aggregate(new StackManipulation.Size(-2, 0));
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.a.equals(((Loader)param1Object).a))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.a.hashCode();
/*     */     } }
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class Putter extends StackManipulation.AbstractBase {
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 195 */       param1MethodVisitor.visitInsn(ArrayAccess.c(this.a));
/* 196 */       return ArrayAccess.b(this.a).toDecreasingSize().aggregate(new StackManipulation.Size(-2, 0));
/*     */     }
/*     */     
/*     */     protected Putter(ArrayAccess this$0) {}
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.a.equals(((Putter)param1Object).a))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.a.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\collection\ArrayAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */