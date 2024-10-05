/*    */ package net.bytebuddy.implementation.bytecode.constant;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.io.Serializable;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.method.MethodDescription;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.implementation.bytecode.Duplication;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*    */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Enhance
/*    */ public class SerializedConstant
/*    */   extends StackManipulation.AbstractBase
/*    */ {
/*    */   private static final String CHARSET = "ISO-8859-1";
/*    */   private final String serialization;
/*    */   
/*    */   protected SerializedConstant(String paramString) {
/* 53 */     this.serialization = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static StackManipulation of(@MaybeNull Serializable paramSerializable) {
/* 63 */     if (paramSerializable == null) {
/* 64 */       return NullConstant.INSTANCE;
/*    */     }
/*    */     try {
/* 67 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 68 */       ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
/*    */       try {
/* 70 */         objectOutputStream.writeObject(paramSerializable);
/*    */       } finally {
/* 72 */         objectOutputStream.close();
/*    */       } 
/* 74 */       return (StackManipulation)new SerializedConstant(byteArrayOutputStream.toString("ISO-8859-1"));
/* 75 */     } catch (IOException iOException) {
/* 76 */       throw new IllegalStateException("Cannot serialize " + paramSerializable, iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/*    */     try {
/* 85 */       return (new StackManipulation.Compound(new StackManipulation[] {
/* 86 */             TypeCreation.of(TypeDescription.ForLoadedType.of(ObjectInputStream.class)), (StackManipulation)Duplication.SINGLE, 
/*    */             
/* 88 */             TypeCreation.of(TypeDescription.ForLoadedType.of(ByteArrayInputStream.class)), (StackManipulation)Duplication.SINGLE, (StackManipulation)new TextConstant(this.serialization), (StackManipulation)new TextConstant("ISO-8859-1"), 
/*    */ 
/*    */ 
/*    */             
/* 92 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(String.class.getMethod("getBytes", new Class[] { String.class
/* 93 */                   }))), (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(ByteArrayInputStream.class.getConstructor(new Class[] { byte[].class
/* 94 */                   }))), (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(ObjectInputStream.class.getConstructor(new Class[] { InputStream.class
/* 95 */                   }))), (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(ObjectInputStream.class.getMethod("readObject", new Class[0])))
/* 96 */           })).apply(paramMethodVisitor, paramContext);
/* 97 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 98 */       throw new IllegalStateException("Could not locate Java API method", noSuchMethodException);
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.serialization.equals(((SerializedConstant)paramObject).serialization))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.serialization.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\SerializedConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */