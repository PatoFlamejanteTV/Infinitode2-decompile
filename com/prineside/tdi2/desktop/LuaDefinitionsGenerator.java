/*     */ package com.prineside.tdi2.desktop;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
/*     */ import com.prineside.tdi2.desktop.luadef.ClassDefData;
/*     */ import com.prineside.tdi2.desktop.luadef.JavadocHandler;
/*     */ import com.prineside.tdi2.desktop.luadef.LuaDefUtils;
/*     */ import com.prineside.tdi2.managers.ScriptManager;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import io.github.classgraph.ClassGraph;
/*     */ import io.github.classgraph.ClassInfo;
/*     */ import io.github.classgraph.FieldInfo;
/*     */ import io.github.classgraph.MethodInfo;
/*     */ import io.github.classgraph.MethodInfoList;
/*     */ import io.github.classgraph.ScanResult;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Parameter;
/*     */ import java.nio.file.FileVisitResult;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.SimpleFileVisitor;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LuaDefinitionsGenerator
/*     */ {
/*  53 */   private static final TLog a = TLog.forClass(LuaDefinitionsGenerator.class);
/*     */ 
/*     */   
/*     */   public static boolean verbose;
/*     */ 
/*     */   
/*     */   public static final String DEFINITIONS_DIR = "scripts/.definitions/classes/";
/*     */ 
/*     */   
/*     */   public HashSet<Class<?>> kryoRegisteredClasses;
/*     */ 
/*     */   
/*     */   public Whitelist whitelist;
/*     */   
/*     */   public ScanResult classGraphScanResult;
/*     */   
/*     */   public Array<Class<?>> allClasses;
/*     */   
/*     */   public HashSet<Class<?>> allClassesSet;
/*     */   
/*     */   public HashSet<Class<?>> usedClasses;
/*     */   
/*     */   public JavadocHandler javadocHandler;
/*     */   
/*     */   public HashSet<String> handledPackageDefinitions;
/*     */   
/*     */   public Array<ClassDefData> filesData;
/*     */ 
/*     */   
/*     */   public void loadWhitelist() {
/*  83 */     long l = TimeUtils.millis();
/*  84 */     this.whitelist = Whitelist.fromFile(new File("res/luaj/whitelist.txt"));
/*  85 */     a.i("loadWhitelist done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public Whitelist getWhitelist() {
/*  89 */     return this.whitelist;
/*     */   }
/*     */   
/*     */   public void prepareJavadocs() {
/*  93 */     if (this.usedClasses == null) {
/*  94 */       throw new IllegalStateException("gatherUsedClasses() has to be run first");
/*     */     }
/*     */     
/*  97 */     long l = TimeUtils.millis();
/*  98 */     this.javadocHandler = new JavadocHandler();
/*  99 */     for (Array.ArrayIterator<Class<?>> arrayIterator = this.allClasses.iterator(); arrayIterator.hasNext(); ) { Class<?> clazz = arrayIterator.next();
/* 100 */       if (isClassUsed(clazz)) {
/* 101 */         this.javadocHandler.classesToFetchFor.add(clazz);
/*     */       } }
/*     */ 
/*     */     
/* 105 */     this.javadocHandler.run();
/* 106 */     a.i("prepareJavadocs done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public void loadKryoRegistry() {
/* 110 */     long l = TimeUtils.millis();
/* 111 */     this.kryoRegisteredClasses = new HashSet<>();
/* 112 */     FileReader fileReader = new FileReader("res/kryo-registry.txt"); 
/* 113 */     try { BufferedReader bufferedReader = new BufferedReader(fileReader);
/* 114 */       byte b = 1;
/*     */       
/*     */       String str;
/* 117 */       while ((str = bufferedReader.readLine()) != null) {
/*     */ 
/*     */         
/* 120 */         str = str.trim();
/*     */         try {
/* 122 */           Class<?> clazz = Class.forName(str);
/* 123 */           this.kryoRegisteredClasses.add(clazz);
/* 124 */         } catch (Exception exception) {
/* 125 */           a.e("class " + str + " not found but is listed in kryo-registry.txt at line " + b, new Object[0]);
/*     */         } 
/* 127 */         b++;
/*     */       } 
/* 129 */       fileReader.close(); } catch (Throwable throwable) { try { fileReader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }
/* 130 */      a.i("loadKryoRegistry done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public boolean isClassRegisteredInKryo(Class<?> paramClass) {
/* 134 */     return this.kryoRegisteredClasses.contains(paramClass);
/*     */   }
/*     */   
/*     */   public void gatherClasses() {
/* 138 */     long l = TimeUtils.millis();
/*     */     HashSet<Class<Object>> hashSet;
/* 140 */     (hashSet = new HashSet<>()).add(Object.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ScanResult scanResult;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     for (ClassInfo classInfo : (scanResult = (new ClassGraph()).removeTemporaryFilesAfterScan().enableSystemJarsAndModules().enableClassInfo().enableFieldInfo().enableMethodInfo().enableAnnotationInfo().ignoreClassVisibility().acceptPackages((String[])ScriptManager.getPackagesToScanFromConfig().toArray()).scan()).getAllClasses()) {
/*     */       try {
/* 154 */         Class<?> clazz = Class.forName(classInfo.getName());
/* 155 */         hashSet.add(clazz);
/* 156 */       } catch (Throwable throwable) {}
/*     */     } 
/*     */     
/* 159 */     Array<Class<?>> array = ReflectionUtils.LuaRelated.filterClasses(hashSet, null);
/* 160 */     this.classGraphScanResult = scanResult;
/* 161 */     a.i("found " + array.size + " classes", new Object[0]);
/* 162 */     this.allClasses = array;
/*     */     
/* 164 */     this.allClasses.sort((paramClass1, paramClass2) -> paramClass1.getSimpleName().compareTo(paramClass2.getSimpleName()));
/*     */     
/* 166 */     this.allClassesSet = new HashSet<>();
/* 167 */     for (Array.ArrayIterator<Class<?>> arrayIterator = this.allClasses.iterator(); arrayIterator.hasNext(); ) { Class<?> clazz = arrayIterator.next();
/* 168 */       this.allClassesSet.add(clazz); }
/*     */     
/* 170 */     a.i("gatherClasses done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public boolean hasNullAnnotation(Field paramField) {
/* 174 */     Class<?> clazz = paramField.getDeclaringClass();
/*     */     ClassInfo classInfo;
/* 176 */     if ((classInfo = this.classGraphScanResult.getClassInfo(clazz.getName())) != null) {
/*     */       FieldInfo fieldInfo;
/* 178 */       if ((fieldInfo = classInfo.getDeclaredFieldInfo(paramField.getName())) != null) {
/* 179 */         return fieldInfo.hasAnnotation(Null.class);
/*     */       }
/* 181 */       return false;
/*     */     } 
/*     */     
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNullAnnotation(Constructor<?> paramConstructor, int paramInt) {
/* 189 */     Class<?> clazz = paramConstructor.getDeclaringClass();
/*     */     ClassInfo classInfo;
/* 191 */     if ((classInfo = this.classGraphScanResult.getClassInfo(clazz.getName())) != null) {
/*     */       MethodInfoList methodInfoList;
/* 193 */       for (MethodInfo methodInfo : methodInfoList = classInfo.getMethodInfo("<init>")) {
/*     */         try {
/*     */           Constructor<?> constructor;
/* 196 */           if ((constructor = methodInfo.loadClassAndGetConstructor()).equals(paramConstructor))
/*     */           {
/* 198 */             return methodInfo.getParameterInfo()[paramInt].hasAnnotation(Null.class);
/*     */           }
/* 200 */         } catch (Throwable throwable) {}
/*     */       } 
/* 202 */       return false;
/*     */     } 
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNullAnnotation(Method paramMethod, int paramInt) {
/* 209 */     Class<?> clazz = paramMethod.getDeclaringClass();
/*     */     ClassInfo classInfo;
/* 211 */     if ((classInfo = this.classGraphScanResult.getClassInfo(clazz.getName())) != null) {
/*     */       MethodInfoList methodInfoList;
/* 213 */       for (MethodInfo methodInfo : methodInfoList = classInfo.getMethodInfo(paramMethod.getName())) {
/*     */         try {
/*     */           Method method;
/* 216 */           if ((method = methodInfo.loadClassAndGetMethod()).equals(paramMethod))
/*     */           {
/* 218 */             return methodInfo.getParameterInfo()[paramInt].hasAnnotation(Null.class);
/*     */           }
/* 220 */         } catch (Throwable throwable) {}
/*     */       } 
/* 222 */       return false;
/*     */     } 
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void deleteDefinitionFiles() {
/* 229 */     long l = TimeUtils.millis();
/* 230 */     Path path = Paths.get("scripts/.definitions/classes/", new String[0]);
/*     */     try {
/* 232 */       Files.walkFileTree(path, new SimpleFileVisitor<Path>()
/*     */           {
/*     */             public FileVisitResult visitFile(Path param1Path, BasicFileAttributes param1BasicFileAttributes) {
/* 235 */               Files.delete(param1Path);
/* 236 */               return FileVisitResult.CONTINUE;
/*     */             }
/*     */ 
/*     */             
/*     */             public FileVisitResult postVisitDirectory(Path param1Path, IOException param1IOException) {
/* 241 */               Files.delete(param1Path);
/* 242 */               return FileVisitResult.CONTINUE;
/*     */             }
/*     */           });
/* 245 */     } catch (Throwable throwable) {}
/* 246 */     a.i("deleteDefinitionFiles done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public void gatherUsedClasses() {
/* 250 */     long l = TimeUtils.millis();
/* 251 */     if (this.allClasses == null) {
/* 252 */       throw new IllegalStateException("allClasses is null - call gatherClasses() first");
/*     */     }
/* 254 */     if (getWhitelist() == null) {
/* 255 */       throw new IllegalStateException("whitelist is null - call loadWhitelist() first");
/*     */     }
/*     */     
/* 258 */     this.usedClasses = new HashSet<>();
/* 259 */     for (Array.ArrayIterator<Class<?>> arrayIterator = this.allClasses.iterator(); arrayIterator.hasNext(); ) {
/* 260 */       Class<?> clazz; if ((clazz = arrayIterator.next()).isInterface()) {
/* 261 */         if (getWhitelist().isInterfaceProxyWhiteListed(clazz)) {
/* 262 */           a(clazz, "whitelisted proxy");
/*     */         }
/*     */       } else {
/* 265 */         Array array = LuaDefUtils.gatherConstructorsCached(clazz);
/* 266 */         for (byte b = 0; b < array.size; b++) {
/* 267 */           Constructor constructor = ((Constructor[])array.items)[b];
/* 268 */           if (getWhitelist().isConstructorWhiteListed(constructor)) {
/* 269 */             a(clazz, "has whitelisted ctor"); Parameter[] arrayOfParameter; int i; byte b3;
/* 270 */             for (i = (arrayOfParameter = constructor.getParameters()).length, b3 = 0; b3 < i; ) { Parameter parameter = arrayOfParameter[b3];
/* 271 */               if (this.allClassesSet.contains(parameter.getType()))
/*     */               {
/*     */                 
/* 274 */                 a(parameter.getType(), "used as a parameter to " + constructor + "'s ctor"); } 
/*     */               b3++; }
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/* 280 */       Array array1 = LuaDefUtils.gatherFieldsCached(clazz);
/* 281 */       for (byte b1 = 0; b1 < array1.size; b1++) {
/* 282 */         Field field = ((Field[])array1.items)[b1];
/* 283 */         if (getWhitelist().isFieldWhiteListed(field)) {
/*     */ 
/*     */           
/* 286 */           a(clazz, "has whitelisted field");
/* 287 */           if (this.allClassesSet.contains(field.getType())) {
/* 288 */             a(field.getType(), "used as a field type in " + clazz);
/*     */           }
/*     */         } 
/*     */       } 
/* 292 */       Array array2 = LuaDefUtils.gatherMethodsCached(clazz);
/* 293 */       for (byte b2 = 0; b2 < array2.size; b2++) {
/* 294 */         Method method = ((Method[])array2.items)[b2];
/* 295 */         if (getWhitelist().isMethodWhiteListedInDeclaringClass(method)) {
/*     */ 
/*     */           
/* 298 */           a(clazz, "has whitelisted method: " + method); Parameter[] arrayOfParameter; int i;
/*     */           byte b;
/* 300 */           for (i = (arrayOfParameter = method.getParameters()).length, b = 0; b < i; ) { Parameter parameter = arrayOfParameter[b];
/* 301 */             if (this.allClassesSet.contains(parameter.getType()))
/* 302 */               a(parameter.getType(), "used as a parameter in method " + method); 
/*     */             b++; }
/*     */           
/* 305 */           if (this.allClassesSet.contains(method.getReturnType())) {
/* 306 */             a(method.getReturnType(), "return type of method " + method);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*     */     while (true) {
/* 313 */       boolean bool = false; Class[] arrayOfClass1, arrayOfClass2; int i;
/*     */       byte b;
/* 315 */       for (i = (arrayOfClass2 = arrayOfClass1 = (Class[])this.usedClasses.toArray((Class<?>[][])new Class[0])).length, b = 0; b < i; ) {
/*     */         Class<?> clazz1; Class<?> clazz2;
/* 317 */         if ((clazz2 = (clazz1 = arrayOfClass2[b]).getSuperclass()) != null && this.allClassesSet.contains(clazz2) && 
/* 318 */           a(clazz2, "super class of " + clazz1)) {
/* 319 */           bool = true;
/*     */         }
/*     */         b++;
/*     */       } 
/* 323 */       if (bool) {
/*     */         continue;
/*     */       }
/*     */       break;
/*     */     } 
/* 328 */     a.i("gatherUsedClasses done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   private boolean a(Class<?> paramClass, String paramString) {
/* 332 */     if (paramClass.isArray()) {
/* 333 */       return a(paramClass.getComponentType(), paramString);
/*     */     }
/* 335 */     if (!this.usedClasses.contains(paramClass)) {
/* 336 */       if (getWhitelist().isClassBlackListed(paramClass)) {
/* 337 */         a.w("Class is blacklisted but is marked as used\n    class: " + paramClass + "\n    reason: " + paramString, new Object[0]);
/* 338 */         return false;
/*     */       } 
/*     */       
/* 341 */       String[] arrayOfString = paramClass.getName().split("\\.");
/* 342 */       StringBuilder stringBuilder = new StringBuilder();
/* 343 */       for (byte b = 0; b < arrayOfString.length - 1; b++) {
/* 344 */         if (b != 0) {
/* 345 */           stringBuilder.append('.');
/*     */         }
/* 347 */         stringBuilder.append(arrayOfString[b]);
/*     */         
/* 349 */         if (getWhitelist().isPackageBlackListed(stringBuilder.toString())) {
/* 350 */           a.w("Package \"" + stringBuilder + "\" is blacklisted but its class is marked as used\n    class: " + paramClass + "\n    reason: " + paramString, new Object[0]);
/* 351 */           return false;
/*     */         } 
/*     */       } 
/* 354 */       if (verbose) {
/* 355 */         a.i("- marked as used: " + paramClass + ", reason: " + paramString, new Object[0]);
/*     */       }
/* 357 */       this.usedClasses.add(paramClass);
/* 358 */       return true;
/*     */     } 
/* 360 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isClassUsed(Class<?> paramClass) {
/* 365 */     return this.usedClasses.contains(paramClass);
/*     */   }
/*     */   
/*     */   public void generatePackageDefinitions() {
/* 369 */     long l = TimeUtils.millis();
/* 370 */     if (this.allClasses == null) {
/* 371 */       throw new IllegalStateException("allClasses is null - call gatherClasses() first");
/*     */     }
/*     */     
/* 374 */     this.handledPackageDefinitions = new HashSet<>();
/* 375 */     for (Array.ArrayIterator<Class<?>> arrayIterator = this.allClasses.iterator(); arrayIterator.hasNext(); ) { Class<?> clazz = arrayIterator.next();
/* 376 */       if (isClassUsed(clazz)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 381 */         String[] arrayOfString = clazz.getName().split("\\.");
/* 382 */         StringBuilder stringBuilder = new StringBuilder();
/* 383 */         for (byte b = 0; b < arrayOfString.length - 1; b++) {
/* 384 */           if (b != 0) {
/* 385 */             stringBuilder.append(".");
/*     */           }
/* 387 */           stringBuilder.append(arrayOfString[b]);
/* 388 */           String str = stringBuilder.toString();
/* 389 */           if (!this.handledPackageDefinitions.contains(str)) {
/*     */             StringBuilder stringBuilder1;
/*     */             
/* 392 */             (stringBuilder1 = new StringBuilder()).append("---@meta\n\n");
/* 393 */             stringBuilder1.append(str).append(" = {}\n");
/*     */             
/* 395 */             if (str.equals("java")) {
/*     */               
/* 397 */               stringBuilder1.append("-- These fields are only used for an easier access to Java's primitive types\n");
/* 398 */               stringBuilder1.append("-- They can not be used as a data type in docs - use Lua LS data types instead:\n");
/* 399 */               stringBuilder1.append("-- - boolean\n");
/* 400 */               stringBuilder1.append("-- - number\n");
/* 401 */               stringBuilder1.append("-- - integer\n");
/* 402 */               stringBuilder1.append("\n");
/* 403 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 404 */               stringBuilder1.append("java.int = nil\n");
/* 405 */               stringBuilder1.append("\n");
/* 406 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 407 */               stringBuilder1.append("java.byte = nil\n");
/* 408 */               stringBuilder1.append("\n");
/* 409 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 410 */               stringBuilder1.append("java.short = nil\n");
/* 411 */               stringBuilder1.append("\n");
/* 412 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 413 */               stringBuilder1.append("java.long = nil\n");
/* 414 */               stringBuilder1.append("\n");
/* 415 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 416 */               stringBuilder1.append("java.float = nil\n");
/* 417 */               stringBuilder1.append("\n");
/* 418 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 419 */               stringBuilder1.append("java.double = nil\n");
/* 420 */               stringBuilder1.append("\n");
/* 421 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 422 */               stringBuilder1.append("java.boolean = nil\n");
/* 423 */               stringBuilder1.append("\n");
/* 424 */               stringBuilder1.append("---@type java.lang.Class\n");
/* 425 */               stringBuilder1.append("java.char = nil\n");
/* 426 */               stringBuilder1.append("\n");
/*     */             } 
/* 428 */             LuaDefUtils.writeFile("scripts/.definitions/classes/" + str.replaceAll("\\.", "/") + "/package.lua", stringBuilder1.toString());
/*     */             
/* 430 */             this.handledPackageDefinitions.add(str);
/*     */           } 
/*     */         } 
/*     */       }  }
/* 434 */      a.i("generatePackageDefinitions done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public void generateFilesData() {
/* 438 */     long l = TimeUtils.millis();
/* 439 */     this.filesData = new Array();
/* 440 */     for (Array.ArrayIterator<Class<?>> arrayIterator = this.allClasses.iterator(); arrayIterator.hasNext(); ) { Class clazz = arrayIterator.next();
/* 441 */       if (!this.usedClasses.contains(clazz)) {
/* 442 */         if (verbose) {
/* 443 */           a.i("skip " + clazz + " - not used", new Object[0]);
/*     */         }
/*     */         
/*     */         continue;
/*     */       } 
/*     */       ClassDefData classDefData;
/* 449 */       (classDefData = new ClassDefData(this, clazz)).prepare();
/* 450 */       this.filesData.add(classDefData); }
/*     */     
/* 452 */     a.i("generateFilesData done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public void writeFilesDataToDisk() {
/* 456 */     long l = TimeUtils.millis();
/* 457 */     for (Array.ArrayIterator<ClassDefData> arrayIterator = this.filesData.iterator(); arrayIterator.hasNext(); ) { ClassDefData classDefData = arrayIterator.next();
/* 458 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 460 */       classDefData.printFileData(stringBuilder);
/*     */ 
/*     */ 
/*     */       
/* 464 */       LuaDefUtils.writeFile("scripts/.definitions/classes/" + classDefData.filePath + ".lua", stringBuilder.toString()); }
/*     */     
/* 466 */     a.i("writeFilesDataToDisk done in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeClassListsToDisk() {
/*     */     StringBuilder stringBuilder;
/* 472 */     (stringBuilder = new StringBuilder()).append("# Do not edit - auto-generated by Lua definitions generator\n");
/* 473 */     stringBuilder.append("# Used by the game to build a class tree (those global tables like 'com' and 'java')\n");
/* 474 */     for (Array.ArrayIterator<Class<?>> arrayIterator1 = this.allClasses.iterator(); arrayIterator1.hasNext(); ) { Class clazz = arrayIterator1.next();
/* 475 */       if (this.usedClasses.contains(clazz)) {
/* 476 */         stringBuilder.append(clazz.getName()).append("\n");
/*     */       } }
/*     */     
/* 479 */     LuaDefUtils.writeFile("res/luaj/class-list.txt", stringBuilder.toString());
/*     */ 
/*     */     
/* 482 */     HashMap<Object, Object> hashMap1 = new HashMap<>(); 
/* 483 */     try { FileReader fileReader = new FileReader("res/luaj/forced-class-aliases.txt"); 
/* 484 */       try { BufferedReader bufferedReader = new BufferedReader(fileReader);
/* 485 */         byte b = 1;
/*     */         
/*     */         String str;
/* 488 */         while ((str = bufferedReader.readLine()) != null) {
/*     */ 
/*     */ 
/*     */           
/* 492 */           if ((str = str.trim()).length() != 0)
/* 493 */             if (str.charAt(0) != '#')
/*     */             { String[] arrayOfString;
/* 495 */               if ((arrayOfString = str.split("=")).length != 2) {
/* 496 */                 throw new IllegalArgumentException("Invalid definition at line " + b + " in res/luaj/forced-class-aliases.txt");
/*     */               }
/* 498 */               Class<?> clazz = Class.forName(arrayOfString[1].trim());
/* 499 */               hashMap1.put(arrayOfString[0].trim(), clazz); }
/*     */             else { continue; }
/* 501 */               b++;
/*     */         } 
/* 503 */         fileReader.close(); } catch (Throwable throwable) { try { fileReader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception exception)
/* 504 */     { a.e("Failed to read res/luaj/forced-class-aliases.txt", new Object[] { exception }); }
/*     */ 
/*     */     
/* 507 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 508 */     for (Array.ArrayIterator<Class<?>> arrayIterator2 = this.allClasses.iterator(); arrayIterator2.hasNext(); ) { Class clazz = arrayIterator2.next();
/* 509 */       if (this.usedClasses.contains(clazz)) {
/* 510 */         String str = clazz.getSimpleName();
/*     */         Array array;
/* 512 */         if ((array = (Array)hashMap2.get(str)) == null) {
/*     */           
/* 514 */           (array = new Array(true, 1, Class.class)).add(clazz);
/* 515 */           hashMap2.put(str, array); continue;
/*     */         } 
/* 517 */         array.add(clazz);
/*     */       }  }
/*     */ 
/*     */ 
/*     */     
/* 522 */     Array array1 = new Array(true, 1, Class.class);
/* 523 */     Array array2 = new Array();
/* 524 */     for (Iterator<Map.Entry> iterator = hashMap2.entrySet().iterator(); iterator.hasNext(); ) {
/* 525 */       Map.Entry entry; if (((Array)(entry = iterator.next()).getValue()).size == 1) {
/*     */         
/* 527 */         array1.add(((Array)entry.getValue()).first()); continue;
/*     */       } 
/*     */       Class clazz;
/* 530 */       if ((clazz = (Class)hashMap1.get(entry.getKey())) != null)
/*     */       {
/* 532 */         for (byte b = 0; b < ((Array)entry.getValue()).size; b++) {
/* 533 */           Class clazz1 = (Class)((Array)entry.getValue()).get(b);
/* 534 */           if (clazz == clazz1) {
/* 535 */             ((Array)entry.getValue()).removeIndex(b);
/* 536 */             array1.add(clazz1);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 541 */       array2.add(entry.getValue());
/*     */     } 
/*     */     
/* 544 */     array1.sort((paramClass1, paramClass2) -> paramClass1.getSimpleName().compareTo(paramClass2.getSimpleName()));
/*     */     
/* 546 */     stringBuilder.setLength(0);
/* 547 */     stringBuilder.append("--- @meta\n");
/* 548 */     stringBuilder.append("\n");
/* 549 */     stringBuilder.append("--- Auto-generated list of aliases for classes with a unique name for your convenience.\n");
/* 550 */     stringBuilder.append("--- Lua LS by sumneko seems to be picking @alias from all files in the workspace so it is not possible to define aliases per-file, that's why this list exists.\n");
/* 551 */     stringBuilder.append("--- Note: aliases may change / disappear in the later versions of the game if some new class gets introduced with the same name of any of the aliased classes.\n");
/* 552 */     stringBuilder.append("\n");
/* 553 */     for (byte b2 = 0; b2 < array1.size; b2++) {
/* 554 */       Class clazz = (Class)array1.get(b2);
/* 555 */       stringBuilder.append("--- @alias ").append(clazz.getSimpleName()).append(" ").append(clazz.getName().replaceAll("\\$", "_")).append("\n");
/*     */     } 
/*     */ 
/*     */     
/* 559 */     stringBuilder.append("\n");
/* 560 */     stringBuilder.append("-- Classes with the same name which has not received an alias:\n");
/* 561 */     array2.sort((paramArray1, paramArray2) -> ((Class)paramArray1.first()).getSimpleName().compareTo(((Class)paramArray2.first()).getSimpleName()));
/* 562 */     for (Array.ArrayIterator<Array> arrayIterator = array2.iterator(); arrayIterator.hasNext(); ) { Array array = arrayIterator.next();
/* 563 */       stringBuilder.append("\n");
/* 564 */       stringBuilder.append("-- ").append(((Class)array.first()).getSimpleName()).append(" (").append(array.size).append(" usages):\n");
/* 565 */       for (Array.ArrayIterator<Class<?>> arrayIterator3 = array.iterator(); arrayIterator3.hasNext(); ) { Class clazz = arrayIterator3.next();
/* 566 */         stringBuilder.append("-- - ").append(clazz.getName().replaceAll("\\$", "_")).append(":\n"); }
/*     */        }
/*     */ 
/*     */     
/* 570 */     LuaDefUtils.writeFile("scripts/.definitions/class-aliases.lua", stringBuilder.toString());
/*     */ 
/*     */     
/* 573 */     stringBuilder.setLength(0);
/* 574 */     stringBuilder.append("--- @meta\n\n");
/* 575 */     stringBuilder.append("--- Represents the global C table (_G.C or simply C) which contains references to all classes with a unique name,\n");
/* 576 */     stringBuilder.append("--- just like class-aliases.lua does for types.\n");
/* 577 */     stringBuilder.append("--- So for example Table class can be accessed like `com.prineside.tdi2.Tower.class` or simply `C.Tower`, resulting in\n");
/* 578 */     stringBuilder.append("--- nothing but your convenience and a shorter code.\n");
/* 579 */     stringBuilder.append("--- The game will generate this table automatically from the `res/luaj/class-list.txt`.\n");
/* 580 */     stringBuilder.append("--- Important: if you are developing scripts with a custom Lua definition rules (meaning you've run Lua def generator)\n");
/* 581 */     stringBuilder.append("--- and use global C table, it may differ from the same table on a vanilla game. You can still access classes through\n");
/* 582 */     stringBuilder.append("--- their full namespace tables to be sure you are pointing on the class you actually need.\n");
/* 583 */     stringBuilder.append("\n");
/* 584 */     stringBuilder.append("local tdi = com.prineside.tdi2\n");
/* 585 */     stringBuilder.append("local gdx = com.badlogic.gdx\n");
/* 586 */     stringBuilder.append("\n");
/* 587 */     stringBuilder.append("_G.C = {\n");
/* 588 */     for (byte b1 = 0; b1 < array1.size; b1++) {
/* 589 */       Class clazz = (Class)array1.get(b1);
/* 590 */       stringBuilder.append("    ").append(clazz.getSimpleName()).append(" = ");
/*     */       String str;
/* 592 */       if ((str = clazz.getName().replaceAll("\\$", "_")).startsWith("com.prineside.tdi2.")) {
/* 593 */         str = "tdi." + str.substring(19);
/* 594 */       } else if (str.startsWith("com.badlogic.gdx.")) {
/* 595 */         str = "gdx." + str.substring(17);
/*     */       } 
/* 597 */       stringBuilder.append(str).append(".class,\n");
/*     */     } 
/* 599 */     stringBuilder.append("}\n");
/* 600 */     LuaDefUtils.writeFile("scripts/.definitions/global-c.lua", stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public void runEverything() {
/* 604 */     loadKryoRegistry();
/* 605 */     loadWhitelist();
/* 606 */     gatherClasses();
/* 607 */     deleteDefinitionFiles();
/* 608 */     gatherUsedClasses();
/* 609 */     prepareJavadocs();
/* 610 */     generatePackageDefinitions();
/* 611 */     generateFilesData();
/* 612 */     writeFilesDataToDisk();
/* 613 */     writeClassListsToDisk();
/*     */     
/* 615 */     a.i("all done", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public String getLuaClassName(Class<?> paramClass, boolean paramBoolean) {
/* 622 */     return a(paramClass, 0, paramBoolean);
/*     */   }
/*     */   @Null
/*     */   private String a(Class<?> paramClass, int paramInt, boolean paramBoolean) {
/* 626 */     if (paramClass.isArray()) {
/* 627 */       return a(paramClass.getComponentType(), paramInt + 1, paramBoolean);
/*     */     }
/* 629 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     String str;
/* 631 */     if ((str = (String)(paramBoolean ? LuaDefUtils.DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.get(paramClass) : LuaDefUtils.DEFAULT_LUA_CLASS_NAMES.get(paramClass))) == null)
/*     */     {
/* 633 */       if (this.usedClasses.contains(paramClass)) {
/* 634 */         str = paramClass.getName().replace("$", "_");
/*     */       } else {
/* 636 */         return null;
/*     */       } 
/*     */     }
/* 639 */     stringBuilder.append(str);
/* 640 */     for (byte b = 0; b < paramInt; b++) {
/* 641 */       stringBuilder.append("[]");
/*     */     }
/* 643 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\LuaDefinitionsGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */