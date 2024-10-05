/*    */ package io.github.classgraph;
/*    */ 
/*    */ import nonapi.io.github.classgraph.types.Parser;
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
/*    */ public abstract class ReferenceTypeSignature
/*    */   extends TypeSignature
/*    */ {
/*    */   static ReferenceTypeSignature parseReferenceTypeSignature(Parser paramParser, String paramString) {
/*    */     ClassRefTypeSignature classRefTypeSignature;
/* 58 */     if ((classRefTypeSignature = ClassRefTypeSignature.parse(paramParser, paramString)) != null) {
/* 59 */       return classRefTypeSignature;
/*    */     }
/*    */     TypeVariableSignature typeVariableSignature;
/* 62 */     if ((typeVariableSignature = TypeVariableSignature.parse(paramParser, paramString)) != null) {
/* 63 */       return typeVariableSignature;
/*    */     }
/*    */     ArrayTypeSignature arrayTypeSignature;
/* 66 */     if ((arrayTypeSignature = ArrayTypeSignature.parse(paramParser, paramString)) != null) {
/* 67 */       return arrayTypeSignature;
/*    */     }
/* 69 */     return null;
/*    */   }
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
/*    */   static ReferenceTypeSignature parseClassBound(Parser paramParser, String paramString) {
/* 85 */     paramParser.expect(':');
/*    */     
/* 87 */     return parseReferenceTypeSignature(paramParser, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ReferenceTypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */