/*      */ package com.prineside.tdi2.desktop.luadef;
/*      */ 
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.desktop.LuaDefinitionsGenerator;
/*      */ import com.prineside.tdi2.managers.script.Whitelist;
/*      */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*      */ import com.prineside.tdi2.utils.ObjectIntPair;
/*      */ import com.prineside.tdi2.utils.ReflectionUtils;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.FileReader;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Parameter;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class ClassDefData {
/*   25 */   private static final TLog a = TLog.forClass(ClassDefData.class);
/*      */   
/*      */   public static final int CLASS_TYPE_CLASS = 0;
/*      */   
/*      */   public static final int CLASS_TYPE_INTERFACE = 1;
/*      */   
/*      */   public static final int CLASS_TYPE_FUNCTIONAL_INTERFACE = 2;
/*      */   
/*      */   public static final int CLASS_TYPE_ANNOTATION = 3;
/*      */   
/*      */   public static final int CLASS_TYPE_ENUM = 4;
/*      */   
/*      */   public static final int CLASS_TYPE_ABSTRACT_CLASS = 5;
/*      */   
/*      */   private static Array<Class<?>> b;
/*      */   private final LuaDefinitionsGenerator c;
/*      */   public final Class<?> clazz;
/*      */   public final String filePath;
/*      */   public int classType;
/*      */   public boolean isSerializable;
/*   45 */   public Array<InnerClassData> innerClasses = new Array();
/*   46 */   public Array<FieldData> staticFields = new Array(); @Null
/*      */   public FunctionalInterfaceProxyData functionalInterfaceProxyData;
/*   48 */   public Array<ConstructorData> constructors = new Array();
/*   49 */   public Array<MethodData> staticMethods = new Array(); @Null
/*      */   public Class<?> superClass;
/*   51 */   public Array<Class<?>> allInterfaces = new Array();
/*   52 */   public Array<FieldData> instanceFields = new Array();
/*   53 */   public Array<MethodData> instanceMethods = new Array(); @Null
/*      */   public String javadocUrl; @Null
/*      */   public String classDescription;
/*      */   @Null
/*      */   public String classGenericsString;
/*      */   
/*      */   public ClassDefData(LuaDefinitionsGenerator paramLuaDefinitionsGenerator, Class<?> paramClass) {
/*   60 */     this.c = paramLuaDefinitionsGenerator;
/*   61 */     this.clazz = paramClass;
/*      */     
/*   63 */     this.filePath = paramClass.getName().replaceAll("\\.", "/").replaceAll("\\$", "_");
/*      */   }
/*      */   
/*      */   private static Array<Class<?>> a() {
/*   67 */     if (b == null) {
/*   68 */       b = new Array(); 
/*   69 */       try { FileReader fileReader = new FileReader("res/luaj/interfaces-priority.txt"); 
/*   70 */         try { BufferedReader bufferedReader = new BufferedReader(fileReader);
/*   71 */           byte b = 1;
/*      */           
/*      */           String str;
/*   74 */           while ((str = bufferedReader.readLine()) != null) {
/*      */ 
/*      */ 
/*      */             
/*   78 */             if ((str = str.trim()).length() != 0 && 
/*   79 */               str.charAt(0) != '#') {
/*      */               try {
/*      */                 Class<?> clazz;
/*   82 */                 if (!(clazz = Class.forName(str)).isInterface()) {
/*   83 */                   throw new IllegalArgumentException(clazz + " is not an interface");
/*      */                 }
/*   85 */                 b.add(clazz);
/*   86 */               } catch (Exception exception) {
/*   87 */                 a.e("Failed to get class for '%s' defined on line %s in interfaces-priority.txt", new Object[] { str, Integer.valueOf(b), exception });
/*      */               } 
/*      */             }
/*      */             
/*   91 */             b++;
/*      */           } 
/*   93 */           fileReader.close(); } catch (Throwable throwable) { try { fileReader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception exception)
/*   94 */       { a.e("Failed to load interfaces-priority.txt", new Object[0]); }
/*      */     
/*      */     } 
/*   97 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String a(Class<?> paramClass) {
/*  104 */     if (paramClass == CharSequence.class) {
/*  105 */       return "|string";
/*      */     }
/*  107 */     if (paramClass == CharSequence[].class) {
/*  108 */       return "|string[]";
/*      */     }
/*  110 */     if (paramClass == CharSequence[][].class) {
/*  111 */       return "|string[][]";
/*      */     }
/*  113 */     if (paramClass == Object.class) {
/*  114 */       return "|any";
/*      */     }
/*  116 */     if (paramClass == Object[].class) {
/*  117 */       return "|any[]";
/*      */     }
/*  119 */     if (paramClass == Object[][].class) {
/*  120 */       return "|any[][]";
/*      */     }
/*  122 */     return "";
/*      */   }
/*      */   
/*      */   private ParamData a(int paramInt, Parameter paramParameter, @Null JavadocHandler.ParamJD paramParamJD, Object paramObject) {
/*  126 */     String str1 = "arg" + paramInt;
/*  127 */     Class<?> clazz = paramParameter.getType();
/*      */     
/*  129 */     if (paramParameter.isVarArgs()) {
/*  130 */       str1 = "...";
/*  131 */       if (clazz.isArray()) {
/*  132 */         clazz = clazz.getComponentType();
/*      */       } else {
/*  134 */         a.w("varargs param type " + paramParameter + " of " + paramObject + " is not an array", new Object[0]);
/*      */       } 
/*      */     } else {
/*  137 */       if (paramParamJD != null) {
/*  138 */         str1 = paramParamJD.name;
/*      */       }
/*  140 */       if (LuaDefUtils.LUA_KEYWORDS.contains(str1)) {
/*  141 */         str1 = "p_" + str1;
/*      */       }
/*      */     } 
/*      */     
/*      */     String str2;
/*  146 */     if ((str2 = this.c.getLuaClassName(clazz, true)) == null) {
/*  147 */       a.e("not accessible parameter type for '" + clazz + "' in " + paramObject, new Object[0]);
/*  148 */       str2 = "any";
/*      */     } 
/*  150 */     str2 = str2 + a(clazz);
/*      */     
/*      */     ParamData paramData;
/*  153 */     (paramData = new ParamData()).param = paramParameter;
/*  154 */     paramData.name = str1;
/*  155 */     paramData.typeName = str2;
/*  156 */     if (paramObject instanceof Constructor) {
/*  157 */       paramData.canBeNull = this.c.hasNullAnnotation((Constructor)paramObject, paramInt);
/*  158 */     } else if (paramObject instanceof Method) {
/*  159 */       paramData.canBeNull = this.c.hasNullAnnotation((Method)paramObject, paramInt);
/*      */     } 
/*  161 */     if (paramParamJD != null) {
/*  162 */       paramData.description = paramParamJD.description;
/*      */     }
/*      */     
/*  165 */     return paramData;
/*      */   }
/*      */   
/*      */   public void prepare() {
/*  169 */     JavadocHandler.ClassJD classJD = this.c.javadocHandler.getForClass(this.clazz);
/*  170 */     this.javadocUrl = classJD.javadocUrl;
/*  171 */     this.classDescription = classJD.description;
/*  172 */     this.classGenericsString = classJD.genericsString;
/*      */     
/*  174 */     this.classType = 0;
/*  175 */     this.isSerializable = false;
/*  176 */     this.innerClasses.clear();
/*  177 */     this.staticFields.clear();
/*  178 */     this.functionalInterfaceProxyData = null;
/*  179 */     this.constructors.clear();
/*  180 */     this.staticMethods.clear();
/*  181 */     this.superClass = null;
/*  182 */     this.allInterfaces.clear();
/*  183 */     this.instanceFields.clear();
/*  184 */     this.instanceMethods.clear();
/*      */     
/*  186 */     Whitelist whitelist = this.c.getWhitelist();
/*      */     
/*  188 */     Array<Field> array = LuaDefUtils.gatherFieldsCached(this.clazz);
/*  189 */     Array<Method> array1 = LuaDefUtils.gatherMethodsCached(this.clazz);
/*      */     
/*  191 */     if (this.clazz.isInterface()) {
/*  192 */       if (this.clazz.isAnnotation()) {
/*  193 */         this.classType = 3;
/*      */       }
/*  195 */       else if (whitelist.isInterfaceProxyWhiteListed(this.clazz) && (this.clazz.getDeclaredMethods()).length == 1) {
/*  196 */         this.classType = 2;
/*      */       } else {
/*  198 */         this.classType = 1;
/*      */       }
/*      */     
/*      */     }
/*  202 */     else if (this.clazz.isEnum()) {
/*  203 */       this.classType = 4;
/*      */     }
/*  205 */     else if (Modifier.isAbstract(this.clazz.getModifiers())) {
/*  206 */       this.classType = 5;
/*      */     } else {
/*  208 */       this.classType = 0;
/*      */     } 
/*      */ 
/*      */     
/*  212 */     this.isSerializable = this.c.isClassRegisteredInKryo(this.clazz);
/*      */ 
/*      */     
/*  215 */     for (byte b1 = 0; b1 < array.size; b1++) {
/*  216 */       Field field = ((Field[])array.items)[b1];
/*  217 */       if (whitelist.isFieldWhiteListed(field))
/*      */       {
/*      */         
/*  220 */         if (Modifier.isStatic(field.getModifiers())) {
/*      */           String str1;
/*      */ 
/*      */ 
/*      */           
/*  225 */           if ((str1 = this.c.getLuaClassName(field.getType(), true)) == null) {
/*  226 */             if (LuaDefinitionsGenerator.verbose) {
/*  227 */               a.i("using \"any\" as a type for " + field + " on " + this.clazz + " as it is not marked as used and will have no definitions", new Object[0]);
/*      */             }
/*  229 */             str1 = "any";
/*      */           } 
/*      */           
/*  232 */           String str2 = field.getName();
/*  233 */           if (LuaDefUtils.LUA_KEYWORDS.contains(str2)) {
/*  234 */             str2 = "_F_" + str2;
/*      */           }
/*  236 */           if (this.c.hasNullAnnotation(field)) {
/*  237 */             str2 = str2 + "?";
/*      */           }
/*      */           
/*  240 */           JavadocHandler.FieldJD fieldJD = classJD.fields.get(field);
/*      */           
/*      */           FieldData fieldData;
/*  243 */           (fieldData = new FieldData(field)).name = str2;
/*  244 */           fieldData.typeName = str1;
/*  245 */           if (fieldJD != null) {
/*  246 */             fieldData.description = fieldJD.description;
/*  247 */             fieldData.generics = fieldJD.generics;
/*      */           } 
/*  249 */           this.staticFields.add(fieldData);
/*      */         }  } 
/*      */     }  Class[] arrayOfClass; int i;
/*      */     byte b3;
/*  253 */     for (i = (arrayOfClass = this.clazz.getDeclaredClasses()).length, b3 = 0; b3 < i; ) { Class<?> clazz = arrayOfClass[b3];
/*  254 */       if (this.c.isClassUsed(clazz)) {
/*      */         InnerClassData innerClassData;
/*      */ 
/*      */         
/*  258 */         (innerClassData = new InnerClassData(clazz)).name = clazz.getSimpleName();
/*  259 */         innerClassData.typeName = this.c.getLuaClassName(clazz, false) + ".class";
/*  260 */         this.innerClasses.add(innerClassData);
/*      */       } 
/*      */       b3++; }
/*      */     
/*  264 */     if (this.clazz.isInterface() && !this.clazz.isAnnotation() && 
/*  265 */       whitelist.isInterfaceProxyWhiteListed(this.clazz) && (
/*  266 */       this.clazz.getDeclaredMethods()).length == 1) {
/*      */       
/*  268 */       Method method = this.clazz.getDeclaredMethods()[0];
/*  269 */       JavadocHandler.MethodJD methodJD = classJD.methods.get(method);
/*      */       
/*      */       String str;
/*  272 */       if ((str = this.c.getLuaClassName(method.getReturnType(), true)) == null) {
/*  273 */         str = "any";
/*      */       }
/*  275 */       str = str + a(method.getReturnType());
/*      */       
/*  277 */       this.functionalInterfaceProxyData = new FunctionalInterfaceProxyData(method);
/*  278 */       this.functionalInterfaceProxyData.returnTypeName = str;
/*      */       
/*  280 */       Parameter[] arrayOfParameter1 = method.getParameters();
/*  281 */       byte b5 = 0; Parameter[] arrayOfParameter2; int j; byte b6;
/*  282 */       for (j = (arrayOfParameter2 = arrayOfParameter1).length, b6 = 0; b6 < j; ) { Parameter parameter = arrayOfParameter2[b6];
/*  283 */         JavadocHandler.ParamJD paramJD = (methodJD == null) ? null : (JavadocHandler.ParamJD)methodJD.params.get(b5);
/*  284 */         ParamData paramData = a(b5, parameter, paramJD, method);
/*  285 */         this.functionalInterfaceProxyData.params.add(paramData);
/*      */         
/*  287 */         b5++;
/*      */         
/*      */         b6++; }
/*      */     
/*      */     } 
/*      */     
/*  293 */     if (!this.clazz.isInterface()) {
/*      */       
/*  295 */       Array<Constructor<?>> array2 = LuaDefUtils.gatherConstructorsCached(this.clazz);
/*      */       
/*  297 */       Array array3 = new Array();
/*  298 */       for (b3 = 0; b3 < array2.size; b3++) {
/*  299 */         Constructor constructor = ((Constructor[])array2.items)[b3];
/*  300 */         if (whitelist.isConstructorWhiteListed(constructor))
/*      */         {
/*      */           
/*  303 */           array3.add(constructor); } 
/*      */       } 
/*  305 */       Array array4 = null;
/*  306 */       if (array3.size >= 2) {
/*  307 */         array4 = ReflectionUtils.LuaRelated.generateOverloadSuffixForConstructors(array3);
/*      */       }
/*      */       
/*  310 */       byte b = 0;
/*  311 */       for (Array.ArrayIterator<Constructor> arrayIterator = array3.iterator(); arrayIterator.hasNext(); ) { Constructor<?> constructor = arrayIterator.next();
/*  312 */         ConstructorData constructorData = new ConstructorData(constructor);
/*  313 */         this.constructors.add(constructorData);
/*      */         
/*      */         JavadocHandler.ConstructorJD constructorJD;
/*      */         
/*  317 */         if ((constructorJD = classJD.constructors.get(constructor)) != null) {
/*  318 */           constructorData.description = constructorJD.description;
/*      */         }
/*      */         
/*  321 */         Parameter[] arrayOfParameter1 = constructor.getParameters();
/*  322 */         byte b5 = 0; int j; Parameter[] arrayOfParameter2; byte b6;
/*  323 */         for (j = (arrayOfParameter2 = arrayOfParameter1).length, b6 = 0; b6 < j; ) { Parameter parameter = arrayOfParameter2[b6];
/*  324 */           JavadocHandler.ParamJD paramJD = (constructorJD != null) ? (JavadocHandler.ParamJD)constructorJD.params.get(b5) : null;
/*      */           
/*  326 */           ParamData paramData = a(b5, parameter, paramJD, constructor);
/*  327 */           constructorData.params.add(paramData);
/*      */           
/*  329 */           b5++;
/*      */           b6++; }
/*      */         
/*  332 */         String str = "new";
/*  333 */         if (array4 != null)
/*      */         {
/*  335 */           str = str + (String)array4.get(b);
/*      */         }
/*  337 */         constructorData.name = str;
/*      */         
/*  339 */         b++; }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  344 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  345 */     for (i = 0; i < array1.size; i++) {
/*  346 */       Method method = ((Method[])array1.items)[i];
/*  347 */       if (whitelist.isMethodWhiteListedInDeclaringClass(method))
/*      */       {
/*      */         
/*  350 */         if (Modifier.isStatic(method.getModifiers())) {
/*      */           Array array2;
/*      */ 
/*      */           
/*  354 */           if ((array2 = (Array)hashMap1.get(method.getName())) == null) {
/*  355 */             hashMap1.put(method.getName(), new Array());
/*      */           }
/*  357 */           ((Array)hashMap1.get(method.getName())).add(method);
/*      */         }  } 
/*      */     } 
/*  360 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  361 */     for (Iterator<Map.Entry> iterator = hashMap1.entrySet().iterator(); iterator.hasNext();) {
/*      */       
/*  363 */       if ((array2 = (entry = iterator.next()).getValue()).size >= 2) {
/*  364 */         Array array3 = ReflectionUtils.LuaRelated.generateOverloadSuffixForMethods(array2);
/*  365 */         for (byte b = 0; b < array2.size; b++) {
/*  366 */           Method method = (Method)array2.get(b);
/*  367 */           String str = (String)array3.get(b);
/*  368 */           hashMap2.put(method, str);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  373 */     for (byte b2 = 0; b2 < array1.size; b2++) {
/*  374 */       Method method = ((Method[])array1.items)[b2];
/*  375 */       if (whitelist.isMethodWhiteListedInDeclaringClass(method))
/*      */       {
/*      */         
/*  378 */         if (Modifier.isStatic(method.getModifiers())) {
/*      */ 
/*      */ 
/*      */           
/*  382 */           MethodData methodData = new MethodData(method);
/*  383 */           this.staticMethods.add(methodData);
/*      */           
/*  385 */           String str1 = method.getName();
/*      */           String str2;
/*  387 */           if ((str2 = (String)hashMap2.get(method)) != null) {
/*  388 */             if (method.getDeclaringClass().getName().startsWith("com.prineside") && !method.isAnnotationPresent((Class)IgnoreMethodOverloadLuaDefWarning.class)) {
/*  389 */               a.w("overload method \"" + method + "\" - suffix auto-generated from parameters", new Object[0]);
/*      */             }
/*  391 */             str1 = str1 + str2;
/*      */           } 
/*      */           
/*  394 */           if (LuaDefUtils.LUA_KEYWORDS.contains(str1)) {
/*  395 */             str1 = "_M_" + str1;
/*      */           } else {
/*  397 */             for (byte b = 0; b < array.size; b++) {
/*  398 */               Field field = ((Field[])array.items)[b];
/*  399 */               if (whitelist.isFieldWhiteListed(field))
/*      */               {
/*      */                 
/*  402 */                 if (Modifier.isStatic(field.getModifiers()))
/*      */                 {
/*      */                   
/*  405 */                   if (field.getName().equals(method.getName())) {
/*  406 */                     str1 = "_M_" + str1;
/*      */                     break;
/*      */                   }  } 
/*      */               }
/*      */             } 
/*      */           } 
/*  412 */           methodData.name = str1;
/*      */           
/*      */           JavadocHandler.MethodJD methodJD;
/*  415 */           if ((methodJD = classJD.methods.get(method)) != null) {
/*  416 */             methodData.description = methodJD.description;
/*  417 */             methodData.returnDescription = methodJD.returnDescription;
/*      */           } 
/*      */           
/*      */           String str3;
/*  421 */           if ((str3 = this.c.getLuaClassName(method.getReturnType(), true)) == null) {
/*  422 */             a.e("not accessible return type for '" + method.getReturnType() + "' in method " + method, new Object[0]);
/*  423 */             str3 = "any";
/*      */           } 
/*      */           
/*  426 */           methodData.returnTypeName = str3;
/*      */           
/*  428 */           Parameter[] arrayOfParameter2 = method.getParameters();
/*  429 */           byte b5 = 0; Parameter[] arrayOfParameter1; int j; byte b6;
/*  430 */           for (j = (arrayOfParameter1 = arrayOfParameter2).length, b6 = 0; b6 < j; ) { Parameter parameter = arrayOfParameter1[b6];
/*  431 */             JavadocHandler.ParamJD paramJD = (methodJD == null) ? null : (JavadocHandler.ParamJD)methodJD.params.get(b5);
/*  432 */             ParamData paramData = a(b5, parameter, paramJD, method);
/*  433 */             methodData.params.add(paramData);
/*      */             
/*  435 */             b5++;
/*      */             
/*      */             b6++; }
/*      */         
/*      */         } 
/*      */       }
/*      */     } 
/*  442 */     Class<?> clazz1 = this.clazz.getSuperclass();
/*  443 */     while (clazz1 != null && 
/*  444 */       !this.c.isClassUsed(clazz1))
/*      */     {
/*      */       
/*  447 */       clazz1 = clazz1.getSuperclass();
/*      */     }
/*      */     
/*  450 */     if (clazz1 != null) {
/*      */       
/*  452 */       if (clazz1 == Object.class) {
/*      */         Class[] arrayOfClass1;
/*      */         
/*  455 */         if ((arrayOfClass1 = this.clazz.getInterfaces()).length != 0) {
/*  456 */           Array array2 = new Array(); Class[] arrayOfClass2; int j; byte b;
/*  457 */           for (j = (arrayOfClass2 = arrayOfClass1).length, b = 0; b < j; ) { Class clazz = arrayOfClass2[b];
/*  458 */             if (this.c.isClassUsed(clazz)) {
/*  459 */               array2.add(clazz);
/*      */             }
/*      */             b++; }
/*      */           
/*  463 */           if (array2.size != 0) {
/*  464 */             if (array2.size > 1) {
/*      */               
/*  466 */               Array array3 = new Array();
/*  467 */               for (j = 0; j < array2.size; j++) {
/*  468 */                 Class clazz = (Class)array2.get(j);
/*  469 */                 byte b5 = -1;
/*  470 */                 Array<Class<?>> array4 = a();
/*  471 */                 for (byte b6 = 0; b6 < array4.size; b6++) {
/*  472 */                   if (array4.get(b6) == clazz) {
/*  473 */                     b5 = b6;
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*  477 */                 array3.add(new ObjectIntPair(clazz, b5));
/*      */               } 
/*  479 */               array3.sort((paramObjectIntPair1, paramObjectIntPair2) -> Integer.compare(paramObjectIntPair1.intValue, paramObjectIntPair2.intValue));
/*      */               ObjectIntPair objectIntPair;
/*  481 */               clazz1 = (Class)(objectIntPair = (ObjectIntPair)array3.first()).object;
/*      */               
/*  483 */               if (objectIntPair.intValue == -1) {
/*  484 */                 a.w("Multiple interfaces in " + this.clazz + ": " + array2.toString(", ") + ". Using " + clazz1 + " (not defined in interfaces-priority.txt) as a super class", new Object[0]);
/*      */               }
/*      */             } else {
/*  487 */               clazz1 = (Class)array2.first();
/*      */             }
/*      */           
/*      */           }
/*      */         }
/*      */       
/*      */       } 
/*  494 */     } else if (this.clazz != Object.class) {
/*      */       
/*  496 */       clazz1 = Object.class;
/*      */     } 
/*      */     
/*  499 */     this.superClass = clazz1;
/*      */     
/*  501 */     Class<?> clazz2 = this.clazz;
/*  502 */     while (clazz2 != null) {
/*  503 */       Class[] arrayOfClass1; int j; byte b; for (j = (arrayOfClass1 = this.clazz.getInterfaces()).length, b = 0; b < j; ) { Class clazz = arrayOfClass1[b];
/*  504 */         if (!this.allInterfaces.contains(clazz, true))
/*  505 */           this.allInterfaces.add(clazz); 
/*      */         b++; }
/*      */       
/*  508 */       clazz2 = clazz2.getSuperclass();
/*      */     } 
/*      */     
/*      */     byte b4;
/*  512 */     for (b4 = 0; b4 < array.size; b4++) {
/*  513 */       Field field = ((Field[])array.items)[b4];
/*  514 */       if (whitelist.isFieldWhiteListed(field))
/*      */       {
/*      */         
/*  517 */         if (!Modifier.isStatic(field.getModifiers())) {
/*      */           String str1;
/*      */ 
/*      */ 
/*      */           
/*  522 */           if ((str1 = this.c.getLuaClassName(field.getType(), true)) == null) {
/*  523 */             str1 = "any";
/*      */           }
/*      */ 
/*      */           
/*  527 */           String str2 = field.getName();
/*  528 */           if (LuaDefUtils.LUA_KEYWORDS.contains(str2)) {
/*  529 */             str2 = "_F_" + str2;
/*      */           }
/*      */           
/*  532 */           JavadocHandler.FieldJD fieldJD = classJD.fields.get(field);
/*      */           
/*      */           FieldData fieldData;
/*  535 */           (fieldData = new FieldData(field)).name = str2;
/*  536 */           fieldData.typeName = str1;
/*  537 */           fieldData.canBeNull = this.c.hasNullAnnotation(field);
/*  538 */           if (fieldJD != null) {
/*  539 */             fieldData.description = fieldJD.description;
/*  540 */             fieldData.generics = fieldJD.generics;
/*      */           } 
/*  542 */           this.instanceFields.add(fieldData);
/*      */         } 
/*      */       }
/*      */     } 
/*  546 */     for (b4 = 0; b4 < array1.size; b4++) {
/*  547 */       Method method = ((Method[])array1.items)[b4];
/*  548 */       if (whitelist.isMethodWhiteListedInDeclaringClass(method))
/*      */       {
/*      */         
/*  551 */         if (!Modifier.isStatic(method.getModifiers())) {
/*      */ 
/*      */ 
/*      */           
/*  555 */           String str1 = method.getName();
/*      */           
/*  557 */           if (LuaDefUtils.LUA_KEYWORDS.contains(str1)) {
/*  558 */             str1 = "_M_" + str1;
/*      */           } else {
/*  560 */             for (byte b = 0; b < array.size; b++) {
/*  561 */               Field field = ((Field[])array.items)[b];
/*  562 */               if (whitelist.isFieldWhiteListed(field))
/*      */               {
/*      */                 
/*  565 */                 if (!Modifier.isStatic(field.getModifiers()))
/*      */                 {
/*      */                   
/*  568 */                   if (field.getName().equals(method.getName())) {
/*  569 */                     str1 = "_M_" + str1;
/*      */                     break;
/*      */                   }  } 
/*      */               }
/*      */             } 
/*      */           } 
/*  575 */           if (this.clazz == Class.class) {
/*  576 */             str1 = "_" + str1;
/*      */           }
/*      */           
/*      */           MethodData methodData;
/*  580 */           (methodData = new MethodData(method)).name = str1;
/*  581 */           this.instanceMethods.add(methodData);
/*      */           
/*      */           JavadocHandler.MethodJD methodJD;
/*  584 */           if ((methodJD = classJD.methods.get(method)) != null) {
/*  585 */             methodData.description = methodJD.description;
/*  586 */             methodData.returnDescription = methodJD.returnDescription;
/*  587 */             methodData.specifiedByInterface = methodJD.specifiedByInterface;
/*  588 */             methodData.overridesSuperMethod = methodJD.overridesSuperMethod;
/*      */           } 
/*      */           
/*      */           String str2;
/*  592 */           if ((str2 = this.c.getLuaClassName(method.getReturnType(), true)) == null) {
/*  593 */             a.e("not accessible return type for '" + method.getReturnType() + "' in method " + method, new Object[0]);
/*  594 */             str2 = "any";
/*      */           } 
/*      */           
/*  597 */           methodData.returnTypeName = str2;
/*      */           
/*  599 */           Parameter[] arrayOfParameter1 = method.getParameters();
/*  600 */           byte b5 = 0; Parameter[] arrayOfParameter2; int j; byte b6;
/*  601 */           for (j = (arrayOfParameter2 = arrayOfParameter1).length, b6 = 0; b6 < j; ) { Parameter parameter = arrayOfParameter2[b6];
/*  602 */             JavadocHandler.ParamJD paramJD = (methodJD == null) ? null : (JavadocHandler.ParamJD)methodJD.params.get(b5);
/*      */             
/*  604 */             ParamData paramData = a(b5, parameter, paramJD, method);
/*  605 */             methodData.params.add(paramData);
/*      */             
/*  607 */             b5++;
/*      */             b6++; }
/*      */         
/*      */         }  } 
/*      */     } 
/*      */   } public void printFileData(StringBuilder paramStringBuilder) {
/*  613 */     String str = this.c.getLuaClassName(this.clazz, false);
/*      */     
/*  615 */     paramStringBuilder.append("--- @meta\n");
/*  616 */     paramStringBuilder.append("--- @diagnostic disable: duplicate-index\n\n");
/*  617 */     String[] arrayOfString = this.filePath.split("/");
/*  618 */     StringBuilder stringBuilder = new StringBuilder();
/*  619 */     for (byte b = 0; b < arrayOfString.length - 1; b++) {
/*  620 */       if (b != 0) {
/*  621 */         stringBuilder.append(".");
/*      */       }
/*  623 */       stringBuilder.append(arrayOfString[b]);
/*      */     } 
/*  625 */     paramStringBuilder.append("--- @see ").append(stringBuilder).append("\n");
/*  626 */     if (this.javadocUrl != null) {
/*  627 */       paramStringBuilder.append("--- 📖 ").append(this.javadocUrl).append("\n");
/*      */     }
/*  629 */     paramStringBuilder.append("\n");
/*  630 */     paramStringBuilder.append("--- Scroll to object definition:\n");
/*  631 */     paramStringBuilder.append("--- @see ").append(str).append("\n");
/*      */     
/*  633 */     paramStringBuilder.append("\n");
/*  634 */     paramStringBuilder.append("\n");
/*      */     
/*  636 */     paramStringBuilder.append("-- ─────────────────────────────────────────────────────────────────────────────\n");
/*  637 */     paramStringBuilder.append("--                           --- Class definition ---\n");
/*      */     
/*  639 */     Array array = new Array();
/*  640 */     if (this.isSerializable) {
/*  641 */       array.add("💾 KryoSerializable");
/*      */     }
/*      */     
/*  644 */     switch (this.classType) {
/*      */       case 3:
/*  646 */         array.add("✍ Annotation");
/*      */         break;
/*      */       case 4:
/*  649 */         array.add("💠 Enum");
/*      */         break;
/*      */       case 5:
/*  652 */         array.add("👻 Abstract class");
/*      */         break;
/*      */       case 1:
/*  655 */         array.add("⭐ Interface");
/*      */         break;
/*      */       case 2:
/*  658 */         array.add("⭐ Interface");
/*  659 */         array.add("✨ Functional interface");
/*      */         break;
/*      */     } 
/*  662 */     if (array.size != 0) {
/*  663 */       int i = (array.size - 1) * 3;
/*  664 */       for (Array.ArrayIterator<String> arrayIterator1 = array.iterator(); arrayIterator1.hasNext(); ) { String str1 = arrayIterator1.next();
/*  665 */         i += str1.length(); }
/*      */       
/*  667 */       paramStringBuilder.append("--");
/*  668 */       int j = (77 - i) / 2;
/*  669 */       for (byte b1 = 0; b1 < j; b1++) {
/*  670 */         paramStringBuilder.append(' ');
/*      */       }
/*  672 */       for (Array.ArrayIterator<String> arrayIterator2 = array.iterator(); arrayIterator2.hasNext(); ) { String str1 = arrayIterator2.next();
/*  673 */         paramStringBuilder.append(str1).append("   "); }
/*      */       
/*  675 */       paramStringBuilder.append("\n");
/*      */     } 
/*  677 */     paramStringBuilder.append("-- ─────────────────────────────────────────────────────────────────────────────\n");
/*      */ 
/*      */ 
/*      */     
/*  681 */     paramStringBuilder.append("\n");
/*  682 */     paramStringBuilder.append("--- @class ").append(str).append(".class: ").append(this.c.getLuaClassName(Class.class, false)).append("\n");
/*      */ 
/*      */     
/*  685 */     if (this.staticFields.size != 0) {
/*  686 */       paramStringBuilder.append("---\n");
/*  687 */       for (Array.ArrayIterator<FieldData> arrayIterator1 = this.staticFields.iterator(); arrayIterator1.hasNext(); ) { FieldData fieldData = arrayIterator1.next();
/*  688 */         paramStringBuilder.append("--- @field ").append(fieldData.name).append(" ").append(fieldData.typeName).append(LuaDefUtils.getLuaPrimitiveType(fieldData.field.getType()));
/*  689 */         if (fieldData.generics != null) {
/*  690 */           paramStringBuilder.append(" (").append(fieldData.generics).append(")");
/*      */         }
/*  692 */         if (fieldData.description != null) {
/*  693 */           paramStringBuilder.append(' ').append(fieldData.description);
/*      */         }
/*  695 */         paramStringBuilder.append("\n"); }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  700 */     if (this.innerClasses.size != 0) {
/*  701 */       paramStringBuilder.append("---\n");
/*  702 */       for (Array.ArrayIterator<InnerClassData> arrayIterator1 = this.innerClasses.iterator(); arrayIterator1.hasNext(); ) { InnerClassData innerClassData = arrayIterator1.next();
/*  703 */         paramStringBuilder.append("--- @field ").append(innerClassData.name).append(" ").append(this.c.getLuaClassName(innerClassData.clazz, false)).append(".class\n"); }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  708 */     if (this.classType == 1 || this.classType == 2) {
/*  709 */       paramStringBuilder.append("---\n");
/*  710 */       if (this.functionalInterfaceProxyData != null) {
/*      */         
/*  712 */         byte b2 = 0;
/*  713 */         paramStringBuilder.append("--- @overload fun(method: fun(");
/*  714 */         for (Array.ArrayIterator<ParamData> arrayIterator2 = this.functionalInterfaceProxyData.params.iterator(); arrayIterator2.hasNext(); ) { ParamData paramData = arrayIterator2.next();
/*  715 */           if (b2) {
/*  716 */             paramStringBuilder.append(", ");
/*      */           }
/*  718 */           paramStringBuilder.append(paramData.name).append(paramData.canBeNull ? "?" : "").append(": ").append(paramData.typeName);
/*  719 */           b2++; }
/*      */         
/*  721 */         paramStringBuilder.append("): ").append(this.functionalInterfaceProxyData.returnTypeName).append("): ").append(str).append("\n");
/*      */       } 
/*      */ 
/*      */       
/*  725 */       paramStringBuilder.append("--- @overload fun(methods: { ");
/*  726 */       byte b1 = 0;
/*  727 */       for (Array.ArrayIterator<MethodData> arrayIterator1 = this.instanceMethods.iterator(); arrayIterator1.hasNext(); ) { MethodData methodData = arrayIterator1.next();
/*  728 */         if (b1) paramStringBuilder.append("; "); 
/*  729 */         paramStringBuilder.append(methodData.name).append(": fun(self");
/*  730 */         for (Array.ArrayIterator<ParamData> arrayIterator2 = methodData.params.iterator(); arrayIterator2.hasNext(); ) { ParamData paramData = arrayIterator2.next();
/*  731 */           paramStringBuilder.append(", ").append(paramData.name).append(paramData.canBeNull ? "?" : "").append(": ").append(paramData.typeName); }
/*      */         
/*  733 */         paramStringBuilder.append("): ").append(methodData.returnTypeName).append(a(methodData.method.getReturnType()));
/*      */         
/*  735 */         b1++; }
/*      */       
/*  737 */       paramStringBuilder.append("}): ").append(str).append("\n");
/*      */     } 
/*      */     
/*  740 */     paramStringBuilder.append(str).append(".class = {\n");
/*  741 */     if (this.constructors.size != 0) {
/*      */       
/*  743 */       paramStringBuilder.append("\n");
/*  744 */       paramStringBuilder.append("    -- ─────────────────────────── Constructors ────────────────────────────────\n");
/*      */       
/*  746 */       for (Array.ArrayIterator<ConstructorData> arrayIterator1 = this.constructors.iterator(); arrayIterator1.hasNext(); ) { ConstructorData constructorData = arrayIterator1.next();
/*  747 */         paramStringBuilder.append("\n");
/*  748 */         paramStringBuilder.append("    --- ✨ Constructor\n");
/*      */         
/*  750 */         if (constructorData.description != null) {
/*  751 */           paramStringBuilder.append("    ---\n");
/*  752 */           paramStringBuilder.append(constructorData.description);
/*      */         } 
/*      */         
/*  755 */         if (constructorData.ctor.isVarArgs()) {
/*  756 */           paramStringBuilder.append("    --- 🍡 Varargs\n");
/*      */         }
/*  758 */         for (Array.ArrayIterator<ParamData> arrayIterator3 = constructorData.params.iterator(); arrayIterator3.hasNext(); ) { ParamData paramData = arrayIterator3.next();
/*  759 */           paramStringBuilder.append("    --- @param ").append(paramData.name).append(paramData.canBeNull ? "?" : "").append(" ").append(paramData.typeName).append(LuaDefUtils.getLuaPrimitiveType(paramData.param.getType()));
/*  760 */           if (paramData.description != null) {
/*  761 */             paramStringBuilder.append(' ').append(paramData.description);
/*      */           }
/*  763 */           paramStringBuilder.append("\n"); }
/*      */         
/*  765 */         paramStringBuilder.append("    --- @return ").append(str).append("\n");
/*  766 */         paramStringBuilder.append("    ").append(constructorData.name).append(" = function(");
/*      */         
/*  768 */         byte b1 = 0;
/*  769 */         for (Array.ArrayIterator<ParamData> arrayIterator2 = constructorData.params.iterator(); arrayIterator2.hasNext(); ) { ParamData paramData = arrayIterator2.next();
/*  770 */           if (b1) {
/*  771 */             paramStringBuilder.append(", ");
/*      */           }
/*  773 */           paramStringBuilder.append(paramData.name);
/*  774 */           b1++; }
/*      */         
/*  776 */         paramStringBuilder.append(") end,\n"); }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  781 */     if (this.staticMethods.size != 0) {
/*  782 */       paramStringBuilder.append("\n");
/*  783 */       paramStringBuilder.append("    -- ────────────────────────── Static methods ───────────────────────────────\n");
/*      */     }  Array.ArrayIterator<MethodData> arrayIterator;
/*  785 */     for (arrayIterator = this.staticMethods.iterator(); arrayIterator.hasNext(); ) { MethodData methodData = arrayIterator.next();
/*  786 */       paramStringBuilder.append("\n");
/*      */       
/*  788 */       if (methodData.description != null) {
/*  789 */         paramStringBuilder.append(methodData.description);
/*      */       }
/*  791 */       if (methodData.method.isVarArgs())
/*  792 */         paramStringBuilder.append("    --- 🍡 Varargs\n"); 
/*      */       Array.ArrayIterator<ParamData> arrayIterator1;
/*  794 */       for (arrayIterator1 = methodData.params.iterator(); arrayIterator1.hasNext(); ) { ParamData paramData = arrayIterator1.next();
/*  795 */         paramStringBuilder.append("    --- @param ").append(paramData.name).append(paramData.canBeNull ? "?" : "").append(" ").append(paramData.typeName).append(LuaDefUtils.getLuaPrimitiveType(paramData.param.getType()));
/*  796 */         if (paramData.description != null) {
/*  797 */           paramStringBuilder.append(" ").append(paramData.description);
/*      */         }
/*  799 */         paramStringBuilder.append("\n"); }
/*      */       
/*  801 */       paramStringBuilder.append("    --- @return ").append(methodData.returnTypeName).append(LuaDefUtils.getLuaPrimitiveType(methodData.method.getReturnType()));
/*  802 */       if (methodData.returnDescription != null) {
/*  803 */         paramStringBuilder.append(" - ").append(methodData.returnDescription);
/*      */       }
/*  805 */       paramStringBuilder.append("\n");
/*      */       
/*  807 */       paramStringBuilder.append("    ").append(methodData.name).append(" = function(self");
/*      */       
/*  809 */       for (arrayIterator1 = methodData.params.iterator(); arrayIterator1.hasNext(); ) { ParamData paramData = arrayIterator1.next();
/*  810 */         paramStringBuilder.append(", ").append(paramData.name); }
/*      */       
/*  812 */       paramStringBuilder.append(") end,\n"); }
/*      */     
/*  814 */     paramStringBuilder.append("}\n");
/*      */ 
/*      */ 
/*      */     
/*  818 */     paramStringBuilder.append("\n");
/*  819 */     paramStringBuilder.append("\n");
/*  820 */     paramStringBuilder.append("-- ─────────────────────────────────────────────────────────────────────────────\n");
/*  821 */     paramStringBuilder.append("--                           --- Object definition ---\n");
/*  822 */     paramStringBuilder.append("-- ─────────────────────────────────────────────────────────────────────────────\n");
/*  823 */     paramStringBuilder.append("\n");
/*      */     
/*  825 */     paramStringBuilder.append("--- @class ").append(str);
/*      */ 
/*      */     
/*  828 */     if (this.superClass != null) {
/*  829 */       paramStringBuilder.append(": ").append(this.c.getLuaClassName(this.superClass, false));
/*      */     }
/*  831 */     paramStringBuilder.append("\n");
/*      */     
/*  833 */     if (this.isSerializable) {
/*  834 */       paramStringBuilder.append("--- 💾 KryoSerializable\n");
/*      */     }
/*  836 */     switch (this.classType) { case 5:
/*  837 */         paramStringBuilder.append("--- 👻 Abstract class\n"); break;
/*  838 */       case 4: paramStringBuilder.append("--- 💠 Enum\n"); break;
/*  839 */       case 3: paramStringBuilder.append("--- ✍ Annotation\n"); break;
/*  840 */       case 1: paramStringBuilder.append("--- ⭐ Interface\n"); break;
/*  841 */       case 2: paramStringBuilder.append("--- ⭐ Interface\n--- ✨ Functional interface\n"); break; }
/*      */     
/*  843 */     if (this.classGenericsString != null) {
/*  844 */       paramStringBuilder.append("---\n");
/*  845 */       paramStringBuilder.append("--- Generic: ").append(this.classGenericsString).append("\n");
/*      */     } 
/*      */     
/*  848 */     if (this.classDescription != null) {
/*  849 */       paramStringBuilder.append("---\n");
/*  850 */       paramStringBuilder.append(this.classDescription);
/*      */     } 
/*      */     
/*  853 */     if (this.allInterfaces.size != 0) {
/*  854 */       paramStringBuilder.append("---\n");
/*  855 */       paramStringBuilder.append("--- Implements interfaces:\n");
/*  856 */       for (arrayIterator = this.allInterfaces.iterator(); arrayIterator.hasNext(); ) { Class clazz = (Class)arrayIterator.next();
/*  857 */         if (this.c.isClassUsed(clazz)) {
/*  858 */           paramStringBuilder.append("--- @see ").append(this.c.getLuaClassName(clazz, false)).append(" ⭐\n"); continue;
/*      */         } 
/*  860 */         paramStringBuilder.append("---    - ").append(clazz.getName()).append(" (not accessible)\n"); }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  865 */     if (this.javadocUrl != null) {
/*  866 */       paramStringBuilder.append("---\n");
/*  867 */       paramStringBuilder.append("--- 📖 [").append(this.clazz.getSimpleName()).append(" Javadoc](").append(this.javadocUrl).append(")\n");
/*      */     } 
/*      */ 
/*      */     
/*  871 */     if (this.instanceFields.size != 0) {
/*  872 */       paramStringBuilder.append("---\n");
/*  873 */       for (arrayIterator = this.instanceFields.iterator(); arrayIterator.hasNext(); ) { FieldData fieldData = (FieldData)arrayIterator.next();
/*  874 */         paramStringBuilder.append("--- @field ").append(fieldData.name).append(" ").append(fieldData.typeName).append(LuaDefUtils.getLuaPrimitiveType(fieldData.field.getType()));
/*  875 */         if (fieldData.generics != null) {
/*  876 */           paramStringBuilder.append(" (").append(fieldData.generics).append(")");
/*      */         }
/*  878 */         if (fieldData.description != null) {
/*  879 */           paramStringBuilder.append(' ').append(fieldData.description);
/*      */         }
/*  881 */         paramStringBuilder.append("\n"); }
/*      */     
/*      */     } 
/*  884 */     paramStringBuilder.append(str).append(" = {\n");
/*      */     
/*  886 */     if (this.clazz == Class.class) {
/*  887 */       paramStringBuilder.append("\n");
/*  888 */       paramStringBuilder.append("    --- Get a method handle by exact method parameter list\n");
/*  889 */       paramStringBuilder.append("    --- Makes it easier to specify which method you want to call if there are multiple methods with the same name\n");
/*  890 */       paramStringBuilder.append("    --- \n");
/*  891 */       paramStringBuilder.append("    --- Usage example:\n");
/*  892 */       paramStringBuilder.append("    ---     local handle = java.util.ArrayList.class:_findMethod(\"add\", java.int, java.lang.Object.class)\n");
/*  893 */       paramStringBuilder.append("    ---     handle(list, \"5\", someObject) -- where list is ArrayList or anything extending it\n");
/*  894 */       paramStringBuilder.append("    --- \n");
/*  895 */       paramStringBuilder.append("    --- @param name string method name\n");
/*  896 */       paramStringBuilder.append("    --- @param ... java.lang.Class parameter types of the method\n");
/*  897 */       paramStringBuilder.append("    --- @return fun(obj:java.lang.Object, ...):any|nil 💾 KryoSerializable\n");
/*  898 */       paramStringBuilder.append("    _findMethod = function(self, name, ...) end,\n");
/*      */     } 
/*      */ 
/*      */     
/*  902 */     for (arrayIterator = this.instanceMethods.iterator(); arrayIterator.hasNext(); ) { MethodData methodData = arrayIterator.next();
/*  903 */       paramStringBuilder.append("\n");
/*  904 */       if (methodData.description != null) {
/*  905 */         paramStringBuilder.append(methodData.description);
/*      */       }
/*  907 */       if (methodData.overridesSuperMethod) {
/*  908 */         paramStringBuilder.append("    ---- 🔼 Override\n");
/*      */       }
/*  910 */       if (methodData.specifiedByInterface) {
/*  911 */         paramStringBuilder.append("    ---- 🎇 Specified by interface\n");
/*      */       }
/*  913 */       if (methodData.method.isVarArgs())
/*  914 */         paramStringBuilder.append("    --- 🍡 Varargs\n"); 
/*      */       Array.ArrayIterator<ParamData> arrayIterator1;
/*  916 */       for (arrayIterator1 = methodData.params.iterator(); arrayIterator1.hasNext(); ) { ParamData paramData = arrayIterator1.next();
/*  917 */         paramStringBuilder.append("    --- @param ").append(paramData.name).append(paramData.canBeNull ? "?" : "").append(" ").append(paramData.typeName).append(LuaDefUtils.getLuaPrimitiveType(paramData.param.getType()));
/*  918 */         if (paramData.description != null) {
/*  919 */           paramStringBuilder.append(' ').append(paramData.description);
/*      */         }
/*  921 */         paramStringBuilder.append("\n"); }
/*      */       
/*  923 */       paramStringBuilder.append("    --- @return ").append(methodData.returnTypeName).append(LuaDefUtils.getLuaPrimitiveType(methodData.method.getReturnType()));
/*  924 */       if (methodData.returnDescription != null) {
/*  925 */         paramStringBuilder.append(" - ").append(methodData.returnDescription);
/*      */       }
/*  927 */       paramStringBuilder.append("\n");
/*  928 */       paramStringBuilder.append("    ").append(methodData.name).append(" = function(self");
/*  929 */       for (arrayIterator1 = methodData.params.iterator(); arrayIterator1.hasNext(); ) { ParamData paramData = arrayIterator1.next();
/*  930 */         paramStringBuilder.append(", ").append(paramData.name); }
/*      */       
/*  932 */       paramStringBuilder.append(") end,\n"); }
/*      */ 
/*      */     
/*  935 */     paramStringBuilder.append("}\n");
/*  936 */     paramStringBuilder.append("\n");
/*      */     
/*  938 */     LuaDefUtils.appendArt(StringFormatter.md5Hash(this.clazz.getName()), paramStringBuilder);
/*      */   }
/*      */   public static class FieldData { public final Field field;
/*      */     public String name;
/*      */     public String typeName;
/*      */     public boolean canBeNull;
/*      */     @Null
/*      */     public String description;
/*      */     @Null
/*      */     public String generics;
/*      */     
/*      */     public FieldData(Field param1Field) {
/*  950 */       this.field = param1Field;
/*      */     } }
/*      */ 
/*      */   
/*      */   public static class InnerClassData {
/*      */     public final Class<?> clazz;
/*      */     public String name;
/*      */     public String typeName;
/*      */     
/*      */     public InnerClassData(Class<?> param1Class) {
/*  960 */       this.clazz = param1Class;
/*      */     } }
/*      */   
/*      */   public static class ParamData {
/*      */     public Parameter param;
/*      */     public String name;
/*      */     public String typeName;
/*      */     @Null
/*      */     public String description;
/*      */     public boolean canBeNull;
/*      */   }
/*      */   
/*      */   public static class FunctionalInterfaceProxyData {
/*      */     public final Method method;
/*      */     public String returnTypeName;
/*  975 */     public Array<ClassDefData.ParamData> params = new Array();
/*      */     
/*      */     public FunctionalInterfaceProxyData(Method param1Method) {
/*  978 */       this.method = param1Method;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ConstructorData {
/*      */     public final Constructor<?> ctor;
/*      */     public String name;
/*  985 */     public Array<ClassDefData.ParamData> params = new Array(); @Null
/*      */     public String description;
/*      */     
/*      */     public ConstructorData(Constructor<?> param1Constructor) {
/*  989 */       this.ctor = param1Constructor;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class MethodData {
/*      */     public final Method method;
/*      */     public String name;
/*      */     public String returnTypeName;
/*  997 */     public Array<ClassDefData.ParamData> params = new Array(); @Null
/*      */     public String description; @Null
/*      */     public String returnDescription;
/*      */     public boolean specifiedByInterface;
/*      */     public boolean overridesSuperMethod;
/*      */     
/*      */     public MethodData(Method param1Method) {
/* 1004 */       this.method = param1Method;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\ClassDefData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */