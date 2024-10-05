/*     */ package com.prineside.tdi2.managers.script;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
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
/*     */ public final class Whitelist
/*     */ {
/*  32 */   private static final TLog a = TLog.forClass(Whitelist.class);
/*     */   
/*  34 */   private final EPackage b = new EPackage("", null, (byte)0);
/*     */   
/*     */   public static Whitelist fromFile(File paramFile) {
/*  37 */     FileReader fileReader = new FileReader(paramFile); 
/*  38 */     try { Whitelist whitelist = fromFile(new BufferedReader(fileReader));
/*  39 */       fileReader.close(); return whitelist; }
/*     */     catch (Throwable throwable) { try { fileReader.close(); }
/*     */       catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*     */        throw throwable; }
/*  43 */      } public static Whitelist fromFile(FileHandle paramFileHandle) { return fromFile(new BufferedReader(paramFileHandle.reader("UTF-8"))); }
/*     */ 
/*     */   
/*     */   public static Whitelist fromFile(BufferedReader paramBufferedReader) {
/*     */     Whitelist whitelist;
/*  48 */     EPackage ePackage = (whitelist = new Whitelist()).b;
/*     */     
/*  50 */     byte b = 1;
/*     */     
/*     */     String str;
/*  53 */     while ((str = paramBufferedReader.readLine()) != null) {
/*     */       EClass eClass1; TreeEntry treeEntry; EClass eClass2;
/*     */       EPackage ePackage1;
/*     */       EClass eClass3;
/*     */       String str1;
/*  58 */       switch (str1 = (str = str.trim()).substring(0, Math.min(3, str.length()))) {
/*     */         
/*     */         case ">p:":
/*  61 */           str = str.substring(3, str.length() - 1);
/*  62 */           if (!(ePackage instanceof EPackage)) {
/*  63 */             throw new IllegalArgumentException("Can not add package '" + str + "' to non-package " + ePackage + " at line " + b);
/*     */           }
/*     */           
/*  66 */           ePackage1 = new EPackage(str, ePackage, (byte)0);
/*  67 */           ePackage.addEntry(ePackage1);
/*  68 */           ePackage = ePackage1;
/*     */           break;
/*     */ 
/*     */         
/*     */         case "-p:":
/*  73 */           str = str.substring(3);
/*  74 */           if (!(ePackage instanceof EPackage)) {
/*  75 */             throw new IllegalArgumentException("Can not exclude package '" + str + "' from non-package " + ePackage + " at line " + b);
/*     */           }
/*  77 */           ePackage1 = new EPackage(str, ePackage, (byte)0);
/*  78 */           ePackage.addEntry(ePackage1);
/*  79 */           ePackage1.setBlacklisted();
/*     */           break;
/*     */ 
/*     */         
/*     */         case ">c:":
/*  84 */           str = str.substring(3, str.length() - 1);
/*  85 */           eClass3 = new EClass(str, ePackage, (byte)0);
/*  86 */           ePackage.addEntry(eClass3);
/*  87 */           eClass1 = eClass3;
/*     */           break;
/*     */ 
/*     */         
/*     */         case "-c:":
/*  92 */           str = str.substring(3);
/*  93 */           eClass3 = new EClass(str, eClass1, (byte)0);
/*  94 */           eClass1.addEntry(eClass3);
/*  95 */           eClass3.setBlacklisted();
/*     */           break;
/*     */         
/*     */         case "+f:":
/*  99 */           str = str.substring(3);
/* 100 */           if (!(eClass1 instanceof EClass)) {
/* 101 */             throw new IllegalArgumentException("Can not add field '" + str + "' to non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 104 */           (eClass3 = eClass1).whitelistField(str);
/*     */           break;
/*     */         
/*     */         case "-f:":
/* 108 */           str = str.substring(3);
/* 109 */           if (!(eClass1 instanceof EClass)) {
/* 110 */             throw new IllegalArgumentException("Can not exclude field '" + str + "' from non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 113 */           (eClass3 = eClass1).blacklistField(str);
/*     */           break;
/*     */         
/*     */         case "+m:":
/* 117 */           str = str.substring(3);
/* 118 */           if (!(eClass1 instanceof EClass)) {
/* 119 */             throw new IllegalArgumentException("Can not add method '" + str + "' to non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 122 */           (eClass3 = eClass1).whitelistMethod(str);
/*     */           break;
/*     */         
/*     */         case "-m:":
/* 126 */           str = str.substring(3);
/* 127 */           if (!(eClass1 instanceof EClass)) {
/* 128 */             throw new IllegalArgumentException("Can not exclude method '" + str + "' from non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 131 */           (eClass3 = eClass1).blacklistMethod(str);
/*     */           break;
/*     */         
/*     */         case "+x:":
/* 135 */           str = str.substring(3);
/* 136 */           if (!(eClass1 instanceof EClass)) {
/* 137 */             throw new IllegalArgumentException("Can not add constructor '" + str + "' to non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 140 */           (eClass3 = eClass1).whitelistConstructor(str);
/*     */           break;
/*     */         
/*     */         case "-x:":
/* 144 */           str = str.substring(3);
/* 145 */           if (!(eClass1 instanceof EClass)) {
/* 146 */             throw new IllegalArgumentException("Can not exclude constructor '" + str + "' from non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 149 */           (eClass3 = eClass1).blacklistConstructor(str);
/*     */           break;
/*     */         
/*     */         case "+z":
/* 153 */           if (!(eClass1 instanceof EClass)) {
/* 154 */             throw new IllegalArgumentException("Can not add proxy for non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 157 */           (eClass2 = eClass1).setInterfaceProxyState(1);
/*     */           break;
/*     */         
/*     */         case "-z":
/* 161 */           if (!(eClass1 instanceof EClass)) {
/* 162 */             throw new IllegalArgumentException("Can not exclude proxy for non-class " + eClass1 + " at line " + b);
/*     */           }
/*     */           
/* 165 */           (eClass2 = eClass1).setInterfaceProxyState(2);
/*     */           break;
/*     */ 
/*     */         
/*     */         case "}":
/* 170 */           treeEntry = TreeEntry.a(eClass1);
/*     */           break;
/*     */         
/*     */         default:
/* 174 */           a.i("unrecognized prefix \"" + eClass3 + "\" on line " + b, new Object[0]);
/*     */           break;
/*     */       } 
/* 177 */       b++;
/*     */     } 
/*     */     
/* 180 */     return whitelist;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   private TreeEntry a(Class<?> paramClass) {
/* 186 */     String[] arrayOfString = paramClass.getName().split("[.$]+");
/* 187 */     TreeEntry treeEntry = this.b; int i; byte b;
/* 188 */     for (i = (arrayOfString = arrayOfString).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*     */       
/* 190 */       if ((treeEntry = treeEntry.findChild(str)) == null) {
/* 191 */         return null;
/*     */       }
/*     */       b++; }
/*     */     
/* 195 */     return treeEntry;
/*     */   }
/*     */   @Null
/*     */   private EClass b(Class<?> paramClass) {
/*     */     TreeEntry treeEntry;
/* 200 */     if ((treeEntry = a(paramClass)) == null) {
/* 201 */       return null;
/*     */     }
/* 203 */     if (!(treeEntry instanceof EClass)) {
/* 204 */       return null;
/*     */     }
/*     */     
/* 207 */     return (EClass)treeEntry;
/*     */   }
/*     */   
/* 210 */   private static final StringBuilder c = new StringBuilder();
/*     */   public static synchronized String getMethodSignature(Method paramMethod) {
/* 212 */     c.setLength(0);
/* 213 */     c.append(paramMethod.getName()).append(':');
/* 214 */     byte b1 = 0; Class[] arrayOfClass; int i; byte b2;
/* 215 */     for (i = (arrayOfClass = paramMethod.getParameterTypes()).length, b2 = 0; b2 < i; ) { Class clazz = arrayOfClass[b2];
/* 216 */       if (b1) {
/* 217 */         c.append(',');
/*     */       }
/* 219 */       c.append(clazz.getSimpleName());
/* 220 */       b1++;
/*     */       b2++; }
/*     */     
/* 223 */     return c.toString();
/*     */   }
/*     */   
/* 226 */   private static final StringBuilder d = new StringBuilder();
/*     */   public static synchronized String getConstructorSignature(Constructor<?> paramConstructor) {
/* 228 */     d.setLength(0);
/* 229 */     byte b1 = 0; Class[] arrayOfClass; int i; byte b2;
/* 230 */     for (i = (arrayOfClass = paramConstructor.getParameterTypes()).length, b2 = 0; b2 < i; ) { Class clazz = arrayOfClass[b2];
/* 231 */       if (b1) {
/* 232 */         d.append(',');
/*     */       }
/* 234 */       d.append(clazz.getSimpleName());
/* 235 */       b1++; b2++; }
/*     */     
/* 237 */     return d.toString();
/*     */   }
/*     */   
/*     */   public final boolean isFieldWhiteListed(Field paramField) {
/*     */     EClass eClass;
/* 242 */     if ((eClass = b(paramField.getDeclaringClass())) == null) {
/* 243 */       return false;
/*     */     }
/*     */     
/* 246 */     return eClass.isFieldWhitelisted(paramField.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(String paramString, Class<?> paramClass) {
/*     */     EClass eClass;
/* 255 */     if ((eClass = b(paramClass)) != null && eClass.isMethodWhitelisted(paramString))
/* 256 */       return true; 
/*     */     Class[] arrayOfClass;
/*     */     int i;
/*     */     byte b;
/* 260 */     for (i = (arrayOfClass = paramClass.getInterfaces()).length, b = 0; b < i; ) { Class<?> clazz = arrayOfClass[b];
/* 261 */       if (a(paramString, clazz)) {
/* 262 */         return true;
/*     */       }
/*     */       b++; }
/*     */     
/* 266 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isMethodWhiteListed(Method paramMethod) {
/* 273 */     String str = getMethodSignature(paramMethod);
/*     */     
/*     */     EClass eClass;
/* 276 */     if ((eClass = b(paramMethod.getDeclaringClass())) != null && eClass.isMethodWhitelisted(str))
/* 277 */       return true; 
/*     */     Class[] arrayOfClass;
/*     */     int i;
/*     */     byte b;
/* 281 */     for (i = (arrayOfClass = paramMethod.getDeclaringClass().getInterfaces()).length, b = 0; b < i; ) { Class<?> clazz = arrayOfClass[b];
/* 282 */       if (a(str, clazz))
/*     */       {
/* 284 */         return true;
/*     */       }
/*     */       b++; }
/*     */     
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isMethodWhiteListedInDeclaringClass(Method paramMethod) {
/*     */     EClass eClass;
/* 296 */     if ((eClass = b(paramMethod.getDeclaringClass())) == null) {
/* 297 */       return false;
/*     */     }
/*     */     
/* 300 */     return eClass.isMethodWhitelisted(getMethodSignature(paramMethod));
/*     */   }
/*     */   
/*     */   public final boolean isConstructorWhiteListed(Constructor<?> paramConstructor) {
/*     */     EClass eClass;
/* 305 */     if ((eClass = b(paramConstructor.getDeclaringClass())) == null) {
/* 306 */       return false;
/*     */     }
/*     */     
/* 309 */     return eClass.isConstructorWhitelisted(getConstructorSignature(paramConstructor));
/*     */   }
/*     */   
/*     */   public final boolean isInterfaceProxyWhiteListed(Class<?> paramClass) {
/*     */     EClass eClass;
/* 314 */     if ((eClass = b(paramClass)) == null) {
/* 315 */       return false;
/*     */     }
/*     */     
/* 318 */     return (EClass.a(eClass) == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isPackageBlackListed(String paramString) {
/* 324 */     String[] arrayOfString = paramString.split("\\.");
/* 325 */     TreeEntry treeEntry = this.b; int i; byte b;
/* 326 */     for (i = (arrayOfString = arrayOfString).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*     */       
/* 328 */       if ((treeEntry = treeEntry.findChild(str)) == null)
/* 329 */         return false; 
/*     */       b++; }
/*     */     
/* 332 */     if (!(treeEntry instanceof EPackage)) {
/* 333 */       return false;
/*     */     }
/*     */     
/*     */     EPackage ePackage;
/* 337 */     return (ePackage = (EPackage)treeEntry).isBlacklisted();
/*     */   }
/*     */   
/*     */   public final boolean isClassBlackListed(Class<?> paramClass) {
/*     */     EClass eClass;
/* 342 */     if ((eClass = b(paramClass)) == null) {
/* 343 */       return false;
/*     */     }
/* 345 */     return eClass.isBlacklisted();
/*     */   }
/*     */   
/*     */   public final boolean isFieldBlackListed(Field paramField) {
/*     */     EClass eClass;
/* 350 */     if ((eClass = b(paramField.getDeclaringClass())) == null) {
/* 351 */       return false;
/*     */     }
/* 353 */     return eClass.isFieldBlacklisted(paramField.getName());
/*     */   }
/*     */   
/*     */   public final boolean isMethodBlackListed(Method paramMethod) {
/*     */     EClass eClass;
/* 358 */     if ((eClass = b(paramMethod.getDeclaringClass())) == null) {
/* 359 */       return false;
/*     */     }
/* 361 */     return eClass.isMethodBlacklisted(getMethodSignature(paramMethod));
/*     */   }
/*     */   
/*     */   public final boolean isConstructorBlackListed(Constructor<?> paramConstructor) {
/*     */     EClass eClass;
/* 366 */     if ((eClass = b(paramConstructor.getDeclaringClass())) == null) {
/* 367 */       return false;
/*     */     }
/* 369 */     return eClass.isConstructorBlacklisted(getConstructorSignature(paramConstructor));
/*     */   }
/*     */   
/*     */   public final boolean isInterfaceProxyBlackListed(Class<?> paramClass) {
/*     */     EClass eClass;
/* 374 */     if ((eClass = b(paramClass)) == null) {
/* 375 */       return false;
/*     */     }
/*     */     
/* 378 */     return (EClass.a(eClass) == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class TreeEntry
/*     */   {
/*     */     private final String a;
/*     */     @Null
/*     */     private final TreeEntry b;
/*     */     private Array<TreeEntry> c;
/*     */     private boolean d;
/*     */     
/*     */     public TreeEntry(String param1String, TreeEntry param1TreeEntry) {
/* 391 */       this.a = param1String;
/* 392 */       this.b = param1TreeEntry;
/*     */     }
/*     */     
/*     */     public void addEntry(TreeEntry param1TreeEntry) {
/* 396 */       if (this.c == null) {
/* 397 */         this.c = new Array(true, 1, TreeEntry.class);
/*     */       }
/* 399 */       this.c.add(param1TreeEntry);
/*     */     }
/*     */     @Null
/*     */     public TreeEntry findChild(String param1String) {
/* 403 */       if (this.c == null) {
/* 404 */         return null;
/*     */       }
/* 406 */       for (byte b = 0; b < this.c.size; b++) {
/* 407 */         if ((((TreeEntry[])this.c.items)[b]).a.equals(param1String)) {
/* 408 */           return ((TreeEntry[])this.c.items)[b];
/*     */         }
/*     */       } 
/* 411 */       return null;
/*     */     }
/*     */     
/*     */     public TreeEntry getParent() {
/* 415 */       return this.b;
/*     */     }
/*     */     
/*     */     public boolean isBlacklisted() {
/* 419 */       return this.d;
/*     */     }
/*     */     
/*     */     public void setBlacklisted() {
/* 423 */       this.d = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class EPackage extends TreeEntry {
/*     */     private final String a;
/*     */     
/*     */     private EPackage(String param1String, Whitelist.TreeEntry param1TreeEntry) {
/* 431 */       super(param1String, param1TreeEntry);
/* 432 */       this.a = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 437 */       return "EPackage (" + this.a + ")";
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class EClass
/*     */     extends TreeEntry {
/*     */     public static final int INTERFACE_PROXY_STATE_NOT_SET = 0;
/*     */     public static final int INTERFACE_PROXY_STATE_WHITELISTED = 1;
/*     */     public static final int INTERFACE_PROXY_STATE_BLACKLISTED = 2;
/*     */     private final String a;
/*     */     private Array<String> b;
/*     */     private Array<String> c;
/*     */     private Array<String> d;
/*     */     private Array<String> e;
/* 451 */     private int f = 0;
/*     */     
/*     */     private EClass(String param1String, Whitelist.TreeEntry param1TreeEntry) {
/* 454 */       super(param1String, param1TreeEntry);
/* 455 */       this.a = param1String;
/*     */     }
/*     */     
/*     */     public final int getInterfaceProxyState() {
/* 459 */       return this.f;
/*     */     }
/*     */     
/*     */     public final void setInterfaceProxyState(int param1Int) {
/* 463 */       this.f = param1Int;
/*     */     }
/*     */     
/*     */     public final void whitelistField(String param1String) {
/* 467 */       if (this.b == null) {
/* 468 */         this.b = new Array();
/*     */       }
/* 470 */       this.b.add(param1String);
/*     */     }
/*     */     
/*     */     public final boolean isFieldWhitelisted(String param1String) {
/* 474 */       return (this.b != null && this.b.contains(param1String, false));
/*     */     }
/*     */     
/*     */     public final boolean isFieldBlacklisted(String param1String) {
/* 478 */       return (this.e != null && this.e.contains("f:" + param1String, false));
/*     */     }
/*     */     
/*     */     public final void blacklistEntry(String param1String) {
/* 482 */       if (this.e == null) {
/* 483 */         this.e = new Array();
/*     */       }
/* 485 */       this.e.add(param1String);
/*     */     }
/*     */     
/*     */     public final void blacklistField(String param1String) {
/* 489 */       blacklistEntry("f:" + param1String);
/*     */     }
/*     */     
/*     */     public final void whitelistMethod(String param1String) {
/* 493 */       if (this.c == null) {
/* 494 */         this.c = new Array();
/*     */       }
/* 496 */       this.c.add(param1String);
/*     */     }
/*     */     
/*     */     public final boolean isMethodWhitelisted(String param1String) {
/* 500 */       return (this.c != null && this.c.contains(param1String, false));
/*     */     }
/*     */     
/*     */     public final boolean isMethodBlacklisted(String param1String) {
/* 504 */       return (this.e != null && this.e.contains("m:" + param1String, false));
/*     */     }
/*     */     
/*     */     public final void blacklistMethod(String param1String) {
/* 508 */       blacklistEntry("m:" + param1String);
/*     */     }
/*     */     
/*     */     public final void whitelistConstructor(String param1String) {
/* 512 */       if (this.d == null) {
/* 513 */         this.d = new Array();
/*     */       }
/* 515 */       this.d.add(param1String);
/*     */     }
/*     */     
/*     */     public final boolean isConstructorWhitelisted(String param1String) {
/* 519 */       return (this.d != null && this.d.contains(param1String, false));
/*     */     }
/*     */     
/*     */     public final boolean isConstructorBlacklisted(String param1String) {
/* 523 */       return (this.e != null && this.e.contains("c:" + param1String, false));
/*     */     }
/*     */     
/*     */     public final void blacklistConstructor(String param1String) {
/* 527 */       blacklistEntry("c:" + param1String);
/*     */     }
/*     */     
/*     */     public final boolean isLocalClass() {
/* 531 */       return getParent() instanceof EClass;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 536 */       return "EClass (" + (isLocalClass() ? "local " : "") + this.a + ")";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\Whitelist.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */