/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.ConstantDynamic;
/*     */ import net.bytebuddy.jar.asm.Handle;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureReader;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureVisitor;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureWriter;
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
/*     */ public abstract class Remapper
/*     */ {
/*     */   public String mapDesc(String paramString) {
/*  55 */     return mapType(Type.getType(paramString)).getDescriptor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Type mapType(Type paramType) {
/*     */     StringBuilder stringBuilder;
/*     */     byte b;
/*     */     String str;
/*  69 */     switch (paramType.getSort()) {
/*     */       case 9:
/*  71 */         stringBuilder = new StringBuilder();
/*  72 */         for (b = 0; b < paramType.getDimensions(); b++) {
/*  73 */           stringBuilder.append('[');
/*     */         }
/*  75 */         stringBuilder.append(mapType(paramType.getElementType()).getDescriptor());
/*  76 */         return Type.getType(stringBuilder.toString());
/*     */       
/*     */       case 10:
/*  79 */         return ((str = map(paramType.getInternalName())) != null) ? Type.getObjectType(str) : paramType;
/*     */       case 11:
/*  81 */         return Type.getMethodType(mapMethodDesc(paramType.getDescriptor()));
/*     */     } 
/*  83 */     return paramType;
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
/*     */   public String mapType(String paramString) {
/*  96 */     if (paramString == null) {
/*  97 */       return null;
/*     */     }
/*  99 */     return mapType(Type.getObjectType(paramString)).getInternalName();
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
/*     */   public String[] mapTypes(String[] paramArrayOfString) {
/* 111 */     String[] arrayOfString = null;
/* 112 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 113 */       String str = paramArrayOfString[b];
/*     */       
/* 115 */       if ((str = mapType(str)) != null) {
/* 116 */         if (arrayOfString == null) {
/* 117 */           arrayOfString = (String[])paramArrayOfString.clone();
/*     */         }
/* 119 */         arrayOfString[b] = str;
/*     */       } 
/*     */     } 
/* 122 */     return (arrayOfString != null) ? arrayOfString : paramArrayOfString;
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
/*     */   public String mapMethodDesc(String paramString) {
/* 134 */     if ("()V".equals(paramString)) {
/* 135 */       return paramString;
/*     */     }
/*     */     
/* 138 */     StringBuilder stringBuilder = new StringBuilder("("); Type[] arrayOfType; int i; byte b;
/* 139 */     for (i = (arrayOfType = Type.getArgumentTypes(paramString)).length, b = 0; b < i; ) { Type type1 = arrayOfType[b];
/* 140 */       stringBuilder.append(mapType(type1).getDescriptor()); b++; }
/*     */     
/*     */     Type type;
/* 143 */     if ((type = Type.getReturnType(paramString)) == Type.VOID_TYPE) {
/* 144 */       stringBuilder.append(")V");
/*     */     } else {
/* 146 */       stringBuilder.append(')').append(mapType(type).getDescriptor());
/*     */     } 
/* 148 */     return stringBuilder.toString();
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
/*     */   public Object mapValue(Object paramObject) {
/* 162 */     if (paramObject instanceof Type) {
/* 163 */       return mapType((Type)paramObject);
/*     */     }
/* 165 */     if (paramObject instanceof Handle) {
/*     */       
/* 167 */       boolean bool = ((paramObject = paramObject).getTag() <= 4) ? true : false;
/*     */       
/* 169 */       return new Handle(paramObject
/* 170 */           .getTag(), 
/* 171 */           mapType(paramObject.getOwner()), 
/* 172 */           bool ? 
/* 173 */           mapFieldName(paramObject.getOwner(), paramObject.getName(), paramObject.getDesc()) : 
/* 174 */           mapMethodName(paramObject.getOwner(), paramObject.getName(), paramObject.getDesc()), 
/* 175 */           bool ? mapDesc(paramObject.getDesc()) : mapMethodDesc(paramObject.getDesc()), paramObject
/* 176 */           .isInterface());
/*     */     } 
/* 178 */     if (paramObject instanceof ConstantDynamic) {
/*     */       int i;
/*     */       
/* 181 */       Object[] arrayOfObject = new Object[i = (paramObject = paramObject).getBootstrapMethodArgumentCount()];
/* 182 */       for (byte b = 0; b < i; b++) {
/* 183 */         arrayOfObject[b] = 
/* 184 */           mapValue(paramObject.getBootstrapMethodArgument(b));
/*     */       }
/* 186 */       String str = paramObject.getDescriptor();
/* 187 */       return new ConstantDynamic(
/* 188 */           mapInvokeDynamicMethodName(paramObject.getName(), str), 
/* 189 */           mapDesc(str), (Handle)
/* 190 */           mapValue(paramObject.getBootstrapMethod()), arrayOfObject);
/*     */     } 
/*     */     
/* 193 */     return paramObject;
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
/*     */   public String mapSignature(String paramString, boolean paramBoolean) {
/* 206 */     if (paramString == null) {
/* 207 */       return null;
/*     */     }
/* 209 */     SignatureReader signatureReader = new SignatureReader(paramString);
/* 210 */     SignatureWriter signatureWriter = new SignatureWriter();
/* 211 */     SignatureVisitor signatureVisitor = createSignatureRemapper((SignatureVisitor)signatureWriter);
/* 212 */     if (paramBoolean) {
/* 213 */       signatureReader.acceptType(signatureVisitor);
/*     */     } else {
/* 215 */       signatureReader.accept(signatureVisitor);
/*     */     } 
/* 217 */     return signatureWriter.toString();
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
/*     */   @Deprecated
/*     */   protected SignatureVisitor createRemappingSignatureAdapter(SignatureVisitor paramSignatureVisitor) {
/* 231 */     return createSignatureRemapper(paramSignatureVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SignatureVisitor createSignatureRemapper(SignatureVisitor paramSignatureVisitor) {
/* 242 */     return new SignatureRemapper(paramSignatureVisitor, this);
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
/*     */   public String mapAnnotationAttributeName(String paramString1, String paramString2) {
/* 254 */     return paramString2;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapInnerClassName(String paramString1, String paramString2, String paramString3) {
/* 273 */     if ((paramString2 = mapType(paramString1)).equals(paramString1)) {
/* 274 */       return paramString3;
/*     */     }
/* 276 */     int i = paramString1.lastIndexOf('/');
/* 277 */     int j = paramString2.lastIndexOf('/');
/* 278 */     if (i != -1 && j != -1 && 
/* 279 */       paramString1.substring(i).equals(paramString2.substring(j)))
/*     */     {
/* 281 */       return paramString3;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 286 */     if (paramString2.contains("$")) {
/* 287 */       i = paramString2.lastIndexOf('$') + 1;
/* 288 */       while (i < paramString2.length() && 
/* 289 */         Character.isDigit(paramString2.charAt(i))) {
/* 290 */         i++;
/*     */       }
/* 292 */       return paramString2.substring(i);
/*     */     } 
/* 294 */     return paramString3;
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
/*     */   
/*     */   public String mapMethodName(String paramString1, String paramString2, String paramString3) {
/* 309 */     return paramString2;
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
/*     */   public String mapInvokeDynamicMethodName(String paramString1, String paramString2) {
/* 321 */     return paramString1;
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
/*     */   
/*     */   public String mapRecordComponentName(String paramString1, String paramString2, String paramString3) {
/* 336 */     return paramString2;
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
/*     */   public String mapFieldName(String paramString1, String paramString2, String paramString3) {
/* 350 */     return paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapPackageName(String paramString) {
/* 361 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapModuleName(String paramString) {
/* 372 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String map(String paramString) {
/* 383 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\Remapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */