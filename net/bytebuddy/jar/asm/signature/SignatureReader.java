/*     */ package net.bytebuddy.jar.asm.signature;
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
/*     */ public class SignatureReader
/*     */ {
/*     */   private final String signatureValue;
/*     */   
/*     */   public SignatureReader(String paramString) {
/*  50 */     this.signatureValue = paramString;
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
/*     */   public void accept(SignatureVisitor paramSignatureVisitor) {
/*     */     int j;
/*     */     String str;
/*  65 */     int i = (str = this.signatureValue).length();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     if (str.charAt(0) == '<') {
/*     */       int k;
/*     */       
/*  75 */       j = 2;
/*     */       
/*     */       do {
/*  78 */         k = str.indexOf(':', j);
/*  79 */         paramSignatureVisitor.visitFormalTypeParameter(str
/*  80 */             .substring(j - 1, k));
/*     */ 
/*     */ 
/*     */         
/*  84 */         j = k + 1;
/*     */         
/*  86 */         if ((k = str.charAt(j)) == 76 || k == 91 || k == 84) {
/*  87 */           j = parseType(str, j, paramSignatureVisitor.visitClassBound());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*  92 */         while ((k = str.charAt(j++)) == 58) {
/*  93 */           j = parseType(str, j, paramSignatureVisitor.visitInterfaceBound());
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 100 */       while (k != 62);
/*     */     } else {
/* 102 */       j = 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     if (str.charAt(j) == '(') {
/* 109 */       j++;
/* 110 */       while (str.charAt(j) != ')') {
/* 111 */         j = parseType(str, j, paramSignatureVisitor.visitParameterType());
/*     */       }
/*     */       
/* 114 */       j = parseType(str, j + 1, paramSignatureVisitor.visitReturnType());
/* 115 */       while (j < i)
/*     */       {
/* 117 */         j = parseType(str, j + 1, paramSignatureVisitor.visitExceptionType());
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 122 */       j = parseType(str, j, paramSignatureVisitor.visitSuperclass());
/* 123 */       while (j < i) {
/* 124 */         j = parseType(str, j, paramSignatureVisitor.visitInterface());
/*     */       }
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
/*     */ 
/*     */   
/*     */   public void acceptType(SignatureVisitor paramSignatureVisitor) {
/* 140 */     parseType(this.signatureValue, 0, paramSignatureVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int parseType(String paramString, int paramInt, SignatureVisitor paramSignatureVisitor) {
/*     */     int j;
/*     */     boolean bool1, bool2;
/* 153 */     int i = paramInt;
/* 154 */     i++;
/*     */ 
/*     */     
/* 157 */     switch (paramInt = paramString.charAt(paramInt)) {
/*     */       
/*     */       case 66:
/*     */       case 67:
/*     */       case 68:
/*     */       case 70:
/*     */       case 73:
/*     */       case 74:
/*     */       case 83:
/*     */       case 86:
/*     */       case 90:
/* 168 */         paramSignatureVisitor.visitBaseType(paramInt);
/* 169 */         return i;
/*     */ 
/*     */       
/*     */       case 91:
/* 173 */         return parseType(paramString, i, paramSignatureVisitor.visitArrayType());
/*     */ 
/*     */       
/*     */       case 84:
/* 177 */         paramInt = paramString.indexOf(';', i);
/* 178 */         paramSignatureVisitor.visitTypeVariable(paramString.substring(i, paramInt));
/* 179 */         return paramInt + 1;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 76:
/* 185 */         j = i;
/* 186 */         bool1 = false;
/* 187 */         bool2 = false;
/*     */ 
/*     */         
/*     */         while (true) {
/* 191 */           if ((paramInt = paramString.charAt(i++)) == 46 || paramInt == 59) {
/*     */ 
/*     */ 
/*     */             
/* 195 */             if (!bool1) {
/* 196 */               String str = paramString.substring(j, i - 1);
/* 197 */               if (bool2) {
/* 198 */                 paramSignatureVisitor.visitInnerClassType(str);
/*     */               } else {
/* 200 */                 paramSignatureVisitor.visitClassType(str);
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 205 */             if (paramInt == 59) {
/* 206 */               paramSignatureVisitor.visitEnd();
/*     */               break;
/*     */             } 
/* 209 */             j = i;
/* 210 */             bool1 = false;
/* 211 */             bool2 = true; continue;
/* 212 */           }  if (paramInt == 60) {
/*     */ 
/*     */ 
/*     */             
/* 216 */             String str = paramString.substring(j, i - 1);
/* 217 */             if (bool2) {
/* 218 */               paramSignatureVisitor.visitInnerClassType(str);
/*     */             } else {
/* 220 */               paramSignatureVisitor.visitClassType(str);
/*     */             } 
/* 222 */             boolean bool = true;
/*     */             
/* 224 */             while ((paramInt = paramString.charAt(i)) != 62) {
/* 225 */               switch (paramInt) {
/*     */                 
/*     */                 case 42:
/* 228 */                   i++;
/* 229 */                   paramSignatureVisitor.visitTypeArgument();
/*     */                   continue;
/*     */ 
/*     */                 
/*     */                 case 43:
/*     */                 case 45:
/* 235 */                   i = parseType(paramString, i + 1, paramSignatureVisitor
/* 236 */                       .visitTypeArgument(paramInt));
/*     */                   continue;
/*     */               } 
/*     */               
/* 240 */               i = parseType(paramString, i, paramSignatureVisitor.visitTypeArgument('='));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 246 */         return i;
/*     */     } 
/*     */     
/* 249 */     throw new IllegalArgumentException();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\signature\SignatureReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */