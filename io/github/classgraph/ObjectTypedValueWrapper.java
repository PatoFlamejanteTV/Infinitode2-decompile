/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ObjectTypedValueWrapper
/*     */   extends ScanResultObject
/*     */ {
/*     */   private AnnotationEnumValue annotationEnumValue;
/*     */   private AnnotationClassRef annotationClassRef;
/*     */   private AnnotationInfo annotationInfo;
/*     */   private String stringValue;
/*     */   private Integer integerValue;
/*     */   private Long longValue;
/*     */   private Short shortValue;
/*     */   private Boolean booleanValue;
/*     */   private Character characterValue;
/*     */   private Float floatValue;
/*     */   private Double doubleValue;
/*     */   private Byte byteValue;
/*     */   private String[] stringArrayValue;
/*     */   private int[] intArrayValue;
/*     */   private long[] longArrayValue;
/*     */   private short[] shortArrayValue;
/*     */   private boolean[] booleanArrayValue;
/*     */   private char[] charArrayValue;
/*     */   private float[] floatArrayValue;
/*     */   private double[] doubleArrayValue;
/*     */   private byte[] byteArrayValue;
/*     */   private ObjectTypedValueWrapper[] objectArrayValue;
/*     */   
/*     */   public ObjectTypedValueWrapper() {}
/*     */   
/*     */   public ObjectTypedValueWrapper(Object paramObject) {
/* 128 */     if (paramObject != null) {
/*     */       int i; Class<?> clazz;
/* 130 */       if ((clazz = paramObject.getClass()).isArray()) {
/*     */         
/* 132 */         if (clazz == String[].class) {
/* 133 */           this.stringArrayValue = (String[])paramObject; return;
/* 134 */         }  if (clazz == int[].class) {
/* 135 */           this.intArrayValue = (int[])paramObject; return;
/* 136 */         }  if (clazz == long[].class) {
/* 137 */           this.longArrayValue = (long[])paramObject; return;
/* 138 */         }  if (clazz == short[].class) {
/* 139 */           this.shortArrayValue = (short[])paramObject; return;
/* 140 */         }  if (clazz == boolean[].class) {
/* 141 */           this.booleanArrayValue = (boolean[])paramObject; return;
/* 142 */         }  if (clazz == char[].class) {
/* 143 */           this.charArrayValue = (char[])paramObject; return;
/* 144 */         }  if (clazz == float[].class) {
/* 145 */           this.floatArrayValue = (float[])paramObject; return;
/* 146 */         }  if (clazz == double[].class) {
/* 147 */           this.doubleArrayValue = (double[])paramObject; return;
/* 148 */         }  if (clazz == byte[].class) {
/* 149 */           this.byteArrayValue = (byte[])paramObject;
/*     */           return;
/*     */         } 
/* 152 */         i = Array.getLength(paramObject);
/* 153 */         this.objectArrayValue = new ObjectTypedValueWrapper[i];
/* 154 */         for (byte b = 0; b < i; b++)
/* 155 */           this.objectArrayValue[b] = new ObjectTypedValueWrapper(Array.get(paramObject, b)); 
/*     */         return;
/*     */       } 
/* 158 */       if (paramObject instanceof AnnotationEnumValue) {
/* 159 */         this.annotationEnumValue = (AnnotationEnumValue)paramObject; return;
/* 160 */       }  if (paramObject instanceof AnnotationClassRef) {
/* 161 */         this.annotationClassRef = (AnnotationClassRef)paramObject; return;
/* 162 */       }  if (paramObject instanceof AnnotationInfo) {
/* 163 */         this.annotationInfo = (AnnotationInfo)paramObject; return;
/* 164 */       }  if (paramObject instanceof String) {
/* 165 */         this.stringValue = (String)paramObject; return;
/* 166 */       }  if (paramObject instanceof Integer) {
/* 167 */         this.integerValue = (Integer)paramObject; return;
/* 168 */       }  if (paramObject instanceof Long) {
/* 169 */         this.longValue = (Long)paramObject; return;
/* 170 */       }  if (paramObject instanceof Short) {
/* 171 */         this.shortValue = (Short)paramObject; return;
/* 172 */       }  if (paramObject instanceof Boolean) {
/* 173 */         this.booleanValue = (Boolean)paramObject; return;
/* 174 */       }  if (paramObject instanceof Character) {
/* 175 */         this.characterValue = (Character)paramObject; return;
/* 176 */       }  if (paramObject instanceof Float) {
/* 177 */         this.floatValue = (Float)paramObject; return;
/* 178 */       }  if (paramObject instanceof Double) {
/* 179 */         this.doubleValue = (Double)paramObject; return;
/* 180 */       }  if (paramObject instanceof Byte) {
/* 181 */         this.byteValue = (Byte)paramObject; return;
/*     */       } 
/* 183 */       throw new IllegalArgumentException("Unsupported annotation parameter value type: " + i
/* 184 */           .getName());
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
/*     */ 
/*     */   
/*     */   Object instantiateOrGet(ClassInfo paramClassInfo, String paramString) {
/* 201 */     boolean bool = (paramClassInfo != null) ? true : false;
/* 202 */     if (this.annotationEnumValue != null)
/* 203 */       return bool ? this.annotationEnumValue.loadClassAndReturnEnumValue() : this.annotationEnumValue; 
/* 204 */     if (this.annotationClassRef != null)
/* 205 */       return bool ? this.annotationClassRef.loadClass() : this.annotationClassRef; 
/* 206 */     if (this.annotationInfo != null)
/* 207 */       return bool ? this.annotationInfo.loadClassAndInstantiate() : this.annotationInfo; 
/* 208 */     if (this.stringValue != null)
/* 209 */       return this.stringValue; 
/* 210 */     if (this.integerValue != null)
/* 211 */       return this.integerValue; 
/* 212 */     if (this.longValue != null)
/* 213 */       return this.longValue; 
/* 214 */     if (this.shortValue != null)
/* 215 */       return this.shortValue; 
/* 216 */     if (this.booleanValue != null)
/* 217 */       return this.booleanValue; 
/* 218 */     if (this.characterValue != null)
/* 219 */       return this.characterValue; 
/* 220 */     if (this.floatValue != null)
/* 221 */       return this.floatValue; 
/* 222 */     if (this.doubleValue != null)
/* 223 */       return this.doubleValue; 
/* 224 */     if (this.byteValue != null)
/* 225 */       return this.byteValue; 
/* 226 */     if (this.stringArrayValue != null)
/* 227 */       return this.stringArrayValue; 
/* 228 */     if (this.intArrayValue != null)
/* 229 */       return this.intArrayValue; 
/* 230 */     if (this.longArrayValue != null)
/* 231 */       return this.longArrayValue; 
/* 232 */     if (this.shortArrayValue != null)
/* 233 */       return this.shortArrayValue; 
/* 234 */     if (this.booleanArrayValue != null)
/* 235 */       return this.booleanArrayValue; 
/* 236 */     if (this.charArrayValue != null)
/* 237 */       return this.charArrayValue; 
/* 238 */     if (this.floatArrayValue != null)
/* 239 */       return this.floatArrayValue; 
/* 240 */     if (this.doubleArrayValue != null)
/* 241 */       return this.doubleArrayValue; 
/* 242 */     if (this.byteArrayValue != null)
/* 243 */       return this.byteArrayValue; 
/* 244 */     if (this.objectArrayValue != null) {
/*     */       Class<?> clazz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 252 */       Object object = ((clazz = (Class<?>)(bool ? getArrayValueClassOrName(paramClassInfo, paramString, true) : null)) == null) ? new Object[this.objectArrayValue.length] : Array.newInstance(clazz, this.objectArrayValue.length);
/*     */       
/* 254 */       for (byte b = 0; b < this.objectArrayValue.length; b++) {
/* 255 */         if (this.objectArrayValue[b] != null) {
/*     */           
/* 257 */           Object object1 = this.objectArrayValue[b].instantiateOrGet(paramClassInfo, paramString);
/*     */           
/* 259 */           Array.set(object, b, object1);
/*     */         } 
/*     */       } 
/* 262 */       return object;
/*     */     } 
/* 264 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get() {
/* 274 */     return instantiateOrGet(null, null);
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
/*     */ 
/*     */   
/*     */   private Object getArrayValueClassOrName(ClassInfo paramClassInfo, String paramString, boolean paramBoolean) {
/* 295 */     MethodInfoList methodInfoList = (paramClassInfo == null || paramClassInfo.methodInfo == null) ? null : paramClassInfo.methodInfo.get(paramString);
/* 296 */     if (paramClassInfo != null && methodInfoList != null && !methodInfoList.isEmpty()) {
/* 297 */       if (methodInfoList.size() > 1)
/*     */       {
/* 299 */         throw new IllegalArgumentException("Duplicated annotation parameter method " + paramString + "() in annotation class " + paramClassInfo
/* 300 */             .getName());
/*     */       }
/*     */ 
/*     */       
/*     */       TypeSignature typeSignature2;
/*     */       
/* 306 */       if (!(typeSignature2 = methodInfoList.get(0).getTypeSignatureOrTypeDescriptor().getResultType() instanceof ArrayTypeSignature)) {
/* 307 */         throw new IllegalArgumentException("Annotation parameter " + paramString + " in annotation class " + paramClassInfo
/* 308 */             .getName() + " holds an array, but does not have an array type signature");
/*     */       }
/*     */       
/*     */       ArrayTypeSignature arrayTypeSignature;
/* 312 */       if ((arrayTypeSignature = (ArrayTypeSignature)typeSignature2).getNumDimensions() != 1) {
/* 313 */         throw new IllegalArgumentException("Annotations only support 1-dimensional arrays");
/*     */       }
/*     */       TypeSignature typeSignature1;
/* 316 */       if (typeSignature1 = arrayTypeSignature.getElementTypeSignature() instanceof ClassRefTypeSignature) {
/*     */         
/* 318 */         ClassRefTypeSignature classRefTypeSignature = (ClassRefTypeSignature)typeSignature1;
/* 319 */         return paramBoolean ? classRefTypeSignature.loadClass() : classRefTypeSignature.getClassName();
/* 320 */       }  if (typeSignature1 instanceof BaseTypeSignature) {
/*     */         
/* 322 */         BaseTypeSignature baseTypeSignature = (BaseTypeSignature)typeSignature1;
/* 323 */         return paramBoolean ? baseTypeSignature.getType() : baseTypeSignature.getTypeStr();
/*     */       } 
/*     */     } else {
/*     */       int i; byte b;
/*     */       ObjectTypedValueWrapper[] arrayOfObjectTypedValueWrapper;
/* 328 */       for (i = (arrayOfObjectTypedValueWrapper = this.objectArrayValue).length, b = 0; b < i; b++) {
/* 329 */         ObjectTypedValueWrapper objectTypedValueWrapper; if ((objectTypedValueWrapper = arrayOfObjectTypedValueWrapper[b]) != null) {
/*     */           
/* 331 */           if (objectTypedValueWrapper.integerValue != null) return paramBoolean ? Integer.class : "int";  if (objectTypedValueWrapper.longValue != null) return paramBoolean ? Long.class : "long";  if (objectTypedValueWrapper.shortValue != null) return paramBoolean ? Short.class : "short";  if (objectTypedValueWrapper.characterValue != null) return paramBoolean ? Character.class : "char";  if (objectTypedValueWrapper.byteValue != null) return paramBoolean ? Byte.class : "byte";  if (objectTypedValueWrapper.booleanValue != null) return paramBoolean ? Boolean.class : "boolean";  if (objectTypedValueWrapper.doubleValue != null) return paramBoolean ? Double.class : "double";  if (objectTypedValueWrapper.floatValue != null) return paramBoolean ? Float.class : "float";  if (paramBoolean)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 343 */             return objectTypedValueWrapper.getClass(); }  return objectTypedValueWrapper
/* 344 */             .getClass()
/* 345 */             .getName();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 350 */     return paramBoolean ? Object.class : "java.lang.Object";
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
/*     */   void convertWrapperArraysToPrimitiveArrays(ClassInfo paramClassInfo, String paramString) {
/* 362 */     if (this.annotationInfo != null) {
/*     */       
/* 364 */       this.annotationInfo.convertWrapperArraysToPrimitiveArrays(); return;
/* 365 */     }  if (this.objectArrayValue != null) {
/* 366 */       byte b; ObjectTypedValueWrapper[] arrayOfObjectTypedValueWrapper; for (int i = (arrayOfObjectTypedValueWrapper = this.objectArrayValue).length; null < i; null++) {
/* 367 */         ObjectTypedValueWrapper objectTypedValueWrapper; if ((objectTypedValueWrapper = arrayOfObjectTypedValueWrapper[null]).annotationInfo != null)
/*     */         {
/* 369 */           objectTypedValueWrapper.annotationInfo.convertWrapperArraysToPrimitiveArrays();
/*     */         }
/*     */       } 
/*     */       
/* 373 */       if (this.objectArrayValue.getClass().getComponentType().isArray()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       String str;
/*     */ 
/*     */ 
/*     */       
/* 383 */       switch (str = (String)getArrayValueClassOrName(paramClassInfo, paramString, false)) {
/*     */         
/*     */         case "java.lang.String":
/* 386 */           this.stringArrayValue = new String[this.objectArrayValue.length];
/* 387 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/* 388 */             this.stringArrayValue[b] = (this.objectArrayValue[b]).stringValue;
/*     */           }
/* 390 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "int":
/* 393 */           this.intArrayValue = new int[this.objectArrayValue.length];
/* 394 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 396 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 397 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 400 */                   .getName()));
/*     */             }
/* 402 */             this.intArrayValue[b] = (this.objectArrayValue[b]).integerValue.intValue();
/*     */           } 
/* 404 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "long":
/* 407 */           this.longArrayValue = new long[this.objectArrayValue.length];
/* 408 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 410 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 411 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 414 */                   .getName()));
/*     */             }
/* 416 */             this.longArrayValue[b] = (this.objectArrayValue[b]).longValue.longValue();
/*     */           } 
/* 418 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "short":
/* 421 */           this.shortArrayValue = new short[this.objectArrayValue.length];
/* 422 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 424 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 425 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 428 */                   .getName()));
/*     */             }
/* 430 */             this.shortArrayValue[b] = (this.objectArrayValue[b]).shortValue.shortValue();
/*     */           } 
/* 432 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "char":
/* 435 */           this.charArrayValue = new char[this.objectArrayValue.length];
/* 436 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 438 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 439 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 442 */                   .getName()));
/*     */             }
/* 444 */             this.charArrayValue[b] = (this.objectArrayValue[b]).characterValue.charValue();
/*     */           } 
/* 446 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "float":
/* 449 */           this.floatArrayValue = new float[this.objectArrayValue.length];
/* 450 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 452 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 453 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 456 */                   .getName()));
/*     */             }
/* 458 */             this.floatArrayValue[b] = (this.objectArrayValue[b]).floatValue.floatValue();
/*     */           } 
/* 460 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "double":
/* 463 */           this.doubleArrayValue = new double[this.objectArrayValue.length];
/* 464 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 466 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 467 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 470 */                   .getName()));
/*     */             }
/* 472 */             this.doubleArrayValue[b] = (this.objectArrayValue[b]).doubleValue.doubleValue();
/*     */           } 
/* 474 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "boolean":
/* 477 */           this.booleanArrayValue = new boolean[this.objectArrayValue.length];
/* 478 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 480 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 481 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 484 */                   .getName()));
/*     */             }
/* 486 */             this.booleanArrayValue[b] = (this.objectArrayValue[b]).booleanValue.booleanValue();
/*     */           } 
/* 488 */           this.objectArrayValue = null;
/*     */           return;
/*     */         case "byte":
/* 491 */           this.byteArrayValue = new byte[this.objectArrayValue.length];
/* 492 */           for (b = 0; b < this.objectArrayValue.length; b++) {
/*     */             ObjectTypedValueWrapper objectTypedValueWrapper;
/* 494 */             if ((objectTypedValueWrapper = this.objectArrayValue[b]) == null) {
/* 495 */               throw new IllegalArgumentException("Illegal null value for array of element type " + str + " in parameter " + paramString + " of annotation class " + ((paramClassInfo == null) ? "<class outside accept>" : paramClassInfo
/*     */ 
/*     */                   
/* 498 */                   .getName()));
/*     */             }
/* 500 */             this.byteArrayValue[b] = (this.objectArrayValue[b]).byteValue.byteValue();
/*     */           } 
/* 502 */           this.objectArrayValue = null;
/*     */           break;
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
/*     */   protected String getClassName() {
/* 519 */     throw new IllegalArgumentException("getClassName() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassInfo getClassInfo() {
/* 527 */     throw new IllegalArgumentException("getClassInfo() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {
/* 535 */     super.setScanResult(paramScanResult);
/* 536 */     if (this.annotationEnumValue != null) {
/* 537 */       this.annotationEnumValue.setScanResult(paramScanResult); return;
/* 538 */     }  if (this.annotationClassRef != null) {
/* 539 */       this.annotationClassRef.setScanResult(paramScanResult); return;
/* 540 */     }  if (this.annotationInfo != null) {
/* 541 */       this.annotationInfo.setScanResult(paramScanResult); return;
/* 542 */     }  if (this.objectArrayValue != null) {
/* 543 */       ObjectTypedValueWrapper[] arrayOfObjectTypedValueWrapper; int i; byte b; for (i = (arrayOfObjectTypedValueWrapper = this.objectArrayValue).length, b = 0; b < i; b++) {
/* 544 */         ObjectTypedValueWrapper objectTypedValueWrapper; if ((objectTypedValueWrapper = arrayOfObjectTypedValueWrapper[b]) != null) {
/* 545 */           objectTypedValueWrapper.setScanResult(paramScanResult);
/*     */         }
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
/*     */   protected void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/* 562 */     if (this.annotationEnumValue != null) {
/* 563 */       this.annotationEnumValue.findReferencedClassInfo(paramMap, paramSet, paramLogNode); return;
/* 564 */     }  if (this.annotationClassRef != null) {
/*     */       ClassInfo classInfo;
/* 566 */       if ((classInfo = this.annotationClassRef.getClassInfo()) != null)
/* 567 */         paramSet.add(classInfo);  return;
/*     */     } 
/* 569 */     if (this.annotationInfo != null) {
/* 570 */       this.annotationInfo.findReferencedClassInfo(paramMap, paramSet, paramLogNode); return;
/* 571 */     }  if (this.objectArrayValue != null) {
/* 572 */       ObjectTypedValueWrapper[] arrayOfObjectTypedValueWrapper; int i; byte b; for (i = (arrayOfObjectTypedValueWrapper = this.objectArrayValue).length, b = 0; b < i; b++) {
/* 573 */         ObjectTypedValueWrapper objectTypedValueWrapper; (objectTypedValueWrapper = arrayOfObjectTypedValueWrapper[b]).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
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
/*     */   public int hashCode() {
/* 585 */     return Objects.hash(new Object[] { this.annotationEnumValue, this.annotationClassRef, this.annotationInfo, this.stringValue, this.integerValue, this.longValue, this.shortValue, this.booleanValue, this.characterValue, this.floatValue, this.doubleValue, this.byteValue, 
/*     */           
/* 587 */           Integer.valueOf(Arrays.hashCode((Object[])this.stringArrayValue)), Integer.valueOf(Arrays.hashCode(this.intArrayValue)), Integer.valueOf(Arrays.hashCode(this.longArrayValue)), 
/* 588 */           Integer.valueOf(Arrays.hashCode(this.shortArrayValue)), Integer.valueOf(Arrays.hashCode(this.booleanArrayValue)), 
/* 589 */           Integer.valueOf(Arrays.hashCode(this.charArrayValue)), Integer.valueOf(Arrays.hashCode(this.floatArrayValue)), 
/* 590 */           Integer.valueOf(Arrays.hashCode(this.doubleArrayValue)), Integer.valueOf(Arrays.hashCode(this.byteArrayValue)), 
/* 591 */           Integer.valueOf(Arrays.hashCode((Object[])this.objectArrayValue)) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 599 */     if (paramObject == this)
/* 600 */       return true; 
/* 601 */     if (!(paramObject instanceof ObjectTypedValueWrapper)) {
/* 602 */       return false;
/*     */     }
/* 604 */     paramObject = paramObject;
/* 605 */     if (Objects.equals(this.annotationEnumValue, ((ObjectTypedValueWrapper)paramObject).annotationEnumValue) && 
/* 606 */       Objects.equals(this.annotationClassRef, ((ObjectTypedValueWrapper)paramObject).annotationClassRef) && 
/* 607 */       Objects.equals(this.annotationInfo, ((ObjectTypedValueWrapper)paramObject).annotationInfo) && Objects.equals(this.stringValue, ((ObjectTypedValueWrapper)paramObject).stringValue) && 
/* 608 */       Objects.equals(this.integerValue, ((ObjectTypedValueWrapper)paramObject).integerValue) && Objects.equals(this.longValue, ((ObjectTypedValueWrapper)paramObject).longValue) && 
/* 609 */       Objects.equals(this.shortValue, ((ObjectTypedValueWrapper)paramObject).shortValue) && Objects.equals(this.booleanValue, ((ObjectTypedValueWrapper)paramObject).booleanValue) && 
/* 610 */       Objects.equals(this.characterValue, ((ObjectTypedValueWrapper)paramObject).characterValue) && Objects.equals(this.floatValue, ((ObjectTypedValueWrapper)paramObject).floatValue) && 
/* 611 */       Objects.equals(this.doubleValue, ((ObjectTypedValueWrapper)paramObject).doubleValue) && Objects.equals(this.byteValue, ((ObjectTypedValueWrapper)paramObject).byteValue) && 
/* 612 */       Arrays.equals((Object[])this.stringArrayValue, (Object[])((ObjectTypedValueWrapper)paramObject).stringArrayValue) && 
/* 613 */       Arrays.equals(this.intArrayValue, ((ObjectTypedValueWrapper)paramObject).intArrayValue) && Arrays.equals(this.longArrayValue, ((ObjectTypedValueWrapper)paramObject).longArrayValue) && 
/* 614 */       Arrays.equals(this.shortArrayValue, ((ObjectTypedValueWrapper)paramObject).shortArrayValue) && 
/* 615 */       Arrays.equals(this.floatArrayValue, ((ObjectTypedValueWrapper)paramObject).floatArrayValue) && 
/* 616 */       Arrays.equals(this.byteArrayValue, ((ObjectTypedValueWrapper)paramObject).byteArrayValue) && 
/* 617 */       Arrays.deepEquals((Object[])this.objectArrayValue, (Object[])((ObjectTypedValueWrapper)paramObject).objectArrayValue)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 624 */     if (this.annotationEnumValue != null) {
/* 625 */       this.annotationEnumValue.toString(paramBoolean, paramStringBuilder); return;
/* 626 */     }  if (this.annotationClassRef != null) {
/* 627 */       this.annotationClassRef.toString(paramBoolean, paramStringBuilder); return;
/* 628 */     }  if (this.annotationInfo != null) {
/* 629 */       this.annotationInfo.toString(paramBoolean, paramStringBuilder); return;
/* 630 */     }  if (this.stringValue != null) {
/* 631 */       paramStringBuilder.append(this.stringValue); return;
/* 632 */     }  if (this.integerValue != null) {
/* 633 */       paramStringBuilder.append(this.integerValue); return;
/* 634 */     }  if (this.longValue != null) {
/* 635 */       paramStringBuilder.append(this.longValue); return;
/* 636 */     }  if (this.shortValue != null) {
/* 637 */       paramStringBuilder.append(this.shortValue); return;
/* 638 */     }  if (this.booleanValue != null) {
/* 639 */       paramStringBuilder.append(this.booleanValue); return;
/* 640 */     }  if (this.characterValue != null) {
/* 641 */       paramStringBuilder.append(this.characterValue); return;
/* 642 */     }  if (this.floatValue != null) {
/* 643 */       paramStringBuilder.append(this.floatValue); return;
/* 644 */     }  if (this.doubleValue != null) {
/* 645 */       paramStringBuilder.append(this.doubleValue); return;
/* 646 */     }  if (this.byteValue != null) {
/* 647 */       paramStringBuilder.append(this.byteValue); return;
/* 648 */     }  if (this.stringArrayValue != null) {
/* 649 */       paramStringBuilder.append(Arrays.toString((Object[])this.stringArrayValue)); return;
/* 650 */     }  if (this.intArrayValue != null) {
/* 651 */       paramStringBuilder.append(Arrays.toString(this.intArrayValue)); return;
/* 652 */     }  if (this.longArrayValue != null) {
/* 653 */       paramStringBuilder.append(Arrays.toString(this.longArrayValue)); return;
/* 654 */     }  if (this.shortArrayValue != null) {
/* 655 */       paramStringBuilder.append(Arrays.toString(this.shortArrayValue)); return;
/* 656 */     }  if (this.booleanArrayValue != null) {
/* 657 */       paramStringBuilder.append(Arrays.toString(this.booleanArrayValue)); return;
/* 658 */     }  if (this.charArrayValue != null) {
/* 659 */       paramStringBuilder.append(Arrays.toString(this.charArrayValue)); return;
/* 660 */     }  if (this.floatArrayValue != null) {
/* 661 */       paramStringBuilder.append(Arrays.toString(this.floatArrayValue)); return;
/* 662 */     }  if (this.doubleArrayValue != null) {
/* 663 */       paramStringBuilder.append(Arrays.toString(this.doubleArrayValue)); return;
/* 664 */     }  if (this.byteArrayValue != null) {
/* 665 */       paramStringBuilder.append(Arrays.toString(this.byteArrayValue)); return;
/* 666 */     }  if (this.objectArrayValue != null)
/*     */     {
/* 668 */       paramStringBuilder.append(Arrays.toString((Object[])this.objectArrayValue));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ObjectTypedValueWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */